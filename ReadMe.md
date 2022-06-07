# АльфаБанк. Тестовое приложение

Запуск через gradle:
* gradle clean
* gradle build
* java -jar AlphaBankCurrencyTracker-0.0.1-SNAPSHOT.jar

Запуск через docker-compose.yml

### HTTP endpoint 
/gif/currency-rate-dynamics
@Request parameter "curr_code" по формату ISO 4217 (пример RUB)

Возвращает text/html

### cURL
curl -X GET http://localhost:8080/gif/currency-rate/dynamics?curr_code=RUB
