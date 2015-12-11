.class Lcom/amazon/mShop/photo/PhotoCaptureView$4;
.super Ljava/lang/Object;
.source "PhotoCaptureView.java"

# interfaces
.implements Landroid/view/View$OnTouchListener;


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
    .line 107
    iput-object p1, p0, Lcom/amazon/mShop/photo/PhotoCaptureView$4;->this$0:Lcom/amazon/mShop/photo/PhotoCaptureView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z
    .locals 2
    .param p1, "v"    # Landroid/view/View;
    .param p2, "event"    # Landroid/view/MotionEvent;

    .prologue
    const/4 v1, 0x1

    .line 110
    invoke-virtual {p2}, Landroid/view/MotionEvent;->getAction()I

    move-result v0

    if-ne v0, v1, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/photo/PhotoCaptureView$4;->this$0:Lcom/amazon/mShop/photo/PhotoCaptureView;

    # invokes: Lcom/amazon/mShop/photo/PhotoCaptureView;->isCameraButtonClickable()Z
    invoke-static {v0}, Lcom/amazon/mShop/photo/PhotoCaptureView;->access$100(Lcom/amazon/mShop/photo/PhotoCaptureView;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 111
    iget-object v0, p0, Lcom/amazon/mShop/photo/PhotoCaptureView$4;->this$0:Lcom/amazon/mShop/photo/PhotoCaptureView;

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/photo/PhotoCaptureView;->doAutoFocus(Z)V

    .line 114
    :cond_0
    const/4 v0, 0x0

    return v0
.end method
