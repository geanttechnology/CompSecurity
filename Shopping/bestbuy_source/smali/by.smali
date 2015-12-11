.class public abstract Lby;
.super Landroid/widget/BaseAdapter;
.source "SourceFile"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# instance fields
.field private a:I


# direct methods
.method private i(I)I
    .locals 2

    .prologue
    .line 166
    invoke-virtual {p0, p1}, Lby;->a(I)I

    move-result v1

    invoke-virtual {p0, p1}, Lby;->b(I)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    add-int/2addr v0, v1

    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public abstract a()I
.end method

.method public abstract a(I)I
.end method

.method public abstract a(IILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
.end method

.method public a(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 1

    .prologue
    .line 26
    const/4 v0, 0x0

    return-object v0
.end method

.method public abstract a(II)Ljava/lang/Object;
.end method

.method public a(Landroid/widget/AdapterView;Landroid/view/View;IIJ)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView",
            "<*>;",
            "Landroid/view/View;",
            "IIJ)V"
        }
    .end annotation

    .prologue
    .line 65
    return-void
.end method

.method public b()I
    .locals 1

    .prologue
    .line 34
    const/4 v0, 0x1

    return v0
.end method

.method public b(II)I
    .locals 1

    .prologue
    .line 45
    const/4 v0, 0x0

    return v0
.end method

.method public b(I)Z
    .locals 1

    .prologue
    .line 22
    const/4 v0, 0x0

    return v0
.end method

.method public c()I
    .locals 1

    .prologue
    .line 38
    const/4 v0, 0x1

    return v0
.end method

.method public c(I)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 30
    const/4 v0, 0x0

    return-object v0
.end method

.method public c(II)Z
    .locals 1

    .prologue
    .line 215
    const/4 v0, 0x1

    return v0
.end method

.method public d(I)I
    .locals 1

    .prologue
    .line 52
    const/4 v0, 0x0

    return v0
.end method

.method public d()Z
    .locals 1

    .prologue
    .line 211
    const/4 v0, 0x0

    return v0
.end method

.method protected e(I)I
    .locals 3

    .prologue
    const/4 v0, 0x0

    .line 122
    move v1, v0

    .line 124
    :goto_0
    if-gt v0, p1, :cond_0

    invoke-virtual {p0}, Lby;->a()I

    move-result v2

    if-gt v1, v2, :cond_0

    .line 125
    invoke-direct {p0, v1}, Lby;->i(I)I

    move-result v2

    add-int/2addr v0, v2

    .line 126
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 128
    :cond_0
    add-int/lit8 v0, v1, -0x1

    return v0
.end method

.method protected f(I)I
    .locals 2

    .prologue
    .line 136
    invoke-virtual {p0, p1}, Lby;->e(I)I

    move-result v1

    .line 137
    invoke-virtual {p0, v1}, Lby;->h(I)I

    move-result v0

    sub-int v0, p1, v0

    .line 138
    invoke-virtual {p0, v1}, Lby;->b(I)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 139
    add-int/lit8 v0, v0, -0x1

    .line 141
    :cond_0
    return v0
.end method

.method protected g(I)Z
    .locals 2

    .prologue
    .line 149
    invoke-virtual {p0, p1}, Lby;->e(I)I

    move-result v0

    .line 150
    invoke-virtual {p0, v0}, Lby;->b(I)Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-virtual {p0, v0}, Lby;->h(I)I

    move-result v0

    if-ne v0, p1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public final getCount()I
    .locals 1

    .prologue
    .line 72
    iget v0, p0, Lby;->a:I

    if-gez v0, :cond_0

    .line 73
    invoke-virtual {p0}, Lby;->a()I

    move-result v0

    invoke-virtual {p0, v0}, Lby;->h(I)I

    move-result v0

    iput v0, p0, Lby;->a:I

    .line 75
    :cond_0
    iget v0, p0, Lby;->a:I

    return v0
.end method

.method public final getItem(I)Ljava/lang/Object;
    .locals 2

    .prologue
    .line 88
    invoke-virtual {p0, p1}, Lby;->e(I)I

    move-result v0

    .line 89
    invoke-virtual {p0, p1}, Lby;->g(I)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 90
    invoke-virtual {p0, v0}, Lby;->b(I)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 91
    invoke-virtual {p0, v0}, Lby;->c(I)Ljava/lang/Object;

    move-result-object v0

    .line 95
    :goto_0
    return-object v0

    .line 93
    :cond_0
    const/4 v0, 0x0

    goto :goto_0

    .line 95
    :cond_1
    invoke-virtual {p0, p1}, Lby;->f(I)I

    move-result v1

    invoke-virtual {p0, v0, v1}, Lby;->a(II)Ljava/lang/Object;

    move-result-object v0

    goto :goto_0
.end method

.method public getItemId(I)J
    .locals 2

    .prologue
    .line 100
    int-to-long v0, p1

    return-wide v0
.end method

.method public final getItemViewType(I)I
    .locals 2

    .prologue
    .line 186
    invoke-virtual {p0, p1}, Lby;->e(I)I

    move-result v0

    .line 187
    invoke-virtual {p0, p1}, Lby;->g(I)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 188
    invoke-virtual {p0}, Lby;->b()I

    move-result v1

    invoke-virtual {p0, v0}, Lby;->d(I)I

    move-result v0

    add-int/2addr v0, v1

    .line 190
    :goto_0
    return v0

    :cond_0
    invoke-virtual {p0, p1}, Lby;->f(I)I

    move-result v1

    invoke-virtual {p0, v0, v1}, Lby;->b(II)I

    move-result v0

    goto :goto_0
.end method

.method public final getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 2

    .prologue
    .line 108
    invoke-virtual {p0, p1}, Lby;->e(I)I

    move-result v0

    .line 109
    invoke-virtual {p0, p1}, Lby;->g(I)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 110
    invoke-virtual {p0, v0}, Lby;->b(I)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 111
    invoke-virtual {p0, v0, p2, p3}, Lby;->a(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    .line 115
    :goto_0
    return-object v0

    .line 113
    :cond_0
    const/4 v0, 0x0

    goto :goto_0

    .line 115
    :cond_1
    invoke-virtual {p0, p1}, Lby;->f(I)I

    move-result v1

    invoke-virtual {p0, v0, v1, p2, p3}, Lby;->a(IILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    goto :goto_0
.end method

.method public final getViewTypeCount()I
    .locals 2

    .prologue
    .line 199
    invoke-virtual {p0}, Lby;->b()I

    move-result v0

    invoke-virtual {p0}, Lby;->c()I

    move-result v1

    add-int/2addr v0, v1

    return v0
.end method

.method protected h(I)I
    .locals 3

    .prologue
    const/4 v0, 0x0

    .line 158
    move v1, v0

    .line 159
    :goto_0
    invoke-virtual {p0}, Lby;->a()I

    move-result v2

    invoke-static {v2, p1}, Ljava/lang/Math;->min(II)I

    move-result v2

    if-ge v0, v2, :cond_0

    .line 160
    invoke-direct {p0, v0}, Lby;->i(I)I

    move-result v2

    add-int/2addr v1, v2

    .line 159
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 162
    :cond_0
    return v1
.end method

.method public isEmpty()Z
    .locals 1

    .prologue
    .line 80
    invoke-virtual {p0}, Lby;->getCount()I

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isEnabled(I)Z
    .locals 2

    .prologue
    .line 207
    invoke-virtual {p0}, Lby;->d()Z

    move-result v0

    if-nez v0, :cond_0

    invoke-virtual {p0, p1}, Lby;->g(I)Z

    move-result v0

    if-nez v0, :cond_1

    :cond_0
    invoke-virtual {p0, p1}, Lby;->e(I)I

    move-result v0

    invoke-virtual {p0, p1}, Lby;->f(I)I

    move-result v1

    invoke-virtual {p0, v0, v1}, Lby;->c(II)Z

    move-result v0

    if-eqz v0, :cond_1

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public notifyDataSetChanged()V
    .locals 1

    .prologue
    .line 171
    invoke-virtual {p0}, Lby;->a()I

    move-result v0

    invoke-virtual {p0, v0}, Lby;->h(I)I

    move-result v0

    iput v0, p0, Lby;->a:I

    .line 172
    invoke-super {p0}, Landroid/widget/BaseAdapter;->notifyDataSetChanged()V

    .line 173
    return-void
.end method

.method public notifyDataSetInvalidated()V
    .locals 1

    .prologue
    .line 177
    invoke-virtual {p0}, Lby;->a()I

    move-result v0

    invoke-virtual {p0, v0}, Lby;->h(I)I

    move-result v0

    iput v0, p0, Lby;->a:I

    .line 178
    invoke-super {p0}, Landroid/widget/BaseAdapter;->notifyDataSetInvalidated()V

    .line 179
    return-void
.end method

.method public final onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView",
            "<*>;",
            "Landroid/view/View;",
            "IJ)V"
        }
    .end annotation

    .prologue
    .line 60
    invoke-virtual {p0, p3}, Lby;->e(I)I

    move-result v4

    invoke-virtual {p0, p3}, Lby;->f(I)I

    move-result v5

    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    move-wide v6, p4

    invoke-virtual/range {v1 .. v7}, Lby;->a(Landroid/widget/AdapterView;Landroid/view/View;IIJ)V

    .line 61
    return-void
.end method
