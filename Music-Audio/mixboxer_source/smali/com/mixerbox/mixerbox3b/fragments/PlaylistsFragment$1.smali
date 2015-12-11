.class Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/handmark/pulltorefresh/library/PullToRefreshBase$OnRefreshListener;


# instance fields
.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;)V
    .locals 0

    .prologue
    .line 100
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment$1;->this$0:Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onRefresh(Lcom/handmark/pulltorefresh/library/PullToRefreshBase;)V
    .locals 4

    .prologue
    .line 103
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment$1;->this$0:Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-boolean v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->isLogIn:Z

    if-eqz v0, :cond_0

    .line 104
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment$1;->this$0:Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->getUUID(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    .line 105
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment$1;->this$0:Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-static {v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->getFacebookToken(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->getAuthLoginUrl(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 107
    const/4 v1, 0x0

    new-instance v2, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment$1$1;

    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment$1;->this$0:Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;

    invoke-virtual {v3}, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    invoke-direct {v2, p0, v3}, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment$1$1;-><init>(Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment$1;Landroid/content/Context;)V

    invoke-static {v0, v1, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->get(Ljava/lang/String;Lcom/loopj/android/http/RequestParams;Lcom/loopj/android/http/AsyncHttpResponseHandler;)V

    .line 167
    :cond_0
    return-void
.end method
