.class public Lcom/poshmark/ui/customviews/ColorSelectionView;
.super Landroid/widget/LinearLayout;
.source "ColorSelectionView.java"


# instance fields
.field context:Landroid/content/Context;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 24
    invoke-direct {p0, p1, p2}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 25
    iput-object p1, p0, Lcom/poshmark/ui/customviews/ColorSelectionView;->context:Landroid/content/Context;

    .line 26
    return-void
.end method


# virtual methods
.method public addAllColors(Ljava/util/List;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/PMColor;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 43
    .local p1, "colorsList":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/PMColor;>;"
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/ColorSelectionView;->removeAllColors()V

    .line 44
    if-eqz p1, :cond_0

    invoke-interface {p1}, Ljava/util/List;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_0

    .line 45
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .line 46
    .local v1, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/PMColor;>;"
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 47
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/PMColor;

    .line 48
    .local v0, "color":Lcom/poshmark/data_model/models/PMColor;
    invoke-virtual {p0, v0}, Lcom/poshmark/ui/customviews/ColorSelectionView;->addColor(Lcom/poshmark/data_model/models/PMColor;)V

    goto :goto_0

    .line 51
    .end local v0    # "color":Lcom/poshmark/data_model/models/PMColor;
    .end local v1    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/PMColor;>;"
    :cond_0
    return-void
.end method

.method public addColor(Lcom/poshmark/data_model/models/PMColor;)V
    .locals 8
    .param p1, "color"    # Lcom/poshmark/data_model/models/PMColor;

    .prologue
    const/4 v7, 0x0

    const/4 v6, -0x2

    const/high16 v5, 0x41f00000    # 30.0f

    .line 29
    new-instance v1, Landroid/widget/ImageView;

    iget-object v4, p0, Lcom/poshmark/ui/customviews/ColorSelectionView;->context:Landroid/content/Context;

    invoke-direct {v1, v4}, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V

    .line 30
    .local v1, "imgView":Landroid/widget/ImageView;
    new-instance v2, Landroid/widget/LinearLayout$LayoutParams;

    invoke-direct {v2, v6, v6}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    .line 31
    .local v2, "lp":Landroid/widget/LinearLayout$LayoutParams;
    iget-object v4, p0, Lcom/poshmark/ui/customviews/ColorSelectionView;->context:Landroid/content/Context;

    invoke-static {v4, v5}, Lcom/poshmark/utils/ViewUtils;->dipToPixels(Landroid/content/Context;F)F

    move-result v4

    float-to-int v4, v4

    iput v4, v2, Landroid/widget/LinearLayout$LayoutParams;->height:I

    .line 32
    iget-object v4, p0, Lcom/poshmark/ui/customviews/ColorSelectionView;->context:Landroid/content/Context;

    invoke-static {v4, v5}, Lcom/poshmark/utils/ViewUtils;->dipToPixels(Landroid/content/Context;F)F

    move-result v4

    float-to-int v4, v4

    iput v4, v2, Landroid/widget/LinearLayout$LayoutParams;->width:I

    .line 33
    iget-object v4, p0, Lcom/poshmark/ui/customviews/ColorSelectionView;->context:Landroid/content/Context;

    const/high16 v5, 0x41200000    # 10.0f

    invoke-static {v4, v5}, Lcom/poshmark/utils/ViewUtils;->dipToPixels(Landroid/content/Context;F)F

    move-result v4

    float-to-int v3, v4

    .line 34
    .local v3, "offset":I
    invoke-virtual {v2, v3, v7, v3, v7}, Landroid/widget/LinearLayout$LayoutParams;->setMargins(IIII)V

    .line 35
    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 36
    iget-object v4, p0, Lcom/poshmark/ui/customviews/ColorSelectionView;->context:Landroid/content/Context;

    invoke-virtual {v4}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    const v5, 0x7f020038

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    check-cast v0, Landroid/graphics/drawable/GradientDrawable;

    .line 37
    .local v0, "drawable":Landroid/graphics/drawable/GradientDrawable;
    iget-object v4, p1, Lcom/poshmark/data_model/models/PMColor;->rgb:Ljava/lang/String;

    invoke-virtual {v4}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I

    move-result v4

    invoke-virtual {v0, v4}, Landroid/graphics/drawable/GradientDrawable;->setColor(I)V

    .line 38
    invoke-virtual {v1, v0}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 39
    invoke-virtual {p0, v1}, Lcom/poshmark/ui/customviews/ColorSelectionView;->addView(Landroid/view/View;)V

    .line 40
    return-void
.end method

.method public removeAllColors()V
    .locals 0

    .prologue
    .line 54
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/ColorSelectionView;->removeAllViews()V

    .line 55
    return-void
.end method
