.class public Lco/vine/android/widget/SectionAdapter;
.super Landroid/widget/BaseAdapter;
.source "SectionAdapter.java"

# interfaces
.implements Lco/vine/android/widget/PinnedHeaderAdapter;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/widget/SectionAdapter$AdapterDataSetObserver;
    }
.end annotation


# static fields
.field public static final TYPE_CARDROW:I = 0x0

.field public static final TYPE_NORMAL:I = 0x1

.field private static final VIEW_TYPE_SECTION:I


# instance fields
.field private final mAdapters:[Landroid/widget/BaseAdapter;

.field private final mCardHeaders:[Z

.field private final mDataSetObserver:Lco/vine/android/widget/SectionAdapter$AdapterDataSetObserver;

.field private final mDefaultType:I

.field mNotifyOnChange:Z

.field private mPinnedHeaderAdapter:Lco/vine/android/widget/PinnedHeaderAdapter;

.field private final mSectionLayout:I

.field private final mStringResIds:[I

.field private final mTypes:[I


# direct methods
.method public constructor <init>([I[I[Landroid/widget/BaseAdapter;)V
    .locals 7
    .param p1, "types"    # [I
    .param p2, "stringIds"    # [I
    .param p3, "adapters"    # [Landroid/widget/BaseAdapter;

    .prologue
    .line 42
    const/4 v1, 0x0

    const v5, 0x7f03008e

    const/4 v6, 0x0

    move-object v0, p0

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    invoke-direct/range {v0 .. v6}, Lco/vine/android/widget/SectionAdapter;-><init>([Z[I[I[Landroid/widget/BaseAdapter;II)V

    .line 43
    return-void
.end method

.method public constructor <init>([Landroid/widget/BaseAdapter;)V
    .locals 7
    .param p1, "adapters"    # [Landroid/widget/BaseAdapter;

    .prologue
    const/4 v1, 0x0

    .line 34
    const v5, 0x7f03008e

    const/4 v6, 0x0

    move-object v0, p0

    move-object v2, v1

    move-object v3, v1

    move-object v4, p1

    invoke-direct/range {v0 .. v6}, Lco/vine/android/widget/SectionAdapter;-><init>([Z[I[I[Landroid/widget/BaseAdapter;II)V

    .line 35
    return-void
.end method

.method public constructor <init>([Landroid/widget/BaseAdapter;I)V
    .locals 7
    .param p1, "adapters"    # [Landroid/widget/BaseAdapter;
    .param p2, "defaultType"    # I

    .prologue
    const/4 v1, 0x0

    .line 38
    const v5, 0x7f03008e

    move-object v0, p0

    move-object v2, v1

    move-object v3, v1

    move-object v4, p1

    move v6, p2

    invoke-direct/range {v0 .. v6}, Lco/vine/android/widget/SectionAdapter;-><init>([Z[I[I[Landroid/widget/BaseAdapter;II)V

    .line 39
    return-void
.end method

.method public constructor <init>([Z[I[I[Landroid/widget/BaseAdapter;II)V
    .locals 5
    .param p1, "headers"    # [Z
    .param p2, "types"    # [I
    .param p3, "stringIds"    # [I
    .param p4, "adapters"    # [Landroid/widget/BaseAdapter;
    .param p5, "sectionLayout"    # I
    .param p6, "defaultType"    # I

    .prologue
    .line 46
    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    .line 31
    const/4 v4, 0x1

    iput-boolean v4, p0, Lco/vine/android/widget/SectionAdapter;->mNotifyOnChange:Z

    .line 47
    iput-object p1, p0, Lco/vine/android/widget/SectionAdapter;->mCardHeaders:[Z

    .line 48
    iput-object p3, p0, Lco/vine/android/widget/SectionAdapter;->mStringResIds:[I

    .line 49
    iput-object p4, p0, Lco/vine/android/widget/SectionAdapter;->mAdapters:[Landroid/widget/BaseAdapter;

    .line 50
    iput p5, p0, Lco/vine/android/widget/SectionAdapter;->mSectionLayout:I

    .line 51
    iput-object p2, p0, Lco/vine/android/widget/SectionAdapter;->mTypes:[I

    .line 52
    iput p6, p0, Lco/vine/android/widget/SectionAdapter;->mDefaultType:I

    .line 54
    new-instance v4, Lco/vine/android/widget/SectionAdapter$AdapterDataSetObserver;

    invoke-direct {v4, p0}, Lco/vine/android/widget/SectionAdapter$AdapterDataSetObserver;-><init>(Lco/vine/android/widget/SectionAdapter;)V

    iput-object v4, p0, Lco/vine/android/widget/SectionAdapter;->mDataSetObserver:Lco/vine/android/widget/SectionAdapter$AdapterDataSetObserver;

    .line 55
    move-object v1, p4

    .local v1, "arr$":[Landroid/widget/BaseAdapter;
    array-length v3, v1

    .local v3, "len$":I
    const/4 v2, 0x0

    .local v2, "i$":I
    :goto_0
    if-ge v2, v3, :cond_1

    aget-object v0, v1, v2

    .line 56
    .local v0, "adapter":Landroid/widget/BaseAdapter;
    iget-object v4, p0, Lco/vine/android/widget/SectionAdapter;->mDataSetObserver:Lco/vine/android/widget/SectionAdapter$AdapterDataSetObserver;

    invoke-virtual {v0, v4}, Landroid/widget/BaseAdapter;->registerDataSetObserver(Landroid/database/DataSetObserver;)V

    .line 57
    instance-of v4, v0, Lco/vine/android/widget/PinnedHeaderAdapter;

    if-eqz v4, :cond_0

    .line 58
    check-cast v0, Lco/vine/android/widget/PinnedHeaderAdapter;

    .end local v0    # "adapter":Landroid/widget/BaseAdapter;
    iput-object v0, p0, Lco/vine/android/widget/SectionAdapter;->mPinnedHeaderAdapter:Lco/vine/android/widget/PinnedHeaderAdapter;

    .line 55
    :cond_0
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 61
    :cond_1
    return-void
.end method

.method private getAdapterCount(Landroid/widget/BaseAdapter;)I
    .locals 2
    .param p1, "adapter"    # Landroid/widget/BaseAdapter;

    .prologue
    .line 79
    :try_start_0
    invoke-virtual {p1}, Landroid/widget/BaseAdapter;->getCount()I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result v1

    .line 82
    :goto_0
    return v1

    .line 80
    :catch_0
    move-exception v0

    .line 81
    .local v0, "e":Ljava/lang/Exception;
    invoke-static {v0}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;)V

    .line 82
    const/4 v1, 0x0

    goto :goto_0
.end method

.method private hasDivider(I)Z
    .locals 1
    .param p1, "index"    # I

    .prologue
    .line 74
    iget-object v0, p0, Lco/vine/android/widget/SectionAdapter;->mStringResIds:[I

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/widget/SectionAdapter;->mStringResIds:[I

    aget v0, v0, p1

    if-lez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public areAllItemsEnabled()Z
    .locals 4

    .prologue
    .line 227
    const/4 v2, 0x0

    .line 228
    .local v2, "showDividers":Z
    iget-object v3, p0, Lco/vine/android/widget/SectionAdapter;->mAdapters:[Landroid/widget/BaseAdapter;

    array-length v1, v3

    .line 229
    .local v1, "len":I
    const/4 v0, 0x0

    .local v0, "index":I
    :goto_0
    if-ge v0, v1, :cond_0

    .line 230
    invoke-direct {p0, v0}, Lco/vine/android/widget/SectionAdapter;->hasDivider(I)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 231
    const/4 v2, 0x1

    .line 235
    :cond_0
    if-nez v2, :cond_2

    invoke-super {p0}, Landroid/widget/BaseAdapter;->areAllItemsEnabled()Z

    move-result v3

    if-eqz v3, :cond_2

    const/4 v3, 0x1

    :goto_1
    return v3

    .line 229
    :cond_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 235
    :cond_2
    const/4 v3, 0x0

    goto :goto_1
.end method

.method public getAdapterIndex(I)I
    .locals 7
    .param p1, "pos"    # I

    .prologue
    .line 310
    const/4 v4, 0x0

    .line 311
    .local v4, "index":I
    const/4 v2, 0x0

    .line 312
    .local v2, "count":I
    iget-object v1, p0, Lco/vine/android/widget/SectionAdapter;->mAdapters:[Landroid/widget/BaseAdapter;

    .local v1, "arr$":[Landroid/widget/BaseAdapter;
    array-length v5, v1

    .local v5, "len$":I
    const/4 v3, 0x0

    .local v3, "i$":I
    :goto_0
    if-ge v3, v5, :cond_1

    aget-object v0, v1, v3

    .line 313
    .local v0, "adapter":Landroid/widget/BaseAdapter;
    invoke-direct {p0, v0}, Lco/vine/android/widget/SectionAdapter;->getAdapterCount(Landroid/widget/BaseAdapter;)I

    move-result v2

    .line 314
    invoke-direct {p0, v4}, Lco/vine/android/widget/SectionAdapter;->hasDivider(I)Z

    move-result v6

    if-eqz v6, :cond_0

    .line 315
    add-int/lit8 v2, v2, 0x1

    .line 317
    :cond_0
    if-ge p1, v2, :cond_2

    .line 322
    .end local v0    # "adapter":Landroid/widget/BaseAdapter;
    :cond_1
    return v4

    .line 320
    .restart local v0    # "adapter":Landroid/widget/BaseAdapter;
    :cond_2
    add-int/lit8 v4, v4, 0x1

    .line 312
    add-int/lit8 v3, v3, 0x1

    goto :goto_0
.end method

.method protected getAdapterView(Landroid/widget/BaseAdapter;IIILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 2
    .param p1, "adapter"    # Landroid/widget/BaseAdapter;
    .param p2, "visibleIndex"    # I
    .param p3, "adapterIndex"    # I
    .param p4, "pos"    # I
    .param p5, "convertView"    # Landroid/view/View;
    .param p6, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 206
    iget-object v1, p0, Lco/vine/android/widget/SectionAdapter;->mTypes:[I

    if-eqz v1, :cond_0

    .line 207
    iget-object v1, p0, Lco/vine/android/widget/SectionAdapter;->mTypes:[I

    aget v0, v1, p3

    .line 221
    .local v0, "type":I
    :goto_0
    invoke-virtual {p1, p4, p5, p6}, Landroid/widget/BaseAdapter;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v1

    return-object v1

    .line 209
    .end local v0    # "type":I
    :cond_0
    iget v0, p0, Lco/vine/android/widget/SectionAdapter;->mDefaultType:I

    .restart local v0    # "type":I
    goto :goto_0
.end method

.method public getCount()I
    .locals 8

    .prologue
    .line 87
    const/4 v6, 0x0

    .line 88
    .local v6, "total":I
    const/4 v4, 0x0

    .line 90
    .local v4, "index":I
    iget-object v1, p0, Lco/vine/android/widget/SectionAdapter;->mAdapters:[Landroid/widget/BaseAdapter;

    .local v1, "arr$":[Landroid/widget/BaseAdapter;
    array-length v5, v1

    .local v5, "len$":I
    const/4 v3, 0x0

    .local v3, "i$":I
    :goto_0
    if-ge v3, v5, :cond_1

    aget-object v0, v1, v3

    .line 91
    .local v0, "adapter":Landroid/widget/BaseAdapter;
    invoke-direct {p0, v0}, Lco/vine/android/widget/SectionAdapter;->getAdapterCount(Landroid/widget/BaseAdapter;)I

    move-result v2

    .line 92
    .local v2, "count":I
    if-lez v2, :cond_0

    .line 93
    add-int/2addr v6, v2

    .line 94
    invoke-direct {p0, v4}, Lco/vine/android/widget/SectionAdapter;->hasDivider(I)Z

    move-result v7

    if-eqz v7, :cond_0

    .line 95
    add-int/lit8 v6, v6, 0x1

    .line 98
    :cond_0
    add-int/lit8 v4, v4, 0x1

    .line 90
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 100
    .end local v0    # "adapter":Landroid/widget/BaseAdapter;
    .end local v2    # "count":I
    :cond_1
    return v6
.end method

.method public getDataSetObserver()Lco/vine/android/widget/SectionAdapter$AdapterDataSetObserver;
    .locals 1

    .prologue
    .line 64
    iget-object v0, p0, Lco/vine/android/widget/SectionAdapter;->mDataSetObserver:Lco/vine/android/widget/SectionAdapter$AdapterDataSetObserver;

    return-object v0
.end method

.method public getItem(I)Ljava/lang/Object;
    .locals 8
    .param p1, "pos"    # I

    .prologue
    const/4 v6, 0x0

    .line 112
    const/4 v4, 0x0

    .line 113
    .local v4, "index":I
    iget-object v1, p0, Lco/vine/android/widget/SectionAdapter;->mAdapters:[Landroid/widget/BaseAdapter;

    .local v1, "arr$":[Landroid/widget/BaseAdapter;
    array-length v5, v1

    .local v5, "len$":I
    const/4 v3, 0x0

    .local v3, "i$":I
    :goto_0
    if-ge v3, v5, :cond_0

    aget-object v0, v1, v3

    .line 114
    .local v0, "adapter":Landroid/widget/BaseAdapter;
    invoke-direct {p0, v0}, Lco/vine/android/widget/SectionAdapter;->getAdapterCount(Landroid/widget/BaseAdapter;)I

    move-result v2

    .line 115
    .local v2, "count":I
    if-lez v2, :cond_4

    .line 116
    invoke-direct {p0, v4}, Lco/vine/android/widget/SectionAdapter;->hasDivider(I)Z

    move-result v7

    if-eqz v7, :cond_2

    .line 117
    add-int/lit8 v2, v2, 0x1

    .line 118
    if-nez p1, :cond_1

    .line 132
    .end local v0    # "adapter":Landroid/widget/BaseAdapter;
    .end local v2    # "count":I
    :cond_0
    :goto_1
    return-object v6

    .line 120
    .restart local v0    # "adapter":Landroid/widget/BaseAdapter;
    .restart local v2    # "count":I
    :cond_1
    if-ge p1, v2, :cond_3

    .line 121
    add-int/lit8 v6, p1, -0x1

    invoke-virtual {v0, v6}, Landroid/widget/BaseAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v6

    goto :goto_1

    .line 124
    :cond_2
    if-ge p1, v2, :cond_3

    .line 125
    invoke-virtual {v0, p1}, Landroid/widget/BaseAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v6

    goto :goto_1

    .line 128
    :cond_3
    sub-int/2addr p1, v2

    .line 130
    :cond_4
    add-int/lit8 v4, v4, 0x1

    .line 113
    add-int/lit8 v3, v3, 0x1

    goto :goto_0
.end method

.method public getItemId(I)J
    .locals 9
    .param p1, "pos"    # I

    .prologue
    const-wide/16 v6, 0x0

    .line 137
    const/4 v4, 0x0

    .line 138
    .local v4, "index":I
    iget-object v1, p0, Lco/vine/android/widget/SectionAdapter;->mAdapters:[Landroid/widget/BaseAdapter;

    .local v1, "arr$":[Landroid/widget/BaseAdapter;
    array-length v5, v1

    .local v5, "len$":I
    const/4 v3, 0x0

    .local v3, "i$":I
    :goto_0
    if-ge v3, v5, :cond_0

    aget-object v0, v1, v3

    .line 139
    .local v0, "adapter":Landroid/widget/BaseAdapter;
    invoke-direct {p0, v0}, Lco/vine/android/widget/SectionAdapter;->getAdapterCount(Landroid/widget/BaseAdapter;)I

    move-result v2

    .line 140
    .local v2, "count":I
    if-lez v2, :cond_4

    .line 141
    invoke-direct {p0, v4}, Lco/vine/android/widget/SectionAdapter;->hasDivider(I)Z

    move-result v8

    if-eqz v8, :cond_2

    .line 142
    add-int/lit8 v2, v2, 0x1

    .line 143
    if-nez p1, :cond_1

    .line 157
    .end local v0    # "adapter":Landroid/widget/BaseAdapter;
    .end local v2    # "count":I
    :cond_0
    :goto_1
    return-wide v6

    .line 145
    .restart local v0    # "adapter":Landroid/widget/BaseAdapter;
    .restart local v2    # "count":I
    :cond_1
    if-ge p1, v2, :cond_3

    .line 146
    add-int/lit8 v6, p1, -0x1

    invoke-virtual {v0, v6}, Landroid/widget/BaseAdapter;->getItemId(I)J

    move-result-wide v6

    goto :goto_1

    .line 149
    :cond_2
    if-ge p1, v2, :cond_3

    .line 150
    invoke-virtual {v0, p1}, Landroid/widget/BaseAdapter;->getItemId(I)J

    move-result-wide v6

    goto :goto_1

    .line 153
    :cond_3
    sub-int/2addr p1, v2

    .line 155
    :cond_4
    add-int/lit8 v4, v4, 0x1

    .line 138
    add-int/lit8 v3, v3, 0x1

    goto :goto_0
.end method

.method public getItemViewType(I)I
    .locals 8
    .param p1, "pos"    # I

    .prologue
    .line 268
    const/4 v6, 0x1

    .line 269
    .local v6, "typeCount":I
    const/4 v4, 0x0

    .line 270
    .local v4, "index":I
    iget-object v1, p0, Lco/vine/android/widget/SectionAdapter;->mAdapters:[Landroid/widget/BaseAdapter;

    .local v1, "arr$":[Landroid/widget/BaseAdapter;
    array-length v5, v1

    .local v5, "len$":I
    const/4 v3, 0x0

    .local v3, "i$":I
    :goto_0
    if-ge v3, v5, :cond_4

    aget-object v0, v1, v3

    .line 271
    .local v0, "adapter":Landroid/widget/BaseAdapter;
    invoke-direct {p0, v0}, Lco/vine/android/widget/SectionAdapter;->getAdapterCount(Landroid/widget/BaseAdapter;)I

    move-result v2

    .line 272
    .local v2, "count":I
    if-lez v2, :cond_3

    .line 273
    invoke-direct {p0, v4}, Lco/vine/android/widget/SectionAdapter;->hasDivider(I)Z

    move-result v7

    if-eqz v7, :cond_1

    .line 274
    add-int/lit8 v2, v2, 0x1

    .line 275
    if-nez p1, :cond_0

    .line 276
    const/4 v7, 0x0

    .line 290
    .end local v0    # "adapter":Landroid/widget/BaseAdapter;
    .end local v2    # "count":I
    :goto_1
    return v7

    .line 277
    .restart local v0    # "adapter":Landroid/widget/BaseAdapter;
    .restart local v2    # "count":I
    :cond_0
    if-ge p1, v2, :cond_2

    .line 278
    add-int/lit8 v7, p1, -0x1

    invoke-virtual {v0, v7}, Landroid/widget/BaseAdapter;->getItemViewType(I)I

    move-result v7

    add-int/2addr v7, v6

    goto :goto_1

    .line 281
    :cond_1
    if-ge p1, v2, :cond_2

    .line 282
    invoke-virtual {v0, p1}, Landroid/widget/BaseAdapter;->getItemViewType(I)I

    move-result v7

    add-int/2addr v7, v6

    goto :goto_1

    .line 285
    :cond_2
    sub-int/2addr p1, v2

    .line 287
    :cond_3
    invoke-virtual {v0}, Landroid/widget/BaseAdapter;->getViewTypeCount()I

    move-result v7

    add-int/2addr v6, v7

    .line 288
    add-int/lit8 v4, v4, 0x1

    .line 270
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 290
    .end local v0    # "adapter":Landroid/widget/BaseAdapter;
    .end local v2    # "count":I
    :cond_4
    invoke-super {p0, p1}, Landroid/widget/BaseAdapter;->getItemViewType(I)I

    move-result v7

    goto :goto_1
.end method

.method public getMyAdapterIndex(Landroid/widget/BaseAdapter;)I
    .locals 5
    .param p1, "adapter"    # Landroid/widget/BaseAdapter;

    .prologue
    .line 326
    const/4 v3, 0x0

    .line 327
    .local v3, "index":I
    iget-object v0, p0, Lco/vine/android/widget/SectionAdapter;->mAdapters:[Landroid/widget/BaseAdapter;

    .local v0, "arr$":[Landroid/widget/BaseAdapter;
    array-length v4, v0

    .local v4, "len$":I
    const/4 v2, 0x0

    .local v2, "i$":I
    :goto_0
    if-ge v2, v4, :cond_0

    aget-object v1, v0, v2

    .line 328
    .local v1, "ba":Landroid/widget/BaseAdapter;
    if-ne v1, p1, :cond_1

    .line 333
    .end local v1    # "ba":Landroid/widget/BaseAdapter;
    :cond_0
    return v3

    .line 331
    .restart local v1    # "ba":Landroid/widget/BaseAdapter;
    :cond_1
    add-int/lit8 v3, v3, 0x1

    .line 327
    add-int/lit8 v2, v2, 0x1

    goto :goto_0
.end method

.method public getNumberOfAdapters()I
    .locals 1

    .prologue
    .line 104
    iget-object v0, p0, Lco/vine/android/widget/SectionAdapter;->mAdapters:[Landroid/widget/BaseAdapter;

    if-eqz v0, :cond_0

    .line 105
    iget-object v0, p0, Lco/vine/android/widget/SectionAdapter;->mAdapters:[Landroid/widget/BaseAdapter;

    array-length v0, v0

    .line 107
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getPinnedHeaderHeight()I
    .locals 1

    .prologue
    .line 368
    iget-object v0, p0, Lco/vine/android/widget/SectionAdapter;->mPinnedHeaderAdapter:Lco/vine/android/widget/PinnedHeaderAdapter;

    if-eqz v0, :cond_0

    .line 369
    iget-object v0, p0, Lco/vine/android/widget/SectionAdapter;->mPinnedHeaderAdapter:Lco/vine/android/widget/PinnedHeaderAdapter;

    invoke-interface {v0}, Lco/vine/android/widget/PinnedHeaderAdapter;->getPinnedHeaderHeight()I

    move-result v0

    .line 371
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getPinnedHeaderStatus(I)Lco/vine/android/widget/PinnedHeaderAdapter$PinnedHeaderStatus;
    .locals 1
    .param p1, "navBottom"    # I

    .prologue
    .line 352
    iget-object v0, p0, Lco/vine/android/widget/SectionAdapter;->mPinnedHeaderAdapter:Lco/vine/android/widget/PinnedHeaderAdapter;

    if-eqz v0, :cond_0

    .line 353
    iget-object v0, p0, Lco/vine/android/widget/SectionAdapter;->mPinnedHeaderAdapter:Lco/vine/android/widget/PinnedHeaderAdapter;

    invoke-interface {v0, p1}, Lco/vine/android/widget/PinnedHeaderAdapter;->getPinnedHeaderStatus(I)Lco/vine/android/widget/PinnedHeaderAdapter$PinnedHeaderStatus;

    move-result-object v0

    .line 355
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getPinnedHeaderView(Landroid/view/View;)Landroid/view/View;
    .locals 1
    .param p1, "convertView"    # Landroid/view/View;

    .prologue
    .line 360
    iget-object v0, p0, Lco/vine/android/widget/SectionAdapter;->mPinnedHeaderAdapter:Lco/vine/android/widget/PinnedHeaderAdapter;

    if-eqz v0, :cond_0

    .line 361
    iget-object v0, p0, Lco/vine/android/widget/SectionAdapter;->mPinnedHeaderAdapter:Lco/vine/android/widget/PinnedHeaderAdapter;

    invoke-interface {v0, p1}, Lco/vine/android/widget/PinnedHeaderAdapter;->getPinnedHeaderView(Landroid/view/View;)Landroid/view/View;

    move-result-object v0

    .line 363
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getPositionOffset(I)I
    .locals 3
    .param p1, "index"    # I

    .prologue
    .line 337
    const/4 v1, 0x0

    .line 338
    .local v1, "offset":I
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    if-ge v0, p1, :cond_0

    .line 339
    iget-object v2, p0, Lco/vine/android/widget/SectionAdapter;->mAdapters:[Landroid/widget/BaseAdapter;

    aget-object v2, v2, v0

    invoke-virtual {v2}, Landroid/widget/BaseAdapter;->getCount()I

    move-result v2

    add-int/2addr v1, v2

    .line 338
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 341
    :cond_0
    return v1
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 15
    .param p1, "pos"    # I
    .param p2, "view"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 161
    invoke-virtual/range {p3 .. p3}, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-static {v1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v11

    .line 164
    .local v11, "inflater":Landroid/view/LayoutInflater;
    const/4 v4, 0x0

    .line 165
    .local v4, "index":I
    const/4 v3, 0x0

    .line 167
    .local v3, "visibleIndex":I
    iget-object v8, p0, Lco/vine/android/widget/SectionAdapter;->mAdapters:[Landroid/widget/BaseAdapter;

    .local v8, "arr$":[Landroid/widget/BaseAdapter;
    array-length v12, v8

    .local v12, "len$":I
    const/4 v10, 0x0

    .local v10, "i$":I
    :goto_0
    if-ge v10, v12, :cond_6

    aget-object v2, v8, v10

    .line 168
    .local v2, "adapter":Landroid/widget/BaseAdapter;
    invoke-direct {p0, v2}, Lco/vine/android/widget/SectionAdapter;->getAdapterCount(Landroid/widget/BaseAdapter;)I

    move-result v9

    .line 169
    .local v9, "count":I
    if-lez v9, :cond_5

    .line 170
    invoke-direct {p0, v4}, Lco/vine/android/widget/SectionAdapter;->hasDivider(I)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 171
    add-int/lit8 v9, v9, 0x1

    .line 172
    if-nez p1, :cond_2

    .line 174
    if-nez p2, :cond_0

    .line 175
    iget v1, p0, Lco/vine/android/widget/SectionAdapter;->mSectionLayout:I

    const/4 v5, 0x0

    move-object/from16 v0, p3

    invoke-virtual {v11, v1, v0, v5}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object p2

    .line 176
    const v1, 0x7f0a0128

    move-object/from16 v0, p2

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    move-object/from16 v0, p2

    invoke-virtual {v0, v1}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 178
    :cond_0
    iget-object v14, p0, Lco/vine/android/widget/SectionAdapter;->mStringResIds:[I

    .line 179
    .local v14, "strings":[I
    array-length v1, v14

    rem-int v1, v4, v1

    aget v13, v14, v1

    .line 180
    .local v13, "stringResId":I
    if-nez v13, :cond_1

    .line 181
    invoke-virtual/range {p2 .. p2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    const/4 v5, 0x0

    invoke-virtual {v1, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    :goto_1
    move-object/from16 v1, p2

    .line 200
    .end local v2    # "adapter":Landroid/widget/BaseAdapter;
    .end local v9    # "count":I
    .end local v13    # "stringResId":I
    .end local v14    # "strings":[I
    :goto_2
    return-object v1

    .line 183
    .restart local v2    # "adapter":Landroid/widget/BaseAdapter;
    .restart local v9    # "count":I
    .restart local v13    # "stringResId":I
    .restart local v14    # "strings":[I
    :cond_1
    invoke-virtual/range {p2 .. p2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    invoke-virtual {v1, v13}, Landroid/widget/TextView;->setText(I)V

    goto :goto_1

    .line 186
    .end local v13    # "stringResId":I
    .end local v14    # "strings":[I
    :cond_2
    move/from16 v0, p1

    if-ge v0, v9, :cond_4

    .line 187
    add-int/lit8 v5, p1, -0x1

    move-object v1, p0

    move-object/from16 v6, p2

    move-object/from16 v7, p3

    invoke-virtual/range {v1 .. v7}, Lco/vine/android/widget/SectionAdapter;->getAdapterView(Landroid/widget/BaseAdapter;IIILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v1

    goto :goto_2

    .line 190
    :cond_3
    move/from16 v0, p1

    if-ge v0, v9, :cond_4

    move-object v1, p0

    move/from16 v5, p1

    move-object/from16 v6, p2

    move-object/from16 v7, p3

    .line 191
    invoke-virtual/range {v1 .. v7}, Lco/vine/android/widget/SectionAdapter;->getAdapterView(Landroid/widget/BaseAdapter;IIILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v1

    goto :goto_2

    .line 194
    :cond_4
    sub-int p1, p1, v9

    .line 195
    add-int/lit8 v3, v3, 0x1

    .line 197
    :cond_5
    add-int/lit8 v4, v4, 0x1

    .line 167
    add-int/lit8 v10, v10, 0x1

    goto :goto_0

    .end local v2    # "adapter":Landroid/widget/BaseAdapter;
    .end local v9    # "count":I
    :cond_6
    move-object/from16 v1, p2

    .line 200
    goto :goto_2
.end method

.method public getViewTypeCount()I
    .locals 6

    .prologue
    .line 295
    const/4 v2, 0x0

    .line 296
    .local v2, "count":I
    iget-object v1, p0, Lco/vine/android/widget/SectionAdapter;->mAdapters:[Landroid/widget/BaseAdapter;

    .local v1, "arr$":[Landroid/widget/BaseAdapter;
    array-length v4, v1

    .local v4, "len$":I
    const/4 v3, 0x0

    .local v3, "i$":I
    :goto_0
    if-ge v3, v4, :cond_0

    aget-object v0, v1, v3

    .line 297
    .local v0, "adapter":Landroid/widget/BaseAdapter;
    invoke-virtual {v0}, Landroid/widget/BaseAdapter;->getViewTypeCount()I

    move-result v5

    add-int/2addr v2, v5

    .line 296
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 300
    .end local v0    # "adapter":Landroid/widget/BaseAdapter;
    :cond_0
    add-int/lit8 v5, v2, 0x1

    return v5
.end method

.method public isEnabled(I)Z
    .locals 7
    .param p1, "pos"    # I

    .prologue
    .line 241
    const/4 v4, 0x0

    .line 242
    .local v4, "index":I
    iget-object v1, p0, Lco/vine/android/widget/SectionAdapter;->mAdapters:[Landroid/widget/BaseAdapter;

    .local v1, "arr$":[Landroid/widget/BaseAdapter;
    array-length v5, v1

    .local v5, "len$":I
    const/4 v3, 0x0

    .local v3, "i$":I
    :goto_0
    if-ge v3, v5, :cond_4

    aget-object v0, v1, v3

    .line 243
    .local v0, "adapter":Landroid/widget/BaseAdapter;
    invoke-direct {p0, v0}, Lco/vine/android/widget/SectionAdapter;->getAdapterCount(Landroid/widget/BaseAdapter;)I

    move-result v2

    .line 244
    .local v2, "count":I
    if-lez v2, :cond_3

    .line 245
    invoke-direct {p0, v4}, Lco/vine/android/widget/SectionAdapter;->hasDivider(I)Z

    move-result v6

    if-eqz v6, :cond_1

    .line 246
    add-int/lit8 v2, v2, 0x1

    .line 247
    if-nez p1, :cond_0

    .line 248
    const/4 v6, 0x0

    .line 261
    .end local v0    # "adapter":Landroid/widget/BaseAdapter;
    .end local v2    # "count":I
    :goto_1
    return v6

    .line 249
    .restart local v0    # "adapter":Landroid/widget/BaseAdapter;
    .restart local v2    # "count":I
    :cond_0
    if-ge p1, v2, :cond_2

    .line 250
    add-int/lit8 v6, p1, -0x1

    invoke-virtual {v0, v6}, Landroid/widget/BaseAdapter;->isEnabled(I)Z

    move-result v6

    goto :goto_1

    .line 253
    :cond_1
    if-ge p1, v2, :cond_2

    .line 254
    invoke-virtual {v0, p1}, Landroid/widget/BaseAdapter;->isEnabled(I)Z

    move-result v6

    goto :goto_1

    .line 257
    :cond_2
    sub-int/2addr p1, v2

    .line 259
    :cond_3
    add-int/lit8 v4, v4, 0x1

    .line 242
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 261
    .end local v0    # "adapter":Landroid/widget/BaseAdapter;
    .end local v2    # "count":I
    :cond_4
    invoke-super {p0, p1}, Landroid/widget/BaseAdapter;->isEnabled(I)Z

    move-result v6

    goto :goto_1
.end method

.method public layoutPinnedHeader(Landroid/view/View;IIII)V
    .locals 6
    .param p1, "header"    # Landroid/view/View;
    .param p2, "l"    # I
    .param p3, "t"    # I
    .param p4, "r"    # I
    .param p5, "b"    # I

    .prologue
    .line 377
    iget-object v0, p0, Lco/vine/android/widget/SectionAdapter;->mPinnedHeaderAdapter:Lco/vine/android/widget/PinnedHeaderAdapter;

    move-object v1, p1

    move v2, p2

    move v3, p3

    move v4, p4

    move v5, p5

    invoke-interface/range {v0 .. v5}, Lco/vine/android/widget/PinnedHeaderAdapter;->layoutPinnedHeader(Landroid/view/View;IIII)V

    .line 378
    return-void
.end method

.method public notifyDataSetChanged()V
    .locals 1

    .prologue
    .line 346
    invoke-super {p0}, Landroid/widget/BaseAdapter;->notifyDataSetChanged()V

    .line 347
    const/4 v0, 0x1

    iput-boolean v0, p0, Lco/vine/android/widget/SectionAdapter;->mNotifyOnChange:Z

    .line 348
    return-void
.end method

.method public release()V
    .locals 5

    .prologue
    .line 68
    iget-object v1, p0, Lco/vine/android/widget/SectionAdapter;->mAdapters:[Landroid/widget/BaseAdapter;

    .local v1, "arr$":[Landroid/widget/BaseAdapter;
    array-length v3, v1

    .local v3, "len$":I
    const/4 v2, 0x0

    .local v2, "i$":I
    :goto_0
    if-ge v2, v3, :cond_0

    aget-object v0, v1, v2

    .line 69
    .local v0, "adapter":Landroid/widget/BaseAdapter;
    iget-object v4, p0, Lco/vine/android/widget/SectionAdapter;->mDataSetObserver:Lco/vine/android/widget/SectionAdapter$AdapterDataSetObserver;

    invoke-virtual {v0, v4}, Landroid/widget/BaseAdapter;->unregisterDataSetObserver(Landroid/database/DataSetObserver;)V

    .line 68
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 71
    .end local v0    # "adapter":Landroid/widget/BaseAdapter;
    :cond_0
    return-void
.end method
