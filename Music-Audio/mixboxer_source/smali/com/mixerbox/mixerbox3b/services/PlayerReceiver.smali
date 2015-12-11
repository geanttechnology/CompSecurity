.class public Lcom/mixerbox/mixerbox3b/services/PlayerReceiver;
.super Landroid/content/BroadcastReceiver;
.source "SourceFile"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 12
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 4

    .prologue
    const/4 v3, 0x1

    .line 16
    invoke-virtual {p2}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    .line 17
    if-eqz v0, :cond_0

    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v1

    const-string v2, "PlayerBroadcastReceiver"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 19
    const-string v1, "player"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 20
    const-string v1, "player"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v0

    .line 21
    const-string v1, "player"

    invoke-virtual {p2, v1}, Landroid/content/Intent;->removeExtra(Ljava/lang/String;)V

    .line 22
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "BUNDLE = "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->logMsg(Ljava/lang/String;)V

    .line 23
    if-ne v0, v3, :cond_1

    .line 24
    check-cast p1, Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-virtual {p1}, Lcom/mixerbox/mixerbox3b/MainPage;->musicPlayPause()V

    .line 46
    :cond_0
    :goto_0
    return-void

    .line 26
    :cond_1
    const/4 v1, 0x2

    if-ne v0, v1, :cond_2

    .line 27
    check-cast p1, Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-virtual {p1}, Lcom/mixerbox/mixerbox3b/MainPage;->playPreviousSong()V

    goto :goto_0

    .line 29
    :cond_2
    const/4 v1, 0x3

    if-ne v0, v1, :cond_3

    .line 30
    check-cast p1, Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-virtual {p1}, Lcom/mixerbox/mixerbox3b/MainPage;->playNextSong()V

    goto :goto_0

    .line 34
    :cond_3
    const-string v0, "notification"

    invoke-virtual {p1, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/NotificationManager;

    .line 35
    const/16 v1, 0x10

    invoke-virtual {v0, v1}, Landroid/app/NotificationManager;->cancel(I)V

    move-object v0, p1

    .line 38
    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iput-boolean v3, v0, Lcom/mixerbox/mixerbox3b/MainPage;->shouldCloseApp:Z

    move-object v0, p1

    .line 39
    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/MainPage;->closePlayer()V

    move-object v0, p1

    .line 40
    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/MainPage;->stopPlayer()V

    .line 42
    check-cast p1, Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-virtual {p1}, Lcom/mixerbox/mixerbox3b/MainPage;->finish()V

    goto :goto_0
.end method
