.class public Lcom/comcast/playerplatform/analytics/java/xua/values/XuaMediaOpenedValue;
.super Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;
.source "XuaMediaOpenedValue.java"


# annotations
.annotation runtime Lcom/fasterxml/jackson/databind/annotation/JsonSerialize;
    include = .enum Lcom/fasterxml/jackson/databind/annotation/JsonSerialize$Inclusion;->NON_NULL:Lcom/fasterxml/jackson/databind/annotation/JsonSerialize$Inclusion;
.end annotation


# instance fields
.field private latency:Ljava/lang/Long;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "LAT"
    .end annotation
.end field

.field private manifestUrl:Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "MANIF"
    .end annotation
.end field

.field private position:J
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "POS"
    .end annotation
.end field


# direct methods
.method public constructor <init>(JLjava/lang/Long;Ljava/lang/String;)V
    .locals 1
    .param p1, "position"    # J
    .param p3, "latency"    # Ljava/lang/Long;
    .param p4, "manifestUrl"    # Ljava/lang/String;

    .prologue
    .line 28
    invoke-direct {p0}, Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;-><init>()V

    .line 29
    iput-wide p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaMediaOpenedValue;->position:J

    .line 30
    iput-object p3, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaMediaOpenedValue;->latency:Ljava/lang/Long;

    .line 31
    iput-object p4, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaMediaOpenedValue;->manifestUrl:Ljava/lang/String;

    .line 32
    return-void
.end method


# virtual methods
.method public getLatency()Ljava/lang/Long;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 48
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaMediaOpenedValue;->latency:Ljava/lang/Long;

    return-object v0
.end method

.method public getManifestUrl()Ljava/lang/String;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 58
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaMediaOpenedValue;->manifestUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getPosition()J
    .locals 2
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 37
    iget-wide v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaMediaOpenedValue;->position:J

    return-wide v0
.end method

.method public setLatency(Ljava/lang/Long;)V
    .locals 0
    .param p1, "latency"    # Ljava/lang/Long;

    .prologue
    .line 53
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaMediaOpenedValue;->latency:Ljava/lang/Long;

    .line 54
    return-void
.end method

.method public setManifestUrl(Ljava/lang/String;)V
    .locals 0
    .param p1, "manifestUrl"    # Ljava/lang/String;

    .prologue
    .line 62
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaMediaOpenedValue;->manifestUrl:Ljava/lang/String;

    .line 63
    return-void
.end method

.method public setPosition(J)V
    .locals 1
    .param p1, "position"    # J

    .prologue
    .line 42
    iput-wide p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaMediaOpenedValue;->position:J

    .line 43
    return-void
.end method
