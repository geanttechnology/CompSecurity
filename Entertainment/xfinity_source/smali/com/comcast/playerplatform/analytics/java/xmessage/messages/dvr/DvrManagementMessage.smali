.class public Lcom/comcast/playerplatform/analytics/java/xmessage/messages/dvr/DvrManagementMessage;
.super Lcom/comcast/playerplatform/analytics/java/xmessage/AbstractXMessageBuilder;
.source "DvrManagementMessage.java"


# instance fields
.field private count:Ljava/lang/String;

.field private eventName:Ljava/lang/String;

.field private evtTimestamp:J

.field private type:Ljava/lang/String;

.field private xuaAsset:Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;


# virtual methods
.method public buildXuaEvent()V
    .locals 5

    .prologue
    .line 47
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaEvent;

    iget-wide v2, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/dvr/DvrManagementMessage;->evtTimestamp:J

    iget-object v1, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/dvr/DvrManagementMessage;->eventName:Ljava/lang/String;

    invoke-virtual {p0}, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/dvr/DvrManagementMessage;->getMessage()Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;

    move-result-object v4

    invoke-virtual {v4}, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;->getValue()Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;

    move-result-object v4

    invoke-direct {v0, v2, v3, v1, v4}, Lcom/comcast/playerplatform/analytics/java/xua/XuaEvent;-><init>(JLjava/lang/String;Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;)V

    .line 48
    .local v0, "event":Lcom/comcast/playerplatform/analytics/java/xua/XuaEvent;
    iget-object v1, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/dvr/DvrManagementMessage;->xuaAsset:Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/analytics/java/xua/XuaEvent;->setAsset(Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V

    .line 49
    invoke-virtual {p0}, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/dvr/DvrManagementMessage;->getMessage()Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;->setEvent(Lcom/comcast/playerplatform/analytics/java/xua/XuaBaseEvent;)V

    .line 50
    return-void
.end method

.method public buildXuaValue()V
    .locals 3

    .prologue
    .line 41
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaDvrManagementValue;

    iget-object v1, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/dvr/DvrManagementMessage;->count:Ljava/lang/String;

    iget-object v2, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/dvr/DvrManagementMessage;->type:Ljava/lang/String;

    invoke-direct {v0, v1, v2}, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaDvrManagementValue;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 42
    .local v0, "value":Lcom/comcast/playerplatform/analytics/java/xua/values/XuaDvrManagementValue;
    invoke-virtual {p0}, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/dvr/DvrManagementMessage;->getMessage()Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;->setValue(Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;)V

    .line 43
    return-void
.end method
