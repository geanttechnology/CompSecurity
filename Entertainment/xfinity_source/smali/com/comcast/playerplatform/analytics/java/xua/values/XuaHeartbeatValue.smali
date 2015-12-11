.class public Lcom/comcast/playerplatform/analytics/java/xua/values/XuaHeartbeatValue;
.super Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;
.source "XuaHeartbeatValue.java"


# instance fields
.field private bitRate:Ljava/lang/Long;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "XBR"
    .end annotation
.end field

.field private closedCaptionTrack:Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "CC"
    .end annotation
.end field

.field private currentPosition:Ljava/lang/Long;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "POS"
    .end annotation
.end field

.field private framesPerSecond:Ljava/lang/Integer;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "XFS"
    .end annotation
.end field

.field private secondaryAudioTrack:Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "SAP"
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 15
    invoke-direct {p0}, Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;-><init>()V

    return-void
.end method


# virtual methods
.method public getBitRate()Ljava/lang/Long;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 42
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaHeartbeatValue;->bitRate:Ljava/lang/Long;

    return-object v0
.end method

.method public getClosedCaptionTrack()Ljava/lang/String;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 60
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaHeartbeatValue;->closedCaptionTrack:Ljava/lang/String;

    return-object v0
.end method

.method public getCurrentPosition()Ljava/lang/Long;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 33
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaHeartbeatValue;->currentPosition:Ljava/lang/Long;

    return-object v0
.end method

.method public getFramesPerSecond()Ljava/lang/Integer;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 51
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaHeartbeatValue;->framesPerSecond:Ljava/lang/Integer;

    return-object v0
.end method

.method public getSecondaryAudioTrack()Ljava/lang/String;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 69
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaHeartbeatValue;->secondaryAudioTrack:Ljava/lang/String;

    return-object v0
.end method

.method public setBitRate(Ljava/lang/Long;)V
    .locals 0
    .param p1, "bitRate"    # Ljava/lang/Long;

    .prologue
    .line 46
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaHeartbeatValue;->bitRate:Ljava/lang/Long;

    .line 47
    return-void
.end method

.method public setClosedCaptionTrack(Ljava/lang/String;)V
    .locals 0
    .param p1, "closedCaptionTrack"    # Ljava/lang/String;

    .prologue
    .line 64
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaHeartbeatValue;->closedCaptionTrack:Ljava/lang/String;

    .line 65
    return-void
.end method

.method public setCurrentPosition(Ljava/lang/Long;)V
    .locals 0
    .param p1, "position"    # Ljava/lang/Long;

    .prologue
    .line 37
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaHeartbeatValue;->currentPosition:Ljava/lang/Long;

    .line 38
    return-void
.end method

.method public setFramesPerSecond(Ljava/lang/Integer;)V
    .locals 0
    .param p1, "framesPerSecond"    # Ljava/lang/Integer;

    .prologue
    .line 55
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaHeartbeatValue;->framesPerSecond:Ljava/lang/Integer;

    .line 56
    return-void
.end method

.method public setSecondaryAudioTrack(Ljava/lang/String;)V
    .locals 0
    .param p1, "secondaryAudioTrack"    # Ljava/lang/String;

    .prologue
    .line 73
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaHeartbeatValue;->secondaryAudioTrack:Ljava/lang/String;

    .line 74
    return-void
.end method
