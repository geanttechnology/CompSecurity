.class public Lcom/comcast/playerplatform/analytics/java/xmessage/messages/OpeningMediaMessage;
.super Lcom/comcast/playerplatform/analytics/java/xmessage/AbstractXMessageBuilder;
.source "OpeningMediaMessage.java"


# instance fields
.field private evtTimestamp:J

.field private manifestUrl:Ljava/lang/String;

.field private xuaAsset:Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;


# direct methods
.method public constructor <init>(JLcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;Ljava/lang/String;)V
    .locals 1
    .param p1, "evtTimestamp"    # J
    .param p3, "xuaAsset"    # Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;
    .param p4, "manifestUrl"    # Ljava/lang/String;

    .prologue
    .line 25
    invoke-direct {p0}, Lcom/comcast/playerplatform/analytics/java/xmessage/AbstractXMessageBuilder;-><init>()V

    .line 26
    iput-wide p1, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/OpeningMediaMessage;->evtTimestamp:J

    .line 27
    iput-object p3, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/OpeningMediaMessage;->xuaAsset:Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    .line 28
    iput-object p4, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/OpeningMediaMessage;->manifestUrl:Ljava/lang/String;

    .line 29
    return-void
.end method


# virtual methods
.method public buildXuaEvent()V
    .locals 5

    .prologue
    .line 39
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaEvent;

    iget-wide v2, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/OpeningMediaMessage;->evtTimestamp:J

    sget-object v1, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->xuaOpeningMedia:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->name()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0}, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/OpeningMediaMessage;->getMessage()Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;

    move-result-object v4

    invoke-virtual {v4}, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;->getValue()Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;

    move-result-object v4

    invoke-direct {v0, v2, v3, v1, v4}, Lcom/comcast/playerplatform/analytics/java/xua/XuaEvent;-><init>(JLjava/lang/String;Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;)V

    .line 40
    .local v0, "xuaEvent":Lcom/comcast/playerplatform/analytics/java/xua/XuaEvent;
    iget-object v1, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/OpeningMediaMessage;->xuaAsset:Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/analytics/java/xua/XuaEvent;->setAsset(Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V

    .line 42
    invoke-virtual {p0}, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/OpeningMediaMessage;->getMessage()Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;->setEvent(Lcom/comcast/playerplatform/analytics/java/xua/XuaBaseEvent;)V

    .line 43
    return-void
.end method

.method public buildXuaValue()V
    .locals 2

    .prologue
    .line 33
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaOpeningMediaValue;

    iget-object v1, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/OpeningMediaMessage;->manifestUrl:Ljava/lang/String;

    invoke-direct {v0, v1}, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaOpeningMediaValue;-><init>(Ljava/lang/String;)V

    .line 34
    .local v0, "xuaOpeningMediaValue":Lcom/comcast/playerplatform/analytics/java/xua/values/XuaOpeningMediaValue;
    invoke-virtual {p0}, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/OpeningMediaMessage;->getMessage()Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;->setValue(Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;)V

    .line 35
    return-void
.end method
