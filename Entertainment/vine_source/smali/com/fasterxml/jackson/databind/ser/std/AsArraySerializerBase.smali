.class public abstract Lcom/fasterxml/jackson/databind/ser/std/AsArraySerializerBase;
.super Lcom/fasterxml/jackson/databind/ser/ContainerSerializer;
.source "AsArraySerializerBase.java"

# interfaces
.implements Lcom/fasterxml/jackson/databind/ser/ContextualSerializer;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Lcom/fasterxml/jackson/databind/ser/ContainerSerializer",
        "<TT;>;",
        "Lcom/fasterxml/jackson/databind/ser/ContextualSerializer;"
    }
.end annotation


# instance fields
.field protected _dynamicSerializers:Lcom/fasterxml/jackson/databind/ser/impl/PropertySerializerMap;

.field protected final _elementSerializer:Lcom/fasterxml/jackson/databind/JsonSerializer;
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

.field protected final _property:Lcom/fasterxml/jackson/databind/BeanProperty;

.field protected final _staticTyping:Z

.field protected final _valueTypeSerializer:Lcom/fasterxml/jackson/databind/jsontype/TypeSerializer;


# direct methods
.method protected constructor <init>(Lcom/fasterxml/jackson/databind/ser/std/AsArraySerializerBase;Lcom/fasterxml/jackson/databind/BeanProperty;Lcom/fasterxml/jackson/databind/jsontype/TypeSerializer;Lcom/fasterxml/jackson/databind/JsonSerializer;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/fasterxml/jackson/databind/ser/std/AsArraySerializerBase",
            "<*>;",
            "Lcom/fasterxml/jackson/databind/BeanProperty;",
            "Lcom/fasterxml/jackson/databind/jsontype/TypeSerializer;",
            "Lcom/fasterxml/jackson/databind/JsonSerializer",
            "<*>;)V"
        }
    .end annotation

    .prologue
    .line 78
    invoke-direct {p0, p1}, Lcom/fasterxml/jackson/databind/ser/ContainerSerializer;-><init>(Lcom/fasterxml/jackson/databind/ser/ContainerSerializer;)V

    .line 79
    iget-object v0, p1, Lcom/fasterxml/jackson/databind/ser/std/AsArraySerializerBase;->_elementType:Lcom/fasterxml/jackson/databind/JavaType;

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/ser/std/AsArraySerializerBase;->_elementType:Lcom/fasterxml/jackson/databind/JavaType;

    .line 80
    iget-boolean v0, p1, Lcom/fasterxml/jackson/databind/ser/std/AsArraySerializerBase;->_staticTyping:Z

    iput-boolean v0, p0, Lcom/fasterxml/jackson/databind/ser/std/AsArraySerializerBase;->_staticTyping:Z

    .line 81
    iput-object p3, p0, Lcom/fasterxml/jackson/databind/ser/std/AsArraySerializerBase;->_valueTypeSerializer:Lcom/fasterxml/jackson/databind/jsontype/TypeSerializer;

    .line 82
    iput-object p2, p0, Lcom/fasterxml/jackson/databind/ser/std/AsArraySerializerBase;->_property:Lcom/fasterxml/jackson/databind/BeanProperty;

    .line 83
    iput-object p4, p0, Lcom/fasterxml/jackson/databind/ser/std/AsArraySerializerBase;->_elementSerializer:Lcom/fasterxml/jackson/databind/JsonSerializer;

    .line 84
    iget-object v0, p1, Lcom/fasterxml/jackson/databind/ser/std/AsArraySerializerBase;->_dynamicSerializers:Lcom/fasterxml/jackson/databind/ser/impl/PropertySerializerMap;

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/ser/std/AsArraySerializerBase;->_dynamicSerializers:Lcom/fasterxml/jackson/databind/ser/impl/PropertySerializerMap;

    .line 85
    return-void
.end method

.method protected constructor <init>(Ljava/lang/Class;Lcom/fasterxml/jackson/databind/JavaType;ZLcom/fasterxml/jackson/databind/jsontype/TypeSerializer;Lcom/fasterxml/jackson/databind/BeanProperty;Lcom/fasterxml/jackson/databind/JsonSerializer;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;",
            "Lcom/fasterxml/jackson/databind/JavaType;",
            "Z",
            "Lcom/fasterxml/jackson/databind/jsontype/TypeSerializer;",
            "Lcom/fasterxml/jackson/databind/BeanProperty;",
            "Lcom/fasterxml/jackson/databind/JsonSerializer",
            "<",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    .prologue
    const/4 v0, 0x0

    .line 64
    invoke-direct {p0, p1, v0}, Lcom/fasterxml/jackson/databind/ser/ContainerSerializer;-><init>(Ljava/lang/Class;Z)V

    .line 65
    iput-object p2, p0, Lcom/fasterxml/jackson/databind/ser/std/AsArraySerializerBase;->_elementType:Lcom/fasterxml/jackson/databind/JavaType;

    .line 67
    if-nez p3, :cond_0

    if-eqz p2, :cond_1

    invoke-virtual {p2}, Lcom/fasterxml/jackson/databind/JavaType;->isFinal()Z

    move-result v1

    if-eqz v1, :cond_1

    :cond_0
    const/4 v0, 0x1

    :cond_1
    iput-boolean v0, p0, Lcom/fasterxml/jackson/databind/ser/std/AsArraySerializerBase;->_staticTyping:Z

    .line 68
    iput-object p4, p0, Lcom/fasterxml/jackson/databind/ser/std/AsArraySerializerBase;->_valueTypeSerializer:Lcom/fasterxml/jackson/databind/jsontype/TypeSerializer;

    .line 69
    iput-object p5, p0, Lcom/fasterxml/jackson/databind/ser/std/AsArraySerializerBase;->_property:Lcom/fasterxml/jackson/databind/BeanProperty;

    .line 70
    iput-object p6, p0, Lcom/fasterxml/jackson/databind/ser/std/AsArraySerializerBase;->_elementSerializer:Lcom/fasterxml/jackson/databind/JsonSerializer;

    .line 71
    invoke-static {}, Lcom/fasterxml/jackson/databind/ser/impl/PropertySerializerMap;->emptyMap()Lcom/fasterxml/jackson/databind/ser/impl/PropertySerializerMap;

    move-result-object v0

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/ser/std/AsArraySerializerBase;->_dynamicSerializers:Lcom/fasterxml/jackson/databind/ser/impl/PropertySerializerMap;

    .line 72
    return-void
.end method


# virtual methods
.method protected final _findAndAddDynamic(Lcom/fasterxml/jackson/databind/ser/impl/PropertySerializerMap;Lcom/fasterxml/jackson/databind/JavaType;Lcom/fasterxml/jackson/databind/SerializerProvider;)Lcom/fasterxml/jackson/databind/JsonSerializer;
    .locals 2
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
    .line 279
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/ser/std/AsArraySerializerBase;->_property:Lcom/fasterxml/jackson/databind/BeanProperty;

    invoke-virtual {p1, p2, p3, v0}, Lcom/fasterxml/jackson/databind/ser/impl/PropertySerializerMap;->findAndAddSecondarySerializer(Lcom/fasterxml/jackson/databind/JavaType;Lcom/fasterxml/jackson/databind/SerializerProvider;Lcom/fasterxml/jackson/databind/BeanProperty;)Lcom/fasterxml/jackson/databind/ser/impl/PropertySerializerMap$SerializerAndMapResult;

    move-result-object v0

    .line 280
    iget-object v1, v0, Lcom/fasterxml/jackson/databind/ser/impl/PropertySerializerMap$SerializerAndMapResult;->map:Lcom/fasterxml/jackson/databind/ser/impl/PropertySerializerMap;

    if-eq p1, v1, :cond_0

    .line 281
    iget-object v1, v0, Lcom/fasterxml/jackson/databind/ser/impl/PropertySerializerMap$SerializerAndMapResult;->map:Lcom/fasterxml/jackson/databind/ser/impl/PropertySerializerMap;

    iput-object v1, p0, Lcom/fasterxml/jackson/databind/ser/std/AsArraySerializerBase;->_dynamicSerializers:Lcom/fasterxml/jackson/databind/ser/impl/PropertySerializerMap;

    .line 283
    :cond_0
    iget-object v0, v0, Lcom/fasterxml/jackson/databind/ser/impl/PropertySerializerMap$SerializerAndMapResult;->serializer:Lcom/fasterxml/jackson/databind/JsonSerializer;

    return-object v0
.end method

.method protected final _findAndAddDynamic(Lcom/fasterxml/jackson/databind/ser/impl/PropertySerializerMap;Ljava/lang/Class;Lcom/fasterxml/jackson/databind/SerializerProvider;)Lcom/fasterxml/jackson/databind/JsonSerializer;
    .locals 2
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
    .line 268
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/ser/std/AsArraySerializerBase;->_property:Lcom/fasterxml/jackson/databind/BeanProperty;

    invoke-virtual {p1, p2, p3, v0}, Lcom/fasterxml/jackson/databind/ser/impl/PropertySerializerMap;->findAndAddSecondarySerializer(Ljava/lang/Class;Lcom/fasterxml/jackson/databind/SerializerProvider;Lcom/fasterxml/jackson/databind/BeanProperty;)Lcom/fasterxml/jackson/databind/ser/impl/PropertySerializerMap$SerializerAndMapResult;

    move-result-object v0

    .line 270
    iget-object v1, v0, Lcom/fasterxml/jackson/databind/ser/impl/PropertySerializerMap$SerializerAndMapResult;->map:Lcom/fasterxml/jackson/databind/ser/impl/PropertySerializerMap;

    if-eq p1, v1, :cond_0

    .line 271
    iget-object v1, v0, Lcom/fasterxml/jackson/databind/ser/impl/PropertySerializerMap$SerializerAndMapResult;->map:Lcom/fasterxml/jackson/databind/ser/impl/PropertySerializerMap;

    iput-object v1, p0, Lcom/fasterxml/jackson/databind/ser/std/AsArraySerializerBase;->_dynamicSerializers:Lcom/fasterxml/jackson/databind/ser/impl/PropertySerializerMap;

    .line 273
    :cond_0
    iget-object v0, v0, Lcom/fasterxml/jackson/databind/ser/impl/PropertySerializerMap$SerializerAndMapResult;->serializer:Lcom/fasterxml/jackson/databind/JsonSerializer;

    return-object v0
.end method

.method public acceptJsonFormatVisitor(Lcom/fasterxml/jackson/databind/jsonFormatVisitors/JsonFormatVisitorWrapper;Lcom/fasterxml/jackson/databind/JavaType;)V
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/fasterxml/jackson/databind/JsonMappingException;
        }
    .end annotation

    .prologue
    .line 250
    if-nez p1, :cond_0

    const/4 v0, 0x0

    move-object v1, v0

    .line 251
    :goto_0
    if-eqz v1, :cond_3

    .line 252
    invoke-interface {p1}, Lcom/fasterxml/jackson/databind/jsonFormatVisitors/JsonFormatVisitorWrapper;->getProvider()Lcom/fasterxml/jackson/databind/SerializerProvider;

    move-result-object v0

    invoke-virtual {v0}, Lcom/fasterxml/jackson/databind/SerializerProvider;->getTypeFactory()Lcom/fasterxml/jackson/databind/type/TypeFactory;

    move-result-object v0

    .line 253
    iget-object v2, p0, Lcom/fasterxml/jackson/databind/ser/std/AsArraySerializerBase;->_elementType:Lcom/fasterxml/jackson/databind/JavaType;

    invoke-virtual {p2}, Lcom/fasterxml/jackson/databind/JavaType;->getContentType()Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Lcom/fasterxml/jackson/databind/type/TypeFactory;->moreSpecificType(Lcom/fasterxml/jackson/databind/JavaType;Lcom/fasterxml/jackson/databind/JavaType;)Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v2

    .line 254
    if-nez v2, :cond_1

    .line 255
    new-instance v0, Lcom/fasterxml/jackson/databind/JsonMappingException;

    const-string v1, "Could not resolve type"

    invoke-direct {v0, v1}, Lcom/fasterxml/jackson/databind/JsonMappingException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 250
    :cond_0
    invoke-interface {p1, p2}, Lcom/fasterxml/jackson/databind/jsonFormatVisitors/JsonFormatVisitorWrapper;->expectArrayFormat(Lcom/fasterxml/jackson/databind/JavaType;)Lcom/fasterxml/jackson/databind/jsonFormatVisitors/JsonArrayFormatVisitor;

    move-result-object v0

    move-object v1, v0

    goto :goto_0

    .line 257
    :cond_1
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/ser/std/AsArraySerializerBase;->_elementSerializer:Lcom/fasterxml/jackson/databind/JsonSerializer;

    .line 258
    if-nez v0, :cond_2

    .line 259
    invoke-interface {p1}, Lcom/fasterxml/jackson/databind/jsonFormatVisitors/JsonFormatVisitorWrapper;->getProvider()Lcom/fasterxml/jackson/databind/SerializerProvider;

    move-result-object v0

    iget-object v3, p0, Lcom/fasterxml/jackson/databind/ser/std/AsArraySerializerBase;->_property:Lcom/fasterxml/jackson/databind/BeanProperty;

    invoke-virtual {v0, v2, v3}, Lcom/fasterxml/jackson/databind/SerializerProvider;->findValueSerializer(Lcom/fasterxml/jackson/databind/JavaType;Lcom/fasterxml/jackson/databind/BeanProperty;)Lcom/fasterxml/jackson/databind/JsonSerializer;

    move-result-object v0

    .line 261
    :cond_2
    invoke-interface {v1, v0, v2}, Lcom/fasterxml/jackson/databind/jsonFormatVisitors/JsonArrayFormatVisitor;->itemsFormat(Lcom/fasterxml/jackson/databind/jsonFormatVisitors/JsonFormatVisitable;Lcom/fasterxml/jackson/databind/JavaType;)V

    .line 263
    :cond_3
    return-void
.end method

.method public createContextual(Lcom/fasterxml/jackson/databind/SerializerProvider;Lcom/fasterxml/jackson/databind/BeanProperty;)Lcom/fasterxml/jackson/databind/JsonSerializer;
    .locals 4
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
    .line 107
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/ser/std/AsArraySerializerBase;->_valueTypeSerializer:Lcom/fasterxml/jackson/databind/jsontype/TypeSerializer;

    .line 108
    if-eqz v0, :cond_8

    .line 109
    invoke-virtual {v0, p2}, Lcom/fasterxml/jackson/databind/jsontype/TypeSerializer;->forProperty(Lcom/fasterxml/jackson/databind/BeanProperty;)Lcom/fasterxml/jackson/databind/jsontype/TypeSerializer;

    move-result-object v0

    move-object v1, v0

    .line 115
    :goto_0
    const/4 v0, 0x0

    .line 117
    if-eqz p2, :cond_0

    .line 118
    invoke-interface {p2}, Lcom/fasterxml/jackson/databind/BeanProperty;->getMember()Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;

    move-result-object v2

    .line 119
    if-eqz v2, :cond_0

    .line 120
    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/SerializerProvider;->getAnnotationIntrospector()Lcom/fasterxml/jackson/databind/AnnotationIntrospector;

    move-result-object v3

    invoke-virtual {v3, v2}, Lcom/fasterxml/jackson/databind/AnnotationIntrospector;->findContentSerializer(Lcom/fasterxml/jackson/databind/introspect/Annotated;)Ljava/lang/Object;

    move-result-object v3

    .line 121
    if-eqz v3, :cond_0

    .line 122
    invoke-virtual {p1, v2, v3}, Lcom/fasterxml/jackson/databind/SerializerProvider;->serializerInstance(Lcom/fasterxml/jackson/databind/introspect/Annotated;Ljava/lang/Object;)Lcom/fasterxml/jackson/databind/JsonSerializer;

    move-result-object v0

    .line 126
    :cond_0
    if-nez v0, :cond_1

    .line 127
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/ser/std/AsArraySerializerBase;->_elementSerializer:Lcom/fasterxml/jackson/databind/JsonSerializer;

    .line 130
    :cond_1
    invoke-virtual {p0, p1, p2, v0}, Lcom/fasterxml/jackson/databind/ser/std/AsArraySerializerBase;->findConvertingContentSerializer(Lcom/fasterxml/jackson/databind/SerializerProvider;Lcom/fasterxml/jackson/databind/BeanProperty;Lcom/fasterxml/jackson/databind/JsonSerializer;)Lcom/fasterxml/jackson/databind/JsonSerializer;

    move-result-object v0

    .line 131
    if-nez v0, :cond_7

    .line 134
    iget-object v2, p0, Lcom/fasterxml/jackson/databind/ser/std/AsArraySerializerBase;->_elementType:Lcom/fasterxml/jackson/databind/JavaType;

    if-eqz v2, :cond_4

    .line 136
    iget-boolean v2, p0, Lcom/fasterxml/jackson/databind/ser/std/AsArraySerializerBase;->_staticTyping:Z

    if-eqz v2, :cond_2

    iget-object v2, p0, Lcom/fasterxml/jackson/databind/ser/std/AsArraySerializerBase;->_elementType:Lcom/fasterxml/jackson/databind/JavaType;

    invoke-virtual {v2}, Lcom/fasterxml/jackson/databind/JavaType;->getRawClass()Ljava/lang/Class;

    move-result-object v2

    const-class v3, Ljava/lang/Object;

    if-ne v2, v3, :cond_3

    :cond_2
    invoke-virtual {p0, p1, p2}, Lcom/fasterxml/jackson/databind/ser/std/AsArraySerializerBase;->hasContentTypeAnnotation(Lcom/fasterxml/jackson/databind/SerializerProvider;Lcom/fasterxml/jackson/databind/BeanProperty;)Z

    move-result v2

    if-eqz v2, :cond_4

    .line 138
    :cond_3
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/ser/std/AsArraySerializerBase;->_elementType:Lcom/fasterxml/jackson/databind/JavaType;

    invoke-virtual {p1, v0, p2}, Lcom/fasterxml/jackson/databind/SerializerProvider;->findValueSerializer(Lcom/fasterxml/jackson/databind/JavaType;Lcom/fasterxml/jackson/databind/BeanProperty;)Lcom/fasterxml/jackson/databind/JsonSerializer;

    move-result-object v0

    .line 144
    :cond_4
    :goto_1
    iget-object v2, p0, Lcom/fasterxml/jackson/databind/ser/std/AsArraySerializerBase;->_elementSerializer:Lcom/fasterxml/jackson/databind/JsonSerializer;

    if-ne v0, v2, :cond_5

    iget-object v2, p0, Lcom/fasterxml/jackson/databind/ser/std/AsArraySerializerBase;->_property:Lcom/fasterxml/jackson/databind/BeanProperty;

    if-ne p2, v2, :cond_5

    iget-object v2, p0, Lcom/fasterxml/jackson/databind/ser/std/AsArraySerializerBase;->_valueTypeSerializer:Lcom/fasterxml/jackson/databind/jsontype/TypeSerializer;

    if-eq v2, v1, :cond_6

    .line 145
    :cond_5
    invoke-virtual {p0, p2, v1, v0}, Lcom/fasterxml/jackson/databind/ser/std/AsArraySerializerBase;->withResolved(Lcom/fasterxml/jackson/databind/BeanProperty;Lcom/fasterxml/jackson/databind/jsontype/TypeSerializer;Lcom/fasterxml/jackson/databind/JsonSerializer;)Lcom/fasterxml/jackson/databind/ser/std/AsArraySerializerBase;

    move-result-object p0

    .line 147
    :cond_6
    return-object p0

    .line 142
    :cond_7
    invoke-virtual {p1, v0, p2}, Lcom/fasterxml/jackson/databind/SerializerProvider;->handleSecondaryContextualization(Lcom/fasterxml/jackson/databind/JsonSerializer;Lcom/fasterxml/jackson/databind/BeanProperty;)Lcom/fasterxml/jackson/databind/JsonSerializer;

    move-result-object v0

    goto :goto_1

    :cond_8
    move-object v1, v0

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
    .line 163
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/ser/std/AsArraySerializerBase;->_elementSerializer:Lcom/fasterxml/jackson/databind/JsonSerializer;

    return-object v0
.end method

.method public getContentType()Lcom/fasterxml/jackson/databind/JavaType;
    .locals 1

    .prologue
    .line 158
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/ser/std/AsArraySerializerBase;->_elementType:Lcom/fasterxml/jackson/databind/JavaType;

    return-object v0
.end method

.method public getSchema(Lcom/fasterxml/jackson/databind/SerializerProvider;Ljava/lang/reflect/Type;)Lcom/fasterxml/jackson/databind/JsonNode;
    .locals 6
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/fasterxml/jackson/databind/JsonMappingException;
        }
    .end annotation

    .prologue
    const/4 v5, 0x1

    const/4 v1, 0x0

    .line 212
    const-string v0, "array"

    invoke-virtual {p0, v0, v5}, Lcom/fasterxml/jackson/databind/ser/std/AsArraySerializerBase;->createSchemaNode(Ljava/lang/String;Z)Lcom/fasterxml/jackson/databind/node/ObjectNode;

    move-result-object v2

    .line 214
    if-eqz p2, :cond_5

    .line 215
    invoke-virtual {p1, p2}, Lcom/fasterxml/jackson/databind/SerializerProvider;->constructType(Ljava/lang/reflect/Type;)Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v0

    .line 216
    invoke-virtual {v0}, Lcom/fasterxml/jackson/databind/JavaType;->getContentType()Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v0

    .line 217
    if-nez v0, :cond_0

    .line 218
    instance-of v3, p2, Ljava/lang/reflect/ParameterizedType;

    if-eqz v3, :cond_0

    .line 219
    check-cast p2, Ljava/lang/reflect/ParameterizedType;

    invoke-interface {p2}, Ljava/lang/reflect/ParameterizedType;->getActualTypeArguments()[Ljava/lang/reflect/Type;

    move-result-object v3

    .line 220
    array-length v4, v3

    if-ne v4, v5, :cond_0

    .line 221
    const/4 v0, 0x0

    aget-object v0, v3, v0

    invoke-virtual {p1, v0}, Lcom/fasterxml/jackson/databind/SerializerProvider;->constructType(Ljava/lang/reflect/Type;)Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v0

    .line 226
    :cond_0
    :goto_0
    if-nez v0, :cond_1

    iget-object v3, p0, Lcom/fasterxml/jackson/databind/ser/std/AsArraySerializerBase;->_elementType:Lcom/fasterxml/jackson/databind/JavaType;

    if-eqz v3, :cond_1

    .line 227
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/ser/std/AsArraySerializerBase;->_elementType:Lcom/fasterxml/jackson/databind/JavaType;

    .line 229
    :cond_1
    if-eqz v0, :cond_3

    .line 232
    invoke-virtual {v0}, Lcom/fasterxml/jackson/databind/JavaType;->getRawClass()Ljava/lang/Class;

    move-result-object v3

    const-class v4, Ljava/lang/Object;

    if-eq v3, v4, :cond_4

    .line 233
    iget-object v3, p0, Lcom/fasterxml/jackson/databind/ser/std/AsArraySerializerBase;->_property:Lcom/fasterxml/jackson/databind/BeanProperty;

    invoke-virtual {p1, v0, v3}, Lcom/fasterxml/jackson/databind/SerializerProvider;->findValueSerializer(Lcom/fasterxml/jackson/databind/JavaType;Lcom/fasterxml/jackson/databind/BeanProperty;)Lcom/fasterxml/jackson/databind/JsonSerializer;

    move-result-object v0

    .line 234
    instance-of v3, v0, Lcom/fasterxml/jackson/databind/jsonschema/SchemaAware;

    if-eqz v3, :cond_4

    .line 235
    check-cast v0, Lcom/fasterxml/jackson/databind/jsonschema/SchemaAware;

    invoke-interface {v0, p1, v1}, Lcom/fasterxml/jackson/databind/jsonschema/SchemaAware;->getSchema(Lcom/fasterxml/jackson/databind/SerializerProvider;Ljava/lang/reflect/Type;)Lcom/fasterxml/jackson/databind/JsonNode;

    move-result-object v0

    .line 238
    :goto_1
    if-nez v0, :cond_2

    .line 239
    invoke-static {}, Lcom/fasterxml/jackson/databind/jsonschema/JsonSchema;->getDefaultSchemaNode()Lcom/fasterxml/jackson/databind/JsonNode;

    move-result-object v0

    .line 241
    :cond_2
    const-string v1, "items"

    invoke-virtual {v2, v1, v0}, Lcom/fasterxml/jackson/databind/node/ObjectNode;->put(Ljava/lang/String;Lcom/fasterxml/jackson/databind/JsonNode;)Lcom/fasterxml/jackson/databind/JsonNode;

    .line 243
    :cond_3
    return-object v2

    :cond_4
    move-object v0, v1

    goto :goto_1

    :cond_5
    move-object v0, v1

    goto :goto_0
.end method

.method public final serialize(Ljava/lang/Object;Lcom/fasterxml/jackson/core/JsonGenerator;Lcom/fasterxml/jackson/databind/SerializerProvider;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;",
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
    .line 177
    sget-object v0, Lcom/fasterxml/jackson/databind/SerializationFeature;->WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED:Lcom/fasterxml/jackson/databind/SerializationFeature;

    invoke-virtual {p3, v0}, Lcom/fasterxml/jackson/databind/SerializerProvider;->isEnabled(Lcom/fasterxml/jackson/databind/SerializationFeature;)Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p0, p1}, Lcom/fasterxml/jackson/databind/ser/std/AsArraySerializerBase;->hasSingleElement(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 179
    invoke-virtual {p0, p1, p2, p3}, Lcom/fasterxml/jackson/databind/ser/std/AsArraySerializerBase;->serializeContents(Ljava/lang/Object;Lcom/fasterxml/jackson/core/JsonGenerator;Lcom/fasterxml/jackson/databind/SerializerProvider;)V

    .line 185
    :goto_0
    return-void

    .line 182
    :cond_0
    invoke-virtual {p2}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeStartArray()V

    .line 183
    invoke-virtual {p0, p1, p2, p3}, Lcom/fasterxml/jackson/databind/ser/std/AsArraySerializerBase;->serializeContents(Ljava/lang/Object;Lcom/fasterxml/jackson/core/JsonGenerator;Lcom/fasterxml/jackson/databind/SerializerProvider;)V

    .line 184
    invoke-virtual {p2}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeEndArray()V

    goto :goto_0
.end method

.method protected abstract serializeContents(Ljava/lang/Object;Lcom/fasterxml/jackson/core/JsonGenerator;Lcom/fasterxml/jackson/databind/SerializerProvider;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;",
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
.end method

.method public serializeWithType(Ljava/lang/Object;Lcom/fasterxml/jackson/core/JsonGenerator;Lcom/fasterxml/jackson/databind/SerializerProvider;Lcom/fasterxml/jackson/databind/jsontype/TypeSerializer;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;",
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
    .line 194
    invoke-virtual {p4, p1, p2}, Lcom/fasterxml/jackson/databind/jsontype/TypeSerializer;->writeTypePrefixForArray(Ljava/lang/Object;Lcom/fasterxml/jackson/core/JsonGenerator;)V

    .line 195
    invoke-virtual {p0, p1, p2, p3}, Lcom/fasterxml/jackson/databind/ser/std/AsArraySerializerBase;->serializeContents(Ljava/lang/Object;Lcom/fasterxml/jackson/core/JsonGenerator;Lcom/fasterxml/jackson/databind/SerializerProvider;)V

    .line 196
    invoke-virtual {p4, p1, p2}, Lcom/fasterxml/jackson/databind/jsontype/TypeSerializer;->writeTypeSuffixForArray(Ljava/lang/Object;Lcom/fasterxml/jackson/core/JsonGenerator;)V

    .line 197
    return-void
.end method

.method public abstract withResolved(Lcom/fasterxml/jackson/databind/BeanProperty;Lcom/fasterxml/jackson/databind/jsontype/TypeSerializer;Lcom/fasterxml/jackson/databind/JsonSerializer;)Lcom/fasterxml/jackson/databind/ser/std/AsArraySerializerBase;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/fasterxml/jackson/databind/BeanProperty;",
            "Lcom/fasterxml/jackson/databind/jsontype/TypeSerializer;",
            "Lcom/fasterxml/jackson/databind/JsonSerializer",
            "<*>;)",
            "Lcom/fasterxml/jackson/databind/ser/std/AsArraySerializerBase",
            "<TT;>;"
        }
    .end annotation
.end method
