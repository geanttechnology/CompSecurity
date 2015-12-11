.class public Lcom/amazon/mShop/home/HomeShovelerView;
.super Landroid/widget/LinearLayout;
.source "HomeShovelerView.java"

# interfaces
.implements Lcom/amazon/mShop/home/HomeShovelerItemsAdapter$HomeShovelerItemsShownSubscriber;


# instance fields
.field private mHomeCarouselArg:Ljava/lang/String;

.field private mHomeShoveler:Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;

.field private mItemsHorizontalListView:Lcom/amazon/mShop/ui/HorizontalListView;

.field private mLeftFading1:Landroid/view/View;

.field private mLeftFading2:Landroid/view/View;

.field private mMoreLinkRefMarker:Ljava/lang/String;

.field private mPageMetricsCriticalFeatureObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

.field private mPageMetricsObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

.field private mPageMetricsRefreshCriticalFeatureObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

.field private mRequestId:Ljava/lang/String;

.field private mRightFading1:Landroid/view/View;

.field private mRightFading2:Landroid/view/View;

.field private mShovelerMoreLink:Landroid/widget/TextView;

.field private mShovelerTitle:Landroid/widget/TextView;

.field private mshovelerTitleContainer:Landroid/view/ViewGroup;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 51
    invoke-direct {p0, p1, p2}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 52
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/home/HomeShovelerView;)Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/home/HomeShovelerView;

    .prologue
    .line 26
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeShovelerView;->mHomeShoveler:Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;

    return-object v0
.end method

.method static synthetic access$100(Lcom/amazon/mShop/home/HomeShovelerView;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/home/HomeShovelerView;

    .prologue
    .line 26
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeShovelerView;->mMoreLinkRefMarker:Ljava/lang/String;

    return-object v0
.end method

.method private setUpTitleContainerClickListener(Z)V
    .locals 2
    .param p1, "isClickable"    # Z

    .prologue
    .line 87
    if-eqz p1, :cond_0

    .line 88
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeShovelerView;->mshovelerTitleContainer:Landroid/view/ViewGroup;

    new-instance v1, Lcom/amazon/mShop/home/HomeShovelerView$1;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/home/HomeShovelerView$1;-><init>(Lcom/amazon/mShop/home/HomeShovelerView;)V

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 120
    :goto_0
    return-void

    .line 118
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeShovelerView;->mshovelerTitleContainer:Landroid/view/ViewGroup;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto :goto_0
.end method

.method private updateHeight(I)V
    .locals 1
    .param p1, "height"    # I

    .prologue
    .line 251
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->items_horizontal_listview_container:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/home/HomeShovelerView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    iput p1, v0, Landroid/view/ViewGroup$LayoutParams;->height:I

    .line 252
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->items_horizontal_listview:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/home/HomeShovelerView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    iput p1, v0, Landroid/view/ViewGroup$LayoutParams;->height:I

    .line 253
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->shoveler_view_left_fading_1:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/home/HomeShovelerView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    iput p1, v0, Landroid/view/ViewGroup$LayoutParams;->height:I

    .line 254
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->shoveler_view_left_fading_2:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/home/HomeShovelerView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    iput p1, v0, Landroid/view/ViewGroup$LayoutParams;->height:I

    .line 255
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->shoveler_view_right_fading_1:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/home/HomeShovelerView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    iput p1, v0, Landroid/view/ViewGroup$LayoutParams;->height:I

    .line 256
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->shoveler_view_right_fading_2:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/home/HomeShovelerView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    iput p1, v0, Landroid/view/ViewGroup$LayoutParams;->height:I

    .line 257
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->shoveler_view_loading_placeholder:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/home/HomeShovelerView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    iput p1, v0, Landroid/view/ViewGroup$LayoutParams;->height:I

    .line 258
    return-void
.end method

.method private updateTitleContainer()V
    .locals 6

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 166
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeShovelerView;->mHomeShoveler:Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/home/HomeShovelerView;->mHomeShoveler:Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;->getMoreLinkText()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/home/HomeShovelerView;->mHomeShoveler:Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;->getMoreLink()Lcom/amazon/rio/j2me/client/services/mShop/UniversalLink;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 167
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeShovelerView;->mShovelerMoreLink:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/amazon/mShop/home/HomeShovelerView;->mHomeShoveler:Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;->getMoreLinkText()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 168
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeShovelerView;->mShovelerMoreLink:Landroid/widget/TextView;

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setVisibility(I)V

    .line 169
    invoke-direct {p0, v3}, Lcom/amazon/mShop/home/HomeShovelerView;->setUpTitleContainerClickListener(Z)V

    .line 170
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeShovelerView;->mshovelerTitleContainer:Landroid/view/ViewGroup;

    invoke-virtual {v0, v3}, Landroid/view/ViewGroup;->setFocusable(Z)V

    .line 171
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeShovelerView;->mshovelerTitleContainer:Landroid/view/ViewGroup;

    invoke-virtual {v0, v3}, Landroid/view/ViewGroup;->setClickable(Z)V

    .line 172
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeShovelerView;->mshovelerTitleContainer:Landroid/view/ViewGroup;

    sget v1, Lcom/amazon/mShop/android/lib/R$color;->common_arrow_selector:I

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->setBackgroundResource(I)V

    .line 181
    :goto_0
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeShovelerView;->mshovelerTitleContainer:Landroid/view/ViewGroup;

    invoke-virtual {p0}, Lcom/amazon/mShop/home/HomeShovelerView;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    sget v2, Lcom/amazon/mShop/android/lib/R$dimen;->padding:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDimension(I)F

    move-result v1

    float-to-int v1, v1

    invoke-virtual {p0}, Lcom/amazon/mShop/home/HomeShovelerView;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/amazon/mShop/android/lib/R$dimen;->padding:I

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getDimension(I)F

    move-result v2

    float-to-int v2, v2

    invoke-virtual {p0}, Lcom/amazon/mShop/home/HomeShovelerView;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    sget v4, Lcom/amazon/mShop/android/lib/R$dimen;->padding_icon_selector_right:I

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getDimension(I)F

    move-result v3

    float-to-int v3, v3

    invoke-virtual {p0}, Lcom/amazon/mShop/home/HomeShovelerView;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    sget v5, Lcom/amazon/mShop/android/lib/R$dimen;->padding:I

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getDimension(I)F

    move-result v4

    float-to-int v4, v4

    invoke-virtual {v0, v1, v2, v3, v4}, Landroid/view/ViewGroup;->setPadding(IIII)V

    .line 183
    return-void

    .line 174
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeShovelerView;->mShovelerMoreLink:Landroid/widget/TextView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 175
    invoke-direct {p0, v2}, Lcom/amazon/mShop/home/HomeShovelerView;->setUpTitleContainerClickListener(Z)V

    .line 176
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeShovelerView;->mshovelerTitleContainer:Landroid/view/ViewGroup;

    invoke-virtual {v0, v2}, Landroid/view/ViewGroup;->setFocusable(Z)V

    .line 177
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeShovelerView;->mshovelerTitleContainer:Landroid/view/ViewGroup;

    invoke-virtual {v0, v2}, Landroid/view/ViewGroup;->setClickable(Z)V

    .line 178
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeShovelerView;->mshovelerTitleContainer:Landroid/view/ViewGroup;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    goto :goto_0
.end method


# virtual methods
.method public clear()V
    .locals 4

    .prologue
    const/4 v1, 0x0

    const/16 v3, 0x8

    const/4 v2, 0x0

    .line 192
    iput-object v1, p0, Lcom/amazon/mShop/home/HomeShovelerView;->mHomeShoveler:Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;

    .line 193
    invoke-virtual {p0, v1}, Lcom/amazon/mShop/home/HomeShovelerView;->updateShovelerTitle(Ljava/lang/String;)V

    .line 194
    invoke-direct {p0}, Lcom/amazon/mShop/home/HomeShovelerView;->updateTitleContainer()V

    .line 195
    sget v1, Lcom/amazon/mShop/android/lib/R$id;->shoveler_view_loading_placeholder:I

    invoke-virtual {p0, v1}, Lcom/amazon/mShop/home/HomeShovelerView;->findViewById(I)Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1, v2}, Landroid/view/View;->setVisibility(I)V

    .line 196
    sget v1, Lcom/amazon/mShop/android/lib/R$id;->shoveler_view_loading_progressbar:I

    invoke-virtual {p0, v1}, Lcom/amazon/mShop/home/HomeShovelerView;->findViewById(I)Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1, v2}, Landroid/view/View;->setVisibility(I)V

    .line 197
    sget v1, Lcom/amazon/mShop/android/lib/R$id;->items_horizontal_listview:I

    invoke-virtual {p0, v1}, Lcom/amazon/mShop/home/HomeShovelerView;->findViewById(I)Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1, v3}, Landroid/view/View;->setVisibility(I)V

    .line 198
    sget v1, Lcom/amazon/mShop/android/lib/R$id;->items_horizontal_listview_container:I

    invoke-virtual {p0, v1}, Lcom/amazon/mShop/home/HomeShovelerView;->findViewById(I)Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1, v3}, Landroid/view/View;->setVisibility(I)V

    .line 199
    iget-object v1, p0, Lcom/amazon/mShop/home/HomeShovelerView;->mItemsHorizontalListView:Lcom/amazon/mShop/ui/HorizontalListView;

    invoke-virtual {v1}, Lcom/amazon/mShop/ui/HorizontalListView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;

    .line 200
    .local v0, "adapter":Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;
    if-eqz v0, :cond_0

    .line 201
    invoke-virtual {v0}, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->reset()V

    .line 203
    :cond_0
    return-void
.end method

.method protected onDetachedFromWindow()V
    .locals 2

    .prologue
    .line 215
    invoke-super {p0}, Landroid/widget/LinearLayout;->onDetachedFromWindow()V

    .line 218
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->shoveler_view_loading_progressbar:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/home/HomeShovelerView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 219
    return-void
.end method

.method protected onFinishInflate()V
    .locals 2

    .prologue
    .line 56
    invoke-super {p0}, Landroid/widget/LinearLayout;->onFinishInflate()V

    .line 57
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->home_shoveler_title:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/home/HomeShovelerView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/amazon/mShop/home/HomeShovelerView;->mShovelerTitle:Landroid/widget/TextView;

    .line 58
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->home_shoveler_more_link:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/home/HomeShovelerView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/amazon/mShop/home/HomeShovelerView;->mShovelerMoreLink:Landroid/widget/TextView;

    .line 59
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->items_horizontal_listview:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/home/HomeShovelerView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/ui/HorizontalListView;

    iput-object v0, p0, Lcom/amazon/mShop/home/HomeShovelerView;->mItemsHorizontalListView:Lcom/amazon/mShop/ui/HorizontalListView;

    .line 60
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeShovelerView;->mItemsHorizontalListView:Lcom/amazon/mShop/ui/HorizontalListView;

    sget v1, Lcom/amazon/mShop/android/lib/R$drawable;->orange_outline_sharp_corner:I

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/ui/HorizontalListView;->setHighlightBackgroundResource(I)V

    .line 61
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeShovelerView;->mItemsHorizontalListView:Lcom/amazon/mShop/ui/HorizontalListView;

    sget v1, Lcom/amazon/mShop/android/lib/R$color;->transparent:I

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/ui/HorizontalListView;->setNormalBackgroundResource(I)V

    .line 62
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->home_shoveler_title_container:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/home/HomeShovelerView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    iput-object v0, p0, Lcom/amazon/mShop/home/HomeShovelerView;->mshovelerTitleContainer:Landroid/view/ViewGroup;

    .line 64
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->shoveler_view_left_fading_1:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/home/HomeShovelerView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/home/HomeShovelerView;->mLeftFading1:Landroid/view/View;

    .line 65
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->shoveler_view_left_fading_2:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/home/HomeShovelerView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/home/HomeShovelerView;->mLeftFading2:Landroid/view/View;

    .line 66
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->shoveler_view_right_fading_1:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/home/HomeShovelerView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/home/HomeShovelerView;->mRightFading1:Landroid/view/View;

    .line 67
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->shoveler_view_right_fading_2:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/home/HomeShovelerView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/home/HomeShovelerView;->mRightFading2:Landroid/view/View;

    .line 68
    return-void
.end method

.method public onHomeShovelerItemsShown()V
    .locals 3

    .prologue
    const/16 v2, 0x8

    const/4 v1, 0x0

    .line 207
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->shoveler_view_loading_placeholder:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/home/HomeShovelerView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    .line 208
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->shoveler_view_loading_progressbar:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/home/HomeShovelerView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    .line 209
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->items_horizontal_listview:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/home/HomeShovelerView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 210
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->items_horizontal_listview_container:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/home/HomeShovelerView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 211
    return-void
.end method

.method public onMostLeftItemFocused(Z)V
    .locals 3
    .param p1, "focused"    # Z

    .prologue
    const/16 v2, 0x8

    const/4 v1, 0x0

    .line 230
    if-eqz p1, :cond_0

    .line 231
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeShovelerView;->mLeftFading1:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    .line 232
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeShovelerView;->mLeftFading2:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    .line 237
    :goto_0
    return-void

    .line 234
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeShovelerView;->mLeftFading1:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 235
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeShovelerView;->mLeftFading2:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    goto :goto_0
.end method

.method public onMostRightItemFocused(Z)V
    .locals 3
    .param p1, "focused"    # Z

    .prologue
    const/16 v2, 0x8

    const/4 v1, 0x0

    .line 241
    if-eqz p1, :cond_0

    .line 242
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeShovelerView;->mRightFading1:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    .line 243
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeShovelerView;->mRightFading2:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    .line 248
    :goto_0
    return-void

    .line 245
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeShovelerView;->mRightFading1:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 246
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeShovelerView;->mRightFading2:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    goto :goto_0
.end method

.method public setHomeCarouselArg(Ljava/lang/String;)V
    .locals 0
    .param p1, "arg"    # Ljava/lang/String;

    .prologue
    .line 75
    iput-object p1, p0, Lcom/amazon/mShop/home/HomeShovelerView;->mHomeCarouselArg:Ljava/lang/String;

    .line 76
    return-void
.end method

.method public setMoreLinkRefMarker(Ljava/lang/String;)V
    .locals 0
    .param p1, "refMarker"    # Ljava/lang/String;

    .prologue
    .line 71
    iput-object p1, p0, Lcom/amazon/mShop/home/HomeShovelerView;->mMoreLinkRefMarker:Ljava/lang/String;

    .line 72
    return-void
.end method

.method public update(Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;Lcom/amazon/mShop/net/PageMetricsObserver;Lcom/amazon/mShop/net/PageMetricsObserver;Lcom/amazon/mShop/net/PageMetricsObserver;Ljava/lang/String;)V
    .locals 13
    .param p1, "shoveler"    # Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;
    .param p2, "pageMetricsObserver"    # Lcom/amazon/mShop/net/PageMetricsObserver;
    .param p3, "pageMetricsCriticalFeatureObserver"    # Lcom/amazon/mShop/net/PageMetricsObserver;
    .param p4, "pageMetricsRefreshCriticalFeatureObserver"    # Lcom/amazon/mShop/net/PageMetricsObserver;
    .param p5, "requestId"    # Ljava/lang/String;

    .prologue
    .line 123
    if-nez p1, :cond_0

    .line 163
    :goto_0
    return-void

    .line 126
    :cond_0
    move-object/from16 v0, p5

    iput-object v0, p0, Lcom/amazon/mShop/home/HomeShovelerView;->mRequestId:Ljava/lang/String;

    .line 127
    iput-object p2, p0, Lcom/amazon/mShop/home/HomeShovelerView;->mPageMetricsObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    .line 128
    move-object/from16 v0, p3

    iput-object v0, p0, Lcom/amazon/mShop/home/HomeShovelerView;->mPageMetricsCriticalFeatureObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    .line 129
    move-object/from16 v0, p4

    iput-object v0, p0, Lcom/amazon/mShop/home/HomeShovelerView;->mPageMetricsRefreshCriticalFeatureObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    .line 130
    iput-object p1, p0, Lcom/amazon/mShop/home/HomeShovelerView;->mHomeShoveler:Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;

    .line 131
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;->getTitle()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v2}, Lcom/amazon/mShop/home/HomeShovelerView;->updateShovelerTitle(Ljava/lang/String;)V

    .line 132
    invoke-direct {p0}, Lcom/amazon/mShop/home/HomeShovelerView;->updateTitleContainer()V

    .line 134
    const/4 v12, 0x0

    .line 138
    .local v12, "listHeight":I
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;->getDisplayType()Ljava/lang/Integer;

    move-result-object v2

    const/4 v3, 0x1

    invoke-static {v2, v3}, Lcom/amazon/mShop/util/DataUtil;->isEqual(Ljava/lang/Integer;I)Z

    move-result v2

    if-eqz v2, :cond_4

    .line 139
    invoke-virtual {p0}, Lcom/amazon/mShop/home/HomeShovelerView;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/amazon/mShop/android/lib/R$dimen;->home_view_shoveler_view_thumbnail_max_dimension:I

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getDimension(I)F

    move-result v2

    float-to-int v12, v2

    .line 144
    :goto_1
    invoke-direct {p0, v12}, Lcom/amazon/mShop/home/HomeShovelerView;->updateHeight(I)V

    .line 146
    new-instance v1, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;

    invoke-virtual {p0}, Lcom/amazon/mShop/home/HomeShovelerView;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;->getSlotToken()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;->getClickStreamOrigin()Ljava/lang/String;

    move-result-object v4

    iget-object v5, p0, Lcom/amazon/mShop/home/HomeShovelerView;->mHomeCarouselArg:Ljava/lang/String;

    iget-object v6, p0, Lcom/amazon/mShop/home/HomeShovelerView;->mPageMetricsObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    iget-object v7, p0, Lcom/amazon/mShop/home/HomeShovelerView;->mPageMetricsCriticalFeatureObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    iget-object v8, p0, Lcom/amazon/mShop/home/HomeShovelerView;->mPageMetricsRefreshCriticalFeatureObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    iget-object v10, p0, Lcom/amazon/mShop/home/HomeShovelerView;->mRequestId:Ljava/lang/String;

    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;->getDisplayType()Ljava/lang/Integer;

    move-result-object v11

    move-object v9, p0

    invoke-direct/range {v1 .. v11}, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;-><init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/mShop/net/PageMetricsObserver;Lcom/amazon/mShop/net/PageMetricsObserver;Lcom/amazon/mShop/net/PageMetricsObserver;Lcom/amazon/mShop/home/HomeShovelerItemsAdapter$HomeShovelerItemsShownSubscriber;Ljava/lang/String;Ljava/lang/Integer;)V

    .line 149
    .local v1, "adapter":Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;
    iget-object v2, p0, Lcom/amazon/mShop/home/HomeShovelerView;->mPageMetricsObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    if-eqz v2, :cond_1

    .line 150
    iget-object v2, p0, Lcom/amazon/mShop/home/HomeShovelerView;->mPageMetricsObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    const-class v3, Lcom/amazon/mShop/home/HomeShovelerView;

    invoke-virtual {v3}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/amazon/mShop/net/PageMetricsObserver;->startForObject(Ljava/lang/String;)V

    .line 153
    :cond_1
    iget-object v2, p0, Lcom/amazon/mShop/home/HomeShovelerView;->mPageMetricsCriticalFeatureObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    if-eqz v2, :cond_2

    .line 154
    iget-object v2, p0, Lcom/amazon/mShop/home/HomeShovelerView;->mPageMetricsCriticalFeatureObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    const-class v3, Lcom/amazon/mShop/home/HomeShovelerView;

    invoke-virtual {v3}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/amazon/mShop/net/PageMetricsObserver;->startForObject(Ljava/lang/String;)V

    .line 157
    :cond_2
    iget-object v2, p0, Lcom/amazon/mShop/home/HomeShovelerView;->mPageMetricsRefreshCriticalFeatureObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    if-eqz v2, :cond_3

    .line 158
    iget-object v2, p0, Lcom/amazon/mShop/home/HomeShovelerView;->mPageMetricsRefreshCriticalFeatureObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    const-class v3, Lcom/amazon/mShop/home/HomeShovelerView;

    invoke-virtual {v3}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/amazon/mShop/net/PageMetricsObserver;->startForObject(Ljava/lang/String;)V

    .line 161
    :cond_3
    iget-object v2, p0, Lcom/amazon/mShop/home/HomeShovelerView;->mItemsHorizontalListView:Lcom/amazon/mShop/ui/HorizontalListView;

    invoke-virtual {v2, v1}, Lcom/amazon/mShop/ui/HorizontalListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 162
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;->getItems()Ljava/util/List;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->setRawItems(Ljava/util/List;)V

    goto/16 :goto_0

    .line 141
    .end local v1    # "adapter":Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;
    :cond_4
    invoke-virtual {p0}, Lcom/amazon/mShop/home/HomeShovelerView;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/amazon/mShop/android/lib/R$dimen;->home_view_shoveler_view_height:I

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getDimension(I)F

    move-result v2

    float-to-int v12, v2

    goto :goto_1
.end method

.method public updateShovelerTitle(Ljava/lang/String;)V
    .locals 2
    .param p1, "title"    # Ljava/lang/String;

    .prologue
    .line 79
    invoke-static {p1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 80
    invoke-virtual {p0}, Lcom/amazon/mShop/home/HomeShovelerView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->loading:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object p1

    .line 82
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeShovelerView;->mShovelerTitle:Landroid/widget/TextView;

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 83
    return-void
.end method
