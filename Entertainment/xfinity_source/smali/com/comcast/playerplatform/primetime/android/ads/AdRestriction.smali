.class public Lcom/comcast/playerplatform/primetime/android/ads/AdRestriction;
.super Ljava/lang/Object;
.source "AdRestriction.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/comcast/playerplatform/primetime/android/ads/AdRestriction$RestrictionType;
    }
.end annotation


# instance fields
.field private id:Ljava/lang/String;

.field private isRestricted:Z

.field private type:Lcom/comcast/playerplatform/primetime/android/ads/AdRestriction$RestrictionType;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p1, "id"    # Ljava/lang/String;
    .param p2, "type"    # Ljava/lang/String;
    .param p3, "limit"    # Ljava/lang/String;

    .prologue
    const/4 v2, 0x1

    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 14
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/ads/AdRestriction;->id:Ljava/lang/String;

    .line 15
    invoke-virtual {p2}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v0

    const-string v1, "pause"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 16
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/ads/AdRestriction$RestrictionType;->PAUSE:Lcom/comcast/playerplatform/primetime/android/ads/AdRestriction$RestrictionType;

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/AdRestriction;->type:Lcom/comcast/playerplatform/primetime/android/ads/AdRestriction$RestrictionType;

    .line 17
    iput-boolean v2, p0, Lcom/comcast/playerplatform/primetime/android/ads/AdRestriction;->isRestricted:Z

    .line 25
    :goto_0
    invoke-static {p3}, Lcom/comcast/playerplatform/util/android/StringUtil;->isNotNullOrEmpty(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p3}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v0

    const-string v1, "always"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 26
    iput-boolean v2, p0, Lcom/comcast/playerplatform/primetime/android/ads/AdRestriction;->isRestricted:Z

    .line 28
    :cond_0
    return-void

    .line 18
    :cond_1
    invoke-virtual {p2}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v0

    const-string v1, "fastforward"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 19
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/ads/AdRestriction$RestrictionType;->SEEK:Lcom/comcast/playerplatform/primetime/android/ads/AdRestriction$RestrictionType;

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/AdRestriction;->type:Lcom/comcast/playerplatform/primetime/android/ads/AdRestriction$RestrictionType;

    .line 20
    iput-boolean v2, p0, Lcom/comcast/playerplatform/primetime/android/ads/AdRestriction;->isRestricted:Z

    goto :goto_0

    .line 22
    :cond_2
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/ads/AdRestriction$RestrictionType;->NONE:Lcom/comcast/playerplatform/primetime/android/ads/AdRestriction$RestrictionType;

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/AdRestriction;->type:Lcom/comcast/playerplatform/primetime/android/ads/AdRestriction$RestrictionType;

    goto :goto_0
.end method


# virtual methods
.method public getId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 31
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/AdRestriction;->id:Ljava/lang/String;

    return-object v0
.end method

.method public getType()Lcom/comcast/playerplatform/primetime/android/ads/AdRestriction$RestrictionType;
    .locals 1

    .prologue
    .line 35
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/AdRestriction;->type:Lcom/comcast/playerplatform/primetime/android/ads/AdRestriction$RestrictionType;

    return-object v0
.end method

.method public isRestricted()Z
    .locals 1

    .prologue
    .line 39
    iget-boolean v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/AdRestriction;->isRestricted:Z

    return v0
.end method
