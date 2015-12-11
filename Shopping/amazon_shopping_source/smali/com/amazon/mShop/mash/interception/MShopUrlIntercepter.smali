.class public Lcom/amazon/mShop/mash/interception/MShopUrlIntercepter;
.super Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter;
.source "MShopUrlIntercepter.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/mash/interception/MShopUrlIntercepter$1;
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter;-><init>()V

    .line 44
    return-void
.end method


# virtual methods
.method public buildHandler(Ljava/lang/String;Landroid/content/Context;)Lcom/amazon/mobile/mash/interception/UrlInterceptionHandler;
    .locals 5
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    const/4 v2, 0x0

    .line 22
    invoke-static {p1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 23
    .local v1, "uri":Landroid/net/Uri;
    invoke-virtual {p0, v1}, Lcom/amazon/mShop/mash/interception/MShopUrlIntercepter;->getConfigEntryForUri(Landroid/net/Uri;)Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;

    move-result-object v0

    .line 24
    .local v0, "configEntry":Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;
    if-nez v0, :cond_0

    .line 46
    :goto_0
    return-object v2

    .line 28
    :cond_0
    sget-object v3, Lcom/amazon/mShop/mash/interception/MShopUrlIntercepter$1;->$SwitchMap$com$amazon$mobile$mash$interception$MASHUrlIntercepter$UrlDestination:[I

    invoke-virtual {v0}, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;->getDestination()Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;

    move-result-object v4

    invoke-virtual {v4}, Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;->ordinal()I

    move-result v4

    aget v3, v3, v4

    packed-switch v3, :pswitch_data_0

    goto :goto_0

    .line 30
    :pswitch_0
    new-instance v2, Lcom/amazon/mShop/mash/interception/HomeInterceptionHandler;

    invoke-direct {v2, p2, v1, v0}, Lcom/amazon/mShop/mash/interception/HomeInterceptionHandler;-><init>(Landroid/content/Context;Landroid/net/Uri;Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;)V

    goto :goto_0

    .line 32
    :pswitch_1
    new-instance v2, Lcom/amazon/mShop/mash/interception/SearchInterceptionHandler;

    invoke-direct {v2, p2, v1, v0}, Lcom/amazon/mShop/mash/interception/SearchInterceptionHandler;-><init>(Landroid/content/Context;Landroid/net/Uri;Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;)V

    goto :goto_0

    .line 34
    :pswitch_2
    new-instance v2, Lcom/amazon/mShop/mash/interception/BrowseInterceptionHandler;

    invoke-direct {v2, p2, v1, v0}, Lcom/amazon/mShop/mash/interception/BrowseInterceptionHandler;-><init>(Landroid/content/Context;Landroid/net/Uri;Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;)V

    goto :goto_0

    .line 36
    :pswitch_3
    new-instance v2, Lcom/amazon/mShop/mash/interception/CartInterceptionHandler;

    invoke-direct {v2, p2, v1, v0}, Lcom/amazon/mShop/mash/interception/CartInterceptionHandler;-><init>(Landroid/content/Context;Landroid/net/Uri;Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;)V

    goto :goto_0

    .line 38
    :pswitch_4
    new-instance v2, Lcom/amazon/mShop/mash/interception/DetailInterceptionHandler;

    invoke-direct {v2, p2, v1, v0}, Lcom/amazon/mShop/mash/interception/DetailInterceptionHandler;-><init>(Landroid/content/Context;Landroid/net/Uri;Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;)V

    goto :goto_0

    .line 40
    :pswitch_5
    new-instance v2, Lcom/amazon/mShop/mash/interception/CheckoutInterceptionHandler;

    invoke-direct {v2, p2, v1, v0}, Lcom/amazon/mShop/mash/interception/CheckoutInterceptionHandler;-><init>(Landroid/content/Context;Landroid/net/Uri;Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;)V

    goto :goto_0

    .line 42
    :pswitch_6
    new-instance v2, Lcom/amazon/mShop/mash/interception/AppStoreInterceptionHandler;

    invoke-direct {v2, p2, v1, v0}, Lcom/amazon/mShop/mash/interception/AppStoreInterceptionHandler;-><init>(Landroid/content/Context;Landroid/net/Uri;Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;)V

    goto :goto_0

    .line 28
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
    .end packed-switch
.end method
