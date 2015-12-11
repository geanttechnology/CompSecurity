.class public Lcom/comcast/playerplatform/analytics/java/xmessage/messages/MediaEndedMessage;
.super Lcom/comcast/playerplatform/analytics/java/xmessage/AbstractXMessageBuilder;
.source "MediaEndedMessage.java"


# instance fields
.field private evtTimestamp:J

.field private xuaAsset:Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;


# direct methods
.method public constructor <init>(JLcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V
    .locals 1
    .param p1, "evtTimestamp"    # J
    .param p3, "xuaAsset"    # Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    .prologue
    .line 16
    invoke-direct {p0}, Lcom/comcast/playerplatform/analytics/java/xmessage/AbstractXMessageBuilder;-><init>()V

    .line 17
    iput-wide p1, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/MediaEndedMessage;->evtTimestamp:J

    .line 18
    iput-object p3, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/MediaEndedMessage;->xuaAsset:Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    .line 19
    return-void
.end method


# virtual methods
.method public buildXuaEvent()V
    .locals 5

    .prologue
    .line 23
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaEvent;

    iget-wide v2, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/MediaEndedMessage;->evtTimestamp:J

    sget-object v1, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->xuaMediaEnded:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->name()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0}, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/MediaEndedMessage;->getMessage()Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;

    move-result-object v4

    invoke-virtual {v4}, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;->getValue()Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;

    move-result-object v4

    invoke-direct {v0, v2, v3, v1, v4}, Lcom/comcast/playerplatform/analytics/java/xua/XuaEvent;-><init>(JLjava/lang/String;Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;)V

    .line 24
    .local v0, "event":Lcom/comcast/playerplatform/analytics/java/xua/XuaEvent;
    iget-object v1, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/MediaEndedMessage;->xuaAsset:Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/analytics/java/xua/XuaEvent;->setAsset(Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V

    .line 25
    invoke-virtual {p0}, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/MediaEndedMessage;->getMessage()Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;->setEvent(Lcom/comcast/playerplatform/analytics/java/xua/XuaBaseEvent;)V

    .line 26
    return-void
.end method
