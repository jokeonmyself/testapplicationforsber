man Деплой:

    1) war файл: https://github.com/jokeonmyself/tomcattestserver/blob/master/target/tomcatservlet-1.0-SNAPSHOT.war
    2) Идем в папку Tomcat, далее в папку webapps и перемещаем туда скачанный war.
    3) Запускаем сервер Tomcat.
    4) По адресу http://localhost:8080/GetBankAutomat/ отображаются координаты в формате json.
    5) Не выключая сервер, запускаем приложение на встроенном эмуляторе Android studio (не Genymotion и не реальное устройство).


Сам сервер: https://github.com/jokeonmyself/tomcattestserver

    При запуске из IDE обязательно указать ссылку на сервер http://localhost:8080
