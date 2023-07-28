import { PageContainer } from '@ant-design/pro-components';
import React, {useEffect, useState} from 'react';
import {Button, Card, Descriptions, Divider, Form, message, Spin} from "antd";
import {
  getInterfaceInfoByIdUsingGET, invokeInterfaceInfoUsingPOST
} from "@/services/myapi-backend/interfaceInfoController";
import {useMatch, useParams} from "@@/exports";
import TextArea from "antd/es/input/TextArea";


/**
 * 主页
 * @constructor
 */
const Index: React.FC = () => {
  const [loading, setLoading] = useState(false);
  const [invokeLoading, setInvokeLoading] = useState(false);
  const [data, setData] = useState<API.InterfaceInfo>();
  const [invokeRes, setInvokeRes] = useState<any>();
  const params= useParams()

  const loadData = async () => {
    if (!params.id) {
      message.error('参数不存在');
      return;
    }
    setLoading(true)
    try {
      const res = await getInterfaceInfoByIdUsingGET({
        id: Number(params.id),
      });
      setData(res.data);
    } catch (e: any) {
      message.error('请求失败, ' + e.message);
    }
    setLoading(false)
  }

  useEffect(() => {
    loadData();
  }, [])

  const onFinish = async (values: any) => {
      if (!params.id) {
        message.error('接口不存在');
        return;
      }
      setInvokeLoading(true)
      try {
        const res = await invokeInterfaceInfoUsingPOST({
          id: params.id,
          ...values
        })
        setInvokeRes(res.data)
        message.success('请求成功')
      } catch (e: any) {
        message.error('操作失败, ' + e.message)
      }
      setInvokeLoading(false)
  }

  return (
    <PageContainer title="查看接口文档">
      <Card>
        {
          data ? (
            <Descriptions title={data?.username} column={1} extra={<Button>调用</Button>}>
              <Descriptions.Item label="接口状态">{data.status ? '开启' : '关闭'}</Descriptions.Item>
              <Descriptions.Item label="描述">{data.description}</Descriptions.Item>
              <Descriptions.Item label="请求地址">{data.url}</Descriptions.Item>
              <Descriptions.Item label="请求方法">{data.method}</Descriptions.Item>
              <Descriptions.Item label="请求参数">{data.requestParams}</Descriptions.Item>
              <Descriptions.Item label="请求头">{data.requestHeader}</Descriptions.Item>
              <Descriptions.Item label="响应头">{data.responseHeader}</Descriptions.Item>
              <Descriptions.Item label="创建时间">{data.createTime}</Descriptions.Item>
              <Descriptions.Item label="更新时间">{data.updateTime}</Descriptions.Item>
            </Descriptions> ) : ( <>接口不存在</> )
        }
      </Card>
      <Divider/>
      <Card title="在线测试">
        <Form
          name="invoke"
          layout="vertical"
          onFinish={onFinish}>
          <Form.Item
            label="请求参数"
            name="userRequestParams">
            <TextArea/>
          </Form.Item>
          <Form.Item wrapperCol={{ span: 16 }}>
            <Button type="primary" htmlType="submit">
              调用
            </Button>
          </Form.Item>
        </Form>
      </Card>
      <Divider/>
      <Card title="测试结果" loading={invokeLoading}>
        {invokeRes}
      </Card>
    </PageContainer>
  );
};

export default Index;
