.class public abstract Lco/vine/android/AbstractRecordingActivity;
.super Lco/vine/android/BaseActionBarActivity;
.source "AbstractRecordingActivity.java"

# interfaces
.implements Lco/vine/android/widgets/PromptDialogFragment$OnDialogDoneListener;
.implements Landroid/support/v4/view/DraftViewPager$OnPageChangeListener;
.implements Lco/vine/android/animation/SmoothAnimator$AnimationListener;
.implements Lco/vine/android/widget/DragUpToDeleteContainer$DragUpListener;
.implements Lco/vine/android/recorder/ByteBufferQueue$MemoryResponder;


# annotations
.annotation build Landroid/annotation/TargetApi;
    value = 0xe
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/AbstractRecordingActivity$DraftPagerImpl;,
        Lco/vine/android/AbstractRecordingActivity$SetSelectedRunnable;
    }
.end annotation


# static fields
.field private static final ANIMATION_CAMERA_ICON:I = 0x4

.field private static final ANIMATION_DELETE:I = 0x3

.field private static final ANIMATION_PREVIEW:I = 0x1

.field private static final ANIMATION_PROGRESS:I = 0x2

.field private static final ANIMATION_PROGRESS_TO_DRAFTS:I = 0x6

.field private static final ANIMATION_TO_DRAFTS:I = 0x5

.field private static final ANIMATION_TO_DRAFTS_CAMERA:I = 0x7

.field private static final ANIM_DURATION:I = 0x12c

.field public static final DIALOG_DELETE:I = 0x1

.field public static final DIALOG_DIRTY:I = 0x2

.field public static final DIALOG_TOO_MANY_DRAFTS:I = 0x3

.field public static final DIALOG_UNSAVED_CHANGES:I = 0x0

.field protected static final EXTRA_AM_FOLLOWING:Ljava/lang/String; = "am_following"

.field protected static final EXTRA_CONVERSATION_ROW_ID:Ljava/lang/String; = "conv_row_id"

.field protected static final EXTRA_DIRECT_USER_ID:Ljava/lang/String; = "direct_id"

.field protected static final EXTRA_IS_VM_ONBOARDING:Ljava/lang/String; = "is_vm_onboarding"

.field protected static final EXTRA_MESSAGING:Ljava/lang/String; = "messaging"

.field protected static final EXTRA_RECIPIENT_USERNAME:Ljava/lang/String; = "recipient_username"

.field protected static final EXTRA_START_CONVERSATION:Ljava/lang/String; = "start_conversation"

.field private static final EXTRA_TOP_OVERLAY:Ljava/lang/String; = "arg_top_overlay"

.field private static final PAGE_INVALID:I = -0x1

.field public static final PREF_CAPTURE_LAUNCH_COUNT:Ljava/lang/String; = "recorder_launch_count"

.field public static final RESULT_RECORDING_CANCELLED:I = 0x64

.field private static final SECRETS:[I

.field public static final START_SESSION_ID_CAMERA:Ljava/lang/String; = "camera_preview"

.field private static final STATE_FIRST_DRAFT_LAUNCH:Ljava/lang/String; = "first_launch"

.field private static final STATE_FIRST_PAGE_SET:Ljava/lang/String; = "state_fp"

.field private static final STEP_NONE:I = -0x1

.field private static final STEP_PREVIEW:I = 0x1

.field private static final STEP_RECORD:I

.field private static final sQueues:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/ref/WeakReference",
            "<",
            "Ljava/lang/Object;",
            ">;>;"
        }
    .end annotation
.end field


# instance fields
.field private isSecretModeOn:Z

.field private mAdapter:Lco/vine/android/AbstractRecordingActivity$DraftPagerImpl;

.field private mAddToUploadThread:Ljava/lang/Thread;

.field private mAmFollowingRecipient:Z

.field private mAnimatingIntoDrafts:Z

.field private mAnimationPreviewOverlay:Landroid/view/View;

.field private mCameraFragment:Ljava/lang/ref/WeakReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ref/WeakReference",
            "<",
            "Lco/vine/android/DraftCameraPreviewFragment;",
            ">;"
        }
    .end annotation
.end field

.field private mCameraIconFadeIn:Landroid/view/animation/Animation;

.field private mCameraIconOverlay:Landroid/view/View;

.field private mCameraIconOverlayImage:Landroid/view/View;

.field protected mColor:I

.field protected mConversationRowId:J

.field public mCurrentDuration:J

.field protected mCurrentFragment:Landroid/support/v4/app/Fragment;

.field mCurrentPage:I

.field private mCurrentSecret:I

.field private mCurrentSession:Lco/vine/android/recorder/RecordSessionManager$RecordSessionInfo;

.field private mDeleteWasDrag:Z

.field protected mDirectUserId:J

.field private mDots:Lco/vine/android/widget/DotIndicators;

.field private final mDraftFragments:Landroid/util/SparseArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/util/SparseArray",
            "<",
            "Ljava/lang/ref/WeakReference",
            "<",
            "Lco/vine/android/DraftFragment;",
            ">;>;"
        }
    .end annotation
.end field

.field private mDraftFullMask:Landroid/view/View;

.field private mDraftMaskLeft:Landroid/view/View;

.field private mDraftMaskParent:Landroid/view/View;

.field private mDraftMaskRight:Landroid/view/View;

.field private mDraftMaskTop:Landroid/view/View;

.field private mDraftRoot:Landroid/view/View;

.field private mDraftTrashBackground:Landroid/view/View;

.field private mDraftTrashButton:Landroid/view/View;

.field private mDraftTrashContainer:Landroid/view/View;

.field private mDragUpToDeleteView:Lco/vine/android/widget/DragUpToDeleteContainer;

.field private final mEmptyClicker:Landroid/view/View$OnClickListener;

.field private mFirstDraftLaunch:Z

.field private mFirstPageSet:Z

.field private final mHandler:Landroid/os/Handler;

.field private mHasPreviewedAlready:Z

.field private mHasStartedRelativeTimeFromHardwareButton:Z

.field private final mHelper:Lco/vine/android/recorder/RecordingActivityHelper;

.field private final mIntentionalObjectCounter:Lco/vine/android/util/IntentionalObjectCounter;

.field private mIsGoingToRecord:Z

.field protected mIsMessaging:Z

.field protected mIsVmOnboarding:Z

.field private mLargeThumbnailOverlay:Landroid/widget/ImageView;

.field final mOnMaskTouchListesner:Landroid/view/View$OnTouchListener;

.field private mOnPageIdleRunnable:Lco/vine/android/AbstractRecordingActivity$SetSelectedRunnable;

.field private final mOnResumeDraftRunnable:Ljava/lang/Runnable;

.field private mPageScrollState:I

.field mPreviewDimen:I

.field private mPreviewOverlay:Landroid/view/View;

.field mPreviewRatio:F

.field public mProgressContainerWidth:I

.field private mProgressOverlay:Landroid/view/View;

.field private mPromptDialog:Lco/vine/android/widgets/PromptDialogFragment;

.field private mRecipientUsername:Ljava/lang/String;

.field private mRegularUiMode:I

.field private mScreenSize:Landroid/graphics/Point;

.field private mSessions:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/recorder/RecordSessionManager$RecordSessionInfo;",
            ">;"
        }
    .end annotation
.end field

.field private mSideMaskWidth:I

.field private mSlowFadeIn:Landroid/view/animation/Animation;

.field private mStartConversation:Z

.field private mStartSessionId:Ljava/lang/String;

.field private mStep:I

.field private mTopMaskHeight:I

.field private mTopOverlay:Landroid/graphics/Bitmap;

.field protected mUploadFile:Ljava/lang/String;

.field private mVersion:Lco/vine/android/recorder/RecordSessionVersion;

.field private mVideoViews:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/player/SdkVideoView;",
            ">;"
        }
    .end annotation
.end field

.field private mViewPager:Landroid/support/v4/view/DraftViewPager;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 290
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    sput-object v0, Lco/vine/android/AbstractRecordingActivity;->sQueues:Ljava/util/ArrayList;

    .line 1311
    const/4 v0, 0x7

    new-array v0, v0, [I

    fill-array-data v0, :array_0

    sput-object v0, Lco/vine/android/AbstractRecordingActivity;->SECRETS:[I

    return-void

    :array_0
    .array-data 4
        0x19
        0x18
        0x18
        0x18
        0x18
        0x18
        0x19
    .end array-data
.end method

.method public constructor <init>()V
    .locals 7

    .prologue
    const/4 v6, 0x0

    .line 292
    invoke-direct {p0}, Lco/vine/android/BaseActionBarActivity;-><init>()V

    .line 130
    new-instance v3, Lco/vine/android/util/IntentionalObjectCounter;

    const-string v4, "recorder"

    invoke-direct {v3, v4, p0}, Lco/vine/android/util/IntentionalObjectCounter;-><init>(Ljava/lang/String;Ljava/lang/Object;)V

    iput-object v3, p0, Lco/vine/android/AbstractRecordingActivity;->mIntentionalObjectCounter:Lco/vine/android/util/IntentionalObjectCounter;

    .line 131
    new-instance v3, Landroid/os/Handler;

    invoke-direct {v3}, Landroid/os/Handler;-><init>()V

    iput-object v3, p0, Lco/vine/android/AbstractRecordingActivity;->mHandler:Landroid/os/Handler;

    .line 166
    new-instance v3, Landroid/util/SparseArray;

    invoke-direct {v3}, Landroid/util/SparseArray;-><init>()V

    iput-object v3, p0, Lco/vine/android/AbstractRecordingActivity;->mDraftFragments:Landroid/util/SparseArray;

    .line 175
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    iput-object v3, p0, Lco/vine/android/AbstractRecordingActivity;->mVideoViews:Ljava/util/ArrayList;

    .line 186
    const/4 v3, -0x1

    iput v3, p0, Lco/vine/android/AbstractRecordingActivity;->mStep:I

    .line 191
    iput-boolean v6, p0, Lco/vine/android/AbstractRecordingActivity;->mDeleteWasDrag:Z

    .line 193
    new-instance v3, Lco/vine/android/AbstractRecordingActivity$1;

    invoke-direct {v3, p0}, Lco/vine/android/AbstractRecordingActivity$1;-><init>(Lco/vine/android/AbstractRecordingActivity;)V

    iput-object v3, p0, Lco/vine/android/AbstractRecordingActivity;->mEmptyClicker:Landroid/view/View$OnClickListener;

    .line 204
    iput-boolean v6, p0, Lco/vine/android/AbstractRecordingActivity;->mAnimatingIntoDrafts:Z

    .line 213
    new-instance v3, Lco/vine/android/AbstractRecordingActivity$2;

    invoke-direct {v3, p0}, Lco/vine/android/AbstractRecordingActivity$2;-><init>(Lco/vine/android/AbstractRecordingActivity;)V

    iput-object v3, p0, Lco/vine/android/AbstractRecordingActivity;->mOnMaskTouchListesner:Landroid/view/View$OnTouchListener;

    .line 222
    new-instance v3, Lco/vine/android/recorder/RecordingActivityHelper;

    invoke-direct {v3}, Lco/vine/android/recorder/RecordingActivityHelper;-><init>()V

    iput-object v3, p0, Lco/vine/android/AbstractRecordingActivity;->mHelper:Lco/vine/android/recorder/RecordingActivityHelper;

    .line 224
    iput-boolean v6, p0, Lco/vine/android/AbstractRecordingActivity;->mAmFollowingRecipient:Z

    .line 1321
    iput v6, p0, Lco/vine/android/AbstractRecordingActivity;->mCurrentSecret:I

    .line 1322
    iput-boolean v6, p0, Lco/vine/android/AbstractRecordingActivity;->isSecretModeOn:Z

    .line 1616
    new-instance v3, Lco/vine/android/AbstractRecordingActivity$11;

    invoke-direct {v3, p0}, Lco/vine/android/AbstractRecordingActivity$11;-><init>(Lco/vine/android/AbstractRecordingActivity;)V

    iput-object v3, p0, Lco/vine/android/AbstractRecordingActivity;->mOnResumeDraftRunnable:Ljava/lang/Runnable;

    .line 293
    sget-object v3, Lco/vine/android/AbstractRecordingActivity;->sQueues:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v3

    const/16 v4, 0x14

    if-le v3, v4, :cond_0

    .line 294
    sget-object v3, Lco/vine/android/AbstractRecordingActivity;->sQueues:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->clear()V

    .line 296
    :cond_0
    sget-object v3, Lco/vine/android/AbstractRecordingActivity;->sQueues:Ljava/util/ArrayList;

    new-instance v4, Ljava/lang/ref/WeakReference;

    invoke-direct {v4, p0}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    invoke-virtual {v3, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 297
    const/4 v1, 0x0

    .line 298
    .local v1, "n":I
    sget-object v3, Lco/vine/android/AbstractRecordingActivity;->sQueues:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_1
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_2

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/ref/WeakReference;

    .line 299
    .local v2, "queue":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Ljava/lang/Object;>;"
    invoke-virtual {v2}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v3

    if-eqz v3, :cond_1

    .line 300
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 303
    .end local v2    # "queue":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Ljava/lang/Object;>;"
    :cond_2
    const-string v3, "[mem] Current RecordingActivity queue count: {}."

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v4, v6

    invoke-static {v3, v4}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 304
    return-void
.end method

.method static synthetic access$000(Lco/vine/android/AbstractRecordingActivity;)Landroid/util/SparseArray;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/AbstractRecordingActivity;

    .prologue
    .line 83
    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mDraftFragments:Landroid/util/SparseArray;

    return-object v0
.end method

.method static synthetic access$1000(Lco/vine/android/AbstractRecordingActivity;)Landroid/view/View;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/AbstractRecordingActivity;

    .prologue
    .line 83
    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mAnimationPreviewOverlay:Landroid/view/View;

    return-object v0
.end method

.method static synthetic access$102(Lco/vine/android/AbstractRecordingActivity;Z)Z
    .locals 0
    .param p0, "x0"    # Lco/vine/android/AbstractRecordingActivity;
    .param p1, "x1"    # Z

    .prologue
    .line 83
    iput-boolean p1, p0, Lco/vine/android/AbstractRecordingActivity;->mDeleteWasDrag:Z

    return p1
.end method

.method static synthetic access$1100(Lco/vine/android/AbstractRecordingActivity;)Ljava/lang/Runnable;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/AbstractRecordingActivity;

    .prologue
    .line 83
    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mOnResumeDraftRunnable:Ljava/lang/Runnable;

    return-object v0
.end method

.method static synthetic access$1200(Lco/vine/android/AbstractRecordingActivity;)Landroid/os/Handler;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/AbstractRecordingActivity;

    .prologue
    .line 83
    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mHandler:Landroid/os/Handler;

    return-object v0
.end method

.method static synthetic access$1300(Lco/vine/android/AbstractRecordingActivity;)Z
    .locals 1
    .param p0, "x0"    # Lco/vine/android/AbstractRecordingActivity;

    .prologue
    .line 83
    invoke-direct {p0}, Lco/vine/android/AbstractRecordingActivity;->isResuming()Z

    move-result v0

    return v0
.end method

.method static synthetic access$1400(Lco/vine/android/AbstractRecordingActivity;)Landroid/view/View;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/AbstractRecordingActivity;

    .prologue
    .line 83
    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mCameraIconOverlayImage:Landroid/view/View;

    return-object v0
.end method

.method static synthetic access$1500(Lco/vine/android/AbstractRecordingActivity;)Landroid/view/animation/Animation;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/AbstractRecordingActivity;

    .prologue
    .line 83
    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mSlowFadeIn:Landroid/view/animation/Animation;

    return-object v0
.end method

.method static synthetic access$1600(Lco/vine/android/AbstractRecordingActivity;)Landroid/view/animation/Animation;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/AbstractRecordingActivity;

    .prologue
    .line 83
    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mCameraIconFadeIn:Landroid/view/animation/Animation;

    return-object v0
.end method

.method static synthetic access$1700(Lco/vine/android/AbstractRecordingActivity;)Z
    .locals 1
    .param p0, "x0"    # Lco/vine/android/AbstractRecordingActivity;

    .prologue
    .line 83
    iget-boolean v0, p0, Lco/vine/android/AbstractRecordingActivity;->mAnimatingIntoDrafts:Z

    return v0
.end method

.method static synthetic access$1702(Lco/vine/android/AbstractRecordingActivity;Z)Z
    .locals 0
    .param p0, "x0"    # Lco/vine/android/AbstractRecordingActivity;
    .param p1, "x1"    # Z

    .prologue
    .line 83
    iput-boolean p1, p0, Lco/vine/android/AbstractRecordingActivity;->mAnimatingIntoDrafts:Z

    return p1
.end method

.method static synthetic access$1800(Lco/vine/android/AbstractRecordingActivity;)Landroid/view/View;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/AbstractRecordingActivity;

    .prologue
    .line 83
    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mDraftFullMask:Landroid/view/View;

    return-object v0
.end method

.method static synthetic access$1900(Lco/vine/android/AbstractRecordingActivity;)Landroid/support/v4/view/DraftViewPager;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/AbstractRecordingActivity;

    .prologue
    .line 83
    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mViewPager:Landroid/support/v4/view/DraftViewPager;

    return-object v0
.end method

.method static synthetic access$200(Lco/vine/android/AbstractRecordingActivity;)Landroid/view/View;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/AbstractRecordingActivity;

    .prologue
    .line 83
    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mDraftTrashBackground:Landroid/view/View;

    return-object v0
.end method

.method static synthetic access$2002(Lco/vine/android/AbstractRecordingActivity;I)I
    .locals 0
    .param p0, "x0"    # Lco/vine/android/AbstractRecordingActivity;
    .param p1, "x1"    # I

    .prologue
    .line 83
    iput p1, p0, Lco/vine/android/AbstractRecordingActivity;->mPageScrollState:I

    return p1
.end method

.method static synthetic access$2100(Lco/vine/android/AbstractRecordingActivity;)Landroid/view/View;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/AbstractRecordingActivity;

    .prologue
    .line 83
    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mDraftMaskTop:Landroid/view/View;

    return-object v0
.end method

.method static synthetic access$2200(Lco/vine/android/AbstractRecordingActivity;)Landroid/view/View;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/AbstractRecordingActivity;

    .prologue
    .line 83
    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mDraftMaskLeft:Landroid/view/View;

    return-object v0
.end method

.method static synthetic access$2300(Lco/vine/android/AbstractRecordingActivity;)Landroid/view/View;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/AbstractRecordingActivity;

    .prologue
    .line 83
    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mDraftMaskRight:Landroid/view/View;

    return-object v0
.end method

.method static synthetic access$2402(Lco/vine/android/AbstractRecordingActivity;Ljava/lang/Thread;)Ljava/lang/Thread;
    .locals 0
    .param p0, "x0"    # Lco/vine/android/AbstractRecordingActivity;
    .param p1, "x1"    # Ljava/lang/Thread;

    .prologue
    .line 83
    iput-object p1, p0, Lco/vine/android/AbstractRecordingActivity;->mAddToUploadThread:Ljava/lang/Thread;

    return-object p1
.end method

.method static synthetic access$2500(Lco/vine/android/AbstractRecordingActivity;)Lco/vine/android/AbstractRecordingActivity$DraftPagerImpl;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/AbstractRecordingActivity;

    .prologue
    .line 83
    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mAdapter:Lco/vine/android/AbstractRecordingActivity$DraftPagerImpl;

    return-object v0
.end method

.method static synthetic access$2602(Lco/vine/android/AbstractRecordingActivity;Lco/vine/android/recorder/RecordSessionManager$RecordSessionInfo;)Lco/vine/android/recorder/RecordSessionManager$RecordSessionInfo;
    .locals 0
    .param p0, "x0"    # Lco/vine/android/AbstractRecordingActivity;
    .param p1, "x1"    # Lco/vine/android/recorder/RecordSessionManager$RecordSessionInfo;

    .prologue
    .line 83
    iput-object p1, p0, Lco/vine/android/AbstractRecordingActivity;->mCurrentSession:Lco/vine/android/recorder/RecordSessionManager$RecordSessionInfo;

    return-object p1
.end method

.method static synthetic access$2700(Lco/vine/android/AbstractRecordingActivity;)Ljava/util/ArrayList;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/AbstractRecordingActivity;

    .prologue
    .line 83
    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mSessions:Ljava/util/ArrayList;

    return-object v0
.end method

.method static synthetic access$2802(Lco/vine/android/AbstractRecordingActivity;Ljava/lang/ref/WeakReference;)Ljava/lang/ref/WeakReference;
    .locals 0
    .param p0, "x0"    # Lco/vine/android/AbstractRecordingActivity;
    .param p1, "x1"    # Ljava/lang/ref/WeakReference;

    .prologue
    .line 83
    iput-object p1, p0, Lco/vine/android/AbstractRecordingActivity;->mCameraFragment:Ljava/lang/ref/WeakReference;

    return-object p1
.end method

.method static synthetic access$2900(Lco/vine/android/AbstractRecordingActivity;)Z
    .locals 1
    .param p0, "x0"    # Lco/vine/android/AbstractRecordingActivity;

    .prologue
    .line 83
    iget-boolean v0, p0, Lco/vine/android/AbstractRecordingActivity;->mFirstPageSet:Z

    return v0
.end method

.method static synthetic access$300(Lco/vine/android/AbstractRecordingActivity;)Landroid/view/View;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/AbstractRecordingActivity;

    .prologue
    .line 83
    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mDraftTrashButton:Landroid/view/View;

    return-object v0
.end method

.method static synthetic access$3002(Lco/vine/android/AbstractRecordingActivity;Z)Z
    .locals 0
    .param p0, "x0"    # Lco/vine/android/AbstractRecordingActivity;
    .param p1, "x1"    # Z

    .prologue
    .line 83
    iput-boolean p1, p0, Lco/vine/android/AbstractRecordingActivity;->mIsGoingToRecord:Z

    return p1
.end method

.method static synthetic access$3100(Lco/vine/android/AbstractRecordingActivity;Lco/vine/android/DraftFragment;)V
    .locals 0
    .param p0, "x0"    # Lco/vine/android/AbstractRecordingActivity;
    .param p1, "x1"    # Lco/vine/android/DraftFragment;

    .prologue
    .line 83
    invoke-direct {p0, p1}, Lco/vine/android/AbstractRecordingActivity;->buildAndShowFloatingView(Lco/vine/android/DraftFragment;)V

    return-void
.end method

.method static synthetic access$3200(Lco/vine/android/AbstractRecordingActivity;)V
    .locals 0
    .param p0, "x0"    # Lco/vine/android/AbstractRecordingActivity;

    .prologue
    .line 83
    invoke-direct {p0}, Lco/vine/android/AbstractRecordingActivity;->releasePlayers()V

    return-void
.end method

.method static synthetic access$3300(Lco/vine/android/AbstractRecordingActivity;)Landroid/graphics/Point;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/AbstractRecordingActivity;

    .prologue
    .line 83
    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mScreenSize:Landroid/graphics/Point;

    return-object v0
.end method

.method static synthetic access$3400(Lco/vine/android/AbstractRecordingActivity;)Landroid/view/View;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/AbstractRecordingActivity;

    .prologue
    .line 83
    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mPreviewOverlay:Landroid/view/View;

    return-object v0
.end method

.method static synthetic access$3500(Lco/vine/android/AbstractRecordingActivity;)Landroid/view/View;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/AbstractRecordingActivity;

    .prologue
    .line 83
    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mProgressOverlay:Landroid/view/View;

    return-object v0
.end method

.method static synthetic access$3600(Lco/vine/android/AbstractRecordingActivity;)Z
    .locals 1
    .param p0, "x0"    # Lco/vine/android/AbstractRecordingActivity;

    .prologue
    .line 83
    iget-boolean v0, p0, Lco/vine/android/AbstractRecordingActivity;->mFirstDraftLaunch:Z

    return v0
.end method

.method static synthetic access$3602(Lco/vine/android/AbstractRecordingActivity;Z)Z
    .locals 0
    .param p0, "x0"    # Lco/vine/android/AbstractRecordingActivity;
    .param p1, "x1"    # Z

    .prologue
    .line 83
    iput-boolean p1, p0, Lco/vine/android/AbstractRecordingActivity;->mFirstDraftLaunch:Z

    return p1
.end method

.method static synthetic access$3700(Lco/vine/android/AbstractRecordingActivity;)Z
    .locals 1
    .param p0, "x0"    # Lco/vine/android/AbstractRecordingActivity;

    .prologue
    .line 83
    invoke-direct {p0}, Lco/vine/android/AbstractRecordingActivity;->setCurrentSession()Z

    move-result v0

    return v0
.end method

.method static synthetic access$400(Lco/vine/android/AbstractRecordingActivity;)Landroid/view/View;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/AbstractRecordingActivity;

    .prologue
    .line 83
    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mDraftTrashContainer:Landroid/view/View;

    return-object v0
.end method

.method static synthetic access$500(Lco/vine/android/AbstractRecordingActivity;)Landroid/view/View;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/AbstractRecordingActivity;

    .prologue
    .line 83
    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mDraftMaskParent:Landroid/view/View;

    return-object v0
.end method

.method static synthetic access$600(Lco/vine/android/AbstractRecordingActivity;)Landroid/view/View;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/AbstractRecordingActivity;

    .prologue
    .line 83
    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mDraftRoot:Landroid/view/View;

    return-object v0
.end method

.method static synthetic access$700(Lco/vine/android/AbstractRecordingActivity;)V
    .locals 0
    .param p0, "x0"    # Lco/vine/android/AbstractRecordingActivity;

    .prologue
    .line 83
    invoke-direct {p0}, Lco/vine/android/AbstractRecordingActivity;->hideDraftsInternal()V

    return-void
.end method

.method static synthetic access$800(Lco/vine/android/AbstractRecordingActivity;)Landroid/view/View;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/AbstractRecordingActivity;

    .prologue
    .line 83
    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mCameraIconOverlay:Landroid/view/View;

    return-object v0
.end method

.method static synthetic access$900(Lco/vine/android/AbstractRecordingActivity;)Landroid/widget/ImageView;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/AbstractRecordingActivity;

    .prologue
    .line 83
    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mLargeThumbnailOverlay:Landroid/widget/ImageView;

    return-object v0
.end method

.method private buildAndShowFloatingView(Lco/vine/android/DraftFragment;)V
    .locals 13
    .param p1, "ref"    # Lco/vine/android/DraftFragment;

    .prologue
    const/16 v12, 0x8

    const/4 v6, 0x2

    const/4 v7, 0x1

    const/4 v11, 0x0

    .line 1536
    invoke-direct {p0}, Lco/vine/android/AbstractRecordingActivity;->releasePlayers()V

    .line 1537
    invoke-virtual {p1}, Lco/vine/android/DraftFragment;->showImage()V

    .line 1538
    new-array v8, v6, [I

    .line 1539
    .local v8, "previewLocation":[I
    invoke-virtual {p1}, Lco/vine/android/DraftFragment;->getThumbnailView()Landroid/view/View;

    move-result-object v1

    .line 1540
    .local v1, "thumbnailView":Landroid/view/View;
    invoke-virtual {v1, v8}, Landroid/view/View;->getLocationOnScreen([I)V

    .line 1542
    invoke-virtual {p0}, Lco/vine/android/AbstractRecordingActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v2, 0x7f0b0031

    invoke-virtual {v0, v2}, Landroid/content/res/Resources;->getDimensionPixelOffset(I)I

    move-result v10

    .line 1544
    .local v10, "yOffset":I
    iget-object v2, p0, Lco/vine/android/AbstractRecordingActivity;->mPreviewOverlay:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->getWidth()I

    move-result v3

    aget v4, v8, v11

    aget v0, v8, v7

    sub-int v5, v0, v10

    move-object v0, p0

    invoke-static/range {v0 .. v5}, Lco/vine/android/util/FloatingViewUtils;->buildFloatingViewFor(Landroid/content/Context;Landroid/view/View;Landroid/view/View;III)Landroid/graphics/Bitmap;

    .line 1547
    new-array v9, v6, [I

    .line 1548
    .local v9, "progressLocation":[I
    invoke-virtual {p1}, Lco/vine/android/DraftFragment;->getProgressView()Landroid/view/View;

    move-result-object v3

    .line 1549
    .local v3, "progressView":Landroid/view/View;
    invoke-virtual {v3, v9}, Landroid/view/View;->getLocationOnScreen([I)V

    .line 1551
    iget-object v4, p0, Lco/vine/android/AbstractRecordingActivity;->mProgressOverlay:Landroid/view/View;

    invoke-virtual {v3}, Landroid/view/View;->getWidth()I

    move-result v5

    aget v6, v9, v11

    aget v0, v9, v7

    sub-int v7, v0, v10

    move-object v2, p0

    invoke-static/range {v2 .. v7}, Lco/vine/android/util/FloatingViewUtils;->buildFloatingViewFor(Landroid/content/Context;Landroid/view/View;Landroid/view/View;III)Landroid/graphics/Bitmap;

    .line 1553
    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mPreviewOverlay:Landroid/view/View;

    invoke-virtual {v0, v11}, Landroid/view/View;->setVisibility(I)V

    .line 1554
    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mProgressOverlay:Landroid/view/View;

    invoke-virtual {v0, v11}, Landroid/view/View;->setVisibility(I)V

    .line 1555
    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mDraftTrashContainer:Landroid/view/View;

    invoke-virtual {v0, v12}, Landroid/view/View;->setVisibility(I)V

    .line 1556
    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mViewPager:Landroid/support/v4/view/DraftViewPager;

    invoke-virtual {v0, v12}, Landroid/support/v4/view/DraftViewPager;->setVisibility(I)V

    .line 1557
    return-void
.end method

.method private getActiveRecordingFragment()Lco/vine/android/RecordingFragment;
    .locals 1

    .prologue
    .line 1325
    invoke-virtual {p0}, Lco/vine/android/AbstractRecordingActivity;->isDraftsShowing()Z

    move-result v0

    if-nez v0, :cond_0

    iget v0, p0, Lco/vine/android/AbstractRecordingActivity;->mStep:I

    if-nez v0, :cond_0

    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mCurrentFragment:Landroid/support/v4/app/Fragment;

    instance-of v0, v0, Lco/vine/android/RecordingFragment;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mCurrentFragment:Landroid/support/v4/app/Fragment;

    check-cast v0, Lco/vine/android/RecordingFragment;

    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private static getIntent(Landroid/content/Context;ILjava/lang/String;ZJJZLjava/lang/String;ZZ)Landroid/content/Intent;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "flags"    # I
    .param p2, "tag"    # Ljava/lang/String;
    .param p3, "isMessaging"    # Z
    .param p4, "conversationRowId"    # J
    .param p6, "directUserId"    # J
    .param p8, "startConversation"    # Z
    .param p9, "recipientName"    # Ljava/lang/String;
    .param p10, "amFollowing"    # Z
    .param p11, "isVmOnboarding"    # Z

    .prologue
    .line 267
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lco/vine/android/RecordingActivity;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 268
    .local v0, "intent":Landroid/content/Intent;
    invoke-virtual {v0, p2}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 269
    if-lez p1, :cond_0

    .line 270
    invoke-virtual {v0, p1}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 272
    :cond_0
    const-string v1, "messaging"

    invoke-virtual {v0, v1, p3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 273
    const-string v1, "conv_row_id"

    invoke-virtual {v0, v1, p4, p5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;J)Landroid/content/Intent;

    .line 274
    const-string v1, "direct_id"

    invoke-virtual {v0, v1, p6, p7}, Landroid/content/Intent;->putExtra(Ljava/lang/String;J)Landroid/content/Intent;

    .line 275
    const-string v1, "start_conversation"

    invoke-virtual {v0, v1, p8}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 276
    const-string v1, "recipient_username"

    invoke-virtual {v0, v1, p9}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 277
    const-string v1, "am_following"

    invoke-virtual {v0, v1, p10}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 278
    const-string v1, "is_vm_onboarding"

    invoke-virtual {v0, v1, p11}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 279
    return-object v0
.end method

.method public static getIntentForConversation(Landroid/content/Context;ILjava/lang/String;JZLjava/lang/String;Z)Landroid/content/Intent;
    .locals 12
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "flags"    # I
    .param p2, "tag"    # Ljava/lang/String;
    .param p3, "conversationRowId"    # J
    .param p5, "startConversation"    # Z
    .param p6, "username"    # Ljava/lang/String;
    .param p7, "amFollowing"    # Z

    .prologue
    .line 259
    const/4 v3, 0x1

    const-wide/16 v6, -0x1

    const/4 v11, 0x0

    move-object v0, p0

    move v1, p1

    move-object v2, p2

    move-wide v4, p3

    move/from16 v8, p5

    move-object/from16 v9, p6

    move/from16 v10, p7

    invoke-static/range {v0 .. v11}, Lco/vine/android/AbstractRecordingActivity;->getIntent(Landroid/content/Context;ILjava/lang/String;ZJJZLjava/lang/String;ZZ)Landroid/content/Intent;

    move-result-object v0

    return-object v0
.end method

.method public static getIntentForGeneric(Landroid/content/Context;ILjava/lang/String;)Landroid/content/Intent;
    .locals 12
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "flags"    # I
    .param p2, "tag"    # Ljava/lang/String;

    .prologue
    const-wide/16 v4, -0x1

    const/4 v3, 0x0

    .line 239
    const/4 v9, 0x0

    move-object v0, p0

    move v1, p1

    move-object v2, p2

    move-wide v6, v4

    move v8, v3

    move v10, v3

    move v11, v3

    invoke-static/range {v0 .. v11}, Lco/vine/android/AbstractRecordingActivity;->getIntent(Landroid/content/Context;ILjava/lang/String;ZJJZLjava/lang/String;ZZ)Landroid/content/Intent;

    move-result-object v0

    return-object v0
.end method

.method public static getIntentForMessaging(Landroid/content/Context;IZLjava/lang/String;)Landroid/content/Intent;
    .locals 12
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "flags"    # I
    .param p2, "isVmOnboarding"    # Z
    .param p3, "tag"    # Ljava/lang/String;

    .prologue
    const-wide/16 v4, -0x1

    const/4 v8, 0x0

    .line 253
    const/4 v3, 0x1

    const/4 v9, 0x0

    move-object v0, p0

    move v1, p1

    move-object v2, p3

    move-wide v6, v4

    move v10, v8

    move v11, p2

    invoke-static/range {v0 .. v11}, Lco/vine/android/AbstractRecordingActivity;->getIntent(Landroid/content/Context;ILjava/lang/String;ZJJZLjava/lang/String;ZZ)Landroid/content/Intent;

    move-result-object v0

    return-object v0
.end method

.method private getVersion()Lco/vine/android/recorder/RecordSessionVersion;
    .locals 1
    .annotation build Lorg/jetbrains/annotations/NotNull;
    .end annotation

    .prologue
    .line 231
    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mVersion:Lco/vine/android/recorder/RecordSessionVersion;

    if-nez v0, :cond_0

    .line 232
    invoke-static {p0}, Lco/vine/android/recorder/RecordSessionManager;->getCurrentVersion(Landroid/content/Context;)Lco/vine/android/recorder/RecordSessionVersion;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mVersion:Lco/vine/android/recorder/RecordSessionVersion;

    .line 234
    :cond_0
    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mVersion:Lco/vine/android/recorder/RecordSessionVersion;

    return-object v0
.end method

.method private handleDelete()V
    .locals 33

    .prologue
    .line 1825
    const/16 v31, 0x0

    .line 1826
    .local v31, "noAnimationDelete":Z
    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/AbstractRecordingActivity;->mDraftFragments:Landroid/util/SparseArray;

    move-object/from16 v0, p0

    iget v9, v0, Lco/vine/android/AbstractRecordingActivity;->mCurrentPage:I

    invoke-virtual {v3, v9}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v25

    check-cast v25, Ljava/lang/ref/WeakReference;

    .line 1827
    .local v25, "currentFragmentRef":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/DraftFragment;>;"
    if-eqz v25, :cond_b

    .line 1828
    invoke-virtual/range {v25 .. v25}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v24

    check-cast v24, Lco/vine/android/DraftFragment;

    .line 1829
    .local v24, "currentFragment":Lco/vine/android/DraftFragment;
    const v3, 0x7f040013

    move-object/from16 v0, p0

    invoke-static {v0, v3}, Landroid/view/animation/AnimationUtils;->loadAnimation(Landroid/content/Context;I)Landroid/view/animation/Animation;

    move-result-object v27

    .line 1830
    .local v27, "fadeOut":Landroid/view/animation/Animation;
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/AbstractRecordingActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v9, 0x7f0b0031

    invoke-virtual {v3, v9}, Landroid/content/res/Resources;->getDimensionPixelOffset(I)I

    move-result v6

    .line 1831
    .local v6, "offset":I
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/AbstractRecordingActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v9, 0x7f0b0036

    invoke-virtual {v3, v9}, Landroid/content/res/Resources;->getDimensionPixelOffset(I)I

    move-result v7

    .line 1833
    .local v7, "margin":I
    move-object/from16 v0, p0

    iget v3, v0, Lco/vine/android/AbstractRecordingActivity;->mCurrentPage:I

    if-lez v3, :cond_5

    .line 1834
    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/AbstractRecordingActivity;->mDraftFragments:Landroid/util/SparseArray;

    move-object/from16 v0, p0

    iget v9, v0, Lco/vine/android/AbstractRecordingActivity;->mCurrentPage:I

    add-int/lit8 v9, v9, -0x1

    invoke-virtual {v3, v9}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/ref/WeakReference;

    invoke-virtual {v3}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Lco/vine/android/DraftFragment;

    .line 1835
    .local v8, "prevFragment":Lco/vine/android/DraftFragment;
    if-eqz v8, :cond_4

    if-eqz v24, :cond_4

    .line 1836
    invoke-virtual {v8}, Lco/vine/android/DraftFragment;->getThumbnailView()Landroid/view/View;

    move-result-object v4

    .line 1837
    .local v4, "prevView":Landroid/view/View;
    const/4 v3, 0x2

    new-array v5, v3, [I

    .line 1838
    .local v5, "previewLocation":[I
    invoke-virtual {v4, v5}, Landroid/view/View;->getLocationOnScreen([I)V

    .line 1840
    new-instance v2, Lco/vine/android/AbstractRecordingActivity$12;

    move-object/from16 v3, p0

    invoke-direct/range {v2 .. v8}, Lco/vine/android/AbstractRecordingActivity$12;-><init>(Lco/vine/android/AbstractRecordingActivity;Landroid/view/View;[IIILco/vine/android/DraftFragment;)V

    .line 1856
    .local v2, "l":Lco/vine/android/animation/SimpleAnimationListener;
    move-object/from16 v0, v27

    invoke-virtual {v0, v2}, Landroid/view/animation/Animation;->setAnimationListener(Landroid/view/animation/Animation$AnimationListener;)V

    .line 1857
    invoke-virtual {v8}, Lco/vine/android/DraftFragment;->getView()Landroid/view/View;

    move-result-object v32

    .line 1858
    .local v32, "view":Landroid/view/View;
    if-eqz v32, :cond_0

    .line 1859
    const/4 v3, 0x4

    move-object/from16 v0, v32

    invoke-virtual {v0, v3}, Landroid/view/View;->setVisibility(I)V

    .line 1861
    :cond_0
    invoke-virtual/range {v24 .. v24}, Lco/vine/android/DraftFragment;->getView()Landroid/view/View;

    move-result-object v32

    .line 1862
    if-eqz v32, :cond_3

    move-object/from16 v0, p0

    iget-boolean v3, v0, Lco/vine/android/AbstractRecordingActivity;->mDeleteWasDrag:Z

    if-nez v3, :cond_3

    .line 1863
    move-object/from16 v0, v32

    move-object/from16 v1, v27

    invoke-virtual {v0, v1}, Landroid/view/View;->startAnimation(Landroid/view/animation/Animation;)V

    .line 1929
    .end local v2    # "l":Lco/vine/android/animation/SimpleAnimationListener;
    .end local v4    # "prevView":Landroid/view/View;
    .end local v5    # "previewLocation":[I
    .end local v6    # "offset":I
    .end local v7    # "margin":I
    .end local v8    # "prevFragment":Lco/vine/android/DraftFragment;
    .end local v24    # "currentFragment":Lco/vine/android/DraftFragment;
    .end local v27    # "fadeOut":Landroid/view/animation/Animation;
    .end local v32    # "view":Landroid/view/View;
    :cond_1
    :goto_0
    if-eqz v31, :cond_2

    .line 1932
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/AbstractRecordingActivity;->deleteCurrentDraft()V

    .line 1934
    :cond_2
    return-void

    .line 1864
    .restart local v2    # "l":Lco/vine/android/animation/SimpleAnimationListener;
    .restart local v4    # "prevView":Landroid/view/View;
    .restart local v5    # "previewLocation":[I
    .restart local v6    # "offset":I
    .restart local v7    # "margin":I
    .restart local v8    # "prevFragment":Lco/vine/android/DraftFragment;
    .restart local v24    # "currentFragment":Lco/vine/android/DraftFragment;
    .restart local v27    # "fadeOut":Landroid/view/animation/Animation;
    .restart local v32    # "view":Landroid/view/View;
    :cond_3
    if-eqz v32, :cond_1

    .line 1865
    move-object/from16 v0, v27

    invoke-virtual {v2, v0}, Lco/vine/android/animation/SimpleAnimationListener;->onAnimationEnd(Landroid/view/animation/Animation;)V

    goto :goto_0

    .line 1868
    .end local v2    # "l":Lco/vine/android/animation/SimpleAnimationListener;
    .end local v4    # "prevView":Landroid/view/View;
    .end local v5    # "previewLocation":[I
    .end local v32    # "view":Landroid/view/View;
    :cond_4
    const/16 v31, 0x1

    goto :goto_0

    .line 1870
    .end local v8    # "prevFragment":Lco/vine/android/DraftFragment;
    :cond_5
    move-object/from16 v0, p0

    iget v3, v0, Lco/vine/android/AbstractRecordingActivity;->mCurrentPage:I

    if-nez v3, :cond_1

    .line 1871
    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/AbstractRecordingActivity;->mSessions:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v3

    const/4 v9, 0x1

    if-ne v3, v9, :cond_6

    .line 1873
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/AbstractRecordingActivity;->deleteCurrentDraft()V

    .line 1874
    const/4 v3, 0x1

    move-object/from16 v0, p0

    invoke-virtual {v0, v3}, Lco/vine/android/AbstractRecordingActivity;->hideDrafts(Z)V

    .line 1875
    const-string v3, "Delete"

    const/4 v9, 0x0

    move-object/from16 v0, p0

    invoke-virtual {v0, v3, v9}, Lco/vine/android/AbstractRecordingActivity;->swapFolder(Ljava/lang/String;Ljava/io/File;)V

    goto :goto_0

    .line 1878
    :cond_6
    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/AbstractRecordingActivity;->mDraftFragments:Landroid/util/SparseArray;

    move-object/from16 v0, p0

    iget v9, v0, Lco/vine/android/AbstractRecordingActivity;->mCurrentPage:I

    add-int/lit8 v9, v9, 0x1

    invoke-virtual {v3, v9}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v29

    check-cast v29, Ljava/lang/ref/WeakReference;

    .line 1880
    .local v29, "nextFragmentRef":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/DraftFragment;>;"
    if-eqz v29, :cond_a

    .line 1881
    invoke-virtual/range {v29 .. v29}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v28

    check-cast v28, Lco/vine/android/DraftFragment;

    .line 1882
    .local v28, "nextFragment":Lco/vine/android/DraftFragment;
    if-eqz v28, :cond_9

    if-eqz v24, :cond_9

    .line 1883
    invoke-virtual/range {v28 .. v28}, Lco/vine/android/DraftFragment;->getThumbnailView()Landroid/view/View;

    move-result-object v10

    .line 1884
    .local v10, "nextView":Landroid/view/View;
    const/4 v3, 0x2

    new-array v0, v3, [I

    move-object/from16 v30, v0

    .line 1885
    .local v30, "nextLocation":[I
    move-object/from16 v0, v30

    invoke-virtual {v10, v0}, Landroid/view/View;->getLocationOnScreen([I)V

    .line 1887
    :try_start_0
    move-object/from16 v0, p0

    iget-object v11, v0, Lco/vine/android/AbstractRecordingActivity;->mPreviewOverlay:Landroid/view/View;

    invoke-virtual {v10}, Landroid/view/View;->getWidth()I

    move-result v12

    const/4 v3, 0x0

    aget v13, v30, v3

    const/4 v3, 0x1

    aget v3, v30, v3

    sub-int v14, v3, v6

    move-object/from16 v9, p0

    invoke-static/range {v9 .. v14}, Lco/vine/android/util/FloatingViewUtils;->buildFloatingViewFor(Landroid/content/Context;Landroid/view/View;Landroid/view/View;III)Landroid/graphics/Bitmap;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 1894
    :goto_1
    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/AbstractRecordingActivity;->mPreviewOverlay:Landroid/view/View;

    const/4 v9, 0x0

    invoke-virtual {v3, v9}, Landroid/view/View;->setVisibility(I)V

    .line 1896
    new-instance v11, Lco/vine/android/animation/MoveResizeAnimator;

    const/4 v12, 0x3

    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/AbstractRecordingActivity;->mPreviewOverlay:Landroid/view/View;

    move-object/from16 v0, p0

    iget-object v14, v0, Lco/vine/android/AbstractRecordingActivity;->mPreviewOverlay:Landroid/view/View;

    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/AbstractRecordingActivity;->mScreenSize:Landroid/graphics/Point;

    iget v3, v3, Landroid/graphics/Point;->x:I

    int-to-float v3, v3

    const/high16 v9, 0x3f800000    # 1.0f

    move-object/from16 v0, p0

    iget v15, v0, Lco/vine/android/AbstractRecordingActivity;->mPreviewRatio:F

    sub-float/2addr v9, v15

    mul-float/2addr v3, v9

    float-to-int v3, v3

    mul-int/lit8 v9, v7, 0x4

    sub-int v15, v3, v9

    const/4 v3, 0x1

    aget v3, v30, v3

    sub-int v16, v3, v6

    const-wide/high16 v17, 0x3ff0000000000000L    # 1.0

    const-wide/high16 v19, 0x3ff0000000000000L    # 1.0

    const/16 v21, 0x12c

    invoke-virtual/range {v28 .. v28}, Lco/vine/android/DraftFragment;->getView()Landroid/view/View;

    move-result-object v23

    move-object/from16 v22, p0

    invoke-direct/range {v11 .. v23}, Lco/vine/android/animation/MoveResizeAnimator;-><init>(ILandroid/view/View;Landroid/view/View;IIDDILco/vine/android/animation/SmoothAnimator$AnimationListener;Ljava/lang/Object;)V

    .line 1902
    .local v11, "animator":Lco/vine/android/animation/MoveResizeAnimator;
    new-instance v3, Lco/vine/android/AbstractRecordingActivity$13;

    move-object/from16 v0, p0

    invoke-direct {v3, v0, v11}, Lco/vine/android/AbstractRecordingActivity$13;-><init>(Lco/vine/android/AbstractRecordingActivity;Lco/vine/android/animation/MoveResizeAnimator;)V

    move-object/from16 v0, v27

    invoke-virtual {v0, v3}, Landroid/view/animation/Animation;->setAnimationListener(Landroid/view/animation/Animation$AnimationListener;)V

    .line 1908
    invoke-virtual/range {v28 .. v28}, Lco/vine/android/DraftFragment;->getView()Landroid/view/View;

    move-result-object v32

    .line 1909
    .restart local v32    # "view":Landroid/view/View;
    if-eqz v32, :cond_7

    .line 1910
    const/4 v3, 0x4

    move-object/from16 v0, v32

    invoke-virtual {v0, v3}, Landroid/view/View;->setVisibility(I)V

    .line 1912
    :cond_7
    invoke-virtual/range {v24 .. v24}, Lco/vine/android/DraftFragment;->getView()Landroid/view/View;

    move-result-object v32

    .line 1913
    if-eqz v32, :cond_8

    move-object/from16 v0, p0

    iget-boolean v3, v0, Lco/vine/android/AbstractRecordingActivity;->mDeleteWasDrag:Z

    if-nez v3, :cond_8

    .line 1914
    move-object/from16 v0, v32

    move-object/from16 v1, v27

    invoke-virtual {v0, v1}, Landroid/view/View;->startAnimation(Landroid/view/animation/Animation;)V

    goto/16 :goto_0

    .line 1890
    .end local v11    # "animator":Lco/vine/android/animation/MoveResizeAnimator;
    .end local v32    # "view":Landroid/view/View;
    :catch_0
    move-exception v26

    .line 1892
    .local v26, "e":Ljava/lang/Exception;
    invoke-static/range {v26 .. v26}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;)V

    goto :goto_1

    .line 1916
    .end local v26    # "e":Ljava/lang/Exception;
    .restart local v11    # "animator":Lco/vine/android/animation/MoveResizeAnimator;
    .restart local v32    # "view":Landroid/view/View;
    :cond_8
    invoke-virtual {v11}, Lco/vine/android/animation/MoveResizeAnimator;->start()V

    goto/16 :goto_0

    .line 1919
    .end local v10    # "nextView":Landroid/view/View;
    .end local v11    # "animator":Lco/vine/android/animation/MoveResizeAnimator;
    .end local v30    # "nextLocation":[I
    .end local v32    # "view":Landroid/view/View;
    :cond_9
    const/16 v31, 0x1

    goto/16 :goto_0

    .line 1922
    .end local v28    # "nextFragment":Lco/vine/android/DraftFragment;
    :cond_a
    const/16 v31, 0x1

    goto/16 :goto_0

    .line 1927
    .end local v6    # "offset":I
    .end local v7    # "margin":I
    .end local v24    # "currentFragment":Lco/vine/android/DraftFragment;
    .end local v27    # "fadeOut":Landroid/view/animation/Animation;
    .end local v29    # "nextFragmentRef":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/DraftFragment;>;"
    :cond_b
    const/16 v31, 0x1

    goto/16 :goto_0
.end method

.method private hideCurrentFragment()V
    .locals 5

    .prologue
    .line 526
    iget-object v3, p0, Lco/vine/android/AbstractRecordingActivity;->mDraftFragments:Landroid/util/SparseArray;

    iget v4, p0, Lco/vine/android/AbstractRecordingActivity;->mCurrentPage:I

    invoke-virtual {v3, v4}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/ref/WeakReference;

    .line 527
    .local v0, "fragment":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/DraftFragment;>;"
    if-eqz v0, :cond_0

    .line 528
    invoke-virtual {v0}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lco/vine/android/DraftFragment;

    .line 529
    .local v1, "ref":Lco/vine/android/DraftFragment;
    if-eqz v1, :cond_0

    .line 530
    invoke-virtual {v1}, Lco/vine/android/DraftFragment;->pausePlayer()V

    .line 531
    invoke-virtual {v1}, Lco/vine/android/DraftFragment;->getView()Landroid/view/View;

    move-result-object v2

    .line 532
    .local v2, "toHide":Landroid/view/View;
    if-eqz v2, :cond_0

    .line 533
    const/16 v3, 0x8

    invoke-virtual {v2, v3}, Landroid/view/View;->setVisibility(I)V

    .line 537
    .end local v1    # "ref":Lco/vine/android/DraftFragment;
    .end local v2    # "toHide":Landroid/view/View;
    :cond_0
    return-void
.end method

.method private hideDraftsInternal()V
    .locals 2

    .prologue
    const/16 v1, 0x8

    .line 939
    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mDraftRoot:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 940
    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mProgressOverlay:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 941
    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mPreviewOverlay:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 942
    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mProgressOverlay:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 943
    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mDragUpToDeleteView:Lco/vine/android/widget/DragUpToDeleteContainer;

    invoke-virtual {v0, v1}, Lco/vine/android/widget/DragUpToDeleteContainer;->setVisibility(I)V

    .line 944
    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mCurrentFragment:Landroid/support/v4/app/Fragment;

    instance-of v0, v0, Lco/vine/android/RecordingFragment;

    if-eqz v0, :cond_0

    .line 945
    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mCurrentFragment:Landroid/support/v4/app/Fragment;

    check-cast v0, Lco/vine/android/RecordingFragment;

    invoke-virtual {v0}, Lco/vine/android/RecordingFragment;->onHideDrafts()V

    .line 947
    :cond_0
    return-void
.end method

.method private isResuming()Z
    .locals 1

    .prologue
    .line 1959
    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mCurrentFragment:Landroid/support/v4/app/Fragment;

    instance-of v0, v0, Lco/vine/android/RecordingFragment;

    if-eqz v0, :cond_2

    .line 1960
    iget-boolean v0, p0, Lco/vine/android/AbstractRecordingActivity;->mIsGoingToRecord:Z

    if-nez v0, :cond_0

    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mCurrentFragment:Landroid/support/v4/app/Fragment;

    check-cast v0, Lco/vine/android/RecordingFragment;

    invoke-virtual {v0}, Lco/vine/android/RecordingFragment;->isResuming()Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    .line 1962
    :goto_0
    return v0

    .line 1960
    :cond_1
    const/4 v0, 0x0

    goto :goto_0

    .line 1962
    :cond_2
    iget-boolean v0, p0, Lco/vine/android/AbstractRecordingActivity;->mIsGoingToRecord:Z

    goto :goto_0
.end method

.method private releasePlayers()V
    .locals 5

    .prologue
    .line 1525
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    iget-object v3, p0, Lco/vine/android/AbstractRecordingActivity;->mDraftFragments:Landroid/util/SparseArray;

    invoke-virtual {v3}, Landroid/util/SparseArray;->size()I

    move-result v3

    if-ge v0, v3, :cond_1

    .line 1526
    iget-object v3, p0, Lco/vine/android/AbstractRecordingActivity;->mDraftFragments:Landroid/util/SparseArray;

    iget-object v4, p0, Lco/vine/android/AbstractRecordingActivity;->mDraftFragments:Landroid/util/SparseArray;

    invoke-virtual {v4, v0}, Landroid/util/SparseArray;->keyAt(I)I

    move-result v4

    invoke-virtual {v3, v4}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/ref/WeakReference;

    .line 1527
    .local v1, "r":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/DraftFragment;>;"
    invoke-virtual {v1}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lco/vine/android/DraftFragment;

    .line 1528
    .local v2, "ref":Lco/vine/android/DraftFragment;
    if-eqz v2, :cond_0

    .line 1529
    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Lco/vine/android/DraftFragment;->setSelected(Z)V

    .line 1530
    invoke-virtual {v2}, Lco/vine/android/DraftFragment;->release()V

    .line 1525
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 1533
    .end local v1    # "r":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/DraftFragment;>;"
    .end local v2    # "ref":Lco/vine/android/DraftFragment;
    :cond_1
    return-void
.end method

.method private reload(Ljava/util/ArrayList;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/recorder/RecordSessionManager$RecordSessionInfo;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 1560
    .local p1, "sessions":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/recorder/RecordSessionManager$RecordSessionInfo;>;"
    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    move-result v0

    .line 1561
    .local v0, "size":I
    const/16 v1, 0x9

    if-le v0, v1, :cond_0

    .line 1562
    const/4 v1, 0x3

    invoke-static {v1}, Lco/vine/android/widgets/PromptDialogFragment;->newInstance(I)Lco/vine/android/widgets/PromptDialogFragment;

    move-result-object v1

    iput-object v1, p0, Lco/vine/android/AbstractRecordingActivity;->mPromptDialog:Lco/vine/android/widgets/PromptDialogFragment;

    .line 1563
    iget-object v1, p0, Lco/vine/android/AbstractRecordingActivity;->mPromptDialog:Lco/vine/android/widgets/PromptDialogFragment;

    const v2, 0x7f0e024c

    invoke-virtual {v1, v2}, Lco/vine/android/widgets/PromptDialogFragment;->setMessage(I)Lco/vine/android/widgets/PromptDialogFragment;

    .line 1564
    iget-object v1, p0, Lco/vine/android/AbstractRecordingActivity;->mPromptDialog:Lco/vine/android/widgets/PromptDialogFragment;

    const v2, 0x7f0e0163

    invoke-virtual {v1, v2}, Lco/vine/android/widgets/PromptDialogFragment;->setPositiveButton(I)Lco/vine/android/widgets/PromptDialogFragment;

    .line 1565
    iget-object v1, p0, Lco/vine/android/AbstractRecordingActivity;->mPromptDialog:Lco/vine/android/widgets/PromptDialogFragment;

    invoke-virtual {p0}, Lco/vine/android/AbstractRecordingActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v2

    invoke-virtual {v1, v2}, Lco/vine/android/widgets/PromptDialogFragment;->show(Landroid/app/FragmentManager;)V

    .line 1566
    add-int/lit8 v1, v0, -0x1

    invoke-virtual {p1, v1}, Ljava/util/ArrayList;->remove(I)Ljava/lang/Object;

    .line 1568
    :cond_0
    iput-object p1, p0, Lco/vine/android/AbstractRecordingActivity;->mSessions:Ljava/util/ArrayList;

    .line 1569
    new-instance v1, Lco/vine/android/AbstractRecordingActivity$DraftPagerImpl;

    invoke-virtual {p0}, Lco/vine/android/AbstractRecordingActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v2

    invoke-direct {v1, p0, v2}, Lco/vine/android/AbstractRecordingActivity$DraftPagerImpl;-><init>(Lco/vine/android/AbstractRecordingActivity;Landroid/support/v4/app/FragmentManager;)V

    iput-object v1, p0, Lco/vine/android/AbstractRecordingActivity;->mAdapter:Lco/vine/android/AbstractRecordingActivity$DraftPagerImpl;

    .line 1570
    iget-object v1, p0, Lco/vine/android/AbstractRecordingActivity;->mViewPager:Landroid/support/v4/view/DraftViewPager;

    iget-object v2, p0, Lco/vine/android/AbstractRecordingActivity;->mAdapter:Lco/vine/android/AbstractRecordingActivity$DraftPagerImpl;

    invoke-virtual {v1, v2}, Landroid/support/v4/view/DraftViewPager;->setAdapter(Landroid/support/v4/app/DraftFragmentStatePagerAdapter;)V

    .line 1571
    iget-object v1, p0, Lco/vine/android/AbstractRecordingActivity;->mViewPager:Landroid/support/v4/view/DraftViewPager;

    invoke-virtual {v1, p0}, Landroid/support/v4/view/DraftViewPager;->setOnPageChangeListener(Landroid/support/v4/view/DraftViewPager$OnPageChangeListener;)V

    .line 1572
    iget-object v1, p0, Lco/vine/android/AbstractRecordingActivity;->mViewPager:Landroid/support/v4/view/DraftViewPager;

    iget-object v2, p0, Lco/vine/android/AbstractRecordingActivity;->mAdapter:Lco/vine/android/AbstractRecordingActivity$DraftPagerImpl;

    invoke-virtual {v2}, Lco/vine/android/AbstractRecordingActivity$DraftPagerImpl;->getCount()I

    move-result v2

    add-int/lit8 v2, v2, 0x1

    invoke-virtual {v1, v2}, Landroid/support/v4/view/DraftViewPager;->setOffscreenPageLimit(I)V

    .line 1573
    iget-object v1, p0, Lco/vine/android/AbstractRecordingActivity;->mDots:Lco/vine/android/widget/DotIndicators;

    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    move-result v2

    invoke-virtual {v1, v2}, Lco/vine/android/widget/DotIndicators;->setNumberOfDots(I)V

    .line 1574
    iget-object v1, p0, Lco/vine/android/AbstractRecordingActivity;->mDots:Lco/vine/android/widget/DotIndicators;

    invoke-virtual {v1}, Lco/vine/android/widget/DotIndicators;->invalidate()V

    .line 1575
    return-void
.end method

.method private setCurrentSession()Z
    .locals 10

    .prologue
    const/4 v7, 0x0

    const/4 v6, 0x1

    .line 1751
    const/4 v0, 0x0

    .line 1752
    .local v0, "i":I
    iget-object v8, p0, Lco/vine/android/AbstractRecordingActivity;->mViewPager:Landroid/support/v4/view/DraftViewPager;

    invoke-virtual {v8}, Landroid/support/v4/view/DraftViewPager;->isDrawn()Z

    move-result v8

    if-eqz v8, :cond_4

    iget-boolean v8, p0, Lco/vine/android/AbstractRecordingActivity;->mFirstPageSet:Z

    if-nez v8, :cond_4

    .line 1753
    iget-object v8, p0, Lco/vine/android/AbstractRecordingActivity;->mStartSessionId:Ljava/lang/String;

    invoke-static {v8}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v8

    if-nez v8, :cond_0

    const-string v8, "camera_preview"

    iget-object v9, p0, Lco/vine/android/AbstractRecordingActivity;->mStartSessionId:Ljava/lang/String;

    invoke-virtual {v8, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_1

    .line 1754
    :cond_0
    iget-object v8, p0, Lco/vine/android/AbstractRecordingActivity;->mViewPager:Landroid/support/v4/view/DraftViewPager;

    iget-object v9, p0, Lco/vine/android/AbstractRecordingActivity;->mAdapter:Lco/vine/android/AbstractRecordingActivity$DraftPagerImpl;

    invoke-virtual {v9}, Lco/vine/android/AbstractRecordingActivity$DraftPagerImpl;->getCount()I

    move-result v9

    add-int/lit8 v9, v9, -0x1

    invoke-virtual {v8, v9, v7}, Landroid/support/v4/view/DraftViewPager;->setCurrentItem(IZ)V

    .line 1755
    iput-boolean v6, p0, Lco/vine/android/AbstractRecordingActivity;->mFirstPageSet:Z

    .line 1778
    :goto_0
    return v6

    .line 1758
    :cond_1
    iget-object v8, p0, Lco/vine/android/AbstractRecordingActivity;->mSessions:Ljava/util/ArrayList;

    invoke-virtual {v8}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_4

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/recorder/RecordSessionManager$RecordSessionInfo;

    .line 1759
    .local v4, "session":Lco/vine/android/recorder/RecordSessionManager$RecordSessionInfo;
    iget-object v8, p0, Lco/vine/android/AbstractRecordingActivity;->mStartSessionId:Ljava/lang/String;

    iget-object v9, v4, Lco/vine/android/recorder/RecordSessionManager$RecordSessionInfo;->folder:Ljava/io/File;

    invoke-virtual {v9}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_3

    .line 1760
    iget-object v8, p0, Lco/vine/android/AbstractRecordingActivity;->mViewPager:Landroid/support/v4/view/DraftViewPager;

    invoke-virtual {v8, v0, v7}, Landroid/support/v4/view/DraftViewPager;->setCurrentItem(IZ)V

    .line 1761
    iput v0, p0, Lco/vine/android/AbstractRecordingActivity;->mCurrentPage:I

    .line 1762
    iput-boolean v6, p0, Lco/vine/android/AbstractRecordingActivity;->mFirstPageSet:Z

    .line 1763
    iget-object v7, p0, Lco/vine/android/AbstractRecordingActivity;->mDraftFragments:Landroid/util/SparseArray;

    iget v8, p0, Lco/vine/android/AbstractRecordingActivity;->mCurrentPage:I

    invoke-virtual {v7, v8}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/ref/WeakReference;

    .line 1764
    .local v2, "item":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/DraftFragment;>;"
    const/4 v5, 0x0

    .line 1765
    .local v5, "toSet":Landroid/view/View;
    if-eqz v2, :cond_2

    .line 1766
    invoke-virtual {v2}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lco/vine/android/DraftFragment;

    .line 1767
    .local v3, "ref":Lco/vine/android/DraftFragment;
    if-eqz v3, :cond_2

    .line 1768
    invoke-virtual {v3}, Lco/vine/android/DraftFragment;->getView()Landroid/view/View;

    move-result-object v7

    const v8, 0x7f0a00d5

    invoke-virtual {v7, v8}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    .line 1771
    .end local v3    # "ref":Lco/vine/android/DraftFragment;
    :cond_2
    iget-object v7, p0, Lco/vine/android/AbstractRecordingActivity;->mDragUpToDeleteView:Lco/vine/android/widget/DragUpToDeleteContainer;

    iget-object v8, p0, Lco/vine/android/AbstractRecordingActivity;->mViewPager:Landroid/support/v4/view/DraftViewPager;

    invoke-virtual {v8}, Landroid/support/v4/view/DraftViewPager;->getLeftOfSelectedFragment()I

    move-result v8

    invoke-virtual {v7, v5, v8}, Lco/vine/android/widget/DragUpToDeleteContainer;->setView(Landroid/view/View;I)V

    goto :goto_0

    .line 1774
    .end local v2    # "item":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/DraftFragment;>;"
    .end local v5    # "toSet":Landroid/view/View;
    :cond_3
    add-int/lit8 v0, v0, 0x1

    .line 1775
    goto :goto_1

    .end local v1    # "i$":Ljava/util/Iterator;
    .end local v4    # "session":Lco/vine/android/recorder/RecordSessionManager$RecordSessionInfo;
    :cond_4
    move v6, v7

    .line 1778
    goto :goto_0
.end method

.method private showCurrentFragment()V
    .locals 5

    .prologue
    .line 576
    iget-object v3, p0, Lco/vine/android/AbstractRecordingActivity;->mDraftFragments:Landroid/util/SparseArray;

    iget v4, p0, Lco/vine/android/AbstractRecordingActivity;->mCurrentPage:I

    invoke-virtual {v3, v4}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/ref/WeakReference;

    .line 577
    .local v0, "fragment":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/DraftFragment;>;"
    if-eqz v0, :cond_0

    .line 578
    invoke-virtual {v0}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lco/vine/android/DraftFragment;

    .line 579
    .local v1, "ref":Lco/vine/android/DraftFragment;
    if-eqz v1, :cond_0

    .line 580
    const/4 v3, 0x1

    iput-boolean v3, v1, Lco/vine/android/DraftFragment;->mCanUnhide:Z

    .line 581
    invoke-virtual {v1}, Lco/vine/android/DraftFragment;->resumePlayer()V

    .line 582
    invoke-virtual {v1}, Lco/vine/android/DraftFragment;->getView()Landroid/view/View;

    move-result-object v2

    .line 583
    .local v2, "v":Landroid/view/View;
    if-eqz v2, :cond_0

    .line 584
    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/view/View;->setVisibility(I)V

    .line 588
    .end local v1    # "ref":Lco/vine/android/DraftFragment;
    .end local v2    # "v":Landroid/view/View;
    :cond_0
    return-void
.end method

.method private unbindDrawables(Landroid/view/View;)V
    .locals 3
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 1813
    invoke-virtual {p1}, Landroid/view/View;->getBackground()Landroid/graphics/drawable/Drawable;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 1814
    invoke-virtual {p1}, Landroid/view/View;->getBackground()Landroid/graphics/drawable/Drawable;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/graphics/drawable/Drawable;->setCallback(Landroid/graphics/drawable/Drawable$Callback;)V

    .line 1816
    :cond_0
    instance-of v1, p1, Landroid/view/ViewGroup;

    if-eqz v1, :cond_2

    .line 1817
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    move-object v1, p1

    check-cast v1, Landroid/view/ViewGroup;

    invoke-virtual {v1}, Landroid/view/ViewGroup;->getChildCount()I

    move-result v1

    if-ge v0, v1, :cond_1

    move-object v1, p1

    .line 1818
    check-cast v1, Landroid/view/ViewGroup;

    invoke-virtual {v1, v0}, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v1

    invoke-direct {p0, v1}, Lco/vine/android/AbstractRecordingActivity;->unbindDrawables(Landroid/view/View;)V

    .line 1817
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 1820
    :cond_1
    check-cast p1, Landroid/view/ViewGroup;

    .end local p1    # "view":Landroid/view/View;
    invoke-virtual {p1}, Landroid/view/ViewGroup;->removeAllViews()V

    .line 1822
    .end local v0    # "i":I
    :cond_2
    return-void
.end method


# virtual methods
.method public declared-synchronized addPlayerToPool(Lco/vine/android/player/SdkVideoView;)V
    .locals 1
    .param p1, "videoView"    # Lco/vine/android/player/SdkVideoView;

    .prologue
    .line 1604
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mVideoViews:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 1605
    monitor-exit p0

    return-void

    .line 1604
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public cameraPreviewToRecorder(Landroid/view/View;Landroid/view/View;)V
    .locals 19
    .param p1, "iconView"    # Landroid/view/View;
    .param p2, "previewIcon"    # Landroid/view/View;

    .prologue
    .line 1937
    invoke-direct/range {p0 .. p0}, Lco/vine/android/AbstractRecordingActivity;->isResuming()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 1956
    :goto_0
    return-void

    .line 1940
    :cond_0
    const/4 v1, 0x1

    move-object/from16 v0, p0

    iput-boolean v1, v0, Lco/vine/android/AbstractRecordingActivity;->mIsGoingToRecord:Z

    .line 1941
    move-object/from16 v0, p0

    iget-object v1, v0, Lco/vine/android/AbstractRecordingActivity;->mScreenSize:Landroid/graphics/Point;

    iget v1, v1, Landroid/graphics/Point;->x:I

    int-to-float v14, v1

    .line 1942
    .local v14, "fullSize":F
    invoke-virtual/range {p1 .. p1}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v1

    iget v1, v1, Landroid/view/ViewGroup$LayoutParams;->width:I

    int-to-float v1, v1

    div-float v16, v14, v1

    .line 1943
    .local v16, "ratio":F
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/AbstractRecordingActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0b006a

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDimensionPixelOffset(I)I

    move-result v17

    .line 1945
    .local v17, "top":I
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/AbstractRecordingActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0b0031

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDimensionPixelOffset(I)I

    move-result v18

    .line 1947
    .local v18, "topOffset":I
    const/4 v1, 0x2

    new-array v15, v1, [I

    .line 1948
    .local v15, "location":[I
    move-object/from16 v0, p1

    invoke-virtual {v0, v15}, Landroid/view/View;->getLocationInWindow([I)V

    .line 1949
    const/16 v1, 0x8

    move-object/from16 v0, p2

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 1951
    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/AbstractRecordingActivity;->mPreviewOverlay:Landroid/view/View;

    invoke-virtual/range {p1 .. p1}, Landroid/view/View;->getWidth()I

    move-result v4

    const/4 v1, 0x0

    aget v5, v15, v1

    const/4 v1, 0x1

    aget v1, v15, v1

    sub-int v6, v1, v18

    move-object/from16 v1, p0

    move-object/from16 v2, p1

    invoke-static/range {v1 .. v6}, Lco/vine/android/util/FloatingViewUtils;->buildFloatingViewFor(Landroid/content/Context;Landroid/view/View;Landroid/view/View;III)Landroid/graphics/Bitmap;

    .line 1953
    move-object/from16 v0, p0

    iget-object v1, v0, Lco/vine/android/AbstractRecordingActivity;->mPreviewOverlay:Landroid/view/View;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/view/View;->setVisibility(I)V

    .line 1954
    new-instance v1, Lco/vine/android/animation/MoveResizeAnimator;

    const/4 v2, 0x4

    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/AbstractRecordingActivity;->mPreviewOverlay:Landroid/view/View;

    move-object/from16 v0, p0

    iget-object v4, v0, Lco/vine/android/AbstractRecordingActivity;->mPreviewOverlay:Landroid/view/View;

    const/4 v5, 0x0

    move/from16 v0, v16

    float-to-double v7, v0

    move/from16 v0, v16

    float-to-double v9, v0

    const/16 v11, 0x12c

    move/from16 v6, v17

    move-object/from16 v12, p0

    move-object/from16 v13, p1

    invoke-direct/range {v1 .. v13}, Lco/vine/android/animation/MoveResizeAnimator;-><init>(ILandroid/view/View;Landroid/view/View;IIDDILco/vine/android/animation/SmoothAnimator$AnimationListener;Ljava/lang/Object;)V

    invoke-virtual {v1}, Lco/vine/android/animation/MoveResizeAnimator;->start()V

    goto :goto_0
.end method

.method protected createRecordingFragment()Lco/vine/android/RecordingFragment;
    .locals 1

    .prologue
    .line 1985
    new-instance v0, Lco/vine/android/RecordingFragment;

    invoke-direct {v0}, Lco/vine/android/RecordingFragment;-><init>()V

    return-object v0
.end method

.method protected createRecordingPreviewFragmentHw(Lco/vine/android/recorder/RecordingFile;Ljava/lang/String;)Lco/vine/android/RecordingPreviewFragment;
    .locals 13
    .param p1, "finalFile"    # Lco/vine/android/recorder/RecordingFile;
    .param p2, "thumbNailPath"    # Ljava/lang/String;

    .prologue
    .line 1975
    invoke-virtual {p1}, Lco/vine/android/recorder/RecordingFile;->getVideoPath()Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x0

    iget-boolean v3, p0, Lco/vine/android/AbstractRecordingActivity;->mIsMessaging:Z

    iget-wide v4, p0, Lco/vine/android/AbstractRecordingActivity;->mConversationRowId:J

    iget-wide v6, p0, Lco/vine/android/AbstractRecordingActivity;->mDirectUserId:J

    invoke-virtual {p0}, Lco/vine/android/AbstractRecordingActivity;->isFromSony()Z

    move-result v8

    iget v9, p0, Lco/vine/android/AbstractRecordingActivity;->mColor:I

    iget-object v10, p0, Lco/vine/android/AbstractRecordingActivity;->mRecipientUsername:Ljava/lang/String;

    iget-boolean v11, p0, Lco/vine/android/AbstractRecordingActivity;->mAmFollowingRecipient:Z

    iget-boolean v12, p0, Lco/vine/android/AbstractRecordingActivity;->mIsVmOnboarding:Z

    move-object v2, p2

    invoke-static/range {v0 .. v12}, Lco/vine/android/RecordingPreviewFragment;->newInstance(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZJJZILjava/lang/String;ZZ)Lco/vine/android/RecordingPreviewFragment;

    move-result-object v0

    return-object v0
.end method

.method protected createRecordingPreviewFragmentSw(Lco/vine/android/recorder/RecordingFile;Ljava/lang/String;)Lco/vine/android/RecordingPreviewFragment;
    .locals 13
    .param p1, "finalFile"    # Lco/vine/android/recorder/RecordingFile;
    .param p2, "thumbNailPath"    # Ljava/lang/String;

    .prologue
    .line 1967
    invoke-virtual {p1}, Lco/vine/android/recorder/RecordingFile;->getVideoPath()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lco/vine/android/AbstractRecordingActivity;->mUploadFile:Ljava/lang/String;

    iget-boolean v3, p0, Lco/vine/android/AbstractRecordingActivity;->mIsMessaging:Z

    iget-wide v4, p0, Lco/vine/android/AbstractRecordingActivity;->mConversationRowId:J

    iget-wide v6, p0, Lco/vine/android/AbstractRecordingActivity;->mDirectUserId:J

    invoke-virtual {p0}, Lco/vine/android/AbstractRecordingActivity;->isFromSony()Z

    move-result v8

    iget v9, p0, Lco/vine/android/AbstractRecordingActivity;->mColor:I

    iget-object v10, p0, Lco/vine/android/AbstractRecordingActivity;->mRecipientUsername:Ljava/lang/String;

    iget-boolean v11, p0, Lco/vine/android/AbstractRecordingActivity;->mAmFollowingRecipient:Z

    iget-boolean v12, p0, Lco/vine/android/AbstractRecordingActivity;->mIsVmOnboarding:Z

    move-object v2, p2

    invoke-static/range {v0 .. v12}, Lco/vine/android/RecordingPreviewFragment;->newInstance(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZJJZILjava/lang/String;ZZ)Lco/vine/android/RecordingPreviewFragment;

    move-result-object v0

    return-object v0
.end method

.method protected currentlyHoldsRecordingFragment()Z
    .locals 1

    .prologue
    .line 761
    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mCurrentFragment:Landroid/support/v4/app/Fragment;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mCurrentFragment:Landroid/support/v4/app/Fragment;

    instance-of v0, v0, Lco/vine/android/RecordingFragment;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public deleteCurrentDraft()V
    .locals 8

    .prologue
    .line 1485
    :try_start_0
    iget v6, p0, Lco/vine/android/AbstractRecordingActivity;->mCurrentPage:I

    if-nez v6, :cond_2

    .line 1486
    const/4 v4, 0x0

    .line 1490
    .local v4, "nextIndex":I
    :goto_0
    const/4 v6, -0x1

    iput v6, p0, Lco/vine/android/AbstractRecordingActivity;->mCurrentPage:I

    .line 1492
    iget-object v6, p0, Lco/vine/android/AbstractRecordingActivity;->mViewPager:Landroid/support/v4/view/DraftViewPager;

    invoke-virtual {v6}, Landroid/support/v4/view/DraftViewPager;->getCurrentItem()I

    move-result v0

    .line 1493
    .local v0, "current":I
    iget-object v6, p0, Lco/vine/android/AbstractRecordingActivity;->mDraftFragments:Landroid/util/SparseArray;

    invoke-virtual {v6, v0}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/ref/WeakReference;

    .line 1494
    .local v3, "fragRef":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/DraftFragment;>;"
    if-eqz v3, :cond_0

    .line 1495
    invoke-virtual {v3}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lco/vine/android/DraftFragment;

    .line 1496
    .local v2, "frag":Lco/vine/android/DraftFragment;
    if-eqz v2, :cond_0

    .line 1497
    const/4 v6, 0x1

    invoke-virtual {v2, v6}, Lco/vine/android/DraftFragment;->setExpired(Z)V

    .line 1501
    .end local v2    # "frag":Lco/vine/android/DraftFragment;
    :cond_0
    iget-object v6, p0, Lco/vine/android/AbstractRecordingActivity;->mCurrentSession:Lco/vine/android/recorder/RecordSessionManager$RecordSessionInfo;

    if-eqz v6, :cond_1

    .line 1502
    iget-object v6, p0, Lco/vine/android/AbstractRecordingActivity;->mCurrentSession:Lco/vine/android/recorder/RecordSessionManager$RecordSessionInfo;

    iget-object v6, v6, Lco/vine/android/recorder/RecordSessionManager$RecordSessionInfo;->folder:Ljava/io/File;

    const-string v7, "deleteCurrentDraft"

    invoke-static {v6, v7}, Lco/vine/android/recorder/RecordSessionManager;->deleteSession(Ljava/io/File;Ljava/lang/String;)V

    .line 1505
    :cond_1
    const-string v6, "draft"

    invoke-static {v6}, Lco/vine/android/util/FlurryUtils;->trackAbandonedStage(Ljava/lang/String;)V

    .line 1507
    const/4 v6, 0x0

    iput-object v6, p0, Lco/vine/android/AbstractRecordingActivity;->mStartSessionId:Ljava/lang/String;

    .line 1509
    invoke-direct {p0}, Lco/vine/android/AbstractRecordingActivity;->getVersion()Lco/vine/android/recorder/RecordSessionVersion;

    move-result-object v6

    invoke-static {p0, v6}, Lco/vine/android/recorder/RecordSessionManager;->getValidSessions(Landroid/content/Context;Lco/vine/android/recorder/RecordSessionVersion;)Ljava/util/ArrayList;

    move-result-object v5

    .line 1511
    .local v5, "sessions":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/recorder/RecordSessionManager$RecordSessionInfo;>;"
    invoke-direct {p0, v5}, Lco/vine/android/AbstractRecordingActivity;->reload(Ljava/util/ArrayList;)V

    .line 1512
    iput-object v5, p0, Lco/vine/android/AbstractRecordingActivity;->mSessions:Ljava/util/ArrayList;

    .line 1514
    iget-object v6, p0, Lco/vine/android/AbstractRecordingActivity;->mViewPager:Landroid/support/v4/view/DraftViewPager;

    invoke-virtual {v6}, Landroid/support/v4/view/DraftViewPager;->requestLayout()V

    .line 1515
    iget-object v6, p0, Lco/vine/android/AbstractRecordingActivity;->mViewPager:Landroid/support/v4/view/DraftViewPager;

    invoke-virtual {v6}, Landroid/support/v4/view/DraftViewPager;->invalidate()V

    .line 1516
    iget-object v6, p0, Lco/vine/android/AbstractRecordingActivity;->mAdapter:Lco/vine/android/AbstractRecordingActivity$DraftPagerImpl;

    invoke-virtual {v6}, Lco/vine/android/AbstractRecordingActivity$DraftPagerImpl;->notifyDataSetChanged()V

    .line 1517
    iget-object v6, p0, Lco/vine/android/AbstractRecordingActivity;->mViewPager:Landroid/support/v4/view/DraftViewPager;

    const/4 v7, 0x0

    invoke-virtual {v6, v4, v7}, Landroid/support/v4/view/DraftViewPager;->setCurrentItem(IZ)V

    .line 1518
    invoke-virtual {p0, v4}, Lco/vine/android/AbstractRecordingActivity;->onPageSelected(I)V

    .line 1522
    .end local v0    # "current":I
    .end local v3    # "fragRef":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/DraftFragment;>;"
    .end local v4    # "nextIndex":I
    .end local v5    # "sessions":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/recorder/RecordSessionManager$RecordSessionInfo;>;"
    :goto_1
    return-void

    .line 1488
    :cond_2
    iget v6, p0, Lco/vine/android/AbstractRecordingActivity;->mCurrentPage:I
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    add-int/lit8 v4, v6, -0x1

    .restart local v4    # "nextIndex":I
    goto :goto_0

    .line 1519
    .end local v4    # "nextIndex":I
    :catch_0
    move-exception v1

    .line 1520
    .local v1, "e":Ljava/io/IOException;
    const-string v6, "Failed to delete current draft."

    invoke-static {v6, v1}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_1
.end method

.method protected discardUpload()V
    .locals 1

    .prologue
    .line 897
    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mUploadFile:Ljava/lang/String;

    if-eqz v0, :cond_0

    .line 898
    const-string v0, "Upload discarded."

    invoke-static {v0}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 899
    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mUploadFile:Ljava/lang/String;

    invoke-static {p0, v0}, Lco/vine/android/util/UploadManager;->removeFromUploadQueue(Landroid/content/Context;Ljava/lang/String;)V

    .line 901
    :cond_0
    return-void
.end method

.method public endRelativeTime()Z
    .locals 1

    .prologue
    .line 1463
    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mCurrentFragment:Landroid/support/v4/app/Fragment;

    instance-of v0, v0, Lco/vine/android/RecordingFragment;

    if-eqz v0, :cond_0

    .line 1464
    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mCurrentFragment:Landroid/support/v4/app/Fragment;

    check-cast v0, Lco/vine/android/RecordingFragment;

    invoke-virtual {v0}, Lco/vine/android/RecordingFragment;->endRelativeTime()Z

    move-result v0

    .line 1466
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getConversationRowId()J
    .locals 2

    .prologue
    .line 595
    iget-wide v0, p0, Lco/vine/android/AbstractRecordingActivity;->mConversationRowId:J

    return-wide v0
.end method

.method public getRecordingActivityHelper()Lco/vine/android/recorder/RecordingActivityHelper;
    .locals 1

    .prologue
    .line 591
    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mHelper:Lco/vine/android/recorder/RecordingActivityHelper;

    return-object v0
.end method

.method public getScreenSize()Landroid/graphics/Point;
    .locals 1

    .prologue
    .line 486
    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mScreenSize:Landroid/graphics/Point;

    return-object v0
.end method

.method public hasPreviewedAlready()Z
    .locals 1

    .prologue
    .line 1479
    iget-boolean v0, p0, Lco/vine/android/AbstractRecordingActivity;->mHasPreviewedAlready:Z

    return v0
.end method

.method public hideDrafts(Z)V
    .locals 4
    .param p1, "animate"    # Z

    .prologue
    const/4 v3, 0x0

    .line 904
    const-string v1, "Fading away drafts."

    invoke-static {v1}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;)V

    .line 905
    new-instance v0, Landroid/view/animation/AnimationSet;

    const/4 v1, 0x1

    invoke-direct {v0, v1}, Landroid/view/animation/AnimationSet;-><init>(Z)V

    .line 906
    .local v0, "as":Landroid/view/animation/AnimationSet;
    if-eqz p1, :cond_0

    .line 907
    sget-object v1, Lco/vine/android/util/ViewUtil$ResizeAnimationType;->COLLAPSE_HEIGHT:Lco/vine/android/util/ViewUtil$ResizeAnimationType;

    iget-object v2, p0, Lco/vine/android/AbstractRecordingActivity;->mDraftMaskTop:Landroid/view/View;

    invoke-static {v1, v2, v3}, Lco/vine/android/util/ViewUtil;->makeResizeAnimation(Lco/vine/android/util/ViewUtil$ResizeAnimationType;Landroid/view/View;I)Landroid/view/animation/Animation;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/view/animation/AnimationSet;->addAnimation(Landroid/view/animation/Animation;)V

    .line 909
    sget-object v1, Lco/vine/android/util/ViewUtil$ResizeAnimationType;->COLLAPSE_WIDTH:Lco/vine/android/util/ViewUtil$ResizeAnimationType;

    iget-object v2, p0, Lco/vine/android/AbstractRecordingActivity;->mDraftMaskLeft:Landroid/view/View;

    invoke-static {v1, v2, v3}, Lco/vine/android/util/ViewUtil;->makeResizeAnimation(Lco/vine/android/util/ViewUtil$ResizeAnimationType;Landroid/view/View;I)Landroid/view/animation/Animation;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/view/animation/AnimationSet;->addAnimation(Landroid/view/animation/Animation;)V

    .line 911
    sget-object v1, Lco/vine/android/util/ViewUtil$ResizeAnimationType;->COLLAPSE_WIDTH:Lco/vine/android/util/ViewUtil$ResizeAnimationType;

    iget-object v2, p0, Lco/vine/android/AbstractRecordingActivity;->mDraftMaskRight:Landroid/view/View;

    invoke-static {v1, v2, v3}, Lco/vine/android/util/ViewUtil;->makeResizeAnimation(Lco/vine/android/util/ViewUtil$ResizeAnimationType;Landroid/view/View;I)Landroid/view/animation/Animation;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/view/animation/AnimationSet;->addAnimation(Landroid/view/animation/Animation;)V

    .line 914
    :cond_0
    const v1, 0x7f04000f

    invoke-static {p0, v1}, Landroid/view/animation/AnimationUtils;->loadAnimation(Landroid/content/Context;I)Landroid/view/animation/Animation;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/view/animation/AnimationSet;->addAnimation(Landroid/view/animation/Animation;)V

    .line 915
    new-instance v1, Lco/vine/android/AbstractRecordingActivity$7;

    invoke-direct {v1, p0, p1}, Lco/vine/android/AbstractRecordingActivity$7;-><init>(Lco/vine/android/AbstractRecordingActivity;Z)V

    invoke-virtual {v0, v1}, Landroid/view/animation/AnimationSet;->setAnimationListener(Landroid/view/animation/Animation$AnimationListener;)V

    .line 931
    const-wide/16 v1, 0x12c

    invoke-virtual {v0, v1, v2}, Landroid/view/animation/AnimationSet;->setDuration(J)V

    .line 932
    iget-object v1, p0, Lco/vine/android/AbstractRecordingActivity;->mDragUpToDeleteView:Lco/vine/android/widget/DragUpToDeleteContainer;

    const/4 v2, 0x0

    iget-object v3, p0, Lco/vine/android/AbstractRecordingActivity;->mViewPager:Landroid/support/v4/view/DraftViewPager;

    invoke-virtual {v3}, Landroid/support/v4/view/DraftViewPager;->getLeftOfSelectedFragment()I

    move-result v3

    invoke-virtual {v1, v2, v3}, Lco/vine/android/widget/DragUpToDeleteContainer;->setView(Landroid/view/View;I)V

    .line 933
    iget-object v1, p0, Lco/vine/android/AbstractRecordingActivity;->mDraftRoot:Landroid/view/View;

    invoke-virtual {v1, v0}, Landroid/view/View;->startAnimation(Landroid/view/animation/Animation;)V

    .line 934
    iget-object v1, p0, Lco/vine/android/AbstractRecordingActivity;->mDraftTrashContainer:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v1

    invoke-virtual {v1}, Landroid/view/ViewPropertyAnimator;->cancel()V

    .line 935
    iget-object v1, p0, Lco/vine/android/AbstractRecordingActivity;->mDraftTrashContainer:Landroid/view/View;

    const/16 v2, 0x8

    invoke-virtual {v1, v2}, Landroid/view/View;->setVisibility(I)V

    .line 936
    return-void
.end method

.method public initMasks(Landroid/view/View;Landroid/view/View;)V
    .locals 5
    .param p1, "topMask"    # Landroid/view/View;
    .param p2, "bottomMask"    # Landroid/view/View;

    .prologue
    const/4 v4, 0x0

    .line 736
    iget-object v3, p0, Lco/vine/android/AbstractRecordingActivity;->mOnMaskTouchListesner:Landroid/view/View$OnTouchListener;

    invoke-virtual {p1, v3}, Landroid/view/View;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 737
    iget-object v3, p0, Lco/vine/android/AbstractRecordingActivity;->mOnMaskTouchListesner:Landroid/view/View$OnTouchListener;

    invoke-virtual {p2, v3}, Landroid/view/View;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 741
    const-string v3, "capture"

    invoke-virtual {p0, v3, v4}, Lco/vine/android/AbstractRecordingActivity;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v2

    .line 743
    .local v2, "prefs":Landroid/content/SharedPreferences;
    invoke-static {}, Lco/vine/android/recorder/RecordConfigUtils;->isDefaultFrontFacing()Z

    move-result v3

    invoke-static {v3}, Lco/vine/android/recorder/VineRecorder;->getBottomMaskHeightPref(Z)Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3, v4}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v0

    .line 746
    .local v0, "bottomMaskHeightPx":I
    if-lez v0, :cond_0

    .line 747
    invoke-virtual {p2}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v1

    check-cast v1, Landroid/widget/RelativeLayout$LayoutParams;

    .line 749
    .local v1, "bottomMaskParams":Landroid/widget/RelativeLayout$LayoutParams;
    iput v0, v1, Landroid/widget/RelativeLayout$LayoutParams;->height:I

    .line 751
    new-instance v3, Lco/vine/android/AbstractRecordingActivity$6;

    invoke-direct {v3, p0, p2, v1}, Lco/vine/android/AbstractRecordingActivity$6;-><init>(Lco/vine/android/AbstractRecordingActivity;Landroid/view/View;Landroid/widget/RelativeLayout$LayoutParams;)V

    invoke-virtual {p0, v3}, Lco/vine/android/AbstractRecordingActivity;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 758
    .end local v1    # "bottomMaskParams":Landroid/widget/RelativeLayout$LayoutParams;
    :cond_0
    return-void
.end method

.method public isDraftsShowing()Z
    .locals 2

    .prologue
    .line 950
    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mDraftRoot:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getVisibility()I

    move-result v0

    const/16 v1, 0x8

    if-eq v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isFromSony()Z
    .locals 1

    .prologue
    .line 1981
    const/4 v0, 0x0

    return v0
.end method

.method public makeSureUploadIsReady()Ljava/lang/String;
    .locals 2

    .prologue
    .line 540
    iget-object v1, p0, Lco/vine/android/AbstractRecordingActivity;->mAddToUploadThread:Ljava/lang/Thread;

    if-eqz v1, :cond_0

    .line 542
    :try_start_0
    iget-object v1, p0, Lco/vine/android/AbstractRecordingActivity;->mAddToUploadThread:Ljava/lang/Thread;

    invoke-virtual {v1}, Ljava/lang/Thread;->join()V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 547
    :cond_0
    iget-object v1, p0, Lco/vine/android/AbstractRecordingActivity;->mUploadFile:Ljava/lang/String;

    return-object v1

    .line 543
    :catch_0
    move-exception v0

    .line 544
    .local v0, "e":Ljava/lang/InterruptedException;
    new-instance v1, Ljava/lang/RuntimeException;

    invoke-direct {v1, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method

.method public onActivityResult(IILandroid/content/Intent;)V
    .locals 1
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    .line 1300
    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mCurrentFragment:Landroid/support/v4/app/Fragment;

    instance-of v0, v0, Lco/vine/android/RecordingPreviewFragment;

    if-eqz v0, :cond_0

    .line 1301
    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mCurrentFragment:Landroid/support/v4/app/Fragment;

    invoke-virtual {v0, p1, p2, p3}, Landroid/support/v4/app/Fragment;->onActivityResult(IILandroid/content/Intent;)V

    .line 1309
    :goto_0
    return-void

    .line 1304
    :cond_0
    const/16 v0, 0x1f

    if-eq p2, v0, :cond_1

    const/16 v0, 0x20

    if-ne p2, v0, :cond_2

    .line 1305
    :cond_1
    invoke-virtual {p0}, Lco/vine/android/AbstractRecordingActivity;->finish()V

    goto :goto_0

    .line 1307
    :cond_2
    invoke-super {p0, p1, p2, p3}, Lco/vine/android/BaseActionBarActivity;->onActivityResult(IILandroid/content/Intent;)V

    goto :goto_0
.end method

.method public onAnimationFinish(ILjava/lang/Object;)V
    .locals 4
    .param p1, "id"    # I
    .param p2, "tag"    # Ljava/lang/Object;

    .prologue
    const/4 v3, 0x0

    .line 1579
    packed-switch p1, :pswitch_data_0

    .line 1601
    .end local p2    # "tag":Ljava/lang/Object;
    :goto_0
    :pswitch_0
    return-void

    .line 1581
    .restart local p2    # "tag":Ljava/lang/Object;
    :pswitch_1
    const v1, 0x7f04000f

    invoke-static {p0, v1}, Landroid/view/animation/AnimationUtils;->loadAnimation(Landroid/content/Context;I)Landroid/view/animation/Animation;

    move-result-object v0

    .line 1583
    .local v0, "fadeOut":Landroid/view/animation/Animation;
    iget-object v1, p0, Lco/vine/android/AbstractRecordingActivity;->mDraftRoot:Landroid/view/View;

    invoke-virtual {v1, v0}, Landroid/view/View;->startAnimation(Landroid/view/animation/Animation;)V

    .line 1584
    invoke-virtual {p0, v3}, Lco/vine/android/AbstractRecordingActivity;->hideDrafts(Z)V

    .line 1585
    const-string v1, "PreviewAnimationFinish"

    check-cast p2, Ljava/io/File;

    .end local p2    # "tag":Ljava/lang/Object;
    invoke-virtual {p0, v1, p2}, Lco/vine/android/AbstractRecordingActivity;->swapFolder(Ljava/lang/String;Ljava/io/File;)V

    .line 1586
    iput-boolean v3, p0, Lco/vine/android/AbstractRecordingActivity;->mIsGoingToRecord:Z

    goto :goto_0

    .line 1590
    .end local v0    # "fadeOut":Landroid/view/animation/Animation;
    .restart local p2    # "tag":Ljava/lang/Object;
    :pswitch_2
    invoke-virtual {p0}, Lco/vine/android/AbstractRecordingActivity;->deleteCurrentDraft()V

    .line 1591
    iget-object v1, p0, Lco/vine/android/AbstractRecordingActivity;->mPreviewOverlay:Landroid/view/View;

    const/16 v2, 0x8

    invoke-virtual {v1, v2}, Landroid/view/View;->setVisibility(I)V

    goto :goto_0

    .line 1595
    :pswitch_3
    invoke-virtual {p0, v3}, Lco/vine/android/AbstractRecordingActivity;->hideDrafts(Z)V

    .line 1596
    const-string v1, "CameraAnimationFinish"

    const/4 v2, 0x0

    invoke-virtual {p0, v1, v2}, Lco/vine/android/AbstractRecordingActivity;->swapFolder(Ljava/lang/String;Ljava/io/File;)V

    .line 1597
    iput-boolean v3, p0, Lco/vine/android/AbstractRecordingActivity;->mIsGoingToRecord:Z

    goto :goto_0

    .line 1579
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_0
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method public onBackPressed()V
    .locals 4

    .prologue
    .line 788
    invoke-virtual {p0}, Lco/vine/android/AbstractRecordingActivity;->makeSureUploadIsReady()Ljava/lang/String;

    .line 790
    :try_start_0
    iget v2, p0, Lco/vine/android/AbstractRecordingActivity;->mStep:I

    const/4 v3, -0x1

    if-ne v2, v3, :cond_1

    .line 791
    invoke-super {p0}, Lco/vine/android/BaseActionBarActivity;->onBackPressed()V

    .line 830
    :cond_0
    :goto_0
    return-void

    .line 793
    :cond_1
    invoke-virtual {p0}, Lco/vine/android/AbstractRecordingActivity;->isDraftsShowing()Z

    move-result v2

    if-eqz v2, :cond_2

    .line 794
    const/4 v2, 0x1

    invoke-virtual {p0, v2}, Lco/vine/android/AbstractRecordingActivity;->hideDrafts(Z)V

    .line 795
    invoke-direct {p0}, Lco/vine/android/AbstractRecordingActivity;->releasePlayers()V

    .line 796
    iget-object v2, p0, Lco/vine/android/AbstractRecordingActivity;->mCurrentFragment:Landroid/support/v4/app/Fragment;

    instance-of v2, v2, Lco/vine/android/RecordingFragment;

    if-eqz v2, :cond_0

    .line 797
    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mCurrentFragment:Landroid/support/v4/app/Fragment;

    check-cast v0, Lco/vine/android/RecordingFragment;

    .line 798
    .local v0, "fragment":Lco/vine/android/RecordingFragment;
    invoke-virtual {v0}, Lco/vine/android/RecordingFragment;->resumeFromDraft()V

    goto :goto_0

    .line 827
    .end local v0    # "fragment":Lco/vine/android/RecordingFragment;
    :catch_0
    move-exception v2

    goto :goto_0

    .line 801
    :cond_2
    invoke-virtual {p0}, Lco/vine/android/AbstractRecordingActivity;->currentlyHoldsRecordingFragment()Z

    move-result v2

    if-eqz v2, :cond_6

    .line 802
    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mCurrentFragment:Landroid/support/v4/app/Fragment;

    check-cast v0, Lco/vine/android/RecordingFragment;

    .line 803
    .restart local v0    # "fragment":Lco/vine/android/RecordingFragment;
    invoke-virtual {v0}, Lco/vine/android/RecordingFragment;->isEditing()Z

    move-result v1

    .line 804
    .local v1, "isEditing":Z
    if-nez v1, :cond_3

    invoke-virtual {v0}, Lco/vine/android/RecordingFragment;->isSessionModified()Z

    move-result v2

    if-nez v2, :cond_3

    .line 805
    invoke-virtual {v0}, Lco/vine/android/RecordingFragment;->setDiscardChangesOnStop()V

    .line 806
    const/16 v2, 0x64

    invoke-virtual {p0, v2}, Lco/vine/android/AbstractRecordingActivity;->setResult(I)V

    .line 807
    invoke-virtual {v0}, Lco/vine/android/RecordingFragment;->playStopSound()V

    .line 808
    invoke-super {p0}, Lco/vine/android/BaseActionBarActivity;->onBackPressed()V

    goto :goto_0

    .line 810
    :cond_3
    if-eqz v1, :cond_4

    invoke-virtual {v0}, Lco/vine/android/RecordingFragment;->isEditingDirty()Z

    move-result v2

    if-nez v2, :cond_4

    .line 811
    invoke-virtual {v0}, Lco/vine/android/RecordingFragment;->playStopSound()V

    .line 812
    invoke-virtual {v0}, Lco/vine/android/RecordingFragment;->discardEditing()V

    goto :goto_0

    .line 813
    :cond_4
    iget-boolean v2, p0, Lco/vine/android/AbstractRecordingActivity;->mIsMessaging:Z

    if-nez v2, :cond_5

    .line 814
    const/4 v2, 0x0

    invoke-virtual {p0, v2, v0}, Lco/vine/android/AbstractRecordingActivity;->showUnSavedChangesDialog(ILco/vine/android/RecordingFragment;)V

    goto :goto_0

    .line 816
    :cond_5
    const/16 v2, 0x64

    invoke-virtual {p0, v2}, Lco/vine/android/AbstractRecordingActivity;->setResult(I)V

    .line 817
    invoke-super {p0}, Lco/vine/android/BaseActionBarActivity;->onBackPressed()V

    goto :goto_0

    .line 821
    .end local v0    # "fragment":Lco/vine/android/RecordingFragment;
    .end local v1    # "isEditing":Z
    :cond_6
    iget-object v2, p0, Lco/vine/android/AbstractRecordingActivity;->mCurrentFragment:Landroid/support/v4/app/Fragment;

    instance-of v2, v2, Lco/vine/android/RecordingPreviewFragment;

    if-eqz v2, :cond_0

    .line 822
    iget-object v2, p0, Lco/vine/android/AbstractRecordingActivity;->mCurrentFragment:Landroid/support/v4/app/Fragment;

    check-cast v2, Lco/vine/android/RecordingPreviewFragment;

    const/4 v3, 0x0

    invoke-virtual {v2, p0, v3}, Lco/vine/android/RecordingPreviewFragment;->previewToRecord(Lco/vine/android/AbstractRecordingActivity;Z)V
    :try_end_0
    .catch Ljava/lang/IllegalStateException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0
.end method

.method public onCameraSwitchPressed(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 1265
    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mCurrentFragment:Landroid/support/v4/app/Fragment;

    instance-of v0, v0, Lco/vine/android/RecordingFragment;

    if-eqz v0, :cond_0

    .line 1266
    invoke-static {p1}, Lco/vine/android/util/FlurryUtils;->trackCameraSwitchPressed(Landroid/view/View;)V

    .line 1267
    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mCurrentFragment:Landroid/support/v4/app/Fragment;

    check-cast v0, Lco/vine/android/RecordingFragment;

    invoke-virtual {v0, p1}, Lco/vine/android/RecordingFragment;->onCameraSwitchPressed(Landroid/view/View;)V

    .line 1269
    :cond_0
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 23
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 312
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/AbstractRecordingActivity;->getIntent()Landroid/content/Intent;

    move-result-object v11

    .line 313
    .local v11, "intent":Landroid/content/Intent;
    const/4 v5, 0x0

    .line 314
    .local v5, "action":Ljava/lang/String;
    if-eqz v11, :cond_0

    .line 315
    invoke-virtual {v11}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v5

    .line 317
    :cond_0
    const-string v19, "AbstractRecordingActivity {} pid: {}, action tag {}."

    const/16 v20, 0x3

    move/from16 v0, v20

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v20, v0

    const/16 v21, 0x0

    aput-object p0, v20, v21

    const/16 v21, 0x1

    invoke-static {}, Landroid/os/Process;->myPid()I

    move-result v22

    invoke-static/range {v22 .. v22}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v22

    aput-object v22, v20, v21

    const/16 v21, 0x2

    aput-object v5, v20, v21

    invoke-static/range {v19 .. v20}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 319
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/AbstractRecordingActivity;->mIntentionalObjectCounter:Lco/vine/android/util/IntentionalObjectCounter;

    move-object/from16 v19, v0

    invoke-virtual/range {v19 .. v19}, Lco/vine/android/util/IntentionalObjectCounter;->add()V

    .line 320
    invoke-static {}, Lco/vine/android/util/FlurryUtils;->trackRecordingStart()V

    .line 323
    const v19, 0x7f030085

    const/16 v20, 0x0

    const/16 v21, 0x1

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move/from16 v2, v19

    move/from16 v3, v20

    move/from16 v4, v21

    invoke-super {v0, v1, v2, v3, v4}, Lco/vine/android/BaseActionBarActivity;->onCreate(Landroid/os/Bundle;IZZ)V

    .line 324
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/AbstractRecordingActivity;->mHelper:Lco/vine/android/recorder/RecordingActivityHelper;

    move-object/from16 v19, v0

    move-object/from16 v0, v19

    move-object/from16 v1, p0

    invoke-virtual {v0, v1}, Lco/vine/android/recorder/RecordingActivityHelper;->bindCameraService(Landroid/app/Activity;)V

    .line 325
    invoke-static/range {p0 .. p0}, Lco/vine/android/util/SystemUtil;->getDisplaySize(Landroid/app/Activity;)Landroid/graphics/Point;

    move-result-object v19

    move-object/from16 v0, v19

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/AbstractRecordingActivity;->mScreenSize:Landroid/graphics/Point;

    .line 327
    new-instance v10, Landroid/content/IntentFilter;

    invoke-direct {v10}, Landroid/content/IntentFilter;-><init>()V

    .line 328
    .local v10, "filter":Landroid/content/IntentFilter;
    const-string v19, "co.vine.android.session.logout"

    move-object/from16 v0, v19

    invoke-virtual {v10, v0}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 329
    const-string v19, "co.vine.android.session.login"

    move-object/from16 v0, v19

    invoke-virtual {v10, v0}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 331
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/AbstractRecordingActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v17

    .line 333
    .local v17, "rs":Landroid/content/res/Resources;
    const/16 v19, 0x1

    move-object/from16 v0, p0

    move/from16 v1, v19

    invoke-static {v0, v1}, Lco/vine/android/util/SystemUtil;->getMemoryRatio(Landroid/content/Context;Z)D

    move-result-wide v19

    const-wide/high16 v21, 0x3ff0000000000000L    # 1.0

    cmpg-double v19, v19, v21

    if-gez v19, :cond_2

    .line 334
    const v19, 0x7f0e0257

    move-object/from16 v0, p0

    move/from16 v1, v19

    invoke-static {v0, v1}, Lco/vine/android/util/Util;->showCenteredToast(Landroid/content/Context;I)V

    .line 335
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/AbstractRecordingActivity;->finish()V

    .line 474
    :cond_1
    :goto_0
    return-void

    .line 339
    :cond_2
    invoke-static/range {p0 .. p0}, Lco/vine/android/recorder/RecordSessionManager;->getCurrentVersion(Landroid/content/Context;)Lco/vine/android/recorder/RecordSessionVersion;

    move-result-object v19

    move-object/from16 v0, v19

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/AbstractRecordingActivity;->mVersion:Lco/vine/android/recorder/RecordSessionVersion;

    .line 341
    if-nez p1, :cond_4

    .line 342
    if-eqz v11, :cond_3

    .line 343
    invoke-virtual {v11}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v9

    .line 344
    .local v9, "extras":Landroid/os/Bundle;
    if-eqz v9, :cond_3

    .line 345
    const-string v19, "messaging"

    move-object/from16 v0, v19

    invoke-virtual {v9, v0}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v19

    move/from16 v0, v19

    move-object/from16 v1, p0

    iput-boolean v0, v1, Lco/vine/android/AbstractRecordingActivity;->mIsMessaging:Z

    .line 346
    const-string v19, "conv_row_id"

    const-wide/16 v20, -0x1

    move-object/from16 v0, v19

    move-wide/from16 v1, v20

    invoke-virtual {v9, v0, v1, v2}, Landroid/os/Bundle;->getLong(Ljava/lang/String;J)J

    move-result-wide v19

    move-wide/from16 v0, v19

    move-object/from16 v2, p0

    iput-wide v0, v2, Lco/vine/android/AbstractRecordingActivity;->mConversationRowId:J

    .line 347
    const-string v19, "arg_top_overlay"

    move-object/from16 v0, v19

    invoke-virtual {v9, v0}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v19

    check-cast v19, Landroid/graphics/Bitmap;

    move-object/from16 v0, v19

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/AbstractRecordingActivity;->mTopOverlay:Landroid/graphics/Bitmap;

    .line 348
    const-string v19, "direct_id"

    const-wide/16 v20, -0x1

    move-object/from16 v0, v19

    move-wide/from16 v1, v20

    invoke-virtual {v9, v0, v1, v2}, Landroid/os/Bundle;->getLong(Ljava/lang/String;J)J

    move-result-wide v19

    move-wide/from16 v0, v19

    move-object/from16 v2, p0

    iput-wide v0, v2, Lco/vine/android/AbstractRecordingActivity;->mDirectUserId:J

    .line 349
    const-string v19, "start_conversation"

    move-object/from16 v0, v19

    invoke-virtual {v9, v0}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v19

    move/from16 v0, v19

    move-object/from16 v1, p0

    iput-boolean v0, v1, Lco/vine/android/AbstractRecordingActivity;->mStartConversation:Z

    .line 350
    const-string v19, "recipient_username"

    move-object/from16 v0, v19

    invoke-virtual {v9, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v19

    move-object/from16 v0, v19

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/AbstractRecordingActivity;->mRecipientUsername:Ljava/lang/String;

    .line 351
    const-string v19, "is_vm_onboarding"

    move-object/from16 v0, v19

    invoke-virtual {v9, v0}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v19

    move/from16 v0, v19

    move-object/from16 v1, p0

    iput-boolean v0, v1, Lco/vine/android/AbstractRecordingActivity;->mIsVmOnboarding:Z

    .line 354
    .end local v9    # "extras":Landroid/os/Bundle;
    :cond_3
    const/16 v19, 0x1

    const/16 v20, 0x0

    const/16 v21, 0x0

    move-object/from16 v0, p0

    move/from16 v1, v19

    move/from16 v2, v20

    move-object/from16 v3, v21

    invoke-virtual {v0, v1, v2, v3}, Lco/vine/android/AbstractRecordingActivity;->toRecord(ZZLco/vine/android/recorder/RecordingFile;)V

    .line 356
    :cond_4
    invoke-static {}, Lco/vine/android/client/VineAccountHelper;->resetActiveSession()V

    .line 357
    invoke-static/range {p0 .. p0}, Lco/vine/android/service/VineUploadService;->getClearNotificationsIntent(Landroid/content/Context;)Landroid/content/Intent;

    move-result-object v19

    move-object/from16 v0, p0

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Lco/vine/android/AbstractRecordingActivity;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;

    .line 360
    const v19, 0x7f0c0003

    move-object/from16 v0, v17

    move/from16 v1, v19

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getInteger(I)I

    move-result v19

    move/from16 v0, v19

    int-to-float v0, v0

    move/from16 v19, v0

    const/high16 v20, 0x42c80000    # 100.0f

    div-float v19, v19, v20

    move/from16 v0, v19

    move-object/from16 v1, p0

    iput v0, v1, Lco/vine/android/AbstractRecordingActivity;->mPreviewRatio:F

    .line 361
    const v19, 0x7f0a01d5

    move-object/from16 v0, p0

    move/from16 v1, v19

    invoke-virtual {v0, v1}, Lco/vine/android/AbstractRecordingActivity;->findViewById(I)Landroid/view/View;

    move-result-object v19

    move-object/from16 v0, v19

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/AbstractRecordingActivity;->mDraftRoot:Landroid/view/View;

    .line 362
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/AbstractRecordingActivity;->mDraftRoot:Landroid/view/View;

    move-object/from16 v19, v0

    const/16 v20, 0x8

    invoke-virtual/range {v19 .. v20}, Landroid/view/View;->setVisibility(I)V

    .line 363
    const v19, 0x7f0a00da

    move-object/from16 v0, p0

    move/from16 v1, v19

    invoke-virtual {v0, v1}, Lco/vine/android/AbstractRecordingActivity;->findViewById(I)Landroid/view/View;

    move-result-object v19

    check-cast v19, Landroid/support/v4/view/DraftViewPager;

    move-object/from16 v0, v19

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/AbstractRecordingActivity;->mViewPager:Landroid/support/v4/view/DraftViewPager;

    .line 364
    const v19, 0x7f0a00db

    move-object/from16 v0, p0

    move/from16 v1, v19

    invoke-virtual {v0, v1}, Lco/vine/android/AbstractRecordingActivity;->findViewById(I)Landroid/view/View;

    move-result-object v19

    check-cast v19, Lco/vine/android/widget/DotIndicators;

    move-object/from16 v0, v19

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/AbstractRecordingActivity;->mDots:Lco/vine/android/widget/DotIndicators;

    .line 365
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/AbstractRecordingActivity;->mScreenSize:Landroid/graphics/Point;

    move-object/from16 v19, v0

    move-object/from16 v0, v19

    iget v0, v0, Landroid/graphics/Point;->x:I

    move/from16 v19, v0

    move/from16 v0, v19

    int-to-float v0, v0

    move/from16 v19, v0

    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/AbstractRecordingActivity;->mPreviewRatio:F

    move/from16 v20, v0

    mul-float v19, v19, v20

    move/from16 v0, v19

    float-to-int v0, v0

    move/from16 v19, v0

    move/from16 v0, v19

    move-object/from16 v1, p0

    iput v0, v1, Lco/vine/android/AbstractRecordingActivity;->mPreviewDimen:I

    .line 366
    const v19, 0x7f0a00dd

    move-object/from16 v0, p0

    move/from16 v1, v19

    invoke-virtual {v0, v1}, Lco/vine/android/AbstractRecordingActivity;->findViewById(I)Landroid/view/View;

    move-result-object v19

    move-object/from16 v0, v19

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/AbstractRecordingActivity;->mPreviewOverlay:Landroid/view/View;

    .line 367
    const v19, 0x7f0a00dc

    move-object/from16 v0, p0

    move/from16 v1, v19

    invoke-virtual {v0, v1}, Lco/vine/android/AbstractRecordingActivity;->findViewById(I)Landroid/view/View;

    move-result-object v19

    move-object/from16 v0, v19

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/AbstractRecordingActivity;->mProgressOverlay:Landroid/view/View;

    .line 369
    const v19, 0x7f0a01db

    move-object/from16 v0, p0

    move/from16 v1, v19

    invoke-virtual {v0, v1}, Lco/vine/android/AbstractRecordingActivity;->findViewById(I)Landroid/view/View;

    move-result-object v19

    move-object/from16 v0, v19

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/AbstractRecordingActivity;->mDraftMaskTop:Landroid/view/View;

    .line 370
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/AbstractRecordingActivity;->mDraftMaskTop:Landroid/view/View;

    move-object/from16 v19, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/AbstractRecordingActivity;->mEmptyClicker:Landroid/view/View$OnClickListener;

    move-object/from16 v20, v0

    invoke-virtual/range {v19 .. v20}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 371
    const v19, 0x7f0a01dc

    move-object/from16 v0, p0

    move/from16 v1, v19

    invoke-virtual {v0, v1}, Lco/vine/android/AbstractRecordingActivity;->findViewById(I)Landroid/view/View;

    move-result-object v19

    move-object/from16 v0, v19

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/AbstractRecordingActivity;->mDraftMaskLeft:Landroid/view/View;

    .line 372
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/AbstractRecordingActivity;->mDraftMaskLeft:Landroid/view/View;

    move-object/from16 v19, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/AbstractRecordingActivity;->mEmptyClicker:Landroid/view/View$OnClickListener;

    move-object/from16 v20, v0

    invoke-virtual/range {v19 .. v20}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 373
    const v19, 0x7f0a01dd

    move-object/from16 v0, p0

    move/from16 v1, v19

    invoke-virtual {v0, v1}, Lco/vine/android/AbstractRecordingActivity;->findViewById(I)Landroid/view/View;

    move-result-object v19

    move-object/from16 v0, v19

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/AbstractRecordingActivity;->mDraftMaskRight:Landroid/view/View;

    .line 374
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/AbstractRecordingActivity;->mDraftMaskRight:Landroid/view/View;

    move-object/from16 v19, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/AbstractRecordingActivity;->mEmptyClicker:Landroid/view/View$OnClickListener;

    move-object/from16 v20, v0

    invoke-virtual/range {v19 .. v20}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 375
    const v19, 0x7f0a01da

    move-object/from16 v0, p0

    move/from16 v1, v19

    invoke-virtual {v0, v1}, Lco/vine/android/AbstractRecordingActivity;->findViewById(I)Landroid/view/View;

    move-result-object v19

    move-object/from16 v0, v19

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/AbstractRecordingActivity;->mDraftMaskParent:Landroid/view/View;

    .line 376
    const v19, 0x7f0a01de

    move-object/from16 v0, p0

    move/from16 v1, v19

    invoke-virtual {v0, v1}, Lco/vine/android/AbstractRecordingActivity;->findViewById(I)Landroid/view/View;

    move-result-object v19

    move-object/from16 v0, v19

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/AbstractRecordingActivity;->mDraftTrashContainer:Landroid/view/View;

    .line 377
    const v19, 0x7f0a01df

    move-object/from16 v0, p0

    move/from16 v1, v19

    invoke-virtual {v0, v1}, Lco/vine/android/AbstractRecordingActivity;->findViewById(I)Landroid/view/View;

    move-result-object v19

    move-object/from16 v0, v19

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/AbstractRecordingActivity;->mDraftTrashBackground:Landroid/view/View;

    .line 378
    const v19, 0x7f0a01e0

    move-object/from16 v0, p0

    move/from16 v1, v19

    invoke-virtual {v0, v1}, Lco/vine/android/AbstractRecordingActivity;->findViewById(I)Landroid/view/View;

    move-result-object v19

    move-object/from16 v0, v19

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/AbstractRecordingActivity;->mDraftTrashButton:Landroid/view/View;

    .line 379
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/AbstractRecordingActivity;->mDraftTrashButton:Landroid/view/View;

    move-object/from16 v19, v0

    new-instance v20, Lco/vine/android/AbstractRecordingActivity$3;

    move-object/from16 v0, v20

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lco/vine/android/AbstractRecordingActivity$3;-><init>(Lco/vine/android/AbstractRecordingActivity;)V

    invoke-virtual/range {v19 .. v20}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 388
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/AbstractRecordingActivity;->mDraftTrashButton:Landroid/view/View;

    move-object/from16 v19, v0

    new-instance v20, Lco/vine/android/AbstractRecordingActivity$4;

    move-object/from16 v0, v20

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lco/vine/android/AbstractRecordingActivity$4;-><init>(Lco/vine/android/AbstractRecordingActivity;)V

    invoke-virtual/range {v19 .. v20}, Landroid/view/View;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 418
    const v19, 0x7f0a01d4

    move-object/from16 v0, p0

    move/from16 v1, v19

    invoke-virtual {v0, v1}, Lco/vine/android/AbstractRecordingActivity;->findViewById(I)Landroid/view/View;

    move-result-object v19

    check-cast v19, Lco/vine/android/widget/DragUpToDeleteContainer;

    move-object/from16 v0, v19

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/AbstractRecordingActivity;->mDragUpToDeleteView:Lco/vine/android/widget/DragUpToDeleteContainer;

    .line 419
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/AbstractRecordingActivity;->mDragUpToDeleteView:Lco/vine/android/widget/DragUpToDeleteContainer;

    move-object/from16 v19, v0

    const/16 v20, 0x8

    invoke-virtual/range {v19 .. v20}, Lco/vine/android/widget/DragUpToDeleteContainer;->setVisibility(I)V

    .line 420
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/AbstractRecordingActivity;->mDragUpToDeleteView:Lco/vine/android/widget/DragUpToDeleteContainer;

    move-object/from16 v19, v0

    move-object/from16 v0, v19

    move-object/from16 v1, p0

    invoke-virtual {v0, v1}, Lco/vine/android/widget/DragUpToDeleteContainer;->setInteractionListner(Lco/vine/android/widget/DragUpToDeleteContainer$DragUpListener;)V

    .line 421
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/AbstractRecordingActivity;->mDraftTrashContainer:Landroid/view/View;

    move-object/from16 v19, v0

    const/16 v20, 0x8

    invoke-virtual/range {v19 .. v20}, Landroid/view/View;->setVisibility(I)V

    .line 423
    const v19, 0x7f0b0033

    move-object/from16 v0, v17

    move/from16 v1, v19

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimensionPixelOffset(I)I

    move-result v8

    .line 424
    .local v8, "draftProgDimen":I
    const v19, 0x7f0b006a

    move-object/from16 v0, v17

    move/from16 v1, v19

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimensionPixelOffset(I)I

    move-result v16

    .line 426
    .local v16, "progressDimen":I
    add-int v19, v16, v8

    move/from16 v0, v19

    move-object/from16 v1, p0

    iput v0, v1, Lco/vine/android/AbstractRecordingActivity;->mTopMaskHeight:I

    .line 427
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/AbstractRecordingActivity;->mScreenSize:Landroid/graphics/Point;

    move-object/from16 v19, v0

    move-object/from16 v0, v19

    iget v0, v0, Landroid/graphics/Point;->x:I

    move/from16 v19, v0

    div-int/lit8 v19, v19, 0x2

    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/AbstractRecordingActivity;->mPreviewDimen:I

    move/from16 v20, v0

    div-int/lit8 v20, v20, 0x2

    sub-int v19, v19, v20

    move/from16 v0, v19

    move-object/from16 v1, p0

    iput v0, v1, Lco/vine/android/AbstractRecordingActivity;->mSideMaskWidth:I

    .line 429
    const v19, 0x7f0a00d9

    move-object/from16 v0, p0

    move/from16 v1, v19

    invoke-virtual {v0, v1}, Lco/vine/android/AbstractRecordingActivity;->findViewById(I)Landroid/view/View;

    move-result-object v13

    .line 430
    .local v13, "pagerLeftMask":Landroid/view/View;
    invoke-virtual {v13}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v14

    .line 431
    .local v14, "params":Landroid/view/ViewGroup$LayoutParams;
    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/AbstractRecordingActivity;->mPreviewRatio:F

    move/from16 v19, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/AbstractRecordingActivity;->mScreenSize:Landroid/graphics/Point;

    move-object/from16 v20, v0

    move-object/from16 v0, v20

    iget v0, v0, Landroid/graphics/Point;->x:I

    move/from16 v20, v0

    move/from16 v0, v20

    int-to-float v0, v0

    move/from16 v20, v0

    const/high16 v21, 0x3f800000    # 1.0f

    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/AbstractRecordingActivity;->mPreviewRatio:F

    move/from16 v22, v0

    sub-float v21, v21, v22

    const/high16 v22, 0x40000000    # 2.0f

    div-float v21, v21, v22

    mul-float v20, v20, v21

    add-float v19, v19, v20

    move/from16 v0, v19

    float-to-int v0, v0

    move/from16 v19, v0

    move/from16 v0, v19

    iput v0, v14, Landroid/view/ViewGroup$LayoutParams;->width:I

    .line 432
    invoke-virtual {v13, v14}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 434
    if-eqz p1, :cond_7

    .line 435
    const-string v19, "state_fp"

    move-object/from16 v0, p1

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v19

    if-eqz v19, :cond_5

    .line 436
    const-string v19, "state_fp"

    move-object/from16 v0, p1

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v19

    move/from16 v0, v19

    move-object/from16 v1, p0

    iput-boolean v0, v1, Lco/vine/android/AbstractRecordingActivity;->mFirstPageSet:Z

    .line 438
    :cond_5
    const-string v19, "first_launch"

    move-object/from16 v0, p1

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v19

    if-eqz v19, :cond_6

    .line 439
    const-string v19, "first_launch"

    move-object/from16 v0, p1

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v19

    move/from16 v0, v19

    move-object/from16 v1, p0

    iput-boolean v0, v1, Lco/vine/android/AbstractRecordingActivity;->mFirstDraftLaunch:Z

    .line 447
    :goto_1
    const v19, 0x7f0b0030

    move-object/from16 v0, v17

    move/from16 v1, v19

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimensionPixelOffset(I)I

    move-result v6

    .line 448
    .local v6, "bottomRowDimen":I
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/AbstractRecordingActivity;->mViewPager:Landroid/support/v4/view/DraftViewPager;

    move-object/from16 v19, v0

    invoke-virtual/range {v19 .. v19}, Landroid/support/v4/view/DraftViewPager;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v18

    .line 449
    .local v18, "viewPagerLayout":Landroid/view/ViewGroup$LayoutParams;
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/AbstractRecordingActivity;->mScreenSize:Landroid/graphics/Point;

    move-object/from16 v19, v0

    move-object/from16 v0, v19

    iget v0, v0, Landroid/graphics/Point;->x:I

    move/from16 v19, v0

    add-int v19, v19, v16

    add-int v19, v19, v6

    move/from16 v0, v19

    move-object/from16 v1, v18

    iput v0, v1, Landroid/view/ViewGroup$LayoutParams;->height:I

    .line 450
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/AbstractRecordingActivity;->mViewPager:Landroid/support/v4/view/DraftViewPager;

    move-object/from16 v19, v0

    move-object/from16 v0, v19

    move-object/from16 v1, v18

    invoke-virtual {v0, v1}, Landroid/support/v4/view/DraftViewPager;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 452
    const v19, 0x7f0b0030

    move-object/from16 v0, v17

    move/from16 v1, v19

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimensionPixelOffset(I)I

    move-result v7

    .line 453
    .local v7, "dotsHeight":I
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/AbstractRecordingActivity;->mDots:Lco/vine/android/widget/DotIndicators;

    move-object/from16 v19, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/AbstractRecordingActivity;->mScreenSize:Landroid/graphics/Point;

    move-object/from16 v20, v0

    move-object/from16 v0, v20

    iget v0, v0, Landroid/graphics/Point;->x:I

    move/from16 v20, v0

    add-int v20, v20, v16

    div-int/lit8 v21, v7, 0x4

    add-int v20, v20, v21

    move/from16 v0, v20

    int-to-float v0, v0

    move/from16 v20, v0

    invoke-virtual/range {v19 .. v20}, Lco/vine/android/widget/DotIndicators;->setY(F)V

    .line 455
    const v19, 0x7f0a01d7

    move-object/from16 v0, p0

    move/from16 v1, v19

    invoke-virtual {v0, v1}, Lco/vine/android/AbstractRecordingActivity;->findViewById(I)Landroid/view/View;

    move-result-object v19

    check-cast v19, Landroid/widget/ImageView;

    move-object/from16 v0, v19

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/AbstractRecordingActivity;->mLargeThumbnailOverlay:Landroid/widget/ImageView;

    .line 456
    const v19, 0x7f0a01d8

    move-object/from16 v0, p0

    move/from16 v1, v19

    invoke-virtual {v0, v1}, Lco/vine/android/AbstractRecordingActivity;->findViewById(I)Landroid/view/View;

    move-result-object v19

    move-object/from16 v0, v19

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/AbstractRecordingActivity;->mAnimationPreviewOverlay:Landroid/view/View;

    .line 458
    const v19, 0x7f0a01d9

    move-object/from16 v0, p0

    move/from16 v1, v19

    invoke-virtual {v0, v1}, Lco/vine/android/AbstractRecordingActivity;->findViewById(I)Landroid/view/View;

    move-result-object v19

    move-object/from16 v0, v19

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/AbstractRecordingActivity;->mCameraIconOverlay:Landroid/view/View;

    .line 459
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/AbstractRecordingActivity;->mCameraIconOverlay:Landroid/view/View;

    move-object/from16 v19, v0

    const/16 v20, 0x8

    invoke-virtual/range {v19 .. v20}, Landroid/view/View;->setVisibility(I)V

    .line 461
    const v19, 0x7f0a00d3

    move-object/from16 v0, p0

    move/from16 v1, v19

    invoke-virtual {v0, v1}, Lco/vine/android/AbstractRecordingActivity;->findViewById(I)Landroid/view/View;

    move-result-object v19

    move-object/from16 v0, v19

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/AbstractRecordingActivity;->mCameraIconOverlayImage:Landroid/view/View;

    .line 463
    const v19, 0x7f0a01d6

    move-object/from16 v0, p0

    move/from16 v1, v19

    invoke-virtual {v0, v1}, Lco/vine/android/AbstractRecordingActivity;->findViewById(I)Landroid/view/View;

    move-result-object v19

    move-object/from16 v0, v19

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/AbstractRecordingActivity;->mDraftFullMask:Landroid/view/View;

    .line 465
    const v19, 0x7f040019

    move-object/from16 v0, p0

    move/from16 v1, v19

    invoke-static {v0, v1}, Landroid/view/animation/AnimationUtils;->loadAnimation(Landroid/content/Context;I)Landroid/view/animation/Animation;

    move-result-object v19

    move-object/from16 v0, v19

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/AbstractRecordingActivity;->mSlowFadeIn:Landroid/view/animation/Animation;

    .line 466
    const v19, 0x7f040019

    move-object/from16 v0, p0

    move/from16 v1, v19

    invoke-static {v0, v1}, Landroid/view/animation/AnimationUtils;->loadAnimation(Landroid/content/Context;I)Landroid/view/animation/Animation;

    move-result-object v19

    move-object/from16 v0, v19

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/AbstractRecordingActivity;->mCameraIconFadeIn:Landroid/view/animation/Animation;

    .line 468
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lco/vine/android/AbstractRecordingActivity;->mIsMessaging:Z

    move/from16 v19, v0

    if-nez v19, :cond_1

    .line 469
    const-string v19, "capture"

    const/16 v20, 0x0

    move-object/from16 v0, p0

    move-object/from16 v1, v19

    move/from16 v2, v20

    invoke-virtual {v0, v1, v2}, Lco/vine/android/AbstractRecordingActivity;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v15

    .line 471
    .local v15, "prefs":Landroid/content/SharedPreferences;
    const-string v19, "recorder_launch_count"

    const/16 v20, 0x0

    move-object/from16 v0, v19

    move/from16 v1, v20

    invoke-interface {v15, v0, v1}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v19

    add-int/lit8 v12, v19, 0x1

    .line 472
    .local v12, "launchCount":I
    invoke-interface {v15}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v19

    const-string v20, "recorder_launch_count"

    move-object/from16 v0, v19

    move-object/from16 v1, v20

    invoke-interface {v0, v1, v12}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    move-result-object v19

    invoke-interface/range {v19 .. v19}, Landroid/content/SharedPreferences$Editor;->apply()V

    goto/16 :goto_0

    .line 441
    .end local v6    # "bottomRowDimen":I
    .end local v7    # "dotsHeight":I
    .end local v12    # "launchCount":I
    .end local v15    # "prefs":Landroid/content/SharedPreferences;
    .end local v18    # "viewPagerLayout":Landroid/view/ViewGroup$LayoutParams;
    :cond_6
    const/16 v19, 0x1

    move/from16 v0, v19

    move-object/from16 v1, p0

    iput-boolean v0, v1, Lco/vine/android/AbstractRecordingActivity;->mFirstDraftLaunch:Z

    goto/16 :goto_1

    .line 444
    :cond_7
    const/16 v19, 0x1

    move/from16 v0, v19

    move-object/from16 v1, p0

    iput-boolean v0, v1, Lco/vine/android/AbstractRecordingActivity;->mFirstDraftLaunch:Z

    goto/16 :goto_1
.end method

.method protected onDestroy()V
    .locals 6

    .prologue
    const/4 v5, 0x1

    .line 1783
    invoke-super {p0}, Lco/vine/android/BaseActionBarActivity;->onDestroy()V

    .line 1784
    iget-object v3, p0, Lco/vine/android/AbstractRecordingActivity;->mHelper:Lco/vine/android/recorder/RecordingActivityHelper;

    invoke-virtual {v3, p0}, Lco/vine/android/recorder/RecordingActivityHelper;->unBindCameraService(Landroid/app/Activity;)V

    .line 1786
    :try_start_0
    iget-object v3, p0, Lco/vine/android/AbstractRecordingActivity;->mIntentionalObjectCounter:Lco/vine/android/util/IntentionalObjectCounter;

    invoke-virtual {v3}, Lco/vine/android/util/IntentionalObjectCounter;->release()V

    .line 1787
    iget-object v3, p0, Lco/vine/android/AbstractRecordingActivity;->mIntentionalObjectCounter:Lco/vine/android/util/IntentionalObjectCounter;

    invoke-virtual {v3}, Lco/vine/android/util/IntentionalObjectCounter;->getCount()I

    move-result v0

    .line 1788
    .local v0, "count":I
    if-nez v0, :cond_1

    .line 1789
    const-string v3, "Clean up folders because we are the last one."

    invoke-static {v3}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;)V

    .line 1790
    invoke-direct {p0}, Lco/vine/android/AbstractRecordingActivity;->getVersion()Lco/vine/android/recorder/RecordSessionVersion;

    move-result-object v3

    invoke-virtual {v3, p0}, Lco/vine/android/recorder/RecordSessionVersion;->getManager(Landroid/content/Context;)Lco/vine/android/recorder/RecordSessionManager;

    move-result-object v3

    invoke-virtual {v3}, Lco/vine/android/recorder/RecordSessionManager;->cleanUnusedFolders()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 1799
    .end local v0    # "count":I
    :cond_0
    :goto_0
    const/4 v3, 0x0

    iput-object v3, p0, Lco/vine/android/AbstractRecordingActivity;->mCurrentFragment:Landroid/support/v4/app/Fragment;

    .line 1800
    const-string v3, "[mem] AbstractRecordingActivity {} Destroyed."

    new-array v4, v5, [Ljava/lang/Object;

    const/4 v5, 0x0

    aput-object p0, v4, v5

    invoke-static {v3, v4}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 1801
    invoke-static {}, Lco/vine/android/util/FlurryUtils;->trackRecordingDestroy()V

    .line 1803
    const v3, 0x7f0a01d3

    invoke-virtual {p0, v3}, Lco/vine/android/AbstractRecordingActivity;->findViewById(I)Landroid/view/View;

    move-result-object v2

    .line 1805
    .local v2, "root":Landroid/view/View;
    :try_start_1
    invoke-direct {p0, v2}, Lco/vine/android/AbstractRecordingActivity;->unbindDrawables(Landroid/view/View;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    .line 1809
    :goto_1
    invoke-static {}, Ljava/lang/System;->gc()V

    .line 1810
    return-void

    .line 1792
    .end local v2    # "root":Landroid/view/View;
    .restart local v0    # "count":I
    :cond_1
    if-le v0, v5, :cond_0

    .line 1793
    :try_start_2
    new-instance v3, Lco/vine/android/VineLoggingException;

    const-string v4, "Double instance violation, but it\'s ok."

    invoke-direct {v3, v4}, Lco/vine/android/VineLoggingException;-><init>(Ljava/lang/String;)V

    invoke-static {v3}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;)V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_0

    goto :goto_0

    .line 1796
    .end local v0    # "count":I
    :catch_0
    move-exception v1

    .line 1797
    .local v1, "e":Ljava/io/IOException;
    invoke-static {v1}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;)V

    goto :goto_0

    .line 1806
    .end local v1    # "e":Ljava/io/IOException;
    .restart local v2    # "root":Landroid/view/View;
    :catch_1
    move-exception v1

    .line 1807
    .local v1, "e":Ljava/lang/Exception;
    const-string v3, "Failed to remove all drawables, but FINE."

    invoke-static {v3}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;)V

    goto :goto_1
.end method

.method public onDialogDone(Landroid/content/DialogInterface;II)V
    .locals 4
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "id"    # I
    .param p3, "which"    # I

    .prologue
    const/16 v3, 0x64

    const/4 v2, 0x0

    .line 834
    packed-switch p2, :pswitch_data_0

    .line 894
    :cond_0
    :goto_0
    :pswitch_0
    return-void

    .line 839
    :pswitch_1
    packed-switch p3, :pswitch_data_1

    goto :goto_0

    .line 847
    :pswitch_2
    invoke-direct {p0}, Lco/vine/android/AbstractRecordingActivity;->showCurrentFragment()V

    .line 848
    iget-object v1, p0, Lco/vine/android/AbstractRecordingActivity;->mDraftTrashButton:Landroid/view/View;

    invoke-virtual {v1, v2}, Landroid/view/View;->setActivated(Z)V

    .line 849
    iget-object v1, p0, Lco/vine/android/AbstractRecordingActivity;->mDraftTrashBackground:Landroid/view/View;

    invoke-virtual {v1, v2}, Landroid/view/View;->setActivated(Z)V

    goto :goto_0

    .line 841
    :pswitch_3
    invoke-direct {p0}, Lco/vine/android/AbstractRecordingActivity;->handleDelete()V

    .line 842
    iget-object v1, p0, Lco/vine/android/AbstractRecordingActivity;->mDraftTrashButton:Landroid/view/View;

    invoke-virtual {v1, v2}, Landroid/view/View;->setActivated(Z)V

    .line 843
    iget-object v1, p0, Lco/vine/android/AbstractRecordingActivity;->mDraftTrashBackground:Landroid/view/View;

    invoke-virtual {v1, v2}, Landroid/view/View;->setActivated(Z)V

    goto :goto_0

    .line 855
    :pswitch_4
    packed-switch p3, :pswitch_data_2

    goto :goto_0

    .line 857
    :pswitch_5
    iget-object v1, p0, Lco/vine/android/AbstractRecordingActivity;->mCurrentFragment:Landroid/support/v4/app/Fragment;

    instance-of v1, v1, Lco/vine/android/RecordingFragment;

    if-eqz v1, :cond_0

    .line 858
    iget-object v1, p0, Lco/vine/android/AbstractRecordingActivity;->mCurrentFragment:Landroid/support/v4/app/Fragment;

    check-cast v1, Lco/vine/android/RecordingFragment;

    invoke-virtual {v1, v2}, Lco/vine/android/RecordingFragment;->startDrafts(Z)V

    goto :goto_0

    .line 863
    :pswitch_6
    iget-object v1, p0, Lco/vine/android/AbstractRecordingActivity;->mCurrentFragment:Landroid/support/v4/app/Fragment;

    instance-of v1, v1, Lco/vine/android/RecordingFragment;

    if-eqz v1, :cond_0

    .line 864
    iget-object v1, p0, Lco/vine/android/AbstractRecordingActivity;->mCurrentFragment:Landroid/support/v4/app/Fragment;

    check-cast v1, Lco/vine/android/RecordingFragment;

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Lco/vine/android/RecordingFragment;->startDrafts(Z)V

    goto :goto_0

    .line 872
    :pswitch_7
    packed-switch p3, :pswitch_data_3

    goto :goto_0

    .line 874
    :pswitch_8
    invoke-virtual {p0}, Lco/vine/android/AbstractRecordingActivity;->currentlyHoldsRecordingFragment()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 875
    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mCurrentFragment:Landroid/support/v4/app/Fragment;

    check-cast v0, Lco/vine/android/RecordingFragment;

    .line 876
    .local v0, "frag":Lco/vine/android/RecordingFragment;
    invoke-virtual {v0}, Lco/vine/android/RecordingFragment;->setDiscardChangesOnStop()V

    .line 877
    invoke-virtual {v0}, Lco/vine/android/RecordingFragment;->playStopSound()V

    .line 879
    .end local v0    # "frag":Lco/vine/android/RecordingFragment;
    :cond_1
    invoke-virtual {p0}, Lco/vine/android/AbstractRecordingActivity;->discardUpload()V

    .line 880
    invoke-virtual {p0, v3}, Lco/vine/android/AbstractRecordingActivity;->setResult(I)V

    .line 881
    invoke-virtual {p0}, Lco/vine/android/AbstractRecordingActivity;->finish()V

    goto :goto_0

    .line 885
    :pswitch_9
    invoke-virtual {p0}, Lco/vine/android/AbstractRecordingActivity;->currentlyHoldsRecordingFragment()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 886
    invoke-virtual {p0, v3}, Lco/vine/android/AbstractRecordingActivity;->setResult(I)V

    .line 887
    iget-object v1, p0, Lco/vine/android/AbstractRecordingActivity;->mCurrentFragment:Landroid/support/v4/app/Fragment;

    check-cast v1, Lco/vine/android/RecordingFragment;

    invoke-virtual {v1}, Lco/vine/android/RecordingFragment;->saveSessionAndQuit()V

    goto :goto_0

    .line 834
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_7
        :pswitch_1
        :pswitch_4
        :pswitch_0
    .end packed-switch

    .line 839
    :pswitch_data_1
    .packed-switch -0x2
        :pswitch_2
        :pswitch_3
    .end packed-switch

    .line 855
    :pswitch_data_2
    .packed-switch -0x2
        :pswitch_5
        :pswitch_6
    .end packed-switch

    .line 872
    :pswitch_data_3
    .packed-switch -0x2
        :pswitch_8
        :pswitch_9
    .end packed-switch
.end method

.method public onFinishPressed(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 1259
    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mCurrentFragment:Landroid/support/v4/app/Fragment;

    instance-of v0, v0, Lco/vine/android/RecordingFragment;

    if-eqz v0, :cond_0

    .line 1260
    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mCurrentFragment:Landroid/support/v4/app/Fragment;

    check-cast v0, Lco/vine/android/RecordingFragment;

    invoke-virtual {v0, p1}, Lco/vine/android/RecordingFragment;->onFinishPressed(Landroid/view/View;)V

    .line 1262
    :cond_0
    return-void
.end method

.method public onFocusSwitchPressed(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 1272
    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mCurrentFragment:Landroid/support/v4/app/Fragment;

    instance-of v0, v0, Lco/vine/android/RecordingFragment;

    if-eqz v0, :cond_0

    .line 1273
    invoke-static {p1}, Lco/vine/android/util/FlurryUtils;->trackFocusSwitchPressed(Landroid/view/View;)V

    .line 1274
    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mCurrentFragment:Landroid/support/v4/app/Fragment;

    check-cast v0, Lco/vine/android/RecordingFragment;

    invoke-virtual {v0, p1}, Lco/vine/android/RecordingFragment;->onFocusSwitchPressed(Landroid/view/View;)V

    .line 1276
    :cond_0
    return-void
.end method

.method public onGhostSwitchPressed(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 1286
    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mCurrentFragment:Landroid/support/v4/app/Fragment;

    instance-of v0, v0, Lco/vine/android/RecordingFragment;

    if-eqz v0, :cond_0

    .line 1287
    invoke-static {p1}, Lco/vine/android/util/FlurryUtils;->trackGhostSwitchPressed(Landroid/view/View;)V

    .line 1288
    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mCurrentFragment:Landroid/support/v4/app/Fragment;

    check-cast v0, Lco/vine/android/RecordingFragment;

    invoke-virtual {v0, p1}, Lco/vine/android/RecordingFragment;->onGhostSwitchPressed(Landroid/view/View;)V

    .line 1290
    :cond_0
    return-void
.end method

.method public onGridSwitchPressed(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 1279
    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mCurrentFragment:Landroid/support/v4/app/Fragment;

    instance-of v0, v0, Lco/vine/android/RecordingFragment;

    if-eqz v0, :cond_0

    .line 1280
    invoke-static {p1}, Lco/vine/android/util/FlurryUtils;->trackGridSwitchPressed(Landroid/view/View;)V

    .line 1281
    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mCurrentFragment:Landroid/support/v4/app/Fragment;

    check-cast v0, Lco/vine/android/RecordingFragment;

    invoke-virtual {v0}, Lco/vine/android/RecordingFragment;->onGridSwitchPressed()V

    .line 1283
    :cond_0
    return-void
.end method

.method public onKeyDown(ILandroid/view/KeyEvent;)Z
    .locals 8
    .param p1, "keyCode"    # I
    .param p2, "event"    # Landroid/view/KeyEvent;

    .prologue
    const/4 v7, 0x0

    const/4 v4, 0x1

    .line 1332
    const-string v5, "KEY DOWN {}."

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 1336
    sparse-switch p1, :sswitch_data_0

    .line 1361
    const/4 v1, 0x0

    .line 1362
    .local v1, "startRelativeTime":Z
    const/4 v2, 0x0

    .line 1363
    .local v2, "zooming":Z
    const/4 v3, 0x0

    .line 1366
    .local v3, "zoomingIn":Z
    :goto_0
    invoke-direct {p0}, Lco/vine/android/AbstractRecordingActivity;->getActiveRecordingFragment()Lco/vine/android/RecordingFragment;

    move-result-object v0

    .line 1367
    .local v0, "recordingFragment":Lco/vine/android/RecordingFragment;
    iget-boolean v5, p0, Lco/vine/android/AbstractRecordingActivity;->isSecretModeOn:Z

    if-nez v5, :cond_3

    .line 1368
    sget-object v5, Lco/vine/android/AbstractRecordingActivity;->SECRETS:[I

    iget v6, p0, Lco/vine/android/AbstractRecordingActivity;->mCurrentSecret:I

    aget v5, v5, v6

    if-ne p1, v5, :cond_1

    sget-boolean v5, Lcom/edisonwang/android/slog/SLog;->sLogsOn:Z

    if-eqz v5, :cond_1

    .line 1369
    iget v5, p0, Lco/vine/android/AbstractRecordingActivity;->mCurrentSecret:I

    add-int/lit8 v5, v5, 0x1

    iput v5, p0, Lco/vine/android/AbstractRecordingActivity;->mCurrentSecret:I

    .line 1370
    iget v5, p0, Lco/vine/android/AbstractRecordingActivity;->mCurrentSecret:I

    sget-object v6, Lco/vine/android/AbstractRecordingActivity;->SECRETS:[I

    array-length v6, v6

    if-lt v5, v6, :cond_0

    .line 1371
    if-eqz v0, :cond_0

    .line 1372
    const-string v5, "Secret mode enabled."

    invoke-static {p0, v5}, Lco/vine/android/util/Util;->showCenteredToast(Landroid/content/Context;Ljava/lang/String;)Landroid/widget/Toast;

    move-result-object v5

    invoke-virtual {v0, v5}, Lco/vine/android/RecordingFragment;->enableSecretMode(Landroid/widget/Toast;)V

    .line 1373
    iput-boolean v4, p0, Lco/vine/android/AbstractRecordingActivity;->isSecretModeOn:Z

    .line 1374
    iput v7, p0, Lco/vine/android/AbstractRecordingActivity;->mCurrentSecret:I

    .line 1380
    :cond_0
    :goto_1
    if-eqz v0, :cond_7

    .line 1381
    if-eqz v2, :cond_2

    .line 1382
    invoke-virtual {v0}, Lco/vine/android/RecordingFragment;->isEditing()Z

    move-result v5

    if-nez v5, :cond_2

    .line 1383
    invoke-virtual {v0, v3}, Lco/vine/android/RecordingFragment;->modifyZoom(Z)V

    .line 1384
    invoke-virtual {v0}, Lco/vine/android/RecordingFragment;->requestZoomProgressUpdate()V

    .line 1416
    .end local v0    # "recordingFragment":Lco/vine/android/RecordingFragment;
    .end local v1    # "startRelativeTime":Z
    .end local v2    # "zooming":Z
    .end local v3    # "zoomingIn":Z
    :goto_2
    :sswitch_0
    return v4

    .line 1339
    :sswitch_1
    const/4 v3, 0x1

    .line 1340
    .restart local v3    # "zoomingIn":Z
    const/4 v2, 0x1

    .line 1341
    .restart local v2    # "zooming":Z
    const/4 v1, 0x0

    .line 1342
    .restart local v1    # "startRelativeTime":Z
    goto :goto_0

    .line 1346
    .end local v1    # "startRelativeTime":Z
    .end local v2    # "zooming":Z
    .end local v3    # "zoomingIn":Z
    :sswitch_2
    const/4 v3, 0x0

    .line 1347
    .restart local v3    # "zoomingIn":Z
    const/4 v2, 0x1

    .line 1348
    .restart local v2    # "zooming":Z
    const/4 v1, 0x0

    .line 1349
    .restart local v1    # "startRelativeTime":Z
    goto :goto_0

    .line 1352
    .end local v1    # "startRelativeTime":Z
    .end local v2    # "zooming":Z
    .end local v3    # "zoomingIn":Z
    :sswitch_3
    const/4 v1, 0x1

    .line 1353
    .restart local v1    # "startRelativeTime":Z
    const/4 v2, 0x0

    .line 1354
    .restart local v2    # "zooming":Z
    const/4 v3, 0x0

    .line 1355
    .restart local v3    # "zoomingIn":Z
    goto :goto_0

    .line 1378
    .restart local v0    # "recordingFragment":Lco/vine/android/RecordingFragment;
    :cond_1
    iput v7, p0, Lco/vine/android/AbstractRecordingActivity;->mCurrentSecret:I

    goto :goto_1

    .line 1388
    :cond_2
    if-eqz v1, :cond_7

    .line 1389
    iput-boolean v4, p0, Lco/vine/android/AbstractRecordingActivity;->mHasStartedRelativeTimeFromHardwareButton:Z

    .line 1390
    invoke-virtual {v0}, Lco/vine/android/RecordingFragment;->startRelativeTime()Z

    goto :goto_2

    .line 1395
    :cond_3
    if-eqz v0, :cond_7

    .line 1396
    if-eqz v2, :cond_6

    .line 1397
    invoke-virtual {v0}, Lco/vine/android/RecordingFragment;->isEditing()Z

    move-result v5

    if-nez v5, :cond_5

    .line 1398
    if-eqz v3, :cond_4

    .line 1399
    invoke-virtual {v0}, Lco/vine/android/RecordingFragment;->doSecretVolumeUp()V

    goto :goto_2

    .line 1401
    :cond_4
    invoke-virtual {v0}, Lco/vine/android/RecordingFragment;->doSecretVolumeDown()V

    goto :goto_2

    .line 1404
    :cond_5
    invoke-virtual {p0}, Lco/vine/android/AbstractRecordingActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v5

    const-string v6, "Reversed."

    invoke-static {v5, v6}, Lco/vine/android/util/Util;->showCenteredToast(Landroid/content/Context;Ljava/lang/String;)Landroid/widget/Toast;

    .line 1405
    invoke-virtual {v0}, Lco/vine/android/RecordingFragment;->reverseFrames()V

    goto :goto_2

    .line 1409
    :cond_6
    if-eqz v1, :cond_7

    .line 1410
    iput-boolean v4, p0, Lco/vine/android/AbstractRecordingActivity;->mHasStartedRelativeTimeFromHardwareButton:Z

    .line 1411
    invoke-virtual {v0}, Lco/vine/android/RecordingFragment;->startRelativeTime()Z

    goto :goto_2

    .line 1416
    :cond_7
    invoke-super {p0, p1, p2}, Lco/vine/android/BaseActionBarActivity;->onKeyDown(ILandroid/view/KeyEvent;)Z

    move-result v4

    goto :goto_2

    .line 1336
    nop

    :sswitch_data_0
    .sparse-switch
        0x18 -> :sswitch_1
        0x19 -> :sswitch_2
        0x1b -> :sswitch_3
        0x50 -> :sswitch_0
        0xa8 -> :sswitch_1
        0xa9 -> :sswitch_2
    .end sparse-switch
.end method

.method public onKeyUp(ILandroid/view/KeyEvent;)Z
    .locals 5
    .param p1, "keyCode"    # I
    .param p2, "event"    # Landroid/view/KeyEvent;
        .annotation build Lorg/jetbrains/annotations/NotNull;
        .end annotation
    .end param

    .prologue
    const/4 v3, 0x1

    .line 1423
    sparse-switch p1, :sswitch_data_0

    .line 1441
    const/4 v0, 0x0

    .line 1442
    .local v0, "endRelativeTime":Z
    const/4 v2, 0x0

    .line 1445
    .local v2, "zooming":Z
    :goto_0
    invoke-direct {p0}, Lco/vine/android/AbstractRecordingActivity;->getActiveRecordingFragment()Lco/vine/android/RecordingFragment;

    move-result-object v1

    .line 1446
    .local v1, "recordingFragment":Lco/vine/android/RecordingFragment;
    if-eqz v1, :cond_1

    .line 1447
    iget-boolean v4, p0, Lco/vine/android/AbstractRecordingActivity;->isSecretModeOn:Z

    if-nez v4, :cond_0

    .line 1448
    if-eqz v2, :cond_0

    .line 1449
    invoke-virtual {v1}, Lco/vine/android/RecordingFragment;->isEditing()Z

    move-result v4

    if-nez v4, :cond_0

    .line 1450
    invoke-virtual {v1}, Lco/vine/android/RecordingFragment;->stopZoom()V

    .line 1459
    .end local v0    # "endRelativeTime":Z
    .end local v1    # "recordingFragment":Lco/vine/android/RecordingFragment;
    .end local v2    # "zooming":Z
    :goto_1
    :sswitch_0
    return v3

    .line 1428
    :sswitch_1
    const/4 v2, 0x1

    .line 1429
    .restart local v2    # "zooming":Z
    const/4 v0, 0x0

    .line 1430
    .restart local v0    # "endRelativeTime":Z
    goto :goto_0

    .line 1433
    .end local v0    # "endRelativeTime":Z
    .end local v2    # "zooming":Z
    :sswitch_2
    const/4 v2, 0x0

    .line 1434
    .restart local v2    # "zooming":Z
    const/4 v0, 0x1

    .line 1435
    .restart local v0    # "endRelativeTime":Z
    goto :goto_0

    .line 1455
    .restart local v1    # "recordingFragment":Lco/vine/android/RecordingFragment;
    :cond_0
    iget-boolean v3, p0, Lco/vine/android/AbstractRecordingActivity;->mHasStartedRelativeTimeFromHardwareButton:Z

    if-eqz v3, :cond_1

    if-eqz v0, :cond_1

    .line 1456
    invoke-virtual {v1}, Lco/vine/android/RecordingFragment;->endRelativeTime()Z

    .line 1459
    :cond_1
    invoke-super {p0, p1, p2}, Lco/vine/android/BaseActionBarActivity;->onKeyUp(ILandroid/view/KeyEvent;)Z

    move-result v3

    goto :goto_1

    .line 1423
    :sswitch_data_0
    .sparse-switch
        0x18 -> :sswitch_1
        0x19 -> :sswitch_1
        0x1b -> :sswitch_2
        0x50 -> :sswitch_0
        0xa8 -> :sswitch_1
        0xa9 -> :sswitch_1
    .end sparse-switch
.end method

.method public onPageScrollStateChanged(I)V
    .locals 1
    .param p1, "i"    # I

    .prologue
    .line 727
    iput p1, p0, Lco/vine/android/AbstractRecordingActivity;->mPageScrollState:I

    .line 728
    if-nez p1, :cond_0

    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mOnPageIdleRunnable:Lco/vine/android/AbstractRecordingActivity$SetSelectedRunnable;

    if-eqz v0, :cond_0

    .line 729
    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mOnPageIdleRunnable:Lco/vine/android/AbstractRecordingActivity$SetSelectedRunnable;

    invoke-virtual {v0}, Lco/vine/android/AbstractRecordingActivity$SetSelectedRunnable;->run()V

    .line 730
    const/4 v0, 0x0

    iput-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mOnPageIdleRunnable:Lco/vine/android/AbstractRecordingActivity$SetSelectedRunnable;

    .line 732
    :cond_0
    return-void
.end method

.method public onPageScrolled(IFI)V
    .locals 0
    .param p1, "i"    # I
    .param p2, "v"    # F
    .param p3, "i2"    # I

    .prologue
    .line 498
    return-void
.end method

.method public onPageSelected(I)V
    .locals 14
    .param p1, "i"    # I

    .prologue
    const/4 v13, 0x0

    const/4 v9, 0x1

    const/4 v12, -0x1

    const/4 v10, 0x0

    .line 620
    iget-object v11, p0, Lco/vine/android/AbstractRecordingActivity;->mSessions:Ljava/util/ArrayList;

    if-eqz v11, :cond_2

    .line 621
    const/4 v2, 0x0

    .line 622
    .local v2, "fragmentToSetSelectedFalse":Lco/vine/android/DraftFragment;
    const/4 v3, 0x0

    .line 623
    .local v3, "fragmentToSetSelectedTrue":Lco/vine/android/DraftFragment;
    iget v11, p0, Lco/vine/android/AbstractRecordingActivity;->mPageScrollState:I

    if-nez v11, :cond_3

    move v4, v9

    .line 624
    .local v4, "isPageStateIdle":Z
    :goto_0
    iget-object v11, p0, Lco/vine/android/AbstractRecordingActivity;->mSessions:Ljava/util/ArrayList;

    invoke-virtual {v11}, Ljava/util/ArrayList;->size()I

    move-result v5

    .line 625
    .local v5, "numDrafts":I
    if-ne p1, v12, :cond_5

    .line 629
    iget v9, p0, Lco/vine/android/AbstractRecordingActivity;->mCurrentPage:I

    if-gt v9, v5, :cond_0

    .line 630
    iget-object v9, p0, Lco/vine/android/AbstractRecordingActivity;->mDraftFragments:Landroid/util/SparseArray;

    iget v11, p0, Lco/vine/android/AbstractRecordingActivity;->mCurrentPage:I

    invoke-virtual {v9, v11}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/ref/WeakReference;

    .line 631
    .local v1, "fragment":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/DraftFragment;>;"
    if-eqz v1, :cond_0

    .line 632
    invoke-virtual {v1}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lco/vine/android/DraftFragment;

    .line 633
    .local v7, "ref":Lco/vine/android/DraftFragment;
    if-eqz v7, :cond_0

    .line 634
    if-eqz v4, :cond_4

    .line 635
    invoke-virtual {v7, v10}, Lco/vine/android/DraftFragment;->setSelected(Z)V

    .line 719
    .end local v1    # "fragment":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/DraftFragment;>;"
    .end local v7    # "ref":Lco/vine/android/DraftFragment;
    :cond_0
    :goto_1
    if-nez v2, :cond_1

    if-eqz v3, :cond_2

    .line 720
    :cond_1
    new-instance v9, Lco/vine/android/AbstractRecordingActivity$SetSelectedRunnable;

    invoke-direct {v9, p0, v2, v3}, Lco/vine/android/AbstractRecordingActivity$SetSelectedRunnable;-><init>(Lco/vine/android/AbstractRecordingActivity;Lco/vine/android/DraftFragment;Lco/vine/android/DraftFragment;)V

    iput-object v9, p0, Lco/vine/android/AbstractRecordingActivity;->mOnPageIdleRunnable:Lco/vine/android/AbstractRecordingActivity$SetSelectedRunnable;

    .line 723
    .end local v2    # "fragmentToSetSelectedFalse":Lco/vine/android/DraftFragment;
    .end local v3    # "fragmentToSetSelectedTrue":Lco/vine/android/DraftFragment;
    .end local v4    # "isPageStateIdle":Z
    .end local v5    # "numDrafts":I
    :cond_2
    return-void

    .restart local v2    # "fragmentToSetSelectedFalse":Lco/vine/android/DraftFragment;
    .restart local v3    # "fragmentToSetSelectedTrue":Lco/vine/android/DraftFragment;
    :cond_3
    move v4, v10

    .line 623
    goto :goto_0

    .line 637
    .restart local v1    # "fragment":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/DraftFragment;>;"
    .restart local v4    # "isPageStateIdle":Z
    .restart local v5    # "numDrafts":I
    .restart local v7    # "ref":Lco/vine/android/DraftFragment;
    :cond_4
    move-object v2, v7

    goto :goto_1

    .line 643
    .end local v1    # "fragment":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/DraftFragment;>;"
    .end local v7    # "ref":Lco/vine/android/DraftFragment;
    :cond_5
    iget-object v11, p0, Lco/vine/android/AbstractRecordingActivity;->mDots:Lco/vine/android/widget/DotIndicators;

    invoke-virtual {v11, p1}, Lco/vine/android/widget/DotIndicators;->setActiveDot(I)V

    .line 644
    if-ge p1, v5, :cond_c

    .line 645
    iget v11, p0, Lco/vine/android/AbstractRecordingActivity;->mCurrentPage:I

    if-eq v11, v12, :cond_6

    .line 646
    iget v11, p0, Lco/vine/android/AbstractRecordingActivity;->mCurrentPage:I

    if-gt v11, v5, :cond_6

    .line 647
    iget-object v11, p0, Lco/vine/android/AbstractRecordingActivity;->mDraftFragments:Landroid/util/SparseArray;

    iget v12, p0, Lco/vine/android/AbstractRecordingActivity;->mCurrentPage:I

    invoke-virtual {v11, v12}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/ref/WeakReference;

    .line 648
    .restart local v1    # "fragment":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/DraftFragment;>;"
    if-eqz v1, :cond_6

    .line 649
    invoke-virtual {v1}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lco/vine/android/DraftFragment;

    .line 650
    .restart local v7    # "ref":Lco/vine/android/DraftFragment;
    if-eqz v7, :cond_6

    .line 651
    if-eqz v4, :cond_a

    .line 652
    invoke-virtual {v7, v10}, Lco/vine/android/DraftFragment;->setSelected(Z)V

    .line 660
    .end local v1    # "fragment":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/DraftFragment;>;"
    .end local v7    # "ref":Lco/vine/android/DraftFragment;
    :cond_6
    :goto_2
    iget-object v11, p0, Lco/vine/android/AbstractRecordingActivity;->mDraftFragments:Landroid/util/SparseArray;

    invoke-virtual {v11, p1}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/ref/WeakReference;

    .line 661
    .restart local v1    # "fragment":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/DraftFragment;>;"
    if-eqz v1, :cond_9

    .line 662
    invoke-virtual {v1}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lco/vine/android/DraftFragment;

    .line 663
    .restart local v7    # "ref":Lco/vine/android/DraftFragment;
    if-eqz v7, :cond_9

    .line 664
    invoke-virtual {v7}, Lco/vine/android/DraftFragment;->getView()Landroid/view/View;

    move-result-object v0

    .line 665
    .local v0, "fragView":Landroid/view/View;
    if-eqz v0, :cond_9

    .line 666
    const v11, 0x7f0a00d5

    invoke-virtual {v0, v11}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v8

    .line 667
    .local v8, "toSet":Landroid/view/View;
    if-eqz v8, :cond_9

    iget-object v11, p0, Lco/vine/android/AbstractRecordingActivity;->mDragUpToDeleteView:Lco/vine/android/widget/DragUpToDeleteContainer;

    if-eqz v11, :cond_9

    .line 668
    iget-object v11, p0, Lco/vine/android/AbstractRecordingActivity;->mDragUpToDeleteView:Lco/vine/android/widget/DragUpToDeleteContainer;

    iget-object v12, p0, Lco/vine/android/AbstractRecordingActivity;->mViewPager:Landroid/support/v4/view/DraftViewPager;

    invoke-virtual {v12}, Landroid/support/v4/view/DraftViewPager;->getLeftOfSelectedFragment()I

    move-result v12

    invoke-virtual {v11, v8, v12}, Lco/vine/android/widget/DragUpToDeleteContainer;->setView(Landroid/view/View;I)V

    .line 669
    iget-boolean v11, p0, Lco/vine/android/AbstractRecordingActivity;->mAnimatingIntoDrafts:Z

    if-eqz v11, :cond_7

    if-ge p1, v5, :cond_8

    .line 670
    :cond_7
    iget-object v11, p0, Lco/vine/android/AbstractRecordingActivity;->mDraftTrashContainer:Landroid/view/View;

    invoke-virtual {v11, v10}, Landroid/view/View;->setVisibility(I)V

    .line 671
    iget-object v10, p0, Lco/vine/android/AbstractRecordingActivity;->mDraftTrashContainer:Landroid/view/View;

    invoke-virtual {v10}, Landroid/view/View;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v10

    const/high16 v11, 0x3f800000    # 1.0f

    invoke-virtual {v10, v11}, Landroid/view/ViewPropertyAnimator;->alpha(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v10

    invoke-virtual {v10}, Landroid/view/ViewPropertyAnimator;->start()V

    .line 673
    :cond_8
    iget-object v10, p0, Lco/vine/android/AbstractRecordingActivity;->mHandler:Landroid/os/Handler;

    iget-object v11, p0, Lco/vine/android/AbstractRecordingActivity;->mOnResumeDraftRunnable:Ljava/lang/Runnable;

    invoke-virtual {v10, v11}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 674
    iget v10, p0, Lco/vine/android/AbstractRecordingActivity;->mPageScrollState:I

    if-nez v10, :cond_b

    .line 675
    invoke-virtual {v7, v9}, Lco/vine/android/DraftFragment;->setSelected(Z)V

    .line 683
    .end local v0    # "fragView":Landroid/view/View;
    .end local v7    # "ref":Lco/vine/android/DraftFragment;
    .end local v8    # "toSet":Landroid/view/View;
    :cond_9
    :goto_3
    iget-object v9, p0, Lco/vine/android/AbstractRecordingActivity;->mSessions:Ljava/util/ArrayList;

    invoke-virtual {v9, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Lco/vine/android/recorder/RecordSessionManager$RecordSessionInfo;

    iput-object v9, p0, Lco/vine/android/AbstractRecordingActivity;->mCurrentSession:Lco/vine/android/recorder/RecordSessionManager$RecordSessionInfo;

    .line 717
    .end local v1    # "fragment":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/DraftFragment;>;"
    :goto_4
    iput p1, p0, Lco/vine/android/AbstractRecordingActivity;->mCurrentPage:I

    goto/16 :goto_1

    .line 654
    .restart local v1    # "fragment":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/DraftFragment;>;"
    .restart local v7    # "ref":Lco/vine/android/DraftFragment;
    :cond_a
    move-object v2, v7

    goto :goto_2

    .line 677
    .restart local v0    # "fragView":Landroid/view/View;
    .restart local v8    # "toSet":Landroid/view/View;
    :cond_b
    move-object v3, v7

    goto :goto_3

    .line 685
    .end local v0    # "fragView":Landroid/view/View;
    .end local v1    # "fragment":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/DraftFragment;>;"
    .end local v7    # "ref":Lco/vine/android/DraftFragment;
    .end local v8    # "toSet":Landroid/view/View;
    :cond_c
    iget v9, p0, Lco/vine/android/AbstractRecordingActivity;->mCurrentPage:I

    if-eq v9, v12, :cond_d

    .line 686
    iget-object v9, p0, Lco/vine/android/AbstractRecordingActivity;->mDraftFragments:Landroid/util/SparseArray;

    iget v11, p0, Lco/vine/android/AbstractRecordingActivity;->mCurrentPage:I

    invoke-virtual {v9, v11}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/ref/WeakReference;

    .line 687
    .restart local v1    # "fragment":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/DraftFragment;>;"
    if-eqz v1, :cond_10

    .line 688
    invoke-virtual {v1}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lco/vine/android/DraftFragment;

    .line 689
    .local v6, "prev":Lco/vine/android/DraftFragment;
    if-eqz v6, :cond_d

    .line 690
    if-eqz v4, :cond_f

    .line 691
    invoke-virtual {v6, v10}, Lco/vine/android/DraftFragment;->setSelected(Z)V

    .line 701
    .end local v1    # "fragment":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/DraftFragment;>;"
    .end local v6    # "prev":Lco/vine/android/DraftFragment;
    :cond_d
    :goto_5
    iget-object v9, p0, Lco/vine/android/AbstractRecordingActivity;->mCameraFragment:Ljava/lang/ref/WeakReference;

    if-eqz v9, :cond_e

    .line 702
    iget-object v9, p0, Lco/vine/android/AbstractRecordingActivity;->mCameraFragment:Ljava/lang/ref/WeakReference;

    invoke-virtual {v9}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lco/vine/android/DraftCameraPreviewFragment;

    .line 703
    .local v7, "ref":Lco/vine/android/DraftCameraPreviewFragment;
    if-eqz v7, :cond_e

    .line 704
    iget-object v9, p0, Lco/vine/android/AbstractRecordingActivity;->mHandler:Landroid/os/Handler;

    iget-object v10, p0, Lco/vine/android/AbstractRecordingActivity;->mOnResumeDraftRunnable:Ljava/lang/Runnable;

    invoke-virtual {v9, v10}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 707
    .end local v7    # "ref":Lco/vine/android/DraftCameraPreviewFragment;
    :cond_e
    iput-object v13, p0, Lco/vine/android/AbstractRecordingActivity;->mCurrentSession:Lco/vine/android/recorder/RecordSessionManager$RecordSessionInfo;

    .line 708
    iget-object v9, p0, Lco/vine/android/AbstractRecordingActivity;->mDragUpToDeleteView:Lco/vine/android/widget/DragUpToDeleteContainer;

    iget-object v10, p0, Lco/vine/android/AbstractRecordingActivity;->mViewPager:Landroid/support/v4/view/DraftViewPager;

    invoke-virtual {v10}, Landroid/support/v4/view/DraftViewPager;->getLeftOfSelectedFragment()I

    move-result v10

    invoke-virtual {v9, v13, v10}, Lco/vine/android/widget/DragUpToDeleteContainer;->setView(Landroid/view/View;I)V

    .line 709
    iget-object v9, p0, Lco/vine/android/AbstractRecordingActivity;->mDraftTrashContainer:Landroid/view/View;

    invoke-virtual {v9}, Landroid/view/View;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v9

    const/4 v10, 0x0

    invoke-virtual {v9, v10}, Landroid/view/ViewPropertyAnimator;->alpha(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v9

    new-instance v10, Lco/vine/android/AbstractRecordingActivity$5;

    invoke-direct {v10, p0}, Lco/vine/android/AbstractRecordingActivity$5;-><init>(Lco/vine/android/AbstractRecordingActivity;)V

    invoke-virtual {v9, v10}, Landroid/view/ViewPropertyAnimator;->setListener(Landroid/animation/Animator$AnimatorListener;)Landroid/view/ViewPropertyAnimator;

    move-result-object v9

    invoke-virtual {v9}, Landroid/view/ViewPropertyAnimator;->start()V

    goto :goto_4

    .line 693
    .restart local v1    # "fragment":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/DraftFragment;>;"
    .restart local v6    # "prev":Lco/vine/android/DraftFragment;
    :cond_f
    move-object v2, v6

    goto :goto_5

    .line 698
    .end local v6    # "prev":Lco/vine/android/DraftFragment;
    :cond_10
    const-string v9, "Fragment {} is null: size: {}."

    iget v10, p0, Lco/vine/android/AbstractRecordingActivity;->mCurrentPage:I

    invoke-static {v10}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v10

    iget-object v11, p0, Lco/vine/android/AbstractRecordingActivity;->mDraftFragments:Landroid/util/SparseArray;

    invoke-virtual {v11}, Landroid/util/SparseArray;->size()I

    move-result v11

    invoke-static {v11}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v11

    invoke-static {v9, v10, v11}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    goto :goto_5
.end method

.method protected onPause()V
    .locals 1

    .prologue
    .line 478
    invoke-super {p0}, Lco/vine/android/BaseActionBarActivity;->onPause()V

    .line 479
    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mPromptDialog:Lco/vine/android/widgets/PromptDialogFragment;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mPromptDialog:Lco/vine/android/widgets/PromptDialogFragment;

    invoke-virtual {v0}, Lco/vine/android/widgets/PromptDialogFragment;->isVisible()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 480
    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mPromptDialog:Lco/vine/android/widgets/PromptDialogFragment;

    invoke-virtual {v0}, Lco/vine/android/widgets/PromptDialogFragment;->dismiss()V

    .line 482
    :cond_0
    invoke-direct {p0}, Lco/vine/android/AbstractRecordingActivity;->releasePlayers()V

    .line 483
    return-void
.end method

.method public onRecorderBackPressed(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 767
    :try_start_0
    invoke-virtual {p0}, Lco/vine/android/AbstractRecordingActivity;->onBackPressed()V
    :try_end_0
    .catch Ljava/lang/IllegalStateException; {:try_start_0 .. :try_end_0} :catch_0

    .line 771
    :goto_0
    return-void

    .line 768
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method protected onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "outState"    # Landroid/os/Bundle;

    .prologue
    .line 491
    invoke-super {p0, p1}, Lco/vine/android/BaseActionBarActivity;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 492
    const-string v0, "state_fp"

    iget-boolean v1, p0, Lco/vine/android/AbstractRecordingActivity;->mFirstPageSet:Z

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 493
    const-string v0, "first_launch"

    iget-boolean v1, p0, Lco/vine/android/AbstractRecordingActivity;->mFirstDraftLaunch:Z

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 494
    return-void
.end method

.method public onSessionSwitchPressed(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 1293
    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mCurrentFragment:Landroid/support/v4/app/Fragment;

    instance-of v0, v0, Lco/vine/android/RecordingFragment;

    if-eqz v0, :cond_0

    .line 1294
    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mCurrentFragment:Landroid/support/v4/app/Fragment;

    check-cast v0, Lco/vine/android/RecordingFragment;

    invoke-virtual {v0, p1}, Lco/vine/android/RecordingFragment;->onSessionSwitchPressed(Landroid/view/View;)V

    .line 1296
    :cond_0
    return-void
.end method

.method public preSetContentView()V
    .locals 1

    .prologue
    .line 284
    invoke-static {}, Lco/vine/android/recorder/CameraManager;->hasCamera()Z

    move-result v0

    if-nez v0, :cond_0

    .line 285
    invoke-static {p0}, Lco/vine/android/util/Util;->showNoCameraToast(Landroid/content/Context;)V

    .line 286
    invoke-virtual {p0}, Lco/vine/android/AbstractRecordingActivity;->finish()V

    .line 288
    :cond_0
    return-void
.end method

.method public prepareForPickup()Z
    .locals 5

    .prologue
    const/4 v2, 0x0

    .line 502
    iget-boolean v3, p0, Lco/vine/android/AbstractRecordingActivity;->mAnimatingIntoDrafts:Z

    if-nez v3, :cond_0

    .line 503
    iget-object v3, p0, Lco/vine/android/AbstractRecordingActivity;->mDraftFragments:Landroid/util/SparseArray;

    iget v4, p0, Lco/vine/android/AbstractRecordingActivity;->mCurrentPage:I

    invoke-virtual {v3, v4}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/ref/WeakReference;

    .line 504
    .local v0, "fragment":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/DraftFragment;>;"
    if-eqz v0, :cond_0

    .line 505
    invoke-virtual {v0}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lco/vine/android/DraftFragment;

    .line 506
    .local v1, "ref":Lco/vine/android/DraftFragment;
    iput-boolean v2, v1, Lco/vine/android/DraftFragment;->mCanUnhide:Z

    .line 507
    invoke-virtual {v1}, Lco/vine/android/DraftFragment;->pausePlayer()V

    .line 508
    invoke-virtual {v1}, Lco/vine/android/DraftFragment;->showImage()V

    .line 511
    .end local v0    # "fragment":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/DraftFragment;>;"
    .end local v1    # "ref":Lco/vine/android/DraftFragment;
    :cond_0
    iget-boolean v3, p0, Lco/vine/android/AbstractRecordingActivity;->mAnimatingIntoDrafts:Z

    if-nez v3, :cond_1

    const/4 v2, 0x1

    :cond_1
    return v2
.end method

.method public declared-synchronized releaseOtherPlayers(Lco/vine/android/player/SdkVideoView;)V
    .locals 3
    .param p1, "videoView"    # Lco/vine/android/player/SdkVideoView;

    .prologue
    .line 1608
    monitor-enter p0

    :try_start_0
    iget-object v2, p0, Lco/vine/android/AbstractRecordingActivity;->mVideoViews:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lco/vine/android/player/SdkVideoView;

    .line 1609
    .local v1, "v":Lco/vine/android/player/SdkVideoView;
    if-eq v1, p1, :cond_0

    .line 1610
    invoke-virtual {v1}, Lco/vine/android/player/SdkVideoView;->suspend()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 1608
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v1    # "v":Lco/vine/android/player/SdkVideoView;
    :catchall_0
    move-exception v2

    monitor-exit p0

    throw v2

    .line 1613
    .restart local v0    # "i$":Ljava/util/Iterator;
    :cond_1
    :try_start_1
    iget-object v2, p0, Lco/vine/android/AbstractRecordingActivity;->mVideoViews:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->clear()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 1614
    monitor-exit p0

    return-void
.end method

.method public requestForMoreMemory()V
    .locals 2

    .prologue
    .line 245
    :try_start_0
    invoke-static {p0}, Lco/vine/android/client/AppController;->getInstance(Landroid/content/Context;)Lco/vine/android/client/AppController;

    move-result-object v1

    invoke-virtual {v1}, Lco/vine/android/client/AppController;->clearImageCacheFromMemory()V
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    .line 249
    :goto_0
    return-void

    .line 246
    :catch_0
    move-exception v0

    .line 247
    .local v0, "e":Ljava/lang/RuntimeException;
    const-string v1, "Failed to clear image cache memory."

    invoke-static {v1}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public showDeleteDialog()V
    .locals 2

    .prologue
    .line 1735
    const/4 v1, 0x1

    invoke-static {v1}, Lco/vine/android/widgets/PromptDialogFragment;->newInstance(I)Lco/vine/android/widgets/PromptDialogFragment;

    move-result-object v0

    .line 1737
    .local v0, "p":Lco/vine/android/widgets/PromptDialogFragment;
    invoke-virtual {v0, p0}, Lco/vine/android/widgets/PromptDialogFragment;->setListener(Lco/vine/android/widgets/PromptDialogFragment$OnDialogDoneListener;)V

    .line 1738
    const v1, 0x7f0e00b3

    invoke-virtual {v0, v1}, Lco/vine/android/widgets/PromptDialogFragment;->setMessage(I)Lco/vine/android/widgets/PromptDialogFragment;

    .line 1739
    const v1, 0x7f0e00b6

    invoke-virtual {v0, v1}, Lco/vine/android/widgets/PromptDialogFragment;->setPositiveButton(I)Lco/vine/android/widgets/PromptDialogFragment;

    .line 1740
    const v1, 0x7f0e0057

    invoke-virtual {v0, v1}, Lco/vine/android/widgets/PromptDialogFragment;->setNegativeButton(I)Lco/vine/android/widgets/PromptDialogFragment;

    .line 1741
    invoke-virtual {p0}, Lco/vine/android/AbstractRecordingActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v1

    invoke-virtual {v0, v1}, Lco/vine/android/widgets/PromptDialogFragment;->show(Landroid/app/FragmentManager;)V

    .line 1742
    return-void
.end method

.method public showDrafts(Ljava/lang/String;)V
    .locals 29
    .param p1, "sessionId"    # Ljava/lang/String;

    .prologue
    .line 955
    :try_start_0
    const-string v2, "Started showing drafts."

    invoke-static {v2}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;)V

    .line 956
    const-string v2, "camera_preview"

    move-object/from16 v0, p1

    invoke-virtual {v2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v21

    .line 957
    .local v21, "goToCamera":Z
    const/4 v2, 0x1

    move-object/from16 v0, p0

    iput-boolean v2, v0, Lco/vine/android/AbstractRecordingActivity;->mAnimatingIntoDrafts:Z

    .line 958
    move-object/from16 v0, p1

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/AbstractRecordingActivity;->mStartSessionId:Ljava/lang/String;

    .line 959
    const/4 v2, 0x0

    move-object/from16 v0, p0

    iput-boolean v2, v0, Lco/vine/android/AbstractRecordingActivity;->mFirstPageSet:Z

    .line 960
    invoke-direct/range {p0 .. p0}, Lco/vine/android/AbstractRecordingActivity;->getVersion()Lco/vine/android/recorder/RecordSessionVersion;

    move-result-object v2

    move-object/from16 v0, p0

    invoke-static {v0, v2}, Lco/vine/android/recorder/RecordSessionManager;->getValidSessions(Landroid/content/Context;Lco/vine/android/recorder/RecordSessionVersion;)Ljava/util/ArrayList;

    move-result-object v2

    move-object/from16 v0, p0

    invoke-direct {v0, v2}, Lco/vine/android/AbstractRecordingActivity;->reload(Ljava/util/ArrayList;)V

    .line 961
    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/AbstractRecordingActivity;->mDraftFullMask:Landroid/view/View;

    const/4 v4, 0x0

    invoke-virtual {v2, v4}, Landroid/view/View;->setVisibility(I)V

    .line 962
    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/AbstractRecordingActivity;->mDraftMaskParent:Landroid/view/View;

    const/4 v4, 0x0

    invoke-virtual {v2, v4}, Landroid/view/View;->setVisibility(I)V

    .line 963
    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/AbstractRecordingActivity;->mCameraIconOverlayImage:Landroid/view/View;

    const/16 v4, 0x8

    invoke-virtual {v2, v4}, Landroid/view/View;->setVisibility(I)V

    .line 965
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/AbstractRecordingActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v25

    .line 966
    .local v25, "r":Landroid/content/res/Resources;
    const v2, 0x7f0b006a

    move-object/from16 v0, v25

    invoke-virtual {v0, v2}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v24

    .line 967
    .local v24, "progressDimen":I
    const v2, 0x7f0b0033

    move-object/from16 v0, v25

    invoke-virtual {v0, v2}, Landroid/content/res/Resources;->getDimensionPixelOffset(I)I

    move-result v18

    .line 970
    .local v18, "draftProgressDimen":I
    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/AbstractRecordingActivity;->mTopMaskHeight:I

    move/from16 v28, v0

    .line 971
    .local v28, "topMaskHeight":I
    if-eqz v21, :cond_0

    .line 972
    add-int v28, v28, v18

    .line 975
    :cond_0
    if-nez v21, :cond_4

    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/AbstractRecordingActivity;->mCurrentFragment:Landroid/support/v4/app/Fragment;

    instance-of v2, v2, Lco/vine/android/RecordingFragment;

    if-eqz v2, :cond_4

    .line 976
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/AbstractRecordingActivity;->mLargeThumbnailOverlay:Landroid/widget/ImageView;

    move-object/from16 v26, v0

    .line 978
    .local v26, "thumb":Landroid/widget/ImageView;
    invoke-virtual/range {v26 .. v26}, Landroid/widget/ImageView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v27

    check-cast v27, Landroid/widget/RelativeLayout$LayoutParams;

    .line 980
    .local v27, "thumbnailParams":Landroid/widget/RelativeLayout$LayoutParams;
    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/AbstractRecordingActivity;->mScreenSize:Landroid/graphics/Point;

    iget v2, v2, Landroid/graphics/Point;->x:I

    move-object/from16 v0, v27

    iput v2, v0, Landroid/widget/RelativeLayout$LayoutParams;->width:I

    .line 981
    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/AbstractRecordingActivity;->mScreenSize:Landroid/graphics/Point;

    iget v2, v2, Landroid/graphics/Point;->x:I

    move-object/from16 v0, v27

    iput v2, v0, Landroid/widget/RelativeLayout$LayoutParams;->height:I

    .line 982
    const/4 v2, 0x0

    move-object/from16 v0, v27

    iput v2, v0, Landroid/widget/RelativeLayout$LayoutParams;->leftMargin:I

    .line 983
    move/from16 v0, v24

    move-object/from16 v1, v27

    iput v0, v1, Landroid/widget/RelativeLayout$LayoutParams;->topMargin:I

    .line 984
    invoke-virtual/range {v26 .. v27}, Landroid/widget/ImageView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 986
    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/AbstractRecordingActivity;->mCurrentFragment:Landroid/support/v4/app/Fragment;

    check-cast v2, Lco/vine/android/RecordingFragment;

    invoke-virtual {v2}, Lco/vine/android/RecordingFragment;->getThumbnailPath()Ljava/lang/String;

    move-result-object v23

    .line 987
    .local v23, "path":Ljava/lang/String;
    new-instance v19, Landroid/graphics/drawable/BitmapDrawable;

    invoke-virtual/range {p0 .. p0}, Lco/vine/android/AbstractRecordingActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    move-object/from16 v0, v19

    move-object/from16 v1, v23

    invoke-direct {v0, v2, v1}, Landroid/graphics/drawable/BitmapDrawable;-><init>(Landroid/content/res/Resources;Ljava/lang/String;)V

    .line 988
    .local v19, "drawable":Landroid/graphics/drawable/BitmapDrawable;
    move-object/from16 v0, v26

    move-object/from16 v1, v19

    invoke-static {v0, v1}, Lco/vine/android/util/ViewUtil;->setBackground(Landroid/view/View;Landroid/graphics/drawable/Drawable;)V

    .line 989
    const/4 v2, 0x0

    move-object/from16 v0, v26

    invoke-virtual {v0, v2}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 1002
    .end local v19    # "drawable":Landroid/graphics/drawable/BitmapDrawable;
    .end local v23    # "path":Ljava/lang/String;
    .end local v26    # "thumb":Landroid/widget/ImageView;
    .end local v27    # "thumbnailParams":Landroid/widget/RelativeLayout$LayoutParams;
    :cond_1
    :goto_0
    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/AbstractRecordingActivity;->mViewPager:Landroid/support/v4/view/DraftViewPager;

    new-instance v4, Lco/vine/android/AbstractRecordingActivity$8;

    move-object/from16 v0, p0

    move/from16 v1, v21

    invoke-direct {v4, v0, v1}, Lco/vine/android/AbstractRecordingActivity$8;-><init>(Lco/vine/android/AbstractRecordingActivity;Z)V

    invoke-virtual {v2, v4}, Landroid/support/v4/view/DraftViewPager;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 1015
    new-instance v17, Landroid/view/animation/AnimationSet;

    const/4 v2, 0x1

    move-object/from16 v0, v17

    invoke-direct {v0, v2}, Landroid/view/animation/AnimationSet;-><init>(Z)V

    .line 1016
    .local v17, "as":Landroid/view/animation/AnimationSet;
    sget-object v2, Lco/vine/android/util/ViewUtil$ResizeAnimationType;->EXPAND_HEIGHT:Lco/vine/android/util/ViewUtil$ResizeAnimationType;

    move-object/from16 v0, p0

    iget-object v4, v0, Lco/vine/android/AbstractRecordingActivity;->mDraftMaskTop:Landroid/view/View;

    move/from16 v0, v28

    invoke-static {v2, v4, v0}, Lco/vine/android/util/ViewUtil;->makeResizeAnimation(Lco/vine/android/util/ViewUtil$ResizeAnimationType;Landroid/view/View;I)Landroid/view/animation/Animation;

    move-result-object v2

    move-object/from16 v0, v17

    invoke-virtual {v0, v2}, Landroid/view/animation/AnimationSet;->addAnimation(Landroid/view/animation/Animation;)V

    .line 1018
    sget-object v2, Lco/vine/android/util/ViewUtil$ResizeAnimationType;->EXPAND_WIDTH:Lco/vine/android/util/ViewUtil$ResizeAnimationType;

    move-object/from16 v0, p0

    iget-object v4, v0, Lco/vine/android/AbstractRecordingActivity;->mDraftMaskLeft:Landroid/view/View;

    move-object/from16 v0, p0

    iget v5, v0, Lco/vine/android/AbstractRecordingActivity;->mSideMaskWidth:I

    invoke-static {v2, v4, v5}, Lco/vine/android/util/ViewUtil;->makeResizeAnimation(Lco/vine/android/util/ViewUtil$ResizeAnimationType;Landroid/view/View;I)Landroid/view/animation/Animation;

    move-result-object v2

    move-object/from16 v0, v17

    invoke-virtual {v0, v2}, Landroid/view/animation/AnimationSet;->addAnimation(Landroid/view/animation/Animation;)V

    .line 1020
    sget-object v2, Lco/vine/android/util/ViewUtil$ResizeAnimationType;->EXPAND_WIDTH:Lco/vine/android/util/ViewUtil$ResizeAnimationType;

    move-object/from16 v0, p0

    iget-object v4, v0, Lco/vine/android/AbstractRecordingActivity;->mDraftMaskRight:Landroid/view/View;

    move-object/from16 v0, p0

    iget v5, v0, Lco/vine/android/AbstractRecordingActivity;->mSideMaskWidth:I

    invoke-static {v2, v4, v5}, Lco/vine/android/util/ViewUtil;->makeResizeAnimation(Lco/vine/android/util/ViewUtil$ResizeAnimationType;Landroid/view/View;I)Landroid/view/animation/Animation;

    move-result-object v2

    move-object/from16 v0, v17

    invoke-virtual {v0, v2}, Landroid/view/animation/AnimationSet;->addAnimation(Landroid/view/animation/Animation;)V

    .line 1023
    new-instance v2, Lco/vine/android/AbstractRecordingActivity$9;

    move-object/from16 v0, p0

    move/from16 v1, v21

    invoke-direct {v2, v0, v1}, Lco/vine/android/AbstractRecordingActivity$9;-><init>(Lco/vine/android/AbstractRecordingActivity;Z)V

    move-object/from16 v0, v17

    invoke-virtual {v0, v2}, Landroid/view/animation/AnimationSet;->setAnimationListener(Landroid/view/animation/Animation$AnimationListener;)V

    .line 1098
    const-wide/16 v4, 0x12c

    move-object/from16 v0, v17

    invoke-virtual {v0, v4, v5}, Landroid/view/animation/AnimationSet;->setDuration(J)V

    .line 1099
    invoke-direct/range {p0 .. p0}, Lco/vine/android/AbstractRecordingActivity;->setCurrentSession()Z

    .line 1100
    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/AbstractRecordingActivity;->mDragUpToDeleteView:Lco/vine/android/widget/DragUpToDeleteContainer;

    const/4 v4, 0x0

    invoke-virtual {v2, v4}, Lco/vine/android/widget/DragUpToDeleteContainer;->setVisibility(I)V

    .line 1102
    if-nez v21, :cond_3

    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/AbstractRecordingActivity;->mCurrentFragment:Landroid/support/v4/app/Fragment;

    instance-of v2, v2, Lco/vine/android/RecordingFragment;

    if-eqz v2, :cond_3

    .line 1103
    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/AbstractRecordingActivity;->mCurrentFragment:Landroid/support/v4/app/Fragment;

    check-cast v2, Lco/vine/android/RecordingFragment;

    invoke-virtual {v2}, Lco/vine/android/RecordingFragment;->getProgressView()Landroid/view/View;

    move-result-object v3

    .line 1104
    .local v3, "progress":Landroid/view/View;
    if-eqz v3, :cond_2

    .line 1105
    move-object/from16 v0, p0

    iget-object v4, v0, Lco/vine/android/AbstractRecordingActivity;->mAnimationPreviewOverlay:Landroid/view/View;

    invoke-virtual {v3}, Landroid/view/View;->getWidth()I

    move-result v5

    const/4 v6, 0x0

    const/4 v7, 0x0

    move-object/from16 v2, p0

    invoke-static/range {v2 .. v7}, Lco/vine/android/util/FloatingViewUtils;->buildFloatingViewFor(Landroid/content/Context;Landroid/view/View;Landroid/view/View;III)Landroid/graphics/Bitmap;

    .line 1108
    :cond_2
    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/AbstractRecordingActivity;->mAnimationPreviewOverlay:Landroid/view/View;

    const/4 v4, 0x0

    invoke-virtual {v2, v4}, Landroid/view/View;->setVisibility(I)V

    .line 1111
    .end local v3    # "progress":Landroid/view/View;
    :cond_3
    if-eqz v21, :cond_5

    .line 1112
    new-instance v4, Lco/vine/android/animation/MoveResizeAnimator;

    const/4 v5, 0x7

    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/AbstractRecordingActivity;->mCameraIconOverlay:Landroid/view/View;

    move-object/from16 v0, p0

    iget-object v7, v0, Lco/vine/android/AbstractRecordingActivity;->mCameraIconOverlay:Landroid/view/View;

    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/AbstractRecordingActivity;->mScreenSize:Landroid/graphics/Point;

    iget v2, v2, Landroid/graphics/Point;->x:I

    int-to-float v2, v2

    const/high16 v8, 0x3f800000    # 1.0f

    move-object/from16 v0, p0

    iget v9, v0, Lco/vine/android/AbstractRecordingActivity;->mPreviewRatio:F

    sub-float/2addr v8, v9

    mul-float/2addr v2, v8

    const/high16 v8, 0x40000000    # 2.0f

    div-float/2addr v2, v8

    float-to-int v8, v2

    mul-int/lit8 v2, v18, 0x2

    add-int v9, v24, v2

    move-object/from16 v0, p0

    iget v2, v0, Lco/vine/android/AbstractRecordingActivity;->mPreviewRatio:F

    float-to-double v10, v2

    move-object/from16 v0, p0

    iget v2, v0, Lco/vine/android/AbstractRecordingActivity;->mPreviewRatio:F

    float-to-double v12, v2

    const/16 v14, 0x12c

    const/16 v16, 0x0

    move-object/from16 v15, p0

    invoke-direct/range {v4 .. v16}, Lco/vine/android/animation/MoveResizeAnimator;-><init>(ILandroid/view/View;Landroid/view/View;IIDDILco/vine/android/animation/SmoothAnimator$AnimationListener;Ljava/lang/Object;)V

    invoke-virtual {v4}, Lco/vine/android/animation/MoveResizeAnimator;->start()V

    .line 1132
    :goto_1
    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/AbstractRecordingActivity;->mDraftRoot:Landroid/view/View;

    move-object/from16 v0, v17

    invoke-virtual {v2, v0}, Landroid/view/View;->startAnimation(Landroid/view/animation/Animation;)V

    .line 1138
    .end local v17    # "as":Landroid/view/animation/AnimationSet;
    .end local v18    # "draftProgressDimen":I
    .end local v21    # "goToCamera":Z
    .end local v24    # "progressDimen":I
    .end local v25    # "r":Landroid/content/res/Resources;
    .end local v28    # "topMaskHeight":I
    :goto_2
    return-void

    .line 990
    .restart local v18    # "draftProgressDimen":I
    .restart local v21    # "goToCamera":Z
    .restart local v24    # "progressDimen":I
    .restart local v25    # "r":Landroid/content/res/Resources;
    .restart local v28    # "topMaskHeight":I
    :cond_4
    if-eqz v21, :cond_1

    .line 991
    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/AbstractRecordingActivity;->mCameraIconOverlay:Landroid/view/View;

    const/4 v4, 0x0

    invoke-virtual {v2, v4}, Landroid/view/View;->setVisibility(I)V

    .line 992
    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/AbstractRecordingActivity;->mCameraIconOverlay:Landroid/view/View;

    invoke-virtual {v2}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v22

    check-cast v22, Landroid/widget/RelativeLayout$LayoutParams;

    .line 994
    .local v22, "iconParams":Landroid/widget/RelativeLayout$LayoutParams;
    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/AbstractRecordingActivity;->mScreenSize:Landroid/graphics/Point;

    iget v2, v2, Landroid/graphics/Point;->x:I

    move-object/from16 v0, v22

    iput v2, v0, Landroid/widget/RelativeLayout$LayoutParams;->width:I

    .line 995
    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/AbstractRecordingActivity;->mScreenSize:Landroid/graphics/Point;

    iget v2, v2, Landroid/graphics/Point;->x:I

    move-object/from16 v0, v22

    iput v2, v0, Landroid/widget/RelativeLayout$LayoutParams;->height:I

    .line 996
    move/from16 v0, v24

    move-object/from16 v1, v22

    iput v0, v1, Landroid/widget/RelativeLayout$LayoutParams;->topMargin:I

    .line 997
    const/4 v2, 0x0

    move-object/from16 v0, v22

    iput v2, v0, Landroid/widget/RelativeLayout$LayoutParams;->leftMargin:I

    .line 998
    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/AbstractRecordingActivity;->mCameraIconOverlay:Landroid/view/View;

    move-object/from16 v0, v22

    invoke-virtual {v2, v0}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    goto/16 :goto_0

    .line 1133
    .end local v18    # "draftProgressDimen":I
    .end local v21    # "goToCamera":Z
    .end local v22    # "iconParams":Landroid/widget/RelativeLayout$LayoutParams;
    .end local v24    # "progressDimen":I
    .end local v25    # "r":Landroid/content/res/Resources;
    .end local v28    # "topMaskHeight":I
    :catch_0
    move-exception v20

    .line 1134
    .local v20, "e":Ljava/io/IOException;
    const-string v2, "Error refresh reloading drafts."

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/Object;

    move-object/from16 v0, v20

    invoke-static {v0, v2, v4}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_2

    .line 1119
    .end local v20    # "e":Ljava/io/IOException;
    .restart local v17    # "as":Landroid/view/animation/AnimationSet;
    .restart local v18    # "draftProgressDimen":I
    .restart local v21    # "goToCamera":Z
    .restart local v24    # "progressDimen":I
    .restart local v25    # "r":Landroid/content/res/Resources;
    .restart local v28    # "topMaskHeight":I
    :cond_5
    :try_start_1
    new-instance v4, Lco/vine/android/animation/MoveResizeAnimator;

    const/4 v5, 0x6

    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/AbstractRecordingActivity;->mAnimationPreviewOverlay:Landroid/view/View;

    move-object/from16 v0, p0

    iget-object v7, v0, Lco/vine/android/AbstractRecordingActivity;->mAnimationPreviewOverlay:Landroid/view/View;

    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/AbstractRecordingActivity;->mScreenSize:Landroid/graphics/Point;

    iget v2, v2, Landroid/graphics/Point;->x:I

    int-to-float v2, v2

    const/high16 v8, 0x3f800000    # 1.0f

    move-object/from16 v0, p0

    iget v9, v0, Lco/vine/android/AbstractRecordingActivity;->mPreviewRatio:F

    sub-float/2addr v8, v9

    mul-float/2addr v2, v8

    const/high16 v8, 0x40000000    # 2.0f

    div-float/2addr v2, v8

    float-to-int v8, v2

    add-int v9, v24, v18

    move-object/from16 v0, p0

    iget v2, v0, Lco/vine/android/AbstractRecordingActivity;->mPreviewRatio:F

    float-to-double v10, v2

    const-wide/high16 v12, 0x3fe0000000000000L    # 0.5

    const/16 v14, 0x12c

    const/16 v16, 0x0

    move-object/from16 v15, p0

    invoke-direct/range {v4 .. v16}, Lco/vine/android/animation/MoveResizeAnimator;-><init>(ILandroid/view/View;Landroid/view/View;IIDDILco/vine/android/animation/SmoothAnimator$AnimationListener;Ljava/lang/Object;)V

    invoke-virtual {v4}, Lco/vine/android/animation/MoveResizeAnimator;->start()V

    .line 1125
    new-instance v4, Lco/vine/android/animation/MoveResizeAnimator;

    const/4 v5, 0x5

    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/AbstractRecordingActivity;->mLargeThumbnailOverlay:Landroid/widget/ImageView;

    move-object/from16 v0, p0

    iget-object v7, v0, Lco/vine/android/AbstractRecordingActivity;->mLargeThumbnailOverlay:Landroid/widget/ImageView;

    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/AbstractRecordingActivity;->mScreenSize:Landroid/graphics/Point;

    iget v2, v2, Landroid/graphics/Point;->x:I

    int-to-float v2, v2

    const/high16 v8, 0x3f800000    # 1.0f

    move-object/from16 v0, p0

    iget v9, v0, Lco/vine/android/AbstractRecordingActivity;->mPreviewRatio:F

    sub-float/2addr v8, v9

    mul-float/2addr v2, v8

    const/high16 v8, 0x40000000    # 2.0f

    div-float/2addr v2, v8

    float-to-int v8, v2

    mul-int/lit8 v2, v18, 0x2

    add-int v9, v24, v2

    move-object/from16 v0, p0

    iget v2, v0, Lco/vine/android/AbstractRecordingActivity;->mPreviewRatio:F

    float-to-double v10, v2

    move-object/from16 v0, p0

    iget v2, v0, Lco/vine/android/AbstractRecordingActivity;->mPreviewRatio:F

    float-to-double v12, v2

    const/16 v14, 0x12c

    const/16 v16, 0x0

    move-object/from16 v15, p0

    invoke-direct/range {v4 .. v16}, Lco/vine/android/animation/MoveResizeAnimator;-><init>(ILandroid/view/View;Landroid/view/View;IIDDILco/vine/android/animation/SmoothAnimator$AnimationListener;Ljava/lang/Object;)V

    invoke-virtual {v4}, Lco/vine/android/animation/MoveResizeAnimator;->start()V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    goto/16 :goto_1

    .line 1135
    .end local v17    # "as":Landroid/view/animation/AnimationSet;
    .end local v18    # "draftProgressDimen":I
    .end local v21    # "goToCamera":Z
    .end local v24    # "progressDimen":I
    .end local v25    # "r":Landroid/content/res/Resources;
    .end local v28    # "topMaskHeight":I
    :catch_1
    move-exception v20

    .line 1136
    .local v20, "e":Ljava/lang/Exception;
    const-string v2, "Error showing reloading drafts."

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/Object;

    move-object/from16 v0, v20

    invoke-static {v0, v2, v4}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V

    goto/16 :goto_2
.end method

.method public showUnSavedChangesDialog(ILco/vine/android/RecordingFragment;)V
    .locals 2
    .param p1, "dialogId"    # I
    .param p2, "fragment"    # Lco/vine/android/RecordingFragment;

    .prologue
    .line 774
    invoke-static {p1}, Lco/vine/android/widgets/PromptDialogFragment;->newInstance(I)Lco/vine/android/widgets/PromptDialogFragment;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mPromptDialog:Lco/vine/android/widgets/PromptDialogFragment;

    .line 775
    iget-object v1, p0, Lco/vine/android/AbstractRecordingActivity;->mPromptDialog:Lco/vine/android/widgets/PromptDialogFragment;

    invoke-virtual {p2}, Lco/vine/android/RecordingFragment;->isSavedSession()Z

    move-result v0

    if-eqz v0, :cond_0

    const v0, 0x7f0e01b8

    :goto_0
    invoke-virtual {v1, v0}, Lco/vine/android/widgets/PromptDialogFragment;->setMessage(I)Lco/vine/android/widgets/PromptDialogFragment;

    .line 777
    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mPromptDialog:Lco/vine/android/widgets/PromptDialogFragment;

    const v1, 0x7f0e01b5

    invoke-virtual {v0, v1}, Lco/vine/android/widgets/PromptDialogFragment;->setPositiveButton(I)Lco/vine/android/widgets/PromptDialogFragment;

    .line 778
    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mPromptDialog:Lco/vine/android/widgets/PromptDialogFragment;

    const v1, 0x7f0e00bb

    invoke-virtual {v0, v1}, Lco/vine/android/widgets/PromptDialogFragment;->setNegativeButton(I)Lco/vine/android/widgets/PromptDialogFragment;

    .line 780
    :try_start_0
    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mPromptDialog:Lco/vine/android/widgets/PromptDialogFragment;

    invoke-virtual {p0}, Lco/vine/android/AbstractRecordingActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v1

    invoke-virtual {v0, v1}, Lco/vine/android/widgets/PromptDialogFragment;->show(Landroid/app/FragmentManager;)V
    :try_end_0
    .catch Ljava/lang/IllegalStateException; {:try_start_0 .. :try_end_0} :catch_0

    .line 784
    :goto_1
    return-void

    .line 775
    :cond_0
    const v0, 0x7f0e01b7

    goto :goto_0

    .line 781
    :catch_0
    move-exception v0

    goto :goto_1
.end method

.method public startConversationOnFinish()Z
    .locals 1

    .prologue
    .line 307
    iget-boolean v0, p0, Lco/vine/android/AbstractRecordingActivity;->mStartConversation:Z

    return v0
.end method

.method public startRelativeTime()Z
    .locals 1

    .prologue
    .line 1471
    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mCurrentFragment:Landroid/support/v4/app/Fragment;

    instance-of v0, v0, Lco/vine/android/RecordingFragment;

    if-eqz v0, :cond_0

    .line 1472
    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mCurrentFragment:Landroid/support/v4/app/Fragment;

    check-cast v0, Lco/vine/android/RecordingFragment;

    invoke-virtual {v0}, Lco/vine/android/RecordingFragment;->startRelativeTime()Z

    move-result v0

    .line 1474
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public swapFolder(Ljava/lang/String;Ljava/io/File;)V
    .locals 2
    .param p1, "tag"    # Ljava/lang/String;
    .param p2, "folder"    # Ljava/io/File;

    .prologue
    .line 1178
    iget-object v1, p0, Lco/vine/android/AbstractRecordingActivity;->mCurrentFragment:Landroid/support/v4/app/Fragment;

    instance-of v1, v1, Lco/vine/android/RecordingFragment;

    if-eqz v1, :cond_0

    .line 1179
    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mCurrentFragment:Landroid/support/v4/app/Fragment;

    check-cast v0, Lco/vine/android/RecordingFragment;

    .line 1180
    .local v0, "rf":Lco/vine/android/RecordingFragment;
    invoke-virtual {v0}, Lco/vine/android/RecordingFragment;->isResuming()Z

    move-result v1

    if-nez v1, :cond_0

    .line 1181
    invoke-virtual {v0, p1, p2}, Lco/vine/android/RecordingFragment;->swapFolder(Ljava/lang/String;Ljava/io/File;)V

    .line 1184
    .end local v0    # "rf":Lco/vine/android/RecordingFragment;
    :cond_0
    return-void
.end method

.method public toPreview(Ljava/lang/String;Lco/vine/android/recorder/RecordingFile;Ljava/lang/String;Lco/vine/android/util/MediaUtil$GenerateThumbnailsRunnable;)V
    .locals 11
    .param p1, "source"    # Ljava/lang/String;
    .param p2, "finalFile"    # Lco/vine/android/recorder/RecordingFile;
    .param p3, "thumbNailPath"    # Ljava/lang/String;
    .param p4, "grabThumbnailRunnable"    # Lco/vine/android/util/MediaUtil$GenerateThumbnailsRunnable;

    .prologue
    .line 1187
    const-string v0, "From {} to preview fragment: {} {}"

    const/4 v1, 0x3

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    aput-object p1, v1, v2

    const/4 v2, 0x1

    aput-object p2, v1, v2

    const/4 v2, 0x2

    aput-object p3, v1, v2

    invoke-static {v0, v1}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 1188
    invoke-virtual {p0}, Lco/vine/android/AbstractRecordingActivity;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v0

    iget v1, p0, Lco/vine/android/AbstractRecordingActivity;->mRegularUiMode:I

    invoke-virtual {v0, v1}, Landroid/view/View;->setSystemUiVisibility(I)V

    .line 1190
    :try_start_0
    iget-object v0, p2, Lco/vine/android/recorder/RecordingFile;->folder:Ljava/io/File;

    invoke-virtual {v0}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v10

    .line 1191
    .local v10, "reference":Ljava/lang/String;
    invoke-static {p0, v10}, Lco/vine/android/util/UploadManager;->getReferenceCursor(Landroid/content/Context;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v7

    .line 1192
    .local v7, "cursor":Landroid/database/Cursor;
    if-eqz v7, :cond_0

    invoke-interface {v7}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1193
    const-string v0, "User have edited the vine already, discard until new one comes in."

    invoke-static {v0}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;)V

    .line 1194
    const/4 v0, 0x1

    invoke-interface {v7, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-static {p0, v0}, Lco/vine/android/service/VineUploadService;->getDiscardIntent(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {p0, v0}, Lco/vine/android/AbstractRecordingActivity;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;

    .line 1197
    :cond_0
    if-eqz v7, :cond_1

    .line 1198
    invoke-interface {v7}, Landroid/database/Cursor;->close()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 1203
    .end local v7    # "cursor":Landroid/database/Cursor;
    .end local v10    # "reference":Ljava/lang/String;
    :cond_1
    :goto_0
    invoke-static {}, Lco/vine/android/util/BuildUtil;->isIsHwEncodingEnabled()Z

    move-result v0

    if-eqz v0, :cond_5

    .line 1204
    new-instance v0, Lco/vine/android/AbstractRecordingActivity$10;

    invoke-direct {v0, p0, p4, p2, p3}, Lco/vine/android/AbstractRecordingActivity$10;-><init>(Lco/vine/android/AbstractRecordingActivity;Lco/vine/android/util/MediaUtil$GenerateThumbnailsRunnable;Lco/vine/android/recorder/RecordingFile;Ljava/lang/String;)V

    iput-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mAddToUploadThread:Ljava/lang/Thread;

    .line 1222
    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mAddToUploadThread:Ljava/lang/Thread;

    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 1234
    :cond_2
    :goto_1
    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mCurrentFragment:Landroid/support/v4/app/Fragment;

    instance-of v0, v0, Lco/vine/android/RecordingFragment;

    if-eqz v0, :cond_3

    .line 1235
    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mCurrentFragment:Landroid/support/v4/app/Fragment;

    invoke-virtual {v0}, Landroid/support/v4/app/Fragment;->onPause()V

    .line 1239
    :cond_3
    invoke-static {}, Lco/vine/android/util/BuildUtil;->isIsHwEncodingEnabled()Z

    move-result v0

    if-eqz v0, :cond_6

    .line 1240
    invoke-virtual {p0, p2, p3}, Lco/vine/android/AbstractRecordingActivity;->createRecordingPreviewFragmentHw(Lco/vine/android/recorder/RecordingFile;Ljava/lang/String;)Lco/vine/android/RecordingPreviewFragment;

    move-result-object v9

    .line 1245
    .local v9, "fragment":Lco/vine/android/RecordingPreviewFragment;
    :goto_2
    invoke-virtual {v9, p2}, Lco/vine/android/RecordingPreviewFragment;->setFinalFile(Lco/vine/android/recorder/RecordingFile;)V

    .line 1246
    const/4 v0, 0x1

    iput v0, p0, Lco/vine/android/AbstractRecordingActivity;->mStep:I

    .line 1247
    const/4 v0, 0x1

    iput-boolean v0, p0, Lco/vine/android/AbstractRecordingActivity;->mHasPreviewedAlready:Z

    .line 1248
    invoke-virtual {p0}, Lco/vine/android/AbstractRecordingActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    const v1, 0x7f0a0102

    invoke-virtual {v0, v1, v9}, Landroid/support/v4/app/FragmentTransaction;->replace(ILandroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentTransaction;->commit()I

    .line 1252
    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mCurrentFragment:Landroid/support/v4/app/Fragment;

    instance-of v0, v0, Lco/vine/android/RecordingFragment;

    if-eqz v0, :cond_4

    .line 1253
    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mCurrentFragment:Landroid/support/v4/app/Fragment;

    check-cast v0, Lco/vine/android/RecordingFragment;

    invoke-virtual {v0}, Lco/vine/android/RecordingFragment;->release()V

    .line 1255
    :cond_4
    iput-object v9, p0, Lco/vine/android/AbstractRecordingActivity;->mCurrentFragment:Landroid/support/v4/app/Fragment;

    .line 1256
    return-void

    .line 1200
    .end local v9    # "fragment":Lco/vine/android/RecordingPreviewFragment;
    :catch_0
    move-exception v8

    .line 1201
    .local v8, "e":Ljava/lang/Exception;
    const-string v0, "Failed to delete previous vines."

    invoke-static {v0}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;)V

    goto :goto_0

    .line 1224
    .end local v8    # "e":Ljava/lang/Exception;
    :cond_5
    invoke-static {p0}, Lco/vine/android/client/AppController;->getInstance(Landroid/content/Context;)Lco/vine/android/client/AppController;

    move-result-object v0

    invoke-virtual {v0}, Lco/vine/android/client/AppController;->isLoggedIn()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 1226
    :try_start_1
    iget-object v0, p2, Lco/vine/android/recorder/RecordingFile;->folder:Ljava/io/File;

    invoke-virtual {v0}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v3

    iget-boolean v4, p0, Lco/vine/android/AbstractRecordingActivity;->mIsMessaging:Z

    iget-wide v5, p0, Lco/vine/android/AbstractRecordingActivity;->mConversationRowId:J

    move-object v0, p0

    move-object v1, p2

    move-object v2, p3

    invoke-static/range {v0 .. v6}, Lco/vine/android/util/UploadManager;->addToUploadQueue(Landroid/content/Context;Lco/vine/android/recorder/RecordingFile;Ljava/lang/String;Ljava/lang/String;ZJ)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mUploadFile:Ljava/lang/String;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    goto :goto_1

    .line 1229
    :catch_1
    move-exception v8

    .line 1230
    .restart local v8    # "e":Ljava/lang/Exception;
    new-instance v0, Ljava/lang/RuntimeException;

    invoke-direct {v0, v8}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v0

    .line 1242
    .end local v8    # "e":Ljava/lang/Exception;
    :cond_6
    invoke-virtual {p0, p2, p3}, Lco/vine/android/AbstractRecordingActivity;->createRecordingPreviewFragmentSw(Lco/vine/android/recorder/RecordingFile;Ljava/lang/String;)Lco/vine/android/RecordingPreviewFragment;

    move-result-object v9

    .restart local v9    # "fragment":Lco/vine/android/RecordingPreviewFragment;
    goto :goto_2
.end method

.method public toRecord(ZZLco/vine/android/recorder/RecordingFile;)V
    .locals 10
    .param p1, "isNew"    # Z
    .param p2, "startWithEdit"    # Z
    .param p3, "fileToUse"    # Lco/vine/android/recorder/RecordingFile;

    .prologue
    const v9, 0x7f0a0102

    const/4 v4, 0x1

    const/4 v5, 0x0

    .line 1141
    iput v5, p0, Lco/vine/android/AbstractRecordingActivity;->mStep:I

    .line 1142
    iput-boolean v5, p0, Lco/vine/android/AbstractRecordingActivity;->mFirstPageSet:Z

    .line 1143
    const/4 v6, -0x1

    invoke-virtual {p0, v6}, Lco/vine/android/AbstractRecordingActivity;->onPageSelected(I)V

    .line 1144
    if-eqz p3, :cond_2

    move v2, v4

    .line 1145
    .local v2, "fromPreview":Z
    :goto_0
    const-string v6, "To recording fragment: {} {} {}"

    const/4 v7, 0x3

    new-array v7, v7, [Ljava/lang/Object;

    invoke-static {p1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v8

    aput-object v8, v7, v5

    invoke-static {p2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v8

    aput-object v8, v7, v4

    const/4 v8, 0x2

    if-eqz p3, :cond_0

    move v5, v4

    :cond_0
    invoke-static {v5}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v5

    aput-object v5, v7, v8

    invoke-static {v6, v7}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 1146
    if-eqz v2, :cond_1

    .line 1147
    invoke-virtual {p0}, Lco/vine/android/AbstractRecordingActivity;->discardUpload()V

    .line 1149
    :cond_1
    invoke-virtual {p0}, Lco/vine/android/AbstractRecordingActivity;->createRecordingFragment()Lco/vine/android/RecordingFragment;

    move-result-object v1

    .line 1150
    .local v1, "fragment":Lco/vine/android/RecordingFragment;
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 1151
    .local v0, "args":Landroid/os/Bundle;
    const-string v5, "arg_top_overlay"

    iget-object v6, p0, Lco/vine/android/AbstractRecordingActivity;->mTopOverlay:Landroid/graphics/Bitmap;

    invoke-virtual {v0, v5, v6}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 1152
    const-string v5, "screen_size"

    iget-object v6, p0, Lco/vine/android/AbstractRecordingActivity;->mScreenSize:Landroid/graphics/Point;

    invoke-virtual {v0, v5, v6}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 1153
    const-string v5, "is_messaging"

    iget-boolean v6, p0, Lco/vine/android/AbstractRecordingActivity;->mIsMessaging:Z

    invoke-virtual {v0, v5, v6}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 1154
    const-string v5, "is_vm_onboarding"

    iget-boolean v6, p0, Lco/vine/android/AbstractRecordingActivity;->mIsVmOnboarding:Z

    invoke-virtual {v0, v5, v6}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 1155
    const-string v5, "recipient_username"

    iget-object v6, p0, Lco/vine/android/AbstractRecordingActivity;->mRecipientUsername:Ljava/lang/String;

    invoke-virtual {v0, v5, v6}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1158
    invoke-static {p0}, Lco/vine/android/util/Util;->getDefaultSharedPrefs(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v5

    const-string v6, "profile_background"

    sget v7, Lco/vine/android/Settings;->DEFAULT_PROFILE_COLOR:I

    invoke-interface {v5, v6, v7}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v5

    iput v5, p0, Lco/vine/android/AbstractRecordingActivity;->mColor:I

    .line 1161
    const-string v5, "color"

    iget v6, p0, Lco/vine/android/AbstractRecordingActivity;->mColor:I

    invoke-virtual {v0, v5, v6}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 1162
    invoke-virtual {v1, v0}, Lco/vine/android/RecordingFragment;->setArguments(Landroid/os/Bundle;)V

    .line 1163
    invoke-virtual {v1, p3}, Lco/vine/android/RecordingFragment;->setFileFileToUse(Lco/vine/android/recorder/RecordingFile;)V

    .line 1164
    invoke-virtual {v1, p2}, Lco/vine/android/RecordingFragment;->setStartWithEdit(Z)V

    .line 1165
    invoke-virtual {p0}, Lco/vine/android/AbstractRecordingActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v5

    invoke-virtual {v5}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v3

    .line 1166
    .local v3, "ft":Landroid/support/v4/app/FragmentTransaction;
    if-eqz p1, :cond_3

    .line 1167
    invoke-virtual {v3, v9, v1}, Landroid/support/v4/app/FragmentTransaction;->add(ILandroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;

    .line 1171
    :goto_1
    invoke-virtual {v3}, Landroid/support/v4/app/FragmentTransaction;->commit()I

    .line 1172
    iput-object v1, p0, Lco/vine/android/AbstractRecordingActivity;->mCurrentFragment:Landroid/support/v4/app/Fragment;

    .line 1173
    invoke-virtual {p0}, Lco/vine/android/AbstractRecordingActivity;->getWindow()Landroid/view/Window;

    move-result-object v5

    invoke-virtual {v5}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v5

    invoke-virtual {v5}, Landroid/view/View;->getSystemUiVisibility()I

    move-result v5

    iput v5, p0, Lco/vine/android/AbstractRecordingActivity;->mRegularUiMode:I

    .line 1174
    invoke-virtual {p0}, Lco/vine/android/AbstractRecordingActivity;->getWindow()Landroid/view/Window;

    move-result-object v5

    invoke-virtual {v5}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v5

    invoke-virtual {v5, v4}, Landroid/view/View;->setSystemUiVisibility(I)V

    .line 1175
    return-void

    .end local v0    # "args":Landroid/os/Bundle;
    .end local v1    # "fragment":Lco/vine/android/RecordingFragment;
    .end local v2    # "fromPreview":Z
    .end local v3    # "ft":Landroid/support/v4/app/FragmentTransaction;
    :cond_2
    move v2, v5

    .line 1144
    goto/16 :goto_0

    .line 1169
    .restart local v0    # "args":Landroid/os/Bundle;
    .restart local v1    # "fragment":Lco/vine/android/RecordingFragment;
    .restart local v2    # "fromPreview":Z
    .restart local v3    # "ft":Landroid/support/v4/app/FragmentTransaction;
    :cond_3
    invoke-virtual {v3, v9, v1}, Landroid/support/v4/app/FragmentTransaction;->replace(ILandroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;

    goto :goto_1
.end method

.method public viewDestroyFinished()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 521
    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mDraftTrashButton:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setActivated(Z)V

    .line 522
    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity;->mDraftTrashBackground:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setActivated(Z)V

    .line 523
    return-void
.end method

.method public viewDropped(I)Z
    .locals 5
    .param p1, "viewTopY"    # I

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 560
    if-gtz p1, :cond_0

    move v0, v1

    .line 561
    .local v0, "delete":Z
    :goto_0
    if-eqz v0, :cond_1

    iget v3, p0, Lco/vine/android/AbstractRecordingActivity;->mCurrentPage:I

    iget-object v4, p0, Lco/vine/android/AbstractRecordingActivity;->mDraftFragments:Landroid/util/SparseArray;

    invoke-virtual {v4}, Landroid/util/SparseArray;->size()I

    move-result v4

    if-eq v3, v4, :cond_1

    .line 562
    iput-boolean v1, p0, Lco/vine/android/AbstractRecordingActivity;->mDeleteWasDrag:Z

    .line 563
    invoke-virtual {p0}, Lco/vine/android/AbstractRecordingActivity;->showDeleteDialog()V

    .line 567
    :goto_1
    return v0

    .end local v0    # "delete":Z
    :cond_0
    move v0, v2

    .line 560
    goto :goto_0

    .line 565
    .restart local v0    # "delete":Z
    :cond_1
    iget-object v1, p0, Lco/vine/android/AbstractRecordingActivity;->mDraftTrashButton:Landroid/view/View;

    invoke-virtual {v1, v2}, Landroid/view/View;->setActivated(Z)V

    goto :goto_1
.end method

.method public viewLanded()V
    .locals 0

    .prologue
    .line 572
    invoke-direct {p0}, Lco/vine/android/AbstractRecordingActivity;->showCurrentFragment()V

    .line 573
    return-void
.end method

.method public viewMoved(I)Z
    .locals 5
    .param p1, "viewTopY"    # I

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 552
    if-gez p1, :cond_0

    move v0, v1

    .line 553
    .local v0, "lightTrash":Z
    :goto_0
    iget-object v3, p0, Lco/vine/android/AbstractRecordingActivity;->mDraftTrashBackground:Landroid/view/View;

    invoke-virtual {v3, v0}, Landroid/view/View;->setActivated(Z)V

    .line 554
    iget-object v3, p0, Lco/vine/android/AbstractRecordingActivity;->mDraftTrashButton:Landroid/view/View;

    iget-object v4, p0, Lco/vine/android/AbstractRecordingActivity;->mDraftTrashContainer:Landroid/view/View;

    invoke-virtual {v4}, Landroid/view/View;->getHeight()I

    move-result v4

    if-ge p1, v4, :cond_1

    :goto_1
    invoke-virtual {v3, v1}, Landroid/view/View;->setActivated(Z)V

    .line 555
    return v0

    .end local v0    # "lightTrash":Z
    :cond_0
    move v0, v2

    .line 552
    goto :goto_0

    .restart local v0    # "lightTrash":Z
    :cond_1
    move v1, v2

    .line 554
    goto :goto_1
.end method

.method public viewPickedUp()V
    .locals 0

    .prologue
    .line 516
    invoke-direct {p0}, Lco/vine/android/AbstractRecordingActivity;->hideCurrentFragment()V

    .line 517
    return-void
.end method
