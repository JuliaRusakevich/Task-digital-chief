Композиция город-достопримечательность. В качестве объектов для описания композиции были созданы соответственно City и Sight, отношения между которыми один ко многим (в одном городе есть много достопримечательностей).
Такую композицию можно использовать в предметной области Путешествия/Путеводитель.

Свойства объекта City:
-  название город (name)
-  страна (country)
-  возраст города (age)
-  популяция города (population)
-  описание (description)
- 
Свойства объекта Sight:
-  наименование достопримечательности (name)
-  архитектор (architect)
-  стиль (style)
-  адрес (address)
-  описание (description)
  
Написаны CRUD контроллер для сущностей City и Sight. 

При сохранении сущностей (City и Sight) данные передаются JSON, не все поля являются обязательными (передача id города обязательна).
Данные сущностей можно обновить, путем передачи JSON как при сохранении, если сущности нет в БД -> ошибка 404.
Чтение данных реализовано:
- чтение по id, если сущности нет в БД -> ошибка 404
- чтение всех сущностей (выводится список)
- чтение только тех достопримечательностей, которые находятся в конкретном городе

  Сборка проекта
Создайте pom.xml и пропишите modelVersion - всегда 4.0.0, groupId, artifactId:

    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.1.1</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>
    <groupId>com.example</groupId>
    <artifactId>task-digital-chief</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <packaging>war</packaging>

Версия java:
    <properties>
        <java.version>17</java.version>
    </properties>

Зависимости:
1. spring-boot-configuration-processor
2. spring-boot-starter-data-jpa
3. postgresql
4. spring-boot-starter-web
5. spring-boot-test
6. spring-boot-starter-test
7. lombok
   
Плагины для maven:
1. spring-boot-maven-plugin
   для ломбок прописать конфигурацию
<configuration>
    <excludes>
        <exclude>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
        </exclude>
    </excludes>
</configuration>

Пример моего pom.xml во вложении.

В properties.yml прописать подключения к БД и конфигурацию Hibernate (шаблон есть, свои данные)

Во вложении ddl для создания таблиц в Postgresql. 

Подготовленные запросы в файлах коллекции Postman.

Файлы postman, ddl, yml добавить в папку src/java/resources.

mvn compile - в папке target скомпилированные классы.

mvn package WAR-файл в target директории.


