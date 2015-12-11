.class Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# instance fields
.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;

.field final synthetic val$view:Landroid/view/View;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;Landroid/view/View;)V
    .locals 0

    .prologue
    .line 43
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;

    iput-object p2, p0, Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog$1;->val$view:Landroid/view/View;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 12

    .prologue
    .line 46
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog$1;->val$view:Landroid/view/View;

    const v1, 0x7f070062

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    move-object v9, v0

    check-cast v9, Landroid/widget/EditText;

    .line 48
    invoke-virtual {v9}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {v9}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    if-nez v0, :cond_1

    .line 49
    :cond_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;->access$000(Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;)Landroid/content/Context;

    move-result-object v0

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;->ctx:Landroid/content/Context;
    invoke-static {v1}, Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;->access$000(Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;)Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f08006d

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x1

    invoke-static {v0, v1, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->toastMsg(Landroid/content/Context;Ljava/lang/String;I)V

    .line 50
    new-instance v0, Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;->ctx:Landroid/content/Context;
    invoke-static {v1}, Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;->access$000(Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;)Landroid/content/Context;

    move-result-object v1

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;

    iget v2, v2, Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;->type:I

    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;

    iget-object v3, v3, Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;->name:Ljava/lang/String;

    invoke-direct {v0, v1, v2, v3}, Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;-><init>(Landroid/content/Context;ILjava/lang/String;)V

    .line 51
    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;->show()Landroid/app/AlertDialog;

    .line 82
    :goto_0
    return-void

    .line 55
    :cond_1
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;->access$000(Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;)Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-boolean v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->isLogIn:Z

    if-eqz v0, :cond_3

    .line 56
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;->access$000(Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;)Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->fragmentPlaylists:Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->lv:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    if-eqz v0, :cond_2

    .line 57
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;->access$000(Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;)Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->fragmentPlaylists:Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->lv:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    invoke-virtual {v0}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->setRefreshing()V

    .line 59
    :cond_2
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;->access$000(Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;)Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v9}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->createPlaylist(Landroid/content/Context;Ljava/lang/String;)V

    goto :goto_0

    .line 62
    :cond_3
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;->access$000(Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;)Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->DB:Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;

    const-string v1, ""

    invoke-virtual {v9}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    const-string v3, ""

    const-string v4, ""

    const-string v5, "0"

    const-string v6, "0"

    const-string v7, ""

    const/4 v8, 0x5

    invoke-virtual/range {v0 .. v8}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;->addMyPlaylist(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)J

    move-result-wide v10

    .line 64
    invoke-static {v10, v11}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v0

    const-string v1, "-1"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 65
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;->access$000(Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;)Landroid/content/Context;

    move-result-object v0

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;->ctx:Landroid/content/Context;
    invoke-static {v1}, Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;->access$000(Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;)Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f080049

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x1

    invoke-static {v0, v1, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->toastMsg(Landroid/content/Context;Ljava/lang/String;I)V

    goto/16 :goto_0

    .line 68
    :cond_4
    const-string v0, "action:playlist_create_local"

    invoke-static {v0}, Lcom/flurry/android/FlurryAgent;->logEvent(Ljava/lang/String;)V

    .line 69
    new-instance v0, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    invoke-static {v10, v11}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v9}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    const-string v3, ""

    const-string v4, ""

    const-string v5, "0"

    const-string v6, "0"

    const-string v7, ""

    const/4 v8, 0x5

    const/4 v9, 0x0

    invoke-direct/range {v0 .. v9}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZ)V

    .line 71
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;->ctx:Landroid/content/Context;
    invoke-static {v1}, Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;->access$000(Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;)Landroid/content/Context;

    move-result-object v1

    check-cast v1, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/MainPage;->arrayMyPlaylists:Ljava/util/ArrayList;

    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 72
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;->ctx:Landroid/content/Context;
    invoke-static {v1}, Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;->access$000(Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;)Landroid/content/Context;

    move-result-object v1

    check-cast v1, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/MainPage;->myPlaylists:Ljava/util/ArrayList;

    invoke-static {v10, v11}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 73
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;->ctx:Landroid/content/Context;
    invoke-static {v1}, Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;->access$000(Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;)Landroid/content/Context;

    move-result-object v1

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;->ctx:Landroid/content/Context;
    invoke-static {v2}, Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;->access$000(Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;)Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f0800e9

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x1

    invoke-static {v1, v2, v3}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->toastMsg(Landroid/content/Context;Ljava/lang/String;I)V

    .line 74
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;->ctx:Landroid/content/Context;
    invoke-static {v1}, Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;->access$000(Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;)Landroid/content/Context;

    move-result-object v1

    check-cast v1, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/MainPage;->fragmentPlaylists:Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->loadContent()V

    .line 76
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;->ctx:Landroid/content/Context;
    invoke-static {v1}, Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;->access$000(Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;)Landroid/content/Context;

    move-result-object v1

    check-cast v1, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/MainPage;->arraySong:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->clear()V

    .line 77
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;->ctx:Landroid/content/Context;
    invoke-static {v1}, Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;->access$000(Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;)Landroid/content/Context;

    move-result-object v1

    check-cast v1, Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/mixerbox/mixerbox3b/MainPage;->setSong(Ljava/lang/String;)Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    move-result-object v1

    .line 78
    iput-object v0, v1, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->currentPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    .line 79
    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;->ctx:Landroid/content/Context;
    invoke-static {v2}, Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;->access$000(Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;)Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistId()Ljava/lang/String;

    move-result-object v0

    const/4 v3, 0x0

    invoke-static {v2, v0, v3, v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->loadDBSong(Landroid/content/Context;Ljava/lang/String;ZLcom/mixerbox/mixerbox3b/fragments/SongFragment;)V

    goto/16 :goto_0
.end method
