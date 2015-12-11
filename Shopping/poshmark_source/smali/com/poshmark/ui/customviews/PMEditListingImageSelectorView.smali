.class public Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;
.super Landroid/widget/FrameLayout;
.source "PMEditListingImageSelectorView.java"


# instance fields
.field private deleteButton:Landroid/widget/ImageButton;

.field private imageView:Lcom/poshmark/ui/customviews/PMEditListingImageView;

.field private removeHandler:Lcom/poshmark/utils/RemoveEditListingImageListener;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 23
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 24
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    .line 27
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 29
    return-void
.end method

.method static synthetic access$000(Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;)Lcom/poshmark/utils/RemoveEditListingImageListener;
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;

    .prologue
    .line 16
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->removeHandler:Lcom/poshmark/utils/RemoveEditListingImageListener;

    return-object v0
.end method

.method private setupView()V
    .locals 2

    .prologue
    .line 131
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->imageView:Lcom/poshmark/ui/customviews/PMEditListingImageView;

    if-nez v0, :cond_0

    .line 132
    const v0, 0x7f0c00b5

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/customviews/PMEditListingImageView;

    iput-object v0, p0, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->imageView:Lcom/poshmark/ui/customviews/PMEditListingImageView;

    .line 133
    :cond_0
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->deleteButton:Landroid/widget/ImageButton;

    if-nez v0, :cond_1

    .line 134
    const v0, 0x7f0c01ab

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageButton;

    iput-object v0, p0, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->deleteButton:Landroid/widget/ImageButton;

    .line 135
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->deleteButton:Landroid/widget/ImageButton;

    new-instance v1, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView$1;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView$1;-><init>(Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;)V

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 144
    :cond_1
    return-void
.end method

.method private updateDeleteButtonVisibility()V
    .locals 2

    .prologue
    .line 147
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->imageView:Lcom/poshmark/ui/customviews/PMEditListingImageView;

    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/PMEditListingImageView;->isCovershot()Z

    move-result v0

    if-nez v0, :cond_0

    .line 148
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->deleteButton:Landroid/widget/ImageButton;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setVisibility(I)V

    .line 149
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->deleteButton:Landroid/widget/ImageButton;

    invoke-virtual {v0}, Landroid/widget/ImageButton;->bringToFront()V

    .line 151
    :cond_0
    return-void
.end method


# virtual methods
.method public getFileUri()Landroid/net/Uri;
    .locals 1

    .prologue
    .line 106
    invoke-direct {p0}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->setupView()V

    .line 107
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->imageView:Lcom/poshmark/ui/customviews/PMEditListingImageView;

    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/PMEditListingImageView;->getFileUri()Landroid/net/Uri;

    move-result-object v0

    return-object v0
.end method

.method public getImageBitmap()Landroid/graphics/Bitmap;
    .locals 1

    .prologue
    .line 126
    invoke-direct {p0}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->setupView()V

    .line 127
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->imageView:Lcom/poshmark/ui/customviews/PMEditListingImageView;

    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/PMEditListingImageView;->getDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    check-cast v0, Landroid/graphics/drawable/BitmapDrawable;

    invoke-virtual {v0}, Landroid/graphics/drawable/BitmapDrawable;->getBitmap()Landroid/graphics/Bitmap;

    move-result-object v0

    return-object v0
.end method

.method public getImageId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 121
    invoke-direct {p0}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->setupView()V

    .line 122
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->imageView:Lcom/poshmark/ui/customviews/PMEditListingImageView;

    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/PMEditListingImageView;->getImageId()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getImageUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 116
    invoke-direct {p0}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->setupView()V

    .line 117
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->imageView:Lcom/poshmark/ui/customviews/PMEditListingImageView;

    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/PMEditListingImageView;->getImageUrl()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getOriginalFileUri()Landroid/net/Uri;
    .locals 1

    .prologue
    .line 111
    invoke-direct {p0}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->setupView()V

    .line 112
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->imageView:Lcom/poshmark/ui/customviews/PMEditListingImageView;

    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/PMEditListingImageView;->getOriginalFileUri()Landroid/net/Uri;

    move-result-object v0

    return-object v0
.end method

.method public imageAssignedState(Z)V
    .locals 1
    .param p1, "bIsSet"    # Z

    .prologue
    .line 46
    invoke-direct {p0}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->setupView()V

    .line 47
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->imageView:Lcom/poshmark/ui/customviews/PMEditListingImageView;

    invoke-virtual {v0, p1}, Lcom/poshmark/ui/customviews/PMEditListingImageView;->imageAssignedState(Z)V

    .line 48
    return-void
.end method

.method public isCovershot()Z
    .locals 1

    .prologue
    .line 96
    invoke-direct {p0}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->setupView()V

    .line 97
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->imageView:Lcom/poshmark/ui/customviews/PMEditListingImageView;

    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/PMEditListingImageView;->isCovershot()Z

    move-result v0

    return v0
.end method

.method public isImageSet()Z
    .locals 1

    .prologue
    .line 91
    invoke-direct {p0}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->setupView()V

    .line 92
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->imageView:Lcom/poshmark/ui/customviews/PMEditListingImageView;

    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/PMEditListingImageView;->isImageSet()Z

    move-result v0

    return v0
.end method

.method public isNextSelector()Z
    .locals 1

    .prologue
    .line 101
    invoke-direct {p0}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->setupView()V

    .line 102
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->imageView:Lcom/poshmark/ui/customviews/PMEditListingImageView;

    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/PMEditListingImageView;->isNextSelector()Z

    move-result v0

    return v0
.end method

.method public resetImageView()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 36
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->imageView:Lcom/poshmark/ui/customviews/PMEditListingImageView;

    const v1, 0x106000d

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMEditListingImageView;->setImageResource(I)V

    .line 37
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->imageView:Lcom/poshmark/ui/customviews/PMEditListingImageView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMEditListingImageView;->imageAssignedState(Z)V

    .line 38
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->imageView:Lcom/poshmark/ui/customviews/PMEditListingImageView;

    invoke-virtual {v0, v2}, Lcom/poshmark/ui/customviews/PMEditListingImageView;->setURL(Ljava/lang/String;)V

    .line 39
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->imageView:Lcom/poshmark/ui/customviews/PMEditListingImageView;

    invoke-virtual {v0, v2}, Lcom/poshmark/ui/customviews/PMEditListingImageView;->setFileUri(Landroid/net/Uri;)V

    .line 40
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->imageView:Lcom/poshmark/ui/customviews/PMEditListingImageView;

    invoke-virtual {v0, v2}, Lcom/poshmark/ui/customviews/PMEditListingImageView;->setOriginalFileUri(Landroid/net/Uri;)V

    .line 41
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->deleteButton:Landroid/widget/ImageButton;

    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setVisibility(I)V

    .line 42
    return-void
.end method

.method public setAsNextSelector(Z)V
    .locals 1
    .param p1, "nextSelector"    # Z

    .prologue
    .line 84
    invoke-direct {p0}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->setupView()V

    .line 85
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->imageView:Lcom/poshmark/ui/customviews/PMEditListingImageView;

    invoke-virtual {v0, p1}, Lcom/poshmark/ui/customviews/PMEditListingImageView;->setAsNextEmptyImageView(Z)V

    .line 86
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->imageView:Lcom/poshmark/ui/customviews/PMEditListingImageView;

    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/PMEditListingImageView;->postInvalidate()V

    .line 87
    return-void
.end method

.method public setCovershotStatus(Z)V
    .locals 1
    .param p1, "bIsCovershot"    # Z

    .prologue
    .line 51
    invoke-direct {p0}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->setupView()V

    .line 52
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->imageView:Lcom/poshmark/ui/customviews/PMEditListingImageView;

    invoke-virtual {v0, p1}, Lcom/poshmark/ui/customviews/PMEditListingImageView;->setCovershotStatus(Z)V

    .line 53
    return-void
.end method

.method public setFileUri(Landroid/net/Uri;)V
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;

    .prologue
    .line 56
    invoke-direct {p0}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->setupView()V

    .line 57
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->imageView:Lcom/poshmark/ui/customviews/PMEditListingImageView;

    invoke-virtual {v0, p1}, Lcom/poshmark/ui/customviews/PMEditListingImageView;->setFileUri(Landroid/net/Uri;)V

    .line 58
    invoke-direct {p0}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->updateDeleteButtonVisibility()V

    .line 59
    return-void
.end method

.method public setImageBitmap(Landroid/graphics/Bitmap;)V
    .locals 2
    .param p1, "bitmap"    # Landroid/graphics/Bitmap;

    .prologue
    .line 74
    invoke-direct {p0}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->setupView()V

    .line 76
    invoke-static {}, Lcom/nostra13/universalimageloader/core/ImageLoader;->getInstance()Lcom/nostra13/universalimageloader/core/ImageLoader;

    move-result-object v0

    .line 77
    .local v0, "imageLoader":Lcom/nostra13/universalimageloader/core/ImageLoader;
    iget-object v1, p0, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->imageView:Lcom/poshmark/ui/customviews/PMEditListingImageView;

    invoke-virtual {v0, v1}, Lcom/nostra13/universalimageloader/core/ImageLoader;->cancelDisplayTask(Landroid/widget/ImageView;)V

    .line 79
    iget-object v1, p0, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->imageView:Lcom/poshmark/ui/customviews/PMEditListingImageView;

    invoke-virtual {v1, p1}, Lcom/poshmark/ui/customviews/PMEditListingImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    .line 80
    invoke-direct {p0}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->updateDeleteButtonVisibility()V

    .line 81
    return-void
.end method

.method public setOriginalFileUri(Landroid/net/Uri;)V
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;

    .prologue
    .line 62
    invoke-direct {p0}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->setupView()V

    .line 63
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->imageView:Lcom/poshmark/ui/customviews/PMEditListingImageView;

    invoke-virtual {v0, p1}, Lcom/poshmark/ui/customviews/PMEditListingImageView;->setOriginalFileUri(Landroid/net/Uri;)V

    .line 64
    invoke-direct {p0}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->updateDeleteButtonVisibility()V

    .line 65
    return-void
.end method

.method public setRemoteImageInfo(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "id"    # Ljava/lang/String;

    .prologue
    .line 68
    invoke-direct {p0}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->setupView()V

    .line 69
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->imageView:Lcom/poshmark/ui/customviews/PMEditListingImageView;

    invoke-virtual {v0, p1, p2}, Lcom/poshmark/ui/customviews/PMEditListingImageView;->setRemoteImageInfo(Ljava/lang/String;Ljava/lang/String;)V

    .line 70
    invoke-direct {p0}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->updateDeleteButtonVisibility()V

    .line 71
    return-void
.end method

.method public setRemoveButtonClickListener(Lcom/poshmark/utils/RemoveEditListingImageListener;)V
    .locals 0
    .param p1, "listener"    # Lcom/poshmark/utils/RemoveEditListingImageListener;

    .prologue
    .line 32
    iput-object p1, p0, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->removeHandler:Lcom/poshmark/utils/RemoveEditListingImageListener;

    .line 33
    return-void
.end method
