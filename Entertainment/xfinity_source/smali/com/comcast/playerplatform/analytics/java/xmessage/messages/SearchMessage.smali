.class public Lcom/comcast/playerplatform/analytics/java/xmessage/messages/SearchMessage;
.super Lcom/comcast/playerplatform/analytics/java/xmessage/AbstractXMessageBuilder;
.source "SearchMessage.java"


# instance fields
.field private evtTimestamp:J

.field private query:Ljava/lang/String;


# virtual methods
.method public buildXuaEvent()V
    .locals 5

    .prologue
    .line 30
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaEvent;

    iget-wide v2, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/SearchMessage;->evtTimestamp:J

    sget-object v1, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->xuaSearch:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->name()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0}, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/SearchMessage;->getMessage()Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;

    move-result-object v4

    invoke-virtual {v4}, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;->getValue()Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;

    move-result-object v4

    invoke-direct {v0, v2, v3, v1, v4}, Lcom/comcast/playerplatform/analytics/java/xua/XuaEvent;-><init>(JLjava/lang/String;Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;)V

    .line 31
    .local v0, "event":Lcom/comcast/playerplatform/analytics/java/xua/XuaEvent;
    invoke-virtual {p0}, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/SearchMessage;->getMessage()Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;->setEvent(Lcom/comcast/playerplatform/analytics/java/xua/XuaBaseEvent;)V

    .line 32
    return-void
.end method

.method public buildXuaValue()V
    .locals 2

    .prologue
    .line 24
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaSearchValue;

    iget-object v1, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/SearchMessage;->query:Ljava/lang/String;

    invoke-direct {v0, v1}, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaSearchValue;-><init>(Ljava/lang/String;)V

    .line 25
    .local v0, "value":Lcom/comcast/playerplatform/analytics/java/xua/values/XuaSearchValue;
    invoke-virtual {p0}, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/SearchMessage;->getMessage()Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;->setValue(Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;)V

    .line 26
    return-void
.end method
