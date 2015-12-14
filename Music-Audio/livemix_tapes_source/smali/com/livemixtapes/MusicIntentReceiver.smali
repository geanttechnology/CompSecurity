.class public Lcom/livemixtapes/MusicIntentReceiver;
.super Landroid/content/BroadcastReceiver;
.source "MusicIntentReceiver.java"


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
    .locals 6
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 16
    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v3

    const-string v4, "android.media.AUDIO_BECOMING_NOISY"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 21
    new-instance v0, Landroid/content/Intent;

    const-string v3, "com.livemixtapes.action.PAUSE"

    invoke-direct {v0, v3}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 22
    .local v0, "i":Landroid/content/Intent;
    const-string v3, "com.livemixtapes"

    invoke-virtual {v0, v3}, Landroid/content/Intent;->setPackage(Ljava/lang/String;)Landroid/content/Intent;

    .line 23
    sget-object v3, Lcom/livemixtapes/App;->context:Landroid/content/Context;

    invoke-virtual {v3, v0}, Landroid/content/Context;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;

    .line 91
    .end local v0    # "i":Landroid/content/Intent;
    :cond_0
    :goto_0
    return-void

    .line 25
    :cond_1
    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v3

    const-string v4, "android.intent.action.MEDIA_BUTTON"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 26
    invoke-virtual {p2}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v3

    const-string v4, "android.intent.extra.KEY_EVENT"

    invoke-virtual {v3, v4}, Landroid/os/Bundle;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/view/KeyEvent;

    .line 27
    .local v2, "keyEvent":Landroid/view/KeyEvent;
    invoke-virtual {v2}, Landroid/view/KeyEvent;->getAction()I

    move-result v3

    if-nez v3, :cond_0

    .line 29
    invoke-virtual {v2}, Landroid/view/KeyEvent;->getKeyCode()I

    move-result v3

    sparse-switch v3, :sswitch_data_0

    goto :goto_0

    .line 36
    :sswitch_0
    new-instance v1, Landroid/content/Intent;

    const-string v3, "com.livemixtapes.action.TOGGLE_PLAYBACK"

    invoke-direct {v1, v3}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 37
    .local v1, "iplayback":Landroid/content/Intent;
    const-string v3, "com.livemixtapes"

    invoke-virtual {v1, v3}, Landroid/content/Intent;->setPackage(Ljava/lang/String;)Landroid/content/Intent;

    .line 38
    sget-object v3, Lcom/livemixtapes/App;->context:Landroid/content/Context;

    invoke-virtual {v3, v1}, Landroid/content/Context;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;

    goto :goto_0

    .line 50
    .end local v1    # "iplayback":Landroid/content/Intent;
    :sswitch_1
    invoke-static {}, Lcom/livemixtapes/NowPlayingActivity;->play()V

    goto :goto_0

    .line 60
    :sswitch_2
    invoke-static {}, Lcom/livemixtapes/NowPlayingActivity;->pause()V

    goto :goto_0

    .line 67
    :sswitch_3
    invoke-static {}, Lcom/livemixtapes/NowPlayingActivity;->stop()V

    goto :goto_0

    .line 69
    :sswitch_4
    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    .line 71
    const-string v5, "NEXT BUTTON PRESSED"

    aput-object v5, v3, v4

    invoke-static {v3}, Lcom/livemixtapes/console;->log([Ljava/lang/Object;)V

    .line 77
    invoke-static {}, Lcom/livemixtapes/NowPlayingActivity;->nextTrack()V

    goto :goto_0

    .line 87
    :sswitch_5
    invoke-static {}, Lcom/livemixtapes/NowPlayingActivity;->previousTrack()V

    goto :goto_0

    .line 29
    nop

    :sswitch_data_0
    .sparse-switch
        0x4f -> :sswitch_0
        0x55 -> :sswitch_0
        0x56 -> :sswitch_3
        0x57 -> :sswitch_4
        0x58 -> :sswitch_5
        0x7e -> :sswitch_1
        0x7f -> :sswitch_2
    .end sparse-switch
.end method
