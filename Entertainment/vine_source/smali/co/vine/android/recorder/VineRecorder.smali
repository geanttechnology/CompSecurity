.class public Lco/vine/android/recorder/VineRecorder;
.super Lco/vine/android/recorder/RegularVineRecorder;
.source "VineRecorder.java"

# interfaces
.implements Landroid/view/View$OnTouchListener;
.implements Lco/vine/android/recorder/RecordController$OnRecorderControllerStateChangedListener;
.implements Lco/vine/android/dragsort/DragSortWidget$SelectionChangedListener;
.implements Lco/vine/android/player/VideoViewInterface$OnPreparedListener;
.implements Lco/vine/android/dragsort/DragSortWidget$FloatViewInteractionListener;
.implements Lco/vine/android/dragsort/DragSortWidget$CurrentlyPlayingProvider;
.implements Landroid/view/View$OnKeyListener;


# annotations
.annotation build Landroid/annotation/TargetApi;
    value = 0xe
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/recorder/VineRecorder$SegmentChangeDetector;,
        Lco/vine/android/recorder/VineRecorder$PlayButtonOnClickListener;,
        Lco/vine/android/recorder/VineRecorder$EditModePreviewClickListener;,
        Lco/vine/android/recorder/VineRecorder$RefreshPreviewTask;
    }
.end annotation


# static fields
.field private static final JAPANESE_LANG:Ljava/lang/String; = "ja"

.field private static final JAPANESE_MCC:I = 0x1b8

.field private static final REMOVE_THUMBNAIL_MILLIS:J = 0x64L

.field private static final TRANSITION_DURATION:J = 0xfaL

.field private static final TRASH_BRIGHT:I = 0x1

.field private static final TRASH_INVISIBLE:I = 0x2

.field private static final TRASH_VISIBLE:I


# instance fields
.field public detectedInvalidSession:Z

.field private mCameraSwitcher:Landroid/view/ViewGroup;

.field private final mCameraSwitcherId:I

.field private final mCameraSwitcherViewListener:Landroid/view/View$OnClickListener;

.field private final mChangeProgressOverlayVisibilityRunnable:Ljava/lang/Runnable;

.field private mCurrentFrameRate:I

.field private mDefaultColor:I

.field private mDragSortWidget:Lco/vine/android/dragsort/DragSortWidget;

.field private final mDragSortWidgetId:I

.field private mEditing:Z

.field private mEditorAdapter:Lco/vine/android/recorder/SegmentEditorAdapter;

.field private mEditorButtons:Landroid/view/View;

.field private mEditorButtonsHeight:I

.field private final mEditorButtonsId:I

.field private mEditorCancelButton:Landroid/view/View;

.field private final mEditorCancelButtonId:I

.field private mEditorDoneButton:Landroid/view/View;

.field private final mEditorDoneButtonId:I

.field private mEnabledColor:I

.field private mFinishButton:Landroid/view/View;

.field private final mFinishButtonId:I

.field private final mFinishClicker:Landroid/view/View$OnClickListener;

.field private mFinishLoadingOverlay:Landroid/view/View;

.field private final mFinishLoadingOverlayId:I

.field private mFlashSwitcher:Landroid/view/View;

.field private final mFlashSwitcherId:I

.field private final mFocusAnimationSet:Landroid/view/animation/AnimationSet;

.field private final mFocusDisabledDrawable:I

.field private final mFocusDismissAnimation:Landroid/view/animation/AlphaAnimation;

.field private final mFocusEnabledDrawable:I

.field private final mFocusIndicator:Landroid/widget/ImageView;

.field private mFocusView:Landroid/view/View;

.field private final mFocusViewResourceId:I

.field private final mGhostButton:Landroid/widget/ToggleButton;

.field private mGhostModeEnabled:Z

.field private final mGhostView:Landroid/widget/ImageView;

.field private mGridSwitch:Landroid/widget/ToggleButton;

.field private final mGridSwitchId:I

.field private mHasPreviewedAlready:Z

.field private final mInitiallyStartedWithEditMode:Z

.field private mIsGridOn:Z

.field private final mIsMessaging:Z

.field private mLastPlayingSegment:Lco/vine/android/recorder/RecordSegment;

.field private mLastSelectedPosition:I

.field private mLastUpdatedZoom:I

.field private mMediaActionSound:Landroid/media/MediaActionSound;

.field private mPickedUpPosition:I

.field private mPlayButton:Landroid/view/View;

.field private mPlayButtonContainer:Landroid/view/View;

.field private final mPlayButtonContainerId:I

.field private mPlayButtonOnClickListener:Lco/vine/android/recorder/VineRecorder$PlayButtonOnClickListener;

.field private mPlayRefreshButton:Landroid/view/View;

.field private mPlaySound:Z

.field private mPreviewLoadingOverlay:Landroid/view/View;

.field private final mPreviewLoadingOverlayId:I

.field private mProgressOverlay:Landroid/view/View;

.field private final mProgressOverlayId:I

.field private mRecordingOptions:Landroid/view/View;

.field private final mRecordingOptionsRowId:I

.field private mRefreshPreviewTask:Lco/vine/android/recorder/VineRecorder$RefreshPreviewTask;

.field private mResources:Landroid/content/res/Resources;

.field private mReturnToPreview:Z

.field private mSegmentChangeDetector:Lco/vine/android/recorder/VineRecorder$SegmentChangeDetector;

.field private mSegmentChangeThread:Ljava/lang/Thread;

.field private mShortAnimTime:I

.field private mStartWithEditMode:Z

.field private final mSwitchFlashViewListener:Landroid/view/View$OnClickListener;

.field private mThumbnailList:Landroid/view/View;

.field private mThumbnailOverlay:Landroid/widget/ImageView;

.field private final mThumbnailOverlayId:I

.field private mThumbnailPadding:I

.field private mThumbnailSegment:Lco/vine/android/recorder/RecordSegment;

.field private mTimeLapseDelay:D

.field mTimeLapseRunnable:Ljava/lang/Runnable;

.field private mTimelapsing:Z

.field private mTrashCanButton:Landroid/view/View;

.field private final mTrashCanButtonId:I

.field private mTrashUndoContainer:Landroid/view/View;

.field private final mTrashUndoContainerId:I

.field private mUndoButton:Landroid/view/View;

.field private final mUndoButtonId:I

.field private mVideoAttr:Landroid/util/AttributeSet;

.field private mVideoPlayer:Lco/vine/android/player/SdkVideoView;

.field private mVideoViewParams:Landroid/widget/RelativeLayout$LayoutParams;

.field private mZoomSeek:Landroid/widget/SeekBar;

.field private mZoomSeekContainer:Landroid/view/View;

.field private final mZoomSeekContainerId:I

.field private final mZoomSeekId:I

.field private final mZoomSeekListener:Landroid/widget/SeekBar$OnSeekBarChangeListener;

.field private final mZoomUpdateRunnable:Ljava/lang/Runnable;

.field private final onCameraReadyRunnable:Ljava/lang/Runnable;


# direct methods
.method public varargs constructor <init>(Lco/vine/android/recorder/RecordSessionVersion;ZLandroid/graphics/Point;ZZLco/vine/android/recorder/RecordingFile;Landroid/app/Activity;Lco/vine/android/player/SdkVideoView;IIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIILjava/lang/String;Landroid/widget/ToggleButton;ZZIIIILandroid/media/MediaActionSound;[Ljava/lang/CharSequence;)V
    .locals 18
    .param p1, "version"    # Lco/vine/android/recorder/RecordSessionVersion;
    .param p2, "startWithEditMode"    # Z
    .param p3, "screenSize"    # Landroid/graphics/Point;
    .param p4, "returnToPreview"    # Z
    .param p5, "hasPreviewedAlready"    # Z
    .param p6, "file"    # Lco/vine/android/recorder/RecordingFile;
    .param p7, "activity"    # Landroid/app/Activity;
    .param p8, "videoPlayer"    # Lco/vine/android/player/SdkVideoView;
    .param p9, "recordingOptionsRowId"    # I
    .param p10, "dragSortWidgetId"    # I
    .param p11, "gridButton"    # I
    .param p12, "ghostViewId"    # I
    .param p13, "focusIndicatorId"    # I
    .param p14, "focusEnabledDrawable"    # I
    .param p15, "focusDisabledDrawable"    # I
    .param p16, "focusViewResourceId"    # I
    .param p17, "progressViewResourceId"    # I
    .param p18, "cameraViewResourceId"    # I
    .param p19, "cameraSwitcher"    # I
    .param p20, "flashSwitcherId"    # I
    .param p21, "finishButtonId"    # I
    .param p22, "topMaskId"    # I
    .param p23, "bottomMaskId"    # I
    .param p24, "editorButtonsId"    # I
    .param p25, "editorDoneButtonId"    # I
    .param p26, "editorCancelButtonId"    # I
    .param p27, "trashUndoContainerId"    # I
    .param p28, "trashCanButtonId"    # I
    .param p29, "unDoButtonId"    # I
    .param p30, "lastSegmentString"    # I
    .param p31, "cameraFailString"    # I
    .param p32, "openCameraString"    # I
    .param p33, "playButtonContainerId"    # I
    .param p34, "thumbnailOverlayId"    # I
    .param p35, "rootLayoutId"    # I
    .param p36, "editorPadding"    # I
    .param p37, "editorButtonsHeight"    # I
    .param p38, "finishLoadingOverlayId"    # I
    .param p39, "previewLoadingOverlayId"    # I
    .param p40, "progressOverlay"    # I
    .param p41, "deviceNotSupportedString"    # Ljava/lang/String;
    .param p42, "ghostButton"    # Landroid/widget/ToggleButton;
    .param p43, "startWithFrontFacingCamera"    # Z
    .param p44, "isMessaging"    # Z
    .param p45, "color"    # I
    .param p46, "defaultColor"    # I
    .param p47, "zoomSeekContainerId"    # I
    .param p48, "zoomSeekId"    # I
    .param p49, "mediaActionSound"    # Landroid/media/MediaActionSound;
    .param p50, "messages"    # [Ljava/lang/CharSequence;

    .prologue
    .line 248
    if-eqz p44, :cond_2

    const/16 v3, 0x42

    :goto_0
    move-object/from16 v2, p0

    move-object/from16 v4, p3

    move-object/from16 v5, p7

    move/from16 v6, p17

    move/from16 v7, p18

    move/from16 v8, p22

    move/from16 v9, p23

    move/from16 v10, p31

    move/from16 v11, p32

    move/from16 v12, p35

    move-object/from16 v13, p41

    move/from16 v14, p43

    move-object/from16 v15, p1

    move-object/from16 v16, p50

    invoke-direct/range {v2 .. v16}, Lco/vine/android/recorder/RegularVineRecorder;-><init>(ILandroid/graphics/Point;Landroid/app/Activity;IIIIIIILjava/lang/String;ZLco/vine/android/recorder/RecordSessionVersion;[Ljava/lang/CharSequence;)V

    .line 127
    const/4 v2, 0x0

    move-object/from16 v0, p0

    iput-boolean v2, v0, Lco/vine/android/recorder/VineRecorder;->mGhostModeEnabled:Z

    .line 128
    new-instance v2, Lco/vine/android/recorder/RecordSegment;

    const-wide/16 v3, 0x0

    invoke-direct {v2, v3, v4}, Lco/vine/android/recorder/RecordSegment;-><init>(J)V

    move-object/from16 v0, p0

    iput-object v2, v0, Lco/vine/android/recorder/VineRecorder;->mLastPlayingSegment:Lco/vine/android/recorder/RecordSegment;

    .line 131
    new-instance v2, Lco/vine/android/recorder/VineRecorder$1;

    move-object/from16 v0, p0

    invoke-direct {v2, v0}, Lco/vine/android/recorder/VineRecorder$1;-><init>(Lco/vine/android/recorder/VineRecorder;)V

    move-object/from16 v0, p0

    iput-object v2, v0, Lco/vine/android/recorder/VineRecorder;->mSwitchFlashViewListener:Landroid/view/View$OnClickListener;

    .line 138
    new-instance v2, Lco/vine/android/recorder/VineRecorder$2;

    move-object/from16 v0, p0

    invoke-direct {v2, v0}, Lco/vine/android/recorder/VineRecorder$2;-><init>(Lco/vine/android/recorder/VineRecorder;)V

    move-object/from16 v0, p0

    iput-object v2, v0, Lco/vine/android/recorder/VineRecorder;->mZoomSeekListener:Landroid/widget/SeekBar$OnSeekBarChangeListener;

    .line 154
    new-instance v2, Lco/vine/android/recorder/VineRecorder$3;

    move-object/from16 v0, p0

    invoke-direct {v2, v0}, Lco/vine/android/recorder/VineRecorder$3;-><init>(Lco/vine/android/recorder/VineRecorder;)V

    move-object/from16 v0, p0

    iput-object v2, v0, Lco/vine/android/recorder/VineRecorder;->mCameraSwitcherViewListener:Landroid/view/View$OnClickListener;

    .line 176
    new-instance v2, Lco/vine/android/recorder/VineRecorder$4;

    move-object/from16 v0, p0

    invoke-direct {v2, v0}, Lco/vine/android/recorder/VineRecorder$4;-><init>(Lco/vine/android/recorder/VineRecorder;)V

    move-object/from16 v0, p0

    iput-object v2, v0, Lco/vine/android/recorder/VineRecorder;->onCameraReadyRunnable:Ljava/lang/Runnable;

    .line 230
    const/4 v2, 0x0

    move-object/from16 v0, p0

    iput-boolean v2, v0, Lco/vine/android/recorder/VineRecorder;->mPlaySound:Z

    .line 231
    const/4 v2, -0x1

    move-object/from16 v0, p0

    iput v2, v0, Lco/vine/android/recorder/VineRecorder;->mLastUpdatedZoom:I

    .line 337
    new-instance v2, Lco/vine/android/recorder/VineRecorder$6;

    move-object/from16 v0, p0

    invoke-direct {v2, v0}, Lco/vine/android/recorder/VineRecorder$6;-><init>(Lco/vine/android/recorder/VineRecorder;)V

    move-object/from16 v0, p0

    iput-object v2, v0, Lco/vine/android/recorder/VineRecorder;->mFinishClicker:Landroid/view/View$OnClickListener;

    .line 374
    new-instance v2, Lco/vine/android/recorder/VineRecorder$7;

    move-object/from16 v0, p0

    invoke-direct {v2, v0}, Lco/vine/android/recorder/VineRecorder$7;-><init>(Lco/vine/android/recorder/VineRecorder;)V

    move-object/from16 v0, p0

    iput-object v2, v0, Lco/vine/android/recorder/VineRecorder;->mZoomUpdateRunnable:Ljava/lang/Runnable;

    .line 1193
    const/4 v2, 0x0

    move-object/from16 v0, p0

    iput-boolean v2, v0, Lco/vine/android/recorder/VineRecorder;->mTimelapsing:Z

    .line 1194
    new-instance v2, Lco/vine/android/recorder/VineRecorder$17;

    move-object/from16 v0, p0

    invoke-direct {v2, v0}, Lco/vine/android/recorder/VineRecorder$17;-><init>(Lco/vine/android/recorder/VineRecorder;)V

    move-object/from16 v0, p0

    iput-object v2, v0, Lco/vine/android/recorder/VineRecorder;->mTimeLapseRunnable:Ljava/lang/Runnable;

    .line 1928
    new-instance v2, Lco/vine/android/recorder/VineRecorder$31;

    move-object/from16 v0, p0

    invoke-direct {v2, v0}, Lco/vine/android/recorder/VineRecorder$31;-><init>(Lco/vine/android/recorder/VineRecorder;)V

    move-object/from16 v0, p0

    iput-object v2, v0, Lco/vine/android/recorder/VineRecorder;->mChangeProgressOverlayVisibilityRunnable:Ljava/lang/Runnable;

    .line 252
    move/from16 v0, p4

    move-object/from16 v1, p0

    iput-boolean v0, v1, Lco/vine/android/recorder/VineRecorder;->mReturnToPreview:Z

    .line 253
    move/from16 v0, p5

    move-object/from16 v1, p0

    iput-boolean v0, v1, Lco/vine/android/recorder/VineRecorder;->mHasPreviewedAlready:Z

    .line 254
    move/from16 v0, p2

    move-object/from16 v1, p0

    iput-boolean v0, v1, Lco/vine/android/recorder/VineRecorder;->mStartWithEditMode:Z

    .line 255
    move/from16 v0, p2

    move-object/from16 v1, p0

    iput-boolean v0, v1, Lco/vine/android/recorder/VineRecorder;->mInitiallyStartedWithEditMode:Z

    .line 256
    move/from16 v0, p27

    move-object/from16 v1, p0

    iput v0, v1, Lco/vine/android/recorder/VineRecorder;->mTrashUndoContainerId:I

    .line 257
    move/from16 v0, p37

    move-object/from16 v1, p0

    iput v0, v1, Lco/vine/android/recorder/VineRecorder;->mEditorButtonsHeight:I

    .line 258
    move-object/from16 v0, p8

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/recorder/VineRecorder;->mVideoPlayer:Lco/vine/android/player/SdkVideoView;

    .line 259
    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/recorder/VineRecorder;->mActivity:Landroid/app/Activity;

    invoke-virtual {v2}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const/high16 v3, 0x10e0000

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getInteger(I)I

    move-result v2

    move-object/from16 v0, p0

    iput v2, v0, Lco/vine/android/recorder/VineRecorder;->mShortAnimTime:I

    .line 260
    move/from16 v0, p36

    move-object/from16 v1, p0

    iput v0, v1, Lco/vine/android/recorder/VineRecorder;->mThumbnailPadding:I

    .line 261
    move/from16 v0, p29

    move-object/from16 v1, p0

    iput v0, v1, Lco/vine/android/recorder/VineRecorder;->mUndoButtonId:I

    .line 262
    move/from16 v0, p21

    move-object/from16 v1, p0

    iput v0, v1, Lco/vine/android/recorder/VineRecorder;->mFinishButtonId:I

    .line 263
    move-object/from16 v0, p42

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/recorder/VineRecorder;->mGhostButton:Landroid/widget/ToggleButton;

    .line 264
    move-object/from16 v0, p7

    move/from16 v1, p30

    invoke-virtual {v0, v1}, Landroid/app/Activity;->getText(I)Ljava/lang/CharSequence;

    move-result-object v2

    move-object/from16 v0, p0

    iput-object v2, v0, Lco/vine/android/recorder/VineRecorder;->mFinishLastSegmentString:Ljava/lang/CharSequence;

    .line 265
    move/from16 v0, p34

    move-object/from16 v1, p0

    iput v0, v1, Lco/vine/android/recorder/VineRecorder;->mThumbnailOverlayId:I

    .line 266
    move/from16 v0, p20

    move-object/from16 v1, p0

    iput v0, v1, Lco/vine/android/recorder/VineRecorder;->mFlashSwitcherId:I

    .line 267
    move/from16 v0, p19

    move-object/from16 v1, p0

    iput v0, v1, Lco/vine/android/recorder/VineRecorder;->mCameraSwitcherId:I

    .line 268
    move/from16 v0, p11

    move-object/from16 v1, p0

    iput v0, v1, Lco/vine/android/recorder/VineRecorder;->mGridSwitchId:I

    .line 269
    move/from16 v0, p38

    move-object/from16 v1, p0

    iput v0, v1, Lco/vine/android/recorder/VineRecorder;->mFinishLoadingOverlayId:I

    .line 270
    move/from16 v0, p33

    move-object/from16 v1, p0

    iput v0, v1, Lco/vine/android/recorder/VineRecorder;->mPlayButtonContainerId:I

    .line 271
    move/from16 v0, p39

    move-object/from16 v1, p0

    iput v0, v1, Lco/vine/android/recorder/VineRecorder;->mPreviewLoadingOverlayId:I

    .line 272
    move/from16 v0, p24

    move-object/from16 v1, p0

    iput v0, v1, Lco/vine/android/recorder/VineRecorder;->mEditorButtonsId:I

    .line 273
    move/from16 v0, p25

    move-object/from16 v1, p0

    iput v0, v1, Lco/vine/android/recorder/VineRecorder;->mEditorDoneButtonId:I

    .line 274
    move/from16 v0, p26

    move-object/from16 v1, p0

    iput v0, v1, Lco/vine/android/recorder/VineRecorder;->mEditorCancelButtonId:I

    .line 275
    move/from16 v0, p28

    move-object/from16 v1, p0

    iput v0, v1, Lco/vine/android/recorder/VineRecorder;->mTrashCanButtonId:I

    .line 276
    move/from16 v0, p9

    move-object/from16 v1, p0

    iput v0, v1, Lco/vine/android/recorder/VineRecorder;->mRecordingOptionsRowId:I

    .line 277
    move/from16 v0, p16

    move-object/from16 v1, p0

    iput v0, v1, Lco/vine/android/recorder/VineRecorder;->mFocusViewResourceId:I

    .line 278
    move/from16 v0, p14

    move-object/from16 v1, p0

    iput v0, v1, Lco/vine/android/recorder/VineRecorder;->mFocusEnabledDrawable:I

    .line 279
    move/from16 v0, p15

    move-object/from16 v1, p0

    iput v0, v1, Lco/vine/android/recorder/VineRecorder;->mFocusDisabledDrawable:I

    .line 280
    move/from16 v0, p10

    move-object/from16 v1, p0

    iput v0, v1, Lco/vine/android/recorder/VineRecorder;->mDragSortWidgetId:I

    .line 281
    move-object/from16 v0, p7

    move/from16 v1, p13

    invoke-virtual {v0, v1}, Landroid/app/Activity;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ImageView;

    move-object/from16 v0, p0

    iput-object v2, v0, Lco/vine/android/recorder/VineRecorder;->mFocusIndicator:Landroid/widget/ImageView;

    .line 282
    move-object/from16 v0, p7

    move/from16 v1, p12

    invoke-virtual {v0, v1}, Landroid/app/Activity;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ImageView;

    move-object/from16 v0, p0

    iput-object v2, v0, Lco/vine/android/recorder/VineRecorder;->mGhostView:Landroid/widget/ImageView;

    .line 283
    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/recorder/VineRecorder;->mGhostView:Landroid/widget/ImageView;

    const v3, 0x3eb33333    # 0.35f

    invoke-virtual {v2, v3}, Landroid/widget/ImageView;->setAlpha(F)V

    .line 284
    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/recorder/VineRecorder;->mFocusIndicator:Landroid/widget/ImageView;

    invoke-static {v2}, Lco/vine/android/recorder/RecordingAnimations;->getFocusDismissAnimation(Landroid/widget/ImageView;)Landroid/view/animation/AlphaAnimation;

    move-result-object v2

    move-object/from16 v0, p0

    iput-object v2, v0, Lco/vine/android/recorder/VineRecorder;->mFocusDismissAnimation:Landroid/view/animation/AlphaAnimation;

    .line 285
    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/recorder/VineRecorder;->mFocusDismissAnimation:Landroid/view/animation/AlphaAnimation;

    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/recorder/VineRecorder;->mFocusIndicator:Landroid/widget/ImageView;

    invoke-static {v2, v3}, Lco/vine/android/recorder/RecordingAnimations;->getFocusAnimationSet(Landroid/view/animation/AlphaAnimation;Landroid/widget/ImageView;)Landroid/view/animation/AnimationSet;

    move-result-object v2

    move-object/from16 v0, p0

    iput-object v2, v0, Lco/vine/android/recorder/VineRecorder;->mFocusAnimationSet:Landroid/view/animation/AnimationSet;

    .line 287
    move/from16 v0, p40

    move-object/from16 v1, p0

    iput v0, v1, Lco/vine/android/recorder/VineRecorder;->mProgressOverlayId:I

    .line 288
    move-object/from16 v0, p49

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/recorder/VineRecorder;->mMediaActionSound:Landroid/media/MediaActionSound;

    .line 290
    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v17

    .line 294
    .local v17, "locale":Ljava/util/Locale;
    if-eqz v17, :cond_0

    const-string v2, "ja"

    invoke-virtual/range {v17 .. v17}, Ljava/util/Locale;->getLanguage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_1

    :cond_0
    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/recorder/VineRecorder;->mActivity:Landroid/app/Activity;

    invoke-virtual {v2}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v2

    iget v2, v2, Landroid/content/res/Configuration;->mcc:I

    const/16 v3, 0x1b8

    if-ne v2, v3, :cond_3

    :cond_1
    const/4 v2, 0x1

    :goto_1
    move-object/from16 v0, p0

    iput-boolean v2, v0, Lco/vine/android/recorder/VineRecorder;->mPlaySound:Z

    .line 296
    const-string v2, "Init"

    move-object/from16 v0, p0

    move-object/from16 v1, p6

    invoke-virtual {v0, v2, v1}, Lco/vine/android/recorder/VineRecorder;->swapSession(Ljava/lang/String;Lco/vine/android/recorder/RecordingFile;)Lco/vine/android/recorder/RecordingFile;

    .line 297
    move/from16 v0, p44

    move-object/from16 v1, p0

    iput-boolean v0, v1, Lco/vine/android/recorder/VineRecorder;->mIsMessaging:Z

    .line 298
    move/from16 v0, p45

    move-object/from16 v1, p0

    iput v0, v1, Lco/vine/android/recorder/VineRecorder;->mEnabledColor:I

    .line 299
    move/from16 v0, p46

    move-object/from16 v1, p0

    iput v0, v1, Lco/vine/android/recorder/VineRecorder;->mDefaultColor:I

    .line 300
    move/from16 v0, p47

    move-object/from16 v1, p0

    iput v0, v1, Lco/vine/android/recorder/VineRecorder;->mZoomSeekContainerId:I

    .line 301
    move/from16 v0, p48

    move-object/from16 v1, p0

    iput v0, v1, Lco/vine/android/recorder/VineRecorder;->mZoomSeekId:I

    .line 302
    return-void

    .line 248
    .end local v17    # "locale":Ljava/util/Locale;
    :cond_2
    const/16 v3, 0x3e8

    goto/16 :goto_0

    .line 294
    .restart local v17    # "locale":Ljava/util/Locale;
    :cond_3
    const/4 v2, 0x0

    goto :goto_1
.end method

.method static synthetic access$000(Lco/vine/android/recorder/VineRecorder;)V
    .locals 0
    .param p0, "x0"    # Lco/vine/android/recorder/VineRecorder;

    .prologue
    .line 57
    invoke-direct {p0}, Lco/vine/android/recorder/VineRecorder;->invalidateZoomSlider()V

    return-void
.end method

.method static synthetic access$100(Lco/vine/android/recorder/VineRecorder;)Landroid/view/View;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/recorder/VineRecorder;

    .prologue
    .line 57
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mFocusView:Landroid/view/View;

    return-object v0
.end method

.method static synthetic access$1000(Lco/vine/android/recorder/VineRecorder;)Z
    .locals 1
    .param p0, "x0"    # Lco/vine/android/recorder/VineRecorder;

    .prologue
    .line 57
    iget-boolean v0, p0, Lco/vine/android/recorder/VineRecorder;->mInitiallyStartedWithEditMode:Z

    return v0
.end method

.method static synthetic access$1100(Lco/vine/android/recorder/VineRecorder;)Lco/vine/android/recorder/RecordSegment;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/recorder/VineRecorder;

    .prologue
    .line 57
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mLastPlayingSegment:Lco/vine/android/recorder/RecordSegment;

    return-object v0
.end method

.method static synthetic access$1102(Lco/vine/android/recorder/VineRecorder;Lco/vine/android/recorder/RecordSegment;)Lco/vine/android/recorder/RecordSegment;
    .locals 0
    .param p0, "x0"    # Lco/vine/android/recorder/VineRecorder;
    .param p1, "x1"    # Lco/vine/android/recorder/RecordSegment;

    .prologue
    .line 57
    iput-object p1, p0, Lco/vine/android/recorder/VineRecorder;->mLastPlayingSegment:Lco/vine/android/recorder/RecordSegment;

    return-object p1
.end method

.method static synthetic access$1200(Lco/vine/android/recorder/VineRecorder;)Landroid/widget/SeekBar;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/recorder/VineRecorder;

    .prologue
    .line 57
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mZoomSeek:Landroid/widget/SeekBar;

    return-object v0
.end method

.method static synthetic access$1300(Lco/vine/android/recorder/VineRecorder;)I
    .locals 1
    .param p0, "x0"    # Lco/vine/android/recorder/VineRecorder;

    .prologue
    .line 57
    iget v0, p0, Lco/vine/android/recorder/VineRecorder;->mLastUpdatedZoom:I

    return v0
.end method

.method static synthetic access$1400(Lco/vine/android/recorder/VineRecorder;)Landroid/widget/ImageView;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/recorder/VineRecorder;

    .prologue
    .line 57
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mGhostView:Landroid/widget/ImageView;

    return-object v0
.end method

.method static synthetic access$1500(Lco/vine/android/recorder/VineRecorder;)Landroid/view/View;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/recorder/VineRecorder;

    .prologue
    .line 57
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mRecordingOptions:Landroid/view/View;

    return-object v0
.end method

.method static synthetic access$1600(Lco/vine/android/recorder/VineRecorder;)I
    .locals 1
    .param p0, "x0"    # Lco/vine/android/recorder/VineRecorder;

    .prologue
    .line 57
    iget v0, p0, Lco/vine/android/recorder/VineRecorder;->mEditorButtonsHeight:I

    return v0
.end method

.method static synthetic access$1700(Lco/vine/android/recorder/VineRecorder;)Landroid/view/View;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/recorder/VineRecorder;

    .prologue
    .line 57
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mEditorButtons:Landroid/view/View;

    return-object v0
.end method

.method static synthetic access$1800(Lco/vine/android/recorder/VineRecorder;)Landroid/view/View;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/recorder/VineRecorder;

    .prologue
    .line 57
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mThumbnailList:Landroid/view/View;

    return-object v0
.end method

.method static synthetic access$1900(Lco/vine/android/recorder/VineRecorder;)Lco/vine/android/player/SdkVideoView;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/recorder/VineRecorder;

    .prologue
    .line 57
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mVideoPlayer:Lco/vine/android/player/SdkVideoView;

    return-object v0
.end method

.method static synthetic access$200(Lco/vine/android/recorder/VineRecorder;)I
    .locals 1
    .param p0, "x0"    # Lco/vine/android/recorder/VineRecorder;

    .prologue
    .line 57
    iget v0, p0, Lco/vine/android/recorder/VineRecorder;->mFocusEnabledDrawable:I

    return v0
.end method

.method static synthetic access$2000(Lco/vine/android/recorder/VineRecorder;)Landroid/widget/RelativeLayout$LayoutParams;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/recorder/VineRecorder;

    .prologue
    .line 57
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mVideoViewParams:Landroid/widget/RelativeLayout$LayoutParams;

    return-object v0
.end method

.method static synthetic access$2100(Lco/vine/android/recorder/VineRecorder;)D
    .locals 2
    .param p0, "x0"    # Lco/vine/android/recorder/VineRecorder;

    .prologue
    .line 57
    iget-wide v0, p0, Lco/vine/android/recorder/VineRecorder;->mTimeLapseDelay:D

    return-wide v0
.end method

.method static synthetic access$2200(Lco/vine/android/recorder/VineRecorder;)V
    .locals 0
    .param p0, "x0"    # Lco/vine/android/recorder/VineRecorder;

    .prologue
    .line 57
    invoke-direct {p0}, Lco/vine/android/recorder/VineRecorder;->refreshFullPreview()V

    return-void
.end method

.method static synthetic access$2300(Lco/vine/android/recorder/VineRecorder;)Lco/vine/android/recorder/SegmentEditorAdapter;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/recorder/VineRecorder;

    .prologue
    .line 57
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mEditorAdapter:Lco/vine/android/recorder/SegmentEditorAdapter;

    return-object v0
.end method

.method static synthetic access$2400(Lco/vine/android/recorder/VineRecorder;)Landroid/util/AttributeSet;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/recorder/VineRecorder;

    .prologue
    .line 57
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mVideoAttr:Landroid/util/AttributeSet;

    return-object v0
.end method

.method static synthetic access$2402(Lco/vine/android/recorder/VineRecorder;Landroid/util/AttributeSet;)Landroid/util/AttributeSet;
    .locals 0
    .param p0, "x0"    # Lco/vine/android/recorder/VineRecorder;
    .param p1, "x1"    # Landroid/util/AttributeSet;

    .prologue
    .line 57
    iput-object p1, p0, Lco/vine/android/recorder/VineRecorder;->mVideoAttr:Landroid/util/AttributeSet;

    return-object p1
.end method

.method static synthetic access$2600(Lco/vine/android/recorder/VineRecorder;)Lco/vine/android/dragsort/DragSortWidget;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/recorder/VineRecorder;

    .prologue
    .line 57
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mDragSortWidget:Lco/vine/android/dragsort/DragSortWidget;

    return-object v0
.end method

.method static synthetic access$2700(Lco/vine/android/recorder/VineRecorder;)V
    .locals 0
    .param p0, "x0"    # Lco/vine/android/recorder/VineRecorder;

    .prologue
    .line 57
    invoke-direct {p0}, Lco/vine/android/recorder/VineRecorder;->adjustEditBoundaries()V

    return-void
.end method

.method static synthetic access$2800(Lco/vine/android/recorder/VineRecorder;Z)V
    .locals 0
    .param p0, "x0"    # Lco/vine/android/recorder/VineRecorder;
    .param p1, "x1"    # Z

    .prologue
    .line 57
    invoke-direct {p0, p1}, Lco/vine/android/recorder/VineRecorder;->animatePreviewSpinner(Z)V

    return-void
.end method

.method static synthetic access$2900(Lco/vine/android/recorder/VineRecorder;)Lco/vine/android/recorder/VineRecorder$PlayButtonOnClickListener;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/recorder/VineRecorder;

    .prologue
    .line 57
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mPlayButtonOnClickListener:Lco/vine/android/recorder/VineRecorder$PlayButtonOnClickListener;

    return-object v0
.end method

.method static synthetic access$300(Lco/vine/android/recorder/VineRecorder;)Landroid/content/res/Resources;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/recorder/VineRecorder;

    .prologue
    .line 57
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mResources:Landroid/content/res/Resources;

    return-object v0
.end method

.method static synthetic access$3000(Lco/vine/android/recorder/VineRecorder;)Landroid/view/View;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/recorder/VineRecorder;

    .prologue
    .line 57
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mFinishLoadingOverlay:Landroid/view/View;

    return-object v0
.end method

.method static synthetic access$3100(Lco/vine/android/recorder/VineRecorder;Landroid/view/View;Z)V
    .locals 0
    .param p0, "x0"    # Lco/vine/android/recorder/VineRecorder;
    .param p1, "x1"    # Landroid/view/View;
    .param p2, "x2"    # Z

    .prologue
    .line 57
    invoke-direct {p0, p1, p2}, Lco/vine/android/recorder/VineRecorder;->animateSpinner(Landroid/view/View;Z)V

    return-void
.end method

.method static synthetic access$3200(Lco/vine/android/recorder/VineRecorder;)Landroid/view/View;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/recorder/VineRecorder;

    .prologue
    .line 57
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mTrashUndoContainer:Landroid/view/View;

    return-object v0
.end method

.method static synthetic access$3400(Lco/vine/android/recorder/VineRecorder;)Landroid/view/View;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/recorder/VineRecorder;

    .prologue
    .line 57
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mPlayButtonContainer:Landroid/view/View;

    return-object v0
.end method

.method static synthetic access$3500(Lco/vine/android/recorder/VineRecorder;)Z
    .locals 1
    .param p0, "x0"    # Lco/vine/android/recorder/VineRecorder;

    .prologue
    .line 57
    iget-boolean v0, p0, Lco/vine/android/recorder/VineRecorder;->mReturnToPreview:Z

    return v0
.end method

.method static synthetic access$3600(Lco/vine/android/recorder/VineRecorder;)J
    .locals 2
    .param p0, "x0"    # Lco/vine/android/recorder/VineRecorder;

    .prologue
    .line 57
    invoke-direct {p0}, Lco/vine/android/recorder/VineRecorder;->getDurationFromSegments()J

    move-result-wide v0

    return-wide v0
.end method

.method static synthetic access$3700(Lco/vine/android/recorder/VineRecorder;Z)V
    .locals 0
    .param p0, "x0"    # Lco/vine/android/recorder/VineRecorder;
    .param p1, "x1"    # Z

    .prologue
    .line 57
    invoke-direct {p0, p1}, Lco/vine/android/recorder/VineRecorder;->animateEditModeControlsOut(Z)V

    return-void
.end method

.method static synthetic access$3800(Lco/vine/android/recorder/VineRecorder;Z)V
    .locals 0
    .param p0, "x0"    # Lco/vine/android/recorder/VineRecorder;
    .param p1, "x1"    # Z

    .prologue
    .line 57
    invoke-direct {p0, p1}, Lco/vine/android/recorder/VineRecorder;->returnToPreview(Z)V

    return-void
.end method

.method static synthetic access$3900(Lco/vine/android/recorder/VineRecorder;)Landroid/view/View;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/recorder/VineRecorder;

    .prologue
    .line 57
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mEditorDoneButton:Landroid/view/View;

    return-object v0
.end method

.method static synthetic access$400(Lco/vine/android/recorder/VineRecorder;)I
    .locals 1
    .param p0, "x0"    # Lco/vine/android/recorder/VineRecorder;

    .prologue
    .line 57
    iget v0, p0, Lco/vine/android/recorder/VineRecorder;->mFocusDisabledDrawable:I

    return v0
.end method

.method static synthetic access$4000(Lco/vine/android/recorder/VineRecorder;)Z
    .locals 1
    .param p0, "x0"    # Lco/vine/android/recorder/VineRecorder;

    .prologue
    .line 57
    iget-boolean v0, p0, Lco/vine/android/recorder/VineRecorder;->mEditing:Z

    return v0
.end method

.method static synthetic access$4100(Lco/vine/android/recorder/VineRecorder;I)V
    .locals 0
    .param p0, "x0"    # Lco/vine/android/recorder/VineRecorder;
    .param p1, "x1"    # I

    .prologue
    .line 57
    invoke-direct {p0, p1}, Lco/vine/android/recorder/VineRecorder;->animateTopButtons(I)V

    return-void
.end method

.method static synthetic access$4200(Lco/vine/android/recorder/VineRecorder;)Landroid/view/View;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/recorder/VineRecorder;

    .prologue
    .line 57
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mUndoButton:Landroid/view/View;

    return-object v0
.end method

.method static synthetic access$4300(Lco/vine/android/recorder/VineRecorder;)Landroid/view/View;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/recorder/VineRecorder;

    .prologue
    .line 57
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mEditorCancelButton:Landroid/view/View;

    return-object v0
.end method

.method static synthetic access$4400(Lco/vine/android/recorder/VineRecorder;)I
    .locals 1
    .param p0, "x0"    # Lco/vine/android/recorder/VineRecorder;

    .prologue
    .line 57
    iget v0, p0, Lco/vine/android/recorder/VineRecorder;->mLastSelectedPosition:I

    return v0
.end method

.method static synthetic access$4402(Lco/vine/android/recorder/VineRecorder;I)I
    .locals 0
    .param p0, "x0"    # Lco/vine/android/recorder/VineRecorder;
    .param p1, "x1"    # I

    .prologue
    .line 57
    iput p1, p0, Lco/vine/android/recorder/VineRecorder;->mLastSelectedPosition:I

    return p1
.end method

.method static synthetic access$4500(Lco/vine/android/recorder/VineRecorder;)Landroid/view/View;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/recorder/VineRecorder;

    .prologue
    .line 57
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mProgressOverlay:Landroid/view/View;

    return-object v0
.end method

.method static synthetic access$500(Lco/vine/android/recorder/VineRecorder;)Z
    .locals 1
    .param p0, "x0"    # Lco/vine/android/recorder/VineRecorder;

    .prologue
    .line 57
    iget-boolean v0, p0, Lco/vine/android/recorder/VineRecorder;->mIsMessaging:Z

    return v0
.end method

.method static synthetic access$600(Lco/vine/android/recorder/VineRecorder;)I
    .locals 1
    .param p0, "x0"    # Lco/vine/android/recorder/VineRecorder;

    .prologue
    .line 57
    iget v0, p0, Lco/vine/android/recorder/VineRecorder;->mEnabledColor:I

    return v0
.end method

.method static synthetic access$700(Lco/vine/android/recorder/VineRecorder;)Landroid/view/ViewGroup;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/recorder/VineRecorder;

    .prologue
    .line 57
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mCameraSwitcher:Landroid/view/ViewGroup;

    return-object v0
.end method

.method static synthetic access$800(Lco/vine/android/recorder/VineRecorder;)Landroid/widget/ToggleButton;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/recorder/VineRecorder;

    .prologue
    .line 57
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mGridSwitch:Landroid/widget/ToggleButton;

    return-object v0
.end method

.method static synthetic access$900(Lco/vine/android/recorder/VineRecorder;)Z
    .locals 1
    .param p0, "x0"    # Lco/vine/android/recorder/VineRecorder;

    .prologue
    .line 57
    iget-boolean v0, p0, Lco/vine/android/recorder/VineRecorder;->mIsGridOn:Z

    return v0
.end method

.method private adjustEditBoundaries()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 815
    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mVideoPlayer:Lco/vine/android/player/SdkVideoView;

    if-eqz v1, :cond_0

    .line 816
    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mVideoPlayer:Lco/vine/android/player/SdkVideoView;

    invoke-virtual {v1}, Lco/vine/android/player/SdkVideoView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v1

    check-cast v1, Landroid/widget/RelativeLayout$LayoutParams;

    iput-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mVideoViewParams:Landroid/widget/RelativeLayout$LayoutParams;

    .line 817
    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mVideoViewParams:Landroid/widget/RelativeLayout$LayoutParams;

    iget-object v2, p0, Lco/vine/android/recorder/VineRecorder;->mSize:Landroid/graphics/Point;

    iget v2, v2, Landroid/graphics/Point;->x:I

    iput v2, v1, Landroid/widget/RelativeLayout$LayoutParams;->width:I

    .line 818
    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mVideoViewParams:Landroid/widget/RelativeLayout$LayoutParams;

    iget-object v2, p0, Lco/vine/android/recorder/VineRecorder;->mSize:Landroid/graphics/Point;

    iget v2, v2, Landroid/graphics/Point;->x:I

    iput v2, v1, Landroid/widget/RelativeLayout$LayoutParams;->height:I

    .line 820
    :cond_0
    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mPlayButtonContainer:Landroid/view/View;

    if-eqz v1, :cond_1

    .line 821
    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mPlayButtonContainer:Landroid/view/View;

    iget-object v2, p0, Lco/vine/android/recorder/VineRecorder;->mVideoViewParams:Landroid/widget/RelativeLayout$LayoutParams;

    invoke-virtual {v1, v2}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 823
    :cond_1
    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mThumbnailOverlay:Landroid/widget/ImageView;

    if-eqz v1, :cond_2

    .line 824
    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mThumbnailOverlay:Landroid/widget/ImageView;

    iget-object v2, p0, Lco/vine/android/recorder/VineRecorder;->mVideoViewParams:Landroid/widget/RelativeLayout$LayoutParams;

    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 826
    :cond_2
    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mPreviewLoadingOverlay:Landroid/view/View;

    if-eqz v1, :cond_3

    .line 827
    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mPreviewLoadingOverlay:Landroid/view/View;

    iget-object v2, p0, Lco/vine/android/recorder/VineRecorder;->mVideoViewParams:Landroid/widget/RelativeLayout$LayoutParams;

    invoke-virtual {v1, v2}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 831
    :cond_3
    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mThumbnailList:Landroid/view/View;

    if-eqz v1, :cond_5

    .line 832
    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mThumbnailList:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout$LayoutParams;

    .line 835
    .local v0, "thumbListParams":Landroid/widget/RelativeLayout$LayoutParams;
    iget v1, p0, Lco/vine/android/recorder/VineRecorder;->mEditorButtonsHeight:I

    iget-object v2, p0, Lco/vine/android/recorder/VineRecorder;->mSize:Landroid/graphics/Point;

    iget v2, v2, Landroid/graphics/Point;->x:I

    add-int/2addr v1, v2

    iget v2, p0, Lco/vine/android/recorder/VineRecorder;->mThumbnailPadding:I

    add-int/2addr v1, v2

    invoke-virtual {v0, v3, v1, v3, v3}, Landroid/widget/RelativeLayout$LayoutParams;->setMargins(IIII)V

    .line 841
    :goto_0
    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mActivity:Landroid/app/Activity;

    if-eqz v1, :cond_4

    .line 842
    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mActivity:Landroid/app/Activity;

    new-instance v2, Lco/vine/android/recorder/VineRecorder$12;

    invoke-direct {v2, p0, v0}, Lco/vine/android/recorder/VineRecorder$12;-><init>(Lco/vine/android/recorder/VineRecorder;Landroid/widget/RelativeLayout$LayoutParams;)V

    invoke-virtual {v1, v2}, Landroid/app/Activity;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 856
    :cond_4
    return-void

    .line 838
    .end local v0    # "thumbListParams":Landroid/widget/RelativeLayout$LayoutParams;
    :cond_5
    const/4 v0, 0x0

    .restart local v0    # "thumbListParams":Landroid/widget/RelativeLayout$LayoutParams;
    goto :goto_0
.end method

.method private animateCaptureControlsIn()V
    .locals 4

    .prologue
    .line 491
    invoke-virtual {p0}, Lco/vine/android/recorder/VineRecorder;->getHandler()Landroid/os/Handler;

    move-result-object v0

    new-instance v1, Lco/vine/android/recorder/VineRecorder$9;

    invoke-direct {v1, p0}, Lco/vine/android/recorder/VineRecorder$9;-><init>(Lco/vine/android/recorder/VineRecorder;)V

    const-wide/16 v2, 0xfa

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 513
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mCameraView:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 514
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mCameraView:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 516
    :cond_0
    return-void
.end method

.method private animateCaptureControlsOut()V
    .locals 7

    .prologue
    const-wide/16 v5, 0xfa

    const/4 v4, 0x0

    .line 519
    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mProgressView:Lco/vine/android/recorder/ProgressView;

    .line 520
    .local v1, "v":Landroid/view/View;
    if-eqz v1, :cond_0

    .line 521
    invoke-virtual {v1}, Landroid/view/View;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    .line 522
    .local v0, "am":Landroid/view/ViewPropertyAnimator;
    if-eqz v0, :cond_0

    .line 523
    invoke-virtual {v0, v4}, Landroid/view/ViewPropertyAnimator;->scaleY(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v2

    iget v3, p0, Lco/vine/android/recorder/VineRecorder;->mEditorButtonsHeight:I

    int-to-float v3, v3

    invoke-virtual {v2, v3}, Landroid/view/ViewPropertyAnimator;->translationY(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v2

    invoke-virtual {v2, v5, v6}, Landroid/view/ViewPropertyAnimator;->setDuration(J)Landroid/view/ViewPropertyAnimator;

    move-result-object v2

    new-instance v3, Lco/vine/android/recorder/ViewGoneAnimationListener;

    invoke-direct {v3, v1}, Lco/vine/android/recorder/ViewGoneAnimationListener;-><init>(Landroid/view/View;)V

    invoke-virtual {v2, v3}, Landroid/view/ViewPropertyAnimator;->setListener(Landroid/animation/Animator$AnimatorListener;)Landroid/view/ViewPropertyAnimator;

    move-result-object v2

    invoke-virtual {v2}, Landroid/view/ViewPropertyAnimator;->start()V

    .line 527
    .end local v0    # "am":Landroid/view/ViewPropertyAnimator;
    :cond_0
    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mTopMaskView:Landroid/view/View;

    .line 528
    if-eqz v1, :cond_1

    .line 529
    invoke-virtual {v1}, Landroid/view/View;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    .line 530
    .restart local v0    # "am":Landroid/view/ViewPropertyAnimator;
    if-eqz v0, :cond_1

    .line 531
    invoke-virtual {v0, v4}, Landroid/view/ViewPropertyAnimator;->alpha(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v2

    invoke-virtual {v2, v5, v6}, Landroid/view/ViewPropertyAnimator;->setDuration(J)Landroid/view/ViewPropertyAnimator;

    move-result-object v2

    new-instance v3, Lco/vine/android/recorder/ViewGoneAnimationListener;

    invoke-direct {v3, v1}, Lco/vine/android/recorder/ViewGoneAnimationListener;-><init>(Landroid/view/View;)V

    invoke-virtual {v2, v3}, Landroid/view/ViewPropertyAnimator;->setListener(Landroid/animation/Animator$AnimatorListener;)Landroid/view/ViewPropertyAnimator;

    move-result-object v2

    invoke-virtual {v2}, Landroid/view/ViewPropertyAnimator;->start()V

    .line 535
    .end local v0    # "am":Landroid/view/ViewPropertyAnimator;
    :cond_1
    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mRecordingOptions:Landroid/view/View;

    .line 536
    if-eqz v1, :cond_2

    .line 537
    invoke-virtual {v1}, Landroid/view/View;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    .line 538
    .restart local v0    # "am":Landroid/view/ViewPropertyAnimator;
    if-eqz v0, :cond_2

    .line 539
    invoke-virtual {v0, v4}, Landroid/view/ViewPropertyAnimator;->alpha(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v2

    invoke-virtual {v2, v5, v6}, Landroid/view/ViewPropertyAnimator;->setDuration(J)Landroid/view/ViewPropertyAnimator;

    move-result-object v2

    new-instance v3, Lco/vine/android/recorder/ViewGoneAnimationListener;

    invoke-direct {v3, v1}, Lco/vine/android/recorder/ViewGoneAnimationListener;-><init>(Landroid/view/View;)V

    invoke-virtual {v2, v3}, Landroid/view/ViewPropertyAnimator;->setListener(Landroid/animation/Animator$AnimatorListener;)Landroid/view/ViewPropertyAnimator;

    move-result-object v2

    invoke-virtual {v2}, Landroid/view/ViewPropertyAnimator;->start()V

    .line 543
    .end local v0    # "am":Landroid/view/ViewPropertyAnimator;
    :cond_2
    iget-object v2, p0, Lco/vine/android/recorder/VineRecorder;->mCameraView:Landroid/view/View;

    if-eqz v2, :cond_3

    .line 544
    iget-object v2, p0, Lco/vine/android/recorder/VineRecorder;->mCameraView:Landroid/view/View;

    const/4 v3, 0x4

    invoke-virtual {v2, v3}, Landroid/view/View;->setVisibility(I)V

    .line 546
    :cond_3
    return-void
.end method

.method private animateEditModeControlsIn()V
    .locals 7

    .prologue
    const/4 v6, 0x0

    const/4 v5, 0x0

    const/4 v4, 0x4

    .line 564
    invoke-virtual {p0}, Lco/vine/android/recorder/VineRecorder;->getHandler()Landroid/os/Handler;

    move-result-object v0

    new-instance v1, Lco/vine/android/recorder/VineRecorder$10;

    invoke-direct {v1, p0}, Lco/vine/android/recorder/VineRecorder$10;-><init>(Lco/vine/android/recorder/VineRecorder;)V

    const-wide/16 v2, 0xfa

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 583
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mVideoPlayer:Lco/vine/android/player/SdkVideoView;

    invoke-virtual {v0, v6}, Lco/vine/android/player/SdkVideoView;->setVisibility(I)V

    .line 585
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mPreviewLoadingOverlay:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 587
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mPreviewLoadingOverlay:Landroid/view/View;

    invoke-virtual {v0, v4}, Landroid/view/View;->setVisibility(I)V

    .line 588
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mPreviewLoadingOverlay:Landroid/view/View;

    invoke-virtual {v0, v5}, Landroid/view/View;->setAlpha(F)V

    .line 591
    :cond_0
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mPlayButtonContainer:Landroid/view/View;

    if-eqz v0, :cond_1

    .line 592
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mPlayButtonContainer:Landroid/view/View;

    invoke-virtual {v0, v4}, Landroid/view/View;->setVisibility(I)V

    .line 593
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mPlayButtonContainer:Landroid/view/View;

    invoke-virtual {v0, v5}, Landroid/view/View;->setAlpha(F)V

    .line 596
    :cond_1
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mTrashUndoContainer:Landroid/view/View;

    if-eqz v0, :cond_2

    .line 597
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mTrashUndoContainer:Landroid/view/View;

    invoke-virtual {v0, v6}, Landroid/view/View;->setVisibility(I)V

    .line 598
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mTrashUndoContainer:Landroid/view/View;

    const/high16 v1, 0x3f800000    # 1.0f

    invoke-virtual {v0, v1}, Landroid/view/View;->setAlpha(F)V

    .line 601
    :cond_2
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mTrashCanButton:Landroid/view/View;

    if-eqz v0, :cond_3

    .line 602
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mTrashCanButton:Landroid/view/View;

    invoke-virtual {v0, v4}, Landroid/view/View;->setVisibility(I)V

    .line 605
    :cond_3
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mUndoButton:Landroid/view/View;

    if-eqz v0, :cond_4

    .line 606
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mUndoButton:Landroid/view/View;

    invoke-virtual {v0, v4}, Landroid/view/View;->setVisibility(I)V

    .line 609
    :cond_4
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mThumbnailOverlay:Landroid/widget/ImageView;

    if-eqz v0, :cond_5

    .line 610
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mThumbnailOverlay:Landroid/widget/ImageView;

    invoke-virtual {v0, v4}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 612
    :cond_5
    return-void
.end method

.method private animateEditModeControlsOut(Z)V
    .locals 6
    .param p1, "hideVideo"    # Z

    .prologue
    const-wide/16 v4, 0xfa

    const/4 v3, 0x0

    .line 615
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mEditorAdapter:Lco/vine/android/recorder/SegmentEditorAdapter;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mThumbnailOverlay:Landroid/widget/ImageView;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mTrashUndoContainer:Landroid/view/View;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mPlayButtonContainer:Landroid/view/View;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mPreviewLoadingOverlay:Landroid/view/View;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mThumbnailList:Landroid/view/View;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mPlayButton:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 618
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mEditorButtons:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0, v3}, Landroid/view/ViewPropertyAnimator;->alpha(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0, v4, v5}, Landroid/view/ViewPropertyAnimator;->setDuration(J)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    new-instance v1, Lco/vine/android/recorder/ViewGoneAnimationListener;

    iget-object v2, p0, Lco/vine/android/recorder/VineRecorder;->mEditorButtons:Landroid/view/View;

    invoke-direct {v1, v2}, Lco/vine/android/recorder/ViewGoneAnimationListener;-><init>(Landroid/view/View;)V

    invoke-virtual {v0, v1}, Landroid/view/ViewPropertyAnimator;->setListener(Landroid/animation/Animator$AnimatorListener;)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/ViewPropertyAnimator;->start()V

    .line 620
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mThumbnailOverlay:Landroid/widget/ImageView;

    invoke-virtual {v0}, Landroid/widget/ImageView;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0, v3}, Landroid/view/ViewPropertyAnimator;->alpha(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0, v4, v5}, Landroid/view/ViewPropertyAnimator;->setDuration(J)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    new-instance v1, Lco/vine/android/recorder/ViewGoneAnimationListener;

    iget-object v2, p0, Lco/vine/android/recorder/VineRecorder;->mThumbnailOverlay:Landroid/widget/ImageView;

    invoke-direct {v1, v2}, Lco/vine/android/recorder/ViewGoneAnimationListener;-><init>(Landroid/view/View;)V

    invoke-virtual {v0, v1}, Landroid/view/ViewPropertyAnimator;->setListener(Landroid/animation/Animator$AnimatorListener;)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/ViewPropertyAnimator;->start()V

    .line 622
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mTrashUndoContainer:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0, v3}, Landroid/view/ViewPropertyAnimator;->alpha(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0, v4, v5}, Landroid/view/ViewPropertyAnimator;->setDuration(J)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    new-instance v1, Lco/vine/android/recorder/ViewGoneAnimationListener;

    iget-object v2, p0, Lco/vine/android/recorder/VineRecorder;->mTrashUndoContainer:Landroid/view/View;

    invoke-direct {v1, v2}, Lco/vine/android/recorder/ViewGoneAnimationListener;-><init>(Landroid/view/View;)V

    invoke-virtual {v0, v1}, Landroid/view/ViewPropertyAnimator;->setListener(Landroid/animation/Animator$AnimatorListener;)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/ViewPropertyAnimator;->start()V

    .line 624
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mPlayButtonContainer:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0, v3}, Landroid/view/ViewPropertyAnimator;->alpha(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0, v4, v5}, Landroid/view/ViewPropertyAnimator;->setDuration(J)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    new-instance v1, Lco/vine/android/recorder/ViewGoneAnimationListener;

    iget-object v2, p0, Lco/vine/android/recorder/VineRecorder;->mPlayButtonContainer:Landroid/view/View;

    invoke-direct {v1, v2}, Lco/vine/android/recorder/ViewGoneAnimationListener;-><init>(Landroid/view/View;)V

    invoke-virtual {v0, v1}, Landroid/view/ViewPropertyAnimator;->setListener(Landroid/animation/Animator$AnimatorListener;)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/ViewPropertyAnimator;->start()V

    .line 626
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mPreviewLoadingOverlay:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0, v3}, Landroid/view/ViewPropertyAnimator;->alpha(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0, v4, v5}, Landroid/view/ViewPropertyAnimator;->setDuration(J)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    new-instance v1, Lco/vine/android/recorder/ViewGoneAnimationListener;

    iget-object v2, p0, Lco/vine/android/recorder/VineRecorder;->mPreviewLoadingOverlay:Landroid/view/View;

    invoke-direct {v1, v2}, Lco/vine/android/recorder/ViewGoneAnimationListener;-><init>(Landroid/view/View;)V

    invoke-virtual {v0, v1}, Landroid/view/ViewPropertyAnimator;->setListener(Landroid/animation/Animator$AnimatorListener;)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/ViewPropertyAnimator;->start()V

    .line 628
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mThumbnailList:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0, v3}, Landroid/view/ViewPropertyAnimator;->scaleY(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mThumbnailList:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->getHeight()I

    move-result v1

    neg-int v1, v1

    div-int/lit8 v1, v1, 0x2

    int-to-float v1, v1

    invoke-virtual {v0, v1}, Landroid/view/ViewPropertyAnimator;->translationY(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0, v4, v5}, Landroid/view/ViewPropertyAnimator;->setDuration(J)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    new-instance v1, Lco/vine/android/recorder/ViewGoneAnimationListener;

    iget-object v2, p0, Lco/vine/android/recorder/VineRecorder;->mThumbnailList:Landroid/view/View;

    invoke-direct {v1, v2}, Lco/vine/android/recorder/ViewGoneAnimationListener;-><init>(Landroid/view/View;)V

    invoke-virtual {v0, v1}, Landroid/view/ViewPropertyAnimator;->setListener(Landroid/animation/Animator$AnimatorListener;)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/ViewPropertyAnimator;->start()V

    .line 632
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mPlayButtonContainer:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0, v3}, Landroid/view/ViewPropertyAnimator;->alpha(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0, v4, v5}, Landroid/view/ViewPropertyAnimator;->setDuration(J)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/ViewPropertyAnimator;->start()V

    .line 633
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mTrashUndoContainer:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setActivated(Z)V

    .line 634
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mDragSortWidget:Lco/vine/android/dragsort/DragSortWidget;

    const/4 v1, -0x1

    invoke-virtual {v0, v1}, Lco/vine/android/dragsort/DragSortWidget;->setSelection(I)V

    .line 636
    :cond_0
    if-eqz p1, :cond_1

    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mVideoPlayer:Lco/vine/android/player/SdkVideoView;

    if-eqz v0, :cond_1

    .line 637
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mVideoPlayer:Lco/vine/android/player/SdkVideoView;

    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Lco/vine/android/player/SdkVideoView;->setVisibility(I)V

    .line 639
    :cond_1
    return-void
.end method

.method private animatePlayButton(Z)V
    .locals 3
    .param p1, "visible"    # Z

    .prologue
    const/16 v2, 0x8

    const/4 v1, 0x0

    .line 1070
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mPlayButton:Landroid/view/View;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mPlayRefreshButton:Landroid/view/View;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mPlayButtonContainer:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 1071
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mPlayButtonContainer:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/ViewPropertyAnimator;->cancel()V

    .line 1072
    if-nez p1, :cond_1

    .line 1073
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mPlayButtonContainer:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/ViewPropertyAnimator;->alpha(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    iget v1, p0, Lco/vine/android/recorder/VineRecorder;->mShortAnimTime:I

    int-to-long v1, v1

    invoke-virtual {v0, v1, v2}, Landroid/view/ViewPropertyAnimator;->setDuration(J)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    new-instance v1, Lco/vine/android/recorder/ViewGoneAnimationListener;

    iget-object v2, p0, Lco/vine/android/recorder/VineRecorder;->mPlayButtonContainer:Landroid/view/View;

    invoke-direct {v1, v2}, Lco/vine/android/recorder/ViewGoneAnimationListener;-><init>(Landroid/view/View;)V

    invoke-virtual {v0, v1}, Landroid/view/ViewPropertyAnimator;->setListener(Landroid/animation/Animator$AnimatorListener;)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/ViewPropertyAnimator;->start()V

    .line 1094
    :cond_0
    :goto_0
    return-void

    .line 1079
    :cond_1
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mPlayButtonOnClickListener:Lco/vine/android/recorder/VineRecorder$PlayButtonOnClickListener;

    iget-object v0, v0, Lco/vine/android/recorder/VineRecorder$PlayButtonOnClickListener;->toPlay:Lco/vine/android/recorder/RecordSegment;

    if-eqz v0, :cond_2

    .line 1080
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mPlayButton:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    .line 1081
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mPlayRefreshButton:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 1087
    :goto_1
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mPlayButtonContainer:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 1088
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mPlayButtonContainer:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    const/high16 v1, 0x3f800000    # 1.0f

    invoke-virtual {v0, v1}, Landroid/view/ViewPropertyAnimator;->alpha(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    iget v1, p0, Lco/vine/android/recorder/VineRecorder;->mShortAnimTime:I

    int-to-long v1, v1

    invoke-virtual {v0, v1, v2}, Landroid/view/ViewPropertyAnimator;->setDuration(J)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/ViewPropertyAnimator;->start()V

    goto :goto_0

    .line 1083
    :cond_2
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mPlayButton:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 1084
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mPlayRefreshButton:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    goto :goto_1
.end method

.method private animatePreviewSpinner(Z)V
    .locals 1
    .param p1, "visible"    # Z

    .prologue
    .line 1097
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mPreviewLoadingOverlay:Landroid/view/View;

    invoke-direct {p0, v0, p1}, Lco/vine/android/recorder/VineRecorder;->animateSpinner(Landroid/view/View;Z)V

    .line 1098
    return-void
.end method

.method private animateSpinner(Landroid/view/View;Z)V
    .locals 3
    .param p1, "view"    # Landroid/view/View;
    .param p2, "visible"    # Z

    .prologue
    const/4 v1, 0x0

    .line 1101
    if-eqz p1, :cond_0

    .line 1102
    invoke-virtual {p1}, Landroid/view/View;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/ViewPropertyAnimator;->cancel()V

    .line 1103
    if-nez p2, :cond_1

    .line 1104
    invoke-virtual {p1}, Landroid/view/View;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/view/ViewPropertyAnimator;->alpha(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    iget v1, p0, Lco/vine/android/recorder/VineRecorder;->mShortAnimTime:I

    int-to-long v1, v1

    invoke-virtual {v0, v1, v2}, Landroid/view/ViewPropertyAnimator;->setDuration(J)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    new-instance v1, Lco/vine/android/recorder/ViewGoneAnimationListener;

    invoke-direct {v1, p1}, Lco/vine/android/recorder/ViewGoneAnimationListener;-><init>(Landroid/view/View;)V

    invoke-virtual {v0, v1}, Landroid/view/ViewPropertyAnimator;->setListener(Landroid/animation/Animator$AnimatorListener;)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/ViewPropertyAnimator;->start()V

    .line 1118
    :cond_0
    :goto_0
    return-void

    .line 1110
    :cond_1
    const/4 v0, 0x0

    invoke-virtual {p1, v0}, Landroid/view/View;->setVisibility(I)V

    .line 1111
    invoke-virtual {p1, v1}, Landroid/view/View;->setAlpha(F)V

    .line 1112
    invoke-virtual {p1}, Landroid/view/View;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    const/high16 v1, 0x3f800000    # 1.0f

    invoke-virtual {v0, v1}, Landroid/view/ViewPropertyAnimator;->alpha(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    iget v1, p0, Lco/vine/android/recorder/VineRecorder;->mShortAnimTime:I

    int-to-long v1, v1

    invoke-virtual {v0, v1, v2}, Landroid/view/ViewPropertyAnimator;->setDuration(J)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/ViewPropertyAnimator;->start()V

    goto :goto_0
.end method

.method private animateTopButtons(I)V
    .locals 4
    .param p1, "animation"    # I

    .prologue
    const/16 v3, 0x8

    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 1043
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mTrashUndoContainer:Landroid/view/View;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mTrashCanButton:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 1044
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mTrashUndoContainer:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/ViewPropertyAnimator;->cancel()V

    .line 1045
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mTrashCanButton:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/ViewPropertyAnimator;->cancel()V

    .line 1046
    packed-switch p1, :pswitch_data_0

    .line 1067
    :cond_0
    :goto_0
    return-void

    .line 1048
    :pswitch_0
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mTrashCanButton:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 1049
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mUndoButton:Landroid/view/View;

    invoke-virtual {v0, v3}, Landroid/view/View;->setVisibility(I)V

    .line 1050
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mTrashUndoContainer:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setActivated(Z)V

    .line 1051
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mTrashCanButton:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setActivated(Z)V

    goto :goto_0

    .line 1054
    :pswitch_1
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mTrashUndoContainer:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setActivated(Z)V

    .line 1055
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mTrashCanButton:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setActivated(Z)V

    goto :goto_0

    .line 1058
    :pswitch_2
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mTrashCanButton:Landroid/view/View;

    invoke-virtual {v0, v3}, Landroid/view/View;->setVisibility(I)V

    .line 1059
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mTrashUndoContainer:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setActivated(Z)V

    .line 1060
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mTrashCanButton:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setActivated(Z)V

    .line 1061
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mEditorAdapter:Lco/vine/android/recorder/SegmentEditorAdapter;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mEditorAdapter:Lco/vine/android/recorder/SegmentEditorAdapter;

    invoke-virtual {v0}, Lco/vine/android/recorder/SegmentEditorAdapter;->canUndoDelete()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1062
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mUndoButton:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    goto :goto_0

    .line 1046
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method private commitChanges()Z
    .locals 11

    .prologue
    const/4 v2, 0x0

    const/4 v7, 0x1

    .line 774
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mEditorAdapter:Lco/vine/android/recorder/SegmentEditorAdapter;

    .line 775
    .local v0, "adapter":Lco/vine/android/recorder/SegmentEditorAdapter;
    if-eqz v0, :cond_5

    .line 776
    invoke-virtual {v0}, Lco/vine/android/recorder/SegmentEditorAdapter;->commitDelete()V

    .line 777
    iget-object v8, p0, Lco/vine/android/recorder/VineRecorder;->mEditedSegments:Ljava/util/ArrayList;

    invoke-virtual {v8}, Ljava/util/ArrayList;->size()I

    move-result v6

    .line 778
    .local v6, "size":I
    const/4 v3, 0x0

    .line 780
    .local v3, "lastSegment":Lco/vine/android/recorder/RecordSegment;
    if-lez v6, :cond_0

    .line 781
    iget-object v8, p0, Lco/vine/android/recorder/VineRecorder;->mEditedSegments:Ljava/util/ArrayList;

    add-int/lit8 v9, v6, -0x1

    invoke-virtual {v8, v9}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    .end local v3    # "lastSegment":Lco/vine/android/recorder/RecordSegment;
    check-cast v3, Lco/vine/android/recorder/RecordSegment;

    .line 784
    .restart local v3    # "lastSegment":Lco/vine/android/recorder/RecordSegment;
    :cond_0
    invoke-virtual {v0}, Lco/vine/android/recorder/SegmentEditorAdapter;->getData()Ljava/util/ArrayList;

    move-result-object v8

    invoke-virtual {v8}, Ljava/util/ArrayList;->size()I

    move-result v4

    .line 788
    .local v4, "modifiedSize":I
    if-lez v4, :cond_2

    .line 789
    invoke-virtual {v0}, Lco/vine/android/recorder/SegmentEditorAdapter;->getData()Ljava/util/ArrayList;

    move-result-object v8

    add-int/lit8 v9, v4, -0x1

    invoke-virtual {v8, v9}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v8

    if-eq v3, v8, :cond_1

    move v2, v7

    .line 794
    .local v2, "lastChanged":Z
    :cond_1
    :goto_0
    iget-object v8, p0, Lco/vine/android/recorder/VineRecorder;->mEditedSegments:Ljava/util/ArrayList;

    invoke-virtual {v8}, Ljava/util/ArrayList;->clear()V

    .line 795
    iget-object v8, p0, Lco/vine/android/recorder/VineRecorder;->mEditedSegments:Ljava/util/ArrayList;

    invoke-virtual {v0}, Lco/vine/android/recorder/SegmentEditorAdapter;->getData()Ljava/util/ArrayList;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 796
    iget-object v8, p0, Lco/vine/android/recorder/VineRecorder;->mEditedSegments:Ljava/util/ArrayList;

    invoke-virtual {v0}, Lco/vine/android/recorder/SegmentEditorAdapter;->getDeleted()Ljava/util/ArrayList;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 797
    invoke-virtual {v0}, Lco/vine/android/recorder/SegmentEditorAdapter;->getDeleted()Ljava/util/ArrayList;

    move-result-object v8

    invoke-virtual {v8}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_4

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lco/vine/android/recorder/RecordSegment;

    .line 798
    .local v5, "segment":Lco/vine/android/recorder/RecordSegment;
    iput-boolean v7, v5, Lco/vine/android/recorder/RecordSegment;->removed:Z

    goto :goto_1

    .line 791
    .end local v1    # "i$":Ljava/util/Iterator;
    .end local v2    # "lastChanged":Z
    .end local v5    # "segment":Lco/vine/android/recorder/RecordSegment;
    :cond_2
    if-eqz v3, :cond_3

    move v2, v7

    .restart local v2    # "lastChanged":Z
    :cond_3
    goto :goto_0

    .line 800
    .restart local v1    # "i$":Ljava/util/Iterator;
    :cond_4
    iget-object v8, p0, Lco/vine/android/recorder/VineRecorder;->mEditedSegments:Ljava/util/ArrayList;

    invoke-virtual {p0, v8}, Lco/vine/android/recorder/VineRecorder;->swapTimestampsFromSegments(Ljava/util/ArrayList;)V

    .line 801
    iget-object v8, p0, Lco/vine/android/recorder/VineRecorder;->mToRemove:Ljava/util/HashSet;

    iget-object v9, p0, Lco/vine/android/recorder/VineRecorder;->mCurrentRecordingFile:Lco/vine/android/recorder/RecordingFile;

    invoke-virtual {v9}, Lco/vine/android/recorder/RecordingFile;->getSession()Lco/vine/android/recorder/RecordSession;

    move-result-object v9

    iget-object v10, p0, Lco/vine/android/recorder/VineRecorder;->mEditedSegments:Ljava/util/ArrayList;

    invoke-static {v9, v10}, Lco/vine/android/recorder/RecordSegment;->applyEditedChanges(Lco/vine/android/recorder/RecordSession;Ljava/util/ArrayList;)Ljava/util/ArrayList;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/util/HashSet;->addAll(Ljava/util/Collection;)Z

    .line 803
    iget-object v8, p0, Lco/vine/android/recorder/VineRecorder;->mCurrentRecordingFile:Lco/vine/android/recorder/RecordingFile;

    iput-boolean v7, v8, Lco/vine/android/recorder/RecordingFile;->isDirty:Z

    .line 805
    const-string v7, "Changes commited, last segment has changed? {}."

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v8

    invoke-static {v7, v8}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 809
    .end local v1    # "i$":Ljava/util/Iterator;
    .end local v2    # "lastChanged":Z
    .end local v3    # "lastSegment":Lco/vine/android/recorder/RecordSegment;
    .end local v4    # "modifiedSize":I
    .end local v6    # "size":I
    :cond_5
    return v2
.end method

.method private dismissFocusIndicator()V
    .locals 2

    .prologue
    .line 412
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mFocusIndicator:Landroid/widget/ImageView;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mFocusIndicator:Landroid/widget/ImageView;

    invoke-virtual {v0}, Landroid/widget/ImageView;->getVisibility()I

    move-result v0

    if-nez v0, :cond_0

    .line 413
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mFocusIndicator:Landroid/widget/ImageView;

    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mFocusDismissAnimation:Landroid/view/animation/AlphaAnimation;

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->startAnimation(Landroid/view/animation/Animation;)V

    .line 415
    :cond_0
    return-void
.end method

.method private floatViewIntersectsTrashCan()Z
    .locals 7

    .prologue
    const/4 v4, 0x1

    const/4 v5, 0x0

    .line 998
    iget-object v3, p0, Lco/vine/android/recorder/VineRecorder;->mVideoPlayer:Lco/vine/android/player/SdkVideoView;

    if-eqz v3, :cond_3

    .line 999
    iget-object v3, p0, Lco/vine/android/recorder/VineRecorder;->mVideoPlayer:Lco/vine/android/player/SdkVideoView;

    invoke-virtual {v3}, Lco/vine/android/player/SdkVideoView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v3

    check-cast v3, Landroid/widget/RelativeLayout$LayoutParams;

    iget v1, v3, Landroid/widget/RelativeLayout$LayoutParams;->topMargin:I

    .line 1001
    .local v1, "vidPlayerMarginTop":I
    iget-object v3, p0, Lco/vine/android/recorder/VineRecorder;->mDragSortWidget:Lco/vine/android/dragsort/DragSortWidget;

    invoke-virtual {v3}, Lco/vine/android/dragsort/DragSortWidget;->getFloatViewBounds()Landroid/graphics/Rect;

    move-result-object v0

    .line 1002
    .local v0, "floatViewBounds":Landroid/graphics/Rect;
    iget-object v3, p0, Lco/vine/android/recorder/VineRecorder;->mDragSortWidget:Lco/vine/android/dragsort/DragSortWidget;

    invoke-virtual {v3}, Lco/vine/android/dragsort/DragSortWidget;->floatViewIsFromContentView()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 1003
    iget v3, v0, Landroid/graphics/Rect;->top:I

    if-ge v3, v1, :cond_0

    move v3, v4

    .line 1010
    .end local v0    # "floatViewBounds":Landroid/graphics/Rect;
    .end local v1    # "vidPlayerMarginTop":I
    :goto_0
    return v3

    .restart local v0    # "floatViewBounds":Landroid/graphics/Rect;
    .restart local v1    # "vidPlayerMarginTop":I
    :cond_0
    move v3, v5

    .line 1003
    goto :goto_0

    .line 1005
    :cond_1
    iget-object v3, p0, Lco/vine/android/recorder/VineRecorder;->mVideoPlayer:Lco/vine/android/player/SdkVideoView;

    invoke-virtual {v3}, Lco/vine/android/player/SdkVideoView;->getBottom()I

    move-result v3

    iget-object v6, p0, Lco/vine/android/recorder/VineRecorder;->mVideoPlayer:Lco/vine/android/player/SdkVideoView;

    invoke-virtual {v6}, Lco/vine/android/player/SdkVideoView;->getTop()I

    move-result v6

    sub-int/2addr v3, v6

    div-int/lit8 v3, v3, 0x2

    add-int v2, v3, v1

    .line 1007
    .local v2, "videoPlayerMiddle":I
    iget v3, v0, Landroid/graphics/Rect;->top:I

    if-ge v3, v2, :cond_2

    :goto_1
    move v3, v4

    goto :goto_0

    :cond_2
    move v4, v5

    goto :goto_1

    .end local v0    # "floatViewBounds":Landroid/graphics/Rect;
    .end local v1    # "vidPlayerMarginTop":I
    .end local v2    # "videoPlayerMiddle":I
    :cond_3
    move v3, v5

    .line 1010
    goto :goto_0
.end method

.method private getDurationFromSegments()J
    .locals 7

    .prologue
    .line 1702
    const/4 v0, 0x0

    .line 1703
    .local v0, "audioProgress":I
    iget-object v3, p0, Lco/vine/android/recorder/VineRecorder;->mEditorAdapter:Lco/vine/android/recorder/SegmentEditorAdapter;

    invoke-virtual {v3}, Lco/vine/android/recorder/SegmentEditorAdapter;->getData()Ljava/util/ArrayList;

    move-result-object v3

    invoke-virtual {v3}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lco/vine/android/recorder/RecordSegment;

    .line 1704
    .local v2, "segment":Lco/vine/android/recorder/RecordSegment;
    iget-boolean v3, v2, Lco/vine/android/recorder/RecordSegment;->removed:Z

    if-nez v3, :cond_0

    .line 1705
    invoke-virtual {v2}, Lco/vine/android/recorder/RecordSegment;->getCombinedAudioData()Lco/vine/android/recorder/AudioData;

    move-result-object v3

    iget v3, v3, Lco/vine/android/recorder/AudioData;->size:I

    add-int/2addr v0, v3

    goto :goto_0

    .line 1708
    .end local v2    # "segment":Lco/vine/android/recorder/RecordSegment;
    :cond_1
    invoke-static {v0}, Lco/vine/android/recorder/RecordConfigUtils;->getTimeStampInNsFromSampleCounted(I)I

    move-result v3

    int-to-long v3, v3

    const-wide/16 v5, 0x3e8

    div-long/2addr v3, v5

    return-wide v3
.end method

.method private hideCaptureControls()V
    .locals 2

    .prologue
    const/4 v1, 0x4

    .line 549
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mProgressView:Lco/vine/android/recorder/ProgressView;

    if-eqz v0, :cond_0

    .line 550
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mProgressView:Lco/vine/android/recorder/ProgressView;

    invoke-virtual {v0, v1}, Lco/vine/android/recorder/ProgressView;->setVisibility(I)V

    .line 552
    :cond_0
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mCameraView:Landroid/view/View;

    if-eqz v0, :cond_1

    .line 553
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mCameraView:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 555
    :cond_1
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mTopMaskView:Landroid/view/View;

    if-eqz v0, :cond_2

    .line 556
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mTopMaskView:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 558
    :cond_2
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mRecordingOptions:Landroid/view/View;

    if-eqz v0, :cond_3

    .line 559
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mRecordingOptions:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 561
    :cond_3
    return-void
.end method

.method private invalidateGhostView()V
    .locals 4

    .prologue
    .line 484
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mEditedSegments:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-lez v0, :cond_0

    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mGhostView:Landroid/widget/ImageView;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mActivity:Landroid/app/Activity;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mCurrentRecordingFile:Lco/vine/android/recorder/RecordingFile;

    if-eqz v0, :cond_0

    .line 485
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mGhostView:Landroid/widget/ImageView;

    new-instance v1, Landroid/graphics/drawable/BitmapDrawable;

    iget-object v2, p0, Lco/vine/android/recorder/VineRecorder;->mActivity:Landroid/app/Activity;

    invoke-virtual {v2}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    iget-object v3, p0, Lco/vine/android/recorder/VineRecorder;->mCurrentRecordingFile:Lco/vine/android/recorder/RecordingFile;

    invoke-virtual {v3}, Lco/vine/android/recorder/RecordingFile;->getLastFramePath()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v2, v3}, Landroid/graphics/drawable/BitmapDrawable;-><init>(Landroid/content/res/Resources;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 487
    :cond_0
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    invoke-virtual {v0}, Lco/vine/android/recorder/RecordController;->invalidateGhostFrame()V

    .line 488
    return-void
.end method

.method private invalidateZoomSlider()V
    .locals 4

    .prologue
    const/16 v3, 0x8

    const/4 v2, 0x0

    .line 1240
    invoke-virtual {p0}, Lco/vine/android/recorder/VineRecorder;->getConfig()Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;

    move-result-object v0

    .line 1241
    .local v0, "config":Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;
    if-eqz v0, :cond_0

    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mZoomSeekContainer:Landroid/view/View;

    if-eqz v1, :cond_0

    .line 1242
    iget-boolean v1, v0, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->isZoomButtonEnabled:Z

    if-eqz v1, :cond_2

    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mZoomSeek:Landroid/widget/SeekBar;

    if-eqz v1, :cond_2

    .line 1243
    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mZoomSeekContainer:Landroid/view/View;

    invoke-virtual {v1, v2}, Landroid/view/View;->setVisibility(I)V

    .line 1244
    iget-boolean v1, v0, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->zoomEnabled:Z

    if-eqz v1, :cond_1

    invoke-static {}, Lco/vine/android/recorder/CameraManager;->getInstance()Lco/vine/android/recorder/CameraManager;

    move-result-object v1

    invoke-virtual {v1}, Lco/vine/android/recorder/CameraManager;->isZoomSupported()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 1245
    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mZoomSeek:Landroid/widget/SeekBar;

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Landroid/widget/SeekBar;->setEnabled(Z)V

    .line 1246
    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mZoomSeek:Landroid/widget/SeekBar;

    invoke-static {}, Lco/vine/android/recorder/CameraManager;->getInstance()Lco/vine/android/recorder/CameraManager;

    move-result-object v2

    invoke-virtual {v2}, Lco/vine/android/recorder/CameraManager;->getMaxZoom()I

    move-result v2

    add-int/lit8 v2, v2, -0x1

    invoke-virtual {v1, v2}, Landroid/widget/SeekBar;->setMax(I)V

    .line 1256
    :cond_0
    :goto_0
    return-void

    .line 1248
    :cond_1
    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mZoomSeekContainer:Landroid/view/View;

    invoke-virtual {v1, v3}, Landroid/view/View;->setVisibility(I)V

    .line 1249
    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mZoomSeek:Landroid/widget/SeekBar;

    invoke-virtual {v1, v2}, Landroid/widget/SeekBar;->setProgress(I)V

    .line 1250
    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mZoomSeek:Landroid/widget/SeekBar;

    invoke-virtual {v1, v2}, Landroid/widget/SeekBar;->setEnabled(Z)V

    goto :goto_0

    .line 1253
    :cond_2
    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mZoomSeekContainer:Landroid/view/View;

    invoke-virtual {v1, v3}, Landroid/view/View;->setVisibility(I)V

    goto :goto_0
.end method

.method private refreshFullPreview()V
    .locals 13

    .prologue
    .line 1388
    const-string v10, "Refresh full preview."

    invoke-static {v10}, Lcom/edisonwang/android/slog/SLog;->i(Ljava/lang/String;)V

    .line 1389
    invoke-virtual {p0}, Lco/vine/android/recorder/VineRecorder;->getFile()Lco/vine/android/recorder/RecordingFile;

    move-result-object v2

    .line 1390
    .local v2, "file":Lco/vine/android/recorder/RecordingFile;
    const/4 v8, 0x0

    .line 1391
    .local v8, "session":Lco/vine/android/recorder/RecordSession;
    if-eqz v2, :cond_0

    .line 1392
    invoke-virtual {v2}, Lco/vine/android/recorder/RecordingFile;->getSession()Lco/vine/android/recorder/RecordSession;

    move-result-object v8

    .line 1394
    :cond_0
    if-eqz v8, :cond_2

    .line 1395
    iget-object v10, p0, Lco/vine/android/recorder/VineRecorder;->mEditorAdapter:Lco/vine/android/recorder/SegmentEditorAdapter;

    invoke-virtual {v10}, Lco/vine/android/recorder/SegmentEditorAdapter;->getData()Ljava/util/ArrayList;

    move-result-object v1

    .line 1397
    .local v1, "data":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/recorder/RecordSegment;>;"
    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v10

    if-lez v10, :cond_1

    .line 1398
    const/4 v10, 0x0

    invoke-virtual {v1, v10}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Lco/vine/android/recorder/RecordSegment;

    invoke-virtual {v10}, Lco/vine/android/recorder/RecordSegment;->getCameraSetting()Lco/vine/android/recorder/CameraSetting;

    move-result-object v10

    iget v3, v10, Lco/vine/android/recorder/CameraSetting;->frameRate:I

    .line 1402
    .local v3, "framerate":I
    :goto_0
    invoke-virtual {v8}, Lco/vine/android/recorder/RecordSession;->getVideoData()[B

    move-result-object v10

    array-length v10, v10

    new-array v9, v10, [B

    .line 1403
    .local v9, "videoData":[B
    new-instance v0, Lco/vine/android/recorder/AudioArray;

    invoke-virtual {v8}, Lco/vine/android/recorder/RecordSession;->getAudioData()Lco/vine/android/recorder/AudioArray;

    move-result-object v10

    iget v10, v10, Lco/vine/android/recorder/AudioArray;->length:I

    invoke-virtual {v8}, Lco/vine/android/recorder/RecordSession;->getVersion()Lco/vine/android/recorder/RecordSessionVersion;

    move-result-object v11

    invoke-virtual {v11}, Lco/vine/android/recorder/RecordSessionVersion;->getAudioArrayType()Lco/vine/android/recorder/AudioArray$AudioArrayType;

    move-result-object v11

    invoke-direct {v0, v10, v11}, Lco/vine/android/recorder/AudioArray;-><init>(ILco/vine/android/recorder/AudioArray$AudioArrayType;)V

    .line 1404
    .local v0, "audioData":Lco/vine/android/recorder/AudioArray;
    iget-object v10, p0, Lco/vine/android/recorder/VineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    invoke-virtual {p0}, Lco/vine/android/recorder/VineRecorder;->getFile()Lco/vine/android/recorder/RecordingFile;

    move-result-object v11

    invoke-virtual {v11}, Lco/vine/android/recorder/RecordingFile;->getSession()Lco/vine/android/recorder/RecordSession;

    move-result-object v11

    invoke-static {v11, v9, v0, v1}, Lco/vine/android/recorder/RecordSegment;->applyForEditedChanges(Lco/vine/android/recorder/RecordSession;[BLco/vine/android/recorder/AudioArray;Ljava/util/ArrayList;)Ljava/util/ArrayList;

    move-result-object v11

    invoke-virtual {v10, v11, v9, v0, v3}, Lco/vine/android/recorder/RecordController;->writeToFile(Ljava/util/ArrayList;[BLco/vine/android/recorder/AudioArray;I)V

    .line 1406
    const-wide/16 v5, 0x0

    .line 1407
    .local v5, "lastTime":J
    const/4 v4, 0x0

    .local v4, "i":I
    :goto_1
    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v10

    if-ge v4, v10, :cond_2

    .line 1408
    invoke-virtual {v1, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lco/vine/android/recorder/RecordSegment;

    .line 1409
    .local v7, "segment":Lco/vine/android/recorder/RecordSegment;
    iput v4, v7, Lco/vine/android/recorder/RecordSegment;->index:I

    .line 1410
    iput-wide v5, v7, Lco/vine/android/recorder/RecordSegment;->startTimestamp:J

    .line 1411
    invoke-virtual {v7}, Lco/vine/android/recorder/RecordSegment;->getCombinedAudioData()Lco/vine/android/recorder/AudioData;

    move-result-object v10

    iget v10, v10, Lco/vine/android/recorder/AudioData;->size:I

    invoke-static {v10}, Lco/vine/android/recorder/RecordConfigUtils;->getTimeStampInNsFromSampleCounted(I)I

    move-result v10

    div-int/lit16 v10, v10, 0x3e8

    int-to-long v10, v10

    add-long/2addr v5, v10

    .line 1412
    const-string v10, "Timestamp modified to: {}."

    iget-wide v11, v7, Lco/vine/android/recorder/RecordSegment;->startTimestamp:J

    invoke-static {v11, v12}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v11

    invoke-static {v10, v11}, Lcom/edisonwang/android/slog/SLog;->i(Ljava/lang/String;Ljava/lang/Object;)V

    .line 1407
    add-int/lit8 v4, v4, 0x1

    goto :goto_1

    .line 1400
    .end local v0    # "audioData":Lco/vine/android/recorder/AudioArray;
    .end local v3    # "framerate":I
    .end local v4    # "i":I
    .end local v5    # "lastTime":J
    .end local v7    # "segment":Lco/vine/android/recorder/RecordSegment;
    .end local v9    # "videoData":[B
    :cond_1
    const/16 v3, 0x1e

    .restart local v3    # "framerate":I
    goto :goto_0

    .line 1415
    .end local v1    # "data":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/recorder/RecordSegment;>;"
    .end local v3    # "framerate":I
    :cond_2
    return-void
.end method

.method private releaseSegmentChangeDetector()V
    .locals 2

    .prologue
    .line 1893
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mSegmentChangeThread:Ljava/lang/Thread;

    if-eqz v0, :cond_0

    .line 1894
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mSegmentChangeDetector:Lco/vine/android/recorder/VineRecorder$SegmentChangeDetector;

    const/4 v1, 0x0

    iput-boolean v1, v0, Lco/vine/android/recorder/VineRecorder$SegmentChangeDetector;->runThread:Z

    .line 1896
    :try_start_0
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mSegmentChangeThread:Ljava/lang/Thread;

    invoke-virtual {v0}, Ljava/lang/Thread;->join()V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 1899
    :goto_0
    const/4 v0, 0x0

    iput-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mSegmentChangeThread:Ljava/lang/Thread;

    .line 1901
    :cond_0
    return-void

    .line 1897
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method private returnToPreview(Z)V
    .locals 2
    .param p1, "discard"    # Z

    .prologue
    const/4 v1, 0x0

    .line 1690
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mCurrentRecordingFile:Lco/vine/android/recorder/RecordingFile;

    if-eqz v0, :cond_1

    .line 1691
    invoke-direct {p0}, Lco/vine/android/recorder/VineRecorder;->releaseSegmentChangeDetector()V

    .line 1692
    if-nez p1, :cond_0

    .line 1693
    invoke-direct {p0}, Lco/vine/android/recorder/VineRecorder;->commitChanges()Z

    .line 1695
    :cond_0
    iput-boolean v1, p0, Lco/vine/android/recorder/VineRecorder;->mCanKeepRecording:Z

    .line 1696
    invoke-virtual {p0}, Lco/vine/android/recorder/VineRecorder;->writePreviewToFile()V

    .line 1697
    invoke-virtual {p0, v1}, Lco/vine/android/recorder/VineRecorder;->startHashTask(Z)V

    .line 1699
    :cond_1
    return-void
.end method

.method private showCameraSwitcher()V
    .locals 3

    .prologue
    .line 1274
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mCameraSwitcher:Landroid/view/ViewGroup;

    .line 1275
    .local v0, "view":Landroid/view/View;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroid/view/View;->getVisibility()I

    move-result v1

    const/16 v2, 0x8

    if-eq v1, v2, :cond_0

    .line 1276
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 1278
    :cond_0
    return-void
.end method


# virtual methods
.method protected adjustBoundaries(Lco/vine/android/recorder/CameraSetting;)V
    .locals 22
    .param p1, "cs"    # Lco/vine/android/recorder/CameraSetting;

    .prologue
    .line 1812
    move-object/from16 v0, p0

    iget-object v4, v0, Lco/vine/android/recorder/VineRecorder;->mActivity:Landroid/app/Activity;

    .line 1813
    .local v4, "activity":Landroid/app/Activity;
    if-eqz v4, :cond_4

    .line 1814
    if-eqz p1, :cond_4

    .line 1816
    move-object/from16 v0, p1

    iget v0, v0, Lco/vine/android/recorder/CameraSetting;->originalW:I

    move/from16 v19, v0

    move/from16 v0, v19

    int-to-float v12, v0

    .line 1817
    .local v12, "previewWidth":F
    move-object/from16 v0, p1

    iget-boolean v0, v0, Lco/vine/android/recorder/CameraSetting;->frontFacing:Z

    move/from16 v19, v0

    if-eqz v19, :cond_5

    move-object/from16 v0, p1

    iget v0, v0, Lco/vine/android/recorder/CameraSetting;->frontFacingAspectRatio:F

    move/from16 v19, v0

    const/16 v20, 0x0

    cmpl-float v19, v19, v20

    if-lez v19, :cond_5

    .line 1818
    move-object/from16 v0, p1

    iget v0, v0, Lco/vine/android/recorder/CameraSetting;->originalH:I

    move/from16 v19, v0

    move/from16 v0, v19

    int-to-float v0, v0

    move/from16 v19, v0

    move-object/from16 v0, p1

    iget v0, v0, Lco/vine/android/recorder/CameraSetting;->frontFacingAspectRatio:F

    move/from16 v20, v0

    mul-float v12, v19, v20

    .line 1822
    :cond_0
    :goto_0
    move-object/from16 v0, p1

    iget v0, v0, Lco/vine/android/recorder/CameraSetting;->frontFacingAspectRatio:F

    move/from16 v19, v0

    const/16 v20, 0x0

    cmpl-float v19, v19, v20

    if-gtz v19, :cond_1

    move-object/from16 v0, p1

    iget v0, v0, Lco/vine/android/recorder/CameraSetting;->backFacingAspectRatio:F

    move/from16 v19, v0

    const/16 v20, 0x0

    cmpl-float v19, v19, v20

    if-lez v19, :cond_2

    .line 1823
    :cond_1
    new-instance v19, Lco/vine/android/VineLoggingException;

    new-instance v20, Ljava/lang/StringBuilder;

    invoke-direct/range {v20 .. v20}, Ljava/lang/StringBuilder;-><init>()V

    const-string v21, "Adjusting ratio originalW = "

    invoke-virtual/range {v20 .. v21}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v20

    move-object/from16 v0, p1

    iget v0, v0, Lco/vine/android/recorder/CameraSetting;->originalW:I

    move/from16 v21, v0

    invoke-virtual/range {v20 .. v21}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v20

    const-string v21, " originalH = "

    invoke-virtual/range {v20 .. v21}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v20

    move-object/from16 v0, p1

    iget v0, v0, Lco/vine/android/recorder/CameraSetting;->originalH:I

    move/from16 v21, v0

    invoke-virtual/range {v20 .. v21}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v20

    const-string v21, " hardware "

    invoke-virtual/range {v20 .. v21}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v20

    const-string v21, "Hardware Version: "

    invoke-virtual/range {v20 .. v21}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v20

    sget-object v21, Landroid/os/Build;->DEVICE:Ljava/lang/String;

    invoke-virtual/range {v20 .. v21}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v20

    const-string v21, " - "

    invoke-virtual/range {v20 .. v21}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v20

    sget-object v21, Landroid/os/Build;->MODEL:Ljava/lang/String;

    invoke-virtual/range {v20 .. v21}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v20

    const-string v21, " ("

    invoke-virtual/range {v20 .. v21}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v20

    sget-object v21, Landroid/os/Build;->CPU_ABI:Ljava/lang/String;

    invoke-virtual/range {v20 .. v21}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v20

    const-string v21, "."

    invoke-virtual/range {v20 .. v21}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v20

    sget-object v21, Landroid/os/Build;->HARDWARE:Ljava/lang/String;

    invoke-virtual/range {v20 .. v21}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v20

    const-string v21, "."

    invoke-virtual/range {v20 .. v21}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v20

    sget-object v21, Landroid/os/Build;->BRAND:Ljava/lang/String;

    invoke-virtual/range {v20 .. v21}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v20

    const-string v21, "."

    invoke-virtual/range {v20 .. v21}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v20

    sget-object v21, Landroid/os/Build;->PRODUCT:Ljava/lang/String;

    invoke-virtual/range {v20 .. v21}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v20

    const-string v21, "."

    invoke-virtual/range {v20 .. v21}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v20

    sget-object v21, Landroid/os/Build;->MANUFACTURER:Ljava/lang/String;

    invoke-virtual/range {v20 .. v21}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v20

    const-string v21, "."

    invoke-virtual/range {v20 .. v21}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v20

    sget-object v21, Landroid/os/Build;->CPU_ABI2:Ljava/lang/String;

    invoke-virtual/range {v20 .. v21}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v20

    const-string v21, ")"

    invoke-virtual/range {v20 .. v21}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v20

    invoke-virtual/range {v20 .. v20}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v20

    invoke-direct/range {v19 .. v20}, Lco/vine/android/VineLoggingException;-><init>(Ljava/lang/String;)V

    invoke-static/range {v19 .. v19}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;)V

    .line 1829
    :cond_2
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/VineRecorder;->mFinishLoadingOverlay:Landroid/view/View;

    move-object/from16 v19, v0

    if-eqz v19, :cond_3

    .line 1830
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/VineRecorder;->mVideoPlayer:Lco/vine/android/player/SdkVideoView;

    move-object/from16 v19, v0

    if-eqz v19, :cond_3

    .line 1831
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/VineRecorder;->mVideoPlayer:Lco/vine/android/player/SdkVideoView;

    move-object/from16 v19, v0

    invoke-virtual/range {v19 .. v19}, Lco/vine/android/player/SdkVideoView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v10

    .line 1832
    .local v10, "params":Landroid/view/ViewGroup$LayoutParams;
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/VineRecorder;->mSize:Landroid/graphics/Point;

    move-object/from16 v19, v0

    move-object/from16 v0, v19

    iget v0, v0, Landroid/graphics/Point;->x:I

    move/from16 v19, v0

    move/from16 v0, v19

    iput v0, v10, Landroid/view/ViewGroup$LayoutParams;->width:I

    .line 1833
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/VineRecorder;->mSize:Landroid/graphics/Point;

    move-object/from16 v19, v0

    move-object/from16 v0, v19

    iget v0, v0, Landroid/graphics/Point;->x:I

    move/from16 v19, v0

    move/from16 v0, v19

    iput v0, v10, Landroid/view/ViewGroup$LayoutParams;->height:I

    .line 1834
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/VineRecorder;->mFinishLoadingOverlay:Landroid/view/View;

    move-object/from16 v19, v0

    new-instance v20, Lco/vine/android/recorder/VineRecorder$29;

    move-object/from16 v0, v20

    move-object/from16 v1, p0

    invoke-direct {v0, v1, v10}, Lco/vine/android/recorder/VineRecorder$29;-><init>(Lco/vine/android/recorder/VineRecorder;Landroid/view/ViewGroup$LayoutParams;)V

    invoke-virtual/range {v19 .. v20}, Landroid/view/View;->post(Ljava/lang/Runnable;)Z

    .line 1845
    .end local v10    # "params":Landroid/view/ViewGroup$LayoutParams;
    :cond_3
    move-object/from16 v0, p1

    iget v0, v0, Lco/vine/android/recorder/CameraSetting;->originalH:I

    move/from16 v19, v0

    move/from16 v0, v19

    int-to-float v11, v0

    .line 1846
    .local v11, "previewHeight":F
    div-float v5, v12, v11

    .line 1848
    .local v5, "aspectRatio":F
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/VineRecorder;->mSize:Landroid/graphics/Point;

    move-object/from16 v19, v0

    move-object/from16 v0, v19

    iget v0, v0, Landroid/graphics/Point;->x:I

    move/from16 v19, v0

    move/from16 v0, v19

    int-to-float v0, v0

    move/from16 v19, v0

    mul-float v19, v19, v5

    move/from16 v0, v19

    float-to-int v15, v0

    .line 1851
    .local v15, "surfaceViewHeightPx":I
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/VineRecorder;->mTopMaskView:Landroid/view/View;

    move-object/from16 v19, v0

    if-eqz v19, :cond_4

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/VineRecorder;->mBottomMaskView:Landroid/view/View;

    move-object/from16 v19, v0

    if-eqz v19, :cond_4

    .line 1852
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/VineRecorder;->mTopMaskView:Landroid/view/View;

    move-object/from16 v19, v0

    invoke-virtual/range {v19 .. v19}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v19

    move-object/from16 v0, v19

    iget v0, v0, Landroid/view/ViewGroup$LayoutParams;->height:I

    move/from16 v18, v0

    .line 1853
    .local v18, "topMaskHeightPx":I
    div-int/lit8 v16, v15, 0x2

    .line 1854
    .local v16, "surfaceViewMidpoint":I
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/VineRecorder;->mSize:Landroid/graphics/Point;

    move-object/from16 v19, v0

    move-object/from16 v0, v19

    iget v0, v0, Landroid/graphics/Point;->x:I

    move/from16 v19, v0

    div-int/lit8 v19, v19, 0x2

    add-int v9, v19, v18

    .line 1855
    .local v9, "midpointYOffset":I
    sub-int v17, v9, v16

    .line 1857
    .local v17, "surfaceViewYPos":I
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/VineRecorder;->mCameraView:Landroid/view/View;

    move-object/from16 v19, v0

    invoke-virtual/range {v19 .. v19}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v8

    check-cast v8, Landroid/widget/RelativeLayout$LayoutParams;

    .line 1859
    .local v8, "cameraViewParams":Landroid/widget/RelativeLayout$LayoutParams;
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/VineRecorder;->mSize:Landroid/graphics/Point;

    move-object/from16 v19, v0

    move-object/from16 v0, v19

    iget v0, v0, Landroid/graphics/Point;->x:I

    move/from16 v19, v0

    move/from16 v0, v19

    iput v0, v8, Landroid/widget/RelativeLayout$LayoutParams;->width:I

    .line 1860
    iput v15, v8, Landroid/widget/RelativeLayout$LayoutParams;->height:I

    .line 1861
    const/16 v19, 0x0

    const/16 v20, 0x0

    const/16 v21, 0x0

    move/from16 v0, v19

    move/from16 v1, v17

    move/from16 v2, v20

    move/from16 v3, v21

    invoke-virtual {v8, v0, v1, v2, v3}, Landroid/widget/RelativeLayout$LayoutParams;->setMargins(IIII)V

    .line 1864
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/VineRecorder;->mRootLayoutView:Landroid/view/View;

    move-object/from16 v19, v0

    invoke-virtual/range {v19 .. v19}, Landroid/view/View;->getMeasuredHeight()I

    move-result v13

    .line 1865
    .local v13, "rootHeight":I
    sub-int v19, v13, v18

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/VineRecorder;->mSize:Landroid/graphics/Point;

    move-object/from16 v20, v0

    move-object/from16 v0, v20

    iget v0, v0, Landroid/graphics/Point;->x:I

    move/from16 v20, v0

    sub-int v6, v19, v20

    .line 1867
    .local v6, "bottomMaskHeightPx":I
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/VineRecorder;->mBottomMaskView:Landroid/view/View;

    move-object/from16 v19, v0

    invoke-virtual/range {v19 .. v19}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v7

    check-cast v7, Landroid/widget/RelativeLayout$LayoutParams;

    .line 1869
    .local v7, "bottomMaskParams":Landroid/widget/RelativeLayout$LayoutParams;
    iput v6, v7, Landroid/widget/RelativeLayout$LayoutParams;->height:I

    .line 1870
    const-string v19, "capture"

    const/16 v20, 0x0

    move-object/from16 v0, v19

    move/from16 v1, v20

    invoke-virtual {v4, v0, v1}, Landroid/app/Activity;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v14

    .line 1871
    .local v14, "sp":Landroid/content/SharedPreferences;
    invoke-interface {v14}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v19

    move-object/from16 v0, p1

    iget-boolean v0, v0, Lco/vine/android/recorder/CameraSetting;->frontFacing:Z

    move/from16 v20, v0

    invoke-static/range {v20 .. v20}, Lco/vine/android/recorder/VineRecorder;->getBottomMaskHeightPref(Z)Ljava/lang/String;

    move-result-object v20

    move-object/from16 v0, v19

    move-object/from16 v1, v20

    invoke-interface {v0, v1, v6}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    move-result-object v19

    invoke-interface/range {v19 .. v19}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 1873
    new-instance v19, Lco/vine/android/recorder/VineRecorder$30;

    move-object/from16 v0, v19

    move-object/from16 v1, p0

    invoke-direct {v0, v1, v8, v7}, Lco/vine/android/recorder/VineRecorder$30;-><init>(Lco/vine/android/recorder/VineRecorder;Landroid/widget/RelativeLayout$LayoutParams;Landroid/widget/RelativeLayout$LayoutParams;)V

    move-object/from16 v0, v19

    invoke-virtual {v4, v0}, Landroid/app/Activity;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 1890
    .end local v5    # "aspectRatio":F
    .end local v6    # "bottomMaskHeightPx":I
    .end local v7    # "bottomMaskParams":Landroid/widget/RelativeLayout$LayoutParams;
    .end local v8    # "cameraViewParams":Landroid/widget/RelativeLayout$LayoutParams;
    .end local v9    # "midpointYOffset":I
    .end local v11    # "previewHeight":F
    .end local v12    # "previewWidth":F
    .end local v13    # "rootHeight":I
    .end local v14    # "sp":Landroid/content/SharedPreferences;
    .end local v15    # "surfaceViewHeightPx":I
    .end local v16    # "surfaceViewMidpoint":I
    .end local v17    # "surfaceViewYPos":I
    .end local v18    # "topMaskHeightPx":I
    :cond_4
    return-void

    .line 1819
    .restart local v12    # "previewWidth":F
    :cond_5
    move-object/from16 v0, p1

    iget v0, v0, Lco/vine/android/recorder/CameraSetting;->backFacingAspectRatio:F

    move/from16 v19, v0

    const/16 v20, 0x0

    cmpl-float v19, v19, v20

    if-lez v19, :cond_0

    .line 1820
    move-object/from16 v0, p1

    iget v0, v0, Lco/vine/android/recorder/CameraSetting;->originalH:I

    move/from16 v19, v0

    move/from16 v0, v19

    int-to-float v0, v0

    move/from16 v19, v0

    move-object/from16 v0, p1

    iget v0, v0, Lco/vine/android/recorder/CameraSetting;->backFacingAspectRatio:F

    move/from16 v20, v0

    mul-float v12, v19, v20

    goto/16 :goto_0
.end method

.method public canChangeFocus()Z
    .locals 1

    .prologue
    .line 418
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mCurrentSegment:Lco/vine/android/recorder/RecordSegment;

    if-nez v0, :cond_0

    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    invoke-virtual {v0}, Lco/vine/android/recorder/RecordController;->canChangeFocus()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public canPickUpFloatView()Z
    .locals 2

    .prologue
    const/4 v0, 0x0

    .line 951
    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mPreviewLoadingOverlay:Landroid/view/View;

    if-eqz v1, :cond_0

    .line 952
    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mPreviewLoadingOverlay:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->getVisibility()I

    move-result v1

    if-eqz v1, :cond_0

    const/4 v0, 0x1

    .line 954
    :cond_0
    return v0
.end method

.method public changeProgress(J)V
    .locals 2
    .param p1, "progress"    # J

    .prologue
    .line 1936
    invoke-super {p0, p1, p2}, Lco/vine/android/recorder/RegularVineRecorder;->changeProgress(J)V

    .line 1937
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mProgressOverlay:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 1938
    invoke-static {}, Lco/vine/android/util/SystemUtil;->isOnMainThread()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 1939
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mChangeProgressOverlayVisibilityRunnable:Ljava/lang/Runnable;

    invoke-interface {v0}, Ljava/lang/Runnable;->run()V

    .line 1944
    :cond_0
    :goto_0
    return-void

    .line 1941
    :cond_1
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mHandler:Landroid/os/Handler;

    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mChangeProgressOverlayVisibilityRunnable:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    goto :goto_0
.end method

.method public doOneFrame()V
    .locals 4

    .prologue
    .line 1146
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mCurrentRecordingFile:Lco/vine/android/recorder/RecordingFile;

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lco/vine/android/recorder/VineRecorder;->isEditing()Z

    move-result v0

    if-nez v0, :cond_0

    iget-boolean v0, p0, Lco/vine/android/recorder/VineRecorder;->mAutoFocusing:Z

    if-eqz v0, :cond_0

    .line 1147
    invoke-virtual {p0}, Lco/vine/android/recorder/VineRecorder;->startRelativeTime()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1148
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mHandler:Landroid/os/Handler;

    new-instance v1, Lco/vine/android/recorder/VineRecorder$14;

    invoke-direct {v1, p0}, Lco/vine/android/recorder/VineRecorder$14;-><init>(Lco/vine/android/recorder/VineRecorder;)V

    const-wide/16 v2, 0x19

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 1156
    :cond_0
    return-void
.end method

.method public declared-synchronized endRelativeTime()Z
    .locals 2

    .prologue
    .line 1501
    monitor-enter p0

    :try_start_0
    invoke-super {p0}, Lco/vine/android/recorder/RegularVineRecorder;->endRelativeTime()Z

    .line 1502
    iget-boolean v0, p0, Lco/vine/android/recorder/VineRecorder;->mGhostModeEnabled:Z

    if-eqz v0, :cond_0

    .line 1503
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lco/vine/android/recorder/RecordController;->requestGhostDrawing(Z)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 1505
    :cond_0
    const/4 v0, 0x1

    monitor-exit p0

    return v0

    .line 1501
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public floatViewDropped(I)Z
    .locals 4
    .param p1, "to"    # I

    .prologue
    const/4 v2, 0x0

    const/4 v3, 0x1

    .line 1015
    invoke-direct {p0}, Lco/vine/android/recorder/VineRecorder;->floatViewIntersectsTrashCan()Z

    move-result v0

    .line 1016
    .local v0, "intersects":Z
    invoke-direct {p0, v2}, Lco/vine/android/recorder/VineRecorder;->animateTopButtons(I)V

    .line 1017
    if-eqz v0, :cond_0

    .line 1018
    if-nez p1, :cond_5

    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mEditorAdapter:Lco/vine/android/recorder/SegmentEditorAdapter;

    invoke-virtual {v1}, Lco/vine/android/recorder/SegmentEditorAdapter;->getCount()I

    move-result v1

    if-le v1, v3, :cond_5

    .line 1019
    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mEditorAdapter:Lco/vine/android/recorder/SegmentEditorAdapter;

    invoke-virtual {v1, v3}, Lco/vine/android/recorder/SegmentEditorAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lco/vine/android/recorder/RecordSegment;

    invoke-virtual {p0, v1}, Lco/vine/android/recorder/VineRecorder;->showThumbnailOverlay(Lco/vine/android/recorder/RecordSegment;)V

    .line 1024
    :cond_0
    :goto_0
    iget v1, p0, Lco/vine/android/recorder/VineRecorder;->mPickedUpPosition:I

    if-ne v1, p1, :cond_1

    if-eqz v0, :cond_2

    .line 1025
    :cond_1
    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mPlayButtonOnClickListener:Lco/vine/android/recorder/VineRecorder$PlayButtonOnClickListener;

    const/4 v2, 0x0

    iput-object v2, v1, Lco/vine/android/recorder/VineRecorder$PlayButtonOnClickListener;->toPlay:Lco/vine/android/recorder/RecordSegment;

    .line 1026
    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mPlayButtonOnClickListener:Lco/vine/android/recorder/VineRecorder$PlayButtonOnClickListener;

    iput-boolean v3, v1, Lco/vine/android/recorder/VineRecorder$PlayButtonOnClickListener;->forceRefresh:Z

    .line 1028
    :cond_2
    if-eqz v0, :cond_3

    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mEditorAdapter:Lco/vine/android/recorder/SegmentEditorAdapter;

    invoke-virtual {v1}, Lco/vine/android/recorder/SegmentEditorAdapter;->getCount()I

    move-result v1

    if-eq v1, v3, :cond_4

    .line 1029
    :cond_3
    invoke-direct {p0, v3}, Lco/vine/android/recorder/VineRecorder;->animatePlayButton(Z)V

    .line 1031
    :cond_4
    return v0

    .line 1020
    :cond_5
    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mEditorAdapter:Lco/vine/android/recorder/SegmentEditorAdapter;

    invoke-virtual {v1}, Lco/vine/android/recorder/SegmentEditorAdapter;->getCount()I

    move-result v1

    if-le v1, v3, :cond_0

    .line 1021
    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mEditorAdapter:Lco/vine/android/recorder/SegmentEditorAdapter;

    invoke-virtual {v1, v2}, Lco/vine/android/recorder/SegmentEditorAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lco/vine/android/recorder/RecordSegment;

    invoke-virtual {p0, v1}, Lco/vine/android/recorder/VineRecorder;->showThumbnailOverlay(Lco/vine/android/recorder/RecordSegment;)V

    goto :goto_0
.end method

.method public floatViewLanded(I)V
    .locals 0
    .param p1, "to"    # I

    .prologue
    .line 1036
    return-void
.end method

.method public floatViewMoved()V
    .locals 4

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 989
    invoke-direct {p0}, Lco/vine/android/recorder/VineRecorder;->floatViewIntersectsTrashCan()Z

    move-result v3

    if-eqz v3, :cond_0

    iget-object v3, p0, Lco/vine/android/recorder/VineRecorder;->mDragSortWidget:Lco/vine/android/dragsort/DragSortWidget;

    invoke-virtual {v3}, Lco/vine/android/dragsort/DragSortWidget;->canDelete()Z

    move-result v3

    if-eqz v3, :cond_0

    move v0, v1

    .line 990
    .local v0, "canDelete":Z
    :goto_0
    if-eqz v0, :cond_1

    .line 991
    invoke-direct {p0, v1}, Lco/vine/android/recorder/VineRecorder;->animateTopButtons(I)V

    .line 995
    :goto_1
    return-void

    .end local v0    # "canDelete":Z
    :cond_0
    move v0, v2

    .line 989
    goto :goto_0

    .line 993
    .restart local v0    # "canDelete":Z
    :cond_1
    invoke-direct {p0, v2}, Lco/vine/android/recorder/VineRecorder;->animateTopButtons(I)V

    goto :goto_1
.end method

.method public floatViewPickedUp(I)V
    .locals 3
    .param p1, "item"    # I

    .prologue
    const/4 v2, 0x0

    .line 960
    iput p1, p0, Lco/vine/android/recorder/VineRecorder;->mPickedUpPosition:I

    .line 961
    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mEditorAdapter:Lco/vine/android/recorder/SegmentEditorAdapter;

    if-eqz v1, :cond_0

    .line 962
    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mEditorAdapter:Lco/vine/android/recorder/SegmentEditorAdapter;

    invoke-virtual {v1, p1}, Lco/vine/android/recorder/SegmentEditorAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/recorder/RecordSegment;

    .line 963
    .local v0, "segment":Lco/vine/android/recorder/RecordSegment;
    invoke-virtual {p0, v0}, Lco/vine/android/recorder/VineRecorder;->showThumbnailOverlay(Lco/vine/android/recorder/RecordSegment;)V

    .line 964
    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mPlayButtonOnClickListener:Lco/vine/android/recorder/VineRecorder$PlayButtonOnClickListener;

    iput-object v0, v1, Lco/vine/android/recorder/VineRecorder$PlayButtonOnClickListener;->toPlay:Lco/vine/android/recorder/RecordSegment;

    .line 965
    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mPlayButtonOnClickListener:Lco/vine/android/recorder/VineRecorder$PlayButtonOnClickListener;

    iput-boolean v2, v1, Lco/vine/android/recorder/VineRecorder$PlayButtonOnClickListener;->forceRefresh:Z

    .line 967
    .end local v0    # "segment":Lco/vine/android/recorder/RecordSegment;
    :cond_0
    invoke-virtual {p0, v2}, Lco/vine/android/recorder/VineRecorder;->pausePreview(Z)V

    .line 968
    return-void
.end method

.method public getCurrentlyPlayingPosition()I
    .locals 2

    .prologue
    .line 1132
    iget v0, p0, Lco/vine/android/recorder/VineRecorder;->mLastSelectedPosition:I

    const/4 v1, -0x1

    if-ne v0, v1, :cond_1

    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mSegmentChangeDetector:Lco/vine/android/recorder/VineRecorder$SegmentChangeDetector;

    if-eqz v0, :cond_1

    .line 1134
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mSegmentChangeDetector:Lco/vine/android/recorder/VineRecorder$SegmentChangeDetector;

    iget v0, v0, Lco/vine/android/recorder/VineRecorder$SegmentChangeDetector;->lastFirstItem:I

    if-ltz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mEditorAdapter:Lco/vine/android/recorder/SegmentEditorAdapter;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mSegmentChangeDetector:Lco/vine/android/recorder/VineRecorder$SegmentChangeDetector;

    iget v0, v0, Lco/vine/android/recorder/VineRecorder$SegmentChangeDetector;->lastFirstItem:I

    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mEditorAdapter:Lco/vine/android/recorder/SegmentEditorAdapter;

    invoke-virtual {v1}, Lco/vine/android/recorder/SegmentEditorAdapter;->getCount()I

    move-result v1

    if-ge v0, v1, :cond_0

    .line 1137
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mSegmentChangeDetector:Lco/vine/android/recorder/VineRecorder$SegmentChangeDetector;

    iget v0, v0, Lco/vine/android/recorder/VineRecorder$SegmentChangeDetector;->lastFirstItem:I

    .line 1141
    :goto_0
    return v0

    .line 1139
    :cond_0
    const/4 v0, 0x0

    goto :goto_0

    .line 1141
    :cond_1
    iget v0, p0, Lco/vine/android/recorder/VineRecorder;->mLastSelectedPosition:I

    goto :goto_0
.end method

.method protected getFinishProcessRunnable()Lco/vine/android/recorder/BasicVineRecorder$FinishProcessRunnable;
    .locals 1

    .prologue
    .line 306
    new-instance v0, Lco/vine/android/recorder/VineRecorder$5;

    invoke-direct {v0, p0}, Lco/vine/android/recorder/VineRecorder$5;-><init>(Lco/vine/android/recorder/VineRecorder;)V

    return-object v0
.end method

.method public getFinishProcessTask(Ljava/lang/String;Ljava/lang/Runnable;ZZ)Lco/vine/android/recorder/BaseFinishProcessTask;
    .locals 6
    .param p1, "tag"    # Ljava/lang/String;
    .param p2, "onComplete"    # Ljava/lang/Runnable;
    .param p3, "releasePreview"    # Z
    .param p4, "saveSession"    # Z

    .prologue
    .line 1419
    iget-boolean v0, p0, Lco/vine/android/recorder/VineRecorder;->mFastEncoding:Z

    if-eqz v0, :cond_0

    .line 1420
    new-instance v0, Lco/vine/android/recorder/VineRecorder$19;

    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    move v4, p3

    move v5, p4

    invoke-direct/range {v0 .. v5}, Lco/vine/android/recorder/VineRecorder$19;-><init>(Lco/vine/android/recorder/VineRecorder;Ljava/lang/String;Ljava/lang/Runnable;ZZ)V

    .line 1434
    :goto_0
    return-object v0

    :cond_0
    invoke-super {p0, p1, p2, p3, p4}, Lco/vine/android/recorder/RegularVineRecorder;->getFinishProcessTask(Ljava/lang/String;Ljava/lang/Runnable;ZZ)Lco/vine/android/recorder/BaseFinishProcessTask;

    move-result-object v0

    goto :goto_0
.end method

.method public getGhostView()Landroid/view/View;
    .locals 1

    .prologue
    .line 1127
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mGhostView:Landroid/widget/ImageView;

    return-object v0
.end method

.method public getOnResumeTask(Landroid/view/View;Ljava/lang/String;)Lco/vine/android/recorder/BasicVineRecorder$OnResumeTask;
    .locals 1
    .param p1, "view"    # Landroid/view/View;
    .param p2, "tag"    # Ljava/lang/String;

    .prologue
    .line 1260
    new-instance v0, Lco/vine/android/recorder/VineRecorder$18;

    invoke-direct {v0, p0, p1, p2}, Lco/vine/android/recorder/VineRecorder$18;-><init>(Lco/vine/android/recorder/VineRecorder;Landroid/view/View;Ljava/lang/String;)V

    return-object v0
.end method

.method public getProgressView()Landroid/view/View;
    .locals 1

    .prologue
    .line 1911
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mProgressView:Lco/vine/android/recorder/ProgressView;

    return-object v0
.end method

.method public getSize()Landroid/graphics/Point;
    .locals 1

    .prologue
    .line 2005
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mSize:Landroid/graphics/Point;

    return-object v0
.end method

.method public hideThumbnailOverlay()V
    .locals 3

    .prologue
    .line 931
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mThumbnailOverlay:Landroid/widget/ImageView;

    if-eqz v0, :cond_0

    .line 932
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mThumbnailOverlay:Landroid/widget/ImageView;

    invoke-virtual {v0}, Landroid/widget/ImageView;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    iget v1, p0, Lco/vine/android/recorder/VineRecorder;->mShortAnimTime:I

    int-to-long v1, v1

    invoke-virtual {v0, v1, v2}, Landroid/view/ViewPropertyAnimator;->setDuration(J)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/ViewPropertyAnimator;->alpha(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    new-instance v1, Lco/vine/android/recorder/ViewGoneAnimationListener;

    iget-object v2, p0, Lco/vine/android/recorder/VineRecorder;->mThumbnailOverlay:Landroid/widget/ImageView;

    invoke-direct {v1, v2}, Lco/vine/android/recorder/ViewGoneAnimationListener;-><init>(Landroid/view/View;)V

    invoke-virtual {v0, v1}, Landroid/view/ViewPropertyAnimator;->setListener(Landroid/animation/Animator$AnimatorListener;)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/ViewPropertyAnimator;->start()V

    .line 934
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mThumbnailOverlay:Landroid/widget/ImageView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 936
    :cond_0
    return-void
.end method

.method public hideThumbnailOverlayDelayed()V
    .locals 4

    .prologue
    .line 921
    invoke-virtual {p0}, Lco/vine/android/recorder/VineRecorder;->getHandler()Landroid/os/Handler;

    move-result-object v0

    new-instance v1, Lco/vine/android/recorder/VineRecorder$13;

    invoke-direct {v1, p0}, Lco/vine/android/recorder/VineRecorder$13;-><init>(Lco/vine/android/recorder/VineRecorder;)V

    const-wide/16 v2, 0x64

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 928
    return-void
.end method

.method protected invalidateFinishButton()V
    .locals 5

    .prologue
    .line 1461
    iget-wide v1, p0, Lco/vine/android/recorder/VineRecorder;->mCurrentDuration:J

    iget v3, p0, Lco/vine/android/recorder/VineRecorder;->mThresholdMs:I

    int-to-long v3, v3

    cmp-long v1, v1, v3

    if-gez v1, :cond_1

    .line 1462
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mFinishButton:Landroid/view/View;

    .line 1463
    .local v0, "view":Landroid/view/View;
    if-eqz v0, :cond_0

    .line 1464
    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 1469
    .end local v0    # "view":Landroid/view/View;
    :cond_0
    :goto_0
    return-void

    .line 1467
    :cond_1
    invoke-virtual {p0}, Lco/vine/android/recorder/VineRecorder;->onProgressThresholdReached()V

    goto :goto_0
.end method

.method public isAutoFocusing()Z
    .locals 1

    .prologue
    .line 397
    iget-boolean v0, p0, Lco/vine/android/recorder/VineRecorder;->mAutoFocusing:Z

    return v0
.end method

.method public isEditing()Z
    .locals 1

    .prologue
    .line 859
    iget-boolean v0, p0, Lco/vine/android/recorder/VineRecorder;->mEditing:Z

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mEditorAdapter:Lco/vine/android/recorder/SegmentEditorAdapter;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isEditingDirty()Z
    .locals 2

    .prologue
    .line 1039
    invoke-virtual {p0}, Lco/vine/android/recorder/VineRecorder;->isEditing()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mEditorAdapter:Lco/vine/android/recorder/SegmentEditorAdapter;

    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mEditedSegments:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Lco/vine/android/recorder/SegmentEditorAdapter;->compareTo(Ljava/util/ArrayList;)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public modifyZoom(Z)V
    .locals 1
    .param p1, "zoomIn"    # Z

    .prologue
    .line 350
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    invoke-virtual {v0}, Lco/vine/android/recorder/RecordController;->isRecordingStarted()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 351
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    invoke-virtual {v0, p1}, Lco/vine/android/recorder/RecordController;->modifyZoom(Z)V

    .line 353
    :cond_0
    return-void
.end method

.method public onCameraReady(Lco/vine/android/recorder/RecordController;)V
    .locals 3
    .param p1, "controller"    # Lco/vine/android/recorder/RecordController;

    .prologue
    .line 1916
    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mActivity:Landroid/app/Activity;

    if-eqz v1, :cond_1

    .line 1917
    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mSession:Lco/vine/android/recorder/RecordSession;

    invoke-virtual {v1}, Lco/vine/android/recorder/RecordSession;->getConfig()Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;

    move-result-object v1

    iget-boolean v1, v1, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->flashSwitchEnabled:Z

    if-eqz v1, :cond_0

    .line 1918
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mFlashSwitcher:Landroid/view/View;

    .line 1919
    .local v0, "view":Landroid/view/View;
    if-eqz v0, :cond_0

    .line 1920
    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    invoke-virtual {v1}, Lco/vine/android/recorder/RecordController;->isFlashSupported()Z

    move-result v1

    if-eqz v1, :cond_2

    const/4 v1, 0x0

    :goto_0
    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 1923
    .end local v0    # "view":Landroid/view/View;
    :cond_0
    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mHandler:Landroid/os/Handler;

    iget-object v2, p0, Lco/vine/android/recorder/VineRecorder;->onCameraReadyRunnable:Ljava/lang/Runnable;

    invoke-virtual {v1, v2}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 1924
    invoke-super {p0, p1}, Lco/vine/android/recorder/RegularVineRecorder;->onCameraReady(Lco/vine/android/recorder/RecordController;)V

    .line 1926
    :cond_1
    return-void

    .line 1920
    .restart local v0    # "view":Landroid/view/View;
    :cond_2
    const/16 v1, 0x8

    goto :goto_0
.end method

.method public onCameraSwitcherPressed(Landroid/view/View;)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 1509
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mCameraSwitcherViewListener:Landroid/view/View$OnClickListener;

    invoke-interface {v0, p1}, Landroid/view/View$OnClickListener;->onClick(Landroid/view/View;)V

    .line 1510
    return-void
.end method

.method public onGhostSwitchPressed()Z
    .locals 1

    .prologue
    .line 432
    iget-boolean v0, p0, Lco/vine/android/recorder/VineRecorder;->mGhostModeEnabled:Z

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    invoke-virtual {p0, v0}, Lco/vine/android/recorder/VineRecorder;->setGhostMode(Z)Z

    move-result v0

    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public declared-synchronized onKey(Landroid/view/View;ILandroid/view/KeyEvent;)Z
    .locals 1
    .param p1, "v"    # Landroid/view/View;
    .param p2, "keyCode"    # I
    .param p3, "event"    # Landroid/view/KeyEvent;

    .prologue
    .line 1479
    monitor-enter p0

    packed-switch p2, :pswitch_data_0

    .line 1494
    const/4 v0, 0x0

    :goto_0
    monitor-exit p0

    return v0

    .line 1481
    :pswitch_0
    :try_start_0
    invoke-virtual {p3}, Landroid/view/KeyEvent;->getAction()I

    move-result v0

    packed-switch v0, :pswitch_data_1

    .line 1491
    :goto_1
    const/4 v0, 0x1

    goto :goto_0

    .line 1483
    :pswitch_1
    invoke-virtual {p0}, Lco/vine/android/recorder/VineRecorder;->startRelativeTime()Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_1

    .line 1479
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0

    .line 1487
    :pswitch_2
    :try_start_1
    invoke-virtual {p0}, Lco/vine/android/recorder/VineRecorder;->endRelativeTime()Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_1

    .line 1479
    nop

    :pswitch_data_0
    .packed-switch 0x1b
        :pswitch_0
    .end packed-switch

    .line 1481
    :pswitch_data_1
    .packed-switch 0x0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method public onPause()V
    .locals 2
    .annotation build Landroid/annotation/TargetApi;
        value = 0x10
    .end annotation

    .prologue
    .line 1722
    invoke-super {p0}, Lco/vine/android/recorder/RegularVineRecorder;->onPause()V

    .line 1723
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x10

    if-lt v0, v1, :cond_0

    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mMediaActionSound:Landroid/media/MediaActionSound;

    if-eqz v0, :cond_0

    .line 1724
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mMediaActionSound:Landroid/media/MediaActionSound;

    invoke-virtual {v0}, Landroid/media/MediaActionSound;->release()V

    .line 1726
    :cond_0
    return-void
.end method

.method public onPrepared(Lco/vine/android/player/VideoViewInterface;)V
    .locals 2
    .param p1, "view"    # Lco/vine/android/player/VideoViewInterface;

    .prologue
    const/4 v1, 0x0

    .line 940
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mDragSortWidget:Lco/vine/android/dragsort/DragSortWidget;

    if-eqz v0, :cond_1

    .line 941
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mDragSortWidget:Lco/vine/android/dragsort/DragSortWidget;

    invoke-virtual {v0}, Lco/vine/android/dragsort/DragSortWidget;->hasFloatView()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 942
    invoke-virtual {p0, v1}, Lco/vine/android/recorder/VineRecorder;->pausePreview(Z)V

    .line 944
    :cond_0
    invoke-virtual {p0}, Lco/vine/android/recorder/VineRecorder;->hideThumbnailOverlayDelayed()V

    .line 945
    invoke-direct {p0, v1}, Lco/vine/android/recorder/VineRecorder;->animatePreviewSpinner(Z)V

    .line 947
    :cond_1
    return-void
.end method

.method public onProgressMaxReached()V
    .locals 1

    .prologue
    .line 1905
    iget-boolean v0, p0, Lco/vine/android/recorder/VineRecorder;->mHasPreviewedAlready:Z

    if-nez v0, :cond_0

    .line 1906
    const-string v0, "progressMaxReached"

    invoke-virtual {p0, v0}, Lco/vine/android/recorder/VineRecorder;->finish(Ljava/lang/String;)V

    .line 1908
    :cond_0
    return-void
.end method

.method public onProgressThresholdReached()V
    .locals 2

    .prologue
    .line 1713
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mFinishButton:Landroid/view/View;

    .line 1714
    .local v0, "view":Landroid/view/View;
    if-eqz v0, :cond_0

    .line 1715
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 1717
    :cond_0
    return-void
.end method

.method public onResume(Ljava/lang/String;Z)V
    .locals 7
    .param p1, "tag"    # Ljava/lang/String;
    .param p2, "delayDialog"    # Z

    .prologue
    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 1206
    invoke-virtual {p0}, Lco/vine/android/recorder/VineRecorder;->canKeepRecording()Z

    move-result v0

    .line 1207
    .local v0, "canKeepRecording":Z
    const-string v4, "Resume VineRecorder: delayDialog: {} canKeepRecording: {} isEditing: {} NullFinalFile: {}."

    const/4 v1, 0x4

    new-array v5, v1, [Ljava/lang/Object;

    invoke-static {p2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    aput-object v1, v5, v3

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    aput-object v1, v5, v2

    const/4 v1, 0x2

    invoke-virtual {p0}, Lco/vine/android/recorder/VineRecorder;->isEditing()Z

    move-result v6

    invoke-static {v6}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v6

    aput-object v6, v5, v1

    const/4 v6, 0x3

    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->finalFile:Lco/vine/android/recorder/RecordingFile;

    if-eqz v1, :cond_1

    move v1, v2

    :goto_0
    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    aput-object v1, v5, v6

    invoke-static {v4, v5}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 1208
    if-eqz v0, :cond_6

    .line 1209
    invoke-virtual {p0}, Lco/vine/android/recorder/VineRecorder;->isEditing()Z

    move-result v1

    if-nez v1, :cond_5

    .line 1210
    invoke-virtual {p0}, Lco/vine/android/recorder/VineRecorder;->initPreviewSurface()V

    .line 1211
    iget-boolean v1, p0, Lco/vine/android/recorder/VineRecorder;->mStartWithEditMode:Z

    if-eqz v1, :cond_2

    .line 1212
    invoke-virtual {p0, v2, v3}, Lco/vine/android/recorder/VineRecorder;->setEditMode(ZZ)V

    .line 1237
    :cond_0
    :goto_1
    return-void

    :cond_1
    move v1, v3

    .line 1207
    goto :goto_0

    .line 1214
    :cond_2
    const/4 v1, 0x0

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "OnResume_"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p0, v1, v4}, Lco/vine/android/recorder/VineRecorder;->getOnResumeTask(Landroid/view/View;Ljava/lang/String;)Lco/vine/android/recorder/BasicVineRecorder$OnResumeTask;

    move-result-object v1

    iput-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mResumeTask:Lco/vine/android/recorder/BasicVineRecorder$OnResumeTask;

    .line 1215
    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mResumeTask:Lco/vine/android/recorder/BasicVineRecorder$OnResumeTask;

    if-nez p2, :cond_3

    iget-object v4, p0, Lco/vine/android/recorder/VineRecorder;->mCurrentRecordingFile:Lco/vine/android/recorder/RecordingFile;

    iget-boolean v4, v4, Lco/vine/android/recorder/RecordingFile;->isSavedSession:Z

    if-eqz v4, :cond_4

    iget-boolean v4, p0, Lco/vine/android/recorder/VineRecorder;->mNeverResumedRecorder:Z

    if-eqz v4, :cond_4

    :cond_3
    :goto_2
    iput-boolean v2, v1, Lco/vine/android/recorder/BasicVineRecorder$OnResumeTask;->showDialogDelayed:Z

    .line 1216
    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mResumeTask:Lco/vine/android/recorder/BasicVineRecorder$OnResumeTask;

    new-array v2, v3, [Ljava/lang/Void;

    invoke-virtual {v1, v2}, Lco/vine/android/recorder/BasicVineRecorder$OnResumeTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_1

    :cond_4
    move v2, v3

    .line 1215
    goto :goto_2

    .line 1219
    :cond_5
    invoke-virtual {p0, v2, v3}, Lco/vine/android/recorder/VineRecorder;->setEditMode(ZZ)V

    goto :goto_1

    .line 1222
    :cond_6
    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->finalFile:Lco/vine/android/recorder/RecordingFile;

    if-eqz v1, :cond_7

    .line 1223
    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mOnCompleteConsumer:Ljava/lang/Runnable;

    invoke-interface {v1}, Ljava/lang/Runnable;->run()V

    goto :goto_1

    .line 1225
    :cond_7
    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mStartProgressDialog:Landroid/app/ProgressDialog;

    if-eqz v1, :cond_0

    .line 1226
    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mStartProgressDialog:Landroid/app/ProgressDialog;

    iget-object v2, p0, Lco/vine/android/recorder/VineRecorder;->mFinishLastSegmentString:Ljava/lang/CharSequence;

    invoke-virtual {v1, v2}, Landroid/app/ProgressDialog;->setMessage(Ljava/lang/CharSequence;)V

    .line 1227
    if-nez p2, :cond_0

    .line 1229
    :try_start_0
    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mStartProgressDialog:Landroid/app/ProgressDialog;

    invoke-virtual {v1}, Landroid/app/ProgressDialog;->show()V
    :try_end_0
    .catch Landroid/view/WindowManager$BadTokenException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    .line 1230
    :catch_0
    move-exception v1

    goto :goto_1
.end method

.method public onSelectionChanged(IZ)V
    .locals 6
    .param p1, "position"    # I
    .param p2, "listViewClick"    # Z

    .prologue
    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 876
    iput p1, p0, Lco/vine/android/recorder/VineRecorder;->mLastSelectedPosition:I

    .line 877
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mEditorAdapter:Lco/vine/android/recorder/SegmentEditorAdapter;

    .line 878
    .local v0, "editor":Lco/vine/android/recorder/SegmentEditorAdapter;
    if-eqz v0, :cond_1

    .line 879
    const/4 v2, -0x1

    if-eq p1, v2, :cond_2

    iget-object v2, p0, Lco/vine/android/recorder/VineRecorder;->mEditedSegments:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v2

    if-ge p1, v2, :cond_2

    .line 880
    invoke-direct {p0, v3}, Lco/vine/android/recorder/VineRecorder;->animateTopButtons(I)V

    .line 881
    invoke-virtual {v0, p1}, Lco/vine/android/recorder/SegmentEditorAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lco/vine/android/recorder/RecordSegment;

    .line 882
    .local v1, "toPlay":Lco/vine/android/recorder/RecordSegment;
    if-eqz p2, :cond_0

    .line 883
    invoke-virtual {p0, v1, v4}, Lco/vine/android/recorder/VineRecorder;->playPreview(Lco/vine/android/recorder/RecordSegment;Z)V

    .line 885
    :cond_0
    invoke-virtual {v0}, Lco/vine/android/recorder/SegmentEditorAdapter;->commitDelete()V

    .line 905
    .end local v1    # "toPlay":Lco/vine/android/recorder/RecordSegment;
    :cond_1
    :goto_0
    return-void

    .line 886
    :cond_2
    invoke-virtual {v0}, Lco/vine/android/recorder/SegmentEditorAdapter;->getCount()I

    move-result v2

    if-lez v2, :cond_5

    .line 887
    invoke-direct {p0, v5}, Lco/vine/android/recorder/VineRecorder;->animateTopButtons(I)V

    .line 888
    if-eqz p2, :cond_4

    .line 889
    const/4 v2, 0x0

    invoke-virtual {p0, v2, v4}, Lco/vine/android/recorder/VineRecorder;->playPreview(Lco/vine/android/recorder/RecordSegment;Z)V

    .line 893
    :cond_3
    :goto_1
    iget-object v2, p0, Lco/vine/android/recorder/VineRecorder;->mDragSortWidget:Lco/vine/android/dragsort/DragSortWidget;

    if-eqz v2, :cond_1

    .line 894
    iget-object v2, p0, Lco/vine/android/recorder/VineRecorder;->mDragSortWidget:Lco/vine/android/dragsort/DragSortWidget;

    invoke-virtual {v2, v3}, Lco/vine/android/dragsort/DragSortWidget;->setFocused(I)V

    goto :goto_0

    .line 890
    :cond_4
    iget-object v2, p0, Lco/vine/android/recorder/VineRecorder;->mLastPlayingSegment:Lco/vine/android/recorder/RecordSegment;

    if-eqz v2, :cond_3

    if-nez p2, :cond_3

    .line 891
    invoke-virtual {p0, v4}, Lco/vine/android/recorder/VineRecorder;->pausePreview(Z)V

    goto :goto_1

    .line 897
    :cond_5
    iget-object v2, p0, Lco/vine/android/recorder/VineRecorder;->mVideoPlayer:Lco/vine/android/player/SdkVideoView;

    invoke-virtual {v2}, Lco/vine/android/player/SdkVideoView;->suspend()V

    .line 898
    invoke-direct {p0, v3}, Lco/vine/android/recorder/VineRecorder;->animatePlayButton(Z)V

    .line 899
    invoke-direct {p0, v3}, Lco/vine/android/recorder/VineRecorder;->animatePreviewSpinner(Z)V

    .line 900
    invoke-virtual {p0}, Lco/vine/android/recorder/VineRecorder;->hideThumbnailOverlay()V

    .line 901
    invoke-direct {p0, v5}, Lco/vine/android/recorder/VineRecorder;->animateTopButtons(I)V

    .line 902
    iget-object v2, p0, Lco/vine/android/recorder/VineRecorder;->mVideoPlayer:Lco/vine/android/player/SdkVideoView;

    const/16 v3, 0x8

    invoke-virtual {v2, v3}, Lco/vine/android/player/SdkVideoView;->setVisibility(I)V

    goto :goto_0
.end method

.method public declared-synchronized onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z
    .locals 1
    .param p1, "v"    # Landroid/view/View;
    .param p2, "event"    # Landroid/view/MotionEvent;

    .prologue
    .line 1473
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lco/vine/android/recorder/VineRecorder;->isEditing()Z

    move-result v0

    if-nez v0, :cond_0

    invoke-super {p0, p1, p2}, Lco/vine/android/recorder/RegularVineRecorder;->onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    monitor-exit p0

    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public onUiPaused()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 1746
    invoke-direct {p0}, Lco/vine/android/recorder/VineRecorder;->releaseSegmentChangeDetector()V

    .line 1747
    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mDragSortWidget:Lco/vine/android/dragsort/DragSortWidget;

    if-eqz v1, :cond_0

    .line 1748
    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mDragSortWidget:Lco/vine/android/dragsort/DragSortWidget;

    invoke-virtual {v1}, Lco/vine/android/dragsort/DragSortWidget;->releaseReferences()V

    .line 1750
    :cond_0
    iput-object v3, p0, Lco/vine/android/recorder/VineRecorder;->mResources:Landroid/content/res/Resources;

    .line 1752
    :try_start_0
    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mRefreshPreviewTask:Lco/vine/android/recorder/VineRecorder$RefreshPreviewTask;

    if-eqz v1, :cond_1

    .line 1753
    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mRefreshPreviewTask:Lco/vine/android/recorder/VineRecorder$RefreshPreviewTask;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Lco/vine/android/recorder/VineRecorder$RefreshPreviewTask;->cancel(Z)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 1758
    :cond_1
    :goto_0
    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mVideoPlayer:Lco/vine/android/player/SdkVideoView;

    if-eqz v1, :cond_2

    .line 1759
    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mVideoPlayer:Lco/vine/android/player/SdkVideoView;

    invoke-virtual {v1, v3}, Lco/vine/android/player/SdkVideoView;->setOnErrorListener(Lco/vine/android/player/VideoViewInterface$OnErrorListener;)V

    .line 1760
    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mVideoPlayer:Lco/vine/android/player/SdkVideoView;

    invoke-virtual {v1, v3}, Lco/vine/android/player/SdkVideoView;->setOnPreparedListener(Lco/vine/android/player/VideoViewInterface$OnPreparedListener;)V

    .line 1762
    :cond_2
    iput-object v3, p0, Lco/vine/android/recorder/VineRecorder;->mRefreshPreviewTask:Lco/vine/android/recorder/VineRecorder$RefreshPreviewTask;

    .line 1763
    iput-object v3, p0, Lco/vine/android/recorder/VineRecorder;->mRecordingOptions:Landroid/view/View;

    .line 1764
    iput-object v3, p0, Lco/vine/android/recorder/VineRecorder;->mPreviewLoadingOverlay:Landroid/view/View;

    .line 1765
    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mFlashSwitcher:Landroid/view/View;

    if-eqz v1, :cond_3

    .line 1766
    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mFlashSwitcher:Landroid/view/View;

    invoke-virtual {v1, v3}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 1768
    :cond_3
    iput-object v3, p0, Lco/vine/android/recorder/VineRecorder;->mFinishLoadingOverlay:Landroid/view/View;

    .line 1769
    iput-object v3, p0, Lco/vine/android/recorder/VineRecorder;->mFlashSwitcher:Landroid/view/View;

    .line 1770
    iput-object v3, p0, Lco/vine/android/recorder/VineRecorder;->mZoomSeek:Landroid/widget/SeekBar;

    .line 1771
    iput-object v3, p0, Lco/vine/android/recorder/VineRecorder;->mZoomSeekContainer:Landroid/view/View;

    .line 1772
    iput-object v3, p0, Lco/vine/android/recorder/VineRecorder;->mCameraSwitcher:Landroid/view/ViewGroup;

    .line 1773
    iput-object v3, p0, Lco/vine/android/recorder/VineRecorder;->mTrashUndoContainer:Landroid/view/View;

    .line 1774
    iput-object v3, p0, Lco/vine/android/recorder/VineRecorder;->mThumbnailList:Landroid/view/View;

    .line 1775
    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mPlayButtonContainer:Landroid/view/View;

    if-eqz v1, :cond_4

    .line 1776
    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mPlayButtonContainer:Landroid/view/View;

    invoke-virtual {v1, v3}, Landroid/view/View;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 1777
    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mPlayButtonContainer:Landroid/view/View;

    invoke-virtual {v1, v3}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 1779
    :cond_4
    iput-object v3, p0, Lco/vine/android/recorder/VineRecorder;->mPlayButtonContainer:Landroid/view/View;

    .line 1780
    iput-object v3, p0, Lco/vine/android/recorder/VineRecorder;->mThumbnailSegment:Lco/vine/android/recorder/RecordSegment;

    .line 1781
    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mEditorCancelButton:Landroid/view/View;

    if-eqz v1, :cond_5

    .line 1782
    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mEditorCancelButton:Landroid/view/View;

    invoke-virtual {v1, v3}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 1784
    :cond_5
    iput-object v3, p0, Lco/vine/android/recorder/VineRecorder;->mEditorCancelButton:Landroid/view/View;

    .line 1785
    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mEditorDoneButton:Landroid/view/View;

    if-eqz v1, :cond_6

    .line 1786
    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mEditorDoneButton:Landroid/view/View;

    invoke-virtual {v1, v3}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 1788
    :cond_6
    iput-object v3, p0, Lco/vine/android/recorder/VineRecorder;->mEditorDoneButton:Landroid/view/View;

    .line 1789
    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mTrashCanButton:Landroid/view/View;

    if-eqz v1, :cond_7

    .line 1790
    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mTrashCanButton:Landroid/view/View;

    invoke-virtual {v1, v3}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 1791
    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mTrashCanButton:Landroid/view/View;

    invoke-virtual {v1, v3}, Landroid/view/View;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 1793
    :cond_7
    iput-object v3, p0, Lco/vine/android/recorder/VineRecorder;->mTrashCanButton:Landroid/view/View;

    .line 1794
    iput-object v3, p0, Lco/vine/android/recorder/VineRecorder;->mEditorButtons:Landroid/view/View;

    .line 1795
    iput-object v3, p0, Lco/vine/android/recorder/VineRecorder;->mThumbnailOverlay:Landroid/widget/ImageView;

    .line 1796
    iput-object v3, p0, Lco/vine/android/recorder/VineRecorder;->mFocusView:Landroid/view/View;

    .line 1797
    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mDragSortWidget:Lco/vine/android/dragsort/DragSortWidget;

    if-eqz v1, :cond_8

    .line 1798
    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mDragSortWidget:Lco/vine/android/dragsort/DragSortWidget;

    invoke-virtual {v1, v3}, Lco/vine/android/dragsort/DragSortWidget;->setSelectionChangedListener(Lco/vine/android/dragsort/DragSortWidget$SelectionChangedListener;)V

    .line 1799
    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mDragSortWidget:Lco/vine/android/dragsort/DragSortWidget;

    invoke-virtual {v1, v3}, Lco/vine/android/dragsort/DragSortWidget;->setFloatViewInteractionListener(Lco/vine/android/dragsort/DragSortWidget$FloatViewInteractionListener;)V

    .line 1800
    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mDragSortWidget:Lco/vine/android/dragsort/DragSortWidget;

    invoke-virtual {v1, v3}, Lco/vine/android/dragsort/DragSortWidget;->setCurrentlyPlayingProvider(Lco/vine/android/dragsort/DragSortWidget$CurrentlyPlayingProvider;)V

    .line 1802
    :cond_8
    iput-object v3, p0, Lco/vine/android/recorder/VineRecorder;->mDragSortWidget:Lco/vine/android/dragsort/DragSortWidget;

    .line 1803
    iput-object v3, p0, Lco/vine/android/recorder/VineRecorder;->mGridSwitch:Landroid/widget/ToggleButton;

    .line 1804
    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mFinishButton:Landroid/view/View;

    if-eqz v1, :cond_9

    .line 1805
    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mFinishButton:Landroid/view/View;

    invoke-virtual {v1, v3}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 1807
    :cond_9
    iput-object v3, p0, Lco/vine/android/recorder/VineRecorder;->mFinishButton:Landroid/view/View;

    .line 1808
    invoke-super {p0}, Lco/vine/android/recorder/RegularVineRecorder;->onUiPaused()V

    .line 1809
    return-void

    .line 1755
    :catch_0
    move-exception v0

    .line 1756
    .local v0, "e":Ljava/lang/Exception;
    const-string v1, "It\'s probably detached already."

    invoke-static {v1, v0}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto/16 :goto_0
.end method

.method public onUiResumed(Landroid/app/Activity;Ljava/lang/Runnable;Z)V
    .locals 7
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "onCompleteAsyncTask"    # Ljava/lang/Runnable;
    .param p3, "doNotResumeRecorder"    # Z
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "ShowToast"
        }
    .end annotation

    .prologue
    const/16 v6, 0x8

    const/4 v5, 0x0

    const/4 v4, 0x0

    .line 1514
    invoke-super {p0, p1, p2, p3}, Lco/vine/android/recorder/RegularVineRecorder;->onUiResumed(Landroid/app/Activity;Ljava/lang/Runnable;Z)V

    .line 1515
    invoke-virtual {p1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mResources:Landroid/content/res/Resources;

    .line 1516
    iget v0, p0, Lco/vine/android/recorder/VineRecorder;->mRecordingOptionsRowId:I

    invoke-virtual {p1, v0}, Landroid/app/Activity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mRecordingOptions:Landroid/view/View;

    .line 1517
    const v0, 0x102000a

    invoke-virtual {p1, v0}, Landroid/app/Activity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mThumbnailList:Landroid/view/View;

    .line 1518
    iget v0, p0, Lco/vine/android/recorder/VineRecorder;->mThumbnailOverlayId:I

    invoke-virtual {p1, v0}, Landroid/app/Activity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mThumbnailOverlay:Landroid/widget/ImageView;

    .line 1519
    iget v0, p0, Lco/vine/android/recorder/VineRecorder;->mTrashUndoContainerId:I

    invoke-virtual {p1, v0}, Landroid/app/Activity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mTrashUndoContainer:Landroid/view/View;

    .line 1520
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mTrashUndoContainer:Landroid/view/View;

    new-instance v1, Lco/vine/android/recorder/VineRecorder$20;

    invoke-direct {v1, p0}, Lco/vine/android/recorder/VineRecorder$20;-><init>(Lco/vine/android/recorder/VineRecorder;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 1529
    iget v0, p0, Lco/vine/android/recorder/VineRecorder;->mFinishLoadingOverlayId:I

    invoke-virtual {p1, v0}, Landroid/app/Activity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mFinishLoadingOverlay:Landroid/view/View;

    .line 1530
    iget v0, p0, Lco/vine/android/recorder/VineRecorder;->mPlayButtonContainerId:I

    invoke-virtual {p1, v0}, Landroid/app/Activity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mPlayButtonContainer:Landroid/view/View;

    .line 1531
    new-instance v0, Lco/vine/android/recorder/VineRecorder$PlayButtonOnClickListener;

    invoke-direct {v0, p0, v5}, Lco/vine/android/recorder/VineRecorder$PlayButtonOnClickListener;-><init>(Lco/vine/android/recorder/VineRecorder;Lco/vine/android/recorder/VineRecorder$1;)V

    iput-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mPlayButtonOnClickListener:Lco/vine/android/recorder/VineRecorder$PlayButtonOnClickListener;

    .line 1532
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mPlayButtonContainer:Landroid/view/View;

    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mPlayButtonOnClickListener:Lco/vine/android/recorder/VineRecorder$PlayButtonOnClickListener;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 1533
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mPlayButtonContainer:Landroid/view/View;

    new-instance v1, Lco/vine/android/recorder/VineRecorder$21;

    invoke-direct {v1, p0}, Lco/vine/android/recorder/VineRecorder$21;-><init>(Lco/vine/android/recorder/VineRecorder;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 1544
    iget v0, p0, Lco/vine/android/recorder/VineRecorder;->mFinishButtonId:I

    invoke-virtual {p1, v0}, Landroid/app/Activity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mFinishButton:Landroid/view/View;

    .line 1545
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mFinishButton:Landroid/view/View;

    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mFinishClicker:Landroid/view/View$OnClickListener;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 1546
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mPlayButtonContainer:Landroid/view/View;

    check-cast v0, Landroid/view/ViewGroup;

    invoke-virtual {v0, v4}, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mPlayButton:Landroid/view/View;

    .line 1547
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mPlayButtonContainer:Landroid/view/View;

    check-cast v0, Landroid/view/ViewGroup;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mPlayRefreshButton:Landroid/view/View;

    .line 1548
    iget v0, p0, Lco/vine/android/recorder/VineRecorder;->mDragSortWidgetId:I

    invoke-virtual {p1, v0}, Landroid/app/Activity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lco/vine/android/dragsort/DragSortWidget;

    iput-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mDragSortWidget:Lco/vine/android/dragsort/DragSortWidget;

    .line 1549
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mDragSortWidget:Lco/vine/android/dragsort/DragSortWidget;

    invoke-virtual {v0, p0}, Lco/vine/android/dragsort/DragSortWidget;->setSelectionChangedListener(Lco/vine/android/dragsort/DragSortWidget$SelectionChangedListener;)V

    .line 1550
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mDragSortWidget:Lco/vine/android/dragsort/DragSortWidget;

    invoke-virtual {v0, p0}, Lco/vine/android/dragsort/DragSortWidget;->setFloatViewInteractionListener(Lco/vine/android/dragsort/DragSortWidget$FloatViewInteractionListener;)V

    .line 1551
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mDragSortWidget:Lco/vine/android/dragsort/DragSortWidget;

    invoke-virtual {v0, p0}, Lco/vine/android/dragsort/DragSortWidget;->setCurrentlyPlayingProvider(Lco/vine/android/dragsort/DragSortWidget$CurrentlyPlayingProvider;)V

    .line 1552
    iget v0, p0, Lco/vine/android/recorder/VineRecorder;->mEditorButtonsId:I

    invoke-virtual {p1, v0}, Landroid/app/Activity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mEditorButtons:Landroid/view/View;

    .line 1553
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mEditorButtons:Landroid/view/View;

    new-instance v1, Lco/vine/android/recorder/VineRecorder$22;

    invoke-direct {v1, p0}, Lco/vine/android/recorder/VineRecorder$22;-><init>(Lco/vine/android/recorder/VineRecorder;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 1559
    iget v0, p0, Lco/vine/android/recorder/VineRecorder;->mEditorDoneButtonId:I

    invoke-virtual {p1, v0}, Landroid/app/Activity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mEditorDoneButton:Landroid/view/View;

    .line 1560
    iget v0, p0, Lco/vine/android/recorder/VineRecorder;->mPreviewLoadingOverlayId:I

    invoke-virtual {p1, v0}, Landroid/app/Activity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mPreviewLoadingOverlay:Landroid/view/View;

    .line 1561
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mEditorDoneButton:Landroid/view/View;

    new-instance v1, Lco/vine/android/recorder/VineRecorder$23;

    invoke-direct {v1, p0}, Lco/vine/android/recorder/VineRecorder$23;-><init>(Lco/vine/android/recorder/VineRecorder;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 1572
    iget v0, p0, Lco/vine/android/recorder/VineRecorder;->mTrashCanButtonId:I

    invoke-virtual {p1, v0}, Landroid/app/Activity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mTrashCanButton:Landroid/view/View;

    .line 1573
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mTrashCanButton:Landroid/view/View;

    new-instance v1, Lco/vine/android/recorder/VineRecorder$24;

    invoke-direct {v1, p0}, Lco/vine/android/recorder/VineRecorder$24;-><init>(Lco/vine/android/recorder/VineRecorder;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 1584
    iget v0, p0, Lco/vine/android/recorder/VineRecorder;->mUndoButtonId:I

    invoke-virtual {p1, v0}, Landroid/app/Activity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mUndoButton:Landroid/view/View;

    .line 1585
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mUndoButton:Landroid/view/View;

    new-instance v1, Lco/vine/android/recorder/VineRecorder$25;

    invoke-direct {v1, p0}, Lco/vine/android/recorder/VineRecorder$25;-><init>(Lco/vine/android/recorder/VineRecorder;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 1604
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mTrashCanButton:Landroid/view/View;

    new-instance v1, Lco/vine/android/recorder/VineRecorder$26;

    invoke-direct {v1, p0}, Lco/vine/android/recorder/VineRecorder$26;-><init>(Lco/vine/android/recorder/VineRecorder;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 1624
    iget v0, p0, Lco/vine/android/recorder/VineRecorder;->mEditorCancelButtonId:I

    invoke-virtual {p1, v0}, Landroid/app/Activity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mEditorCancelButton:Landroid/view/View;

    .line 1625
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mEditorCancelButton:Landroid/view/View;

    new-instance v1, Lco/vine/android/recorder/VineRecorder$27;

    invoke-direct {v1, p0}, Lco/vine/android/recorder/VineRecorder$27;-><init>(Lco/vine/android/recorder/VineRecorder;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 1636
    iget v0, p0, Lco/vine/android/recorder/VineRecorder;->mGridSwitchId:I

    invoke-virtual {p1, v0}, Landroid/app/Activity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ToggleButton;

    iput-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mGridSwitch:Landroid/widget/ToggleButton;

    .line 1637
    iget v0, p0, Lco/vine/android/recorder/VineRecorder;->mFocusViewResourceId:I

    invoke-virtual {p1, v0}, Landroid/app/Activity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mFocusView:Landroid/view/View;

    .line 1638
    invoke-virtual {p0}, Lco/vine/android/recorder/VineRecorder;->isEditing()Z

    move-result v0

    if-nez v0, :cond_0

    iget-wide v0, p0, Lco/vine/android/recorder/VineRecorder;->mCurrentDuration:J

    iget v2, p0, Lco/vine/android/recorder/VineRecorder;->mThresholdMs:I

    int-to-long v2, v2

    cmp-long v0, v0, v2

    if-ltz v0, :cond_0

    .line 1639
    invoke-virtual {p0}, Lco/vine/android/recorder/VineRecorder;->onProgressThresholdReached()V

    .line 1641
    :cond_0
    iget v0, p0, Lco/vine/android/recorder/VineRecorder;->mCameraSwitcherId:I

    if-lez v0, :cond_5

    .line 1642
    iget v0, p0, Lco/vine/android/recorder/VineRecorder;->mCameraSwitcherId:I

    invoke-virtual {p1, v0}, Landroid/app/Activity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    iput-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mCameraSwitcher:Landroid/view/ViewGroup;

    .line 1643
    invoke-static {p1}, Lco/vine/android/recorder/RecordConfigUtils;->getGenericConfig(Landroid/content/Context;)Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;

    move-result-object v0

    iget-boolean v0, v0, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->cameraSwitchEnabled:Z

    if-nez v0, :cond_4

    .line 1644
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mCameraSwitcher:Landroid/view/ViewGroup;

    invoke-virtual {v0, v6}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 1651
    :goto_0
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mProgressView:Lco/vine/android/recorder/ProgressView;

    new-instance v1, Lco/vine/android/recorder/VineRecorder$28;

    invoke-direct {v1, p0}, Lco/vine/android/recorder/VineRecorder$28;-><init>(Lco/vine/android/recorder/VineRecorder;)V

    invoke-virtual {v0, v1}, Lco/vine/android/recorder/ProgressView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 1660
    iget v0, p0, Lco/vine/android/recorder/VineRecorder;->mZoomSeekContainerId:I

    if-lez v0, :cond_1

    iget v0, p0, Lco/vine/android/recorder/VineRecorder;->mZoomSeekId:I

    if-lez v0, :cond_1

    .line 1661
    iget v0, p0, Lco/vine/android/recorder/VineRecorder;->mZoomSeekContainerId:I

    invoke-virtual {p1, v0}, Landroid/app/Activity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mZoomSeekContainer:Landroid/view/View;

    .line 1662
    iget v0, p0, Lco/vine/android/recorder/VineRecorder;->mZoomSeekId:I

    invoke-virtual {p1, v0}, Landroid/app/Activity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/SeekBar;

    iput-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mZoomSeek:Landroid/widget/SeekBar;

    .line 1663
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mZoomSeek:Landroid/widget/SeekBar;

    invoke-virtual {v0, v4}, Landroid/widget/SeekBar;->setProgress(I)V

    .line 1664
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mZoomSeek:Landroid/widget/SeekBar;

    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mZoomSeekListener:Landroid/widget/SeekBar$OnSeekBarChangeListener;

    invoke-virtual {v0, v1}, Landroid/widget/SeekBar;->setOnSeekBarChangeListener(Landroid/widget/SeekBar$OnSeekBarChangeListener;)V

    .line 1667
    :cond_1
    iget v0, p0, Lco/vine/android/recorder/VineRecorder;->mFlashSwitcherId:I

    if-lez v0, :cond_7

    .line 1668
    iget v0, p0, Lco/vine/android/recorder/VineRecorder;->mFlashSwitcherId:I

    invoke-virtual {p1, v0}, Landroid/app/Activity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mFlashSwitcher:Landroid/view/View;

    .line 1669
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mSession:Lco/vine/android/recorder/RecordSession;

    invoke-virtual {v0}, Lco/vine/android/recorder/RecordSession;->getConfig()Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;

    move-result-object v0

    iget-boolean v0, v0, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->flashSwitchEnabled:Z

    if-eqz v0, :cond_6

    .line 1670
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mFlashSwitcher:Landroid/view/View;

    invoke-virtual {v0, v4}, Landroid/view/View;->setVisibility(I)V

    .line 1671
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mFlashSwitcher:Landroid/view/View;

    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mSwitchFlashViewListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 1678
    :goto_1
    invoke-virtual {p0}, Lco/vine/android/recorder/VineRecorder;->canSwitchCamera()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 1679
    invoke-direct {p0}, Lco/vine/android/recorder/VineRecorder;->showCameraSwitcher()V

    .line 1681
    :cond_2
    iput-boolean v4, p0, Lco/vine/android/recorder/VineRecorder;->mIsSwitchingCamera:Z

    .line 1683
    iget v0, p0, Lco/vine/android/recorder/VineRecorder;->mProgressOverlayId:I

    invoke-virtual {p1, v0}, Landroid/app/Activity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mProgressOverlay:Landroid/view/View;

    .line 1684
    if-nez p3, :cond_3

    .line 1685
    const-string v0, "UI Resume"

    invoke-virtual {p0, v0, v4}, Lco/vine/android/recorder/VineRecorder;->onResume(Ljava/lang/String;Z)V

    .line 1687
    :cond_3
    return-void

    .line 1646
    :cond_4
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mCameraSwitcher:Landroid/view/ViewGroup;

    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mCameraSwitcherViewListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto :goto_0

    .line 1649
    :cond_5
    iput-object v5, p0, Lco/vine/android/recorder/VineRecorder;->mCameraSwitcher:Landroid/view/ViewGroup;

    goto :goto_0

    .line 1673
    :cond_6
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mFlashSwitcher:Landroid/view/View;

    invoke-virtual {v0, v6}, Landroid/view/View;->setVisibility(I)V

    goto :goto_1

    .line 1676
    :cond_7
    iput-object v5, p0, Lco/vine/android/recorder/VineRecorder;->mFlashSwitcher:Landroid/view/View;

    goto :goto_1
.end method

.method public onZoomUpdated(IZ)V
    .locals 2
    .param p1, "zoom"    # I
    .param p2, "stopped"    # Z

    .prologue
    .line 364
    iput p1, p0, Lco/vine/android/recorder/VineRecorder;->mLastUpdatedZoom:I

    .line 365
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Zoom updated: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 366
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mZoomSeek:Landroid/widget/SeekBar;

    if-eqz v0, :cond_0

    if-eqz p2, :cond_0

    .line 367
    const/4 v0, -0x1

    iput v0, p0, Lco/vine/android/recorder/VineRecorder;->mLastUpdatedZoom:I

    .line 368
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Zoom progress updated: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 369
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mZoomSeek:Landroid/widget/SeekBar;

    add-int/lit8 v1, p1, -0x1

    invoke-virtual {v0, v1}, Landroid/widget/SeekBar;->setProgress(I)V

    .line 370
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mHandler:Landroid/os/Handler;

    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mZoomUpdateRunnable:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 372
    :cond_0
    return-void
.end method

.method public pausePreview(Z)V
    .locals 2
    .param p1, "showPlayButton"    # Z

    .prologue
    const/4 v1, 0x1

    .line 971
    if-eqz p1, :cond_1

    .line 972
    invoke-direct {p0, v1}, Lco/vine/android/recorder/VineRecorder;->animatePlayButton(Z)V

    .line 976
    :goto_0
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mRefreshPreviewTask:Lco/vine/android/recorder/VineRecorder$RefreshPreviewTask;

    if-eqz v0, :cond_0

    .line 977
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mRefreshPreviewTask:Lco/vine/android/recorder/VineRecorder$RefreshPreviewTask;

    invoke-virtual {v0, v1}, Lco/vine/android/recorder/VineRecorder$RefreshPreviewTask;->cancel(Z)Z

    .line 979
    :cond_0
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mVideoPlayer:Lco/vine/android/player/SdkVideoView;

    invoke-virtual {v0}, Lco/vine/android/player/SdkVideoView;->pause()V

    .line 980
    return-void

    .line 974
    :cond_1
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lco/vine/android/recorder/VineRecorder;->animatePlayButton(Z)V

    goto :goto_0
.end method

.method public playPreview(Lco/vine/android/recorder/RecordSegment;Z)V
    .locals 1
    .param p1, "toPlay"    # Lco/vine/android/recorder/RecordSegment;
    .param p2, "forceRefresh"    # Z

    .prologue
    .line 983
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lco/vine/android/recorder/VineRecorder;->animatePlayButton(Z)V

    .line 984
    invoke-virtual {p0, p1, p2}, Lco/vine/android/recorder/VineRecorder;->refreshVideoView(Lco/vine/android/recorder/RecordSegment;Z)V

    .line 985
    return-void
.end method

.method public playStartRecordingSound()V
    .locals 2
    .annotation build Landroid/annotation/TargetApi;
        value = 0x10
    .end annotation

    .prologue
    .line 2024
    :try_start_0
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x10

    if-lt v0, v1, :cond_0

    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mMediaActionSound:Landroid/media/MediaActionSound;

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Lco/vine/android/recorder/VineRecorder;->mPlaySound:Z

    if-eqz v0, :cond_0

    .line 2025
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mMediaActionSound:Landroid/media/MediaActionSound;

    const/4 v1, 0x2

    invoke-virtual {v0, v1}, Landroid/media/MediaActionSound;->play(I)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 2031
    :cond_0
    :goto_0
    return-void

    .line 2027
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method public playStopRecordingSound()V
    .locals 2
    .annotation build Landroid/annotation/TargetApi;
        value = 0x10
    .end annotation

    .prologue
    .line 2011
    :try_start_0
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x10

    if-lt v0, v1, :cond_0

    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mMediaActionSound:Landroid/media/MediaActionSound;

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Lco/vine/android/recorder/VineRecorder;->mPlaySound:Z

    if-eqz v0, :cond_0

    .line 2012
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mMediaActionSound:Landroid/media/MediaActionSound;

    const/4 v1, 0x3

    invoke-virtual {v0, v1}, Landroid/media/MediaActionSound;->play(I)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 2019
    :cond_0
    :goto_0
    return-void

    .line 2014
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method public refreshVideoView(Lco/vine/android/recorder/RecordSegment;Z)V
    .locals 4
    .param p1, "segment"    # Lco/vine/android/recorder/RecordSegment;
    .param p2, "forceRefresh"    # Z

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 1281
    invoke-direct {p0}, Lco/vine/android/recorder/VineRecorder;->releaseSegmentChangeDetector()V

    .line 1282
    new-instance v0, Lco/vine/android/recorder/VineRecorder$SegmentChangeDetector;

    invoke-direct {v0, p0}, Lco/vine/android/recorder/VineRecorder$SegmentChangeDetector;-><init>(Lco/vine/android/recorder/VineRecorder;)V

    iput-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mSegmentChangeDetector:Lco/vine/android/recorder/VineRecorder$SegmentChangeDetector;

    .line 1283
    new-instance v0, Ljava/lang/Thread;

    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mSegmentChangeDetector:Lco/vine/android/recorder/VineRecorder$SegmentChangeDetector;

    invoke-direct {v0, v1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    iput-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mSegmentChangeThread:Ljava/lang/Thread;

    .line 1284
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mSegmentChangeThread:Ljava/lang/Thread;

    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 1285
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mLastPlayingSegment:Lco/vine/android/recorder/RecordSegment;

    if-ne v0, p1, :cond_0

    if-eqz p2, :cond_4

    .line 1286
    :cond_0
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mEditorAdapter:Lco/vine/android/recorder/SegmentEditorAdapter;

    invoke-virtual {v0}, Lco/vine/android/recorder/SegmentEditorAdapter;->getCount()I

    move-result v0

    if-lez v0, :cond_1

    .line 1287
    invoke-virtual {p0, p1}, Lco/vine/android/recorder/VineRecorder;->showThumbnailOverlay(Lco/vine/android/recorder/RecordSegment;)V

    .line 1289
    :cond_1
    if-nez p1, :cond_2

    .line 1290
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mDragSortWidget:Lco/vine/android/dragsort/DragSortWidget;

    if-eqz v0, :cond_2

    .line 1291
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mDragSortWidget:Lco/vine/android/dragsort/DragSortWidget;

    invoke-virtual {v0, v2}, Lco/vine/android/dragsort/DragSortWidget;->setFocused(I)V

    .line 1294
    :cond_2
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mRefreshPreviewTask:Lco/vine/android/recorder/VineRecorder$RefreshPreviewTask;

    if-eqz v0, :cond_3

    .line 1295
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mRefreshPreviewTask:Lco/vine/android/recorder/VineRecorder$RefreshPreviewTask;

    invoke-virtual {v0, v3}, Lco/vine/android/recorder/VineRecorder$RefreshPreviewTask;->cancel(Z)Z

    .line 1297
    :cond_3
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mVideoPlayer:Lco/vine/android/player/SdkVideoView;

    invoke-virtual {v0}, Lco/vine/android/player/SdkVideoView;->suspend()V

    .line 1298
    invoke-direct {p0, v3}, Lco/vine/android/recorder/VineRecorder;->animatePreviewSpinner(Z)V

    .line 1299
    new-instance v0, Lco/vine/android/recorder/VineRecorder$RefreshPreviewTask;

    invoke-direct {v0, p0, p1}, Lco/vine/android/recorder/VineRecorder$RefreshPreviewTask;-><init>(Lco/vine/android/recorder/VineRecorder;Lco/vine/android/recorder/RecordSegment;)V

    iput-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mRefreshPreviewTask:Lco/vine/android/recorder/VineRecorder$RefreshPreviewTask;

    .line 1300
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mRefreshPreviewTask:Lco/vine/android/recorder/VineRecorder$RefreshPreviewTask;

    new-array v1, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1}, Lco/vine/android/recorder/VineRecorder$RefreshPreviewTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 1306
    :goto_0
    return-void

    .line 1302
    :cond_4
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mVideoPlayer:Lco/vine/android/player/SdkVideoView;

    invoke-virtual {v0}, Lco/vine/android/player/SdkVideoView;->resume()V

    .line 1303
    invoke-virtual {p0}, Lco/vine/android/recorder/VineRecorder;->hideThumbnailOverlayDelayed()V

    .line 1304
    invoke-direct {p0, v2}, Lco/vine/android/recorder/VineRecorder;->animatePreviewSpinner(Z)V

    goto :goto_0
.end method

.method public release()Z
    .locals 1

    .prologue
    .line 392
    const/4 v0, 0x0

    iput-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mLastPlayingSegment:Lco/vine/android/recorder/RecordSegment;

    .line 393
    invoke-super {p0}, Lco/vine/android/recorder/RegularVineRecorder;->release()Z

    move-result v0

    return v0
.end method

.method public requestZoomProgressUpdate()V
    .locals 4

    .prologue
    .line 386
    invoke-static {}, Lco/vine/android/recorder/CameraManager;->getInstance()Lco/vine/android/recorder/CameraManager;

    move-result-object v0

    invoke-virtual {v0}, Lco/vine/android/recorder/CameraManager;->isSmoothZoomingSupported()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 387
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mHandler:Landroid/os/Handler;

    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mZoomUpdateRunnable:Ljava/lang/Runnable;

    const-wide/16 v2, 0x1e

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 389
    :cond_0
    return-void
.end method

.method public reverseFrames()V
    .locals 1

    .prologue
    .line 1121
    invoke-virtual {p0}, Lco/vine/android/recorder/VineRecorder;->isEditing()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1122
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mEditorAdapter:Lco/vine/android/recorder/SegmentEditorAdapter;

    invoke-virtual {v0}, Lco/vine/android/recorder/SegmentEditorAdapter;->reverse()V

    .line 1124
    :cond_0
    return-void
.end method

.method public saveSession(Ljava/lang/Runnable;Z)V
    .locals 2
    .param p1, "onSaveSessionCompleteRunnable"    # Ljava/lang/Runnable;
    .param p2, "releaseCamera"    # Z

    .prologue
    .line 870
    const/4 v0, 0x0

    iput-boolean v0, p0, Lco/vine/android/recorder/VineRecorder;->mCanKeepRecording:Z

    .line 871
    const-string v0, "saveSession"

    const/4 v1, 0x1

    invoke-virtual {p0, v0, p1, p2, v1}, Lco/vine/android/recorder/VineRecorder;->stop(Ljava/lang/String;Ljava/lang/Runnable;ZZ)V

    .line 872
    return-void
.end method

.method public setAutoFocusing(Z)V
    .locals 3
    .param p1, "autoFocusing"    # Z

    .prologue
    .line 401
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    .line 402
    .local v0, "controller":Lco/vine/android/recorder/RecordController;
    if-eqz v0, :cond_0

    .line 403
    iput-boolean p1, p0, Lco/vine/android/recorder/VineRecorder;->mAutoFocusing:Z

    .line 404
    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    iget-boolean v2, p0, Lco/vine/android/recorder/VineRecorder;->mAutoFocusing:Z

    invoke-virtual {v1, v2}, Lco/vine/android/recorder/RecordController;->setAutoFocus(Z)V

    .line 405
    iget-boolean v1, p0, Lco/vine/android/recorder/VineRecorder;->mAutoFocusing:Z

    if-eqz v1, :cond_0

    .line 406
    invoke-direct {p0}, Lco/vine/android/recorder/VineRecorder;->dismissFocusIndicator()V

    .line 409
    :cond_0
    return-void
.end method

.method public setDiscardChanges(Z)V
    .locals 0
    .param p1, "discardChanges"    # Z

    .prologue
    .line 1270
    iput-boolean p1, p0, Lco/vine/android/recorder/VineRecorder;->mDiscardChanges:Z

    .line 1271
    return-void
.end method

.method public setEditMode(Landroid/view/View;ZZ)V
    .locals 7
    .param p1, "view"    # Landroid/view/View;
    .param p2, "on"    # Z
    .param p3, "discard"    # Z

    .prologue
    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 689
    const-string v2, "Set edit mode: {} {}."

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    invoke-static {p2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    aput-object v4, v3, v5

    invoke-static {p3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    aput-object v4, v3, v6

    invoke-static {v2, v3}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 690
    iget-boolean v2, p0, Lco/vine/android/recorder/VineRecorder;->mTimelapsing:Z

    if-eqz v2, :cond_1

    sget-boolean v2, Lcom/edisonwang/android/slog/SLog;->sLogsOn:Z

    if-eqz v2, :cond_1

    .line 691
    iput-boolean v5, p0, Lco/vine/android/recorder/VineRecorder;->mTimelapsing:Z

    .line 692
    iget-object v2, p0, Lco/vine/android/recorder/VineRecorder;->mHandler:Landroid/os/Handler;

    iget-object v3, p0, Lco/vine/android/recorder/VineRecorder;->mTimeLapseRunnable:Ljava/lang/Runnable;

    invoke-virtual {v2, v3}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 760
    :cond_0
    :goto_0
    return-void

    .line 695
    :cond_1
    iget-boolean v1, p0, Lco/vine/android/recorder/VineRecorder;->mEditing:Z

    .line 696
    .local v1, "wasEditingAlready":Z
    iput-boolean p2, p0, Lco/vine/android/recorder/VineRecorder;->mEditing:Z

    .line 697
    iget-object v2, p0, Lco/vine/android/recorder/VineRecorder;->mUndoButton:Landroid/view/View;

    const/16 v3, 0x8

    invoke-virtual {v2, v3}, Landroid/view/View;->setVisibility(I)V

    .line 698
    iget-object v2, p0, Lco/vine/android/recorder/VineRecorder;->mCurrentRecordingFile:Lco/vine/android/recorder/RecordingFile;

    invoke-virtual {v2}, Lco/vine/android/recorder/RecordingFile;->hasData()Z

    move-result v2

    if-eqz v2, :cond_c

    .line 699
    iget-boolean v2, p0, Lco/vine/android/recorder/VineRecorder;->mEditing:Z

    if-eqz v2, :cond_4

    .line 700
    iput-boolean v5, p0, Lco/vine/android/recorder/VineRecorder;->mStartWithEditMode:Z

    .line 701
    invoke-virtual {p0}, Lco/vine/android/recorder/VineRecorder;->canKeepRecording()Z

    move-result v2

    if-eqz v2, :cond_3

    .line 702
    iget-object v2, p0, Lco/vine/android/recorder/VineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    invoke-virtual {v2}, Lco/vine/android/recorder/RecordController;->isRecordingStarted()Z

    move-result v2

    if-eqz v2, :cond_2

    .line 703
    const-string v2, "editMode"

    new-instance v3, Lco/vine/android/recorder/VineRecorder$11;

    invoke-direct {v3, p0, v1}, Lco/vine/android/recorder/VineRecorder$11;-><init>(Lco/vine/android/recorder/VineRecorder;Z)V

    invoke-virtual {p0, v2, v3, v6, v5}, Lco/vine/android/recorder/VineRecorder;->stop(Ljava/lang/String;Ljava/lang/Runnable;ZZ)V

    goto :goto_0

    .line 710
    :cond_2
    invoke-virtual {p0, v1}, Lco/vine/android/recorder/VineRecorder;->startEditMode(Z)V

    goto :goto_0

    .line 713
    :cond_3
    iput-boolean v5, p0, Lco/vine/android/recorder/VineRecorder;->mEditing:Z

    goto :goto_0

    .line 716
    :cond_4
    invoke-direct {p0}, Lco/vine/android/recorder/VineRecorder;->releaseSegmentChangeDetector()V

    .line 717
    iget-object v2, p0, Lco/vine/android/recorder/VineRecorder;->mRefreshPreviewTask:Lco/vine/android/recorder/VineRecorder$RefreshPreviewTask;

    if-eqz v2, :cond_5

    .line 718
    iget-object v2, p0, Lco/vine/android/recorder/VineRecorder;->mRefreshPreviewTask:Lco/vine/android/recorder/VineRecorder$RefreshPreviewTask;

    invoke-virtual {v2, v6}, Lco/vine/android/recorder/VineRecorder$RefreshPreviewTask;->cancel(Z)Z

    .line 720
    :cond_5
    iget-object v2, p0, Lco/vine/android/recorder/VineRecorder;->mVideoPlayer:Lco/vine/android/player/SdkVideoView;

    if-eqz v2, :cond_6

    .line 721
    iget-object v2, p0, Lco/vine/android/recorder/VineRecorder;->mVideoPlayer:Lco/vine/android/player/SdkVideoView;

    invoke-virtual {v2}, Lco/vine/android/player/SdkVideoView;->stopPlayback()V

    .line 723
    :cond_6
    iget-object v2, p0, Lco/vine/android/recorder/VineRecorder;->mDragSortWidget:Lco/vine/android/dragsort/DragSortWidget;

    if-eqz v2, :cond_7

    .line 724
    iget-object v2, p0, Lco/vine/android/recorder/VineRecorder;->mDragSortWidget:Lco/vine/android/dragsort/DragSortWidget;

    invoke-virtual {v2}, Lco/vine/android/dragsort/DragSortWidget;->cleanUp()V

    .line 726
    :cond_7
    iget-boolean v2, p0, Lco/vine/android/recorder/VineRecorder;->mIsGridOn:Z

    if-eqz v2, :cond_8

    .line 727
    invoke-virtual {p0, v5}, Lco/vine/android/recorder/VineRecorder;->setGridOn(Z)V

    .line 728
    iget-object v2, p0, Lco/vine/android/recorder/VineRecorder;->mGridSwitch:Landroid/widget/ToggleButton;

    iget-boolean v3, p0, Lco/vine/android/recorder/VineRecorder;->mIsGridOn:Z

    invoke-virtual {v2, v3}, Landroid/widget/ToggleButton;->setChecked(Z)V

    .line 730
    :cond_8
    iget-boolean v2, p0, Lco/vine/android/recorder/VineRecorder;->mGhostModeEnabled:Z

    if-eqz v2, :cond_9

    .line 731
    invoke-virtual {p0, v5}, Lco/vine/android/recorder/VineRecorder;->setGhostMode(Z)Z

    .line 733
    :cond_9
    if-nez p3, :cond_b

    .line 734
    invoke-direct {p0}, Lco/vine/android/recorder/VineRecorder;->commitChanges()Z

    move-result v2

    if-eqz v2, :cond_a

    .line 735
    iget-object v2, p0, Lco/vine/android/recorder/VineRecorder;->mEditedSegments:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v0

    .line 736
    .local v0, "size":I
    if-lez v0, :cond_a

    iget-object v2, p0, Lco/vine/android/recorder/VineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    if-eqz v2, :cond_a

    .line 737
    iget-object v3, p0, Lco/vine/android/recorder/VineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    iget-object v2, p0, Lco/vine/android/recorder/VineRecorder;->mEditedSegments:Ljava/util/ArrayList;

    add-int/lit8 v4, v0, -0x1

    invoke-virtual {v2, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lco/vine/android/recorder/RecordSegment;

    invoke-virtual {v3, v2, v6}, Lco/vine/android/recorder/RecordController;->makePreview(Lco/vine/android/recorder/RecordSegment;Z)V

    .line 740
    .end local v0    # "size":I
    :cond_a
    iget-object v2, p0, Lco/vine/android/recorder/VineRecorder;->mCurrentRecordingFile:Lco/vine/android/recorder/RecordingFile;

    if-eqz v2, :cond_b

    .line 741
    iget-object v2, p0, Lco/vine/android/recorder/VineRecorder;->mCurrentRecordingFile:Lco/vine/android/recorder/RecordingFile;

    invoke-virtual {v2}, Lco/vine/android/recorder/RecordingFile;->invalidateGhostThumbnail()V

    .line 744
    :cond_b
    invoke-direct {p0, v6}, Lco/vine/android/recorder/VineRecorder;->animateEditModeControlsOut(Z)V

    .line 745
    invoke-direct {p0}, Lco/vine/android/recorder/VineRecorder;->animateCaptureControlsIn()V

    .line 746
    invoke-direct {p0}, Lco/vine/android/recorder/VineRecorder;->invalidateGhostView()V

    .line 747
    invoke-virtual {p0}, Lco/vine/android/recorder/VineRecorder;->invalidateFinishButton()V

    .line 748
    invoke-virtual {p0}, Lco/vine/android/recorder/VineRecorder;->setHasPreviewedAlreadyIfNeeded()V

    .line 749
    iput-boolean v5, p0, Lco/vine/android/recorder/VineRecorder;->mReturnToPreview:Z

    .line 750
    new-instance v2, Lco/vine/android/recorder/RegularVineRecorder$OnResumeTask;

    const-string v3, "Set EditMode."

    invoke-direct {v2, p0, p1, v3}, Lco/vine/android/recorder/RegularVineRecorder$OnResumeTask;-><init>(Lco/vine/android/recorder/RegularVineRecorder;Landroid/view/View;Ljava/lang/String;)V

    iput-object v2, p0, Lco/vine/android/recorder/VineRecorder;->mResumeTask:Lco/vine/android/recorder/BasicVineRecorder$OnResumeTask;

    .line 751
    iget-object v2, p0, Lco/vine/android/recorder/VineRecorder;->mResumeTask:Lco/vine/android/recorder/BasicVineRecorder$OnResumeTask;

    new-array v3, v5, [Ljava/lang/Void;

    invoke-virtual {v2, v3}, Lco/vine/android/recorder/BasicVineRecorder$OnResumeTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 752
    const/4 v2, 0x0

    iput-object v2, p0, Lco/vine/android/recorder/VineRecorder;->mEditorAdapter:Lco/vine/android/recorder/SegmentEditorAdapter;

    goto/16 :goto_0

    .line 755
    :cond_c
    iput-boolean v5, p0, Lco/vine/android/recorder/VineRecorder;->mEditing:Z

    .line 756
    sget-boolean v2, Lcom/edisonwang/android/slog/SLog;->sLogsOn:Z

    if-eqz v2, :cond_0

    .line 757
    invoke-virtual {p0}, Lco/vine/android/recorder/VineRecorder;->showTimeLapseDialog()V

    goto/16 :goto_0
.end method

.method public setEditMode(ZZ)V
    .locals 1
    .param p1, "on"    # Z
    .param p2, "discard"    # Z

    .prologue
    .line 763
    const/4 v0, 0x0

    invoke-virtual {p0, v0, p1, p2}, Lco/vine/android/recorder/VineRecorder;->setEditMode(Landroid/view/View;ZZ)V

    .line 764
    return-void
.end method

.method public setGhostMode(Z)Z
    .locals 3
    .param p1, "enable"    # Z

    .prologue
    const/4 v0, 0x0

    .line 436
    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mGhostView:Landroid/widget/ImageView;

    if-eqz v1, :cond_2

    .line 437
    if-eqz p1, :cond_0

    .line 438
    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mGhostView:Landroid/widget/ImageView;

    invoke-virtual {v1, v0}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 442
    :goto_0
    iput-boolean p1, p0, Lco/vine/android/recorder/VineRecorder;->mGhostModeEnabled:Z

    .line 443
    iget-boolean v1, p0, Lco/vine/android/recorder/VineRecorder;->mGhostModeEnabled:Z

    if-eqz v1, :cond_1

    .line 444
    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    invoke-virtual {v1, v0}, Lco/vine/android/recorder/RecordController;->requestGhostDrawing(Z)V

    .line 448
    :goto_1
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mGhostButton:Landroid/widget/ToggleButton;

    invoke-virtual {v0, p1}, Landroid/widget/ToggleButton;->setChecked(Z)V

    .line 451
    .end local p1    # "enable":Z
    :goto_2
    return p1

    .line 440
    .restart local p1    # "enable":Z
    :cond_0
    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mGhostView:Landroid/widget/ImageView;

    const/16 v2, 0x8

    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setVisibility(I)V

    goto :goto_0

    .line 446
    :cond_1
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lco/vine/android/recorder/VineRecorder;->updateGhostBitmap(Landroid/graphics/Bitmap;)V

    goto :goto_1

    :cond_2
    move p1, v0

    .line 451
    goto :goto_2
.end method

.method public setGridOn(Z)V
    .locals 0
    .param p1, "b"    # Z

    .prologue
    .line 480
    iput-boolean p1, p0, Lco/vine/android/recorder/VineRecorder;->mIsGridOn:Z

    .line 481
    return-void
.end method

.method protected setHasPreviewedAlreadyIfNeeded()V
    .locals 4

    .prologue
    .line 767
    iget-wide v0, p0, Lco/vine/android/recorder/VineRecorder;->mCurrentDuration:J

    iget-object v2, p0, Lco/vine/android/recorder/VineRecorder;->mSession:Lco/vine/android/recorder/RecordSession;

    invoke-virtual {v2}, Lco/vine/android/recorder/RecordSession;->getConfig()Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;

    move-result-object v2

    iget v2, v2, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->maxDuration:I

    int-to-long v2, v2

    cmp-long v0, v0, v2

    if-ltz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    iput-boolean v0, p0, Lco/vine/android/recorder/VineRecorder;->mHasPreviewedAlready:Z

    .line 768
    return-void

    .line 767
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public showFocusIndicator(II)V
    .locals 7
    .param p1, "x"    # I
    .param p2, "y"    # I

    .prologue
    .line 422
    iget-object v2, p0, Lco/vine/android/recorder/VineRecorder;->mFocusIndicator:Landroid/widget/ImageView;

    if-eqz v2, :cond_0

    .line 423
    iget-object v2, p0, Lco/vine/android/recorder/VineRecorder;->mFocusIndicator:Landroid/widget/ImageView;

    invoke-virtual {v2}, Landroid/widget/ImageView;->getMeasuredWidth()I

    move-result v1

    .line 424
    .local v1, "width":I
    iget-object v2, p0, Lco/vine/android/recorder/VineRecorder;->mFocusIndicator:Landroid/widget/ImageView;

    invoke-virtual {v2}, Landroid/widget/ImageView;->getMeasuredHeight()I

    move-result v0

    .line 425
    .local v0, "height":I
    iget-object v2, p0, Lco/vine/android/recorder/VineRecorder;->mFocusIndicator:Landroid/widget/ImageView;

    div-int/lit8 v3, v1, 0x2

    sub-int v3, p1, v3

    div-int/lit8 v4, v0, 0x2

    sub-int v4, p2, v4

    div-int/lit8 v5, v1, 0x2

    add-int/2addr v5, p1

    div-int/lit8 v6, v0, 0x2

    add-int/2addr v6, p2

    invoke-virtual {v2, v3, v4, v5, v6}, Landroid/widget/ImageView;->layout(IIII)V

    .line 426
    iget-object v2, p0, Lco/vine/android/recorder/VineRecorder;->mFocusIndicator:Landroid/widget/ImageView;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 427
    iget-object v2, p0, Lco/vine/android/recorder/VineRecorder;->mFocusIndicator:Landroid/widget/ImageView;

    iget-object v3, p0, Lco/vine/android/recorder/VineRecorder;->mFocusAnimationSet:Landroid/view/animation/AnimationSet;

    invoke-virtual {v2, v3}, Landroid/widget/ImageView;->startAnimation(Landroid/view/animation/Animation;)V

    .line 429
    .end local v0    # "height":I
    .end local v1    # "width":I
    :cond_0
    return-void
.end method

.method public showThumbnailOverlay(Lco/vine/android/recorder/RecordSegment;)V
    .locals 4
    .param p1, "segment"    # Lco/vine/android/recorder/RecordSegment;

    .prologue
    const/4 v3, 0x0

    .line 908
    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mThumbnailOverlay:Landroid/widget/ImageView;

    if-eqz v1, :cond_2

    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mThumbnailOverlay:Landroid/widget/ImageView;

    invoke-virtual {v1}, Landroid/widget/ImageView;->getVisibility()I

    move-result v1

    if-nez v1, :cond_0

    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mThumbnailSegment:Lco/vine/android/recorder/RecordSegment;

    if-eq p1, v1, :cond_2

    .line 909
    :cond_0
    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mThumbnailOverlay:Landroid/widget/ImageView;

    invoke-virtual {v1, v3}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 910
    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mThumbnailOverlay:Landroid/widget/ImageView;

    const/high16 v2, 0x3f800000    # 1.0f

    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setAlpha(F)V

    .line 911
    if-nez p1, :cond_1

    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mEditorAdapter:Lco/vine/android/recorder/SegmentEditorAdapter;

    invoke-virtual {v1}, Lco/vine/android/recorder/SegmentEditorAdapter;->getCount()I

    move-result v1

    if-lez v1, :cond_1

    .line 912
    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mEditorAdapter:Lco/vine/android/recorder/SegmentEditorAdapter;

    invoke-virtual {v1, v3}, Lco/vine/android/recorder/SegmentEditorAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object p1

    .end local p1    # "segment":Lco/vine/android/recorder/RecordSegment;
    check-cast p1, Lco/vine/android/recorder/RecordSegment;

    .line 914
    .restart local p1    # "segment":Lco/vine/android/recorder/RecordSegment;
    :cond_1
    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mActivity:Landroid/app/Activity;

    invoke-virtual {p1, v1}, Lco/vine/android/recorder/RecordSegment;->getDrawableCopy(Landroid/content/Context;)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .line 915
    .local v0, "thumbDrawable":Landroid/graphics/drawable/Drawable;
    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mThumbnailOverlay:Landroid/widget/ImageView;

    invoke-virtual {v1, v0}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 917
    .end local v0    # "thumbDrawable":Landroid/graphics/drawable/Drawable;
    :cond_2
    iput-object p1, p0, Lco/vine/android/recorder/VineRecorder;->mThumbnailSegment:Lco/vine/android/recorder/RecordSegment;

    .line 918
    return-void
.end method

.method public showTimeLapseDialog()V
    .locals 5

    .prologue
    .line 1159
    new-instance v0, Landroid/app/AlertDialog$Builder;

    iget-object v3, p0, Lco/vine/android/recorder/VineRecorder;->mActivity:Landroid/app/Activity;

    invoke-direct {v0, v3}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 1160
    .local v0, "alert":Landroid/app/AlertDialog$Builder;
    const-string v3, "Time Lapse Mode"

    invoke-virtual {v0, v3}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    .line 1161
    new-instance v2, Landroid/widget/LinearLayout;

    iget-object v3, p0, Lco/vine/android/recorder/VineRecorder;->mActivity:Landroid/app/Activity;

    invoke-direct {v2, v3}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    .line 1162
    .local v2, "ll":Landroid/widget/LinearLayout;
    new-instance v1, Landroid/widget/EditText;

    iget-object v3, p0, Lco/vine/android/recorder/VineRecorder;->mActivity:Landroid/app/Activity;

    invoke-direct {v1, v3}, Landroid/widget/EditText;-><init>(Landroid/content/Context;)V

    .line 1163
    .local v1, "et":Landroid/widget/EditText;
    const/16 v3, 0x2002

    invoke-virtual {v1, v3}, Landroid/widget/EditText;->setInputType(I)V

    .line 1164
    const-string v3, "time in seconds, decimals OK."

    invoke-virtual {v1, v3}, Landroid/widget/EditText;->setHint(Ljava/lang/CharSequence;)V

    .line 1165
    invoke-virtual {v2, v1}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 1166
    invoke-virtual {v0, v2}, Landroid/app/AlertDialog$Builder;->setView(Landroid/view/View;)Landroid/app/AlertDialog$Builder;

    .line 1167
    const-string v3, "Start"

    new-instance v4, Lco/vine/android/recorder/VineRecorder$15;

    invoke-direct {v4, p0, v1}, Lco/vine/android/recorder/VineRecorder$15;-><init>(Lco/vine/android/recorder/VineRecorder;Landroid/widget/EditText;)V

    invoke-virtual {v0, v3, v4}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 1177
    const-string v3, "Cancel"

    new-instance v4, Lco/vine/android/recorder/VineRecorder$16;

    invoke-direct {v4, p0}, Lco/vine/android/recorder/VineRecorder$16;-><init>(Lco/vine/android/recorder/VineRecorder;)V

    invoke-virtual {v0, v3, v4}, Landroid/app/AlertDialog$Builder;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 1183
    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->show()Landroid/app/AlertDialog;

    .line 1184
    return-void
.end method

.method public startEditMode(Z)V
    .locals 7
    .param p1, "wasRecordingAlready"    # Z

    .prologue
    const/4 v6, 0x0

    const/4 v5, -0x1

    const/4 v4, 0x0

    .line 642
    invoke-direct {p0}, Lco/vine/android/recorder/VineRecorder;->adjustEditBoundaries()V

    .line 643
    iget-boolean v0, p0, Lco/vine/android/recorder/VineRecorder;->mReturnToPreview:Z

    if-nez v0, :cond_3

    .line 644
    invoke-direct {p0}, Lco/vine/android/recorder/VineRecorder;->animateCaptureControlsOut()V

    .line 648
    :goto_0
    invoke-direct {p0}, Lco/vine/android/recorder/VineRecorder;->animateEditModeControlsIn()V

    .line 650
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mTrashUndoContainer:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 651
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mTrashUndoContainer:Landroid/view/View;

    invoke-virtual {v0, v4}, Landroid/view/View;->setActivated(Z)V

    .line 654
    :cond_0
    iput v5, p0, Lco/vine/android/recorder/VineRecorder;->mLastSelectedPosition:I

    .line 656
    iput-object v6, p0, Lco/vine/android/recorder/VineRecorder;->mLastPlayingSegment:Lco/vine/android/recorder/RecordSegment;

    .line 658
    if-nez p1, :cond_4

    .line 659
    new-instance v0, Lco/vine/android/recorder/SegmentEditorAdapter;

    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mEditedSegments:Ljava/util/ArrayList;

    iget-object v2, p0, Lco/vine/android/recorder/VineRecorder;->mActivity:Landroid/app/Activity;

    iget v3, p0, Lco/vine/android/recorder/VineRecorder;->density:F

    invoke-direct {v0, v1, v2, v3}, Lco/vine/android/recorder/SegmentEditorAdapter;-><init>(Ljava/util/ArrayList;Landroid/content/Context;F)V

    iput-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mEditorAdapter:Lco/vine/android/recorder/SegmentEditorAdapter;

    .line 664
    :goto_1
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mEditorAdapter:Lco/vine/android/recorder/SegmentEditorAdapter;

    invoke-virtual {v0}, Lco/vine/android/recorder/SegmentEditorAdapter;->canUndoDelete()Z

    move-result v0

    if-eqz v0, :cond_5

    .line 665
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mUndoButton:Landroid/view/View;

    invoke-virtual {v0, v4}, Landroid/view/View;->setVisibility(I)V

    .line 670
    :goto_2
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mDragSortWidget:Lco/vine/android/dragsort/DragSortWidget;

    if-eqz v0, :cond_1

    .line 671
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mDragSortWidget:Lco/vine/android/dragsort/DragSortWidget;

    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mEditorAdapter:Lco/vine/android/recorder/SegmentEditorAdapter;

    invoke-virtual {v0, v1}, Lco/vine/android/dragsort/DragSortWidget;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 673
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mEditorAdapter:Lco/vine/android/recorder/SegmentEditorAdapter;

    invoke-virtual {v0}, Lco/vine/android/recorder/SegmentEditorAdapter;->notifyDataSetChanged()V

    .line 675
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mDragSortWidget:Lco/vine/android/dragsort/DragSortWidget;

    invoke-virtual {v0, v5}, Lco/vine/android/dragsort/DragSortWidget;->setSelection(I)V

    .line 676
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mDragSortWidget:Lco/vine/android/dragsort/DragSortWidget;

    invoke-virtual {v0, v4}, Lco/vine/android/dragsort/DragSortWidget;->setFocused(I)V

    .line 679
    :cond_1
    invoke-virtual {p0, v4}, Lco/vine/android/recorder/VineRecorder;->setGhostMode(Z)Z

    .line 681
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mGridSwitch:Landroid/widget/ToggleButton;

    if-eqz v0, :cond_2

    .line 682
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mGridSwitch:Landroid/widget/ToggleButton;

    invoke-virtual {v0, v4}, Landroid/widget/ToggleButton;->setChecked(Z)V

    .line 685
    :cond_2
    const/4 v0, 0x1

    invoke-virtual {p0, v6, v0}, Lco/vine/android/recorder/VineRecorder;->refreshVideoView(Lco/vine/android/recorder/RecordSegment;Z)V

    .line 686
    return-void

    .line 646
    :cond_3
    invoke-direct {p0}, Lco/vine/android/recorder/VineRecorder;->hideCaptureControls()V

    goto :goto_0

    .line 662
    :cond_4
    new-instance v0, Lco/vine/android/recorder/SegmentEditorAdapter;

    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mEditorAdapter:Lco/vine/android/recorder/SegmentEditorAdapter;

    invoke-direct {v0, v1}, Lco/vine/android/recorder/SegmentEditorAdapter;-><init>(Lco/vine/android/recorder/SegmentEditorAdapter;)V

    iput-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mEditorAdapter:Lco/vine/android/recorder/SegmentEditorAdapter;

    goto :goto_1

    .line 667
    :cond_5
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mUndoButton:Landroid/view/View;

    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    goto :goto_2
.end method

.method public startTimeLapse(D)V
    .locals 2
    .param p1, "sec"    # D

    .prologue
    .line 1187
    const-wide v0, 0x408f400000000000L    # 1000.0

    mul-double/2addr v0, p1

    iput-wide v0, p0, Lco/vine/android/recorder/VineRecorder;->mTimeLapseDelay:D

    .line 1188
    const/4 v0, 0x1

    iput-boolean v0, p0, Lco/vine/android/recorder/VineRecorder;->mTimelapsing:Z

    .line 1189
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mTimeLapseRunnable:Ljava/lang/Runnable;

    invoke-interface {v0}, Ljava/lang/Runnable;->run()V

    .line 1190
    return-void
.end method

.method public stopZoom()V
    .locals 2

    .prologue
    .line 356
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    invoke-virtual {v0}, Lco/vine/android/recorder/RecordController;->isRecordingStarted()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 357
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    invoke-virtual {v0}, Lco/vine/android/recorder/RecordController;->stopZoom()V

    .line 358
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mHandler:Landroid/os/Handler;

    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mZoomUpdateRunnable:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 360
    :cond_0
    return-void
.end method

.method public swapSession(Ljava/lang/String;Lco/vine/android/recorder/RecordingFile;)Lco/vine/android/recorder/RecordingFile;
    .locals 2
    .param p1, "tag"    # Ljava/lang/String;
    .param p2, "file"    # Lco/vine/android/recorder/RecordingFile;

    .prologue
    .line 328
    const/4 v0, 0x0

    .line 329
    .local v0, "ret":Lco/vine/android/recorder/RecordingFile;
    if-eqz p2, :cond_0

    .line 330
    invoke-super {p0, p1, p2}, Lco/vine/android/recorder/RegularVineRecorder;->swapSession(Ljava/lang/String;Lco/vine/android/recorder/RecordingFile;)Lco/vine/android/recorder/RecordingFile;

    move-result-object v0

    .line 331
    invoke-direct {p0}, Lco/vine/android/recorder/VineRecorder;->invalidateGhostView()V

    .line 332
    const/4 v1, 0x0

    invoke-virtual {p0, v1}, Lco/vine/android/recorder/VineRecorder;->setGhostMode(Z)Z

    .line 334
    :cond_0
    return-object v0
.end method

.method public switchFlash()V
    .locals 1

    .prologue
    .line 346
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    invoke-virtual {v0}, Lco/vine/android/recorder/RecordController;->switchFlash()V

    .line 347
    return-void
.end method

.method public updateGhostBitmap(Landroid/graphics/Bitmap;)V
    .locals 2
    .param p1, "ghostBitmap"    # Landroid/graphics/Bitmap;

    .prologue
    .line 456
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder;->mHandler:Landroid/os/Handler;

    new-instance v1, Lco/vine/android/recorder/VineRecorder$8;

    invoke-direct {v1, p0, p1}, Lco/vine/android/recorder/VineRecorder$8;-><init>(Lco/vine/android/recorder/VineRecorder;Landroid/graphics/Bitmap;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 477
    return-void
.end method

.method public writePreviewToFile()V
    .locals 13

    .prologue
    const/4 v12, 0x0

    .line 1440
    :try_start_0
    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mEditedSegments:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-lez v1, :cond_0

    .line 1441
    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder;->mEditedSegments:Ljava/util/ArrayList;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lco/vine/android/recorder/RecordSegment;

    invoke-virtual {v1}, Lco/vine/android/recorder/RecordSegment;->getCameraSetting()Lco/vine/android/recorder/CameraSetting;

    move-result-object v1

    iget v1, v1, Lco/vine/android/recorder/CameraSetting;->frameRate:I

    iput v1, p0, Lco/vine/android/recorder/VineRecorder;->mCurrentFrameRate:I

    .line 1446
    :goto_0
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lco/vine/android/recorder/VineRecorder;->mCurrentRecordingFile:Lco/vine/android/recorder/RecordingFile;

    invoke-virtual {v2}, Lco/vine/android/recorder/RecordingFile;->getVideoPath()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ".video"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    sget-object v2, Lco/vine/android/recorder/RecordConfigUtils;->VIDEO_CONTAINER_EXT:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    iget v2, p0, Lco/vine/android/recorder/VineRecorder;->mCurrentFrameRate:I

    const/16 v3, 0x1e0

    iget-boolean v4, p0, Lco/vine/android/recorder/VineRecorder;->mUseMp4:Z

    invoke-static {v1, v2, v3, v4}, Lco/vine/android/recorder/RecordConfigUtils;->newVideoRecorder(Ljava/lang/String;IIZ)Lco/vine/android/recorder/SwVineFrameRecorder;

    move-result-object v6

    .line 1448
    .local v6, "videoRecorder":Lco/vine/android/recorder/SwVineFrameRecorder;
    invoke-virtual {v6}, Lco/vine/android/recorder/SwVineFrameRecorder;->start()V

    .line 1449
    invoke-virtual {p0}, Lco/vine/android/recorder/VineRecorder;->getFile()Lco/vine/android/recorder/RecordingFile;

    move-result-object v1

    invoke-virtual {v1}, Lco/vine/android/recorder/RecordingFile;->getSession()Lco/vine/android/recorder/RecordSession;

    move-result-object v11

    .line 1450
    .local v11, "recordSession":Lco/vine/android/recorder/RecordSession;
    new-instance v0, Lco/vine/android/recorder/SwCombiningRunnable;

    invoke-virtual {p0}, Lco/vine/android/recorder/VineRecorder;->getFile()Lco/vine/android/recorder/RecordingFile;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v11}, Lco/vine/android/recorder/RecordSession;->getAudioData()Lco/vine/android/recorder/AudioArray;

    move-result-object v3

    invoke-virtual {v11}, Lco/vine/android/recorder/RecordSession;->getVideoData()[B

    move-result-object v4

    iget-object v5, p0, Lco/vine/android/recorder/VineRecorder;->mEditedSegments:Ljava/util/ArrayList;

    iget-object v7, p0, Lco/vine/android/recorder/VineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    invoke-virtual {v7}, Lco/vine/android/recorder/RecordController;->getFinishProcessTask()Lco/vine/android/recorder/BaseFinishProcessTask;

    move-result-object v7

    iget-object v8, p0, Lco/vine/android/recorder/VineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    invoke-virtual {v8}, Lco/vine/android/recorder/RecordController;->getPreviewBitmap()Landroid/graphics/Bitmap;

    move-result-object v8

    iget-object v9, p0, Lco/vine/android/recorder/VineRecorder;->mVideoController:Lco/vine/android/recorder/RecordController;

    invoke-virtual {v9}, Lco/vine/android/recorder/RecordController;->getFrameBuffer()Lcom/googlecode/javacv/cpp/opencv_core$IplImage;

    move-result-object v9

    invoke-direct/range {v0 .. v9}, Lco/vine/android/recorder/SwCombiningRunnable;-><init>(Lco/vine/android/recorder/RecordingFile;ZLco/vine/android/recorder/AudioArray;[BLjava/util/ArrayList;Lco/vine/android/recorder/SwVineFrameRecorder;Lco/vine/android/recorder/BaseFinishProcessTask;Landroid/graphics/Bitmap;Lcom/googlecode/javacv/cpp/opencv_core$IplImage;)V

    .line 1453
    .local v0, "combiningRunnable":Lco/vine/android/recorder/SwCombiningRunnable;
    invoke-virtual {v0}, Lco/vine/android/recorder/SwCombiningRunnable;->combineVideos()Lco/vine/android/util/MediaUtil$GenerateThumbnailsRunnable;

    .line 1457
    .end local v0    # "combiningRunnable":Lco/vine/android/recorder/SwCombiningRunnable;
    .end local v6    # "videoRecorder":Lco/vine/android/recorder/SwVineFrameRecorder;
    .end local v11    # "recordSession":Lco/vine/android/recorder/RecordSession;
    :goto_1
    return-void

    .line 1443
    :cond_0
    const/16 v1, 0x1e

    iput v1, p0, Lco/vine/android/recorder/VineRecorder;->mCurrentFrameRate:I
    :try_end_0
    .catch Lco/vine/android/recorder/SwVineFrameRecorder$Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 1454
    :catch_0
    move-exception v10

    .line 1455
    .local v10, "e":Lco/vine/android/recorder/SwVineFrameRecorder$Exception;
    const-string v1, "Cannot start audio/video recorder. "

    new-array v2, v12, [Ljava/lang/Object;

    invoke-static {v10, v1, v2}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_1
.end method
