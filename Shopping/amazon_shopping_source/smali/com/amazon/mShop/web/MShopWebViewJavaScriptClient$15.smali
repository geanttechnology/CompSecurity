.class Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$15;
.super Ljava/lang/Object;
.source "MShopWebViewJavaScriptClient.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->buyAsin(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

.field final synthetic val$asin:Ljava/lang/String;

.field final synthetic val$clickStream:Ljava/lang/String;

.field final synthetic val$dealId:Ljava/lang/String;

.field final synthetic val$listId:Ljava/lang/String;

.field final synthetic val$listItemId:Ljava/lang/String;

.field final synthetic val$offerId:Ljava/lang/String;

.field final synthetic val$oneClickShippingSpeed:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 517
    iput-object p1, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$15;->this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

    iput-object p2, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$15;->val$clickStream:Ljava/lang/String;

    iput-object p3, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$15;->val$dealId:Ljava/lang/String;

    iput-object p4, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$15;->val$listId:Ljava/lang/String;

    iput-object p5, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$15;->val$listItemId:Ljava/lang/String;

    iput-object p6, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$15;->val$oneClickShippingSpeed:Ljava/lang/String;

    iput-object p7, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$15;->val$asin:Ljava/lang/String;

    iput-object p8, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$15;->val$offerId:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 8

    .prologue
    .line 522
    iget-object v1, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$15;->this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

    iget-object v2, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$15;->val$clickStream:Ljava/lang/String;

    # invokes: Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->isDefined(Ljava/lang/String;)Z
    invoke-static {v1, v2}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->access$100(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_4

    .line 523
    iget-object v7, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$15;->val$clickStream:Ljava/lang/String;

    .line 530
    .local v7, "clickStreamOrigin":Ljava/lang/String;
    :goto_0
    iget-object v5, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$15;->val$dealId:Ljava/lang/String;

    .line 531
    .local v5, "dealIdNew":Ljava/lang/String;
    iget-object v1, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$15;->this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

    # invokes: Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->isDefined(Ljava/lang/String;)Z
    invoke-static {v1, v5}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->access$100(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    const/4 v5, 0x0

    .line 533
    :cond_0
    iget-object v3, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$15;->val$listId:Ljava/lang/String;

    .line 534
    .local v3, "listIdNew":Ljava/lang/String;
    iget-object v1, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$15;->this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

    # invokes: Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->isDefined(Ljava/lang/String;)Z
    invoke-static {v1, v3}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->access$100(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_1

    const/4 v3, 0x0

    .line 536
    :cond_1
    iget-object v4, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$15;->val$listItemId:Ljava/lang/String;

    .line 537
    .local v4, "listItemIdNew":Ljava/lang/String;
    iget-object v1, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$15;->this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

    # invokes: Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->isDefined(Ljava/lang/String;)Z
    invoke-static {v1, v4}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->access$100(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_2

    const/4 v4, 0x0

    .line 539
    :cond_2
    iget-object v6, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$15;->val$oneClickShippingSpeed:Ljava/lang/String;

    .line 540
    .local v6, "oneClickShippingSpeedNew":Ljava/lang/String;
    iget-object v1, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$15;->this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

    # invokes: Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->isDefined(Ljava/lang/String;)Z
    invoke-static {v1, v6}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->access$100(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_3

    const/4 v6, 0x0

    .line 542
    :cond_3
    new-instance v0, Lcom/amazon/mShop/opl/PurchaseParams;

    iget-object v1, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$15;->val$asin:Ljava/lang/String;

    iget-object v2, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$15;->val$offerId:Ljava/lang/String;

    invoke-direct/range {v0 .. v7}, Lcom/amazon/mShop/opl/PurchaseParams;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 544
    .local v0, "params":Lcom/amazon/mShop/opl/PurchaseParams;
    iget-object v1, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$15;->this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

    # getter for: Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->mContext:Landroid/content/Context;
    invoke-static {v1}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->access$000(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;)Landroid/content/Context;

    move-result-object v1

    invoke-static {v1, v0}, Lcom/amazon/mShop/util/ActivityUtils;->startPurchaseActivity(Landroid/content/Context;Lcom/amazon/mShop/opl/PurchaseParams;)V

    .line 545
    return-void

    .line 524
    .end local v0    # "params":Lcom/amazon/mShop/opl/PurchaseParams;
    .end local v3    # "listIdNew":Ljava/lang/String;
    .end local v4    # "listItemIdNew":Ljava/lang/String;
    .end local v5    # "dealIdNew":Ljava/lang/String;
    .end local v6    # "oneClickShippingSpeedNew":Ljava/lang/String;
    .end local v7    # "clickStreamOrigin":Ljava/lang/String;
    :cond_4
    iget-object v1, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$15;->this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

    # getter for: Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->mContext:Landroid/content/Context;
    invoke-static {v1}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->access$000(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;)Landroid/content/Context;

    move-result-object v1

    instance-of v1, v1, Lcom/amazon/mShop/AmazonActivity;

    if-eqz v1, :cond_5

    iget-object v1, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$15;->this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

    # getter for: Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->mContext:Landroid/content/Context;
    invoke-static {v1}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->access$000(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;)Landroid/content/Context;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/AmazonActivity;

    invoke-virtual {v1}, Lcom/amazon/mShop/AmazonActivity;->getClickStreamOrigin()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_5

    .line 526
    iget-object v1, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$15;->this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

    # getter for: Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->mContext:Landroid/content/Context;
    invoke-static {v1}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->access$000(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;)Landroid/content/Context;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/AmazonActivity;

    invoke-virtual {v1}, Lcom/amazon/mShop/AmazonActivity;->getClickStreamOrigin()Ljava/lang/String;

    move-result-object v7

    .restart local v7    # "clickStreamOrigin":Ljava/lang/String;
    goto :goto_0

    .line 528
    .end local v7    # "clickStreamOrigin":Ljava/lang/String;
    :cond_5
    sget-object v1, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_DEFAULT:Lcom/amazon/mShop/control/item/ClickStreamTag;

    invoke-virtual {v1}, Lcom/amazon/mShop/control/item/ClickStreamTag;->getTag()Ljava/lang/String;

    move-result-object v7

    .restart local v7    # "clickStreamOrigin":Ljava/lang/String;
    goto :goto_0
.end method
