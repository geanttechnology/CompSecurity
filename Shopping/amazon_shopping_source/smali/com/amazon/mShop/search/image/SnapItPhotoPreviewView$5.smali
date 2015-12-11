.class Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView$5;
.super Ljava/lang/Object;
.source "SnapItPhotoPreviewView.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView;-><init>(Lcom/amazon/mShop/search/image/SnapItPhotoPreviewActivity;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView;)V
    .locals 0

    .prologue
    .line 76
    iput-object p1, p0, Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView$5;->this$0:Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 79
    iget-object v1, p0, Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView$5;->this$0:Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView;

    # getter for: Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView;->mActivity:Lcom/amazon/mShop/search/image/SnapItPhotoPreviewActivity;
    invoke-static {v1}, Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView;->access$200(Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView;)Lcom/amazon/mShop/search/image/SnapItPhotoPreviewActivity;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/search/image/SnapItPhotoPreviewActivity;->getLastCapturedPhoto()[B

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/mShop/util/JpegUtils;->jpegToBitmap([B)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 80
    .local v0, "bmp":Landroid/graphics/Bitmap;
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v1

    new-instance v2, Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView$5$1;

    invoke-direct {v2, p0, v0}, Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView$5$1;-><init>(Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView$5;Landroid/graphics/Bitmap;)V

    invoke-interface {v1, v2}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 86
    return-void
.end method
