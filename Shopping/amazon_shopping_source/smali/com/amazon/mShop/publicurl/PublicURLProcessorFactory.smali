.class public Lcom/amazon/mShop/publicurl/PublicURLProcessorFactory;
.super Ljava/lang/Object;
.source "PublicURLProcessorFactory.java"


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 23
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getInstance(Landroid/net/Uri;)Lcom/amazon/mShop/publicurl/PublicURLProcessor;
    .locals 6
    .param p0, "uri"    # Landroid/net/Uri;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/mShop/publicurl/PublicURLProcessException;
        }
    .end annotation

    .prologue
    const/4 v5, 0x1

    .line 26
    invoke-virtual {p0}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v0

    .line 27
    .local v0, "pathSegments":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v3

    if-lez v3, :cond_2

    const/4 v3, 0x0

    invoke-interface {v0, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    move-object v2, v3

    .line 28
    .local v2, "type":Ljava/lang/String;
    :goto_0
    const/4 v1, 0x0

    .line 29
    .local v1, "processor":Lcom/amazon/mShop/publicurl/PublicURLProcessor;
    if-eqz v2, :cond_0

    const-string/jumbo v3, ""

    invoke-virtual {v3, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_3

    .line 30
    :cond_0
    new-instance v1, Lcom/amazon/mShop/publicurl/HomeURLProcessor;

    .end local v1    # "processor":Lcom/amazon/mShop/publicurl/PublicURLProcessor;
    invoke-direct {v1, p0}, Lcom/amazon/mShop/publicurl/HomeURLProcessor;-><init>(Landroid/net/Uri;)V

    .line 51
    .restart local v1    # "processor":Lcom/amazon/mShop/publicurl/PublicURLProcessor;
    :cond_1
    :goto_1
    if-nez v1, :cond_b

    .line 52
    new-instance v3, Lcom/amazon/mShop/publicurl/PublicURLProcessException;

    sget-object v4, Lcom/amazon/mShop/publicurl/PublicURLProcessException$PublicURLErrorCode;->ERROR_CODE_ERROR_PATH:Lcom/amazon/mShop/publicurl/PublicURLProcessException$PublicURLErrorCode;

    invoke-direct {v3, v4}, Lcom/amazon/mShop/publicurl/PublicURLProcessException;-><init>(Lcom/amazon/mShop/publicurl/PublicURLProcessException$PublicURLErrorCode;)V

    throw v3

    .line 27
    .end local v1    # "processor":Lcom/amazon/mShop/publicurl/PublicURLProcessor;
    .end local v2    # "type":Ljava/lang/String;
    :cond_2
    const/4 v2, 0x0

    goto :goto_0

    .line 31
    .restart local v1    # "processor":Lcom/amazon/mShop/publicurl/PublicURLProcessor;
    .restart local v2    # "type":Ljava/lang/String;
    :cond_3
    const-string/jumbo v3, "products"

    invoke-virtual {v3, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_4

    .line 32
    new-instance v1, Lcom/amazon/mShop/publicurl/ProductURLProcessor;

    .end local v1    # "processor":Lcom/amazon/mShop/publicurl/PublicURLProcessor;
    invoke-direct {v1, p0}, Lcom/amazon/mShop/publicurl/ProductURLProcessor;-><init>(Landroid/net/Uri;)V

    .restart local v1    # "processor":Lcom/amazon/mShop/publicurl/PublicURLProcessor;
    goto :goto_1

    .line 33
    :cond_4
    const-string/jumbo v3, "cart"

    invoke-virtual {v3, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_5

    .line 34
    new-instance v1, Lcom/amazon/mShop/publicurl/CartURLProcessor;

    .end local v1    # "processor":Lcom/amazon/mShop/publicurl/PublicURLProcessor;
    invoke-direct {v1, p0}, Lcom/amazon/mShop/publicurl/CartURLProcessor;-><init>(Landroid/net/Uri;)V

    .restart local v1    # "processor":Lcom/amazon/mShop/publicurl/PublicURLProcessor;
    goto :goto_1

    .line 35
    :cond_5
    const-string/jumbo v3, "wishlists"

    invoke-virtual {v3, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_6

    .line 36
    new-instance v1, Lcom/amazon/mShop/publicurl/WishlistURLProcessor;

    .end local v1    # "processor":Lcom/amazon/mShop/publicurl/PublicURLProcessor;
    invoke-direct {v1, p0}, Lcom/amazon/mShop/publicurl/WishlistURLProcessor;-><init>(Landroid/net/Uri;)V

    .restart local v1    # "processor":Lcom/amazon/mShop/publicurl/PublicURLProcessor;
    goto :goto_1

    .line 37
    :cond_6
    const-string/jumbo v3, "orders"

    invoke-virtual {v3, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_7

    .line 38
    new-instance v1, Lcom/amazon/mShop/publicurl/OrderURLProcessor;

    .end local v1    # "processor":Lcom/amazon/mShop/publicurl/PublicURLProcessor;
    invoke-direct {v1, p0}, Lcom/amazon/mShop/publicurl/OrderURLProcessor;-><init>(Landroid/net/Uri;)V

    .restart local v1    # "processor":Lcom/amazon/mShop/publicurl/PublicURLProcessor;
    goto :goto_1

    .line 39
    :cond_7
    const-string/jumbo v3, "account"

    invoke-virtual {v3, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_9

    .line 40
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v3

    const/4 v4, 0x2

    if-lt v3, v4, :cond_8

    const-string/jumbo v3, "notifications"

    invoke-interface {v0, v5}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_8

    .line 41
    new-instance v1, Lcom/amazon/mShop/publicurl/PushNotificationsURLProcessor;

    .end local v1    # "processor":Lcom/amazon/mShop/publicurl/PublicURLProcessor;
    invoke-direct {v1, p0}, Lcom/amazon/mShop/publicurl/PushNotificationsURLProcessor;-><init>(Landroid/net/Uri;)V

    .restart local v1    # "processor":Lcom/amazon/mShop/publicurl/PublicURLProcessor;
    goto :goto_1

    .line 42
    :cond_8
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v3

    if-ne v3, v5, :cond_1

    .line 43
    new-instance v1, Lcom/amazon/mShop/publicurl/YourAccountURLProcssor;

    .end local v1    # "processor":Lcom/amazon/mShop/publicurl/PublicURLProcessor;
    invoke-direct {v1, p0}, Lcom/amazon/mShop/publicurl/YourAccountURLProcssor;-><init>(Landroid/net/Uri;)V

    .restart local v1    # "processor":Lcom/amazon/mShop/publicurl/PublicURLProcessor;
    goto :goto_1

    .line 45
    :cond_9
    const-string/jumbo v3, "recommendations"

    invoke-virtual {v3, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_a

    .line 46
    new-instance v1, Lcom/amazon/mShop/publicurl/RecommendationsURLProcessor;

    .end local v1    # "processor":Lcom/amazon/mShop/publicurl/PublicURLProcessor;
    invoke-direct {v1, p0}, Lcom/amazon/mShop/publicurl/RecommendationsURLProcessor;-><init>(Landroid/net/Uri;)V

    .restart local v1    # "processor":Lcom/amazon/mShop/publicurl/PublicURLProcessor;
    goto/16 :goto_1

    .line 47
    :cond_a
    const-string/jumbo v3, "deals"

    invoke-virtual {v3, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 48
    new-instance v1, Lcom/amazon/mShop/publicurl/DealsURLProcessor;

    .end local v1    # "processor":Lcom/amazon/mShop/publicurl/PublicURLProcessor;
    invoke-direct {v1, p0}, Lcom/amazon/mShop/publicurl/DealsURLProcessor;-><init>(Landroid/net/Uri;)V

    .restart local v1    # "processor":Lcom/amazon/mShop/publicurl/PublicURLProcessor;
    goto/16 :goto_1

    .line 54
    :cond_b
    return-object v1
.end method
