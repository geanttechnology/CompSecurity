.class public Lcom/comcast/playerplatform/analytics/java/xmessage/messages/HeartbeatMessage;
.super Lcom/comcast/playerplatform/analytics/java/xmessage/AbstractXMessageBuilder;
.source "HeartbeatMessage.java"


# instance fields
.field private bitrate:Ljava/lang/Long;

.field private cc:Ljava/lang/String;

.field private currentPosition:Ljava/lang/Long;

.field private environment:Lcom/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent$HeartbeatEnvironment;

.field private evtTimestamp:J

.field private fps:Ljava/lang/Integer;

.field private fragment:Lcom/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent$HeartbeatFragment;

.field private sap:Ljava/lang/String;

.field private xuaAsset:Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;


# direct methods
.method public constructor <init>(JLjava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;Lcom/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent$HeartbeatEnvironment;Lcom/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent$HeartbeatFragment;)V
    .locals 1
    .param p1, "evtTimestamp"    # J
    .param p3, "currentPosition"    # Ljava/lang/Long;
    .param p4, "bitrate"    # Ljava/lang/Long;
    .param p5, "fps"    # Ljava/lang/Integer;
    .param p6, "ccTrack"    # Ljava/lang/String;
    .param p7, "sapTrack"    # Ljava/lang/String;
    .param p8, "xuaAsset"    # Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;
    .param p9, "environment"    # Lcom/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent$HeartbeatEnvironment;
    .param p10, "fragment"    # Lcom/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent$HeartbeatFragment;

    .prologue
    .line 45
    invoke-direct {p0}, Lcom/comcast/playerplatform/analytics/java/xmessage/AbstractXMessageBuilder;-><init>()V

    .line 46
    iput-wide p1, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/HeartbeatMessage;->evtTimestamp:J

    .line 47
    iput-object p3, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/HeartbeatMessage;->currentPosition:Ljava/lang/Long;

    .line 48
    iput-object p4, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/HeartbeatMessage;->bitrate:Ljava/lang/Long;

    .line 49
    iput-object p5, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/HeartbeatMessage;->fps:Ljava/lang/Integer;

    .line 50
    iput-object p6, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/HeartbeatMessage;->cc:Ljava/lang/String;

    .line 51
    iput-object p7, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/HeartbeatMessage;->sap:Ljava/lang/String;

    .line 52
    iput-object p8, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/HeartbeatMessage;->xuaAsset:Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    .line 53
    iput-object p9, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/HeartbeatMessage;->environment:Lcom/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent$HeartbeatEnvironment;

    .line 54
    iput-object p10, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/HeartbeatMessage;->fragment:Lcom/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent$HeartbeatFragment;

    .line 55
    return-void
.end method


# virtual methods
.method public buildXuaEvent()V
    .locals 5

    .prologue
    .line 72
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent;

    iget-wide v2, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/HeartbeatMessage;->evtTimestamp:J

    sget-object v1, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->xuaHeartBeat:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->name()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0}, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/HeartbeatMessage;->getMessage()Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;

    move-result-object v4

    invoke-virtual {v4}, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;->getValue()Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;

    move-result-object v4

    invoke-direct {v0, v2, v3, v1, v4}, Lcom/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent;-><init>(JLjava/lang/String;Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;)V

    .line 74
    .local v0, "xuaEvent":Lcom/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent;
    iget-object v1, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/HeartbeatMessage;->xuaAsset:Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent;->setAsset(Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V

    .line 75
    iget-object v1, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/HeartbeatMessage;->environment:Lcom/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent$HeartbeatEnvironment;

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent;->setEnvironment(Lcom/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent$HeartbeatEnvironment;)V

    .line 76
    iget-object v1, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/HeartbeatMessage;->fragment:Lcom/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent$HeartbeatFragment;

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent;->setFragment(Lcom/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent$HeartbeatFragment;)V

    .line 78
    invoke-virtual {p0}, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/HeartbeatMessage;->getMessage()Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;->setEvent(Lcom/comcast/playerplatform/analytics/java/xua/XuaBaseEvent;)V

    .line 79
    return-void
.end method

.method public buildXuaValue()V
    .locals 2

    .prologue
    .line 59
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaHeartbeatValue;

    invoke-direct {v0}, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaHeartbeatValue;-><init>()V

    .line 61
    .local v0, "xuaHeartbeatValue":Lcom/comcast/playerplatform/analytics/java/xua/values/XuaHeartbeatValue;
    iget-object v1, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/HeartbeatMessage;->currentPosition:Ljava/lang/Long;

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaHeartbeatValue;->setCurrentPosition(Ljava/lang/Long;)V

    .line 62
    iget-object v1, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/HeartbeatMessage;->bitrate:Ljava/lang/Long;

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaHeartbeatValue;->setBitRate(Ljava/lang/Long;)V

    .line 63
    iget-object v1, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/HeartbeatMessage;->fps:Ljava/lang/Integer;

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaHeartbeatValue;->setFramesPerSecond(Ljava/lang/Integer;)V

    .line 64
    iget-object v1, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/HeartbeatMessage;->cc:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaHeartbeatValue;->setClosedCaptionTrack(Ljava/lang/String;)V

    .line 65
    iget-object v1, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/HeartbeatMessage;->sap:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaHeartbeatValue;->setSecondaryAudioTrack(Ljava/lang/String;)V

    .line 67
    invoke-virtual {p0}, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/HeartbeatMessage;->getMessage()Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;->setValue(Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;)V

    .line 68
    return-void
.end method
