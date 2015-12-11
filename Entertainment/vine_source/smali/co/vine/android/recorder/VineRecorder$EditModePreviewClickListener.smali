.class Lco/vine/android/recorder/VineRecorder$EditModePreviewClickListener;
.super Ljava/lang/Object;
.source "VineRecorder.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/recorder/VineRecorder;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "EditModePreviewClickListener"
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/recorder/VineRecorder;


# direct methods
.method private constructor <init>(Lco/vine/android/recorder/VineRecorder;)V
    .locals 0

    .prologue
    .line 1375
    iput-object p1, p0, Lco/vine/android/recorder/VineRecorder$EditModePreviewClickListener;->this$0:Lco/vine/android/recorder/VineRecorder;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lco/vine/android/recorder/VineRecorder;Lco/vine/android/recorder/VineRecorder$1;)V
    .locals 0
    .param p1, "x0"    # Lco/vine/android/recorder/VineRecorder;
    .param p2, "x1"    # Lco/vine/android/recorder/VineRecorder$1;

    .prologue
    .line 1375
    invoke-direct {p0, p1}, Lco/vine/android/recorder/VineRecorder$EditModePreviewClickListener;-><init>(Lco/vine/android/recorder/VineRecorder;)V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 1379
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder$EditModePreviewClickListener;->this$0:Lco/vine/android/recorder/VineRecorder;

    # getter for: Lco/vine/android/recorder/VineRecorder;->mVideoPlayer:Lco/vine/android/player/SdkVideoView;
    invoke-static {v0}, Lco/vine/android/recorder/VineRecorder;->access$1900(Lco/vine/android/recorder/VineRecorder;)Lco/vine/android/player/SdkVideoView;

    move-result-object v0

    invoke-virtual {v0}, Lco/vine/android/player/SdkVideoView;->isPlaying()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1380
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder$EditModePreviewClickListener;->this$0:Lco/vine/android/recorder/VineRecorder;

    # getter for: Lco/vine/android/recorder/VineRecorder;->mPlayButtonOnClickListener:Lco/vine/android/recorder/VineRecorder$PlayButtonOnClickListener;
    invoke-static {v0}, Lco/vine/android/recorder/VineRecorder;->access$2900(Lco/vine/android/recorder/VineRecorder;)Lco/vine/android/recorder/VineRecorder$PlayButtonOnClickListener;

    move-result-object v0

    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder$EditModePreviewClickListener;->this$0:Lco/vine/android/recorder/VineRecorder;

    # getter for: Lco/vine/android/recorder/VineRecorder;->mLastPlayingSegment:Lco/vine/android/recorder/RecordSegment;
    invoke-static {v1}, Lco/vine/android/recorder/VineRecorder;->access$1100(Lco/vine/android/recorder/VineRecorder;)Lco/vine/android/recorder/RecordSegment;

    move-result-object v1

    iput-object v1, v0, Lco/vine/android/recorder/VineRecorder$PlayButtonOnClickListener;->toPlay:Lco/vine/android/recorder/RecordSegment;

    .line 1381
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder$EditModePreviewClickListener;->this$0:Lco/vine/android/recorder/VineRecorder;

    # getter for: Lco/vine/android/recorder/VineRecorder;->mPlayButtonOnClickListener:Lco/vine/android/recorder/VineRecorder$PlayButtonOnClickListener;
    invoke-static {v0}, Lco/vine/android/recorder/VineRecorder;->access$2900(Lco/vine/android/recorder/VineRecorder;)Lco/vine/android/recorder/VineRecorder$PlayButtonOnClickListener;

    move-result-object v0

    const/4 v1, 0x0

    iput-boolean v1, v0, Lco/vine/android/recorder/VineRecorder$PlayButtonOnClickListener;->forceRefresh:Z

    .line 1382
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder$EditModePreviewClickListener;->this$0:Lco/vine/android/recorder/VineRecorder;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lco/vine/android/recorder/VineRecorder;->pausePreview(Z)V

    .line 1384
    :cond_0
    return-void
.end method
