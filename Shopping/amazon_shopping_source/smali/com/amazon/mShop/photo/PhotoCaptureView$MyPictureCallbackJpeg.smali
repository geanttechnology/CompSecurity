.class Lcom/amazon/mShop/photo/PhotoCaptureView$MyPictureCallbackJpeg;
.super Ljava/lang/Object;
.source "PhotoCaptureView.java"

# interfaces
.implements Landroid/hardware/Camera$PictureCallback;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/photo/PhotoCaptureView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "MyPictureCallbackJpeg"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/photo/PhotoCaptureView;


# direct methods
.method private constructor <init>(Lcom/amazon/mShop/photo/PhotoCaptureView;)V
    .locals 0

    .prologue
    .line 307
    iput-object p1, p0, Lcom/amazon/mShop/photo/PhotoCaptureView$MyPictureCallbackJpeg;->this$0:Lcom/amazon/mShop/photo/PhotoCaptureView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/mShop/photo/PhotoCaptureView;Lcom/amazon/mShop/photo/PhotoCaptureView$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/mShop/photo/PhotoCaptureView;
    .param p2, "x1"    # Lcom/amazon/mShop/photo/PhotoCaptureView$1;

    .prologue
    .line 307
    invoke-direct {p0, p1}, Lcom/amazon/mShop/photo/PhotoCaptureView$MyPictureCallbackJpeg;-><init>(Lcom/amazon/mShop/photo/PhotoCaptureView;)V

    return-void
.end method


# virtual methods
.method public onPictureTaken([BLandroid/hardware/Camera;)V
    .locals 2
    .param p1, "data"    # [B
    .param p2, "camera"    # Landroid/hardware/Camera;

    .prologue
    .line 310
    iget-object v0, p0, Lcom/amazon/mShop/photo/PhotoCaptureView$MyPictureCallbackJpeg;->this$0:Lcom/amazon/mShop/photo/PhotoCaptureView;

    # getter for: Lcom/amazon/mShop/photo/PhotoCaptureView;->mPhotoCaptureActivity:Lcom/amazon/mShop/photo/PhotoCaptureActivity;
    invoke-static {v0}, Lcom/amazon/mShop/photo/PhotoCaptureView;->access$500(Lcom/amazon/mShop/photo/PhotoCaptureView;)Lcom/amazon/mShop/photo/PhotoCaptureActivity;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/photo/PhotoCaptureView$MyPictureCallbackJpeg;->this$0:Lcom/amazon/mShop/photo/PhotoCaptureView;

    # getter for: Lcom/amazon/mShop/photo/PhotoCaptureView;->mLastKnownOrientation:I
    invoke-static {v1}, Lcom/amazon/mShop/photo/PhotoCaptureView;->access$400(Lcom/amazon/mShop/photo/PhotoCaptureView;)I

    move-result v1

    invoke-virtual {v0, p1, v1}, Lcom/amazon/mShop/photo/PhotoCaptureActivity;->handlePhotoTaken([BI)V

    .line 311
    return-void
.end method
