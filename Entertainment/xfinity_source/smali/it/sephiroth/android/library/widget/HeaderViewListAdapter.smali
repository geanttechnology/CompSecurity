.class public Lit/sephiroth/android/library/widget/HeaderViewListAdapter;
.super Ljava/lang/Object;
.source "HeaderViewListAdapter.java"

# interfaces
.implements Landroid/widget/Filterable;
.implements Landroid/widget/WrapperListAdapter;


# static fields
.field static final EMPTY_INFO_LIST:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lit/sephiroth/android/library/widget/HListView$FixedViewInfo;",
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
            "Lit/sephiroth/android/library/widget/HListView$FixedViewInfo;",
            ">;"
        }
    .end annotation
.end field

.field mHeaderViewInfos:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lit/sephiroth/android/library/widget/HListView$FixedViewInfo;",
            ">;"
        }
    .end annotation
.end field

.field private final mIsFilterable:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 48
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    sput-object v0, Lit/sephiroth/android/library/widget/HeaderViewListAdapter;->EMPTY_INFO_LIST:Ljava/util/ArrayList;

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
            "Lit/sephiroth/android/library/widget/HListView$FixedViewInfo;",
            ">;",
            "Ljava/util/ArrayList",
            "<",
            "Lit/sephiroth/android/library/widget/HListView$FixedViewInfo;",
            ">;",
            "Landroid/widget/ListAdapter;",
            ")V"
        }
    .end annotation

    .prologue
    .line 57
    .local p1, "headerViewInfos":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lit/sephiroth/android/library/widget/HListView$FixedViewInfo;>;"
    .local p2, "footerViewInfos":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lit/sephiroth/android/library/widget/HListView$FixedViewInfo;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 58
    iput-object p3, p0, Lit/sephiroth/android/library/widget/HeaderViewListAdapter;->mAdapter:Landroid/widget/ListAdapter;

    .line 59
    instance-of v0, p3, Landroid/widget/Filterable;

    iput-boolean v0, p0, Lit/sephiroth/android/library/widget/HeaderViewListAdapter;->mIsFilterable:Z

    .line 61
    if-nez p1, :cond_0

    .line 62
    sget-object v0, Lit/sephiroth/android/library/widget/HeaderViewListAdapter;->EMPTY_INFO_LIST:Ljava/util/ArrayList;

    iput-object v0, p0, Lit/sephiroth/android/library/widget/HeaderViewListAdapter;->mHeaderViewInfos:Ljava/util/ArrayList;

    .line 67
    :goto_0
    if-nez p2, :cond_1

    .line 68
    sget-object v0, Lit/sephiroth/android/library/widget/HeaderViewListAdapter;->EMPTY_INFO_LIST:Ljava/util/ArrayList;

    iput-object v0, p0, Lit/sephiroth/android/library/widget/HeaderViewListAdapter;->mFooterViewInfos:Ljava/util/ArrayList;

    .line 73
    :goto_1
    iget-object v0, p0, Lit/sephiroth/android/library/widget/HeaderViewListAdapter;->mHeaderViewInfos:Ljava/util/ArrayList;

    invoke-direct {p0, v0}, Lit/sephiroth/android/library/widget/HeaderViewListAdapter;->areAllListInfosSelectable(Ljava/util/ArrayList;)Z

    move-result v0

    if-eqz v0, :cond_2

    iget-object v0, p0, Lit/sephiroth/android/library/widget/HeaderViewListAdapter;->mFooterViewInfos:Ljava/util/ArrayList;

    invoke-direct {p0, v0}, Lit/sephiroth/android/library/widget/HeaderViewListAdapter;->areAllListInfosSelectable(Ljava/util/ArrayList;)Z

    move-result v0

    if-eqz v0, :cond_2

    const/4 v0, 0x1

    :goto_2
    iput-boolean v0, p0, Lit/sephiroth/android/library/widget/HeaderViewListAdapter;->mAreAllFixedViewsSelectable:Z

    .line 76
    return-void

    .line 64
    :cond_0
    iput-object p1, p0, Lit/sephiroth/android/library/widget/HeaderViewListAdapter;->mHeaderViewInfos:Ljava/util/ArrayList;

    goto :goto_0

    .line 70
    :cond_1
    iput-object p2, p0, Lit/sephiroth/android/library/widget/HeaderViewListAdapter;->mFooterViewInfos:Ljava/util/ArrayList;

    goto :goto_1

    .line 73
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
            "Lit/sephiroth/android/library/widget/HListView$FixedViewInfo;",
            ">;)Z"
        }
    .end annotation

    .prologue
    .line 91
    .local p1, "infos":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lit/sephiroth/android/library/widget/HListView$FixedViewInfo;>;"
    if-eqz p1, :cond_1

    .line 92
    invoke-virtual {p1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lit/sephiroth/android/library/widget/HListView$FixedViewInfo;

    .line 93
    .local v1, "info":Lit/sephiroth/android/library/widget/HListView$FixedViewInfo;
    iget-boolean v2, v1, Lit/sephiroth/android/library/widget/HListView$FixedViewInfo;->isSelectable:Z

    if-nez v2, :cond_0

    .line 94
    const/4 v2, 0x0

    .line 98
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v1    # "info":Lit/sephiroth/android/library/widget/HListView$FixedViewInfo;
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

    .line 144
    iget-object v1, p0, Lit/sephiroth/android/library/widget/HeaderViewListAdapter;->mAdapter:Landroid/widget/ListAdapter;

    if-eqz v1, :cond_0

    .line 145
    iget-boolean v1, p0, Lit/sephiroth/android/library/widget/HeaderViewListAdapter;->mAreAllFixedViewsSelectable:Z

    if-eqz v1, :cond_1

    iget-object v1, p0, Lit/sephiroth/android/library/widget/HeaderViewListAdapter;->mAdapter:Landroid/widget/ListAdapter;

    invoke-interface {v1}, Landroid/widget/ListAdapter;->areAllItemsEnabled()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 147
    :cond_0
    :goto_0
    return v0

    .line 145
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getCount()I
    .locals 2

    .prologue
    .line 136
    iget-object v0, p0, Lit/sephiroth/android/library/widget/HeaderViewListAdapter;->mAdapter:Landroid/widget/ListAdapter;

    if-eqz v0, :cond_0

    .line 137
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HeaderViewListAdapter;->getFootersCount()I

    move-result v0

    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HeaderViewListAdapter;->getHeadersCount()I

    move-result v1

    add-int/2addr v0, v1

    iget-object v1, p0, Lit/sephiroth/android/library/widget/HeaderViewListAdapter;->mAdapter:Landroid/widget/ListAdapter;

    invoke-interface {v1}, Landroid/widget/ListAdapter;->getCount()I

    move-result v1

    add-int/2addr v0, v1

    .line 139
    :goto_0
    return v0

    :cond_0
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HeaderViewListAdapter;->getFootersCount()I

    move-result v0

    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HeaderViewListAdapter;->getHeadersCount()I

    move-result v1

    add-int/2addr v0, v1

    goto :goto_0
.end method

.method public getFilter()Landroid/widget/Filter;
    .locals 1

    .prologue
    .line 266
    iget-boolean v0, p0, Lit/sephiroth/android/library/widget/HeaderViewListAdapter;->mIsFilterable:Z

    if-eqz v0, :cond_0

    .line 267
    iget-object v0, p0, Lit/sephiroth/android/library/widget/HeaderViewListAdapter;->mAdapter:Landroid/widget/ListAdapter;

    check-cast v0, Landroid/widget/Filterable;

    invoke-interface {v0}, Landroid/widget/Filterable;->getFilter()Landroid/widget/Filter;

    move-result-object v0

    .line 269
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getFootersCount()I
    .locals 1

    .prologue
    .line 83
    iget-object v0, p0, Lit/sephiroth/android/library/widget/HeaderViewListAdapter;->mFooterViewInfos:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    return v0
.end method

.method public getHeadersCount()I
    .locals 1

    .prologue
    .line 79
    iget-object v0, p0, Lit/sephiroth/android/library/widget/HeaderViewListAdapter;->mHeaderViewInfos:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    return v0
.end method

.method public getItem(I)Ljava/lang/Object;
    .locals 5
    .param p1, "position"    # I

    .prologue
    .line 174
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HeaderViewListAdapter;->getHeadersCount()I

    move-result v2

    .line 175
    .local v2, "numHeaders":I
    if-ge p1, v2, :cond_0

    .line 176
    iget-object v3, p0, Lit/sephiroth/android/library/widget/HeaderViewListAdapter;->mHeaderViewInfos:Ljava/util/ArrayList;

    invoke-virtual {v3, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lit/sephiroth/android/library/widget/HListView$FixedViewInfo;

    iget-object v3, v3, Lit/sephiroth/android/library/widget/HListView$FixedViewInfo;->data:Ljava/lang/Object;

    .line 190
    :goto_0
    return-object v3

    .line 180
    :cond_0
    sub-int v1, p1, v2

    .line 181
    .local v1, "adjPosition":I
    const/4 v0, 0x0

    .line 182
    .local v0, "adapterCount":I
    iget-object v3, p0, Lit/sephiroth/android/library/widget/HeaderViewListAdapter;->mAdapter:Landroid/widget/ListAdapter;

    if-eqz v3, :cond_1

    .line 183
    iget-object v3, p0, Lit/sephiroth/android/library/widget/HeaderViewListAdapter;->mAdapter:Landroid/widget/ListAdapter;

    invoke-interface {v3}, Landroid/widget/ListAdapter;->getCount()I

    move-result v0

    .line 184
    if-ge v1, v0, :cond_1

    .line 185
    iget-object v3, p0, Lit/sephiroth/android/library/widget/HeaderViewListAdapter;->mAdapter:Landroid/widget/ListAdapter;

    invoke-interface {v3, v1}, Landroid/widget/ListAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v3

    goto :goto_0

    .line 190
    :cond_1
    iget-object v3, p0, Lit/sephiroth/android/library/widget/HeaderViewListAdapter;->mFooterViewInfos:Ljava/util/ArrayList;

    sub-int v4, v1, v0

    invoke-virtual {v3, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lit/sephiroth/android/library/widget/HListView$FixedViewInfo;

    iget-object v3, v3, Lit/sephiroth/android/library/widget/HListView$FixedViewInfo;->data:Ljava/lang/Object;

    goto :goto_0
.end method

.method public getItemId(I)J
    .locals 6
    .param p1, "position"    # I

    .prologue
    .line 194
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HeaderViewListAdapter;->getHeadersCount()I

    move-result v2

    .line 195
    .local v2, "numHeaders":I
    iget-object v3, p0, Lit/sephiroth/android/library/widget/HeaderViewListAdapter;->mAdapter:Landroid/widget/ListAdapter;

    if-eqz v3, :cond_0

    if-lt p1, v2, :cond_0

    .line 196
    sub-int v1, p1, v2

    .line 197
    .local v1, "adjPosition":I
    iget-object v3, p0, Lit/sephiroth/android/library/widget/HeaderViewListAdapter;->mAdapter:Landroid/widget/ListAdapter;

    invoke-interface {v3}, Landroid/widget/ListAdapter;->getCount()I

    move-result v0

    .line 198
    .local v0, "adapterCount":I
    if-ge v1, v0, :cond_0

    .line 199
    iget-object v3, p0, Lit/sephiroth/android/library/widget/HeaderViewListAdapter;->mAdapter:Landroid/widget/ListAdapter;

    invoke-interface {v3, v1}, Landroid/widget/ListAdapter;->getItemId(I)J

    move-result-wide v4

    .line 202
    .end local v0    # "adapterCount":I
    .end local v1    # "adjPosition":I
    :goto_0
    return-wide v4

    :cond_0
    const-wide/16 v4, -0x1

    goto :goto_0
.end method

.method public getItemViewType(I)I
    .locals 4
    .param p1, "position"    # I

    .prologue
    .line 234
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HeaderViewListAdapter;->getHeadersCount()I

    move-result v2

    .line 235
    .local v2, "numHeaders":I
    iget-object v3, p0, Lit/sephiroth/android/library/widget/HeaderViewListAdapter;->mAdapter:Landroid/widget/ListAdapter;

    if-eqz v3, :cond_0

    if-lt p1, v2, :cond_0

    .line 236
    sub-int v1, p1, v2

    .line 237
    .local v1, "adjPosition":I
    iget-object v3, p0, Lit/sephiroth/android/library/widget/HeaderViewListAdapter;->mAdapter:Landroid/widget/ListAdapter;

    invoke-interface {v3}, Landroid/widget/ListAdapter;->getCount()I

    move-result v0

    .line 238
    .local v0, "adapterCount":I
    if-ge v1, v0, :cond_0

    .line 239
    iget-object v3, p0, Lit/sephiroth/android/library/widget/HeaderViewListAdapter;->mAdapter:Landroid/widget/ListAdapter;

    invoke-interface {v3, v1}, Landroid/widget/ListAdapter;->getItemViewType(I)I

    move-result v3

    .line 243
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
    .line 214
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HeaderViewListAdapter;->getHeadersCount()I

    move-result v2

    .line 215
    .local v2, "numHeaders":I
    if-ge p1, v2, :cond_0

    .line 216
    iget-object v3, p0, Lit/sephiroth/android/library/widget/HeaderViewListAdapter;->mHeaderViewInfos:Ljava/util/ArrayList;

    invoke-virtual {v3, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lit/sephiroth/android/library/widget/HListView$FixedViewInfo;

    iget-object v3, v3, Lit/sephiroth/android/library/widget/HListView$FixedViewInfo;->view:Landroid/view/View;

    .line 230
    :goto_0
    return-object v3

    .line 220
    :cond_0
    sub-int v1, p1, v2

    .line 221
    .local v1, "adjPosition":I
    const/4 v0, 0x0

    .line 222
    .local v0, "adapterCount":I
    iget-object v3, p0, Lit/sephiroth/android/library/widget/HeaderViewListAdapter;->mAdapter:Landroid/widget/ListAdapter;

    if-eqz v3, :cond_1

    .line 223
    iget-object v3, p0, Lit/sephiroth/android/library/widget/HeaderViewListAdapter;->mAdapter:Landroid/widget/ListAdapter;

    invoke-interface {v3}, Landroid/widget/ListAdapter;->getCount()I

    move-result v0

    .line 224
    if-ge v1, v0, :cond_1

    .line 225
    iget-object v3, p0, Lit/sephiroth/android/library/widget/HeaderViewListAdapter;->mAdapter:Landroid/widget/ListAdapter;

    invoke-interface {v3, v1, p2, p3}, Landroid/widget/ListAdapter;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v3

    goto :goto_0

    .line 230
    :cond_1
    iget-object v3, p0, Lit/sephiroth/android/library/widget/HeaderViewListAdapter;->mFooterViewInfos:Ljava/util/ArrayList;

    sub-int v4, v1, v0

    invoke-virtual {v3, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lit/sephiroth/android/library/widget/HListView$FixedViewInfo;

    iget-object v3, v3, Lit/sephiroth/android/library/widget/HListView$FixedViewInfo;->view:Landroid/view/View;

    goto :goto_0
.end method

.method public getViewTypeCount()I
    .locals 1

    .prologue
    .line 247
    iget-object v0, p0, Lit/sephiroth/android/library/widget/HeaderViewListAdapter;->mAdapter:Landroid/widget/ListAdapter;

    if-eqz v0, :cond_0

    .line 248
    iget-object v0, p0, Lit/sephiroth/android/library/widget/HeaderViewListAdapter;->mAdapter:Landroid/widget/ListAdapter;

    invoke-interface {v0}, Landroid/widget/ListAdapter;->getViewTypeCount()I

    move-result v0

    .line 250
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public getWrappedAdapter()Landroid/widget/ListAdapter;
    .locals 1

    .prologue
    .line 273
    iget-object v0, p0, Lit/sephiroth/android/library/widget/HeaderViewListAdapter;->mAdapter:Landroid/widget/ListAdapter;

    return-object v0
.end method

.method public hasStableIds()Z
    .locals 1

    .prologue
    .line 206
    iget-object v0, p0, Lit/sephiroth/android/library/widget/HeaderViewListAdapter;->mAdapter:Landroid/widget/ListAdapter;

    if-eqz v0, :cond_0

    .line 207
    iget-object v0, p0, Lit/sephiroth/android/library/widget/HeaderViewListAdapter;->mAdapter:Landroid/widget/ListAdapter;

    invoke-interface {v0}, Landroid/widget/ListAdapter;->hasStableIds()Z

    move-result v0

    .line 209
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isEmpty()Z
    .locals 1

    .prologue
    .line 87
    iget-object v0, p0, Lit/sephiroth/android/library/widget/HeaderViewListAdapter;->mAdapter:Landroid/widget/ListAdapter;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lit/sephiroth/android/library/widget/HeaderViewListAdapter;->mAdapter:Landroid/widget/ListAdapter;

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
    .line 153
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/HeaderViewListAdapter;->getHeadersCount()I

    move-result v2

    .line 154
    .local v2, "numHeaders":I
    if-ge p1, v2, :cond_0

    .line 155
    iget-object v3, p0, Lit/sephiroth/android/library/widget/HeaderViewListAdapter;->mHeaderViewInfos:Ljava/util/ArrayList;

    invoke-virtual {v3, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lit/sephiroth/android/library/widget/HListView$FixedViewInfo;

    iget-boolean v3, v3, Lit/sephiroth/android/library/widget/HListView$FixedViewInfo;->isSelectable:Z

    .line 169
    :goto_0
    return v3

    .line 159
    :cond_0
    sub-int v1, p1, v2

    .line 160
    .local v1, "adjPosition":I
    const/4 v0, 0x0

    .line 161
    .local v0, "adapterCount":I
    iget-object v3, p0, Lit/sephiroth/android/library/widget/HeaderViewListAdapter;->mAdapter:Landroid/widget/ListAdapter;

    if-eqz v3, :cond_1

    .line 162
    iget-object v3, p0, Lit/sephiroth/android/library/widget/HeaderViewListAdapter;->mAdapter:Landroid/widget/ListAdapter;

    invoke-interface {v3}, Landroid/widget/ListAdapter;->getCount()I

    move-result v0

    .line 163
    if-ge v1, v0, :cond_1

    .line 164
    iget-object v3, p0, Lit/sephiroth/android/library/widget/HeaderViewListAdapter;->mAdapter:Landroid/widget/ListAdapter;

    invoke-interface {v3, v1}, Landroid/widget/ListAdapter;->isEnabled(I)Z

    move-result v3

    goto :goto_0

    .line 169
    :cond_1
    iget-object v3, p0, Lit/sephiroth/android/library/widget/HeaderViewListAdapter;->mFooterViewInfos:Ljava/util/ArrayList;

    sub-int v4, v1, v0

    invoke-virtual {v3, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lit/sephiroth/android/library/widget/HListView$FixedViewInfo;

    iget-boolean v3, v3, Lit/sephiroth/android/library/widget/HListView$FixedViewInfo;->isSelectable:Z

    goto :goto_0
.end method

.method public registerDataSetObserver(Landroid/database/DataSetObserver;)V
    .locals 1
    .param p1, "observer"    # Landroid/database/DataSetObserver;

    .prologue
    .line 254
    iget-object v0, p0, Lit/sephiroth/android/library/widget/HeaderViewListAdapter;->mAdapter:Landroid/widget/ListAdapter;

    if-eqz v0, :cond_0

    .line 255
    iget-object v0, p0, Lit/sephiroth/android/library/widget/HeaderViewListAdapter;->mAdapter:Landroid/widget/ListAdapter;

    invoke-interface {v0, p1}, Landroid/widget/ListAdapter;->registerDataSetObserver(Landroid/database/DataSetObserver;)V

    .line 257
    :cond_0
    return-void
.end method

.method public unregisterDataSetObserver(Landroid/database/DataSetObserver;)V
    .locals 1
    .param p1, "observer"    # Landroid/database/DataSetObserver;

    .prologue
    .line 260
    iget-object v0, p0, Lit/sephiroth/android/library/widget/HeaderViewListAdapter;->mAdapter:Landroid/widget/ListAdapter;

    if-eqz v0, :cond_0

    .line 261
    iget-object v0, p0, Lit/sephiroth/android/library/widget/HeaderViewListAdapter;->mAdapter:Landroid/widget/ListAdapter;

    invoke-interface {v0, p1}, Landroid/widget/ListAdapter;->unregisterDataSetObserver(Landroid/database/DataSetObserver;)V

    .line 263
    :cond_0
    return-void
.end method
