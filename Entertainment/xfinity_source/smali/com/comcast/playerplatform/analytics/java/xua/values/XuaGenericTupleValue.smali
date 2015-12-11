.class public Lcom/comcast/playerplatform/analytics/java/xua/values/XuaGenericTupleValue;
.super Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;
.source "XuaGenericTupleValue.java"


# annotations
.annotation runtime Lcom/fasterxml/jackson/annotation/JsonInclude;
    value = .enum Lcom/fasterxml/jackson/annotation/JsonInclude$Include;->NON_NULL:Lcom/fasterxml/jackson/annotation/JsonInclude$Include;
.end annotation


# instance fields
.field private value:Ljava/util/Map;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "DIC"
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 19
    invoke-direct {p0}, Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;-><init>()V

    return-void
.end method


# virtual methods
.method public getValue()Ljava/util/Map;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 27
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaGenericTupleValue;->value:Ljava/util/Map;

    return-object v0
.end method

.method public setValue(Ljava/util/Map;)V
    .locals 0
    .param p1, "value"    # Ljava/util/Map;

    .prologue
    .line 32
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaGenericTupleValue;->value:Ljava/util/Map;

    .line 33
    return-void
.end method
