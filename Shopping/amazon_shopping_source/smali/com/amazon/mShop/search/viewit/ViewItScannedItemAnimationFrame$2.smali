.class Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame$2;
.super Ljava/lang/Object;
.source "ViewItScannedItemAnimationFrame.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->popUpLoadingWindow(Ljava/util/List;Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;)V
    .locals 0

    .prologue
    .line 108
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame$2;->this$0:Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 111
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame$2;->this$0:Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->mIsErrorHappened:Z
    invoke-static {v0}, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->access$000(Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 112
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame$2;->this$0:Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;

    const/4 v1, 0x1

    # invokes: Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->prepareLoading(Z)V
    invoke-static {v0, v1}, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->access$100(Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;Z)V

    .line 113
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame$2;->this$0:Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;

    # invokes: Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->startItemScaleAndTranslateAnimation()V
    invoke-static {v0}, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->access$200(Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;)V

    .line 115
    :cond_0
    return-void
.end method
