.class Lcom/mixerbox/mixerbox3b/adapters/SongAdapter$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;

.field final synthetic val$position:I


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;I)V
    .locals 0

    .prologue
    .line 133
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter$2;->this$0:Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;

    iput p2, p0, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter$2;->val$position:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5

    .prologue
    .line 136
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter$2;->this$0:Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;

    # getter for: Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;->access$100(Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;)Landroid/content/Context;

    move-result-object v1

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter$2;->this$0:Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;->array:Ljava/util/ArrayList;

    iget v2, p0, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter$2;->val$position:I

    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/classes/SongItem;

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter$2;->this$0:Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;

    iget-object v2, v2, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;->currentPlaylistId:Ljava/lang/String;

    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter$2;->this$0:Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;

    iget-object v3, v3, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;->array:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v3

    iget v4, p0, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter$2;->val$position:I

    sub-int/2addr v3, v4

    add-int/lit8 v3, v3, -0x1

    invoke-static {v1, p1, v0, v2, v3}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->createPopupMenu(Landroid/content/Context;Landroid/view/View;Lcom/mixerbox/mixerbox3b/classes/SongItem;Ljava/lang/String;I)V

    .line 138
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 139
    const-string v2, "id"

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter$2;->this$0:Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;->array:Ljava/util/ArrayList;

    iget v3, p0, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter$2;->val$position:I

    invoke-virtual {v0, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/classes/SongItem;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongId()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v1, v2, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 140
    const-string v0, "playlist"

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter$2;->this$0:Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;

    iget-object v2, v2, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;->currentPlaylistId:Ljava/lang/String;

    invoke-interface {v1, v0, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 141
    const-string v0, "action:music_edit"

    invoke-static {v0, v1}, Lcom/flurry/android/FlurryAgent;->logEvent(Ljava/lang/String;Ljava/util/Map;)V

    .line 142
    return-void
.end method
