.class public Lcom/livemixtapes/AudioFocusHelper;
.super Ljava/lang/Object;
.source "AudioFocusHelper.java"

# interfaces
.implements Landroid/media/AudioManager$OnAudioFocusChangeListener;


# instance fields
.field mAM:Landroid/media/AudioManager;

.field mFocusable:Lcom/livemixtapes/MusicFocusable;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lcom/livemixtapes/MusicFocusable;)V
    .locals 1
    .param p1, "ctx"    # Landroid/content/Context;
    .param p2, "focusable"    # Lcom/livemixtapes/MusicFocusable;

    .prologue
    .line 30
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 31
    const-string v0, "audio"

    invoke-virtual {p1, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/media/AudioManager;

    iput-object v0, p0, Lcom/livemixtapes/AudioFocusHelper;->mAM:Landroid/media/AudioManager;

    .line 32
    iput-object p2, p0, Lcom/livemixtapes/AudioFocusHelper;->mFocusable:Lcom/livemixtapes/MusicFocusable;

    .line 33
    return-void
.end method


# virtual methods
.method public abandonFocus()Z
    .locals 2

    .prologue
    const/4 v0, 0x1

    .line 41
    iget-object v1, p0, Lcom/livemixtapes/AudioFocusHelper;->mAM:Landroid/media/AudioManager;

    invoke-virtual {v1, p0}, Landroid/media/AudioManager;->abandonAudioFocus(Landroid/media/AudioManager$OnAudioFocusChangeListener;)I

    move-result v1

    if-ne v0, v1, :cond_0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onAudioFocusChange(I)V
    .locals 2
    .param p1, "focusChange"    # I

    .prologue
    .line 49
    iget-object v0, p0, Lcom/livemixtapes/AudioFocusHelper;->mFocusable:Lcom/livemixtapes/MusicFocusable;

    if-nez v0, :cond_0

    .line 63
    :goto_0
    return-void

    .line 50
    :cond_0
    packed-switch p1, :pswitch_data_0

    :pswitch_0
    goto :goto_0

    .line 59
    :pswitch_1
    iget-object v0, p0, Lcom/livemixtapes/AudioFocusHelper;->mFocusable:Lcom/livemixtapes/MusicFocusable;

    const/4 v1, 0x1

    invoke-interface {v0, v1}, Lcom/livemixtapes/MusicFocusable;->onLostAudioFocus(Z)V

    goto :goto_0

    .line 52
    :pswitch_2
    iget-object v0, p0, Lcom/livemixtapes/AudioFocusHelper;->mFocusable:Lcom/livemixtapes/MusicFocusable;

    invoke-interface {v0}, Lcom/livemixtapes/MusicFocusable;->onGainedAudioFocus()V

    goto :goto_0

    .line 56
    :pswitch_3
    iget-object v0, p0, Lcom/livemixtapes/AudioFocusHelper;->mFocusable:Lcom/livemixtapes/MusicFocusable;

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Lcom/livemixtapes/MusicFocusable;->onLostAudioFocus(Z)V

    goto :goto_0

    .line 50
    nop

    :pswitch_data_0
    .packed-switch -0x3
        :pswitch_1
        :pswitch_3
        :pswitch_3
        :pswitch_0
        :pswitch_2
    .end packed-switch
.end method

.method public requestFocus()Z
    .locals 3

    .prologue
    const/4 v0, 0x1

    .line 36
    .line 37
    iget-object v1, p0, Lcom/livemixtapes/AudioFocusHelper;->mAM:Landroid/media/AudioManager;

    const/4 v2, 0x3

    invoke-virtual {v1, p0, v2, v0}, Landroid/media/AudioManager;->requestAudioFocus(Landroid/media/AudioManager$OnAudioFocusChangeListener;II)I

    move-result v1

    .line 36
    if-ne v0, v1, :cond_0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
