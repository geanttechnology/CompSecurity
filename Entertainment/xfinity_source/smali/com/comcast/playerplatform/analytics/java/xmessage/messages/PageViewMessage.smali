.class public Lcom/comcast/playerplatform/analytics/java/xmessage/messages/PageViewMessage;
.super Lcom/comcast/playerplatform/analytics/java/xmessage/AbstractXMessageBuilder;
.source "PageViewMessage.java"


# instance fields
.field private evtTimestamp:J

.field private pageId:Ljava/lang/String;

.field private title:Ljava/lang/String;


# virtual methods
.method public buildXuaEvent()V
    .locals 5

    .prologue
    .line 35
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaEvent;

    iget-wide v2, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/PageViewMessage;->evtTimestamp:J

    sget-object v1, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->xuaPageView:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->name()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0}, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/PageViewMessage;->getMessage()Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;

    move-result-object v4

    invoke-virtual {v4}, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;->getValue()Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;

    move-result-object v4

    invoke-direct {v0, v2, v3, v1, v4}, Lcom/comcast/playerplatform/analytics/java/xua/XuaEvent;-><init>(JLjava/lang/String;Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;)V

    .line 36
    .local v0, "event":Lcom/comcast/playerplatform/analytics/java/xua/XuaEvent;
    invoke-virtual {p0}, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/PageViewMessage;->getMessage()Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;->setEvent(Lcom/comcast/playerplatform/analytics/java/xua/XuaBaseEvent;)V

    .line 37
    return-void
.end method

.method public buildXuaValue()V
    .locals 3

    .prologue
    .line 29
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaPageViewValue;

    iget-object v1, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/PageViewMessage;->pageId:Ljava/lang/String;

    iget-object v2, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/PageViewMessage;->title:Ljava/lang/String;

    invoke-direct {v0, v1, v2}, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaPageViewValue;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 30
    .local v0, "value":Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;
    invoke-virtual {p0}, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/PageViewMessage;->getMessage()Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;->setValue(Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;)V

    .line 31
    return-void
.end method
