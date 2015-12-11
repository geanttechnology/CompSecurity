.class public Lcom/comcast/playerplatform/analytics/java/xmessage/messages/PlayStateChangedMessage;
.super Lcom/comcast/playerplatform/analytics/java/xmessage/AbstractXMessageBuilder;
.source "PlayStateChangedMessage.java"


# instance fields
.field private evtTimestamp:J

.field private playerState:Ljava/lang/String;

.field private xuaAsset:Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;


# direct methods
.method public constructor <init>(JLjava/lang/String;Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V
    .locals 1
    .param p1, "evtTimestamp"    # J
    .param p3, "playerState"    # Ljava/lang/String;
    .param p4, "xuaAsset"    # Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    .prologue
    .line 24
    invoke-direct {p0}, Lcom/comcast/playerplatform/analytics/java/xmessage/AbstractXMessageBuilder;-><init>()V

    .line 25
    iput-wide p1, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/PlayStateChangedMessage;->evtTimestamp:J

    .line 26
    iput-object p3, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/PlayStateChangedMessage;->playerState:Ljava/lang/String;

    .line 27
    iput-object p4, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/PlayStateChangedMessage;->xuaAsset:Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    .line 28
    return-void
.end method


# virtual methods
.method public buildXuaEvent()V
    .locals 5

    .prologue
    .line 41
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaEvent;

    iget-wide v2, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/PlayStateChangedMessage;->evtTimestamp:J

    sget-object v1, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->xuaPlayStateChanged:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->name()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0}, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/PlayStateChangedMessage;->getMessage()Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;

    move-result-object v4

    invoke-virtual {v4}, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;->getValue()Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;

    move-result-object v4

    invoke-direct {v0, v2, v3, v1, v4}, Lcom/comcast/playerplatform/analytics/java/xua/XuaEvent;-><init>(JLjava/lang/String;Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;)V

    .line 42
    .local v0, "xuaEvent":Lcom/comcast/playerplatform/analytics/java/xua/XuaEvent;
    iget-object v1, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/PlayStateChangedMessage;->xuaAsset:Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/analytics/java/xua/XuaEvent;->setAsset(Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V

    .line 44
    invoke-virtual {p0}, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/PlayStateChangedMessage;->getMessage()Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;->setEvent(Lcom/comcast/playerplatform/analytics/java/xua/XuaBaseEvent;)V

    .line 45
    return-void
.end method

.method public buildXuaValue()V
    .locals 2

    .prologue
    .line 32
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaPlayStateChangedValue;

    invoke-direct {v0}, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaPlayStateChangedValue;-><init>()V

    .line 34
    .local v0, "xuaPlayStateChangedValue":Lcom/comcast/playerplatform/analytics/java/xua/values/XuaPlayStateChangedValue;
    iget-object v1, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/PlayStateChangedMessage;->playerState:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaPlayStateChangedValue;->setValue(Ljava/lang/String;)V

    .line 36
    invoke-virtual {p0}, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/PlayStateChangedMessage;->getMessage()Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;->setValue(Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;)V

    .line 37
    return-void
.end method
