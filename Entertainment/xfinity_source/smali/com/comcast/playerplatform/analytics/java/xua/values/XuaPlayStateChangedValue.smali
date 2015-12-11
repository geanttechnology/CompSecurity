.class public Lcom/comcast/playerplatform/analytics/java/xua/values/XuaPlayStateChangedValue;
.super Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;
.source "XuaPlayStateChangedValue.java"


# instance fields
.field private value:Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "VAL"
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
.method public getValue()Ljava/lang/String;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 23
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaPlayStateChangedValue;->value:Ljava/lang/String;

    return-object v0
.end method

.method public setValue(Ljava/lang/String;)V
    .locals 0
    .param p1, "value"    # Ljava/lang/String;

    .prologue
    .line 28
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaPlayStateChangedValue;->value:Ljava/lang/String;

    .line 29
    return-void
.end method
