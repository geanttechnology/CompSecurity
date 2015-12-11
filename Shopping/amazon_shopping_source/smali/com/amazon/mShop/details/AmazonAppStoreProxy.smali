.class public Lcom/amazon/mShop/details/AmazonAppStoreProxy;
.super Lcom/amazon/mShop/details/FriendAppProxy;
.source "AmazonAppStoreProxy.java"


# static fields
.field private static final instance:Lcom/amazon/mShop/details/AmazonAppStoreProxy;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 18
    new-instance v0, Lcom/amazon/mShop/details/AmazonAppStoreProxy;

    invoke-direct {v0}, Lcom/amazon/mShop/details/AmazonAppStoreProxy;-><init>()V

    sput-object v0, Lcom/amazon/mShop/details/AmazonAppStoreProxy;->instance:Lcom/amazon/mShop/details/AmazonAppStoreProxy;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 16
    invoke-direct {p0}, Lcom/amazon/mShop/details/FriendAppProxy;-><init>()V

    return-void
.end method

.method public static getInstance()Lcom/amazon/mShop/details/AmazonAppStoreProxy;
    .locals 1

    .prologue
    .line 28
    sget-object v0, Lcom/amazon/mShop/details/AmazonAppStoreProxy;->instance:Lcom/amazon/mShop/details/AmazonAppStoreProxy;

    return-object v0
.end method


# virtual methods
.method public getButtonLabel(Landroid/content/Context;)Ljava/lang/String;
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 76
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/details/AmazonAppStoreProxy;->isFriendAppInstalled(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 77
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->buy_box_buy_now_from_amazon_appstore:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 80
    :goto_0
    return-object v0

    :cond_0
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->buy_box_install_amazon_appstore_to_buy:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public getIntentForInstall(Landroid/content/Context;)Landroid/content/Intent;
    .locals 4
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 65
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/amazon/mShop/android/lib/R$string;->amazon_appstore_landing_page_url:I

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 66
    .local v1, "landingPage":Ljava/lang/String;
    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 67
    const-string/jumbo v2, "Amazon.AmazonAppStoreProxy"

    const-string/jumbo v3, "landing page is empty."

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 68
    const/4 v0, 0x0

    .line 71
    :goto_0
    return-object v0

    .line 70
    :cond_0
    new-instance v0, Landroid/content/Intent;

    const-string/jumbo v2, "android.intent.action.VIEW"

    invoke-static {v1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v3

    invoke-direct {v0, v2, v3}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 71
    .local v0, "intent":Landroid/content/Intent;
    goto :goto_0
.end method

.method protected getIntentForStart(Landroid/content/Context;Lcom/amazon/mShop/control/item/ProductController;)Landroid/content/Intent;
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "product"    # Lcom/amazon/mShop/control/item/ProductController;

    .prologue
    .line 38
    const/4 v0, 0x0

    invoke-virtual {p2}, Lcom/amazon/mShop/control/item/ProductController;->getAsin()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, p1, v0, v1}, Lcom/amazon/mShop/details/AmazonAppStoreProxy;->getIntentForStart(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v0

    return-object v0
.end method

.method protected getIntentForStart(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;
    .locals 4
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    const/4 v2, 0x0

    .line 53
    invoke-virtual {p2}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 54
    .local v1, "uri":Landroid/net/Uri;
    const-string/jumbo v3, "asin"

    invoke-virtual {v1, v3}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 55
    .local v0, "asin":Ljava/lang/String;
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 57
    sget v3, Lcom/amazon/mShop/android/lib/R$string;->error_can_not_find_product:I

    invoke-static {p1, v3}, Lcom/amazon/mShop/util/UIUtils;->info(Landroid/content/Context;I)V

    .line 60
    :goto_0
    return-object v2

    :cond_0
    invoke-virtual {p0, p1, v2, v0}, Lcom/amazon/mShop/details/AmazonAppStoreProxy;->getIntentForStart(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v2

    goto :goto_0
.end method

.method public getIntentForStart(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    .locals 5
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "groupId"    # Ljava/lang/String;
    .param p3, "asin"    # Ljava/lang/String;

    .prologue
    .line 43
    const-string/jumbo v2, "amzn://apps/android?asin=%s"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p3, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 44
    .local v1, "uri":Landroid/net/Uri;
    new-instance v0, Landroid/content/Intent;

    const-string/jumbo v2, "android.intent.action.VIEW"

    invoke-direct {v0, v2, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 46
    .local v0, "intent":Landroid/content/Intent;
    invoke-virtual {p0, p1, v0}, Lcom/amazon/mShop/details/AmazonAppStoreProxy;->addRefTag(Landroid/content/Context;Landroid/content/Intent;)V

    .line 47
    return-object v0
.end method

.method protected getPackageName(Landroid/content/Context;)Ljava/lang/String;
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 33
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->amazon_appstore_package_name:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected getRefTag()Ljava/lang/String;
    .locals 1

    .prologue
    .line 98
    const-string/jumbo v0, "app"

    return-object v0
.end method

.method protected needFriendAppUpdate(Landroid/content/Context;)Z
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 93
    const/4 v0, 0x0

    return v0
.end method
