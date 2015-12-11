.class Lco/vine/android/player/SdkVideoTimer$SdkVideoTimerTask;
.super Ljava/util/TimerTask;
.source "SdkVideoTimer.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/player/SdkVideoTimer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "SdkVideoTimerTask"
.end annotation


# instance fields
.field private final mController:Lco/vine/android/player/SdkVideoTimer$HasVideoPlayerViewController;

.field private final mHandler:Landroid/os/Handler;


# direct methods
.method public constructor <init>(Lco/vine/android/player/SdkVideoTimer$HasVideoPlayerViewController;)V
    .locals 1
    .param p1, "controller"    # Lco/vine/android/player/SdkVideoTimer$HasVideoPlayerViewController;

    .prologue
    .line 36
    invoke-direct {p0}, Ljava/util/TimerTask;-><init>()V

    .line 34
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    iput-object v0, p0, Lco/vine/android/player/SdkVideoTimer$SdkVideoTimerTask;->mHandler:Landroid/os/Handler;

    .line 37
    iput-object p1, p0, Lco/vine/android/player/SdkVideoTimer$SdkVideoTimerTask;->mController:Lco/vine/android/player/SdkVideoTimer$HasVideoPlayerViewController;

    .line 38
    return-void
.end method

.method static synthetic access$000(Lco/vine/android/player/SdkVideoTimer$SdkVideoTimerTask;)Lco/vine/android/player/SdkVideoTimer$HasVideoPlayerViewController;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/player/SdkVideoTimer$SdkVideoTimerTask;

    .prologue
    .line 31
    iget-object v0, p0, Lco/vine/android/player/SdkVideoTimer$SdkVideoTimerTask;->mController:Lco/vine/android/player/SdkVideoTimer$HasVideoPlayerViewController;

    return-object v0
.end method


# virtual methods
.method public run()V
    .locals 5

    .prologue
    .line 42
    iget-object v3, p0, Lco/vine/android/player/SdkVideoTimer$SdkVideoTimerTask;->mController:Lco/vine/android/player/SdkVideoTimer$HasVideoPlayerViewController;

    invoke-interface {v3}, Lco/vine/android/player/SdkVideoTimer$HasVideoPlayerViewController;->getLastPlayer()Lco/vine/android/player/SdkVideoView;

    move-result-object v2

    .line 43
    .local v2, "view":Lco/vine/android/player/SdkVideoView;
    if-eqz v2, :cond_0

    .line 44
    invoke-virtual {v2}, Lco/vine/android/player/SdkVideoView;->isInPlaybackState()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 46
    :try_start_0
    invoke-virtual {v2}, Lco/vine/android/player/SdkVideoView;->getDuration()I

    move-result v1

    .line 47
    .local v1, "duration":I
    if-gez v1, :cond_1

    .line 76
    .end local v1    # "duration":I
    :cond_0
    :goto_0
    return-void

    .line 50
    .restart local v1    # "duration":I
    :cond_1
    invoke-virtual {v2}, Lco/vine/android/player/SdkVideoView;->getCurrentPosition()I

    move-result v0

    .line 51
    .local v0, "current":I
    if-lez v0, :cond_0

    invoke-virtual {v2}, Lco/vine/android/player/SdkVideoView;->getCurrentPosition()I

    move-result v3

    sub-int v3, v1, v3

    const/16 v4, 0xfa

    if-ge v3, v4, :cond_0

    .line 52
    const-string v3, "Restart."

    invoke-static {v3}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 53
    iget-object v3, p0, Lco/vine/android/player/SdkVideoTimer$SdkVideoTimerTask;->mHandler:Landroid/os/Handler;

    new-instance v4, Lco/vine/android/player/SdkVideoTimer$SdkVideoTimerTask$1;

    invoke-direct {v4, p0}, Lco/vine/android/player/SdkVideoTimer$SdkVideoTimerTask$1;-><init>(Lco/vine/android/player/SdkVideoTimer$SdkVideoTimerTask;)V

    invoke-virtual {v3, v4}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z
    :try_end_0
    .catch Ljava/lang/IllegalStateException; {:try_start_0 .. :try_end_0} :catch_1

    .line 64
    :try_start_1
    invoke-virtual {v2}, Lco/vine/android/player/SdkVideoView;->restart()V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/lang/IllegalStateException; {:try_start_1 .. :try_end_1} :catch_1

    goto :goto_0

    .line 65
    :catch_0
    move-exception v3

    goto :goto_0

    .line 71
    .end local v0    # "current":I
    .end local v1    # "duration":I
    :catch_1
    move-exception v3

    goto :goto_0
.end method
