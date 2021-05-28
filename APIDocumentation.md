# Api Documentation
Api Documentation

## Version: 1.0

### Terms of service
urn:tos

**License:** [Apache 2.0](http://www.apache.org/licenses/LICENSE-2.0)

### /api/products/add

#### POST
##### Summary

add

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| product | body | product | Yes | [Product](#product) |

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [Result](#result) |
| 201 | Created |  |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /api/products/getall

#### GET
##### Summary

getAll

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [DataResult«List«Product»»](#dataresult«list«product»») |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /api/products/getallbypage

#### GET
##### Summary

getAll

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| pageNo | query | pageNo | Yes | integer |
| pageSize | query | pageSize | Yes | integer |

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [DataResult«List«Product»»](#dataresult«list«product»») |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /api/products/getallbyproductnamecontains

#### GET
##### Summary

getAllByProductNameContains

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| productName | query | productName | Yes | string |

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [DataResult«List«Product»»](#dataresult«list«product»») |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /api/products/getallsorted

#### GET
##### Summary

getAllSorted

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| direction | query | direction | Yes | string |
| propertyNames | query | propertyNames | Yes | string |

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [DataResult«List«Product»»](#dataresult«list«product»») |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /api/products/getbyproductname

#### GET
##### Summary

getByProductName

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| productName | query | productName | Yes | string |

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [DataResult«Product»](#dataresult«product») |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /api/products/getbyproductnameandcategoryid

#### GET
##### Summary

getByProductNameAndCategoryId

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| categoryId | query | categoryId | Yes | integer |
| productName | query | productName | Yes | string |

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [DataResult«Product»](#dataresult«product») |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### Models

#### Category

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| categoryId | integer |  | No |
| categoryName | string |  | No |
| products | [ [Product](#product) ] |  | No |

#### DataResult«List«Product»»

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| data | [ [Product](#product) ] |  | No |
| message | string |  | No |
| success | boolean |  | No |

#### DataResult«Product»

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| data | [Product](#product) |  | No |
| message | string |  | No |
| success | boolean |  | No |

#### Product

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| category | [Category](#category) |  | No |
| id | integer |  | No |
| productName | string |  | No |
| quantityPerUnit | string |  | No |
| unitPrice | double |  | No |
| unitsInStock | integer |  | No |

#### Result

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| message | string |  | No |
| success | boolean |  | No |
