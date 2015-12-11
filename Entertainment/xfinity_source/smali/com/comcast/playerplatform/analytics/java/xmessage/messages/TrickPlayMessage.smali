.class public Lcom/comcast/playerplatform/analytics/java/xmessage/messages/TrickPlayMessage;
.super Lcom/comcast/playerplatform/analytics/java/xmessage/AbstractXMessageBuilder;
.source "TrickPlayMessage.java"


# instance fields
.field private currentPosition:J

.field private evtTimestamp:J

.field private trickPlayType:Ljava/lang/String;

.field private xuaAsset:Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;


# direct methods
.method public constructor <init>(JJLjava/lang/String;Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V
    .locals 1
    .param p1, "evtTimestamp"    # J
    .param p3, "currentPosition"    # J
    .param p5, "trickPlayType"    # Ljava/lang/String;
    .param p6, "xuaAsset"    # Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    .prologue
    .line 24
    invoke-direct {p0}, Lcom/comcast/playerplatform/analytics/java/xmessage/AbstractXMessageBuilder;-><init>()V

    .line 25
    iput-wide p1, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/TrickPlayMessage;->evtTimestamp:J

    .line 26
    iput-wide p3, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/TrickPlayMessage;->currentPosition:J

    .line 27
    iput-object p5, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/TrickPlayMessage;->trickPlayType:Ljava/lang/String;

    .line 28
    iput-object p6, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/TrickPlayMessage;->xuaAsset:Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    .line 29
    return-void
.end method


# virtual methods
.method public buildXuaEvent()V
    .locals 5

    .prologue
    .line 43
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaEvent;

    iget-wide v2, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/TrickPlayMessage;->evtTimestamp:J

    sget-object v1, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->xuaTrickPlay:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->name()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0}, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/TrickPlayMessage;->getMessage()Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;

    move-result-object v4

    invoke-virtual {v4}, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;->getValue()Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;

    move-result-object v4

    invoke-direct {v0, v2, v3, v1, v4}, Lcom/comcast/playerplatform/analytics/java/xua/XuaEvent;-><init>(JLjava/lang/String;Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;)V

    .line 44
    .local v0, "xuaEvent":Lcom/comcast/playerplatform/analytics/java/xua/XuaEvent;
    iget-wide v2, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/TrickPlayMessage;->evtTimestamp:J

    invoke-virtual {v0, v2, v3}, Lcom/comcast/playerplatform/analytics/java/xua/XuaEvent;->setTimeStamp(J)V

    .line 45
    sget-object v1, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->xuaTrickPlay:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->name()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/analytics/java/xua/XuaEvent;->setEventName(Ljava/lang/String;)V

    .line 46
    invoke-virtual {p0}, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/TrickPlayMessage;->getMessage()Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;

    move-result-object v1

    invoke-virtual {v1}, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;->getValue()Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/analytics/java/xua/XuaEvent;->setValue(Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;)V

    .line 47
    iget-object v1, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/TrickPlayMessage;->xuaAsset:Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/analytics/java/xua/XuaEvent;->setAsset(Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V

    .line 49
    invoke-virtual {p0}, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/TrickPlayMessage;->getMessage()Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;->setEvent(Lcom/comcast/playerplatform/analytics/java/xua/XuaBaseEvent;)V

    .line 50
    return-void
.end method

.method public buildXuaValue()V
    .locals 4

    .prologue
    .line 33
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaTrickPlayValue;

    invoke-direct {v0}, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaTrickPlayValue;-><init>()V

    .line 35
    .local v0, "xuaTrickPlayValue":Lcom/comcast/playerplatform/analytics/java/xua/values/XuaTrickPlayValue;
    iget-wide v2, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/TrickPlayMessage;->currentPosition:J

    invoke-virtual {v0, v2, v3}, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaTrickPlayValue;->setPosition(J)V

    .line 36
    iget-object v1, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/TrickPlayMessage;->trickPlayType:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaTrickPlayValue;->setType(Ljava/lang/String;)V

    .line 38
    invoke-virtual {p0}, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/TrickPlayMessage;->getMessage()Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;->setValue(Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;)V

    .line 39
    return-void
.end method
