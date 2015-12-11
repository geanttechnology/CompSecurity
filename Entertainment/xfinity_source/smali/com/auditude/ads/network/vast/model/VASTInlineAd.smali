.class public Lcom/auditude/ads/network/vast/model/VASTInlineAd;
.super Lcom/auditude/ads/network/vast/model/VASTAdBase;
.source "VASTInlineAd.java"


# instance fields
.field public adTitle:Ljava/lang/String;

.field public asInvalideXML:Ljava/lang/Boolean;

.field private companionAds:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/auditude/ads/network/vast/model/VASTCompanionCreative;",
            ">;"
        }
    .end annotation
.end field

.field public companionRequired:Ljava/lang/String;

.field public description:Ljava/lang/String;

.field public linearAd:Lcom/auditude/ads/network/vast/model/VASTLinearCreative;

.field private nonLinearAds:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/auditude/ads/network/vast/model/VASTNonLinearCreative;",
            ">;"
        }
    .end annotation
.end field

.field public surveyUrl:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 5
    invoke-direct {p0}, Lcom/auditude/ads/network/vast/model/VASTAdBase;-><init>()V

    .line 11
    const/4 v0, 0x0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/auditude/ads/network/vast/model/VASTInlineAd;->asInvalideXML:Ljava/lang/Boolean;

    .line 12
    const-string v0, "none"

    iput-object v0, p0, Lcom/auditude/ads/network/vast/model/VASTInlineAd;->companionRequired:Ljava/lang/String;

    .line 5
    return-void
.end method


# virtual methods
.method public final addCompanionAd(Lcom/auditude/ads/network/vast/model/VASTCompanionCreative;)V
    .locals 1
    .param p1, "creative"    # Lcom/auditude/ads/network/vast/model/VASTCompanionCreative;

    .prologue
    .line 29
    if-nez p1, :cond_0

    .line 39
    :goto_0
    return-void

    .line 34
    :cond_0
    iget-object v0, p0, Lcom/auditude/ads/network/vast/model/VASTInlineAd;->companionAds:Ljava/util/ArrayList;

    if-nez v0, :cond_1

    .line 36
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/auditude/ads/network/vast/model/VASTInlineAd;->companionAds:Ljava/util/ArrayList;

    .line 38
    :cond_1
    iget-object v0, p0, Lcom/auditude/ads/network/vast/model/VASTInlineAd;->companionAds:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0
.end method

.method public final addNonLinearAd(Lcom/auditude/ads/network/vast/model/VASTNonLinearCreative;)V
    .locals 1
    .param p1, "creative"    # Lcom/auditude/ads/network/vast/model/VASTNonLinearCreative;

    .prologue
    .line 43
    if-nez p1, :cond_0

    .line 50
    :goto_0
    return-void

    .line 45
    :cond_0
    iget-object v0, p0, Lcom/auditude/ads/network/vast/model/VASTInlineAd;->nonLinearAds:Ljava/util/ArrayList;

    if-nez v0, :cond_1

    .line 47
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/auditude/ads/network/vast/model/VASTInlineAd;->nonLinearAds:Ljava/util/ArrayList;

    .line 49
    :cond_1
    iget-object v0, p0, Lcom/auditude/ads/network/vast/model/VASTInlineAd;->nonLinearAds:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0
.end method

.method public final getCompanionAds()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/auditude/ads/network/vast/model/VASTCompanionCreative;",
            ">;"
        }
    .end annotation

    .prologue
    .line 19
    iget-object v0, p0, Lcom/auditude/ads/network/vast/model/VASTInlineAd;->companionAds:Ljava/util/ArrayList;

    return-object v0
.end method

.method public final getNonLinearAds()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/auditude/ads/network/vast/model/VASTNonLinearCreative;",
            ">;"
        }
    .end annotation

    .prologue
    .line 24
    iget-object v0, p0, Lcom/auditude/ads/network/vast/model/VASTInlineAd;->nonLinearAds:Ljava/util/ArrayList;

    return-object v0
.end method

.method public setNonLinearAdTrackingEvents(Ljava/util/ArrayList;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/auditude/ads/network/vast/model/VASTTrackingEvent;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 55
    .local p1, "value":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/auditude/ads/network/vast/model/VASTTrackingEvent;>;"
    iget-object v1, p0, Lcom/auditude/ads/network/vast/model/VASTInlineAd;->nonLinearAds:Ljava/util/ArrayList;

    if-eqz v1, :cond_0

    .line 57
    iget-object v1, p0, Lcom/auditude/ads/network/vast/model/VASTInlineAd;->nonLinearAds:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-nez v2, :cond_1

    .line 62
    :cond_0
    return-void

    .line 57
    :cond_1
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/auditude/ads/network/vast/model/VASTNonLinearCreative;

    .line 59
    .local v0, "nonLinearCreative":Lcom/auditude/ads/network/vast/model/VASTNonLinearCreative;
    invoke-virtual {v0, p1}, Lcom/auditude/ads/network/vast/model/VASTNonLinearCreative;->setTrackingEvents(Ljava/util/ArrayList;)V

    goto :goto_0
.end method
