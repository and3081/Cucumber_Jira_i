#language: ru
@AllTests
Функция: Проверка Jira
  Предыстория:
    Когда Авторизуемся
    Тогда Появляется кнопка 'Проекты'

  Сценарий: Открытие проекта
    Когда Открываем проект
      | Test (TEST) |
    Тогда Появляется название-линк открытого проекта
      | Test        |


