.class Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/handmark/pulltorefresh/library/PullToRefreshBase$OnRefreshListener;


# instance fields
.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment;)V
    .locals 0

    .prologue
    .line 85
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onRefresh(Lcom/handmark/pulltorefresh/library/PullToRefreshBase;)V
    .locals 4

    .prologue
    .line 88
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment;->locale:Ljava/lang/String;

    invoke-static {v0, v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->getSystemListUrl(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x0

    new-instance v2, Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment$2$1;

    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment;

    invoke-virtual {v3}, Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    invoke-direct {v2, p0, v3}, Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment$2$1;-><init>(Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment$2;Landroid/content/Context;)V

    invoke-static {v0, v1, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->get(Ljava/lang/String;Lcom/loopj/android/http/RequestParams;Lcom/loopj/android/http/AsyncHttpResponseHandler;)V

    .line 127
    return-void
.end method
