.class public Lcom/fasterxml/jackson/databind/ser/std/ObjectArraySerializer;
.super Lcom/fasterxml/jackson/databind/ser/std/ArraySerializerBase;
.source "ObjectArraySerializer.java"

# interfaces
.implements Lcom/fasterxml/jackson/databind/ser/ContextualSerializer;


# annotations
.annotation runtime Lcom/fasterxml/jackson/databind/annotation/JacksonStdImpl;
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/fasterxml/jackson/databind/ser/std/ArraySerializerBase",
        "<[",
        "Ljava/lang/Object;",
        ">;",
        "Lcom/fasterxml/jackson/databind/ser/ContextualSerializer;"
    }
.end annotation


# instance fields
.field protected _dynamicSerializers:Lcom/fasterxml/jackson/databind/ser/impl/PropertySerializerMap;

.field protected _elementSerializer:Lcom/fasterxml/jackson/databind/JsonSerializer;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/fasterxml/jackson/databind/JsonSerializer",
            "<",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end field

.field protected final _elementType:Lcom/fasterxml/jackson/databind/JavaType;

.field protected final _staticTyping:Z

.field protected final _valueTypeSerializer:Lcom/fasterxml/jackson/databind/jsontype/TypeSerializer;


# direct methods
.method public constructor <init>(Lcom/fasterxml/jackson/databind/JavaType;ZLcom/fasterxml/jackson/databind/jsontype/TypeSerializer;Lcom/fasterxml/jackson/databind/JsonSerializer;)V
    .locals 2
    .param p1, "elemType"    # Lcom/fasterxml/jackson/databind/JavaType;
    .param p2, "staticTyping"    # Z
    .param p3, "vts"    # Lcom/fasterxml/jackson/databind/jsontype/TypeSerializer;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/fasterxml/jackson/databind/JavaType;",
            "Z",
            "Lcom/fasterxml/jackson/databind/jsontype/TypeSerializer;",
            "Lcom/fasterxml/jackson/databind/JsonSerializer",
            "<",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 66
    .local p4, "elementSerializer":Lcom/fasterxml/jackson/databind/JsonSerializer;, "Lcom/fasterxml/jackson/databind/JsonSerializer<Ljava/lang/Object;>;"
    const-class v0, [Ljava/lang/Object;

    const/4 v1, 0x0

    invoke-direct {p0, v0, v1}, Lcom/fasterxml/jackson/databind/ser/std/ArraySerializerBase;-><init>(Ljava/lang/Class;Lcom/fasterxml/jackson/databind/BeanProperty;)V

    .line 67
    iput-object p1, p0, Lcom/fasterxml/jackson/databind/ser/std/ObjectArraySerializer;->_elementType:Lcom/fasterxml/jackson/databind/JavaType;

    .line 68
    iput-boolean p2, p0, Lcom/fasterxml/jackson/databind/ser/std/ObjectArraySerializer;->_staticTyping:Z

    .line 69
    iput-object p3, p0, Lcom/fasterxml/jackson/databind/ser/std/ObjectArraySerializer;->_valueTypeSerializer:Lcom/fasterxml/jackson/databind/jsontype/TypeSerializer;

    .line 70
    invoke-static {}, Lcom/fasterxml/jackson/databind/ser/impl/PropertySerializerMap;->emptyMap()Lcom/fasterxml/jackson/databind/ser/impl/PropertySerializerMap;

    move-result-object v0

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/ser/std/ObjectArraySerializer;->_dynamicSerializers:Lcom/fasterxml/jackson/databind/ser/impl/PropertySerializerMap;

    .line 71
    iput-object p4, p0, Lcom/fasterxml/jackson/databind/ser/std/ObjectArraySerializer;->_elementSerializer:Lcom/fasterxml/jackson/databind/JsonSerializer;

    .line 72
    return-void
.end method

.method public constructor <init>(Lcom/fasterxml/jackson/databind/ser/std/ObjectArraySerializer;Lcom/fasterxml/jackson/databind/BeanProperty;Lcom/fasterxml/jackson/databind/jsontype/TypeSerializer;Lcom/fasterxml/jackson/databind/JsonSerializer;)V
    .locals 1
    .param p1, "src"    # Lcom/fasterxml/jackson/databind/ser/std/ObjectArraySerializer;
    .param p2, "property"    # Lcom/fasterxml/jackson/databind/BeanProperty;
    .param p3, "vts"    # Lcom/fasterxml/jackson/databind/jsontype/TypeSerializer;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/fasterxml/jackson/databind/ser/std/ObjectArraySerializer;",
            "Lcom/fasterxml/jackson/databind/BeanProperty;",
            "Lcom/fasterxml/jackson/databind/jsontype/TypeSerializer;",
            "Lcom/fasterxml/jackson/databind/JsonSerializer",
            "<*>;)V"
        }
    .end annotation

    .prologue
    .line 88
    .local p4, "elementSerializer":Lcom/fasterxml/jackson/databind/JsonSerializer;, "Lcom/fasterxml/jackson/databind/JsonSerializer<*>;"
    invoke-direct {p0, p1, p2}, Lcom/fasterxml/jackson/databind/ser/std/ArraySerializerBase;-><init>(Lcom/fasterxml/jackson/databind/ser/std/ArraySerializerBase;Lcom/fasterxml/jackson/databind/BeanProperty;)V

    .line 89
    iget-object v0, p1, Lcom/fasterxml/jackson/databind/ser/std/ObjectArraySerializer;->_elementType:Lcom/fasterxml/jackson/databind/JavaType;

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/ser/std/ObjectArraySerializer;->_elementType:Lcom/fasterxml/jackson/databind/JavaType;

    .line 90
    iput-object p3, p0, Lcom/fasterxml/jackson/databind/ser/std/ObjectArraySerializer;->_valueTypeSerializer:Lcom/fasterxml/jackson/databind/jsontype/TypeSerializer;

    .line 91
    iget-boolean v0, p1, Lcom/fasterxml/jackson/databind/ser/std/ObjectArraySerializer;->_staticTyping:Z

    iput-boolean v0, p0, Lcom/fasterxml/jackson/databind/ser/std/ObjectArraySerializer;->_staticTyping:Z

    .line 92
    iget-object v0, p1, Lcom/fasterxml/jackson/databind/ser/std/ObjectArraySerializer;->_dynamicSerializers:Lcom/fasterxml/jackson/databind/ser/impl/PropertySerializerMap;

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/ser/std/ObjectArraySerializer;->_dynamicSerializers:Lcom/fasterxml/jackson/databind/ser/impl/PropertySerializerMap;

    .line 93
    iput-object p4, p0, Lcom/fasterxml/jackson/databind/ser/std/ObjectArraySerializer;->_elementSerializer:Lcom/fasterxml/jackson/databind/JsonSerializer;

    .line 94
    return-void
.end method

.method public constructor <init>(Lcom/fasterxml/jackson/databind/ser/std/ObjectArraySerializer;Lcom/fasterxml/jackson/databind/jsontype/TypeSerializer;)V
    .locals 1
    .param p1, "src"    # Lcom/fasterxml/jackson/databind/ser/std/ObjectArraySerializer;
    .param p2, "vts"    # Lcom/fasterxml/jackson/databind/jsontype/TypeSerializer;

    .prologue
    .line 76
    invoke-direct {p0, p1}, Lcom/fasterxml/jackson/databind/ser/std/ArraySerializerBase;-><init>(Lcom/fasterxml/jackson/databind/ser/std/ArraySerializerBase;)V

    .line 77
    iget-object v0, p1, Lcom/fasterxml/jackson/databind/ser/std/ObjectArraySerializer;->_elementType:Lcom/fasterxml/jackson/databind/JavaType;

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/ser/std/ObjectArraySerializer;->_elementType:Lcom/fasterxml/jackson/databind/JavaType;

    .line 78
    iput-object p2, p0, Lcom/fasterxml/jackson/databind/ser/std/ObjectArraySerializer;->_valueTypeSerializer:Lcom/fasterxml/jackson/databind/jsontype/TypeSerializer;

    .line 79
    iget-boolean v0, p1, Lcom/fasterxml/jackson/databind/ser/std/ObjectArraySerializer;->_staticTyping:Z

    iput-boolean v0, p0, Lcom/fasterxml/jackson/databind/ser/std/ObjectArraySerializer;->_staticTyping:Z

    .line 80
    iget-object v0, p1, Lcom/fasterxml/jackson/databind/ser/std/ObjectArraySerializer;->_dynamicSerializers:Lcom/fasterxml/jackson/databind/ser/impl/PropertySerializerMap;

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/ser/std/ObjectArraySerializer;->_dynamicSerializers:Lcom/fasterxml/jackson/databind/ser/impl/PropertySerializerMap;

    .line 81
    iget-object v0, p1, Lcom/fasterxml/jackson/databind/ser/std/ObjectArraySerializer;->_elementSerializer:Lcom/fasterxml/jackson/databind/JsonSerializer;

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/ser/std/ObjectArraySerializer;->_elementSerializer:Lcom/fasterxml/jackson/databind/JsonSerializer;

    .line 82
    return-void
.end method


# virtual methods
.method protected final _findAndAddDynamic(Lcom/fasterxml/jackson/databind/ser/impl/PropertySerializerMap;Lcom/fasterxml/jackson/databind/JavaType;Lcom/fasterxml/jackson/databind/SerializerProvider;)Lcom/fasterxml/jackson/databind/JsonSerializer;
    .locals 2
    .param p1, "map"    # Lcom/fasterxml/jackson/databind/ser/impl/PropertySerializerMap;
    .param p2, "type"    # Lcom/fasterxml/jackson/databind/JavaType;
    .param p3, "provider"    # Lcom/fasterxml/jackson/databind/SerializerProvider;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/fasterxml/jackson/databind/ser/impl/PropertySerializerMap;",
            "Lcom/fasterxml/jackson/databind/JavaType;",
            "Lcom/fasterxml/jackson/databind/SerializerProvider;",
            ")",
            "Lcom/fasterxml/jackson/databind/JsonSerializer",
            "<",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/fasterxml/jackson/databind/JsonMappingException;
        }
    .end annotation

    .prologue
    .line 363
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/ser/std/ObjectArraySerializer;->_property:Lcom/fasterxml/jackson/databind/BeanProperty;

    invoke-virtual {p1, p2, p3, v1}, Lcom/fasterxml/jackson/databind/ser/impl/PropertySerializerMap;->findAndAddSerializer(Lcom/fasterxml/jackson/databind/JavaType;Lcom/fasterxml/jackson/databind/SerializerProvider;Lcom/fasterxml/jackson/databind/BeanProperty;)Lcom/fasterxml/jackson/databind/ser/impl/PropertySerializerMap$SerializerAndMapResult;

    move-result-object v0

    .line 365
    .local v0, "result":Lcom/fasterxml/jackson/databind/ser/impl/PropertySerializerMap$SerializerAndMapResult;
    iget-object v1, v0, Lcom/fasterxml/jackson/databind/ser/impl/PropertySerializerMap$SerializerAndMapResult;->map:Lcom/fasterxml/jackson/databind/ser/impl/PropertySerializerMap;

    if-eq p1, v1, :cond_0

    .line 366
    iget-object v1, v0, Lcom/fasterxml/jackson/databind/ser/impl/PropertySerializerMap$SerializerAndMapResult;->map:Lcom/fasterxml/jackson/databind/ser/impl/PropertySerializerMap;

    iput-object v1, p0, Lcom/fasterxml/jackson/databind/ser/std/ObjectArraySerializer;->_dynamicSerializers:Lcom/fasterxml/jackson/databind/ser/impl/PropertySerializerMap;

    .line 368
    :cond_0
    iget-object v1, v0, Lcom/fasterxml/jackson/databind/ser/impl/PropertySerializerMap$SerializerAndMapResult;->serializer:Lcom/fasterxml/jackson/databind/JsonSerializer;

    return-object v1
.end method

.method protected final _findAndAddDynamic(Lcom/fasterxml/jackson/databind/ser/impl/PropertySerializerMap;Ljava/lang/Class;Lcom/fasterxml/jackson/databind/SerializerProvider;)Lcom/fasterxml/jackson/databind/JsonSerializer;
    .locals 2
    .param p1, "map"    # Lcom/fasterxml/jackson/databind/ser/impl/PropertySerializerMap;
    .param p3, "provider"    # Lcom/fasterxml/jackson/databind/SerializerProvider;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/fasterxml/jackson/databind/ser/impl/PropertySerializerMap;",
            "Ljava/lang/Class",
            "<*>;",
            "Lcom/fasterxml/jackson/databind/SerializerProvider;",
            ")",
            "Lcom/fasterxml/jackson/databind/JsonSerializer",
            "<",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/fasterxml/jackson/databind/JsonMappingException;
        }
    .end annotation

    .prologue
    .line 352
    .local p2, "type":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/ser/std/ObjectArraySerializer;->_property:Lcom/fasterxml/jackson/databind/BeanProperty;

    invoke-virtual {p1, p2, p3, v1}, Lcom/fasterxml/jackson/databind/ser/impl/PropertySerializerMap;->findAndAddSerializer(Ljava/lang/Class;Lcom/fasterxml/jackson/databind/SerializerProvider;Lcom/fasterxml/jackson/databind/BeanProperty;)Lcom/fasterxml/jackson/databind/ser/impl/PropertySerializerMap$SerializerAndMapResult;

    move-result-object v0

    .line 354
    .local v0, "result":Lcom/fasterxml/jackson/databind/ser/impl/PropertySerializerMap$SerializerAndMapResult;
    iget-object v1, v0, Lcom/fasterxml/jackson/databind/ser/impl/PropertySerializerMap$SerializerAndMapResult;->map:Lcom/fasterxml/jackson/databind/ser/impl/PropertySerializerMap;

    if-eq p1, v1, :cond_0

    .line 355
    iget-object v1, v0, Lcom/fasterxml/jackson/databind/ser/impl/PropertySerializerMap$SerializerAndMapResult;->map:Lcom/fasterxml/jackson/databind/ser/impl/PropertySerializerMap;

    iput-object v1, p0, Lcom/fasterxml/jackson/databind/ser/std/ObjectArraySerializer;->_dynamicSerializers:Lcom/fasterxml/jackson/databind/ser/impl/PropertySerializerMap;

    .line 357
    :cond_0
    iget-object v1, v0, Lcom/fasterxml/jackson/databind/ser/impl/PropertySerializerMap$SerializerAndMapResult;->serializer:Lcom/fasterxml/jackson/databind/JsonSerializer;

    return-object v1
.end method

.method public _withValueTypeSerializer(Lcom/fasterxml/jackson/databind/jsontype/TypeSerializer;)Lcom/fasterxml/jackson/databind/ser/ContainerSerializer;
    .locals 4
    .param p1, "vts"    # Lcom/fasterxml/jackson/databind/jsontype/TypeSerializer;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/fasterxml/jackson/databind/jsontype/TypeSerializer;",
            ")",
            "Lcom/fasterxml/jackson/databind/ser/ContainerSerializer",
            "<*>;"
        }
    .end annotation

    .prologue
    .line 99
    new-instance v0, Lcom/fasterxml/jackson/databind/ser/std/ObjectArraySerializer;

    iget-object v1, p0, Lcom/fasterxml/jackson/databind/ser/std/ObjectArraySerializer;->_elementType:Lcom/fasterxml/jackson/databind/JavaType;

    iget-boolean v2, p0, Lcom/fasterxml/jackson/databind/ser/std/ObjectArraySerializer;->_staticTyping:Z

    iget-object v3, p0, Lcom/fasterxml/jackson/databind/ser/std/ObjectArraySerializer;->_elementSerializer:Lcom/fasterxml/jackson/databind/JsonSerializer;

    invoke-direct {v0, v1, v2, p1, v3}, Lcom/fasterxml/jackson/databind/ser/std/ObjectArraySerializer;-><init>(Lcom/fasterxml/jackson/databind/JavaType;ZLcom/fasterxml/jackson/databind/jsontype/TypeSerializer;Lcom/fasterxml/jackson/databind/JsonSerializer;)V

    return-object v0
.end method

.method public acceptJsonFormatVisitor(Lcom/fasterxml/jackson/databind/jsonFormatVisitors/JsonFormatVisitorWrapper;Lcom/fasterxml/jackson/databind/JavaType;)V
    .locals 2
    .param p1, "visitor"    # Lcom/fasterxml/jackson/databind/jsonFormatVisitors/JsonFormatVisitorWrapper;
    .param p2, "typeHint"    # Lcom/fasterxml/jackson/databind/JavaType;

    .prologue
    .line 346
    invoke-interface {p1, p2}, Lcom/fasterxml/jackson/databind/jsonFormatVisitors/JsonFormatVisitorWrapper;->expectArrayFormat(Lcom/fasterxml/jackson/databind/JavaType;)Lcom/fasterxml/jackson/databind/jsonFormatVisitors/JsonArrayFormatVisitor;

    move-result-object v0

    iget-object v1, p0, Lcom/fasterxml/jackson/databind/ser/std/ObjectArraySerializer;->_elementType:Lcom/fasterxml/jackson/databind/JavaType;

    invoke-interface {v0, v1}, Lcom/fasterxml/jackson/databind/jsonFormatVisitors/JsonArrayFormatVisitor;->itemsFormat(Lcom/fasterxml/jackson/databind/JavaType;)V

    .line 347
    return-void
.end method

.method public createContextual(Lcom/fasterxml/jackson/databind/SerializerProvider;Lcom/fasterxml/jackson/databind/BeanProperty;)Lcom/fasterxml/jackson/databind/JsonSerializer;
    .locals 5
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
    .line 121
    iget-object v3, p0, Lcom/fasterxml/jackson/databind/ser/std/ObjectArraySerializer;->_valueTypeSerializer:Lcom/fasterxml/jackson/databind/jsontype/TypeSerializer;

    .line 122
    .local v3, "vts":Lcom/fasterxml/jackson/databind/jsontype/TypeSerializer;
    if-eqz v3, :cond_0

    .line 123
    invoke-virtual {v3, p2}, Lcom/fasterxml/jackson/databind/jsontype/TypeSerializer;->forProperty(Lcom/fasterxml/jackson/databind/BeanProperty;)Lcom/fasterxml/jackson/databind/jsontype/TypeSerializer;

    move-result-object v3

    .line 129
    :cond_0
    const/4 v1, 0x0

    .line 131
    .local v1, "ser":Lcom/fasterxml/jackson/databind/JsonSerializer;, "Lcom/fasterxml/jackson/databind/JsonSerializer<*>;"
    if-eqz p2, :cond_1

    .line 132
    invoke-interface {p2}, Lcom/fasterxml/jackson/databind/BeanProperty;->getMember()Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;

    move-result-object v0

    .line 133
    .local v0, "m":Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;
    if-eqz v0, :cond_1

    .line 134
    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/SerializerProvider;->getAnnotationIntrospector()Lcom/fasterxml/jackson/databind/AnnotationIntrospector;

    move-result-object v4

    invoke-virtual {v4, v0}, Lcom/fasterxml/jackson/databind/AnnotationIntrospector;->findContentSerializer(Lcom/fasterxml/jackson/databind/introspect/Annotated;)Ljava/lang/Object;

    move-result-object v2

    .line 135
    .local v2, "serDef":Ljava/lang/Object;
    if-eqz v2, :cond_1

    .line 136
    invoke-virtual {p1, v0, v2}, Lcom/fasterxml/jackson/databind/SerializerProvider;->serializerInstance(Lcom/fasterxml/jackson/databind/introspect/Annotated;Ljava/lang/Object;)Lcom/fasterxml/jackson/databind/JsonSerializer;

    move-result-object v1

    .line 140
    .end local v0    # "m":Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;
    .end local v2    # "serDef":Ljava/lang/Object;
    :cond_1
    if-nez v1, :cond_2

    .line 141
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/ser/std/ObjectArraySerializer;->_elementSerializer:Lcom/fasterxml/jackson/databind/JsonSerializer;

    .line 143
    :cond_2
    if-nez v1, :cond_5

    .line 146
    iget-object v4, p0, Lcom/fasterxml/jackson/databind/ser/std/ObjectArraySerializer;->_elementType:Lcom/fasterxml/jackson/databind/JavaType;

    if-eqz v4, :cond_4

    .line 147
    iget-boolean v4, p0, Lcom/fasterxml/jackson/databind/ser/std/ObjectArraySerializer;->_staticTyping:Z

    if-nez v4, :cond_3

    invoke-virtual {p0, p1, p2}, Lcom/fasterxml/jackson/databind/ser/std/ObjectArraySerializer;->hasContentTypeAnnotation(Lcom/fasterxml/jackson/databind/SerializerProvider;Lcom/fasterxml/jackson/databind/BeanProperty;)Z

    move-result v4

    if-eqz v4, :cond_4

    .line 148
    :cond_3
    iget-object v4, p0, Lcom/fasterxml/jackson/databind/ser/std/ObjectArraySerializer;->_elementType:Lcom/fasterxml/jackson/databind/JavaType;

    invoke-virtual {p1, v4, p2}, Lcom/fasterxml/jackson/databind/SerializerProvider;->findValueSerializer(Lcom/fasterxml/jackson/databind/JavaType;Lcom/fasterxml/jackson/databind/BeanProperty;)Lcom/fasterxml/jackson/databind/JsonSerializer;

    move-result-object v1

    .line 154
    :cond_4
    :goto_0
    invoke-virtual {p0, p2, v3, v1}, Lcom/fasterxml/jackson/databind/ser/std/ObjectArraySerializer;->withResolved(Lcom/fasterxml/jackson/databind/BeanProperty;Lcom/fasterxml/jackson/databind/jsontype/TypeSerializer;Lcom/fasterxml/jackson/databind/JsonSerializer;)Lcom/fasterxml/jackson/databind/ser/std/ObjectArraySerializer;

    move-result-object v4

    return-object v4

    .line 151
    :cond_5
    instance-of v4, v1, Lcom/fasterxml/jackson/databind/ser/ContextualSerializer;

    if-eqz v4, :cond_4

    .line 152
    iget-object v4, p0, Lcom/fasterxml/jackson/databind/ser/std/ObjectArraySerializer;->_elementSerializer:Lcom/fasterxml/jackson/databind/JsonSerializer;

    check-cast v4, Lcom/fasterxml/jackson/databind/ser/ContextualSerializer;

    invoke-interface {v4, p1, p2}, Lcom/fasterxml/jackson/databind/ser/ContextualSerializer;->createContextual(Lcom/fasterxml/jackson/databind/SerializerProvider;Lcom/fasterxml/jackson/databind/BeanProperty;)Lcom/fasterxml/jackson/databind/JsonSerializer;

    move-result-object v1

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
    .line 170
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/ser/std/ObjectArraySerializer;->_elementSerializer:Lcom/fasterxml/jackson/databind/JsonSerializer;

    return-object v0
.end method

.method public getContentType()Lcom/fasterxml/jackson/databind/JavaType;
    .locals 1

    .prologue
    .line 165
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/ser/std/ObjectArraySerializer;->_elementType:Lcom/fasterxml/jackson/databind/JavaType;

    return-object v0
.end method

.method public getSchema(Lcom/fasterxml/jackson/databind/SerializerProvider;Ljava/lang/reflect/Type;)Lcom/fasterxml/jackson/databind/JsonNode;
    .locals 7
    .param p1, "provider"    # Lcom/fasterxml/jackson/databind/SerializerProvider;
    .param p2, "typeHint"    # Ljava/lang/reflect/Type;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/fasterxml/jackson/databind/JsonMappingException;
        }
    .end annotation

    .prologue
    .line 323
    const-string v5, "array"

    const/4 v6, 0x1

    invoke-virtual {p0, v5, v6}, Lcom/fasterxml/jackson/databind/ser/std/ObjectArraySerializer;->createSchemaNode(Ljava/lang/String;Z)Lcom/fasterxml/jackson/databind/node/ObjectNode;

    move-result-object v2

    .line 324
    .local v2, "o":Lcom/fasterxml/jackson/databind/node/ObjectNode;
    if-eqz p2, :cond_0

    .line 325
    invoke-virtual {p1, p2}, Lcom/fasterxml/jackson/databind/SerializerProvider;->constructType(Ljava/lang/reflect/Type;)Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v1

    .line 326
    .local v1, "javaType":Lcom/fasterxml/jackson/databind/JavaType;
    invoke-virtual {v1}, Lcom/fasterxml/jackson/databind/JavaType;->isArrayType()Z

    move-result v5

    if-eqz v5, :cond_0

    .line 327
    check-cast v1, Lcom/fasterxml/jackson/databind/type/ArrayType;

    .end local v1    # "javaType":Lcom/fasterxml/jackson/databind/JavaType;
    invoke-virtual {v1}, Lcom/fasterxml/jackson/databind/type/ArrayType;->getContentType()Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v5

    invoke-virtual {v5}, Lcom/fasterxml/jackson/databind/JavaType;->getRawClass()Ljava/lang/Class;

    move-result-object v0

    .line 329
    .local v0, "componentType":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    const-class v5, Ljava/lang/Object;

    if-ne v0, v5, :cond_1

    .line 330
    const-string v5, "items"

    invoke-static {}, Lcom/fasterxml/jackson/databind/jsonschema/JsonSchema;->getDefaultSchemaNode()Lcom/fasterxml/jackson/databind/JsonNode;

    move-result-object v6

    invoke-virtual {v2, v5, v6}, Lcom/fasterxml/jackson/databind/node/ObjectNode;->put(Ljava/lang/String;Lcom/fasterxml/jackson/databind/JsonNode;)Lcom/fasterxml/jackson/databind/JsonNode;

    .line 340
    .end local v0    # "componentType":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    :cond_0
    :goto_0
    return-object v2

    .line 332
    .restart local v0    # "componentType":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    :cond_1
    iget-object v5, p0, Lcom/fasterxml/jackson/databind/ser/std/ObjectArraySerializer;->_property:Lcom/fasterxml/jackson/databind/BeanProperty;

    invoke-virtual {p1, v0, v5}, Lcom/fasterxml/jackson/databind/SerializerProvider;->findValueSerializer(Ljava/lang/Class;Lcom/fasterxml/jackson/databind/BeanProperty;)Lcom/fasterxml/jackson/databind/JsonSerializer;

    move-result-object v4

    .line 333
    .local v4, "ser":Lcom/fasterxml/jackson/databind/JsonSerializer;, "Lcom/fasterxml/jackson/databind/JsonSerializer<Ljava/lang/Object;>;"
    instance-of v5, v4, Lcom/fasterxml/jackson/databind/jsonschema/SchemaAware;

    if-eqz v5, :cond_2

    check-cast v4, Lcom/fasterxml/jackson/databind/jsonschema/SchemaAware;

    .end local v4    # "ser":Lcom/fasterxml/jackson/databind/JsonSerializer;, "Lcom/fasterxml/jackson/databind/JsonSerializer<Ljava/lang/Object;>;"
    const/4 v5, 0x0

    invoke-interface {v4, p1, v5}, Lcom/fasterxml/jackson/databind/jsonschema/SchemaAware;->getSchema(Lcom/fasterxml/jackson/databind/SerializerProvider;Ljava/lang/reflect/Type;)Lcom/fasterxml/jackson/databind/JsonNode;

    move-result-object v3

    .line 336
    .local v3, "schemaNode":Lcom/fasterxml/jackson/databind/JsonNode;
    :goto_1
    const-string v5, "items"

    invoke-virtual {v2, v5, v3}, Lcom/fasterxml/jackson/databind/node/ObjectNode;->put(Ljava/lang/String;Lcom/fasterxml/jackson/databind/JsonNode;)Lcom/fasterxml/jackson/databind/JsonNode;

    goto :goto_0

    .line 333
    .end local v3    # "schemaNode":Lcom/fasterxml/jackson/databind/JsonNode;
    .restart local v4    # "ser":Lcom/fasterxml/jackson/databind/JsonSerializer;, "Lcom/fasterxml/jackson/databind/JsonSerializer<Ljava/lang/Object;>;"
    :cond_2
    invoke-static {}, Lcom/fasterxml/jackson/databind/jsonschema/JsonSchema;->getDefaultSchemaNode()Lcom/fasterxml/jackson/databind/JsonNode;

    move-result-object v3

    goto :goto_1
.end method

.method public bridge synthetic hasSingleElement(Ljava/lang/Object;)Z
    .locals 1
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 25
    check-cast p1, [Ljava/lang/Object;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/fasterxml/jackson/databind/ser/std/ObjectArraySerializer;->hasSingleElement([Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public hasSingleElement([Ljava/lang/Object;)Z
    .locals 2
    .param p1, "value"    # [Ljava/lang/Object;

    .prologue
    const/4 v0, 0x1

    .line 180
    array-length v1, p1

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
    .line 25
    check-cast p1, [Ljava/lang/Object;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/fasterxml/jackson/databind/ser/std/ObjectArraySerializer;->isEmpty([Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public isEmpty([Ljava/lang/Object;)Z
    .locals 1
    .param p1, "value"    # [Ljava/lang/Object;

    .prologue
    .line 175
    if-eqz p1, :cond_0

    array-length v0, p1

    if-nez v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public bridge synthetic serializeContents(Ljava/lang/Object;Lcom/fasterxml/jackson/core/JsonGenerator;Lcom/fasterxml/jackson/databind/SerializerProvider;)V
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
    .line 25
    check-cast p1, [Ljava/lang/Object;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2, p3}, Lcom/fasterxml/jackson/databind/ser/std/ObjectArraySerializer;->serializeContents([Ljava/lang/Object;Lcom/fasterxml/jackson/core/JsonGenerator;Lcom/fasterxml/jackson/databind/SerializerProvider;)V

    return-void
.end method

.method public serializeContents([Ljava/lang/Object;Lcom/fasterxml/jackson/core/JsonGenerator;Lcom/fasterxml/jackson/databind/SerializerProvider;)V
    .locals 10
    .param p1, "value"    # [Ljava/lang/Object;
    .param p2, "jgen"    # Lcom/fasterxml/jackson/core/JsonGenerator;
    .param p3, "provider"    # Lcom/fasterxml/jackson/databind/SerializerProvider;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonGenerationException;
        }
    .end annotation

    .prologue
    .line 193
    array-length v5, p1

    .line 194
    .local v5, "len":I
    if-nez v5, :cond_1

    .line 245
    :cond_0
    :goto_0
    return-void

    .line 197
    :cond_1
    iget-object v9, p0, Lcom/fasterxml/jackson/databind/ser/std/ObjectArraySerializer;->_elementSerializer:Lcom/fasterxml/jackson/databind/JsonSerializer;

    if-eqz v9, :cond_2

    .line 198
    iget-object v9, p0, Lcom/fasterxml/jackson/databind/ser/std/ObjectArraySerializer;->_elementSerializer:Lcom/fasterxml/jackson/databind/JsonSerializer;

    invoke-virtual {p0, p1, p2, p3, v9}, Lcom/fasterxml/jackson/databind/ser/std/ObjectArraySerializer;->serializeContentsUsing([Ljava/lang/Object;Lcom/fasterxml/jackson/core/JsonGenerator;Lcom/fasterxml/jackson/databind/SerializerProvider;Lcom/fasterxml/jackson/databind/JsonSerializer;)V

    goto :goto_0

    .line 201
    :cond_2
    iget-object v9, p0, Lcom/fasterxml/jackson/databind/ser/std/ObjectArraySerializer;->_valueTypeSerializer:Lcom/fasterxml/jackson/databind/jsontype/TypeSerializer;

    if-eqz v9, :cond_3

    .line 202
    invoke-virtual {p0, p1, p2, p3}, Lcom/fasterxml/jackson/databind/ser/std/ObjectArraySerializer;->serializeTypedContents([Ljava/lang/Object;Lcom/fasterxml/jackson/core/JsonGenerator;Lcom/fasterxml/jackson/databind/SerializerProvider;)V

    goto :goto_0

    .line 205
    :cond_3
    const/4 v3, 0x0

    .line 206
    .local v3, "i":I
    const/4 v2, 0x0

    .line 208
    .local v2, "elem":Ljava/lang/Object;
    :try_start_0
    iget-object v7, p0, Lcom/fasterxml/jackson/databind/ser/std/ObjectArraySerializer;->_dynamicSerializers:Lcom/fasterxml/jackson/databind/ser/impl/PropertySerializerMap;

    .line 209
    .end local v2    # "elem":Ljava/lang/Object;
    .local v7, "serializers":Lcom/fasterxml/jackson/databind/ser/impl/PropertySerializerMap;
    :goto_1
    if-ge v3, v5, :cond_0

    .line 210
    aget-object v2, p1, v3

    .line 211
    .restart local v2    # "elem":Ljava/lang/Object;
    if-nez v2, :cond_4

    .line 212
    invoke-virtual {p3, p2}, Lcom/fasterxml/jackson/databind/SerializerProvider;->defaultSerializeNull(Lcom/fasterxml/jackson/core/JsonGenerator;)V

    .line 209
    :goto_2
    add-int/lit8 v3, v3, 0x1

    goto :goto_1

    .line 215
    :cond_4
    invoke-virtual {v2}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    .line 216
    .local v0, "cc":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-virtual {v7, v0}, Lcom/fasterxml/jackson/databind/ser/impl/PropertySerializerMap;->serializerFor(Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/JsonSerializer;

    move-result-object v6

    .line 217
    .local v6, "serializer":Lcom/fasterxml/jackson/databind/JsonSerializer;, "Lcom/fasterxml/jackson/databind/JsonSerializer<Ljava/lang/Object;>;"
    if-nez v6, :cond_5

    .line 219
    iget-object v9, p0, Lcom/fasterxml/jackson/databind/ser/std/ObjectArraySerializer;->_elementType:Lcom/fasterxml/jackson/databind/JavaType;

    invoke-virtual {v9}, Lcom/fasterxml/jackson/databind/JavaType;->hasGenericTypes()Z

    move-result v9

    if-eqz v9, :cond_6

    .line 220
    iget-object v9, p0, Lcom/fasterxml/jackson/databind/ser/std/ObjectArraySerializer;->_elementType:Lcom/fasterxml/jackson/databind/JavaType;

    invoke-virtual {p3, v9, v0}, Lcom/fasterxml/jackson/databind/SerializerProvider;->constructSpecializedType(Lcom/fasterxml/jackson/databind/JavaType;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v9

    invoke-virtual {p0, v7, v9, p3}, Lcom/fasterxml/jackson/databind/ser/std/ObjectArraySerializer;->_findAndAddDynamic(Lcom/fasterxml/jackson/databind/ser/impl/PropertySerializerMap;Lcom/fasterxml/jackson/databind/JavaType;Lcom/fasterxml/jackson/databind/SerializerProvider;)Lcom/fasterxml/jackson/databind/JsonSerializer;

    move-result-object v6

    .line 226
    :cond_5
    :goto_3
    invoke-virtual {v6, v2, p2, p3}, Lcom/fasterxml/jackson/databind/JsonSerializer;->serialize(Ljava/lang/Object;Lcom/fasterxml/jackson/core/JsonGenerator;Lcom/fasterxml/jackson/databind/SerializerProvider;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    goto :goto_2

    .line 228
    .end local v0    # "cc":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .end local v2    # "elem":Ljava/lang/Object;
    .end local v6    # "serializer":Lcom/fasterxml/jackson/databind/JsonSerializer;, "Lcom/fasterxml/jackson/databind/JsonSerializer<Ljava/lang/Object;>;"
    .end local v7    # "serializers":Lcom/fasterxml/jackson/databind/ser/impl/PropertySerializerMap;
    :catch_0
    move-exception v4

    .line 229
    .local v4, "ioe":Ljava/io/IOException;
    throw v4

    .line 223
    .end local v4    # "ioe":Ljava/io/IOException;
    .restart local v0    # "cc":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .restart local v2    # "elem":Ljava/lang/Object;
    .restart local v6    # "serializer":Lcom/fasterxml/jackson/databind/JsonSerializer;, "Lcom/fasterxml/jackson/databind/JsonSerializer<Ljava/lang/Object;>;"
    .restart local v7    # "serializers":Lcom/fasterxml/jackson/databind/ser/impl/PropertySerializerMap;
    :cond_6
    :try_start_1
    invoke-virtual {p0, v7, v0, p3}, Lcom/fasterxml/jackson/databind/ser/std/ObjectArraySerializer;->_findAndAddDynamic(Lcom/fasterxml/jackson/databind/ser/impl/PropertySerializerMap;Ljava/lang/Class;Lcom/fasterxml/jackson/databind/SerializerProvider;)Lcom/fasterxml/jackson/databind/JsonSerializer;
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    move-result-object v6

    goto :goto_3

    .line 230
    .end local v0    # "cc":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .end local v2    # "elem":Ljava/lang/Object;
    .end local v6    # "serializer":Lcom/fasterxml/jackson/databind/JsonSerializer;, "Lcom/fasterxml/jackson/databind/JsonSerializer<Ljava/lang/Object;>;"
    .end local v7    # "serializers":Lcom/fasterxml/jackson/databind/ser/impl/PropertySerializerMap;
    :catch_1
    move-exception v1

    .line 236
    .local v1, "e":Ljava/lang/Exception;
    move-object v8, v1

    .line 237
    .local v8, "t":Ljava/lang/Throwable;
    :goto_4
    instance-of v9, v8, Ljava/lang/reflect/InvocationTargetException;

    if-eqz v9, :cond_7

    invoke-virtual {v8}, Ljava/lang/Throwable;->getCause()Ljava/lang/Throwable;

    move-result-object v9

    if-eqz v9, :cond_7

    .line 238
    invoke-virtual {v8}, Ljava/lang/Throwable;->getCause()Ljava/lang/Throwable;

    move-result-object v8

    goto :goto_4

    .line 240
    :cond_7
    instance-of v9, v8, Ljava/lang/Error;

    if-eqz v9, :cond_8

    .line 241
    check-cast v8, Ljava/lang/Error;

    .end local v8    # "t":Ljava/lang/Throwable;
    throw v8

    .line 243
    .restart local v8    # "t":Ljava/lang/Throwable;
    :cond_8
    invoke-static {v8, v2, v3}, Lcom/fasterxml/jackson/databind/JsonMappingException;->wrapWithPath(Ljava/lang/Throwable;Ljava/lang/Object;I)Lcom/fasterxml/jackson/databind/JsonMappingException;

    move-result-object v9

    throw v9
.end method

.method public serializeContentsUsing([Ljava/lang/Object;Lcom/fasterxml/jackson/core/JsonGenerator;Lcom/fasterxml/jackson/databind/SerializerProvider;Lcom/fasterxml/jackson/databind/JsonSerializer;)V
    .locals 8
    .param p1, "value"    # [Ljava/lang/Object;
    .param p2, "jgen"    # Lcom/fasterxml/jackson/core/JsonGenerator;
    .param p3, "provider"    # Lcom/fasterxml/jackson/databind/SerializerProvider;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([",
            "Ljava/lang/Object;",
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
    .line 251
    .local p4, "ser":Lcom/fasterxml/jackson/databind/JsonSerializer;, "Lcom/fasterxml/jackson/databind/JsonSerializer<Ljava/lang/Object;>;"
    array-length v4, p1

    .line 252
    .local v4, "len":I
    iget-object v6, p0, Lcom/fasterxml/jackson/databind/ser/std/ObjectArraySerializer;->_valueTypeSerializer:Lcom/fasterxml/jackson/databind/jsontype/TypeSerializer;

    .line 254
    .local v6, "typeSer":Lcom/fasterxml/jackson/databind/jsontype/TypeSerializer;
    const/4 v2, 0x0

    .line 255
    .local v2, "i":I
    const/4 v1, 0x0

    .line 257
    :goto_0
    if-ge v2, v4, :cond_4

    .line 258
    :try_start_0
    aget-object v1, p1, v2

    .line 259
    .local v1, "elem":Ljava/lang/Object;
    if-nez v1, :cond_0

    .line 260
    invoke-virtual {p3, p2}, Lcom/fasterxml/jackson/databind/SerializerProvider;->defaultSerializeNull(Lcom/fasterxml/jackson/core/JsonGenerator;)V

    .line 257
    :goto_1
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 263
    :cond_0
    if-nez v6, :cond_1

    .line 264
    invoke-virtual {p4, v1, p2, p3}, Lcom/fasterxml/jackson/databind/JsonSerializer;->serialize(Ljava/lang/Object;Lcom/fasterxml/jackson/core/JsonGenerator;Lcom/fasterxml/jackson/databind/SerializerProvider;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    goto :goto_1

    .line 269
    .end local v1    # "elem":Ljava/lang/Object;
    :catch_0
    move-exception v3

    .line 270
    .local v3, "ioe":Ljava/io/IOException;
    throw v3

    .line 266
    .end local v3    # "ioe":Ljava/io/IOException;
    .restart local v1    # "elem":Ljava/lang/Object;
    :cond_1
    :try_start_1
    invoke-virtual {p4, v1, p2, p3, v6}, Lcom/fasterxml/jackson/databind/JsonSerializer;->serializeWithType(Ljava/lang/Object;Lcom/fasterxml/jackson/core/JsonGenerator;Lcom/fasterxml/jackson/databind/SerializerProvider;Lcom/fasterxml/jackson/databind/jsontype/TypeSerializer;)V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    goto :goto_1

    .line 271
    .end local v1    # "elem":Ljava/lang/Object;
    :catch_1
    move-exception v0

    .line 272
    .local v0, "e":Ljava/lang/Exception;
    move-object v5, v0

    .line 273
    .local v5, "t":Ljava/lang/Throwable;
    :goto_2
    instance-of v7, v5, Ljava/lang/reflect/InvocationTargetException;

    if-eqz v7, :cond_2

    invoke-virtual {v5}, Ljava/lang/Throwable;->getCause()Ljava/lang/Throwable;

    move-result-object v7

    if-eqz v7, :cond_2

    .line 274
    invoke-virtual {v5}, Ljava/lang/Throwable;->getCause()Ljava/lang/Throwable;

    move-result-object v5

    goto :goto_2

    .line 276
    :cond_2
    instance-of v7, v5, Ljava/lang/Error;

    if-eqz v7, :cond_3

    .line 277
    check-cast v5, Ljava/lang/Error;

    .end local v5    # "t":Ljava/lang/Throwable;
    throw v5

    .line 279
    .restart local v5    # "t":Ljava/lang/Throwable;
    :cond_3
    invoke-static {v5, v1, v2}, Lcom/fasterxml/jackson/databind/JsonMappingException;->wrapWithPath(Ljava/lang/Throwable;Ljava/lang/Object;I)Lcom/fasterxml/jackson/databind/JsonMappingException;

    move-result-object v7

    throw v7

    .line 281
    .end local v0    # "e":Ljava/lang/Exception;
    .end local v5    # "t":Ljava/lang/Throwable;
    :cond_4
    return-void
.end method

.method public serializeTypedContents([Ljava/lang/Object;Lcom/fasterxml/jackson/core/JsonGenerator;Lcom/fasterxml/jackson/databind/SerializerProvider;)V
    .locals 11
    .param p1, "value"    # [Ljava/lang/Object;
    .param p2, "jgen"    # Lcom/fasterxml/jackson/core/JsonGenerator;
    .param p3, "provider"    # Lcom/fasterxml/jackson/databind/SerializerProvider;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonGenerationException;
        }
    .end annotation

    .prologue
    .line 286
    array-length v5, p1

    .line 287
    .local v5, "len":I
    iget-object v9, p0, Lcom/fasterxml/jackson/databind/ser/std/ObjectArraySerializer;->_valueTypeSerializer:Lcom/fasterxml/jackson/databind/jsontype/TypeSerializer;

    .line 288
    .local v9, "typeSer":Lcom/fasterxml/jackson/databind/jsontype/TypeSerializer;
    const/4 v3, 0x0

    .line 289
    .local v3, "i":I
    const/4 v2, 0x0

    .line 291
    .local v2, "elem":Ljava/lang/Object;
    :try_start_0
    iget-object v7, p0, Lcom/fasterxml/jackson/databind/ser/std/ObjectArraySerializer;->_dynamicSerializers:Lcom/fasterxml/jackson/databind/ser/impl/PropertySerializerMap;

    .line 292
    .end local v2    # "elem":Ljava/lang/Object;
    .local v7, "serializers":Lcom/fasterxml/jackson/databind/ser/impl/PropertySerializerMap;
    :goto_0
    if-ge v3, v5, :cond_4

    .line 293
    aget-object v2, p1, v3

    .line 294
    .restart local v2    # "elem":Ljava/lang/Object;
    if-nez v2, :cond_0

    .line 295
    invoke-virtual {p3, p2}, Lcom/fasterxml/jackson/databind/SerializerProvider;->defaultSerializeNull(Lcom/fasterxml/jackson/core/JsonGenerator;)V

    .line 292
    :goto_1
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 298
    :cond_0
    invoke-virtual {v2}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    .line 299
    .local v0, "cc":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-virtual {v7, v0}, Lcom/fasterxml/jackson/databind/ser/impl/PropertySerializerMap;->serializerFor(Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/JsonSerializer;

    move-result-object v6

    .line 300
    .local v6, "serializer":Lcom/fasterxml/jackson/databind/JsonSerializer;, "Lcom/fasterxml/jackson/databind/JsonSerializer<Ljava/lang/Object;>;"
    if-nez v6, :cond_1

    .line 301
    invoke-virtual {p0, v7, v0, p3}, Lcom/fasterxml/jackson/databind/ser/std/ObjectArraySerializer;->_findAndAddDynamic(Lcom/fasterxml/jackson/databind/ser/impl/PropertySerializerMap;Ljava/lang/Class;Lcom/fasterxml/jackson/databind/SerializerProvider;)Lcom/fasterxml/jackson/databind/JsonSerializer;

    move-result-object v6

    .line 303
    :cond_1
    invoke-virtual {v6, v2, p2, p3, v9}, Lcom/fasterxml/jackson/databind/JsonSerializer;->serializeWithType(Ljava/lang/Object;Lcom/fasterxml/jackson/core/JsonGenerator;Lcom/fasterxml/jackson/databind/SerializerProvider;Lcom/fasterxml/jackson/databind/jsontype/TypeSerializer;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    goto :goto_1

    .line 305
    .end local v0    # "cc":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .end local v2    # "elem":Ljava/lang/Object;
    .end local v6    # "serializer":Lcom/fasterxml/jackson/databind/JsonSerializer;, "Lcom/fasterxml/jackson/databind/JsonSerializer<Ljava/lang/Object;>;"
    .end local v7    # "serializers":Lcom/fasterxml/jackson/databind/ser/impl/PropertySerializerMap;
    :catch_0
    move-exception v4

    .line 306
    .local v4, "ioe":Ljava/io/IOException;
    throw v4

    .line 307
    .end local v4    # "ioe":Ljava/io/IOException;
    :catch_1
    move-exception v1

    .line 308
    .local v1, "e":Ljava/lang/Exception;
    move-object v8, v1

    .line 309
    .local v8, "t":Ljava/lang/Throwable;
    :goto_2
    instance-of v10, v8, Ljava/lang/reflect/InvocationTargetException;

    if-eqz v10, :cond_2

    invoke-virtual {v8}, Ljava/lang/Throwable;->getCause()Ljava/lang/Throwable;

    move-result-object v10

    if-eqz v10, :cond_2

    .line 310
    invoke-virtual {v8}, Ljava/lang/Throwable;->getCause()Ljava/lang/Throwable;

    move-result-object v8

    goto :goto_2

    .line 312
    :cond_2
    instance-of v10, v8, Ljava/lang/Error;

    if-eqz v10, :cond_3

    .line 313
    check-cast v8, Ljava/lang/Error;

    .end local v8    # "t":Ljava/lang/Throwable;
    throw v8

    .line 315
    .restart local v8    # "t":Ljava/lang/Throwable;
    :cond_3
    invoke-static {v8, v2, v3}, Lcom/fasterxml/jackson/databind/JsonMappingException;->wrapWithPath(Ljava/lang/Throwable;Ljava/lang/Object;I)Lcom/fasterxml/jackson/databind/JsonMappingException;

    move-result-object v10

    throw v10

    .line 317
    .end local v1    # "e":Ljava/lang/Exception;
    .end local v8    # "t":Ljava/lang/Throwable;
    .restart local v7    # "serializers":Lcom/fasterxml/jackson/databind/ser/impl/PropertySerializerMap;
    :cond_4
    return-void
.end method

.method public withResolved(Lcom/fasterxml/jackson/databind/BeanProperty;Lcom/fasterxml/jackson/databind/jsontype/TypeSerializer;Lcom/fasterxml/jackson/databind/JsonSerializer;)Lcom/fasterxml/jackson/databind/ser/std/ObjectArraySerializer;
    .locals 1
    .param p1, "prop"    # Lcom/fasterxml/jackson/databind/BeanProperty;
    .param p2, "vts"    # Lcom/fasterxml/jackson/databind/jsontype/TypeSerializer;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/fasterxml/jackson/databind/BeanProperty;",
            "Lcom/fasterxml/jackson/databind/jsontype/TypeSerializer;",
            "Lcom/fasterxml/jackson/databind/JsonSerializer",
            "<*>;)",
            "Lcom/fasterxml/jackson/databind/ser/std/ObjectArraySerializer;"
        }
    .end annotation

    .prologue
    .line 104
    .local p3, "ser":Lcom/fasterxml/jackson/databind/JsonSerializer;, "Lcom/fasterxml/jackson/databind/JsonSerializer<*>;"
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/ser/std/ObjectArraySerializer;->_property:Lcom/fasterxml/jackson/databind/BeanProperty;

    if-ne v0, p1, :cond_0

    iget-object v0, p0, Lcom/fasterxml/jackson/databind/ser/std/ObjectArraySerializer;->_elementSerializer:Lcom/fasterxml/jackson/databind/JsonSerializer;

    if-ne p3, v0, :cond_0

    iget-object v0, p0, Lcom/fasterxml/jackson/databind/ser/std/ObjectArraySerializer;->_valueTypeSerializer:Lcom/fasterxml/jackson/databind/jsontype/TypeSerializer;

    if-ne v0, p2, :cond_0

    .line 107
    .end local p0    # "this":Lcom/fasterxml/jackson/databind/ser/std/ObjectArraySerializer;
    :goto_0
    return-object p0

    .restart local p0    # "this":Lcom/fasterxml/jackson/databind/ser/std/ObjectArraySerializer;
    :cond_0
    new-instance v0, Lcom/fasterxml/jackson/databind/ser/std/ObjectArraySerializer;

    invoke-direct {v0, p0, p1, p2, p3}, Lcom/fasterxml/jackson/databind/ser/std/ObjectArraySerializer;-><init>(Lcom/fasterxml/jackson/databind/ser/std/ObjectArraySerializer;Lcom/fasterxml/jackson/databind/BeanProperty;Lcom/fasterxml/jackson/databind/jsontype/TypeSerializer;Lcom/fasterxml/jackson/databind/JsonSerializer;)V

    move-object p0, v0

    goto :goto_0
.end method
