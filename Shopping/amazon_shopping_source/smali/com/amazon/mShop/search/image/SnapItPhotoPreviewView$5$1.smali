.class Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView$5$1;
.super Ljava/lang/Object;
.source "SnapItPhotoPreviewView.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView$5;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView$5;

.field final synthetic val$bmp:Landroid/graphics/Bitmap;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView$5;Landroid/graphics/Bitmap;)V
    .locals 0

    .prologue
    .line 80
    iput-object p1, p0, Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView$5$1;->this$1:Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView$5;

    iput-object p2, p0, Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView$5$1;->val$bmp:Landroid/graphics/Bitmap;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 83
    iget-object v0, p0, Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView$5$1;->this$1:Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView$5;

    iget-object v0, v0, Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView$5;->this$0:Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView;

    # getter for: Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView;->mPhotoCapturePreview:Landroid/widget/ImageView;
    invoke-static {v0}, Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView;->access$300(Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView;)Landroid/widget/ImageView;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView$5$1;->val$bmp:Landroid/graphics/Bitmap;

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    .line 84
    return-void
.end method
