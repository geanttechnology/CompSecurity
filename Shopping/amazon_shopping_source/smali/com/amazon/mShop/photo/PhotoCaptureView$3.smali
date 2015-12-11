.class Lcom/amazon/mShop/photo/PhotoCaptureView$3;
.super Ljava/lang/Object;
.source "PhotoCaptureView.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/photo/PhotoCaptureView;-><init>(Lcom/amazon/mShop/photo/PhotoCaptureActivity;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/photo/PhotoCaptureView;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/photo/PhotoCaptureView;)V
    .locals 0

    .prologue
    .line 99
    iput-object p1, p0, Lcom/amazon/mShop/photo/PhotoCaptureView$3;->this$0:Lcom/amazon/mShop/photo/PhotoCaptureView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 102
    invoke-virtual {p1}, Landroid/view/View;->isInTouchMode()Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/photo/PhotoCaptureView$3;->this$0:Lcom/amazon/mShop/photo/PhotoCaptureView;

    # invokes: Lcom/amazon/mShop/photo/PhotoCaptureView;->isCameraButtonClickable()Z
    invoke-static {v0}, Lcom/amazon/mShop/photo/PhotoCaptureView;->access$100(Lcom/amazon/mShop/photo/PhotoCaptureView;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 103
    iget-object v0, p0, Lcom/amazon/mShop/photo/PhotoCaptureView$3;->this$0:Lcom/amazon/mShop/photo/PhotoCaptureView;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/photo/PhotoCaptureView;->doAutoFocus(Z)V

    .line 105
    :cond_0
    return-void
.end method
