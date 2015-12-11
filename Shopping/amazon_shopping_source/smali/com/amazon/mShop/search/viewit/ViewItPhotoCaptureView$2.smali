.class Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$2;
.super Ljava/lang/Object;
.source "ViewItPhotoCaptureView.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->onFinishInflate()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;)V
    .locals 0

    .prologue
    .line 121
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$2;->this$0:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 124
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$2;->this$0:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->mTopFlashButton:Landroid/widget/ToggleButton;
    invoke-static {v0}, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->access$200(Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;)Landroid/widget/ToggleButton;

    move-result-object v1

    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$2;->this$0:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->mTopFlashButton:Landroid/widget/ToggleButton;
    invoke-static {v0}, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->access$200(Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;)Landroid/widget/ToggleButton;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/ToggleButton;->isChecked()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    invoke-virtual {v1, v0}, Landroid/widget/ToggleButton;->setChecked(Z)V

    .line 125
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$2;->this$0:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;
    invoke-static {v0}, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->access$100(Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;)Lcom/amazon/mShop/search/viewit/ViewItActivity;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->getCameraBgHelper()Lcom/amazon/mShop/search/viewit/CameraBgHelper;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/CameraBgHelper;->switchCameraFlashMode()Z

    .line 126
    return-void

    .line 124
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
