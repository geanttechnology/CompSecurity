.class public abstract Lcom/comcast/playerplatform/analytics/java/xua/XuaBaseEvent;
.super Ljava/lang/Object;
.source "XuaBaseEvent.java"


# annotations
.annotation runtime Lcom/fasterxml/jackson/annotation/JsonInclude;
    value = .enum Lcom/fasterxml/jackson/annotation/JsonInclude$Include;->NON_NULL:Lcom/fasterxml/jackson/annotation/JsonInclude$Include;
.end annotation


# instance fields
.field private asset:Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "ASSET"
    .end annotation
.end field

.field protected eventName:Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "NAME"
    .end annotation
.end field

.field protected networkInfo:Lcom/comcast/playerplatform/analytics/java/xua/XuaNetworkInfo;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "NET"
    .end annotation
.end field

.field protected timeStamp:J
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "ETS"
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getAsset()Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 48
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaBaseEvent;->asset:Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    return-object v0
.end method

.method public getEventName()Ljava/lang/String;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 70
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaBaseEvent;->eventName:Ljava/lang/String;

    return-object v0
.end method

.method public getNetworkInfo()Lcom/comcast/playerplatform/analytics/java/xua/XuaNetworkInfo;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 38
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaBaseEvent;->networkInfo:Lcom/comcast/playerplatform/analytics/java/xua/XuaNetworkInfo;

    return-object v0
.end method

.method public getTimeStamp()J
    .locals 2
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 59
    iget-wide v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaBaseEvent;->timeStamp:J

    return-wide v0
.end method

.method public setAsset(Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V
    .locals 0
    .param p1, "asset"    # Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    .prologue
    .line 53
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaBaseEvent;->asset:Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    .line 54
    return-void
.end method

.method public setEventName(Ljava/lang/String;)V
    .locals 0
    .param p1, "eventName"    # Ljava/lang/String;

    .prologue
    .line 75
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaBaseEvent;->eventName:Ljava/lang/String;

    .line 76
    return-void
.end method

.method public setNetworkInfo(Lcom/comcast/playerplatform/analytics/java/xua/XuaNetworkInfo;)V
    .locals 0
    .param p1, "networkInfo"    # Lcom/comcast/playerplatform/analytics/java/xua/XuaNetworkInfo;

    .prologue
    .line 42
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaBaseEvent;->networkInfo:Lcom/comcast/playerplatform/analytics/java/xua/XuaNetworkInfo;

    .line 43
    return-void
.end method

.method public setTimeStamp(J)V
    .locals 1
    .param p1, "timeStamp"    # J

    .prologue
    .line 64
    iput-wide p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaBaseEvent;->timeStamp:J

    .line 65
    return-void
.end method
