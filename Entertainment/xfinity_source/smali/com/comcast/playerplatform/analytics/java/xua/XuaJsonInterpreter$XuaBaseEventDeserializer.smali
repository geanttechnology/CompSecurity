.class Lcom/comcast/playerplatform/analytics/java/xua/XuaJsonInterpreter$XuaBaseEventDeserializer;
.super Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;
.source "XuaJsonInterpreter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/playerplatform/analytics/java/xua/XuaJsonInterpreter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "XuaBaseEventDeserializer"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer",
        "<",
        "Lcom/comcast/playerplatform/analytics/java/xua/XuaBaseEvent;",
        ">;"
    }
.end annotation


# instance fields
.field private registry:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Class",
            "<+",
            "Lcom/comcast/playerplatform/analytics/java/xua/XuaBaseEvent;",
            ">;>;"
        }
    .end annotation
.end field


# direct methods
.method constructor <init>()V
    .locals 1

    .prologue
    .line 40
    const-class v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaBaseEvent;

    invoke-direct {p0, v0}, Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;-><init>(Ljava/lang/Class;)V

    .line 37
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaJsonInterpreter$XuaBaseEventDeserializer;->registry:Ljava/util/Map;

    .line 41
    return-void
.end method


# virtual methods
.method public deserialize(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;)Lcom/comcast/playerplatform/analytics/java/xua/XuaBaseEvent;
    .locals 7
    .param p1, "jsonParser"    # Lcom/fasterxml/jackson/core/JsonParser;
    .param p2, "deserializationContext"    # Lcom/fasterxml/jackson/databind/DeserializationContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonProcessingException;
        }
    .end annotation

    .prologue
    .line 49
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getCodec()Lcom/fasterxml/jackson/core/ObjectCodec;

    move-result-object v2

    check-cast v2, Lcom/fasterxml/jackson/databind/ObjectMapper;

    .line 50
    .local v2, "mapper":Lcom/fasterxml/jackson/databind/ObjectMapper;
    invoke-virtual {v2, p1}, Lcom/fasterxml/jackson/databind/ObjectMapper;->readTree(Lcom/fasterxml/jackson/core/JsonParser;)Lcom/fasterxml/jackson/core/TreeNode;

    move-result-object v4

    check-cast v4, Lcom/fasterxml/jackson/databind/node/ObjectNode;

    .line 51
    .local v4, "root":Lcom/fasterxml/jackson/databind/node/ObjectNode;
    const/4 v5, 0x0

    .line 53
    .local v5, "xuaClass":Ljava/lang/Class;, "Ljava/lang/Class<+Lcom/comcast/playerplatform/analytics/java/xua/XuaBaseEvent;>;"
    invoke-virtual {v4}, Lcom/fasterxml/jackson/databind/node/ObjectNode;->fields()Ljava/util/Iterator;

    move-result-object v1

    .line 54
    .local v1, "iterator":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/util/Map$Entry<Ljava/lang/String;Lcom/fasterxml/jackson/databind/JsonNode;>;>;"
    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_1

    .line 55
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 56
    .local v0, "element":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Lcom/fasterxml/jackson/databind/JsonNode;>;"
    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 57
    .local v3, "name":Ljava/lang/String;
    iget-object v6, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaJsonInterpreter$XuaBaseEventDeserializer;->registry:Ljava/util/Map;

    invoke-interface {v6, v3}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_0

    .line 58
    iget-object v6, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaJsonInterpreter$XuaBaseEventDeserializer;->registry:Ljava/util/Map;

    invoke-interface {v6, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    .end local v5    # "xuaClass":Ljava/lang/Class;, "Ljava/lang/Class<+Lcom/comcast/playerplatform/analytics/java/xua/XuaBaseEvent;>;"
    check-cast v5, Ljava/lang/Class;

    .line 62
    .end local v0    # "element":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Lcom/fasterxml/jackson/databind/JsonNode;>;"
    .end local v3    # "name":Ljava/lang/String;
    .restart local v5    # "xuaClass":Ljava/lang/Class;, "Ljava/lang/Class<+Lcom/comcast/playerplatform/analytics/java/xua/XuaBaseEvent;>;"
    :cond_1
    if-nez v5, :cond_2

    const/4 v6, 0x0

    :goto_0
    return-object v6

    :cond_2
    invoke-virtual {v2, p1, v5}, Lcom/fasterxml/jackson/databind/ObjectMapper;->readValue(Lcom/fasterxml/jackson/core/JsonParser;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lcom/comcast/playerplatform/analytics/java/xua/XuaBaseEvent;

    goto :goto_0
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
    .line 35
    invoke-virtual {p0, p1, p2}, Lcom/comcast/playerplatform/analytics/java/xua/XuaJsonInterpreter$XuaBaseEventDeserializer;->deserialize(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;)Lcom/comcast/playerplatform/analytics/java/xua/XuaBaseEvent;

    move-result-object v0

    return-object v0
.end method

.method registerXuaBaseEvent(Ljava/lang/String;Ljava/lang/Class;)V
    .locals 1
    .param p1, "uid"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/Class",
            "<+",
            "Lcom/comcast/playerplatform/analytics/java/xua/XuaBaseEvent;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 44
    .local p2, "xuaClass":Ljava/lang/Class;, "Ljava/lang/Class<+Lcom/comcast/playerplatform/analytics/java/xua/XuaBaseEvent;>;"
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaJsonInterpreter$XuaBaseEventDeserializer;->registry:Ljava/util/Map;

    invoke-interface {v0, p1, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 45
    return-void
.end method
