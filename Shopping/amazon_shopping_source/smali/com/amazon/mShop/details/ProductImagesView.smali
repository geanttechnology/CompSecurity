.class public Lcom/amazon/mShop/details/ProductImagesView;
.super Landroid/widget/LinearLayout;
.source "ProductImagesView.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemSelectedListener;
.implements Lcom/amazon/mShop/AmazonActivity$OnConfigurationChangedListener;
.implements Lcom/amazon/mShop/DelayedInitView;
.implements Lcom/amazon/mShop/TitleProvider;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/details/ProductImagesView$MoveAction;,
        Lcom/amazon/mShop/details/ProductImagesView$ScaleListener;,
        Lcom/amazon/mShop/details/ProductImagesView$GestureListener;,
        Lcom/amazon/mShop/details/ProductImagesView$GalleryDelayImages;,
        Lcom/amazon/mShop/details/ProductImagesView$ImageAdapter;
    }
.end annotation


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final amazonActivity:Lcom/amazon/mShop/AmazonActivity;

.field private mGalleryDelayImages:Lcom/amazon/mShop/details/ProductImagesView$GalleryDelayImages;

.field private mGestureDetector:Landroid/view/GestureDetector;

.field private final mImageAdapter:Lcom/amazon/mShop/details/ProductImagesView$ImageAdapter;

.field private final mKeepImageOrder:Z

.field private mLastOrientation:I

.field private mMainGallery:Landroid/widget/Gallery;

.field private mMultiImages:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/MultiImage;",
            ">;"
        }
    .end annotation
.end field

.field private mPinchImage:Lcom/amazon/mShop/details/GalleryPinchImageView;

.field private mProgressBar:Landroid/view/View;

.field private mScaleDetector:Lcom/amazon/mShop/imageview/MShopScaleGestoreDetector$VersionedGestureDetector;

.field private mScrollView:Landroid/widget/HorizontalScrollView;

.field private mStartIndex:I

.field private mThumbnails:Landroid/view/ViewGroup;

.field private mTitle:Ljava/lang/String;

.field private final onTouchListener:Landroid/view/View$OnTouchListener;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 56
    const-class v0, Lcom/amazon/mShop/details/ProductImagesView;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/mShop/details/ProductImagesView;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 75
    invoke-direct {p0, p1, p2}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 71
    const/4 v0, -0x1

    iput v0, p0, Lcom/amazon/mShop/details/ProductImagesView;->mStartIndex:I

    .line 543
    new-instance v0, Lcom/amazon/mShop/details/ProductImagesView$3;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/details/ProductImagesView$3;-><init>(Lcom/amazon/mShop/details/ProductImagesView;)V

    iput-object v0, p0, Lcom/amazon/mShop/details/ProductImagesView;->onTouchListener:Landroid/view/View$OnTouchListener;

    .line 76
    check-cast p1, Lcom/amazon/mShop/AmazonActivity;

    .end local p1    # "context":Landroid/content/Context;
    iput-object p1, p0, Lcom/amazon/mShop/details/ProductImagesView;->amazonActivity:Lcom/amazon/mShop/AmazonActivity;

    .line 77
    new-instance v0, Lcom/amazon/mShop/details/ProductImagesView$ImageAdapter;

    iget-object v1, p0, Lcom/amazon/mShop/details/ProductImagesView;->amazonActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-direct {v0, p0, v1}, Lcom/amazon/mShop/details/ProductImagesView$ImageAdapter;-><init>(Lcom/amazon/mShop/details/ProductImagesView;Lcom/amazon/mShop/AmazonActivity;)V

    iput-object v0, p0, Lcom/amazon/mShop/details/ProductImagesView;->mImageAdapter:Lcom/amazon/mShop/details/ProductImagesView$ImageAdapter;

    .line 78
    new-instance v0, Lcom/amazon/mShop/details/ProductImagesView$GalleryDelayImages;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/details/ProductImagesView$GalleryDelayImages;-><init>(Lcom/amazon/mShop/details/ProductImagesView;)V

    iput-object v0, p0, Lcom/amazon/mShop/details/ProductImagesView;->mGalleryDelayImages:Lcom/amazon/mShop/details/ProductImagesView$GalleryDelayImages;

    .line 79
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/mShop/details/ProductImagesView;->mKeepImageOrder:Z

    .line 80
    return-void
.end method

.method static synthetic access$100(Lcom/amazon/mShop/details/ProductImagesView;)Landroid/widget/Gallery;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/details/ProductImagesView;

    .prologue
    .line 53
    iget-object v0, p0, Lcom/amazon/mShop/details/ProductImagesView;->mMainGallery:Landroid/widget/Gallery;

    return-object v0
.end method

.method static synthetic access$1000(Lcom/amazon/mShop/details/ProductImagesView;Landroid/graphics/drawable/Drawable;Landroid/widget/ImageView;Z)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/details/ProductImagesView;
    .param p1, "x1"    # Landroid/graphics/drawable/Drawable;
    .param p2, "x2"    # Landroid/widget/ImageView;
    .param p3, "x3"    # Z

    .prologue
    .line 53
    invoke-direct {p0, p1, p2, p3}, Lcom/amazon/mShop/details/ProductImagesView;->setDrawableForImageView(Landroid/graphics/drawable/Drawable;Landroid/widget/ImageView;Z)V

    return-void
.end method

.method static synthetic access$1100(Lcom/amazon/mShop/details/ProductImagesView;)Landroid/view/View;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/details/ProductImagesView;

    .prologue
    .line 53
    iget-object v0, p0, Lcom/amazon/mShop/details/ProductImagesView;->mProgressBar:Landroid/view/View;

    return-object v0
.end method

.method static synthetic access$1200(Lcom/amazon/mShop/details/ProductImagesView;)Lcom/amazon/mShop/details/GalleryPinchImageView;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/details/ProductImagesView;

    .prologue
    .line 53
    iget-object v0, p0, Lcom/amazon/mShop/details/ProductImagesView;->mPinchImage:Lcom/amazon/mShop/details/GalleryPinchImageView;

    return-object v0
.end method

.method static synthetic access$1300(Lcom/amazon/mShop/details/ProductImagesView;)Landroid/view/ViewGroup;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/details/ProductImagesView;

    .prologue
    .line 53
    iget-object v0, p0, Lcom/amazon/mShop/details/ProductImagesView;->mThumbnails:Landroid/view/ViewGroup;

    return-object v0
.end method

.method static synthetic access$1500(Lcom/amazon/mShop/details/ProductImagesView;)Z
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/details/ProductImagesView;

    .prologue
    .line 53
    iget-boolean v0, p0, Lcom/amazon/mShop/details/ProductImagesView;->mKeepImageOrder:Z

    return v0
.end method

.method static synthetic access$1600()Ljava/lang/String;
    .locals 1

    .prologue
    .line 53
    sget-object v0, Lcom/amazon/mShop/details/ProductImagesView;->TAG:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$200(Lcom/amazon/mShop/details/ProductImagesView;)Lcom/amazon/mShop/details/ProductImagesView$GalleryDelayImages;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/details/ProductImagesView;

    .prologue
    .line 53
    iget-object v0, p0, Lcom/amazon/mShop/details/ProductImagesView;->mGalleryDelayImages:Lcom/amazon/mShop/details/ProductImagesView$GalleryDelayImages;

    return-object v0
.end method

.method static synthetic access$300(Lcom/amazon/mShop/details/ProductImagesView;Landroid/graphics/drawable/Drawable;I)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/details/ProductImagesView;
    .param p1, "x1"    # Landroid/graphics/drawable/Drawable;
    .param p2, "x2"    # I

    .prologue
    .line 53
    invoke-direct {p0, p1, p2}, Lcom/amazon/mShop/details/ProductImagesView;->addThumbnail(Landroid/graphics/drawable/Drawable;I)V

    return-void
.end method

.method static synthetic access$400(Lcom/amazon/mShop/details/ProductImagesView;)Landroid/view/GestureDetector;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/details/ProductImagesView;

    .prologue
    .line 53
    iget-object v0, p0, Lcom/amazon/mShop/details/ProductImagesView;->mGestureDetector:Landroid/view/GestureDetector;

    return-object v0
.end method

.method static synthetic access$402(Lcom/amazon/mShop/details/ProductImagesView;Landroid/view/GestureDetector;)Landroid/view/GestureDetector;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/details/ProductImagesView;
    .param p1, "x1"    # Landroid/view/GestureDetector;

    .prologue
    .line 53
    iput-object p1, p0, Lcom/amazon/mShop/details/ProductImagesView;->mGestureDetector:Landroid/view/GestureDetector;

    return-object p1
.end method

.method static synthetic access$600(Lcom/amazon/mShop/details/ProductImagesView;)Lcom/amazon/mShop/imageview/MShopScaleGestoreDetector$VersionedGestureDetector;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/details/ProductImagesView;

    .prologue
    .line 53
    iget-object v0, p0, Lcom/amazon/mShop/details/ProductImagesView;->mScaleDetector:Lcom/amazon/mShop/imageview/MShopScaleGestoreDetector$VersionedGestureDetector;

    return-object v0
.end method

.method static synthetic access$602(Lcom/amazon/mShop/details/ProductImagesView;Lcom/amazon/mShop/imageview/MShopScaleGestoreDetector$VersionedGestureDetector;)Lcom/amazon/mShop/imageview/MShopScaleGestoreDetector$VersionedGestureDetector;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/details/ProductImagesView;
    .param p1, "x1"    # Lcom/amazon/mShop/imageview/MShopScaleGestoreDetector$VersionedGestureDetector;

    .prologue
    .line 53
    iput-object p1, p0, Lcom/amazon/mShop/details/ProductImagesView;->mScaleDetector:Lcom/amazon/mShop/imageview/MShopScaleGestoreDetector$VersionedGestureDetector;

    return-object p1
.end method

.method static synthetic access$800(Lcom/amazon/mShop/details/ProductImagesView;)Landroid/view/View$OnTouchListener;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/details/ProductImagesView;

    .prologue
    .line 53
    iget-object v0, p0, Lcom/amazon/mShop/details/ProductImagesView;->onTouchListener:Landroid/view/View$OnTouchListener;

    return-object v0
.end method

.method static synthetic access$900(Lcom/amazon/mShop/details/ProductImagesView;)I
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/details/ProductImagesView;

    .prologue
    .line 53
    iget v0, p0, Lcom/amazon/mShop/details/ProductImagesView;->mStartIndex:I

    return v0
.end method

.method private addThumbnail(Landroid/graphics/drawable/Drawable;I)V
    .locals 7
    .param p1, "drawable"    # Landroid/graphics/drawable/Drawable;
    .param p2, "indexTag"    # I

    .prologue
    const/4 v6, 0x1

    const/4 v5, -0x1

    .line 277
    new-instance v0, Landroid/widget/ImageView;

    invoke-virtual {p0}, Lcom/amazon/mShop/details/ProductImagesView;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-direct {v0, v3}, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V

    .line 278
    .local v0, "img":Landroid/widget/ImageView;
    new-instance v2, Landroid/widget/LinearLayout$LayoutParams;

    invoke-direct {v2, v5, v5}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    .line 279
    .local v2, "params":Landroid/widget/LinearLayout$LayoutParams;
    invoke-virtual {p0}, Lcom/amazon/mShop/details/ProductImagesView;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    sget v4, Lcom/amazon/mShop/android/lib/R$dimen;->carousel_list_item_underline_height:I

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getDimension(I)F

    move-result v3

    float-to-int v3, v3

    iput v3, v2, Landroid/widget/LinearLayout$LayoutParams;->bottomMargin:I

    .line 280
    invoke-virtual {v0, v2}, Landroid/widget/ImageView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 282
    invoke-direct {p0, p1, v0, v6}, Lcom/amazon/mShop/details/ProductImagesView;->setDrawableForImageView(Landroid/graphics/drawable/Drawable;Landroid/widget/ImageView;Z)V

    .line 287
    new-instance v1, Landroid/widget/LinearLayout;

    invoke-virtual {p0}, Lcom/amazon/mShop/details/ProductImagesView;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-direct {v1, v3}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    .line 288
    .local v1, "linearLayout":Landroid/widget/LinearLayout;
    sget v3, Lcom/amazon/mShop/android/lib/R$color;->product_detail_gallery_image_selector:I

    invoke-virtual {v1, v3}, Landroid/widget/LinearLayout;->setBackgroundResource(I)V

    .line 289
    new-instance v3, Landroid/widget/LinearLayout$LayoutParams;

    const/4 v4, -0x2

    invoke-direct {v3, v4, v5}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    invoke-virtual {v1, v3}, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 290
    invoke-virtual {v1, v0}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 292
    invoke-virtual {v1, v6}, Landroid/widget/LinearLayout;->setFocusable(Z)V

    .line 293
    invoke-virtual {v1, v6}, Landroid/widget/LinearLayout;->setClickable(Z)V

    .line 294
    new-instance v3, Lcom/amazon/mShop/details/ProductImagesView$2;

    invoke-direct {v3, p0}, Lcom/amazon/mShop/details/ProductImagesView$2;-><init>(Lcom/amazon/mShop/details/ProductImagesView;)V

    invoke-virtual {v1, v3}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 321
    iget-boolean v3, p0, Lcom/amazon/mShop/details/ProductImagesView;->mKeepImageOrder:Z

    if-eqz v3, :cond_0

    iget-object v3, p0, Lcom/amazon/mShop/details/ProductImagesView;->mThumbnails:Landroid/view/ViewGroup;

    invoke-virtual {v3}, Landroid/view/ViewGroup;->getChildCount()I

    move-result v3

    if-gt v3, p2, :cond_1

    .line 322
    :cond_0
    iget-object v3, p0, Lcom/amazon/mShop/details/ProductImagesView;->mThumbnails:Landroid/view/ViewGroup;

    invoke-virtual {v3, v1}, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V

    .line 327
    :goto_0
    return-void

    .line 324
    :cond_1
    iget-object v3, p0, Lcom/amazon/mShop/details/ProductImagesView;->mThumbnails:Landroid/view/ViewGroup;

    invoke-virtual {v3, p2}, Landroid/view/ViewGroup;->removeViewAt(I)V

    .line 325
    iget-object v3, p0, Lcom/amazon/mShop/details/ProductImagesView;->mThumbnails:Landroid/view/ViewGroup;

    invoke-virtual {v3, v1, p2}, Landroid/view/ViewGroup;->addView(Landroid/view/View;I)V

    goto :goto_0
.end method

.method private cloneMultiImages(Ljava/util/List;)Ljava/util/List;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/MultiImage;",
            ">;)",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/MultiImage;",
            ">;"
        }
    .end annotation

    .prologue
    .line 142
    .local p1, "multiImages":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/MultiImage;>;"
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 143
    .local v1, "cloneList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/MultiImage;>;"
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/amazon/rio/j2me/client/services/mShop/MultiImage;

    .line 144
    .local v3, "image":Lcom/amazon/rio/j2me/client/services/mShop/MultiImage;
    new-instance v0, Lcom/amazon/rio/j2me/client/services/mShop/MultiImage;

    invoke-direct {v0}, Lcom/amazon/rio/j2me/client/services/mShop/MultiImage;-><init>()V

    .local v0, "cloneImage":Lcom/amazon/rio/j2me/client/services/mShop/MultiImage;
    move-object v4, v3

    .line 145
    check-cast v4, Lcom/amazon/rio/j2me/client/services/mShop/MultiImage;

    invoke-virtual {v4}, Lcom/amazon/rio/j2me/client/services/mShop/MultiImage;->getStandardUrl()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v4}, Lcom/amazon/rio/j2me/client/services/mShop/MultiImage;->setStandardUrl(Ljava/lang/String;)V

    .line 146
    check-cast v3, Lcom/amazon/rio/j2me/client/services/mShop/MultiImage;

    .end local v3    # "image":Lcom/amazon/rio/j2me/client/services/mShop/MultiImage;
    invoke-virtual {v3}, Lcom/amazon/rio/j2me/client/services/mShop/MultiImage;->getHiresUrl()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v4}, Lcom/amazon/rio/j2me/client/services/mShop/MultiImage;->setHiresUrl(Ljava/lang/String;)V

    .line 147
    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 149
    .end local v0    # "cloneImage":Lcom/amazon/rio/j2me/client/services/mShop/MultiImage;
    :cond_0
    return-object v1
.end method

.method private setDrawableForImageView(Landroid/graphics/drawable/Drawable;Landroid/widget/ImageView;Z)V
    .locals 14
    .param p1, "drawable"    # Landroid/graphics/drawable/Drawable;
    .param p2, "img"    # Landroid/widget/ImageView;
    .param p3, "isThumbnail"    # Z

    .prologue
    .line 335
    const/4 v1, 0x0

    .line 336
    .local v1, "bitmap":Landroid/graphics/Bitmap;
    if-eqz p3, :cond_0

    .line 338
    :try_start_0
    instance-of v11, p1, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable;

    if-eqz v11, :cond_1

    .line 339
    move-object v0, p1

    check-cast v0, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable;

    move-object v2, v0

    .line 340
    .local v2, "bitmapDrawable":Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable;
    invoke-virtual {v2}, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable;->getBitmap()Landroid/graphics/Bitmap;

    move-result-object v1

    .line 341
    invoke-virtual {v1}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v11

    div-int/lit8 v11, v11, 0x8

    invoke-virtual {v1}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v12

    div-int/lit8 v12, v12, 0x8

    const/4 v13, 0x0

    invoke-static {v1, v11, v12, v13}, Landroid/graphics/Bitmap;->createScaledBitmap(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;

    move-result-object v1

    .line 342
    new-instance v4, Landroid/graphics/drawable/BitmapDrawable;

    invoke-virtual {p0}, Lcom/amazon/mShop/details/ProductImagesView;->getResources()Landroid/content/res/Resources;

    move-result-object v11

    invoke-direct {v4, v11, v1}, Landroid/graphics/drawable/BitmapDrawable;-><init>(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V

    .end local p1    # "drawable":Landroid/graphics/drawable/Drawable;
    .local v4, "drawable":Landroid/graphics/drawable/Drawable;
    move-object p1, v4

    .line 352
    .end local v2    # "bitmapDrawable":Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable;
    .end local v4    # "drawable":Landroid/graphics/drawable/Drawable;
    .restart local p1    # "drawable":Landroid/graphics/drawable/Drawable;
    :cond_0
    :goto_0
    sget-object v11, Landroid/widget/ImageView$ScaleType;->CENTER_INSIDE:Landroid/widget/ImageView$ScaleType;

    move-object/from16 v0, p2

    invoke-virtual {v0, v11}, Landroid/widget/ImageView;->setScaleType(Landroid/widget/ImageView$ScaleType;)V

    .line 353
    move-object/from16 v0, p2

    invoke-virtual {v0, p1}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 355
    if-eqz p3, :cond_2

    if-eqz v1, :cond_2

    .line 356
    invoke-virtual {p0}, Lcom/amazon/mShop/details/ProductImagesView;->getResources()Landroid/content/res/Resources;

    move-result-object v11

    sget v12, Lcom/amazon/mShop/android/lib/R$dimen;->padding_smallest:I

    invoke-virtual {v11, v12}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v6

    .line 357
    .local v6, "extraDimension":I
    invoke-virtual {v1}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v11

    invoke-virtual {v1}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v12

    invoke-static {v11, v12}, Ljava/lang/Math;->max(II)I

    move-result v7

    .line 358
    .local v7, "maxDimension":I
    invoke-virtual {v1}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v11

    sub-int v11, v7, v11

    div-int/lit8 v11, v11, 0x2

    add-int v9, v11, v6

    .line 359
    .local v9, "paddingLeftRight":I
    invoke-virtual {v1}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v11

    sub-int v11, v7, v11

    div-int/lit8 v11, v11, 0x2

    add-int v10, v11, v6

    .line 360
    .local v10, "paddingTopBottom":I
    move-object/from16 v0, p2

    invoke-virtual {v0, v9, v10, v9, v10}, Landroid/widget/ImageView;->setPadding(IIII)V

    .line 372
    .end local v6    # "extraDimension":I
    .end local v7    # "maxDimension":I
    .end local v9    # "paddingLeftRight":I
    .end local v10    # "paddingTopBottom":I
    :goto_1
    return-void

    .line 343
    :cond_1
    instance-of v11, p1, Landroid/graphics/drawable/BitmapDrawable;

    if-eqz v11, :cond_0

    .line 345
    move-object v0, p1

    check-cast v0, Landroid/graphics/drawable/BitmapDrawable;

    move-object v3, v0

    .line 346
    .local v3, "bmDrawable":Landroid/graphics/drawable/BitmapDrawable;
    invoke-virtual {v3}, Landroid/graphics/drawable/BitmapDrawable;->getBitmap()Landroid/graphics/Bitmap;

    move-result-object v1

    .line 347
    invoke-virtual {v1}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v11

    div-int/lit8 v11, v11, 0x8

    invoke-virtual {v1}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v12

    div-int/lit8 v12, v12, 0x8

    const/4 v13, 0x0

    invoke-static {v1, v11, v12, v13}, Landroid/graphics/Bitmap;->createScaledBitmap(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;

    move-result-object v1

    .line 348
    new-instance v4, Landroid/graphics/drawable/BitmapDrawable;

    invoke-virtual {p0}, Lcom/amazon/mShop/details/ProductImagesView;->getResources()Landroid/content/res/Resources;

    move-result-object v11

    invoke-direct {v4, v11, v1}, Landroid/graphics/drawable/BitmapDrawable;-><init>(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V

    .end local p1    # "drawable":Landroid/graphics/drawable/Drawable;
    .restart local v4    # "drawable":Landroid/graphics/drawable/Drawable;
    move-object p1, v4

    .end local v4    # "drawable":Landroid/graphics/drawable/Drawable;
    .restart local p1    # "drawable":Landroid/graphics/drawable/Drawable;
    goto :goto_0

    .line 362
    .end local v3    # "bmDrawable":Landroid/graphics/drawable/BitmapDrawable;
    :cond_2
    invoke-virtual {p0}, Lcom/amazon/mShop/details/ProductImagesView;->getResources()Landroid/content/res/Resources;

    move-result-object v11

    sget v12, Lcom/amazon/mShop/android/lib/R$dimen;->product_gallery_images_padding:I

    invoke-virtual {v11, v12}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v8

    .line 363
    .local v8, "padding":I
    const/4 v11, 0x0

    const/4 v12, 0x0

    move-object/from16 v0, p2

    invoke-virtual {v0, v8, v11, v8, v12}, Landroid/widget/ImageView;->setPadding(IIII)V
    :try_end_0
    .catch Ljava/lang/OutOfMemoryError; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    .line 366
    .end local v8    # "padding":I
    :catch_0
    move-exception v5

    .line 367
    .local v5, "e":Ljava/lang/OutOfMemoryError;
    const-string/jumbo v11, "AmazonActivity"

    new-instance v12, Ljava/lang/StringBuilder;

    invoke-direct {v12}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v13, "could not decode image: "

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    invoke-static {v11, v12}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 368
    invoke-static {}, Lcom/amazon/mShop/ui/DrawableFactory;->getInstance()Lcom/amazon/mShop/ui/DrawableFactory$DrawableFactoryInterface;

    move-result-object v11

    invoke-virtual {p0}, Lcom/amazon/mShop/details/ProductImagesView;->getResources()Landroid/content/res/Resources;

    move-result-object v12

    invoke-interface {v11, v12}, Lcom/amazon/mShop/ui/DrawableFactory$DrawableFactoryInterface;->getDefaultDrawable(Landroid/content/res/Resources;)Landroid/graphics/drawable/Drawable;

    move-result-object v11

    move-object/from16 v0, p2

    invoke-virtual {v0, v11}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 369
    const/4 v11, 0x0

    move-object/from16 v0, p2

    invoke-virtual {v0, v11}, Landroid/widget/ImageView;->setTag(Ljava/lang/Object;)V

    goto :goto_1
.end method

.method private setProductImages(Ljava/util/List;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/MultiImage;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 131
    .local p1, "multiImages":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/MultiImage;>;"
    const/4 v0, 0x0

    const/4 v1, 0x0

    invoke-direct {p0, p1, v0, v1}, Lcom/amazon/mShop/details/ProductImagesView;->setProductImages(Ljava/util/List;Ljava/lang/String;I)V

    .line 132
    return-void
.end method

.method private setProductImages(Ljava/util/List;Ljava/lang/String;I)V
    .locals 2
    .param p2, "previewImageUrl"    # Ljava/lang/String;
    .param p3, "previewImageDimension"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/MultiImage;",
            ">;",
            "Ljava/lang/String;",
            "I)V"
        }
    .end annotation

    .prologue
    .line 136
    .local p1, "multiImages":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/MultiImage;>;"
    invoke-direct {p0, p1}, Lcom/amazon/mShop/details/ProductImagesView;->cloneMultiImages(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/details/ProductImagesView;->mMultiImages:Ljava/util/List;

    .line 137
    iget-object v0, p0, Lcom/amazon/mShop/details/ProductImagesView;->mGalleryDelayImages:Lcom/amazon/mShop/details/ProductImagesView$GalleryDelayImages;

    iget-object v1, p0, Lcom/amazon/mShop/details/ProductImagesView;->mImageAdapter:Lcom/amazon/mShop/details/ProductImagesView$ImageAdapter;

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/details/ProductImagesView$GalleryDelayImages;->addGalleryImageItemsListener(Lcom/amazon/mShop/details/ProductImagesView$ImageAdapter;)V

    .line 138
    iget-object v0, p0, Lcom/amazon/mShop/details/ProductImagesView;->mGalleryDelayImages:Lcom/amazon/mShop/details/ProductImagesView$GalleryDelayImages;

    iget-object v1, p0, Lcom/amazon/mShop/details/ProductImagesView;->mMultiImages:Ljava/util/List;

    invoke-virtual {v0, v1, p2, p3}, Lcom/amazon/mShop/details/ProductImagesView$GalleryDelayImages;->setMultiImages(Ljava/util/List;Ljava/lang/String;I)V

    .line 139
    return-void
.end method


# virtual methods
.method public bridge synthetic getTitle()Ljava/lang/CharSequence;
    .locals 1

    .prologue
    .line 53
    invoke-virtual {p0}, Lcom/amazon/mShop/details/ProductImagesView;->getTitle()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 3

    .prologue
    .line 405
    iget-object v0, p0, Lcom/amazon/mShop/details/ProductImagesView;->mTitle:Ljava/lang/String;

    .line 406
    .local v0, "title":Ljava/lang/String;
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 407
    invoke-virtual {p0}, Lcom/amazon/mShop/details/ProductImagesView;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->product_details:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 409
    :cond_0
    return-object v0
.end method

.method public handleConfigurationChanged(Landroid/content/res/Configuration;)V
    .locals 3
    .param p1, "newConfig"    # Landroid/content/res/Configuration;

    .prologue
    const/4 v2, 0x0

    .line 387
    const/4 v0, 0x2

    iget v1, p1, Landroid/content/res/Configuration;->orientation:I

    if-ne v0, v1, :cond_1

    .line 388
    iget-object v0, p0, Lcom/amazon/mShop/details/ProductImagesView;->mThumbnails:Landroid/view/ViewGroup;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 392
    :goto_0
    iget v0, p0, Lcom/amazon/mShop/details/ProductImagesView;->mLastOrientation:I

    iget v1, p1, Landroid/content/res/Configuration;->orientation:I

    if-eq v0, v1, :cond_0

    .line 393
    iget-object v0, p0, Lcom/amazon/mShop/details/ProductImagesView;->mPinchImage:Lcom/amazon/mShop/details/GalleryPinchImageView;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/details/ProductImagesView;->mPinchImage:Lcom/amazon/mShop/details/GalleryPinchImageView;

    invoke-virtual {v0}, Lcom/amazon/mShop/details/GalleryPinchImageView;->getVisibility()I

    move-result v0

    if-nez v0, :cond_0

    .line 394
    iget-object v0, p0, Lcom/amazon/mShop/details/ProductImagesView;->mMainGallery:Landroid/widget/Gallery;

    invoke-virtual {v0, v2}, Landroid/widget/Gallery;->setVisibility(I)V

    .line 395
    iget-object v0, p0, Lcom/amazon/mShop/details/ProductImagesView;->mPinchImage:Lcom/amazon/mShop/details/GalleryPinchImageView;

    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/details/GalleryPinchImageView;->setVisibility(I)V

    .line 396
    iget-object v0, p0, Lcom/amazon/mShop/details/ProductImagesView;->mPinchImage:Lcom/amazon/mShop/details/GalleryPinchImageView;

    invoke-virtual {v0}, Lcom/amazon/mShop/details/GalleryPinchImageView;->clear()V

    .line 400
    :cond_0
    iget v0, p1, Landroid/content/res/Configuration;->orientation:I

    iput v0, p0, Lcom/amazon/mShop/details/ProductImagesView;->mLastOrientation:I

    .line 401
    return-void

    .line 390
    :cond_1
    iget-object v0, p0, Lcom/amazon/mShop/details/ProductImagesView;->mThumbnails:Landroid/view/ViewGroup;

    invoke-virtual {v0, v2}, Landroid/view/ViewGroup;->setVisibility(I)V

    goto :goto_0
.end method

.method protected onAttachedToWindow()V
    .locals 1

    .prologue
    .line 171
    invoke-super {p0}, Landroid/widget/LinearLayout;->onAttachedToWindow()V

    .line 172
    iget-object v0, p0, Lcom/amazon/mShop/details/ProductImagesView;->amazonActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-virtual {v0, p0}, Lcom/amazon/mShop/AmazonActivity;->registerConfigChangedListener(Lcom/amazon/mShop/AmazonActivity$OnConfigurationChangedListener;)V

    .line 174
    return-void
.end method

.method protected onDetachedFromWindow()V
    .locals 1

    .prologue
    .line 165
    invoke-super {p0}, Landroid/widget/LinearLayout;->onDetachedFromWindow()V

    .line 166
    iget-object v0, p0, Lcom/amazon/mShop/details/ProductImagesView;->amazonActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-virtual {v0, p0}, Lcom/amazon/mShop/AmazonActivity;->unregisterConfigChangedListener(Lcom/amazon/mShop/AmazonActivity$OnConfigurationChangedListener;)V

    .line 167
    return-void
.end method

.method protected onFinishInflate()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 88
    invoke-super {p0}, Landroid/widget/LinearLayout;->onFinishInflate()V

    .line 89
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->images:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/details/ProductImagesView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Gallery;

    iput-object v0, p0, Lcom/amazon/mShop/details/ProductImagesView;->mMainGallery:Landroid/widget/Gallery;

    .line 90
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->product_images_group:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/details/ProductImagesView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    iput-object v0, p0, Lcom/amazon/mShop/details/ProductImagesView;->mThumbnails:Landroid/view/ViewGroup;

    .line 91
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->product_images_view_progressbar:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/details/ProductImagesView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/details/ProductImagesView;->mProgressBar:Landroid/view/View;

    .line 92
    iget-object v0, p0, Lcom/amazon/mShop/details/ProductImagesView;->amazonActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-virtual {v0}, Lcom/amazon/mShop/AmazonActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/details/ProductImagesView;->handleConfigurationChanged(Landroid/content/res/Configuration;)V

    .line 95
    iget-object v0, p0, Lcom/amazon/mShop/details/ProductImagesView;->mMainGallery:Landroid/widget/Gallery;

    invoke-virtual {v0, v2}, Landroid/widget/Gallery;->setHapticFeedbackEnabled(Z)V

    .line 96
    iget-object v0, p0, Lcom/amazon/mShop/details/ProductImagesView;->mMainGallery:Landroid/widget/Gallery;

    invoke-virtual {v0, v2}, Landroid/widget/Gallery;->setSoundEffectsEnabled(Z)V

    .line 97
    iget-object v0, p0, Lcom/amazon/mShop/details/ProductImagesView;->mMainGallery:Landroid/widget/Gallery;

    iget-object v1, p0, Lcom/amazon/mShop/details/ProductImagesView;->mImageAdapter:Lcom/amazon/mShop/details/ProductImagesView$ImageAdapter;

    invoke-virtual {v0, v1}, Landroid/widget/Gallery;->setAdapter(Landroid/widget/SpinnerAdapter;)V

    .line 98
    iget-object v0, p0, Lcom/amazon/mShop/details/ProductImagesView;->mMainGallery:Landroid/widget/Gallery;

    invoke-virtual {v0, p0}, Landroid/widget/Gallery;->setOnItemSelectedListener(Landroid/widget/AdapterView$OnItemSelectedListener;)V

    .line 101
    iget-object v0, p0, Lcom/amazon/mShop/details/ProductImagesView;->mMainGallery:Landroid/widget/Gallery;

    check-cast v0, Lcom/amazon/mShop/details/CustomizedGallery;

    invoke-virtual {v0, v2}, Lcom/amazon/mShop/details/CustomizedGallery;->setCallbackDuringFling(Z)V

    .line 102
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->pinch_image:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/details/ProductImagesView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/details/GalleryPinchImageView;

    iput-object v0, p0, Lcom/amazon/mShop/details/ProductImagesView;->mPinchImage:Lcom/amazon/mShop/details/GalleryPinchImageView;

    .line 103
    iget-object v0, p0, Lcom/amazon/mShop/details/ProductImagesView;->mPinchImage:Lcom/amazon/mShop/details/GalleryPinchImageView;

    iget-object v1, p0, Lcom/amazon/mShop/details/ProductImagesView;->mMainGallery:Landroid/widget/Gallery;

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/details/GalleryPinchImageView;->setGallery(Landroid/widget/Gallery;)V

    .line 104
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->product_images_group_container:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/details/ProductImagesView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/HorizontalScrollView;

    iput-object v0, p0, Lcom/amazon/mShop/details/ProductImagesView;->mScrollView:Landroid/widget/HorizontalScrollView;

    .line 106
    return-void
.end method

.method public onItemSelected(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 4
    .param p2, "v"    # Landroid/view/View;
    .param p3, "position"    # I
    .param p4, "id"    # J
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
    .line 183
    .local p1, "parent":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    iget-object v0, p0, Lcom/amazon/mShop/details/ProductImagesView;->mMainGallery:Landroid/widget/Gallery;

    new-instance v1, Lcom/amazon/mShop/details/ProductImagesView$1;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/details/ProductImagesView$1;-><init>(Lcom/amazon/mShop/details/ProductImagesView;)V

    const-wide/16 v2, 0xfa

    invoke-virtual {v0, v1, v2, v3}, Landroid/widget/Gallery;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 190
    iget-object v0, p0, Lcom/amazon/mShop/details/ProductImagesView;->mMainGallery:Landroid/widget/Gallery;

    check-cast v0, Lcom/amazon/mShop/details/CustomizedGallery;

    invoke-virtual {v0}, Lcom/amazon/mShop/details/CustomizedGallery;->logImageViewedRefMarker()V

    .line 191
    return-void
.end method

.method public onNothingSelected(Landroid/widget/AdapterView;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView",
            "<*>;)V"
        }
    .end annotation

    .prologue
    .line 195
    .local p1, "parent":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    return-void
.end method

.method public onPushViewCompleted()V
    .locals 2

    .prologue
    .line 157
    iget-object v0, p0, Lcom/amazon/mShop/details/ProductImagesView;->mGalleryDelayImages:Lcom/amazon/mShop/details/ProductImagesView$GalleryDelayImages;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/details/ProductImagesView;->mGalleryDelayImages:Lcom/amazon/mShop/details/ProductImagesView$GalleryDelayImages;

    # getter for: Lcom/amazon/mShop/details/ProductImagesView$GalleryDelayImages;->mImages:Ljava/util/List;
    invoke-static {v0}, Lcom/amazon/mShop/details/ProductImagesView$GalleryDelayImages;->access$000(Lcom/amazon/mShop/details/ProductImagesView$GalleryDelayImages;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-nez v0, :cond_0

    .line 158
    iget-object v0, p0, Lcom/amazon/mShop/details/ProductImagesView;->mMainGallery:Landroid/widget/Gallery;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/Gallery;->setVisibility(I)V

    .line 159
    iget-object v0, p0, Lcom/amazon/mShop/details/ProductImagesView;->mProgressBar:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 161
    :cond_0
    return-void
.end method

.method public setImagesAndTitle(Ljava/lang/String;Ljava/util/List;)V
    .locals 0
    .param p1, "title"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/MultiImage;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 125
    .local p2, "multiImages":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/MultiImage;>;"
    iput-object p1, p0, Lcom/amazon/mShop/details/ProductImagesView;->mTitle:Ljava/lang/String;

    .line 126
    invoke-direct {p0, p2}, Lcom/amazon/mShop/details/ProductImagesView;->setProductImages(Ljava/util/List;)V

    .line 127
    return-void
.end method

.method public setProductController(Lcom/amazon/mShop/control/item/ProductController;)V
    .locals 3
    .param p1, "productController"    # Lcom/amazon/mShop/control/item/ProductController;

    .prologue
    .line 115
    invoke-virtual {p1}, Lcom/amazon/mShop/control/item/ProductController;->getTitle()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/details/ProductImagesView;->mTitle:Ljava/lang/String;

    .line 116
    invoke-virtual {p1}, Lcom/amazon/mShop/control/item/ProductController;->getMultiImages()Ljava/util/List;

    move-result-object v0

    invoke-virtual {p1}, Lcom/amazon/mShop/control/item/ProductController;->getImageUrl()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1}, Lcom/amazon/mShop/control/item/ProductController;->getMaxImageDimension()I

    move-result v2

    invoke-direct {p0, v0, v1, v2}, Lcom/amazon/mShop/details/ProductImagesView;->setProductImages(Ljava/util/List;Ljava/lang/String;I)V

    .line 117
    return-void
.end method

.method public setSelectedState(ILcom/amazon/mShop/details/ProductImagesView$MoveAction;)V
    .locals 1
    .param p1, "position"    # I
    .param p2, "action"    # Lcom/amazon/mShop/details/ProductImagesView$MoveAction;

    .prologue
    .line 626
    iget-object v0, p0, Lcom/amazon/mShop/details/ProductImagesView;->mThumbnails:Landroid/view/ViewGroup;

    invoke-virtual {v0, p1}, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {p0, v0, p2}, Lcom/amazon/mShop/details/ProductImagesView;->setSelectedState(Landroid/view/View;Lcom/amazon/mShop/details/ProductImagesView$MoveAction;)V

    .line 627
    return-void
.end method

.method public setSelectedState(Landroid/view/View;Lcom/amazon/mShop/details/ProductImagesView$MoveAction;)V
    .locals 5
    .param p1, "viewToBeSelected"    # Landroid/view/View;
    .param p2, "action"    # Lcom/amazon/mShop/details/ProductImagesView$MoveAction;

    .prologue
    const/4 v4, 0x0

    .line 630
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    iget-object v2, p0, Lcom/amazon/mShop/details/ProductImagesView;->mThumbnails:Landroid/view/ViewGroup;

    invoke-virtual {v2}, Landroid/view/ViewGroup;->getChildCount()I

    move-result v2

    if-ge v0, v2, :cond_1

    .line 631
    iget-object v2, p0, Lcom/amazon/mShop/details/ProductImagesView;->mThumbnails:Landroid/view/ViewGroup;

    invoke-virtual {v2, v0}, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    invoke-virtual {v2}, Landroid/view/View;->isSelected()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 632
    iget-object v2, p0, Lcom/amazon/mShop/details/ProductImagesView;->mThumbnails:Landroid/view/ViewGroup;

    invoke-virtual {v2, v0}, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    invoke-virtual {v2, v4}, Landroid/view/View;->setSelected(Z)V

    .line 630
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 635
    :cond_1
    if-eqz p1, :cond_3

    .line 636
    const/4 v2, 0x1

    invoke-virtual {p1, v2}, Landroid/view/View;->setSelected(Z)V

    .line 637
    new-instance v1, Landroid/graphics/Rect;

    invoke-direct {v1}, Landroid/graphics/Rect;-><init>()V

    .line 638
    .local v1, "rect":Landroid/graphics/Rect;
    invoke-virtual {p1, v1}, Landroid/view/View;->getLocalVisibleRect(Landroid/graphics/Rect;)Z

    .line 639
    sget-object v2, Lcom/amazon/mShop/details/ProductImagesView$MoveAction;->LEFT:Lcom/amazon/mShop/details/ProductImagesView$MoveAction;

    if-ne p2, v2, :cond_4

    iget v2, v1, Landroid/graphics/Rect;->right:I

    iget v3, v1, Landroid/graphics/Rect;->left:I

    sub-int/2addr v2, v3

    invoke-virtual {p1}, Landroid/view/View;->getWidth()I

    move-result v3

    if-lt v2, v3, :cond_2

    iget v2, v1, Landroid/graphics/Rect;->left:I

    if-gez v2, :cond_4

    .line 640
    :cond_2
    iget-object v2, p0, Lcom/amazon/mShop/details/ProductImagesView;->mScrollView:Landroid/widget/HorizontalScrollView;

    invoke-virtual {p1}, Landroid/view/View;->getWidth()I

    move-result v3

    neg-int v3, v3

    invoke-virtual {v2, v3, v4}, Landroid/widget/HorizontalScrollView;->scrollBy(II)V

    .line 646
    .end local v1    # "rect":Landroid/graphics/Rect;
    :cond_3
    :goto_1
    return-void

    .line 641
    .restart local v1    # "rect":Landroid/graphics/Rect;
    :cond_4
    sget-object v2, Lcom/amazon/mShop/details/ProductImagesView$MoveAction;->RIGHT:Lcom/amazon/mShop/details/ProductImagesView$MoveAction;

    if-ne p2, v2, :cond_3

    iget v2, v1, Landroid/graphics/Rect;->right:I

    iget v3, v1, Landroid/graphics/Rect;->left:I

    sub-int/2addr v2, v3

    invoke-virtual {p1}, Landroid/view/View;->getWidth()I

    move-result v3

    if-ge v2, v3, :cond_3

    .line 642
    iget-object v2, p0, Lcom/amazon/mShop/details/ProductImagesView;->mScrollView:Landroid/widget/HorizontalScrollView;

    invoke-virtual {p1}, Landroid/view/View;->getWidth()I

    move-result v3

    invoke-virtual {v2, v3, v4}, Landroid/widget/HorizontalScrollView;->scrollBy(II)V

    goto :goto_1
.end method

.method public setStartIndex(I)V
    .locals 0
    .param p1, "startIndex"    # I

    .prologue
    .line 83
    iput p1, p0, Lcom/amazon/mShop/details/ProductImagesView;->mStartIndex:I

    .line 84
    return-void
.end method
