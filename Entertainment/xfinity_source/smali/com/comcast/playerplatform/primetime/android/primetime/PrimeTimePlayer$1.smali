.class Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$1;
.super Ljava/lang/Object;
.source "PrimeTimePlayer.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->setPreferredAudioLanguage(Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

.field final synthetic val$track:Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;


# direct methods
.method constructor <init>(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;)V
    .locals 0

    .prologue
    .line 372
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$1;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    iput-object p2, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$1;->val$track:Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 376
    :try_start_0
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$1;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;
    invoke-static {v1}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->access$000(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)Lcom/adobe/mediacore/MediaPlayer;

    move-result-object v1

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$1;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;
    invoke-static {v1}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->access$000(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)Lcom/adobe/mediacore/MediaPlayer;

    move-result-object v1

    invoke-interface {v1}, Lcom/adobe/mediacore/MediaPlayer;->getCurrentItem()Lcom/adobe/mediacore/MediaPlayerItem;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 377
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$1;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$1;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    invoke-virtual {v2}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->getCurrentAudioTrack()Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;

    move-result-object v2

    # setter for: Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->previousAudioTrack:Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;
    invoke-static {v1, v2}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->access$102(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;)Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;

    .line 378
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$1;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;
    invoke-static {v1}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->access$000(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)Lcom/adobe/mediacore/MediaPlayer;

    move-result-object v1

    invoke-interface {v1}, Lcom/adobe/mediacore/MediaPlayer;->getCurrentItem()Lcom/adobe/mediacore/MediaPlayerItem;

    move-result-object v1

    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$1;->val$track:Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;

    invoke-virtual {v2}, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;->getTrack()Lcom/adobe/mediacore/info/AudioTrack;

    move-result-object v2

    invoke-interface {v1, v2}, Lcom/adobe/mediacore/MediaPlayerItem;->selectAudioTrack(Lcom/adobe/mediacore/info/AudioTrack;)Z

    .line 386
    :goto_0
    return-void

    .line 381
    :cond_0
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$1;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->logger:Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;
    invoke-static {v1}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->access$200(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;

    move-result-object v1

    const-string v2, "com.comcast.playerplatform.primetime::primetimeplayer"

    const-string v3, "Audio Track not set. Player\'s currentItem is null."

    invoke-virtual {v1, v2, v3}, Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;->i(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 383
    :catch_0
    move-exception v0

    .line 384
    .local v0, "ex":Ljava/lang/Exception;
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$1;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$1;->val$track:Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;

    invoke-virtual {v2}, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;->getLanguage()Ljava/lang/String;

    move-result-object v2

    # invokes: Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->setPreferredAudioLanguageByLanguage(Ljava/lang/String;)V
    invoke-static {v1, v2}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->access$300(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;Ljava/lang/String;)V

    goto :goto_0
.end method
