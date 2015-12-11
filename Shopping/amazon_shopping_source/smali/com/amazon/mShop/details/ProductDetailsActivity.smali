.class public Lcom/amazon/mShop/details/ProductDetailsActivity;
.super Lcom/amazon/mShop/AmazonActivity;
.source "ProductDetailsActivity.java"


# static fields
.field private static sGlobalProductController:Lcom/amazon/mShop/control/item/ProductController;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 23
    invoke-direct {p0}, Lcom/amazon/mShop/AmazonActivity;-><init>()V

    return-void
.end method

.method public static getViewIntentUri(Ljava/lang/String;Landroid/content/Context;)Ljava/lang/String;
    .locals 3
    .param p0, "asin"    # Ljava/lang/String;
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 51
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .line 52
    .local v0, "intent":Landroid/content/Intent;
    const-string/jumbo v1, "android.intent.action.VIEW"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 53
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "mshop://featured?ASIN="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    const-string/jumbo v2, "vnd.android.cursor.item/vnd.amazon.mShop.featured"

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 54
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/content/Intent;->toUri(I)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method


# virtual methods
.method protected handleForceSignIn()V
    .locals 1

    .prologue
    .line 117
    invoke-virtual {p0}, Lcom/amazon/mShop/details/ProductDetailsActivity;->isLaunchedFromPublicUrl()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 118
    invoke-static {p0}, Lcom/amazon/mShop/sso/SSOUtil;->handleSigninPrompt(Landroid/content/Context;)Z

    .line 120
    :cond_0
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 9
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v8, 0x0

    .line 59
    invoke-super {p0, p1}, Lcom/amazon/mShop/AmazonActivity;->onCreate(Landroid/os/Bundle;)V

    .line 70
    sget v6, Lcom/amazon/mShop/android/lib/R$string;->product_details_activity_name:I

    invoke-virtual {p0, v6}, Lcom/amazon/mShop/details/ProductDetailsActivity;->setTitle(I)V

    .line 72
    const/4 v2, 0x0

    .line 74
    .local v2, "productController":Lcom/amazon/mShop/control/item/ProductController;
    invoke-virtual {p0}, Lcom/amazon/mShop/details/ProductDetailsActivity;->getIntent()Landroid/content/Intent;

    move-result-object v1

    .line 75
    .local v1, "intent":Landroid/content/Intent;
    invoke-virtual {v1}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v5

    .line 76
    .local v5, "uri":Landroid/net/Uri;
    if-eqz v5, :cond_5

    .line 77
    const/4 v0, 0x0

    .line 78
    .local v0, "asin":Ljava/lang/String;
    const-string/jumbo v6, "amazonmobile"

    invoke-virtual {v5}, Landroid/net/Uri;->getScheme()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_3

    .line 79
    const-string/jumbo v6, "asin"

    invoke-virtual {v5, v6}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 84
    :cond_0
    :goto_0
    if-eqz v0, :cond_1

    .line 85
    invoke-virtual {p0}, Lcom/amazon/mShop/details/ProductDetailsActivity;->getClickStreamOrigin()Ljava/lang/String;

    move-result-object v4

    .line 87
    .local v4, "tagStr":Ljava/lang/String;
    invoke-static {v4}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_4

    .line 88
    sget-object v3, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_REMEMBERS:Lcom/amazon/mShop/control/item/ClickStreamTag;

    .line 93
    .local v3, "tag":Lcom/amazon/mShop/control/item/ClickStreamTag;
    :goto_1
    new-instance v2, Lcom/amazon/mShop/control/item/ProductController;

    .end local v2    # "productController":Lcom/amazon/mShop/control/item/ProductController;
    invoke-direct {v2, v0, v3}, Lcom/amazon/mShop/control/item/ProductController;-><init>(Ljava/lang/String;Lcom/amazon/mShop/control/item/ClickStreamTag;)V

    .line 97
    .end local v3    # "tag":Lcom/amazon/mShop/control/item/ClickStreamTag;
    .end local v4    # "tagStr":Ljava/lang/String;
    .restart local v2    # "productController":Lcom/amazon/mShop/control/item/ProductController;
    :cond_1
    invoke-static {p0}, Lcom/amazon/mShop/home/EulaDialog;->showEulaIfNeeded(Lcom/amazon/mShop/AmazonActivity;)V

    .line 104
    .end local v0    # "asin":Ljava/lang/String;
    :cond_2
    :goto_2
    if-nez v2, :cond_6

    .line 105
    invoke-virtual {p0}, Lcom/amazon/mShop/details/ProductDetailsActivity;->finish()V

    .line 113
    :goto_3
    return-void

    .line 80
    .restart local v0    # "asin":Ljava/lang/String;
    :cond_3
    const-string/jumbo v6, "mshop"

    invoke-virtual {v5}, Landroid/net/Uri;->getScheme()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_0

    .line 81
    const-string/jumbo v6, "ASIN"

    invoke-virtual {v5, v6}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 91
    .restart local v4    # "tagStr":Ljava/lang/String;
    :cond_4
    new-instance v3, Lcom/amazon/mShop/control/item/ClickStreamTag;

    invoke-direct {v3, v4}, Lcom/amazon/mShop/control/item/ClickStreamTag;-><init>(Ljava/lang/String;)V

    .restart local v3    # "tag":Lcom/amazon/mShop/control/item/ClickStreamTag;
    goto :goto_1

    .line 99
    .end local v0    # "asin":Ljava/lang/String;
    .end local v3    # "tag":Lcom/amazon/mShop/control/item/ClickStreamTag;
    .end local v4    # "tagStr":Ljava/lang/String;
    :cond_5
    sget-object v6, Lcom/amazon/mShop/details/ProductDetailsActivity;->sGlobalProductController:Lcom/amazon/mShop/control/item/ProductController;

    if-eqz v6, :cond_2

    .line 100
    sget-object v2, Lcom/amazon/mShop/details/ProductDetailsActivity;->sGlobalProductController:Lcom/amazon/mShop/control/item/ProductController;

    .line 101
    sput-object v8, Lcom/amazon/mShop/details/ProductDetailsActivity;->sGlobalProductController:Lcom/amazon/mShop/control/item/ProductController;

    goto :goto_2

    .line 111
    :cond_6
    const/4 v6, -0x1

    invoke-static {p0, v2, v8, v6}, Lcom/amazon/mShop/util/ActivityUtils;->goToUdp(Landroid/content/Context;Lcom/amazon/mShop/control/item/ProductController;Ljava/util/Map;I)Z

    .line 112
    invoke-virtual {p0}, Lcom/amazon/mShop/details/ProductDetailsActivity;->finish()V

    goto :goto_3
.end method
