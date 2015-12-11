.class Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$1;
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
    .line 94
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$1;->this$0:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 97
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$1;->this$0:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->mDialogHelper:Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;
    invoke-static {v0}, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->access$000(Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;)Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->isPauseDialogShowing()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 98
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$1;->this$0:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->mDialogHelper:Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;
    invoke-static {v0}, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->access$000(Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;)Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->clearErrorWindow()V

    .line 102
    :goto_0
    return-void

    .line 100
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$1;->this$0:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;
    invoke-static {v0}, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->access$100(Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;)Lcom/amazon/mShop/search/viewit/ViewItActivity;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->getCameraBgHelper()Lcom/amazon/mShop/search/viewit/CameraBgHelper;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/CameraBgHelper;->focusOnClick()V

    goto :goto_0
.end method
