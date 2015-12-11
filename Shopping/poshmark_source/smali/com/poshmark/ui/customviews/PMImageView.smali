.class public abstract Lcom/poshmark/ui/customviews/PMImageView;
.super Landroid/widget/ImageView;
.source "PMImageView.java"


# instance fields
.field bUsingResourceBitmap:Z

.field customOnCLickListener:Lcom/poshmark/ui/customviews/PMImageViewOnClickListener;

.field imageClickListener:Landroid/view/View$OnClickListener;

.field protected imgURL:Ljava/lang/String;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 34
    invoke-direct {p0, p1}, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V

    .line 19
    const-string v0, ""

    iput-object v0, p0, Lcom/poshmark/ui/customviews/PMImageView;->imgURL:Ljava/lang/String;

    .line 20
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/poshmark/ui/customviews/PMImageView;->bUsingResourceBitmap:Z

    .line 23
    new-instance v0, Lcom/poshmark/ui/customviews/PMImageView$1;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/customviews/PMImageView$1;-><init>(Lcom/poshmark/ui/customviews/PMImageView;)V

    iput-object v0, p0, Lcom/poshmark/ui/customviews/PMImageView;->imageClickListener:Landroid/view/View$OnClickListener;

    .line 35
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 5
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    const/4 v4, 0x1

    .line 38
    invoke-direct {p0, p1, p2}, Landroid/widget/ImageView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 19
    const-string v2, ""

    iput-object v2, p0, Lcom/poshmark/ui/customviews/PMImageView;->imgURL:Ljava/lang/String;

    .line 20
    iput-boolean v4, p0, Lcom/poshmark/ui/customviews/PMImageView;->bUsingResourceBitmap:Z

    .line 23
    new-instance v2, Lcom/poshmark/ui/customviews/PMImageView$1;

    invoke-direct {v2, p0}, Lcom/poshmark/ui/customviews/PMImageView$1;-><init>(Lcom/poshmark/ui/customviews/PMImageView;)V

    iput-object v2, p0, Lcom/poshmark/ui/customviews/PMImageView;->imageClickListener:Landroid/view/View$OnClickListener;

    .line 39
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMImageView;->getContext()Landroid/content/Context;

    move-result-object v2

    sget-object v3, Lcom/poshmark/app/R$styleable;->PMImageView:[I

    invoke-virtual {v2, p2, v3}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 40
    .local v0, "array":Landroid/content/res/TypedArray;
    const/4 v2, 0x0

    invoke-virtual {v0, v2, v4}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v1

    .line 41
    .local v1, "isClickable":Z
    if-eqz v1, :cond_0

    .line 42
    iget-object v2, p0, Lcom/poshmark/ui/customviews/PMImageView;->imageClickListener:Landroid/view/View$OnClickListener;

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/customviews/PMImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 44
    :cond_0
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    .line 45
    return-void
.end method


# virtual methods
.method public getImageURL()Ljava/lang/String;
    .locals 1

    .prologue
    .line 95
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMImageView;->imgURL:Ljava/lang/String;

    return-object v0
.end method

.method public abstract launchFragmentOnClick()V
.end method

.method public loadImage(I)V
    .locals 1
    .param p1, "imageID"    # I

    .prologue
    .line 69
    const-string v0, ""

    iput-object v0, p0, Lcom/poshmark/ui/customviews/PMImageView;->imgURL:Ljava/lang/String;

    .line 70
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/poshmark/ui/customviews/PMImageView;->bUsingResourceBitmap:Z

    .line 71
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMImageView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/customviews/PMImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 72
    return-void
.end method

.method public loadImage(Ljava/lang/String;)V
    .locals 5
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 48
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMImageView;->releaseInternalBitmap()V

    .line 49
    const/4 v3, 0x0

    invoke-virtual {p0, v3}, Lcom/poshmark/ui/customviews/PMImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    .line 50
    if-eqz p1, :cond_1

    .line 51
    invoke-static {}, Lcom/nostra13/universalimageloader/core/ImageLoader;->getInstance()Lcom/nostra13/universalimageloader/core/ImageLoader;

    move-result-object v2

    .line 52
    .local v2, "imageLoader":Lcom/nostra13/universalimageloader/core/ImageLoader;
    invoke-virtual {v2, p1, p0}, Lcom/nostra13/universalimageloader/core/ImageLoader;->displayImage(Ljava/lang/String;Landroid/widget/ImageView;)V

    .line 53
    iput-object p1, p0, Lcom/poshmark/ui/customviews/PMImageView;->imgURL:Ljava/lang/String;

    .line 54
    const/4 v3, 0x0

    iput-boolean v3, p0, Lcom/poshmark/ui/customviews/PMImageView;->bUsingResourceBitmap:Z

    .line 65
    .end local v2    # "imageLoader":Lcom/nostra13/universalimageloader/core/ImageLoader;
    :cond_0
    :goto_0
    return-void

    .line 56
    :cond_1
    const-string v3, ""

    iput-object v3, p0, Lcom/poshmark/ui/customviews/PMImageView;->imgURL:Ljava/lang/String;

    .line 57
    const/4 v3, 0x1

    iput-boolean v3, p0, Lcom/poshmark/ui/customviews/PMImageView;->bUsingResourceBitmap:Z

    .line 58
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMImageView;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f0200d4

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    .line 59
    .local v1, "d":Landroid/graphics/drawable/Drawable;
    instance-of v3, v1, Landroid/graphics/drawable/BitmapDrawable;

    if-eqz v3, :cond_0

    .line 60
    check-cast v1, Landroid/graphics/drawable/BitmapDrawable;

    .end local v1    # "d":Landroid/graphics/drawable/Drawable;
    invoke-virtual {v1}, Landroid/graphics/drawable/BitmapDrawable;->getBitmap()Landroid/graphics/Bitmap;

    move-result-object v0

    .line 61
    .local v0, "b":Landroid/graphics/Bitmap;
    invoke-virtual {p0, v0}, Lcom/poshmark/ui/customviews/PMImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    goto :goto_0
.end method

.method public releaseInternalBitmap()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 79
    iget-boolean v2, p0, Lcom/poshmark/ui/customviews/PMImageView;->bUsingResourceBitmap:Z

    if-nez v2, :cond_0

    .line 81
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMImageView;->getDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v1

    check-cast v1, Landroid/graphics/drawable/BitmapDrawable;

    .line 82
    .local v1, "drawable":Landroid/graphics/drawable/BitmapDrawable;
    if-eqz v1, :cond_0

    .line 83
    invoke-virtual {v1}, Landroid/graphics/drawable/BitmapDrawable;->getBitmap()Landroid/graphics/Bitmap;

    move-result-object v0

    .line 84
    .local v0, "bmp":Landroid/graphics/Bitmap;
    if-eqz v0, :cond_0

    .line 85
    invoke-virtual {v0}, Landroid/graphics/Bitmap;->recycle()V

    .line 86
    invoke-virtual {p0, v3}, Lcom/poshmark/ui/customviews/PMImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 87
    invoke-virtual {p0, v3}, Lcom/poshmark/ui/customviews/PMImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    .line 88
    const-string v2, ""

    iput-object v2, p0, Lcom/poshmark/ui/customviews/PMImageView;->imgURL:Ljava/lang/String;

    .line 92
    .end local v0    # "bmp":Landroid/graphics/Bitmap;
    .end local v1    # "drawable":Landroid/graphics/drawable/BitmapDrawable;
    :cond_0
    return-void
.end method

.method public resetImageUrl()V
    .locals 1

    .prologue
    .line 75
    const-string v0, ""

    iput-object v0, p0, Lcom/poshmark/ui/customviews/PMImageView;->imgURL:Ljava/lang/String;

    .line 76
    return-void
.end method

.method public setCustomOnClickListener(Lcom/poshmark/ui/customviews/PMImageViewOnClickListener;)V
    .locals 0
    .param p1, "listener"    # Lcom/poshmark/ui/customviews/PMImageViewOnClickListener;

    .prologue
    .line 99
    iput-object p1, p0, Lcom/poshmark/ui/customviews/PMImageView;->customOnCLickListener:Lcom/poshmark/ui/customviews/PMImageViewOnClickListener;

    .line 100
    return-void
.end method
