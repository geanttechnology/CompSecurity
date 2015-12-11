.class Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser$3;
.super Ljava/lang/Object;
.source "ViewItSlidingDrawerBrowser.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->error(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
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
    .line 431
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser$3;->this$0:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 434
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser$3;->this$0:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->mCurrentRequestDBObjects:Ljava/util/List;
    invoke-static {v0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->access$100(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 440
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser$3;->this$0:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->nextTriggerObjectIndex:I
    invoke-static {v0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->access$200(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;)I

    move-result v0

    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser$3;->this$0:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->pageSize:I
    invoke-static {v1}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->access$300(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;)I

    move-result v1

    if-le v0, v1, :cond_0

    .line 441
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser$3;->this$0:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;

    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser$3;->this$0:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->nextTriggerObjectIndex:I
    invoke-static {v1}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->access$500(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;)I

    move-result v1

    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser$3;->this$0:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->pageSize:I
    invoke-static {v2}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->access$600(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;)I

    move-result v2

    sub-int/2addr v1, v2

    # setter for: Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->nextTriggerObjectIndex:I
    invoke-static {v0, v1}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->access$402(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;I)I

    .line 443
    :cond_0
    return-void
.end method
