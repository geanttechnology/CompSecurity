.class public Lcom/mixerbox/mixerbox3b/services/EarphoneReceiver;
.super Landroid/content/BroadcastReceiver;
.source "SourceFile"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 4

    .prologue
    const/4 v3, 0x2

    .line 16
    invoke-virtual {p2}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    .line 17
    if-eqz v0, :cond_0

    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Earphone"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 18
    const-string v1, "key"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 19
    const-string v1, "key"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v0

    .line 20
    const-string v1, "key"

    invoke-virtual {p2, v1}, Landroid/content/Intent;->removeExtra(Ljava/lang/String;)V

    .line 21
    const/16 v1, 0x7e

    if-ne v0, v1, :cond_1

    move-object v0, p1

    .line 22
    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->videoState:I

    if-ne v0, v3, :cond_0

    .line 23
    check-cast p1, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, p1, Lcom/mixerbox/mixerbox3b/MainPage;->wv:Landroid/webkit/WebView;

    const-string v1, "javascript:playVideo()"

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    .line 47
    :cond_0
    :goto_0
    return-void

    .line 26
    :cond_1
    const/16 v1, 0x7f

    if-eq v0, v1, :cond_2

    const/16 v1, 0x56

    if-ne v0, v1, :cond_3

    .line 27
    :cond_2
    check-cast p1, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, p1, Lcom/mixerbox/mixerbox3b/MainPage;->wv:Landroid/webkit/WebView;

    const-string v1, "javascript:pauseVideo()"

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    goto :goto_0

    .line 29
    :cond_3
    const/16 v1, 0x57

    if-eq v0, v1, :cond_4

    const/16 v1, 0x5a

    if-ne v0, v1, :cond_5

    .line 30
    :cond_4
    check-cast p1, Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-virtual {p1}, Lcom/mixerbox/mixerbox3b/MainPage;->playNextSong()V

    goto :goto_0

    .line 32
    :cond_5
    const/16 v1, 0x58

    if-eq v0, v1, :cond_6

    const/16 v1, 0x59

    if-ne v0, v1, :cond_7

    .line 33
    :cond_6
    check-cast p1, Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-virtual {p1}, Lcom/mixerbox/mixerbox3b/MainPage;->playPreviousSong()V

    goto :goto_0

    .line 35
    :cond_7
    const/16 v1, 0x55

    if-eq v0, v1, :cond_8

    const/16 v1, 0x4f

    if-ne v0, v1, :cond_0

    :cond_8
    move-object v0, p1

    .line 36
    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->videoState:I

    if-ne v0, v3, :cond_9

    .line 37
    check-cast p1, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, p1, Lcom/mixerbox/mixerbox3b/MainPage;->wv:Landroid/webkit/WebView;

    const-string v1, "javascript:playVideo()"

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    .line 38
    const-string v0, "play"

    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->logMsg(Ljava/lang/String;)V

    goto :goto_0

    .line 41
    :cond_9
    check-cast p1, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, p1, Lcom/mixerbox/mixerbox3b/MainPage;->wv:Landroid/webkit/WebView;

    const-string v1, "javascript:pauseVideo()"

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    .line 42
    const-string v0, "pause"

    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->logMsg(Ljava/lang/String;)V

    goto :goto_0
.end method
