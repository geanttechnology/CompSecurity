.class Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$5;
.super Ljava/lang/Object;
.source "ViewItPhotoCaptureView.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->updateTitleForPeriod(II)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

.field final synthetic val$back_resid:I


# direct methods
.method constructor <init>(Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;I)V
    .locals 0

    .prologue
    .line 320
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$5;->this$0:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    iput p2, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$5;->val$back_resid:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 325
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$5;->this$0:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->mSlidingDrawer:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;
    invoke-static {v0}, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->access$300(Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;)Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->isOpened()Z

    move-result v0

    if-nez v0, :cond_0

    .line 326
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$5;->this$0:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    iget v1, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$5;->val$back_resid:I

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->updateTitle(I)V

    .line 328
    :cond_0
    return-void
.end method
