.class Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$LoadSongTask;
.super Landroid/os/AsyncTask;
.source "SourceFile"


# instance fields
.field ctx:Landroid/content/Context;

.field frag:Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

.field hasToGoBack:Z

.field playIndex:I

.field shouldCancel:Z

.field type:I


# direct methods
.method public constructor <init>(Landroid/content/Context;ZIILcom/mixerbox/mixerbox3b/fragments/SongFragment;)V
    .locals 1

    .prologue
    .line 747
    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    .line 748
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$LoadSongTask;->ctx:Landroid/content/Context;

    .line 749
    iput-boolean p2, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$LoadSongTask;->hasToGoBack:Z

    .line 750
    iput p3, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$LoadSongTask;->type:I

    .line 751
    iput p4, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$LoadSongTask;->playIndex:I

    .line 752
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$LoadSongTask;->shouldCancel:Z

    .line 753
    iput-object p5, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$LoadSongTask;->frag:Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    .line 754
    return-void
.end method


# virtual methods
.method protected bridge synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 739
    check-cast p1, [Ljava/lang/String;

    invoke-virtual {p0, p1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$LoadSongTask;->doInBackground([Ljava/lang/String;)Ljava/lang/Void;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/String;)Ljava/lang/Void;
    .locals 5

    .prologue
    const/4 v4, 0x0

    const/4 v3, 0x0

    .line 763
    aget-object v0, p1, v3

    if-nez v0, :cond_0

    .line 764
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$LoadSongTask;->shouldCancel:Z

    .line 772
    :goto_0
    return-object v4

    .line 767
    :cond_0
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 768
    new-instance v1, Ljava/util/ArrayList;

    aget-object v0, p1, v3

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$LoadSongTask;->frag:Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    invoke-static {v0, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->getSongArray(Ljava/lang/String;Lcom/mixerbox/mixerbox3b/fragments/SongFragment;)Ljava/util/ArrayList;

    move-result-object v0

    invoke-direct {v1, v0}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    .line 769
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$LoadSongTask;->ctx:Landroid/content/Context;

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2, v1}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    iput-object v2, v0, Lcom/mixerbox/mixerbox3b/MainPage;->arraySong:Ljava/util/ArrayList;

    .line 771
    iput-boolean v3, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$LoadSongTask;->shouldCancel:Z

    goto :goto_0
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 739
    check-cast p1, Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$LoadSongTask;->onPostExecute(Ljava/lang/Void;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/Void;)V
    .locals 5

    .prologue
    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 782
    invoke-super {p0, p1}, Landroid/os/AsyncTask;->onPostExecute(Ljava/lang/Object;)V

    .line 783
    iget-boolean v0, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$LoadSongTask;->shouldCancel:Z

    if-eqz v0, :cond_1

    .line 784
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$LoadSongTask;->ctx:Landroid/content/Context;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$LoadSongTask;->ctx:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f080049

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1, v4}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->toastMsg(Landroid/content/Context;Ljava/lang/String;I)V

    .line 822
    :cond_0
    :goto_0
    return-void

    .line 787
    :cond_1
    iget v0, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$LoadSongTask;->type:I

    if-ne v0, v4, :cond_3

    .line 788
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$LoadSongTask;->ctx:Landroid/content/Context;

    check-cast v0, Landroid/app/Activity;

    new-instance v1, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$LoadSongTask$1;

    invoke-direct {v1, p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$LoadSongTask$1;-><init>(Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$LoadSongTask;)V

    invoke-virtual {v0, v1}, Landroid/app/Activity;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 794
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$LoadSongTask;->ctx:Landroid/content/Context;

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->playingPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    if-eqz v0, :cond_2

    .line 795
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$LoadSongTask;->ctx:Landroid/content/Context;

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->playingPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistId()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$LoadSongTask;->frag:Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->currentPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 796
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$LoadSongTask;->ctx:Landroid/content/Context;

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    new-instance v2, Ljava/util/ArrayList;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$LoadSongTask;->ctx:Landroid/content/Context;

    check-cast v1, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/MainPage;->arraySong:Ljava/util/ArrayList;

    invoke-direct {v2, v1}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    iput-object v2, v0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayPlayingSong:Ljava/util/ArrayList;

    .line 808
    :cond_2
    :goto_1
    iget v0, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$LoadSongTask;->playIndex:I

    if-ltz v0, :cond_0

    .line 809
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$LoadSongTask;->ctx:Landroid/content/Context;

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->arraySong:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-eqz v0, :cond_0

    .line 811
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$LoadSongTask;->ctx:Landroid/content/Context;

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    new-instance v2, Ljava/util/ArrayList;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$LoadSongTask;->ctx:Landroid/content/Context;

    check-cast v1, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/MainPage;->arraySong:Ljava/util/ArrayList;

    invoke-direct {v2, v1}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    iput-object v2, v0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayPlayingSong:Ljava/util/ArrayList;

    .line 812
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$LoadSongTask;->ctx:Landroid/content/Context;

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$LoadSongTask;->ctx:Landroid/content/Context;

    check-cast v1, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/MainPage;->arrayPlayingSong:Ljava/util/ArrayList;

    invoke-virtual {v1, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/mixerbox/mixerbox3b/classes/SongItem;

    iput-object v1, v0, Lcom/mixerbox/mixerbox3b/MainPage;->playingSong:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    .line 813
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$LoadSongTask;->ctx:Landroid/content/Context;

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$LoadSongTask;->frag:Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->currentPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    iput-object v1, v0, Lcom/mixerbox/mixerbox3b/MainPage;->playingPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    .line 814
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$LoadSongTask;->ctx:Landroid/content/Context;

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iput v3, v0, Lcom/mixerbox/mixerbox3b/MainPage;->playingSongIndex:I

    .line 815
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$LoadSongTask;->ctx:Landroid/content/Context;

    check-cast v0, Landroid/app/Activity;

    new-instance v1, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$LoadSongTask$3;

    invoke-direct {v1, p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$LoadSongTask$3;-><init>(Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$LoadSongTask;)V

    invoke-virtual {v0, v1}, Landroid/app/Activity;->runOnUiThread(Ljava/lang/Runnable;)V

    goto/16 :goto_0

    .line 798
    :cond_3
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$LoadSongTask;->ctx:Landroid/content/Context;

    check-cast v0, Landroid/app/Activity;

    new-instance v1, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$LoadSongTask$2;

    invoke-direct {v1, p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$LoadSongTask$2;-><init>(Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$LoadSongTask;)V

    invoke-virtual {v0, v1}, Landroid/app/Activity;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 804
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$LoadSongTask;->ctx:Landroid/content/Context;

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->playingPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    if-eqz v0, :cond_2

    .line 805
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$LoadSongTask;->ctx:Landroid/content/Context;

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->playingPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistId()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$LoadSongTask;->frag:Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->currentPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 806
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$LoadSongTask;->ctx:Landroid/content/Context;

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    new-instance v2, Ljava/util/ArrayList;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$LoadSongTask;->ctx:Landroid/content/Context;

    check-cast v1, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/MainPage;->arraySong:Ljava/util/ArrayList;

    invoke-direct {v2, v1}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    iput-object v2, v0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayPlayingSong:Ljava/util/ArrayList;

    goto/16 :goto_1
.end method

.method protected onPreExecute()V
    .locals 0

    .prologue
    .line 758
    invoke-super {p0}, Landroid/os/AsyncTask;->onPreExecute()V

    .line 759
    return-void
.end method

.method protected varargs onProgressUpdate([Ljava/lang/Integer;)V
    .locals 0

    .prologue
    .line 777
    invoke-super {p0, p1}, Landroid/os/AsyncTask;->onProgressUpdate([Ljava/lang/Object;)V

    .line 778
    return-void
.end method

.method protected bridge synthetic onProgressUpdate([Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 739
    check-cast p1, [Ljava/lang/Integer;

    invoke-virtual {p0, p1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$LoadSongTask;->onProgressUpdate([Ljava/lang/Integer;)V

    return-void
.end method
