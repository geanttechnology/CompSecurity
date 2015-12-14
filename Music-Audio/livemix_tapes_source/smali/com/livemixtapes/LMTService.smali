.class public Lcom/livemixtapes/LMTService;
.super Landroid/app/Service;
.source "LMTService.java"

# interfaces
.implements Landroid/media/MediaPlayer$OnCompletionListener;
.implements Landroid/media/MediaPlayer$OnPreparedListener;
.implements Landroid/media/MediaPlayer$OnErrorListener;
.implements Lcom/livemixtapes/MusicFocusable;
.implements Lcom/livemixtapes/PrepareMusicRetrieverTask$MusicRetrieverPreparedListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/livemixtapes/LMTService$AudioFocus;,
        Lcom/livemixtapes/LMTService$PauseReason;,
        Lcom/livemixtapes/LMTService$State;
    }
.end annotation


# static fields
.field public static final ACTION_IMAGE:Ljava/lang/String; = "com.livemixtapes.action.IMAGE"

.field public static final ACTION_PAUSE:Ljava/lang/String; = "com.livemixtapes.action.PAUSE"

.field public static final ACTION_PLAY:Ljava/lang/String; = "com.livemixtapes.action.PLAY"

.field public static final ACTION_REWIND:Ljava/lang/String; = "com.livemixtapes.action.REWIND"

.field public static final ACTION_SKIP:Ljava/lang/String; = "com.livemixtapes.action.SKIP"

.field public static final ACTION_STOP:Ljava/lang/String; = "com.livemixtapes.action.STOP"

.field public static final ACTION_TOGGLE_PLAYBACK:Ljava/lang/String; = "com.livemixtapes.action.TOGGLE_PLAYBACK"

.field public static final ACTION_URL:Ljava/lang/String; = "com.livemixtapes.action.URL"

.field public static final DUCK_VOLUME:F = 0.1f

.field static final TAG:Ljava/lang/String; = "livemixtapesPlayer"

.field public static amPlaying:Ljava/lang/Boolean;

.field public static mPlayer:Landroid/media/MediaPlayer;

.field public static mediaSession:Landroid/media/session/MediaSession;

.field public static temp_title:Ljava/lang/String;


# instance fields
.field final NOTIFICATION_ID:I

.field mAudioFocus:Lcom/livemixtapes/LMTService$AudioFocus;

.field mAudioFocusHelper:Lcom/livemixtapes/AudioFocusHelper;

.field mAudioManager:Landroid/media/AudioManager;

.field mDummyAlbumArt:Landroid/graphics/Bitmap;

.field mIsStreaming:Z

.field mMediaButtonReceiverComponent:Landroid/content/ComponentName;

.field mNotification:Landroid/app/Notification;

.field mNotificationManager:Landroid/app/NotificationManager;

.field mPauseReason:Lcom/livemixtapes/LMTService$PauseReason;

.field mRemoteControlClientCompat:Lcom/livemixtapes/RemoteControlClientCompat;

.field mRetriever:Lcom/livemixtapes/MusicRetriever;

.field mSongTitle:Ljava/lang/String;

.field mStartPlayingAfterRetrieve:Z

.field mState:Lcom/livemixtapes/LMTService$State;

.field mWhatToPlayAfterRetrieve:Landroid/net/Uri;

.field mWifiLock:Landroid/net/wifi/WifiManager$WifiLock;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 66
    const/4 v0, 0x0

    sput-object v0, Lcom/livemixtapes/LMTService;->mPlayer:Landroid/media/MediaPlayer;

    .line 68
    const/4 v0, 0x0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    sput-object v0, Lcom/livemixtapes/LMTService;->amPlaying:Ljava/lang/Boolean;

    .line 69
    return-void
.end method

.method public constructor <init>()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x0

    .line 45
    invoke-direct {p0}, Landroid/app/Service;-><init>()V

    .line 73
    iput-object v1, p0, Lcom/livemixtapes/LMTService;->mAudioFocusHelper:Lcom/livemixtapes/AudioFocusHelper;

    .line 84
    sget-object v0, Lcom/livemixtapes/LMTService$State;->Retrieving:Lcom/livemixtapes/LMTService$State;

    iput-object v0, p0, Lcom/livemixtapes/LMTService;->mState:Lcom/livemixtapes/LMTService$State;

    .line 87
    iput-boolean v2, p0, Lcom/livemixtapes/LMTService;->mStartPlayingAfterRetrieve:Z

    .line 90
    iput-object v1, p0, Lcom/livemixtapes/LMTService;->mWhatToPlayAfterRetrieve:Landroid/net/Uri;

    .line 96
    sget-object v0, Lcom/livemixtapes/LMTService$PauseReason;->UserRequest:Lcom/livemixtapes/LMTService$PauseReason;

    iput-object v0, p0, Lcom/livemixtapes/LMTService;->mPauseReason:Lcom/livemixtapes/LMTService$PauseReason;

    .line 103
    sget-object v0, Lcom/livemixtapes/LMTService$AudioFocus;->NoFocusNoDuck:Lcom/livemixtapes/LMTService$AudioFocus;

    iput-object v0, p0, Lcom/livemixtapes/LMTService;->mAudioFocus:Lcom/livemixtapes/LMTService$AudioFocus;

    .line 105
    const-string v0, ""

    iput-object v0, p0, Lcom/livemixtapes/LMTService;->mSongTitle:Ljava/lang/String;

    .line 107
    iput-boolean v2, p0, Lcom/livemixtapes/LMTService;->mIsStreaming:Z

    .line 114
    const/4 v0, 0x1

    iput v0, p0, Lcom/livemixtapes/LMTService;->NOTIFICATION_ID:I

    .line 128
    iput-object v1, p0, Lcom/livemixtapes/LMTService;->mNotification:Landroid/app/Notification;

    .line 45
    return-void
.end method

.method private retreivePlaybackAction(I)Landroid/app/PendingIntent;
    .locals 8
    .param p1, "which"    # I
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "NewApi"
        }
    .end annotation

    .prologue
    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 736
    const/4 v0, 0x0

    .local v0, "action":Landroid/content/Intent;
    new-array v3, v7, [Ljava/lang/Object;

    .line 738
    const-string v4, "PENDING INTENT CALLED"

    aput-object v4, v3, v6

    invoke-static {v3}, Lcom/livemixtapes/console;->log([Ljava/lang/Object;)V

    new-array v3, v7, [Ljava/lang/Object;

    .line 739
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "AMPLAYING IS "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget-object v5, Lcom/livemixtapes/LMTService;->amPlaying:Ljava/lang/Boolean;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v6

    invoke-static {v3}, Lcom/livemixtapes/console;->log([Ljava/lang/Object;)V

    .line 740
    new-instance v2, Landroid/content/ComponentName;

    const-class v3, Lcom/livemixtapes/LMTService;

    invoke-direct {v2, p0, v3}, Landroid/content/ComponentName;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 750
    .local v2, "serviceName":Landroid/content/ComponentName;
    packed-switch p1, :pswitch_data_0

    .line 863
    const/4 v1, 0x0

    :goto_0
    return-object v1

    .line 753
    :pswitch_0
    const-string v3, "herp"

    const-string v4, "PLAY AND PAUSE"

    invoke-static {v3, v4}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    new-array v3, v7, [Ljava/lang/Object;

    .line 754
    const-string v4, "PLAY AN DPAUSE "

    aput-object v4, v3, v6

    invoke-static {v3}, Lcom/livemixtapes/console;->log([Ljava/lang/Object;)V

    new-array v3, v7, [Ljava/lang/Object;

    .line 829
    const-string v4, "ACTION PLAY"

    aput-object v4, v3, v6

    invoke-static {v3}, Lcom/livemixtapes/console;->log([Ljava/lang/Object;)V

    .line 831
    new-instance v0, Landroid/content/Intent;

    .end local v0    # "action":Landroid/content/Intent;
    const-string v3, "com.livemixtapes.action.PLAY"

    invoke-direct {v0, v3}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .restart local v0    # "action":Landroid/content/Intent;
    new-array v3, v7, [Ljava/lang/Object;

    .line 832
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "AMPLAYING IS "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget-object v5, Lcom/livemixtapes/LMTService;->amPlaying:Ljava/lang/Boolean;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v6

    invoke-static {v3}, Lcom/livemixtapes/console;->log([Ljava/lang/Object;)V

    .line 835
    invoke-virtual {v0, v2}, Landroid/content/Intent;->setComponent(Landroid/content/ComponentName;)Landroid/content/Intent;

    .line 836
    invoke-static {p0, v7, v0, v6}, Landroid/app/PendingIntent;->getService(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v1

    .line 837
    .local v1, "pendingIntent":Landroid/app/PendingIntent;
    goto :goto_0

    .line 841
    .end local v1    # "pendingIntent":Landroid/app/PendingIntent;
    :pswitch_1
    new-instance v0, Landroid/content/Intent;

    .end local v0    # "action":Landroid/content/Intent;
    const-string v3, "com.livemixtapes.action.SKIP"

    invoke-direct {v0, v3}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 842
    .restart local v0    # "action":Landroid/content/Intent;
    invoke-virtual {v0, v2}, Landroid/content/Intent;->setComponent(Landroid/content/ComponentName;)Landroid/content/Intent;

    .line 843
    const/4 v3, 0x2

    invoke-static {p0, v3, v0, v6}, Landroid/app/PendingIntent;->getService(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v1

    .line 844
    .restart local v1    # "pendingIntent":Landroid/app/PendingIntent;
    goto :goto_0

    .line 848
    .end local v1    # "pendingIntent":Landroid/app/PendingIntent;
    :pswitch_2
    new-instance v0, Landroid/content/Intent;

    .end local v0    # "action":Landroid/content/Intent;
    const-string v3, "com.livemixtapes.action.REWIND"

    invoke-direct {v0, v3}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 849
    .restart local v0    # "action":Landroid/content/Intent;
    invoke-virtual {v0, v2}, Landroid/content/Intent;->setComponent(Landroid/content/ComponentName;)Landroid/content/Intent;

    .line 850
    const/4 v3, 0x3

    invoke-static {p0, v3, v0, v6}, Landroid/app/PendingIntent;->getService(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v1

    .line 851
    .restart local v1    # "pendingIntent":Landroid/app/PendingIntent;
    goto :goto_0

    .line 855
    .end local v1    # "pendingIntent":Landroid/app/PendingIntent;
    :pswitch_3
    new-instance v0, Landroid/content/Intent;

    .end local v0    # "action":Landroid/content/Intent;
    const-string v3, "com.livemixtapes.action.STOP"

    invoke-direct {v0, v3}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 856
    .restart local v0    # "action":Landroid/content/Intent;
    invoke-virtual {v0, v2}, Landroid/content/Intent;->setComponent(Landroid/content/ComponentName;)Landroid/content/Intent;

    .line 857
    const/4 v3, 0x4

    invoke-static {p0, v3, v0, v6}, Landroid/app/PendingIntent;->getService(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v1

    .line 858
    .restart local v1    # "pendingIntent":Landroid/app/PendingIntent;
    goto :goto_0

    .line 750
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method


# virtual methods
.method configAndStartMediaPlayer()V
    .locals 4

    .prologue
    const/high16 v3, 0x3f800000    # 1.0f

    const v2, 0x3dcccccd    # 0.1f

    .line 343
    iget-object v0, p0, Lcom/livemixtapes/LMTService;->mAudioFocus:Lcom/livemixtapes/LMTService$AudioFocus;

    sget-object v1, Lcom/livemixtapes/LMTService$AudioFocus;->NoFocusNoDuck:Lcom/livemixtapes/LMTService$AudioFocus;

    if-ne v0, v1, :cond_1

    .line 347
    sget-object v0, Lcom/livemixtapes/LMTService;->mPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->isPlaying()Z

    move-result v0

    if-eqz v0, :cond_0

    sget-object v0, Lcom/livemixtapes/LMTService;->mPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->pause()V

    .line 355
    :cond_0
    :goto_0
    return-void

    .line 350
    :cond_1
    iget-object v0, p0, Lcom/livemixtapes/LMTService;->mAudioFocus:Lcom/livemixtapes/LMTService$AudioFocus;

    sget-object v1, Lcom/livemixtapes/LMTService$AudioFocus;->NoFocusCanDuck:Lcom/livemixtapes/LMTService$AudioFocus;

    if-ne v0, v1, :cond_2

    .line 351
    sget-object v0, Lcom/livemixtapes/LMTService;->mPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0, v2, v2}, Landroid/media/MediaPlayer;->setVolume(FF)V

    .line 354
    :goto_1
    sget-object v0, Lcom/livemixtapes/LMTService;->mPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->isPlaying()Z

    move-result v0

    if-nez v0, :cond_0

    sget-object v0, Lcom/livemixtapes/LMTService;->mPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->start()V

    goto :goto_0

    .line 353
    :cond_2
    sget-object v0, Lcom/livemixtapes/LMTService;->mPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0, v3, v3}, Landroid/media/MediaPlayer;->setVolume(FF)V

    goto :goto_1
.end method

.method createMediaPlayerIfNeeded()V
    .locals 3

    .prologue
    .line 134
    sget-object v0, Lcom/livemixtapes/LMTService;->mPlayer:Landroid/media/MediaPlayer;

    if-nez v0, :cond_0

    .line 135
    new-instance v0, Landroid/media/MediaPlayer;

    invoke-direct {v0}, Landroid/media/MediaPlayer;-><init>()V

    sput-object v0, Lcom/livemixtapes/LMTService;->mPlayer:Landroid/media/MediaPlayer;

    .line 141
    sget-object v0, Lcom/livemixtapes/LMTService;->mPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {p0}, Lcom/livemixtapes/LMTService;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Landroid/media/MediaPlayer;->setWakeMode(Landroid/content/Context;I)V

    .line 144
    sget-object v0, Lcom/livemixtapes/LMTService;->mPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0, p0}, Landroid/media/MediaPlayer;->setOnPreparedListener(Landroid/media/MediaPlayer$OnPreparedListener;)V

    .line 145
    sget-object v0, Lcom/livemixtapes/LMTService;->mPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0, p0}, Landroid/media/MediaPlayer;->setOnCompletionListener(Landroid/media/MediaPlayer$OnCompletionListener;)V

    .line 146
    sget-object v0, Lcom/livemixtapes/LMTService;->mPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0, p0}, Landroid/media/MediaPlayer;->setOnErrorListener(Landroid/media/MediaPlayer$OnErrorListener;)V

    .line 150
    :goto_0
    return-void

    .line 149
    :cond_0
    sget-object v0, Lcom/livemixtapes/LMTService;->mPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->reset()V

    goto :goto_0
.end method

.method giveUpAudioFocus()V
    .locals 2

    .prologue
    .line 330
    iget-object v0, p0, Lcom/livemixtapes/LMTService;->mAudioFocus:Lcom/livemixtapes/LMTService$AudioFocus;

    sget-object v1, Lcom/livemixtapes/LMTService$AudioFocus;->Focused:Lcom/livemixtapes/LMTService$AudioFocus;

    if-ne v0, v1, :cond_0

    iget-object v0, p0, Lcom/livemixtapes/LMTService;->mAudioFocusHelper:Lcom/livemixtapes/AudioFocusHelper;

    if-eqz v0, :cond_0

    .line 331
    iget-object v0, p0, Lcom/livemixtapes/LMTService;->mAudioFocusHelper:Lcom/livemixtapes/AudioFocusHelper;

    invoke-virtual {v0}, Lcom/livemixtapes/AudioFocusHelper;->abandonFocus()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 332
    sget-object v0, Lcom/livemixtapes/LMTService$AudioFocus;->NoFocusNoDuck:Lcom/livemixtapes/LMTService$AudioFocus;

    iput-object v0, p0, Lcom/livemixtapes/LMTService;->mAudioFocus:Lcom/livemixtapes/LMTService$AudioFocus;

    .line 333
    :cond_0
    return-void
.end method

.method public onBind(Landroid/content/Intent;)Landroid/os/IBinder;
    .locals 1
    .param p1, "arg0"    # Landroid/content/Intent;

    .prologue
    .line 714
    const/4 v0, 0x0

    return-object v0
.end method

.method public onCompletion(Landroid/media/MediaPlayer;)V
    .locals 0
    .param p1, "player"    # Landroid/media/MediaPlayer;

    .prologue
    .line 636
    invoke-static {}, Lcom/livemixtapes/NowPlayingActivity;->nextTrack()V

    .line 637
    return-void
.end method

.method public onCreate()V
    .locals 3

    .prologue
    .line 153
    const-string v0, "livemixtapesPlayer"

    const-string v1, "debug: Creating service"

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 155
    const-string v0, "wifi"

    invoke-virtual {p0, v0}, Lcom/livemixtapes/LMTService;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/net/wifi/WifiManager;

    .line 156
    const/4 v1, 0x1

    const-string v2, "mylock"

    invoke-virtual {v0, v1, v2}, Landroid/net/wifi/WifiManager;->createWifiLock(ILjava/lang/String;)Landroid/net/wifi/WifiManager$WifiLock;

    move-result-object v0

    .line 155
    iput-object v0, p0, Lcom/livemixtapes/LMTService;->mWifiLock:Landroid/net/wifi/WifiManager$WifiLock;

    .line 157
    const-string v0, "notification"

    invoke-virtual {p0, v0}, Lcom/livemixtapes/LMTService;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/NotificationManager;

    iput-object v0, p0, Lcom/livemixtapes/LMTService;->mNotificationManager:Landroid/app/NotificationManager;

    .line 158
    const-string v0, "audio"

    invoke-virtual {p0, v0}, Lcom/livemixtapes/LMTService;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/media/AudioManager;

    iput-object v0, p0, Lcom/livemixtapes/LMTService;->mAudioManager:Landroid/media/AudioManager;

    .line 160
    new-instance v0, Lcom/livemixtapes/MusicRetriever;

    invoke-virtual {p0}, Lcom/livemixtapes/LMTService;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/livemixtapes/MusicRetriever;-><init>(Landroid/content/ContentResolver;)V

    iput-object v0, p0, Lcom/livemixtapes/LMTService;->mRetriever:Lcom/livemixtapes/MusicRetriever;

    .line 161
    new-instance v0, Lcom/livemixtapes/PrepareMusicRetrieverTask;

    iget-object v1, p0, Lcom/livemixtapes/LMTService;->mRetriever:Lcom/livemixtapes/MusicRetriever;

    invoke-direct {v0, v1, p0}, Lcom/livemixtapes/PrepareMusicRetrieverTask;-><init>(Lcom/livemixtapes/MusicRetriever;Lcom/livemixtapes/PrepareMusicRetrieverTask$MusicRetrieverPreparedListener;)V

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Void;

    invoke-virtual {v0, v1}, Lcom/livemixtapes/PrepareMusicRetrieverTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 163
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x8

    if-lt v0, v1, :cond_0

    .line 164
    new-instance v0, Lcom/livemixtapes/AudioFocusHelper;

    invoke-virtual {p0}, Lcom/livemixtapes/LMTService;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1, p0}, Lcom/livemixtapes/AudioFocusHelper;-><init>(Landroid/content/Context;Lcom/livemixtapes/MusicFocusable;)V

    iput-object v0, p0, Lcom/livemixtapes/LMTService;->mAudioFocusHelper:Lcom/livemixtapes/AudioFocusHelper;

    .line 167
    :goto_0
    invoke-virtual {p0}, Lcom/livemixtapes/LMTService;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f0200a4

    invoke-static {v0, v1}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v0

    iput-object v0, p0, Lcom/livemixtapes/LMTService;->mDummyAlbumArt:Landroid/graphics/Bitmap;

    .line 168
    new-instance v0, Landroid/content/ComponentName;

    const-class v1, Lcom/livemixtapes/MusicIntentReceiver;

    invoke-direct {v0, p0, v1}, Landroid/content/ComponentName;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    iput-object v0, p0, Lcom/livemixtapes/LMTService;->mMediaButtonReceiverComponent:Landroid/content/ComponentName;

    .line 169
    return-void

    .line 166
    :cond_0
    sget-object v0, Lcom/livemixtapes/LMTService$AudioFocus;->Focused:Lcom/livemixtapes/LMTService$AudioFocus;

    iput-object v0, p0, Lcom/livemixtapes/LMTService;->mAudioFocus:Lcom/livemixtapes/LMTService$AudioFocus;

    goto :goto_0
.end method

.method public onDestroy()V
    .locals 3

    .prologue
    .line 703
    sget-object v1, Lcom/livemixtapes/App;->context:Landroid/content/Context;

    const-string v2, "notification"

    invoke-virtual {v1, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/NotificationManager;

    .line 704
    .local v0, "mNotifyManager":Landroid/app/NotificationManager;
    invoke-virtual {v0}, Landroid/app/NotificationManager;->cancelAll()V

    .line 707
    sget-object v1, Lcom/livemixtapes/LMTService$State;->Stopped:Lcom/livemixtapes/LMTService$State;

    iput-object v1, p0, Lcom/livemixtapes/LMTService;->mState:Lcom/livemixtapes/LMTService$State;

    .line 708
    const/4 v1, 0x1

    invoke-virtual {p0, v1}, Lcom/livemixtapes/LMTService;->relaxResources(Z)V

    .line 709
    invoke-virtual {p0}, Lcom/livemixtapes/LMTService;->giveUpAudioFocus()V

    .line 710
    return-void
.end method

.method public onError(Landroid/media/MediaPlayer;II)Z
    .locals 3
    .param p1, "mp"    # Landroid/media/MediaPlayer;
    .param p2, "what"    # I
    .param p3, "extra"    # I

    .prologue
    .line 664
    invoke-virtual {p0}, Lcom/livemixtapes/LMTService;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    const-string v1, "Media player error! Resetting."

    .line 665
    const/4 v2, 0x0

    .line 664
    invoke-static {v0, v1, v2}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    .line 665
    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    .line 666
    const-string v0, "livemixtapesPlayer"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Error: what="

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {p2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", extra="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {p3}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 670
    const/4 v0, 0x1

    return v0
.end method

.method public onGainedAudioFocus()V
    .locals 3

    .prologue
    .line 674
    invoke-virtual {p0}, Lcom/livemixtapes/LMTService;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    const-string v1, "gained audio focus."

    const/4 v2, 0x0

    invoke-static {v0, v1, v2}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    .line 675
    sget-object v0, Lcom/livemixtapes/LMTService$AudioFocus;->Focused:Lcom/livemixtapes/LMTService$AudioFocus;

    iput-object v0, p0, Lcom/livemixtapes/LMTService;->mAudioFocus:Lcom/livemixtapes/LMTService$AudioFocus;

    .line 677
    iget-object v0, p0, Lcom/livemixtapes/LMTService;->mState:Lcom/livemixtapes/LMTService$State;

    sget-object v1, Lcom/livemixtapes/LMTService$State;->Playing:Lcom/livemixtapes/LMTService$State;

    if-ne v0, v1, :cond_0

    .line 678
    invoke-virtual {p0}, Lcom/livemixtapes/LMTService;->configAndStartMediaPlayer()V

    .line 679
    :cond_0
    return-void
.end method

.method public onLostAudioFocus(Z)V
    .locals 3
    .param p1, "canDuck"    # Z

    .prologue
    .line 682
    invoke-virtual {p0}, Lcom/livemixtapes/LMTService;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v0, "lost audio focus."

    invoke-direct {v2, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    if-eqz p1, :cond_1

    const-string v0, "can duck"

    .line 683
    :goto_0
    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    const/4 v2, 0x0

    .line 682
    invoke-static {v1, v0, v2}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    .line 683
    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    .line 684
    if-eqz p1, :cond_2

    sget-object v0, Lcom/livemixtapes/LMTService$AudioFocus;->NoFocusCanDuck:Lcom/livemixtapes/LMTService$AudioFocus;

    :goto_1
    iput-object v0, p0, Lcom/livemixtapes/LMTService;->mAudioFocus:Lcom/livemixtapes/LMTService$AudioFocus;

    .line 686
    sget-object v0, Lcom/livemixtapes/LMTService;->mPlayer:Landroid/media/MediaPlayer;

    if-eqz v0, :cond_0

    sget-object v0, Lcom/livemixtapes/LMTService;->mPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->isPlaying()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 687
    invoke-virtual {p0}, Lcom/livemixtapes/LMTService;->configAndStartMediaPlayer()V

    .line 688
    :cond_0
    return-void

    .line 683
    :cond_1
    const-string v0, "no duck"

    goto :goto_0

    .line 684
    :cond_2
    sget-object v0, Lcom/livemixtapes/LMTService$AudioFocus;->NoFocusNoDuck:Lcom/livemixtapes/LMTService$AudioFocus;

    goto :goto_1
.end method

.method public onMusicRetrieverPrepared()V
    .locals 1

    .prologue
    .line 692
    sget-object v0, Lcom/livemixtapes/LMTService$State;->Stopped:Lcom/livemixtapes/LMTService$State;

    iput-object v0, p0, Lcom/livemixtapes/LMTService;->mState:Lcom/livemixtapes/LMTService$State;

    .line 694
    iget-boolean v0, p0, Lcom/livemixtapes/LMTService;->mStartPlayingAfterRetrieve:Z

    if-eqz v0, :cond_0

    .line 695
    invoke-virtual {p0}, Lcom/livemixtapes/LMTService;->tryToGetAudioFocus()V

    .line 696
    iget-object v0, p0, Lcom/livemixtapes/LMTService;->mWhatToPlayAfterRetrieve:Landroid/net/Uri;

    if-nez v0, :cond_1

    .line 697
    const/4 v0, 0x0

    .line 696
    :goto_0
    invoke-virtual {p0, v0}, Lcom/livemixtapes/LMTService;->playNextSong(Ljava/lang/String;)V

    .line 699
    :cond_0
    return-void

    .line 697
    :cond_1
    iget-object v0, p0, Lcom/livemixtapes/LMTService;->mWhatToPlayAfterRetrieve:Landroid/net/Uri;

    invoke-virtual {v0}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public onPrepared(Landroid/media/MediaPlayer;)V
    .locals 2
    .param p1, "player"    # Landroid/media/MediaPlayer;

    .prologue
    .line 642
    sget-object v0, Lcom/livemixtapes/LMTService$State;->Playing:Lcom/livemixtapes/LMTService$State;

    iput-object v0, p0, Lcom/livemixtapes/LMTService;->mState:Lcom/livemixtapes/LMTService$State;

    .line 643
    new-instance v0, Ljava/lang/StringBuilder;

    iget-object v1, p0, Lcom/livemixtapes/LMTService;->mSongTitle:Ljava/lang/String;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v1, " (playing)"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/livemixtapes/LMTService;->updateNotification(Ljava/lang/String;)V

    .line 644
    invoke-virtual {p0}, Lcom/livemixtapes/LMTService;->configAndStartMediaPlayer()V

    .line 645
    return-void
.end method

.method public onStartCommand(Landroid/content/Intent;II)I
    .locals 6
    .param p1, "intent"    # Landroid/content/Intent;
    .param p2, "flags"    # I
    .param p3, "startId"    # I

    .prologue
    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 177
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    .local v0, "action":Ljava/lang/String;
    new-array v1, v5, [Ljava/lang/Object;

    .line 178
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "ACTION: "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    aput-object v2, v1, v4

    invoke-static {v1}, Lcom/livemixtapes/console;->log([Ljava/lang/Object;)V

    .line 181
    const-string v1, "com.livemixtapes.action.TOGGLE_PLAYBACK"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    invoke-virtual {p0}, Lcom/livemixtapes/LMTService;->processTogglePlaybackRequest()V

    .line 194
    :cond_0
    :goto_0
    const/4 v1, 0x2

    return v1

    .line 182
    :cond_1
    const-string v1, "com.livemixtapes.action.PLAY"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    invoke-virtual {p0}, Lcom/livemixtapes/LMTService;->processPlayRequest()V

    goto :goto_0

    .line 183
    :cond_2
    const-string v1, "com.livemixtapes.action.PAUSE"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    invoke-virtual {p0}, Lcom/livemixtapes/LMTService;->processPauseRequest()V

    goto :goto_0

    .line 184
    :cond_3
    const-string v1, "com.livemixtapes.action.SKIP"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_4

    invoke-virtual {p0}, Lcom/livemixtapes/LMTService;->processSkipRequest()V

    goto :goto_0

    .line 185
    :cond_4
    const-string v1, "com.livemixtapes.action.STOP"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_5

    invoke-virtual {p0}, Lcom/livemixtapes/LMTService;->processStopRequest()V

    goto :goto_0

    .line 186
    :cond_5
    const-string v1, "com.livemixtapes.action.REWIND"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_6

    invoke-virtual {p0}, Lcom/livemixtapes/LMTService;->processRewindRequest()V

    goto :goto_0

    .line 187
    :cond_6
    const-string v1, "com.livemixtapes.action.URL"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_7

    invoke-virtual {p0, p1}, Lcom/livemixtapes/LMTService;->processAddRequest(Landroid/content/Intent;)V

    goto :goto_0

    .line 188
    :cond_7
    const-string v1, "com.livemixtapes.action.IMAGE"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 189
    new-array v1, v5, [Ljava/lang/Object;

    .line 190
    const-string v2, "PROCESSING IMAGE DAWG"

    aput-object v2, v1, v4

    invoke-static {v1}, Lcom/livemixtapes/console;->log([Ljava/lang/Object;)V

    .line 191
    invoke-virtual {p0}, Lcom/livemixtapes/LMTService;->processImageRequest()V

    goto :goto_0
.end method

.method playNextSong(Ljava/lang/String;)V
    .locals 18
    .param p1, "manualUrl"    # Ljava/lang/String;
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "NewApi"
        }
    .end annotation

    .prologue
    .line 393
    sget-object v2, Lcom/livemixtapes/LMTService$State;->Stopped:Lcom/livemixtapes/LMTService$State;

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/livemixtapes/LMTService;->mState:Lcom/livemixtapes/LMTService$State;

    .line 394
    const/4 v2, 0x0

    move-object/from16 v0, p0

    invoke-virtual {v0, v2}, Lcom/livemixtapes/LMTService;->relaxResources(Z)V

    .line 396
    const/16 v16, 0x0

    .line 397
    .local v16, "playingItem":Lcom/livemixtapes/MusicRetriever$Item;
    if-eqz p1, :cond_3

    .line 399
    :try_start_0
    invoke-virtual/range {p0 .. p0}, Lcom/livemixtapes/LMTService;->createMediaPlayerIfNeeded()V

    .line 400
    sget-object v2, Lcom/livemixtapes/LMTService;->mPlayer:Landroid/media/MediaPlayer;

    const/4 v3, 0x3

    invoke-virtual {v2, v3}, Landroid/media/MediaPlayer;->setAudioStreamType(I)V

    .line 401
    sget-object v2, Lcom/livemixtapes/LMTService;->mPlayer:Landroid/media/MediaPlayer;

    move-object/from16 v0, p1

    invoke-virtual {v2, v0}, Landroid/media/MediaPlayer;->setDataSource(Ljava/lang/String;)V

    .line 402
    const-string v2, "http:"

    move-object/from16 v0, p1

    invoke-virtual {v0, v2}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_2

    const-string v2, "https:"

    move-object/from16 v0, p1

    invoke-virtual {v0, v2}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_2

    const/4 v2, 0x0

    :goto_0
    move-object/from16 v0, p0

    iput-boolean v2, v0, Lcom/livemixtapes/LMTService;->mIsStreaming:Z

    .line 403
    new-instance v1, Lcom/livemixtapes/MusicRetriever$Item;

    const-wide/16 v2, 0x0

    const/4 v4, 0x0

    const/4 v6, 0x0

    const-wide/16 v7, 0x0

    move-object/from16 v5, p1

    invoke-direct/range {v1 .. v8}, Lcom/livemixtapes/MusicRetriever$Item;-><init>(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_3

    .line 422
    .end local v16    # "playingItem":Lcom/livemixtapes/MusicRetriever$Item;
    .local v1, "playingItem":Lcom/livemixtapes/MusicRetriever$Item;
    :goto_1
    :try_start_1
    const-string v2, ""

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/livemixtapes/LMTService;->mSongTitle:Ljava/lang/String;
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0

    .line 424
    :try_start_2
    const-string v2, " "

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/livemixtapes/LMTService;->mSongTitle:Ljava/lang/String;
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_4
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_0

    .line 430
    :goto_2
    :try_start_3
    sget-object v2, Lcom/livemixtapes/LMTService$State;->Preparing:Lcom/livemixtapes/LMTService$State;

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/livemixtapes/LMTService;->mState:Lcom/livemixtapes/LMTService$State;

    .line 431
    new-instance v2, Ljava/lang/StringBuilder;

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/livemixtapes/LMTService;->mSongTitle:Ljava/lang/String;

    invoke-static {v3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v3, " (loading)"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    move-object/from16 v0, p0

    invoke-virtual {v0, v2}, Lcom/livemixtapes/LMTService;->setUpAsForeground(Ljava/lang/String;)V

    .line 449
    sget v2, Landroid/os/Build$VERSION;->SDK_INT:I
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_0

    const/16 v3, 0x15

    if-lt v2, v3, :cond_6

    .line 452
    const/16 v17, 0x0

    .line 455
    .local v17, "tempBitmap":Landroid/graphics/Bitmap;
    :try_start_4
    new-instance v2, Lcom/livemixtapes/BitmapDownloader;

    invoke-direct {v2}, Lcom/livemixtapes/BitmapDownloader;-><init>()V

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    sget-object v5, Lcom/livemixtapes/NowPlayingActivity;->thumbURL:Ljava/lang/String;

    aput-object v5, v3, v4

    invoke-virtual {v2, v3}, Lcom/livemixtapes/BitmapDownloader;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    move-result-object v2

    invoke-virtual {v2}, Landroid/os/AsyncTask;->get()Ljava/lang/Object;

    move-result-object v2

    move-object v0, v2

    check-cast v0, Landroid/graphics/Bitmap;

    move-object/from16 v17, v0
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_1
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_0

    .line 463
    :goto_3
    :try_start_5
    sget-object v2, Lcom/livemixtapes/LMTService;->mediaSession:Landroid/media/session/MediaSession;

    if-eqz v2, :cond_0

    .line 464
    sget-object v2, Lcom/livemixtapes/LMTService;->mediaSession:Landroid/media/session/MediaSession;

    invoke-virtual {v2}, Landroid/media/session/MediaSession;->release()V

    .line 467
    :cond_0
    new-instance v2, Landroid/media/session/MediaSession;

    const-string v3, "LMT"

    move-object/from16 v0, p0

    invoke-direct {v2, v0, v3}, Landroid/media/session/MediaSession;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    sput-object v2, Lcom/livemixtapes/LMTService;->mediaSession:Landroid/media/session/MediaSession;

    .line 469
    sget-object v2, Lcom/livemixtapes/LMTService;->mediaSession:Landroid/media/session/MediaSession;

    new-instance v3, Landroid/media/MediaMetadata$Builder;

    invoke-direct {v3}, Landroid/media/MediaMetadata$Builder;-><init>()V

    .line 470
    const-string v4, "android.media.metadata.ALBUM_ART"

    move-object/from16 v0, v17

    invoke-virtual {v3, v4, v0}, Landroid/media/MediaMetadata$Builder;->putBitmap(Ljava/lang/String;Landroid/graphics/Bitmap;)Landroid/media/MediaMetadata$Builder;

    move-result-object v3

    .line 471
    const-string v4, "android.media.metadata.ARTIST"

    sget-object v5, Lcom/livemixtapes/NowPlayingActivity;->artist:Ljava/lang/String;

    invoke-virtual {v3, v4, v5}, Landroid/media/MediaMetadata$Builder;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/media/MediaMetadata$Builder;

    move-result-object v3

    .line 472
    const-string v4, "android.media.metadata.ALBUM"

    sget-object v5, Lcom/livemixtapes/NowPlayingActivity;->tape:Ljava/lang/String;

    invoke-virtual {v3, v4, v5}, Landroid/media/MediaMetadata$Builder;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/media/MediaMetadata$Builder;

    move-result-object v3

    .line 473
    const-string v4, "android.media.metadata.TITLE"

    sget-object v5, Lcom/livemixtapes/NowPlayingActivity;->title:Ljava/lang/String;

    invoke-virtual {v3, v4, v5}, Landroid/media/MediaMetadata$Builder;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/media/MediaMetadata$Builder;

    move-result-object v3

    .line 474
    invoke-virtual {v3}, Landroid/media/MediaMetadata$Builder;->build()Landroid/media/MediaMetadata;

    move-result-object v3

    .line 469
    invoke-virtual {v2, v3}, Landroid/media/session/MediaSession;->setMetadata(Landroid/media/MediaMetadata;)V

    .line 476
    sget-object v2, Lcom/livemixtapes/LMTService;->mediaSession:Landroid/media/session/MediaSession;

    const/4 v3, 0x1

    invoke-virtual {v2, v3}, Landroid/media/session/MediaSession;->setActive(Z)V

    .line 479
    sget-object v2, Lcom/livemixtapes/LMTService;->mediaSession:Landroid/media/session/MediaSession;

    new-instance v3, Lcom/livemixtapes/LMTService$1;

    move-object/from16 v0, p0

    invoke-direct {v3, v0}, Lcom/livemixtapes/LMTService$1;-><init>(Lcom/livemixtapes/LMTService;)V

    invoke-virtual {v2, v3}, Landroid/media/session/MediaSession;->setCallback(Landroid/media/session/MediaSession$Callback;)V

    .line 485
    sget-object v2, Lcom/livemixtapes/LMTService;->mediaSession:Landroid/media/session/MediaSession;

    const/4 v3, 0x2

    invoke-virtual {v2, v3}, Landroid/media/session/MediaSession;->setFlags(I)V

    .line 487
    new-instance v14, Landroid/content/Intent;

    const-class v2, Lcom/livemixtapes/NowPlayingActivity;

    move-object/from16 v0, p0

    invoke-direct {v14, v0, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 488
    .local v14, "notificationIntent":Landroid/content/Intent;
    const/4 v2, 0x0

    .line 489
    const/4 v3, 0x0

    .line 488
    move-object/from16 v0, p0

    invoke-static {v0, v2, v14, v3}, Landroid/app/PendingIntent;->getActivity(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v15

    .line 492
    .local v15, "pendingIntent":Landroid/app/PendingIntent;
    sget-object v2, Lcom/livemixtapes/NowPlayingActivity;->artist:Ljava/lang/String;

    const-string v3, ""

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_5

    .line 494
    sget-object v2, Lcom/livemixtapes/NowPlayingActivity;->title:Ljava/lang/String;

    sput-object v2, Lcom/livemixtapes/LMTService;->temp_title:Ljava/lang/String;

    .line 501
    :goto_4
    new-instance v2, Landroid/app/Notification$Builder;

    move-object/from16 v0, p0

    invoke-direct {v2, v0}, Landroid/app/Notification$Builder;-><init>(Landroid/content/Context;)V

    .line 504
    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/app/Notification$Builder;->setAutoCancel(Z)Landroid/app/Notification$Builder;

    move-result-object v2

    .line 505
    const/4 v3, 0x1

    invoke-virtual {v2, v3}, Landroid/app/Notification$Builder;->setOngoing(Z)Landroid/app/Notification$Builder;

    move-result-object v2

    .line 507
    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/app/Notification$Builder;->setShowWhen(Z)Landroid/app/Notification$Builder;

    move-result-object v2

    .line 510
    new-instance v3, Landroid/app/Notification$MediaStyle;

    invoke-direct {v3}, Landroid/app/Notification$MediaStyle;-><init>()V

    .line 512
    sget-object v4, Lcom/livemixtapes/LMTService;->mediaSession:Landroid/media/session/MediaSession;

    invoke-virtual {v4}, Landroid/media/session/MediaSession;->getSessionToken()Landroid/media/session/MediaSession$Token;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/app/Notification$MediaStyle;->setMediaSession(Landroid/media/session/MediaSession$Token;)Landroid/app/Notification$MediaStyle;

    move-result-object v3

    const/4 v4, 0x3

    new-array v4, v4, [I

    fill-array-data v4, :array_0

    .line 514
    invoke-virtual {v3, v4}, Landroid/app/Notification$MediaStyle;->setShowActionsInCompactView([I)Landroid/app/Notification$MediaStyle;

    move-result-object v3

    .line 510
    invoke-virtual {v2, v3}, Landroid/app/Notification$Builder;->setStyle(Landroid/app/Notification$Style;)Landroid/app/Notification$Builder;

    move-result-object v2

    .line 516
    const v3, -0xffba81

    invoke-virtual {v2, v3}, Landroid/app/Notification$Builder;->setColor(I)Landroid/app/Notification$Builder;

    move-result-object v2

    .line 518
    move-object/from16 v0, v17

    invoke-virtual {v2, v0}, Landroid/app/Notification$Builder;->setLargeIcon(Landroid/graphics/Bitmap;)Landroid/app/Notification$Builder;

    move-result-object v2

    .line 519
    const v3, 0x7f02005b

    invoke-virtual {v2, v3}, Landroid/app/Notification$Builder;->setSmallIcon(I)Landroid/app/Notification$Builder;

    move-result-object v2

    .line 521
    const-string v3, ""

    invoke-virtual {v2, v3}, Landroid/app/Notification$Builder;->setContentText(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;

    move-result-object v2

    .line 522
    const-string v3, ""

    invoke-virtual {v2, v3}, Landroid/app/Notification$Builder;->setContentInfo(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;

    move-result-object v2

    .line 523
    sget-object v3, Lcom/livemixtapes/LMTService;->temp_title:Ljava/lang/String;

    invoke-virtual {v2, v3}, Landroid/app/Notification$Builder;->setContentTitle(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;

    move-result-object v2

    .line 525
    invoke-virtual {v2, v15}, Landroid/app/Notification$Builder;->setContentIntent(Landroid/app/PendingIntent;)Landroid/app/Notification$Builder;

    move-result-object v2

    .line 528
    const v3, 0x7f0200a8

    const-string v4, "prev"

    const/4 v5, 0x3

    move-object/from16 v0, p0

    invoke-direct {v0, v5}, Lcom/livemixtapes/LMTService;->retreivePlaybackAction(I)Landroid/app/PendingIntent;

    move-result-object v5

    invoke-virtual {v2, v3, v4, v5}, Landroid/app/Notification$Builder;->addAction(ILjava/lang/CharSequence;Landroid/app/PendingIntent;)Landroid/app/Notification$Builder;

    move-result-object v2

    .line 529
    const v3, 0x7f0200a6

    const-string v4, "pause"

    const/4 v5, 0x1

    move-object/from16 v0, p0

    invoke-direct {v0, v5}, Lcom/livemixtapes/LMTService;->retreivePlaybackAction(I)Landroid/app/PendingIntent;

    move-result-object v5

    invoke-virtual {v2, v3, v4, v5}, Landroid/app/Notification$Builder;->addAction(ILjava/lang/CharSequence;Landroid/app/PendingIntent;)Landroid/app/Notification$Builder;

    move-result-object v2

    .line 530
    const v3, 0x7f0200a5

    const-string v4, "next"

    const/4 v5, 0x2

    move-object/from16 v0, p0

    invoke-direct {v0, v5}, Lcom/livemixtapes/LMTService;->retreivePlaybackAction(I)Landroid/app/PendingIntent;

    move-result-object v5

    invoke-virtual {v2, v3, v4, v5}, Landroid/app/Notification$Builder;->addAction(ILjava/lang/CharSequence;Landroid/app/PendingIntent;)Landroid/app/Notification$Builder;

    move-result-object v2

    .line 531
    const v3, 0x7f0200a0

    const-string v4, "close"

    const/4 v5, 0x4

    move-object/from16 v0, p0

    invoke-direct {v0, v5}, Lcom/livemixtapes/LMTService;->retreivePlaybackAction(I)Landroid/app/PendingIntent;

    move-result-object v5

    invoke-virtual {v2, v3, v4, v5}, Landroid/app/Notification$Builder;->addAction(ILjava/lang/CharSequence;Landroid/app/PendingIntent;)Landroid/app/Notification$Builder;

    move-result-object v2

    .line 532
    invoke-virtual {v2}, Landroid/app/Notification$Builder;->build()Landroid/app/Notification;

    move-result-object v13

    .line 535
    .local v13, "noti":Landroid/app/Notification;
    sget-object v2, Lcom/livemixtapes/LMTService;->mediaSession:Landroid/media/session/MediaSession;

    invoke-virtual {v2}, Landroid/media/session/MediaSession;->getController()Landroid/media/session/MediaController;

    move-result-object v2

    invoke-virtual {v2}, Landroid/media/session/MediaController;->getTransportControls()Landroid/media/session/MediaController$TransportControls;

    move-result-object v9

    .line 536
    .local v9, "controls":Landroid/media/session/MediaController$TransportControls;
    const/4 v2, 0x1

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    sput-object v2, Lcom/livemixtapes/LMTService;->amPlaying:Ljava/lang/Boolean;

    .line 537
    const-string v2, "notification"

    move-object/from16 v0, p0

    invoke-virtual {v0, v2}, Lcom/livemixtapes/LMTService;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/app/NotificationManager;

    const/4 v3, 0x1

    invoke-virtual {v2, v3, v13}, Landroid/app/NotificationManager;->notify(ILandroid/app/Notification;)V

    .line 612
    .end local v9    # "controls":Landroid/media/session/MediaController$TransportControls;
    .end local v13    # "noti":Landroid/app/Notification;
    .end local v14    # "notificationIntent":Landroid/content/Intent;
    .end local v15    # "pendingIntent":Landroid/app/PendingIntent;
    :goto_5
    sget-object v2, Lcom/livemixtapes/LMTService;->mPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v2}, Landroid/media/MediaPlayer;->prepareAsync()V

    .line 622
    move-object/from16 v0, p0

    iget-boolean v2, v0, Lcom/livemixtapes/LMTService;->mIsStreaming:Z

    if-eqz v2, :cond_9

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/livemixtapes/LMTService;->mWifiLock:Landroid/net/wifi/WifiManager$WifiLock;

    invoke-virtual {v2}, Landroid/net/wifi/WifiManager$WifiLock;->acquire()V
    :try_end_5
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_0

    .line 629
    .end local v17    # "tempBitmap":Landroid/graphics/Bitmap;
    :cond_1
    :goto_6
    return-void

    .line 402
    .end local v1    # "playingItem":Lcom/livemixtapes/MusicRetriever$Item;
    .restart local v16    # "playingItem":Lcom/livemixtapes/MusicRetriever$Item;
    :cond_2
    const/4 v2, 0x1

    goto/16 :goto_0

    .line 406
    :cond_3
    const/4 v2, 0x0

    :try_start_6
    move-object/from16 v0, p0

    iput-boolean v2, v0, Lcom/livemixtapes/LMTService;->mIsStreaming:Z

    .line 407
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/livemixtapes/LMTService;->mRetriever:Lcom/livemixtapes/MusicRetriever;

    invoke-virtual {v2}, Lcom/livemixtapes/MusicRetriever;->getRandomItem()Lcom/livemixtapes/MusicRetriever$Item;
    :try_end_6
    .catch Ljava/io/IOException; {:try_start_6 .. :try_end_6} :catch_3

    move-result-object v1

    .line 408
    .end local v16    # "playingItem":Lcom/livemixtapes/MusicRetriever$Item;
    .restart local v1    # "playingItem":Lcom/livemixtapes/MusicRetriever$Item;
    if-nez v1, :cond_4

    .line 410
    :try_start_7
    const-string v2, "No available music to play. Place some music on your external storage device (e.g. your SD card) and try again."

    .line 412
    const/4 v3, 0x1

    .line 409
    move-object/from16 v0, p0

    invoke-static {v0, v2, v3}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v2

    .line 412
    invoke-virtual {v2}, Landroid/widget/Toast;->show()V

    .line 413
    const/4 v2, 0x1

    move-object/from16 v0, p0

    invoke-virtual {v0, v2}, Lcom/livemixtapes/LMTService;->processStopRequest(Z)V
    :try_end_7
    .catch Ljava/io/IOException; {:try_start_7 .. :try_end_7} :catch_0

    goto :goto_6

    .line 625
    :catch_0
    move-exception v11

    .line 626
    .local v11, "ex":Ljava/io/IOException;
    :goto_7
    const-string v2, "MusicService"

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "IOException playing next song: "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v11}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 627
    invoke-virtual {v11}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_6

    .line 417
    .end local v11    # "ex":Ljava/io/IOException;
    :cond_4
    :try_start_8
    invoke-virtual/range {p0 .. p0}, Lcom/livemixtapes/LMTService;->createMediaPlayerIfNeeded()V

    .line 418
    sget-object v2, Lcom/livemixtapes/LMTService;->mPlayer:Landroid/media/MediaPlayer;

    const/4 v3, 0x3

    invoke-virtual {v2, v3}, Landroid/media/MediaPlayer;->setAudioStreamType(I)V

    .line 419
    sget-object v2, Lcom/livemixtapes/LMTService;->mPlayer:Landroid/media/MediaPlayer;

    invoke-virtual/range {p0 .. p0}, Lcom/livemixtapes/LMTService;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v1}, Lcom/livemixtapes/MusicRetriever$Item;->getURI()Landroid/net/Uri;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Landroid/media/MediaPlayer;->setDataSource(Landroid/content/Context;Landroid/net/Uri;)V

    goto/16 :goto_1

    .line 457
    .restart local v17    # "tempBitmap":Landroid/graphics/Bitmap;
    :catch_1
    move-exception v10

    .line 458
    .local v10, "e":Ljava/lang/Exception;
    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    .line 459
    const-string v4, "COULD NOT GRAB BITMAP"

    aput-object v4, v2, v3

    invoke-static {v2}, Lcom/livemixtapes/console;->log([Ljava/lang/Object;)V

    goto/16 :goto_3

    .line 498
    .end local v10    # "e":Ljava/lang/Exception;
    .restart local v14    # "notificationIntent":Landroid/content/Intent;
    .restart local v15    # "pendingIntent":Landroid/app/PendingIntent;
    :cond_5
    new-instance v2, Ljava/lang/StringBuilder;

    sget-object v3, Lcom/livemixtapes/NowPlayingActivity;->artist:Ljava/lang/String;

    invoke-static {v3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v3, " - "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    sget-object v3, Lcom/livemixtapes/NowPlayingActivity;->title:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    sput-object v2, Lcom/livemixtapes/LMTService;->temp_title:Ljava/lang/String;

    goto/16 :goto_4

    .line 545
    .end local v14    # "notificationIntent":Landroid/content/Intent;
    .end local v15    # "pendingIntent":Landroid/app/PendingIntent;
    .end local v17    # "tempBitmap":Landroid/graphics/Bitmap;
    :cond_6
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/livemixtapes/LMTService;->mAudioManager:Landroid/media/AudioManager;

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/livemixtapes/LMTService;->mMediaButtonReceiverComponent:Landroid/content/ComponentName;

    .line 544
    invoke-static {v2, v3}, Lcom/livemixtapes/MediaButtonHelper;->registerMediaButtonEventReceiverCompat(Landroid/media/AudioManager;Landroid/content/ComponentName;)V

    .line 547
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/livemixtapes/LMTService;->mRemoteControlClientCompat:Lcom/livemixtapes/RemoteControlClientCompat;

    if-nez v2, :cond_7

    .line 548
    new-instance v12, Landroid/content/Intent;

    const-string v2, "android.intent.action.MEDIA_BUTTON"

    invoke-direct {v12, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 549
    .local v12, "intent":Landroid/content/Intent;
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/livemixtapes/LMTService;->mMediaButtonReceiverComponent:Landroid/content/ComponentName;

    invoke-virtual {v12, v2}, Landroid/content/Intent;->setComponent(Landroid/content/ComponentName;)Landroid/content/Intent;

    .line 550
    new-instance v2, Lcom/livemixtapes/RemoteControlClientCompat;

    .line 552
    const/4 v3, 0x0

    const/4 v4, 0x0

    .line 551
    move-object/from16 v0, p0

    invoke-static {v0, v3, v12, v4}, Landroid/app/PendingIntent;->getBroadcast(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v3

    invoke-direct {v2, v3}, Lcom/livemixtapes/RemoteControlClientCompat;-><init>(Landroid/app/PendingIntent;)V

    .line 550
    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/livemixtapes/LMTService;->mRemoteControlClientCompat:Lcom/livemixtapes/RemoteControlClientCompat;

    .line 553
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/livemixtapes/LMTService;->mAudioManager:Landroid/media/AudioManager;

    .line 554
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/livemixtapes/LMTService;->mRemoteControlClientCompat:Lcom/livemixtapes/RemoteControlClientCompat;

    .line 553
    invoke-static {v2, v3}, Lcom/livemixtapes/RemoteControlHelper;->registerRemoteControlClient(Landroid/media/AudioManager;Lcom/livemixtapes/RemoteControlClientCompat;)V

    .line 556
    .end local v12    # "intent":Landroid/content/Intent;
    :cond_7
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/livemixtapes/LMTService;->mRemoteControlClientCompat:Lcom/livemixtapes/RemoteControlClientCompat;

    .line 557
    const/4 v3, 0x3

    .line 556
    invoke-virtual {v2, v3}, Lcom/livemixtapes/RemoteControlClientCompat;->setPlaybackState(I)V

    .line 558
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/livemixtapes/LMTService;->mRemoteControlClientCompat:Lcom/livemixtapes/RemoteControlClientCompat;

    .line 559
    const/16 v3, 0xb5

    .line 558
    invoke-virtual {v2, v3}, Lcom/livemixtapes/RemoteControlClientCompat;->setTransportControlFlags(I)V
    :try_end_8
    .catch Ljava/io/IOException; {:try_start_8 .. :try_end_8} :catch_0

    .line 567
    const/16 v17, 0x0

    .line 570
    .restart local v17    # "tempBitmap":Landroid/graphics/Bitmap;
    :try_start_9
    new-instance v2, Lcom/livemixtapes/BitmapDownloader;

    invoke-direct {v2}, Lcom/livemixtapes/BitmapDownloader;-><init>()V

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    sget-object v5, Lcom/livemixtapes/NowPlayingActivity;->thumbURL:Ljava/lang/String;

    aput-object v5, v3, v4

    invoke-virtual {v2, v3}, Lcom/livemixtapes/BitmapDownloader;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    move-result-object v2

    invoke-virtual {v2}, Landroid/os/AsyncTask;->get()Ljava/lang/Object;

    move-result-object v2

    move-object v0, v2

    check-cast v0, Landroid/graphics/Bitmap;

    move-object/from16 v17, v0
    :try_end_9
    .catch Ljava/lang/Exception; {:try_start_9 .. :try_end_9} :catch_2
    .catch Ljava/io/IOException; {:try_start_9 .. :try_end_9} :catch_0

    .line 574
    :goto_8
    const/4 v2, 0x1

    :try_start_a
    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    .line 577
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "GRABBING THUMB: "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget-object v5, Lcom/livemixtapes/NowPlayingActivity;->thumbURL:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v2}, Lcom/livemixtapes/console;->log([Ljava/lang/Object;)V

    .line 582
    sget-object v2, Lcom/livemixtapes/NowPlayingActivity;->artist:Ljava/lang/String;

    const-string v3, ""

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_8

    .line 584
    sget-object v2, Lcom/livemixtapes/NowPlayingActivity;->title:Ljava/lang/String;

    sput-object v2, Lcom/livemixtapes/LMTService;->temp_title:Ljava/lang/String;

    .line 591
    :goto_9
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/livemixtapes/LMTService;->mRemoteControlClientCompat:Lcom/livemixtapes/RemoteControlClientCompat;

    const/4 v3, 0x1

    invoke-virtual {v2, v3}, Lcom/livemixtapes/RemoteControlClientCompat;->editMetadata(Z)Lcom/livemixtapes/RemoteControlClientCompat$MetadataEditorCompat;

    move-result-object v2

    .line 592
    const/4 v3, 0x2

    sget-object v4, Lcom/livemixtapes/NowPlayingActivity;->artist:Ljava/lang/String;

    invoke-virtual {v2, v3, v4}, Lcom/livemixtapes/RemoteControlClientCompat$MetadataEditorCompat;->putString(ILjava/lang/String;)Lcom/livemixtapes/RemoteControlClientCompat$MetadataEditorCompat;

    move-result-object v2

    .line 593
    const/16 v3, 0xd

    sget-object v4, Lcom/livemixtapes/NowPlayingActivity;->artist:Ljava/lang/String;

    invoke-virtual {v2, v3, v4}, Lcom/livemixtapes/RemoteControlClientCompat$MetadataEditorCompat;->putString(ILjava/lang/String;)Lcom/livemixtapes/RemoteControlClientCompat$MetadataEditorCompat;

    move-result-object v2

    .line 594
    const/4 v3, 0x1

    sget-object v4, Lcom/livemixtapes/NowPlayingActivity;->tape:Ljava/lang/String;

    invoke-virtual {v2, v3, v4}, Lcom/livemixtapes/RemoteControlClientCompat$MetadataEditorCompat;->putString(ILjava/lang/String;)Lcom/livemixtapes/RemoteControlClientCompat$MetadataEditorCompat;

    move-result-object v2

    .line 595
    const/16 v3, 0x9

    .line 596
    invoke-virtual {v1}, Lcom/livemixtapes/MusicRetriever$Item;->getDuration()J

    move-result-wide v4

    .line 595
    invoke-virtual {v2, v3, v4, v5}, Lcom/livemixtapes/RemoteControlClientCompat$MetadataEditorCompat;->putLong(IJ)Lcom/livemixtapes/RemoteControlClientCompat$MetadataEditorCompat;

    move-result-object v2

    .line 599
    const/4 v3, 0x7

    sget-object v4, Lcom/livemixtapes/NowPlayingActivity;->title:Ljava/lang/String;

    invoke-virtual {v2, v3, v4}, Lcom/livemixtapes/RemoteControlClientCompat$MetadataEditorCompat;->putString(ILjava/lang/String;)Lcom/livemixtapes/RemoteControlClientCompat$MetadataEditorCompat;

    move-result-object v2

    .line 605
    const/16 v3, 0x64

    .line 604
    move-object/from16 v0, v17

    invoke-virtual {v2, v3, v0}, Lcom/livemixtapes/RemoteControlClientCompat$MetadataEditorCompat;->putBitmap(ILandroid/graphics/Bitmap;)Lcom/livemixtapes/RemoteControlClientCompat$MetadataEditorCompat;

    move-result-object v2

    .line 607
    invoke-virtual {v2}, Lcom/livemixtapes/RemoteControlClientCompat$MetadataEditorCompat;->apply()V

    goto/16 :goto_5

    .line 572
    :catch_2
    move-exception v10

    .line 573
    .restart local v10    # "e":Ljava/lang/Exception;
    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    .line 574
    const-string v4, "COULD NOT GRAB BITMAP"

    aput-object v4, v2, v3

    invoke-static {v2}, Lcom/livemixtapes/console;->log([Ljava/lang/Object;)V

    goto :goto_8

    .line 588
    .end local v10    # "e":Ljava/lang/Exception;
    :cond_8
    new-instance v2, Ljava/lang/StringBuilder;

    sget-object v3, Lcom/livemixtapes/NowPlayingActivity;->artist:Ljava/lang/String;

    invoke-static {v3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v3, " - "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    sget-object v3, Lcom/livemixtapes/NowPlayingActivity;->title:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    sput-object v2, Lcom/livemixtapes/LMTService;->temp_title:Ljava/lang/String;

    goto :goto_9

    .line 623
    :cond_9
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/livemixtapes/LMTService;->mWifiLock:Landroid/net/wifi/WifiManager$WifiLock;

    invoke-virtual {v2}, Landroid/net/wifi/WifiManager$WifiLock;->isHeld()Z

    move-result v2

    if-eqz v2, :cond_1

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/livemixtapes/LMTService;->mWifiLock:Landroid/net/wifi/WifiManager$WifiLock;

    invoke-virtual {v2}, Landroid/net/wifi/WifiManager$WifiLock;->release()V
    :try_end_a
    .catch Ljava/io/IOException; {:try_start_a .. :try_end_a} :catch_0

    goto/16 :goto_6

    .line 625
    .end local v1    # "playingItem":Lcom/livemixtapes/MusicRetriever$Item;
    .end local v17    # "tempBitmap":Landroid/graphics/Bitmap;
    .restart local v16    # "playingItem":Lcom/livemixtapes/MusicRetriever$Item;
    :catch_3
    move-exception v11

    move-object/from16 v1, v16

    .end local v16    # "playingItem":Lcom/livemixtapes/MusicRetriever$Item;
    .restart local v1    # "playingItem":Lcom/livemixtapes/MusicRetriever$Item;
    goto/16 :goto_7

    .line 426
    :catch_4
    move-exception v2

    goto/16 :goto_2

    .line 512
    :array_0
    .array-data 4
        0x0
        0x1
        0x2
    .end array-data
.end method

.method processAddRequest(Landroid/content/Intent;)V
    .locals 5
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    const/4 v4, 0x0

    const/4 v3, 0x1

    .line 380
    new-array v0, v3, [Ljava/lang/Object;

    .line 366
    const-string v1, "ADDING"

    aput-object v1, v0, v4

    invoke-static {v0}, Lcom/livemixtapes/console;->log([Ljava/lang/Object;)V

    new-array v0, v3, [Ljava/lang/Object;

    .line 367
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "HERP: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v2

    invoke-virtual {v2}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    aput-object v1, v0, v4

    invoke-static {v0}, Lcom/livemixtapes/console;->log([Ljava/lang/Object;)V

    .line 368
    iget-object v0, p0, Lcom/livemixtapes/LMTService;->mState:Lcom/livemixtapes/LMTService$State;

    sget-object v1, Lcom/livemixtapes/LMTService$State;->Retrieving:Lcom/livemixtapes/LMTService$State;

    if-ne v0, v1, :cond_1

    new-array v0, v3, [Ljava/lang/Object;

    .line 369
    const-string v1, "HUMRETREIVING"

    aput-object v1, v0, v4

    invoke-static {v0}, Lcom/livemixtapes/console;->log([Ljava/lang/Object;)V

    .line 371
    invoke-virtual {p1}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v0

    iput-object v0, p0, Lcom/livemixtapes/LMTService;->mWhatToPlayAfterRetrieve:Landroid/net/Uri;

    .line 372
    iput-boolean v3, p0, Lcom/livemixtapes/LMTService;->mStartPlayingAfterRetrieve:Z

    .line 378
    :cond_0
    :goto_0
    return-void

    .line 374
    :cond_1
    iget-object v0, p0, Lcom/livemixtapes/LMTService;->mState:Lcom/livemixtapes/LMTService$State;

    sget-object v1, Lcom/livemixtapes/LMTService$State;->Playing:Lcom/livemixtapes/LMTService$State;

    if-eq v0, v1, :cond_2

    iget-object v0, p0, Lcom/livemixtapes/LMTService;->mState:Lcom/livemixtapes/LMTService$State;

    sget-object v1, Lcom/livemixtapes/LMTService$State;->Paused:Lcom/livemixtapes/LMTService$State;

    if-eq v0, v1, :cond_2

    iget-object v0, p0, Lcom/livemixtapes/LMTService;->mState:Lcom/livemixtapes/LMTService$State;

    sget-object v1, Lcom/livemixtapes/LMTService$State;->Stopped:Lcom/livemixtapes/LMTService$State;

    if-ne v0, v1, :cond_0

    :cond_2
    new-array v0, v3, [Ljava/lang/Object;

    .line 375
    const-string v1, "HUMSTARTING"

    aput-object v1, v0, v4

    invoke-static {v0}, Lcom/livemixtapes/console;->log([Ljava/lang/Object;)V

    .line 376
    const-string v0, "livemixtapesPlayer"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Playing from URL/path: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v2

    invoke-virtual {v2}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 377
    invoke-virtual {p0}, Lcom/livemixtapes/LMTService;->tryToGetAudioFocus()V

    .line 378
    invoke-virtual {p1}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/livemixtapes/LMTService;->playNextSong(Ljava/lang/String;)V

    goto :goto_0
.end method

.method processImageRequest()V
    .locals 0

    .prologue
    .line 361
    return-void
.end method

.method processPauseRequest()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 256
    iget-object v0, p0, Lcom/livemixtapes/LMTService;->mState:Lcom/livemixtapes/LMTService$State;

    sget-object v1, Lcom/livemixtapes/LMTService$State;->Retrieving:Lcom/livemixtapes/LMTService$State;

    if-ne v0, v1, :cond_1

    .line 259
    iput-boolean v2, p0, Lcom/livemixtapes/LMTService;->mStartPlayingAfterRetrieve:Z

    .line 274
    :cond_0
    :goto_0
    return-void

    .line 262
    :cond_1
    iget-object v0, p0, Lcom/livemixtapes/LMTService;->mState:Lcom/livemixtapes/LMTService$State;

    sget-object v1, Lcom/livemixtapes/LMTService$State;->Playing:Lcom/livemixtapes/LMTService$State;

    if-ne v0, v1, :cond_2

    .line 264
    sget-object v0, Lcom/livemixtapes/LMTService$State;->Paused:Lcom/livemixtapes/LMTService$State;

    iput-object v0, p0, Lcom/livemixtapes/LMTService;->mState:Lcom/livemixtapes/LMTService$State;

    .line 265
    sget-object v0, Lcom/livemixtapes/LMTService;->mPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->pause()V

    .line 266
    invoke-virtual {p0, v2}, Lcom/livemixtapes/LMTService;->relaxResources(Z)V

    .line 270
    :cond_2
    iget-object v0, p0, Lcom/livemixtapes/LMTService;->mRemoteControlClientCompat:Lcom/livemixtapes/RemoteControlClientCompat;

    if-eqz v0, :cond_0

    .line 271
    iget-object v0, p0, Lcom/livemixtapes/LMTService;->mRemoteControlClientCompat:Lcom/livemixtapes/RemoteControlClientCompat;

    .line 272
    const/4 v1, 0x2

    invoke-virtual {v0, v1}, Lcom/livemixtapes/RemoteControlClientCompat;->setPlaybackState(I)V

    goto :goto_0
.end method

.method processPlayRequest()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    const/16 v2, 0x15

    .line 209
    sget-object v0, Lcom/livemixtapes/LMTService;->mPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->isPlaying()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 211
    invoke-virtual {p0}, Lcom/livemixtapes/LMTService;->processPauseRequest()V

    .line 213
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    if-lt v0, v2, :cond_0

    .line 215
    invoke-virtual {p0}, Lcom/livemixtapes/LMTService;->setPauseNotify()V

    .line 254
    :cond_0
    :goto_0
    return-void

    .line 223
    :cond_1
    iget-object v0, p0, Lcom/livemixtapes/LMTService;->mState:Lcom/livemixtapes/LMTService$State;

    sget-object v1, Lcom/livemixtapes/LMTService$State;->Retrieving:Lcom/livemixtapes/LMTService$State;

    if-ne v0, v1, :cond_2

    .line 226
    iput-object v3, p0, Lcom/livemixtapes/LMTService;->mWhatToPlayAfterRetrieve:Landroid/net/Uri;

    .line 227
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/livemixtapes/LMTService;->mStartPlayingAfterRetrieve:Z

    goto :goto_0

    .line 230
    :cond_2
    invoke-virtual {p0}, Lcom/livemixtapes/LMTService;->tryToGetAudioFocus()V

    .line 232
    iget-object v0, p0, Lcom/livemixtapes/LMTService;->mState:Lcom/livemixtapes/LMTService$State;

    sget-object v1, Lcom/livemixtapes/LMTService$State;->Stopped:Lcom/livemixtapes/LMTService$State;

    if-ne v0, v1, :cond_5

    .line 234
    invoke-virtual {p0, v3}, Lcom/livemixtapes/LMTService;->playNextSong(Ljava/lang/String;)V

    .line 243
    :cond_3
    :goto_1
    iget-object v0, p0, Lcom/livemixtapes/LMTService;->mRemoteControlClientCompat:Lcom/livemixtapes/RemoteControlClientCompat;

    if-eqz v0, :cond_4

    .line 244
    iget-object v0, p0, Lcom/livemixtapes/LMTService;->mRemoteControlClientCompat:Lcom/livemixtapes/RemoteControlClientCompat;

    .line 245
    const/4 v1, 0x3

    invoke-virtual {v0, v1}, Lcom/livemixtapes/RemoteControlClientCompat;->setPlaybackState(I)V

    .line 248
    :cond_4
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    if-lt v0, v2, :cond_0

    .line 250
    invoke-virtual {p0}, Lcom/livemixtapes/LMTService;->setPlayNotify()V

    goto :goto_0

    .line 236
    :cond_5
    iget-object v0, p0, Lcom/livemixtapes/LMTService;->mState:Lcom/livemixtapes/LMTService$State;

    sget-object v1, Lcom/livemixtapes/LMTService$State;->Paused:Lcom/livemixtapes/LMTService$State;

    if-ne v0, v1, :cond_3

    .line 238
    sget-object v0, Lcom/livemixtapes/LMTService$State;->Playing:Lcom/livemixtapes/LMTService$State;

    iput-object v0, p0, Lcom/livemixtapes/LMTService;->mState:Lcom/livemixtapes/LMTService$State;

    .line 239
    new-instance v0, Ljava/lang/StringBuilder;

    iget-object v1, p0, Lcom/livemixtapes/LMTService;->mSongTitle:Ljava/lang/String;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v1, " (playing)"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/livemixtapes/LMTService;->setUpAsForeground(Ljava/lang/String;)V

    .line 240
    invoke-virtual {p0}, Lcom/livemixtapes/LMTService;->configAndStartMediaPlayer()V

    goto :goto_1
.end method

.method processRewindRequest()V
    .locals 2

    .prologue
    .line 276
    iget-object v0, p0, Lcom/livemixtapes/LMTService;->mState:Lcom/livemixtapes/LMTService$State;

    sget-object v1, Lcom/livemixtapes/LMTService$State;->Playing:Lcom/livemixtapes/LMTService$State;

    if-eq v0, v1, :cond_0

    iget-object v0, p0, Lcom/livemixtapes/LMTService;->mState:Lcom/livemixtapes/LMTService$State;

    sget-object v1, Lcom/livemixtapes/LMTService$State;->Paused:Lcom/livemixtapes/LMTService$State;

    if-ne v0, v1, :cond_1

    .line 278
    :cond_0
    invoke-static {}, Lcom/livemixtapes/NowPlayingActivity;->previousTrack()V

    .line 279
    :cond_1
    return-void
.end method

.method processSkipRequest()V
    .locals 5

    .prologue
    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 288
    new-array v0, v4, [Ljava/lang/Object;

    .line 281
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "PRESKIP REQUEST"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/livemixtapes/LMTService;->mState:Lcom/livemixtapes/LMTService$State;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    aput-object v1, v0, v3

    invoke-static {v0}, Lcom/livemixtapes/console;->log([Ljava/lang/Object;)V

    .line 282
    iget-object v0, p0, Lcom/livemixtapes/LMTService;->mState:Lcom/livemixtapes/LMTService$State;

    sget-object v1, Lcom/livemixtapes/LMTService$State;->Playing:Lcom/livemixtapes/LMTService$State;

    if-eq v0, v1, :cond_0

    iget-object v0, p0, Lcom/livemixtapes/LMTService;->mState:Lcom/livemixtapes/LMTService$State;

    sget-object v1, Lcom/livemixtapes/LMTService$State;->Paused:Lcom/livemixtapes/LMTService$State;

    if-ne v0, v1, :cond_1

    :cond_0
    new-array v0, v4, [Ljava/lang/Object;

    .line 283
    const-string v1, "SKIP REQUEST"

    aput-object v1, v0, v3

    invoke-static {v0}, Lcom/livemixtapes/console;->log([Ljava/lang/Object;)V

    .line 284
    invoke-virtual {p0}, Lcom/livemixtapes/LMTService;->tryToGetAudioFocus()V

    .line 285
    invoke-static {}, Lcom/livemixtapes/NowPlayingActivity;->nextTrack()V

    :cond_1
    return-void
.end method

.method processStopRequest()V
    .locals 0

    .prologue
    .line 291
    invoke-virtual {p0}, Lcom/livemixtapes/LMTService;->processPauseRequest()V

    .line 292
    invoke-virtual {p0}, Lcom/livemixtapes/LMTService;->setCloseNotify()V

    .line 294
    return-void
.end method

.method processStopRequest(Z)V
    .locals 3
    .param p1, "force"    # Z

    .prologue
    const/4 v2, 0x1

    .line 296
    iget-object v0, p0, Lcom/livemixtapes/LMTService;->mState:Lcom/livemixtapes/LMTService$State;

    sget-object v1, Lcom/livemixtapes/LMTService$State;->Playing:Lcom/livemixtapes/LMTService$State;

    if-eq v0, v1, :cond_0

    iget-object v0, p0, Lcom/livemixtapes/LMTService;->mState:Lcom/livemixtapes/LMTService$State;

    sget-object v1, Lcom/livemixtapes/LMTService$State;->Paused:Lcom/livemixtapes/LMTService$State;

    if-eq v0, v1, :cond_0

    if-eqz p1, :cond_2

    .line 297
    :cond_0
    sget-object v0, Lcom/livemixtapes/LMTService$State;->Stopped:Lcom/livemixtapes/LMTService$State;

    iput-object v0, p0, Lcom/livemixtapes/LMTService;->mState:Lcom/livemixtapes/LMTService$State;

    .line 299
    invoke-virtual {p0, v2}, Lcom/livemixtapes/LMTService;->relaxResources(Z)V

    .line 300
    invoke-virtual {p0}, Lcom/livemixtapes/LMTService;->giveUpAudioFocus()V

    .line 302
    iget-object v0, p0, Lcom/livemixtapes/LMTService;->mRemoteControlClientCompat:Lcom/livemixtapes/RemoteControlClientCompat;

    if-eqz v0, :cond_1

    .line 303
    iget-object v0, p0, Lcom/livemixtapes/LMTService;->mRemoteControlClientCompat:Lcom/livemixtapes/RemoteControlClientCompat;

    .line 304
    invoke-virtual {v0, v2}, Lcom/livemixtapes/RemoteControlClientCompat;->setPlaybackState(I)V

    .line 307
    :cond_1
    invoke-virtual {p0}, Lcom/livemixtapes/LMTService;->stopSelf()V

    .line 309
    :cond_2
    invoke-virtual {p0}, Lcom/livemixtapes/LMTService;->setCloseNotify()V

    .line 310
    return-void
.end method

.method processTogglePlaybackRequest()V
    .locals 2

    .prologue
    .line 198
    iget-object v0, p0, Lcom/livemixtapes/LMTService;->mState:Lcom/livemixtapes/LMTService$State;

    sget-object v1, Lcom/livemixtapes/LMTService$State;->Paused:Lcom/livemixtapes/LMTService$State;

    if-eq v0, v1, :cond_0

    iget-object v0, p0, Lcom/livemixtapes/LMTService;->mState:Lcom/livemixtapes/LMTService$State;

    sget-object v1, Lcom/livemixtapes/LMTService$State;->Stopped:Lcom/livemixtapes/LMTService$State;

    if-ne v0, v1, :cond_1

    .line 199
    :cond_0
    invoke-virtual {p0}, Lcom/livemixtapes/LMTService;->processPlayRequest()V

    .line 205
    :goto_0
    return-void

    .line 203
    :cond_1
    invoke-virtual {p0}, Lcom/livemixtapes/LMTService;->processPauseRequest()V

    goto :goto_0
.end method

.method relaxResources(Z)V
    .locals 1
    .param p1, "releaseMediaPlayer"    # Z

    .prologue
    .line 319
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/livemixtapes/LMTService;->stopForeground(Z)V

    .line 321
    if-eqz p1, :cond_0

    sget-object v0, Lcom/livemixtapes/LMTService;->mPlayer:Landroid/media/MediaPlayer;

    if-eqz v0, :cond_0

    .line 322
    sget-object v0, Lcom/livemixtapes/LMTService;->mPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->reset()V

    .line 323
    sget-object v0, Lcom/livemixtapes/LMTService;->mPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->release()V

    .line 324
    const/4 v0, 0x0

    sput-object v0, Lcom/livemixtapes/LMTService;->mPlayer:Landroid/media/MediaPlayer;

    .line 327
    :cond_0
    iget-object v0, p0, Lcom/livemixtapes/LMTService;->mWifiLock:Landroid/net/wifi/WifiManager$WifiLock;

    invoke-virtual {v0}, Landroid/net/wifi/WifiManager$WifiLock;->isHeld()Z

    move-result v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/livemixtapes/LMTService;->mWifiLock:Landroid/net/wifi/WifiManager$WifiLock;

    invoke-virtual {v0}, Landroid/net/wifi/WifiManager$WifiLock;->release()V

    .line 328
    :cond_1
    return-void
.end method

.method setCloseNotify()V
    .locals 1
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "NewApi"
        }
    .end annotation

    .prologue
    .line 938
    const/4 v0, 0x1

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    sput-object v0, Lcom/livemixtapes/LMTService;->amPlaying:Ljava/lang/Boolean;

    .line 939
    const-string v0, "notification"

    invoke-virtual {p0, v0}, Lcom/livemixtapes/LMTService;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/NotificationManager;

    invoke-virtual {v0}, Landroid/app/NotificationManager;->cancelAll()V

    .line 941
    return-void
.end method

.method setPauseNotify()V
    .locals 14
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "NewApi"
        }
    .end annotation

    .prologue
    const/4 v13, 0x3

    const/4 v12, 0x1

    const/4 v11, 0x0

    .line 872
    const/4 v6, 0x0

    .line 875
    .local v6, "tempBitmap":Landroid/graphics/Bitmap;
    :try_start_0
    new-instance v7, Lcom/livemixtapes/BitmapDownloader;

    invoke-direct {v7}, Lcom/livemixtapes/BitmapDownloader;-><init>()V

    const/4 v8, 0x1

    new-array v8, v8, [Ljava/lang/String;

    const/4 v9, 0x0

    sget-object v10, Lcom/livemixtapes/NowPlayingActivity;->thumbURL:Ljava/lang/String;

    aput-object v10, v8, v9

    invoke-virtual {v7, v8}, Lcom/livemixtapes/BitmapDownloader;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    move-result-object v7

    invoke-virtual {v7}, Landroid/os/AsyncTask;->get()Ljava/lang/Object;

    move-result-object v7

    move-object v0, v7

    check-cast v0, Landroid/graphics/Bitmap;

    move-object v6, v0
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 882
    :goto_0
    new-instance v4, Landroid/content/Intent;

    const-class v7, Lcom/livemixtapes/NowPlayingActivity;

    invoke-direct {v4, p0, v7}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 883
    .local v4, "notificationIntent":Landroid/content/Intent;
    invoke-static {p0, v11, v4, v11}, Landroid/app/PendingIntent;->getActivity(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v5

    .line 887
    .local v5, "pendingIntent":Landroid/app/PendingIntent;
    sget-object v7, Lcom/livemixtapes/NowPlayingActivity;->artist:Ljava/lang/String;

    const-string v8, ""

    invoke-virtual {v7, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_0

    .line 889
    sget-object v7, Lcom/livemixtapes/NowPlayingActivity;->title:Ljava/lang/String;

    sput-object v7, Lcom/livemixtapes/LMTService;->temp_title:Ljava/lang/String;

    .line 896
    :goto_1
    new-instance v7, Landroid/app/Notification$Builder;

    invoke-direct {v7, p0}, Landroid/app/Notification$Builder;-><init>(Landroid/content/Context;)V

    .line 898
    invoke-virtual {v7, v11}, Landroid/app/Notification$Builder;->setAutoCancel(Z)Landroid/app/Notification$Builder;

    move-result-object v7

    .line 899
    invoke-virtual {v7, v12}, Landroid/app/Notification$Builder;->setOngoing(Z)Landroid/app/Notification$Builder;

    move-result-object v7

    .line 900
    invoke-virtual {v7, v11}, Landroid/app/Notification$Builder;->setShowWhen(Z)Landroid/app/Notification$Builder;

    move-result-object v7

    .line 903
    new-instance v8, Landroid/app/Notification$MediaStyle;

    invoke-direct {v8}, Landroid/app/Notification$MediaStyle;-><init>()V

    .line 906
    sget-object v9, Lcom/livemixtapes/LMTService;->mediaSession:Landroid/media/session/MediaSession;

    invoke-virtual {v9}, Landroid/media/session/MediaSession;->getSessionToken()Landroid/media/session/MediaSession$Token;

    move-result-object v9

    invoke-virtual {v8, v9}, Landroid/app/Notification$MediaStyle;->setMediaSession(Landroid/media/session/MediaSession$Token;)Landroid/app/Notification$MediaStyle;

    move-result-object v8

    new-array v9, v13, [I

    fill-array-data v9, :array_0

    .line 908
    invoke-virtual {v8, v9}, Landroid/app/Notification$MediaStyle;->setShowActionsInCompactView([I)Landroid/app/Notification$MediaStyle;

    move-result-object v8

    .line 903
    invoke-virtual {v7, v8}, Landroid/app/Notification$Builder;->setStyle(Landroid/app/Notification$Style;)Landroid/app/Notification$Builder;

    move-result-object v7

    .line 910
    const v8, -0xffba81

    invoke-virtual {v7, v8}, Landroid/app/Notification$Builder;->setColor(I)Landroid/app/Notification$Builder;

    move-result-object v7

    .line 912
    invoke-virtual {v7, v6}, Landroid/app/Notification$Builder;->setLargeIcon(Landroid/graphics/Bitmap;)Landroid/app/Notification$Builder;

    move-result-object v7

    .line 913
    const v8, 0x7f02005b

    invoke-virtual {v7, v8}, Landroid/app/Notification$Builder;->setSmallIcon(I)Landroid/app/Notification$Builder;

    move-result-object v7

    .line 915
    const-string v8, ""

    invoke-virtual {v7, v8}, Landroid/app/Notification$Builder;->setContentText(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;

    move-result-object v7

    .line 916
    const-string v8, ""

    invoke-virtual {v7, v8}, Landroid/app/Notification$Builder;->setContentInfo(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;

    move-result-object v7

    .line 917
    sget-object v8, Lcom/livemixtapes/LMTService;->temp_title:Ljava/lang/String;

    invoke-virtual {v7, v8}, Landroid/app/Notification$Builder;->setContentTitle(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;

    move-result-object v7

    .line 919
    invoke-virtual {v7, v5}, Landroid/app/Notification$Builder;->setContentIntent(Landroid/app/PendingIntent;)Landroid/app/Notification$Builder;

    move-result-object v7

    .line 922
    const v8, 0x7f0200a8

    const-string v9, "prev"

    invoke-direct {p0, v13}, Lcom/livemixtapes/LMTService;->retreivePlaybackAction(I)Landroid/app/PendingIntent;

    move-result-object v10

    invoke-virtual {v7, v8, v9, v10}, Landroid/app/Notification$Builder;->addAction(ILjava/lang/CharSequence;Landroid/app/PendingIntent;)Landroid/app/Notification$Builder;

    move-result-object v7

    .line 923
    const v8, 0x7f0200a7

    const-string v9, "play"

    invoke-direct {p0, v12}, Lcom/livemixtapes/LMTService;->retreivePlaybackAction(I)Landroid/app/PendingIntent;

    move-result-object v10

    invoke-virtual {v7, v8, v9, v10}, Landroid/app/Notification$Builder;->addAction(ILjava/lang/CharSequence;Landroid/app/PendingIntent;)Landroid/app/Notification$Builder;

    move-result-object v7

    .line 924
    const v8, 0x7f0200a5

    const-string v9, "next"

    const/4 v10, 0x2

    invoke-direct {p0, v10}, Lcom/livemixtapes/LMTService;->retreivePlaybackAction(I)Landroid/app/PendingIntent;

    move-result-object v10

    invoke-virtual {v7, v8, v9, v10}, Landroid/app/Notification$Builder;->addAction(ILjava/lang/CharSequence;Landroid/app/PendingIntent;)Landroid/app/Notification$Builder;

    move-result-object v7

    .line 925
    const v8, 0x7f0200a0

    const-string v9, "close"

    const/4 v10, 0x4

    invoke-direct {p0, v10}, Lcom/livemixtapes/LMTService;->retreivePlaybackAction(I)Landroid/app/PendingIntent;

    move-result-object v10

    invoke-virtual {v7, v8, v9, v10}, Landroid/app/Notification$Builder;->addAction(ILjava/lang/CharSequence;Landroid/app/PendingIntent;)Landroid/app/Notification$Builder;

    move-result-object v7

    .line 926
    invoke-virtual {v7}, Landroid/app/Notification$Builder;->build()Landroid/app/Notification;

    move-result-object v3

    .line 929
    .local v3, "noti":Landroid/app/Notification;
    sget-object v7, Lcom/livemixtapes/LMTService;->mediaSession:Landroid/media/session/MediaSession;

    invoke-virtual {v7}, Landroid/media/session/MediaSession;->getController()Landroid/media/session/MediaController;

    move-result-object v7

    invoke-virtual {v7}, Landroid/media/session/MediaController;->getTransportControls()Landroid/media/session/MediaController$TransportControls;

    move-result-object v1

    .line 930
    .local v1, "controls":Landroid/media/session/MediaController$TransportControls;
    invoke-static {v12}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v7

    sput-object v7, Lcom/livemixtapes/LMTService;->amPlaying:Ljava/lang/Boolean;

    .line 931
    const-string v7, "notification"

    invoke-virtual {p0, v7}, Lcom/livemixtapes/LMTService;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Landroid/app/NotificationManager;

    invoke-virtual {v7, v12, v3}, Landroid/app/NotificationManager;->notify(ILandroid/app/Notification;)V

    .line 932
    return-void

    .line 877
    .end local v1    # "controls":Landroid/media/session/MediaController$TransportControls;
    .end local v3    # "noti":Landroid/app/Notification;
    .end local v4    # "notificationIntent":Landroid/content/Intent;
    .end local v5    # "pendingIntent":Landroid/app/PendingIntent;
    :catch_0
    move-exception v2

    .line 878
    .local v2, "e":Ljava/lang/Exception;
    new-array v7, v12, [Ljava/lang/Object;

    .line 879
    const-string v8, "COULD NOT GRAB BITMAP"

    aput-object v8, v7, v11

    invoke-static {v7}, Lcom/livemixtapes/console;->log([Ljava/lang/Object;)V

    goto/16 :goto_0

    .line 893
    .end local v2    # "e":Ljava/lang/Exception;
    .restart local v4    # "notificationIntent":Landroid/content/Intent;
    .restart local v5    # "pendingIntent":Landroid/app/PendingIntent;
    :cond_0
    new-instance v7, Ljava/lang/StringBuilder;

    sget-object v8, Lcom/livemixtapes/NowPlayingActivity;->artist:Ljava/lang/String;

    invoke-static {v8}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v8

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v8, " - "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    sget-object v8, Lcom/livemixtapes/NowPlayingActivity;->title:Ljava/lang/String;

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    sput-object v7, Lcom/livemixtapes/LMTService;->temp_title:Ljava/lang/String;

    goto/16 :goto_1

    .line 906
    :array_0
    .array-data 4
        0x0
        0x1
        0x2
    .end array-data
.end method

.method setPlayNotify()V
    .locals 14
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "NewApi"
        }
    .end annotation

    .prologue
    const/4 v13, 0x3

    const/4 v12, 0x1

    const/4 v11, 0x0

    .line 948
    const/4 v6, 0x0

    .line 951
    .local v6, "tempBitmap":Landroid/graphics/Bitmap;
    :try_start_0
    new-instance v7, Lcom/livemixtapes/BitmapDownloader;

    invoke-direct {v7}, Lcom/livemixtapes/BitmapDownloader;-><init>()V

    const/4 v8, 0x1

    new-array v8, v8, [Ljava/lang/String;

    const/4 v9, 0x0

    sget-object v10, Lcom/livemixtapes/NowPlayingActivity;->thumbURL:Ljava/lang/String;

    aput-object v10, v8, v9

    invoke-virtual {v7, v8}, Lcom/livemixtapes/BitmapDownloader;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    move-result-object v7

    invoke-virtual {v7}, Landroid/os/AsyncTask;->get()Ljava/lang/Object;

    move-result-object v7

    move-object v0, v7

    check-cast v0, Landroid/graphics/Bitmap;

    move-object v6, v0
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 958
    :goto_0
    new-instance v4, Landroid/content/Intent;

    const-class v7, Lcom/livemixtapes/NowPlayingActivity;

    invoke-direct {v4, p0, v7}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 959
    .local v4, "notificationIntent":Landroid/content/Intent;
    invoke-static {p0, v11, v4, v11}, Landroid/app/PendingIntent;->getActivity(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v5

    .line 964
    .local v5, "pendingIntent":Landroid/app/PendingIntent;
    sget-object v7, Lcom/livemixtapes/NowPlayingActivity;->artist:Ljava/lang/String;

    const-string v8, ""

    invoke-virtual {v7, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_0

    .line 966
    sget-object v7, Lcom/livemixtapes/NowPlayingActivity;->title:Ljava/lang/String;

    sput-object v7, Lcom/livemixtapes/LMTService;->temp_title:Ljava/lang/String;

    .line 973
    :goto_1
    new-instance v7, Landroid/app/Notification$Builder;

    invoke-direct {v7, p0}, Landroid/app/Notification$Builder;-><init>(Landroid/content/Context;)V

    .line 977
    invoke-virtual {v7, v11}, Landroid/app/Notification$Builder;->setAutoCancel(Z)Landroid/app/Notification$Builder;

    move-result-object v7

    .line 978
    invoke-virtual {v7, v12}, Landroid/app/Notification$Builder;->setOngoing(Z)Landroid/app/Notification$Builder;

    move-result-object v7

    .line 979
    invoke-virtual {v7, v11}, Landroid/app/Notification$Builder;->setShowWhen(Z)Landroid/app/Notification$Builder;

    move-result-object v7

    .line 982
    new-instance v8, Landroid/app/Notification$MediaStyle;

    invoke-direct {v8}, Landroid/app/Notification$MediaStyle;-><init>()V

    .line 984
    sget-object v9, Lcom/livemixtapes/LMTService;->mediaSession:Landroid/media/session/MediaSession;

    invoke-virtual {v9}, Landroid/media/session/MediaSession;->getSessionToken()Landroid/media/session/MediaSession$Token;

    move-result-object v9

    invoke-virtual {v8, v9}, Landroid/app/Notification$MediaStyle;->setMediaSession(Landroid/media/session/MediaSession$Token;)Landroid/app/Notification$MediaStyle;

    move-result-object v8

    new-array v9, v13, [I

    fill-array-data v9, :array_0

    .line 986
    invoke-virtual {v8, v9}, Landroid/app/Notification$MediaStyle;->setShowActionsInCompactView([I)Landroid/app/Notification$MediaStyle;

    move-result-object v8

    .line 982
    invoke-virtual {v7, v8}, Landroid/app/Notification$Builder;->setStyle(Landroid/app/Notification$Style;)Landroid/app/Notification$Builder;

    move-result-object v7

    .line 988
    const v8, -0xffba81

    invoke-virtual {v7, v8}, Landroid/app/Notification$Builder;->setColor(I)Landroid/app/Notification$Builder;

    move-result-object v7

    .line 990
    invoke-virtual {v7, v6}, Landroid/app/Notification$Builder;->setLargeIcon(Landroid/graphics/Bitmap;)Landroid/app/Notification$Builder;

    move-result-object v7

    .line 991
    const v8, 0x7f02005b

    invoke-virtual {v7, v8}, Landroid/app/Notification$Builder;->setSmallIcon(I)Landroid/app/Notification$Builder;

    move-result-object v7

    .line 993
    const-string v8, ""

    invoke-virtual {v7, v8}, Landroid/app/Notification$Builder;->setContentText(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;

    move-result-object v7

    .line 994
    const-string v8, ""

    invoke-virtual {v7, v8}, Landroid/app/Notification$Builder;->setContentInfo(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;

    move-result-object v7

    .line 995
    sget-object v8, Lcom/livemixtapes/LMTService;->temp_title:Ljava/lang/String;

    invoke-virtual {v7, v8}, Landroid/app/Notification$Builder;->setContentTitle(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;

    move-result-object v7

    .line 997
    invoke-virtual {v7, v5}, Landroid/app/Notification$Builder;->setContentIntent(Landroid/app/PendingIntent;)Landroid/app/Notification$Builder;

    move-result-object v7

    .line 1000
    const v8, 0x7f0200a8

    const-string v9, "prev"

    invoke-direct {p0, v13}, Lcom/livemixtapes/LMTService;->retreivePlaybackAction(I)Landroid/app/PendingIntent;

    move-result-object v10

    invoke-virtual {v7, v8, v9, v10}, Landroid/app/Notification$Builder;->addAction(ILjava/lang/CharSequence;Landroid/app/PendingIntent;)Landroid/app/Notification$Builder;

    move-result-object v7

    .line 1001
    const v8, 0x7f0200a6

    const-string v9, "pause"

    invoke-direct {p0, v12}, Lcom/livemixtapes/LMTService;->retreivePlaybackAction(I)Landroid/app/PendingIntent;

    move-result-object v10

    invoke-virtual {v7, v8, v9, v10}, Landroid/app/Notification$Builder;->addAction(ILjava/lang/CharSequence;Landroid/app/PendingIntent;)Landroid/app/Notification$Builder;

    move-result-object v7

    .line 1002
    const v8, 0x7f0200a5

    const-string v9, "next"

    const/4 v10, 0x2

    invoke-direct {p0, v10}, Lcom/livemixtapes/LMTService;->retreivePlaybackAction(I)Landroid/app/PendingIntent;

    move-result-object v10

    invoke-virtual {v7, v8, v9, v10}, Landroid/app/Notification$Builder;->addAction(ILjava/lang/CharSequence;Landroid/app/PendingIntent;)Landroid/app/Notification$Builder;

    move-result-object v7

    .line 1003
    const v8, 0x7f0200a0

    const-string v9, "close"

    const/4 v10, 0x4

    invoke-direct {p0, v10}, Lcom/livemixtapes/LMTService;->retreivePlaybackAction(I)Landroid/app/PendingIntent;

    move-result-object v10

    invoke-virtual {v7, v8, v9, v10}, Landroid/app/Notification$Builder;->addAction(ILjava/lang/CharSequence;Landroid/app/PendingIntent;)Landroid/app/Notification$Builder;

    move-result-object v7

    .line 1004
    invoke-virtual {v7}, Landroid/app/Notification$Builder;->build()Landroid/app/Notification;

    move-result-object v3

    .line 1007
    .local v3, "noti":Landroid/app/Notification;
    sget-object v7, Lcom/livemixtapes/LMTService;->mediaSession:Landroid/media/session/MediaSession;

    invoke-virtual {v7}, Landroid/media/session/MediaSession;->getController()Landroid/media/session/MediaController;

    move-result-object v7

    invoke-virtual {v7}, Landroid/media/session/MediaController;->getTransportControls()Landroid/media/session/MediaController$TransportControls;

    move-result-object v1

    .line 1008
    .local v1, "controls":Landroid/media/session/MediaController$TransportControls;
    invoke-static {v12}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v7

    sput-object v7, Lcom/livemixtapes/LMTService;->amPlaying:Ljava/lang/Boolean;

    .line 1009
    const-string v7, "notification"

    invoke-virtual {p0, v7}, Lcom/livemixtapes/LMTService;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Landroid/app/NotificationManager;

    invoke-virtual {v7, v12, v3}, Landroid/app/NotificationManager;->notify(ILandroid/app/Notification;)V

    .line 1010
    return-void

    .line 953
    .end local v1    # "controls":Landroid/media/session/MediaController$TransportControls;
    .end local v3    # "noti":Landroid/app/Notification;
    .end local v4    # "notificationIntent":Landroid/content/Intent;
    .end local v5    # "pendingIntent":Landroid/app/PendingIntent;
    :catch_0
    move-exception v2

    .line 954
    .local v2, "e":Ljava/lang/Exception;
    new-array v7, v12, [Ljava/lang/Object;

    .line 955
    const-string v8, "COULD NOT GRAB BITMAP"

    aput-object v8, v7, v11

    invoke-static {v7}, Lcom/livemixtapes/console;->log([Ljava/lang/Object;)V

    goto/16 :goto_0

    .line 970
    .end local v2    # "e":Ljava/lang/Exception;
    .restart local v4    # "notificationIntent":Landroid/content/Intent;
    .restart local v5    # "pendingIntent":Landroid/app/PendingIntent;
    :cond_0
    new-instance v7, Ljava/lang/StringBuilder;

    sget-object v8, Lcom/livemixtapes/NowPlayingActivity;->artist:Ljava/lang/String;

    invoke-static {v8}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v8

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v8, " - "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    sget-object v8, Lcom/livemixtapes/NowPlayingActivity;->title:Ljava/lang/String;

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    sput-object v7, Lcom/livemixtapes/LMTService;->temp_title:Ljava/lang/String;

    goto/16 :goto_1

    .line 984
    :array_0
    .array-data 4
        0x0
        0x1
        0x2
    .end array-data
.end method

.method setUpAsForeground(Ljava/lang/String;)V
    .locals 0
    .param p1, "text"    # Ljava/lang/String;

    .prologue
    .line 657
    return-void
.end method

.method tryToGetAudioFocus()V
    .locals 2

    .prologue
    .line 382
    iget-object v0, p0, Lcom/livemixtapes/LMTService;->mAudioFocus:Lcom/livemixtapes/LMTService$AudioFocus;

    sget-object v1, Lcom/livemixtapes/LMTService$AudioFocus;->Focused:Lcom/livemixtapes/LMTService$AudioFocus;

    if-eq v0, v1, :cond_0

    iget-object v0, p0, Lcom/livemixtapes/LMTService;->mAudioFocusHelper:Lcom/livemixtapes/AudioFocusHelper;

    if-eqz v0, :cond_0

    .line 383
    iget-object v0, p0, Lcom/livemixtapes/LMTService;->mAudioFocusHelper:Lcom/livemixtapes/AudioFocusHelper;

    invoke-virtual {v0}, Lcom/livemixtapes/AudioFocusHelper;->requestFocus()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 384
    sget-object v0, Lcom/livemixtapes/LMTService$AudioFocus;->Focused:Lcom/livemixtapes/LMTService$AudioFocus;

    iput-object v0, p0, Lcom/livemixtapes/LMTService;->mAudioFocus:Lcom/livemixtapes/LMTService$AudioFocus;

    .line 385
    :cond_0
    return-void
.end method

.method updateNotification(Ljava/lang/String;)V
    .locals 0
    .param p1, "text"    # Ljava/lang/String;

    .prologue
    .line 649
    return-void
.end method
