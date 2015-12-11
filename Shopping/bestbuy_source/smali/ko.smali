.class public Lko;
.super Landroid/widget/LinearLayout;
.source "SourceFile"


# virtual methods
.method public a(I)V
    .locals 4

    .prologue
    const/4 v2, 0x0

    .line 160
    move v1, v2

    :goto_0
    invoke-virtual {p0}, Lko;->getChildCount()I

    move-result v0

    if-ge v1, v0, :cond_2

    .line 161
    invoke-virtual {p0, v1}, Lko;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 162
    if-ne p1, v1, :cond_1

    .line 163
    if-eqz v0, :cond_0

    .line 164
    const/4 v3, 0x1

    invoke-virtual {v0, v3}, Landroid/widget/ImageView;->setSelected(Z)V

    .line 160
    :cond_0
    :goto_1
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0

    .line 167
    :cond_1
    invoke-virtual {v0, v2}, Landroid/widget/ImageView;->setSelected(Z)V

    goto :goto_1

    .line 170
    :cond_2
    return-void
.end method
