.class Lcom/amazon/mShop/net/HttpFetcher$1;
.super Ljava/lang/Object;
.source "HttpFetcher.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/net/HttpFetcher;->onPostExecute(Ljava/lang/Object;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/net/HttpFetcher;

.field final synthetic val$result:Ljava/lang/Object;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/net/HttpFetcher;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 285
    .local p0, "this":Lcom/amazon/mShop/net/HttpFetcher$1;, "Lcom/amazon/mShop/net/HttpFetcher.1;"
    iput-object p1, p0, Lcom/amazon/mShop/net/HttpFetcher$1;->this$0:Lcom/amazon/mShop/net/HttpFetcher;

    iput-object p2, p0, Lcom/amazon/mShop/net/HttpFetcher$1;->val$result:Ljava/lang/Object;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 291
    .local p0, "this":Lcom/amazon/mShop/net/HttpFetcher$1;, "Lcom/amazon/mShop/net/HttpFetcher.1;"
    iget-object v0, p0, Lcom/amazon/mShop/net/HttpFetcher$1;->this$0:Lcom/amazon/mShop/net/HttpFetcher;

    invoke-virtual {v0}, Lcom/amazon/mShop/net/HttpFetcher;->isCancelled()Z

    move-result v0

    if-nez v0, :cond_0

    .line 292
    iget-object v0, p0, Lcom/amazon/mShop/net/HttpFetcher$1;->val$result:Ljava/lang/Object;

    if-nez v0, :cond_2

    .line 293
    iget-object v0, p0, Lcom/amazon/mShop/net/HttpFetcher$1;->this$0:Lcom/amazon/mShop/net/HttpFetcher;

    # getter for: Lcom/amazon/mShop/net/HttpFetcher;->mParams:Lcom/amazon/mShop/net/HttpFetcher$Params;
    invoke-static {v0}, Lcom/amazon/mShop/net/HttpFetcher;->access$000(Lcom/amazon/mShop/net/HttpFetcher;)Lcom/amazon/mShop/net/HttpFetcher$Params;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/net/HttpFetcher$Params;->getSubscriber()Lcom/amazon/mShop/net/HttpFetcher$Subscriber;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/net/HttpFetcher$1;->this$0:Lcom/amazon/mShop/net/HttpFetcher;

    # getter for: Lcom/amazon/mShop/net/HttpFetcher;->mParams:Lcom/amazon/mShop/net/HttpFetcher$Params;
    invoke-static {v1}, Lcom/amazon/mShop/net/HttpFetcher;->access$000(Lcom/amazon/mShop/net/HttpFetcher;)Lcom/amazon/mShop/net/HttpFetcher$Params;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/amazon/mShop/net/HttpFetcher$Subscriber;->onHttpRequestFailed(Lcom/amazon/mShop/net/HttpFetcher$Params;)V

    .line 301
    :cond_0
    :goto_0
    iget-object v0, p0, Lcom/amazon/mShop/net/HttpFetcher$1;->this$0:Lcom/amazon/mShop/net/HttpFetcher;

    iget-object v0, v0, Lcom/amazon/mShop/net/HttpFetcher;->mCallObserver:Lcom/amazon/mShop/net/CallObserver;

    invoke-virtual {v0}, Lcom/amazon/mShop/net/CallObserver;->isFinished()Z

    move-result v0

    if-nez v0, :cond_1

    .line 302
    iget-object v0, p0, Lcom/amazon/mShop/net/HttpFetcher$1;->this$0:Lcom/amazon/mShop/net/HttpFetcher;

    iget-object v0, v0, Lcom/amazon/mShop/net/HttpFetcher;->mCallObserver:Lcom/amazon/mShop/net/CallObserver;

    invoke-virtual {v0}, Lcom/amazon/mShop/net/CallObserver;->onComplete()V

    .line 303
    :cond_1
    return-void

    .line 295
    :cond_2
    iget-object v0, p0, Lcom/amazon/mShop/net/HttpFetcher$1;->this$0:Lcom/amazon/mShop/net/HttpFetcher;

    # getter for: Lcom/amazon/mShop/net/HttpFetcher;->mParams:Lcom/amazon/mShop/net/HttpFetcher$Params;
    invoke-static {v0}, Lcom/amazon/mShop/net/HttpFetcher;->access$000(Lcom/amazon/mShop/net/HttpFetcher;)Lcom/amazon/mShop/net/HttpFetcher$Params;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/net/HttpFetcher$Params;->getSubscriber()Lcom/amazon/mShop/net/HttpFetcher$Subscriber;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/net/HttpFetcher$1;->val$result:Ljava/lang/Object;

    iget-object v2, p0, Lcom/amazon/mShop/net/HttpFetcher$1;->this$0:Lcom/amazon/mShop/net/HttpFetcher;

    # getter for: Lcom/amazon/mShop/net/HttpFetcher;->mParams:Lcom/amazon/mShop/net/HttpFetcher$Params;
    invoke-static {v2}, Lcom/amazon/mShop/net/HttpFetcher;->access$000(Lcom/amazon/mShop/net/HttpFetcher;)Lcom/amazon/mShop/net/HttpFetcher$Params;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/amazon/mShop/net/HttpFetcher$Subscriber;->onHttpResponseReceived(Ljava/lang/Object;Lcom/amazon/mShop/net/HttpFetcher$Params;)V

    goto :goto_0
.end method
