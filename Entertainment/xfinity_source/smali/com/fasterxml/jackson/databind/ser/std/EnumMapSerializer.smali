.class public Lcom/fasterxml/jackson/databind/ser/std/EnumMapSerializer;
.super Lcom/fasterxml/jackson/databind/ser/ContainerSerializer;
.source "EnumMapSerializer.java"

# interfaces
.implements Lcom/fasterxml/jackson/databind/ser/ContextualSerializer;


# annotations
.annotation runtime Lcom/fasterxml/jackson/databind/annotation/JacksonStdImpl;
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/fasterxml/jackson/databind/ser/ContainerSerializer",
        "<",
        "Ljava/util/EnumMap",
        "<+",
        "Ljava/lang/Enum",
        "<*>;*>;>;",
        "Lcom/fasterxml/jackson/databind/ser/ContextualSerializer;"
    }
.end annotation


# instance fields
.field protected final _keyEnums:Lcom/fasterxml/jackson/databind/util/EnumValues;

.field protected final _property:Lcom/fasterxml/jackson/databind/BeanProperty;

.field protected final _staticTyping:Z

.field protected final _valueSerializer:Lcom/fasterxml/jackson/databind/JsonSerializer;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/fasterxml/jackson/databind/JsonSerializer",
            "<",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end field

.field protected final _valueType:Lcom/fasterxml/jackson/databind/JavaType;

.field protected final _valueTypeSerializer:Lcom/fasterxml/jackson/databind/jsontype/TypeSerializer;


# direct methods
.method public constructor <init>(Lcom/fasterxml/jackson/databind/JavaType;ZLcom/fasterxml/jackson/databind/util/EnumValues;Lcom/fasterxml/jackson/databind/jsontype/TypeSerializer;Lcom/fasterxml/jackson/databind/JsonSerializer;)V
    .locals 2
    .param p1, "valueType"    # Lcom/fasterxml/jackson/databind/JavaType;
    .param p2, "staticTyping"    # Z
    .param p3, "keyEnums"    # Lcom/fasterxml/jackson/databind/util/EnumValues;
    .param p4, "vts"    # Lcom/fasterxml/jackson/databind/jsontype/TypeSerializer;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/fasterxml/jackson/databind/JavaType;",
            "Z",
            "Lcom/fasterxml/jackson/databind/util/EnumValues;",
            "Lcom/fasterxml/jackson/databind/jsontype/TypeSerializer;",
            "Lcom/fasterxml/jackson/databind/JsonSerializer",
            "<",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p5, "valueSerializer":Lcom/fasterxml/jackson/databind/JsonSerializer;, "Lcom/fasterxml/jackson/databind/JsonSerializer<Ljava/lang/Object;>;"
    const/4 v0, 0x0

    .line 71
    const-class v1, Ljava/util/EnumMap;

    invoke-direct {p0, v1, v0}, Lcom/fasterxml/jackson/databind/ser/ContainerSerializer;-><init>(Ljava/lang/Class;Z)V

    .line 72
    const/4 v1, 0x0

    iput-object v1, p0, Lcom/fasterxml/jackson/databind/ser/std/EnumMapSerializer;->_property:Lcom/fasterxml/jackson/databind/BeanProperty;

    .line 73
    if-nez p2, :cond_0

    if-eqz p1, :cond_1

    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/JavaType;->isFinal()Z

    move-result v1

    if-eqz v1, :cond_1

    :cond_0
    const/4 v0, 0x1

    :cond_1
    iput-boolean v0, p0, Lcom/fasterxml/jackson/databind/ser/std/EnumMapSerializer;->_staticTyping:Z

    .line 74
    iput-object p1, p0, Lcom/fasterxml/jackson/databind/ser/std/EnumMapSerializer;->_valueType:Lcom/fasterxml/jackson/databind/JavaType;

    .line 75
    iput-object p3, p0, Lcom/fasterxml/jackson/databind/ser/std/EnumMapSerializer;->_keyEnums:Lcom/fasterxml/jackson/databind/util/EnumValues;

    .line 76
    iput-object p4, p0, Lcom/fasterxml/jackson/databind/ser/std/EnumMapSerializer;->_valueTypeSerializer:Lcom/fasterxml/jackson/databind/jsontype/TypeSerializer;

    .line 77
    iput-object p5, p0, Lcom/fasterxml/jackson/databind/ser/std/EnumMapSerializer;->_valueSerializer:Lcom/fasterxml/jackson/databind/JsonSerializer;

    .line 78
    return-void
.end method

.method public constructor <init>(Lcom/fasterxml/jackson/databind/ser/std/EnumMapSerializer;Lcom/fasterxml/jackson/databind/BeanProperty;Lcom/fasterxml/jackson/databind/JsonSerializer;)V
    .locals 1
    .param p1, "src"    # Lcom/fasterxml/jackson/databind/ser/std/EnumMapSerializer;
    .param p2, "property"    # Lcom/fasterxml/jackson/databind/BeanProperty;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/fasterxml/jackson/databind/ser/std/EnumMapSerializer;",
            "Lcom/fasterxml/jackson/databind/BeanProperty;",
            "Lcom/fasterxml/jackson/databind/JsonSerializer",
            "<*>;)V"
        }
    .end annotation

    .prologue
    .line 87
    .local p3, "ser":Lcom/fasterxml/jackson/databind/JsonSerializer;, "Lcom/fasterxml/jackson/databind/JsonSerializer<*>;"
    invoke-direct {p0, p1}, Lcom/fasterxml/jackson/databind/ser/ContainerSerializer;-><init>(Lcom/fasterxml/jackson/databind/ser/ContainerSerializer;)V

    .line 88
    iput-object p2, p0, Lcom/fasterxml/jackson/databind/ser/std/EnumMapSerializer;->_property:Lcom/fasterxml/jackson/databind/BeanProperty;

    .line 89
    iget-boolean v0, p1, Lcom/fasterxml/jackson/databind/ser/std/EnumMapSerializer;->_staticTyping:Z

    iput-boolean v0, p0, Lcom/fasterxml/jackson/databind/ser/std/EnumMapSerializer;->_staticTyping:Z

    .line 90
    iget-object v0, p1, Lcom/fasterxml/jackson/databind/ser/std/EnumMapSerializer;->_valueType:Lcom/fasterxml/jackson/databind/JavaType;

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/ser/std/EnumMapSerializer;->_valueType:Lcom/fasterxml/jackson/databind/JavaType;

    .line 91
    iget-object v0, p1, Lcom/fasterxml/jackson/databind/ser/std/EnumMapSerializer;->_keyEnums:Lcom/fasterxml/jackson/databind/util/EnumValues;

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/ser/std/EnumMapSerializer;->_keyEnums:Lcom/fasterxml/jackson/databind/util/EnumValues;

    .line 92
    iget-object v0, p1, Lcom/fasterxml/jackson/databind/ser/std/EnumMapSerializer;->_valueTypeSerializer:Lcom/fasterxml/jackson/databind/jsontype/TypeSerializer;

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/ser/std/EnumMapSerializer;->_valueTypeSerializer:Lcom/fasterxml/jackson/databind/jsontype/TypeSerializer;

    .line 93
    iput-object p3, p0, Lcom/fasterxml/jackson/databind/ser/std/EnumMapSerializer;->_valueSerializer:Lcom/fasterxml/jackson/databind/JsonSerializer;

    .line 94
    return-void
.end method


# virtual methods
.method public bridge synthetic _withValueTypeSerializer(Lcom/fasterxml/jackson/databind/jsontype/TypeSerializer;)Lcom/fasterxml/jackson/databind/ser/ContainerSerializer;
    .locals 1
    .param p1, "x0"    # Lcom/fasterxml/jackson/databind/jsontype/TypeSerializer;

    .prologue
    .line 31
    invoke-virtual {p0, p1}, Lcom/fasterxml/jackson/databind/ser/std/EnumMapSerializer;->_withValueTypeSerializer(Lcom/fasterxml/jackson/databind/jsontype/TypeSerializer;)Lcom/fasterxml/jackson/databind/ser/std/EnumMapSerializer;

    move-result-object v0

    return-object v0
.end method

.method public _withValueTypeSerializer(Lcom/fasterxml/jackson/databind/jsontype/TypeSerializer;)Lcom/fasterxml/jackson/databind/ser/std/EnumMapSerializer;
    .locals 6
    .param p1, "vts"    # Lcom/fasterxml/jackson/databind/jsontype/TypeSerializer;

    .prologue
    .line 98
    new-instance v0, Lcom/fasterxml/jackson/databind/ser/std/EnumMapSerializer;

    iget-object v1, p0, Lcom/fasterxml/jackson/databind/ser/std/EnumMapSerializer;->_valueType:Lcom/fasterxml/jackson/databind/JavaType;

    iget-boolean v2, p0, Lcom/fasterxml/jackson/databind/ser/std/EnumMapSerializer;->_staticTyping:Z

    iget-object v3, p0, Lcom/fasterxml/jackson/databind/ser/std/EnumMapSerializer;->_keyEnums:Lcom/fasterxml/jackson/databind/util/EnumValues;

    iget-object v5, p0, Lcom/fasterxml/jackson/databind/ser/std/EnumMapSerializer;->_valueSerializer:Lcom/fasterxml/jackson/databind/JsonSerializer;

    move-object v4, p1

    invoke-direct/range {v0 .. v5}, Lcom/fasterxml/jackson/databind/ser/std/EnumMapSerializer;-><init>(Lcom/fasterxml/jackson/databind/JavaType;ZLcom/fasterxml/jackson/databind/util/EnumValues;Lcom/fasterxml/jackson/databind/jsontype/TypeSerializer;Lcom/fasterxml/jackson/databind/JsonSerializer;)V

    return-object v0
.end method

.method public acceptJsonFormatVisitor(Lcom/fasterxml/jackson/databind/jsonFormatVisitors/JsonFormatVisitorWrapper;Lcom/fasterxml/jackson/databind/JavaType;)V
    .locals 9
    .param p1, "visitor"    # Lcom/fasterxml/jackson/databind/jsonFormatVisitors/JsonFormatVisitorWrapper;
    .param p2, "typeHint"    # Lcom/fasterxml/jackson/databind/JavaType;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/fasterxml/jackson/databind/JsonMappingException;
        }
    .end annotation

    .prologue
    .line 308
    invoke-interface {p1, p2}, Lcom/fasterxml/jackson/databind/jsonFormatVisitors/JsonFormatVisitorWrapper;->expectObjectFormat(Lcom/fasterxml/jackson/databind/JavaType;)Lcom/fasterxml/jackson/databind/jsonFormatVisitors/JsonObjectFormatVisitor;

    move-result-object v3

    .line 315
    .local v3, "objectVisitor":Lcom/fasterxml/jackson/databind/jsonFormatVisitors/JsonObjectFormatVisitor;
    const/4 v6, 0x1

    invoke-virtual {p2, v6}, Lcom/fasterxml/jackson/databind/JavaType;->containedType(I)Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v5

    .line 316
    .local v5, "valueType":Lcom/fasterxml/jackson/databind/JavaType;
    if-nez v5, :cond_0

    .line 317
    invoke-interface {p1}, Lcom/fasterxml/jackson/databind/jsonFormatVisitors/JsonFormatVisitorWrapper;->getProvider()Lcom/fasterxml/jackson/databind/SerializerProvider;

    move-result-object v6

    const-class v7, Ljava/lang/Object;

    invoke-virtual {v6, v7}, Lcom/fasterxml/jackson/databind/SerializerProvider;->constructType(Ljava/lang/reflect/Type;)Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v5

    .line 319
    :cond_0
    iget-object v4, p0, Lcom/fasterxml/jackson/databind/ser/std/EnumMapSerializer;->_valueSerializer:Lcom/fasterxml/jackson/databind/JsonSerializer;

    .line 321
    .local v4, "ser":Lcom/fasterxml/jackson/databind/JsonSerializer;, "Lcom/fasterxml/jackson/databind/JsonSerializer<Ljava/lang/Object;>;"
    iget-object v6, p0, Lcom/fasterxml/jackson/databind/ser/std/EnumMapSerializer;->_keyEnums:Lcom/fasterxml/jackson/databind/util/EnumValues;

    invoke-virtual {v6}, Lcom/fasterxml/jackson/databind/util/EnumValues;->internalMap()Ljava/util/EnumMap;

    move-result-object v6

    invoke-virtual {v6}, Ljava/util/EnumMap;->entrySet()Ljava/util/Set;

    move-result-object v6

    invoke-interface {v6}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_2

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 322
    .local v0, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<*Lcom/fasterxml/jackson/core/io/SerializedString;>;"
    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lcom/fasterxml/jackson/core/io/SerializedString;

    invoke-virtual {v6}, Lcom/fasterxml/jackson/core/io/SerializedString;->getValue()Ljava/lang/String;

    move-result-object v2

    .line 324
    .local v2, "name":Ljava/lang/String;
    if-nez v4, :cond_1

    .line 325
    invoke-interface {p1}, Lcom/fasterxml/jackson/databind/jsonFormatVisitors/JsonFormatVisitorWrapper;->getProvider()Lcom/fasterxml/jackson/databind/SerializerProvider;

    move-result-object v6

    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v7

    iget-object v8, p0, Lcom/fasterxml/jackson/databind/ser/std/EnumMapSerializer;->_property:Lcom/fasterxml/jackson/databind/BeanProperty;

    invoke-virtual {v6, v7, v8}, Lcom/fasterxml/jackson/databind/SerializerProvider;->findValueSerializer(Ljava/lang/Class;Lcom/fasterxml/jackson/databind/BeanProperty;)Lcom/fasterxml/jackson/databind/JsonSerializer;

    move-result-object v4

    .line 327
    :cond_1
    invoke-interface {v3, v2, v4, v5}, Lcom/fasterxml/jackson/databind/jsonFormatVisitors/JsonObjectFormatVisitor;->property(Ljava/lang/String;Lcom/fasterxml/jackson/databind/jsonFormatVisitors/JsonFormatVisitable;Lcom/fasterxml/jackson/databind/JavaType;)V

    goto :goto_0

    .line 329
    .end local v0    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<*Lcom/fasterxml/jackson/core/io/SerializedString;>;"
    .end local v2    # "name":Ljava/lang/String;
    :cond_2
    return-void
.end method

.method public createContextual(Lcom/fasterxml/jackson/databind/SerializerProvider;Lcom/fasterxml/jackson/databind/BeanProperty;)Lcom/fasterxml/jackson/databind/JsonSerializer;
    .locals 4
    .param p1, "provider"    # Lcom/fasterxml/jackson/databind/SerializerProvider;
    .param p2, "property"    # Lcom/fasterxml/jackson/databind/BeanProperty;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/fasterxml/jackson/databind/SerializerProvider;",
            "Lcom/fasterxml/jackson/databind/BeanProperty;",
            ")",
            "Lcom/fasterxml/jackson/databind/JsonSerializer",
            "<*>;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/fasterxml/jackson/databind/JsonMappingException;
        }
    .end annotation

    .prologue
    .line 117
    const/4 v1, 0x0

    .line 119
    .local v1, "ser":Lcom/fasterxml/jackson/databind/JsonSerializer;, "Lcom/fasterxml/jackson/databind/JsonSerializer<*>;"
    if-eqz p2, :cond_0

    .line 120
    invoke-interface {p2}, Lcom/fasterxml/jackson/databind/BeanProperty;->getMember()Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;

    move-result-object v0

    .line 121
    .local v0, "m":Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;
    if-eqz v0, :cond_0

    .line 122
    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/SerializerProvider;->getAnnotationIntrospector()Lcom/fasterxml/jackson/databind/AnnotationIntrospector;

    move-result-object v3

    invoke-virtual {v3, v0}, Lcom/fasterxml/jackson/databind/AnnotationIntrospector;->findContentSerializer(Lcom/fasterxml/jackson/databind/introspect/Annotated;)Ljava/lang/Object;

    move-result-object v2

    .line 123
    .local v2, "serDef":Ljava/lang/Object;
    if-eqz v2, :cond_0

    .line 124
    invoke-virtual {p1, v0, v2}, Lcom/fasterxml/jackson/databind/SerializerProvider;->serializerInstance(Lcom/fasterxml/jackson/databind/introspect/Annotated;Ljava/lang/Object;)Lcom/fasterxml/jackson/databind/JsonSerializer;

    move-result-object v1

    .line 128
    .end local v0    # "m":Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;
    .end local v2    # "serDef":Ljava/lang/Object;
    :cond_0
    if-nez v1, :cond_1

    .line 129
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/ser/std/EnumMapSerializer;->_valueSerializer:Lcom/fasterxml/jackson/databind/JsonSerializer;

    .line 131
    :cond_1
    if-nez v1, :cond_3

    .line 132
    iget-boolean v3, p0, Lcom/fasterxml/jackson/databind/ser/std/EnumMapSerializer;->_staticTyping:Z

    if-eqz v3, :cond_4

    .line 133
    iget-object v3, p0, Lcom/fasterxml/jackson/databind/ser/std/EnumMapSerializer;->_valueType:Lcom/fasterxml/jackson/databind/JavaType;

    invoke-virtual {p1, v3, p2}, Lcom/fasterxml/jackson/databind/SerializerProvider;->findValueSerializer(Lcom/fasterxml/jackson/databind/JavaType;Lcom/fasterxml/jackson/databind/BeanProperty;)Lcom/fasterxml/jackson/databind/JsonSerializer;

    move-result-object v3

    invoke-virtual {p0, p2, v3}, Lcom/fasterxml/jackson/databind/ser/std/EnumMapSerializer;->withValueSerializer(Lcom/fasterxml/jackson/databind/BeanProperty;Lcom/fasterxml/jackson/databind/JsonSerializer;)Lcom/fasterxml/jackson/databind/ser/std/EnumMapSerializer;

    move-result-object p0

    .line 141
    .end local p0    # "this":Lcom/fasterxml/jackson/databind/ser/std/EnumMapSerializer;
    :cond_2
    :goto_0
    return-object p0

    .line 135
    .restart local p0    # "this":Lcom/fasterxml/jackson/databind/ser/std/EnumMapSerializer;
    :cond_3
    iget-object v3, p0, Lcom/fasterxml/jackson/databind/ser/std/EnumMapSerializer;->_valueSerializer:Lcom/fasterxml/jackson/databind/JsonSerializer;

    instance-of v3, v3, Lcom/fasterxml/jackson/databind/ser/ContextualSerializer;

    if-eqz v3, :cond_4

    .line 136
    check-cast v1, Lcom/fasterxml/jackson/databind/ser/ContextualSerializer;

    .end local v1    # "ser":Lcom/fasterxml/jackson/databind/JsonSerializer;, "Lcom/fasterxml/jackson/databind/JsonSerializer<*>;"
    invoke-interface {v1, p1, p2}, Lcom/fasterxml/jackson/databind/ser/ContextualSerializer;->createContextual(Lcom/fasterxml/jackson/databind/SerializerProvider;Lcom/fasterxml/jackson/databind/BeanProperty;)Lcom/fasterxml/jackson/databind/JsonSerializer;

    move-result-object v1

    .line 138
    .restart local v1    # "ser":Lcom/fasterxml/jackson/databind/JsonSerializer;, "Lcom/fasterxml/jackson/databind/JsonSerializer<*>;"
    :cond_4
    iget-object v3, p0, Lcom/fasterxml/jackson/databind/ser/std/EnumMapSerializer;->_valueSerializer:Lcom/fasterxml/jackson/databind/JsonSerializer;

    if-eq v1, v3, :cond_2

    .line 139
    invoke-virtual {p0, p2, v1}, Lcom/fasterxml/jackson/databind/ser/std/EnumMapSerializer;->withValueSerializer(Lcom/fasterxml/jackson/databind/BeanProperty;Lcom/fasterxml/jackson/databind/JsonSerializer;)Lcom/fasterxml/jackson/databind/ser/std/EnumMapSerializer;

    move-result-object p0

    goto :goto_0
.end method

.method public getContentSerializer()Lcom/fasterxml/jackson/databind/JsonSerializer;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/fasterxml/jackson/databind/JsonSerializer",
            "<*>;"
        }
    .end annotation

    .prologue
    .line 157
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/ser/std/EnumMapSerializer;->_valueSerializer:Lcom/fasterxml/jackson/databind/JsonSerializer;

    return-object v0
.end method

.method public getContentType()Lcom/fasterxml/jackson/databind/JavaType;
    .locals 1

    .prologue
    .line 152
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/ser/std/EnumMapSerializer;->_valueType:Lcom/fasterxml/jackson/databind/JavaType;

    return-object v0
.end method

.method public getSchema(Lcom/fasterxml/jackson/databind/SerializerProvider;Ljava/lang/reflect/Type;)Lcom/fasterxml/jackson/databind/JsonNode;
    .locals 15
    .param p1, "provider"    # Lcom/fasterxml/jackson/databind/SerializerProvider;
    .param p2, "typeHint"    # Ljava/lang/reflect/Type;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/fasterxml/jackson/databind/JsonMappingException;
        }
    .end annotation

    .prologue
    .line 280
    const-string v13, "object"

    const/4 v14, 0x1

    invoke-virtual {p0, v13, v14}, Lcom/fasterxml/jackson/databind/ser/std/EnumMapSerializer;->createSchemaNode(Ljava/lang/String;Z)Lcom/fasterxml/jackson/databind/node/ObjectNode;

    move-result-object v7

    .line 281
    .local v7, "o":Lcom/fasterxml/jackson/databind/node/ObjectNode;
    move-object/from16 v0, p2

    instance-of v13, v0, Ljava/lang/reflect/ParameterizedType;

    if-eqz v13, :cond_2

    .line 282
    check-cast p2, Ljava/lang/reflect/ParameterizedType;

    .end local p2    # "typeHint":Ljava/lang/reflect/Type;
    invoke-interface/range {p2 .. p2}, Ljava/lang/reflect/ParameterizedType;->getActualTypeArguments()[Ljava/lang/reflect/Type;

    move-result-object v11

    .line 283
    .local v11, "typeArgs":[Ljava/lang/reflect/Type;
    array-length v13, v11

    const/4 v14, 0x2

    if-ne v13, v14, :cond_2

    .line 284
    const/4 v13, 0x0

    aget-object v13, v11, v13

    move-object/from16 v0, p1

    invoke-virtual {v0, v13}, Lcom/fasterxml/jackson/databind/SerializerProvider;->constructType(Ljava/lang/reflect/Type;)Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v3

    .line 285
    .local v3, "enumType":Lcom/fasterxml/jackson/databind/JavaType;
    const/4 v13, 0x1

    aget-object v13, v11, v13

    move-object/from16 v0, p1

    invoke-virtual {v0, v13}, Lcom/fasterxml/jackson/databind/SerializerProvider;->constructType(Ljava/lang/reflect/Type;)Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v12

    .line 286
    .local v12, "valueType":Lcom/fasterxml/jackson/databind/JavaType;
    sget-object v13, Lcom/fasterxml/jackson/databind/node/JsonNodeFactory;->instance:Lcom/fasterxml/jackson/databind/node/JsonNodeFactory;

    invoke-virtual {v13}, Lcom/fasterxml/jackson/databind/node/JsonNodeFactory;->objectNode()Lcom/fasterxml/jackson/databind/node/ObjectNode;

    move-result-object v8

    .line 287
    .local v8, "propsNode":Lcom/fasterxml/jackson/databind/node/ObjectNode;
    invoke-virtual {v3}, Lcom/fasterxml/jackson/databind/JavaType;->getRawClass()Ljava/lang/Class;

    move-result-object v2

    .line 288
    .local v2, "enumClass":Ljava/lang/Class;, "Ljava/lang/Class<Ljava/lang/Enum<*>;>;"
    invoke-virtual {v2}, Ljava/lang/Class;->getEnumConstants()[Ljava/lang/Object;

    move-result-object v1

    check-cast v1, [Ljava/lang/Enum;

    .local v1, "arr$":[Ljava/lang/Enum;
    array-length v6, v1

    .local v6, "len$":I
    const/4 v5, 0x0

    .local v5, "i$":I
    :goto_0
    if-ge v5, v6, :cond_1

    aget-object v4, v1, v5

    .line 289
    .local v4, "enumValue":Ljava/lang/Enum;, "Ljava/lang/Enum<*>;"
    invoke-virtual {v12}, Lcom/fasterxml/jackson/databind/JavaType;->getRawClass()Ljava/lang/Class;

    move-result-object v13

    iget-object v14, p0, Lcom/fasterxml/jackson/databind/ser/std/EnumMapSerializer;->_property:Lcom/fasterxml/jackson/databind/BeanProperty;

    move-object/from16 v0, p1

    invoke-virtual {v0, v13, v14}, Lcom/fasterxml/jackson/databind/SerializerProvider;->findValueSerializer(Ljava/lang/Class;Lcom/fasterxml/jackson/databind/BeanProperty;)Lcom/fasterxml/jackson/databind/JsonSerializer;

    move-result-object v10

    .line 290
    .local v10, "ser":Lcom/fasterxml/jackson/databind/JsonSerializer;, "Lcom/fasterxml/jackson/databind/JsonSerializer<Ljava/lang/Object;>;"
    instance-of v13, v10, Lcom/fasterxml/jackson/databind/jsonschema/SchemaAware;

    if-eqz v13, :cond_0

    check-cast v10, Lcom/fasterxml/jackson/databind/jsonschema/SchemaAware;

    .end local v10    # "ser":Lcom/fasterxml/jackson/databind/JsonSerializer;, "Lcom/fasterxml/jackson/databind/JsonSerializer<Ljava/lang/Object;>;"
    const/4 v13, 0x0

    move-object/from16 v0, p1

    invoke-interface {v10, v0, v13}, Lcom/fasterxml/jackson/databind/jsonschema/SchemaAware;->getSchema(Lcom/fasterxml/jackson/databind/SerializerProvider;Ljava/lang/reflect/Type;)Lcom/fasterxml/jackson/databind/JsonNode;

    move-result-object v9

    .line 293
    .local v9, "schemaNode":Lcom/fasterxml/jackson/databind/JsonNode;
    :goto_1
    invoke-virtual/range {p1 .. p1}, Lcom/fasterxml/jackson/databind/SerializerProvider;->getConfig()Lcom/fasterxml/jackson/databind/SerializationConfig;

    move-result-object v13

    invoke-virtual {v13}, Lcom/fasterxml/jackson/databind/SerializationConfig;->getAnnotationIntrospector()Lcom/fasterxml/jackson/databind/AnnotationIntrospector;

    move-result-object v13

    invoke-virtual {v13, v4}, Lcom/fasterxml/jackson/databind/AnnotationIntrospector;->findEnumValue(Ljava/lang/Enum;)Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v8, v13, v9}, Lcom/fasterxml/jackson/databind/node/ObjectNode;->put(Ljava/lang/String;Lcom/fasterxml/jackson/databind/JsonNode;)Lcom/fasterxml/jackson/databind/JsonNode;

    .line 288
    add-int/lit8 v5, v5, 0x1

    goto :goto_0

    .line 290
    .end local v9    # "schemaNode":Lcom/fasterxml/jackson/databind/JsonNode;
    .restart local v10    # "ser":Lcom/fasterxml/jackson/databind/JsonSerializer;, "Lcom/fasterxml/jackson/databind/JsonSerializer<Ljava/lang/Object;>;"
    :cond_0
    invoke-static {}, Lcom/fasterxml/jackson/databind/jsonschema/JsonSchema;->getDefaultSchemaNode()Lcom/fasterxml/jackson/databind/JsonNode;

    move-result-object v9

    goto :goto_1

    .line 295
    .end local v4    # "enumValue":Ljava/lang/Enum;, "Ljava/lang/Enum<*>;"
    .end local v10    # "ser":Lcom/fasterxml/jackson/databind/JsonSerializer;, "Lcom/fasterxml/jackson/databind/JsonSerializer<Ljava/lang/Object;>;"
    :cond_1
    const-string v13, "properties"

    invoke-virtual {v7, v13, v8}, Lcom/fasterxml/jackson/databind/node/ObjectNode;->put(Ljava/lang/String;Lcom/fasterxml/jackson/databind/JsonNode;)Lcom/fasterxml/jackson/databind/JsonNode;

    .line 298
    .end local v1    # "arr$":[Ljava/lang/Enum;
    .end local v2    # "enumClass":Ljava/lang/Class;, "Ljava/lang/Class<Ljava/lang/Enum<*>;>;"
    .end local v3    # "enumType":Lcom/fasterxml/jackson/databind/JavaType;
    .end local v5    # "i$":I
    .end local v6    # "len$":I
    .end local v8    # "propsNode":Lcom/fasterxml/jackson/databind/node/ObjectNode;
    .end local v11    # "typeArgs":[Ljava/lang/reflect/Type;
    .end local v12    # "valueType":Lcom/fasterxml/jackson/databind/JavaType;
    :cond_2
    return-object v7
.end method

.method public bridge synthetic hasSingleElement(Ljava/lang/Object;)Z
    .locals 1
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 31
    check-cast p1, Ljava/util/EnumMap;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/fasterxml/jackson/databind/ser/std/EnumMapSerializer;->hasSingleElement(Ljava/util/EnumMap;)Z

    move-result v0

    return v0
.end method

.method public hasSingleElement(Ljava/util/EnumMap;)Z
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/EnumMap",
            "<+",
            "Ljava/lang/Enum",
            "<*>;*>;)Z"
        }
    .end annotation

    .prologue
    .local p1, "value":Ljava/util/EnumMap;, "Ljava/util/EnumMap<+Ljava/lang/Enum<*>;*>;"
    const/4 v0, 0x1

    .line 167
    invoke-virtual {p1}, Ljava/util/EnumMap;->size()I

    move-result v1

    if-ne v1, v0, :cond_0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public bridge synthetic isEmpty(Ljava/lang/Object;)Z
    .locals 1
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 31
    check-cast p1, Ljava/util/EnumMap;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/fasterxml/jackson/databind/ser/std/EnumMapSerializer;->isEmpty(Ljava/util/EnumMap;)Z

    move-result v0

    return v0
.end method

.method public isEmpty(Ljava/util/EnumMap;)Z
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/EnumMap",
            "<+",
            "Ljava/lang/Enum",
            "<*>;*>;)Z"
        }
    .end annotation

    .prologue
    .line 162
    .local p1, "value":Ljava/util/EnumMap;, "Ljava/util/EnumMap<+Ljava/lang/Enum<*>;*>;"
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/util/EnumMap;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public bridge synthetic serialize(Ljava/lang/Object;Lcom/fasterxml/jackson/core/JsonGenerator;Lcom/fasterxml/jackson/databind/SerializerProvider;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;
    .param p2, "x1"    # Lcom/fasterxml/jackson/core/JsonGenerator;
    .param p3, "x2"    # Lcom/fasterxml/jackson/databind/SerializerProvider;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonGenerationException;
        }
    .end annotation

    .prologue
    .line 31
    check-cast p1, Ljava/util/EnumMap;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2, p3}, Lcom/fasterxml/jackson/databind/ser/std/EnumMapSerializer;->serialize(Ljava/util/EnumMap;Lcom/fasterxml/jackson/core/JsonGenerator;Lcom/fasterxml/jackson/databind/SerializerProvider;)V

    return-void
.end method

.method public serialize(Ljava/util/EnumMap;Lcom/fasterxml/jackson/core/JsonGenerator;Lcom/fasterxml/jackson/databind/SerializerProvider;)V
    .locals 1
    .param p2, "jgen"    # Lcom/fasterxml/jackson/core/JsonGenerator;
    .param p3, "provider"    # Lcom/fasterxml/jackson/databind/SerializerProvider;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/EnumMap",
            "<+",
            "Ljava/lang/Enum",
            "<*>;*>;",
            "Lcom/fasterxml/jackson/core/JsonGenerator;",
            "Lcom/fasterxml/jackson/databind/SerializerProvider;",
            ")V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonGenerationException;
        }
    .end annotation

    .prologue
    .line 180
    .local p1, "value":Ljava/util/EnumMap;, "Ljava/util/EnumMap<+Ljava/lang/Enum<*>;*>;"
    invoke-virtual {p2}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeStartObject()V

    .line 181
    invoke-virtual {p1}, Ljava/util/EnumMap;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    .line 182
    invoke-virtual {p0, p1, p2, p3}, Lcom/fasterxml/jackson/databind/ser/std/EnumMapSerializer;->serializeContents(Ljava/util/EnumMap;Lcom/fasterxml/jackson/core/JsonGenerator;Lcom/fasterxml/jackson/databind/SerializerProvider;)V

    .line 184
    :cond_0
    invoke-virtual {p2}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeEndObject()V

    .line 185
    return-void
.end method

.method protected serializeContents(Ljava/util/EnumMap;Lcom/fasterxml/jackson/core/JsonGenerator;Lcom/fasterxml/jackson/databind/SerializerProvider;)V
    .locals 17
    .param p2, "jgen"    # Lcom/fasterxml/jackson/core/JsonGenerator;
    .param p3, "provider"    # Lcom/fasterxml/jackson/databind/SerializerProvider;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/EnumMap",
            "<+",
            "Ljava/lang/Enum",
            "<*>;*>;",
            "Lcom/fasterxml/jackson/core/JsonGenerator;",
            "Lcom/fasterxml/jackson/databind/SerializerProvider;",
            ")V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonGenerationException;
        }
    .end annotation

    .prologue
    .line 202
    .local p1, "value":Ljava/util/EnumMap;, "Ljava/util/EnumMap<+Ljava/lang/Enum<*>;*>;"
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/fasterxml/jackson/databind/ser/std/EnumMapSerializer;->_valueSerializer:Lcom/fasterxml/jackson/databind/JsonSerializer;

    if-eqz v15, :cond_1

    .line 203
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/fasterxml/jackson/databind/ser/std/EnumMapSerializer;->_valueSerializer:Lcom/fasterxml/jackson/databind/JsonSerializer;

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move-object/from16 v2, p2

    move-object/from16 v3, p3

    invoke-virtual {v0, v1, v2, v3, v15}, Lcom/fasterxml/jackson/databind/ser/std/EnumMapSerializer;->serializeContentsUsing(Ljava/util/EnumMap;Lcom/fasterxml/jackson/core/JsonGenerator;Lcom/fasterxml/jackson/databind/SerializerProvider;Lcom/fasterxml/jackson/databind/JsonSerializer;)V

    .line 246
    :cond_0
    return-void

    .line 206
    :cond_1
    const/4 v12, 0x0

    .line 207
    .local v12, "prevSerializer":Lcom/fasterxml/jackson/databind/JsonSerializer;, "Lcom/fasterxml/jackson/databind/JsonSerializer<Ljava/lang/Object;>;"
    const/4 v11, 0x0

    .line 208
    .local v11, "prevClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    move-object/from16 v0, p0

    iget-object v10, v0, Lcom/fasterxml/jackson/databind/ser/std/EnumMapSerializer;->_keyEnums:Lcom/fasterxml/jackson/databind/util/EnumValues;

    .line 210
    .local v10, "keyEnums":Lcom/fasterxml/jackson/databind/util/EnumValues;
    invoke-virtual/range {p1 .. p1}, Ljava/util/EnumMap;->entrySet()Ljava/util/Set;

    move-result-object v15

    invoke-interface {v15}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v8

    .local v8, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v8}, Ljava/util/Iterator;->hasNext()Z

    move-result v15

    if-eqz v15, :cond_0

    invoke-interface {v8}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/util/Map$Entry;

    .line 212
    .local v7, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<+Ljava/lang/Enum<*>;*>;"
    invoke-interface {v7}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/lang/Enum;

    .line 213
    .local v9, "key":Ljava/lang/Enum;, "Ljava/lang/Enum<*>;"
    if-nez v10, :cond_2

    .line 219
    invoke-virtual {v9}, Ljava/lang/Enum;->getDeclaringClass()Ljava/lang/Class;

    move-result-object v15

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/fasterxml/jackson/databind/ser/std/EnumMapSerializer;->_property:Lcom/fasterxml/jackson/databind/BeanProperty;

    move-object/from16 v16, v0

    move-object/from16 v0, p3

    move-object/from16 v1, v16

    invoke-virtual {v0, v15, v1}, Lcom/fasterxml/jackson/databind/SerializerProvider;->findValueSerializer(Ljava/lang/Class;Lcom/fasterxml/jackson/databind/BeanProperty;)Lcom/fasterxml/jackson/databind/JsonSerializer;

    move-result-object v13

    check-cast v13, Lcom/fasterxml/jackson/databind/ser/std/StdSerializer;

    .line 221
    .local v13, "ser":Lcom/fasterxml/jackson/databind/ser/std/StdSerializer;, "Lcom/fasterxml/jackson/databind/ser/std/StdSerializer<*>;"
    check-cast v13, Lcom/fasterxml/jackson/databind/ser/std/EnumSerializer;

    .end local v13    # "ser":Lcom/fasterxml/jackson/databind/ser/std/StdSerializer;, "Lcom/fasterxml/jackson/databind/ser/std/StdSerializer<*>;"
    invoke-virtual {v13}, Lcom/fasterxml/jackson/databind/ser/std/EnumSerializer;->getEnumValues()Lcom/fasterxml/jackson/databind/util/EnumValues;

    move-result-object v10

    .line 223
    :cond_2
    invoke-virtual {v10, v9}, Lcom/fasterxml/jackson/databind/util/EnumValues;->serializedValueFor(Ljava/lang/Enum;)Lcom/fasterxml/jackson/core/io/SerializedString;

    move-result-object v15

    move-object/from16 v0, p2

    invoke-virtual {v0, v15}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeFieldName(Lcom/fasterxml/jackson/core/SerializableString;)V

    .line 225
    invoke-interface {v7}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v14

    .line 226
    .local v14, "valueElem":Ljava/lang/Object;
    if-nez v14, :cond_3

    .line 227
    move-object/from16 v0, p3

    move-object/from16 v1, p2

    invoke-virtual {v0, v1}, Lcom/fasterxml/jackson/databind/SerializerProvider;->defaultSerializeNull(Lcom/fasterxml/jackson/core/JsonGenerator;)V

    goto :goto_0

    .line 229
    :cond_3
    invoke-virtual {v14}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    .line 231
    .local v4, "cc":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    if-ne v4, v11, :cond_4

    .line 232
    move-object v5, v12

    .line 239
    .local v5, "currSerializer":Lcom/fasterxml/jackson/databind/JsonSerializer;, "Lcom/fasterxml/jackson/databind/JsonSerializer<Ljava/lang/Object;>;"
    :goto_1
    :try_start_0
    move-object/from16 v0, p2

    move-object/from16 v1, p3

    invoke-virtual {v5, v14, v0, v1}, Lcom/fasterxml/jackson/databind/JsonSerializer;->serialize(Ljava/lang/Object;Lcom/fasterxml/jackson/core/JsonGenerator;Lcom/fasterxml/jackson/databind/SerializerProvider;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 240
    :catch_0
    move-exception v6

    .line 242
    .local v6, "e":Ljava/lang/Exception;
    invoke-interface {v7}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v15

    check-cast v15, Ljava/lang/Enum;

    invoke-virtual {v15}, Ljava/lang/Enum;->name()Ljava/lang/String;

    move-result-object v15

    move-object/from16 v0, p0

    move-object/from16 v1, p3

    move-object/from16 v2, p1

    invoke-virtual {v0, v1, v6, v2, v15}, Lcom/fasterxml/jackson/databind/ser/std/EnumMapSerializer;->wrapAndThrow(Lcom/fasterxml/jackson/databind/SerializerProvider;Ljava/lang/Throwable;Ljava/lang/Object;Ljava/lang/String;)V

    goto :goto_0

    .line 234
    .end local v5    # "currSerializer":Lcom/fasterxml/jackson/databind/JsonSerializer;, "Lcom/fasterxml/jackson/databind/JsonSerializer<Ljava/lang/Object;>;"
    .end local v6    # "e":Ljava/lang/Exception;
    :cond_4
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/fasterxml/jackson/databind/ser/std/EnumMapSerializer;->_property:Lcom/fasterxml/jackson/databind/BeanProperty;

    move-object/from16 v0, p3

    invoke-virtual {v0, v4, v15}, Lcom/fasterxml/jackson/databind/SerializerProvider;->findValueSerializer(Ljava/lang/Class;Lcom/fasterxml/jackson/databind/BeanProperty;)Lcom/fasterxml/jackson/databind/JsonSerializer;

    move-result-object v5

    .line 235
    .restart local v5    # "currSerializer":Lcom/fasterxml/jackson/databind/JsonSerializer;, "Lcom/fasterxml/jackson/databind/JsonSerializer<Ljava/lang/Object;>;"
    move-object v12, v5

    .line 236
    move-object v11, v4

    goto :goto_1
.end method

.method protected serializeContentsUsing(Ljava/util/EnumMap;Lcom/fasterxml/jackson/core/JsonGenerator;Lcom/fasterxml/jackson/databind/SerializerProvider;Lcom/fasterxml/jackson/databind/JsonSerializer;)V
    .locals 9
    .param p2, "jgen"    # Lcom/fasterxml/jackson/core/JsonGenerator;
    .param p3, "provider"    # Lcom/fasterxml/jackson/databind/SerializerProvider;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/EnumMap",
            "<+",
            "Ljava/lang/Enum",
            "<*>;*>;",
            "Lcom/fasterxml/jackson/core/JsonGenerator;",
            "Lcom/fasterxml/jackson/databind/SerializerProvider;",
            "Lcom/fasterxml/jackson/databind/JsonSerializer",
            "<",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonGenerationException;
        }
    .end annotation

    .prologue
    .line 252
    .local p1, "value":Ljava/util/EnumMap;, "Ljava/util/EnumMap<+Ljava/lang/Enum<*>;*>;"
    .local p4, "valueSer":Lcom/fasterxml/jackson/databind/JsonSerializer;, "Lcom/fasterxml/jackson/databind/JsonSerializer<Ljava/lang/Object;>;"
    iget-object v4, p0, Lcom/fasterxml/jackson/databind/ser/std/EnumMapSerializer;->_keyEnums:Lcom/fasterxml/jackson/databind/util/EnumValues;

    .line 253
    .local v4, "keyEnums":Lcom/fasterxml/jackson/databind/util/EnumValues;
    invoke-virtual {p1}, Ljava/util/EnumMap;->entrySet()Ljava/util/Set;

    move-result-object v7

    invoke-interface {v7}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_2

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/Map$Entry;

    .line 254
    .local v1, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<+Ljava/lang/Enum<*>;*>;"
    invoke-interface {v1}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Enum;

    .line 255
    .local v3, "key":Ljava/lang/Enum;, "Ljava/lang/Enum<*>;"
    if-nez v4, :cond_0

    .line 257
    invoke-virtual {v3}, Ljava/lang/Enum;->getDeclaringClass()Ljava/lang/Class;

    move-result-object v7

    iget-object v8, p0, Lcom/fasterxml/jackson/databind/ser/std/EnumMapSerializer;->_property:Lcom/fasterxml/jackson/databind/BeanProperty;

    invoke-virtual {p3, v7, v8}, Lcom/fasterxml/jackson/databind/SerializerProvider;->findValueSerializer(Ljava/lang/Class;Lcom/fasterxml/jackson/databind/BeanProperty;)Lcom/fasterxml/jackson/databind/JsonSerializer;

    move-result-object v5

    check-cast v5, Lcom/fasterxml/jackson/databind/ser/std/StdSerializer;

    .line 259
    .local v5, "ser":Lcom/fasterxml/jackson/databind/ser/std/StdSerializer;, "Lcom/fasterxml/jackson/databind/ser/std/StdSerializer<*>;"
    check-cast v5, Lcom/fasterxml/jackson/databind/ser/std/EnumSerializer;

    .end local v5    # "ser":Lcom/fasterxml/jackson/databind/ser/std/StdSerializer;, "Lcom/fasterxml/jackson/databind/ser/std/StdSerializer<*>;"
    invoke-virtual {v5}, Lcom/fasterxml/jackson/databind/ser/std/EnumSerializer;->getEnumValues()Lcom/fasterxml/jackson/databind/util/EnumValues;

    move-result-object v4

    .line 261
    :cond_0
    invoke-virtual {v4, v3}, Lcom/fasterxml/jackson/databind/util/EnumValues;->serializedValueFor(Ljava/lang/Enum;)Lcom/fasterxml/jackson/core/io/SerializedString;

    move-result-object v7

    invoke-virtual {p2, v7}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeFieldName(Lcom/fasterxml/jackson/core/SerializableString;)V

    .line 262
    invoke-interface {v1}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v6

    .line 263
    .local v6, "valueElem":Ljava/lang/Object;
    if-nez v6, :cond_1

    .line 264
    invoke-virtual {p3, p2}, Lcom/fasterxml/jackson/databind/SerializerProvider;->defaultSerializeNull(Lcom/fasterxml/jackson/core/JsonGenerator;)V

    goto :goto_0

    .line 267
    :cond_1
    :try_start_0
    invoke-virtual {p4, v6, p2, p3}, Lcom/fasterxml/jackson/databind/JsonSerializer;->serialize(Ljava/lang/Object;Lcom/fasterxml/jackson/core/JsonGenerator;Lcom/fasterxml/jackson/databind/SerializerProvider;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 268
    :catch_0
    move-exception v0

    .line 269
    .local v0, "e":Ljava/lang/Exception;
    invoke-interface {v1}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/lang/Enum;

    invoke-virtual {v7}, Ljava/lang/Enum;->name()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {p0, p3, v0, p1, v7}, Lcom/fasterxml/jackson/databind/ser/std/EnumMapSerializer;->wrapAndThrow(Lcom/fasterxml/jackson/databind/SerializerProvider;Ljava/lang/Throwable;Ljava/lang/Object;Ljava/lang/String;)V

    goto :goto_0

    .line 273
    .end local v0    # "e":Ljava/lang/Exception;
    .end local v1    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<+Ljava/lang/Enum<*>;*>;"
    .end local v3    # "key":Ljava/lang/Enum;, "Ljava/lang/Enum<*>;"
    .end local v6    # "valueElem":Ljava/lang/Object;
    :cond_2
    return-void
.end method

.method public bridge synthetic serializeWithType(Ljava/lang/Object;Lcom/fasterxml/jackson/core/JsonGenerator;Lcom/fasterxml/jackson/databind/SerializerProvider;Lcom/fasterxml/jackson/databind/jsontype/TypeSerializer;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;
    .param p2, "x1"    # Lcom/fasterxml/jackson/core/JsonGenerator;
    .param p3, "x2"    # Lcom/fasterxml/jackson/databind/SerializerProvider;
    .param p4, "x3"    # Lcom/fasterxml/jackson/databind/jsontype/TypeSerializer;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonProcessingException;
        }
    .end annotation

    .prologue
    .line 31
    check-cast p1, Ljava/util/EnumMap;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2, p3, p4}, Lcom/fasterxml/jackson/databind/ser/std/EnumMapSerializer;->serializeWithType(Ljava/util/EnumMap;Lcom/fasterxml/jackson/core/JsonGenerator;Lcom/fasterxml/jackson/databind/SerializerProvider;Lcom/fasterxml/jackson/databind/jsontype/TypeSerializer;)V

    return-void
.end method

.method public serializeWithType(Ljava/util/EnumMap;Lcom/fasterxml/jackson/core/JsonGenerator;Lcom/fasterxml/jackson/databind/SerializerProvider;Lcom/fasterxml/jackson/databind/jsontype/TypeSerializer;)V
    .locals 1
    .param p2, "jgen"    # Lcom/fasterxml/jackson/core/JsonGenerator;
    .param p3, "provider"    # Lcom/fasterxml/jackson/databind/SerializerProvider;
    .param p4, "typeSer"    # Lcom/fasterxml/jackson/databind/jsontype/TypeSerializer;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/EnumMap",
            "<+",
            "Ljava/lang/Enum",
            "<*>;*>;",
            "Lcom/fasterxml/jackson/core/JsonGenerator;",
            "Lcom/fasterxml/jackson/databind/SerializerProvider;",
            "Lcom/fasterxml/jackson/databind/jsontype/TypeSerializer;",
            ")V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonGenerationException;
        }
    .end annotation

    .prologue
    .line 192
    .local p1, "value":Ljava/util/EnumMap;, "Ljava/util/EnumMap<+Ljava/lang/Enum<*>;*>;"
    invoke-virtual {p4, p1, p2}, Lcom/fasterxml/jackson/databind/jsontype/TypeSerializer;->writeTypePrefixForObject(Ljava/lang/Object;Lcom/fasterxml/jackson/core/JsonGenerator;)V

    .line 193
    invoke-virtual {p1}, Ljava/util/EnumMap;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    .line 194
    invoke-virtual {p0, p1, p2, p3}, Lcom/fasterxml/jackson/databind/ser/std/EnumMapSerializer;->serializeContents(Ljava/util/EnumMap;Lcom/fasterxml/jackson/core/JsonGenerator;Lcom/fasterxml/jackson/databind/SerializerProvider;)V

    .line 196
    :cond_0
    invoke-virtual {p4, p1, p2}, Lcom/fasterxml/jackson/databind/jsontype/TypeSerializer;->writeTypeSuffixForObject(Ljava/lang/Object;Lcom/fasterxml/jackson/core/JsonGenerator;)V

    .line 197
    return-void
.end method

.method public withValueSerializer(Lcom/fasterxml/jackson/databind/BeanProperty;Lcom/fasterxml/jackson/databind/JsonSerializer;)Lcom/fasterxml/jackson/databind/ser/std/EnumMapSerializer;
    .locals 1
    .param p1, "prop"    # Lcom/fasterxml/jackson/databind/BeanProperty;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/fasterxml/jackson/databind/BeanProperty;",
            "Lcom/fasterxml/jackson/databind/JsonSerializer",
            "<*>;)",
            "Lcom/fasterxml/jackson/databind/ser/std/EnumMapSerializer;"
        }
    .end annotation

    .prologue
    .line 102
    .local p2, "ser":Lcom/fasterxml/jackson/databind/JsonSerializer;, "Lcom/fasterxml/jackson/databind/JsonSerializer<*>;"
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/ser/std/EnumMapSerializer;->_property:Lcom/fasterxml/jackson/databind/BeanProperty;

    if-ne v0, p1, :cond_0

    iget-object v0, p0, Lcom/fasterxml/jackson/databind/ser/std/EnumMapSerializer;->_valueSerializer:Lcom/fasterxml/jackson/databind/JsonSerializer;

    if-ne p2, v0, :cond_0

    .line 105
    .end local p0    # "this":Lcom/fasterxml/jackson/databind/ser/std/EnumMapSerializer;
    :goto_0
    return-object p0

    .restart local p0    # "this":Lcom/fasterxml/jackson/databind/ser/std/EnumMapSerializer;
    :cond_0
    new-instance v0, Lcom/fasterxml/jackson/databind/ser/std/EnumMapSerializer;

    invoke-direct {v0, p0, p1, p2}, Lcom/fasterxml/jackson/databind/ser/std/EnumMapSerializer;-><init>(Lcom/fasterxml/jackson/databind/ser/std/EnumMapSerializer;Lcom/fasterxml/jackson/databind/BeanProperty;Lcom/fasterxml/jackson/databind/JsonSerializer;)V

    move-object p0, v0

    goto :goto_0
.end method
