.class final Lcom/handmark/pulltorefresh/library/extras/PullToRefreshWebView2$JsValueCallback;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field final synthetic this$0:Lcom/handmark/pulltorefresh/library/extras/PullToRefreshWebView2;


# direct methods
.method constructor <init>(Lcom/handmark/pulltorefresh/library/extras/PullToRefreshWebView2;)V
    .locals 0

    .prologue
    .line 122
    iput-object p1, p0, Lcom/handmark/pulltorefresh/library/extras/PullToRefreshWebView2$JsValueCallback;->this$0:Lcom/handmark/pulltorefresh/library/extras/PullToRefreshWebView2;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final isReadyForPullDownResponse(Z)V
    .locals 1

    .prologue
    .line 129
    iget-object v0, p0, Lcom/handmark/pulltorefresh/library/extras/PullToRefreshWebView2$JsValueCallback;->this$0:Lcom/handmark/pulltorefresh/library/extras/PullToRefreshWebView2;

    # getter for: Lcom/handmark/pulltorefresh/library/extras/PullToRefreshWebView2;->mIsReadyForPullDown:Ljava/util/concurrent/atomic/AtomicBoolean;
    invoke-static {v0}, Lcom/handmark/pulltorefresh/library/extras/PullToRefreshWebView2;->access$100(Lcom/handmark/pulltorefresh/library/extras/PullToRefreshWebView2;)Ljava/util/concurrent/atomic/AtomicBoolean;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/util/concurrent/atomic/AtomicBoolean;->set(Z)V

    .line 130
    return-void
.end method

.method public final isReadyForPullUpResponse(Z)V
    .locals 1

    .prologue
    .line 125
    iget-object v0, p0, Lcom/handmark/pulltorefresh/library/extras/PullToRefreshWebView2$JsValueCallback;->this$0:Lcom/handmark/pulltorefresh/library/extras/PullToRefreshWebView2;

    # getter for: Lcom/handmark/pulltorefresh/library/extras/PullToRefreshWebView2;->mIsReadyForPullUp:Ljava/util/concurrent/atomic/AtomicBoolean;
    invoke-static {v0}, Lcom/handmark/pulltorefresh/library/extras/PullToRefreshWebView2;->access$000(Lcom/handmark/pulltorefresh/library/extras/PullToRefreshWebView2;)Ljava/util/concurrent/atomic/AtomicBoolean;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/util/concurrent/atomic/AtomicBoolean;->set(Z)V

    .line 126
    return-void
.end method
