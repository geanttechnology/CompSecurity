.class Lcom/mixerbox/mixerbox3b/fragments/SongFragment$2$1;
.super Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;
.source "SourceFile"


# instance fields
.field final synthetic this$1:Lcom/mixerbox/mixerbox3b/fragments/SongFragment$2;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/fragments/SongFragment$2;Landroid/content/Context;)V
    .locals 0

    .prologue
    .line 199
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment$2$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/SongFragment$2;

    invoke-direct {p0, p2}, Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;-><init>(Landroid/content/Context;)V

    return-void
.end method


# virtual methods
.method public onSuccess(Ljava/lang/String;)V
    .locals 3

    .prologue
    .line 202
    invoke-super {p0, p1}, Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;->onSuccess(Ljava/lang/String;)V

    .line 203
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 204
    if-eqz p1, :cond_1

    .line 205
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment$2$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/SongFragment$2;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    invoke-static {p1, v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->getSongArray(Ljava/lang/String;Lcom/mixerbox/mixerbox3b/fragments/SongFragment;)Ljava/util/ArrayList;

    move-result-object v0

    move-object v1, v0

    .line 206
    :goto_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment$2$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/SongFragment$2;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    if-nez v0, :cond_0

    .line 211
    :goto_1
    return-void

    .line 208
    :cond_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment$2$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/SongFragment$2;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2, v1}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    iput-object v2, v0, Lcom/mixerbox/mixerbox3b/MainPage;->arraySong:Ljava/util/ArrayList;

    .line 209
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment$2$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/SongFragment$2;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->lv:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    invoke-virtual {v0}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->onRefreshComplete()V

    .line 210
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment$2$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/SongFragment$2;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->loadContent()V

    goto :goto_1

    :cond_1
    move-object v1, v0

    goto :goto_0
.end method
