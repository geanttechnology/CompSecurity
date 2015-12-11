.class public Lco/vine/android/RecordingFragment;
.super Lco/vine/android/BaseFragment;
.source "RecordingFragment.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/RecordingFragment$16;,
        Lco/vine/android/RecordingFragment$OnRecordingFinishRunnable;,
        Lco/vine/android/RecordingFragment$SecretModes;,
        Lco/vine/android/RecordingFragment$PlusMinusTouchListener;
    }
.end annotation


# static fields
.field public static final ARG_COLOR:Ljava/lang/String; = "color"

.field public static final ARG_ENCODER_VERSION:Ljava/lang/String; = "arg_encoder_version"

.field public static final ARG_IS_MESSAGING:Ljava/lang/String; = "is_messaging"

.field public static final ARG_IS_VM_ONBOARDING:Ljava/lang/String; = "is_vm_onboarding"

.field public static final ARG_RECIPIENT_USERNAME:Ljava/lang/String; = "recipient_username"

.field public static final ARG_SCREEN_SIZE:Ljava/lang/String; = "screen_size"

.field public static final ARG_TOP_OVERLAY:Ljava/lang/String; = "arg_top_overlay"

.field private static final DISABLED_ALPHA:F = 0.35f

.field private static final ENABLED_ALPHA:F = 1.0f


# instance fields
.field private mColor:I

.field private mCurrentSteadyCount:I

.field private mDismissGridAnimation:Landroid/view/animation/AlphaAnimation;

.field private mDraftOverlayIcon:Landroid/view/View;

.field private mDraftUpgradeCount:I

.field private mDraftsButton:Landroid/widget/TextView;

.field private mFadeIn:Landroid/view/animation/Animation;

.field private final mFadeInListener:Landroid/view/animation/Animation$AnimationListener;

.field private mFadeOut:Landroid/view/animation/Animation;

.field private final mFadeOutListener:Landroid/view/animation/Animation$AnimationListener;

.field private mFileFileToUse:Lco/vine/android/recorder/RecordingFile;

.field private mFocusButton:Landroid/view/View;

.field private mFolder:Ljava/io/File;

.field private mGhostButton:Landroid/widget/ToggleButton;

.field private mGrid:Landroid/view/View;

.field private mGridButton:Landroid/widget/ToggleButton;

.field private mHalfColor:I

.field private final mHandler:Landroid/os/Handler;

.field private mIsDraftUpgradeAnimationRunning:Z

.field private mIsMessaging:Z

.field private mIsVmOnboarding:Z

.field private mMediaActionSound:Landroid/media/MediaActionSound;

.field private mNoDraftsOverlay:Landroid/view/View;

.field private mNumDrafts:I

.field final mOnNoDraftOverlayTouchListener:Landroid/view/View$OnTouchListener;

.field private mRecipientUsername:Ljava/lang/String;

.field private mRecorder:Lco/vine/android/recorder/VineRecorder;

.field private mRecordingOptions:Landroid/view/View;

.field private mRsm:Lco/vine/android/recorder/RecordSessionManager;

.field private mScreenSize:Landroid/graphics/Point;

.field private mSecretMode:Lco/vine/android/RecordingFragment$SecretModes;

.field private mSecretToast:Landroid/widget/Toast;

.field private mShowGridAnimation:Landroid/view/animation/AlphaAnimation;

.field private final mStartDraftsRunnable:Ljava/lang/Runnable;

.field private mStartWithEdit:Z

.field private mTier:D

.field private mTopOverlay:Landroid/graphics/Bitmap;

.field private mUpgradeSpinner:Landroid/widget/ProgressBar;

.field private mVersion:Lco/vine/android/recorder/RecordSessionVersion;

.field private mVmOnboardOverlay:Landroid/view/ViewGroup;

.field private final mVmOnboardingFadeListener:Landroid/view/animation/Animation$AnimationListener;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 61
    invoke-direct {p0}, Lco/vine/android/BaseFragment;-><init>()V

    .line 96
    const/4 v0, 0x0

    iput v0, p0, Lco/vine/android/RecordingFragment;->mCurrentSteadyCount:I

    .line 99
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    iput-object v0, p0, Lco/vine/android/RecordingFragment;->mHandler:Landroid/os/Handler;

    .line 106
    new-instance v0, Lco/vine/android/RecordingFragment$1;

    invoke-direct {v0, p0}, Lco/vine/android/RecordingFragment$1;-><init>(Lco/vine/android/RecordingFragment;)V

    iput-object v0, p0, Lco/vine/android/RecordingFragment;->mFadeOutListener:Landroid/view/animation/Animation$AnimationListener;

    .line 125
    new-instance v0, Lco/vine/android/RecordingFragment$2;

    invoke-direct {v0, p0}, Lco/vine/android/RecordingFragment$2;-><init>(Lco/vine/android/RecordingFragment;)V

    iput-object v0, p0, Lco/vine/android/RecordingFragment;->mVmOnboardingFadeListener:Landroid/view/animation/Animation$AnimationListener;

    .line 140
    new-instance v0, Lco/vine/android/RecordingFragment$3;

    invoke-direct {v0, p0}, Lco/vine/android/RecordingFragment$3;-><init>(Lco/vine/android/RecordingFragment;)V

    iput-object v0, p0, Lco/vine/android/RecordingFragment;->mFadeInListener:Landroid/view/animation/Animation$AnimationListener;

    .line 156
    new-instance v0, Lco/vine/android/RecordingFragment$4;

    invoke-direct {v0, p0}, Lco/vine/android/RecordingFragment$4;-><init>(Lco/vine/android/RecordingFragment;)V

    iput-object v0, p0, Lco/vine/android/RecordingFragment;->mOnNoDraftOverlayTouchListener:Landroid/view/View$OnTouchListener;

    .line 165
    new-instance v0, Lco/vine/android/RecordingFragment$5;

    invoke-direct {v0, p0}, Lco/vine/android/RecordingFragment$5;-><init>(Lco/vine/android/RecordingFragment;)V

    iput-object v0, p0, Lco/vine/android/RecordingFragment;->mStartDraftsRunnable:Ljava/lang/Runnable;

    .line 1138
    return-void
.end method

.method static synthetic access$000(Lco/vine/android/RecordingFragment;)Landroid/view/View;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/RecordingFragment;

    .prologue
    .line 61
    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mDraftOverlayIcon:Landroid/view/View;

    return-object v0
.end method

.method static synthetic access$100(Lco/vine/android/RecordingFragment;)Landroid/widget/TextView;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/RecordingFragment;

    .prologue
    .line 61
    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mDraftsButton:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$1000(Lco/vine/android/RecordingFragment;)Landroid/view/View;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/RecordingFragment;

    .prologue
    .line 61
    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mGrid:Landroid/view/View;

    return-object v0
.end method

.method static synthetic access$1100(Lco/vine/android/RecordingFragment;)Landroid/view/animation/Animation$AnimationListener;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/RecordingFragment;

    .prologue
    .line 61
    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mVmOnboardingFadeListener:Landroid/view/animation/Animation$AnimationListener;

    return-object v0
.end method

.method static synthetic access$1200(Lco/vine/android/RecordingFragment;)Landroid/view/animation/AlphaAnimation;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/RecordingFragment;

    .prologue
    .line 61
    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mShowGridAnimation:Landroid/view/animation/AlphaAnimation;

    return-object v0
.end method

.method static synthetic access$1300(Lco/vine/android/RecordingFragment;)Landroid/view/animation/AlphaAnimation;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/RecordingFragment;

    .prologue
    .line 61
    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mDismissGridAnimation:Landroid/view/animation/AlphaAnimation;

    return-object v0
.end method

.method static synthetic access$1400(Lco/vine/android/RecordingFragment;)Z
    .locals 1
    .param p0, "x0"    # Lco/vine/android/RecordingFragment;

    .prologue
    .line 61
    iget-boolean v0, p0, Lco/vine/android/RecordingFragment;->mIsDraftUpgradeAnimationRunning:Z

    return v0
.end method

.method static synthetic access$1402(Lco/vine/android/RecordingFragment;Z)Z
    .locals 0
    .param p0, "x0"    # Lco/vine/android/RecordingFragment;
    .param p1, "x1"    # Z

    .prologue
    .line 61
    iput-boolean p1, p0, Lco/vine/android/RecordingFragment;->mIsDraftUpgradeAnimationRunning:Z

    return p1
.end method

.method static synthetic access$1500(Lco/vine/android/RecordingFragment;)I
    .locals 1
    .param p0, "x0"    # Lco/vine/android/RecordingFragment;

    .prologue
    .line 61
    iget v0, p0, Lco/vine/android/RecordingFragment;->mDraftUpgradeCount:I

    return v0
.end method

.method static synthetic access$1608(Lco/vine/android/RecordingFragment;)I
    .locals 2
    .param p0, "x0"    # Lco/vine/android/RecordingFragment;

    .prologue
    .line 61
    iget v0, p0, Lco/vine/android/RecordingFragment;->mCurrentSteadyCount:I

    add-int/lit8 v1, v0, 0x1

    iput v1, p0, Lco/vine/android/RecordingFragment;->mCurrentSteadyCount:I

    return v0
.end method

.method static synthetic access$1700(Lco/vine/android/RecordingFragment;)V
    .locals 0
    .param p0, "x0"    # Lco/vine/android/RecordingFragment;

    .prologue
    .line 61
    invoke-direct {p0}, Lco/vine/android/RecordingFragment;->doStopMotion()V

    return-void
.end method

.method static synthetic access$1800(Lco/vine/android/RecordingFragment;Ljava/lang/String;ZLco/vine/android/util/MediaUtil$GenerateThumbnailsRunnable;)V
    .locals 0
    .param p0, "x0"    # Lco/vine/android/RecordingFragment;
    .param p1, "x1"    # Ljava/lang/String;
    .param p2, "x2"    # Z
    .param p3, "x3"    # Lco/vine/android/util/MediaUtil$GenerateThumbnailsRunnable;

    .prologue
    .line 61
    invoke-direct {p0, p1, p2, p3}, Lco/vine/android/RecordingFragment;->notifyActivity(Ljava/lang/String;ZLco/vine/android/util/MediaUtil$GenerateThumbnailsRunnable;)V

    return-void
.end method

.method static synthetic access$200(Lco/vine/android/RecordingFragment;)Landroid/view/View;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/RecordingFragment;

    .prologue
    .line 61
    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mNoDraftsOverlay:Landroid/view/View;

    return-object v0
.end method

.method static synthetic access$300(Lco/vine/android/RecordingFragment;)Landroid/view/ViewGroup;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/RecordingFragment;

    .prologue
    .line 61
    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mVmOnboardOverlay:Landroid/view/ViewGroup;

    return-object v0
.end method

.method static synthetic access$400(Lco/vine/android/RecordingFragment;)Landroid/view/animation/Animation$AnimationListener;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/RecordingFragment;

    .prologue
    .line 61
    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mFadeOutListener:Landroid/view/animation/Animation$AnimationListener;

    return-object v0
.end method

.method static synthetic access$500(Lco/vine/android/RecordingFragment;)Landroid/view/animation/Animation;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/RecordingFragment;

    .prologue
    .line 61
    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mFadeOut:Landroid/view/animation/Animation;

    return-object v0
.end method

.method static synthetic access$600(Lco/vine/android/RecordingFragment;)Landroid/widget/ToggleButton;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/RecordingFragment;

    .prologue
    .line 61
    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mGridButton:Landroid/widget/ToggleButton;

    return-object v0
.end method

.method static synthetic access$700(Lco/vine/android/RecordingFragment;)Landroid/widget/ToggleButton;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/RecordingFragment;

    .prologue
    .line 61
    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mGhostButton:Landroid/widget/ToggleButton;

    return-object v0
.end method

.method static synthetic access$800(Lco/vine/android/RecordingFragment;)Lco/vine/android/recorder/VineRecorder;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/RecordingFragment;

    .prologue
    .line 61
    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    return-object v0
.end method

.method static synthetic access$900(Lco/vine/android/RecordingFragment;)I
    .locals 1
    .param p0, "x0"    # Lco/vine/android/RecordingFragment;

    .prologue
    .line 61
    iget v0, p0, Lco/vine/android/RecordingFragment;->mColor:I

    return v0
.end method

.method private determineSessionFileForSwap(Z)Lco/vine/android/recorder/RecordingFile;
    .locals 15
    .param p1, "useFinalFile"    # Z

    .prologue
    .line 251
    invoke-virtual {p0}, Lco/vine/android/RecordingFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v7

    check-cast v7, Lco/vine/android/AbstractRecordingActivity;

    .line 253
    .local v7, "activity":Lco/vine/android/AbstractRecordingActivity;
    :try_start_0
    iget-object v1, p0, Lco/vine/android/RecordingFragment;->mVersion:Lco/vine/android/recorder/RecordSessionVersion;

    invoke-static {v7, v1}, Lco/vine/android/recorder/RecordSessionManager;->getValidSessions(Landroid/content/Context;Lco/vine/android/recorder/RecordSessionVersion;)Ljava/util/ArrayList;

    move-result-object v13

    .line 254
    .local v13, "sessions":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/recorder/RecordSessionManager$RecordSessionInfo;>;"
    const/4 v9, 0x0

    .line 255
    .local v9, "extraFolder":Ljava/io/File;
    invoke-virtual {v13}, Ljava/util/ArrayList;->size()I

    move-result v1

    const/16 v6, 0x9

    if-le v1, v6, :cond_0

    .line 256
    invoke-virtual {v13}, Ljava/util/ArrayList;->size()I

    move-result v1

    add-int/lit8 v1, v1, -0x1

    invoke-virtual {v13, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lco/vine/android/recorder/RecordSessionManager$RecordSessionInfo;

    iget-object v9, v1, Lco/vine/android/recorder/RecordSessionManager$RecordSessionInfo;->folder:Ljava/io/File;

    .line 258
    :cond_0
    const/4 v2, 0x0

    .line 259
    .local v2, "folder":Ljava/io/File;
    iget-object v10, p0, Lco/vine/android/RecordingFragment;->mFileFileToUse:Lco/vine/android/recorder/RecordingFile;

    .line 260
    .local v10, "file":Lco/vine/android/recorder/RecordingFile;
    if-eqz p1, :cond_2

    if-eqz v10, :cond_2

    .line 261
    const-string v1, "Is from preview, use existing final file."

    invoke-static {v1}, Lcom/edisonwang/android/slog/SLog;->i(Ljava/lang/String;)V

    .line 262
    iget-boolean v1, v10, Lco/vine/android/recorder/RecordingFile;->isSavedSession:Z

    if-nez v1, :cond_1

    const/4 v1, 0x1

    :goto_0
    iput-boolean v1, v10, Lco/vine/android/recorder/RecordingFile;->isDirty:Z

    .line 327
    .end local v2    # "folder":Ljava/io/File;
    .end local v9    # "extraFolder":Ljava/io/File;
    .end local v10    # "file":Lco/vine/android/recorder/RecordingFile;
    .end local v13    # "sessions":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/recorder/RecordSessionManager$RecordSessionInfo;>;"
    :goto_1
    return-object v10

    .line 262
    .restart local v2    # "folder":Ljava/io/File;
    .restart local v9    # "extraFolder":Ljava/io/File;
    .restart local v10    # "file":Lco/vine/android/recorder/RecordingFile;
    .restart local v13    # "sessions":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/recorder/RecordSessionManager$RecordSessionInfo;>;"
    :cond_1
    const/4 v1, 0x0

    goto :goto_0

    .line 265
    :cond_2
    iget-object v1, p0, Lco/vine/android/RecordingFragment;->mFolder:Ljava/io/File;

    if-eqz v1, :cond_4

    const/4 v4, 0x1

    .line 266
    .local v4, "savedSession":Z
    :goto_2
    const/4 v5, 0x0

    .line 267
    .local v5, "dirty":Z
    const/4 v3, 0x0

    .line 268
    .local v3, "session":Lco/vine/android/recorder/RecordSession;
    if-eqz v10, :cond_5

    .line 269
    invoke-virtual {v10}, Lco/vine/android/recorder/RecordingFile;->getSession()Lco/vine/android/recorder/RecordSession;

    move-result-object v3

    .line 270
    iget-object v2, v10, Lco/vine/android/recorder/RecordingFile;->folder:Ljava/io/File;

    .line 322
    :cond_3
    :goto_3
    new-instance v1, Lco/vine/android/recorder/RecordingFile;

    if-ne v2, v9, :cond_e

    const/4 v6, 0x1

    :goto_4
    invoke-direct/range {v1 .. v6}, Lco/vine/android/recorder/RecordingFile;-><init>(Ljava/io/File;Lco/vine/android/recorder/RecordSession;ZZZ)V

    move-object v10, v1

    goto :goto_1

    .line 265
    .end local v3    # "session":Lco/vine/android/recorder/RecordSession;
    .end local v4    # "savedSession":Z
    .end local v5    # "dirty":Z
    :cond_4
    const/4 v4, 0x0

    goto :goto_2

    .line 272
    .restart local v3    # "session":Lco/vine/android/recorder/RecordSession;
    .restart local v4    # "savedSession":Z
    .restart local v5    # "dirty":Z
    :cond_5
    if-nez v9, :cond_a

    if-nez v4, :cond_a

    const/4 v11, 0x1

    .line 273
    .local v11, "makeNewSession":Z
    :goto_5
    if-nez v11, :cond_8

    .line 274
    if-eqz v4, :cond_6

    iget-object v1, p0, Lco/vine/android/RecordingFragment;->mFolder:Ljava/io/File;

    invoke-virtual {v1}, Ljava/io/File;->exists()Z

    move-result v1

    if-eqz v1, :cond_7

    :cond_6
    if-eqz v9, :cond_8

    invoke-virtual {v9}, Ljava/io/File;->exists()Z
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1

    move-result v1

    if-nez v1, :cond_8

    .line 275
    :cond_7
    const/4 v11, 0x1

    .line 276
    const/4 v4, 0x0

    .line 280
    :cond_8
    if-eqz v11, :cond_c

    .line 282
    :try_start_1
    iget-object v1, p0, Lco/vine/android/RecordingFragment;->mRsm:Lco/vine/android/recorder/RecordSessionManager;

    invoke-virtual {v1}, Lco/vine/android/recorder/RecordSessionManager;->getCrashedSession()Ljava/util/HashMap;

    move-result-object v12

    .line 283
    .local v12, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Lco/vine/android/recorder/RecordSession;Ljava/io/File;>;"
    if-eqz v12, :cond_9

    .line 284
    invoke-virtual {v12}, Ljava/util/HashMap;->keySet()Ljava/util/Set;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    move-object v0, v1

    check-cast v0, Lco/vine/android/recorder/RecordSession;

    move-object v3, v0

    .line 285
    new-instance v1, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;

    invoke-direct {v1, v7}, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;-><init>(Landroid/content/Context;)V

    invoke-virtual {v3, v1}, Lco/vine/android/recorder/RecordSession;->setConfig(Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;)V

    .line 286
    invoke-virtual {v12, v3}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    move-object v0, v1

    check-cast v0, Ljava/io/File;

    move-object v2, v0

    .line 287
    invoke-virtual {v3}, Lco/vine/android/recorder/RecordSession;->getSegments()Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-lez v1, :cond_b

    const/4 v5, 0x1

    .line 288
    :goto_6
    const-string v1, "Restore from crashed session."

    invoke-static {v1}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;)V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0

    .line 293
    .end local v12    # "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Lco/vine/android/recorder/RecordSession;Ljava/io/File;>;"
    :cond_9
    :goto_7
    if-nez v3, :cond_3

    .line 294
    :try_start_2
    const-string v1, "Creating new session."

    invoke-static {v1}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;)V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_1

    .line 296
    :try_start_3
    iget-object v1, p0, Lco/vine/android/RecordingFragment;->mRsm:Lco/vine/android/recorder/RecordSessionManager;

    invoke-virtual {v1}, Lco/vine/android/recorder/RecordSessionManager;->createFolderForSession()Ljava/io/File;

    move-result-object v2

    .line 297
    new-instance v1, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;

    invoke-direct {v1, v7}, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;-><init>(Landroid/content/Context;)V

    iget-object v6, p0, Lco/vine/android/RecordingFragment;->mVersion:Lco/vine/android/recorder/RecordSessionVersion;

    invoke-static {v1, v6}, Lco/vine/android/recorder/RecordSession;->newSession(Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;Lco/vine/android/recorder/RecordSessionVersion;)Lco/vine/android/recorder/RecordSession;

    move-result-object v3

    .line 299
    invoke-virtual {v13}, Ljava/util/ArrayList;->size()I
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_2

    move-result v1

    const/16 v6, 0x9

    if-ne v1, v6, :cond_3

    .line 300
    move-object v9, v2

    goto/16 :goto_3

    .line 272
    .end local v11    # "makeNewSession":Z
    :cond_a
    const/4 v11, 0x0

    goto :goto_5

    .line 287
    .restart local v11    # "makeNewSession":Z
    .restart local v12    # "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Lco/vine/android/recorder/RecordSession;Ljava/io/File;>;"
    :cond_b
    const/4 v5, 0x0

    goto :goto_6

    .line 290
    .end local v12    # "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Lco/vine/android/recorder/RecordSession;Ljava/io/File;>;"
    :catch_0
    move-exception v8

    .line 291
    .local v8, "e":Ljava/io/IOException;
    :try_start_4
    const-string v1, "Failed to get a crashed session."

    invoke-static {v1}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;)V
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_1

    goto :goto_7

    .line 323
    .end local v2    # "folder":Ljava/io/File;
    .end local v3    # "session":Lco/vine/android/recorder/RecordSession;
    .end local v4    # "savedSession":Z
    .end local v5    # "dirty":Z
    .end local v8    # "e":Ljava/io/IOException;
    .end local v9    # "extraFolder":Ljava/io/File;
    .end local v10    # "file":Lco/vine/android/recorder/RecordingFile;
    .end local v11    # "makeNewSession":Z
    .end local v13    # "sessions":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/recorder/RecordSessionManager$RecordSessionInfo;>;"
    :catch_1
    move-exception v8

    .line 324
    .restart local v8    # "e":Ljava/io/IOException;
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Error creating folder: "

    invoke-virtual {v1, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v6, p0, Lco/vine/android/RecordingFragment;->mFolder:Ljava/io/File;

    invoke-virtual {v1, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1, v8}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 325
    const v1, 0x7f0e0232

    const/4 v6, 0x0

    invoke-static {v7, v1, v6}, Landroid/widget/Toast;->makeText(Landroid/content/Context;II)Landroid/widget/Toast;

    move-result-object v1

    invoke-virtual {v1}, Landroid/widget/Toast;->show()V

    .line 326
    invoke-virtual {v7}, Lco/vine/android/AbstractRecordingActivity;->finish()V

    .line 327
    const/4 v10, 0x0

    goto/16 :goto_1

    .line 302
    .end local v8    # "e":Ljava/io/IOException;
    .restart local v2    # "folder":Ljava/io/File;
    .restart local v3    # "session":Lco/vine/android/recorder/RecordSession;
    .restart local v4    # "savedSession":Z
    .restart local v5    # "dirty":Z
    .restart local v9    # "extraFolder":Ljava/io/File;
    .restart local v10    # "file":Lco/vine/android/recorder/RecordingFile;
    .restart local v11    # "makeNewSession":Z
    .restart local v13    # "sessions":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/recorder/RecordSessionManager$RecordSessionInfo;>;"
    :catch_2
    move-exception v8

    .line 303
    .restart local v8    # "e":Ljava/io/IOException;
    :try_start_5
    const-string v1, "Cannot create folder."

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v14, 0x0

    aput-object v8, v6, v14

    invoke-static {v1, v6}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 304
    invoke-virtual {p0}, Lco/vine/android/RecordingFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->finish()V

    .line 305
    const/4 v10, 0x0

    goto/16 :goto_1

    .line 309
    .end local v8    # "e":Ljava/io/IOException;
    :cond_c
    if-eqz v4, :cond_d

    .line 310
    iget-object v2, p0, Lco/vine/android/RecordingFragment;->mFolder:Ljava/io/File;

    .line 315
    :goto_8
    invoke-static {v2}, Lco/vine/android/recorder/RecordSessionManager;->readDataObject(Ljava/io/File;)Lco/vine/android/recorder/RecordSession;

    move-result-object v3

    .line 316
    new-instance v1, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;

    invoke-direct {v1, v7}, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;-><init>(Landroid/content/Context;)V

    invoke-virtual {v3, v1}, Lco/vine/android/recorder/RecordSession;->setConfig(Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;)V

    .line 317
    invoke-virtual {v3}, Lco/vine/android/recorder/RecordSession;->calculateAudioCount()I

    move-result v1

    invoke-virtual {v3, v1}, Lco/vine/android/recorder/RecordSession;->setAudioDataCount(I)V

    .line 318
    invoke-virtual {v3}, Lco/vine/android/recorder/RecordSession;->calculateVideoCount()I

    move-result v1

    invoke-virtual {v3, v1}, Lco/vine/android/recorder/RecordSession;->setVideoDataCount(I)V

    .line 319
    const-string v1, "Resume session {}."

    invoke-virtual {v2}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v6

    invoke-static {v1, v6}, Lcom/edisonwang/android/slog/SLog;->i(Ljava/lang/String;Ljava/lang/Object;)V
    :try_end_5
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_1

    goto/16 :goto_3

    .line 312
    :cond_d
    move-object v2, v9

    .line 313
    const/4 v5, 0x1

    goto :goto_8

    .line 322
    .end local v11    # "makeNewSession":Z
    :cond_e
    const/4 v6, 0x0

    goto/16 :goto_4
.end method

.method private doStopMotion()V
    .locals 4

    .prologue
    .line 1090
    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    invoke-virtual {v0}, Lco/vine/android/recorder/VineRecorder;->canKeepRecording()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1091
    iget v0, p0, Lco/vine/android/RecordingFragment;->mCurrentSteadyCount:I

    const/16 v1, 0x28

    if-ge v0, v1, :cond_0

    .line 1092
    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mHandler:Landroid/os/Handler;

    new-instance v1, Lco/vine/android/RecordingFragment$15;

    invoke-direct {v1, p0}, Lco/vine/android/RecordingFragment$15;-><init>(Lco/vine/android/RecordingFragment;)V

    const-wide/16 v2, 0x32

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 1102
    :cond_0
    return-void
.end method

.method private notifyActivity(Ljava/lang/String;ZLco/vine/android/util/MediaUtil$GenerateThumbnailsRunnable;)V
    .locals 3
    .param p1, "source"    # Ljava/lang/String;
    .param p2, "detectedInvalidSession"    # Z
    .param p3, "r"    # Lco/vine/android/util/MediaUtil$GenerateThumbnailsRunnable;

    .prologue
    .line 525
    iget-object v1, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    iget-object v1, v1, Lco/vine/android/recorder/VineRecorder;->finalFile:Lco/vine/android/recorder/RecordingFile;

    if-eqz v1, :cond_0

    .line 526
    invoke-virtual {p0}, Lco/vine/android/RecordingFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lco/vine/android/AbstractRecordingActivity;

    .line 527
    .local v0, "activity":Lco/vine/android/AbstractRecordingActivity;
    if-eqz v0, :cond_0

    .line 528
    if-eqz p2, :cond_1

    .line 529
    new-instance v1, Ljava/lang/IllegalStateException;

    const-string v2, "Detected invalid session."

    invoke-direct {v1, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    invoke-static {v1}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;)V

    .line 530
    const v1, 0x7f0e0116

    invoke-static {v0, v1}, Lco/vine/android/util/Util;->showCenteredToast(Landroid/content/Context;I)V

    .line 531
    invoke-virtual {v0}, Lco/vine/android/AbstractRecordingActivity;->finish()V

    .line 540
    .end local v0    # "activity":Lco/vine/android/AbstractRecordingActivity;
    :cond_0
    :goto_0
    return-void

    .line 533
    .restart local v0    # "activity":Lco/vine/android/AbstractRecordingActivity;
    :cond_1
    iget-object v1, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    invoke-virtual {v1}, Lco/vine/android/recorder/VineRecorder;->getCameraView()Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v1

    check-cast v1, Landroid/view/ViewGroup;

    invoke-virtual {v1}, Landroid/view/ViewGroup;->getMeasuredWidth()I

    move-result v1

    iput v1, v0, Lco/vine/android/AbstractRecordingActivity;->mProgressContainerWidth:I

    .line 535
    iget-object v1, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    invoke-virtual {v1}, Lco/vine/android/recorder/VineRecorder;->getCurrentDuration()J

    move-result-wide v1

    iput-wide v1, v0, Lco/vine/android/AbstractRecordingActivity;->mCurrentDuration:J

    .line 536
    iget-object v1, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    iget-object v1, v1, Lco/vine/android/recorder/VineRecorder;->finalFile:Lco/vine/android/recorder/RecordingFile;

    iget-object v2, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    invoke-virtual {v2}, Lco/vine/android/recorder/VineRecorder;->getThumbnailPath()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, p1, v1, v2, p3}, Lco/vine/android/AbstractRecordingActivity;->toPreview(Ljava/lang/String;Lco/vine/android/recorder/RecordingFile;Ljava/lang/String;Lco/vine/android/util/MediaUtil$GenerateThumbnailsRunnable;)V

    goto :goto_0
.end method

.method private refreshDraftNumber()V
    .locals 4

    .prologue
    .line 760
    :try_start_0
    invoke-virtual {p0}, Lco/vine/android/RecordingFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    iget-object v3, p0, Lco/vine/android/RecordingFragment;->mVersion:Lco/vine/android/recorder/RecordSessionVersion;

    invoke-static {v2, v3}, Lco/vine/android/recorder/RecordSessionManager;->getNumberOfValidSessions(Landroid/content/Context;Lco/vine/android/recorder/RecordSessionVersion;)I

    move-result v1

    .line 761
    .local v1, "numDrafts":I
    if-lez v1, :cond_1

    .line 762
    const/16 v2, 0x9

    if-le v1, v2, :cond_0

    .line 763
    add-int/lit8 v1, v1, -0x1

    .line 765
    :cond_0
    iget-object v2, p0, Lco/vine/android/RecordingFragment;->mDraftsButton:Landroid/widget/TextView;

    invoke-static {v1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 769
    :goto_0
    iput v1, p0, Lco/vine/android/RecordingFragment;->mNumDrafts:I

    .line 773
    .end local v1    # "numDrafts":I
    :goto_1
    return-void

    .line 767
    .restart local v1    # "numDrafts":I
    :cond_1
    iget-object v2, p0, Lco/vine/android/RecordingFragment;->mDraftsButton:Landroid/widget/TextView;

    const-string v3, ""

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 770
    .end local v1    # "numDrafts":I
    :catch_0
    move-exception v0

    .line 771
    .local v0, "e":Ljava/io/IOException;
    invoke-static {v0}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;)V

    goto :goto_1
.end method


# virtual methods
.method public discardEditing()V
    .locals 3

    .prologue
    .line 916
    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    if-eqz v0, :cond_0

    .line 917
    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    const/4 v1, 0x0

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Lco/vine/android/recorder/VineRecorder;->setEditMode(ZZ)V

    .line 919
    :cond_0
    return-void
.end method

.method public doOneFrame()V
    .locals 1

    .prologue
    .line 947
    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    invoke-virtual {v0}, Lco/vine/android/recorder/VineRecorder;->canKeepRecording()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 948
    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    invoke-virtual {v0}, Lco/vine/android/recorder/VineRecorder;->doOneFrame()V

    .line 950
    :cond_0
    return-void
.end method

.method public doSecretVolumeDown()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 1058
    sget-object v0, Lco/vine/android/RecordingFragment$16;->$SwitchMap$co$vine$android$RecordingFragment$SecretModes:[I

    iget-object v1, p0, Lco/vine/android/RecordingFragment;->mSecretMode:Lco/vine/android/RecordingFragment$SecretModes;

    invoke-virtual {v1}, Lco/vine/android/RecordingFragment$SecretModes;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 1087
    :goto_0
    return-void

    .line 1060
    :pswitch_0
    invoke-direct {p0}, Lco/vine/android/RecordingFragment;->doStopMotion()V

    goto :goto_0

    .line 1063
    :pswitch_1
    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    invoke-virtual {v0, v2}, Lco/vine/android/recorder/VineRecorder;->modifyWhiteBalance(Z)V

    goto :goto_0

    .line 1066
    :pswitch_2
    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    invoke-virtual {v0, v2}, Lco/vine/android/recorder/VineRecorder;->modifyExposure(Z)V

    goto :goto_0

    .line 1069
    :pswitch_3
    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    invoke-virtual {v0}, Lco/vine/android/recorder/VineRecorder;->switchFlash()V

    goto :goto_0

    .line 1072
    :pswitch_4
    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    invoke-virtual {v0}, Lco/vine/android/recorder/VineRecorder;->showTimeLapseDialog()V

    goto :goto_0

    .line 1075
    :pswitch_5
    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    invoke-virtual {v0, v2}, Lco/vine/android/recorder/VineRecorder;->modifySceneMode(Z)V

    goto :goto_0

    .line 1078
    :pswitch_6
    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    invoke-virtual {v0, v2}, Lco/vine/android/recorder/VineRecorder;->modifyColorEffects(Z)V

    goto :goto_0

    .line 1081
    :pswitch_7
    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    invoke-virtual {v0, v2}, Lco/vine/android/recorder/VineRecorder;->modifyAntiBanding(Z)V

    goto :goto_0

    .line 1084
    :pswitch_8
    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    invoke-virtual {v0}, Lco/vine/android/recorder/VineRecorder;->switchImageStabilization()V

    goto :goto_0

    .line 1058
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
        :pswitch_7
        :pswitch_8
    .end packed-switch
.end method

.method public doSecretVolumeUp()V
    .locals 3

    .prologue
    const/4 v2, 0x1

    .line 1024
    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    invoke-virtual {v0}, Lco/vine/android/recorder/VineRecorder;->canKeepRecording()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1025
    sget-object v0, Lco/vine/android/RecordingFragment$16;->$SwitchMap$co$vine$android$RecordingFragment$SecretModes:[I

    iget-object v1, p0, Lco/vine/android/RecordingFragment;->mSecretMode:Lco/vine/android/RecordingFragment$SecretModes;

    invoke-virtual {v1}, Lco/vine/android/RecordingFragment$SecretModes;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 1055
    :cond_0
    :goto_0
    return-void

    .line 1027
    :pswitch_0
    invoke-virtual {p0}, Lco/vine/android/RecordingFragment;->doOneFrame()V

    goto :goto_0

    .line 1030
    :pswitch_1
    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    invoke-virtual {v0, v2}, Lco/vine/android/recorder/VineRecorder;->modifyWhiteBalance(Z)V

    goto :goto_0

    .line 1033
    :pswitch_2
    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    invoke-virtual {v0, v2}, Lco/vine/android/recorder/VineRecorder;->modifyExposure(Z)V

    goto :goto_0

    .line 1036
    :pswitch_3
    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    invoke-virtual {v0}, Lco/vine/android/recorder/VineRecorder;->switchFlash()V

    goto :goto_0

    .line 1039
    :pswitch_4
    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    invoke-virtual {v0}, Lco/vine/android/recorder/VineRecorder;->showTimeLapseDialog()V

    goto :goto_0

    .line 1042
    :pswitch_5
    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    invoke-virtual {v0, v2}, Lco/vine/android/recorder/VineRecorder;->modifySceneMode(Z)V

    goto :goto_0

    .line 1045
    :pswitch_6
    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    invoke-virtual {v0, v2}, Lco/vine/android/recorder/VineRecorder;->modifyColorEffects(Z)V

    goto :goto_0

    .line 1048
    :pswitch_7
    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    invoke-virtual {v0, v2}, Lco/vine/android/recorder/VineRecorder;->modifyAntiBanding(Z)V

    goto :goto_0

    .line 1051
    :pswitch_8
    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    invoke-virtual {v0}, Lco/vine/android/recorder/VineRecorder;->switchImageStabilization()V

    goto :goto_0

    .line 1025
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
        :pswitch_7
        :pswitch_8
    .end packed-switch
.end method

.method public enableSecretMode(Landroid/widget/Toast;)V
    .locals 1
    .param p1, "toast"    # Landroid/widget/Toast;

    .prologue
    .line 1134
    iput-object p1, p0, Lco/vine/android/RecordingFragment;->mSecretToast:Landroid/widget/Toast;

    .line 1135
    sget-object v0, Lco/vine/android/RecordingFragment$SecretModes;->STOP_MOTION:Lco/vine/android/RecordingFragment$SecretModes;

    iput-object v0, p0, Lco/vine/android/RecordingFragment;->mSecretMode:Lco/vine/android/RecordingFragment$SecretModes;

    .line 1136
    return-void
.end method

.method public endRelativeTime()Z
    .locals 1

    .prologue
    .line 1113
    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    invoke-virtual {v0}, Lco/vine/android/recorder/VineRecorder;->canKeepRecording()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    invoke-virtual {v0}, Lco/vine/android/recorder/VineRecorder;->isCurrentlyRecording()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1114
    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    invoke-virtual {v0}, Lco/vine/android/recorder/VineRecorder;->endRelativeTime()Z

    move-result v0

    .line 1116
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getProgressView()Landroid/view/View;
    .locals 1

    .prologue
    .line 1016
    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    invoke-virtual {v0}, Lco/vine/android/recorder/VineRecorder;->getProgressView()Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public getThumbnailPath()Ljava/lang/String;
    .locals 1

    .prologue
    .line 1012
    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    invoke-virtual {v0}, Lco/vine/android/recorder/VineRecorder;->getThumbnailPath()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public isEditing()Z
    .locals 1

    .prologue
    .line 788
    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    invoke-virtual {v0}, Lco/vine/android/recorder/VineRecorder;->isEditing()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isEditingDirty()Z
    .locals 1

    .prologue
    .line 792
    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    invoke-virtual {v0}, Lco/vine/android/recorder/VineRecorder;->isEditingDirty()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isResuming()Z
    .locals 1

    .prologue
    .line 984
    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    invoke-virtual {v0}, Lco/vine/android/recorder/VineRecorder;->isResuming()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isSavedSession()Z
    .locals 1

    .prologue
    .line 843
    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    invoke-virtual {v0}, Lco/vine/android/recorder/VineRecorder;->isSavedSession()Z

    move-result v0

    return v0
.end method

.method public isSessionModified()Z
    .locals 1

    .prologue
    .line 961
    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    if-eqz v0, :cond_0

    .line 962
    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    invoke-virtual {v0}, Lco/vine/android/recorder/VineRecorder;->isSessionDirty()Z

    move-result v0

    .line 964
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
    .line 796
    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    if-eqz v0, :cond_0

    .line 797
    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    invoke-virtual {v0, p1}, Lco/vine/android/recorder/VineRecorder;->modifyZoom(Z)V

    .line 799
    :cond_0
    return-void
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 60
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 391
    invoke-super/range {p0 .. p1}, Lco/vine/android/BaseFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 392
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/RecordingFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    const/4 v3, 0x1

    invoke-static {v2, v3}, Lco/vine/android/util/SystemUtil;->getMemoryRatio(Landroid/content/Context;Z)D

    move-result-wide v2

    move-object/from16 v0, p0

    iput-wide v2, v0, Lco/vine/android/RecordingFragment;->mTier:D

    .line 393
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/RecordingFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v9

    check-cast v9, Lco/vine/android/AbstractRecordingActivity;

    .line 395
    .local v9, "activity":Lco/vine/android/AbstractRecordingActivity;
    :try_start_0
    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/RecordingFragment;->mVersion:Lco/vine/android/recorder/RecordSessionVersion;

    invoke-virtual/range {p0 .. p0}, Lco/vine/android/RecordingFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    invoke-virtual {v2, v3}, Lco/vine/android/recorder/RecordSessionVersion;->getManager(Landroid/content/Context;)Lco/vine/android/recorder/RecordSessionManager;

    move-result-object v2

    move-object/from16 v0, p0

    iput-object v2, v0, Lco/vine/android/RecordingFragment;->mRsm:Lco/vine/android/recorder/RecordSessionManager;

    .line 396
    move-object/from16 v0, p0

    iget-boolean v2, v0, Lco/vine/android/RecordingFragment;->mIsMessaging:Z

    if-eqz v2, :cond_0

    .line 397
    const v2, 0x7f0a01c4

    invoke-virtual {v9, v2}, Lco/vine/android/AbstractRecordingActivity;->findViewById(I)Landroid/view/View;

    move-result-object v2

    const/16 v3, 0x8

    invoke-virtual {v2, v3}, Landroid/view/View;->setVisibility(I)V

    .line 399
    :cond_0
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/RecordingFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v56

    .line 401
    .local v56, "res":Landroid/content/res/Resources;
    const v16, 0x7f020182

    .line 402
    .local v16, "focusEnabled":I
    const v17, 0x7f020184

    .line 404
    .local v17, "focusDisabled":I
    const v2, 0x7f0a01c8

    invoke-virtual {v9, v2}, Lco/vine/android/AbstractRecordingActivity;->findViewById(I)Landroid/view/View;

    move-result-object v57

    check-cast v57, Landroid/view/ViewGroup;

    .line 405
    .local v57, "trigger":Landroid/view/ViewGroup;
    new-instance v3, Lco/vine/android/RecordingFragment$PlusMinusTouchListener;

    const/4 v2, 0x0

    move-object/from16 v0, v57

    invoke-virtual {v0, v2}, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ImageView;

    const v4, 0x7f020296

    move-object/from16 v0, p0

    invoke-direct {v3, v0, v2, v4}, Lco/vine/android/RecordingFragment$PlusMinusTouchListener;-><init>(Lco/vine/android/RecordingFragment;Landroid/widget/ImageView;I)V

    move-object/from16 v0, v57

    invoke-virtual {v0, v3}, Landroid/view/ViewGroup;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 406
    const v2, 0x7f0a01ca

    invoke-virtual {v9, v2}, Lco/vine/android/AbstractRecordingActivity;->findViewById(I)Landroid/view/View;

    move-result-object v57

    .end local v57    # "trigger":Landroid/view/ViewGroup;
    check-cast v57, Landroid/view/ViewGroup;

    .line 407
    .restart local v57    # "trigger":Landroid/view/ViewGroup;
    new-instance v3, Lco/vine/android/RecordingFragment$PlusMinusTouchListener;

    const/4 v2, 0x0

    move-object/from16 v0, v57

    invoke-virtual {v0, v2}, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ImageView;

    const v4, 0x7f020297

    move-object/from16 v0, p0

    invoke-direct {v3, v0, v2, v4}, Lco/vine/android/RecordingFragment$PlusMinusTouchListener;-><init>(Lco/vine/android/RecordingFragment;Landroid/widget/ImageView;I)V

    move-object/from16 v0, v57

    invoke-virtual {v0, v3}, Landroid/view/ViewGroup;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 408
    const v2, 0x7f0a01c9

    invoke-virtual {v9, v2}, Lco/vine/android/AbstractRecordingActivity;->findViewById(I)Landroid/view/View;

    move-result-object v53

    .line 409
    .local v53, "container":Landroid/view/View;
    invoke-virtual/range {v53 .. v53}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v55

    .line 410
    .local v55, "params":Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/RecordingFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-static {v2}, Lco/vine/android/util/SystemUtil;->getDisplaySize(Landroid/app/Activity;)Landroid/graphics/Point;

    move-result-object v2

    iget v2, v2, Landroid/graphics/Point;->x:I

    int-to-double v2, v2

    const-wide v4, 0x3fe999999999999aL    # 0.8

    mul-double/2addr v2, v4

    invoke-virtual {v9}, Lco/vine/android/AbstractRecordingActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    invoke-virtual {v4}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v4

    iget v4, v4, Landroid/util/DisplayMetrics;->density:F

    const/high16 v5, 0x40000000    # 2.0f

    mul-float/2addr v4, v5

    const/high16 v5, 0x42100000    # 36.0f

    mul-float/2addr v4, v5

    float-to-double v4, v4

    sub-double/2addr v2, v4

    double-to-int v2, v2

    move-object/from16 v0, v55

    iput v2, v0, Landroid/view/ViewGroup$LayoutParams;->width:I

    .line 411
    move-object/from16 v0, v53

    move-object/from16 v1, v55

    invoke-virtual {v0, v1}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 413
    new-instance v2, Lco/vine/android/recorder/VineRecorder;

    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/RecordingFragment;->mVersion:Lco/vine/android/recorder/RecordSessionVersion;

    move-object/from16 v0, p0

    iget-boolean v4, v0, Lco/vine/android/RecordingFragment;->mStartWithEdit:Z

    invoke-virtual {v9}, Lco/vine/android/AbstractRecordingActivity;->getScreenSize()Landroid/graphics/Point;

    move-result-object v5

    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/RecordingFragment;->mFileFileToUse:Lco/vine/android/recorder/RecordingFile;

    if-eqz v6, :cond_3

    move-object/from16 v0, p0

    iget-boolean v6, v0, Lco/vine/android/RecordingFragment;->mStartWithEdit:Z

    if-eqz v6, :cond_3

    const/4 v6, 0x1

    :goto_0
    invoke-virtual {v9}, Lco/vine/android/AbstractRecordingActivity;->hasPreviewedAlready()Z

    move-result v7

    const/4 v8, 0x1

    move-object/from16 v0, p0

    invoke-direct {v0, v8}, Lco/vine/android/RecordingFragment;->determineSessionFileForSwap(Z)Lco/vine/android/recorder/RecordingFile;

    move-result-object v8

    const v10, 0x7f0a0178

    invoke-virtual {v9, v10}, Lco/vine/android/AbstractRecordingActivity;->findViewById(I)Landroid/view/View;

    move-result-object v10

    check-cast v10, Lco/vine/android/player/SdkVideoView;

    const v11, 0x7f0a01be

    const v12, 0x7f0a01ac

    const v13, 0x7f0a01c1

    const v14, 0x7f0a01ce

    const v15, 0x7f0a01b3

    const v18, 0x7f0a01c2

    const v19, 0x7f0a00b2

    const v20, 0x7f0a009f

    const v21, 0x7f0a01bf

    const/16 v22, -0x1

    const v23, 0x7f0a01bc

    const v24, 0x7f0a00a0

    const v25, 0x7f0a00a3

    const v26, 0x7f0a01b4

    const v27, 0x7f0a01b6

    const v28, 0x7f0a01b5

    const v29, 0x7f0a01b7

    const v30, 0x7f0a01b8

    const v31, 0x7f0a01b9

    const v32, 0x7f0e00f9

    const v33, 0x7f0e0054

    const v34, 0x7f0e0167

    const v35, 0x7f0a01af

    const v36, 0x7f0a01ad

    const v37, 0x7f0a011d

    const v38, 0x7f0b003c

    move-object/from16 v0, v56

    move/from16 v1, v38

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v38

    const v39, 0x7f0b0038

    move-object/from16 v0, v56

    move/from16 v1, v39

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v39

    const v40, 0x7f0a01b2

    const v41, 0x7f0a01ae

    const v42, 0x7f0a00dc

    const v43, 0x7f0e0256

    move-object/from16 v0, p0

    move/from16 v1, v43

    invoke-virtual {v0, v1}, Lco/vine/android/RecordingFragment;->getString(I)Ljava/lang/String;

    move-result-object v43

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/RecordingFragment;->mGhostButton:Landroid/widget/ToggleButton;

    move-object/from16 v44, v0

    const/16 v45, 0x0

    move-object/from16 v0, p0

    iget-boolean v0, v0, Lco/vine/android/RecordingFragment;->mIsMessaging:Z

    move/from16 v46, v0

    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/RecordingFragment;->mColor:I

    move/from16 v47, v0

    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/RecordingFragment;->mHalfColor:I

    move/from16 v48, v0

    const v49, 0x7f0a01c7

    const v50, 0x7f0a01c9

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/RecordingFragment;->mMediaActionSound:Landroid/media/MediaActionSound;

    move-object/from16 v51, v0

    const/16 v52, 0x4

    move/from16 v0, v52

    new-array v0, v0, [Ljava/lang/CharSequence;

    move-object/from16 v52, v0

    const/16 v58, 0x0

    const v59, 0x7f0e0106

    move-object/from16 v0, p0

    move/from16 v1, v59

    invoke-virtual {v0, v1}, Lco/vine/android/RecordingFragment;->getText(I)Ljava/lang/CharSequence;

    move-result-object v59

    aput-object v59, v52, v58

    const/16 v58, 0x1

    const v59, 0x7f0e00f6

    move-object/from16 v0, p0

    move/from16 v1, v59

    invoke-virtual {v0, v1}, Lco/vine/android/RecordingFragment;->getText(I)Ljava/lang/CharSequence;

    move-result-object v59

    aput-object v59, v52, v58

    const/16 v58, 0x2

    const v59, 0x7f0e00f7

    move-object/from16 v0, p0

    move/from16 v1, v59

    invoke-virtual {v0, v1}, Lco/vine/android/RecordingFragment;->getText(I)Ljava/lang/CharSequence;

    move-result-object v59

    aput-object v59, v52, v58

    const/16 v58, 0x3

    const v59, 0x7f0e00f8

    move-object/from16 v0, p0

    move/from16 v1, v59

    invoke-virtual {v0, v1}, Lco/vine/android/RecordingFragment;->getText(I)Ljava/lang/CharSequence;

    move-result-object v59

    aput-object v59, v52, v58

    invoke-direct/range {v2 .. v52}, Lco/vine/android/recorder/VineRecorder;-><init>(Lco/vine/android/recorder/RecordSessionVersion;ZLandroid/graphics/Point;ZZLco/vine/android/recorder/RecordingFile;Landroid/app/Activity;Lco/vine/android/player/SdkVideoView;IIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIILjava/lang/String;Landroid/widget/ToggleButton;ZZIIIILandroid/media/MediaActionSound;[Ljava/lang/CharSequence;)V

    move-object/from16 v0, p0

    iput-object v2, v0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    .line 462
    new-instance v2, Lco/vine/android/RecordingFragment$6;

    move-object/from16 v0, p0

    invoke-direct {v2, v0}, Lco/vine/android/RecordingFragment$6;-><init>(Lco/vine/android/RecordingFragment;)V

    invoke-static {v2}, Lco/vine/android/recorder/RecordingAnimations;->getShowGridAinimation(Lco/vine/android/animation/SimpleAnimationListener;)Landroid/view/animation/AlphaAnimation;

    move-result-object v2

    move-object/from16 v0, p0

    iput-object v2, v0, Lco/vine/android/RecordingFragment;->mShowGridAnimation:Landroid/view/animation/AlphaAnimation;

    .line 479
    new-instance v2, Lco/vine/android/RecordingFragment$7;

    move-object/from16 v0, p0

    invoke-direct {v2, v0}, Lco/vine/android/RecordingFragment$7;-><init>(Lco/vine/android/RecordingFragment;)V

    invoke-static {v2}, Lco/vine/android/recorder/RecordingAnimations;->getGridDimissAnimation(Lco/vine/android/animation/SimpleAnimationListener;)Landroid/view/animation/AlphaAnimation;

    move-result-object v2

    move-object/from16 v0, p0

    iput-object v2, v0, Lco/vine/android/RecordingFragment;->mDismissGridAnimation:Landroid/view/animation/AlphaAnimation;

    .line 491
    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/RecordingFragment;->mGrid:Landroid/view/View;

    invoke-virtual {v2}, Landroid/view/View;->getVisibility()I

    move-result v2

    if-nez v2, :cond_1

    .line 492
    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/RecordingFragment;->mGrid:Landroid/view/View;

    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/RecordingFragment;->mDismissGridAnimation:Landroid/view/animation/AlphaAnimation;

    invoke-virtual {v2, v3}, Landroid/view/View;->startAnimation(Landroid/view/animation/Animation;)V

    .line 494
    :cond_1
    move-object/from16 v0, p0

    iget-boolean v2, v0, Lco/vine/android/RecordingFragment;->mIsVmOnboarding:Z

    if-eqz v2, :cond_2

    .line 495
    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/RecordingFragment;->mVmOnboardOverlay:Landroid/view/ViewGroup;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 496
    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/RecordingFragment;->mVmOnboardOverlay:Landroid/view/ViewGroup;

    new-instance v3, Lco/vine/android/RecordingFragment$8;

    move-object/from16 v0, p0

    invoke-direct {v3, v0}, Lco/vine/android/RecordingFragment$8;-><init>(Lco/vine/android/RecordingFragment;)V

    invoke-virtual {v2, v3}, Landroid/view/ViewGroup;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/VerifyError; {:try_start_0 .. :try_end_0} :catch_2

    .line 510
    :cond_2
    :try_start_1
    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    invoke-virtual {v2}, Lco/vine/android/recorder/VineRecorder;->playStartRecordingSound()V
    :try_end_1
    .catch Ljava/lang/NullPointerException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_1
    .catch Ljava/lang/VerifyError; {:try_start_1 .. :try_end_1} :catch_2

    .line 522
    .end local v16    # "focusEnabled":I
    .end local v17    # "focusDisabled":I
    .end local v53    # "container":Landroid/view/View;
    .end local v55    # "params":Landroid/view/ViewGroup$LayoutParams;
    .end local v56    # "res":Landroid/content/res/Resources;
    .end local v57    # "trigger":Landroid/view/ViewGroup;
    :goto_1
    return-void

    .line 413
    .restart local v16    # "focusEnabled":I
    .restart local v17    # "focusDisabled":I
    .restart local v53    # "container":Landroid/view/View;
    .restart local v55    # "params":Landroid/view/ViewGroup$LayoutParams;
    .restart local v56    # "res":Landroid/content/res/Resources;
    .restart local v57    # "trigger":Landroid/view/ViewGroup;
    :cond_3
    const/4 v6, 0x0

    goto/16 :goto_0

    .line 511
    :catch_0
    move-exception v54

    .line 512
    .local v54, "e":Ljava/lang/NullPointerException;
    :try_start_2
    const-string v2, "NPE when playing sound"

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/Object;

    move-object/from16 v0, v54

    invoke-static {v0, v2, v3}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_1
    .catch Ljava/lang/VerifyError; {:try_start_2 .. :try_end_2} :catch_2

    goto :goto_1

    .line 514
    .end local v16    # "focusEnabled":I
    .end local v17    # "focusDisabled":I
    .end local v53    # "container":Landroid/view/View;
    .end local v54    # "e":Ljava/lang/NullPointerException;
    .end local v55    # "params":Landroid/view/ViewGroup$LayoutParams;
    .end local v56    # "res":Landroid/content/res/Resources;
    .end local v57    # "trigger":Landroid/view/ViewGroup;
    :catch_1
    move-exception v54

    .line 515
    .local v54, "e":Ljava/io/IOException;
    const-string v2, "Error creating folder. "

    move-object/from16 v0, v54

    invoke-static {v2, v0}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 516
    const v2, 0x7f0e0232

    const/4 v3, 0x0

    invoke-static {v9, v2, v3}, Landroid/widget/Toast;->makeText(Landroid/content/Context;II)Landroid/widget/Toast;

    move-result-object v2

    invoke-virtual {v2}, Landroid/widget/Toast;->show()V

    .line 517
    invoke-virtual {v9}, Lco/vine/android/AbstractRecordingActivity;->finish()V

    goto :goto_1

    .line 518
    .end local v54    # "e":Ljava/io/IOException;
    :catch_2
    move-exception v54

    .line 519
    .local v54, "e":Ljava/lang/VerifyError;
    const-string v2, "Invalid recorder object."

    invoke-static {v2}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;)V

    .line 520
    invoke-virtual {v9}, Lco/vine/android/AbstractRecordingActivity;->finish()V

    goto :goto_1
.end method

.method public onCameraSwitchPressed(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 814
    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    if-eqz v0, :cond_0

    .line 815
    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    invoke-virtual {v0, p1}, Lco/vine/android/recorder/VineRecorder;->onCameraSwitcherPressed(Landroid/view/View;)V

    .line 817
    :cond_0
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const v3, 0xffffff

    const/4 v2, 0x0

    .line 544
    invoke-super {p0, p1}, Lco/vine/android/BaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 545
    invoke-virtual {p0}, Lco/vine/android/RecordingFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    .line 546
    .local v0, "args":Landroid/os/Bundle;
    const-string v1, "arg_encoder_version"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getSerializable(Ljava/lang/String;)Ljava/io/Serializable;

    move-result-object v1

    check-cast v1, Lco/vine/android/recorder/RecordSessionVersion;

    iput-object v1, p0, Lco/vine/android/RecordingFragment;->mVersion:Lco/vine/android/recorder/RecordSessionVersion;

    .line 547
    iget-object v1, p0, Lco/vine/android/RecordingFragment;->mVersion:Lco/vine/android/recorder/RecordSessionVersion;

    if-nez v1, :cond_0

    .line 548
    invoke-virtual {p0}, Lco/vine/android/RecordingFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-static {v1}, Lco/vine/android/recorder/RecordSessionManager;->getCurrentVersion(Landroid/content/Context;)Lco/vine/android/recorder/RecordSessionVersion;

    move-result-object v1

    iput-object v1, p0, Lco/vine/android/RecordingFragment;->mVersion:Lco/vine/android/recorder/RecordSessionVersion;

    .line 550
    :cond_0
    const-string v1, "arg_top_overlay"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v1

    check-cast v1, Landroid/graphics/Bitmap;

    iput-object v1, p0, Lco/vine/android/RecordingFragment;->mTopOverlay:Landroid/graphics/Bitmap;

    .line 551
    const-string v1, "screen_size"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v1

    check-cast v1, Landroid/graphics/Point;

    iput-object v1, p0, Lco/vine/android/RecordingFragment;->mScreenSize:Landroid/graphics/Point;

    .line 552
    const-string v1, "is_messaging"

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v1

    iput-boolean v1, p0, Lco/vine/android/RecordingFragment;->mIsMessaging:Z

    .line 553
    const-string v1, "is_vm_onboarding"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v1

    iput-boolean v1, p0, Lco/vine/android/RecordingFragment;->mIsVmOnboarding:Z

    .line 554
    const-string v1, "recipient_username"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lco/vine/android/RecordingFragment;->mRecipientUsername:Ljava/lang/String;

    .line 555
    const-string v1, "color"

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v1

    iput v1, p0, Lco/vine/android/RecordingFragment;->mColor:I

    .line 556
    iget v1, p0, Lco/vine/android/RecordingFragment;->mColor:I

    sget v2, Lco/vine/android/Settings;->DEFAULT_PROFILE_COLOR:I

    if-eq v1, v2, :cond_1

    iget v1, p0, Lco/vine/android/RecordingFragment;->mColor:I

    if-gtz v1, :cond_2

    .line 557
    :cond_1
    invoke-virtual {p0}, Lco/vine/android/RecordingFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f090096

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    and-int/2addr v1, v3

    iput v1, p0, Lco/vine/android/RecordingFragment;->mColor:I

    .line 559
    :cond_2
    iget-boolean v1, p0, Lco/vine/android/RecordingFragment;->mIsMessaging:Z

    if-nez v1, :cond_3

    .line 560
    iput v3, p0, Lco/vine/android/RecordingFragment;->mColor:I

    .line 562
    :cond_3
    iget v1, p0, Lco/vine/android/RecordingFragment;->mColor:I

    const/high16 v2, 0x5a000000

    or-int/2addr v1, v2

    iput v1, p0, Lco/vine/android/RecordingFragment;->mHalfColor:I

    .line 563
    iget v1, p0, Lco/vine/android/RecordingFragment;->mColor:I

    const/high16 v2, -0x1000000

    or-int/2addr v1, v2

    iput v1, p0, Lco/vine/android/RecordingFragment;->mColor:I

    .line 564
    invoke-virtual {p0}, Lco/vine/android/RecordingFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const v2, 0x7f04000d

    invoke-static {v1, v2}, Landroid/view/animation/AnimationUtils;->loadAnimation(Landroid/content/Context;I)Landroid/view/animation/Animation;

    move-result-object v1

    iput-object v1, p0, Lco/vine/android/RecordingFragment;->mFadeIn:Landroid/view/animation/Animation;

    .line 565
    invoke-virtual {p0}, Lco/vine/android/RecordingFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const v2, 0x7f04000f

    invoke-static {v1, v2}, Landroid/view/animation/AnimationUtils;->loadAnimation(Landroid/content/Context;I)Landroid/view/animation/Animation;

    move-result-object v1

    iput-object v1, p0, Lco/vine/android/RecordingFragment;->mFadeOut:Landroid/view/animation/Animation;

    .line 567
    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0x10

    if-lt v1, v2, :cond_4

    .line 568
    new-instance v1, Landroid/media/MediaActionSound;

    invoke-direct {v1}, Landroid/media/MediaActionSound;-><init>()V

    iput-object v1, p0, Lco/vine/android/RecordingFragment;->mMediaActionSound:Landroid/media/MediaActionSound;

    .line 569
    iget-object v1, p0, Lco/vine/android/RecordingFragment;->mMediaActionSound:Landroid/media/MediaActionSound;

    const/4 v2, 0x2

    invoke-virtual {v1, v2}, Landroid/media/MediaActionSound;->load(I)V

    .line 570
    iget-object v1, p0, Lco/vine/android/RecordingFragment;->mMediaActionSound:Landroid/media/MediaActionSound;

    const/4 v2, 0x3

    invoke-virtual {v1, v2}, Landroid/media/MediaActionSound;->load(I)V

    .line 572
    :cond_4
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 20
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 577
    const v17, 0x7f030084

    const/16 v18, 0x0

    move-object/from16 v0, p1

    move/from16 v1, v17

    move-object/from16 v2, p2

    move/from16 v3, v18

    invoke-virtual {v0, v1, v2, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v15

    .line 578
    .local v15, "view":Landroid/view/View;
    const v17, 0x7f0a00a0

    move/from16 v0, v17

    invoke-virtual {v15, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v13

    .line 579
    .local v13, "topMask":Landroid/view/View;
    const v17, 0x7f0a00a3

    move/from16 v0, v17

    invoke-virtual {v15, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v6

    .line 581
    .local v6, "bottomMask":Landroid/view/View;
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/RecordingFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v11

    .line 582
    .local v11, "res":Landroid/content/res/Resources;
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lco/vine/android/RecordingFragment;->mIsMessaging:Z

    move/from16 v17, v0

    if-eqz v17, :cond_0

    .line 583
    const v17, 0x7f090025

    move/from16 v0, v17

    invoke-virtual {v11, v0}, Landroid/content/res/Resources;->getColor(I)I

    move-result v7

    .line 584
    .local v7, "color":I
    invoke-virtual {v13, v7}, Landroid/view/View;->setBackgroundColor(I)V

    .line 585
    invoke-virtual {v6, v7}, Landroid/view/View;->setBackgroundColor(I)V

    .line 587
    const v17, 0x7f0a00b2

    move/from16 v0, v17

    invoke-virtual {v15, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v10

    .line 588
    .local v10, "progress":Landroid/view/View;
    invoke-virtual {v10, v7}, Landroid/view/View;->setBackgroundColor(I)V

    .line 591
    .end local v7    # "color":I
    .end local v10    # "progress":Landroid/view/View;
    :cond_0
    const v17, 0x7f0a01c2

    move/from16 v0, v17

    invoke-virtual {v15, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v17

    move-object/from16 v0, v17

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/RecordingFragment;->mFocusButton:Landroid/view/View;

    .line 592
    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/RecordingFragment;->mColor:I

    move/from16 v17, v0

    const v18, 0x7f020182

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/RecordingFragment;->mFocusButton:Landroid/view/View;

    move-object/from16 v19, v0

    move/from16 v0, v17

    move/from16 v1, v18

    move-object/from16 v2, v19

    invoke-static {v11, v0, v1, v2}, Lco/vine/android/util/ViewUtil;->fillColor(Landroid/content/res/Resources;IILandroid/view/View;)V

    .line 593
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/RecordingFragment;->mFocusButton:Landroid/view/View;

    move-object/from16 v17, v0

    const v18, 0x3eb33333    # 0.35f

    invoke-virtual/range {v17 .. v18}, Landroid/view/View;->setAlpha(F)V

    .line 595
    const v17, 0x7f0a01c0

    move/from16 v0, v17

    invoke-virtual {v15, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v12

    .line 596
    .local v12, "switchCameraButton":Landroid/view/View;
    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/RecordingFragment;->mColor:I

    move/from16 v17, v0

    const v18, 0x7f020188

    move/from16 v0, v17

    move/from16 v1, v18

    invoke-static {v11, v0, v1, v12}, Lco/vine/android/util/ViewUtil;->fillColor(Landroid/content/res/Resources;IILandroid/view/View;)V

    .line 597
    const v17, 0x3eb33333    # 0.35f

    move/from16 v0, v17

    invoke-virtual {v12, v0}, Landroid/view/View;->setAlpha(F)V

    .line 599
    new-instance v17, Lco/vine/android/RecordingFragment$9;

    move-object/from16 v0, v17

    move-object/from16 v1, p0

    invoke-direct {v0, v1, v11, v12}, Lco/vine/android/RecordingFragment$9;-><init>(Lco/vine/android/RecordingFragment;Landroid/content/res/Resources;Landroid/view/View;)V

    move-object/from16 v0, v17

    invoke-virtual {v12, v0}, Landroid/view/View;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 626
    const v17, 0x7f0a01bb

    move/from16 v0, v17

    invoke-virtual {v15, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v16

    .line 627
    .local v16, "xButton":Landroid/view/View;
    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/RecordingFragment;->mColor:I

    move/from16 v17, v0

    const v18, 0x7f020213

    move/from16 v0, v17

    move/from16 v1, v18

    move-object/from16 v2, v16

    invoke-static {v11, v0, v1, v2}, Lco/vine/android/util/ViewUtil;->fillColor(Landroid/content/res/Resources;IILandroid/view/View;)V

    .line 629
    const v17, 0x7f0a01bd

    move/from16 v0, v17

    invoke-virtual {v15, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    .line 630
    .local v5, "arrow":Landroid/view/View;
    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/RecordingFragment;->mColor:I

    move/from16 v17, v0

    const v18, 0x7f02014e

    move/from16 v0, v17

    move/from16 v1, v18

    invoke-static {v11, v0, v1, v5}, Lco/vine/android/util/ViewUtil;->fillColor(Landroid/content/res/Resources;IILandroid/view/View;)V

    .line 632
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lco/vine/android/RecordingFragment;->mIsMessaging:Z

    move/from16 v17, v0

    if-eqz v17, :cond_2

    .line 633
    const v17, 0x7f0a0181

    move/from16 v0, v17

    invoke-virtual {v15, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v8

    check-cast v8, Lco/vine/android/widget/TypefacesTextView;

    .line 634
    .local v8, "name":Lco/vine/android/widget/TypefacesTextView;
    const/16 v17, 0x3

    move/from16 v0, v17

    invoke-virtual {v8, v0}, Lco/vine/android/widget/TypefacesTextView;->setWeight(I)V

    .line 635
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/RecordingFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v17

    invoke-static/range {v17 .. v17}, Lco/vine/android/widget/Typefaces;->get(Landroid/content/Context;)Lco/vine/android/widget/Typefaces;

    move-result-object v17

    move-object/from16 v0, v17

    iget-object v0, v0, Lco/vine/android/widget/Typefaces;->mediumContent:Landroid/graphics/Typeface;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    invoke-virtual {v8, v0}, Lco/vine/android/widget/TypefacesTextView;->setTypeface(Landroid/graphics/Typeface;)V

    .line 636
    const/16 v17, 0x0

    move/from16 v0, v17

    invoke-virtual {v8, v0}, Lco/vine/android/widget/TypefacesTextView;->setVisibility(I)V

    .line 637
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/RecordingFragment;->mRecipientUsername:Ljava/lang/String;

    move-object/from16 v17, v0

    invoke-static/range {v17 .. v17}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v17

    if-nez v17, :cond_1

    .line 638
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/RecordingFragment;->mRecipientUsername:Ljava/lang/String;

    move-object/from16 v17, v0

    invoke-static/range {v17 .. v17}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v17

    if-nez v17, :cond_1

    .line 639
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/RecordingFragment;->mRecipientUsername:Ljava/lang/String;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    invoke-virtual {v8, v0}, Lco/vine/android/widget/TypefacesTextView;->setText(Ljava/lang/CharSequence;)V

    .line 642
    :cond_1
    const v17, 0x7f0a00b2

    move/from16 v0, v17

    invoke-virtual {v15, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v9

    check-cast v9, Lco/vine/android/recorder/ProgressView;

    .line 643
    .local v9, "pg":Lco/vine/android/recorder/ProgressView;
    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/RecordingFragment;->mHalfColor:I

    move/from16 v17, v0

    move/from16 v0, v17

    invoke-virtual {v9, v0}, Lco/vine/android/recorder/ProgressView;->setColor(I)V

    .line 646
    .end local v8    # "name":Lco/vine/android/widget/TypefacesTextView;
    .end local v9    # "pg":Lco/vine/android/recorder/ProgressView;
    :cond_2
    const v17, 0x7f0a01c1

    move/from16 v0, v17

    invoke-virtual {v15, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v17

    check-cast v17, Landroid/widget/ToggleButton;

    move-object/from16 v0, v17

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/RecordingFragment;->mGridButton:Landroid/widget/ToggleButton;

    .line 647
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/RecordingFragment;->mGridButton:Landroid/widget/ToggleButton;

    move-object/from16 v17, v0

    const/16 v18, 0x0

    invoke-virtual/range {v17 .. v18}, Landroid/widget/ToggleButton;->setText(Ljava/lang/CharSequence;)V

    .line 648
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/RecordingFragment;->mGridButton:Landroid/widget/ToggleButton;

    move-object/from16 v17, v0

    const/16 v18, 0x0

    invoke-virtual/range {v17 .. v18}, Landroid/widget/ToggleButton;->setTextOn(Ljava/lang/CharSequence;)V

    .line 649
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/RecordingFragment;->mGridButton:Landroid/widget/ToggleButton;

    move-object/from16 v17, v0

    const/16 v18, 0x0

    invoke-virtual/range {v17 .. v18}, Landroid/widget/ToggleButton;->setTextOff(Ljava/lang/CharSequence;)V

    .line 650
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/RecordingFragment;->mGridButton:Landroid/widget/ToggleButton;

    move-object/from16 v17, v0

    new-instance v18, Lco/vine/android/RecordingFragment$10;

    move-object/from16 v0, v18

    move-object/from16 v1, p0

    invoke-direct {v0, v1, v11}, Lco/vine/android/RecordingFragment$10;-><init>(Lco/vine/android/RecordingFragment;Landroid/content/res/Resources;)V

    invoke-virtual/range {v17 .. v18}, Landroid/widget/ToggleButton;->setOnCheckedChangeListener(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V

    .line 664
    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/RecordingFragment;->mColor:I

    move/from16 v17, v0

    const v18, 0x7f02018e

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/RecordingFragment;->mGridButton:Landroid/widget/ToggleButton;

    move-object/from16 v19, v0

    move/from16 v0, v17

    move/from16 v1, v18

    move-object/from16 v2, v19

    invoke-static {v11, v0, v1, v2}, Lco/vine/android/util/ViewUtil;->fillColor(Landroid/content/res/Resources;IILandroid/view/View;)V

    .line 665
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/RecordingFragment;->mGridButton:Landroid/widget/ToggleButton;

    move-object/from16 v17, v0

    const v18, 0x3eb33333    # 0.35f

    invoke-virtual/range {v17 .. v18}, Landroid/widget/ToggleButton;->setAlpha(F)V

    .line 667
    const v17, 0x7f0a0129

    move/from16 v0, v17

    invoke-virtual {v15, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v17

    move-object/from16 v0, v17

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/RecordingFragment;->mGrid:Landroid/view/View;

    .line 668
    const v17, 0x7f0a00dc

    move/from16 v0, v17

    invoke-virtual {v15, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v14

    .line 669
    .local v14, "topOverlayView":Landroid/view/View;
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/RecordingFragment;->mTopOverlay:Landroid/graphics/Bitmap;

    move-object/from16 v17, v0

    if-eqz v17, :cond_3

    .line 670
    const/16 v17, 0x0

    move/from16 v0, v17

    invoke-virtual {v14, v0}, Landroid/view/View;->setVisibility(I)V

    .line 671
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/RecordingFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v17

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/RecordingFragment;->mTopOverlay:Landroid/graphics/Bitmap;

    move-object/from16 v18, v0

    move-object/from16 v0, v17

    move-object/from16 v1, v18

    invoke-static {v0, v14, v1}, Lco/vine/android/util/ViewUtil;->setBackground(Landroid/content/res/Resources;Landroid/view/View;Landroid/graphics/Bitmap;)V

    .line 675
    :goto_0
    const v17, 0x7f0a01c3

    move/from16 v0, v17

    invoke-virtual {v15, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v17

    check-cast v17, Landroid/widget/ToggleButton;

    move-object/from16 v0, v17

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/RecordingFragment;->mGhostButton:Landroid/widget/ToggleButton;

    .line 676
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/RecordingFragment;->mGhostButton:Landroid/widget/ToggleButton;

    move-object/from16 v17, v0

    const/16 v18, 0x0

    invoke-virtual/range {v17 .. v18}, Landroid/widget/ToggleButton;->setText(Ljava/lang/CharSequence;)V

    .line 677
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/RecordingFragment;->mGhostButton:Landroid/widget/ToggleButton;

    move-object/from16 v17, v0

    const/16 v18, 0x0

    invoke-virtual/range {v17 .. v18}, Landroid/widget/ToggleButton;->setTextOn(Ljava/lang/CharSequence;)V

    .line 678
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/RecordingFragment;->mGhostButton:Landroid/widget/ToggleButton;

    move-object/from16 v17, v0

    const/16 v18, 0x0

    invoke-virtual/range {v17 .. v18}, Landroid/widget/ToggleButton;->setTextOff(Ljava/lang/CharSequence;)V

    .line 679
    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/RecordingFragment;->mColor:I

    move/from16 v17, v0

    const v18, 0x7f02018b

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/RecordingFragment;->mGhostButton:Landroid/widget/ToggleButton;

    move-object/from16 v19, v0

    move/from16 v0, v17

    move/from16 v1, v18

    move-object/from16 v2, v19

    invoke-static {v11, v0, v1, v2}, Lco/vine/android/util/ViewUtil;->fillColor(Landroid/content/res/Resources;IILandroid/view/View;)V

    .line 680
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/RecordingFragment;->mGhostButton:Landroid/widget/ToggleButton;

    move-object/from16 v17, v0

    const v18, 0x3eb33333    # 0.35f

    invoke-virtual/range {v17 .. v18}, Landroid/widget/ToggleButton;->setAlpha(F)V

    .line 681
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/RecordingFragment;->mGhostButton:Landroid/widget/ToggleButton;

    move-object/from16 v17, v0

    new-instance v18, Lco/vine/android/RecordingFragment$11;

    move-object/from16 v0, v18

    move-object/from16 v1, p0

    invoke-direct {v0, v1, v11}, Lco/vine/android/RecordingFragment$11;-><init>(Lco/vine/android/RecordingFragment;Landroid/content/res/Resources;)V

    invoke-virtual/range {v17 .. v18}, Landroid/widget/ToggleButton;->setOnCheckedChangeListener(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V

    .line 694
    const v17, 0x7f0a01c6

    move/from16 v0, v17

    invoke-virtual {v15, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v17

    check-cast v17, Landroid/widget/ProgressBar;

    move-object/from16 v0, v17

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/RecordingFragment;->mUpgradeSpinner:Landroid/widget/ProgressBar;

    .line 695
    const v17, 0x7f0a01c5

    move/from16 v0, v17

    invoke-virtual {v15, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v17

    check-cast v17, Landroid/widget/TextView;

    move-object/from16 v0, v17

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/RecordingFragment;->mDraftsButton:Landroid/widget/TextView;

    .line 696
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/RecordingFragment;->mDraftsButton:Landroid/widget/TextView;

    move-object/from16 v17, v0

    const v18, 0x3eb33333    # 0.35f

    invoke-virtual/range {v17 .. v18}, Landroid/widget/TextView;->setAlpha(F)V

    .line 697
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/RecordingFragment;->mDraftsButton:Landroid/widget/TextView;

    move-object/from16 v17, v0

    new-instance v18, Lco/vine/android/RecordingFragment$12;

    move-object/from16 v0, v18

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lco/vine/android/RecordingFragment$12;-><init>(Lco/vine/android/RecordingFragment;)V

    invoke-virtual/range {v17 .. v18}, Landroid/widget/TextView;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 714
    invoke-direct/range {p0 .. p0}, Lco/vine/android/RecordingFragment;->refreshDraftNumber()V

    .line 716
    const v17, 0x7f0a01be

    move/from16 v0, v17

    invoke-virtual {v15, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v17

    move-object/from16 v0, v17

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/RecordingFragment;->mRecordingOptions:Landroid/view/View;

    .line 717
    const v17, 0x7f0a01cf

    move/from16 v0, v17

    invoke-virtual {v15, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v17

    move-object/from16 v0, v17

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/RecordingFragment;->mNoDraftsOverlay:Landroid/view/View;

    .line 718
    const v17, 0x7f0a01cc

    move/from16 v0, v17

    invoke-virtual {v15, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v17

    check-cast v17, Landroid/view/ViewGroup;

    move-object/from16 v0, v17

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/RecordingFragment;->mVmOnboardOverlay:Landroid/view/ViewGroup;

    .line 720
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/RecordingFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v4

    check-cast v4, Lco/vine/android/AbstractRecordingActivity;

    .line 722
    .local v4, "activity":Lco/vine/android/AbstractRecordingActivity;
    invoke-virtual {v4, v13, v6}, Lco/vine/android/AbstractRecordingActivity;->initMasks(Landroid/view/View;Landroid/view/View;)V

    .line 724
    return-object v15

    .line 673
    .end local v4    # "activity":Lco/vine/android/AbstractRecordingActivity;
    :cond_3
    const/16 v17, 0x8

    move/from16 v0, v17

    invoke-virtual {v14, v0}, Landroid/view/View;->setVisibility(I)V

    goto/16 :goto_0
.end method

.method public onDestroy()V
    .locals 0

    .prologue
    .line 234
    invoke-super {p0}, Lco/vine/android/BaseFragment;->onDestroy()V

    .line 235
    invoke-virtual {p0}, Lco/vine/android/RecordingFragment;->release()V

    .line 236
    return-void
.end method

.method public onDraftUpgradeNumberChanged(I)V
    .locals 4
    .param p1, "count"    # I

    .prologue
    const/16 v3, 0x8

    const/4 v2, 0x0

    .line 338
    const-string v0, "Draft upgrade number changed with count {}"

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 339
    iput p1, p0, Lco/vine/android/RecordingFragment;->mDraftUpgradeCount:I

    .line 340
    iget-boolean v0, p0, Lco/vine/android/RecordingFragment;->mIsDraftUpgradeAnimationRunning:Z

    if-eqz v0, :cond_0

    .line 341
    if-lez p1, :cond_1

    .line 342
    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mUpgradeSpinner:Landroid/widget/ProgressBar;

    invoke-virtual {v0, v2}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 343
    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mDraftsButton:Landroid/widget/TextView;

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setVisibility(I)V

    .line 349
    :cond_0
    :goto_0
    return-void

    .line 345
    :cond_1
    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mUpgradeSpinner:Landroid/widget/ProgressBar;

    invoke-virtual {v0, v3}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 346
    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mDraftsButton:Landroid/widget/TextView;

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_0
.end method

.method public onFinishPressed(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 808
    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    if-eqz v0, :cond_0

    .line 809
    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    invoke-virtual {v0}, Lco/vine/android/recorder/VineRecorder;->onFinishPressed()V

    .line 811
    :cond_0
    return-void
.end method

.method public onFocusSwitchPressed(Landroid/view/View;)V
    .locals 5
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 820
    iget-object v1, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    if-eqz v1, :cond_0

    .line 821
    iget-object v1, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    invoke-virtual {v1}, Lco/vine/android/recorder/VineRecorder;->canChangeFocus()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 822
    iget-object v1, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    invoke-virtual {v1}, Lco/vine/android/recorder/VineRecorder;->isAutoFocusing()Z

    move-result v1

    if-eqz v1, :cond_1

    const/high16 v0, 0x3f800000    # 1.0f

    .line 824
    .local v0, "alpha":F
    :goto_0
    invoke-virtual {p0}, Lco/vine/android/RecordingFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    iget v2, p0, Lco/vine/android/RecordingFragment;->mColor:I

    const v3, 0x7f020182

    iget-object v4, p0, Lco/vine/android/RecordingFragment;->mFocusButton:Landroid/view/View;

    invoke-static {v1, v2, v3, v4}, Lco/vine/android/util/ViewUtil;->fillColor(Landroid/content/res/Resources;IILandroid/view/View;)V

    .line 825
    iget-object v1, p0, Lco/vine/android/RecordingFragment;->mFocusButton:Landroid/view/View;

    invoke-virtual {v1, v0}, Landroid/view/View;->setAlpha(F)V

    .line 826
    iget-object v2, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    iget-object v1, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    invoke-virtual {v1}, Lco/vine/android/recorder/VineRecorder;->isAutoFocusing()Z

    move-result v1

    if-nez v1, :cond_2

    const/4 v1, 0x1

    :goto_1
    invoke-virtual {v2, v1}, Lco/vine/android/recorder/VineRecorder;->setAutoFocusing(Z)V

    .line 829
    .end local v0    # "alpha":F
    :cond_0
    return-void

    .line 822
    :cond_1
    const v0, 0x3eb33333    # 0.35f

    goto :goto_0

    .line 826
    .restart local v0    # "alpha":F
    :cond_2
    const/4 v1, 0x0

    goto :goto_1
.end method

.method public onGhostSwitchPressed(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 910
    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    if-eqz v0, :cond_0

    .line 911
    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    invoke-virtual {v0}, Lco/vine/android/recorder/VineRecorder;->onGhostSwitchPressed()Z

    .line 913
    :cond_0
    return-void
.end method

.method public onGridSwitchPressed()V
    .locals 4

    .prologue
    .line 895
    iget-object v1, p0, Lco/vine/android/RecordingFragment;->mSecretMode:Lco/vine/android/RecordingFragment$SecretModes;

    if-eqz v1, :cond_0

    .line 896
    invoke-static {}, Lco/vine/android/RecordingFragment$SecretModes;->values()[Lco/vine/android/RecordingFragment$SecretModes;

    move-result-object v0

    .line 897
    .local v0, "values":[Lco/vine/android/RecordingFragment$SecretModes;
    iget-object v1, p0, Lco/vine/android/RecordingFragment;->mSecretMode:Lco/vine/android/RecordingFragment$SecretModes;

    invoke-virtual {v1}, Lco/vine/android/RecordingFragment$SecretModes;->ordinal()I

    move-result v1

    add-int/lit8 v1, v1, 0x1

    array-length v2, v0

    rem-int/2addr v1, v2

    aget-object v1, v0, v1

    iput-object v1, p0, Lco/vine/android/RecordingFragment;->mSecretMode:Lco/vine/android/RecordingFragment$SecretModes;

    .line 898
    iget-object v1, p0, Lco/vine/android/RecordingFragment;->mSecretToast:Landroid/widget/Toast;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Secret Mode: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lco/vine/android/RecordingFragment;->mSecretMode:Lco/vine/android/RecordingFragment$SecretModes;

    invoke-virtual {v3}, Lco/vine/android/RecordingFragment$SecretModes;->name()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/Toast;->setText(Ljava/lang/CharSequence;)V

    .line 899
    iget-object v1, p0, Lco/vine/android/RecordingFragment;->mSecretToast:Landroid/widget/Toast;

    invoke-virtual {v1}, Landroid/widget/Toast;->show()V

    .line 907
    .end local v0    # "values":[Lco/vine/android/RecordingFragment$SecretModes;
    :goto_0
    return-void

    .line 901
    :cond_0
    iget-object v1, p0, Lco/vine/android/RecordingFragment;->mGrid:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->getVisibility()I

    move-result v1

    const/16 v2, 0x8

    if-ne v1, v2, :cond_1

    .line 902
    iget-object v1, p0, Lco/vine/android/RecordingFragment;->mGrid:Landroid/view/View;

    iget-object v2, p0, Lco/vine/android/RecordingFragment;->mShowGridAnimation:Landroid/view/animation/AlphaAnimation;

    invoke-virtual {v1, v2}, Landroid/view/View;->startAnimation(Landroid/view/animation/Animation;)V

    goto :goto_0

    .line 904
    :cond_1
    iget-object v1, p0, Lco/vine/android/RecordingFragment;->mGrid:Landroid/view/View;

    iget-object v2, p0, Lco/vine/android/RecordingFragment;->mDismissGridAnimation:Landroid/view/animation/AlphaAnimation;

    invoke-virtual {v1, v2}, Landroid/view/View;->startAnimation(Landroid/view/animation/Animation;)V

    goto :goto_0
.end method

.method public onHideDrafts()V
    .locals 2

    .prologue
    .line 1005
    invoke-direct {p0}, Lco/vine/android/RecordingFragment;->refreshDraftNumber()V

    .line 1006
    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mRecordingOptions:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setAlpha(F)V

    .line 1007
    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mRecordingOptions:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 1008
    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mRecordingOptions:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    const/high16 v1, 0x3f800000    # 1.0f

    invoke-virtual {v0, v1}, Landroid/view/ViewPropertyAnimator;->alpha(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/ViewPropertyAnimator;->start()V

    .line 1009
    return-void
.end method

.method public onPause()V
    .locals 1

    .prologue
    .line 196
    invoke-super {p0}, Lco/vine/android/BaseFragment;->onPause()V

    .line 197
    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    if-eqz v0, :cond_0

    .line 198
    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    invoke-virtual {v0}, Lco/vine/android/recorder/VineRecorder;->onUiPaused()V

    .line 199
    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    invoke-virtual {v0}, Lco/vine/android/recorder/VineRecorder;->playStopRecordingSound()V

    .line 201
    :cond_0
    return-void
.end method

.method public onResume()V
    .locals 7

    .prologue
    const/4 v3, 0x0

    .line 205
    invoke-super {p0}, Lco/vine/android/BaseFragment;->onResume()V

    .line 206
    iget-object v4, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    if-eqz v4, :cond_2

    .line 207
    invoke-virtual {p0}, Lco/vine/android/RecordingFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lco/vine/android/AbstractRecordingActivity;

    .line 208
    .local v0, "activity":Lco/vine/android/AbstractRecordingActivity;
    invoke-virtual {v0}, Lco/vine/android/AbstractRecordingActivity;->isDraftsShowing()Z

    move-result v2

    .line 210
    .local v2, "isDraftsShowing":Z
    if-nez v2, :cond_0

    .line 211
    invoke-direct {p0}, Lco/vine/android/RecordingFragment;->refreshDraftNumber()V

    .line 212
    iget-object v4, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    invoke-virtual {v4}, Lco/vine/android/recorder/VineRecorder;->getFile()Lco/vine/android/recorder/RecordingFile;

    move-result-object v1

    .line 213
    .local v1, "file":Lco/vine/android/recorder/RecordingFile;
    if-eqz v1, :cond_0

    .line 214
    iget-object v4, v1, Lco/vine/android/recorder/RecordingFile;->folder:Ljava/io/File;

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-nez v4, :cond_0

    .line 215
    new-instance v4, Lco/vine/android/VineLoggingException;

    const-string v5, "Invalid folder"

    invoke-direct {v4, v5}, Lco/vine/android/VineLoggingException;-><init>(Ljava/lang/String;)V

    invoke-static {v4}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;)V

    .line 216
    const/4 v4, 0x0

    invoke-virtual {p0, v4}, Lco/vine/android/RecordingFragment;->setFileFileToUse(Lco/vine/android/recorder/RecordingFile;)V

    .line 217
    iget-object v4, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    const-string v5, "Resume invalid."

    invoke-direct {p0, v3}, Lco/vine/android/RecordingFragment;->determineSessionFileForSwap(Z)Lco/vine/android/recorder/RecordingFile;

    move-result-object v6

    invoke-virtual {v4, v5, v6}, Lco/vine/android/recorder/VineRecorder;->swapSession(Ljava/lang/String;Lco/vine/android/recorder/RecordingFile;)Lco/vine/android/recorder/RecordingFile;

    .line 222
    .end local v1    # "file":Lco/vine/android/recorder/RecordingFile;
    :cond_0
    iget-object v4, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    new-instance v5, Lco/vine/android/RecordingFragment$OnRecordingFinishRunnable;

    new-instance v6, Ljava/lang/ref/WeakReference;

    invoke-direct {v6, p0}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    invoke-direct {v5, v6}, Lco/vine/android/RecordingFragment$OnRecordingFinishRunnable;-><init>(Ljava/lang/ref/WeakReference;)V

    invoke-virtual {v4, v0, v5, v2}, Lco/vine/android/recorder/VineRecorder;->onUiResumed(Landroid/app/Activity;Ljava/lang/Runnable;Z)V

    .line 226
    iget-object v4, p0, Lco/vine/android/RecordingFragment;->mGridButton:Landroid/widget/ToggleButton;

    invoke-virtual {v4}, Landroid/widget/ToggleButton;->isChecked()Z

    move-result v4

    if-eqz v4, :cond_2

    .line 227
    iget-object v4, p0, Lco/vine/android/RecordingFragment;->mGridButton:Landroid/widget/ToggleButton;

    iget-object v5, p0, Lco/vine/android/RecordingFragment;->mGrid:Landroid/view/View;

    invoke-virtual {v5}, Landroid/view/View;->getVisibility()I

    move-result v5

    const/16 v6, 0x8

    if-eq v5, v6, :cond_1

    const/4 v3, 0x1

    :cond_1
    invoke-virtual {v4, v3}, Landroid/widget/ToggleButton;->setChecked(Z)V

    .line 230
    .end local v0    # "activity":Lco/vine/android/AbstractRecordingActivity;
    .end local v2    # "isDraftsShowing":Z
    :cond_2
    return-void
.end method

.method public onSessionSwitchPressed(Landroid/view/View;)V
    .locals 7
    .param p1, "v"    # Landroid/view/View;

    .prologue
    const/4 v6, 0x2

    const/4 v5, 0x0

    .line 847
    iget v4, p0, Lco/vine/android/RecordingFragment;->mDraftUpgradeCount:I

    if-lez v4, :cond_0

    .line 848
    iget v4, p0, Lco/vine/android/RecordingFragment;->mDraftUpgradeCount:I

    invoke-static {v4}, Lco/vine/android/util/FlurryUtils;->trackSessionSwitchPressedOnDraftUpgrade(I)V

    .line 849
    iget-object v4, p0, Lco/vine/android/RecordingFragment;->mHandler:Landroid/os/Handler;

    new-instance v5, Lco/vine/android/RecordingFragment$13;

    invoke-direct {v5, p0}, Lco/vine/android/RecordingFragment$13;-><init>(Lco/vine/android/RecordingFragment;)V

    invoke-virtual {v4, v5}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 892
    :goto_0
    return-void

    .line 865
    :cond_0
    invoke-static {p1}, Lco/vine/android/util/FlurryUtils;->trackSessionSwitchPressed(Landroid/view/View;)V

    .line 866
    iget-object v4, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    if-eqz v4, :cond_3

    iget v4, p0, Lco/vine/android/RecordingFragment;->mNumDrafts:I

    if-gtz v4, :cond_1

    iget-object v4, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    invoke-virtual {v4}, Lco/vine/android/recorder/VineRecorder;->isSessionDirty()Z

    move-result v4

    if-eqz v4, :cond_3

    .line 868
    :cond_1
    iget-object v4, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    invoke-virtual {v4}, Lco/vine/android/recorder/VineRecorder;->isSessionDirty()Z

    move-result v4

    if-eqz v4, :cond_2

    .line 869
    invoke-virtual {p0}, Lco/vine/android/RecordingFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v4

    check-cast v4, Lco/vine/android/AbstractRecordingActivity;

    invoke-virtual {v4, v6, p0}, Lco/vine/android/AbstractRecordingActivity;->showUnSavedChangesDialog(ILco/vine/android/RecordingFragment;)V

    goto :goto_0

    .line 871
    :cond_2
    invoke-virtual {p0, v5}, Lco/vine/android/RecordingFragment;->startDrafts(Z)V

    goto :goto_0

    .line 875
    :cond_3
    iget-object v4, p0, Lco/vine/android/RecordingFragment;->mDraftOverlayIcon:Landroid/view/View;

    invoke-virtual {v4, v5}, Landroid/view/View;->setVisibility(I)V

    .line 877
    new-array v1, v6, [I

    .line 878
    .local v1, "location":[I
    iget-object v4, p0, Lco/vine/android/RecordingFragment;->mDraftsButton:Landroid/widget/TextView;

    invoke-virtual {v4, v1}, Landroid/widget/TextView;->getLocationOnScreen([I)V

    .line 879
    aget v2, v1, v5

    .line 880
    .local v2, "x":I
    const/4 v4, 0x1

    aget v3, v1, v4

    .line 881
    .local v3, "y":I
    iget-object v4, p0, Lco/vine/android/RecordingFragment;->mDraftOverlayIcon:Landroid/view/View;

    int-to-float v5, v2

    invoke-virtual {v4, v5}, Landroid/view/View;->setX(F)V

    .line 883
    invoke-virtual {p0}, Lco/vine/android/RecordingFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    const v5, 0x7f0b0031

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getDimensionPixelOffset(I)I

    move-result v0

    .line 886
    .local v0, "draftOverlayOffset":I
    iget-object v4, p0, Lco/vine/android/RecordingFragment;->mDraftOverlayIcon:Landroid/view/View;

    sub-int v5, v3, v0

    int-to-float v5, v5

    invoke-virtual {v4, v5}, Landroid/view/View;->setY(F)V

    .line 888
    iget-object v4, p0, Lco/vine/android/RecordingFragment;->mNoDraftsOverlay:Landroid/view/View;

    iget-object v5, p0, Lco/vine/android/RecordingFragment;->mOnNoDraftOverlayTouchListener:Landroid/view/View$OnTouchListener;

    invoke-virtual {v4, v5}, Landroid/view/View;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 889
    iget-object v4, p0, Lco/vine/android/RecordingFragment;->mFadeIn:Landroid/view/animation/Animation;

    iget-object v5, p0, Lco/vine/android/RecordingFragment;->mFadeInListener:Landroid/view/animation/Animation$AnimationListener;

    invoke-virtual {v4, v5}, Landroid/view/animation/Animation;->setAnimationListener(Landroid/view/animation/Animation$AnimationListener;)V

    .line 890
    iget-object v4, p0, Lco/vine/android/RecordingFragment;->mNoDraftsOverlay:Landroid/view/View;

    iget-object v5, p0, Lco/vine/android/RecordingFragment;->mFadeIn:Landroid/view/animation/Animation;

    invoke-virtual {v4, v5}, Landroid/view/View;->startAnimation(Landroid/view/animation/Animation;)V

    goto :goto_0
.end method

.method public onShowDrafts()V
    .locals 2

    .prologue
    .line 1020
    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mRecordingOptions:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 1021
    return-void
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 13
    .param p1, "view"    # Landroid/view/View;
    .param p2, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 729
    invoke-super {p0, p1, p2}, Lco/vine/android/BaseFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 730
    invoke-virtual {p0}, Lco/vine/android/RecordingFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    .line 736
    .local v4, "res":Landroid/content/res/Resources;
    iget-object v9, p0, Lco/vine/android/RecordingFragment;->mNoDraftsOverlay:Landroid/view/View;

    const v10, 0x7f0a01d0

    invoke-virtual {v9, v10}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    .line 737
    .local v5, "sadface":Landroid/view/View;
    const v9, 0x7f0b006a

    invoke-virtual {v4, v9}, Landroid/content/res/Resources;->getDimensionPixelOffset(I)I

    move-result v9

    int-to-float v3, v9

    .line 738
    .local v3, "progressHeight":F
    const v9, 0x7f0b0034

    invoke-virtual {v4, v9}, Landroid/content/res/Resources;->getDimensionPixelOffset(I)I

    move-result v9

    int-to-float v6, v9

    .line 739
    .local v6, "sadfaceHeight":F
    iget-object v9, p0, Lco/vine/android/RecordingFragment;->mScreenSize:Landroid/graphics/Point;

    iget v9, v9, Landroid/graphics/Point;->x:I

    div-int/lit8 v9, v9, 0x2

    int-to-float v9, v9

    add-float/2addr v9, v3

    sub-float/2addr v9, v6

    invoke-virtual {v5, v9}, Landroid/view/View;->setY(F)V

    .line 741
    iget-boolean v9, p0, Lco/vine/android/RecordingFragment;->mIsMessaging:Z

    if-eqz v9, :cond_0

    .line 742
    invoke-virtual {p0}, Lco/vine/android/RecordingFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v9

    const v10, 0x7f0a01be

    invoke-virtual {v9, v10}, Landroid/support/v4/app/FragmentActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    .line 743
    .local v1, "options":Landroid/view/View;
    invoke-virtual {v1}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v2

    check-cast v2, Landroid/widget/RelativeLayout$LayoutParams;

    .line 744
    .local v2, "params":Landroid/widget/RelativeLayout$LayoutParams;
    iget-object v9, p0, Lco/vine/android/RecordingFragment;->mScreenSize:Landroid/graphics/Point;

    iget v9, v9, Landroid/graphics/Point;->x:I

    int-to-double v9, v9

    const-wide v11, 0x3fb999999999999aL    # 0.1

    mul-double/2addr v9, v11

    double-to-int v0, v9

    .line 745
    .local v0, "margin":I
    const/4 v9, 0x0

    const/4 v10, 0x0

    invoke-virtual {v2, v0, v9, v0, v10}, Landroid/widget/RelativeLayout$LayoutParams;->setMargins(IIII)V

    .line 746
    invoke-virtual {v1, v2}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 750
    .end local v0    # "margin":I
    .end local v1    # "options":Landroid/view/View;
    .end local v2    # "params":Landroid/widget/RelativeLayout$LayoutParams;
    :cond_0
    iget-object v9, p0, Lco/vine/android/RecordingFragment;->mNoDraftsOverlay:Landroid/view/View;

    const v10, 0x7f0a01d1

    invoke-virtual {v9, v10}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v7

    .line 751
    .local v7, "sadfaceText":Landroid/view/View;
    const v9, 0x7f0b0035

    invoke-virtual {v4, v9}, Landroid/content/res/Resources;->getDimensionPixelOffset(I)I

    move-result v9

    int-to-float v8, v9

    .line 752
    .local v8, "spacing":F
    invoke-virtual {v5}, Landroid/view/View;->getY()F

    move-result v9

    add-float/2addr v9, v8

    invoke-virtual {v7, v9}, Landroid/view/View;->setY(F)V

    .line 755
    const v9, 0x7f0a01d2

    invoke-virtual {p1, v9}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v9

    iput-object v9, p0, Lco/vine/android/RecordingFragment;->mDraftOverlayIcon:Landroid/view/View;

    .line 756
    return-void
.end method

.method public playStopSound()V
    .locals 1

    .prologue
    .line 782
    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    if-eqz v0, :cond_0

    .line 783
    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    invoke-virtual {v0}, Lco/vine/android/recorder/VineRecorder;->playStopRecordingSound()V

    .line 785
    :cond_0
    return-void
.end method

.method public release()V
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 240
    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    if-eqz v0, :cond_1

    .line 241
    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    invoke-virtual {v0}, Lco/vine/android/recorder/VineRecorder;->release()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 242
    const-string v0, "capture"

    invoke-static {v0}, Lco/vine/android/util/FlurryUtils;->trackAbandonedStage(Ljava/lang/String;)V

    .line 243
    iget-wide v0, p0, Lco/vine/android/RecordingFragment;->mTier:D

    const-wide/high16 v2, 0x4050000000000000L    # 64.0

    div-double/2addr v0, v2

    double-to-int v0, v0

    invoke-static {v0}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lco/vine/android/util/FlurryUtils;->trackAbandonedTier(Ljava/lang/String;)V

    .line 245
    :cond_0
    iput-object v4, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    .line 247
    :cond_1
    iput-object v4, p0, Lco/vine/android/RecordingFragment;->mFileFileToUse:Lco/vine/android/recorder/RecordingFile;

    .line 248
    return-void
.end method

.method public requestZoomProgressUpdate()V
    .locals 1

    .prologue
    .line 332
    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    if-eqz v0, :cond_0

    .line 333
    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    invoke-virtual {v0}, Lco/vine/android/recorder/VineRecorder;->requestZoomProgressUpdate()V

    .line 335
    :cond_0
    return-void
.end method

.method public resumeFromDraft()V
    .locals 5

    .prologue
    .line 988
    iget-object v2, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    if-eqz v2, :cond_0

    .line 989
    iget-object v2, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    invoke-virtual {v2}, Lco/vine/android/recorder/VineRecorder;->isResuming()Z

    move-result v2

    if-nez v2, :cond_0

    .line 990
    iget-object v2, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    invoke-virtual {v2}, Lco/vine/android/recorder/VineRecorder;->getFile()Lco/vine/android/recorder/RecordingFile;

    move-result-object v1

    .line 992
    .local v1, "resumeFile":Lco/vine/android/recorder/RecordingFile;
    iget-object v2, v1, Lco/vine/android/recorder/RecordingFile;->folder:Ljava/io/File;

    invoke-virtual {v2}, Ljava/io/File;->exists()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 993
    iget-object v2, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    const-string v3, "BackPress, Resume from draft using resumeFile."

    invoke-virtual {v2, v3, v1}, Lco/vine/android/recorder/VineRecorder;->swapSession(Ljava/lang/String;Lco/vine/android/recorder/RecordingFile;)Lco/vine/android/recorder/RecordingFile;

    move-result-object v0

    .line 997
    .local v0, "newFile":Lco/vine/android/recorder/RecordingFile;
    :goto_0
    if-eqz v0, :cond_0

    .line 998
    iget-object v2, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    const-string v3, "Resume draft"

    const/4 v4, 0x1

    invoke-virtual {v2, v3, v4}, Lco/vine/android/recorder/VineRecorder;->onResume(Ljava/lang/String;Z)V

    .line 1002
    .end local v0    # "newFile":Lco/vine/android/recorder/RecordingFile;
    .end local v1    # "resumeFile":Lco/vine/android/recorder/RecordingFile;
    :cond_0
    return-void

    .line 995
    .restart local v1    # "resumeFile":Lco/vine/android/recorder/RecordingFile;
    :cond_1
    iget-object v2, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    const-string v3, "BackPress, Resume from draft using determined."

    const/4 v4, 0x0

    invoke-direct {p0, v4}, Lco/vine/android/RecordingFragment;->determineSessionFileForSwap(Z)Lco/vine/android/recorder/RecordingFile;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Lco/vine/android/recorder/VineRecorder;->swapSession(Ljava/lang/String;Lco/vine/android/recorder/RecordingFile;)Lco/vine/android/recorder/RecordingFile;

    move-result-object v0

    .restart local v0    # "newFile":Lco/vine/android/recorder/RecordingFile;
    goto :goto_0
.end method

.method public reverseFrames()V
    .locals 1

    .prologue
    .line 969
    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    if-eqz v0, :cond_0

    .line 970
    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    invoke-virtual {v0}, Lco/vine/android/recorder/VineRecorder;->reverseFrames()V

    .line 972
    :cond_0
    return-void
.end method

.method public saveSession()V
    .locals 3

    .prologue
    .line 940
    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    if-eqz v0, :cond_0

    .line 941
    const-string v0, "saveNoQuit"

    invoke-static {v0}, Lco/vine/android/util/FlurryUtils;->trackSaveSession(Ljava/lang/String;)V

    .line 942
    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    const/4 v1, 0x0

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Lco/vine/android/recorder/VineRecorder;->saveSession(Ljava/lang/Runnable;Z)V

    .line 944
    :cond_0
    return-void
.end method

.method public saveSessionAndQuit()V
    .locals 3

    .prologue
    .line 922
    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    if-eqz v0, :cond_0

    .line 923
    const-string v0, "quit"

    invoke-static {v0}, Lco/vine/android/util/FlurryUtils;->trackSaveSession(Ljava/lang/String;)V

    .line 924
    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    new-instance v1, Lco/vine/android/RecordingFragment$14;

    invoke-direct {v1, p0}, Lco/vine/android/RecordingFragment$14;-><init>(Lco/vine/android/RecordingFragment;)V

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Lco/vine/android/recorder/VineRecorder;->saveSession(Ljava/lang/Runnable;Z)V

    .line 934
    :cond_0
    return-void
.end method

.method public setDiscardChangesOnStop()V
    .locals 2

    .prologue
    .line 776
    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    if-eqz v0, :cond_0

    .line 777
    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lco/vine/android/recorder/VineRecorder;->setDiscardChanges(Z)V

    .line 779
    :cond_0
    return-void
.end method

.method public setFileFileToUse(Lco/vine/android/recorder/RecordingFile;)V
    .locals 0
    .param p1, "fileFileToUse"    # Lco/vine/android/recorder/RecordingFile;

    .prologue
    .line 953
    iput-object p1, p0, Lco/vine/android/RecordingFragment;->mFileFileToUse:Lco/vine/android/recorder/RecordingFile;

    .line 954
    return-void
.end method

.method public setStartWithEdit(Z)V
    .locals 0
    .param p1, "startWithEdit"    # Z

    .prologue
    .line 957
    iput-boolean p1, p0, Lco/vine/android/RecordingFragment;->mStartWithEdit:Z

    .line 958
    return-void
.end method

.method public startDrafts(Z)V
    .locals 4
    .param p1, "save"    # Z

    .prologue
    const/4 v3, 0x0

    .line 832
    const-string v0, "Start Drafts: {}."

    invoke-static {p1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 833
    if-eqz p1, :cond_0

    .line 834
    const-string v0, "drafts"

    invoke-static {v0}, Lco/vine/android/util/FlurryUtils;->trackSaveSession(Ljava/lang/String;)V

    .line 835
    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    iget-object v1, p0, Lco/vine/android/RecordingFragment;->mStartDraftsRunnable:Ljava/lang/Runnable;

    invoke-virtual {v0, v1, v3}, Lco/vine/android/recorder/VineRecorder;->saveSession(Ljava/lang/Runnable;Z)V

    .line 840
    :goto_0
    return-void

    .line 837
    :cond_0
    const/4 v0, 0x0

    iput-object v0, p0, Lco/vine/android/RecordingFragment;->mFileFileToUse:Lco/vine/android/recorder/RecordingFile;

    .line 838
    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    const-string v1, "StartDrafts"

    iget-object v2, p0, Lco/vine/android/RecordingFragment;->mStartDraftsRunnable:Ljava/lang/Runnable;

    invoke-virtual {v0, v1, v2, v3}, Lco/vine/android/recorder/VineRecorder;->stopAndDiscardChanges(Ljava/lang/String;Ljava/lang/Runnable;Z)V

    goto :goto_0
.end method

.method public startRelativeTime()Z
    .locals 1

    .prologue
    .line 1105
    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    invoke-virtual {v0}, Lco/vine/android/recorder/VineRecorder;->canKeepRecording()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    invoke-virtual {v0}, Lco/vine/android/recorder/VineRecorder;->isCurrentlyRecording()Z

    move-result v0

    if-nez v0, :cond_0

    .line 1106
    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    invoke-virtual {v0}, Lco/vine/android/recorder/VineRecorder;->startRelativeTime()Z

    move-result v0

    .line 1108
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public stopZoom()V
    .locals 1

    .prologue
    .line 802
    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    if-eqz v0, :cond_0

    .line 803
    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    invoke-virtual {v0}, Lco/vine/android/recorder/VineRecorder;->stopZoom()V

    .line 805
    :cond_0
    return-void
.end method

.method public swapFolder(Ljava/lang/String;Ljava/io/File;)V
    .locals 3
    .param p1, "tag"    # Ljava/lang/String;
    .param p2, "folder"    # Ljava/io/File;

    .prologue
    .line 975
    iput-object p2, p0, Lco/vine/android/RecordingFragment;->mFolder:Ljava/io/File;

    .line 976
    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    if-eqz v0, :cond_0

    .line 977
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lco/vine/android/RecordingFragment;->setFileFileToUse(Lco/vine/android/recorder/RecordingFile;)V

    .line 978
    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " swap"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x0

    invoke-direct {p0, v2}, Lco/vine/android/RecordingFragment;->determineSessionFileForSwap(Z)Lco/vine/android/recorder/RecordingFile;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lco/vine/android/recorder/VineRecorder;->swapSession(Ljava/lang/String;Lco/vine/android/recorder/RecordingFile;)Lco/vine/android/recorder/RecordingFile;

    .line 979
    iget-object v0, p0, Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;

    const-string v1, "Swap folder"

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Lco/vine/android/recorder/VineRecorder;->onResume(Ljava/lang/String;Z)V

    .line 981
    :cond_0
    return-void
.end method
