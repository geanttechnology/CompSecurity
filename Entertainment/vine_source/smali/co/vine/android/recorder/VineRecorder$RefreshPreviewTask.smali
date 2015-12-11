.class Lco/vine/android/recorder/VineRecorder$RefreshPreviewTask;
.super Landroid/os/AsyncTask;
.source "VineRecorder.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/recorder/VineRecorder;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "RefreshPreviewTask"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        ">;"
    }
.end annotation


# instance fields
.field private final mSegment:Lco/vine/android/recorder/RecordSegment;

.field final synthetic this$0:Lco/vine/android/recorder/VineRecorder;


# direct methods
.method public constructor <init>(Lco/vine/android/recorder/VineRecorder;Lco/vine/android/recorder/RecordSegment;)V
    .locals 0
    .param p2, "segment"    # Lco/vine/android/recorder/RecordSegment;

    .prologue
    .line 1312
    iput-object p1, p0, Lco/vine/android/recorder/VineRecorder$RefreshPreviewTask;->this$0:Lco/vine/android/recorder/VineRecorder;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    .line 1313
    iput-object p2, p0, Lco/vine/android/recorder/VineRecorder$RefreshPreviewTask;->mSegment:Lco/vine/android/recorder/RecordSegment;

    .line 1314
    return-void
.end method


# virtual methods
.method protected bridge synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # [Ljava/lang/Object;

    .prologue
    .line 1308
    check-cast p1, [Ljava/lang/Void;

    .end local p1    # "x0":[Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lco/vine/android/recorder/VineRecorder$RefreshPreviewTask;->doInBackground([Ljava/lang/Void;)Ljava/lang/Void;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/Void;
    .locals 3
    .param p1, "params"    # [Ljava/lang/Void;

    .prologue
    .line 1318
    invoke-virtual {p0}, Lco/vine/android/recorder/VineRecorder$RefreshPreviewTask;->isCancelled()Z

    move-result v0

    if-nez v0, :cond_0

    .line 1319
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder$RefreshPreviewTask;->mSegment:Lco/vine/android/recorder/RecordSegment;

    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder$RefreshPreviewTask;->this$0:Lco/vine/android/recorder/VineRecorder;

    # getter for: Lco/vine/android/recorder/VineRecorder;->mLastPlayingSegment:Lco/vine/android/recorder/RecordSegment;
    invoke-static {v1}, Lco/vine/android/recorder/VineRecorder;->access$1100(Lco/vine/android/recorder/VineRecorder;)Lco/vine/android/recorder/RecordSegment;

    move-result-object v1

    if-eq v0, v1, :cond_2

    .line 1320
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder$RefreshPreviewTask;->mSegment:Lco/vine/android/recorder/RecordSegment;

    if-nez v0, :cond_1

    .line 1321
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder$RefreshPreviewTask;->this$0:Lco/vine/android/recorder/VineRecorder;

    # invokes: Lco/vine/android/recorder/VineRecorder;->refreshFullPreview()V
    invoke-static {v0}, Lco/vine/android/recorder/VineRecorder;->access$2200(Lco/vine/android/recorder/VineRecorder;)V

    .line 1329
    :cond_0
    :goto_0
    const/4 v0, 0x0

    return-object v0

    .line 1323
    :cond_1
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder$RefreshPreviewTask;->this$0:Lco/vine/android/recorder/VineRecorder;

    iget-object v0, v0, Lco/vine/android/recorder/VineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder$RefreshPreviewTask;->mSegment:Lco/vine/android/recorder/RecordSegment;

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Lco/vine/android/recorder/RecordController;->makePreview(Lco/vine/android/recorder/RecordSegment;Z)V

    goto :goto_0

    .line 1325
    :cond_2
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder$RefreshPreviewTask;->mSegment:Lco/vine/android/recorder/RecordSegment;

    if-nez v0, :cond_0

    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder$RefreshPreviewTask;->this$0:Lco/vine/android/recorder/VineRecorder;

    # getter for: Lco/vine/android/recorder/VineRecorder;->mEditorAdapter:Lco/vine/android/recorder/SegmentEditorAdapter;
    invoke-static {v0}, Lco/vine/android/recorder/VineRecorder;->access$2300(Lco/vine/android/recorder/VineRecorder;)Lco/vine/android/recorder/SegmentEditorAdapter;

    move-result-object v0

    iget-boolean v0, v0, Lco/vine/android/recorder/SegmentEditorAdapter;->hasInitialized:Z

    if-eqz v0, :cond_0

    .line 1326
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder$RefreshPreviewTask;->this$0:Lco/vine/android/recorder/VineRecorder;

    # invokes: Lco/vine/android/recorder/VineRecorder;->refreshFullPreview()V
    invoke-static {v0}, Lco/vine/android/recorder/VineRecorder;->access$2200(Lco/vine/android/recorder/VineRecorder;)V

    goto :goto_0
.end method

.method public onCancelled()V
    .locals 2

    .prologue
    .line 1370
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder$RefreshPreviewTask;->this$0:Lco/vine/android/recorder/VineRecorder;

    const/4 v1, 0x0

    # invokes: Lco/vine/android/recorder/VineRecorder;->animatePreviewSpinner(Z)V
    invoke-static {v0, v1}, Lco/vine/android/recorder/VineRecorder;->access$2800(Lco/vine/android/recorder/VineRecorder;Z)V

    .line 1371
    return-void
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 1308
    check-cast p1, Ljava/lang/Void;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lco/vine/android/recorder/VineRecorder$RefreshPreviewTask;->onPostExecute(Ljava/lang/Void;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/Void;)V
    .locals 12
    .param p1, "aVoid"    # Ljava/lang/Void;

    .prologue
    const/4 v3, 0x0

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 1334
    iget-object v6, p0, Lco/vine/android/recorder/VineRecorder$RefreshPreviewTask;->this$0:Lco/vine/android/recorder/VineRecorder;

    # getter for: Lco/vine/android/recorder/VineRecorder;->mEditorAdapter:Lco/vine/android/recorder/SegmentEditorAdapter;
    invoke-static {v6}, Lco/vine/android/recorder/VineRecorder;->access$2300(Lco/vine/android/recorder/VineRecorder;)Lco/vine/android/recorder/SegmentEditorAdapter;

    move-result-object v0

    .line 1335
    .local v0, "adapter":Lco/vine/android/recorder/SegmentEditorAdapter;
    iget-object v6, p0, Lco/vine/android/recorder/VineRecorder$RefreshPreviewTask;->this$0:Lco/vine/android/recorder/VineRecorder;

    # getter for: Lco/vine/android/recorder/VineRecorder;->mVideoPlayer:Lco/vine/android/player/SdkVideoView;
    invoke-static {v6}, Lco/vine/android/recorder/VineRecorder;->access$1900(Lco/vine/android/recorder/VineRecorder;)Lco/vine/android/player/SdkVideoView;

    move-result-object v2

    .line 1336
    .local v2, "player":Lco/vine/android/player/SdkVideoView;
    if-eqz v2, :cond_6

    .line 1337
    if-eqz v0, :cond_8

    invoke-virtual {p0}, Lco/vine/android/recorder/VineRecorder$RefreshPreviewTask;->isCancelled()Z

    move-result v6

    if-nez v6, :cond_8

    invoke-virtual {v0}, Lco/vine/android/recorder/SegmentEditorAdapter;->getCount()I

    move-result v6

    if-lez v6, :cond_8

    .line 1338
    iget-object v6, p0, Lco/vine/android/recorder/VineRecorder$RefreshPreviewTask;->this$0:Lco/vine/android/recorder/VineRecorder;

    # getter for: Lco/vine/android/recorder/VineRecorder;->mVideoPlayer:Lco/vine/android/player/SdkVideoView;
    invoke-static {v6}, Lco/vine/android/recorder/VineRecorder;->access$1900(Lco/vine/android/recorder/VineRecorder;)Lco/vine/android/player/SdkVideoView;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/player/SdkVideoView;->getParent()Landroid/view/ViewParent;

    move-result-object v1

    check-cast v1, Landroid/view/ViewGroup;

    .line 1339
    .local v1, "group":Landroid/view/ViewGroup;
    iget-object v6, p0, Lco/vine/android/recorder/VineRecorder$RefreshPreviewTask;->this$0:Lco/vine/android/recorder/VineRecorder;

    # getter for: Lco/vine/android/recorder/VineRecorder;->mVideoAttr:Landroid/util/AttributeSet;
    invoke-static {v6}, Lco/vine/android/recorder/VineRecorder;->access$2400(Lco/vine/android/recorder/VineRecorder;)Landroid/util/AttributeSet;

    move-result-object v6

    if-nez v6, :cond_0

    .line 1340
    iget-object v6, p0, Lco/vine/android/recorder/VineRecorder$RefreshPreviewTask;->this$0:Lco/vine/android/recorder/VineRecorder;

    iget-object v7, p0, Lco/vine/android/recorder/VineRecorder$RefreshPreviewTask;->this$0:Lco/vine/android/recorder/VineRecorder;

    # getter for: Lco/vine/android/recorder/VineRecorder;->mVideoPlayer:Lco/vine/android/player/SdkVideoView;
    invoke-static {v7}, Lco/vine/android/recorder/VineRecorder;->access$1900(Lco/vine/android/recorder/VineRecorder;)Lco/vine/android/player/SdkVideoView;

    move-result-object v7

    invoke-virtual {v7}, Lco/vine/android/player/SdkVideoView;->getAttributes()Landroid/util/AttributeSet;

    move-result-object v7

    # setter for: Lco/vine/android/recorder/VineRecorder;->mVideoAttr:Landroid/util/AttributeSet;
    invoke-static {v6, v7}, Lco/vine/android/recorder/VineRecorder;->access$2402(Lco/vine/android/recorder/VineRecorder;Landroid/util/AttributeSet;)Landroid/util/AttributeSet;

    .line 1342
    :cond_0
    iget-object v6, p0, Lco/vine/android/recorder/VineRecorder$RefreshPreviewTask;->this$0:Lco/vine/android/recorder/VineRecorder;

    # getter for: Lco/vine/android/recorder/VineRecorder;->mVideoPlayer:Lco/vine/android/player/SdkVideoView;
    invoke-static {v6}, Lco/vine/android/recorder/VineRecorder;->access$1900(Lco/vine/android/recorder/VineRecorder;)Lco/vine/android/player/SdkVideoView;

    move-result-object v6

    invoke-virtual {v6, v5}, Lco/vine/android/player/SdkVideoView;->setLooping(Z)V

    .line 1343
    iget-object v6, p0, Lco/vine/android/recorder/VineRecorder$RefreshPreviewTask;->this$0:Lco/vine/android/recorder/VineRecorder;

    # getter for: Lco/vine/android/recorder/VineRecorder;->mVideoPlayer:Lco/vine/android/player/SdkVideoView;
    invoke-static {v6}, Lco/vine/android/recorder/VineRecorder;->access$1900(Lco/vine/android/recorder/VineRecorder;)Lco/vine/android/player/SdkVideoView;

    move-result-object v6

    invoke-virtual {v6, v4}, Lco/vine/android/player/SdkVideoView;->setVisibility(I)V

    .line 1344
    if-eqz v1, :cond_1

    .line 1345
    new-instance v6, Lco/vine/android/recorder/VineRecorder$EditModePreviewClickListener;

    iget-object v7, p0, Lco/vine/android/recorder/VineRecorder$RefreshPreviewTask;->this$0:Lco/vine/android/recorder/VineRecorder;

    invoke-direct {v6, v7, v3}, Lco/vine/android/recorder/VineRecorder$EditModePreviewClickListener;-><init>(Lco/vine/android/recorder/VineRecorder;Lco/vine/android/recorder/VineRecorder$1;)V

    invoke-virtual {v1, v6}, Landroid/view/ViewGroup;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 1347
    :cond_1
    iget-object v6, p0, Lco/vine/android/recorder/VineRecorder$RefreshPreviewTask;->this$0:Lco/vine/android/recorder/VineRecorder;

    # getter for: Lco/vine/android/recorder/VineRecorder;->mDragSortWidget:Lco/vine/android/dragsort/DragSortWidget;
    invoke-static {v6}, Lco/vine/android/recorder/VineRecorder;->access$2600(Lco/vine/android/recorder/VineRecorder;)Lco/vine/android/dragsort/DragSortWidget;

    move-result-object v6

    if-eqz v6, :cond_2

    .line 1348
    iget-object v6, p0, Lco/vine/android/recorder/VineRecorder$RefreshPreviewTask;->this$0:Lco/vine/android/recorder/VineRecorder;

    # getter for: Lco/vine/android/recorder/VineRecorder;->mDragSortWidget:Lco/vine/android/dragsort/DragSortWidget;
    invoke-static {v6}, Lco/vine/android/recorder/VineRecorder;->access$2600(Lco/vine/android/recorder/VineRecorder;)Lco/vine/android/dragsort/DragSortWidget;

    move-result-object v6

    new-instance v7, Landroid/graphics/Rect;

    iget-object v8, p0, Lco/vine/android/recorder/VineRecorder$RefreshPreviewTask;->this$0:Lco/vine/android/recorder/VineRecorder;

    # getter for: Lco/vine/android/recorder/VineRecorder;->mEditorButtonsHeight:I
    invoke-static {v8}, Lco/vine/android/recorder/VineRecorder;->access$1600(Lco/vine/android/recorder/VineRecorder;)I

    move-result v8

    iget-object v9, p0, Lco/vine/android/recorder/VineRecorder$RefreshPreviewTask;->this$0:Lco/vine/android/recorder/VineRecorder;

    iget-object v9, v9, Lco/vine/android/recorder/VineRecorder;->mSize:Landroid/graphics/Point;

    iget v9, v9, Landroid/graphics/Point;->x:I

    iget-object v10, p0, Lco/vine/android/recorder/VineRecorder$RefreshPreviewTask;->this$0:Lco/vine/android/recorder/VineRecorder;

    # getter for: Lco/vine/android/recorder/VineRecorder;->mEditorButtonsHeight:I
    invoke-static {v10}, Lco/vine/android/recorder/VineRecorder;->access$1600(Lco/vine/android/recorder/VineRecorder;)I

    move-result v10

    iget-object v11, p0, Lco/vine/android/recorder/VineRecorder$RefreshPreviewTask;->this$0:Lco/vine/android/recorder/VineRecorder;

    iget-object v11, v11, Lco/vine/android/recorder/VineRecorder;->mSize:Landroid/graphics/Point;

    iget v11, v11, Landroid/graphics/Point;->x:I

    add-int/2addr v10, v11

    invoke-direct {v7, v4, v8, v9, v10}, Landroid/graphics/Rect;-><init>(IIII)V

    invoke-virtual {v6, v1, v7}, Lco/vine/android/dragsort/DragSortWidget;->setContentView(Landroid/view/View;Landroid/graphics/Rect;)V

    .line 1351
    :cond_2
    iget-object v6, p0, Lco/vine/android/recorder/VineRecorder$RefreshPreviewTask;->this$0:Lco/vine/android/recorder/VineRecorder;

    # invokes: Lco/vine/android/recorder/VineRecorder;->adjustEditBoundaries()V
    invoke-static {v6}, Lco/vine/android/recorder/VineRecorder;->access$2700(Lco/vine/android/recorder/VineRecorder;)V

    .line 1352
    iget-object v6, p0, Lco/vine/android/recorder/VineRecorder$RefreshPreviewTask;->this$0:Lco/vine/android/recorder/VineRecorder;

    iget-object v7, p0, Lco/vine/android/recorder/VineRecorder$RefreshPreviewTask;->mSegment:Lco/vine/android/recorder/RecordSegment;

    # setter for: Lco/vine/android/recorder/VineRecorder;->mLastPlayingSegment:Lco/vine/android/recorder/RecordSegment;
    invoke-static {v6, v7}, Lco/vine/android/recorder/VineRecorder;->access$1102(Lco/vine/android/recorder/VineRecorder;Lco/vine/android/recorder/RecordSegment;)Lco/vine/android/recorder/RecordSegment;

    .line 1353
    iget-object v6, p0, Lco/vine/android/recorder/VineRecorder$RefreshPreviewTask;->mSegment:Lco/vine/android/recorder/RecordSegment;

    if-nez v6, :cond_7

    iget-object v6, p0, Lco/vine/android/recorder/VineRecorder$RefreshPreviewTask;->this$0:Lco/vine/android/recorder/VineRecorder;

    iget-object v6, v6, Lco/vine/android/recorder/VineRecorder;->mCurrentRecordingFile:Lco/vine/android/recorder/RecordingFile;

    if-eqz v6, :cond_3

    iget-object v6, p0, Lco/vine/android/recorder/VineRecorder$RefreshPreviewTask;->this$0:Lco/vine/android/recorder/VineRecorder;

    iget-object v6, v6, Lco/vine/android/recorder/VineRecorder;->mCurrentRecordingFile:Lco/vine/android/recorder/RecordingFile;

    invoke-virtual {v6}, Lco/vine/android/recorder/RecordingFile;->getPreviewVideoPath()Ljava/lang/String;

    move-result-object v3

    .line 1356
    .local v3, "videoPath":Ljava/lang/String;
    :cond_3
    :goto_0
    iget-object v6, p0, Lco/vine/android/recorder/VineRecorder$RefreshPreviewTask;->this$0:Lco/vine/android/recorder/VineRecorder;

    # getter for: Lco/vine/android/recorder/VineRecorder;->mVideoPlayer:Lco/vine/android/player/SdkVideoView;
    invoke-static {v6}, Lco/vine/android/recorder/VineRecorder;->access$1900(Lco/vine/android/recorder/VineRecorder;)Lco/vine/android/player/SdkVideoView;

    move-result-object v6

    if-eqz v6, :cond_6

    if-eqz v3, :cond_6

    .line 1357
    iget-object v6, p0, Lco/vine/android/recorder/VineRecorder$RefreshPreviewTask;->this$0:Lco/vine/android/recorder/VineRecorder;

    # getter for: Lco/vine/android/recorder/VineRecorder;->mVideoPlayer:Lco/vine/android/player/SdkVideoView;
    invoke-static {v6}, Lco/vine/android/recorder/VineRecorder;->access$1900(Lco/vine/android/recorder/VineRecorder;)Lco/vine/android/player/SdkVideoView;

    move-result-object v6

    iget-object v7, p0, Lco/vine/android/recorder/VineRecorder$RefreshPreviewTask;->this$0:Lco/vine/android/recorder/VineRecorder;

    # getter for: Lco/vine/android/recorder/VineRecorder;->mDragSortWidget:Lco/vine/android/dragsort/DragSortWidget;
    invoke-static {v7}, Lco/vine/android/recorder/VineRecorder;->access$2600(Lco/vine/android/recorder/VineRecorder;)Lco/vine/android/dragsort/DragSortWidget;

    move-result-object v7

    if-eqz v7, :cond_4

    iget-object v7, p0, Lco/vine/android/recorder/VineRecorder$RefreshPreviewTask;->this$0:Lco/vine/android/recorder/VineRecorder;

    # getter for: Lco/vine/android/recorder/VineRecorder;->mDragSortWidget:Lco/vine/android/dragsort/DragSortWidget;
    invoke-static {v7}, Lco/vine/android/recorder/VineRecorder;->access$2600(Lco/vine/android/recorder/VineRecorder;)Lco/vine/android/dragsort/DragSortWidget;

    move-result-object v7

    invoke-virtual {v7}, Lco/vine/android/dragsort/DragSortWidget;->hasFloatView()Z

    move-result v7

    if-nez v7, :cond_5

    :cond_4
    move v4, v5

    :cond_5
    invoke-virtual {v6, v4}, Lco/vine/android/player/SdkVideoView;->setAutoPlayOnPrepared(Z)V

    .line 1358
    iget-object v4, p0, Lco/vine/android/recorder/VineRecorder$RefreshPreviewTask;->this$0:Lco/vine/android/recorder/VineRecorder;

    # getter for: Lco/vine/android/recorder/VineRecorder;->mVideoPlayer:Lco/vine/android/player/SdkVideoView;
    invoke-static {v4}, Lco/vine/android/recorder/VineRecorder;->access$1900(Lco/vine/android/recorder/VineRecorder;)Lco/vine/android/player/SdkVideoView;

    move-result-object v4

    iget-object v5, p0, Lco/vine/android/recorder/VineRecorder$RefreshPreviewTask;->this$0:Lco/vine/android/recorder/VineRecorder;

    invoke-virtual {v4, v5}, Lco/vine/android/player/SdkVideoView;->setOnPreparedListener(Lco/vine/android/player/VideoViewInterface$OnPreparedListener;)V

    .line 1359
    iget-object v4, p0, Lco/vine/android/recorder/VineRecorder$RefreshPreviewTask;->this$0:Lco/vine/android/recorder/VineRecorder;

    # getter for: Lco/vine/android/recorder/VineRecorder;->mVideoPlayer:Lco/vine/android/player/SdkVideoView;
    invoke-static {v4}, Lco/vine/android/recorder/VineRecorder;->access$1900(Lco/vine/android/recorder/VineRecorder;)Lco/vine/android/player/SdkVideoView;

    move-result-object v4

    iget-object v5, p0, Lco/vine/android/recorder/VineRecorder$RefreshPreviewTask;->this$0:Lco/vine/android/recorder/VineRecorder;

    invoke-virtual {v4, v5}, Lco/vine/android/player/SdkVideoView;->setOnErrorListener(Lco/vine/android/player/VideoViewInterface$OnErrorListener;)V

    .line 1360
    iget-object v4, p0, Lco/vine/android/recorder/VineRecorder$RefreshPreviewTask;->this$0:Lco/vine/android/recorder/VineRecorder;

    # getter for: Lco/vine/android/recorder/VineRecorder;->mVideoPlayer:Lco/vine/android/player/SdkVideoView;
    invoke-static {v4}, Lco/vine/android/recorder/VineRecorder;->access$1900(Lco/vine/android/recorder/VineRecorder;)Lco/vine/android/player/SdkVideoView;

    move-result-object v4

    invoke-virtual {v4, v3}, Lco/vine/android/player/SdkVideoView;->setVideoPath(Ljava/lang/String;)V

    .line 1366
    .end local v1    # "group":Landroid/view/ViewGroup;
    .end local v3    # "videoPath":Ljava/lang/String;
    :cond_6
    :goto_1
    return-void

    .line 1353
    .restart local v1    # "group":Landroid/view/ViewGroup;
    :cond_7
    iget-object v6, p0, Lco/vine/android/recorder/VineRecorder$RefreshPreviewTask;->mSegment:Lco/vine/android/recorder/RecordSegment;

    iget-object v3, v6, Lco/vine/android/recorder/RecordSegment;->videoPath:Ljava/lang/String;

    goto :goto_0

    .line 1363
    .end local v1    # "group":Landroid/view/ViewGroup;
    :cond_8
    iget-object v4, p0, Lco/vine/android/recorder/VineRecorder$RefreshPreviewTask;->this$0:Lco/vine/android/recorder/VineRecorder;

    # getter for: Lco/vine/android/recorder/VineRecorder;->mVideoPlayer:Lco/vine/android/player/SdkVideoView;
    invoke-static {v4}, Lco/vine/android/recorder/VineRecorder;->access$1900(Lco/vine/android/recorder/VineRecorder;)Lco/vine/android/player/SdkVideoView;

    move-result-object v4

    const/16 v5, 0x8

    invoke-virtual {v4, v5}, Lco/vine/android/player/SdkVideoView;->setVisibility(I)V

    goto :goto_1
.end method
