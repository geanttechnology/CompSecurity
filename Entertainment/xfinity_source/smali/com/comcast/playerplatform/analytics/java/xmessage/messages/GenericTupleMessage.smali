.class public Lcom/comcast/playerplatform/analytics/java/xmessage/messages/GenericTupleMessage;
.super Lcom/comcast/playerplatform/analytics/java/xmessage/AbstractXMessageBuilder;
.source "GenericTupleMessage.java"


# instance fields
.field private eventName:Ljava/lang/String;

.field private eventValue:Ljava/util/Map;

.field private evtTimestamp:J

.field private xuaAsset:Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;


# direct methods
.method public constructor <init>(JLjava/lang/String;Ljava/util/Map;Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V
    .locals 1
    .param p1, "evtTimestamp"    # J
    .param p3, "eventName"    # Ljava/lang/String;
    .param p4, "eventValue"    # Ljava/util/Map;
    .param p5, "xuaAsset"    # Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    .prologue
    .line 25
    invoke-direct {p0}, Lcom/comcast/playerplatform/analytics/java/xmessage/AbstractXMessageBuilder;-><init>()V

    .line 26
    iput-wide p1, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/GenericTupleMessage;->evtTimestamp:J

    .line 27
    iput-object p3, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/GenericTupleMessage;->eventName:Ljava/lang/String;

    .line 28
    iput-object p4, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/GenericTupleMessage;->eventValue:Ljava/util/Map;

    .line 29
    iput-object p5, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/GenericTupleMessage;->xuaAsset:Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    .line 30
    return-void
.end method


# virtual methods
.method public buildXuaEvent()V
    .locals 5

    .prologue
    .line 43
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaGenericEvent;

    iget-wide v2, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/GenericTupleMessage;->evtTimestamp:J

    iget-object v1, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/GenericTupleMessage;->eventName:Ljava/lang/String;

    iget-object v4, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/GenericTupleMessage;->eventValue:Ljava/util/Map;

    invoke-direct {v0, v2, v3, v1, v4}, Lcom/comcast/playerplatform/analytics/java/xua/XuaGenericEvent;-><init>(JLjava/lang/String;Ljava/util/Map;)V

    .line 44
    .local v0, "xuaEvent":Lcom/comcast/playerplatform/analytics/java/xua/XuaGenericEvent;
    iget-object v1, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/GenericTupleMessage;->xuaAsset:Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/analytics/java/xua/XuaGenericEvent;->setAsset(Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V

    .line 46
    invoke-virtual {p0}, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/GenericTupleMessage;->getMessage()Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;->setEvent(Lcom/comcast/playerplatform/analytics/java/xua/XuaBaseEvent;)V

    .line 47
    return-void
.end method

.method public buildXuaValue()V
    .locals 2

    .prologue
    .line 34
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaGenericTupleValue;

    invoke-direct {v0}, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaGenericTupleValue;-><init>()V

    .line 36
    .local v0, "xuaGenericTupleValue":Lcom/comcast/playerplatform/analytics/java/xua/values/XuaGenericTupleValue;
    iget-object v1, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/GenericTupleMessage;->eventValue:Ljava/util/Map;

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaGenericTupleValue;->setValue(Ljava/util/Map;)V

    .line 38
    invoke-virtual {p0}, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/GenericTupleMessage;->getMessage()Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;->setValue(Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;)V

    .line 39
    return-void
.end method
