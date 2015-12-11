.class public Lcom/comcast/playerplatform/analytics/java/xmessage/messages/PerformanceMessage;
.super Lcom/comcast/playerplatform/analytics/java/xmessage/AbstractXMessageBuilder;
.source "PerformanceMessage.java"


# instance fields
.field private final evtTimestamp:J

.field private final stepName:Ljava/lang/String;

.field private final valueMs:J

.field private final xuaAsset:Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;


# direct methods
.method public constructor <init>(JLjava/lang/String;JLcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V
    .locals 0
    .param p1, "evtTimestamp"    # J
    .param p3, "stepName"    # Ljava/lang/String;
    .param p4, "valueMs"    # J
    .param p6, "xuaAsset"    # Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    .prologue
    .line 22
    invoke-direct {p0}, Lcom/comcast/playerplatform/analytics/java/xmessage/AbstractXMessageBuilder;-><init>()V

    .line 23
    iput-wide p1, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/PerformanceMessage;->evtTimestamp:J

    .line 24
    iput-object p3, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/PerformanceMessage;->stepName:Ljava/lang/String;

    .line 25
    iput-wide p4, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/PerformanceMessage;->valueMs:J

    .line 26
    iput-object p6, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/PerformanceMessage;->xuaAsset:Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    .line 27
    return-void
.end method


# virtual methods
.method public buildXuaEvent()V
    .locals 5

    .prologue
    .line 39
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaEvent;

    iget-wide v2, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/PerformanceMessage;->evtTimestamp:J

    sget-object v1, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->xuaPerformance:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->name()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0}, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/PerformanceMessage;->getMessage()Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;

    move-result-object v4

    invoke-virtual {v4}, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;->getValue()Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;

    move-result-object v4

    invoke-direct {v0, v2, v3, v1, v4}, Lcom/comcast/playerplatform/analytics/java/xua/XuaEvent;-><init>(JLjava/lang/String;Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;)V

    .line 40
    .local v0, "event":Lcom/comcast/playerplatform/analytics/java/xua/XuaEvent;
    iget-object v1, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/PerformanceMessage;->xuaAsset:Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/analytics/java/xua/XuaEvent;->setAsset(Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V

    .line 41
    invoke-virtual {p0}, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/PerformanceMessage;->getMessage()Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;->setEvent(Lcom/comcast/playerplatform/analytics/java/xua/XuaBaseEvent;)V

    .line 42
    return-void
.end method

.method public buildXuaValue()V
    .locals 6

    .prologue
    .line 31
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 32
    .local v0, "map":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    iget-object v2, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/PerformanceMessage;->stepName:Ljava/lang/String;

    iget-wide v4, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/PerformanceMessage;->valueMs:J

    invoke-static {v4, v5}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v3

    invoke-interface {v0, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 33
    new-instance v1, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaMapValue;

    invoke-direct {v1, v0}, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaMapValue;-><init>(Ljava/util/Map;)V

    .line 34
    .local v1, "value":Lcom/comcast/playerplatform/analytics/java/xua/values/XuaMapValue;
    invoke-virtual {p0}, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/PerformanceMessage;->getMessage()Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;

    move-result-object v2

    invoke-virtual {v2, v1}, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;->setValue(Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;)V

    .line 35
    return-void
.end method
