.class Lco/vine/android/recorder/RecordingActivityHelper$1;
.super Ljava/lang/Object;
.source "RecordingActivityHelper.java"

# interfaces
.implements Landroid/content/ServiceConnection;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/recorder/RecordingActivityHelper;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/recorder/RecordingActivityHelper;


# direct methods
.method constructor <init>(Lco/vine/android/recorder/RecordingActivityHelper;)V
    .locals 0

    .prologue
    .line 26
    iput-object p1, p0, Lco/vine/android/recorder/RecordingActivityHelper$1;->this$0:Lco/vine/android/recorder/RecordingActivityHelper;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onServiceConnected(Landroid/content/ComponentName;Landroid/os/IBinder;)V
    .locals 1
    .param p1, "className"    # Landroid/content/ComponentName;
    .param p2, "service"    # Landroid/os/IBinder;

    .prologue
    .line 29
    const-string v0, "Camera service connected."

    invoke-static {v0}, Lcom/edisonwang/android/slog/SLog;->i(Ljava/lang/String;)V

    .line 30
    return-void
.end method

.method public onServiceDisconnected(Landroid/content/ComponentName;)V
    .locals 1
    .param p1, "className"    # Landroid/content/ComponentName;

    .prologue
    .line 33
    const-string v0, "Camera service disconnected."

    invoke-static {v0}, Lcom/edisonwang/android/slog/SLog;->i(Ljava/lang/String;)V

    .line 34
    return-void
.end method
