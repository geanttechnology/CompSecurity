.class public Lcom/livemixtapes/CallbackActivity;
.super Landroid/app/Activity;
.source "CallbackActivity.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 7
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    return-void
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v3, 0x1

    .line 12
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 15
    invoke-virtual {p0}, Lcom/livemixtapes/CallbackActivity;->getIntent()Landroid/content/Intent;

    move-result-object v1

    const-string v2, "which"

    invoke-virtual {v1, v2, v3}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v0

    .line 16
    .local v0, "flag":I
    if-ne v0, v3, :cond_0

    .line 18
    invoke-static {}, Lcom/livemixtapes/NowPlayingActivity;->pause()V

    .line 31
    :goto_0
    invoke-virtual {p0}, Lcom/livemixtapes/CallbackActivity;->finish()V

    .line 32
    return-void

    .line 21
    :cond_0
    const/4 v1, 0x2

    if-ne v0, v1, :cond_1

    .line 23
    invoke-static {}, Lcom/livemixtapes/NowPlayingActivity;->nextTrack()V

    goto :goto_0

    .line 28
    :cond_1
    invoke-static {}, Lcom/livemixtapes/NowPlayingActivity;->previousTrack()V

    goto :goto_0
.end method
