.class public abstract Lcom/wishabi/flipp/widget/da;
.super Landroid/widget/BaseAdapter;
.source "SourceFile"


# instance fields
.field private a:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field public j:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 12
    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    return-void
.end method


# virtual methods
.method protected a(IILandroid/view/View;)Landroid/view/View;
    .locals 1

    .prologue
    .line 134
    const/4 v0, 0x0

    return-object v0
.end method

.method protected a(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 1

    .prologue
    .line 138
    const/4 v0, 0x0

    return-object v0
.end method

.method protected a(I)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 129
    const/4 v0, 0x0

    return-object v0
.end method

.method protected final a(Ljava/util/List;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/Integer;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 17
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/wishabi/flipp/widget/da;->a:Ljava/util/List;

    .line 18
    const/4 v0, 0x0

    iput v0, p0, Lcom/wishabi/flipp/widget/da;->j:I

    .line 19
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    .line 23
    iget-object v2, p0, Lcom/wishabi/flipp/widget/da;->a:Ljava/util/List;

    iget v3, p0, Lcom/wishabi/flipp/widget/da;->j:I

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-interface {v2, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 24
    iget v2, p0, Lcom/wishabi/flipp/widget/da;->j:I

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    add-int/2addr v0, v2

    iput v0, p0, Lcom/wishabi/flipp/widget/da;->j:I

    goto :goto_0

    .line 26
    :cond_0
    return-void
.end method

.method public areAllItemsEnabled()Z
    .locals 1

    .prologue
    .line 38
    const/4 v0, 0x0

    return v0
.end method

.method public final b()I
    .locals 1

    .prologue
    .line 33
    iget-object v0, p0, Lcom/wishabi/flipp/widget/da;->a:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    return v0
.end method

.method protected final b(II)I
    .locals 1

    .prologue
    .line 29
    iget-object v0, p0, Lcom/wishabi/flipp/widget/da;->a:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    add-int/2addr v0, p2

    return v0
.end method

.method protected c(I)I
    .locals 1

    .prologue
    .line 152
    const/4 v0, -0x1

    return v0
.end method

.method protected d(I)I
    .locals 1

    .prologue
    .line 156
    const/4 v0, -0x1

    return v0
.end method

.method public getCount()I
    .locals 2

    .prologue
    .line 52
    iget v0, p0, Lcom/wishabi/flipp/widget/da;->j:I

    iget-object v1, p0, Lcom/wishabi/flipp/widget/da;->a:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    mul-int/lit8 v1, v1, 0x2

    add-int/2addr v0, v1

    return v0
.end method

.method public getItem(I)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 57
    iget v0, p0, Lcom/wishabi/flipp/widget/da;->j:I

    if-ge p1, v0, :cond_0

    .line 58
    invoke-virtual {p0, p1}, Lcom/wishabi/flipp/widget/da;->a(I)Ljava/lang/Object;

    move-result-object v0

    .line 60
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getItemId(I)J
    .locals 2

    .prologue
    .line 65
    int-to-long v0, p1

    return-wide v0
.end method

.method public getItemViewType(I)I
    .locals 4

    .prologue
    const/4 v0, -0x1

    .line 101
    iget v1, p0, Lcom/wishabi/flipp/widget/da;->j:I

    if-ge p1, v1, :cond_1

    .line 103
    iget-object v1, p0, Lcom/wishabi/flipp/widget/da;->a:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    move v1, v0

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    .line 105
    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v3

    if-lt p1, v3, :cond_0

    .line 106
    add-int/lit8 v1, v1, 0x1

    .line 109
    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    goto :goto_0

    .line 111
    :cond_0
    invoke-virtual {p0, v1}, Lcom/wishabi/flipp/widget/da;->c(I)I

    move-result v0

    .line 118
    :goto_1
    return v0

    .line 112
    :cond_1
    iget v1, p0, Lcom/wishabi/flipp/widget/da;->j:I

    iget-object v2, p0, Lcom/wishabi/flipp/widget/da;->a:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    add-int/2addr v1, v2

    if-ge p1, v1, :cond_2

    .line 113
    iget v0, p0, Lcom/wishabi/flipp/widget/da;->j:I

    sub-int v0, p1, v0

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/da;->d(I)I

    move-result v0

    goto :goto_1

    .line 114
    :cond_2
    iget v1, p0, Lcom/wishabi/flipp/widget/da;->j:I

    iget-object v2, p0, Lcom/wishabi/flipp/widget/da;->a:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    mul-int/lit8 v2, v2, 0x2

    add-int/2addr v1, v2

    if-ge p1, v1, :cond_3

    .line 115
    iget-object v1, p0, Lcom/wishabi/flipp/widget/da;->a:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    goto :goto_1

    .line 118
    :cond_3
    iget-object v1, p0, Lcom/wishabi/flipp/widget/da;->a:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    goto :goto_1
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 5

    .prologue
    const/4 v0, 0x0

    .line 75
    iget v1, p0, Lcom/wishabi/flipp/widget/da;->j:I

    if-ge p1, v1, :cond_1

    .line 76
    const/4 v1, -0x1

    .line 77
    const/4 v0, 0x0

    .line 78
    iget-object v2, p0, Lcom/wishabi/flipp/widget/da;->a:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    move v2, v1

    move v1, v0

    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    .line 79
    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v4

    if-lt p1, v4, :cond_0

    .line 80
    add-int/lit8 v1, v2, 0x1

    .line 83
    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    sub-int v0, p1, v0

    move v2, v1

    move v1, v0

    .line 84
    goto :goto_0

    .line 85
    :cond_0
    invoke-virtual {p0, v2, v1, p2}, Lcom/wishabi/flipp/widget/da;->a(IILandroid/view/View;)Landroid/view/View;

    move-result-object v0

    .line 93
    :goto_1
    return-object v0

    .line 86
    :cond_1
    iget v1, p0, Lcom/wishabi/flipp/widget/da;->j:I

    iget-object v2, p0, Lcom/wishabi/flipp/widget/da;->a:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    add-int/2addr v1, v2

    if-ge p1, v1, :cond_2

    .line 87
    iget v0, p0, Lcom/wishabi/flipp/widget/da;->j:I

    sub-int v0, p1, v0

    invoke-virtual {p0, v0, p2, p3}, Lcom/wishabi/flipp/widget/da;->a(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    goto :goto_1

    .line 88
    :cond_2
    iget v1, p0, Lcom/wishabi/flipp/widget/da;->j:I

    iget-object v2, p0, Lcom/wishabi/flipp/widget/da;->a:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    mul-int/lit8 v2, v2, 0x2

    add-int/2addr v1, v2

    if-ge p1, v1, :cond_3

    .line 89
    iget-object v1, p0, Lcom/wishabi/flipp/widget/da;->a:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    goto :goto_1

    .line 93
    :cond_3
    iget-object v1, p0, Lcom/wishabi/flipp/widget/da;->a:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    goto :goto_1
.end method

.method public hasStableIds()Z
    .locals 1

    .prologue
    .line 70
    const/4 v0, 0x0

    return v0
.end method

.method public isEmpty()Z
    .locals 1

    .prologue
    .line 125
    iget v0, p0, Lcom/wishabi/flipp/widget/da;->j:I

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isEnabled(I)Z
    .locals 1

    .prologue
    .line 43
    iget v0, p0, Lcom/wishabi/flipp/widget/da;->j:I

    if-ge p1, v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
