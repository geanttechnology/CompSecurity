.class Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# instance fields
.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;)V
    .locals 0

    .prologue
    .line 172
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 6

    .prologue
    const/16 v3, 0x8

    .line 175
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->lv:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    invoke-virtual {v0}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->getRefreshableView()Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ListView;

    invoke-virtual {v0, p3}, Landroid/widget/ListView;->getItemAtPosition(I)Ljava/lang/Object;

    move-result-object v0

    move-object v1, v0

    check-cast v1, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    .line 176
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->isConnectingToInternet(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_0

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistType()I

    move-result v0

    if-eq v0, v3, :cond_0

    .line 178
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/dialogs/AlertDialogFactory;->NoNetworkAlertDialog(Landroid/app/Activity;)Landroid/app/AlertDialog;

    move-result-object v0

    .line 179
    invoke-virtual {v0}, Landroid/app/Dialog;->show()V

    .line 209
    :goto_0
    return-void

    .line 183
    :cond_0
    :try_start_0
    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistId()Ljava/lang/String;

    move-result-object v0

    const-string v2, "-999"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 184
    new-instance v0, Lcom/mixerbox/mixerbox3b/dialogs/LoginDialog;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const/4 v2, 0x3

    invoke-direct {v0, v1, v2}, Lcom/mixerbox/mixerbox3b/dialogs/LoginDialog;-><init>(Landroid/content/Context;I)V

    .line 185
    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/dialogs/LoginDialog;->show()Landroid/app/AlertDialog;

    goto :goto_0

    :catch_0
    move-exception v0

    goto :goto_0

    .line 187
    :cond_1
    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistType()I

    move-result v0

    if-ne v0, v3, :cond_2

    .line 188
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/MainPage;->setMP3()V

    goto :goto_0

    .line 190
    :cond_2
    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistType()I

    move-result v0

    const/4 v2, 0x6

    if-ne v0, v2, :cond_3

    .line 191
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->arraySong:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 192
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/mixerbox/mixerbox3b/MainPage;->setSong(Ljava/lang/String;)Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    move-result-object v0

    .line 193
    iput-object v1, v0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->currentPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    .line 194
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const-string v2, "PLAYLISTHISTORYID"

    const/4 v3, 0x0

    invoke-static {v1, v2, v3, v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->loadDBSong(Landroid/content/Context;Ljava/lang/String;ZLcom/mixerbox/mixerbox3b/fragments/SongFragment;)V

    goto :goto_0

    .line 196
    :cond_3
    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistType()I

    move-result v0

    const/4 v2, 0x5

    if-ne v0, v2, :cond_4

    .line 197
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->arraySong:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 198
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/mixerbox/mixerbox3b/MainPage;->setSong(Ljava/lang/String;)Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    move-result-object v0

    .line 199
    iput-object v1, v0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->currentPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    .line 200
    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;

    invoke-virtual {v2}, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistId()Ljava/lang/String;

    move-result-object v1

    const/4 v3, 0x0

    invoke-static {v2, v1, v3, v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->loadDBSong(Landroid/content/Context;Ljava/lang/String;ZLcom/mixerbox/mixerbox3b/fragments/SongFragment;)V

    goto/16 :goto_0

    .line 202
    :cond_4
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->arraySong:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 203
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/mixerbox/mixerbox3b/MainPage;->setSong(Ljava/lang/String;)Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    move-result-object v5

    .line 204
    iput-object v1, v5, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->currentPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    .line 205
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistId()Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x0

    const/4 v3, 0x1

    const/4 v4, -0x1

    invoke-static/range {v0 .. v5}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->loadSong(Landroid/content/Context;Ljava/lang/String;ZIILcom/mixerbox/mixerbox3b/fragments/SongFragment;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto/16 :goto_0
.end method
