# Hibernate Collection Mapping Demo

* One ``Question`` can have multiple options in ``List<String> options``.
* List in hibernate require specific format for mapping.
* If you use Annotation based mapping, ``index`` for list is not mandatory.
```declarative
<list name="PROPERTY_NAME" table="TABLE_NAME" cascade="all">
    <key column="FOREIGN_KEY"/>
    <index column="LIST_VALUE_INDEX"/> <!-- Index column for the list -->
    <element column="LIST_VALUE"/>
</list>

<set name="PROPERTY_NAME">
    <key column="FOREIGN_KEY" />
    <element column="VALUE"/>
</set>
```

### Annotation Based Mapping Changes
* Add JPA API in ``pom.xml``
```declarative
<!-- JPA API -->
<dependency>
    <groupId>javax.persistence</groupId>
    <artifactId>javax.persistence-api</artifactId>
    <version>2.2</version>
</dependency>
```
* Add entity's mapping to ``hibernate.cfg.xml`` as ``<mapping class="org.abhinandanpdy.entity.AnnotatedQuestion" />``.
* Add annotated class entity to ``Configration`` in ``HibernateUtil.java`` as ``configuration.addAnnotatedClass(AnnotatedQuestion.class);``.

