.class public Lcom/mixerbox/mixerbox3b/services/SleepReceiver;
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
    .locals 2

    .prologue
    .line 13
    invoke-virtual {p2}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    .line 14
    if-eqz v0, :cond_0

    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    const-string v1, "SleepService"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    move-object v0, p1

    .line 16
    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    const/4 v1, 0x1

    iput-boolean v1, v0, Lcom/mixerbox/mixerbox3b/MainPage;->shouldCloseApp:Z

    move-object v0, p1

    .line 17
    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/MainPage;->closePlayer()V

    .line 18
    check-cast p1, Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-virtual {p1}, Lcom/mixerbox/mixerbox3b/MainPage;->finish()V

    .line 22
    :cond_0
    return-void
.end method
