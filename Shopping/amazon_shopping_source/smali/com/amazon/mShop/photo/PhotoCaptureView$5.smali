.class Lcom/amazon/mShop/photo/PhotoCaptureView$5;
.super Ljava/lang/Object;
.source "PhotoCaptureView.java"

# interfaces
.implements Landroid/hardware/Camera$AutoFocusCallback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/photo/PhotoCaptureView;->doAutoFocus(Z)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/photo/PhotoCaptureView;

.field final synthetic val$needTakePhotoAfterAutoFocus:Z


# direct methods
.method constructor <init>(Lcom/amazon/mShop/photo/PhotoCaptureView;Z)V
    .locals 0

    .prologue
    .line 142
    iput-object p1, p0, Lcom/amazon/mShop/photo/PhotoCaptureView$5;->this$0:Lcom/amazon/mShop/photo/PhotoCaptureView;

    iput-boolean p2, p0, Lcom/amazon/mShop/photo/PhotoCaptureView$5;->val$needTakePhotoAfterAutoFocus:Z

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAutoFocus(ZLandroid/hardware/Camera;)V
    .locals 2
    .param p1, "success"    # Z
    .param p2, "camera"    # Landroid/hardware/Camera;

    .prologue
    .line 147
    iget-object v0, p0, Lcom/amazon/mShop/photo/PhotoCaptureView$5;->this$0:Lcom/amazon/mShop/photo/PhotoCaptureView;

    const/4 v1, 0x0

    # setter for: Lcom/amazon/mShop/photo/PhotoCaptureView;->mIsCameraAutoFocusing:Z
    invoke-static {v0, v1}, Lcom/amazon/mShop/photo/PhotoCaptureView;->access$202(Lcom/amazon/mShop/photo/PhotoCaptureView;Z)Z

    .line 148
    iget-boolean v0, p0, Lcom/amazon/mShop/photo/PhotoCaptureView$5;->val$needTakePhotoAfterAutoFocus:Z

    if-eqz v0, :cond_0

    .line 149
    iget-object v0, p0, Lcom/amazon/mShop/photo/PhotoCaptureView$5;->this$0:Lcom/amazon/mShop/photo/PhotoCaptureView;

    invoke-virtual {v0}, Lcom/amazon/mShop/photo/PhotoCaptureView;->doTakePhoto()V

    .line 151
    :cond_0
    return-void
.end method
