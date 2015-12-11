.class public Lcom/amazon/mShop/sns/SnsAction;
.super Ljava/lang/Object;
.source "SnsAction.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field private final mContext:Landroid/content/Context;

.field private final mProductController:Lcom/amazon/mShop/control/item/ProductController;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lcom/amazon/mShop/control/item/ProductController;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "productController"    # Lcom/amazon/mShop/control/item/ProductController;

    .prologue
    .line 24
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 25
    iput-object p1, p0, Lcom/amazon/mShop/sns/SnsAction;->mContext:Landroid/content/Context;

    .line 26
    iput-object p2, p0, Lcom/amazon/mShop/sns/SnsAction;->mProductController:Lcom/amazon/mShop/control/item/ProductController;

    .line 27
    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 8
    .param p1, "v"    # Landroid/view/View;

    .prologue
    const/4 v7, 0x2

    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 31
    iget-object v3, p0, Lcom/amazon/mShop/sns/SnsAction;->mContext:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    .line 32
    .local v1, "res":Landroid/content/res/Resources;
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v3

    invoke-interface {v3}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v3

    const-string/jumbo v4, "currentSnsDetail"

    invoke-interface {v3, v4}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 33
    .local v2, "snsDetailUrl":Ljava/lang/String;
    invoke-static {v2}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 34
    sget v3, Lcom/amazon/mShop/android/lib/R$string;->sns_detail_webpage:I

    invoke-virtual {v1, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 36
    :cond_0
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/mShop/sns/SnsAction;->mProductController:Lcom/amazon/mShop/control/item/ProductController;

    invoke-virtual {v4}, Lcom/amazon/mShop/control/item/ProductController;->getAsin()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 37
    instance-of v3, p1, Lcom/amazon/mShop/details/BuyButtonView;

    if-eqz v3, :cond_2

    .line 38
    sget v3, Lcom/amazon/mShop/android/lib/R$string;->sns_url_with_refmarker:I

    new-array v4, v7, [Ljava/lang/Object;

    aput-object v2, v4, v5

    const-string/jumbo v5, "rcxsubs_ap_am_native_buybox"

    aput-object v5, v4, v6

    invoke-virtual {v1, v3, v4}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    .line 43
    :cond_1
    :goto_0
    new-instance v0, Landroid/content/Intent;

    iget-object v3, p0, Lcom/amazon/mShop/sns/SnsAction;->mContext:Landroid/content/Context;

    const-class v4, Lcom/amazon/mShop/sns/SnsWebViewActivity;

    invoke-direct {v0, v3, v4}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 44
    .local v0, "intent":Landroid/content/Intent;
    invoke-static {}, Lcom/amazon/mobile/mash/constants/WebConstants;->getWebViewUrlKey()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 45
    iget-object v3, p0, Lcom/amazon/mShop/sns/SnsAction;->mContext:Landroid/content/Context;

    invoke-virtual {v3, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 46
    return-void

    .line 39
    .end local v0    # "intent":Landroid/content/Intent;
    :cond_2
    instance-of v3, p1, Landroid/widget/LinearLayout;

    if-eqz v3, :cond_1

    .line 40
    sget v3, Lcom/amazon/mShop/android/lib/R$string;->sns_url_with_refmarker:I

    new-array v4, v7, [Ljava/lang/Object;

    aput-object v2, v4, v5

    const-string/jumbo v5, "rcxsubs_ap_am_native_priceblock"

    aput-object v5, v4, v6

    invoke-virtual {v1, v3, v4}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    goto :goto_0
.end method
