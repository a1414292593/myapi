package com.myapi.project.common;

import lombok.Data;

import java.awt.*;
import java.io.Serializable;

/**
 * id请求
 */
@Data
public class IdRequest implements Serializable {

    /**
     * id
     */
    private Long id;

}
