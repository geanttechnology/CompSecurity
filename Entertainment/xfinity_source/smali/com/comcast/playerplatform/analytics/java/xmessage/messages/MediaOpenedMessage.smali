.class public Lcom/comcast/playerplatform/analytics/java/xmessage/messages/MediaOpenedMessage;
.super Lcom/comcast/playerplatform/analytics/java/xmessage/AbstractXMessageBuilder;
.source "MediaOpenedMessage.java"


# instance fields
.field private channelOpenningLatency:Ljava/lang/Long;

.field private currentPosition:J

.field private evtTimestamp:J

.field private manifestUrl:Ljava/lang/String;

.field private xuaAsset:Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;


# direct methods
.method public constructor <init>(JLjava/lang/Long;JLjava/lang/String;Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V
    .locals 0
    .param p1, "evtTimestamp"    # J
    .param p3, "channelOpenningLatency"    # Ljava/lang/Long;
    .param p4, "currentPosition"    # J
    .param p6, "manifestUrl"    # Ljava/lang/String;
    .param p7, "xuaAsset"    # Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    .prologue
    .line 29
    invoke-direct {p0}, Lcom/comcast/playerplatform/analytics/java/xmessage/AbstractXMessageBuilder;-><init>()V

    .line 30
    iput-wide p1, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/MediaOpenedMessage;->evtTimestamp:J

    .line 31
    iput-object p3, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/MediaOpenedMessage;->channelOpenningLatency:Ljava/lang/Long;

    .line 32
    iput-wide p4, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/MediaOpenedMessage;->currentPosition:J

    .line 33
    iput-object p6, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/MediaOpenedMessage;->manifestUrl:Ljava/lang/String;

    .line 34
    iput-object p7, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/MediaOpenedMessage;->xuaAsset:Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    .line 35
    return-void
.end method


# virtual methods
.method public buildXuaEvent()V
    .locals 5

    .prologue
    .line 45
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaEvent;

    iget-wide v2, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/MediaOpenedMessage;->evtTimestamp:J

    sget-object v1, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->xuaMediaOpened:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->name()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0}, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/MediaOpenedMessage;->getMessage()Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;

    move-result-object v4

    invoke-virtual {v4}, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;->getValue()Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;

    move-result-object v4

    invoke-direct {v0, v2, v3, v1, v4}, Lcom/comcast/playerplatform/analytics/java/xua/XuaEvent;-><init>(JLjava/lang/String;Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;)V

    .line 46
    .local v0, "xuaEvent":Lcom/comcast/playerplatform/analytics/java/xua/XuaEvent;
    iget-object v1, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/MediaOpenedMessage;->xuaAsset:Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/analytics/java/xua/XuaEvent;->setAsset(Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V

    .line 48
    invoke-virtual {p0}, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/MediaOpenedMessage;->getMessage()Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;->setEvent(Lcom/comcast/playerplatform/analytics/java/xua/XuaBaseEvent;)V

    .line 51
    return-void
.end method

.method public buildXuaValue()V
    .locals 5

    .prologue
    .line 39
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaMediaOpenedValue;

    iget-wide v2, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/MediaOpenedMessage;->currentPosition:J

    iget-object v1, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/MediaOpenedMessage;->channelOpenningLatency:Ljava/lang/Long;

    iget-object v4, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/MediaOpenedMessage;->manifestUrl:Ljava/lang/String;

    invoke-direct {v0, v2, v3, v1, v4}, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaMediaOpenedValue;-><init>(JLjava/lang/Long;Ljava/lang/String;)V

    .line 40
    .local v0, "xuaMediaOpenedValue":Lcom/comcast/playerplatform/analytics/java/xua/values/XuaMediaOpenedValue;
    invoke-virtual {p0}, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/MediaOpenedMessage;->getMessage()Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;->setValue(Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;)V

    .line 41
    return-void
.end method
