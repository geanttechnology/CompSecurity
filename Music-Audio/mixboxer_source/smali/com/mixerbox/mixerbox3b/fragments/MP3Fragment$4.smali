.class Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment$4;
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
    .line 128
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment$4;->this$0:Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 6

    .prologue
    .line 131
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment$4;->this$0:Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->arraySong:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 132
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment$4;->this$0:Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->lvPlaylist:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    invoke-virtual {v0}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->getRefreshableView()Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ListView;

    invoke-virtual {v0, p3}, Landroid/widget/ListView;->getItemAtPosition(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    .line 133
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment$4;->this$0:Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    check-cast v1, Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/mixerbox/mixerbox3b/MainPage;->setSong(Ljava/lang/String;)Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    move-result-object v1

    .line 134
    iput-object v0, v1, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->currentPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    .line 135
    const-string v2, "is_music != 0 "

    .line 136
    const-string v3, "external"

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistOwnerId()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Long;->valueOf(Ljava/lang/String;)Ljava/lang/Long;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    invoke-static {v3, v4, v5}, Landroid/provider/MediaStore$Audio$Playlists$Members;->getContentUri(Ljava/lang/String;J)Landroid/net/Uri;

    move-result-object v0

    .line 137
    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment$4;->this$0:Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;

    invoke-virtual {v3}, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    const/4 v4, 0x0

    invoke-static {v3, v4, v1, v2, v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->loadMP3Song(Landroid/content/Context;ZLcom/mixerbox/mixerbox3b/fragments/SongFragment;Ljava/lang/String;Landroid/net/Uri;)V

    .line 138
    return-void
.end method
