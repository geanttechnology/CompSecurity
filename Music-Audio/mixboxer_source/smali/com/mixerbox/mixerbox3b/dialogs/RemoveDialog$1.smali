.class Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# instance fields
.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;)V
    .locals 0

    .prologue
    .line 55
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 6

    .prologue
    const v5, 0x7f0800e9

    const/4 v4, 0x1

    .line 58
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;->dialogType:I
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;->access$000(Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;)I

    move-result v0

    if-ne v0, v4, :cond_2

    .line 59
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;->access$100(Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;)Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-boolean v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->isLogIn:Z

    if-eqz v0, :cond_1

    .line 60
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;->access$100(Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;)Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/MainPage;->backToPreviousFragment()V

    .line 61
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;->access$100(Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;)Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->fragmentPlaylists:Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->lv:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    if-eqz v0, :cond_0

    .line 62
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;->access$100(Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;)Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->fragmentPlaylists:Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->lv:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    invoke-virtual {v0}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->setRefreshing()V

    .line 63
    :cond_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;->access$100(Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;)Landroid/content/Context;

    move-result-object v0

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;->playlistId:Ljava/lang/String;

    invoke-static {v0, v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->removePlaylist(Landroid/content/Context;Ljava/lang/String;)V

    .line 94
    :goto_0
    return-void

    .line 66
    :cond_1
    const-string v0, "action:playlist_delete_local"

    invoke-static {v0}, Lcom/flurry/android/FlurryAgent;->logEvent(Ljava/lang/String;)V

    .line 67
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;->access$100(Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;)Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v1, v0, Lcom/mixerbox/mixerbox3b/MainPage;->DB:Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;->access$100(Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;)Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->stack:Ljava/util/Stack;

    invoke-virtual {v0}, Ljava/util/Stack;->lastElement()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->currentPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistId()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;->deleteMyPlaylist(Ljava/lang/String;)I

    .line 68
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;->access$100(Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;)Landroid/content/Context;

    move-result-object v0

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;->ctx:Landroid/content/Context;
    invoke-static {v1}, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;->access$100(Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;)Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1, v4}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->toastMsg(Landroid/content/Context;Ljava/lang/String;I)V

    .line 69
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;->access$100(Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;)Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->fragmentPlaylists:Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->loadContent()V

    .line 70
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;->access$100(Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;)Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/MainPage;->backToPreviousFragment()V

    goto :goto_0

    .line 74
    :cond_2
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;->access$100(Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;)Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-boolean v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->isLogIn:Z

    if-eqz v0, :cond_3

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;->playlistId:Ljava/lang/String;

    const-string v1, "PLAYLISTHISTORYID"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_3

    .line 75
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;->access$100(Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;)Landroid/content/Context;

    move-result-object v0

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;->playlistId:Ljava/lang/String;

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;

    iget-object v2, v2, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;->song:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;

    iget v3, v3, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;->order:I

    invoke-static {v0, v1, v2, v3}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->removeSong(Landroid/content/Context;Ljava/lang/String;Lcom/mixerbox/mixerbox3b/classes/SongItem;I)V

    goto/16 :goto_0

    .line 77
    :cond_3
    const-string v0, "action:music_delete_local"

    invoke-static {v0}, Lcom/flurry/android/FlurryAgent;->logEvent(Ljava/lang/String;)V

    .line 78
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;->access$100(Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;)Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->DB:Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;->playlistId:Ljava/lang/String;

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;

    iget-object v2, v2, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;->song:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    invoke-virtual {v2}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongYtId()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;

    iget-object v3, v3, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;->song:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    invoke-virtual {v3}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v1, v2, v3}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;->deleteSong(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    .line 80
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;->access$100(Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;)Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->stack:Ljava/util/Stack;

    invoke-virtual {v0}, Ljava/util/Stack;->lastElement()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/support/v4/app/Fragment;

    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    const-string v1, "SongFragment"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 81
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;->access$100(Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;)Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->stack:Ljava/util/Stack;

    invoke-virtual {v0}, Ljava/util/Stack;->lastElement()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->currentPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistId()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;->playlistId:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 83
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;->access$100(Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;)Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->stack:Ljava/util/Stack;

    invoke-virtual {v0}, Ljava/util/Stack;->lastElement()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->adapter:Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;->array:Ljava/util/ArrayList;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;->song:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->indexOf(Ljava/lang/Object;)I

    move-result v1

    .line 84
    const/4 v0, -0x1

    if-eq v1, v0, :cond_4

    .line 85
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;->access$100(Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;)Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->stack:Ljava/util/Stack;

    invoke-virtual {v0}, Ljava/util/Stack;->lastElement()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->adapter:Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;->array:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->remove(I)Ljava/lang/Object;

    .line 86
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;->access$100(Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;)Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->stack:Ljava/util/Stack;

    invoke-virtual {v0}, Ljava/util/Stack;->lastElement()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->adapter:Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;->notifyDataSetChanged()V

    .line 90
    :cond_4
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;->access$100(Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;)Landroid/content/Context;

    move-result-object v0

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;->ctx:Landroid/content/Context;
    invoke-static {v1}, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;->access$100(Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;)Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1, v4}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->toastMsg(Landroid/content/Context;Ljava/lang/String;I)V

    .line 91
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;->access$100(Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;)Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->fragmentPlaylists:Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->loadContent()V

    goto/16 :goto_0
.end method
