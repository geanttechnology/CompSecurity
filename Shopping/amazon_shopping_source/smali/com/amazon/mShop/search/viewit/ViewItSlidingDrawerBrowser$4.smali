.class Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser$4;
.super Ljava/lang/Object;
.source "ViewItSlidingDrawerBrowser.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->cancelled(Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
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
    .line 450
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser$4;->this$0:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 453
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser$4;->this$0:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->mCurrentRequestDBObjects:Ljava/util/List;
    invoke-static {v0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->access$100(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 454
    return-void
.end method
