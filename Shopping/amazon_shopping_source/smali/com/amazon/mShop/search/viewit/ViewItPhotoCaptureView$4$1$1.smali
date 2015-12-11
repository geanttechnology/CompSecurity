.class Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$4$1$1;
.super Ljava/lang/Object;
.source "ViewItPhotoCaptureView.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$4$1;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$2:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$4$1;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$4$1;)V
    .locals 0

    .prologue
    .line 249
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$4$1$1;->this$2:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$4$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 252
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$4$1$1;->this$2:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$4$1;

    iget-object v0, v0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$4$1;->this$1:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$4;

    iget-object v0, v0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$4;->this$0:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->mSlidingDrawer:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;
    invoke-static {v0}, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->access$300(Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;)Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->getListView()Landroid/widget/ListView;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setSelection(I)V

    .line 253
    return-void
.end method
