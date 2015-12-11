.class Lcom/mixerbox/mixerbox3b/adapters/SongAdapter$1;
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
    .line 118
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter$1;->this$0:Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;

    iput p2, p0, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter$1;->val$position:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 6

    .prologue
    .line 121
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter$1;->this$0:Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;

    # getter for: Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;->access$100(Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;)Landroid/content/Context;

    move-result-object v1

    const/4 v2, 0x1

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter$1;->this$0:Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;->array:Ljava/util/ArrayList;

    iget v3, p0, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter$1;->val$position:I

    invoke-virtual {v0, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/classes/SongItem;

    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter$1;->this$0:Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;

    iget-object v3, v3, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;->currentPlaylistId:Ljava/lang/String;

    iget-object v4, p0, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter$1;->this$0:Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;

    iget-object v4, v4, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;->array:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    move-result v4

    iget v5, p0, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter$1;->val$position:I

    sub-int/2addr v4, v5

    add-int/lit8 v4, v4, -0x1

    invoke-static {v1, v2, v0, v3, v4}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->performSongAction(Landroid/content/Context;ILcom/mixerbox/mixerbox3b/classes/SongItem;Ljava/lang/String;I)V

    .line 122
    return-void
.end method
