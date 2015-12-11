.class public Lcom/poshmark/utils/ViewUtils;
.super Ljava/lang/Object;
.source "ViewUtils.java"


# static fields
.field public static final sMaxHostImageCount:I = 0x7


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 25
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static addEmptyView(Landroid/content/Context;Landroid/view/ViewGroup;IZ)V
    .locals 4
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "parentView"    # Landroid/view/ViewGroup;
    .param p2, "height"    # I
    .param p3, "valueIsPixels"    # Z

    .prologue
    .line 62
    if-nez p3, :cond_0

    .line 63
    int-to-float v3, p2

    invoke-static {p0, v3}, Lcom/poshmark/utils/ViewUtils;->dipToPixels(Landroid/content/Context;F)F

    move-result v3

    float-to-int v1, v3

    .line 67
    .local v1, "footerHeight":I
    :goto_0
    new-instance v0, Landroid/view/View;

    const/4 v3, 0x0

    invoke-direct {v0, p0, v3}, Landroid/view/View;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 68
    .local v0, "bottomSpaceView":Landroid/view/View;
    new-instance v2, Landroid/widget/LinearLayout$LayoutParams;

    const/4 v3, -0x1

    invoke-direct {v2, v3, v1}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    .line 69
    .local v2, "lp":Landroid/widget/LinearLayout$LayoutParams;
    invoke-virtual {v0, v2}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 70
    invoke-virtual {p1, v0}, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V

    .line 71
    return-void

    .line 65
    .end local v0    # "bottomSpaceView":Landroid/view/View;
    .end local v1    # "footerHeight":I
    .end local v2    # "lp":Landroid/widget/LinearLayout$LayoutParams;
    :cond_0
    move v1, p2

    .restart local v1    # "footerHeight":I
    goto :goto_0
.end method

.method public static dipToPixels(Landroid/content/Context;F)F
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "dipValue"    # F

    .prologue
    .line 45
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v0

    .line 46
    .local v0, "metrics":Landroid/util/DisplayMetrics;
    const/4 v1, 0x1

    invoke-static {v1, p1, v0}, Landroid/util/TypedValue;->applyDimension(IFLandroid/util/DisplayMetrics;)F

    move-result v1

    return v1
.end method

.method public static getDiffInTops(Landroid/view/View;Landroid/view/View;)Landroid/graphics/Point;
    .locals 9
    .param p0, "child"    # Landroid/view/View;
    .param p1, "parent"    # Landroid/view/View;

    .prologue
    const/4 v6, 0x2

    const/4 v8, 0x1

    const/4 v7, 0x0

    .line 127
    new-instance v3, Landroid/graphics/Rect;

    invoke-direct {v3}, Landroid/graphics/Rect;-><init>()V

    .line 128
    .local v3, "result":Landroid/graphics/Rect;
    new-instance v1, Landroid/graphics/Rect;

    invoke-direct {v1}, Landroid/graphics/Rect;-><init>()V

    .line 129
    .local v1, "rectChild":Landroid/graphics/Rect;
    new-instance v2, Landroid/graphics/Rect;

    invoke-direct {v2}, Landroid/graphics/Rect;-><init>()V

    .line 130
    .local v2, "rectParent":Landroid/graphics/Rect;
    new-array v4, v6, [I

    .line 131
    .local v4, "topLeftChild":[I
    new-array v5, v6, [I

    .line 132
    .local v5, "topLeftParent":[I
    new-instance v0, Landroid/graphics/Point;

    invoke-direct {v0}, Landroid/graphics/Point;-><init>()V

    .line 133
    .local v0, "point":Landroid/graphics/Point;
    invoke-virtual {p0, v1}, Landroid/view/View;->getGlobalVisibleRect(Landroid/graphics/Rect;)Z

    .line 134
    invoke-virtual {p1, v2}, Landroid/view/View;->getGlobalVisibleRect(Landroid/graphics/Rect;)Z

    .line 136
    aget v6, v5, v7

    aget v7, v4, v7

    sub-int/2addr v6, v7

    iput v6, v0, Landroid/graphics/Point;->x:I

    .line 137
    aget v6, v5, v8

    aget v7, v4, v8

    sub-int/2addr v6, v7

    iput v6, v0, Landroid/graphics/Point;->y:I

    .line 139
    invoke-virtual {p0, v4}, Landroid/view/View;->getLocationOnScreen([I)V

    .line 140
    invoke-virtual {p1, v5}, Landroid/view/View;->getLocationOnScreen([I)V

    .line 142
    iget v6, v2, Landroid/graphics/Rect;->left:I

    iget v7, v1, Landroid/graphics/Rect;->left:I

    sub-int/2addr v6, v7

    iput v6, v3, Landroid/graphics/Rect;->left:I

    .line 143
    iget v6, v2, Landroid/graphics/Rect;->top:I

    iget v7, v1, Landroid/graphics/Rect;->top:I

    sub-int/2addr v6, v7

    iput v6, v3, Landroid/graphics/Rect;->top:I

    .line 144
    iget v6, v2, Landroid/graphics/Rect;->right:I

    iget v7, v1, Landroid/graphics/Rect;->right:I

    sub-int/2addr v6, v7

    iput v6, v3, Landroid/graphics/Rect;->right:I

    .line 145
    iget v6, v2, Landroid/graphics/Rect;->bottom:I

    iget v7, v1, Landroid/graphics/Rect;->bottom:I

    sub-int/2addr v6, v7

    iput v6, v3, Landroid/graphics/Rect;->bottom:I

    .line 146
    return-object v0
.end method

.method public static getTypefaceFromName(Landroid/content/Context;Ljava/lang/String;)Landroid/graphics/Typeface;
    .locals 3
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "typefaceName"    # Ljava/lang/String;

    .prologue
    .line 52
    if-eqz p1, :cond_0

    .line 53
    invoke-virtual {p0}, Landroid/content/Context;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v1

    invoke-static {v1, p1}, Landroid/graphics/Typeface;->createFromAsset(Landroid/content/res/AssetManager;Ljava/lang/String;)Landroid/graphics/Typeface;

    move-result-object v0

    .line 57
    .local v0, "font":Landroid/graphics/Typeface;
    :goto_0
    return-object v0

    .line 55
    .end local v0    # "font":Landroid/graphics/Typeface;
    :cond_0
    const/4 v1, 0x0

    check-cast v1, Ljava/lang/String;

    const/4 v2, 0x0

    invoke-static {v1, v2}, Landroid/graphics/Typeface;->create(Ljava/lang/String;I)Landroid/graphics/Typeface;

    move-result-object v0

    .restart local v0    # "font":Landroid/graphics/Typeface;
    goto :goto_0
.end method

.method public static loadFbAvataar(Ljava/lang/String;Landroid/widget/ImageView;)V
    .locals 4
    .param p0, "fbToken"    # Ljava/lang/String;
    .param p1, "imageView"    # Landroid/widget/ImageView;

    .prologue
    .line 31
    new-instance v1, Ljava/lang/String;

    const-string v2, "https://graph.facebook.com/%s/picture?width=100&height=100"

    invoke-direct {v1, v2}, Ljava/lang/String;-><init>(Ljava/lang/String;)V

    .line 32
    .local v1, "url":Ljava/lang/String;
    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object p0, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    .line 34
    invoke-static {}, Lcom/nostra13/universalimageloader/core/ImageLoader;->getInstance()Lcom/nostra13/universalimageloader/core/ImageLoader;

    move-result-object v0

    .line 35
    .local v0, "imageLoader":Lcom/nostra13/universalimageloader/core/ImageLoader;
    invoke-virtual {v0, v1, p1}, Lcom/nostra13/universalimageloader/core/ImageLoader;->displayImage(Ljava/lang/String;Landroid/widget/ImageView;)V

    .line 36
    return-void
.end method

.method public static loadGooglePlusAvataar(Ljava/lang/String;Landroid/widget/ImageView;)V
    .locals 1
    .param p0, "url"    # Ljava/lang/String;
    .param p1, "imageView"    # Landroid/widget/ImageView;

    .prologue
    .line 122
    invoke-static {}, Lcom/nostra13/universalimageloader/core/ImageLoader;->getInstance()Lcom/nostra13/universalimageloader/core/ImageLoader;

    move-result-object v0

    .line 123
    .local v0, "imageLoader":Lcom/nostra13/universalimageloader/core/ImageLoader;
    invoke-virtual {v0, p0, p1}, Lcom/nostra13/universalimageloader/core/ImageLoader;->displayImage(Ljava/lang/String;Landroid/widget/ImageView;)V

    .line 124
    return-void
.end method

.method public static populatePartyHostsInLayout(Landroid/content/Context;Ljava/util/List;Landroid/widget/GridLayout;)V
    .locals 16
    .param p0, "context"    # Landroid/content/Context;
    .param p2, "gridLayout"    # Landroid/widget/GridLayout;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/inner_models/Host;",
            ">;",
            "Landroid/widget/GridLayout;",
            ")V"
        }
    .end annotation

    .prologue
    .line 84
    .local p1, "hosts":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/inner_models/Host;>;"
    const/4 v12, 0x0

    .line 85
    .local v12, "row":I
    const/4 v1, 0x0

    .line 86
    .local v1, "col":I
    invoke-interface/range {p1 .. p1}, Ljava/util/List;->size()I

    move-result v6

    .line 87
    .local v6, "hostCount":I
    const/4 v8, 0x0

    .local v8, "i":I
    :goto_0
    if-ge v8, v6, :cond_2

    .line 88
    move-object/from16 v0, p1

    invoke-interface {v0, v8}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/poshmark/data_model/models/inner_models/Host;

    .line 89
    .local v5, "host":Lcom/poshmark/data_model/models/inner_models/Host;
    new-instance v7, Lcom/poshmark/ui/customviews/RoundedImageView;

    const/4 v13, 0x0

    move-object/from16 v0, p0

    invoke-direct {v7, v0, v13}, Lcom/poshmark/ui/customviews/RoundedImageView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 90
    .local v7, "hostImageView":Lcom/poshmark/ui/customviews/RoundedImageView;
    invoke-virtual {v5}, Lcom/poshmark/data_model/models/inner_models/Host;->getUsername()Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v7, v13}, Lcom/poshmark/ui/customviews/RoundedImageView;->setUser(Ljava/lang/String;)V

    .line 92
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v13

    const/high16 v14, 0x41200000    # 10.0f

    invoke-static {v13, v14}, Lcom/poshmark/utils/ViewUtils;->dipToPixels(Landroid/content/Context;F)F

    move-result v13

    float-to-int v10, v13

    .line 93
    .local v10, "margin":I
    mul-int/lit8 v2, v10, 0x3

    .line 95
    .local v2, "dimension":I
    const/4 v13, 0x1

    invoke-static {v12, v13}, Landroid/widget/GridLayout;->spec(II)Landroid/widget/GridLayout$Spec;

    move-result-object v4

    .line 96
    .local v4, "gridRow":Landroid/widget/GridLayout$Spec;
    const/4 v13, 0x1

    invoke-static {v1, v13}, Landroid/widget/GridLayout;->spec(II)Landroid/widget/GridLayout$Spec;

    move-result-object v3

    .line 97
    .local v3, "gridCol":Landroid/widget/GridLayout$Spec;
    new-instance v9, Landroid/widget/GridLayout$LayoutParams;

    invoke-direct {v9, v4, v3}, Landroid/widget/GridLayout$LayoutParams;-><init>(Landroid/widget/GridLayout$Spec;Landroid/widget/GridLayout$Spec;)V

    .line 98
    .local v9, "lp":Landroid/widget/GridLayout$LayoutParams;
    iput v2, v9, Landroid/widget/GridLayout$LayoutParams;->width:I

    .line 99
    iput v2, v9, Landroid/widget/GridLayout$LayoutParams;->height:I

    .line 100
    const/4 v13, 0x0

    div-int/lit8 v14, v10, 0x2

    const/4 v15, 0x0

    invoke-virtual {v9, v13, v14, v10, v15}, Landroid/widget/GridLayout$LayoutParams;->setMargins(IIII)V

    .line 102
    move-object/from16 v0, p2

    invoke-virtual {v0, v7, v9}, Landroid/widget/GridLayout;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 104
    invoke-virtual {v5}, Lcom/poshmark/data_model/models/inner_models/Host;->getAvataar()Ljava/lang/String;

    move-result-object v11

    .line 105
    .local v11, "pictureUrl":Ljava/lang/String;
    if-eqz v11, :cond_0

    .line 106
    invoke-static {}, Lcom/nostra13/universalimageloader/core/ImageLoader;->getInstance()Lcom/nostra13/universalimageloader/core/ImageLoader;

    move-result-object v13

    iget-object v14, v7, Lcom/poshmark/ui/customviews/RoundedImageView;->listener:Lcom/nostra13/universalimageloader/core/listener/ImageLoadingListener;

    invoke-virtual {v13, v11, v14}, Lcom/nostra13/universalimageloader/core/ImageLoader;->loadImage(Ljava/lang/String;Lcom/nostra13/universalimageloader/core/listener/ImageLoadingListener;)V

    .line 111
    :goto_1
    add-int/lit8 v13, v1, 0x1

    const/4 v14, 0x7

    if-ne v13, v14, :cond_1

    .line 112
    add-int/lit8 v12, v12, 0x1

    .line 113
    const/4 v1, 0x0

    .line 87
    :goto_2
    add-int/lit8 v8, v8, 0x1

    goto :goto_0

    .line 108
    :cond_0
    const v13, 0x7f0200d4

    invoke-virtual {v7, v13}, Lcom/poshmark/ui/customviews/RoundedImageView;->setBitmap(I)V

    goto :goto_1

    .line 116
    :cond_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_2

    .line 119
    .end local v2    # "dimension":I
    .end local v3    # "gridCol":Landroid/widget/GridLayout$Spec;
    .end local v4    # "gridRow":Landroid/widget/GridLayout$Spec;
    .end local v5    # "host":Lcom/poshmark/data_model/models/inner_models/Host;
    .end local v7    # "hostImageView":Lcom/poshmark/ui/customviews/RoundedImageView;
    .end local v9    # "lp":Landroid/widget/GridLayout$LayoutParams;
    .end local v10    # "margin":I
    .end local v11    # "pictureUrl":Ljava/lang/String;
    :cond_2
    return-void
.end method

.method public static setTypefaceForView(Landroid/content/Context;Ljava/lang/String;Landroid/widget/TextView;)V
    .locals 0
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "typefaceName"    # Ljava/lang/String;
    .param p2, "view"    # Landroid/widget/TextView;

    .prologue
    .line 39
    if-eqz p2, :cond_0

    .line 42
    :cond_0
    return-void
.end method

.method public static showLoadingProgress(Landroid/content/Context;Landroid/view/View;)V
    .locals 6
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "footerView"    # Landroid/view/View;

    .prologue
    .line 74
    const v4, 0x7f0c012d

    invoke-virtual {p1, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    .line 75
    .local v0, "footerLayout":Landroid/widget/LinearLayout;
    const v4, 0x7f0c012e

    invoke-virtual {v0, v4}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v1

    .line 76
    .local v1, "progressBar":Landroid/view/View;
    if-nez v1, :cond_0

    .line 77
    invoke-static {p0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v3

    .line 78
    .local v3, "vi":Landroid/view/LayoutInflater;
    const v4, 0x7f03004e

    const/4 v5, 0x0

    invoke-virtual {v3, v4, v5}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v2

    .line 79
    .local v2, "v":Landroid/view/View;
    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 81
    .end local v2    # "v":Landroid/view/View;
    .end local v3    # "vi":Landroid/view/LayoutInflater;
    :cond_0
    return-void
.end method
