.class Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment$3;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# instance fields
.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;)V
    .locals 0

    .prologue
    .line 117
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment$3;->this$0:Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 5

    .prologue
    .line 120
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment$3;->this$0:Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->arraySong:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 121
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment$3;->this$0:Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->lvArtist:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    invoke-virtual {v0}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->getRefreshableView()Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ListView;

    invoke-virtual {v0, p3}, Landroid/widget/ListView;->getItemAtPosition(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    .line 122
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment$3;->this$0:Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    check-cast v1, Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/mixerbox/mixerbox3b/MainPage;->setSong(Ljava/lang/String;)Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    move-result-object v1

    .line 123
    iput-object v0, v1, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->currentPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    .line 124
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "artist_id = "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v2, v1, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->currentPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    invoke-virtual {v2}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistOwnerId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 125
    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment$3;->this$0:Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;

    invoke-virtual {v2}, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    const/4 v3, 0x0

    sget-object v4, Landroid/provider/MediaStore$Audio$Media;->EXTERNAL_CONTENT_URI:Landroid/net/Uri;

    invoke-static {v2, v3, v1, v0, v4}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->loadMP3Song(Landroid/content/Context;ZLcom/mixerbox/mixerbox3b/fragments/SongFragment;Ljava/lang/String;Landroid/net/Uri;)V

    .line 126
    return-void
.end method
