.class Lcom/mixerbox/mixerbox3b/MainPage$33;
.super Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;
.source "SourceFile"


# instance fields
.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/MainPage;

.field final synthetic val$p:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/MainPage;Landroid/content/Context;Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;)V
    .locals 0

    .prologue
    .line 2031
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/MainPage$33;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iput-object p3, p0, Lcom/mixerbox/mixerbox3b/MainPage$33;->val$p:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    invoke-direct {p0, p2}, Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;-><init>(Landroid/content/Context;)V

    return-void
.end method


# virtual methods
.method public onSuccess(Ljava/lang/String;)V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 2034
    invoke-super {p0, p1}, Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;->onSuccess(Ljava/lang/String;)V

    .line 2035
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 2036
    new-instance v0, Ljava/util/ArrayList;

    const/4 v1, 0x0

    invoke-static {p1, v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->getSongArray(Ljava/lang/String;Lcom/mixerbox/mixerbox3b/fragments/SongFragment;)Ljava/util/ArrayList;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    .line 2037
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-nez v1, :cond_0

    .line 2044
    :goto_0
    return-void

    .line 2039
    :cond_0
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage$33;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2, v0}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    iput-object v2, v1, Lcom/mixerbox/mixerbox3b/MainPage;->arrayPlayingSong:Ljava/util/ArrayList;

    .line 2040
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage$33;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$33;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayPlayingSong:Ljava/util/ArrayList;

    invoke-virtual {v0, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/classes/SongItem;

    iput-object v0, v1, Lcom/mixerbox/mixerbox3b/MainPage;->playingSong:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    .line 2041
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$33;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage$33;->val$p:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    iput-object v1, v0, Lcom/mixerbox/mixerbox3b/MainPage;->playingPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    .line 2042
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$33;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iput v3, v0, Lcom/mixerbox/mixerbox3b/MainPage;->playingSongIndex:I

    .line 2043
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$33;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-virtual {v0, v3}, Lcom/mixerbox/mixerbox3b/MainPage;->playMusic(Z)V

    goto :goto_0
.end method
