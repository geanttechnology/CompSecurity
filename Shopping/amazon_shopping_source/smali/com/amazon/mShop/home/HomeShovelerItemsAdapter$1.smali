.class Lcom/amazon/mShop/home/HomeShovelerItemsAdapter$1;
.super Ljava/lang/Object;
.source "HomeShovelerItemsAdapter.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->getShovelerItemView(ILcom/amazon/mShop/home/ShovelerItemView;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;

.field final synthetic val$position:I

.field final synthetic val$shovelerItemView:Lcom/amazon/mShop/home/ShovelerItemView;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;Lcom/amazon/mShop/home/ShovelerItemView;I)V
    .locals 0

    .prologue
    .line 444
    iput-object p1, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter$1;->this$0:Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;

    iput-object p2, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter$1;->val$shovelerItemView:Lcom/amazon/mShop/home/ShovelerItemView;

    iput p3, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter$1;->val$position:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 7
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 447
    invoke-virtual {p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v2

    .line 448
    .local v2, "o":Ljava/lang/Object;
    instance-of v3, v2, Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;

    if-eqz v3, :cond_2

    .line 449
    const/4 v0, 0x0

    .local v0, "clickStreamOrigin":Ljava/lang/String;
    move-object v3, v2

    .line 451
    check-cast v3, Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;

    invoke-virtual {v3}, Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;->getClickStreamOrigin()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_3

    move-object v3, v2

    .line 452
    check-cast v3, Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;

    invoke-virtual {v3}, Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;->getClickStreamOrigin()Ljava/lang/String;

    move-result-object v0

    .line 457
    :cond_0
    :goto_0
    new-instance v1, Lcom/amazon/mShop/control/item/ClickStreamTag;

    invoke-direct {v1, v0}, Lcom/amazon/mShop/control/item/ClickStreamTag;-><init>(Ljava/lang/String;)V

    .line 458
    .local v1, "homeItemsClickStreamTag":Lcom/amazon/mShop/control/item/ClickStreamTag;
    iget-object v3, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter$1;->this$0:Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;

    # getter for: Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mContext:Landroid/content/Context;
    invoke-static {v3}, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->access$100(Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;)Landroid/content/Context;

    move-result-object v3

    check-cast v2, Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;

    .end local v2    # "o":Ljava/lang/Object;
    iget-object v4, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter$1;->val$shovelerItemView:Lcom/amazon/mShop/home/ShovelerItemView;

    invoke-virtual {v4}, Lcom/amazon/mShop/home/ShovelerItemView;->getEncodedImage()[B

    move-result-object v4

    invoke-static {v3, v2, v1, v4}, Lcom/amazon/mShop/home/HomeView;->forwardProductDetailsView(Landroid/content/Context;Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;Lcom/amazon/mShop/control/item/ClickStreamTag;[B)V

    .line 461
    iget-object v3, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter$1;->this$0:Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;

    # getter for: Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mShovelerSlotToken:Ljava/lang/String;
    invoke-static {v3}, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->access$200(Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_1

    .line 462
    iget-object v3, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter$1;->this$0:Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;

    # getter for: Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mShovelerSlotToken:Ljava/lang/String;
    invoke-static {v3}, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->access$200(Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/amazon/mShop/home/HomeView;->postClickedSlotToken(Ljava/lang/String;)V

    .line 466
    :cond_1
    iget-object v3, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter$1;->this$0:Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;

    # getter for: Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mRefMarkerArg:Ljava/lang/String;
    invoke-static {v3}, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->access$300(Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_2

    .line 468
    iget-object v3, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter$1;->this$0:Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;

    # getter for: Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mRefMarkerArg:Ljava/lang/String;
    invoke-static {v3}, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->access$300(Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;)Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    iget v6, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter$1;->val$position:I

    add-int/lit8 v6, v6, 0x1

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 473
    .end local v0    # "clickStreamOrigin":Ljava/lang/String;
    .end local v1    # "homeItemsClickStreamTag":Lcom/amazon/mShop/control/item/ClickStreamTag;
    :cond_2
    return-void

    .line 453
    .restart local v0    # "clickStreamOrigin":Ljava/lang/String;
    .restart local v2    # "o":Ljava/lang/Object;
    :cond_3
    iget-object v3, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter$1;->this$0:Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;

    # getter for: Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mShovelerClickStreamOrigin:Ljava/lang/String;
    invoke-static {v3}, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->access$000(Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 454
    iget-object v3, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter$1;->this$0:Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;

    # getter for: Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->mShovelerClickStreamOrigin:Ljava/lang/String;
    invoke-static {v3}, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->access$000(Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method
