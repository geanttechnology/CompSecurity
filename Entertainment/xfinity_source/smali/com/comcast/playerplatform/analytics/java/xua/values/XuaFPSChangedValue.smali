.class public Lcom/comcast/playerplatform/analytics/java/xua/values/XuaFPSChangedValue;
.super Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;
.source "XuaFPSChangedValue.java"


# instance fields
.field private value:F
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "XFS"
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
.method public getValue()F
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 22
    iget v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaFPSChangedValue;->value:F

    return v0
.end method

.method public setValue(F)V
    .locals 0
    .param p1, "value"    # F

    .prologue
    .line 26
    iput p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaFPSChangedValue;->value:F

    .line 27
    return-void
.end method
