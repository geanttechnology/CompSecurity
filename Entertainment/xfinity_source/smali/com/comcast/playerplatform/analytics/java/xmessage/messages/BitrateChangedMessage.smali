.class public Lcom/comcast/playerplatform/analytics/java/xmessage/messages/BitrateChangedMessage;
.super Lcom/comcast/playerplatform/analytics/java/xmessage/AbstractXMessageBuilder;
.source "BitrateChangedMessage.java"


# instance fields
.field private bitrate:J

.field private evtTimestamp:J

.field private xuaAsset:Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;


# direct methods
.method public constructor <init>(JJLcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V
    .locals 1
    .param p1, "evtTimestamp"    # J
    .param p3, "bitrate"    # J
    .param p5, "xuaAsset"    # Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    .prologue
    .line 24
    invoke-direct {p0}, Lcom/comcast/playerplatform/analytics/java/xmessage/AbstractXMessageBuilder;-><init>()V

    .line 25
    iput-wide p1, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/BitrateChangedMessage;->evtTimestamp:J

    .line 26
    iput-wide p3, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/BitrateChangedMessage;->bitrate:J

    .line 27
    iput-object p5, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/BitrateChangedMessage;->xuaAsset:Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    .line 28
    return-void
.end method


# virtual methods
.method public buildXuaEvent()V
    .locals 5

    .prologue
    .line 40
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaEvent;

    iget-wide v2, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/BitrateChangedMessage;->evtTimestamp:J

    sget-object v1, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->xuaBitrateChanged:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->name()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0}, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/BitrateChangedMessage;->getMessage()Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;

    move-result-object v4

    invoke-virtual {v4}, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;->getValue()Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;

    move-result-object v4

    invoke-direct {v0, v2, v3, v1, v4}, Lcom/comcast/playerplatform/analytics/java/xua/XuaEvent;-><init>(JLjava/lang/String;Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;)V

    .line 41
    .local v0, "xuaEvent":Lcom/comcast/playerplatform/analytics/java/xua/XuaEvent;
    iget-object v1, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/BitrateChangedMessage;->xuaAsset:Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/analytics/java/xua/XuaEvent;->setAsset(Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V

    .line 43
    invoke-virtual {p0}, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/BitrateChangedMessage;->getMessage()Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;->setEvent(Lcom/comcast/playerplatform/analytics/java/xua/XuaBaseEvent;)V

    .line 44
    return-void
.end method

.method public buildXuaValue()V
    .locals 4

    .prologue
    .line 32
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaBitrateChangedValue;

    invoke-direct {v0}, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaBitrateChangedValue;-><init>()V

    .line 33
    .local v0, "xuaBitrateChangedValue":Lcom/comcast/playerplatform/analytics/java/xua/values/XuaBitrateChangedValue;
    iget-wide v2, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/BitrateChangedMessage;->bitrate:J

    invoke-virtual {v0, v2, v3}, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaBitrateChangedValue;->setValue(J)V

    .line 35
    invoke-virtual {p0}, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/BitrateChangedMessage;->getMessage()Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;->setValue(Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;)V

    .line 36
    return-void
.end method
