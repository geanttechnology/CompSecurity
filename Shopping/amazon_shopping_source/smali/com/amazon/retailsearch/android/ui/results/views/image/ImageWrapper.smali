.class public abstract Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;
.super Landroid/widget/LinearLayout;
.source "ImageWrapper.java"

# interfaces
.implements Lcom/amazon/retailsearch/android/ui/results/views/RetailSearchResultView;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper$ViewHolder;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/widget/LinearLayout;",
        "Lcom/amazon/retailsearch/android/ui/results/views/RetailSearchResultView",
        "<",
        "Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapperModel;",
        ">;"
    }
.end annotation


# instance fields
.field private activeImageRequest:Lcom/amazon/ansel/fetch/ImageRequest;

.field private displayedImage:Lcom/amazon/ansel/fetch/ImageRequest;

.field private imageListener:Lcom/amazon/ansel/fetch/ResourceListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/amazon/ansel/fetch/ResourceListener",
            "<",
            "Landroid/graphics/Bitmap;",
            ">;"
        }
    .end annotation
.end field

.field protected imageView:Landroid/widget/ImageView;

.field private resourceProvider:Lcom/amazon/ansel/fetch/ResourceProvider;

.field protected thumbSwitcher:Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 59
    invoke-direct {p0, p1, p2}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 60
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;)Lcom/amazon/ansel/fetch/ResourceListener;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;

    .prologue
    .line 28
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;->imageListener:Lcom/amazon/ansel/fetch/ResourceListener;

    return-object v0
.end method

.method static synthetic access$100(Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;)Lcom/amazon/ansel/fetch/ImageRequest;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;

    .prologue
    .line 28
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;->activeImageRequest:Lcom/amazon/ansel/fetch/ImageRequest;

    return-object v0
.end method


# virtual methods
.method public buildView(Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapperModel;Lcom/amazon/retailsearch/android/ui/results/ViewType;)V
    .locals 4
    .param p1, "model"    # Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapperModel;
    .param p2, "viewType"    # Lcom/amazon/retailsearch/android/ui/results/ViewType;

    .prologue
    .line 97
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;->imageView:Landroid/widget/ImageView;

    if-eqz v0, :cond_0

    if-nez p1, :cond_1

    .line 99
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;->hideImage()V

    .line 118
    :goto_0
    return-void

    .line 103
    :cond_1
    invoke-virtual {p1}, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapperModel;->getResourceProvider()Lcom/amazon/ansel/fetch/ResourceProvider;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;->resourceProvider:Lcom/amazon/ansel/fetch/ResourceProvider;

    .line 105
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;->imageView:Landroid/widget/ImageView;

    invoke-virtual {p1}, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapperModel;->getContentDescription()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 107
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;->hasThumbSwitcher()Z

    move-result v0

    if-nez v0, :cond_2

    .line 109
    invoke-virtual {p1}, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapperModel;->getImage()Lcom/amazon/ansel/fetch/ImageRequest;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;->loadAndShowImage(Lcom/amazon/ansel/fetch/ImageRequest;)V

    .line 117
    :goto_1
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;->setVisibility(I)V

    goto :goto_0

    .line 114
    :cond_2
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;->thumbSwitcher:Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;

    invoke-virtual {p1}, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapperModel;->getAsin()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1}, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapperModel;->getImageList()Ljava/util/List;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;->resourceProvider:Lcom/amazon/ansel/fetch/ResourceProvider;

    invoke-virtual {v0, v1, p0, v2, v3}, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;->buildView(Ljava/lang/String;Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;Ljava/util/List;Lcom/amazon/ansel/fetch/ResourceProvider;)V

    goto :goto_1
.end method

.method public bridge synthetic buildView(Ljava/lang/Object;Lcom/amazon/retailsearch/android/ui/results/ViewType;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;
    .param p2, "x1"    # Lcom/amazon/retailsearch/android/ui/results/ViewType;

    .prologue
    .line 28
    check-cast p1, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapperModel;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;->buildView(Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapperModel;Lcom/amazon/retailsearch/android/ui/results/ViewType;)V

    return-void
.end method

.method public getImageView()Landroid/widget/ImageView;
    .locals 1

    .prologue
    .line 242
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;->imageView:Landroid/widget/ImageView;

    return-object v0
.end method

.method public hasThumbSwitcher()Z
    .locals 1

    .prologue
    .line 49
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;->thumbSwitcher:Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public hideImage()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 205
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;->imageView:Landroid/widget/ImageView;

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 207
    iput-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;->displayedImage:Lcom/amazon/ansel/fetch/ImageRequest;

    .line 208
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;->updateTag()V

    .line 209
    return-void
.end method

.method protected loadAndShowImage(Lcom/amazon/ansel/fetch/ImageRequest;)V
    .locals 6
    .param p1, "imageRequest"    # Lcom/amazon/ansel/fetch/ImageRequest;

    .prologue
    .line 128
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;->displayedImage:Lcom/amazon/ansel/fetch/ImageRequest;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;->displayedImage:Lcom/amazon/ansel/fetch/ImageRequest;

    invoke-virtual {v1, p1}, Lcom/amazon/ansel/fetch/ImageRequest;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 170
    :goto_0
    return-void

    .line 133
    :cond_0
    if-eqz p1, :cond_1

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;->displayedImage:Lcom/amazon/ansel/fetch/ImageRequest;

    if-eqz v1, :cond_2

    .line 136
    :cond_1
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;->hideImage()V

    .line 139
    :cond_2
    new-instance v1, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper$1;

    invoke-direct {v1, p0, p1}, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper$1;-><init>(Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;Lcom/amazon/ansel/fetch/ImageRequest;)V

    iput-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;->imageListener:Lcom/amazon/ansel/fetch/ResourceListener;

    .line 160
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;->activeImageRequest:Lcom/amazon/ansel/fetch/ImageRequest;

    .line 162
    new-instance v0, Lcom/amazon/ansel/fetch/ImageLoader;

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;->resourceProvider:Lcom/amazon/ansel/fetch/ResourceProvider;

    invoke-virtual {v1}, Lcom/amazon/ansel/fetch/ResourceProvider;->getContext()Lcom/amazon/ansel/fetch/LoaderContext;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;->imageListener:Lcom/amazon/ansel/fetch/ResourceListener;

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v3

    move-object v5, p1

    invoke-direct/range {v0 .. v5}, Lcom/amazon/ansel/fetch/ImageLoader;-><init>(Lcom/amazon/ansel/fetch/LoaderContext;Lcom/amazon/ansel/fetch/ResourceListener;JLcom/amazon/ansel/fetch/ImageRequest;)V

    .line 169
    .local v0, "loader":Lcom/amazon/ansel/fetch/ImageLoader;
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;->resourceProvider:Lcom/amazon/ansel/fetch/ResourceProvider;

    invoke-virtual {v1, v0}, Lcom/amazon/ansel/fetch/ResourceProvider;->execute(Lcom/amazon/ansel/fetch/ResourceLoader;)V

    goto :goto_0
.end method

.method protected onFinishInflate()V
    .locals 2

    .prologue
    .line 68
    invoke-super {p0}, Landroid/widget/LinearLayout;->onFinishInflate()V

    .line 70
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper$ViewHolder;

    .line 71
    .local v0, "holder":Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper$ViewHolder;
    if-nez v0, :cond_0

    .line 74
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;->postInflate()V

    .line 75
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;->updateTag()V

    .line 83
    :goto_0
    return-void

    .line 80
    :cond_0
    iget-object v1, v0, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper$ViewHolder;->displayedImage:Lcom/amazon/ansel/fetch/ImageRequest;

    iput-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;->displayedImage:Lcom/amazon/ansel/fetch/ImageRequest;

    .line 81
    iget-object v1, v0, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper$ViewHolder;->imageView:Landroid/widget/ImageView;

    iput-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;->imageView:Landroid/widget/ImageView;

    .line 82
    iget-object v1, v0, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper$ViewHolder;->thumbSwitcher:Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;

    iput-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;->thumbSwitcher:Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;

    goto :goto_0
.end method

.method protected abstract postInflate()V
.end method

.method public showImage(Lcom/amazon/ansel/fetch/ImageRequest;Landroid/graphics/Bitmap;)V
    .locals 2
    .param p1, "imageRequestShown"    # Lcom/amazon/ansel/fetch/ImageRequest;
    .param p2, "image"    # Landroid/graphics/Bitmap;

    .prologue
    .line 184
    if-nez p2, :cond_0

    .line 186
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;->hideImage()V

    .line 197
    :goto_0
    return-void

    .line 189
    :cond_0
    invoke-virtual {p2}, Landroid/graphics/Bitmap;->getConfig()Landroid/graphics/Bitmap$Config;

    move-result-object v0

    if-nez v0, :cond_1

    .line 191
    sget-object v0, Landroid/graphics/Bitmap$Config;->ARGB_8888:Landroid/graphics/Bitmap$Config;

    const/4 v1, 0x0

    invoke-virtual {p2, v0, v1}, Landroid/graphics/Bitmap;->copy(Landroid/graphics/Bitmap$Config;Z)Landroid/graphics/Bitmap;

    move-result-object p2

    .line 193
    :cond_1
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;->imageView:Landroid/widget/ImageView;

    invoke-virtual {v0, p2}, Landroid/widget/ImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    .line 195
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;->displayedImage:Lcom/amazon/ansel/fetch/ImageRequest;

    .line 196
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;->updateTag()V

    goto :goto_0
.end method

.method updateTag()V
    .locals 2

    .prologue
    .line 217
    new-instance v0, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper$ViewHolder;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper$ViewHolder;-><init>(Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper$1;)V

    .line 218
    .local v0, "holder":Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper$ViewHolder;
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;->displayedImage:Lcom/amazon/ansel/fetch/ImageRequest;

    iput-object v1, v0, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper$ViewHolder;->displayedImage:Lcom/amazon/ansel/fetch/ImageRequest;

    .line 219
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;->imageView:Landroid/widget/ImageView;

    iput-object v1, v0, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper$ViewHolder;->imageView:Landroid/widget/ImageView;

    .line 220
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;->thumbSwitcher:Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;

    iput-object v1, v0, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper$ViewHolder;->thumbSwitcher:Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;

    .line 221
    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/views/image/ImageWrapper;->setTag(Ljava/lang/Object;)V

    .line 222
    return-void
.end method
