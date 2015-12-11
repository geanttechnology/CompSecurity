.class public Lcom/comcast/playerplatform/analytics/java/xmessage/messages/KeyMessage;
.super Lcom/comcast/playerplatform/analytics/java/xmessage/AbstractXMessageBuilder;
.source "KeyMessage.java"


# instance fields
.field private evtTimestamp:J

.field private keyValue:Ljava/lang/String;


# virtual methods
.method public buildXuaEvent()V
    .locals 5

    .prologue
    .line 38
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaEvent;

    iget-wide v2, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/KeyMessage;->evtTimestamp:J

    sget-object v1, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->xuaKeyEvent:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->name()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0}, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/KeyMessage;->getMessage()Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;

    move-result-object v4

    invoke-virtual {v4}, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;->getValue()Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;

    move-result-object v4

    invoke-direct {v0, v2, v3, v1, v4}, Lcom/comcast/playerplatform/analytics/java/xua/XuaEvent;-><init>(JLjava/lang/String;Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;)V

    .line 39
    .local v0, "xuaEvent":Lcom/comcast/playerplatform/analytics/java/xua/XuaEvent;
    invoke-virtual {p0}, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/KeyMessage;->getMessage()Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;->setEvent(Lcom/comcast/playerplatform/analytics/java/xua/XuaBaseEvent;)V

    .line 40
    return-void
.end method

.method public buildXuaValue()V
    .locals 2

    .prologue
    .line 29
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaKeyEventValue;

    invoke-direct {v0}, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaKeyEventValue;-><init>()V

    .line 31
    .local v0, "xuaKeyEventValue":Lcom/comcast/playerplatform/analytics/java/xua/values/XuaKeyEventValue;
    iget-object v1, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/KeyMessage;->keyValue:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaKeyEventValue;->setValue(Ljava/lang/String;)V

    .line 33
    invoke-virtual {p0}, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/KeyMessage;->getMessage()Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;->setValue(Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;)V

    .line 34
    return-void
.end method
