.class public Lcom/comcast/playerplatform/analytics/java/xmessage/messages/PluginInitializedMessage;
.super Lcom/comcast/playerplatform/analytics/java/xmessage/AbstractXMessageBuilder;
.source "PluginInitializedMessage.java"


# instance fields
.field private final evtTimestamp:J

.field private final xuaValue:Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;


# direct methods
.method public constructor <init>(JLcom/comcast/playerplatform/analytics/java/xua/values/XuaPluginInitializedValue;)V
    .locals 1
    .param p1, "evtTimestamp"    # J
    .param p3, "xuaValue"    # Lcom/comcast/playerplatform/analytics/java/xua/values/XuaPluginInitializedValue;

    .prologue
    .line 21
    invoke-direct {p0}, Lcom/comcast/playerplatform/analytics/java/xmessage/AbstractXMessageBuilder;-><init>()V

    .line 22
    iput-wide p1, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/PluginInitializedMessage;->evtTimestamp:J

    .line 23
    iput-object p3, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/PluginInitializedMessage;->xuaValue:Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;

    .line 24
    return-void
.end method


# virtual methods
.method public buildXuaEvent()V
    .locals 5

    .prologue
    .line 33
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaEvent;

    iget-wide v2, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/PluginInitializedMessage;->evtTimestamp:J

    sget-object v1, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->xuaPluginInitialized:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->name()Ljava/lang/String;

    move-result-object v1

    iget-object v4, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/PluginInitializedMessage;->xuaValue:Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;

    invoke-direct {v0, v2, v3, v1, v4}, Lcom/comcast/playerplatform/analytics/java/xua/XuaEvent;-><init>(JLjava/lang/String;Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;)V

    .line 34
    .local v0, "event":Lcom/comcast/playerplatform/analytics/java/xua/XuaEvent;
    invoke-virtual {p0}, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/PluginInitializedMessage;->getMessage()Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;->setEvent(Lcom/comcast/playerplatform/analytics/java/xua/XuaBaseEvent;)V

    .line 35
    return-void
.end method

.method public buildXuaValue()V
    .locals 2

    .prologue
    .line 28
    invoke-virtual {p0}, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/PluginInitializedMessage;->getMessage()Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;

    move-result-object v0

    iget-object v1, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/PluginInitializedMessage;->xuaValue:Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;->setValue(Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;)V

    .line 29
    return-void
.end method
