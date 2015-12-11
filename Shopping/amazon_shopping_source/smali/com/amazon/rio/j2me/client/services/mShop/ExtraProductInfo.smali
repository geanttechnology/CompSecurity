.class public Lcom/amazon/rio/j2me/client/services/mShop/ExtraProductInfo;
.super Ljava/lang/Object;
.source "ExtraProductInfo.java"


# instance fields
.field private customerReviewsInfo:Lcom/amazon/rio/j2me/client/services/mShop/CustomerReviewsInfo;

.field private descs:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/KeyValuePair;",
            ">;"
        }
    .end annotation
.end field

.field private details:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/KeyValuePair;",
            ">;"
        }
    .end annotation
.end field

.field private offerListSummaries:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/ConditionalOffersSummary;",
            ">;"
        }
    .end annotation
.end field

.field private offers:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/OfferListing;",
            ">;"
        }
    .end annotation
.end field

.field private productMessages:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/HyperText;",
            ">;"
        }
    .end annotation
.end field

.field private productWarnings:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/ProductWarning;",
            ">;"
        }
    .end annotation
.end field

.field private similarItems:Lcom/amazon/rio/j2me/client/services/mShop/SimilarItemsResponse;

.field private trackListings:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/DiscListing;",
            ">;"
        }
    .end annotation
.end field

.field private videoClips:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/VideoClip;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getOfferListSummaries()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/ConditionalOffersSummary;",
            ">;"
        }
    .end annotation

    .prologue
    .line 59
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/ExtraProductInfo;->offerListSummaries:Ljava/util/List;

    return-object v0
.end method

.method public setCustomerReviewsInfo(Lcom/amazon/rio/j2me/client/services/mShop/CustomerReviewsInfo;)V
    .locals 0
    .param p1, "value_"    # Lcom/amazon/rio/j2me/client/services/mShop/CustomerReviewsInfo;

    .prologue
    .line 34
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ExtraProductInfo;->customerReviewsInfo:Lcom/amazon/rio/j2me/client/services/mShop/CustomerReviewsInfo;

    .line 35
    return-void
.end method

.method public setDescs(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/KeyValuePair;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 54
    .local p1, "value_":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/KeyValuePair;>;"
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ExtraProductInfo;->descs:Ljava/util/List;

    .line 55
    return-void
.end method

.method public setDetails(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/KeyValuePair;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 44
    .local p1, "value_":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/KeyValuePair;>;"
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ExtraProductInfo;->details:Ljava/util/List;

    .line 45
    return-void
.end method

.method public setOfferListSummaries(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/ConditionalOffersSummary;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 64
    .local p1, "value_":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/ConditionalOffersSummary;>;"
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ExtraProductInfo;->offerListSummaries:Ljava/util/List;

    .line 65
    return-void
.end method

.method public setOffers(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/OfferListing;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 74
    .local p1, "value_":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/OfferListing;>;"
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ExtraProductInfo;->offers:Ljava/util/List;

    .line 75
    return-void
.end method

.method public setProductMessages(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/HyperText;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 87
    .local p1, "value_":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/HyperText;>;"
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ExtraProductInfo;->productMessages:Ljava/util/List;

    .line 88
    return-void
.end method

.method public setProductWarnings(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/ProductWarning;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 100
    .local p1, "value_":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/ProductWarning;>;"
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ExtraProductInfo;->productWarnings:Ljava/util/List;

    .line 101
    return-void
.end method

.method public setSimilarItems(Lcom/amazon/rio/j2me/client/services/mShop/SimilarItemsResponse;)V
    .locals 0
    .param p1, "value_"    # Lcom/amazon/rio/j2me/client/services/mShop/SimilarItemsResponse;

    .prologue
    .line 113
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ExtraProductInfo;->similarItems:Lcom/amazon/rio/j2me/client/services/mShop/SimilarItemsResponse;

    .line 114
    return-void
.end method

.method public setTrackListings(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/DiscListing;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 139
    .local p1, "value_":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/DiscListing;>;"
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ExtraProductInfo;->trackListings:Ljava/util/List;

    .line 140
    return-void
.end method

.method public setVideoClips(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/VideoClip;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 126
    .local p1, "value_":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/VideoClip;>;"
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ExtraProductInfo;->videoClips:Ljava/util/List;

    .line 127
    return-void
.end method
