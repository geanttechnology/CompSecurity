.class public Lco/vine/android/player/SdkVideoTimer;
.super Ljava/lang/Object;
.source "SdkVideoTimer.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/player/SdkVideoTimer$HasVideoPlayerViewController;,
        Lco/vine/android/player/SdkVideoTimer$SdkVideoTimerTask;
    }
.end annotation


# static fields
.field public static final INTERVAL:I = 0x32

.field public static final TAIL_CUT:I = 0xfa


# instance fields
.field private final mTimer:Ljava/util/Timer;


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 20
    new-instance v0, Ljava/util/Timer;

    const-string v1, "VideoTimer"

    invoke-direct {v0, v1}, Ljava/util/Timer;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lco/vine/android/player/SdkVideoTimer;->mTimer:Ljava/util/Timer;

    .line 79
    return-void
.end method


# virtual methods
.method public release()V
    .locals 1

    .prologue
    .line 27
    iget-object v0, p0, Lco/vine/android/player/SdkVideoTimer;->mTimer:Ljava/util/Timer;

    invoke-virtual {v0}, Ljava/util/Timer;->cancel()V

    .line 28
    iget-object v0, p0, Lco/vine/android/player/SdkVideoTimer;->mTimer:Ljava/util/Timer;

    invoke-virtual {v0}, Ljava/util/Timer;->purge()I

    .line 29
    return-void
.end method

.method public start(Lco/vine/android/player/SdkVideoTimer$HasVideoPlayerViewController;)V
    .locals 6
    .param p1, "controller"    # Lco/vine/android/player/SdkVideoTimer$HasVideoPlayerViewController;

    .prologue
    .line 23
    iget-object v0, p0, Lco/vine/android/player/SdkVideoTimer;->mTimer:Ljava/util/Timer;

    new-instance v1, Lco/vine/android/player/SdkVideoTimer$SdkVideoTimerTask;

    invoke-direct {v1, p1}, Lco/vine/android/player/SdkVideoTimer$SdkVideoTimerTask;-><init>(Lco/vine/android/player/SdkVideoTimer$HasVideoPlayerViewController;)V

    const-wide/16 v2, 0xa

    const-wide/16 v4, 0x32

    invoke-virtual/range {v0 .. v5}, Ljava/util/Timer;->schedule(Ljava/util/TimerTask;JJ)V

    .line 24
    return-void
.end method
