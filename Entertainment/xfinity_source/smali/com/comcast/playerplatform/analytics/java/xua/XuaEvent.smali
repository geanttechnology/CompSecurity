.class public Lcom/comcast/playerplatform/analytics/java/xua/XuaEvent;
.super Lcom/comcast/playerplatform/analytics/java/xua/XuaBaseEvent;
.source "XuaEvent.java"


# annotations
.annotation runtime Lcom/fasterxml/jackson/annotation/JsonInclude;
    value = .enum Lcom/fasterxml/jackson/annotation/JsonInclude$Include;->NON_NULL:Lcom/fasterxml/jackson/annotation/JsonInclude$Include;
.end annotation


# instance fields
.field private value:Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "VALUE"
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 21
    invoke-direct {p0}, Lcom/comcast/playerplatform/analytics/java/xua/XuaBaseEvent;-><init>()V

    .line 25
    return-void
.end method

.method public constructor <init>(JLjava/lang/String;Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;)V
    .locals 1
    .param p1, "timestamp"    # J
    .param p3, "eventName"    # Ljava/lang/String;
    .param p4, "xuaValue"    # Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;

    .prologue
    .line 27
    invoke-direct {p0}, Lcom/comcast/playerplatform/analytics/java/xua/XuaBaseEvent;-><init>()V

    .line 28
    iput-wide p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaEvent;->timeStamp:J

    .line 29
    iput-object p3, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaEvent;->eventName:Ljava/lang/String;

    .line 30
    iput-object p4, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaEvent;->value:Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;

    .line 31
    return-void
.end method


# virtual methods
.method public getValue()Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 36
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaEvent;->value:Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;

    return-object v0
.end method

.method public setValue(Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;)V
    .locals 0
    .param p1, "value"    # Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;

    .prologue
    .line 41
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaEvent;->value:Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;

    .line 42
    return-void
.end method
