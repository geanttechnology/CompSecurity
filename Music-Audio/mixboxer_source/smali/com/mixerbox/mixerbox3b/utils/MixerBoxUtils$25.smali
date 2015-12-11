.class final Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$25;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/widget/PopupMenu$OnMenuItemClickListener;


# instance fields
.field final synthetic val$ctx:Landroid/content/Context;

.field final synthetic val$currentPlaylistId:Ljava/lang/String;

.field final synthetic val$currentSong:Lcom/mixerbox/mixerbox3b/classes/SongItem;

.field final synthetic val$k:I


# direct methods
.method constructor <init>(Landroid/content/Context;Lcom/mixerbox/mixerbox3b/classes/SongItem;Ljava/lang/String;I)V
    .locals 0

    .prologue
    .line 1303
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$25;->val$ctx:Landroid/content/Context;

    iput-object p2, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$25;->val$currentSong:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    iput-object p3, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$25;->val$currentPlaylistId:Ljava/lang/String;

    iput p4, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$25;->val$k:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onMenuItemClick(Landroid/view/MenuItem;)Z
    .locals 5

    .prologue
    .line 1306
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$25;->val$ctx:Landroid/content/Context;

    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v1

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$25;->val$currentSong:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$25;->val$currentPlaylistId:Ljava/lang/String;

    iget v4, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$25;->val$k:I

    invoke-static {v0, v1, v2, v3, v4}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->performSongAction(Landroid/content/Context;ILcom/mixerbox/mixerbox3b/classes/SongItem;Ljava/lang/String;I)V

    .line 1307
    const/4 v0, 0x1

    return v0
.end method
