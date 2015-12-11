.class public Lco/vine/android/recorder/RecordingActivityHelper;
.super Ljava/lang/Object;
.source "RecordingActivityHelper.java"


# instance fields
.field private mConnection:Landroid/content/ServiceConnection;

.field public mIsBound:Z


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 22
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 26
    new-instance v0, Lco/vine/android/recorder/RecordingActivityHelper$1;

    invoke-direct {v0, p0}, Lco/vine/android/recorder/RecordingActivityHelper$1;-><init>(Lco/vine/android/recorder/RecordingActivityHelper;)V

    iput-object v0, p0, Lco/vine/android/recorder/RecordingActivityHelper;->mConnection:Landroid/content/ServiceConnection;

    .line 24
    return-void
.end method


# virtual methods
.method public bindCameraService(Landroid/app/Activity;)V
    .locals 3
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    const/4 v2, 0x1

    .line 38
    iget-boolean v0, p0, Lco/vine/android/recorder/RecordingActivityHelper;->mIsBound:Z

    if-nez v0, :cond_1

    .line 39
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lco/vine/android/service/ResourceService;

    invoke-direct {v0, p1, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    iget-object v1, p0, Lco/vine/android/recorder/RecordingActivityHelper;->mConnection:Landroid/content/ServiceConnection;

    invoke-virtual {p1, v0, v1, v2}, Landroid/app/Activity;->bindService(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 41
    iput-boolean v2, p0, Lco/vine/android/recorder/RecordingActivityHelper;->mIsBound:Z

    .line 48
    :goto_0
    return-void

    .line 43
    :cond_0
    const-string v0, "Failed to bind camera service."

    invoke-static {v0}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;)V

    goto :goto_0

    .line 46
    :cond_1
    const-string v0, "Camera service already binded. "

    invoke-static {v0}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public unBindCameraService(Landroid/app/Activity;)V
    .locals 1
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    .line 51
    iget-boolean v0, p0, Lco/vine/android/recorder/RecordingActivityHelper;->mIsBound:Z

    if-eqz v0, :cond_0

    .line 52
    iget-object v0, p0, Lco/vine/android/recorder/RecordingActivityHelper;->mConnection:Landroid/content/ServiceConnection;

    invoke-virtual {p1, v0}, Landroid/app/Activity;->unbindService(Landroid/content/ServiceConnection;)V

    .line 53
    const/4 v0, 0x0

    iput-boolean v0, p0, Lco/vine/android/recorder/RecordingActivityHelper;->mIsBound:Z

    .line 55
    :cond_0
    return-void
.end method
