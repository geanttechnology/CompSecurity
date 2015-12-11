.class public Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView;
.super Landroid/widget/LinearLayout;
.source "SnapItPhotoPreviewView.java"


# instance fields
.field private final mActivity:Lcom/amazon/mShop/search/image/SnapItPhotoPreviewActivity;

.field private mPhotoCapturePreview:Landroid/widget/ImageView;

.field private mRetakeButton:Landroid/widget/ImageButton;

.field private mUseButton:Landroid/widget/ImageButton;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/search/image/SnapItPhotoPreviewActivity;)V
    .locals 3
    .param p1, "activity"    # Lcom/amazon/mShop/search/image/SnapItPhotoPreviewActivity;

    .prologue
    .line 28
    invoke-direct {p0, p1}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    .line 29
    iput-object p1, p0, Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView;->mActivity:Lcom/amazon/mShop/search/image/SnapItPhotoPreviewActivity;

    .line 31
    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    sget v1, Lcom/amazon/mShop/android/lib/R$layout;->snapit_photo_preview:I

    const/4 v2, 0x1

    invoke-virtual {v0, v1, p0, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    .line 33
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->photo_preview_use:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageButton;

    iput-object v0, p0, Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView;->mUseButton:Landroid/widget/ImageButton;

    .line 34
    iget-object v0, p0, Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView;->mUseButton:Landroid/widget/ImageButton;

    new-instance v1, Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView$1;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView$1;-><init>(Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView;)V

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 43
    iget-object v0, p0, Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView;->mUseButton:Landroid/widget/ImageButton;

    new-instance v1, Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView$2;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView$2;-><init>(Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView;)V

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 54
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->photo_preview_retake:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageButton;

    iput-object v0, p0, Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView;->mRetakeButton:Landroid/widget/ImageButton;

    .line 55
    iget-object v0, p0, Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView;->mRetakeButton:Landroid/widget/ImageButton;

    new-instance v1, Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView$3;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView$3;-><init>(Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView;)V

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 63
    iget-object v0, p0, Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView;->mRetakeButton:Landroid/widget/ImageButton;

    new-instance v1, Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView$4;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView$4;-><init>(Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView;)V

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 73
    iget-object v0, p0, Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView;->mUseButton:Landroid/widget/ImageButton;

    invoke-virtual {v0}, Landroid/widget/ImageButton;->requestFocus()Z

    .line 74
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->photo_preview:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView;->mPhotoCapturePreview:Landroid/widget/ImageView;

    .line 76
    new-instance v0, Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView$5;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView$5;-><init>(Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView;)V

    invoke-static {v0}, Lcom/amazon/mShop/util/BitmapUtil;->tryInCaseOfOutOfMemory(Ljava/lang/Runnable;)V

    .line 88
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView;

    .prologue
    .line 20
    invoke-direct {p0}, Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView;->doUsePhoto()V

    return-void
.end method

.method static synthetic access$100(Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView;

    .prologue
    .line 20
    invoke-direct {p0}, Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView;->doRetakePhoto()V

    return-void
.end method

.method static synthetic access$200(Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView;)Lcom/amazon/mShop/search/image/SnapItPhotoPreviewActivity;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView;

    .prologue
    .line 20
    iget-object v0, p0, Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView;->mActivity:Lcom/amazon/mShop/search/image/SnapItPhotoPreviewActivity;

    return-object v0
.end method

.method static synthetic access$300(Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView;)Landroid/widget/ImageView;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView;

    .prologue
    .line 20
    iget-object v0, p0, Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView;->mPhotoCapturePreview:Landroid/widget/ImageView;

    return-object v0
.end method

.method private doRetakePhoto()V
    .locals 1

    .prologue
    .line 104
    iget-object v0, p0, Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView;->mActivity:Lcom/amazon/mShop/search/image/SnapItPhotoPreviewActivity;

    invoke-virtual {v0}, Lcom/amazon/mShop/search/image/SnapItPhotoPreviewActivity;->retakePhoto()V

    .line 105
    return-void
.end method

.method private doUsePhoto()V
    .locals 5

    .prologue
    .line 91
    iget-object v3, p0, Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView;->mPhotoCapturePreview:Landroid/widget/ImageView;

    invoke-virtual {v3}, Landroid/widget/ImageView;->getDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    check-cast v0, Landroid/graphics/drawable/BitmapDrawable;

    .line 95
    .local v0, "bitmapDrawable":Landroid/graphics/drawable/BitmapDrawable;
    if-eqz v0, :cond_0

    .line 96
    invoke-virtual {v0}, Landroid/graphics/drawable/BitmapDrawable;->getBitmap()Landroid/graphics/Bitmap;

    move-result-object v2

    .line 97
    .local v2, "resizedBitmap":Landroid/graphics/Bitmap;
    new-instance v1, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v1}, Ljava/io/ByteArrayOutputStream;-><init>()V

    .line 98
    .local v1, "bos":Ljava/io/ByteArrayOutputStream;
    sget-object v3, Landroid/graphics/Bitmap$CompressFormat;->JPEG:Landroid/graphics/Bitmap$CompressFormat;

    const/16 v4, 0x64

    invoke-virtual {v2, v3, v4, v1}, Landroid/graphics/Bitmap;->compress(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z

    .line 99
    invoke-virtual {v1}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object v3

    invoke-static {v3}, Lcom/amazon/mShop/search/image/SnapItActivity;->setLastPhotoCaptured([B)V

    .line 100
    iget-object v3, p0, Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView;->mActivity:Lcom/amazon/mShop/search/image/SnapItPhotoPreviewActivity;

    invoke-virtual {v3}, Lcom/amazon/mShop/search/image/SnapItPhotoPreviewActivity;->usePhoto()V

    .line 102
    .end local v1    # "bos":Ljava/io/ByteArrayOutputStream;
    .end local v2    # "resizedBitmap":Landroid/graphics/Bitmap;
    :cond_0
    return-void
.end method
