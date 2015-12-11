.class public Lcom/amazon/mShop/publicurl/RecommendationsURLProcessor;
.super Lcom/amazon/mShop/publicurl/PublicURLProcessor;
.source "RecommendationsURLProcessor.java"


# direct methods
.method public constructor <init>(Landroid/net/Uri;)V
    .locals 0
    .param p1, "uri"    # Landroid/net/Uri;

    .prologue
    .line 15
    invoke-direct {p0, p1}, Lcom/amazon/mShop/publicurl/PublicURLProcessor;-><init>(Landroid/net/Uri;)V

    .line 16
    return-void
.end method


# virtual methods
.method protected doProcess(Landroid/content/Context;)V
    .locals 4
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 20
    iget-object v2, p0, Lcom/amazon/mShop/publicurl/RecommendationsURLProcessor;->mUri:Landroid/net/Uri;

    const-string/jumbo v3, "node"

    invoke-virtual {v2, v3}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 21
    .local v0, "browseNode":Ljava/lang/String;
    iget-object v2, p0, Lcom/amazon/mShop/publicurl/RecommendationsURLProcessor;->mUri:Landroid/net/Uri;

    const-string/jumbo v3, "category_display_name"

    invoke-virtual {v2, v3}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 22
    .local v1, "categoryDisplayName":Ljava/lang/String;
    sget-object v2, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_NOTIFICATION:Lcom/amazon/mShop/control/item/ClickStreamTag;

    invoke-virtual {v2}, Lcom/amazon/mShop/control/item/ClickStreamTag;->getTag()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0}, Lcom/amazon/mShop/publicurl/RecommendationsURLProcessor;->getOrigin()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 23
    const-string/jumbo v2, "pn_recs_t"

    invoke-static {v2}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 26
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/mShop/publicurl/RecommendationsURLProcessor;->getParams()Ljava/util/Map;

    move-result-object v2

    invoke-static {p1, v2}, Lcom/amazon/mShop/util/ActivityUtils;->startRecommendationsActivity(Landroid/content/Context;Ljava/util/Map;)Z

    .line 27
    return-void
.end method

.method public getMetricIdentity()Ljava/lang/String;
    .locals 1

    .prologue
    .line 31
    const-string/jumbo v0, "Recommendation"

    return-object v0
.end method
