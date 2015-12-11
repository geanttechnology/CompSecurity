.class public abstract Lcom/fasterxml/jackson/databind/deser/DefaultDeserializationContext;
.super Lcom/fasterxml/jackson/databind/DeserializationContext;
.source "DefaultDeserializationContext.java"

# interfaces
.implements Ljava/io/Serializable;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/fasterxml/jackson/databind/deser/DefaultDeserializationContext$Impl;
    }
.end annotation


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field protected transient _objectIds:Ljava/util/LinkedHashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/LinkedHashMap",
            "<",
            "Lcom/fasterxml/jackson/annotation/ObjectIdGenerator$IdKey;",
            "Lcom/fasterxml/jackson/databind/deser/impl/ReadableObjectId;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method protected constructor <init>(Lcom/fasterxml/jackson/databind/deser/DefaultDeserializationContext;Lcom/fasterxml/jackson/databind/DeserializationConfig;Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/InjectableValues;)V
    .locals 0
    .param p1, "src"    # Lcom/fasterxml/jackson/databind/deser/DefaultDeserializationContext;
    .param p2, "config"    # Lcom/fasterxml/jackson/databind/DeserializationConfig;
    .param p3, "jp"    # Lcom/fasterxml/jackson/core/JsonParser;
    .param p4, "values"    # Lcom/fasterxml/jackson/databind/InjectableValues;

    .prologue
    .line 43
    invoke-direct {p0, p1, p2, p3, p4}, Lcom/fasterxml/jackson/databind/DeserializationContext;-><init>(Lcom/fasterxml/jackson/databind/DeserializationContext;Lcom/fasterxml/jackson/databind/DeserializationConfig;Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/InjectableValues;)V

    .line 44
    return-void
.end method

.method protected constructor <init>(Lcom/fasterxml/jackson/databind/deser/DefaultDeserializationContext;Lcom/fasterxml/jackson/databind/deser/DeserializerFactory;)V
    .locals 0
    .param p1, "src"    # Lcom/fasterxml/jackson/databind/deser/DefaultDeserializationContext;
    .param p2, "factory"    # Lcom/fasterxml/jackson/databind/deser/DeserializerFactory;

    .prologue
    .line 48
    invoke-direct {p0, p1, p2}, Lcom/fasterxml/jackson/databind/DeserializationContext;-><init>(Lcom/fasterxml/jackson/databind/DeserializationContext;Lcom/fasterxml/jackson/databind/deser/DeserializerFactory;)V

    .line 49
    return-void
.end method

.method protected constructor <init>(Lcom/fasterxml/jackson/databind/deser/DeserializerFactory;Lcom/fasterxml/jackson/databind/deser/DeserializerCache;)V
    .locals 0
    .param p1, "df"    # Lcom/fasterxml/jackson/databind/deser/DeserializerFactory;
    .param p2, "cache"    # Lcom/fasterxml/jackson/databind/deser/DeserializerCache;

    .prologue
    .line 38
    invoke-direct {p0, p1, p2}, Lcom/fasterxml/jackson/databind/DeserializationContext;-><init>(Lcom/fasterxml/jackson/databind/deser/DeserializerFactory;Lcom/fasterxml/jackson/databind/deser/DeserializerCache;)V

    .line 39
    return-void
.end method


# virtual methods
.method public abstract createInstance(Lcom/fasterxml/jackson/databind/DeserializationConfig;Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/InjectableValues;)Lcom/fasterxml/jackson/databind/deser/DefaultDeserializationContext;
.end method

.method public deserializerInstance(Lcom/fasterxml/jackson/databind/introspect/Annotated;Ljava/lang/Object;)Lcom/fasterxml/jackson/databind/JsonDeserializer;
    .locals 6
    .param p1, "annotated"    # Lcom/fasterxml/jackson/databind/introspect/Annotated;
    .param p2, "deserDef"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/fasterxml/jackson/databind/introspect/Annotated;",
            "Ljava/lang/Object;",
            ")",
            "Lcom/fasterxml/jackson/databind/JsonDeserializer",
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
    const/4 v0, 0x0

    .line 105
    if-nez p2, :cond_1

    .line 139
    :cond_0
    :goto_0
    return-object v0

    .line 110
    :cond_1
    instance-of v3, p2, Lcom/fasterxml/jackson/databind/JsonDeserializer;

    if-eqz v3, :cond_2

    move-object v0, p2

    .line 111
    check-cast v0, Lcom/fasterxml/jackson/databind/JsonDeserializer;

    .line 136
    .local v0, "deser":Lcom/fasterxml/jackson/databind/JsonDeserializer;, "Lcom/fasterxml/jackson/databind/JsonDeserializer<*>;"
    :goto_1
    instance-of v3, v0, Lcom/fasterxml/jackson/databind/deser/ResolvableDeserializer;

    if-eqz v3, :cond_0

    move-object v3, v0

    .line 137
    check-cast v3, Lcom/fasterxml/jackson/databind/deser/ResolvableDeserializer;

    invoke-interface {v3, p0}, Lcom/fasterxml/jackson/databind/deser/ResolvableDeserializer;->resolve(Lcom/fasterxml/jackson/databind/DeserializationContext;)V

    goto :goto_0

    .line 116
    .end local v0    # "deser":Lcom/fasterxml/jackson/databind/JsonDeserializer;, "Lcom/fasterxml/jackson/databind/JsonDeserializer<*>;"
    :cond_2
    instance-of v3, p2, Ljava/lang/Class;

    if-nez v3, :cond_3

    .line 117
    new-instance v3, Ljava/lang/IllegalStateException;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "AnnotationIntrospector returned deserializer definition of type "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {p2}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "; expected type JsonDeserializer or Class<JsonDeserializer> instead"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v3

    :cond_3
    move-object v1, p2

    .line 119
    check-cast v1, Ljava/lang/Class;

    .line 121
    .local v1, "deserClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    const-class v3, Lcom/fasterxml/jackson/databind/JsonDeserializer$None;

    if-eq v1, v3, :cond_0

    const-class v3, Lcom/fasterxml/jackson/databind/annotation/NoClass;

    if-eq v1, v3, :cond_0

    .line 124
    const-class v3, Lcom/fasterxml/jackson/databind/JsonDeserializer;

    invoke-virtual {v3, v1}, Ljava/lang/Class;->isAssignableFrom(Ljava/lang/Class;)Z

    move-result v3

    if-nez v3, :cond_4

    .line 125
    new-instance v3, Ljava/lang/IllegalStateException;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "AnnotationIntrospector returned Class "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "; expected Class<JsonDeserializer>"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 127
    :cond_4
    iget-object v3, p0, Lcom/fasterxml/jackson/databind/deser/DefaultDeserializationContext;->_config:Lcom/fasterxml/jackson/databind/DeserializationConfig;

    invoke-virtual {v3}, Lcom/fasterxml/jackson/databind/DeserializationConfig;->getHandlerInstantiator()Lcom/fasterxml/jackson/databind/cfg/HandlerInstantiator;

    move-result-object v2

    .line 128
    .local v2, "hi":Lcom/fasterxml/jackson/databind/cfg/HandlerInstantiator;
    if-eqz v2, :cond_5

    .line 129
    iget-object v3, p0, Lcom/fasterxml/jackson/databind/deser/DefaultDeserializationContext;->_config:Lcom/fasterxml/jackson/databind/DeserializationConfig;

    invoke-virtual {v2, v3, p1, v1}, Lcom/fasterxml/jackson/databind/cfg/HandlerInstantiator;->deserializerInstance(Lcom/fasterxml/jackson/databind/DeserializationConfig;Lcom/fasterxml/jackson/databind/introspect/Annotated;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/JsonDeserializer;

    move-result-object v0

    .restart local v0    # "deser":Lcom/fasterxml/jackson/databind/JsonDeserializer;, "Lcom/fasterxml/jackson/databind/JsonDeserializer<*>;"
    goto :goto_1

    .line 131
    .end local v0    # "deser":Lcom/fasterxml/jackson/databind/JsonDeserializer;, "Lcom/fasterxml/jackson/databind/JsonDeserializer<*>;"
    :cond_5
    iget-object v3, p0, Lcom/fasterxml/jackson/databind/deser/DefaultDeserializationContext;->_config:Lcom/fasterxml/jackson/databind/DeserializationConfig;

    invoke-virtual {v3}, Lcom/fasterxml/jackson/databind/DeserializationConfig;->canOverrideAccessModifiers()Z

    move-result v3

    invoke-static {v1, v3}, Lcom/fasterxml/jackson/databind/util/ClassUtil;->createInstance(Ljava/lang/Class;Z)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/fasterxml/jackson/databind/JsonDeserializer;

    .restart local v0    # "deser":Lcom/fasterxml/jackson/databind/JsonDeserializer;, "Lcom/fasterxml/jackson/databind/JsonDeserializer<*>;"
    goto/16 :goto_1
.end method

.method public findObjectId(Ljava/lang/Object;Lcom/fasterxml/jackson/annotation/ObjectIdGenerator;)Lcom/fasterxml/jackson/databind/deser/impl/ReadableObjectId;
    .locals 4
    .param p1, "id"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Object;",
            "Lcom/fasterxml/jackson/annotation/ObjectIdGenerator",
            "<*>;)",
            "Lcom/fasterxml/jackson/databind/deser/impl/ReadableObjectId;"
        }
    .end annotation

    .prologue
    .line 61
    .local p2, "generator":Lcom/fasterxml/jackson/annotation/ObjectIdGenerator;, "Lcom/fasterxml/jackson/annotation/ObjectIdGenerator<*>;"
    invoke-virtual {p2, p1}, Lcom/fasterxml/jackson/annotation/ObjectIdGenerator;->key(Ljava/lang/Object;)Lcom/fasterxml/jackson/annotation/ObjectIdGenerator$IdKey;

    move-result-object v2

    .line 62
    .local v2, "key":Lcom/fasterxml/jackson/annotation/ObjectIdGenerator$IdKey;
    iget-object v3, p0, Lcom/fasterxml/jackson/databind/deser/DefaultDeserializationContext;->_objectIds:Ljava/util/LinkedHashMap;

    if-nez v3, :cond_1

    .line 63
    new-instance v3, Ljava/util/LinkedHashMap;

    invoke-direct {v3}, Ljava/util/LinkedHashMap;-><init>()V

    iput-object v3, p0, Lcom/fasterxml/jackson/databind/deser/DefaultDeserializationContext;->_objectIds:Ljava/util/LinkedHashMap;

    .line 70
    :cond_0
    new-instance v0, Lcom/fasterxml/jackson/databind/deser/impl/ReadableObjectId;

    invoke-direct {v0, p1}, Lcom/fasterxml/jackson/databind/deser/impl/ReadableObjectId;-><init>(Ljava/lang/Object;)V

    .line 71
    .local v0, "entry":Lcom/fasterxml/jackson/databind/deser/impl/ReadableObjectId;
    iget-object v3, p0, Lcom/fasterxml/jackson/databind/deser/DefaultDeserializationContext;->_objectIds:Ljava/util/LinkedHashMap;

    invoke-virtual {v3, v2, v0}, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-object v1, v0

    .line 72
    .end local v0    # "entry":Lcom/fasterxml/jackson/databind/deser/impl/ReadableObjectId;
    .local v1, "entry":Ljava/lang/Object;
    :goto_0
    return-object v1

    .line 65
    .end local v1    # "entry":Ljava/lang/Object;
    :cond_1
    iget-object v3, p0, Lcom/fasterxml/jackson/databind/deser/DefaultDeserializationContext;->_objectIds:Ljava/util/LinkedHashMap;

    invoke-virtual {v3, v2}, Ljava/util/LinkedHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/fasterxml/jackson/databind/deser/impl/ReadableObjectId;

    .line 66
    .restart local v0    # "entry":Lcom/fasterxml/jackson/databind/deser/impl/ReadableObjectId;
    if-eqz v0, :cond_0

    move-object v1, v0

    .line 67
    .restart local v1    # "entry":Ljava/lang/Object;
    goto :goto_0
.end method

.method public final keyDeserializerInstance(Lcom/fasterxml/jackson/databind/introspect/Annotated;Ljava/lang/Object;)Lcom/fasterxml/jackson/databind/KeyDeserializer;
    .locals 6
    .param p1, "annotated"    # Lcom/fasterxml/jackson/databind/introspect/Annotated;
    .param p2, "deserDef"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/fasterxml/jackson/databind/JsonMappingException;
        }
    .end annotation

    .prologue
    const/4 v0, 0x0

    .line 147
    if-nez p2, :cond_1

    .line 182
    :cond_0
    :goto_0
    return-object v0

    .line 153
    :cond_1
    instance-of v3, p2, Lcom/fasterxml/jackson/databind/KeyDeserializer;

    if-eqz v3, :cond_2

    move-object v0, p2

    .line 154
    check-cast v0, Lcom/fasterxml/jackson/databind/KeyDeserializer;

    .line 179
    .local v0, "deser":Lcom/fasterxml/jackson/databind/KeyDeserializer;
    :goto_1
    instance-of v3, v0, Lcom/fasterxml/jackson/databind/deser/ResolvableDeserializer;

    if-eqz v3, :cond_0

    move-object v3, v0

    .line 180
    check-cast v3, Lcom/fasterxml/jackson/databind/deser/ResolvableDeserializer;

    invoke-interface {v3, p0}, Lcom/fasterxml/jackson/databind/deser/ResolvableDeserializer;->resolve(Lcom/fasterxml/jackson/databind/DeserializationContext;)V

    goto :goto_0

    .line 156
    .end local v0    # "deser":Lcom/fasterxml/jackson/databind/KeyDeserializer;
    :cond_2
    instance-of v3, p2, Ljava/lang/Class;

    if-nez v3, :cond_3

    .line 157
    new-instance v3, Ljava/lang/IllegalStateException;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "AnnotationIntrospector returned key deserializer definition of type "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {p2}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "; expected type KeyDeserializer or Class<KeyDeserializer> instead"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v3

    :cond_3
    move-object v1, p2

    .line 161
    check-cast v1, Ljava/lang/Class;

    .line 163
    .local v1, "deserClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    const-class v3, Lcom/fasterxml/jackson/databind/KeyDeserializer$None;

    if-eq v1, v3, :cond_0

    const-class v3, Lcom/fasterxml/jackson/databind/annotation/NoClass;

    if-eq v1, v3, :cond_0

    .line 166
    const-class v3, Lcom/fasterxml/jackson/databind/KeyDeserializer;

    invoke-virtual {v3, v1}, Ljava/lang/Class;->isAssignableFrom(Ljava/lang/Class;)Z

    move-result v3

    if-nez v3, :cond_4

    .line 167
    new-instance v3, Ljava/lang/IllegalStateException;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "AnnotationIntrospector returned Class "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "; expected Class<KeyDeserializer>"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 170
    :cond_4
    iget-object v3, p0, Lcom/fasterxml/jackson/databind/deser/DefaultDeserializationContext;->_config:Lcom/fasterxml/jackson/databind/DeserializationConfig;

    invoke-virtual {v3}, Lcom/fasterxml/jackson/databind/DeserializationConfig;->getHandlerInstantiator()Lcom/fasterxml/jackson/databind/cfg/HandlerInstantiator;

    move-result-object v2

    .line 171
    .local v2, "hi":Lcom/fasterxml/jackson/databind/cfg/HandlerInstantiator;
    if-eqz v2, :cond_5

    .line 172
    iget-object v3, p0, Lcom/fasterxml/jackson/databind/deser/DefaultDeserializationContext;->_config:Lcom/fasterxml/jackson/databind/DeserializationConfig;

    invoke-virtual {v2, v3, p1, v1}, Lcom/fasterxml/jackson/databind/cfg/HandlerInstantiator;->keyDeserializerInstance(Lcom/fasterxml/jackson/databind/DeserializationConfig;Lcom/fasterxml/jackson/databind/introspect/Annotated;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/KeyDeserializer;

    move-result-object v0

    .restart local v0    # "deser":Lcom/fasterxml/jackson/databind/KeyDeserializer;
    goto :goto_1

    .line 174
    .end local v0    # "deser":Lcom/fasterxml/jackson/databind/KeyDeserializer;
    :cond_5
    iget-object v3, p0, Lcom/fasterxml/jackson/databind/deser/DefaultDeserializationContext;->_config:Lcom/fasterxml/jackson/databind/DeserializationConfig;

    invoke-virtual {v3}, Lcom/fasterxml/jackson/databind/DeserializationConfig;->canOverrideAccessModifiers()Z

    move-result v3

    invoke-static {v1, v3}, Lcom/fasterxml/jackson/databind/util/ClassUtil;->createInstance(Ljava/lang/Class;Z)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/fasterxml/jackson/databind/KeyDeserializer;

    .restart local v0    # "deser":Lcom/fasterxml/jackson/databind/KeyDeserializer;
    goto/16 :goto_1
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
    .line 80
    invoke-virtual {p2}, Lcom/fasterxml/jackson/databind/introspect/ObjectIdInfo;->getGeneratorType()Ljava/lang/Class;

    move-result-object v2

    .line 81
    .local v2, "implClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    iget-object v3, p0, Lcom/fasterxml/jackson/databind/deser/DefaultDeserializationContext;->_config:Lcom/fasterxml/jackson/databind/DeserializationConfig;

    invoke-virtual {v3}, Lcom/fasterxml/jackson/databind/DeserializationConfig;->getHandlerInstantiator()Lcom/fasterxml/jackson/databind/cfg/HandlerInstantiator;

    move-result-object v1

    .line 84
    .local v1, "hi":Lcom/fasterxml/jackson/databind/cfg/HandlerInstantiator;
    if-eqz v1, :cond_0

    .line 85
    iget-object v3, p0, Lcom/fasterxml/jackson/databind/deser/DefaultDeserializationContext;->_config:Lcom/fasterxml/jackson/databind/DeserializationConfig;

    invoke-virtual {v1, v3, p1, v2}, Lcom/fasterxml/jackson/databind/cfg/HandlerInstantiator;->objectIdGeneratorInstance(Lcom/fasterxml/jackson/databind/cfg/MapperConfig;Lcom/fasterxml/jackson/databind/introspect/Annotated;Ljava/lang/Class;)Lcom/fasterxml/jackson/annotation/ObjectIdGenerator;

    move-result-object v0

    .line 90
    .local v0, "gen":Lcom/fasterxml/jackson/annotation/ObjectIdGenerator;, "Lcom/fasterxml/jackson/annotation/ObjectIdGenerator<*>;"
    :goto_0
    invoke-virtual {p2}, Lcom/fasterxml/jackson/databind/introspect/ObjectIdInfo;->getScope()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/fasterxml/jackson/annotation/ObjectIdGenerator;->forScope(Ljava/lang/Class;)Lcom/fasterxml/jackson/annotation/ObjectIdGenerator;

    move-result-object v3

    return-object v3

    .line 87
    .end local v0    # "gen":Lcom/fasterxml/jackson/annotation/ObjectIdGenerator;, "Lcom/fasterxml/jackson/annotation/ObjectIdGenerator<*>;"
    :cond_0
    iget-object v3, p0, Lcom/fasterxml/jackson/databind/deser/DefaultDeserializationContext;->_config:Lcom/fasterxml/jackson/databind/DeserializationConfig;

    invoke-virtual {v3}, Lcom/fasterxml/jackson/databind/DeserializationConfig;->canOverrideAccessModifiers()Z

    move-result v3

    invoke-static {v2, v3}, Lcom/fasterxml/jackson/databind/util/ClassUtil;->createInstance(Ljava/lang/Class;Z)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/fasterxml/jackson/annotation/ObjectIdGenerator;

    .restart local v0    # "gen":Lcom/fasterxml/jackson/annotation/ObjectIdGenerator;, "Lcom/fasterxml/jackson/annotation/ObjectIdGenerator<*>;"
    goto :goto_0
.end method

.method public abstract with(Lcom/fasterxml/jackson/databind/deser/DeserializerFactory;)Lcom/fasterxml/jackson/databind/deser/DefaultDeserializationContext;
.end method
