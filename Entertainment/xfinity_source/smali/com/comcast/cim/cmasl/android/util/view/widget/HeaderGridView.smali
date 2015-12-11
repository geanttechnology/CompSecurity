.class public Lcom/comcast/cim/cmasl/android/util/view/widget/HeaderGridView;
.super Landroid/widget/GridView;
.source "HeaderGridView.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/comcast/cim/cmasl/android/util/view/widget/HeaderGridView$1;,
        Lcom/comcast/cim/cmasl/android/util/view/widget/HeaderGridView$HeaderViewGridAdapter;,
        Lcom/comcast/cim/cmasl/android/util/view/widget/HeaderGridView$FullWidthFixedViewLayout;,
        Lcom/comcast/cim/cmasl/android/util/view/widget/HeaderGridView$FixedViewInfo;
    }
.end annotation


# instance fields
.field private mHeaderViewInfos:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/comcast/cim/cmasl/android/util/view/widget/HeaderGridView$FixedViewInfo;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 65
    invoke-direct {p0, p1}, Landroid/widget/GridView;-><init>(Landroid/content/Context;)V

    .line 58
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/HeaderGridView;->mHeaderViewInfos:Ljava/util/ArrayList;

    .line 66
    invoke-direct {p0}, Lcom/comcast/cim/cmasl/android/util/view/widget/HeaderGridView;->initHeaderGridView()V

    .line 67
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 70
    invoke-direct {p0, p1, p2}, Landroid/widget/GridView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 58
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/HeaderGridView;->mHeaderViewInfos:Ljava/util/ArrayList;

    .line 71
    invoke-direct {p0}, Lcom/comcast/cim/cmasl/android/util/view/widget/HeaderGridView;->initHeaderGridView()V

    .line 72
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    .line 75
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/GridView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 58
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/HeaderGridView;->mHeaderViewInfos:Ljava/util/ArrayList;

    .line 76
    invoke-direct {p0}, Lcom/comcast/cim/cmasl/android/util/view/widget/HeaderGridView;->initHeaderGridView()V

    .line 77
    return-void
.end method

.method private initHeaderGridView()V
    .locals 1

    .prologue
    .line 61
    const/4 v0, 0x0

    invoke-super {p0, v0}, Landroid/widget/GridView;->setClipChildren(Z)V

    .line 62
    return-void
.end method

.method private removeFixedViewInfo(Landroid/view/View;Ljava/util/ArrayList;)V
    .locals 4
    .param p1, "v"    # Landroid/view/View;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/view/View;",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/comcast/cim/cmasl/android/util/view/widget/HeaderGridView$FixedViewInfo;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 168
    .local p2, "where":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/comcast/cim/cmasl/android/util/view/widget/HeaderGridView$FixedViewInfo;>;"
    invoke-virtual {p2}, Ljava/util/ArrayList;->size()I

    move-result v2

    .line 169
    .local v2, "len":I
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    if-ge v0, v2, :cond_0

    .line 170
    invoke-virtual {p2, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/comcast/cim/cmasl/android/util/view/widget/HeaderGridView$FixedViewInfo;

    .line 171
    .local v1, "info":Lcom/comcast/cim/cmasl/android/util/view/widget/HeaderGridView$FixedViewInfo;
    iget-object v3, v1, Lcom/comcast/cim/cmasl/android/util/view/widget/HeaderGridView$FixedViewInfo;->view:Landroid/view/View;

    if-ne v3, p1, :cond_1

    .line 172
    invoke-virtual {p2, v0}, Ljava/util/ArrayList;->remove(I)Ljava/lang/Object;

    .line 176
    .end local v1    # "info":Lcom/comcast/cim/cmasl/android/util/view/widget/HeaderGridView$FixedViewInfo;
    :cond_0
    return-void

    .line 169
    .restart local v1    # "info":Lcom/comcast/cim/cmasl/android/util/view/widget/HeaderGridView$FixedViewInfo;
    :cond_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_0
.end method


# virtual methods
.method public addHeaderView(Landroid/view/View;)V
    .locals 2
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 140
    const/4 v0, 0x0

    const/4 v1, 0x1

    invoke-virtual {p0, p1, v0, v1}, Lcom/comcast/cim/cmasl/android/util/view/widget/HeaderGridView;->addHeaderView(Landroid/view/View;Ljava/lang/Object;Z)V

    .line 141
    return-void
.end method

.method public addHeaderView(Landroid/view/View;Ljava/lang/Object;Z)V
    .locals 5
    .param p1, "v"    # Landroid/view/View;
    .param p2, "data"    # Ljava/lang/Object;
    .param p3, "isSelectable"    # Z

    .prologue
    .line 106
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/android/util/view/widget/HeaderGridView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v0

    .line 108
    .local v0, "adapter":Landroid/widget/ListAdapter;
    if-eqz v0, :cond_0

    instance-of v3, v0, Lcom/comcast/cim/cmasl/android/util/view/widget/HeaderGridView$HeaderViewGridAdapter;

    if-nez v3, :cond_0

    .line 109
    new-instance v3, Ljava/lang/IllegalStateException;

    const-string v4, "Cannot add header view to grid -- setAdapter has already been called."

    invoke-direct {v3, v4}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 113
    :cond_0
    new-instance v2, Lcom/comcast/cim/cmasl/android/util/view/widget/HeaderGridView$FixedViewInfo;

    const/4 v3, 0x0

    invoke-direct {v2, v3}, Lcom/comcast/cim/cmasl/android/util/view/widget/HeaderGridView$FixedViewInfo;-><init>(Lcom/comcast/cim/cmasl/android/util/view/widget/HeaderGridView$1;)V

    .line 114
    .local v2, "info":Lcom/comcast/cim/cmasl/android/util/view/widget/HeaderGridView$FixedViewInfo;
    new-instance v1, Lcom/comcast/cim/cmasl/android/util/view/widget/HeaderGridView$FullWidthFixedViewLayout;

    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/android/util/view/widget/HeaderGridView;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-direct {v1, p0, v3}, Lcom/comcast/cim/cmasl/android/util/view/widget/HeaderGridView$FullWidthFixedViewLayout;-><init>(Lcom/comcast/cim/cmasl/android/util/view/widget/HeaderGridView;Landroid/content/Context;)V

    .line 115
    .local v1, "fl":Landroid/widget/FrameLayout;
    invoke-virtual {v1, p1}, Landroid/widget/FrameLayout;->addView(Landroid/view/View;)V

    .line 116
    iput-object p1, v2, Lcom/comcast/cim/cmasl/android/util/view/widget/HeaderGridView$FixedViewInfo;->view:Landroid/view/View;

    .line 117
    iput-object v1, v2, Lcom/comcast/cim/cmasl/android/util/view/widget/HeaderGridView$FixedViewInfo;->viewContainer:Landroid/view/ViewGroup;

    .line 118
    iput-object p2, v2, Lcom/comcast/cim/cmasl/android/util/view/widget/HeaderGridView$FixedViewInfo;->data:Ljava/lang/Object;

    .line 119
    iput-boolean p3, v2, Lcom/comcast/cim/cmasl/android/util/view/widget/HeaderGridView$FixedViewInfo;->isSelectable:Z

    .line 120
    iget-object v3, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/HeaderGridView;->mHeaderViewInfos:Ljava/util/ArrayList;

    invoke-virtual {v3, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 124
    if-eqz v0, :cond_1

    .line 125
    check-cast v0, Lcom/comcast/cim/cmasl/android/util/view/widget/HeaderGridView$HeaderViewGridAdapter;

    .end local v0    # "adapter":Landroid/widget/ListAdapter;
    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/android/util/view/widget/HeaderGridView$HeaderViewGridAdapter;->notifyDataSetChanged()V

    .line 127
    :cond_1
    return-void
.end method

.method public getHeaderViewCount()I
    .locals 1

    .prologue
    .line 144
    iget-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/HeaderGridView;->mHeaderViewInfos:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    return v0
.end method

.method public getWrappedAdapter()Landroid/widget/ListAdapter;
    .locals 2

    .prologue
    .line 179
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/android/util/view/widget/HeaderGridView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v0

    .line 180
    .local v0, "adapter":Landroid/widget/ListAdapter;
    instance-of v1, v0, Lcom/comcast/cim/cmasl/android/util/view/widget/HeaderGridView$HeaderViewGridAdapter;

    if-eqz v1, :cond_0

    .line 181
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/android/util/view/widget/HeaderGridView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v1

    check-cast v1, Lcom/comcast/cim/cmasl/android/util/view/widget/HeaderGridView$HeaderViewGridAdapter;

    invoke-virtual {v1}, Lcom/comcast/cim/cmasl/android/util/view/widget/HeaderGridView$HeaderViewGridAdapter;->getWrappedAdapter()Landroid/widget/ListAdapter;

    move-result-object v0

    .line 183
    .end local v0    # "adapter":Landroid/widget/ListAdapter;
    :cond_0
    return-object v0
.end method

.method protected onMeasure(II)V
    .locals 2
    .param p1, "widthMeasureSpec"    # I
    .param p2, "heightMeasureSpec"    # I

    .prologue
    .line 81
    invoke-super {p0, p1, p2}, Landroid/widget/GridView;->onMeasure(II)V

    .line 82
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/android/util/view/widget/HeaderGridView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v0

    .line 83
    .local v0, "adapter":Landroid/widget/ListAdapter;
    if-eqz v0, :cond_0

    instance-of v1, v0, Lcom/comcast/cim/cmasl/android/util/view/widget/HeaderGridView$HeaderViewGridAdapter;

    if-eqz v1, :cond_0

    .line 84
    check-cast v0, Lcom/comcast/cim/cmasl/android/util/view/widget/HeaderGridView$HeaderViewGridAdapter;

    .end local v0    # "adapter":Landroid/widget/ListAdapter;
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/android/util/view/widget/HeaderGridView;->getNumColumns()I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/comcast/cim/cmasl/android/util/view/widget/HeaderGridView$HeaderViewGridAdapter;->setNumColumns(I)V

    .line 86
    :cond_0
    return-void
.end method

.method public removeHeaderView(Landroid/view/View;)Z
    .locals 3
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 155
    iget-object v2, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/HeaderGridView;->mHeaderViewInfos:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v2

    if-lez v2, :cond_1

    .line 156
    const/4 v1, 0x0

    .line 157
    .local v1, "result":Z
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/android/util/view/widget/HeaderGridView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v0

    .line 158
    .local v0, "adapter":Landroid/widget/ListAdapter;
    if-eqz v0, :cond_0

    check-cast v0, Lcom/comcast/cim/cmasl/android/util/view/widget/HeaderGridView$HeaderViewGridAdapter;

    .end local v0    # "adapter":Landroid/widget/ListAdapter;
    invoke-virtual {v0, p1}, Lcom/comcast/cim/cmasl/android/util/view/widget/HeaderGridView$HeaderViewGridAdapter;->removeHeader(Landroid/view/View;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 159
    const/4 v1, 0x1

    .line 161
    :cond_0
    iget-object v2, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/HeaderGridView;->mHeaderViewInfos:Ljava/util/ArrayList;

    invoke-direct {p0, p1, v2}, Lcom/comcast/cim/cmasl/android/util/view/widget/HeaderGridView;->removeFixedViewInfo(Landroid/view/View;Ljava/util/ArrayList;)V

    .line 164
    .end local v1    # "result":Z
    :goto_0
    return v1

    :cond_1
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public bridge synthetic setAdapter(Landroid/widget/Adapter;)V
    .locals 0
    .param p1, "x0"    # Landroid/widget/Adapter;

    .prologue
    .line 41
    check-cast p1, Landroid/widget/ListAdapter;

    .end local p1    # "x0":Landroid/widget/Adapter;
    invoke-virtual {p0, p1}, Lcom/comcast/cim/cmasl/android/util/view/widget/HeaderGridView;->setAdapter(Landroid/widget/ListAdapter;)V

    return-void
.end method

.method public setAdapter(Landroid/widget/ListAdapter;)V
    .locals 3
    .param p1, "adapter"    # Landroid/widget/ListAdapter;

    .prologue
    .line 189
    iget-object v2, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/HeaderGridView;->mHeaderViewInfos:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v2

    if-lez v2, :cond_1

    .line 190
    new-instance v0, Lcom/comcast/cim/cmasl/android/util/view/widget/HeaderGridView$HeaderViewGridAdapter;

    iget-object v2, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/HeaderGridView;->mHeaderViewInfos:Ljava/util/ArrayList;

    invoke-direct {v0, v2, p1}, Lcom/comcast/cim/cmasl/android/util/view/widget/HeaderGridView$HeaderViewGridAdapter;-><init>(Ljava/util/ArrayList;Landroid/widget/ListAdapter;)V

    .line 191
    .local v0, "hadapter":Lcom/comcast/cim/cmasl/android/util/view/widget/HeaderGridView$HeaderViewGridAdapter;
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/android/util/view/widget/HeaderGridView;->getNumColumns()I

    move-result v1

    .line 192
    .local v1, "numColumns":I
    const/4 v2, 0x1

    if-le v1, v2, :cond_0

    .line 193
    invoke-virtual {v0, v1}, Lcom/comcast/cim/cmasl/android/util/view/widget/HeaderGridView$HeaderViewGridAdapter;->setNumColumns(I)V

    .line 195
    :cond_0
    invoke-super {p0, v0}, Landroid/widget/GridView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 199
    .end local v0    # "hadapter":Lcom/comcast/cim/cmasl/android/util/view/widget/HeaderGridView$HeaderViewGridAdapter;
    .end local v1    # "numColumns":I
    :goto_0
    return-void

    .line 197
    :cond_1
    invoke-super {p0, p1}, Landroid/widget/GridView;->setAdapter(Landroid/widget/ListAdapter;)V

    goto :goto_0
.end method

.method public setClipChildren(Z)V
    .locals 0
    .param p1, "clipChildren"    # Z

    .prologue
    .line 91
    return-void
.end method
