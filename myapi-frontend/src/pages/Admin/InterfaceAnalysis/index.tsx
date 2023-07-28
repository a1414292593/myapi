import {
  PageContainer,
} from '@ant-design/pro-components';
import '@umijs/max';
import React, {useEffect, useState} from 'react';
import EChartsReact from "echarts-for-react";
import {listTopInvokeInterfaceInfoUsingGET} from "@/services/myapi-backend/analysisController";
import {c} from "@umijs/utils/compiled/tar";
const InterfaceAnalysis: React.FC = () => {

  const [data, setData] = useState<API.InterfaceInfoVo[]>([]);

  const [loading, setLoading] = useState(true);

  useEffect(() => {
    try {
      listTopInvokeInterfaceInfoUsingGET().then(r => {
        if (r.data) {
          setData(r.data)
        }
      })
    } catch (e: any) {

    }
  }, [])

  const chartData = data.map(item => {
    return {
      value: item.totalNum,
      name: item.username
    }
  })

  /**
   * 接口分析
   */
  const option = {
    title: {
      text: '调用次数最多的接口TOP3',
      left: 'center'
    },
    tooltip: {
      trigger: 'item'
    },
    legend: {
      orient: 'vertical',
      left: 'left'
    },
    series: [
      {
        name: 'Access From',
        type: 'pie',
        radius: '50%',
        data: chartData,
        emphasis: {
          itemStyle: {
            shadowBlur: 10,
            shadowOffsetX: 0,
            shadowColor: 'rgba(0, 0, 0, 0.5)'
          }
        }
      }
    ]
  };

  return (
    <PageContainer>
      <EChartsReact loadingOption={{
        showLoading: loading
      }} option={option}/>
    </PageContainer>
  );
};
export default InterfaceAnalysis;
