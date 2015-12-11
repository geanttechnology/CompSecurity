.class public Lcom/amazon/mShop/history/HistoryItemView;
.super Lcom/amazon/mShop/ItemView;
.source "HistoryItemView.java"


# instance fields
.field private mIndex:I

.field private mItemRowGroup:Landroid/view/ViewGroup;

.field private mItemRowImage:Landroid/widget/ImageView;

.field private mItemTitle:Ljava/lang/String;

.field private mObserver:Lcom/amazon/mShop/history/ObjectDeletingObserver;

.field private mUndoGroup:Landroid/view/ViewGroup;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 39
    invoke-direct {p0, p1, p2}, Lcom/amazon/mShop/ItemView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 40
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/history/HistoryItemView;)Lcom/amazon/mShop/history/ObjectDeletingObserver;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/history/HistoryItemView;

    .prologue
    .line 29
    iget-object v0, p0, Lcom/amazon/mShop/history/HistoryItemView;->mObserver:Lcom/amazon/mShop/history/ObjectDeletingObserver;

    return-object v0
.end method

.method static synthetic access$100(Lcom/amazon/mShop/history/HistoryItemView;)I
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/history/HistoryItemView;

    .prologue
    .line 29
    iget v0, p0, Lcom/amazon/mShop/history/HistoryItemView;->mIndex:I

    return v0
.end method


# virtual methods
.method protected dispatchSetPressed(Z)V
    .locals 0
    .param p1, "pressed"    # Z

    .prologue
    .line 135
    return-void
.end method

.method protected onFinishInflate()V
    .locals 3

    .prologue
    .line 52
    invoke-super {p0}, Lcom/amazon/mShop/ItemView;->onFinishInflate()V

    .line 53
    sget v2, Lcom/amazon/mShop/android/lib/R$id;->history_item_group:I

    invoke-virtual {p0, v2}, Lcom/amazon/mShop/history/HistoryItemView;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/view/ViewGroup;

    iput-object v2, p0, Lcom/amazon/mShop/history/HistoryItemView;->mItemRowGroup:Landroid/view/ViewGroup;

    .line 54
    sget v2, Lcom/amazon/mShop/android/lib/R$id;->history_undo_group:I

    invoke-virtual {p0, v2}, Lcom/amazon/mShop/history/HistoryItemView;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/view/ViewGroup;

    iput-object v2, p0, Lcom/amazon/mShop/history/HistoryItemView;->mUndoGroup:Landroid/view/ViewGroup;

    .line 56
    sget v2, Lcom/amazon/mShop/android/lib/R$id;->item_row_image:I

    invoke-virtual {p0, v2}, Lcom/amazon/mShop/history/HistoryItemView;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ImageView;

    iput-object v2, p0, Lcom/amazon/mShop/history/HistoryItemView;->mItemRowImage:Landroid/widget/ImageView;

    .line 57
    sget v2, Lcom/amazon/mShop/android/lib/R$id;->history_delete_button:I

    invoke-virtual {p0, v2}, Lcom/amazon/mShop/history/HistoryItemView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    .line 58
    .local v0, "deleteButton":Landroid/widget/Button;
    new-instance v2, Lcom/amazon/mShop/history/HistoryItemView$1;

    invoke-direct {v2, p0}, Lcom/amazon/mShop/history/HistoryItemView$1;-><init>(Lcom/amazon/mShop/history/HistoryItemView;)V

    invoke-virtual {v0, v2}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 69
    sget v2, Lcom/amazon/mShop/android/lib/R$id;->history_undo_button:I

    invoke-virtual {p0, v2}, Lcom/amazon/mShop/history/HistoryItemView;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    .line 70
    .local v1, "undoButton":Landroid/widget/Button;
    new-instance v2, Lcom/amazon/mShop/history/HistoryItemView$2;

    invoke-direct {v2, p0}, Lcom/amazon/mShop/history/HistoryItemView$2;-><init>(Lcom/amazon/mShop/history/HistoryItemView;)V

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 81
    return-void
.end method

.method public setObjectIndex(I)V
    .locals 0
    .param p1, "index"    # I

    .prologue
    .line 47
    iput p1, p0, Lcom/amazon/mShop/history/HistoryItemView;->mIndex:I

    .line 48
    return-void
.end method

.method public setObserver(Lcom/amazon/mShop/history/ObjectDeletingObserver;)V
    .locals 0
    .param p1, "observer"    # Lcom/amazon/mShop/history/ObjectDeletingObserver;

    .prologue
    .line 43
    iput-object p1, p0, Lcom/amazon/mShop/history/HistoryItemView;->mObserver:Lcom/amazon/mShop/history/ObjectDeletingObserver;

    .line 44
    return-void
.end method

.method protected showItemGroup()V
    .locals 2

    .prologue
    .line 90
    iget-object v0, p0, Lcom/amazon/mShop/history/HistoryItemView;->mItemRowGroup:Landroid/view/ViewGroup;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 91
    iget-object v0, p0, Lcom/amazon/mShop/history/HistoryItemView;->mUndoGroup:Landroid/view/ViewGroup;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 92
    return-void
.end method

.method protected showUndoGroup()V
    .locals 6

    .prologue
    const/4 v5, 0x0

    .line 84
    iget-object v0, p0, Lcom/amazon/mShop/history/HistoryItemView;->mUndoGroup:Landroid/view/ViewGroup;

    sget v1, Lcom/amazon/mShop/android/lib/R$id;->history_removed_item:I

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/amazon/mShop/history/HistoryItemView;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->history_item_was_removed:I

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    iget-object v4, p0, Lcom/amazon/mShop/history/HistoryItemView;->mItemTitle:Ljava/lang/String;

    aput-object v4, v3, v5

    invoke-virtual {v1, v2, v3}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 85
    iget-object v0, p0, Lcom/amazon/mShop/history/HistoryItemView;->mItemRowGroup:Landroid/view/ViewGroup;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 86
    iget-object v0, p0, Lcom/amazon/mShop/history/HistoryItemView;->mUndoGroup:Landroid/view/ViewGroup;

    invoke-virtual {v0, v5}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 87
    return-void
.end method

.method public update(Lcom/amazon/mShop/ObjectSubscriberAdapter;Ljava/lang/Object;[BI)V
    .locals 13
    .param p1, "adapter"    # Lcom/amazon/mShop/ObjectSubscriberAdapter;
    .param p2, "o"    # Ljava/lang/Object;
    .param p3, "thumbnail"    # [B
    .param p4, "index"    # I

    .prologue
    .line 98
    move-object v7, p2

    check-cast v7, Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;

    .line 99
    .local v7, "searchResult":Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;
    invoke-virtual {v7}, Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;->getBasicOffer()Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

    move-result-object v1

    .line 100
    .local v1, "basicOffer":Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;
    invoke-virtual {v7}, Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;->getBasicProduct()Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    move-result-object v2

    .line 102
    .local v2, "basicProduct":Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;
    if-nez v2, :cond_1

    .line 129
    :cond_0
    :goto_0
    return-void

    .line 104
    :cond_1
    invoke-virtual {p0, p2}, Lcom/amazon/mShop/history/HistoryItemView;->setImageRequester(Ljava/lang/Object;)V

    .line 107
    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getImageUrl()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {p0}, Lcom/amazon/mShop/history/HistoryItemView;->getResources()Landroid/content/res/Resources;

    move-result-object v11

    sget v12, Lcom/amazon/mShop/android/lib/R$dimen;->item_row_height:I

    invoke-virtual {v11, v12}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v11

    invoke-static {v10, v11}, Lcom/amazon/mShop/util/ImageUtil;->getImageUrl(Ljava/lang/String;I)Ljava/lang/String;

    move-result-object v3

    .line 108
    .local v3, "imageUrl":Ljava/lang/String;
    const-class v10, Landroid/graphics/Bitmap;

    invoke-static {v3, v10}, Lcom/amazon/mShop/net/LRUCache;->getValue(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Landroid/graphics/Bitmap;

    .line 109
    .local v5, "productImageBitmap":Landroid/graphics/Bitmap;
    const/4 v6, 0x0

    .line 110
    .local v6, "productImageDrawable":Landroid/graphics/drawable/Drawable;
    if-eqz v5, :cond_2

    .line 111
    new-instance v4, Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;

    const/4 v10, 0x0

    invoke-direct {v4, v3, v10}, Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;-><init>(Ljava/lang/String;Lcom/amazon/mShop/net/HttpFetcher$Subscriber;)V

    .line 112
    .local v4, "params":Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;
    invoke-static {}, Lcom/amazon/mShop/ui/DrawableFactory;->getInstance()Lcom/amazon/mShop/ui/DrawableFactory$DrawableFactoryInterface;

    move-result-object v10

    invoke-virtual {p0}, Lcom/amazon/mShop/history/HistoryItemView;->getResources()Landroid/content/res/Resources;

    move-result-object v11

    invoke-interface {v10, v11, v5, v4}, Lcom/amazon/mShop/ui/DrawableFactory$DrawableFactoryInterface;->createDrawable(Landroid/content/res/Resources;Landroid/graphics/Bitmap;Lcom/amazon/mShop/net/HttpFetcher$Params;)Landroid/graphics/drawable/Drawable;

    move-result-object v6

    .line 114
    .end local v4    # "params":Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;
    :cond_2
    iget-object v10, p0, Lcom/amazon/mShop/history/HistoryItemView;->mItemRowImage:Landroid/widget/ImageView;

    invoke-static {v6, v10}, Lcom/amazon/mShop/details/ItemViewUtils;->updateImageWithDrawable(Landroid/graphics/drawable/Drawable;Landroid/widget/ImageView;)V

    .line 117
    if-nez v6, :cond_3

    if-nez p3, :cond_3

    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getImageUrl()Ljava/lang/String;

    move-result-object v10

    invoke-static {v10}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v10

    if-nez v10, :cond_3

    .line 118
    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getImageUrl()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {p0, v10}, Lcom/amazon/mShop/history/HistoryItemView;->getImageFromBackground(Ljava/lang/String;)V

    .line 121
    :cond_3
    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getTitle()Ljava/lang/String;

    move-result-object v10

    iput-object v10, p0, Lcom/amazon/mShop/history/HistoryItemView;->mItemTitle:Ljava/lang/String;

    .line 122
    move/from16 v0, p4

    invoke-virtual {p0, v0, v1, v2}, Lcom/amazon/mShop/history/HistoryItemView;->updateItemView(ILcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;)V

    .line 124
    invoke-virtual {p0}, Lcom/amazon/mShop/history/HistoryItemView;->getTag()Ljava/lang/Object;

    move-result-object v10

    if-eqz v10, :cond_0

    .line 125
    sget v10, Lcom/amazon/mShop/android/lib/R$id;->history_viewed_time:I

    invoke-virtual {p0, v10}, Lcom/amazon/mShop/history/HistoryItemView;->findViewById(I)Landroid/view/View;

    move-result-object v8

    check-cast v8, Landroid/widget/TextView;

    .line 126
    .local v8, "viewedTime":Landroid/widget/TextView;
    invoke-virtual {p0}, Lcom/amazon/mShop/history/HistoryItemView;->getTag()Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/util/Date;

    .line 127
    .local v9, "visitDate":Ljava/util/Date;
    new-instance v10, Ljava/text/SimpleDateFormat;

    invoke-virtual {p0}, Lcom/amazon/mShop/history/HistoryItemView;->getResources()Landroid/content/res/Resources;

    move-result-object v11

    sget v12, Lcom/amazon/mShop/android/lib/R$string;->history_time_format:I

    invoke-virtual {v11, v12}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v11

    invoke-direct {v10, v11}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;)V

    invoke-virtual {v10, v9}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v8, v10}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_0
.end method
