.class public Lcom/fasterxml/jackson/databind/ser/impl/BeanAsArraySerializer;
.super Lcom/fasterxml/jackson/databind/ser/std/BeanSerializerBase;
.source "BeanAsArraySerializer.java"


# instance fields
.field protected final _defaultSerializer:Lcom/fasterxml/jackson/databind/ser/std/BeanSerializerBase;


# direct methods
.method public constructor <init>(Lcom/fasterxml/jackson/databind/ser/std/BeanSerializerBase;)V
    .locals 1

    .prologue
    .line 60
    const/4 v0, 0x0

    check-cast v0, Lcom/fasterxml/jackson/databind/ser/impl/ObjectIdWriter;

    invoke-direct {p0, p1, v0}, Lcom/fasterxml/jackson/databind/ser/std/BeanSerializerBase;-><init>(Lcom/fasterxml/jackson/databind/ser/std/BeanSerializerBase;Lcom/fasterxml/jackson/databind/ser/impl/ObjectIdWriter;)V

    .line 61
    iput-object p1, p0, Lcom/fasterxml/jackson/databind/ser/impl/BeanAsArraySerializer;->_defaultSerializer:Lcom/fasterxml/jackson/databind/ser/std/BeanSerializerBase;

    .line 62
    return-void
.end method

.method protected constructor <init>(Lcom/fasterxml/jackson/databind/ser/std/BeanSerializerBase;Lcom/fasterxml/jackson/databind/ser/impl/ObjectIdWriter;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 71
    invoke-direct {p0, p1, p2, p3}, Lcom/fasterxml/jackson/databind/ser/std/BeanSerializerBase;-><init>(Lcom/fasterxml/jackson/databind/ser/std/BeanSerializerBase;Lcom/fasterxml/jackson/databind/ser/impl/ObjectIdWriter;Ljava/lang/Object;)V

    .line 72
    iput-object p1, p0, Lcom/fasterxml/jackson/databind/ser/impl/BeanAsArraySerializer;->_defaultSerializer:Lcom/fasterxml/jackson/databind/ser/std/BeanSerializerBase;

    .line 73
    return-void
.end method

.method protected constructor <init>(Lcom/fasterxml/jackson/databind/ser/std/BeanSerializerBase;[Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 65
    invoke-direct {p0, p1, p2}, Lcom/fasterxml/jackson/databind/ser/std/BeanSerializerBase;-><init>(Lcom/fasterxml/jackson/databind/ser/std/BeanSerializerBase;[Ljava/lang/String;)V

    .line 66
    iput-object p1, p0, Lcom/fasterxml/jackson/databind/ser/impl/BeanAsArraySerializer;->_defaultSerializer:Lcom/fasterxml/jackson/databind/ser/std/BeanSerializerBase;

    .line 67
    return-void
.end method

.method private hasSingleElement(Lcom/fasterxml/jackson/databind/SerializerProvider;)Z
    .locals 2

    .prologue
    const/4 v1, 0x1

    .line 166
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/ser/impl/BeanAsArraySerializer;->_filteredProps:[Lcom/fasterxml/jackson/databind/ser/BeanPropertyWriter;

    if-eqz v0, :cond_0

    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/SerializerProvider;->getActiveView()Ljava/lang/Class;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 167
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/ser/impl/BeanAsArraySerializer;->_filteredProps:[Lcom/fasterxml/jackson/databind/ser/BeanPropertyWriter;

    .line 171
    :goto_0
    array-length v0, v0

    if-ne v0, v1, :cond_1

    move v0, v1

    :goto_1
    return v0

    .line 169
    :cond_0
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/ser/impl/BeanAsArraySerializer;->_props:[Lcom/fasterxml/jackson/databind/ser/BeanPropertyWriter;

    goto :goto_0

    .line 171
    :cond_1
    const/4 v0, 0x0

    goto :goto_1
.end method


# virtual methods
.method protected asArraySerializer()Lcom/fasterxml/jackson/databind/ser/std/BeanSerializerBase;
    .locals 0

    .prologue
    .line 113
    return-object p0
.end method

.method public isUnwrappingSerializer()Z
    .locals 1

    .prologue
    .line 91
    const/4 v0, 0x0

    return v0
.end method

.method public final serialize(Ljava/lang/Object;Lcom/fasterxml/jackson/core/JsonGenerator;Lcom/fasterxml/jackson/databind/SerializerProvider;)V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonGenerationException;
        }
    .end annotation

    .prologue
    .line 144
    sget-object v0, Lcom/fasterxml/jackson/databind/SerializationFeature;->WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED:Lcom/fasterxml/jackson/databind/SerializationFeature;

    invoke-virtual {p3, v0}, Lcom/fasterxml/jackson/databind/SerializerProvider;->isEnabled(Lcom/fasterxml/jackson/databind/SerializationFeature;)Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-direct {p0, p3}, Lcom/fasterxml/jackson/databind/ser/impl/BeanAsArraySerializer;->hasSingleElement(Lcom/fasterxml/jackson/databind/SerializerProvider;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 146
    invoke-virtual {p0, p1, p2, p3}, Lcom/fasterxml/jackson/databind/ser/impl/BeanAsArraySerializer;->serializeAsArray(Ljava/lang/Object;Lcom/fasterxml/jackson/core/JsonGenerator;Lcom/fasterxml/jackson/databind/SerializerProvider;)V

    .line 156
    :goto_0
    return-void

    .line 153
    :cond_0
    invoke-virtual {p2}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeStartArray()V

    .line 154
    invoke-virtual {p0, p1, p2, p3}, Lcom/fasterxml/jackson/databind/ser/impl/BeanAsArraySerializer;->serializeAsArray(Ljava/lang/Object;Lcom/fasterxml/jackson/core/JsonGenerator;Lcom/fasterxml/jackson/databind/SerializerProvider;)V

    .line 155
    invoke-virtual {p2}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeEndArray()V

    goto :goto_0
.end method

.method protected final serializeAsArray(Ljava/lang/Object;Lcom/fasterxml/jackson/core/JsonGenerator;Lcom/fasterxml/jackson/databind/SerializerProvider;)V
    .locals 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonGenerationException;
        }
    .end annotation

    .prologue
    .line 178
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/ser/impl/BeanAsArraySerializer;->_filteredProps:[Lcom/fasterxml/jackson/databind/ser/BeanPropertyWriter;

    if-eqz v0, :cond_0

    invoke-virtual {p3}, Lcom/fasterxml/jackson/databind/SerializerProvider;->getActiveView()Ljava/lang/Class;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 179
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/ser/impl/BeanAsArraySerializer;->_filteredProps:[Lcom/fasterxml/jackson/databind/ser/BeanPropertyWriter;

    .line 184
    :goto_0
    const/4 v2, 0x0

    .line 186
    :try_start_0
    array-length v1, v0

    :goto_1
    if-ge v2, v1, :cond_2

    .line 187
    aget-object v3, v0, v2

    .line 188
    if-nez v3, :cond_1

    .line 189
    invoke-virtual {p2}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeNull()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/StackOverflowError; {:try_start_0 .. :try_end_0} :catch_1

    .line 186
    :goto_2
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 181
    :cond_0
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/ser/impl/BeanAsArraySerializer;->_props:[Lcom/fasterxml/jackson/databind/ser/BeanPropertyWriter;

    goto :goto_0

    .line 191
    :cond_1
    :try_start_1
    invoke-virtual {v3, p1, p2, p3}, Lcom/fasterxml/jackson/databind/ser/BeanPropertyWriter;->serializeAsElement(Ljava/lang/Object;Lcom/fasterxml/jackson/core/JsonGenerator;Lcom/fasterxml/jackson/databind/SerializerProvider;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/lang/StackOverflowError; {:try_start_1 .. :try_end_1} :catch_1

    goto :goto_2

    .line 198
    :catch_0
    move-exception v1

    .line 199
    array-length v3, v0

    if-ne v2, v3, :cond_3

    const-string v0, "[anySetter]"

    .line 200
    :goto_3
    invoke-virtual {p0, p3, v1, p1, v0}, Lcom/fasterxml/jackson/databind/ser/impl/BeanAsArraySerializer;->wrapAndThrow(Lcom/fasterxml/jackson/databind/SerializerProvider;Ljava/lang/Throwable;Ljava/lang/Object;Ljava/lang/String;)V

    .line 207
    :cond_2
    return-void

    .line 199
    :cond_3
    aget-object v0, v0, v2

    invoke-virtual {v0}, Lcom/fasterxml/jackson/databind/ser/BeanPropertyWriter;->getName()Ljava/lang/String;

    move-result-object v0

    goto :goto_3

    .line 201
    :catch_1
    move-exception v1

    .line 202
    new-instance v3, Lcom/fasterxml/jackson/databind/JsonMappingException;

    const-string v4, "Infinite recursion (StackOverflowError)"

    invoke-direct {v3, v4, v1}, Lcom/fasterxml/jackson/databind/JsonMappingException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 203
    array-length v1, v0

    if-ne v2, v1, :cond_4

    const-string v0, "[anySetter]"

    .line 204
    :goto_4
    new-instance v1, Lcom/fasterxml/jackson/databind/JsonMappingException$Reference;

    invoke-direct {v1, p1, v0}, Lcom/fasterxml/jackson/databind/JsonMappingException$Reference;-><init>(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {v3, v1}, Lcom/fasterxml/jackson/databind/JsonMappingException;->prependPath(Lcom/fasterxml/jackson/databind/JsonMappingException$Reference;)V

    .line 205
    throw v3

    .line 203
    :cond_4
    aget-object v0, v0, v2

    invoke-virtual {v0}, Lcom/fasterxml/jackson/databind/ser/BeanPropertyWriter;->getName()Ljava/lang/String;

    move-result-object v0

    goto :goto_4
.end method

.method public serializeWithType(Ljava/lang/Object;Lcom/fasterxml/jackson/core/JsonGenerator;Lcom/fasterxml/jackson/databind/SerializerProvider;Lcom/fasterxml/jackson/databind/jsontype/TypeSerializer;)V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonGenerationException;
        }
    .end annotation

    .prologue
    .line 131
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/ser/impl/BeanAsArraySerializer;->_defaultSerializer:Lcom/fasterxml/jackson/databind/ser/std/BeanSerializerBase;

    invoke-virtual {v0, p1, p2, p3, p4}, Lcom/fasterxml/jackson/databind/ser/std/BeanSerializerBase;->serializeWithType(Ljava/lang/Object;Lcom/fasterxml/jackson/core/JsonGenerator;Lcom/fasterxml/jackson/databind/SerializerProvider;Lcom/fasterxml/jackson/databind/jsontype/TypeSerializer;)V

    .line 132
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 216
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "BeanAsArraySerializer for "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p0}, Lcom/fasterxml/jackson/databind/ser/impl/BeanAsArraySerializer;->handledType()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public unwrappingSerializer(Lcom/fasterxml/jackson/databind/util/NameTransformer;)Lcom/fasterxml/jackson/databind/JsonSerializer;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/fasterxml/jackson/databind/util/NameTransformer;",
            ")",
            "Lcom/fasterxml/jackson/databind/JsonSerializer",
            "<",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation

    .prologue
    .line 86
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/ser/impl/BeanAsArraySerializer;->_defaultSerializer:Lcom/fasterxml/jackson/databind/ser/std/BeanSerializerBase;

    invoke-virtual {v0, p1}, Lcom/fasterxml/jackson/databind/ser/std/BeanSerializerBase;->unwrappingSerializer(Lcom/fasterxml/jackson/databind/util/NameTransformer;)Lcom/fasterxml/jackson/databind/JsonSerializer;

    move-result-object v0

    return-object v0
.end method

.method protected withFilterId(Ljava/lang/Object;)Lcom/fasterxml/jackson/databind/ser/std/BeanSerializerBase;
    .locals 2

    .prologue
    .line 102
    new-instance v0, Lcom/fasterxml/jackson/databind/ser/impl/BeanAsArraySerializer;

    iget-object v1, p0, Lcom/fasterxml/jackson/databind/ser/impl/BeanAsArraySerializer;->_objectIdWriter:Lcom/fasterxml/jackson/databind/ser/impl/ObjectIdWriter;

    invoke-direct {v0, p0, v1, p1}, Lcom/fasterxml/jackson/databind/ser/impl/BeanAsArraySerializer;-><init>(Lcom/fasterxml/jackson/databind/ser/std/BeanSerializerBase;Lcom/fasterxml/jackson/databind/ser/impl/ObjectIdWriter;Ljava/lang/Object;)V

    return-object v0
.end method

.method protected withIgnorals([Ljava/lang/String;)Lcom/fasterxml/jackson/databind/ser/impl/BeanAsArraySerializer;
    .locals 1

    .prologue
    .line 107
    new-instance v0, Lcom/fasterxml/jackson/databind/ser/impl/BeanAsArraySerializer;

    invoke-direct {v0, p0, p1}, Lcom/fasterxml/jackson/databind/ser/impl/BeanAsArraySerializer;-><init>(Lcom/fasterxml/jackson/databind/ser/std/BeanSerializerBase;[Ljava/lang/String;)V

    return-object v0
.end method

.method protected bridge synthetic withIgnorals([Ljava/lang/String;)Lcom/fasterxml/jackson/databind/ser/std/BeanSerializerBase;
    .locals 1

    .prologue
    .line 44
    invoke-virtual {p0, p1}, Lcom/fasterxml/jackson/databind/ser/impl/BeanAsArraySerializer;->withIgnorals([Ljava/lang/String;)Lcom/fasterxml/jackson/databind/ser/impl/BeanAsArraySerializer;

    move-result-object v0

    return-object v0
.end method

.method public withObjectIdWriter(Lcom/fasterxml/jackson/databind/ser/impl/ObjectIdWriter;)Lcom/fasterxml/jackson/databind/ser/std/BeanSerializerBase;
    .locals 1

    .prologue
    .line 97
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/ser/impl/BeanAsArraySerializer;->_defaultSerializer:Lcom/fasterxml/jackson/databind/ser/std/BeanSerializerBase;

    invoke-virtual {v0, p1}, Lcom/fasterxml/jackson/databind/ser/std/BeanSerializerBase;->withObjectIdWriter(Lcom/fasterxml/jackson/databind/ser/impl/ObjectIdWriter;)Lcom/fasterxml/jackson/databind/ser/std/BeanSerializerBase;

    move-result-object v0

    return-object v0
.end method
