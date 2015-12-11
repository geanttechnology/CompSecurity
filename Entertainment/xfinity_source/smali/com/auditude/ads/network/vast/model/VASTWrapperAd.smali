.class public Lcom/auditude/ads/network/vast/model/VASTWrapperAd;
.super Lcom/auditude/ads/network/vast/model/VASTInlineAd;
.source "VASTWrapperAd.java"


# instance fields
.field public allowMultipleAds:Ljava/lang/String;

.field public fallbackOnNoAd:Ljava/lang/String;

.field public followAdditionalWrappers:Ljava/lang/Boolean;

.field public source:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 3
    invoke-direct {p0}, Lcom/auditude/ads/network/vast/model/VASTInlineAd;-><init>()V

    .line 6
    const/4 v0, 0x1

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/auditude/ads/network/vast/model/VASTWrapperAd;->followAdditionalWrappers:Ljava/lang/Boolean;

    .line 7
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/auditude/ads/network/vast/model/VASTWrapperAd;->fallbackOnNoAd:Ljava/lang/String;

    .line 3
    return-void
.end method
