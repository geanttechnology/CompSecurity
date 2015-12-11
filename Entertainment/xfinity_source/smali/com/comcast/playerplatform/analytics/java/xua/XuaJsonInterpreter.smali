.class public Lcom/comcast/playerplatform/analytics/java/xua/XuaJsonInterpreter;
.super Ljava/lang/Object;
.source "XuaJsonInterpreter.java"

# interfaces
.implements Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo$JsonInterpreter;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/comcast/playerplatform/analytics/java/xua/XuaJsonInterpreter$XuaBaseEventDeserializer;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo$JsonInterpreter",
        "<",
        "Lcom/comcast/playerplatform/analytics/java/xua/XuaMessage;",
        ">;"
    }
.end annotation


# instance fields
.field private final mapper:Lcom/fasterxml/jackson/databind/ObjectMapper;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 67
    new-instance v0, Lcom/fasterxml/jackson/databind/ObjectMapper;

    invoke-direct {v0}, Lcom/fasterxml/jackson/databind/ObjectMapper;-><init>()V

    invoke-direct {p0, v0}, Lcom/comcast/playerplatform/analytics/java/xua/XuaJsonInterpreter;-><init>(Lcom/fasterxml/jackson/databind/ObjectMapper;)V

    .line 68
    return-void
.end method

.method public constructor <init>(Lcom/fasterxml/jackson/databind/ObjectMapper;)V
    .locals 1
    .param p1, "mapper"    # Lcom/fasterxml/jackson/databind/ObjectMapper;

    .prologue
    .line 70
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 71
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaJsonInterpreter;->mapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    .line 72
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaJsonInterpreter;->mapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    invoke-direct {p0, v0}, Lcom/comcast/playerplatform/analytics/java/xua/XuaJsonInterpreter;->setupXuaBaseDeserializer(Lcom/fasterxml/jackson/databind/ObjectMapper;)V

    .line 73
    return-void
.end method

.method private setupXuaBaseDeserializer(Lcom/fasterxml/jackson/databind/ObjectMapper;)V
    .locals 10
    .param p1, "mapper"    # Lcom/fasterxml/jackson/databind/ObjectMapper;

    .prologue
    .line 78
    new-instance v8, Lcom/comcast/playerplatform/analytics/java/xua/XuaJsonInterpreter$1;

    invoke-direct {v8, p0}, Lcom/comcast/playerplatform/analytics/java/xua/XuaJsonInterpreter$1;-><init>(Lcom/comcast/playerplatform/analytics/java/xua/XuaJsonInterpreter;)V

    .line 84
    .local v8, "xuaBaseEventDeserializer":Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;, "Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer<Lcom/comcast/playerplatform/analytics/java/xua/XuaBaseEvent;>;"
    new-instance v7, Lcom/fasterxml/jackson/databind/module/SimpleModule;

    const-string v9, "SimpleModule"

    new-instance v0, Lcom/fasterxml/jackson/core/Version;

    const/4 v1, 0x0

    const/4 v2, 0x3

    const/4 v3, 0x1

    const-string v4, "0.3.001"

    const-string v5, "com.comcast.playerplatform"

    const-string v6, "java_analytics"

    invoke-direct/range {v0 .. v6}, Lcom/fasterxml/jackson/core/Version;-><init>(IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    invoke-direct {v7, v9, v0}, Lcom/fasterxml/jackson/databind/module/SimpleModule;-><init>(Ljava/lang/String;Lcom/fasterxml/jackson/core/Version;)V

    .line 86
    .local v7, "module":Lcom/fasterxml/jackson/databind/module/SimpleModule;
    const-class v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaBaseEvent;

    invoke-virtual {v7, v0, v8}, Lcom/fasterxml/jackson/databind/module/SimpleModule;->addDeserializer(Ljava/lang/Class;Lcom/fasterxml/jackson/databind/JsonDeserializer;)Lcom/fasterxml/jackson/databind/module/SimpleModule;

    .line 87
    invoke-virtual {p1, v7}, Lcom/fasterxml/jackson/databind/ObjectMapper;->registerModule(Lcom/fasterxml/jackson/databind/Module;)Lcom/fasterxml/jackson/databind/ObjectMapper;

    .line 88
    return-void
.end method


# virtual methods
.method public fromJson(Ljava/lang/String;)Lcom/comcast/playerplatform/analytics/java/xua/XuaMessage;
    .locals 2
    .param p1, "json"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 92
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaJsonInterpreter;->mapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    const-class v1, Lcom/comcast/playerplatform/analytics/java/xua/XuaMessage;

    invoke-virtual {v0, p1, v1}, Lcom/fasterxml/jackson/databind/ObjectMapper;->readValue(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaMessage;

    return-object v0
.end method

.method public bridge synthetic fromJson(Ljava/lang/String;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 23
    invoke-virtual {p0, p1}, Lcom/comcast/playerplatform/analytics/java/xua/XuaJsonInterpreter;->fromJson(Ljava/lang/String;)Lcom/comcast/playerplatform/analytics/java/xua/XuaMessage;

    move-result-object v0

    return-object v0
.end method

.method public toJson(Lcom/comcast/playerplatform/analytics/java/xua/XuaMessage;)Ljava/lang/String;
    .locals 1
    .param p1, "item"    # Lcom/comcast/playerplatform/analytics/java/xua/XuaMessage;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 97
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaJsonInterpreter;->mapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    invoke-virtual {v0, p1}, Lcom/fasterxml/jackson/databind/ObjectMapper;->writeValueAsString(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic toJson(Ljava/lang/Object;)Ljava/lang/String;
    .locals 1
    .param p1, "x0"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 23
    check-cast p1, Lcom/comcast/playerplatform/analytics/java/xua/XuaMessage;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/comcast/playerplatform/analytics/java/xua/XuaJsonInterpreter;->toJson(Lcom/comcast/playerplatform/analytics/java/xua/XuaMessage;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
