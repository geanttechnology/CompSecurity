.class public Lcom/xfinity/playerlib/view/featured/TabletFeaturedAccessibleAdapter;
.super Lcom/xfinity/playerlib/view/featured/PhoneCoverAdapter;
.source "TabletFeaturedAccessibleAdapter.java"


# virtual methods
.method protected adjustImageHeight(Landroid/view/View;)V
    .locals 4
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 56
    sget v2, Lcom/xfinity/playerlib/R$id;->cover_art:I

    invoke-virtual {p1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 58
    .local v0, "coverImage":Landroid/widget/ImageView;
    new-instance v1, Landroid/widget/RelativeLayout$LayoutParams;

    const/4 v2, -0x1

    sget v3, Lcom/xfinity/playerlib/view/featured/TabletFeaturedAccessibleAdapter;->coverImageHeightPx:I

    invoke-direct {v1, v2, v3}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    .line 63
    .local v1, "params":Landroid/widget/RelativeLayout$LayoutParams;
    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 64
    invoke-virtual {v0}, Landroid/widget/ImageView;->requestLayout()V

    .line 65
    return-void
.end method

.method protected getCoverImageHeight()Landroid/graphics/Point;
    .locals 5

    .prologue
    .line 35
    iget-object v2, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedAccessibleAdapter;->context:Landroid/content/Context;

    const-string v3, "window"

    invoke-virtual {v2, v3}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/view/WindowManager;

    .line 36
    .local v1, "wm":Landroid/view/WindowManager;
    invoke-interface {v1}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v0

    .line 38
    .local v0, "display":Landroid/view/Display;
    new-instance v2, Landroid/graphics/Point;

    invoke-virtual {v0}, Landroid/view/Display;->getWidth()I

    move-result v3

    div-int/lit8 v3, v3, 0x3

    invoke-virtual {v0}, Landroid/view/Display;->getWidth()I

    move-result v4

    div-int/lit8 v4, v4, 0x6

    invoke-direct {v2, v3, v4}, Landroid/graphics/Point;-><init>(II)V

    return-object v2
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 1
    .param p1, "i"    # I
    .param p2, "view"    # Landroid/view/View;
    .param p3, "viewGroup"    # Landroid/view/ViewGroup;

    .prologue
    .line 48
    invoke-super {p0, p1, p2, p3}, Lcom/xfinity/playerlib/view/featured/PhoneCoverAdapter;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    .line 49
    .local v0, "ret":Landroid/view/View;
    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/featured/TabletFeaturedAccessibleAdapter;->adjustImageHeight(Landroid/view/View;)V

    .line 50
    return-object v0
.end method

.method protected getViewLayoutId()I
    .locals 1

    .prologue
    .line 43
    sget v0, Lcom/xfinity/playerlib/R$layout;->tablet_cover_accessible:I

    return v0
.end method
