.class Lcom/amazon/mShop/photo/PhotoCaptureView$MyOrientationListener;
.super Landroid/view/OrientationEventListener;
.source "PhotoCaptureView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/photo/PhotoCaptureView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "MyOrientationListener"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/photo/PhotoCaptureView;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/photo/PhotoCaptureView;Lcom/amazon/mShop/photo/PhotoCaptureActivity;)V
    .locals 0
    .param p2, "activity"    # Lcom/amazon/mShop/photo/PhotoCaptureActivity;

    .prologue
    .line 332
    iput-object p1, p0, Lcom/amazon/mShop/photo/PhotoCaptureView$MyOrientationListener;->this$0:Lcom/amazon/mShop/photo/PhotoCaptureView;

    .line 333
    invoke-direct {p0, p2}, Landroid/view/OrientationEventListener;-><init>(Landroid/content/Context;)V

    .line 334
    return-void
.end method


# virtual methods
.method public onOrientationChanged(I)V
    .locals 1
    .param p1, "orientation"    # I

    .prologue
    .line 338
    const/4 v0, -0x1

    if-eq p1, v0, :cond_0

    .line 340
    iget-object v0, p0, Lcom/amazon/mShop/photo/PhotoCaptureView$MyOrientationListener;->this$0:Lcom/amazon/mShop/photo/PhotoCaptureView;

    # setter for: Lcom/amazon/mShop/photo/PhotoCaptureView;->mLastKnownOrientation:I
    invoke-static {v0, p1}, Lcom/amazon/mShop/photo/PhotoCaptureView;->access$402(Lcom/amazon/mShop/photo/PhotoCaptureView;I)I

    .line 342
    :cond_0
    return-void
.end method
