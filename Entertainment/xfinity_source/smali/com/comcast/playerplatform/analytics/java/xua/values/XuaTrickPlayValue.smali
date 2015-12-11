.class public Lcom/comcast/playerplatform/analytics/java/xua/values/XuaTrickPlayValue;
.super Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;
.source "XuaTrickPlayValue.java"


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

.field private type:Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "TYPE"
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
    .line 28
    iget-wide v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaTrickPlayValue;->position:J

    return-wide v0
.end method

.method public getType()Ljava/lang/String;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 38
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaTrickPlayValue;->type:Ljava/lang/String;

    return-object v0
.end method

.method public setPosition(J)V
    .locals 1
    .param p1, "position"    # J

    .prologue
    .line 33
    iput-wide p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaTrickPlayValue;->position:J

    .line 34
    return-void
.end method

.method public setType(Ljava/lang/String;)V
    .locals 0
    .param p1, "type"    # Ljava/lang/String;

    .prologue
    .line 42
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaTrickPlayValue;->type:Ljava/lang/String;

    .line 43
    return-void
.end method
