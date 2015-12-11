.class Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser$1;
.super Ljava/lang/Object;
.source "ViewItSlidingDrawerBrowser.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->objectsReceived(Ljava/util/List;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;)V
    .locals 0

    .prologue
    .line 381
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser$1;->this$0:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 383
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser$1;->this$0:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;
    invoke-static {v0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->access$000(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;)Lcom/amazon/mShop/search/viewit/ViewItActivity;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->getPhotoCaptureView()Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->getViewItSlidingDrawerView()Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->updateBottomToolBar()V

    .line 384
    return-void
.end method
