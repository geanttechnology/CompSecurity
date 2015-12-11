.class Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/handmark/pulltorefresh/library/PullToRefreshBase$OnRefreshListener;


# instance fields
.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;

.field final synthetic val$scroller:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$EndlessScrollListener;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$EndlessScrollListener;)V
    .locals 0

    .prologue
    .line 74
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;

    iput-object p2, p0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$2;->val$scroller:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$EndlessScrollListener;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onRefresh(Lcom/handmark/pulltorefresh/library/PullToRefreshBase;)V
    .locals 4

    .prologue
    const/4 v1, 0x0

    .line 78
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;

    iput-boolean v1, v0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;->endList:Z

    .line 79
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$2;->val$scroller:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$EndlessScrollListener;

    # setter for: Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$EndlessScrollListener;->currentPage:I
    invoke-static {v0, v1}, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$EndlessScrollListener;->access$002(Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$EndlessScrollListener;I)I

    .line 80
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$2;->val$scroller:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$EndlessScrollListener;

    # setter for: Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$EndlessScrollListener;->previousTotal:I
    invoke-static {v0, v1}, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$EndlessScrollListener;->access$102(Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$EndlessScrollListener;I)I

    .line 81
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$2;->val$scroller:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$EndlessScrollListener;

    # setter for: Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$EndlessScrollListener;->loading:Z
    invoke-static {v0, v1}, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$EndlessScrollListener;->access$202(Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$EndlessScrollListener;Z)Z

    .line 83
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0, v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->getNewsfeedUrl(Landroid/content/Context;I)Ljava/lang/String;

    move-result-object v0

    .line 84
    const/4 v1, 0x0

    new-instance v2, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$2$1;

    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;

    invoke-virtual {v3}, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    invoke-direct {v2, p0, v3}, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$2$1;-><init>(Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$2;Landroid/content/Context;)V

    invoke-static {v0, v1, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->get(Ljava/lang/String;Lcom/loopj/android/http/RequestParams;Lcom/loopj/android/http/AsyncHttpResponseHandler;)V

    .line 152
    return-void
.end method
