.class public abstract Lcom/fasterxml/jackson/databind/ser/DefaultSerializerProvider;
.super Lcom/fasterxml/jackson/databind/SerializerProvider;
.source "DefaultSerializerProvider.java"

# interfaces
.implements Ljava/io/Serializable;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/fasterxml/jackson/databind/ser/DefaultSerializerProvider$Impl;
    }
.end annotation


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field protected transient _objectIdGenerators:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/fasterxml/jackson/annotation/ObjectIdGenerator",
            "<*>;>;"
        }
    .end annotation
.end field

.field protected transient _seenObjectIds:Ljava/util/IdentityHashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/IdentityHashMap",
            "<",
            "Ljava/lang/Object;",
            "Lcom/fasterxml/jackson/databind/ser/impl/WritableObjectId;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method protected constructor <init>()V
    .locals 0

    .prologue
    .line 61
    invoke-direct {p0}, Lcom/fasterxml/jackson/databind/SerializerProvider;-><init>()V

    return-void
.end method

.method protected constructor <init>(Lcom/fasterxml/jackson/databind/SerializerProvider;Lcom/fasterxml/jackson/databind/SerializationConfig;Lcom/fasterxml/jackson/databind/ser/SerializerFactory;)V
    .locals 0
    .param p1, "src"    # Lcom/fasterxml/jackson/databind/SerializerProvider;
    .param p2, "config"    # Lcom/fasterxml/jackson/databind/SerializationConfig;
    .param p3, "f"    # Lcom/fasterxml/jackson/databind/ser/SerializerFactory;

    .prologue
    .line 65
    invoke-direct {p0, p1, p2, p3}, Lcom/fasterxml/jackson/databind/SerializerProvider;-><init>(Lcom/fasterxml/jackson/databind/SerializerProvider;Lcom/fasterxml/jackson/databind/SerializationConfig;Lcom/fasterxml/jackson/databind/ser/SerializerFactory;)V

    .line 66
    return-void
.end method


# virtual methods
.method public acceptJsonFormatVisitor(Lcom/fasterxml/jackson/databind/JavaType;Lcom/fasterxml/jackson/databind/jsonFormatVisitors/JsonFormatVisitorWrapper;)V
    .locals 2
    .param p1, "javaType"    # Lcom/fasterxml/jackson/databind/JavaType;
    .param p2, "visitor"    # Lcom/fasterxml/jackson/databind/jsonFormatVisitors/JsonFormatVisitorWrapper;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/fasterxml/jackson/databind/JsonMappingException;
        }
    .end annotation

    .prologue
    .line 276
    if-nez p1, :cond_0

    .line 277
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "A class must be provided"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 282
    :cond_0
    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0}, Lcom/fasterxml/jackson/databind/ser/DefaultSerializerProvider;->findValueSerializer(Lcom/fasterxml/jackson/databind/JavaType;Lcom/fasterxml/jackson/databind/BeanProperty;)Lcom/fasterxml/jackson/databind/JsonSerializer;

    move-result-object v0

    invoke-virtual {v0, p2, p1}, Lcom/fasterxml/jackson/databind/JsonSerializer;->acceptJsonFormatVisitor(Lcom/fasterxml/jackson/databind/jsonFormatVisitors/JsonFormatVisitorWrapper;Lcom/fasterxml/jackson/databind/JavaType;)V

    .line 283
    return-void
.end method

.method public cachedSerializersCount()I
    .locals 1

    .prologue
    .line 314
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/ser/DefaultSerializerProvider;->_serializerCache:Lcom/fasterxml/jackson/databind/ser/SerializerCache;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/databind/ser/SerializerCache;->size()I

    move-result v0

    return v0
.end method

.method public abstract createInstance(Lcom/fasterxml/jackson/databind/SerializationConfig;Lcom/fasterxml/jackson/databind/ser/SerializerFactory;)Lcom/fasterxml/jackson/databind/ser/DefaultSerializerProvider;
.end method

.method public findObjectId(Ljava/lang/Object;Lcom/fasterxml/jackson/annotation/ObjectIdGenerator;)Lcom/fasterxml/jackson/databind/ser/impl/WritableObjectId;
    .locals 7
    .param p1, "forPojo"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Object;",
            "Lcom/fasterxml/jackson/annotation/ObjectIdGenerator",
            "<*>;)",
            "Lcom/fasterxml/jackson/databind/ser/impl/WritableObjectId;"
        }
    .end annotation

    .prologue
    .line 355
    .local p2, "generatorType":Lcom/fasterxml/jackson/annotation/ObjectIdGenerator;, "Lcom/fasterxml/jackson/annotation/ObjectIdGenerator<*>;"
    iget-object v5, p0, Lcom/fasterxml/jackson/databind/ser/DefaultSerializerProvider;->_seenObjectIds:Ljava/util/IdentityHashMap;

    if-nez v5, :cond_3

    .line 356
    new-instance v5, Ljava/util/IdentityHashMap;

    invoke-direct {v5}, Ljava/util/IdentityHashMap;-><init>()V

    iput-object v5, p0, Lcom/fasterxml/jackson/databind/ser/DefaultSerializerProvider;->_seenObjectIds:Ljava/util/IdentityHashMap;

    .line 364
    :cond_0
    const/4 v1, 0x0

    .line 366
    .local v1, "generator":Lcom/fasterxml/jackson/annotation/ObjectIdGenerator;, "Lcom/fasterxml/jackson/annotation/ObjectIdGenerator<*>;"
    iget-object v5, p0, Lcom/fasterxml/jackson/databind/ser/DefaultSerializerProvider;->_objectIdGenerators:Ljava/util/ArrayList;

    if-nez v5, :cond_4

    .line 367
    new-instance v5, Ljava/util/ArrayList;

    const/16 v6, 0x8

    invoke-direct {v5, v6}, Ljava/util/ArrayList;-><init>(I)V

    iput-object v5, p0, Lcom/fasterxml/jackson/databind/ser/DefaultSerializerProvider;->_objectIdGenerators:Ljava/util/ArrayList;

    .line 377
    :cond_1
    :goto_0
    if-nez v1, :cond_2

    .line 378
    invoke-virtual {p2, p0}, Lcom/fasterxml/jackson/annotation/ObjectIdGenerator;->newForSerialization(Ljava/lang/Object;)Lcom/fasterxml/jackson/annotation/ObjectIdGenerator;

    move-result-object v1

    .line 379
    iget-object v5, p0, Lcom/fasterxml/jackson/databind/ser/DefaultSerializerProvider;->_objectIdGenerators:Ljava/util/ArrayList;

    invoke-virtual {v5, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 381
    :cond_2
    new-instance v4, Lcom/fasterxml/jackson/databind/ser/impl/WritableObjectId;

    invoke-direct {v4, v1}, Lcom/fasterxml/jackson/databind/ser/impl/WritableObjectId;-><init>(Lcom/fasterxml/jackson/annotation/ObjectIdGenerator;)V

    .line 382
    .local v4, "oid":Lcom/fasterxml/jackson/databind/ser/impl/WritableObjectId;
    iget-object v5, p0, Lcom/fasterxml/jackson/databind/ser/DefaultSerializerProvider;->_seenObjectIds:Ljava/util/IdentityHashMap;

    invoke-virtual {v5, p1, v4}, Ljava/util/IdentityHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 383
    .end local v1    # "generator":Lcom/fasterxml/jackson/annotation/ObjectIdGenerator;, "Lcom/fasterxml/jackson/annotation/ObjectIdGenerator<*>;"
    :goto_1
    return-object v4

    .line 358
    .end local v4    # "oid":Lcom/fasterxml/jackson/databind/ser/impl/WritableObjectId;
    :cond_3
    iget-object v5, p0, Lcom/fasterxml/jackson/databind/ser/DefaultSerializerProvider;->_seenObjectIds:Ljava/util/IdentityHashMap;

    invoke-virtual {v5, p1}, Ljava/util/IdentityHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/fasterxml/jackson/databind/ser/impl/WritableObjectId;

    .line 359
    .restart local v4    # "oid":Lcom/fasterxml/jackson/databind/ser/impl/WritableObjectId;
    if-eqz v4, :cond_0

    goto :goto_1

    .line 369
    .end local v4    # "oid":Lcom/fasterxml/jackson/databind/ser/impl/WritableObjectId;
    .restart local v1    # "generator":Lcom/fasterxml/jackson/annotation/ObjectIdGenerator;, "Lcom/fasterxml/jackson/annotation/ObjectIdGenerator<*>;"
    :cond_4
    const/4 v2, 0x0

    .local v2, "i":I
    iget-object v5, p0, Lcom/fasterxml/jackson/databind/ser/DefaultSerializerProvider;->_objectIdGenerators:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->size()I

    move-result v3

    .local v3, "len":I
    :goto_2
    if-ge v2, v3, :cond_1

    .line 370
    iget-object v5, p0, Lcom/fasterxml/jackson/databind/ser/DefaultSerializerProvider;->_objectIdGenerators:Ljava/util/ArrayList;

    invoke-virtual {v5, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/fasterxml/jackson/annotation/ObjectIdGenerator;

    .line 371
    .local v0, "gen":Lcom/fasterxml/jackson/annotation/ObjectIdGenerator;, "Lcom/fasterxml/jackson/annotation/ObjectIdGenerator<*>;"
    invoke-virtual {v0, p2}, Lcom/fasterxml/jackson/annotation/ObjectIdGenerator;->canUseFor(Lcom/fasterxml/jackson/annotation/ObjectIdGenerator;)Z

    move-result v5

    if-eqz v5, :cond_5

    .line 372
    move-object v1, v0

    .line 373
    goto :goto_0

    .line 369
    :cond_5
    add-int/lit8 v2, v2, 0x1

    goto :goto_2
.end method

.method public flushCachedSerializers()V
    .locals 1

    .prologue
    .line 324
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/ser/DefaultSerializerProvider;->_serializerCache:Lcom/fasterxml/jackson/databind/ser/SerializerCache;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/databind/ser/SerializerCache;->flush()V

    .line 325
    return-void
.end method

.method public generateJsonSchema(Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/jsonschema/JsonSchema;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;)",
            "Lcom/fasterxml/jackson/databind/jsonschema/JsonSchema;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/fasterxml/jackson/databind/JsonMappingException;
        }
    .end annotation

    .prologue
    .local p1, "type":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    const/4 v3, 0x0

    .line 249
    if-nez p1, :cond_0

    .line 250
    new-instance v2, Ljava/lang/IllegalArgumentException;

    const-string v3, "A class must be provided"

    invoke-direct {v2, v3}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 255
    :cond_0
    invoke-virtual {p0, p1, v3}, Lcom/fasterxml/jackson/databind/ser/DefaultSerializerProvider;->findValueSerializer(Ljava/lang/Class;Lcom/fasterxml/jackson/databind/BeanProperty;)Lcom/fasterxml/jackson/databind/JsonSerializer;

    move-result-object v1

    .line 256
    .local v1, "ser":Lcom/fasterxml/jackson/databind/JsonSerializer;, "Lcom/fasterxml/jackson/databind/JsonSerializer<Ljava/lang/Object;>;"
    instance-of v2, v1, Lcom/fasterxml/jackson/databind/jsonschema/SchemaAware;

    if-eqz v2, :cond_1

    check-cast v1, Lcom/fasterxml/jackson/databind/jsonschema/SchemaAware;

    .end local v1    # "ser":Lcom/fasterxml/jackson/databind/JsonSerializer;, "Lcom/fasterxml/jackson/databind/JsonSerializer<Ljava/lang/Object;>;"
    invoke-interface {v1, p0, v3}, Lcom/fasterxml/jackson/databind/jsonschema/SchemaAware;->getSchema(Lcom/fasterxml/jackson/databind/SerializerProvider;Ljava/lang/reflect/Type;)Lcom/fasterxml/jackson/databind/JsonNode;

    move-result-object v0

    .line 259
    .local v0, "schemaNode":Lcom/fasterxml/jackson/databind/JsonNode;
    :goto_0
    instance-of v2, v0, Lcom/fasterxml/jackson/databind/node/ObjectNode;

    if-nez v2, :cond_2

    .line 260
    new-instance v2, Ljava/lang/IllegalArgumentException;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Class "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {p1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " would not be serialized as a JSON object and therefore has no schema"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 256
    .end local v0    # "schemaNode":Lcom/fasterxml/jackson/databind/JsonNode;
    .restart local v1    # "ser":Lcom/fasterxml/jackson/databind/JsonSerializer;, "Lcom/fasterxml/jackson/databind/JsonSerializer<Ljava/lang/Object;>;"
    :cond_1
    invoke-static {}, Lcom/fasterxml/jackson/databind/jsonschema/JsonSchema;->getDefaultSchemaNode()Lcom/fasterxml/jackson/databind/JsonNode;

    move-result-object v0

    goto :goto_0

    .line 263
    .end local v1    # "ser":Lcom/fasterxml/jackson/databind/JsonSerializer;, "Lcom/fasterxml/jackson/databind/JsonSerializer<Ljava/lang/Object;>;"
    .restart local v0    # "schemaNode":Lcom/fasterxml/jackson/databind/JsonNode;
    :cond_2
    new-instance v2, Lcom/fasterxml/jackson/databind/jsonschema/JsonSchema;

    check-cast v0, Lcom/fasterxml/jackson/databind/node/ObjectNode;

    .end local v0    # "schemaNode":Lcom/fasterxml/jackson/databind/JsonNode;
    invoke-direct {v2, v0}, Lcom/fasterxml/jackson/databind/jsonschema/JsonSchema;-><init>(Lcom/fasterxml/jackson/databind/node/ObjectNode;)V

    return-object v2
.end method

.method public hasSerializerFor(Ljava/lang/Class;)Z
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;)Z"
        }
    .end annotation

    .prologue
    .line 293
    .local p1, "cls":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-virtual {p0, p1}, Lcom/fasterxml/jackson/databind/ser/DefaultSerializerProvider;->_findExplicitUntypedSerializer(Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/JsonSerializer;

    move-result-object v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public objectIdGeneratorInstance(Lcom/fasterxml/jackson/databind/introspect/Annotated;Lcom/fasterxml/jackson/databind/introspect/ObjectIdInfo;)Lcom/fasterxml/jackson/annotation/ObjectIdGenerator;
    .locals 4
    .param p1, "annotated"    # Lcom/fasterxml/jackson/databind/introspect/Annotated;
    .param p2, "objectIdInfo"    # Lcom/fasterxml/jackson/databind/introspect/ObjectIdInfo;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/fasterxml/jackson/databind/introspect/Annotated;",
            "Lcom/fasterxml/jackson/databind/introspect/ObjectIdInfo;",
            ")",
            "Lcom/fasterxml/jackson/annotation/ObjectIdGenerator",
            "<*>;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/fasterxml/jackson/databind/JsonMappingException;
        }
    .end annotation

    .prologue
    .line 338
    invoke-virtual {p2}, Lcom/fasterxml/jackson/databind/introspect/ObjectIdInfo;->getGeneratorType()Ljava/lang/Class;

    move-result-object v2

    .line 339
    .local v2, "implClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    iget-object v3, p0, Lcom/fasterxml/jackson/databind/ser/DefaultSerializerProvider;->_config:Lcom/fasterxml/jackson/databind/SerializationConfig;

    invoke-virtual {v3}, Lcom/fasterxml/jackson/databind/SerializationConfig;->getHandlerInstantiator()Lcom/fasterxml/jackson/databind/cfg/HandlerInstantiator;

    move-result-object v1

    .line 342
    .local v1, "hi":Lcom/fasterxml/jackson/databind/cfg/HandlerInstantiator;
    if-eqz v1, :cond_0

    .line 343
    iget-object v3, p0, Lcom/fasterxml/jackson/databind/ser/DefaultSerializerProvider;->_config:Lcom/fasterxml/jackson/databind/SerializationConfig;

    invoke-virtual {v1, v3, p1, v2}, Lcom/fasterxml/jackson/databind/cfg/HandlerInstantiator;->objectIdGeneratorInstance(Lcom/fasterxml/jackson/databind/cfg/MapperConfig;Lcom/fasterxml/jackson/databind/introspect/Annotated;Ljava/lang/Class;)Lcom/fasterxml/jackson/annotation/ObjectIdGenerator;

    move-result-object v0

    .line 348
    .local v0, "gen":Lcom/fasterxml/jackson/annotation/ObjectIdGenerator;, "Lcom/fasterxml/jackson/annotation/ObjectIdGenerator<*>;"
    :goto_0
    invoke-virtual {p2}, Lcom/fasterxml/jackson/databind/introspect/ObjectIdInfo;->getScope()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/fasterxml/jackson/annotation/ObjectIdGenerator;->forScope(Ljava/lang/Class;)Lcom/fasterxml/jackson/annotation/ObjectIdGenerator;

    move-result-object v3

    return-object v3

    .line 345
    .end local v0    # "gen":Lcom/fasterxml/jackson/annotation/ObjectIdGenerator;, "Lcom/fasterxml/jackson/annotation/ObjectIdGenerator<*>;"
    :cond_0
    iget-object v3, p0, Lcom/fasterxml/jackson/databind/ser/DefaultSerializerProvider;->_config:Lcom/fasterxml/jackson/databind/SerializationConfig;

    invoke-virtual {v3}, Lcom/fasterxml/jackson/databind/SerializationConfig;->canOverrideAccessModifiers()Z

    move-result v3

    invoke-static {v2, v3}, Lcom/fasterxml/jackson/databind/util/ClassUtil;->createInstance(Ljava/lang/Class;Z)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/fasterxml/jackson/annotation/ObjectIdGenerator;

    .restart local v0    # "gen":Lcom/fasterxml/jackson/annotation/ObjectIdGenerator;, "Lcom/fasterxml/jackson/annotation/ObjectIdGenerator<*>;"
    goto :goto_0
.end method

.method public serializeValue(Lcom/fasterxml/jackson/core/JsonGenerator;Ljava/lang/Object;)V
    .locals 10
    .param p1, "jgen"    # Lcom/fasterxml/jackson/core/JsonGenerator;
    .param p2, "value"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonGenerationException;
        }
    .end annotation

    .prologue
    .line 93
    if-nez p2, :cond_2

    .line 94
    invoke-virtual {p0}, Lcom/fasterxml/jackson/databind/ser/DefaultSerializerProvider;->getDefaultNullValueSerializer()Lcom/fasterxml/jackson/databind/JsonSerializer;

    move-result-object v5

    .line 95
    .local v5, "ser":Lcom/fasterxml/jackson/databind/JsonSerializer;, "Lcom/fasterxml/jackson/databind/JsonSerializer<Ljava/lang/Object;>;"
    const/4 v6, 0x0

    .line 120
    .local v6, "wrap":Z
    :cond_0
    :goto_0
    :try_start_0
    invoke-virtual {v5, p2, p1, p0}, Lcom/fasterxml/jackson/databind/JsonSerializer;->serialize(Ljava/lang/Object;Lcom/fasterxml/jackson/core/JsonGenerator;Lcom/fasterxml/jackson/databind/SerializerProvider;)V

    .line 121
    if-eqz v6, :cond_1

    .line 122
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeEndObject()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    .line 133
    :cond_1
    return-void

    .line 97
    .end local v5    # "ser":Lcom/fasterxml/jackson/databind/JsonSerializer;, "Lcom/fasterxml/jackson/databind/JsonSerializer<Ljava/lang/Object;>;"
    .end local v6    # "wrap":Z
    :cond_2
    invoke-virtual {p2}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    .line 99
    .local v0, "cls":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    const/4 v7, 0x1

    const/4 v8, 0x0

    invoke-virtual {p0, v0, v7, v8}, Lcom/fasterxml/jackson/databind/ser/DefaultSerializerProvider;->findTypedValueSerializer(Ljava/lang/Class;ZLcom/fasterxml/jackson/databind/BeanProperty;)Lcom/fasterxml/jackson/databind/JsonSerializer;

    move-result-object v5

    .line 102
    .restart local v5    # "ser":Lcom/fasterxml/jackson/databind/JsonSerializer;, "Lcom/fasterxml/jackson/databind/JsonSerializer<Ljava/lang/Object;>;"
    iget-object v7, p0, Lcom/fasterxml/jackson/databind/ser/DefaultSerializerProvider;->_config:Lcom/fasterxml/jackson/databind/SerializationConfig;

    invoke-virtual {v7}, Lcom/fasterxml/jackson/databind/SerializationConfig;->getRootName()Ljava/lang/String;

    move-result-object v4

    .line 103
    .local v4, "rootName":Ljava/lang/String;
    if-nez v4, :cond_3

    .line 105
    iget-object v7, p0, Lcom/fasterxml/jackson/databind/ser/DefaultSerializerProvider;->_config:Lcom/fasterxml/jackson/databind/SerializationConfig;

    sget-object v8, Lcom/fasterxml/jackson/databind/SerializationFeature;->WRAP_ROOT_VALUE:Lcom/fasterxml/jackson/databind/SerializationFeature;

    invoke-virtual {v7, v8}, Lcom/fasterxml/jackson/databind/SerializationConfig;->isEnabled(Lcom/fasterxml/jackson/databind/SerializationFeature;)Z

    move-result v6

    .line 106
    .restart local v6    # "wrap":Z
    if-eqz v6, :cond_0

    .line 107
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeStartObject()V

    .line 108
    iget-object v7, p0, Lcom/fasterxml/jackson/databind/ser/DefaultSerializerProvider;->_rootNames:Lcom/fasterxml/jackson/databind/util/RootNameLookup;

    invoke-virtual {p2}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v8

    iget-object v9, p0, Lcom/fasterxml/jackson/databind/ser/DefaultSerializerProvider;->_config:Lcom/fasterxml/jackson/databind/SerializationConfig;

    invoke-virtual {v7, v8, v9}, Lcom/fasterxml/jackson/databind/util/RootNameLookup;->findRootName(Ljava/lang/Class;Lcom/fasterxml/jackson/databind/cfg/MapperConfig;)Lcom/fasterxml/jackson/core/io/SerializedString;

    move-result-object v7

    invoke-virtual {p1, v7}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeFieldName(Lcom/fasterxml/jackson/core/SerializableString;)V

    goto :goto_0

    .line 110
    .end local v6    # "wrap":Z
    :cond_3
    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v7

    if-nez v7, :cond_4

    .line 111
    const/4 v6, 0x0

    .restart local v6    # "wrap":Z
    goto :goto_0

    .line 114
    .end local v6    # "wrap":Z
    :cond_4
    const/4 v6, 0x1

    .line 115
    .restart local v6    # "wrap":Z
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeStartObject()V

    .line 116
    invoke-virtual {p1, v4}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeFieldName(Ljava/lang/String;)V

    goto :goto_0

    .line 124
    .end local v0    # "cls":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .end local v4    # "rootName":Ljava/lang/String;
    :catch_0
    move-exception v2

    .line 125
    .local v2, "ioe":Ljava/io/IOException;
    throw v2

    .line 126
    .end local v2    # "ioe":Ljava/io/IOException;
    :catch_1
    move-exception v1

    .line 127
    .local v1, "e":Ljava/lang/Exception;
    invoke-virtual {v1}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v3

    .line 128
    .local v3, "msg":Ljava/lang/String;
    if-nez v3, :cond_5

    .line 129
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "[no message for "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, "]"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 131
    :cond_5
    new-instance v7, Lcom/fasterxml/jackson/databind/JsonMappingException;

    invoke-direct {v7, v3, v1}, Lcom/fasterxml/jackson/databind/JsonMappingException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v7
.end method

.method public serializeValue(Lcom/fasterxml/jackson/core/JsonGenerator;Ljava/lang/Object;Lcom/fasterxml/jackson/databind/JavaType;)V
    .locals 7
    .param p1, "jgen"    # Lcom/fasterxml/jackson/core/JsonGenerator;
    .param p2, "value"    # Ljava/lang/Object;
    .param p3, "rootType"    # Lcom/fasterxml/jackson/databind/JavaType;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonGenerationException;
        }
    .end annotation

    .prologue
    .line 152
    if-nez p2, :cond_2

    .line 153
    invoke-virtual {p0}, Lcom/fasterxml/jackson/databind/ser/DefaultSerializerProvider;->getDefaultNullValueSerializer()Lcom/fasterxml/jackson/databind/JsonSerializer;

    move-result-object v3

    .line 154
    .local v3, "ser":Lcom/fasterxml/jackson/databind/JsonSerializer;, "Lcom/fasterxml/jackson/databind/JsonSerializer<Ljava/lang/Object;>;"
    const/4 v4, 0x0

    .line 170
    .local v4, "wrap":Z
    :cond_0
    :goto_0
    :try_start_0
    invoke-virtual {v3, p2, p1, p0}, Lcom/fasterxml/jackson/databind/JsonSerializer;->serialize(Ljava/lang/Object;Lcom/fasterxml/jackson/core/JsonGenerator;Lcom/fasterxml/jackson/databind/SerializerProvider;)V

    .line 171
    if-eqz v4, :cond_1

    .line 172
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeEndObject()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    .line 183
    :cond_1
    return-void

    .line 157
    .end local v3    # "ser":Lcom/fasterxml/jackson/databind/JsonSerializer;, "Lcom/fasterxml/jackson/databind/JsonSerializer<Ljava/lang/Object;>;"
    .end local v4    # "wrap":Z
    :cond_2
    invoke-virtual {p3}, Lcom/fasterxml/jackson/databind/JavaType;->getRawClass()Ljava/lang/Class;

    move-result-object v5

    invoke-virtual {p2}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/Class;->isAssignableFrom(Ljava/lang/Class;)Z

    move-result v5

    if-nez v5, :cond_3

    .line 158
    invoke-virtual {p0, p2, p3}, Lcom/fasterxml/jackson/databind/ser/DefaultSerializerProvider;->_reportIncompatibleRootType(Ljava/lang/Object;Lcom/fasterxml/jackson/databind/JavaType;)V

    .line 161
    :cond_3
    const/4 v5, 0x1

    const/4 v6, 0x0

    invoke-virtual {p0, p3, v5, v6}, Lcom/fasterxml/jackson/databind/ser/DefaultSerializerProvider;->findTypedValueSerializer(Lcom/fasterxml/jackson/databind/JavaType;ZLcom/fasterxml/jackson/databind/BeanProperty;)Lcom/fasterxml/jackson/databind/JsonSerializer;

    move-result-object v3

    .line 163
    .restart local v3    # "ser":Lcom/fasterxml/jackson/databind/JsonSerializer;, "Lcom/fasterxml/jackson/databind/JsonSerializer<Ljava/lang/Object;>;"
    iget-object v5, p0, Lcom/fasterxml/jackson/databind/ser/DefaultSerializerProvider;->_config:Lcom/fasterxml/jackson/databind/SerializationConfig;

    sget-object v6, Lcom/fasterxml/jackson/databind/SerializationFeature;->WRAP_ROOT_VALUE:Lcom/fasterxml/jackson/databind/SerializationFeature;

    invoke-virtual {v5, v6}, Lcom/fasterxml/jackson/databind/SerializationConfig;->isEnabled(Lcom/fasterxml/jackson/databind/SerializationFeature;)Z

    move-result v4

    .line 164
    .restart local v4    # "wrap":Z
    if-eqz v4, :cond_0

    .line 165
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeStartObject()V

    .line 166
    iget-object v5, p0, Lcom/fasterxml/jackson/databind/ser/DefaultSerializerProvider;->_rootNames:Lcom/fasterxml/jackson/databind/util/RootNameLookup;

    iget-object v6, p0, Lcom/fasterxml/jackson/databind/ser/DefaultSerializerProvider;->_config:Lcom/fasterxml/jackson/databind/SerializationConfig;

    invoke-virtual {v5, p3, v6}, Lcom/fasterxml/jackson/databind/util/RootNameLookup;->findRootName(Lcom/fasterxml/jackson/databind/JavaType;Lcom/fasterxml/jackson/databind/cfg/MapperConfig;)Lcom/fasterxml/jackson/core/io/SerializedString;

    move-result-object v5

    invoke-virtual {p1, v5}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeFieldName(Lcom/fasterxml/jackson/core/SerializableString;)V

    goto :goto_0

    .line 174
    :catch_0
    move-exception v1

    .line 175
    .local v1, "ioe":Ljava/io/IOException;
    throw v1

    .line 176
    .end local v1    # "ioe":Ljava/io/IOException;
    :catch_1
    move-exception v0

    .line 177
    .local v0, "e":Ljava/lang/Exception;
    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    .line 178
    .local v2, "msg":Ljava/lang/String;
    if-nez v2, :cond_4

    .line 179
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "[no message for "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "]"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 181
    :cond_4
    new-instance v5, Lcom/fasterxml/jackson/databind/JsonMappingException;

    invoke-direct {v5, v2, v0}, Lcom/fasterxml/jackson/databind/JsonMappingException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v5
.end method

.method public serializeValue(Lcom/fasterxml/jackson/core/JsonGenerator;Ljava/lang/Object;Lcom/fasterxml/jackson/databind/JavaType;Lcom/fasterxml/jackson/databind/JsonSerializer;)V
    .locals 6
    .param p1, "jgen"    # Lcom/fasterxml/jackson/core/JsonGenerator;
    .param p2, "value"    # Ljava/lang/Object;
    .param p3, "rootType"    # Lcom/fasterxml/jackson/databind/JavaType;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/fasterxml/jackson/core/JsonGenerator;",
            "Ljava/lang/Object;",
            "Lcom/fasterxml/jackson/databind/JavaType;",
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
    .line 203
    .local p4, "ser":Lcom/fasterxml/jackson/databind/JsonSerializer;, "Lcom/fasterxml/jackson/databind/JsonSerializer<Ljava/lang/Object;>;"
    if-nez p2, :cond_2

    .line 204
    invoke-virtual {p0}, Lcom/fasterxml/jackson/databind/ser/DefaultSerializerProvider;->getDefaultNullValueSerializer()Lcom/fasterxml/jackson/databind/JsonSerializer;

    move-result-object p4

    .line 205
    const/4 v3, 0x0

    .line 224
    .local v3, "wrap":Z
    :cond_0
    :goto_0
    :try_start_0
    invoke-virtual {p4, p2, p1, p0}, Lcom/fasterxml/jackson/databind/JsonSerializer;->serialize(Ljava/lang/Object;Lcom/fasterxml/jackson/core/JsonGenerator;Lcom/fasterxml/jackson/databind/SerializerProvider;)V

    .line 225
    if-eqz v3, :cond_1

    .line 226
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeEndObject()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    .line 237
    :cond_1
    return-void

    .line 208
    .end local v3    # "wrap":Z
    :cond_2
    if-eqz p3, :cond_3

    .line 209
    invoke-virtual {p3}, Lcom/fasterxml/jackson/databind/JavaType;->getRawClass()Ljava/lang/Class;

    move-result-object v4

    invoke-virtual {p2}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/Class;->isAssignableFrom(Ljava/lang/Class;)Z

    move-result v4

    if-nez v4, :cond_3

    .line 210
    invoke-virtual {p0, p2, p3}, Lcom/fasterxml/jackson/databind/ser/DefaultSerializerProvider;->_reportIncompatibleRootType(Ljava/lang/Object;Lcom/fasterxml/jackson/databind/JavaType;)V

    .line 214
    :cond_3
    if-nez p4, :cond_4

    .line 215
    const/4 v4, 0x1

    const/4 v5, 0x0

    invoke-virtual {p0, p3, v4, v5}, Lcom/fasterxml/jackson/databind/ser/DefaultSerializerProvider;->findTypedValueSerializer(Lcom/fasterxml/jackson/databind/JavaType;ZLcom/fasterxml/jackson/databind/BeanProperty;)Lcom/fasterxml/jackson/databind/JsonSerializer;

    move-result-object p4

    .line 217
    :cond_4
    iget-object v4, p0, Lcom/fasterxml/jackson/databind/ser/DefaultSerializerProvider;->_config:Lcom/fasterxml/jackson/databind/SerializationConfig;

    sget-object v5, Lcom/fasterxml/jackson/databind/SerializationFeature;->WRAP_ROOT_VALUE:Lcom/fasterxml/jackson/databind/SerializationFeature;

    invoke-virtual {v4, v5}, Lcom/fasterxml/jackson/databind/SerializationConfig;->isEnabled(Lcom/fasterxml/jackson/databind/SerializationFeature;)Z

    move-result v3

    .line 218
    .restart local v3    # "wrap":Z
    if-eqz v3, :cond_0

    .line 219
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeStartObject()V

    .line 220
    iget-object v4, p0, Lcom/fasterxml/jackson/databind/ser/DefaultSerializerProvider;->_rootNames:Lcom/fasterxml/jackson/databind/util/RootNameLookup;

    iget-object v5, p0, Lcom/fasterxml/jackson/databind/ser/DefaultSerializerProvider;->_config:Lcom/fasterxml/jackson/databind/SerializationConfig;

    invoke-virtual {v4, p3, v5}, Lcom/fasterxml/jackson/databind/util/RootNameLookup;->findRootName(Lcom/fasterxml/jackson/databind/JavaType;Lcom/fasterxml/jackson/databind/cfg/MapperConfig;)Lcom/fasterxml/jackson/core/io/SerializedString;

    move-result-object v4

    invoke-virtual {p1, v4}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeFieldName(Lcom/fasterxml/jackson/core/SerializableString;)V

    goto :goto_0

    .line 228
    :catch_0
    move-exception v1

    .line 229
    .local v1, "ioe":Ljava/io/IOException;
    throw v1

    .line 230
    .end local v1    # "ioe":Ljava/io/IOException;
    :catch_1
    move-exception v0

    .line 231
    .local v0, "e":Ljava/lang/Exception;
    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    .line 232
    .local v2, "msg":Ljava/lang/String;
    if-nez v2, :cond_5

    .line 233
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "[no message for "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "]"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 235
    :cond_5
    new-instance v4, Lcom/fasterxml/jackson/databind/JsonMappingException;

    invoke-direct {v4, v2, v0}, Lcom/fasterxml/jackson/databind/JsonMappingException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v4
.end method

.method public serializerInstance(Lcom/fasterxml/jackson/databind/introspect/Annotated;Ljava/lang/Object;)Lcom/fasterxml/jackson/databind/JsonSerializer;
    .locals 6
    .param p1, "annotated"    # Lcom/fasterxml/jackson/databind/introspect/Annotated;
    .param p2, "serDef"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/fasterxml/jackson/databind/introspect/Annotated;",
            "Ljava/lang/Object;",
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
    const/4 v3, 0x0

    .line 398
    if-nez p2, :cond_1

    .line 430
    :cond_0
    :goto_0
    return-object v3

    .line 403
    :cond_1
    instance-of v4, p2, Lcom/fasterxml/jackson/databind/JsonSerializer;

    if-eqz v4, :cond_2

    move-object v1, p2

    .line 404
    check-cast v1, Lcom/fasterxml/jackson/databind/JsonSerializer;

    .line 430
    .local v1, "ser":Lcom/fasterxml/jackson/databind/JsonSerializer;, "Lcom/fasterxml/jackson/databind/JsonSerializer<*>;"
    :goto_1
    invoke-virtual {p0, v1}, Lcom/fasterxml/jackson/databind/ser/DefaultSerializerProvider;->_handleResolvable(Lcom/fasterxml/jackson/databind/JsonSerializer;)Lcom/fasterxml/jackson/databind/JsonSerializer;

    move-result-object v3

    goto :goto_0

    .line 409
    .end local v1    # "ser":Lcom/fasterxml/jackson/databind/JsonSerializer;, "Lcom/fasterxml/jackson/databind/JsonSerializer<*>;"
    :cond_2
    instance-of v4, p2, Ljava/lang/Class;

    if-nez v4, :cond_3

    .line 410
    new-instance v3, Ljava/lang/IllegalStateException;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "AnnotationIntrospector returned serializer definition of type "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {p2}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "; expected type JsonSerializer or Class<JsonSerializer> instead"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v3

    :cond_3
    move-object v2, p2

    .line 413
    check-cast v2, Ljava/lang/Class;

    .line 415
    .local v2, "serClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    const-class v4, Lcom/fasterxml/jackson/databind/JsonSerializer$None;

    if-eq v2, v4, :cond_0

    const-class v4, Lcom/fasterxml/jackson/databind/annotation/NoClass;

    if-eq v2, v4, :cond_0

    .line 418
    const-class v3, Lcom/fasterxml/jackson/databind/JsonSerializer;

    invoke-virtual {v3, v2}, Ljava/lang/Class;->isAssignableFrom(Ljava/lang/Class;)Z

    move-result v3

    if-nez v3, :cond_4

    .line 419
    new-instance v3, Ljava/lang/IllegalStateException;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "AnnotationIntrospector returned Class "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v2}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "; expected Class<JsonSerializer>"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 422
    :cond_4
    iget-object v3, p0, Lcom/fasterxml/jackson/databind/ser/DefaultSerializerProvider;->_config:Lcom/fasterxml/jackson/databind/SerializationConfig;

    invoke-virtual {v3}, Lcom/fasterxml/jackson/databind/SerializationConfig;->getHandlerInstantiator()Lcom/fasterxml/jackson/databind/cfg/HandlerInstantiator;

    move-result-object v0

    .line 423
    .local v0, "hi":Lcom/fasterxml/jackson/databind/cfg/HandlerInstantiator;
    if-eqz v0, :cond_5

    .line 424
    iget-object v3, p0, Lcom/fasterxml/jackson/databind/ser/DefaultSerializerProvider;->_config:Lcom/fasterxml/jackson/databind/SerializationConfig;

    invoke-virtual {v0, v3, p1, v2}, Lcom/fasterxml/jackson/databind/cfg/HandlerInstantiator;->serializerInstance(Lcom/fasterxml/jackson/databind/SerializationConfig;Lcom/fasterxml/jackson/databind/introspect/Annotated;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/JsonSerializer;

    move-result-object v1

    .restart local v1    # "ser":Lcom/fasterxml/jackson/databind/JsonSerializer;, "Lcom/fasterxml/jackson/databind/JsonSerializer<*>;"
    goto :goto_1

    .line 426
    .end local v1    # "ser":Lcom/fasterxml/jackson/databind/JsonSerializer;, "Lcom/fasterxml/jackson/databind/JsonSerializer<*>;"
    :cond_5
    iget-object v3, p0, Lcom/fasterxml/jackson/databind/ser/DefaultSerializerProvider;->_config:Lcom/fasterxml/jackson/databind/SerializationConfig;

    invoke-virtual {v3}, Lcom/fasterxml/jackson/databind/SerializationConfig;->canOverrideAccessModifiers()Z

    move-result v3

    invoke-static {v2, v3}, Lcom/fasterxml/jackson/databind/util/ClassUtil;->createInstance(Ljava/lang/Class;Z)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/fasterxml/jackson/databind/JsonSerializer;

    .restart local v1    # "ser":Lcom/fasterxml/jackson/databind/JsonSerializer;, "Lcom/fasterxml/jackson/databind/JsonSerializer<*>;"
    goto/16 :goto_1
.end method
