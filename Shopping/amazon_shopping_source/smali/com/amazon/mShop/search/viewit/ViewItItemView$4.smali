.class Lcom/amazon/mShop/search/viewit/ViewItItemView$4;
.super Ljava/lang/Object;
.source "ViewItItemView.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/search/viewit/ViewItItemView;->setItemClickAction(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;Z)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/search/viewit/ViewItItemView;

.field final synthetic val$isAllMatchesItem:Z

.field final synthetic val$item:Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;

.field final synthetic val$slidingDrawer:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

.field final synthetic val$wrapper:Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/search/viewit/ViewItItemView;ZLcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;)V
    .locals 0

    .prologue
    .line 179
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/ViewItItemView$4;->this$0:Lcom/amazon/mShop/search/viewit/ViewItItemView;

    iput-boolean p2, p0, Lcom/amazon/mShop/search/viewit/ViewItItemView$4;->val$isAllMatchesItem:Z

    iput-object p3, p0, Lcom/amazon/mShop/search/viewit/ViewItItemView$4;->val$slidingDrawer:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    iput-object p4, p0, Lcom/amazon/mShop/search/viewit/ViewItItemView$4;->val$item:Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;

    iput-object p5, p0, Lcom/amazon/mShop/search/viewit/ViewItItemView$4;->val$wrapper:Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 10
    .param p1, "view"    # Landroid/view/View;

    .prologue
    const/4 v8, 0x1

    .line 182
    iget-boolean v6, p0, Lcom/amazon/mShop/search/viewit/ViewItItemView$4;->val$isAllMatchesItem:Z

    if-eqz v6, :cond_2

    .line 183
    const-string/jumbo v6, "fl_allmatch_dp"

    invoke-static {v6}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 194
    :goto_0
    new-instance v3, Lcom/amazon/mShop/control/item/ProductController;

    iget-object v6, p0, Lcom/amazon/mShop/search/viewit/ViewItItemView$4;->val$item:Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;

    invoke-direct {v3, v6}, Lcom/amazon/mShop/control/item/ProductController;-><init>(Ljava/lang/Object;)V

    .line 195
    .local v3, "controller":Lcom/amazon/mShop/control/item/ProductController;
    iget-object v6, p0, Lcom/amazon/mShop/search/viewit/ViewItItemView$4;->this$0:Lcom/amazon/mShop/search/viewit/ViewItItemView;

    iget-object v7, p0, Lcom/amazon/mShop/search/viewit/ViewItItemView$4;->val$wrapper:Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;

    iget-boolean v8, p0, Lcom/amazon/mShop/search/viewit/ViewItItemView$4;->val$isAllMatchesItem:Z

    iget-object v9, p0, Lcom/amazon/mShop/search/viewit/ViewItItemView$4;->val$slidingDrawer:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    invoke-virtual {v9}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->isOpened()Z

    move-result v9

    # invokes: Lcom/amazon/mShop/search/viewit/ViewItItemView;->getClickStreamTag(Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;ZZ)Lcom/amazon/mShop/control/item/ClickStreamTag;
    invoke-static {v6, v7, v8, v9}, Lcom/amazon/mShop/search/viewit/ViewItItemView;->access$500(Lcom/amazon/mShop/search/viewit/ViewItItemView;Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;ZZ)Lcom/amazon/mShop/control/item/ClickStreamTag;

    move-result-object v2

    .line 196
    .local v2, "clickSteamOrigin":Lcom/amazon/mShop/control/item/ClickStreamTag;
    invoke-virtual {v3, v2}, Lcom/amazon/mShop/control/item/ProductController;->setClickStreamTag(Lcom/amazon/mShop/control/item/ClickStreamTag;)V

    .line 198
    iget-object v6, p0, Lcom/amazon/mShop/search/viewit/ViewItItemView$4;->val$item:Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;

    invoke-virtual {v6}, Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;->getBasicProduct()Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    move-result-object v6

    invoke-virtual {v6}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getImageUrl()Ljava/lang/String;

    move-result-object v6

    iget-object v7, p0, Lcom/amazon/mShop/search/viewit/ViewItItemView$4;->this$0:Lcom/amazon/mShop/search/viewit/ViewItItemView;

    invoke-virtual {v7}, Lcom/amazon/mShop/search/viewit/ViewItItemView;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    sget v8, Lcom/amazon/mShop/android/lib/R$dimen;->view_it_item_thumbnail_picture_max_dimension:I

    invoke-virtual {v7, v8}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v7

    invoke-static {v6, v7}, Lcom/amazon/mShop/util/ImageUtil;->getImageUrl(Ljava/lang/String;I)Ljava/lang/String;

    move-result-object v5

    .line 199
    .local v5, "url":Ljava/lang/String;
    const-class v6, Landroid/graphics/Bitmap;

    invoke-static {v5, v6}, Lcom/amazon/mShop/net/LRUCache;->getValue(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/graphics/Bitmap;

    .line 200
    .local v1, "bitmap":Landroid/graphics/Bitmap;
    if-nez v1, :cond_0

    .line 201
    iget-object v6, p0, Lcom/amazon/mShop/search/viewit/ViewItItemView$4;->this$0:Lcom/amazon/mShop/search/viewit/ViewItItemView;

    invoke-virtual {v6}, Lcom/amazon/mShop/search/viewit/ViewItItemView;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    sget v7, Lcom/amazon/mShop/android/lib/R$drawable;->noimage:I

    invoke-static {v6, v7}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v1

    .line 203
    :cond_0
    new-instance v0, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v0}, Ljava/io/ByteArrayOutputStream;-><init>()V

    .line 204
    .local v0, "baos":Ljava/io/ByteArrayOutputStream;
    sget-object v6, Landroid/graphics/Bitmap$CompressFormat;->JPEG:Landroid/graphics/Bitmap$CompressFormat;

    const/16 v7, 0x64

    invoke-virtual {v1, v6, v7, v0}, Landroid/graphics/Bitmap;->compress(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z

    move-result v4

    .line 205
    .local v4, "isSuccessful":Z
    if-eqz v4, :cond_1

    .line 206
    invoke-virtual {v0}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object v6

    invoke-virtual {v3, v6}, Lcom/amazon/mShop/control/item/ProductController;->setThumbnail([B)V

    .line 209
    :cond_1
    iget-object v6, p0, Lcom/amazon/mShop/search/viewit/ViewItItemView$4;->this$0:Lcom/amazon/mShop/search/viewit/ViewItItemView;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItItemView;->mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;
    invoke-static {v6}, Lcom/amazon/mShop/search/viewit/ViewItItemView;->access$400(Lcom/amazon/mShop/search/viewit/ViewItItemView;)Lcom/amazon/mShop/search/viewit/ViewItActivity;

    move-result-object v6

    invoke-virtual {v6, v3}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->forward(Ljava/lang/Object;)Z

    .line 210
    iget-object v6, p0, Lcom/amazon/mShop/search/viewit/ViewItItemView$4;->this$0:Lcom/amazon/mShop/search/viewit/ViewItItemView;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItItemView;->mBrowser:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;
    invoke-static {v6}, Lcom/amazon/mShop/search/viewit/ViewItItemView;->access$300(Lcom/amazon/mShop/search/viewit/ViewItItemView;)Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;

    move-result-object v6

    invoke-virtual {v6}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->deleteUndoObject()V

    .line 212
    return-void

    .line 185
    .end local v0    # "baos":Ljava/io/ByteArrayOutputStream;
    .end local v1    # "bitmap":Landroid/graphics/Bitmap;
    .end local v2    # "clickSteamOrigin":Lcom/amazon/mShop/control/item/ClickStreamTag;
    .end local v3    # "controller":Lcom/amazon/mShop/control/item/ProductController;
    .end local v4    # "isSuccessful":Z
    .end local v5    # "url":Ljava/lang/String;
    :cond_2
    iget-object v6, p0, Lcom/amazon/mShop/search/viewit/ViewItItemView$4;->val$slidingDrawer:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    invoke-virtual {v6}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->isOpened()Z

    move-result v6

    if-eqz v6, :cond_3

    .line 186
    iget-object v6, p0, Lcom/amazon/mShop/search/viewit/ViewItItemView$4;->this$0:Lcom/amazon/mShop/search/viewit/ViewItItemView;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItItemView;->mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;
    invoke-static {v6}, Lcom/amazon/mShop/search/viewit/ViewItItemView;->access$400(Lcom/amazon/mShop/search/viewit/ViewItItemView;)Lcom/amazon/mShop/search/viewit/ViewItActivity;

    move-result-object v6

    invoke-virtual {v6}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->getViewItMetricHelper()Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;

    move-result-object v6

    const-string/jumbo v7, "history-maximized-item-tap"

    invoke-virtual {v6, v7, v8}, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->logCountMetricsPerSession(Ljava/lang/String;I)V

    .line 187
    const-string/jumbo v6, "fl_max_dp"

    invoke-static {v6}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 189
    :cond_3
    iget-object v6, p0, Lcom/amazon/mShop/search/viewit/ViewItItemView$4;->this$0:Lcom/amazon/mShop/search/viewit/ViewItItemView;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItItemView;->mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;
    invoke-static {v6}, Lcom/amazon/mShop/search/viewit/ViewItItemView;->access$400(Lcom/amazon/mShop/search/viewit/ViewItItemView;)Lcom/amazon/mShop/search/viewit/ViewItActivity;

    move-result-object v6

    invoke-virtual {v6}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->getViewItMetricHelper()Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;

    move-result-object v6

    const-string/jumbo v7, "history-minimized-item-tap"

    invoke-virtual {v6, v7, v8}, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->logCountMetricsPerSession(Ljava/lang/String;I)V

    .line 190
    const-string/jumbo v6, "fl_mini_dp"

    invoke-static {v6}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    goto/16 :goto_0
.end method
