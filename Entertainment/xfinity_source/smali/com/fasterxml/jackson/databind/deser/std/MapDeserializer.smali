.class public Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;
.super Lcom/fasterxml/jackson/databind/deser/std/ContainerDeserializerBase;
.source "MapDeserializer.java"

# interfaces
.implements Lcom/fasterxml/jackson/databind/deser/ContextualDeserializer;
.implements Lcom/fasterxml/jackson/databind/deser/ResolvableDeserializer;


# annotations
.annotation runtime Lcom/fasterxml/jackson/databind/annotation/JacksonStdImpl;
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/fasterxml/jackson/databind/deser/std/ContainerDeserializerBase",
        "<",
        "Ljava/util/Map",
        "<",
        "Ljava/lang/Object;",
        "Ljava/lang/Object;",
        ">;>;",
        "Lcom/fasterxml/jackson/databind/deser/ContextualDeserializer;",
        "Lcom/fasterxml/jackson/databind/deser/ResolvableDeserializer;"
    }
.end annotation


# instance fields
.field protected _delegateDeserializer:Lcom/fasterxml/jackson/databind/JsonDeserializer;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/fasterxml/jackson/databind/JsonDeserializer",
            "<",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end field

.field protected final _hasDefaultCreator:Z

.field protected _ignorableProperties:Ljava/util/HashSet;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashSet",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field protected final _keyDeserializer:Lcom/fasterxml/jackson/databind/KeyDeserializer;

.field protected final _mapType:Lcom/fasterxml/jackson/databind/JavaType;

.field protected _propertyBasedCreator:Lcom/fasterxml/jackson/databind/deser/impl/PropertyBasedCreator;

.field protected _standardStringKey:Z

.field protected final _valueDeserializer:Lcom/fasterxml/jackson/databind/JsonDeserializer;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/fasterxml/jackson/databind/JsonDeserializer",
            "<",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end field

.field protected final _valueInstantiator:Lcom/fasterxml/jackson/databind/deser/ValueInstantiator;

.field protected final _valueTypeDeserializer:Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;


# direct methods
.method public constructor <init>(Lcom/fasterxml/jackson/databind/JavaType;Lcom/fasterxml/jackson/databind/deser/ValueInstantiator;Lcom/fasterxml/jackson/databind/KeyDeserializer;Lcom/fasterxml/jackson/databind/JsonDeserializer;Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;)V
    .locals 2
    .param p1, "mapType"    # Lcom/fasterxml/jackson/databind/JavaType;
    .param p2, "valueInstantiator"    # Lcom/fasterxml/jackson/databind/deser/ValueInstantiator;
    .param p3, "keyDeser"    # Lcom/fasterxml/jackson/databind/KeyDeserializer;
    .param p5, "valueTypeDeser"    # Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/fasterxml/jackson/databind/JavaType;",
            "Lcom/fasterxml/jackson/databind/deser/ValueInstantiator;",
            "Lcom/fasterxml/jackson/databind/KeyDeserializer;",
            "Lcom/fasterxml/jackson/databind/JsonDeserializer",
            "<",
            "Ljava/lang/Object;",
            ">;",
            "Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;",
            ")V"
        }
    .end annotation

    .prologue
    .local p4, "valueDeser":Lcom/fasterxml/jackson/databind/JsonDeserializer;, "Lcom/fasterxml/jackson/databind/JsonDeserializer<Ljava/lang/Object;>;"
    const/4 v1, 0x0

    .line 96
    const-class v0, Ljava/util/Map;

    invoke-direct {p0, v0}, Lcom/fasterxml/jackson/databind/deser/std/ContainerDeserializerBase;-><init>(Ljava/lang/Class;)V

    .line 97
    iput-object p1, p0, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_mapType:Lcom/fasterxml/jackson/databind/JavaType;

    .line 98
    iput-object p3, p0, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_keyDeserializer:Lcom/fasterxml/jackson/databind/KeyDeserializer;

    .line 99
    iput-object p4, p0, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_valueDeserializer:Lcom/fasterxml/jackson/databind/JsonDeserializer;

    .line 100
    iput-object p5, p0, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_valueTypeDeserializer:Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;

    .line 101
    iput-object p2, p0, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_valueInstantiator:Lcom/fasterxml/jackson/databind/deser/ValueInstantiator;

    .line 102
    invoke-virtual {p2}, Lcom/fasterxml/jackson/databind/deser/ValueInstantiator;->canCreateUsingDefault()Z

    move-result v0

    iput-boolean v0, p0, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_hasDefaultCreator:Z

    .line 103
    iput-object v1, p0, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_delegateDeserializer:Lcom/fasterxml/jackson/databind/JsonDeserializer;

    .line 104
    iput-object v1, p0, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_propertyBasedCreator:Lcom/fasterxml/jackson/databind/deser/impl/PropertyBasedCreator;

    .line 105
    invoke-virtual {p0, p1, p3}, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_isStdKeyDeser(Lcom/fasterxml/jackson/databind/JavaType;Lcom/fasterxml/jackson/databind/KeyDeserializer;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_standardStringKey:Z

    .line 106
    return-void
.end method

.method protected constructor <init>(Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;)V
    .locals 1
    .param p1, "src"    # Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;

    .prologue
    .line 114
    iget-object v0, p1, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_valueClass:Ljava/lang/Class;

    invoke-direct {p0, v0}, Lcom/fasterxml/jackson/databind/deser/std/ContainerDeserializerBase;-><init>(Ljava/lang/Class;)V

    .line 115
    iget-object v0, p1, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_mapType:Lcom/fasterxml/jackson/databind/JavaType;

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_mapType:Lcom/fasterxml/jackson/databind/JavaType;

    .line 116
    iget-object v0, p1, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_keyDeserializer:Lcom/fasterxml/jackson/databind/KeyDeserializer;

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_keyDeserializer:Lcom/fasterxml/jackson/databind/KeyDeserializer;

    .line 117
    iget-object v0, p1, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_valueDeserializer:Lcom/fasterxml/jackson/databind/JsonDeserializer;

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_valueDeserializer:Lcom/fasterxml/jackson/databind/JsonDeserializer;

    .line 118
    iget-object v0, p1, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_valueTypeDeserializer:Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_valueTypeDeserializer:Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;

    .line 119
    iget-object v0, p1, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_valueInstantiator:Lcom/fasterxml/jackson/databind/deser/ValueInstantiator;

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_valueInstantiator:Lcom/fasterxml/jackson/databind/deser/ValueInstantiator;

    .line 120
    iget-object v0, p1, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_propertyBasedCreator:Lcom/fasterxml/jackson/databind/deser/impl/PropertyBasedCreator;

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_propertyBasedCreator:Lcom/fasterxml/jackson/databind/deser/impl/PropertyBasedCreator;

    .line 121
    iget-object v0, p1, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_delegateDeserializer:Lcom/fasterxml/jackson/databind/JsonDeserializer;

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_delegateDeserializer:Lcom/fasterxml/jackson/databind/JsonDeserializer;

    .line 122
    iget-boolean v0, p1, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_hasDefaultCreator:Z

    iput-boolean v0, p0, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_hasDefaultCreator:Z

    .line 124
    iget-object v0, p1, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_ignorableProperties:Ljava/util/HashSet;

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_ignorableProperties:Ljava/util/HashSet;

    .line 126
    iget-boolean v0, p1, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_standardStringKey:Z

    iput-boolean v0, p0, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_standardStringKey:Z

    .line 127
    return-void
.end method

.method protected constructor <init>(Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;Lcom/fasterxml/jackson/databind/KeyDeserializer;Lcom/fasterxml/jackson/databind/JsonDeserializer;Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;Ljava/util/HashSet;)V
    .locals 1
    .param p1, "src"    # Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;
    .param p2, "keyDeser"    # Lcom/fasterxml/jackson/databind/KeyDeserializer;
    .param p4, "valueTypeDeser"    # Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;",
            "Lcom/fasterxml/jackson/databind/KeyDeserializer;",
            "Lcom/fasterxml/jackson/databind/JsonDeserializer",
            "<",
            "Ljava/lang/Object;",
            ">;",
            "Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;",
            "Ljava/util/HashSet",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 134
    .local p3, "valueDeser":Lcom/fasterxml/jackson/databind/JsonDeserializer;, "Lcom/fasterxml/jackson/databind/JsonDeserializer<Ljava/lang/Object;>;"
    .local p5, "ignorable":Ljava/util/HashSet;, "Ljava/util/HashSet<Ljava/lang/String;>;"
    iget-object v0, p1, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_valueClass:Ljava/lang/Class;

    invoke-direct {p0, v0}, Lcom/fasterxml/jackson/databind/deser/std/ContainerDeserializerBase;-><init>(Ljava/lang/Class;)V

    .line 135
    iget-object v0, p1, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_mapType:Lcom/fasterxml/jackson/databind/JavaType;

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_mapType:Lcom/fasterxml/jackson/databind/JavaType;

    .line 136
    iput-object p2, p0, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_keyDeserializer:Lcom/fasterxml/jackson/databind/KeyDeserializer;

    .line 137
    iput-object p3, p0, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_valueDeserializer:Lcom/fasterxml/jackson/databind/JsonDeserializer;

    .line 138
    iput-object p4, p0, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_valueTypeDeserializer:Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;

    .line 139
    iget-object v0, p1, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_valueInstantiator:Lcom/fasterxml/jackson/databind/deser/ValueInstantiator;

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_valueInstantiator:Lcom/fasterxml/jackson/databind/deser/ValueInstantiator;

    .line 140
    iget-object v0, p1, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_propertyBasedCreator:Lcom/fasterxml/jackson/databind/deser/impl/PropertyBasedCreator;

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_propertyBasedCreator:Lcom/fasterxml/jackson/databind/deser/impl/PropertyBasedCreator;

    .line 141
    iget-object v0, p1, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_delegateDeserializer:Lcom/fasterxml/jackson/databind/JsonDeserializer;

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_delegateDeserializer:Lcom/fasterxml/jackson/databind/JsonDeserializer;

    .line 142
    iget-boolean v0, p1, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_hasDefaultCreator:Z

    iput-boolean v0, p0, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_hasDefaultCreator:Z

    .line 143
    iput-object p5, p0, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_ignorableProperties:Ljava/util/HashSet;

    .line 145
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_mapType:Lcom/fasterxml/jackson/databind/JavaType;

    invoke-virtual {p0, v0, p2}, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_isStdKeyDeser(Lcom/fasterxml/jackson/databind/JavaType;Lcom/fasterxml/jackson/databind/KeyDeserializer;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_standardStringKey:Z

    .line 146
    return-void
.end method


# virtual methods
.method public _deserializeUsingCreator(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;)Ljava/util/Map;
    .locals 13
    .param p1, "jp"    # Lcom/fasterxml/jackson/core/JsonParser;
    .param p2, "ctxt"    # Lcom/fasterxml/jackson/databind/DeserializationContext;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/fasterxml/jackson/core/JsonParser;",
            "Lcom/fasterxml/jackson/databind/DeserializationContext;",
            ")",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Object;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonProcessingException;
        }
    .end annotation

    .prologue
    .line 441
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_propertyBasedCreator:Lcom/fasterxml/jackson/databind/deser/impl/PropertyBasedCreator;

    .line 443
    .local v1, "creator":Lcom/fasterxml/jackson/databind/deser/impl/PropertyBasedCreator;
    const/4 v12, 0x0

    invoke-virtual {v1, p1, p2, v12}, Lcom/fasterxml/jackson/databind/deser/impl/PropertyBasedCreator;->startBuilding(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;Lcom/fasterxml/jackson/databind/deser/impl/ObjectIdReader;)Lcom/fasterxml/jackson/databind/deser/impl/PropertyValueBuffer;

    move-result-object v0

    .line 445
    .local v0, "buffer":Lcom/fasterxml/jackson/databind/deser/impl/PropertyValueBuffer;
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v8

    .line 446
    .local v8, "t":Lcom/fasterxml/jackson/core/JsonToken;
    sget-object v12, Lcom/fasterxml/jackson/core/JsonToken;->START_OBJECT:Lcom/fasterxml/jackson/core/JsonToken;

    if-ne v8, v12, :cond_0

    .line 447
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v8

    .line 449
    :cond_0
    iget-object v11, p0, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_valueDeserializer:Lcom/fasterxml/jackson/databind/JsonDeserializer;

    .line 450
    .local v11, "valueDes":Lcom/fasterxml/jackson/databind/JsonDeserializer;, "Lcom/fasterxml/jackson/databind/JsonDeserializer<Ljava/lang/Object;>;"
    iget-object v9, p0, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_valueTypeDeserializer:Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;

    .line 451
    .local v9, "typeDeser":Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;
    :goto_0
    sget-object v12, Lcom/fasterxml/jackson/core/JsonToken;->FIELD_NAME:Lcom/fasterxml/jackson/core/JsonToken;

    if-ne v8, v12, :cond_6

    .line 452
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v6

    .line 453
    .local v6, "propName":Ljava/lang/String;
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v8

    .line 454
    iget-object v12, p0, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_ignorableProperties:Ljava/util/HashSet;

    if-eqz v12, :cond_2

    iget-object v12, p0, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_ignorableProperties:Ljava/util/HashSet;

    invoke-virtual {v12, v6}, Ljava/util/HashSet;->contains(Ljava/lang/Object;)Z

    move-result v12

    if-eqz v12, :cond_2

    .line 455
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->skipChildren()Lcom/fasterxml/jackson/core/JsonParser;

    .line 451
    :cond_1
    :goto_1
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v8

    goto :goto_0

    .line 459
    :cond_2
    invoke-virtual {v1, v6}, Lcom/fasterxml/jackson/databind/deser/impl/PropertyBasedCreator;->findCreatorProperty(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/deser/SettableBeanProperty;

    move-result-object v5

    .line 460
    .local v5, "prop":Lcom/fasterxml/jackson/databind/deser/SettableBeanProperty;
    if-eqz v5, :cond_3

    .line 462
    invoke-virtual {v5, p1, p2}, Lcom/fasterxml/jackson/databind/deser/SettableBeanProperty;->deserialize(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;)Ljava/lang/Object;

    move-result-object v10

    .line 463
    .local v10, "value":Ljava/lang/Object;
    invoke-virtual {v5}, Lcom/fasterxml/jackson/databind/deser/SettableBeanProperty;->getCreatorIndex()I

    move-result v12

    invoke-virtual {v0, v12, v10}, Lcom/fasterxml/jackson/databind/deser/impl/PropertyValueBuffer;->assignParameter(ILjava/lang/Object;)Z

    move-result v12

    if-eqz v12, :cond_1

    .line 464
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    .line 467
    :try_start_0
    invoke-virtual {v1, p2, v0}, Lcom/fasterxml/jackson/databind/deser/impl/PropertyBasedCreator;->build(Lcom/fasterxml/jackson/databind/DeserializationContext;Lcom/fasterxml/jackson/databind/deser/impl/PropertyValueBuffer;)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/util/Map;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 472
    .local v7, "result":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/Object;Ljava/lang/Object;>;"
    invoke-virtual {p0, p1, p2, v7}, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_readAndBind(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;Ljava/util/Map;)V

    .line 496
    .end local v5    # "prop":Lcom/fasterxml/jackson/databind/deser/SettableBeanProperty;
    .end local v6    # "propName":Ljava/lang/String;
    .end local v7    # "result":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/Object;Ljava/lang/Object;>;"
    .end local v10    # "value":Ljava/lang/Object;
    :goto_2
    return-object v7

    .line 468
    .restart local v5    # "prop":Lcom/fasterxml/jackson/databind/deser/SettableBeanProperty;
    .restart local v6    # "propName":Ljava/lang/String;
    .restart local v10    # "value":Ljava/lang/Object;
    :catch_0
    move-exception v2

    .line 469
    .local v2, "e":Ljava/lang/Exception;
    iget-object v12, p0, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_mapType:Lcom/fasterxml/jackson/databind/JavaType;

    invoke-virtual {v12}, Lcom/fasterxml/jackson/databind/JavaType;->getRawClass()Ljava/lang/Class;

    move-result-object v12

    invoke-virtual {p0, v2, v12}, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->wrapAndThrow(Ljava/lang/Throwable;Ljava/lang/Object;)V

    .line 470
    const/4 v7, 0x0

    goto :goto_2

    .line 478
    .end local v2    # "e":Ljava/lang/Exception;
    .end local v10    # "value":Ljava/lang/Object;
    :cond_3
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v3

    .line 479
    .local v3, "fieldName":Ljava/lang/String;
    iget-object v12, p0, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_keyDeserializer:Lcom/fasterxml/jackson/databind/KeyDeserializer;

    invoke-virtual {v12, v3, p2}, Lcom/fasterxml/jackson/databind/KeyDeserializer;->deserializeKey(Ljava/lang/String;Lcom/fasterxml/jackson/databind/DeserializationContext;)Ljava/lang/Object;

    move-result-object v4

    .line 481
    .local v4, "key":Ljava/lang/Object;
    sget-object v12, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_NULL:Lcom/fasterxml/jackson/core/JsonToken;

    if-ne v8, v12, :cond_4

    .line 482
    const/4 v10, 0x0

    .line 488
    :goto_3
    invoke-virtual {v0, v4, v10}, Lcom/fasterxml/jackson/databind/deser/impl/PropertyValueBuffer;->bufferMapProperty(Ljava/lang/Object;Ljava/lang/Object;)V

    goto :goto_1

    .line 483
    :cond_4
    if-nez v9, :cond_5

    .line 484
    invoke-virtual {v11, p1, p2}, Lcom/fasterxml/jackson/databind/JsonDeserializer;->deserialize(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;)Ljava/lang/Object;

    move-result-object v10

    .restart local v10    # "value":Ljava/lang/Object;
    goto :goto_3

    .line 486
    .end local v10    # "value":Ljava/lang/Object;
    :cond_5
    invoke-virtual {v11, p1, p2, v9}, Lcom/fasterxml/jackson/databind/JsonDeserializer;->deserializeWithType(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;)Ljava/lang/Object;

    move-result-object v10

    .restart local v10    # "value":Ljava/lang/Object;
    goto :goto_3

    .line 493
    .end local v3    # "fieldName":Ljava/lang/String;
    .end local v4    # "key":Ljava/lang/Object;
    .end local v5    # "prop":Lcom/fasterxml/jackson/databind/deser/SettableBeanProperty;
    .end local v6    # "propName":Ljava/lang/String;
    .end local v10    # "value":Ljava/lang/Object;
    :cond_6
    :try_start_1
    invoke-virtual {v1, p2, v0}, Lcom/fasterxml/jackson/databind/deser/impl/PropertyBasedCreator;->build(Lcom/fasterxml/jackson/databind/DeserializationContext;Lcom/fasterxml/jackson/databind/deser/impl/PropertyValueBuffer;)Ljava/lang/Object;

    move-result-object v12

    check-cast v12, Ljava/util/Map;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    move-object v7, v12

    goto :goto_2

    .line 494
    :catch_1
    move-exception v2

    .line 495
    .restart local v2    # "e":Ljava/lang/Exception;
    iget-object v12, p0, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_mapType:Lcom/fasterxml/jackson/databind/JavaType;

    invoke-virtual {v12}, Lcom/fasterxml/jackson/databind/JavaType;->getRawClass()Ljava/lang/Class;

    move-result-object v12

    invoke-virtual {p0, v2, v12}, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->wrapAndThrow(Ljava/lang/Throwable;Ljava/lang/Object;)V

    .line 496
    const/4 v7, 0x0

    goto :goto_2
.end method

.method protected final _isStdKeyDeser(Lcom/fasterxml/jackson/databind/JavaType;Lcom/fasterxml/jackson/databind/KeyDeserializer;)Z
    .locals 4
    .param p1, "mapType"    # Lcom/fasterxml/jackson/databind/JavaType;
    .param p2, "keyDeser"    # Lcom/fasterxml/jackson/databind/KeyDeserializer;

    .prologue
    const/4 v2, 0x1

    .line 172
    if-nez p2, :cond_1

    .line 180
    :cond_0
    :goto_0
    return v2

    .line 175
    :cond_1
    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/JavaType;->getKeyType()Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v0

    .line 176
    .local v0, "keyType":Lcom/fasterxml/jackson/databind/JavaType;
    if-eqz v0, :cond_0

    .line 179
    invoke-virtual {v0}, Lcom/fasterxml/jackson/databind/JavaType;->getRawClass()Ljava/lang/Class;

    move-result-object v1

    .line 180
    .local v1, "rawKeyType":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    const-class v3, Ljava/lang/String;

    if-eq v1, v3, :cond_2

    const-class v3, Ljava/lang/Object;

    if-ne v1, v3, :cond_3

    :cond_2
    invoke-virtual {p0, p2}, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->isDefaultKeyDeserializer(Lcom/fasterxml/jackson/databind/KeyDeserializer;)Z

    move-result v3

    if-nez v3, :cond_0

    :cond_3
    const/4 v2, 0x0

    goto :goto_0
.end method

.method protected final _readAndBind(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;Ljava/util/Map;)V
    .locals 8
    .param p1, "jp"    # Lcom/fasterxml/jackson/core/JsonParser;
    .param p2, "ctxt"    # Lcom/fasterxml/jackson/databind/DeserializationContext;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/fasterxml/jackson/core/JsonParser;",
            "Lcom/fasterxml/jackson/databind/DeserializationContext;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Object;",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonProcessingException;
        }
    .end annotation

    .prologue
    .line 365
    .local p3, "result":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/Object;Ljava/lang/Object;>;"
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v3

    .line 366
    .local v3, "t":Lcom/fasterxml/jackson/core/JsonToken;
    sget-object v7, Lcom/fasterxml/jackson/core/JsonToken;->START_OBJECT:Lcom/fasterxml/jackson/core/JsonToken;

    if-ne v3, v7, :cond_0

    .line 367
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v3

    .line 369
    :cond_0
    iget-object v2, p0, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_keyDeserializer:Lcom/fasterxml/jackson/databind/KeyDeserializer;

    .line 371
    .local v2, "keyDes":Lcom/fasterxml/jackson/databind/KeyDeserializer;
    iget-object v6, p0, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_valueDeserializer:Lcom/fasterxml/jackson/databind/JsonDeserializer;

    .line 372
    .local v6, "valueDes":Lcom/fasterxml/jackson/databind/JsonDeserializer;, "Lcom/fasterxml/jackson/databind/JsonDeserializer<Ljava/lang/Object;>;"
    iget-object v4, p0, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_valueTypeDeserializer:Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;

    .line 373
    .local v4, "typeDeser":Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;
    :goto_0
    sget-object v7, Lcom/fasterxml/jackson/core/JsonToken;->FIELD_NAME:Lcom/fasterxml/jackson/core/JsonToken;

    if-ne v3, v7, :cond_4

    .line 375
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v0

    .line 376
    .local v0, "fieldName":Ljava/lang/String;
    invoke-virtual {v2, v0, p2}, Lcom/fasterxml/jackson/databind/KeyDeserializer;->deserializeKey(Ljava/lang/String;Lcom/fasterxml/jackson/databind/DeserializationContext;)Ljava/lang/Object;

    move-result-object v1

    .line 378
    .local v1, "key":Ljava/lang/Object;
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v3

    .line 379
    iget-object v7, p0, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_ignorableProperties:Ljava/util/HashSet;

    if-eqz v7, :cond_1

    iget-object v7, p0, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_ignorableProperties:Ljava/util/HashSet;

    invoke-virtual {v7, v0}, Ljava/util/HashSet;->contains(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_1

    .line 380
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->skipChildren()Lcom/fasterxml/jackson/core/JsonParser;

    .line 373
    :goto_1
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v3

    goto :goto_0

    .line 385
    :cond_1
    sget-object v7, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_NULL:Lcom/fasterxml/jackson/core/JsonToken;

    if-ne v3, v7, :cond_2

    .line 386
    const/4 v5, 0x0

    .line 396
    :goto_2
    invoke-interface {p3, v1, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_1

    .line 387
    :cond_2
    if-nez v4, :cond_3

    .line 388
    invoke-virtual {v6, p1, p2}, Lcom/fasterxml/jackson/databind/JsonDeserializer;->deserialize(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;)Ljava/lang/Object;

    move-result-object v5

    .local v5, "value":Ljava/lang/Object;
    goto :goto_2

    .line 390
    .end local v5    # "value":Ljava/lang/Object;
    :cond_3
    invoke-virtual {v6, p1, p2, v4}, Lcom/fasterxml/jackson/databind/JsonDeserializer;->deserializeWithType(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;)Ljava/lang/Object;

    move-result-object v5

    .restart local v5    # "value":Ljava/lang/Object;
    goto :goto_2

    .line 398
    .end local v0    # "fieldName":Ljava/lang/String;
    .end local v1    # "key":Ljava/lang/Object;
    .end local v5    # "value":Ljava/lang/Object;
    :cond_4
    return-void
.end method

.method protected final _readAndBindStringMap(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;Ljava/util/Map;)V
    .locals 6
    .param p1, "jp"    # Lcom/fasterxml/jackson/core/JsonParser;
    .param p2, "ctxt"    # Lcom/fasterxml/jackson/databind/DeserializationContext;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/fasterxml/jackson/core/JsonParser;",
            "Lcom/fasterxml/jackson/databind/DeserializationContext;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Object;",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonProcessingException;
        }
    .end annotation

    .prologue
    .line 409
    .local p3, "result":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/Object;Ljava/lang/Object;>;"
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v1

    .line 410
    .local v1, "t":Lcom/fasterxml/jackson/core/JsonToken;
    sget-object v5, Lcom/fasterxml/jackson/core/JsonToken;->START_OBJECT:Lcom/fasterxml/jackson/core/JsonToken;

    if-ne v1, v5, :cond_0

    .line 411
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v1

    .line 413
    :cond_0
    iget-object v4, p0, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_valueDeserializer:Lcom/fasterxml/jackson/databind/JsonDeserializer;

    .line 414
    .local v4, "valueDes":Lcom/fasterxml/jackson/databind/JsonDeserializer;, "Lcom/fasterxml/jackson/databind/JsonDeserializer<Ljava/lang/Object;>;"
    iget-object v2, p0, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_valueTypeDeserializer:Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;

    .line 415
    .local v2, "typeDeser":Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;
    :goto_0
    sget-object v5, Lcom/fasterxml/jackson/core/JsonToken;->FIELD_NAME:Lcom/fasterxml/jackson/core/JsonToken;

    if-ne v1, v5, :cond_4

    .line 417
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v0

    .line 419
    .local v0, "fieldName":Ljava/lang/String;
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v1

    .line 420
    iget-object v5, p0, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_ignorableProperties:Ljava/util/HashSet;

    if-eqz v5, :cond_1

    iget-object v5, p0, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_ignorableProperties:Ljava/util/HashSet;

    invoke-virtual {v5, v0}, Ljava/util/HashSet;->contains(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_1

    .line 421
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->skipChildren()Lcom/fasterxml/jackson/core/JsonParser;

    .line 415
    :goto_1
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v1

    goto :goto_0

    .line 426
    :cond_1
    sget-object v5, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_NULL:Lcom/fasterxml/jackson/core/JsonToken;

    if-ne v1, v5, :cond_2

    .line 427
    const/4 v3, 0x0

    .line 433
    :goto_2
    invoke-interface {p3, v0, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_1

    .line 428
    :cond_2
    if-nez v2, :cond_3

    .line 429
    invoke-virtual {v4, p1, p2}, Lcom/fasterxml/jackson/databind/JsonDeserializer;->deserialize(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;)Ljava/lang/Object;

    move-result-object v3

    .local v3, "value":Ljava/lang/Object;
    goto :goto_2

    .line 431
    .end local v3    # "value":Ljava/lang/Object;
    :cond_3
    invoke-virtual {v4, p1, p2, v2}, Lcom/fasterxml/jackson/databind/JsonDeserializer;->deserializeWithType(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;)Ljava/lang/Object;

    move-result-object v3

    .restart local v3    # "value":Ljava/lang/Object;
    goto :goto_2

    .line 435
    .end local v0    # "fieldName":Ljava/lang/String;
    .end local v3    # "value":Ljava/lang/Object;
    :cond_4
    return-void
.end method

.method public createContextual(Lcom/fasterxml/jackson/databind/DeserializationContext;Lcom/fasterxml/jackson/databind/BeanProperty;)Lcom/fasterxml/jackson/databind/JsonDeserializer;
    .locals 11
    .param p1, "ctxt"    # Lcom/fasterxml/jackson/databind/DeserializationContext;
    .param p2, "property"    # Lcom/fasterxml/jackson/databind/BeanProperty;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/fasterxml/jackson/databind/DeserializationContext;",
            "Lcom/fasterxml/jackson/databind/BeanProperty;",
            ")",
            "Lcom/fasterxml/jackson/databind/JsonDeserializer",
            "<*>;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/fasterxml/jackson/databind/JsonMappingException;
        }
    .end annotation

    .prologue
    .line 228
    iget-object v4, p0, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_keyDeserializer:Lcom/fasterxml/jackson/databind/KeyDeserializer;

    .line 229
    .local v4, "kd":Lcom/fasterxml/jackson/databind/KeyDeserializer;
    if-nez v4, :cond_3

    .line 230
    iget-object v10, p0, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_mapType:Lcom/fasterxml/jackson/databind/JavaType;

    invoke-virtual {v10}, Lcom/fasterxml/jackson/databind/JavaType;->getKeyType()Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v10

    invoke-virtual {p1, v10, p2}, Lcom/fasterxml/jackson/databind/DeserializationContext;->findKeyDeserializer(Lcom/fasterxml/jackson/databind/JavaType;Lcom/fasterxml/jackson/databind/BeanProperty;)Lcom/fasterxml/jackson/databind/KeyDeserializer;

    move-result-object v4

    .line 236
    :cond_0
    :goto_0
    iget-object v8, p0, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_valueDeserializer:Lcom/fasterxml/jackson/databind/JsonDeserializer;

    .line 237
    .local v8, "vd":Lcom/fasterxml/jackson/databind/JsonDeserializer;, "Lcom/fasterxml/jackson/databind/JsonDeserializer<*>;"
    if-nez v8, :cond_4

    .line 238
    iget-object v10, p0, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_mapType:Lcom/fasterxml/jackson/databind/JavaType;

    invoke-virtual {v10}, Lcom/fasterxml/jackson/databind/JavaType;->getContentType()Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v10

    invoke-virtual {p1, v10, p2}, Lcom/fasterxml/jackson/databind/DeserializationContext;->findContextualValueDeserializer(Lcom/fasterxml/jackson/databind/JavaType;Lcom/fasterxml/jackson/databind/BeanProperty;)Lcom/fasterxml/jackson/databind/JsonDeserializer;

    move-result-object v8

    .line 244
    :cond_1
    :goto_1
    iget-object v9, p0, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_valueTypeDeserializer:Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;

    .line 245
    .local v9, "vtd":Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;
    if-eqz v9, :cond_2

    .line 246
    invoke-virtual {v9, p2}, Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;->forProperty(Lcom/fasterxml/jackson/databind/BeanProperty;)Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;

    move-result-object v9

    .line 248
    :cond_2
    iget-object v2, p0, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_ignorableProperties:Ljava/util/HashSet;

    .line 249
    .local v2, "ignored":Ljava/util/HashSet;, "Ljava/util/HashSet<Ljava/lang/String;>;"
    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/DeserializationContext;->getAnnotationIntrospector()Lcom/fasterxml/jackson/databind/AnnotationIntrospector;

    move-result-object v3

    .line 250
    .local v3, "intr":Lcom/fasterxml/jackson/databind/AnnotationIntrospector;
    if-eqz v3, :cond_6

    if-eqz p2, :cond_6

    .line 251
    invoke-interface {p2}, Lcom/fasterxml/jackson/databind/BeanProperty;->getMember()Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;

    move-result-object v10

    invoke-virtual {v3, v10}, Lcom/fasterxml/jackson/databind/AnnotationIntrospector;->findPropertiesToIgnore(Lcom/fasterxml/jackson/databind/introspect/Annotated;)[Ljava/lang/String;

    move-result-object v6

    .line 252
    .local v6, "moreToIgnore":[Ljava/lang/String;
    if-eqz v6, :cond_6

    .line 253
    if-nez v2, :cond_5

    new-instance v2, Ljava/util/HashSet;

    .end local v2    # "ignored":Ljava/util/HashSet;, "Ljava/util/HashSet<Ljava/lang/String;>;"
    invoke-direct {v2}, Ljava/util/HashSet;-><init>()V

    .line 254
    .restart local v2    # "ignored":Ljava/util/HashSet;, "Ljava/util/HashSet<Ljava/lang/String;>;"
    :goto_2
    move-object v0, v6

    .local v0, "arr$":[Ljava/lang/String;
    array-length v5, v0

    .local v5, "len$":I
    const/4 v1, 0x0

    .local v1, "i$":I
    :goto_3
    if-ge v1, v5, :cond_6

    aget-object v7, v0, v1

    .line 255
    .local v7, "str":Ljava/lang/String;
    invoke-virtual {v2, v7}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    .line 254
    add-int/lit8 v1, v1, 0x1

    goto :goto_3

    .line 232
    .end local v0    # "arr$":[Ljava/lang/String;
    .end local v1    # "i$":I
    .end local v2    # "ignored":Ljava/util/HashSet;, "Ljava/util/HashSet<Ljava/lang/String;>;"
    .end local v3    # "intr":Lcom/fasterxml/jackson/databind/AnnotationIntrospector;
    .end local v5    # "len$":I
    .end local v6    # "moreToIgnore":[Ljava/lang/String;
    .end local v7    # "str":Ljava/lang/String;
    .end local v8    # "vd":Lcom/fasterxml/jackson/databind/JsonDeserializer;, "Lcom/fasterxml/jackson/databind/JsonDeserializer<*>;"
    .end local v9    # "vtd":Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;
    :cond_3
    instance-of v10, v4, Lcom/fasterxml/jackson/databind/deser/ContextualKeyDeserializer;

    if-eqz v10, :cond_0

    .line 233
    check-cast v4, Lcom/fasterxml/jackson/databind/deser/ContextualKeyDeserializer;

    .end local v4    # "kd":Lcom/fasterxml/jackson/databind/KeyDeserializer;
    invoke-interface {v4, p1, p2}, Lcom/fasterxml/jackson/databind/deser/ContextualKeyDeserializer;->createContextual(Lcom/fasterxml/jackson/databind/DeserializationContext;Lcom/fasterxml/jackson/databind/BeanProperty;)Lcom/fasterxml/jackson/databind/KeyDeserializer;

    move-result-object v4

    .restart local v4    # "kd":Lcom/fasterxml/jackson/databind/KeyDeserializer;
    goto :goto_0

    .line 240
    .restart local v8    # "vd":Lcom/fasterxml/jackson/databind/JsonDeserializer;, "Lcom/fasterxml/jackson/databind/JsonDeserializer<*>;"
    :cond_4
    instance-of v10, v8, Lcom/fasterxml/jackson/databind/deser/ContextualDeserializer;

    if-eqz v10, :cond_1

    .line 241
    check-cast v8, Lcom/fasterxml/jackson/databind/deser/ContextualDeserializer;

    .end local v8    # "vd":Lcom/fasterxml/jackson/databind/JsonDeserializer;, "Lcom/fasterxml/jackson/databind/JsonDeserializer<*>;"
    invoke-interface {v8, p1, p2}, Lcom/fasterxml/jackson/databind/deser/ContextualDeserializer;->createContextual(Lcom/fasterxml/jackson/databind/DeserializationContext;Lcom/fasterxml/jackson/databind/BeanProperty;)Lcom/fasterxml/jackson/databind/JsonDeserializer;

    move-result-object v8

    .restart local v8    # "vd":Lcom/fasterxml/jackson/databind/JsonDeserializer;, "Lcom/fasterxml/jackson/databind/JsonDeserializer<*>;"
    goto :goto_1

    .line 253
    .restart local v2    # "ignored":Ljava/util/HashSet;, "Ljava/util/HashSet<Ljava/lang/String;>;"
    .restart local v3    # "intr":Lcom/fasterxml/jackson/databind/AnnotationIntrospector;
    .restart local v6    # "moreToIgnore":[Ljava/lang/String;
    .restart local v9    # "vtd":Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;
    :cond_5
    new-instance v10, Ljava/util/HashSet;

    invoke-direct {v10, v2}, Ljava/util/HashSet;-><init>(Ljava/util/Collection;)V

    move-object v2, v10

    goto :goto_2

    .line 259
    .end local v6    # "moreToIgnore":[Ljava/lang/String;
    :cond_6
    invoke-virtual {p0, v4, v9, v8, v2}, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->withResolved(Lcom/fasterxml/jackson/databind/KeyDeserializer;Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;Lcom/fasterxml/jackson/databind/JsonDeserializer;Ljava/util/HashSet;)Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;

    move-result-object v10

    return-object v10
.end method

.method public bridge synthetic deserialize(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # Lcom/fasterxml/jackson/core/JsonParser;
    .param p2, "x1"    # Lcom/fasterxml/jackson/databind/DeserializationContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonProcessingException;
        }
    .end annotation

    .prologue
    .line 26
    invoke-virtual {p0, p1, p2}, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->deserialize(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;)Ljava/util/Map;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic deserialize(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # Lcom/fasterxml/jackson/core/JsonParser;
    .param p2, "x1"    # Lcom/fasterxml/jackson/databind/DeserializationContext;
    .param p3, "x2"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonProcessingException;
        }
    .end annotation

    .prologue
    .line 26
    check-cast p3, Ljava/util/Map;

    .end local p3    # "x2":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2, p3}, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->deserialize(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;Ljava/util/Map;)Ljava/util/Map;

    move-result-object v0

    return-object v0
.end method

.method public deserialize(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;)Ljava/util/Map;
    .locals 4
    .param p1, "jp"    # Lcom/fasterxml/jackson/core/JsonParser;
    .param p2, "ctxt"    # Lcom/fasterxml/jackson/databind/DeserializationContext;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/fasterxml/jackson/core/JsonParser;",
            "Lcom/fasterxml/jackson/databind/DeserializationContext;",
            ")",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Object;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonProcessingException;
        }
    .end annotation

    .prologue
    .line 289
    iget-object v2, p0, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_propertyBasedCreator:Lcom/fasterxml/jackson/databind/deser/impl/PropertyBasedCreator;

    if-eqz v2, :cond_0

    .line 290
    invoke-virtual {p0, p1, p2}, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_deserializeUsingCreator(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;)Ljava/util/Map;

    move-result-object v2

    .line 314
    :goto_0
    return-object v2

    .line 292
    :cond_0
    iget-object v2, p0, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_delegateDeserializer:Lcom/fasterxml/jackson/databind/JsonDeserializer;

    if-eqz v2, :cond_1

    .line 293
    iget-object v2, p0, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_valueInstantiator:Lcom/fasterxml/jackson/databind/deser/ValueInstantiator;

    iget-object v3, p0, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_delegateDeserializer:Lcom/fasterxml/jackson/databind/JsonDeserializer;

    invoke-virtual {v3, p1, p2}, Lcom/fasterxml/jackson/databind/JsonDeserializer;->deserialize(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;)Ljava/lang/Object;

    move-result-object v3

    invoke-virtual {v2, p2, v3}, Lcom/fasterxml/jackson/databind/deser/ValueInstantiator;->createUsingDelegate(Lcom/fasterxml/jackson/databind/DeserializationContext;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/Map;

    goto :goto_0

    .line 296
    :cond_1
    iget-boolean v2, p0, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_hasDefaultCreator:Z

    if-nez v2, :cond_2

    .line 297
    invoke-virtual {p0}, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->getMapClass()Ljava/lang/Class;

    move-result-object v2

    const-string v3, "No default constructor found"

    invoke-virtual {p2, v2, v3}, Lcom/fasterxml/jackson/databind/DeserializationContext;->instantiationException(Ljava/lang/Class;Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonMappingException;

    move-result-object v2

    throw v2

    .line 300
    :cond_2
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v1

    .line 301
    .local v1, "t":Lcom/fasterxml/jackson/core/JsonToken;
    sget-object v2, Lcom/fasterxml/jackson/core/JsonToken;->START_OBJECT:Lcom/fasterxml/jackson/core/JsonToken;

    if-eq v1, v2, :cond_4

    sget-object v2, Lcom/fasterxml/jackson/core/JsonToken;->FIELD_NAME:Lcom/fasterxml/jackson/core/JsonToken;

    if-eq v1, v2, :cond_4

    sget-object v2, Lcom/fasterxml/jackson/core/JsonToken;->END_OBJECT:Lcom/fasterxml/jackson/core/JsonToken;

    if-eq v1, v2, :cond_4

    .line 303
    sget-object v2, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_STRING:Lcom/fasterxml/jackson/core/JsonToken;

    if-ne v1, v2, :cond_3

    .line 304
    iget-object v2, p0, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_valueInstantiator:Lcom/fasterxml/jackson/databind/deser/ValueInstantiator;

    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, p2, v3}, Lcom/fasterxml/jackson/databind/deser/ValueInstantiator;->createFromString(Lcom/fasterxml/jackson/databind/DeserializationContext;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/Map;

    goto :goto_0

    .line 306
    :cond_3
    invoke-virtual {p0}, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->getMapClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {p2, v2}, Lcom/fasterxml/jackson/databind/DeserializationContext;->mappingException(Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/JsonMappingException;

    move-result-object v2

    throw v2

    .line 308
    :cond_4
    iget-object v2, p0, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_valueInstantiator:Lcom/fasterxml/jackson/databind/deser/ValueInstantiator;

    invoke-virtual {v2, p2}, Lcom/fasterxml/jackson/databind/deser/ValueInstantiator;->createUsingDefault(Lcom/fasterxml/jackson/databind/DeserializationContext;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map;

    .line 309
    .local v0, "result":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/Object;Ljava/lang/Object;>;"
    iget-boolean v2, p0, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_standardStringKey:Z

    if-eqz v2, :cond_5

    .line 310
    invoke-virtual {p0, p1, p2, v0}, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_readAndBindStringMap(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;Ljava/util/Map;)V

    move-object v2, v0

    .line 311
    goto :goto_0

    .line 313
    :cond_5
    invoke-virtual {p0, p1, p2, v0}, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_readAndBind(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;Ljava/util/Map;)V

    move-object v2, v0

    .line 314
    goto :goto_0
.end method

.method public deserialize(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;Ljava/util/Map;)Ljava/util/Map;
    .locals 2
    .param p1, "jp"    # Lcom/fasterxml/jackson/core/JsonParser;
    .param p2, "ctxt"    # Lcom/fasterxml/jackson/databind/DeserializationContext;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/fasterxml/jackson/core/JsonParser;",
            "Lcom/fasterxml/jackson/databind/DeserializationContext;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Object;",
            "Ljava/lang/Object;",
            ">;)",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Object;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonProcessingException;
        }
    .end annotation

    .prologue
    .line 323
    .local p3, "result":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/Object;Ljava/lang/Object;>;"
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v0

    .line 324
    .local v0, "t":Lcom/fasterxml/jackson/core/JsonToken;
    sget-object v1, Lcom/fasterxml/jackson/core/JsonToken;->START_OBJECT:Lcom/fasterxml/jackson/core/JsonToken;

    if-eq v0, v1, :cond_0

    sget-object v1, Lcom/fasterxml/jackson/core/JsonToken;->FIELD_NAME:Lcom/fasterxml/jackson/core/JsonToken;

    if-eq v0, v1, :cond_0

    .line 325
    invoke-virtual {p0}, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->getMapClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {p2, v1}, Lcom/fasterxml/jackson/databind/DeserializationContext;->mappingException(Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/JsonMappingException;

    move-result-object v1

    throw v1

    .line 327
    :cond_0
    iget-boolean v1, p0, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_standardStringKey:Z

    if-eqz v1, :cond_1

    .line 328
    invoke-virtual {p0, p1, p2, p3}, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_readAndBindStringMap(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;Ljava/util/Map;)V

    .line 332
    :goto_0
    return-object p3

    .line 331
    :cond_1
    invoke-virtual {p0, p1, p2, p3}, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_readAndBind(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;Ljava/util/Map;)V

    goto :goto_0
.end method

.method public deserializeWithType(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;)Ljava/lang/Object;
    .locals 1
    .param p1, "jp"    # Lcom/fasterxml/jackson/core/JsonParser;
    .param p2, "ctxt"    # Lcom/fasterxml/jackson/databind/DeserializationContext;
    .param p3, "typeDeserializer"    # Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonProcessingException;
        }
    .end annotation

    .prologue
    .line 341
    invoke-virtual {p3, p1, p2}, Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;->deserializeTypedFromObject(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public getContentDeserializer()Lcom/fasterxml/jackson/databind/JsonDeserializer;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/fasterxml/jackson/databind/JsonDeserializer",
            "<",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation

    .prologue
    .line 275
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_valueDeserializer:Lcom/fasterxml/jackson/databind/JsonDeserializer;

    return-object v0
.end method

.method public getContentType()Lcom/fasterxml/jackson/databind/JavaType;
    .locals 1

    .prologue
    .line 270
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_mapType:Lcom/fasterxml/jackson/databind/JavaType;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/databind/JavaType;->getContentType()Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v0

    return-object v0
.end method

.method public final getMapClass()Ljava/lang/Class;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/lang/Class",
            "<*>;"
        }
    .end annotation

    .prologue
    .line 351
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_mapType:Lcom/fasterxml/jackson/databind/JavaType;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/databind/JavaType;->getRawClass()Ljava/lang/Class;

    move-result-object v0

    return-object v0
.end method

.method public getValueType()Lcom/fasterxml/jackson/databind/JavaType;
    .locals 1

    .prologue
    .line 353
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_mapType:Lcom/fasterxml/jackson/databind/JavaType;

    return-object v0
.end method

.method public resolve(Lcom/fasterxml/jackson/databind/DeserializationContext;)V
    .locals 5
    .param p1, "ctxt"    # Lcom/fasterxml/jackson/databind/DeserializationContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/fasterxml/jackson/databind/JsonMappingException;
        }
    .end annotation

    .prologue
    .line 200
    iget-object v2, p0, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_valueInstantiator:Lcom/fasterxml/jackson/databind/deser/ValueInstantiator;

    invoke-virtual {v2}, Lcom/fasterxml/jackson/databind/deser/ValueInstantiator;->canCreateUsingDelegate()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 201
    iget-object v2, p0, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_valueInstantiator:Lcom/fasterxml/jackson/databind/deser/ValueInstantiator;

    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/DeserializationContext;->getConfig()Lcom/fasterxml/jackson/databind/DeserializationConfig;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/fasterxml/jackson/databind/deser/ValueInstantiator;->getDelegateType(Lcom/fasterxml/jackson/databind/DeserializationConfig;)Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v1

    .line 202
    .local v1, "delegateType":Lcom/fasterxml/jackson/databind/JavaType;
    if-nez v1, :cond_0

    .line 203
    new-instance v2, Ljava/lang/IllegalArgumentException;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Invalid delegate-creator definition for "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_mapType:Lcom/fasterxml/jackson/databind/JavaType;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ": value instantiator ("

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_valueInstantiator:Lcom/fasterxml/jackson/databind/deser/ValueInstantiator;

    invoke-virtual {v4}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ") returned true for \'canCreateUsingDelegate()\', but null for \'getDelegateType()\'"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 211
    :cond_0
    const/4 v2, 0x0

    invoke-virtual {p0, p1, v1, v2}, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->findDeserializer(Lcom/fasterxml/jackson/databind/DeserializationContext;Lcom/fasterxml/jackson/databind/JavaType;Lcom/fasterxml/jackson/databind/BeanProperty;)Lcom/fasterxml/jackson/databind/JsonDeserializer;

    move-result-object v2

    iput-object v2, p0, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_delegateDeserializer:Lcom/fasterxml/jackson/databind/JsonDeserializer;

    .line 213
    .end local v1    # "delegateType":Lcom/fasterxml/jackson/databind/JavaType;
    :cond_1
    iget-object v2, p0, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_valueInstantiator:Lcom/fasterxml/jackson/databind/deser/ValueInstantiator;

    invoke-virtual {v2}, Lcom/fasterxml/jackson/databind/deser/ValueInstantiator;->canCreateFromObjectWith()Z

    move-result v2

    if-eqz v2, :cond_2

    .line 214
    iget-object v2, p0, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_valueInstantiator:Lcom/fasterxml/jackson/databind/deser/ValueInstantiator;

    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/DeserializationContext;->getConfig()Lcom/fasterxml/jackson/databind/DeserializationConfig;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/fasterxml/jackson/databind/deser/ValueInstantiator;->getFromObjectArguments(Lcom/fasterxml/jackson/databind/DeserializationConfig;)[Lcom/fasterxml/jackson/databind/deser/SettableBeanProperty;

    move-result-object v0

    .line 215
    .local v0, "creatorProps":[Lcom/fasterxml/jackson/databind/deser/SettableBeanProperty;
    iget-object v2, p0, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_valueInstantiator:Lcom/fasterxml/jackson/databind/deser/ValueInstantiator;

    invoke-static {p1, v2, v0}, Lcom/fasterxml/jackson/databind/deser/impl/PropertyBasedCreator;->construct(Lcom/fasterxml/jackson/databind/DeserializationContext;Lcom/fasterxml/jackson/databind/deser/ValueInstantiator;[Lcom/fasterxml/jackson/databind/deser/SettableBeanProperty;)Lcom/fasterxml/jackson/databind/deser/impl/PropertyBasedCreator;

    move-result-object v2

    iput-object v2, p0, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_propertyBasedCreator:Lcom/fasterxml/jackson/databind/deser/impl/PropertyBasedCreator;

    .line 217
    .end local v0    # "creatorProps":[Lcom/fasterxml/jackson/databind/deser/SettableBeanProperty;
    :cond_2
    iget-object v2, p0, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_mapType:Lcom/fasterxml/jackson/databind/JavaType;

    iget-object v3, p0, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_keyDeserializer:Lcom/fasterxml/jackson/databind/KeyDeserializer;

    invoke-virtual {p0, v2, v3}, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_isStdKeyDeser(Lcom/fasterxml/jackson/databind/JavaType;Lcom/fasterxml/jackson/databind/KeyDeserializer;)Z

    move-result v2

    iput-boolean v2, p0, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_standardStringKey:Z

    .line 218
    return-void
.end method

.method public setIgnorableProperties([Ljava/lang/String;)V
    .locals 1
    .param p1, "ignorable"    # [Ljava/lang/String;

    .prologue
    .line 186
    if-eqz p1, :cond_0

    array-length v0, p1

    if-nez v0, :cond_1

    :cond_0
    const/4 v0, 0x0

    :goto_0
    iput-object v0, p0, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_ignorableProperties:Ljava/util/HashSet;

    .line 188
    return-void

    .line 186
    :cond_1
    invoke-static {p1}, Lcom/fasterxml/jackson/databind/util/ArrayBuilders;->arrayToSet([Ljava/lang/Object;)Ljava/util/HashSet;

    move-result-object v0

    goto :goto_0
.end method

.method protected withResolved(Lcom/fasterxml/jackson/databind/KeyDeserializer;Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;Lcom/fasterxml/jackson/databind/JsonDeserializer;Ljava/util/HashSet;)Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;
    .locals 6
    .param p1, "keyDeser"    # Lcom/fasterxml/jackson/databind/KeyDeserializer;
    .param p2, "valueTypeDeser"    # Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/fasterxml/jackson/databind/KeyDeserializer;",
            "Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;",
            "Lcom/fasterxml/jackson/databind/JsonDeserializer",
            "<*>;",
            "Ljava/util/HashSet",
            "<",
            "Ljava/lang/String;",
            ">;)",
            "Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;"
        }
    .end annotation

    .prologue
    .line 158
    .local p3, "valueDeser":Lcom/fasterxml/jackson/databind/JsonDeserializer;, "Lcom/fasterxml/jackson/databind/JsonDeserializer<*>;"
    .local p4, "ignorable":Ljava/util/HashSet;, "Ljava/util/HashSet<Ljava/lang/String;>;"
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_keyDeserializer:Lcom/fasterxml/jackson/databind/KeyDeserializer;

    if-ne v0, p1, :cond_0

    iget-object v0, p0, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_valueDeserializer:Lcom/fasterxml/jackson/databind/JsonDeserializer;

    if-ne v0, p3, :cond_0

    iget-object v0, p0, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_valueTypeDeserializer:Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;

    if-ne v0, p2, :cond_0

    iget-object v0, p0, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;->_ignorableProperties:Ljava/util/HashSet;

    if-ne v0, p4, :cond_0

    .line 162
    .end local p0    # "this":Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;
    :goto_0
    return-object p0

    .restart local p0    # "this":Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;
    :cond_0
    new-instance v0, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;

    move-object v1, p0

    move-object v2, p1

    move-object v3, p3

    move-object v4, p2

    move-object v5, p4

    invoke-direct/range {v0 .. v5}, Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;-><init>(Lcom/fasterxml/jackson/databind/deser/std/MapDeserializer;Lcom/fasterxml/jackson/databind/KeyDeserializer;Lcom/fasterxml/jackson/databind/JsonDeserializer;Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;Ljava/util/HashSet;)V

    move-object p0, v0

    goto :goto_0
.end method

.method protected wrapAndThrow(Ljava/lang/Throwable;Ljava/lang/Object;)V
    .locals 1
    .param p1, "t"    # Ljava/lang/Throwable;
    .param p2, "ref"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 505
    :goto_0
    instance-of v0, p1, Ljava/lang/reflect/InvocationTargetException;

    if-eqz v0, :cond_0

    invoke-virtual {p1}, Ljava/lang/Throwable;->getCause()Ljava/lang/Throwable;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 506
    invoke-virtual {p1}, Ljava/lang/Throwable;->getCause()Ljava/lang/Throwable;

    move-result-object p1

    goto :goto_0

    .line 509
    :cond_0
    instance-of v0, p1, Ljava/lang/Error;

    if-eqz v0, :cond_1

    .line 510
    check-cast p1, Ljava/lang/Error;

    .end local p1    # "t":Ljava/lang/Throwable;
    throw p1

    .line 513
    .restart local p1    # "t":Ljava/lang/Throwable;
    :cond_1
    instance-of v0, p1, Ljava/io/IOException;

    if-eqz v0, :cond_2

    instance-of v0, p1, Lcom/fasterxml/jackson/databind/JsonMappingException;

    if-nez v0, :cond_2

    .line 514
    check-cast p1, Ljava/io/IOException;

    .end local p1    # "t":Ljava/lang/Throwable;
    throw p1

    .line 516
    .restart local p1    # "t":Ljava/lang/Throwable;
    :cond_2
    const/4 v0, 0x0

    invoke-static {p1, p2, v0}, Lcom/fasterxml/jackson/databind/JsonMappingException;->wrapWithPath(Ljava/lang/Throwable;Ljava/lang/Object;Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonMappingException;

    move-result-object v0

    throw v0
.end method
