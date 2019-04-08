# homework7
Домашняя работа к лекции №6 "Основы автоматизации тестирования web-приложений на Selenium(Java)" Данная работа выполняет тесты на сайте https://www.tinkoff.ru/mobile-operator/tariffs/, по заданным заданиям

Первый тест- Tests.tests.FirstTest Второй тест - Tests.tests.SecondTest 
Тест 2.1- Tests.tests.Test21 Тест 2.2 - Tests.tests.Test22 Тест 2.3 - Tests.tests.Test23
Тест 3* - не разобралась
Инструкция к запуску:
Скачать репозиторий любым удобным образом
Добавить поддержку Maven(<Name of Project>(Правой кнопкой мыши) -> Add framework support -> Maven)
Добавить нужный sdk(File->ProjectStructure-> Project -> Project SDK -> 1.8)
Запуск осуществляется в помощью maven- строки -Dtest=Tests.tests.FirstTest,Tests.tests.Test21 -Dbrowser=chrome verify - запуск первого теста в браузере Chrome -Dtest=Tests.tests.SecondTest -Dbrowser=firefox verify - запуск второго теста в браузере Mozilla Firefox
