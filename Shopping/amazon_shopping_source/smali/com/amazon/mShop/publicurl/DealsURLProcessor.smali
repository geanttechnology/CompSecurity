.class public Lcom/amazon/mShop/publicurl/DealsURLProcessor;
.super Lcom/amazon/mShop/publicurl/PublicURLProcessor;
.source "DealsURLProcessor.java"


# direct methods
.method public constructor <init>(Landroid/net/Uri;)V
    .locals 0
    .param p1, "uri"    # Landroid/net/Uri;

    .prologue
    .line 13
    invoke-direct {p0, p1}, Lcom/amazon/mShop/publicurl/PublicURLProcessor;-><init>(Landroid/net/Uri;)V

    .line 14
    return-void
.end method


# virtual methods
.method protected doProcess(Landroid/content/Context;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/mShop/publicurl/PublicURLProcessException;
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    .line 19
    invoke-static {}, Lcom/amazon/mShop/util/ActivityUtils;->isPublicURLDealsEnabled()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 21
    invoke-virtual {p0}, Lcom/amazon/mShop/publicurl/DealsURLProcessor;->getParams()Ljava/util/Map;

    move-result-object v0

    const/4 v1, 0x1

    invoke-static {p1, v2, v2, v0, v1}, Lcom/amazon/mShop/util/ActivityUtils;->startDealsActivity(Landroid/content/Context;Lcom/amazon/mShop/goldbox/GoldboxLaunchParamters;Ljava/lang/String;Ljava/util/Map;Z)Z

    .line 27
    return-void

    .line 25
    :cond_0
    new-instance v0, Lcom/amazon/mShop/publicurl/PublicURLProcessException;

    sget-object v1, Lcom/amazon/mShop/publicurl/PublicURLProcessException$PublicURLErrorCode;->ERROR_CODE_ERROR_PATH:Lcom/amazon/mShop/publicurl/PublicURLProcessException$PublicURLErrorCode;

    invoke-direct {v0, v1}, Lcom/amazon/mShop/publicurl/PublicURLProcessException;-><init>(Lcom/amazon/mShop/publicurl/PublicURLProcessException$PublicURLErrorCode;)V

    throw v0
.end method

.method public getMetricIdentity()Ljava/lang/String;
    .locals 1

    .prologue
    .line 31
    const-string/jumbo v0, "DEALS"

    return-object v0
.end method
