.class Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/handmark/pulltorefresh/library/PullToRefreshBase$OnRefreshListener;


# instance fields
.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

.field final synthetic val$scroller:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$EndlessScrollListener;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$EndlessScrollListener;)V
    .locals 0

    .prologue
    .line 180
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    iput-object p2, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2;->val$scroller:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$EndlessScrollListener;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onRefresh(Lcom/handmark/pulltorefresh/library/PullToRefreshBase;)V
    .locals 4

    .prologue
    const/4 v2, 0x0

    .line 184
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    iput-boolean v2, v0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->endList:Z

    .line 185
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2;->val$scroller:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$EndlessScrollListener;

    # setter for: Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$EndlessScrollListener;->currentPage:I
    invoke-static {v0, v2}, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$EndlessScrollListener;->access$002(Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$EndlessScrollListener;I)I

    .line 186
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2;->val$scroller:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$EndlessScrollListener;

    # setter for: Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$EndlessScrollListener;->previousTotal:I
    invoke-static {v0, v2}, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$EndlessScrollListener;->access$102(Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$EndlessScrollListener;I)I

    .line 187
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2;->val$scroller:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$EndlessScrollListener;

    # setter for: Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$EndlessScrollListener;->loading:Z
    invoke-static {v0, v2}, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$EndlessScrollListener;->access$202(Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$EndlessScrollListener;Z)Z

    .line 189
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->vectorId:Ljava/lang/String;

    const-string v1, ""

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 246
    :goto_0
    return-void

    .line 191
    :cond_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->vectorId:Ljava/lang/String;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->vectorType:Ljava/lang/String;

    invoke-static {v0, v2, v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->getVectorUrl(Ljava/lang/String;ILjava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x0

    new-instance v2, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2$1;

    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    invoke-virtual {v3}, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    invoke-direct {v2, p0, v3}, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2$1;-><init>(Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2;Landroid/content/Context;)V

    invoke-static {v0, v1, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->get(Ljava/lang/String;Lcom/loopj/android/http/RequestParams;Lcom/loopj/android/http/AsyncHttpResponseHandler;)V

    goto :goto_0
.end method
