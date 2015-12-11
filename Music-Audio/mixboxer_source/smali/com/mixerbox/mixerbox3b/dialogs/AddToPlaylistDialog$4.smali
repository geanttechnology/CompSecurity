.class Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog$4;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# instance fields
.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;

.field final synthetic val$etName:Landroid/widget/EditText;

.field final synthetic val$radioGroup:Landroid/widget/RadioGroup;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;Landroid/widget/RadioGroup;Landroid/widget/EditText;)V
    .locals 0

    .prologue
    .line 131
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog$4;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;

    iput-object p2, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog$4;->val$radioGroup:Landroid/widget/RadioGroup;

    iput-object p3, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog$4;->val$etName:Landroid/widget/EditText;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 13

    .prologue
    .line 134
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog$4;->val$radioGroup:Landroid/widget/RadioGroup;

    invoke-virtual {v0}, Landroid/widget/RadioGroup;->getCheckedRadioButtonId()I

    move-result v1

    .line 136
    const v0, 0x7f070061

    if-ne v1, v0, :cond_1

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog$4;->val$etName:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog$4;->val$etName:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    if-nez v0, :cond_1

    .line 137
    :cond_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog$4;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->access$000(Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;)Landroid/content/Context;

    move-result-object v0

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog$4;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->ctx:Landroid/content/Context;
    invoke-static {v1}, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->access$000(Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;)Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f08006d

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x1

    invoke-static {v0, v1, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->toastMsg(Landroid/content/Context;Ljava/lang/String;I)V

    .line 138
    new-instance v0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog$4;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->ctx:Landroid/content/Context;
    invoke-static {v1}, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->access$000(Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;)Landroid/content/Context;

    move-result-object v1

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog$4;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;

    iget-object v2, v2, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->song:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    invoke-direct {v0, v1, v2}, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;-><init>(Landroid/content/Context;Lcom/mixerbox/mixerbox3b/classes/SongItem;)V

    .line 139
    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->show()Landroid/app/AlertDialog;

    move-result-object v0

    .line 140
    invoke-virtual {v0}, Landroid/app/AlertDialog;->getWindow()Landroid/view/Window;

    move-result-object v0

    const/16 v1, 0x10

    invoke-virtual {v0, v1}, Landroid/view/Window;->setSoftInputMode(I)V

    .line 177
    :goto_0
    return-void

    .line 144
    :cond_1
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog$4;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->access$000(Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;)Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-boolean v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->isLogIn:Z

    if-eqz v0, :cond_3

    .line 145
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog$4;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->arrayMyPlaylists:Ljava/util/ArrayList;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog$4;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->arrayMyPlaylists:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ge v1, v0, :cond_2

    if-ltz v1, :cond_2

    .line 146
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog$4;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->access$000(Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;)Landroid/content/Context;

    move-result-object v2

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog$4;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->arrayMyPlaylists:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistId()Ljava/lang/String;

    move-result-object v3

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog$4;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;

    iget-object v4, v0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->song:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    const/4 v5, 0x1

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog$4;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->arrayMyPlaylists:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistName()Ljava/lang/String;

    move-result-object v0

    invoke-static {v2, v3, v4, v5, v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->addSong(Landroid/content/Context;Ljava/lang/String;Lcom/mixerbox/mixerbox3b/classes/SongItem;ZLjava/lang/String;)V

    goto :goto_0

    .line 148
    :cond_2
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog$4;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->access$000(Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;)Landroid/content/Context;

    move-result-object v0

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog$4;->val$etName:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog$4;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;

    iget-object v2, v2, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->song:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    invoke-static {v0, v1, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->addSongToNewPlaylist(Landroid/content/Context;Ljava/lang/String;Lcom/mixerbox/mixerbox3b/classes/SongItem;)V

    goto :goto_0

    .line 151
    :cond_3
    const-string v0, "action:music_add_local"

    invoke-static {v0}, Lcom/flurry/android/FlurryAgent;->logEvent(Ljava/lang/String;)V

    .line 152
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog$4;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->arrayMyPlaylists:Ljava/util/ArrayList;

    if-eqz v0, :cond_4

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog$4;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->arrayMyPlaylists:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ge v1, v0, :cond_4

    if-ltz v1, :cond_4

    .line 153
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog$4;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->access$000(Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;)Landroid/content/Context;

    move-result-object v2

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog$4;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->arrayMyPlaylists:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistId()Ljava/lang/String;

    move-result-object v3

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog$4;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->arrayMyPlaylists:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistName()Ljava/lang/String;

    move-result-object v0

    invoke-static {v2, v3, v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->putDefaultAddedPlaylist(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    .line 154
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog$4;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->access$000(Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;)Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->DB:Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog$4;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;

    iget-object v2, v2, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->arrayMyPlaylists:Ljava/util/ArrayList;

    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistId()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog$4;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;

    iget-object v2, v2, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->song:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    invoke-virtual {v2}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongName()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog$4;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;

    iget-object v3, v3, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->song:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    invoke-virtual {v3}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongTime()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog$4;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;

    iget-object v4, v4, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->song:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    invoke-virtual {v4}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongYtId()Ljava/lang/String;

    move-result-object v4

    iget-object v5, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog$4;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;

    iget-object v5, v5, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->song:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    invoke-virtual {v5}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongOrder()I

    move-result v5

    iget-object v6, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog$4;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;

    iget-object v6, v6, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->song:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    invoke-virtual {v6}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongSource()I

    move-result v6

    iget-object v7, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog$4;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;

    iget-object v7, v7, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->song:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    invoke-virtual {v7}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongThumbnail()Ljava/lang/String;

    move-result-object v7

    invoke-virtual/range {v0 .. v7}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;->addSong(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;)V

    .line 155
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog$4;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->access$000(Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;)Landroid/content/Context;

    move-result-object v0

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog$4;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->ctx:Landroid/content/Context;
    invoke-static {v1}, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->access$000(Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;)Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f080077

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x1

    invoke-static {v0, v1, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->toastMsg(Landroid/content/Context;Ljava/lang/String;I)V

    .line 156
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog$4;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->access$000(Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;)Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->fragmentPlaylists:Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->loadContent()V

    goto/16 :goto_0

    .line 159
    :cond_4
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog$4;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->access$000(Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;)Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->DB:Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;

    const-string v1, ""

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog$4;->val$etName:Landroid/widget/EditText;

    invoke-virtual {v2}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

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

    .line 161
    invoke-static {v10, v11}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v0

    const-string v1, "-1"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 162
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog$4;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->access$000(Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;)Landroid/content/Context;

    move-result-object v0

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog$4;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->ctx:Landroid/content/Context;
    invoke-static {v1}, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->access$000(Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;)Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f080049

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x1

    invoke-static {v0, v1, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->toastMsg(Landroid/content/Context;Ljava/lang/String;I)V

    goto/16 :goto_0

    .line 166
    :cond_5
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog$4;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->access$000(Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;)Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v12, v0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayMyPlaylists:Ljava/util/ArrayList;

    new-instance v0, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    invoke-static {v10, v11}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog$4;->val$etName:Landroid/widget/EditText;

    invoke-virtual {v2}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

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

    invoke-virtual {v12, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 168
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog$4;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->access$000(Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;)Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->myPlaylists:Ljava/util/ArrayList;

    invoke-static {v10, v11}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 169
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog$4;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->access$000(Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;)Landroid/content/Context;

    move-result-object v0

    invoke-static {v10, v11}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog$4;->val$etName:Landroid/widget/EditText;

    invoke-virtual {v2}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->putDefaultAddedPlaylist(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    .line 170
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog$4;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->access$000(Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;)Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->DB:Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;

    invoke-static {v10, v11}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog$4;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;

    iget-object v2, v2, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->song:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    invoke-virtual {v2}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongName()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog$4;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;

    iget-object v3, v3, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->song:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    invoke-virtual {v3}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongTime()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog$4;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;

    iget-object v4, v4, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->song:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    invoke-virtual {v4}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongYtId()Ljava/lang/String;

    move-result-object v4

    iget-object v5, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog$4;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;

    iget-object v5, v5, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->song:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    invoke-virtual {v5}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongOrder()I

    move-result v5

    iget-object v6, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog$4;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;

    iget-object v6, v6, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->song:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    invoke-virtual {v6}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongSource()I

    move-result v6

    iget-object v7, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog$4;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;

    iget-object v7, v7, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->song:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    invoke-virtual {v7}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongThumbnail()Ljava/lang/String;

    move-result-object v7

    invoke-virtual/range {v0 .. v7}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;->addSong(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;)V

    .line 172
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog$4;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->access$000(Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;)Landroid/content/Context;

    move-result-object v0

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog$4;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->ctx:Landroid/content/Context;
    invoke-static {v1}, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->access$000(Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;)Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f080077

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x1

    invoke-static {v0, v1, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->toastMsg(Landroid/content/Context;Ljava/lang/String;I)V

    .line 173
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog$4;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->access$000(Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;)Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->fragmentPlaylists:Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->loadContent()V

    goto/16 :goto_0
.end method
