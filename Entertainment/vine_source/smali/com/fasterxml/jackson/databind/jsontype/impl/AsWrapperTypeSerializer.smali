.class public Lcom/fasterxml/jackson/databind/jsontype/impl/AsWrapperTypeSerializer;
.super Lcom/fasterxml/jackson/databind/jsontype/impl/TypeSerializerBase;
.source "AsWrapperTypeSerializer.java"


# direct methods
.method public constructor <init>(Lcom/fasterxml/jackson/databind/jsontype/TypeIdResolver;Lcom/fasterxml/jackson/databind/BeanProperty;)V
    .locals 0

    .prologue
    .line 24
    invoke-direct {p0, p1, p2}, Lcom/fasterxml/jackson/databind/jsontype/impl/TypeSerializerBase;-><init>(Lcom/fasterxml/jackson/databind/jsontype/TypeIdResolver;Lcom/fasterxml/jackson/databind/BeanProperty;)V

    .line 25
    return-void
.end method


# virtual methods
.method public bridge synthetic forProperty(Lcom/fasterxml/jackson/databind/BeanProperty;)Lcom/fasterxml/jackson/databind/jsontype/TypeSerializer;
    .locals 1

    .prologue
    .line 19
    invoke-virtual {p0, p1}, Lcom/fasterxml/jackson/databind/jsontype/impl/AsWrapperTypeSerializer;->forProperty(Lcom/fasterxml/jackson/databind/BeanProperty;)Lcom/fasterxml/jackson/databind/jsontype/impl/AsWrapperTypeSerializer;

    move-result-object v0

    return-object v0
.end method

.method public forProperty(Lcom/fasterxml/jackson/databind/BeanProperty;)Lcom/fasterxml/jackson/databind/jsontype/impl/AsWrapperTypeSerializer;
    .locals 2

    .prologue
    .line 29
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/jsontype/impl/AsWrapperTypeSerializer;->_property:Lcom/fasterxml/jackson/databind/BeanProperty;

    if-ne v0, p1, :cond_0

    .line 30
    :goto_0
    return-object p0

    :cond_0
    new-instance v0, Lcom/fasterxml/jackson/databind/jsontype/impl/AsWrapperTypeSerializer;

    iget-object v1, p0, Lcom/fasterxml/jackson/databind/jsontype/impl/AsWrapperTypeSerializer;->_idResolver:Lcom/fasterxml/jackson/databind/jsontype/TypeIdResolver;

    invoke-direct {v0, v1, p1}, Lcom/fasterxml/jackson/databind/jsontype/impl/AsWrapperTypeSerializer;-><init>(Lcom/fasterxml/jackson/databind/jsontype/TypeIdResolver;Lcom/fasterxml/jackson/databind/BeanProperty;)V

    move-object p0, v0

    goto :goto_0
.end method

.method public getTypeInclusion()Lcom/fasterxml/jackson/annotation/JsonTypeInfo$As;
    .locals 1

    .prologue
    .line 34
    sget-object v0, Lcom/fasterxml/jackson/annotation/JsonTypeInfo$As;->WRAPPER_OBJECT:Lcom/fasterxml/jackson/annotation/JsonTypeInfo$As;

    return-object v0
.end method

.method public writeCustomTypePrefixForArray(Ljava/lang/Object;Lcom/fasterxml/jackson/core/JsonGenerator;Ljava/lang/String;)V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonProcessingException;
        }
    .end annotation

    .prologue
    .line 188
    invoke-virtual {p2}, Lcom/fasterxml/jackson/core/JsonGenerator;->canWriteTypeId()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 189
    invoke-virtual {p2, p3}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeTypeId(Ljava/lang/Object;)V

    .line 190
    invoke-virtual {p2}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeStartArray()V

    .line 195
    :goto_0
    return-void

    .line 192
    :cond_0
    invoke-virtual {p2}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeStartObject()V

    .line 193
    invoke-virtual {p2, p3}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeArrayFieldStart(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public writeCustomTypePrefixForObject(Ljava/lang/Object;Lcom/fasterxml/jackson/core/JsonGenerator;Ljava/lang/String;)V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonProcessingException;
        }
    .end annotation

    .prologue
    .line 175
    invoke-virtual {p2}, Lcom/fasterxml/jackson/core/JsonGenerator;->canWriteTypeId()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 176
    invoke-virtual {p2, p3}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeTypeId(Ljava/lang/Object;)V

    .line 177
    invoke-virtual {p2}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeStartObject()V

    .line 182
    :goto_0
    return-void

    .line 179
    :cond_0
    invoke-virtual {p2}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeStartObject()V

    .line 180
    invoke-virtual {p2, p3}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeObjectFieldStart(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public writeCustomTypePrefixForScalar(Ljava/lang/Object;Lcom/fasterxml/jackson/core/JsonGenerator;Ljava/lang/String;)V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonProcessingException;
        }
    .end annotation

    .prologue
    .line 201
    invoke-virtual {p2}, Lcom/fasterxml/jackson/core/JsonGenerator;->canWriteTypeId()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 202
    invoke-virtual {p2, p3}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeTypeId(Ljava/lang/Object;)V

    .line 207
    :goto_0
    return-void

    .line 204
    :cond_0
    invoke-virtual {p2}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeStartObject()V

    .line 205
    invoke-virtual {p2, p3}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeFieldName(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public writeCustomTypeSuffixForArray(Ljava/lang/Object;Lcom/fasterxml/jackson/core/JsonGenerator;Ljava/lang/String;)V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonProcessingException;
        }
    .end annotation

    .prologue
    .line 220
    invoke-virtual {p2}, Lcom/fasterxml/jackson/core/JsonGenerator;->canWriteTypeId()Z

    move-result v0

    if-nez v0, :cond_0

    .line 221
    invoke-virtual {p0, p1, p2}, Lcom/fasterxml/jackson/databind/jsontype/impl/AsWrapperTypeSerializer;->writeTypeSuffixForArray(Ljava/lang/Object;Lcom/fasterxml/jackson/core/JsonGenerator;)V

    .line 223
    :cond_0
    return-void
.end method

.method public writeCustomTypeSuffixForObject(Ljava/lang/Object;Lcom/fasterxml/jackson/core/JsonGenerator;Ljava/lang/String;)V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonProcessingException;
        }
    .end annotation

    .prologue
    .line 212
    invoke-virtual {p2}, Lcom/fasterxml/jackson/core/JsonGenerator;->canWriteTypeId()Z

    move-result v0

    if-nez v0, :cond_0

    .line 213
    invoke-virtual {p0, p1, p2}, Lcom/fasterxml/jackson/databind/jsontype/impl/AsWrapperTypeSerializer;->writeTypeSuffixForObject(Ljava/lang/Object;Lcom/fasterxml/jackson/core/JsonGenerator;)V

    .line 215
    :cond_0
    return-void
.end method

.method public writeCustomTypeSuffixForScalar(Ljava/lang/Object;Lcom/fasterxml/jackson/core/JsonGenerator;Ljava/lang/String;)V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonProcessingException;
        }
    .end annotation

    .prologue
    .line 228
    invoke-virtual {p2}, Lcom/fasterxml/jackson/core/JsonGenerator;->canWriteTypeId()Z

    move-result v0

    if-nez v0, :cond_0

    .line 229
    invoke-virtual {p0, p1, p2}, Lcom/fasterxml/jackson/databind/jsontype/impl/AsWrapperTypeSerializer;->writeTypeSuffixForScalar(Ljava/lang/Object;Lcom/fasterxml/jackson/core/JsonGenerator;)V

    .line 231
    :cond_0
    return-void
.end method

.method public writeTypePrefixForArray(Ljava/lang/Object;Lcom/fasterxml/jackson/core/JsonGenerator;)V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonProcessingException;
        }
    .end annotation

    .prologue
    .line 73
    invoke-virtual {p0, p1}, Lcom/fasterxml/jackson/databind/jsontype/impl/AsWrapperTypeSerializer;->idFromValue(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 74
    invoke-virtual {p2}, Lcom/fasterxml/jackson/core/JsonGenerator;->canWriteTypeId()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 75
    invoke-virtual {p2, v0}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeTypeId(Ljava/lang/Object;)V

    .line 76
    invoke-virtual {p2}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeStartObject()V

    .line 83
    :goto_0
    return-void

    .line 79
    :cond_0
    invoke-virtual {p2}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeStartObject()V

    .line 81
    invoke-virtual {p2, v0}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeArrayFieldStart(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public writeTypePrefixForArray(Ljava/lang/Object;Lcom/fasterxml/jackson/core/JsonGenerator;Ljava/lang/Class;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Object;",
            "Lcom/fasterxml/jackson/core/JsonGenerator;",
            "Ljava/lang/Class",
            "<*>;)V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonProcessingException;
        }
    .end annotation

    .prologue
    .line 90
    invoke-virtual {p0, p1, p3}, Lcom/fasterxml/jackson/databind/jsontype/impl/AsWrapperTypeSerializer;->idFromValueAndType(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/String;

    move-result-object v0

    .line 91
    invoke-virtual {p2}, Lcom/fasterxml/jackson/core/JsonGenerator;->canWriteTypeId()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 92
    invoke-virtual {p2, v0}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeTypeId(Ljava/lang/Object;)V

    .line 93
    invoke-virtual {p2}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeStartObject()V

    .line 100
    :goto_0
    return-void

    .line 96
    :cond_0
    invoke-virtual {p2}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeStartObject()V

    .line 98
    invoke-virtual {p2, v0}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeArrayFieldStart(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public writeTypePrefixForObject(Ljava/lang/Object;Lcom/fasterxml/jackson/core/JsonGenerator;)V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonProcessingException;
        }
    .end annotation

    .prologue
    .line 40
    invoke-virtual {p0, p1}, Lcom/fasterxml/jackson/databind/jsontype/impl/AsWrapperTypeSerializer;->idFromValue(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 41
    invoke-virtual {p2}, Lcom/fasterxml/jackson/core/JsonGenerator;->canWriteTypeId()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 42
    invoke-virtual {p2, v0}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeTypeId(Ljava/lang/Object;)V

    .line 43
    invoke-virtual {p2}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeStartObject()V

    .line 50
    :goto_0
    return-void

    .line 46
    :cond_0
    invoke-virtual {p2}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeStartObject()V

    .line 48
    invoke-virtual {p2, v0}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeObjectFieldStart(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public writeTypePrefixForObject(Ljava/lang/Object;Lcom/fasterxml/jackson/core/JsonGenerator;Ljava/lang/Class;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Object;",
            "Lcom/fasterxml/jackson/core/JsonGenerator;",
            "Ljava/lang/Class",
            "<*>;)V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonProcessingException;
        }
    .end annotation

    .prologue
    .line 57
    invoke-virtual {p0, p1, p3}, Lcom/fasterxml/jackson/databind/jsontype/impl/AsWrapperTypeSerializer;->idFromValueAndType(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/String;

    move-result-object v0

    .line 58
    invoke-virtual {p2}, Lcom/fasterxml/jackson/core/JsonGenerator;->canWriteTypeId()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 59
    invoke-virtual {p2, v0}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeTypeId(Ljava/lang/Object;)V

    .line 60
    invoke-virtual {p2}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeStartObject()V

    .line 67
    :goto_0
    return-void

    .line 63
    :cond_0
    invoke-virtual {p2}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeStartObject()V

    .line 65
    invoke-virtual {p2, v0}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeObjectFieldStart(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public writeTypePrefixForScalar(Ljava/lang/Object;Lcom/fasterxml/jackson/core/JsonGenerator;)V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonProcessingException;
        }
    .end annotation

    .prologue
    .line 106
    invoke-virtual {p0, p1}, Lcom/fasterxml/jackson/databind/jsontype/impl/AsWrapperTypeSerializer;->idFromValue(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 107
    invoke-virtual {p2}, Lcom/fasterxml/jackson/core/JsonGenerator;->canWriteTypeId()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 108
    invoke-virtual {p2, v0}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeTypeId(Ljava/lang/Object;)V

    .line 114
    :goto_0
    return-void

    .line 111
    :cond_0
    invoke-virtual {p2}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeStartObject()V

    .line 112
    invoke-virtual {p2, v0}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeFieldName(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public writeTypePrefixForScalar(Ljava/lang/Object;Lcom/fasterxml/jackson/core/JsonGenerator;Ljava/lang/Class;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Object;",
            "Lcom/fasterxml/jackson/core/JsonGenerator;",
            "Ljava/lang/Class",
            "<*>;)V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonProcessingException;
        }
    .end annotation

    .prologue
    .line 121
    invoke-virtual {p0, p1, p3}, Lcom/fasterxml/jackson/databind/jsontype/impl/AsWrapperTypeSerializer;->idFromValueAndType(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/String;

    move-result-object v0

    .line 122
    invoke-virtual {p2}, Lcom/fasterxml/jackson/core/JsonGenerator;->canWriteTypeId()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 123
    invoke-virtual {p2, v0}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeTypeId(Ljava/lang/Object;)V

    .line 129
    :goto_0
    return-void

    .line 126
    :cond_0
    invoke-virtual {p2}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeStartObject()V

    .line 127
    invoke-virtual {p2, v0}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeFieldName(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public writeTypeSuffixForArray(Ljava/lang/Object;Lcom/fasterxml/jackson/core/JsonGenerator;)V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonProcessingException;
        }
    .end annotation

    .prologue
    .line 148
    invoke-virtual {p2}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeEndArray()V

    .line 149
    invoke-virtual {p2}, Lcom/fasterxml/jackson/core/JsonGenerator;->canWriteTypeId()Z

    move-result v0

    if-nez v0, :cond_0

    .line 151
    invoke-virtual {p2}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeEndObject()V

    .line 153
    :cond_0
    return-void
.end method

.method public writeTypeSuffixForObject(Ljava/lang/Object;Lcom/fasterxml/jackson/core/JsonGenerator;)V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonProcessingException;
        }
    .end annotation

    .prologue
    .line 136
    invoke-virtual {p2}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeEndObject()V

    .line 137
    invoke-virtual {p2}, Lcom/fasterxml/jackson/core/JsonGenerator;->canWriteTypeId()Z

    move-result v0

    if-nez v0, :cond_0

    .line 139
    invoke-virtual {p2}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeEndObject()V

    .line 141
    :cond_0
    return-void
.end method

.method public writeTypeSuffixForScalar(Ljava/lang/Object;Lcom/fasterxml/jackson/core/JsonGenerator;)V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonProcessingException;
        }
    .end annotation

    .prologue
    .line 159
    invoke-virtual {p2}, Lcom/fasterxml/jackson/core/JsonGenerator;->canWriteTypeId()Z

    move-result v0

    if-nez v0, :cond_0

    .line 161
    invoke-virtual {p2}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeEndObject()V

    .line 163
    :cond_0
    return-void
.end method
