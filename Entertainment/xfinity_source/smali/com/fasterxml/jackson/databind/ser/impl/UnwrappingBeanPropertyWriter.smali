.class public Lcom/fasterxml/jackson/databind/ser/impl/UnwrappingBeanPropertyWriter;
.super Lcom/fasterxml/jackson/databind/ser/BeanPropertyWriter;
.source "UnwrappingBeanPropertyWriter.java"


# instance fields
.field protected final _nameTransformer:Lcom/fasterxml/jackson/databind/util/NameTransformer;


# direct methods
.method public constructor <init>(Lcom/fasterxml/jackson/databind/ser/BeanPropertyWriter;Lcom/fasterxml/jackson/databind/util/NameTransformer;)V
    .locals 0
    .param p1, "base"    # Lcom/fasterxml/jackson/databind/ser/BeanPropertyWriter;
    .param p2, "unwrapper"    # Lcom/fasterxml/jackson/databind/util/NameTransformer;

    .prologue
    .line 33
    invoke-direct {p0, p1}, Lcom/fasterxml/jackson/databind/ser/BeanPropertyWriter;-><init>(Lcom/fasterxml/jackson/databind/ser/BeanPropertyWriter;)V

    .line 34
    iput-object p2, p0, Lcom/fasterxml/jackson/databind/ser/impl/UnwrappingBeanPropertyWriter;->_nameTransformer:Lcom/fasterxml/jackson/databind/util/NameTransformer;

    .line 35
    return-void
.end method

.method private constructor <init>(Lcom/fasterxml/jackson/databind/ser/impl/UnwrappingBeanPropertyWriter;Lcom/fasterxml/jackson/databind/util/NameTransformer;Lcom/fasterxml/jackson/core/io/SerializedString;)V
    .locals 0
    .param p1, "base"    # Lcom/fasterxml/jackson/databind/ser/impl/UnwrappingBeanPropertyWriter;
    .param p2, "transformer"    # Lcom/fasterxml/jackson/databind/util/NameTransformer;
    .param p3, "name"    # Lcom/fasterxml/jackson/core/io/SerializedString;

    .prologue
    .line 39
    invoke-direct {p0, p1, p3}, Lcom/fasterxml/jackson/databind/ser/BeanPropertyWriter;-><init>(Lcom/fasterxml/jackson/databind/ser/BeanPropertyWriter;Lcom/fasterxml/jackson/core/io/SerializedString;)V

    .line 40
    iput-object p2, p0, Lcom/fasterxml/jackson/databind/ser/impl/UnwrappingBeanPropertyWriter;->_nameTransformer:Lcom/fasterxml/jackson/databind/util/NameTransformer;

    .line 41
    return-void
.end method


# virtual methods
.method protected _findAndAddDynamic(Lcom/fasterxml/jackson/databind/ser/impl/PropertySerializerMap;Ljava/lang/Class;Lcom/fasterxml/jackson/databind/SerializerProvider;)Lcom/fasterxml/jackson/databind/JsonSerializer;
    .locals 4
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
    .line 126
    .local p2, "type":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    iget-object v3, p0, Lcom/fasterxml/jackson/databind/ser/impl/UnwrappingBeanPropertyWriter;->_nonTrivialBaseType:Lcom/fasterxml/jackson/databind/JavaType;

    if-eqz v3, :cond_1

    .line 127
    iget-object v3, p0, Lcom/fasterxml/jackson/databind/ser/impl/UnwrappingBeanPropertyWriter;->_nonTrivialBaseType:Lcom/fasterxml/jackson/databind/JavaType;

    invoke-virtual {p3, v3, p2}, Lcom/fasterxml/jackson/databind/SerializerProvider;->constructSpecializedType(Lcom/fasterxml/jackson/databind/JavaType;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v1

    .line 128
    .local v1, "subtype":Lcom/fasterxml/jackson/databind/JavaType;
    invoke-virtual {p3, v1, p0}, Lcom/fasterxml/jackson/databind/SerializerProvider;->findValueSerializer(Lcom/fasterxml/jackson/databind/JavaType;Lcom/fasterxml/jackson/databind/BeanProperty;)Lcom/fasterxml/jackson/databind/JsonSerializer;

    move-result-object v0

    .line 132
    .end local v1    # "subtype":Lcom/fasterxml/jackson/databind/JavaType;
    .local v0, "serializer":Lcom/fasterxml/jackson/databind/JsonSerializer;, "Lcom/fasterxml/jackson/databind/JsonSerializer<Ljava/lang/Object;>;"
    :goto_0
    iget-object v2, p0, Lcom/fasterxml/jackson/databind/ser/impl/UnwrappingBeanPropertyWriter;->_nameTransformer:Lcom/fasterxml/jackson/databind/util/NameTransformer;

    .line 133
    .local v2, "t":Lcom/fasterxml/jackson/databind/util/NameTransformer;
    invoke-virtual {v0}, Lcom/fasterxml/jackson/databind/JsonSerializer;->isUnwrappingSerializer()Z

    move-result v3

    if-eqz v3, :cond_0

    move-object v3, v0

    .line 134
    check-cast v3, Lcom/fasterxml/jackson/databind/ser/impl/UnwrappingBeanSerializer;

    iget-object v3, v3, Lcom/fasterxml/jackson/databind/ser/impl/UnwrappingBeanSerializer;->_nameTransformer:Lcom/fasterxml/jackson/databind/util/NameTransformer;

    invoke-static {v2, v3}, Lcom/fasterxml/jackson/databind/util/NameTransformer;->chainedTransformer(Lcom/fasterxml/jackson/databind/util/NameTransformer;Lcom/fasterxml/jackson/databind/util/NameTransformer;)Lcom/fasterxml/jackson/databind/util/NameTransformer;

    move-result-object v2

    .line 136
    :cond_0
    invoke-virtual {v0, v2}, Lcom/fasterxml/jackson/databind/JsonSerializer;->unwrappingSerializer(Lcom/fasterxml/jackson/databind/util/NameTransformer;)Lcom/fasterxml/jackson/databind/JsonSerializer;

    move-result-object v0

    .line 138
    iget-object v3, p0, Lcom/fasterxml/jackson/databind/ser/impl/UnwrappingBeanPropertyWriter;->_dynamicSerializers:Lcom/fasterxml/jackson/databind/ser/impl/PropertySerializerMap;

    invoke-virtual {v3, p2, v0}, Lcom/fasterxml/jackson/databind/ser/impl/PropertySerializerMap;->newWith(Ljava/lang/Class;Lcom/fasterxml/jackson/databind/JsonSerializer;)Lcom/fasterxml/jackson/databind/ser/impl/PropertySerializerMap;

    move-result-object v3

    iput-object v3, p0, Lcom/fasterxml/jackson/databind/ser/impl/UnwrappingBeanPropertyWriter;->_dynamicSerializers:Lcom/fasterxml/jackson/databind/ser/impl/PropertySerializerMap;

    .line 139
    return-object v0

    .line 130
    .end local v0    # "serializer":Lcom/fasterxml/jackson/databind/JsonSerializer;, "Lcom/fasterxml/jackson/databind/JsonSerializer<Ljava/lang/Object;>;"
    .end local v2    # "t":Lcom/fasterxml/jackson/databind/util/NameTransformer;
    :cond_1
    invoke-virtual {p3, p2, p0}, Lcom/fasterxml/jackson/databind/SerializerProvider;->findValueSerializer(Ljava/lang/Class;Lcom/fasterxml/jackson/databind/BeanProperty;)Lcom/fasterxml/jackson/databind/JsonSerializer;

    move-result-object v0

    .restart local v0    # "serializer":Lcom/fasterxml/jackson/databind/JsonSerializer;, "Lcom/fasterxml/jackson/databind/JsonSerializer<Ljava/lang/Object;>;"
    goto :goto_0
.end method

.method public assignSerializer(Lcom/fasterxml/jackson/databind/JsonSerializer;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/fasterxml/jackson/databind/JsonSerializer",
            "<",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 110
    .local p1, "ser":Lcom/fasterxml/jackson/databind/JsonSerializer;, "Lcom/fasterxml/jackson/databind/JsonSerializer<Ljava/lang/Object;>;"
    invoke-super {p0, p1}, Lcom/fasterxml/jackson/databind/ser/BeanPropertyWriter;->assignSerializer(Lcom/fasterxml/jackson/databind/JsonSerializer;)V

    .line 111
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/ser/impl/UnwrappingBeanPropertyWriter;->_serializer:Lcom/fasterxml/jackson/databind/JsonSerializer;

    if-eqz v1, :cond_1

    .line 112
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/ser/impl/UnwrappingBeanPropertyWriter;->_nameTransformer:Lcom/fasterxml/jackson/databind/util/NameTransformer;

    .line 113
    .local v0, "t":Lcom/fasterxml/jackson/databind/util/NameTransformer;
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/ser/impl/UnwrappingBeanPropertyWriter;->_serializer:Lcom/fasterxml/jackson/databind/JsonSerializer;

    invoke-virtual {v1}, Lcom/fasterxml/jackson/databind/JsonSerializer;->isUnwrappingSerializer()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 114
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/ser/impl/UnwrappingBeanPropertyWriter;->_serializer:Lcom/fasterxml/jackson/databind/JsonSerializer;

    check-cast v1, Lcom/fasterxml/jackson/databind/ser/impl/UnwrappingBeanSerializer;

    iget-object v1, v1, Lcom/fasterxml/jackson/databind/ser/impl/UnwrappingBeanSerializer;->_nameTransformer:Lcom/fasterxml/jackson/databind/util/NameTransformer;

    invoke-static {v0, v1}, Lcom/fasterxml/jackson/databind/util/NameTransformer;->chainedTransformer(Lcom/fasterxml/jackson/databind/util/NameTransformer;Lcom/fasterxml/jackson/databind/util/NameTransformer;)Lcom/fasterxml/jackson/databind/util/NameTransformer;

    move-result-object v0

    .line 116
    :cond_0
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/ser/impl/UnwrappingBeanPropertyWriter;->_serializer:Lcom/fasterxml/jackson/databind/JsonSerializer;

    invoke-virtual {v1, v0}, Lcom/fasterxml/jackson/databind/JsonSerializer;->unwrappingSerializer(Lcom/fasterxml/jackson/databind/util/NameTransformer;)Lcom/fasterxml/jackson/databind/JsonSerializer;

    move-result-object v1

    iput-object v1, p0, Lcom/fasterxml/jackson/databind/ser/impl/UnwrappingBeanPropertyWriter;->_serializer:Lcom/fasterxml/jackson/databind/JsonSerializer;

    .line 118
    .end local v0    # "t":Lcom/fasterxml/jackson/databind/util/NameTransformer;
    :cond_1
    return-void
.end method

.method public bridge synthetic rename(Lcom/fasterxml/jackson/databind/util/NameTransformer;)Lcom/fasterxml/jackson/databind/ser/BeanPropertyWriter;
    .locals 1
    .param p1, "x0"    # Lcom/fasterxml/jackson/databind/util/NameTransformer;

    .prologue
    .line 17
    invoke-virtual {p0, p1}, Lcom/fasterxml/jackson/databind/ser/impl/UnwrappingBeanPropertyWriter;->rename(Lcom/fasterxml/jackson/databind/util/NameTransformer;)Lcom/fasterxml/jackson/databind/ser/impl/UnwrappingBeanPropertyWriter;

    move-result-object v0

    return-object v0
.end method

.method public rename(Lcom/fasterxml/jackson/databind/util/NameTransformer;)Lcom/fasterxml/jackson/databind/ser/impl/UnwrappingBeanPropertyWriter;
    .locals 4
    .param p1, "transformer"    # Lcom/fasterxml/jackson/databind/util/NameTransformer;

    .prologue
    .line 46
    iget-object v2, p0, Lcom/fasterxml/jackson/databind/ser/impl/UnwrappingBeanPropertyWriter;->_name:Lcom/fasterxml/jackson/core/io/SerializedString;

    invoke-virtual {v2}, Lcom/fasterxml/jackson/core/io/SerializedString;->getValue()Ljava/lang/String;

    move-result-object v1

    .line 47
    .local v1, "oldName":Ljava/lang/String;
    invoke-virtual {p1, v1}, Lcom/fasterxml/jackson/databind/util/NameTransformer;->transform(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 50
    .local v0, "newName":Ljava/lang/String;
    iget-object v2, p0, Lcom/fasterxml/jackson/databind/ser/impl/UnwrappingBeanPropertyWriter;->_nameTransformer:Lcom/fasterxml/jackson/databind/util/NameTransformer;

    invoke-static {p1, v2}, Lcom/fasterxml/jackson/databind/util/NameTransformer;->chainedTransformer(Lcom/fasterxml/jackson/databind/util/NameTransformer;Lcom/fasterxml/jackson/databind/util/NameTransformer;)Lcom/fasterxml/jackson/databind/util/NameTransformer;

    move-result-object p1

    .line 52
    new-instance v2, Lcom/fasterxml/jackson/databind/ser/impl/UnwrappingBeanPropertyWriter;

    new-instance v3, Lcom/fasterxml/jackson/core/io/SerializedString;

    invoke-direct {v3, v0}, Lcom/fasterxml/jackson/core/io/SerializedString;-><init>(Ljava/lang/String;)V

    invoke-direct {v2, p0, p1, v3}, Lcom/fasterxml/jackson/databind/ser/impl/UnwrappingBeanPropertyWriter;-><init>(Lcom/fasterxml/jackson/databind/ser/impl/UnwrappingBeanPropertyWriter;Lcom/fasterxml/jackson/databind/util/NameTransformer;Lcom/fasterxml/jackson/core/io/SerializedString;)V

    return-object v2
.end method

.method public serializeAsField(Ljava/lang/Object;Lcom/fasterxml/jackson/core/JsonGenerator;Lcom/fasterxml/jackson/databind/SerializerProvider;)V
    .locals 6
    .param p1, "bean"    # Ljava/lang/Object;
    .param p2, "jgen"    # Lcom/fasterxml/jackson/core/JsonGenerator;
    .param p3, "prov"    # Lcom/fasterxml/jackson/databind/SerializerProvider;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 65
    invoke-virtual {p0, p1}, Lcom/fasterxml/jackson/databind/ser/impl/UnwrappingBeanPropertyWriter;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    .line 66
    .local v3, "value":Ljava/lang/Object;
    if-nez v3, :cond_1

    .line 104
    :cond_0
    :goto_0
    return-void

    .line 71
    :cond_1
    iget-object v2, p0, Lcom/fasterxml/jackson/databind/ser/impl/UnwrappingBeanPropertyWriter;->_serializer:Lcom/fasterxml/jackson/databind/JsonSerializer;

    .line 72
    .local v2, "ser":Lcom/fasterxml/jackson/databind/JsonSerializer;, "Lcom/fasterxml/jackson/databind/JsonSerializer<Ljava/lang/Object;>;"
    if-nez v2, :cond_2

    .line 73
    invoke-virtual {v3}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    .line 74
    .local v0, "cls":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/ser/impl/UnwrappingBeanPropertyWriter;->_dynamicSerializers:Lcom/fasterxml/jackson/databind/ser/impl/PropertySerializerMap;

    .line 75
    .local v1, "map":Lcom/fasterxml/jackson/databind/ser/impl/PropertySerializerMap;
    invoke-virtual {v1, v0}, Lcom/fasterxml/jackson/databind/ser/impl/PropertySerializerMap;->serializerFor(Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/JsonSerializer;

    move-result-object v2

    .line 76
    if-nez v2, :cond_2

    .line 77
    invoke-virtual {p0, v1, v0, p3}, Lcom/fasterxml/jackson/databind/ser/impl/UnwrappingBeanPropertyWriter;->_findAndAddDynamic(Lcom/fasterxml/jackson/databind/ser/impl/PropertySerializerMap;Ljava/lang/Class;Lcom/fasterxml/jackson/databind/SerializerProvider;)Lcom/fasterxml/jackson/databind/JsonSerializer;

    move-result-object v2

    .line 80
    .end local v0    # "cls":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .end local v1    # "map":Lcom/fasterxml/jackson/databind/ser/impl/PropertySerializerMap;
    :cond_2
    iget-object v4, p0, Lcom/fasterxml/jackson/databind/ser/impl/UnwrappingBeanPropertyWriter;->_suppressableValue:Ljava/lang/Object;

    if-eqz v4, :cond_3

    .line 81
    sget-object v4, Lcom/fasterxml/jackson/databind/ser/impl/UnwrappingBeanPropertyWriter;->MARKER_FOR_EMPTY:Ljava/lang/Object;

    iget-object v5, p0, Lcom/fasterxml/jackson/databind/ser/impl/UnwrappingBeanPropertyWriter;->_suppressableValue:Ljava/lang/Object;

    if-ne v4, v5, :cond_6

    .line 82
    invoke-virtual {v2, v3}, Lcom/fasterxml/jackson/databind/JsonSerializer;->isEmpty(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 90
    :cond_3
    if-ne v3, p1, :cond_4

    .line 91
    invoke-virtual {p0, p1, v2}, Lcom/fasterxml/jackson/databind/ser/impl/UnwrappingBeanPropertyWriter;->_handleSelfReference(Ljava/lang/Object;Lcom/fasterxml/jackson/databind/JsonSerializer;)V

    .line 95
    :cond_4
    invoke-virtual {v2}, Lcom/fasterxml/jackson/databind/JsonSerializer;->isUnwrappingSerializer()Z

    move-result v4

    if-nez v4, :cond_5

    .line 96
    iget-object v4, p0, Lcom/fasterxml/jackson/databind/ser/impl/UnwrappingBeanPropertyWriter;->_name:Lcom/fasterxml/jackson/core/io/SerializedString;

    invoke-virtual {p2, v4}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeFieldName(Lcom/fasterxml/jackson/core/SerializableString;)V

    .line 99
    :cond_5
    iget-object v4, p0, Lcom/fasterxml/jackson/databind/ser/impl/UnwrappingBeanPropertyWriter;->_typeSerializer:Lcom/fasterxml/jackson/databind/jsontype/TypeSerializer;

    if-nez v4, :cond_7

    .line 100
    invoke-virtual {v2, v3, p2, p3}, Lcom/fasterxml/jackson/databind/JsonSerializer;->serialize(Ljava/lang/Object;Lcom/fasterxml/jackson/core/JsonGenerator;Lcom/fasterxml/jackson/databind/SerializerProvider;)V

    goto :goto_0

    .line 85
    :cond_6
    iget-object v4, p0, Lcom/fasterxml/jackson/databind/ser/impl/UnwrappingBeanPropertyWriter;->_suppressableValue:Ljava/lang/Object;

    invoke-virtual {v4, v3}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_3

    goto :goto_0

    .line 102
    :cond_7
    iget-object v4, p0, Lcom/fasterxml/jackson/databind/ser/impl/UnwrappingBeanPropertyWriter;->_typeSerializer:Lcom/fasterxml/jackson/databind/jsontype/TypeSerializer;

    invoke-virtual {v2, v3, p2, p3, v4}, Lcom/fasterxml/jackson/databind/JsonSerializer;->serializeWithType(Ljava/lang/Object;Lcom/fasterxml/jackson/core/JsonGenerator;Lcom/fasterxml/jackson/databind/SerializerProvider;Lcom/fasterxml/jackson/databind/jsontype/TypeSerializer;)V

    goto :goto_0
.end method
