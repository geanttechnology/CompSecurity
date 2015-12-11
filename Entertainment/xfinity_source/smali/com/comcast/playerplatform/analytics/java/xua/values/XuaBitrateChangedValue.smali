.class public Lcom/comcast/playerplatform/analytics/java/xua/values/XuaBitrateChangedValue;
.super Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;
.source "XuaBitrateChangedValue.java"


# instance fields
.field private value:J
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "XBR"
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 15
    invoke-direct {p0}, Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;-><init>()V

    return-void
.end method


# virtual methods
.method public getValue()J
    .locals 2
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 22
    iget-wide v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaBitrateChangedValue;->value:J

    return-wide v0
.end method

.method public setValue(J)V
    .locals 1
    .param p1, "value"    # J

    .prologue
    .line 26
    iput-wide p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaBitrateChangedValue;->value:J

    .line 27
    return-void
.end method
