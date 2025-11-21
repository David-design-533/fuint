package com.fuint.module.backendApi.controller;

import com.fuint.framework.web.BaseController;
import com.fuint.framework.web.ResponseObject;
import com.fuint.utils.ArithmeticCalculator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 算术计算器controller
 * 
 * 提供简单的算术计算功能
 */
@Api(tags="管理端-算术计算器接口")
@RestController
@RequestMapping(value = "/backendApi/calculator")
public class BackendCalculatorController extends BaseController {

    /**
     * 计算算术表达式
     */
    @ApiOperation(value = "计算算术表达式")
    @PostMapping("/calculate")
    public ResponseObject calculate(
            @ApiParam(value = "表达式", required = true)
            @RequestParam("expression") String expression) {
        try {
            double result = ArithmeticCalculator.calculate(expression);
            
            Map<String, Object> data = new HashMap<>();
            data.put("expression", expression);
            data.put("result", result);
            
            return getSuccessResult(data);
        } catch (Exception e) {
            return getFailureResult(1001, e.getMessage());
        }
    }

    /**
     * 加法运算
     */
    @ApiOperation(value = "加法运算")
    @PostMapping("/add")
    public ResponseObject add(
            @ApiParam(value = "第一个数", required = true)
            @RequestParam("a") double a,
            @ApiParam(value = "第二个数", required = true)
            @RequestParam("b") double b) {
        try {
            double result = ArithmeticCalculator.add(a, b);
            
            Map<String, Object> data = new HashMap<>();
            data.put("a", a);
            data.put("b", b);
            data.put("result", result);
            data.put("operation", "加法(+)");
            
            return getSuccessResult(data);
        } catch (Exception e) {
            return getFailureResult(1001, e.getMessage());
        }
    }

    /**
     * 减法运算
     */
    @ApiOperation(value = "减法运算")
    @PostMapping("/subtract")
    public ResponseObject subtract(
            @ApiParam(value = "第一个数", required = true)
            @RequestParam("a") double a,
            @ApiParam(value = "第二个数", required = true)
            @RequestParam("b") double b) {
        try {
            double result = ArithmeticCalculator.subtract(a, b);
            
            Map<String, Object> data = new HashMap<>();
            data.put("a", a);
            data.put("b", b);
            data.put("result", result);
            data.put("operation", "减法(-)");
            
            return getSuccessResult(data);
        } catch (Exception e) {
            return getFailureResult(1001, e.getMessage());
        }
    }

    /**
     * 乘法运算
     */
    @ApiOperation(value = "乘法运算")
    @PostMapping("/multiply")
    public ResponseObject multiply(
            @ApiParam(value = "第一个数", required = true)
            @RequestParam("a") double a,
            @ApiParam(value = "第二个数", required = true)
            @RequestParam("b") double b) {
        try {
            double result = ArithmeticCalculator.multiply(a, b);
            
            Map<String, Object> data = new HashMap<>();
            data.put("a", a);
            data.put("b", b);
            data.put("result", result);
            data.put("operation", "乘法(*)");
            
            return getSuccessResult(data);
        } catch (Exception e) {
            return getFailureResult(1001, e.getMessage());
        }
    }

    /**
     * 除法运算
     */
    @ApiOperation(value = "除法运算")
    @PostMapping("/divide")
    public ResponseObject divide(
            @ApiParam(value = "被除数", required = true)
            @RequestParam("a") double a,
            @ApiParam(value = "除数", required = true)
            @RequestParam("b") double b) {
        try {
            double result = ArithmeticCalculator.divide(a, b);
            
            Map<String, Object> data = new HashMap<>();
            data.put("a", a);
            data.put("b", b);
            data.put("result", result);
            data.put("operation", "除法(/)");
            
            return getSuccessResult(data);
        } catch (Exception e) {
            return getFailureResult(1001, e.getMessage());
        }
    }
}
