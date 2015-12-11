.class public Lcom/fasterxml/jackson/databind/introspect/BasicBeanDescription;
.super Lcom/fasterxml/jackson/databind/BeanDescription;
.source "BasicBeanDescription.java"


# instance fields
.field protected final _annotationIntrospector:Lcom/fasterxml/jackson/databind/AnnotationIntrospector;

.field protected _anyGetter:Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;

.field protected _anySetterMethod:Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;

.field protected _bindings:Lcom/fasterxml/jackson/databind/type/TypeBindings;

.field protected final _classInfo:Lcom/fasterxml/jackson/databind/introspect/AnnotatedClass;

.field protected final _config:Lcom/fasterxml/jackson/databind/cfg/MapperConfig;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/fasterxml/jackson/databind/cfg/MapperConfig",
            "<*>;"
        }
    .end annotation
.end field

.field protected _ignoredPropertyNames:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field protected _injectables:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Object;",
            "Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;",
            ">;"
        }
    .end annotation
.end field

.field protected _jsonValueMethod:Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;

.field protected _objectIdInfo:Lcom/fasterxml/jackson/databind/introspect/ObjectIdInfo;

.field protected final _properties:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/fasterxml/jackson/databind/introspect/BeanPropertyDefinition;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method protected constructor <init>(Lcom/fasterxml/jackson/databind/cfg/MapperConfig;Lcom/fasterxml/jackson/databind/JavaType;Lcom/fasterxml/jackson/databind/introspect/AnnotatedClass;Ljava/util/List;)V
    .locals 1
    .param p2, "type"    # Lcom/fasterxml/jackson/databind/JavaType;
    .param p3, "classDef"    # Lcom/fasterxml/jackson/databind/introspect/AnnotatedClass;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/fasterxml/jackson/databind/cfg/MapperConfig",
            "<*>;",
            "Lcom/fasterxml/jackson/databind/JavaType;",
            "Lcom/fasterxml/jackson/databind/introspect/AnnotatedClass;",
            "Ljava/util/List",
            "<",
            "Lcom/fasterxml/jackson/databind/introspect/BeanPropertyDefinition;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 87
    .local p1, "config":Lcom/fasterxml/jackson/databind/cfg/MapperConfig;, "Lcom/fasterxml/jackson/databind/cfg/MapperConfig<*>;"
    .local p4, "props":Ljava/util/List;, "Ljava/util/List<Lcom/fasterxml/jackson/databind/introspect/BeanPropertyDefinition;>;"
    invoke-direct {p0, p2}, Lcom/fasterxml/jackson/databind/BeanDescription;-><init>(Lcom/fasterxml/jackson/databind/JavaType;)V

    .line 88
    iput-object p1, p0, Lcom/fasterxml/jackson/databind/introspect/BasicBeanDescription;->_config:Lcom/fasterxml/jackson/databind/cfg/MapperConfig;

    .line 89
    if-nez p1, :cond_0

    const/4 v0, 0x0

    :goto_0
    iput-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/BasicBeanDescription;->_annotationIntrospector:Lcom/fasterxml/jackson/databind/AnnotationIntrospector;

    .line 90
    iput-object p3, p0, Lcom/fasterxml/jackson/databind/introspect/BasicBeanDescription;->_classInfo:Lcom/fasterxml/jackson/databind/introspect/AnnotatedClass;

    .line 91
    iput-object p4, p0, Lcom/fasterxml/jackson/databind/introspect/BasicBeanDescription;->_properties:Ljava/util/List;

    .line 92
    return-void

    .line 89
    :cond_0
    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/cfg/MapperConfig;->getAnnotationIntrospector()Lcom/fasterxml/jackson/databind/AnnotationIntrospector;

    move-result-object v0

    goto :goto_0
.end method

.method protected constructor <init>(Lcom/fasterxml/jackson/databind/introspect/POJOPropertiesCollector;)V
    .locals 4
    .param p1, "coll"    # Lcom/fasterxml/jackson/databind/introspect/POJOPropertiesCollector;

    .prologue
    .line 96
    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertiesCollector;->getConfig()Lcom/fasterxml/jackson/databind/cfg/MapperConfig;

    move-result-object v0

    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertiesCollector;->getType()Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v1

    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertiesCollector;->getClassDef()Lcom/fasterxml/jackson/databind/introspect/AnnotatedClass;

    move-result-object v2

    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertiesCollector;->getProperties()Ljava/util/List;

    move-result-object v3

    invoke-direct {p0, v0, v1, v2, v3}, Lcom/fasterxml/jackson/databind/introspect/BasicBeanDescription;-><init>(Lcom/fasterxml/jackson/databind/cfg/MapperConfig;Lcom/fasterxml/jackson/databind/JavaType;Lcom/fasterxml/jackson/databind/introspect/AnnotatedClass;Ljava/util/List;)V

    .line 97
    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertiesCollector;->getObjectIdInfo()Lcom/fasterxml/jackson/databind/introspect/ObjectIdInfo;

    move-result-object v0

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/BasicBeanDescription;->_objectIdInfo:Lcom/fasterxml/jackson/databind/introspect/ObjectIdInfo;

    .line 98
    return-void
.end method

.method public static forDeserialization(Lcom/fasterxml/jackson/databind/introspect/POJOPropertiesCollector;)Lcom/fasterxml/jackson/databind/introspect/BasicBeanDescription;
    .locals 2
    .param p0, "coll"    # Lcom/fasterxml/jackson/databind/introspect/POJOPropertiesCollector;

    .prologue
    .line 106
    new-instance v0, Lcom/fasterxml/jackson/databind/introspect/BasicBeanDescription;

    invoke-direct {v0, p0}, Lcom/fasterxml/jackson/databind/introspect/BasicBeanDescription;-><init>(Lcom/fasterxml/jackson/databind/introspect/POJOPropertiesCollector;)V

    .line 107
    .local v0, "desc":Lcom/fasterxml/jackson/databind/introspect/BasicBeanDescription;
    invoke-virtual {p0}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertiesCollector;->getAnySetterMethod()Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;

    move-result-object v1

    iput-object v1, v0, Lcom/fasterxml/jackson/databind/introspect/BasicBeanDescription;->_anySetterMethod:Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;

    .line 108
    invoke-virtual {p0}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertiesCollector;->getIgnoredPropertyNames()Ljava/util/Set;

    move-result-object v1

    iput-object v1, v0, Lcom/fasterxml/jackson/databind/introspect/BasicBeanDescription;->_ignoredPropertyNames:Ljava/util/Set;

    .line 109
    invoke-virtual {p0}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertiesCollector;->getInjectables()Ljava/util/Map;

    move-result-object v1

    iput-object v1, v0, Lcom/fasterxml/jackson/databind/introspect/BasicBeanDescription;->_injectables:Ljava/util/Map;

    .line 110
    invoke-virtual {p0}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertiesCollector;->getJsonValueMethod()Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;

    move-result-object v1

    iput-object v1, v0, Lcom/fasterxml/jackson/databind/introspect/BasicBeanDescription;->_jsonValueMethod:Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;

    .line 111
    return-object v0
.end method

.method public static forOtherUse(Lcom/fasterxml/jackson/databind/cfg/MapperConfig;Lcom/fasterxml/jackson/databind/JavaType;Lcom/fasterxml/jackson/databind/introspect/AnnotatedClass;)Lcom/fasterxml/jackson/databind/introspect/BasicBeanDescription;
    .locals 2
    .param p1, "type"    # Lcom/fasterxml/jackson/databind/JavaType;
    .param p2, "ac"    # Lcom/fasterxml/jackson/databind/introspect/AnnotatedClass;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/fasterxml/jackson/databind/cfg/MapperConfig",
            "<*>;",
            "Lcom/fasterxml/jackson/databind/JavaType;",
            "Lcom/fasterxml/jackson/databind/introspect/AnnotatedClass;",
            ")",
            "Lcom/fasterxml/jackson/databind/introspect/BasicBeanDescription;"
        }
    .end annotation

    .prologue
    .line 134
    .local p0, "config":Lcom/fasterxml/jackson/databind/cfg/MapperConfig;, "Lcom/fasterxml/jackson/databind/cfg/MapperConfig<*>;"
    new-instance v0, Lcom/fasterxml/jackson/databind/introspect/BasicBeanDescription;

    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object v1

    invoke-direct {v0, p0, p1, p2, v1}, Lcom/fasterxml/jackson/databind/introspect/BasicBeanDescription;-><init>(Lcom/fasterxml/jackson/databind/cfg/MapperConfig;Lcom/fasterxml/jackson/databind/JavaType;Lcom/fasterxml/jackson/databind/introspect/AnnotatedClass;Ljava/util/List;)V

    return-object v0
.end method

.method public static forSerialization(Lcom/fasterxml/jackson/databind/introspect/POJOPropertiesCollector;)Lcom/fasterxml/jackson/databind/introspect/BasicBeanDescription;
    .locals 2
    .param p0, "coll"    # Lcom/fasterxml/jackson/databind/introspect/POJOPropertiesCollector;

    .prologue
    .line 120
    new-instance v0, Lcom/fasterxml/jackson/databind/introspect/BasicBeanDescription;

    invoke-direct {v0, p0}, Lcom/fasterxml/jackson/databind/introspect/BasicBeanDescription;-><init>(Lcom/fasterxml/jackson/databind/introspect/POJOPropertiesCollector;)V

    .line 121
    .local v0, "desc":Lcom/fasterxml/jackson/databind/introspect/BasicBeanDescription;
    invoke-virtual {p0}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertiesCollector;->getJsonValueMethod()Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;

    move-result-object v1

    iput-object v1, v0, Lcom/fasterxml/jackson/databind/introspect/BasicBeanDescription;->_jsonValueMethod:Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;

    .line 122
    invoke-virtual {p0}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertiesCollector;->getAnyGetter()Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;

    move-result-object v1

    iput-object v1, v0, Lcom/fasterxml/jackson/databind/introspect/BasicBeanDescription;->_anyGetter:Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;

    .line 123
    return-object v0
.end method


# virtual methods
.method public _findPropertyFields(Ljava/util/Collection;Z)Ljava/util/LinkedHashMap;
    .locals 6
    .param p2, "forSerialization"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Ljava/lang/String;",
            ">;Z)",
            "Ljava/util/LinkedHashMap",
            "<",
            "Ljava/lang/String;",
            "Lcom/fasterxml/jackson/databind/introspect/AnnotatedField;",
            ">;"
        }
    .end annotation

    .prologue
    .line 531
    .local p1, "ignoredProperties":Ljava/util/Collection;, "Ljava/util/Collection<Ljava/lang/String;>;"
    new-instance v4, Ljava/util/LinkedHashMap;

    invoke-direct {v4}, Ljava/util/LinkedHashMap;-><init>()V

    .line 532
    .local v4, "results":Ljava/util/LinkedHashMap;, "Ljava/util/LinkedHashMap<Ljava/lang/String;Lcom/fasterxml/jackson/databind/introspect/AnnotatedField;>;"
    iget-object v5, p0, Lcom/fasterxml/jackson/databind/introspect/BasicBeanDescription;->_properties:Ljava/util/List;

    invoke-interface {v5}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_2

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/fasterxml/jackson/databind/introspect/BeanPropertyDefinition;

    .line 533
    .local v3, "property":Lcom/fasterxml/jackson/databind/introspect/BeanPropertyDefinition;
    invoke-virtual {v3}, Lcom/fasterxml/jackson/databind/introspect/BeanPropertyDefinition;->getField()Lcom/fasterxml/jackson/databind/introspect/AnnotatedField;

    move-result-object v0

    .line 534
    .local v0, "f":Lcom/fasterxml/jackson/databind/introspect/AnnotatedField;
    if-eqz v0, :cond_0

    .line 535
    invoke-virtual {v3}, Lcom/fasterxml/jackson/databind/introspect/BeanPropertyDefinition;->getName()Ljava/lang/String;

    move-result-object v2

    .line 536
    .local v2, "name":Ljava/lang/String;
    if-eqz p1, :cond_1

    .line 537
    invoke-interface {p1, v2}, Ljava/util/Collection;->contains(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_0

    .line 541
    :cond_1
    invoke-virtual {v4, v2, v0}, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 544
    .end local v0    # "f":Lcom/fasterxml/jackson/databind/introspect/AnnotatedField;
    .end local v2    # "name":Ljava/lang/String;
    .end local v3    # "property":Lcom/fasterxml/jackson/databind/introspect/BeanPropertyDefinition;
    :cond_2
    return-object v4
.end method

.method public bindingsForBeanType()Lcom/fasterxml/jackson/databind/type/TypeBindings;
    .locals 3

    .prologue
    .line 207
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/BasicBeanDescription;->_bindings:Lcom/fasterxml/jackson/databind/type/TypeBindings;

    if-nez v0, :cond_0

    .line 208
    new-instance v0, Lcom/fasterxml/jackson/databind/type/TypeBindings;

    iget-object v1, p0, Lcom/fasterxml/jackson/databind/introspect/BasicBeanDescription;->_config:Lcom/fasterxml/jackson/databind/cfg/MapperConfig;

    invoke-virtual {v1}, Lcom/fasterxml/jackson/databind/cfg/MapperConfig;->getTypeFactory()Lcom/fasterxml/jackson/databind/type/TypeFactory;

    move-result-object v1

    iget-object v2, p0, Lcom/fasterxml/jackson/databind/introspect/BasicBeanDescription;->_type:Lcom/fasterxml/jackson/databind/JavaType;

    invoke-direct {v0, v1, v2}, Lcom/fasterxml/jackson/databind/type/TypeBindings;-><init>(Lcom/fasterxml/jackson/databind/type/TypeFactory;Lcom/fasterxml/jackson/databind/JavaType;)V

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/BasicBeanDescription;->_bindings:Lcom/fasterxml/jackson/databind/type/TypeBindings;

    .line 210
    :cond_0
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/BasicBeanDescription;->_bindings:Lcom/fasterxml/jackson/databind/type/TypeBindings;

    return-object v0
.end method

.method public findAnyGetter()Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalArgumentException;
        }
    .end annotation

    .prologue
    .line 463
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/introspect/BasicBeanDescription;->_anyGetter:Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;

    if-eqz v1, :cond_0

    .line 467
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/introspect/BasicBeanDescription;->_anyGetter:Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;

    invoke-virtual {v1}, Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;->getRawType()Ljava/lang/Class;

    move-result-object v0

    .line 468
    .local v0, "type":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    const-class v1, Ljava/util/Map;

    invoke-virtual {v1, v0}, Ljava/lang/Class;->isAssignableFrom(Ljava/lang/Class;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 469
    new-instance v1, Ljava/lang/IllegalArgumentException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Invalid \'any-getter\' annotation on method "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/fasterxml/jackson/databind/introspect/BasicBeanDescription;->_anyGetter:Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;

    invoke-virtual {v3}, Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "(): return type is not instance of java.util.Map"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 472
    .end local v0    # "type":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    :cond_0
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/introspect/BasicBeanDescription;->_anyGetter:Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;

    return-object v1
.end method

.method public findAnySetter()Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalArgumentException;
        }
    .end annotation

    .prologue
    .line 229
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/introspect/BasicBeanDescription;->_anySetterMethod:Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;

    if-eqz v1, :cond_0

    .line 238
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/introspect/BasicBeanDescription;->_anySetterMethod:Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;->getRawParameterType(I)Ljava/lang/Class;

    move-result-object v0

    .line 239
    .local v0, "type":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    const-class v1, Ljava/lang/String;

    if-eq v0, v1, :cond_0

    const-class v1, Ljava/lang/Object;

    if-eq v0, v1, :cond_0

    .line 240
    new-instance v1, Ljava/lang/IllegalArgumentException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Invalid \'any-setter\' annotation on method "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/fasterxml/jackson/databind/introspect/BasicBeanDescription;->_anySetterMethod:Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;

    invoke-virtual {v3}, Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "(): first argument not of type String or Object, but "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 243
    .end local v0    # "type":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    :cond_0
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/introspect/BasicBeanDescription;->_anySetterMethod:Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;

    return-object v1
.end method

.method public findBackReferenceProperties()Ljava/util/Map;
    .locals 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;",
            ">;"
        }
    .end annotation

    .prologue
    .line 478
    const/4 v5, 0x0

    .line 479
    .local v5, "result":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;>;"
    iget-object v6, p0, Lcom/fasterxml/jackson/databind/introspect/BasicBeanDescription;->_properties:Ljava/util/List;

    invoke-interface {v6}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_2

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/fasterxml/jackson/databind/introspect/BeanPropertyDefinition;

    .line 480
    .local v2, "property":Lcom/fasterxml/jackson/databind/introspect/BeanPropertyDefinition;
    invoke-virtual {v2}, Lcom/fasterxml/jackson/databind/introspect/BeanPropertyDefinition;->getMutator()Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;

    move-result-object v0

    .line 481
    .local v0, "am":Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;
    if-eqz v0, :cond_0

    .line 484
    iget-object v6, p0, Lcom/fasterxml/jackson/databind/introspect/BasicBeanDescription;->_annotationIntrospector:Lcom/fasterxml/jackson/databind/AnnotationIntrospector;

    invoke-virtual {v6, v0}, Lcom/fasterxml/jackson/databind/AnnotationIntrospector;->findReferenceType(Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;)Lcom/fasterxml/jackson/databind/AnnotationIntrospector$ReferenceProperty;

    move-result-object v3

    .line 485
    .local v3, "refDef":Lcom/fasterxml/jackson/databind/AnnotationIntrospector$ReferenceProperty;
    if-eqz v3, :cond_0

    invoke-virtual {v3}, Lcom/fasterxml/jackson/databind/AnnotationIntrospector$ReferenceProperty;->isBackReference()Z

    move-result v6

    if-eqz v6, :cond_0

    .line 486
    if-nez v5, :cond_1

    .line 487
    new-instance v5, Ljava/util/HashMap;

    .end local v5    # "result":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;>;"
    invoke-direct {v5}, Ljava/util/HashMap;-><init>()V

    .line 489
    .restart local v5    # "result":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;>;"
    :cond_1
    invoke-virtual {v3}, Lcom/fasterxml/jackson/databind/AnnotationIntrospector$ReferenceProperty;->getName()Ljava/lang/String;

    move-result-object v4

    .line 490
    .local v4, "refName":Ljava/lang/String;
    invoke-virtual {v5, v4, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    if-eqz v6, :cond_0

    .line 491
    new-instance v6, Ljava/lang/IllegalArgumentException;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "Multiple back-reference properties with name \'"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, "\'"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-direct {v6, v7}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v6

    .line 495
    .end local v0    # "am":Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;
    .end local v2    # "property":Lcom/fasterxml/jackson/databind/introspect/BeanPropertyDefinition;
    .end local v3    # "refDef":Lcom/fasterxml/jackson/databind/AnnotationIntrospector$ReferenceProperty;
    .end local v4    # "refName":Ljava/lang/String;
    :cond_2
    return-object v5
.end method

.method public findCreatorPropertyNames()Ljava/util/List;
    .locals 10
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 405
    const/4 v6, 0x0

    .line 407
    .local v6, "names":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    const/4 v8, 0x2

    if-ge v2, v8, :cond_5

    .line 408
    if-nez v2, :cond_2

    invoke-virtual {p0}, Lcom/fasterxml/jackson/databind/introspect/BasicBeanDescription;->getConstructors()Ljava/util/List;

    move-result-object v4

    .line 410
    .local v4, "l":Ljava/util/List;, "Ljava/util/List<+Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;>;"
    :goto_1
    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, "i$":Ljava/util/Iterator;
    :cond_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_4

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;

    .line 411
    .local v1, "creator":Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;
    invoke-virtual {v1}, Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;->getParameterCount()I

    move-result v0

    .line 412
    .local v0, "argCount":I
    const/4 v8, 0x1

    if-lt v0, v8, :cond_0

    .line 413
    iget-object v8, p0, Lcom/fasterxml/jackson/databind/introspect/BasicBeanDescription;->_annotationIntrospector:Lcom/fasterxml/jackson/databind/AnnotationIntrospector;

    const/4 v9, 0x0

    invoke-virtual {v1, v9}, Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;->getParameter(I)Lcom/fasterxml/jackson/databind/introspect/AnnotatedParameter;

    move-result-object v9

    invoke-virtual {v8, v9}, Lcom/fasterxml/jackson/databind/AnnotationIntrospector;->findNameForDeserialization(Lcom/fasterxml/jackson/databind/introspect/Annotated;)Lcom/fasterxml/jackson/databind/PropertyName;

    move-result-object v5

    .line 414
    .local v5, "name":Lcom/fasterxml/jackson/databind/PropertyName;
    if-eqz v5, :cond_0

    .line 417
    if-nez v6, :cond_1

    .line 418
    new-instance v6, Ljava/util/ArrayList;

    .end local v6    # "names":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-direct {v6}, Ljava/util/ArrayList;-><init>()V

    .line 420
    .restart local v6    # "names":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :cond_1
    invoke-virtual {v5}, Lcom/fasterxml/jackson/databind/PropertyName;->getSimpleName()Ljava/lang/String;

    move-result-object v8

    invoke-interface {v6, v8}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 421
    const/4 v7, 0x1

    .local v7, "p":I
    :goto_2
    if-ge v7, v0, :cond_0

    .line 422
    iget-object v8, p0, Lcom/fasterxml/jackson/databind/introspect/BasicBeanDescription;->_annotationIntrospector:Lcom/fasterxml/jackson/databind/AnnotationIntrospector;

    invoke-virtual {v1, v7}, Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;->getParameter(I)Lcom/fasterxml/jackson/databind/introspect/AnnotatedParameter;

    move-result-object v9

    invoke-virtual {v8, v9}, Lcom/fasterxml/jackson/databind/AnnotationIntrospector;->findNameForDeserialization(Lcom/fasterxml/jackson/databind/introspect/Annotated;)Lcom/fasterxml/jackson/databind/PropertyName;

    move-result-object v5

    .line 423
    if-nez v5, :cond_3

    const/4 v8, 0x0

    :goto_3
    invoke-interface {v6, v8}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 421
    add-int/lit8 v7, v7, 0x1

    goto :goto_2

    .line 408
    .end local v0    # "argCount":I
    .end local v1    # "creator":Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;
    .end local v3    # "i$":Ljava/util/Iterator;
    .end local v4    # "l":Ljava/util/List;, "Ljava/util/List<+Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;>;"
    .end local v5    # "name":Lcom/fasterxml/jackson/databind/PropertyName;
    .end local v7    # "p":I
    :cond_2
    invoke-virtual {p0}, Lcom/fasterxml/jackson/databind/introspect/BasicBeanDescription;->getFactoryMethods()Ljava/util/List;

    move-result-object v4

    goto :goto_1

    .line 423
    .restart local v0    # "argCount":I
    .restart local v1    # "creator":Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;
    .restart local v3    # "i$":Ljava/util/Iterator;
    .restart local v4    # "l":Ljava/util/List;, "Ljava/util/List<+Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;>;"
    .restart local v5    # "name":Lcom/fasterxml/jackson/databind/PropertyName;
    .restart local v7    # "p":I
    :cond_3
    invoke-virtual {v5}, Lcom/fasterxml/jackson/databind/PropertyName;->getSimpleName()Ljava/lang/String;

    move-result-object v8

    goto :goto_3

    .line 407
    .end local v0    # "argCount":I
    .end local v1    # "creator":Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;
    .end local v5    # "name":Lcom/fasterxml/jackson/databind/PropertyName;
    .end local v7    # "p":I
    :cond_4
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 427
    .end local v3    # "i$":Ljava/util/Iterator;
    .end local v4    # "l":Ljava/util/List;, "Ljava/util/List<+Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;>;"
    :cond_5
    if-nez v6, :cond_6

    .line 428
    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object v6

    .line 430
    .end local v6    # "names":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :cond_6
    return-object v6
.end method

.method public findDefaultConstructor()Lcom/fasterxml/jackson/databind/introspect/AnnotatedConstructor;
    .locals 1

    .prologue
    .line 223
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/BasicBeanDescription;->_classInfo:Lcom/fasterxml/jackson/databind/introspect/AnnotatedClass;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/databind/introspect/AnnotatedClass;->getDefaultConstructor()Lcom/fasterxml/jackson/databind/introspect/AnnotatedConstructor;

    move-result-object v0

    return-object v0
.end method

.method public findExpectedFormat(Lcom/fasterxml/jackson/annotation/JsonFormat$Value;)Lcom/fasterxml/jackson/annotation/JsonFormat$Value;
    .locals 3
    .param p1, "defValue"    # Lcom/fasterxml/jackson/annotation/JsonFormat$Value;

    .prologue
    .line 299
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/introspect/BasicBeanDescription;->_annotationIntrospector:Lcom/fasterxml/jackson/databind/AnnotationIntrospector;

    if-eqz v1, :cond_0

    .line 300
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/introspect/BasicBeanDescription;->_annotationIntrospector:Lcom/fasterxml/jackson/databind/AnnotationIntrospector;

    iget-object v2, p0, Lcom/fasterxml/jackson/databind/introspect/BasicBeanDescription;->_classInfo:Lcom/fasterxml/jackson/databind/introspect/AnnotatedClass;

    invoke-virtual {v1, v2}, Lcom/fasterxml/jackson/databind/AnnotationIntrospector;->findFormat(Lcom/fasterxml/jackson/databind/introspect/Annotated;)Lcom/fasterxml/jackson/annotation/JsonFormat$Value;

    move-result-object v0

    .line 301
    .local v0, "v":Lcom/fasterxml/jackson/annotation/JsonFormat$Value;
    if-eqz v0, :cond_0

    .line 305
    .end local v0    # "v":Lcom/fasterxml/jackson/annotation/JsonFormat$Value;
    :goto_0
    return-object v0

    :cond_0
    move-object v0, p1

    goto :goto_0
.end method

.method public varargs findFactoryMethod([Ljava/lang/Class;)Ljava/lang/reflect/Method;
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([",
            "Ljava/lang/Class",
            "<*>;)",
            "Ljava/lang/reflect/Method;"
        }
    .end annotation

    .prologue
    .line 355
    .local p1, "expArgTypes":[Ljava/lang/Class;, "[Ljava/lang/Class<*>;"
    iget-object v7, p0, Lcom/fasterxml/jackson/databind/introspect/BasicBeanDescription;->_classInfo:Lcom/fasterxml/jackson/databind/introspect/AnnotatedClass;

    invoke-virtual {v7}, Lcom/fasterxml/jackson/databind/introspect/AnnotatedClass;->getStaticMethods()Ljava/util/List;

    move-result-object v7

    invoke-interface {v7}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :cond_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_2

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;

    .line 356
    .local v1, "am":Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;
    invoke-virtual {p0, v1}, Lcom/fasterxml/jackson/databind/introspect/BasicBeanDescription;->isFactoryMethod(Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;)Z

    move-result v7

    if-eqz v7, :cond_0

    .line 358
    const/4 v7, 0x0

    invoke-virtual {v1, v7}, Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;->getRawParameterType(I)Ljava/lang/Class;

    move-result-object v0

    .line 359
    .local v0, "actualArgType":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    move-object v2, p1

    .local v2, "arr$":[Ljava/lang/Class;
    array-length v6, v2

    .local v6, "len$":I
    const/4 v5, 0x0

    .local v5, "i$":I
    :goto_0
    if-ge v5, v6, :cond_0

    aget-object v3, v2, v5

    .line 361
    .local v3, "expArgType":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-virtual {v0, v3}, Ljava/lang/Class;->isAssignableFrom(Ljava/lang/Class;)Z

    move-result v7

    if-eqz v7, :cond_1

    .line 362
    invoke-virtual {v1}, Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;->getAnnotated()Ljava/lang/reflect/Method;

    move-result-object v7

    .line 367
    .end local v0    # "actualArgType":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .end local v1    # "am":Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;
    .end local v2    # "arr$":[Ljava/lang/Class;
    .end local v3    # "expArgType":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .end local v5    # "i$":I
    .end local v6    # "len$":I
    :goto_1
    return-object v7

    .line 359
    .restart local v0    # "actualArgType":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .restart local v1    # "am":Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;
    .restart local v2    # "arr$":[Ljava/lang/Class;
    .restart local v3    # "expArgType":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .restart local v5    # "i$":I
    .restart local v6    # "len$":I
    :cond_1
    add-int/lit8 v5, v5, 0x1

    goto :goto_0

    .line 367
    .end local v0    # "actualArgType":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .end local v1    # "am":Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;
    .end local v2    # "arr$":[Ljava/lang/Class;
    .end local v3    # "expArgType":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .end local v5    # "i$":I
    .end local v6    # "len$":I
    :cond_2
    const/4 v7, 0x0

    goto :goto_1
.end method

.method public findInjectables()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Object;",
            "Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;",
            ">;"
        }
    .end annotation

    .prologue
    .line 248
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/BasicBeanDescription;->_injectables:Ljava/util/Map;

    return-object v0
.end method

.method public findJsonValueMethod()Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;
    .locals 1

    .prologue
    .line 183
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/BasicBeanDescription;->_jsonValueMethod:Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;

    return-object v0
.end method

.method public findMethod(Ljava/lang/String;[Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "[",
            "Ljava/lang/Class",
            "<*>;)",
            "Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;"
        }
    .end annotation

    .prologue
    .line 287
    .local p2, "paramTypes":[Ljava/lang/Class;, "[Ljava/lang/Class<*>;"
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/BasicBeanDescription;->_classInfo:Lcom/fasterxml/jackson/databind/introspect/AnnotatedClass;

    invoke-virtual {v0, p1, p2}, Lcom/fasterxml/jackson/databind/introspect/AnnotatedClass;->findMethod(Ljava/lang/String;[Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;

    move-result-object v0

    return-object v0
.end method

.method public findPOJOBuilder()Ljava/lang/Class;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/lang/Class",
            "<*>;"
        }
    .end annotation

    .prologue
    .line 501
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/BasicBeanDescription;->_annotationIntrospector:Lcom/fasterxml/jackson/databind/AnnotationIntrospector;

    if-nez v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/BasicBeanDescription;->_annotationIntrospector:Lcom/fasterxml/jackson/databind/AnnotationIntrospector;

    iget-object v1, p0, Lcom/fasterxml/jackson/databind/introspect/BasicBeanDescription;->_classInfo:Lcom/fasterxml/jackson/databind/introspect/AnnotatedClass;

    invoke-virtual {v0, v1}, Lcom/fasterxml/jackson/databind/AnnotationIntrospector;->findPOJOBuilder(Lcom/fasterxml/jackson/databind/introspect/AnnotatedClass;)Ljava/lang/Class;

    move-result-object v0

    goto :goto_0
.end method

.method public findPOJOBuilderConfig()Lcom/fasterxml/jackson/databind/annotation/JsonPOJOBuilder$Value;
    .locals 2

    .prologue
    .line 508
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/BasicBeanDescription;->_annotationIntrospector:Lcom/fasterxml/jackson/databind/AnnotationIntrospector;

    if-nez v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/BasicBeanDescription;->_annotationIntrospector:Lcom/fasterxml/jackson/databind/AnnotationIntrospector;

    iget-object v1, p0, Lcom/fasterxml/jackson/databind/introspect/BasicBeanDescription;->_classInfo:Lcom/fasterxml/jackson/databind/introspect/AnnotatedClass;

    invoke-virtual {v0, v1}, Lcom/fasterxml/jackson/databind/AnnotationIntrospector;->findPOJOBuilderConfig(Lcom/fasterxml/jackson/databind/introspect/AnnotatedClass;)Lcom/fasterxml/jackson/databind/annotation/JsonPOJOBuilder$Value;

    move-result-object v0

    goto :goto_0
.end method

.method public findProperties()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/fasterxml/jackson/databind/introspect/BeanPropertyDefinition;",
            ">;"
        }
    .end annotation

    .prologue
    .line 178
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/BasicBeanDescription;->_properties:Ljava/util/List;

    return-object v0
.end method

.method public findSerializationInclusion(Lcom/fasterxml/jackson/annotation/JsonInclude$Include;)Lcom/fasterxml/jackson/annotation/JsonInclude$Include;
    .locals 2
    .param p1, "defValue"    # Lcom/fasterxml/jackson/annotation/JsonInclude$Include;

    .prologue
    .line 448
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/BasicBeanDescription;->_annotationIntrospector:Lcom/fasterxml/jackson/databind/AnnotationIntrospector;

    if-nez v0, :cond_0

    .line 451
    .end local p1    # "defValue":Lcom/fasterxml/jackson/annotation/JsonInclude$Include;
    :goto_0
    return-object p1

    .restart local p1    # "defValue":Lcom/fasterxml/jackson/annotation/JsonInclude$Include;
    :cond_0
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/BasicBeanDescription;->_annotationIntrospector:Lcom/fasterxml/jackson/databind/AnnotationIntrospector;

    iget-object v1, p0, Lcom/fasterxml/jackson/databind/introspect/BasicBeanDescription;->_classInfo:Lcom/fasterxml/jackson/databind/introspect/AnnotatedClass;

    invoke-virtual {v0, v1, p1}, Lcom/fasterxml/jackson/databind/AnnotationIntrospector;->findSerializationInclusion(Lcom/fasterxml/jackson/databind/introspect/Annotated;Lcom/fasterxml/jackson/annotation/JsonInclude$Include;)Lcom/fasterxml/jackson/annotation/JsonInclude$Include;

    move-result-object p1

    goto :goto_0
.end method

.method public varargs findSingleArgConstructor([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    .locals 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([",
            "Ljava/lang/Class",
            "<*>;)",
            "Ljava/lang/reflect/Constructor",
            "<*>;"
        }
    .end annotation

    .prologue
    .line 334
    .local p1, "argTypes":[Ljava/lang/Class;, "[Ljava/lang/Class<*>;"
    iget-object v7, p0, Lcom/fasterxml/jackson/databind/introspect/BasicBeanDescription;->_classInfo:Lcom/fasterxml/jackson/databind/introspect/AnnotatedClass;

    invoke-virtual {v7}, Lcom/fasterxml/jackson/databind/introspect/AnnotatedClass;->getConstructors()Ljava/util/List;

    move-result-object v7

    invoke-interface {v7}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :cond_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_2

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/fasterxml/jackson/databind/introspect/AnnotatedConstructor;

    .line 339
    .local v0, "ac":Lcom/fasterxml/jackson/databind/introspect/AnnotatedConstructor;
    invoke-virtual {v0}, Lcom/fasterxml/jackson/databind/introspect/AnnotatedConstructor;->getParameterCount()I

    move-result v7

    const/4 v8, 0x1

    if-ne v7, v8, :cond_0

    .line 340
    const/4 v7, 0x0

    invoke-virtual {v0, v7}, Lcom/fasterxml/jackson/databind/introspect/AnnotatedConstructor;->getRawParameterType(I)Ljava/lang/Class;

    move-result-object v1

    .line 341
    .local v1, "actArg":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    move-object v2, p1

    .local v2, "arr$":[Ljava/lang/Class;
    array-length v6, v2

    .local v6, "len$":I
    const/4 v5, 0x0

    .local v5, "i$":I
    :goto_0
    if-ge v5, v6, :cond_0

    aget-object v3, v2, v5

    .line 342
    .local v3, "expArg":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    if-ne v3, v1, :cond_1

    .line 343
    invoke-virtual {v0}, Lcom/fasterxml/jackson/databind/introspect/AnnotatedConstructor;->getAnnotated()Ljava/lang/reflect/Constructor;

    move-result-object v7

    .line 348
    .end local v0    # "ac":Lcom/fasterxml/jackson/databind/introspect/AnnotatedConstructor;
    .end local v1    # "actArg":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .end local v2    # "arr$":[Ljava/lang/Class;
    .end local v3    # "expArg":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .end local v5    # "i$":I
    .end local v6    # "len$":I
    :goto_1
    return-object v7

    .line 341
    .restart local v0    # "ac":Lcom/fasterxml/jackson/databind/introspect/AnnotatedConstructor;
    .restart local v1    # "actArg":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .restart local v2    # "arr$":[Ljava/lang/Class;
    .restart local v3    # "expArg":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .restart local v5    # "i$":I
    .restart local v6    # "len$":I
    :cond_1
    add-int/lit8 v5, v5, 0x1

    goto :goto_0

    .line 348
    .end local v0    # "ac":Lcom/fasterxml/jackson/databind/introspect/AnnotatedConstructor;
    .end local v1    # "actArg":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .end local v2    # "arr$":[Ljava/lang/Class;
    .end local v3    # "expArg":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .end local v5    # "i$":I
    .end local v6    # "len$":I
    :cond_2
    const/4 v7, 0x0

    goto :goto_1
.end method

.method public getClassAnnotations()Lcom/fasterxml/jackson/databind/util/Annotations;
    .locals 1

    .prologue
    .line 201
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/BasicBeanDescription;->_classInfo:Lcom/fasterxml/jackson/databind/introspect/AnnotatedClass;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/databind/introspect/AnnotatedClass;->getAnnotations()Lcom/fasterxml/jackson/databind/util/Annotations;

    move-result-object v0

    return-object v0
.end method

.method public getClassInfo()Lcom/fasterxml/jackson/databind/introspect/AnnotatedClass;
    .locals 1

    .prologue
    .line 171
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/BasicBeanDescription;->_classInfo:Lcom/fasterxml/jackson/databind/introspect/AnnotatedClass;

    return-object v0
.end method

.method public getConstructors()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/fasterxml/jackson/databind/introspect/AnnotatedConstructor;",
            ">;"
        }
    .end annotation

    .prologue
    .line 253
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/BasicBeanDescription;->_classInfo:Lcom/fasterxml/jackson/databind/introspect/AnnotatedClass;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/databind/introspect/AnnotatedClass;->getConstructors()Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public getFactoryMethods()Ljava/util/List;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;",
            ">;"
        }
    .end annotation

    .prologue
    .line 318
    iget-object v4, p0, Lcom/fasterxml/jackson/databind/introspect/BasicBeanDescription;->_classInfo:Lcom/fasterxml/jackson/databind/introspect/AnnotatedClass;

    invoke-virtual {v4}, Lcom/fasterxml/jackson/databind/introspect/AnnotatedClass;->getStaticMethods()Ljava/util/List;

    move-result-object v1

    .line 319
    .local v1, "candidates":Ljava/util/List;, "Ljava/util/List<Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;>;"
    invoke-interface {v1}, Ljava/util/List;->isEmpty()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 328
    .end local v1    # "candidates":Ljava/util/List;, "Ljava/util/List<Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;>;"
    :goto_0
    return-object v1

    .line 322
    .restart local v1    # "candidates":Ljava/util/List;, "Ljava/util/List<Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;>;"
    :cond_0
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 323
    .local v3, "result":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;>;"
    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :cond_1
    :goto_1
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_2

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;

    .line 324
    .local v0, "am":Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;
    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/databind/introspect/BasicBeanDescription;->isFactoryMethod(Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 325
    invoke-virtual {v3, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .end local v0    # "am":Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;
    :cond_2
    move-object v1, v3

    .line 328
    goto :goto_0
.end method

.method public getIgnoredPropertyNames()Ljava/util/Set;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 188
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/BasicBeanDescription;->_ignoredPropertyNames:Ljava/util/Set;

    if-nez v0, :cond_0

    .line 189
    invoke-static {}, Ljava/util/Collections;->emptySet()Ljava/util/Set;

    move-result-object v0

    .line 191
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/BasicBeanDescription;->_ignoredPropertyNames:Ljava/util/Set;

    goto :goto_0
.end method

.method public getObjectIdInfo()Lcom/fasterxml/jackson/databind/introspect/ObjectIdInfo;
    .locals 1

    .prologue
    .line 174
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/BasicBeanDescription;->_objectIdInfo:Lcom/fasterxml/jackson/databind/introspect/ObjectIdInfo;

    return-object v0
.end method

.method public hasKnownClassAnnotations()Z
    .locals 1

    .prologue
    .line 196
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/BasicBeanDescription;->_classInfo:Lcom/fasterxml/jackson/databind/introspect/AnnotatedClass;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/databind/introspect/AnnotatedClass;->hasAnnotations()Z

    move-result v0

    return v0
.end method

.method public instantiateBean(Z)Ljava/lang/Object;
    .locals 6
    .param p1, "fixAccess"    # Z

    .prologue
    .line 259
    iget-object v3, p0, Lcom/fasterxml/jackson/databind/introspect/BasicBeanDescription;->_classInfo:Lcom/fasterxml/jackson/databind/introspect/AnnotatedClass;

    invoke-virtual {v3}, Lcom/fasterxml/jackson/databind/introspect/AnnotatedClass;->getDefaultConstructor()Lcom/fasterxml/jackson/databind/introspect/AnnotatedConstructor;

    move-result-object v0

    .line 260
    .local v0, "ac":Lcom/fasterxml/jackson/databind/introspect/AnnotatedConstructor;
    if-nez v0, :cond_0

    .line 261
    const/4 v3, 0x0

    .line 267
    :goto_0
    return-object v3

    .line 263
    :cond_0
    if-eqz p1, :cond_1

    .line 264
    invoke-virtual {v0}, Lcom/fasterxml/jackson/databind/introspect/AnnotatedConstructor;->fixAccess()V

    .line 267
    :cond_1
    :try_start_0
    invoke-virtual {v0}, Lcom/fasterxml/jackson/databind/introspect/AnnotatedConstructor;->getAnnotated()Ljava/lang/reflect/Constructor;

    move-result-object v3

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/Object;

    invoke-virtual {v3, v4}, Ljava/lang/reflect/Constructor;->newInstance([Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v3

    goto :goto_0

    .line 268
    :catch_0
    move-exception v1

    .line 269
    .local v1, "e":Ljava/lang/Exception;
    move-object v2, v1

    .line 270
    .local v2, "t":Ljava/lang/Throwable;
    :goto_1
    invoke-virtual {v2}, Ljava/lang/Throwable;->getCause()Ljava/lang/Throwable;

    move-result-object v3

    if-eqz v3, :cond_2

    .line 271
    invoke-virtual {v2}, Ljava/lang/Throwable;->getCause()Ljava/lang/Throwable;

    move-result-object v2

    goto :goto_1

    .line 273
    :cond_2
    instance-of v3, v2, Ljava/lang/Error;

    if-eqz v3, :cond_3

    check-cast v2, Ljava/lang/Error;

    .end local v2    # "t":Ljava/lang/Throwable;
    throw v2

    .line 274
    .restart local v2    # "t":Ljava/lang/Throwable;
    :cond_3
    instance-of v3, v2, Ljava/lang/RuntimeException;

    if-eqz v3, :cond_4

    check-cast v2, Ljava/lang/RuntimeException;

    .end local v2    # "t":Ljava/lang/Throwable;
    throw v2

    .line 275
    .restart local v2    # "t":Ljava/lang/Throwable;
    :cond_4
    new-instance v3, Ljava/lang/IllegalArgumentException;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Failed to instantiate bean of type "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, p0, Lcom/fasterxml/jackson/databind/introspect/BasicBeanDescription;->_classInfo:Lcom/fasterxml/jackson/databind/introspect/AnnotatedClass;

    invoke-virtual {v5}, Lcom/fasterxml/jackson/databind/introspect/AnnotatedClass;->getAnnotated()Ljava/lang/Class;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, ": ("

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v2}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, ") "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v2}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v3
.end method

.method protected isFactoryMethod(Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;)Z
    .locals 5
    .param p1, "am"    # Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;

    .prologue
    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 376
    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;->getRawReturnType()Ljava/lang/Class;

    move-result-object v0

    .line 377
    .local v0, "rt":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-virtual {p0}, Lcom/fasterxml/jackson/databind/introspect/BasicBeanDescription;->getBeanClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {v3, v0}, Ljava/lang/Class;->isAssignableFrom(Ljava/lang/Class;)Z

    move-result v3

    if-nez v3, :cond_1

    .line 391
    :cond_0
    :goto_0
    return v1

    .line 385
    :cond_1
    iget-object v3, p0, Lcom/fasterxml/jackson/databind/introspect/BasicBeanDescription;->_annotationIntrospector:Lcom/fasterxml/jackson/databind/AnnotationIntrospector;

    invoke-virtual {v3, p1}, Lcom/fasterxml/jackson/databind/AnnotationIntrospector;->hasCreatorAnnotation(Lcom/fasterxml/jackson/databind/introspect/Annotated;)Z

    move-result v3

    if-eqz v3, :cond_2

    move v1, v2

    .line 386
    goto :goto_0

    .line 388
    :cond_2
    const-string v3, "valueOf"

    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;->getName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    move v1, v2

    .line 389
    goto :goto_0
.end method

.method public removeProperty(Ljava/lang/String;)Z
    .locals 3
    .param p1, "propName"    # Ljava/lang/String;

    .prologue
    .line 153
    iget-object v2, p0, Lcom/fasterxml/jackson/databind/introspect/BasicBeanDescription;->_properties:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .line 154
    .local v0, "it":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/fasterxml/jackson/databind/introspect/BeanPropertyDefinition;>;"
    :cond_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 155
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/fasterxml/jackson/databind/introspect/BeanPropertyDefinition;

    .line 156
    .local v1, "prop":Lcom/fasterxml/jackson/databind/introspect/BeanPropertyDefinition;
    invoke-virtual {v1}, Lcom/fasterxml/jackson/databind/introspect/BeanPropertyDefinition;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 157
    invoke-interface {v0}, Ljava/util/Iterator;->remove()V

    .line 158
    const/4 v2, 0x1

    .line 161
    .end local v1    # "prop":Lcom/fasterxml/jackson/databind/introspect/BeanPropertyDefinition;
    :goto_0
    return v2

    :cond_1
    const/4 v2, 0x0

    goto :goto_0
.end method

.method public resolveType(Ljava/lang/reflect/Type;)Lcom/fasterxml/jackson/databind/JavaType;
    .locals 1
    .param p1, "jdkType"    # Ljava/lang/reflect/Type;

    .prologue
    .line 215
    if-nez p1, :cond_0

    .line 216
    const/4 v0, 0x0

    .line 218
    :goto_0
    return-object v0

    :cond_0
    invoke-virtual {p0}, Lcom/fasterxml/jackson/databind/introspect/BasicBeanDescription;->bindingsForBeanType()Lcom/fasterxml/jackson/databind/type/TypeBindings;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/fasterxml/jackson/databind/type/TypeBindings;->resolveType(Ljava/lang/reflect/Type;)Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v0

    goto :goto_0
.end method
