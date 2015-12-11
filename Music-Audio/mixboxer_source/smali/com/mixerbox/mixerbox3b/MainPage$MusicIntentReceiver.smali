.class Lcom/mixerbox/mixerbox3b/MainPage$MusicIntentReceiver;
.super Landroid/content/BroadcastReceiver;
.source "SourceFile"


# instance fields
.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/MainPage;


# direct methods
.method private constructor <init>(Lcom/mixerbox/mixerbox3b/MainPage;)V
    .locals 0

    .prologue
    .line 1205
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/MainPage$MusicIntentReceiver;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/mixerbox/mixerbox3b/MainPage;Lcom/mixerbox/mixerbox3b/MainPage$1;)V
    .locals 0

    .prologue
    .line 1205
    invoke-direct {p0, p1}, Lcom/mixerbox/mixerbox3b/MainPage$MusicIntentReceiver;-><init>(Lcom/mixerbox/mixerbox3b/MainPage;)V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 3

    .prologue
    const v2, 0x7f0200ef

    .line 1208
    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    const-string v1, "android.intent.action.HEADSET_PLUG"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1209
    const-string v0, "state"

    const/4 v1, -0x1

    invoke-virtual {p2, v0, v1}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v0

    .line 1210
    packed-switch v0, :pswitch_data_0

    .line 1227
    :cond_0
    :goto_0
    return-void

    .line 1212
    :pswitch_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$MusicIntentReceiver;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->videoState:I

    const/4 v1, 0x1

    if-ne v0, v1, :cond_1

    .line 1213
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$MusicIntentReceiver;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->wv:Landroid/webkit/WebView;

    const-string v1, "javascript:pauseVideo()"

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    .line 1214
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$MusicIntentReceiver;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->btnPlay:Landroid/widget/ImageButton;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage$MusicIntentReceiver;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    goto :goto_0

    .line 1215
    :cond_1
    sget-object v0, Lcom/mixerbox/mixerbox3b/services/MyService;->mediaPlayer:Landroid/media/MediaPlayer;

    if-eqz v0, :cond_0

    sget-object v0, Lcom/mixerbox/mixerbox3b/services/MyService;->mediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->isPlaying()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1216
    sget-object v0, Lcom/mixerbox/mixerbox3b/services/MyService;->mediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->pause()V

    .line 1217
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$MusicIntentReceiver;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->btnPlay:Landroid/widget/ImageButton;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage$MusicIntentReceiver;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    goto :goto_0

    .line 1210
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
    .end packed-switch
.end method
