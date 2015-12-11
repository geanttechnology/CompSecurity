.class public Lcom/comcast/playerplatform/analytics/java/xua/XuaSessionInfo;
.super Ljava/lang/Object;
.source "XuaSessionInfo.java"


# annotations
.annotation runtime Lcom/fasterxml/jackson/annotation/JsonInclude;
    value = .enum Lcom/fasterxml/jackson/annotation/JsonInclude$Include;->NON_NULL:Lcom/fasterxml/jackson/annotation/JsonInclude$Include;
.end annotation


# instance fields
.field private playbackId:Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "PBI"
    .end annotation
.end field

.field private pluginId:Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "PSI"
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 29
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 33
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "pluginSession"    # Ljava/lang/String;

    .prologue
    .line 35
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 36
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaSessionInfo;->pluginId:Ljava/lang/String;

    .line 37
    return-void
.end method


# virtual methods
.method public getPlaybackId()Ljava/lang/String;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 55
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaSessionInfo;->playbackId:Ljava/lang/String;

    return-object v0
.end method

.method public getPluginId()Ljava/lang/String;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 46
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaSessionInfo;->pluginId:Ljava/lang/String;

    return-object v0
.end method

.method public setPlaybackId(Ljava/lang/String;)V
    .locals 0
    .param p1, "playbackId"    # Ljava/lang/String;

    .prologue
    .line 59
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaSessionInfo;->playbackId:Ljava/lang/String;

    .line 60
    return-void
.end method

.method public setPluginId(Ljava/lang/String;)V
    .locals 0
    .param p1, "pluginId"    # Ljava/lang/String;

    .prologue
    .line 50
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaSessionInfo;->pluginId:Ljava/lang/String;

    .line 51
    return-void
.end method
