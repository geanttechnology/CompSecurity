.class public Lcom/poshmark/ui/customviews/PMCovershotImageView;
.super Lcom/poshmark/ui/customviews/PMListingImageView;
.source "PMCovershotImageView.java"


# instance fields
.field isImageSet:Z

.field layoutType:I

.field listingId:Ljava/lang/String;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 28
    invoke-direct {p0, p1, p2}, Lcom/poshmark/ui/customviews/PMListingImageView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 23
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/poshmark/ui/customviews/PMCovershotImageView;->listingId:Ljava/lang/String;

    .line 25
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/poshmark/ui/customviews/PMCovershotImageView;->isImageSet:Z

    .line 29
    return-void
.end method


# virtual methods
.method public launchFragmentOnClick()V
    .locals 4

    .prologue
    .line 37
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 38
    .local v0, "b":Landroid/os/Bundle;
    const-string v2, "ID"

    iget-object v3, p0, Lcom/poshmark/ui/customviews/PMCovershotImageView;->listingId:Ljava/lang/String;

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 40
    iget-object v2, p0, Lcom/poshmark/ui/customviews/PMCovershotImageView;->customOnCLickListener:Lcom/poshmark/ui/customviews/PMImageViewOnClickListener;

    if-eqz v2, :cond_0

    .line 41
    iget-object v2, p0, Lcom/poshmark/ui/customviews/PMCovershotImageView;->customOnCLickListener:Lcom/poshmark/ui/customviews/PMImageViewOnClickListener;

    invoke-interface {v2, p0, v0}, Lcom/poshmark/ui/customviews/PMImageViewOnClickListener;->onClick(Lcom/poshmark/ui/customviews/PMImageView;Landroid/os/Bundle;)V

    .line 46
    :goto_0
    return-void

    .line 43
    :cond_0
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMCovershotImageView;->getContext()Landroid/content/Context;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/PMActivity;

    .line 44
    .local v1, "parentActivity":Lcom/poshmark/ui/PMActivity;
    const-class v2, Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    const/4 v3, 0x0

    invoke-virtual {v1, v0, v2, v3}, Lcom/poshmark/ui/PMActivity;->launchFragmentInNewActivity(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    goto :goto_0
.end method

.method public loadImage(Ljava/lang/String;)V
    .locals 5
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    const/4 v4, 0x1

    .line 49
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMCovershotImageView;->releaseInternalBitmap()V

    .line 50
    const/4 v3, 0x0

    invoke-virtual {p0, v3}, Lcom/poshmark/ui/customviews/PMCovershotImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    .line 51
    if-eqz p1, :cond_1

    .line 52
    invoke-static {}, Lcom/nostra13/universalimageloader/core/ImageLoader;->getInstance()Lcom/nostra13/universalimageloader/core/ImageLoader;

    move-result-object v2

    .line 53
    .local v2, "imageLoader":Lcom/nostra13/universalimageloader/core/ImageLoader;
    invoke-virtual {v2, p1, p0}, Lcom/nostra13/universalimageloader/core/ImageLoader;->displayImage(Ljava/lang/String;Landroid/widget/ImageView;)V

    .line 54
    iput-boolean v4, p0, Lcom/poshmark/ui/customviews/PMCovershotImageView;->isImageSet:Z

    .line 77
    iput-object p1, p0, Lcom/poshmark/ui/customviews/PMCovershotImageView;->imgURL:Ljava/lang/String;

    .line 78
    const/4 v3, 0x0

    iput-boolean v3, p0, Lcom/poshmark/ui/customviews/PMCovershotImageView;->bUsingResourceBitmap:Z

    .line 88
    .end local v2    # "imageLoader":Lcom/nostra13/universalimageloader/core/ImageLoader;
    :cond_0
    :goto_0
    return-void

    .line 80
    :cond_1
    const-string v3, ""

    iput-object v3, p0, Lcom/poshmark/ui/customviews/PMCovershotImageView;->imgURL:Ljava/lang/String;

    .line 81
    iput-boolean v4, p0, Lcom/poshmark/ui/customviews/PMCovershotImageView;->bUsingResourceBitmap:Z

    .line 82
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMCovershotImageView;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f0200d4

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    .line 83
    .local v1, "d":Landroid/graphics/drawable/Drawable;
    instance-of v3, v1, Landroid/graphics/drawable/BitmapDrawable;

    if-eqz v3, :cond_0

    .line 84
    check-cast v1, Landroid/graphics/drawable/BitmapDrawable;

    .end local v1    # "d":Landroid/graphics/drawable/Drawable;
    invoke-virtual {v1}, Landroid/graphics/drawable/BitmapDrawable;->getBitmap()Landroid/graphics/Bitmap;

    move-result-object v0

    .line 85
    .local v0, "b":Landroid/graphics/Bitmap;
    invoke-virtual {p0, v0}, Lcom/poshmark/ui/customviews/PMCovershotImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    goto :goto_0
.end method

.method public requestLayout()V
    .locals 1

    .prologue
    .line 91
    iget-boolean v0, p0, Lcom/poshmark/ui/customviews/PMCovershotImageView;->isImageSet:Z

    if-nez v0, :cond_0

    invoke-super {p0}, Lcom/poshmark/ui/customviews/PMListingImageView;->requestLayout()V

    .line 92
    :cond_0
    return-void
.end method

.method public setListingId(Ljava/lang/String;)V
    .locals 0
    .param p1, "id"    # Ljava/lang/String;

    .prologue
    .line 32
    iput-object p1, p0, Lcom/poshmark/ui/customviews/PMCovershotImageView;->listingId:Ljava/lang/String;

    .line 33
    return-void
.end method
