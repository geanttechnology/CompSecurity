.class public Lcom/comcast/playerplatform/analytics/java/xmessage/messages/MediaFailedMessage;
.super Lcom/comcast/playerplatform/analytics/java/xmessage/AbstractXMessageBuilder;
.source "MediaFailedMessage.java"


# instance fields
.field private code:Ljava/lang/String;

.field private description:Ljava/lang/String;

.field private evtTimestamp:J

.field private manifestUrl:Ljava/lang/String;

.field private position:J

.field private xuaAsset:Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;


# direct methods
.method public constructor <init>(JLjava/lang/String;Ljava/lang/String;JLjava/lang/String;Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V
    .locals 1
    .param p1, "evtTimestamp"    # J
    .param p3, "code"    # Ljava/lang/String;
    .param p4, "description"    # Ljava/lang/String;
    .param p5, "position"    # J
    .param p7, "manifestUrl"    # Ljava/lang/String;
    .param p8, "xuaAsset"    # Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    .prologue
    .line 34
    invoke-direct {p0}, Lcom/comcast/playerplatform/analytics/java/xmessage/AbstractXMessageBuilder;-><init>()V

    .line 35
    iput-wide p1, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/MediaFailedMessage;->evtTimestamp:J

    .line 36
    iput-object p3, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/MediaFailedMessage;->code:Ljava/lang/String;

    .line 37
    iput-object p4, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/MediaFailedMessage;->description:Ljava/lang/String;

    .line 38
    iput-wide p5, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/MediaFailedMessage;->position:J

    .line 39
    iput-object p7, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/MediaFailedMessage;->manifestUrl:Ljava/lang/String;

    .line 40
    iput-object p8, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/MediaFailedMessage;->xuaAsset:Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    .line 41
    return-void
.end method


# virtual methods
.method public buildXuaEvent()V
    .locals 5

    .prologue
    .line 51
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaEvent;

    iget-wide v2, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/MediaFailedMessage;->evtTimestamp:J

    sget-object v1, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->xuaMediaFailed:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->name()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0}, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/MediaFailedMessage;->getMessage()Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;

    move-result-object v4

    invoke-virtual {v4}, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;->getValue()Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;

    move-result-object v4

    invoke-direct {v0, v2, v3, v1, v4}, Lcom/comcast/playerplatform/analytics/java/xua/XuaEvent;-><init>(JLjava/lang/String;Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;)V

    .line 52
    .local v0, "xuaEvent":Lcom/comcast/playerplatform/analytics/java/xua/XuaEvent;
    iget-object v1, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/MediaFailedMessage;->xuaAsset:Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/analytics/java/xua/XuaEvent;->setAsset(Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V

    .line 54
    invoke-virtual {p0}, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/MediaFailedMessage;->getMessage()Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;->setEvent(Lcom/comcast/playerplatform/analytics/java/xua/XuaBaseEvent;)V

    .line 55
    return-void
.end method

.method public buildXuaValue()V
    .locals 7

    .prologue
    .line 45
    new-instance v1, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaMediaFailedValue;

    iget-object v2, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/MediaFailedMessage;->code:Ljava/lang/String;

    iget-object v3, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/MediaFailedMessage;->description:Ljava/lang/String;

    iget-wide v4, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/MediaFailedMessage;->position:J

    iget-object v6, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/MediaFailedMessage;->manifestUrl:Ljava/lang/String;

    invoke-direct/range {v1 .. v6}, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaMediaFailedValue;-><init>(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)V

    .line 46
    .local v1, "xuaMediaFailedValue":Lcom/comcast/playerplatform/analytics/java/xua/values/XuaMediaFailedValue;
    invoke-virtual {p0}, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/MediaFailedMessage;->getMessage()Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;

    move-result-object v0

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;->setValue(Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;)V

    .line 47
    return-void
.end method
