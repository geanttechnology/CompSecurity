.class Lcom/amazon/mShop/search/viewit/ViewItActivity$5;
.super Ljava/lang/Object;
.source "ViewItActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/search/viewit/ViewItActivity;->didReceiveTrack(ILjava/util/ArrayList;Landroid/graphics/PointF;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/search/viewit/ViewItActivity;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/search/viewit/ViewItActivity;)V
    .locals 0

    .prologue
    .line 878
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity$5;->this$0:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 882
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity$5;->this$0:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItActivity;->mViewItMetricHelper:Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;
    invoke-static {v0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->access$100(Lcom/amazon/mShop/search/viewit/ViewItActivity;)Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;

    move-result-object v0

    const-string/jumbo v1, "successes-per-session"

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->logCountMetricsPerSession(Ljava/lang/String;I)V

    .line 884
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity$5;->this$0:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItActivity;->mBarcodes:Ljava/util/List;
    invoke-static {v0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->access$200(Lcom/amazon/mShop/search/viewit/ViewItActivity;)Ljava/util/List;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/util/Collection;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 885
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity$5;->this$0:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity$5;->this$0:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItActivity;->mBarcodes:Ljava/util/List;
    invoke-static {v1}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->access$200(Lcom/amazon/mShop/search/viewit/ViewItActivity;)Ljava/util/List;

    move-result-object v1

    sget-object v2, Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;->BARCODE:Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;

    # invokes: Lcom/amazon/mShop/search/viewit/ViewItActivity;->showLoadingWindow(Ljava/util/List;Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;)V
    invoke-static {v0, v1, v2}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->access$300(Lcom/amazon/mShop/search/viewit/ViewItActivity;Ljava/util/List;Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;)V

    .line 889
    :cond_0
    :goto_0
    return-void

    .line 886
    :cond_1
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity$5;->this$0:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItActivity;->mImageAsins:Ljava/util/List;
    invoke-static {v0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->access$400(Lcom/amazon/mShop/search/viewit/ViewItActivity;)Ljava/util/List;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/util/Collection;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 887
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity$5;->this$0:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity$5;->this$0:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItActivity;->mImageAsins:Ljava/util/List;
    invoke-static {v1}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->access$400(Lcom/amazon/mShop/search/viewit/ViewItActivity;)Ljava/util/List;

    move-result-object v1

    sget-object v2, Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;->IMAGE:Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;

    # invokes: Lcom/amazon/mShop/search/viewit/ViewItActivity;->showLoadingWindow(Ljava/util/List;Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;)V
    invoke-static {v0, v1, v2}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->access$300(Lcom/amazon/mShop/search/viewit/ViewItActivity;Ljava/util/List;Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;)V

    goto :goto_0
.end method
