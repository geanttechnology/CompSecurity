.class Lcom/mixerbox/mixerbox3b/fragments/SongFragment$4;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/fragments/SongFragment;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/fragments/SongFragment;)V
    .locals 0

    .prologue
    .line 259
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment$4;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5

    .prologue
    .line 263
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment$4;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->currentPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistId()Ljava/lang/String;

    move-result-object v1

    .line 265
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment$4;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    const-string v2, "dj"

    const/4 v3, 0x1

    const-string v4, ""

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/mixerbox/mixerbox3b/MainPage;->setVector(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    move-result-object v0

    .line 266
    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment$4;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    invoke-virtual {v2}, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-static {v2, v1, v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->getSubsInfo(Landroid/content/Context;Ljava/lang/String;Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;)V

    .line 267
    return-void
.end method
