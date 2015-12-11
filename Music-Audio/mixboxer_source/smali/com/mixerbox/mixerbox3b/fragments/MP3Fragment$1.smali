.class Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment$1;
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
    .line 94
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment$1;->this$0:Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 11

    .prologue
    .line 97
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment$1;->this$0:Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->lvSong:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    invoke-virtual {v0}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->getRefreshableView()Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ListView;

    invoke-virtual {v0, p3}, Landroid/widget/ListView;->getItemAtPosition(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/classes/SongItem;

    .line 98
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment$1;->this$0:Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    check-cast v1, Lcom/mixerbox/mixerbox3b/MainPage;

    new-instance v2, Ljava/util/ArrayList;

    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment$1;->this$0:Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;

    iget-object v3, v3, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->arraySong:Ljava/util/ArrayList;

    invoke-direct {v2, v3}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    iput-object v2, v1, Lcom/mixerbox/mixerbox3b/MainPage;->arrayPlayingSong:Ljava/util/ArrayList;

    .line 99
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment$1;->this$0:Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    check-cast v1, Lcom/mixerbox/mixerbox3b/MainPage;

    iput-object v0, v1, Lcom/mixerbox/mixerbox3b/MainPage;->playingSong:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    .line 100
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment$1;->this$0:Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    move-object v10, v0

    check-cast v10, Lcom/mixerbox/mixerbox3b/MainPage;

    new-instance v0, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    const-string v1, "PLAYLISTMP3ID"

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment$1;->this$0:Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;

    invoke-virtual {v2}, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-virtual {v2}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f080128

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    const-string v3, ""

    const-string v4, ""

    const-string v5, "0"

    const-string v6, "0"

    const-string v7, ""

    const/16 v8, 0x8

    const/4 v9, 0x0

    invoke-direct/range {v0 .. v9}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZ)V

    iput-object v0, v10, Lcom/mixerbox/mixerbox3b/MainPage;->playingPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    .line 102
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment$1;->this$0:Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    add-int/lit8 v1, p3, -0x1

    iput v1, v0, Lcom/mixerbox/mixerbox3b/MainPage;->playingSongIndex:I

    .line 103
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment$1;->this$0:Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/mixerbox/mixerbox3b/MainPage;->playMusic(Z)V

    .line 104
    return-void
.end method
