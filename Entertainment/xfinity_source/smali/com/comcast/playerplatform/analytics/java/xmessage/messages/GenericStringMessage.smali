.class public Lcom/comcast/playerplatform/analytics/java/xmessage/messages/GenericStringMessage;
.super Lcom/comcast/playerplatform/analytics/java/xmessage/AbstractXMessageBuilder;
.source "GenericStringMessage.java"


# instance fields
.field private eventName:Ljava/lang/String;

.field private eventValue:Ljava/lang/String;

.field private evtTimestamp:J

.field private xuaAsset:Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;


# direct methods
.method public constructor <init>(JLjava/lang/String;Ljava/lang/String;Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V
    .locals 1
    .param p1, "evtTimestamp"    # J
    .param p3, "eventName"    # Ljava/lang/String;
    .param p4, "eventValue"    # Ljava/lang/String;
    .param p5, "xuaAsset"    # Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    .prologue
    .line 23
    invoke-direct {p0}, Lcom/comcast/playerplatform/analytics/java/xmessage/AbstractXMessageBuilder;-><init>()V

    .line 24
    iput-wide p1, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/GenericStringMessage;->evtTimestamp:J

    .line 25
    iput-object p3, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/GenericStringMessage;->eventName:Ljava/lang/String;

    .line 26
    iput-object p4, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/GenericStringMessage;->eventValue:Ljava/lang/String;

    .line 27
    iput-object p5, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/GenericStringMessage;->xuaAsset:Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    .line 28
    return-void
.end method


# virtual methods
.method public buildXuaEvent()V
    .locals 5

    .prologue
    .line 41
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaEvent;

    iget-wide v2, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/GenericStringMessage;->evtTimestamp:J

    iget-object v1, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/GenericStringMessage;->eventName:Ljava/lang/String;

    invoke-virtual {p0}, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/GenericStringMessage;->getMessage()Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;

    move-result-object v4

    invoke-virtual {v4}, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;->getValue()Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;

    move-result-object v4

    invoke-direct {v0, v2, v3, v1, v4}, Lcom/comcast/playerplatform/analytics/java/xua/XuaEvent;-><init>(JLjava/lang/String;Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;)V

    .line 42
    .local v0, "xuaEvent":Lcom/comcast/playerplatform/analytics/java/xua/XuaEvent;
    iget-wide v2, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/GenericStringMessage;->evtTimestamp:J

    invoke-virtual {v0, v2, v3}, Lcom/comcast/playerplatform/analytics/java/xua/XuaEvent;->setTimeStamp(J)V

    .line 43
    iget-object v1, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/GenericStringMessage;->eventName:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/analytics/java/xua/XuaEvent;->setEventName(Ljava/lang/String;)V

    .line 44
    invoke-virtual {p0}, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/GenericStringMessage;->getMessage()Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;

    move-result-object v1

    invoke-virtual {v1}, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;->getValue()Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/analytics/java/xua/XuaEvent;->setValue(Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;)V

    .line 45
    iget-object v1, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/GenericStringMessage;->xuaAsset:Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/analytics/java/xua/XuaEvent;->setAsset(Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V

    .line 47
    invoke-virtual {p0}, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/GenericStringMessage;->getMessage()Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;->setEvent(Lcom/comcast/playerplatform/analytics/java/xua/XuaBaseEvent;)V

    .line 48
    return-void
.end method

.method public buildXuaValue()V
    .locals 2

    .prologue
    .line 32
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaGenericEventValue;

    invoke-direct {v0}, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaGenericEventValue;-><init>()V

    .line 34
    .local v0, "xuaGenericEventValue":Lcom/comcast/playerplatform/analytics/java/xua/values/XuaGenericEventValue;
    iget-object v1, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/GenericStringMessage;->eventValue:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaGenericEventValue;->setValue(Ljava/lang/String;)V

    .line 36
    invoke-virtual {p0}, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/GenericStringMessage;->getMessage()Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;->setValue(Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;)V

    .line 37
    return-void
.end method
