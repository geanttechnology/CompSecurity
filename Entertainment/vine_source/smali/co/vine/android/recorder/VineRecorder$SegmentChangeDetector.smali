.class public Lco/vine/android/recorder/VineRecorder$SegmentChangeDetector;
.super Ljava/lang/Object;
.source "VineRecorder.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/recorder/VineRecorder;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "SegmentChangeDetector"
.end annotation


# static fields
.field private static final SLEEP_MILLIS:I = 0x28


# instance fields
.field public lastFirstItem:I

.field public runThread:Z

.field final synthetic this$0:Lco/vine/android/recorder/VineRecorder;


# direct methods
.method public constructor <init>(Lco/vine/android/recorder/VineRecorder;)V
    .locals 1

    .prologue
    .line 1953
    iput-object p1, p0, Lco/vine/android/recorder/VineRecorder$SegmentChangeDetector;->this$0:Lco/vine/android/recorder/VineRecorder;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 1950
    const/4 v0, 0x0

    iput v0, p0, Lco/vine/android/recorder/VineRecorder$SegmentChangeDetector;->lastFirstItem:I

    .line 1954
    const/4 v0, 0x1

    iput-boolean v0, p0, Lco/vine/android/recorder/VineRecorder$SegmentChangeDetector;->runThread:Z

    .line 1955
    return-void
.end method


# virtual methods
.method public run()V
    .locals 11

    .prologue
    .line 1959
    :goto_0
    iget-boolean v6, p0, Lco/vine/android/recorder/VineRecorder$SegmentChangeDetector;->runThread:Z

    if-eqz v6, :cond_1

    .line 1961
    :try_start_0
    iget-object v6, p0, Lco/vine/android/recorder/VineRecorder$SegmentChangeDetector;->this$0:Lco/vine/android/recorder/VineRecorder;

    # getter for: Lco/vine/android/recorder/VineRecorder;->mLastSelectedPosition:I
    invoke-static {v6}, Lco/vine/android/recorder/VineRecorder;->access$4400(Lco/vine/android/recorder/VineRecorder;)I

    move-result v6

    const/4 v7, -0x1

    if-ne v6, v7, :cond_0

    iget-object v6, p0, Lco/vine/android/recorder/VineRecorder$SegmentChangeDetector;->this$0:Lco/vine/android/recorder/VineRecorder;

    # getter for: Lco/vine/android/recorder/VineRecorder;->mEditorAdapter:Lco/vine/android/recorder/SegmentEditorAdapter;
    invoke-static {v6}, Lco/vine/android/recorder/VineRecorder;->access$2300(Lco/vine/android/recorder/VineRecorder;)Lco/vine/android/recorder/SegmentEditorAdapter;

    move-result-object v6

    if-eqz v6, :cond_0

    .line 1963
    iget-object v6, p0, Lco/vine/android/recorder/VineRecorder$SegmentChangeDetector;->this$0:Lco/vine/android/recorder/VineRecorder;

    # getter for: Lco/vine/android/recorder/VineRecorder;->mVideoPlayer:Lco/vine/android/player/SdkVideoView;
    invoke-static {v6}, Lco/vine/android/recorder/VineRecorder;->access$1900(Lco/vine/android/recorder/VineRecorder;)Lco/vine/android/player/SdkVideoView;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/player/SdkVideoView;->isPlaying()Z

    move-result v6

    if-eqz v6, :cond_0

    .line 1964
    iget-object v6, p0, Lco/vine/android/recorder/VineRecorder$SegmentChangeDetector;->this$0:Lco/vine/android/recorder/VineRecorder;

    # getter for: Lco/vine/android/recorder/VineRecorder;->mVideoPlayer:Lco/vine/android/player/SdkVideoView;
    invoke-static {v6}, Lco/vine/android/recorder/VineRecorder;->access$1900(Lco/vine/android/recorder/VineRecorder;)Lco/vine/android/player/SdkVideoView;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/player/SdkVideoView;->getCurrentPosition()I

    move-result v6

    add-int/lit8 v3, v6, 0x14

    .line 1965
    .local v3, "position":I
    if-lez v3, :cond_0

    .line 1966
    iget-object v6, p0, Lco/vine/android/recorder/VineRecorder$SegmentChangeDetector;->this$0:Lco/vine/android/recorder/VineRecorder;

    # getter for: Lco/vine/android/recorder/VineRecorder;->mEditorAdapter:Lco/vine/android/recorder/SegmentEditorAdapter;
    invoke-static {v6}, Lco/vine/android/recorder/VineRecorder;->access$2300(Lco/vine/android/recorder/VineRecorder;)Lco/vine/android/recorder/SegmentEditorAdapter;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/recorder/SegmentEditorAdapter;->getData()Ljava/util/ArrayList;

    move-result-object v4

    .line 1967
    .local v4, "segments":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/recorder/RecordSegment;>;"
    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    move-result v5

    .line 1968
    .local v5, "size":I
    if-lez v5, :cond_0

    .line 1969
    add-int/lit8 v2, v5, -0x1

    .local v2, "i":I
    :goto_1
    if-ltz v2, :cond_0

    .line 1970
    int-to-long v7, v3

    invoke-virtual {v4, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lco/vine/android/recorder/RecordSegment;

    iget-wide v9, v6, Lco/vine/android/recorder/RecordSegment;->startTimestamp:J

    cmp-long v6, v7, v9

    if-ltz v6, :cond_3

    .line 1971
    iget v6, p0, Lco/vine/android/recorder/VineRecorder$SegmentChangeDetector;->lastFirstItem:I

    if-ne v6, v2, :cond_2

    .line 1996
    .end local v2    # "i":I
    .end local v3    # "position":I
    .end local v4    # "segments":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/recorder/RecordSegment;>;"
    .end local v5    # "size":I
    :cond_0
    :goto_2
    const-wide/16 v6, 0x28

    invoke-static {v6, v7}, Ljava/lang/Thread;->sleep(J)V

    goto :goto_0

    .line 1997
    :catch_0
    move-exception v1

    .line 2001
    :cond_1
    return-void

    .line 1974
    .restart local v2    # "i":I
    .restart local v3    # "position":I
    .restart local v4    # "segments":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/recorder/RecordSegment;>;"
    .restart local v5    # "size":I
    :cond_2
    iput v2, p0, Lco/vine/android/recorder/VineRecorder$SegmentChangeDetector;->lastFirstItem:I

    .line 1975
    iget-object v6, p0, Lco/vine/android/recorder/VineRecorder$SegmentChangeDetector;->this$0:Lco/vine/android/recorder/VineRecorder;

    iget-object v0, v6, Lco/vine/android/recorder/VineRecorder;->mActivity:Landroid/app/Activity;

    .line 1976
    .local v0, "activity":Landroid/app/Activity;
    if-eqz v0, :cond_0

    .line 1977
    new-instance v6, Lco/vine/android/recorder/VineRecorder$SegmentChangeDetector$1;

    invoke-direct {v6, p0}, Lco/vine/android/recorder/VineRecorder$SegmentChangeDetector$1;-><init>(Lco/vine/android/recorder/VineRecorder$SegmentChangeDetector;)V

    invoke-virtual {v0, v6}, Landroid/app/Activity;->runOnUiThread(Ljava/lang/Runnable;)V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_2

    .line 1969
    .end local v0    # "activity":Landroid/app/Activity;
    :cond_3
    add-int/lit8 v2, v2, -0x1

    goto :goto_1
.end method
