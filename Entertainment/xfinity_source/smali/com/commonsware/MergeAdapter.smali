.class public Lcom/commonsware/MergeAdapter;
.super Landroid/widget/BaseAdapter;
.source "MergeAdapter.java"

# interfaces
.implements Landroid/widget/SectionIndexer;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/commonsware/MergeAdapter$CascadeDataSetObserver;,
        Lcom/commonsware/MergeAdapter$EnabledSackAdapter;
    }
.end annotation


# instance fields
.field private pieces:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Landroid/widget/ListAdapter;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 43
    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    .line 37
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/commonsware/MergeAdapter;->pieces:Ljava/util/ArrayList;

    .line 44
    return-void
.end method


# virtual methods
.method public addAdapter(Landroid/widget/ListAdapter;)V
    .locals 2
    .param p1, "adapter"    # Landroid/widget/ListAdapter;

    .prologue
    .line 53
    iget-object v0, p0, Lcom/commonsware/MergeAdapter;->pieces:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 54
    new-instance v0, Lcom/commonsware/MergeAdapter$CascadeDataSetObserver;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lcom/commonsware/MergeAdapter$CascadeDataSetObserver;-><init>(Lcom/commonsware/MergeAdapter;Lcom/commonsware/MergeAdapter$1;)V

    invoke-interface {p1, v0}, Landroid/widget/ListAdapter;->registerDataSetObserver(Landroid/database/DataSetObserver;)V

    .line 55
    return-void
.end method

.method public addView(Landroid/view/View;Z)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;
    .param p2, "enabled"    # Z

    .prologue
    .line 75
    new-instance v0, Ljava/util/ArrayList;

    const/4 v1, 0x1

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(I)V

    .line 77
    .local v0, "list":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/view/View;>;"
    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 79
    invoke-virtual {p0, v0, p2}, Lcom/commonsware/MergeAdapter;->addViews(Ljava/util/List;Z)V

    .line 80
    return-void
.end method

.method public addViews(Ljava/util/List;Z)V
    .locals 1
    .param p2, "enabled"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Landroid/view/View;",
            ">;Z)V"
        }
    .end annotation

    .prologue
    .line 100
    .local p1, "views":Ljava/util/List;, "Ljava/util/List<Landroid/view/View;>;"
    if-eqz p2, :cond_0

    .line 101
    new-instance v0, Lcom/commonsware/MergeAdapter$EnabledSackAdapter;

    invoke-direct {v0, p1}, Lcom/commonsware/MergeAdapter$EnabledSackAdapter;-><init>(Ljava/util/List;)V

    invoke-virtual {p0, v0}, Lcom/commonsware/MergeAdapter;->addAdapter(Landroid/widget/ListAdapter;)V

    .line 105
    :goto_0
    return-void

    .line 103
    :cond_0
    new-instance v0, Lcom/commonsware/SackOfViewsAdapter;

    invoke-direct {v0, p1}, Lcom/commonsware/SackOfViewsAdapter;-><init>(Ljava/util/List;)V

    invoke-virtual {p0, v0}, Lcom/commonsware/MergeAdapter;->addAdapter(Landroid/widget/ListAdapter;)V

    goto :goto_0
.end method

.method public areAllItemsEnabled()Z
    .locals 1

    .prologue
    .line 208
    const/4 v0, 0x0

    return v0
.end method

.method public getCount()I
    .locals 4

    .prologue
    .line 152
    const/4 v1, 0x0

    .line 154
    .local v1, "total":I
    iget-object v2, p0, Lcom/commonsware/MergeAdapter;->pieces:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/ListAdapter;

    .line 155
    .local v0, "piece":Landroid/widget/ListAdapter;
    invoke-interface {v0}, Landroid/widget/ListAdapter;->getCount()I

    move-result v3

    add-int/2addr v1, v3

    .line 156
    goto :goto_0

    .line 158
    .end local v0    # "piece":Landroid/widget/ListAdapter;
    :cond_0
    return v1
.end method

.method public getItem(I)Ljava/lang/Object;
    .locals 4
    .param p1, "position"    # I

    .prologue
    .line 114
    iget-object v2, p0, Lcom/commonsware/MergeAdapter;->pieces:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/ListAdapter;

    .line 115
    .local v0, "piece":Landroid/widget/ListAdapter;
    invoke-interface {v0}, Landroid/widget/ListAdapter;->getCount()I

    move-result v1

    .line 117
    .local v1, "size":I
    if-ge p1, v1, :cond_0

    .line 118
    invoke-interface {v0, p1}, Landroid/widget/ListAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v2

    .line 124
    .end local v0    # "piece":Landroid/widget/ListAdapter;
    .end local v1    # "size":I
    :goto_1
    return-object v2

    .line 121
    .restart local v0    # "piece":Landroid/widget/ListAdapter;
    .restart local v1    # "size":I
    :cond_0
    sub-int/2addr p1, v1

    .line 122
    goto :goto_0

    .line 124
    .end local v0    # "piece":Landroid/widget/ListAdapter;
    .end local v1    # "size":I
    :cond_1
    const/4 v2, 0x0

    goto :goto_1
.end method

.method public getItemId(I)J
    .locals 4
    .param p1, "position"    # I

    .prologue
    .line 262
    iget-object v2, p0, Lcom/commonsware/MergeAdapter;->pieces:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/ListAdapter;

    .line 263
    .local v0, "piece":Landroid/widget/ListAdapter;
    invoke-interface {v0}, Landroid/widget/ListAdapter;->getCount()I

    move-result v1

    .line 265
    .local v1, "size":I
    if-ge p1, v1, :cond_0

    .line 266
    invoke-interface {v0, p1}, Landroid/widget/ListAdapter;->getItemId(I)J

    move-result-wide v2

    .line 272
    .end local v0    # "piece":Landroid/widget/ListAdapter;
    .end local v1    # "size":I
    :goto_1
    return-wide v2

    .line 269
    .restart local v0    # "piece":Landroid/widget/ListAdapter;
    .restart local v1    # "size":I
    :cond_0
    sub-int/2addr p1, v1

    .line 270
    goto :goto_0

    .line 272
    .end local v0    # "piece":Landroid/widget/ListAdapter;
    .end local v1    # "size":I
    :cond_1
    const-wide/16 v2, -0x1

    goto :goto_1
.end method

.method public getItemViewType(I)I
    .locals 6
    .param p1, "position"    # I

    .prologue
    .line 184
    const/4 v3, 0x0

    .line 185
    .local v3, "typeOffset":I
    const/4 v1, -0x1

    .line 187
    .local v1, "result":I
    iget-object v4, p0, Lcom/commonsware/MergeAdapter;->pieces:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/ListAdapter;

    .line 188
    .local v0, "piece":Landroid/widget/ListAdapter;
    invoke-interface {v0}, Landroid/widget/ListAdapter;->getCount()I

    move-result v2

    .line 190
    .local v2, "size":I
    if-ge p1, v2, :cond_1

    .line 191
    invoke-interface {v0, p1}, Landroid/widget/ListAdapter;->getItemViewType(I)I

    move-result v4

    add-int v1, v3, v4

    .line 199
    .end local v0    # "piece":Landroid/widget/ListAdapter;
    .end local v2    # "size":I
    :cond_0
    return v1

    .line 195
    .restart local v0    # "piece":Landroid/widget/ListAdapter;
    .restart local v2    # "size":I
    :cond_1
    sub-int/2addr p1, v2

    .line 196
    invoke-interface {v0}, Landroid/widget/ListAdapter;->getViewTypeCount()I

    move-result v5

    add-int/2addr v3, v5

    .line 197
    goto :goto_0
.end method

.method public getPositionForSection(I)I
    .locals 6
    .param p1, "section"    # I

    .prologue
    .line 276
    const/4 v2, 0x0

    .line 278
    .local v2, "position":I
    iget-object v4, p0, Lcom/commonsware/MergeAdapter;->pieces:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :goto_0
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_3

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/widget/ListAdapter;

    .line 279
    .local v1, "piece":Landroid/widget/ListAdapter;
    instance-of v4, v1, Landroid/widget/SectionIndexer;

    if-eqz v4, :cond_2

    move-object v4, v1

    .line 280
    check-cast v4, Landroid/widget/SectionIndexer;

    invoke-interface {v4}, Landroid/widget/SectionIndexer;->getSections()[Ljava/lang/Object;

    move-result-object v3

    .line 281
    .local v3, "sections":[Ljava/lang/Object;
    const/4 v0, 0x0

    .line 283
    .local v0, "numSections":I
    if-eqz v3, :cond_0

    .line 284
    array-length v0, v3

    .line 287
    :cond_0
    if-ge p1, v0, :cond_1

    .line 288
    check-cast v1, Landroid/widget/SectionIndexer;

    .end local v1    # "piece":Landroid/widget/ListAdapter;
    invoke-interface {v1, p1}, Landroid/widget/SectionIndexer;->getPositionForSection(I)I

    move-result v4

    add-int/2addr v4, v2

    .line 297
    .end local v0    # "numSections":I
    .end local v3    # "sections":[Ljava/lang/Object;
    :goto_1
    return v4

    .line 289
    .restart local v0    # "numSections":I
    .restart local v1    # "piece":Landroid/widget/ListAdapter;
    .restart local v3    # "sections":[Ljava/lang/Object;
    :cond_1
    if-eqz v3, :cond_2

    .line 290
    sub-int/2addr p1, v0

    .line 294
    .end local v0    # "numSections":I
    .end local v3    # "sections":[Ljava/lang/Object;
    :cond_2
    invoke-interface {v1}, Landroid/widget/ListAdapter;->getCount()I

    move-result v4

    add-int/2addr v2, v4

    .line 295
    goto :goto_0

    .line 297
    .end local v1    # "piece":Landroid/widget/ListAdapter;
    :cond_3
    const/4 v4, 0x0

    goto :goto_1
.end method

.method public getSectionForPosition(I)I
    .locals 7
    .param p1, "position"    # I

    .prologue
    const/4 v4, 0x0

    .line 301
    const/4 v1, 0x0

    .line 303
    .local v1, "section":I
    iget-object v5, p0, Lcom/commonsware/MergeAdapter;->pieces:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :goto_0
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_0

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/ListAdapter;

    .line 304
    .local v0, "piece":Landroid/widget/ListAdapter;
    invoke-interface {v0}, Landroid/widget/ListAdapter;->getCount()I

    move-result v3

    .line 306
    .local v3, "size":I
    if-ge p1, v3, :cond_1

    .line 307
    instance-of v5, v0, Landroid/widget/SectionIndexer;

    if-eqz v5, :cond_0

    .line 308
    check-cast v0, Landroid/widget/SectionIndexer;

    .end local v0    # "piece":Landroid/widget/ListAdapter;
    invoke-interface {v0, p1}, Landroid/widget/SectionIndexer;->getSectionForPosition(I)I

    move-result v4

    add-int/2addr v4, v1

    .line 325
    .end local v3    # "size":I
    :cond_0
    return v4

    .line 313
    .restart local v0    # "piece":Landroid/widget/ListAdapter;
    .restart local v3    # "size":I
    :cond_1
    instance-of v6, v0, Landroid/widget/SectionIndexer;

    if-eqz v6, :cond_2

    .line 314
    check-cast v0, Landroid/widget/SectionIndexer;

    .end local v0    # "piece":Landroid/widget/ListAdapter;
    invoke-interface {v0}, Landroid/widget/SectionIndexer;->getSections()[Ljava/lang/Object;

    move-result-object v2

    .line 316
    .local v2, "sections":[Ljava/lang/Object;
    if-eqz v2, :cond_2

    .line 317
    array-length v6, v2

    add-int/2addr v1, v6

    .line 322
    .end local v2    # "sections":[Ljava/lang/Object;
    :cond_2
    sub-int/2addr p1, v3

    .line 323
    goto :goto_0
.end method

.method public getSections()[Ljava/lang/Object;
    .locals 5

    .prologue
    .line 329
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 331
    .local v2, "sections":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/Object;>;"
    iget-object v3, p0, Lcom/commonsware/MergeAdapter;->pieces:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_0
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_1

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/widget/ListAdapter;

    .line 332
    .local v1, "piece":Landroid/widget/ListAdapter;
    instance-of v4, v1, Landroid/widget/SectionIndexer;

    if-eqz v4, :cond_0

    .line 333
    check-cast v1, Landroid/widget/SectionIndexer;

    .end local v1    # "piece":Landroid/widget/ListAdapter;
    invoke-interface {v1}, Landroid/widget/SectionIndexer;->getSections()[Ljava/lang/Object;

    move-result-object v0

    .line 335
    .local v0, "curSections":[Ljava/lang/Object;
    if-eqz v0, :cond_0

    .line 336
    invoke-virtual {v2, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 341
    .end local v0    # "curSections":[Ljava/lang/Object;
    :cond_1
    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v3

    if-nez v3, :cond_2

    .line 342
    const/4 v3, 0x0

    .line 345
    :goto_1
    return-object v3

    :cond_2
    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v3

    new-array v3, v3, [Ljava/lang/Object;

    invoke-virtual {v2, v3}, Ljava/util/ArrayList;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v3

    goto :goto_1
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 4
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 241
    iget-object v2, p0, Lcom/commonsware/MergeAdapter;->pieces:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/ListAdapter;

    .line 242
    .local v0, "piece":Landroid/widget/ListAdapter;
    invoke-interface {v0}, Landroid/widget/ListAdapter;->getCount()I

    move-result v1

    .line 244
    .local v1, "size":I
    if-ge p1, v1, :cond_0

    .line 246
    invoke-interface {v0, p1, p2, p3}, Landroid/widget/ListAdapter;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v2

    .line 252
    .end local v0    # "piece":Landroid/widget/ListAdapter;
    .end local v1    # "size":I
    :goto_1
    return-object v2

    .line 249
    .restart local v0    # "piece":Landroid/widget/ListAdapter;
    .restart local v1    # "size":I
    :cond_0
    sub-int/2addr p1, v1

    .line 250
    goto :goto_0

    .line 252
    .end local v0    # "piece":Landroid/widget/ListAdapter;
    .end local v1    # "size":I
    :cond_1
    const/4 v2, 0x0

    goto :goto_1
.end method

.method public getViewTypeCount()I
    .locals 4

    .prologue
    .line 167
    const/4 v1, 0x0

    .line 169
    .local v1, "total":I
    iget-object v2, p0, Lcom/commonsware/MergeAdapter;->pieces:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/ListAdapter;

    .line 170
    .local v0, "piece":Landroid/widget/ListAdapter;
    invoke-interface {v0}, Landroid/widget/ListAdapter;->getViewTypeCount()I

    move-result v3

    add-int/2addr v1, v3

    .line 171
    goto :goto_0

    .line 173
    .end local v0    # "piece":Landroid/widget/ListAdapter;
    :cond_0
    const/4 v2, 0x1

    invoke-static {v1, v2}, Ljava/lang/Math;->max(II)I

    move-result v2

    return v2
.end method

.method public isEnabled(I)Z
    .locals 4
    .param p1, "position"    # I

    .prologue
    .line 219
    iget-object v2, p0, Lcom/commonsware/MergeAdapter;->pieces:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/ListAdapter;

    .line 220
    .local v0, "piece":Landroid/widget/ListAdapter;
    invoke-interface {v0}, Landroid/widget/ListAdapter;->getCount()I

    move-result v1

    .line 222
    .local v1, "size":I
    if-ge p1, v1, :cond_0

    .line 223
    invoke-interface {v0, p1}, Landroid/widget/ListAdapter;->isEnabled(I)Z

    move-result v2

    .line 229
    .end local v0    # "piece":Landroid/widget/ListAdapter;
    .end local v1    # "size":I
    :goto_1
    return v2

    .line 226
    .restart local v0    # "piece":Landroid/widget/ListAdapter;
    .restart local v1    # "size":I
    :cond_0
    sub-int/2addr p1, v1

    .line 227
    goto :goto_0

    .line 229
    .end local v0    # "piece":Landroid/widget/ListAdapter;
    .end local v1    # "size":I
    :cond_1
    const/4 v2, 0x0

    goto :goto_1
.end method
