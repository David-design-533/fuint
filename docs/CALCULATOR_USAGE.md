# 算术计算器使用说明

## 简介

本系统新增了一个简单的算术计算器工具，支持基本的四则运算（加、减、乘、除）以及复杂的算术表达式计算。

## 功能特性

- 支持基本算术运算：加法(+)、减法(-)、乘法(*)、除法(/)
- 支持运算符优先级（乘除优先于加减）
- 支持括号改变运算顺序
- 支持小数运算
- 支持负数
- 完善的错误处理（除零异常、非法表达式等）

## 使用方式

### 1. Java代码中使用

```java
import com.fuint.utils.ArithmeticCalculator;

// 计算表达式
double result = ArithmeticCalculator.calculate("1 + 2 * 3");  // 结果: 7.0
double result2 = ArithmeticCalculator.calculate("(1 + 2) * 3");  // 结果: 9.0

// 使用独立方法
double sum = ArithmeticCalculator.add(5, 3);        // 结果: 8.0
double diff = ArithmeticCalculator.subtract(5, 3);  // 结果: 2.0
double product = ArithmeticCalculator.multiply(5, 3); // 结果: 15.0
double quotient = ArithmeticCalculator.divide(6, 3);  // 结果: 2.0
```

### 2. REST API接口调用

#### 计算表达式

**请求地址：** `POST /backendApi/calculator/calculate`

**请求参数：**
- `expression` (必填): 算术表达式，例如 "1 + 2 * 3"

**响应示例：**
```json
{
  "code": 200,
  "message": "操作成功",
  "data": {
    "expression": "1 + 2 * 3",
    "result": 7.0
  }
}
```

#### 加法运算

**请求地址：** `POST /backendApi/calculator/add`

**请求参数：**
- `a` (必填): 第一个数
- `b` (必填): 第二个数

**响应示例：**
```json
{
  "code": 200,
  "message": "操作成功",
  "data": {
    "a": 5.0,
    "b": 3.0,
    "result": 8.0,
    "operation": "加法(+)"
  }
}
```

#### 减法运算

**请求地址：** `POST /backendApi/calculator/subtract`

**请求参数：**
- `a` (必填): 第一个数
- `b` (必填): 第二个数

#### 乘法运算

**请求地址：** `POST /backendApi/calculator/multiply`

**请求参数：**
- `a` (必填): 第一个数
- `b` (必填): 第二个数

#### 除法运算

**请求地址：** `POST /backendApi/calculator/divide`

**请求参数：**
- `a` (必填): 被除数
- `b` (必填): 除数

## 表达式示例

### 基本运算
- `2 + 3` → 5.0
- `5 - 2` → 3.0
- `4 * 3` → 12.0
- `10 / 2` → 5.0

### 运算符优先级
- `1 + 2 * 3` → 7.0 (先乘后加)
- `10 - 2 * 3` → 4.0 (先乘后减)

### 括号运算
- `(1 + 2) * 3` → 9.0
- `(10 - 2) / 4` → 2.0

### 复杂表达式
- `1 + 2 * 3 + 4 * 5 - 6` → 21.0
- `((2 + 3) * 2) - 5` → 5.0

### 小数运算
- `1.5 + 2.5` → 4.0
- `10.5 / 2` → 5.25

### 负数运算
- `-5 + 3` → -2.0
- `-2 * 3` → -6.0

## 错误处理

- **除零错误**: 当除数为0时，会抛出异常
- **非法表达式**: 当表达式格式不正确时，会抛出异常
- **空表达式**: 当表达式为空时，会抛出异常

## 技术实现

- **算法**: 使用双栈算法（操作数栈和操作符栈）实现表达式求值
- **优先级处理**: 正确处理乘除优先于加减的运算规则
- **括号支持**: 完整支持括号改变运算顺序
- **测试覆盖**: 包含20个单元测试用例，覆盖各种场景

## 单元测试

项目包含完整的单元测试，位于 `fuint-utils/src/test/java/com/fuint/utils/ArithmeticCalculatorTest.java`

运行测试：
```bash
cd fuint-utils
mvn test
```

所有测试用例均已通过验证。
