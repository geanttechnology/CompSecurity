.class public Lcom/comcast/playerplatform/analytics/java/xua/values/XuaScrubValue;
.super Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;
.source "XuaScrubValue.java"


# annotations
.annotation runtime Lcom/fasterxml/jackson/databind/annotation/JsonSerialize;
    include = .enum Lcom/fasterxml/jackson/databind/annotation/JsonSerialize$Inclusion;->NON_NULL:Lcom/fasterxml/jackson/databind/annotation/JsonSerialize$Inclusion;
.end annotation


# instance fields
.field private position:J
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "POS"
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 17
    invoke-direct {p0}, Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;-><init>()V

    return-void
.end method


# virtual methods
.method public getPosition()J
    .locals 2
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 24
    iget-wide v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaScrubValue;->position:J

    return-wide v0
.end method

.method public setPosition(J)V
    .locals 1
    .param p1, "position"    # J

    .prologue
    .line 28
    iput-wide p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaScrubValue;->position:J

    .line 29
    return-void
.end method
