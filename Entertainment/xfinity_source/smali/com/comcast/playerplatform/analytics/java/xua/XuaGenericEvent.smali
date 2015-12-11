.class public Lcom/comcast/playerplatform/analytics/java/xua/XuaGenericEvent;
.super Lcom/comcast/playerplatform/analytics/java/xua/XuaBaseEvent;
.source "XuaGenericEvent.java"


# instance fields
.field private genericValues:Ljava/util/Map;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "VALUE"
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 20
    invoke-direct {p0}, Lcom/comcast/playerplatform/analytics/java/xua/XuaBaseEvent;-><init>()V

    .line 24
    return-void
.end method

.method public constructor <init>(JLjava/lang/String;Ljava/util/Map;)V
    .locals 1
    .param p1, "timestamp"    # J
    .param p3, "eventName"    # Ljava/lang/String;
    .param p4, "xuaValue"    # Ljava/util/Map;

    .prologue
    .line 26
    invoke-direct {p0}, Lcom/comcast/playerplatform/analytics/java/xua/XuaBaseEvent;-><init>()V

    .line 27
    iput-wide p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaGenericEvent;->timeStamp:J

    .line 28
    iput-object p3, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaGenericEvent;->eventName:Ljava/lang/String;

    .line 29
    iput-object p4, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaGenericEvent;->genericValues:Ljava/util/Map;

    .line 30
    return-void
.end method


# virtual methods
.method public getGenericValues()Ljava/util/Map;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 34
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaGenericEvent;->genericValues:Ljava/util/Map;

    return-object v0
.end method

.method public setGenericValues(Ljava/util/Map;)V
    .locals 0
    .param p1, "genericValues"    # Ljava/util/Map;

    .prologue
    .line 38
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaGenericEvent;->genericValues:Ljava/util/Map;

    .line 39
    return-void
.end method
