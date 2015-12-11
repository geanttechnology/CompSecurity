.class public Lcom/comcast/playerplatform/analytics/java/xmessage/messages/MediaInfoMessage;
.super Lcom/comcast/playerplatform/analytics/java/xmessage/AbstractXMessageBuilder;
.source "MediaInfoMessage.java"


# instance fields
.field private description:Ljava/lang/String;

.field private evtTimestamp:J

.field private position:I

.field private xuaAsset:Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;


# direct methods
.method public constructor <init>(JILjava/lang/String;Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V
    .locals 1
    .param p1, "evtTimestamp"    # J
    .param p3, "position"    # I
    .param p4, "description"    # Ljava/lang/String;
    .param p5, "xuaAsset"    # Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    .prologue
    .line 19
    invoke-direct {p0}, Lcom/comcast/playerplatform/analytics/java/xmessage/AbstractXMessageBuilder;-><init>()V

    .line 20
    iput-wide p1, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/MediaInfoMessage;->evtTimestamp:J

    .line 21
    iput p3, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/MediaInfoMessage;->position:I

    .line 22
    iput-object p4, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/MediaInfoMessage;->description:Ljava/lang/String;

    .line 23
    iput-object p5, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/MediaInfoMessage;->xuaAsset:Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    .line 24
    return-void
.end method


# virtual methods
.method public buildXuaEvent()V
    .locals 5

    .prologue
    .line 34
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaEvent;

    iget-wide v2, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/MediaInfoMessage;->evtTimestamp:J

    sget-object v1, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->xuaMediaInfo:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->name()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0}, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/MediaInfoMessage;->getMessage()Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;

    move-result-object v4

    invoke-virtual {v4}, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;->getValue()Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;

    move-result-object v4

    invoke-direct {v0, v2, v3, v1, v4}, Lcom/comcast/playerplatform/analytics/java/xua/XuaEvent;-><init>(JLjava/lang/String;Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;)V

    .line 35
    .local v0, "event":Lcom/comcast/playerplatform/analytics/java/xua/XuaEvent;
    iget-object v1, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/MediaInfoMessage;->xuaAsset:Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/analytics/java/xua/XuaEvent;->setAsset(Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V

    .line 36
    invoke-virtual {p0}, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/MediaInfoMessage;->getMessage()Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;->setEvent(Lcom/comcast/playerplatform/analytics/java/xua/XuaBaseEvent;)V

    .line 37
    return-void
.end method

.method public buildXuaValue()V
    .locals 3

    .prologue
    .line 28
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaMediaInfoValue;

    iget v1, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/MediaInfoMessage;->position:I

    iget-object v2, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/MediaInfoMessage;->description:Ljava/lang/String;

    invoke-direct {v0, v1, v2}, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaMediaInfoValue;-><init>(ILjava/lang/String;)V

    .line 29
    .local v0, "mediaInfoValue":Lcom/comcast/playerplatform/analytics/java/xua/values/XuaMediaInfoValue;
    invoke-virtual {p0}, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/MediaInfoMessage;->getMessage()Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;->setValue(Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;)V

    .line 30
    return-void
.end method
