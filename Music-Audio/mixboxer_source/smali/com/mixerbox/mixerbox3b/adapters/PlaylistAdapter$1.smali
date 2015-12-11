.class Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;

.field final synthetic val$position:I


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;I)V
    .locals 0

    .prologue
    .line 83
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter$1;->this$0:Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;

    iput p2, p0, Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter$1;->val$position:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 7

    .prologue
    const/4 v2, 0x0

    const/4 v3, 0x1

    .line 87
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter$1;->this$0:Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;

    iget v1, p0, Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter$1;->val$position:I

    invoke-virtual {v0, v1}, Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v0

    move-object v6, v0

    check-cast v6, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    .line 89
    invoke-virtual {v6}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistId()Ljava/lang/String;

    move-result-object v0

    const-string v1, "-999"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 153
    :cond_0
    :goto_0
    return-void

    .line 92
    :cond_1
    invoke-virtual {v6}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistType()I

    move-result v0

    const/16 v1, 0x8

    if-ne v0, v1, :cond_2

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter$1;->this$0:Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;

    # getter for: Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;->access$100(Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;)Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->currentFragment:I

    if-nez v0, :cond_2

    .line 93
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter$1;->this$0:Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;

    # getter for: Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;->access$100(Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;)Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/MainPage;->setMP3()V

    goto :goto_0

    .line 96
    :cond_2
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter$1;->this$0:Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;

    # getter for: Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;->access$100(Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;)Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->currentFragment:I

    const/16 v1, 0xe

    if-ne v0, v1, :cond_5

    .line 97
    invoke-virtual {v6}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistId()Ljava/lang/String;

    move-result-object v0

    const-string v1, "PLAYLISTMP3PLAYLISTID"

    if-ne v0, v1, :cond_3

    .line 98
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter$1;->this$0:Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;

    # getter for: Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;->access$100(Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;)Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->arraySong:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 99
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter$1;->this$0:Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;

    # getter for: Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;->access$100(Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;)Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-virtual {v6}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/mixerbox/mixerbox3b/MainPage;->setSong(Ljava/lang/String;)Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    move-result-object v0

    .line 100
    iput-object v6, v0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->currentPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    .line 101
    const-string v1, "is_music != 0 "

    .line 102
    const-string v2, "external"

    invoke-virtual {v6}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistOwnerId()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Ljava/lang/Long;->valueOf(Ljava/lang/String;)Ljava/lang/Long;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    invoke-static {v2, v4, v5}, Landroid/provider/MediaStore$Audio$Playlists$Members;->getContentUri(Ljava/lang/String;J)Landroid/net/Uri;

    move-result-object v2

    .line 103
    iget-object v4, p0, Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter$1;->this$0:Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;

    # getter for: Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;->ctx:Landroid/content/Context;
    invoke-static {v4}, Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;->access$100(Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;)Landroid/content/Context;

    move-result-object v4

    invoke-static {v4, v3, v0, v1, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->loadMP3Song(Landroid/content/Context;ZLcom/mixerbox/mixerbox3b/fragments/SongFragment;Ljava/lang/String;Landroid/net/Uri;)V

    goto :goto_0

    .line 105
    :cond_3
    invoke-virtual {v6}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistId()Ljava/lang/String;

    move-result-object v0

    const-string v1, "PLAYLISTMP3ALBUMID"

    if-ne v0, v1, :cond_4

    .line 106
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter$1;->this$0:Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;

    # getter for: Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;->access$100(Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;)Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->arraySong:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 107
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter$1;->this$0:Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;

    # getter for: Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;->access$100(Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;)Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-virtual {v6}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/mixerbox/mixerbox3b/MainPage;->setSong(Ljava/lang/String;)Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    move-result-object v0

    .line 108
    iput-object v6, v0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->currentPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    .line 109
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "album_id = "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, v0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->currentPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    invoke-virtual {v2}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistOwnerId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 110
    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter$1;->this$0:Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;

    # getter for: Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;->ctx:Landroid/content/Context;
    invoke-static {v2}, Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;->access$100(Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;)Landroid/content/Context;

    move-result-object v2

    sget-object v4, Landroid/provider/MediaStore$Audio$Media;->EXTERNAL_CONTENT_URI:Landroid/net/Uri;

    invoke-static {v2, v3, v0, v1, v4}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->loadMP3Song(Landroid/content/Context;ZLcom/mixerbox/mixerbox3b/fragments/SongFragment;Ljava/lang/String;Landroid/net/Uri;)V

    goto/16 :goto_0

    .line 112
    :cond_4
    invoke-virtual {v6}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistId()Ljava/lang/String;

    move-result-object v0

    const-string v1, "PLAYLISTMP3ARTISTID"

    if-ne v0, v1, :cond_0

    .line 113
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter$1;->this$0:Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;

    # getter for: Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;->access$100(Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;)Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->arraySong:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 114
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter$1;->this$0:Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;

    # getter for: Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;->access$100(Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;)Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-virtual {v6}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/mixerbox/mixerbox3b/MainPage;->setSong(Ljava/lang/String;)Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    move-result-object v0

    .line 115
    iput-object v6, v0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->currentPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    .line 116
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "artist_id = "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, v0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->currentPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    invoke-virtual {v2}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistOwnerId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 117
    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter$1;->this$0:Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;

    # getter for: Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;->ctx:Landroid/content/Context;
    invoke-static {v2}, Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;->access$100(Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;)Landroid/content/Context;

    move-result-object v2

    sget-object v4, Landroid/provider/MediaStore$Audio$Media;->EXTERNAL_CONTENT_URI:Landroid/net/Uri;

    invoke-static {v2, v3, v0, v1, v4}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->loadMP3Song(Landroid/content/Context;ZLcom/mixerbox/mixerbox3b/fragments/SongFragment;Ljava/lang/String;Landroid/net/Uri;)V

    goto/16 :goto_0

    .line 122
    :cond_5
    invoke-virtual {v6}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistType()I

    move-result v0

    const/4 v1, 0x5

    if-eq v0, v1, :cond_6

    invoke-virtual {v6}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistId()Ljava/lang/String;

    move-result-object v0

    const-string v1, "PLAYLISTHISTORYID"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_7

    .line 126
    :cond_6
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter$1;->this$0:Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;

    # getter for: Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;->access$100(Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;)Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->arraySong:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 128
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter$1;->this$0:Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;

    # getter for: Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;->access$100(Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;)Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-virtual {v6}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/mixerbox/mixerbox3b/MainPage;->setSong(Ljava/lang/String;)Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    move-result-object v0

    .line 129
    iput-object v6, v0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->currentPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    .line 131
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter$1;->this$0:Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;

    # getter for: Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;->ctx:Landroid/content/Context;
    invoke-static {v1}, Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;->access$100(Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;)Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v6}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistId()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, v3, v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->loadDBSong(Landroid/content/Context;Ljava/lang/String;ZLcom/mixerbox/mixerbox3b/fragments/SongFragment;)V

    goto/16 :goto_0

    .line 136
    :cond_7
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter$1;->this$0:Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;

    # getter for: Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;->access$100(Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;)Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->isConnectingToInternet(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_8

    .line 137
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter$1;->this$0:Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;

    # getter for: Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;->access$100(Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;)Landroid/content/Context;

    move-result-object v0

    check-cast v0, Landroid/app/Activity;

    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/dialogs/AlertDialogFactory;->NoNetworkAlertDialog(Landroid/app/Activity;)Landroid/app/AlertDialog;

    move-result-object v0

    .line 138
    invoke-virtual {v0}, Landroid/app/Dialog;->show()V

    goto/16 :goto_0

    .line 142
    :cond_8
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter$1;->this$0:Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;

    # getter for: Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;->access$100(Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;)Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->arraySong:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 144
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter$1;->this$0:Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;

    # getter for: Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;->access$100(Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;)Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-virtual {v6}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/mixerbox/mixerbox3b/MainPage;->setSong(Ljava/lang/String;)Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    move-result-object v5

    .line 145
    iput-object v6, v5, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->currentPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    .line 147
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter$1;->this$0:Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;

    # getter for: Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;->access$100(Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;)Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v6}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistId()Ljava/lang/String;

    move-result-object v1

    move v4, v2

    invoke-static/range {v0 .. v5}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->loadSong(Landroid/content/Context;Ljava/lang/String;ZIILcom/mixerbox/mixerbox3b/fragments/SongFragment;)V

    .line 149
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 150
    const-string v1, "id"

    invoke-virtual {v6}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistId()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 151
    const-string v1, "action:playlist_play"

    invoke-static {v1, v0}, Lcom/flurry/android/FlurryAgent;->logEvent(Ljava/lang/String;Ljava/util/Map;)V

    goto/16 :goto_0
.end method
