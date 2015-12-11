.class public Lcom/amazon/retailsearch/android/ui/HeaderFooterListAdapter;
.super Ljava/lang/Object;
.source "HeaderFooterListAdapter.java"

# interfaces
.implements Landroid/widget/Filterable;
.implements Landroid/widget/WrapperListAdapter;


# static fields
.field static final EMPTY_INFO_LIST:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/amazon/retailsearch/android/ui/HorizontalListView$FixedViewInfo;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private final mAdapter:Landroid/widget/ListAdapter;

.field mAreAllFixedViewsSelectable:Z

.field mFooterViewInfos:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/amazon/retailsearch/android/ui/HorizontalListView$FixedViewInfo;",
            ">;"
        }
    .end annotation
.end field

.field mHeaderViewInfos:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/amazon/retailsearch/android/ui/HorizontalListView$FixedViewInfo;",
            ">;"
        }
    .end annotation
.end field

.field private final mIsFilterable:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 55
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    sput-object v0, Lcom/amazon/retailsearch/android/ui/HeaderFooterListAdapter;->EMPTY_INFO_LIST:Ljava/util/ArrayList;

    return-void
.end method

.method public constructor <init>(Ljava/util/ArrayList;Ljava/util/ArrayList;Landroid/widget/ListAdapter;)V
    .locals 1
    .param p3, "adapter"    # Landroid/widget/ListAdapter;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/amazon/retailsearch/android/ui/HorizontalListView$FixedViewInfo;",
            ">;",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/amazon/retailsearch/android/ui/HorizontalListView$FixedViewInfo;",
            ">;",
            "Landroid/widget/ListAdapter;",
            ")V"
        }
    .end annotation

    .prologue
    .line 63
    .local p1, "headerViewInfos":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/amazon/retailsearch/android/ui/HorizontalListView$FixedViewInfo;>;"
    .local p2, "footerViewInfos":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/amazon/retailsearch/android/ui/HorizontalListView$FixedViewInfo;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 64
    iput-object p3, p0, Lcom/amazon/retailsearch/android/ui/HeaderFooterListAdapter;->mAdapter:Landroid/widget/ListAdapter;

    .line 65
    instance-of v0, p3, Landroid/widget/Filterable;

    iput-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/HeaderFooterListAdapter;->mIsFilterable:Z

    .line 67
    if-nez p1, :cond_0

    .line 69
    sget-object v0, Lcom/amazon/retailsearch/android/ui/HeaderFooterListAdapter;->EMPTY_INFO_LIST:Ljava/util/ArrayList;

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/HeaderFooterListAdapter;->mHeaderViewInfos:Ljava/util/ArrayList;

    .line 76
    :goto_0
    if-nez p2, :cond_1

    .line 78
    sget-object v0, Lcom/amazon/retailsearch/android/ui/HeaderFooterListAdapter;->EMPTY_INFO_LIST:Ljava/util/ArrayList;

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/HeaderFooterListAdapter;->mFooterViewInfos:Ljava/util/ArrayList;

    .line 85
    :goto_1
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/HeaderFooterListAdapter;->mHeaderViewInfos:Ljava/util/ArrayList;

    invoke-direct {p0, v0}, Lcom/amazon/retailsearch/android/ui/HeaderFooterListAdapter;->areAllListInfosSelectable(Ljava/util/ArrayList;)Z

    move-result v0

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/HeaderFooterListAdapter;->mFooterViewInfos:Ljava/util/ArrayList;

    invoke-direct {p0, v0}, Lcom/amazon/retailsearch/android/ui/HeaderFooterListAdapter;->areAllListInfosSelectable(Ljava/util/ArrayList;)Z

    move-result v0

    if-eqz v0, :cond_2

    const/4 v0, 0x1

    :goto_2
    iput-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/HeaderFooterListAdapter;->mAreAllFixedViewsSelectable:Z

    .line 87
    return-void

    .line 73
    :cond_0
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/HeaderFooterListAdapter;->mHeaderViewInfos:Ljava/util/ArrayList;

    goto :goto_0

    .line 82
    :cond_1
    iput-object p2, p0, Lcom/amazon/retailsearch/android/ui/HeaderFooterListAdapter;->mFooterViewInfos:Ljava/util/ArrayList;

    goto :goto_1

    .line 85
    :cond_2
    const/4 v0, 0x0

    goto :goto_2
.end method

.method private areAllListInfosSelectable(Ljava/util/ArrayList;)Z
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/amazon/retailsearch/android/ui/HorizontalListView$FixedViewInfo;",
            ">;)Z"
        }
    .end annotation

    .prologue
    .line 106
    .local p1, "infos":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/amazon/retailsearch/android/ui/HorizontalListView$FixedViewInfo;>;"
    if-eqz p1, :cond_1

    .line 108
    invoke-virtual {p1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/retailsearch/android/ui/HorizontalListView$FixedViewInfo;

    .line 110
    .local v1, "info":Lcom/amazon/retailsearch/android/ui/HorizontalListView$FixedViewInfo;
    iget-boolean v2, v1, Lcom/amazon/retailsearch/android/ui/HorizontalListView$FixedViewInfo;->isSelectable:Z

    if-nez v2, :cond_0

    .line 112
    const/4 v2, 0x0

    .line 116
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v1    # "info":Lcom/amazon/retailsearch/android/ui/HorizontalListView$FixedViewInfo;
    :goto_0
    return v2

    :cond_1
    const/4 v2, 0x1

    goto :goto_0
.end method


# virtual methods
.method public areAllItemsEnabled()Z
    .locals 2

    .prologue
    const/4 v0, 0x1

    .line 171
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/HeaderFooterListAdapter;->mAdapter:Landroid/widget/ListAdapter;

    if-eqz v1, :cond_0

    .line 173
    iget-boolean v1, p0, Lcom/amazon/retailsearch/android/ui/HeaderFooterListAdapter;->mAreAllFixedViewsSelectable:Z

    if-eqz v1, :cond_1

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/HeaderFooterListAdapter;->mAdapter:Landroid/widget/ListAdapter;

    invoke-interface {v1}, Landroid/widget/ListAdapter;->areAllItemsEnabled()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 177
    :cond_0
    :goto_0
    return v0

    .line 173
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getCount()I
    .locals 2

    .prologue
    .line 159
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/HeaderFooterListAdapter;->mAdapter:Landroid/widget/ListAdapter;

    if-eqz v0, :cond_0

    .line 161
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/HeaderFooterListAdapter;->getFootersCount()I

    move-result v0

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/HeaderFooterListAdapter;->getHeadersCount()I

    move-result v1

    add-int/2addr v0, v1

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/HeaderFooterListAdapter;->mAdapter:Landroid/widget/ListAdapter;

    invoke-interface {v1}, Landroid/widget/ListAdapter;->getCount()I

    move-result v1

    add-int/2addr v0, v1

    .line 165
    :goto_0
    return v0

    :cond_0
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/HeaderFooterListAdapter;->getFootersCount()I

    move-result v0

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/HeaderFooterListAdapter;->getHeadersCount()I

    move-result v1

    add-int/2addr v0, v1

    goto :goto_0
.end method

.method public getFilter()Landroid/widget/Filter;
    .locals 1

    .prologue
    .line 329
    iget-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/HeaderFooterListAdapter;->mIsFilterable:Z

    if-eqz v0, :cond_0

    .line 331
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/HeaderFooterListAdapter;->mAdapter:Landroid/widget/ListAdapter;

    check-cast v0, Landroid/widget/Filterable;

    invoke-interface {v0}, Landroid/widget/Filterable;->getFilter()Landroid/widget/Filter;

    move-result-object v0

    .line 333
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getFootersCount()I
    .locals 1

    .prologue
    .line 96
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/HeaderFooterListAdapter;->mFooterViewInfos:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    return v0
.end method

.method public getHeadersCount()I
    .locals 1

    .prologue
    .line 91
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/HeaderFooterListAdapter;->mHeaderViewInfos:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    return v0
.end method

.method public getItem(I)Ljava/lang/Object;
    .locals 5
    .param p1, "position"    # I

    .prologue
    .line 212
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/HeaderFooterListAdapter;->getHeadersCount()I

    move-result v2

    .line 213
    .local v2, "numHeaders":I
    if-ge p1, v2, :cond_0

    .line 215
    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/HeaderFooterListAdapter;->mHeaderViewInfos:Ljava/util/ArrayList;

    invoke-virtual {v3, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/amazon/retailsearch/android/ui/HorizontalListView$FixedViewInfo;

    iget-object v3, v3, Lcom/amazon/retailsearch/android/ui/HorizontalListView$FixedViewInfo;->data:Ljava/lang/Object;

    .line 232
    :goto_0
    return-object v3

    .line 219
    :cond_0
    sub-int v1, p1, v2

    .line 220
    .local v1, "adjPosition":I
    const/4 v0, 0x0

    .line 221
    .local v0, "adapterCount":I
    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/HeaderFooterListAdapter;->mAdapter:Landroid/widget/ListAdapter;

    if-eqz v3, :cond_1

    .line 223
    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/HeaderFooterListAdapter;->mAdapter:Landroid/widget/ListAdapter;

    invoke-interface {v3}, Landroid/widget/ListAdapter;->getCount()I

    move-result v0

    .line 224
    if-ge v1, v0, :cond_1

    .line 226
    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/HeaderFooterListAdapter;->mAdapter:Landroid/widget/ListAdapter;

    invoke-interface {v3, v1}, Landroid/widget/ListAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v3

    goto :goto_0

    .line 232
    :cond_1
    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/HeaderFooterListAdapter;->mFooterViewInfos:Ljava/util/ArrayList;

    sub-int v4, v1, v0

    invoke-virtual {v3, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/amazon/retailsearch/android/ui/HorizontalListView$FixedViewInfo;

    iget-object v3, v3, Lcom/amazon/retailsearch/android/ui/HorizontalListView$FixedViewInfo;->data:Ljava/lang/Object;

    goto :goto_0
.end method

.method public getItemId(I)J
    .locals 5
    .param p1, "position"    # I

    .prologue
    .line 237
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/HeaderFooterListAdapter;->getHeadersCount()I

    move-result v2

    .line 238
    .local v2, "numHeaders":I
    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/HeaderFooterListAdapter;->mAdapter:Landroid/widget/ListAdapter;

    if-eqz v3, :cond_0

    if-lt p1, v2, :cond_0

    .line 240
    sub-int v1, p1, v2

    .line 241
    .local v1, "adjPosition":I
    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/HeaderFooterListAdapter;->mAdapter:Landroid/widget/ListAdapter;

    invoke-interface {v3}, Landroid/widget/ListAdapter;->getCount()I

    move-result v0

    .line 242
    .local v0, "adapterCount":I
    if-ge v1, v0, :cond_0

    .line 244
    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/HeaderFooterListAdapter;->mAdapter:Landroid/widget/ListAdapter;

    invoke-interface {v3, v1}, Landroid/widget/ListAdapter;->getItemId(I)J

    move-result-wide v3

    .line 247
    .end local v0    # "adapterCount":I
    .end local v1    # "adjPosition":I
    :goto_0
    return-wide v3

    :cond_0
    const-wide/16 v3, -0x1

    goto :goto_0
.end method

.method public getItemViewType(I)I
    .locals 4
    .param p1, "position"    # I

    .prologue
    .line 288
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/HeaderFooterListAdapter;->getHeadersCount()I

    move-result v2

    .line 289
    .local v2, "numHeaders":I
    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/HeaderFooterListAdapter;->mAdapter:Landroid/widget/ListAdapter;

    if-eqz v3, :cond_0

    if-lt p1, v2, :cond_0

    .line 291
    sub-int v1, p1, v2

    .line 292
    .local v1, "adjPosition":I
    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/HeaderFooterListAdapter;->mAdapter:Landroid/widget/ListAdapter;

    invoke-interface {v3}, Landroid/widget/ListAdapter;->getCount()I

    move-result v0

    .line 293
    .local v0, "adapterCount":I
    if-ge v1, v0, :cond_0

    .line 295
    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/HeaderFooterListAdapter;->mAdapter:Landroid/widget/ListAdapter;

    invoke-interface {v3, v1}, Landroid/widget/ListAdapter;->getItemViewType(I)I

    move-result v3

    .line 299
    .end local v0    # "adapterCount":I
    .end local v1    # "adjPosition":I
    :goto_0
    return v3

    :cond_0
    const/4 v3, -0x2

    goto :goto_0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 5
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 263
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/HeaderFooterListAdapter;->getHeadersCount()I

    move-result v2

    .line 264
    .local v2, "numHeaders":I
    if-ge p1, v2, :cond_0

    .line 266
    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/HeaderFooterListAdapter;->mHeaderViewInfos:Ljava/util/ArrayList;

    invoke-virtual {v3, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/amazon/retailsearch/android/ui/HorizontalListView$FixedViewInfo;

    iget-object v3, v3, Lcom/amazon/retailsearch/android/ui/HorizontalListView$FixedViewInfo;->view:Landroid/view/View;

    .line 283
    :goto_0
    return-object v3

    .line 270
    :cond_0
    sub-int v1, p1, v2

    .line 271
    .local v1, "adjPosition":I
    const/4 v0, 0x0

    .line 272
    .local v0, "adapterCount":I
    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/HeaderFooterListAdapter;->mAdapter:Landroid/widget/ListAdapter;

    if-eqz v3, :cond_1

    .line 274
    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/HeaderFooterListAdapter;->mAdapter:Landroid/widget/ListAdapter;

    invoke-interface {v3}, Landroid/widget/ListAdapter;->getCount()I

    move-result v0

    .line 275
    if-ge v1, v0, :cond_1

    .line 277
    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/HeaderFooterListAdapter;->mAdapter:Landroid/widget/ListAdapter;

    invoke-interface {v3, v1, p2, p3}, Landroid/widget/ListAdapter;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v3

    goto :goto_0

    .line 283
    :cond_1
    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/HeaderFooterListAdapter;->mFooterViewInfos:Ljava/util/ArrayList;

    sub-int v4, v1, v0

    invoke-virtual {v3, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/amazon/retailsearch/android/ui/HorizontalListView$FixedViewInfo;

    iget-object v3, v3, Lcom/amazon/retailsearch/android/ui/HorizontalListView$FixedViewInfo;->view:Landroid/view/View;

    goto :goto_0
.end method

.method public getViewTypeCount()I
    .locals 1

    .prologue
    .line 304
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/HeaderFooterListAdapter;->mAdapter:Landroid/widget/ListAdapter;

    if-eqz v0, :cond_0

    .line 306
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/HeaderFooterListAdapter;->mAdapter:Landroid/widget/ListAdapter;

    invoke-interface {v0}, Landroid/widget/ListAdapter;->getViewTypeCount()I

    move-result v0

    .line 308
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public getWrappedAdapter()Landroid/widget/ListAdapter;
    .locals 1

    .prologue
    .line 338
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/HeaderFooterListAdapter;->mAdapter:Landroid/widget/ListAdapter;

    return-object v0
.end method

.method public hasStableIds()Z
    .locals 1

    .prologue
    .line 252
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/HeaderFooterListAdapter;->mAdapter:Landroid/widget/ListAdapter;

    if-eqz v0, :cond_0

    .line 254
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/HeaderFooterListAdapter;->mAdapter:Landroid/widget/ListAdapter;

    invoke-interface {v0}, Landroid/widget/ListAdapter;->hasStableIds()Z

    move-result v0

    .line 256
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isEmpty()Z
    .locals 1

    .prologue
    .line 101
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/HeaderFooterListAdapter;->mAdapter:Landroid/widget/ListAdapter;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/HeaderFooterListAdapter;->mAdapter:Landroid/widget/ListAdapter;

    invoke-interface {v0}, Landroid/widget/ListAdapter;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isEnabled(I)Z
    .locals 5
    .param p1, "position"    # I

    .prologue
    .line 185
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/HeaderFooterListAdapter;->getHeadersCount()I

    move-result v2

    .line 186
    .local v2, "numHeaders":I
    if-ge p1, v2, :cond_0

    .line 188
    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/HeaderFooterListAdapter;->mHeaderViewInfos:Ljava/util/ArrayList;

    invoke-virtual {v3, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/amazon/retailsearch/android/ui/HorizontalListView$FixedViewInfo;

    iget-boolean v3, v3, Lcom/amazon/retailsearch/android/ui/HorizontalListView$FixedViewInfo;->isSelectable:Z

    .line 205
    :goto_0
    return v3

    .line 192
    :cond_0
    sub-int v1, p1, v2

    .line 193
    .local v1, "adjPosition":I
    const/4 v0, 0x0

    .line 194
    .local v0, "adapterCount":I
    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/HeaderFooterListAdapter;->mAdapter:Landroid/widget/ListAdapter;

    if-eqz v3, :cond_1

    .line 196
    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/HeaderFooterListAdapter;->mAdapter:Landroid/widget/ListAdapter;

    invoke-interface {v3}, Landroid/widget/ListAdapter;->getCount()I

    move-result v0

    .line 197
    if-ge v1, v0, :cond_1

    .line 199
    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/HeaderFooterListAdapter;->mAdapter:Landroid/widget/ListAdapter;

    invoke-interface {v3, v1}, Landroid/widget/ListAdapter;->isEnabled(I)Z

    move-result v3

    goto :goto_0

    .line 205
    :cond_1
    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/HeaderFooterListAdapter;->mFooterViewInfos:Ljava/util/ArrayList;

    sub-int v4, v1, v0

    invoke-virtual {v3, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/amazon/retailsearch/android/ui/HorizontalListView$FixedViewInfo;

    iget-boolean v3, v3, Lcom/amazon/retailsearch/android/ui/HorizontalListView$FixedViewInfo;->isSelectable:Z

    goto :goto_0
.end method

.method public registerDataSetObserver(Landroid/database/DataSetObserver;)V
    .locals 1
    .param p1, "observer"    # Landroid/database/DataSetObserver;

    .prologue
    .line 313
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/HeaderFooterListAdapter;->mAdapter:Landroid/widget/ListAdapter;

    if-eqz v0, :cond_0

    .line 315
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/HeaderFooterListAdapter;->mAdapter:Landroid/widget/ListAdapter;

    invoke-interface {v0, p1}, Landroid/widget/ListAdapter;->registerDataSetObserver(Landroid/database/DataSetObserver;)V

    .line 317
    :cond_0
    return-void
.end method

.method public removeFooter(Landroid/view/View;)Z
    .locals 5
    .param p1, "v"    # Landroid/view/View;

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 140
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/HeaderFooterListAdapter;->mFooterViewInfos:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    move-result v4

    if-ge v0, v4, :cond_2

    .line 142
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/HeaderFooterListAdapter;->mFooterViewInfos:Ljava/util/ArrayList;

    invoke-virtual {v4, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/retailsearch/android/ui/HorizontalListView$FixedViewInfo;

    .line 143
    .local v1, "info":Lcom/amazon/retailsearch/android/ui/HorizontalListView$FixedViewInfo;
    iget-object v4, v1, Lcom/amazon/retailsearch/android/ui/HorizontalListView$FixedViewInfo;->view:Landroid/view/View;

    if-ne v4, p1, :cond_1

    .line 145
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/HeaderFooterListAdapter;->mFooterViewInfos:Ljava/util/ArrayList;

    invoke-virtual {v4, v0}, Ljava/util/ArrayList;->remove(I)Ljava/lang/Object;

    .line 147
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/HeaderFooterListAdapter;->mHeaderViewInfos:Ljava/util/ArrayList;

    invoke-direct {p0, v4}, Lcom/amazon/retailsearch/android/ui/HeaderFooterListAdapter;->areAllListInfosSelectable(Ljava/util/ArrayList;)Z

    move-result v4

    if-eqz v4, :cond_0

    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/HeaderFooterListAdapter;->mFooterViewInfos:Ljava/util/ArrayList;

    invoke-direct {p0, v4}, Lcom/amazon/retailsearch/android/ui/HeaderFooterListAdapter;->areAllListInfosSelectable(Ljava/util/ArrayList;)Z

    move-result v4

    if-eqz v4, :cond_0

    move v2, v3

    :cond_0
    iput-boolean v2, p0, Lcom/amazon/retailsearch/android/ui/HeaderFooterListAdapter;->mAreAllFixedViewsSelectable:Z

    .line 154
    .end local v1    # "info":Lcom/amazon/retailsearch/android/ui/HorizontalListView$FixedViewInfo;
    :goto_1
    return v3

    .line 140
    .restart local v1    # "info":Lcom/amazon/retailsearch/android/ui/HorizontalListView$FixedViewInfo;
    :cond_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .end local v1    # "info":Lcom/amazon/retailsearch/android/ui/HorizontalListView$FixedViewInfo;
    :cond_2
    move v3, v2

    .line 154
    goto :goto_1
.end method

.method public removeHeader(Landroid/view/View;)Z
    .locals 5
    .param p1, "v"    # Landroid/view/View;

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 121
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/HeaderFooterListAdapter;->mHeaderViewInfos:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    move-result v4

    if-ge v0, v4, :cond_2

    .line 123
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/HeaderFooterListAdapter;->mHeaderViewInfos:Ljava/util/ArrayList;

    invoke-virtual {v4, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/retailsearch/android/ui/HorizontalListView$FixedViewInfo;

    .line 124
    .local v1, "info":Lcom/amazon/retailsearch/android/ui/HorizontalListView$FixedViewInfo;
    iget-object v4, v1, Lcom/amazon/retailsearch/android/ui/HorizontalListView$FixedViewInfo;->view:Landroid/view/View;

    if-ne v4, p1, :cond_1

    .line 126
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/HeaderFooterListAdapter;->mHeaderViewInfos:Ljava/util/ArrayList;

    invoke-virtual {v4, v0}, Ljava/util/ArrayList;->remove(I)Ljava/lang/Object;

    .line 128
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/HeaderFooterListAdapter;->mHeaderViewInfos:Ljava/util/ArrayList;

    invoke-direct {p0, v4}, Lcom/amazon/retailsearch/android/ui/HeaderFooterListAdapter;->areAllListInfosSelectable(Ljava/util/ArrayList;)Z

    move-result v4

    if-eqz v4, :cond_0

    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/HeaderFooterListAdapter;->mFooterViewInfos:Ljava/util/ArrayList;

    invoke-direct {p0, v4}, Lcom/amazon/retailsearch/android/ui/HeaderFooterListAdapter;->areAllListInfosSelectable(Ljava/util/ArrayList;)Z

    move-result v4

    if-eqz v4, :cond_0

    move v2, v3

    :cond_0
    iput-boolean v2, p0, Lcom/amazon/retailsearch/android/ui/HeaderFooterListAdapter;->mAreAllFixedViewsSelectable:Z

    .line 135
    .end local v1    # "info":Lcom/amazon/retailsearch/android/ui/HorizontalListView$FixedViewInfo;
    :goto_1
    return v3

    .line 121
    .restart local v1    # "info":Lcom/amazon/retailsearch/android/ui/HorizontalListView$FixedViewInfo;
    :cond_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .end local v1    # "info":Lcom/amazon/retailsearch/android/ui/HorizontalListView$FixedViewInfo;
    :cond_2
    move v3, v2

    .line 135
    goto :goto_1
.end method

.method public unregisterDataSetObserver(Landroid/database/DataSetObserver;)V
    .locals 1
    .param p1, "observer"    # Landroid/database/DataSetObserver;

    .prologue
    .line 321
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/HeaderFooterListAdapter;->mAdapter:Landroid/widget/ListAdapter;

    if-eqz v0, :cond_0

    .line 323
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/HeaderFooterListAdapter;->mAdapter:Landroid/widget/ListAdapter;

    invoke-interface {v0, p1}, Landroid/widget/ListAdapter;->unregisterDataSetObserver(Landroid/database/DataSetObserver;)V

    .line 325
    :cond_0
    return-void
.end method
