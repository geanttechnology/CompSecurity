.class Lcom/mixerbox/mixerbox3b/MainPage$31;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/MainPage;

.field final synthetic val$b:Z


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/MainPage;Z)V
    .locals 0

    .prologue
    .line 1787
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/MainPage$31;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iput-boolean p2, p0, Lcom/mixerbox/mixerbox3b/MainPage$31;->val$b:Z

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 5

    .prologue
    .line 1789
    const/4 v1, 0x0

    .line 1790
    const-string v0, ""

    .line 1791
    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/MainPage$31;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v2, v2, Lcom/mixerbox/mixerbox3b/MainPage;->playingSong:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    invoke-virtual {v2}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongSource()I

    move-result v2

    const/4 v3, 0x2

    if-ne v2, v3, :cond_1

    .line 1792
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$31;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/MainPage$31;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v2, v2, Lcom/mixerbox/mixerbox3b/MainPage;->playingSong:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    invoke-virtual {v2}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongId()Ljava/lang/String;

    move-result-object v2

    # invokes: Lcom/mixerbox/mixerbox3b/MainPage;->getMP3Thumbnail(Ljava/lang/String;)Ljava/lang/String;
    invoke-static {v0, v2}, Lcom/mixerbox/mixerbox3b/MainPage;->access$500(Lcom/mixerbox/mixerbox3b/MainPage;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 1800
    :goto_0
    new-instance v3, Landroid/content/Intent;

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/MainPage$31;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    const-class v4, Lcom/mixerbox/mixerbox3b/services/PlayerService;

    invoke-direct {v3, v2, v4}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 1801
    const-string v2, ""

    .line 1802
    iget-object v4, p0, Lcom/mixerbox/mixerbox3b/MainPage$31;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v4, v4, Lcom/mixerbox/mixerbox3b/MainPage;->playingSong:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    invoke-virtual {v4}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongName()Ljava/lang/String;

    move-result-object v4

    if-eqz v4, :cond_0

    .line 1803
    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/MainPage$31;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v2, v2, Lcom/mixerbox/mixerbox3b/MainPage;->playingSong:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    invoke-virtual {v2}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongName()Ljava/lang/String;

    move-result-object v2

    .line 1804
    :cond_0
    const-string v4, "song_name"

    invoke-virtual {v3, v4, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 1805
    const-string v2, "bitmap"

    invoke-virtual {v3, v2, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 1806
    const-string v1, "song_source"

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/MainPage$31;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v2, v2, Lcom/mixerbox/mixerbox3b/MainPage;->playingSong:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    invoke-virtual {v2}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongSource()I

    move-result v2

    invoke-virtual {v3, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 1807
    const-string v1, "url"

    invoke-virtual {v3, v1, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 1808
    const-string v0, "is_playing"

    iget-boolean v1, p0, Lcom/mixerbox/mixerbox3b/MainPage$31;->val$b:Z

    invoke-virtual {v3, v0, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 1809
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$31;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-virtual {v0, v3}, Lcom/mixerbox/mixerbox3b/MainPage;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;

    .line 1810
    return-void

    .line 1794
    :cond_1
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage$31;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/MainPage;->playingSong:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongSource()I

    move-result v1

    const/4 v2, 0x1

    if-ne v1, v2, :cond_3

    .line 1795
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "http://i.ytimg.com/vi/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage$31;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/MainPage;->playingSong:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongYtId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/mqdefault.jpg"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 1798
    :cond_2
    :goto_1
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->getBitmapFromURL(Ljava/lang/String;)Landroid/graphics/Bitmap;

    move-result-object v1

    goto :goto_0

    .line 1796
    :cond_3
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage$31;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/MainPage;->playingSong:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongSource()I

    move-result v1

    const/4 v2, 0x3

    if-ne v1, v2, :cond_2

    .line 1797
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$31;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->playingSong:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongThumbnail()Ljava/lang/String;

    move-result-object v0

    goto :goto_1
.end method
