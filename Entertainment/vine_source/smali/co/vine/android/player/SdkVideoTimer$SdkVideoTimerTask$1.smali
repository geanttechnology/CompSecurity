.class Lco/vine/android/player/SdkVideoTimer$SdkVideoTimerTask$1;
.super Ljava/lang/Object;
.source "SdkVideoTimer.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lco/vine/android/player/SdkVideoTimer$SdkVideoTimerTask;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/player/SdkVideoTimer$SdkVideoTimerTask;


# direct methods
.method constructor <init>(Lco/vine/android/player/SdkVideoTimer$SdkVideoTimerTask;)V
    .locals 0

    .prologue
    .line 53
    iput-object p1, p0, Lco/vine/android/player/SdkVideoTimer$SdkVideoTimerTask$1;->this$0:Lco/vine/android/player/SdkVideoTimer$SdkVideoTimerTask;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 56
    iget-object v1, p0, Lco/vine/android/player/SdkVideoTimer$SdkVideoTimerTask$1;->this$0:Lco/vine/android/player/SdkVideoTimer$SdkVideoTimerTask;

    # getter for: Lco/vine/android/player/SdkVideoTimer$SdkVideoTimerTask;->mController:Lco/vine/android/player/SdkVideoTimer$HasVideoPlayerViewController;
    invoke-static {v1}, Lco/vine/android/player/SdkVideoTimer$SdkVideoTimerTask;->access$000(Lco/vine/android/player/SdkVideoTimer$SdkVideoTimerTask;)Lco/vine/android/player/SdkVideoTimer$HasVideoPlayerViewController;

    move-result-object v1

    invoke-interface {v1}, Lco/vine/android/player/SdkVideoTimer$HasVideoPlayerViewController;->getLastPlayer()Lco/vine/android/player/SdkVideoView;

    move-result-object v0

    .line 57
    .local v0, "view":Lco/vine/android/player/SdkVideoView;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lco/vine/android/player/SdkVideoView;->getVisibility()I

    move-result v1

    if-eqz v1, :cond_0

    .line 58
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lco/vine/android/player/SdkVideoView;->setVisibility(I)V

    .line 60
    :cond_0
    return-void
.end method
