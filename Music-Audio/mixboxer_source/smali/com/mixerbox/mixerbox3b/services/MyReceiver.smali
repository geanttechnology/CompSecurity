.class public Lcom/mixerbox/mixerbox3b/services/MyReceiver;
.super Landroid/content/BroadcastReceiver;
.source "SourceFile"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 3

    .prologue
    .line 14
    invoke-virtual {p2}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    .line 15
    if-eqz v0, :cond_0

    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v1

    const-string v2, "MyService"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 16
    const-string v1, "t"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 17
    const-string v1, "t"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v1

    .line 18
    const-string v2, "t"

    invoke-virtual {p2, v2}, Landroid/content/Intent;->removeExtra(Ljava/lang/String;)V

    .line 19
    if-nez v1, :cond_1

    .line 20
    check-cast p1, Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-virtual {p1}, Lcom/mixerbox/mixerbox3b/MainPage;->playNextSong()V

    .line 35
    :cond_0
    :goto_0
    return-void

    .line 22
    :cond_1
    const/4 v2, 0x1

    if-ne v1, v2, :cond_2

    .line 23
    const-string v1, "d"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v0

    .line 24
    check-cast p1, Lcom/mixerbox/mixerbox3b/MainPage;

    div-int/lit16 v0, v0, 0x3e8

    invoke-virtual {p1, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->setSongTime(I)V

    goto :goto_0

    .line 26
    :cond_2
    const/4 v2, 0x2

    if-ne v1, v2, :cond_0

    .line 27
    const-string v1, "c"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v1

    move-object v0, p1

    .line 28
    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    div-int/lit16 v2, v1, 0x3e8

    invoke-virtual {v0, v2}, Lcom/mixerbox/mixerbox3b/MainPage;->updateTime(I)V

    .line 29
    div-int/lit16 v0, v1, 0x3e8

    const/4 v1, 0x5

    if-ge v0, v1, :cond_0

    .line 30
    check-cast p1, Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-virtual {p1}, Lcom/mixerbox/mixerbox3b/MainPage;->checkButton()V

    goto :goto_0
.end method
