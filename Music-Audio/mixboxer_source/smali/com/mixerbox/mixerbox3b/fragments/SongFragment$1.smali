.class Lcom/mixerbox/mixerbox3b/fragments/SongFragment$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# instance fields
.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/fragments/SongFragment;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/fragments/SongFragment;)V
    .locals 0

    .prologue
    .line 160
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment$1;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 4

    .prologue
    .line 163
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment$1;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->isConnectingToInternet(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_1

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment$1;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->currentPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistType()I

    move-result v0

    const/16 v1, 0x8

    if-eq v0, v1, :cond_1

    .line 165
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment$1;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/dialogs/AlertDialogFactory;->NoNetworkAlertDialog(Landroid/app/Activity;)Landroid/app/AlertDialog;

    move-result-object v0

    .line 166
    invoke-virtual {v0}, Landroid/app/Dialog;->show()V

    .line 179
    :cond_0
    :goto_0
    return-void

    .line 170
    :cond_1
    if-lez p3, :cond_0

    .line 173
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment$1;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->lv:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    invoke-virtual {v0}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->getRefreshableView()Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ListView;

    invoke-virtual {v0, p3}, Landroid/widget/ListView;->getItemAtPosition(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/classes/SongItem;

    .line 174
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment$1;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    check-cast v1, Lcom/mixerbox/mixerbox3b/MainPage;

    new-instance v3, Ljava/util/ArrayList;

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment$1;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    invoke-virtual {v2}, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    check-cast v2, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v2, v2, Lcom/mixerbox/mixerbox3b/MainPage;->arraySong:Ljava/util/ArrayList;

    invoke-direct {v3, v2}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    iput-object v3, v1, Lcom/mixerbox/mixerbox3b/MainPage;->arrayPlayingSong:Ljava/util/ArrayList;

    .line 175
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment$1;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    check-cast v1, Lcom/mixerbox/mixerbox3b/MainPage;

    iput-object v0, v1, Lcom/mixerbox/mixerbox3b/MainPage;->playingSong:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    .line 176
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment$1;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment$1;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->currentPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    iput-object v1, v0, Lcom/mixerbox/mixerbox3b/MainPage;->playingPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    .line 177
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment$1;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    add-int/lit8 v1, p3, -0x2

    iput v1, v0, Lcom/mixerbox/mixerbox3b/MainPage;->playingSongIndex:I

    .line 178
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment$1;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/mixerbox/mixerbox3b/MainPage;->playMusic(Z)V

    goto :goto_0
.end method
