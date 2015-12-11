.class public Lcom/amazon/mShop/search/viewit/ViewItItemView;
.super Lcom/amazon/mShop/ItemView;
.source "ViewItItemView.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/search/viewit/ViewItItemView$ItemShowType;
    }
.end annotation


# instance fields
.field private mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;

.field private mBrowser:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;

.field private mButtonGroup:Landroid/view/View;

.field private mDeleteButton:Landroid/widget/Button;

.field private mItemProductInfoContent:Landroid/view/ViewGroup;

.field private mItemResult:Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;

.field private mItemRowImage:Landroid/widget/ImageView;

.field private mItemTextAndImageContent:Landroid/view/ViewGroup;

.field private mItemType:Lcom/amazon/mShop/search/viewit/ViewItItemView$ItemShowType;

.field private mObject:Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;

.field private mSeeAllMatchedButton:Landroid/widget/Button;

.field private mUndoContent:Landroid/view/ViewGroup;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 59
    invoke-direct {p0, p1, p2}, Lcom/amazon/mShop/ItemView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 53
    sget-object v0, Lcom/amazon/mShop/search/viewit/ViewItItemView$ItemShowType;->ITME_SHOW_AS_GROUP:Lcom/amazon/mShop/search/viewit/ViewItItemView$ItemShowType;

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItItemView;->mItemType:Lcom/amazon/mShop/search/viewit/ViewItItemView$ItemShowType;

    .line 60
    check-cast p1, Lcom/amazon/mShop/search/viewit/ViewItActivity;

    .end local p1    # "context":Landroid/content/Context;
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/ViewItItemView;->mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    .line 61
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/search/viewit/ViewItItemView;)Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItItemView;

    .prologue
    .line 35
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItItemView;->mObject:Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;

    return-object v0
.end method

.method static synthetic access$100(Lcom/amazon/mShop/search/viewit/ViewItItemView;)Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItItemView;

    .prologue
    .line 35
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItItemView;->mItemResult:Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;

    return-object v0
.end method

.method static synthetic access$200(Lcom/amazon/mShop/search/viewit/ViewItItemView;)Lcom/amazon/mShop/search/viewit/ViewItItemView$ItemShowType;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItItemView;

    .prologue
    .line 35
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItItemView;->mItemType:Lcom/amazon/mShop/search/viewit/ViewItItemView$ItemShowType;

    return-object v0
.end method

.method static synthetic access$300(Lcom/amazon/mShop/search/viewit/ViewItItemView;)Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItItemView;

    .prologue
    .line 35
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItItemView;->mBrowser:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;

    return-object v0
.end method

.method static synthetic access$400(Lcom/amazon/mShop/search/viewit/ViewItItemView;)Lcom/amazon/mShop/search/viewit/ViewItActivity;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItItemView;

    .prologue
    .line 35
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItItemView;->mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    return-object v0
.end method

.method static synthetic access$500(Lcom/amazon/mShop/search/viewit/ViewItItemView;Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;ZZ)Lcom/amazon/mShop/control/item/ClickStreamTag;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItItemView;
    .param p1, "x1"    # Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;
    .param p2, "x2"    # Z
    .param p3, "x3"    # Z

    .prologue
    .line 35
    invoke-direct {p0, p1, p2, p3}, Lcom/amazon/mShop/search/viewit/ViewItItemView;->getClickStreamTag(Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;ZZ)Lcom/amazon/mShop/control/item/ClickStreamTag;

    move-result-object v0

    return-object v0
.end method

.method private getClickStreamTag(Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;ZZ)Lcom/amazon/mShop/control/item/ClickStreamTag;
    .locals 3
    .param p1, "wrapper"    # Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;
    .param p2, "isAllMatchesItem"    # Z
    .param p3, "isSlidingDrawerOpened"    # Z

    .prologue
    .line 249
    const/4 v0, 0x0

    .line 250
    .local v0, "clickSteamOrigin":Lcom/amazon/mShop/control/item/ClickStreamTag;
    if-eqz p1, :cond_0

    .line 251
    sget-object v1, Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;->BARCODE:Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;

    invoke-virtual {p1}, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;->getResultType()Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 252
    if-eqz p2, :cond_1

    .line 253
    sget-object v0, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_VIEW_IT_FLOW_ALL_MATCHES_BARCODE:Lcom/amazon/mShop/control/item/ClickStreamTag;

    .line 275
    :cond_0
    :goto_0
    return-object v0

    .line 255
    :cond_1
    if-eqz p3, :cond_2

    .line 256
    sget-object v0, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_VIEW_IT_FLOW_EXPANDED_TRAY_BARCODE:Lcom/amazon/mShop/control/item/ClickStreamTag;

    goto :goto_0

    .line 258
    :cond_2
    sget-object v0, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_VIEW_IT_FLOW_MINI_TRAY_BARCODE:Lcom/amazon/mShop/control/item/ClickStreamTag;

    goto :goto_0

    .line 262
    :cond_3
    sget-object v1, Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;->IMAGE:Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;

    invoke-virtual {p1}, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;->getResultType()Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 263
    if-eqz p2, :cond_4

    .line 264
    sget-object v0, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_VIEW_IT_FLOW_ALL_MATCHES_IMAGE:Lcom/amazon/mShop/control/item/ClickStreamTag;

    goto :goto_0

    .line 266
    :cond_4
    if-eqz p3, :cond_5

    .line 267
    sget-object v0, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_VIEW_IT_FLOW_EXPANDED_TRAY_IMAGE:Lcom/amazon/mShop/control/item/ClickStreamTag;

    goto :goto_0

    .line 269
    :cond_5
    sget-object v0, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_VIEW_IT_FLOW_MINI_TRAY_IMAGE:Lcom/amazon/mShop/control/item/ClickStreamTag;

    goto :goto_0
.end method


# virtual methods
.method protected dispatchSetPressed(Z)V
    .locals 0
    .param p1, "pressed"    # Z

    .prologue
    .line 246
    return-void
.end method

.method public getDeleteButtonHeight()I
    .locals 1

    .prologue
    .line 75
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItItemView;->mDeleteButton:Landroid/widget/Button;

    invoke-virtual {v0}, Landroid/widget/Button;->getVisibility()I

    move-result v0

    if-nez v0, :cond_0

    .line 76
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItItemView;->mDeleteButton:Landroid/widget/Button;

    invoke-virtual {v0}, Landroid/widget/Button;->getHeight()I

    move-result v0

    .line 78
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getGroupObject()Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;
    .locals 1

    .prologue
    .line 71
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItItemView;->mObject:Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;

    return-object v0
.end method

.method protected onFinishInflate()V
    .locals 3

    .prologue
    .line 88
    invoke-super {p0}, Lcom/amazon/mShop/ItemView;->onFinishInflate()V

    .line 89
    sget v1, Lcom/amazon/mShop/android/lib/R$id;->item_image_and_text_content:I

    invoke-virtual {p0, v1}, Lcom/amazon/mShop/search/viewit/ViewItItemView;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/view/ViewGroup;

    iput-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItItemView;->mItemTextAndImageContent:Landroid/view/ViewGroup;

    .line 90
    sget v1, Lcom/amazon/mShop/android/lib/R$id;->item_row_product_info_content:I

    invoke-virtual {p0, v1}, Lcom/amazon/mShop/search/viewit/ViewItItemView;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/view/ViewGroup;

    iput-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItItemView;->mItemProductInfoContent:Landroid/view/ViewGroup;

    .line 91
    sget v1, Lcom/amazon/mShop/android/lib/R$id;->item_undo_content:I

    invoke-virtual {p0, v1}, Lcom/amazon/mShop/search/viewit/ViewItItemView;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/view/ViewGroup;

    iput-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItItemView;->mUndoContent:Landroid/view/ViewGroup;

    .line 92
    sget v1, Lcom/amazon/mShop/android/lib/R$id;->item_row_image:I

    invoke-virtual {p0, v1}, Lcom/amazon/mShop/search/viewit/ViewItItemView;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    iput-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItItemView;->mItemRowImage:Landroid/widget/ImageView;

    .line 94
    sget v1, Lcom/amazon/mShop/android/lib/R$id;->item_button_group:I

    invoke-virtual {p0, v1}, Lcom/amazon/mShop/search/viewit/ViewItItemView;->findViewById(I)Landroid/view/View;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItItemView;->mButtonGroup:Landroid/view/View;

    .line 95
    sget v1, Lcom/amazon/mShop/android/lib/R$id;->delete_button:I

    invoke-virtual {p0, v1}, Lcom/amazon/mShop/search/viewit/ViewItItemView;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    iput-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItItemView;->mDeleteButton:Landroid/widget/Button;

    .line 96
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItItemView;->mDeleteButton:Landroid/widget/Button;

    new-instance v2, Lcom/amazon/mShop/search/viewit/ViewItItemView$1;

    invoke-direct {v2, p0}, Lcom/amazon/mShop/search/viewit/ViewItItemView$1;-><init>(Lcom/amazon/mShop/search/viewit/ViewItItemView;)V

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 113
    sget v1, Lcom/amazon/mShop/android/lib/R$id;->undo_button:I

    invoke-virtual {p0, v1}, Lcom/amazon/mShop/search/viewit/ViewItItemView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    .line 114
    .local v0, "undoButton":Landroid/widget/Button;
    new-instance v1, Lcom/amazon/mShop/search/viewit/ViewItItemView$2;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/search/viewit/ViewItItemView$2;-><init>(Lcom/amazon/mShop/search/viewit/ViewItItemView;)V

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 124
    sget v1, Lcom/amazon/mShop/android/lib/R$id;->more_matched_items_button:I

    invoke-virtual {p0, v1}, Lcom/amazon/mShop/search/viewit/ViewItItemView;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    iput-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItItemView;->mSeeAllMatchedButton:Landroid/widget/Button;

    .line 125
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItItemView;->mSeeAllMatchedButton:Landroid/widget/Button;

    new-instance v2, Lcom/amazon/mShop/search/viewit/ViewItItemView$3;

    invoke-direct {v2, p0}, Lcom/amazon/mShop/search/viewit/ViewItItemView$3;-><init>(Lcom/amazon/mShop/search/viewit/ViewItItemView;)V

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 142
    return-void
.end method

.method public setItemClickAction(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;Z)V
    .locals 7
    .param p1, "slidingDrawer"    # Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;
    .param p2, "item"    # Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;
    .param p3, "wrapper"    # Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;
    .param p4, "isAllMatchesItem"    # Z

    .prologue
    .line 179
    iget-object v6, p0, Lcom/amazon/mShop/search/viewit/ViewItItemView;->mItemTextAndImageContent:Landroid/view/ViewGroup;

    new-instance v0, Lcom/amazon/mShop/search/viewit/ViewItItemView$4;

    move-object v1, p0

    move v2, p4

    move-object v3, p1

    move-object v4, p2

    move-object v5, p3

    invoke-direct/range {v0 .. v5}, Lcom/amazon/mShop/search/viewit/ViewItItemView$4;-><init>(Lcom/amazon/mShop/search/viewit/ViewItItemView;ZLcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;)V

    invoke-virtual {v6, v0}, Landroid/view/ViewGroup;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 214
    return-void
.end method

.method public setObject(Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;Lcom/amazon/mShop/search/viewit/ViewItItemView$ItemShowType;)V
    .locals 0
    .param p1, "object"    # Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;
    .param p2, "result"    # Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;
    .param p3, "browser"    # Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;
    .param p4, "itemType"    # Lcom/amazon/mShop/search/viewit/ViewItItemView$ItemShowType;

    .prologue
    .line 64
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/ViewItItemView;->mObject:Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;

    .line 65
    iput-object p2, p0, Lcom/amazon/mShop/search/viewit/ViewItItemView;->mItemResult:Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;

    .line 66
    iput-object p3, p0, Lcom/amazon/mShop/search/viewit/ViewItItemView;->mBrowser:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;

    .line 67
    iput-object p4, p0, Lcom/amazon/mShop/search/viewit/ViewItItemView;->mItemType:Lcom/amazon/mShop/search/viewit/ViewItItemView$ItemShowType;

    .line 68
    return-void
.end method

.method protected showItemContent()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 173
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItItemView;->mItemTextAndImageContent:Landroid/view/ViewGroup;

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 174
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItItemView;->mButtonGroup:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 175
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItItemView;->mUndoContent:Landroid/view/ViewGroup;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 176
    return-void
.end method

.method protected showUndoButtonContent()V
    .locals 7

    .prologue
    const/16 v6, 0x8

    const/4 v5, 0x0

    .line 161
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItItemView;->mItemResult:Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;->getBasicProduct()Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getTitle()Ljava/lang/String;

    move-result-object v0

    .line 162
    .local v0, "title":Ljava/lang/String;
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItItemView;->mObject:Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItItemView;->mObject:Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;

    invoke-virtual {v1}, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;->getSearchResults()Ljava/util/List;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/util/Collection;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 163
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItItemView;->mObject:Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;

    invoke-virtual {v1}, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;->getSearchResults()Ljava/util/List;

    move-result-object v1

    invoke-interface {v1, v5}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;->getBasicProduct()Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getAsin()Ljava/lang/String;

    move-result-object v0

    .line 166
    :cond_0
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItItemView;->mUndoContent:Landroid/view/ViewGroup;

    sget v2, Lcom/amazon/mShop/android/lib/R$id;->removed_item_txt:I

    invoke-virtual {v1, v2}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItItemView;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/amazon/mShop/android/lib/R$string;->view_it_item_was_removed:I

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    aput-object v0, v4, v5

    invoke-virtual {v2, v3, v4}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 167
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItItemView;->mItemTextAndImageContent:Landroid/view/ViewGroup;

    invoke-virtual {v1, v6}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 168
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItItemView;->mButtonGroup:Landroid/view/View;

    invoke-virtual {v1, v6}, Landroid/view/View;->setVisibility(I)V

    .line 169
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItItemView;->mUndoContent:Landroid/view/ViewGroup;

    invoke-virtual {v1, v5}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 170
    return-void
.end method

.method public update(Lcom/amazon/mShop/ObjectSubscriberAdapter;Ljava/lang/Object;[BI)V
    .locals 10
    .param p1, "adapter"    # Lcom/amazon/mShop/ObjectSubscriberAdapter;
    .param p2, "result"    # Ljava/lang/Object;
    .param p3, "thumbnail"    # [B
    .param p4, "index"    # I

    .prologue
    .line 218
    iget-object v7, p0, Lcom/amazon/mShop/search/viewit/ViewItItemView;->mItemProductInfoContent:Landroid/view/ViewGroup;

    const/4 v8, 0x0

    invoke-virtual {v7, v8}, Landroid/view/ViewGroup;->setVisibility(I)V

    move-object v6, p2

    .line 220
    check-cast v6, Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;

    .line 221
    .local v6, "searchResult":Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;
    invoke-virtual {v6}, Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;->getBasicOffer()Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

    move-result-object v0

    .line 222
    .local v0, "basicOffer":Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;
    invoke-virtual {v6}, Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;->getBasicProduct()Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    move-result-object v1

    .line 223
    .local v1, "basicProduct":Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;
    invoke-virtual {p0, p2}, Lcom/amazon/mShop/search/viewit/ViewItItemView;->setImageRequester(Ljava/lang/Object;)V

    .line 226
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getImageUrl()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItItemView;->getResources()Landroid/content/res/Resources;

    move-result-object v8

    sget v9, Lcom/amazon/mShop/android/lib/R$dimen;->view_it_item_thumbnail_picture_max_dimension:I

    invoke-virtual {v8, v9}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v8

    invoke-static {v7, v8}, Lcom/amazon/mShop/util/ImageUtil;->getImageUrl(Ljava/lang/String;I)Ljava/lang/String;

    move-result-object v2

    .line 227
    .local v2, "imageUrl":Ljava/lang/String;
    const-class v7, Landroid/graphics/Bitmap;

    invoke-static {v2, v7}, Lcom/amazon/mShop/net/LRUCache;->getValue(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/graphics/Bitmap;

    .line 228
    .local v4, "productImageBitmap":Landroid/graphics/Bitmap;
    const/4 v5, 0x0

    .line 229
    .local v5, "productImageDrawable":Landroid/graphics/drawable/Drawable;
    if-eqz v4, :cond_0

    .line 230
    new-instance v3, Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;

    const/4 v7, 0x0

    invoke-direct {v3, v2, v7}, Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;-><init>(Ljava/lang/String;Lcom/amazon/mShop/net/HttpFetcher$Subscriber;)V

    .line 231
    .local v3, "params":Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;
    invoke-static {}, Lcom/amazon/mShop/ui/DrawableFactory;->getInstance()Lcom/amazon/mShop/ui/DrawableFactory$DrawableFactoryInterface;

    move-result-object v7

    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItItemView;->getResources()Landroid/content/res/Resources;

    move-result-object v8

    invoke-interface {v7, v8, v4, v3}, Lcom/amazon/mShop/ui/DrawableFactory$DrawableFactoryInterface;->createDrawable(Landroid/content/res/Resources;Landroid/graphics/Bitmap;Lcom/amazon/mShop/net/HttpFetcher$Params;)Landroid/graphics/drawable/Drawable;

    move-result-object v5

    .line 233
    .end local v3    # "params":Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;
    :cond_0
    iget-object v7, p0, Lcom/amazon/mShop/search/viewit/ViewItItemView;->mItemRowImage:Landroid/widget/ImageView;

    invoke-static {v5, v7}, Lcom/amazon/mShop/details/ItemViewUtils;->updateImageWithDrawable(Landroid/graphics/drawable/Drawable;Landroid/widget/ImageView;)V

    .line 235
    if-nez v5, :cond_1

    if-nez p3, :cond_1

    if-eqz v1, :cond_1

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getImageUrl()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v7

    if-nez v7, :cond_1

    .line 236
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getImageUrl()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItItemView;->getResources()Landroid/content/res/Resources;

    move-result-object v8

    sget v9, Lcom/amazon/mShop/android/lib/R$dimen;->view_it_item_thumbnail_picture_max_dimension:I

    invoke-virtual {v8, v9}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v8

    invoke-virtual {p0, v7, v8}, Lcom/amazon/mShop/search/viewit/ViewItItemView;->getImageFromBackground(Ljava/lang/String;I)V

    .line 239
    :cond_1
    invoke-virtual {p0, p4, v0, v1}, Lcom/amazon/mShop/search/viewit/ViewItItemView;->updateItemView(ILcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;)V

    .line 240
    return-void
.end method

.method protected updateButtonVisibility()V
    .locals 3

    .prologue
    const/16 v2, 0x8

    .line 148
    sget-object v0, Lcom/amazon/mShop/search/viewit/ViewItItemView$ItemShowType;->ITME_SHOW_AS_GROUP:Lcom/amazon/mShop/search/viewit/ViewItItemView$ItemShowType;

    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItItemView;->mItemType:Lcom/amazon/mShop/search/viewit/ViewItItemView$ItemShowType;

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/search/viewit/ViewItItemView$ItemShowType;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItItemView;->mObject:Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;

    invoke-static {v0}, Lcom/amazon/mShop/search/viewit/ViewItUtil;->hasMultipleResults(Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 149
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItItemView;->mSeeAllMatchedButton:Landroid/widget/Button;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setVisibility(I)V

    .line 158
    :cond_0
    :goto_0
    return-void

    .line 151
    :cond_1
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItItemView;->mSeeAllMatchedButton:Landroid/widget/Button;

    invoke-virtual {v0, v2}, Landroid/widget/Button;->setVisibility(I)V

    .line 154
    sget-object v0, Lcom/amazon/mShop/search/viewit/ViewItItemView$ItemShowType;->ITEM_SHOW_IN_ALL_MATCHES:Lcom/amazon/mShop/search/viewit/ViewItItemView$ItemShowType;

    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItItemView;->mItemType:Lcom/amazon/mShop/search/viewit/ViewItItemView$ItemShowType;

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/search/viewit/ViewItItemView$ItemShowType;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 155
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItItemView;->mDeleteButton:Landroid/widget/Button;

    invoke-virtual {v0, v2}, Landroid/widget/Button;->setVisibility(I)V

    goto :goto_0
.end method
