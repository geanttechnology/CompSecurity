.class public Lco/vine/android/InlineRecorderManager;
.super Landroid/widget/RelativeLayout;
.source "InlineRecorderManager.java"

# interfaces
.implements Lco/vine/android/recorder/InlineVineRecorder$ProcessingListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/InlineRecorderManager$1;,
        Lco/vine/android/InlineRecorderManager$ResumeThread;,
        Lco/vine/android/InlineRecorderManager$FinishRunnable;,
        Lco/vine/android/InlineRecorderManager$StartInlineRecording;
    }
.end annotation


# static fields
.field private static final CLICK_LENGTH:J = 0xc8L


# instance fields
.field private mCameraView:Landroid/view/View;

.field private mCanInline:Z

.field private mDownWasInRecordButton:Z

.field private mFinishProgressView:Lco/vine/android/recorder/ProgressView;

.field private mFinishRunnable:Lco/vine/android/InlineRecorderManager$FinishRunnable;

.field private mFragment:Lco/vine/android/ConversationFragment;

.field private mHandler:Landroid/os/Handler;

.field private mIsWaitingForResumeThread:Z

.field private mProcessing:Z

.field private mRecorder:Lco/vine/android/recorder/InlineVineRecorder;

.field private mRecordingButtonContainer:Landroid/view/View;

.field private mRecordingContainer:Landroid/view/View;

.field private mResumeThread:Lco/vine/android/InlineRecorderManager$ResumeThread;

.field private mStartInlineRecording:Ljava/lang/Runnable;

.field private mSwipeUpText:Landroid/widget/TextView;

.field private mTextToggle:Landroid/view/View;

.field private mTopMask:Landroid/view/View;

.field private mVersion:Lco/vine/android/recorder/RecordSessionVersion;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    const/4 v1, 0x0

    .line 59
    invoke-direct {p0, p1}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;)V

    .line 42
    new-instance v0, Lco/vine/android/InlineRecorderManager$StartInlineRecording;

    invoke-direct {v0, p0, v1}, Lco/vine/android/InlineRecorderManager$StartInlineRecording;-><init>(Lco/vine/android/InlineRecorderManager;Lco/vine/android/InlineRecorderManager$1;)V

    iput-object v0, p0, Lco/vine/android/InlineRecorderManager;->mStartInlineRecording:Ljava/lang/Runnable;

    .line 43
    new-instance v0, Lco/vine/android/InlineRecorderManager$FinishRunnable;

    invoke-direct {v0, p0, v1}, Lco/vine/android/InlineRecorderManager$FinishRunnable;-><init>(Lco/vine/android/InlineRecorderManager;Lco/vine/android/InlineRecorderManager$1;)V

    iput-object v0, p0, Lco/vine/android/InlineRecorderManager;->mFinishRunnable:Lco/vine/android/InlineRecorderManager$FinishRunnable;

    .line 60
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    const/4 v1, 0x0

    .line 63
    invoke-direct {p0, p1, p2}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 42
    new-instance v0, Lco/vine/android/InlineRecorderManager$StartInlineRecording;

    invoke-direct {v0, p0, v1}, Lco/vine/android/InlineRecorderManager$StartInlineRecording;-><init>(Lco/vine/android/InlineRecorderManager;Lco/vine/android/InlineRecorderManager$1;)V

    iput-object v0, p0, Lco/vine/android/InlineRecorderManager;->mStartInlineRecording:Ljava/lang/Runnable;

    .line 43
    new-instance v0, Lco/vine/android/InlineRecorderManager$FinishRunnable;

    invoke-direct {v0, p0, v1}, Lco/vine/android/InlineRecorderManager$FinishRunnable;-><init>(Lco/vine/android/InlineRecorderManager;Lco/vine/android/InlineRecorderManager$1;)V

    iput-object v0, p0, Lco/vine/android/InlineRecorderManager;->mFinishRunnable:Lco/vine/android/InlineRecorderManager$FinishRunnable;

    .line 64
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    const/4 v1, 0x0

    .line 67
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 42
    new-instance v0, Lco/vine/android/InlineRecorderManager$StartInlineRecording;

    invoke-direct {v0, p0, v1}, Lco/vine/android/InlineRecorderManager$StartInlineRecording;-><init>(Lco/vine/android/InlineRecorderManager;Lco/vine/android/InlineRecorderManager$1;)V

    iput-object v0, p0, Lco/vine/android/InlineRecorderManager;->mStartInlineRecording:Ljava/lang/Runnable;

    .line 43
    new-instance v0, Lco/vine/android/InlineRecorderManager$FinishRunnable;

    invoke-direct {v0, p0, v1}, Lco/vine/android/InlineRecorderManager$FinishRunnable;-><init>(Lco/vine/android/InlineRecorderManager;Lco/vine/android/InlineRecorderManager$1;)V

    iput-object v0, p0, Lco/vine/android/InlineRecorderManager;->mFinishRunnable:Lco/vine/android/InlineRecorderManager$FinishRunnable;

    .line 68
    return-void
.end method

.method static synthetic access$200(Lco/vine/android/InlineRecorderManager;Z)V
    .locals 0
    .param p0, "x0"    # Lco/vine/android/InlineRecorderManager;
    .param p1, "x1"    # Z

    .prologue
    .line 37
    invoke-direct {p0, p1}, Lco/vine/android/InlineRecorderManager;->toggleRecorder(Z)V

    return-void
.end method

.method static synthetic access$300(Lco/vine/android/InlineRecorderManager;)Lco/vine/android/recorder/ProgressView;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/InlineRecorderManager;

    .prologue
    .line 37
    iget-object v0, p0, Lco/vine/android/InlineRecorderManager;->mFinishProgressView:Lco/vine/android/recorder/ProgressView;

    return-object v0
.end method

.method static synthetic access$400(Lco/vine/android/InlineRecorderManager;)Landroid/view/View;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/InlineRecorderManager;

    .prologue
    .line 37
    iget-object v0, p0, Lco/vine/android/InlineRecorderManager;->mRecordingButtonContainer:Landroid/view/View;

    return-object v0
.end method

.method static synthetic access$500(Lco/vine/android/InlineRecorderManager;)Lco/vine/android/ConversationFragment;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/InlineRecorderManager;

    .prologue
    .line 37
    iget-object v0, p0, Lco/vine/android/InlineRecorderManager;->mFragment:Lco/vine/android/ConversationFragment;

    return-object v0
.end method

.method static synthetic access$600(Lco/vine/android/InlineRecorderManager;)Lco/vine/android/recorder/InlineVineRecorder;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/InlineRecorderManager;

    .prologue
    .line 37
    iget-object v0, p0, Lco/vine/android/InlineRecorderManager;->mRecorder:Lco/vine/android/recorder/InlineVineRecorder;

    return-object v0
.end method

.method static synthetic access$700(Lco/vine/android/InlineRecorderManager;)Lco/vine/android/recorder/RecordingFile;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/InlineRecorderManager;

    .prologue
    .line 37
    invoke-direct {p0}, Lco/vine/android/InlineRecorderManager;->getNewMessageRecordingFile()Lco/vine/android/recorder/RecordingFile;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$800(Lco/vine/android/InlineRecorderManager;)Landroid/view/View;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/InlineRecorderManager;

    .prologue
    .line 37
    iget-object v0, p0, Lco/vine/android/InlineRecorderManager;->mTextToggle:Landroid/view/View;

    return-object v0
.end method

.method static synthetic access$902(Lco/vine/android/InlineRecorderManager;Z)Z
    .locals 0
    .param p0, "x0"    # Lco/vine/android/InlineRecorderManager;
    .param p1, "x1"    # Z

    .prologue
    .line 37
    iput-boolean p1, p0, Lco/vine/android/InlineRecorderManager;->mIsWaitingForResumeThread:Z

    return p1
.end method

.method private getNewMessageRecordingFile()Lco/vine/android/recorder/RecordingFile;
    .locals 8

    .prologue
    .line 103
    :try_start_0
    iget-object v0, p0, Lco/vine/android/InlineRecorderManager;->mVersion:Lco/vine/android/recorder/RecordSessionVersion;

    iget-object v2, p0, Lco/vine/android/InlineRecorderManager;->mFragment:Lco/vine/android/ConversationFragment;

    invoke-virtual {v2}, Lco/vine/android/ConversationFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-virtual {v0, v2}, Lco/vine/android/recorder/RecordSessionVersion;->getManager(Landroid/content/Context;)Lco/vine/android/recorder/RecordSessionManager;

    move-result-object v7

    .line 104
    .local v7, "rsm":Lco/vine/android/recorder/RecordSessionManager;
    invoke-virtual {v7}, Lco/vine/android/recorder/RecordSessionManager;->createFolderForSession()Ljava/io/File;

    move-result-object v1

    .line 105
    .local v1, "folder":Ljava/io/File;
    new-instance v0, Lco/vine/android/recorder/RecordingFile;

    new-instance v2, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;

    iget-object v3, p0, Lco/vine/android/InlineRecorderManager;->mFragment:Lco/vine/android/ConversationFragment;

    invoke-virtual {v3}, Lco/vine/android/ConversationFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    invoke-direct {v2, v3}, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;-><init>(Landroid/content/Context;)V

    iget-object v3, p0, Lco/vine/android/InlineRecorderManager;->mVersion:Lco/vine/android/recorder/RecordSessionVersion;

    invoke-static {v2, v3}, Lco/vine/android/recorder/RecordSession;->newSession(Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;Lco/vine/android/recorder/RecordSessionVersion;)Lco/vine/android/recorder/RecordSession;

    move-result-object v2

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-direct/range {v0 .. v5}, Lco/vine/android/recorder/RecordingFile;-><init>(Ljava/io/File;Lco/vine/android/recorder/RecordSession;ZZZ)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    return-object v0

    .line 108
    .end local v1    # "folder":Ljava/io/File;
    .end local v7    # "rsm":Lco/vine/android/recorder/RecordSessionManager;
    :catch_0
    move-exception v6

    .line 109
    .local v6, "e":Ljava/io/IOException;
    new-instance v0, Ljava/lang/RuntimeException;

    invoke-direct {v0, v6}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v0
.end method

.method private isInCancelZone(F)Z
    .locals 3
    .param p1, "y"    # F

    .prologue
    .line 226
    iget-object v1, p0, Lco/vine/android/InlineRecorderManager;->mRecordingButtonContainer:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    .line 227
    .local v0, "buttonParent":Landroid/view/ViewGroup;
    invoke-virtual {p0}, Lco/vine/android/InlineRecorderManager;->getMeasuredHeight()I

    move-result v1

    invoke-virtual {v0}, Landroid/view/ViewGroup;->getHeight()I

    move-result v2

    mul-int/lit8 v2, v2, 0x2

    sub-int/2addr v1, v2

    int-to-float v1, v1

    cmpg-float v1, p1, v1

    if-gez v1, :cond_0

    const/4 v1, 0x1

    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method private isInRecordButton(Landroid/view/MotionEvent;)Z
    .locals 4
    .param p1, "event"    # Landroid/view/MotionEvent;

    .prologue
    .line 124
    iget-object v2, p0, Lco/vine/android/InlineRecorderManager;->mFragment:Lco/vine/android/ConversationFragment;

    if-eqz v2, :cond_0

    iget-object v2, p0, Lco/vine/android/InlineRecorderManager;->mFragment:Lco/vine/android/ConversationFragment;

    invoke-virtual {v2}, Lco/vine/android/ConversationFragment;->isInTextInputMode()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 125
    :cond_0
    const/4 v2, 0x0

    .line 132
    :goto_0
    return v2

    .line 128
    :cond_1
    iget-object v2, p0, Lco/vine/android/InlineRecorderManager;->mRecordingButtonContainer:Landroid/view/View;

    invoke-virtual {v2}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    .line 129
    .local v0, "buttonParent":Landroid/view/ViewGroup;
    new-instance v1, Landroid/graphics/Rect;

    invoke-direct {v1}, Landroid/graphics/Rect;-><init>()V

    .line 130
    .local v1, "hitRect":Landroid/graphics/Rect;
    iget-object v2, p0, Lco/vine/android/InlineRecorderManager;->mRecordingButtonContainer:Landroid/view/View;

    invoke-virtual {v2, v1}, Landroid/view/View;->getHitRect(Landroid/graphics/Rect;)V

    .line 131
    invoke-virtual {v0}, Landroid/view/ViewGroup;->getLeft()I

    move-result v2

    invoke-virtual {v0}, Landroid/view/ViewGroup;->getTop()I

    move-result v3

    invoke-virtual {v1, v2, v3}, Landroid/graphics/Rect;->offset(II)V

    .line 132
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v2

    float-to-int v2, v2

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v3

    float-to-int v3, v3

    invoke-virtual {v1, v2, v3}, Landroid/graphics/Rect;->contains(II)Z

    move-result v2

    goto :goto_0
.end method

.method private toggleRecorder(Z)V
    .locals 4
    .param p1, "show"    # Z

    .prologue
    const/4 v3, 0x0

    .line 257
    iget-boolean v0, p0, Lco/vine/android/InlineRecorderManager;->mCanInline:Z

    if-eqz v0, :cond_0

    .line 258
    if-eqz p1, :cond_1

    .line 262
    iget-object v0, p0, Lco/vine/android/InlineRecorderManager;->mCameraView:Landroid/view/View;

    invoke-virtual {v0, v3}, Landroid/view/View;->setVisibility(I)V

    .line 263
    invoke-static {}, Ljava/lang/System;->nanoTime()J

    move-result-wide v0

    sput-wide v0, Lco/vine/android/recorder/InlineVineRecorder;->startnanos:J

    .line 264
    iget-object v0, p0, Lco/vine/android/InlineRecorderManager;->mRecordingContainer:Landroid/view/View;

    const v1, 0x3c23d70a    # 0.01f

    invoke-virtual {v0, v1}, Landroid/view/View;->setAlpha(F)V

    .line 265
    iget-object v0, p0, Lco/vine/android/InlineRecorderManager;->mRecordingContainer:Landroid/view/View;

    invoke-virtual {v0, v3}, Landroid/view/View;->setVisibility(I)V

    .line 266
    iget-object v0, p0, Lco/vine/android/InlineRecorderManager;->mRecordingContainer:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    const/high16 v1, 0x3f800000    # 1.0f

    invoke-virtual {v0, v1}, Landroid/view/ViewPropertyAnimator;->alpha(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    const-wide/16 v1, 0xfa

    invoke-virtual {v0, v1, v2}, Landroid/view/ViewPropertyAnimator;->setDuration(J)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/ViewPropertyAnimator;->start()V

    .line 267
    iget-object v0, p0, Lco/vine/android/InlineRecorderManager;->mTopMask:Landroid/view/View;

    invoke-virtual {v0, v3}, Landroid/view/View;->setVisibility(I)V

    .line 268
    iget-object v0, p0, Lco/vine/android/InlineRecorderManager;->mTextToggle:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 269
    iget-object v0, p0, Lco/vine/android/InlineRecorderManager;->mTextToggle:Landroid/view/View;

    invoke-virtual {v0, v3}, Landroid/view/View;->setEnabled(Z)V

    .line 270
    iget-object v0, p0, Lco/vine/android/InlineRecorderManager;->mRecorder:Lco/vine/android/recorder/InlineVineRecorder;

    const-string v1, "start"

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Lco/vine/android/recorder/InlineVineRecorder;->onResume(Ljava/lang/String;Z)V

    .line 271
    iget-object v0, p0, Lco/vine/android/InlineRecorderManager;->mFragment:Lco/vine/android/ConversationFragment;

    invoke-virtual {v0}, Lco/vine/android/ConversationFragment;->onRecorderShown()V

    .line 278
    :cond_0
    :goto_0
    return-void

    .line 273
    :cond_1
    iget-object v0, p0, Lco/vine/android/InlineRecorderManager;->mRecordingContainer:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/ViewPropertyAnimator;->alpha(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    new-instance v1, Lco/vine/android/recorder/ViewGoneAnimationListener;

    iget-object v2, p0, Lco/vine/android/InlineRecorderManager;->mRecordingContainer:Landroid/view/View;

    invoke-direct {v1, v2}, Lco/vine/android/recorder/ViewGoneAnimationListener;-><init>(Landroid/view/View;)V

    invoke-virtual {v0, v1}, Landroid/view/ViewPropertyAnimator;->setListener(Landroid/animation/Animator$AnimatorListener;)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/ViewPropertyAnimator;->start()V

    .line 274
    iget-object v0, p0, Lco/vine/android/InlineRecorderManager;->mFragment:Lco/vine/android/ConversationFragment;

    invoke-virtual {v0}, Lco/vine/android/ConversationFragment;->onRecorderHidden()V

    .line 275
    iget-object v0, p0, Lco/vine/android/InlineRecorderManager;->mRecordingButtonContainer:Landroid/view/View;

    invoke-virtual {v0, v3}, Landroid/view/View;->setVisibility(I)V

    goto :goto_0
.end method

.method private waitForResume()V
    .locals 2

    .prologue
    .line 281
    iget-boolean v1, p0, Lco/vine/android/InlineRecorderManager;->mIsWaitingForResumeThread:Z

    if-eqz v1, :cond_0

    .line 283
    :try_start_0
    iget-object v1, p0, Lco/vine/android/InlineRecorderManager;->mResumeThread:Lco/vine/android/InlineRecorderManager$ResumeThread;

    invoke-virtual {v1}, Lco/vine/android/InlineRecorderManager$ResumeThread;->join()V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 288
    :cond_0
    :goto_0
    return-void

    .line 284
    :catch_0
    move-exception v0

    .line 285
    .local v0, "e":Ljava/lang/InterruptedException;
    const-string v1, "You can\'t interrupt this."

    invoke-static {v1}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;)V

    goto :goto_0
.end method


# virtual methods
.method getRecorder()Lco/vine/android/recorder/InlineVineRecorder;
    .locals 1

    .prologue
    .line 305
    iget-object v0, p0, Lco/vine/android/InlineRecorderManager;->mRecorder:Lco/vine/android/recorder/InlineVineRecorder;

    return-object v0
.end method

.method public init(Lco/vine/android/ConversationFragment;Lco/vine/android/ConversationActivity;Lco/vine/android/recorder/RecordSessionVersion;)V
    .locals 19
    .param p1, "fragment"    # Lco/vine/android/ConversationFragment;
    .param p2, "activity"    # Lco/vine/android/ConversationActivity;
    .param p3, "version"    # Lco/vine/android/recorder/RecordSessionVersion;

    .prologue
    .line 84
    move-object/from16 v0, p1

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/InlineRecorderManager;->mFragment:Lco/vine/android/ConversationFragment;

    .line 85
    invoke-static/range {p2 .. p2}, Lco/vine/android/util/Util;->isCapableOfInline(Landroid/content/Context;)Z

    move-result v2

    move-object/from16 v0, p0

    iput-boolean v2, v0, Lco/vine/android/InlineRecorderManager;->mCanInline:Z

    .line 86
    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/InlineRecorderManager;->mFragment:Lco/vine/android/ConversationFragment;

    invoke-virtual {v2}, Lco/vine/android/ConversationFragment;->getView()Landroid/view/View;

    move-result-object v18

    .line 87
    .local v18, "root":Landroid/view/View;
    const v2, 0x7f0a0098

    move-object/from16 v0, v18

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    move-object/from16 v0, p0

    iput-object v2, v0, Lco/vine/android/InlineRecorderManager;->mTextToggle:Landroid/view/View;

    .line 88
    const v2, 0x7f0a00a2

    move-object/from16 v0, v18

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    move-object/from16 v0, p0

    iput-object v2, v0, Lco/vine/android/InlineRecorderManager;->mSwipeUpText:Landroid/widget/TextView;

    .line 89
    move-object/from16 v0, p3

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/InlineRecorderManager;->mVersion:Lco/vine/android/recorder/RecordSessionVersion;

    .line 90
    move-object/from16 v0, p0

    iget-boolean v2, v0, Lco/vine/android/InlineRecorderManager;->mCanInline:Z

    if-eqz v2, :cond_0

    .line 91
    new-instance v2, Lco/vine/android/recorder/InlineVineRecorder;

    invoke-static/range {p2 .. p2}, Lco/vine/android/util/SystemUtil;->getDisplaySize(Landroid/app/Activity;)Landroid/graphics/Point;

    move-result-object v4

    invoke-virtual/range {p2 .. p2}, Lco/vine/android/ConversationActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v5, 0x7f0b008c

    invoke-virtual {v3, v5}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v7

    const v8, 0x7f0a00a1

    const v9, 0x7f0a00a7

    const v10, 0x7f0a009f

    const v11, 0x7f0a00a0

    const v12, 0x7f0a00a3

    const v13, 0x7f0e0054

    const v14, 0x7f0e0167

    const v15, 0x7f0a0096

    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/InlineRecorderManager;->mFragment:Lco/vine/android/ConversationFragment;

    const v5, 0x7f0e0256

    invoke-virtual {v3, v5}, Lco/vine/android/ConversationFragment;->getString(I)Ljava/lang/String;

    move-result-object v16

    const/4 v3, 0x4

    new-array v0, v3, [Ljava/lang/CharSequence;

    move-object/from16 v17, v0

    const/4 v3, 0x0

    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/InlineRecorderManager;->mFragment:Lco/vine/android/ConversationFragment;

    const v6, 0x7f0e0106

    invoke-virtual {v5, v6}, Lco/vine/android/ConversationFragment;->getText(I)Ljava/lang/CharSequence;

    move-result-object v5

    aput-object v5, v17, v3

    const/4 v3, 0x1

    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/InlineRecorderManager;->mFragment:Lco/vine/android/ConversationFragment;

    const v6, 0x7f0e00f6

    invoke-virtual {v5, v6}, Lco/vine/android/ConversationFragment;->getText(I)Ljava/lang/CharSequence;

    move-result-object v5

    aput-object v5, v17, v3

    const/4 v3, 0x2

    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/InlineRecorderManager;->mFragment:Lco/vine/android/ConversationFragment;

    const v6, 0x7f0e00f7

    invoke-virtual {v5, v6}, Lco/vine/android/ConversationFragment;->getText(I)Ljava/lang/CharSequence;

    move-result-object v5

    aput-object v5, v17, v3

    const/4 v3, 0x3

    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/InlineRecorderManager;->mFragment:Lco/vine/android/ConversationFragment;

    const v6, 0x7f0e00f8

    invoke-virtual {v5, v6}, Lco/vine/android/ConversationFragment;->getText(I)Ljava/lang/CharSequence;

    move-result-object v5

    aput-object v5, v17, v3

    move-object/from16 v3, p3

    move-object/from16 v5, p2

    move-object/from16 v6, p0

    invoke-direct/range {v2 .. v17}, Lco/vine/android/recorder/InlineVineRecorder;-><init>(Lco/vine/android/recorder/RecordSessionVersion;Landroid/graphics/Point;Landroid/app/Activity;Lco/vine/android/recorder/InlineVineRecorder$ProcessingListener;IIIIIIIIILjava/lang/String;[Ljava/lang/CharSequence;)V

    move-object/from16 v0, p0

    iput-object v2, v0, Lco/vine/android/InlineRecorderManager;->mRecorder:Lco/vine/android/recorder/InlineVineRecorder;

    .line 99
    :cond_0
    return-void
.end method

.method public initDisabled(Lco/vine/android/ConversationFragment;)V
    .locals 0
    .param p1, "fragment"    # Lco/vine/android/ConversationFragment;

    .prologue
    .line 80
    iput-object p1, p0, Lco/vine/android/InlineRecorderManager;->mFragment:Lco/vine/android/ConversationFragment;

    .line 81
    return-void
.end method

.method protected onAttachedToWindow()V
    .locals 1

    .prologue
    .line 115
    invoke-virtual {p0}, Lco/vine/android/InlineRecorderManager;->getHandler()Landroid/os/Handler;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/InlineRecorderManager;->mHandler:Landroid/os/Handler;

    .line 116
    return-void
.end method

.method protected onFinishInflate()V
    .locals 1

    .prologue
    .line 71
    invoke-super {p0}, Landroid/widget/RelativeLayout;->onFinishInflate()V

    .line 72
    const v0, 0x7f0a00a9

    invoke-virtual {p0, v0}, Lco/vine/android/InlineRecorderManager;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/InlineRecorderManager;->mRecordingButtonContainer:Landroid/view/View;

    .line 73
    const v0, 0x7f0a009e

    invoke-virtual {p0, v0}, Lco/vine/android/InlineRecorderManager;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/InlineRecorderManager;->mRecordingContainer:Landroid/view/View;

    .line 74
    const v0, 0x7f0a00a7

    invoke-virtual {p0, v0}, Lco/vine/android/InlineRecorderManager;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lco/vine/android/recorder/ProgressView;

    iput-object v0, p0, Lco/vine/android/InlineRecorderManager;->mFinishProgressView:Lco/vine/android/recorder/ProgressView;

    .line 75
    const v0, 0x7f0a00a0

    invoke-virtual {p0, v0}, Lco/vine/android/InlineRecorderManager;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/InlineRecorderManager;->mTopMask:Landroid/view/View;

    .line 76
    const v0, 0x7f0a009f

    invoke-virtual {p0, v0}, Lco/vine/android/InlineRecorderManager;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/InlineRecorderManager;->mCameraView:Landroid/view/View;

    .line 77
    return-void
.end method

.method public onInterceptTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 1
    .param p1, "event"    # Landroid/view/MotionEvent;

    .prologue
    .line 120
    invoke-direct {p0, p1}, Lco/vine/android/InlineRecorderManager;->isInRecordButton(Landroid/view/MotionEvent;)Z

    move-result v0

    return v0
.end method

.method public onPaused()V
    .locals 2

    .prologue
    .line 357
    iget-boolean v0, p0, Lco/vine/android/InlineRecorderManager;->mCanInline:Z

    if-eqz v0, :cond_0

    .line 358
    invoke-direct {p0}, Lco/vine/android/InlineRecorderManager;->waitForResume()V

    .line 359
    iget-object v0, p0, Lco/vine/android/InlineRecorderManager;->mRecorder:Lco/vine/android/recorder/InlineVineRecorder;

    if-eqz v0, :cond_0

    .line 360
    iget-object v0, p0, Lco/vine/android/InlineRecorderManager;->mRecorder:Lco/vine/android/recorder/InlineVineRecorder;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lco/vine/android/recorder/InlineVineRecorder;->setStarted(Z)V

    .line 361
    iget-object v0, p0, Lco/vine/android/InlineRecorderManager;->mRecorder:Lco/vine/android/recorder/InlineVineRecorder;

    invoke-virtual {v0}, Lco/vine/android/recorder/InlineVineRecorder;->onUiPaused()V

    .line 364
    :cond_0
    return-void
.end method

.method public onProcessingFinish()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 240
    iput-boolean v2, p0, Lco/vine/android/InlineRecorderManager;->mProcessing:Z

    .line 241
    iget-object v0, p0, Lco/vine/android/InlineRecorderManager;->mRecordingButtonContainer:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setAlpha(F)V

    .line 242
    iget-object v0, p0, Lco/vine/android/InlineRecorderManager;->mRecordingButtonContainer:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    .line 243
    iget-object v0, p0, Lco/vine/android/InlineRecorderManager;->mRecordingButtonContainer:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    const/high16 v1, 0x3f800000    # 1.0f

    invoke-virtual {v0, v1}, Landroid/view/ViewPropertyAnimator;->alpha(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/ViewPropertyAnimator;->start()V

    .line 244
    return-void
.end method

.method public onProcessingStart()V
    .locals 3

    .prologue
    .line 232
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lco/vine/android/InlineRecorderManager;->toggleRecorder(Z)V

    .line 233
    const/4 v0, 0x1

    iput-boolean v0, p0, Lco/vine/android/InlineRecorderManager;->mProcessing:Z

    .line 234
    iget-object v0, p0, Lco/vine/android/InlineRecorderManager;->mRecordingButtonContainer:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/ViewPropertyAnimator;->alpha(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    new-instance v1, Lco/vine/android/recorder/ViewGoneAnimationListener;

    iget-object v2, p0, Lco/vine/android/InlineRecorderManager;->mRecordingButtonContainer:Landroid/view/View;

    invoke-direct {v1, v2}, Lco/vine/android/recorder/ViewGoneAnimationListener;-><init>(Landroid/view/View;)V

    invoke-virtual {v0, v1}, Landroid/view/ViewPropertyAnimator;->setListener(Landroid/animation/Animator$AnimatorListener;)Landroid/view/ViewPropertyAnimator;

    .line 236
    return-void
.end method

.method public onResume()V
    .locals 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v4, 0x1

    .line 309
    iget-boolean v1, p0, Lco/vine/android/InlineRecorderManager;->mCanInline:Z

    if-eqz v1, :cond_0

    .line 311
    :try_start_0
    new-instance v1, Lco/vine/android/InlineRecorderManager$ResumeThread;

    invoke-direct {v1, p0}, Lco/vine/android/InlineRecorderManager$ResumeThread;-><init>(Lco/vine/android/InlineRecorderManager;)V

    iput-object v1, p0, Lco/vine/android/InlineRecorderManager;->mResumeThread:Lco/vine/android/InlineRecorderManager$ResumeThread;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 318
    iget-object v1, p0, Lco/vine/android/InlineRecorderManager;->mRecorder:Lco/vine/android/recorder/InlineVineRecorder;

    iget-object v2, p0, Lco/vine/android/InlineRecorderManager;->mCameraView:Landroid/view/View;

    invoke-virtual {v1, v2}, Lco/vine/android/recorder/InlineVineRecorder;->setCameraView(Landroid/view/View;)V

    .line 319
    iget-object v1, p0, Lco/vine/android/InlineRecorderManager;->mRecorder:Lco/vine/android/recorder/InlineVineRecorder;

    iget-object v2, p0, Lco/vine/android/InlineRecorderManager;->mFragment:Lco/vine/android/ConversationFragment;

    invoke-virtual {v2}, Lco/vine/android/ConversationFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    iget-object v3, p0, Lco/vine/android/InlineRecorderManager;->mFinishRunnable:Lco/vine/android/InlineRecorderManager$FinishRunnable;

    invoke-virtual {v1, v2, v3, v4}, Lco/vine/android/recorder/InlineVineRecorder;->onUiResumed(Landroid/app/Activity;Ljava/lang/Runnable;Z)V

    .line 320
    iput-boolean v4, p0, Lco/vine/android/InlineRecorderManager;->mIsWaitingForResumeThread:Z

    .line 321
    iget-object v1, p0, Lco/vine/android/InlineRecorderManager;->mResumeThread:Lco/vine/android/InlineRecorderManager$ResumeThread;

    invoke-virtual {v1}, Lco/vine/android/InlineRecorderManager$ResumeThread;->start()V

    .line 323
    :cond_0
    return-void

    .line 312
    :catch_0
    move-exception v0

    .line 313
    .local v0, "e":Ljava/io/IOException;
    const/4 v1, 0x0

    iput-boolean v1, p0, Lco/vine/android/InlineRecorderManager;->mCanInline:Z

    .line 314
    iget-object v1, p0, Lco/vine/android/InlineRecorderManager;->mRecorder:Lco/vine/android/recorder/InlineVineRecorder;

    invoke-virtual {v1}, Lco/vine/android/recorder/InlineVineRecorder;->release()Z

    .line 315
    const/4 v1, 0x0

    iput-object v1, p0, Lco/vine/android/InlineRecorderManager;->mRecorder:Lco/vine/android/recorder/InlineVineRecorder;

    .line 316
    throw v0
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 9
    .param p1, "event"    # Landroid/view/MotionEvent;
        .annotation build Lorg/jetbrains/annotations/NotNull;
        .end annotation
    .end param

    .prologue
    const-wide/16 v7, 0xc8

    const v3, 0x7f090081

    const/4 v6, 0x0

    const/4 v1, 0x0

    const/4 v0, 0x1

    .line 139
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v2

    packed-switch v2, :pswitch_data_0

    :cond_0
    move v0, v1

    .line 222
    :cond_1
    :goto_0
    return v0

    .line 141
    :pswitch_0
    iget-boolean v2, p0, Lco/vine/android/InlineRecorderManager;->mProcessing:Z

    if-nez v2, :cond_2

    invoke-direct {p0, p1}, Lco/vine/android/InlineRecorderManager;->isInRecordButton(Landroid/view/MotionEvent;)Z

    move-result v2

    if-eqz v2, :cond_2

    iget-object v2, p0, Lco/vine/android/InlineRecorderManager;->mRecordingContainer:Landroid/view/View;

    invoke-virtual {v2}, Landroid/view/View;->getVisibility()I

    move-result v2

    if-eqz v2, :cond_2

    .line 142
    iput-boolean v0, p0, Lco/vine/android/InlineRecorderManager;->mDownWasInRecordButton:Z

    .line 143
    iget-object v1, p0, Lco/vine/android/InlineRecorderManager;->mRecorder:Lco/vine/android/recorder/InlineVineRecorder;

    if-eqz v1, :cond_1

    .line 146
    iget-object v1, p0, Lco/vine/android/InlineRecorderManager;->mSwipeUpText:Landroid/widget/TextView;

    invoke-virtual {p0}, Lco/vine/android/InlineRecorderManager;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getColor(I)I

    move-result v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setTextColor(I)V

    .line 147
    iget-object v1, p0, Lco/vine/android/InlineRecorderManager;->mRecorder:Lco/vine/android/recorder/InlineVineRecorder;

    invoke-virtual {v1, v0}, Lco/vine/android/recorder/InlineVineRecorder;->setStarted(Z)V

    .line 148
    invoke-direct {p0}, Lco/vine/android/InlineRecorderManager;->waitForResume()V

    .line 149
    iget-object v1, p0, Lco/vine/android/InlineRecorderManager;->mRecorder:Lco/vine/android/recorder/InlineVineRecorder;

    invoke-virtual {v1}, Lco/vine/android/recorder/InlineVineRecorder;->openCamera()V

    .line 150
    iget-object v1, p0, Lco/vine/android/InlineRecorderManager;->mHandler:Landroid/os/Handler;

    iget-object v2, p0, Lco/vine/android/InlineRecorderManager;->mStartInlineRecording:Ljava/lang/Runnable;

    invoke-virtual {v1, v2, v7, v8}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    goto :goto_0

    .line 152
    :cond_2
    iget-object v2, p0, Lco/vine/android/InlineRecorderManager;->mRecordingContainer:Landroid/view/View;

    invoke-virtual {v2}, Landroid/view/View;->getVisibility()I

    move-result v2

    if-nez v2, :cond_3

    .line 153
    iput-boolean v1, p0, Lco/vine/android/InlineRecorderManager;->mDownWasInRecordButton:Z

    .line 154
    iget-object v2, p0, Lco/vine/android/InlineRecorderManager;->mRecorder:Lco/vine/android/recorder/InlineVineRecorder;

    invoke-virtual {v2, v1}, Lco/vine/android/recorder/InlineVineRecorder;->setStarted(Z)V

    goto :goto_0

    :cond_3
    move v0, v1

    .line 157
    goto :goto_0

    .line 161
    :pswitch_1
    iget-object v0, p0, Lco/vine/android/InlineRecorderManager;->mRecorder:Lco/vine/android/recorder/InlineVineRecorder;

    if-nez v0, :cond_4

    .line 162
    iget-boolean v0, p0, Lco/vine/android/InlineRecorderManager;->mDownWasInRecordButton:Z

    goto :goto_0

    .line 164
    :cond_4
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v0

    invoke-direct {p0, v0}, Lco/vine/android/InlineRecorderManager;->isInCancelZone(F)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 165
    iget-object v0, p0, Lco/vine/android/InlineRecorderManager;->mSwipeUpText:Landroid/widget/TextView;

    iget-object v1, p0, Lco/vine/android/InlineRecorderManager;->mFragment:Lco/vine/android/ConversationFragment;

    invoke-virtual {v1}, Lco/vine/android/ConversationFragment;->getMyColor()I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setTextColor(I)V

    .line 170
    :goto_1
    iget-boolean v0, p0, Lco/vine/android/InlineRecorderManager;->mDownWasInRecordButton:Z

    goto :goto_0

    .line 167
    :cond_5
    iget-object v0, p0, Lco/vine/android/InlineRecorderManager;->mSwipeUpText:Landroid/widget/TextView;

    invoke-virtual {p0}, Lco/vine/android/InlineRecorderManager;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v3}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setTextColor(I)V

    goto :goto_1

    .line 173
    :pswitch_2
    iget-boolean v2, p0, Lco/vine/android/InlineRecorderManager;->mDownWasInRecordButton:Z

    if-eqz v2, :cond_6

    iget-object v2, p0, Lco/vine/android/InlineRecorderManager;->mRecorder:Lco/vine/android/recorder/InlineVineRecorder;

    if-nez v2, :cond_6

    .line 174
    iput-boolean v1, p0, Lco/vine/android/InlineRecorderManager;->mDownWasInRecordButton:Z

    .line 175
    iget-object v1, p0, Lco/vine/android/InlineRecorderManager;->mFragment:Lco/vine/android/ConversationFragment;

    invoke-virtual {v1}, Lco/vine/android/ConversationFragment;->launchFullRecord()V

    goto/16 :goto_0

    .line 178
    :cond_6
    invoke-direct {p0}, Lco/vine/android/InlineRecorderManager;->waitForResume()V

    .line 179
    iget-object v2, p0, Lco/vine/android/InlineRecorderManager;->mHandler:Landroid/os/Handler;

    iget-object v3, p0, Lco/vine/android/InlineRecorderManager;->mStartInlineRecording:Ljava/lang/Runnable;

    invoke-virtual {v2, v3}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 180
    iget-boolean v2, p0, Lco/vine/android/InlineRecorderManager;->mDownWasInRecordButton:Z

    if-eqz v2, :cond_7

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getEventTime()J

    move-result-wide v2

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getDownTime()J

    move-result-wide v4

    sub-long/2addr v2, v4

    cmp-long v2, v2, v7

    if-gtz v2, :cond_7

    iget-object v2, p0, Lco/vine/android/InlineRecorderManager;->mRecordingContainer:Landroid/view/View;

    invoke-virtual {v2}, Landroid/view/View;->getVisibility()I

    move-result v2

    if-eqz v2, :cond_7

    .line 182
    iput-boolean v1, p0, Lco/vine/android/InlineRecorderManager;->mDownWasInRecordButton:Z

    .line 183
    iget-object v2, p0, Lco/vine/android/InlineRecorderManager;->mRecorder:Lco/vine/android/recorder/InlineVineRecorder;

    invoke-virtual {v2, v1}, Lco/vine/android/recorder/InlineVineRecorder;->setStarted(Z)V

    .line 184
    iget-object v1, p0, Lco/vine/android/InlineRecorderManager;->mFragment:Lco/vine/android/ConversationFragment;

    invoke-virtual {v1}, Lco/vine/android/ConversationFragment;->launchFullRecord()V

    goto/16 :goto_0

    .line 186
    :cond_7
    iget-object v2, p0, Lco/vine/android/InlineRecorderManager;->mRecordingContainer:Landroid/view/View;

    invoke-virtual {v2}, Landroid/view/View;->getVisibility()I

    move-result v2

    if-nez v2, :cond_0

    iget-boolean v2, p0, Lco/vine/android/InlineRecorderManager;->mDownWasInRecordButton:Z

    if-eqz v2, :cond_0

    iget-object v2, p0, Lco/vine/android/InlineRecorderManager;->mRecorder:Lco/vine/android/recorder/InlineVineRecorder;

    invoke-virtual {v2}, Lco/vine/android/recorder/InlineVineRecorder;->isFinished()Z

    move-result v2

    if-nez v2, :cond_0

    .line 188
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v2

    invoke-direct {p0, v2}, Lco/vine/android/InlineRecorderManager;->isInCancelZone(F)Z

    move-result v2

    if-eqz v2, :cond_9

    .line 189
    iget-object v2, p0, Lco/vine/android/InlineRecorderManager;->mRecorder:Lco/vine/android/recorder/InlineVineRecorder;

    invoke-virtual {v2}, Lco/vine/android/recorder/InlineVineRecorder;->isRecordingSegment()Z

    move-result v2

    if-eqz v2, :cond_8

    .line 190
    iget-object v2, p0, Lco/vine/android/InlineRecorderManager;->mRecorder:Lco/vine/android/recorder/InlineVineRecorder;

    invoke-virtual {v2, v0}, Lco/vine/android/recorder/InlineVineRecorder;->stopRecording(Z)V

    .line 194
    :goto_2
    iget-object v2, p0, Lco/vine/android/InlineRecorderManager;->mRecorder:Lco/vine/android/recorder/InlineVineRecorder;

    const-string v3, "inline action up."

    invoke-virtual {v2, v3}, Lco/vine/android/recorder/InlineVineRecorder;->deleteCurrentDraftFolder(Ljava/lang/String;)Z

    .line 195
    iget-object v2, p0, Lco/vine/android/InlineRecorderManager;->mRecorder:Lco/vine/android/recorder/InlineVineRecorder;

    const-string v3, "Inline record"

    invoke-direct {p0}, Lco/vine/android/InlineRecorderManager;->getNewMessageRecordingFile()Lco/vine/android/recorder/RecordingFile;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Lco/vine/android/recorder/InlineVineRecorder;->swapSession(Ljava/lang/String;Lco/vine/android/recorder/RecordingFile;)Lco/vine/android/recorder/RecordingFile;

    .line 196
    invoke-direct {p0, v1}, Lco/vine/android/InlineRecorderManager;->toggleRecorder(Z)V

    .line 197
    iget-object v2, p0, Lco/vine/android/InlineRecorderManager;->mTextToggle:Landroid/view/View;

    invoke-virtual {v2, v0}, Landroid/view/View;->setEnabled(Z)V

    .line 198
    iget-object v2, p0, Lco/vine/android/InlineRecorderManager;->mFinishProgressView:Lco/vine/android/recorder/ProgressView;

    invoke-virtual {v2}, Lco/vine/android/recorder/ProgressView;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v2

    invoke-virtual {v2, v6}, Landroid/view/ViewPropertyAnimator;->alpha(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v2

    new-instance v3, Lco/vine/android/recorder/ViewGoneAnimationListener;

    iget-object v4, p0, Lco/vine/android/InlineRecorderManager;->mFinishProgressView:Lco/vine/android/recorder/ProgressView;

    invoke-direct {v3, v4}, Lco/vine/android/recorder/ViewGoneAnimationListener;-><init>(Landroid/view/View;)V

    invoke-virtual {v2, v3}, Landroid/view/ViewPropertyAnimator;->setListener(Landroid/animation/Animator$AnimatorListener;)Landroid/view/ViewPropertyAnimator;

    move-result-object v2

    invoke-virtual {v2}, Landroid/view/ViewPropertyAnimator;->start()V

    .line 216
    :goto_3
    iget-object v2, p0, Lco/vine/android/InlineRecorderManager;->mTextToggle:Landroid/view/View;

    invoke-virtual {v2, v1}, Landroid/view/View;->setVisibility(I)V

    goto/16 :goto_0

    .line 192
    :cond_8
    iget-object v2, p0, Lco/vine/android/InlineRecorderManager;->mRecorder:Lco/vine/android/recorder/InlineVineRecorder;

    invoke-virtual {v2}, Lco/vine/android/recorder/InlineVineRecorder;->cancelStartCallback()V

    goto :goto_2

    .line 201
    :cond_9
    iget-object v2, p0, Lco/vine/android/InlineRecorderManager;->mRecorder:Lco/vine/android/recorder/InlineVineRecorder;

    invoke-virtual {v2}, Lco/vine/android/recorder/InlineVineRecorder;->isRecordingSegment()Z

    move-result v2

    if-eqz v2, :cond_a

    .line 202
    iget-object v2, p0, Lco/vine/android/InlineRecorderManager;->mRecorder:Lco/vine/android/recorder/InlineVineRecorder;

    invoke-virtual {v2, v1}, Lco/vine/android/recorder/InlineVineRecorder;->stopRecording(Z)V

    .line 203
    iget-object v2, p0, Lco/vine/android/InlineRecorderManager;->mRecorder:Lco/vine/android/recorder/InlineVineRecorder;

    invoke-virtual {v2}, Lco/vine/android/recorder/InlineVineRecorder;->onFinishPressed()V

    goto :goto_3

    .line 205
    :cond_a
    iget-object v2, p0, Lco/vine/android/InlineRecorderManager;->mRecorder:Lco/vine/android/recorder/InlineVineRecorder;

    invoke-virtual {v2, v0}, Lco/vine/android/recorder/InlineVineRecorder;->stopRecording(Z)V

    .line 206
    iget-object v2, p0, Lco/vine/android/InlineRecorderManager;->mRecorder:Lco/vine/android/recorder/InlineVineRecorder;

    invoke-virtual {v2}, Lco/vine/android/recorder/InlineVineRecorder;->hasSessionFile()Z

    move-result v2

    if-eqz v2, :cond_b

    .line 207
    iget-object v2, p0, Lco/vine/android/InlineRecorderManager;->mRecorder:Lco/vine/android/recorder/InlineVineRecorder;

    const-string v3, "inline action up."

    invoke-virtual {v2, v3}, Lco/vine/android/recorder/InlineVineRecorder;->deleteCurrentDraftFolder(Ljava/lang/String;)Z

    .line 209
    :cond_b
    iget-object v2, p0, Lco/vine/android/InlineRecorderManager;->mRecorder:Lco/vine/android/recorder/InlineVineRecorder;

    const-string v3, "Inline record"

    invoke-direct {p0}, Lco/vine/android/InlineRecorderManager;->getNewMessageRecordingFile()Lco/vine/android/recorder/RecordingFile;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Lco/vine/android/recorder/InlineVineRecorder;->swapSession(Ljava/lang/String;Lco/vine/android/recorder/RecordingFile;)Lco/vine/android/recorder/RecordingFile;

    .line 210
    invoke-direct {p0, v1}, Lco/vine/android/InlineRecorderManager;->toggleRecorder(Z)V

    .line 211
    iget-object v2, p0, Lco/vine/android/InlineRecorderManager;->mTextToggle:Landroid/view/View;

    invoke-virtual {v2, v0}, Landroid/view/View;->setEnabled(Z)V

    .line 212
    iget-object v2, p0, Lco/vine/android/InlineRecorderManager;->mFinishProgressView:Lco/vine/android/recorder/ProgressView;

    invoke-virtual {v2}, Lco/vine/android/recorder/ProgressView;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v2

    invoke-virtual {v2, v6}, Landroid/view/ViewPropertyAnimator;->alpha(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v2

    new-instance v3, Lco/vine/android/recorder/ViewGoneAnimationListener;

    iget-object v4, p0, Lco/vine/android/InlineRecorderManager;->mFinishProgressView:Lco/vine/android/recorder/ProgressView;

    invoke-direct {v3, v4}, Lco/vine/android/recorder/ViewGoneAnimationListener;-><init>(Landroid/view/View;)V

    invoke-virtual {v2, v3}, Landroid/view/ViewPropertyAnimator;->setListener(Landroid/animation/Animator$AnimatorListener;)Landroid/view/ViewPropertyAnimator;

    move-result-object v2

    invoke-virtual {v2}, Landroid/view/ViewPropertyAnimator;->start()V

    goto :goto_3

    .line 139
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_2
        :pswitch_1
    .end packed-switch
.end method

.method public release()V
    .locals 4

    .prologue
    .line 367
    iget-boolean v0, p0, Lco/vine/android/InlineRecorderManager;->mCanInline:Z

    if-eqz v0, :cond_0

    .line 368
    invoke-direct {p0}, Lco/vine/android/InlineRecorderManager;->waitForResume()V

    .line 369
    iget-object v0, p0, Lco/vine/android/InlineRecorderManager;->mRecorder:Lco/vine/android/recorder/InlineVineRecorder;

    const-string v1, "release"

    const/4 v2, 0x0

    const/4 v3, 0x1

    invoke-virtual {v0, v1, v2, v3}, Lco/vine/android/recorder/InlineVineRecorder;->stopAndDiscardChanges(Ljava/lang/String;Ljava/lang/Runnable;Z)V

    .line 370
    iget-object v0, p0, Lco/vine/android/InlineRecorderManager;->mRecorder:Lco/vine/android/recorder/InlineVineRecorder;

    invoke-virtual {v0}, Lco/vine/android/recorder/InlineVineRecorder;->release()Z

    .line 372
    :cond_0
    return-void
.end method
