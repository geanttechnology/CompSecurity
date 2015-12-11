.class Lcom/mixerbox/mixerbox3b/MainPage$36;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/MainPage;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/MainPage;)V
    .locals 0

    .prologue
    .line 2353
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/MainPage$36;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 8

    .prologue
    .line 2357
    :try_start_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$36;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->DB:Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage$36;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/MainPage;->playingSong:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongYtId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;->checkHistory(Ljava/lang/String;)V

    .line 2358
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$36;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->DB:Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;

    const-string v1, "PLAYLISTHISTORYID"

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/MainPage$36;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v2, v2, Lcom/mixerbox/mixerbox3b/MainPage;->playingSong:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    invoke-virtual {v2}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongName()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/MainPage$36;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v3, v3, Lcom/mixerbox/mixerbox3b/MainPage;->playingSong:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    invoke-virtual {v3}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongTime()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/mixerbox/mixerbox3b/MainPage$36;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v4, v4, Lcom/mixerbox/mixerbox3b/MainPage;->playingSong:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    invoke-virtual {v4}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongYtId()Ljava/lang/String;

    move-result-object v4

    iget-object v5, p0, Lcom/mixerbox/mixerbox3b/MainPage$36;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v5, v5, Lcom/mixerbox/mixerbox3b/MainPage;->playingSong:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    invoke-virtual {v5}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongOrder()I

    move-result v5

    iget-object v6, p0, Lcom/mixerbox/mixerbox3b/MainPage$36;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v6, v6, Lcom/mixerbox/mixerbox3b/MainPage;->playingSong:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    invoke-virtual {v6}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongSource()I

    move-result v6

    iget-object v7, p0, Lcom/mixerbox/mixerbox3b/MainPage$36;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v7, v7, Lcom/mixerbox/mixerbox3b/MainPage;->playingSong:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    invoke-virtual {v7}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongThumbnail()Ljava/lang/String;

    move-result-object v7

    invoke-virtual/range {v0 .. v7}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;->addSong(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;)V

    .line 2361
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$36;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->DB:Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;

    const-string v1, "PLAYLISTHISTORYID"

    invoke-virtual {v0, v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;->getSongCount(Ljava/lang/String;)I

    move-result v0

    const/16 v1, 0x64

    if-le v0, v1, :cond_0

    .line 2362
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$36;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->DB:Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;->deleteHistory()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 2365
    :cond_0
    :goto_0
    return-void

    :catch_0
    move-exception v0

    goto :goto_0
.end method
