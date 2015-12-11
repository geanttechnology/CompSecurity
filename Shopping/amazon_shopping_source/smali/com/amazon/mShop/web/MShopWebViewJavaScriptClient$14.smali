.class Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$14;
.super Ljava/lang/Object;
.source "MShopWebViewJavaScriptClient.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->showImageGallery(Ljava/lang/String;I[Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

.field final synthetic val$imageUrls:[Ljava/lang/String;

.field final synthetic val$startIndex:I

.field final synthetic val$title:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;[Ljava/lang/String;ILjava/lang/String;)V
    .locals 0

    .prologue
    .line 479
    iput-object p1, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$14;->this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

    iput-object p2, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$14;->val$imageUrls:[Ljava/lang/String;

    iput p3, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$14;->val$startIndex:I

    iput-object p4, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$14;->val$title:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 10

    .prologue
    .line 482
    new-instance v6, Ljava/util/ArrayList;

    invoke-direct {v6}, Ljava/util/ArrayList;-><init>()V

    .line 483
    .local v6, "multiImageList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/MultiImage;>;"
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$14;->val$imageUrls:[Ljava/lang/String;

    .local v0, "arr$":[Ljava/lang/String;
    array-length v5, v0

    .local v5, "len$":I
    const/4 v1, 0x0

    .local v1, "i$":I
    :goto_0
    if-ge v1, v5, :cond_0

    aget-object v2, v0, v1

    .line 484
    .local v2, "imageUrl":Ljava/lang/String;
    new-instance v4, Lcom/amazon/rio/j2me/client/services/mShop/MultiImage;

    invoke-direct {v4}, Lcom/amazon/rio/j2me/client/services/mShop/MultiImage;-><init>()V

    .line 485
    .local v4, "instance":Lcom/amazon/rio/j2me/client/services/mShop/MultiImage;
    invoke-virtual {v4, v2}, Lcom/amazon/rio/j2me/client/services/mShop/MultiImage;->setStandardUrl(Ljava/lang/String;)V

    .line 486
    invoke-interface {v6, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 483
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 489
    .end local v2    # "imageUrl":Ljava/lang/String;
    .end local v4    # "instance":Lcom/amazon/rio/j2me/client/services/mShop/MultiImage;
    :cond_0
    iget-object v7, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$14;->this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

    # getter for: Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->mContext:Landroid/content/Context;
    invoke-static {v7}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->access$000(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;)Landroid/content/Context;

    move-result-object v7

    sget v8, Lcom/amazon/mShop/android/lib/R$layout;->product_images:I

    const/4 v9, 0x0

    invoke-static {v7, v8, v9}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v3

    check-cast v3, Lcom/amazon/mShop/details/ProductImagesView;

    .line 491
    .local v3, "imageView":Lcom/amazon/mShop/details/ProductImagesView;
    iget v7, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$14;->val$startIndex:I

    invoke-virtual {v3, v7}, Lcom/amazon/mShop/details/ProductImagesView;->setStartIndex(I)V

    .line 492
    iget-object v7, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$14;->val$title:Ljava/lang/String;

    invoke-virtual {v3, v7, v6}, Lcom/amazon/mShop/details/ProductImagesView;->setImagesAndTitle(Ljava/lang/String;Ljava/util/List;)V

    .line 493
    iget-object v7, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$14;->this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

    # getter for: Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->mContext:Landroid/content/Context;
    invoke-static {v7}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->access$000(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;)Landroid/content/Context;

    move-result-object v7

    check-cast v7, Lcom/amazon/mShop/AmazonActivity;

    invoke-virtual {v7, v3}, Lcom/amazon/mShop/AmazonActivity;->pushView(Landroid/view/View;)V

    .line 494
    return-void
.end method
