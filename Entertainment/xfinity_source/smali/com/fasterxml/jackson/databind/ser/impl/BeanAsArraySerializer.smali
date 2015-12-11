.class public Lcom/fasterxml/jackson/databind/ser/impl/BeanAsArraySerializer;
.super Lcom/fasterxml/jackson/databind/ser/std/BeanSerializerBase;
.source "BeanAsArraySerializer.java"


# instance fields
.field protected final _defaultSerializer:Lcom/fasterxml/jackson/databind/ser/std/BeanSerializerBase;


# direct methods
.method public constructor <init>(Lcom/fasterxml/jackson/databind/ser/std/BeanSerializerBase;)V
    .locals 1
    .param p1, "src"    # Lcom/fasterxml/jackson/databind/ser/std/BeanSerializerBase;

    .prologue
    .line 64
    const/4 v0, 0x0

    check-cast v0, Lcom/fasterxml/jackson/databind/ser/impl/ObjectIdWriter;

    invoke-direct {p0, p1, v0}, Lcom/fasterxml/jackson/databind/ser/std/BeanSerializerBase;-><init>(Lcom/fasterxml/jackson/databind/ser/std/BeanSerializerBase;Lcom/fasterxml/jackson/databind/ser/impl/ObjectIdWriter;)V

    .line 65
    iput-object p1, p0, Lcom/fasterxml/jackson/databind/ser/impl/BeanAsArraySerializer;->_defaultSerializer:Lcom/fasterxml/jackson/databind/ser/std/BeanSerializerBase;

    .line 66
    return-void
.end method

.method protected constructor <init>(Lcom/fasterxml/jackson/databind/ser/std/BeanSerializerBase;[Ljava/lang/String;)V
    .locals 0
    .param p1, "src"    # Lcom/fasterxml/jackson/databind/ser/std/BeanSerializerBase;
    .param p2, "toIgnore"    # [Ljava/lang/String;

    .prologue
    .line 69
    invoke-direct {p0, p1, p2}, Lcom/fasterxml/jackson/databind/ser/std/BeanSerializerBase;-><init>(Lcom/fasterxml/jackson/databind/ser/std/BeanSerializerBase;[Ljava/lang/String;)V

    .line 70
    iput-object p1, p0, Lcom/fasterxml/jackson/databind/ser/impl/BeanAsArraySerializer;->_defaultSerializer:Lcom/fasterxml/jackson/databind/ser/std/BeanSerializerBase;

    .line 71
    return-void
.end method

.method private hasSingleElement(Lcom/fasterxml/jackson/databind/SerializerProvider;)Z
    .locals 3
    .param p1, "provider"    # Lcom/fasterxml/jackson/databind/SerializerProvider;

    .prologue
    const/4 v1, 0x1

    .line 158
    iget-object v2, p0, Lcom/fasterxml/jackson/databind/ser/impl/BeanAsArraySerializer;->_filteredProps:[Lcom/fasterxml/jackson/databind/ser/BeanPropertyWriter;

    if-eqz v2, :cond_0

    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/SerializerProvider;->getSerializationView()Ljava/lang/Class;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 159
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/ser/impl/BeanAsArraySerializer;->_filteredProps:[Lcom/fasterxml/jackson/databind/ser/BeanPropertyWriter;

    .line 163
    .local v0, "props":[Lcom/fasterxml/jackson/databind/ser/BeanPropertyWriter;
    :goto_0
    array-length v2, v0

    if-ne v2, v1, :cond_1

    :goto_1
    return v1

    .line 161
    .end local v0    # "props":[Lcom/fasterxml/jackson/databind/ser/BeanPropertyWriter;
    :cond_0
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/ser/impl/BeanAsArraySerializer;->_props:[Lcom/fasterxml/jackson/databind/ser/BeanPropertyWriter;

    .restart local v0    # "props":[Lcom/fasterxml/jackson/databind/ser/BeanPropertyWriter;
    goto :goto_0

    .line 163
    :cond_1
    const/4 v1, 0x0

    goto :goto_1
.end method


# virtual methods
.method protected asArraySerializer()Lcom/fasterxml/jackson/databind/ser/std/BeanSerializerBase;
    .locals 0

    .prologue
    .line 106
    return-object p0
.end method

.method public isUnwrappingSerializer()Z
    .locals 1

    .prologue
    .line 89
    const/4 v0, 0x0

    return v0
.end method

.method public final serialize(Ljava/lang/Object;Lcom/fasterxml/jackson/core/JsonGenerator;Lcom/fasterxml/jackson/databind/SerializerProvider;)V
    .locals 1
    .param p1, "bean"    # Ljava/lang/Object;
    .param p2, "jgen"    # Lcom/fasterxml/jackson/core/JsonGenerator;
    .param p3, "provider"    # Lcom/fasterxml/jackson/databind/SerializerProvider;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonGenerationException;
        }
    .end annotation

    .prologue
    .line 137
    sget-object v0, Lcom/fasterxml/jackson/databind/SerializationFeature;->WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED:Lcom/fasterxml/jackson/databind/SerializationFeature;

    invoke-virtual {p3, v0}, Lcom/fasterxml/jackson/databind/SerializerProvider;->isEnabled(Lcom/fasterxml/jackson/databind/SerializationFeature;)Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-direct {p0, p3}, Lcom/fasterxml/jackson/databind/ser/impl/BeanAsArraySerializer;->hasSingleElement(Lcom/fasterxml/jackson/databind/SerializerProvider;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 139
    invoke-virtual {p0, p1, p2, p3}, Lcom/fasterxml/jackson/databind/ser/impl/BeanAsArraySerializer;->serializeAsArray(Ljava/lang/Object;Lcom/fasterxml/jackson/core/JsonGenerator;Lcom/fasterxml/jackson/databind/SerializerProvider;)V

    .line 149
    :goto_0
    return-void

    .line 146
    :cond_0
    invoke-virtual {p2}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeStartArray()V

    .line 147
    invoke-virtual {p0, p1, p2, p3}, Lcom/fasterxml/jackson/databind/ser/impl/BeanAsArraySerializer;->serializeAsArray(Ljava/lang/Object;Lcom/fasterxml/jackson/core/JsonGenerator;Lcom/fasterxml/jackson/databind/SerializerProvider;)V

    .line 148
    invoke-virtual {p2}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeEndArray()V

    goto :goto_0
.end method

.method protected final serializeAsArray(Ljava/lang/Object;Lcom/fasterxml/jackson/core/JsonGenerator;Lcom/fasterxml/jackson/databind/SerializerProvider;)V
    .locals 8
    .param p1, "bean"    # Ljava/lang/Object;
    .param p2, "jgen"    # Lcom/fasterxml/jackson/core/JsonGenerator;
    .param p3, "provider"    # Lcom/fasterxml/jackson/databind/SerializerProvider;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonGenerationException;
        }
    .end annotation

    .prologue
    .line 170
    iget-object v7, p0, Lcom/fasterxml/jackson/databind/ser/impl/BeanAsArraySerializer;->_filteredProps:[Lcom/fasterxml/jackson/databind/ser/BeanPropertyWriter;

    if-eqz v7, :cond_0

    invoke-virtual {p3}, Lcom/fasterxml/jackson/databind/SerializerProvider;->getSerializationView()Ljava/lang/Class;

    move-result-object v7

    if-eqz v7, :cond_0

    .line 171
    iget-object v6, p0, Lcom/fasterxml/jackson/databind/ser/impl/BeanAsArraySerializer;->_filteredProps:[Lcom/fasterxml/jackson/databind/ser/BeanPropertyWriter;

    .line 176
    .local v6, "props":[Lcom/fasterxml/jackson/databind/ser/BeanPropertyWriter;
    :goto_0
    const/4 v1, 0x0

    .line 178
    .local v1, "i":I
    :try_start_0
    array-length v2, v6

    .local v2, "len":I
    :goto_1
    if-ge v1, v2, :cond_2

    .line 179
    aget-object v5, v6, v1

    .line 180
    .local v5, "prop":Lcom/fasterxml/jackson/databind/ser/BeanPropertyWriter;
    if-nez v5, :cond_1

    .line 181
    invoke-virtual {p2}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeNull()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/StackOverflowError; {:try_start_0 .. :try_end_0} :catch_1

    .line 178
    :goto_2
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 173
    .end local v1    # "i":I
    .end local v2    # "len":I
    .end local v5    # "prop":Lcom/fasterxml/jackson/databind/ser/BeanPropertyWriter;
    .end local v6    # "props":[Lcom/fasterxml/jackson/databind/ser/BeanPropertyWriter;
    :cond_0
    iget-object v6, p0, Lcom/fasterxml/jackson/databind/ser/impl/BeanAsArraySerializer;->_props:[Lcom/fasterxml/jackson/databind/ser/BeanPropertyWriter;

    .restart local v6    # "props":[Lcom/fasterxml/jackson/databind/ser/BeanPropertyWriter;
    goto :goto_0

    .line 183
    .restart local v1    # "i":I
    .restart local v2    # "len":I
    .restart local v5    # "prop":Lcom/fasterxml/jackson/databind/ser/BeanPropertyWriter;
    :cond_1
    :try_start_1
    invoke-virtual {v5, p1, p2, p3}, Lcom/fasterxml/jackson/databind/ser/BeanPropertyWriter;->serializeAsColumn(Ljava/lang/Object;Lcom/fasterxml/jackson/core/JsonGenerator;Lcom/fasterxml/jackson/databind/SerializerProvider;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/lang/StackOverflowError; {:try_start_1 .. :try_end_1} :catch_1

    goto :goto_2

    .line 190
    .end local v2    # "len":I
    .end local v5    # "prop":Lcom/fasterxml/jackson/databind/ser/BeanPropertyWriter;
    :catch_0
    move-exception v0

    .line 191
    .local v0, "e":Ljava/lang/Exception;
    array-length v7, v6

    if-ne v1, v7, :cond_3

    const-string v4, "[anySetter]"

    .line 192
    .local v4, "name":Ljava/lang/String;
    :goto_3
    invoke-virtual {p0, p3, v0, p1, v4}, Lcom/fasterxml/jackson/databind/ser/impl/BeanAsArraySerializer;->wrapAndThrow(Lcom/fasterxml/jackson/databind/SerializerProvider;Ljava/lang/Throwable;Ljava/lang/Object;Ljava/lang/String;)V

    .line 199
    .end local v0    # "e":Ljava/lang/Exception;
    .end local v4    # "name":Ljava/lang/String;
    :cond_2
    return-void

    .line 191
    .restart local v0    # "e":Ljava/lang/Exception;
    :cond_3
    aget-object v7, v6, v1

    invoke-virtual {v7}, Lcom/fasterxml/jackson/databind/ser/BeanPropertyWriter;->getName()Ljava/lang/String;

    move-result-object v4

    goto :goto_3

    .line 193
    .end local v0    # "e":Ljava/lang/Exception;
    :catch_1
    move-exception v0

    .line 194
    .local v0, "e":Ljava/lang/StackOverflowError;
    new-instance v3, Lcom/fasterxml/jackson/databind/JsonMappingException;

    const-string v7, "Infinite recursion (StackOverflowError)"

    invoke-direct {v3, v7, v0}, Lcom/fasterxml/jackson/databind/JsonMappingException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 195
    .local v3, "mapE":Lcom/fasterxml/jackson/databind/JsonMappingException;
    array-length v7, v6

    if-ne v1, v7, :cond_4

    const-string v4, "[anySetter]"

    .line 196
    .restart local v4    # "name":Ljava/lang/String;
    :goto_4
    new-instance v7, Lcom/fasterxml/jackson/databind/JsonMappingException$Reference;

    invoke-direct {v7, p1, v4}, Lcom/fasterxml/jackson/databind/JsonMappingException$Reference;-><init>(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {v3, v7}, Lcom/fasterxml/jackson/databind/JsonMappingException;->prependPath(Lcom/fasterxml/jackson/databind/JsonMappingException$Reference;)V

    .line 197
    throw v3

    .line 195
    .end local v4    # "name":Ljava/lang/String;
    :cond_4
    aget-object v7, v6, v1

    invoke-virtual {v7}, Lcom/fasterxml/jackson/databind/ser/BeanPropertyWriter;->getName()Ljava/lang/String;

    move-result-object v4

    goto :goto_4
.end method

.method public serializeWithType(Ljava/lang/Object;Lcom/fasterxml/jackson/core/JsonGenerator;Lcom/fasterxml/jackson/databind/SerializerProvider;Lcom/fasterxml/jackson/databind/jsontype/TypeSerializer;)V
    .locals 1
    .param p1, "bean"    # Ljava/lang/Object;
    .param p2, "jgen"    # Lcom/fasterxml/jackson/core/JsonGenerator;
    .param p3, "provider"    # Lcom/fasterxml/jackson/databind/SerializerProvider;
    .param p4, "typeSer"    # Lcom/fasterxml/jackson/databind/jsontype/TypeSerializer;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonGenerationException;
        }
    .end annotation

    .prologue
    .line 124
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/ser/impl/BeanAsArraySerializer;->_defaultSerializer:Lcom/fasterxml/jackson/databind/ser/std/BeanSerializerBase;

    invoke-virtual {v0, p1, p2, p3, p4}, Lcom/fasterxml/jackson/databind/ser/std/BeanSerializerBase;->serializeWithType(Ljava/lang/Object;Lcom/fasterxml/jackson/core/JsonGenerator;Lcom/fasterxml/jackson/databind/SerializerProvider;Lcom/fasterxml/jackson/databind/jsontype/TypeSerializer;)V

    .line 125
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 208
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
    .param p1, "transformer"    # Lcom/fasterxml/jackson/databind/util/NameTransformer;
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
    .line 84
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/ser/impl/BeanAsArraySerializer;->_defaultSerializer:Lcom/fasterxml/jackson/databind/ser/std/BeanSerializerBase;

    invoke-virtual {v0, p1}, Lcom/fasterxml/jackson/databind/ser/std/BeanSerializerBase;->unwrappingSerializer(Lcom/fasterxml/jackson/databind/util/NameTransformer;)Lcom/fasterxml/jackson/databind/JsonSerializer;

    move-result-object v0

    return-object v0
.end method

.method protected withIgnorals([Ljava/lang/String;)Lcom/fasterxml/jackson/databind/ser/impl/BeanAsArraySerializer;
    .locals 1
    .param p1, "toIgnore"    # [Ljava/lang/String;

    .prologue
    .line 100
    new-instance v0, Lcom/fasterxml/jackson/databind/ser/impl/BeanAsArraySerializer;

    invoke-direct {v0, p0, p1}, Lcom/fasterxml/jackson/databind/ser/impl/BeanAsArraySerializer;-><init>(Lcom/fasterxml/jackson/databind/ser/std/BeanSerializerBase;[Ljava/lang/String;)V

    return-object v0
.end method

.method protected bridge synthetic withIgnorals([Ljava/lang/String;)Lcom/fasterxml/jackson/databind/ser/std/BeanSerializerBase;
    .locals 1
    .param p1, "x0"    # [Ljava/lang/String;

    .prologue
    .line 47
    invoke-virtual {p0, p1}, Lcom/fasterxml/jackson/databind/ser/impl/BeanAsArraySerializer;->withIgnorals([Ljava/lang/String;)Lcom/fasterxml/jackson/databind/ser/impl/BeanAsArraySerializer;

    move-result-object v0

    return-object v0
.end method

.method public withObjectIdWriter(Lcom/fasterxml/jackson/databind/ser/impl/ObjectIdWriter;)Lcom/fasterxml/jackson/databind/ser/std/BeanSerializerBase;
    .locals 1
    .param p1, "objectIdWriter"    # Lcom/fasterxml/jackson/databind/ser/impl/ObjectIdWriter;

    .prologue
    .line 95
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/ser/impl/BeanAsArraySerializer;->_defaultSerializer:Lcom/fasterxml/jackson/databind/ser/std/BeanSerializerBase;

    invoke-virtual {v0, p1}, Lcom/fasterxml/jackson/databind/ser/std/BeanSerializerBase;->withObjectIdWriter(Lcom/fasterxml/jackson/databind/ser/impl/ObjectIdWriter;)Lcom/fasterxml/jackson/databind/ser/std/BeanSerializerBase;

    move-result-object v0

    return-object v0
.end method
