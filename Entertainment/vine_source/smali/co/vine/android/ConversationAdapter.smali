.class public Lco/vine/android/ConversationAdapter;
.super Landroid/support/v4/widget/CursorAdapter;
.source "ConversationAdapter.java"

# interfaces
.implements Lco/vine/android/player/SdkVideoTimer$HasVideoPlayerViewController;
.implements Lco/vine/android/player/HasVideoPlayerAdapter;
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/ConversationAdapter$ConversationViewHolder;,
        Lco/vine/android/ConversationAdapter$ConversationVideoClickedListener;,
        Lco/vine/android/ConversationAdapter$VanishPlayButtonListener;,
        Lco/vine/android/ConversationAdapter$BlurRunnable;
    }
.end annotation


# static fields
.field private static final VIEW_TYPE_COUNT:I = 0x2

.field private static final VIEW_TYPE_ME:I = 0x1

.field private static final VIEW_TYPE_YOU:I


# instance fields
.field private final mActivity:Lco/vine/android/ConversationActivity;

.field private final mAppController:Lco/vine/android/client/AppController;

.field private final mAvatarMargin:F

.field private final mAvatars:Landroid/util/SparseArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/util/SparseArray",
            "<",
            "Landroid/graphics/Bitmap;",
            ">;"
        }
    .end annotation
.end field

.field private mBlurHandler:Landroid/os/Handler;

.field private mBlurHandlerThread:Landroid/os/HandlerThread;

.field private final mBlurQueueRunnable:Ljava/lang/Runnable;

.field private mBlurTempBitmap:Landroid/graphics/Bitmap;

.field private final mBoldSpan:Lco/vine/android/widget/TypefacesSpan;

.field private mCurrentBlurBitmap:Landroid/graphics/Bitmap;

.field private mCurrentBlurImageView:Landroid/widget/ImageView;

.field private mCurrentPlaying:I

.field private final mDarkGreySpan:Lco/vine/android/widget/ColoredSpan;

.field private final mHandler:Landroid/os/Handler;

.field private final mIdToPositionMap:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/Long;",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field private mLastPlayer:Lco/vine/android/player/SdkVideoView;

.field private final mListView:Landroid/widget/ListView;

.field private final mMessages:Landroid/util/SparseArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/util/SparseArray",
            "<",
            "Lco/vine/android/api/VinePrivateMessage;",
            ">;"
        }
    .end annotation
.end field

.field private mMuted:Z

.field private final mMyColor:I

.field private mMyUserId:J

.field private final mPaths:Landroid/util/SparseArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/util/SparseArray",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private final mPlayCurrentPositionRunnable:Ljava/lang/Runnable;

.field private final mPlayers:Landroid/util/SparseArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/util/SparseArray",
            "<",
            "Lco/vine/android/player/SdkVideoView;",
            ">;"
        }
    .end annotation
.end field

.field private mRsBlur:Lco/vine/android/recorder/RsBlur;

.field private final mScreenWidth:I

.field private final mSeekInfoManager:Lco/vine/android/util/SeekInfoManager;

.field private final mSharedDescSize:F

.field private mShouldBePlaying:I

.field private final mSidePadding:F

.field private mSingleLoopPosition:I

.field private final mSpanClicker:Lco/vine/android/VineSpanClicker;

.field private final mThumbnails:Landroid/util/SparseArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/util/SparseArray",
            "<",
            "Landroid/graphics/Bitmap;",
            ">;"
        }
    .end annotation
.end field

.field private final mUrlReverse:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Lco/vine/android/util/video/VideoKey;",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field private final mVanishedIdDateMap:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/Long;",
            "Ljava/lang/Long;",
            ">;"
        }
    .end annotation
.end field

.field private mVideoAttr:Landroid/util/AttributeSet;

.field private final mViewHolders:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/ref/WeakReference",
            "<",
            "Lco/vine/android/ConversationAdapter$ConversationViewHolder;",
            ">;>;"
        }
    .end annotation
.end field

.field private final mViewedPorterDuffFilterSet:Landroid/util/SparseArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/util/SparseArray",
            "<",
            "Landroid/graphics/PorterDuffColorFilter;",
            ">;"
        }
    .end annotation
.end field

.field private final mVineDateFormatter:Lco/vine/android/util/VineDateFormatter;

.field private final mWaitingBg:Landroid/graphics/drawable/ColorDrawable;


# direct methods
.method public constructor <init>(Lco/vine/android/ConversationActivity;Lco/vine/android/client/AppController;Landroid/widget/ListView;JI)V
    .locals 7
    .param p1, "activity"    # Lco/vine/android/ConversationActivity;
    .param p2, "appController"    # Lco/vine/android/client/AppController;
    .param p3, "listView"    # Landroid/widget/ListView;
    .param p4, "myUserId"    # J
    .param p6, "flags"    # I

    .prologue
    const/4 v6, 0x0

    const/high16 v3, -0x80000000

    .line 130
    invoke-direct {p0, p1, v6, p6}, Landroid/support/v4/widget/CursorAdapter;-><init>(Landroid/content/Context;Landroid/database/Cursor;I)V

    .line 92
    new-instance v2, Landroid/os/Handler;

    invoke-direct {v2}, Landroid/os/Handler;-><init>()V

    iput-object v2, p0, Lco/vine/android/ConversationAdapter;->mHandler:Landroid/os/Handler;

    .line 93
    new-instance v2, Landroid/util/SparseArray;

    invoke-direct {v2}, Landroid/util/SparseArray;-><init>()V

    iput-object v2, p0, Lco/vine/android/ConversationAdapter;->mPaths:Landroid/util/SparseArray;

    .line 94
    new-instance v2, Ljava/util/HashMap;

    invoke-direct {v2}, Ljava/util/HashMap;-><init>()V

    iput-object v2, p0, Lco/vine/android/ConversationAdapter;->mUrlReverse:Ljava/util/HashMap;

    .line 95
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    iput-object v2, p0, Lco/vine/android/ConversationAdapter;->mViewHolders:Ljava/util/ArrayList;

    .line 96
    new-instance v2, Landroid/util/SparseArray;

    invoke-direct {v2}, Landroid/util/SparseArray;-><init>()V

    iput-object v2, p0, Lco/vine/android/ConversationAdapter;->mMessages:Landroid/util/SparseArray;

    .line 97
    new-instance v2, Landroid/util/SparseArray;

    invoke-direct {v2}, Landroid/util/SparseArray;-><init>()V

    iput-object v2, p0, Lco/vine/android/ConversationAdapter;->mThumbnails:Landroid/util/SparseArray;

    .line 98
    new-instance v2, Landroid/util/SparseArray;

    invoke-direct {v2}, Landroid/util/SparseArray;-><init>()V

    iput-object v2, p0, Lco/vine/android/ConversationAdapter;->mAvatars:Landroid/util/SparseArray;

    .line 99
    new-instance v2, Landroid/util/SparseArray;

    invoke-direct {v2}, Landroid/util/SparseArray;-><init>()V

    iput-object v2, p0, Lco/vine/android/ConversationAdapter;->mPlayers:Landroid/util/SparseArray;

    .line 100
    new-instance v2, Ljava/util/HashMap;

    invoke-direct {v2}, Ljava/util/HashMap;-><init>()V

    iput-object v2, p0, Lco/vine/android/ConversationAdapter;->mVanishedIdDateMap:Ljava/util/HashMap;

    .line 101
    new-instance v2, Ljava/util/HashMap;

    invoke-direct {v2}, Ljava/util/HashMap;-><init>()V

    iput-object v2, p0, Lco/vine/android/ConversationAdapter;->mIdToPositionMap:Ljava/util/HashMap;

    .line 102
    new-instance v2, Landroid/util/SparseArray;

    invoke-direct {v2}, Landroid/util/SparseArray;-><init>()V

    iput-object v2, p0, Lco/vine/android/ConversationAdapter;->mViewedPorterDuffFilterSet:Landroid/util/SparseArray;

    .line 117
    iput v3, p0, Lco/vine/android/ConversationAdapter;->mCurrentPlaying:I

    .line 118
    iput v3, p0, Lco/vine/android/ConversationAdapter;->mShouldBePlaying:I

    .line 121
    new-instance v2, Landroid/graphics/drawable/ColorDrawable;

    const/4 v3, -0x1

    invoke-direct {v2, v3}, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V

    iput-object v2, p0, Lco/vine/android/ConversationAdapter;->mWaitingBg:Landroid/graphics/drawable/ColorDrawable;

    .line 857
    new-instance v2, Lco/vine/android/ConversationAdapter$2;

    invoke-direct {v2, p0}, Lco/vine/android/ConversationAdapter$2;-><init>(Lco/vine/android/ConversationAdapter;)V

    iput-object v2, p0, Lco/vine/android/ConversationAdapter;->mPlayCurrentPositionRunnable:Ljava/lang/Runnable;

    .line 1240
    new-instance v2, Lco/vine/android/ConversationAdapter$6;

    invoke-direct {v2, p0}, Lco/vine/android/ConversationAdapter$6;-><init>(Lco/vine/android/ConversationAdapter;)V

    iput-object v2, p0, Lco/vine/android/ConversationAdapter;->mBlurQueueRunnable:Ljava/lang/Runnable;

    .line 131
    iput-wide p4, p0, Lco/vine/android/ConversationAdapter;->mMyUserId:J

    .line 132
    iput-object p1, p0, Lco/vine/android/ConversationAdapter;->mActivity:Lco/vine/android/ConversationActivity;

    .line 133
    new-instance v2, Lco/vine/android/VineSpanClicker;

    invoke-direct {v2, p1}, Lco/vine/android/VineSpanClicker;-><init>(Landroid/support/v4/app/FragmentActivity;)V

    iput-object v2, p0, Lco/vine/android/ConversationAdapter;->mSpanClicker:Lco/vine/android/VineSpanClicker;

    .line 134
    iget-object v2, p0, Lco/vine/android/ConversationAdapter;->mSpanClicker:Lco/vine/android/VineSpanClicker;

    const-string v3, "ConversationAdapter"

    invoke-virtual {v2, v3}, Lco/vine/android/VineSpanClicker;->setFlurryEventSource(Ljava/lang/String;)V

    .line 135
    iput-object p2, p0, Lco/vine/android/ConversationAdapter;->mAppController:Lco/vine/android/client/AppController;

    .line 136
    new-instance v2, Lco/vine/android/util/SeekInfoManager;

    iget-object v3, p0, Lco/vine/android/ConversationAdapter;->mAppController:Lco/vine/android/client/AppController;

    invoke-direct {v2, v3}, Lco/vine/android/util/SeekInfoManager;-><init>(Lco/vine/android/client/AppController;)V

    iput-object v2, p0, Lco/vine/android/ConversationAdapter;->mSeekInfoManager:Lco/vine/android/util/SeekInfoManager;

    .line 137
    iput-object p3, p0, Lco/vine/android/ConversationAdapter;->mListView:Landroid/widget/ListView;

    .line 138
    invoke-static {p1}, Lco/vine/android/util/SystemUtil;->getDisplaySize(Landroid/app/Activity;)Landroid/graphics/Point;

    move-result-object v2

    iget v2, v2, Landroid/graphics/Point;->x:I

    iput v2, p0, Lco/vine/android/ConversationAdapter;->mScreenWidth:I

    .line 139
    invoke-static {p1}, Landroid/preference/PreferenceManager;->getDefaultSharedPreferences(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 140
    .local v0, "prefs":Landroid/content/SharedPreferences;
    const-string v2, "profile_background"

    sget v3, Lco/vine/android/Settings;->DEFAULT_PROFILE_COLOR:I

    invoke-interface {v0, v2, v3}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v2

    iput v2, p0, Lco/vine/android/ConversationAdapter;->mMyColor:I

    .line 142
    invoke-virtual {p1}, Lco/vine/android/ConversationActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    .line 144
    .local v1, "res":Landroid/content/res/Resources;
    const v2, 0x7f0b0045

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDimension(I)F

    move-result v2

    iput v2, p0, Lco/vine/android/ConversationAdapter;->mSharedDescSize:F

    .line 146
    const v2, 0x7f0b0026

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDimension(I)F

    move-result v2

    iput v2, p0, Lco/vine/android/ConversationAdapter;->mSidePadding:F

    .line 148
    const v2, 0x7f0b0021

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDimension(I)F

    move-result v2

    const v3, 0x7f0b007c

    invoke-virtual {v1, v3}, Landroid/content/res/Resources;->getDimension(I)F

    move-result v3

    add-float/2addr v2, v3

    iput v2, p0, Lco/vine/android/ConversationAdapter;->mAvatarMargin:F

    .line 150
    new-instance v2, Lco/vine/android/widget/TypefacesSpan;

    iget-object v3, p0, Lco/vine/android/ConversationAdapter;->mContext:Landroid/content/Context;

    invoke-static {v3}, Lco/vine/android/widget/Typefaces;->get(Landroid/content/Context;)Lco/vine/android/widget/Typefaces;

    move-result-object v3

    const/4 v4, 0x1

    const/4 v5, 0x3

    invoke-virtual {v3, v4, v5}, Lco/vine/android/widget/Typefaces;->getContentTypeface(II)Landroid/graphics/Typeface;

    move-result-object v3

    invoke-direct {v2, v6, v3}, Lco/vine/android/widget/TypefacesSpan;-><init>(Ljava/lang/String;Landroid/graphics/Typeface;)V

    iput-object v2, p0, Lco/vine/android/ConversationAdapter;->mBoldSpan:Lco/vine/android/widget/TypefacesSpan;

    .line 153
    new-instance v2, Lco/vine/android/widget/ColoredSpan;

    const v3, 0x7f09007b

    invoke-virtual {v1, v3}, Landroid/content/res/Resources;->getColor(I)I

    move-result v3

    invoke-direct {v2, v3}, Lco/vine/android/widget/ColoredSpan;-><init>(I)V

    iput-object v2, p0, Lco/vine/android/ConversationAdapter;->mDarkGreySpan:Lco/vine/android/widget/ColoredSpan;

    .line 155
    new-instance v2, Lco/vine/android/util/VineDateFormatter;

    invoke-direct {v2, v1}, Lco/vine/android/util/VineDateFormatter;-><init>(Landroid/content/res/Resources;)V

    iput-object v2, p0, Lco/vine/android/ConversationAdapter;->mVineDateFormatter:Lco/vine/android/util/VineDateFormatter;

    .line 156
    iget-object v2, p0, Lco/vine/android/ConversationAdapter;->mVineDateFormatter:Lco/vine/android/util/VineDateFormatter;

    invoke-virtual {v2}, Lco/vine/android/util/VineDateFormatter;->refreshDates()V

    .line 157
    iget-object v2, p0, Lco/vine/android/ConversationAdapter;->mVineDateFormatter:Lco/vine/android/util/VineDateFormatter;

    iget-object v3, p0, Lco/vine/android/ConversationAdapter;->mBoldSpan:Lco/vine/android/widget/TypefacesSpan;

    invoke-virtual {v2, v3}, Lco/vine/android/util/VineDateFormatter;->addSpanForDateSection(Landroid/text/style/TypefaceSpan;)V

    .line 158
    return-void
.end method

.method static synthetic access$000(Lco/vine/android/ConversationAdapter;)Lco/vine/android/ConversationActivity;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/ConversationAdapter;

    .prologue
    .line 81
    iget-object v0, p0, Lco/vine/android/ConversationAdapter;->mActivity:Lco/vine/android/ConversationActivity;

    return-object v0
.end method

.method static synthetic access$100(Lco/vine/android/ConversationAdapter;)Landroid/widget/ListView;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/ConversationAdapter;

    .prologue
    .line 81
    iget-object v0, p0, Lco/vine/android/ConversationAdapter;->mListView:Landroid/widget/ListView;

    return-object v0
.end method

.method static synthetic access$1000(Lco/vine/android/ConversationAdapter;)Landroid/graphics/Bitmap;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/ConversationAdapter;

    .prologue
    .line 81
    iget-object v0, p0, Lco/vine/android/ConversationAdapter;->mCurrentBlurBitmap:Landroid/graphics/Bitmap;

    return-object v0
.end method

.method static synthetic access$1100(Lco/vine/android/ConversationAdapter;)Landroid/content/Context;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/ConversationAdapter;

    .prologue
    .line 81
    iget-object v0, p0, Lco/vine/android/ConversationAdapter;->mContext:Landroid/content/Context;

    return-object v0
.end method

.method static synthetic access$1200(Lco/vine/android/ConversationAdapter;)Landroid/content/Context;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/ConversationAdapter;

    .prologue
    .line 81
    iget-object v0, p0, Lco/vine/android/ConversationAdapter;->mContext:Landroid/content/Context;

    return-object v0
.end method

.method static synthetic access$1300(Lco/vine/android/ConversationAdapter;)Landroid/graphics/Bitmap;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/ConversationAdapter;

    .prologue
    .line 81
    iget-object v0, p0, Lco/vine/android/ConversationAdapter;->mBlurTempBitmap:Landroid/graphics/Bitmap;

    return-object v0
.end method

.method static synthetic access$1302(Lco/vine/android/ConversationAdapter;Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    .locals 0
    .param p0, "x0"    # Lco/vine/android/ConversationAdapter;
    .param p1, "x1"    # Landroid/graphics/Bitmap;

    .prologue
    .line 81
    iput-object p1, p0, Lco/vine/android/ConversationAdapter;->mBlurTempBitmap:Landroid/graphics/Bitmap;

    return-object p1
.end method

.method static synthetic access$1400(Lco/vine/android/ConversationAdapter;)Lco/vine/android/recorder/RsBlur;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/ConversationAdapter;

    .prologue
    .line 81
    iget-object v0, p0, Lco/vine/android/ConversationAdapter;->mRsBlur:Lco/vine/android/recorder/RsBlur;

    return-object v0
.end method

.method static synthetic access$1402(Lco/vine/android/ConversationAdapter;Lco/vine/android/recorder/RsBlur;)Lco/vine/android/recorder/RsBlur;
    .locals 0
    .param p0, "x0"    # Lco/vine/android/ConversationAdapter;
    .param p1, "x1"    # Lco/vine/android/recorder/RsBlur;

    .prologue
    .line 81
    iput-object p1, p0, Lco/vine/android/ConversationAdapter;->mRsBlur:Lco/vine/android/recorder/RsBlur;

    return-object p1
.end method

.method static synthetic access$1500(Lco/vine/android/ConversationAdapter;)Landroid/os/Handler;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/ConversationAdapter;

    .prologue
    .line 81
    iget-object v0, p0, Lco/vine/android/ConversationAdapter;->mHandler:Landroid/os/Handler;

    return-object v0
.end method

.method static synthetic access$200(Lco/vine/android/ConversationAdapter;)Landroid/util/SparseArray;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/ConversationAdapter;

    .prologue
    .line 81
    iget-object v0, p0, Lco/vine/android/ConversationAdapter;->mMessages:Landroid/util/SparseArray;

    return-object v0
.end method

.method static synthetic access$300(Lco/vine/android/ConversationAdapter;I)Landroid/view/View;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/ConversationAdapter;
    .param p1, "x1"    # I

    .prologue
    .line 81
    invoke-direct {p0, p1}, Lco/vine/android/ConversationAdapter;->getViewAt(I)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$400(Lco/vine/android/ConversationAdapter;)I
    .locals 1
    .param p0, "x0"    # Lco/vine/android/ConversationAdapter;

    .prologue
    .line 81
    iget v0, p0, Lco/vine/android/ConversationAdapter;->mCurrentPlaying:I

    return v0
.end method

.method static synthetic access$500(Lco/vine/android/ConversationAdapter;Lco/vine/android/player/VideoViewInterface;I)Lco/vine/android/util/SeekInfoManager$SeekInfo;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/ConversationAdapter;
    .param p1, "x1"    # Lco/vine/android/player/VideoViewInterface;
    .param p2, "x2"    # I

    .prologue
    .line 81
    invoke-direct {p0, p1, p2}, Lco/vine/android/ConversationAdapter;->getSeekInfoMarkAsRead(Lco/vine/android/player/VideoViewInterface;I)Lco/vine/android/util/SeekInfoManager$SeekInfo;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$600(Lco/vine/android/ConversationAdapter;Lco/vine/android/player/VideoViewInterface;I)Z
    .locals 1
    .param p0, "x0"    # Lco/vine/android/ConversationAdapter;
    .param p1, "x1"    # Lco/vine/android/player/VideoViewInterface;
    .param p2, "x2"    # I

    .prologue
    .line 81
    invoke-direct {p0, p1, p2}, Lco/vine/android/ConversationAdapter;->onLoopFinished(Lco/vine/android/player/VideoViewInterface;I)Z

    move-result v0

    return v0
.end method

.method static synthetic access$700(Lco/vine/android/ConversationAdapter;Lco/vine/android/player/SdkVideoView;)V
    .locals 0
    .param p0, "x0"    # Lco/vine/android/ConversationAdapter;
    .param p1, "x1"    # Lco/vine/android/player/SdkVideoView;

    .prologue
    .line 81
    invoke-direct {p0, p1}, Lco/vine/android/ConversationAdapter;->releaseOtherPlayers(Lco/vine/android/player/SdkVideoView;)V

    return-void
.end method

.method static synthetic access$800(Lco/vine/android/ConversationAdapter;)I
    .locals 1
    .param p0, "x0"    # Lco/vine/android/ConversationAdapter;

    .prologue
    .line 81
    iget v0, p0, Lco/vine/android/ConversationAdapter;->mSingleLoopPosition:I

    return v0
.end method

.method static synthetic access$802(Lco/vine/android/ConversationAdapter;I)I
    .locals 0
    .param p0, "x0"    # Lco/vine/android/ConversationAdapter;
    .param p1, "x1"    # I

    .prologue
    .line 81
    iput p1, p0, Lco/vine/android/ConversationAdapter;->mSingleLoopPosition:I

    return p1
.end method

.method static synthetic access$900(Lco/vine/android/ConversationAdapter;)Landroid/widget/ImageView;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/ConversationAdapter;

    .prologue
    .line 81
    iget-object v0, p0, Lco/vine/android/ConversationAdapter;->mCurrentBlurImageView:Landroid/widget/ImageView;

    return-object v0
.end method

.method private getSeekInfo(I)Lco/vine/android/util/SeekInfoManager$SeekInfo;
    .locals 3
    .param p1, "position"    # I

    .prologue
    const/4 v1, 0x0

    .line 995
    iget-object v2, p0, Lco/vine/android/ConversationAdapter;->mMessages:Landroid/util/SparseArray;

    invoke-virtual {v2, p1}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/api/VinePrivateMessage;

    .line 996
    .local v0, "message":Lco/vine/android/api/VinePrivateMessage;
    if-eqz v0, :cond_0

    .line 997
    iget-boolean v2, v0, Lco/vine/android/api/VinePrivateMessage;->ephemeral:Z

    if-nez v2, :cond_1

    .line 998
    sget-object v1, Lco/vine/android/util/SeekInfoManager;->NO_LOOP_LIMIT:Lco/vine/android/util/SeekInfoManager$SeekInfo;

    .line 1003
    :cond_0
    :goto_0
    return-object v1

    .line 1000
    :cond_1
    iget-object v2, p0, Lco/vine/android/ConversationAdapter;->mSeekInfoManager:Lco/vine/android/util/SeekInfoManager;

    invoke-virtual {v2, v1, v0}, Lco/vine/android/util/SeekInfoManager;->getSeekInfo(Lco/vine/android/player/VideoViewInterface;Lco/vine/android/api/VinePrivateMessage;)Lco/vine/android/util/SeekInfoManager$SeekInfo;

    move-result-object v1

    goto :goto_0
.end method

.method private getSeekInfoMarkAsRead(Lco/vine/android/player/VideoViewInterface;I)Lco/vine/android/util/SeekInfoManager$SeekInfo;
    .locals 4
    .param p1, "view"    # Lco/vine/android/player/VideoViewInterface;
    .param p2, "position"    # I

    .prologue
    const/4 v1, 0x0

    .line 1008
    iget-object v2, p0, Lco/vine/android/ConversationAdapter;->mMessages:Landroid/util/SparseArray;

    invoke-virtual {v2, p2}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/api/VinePrivateMessage;

    .line 1009
    .local v0, "message":Lco/vine/android/api/VinePrivateMessage;
    if-eqz v0, :cond_0

    .line 1010
    iget-boolean v2, v0, Lco/vine/android/api/VinePrivateMessage;->ephemeral:Z

    if-nez v2, :cond_1

    .line 1011
    sget-object v1, Lco/vine/android/util/SeekInfoManager;->NO_LOOP_LIMIT:Lco/vine/android/util/SeekInfoManager$SeekInfo;

    .line 1021
    :cond_0
    :goto_0
    return-object v1

    .line 1013
    :cond_1
    iget-object v2, p0, Lco/vine/android/ConversationAdapter;->mSeekInfoManager:Lco/vine/android/util/SeekInfoManager;

    invoke-virtual {v2, v1, v0}, Lco/vine/android/util/SeekInfoManager;->getSeekInfo(Lco/vine/android/player/VideoViewInterface;Lco/vine/android/api/VinePrivateMessage;)Lco/vine/android/util/SeekInfoManager$SeekInfo;

    move-result-object v1

    .line 1014
    .local v1, "seekInfo":Lco/vine/android/util/SeekInfoManager$SeekInfo;
    if-nez v1, :cond_0

    .line 1015
    iget-object v2, p0, Lco/vine/android/ConversationAdapter;->mSeekInfoManager:Lco/vine/android/util/SeekInfoManager;

    invoke-interface {p1}, Lco/vine/android/player/VideoViewInterface;->getDuration()I

    move-result v3

    invoke-virtual {v2, v3, v0}, Lco/vine/android/util/SeekInfoManager;->markAsRead(ILco/vine/android/api/VinePrivateMessage;)Lco/vine/android/util/SeekInfoManager$SeekInfo;

    move-result-object v1

    goto :goto_0
.end method

.method private getViewAt(I)Landroid/view/View;
    .locals 8
    .param p1, "position"    # I

    .prologue
    .line 845
    iget-object v1, p0, Lco/vine/android/ConversationAdapter;->mListView:Landroid/widget/ListView;

    .line 846
    .local v1, "listView":Landroid/widget/ListView;
    const/4 v2, 0x0

    .line 847
    .local v2, "offset":I
    invoke-virtual {v1}, Landroid/widget/ListView;->getFirstVisiblePosition()I

    move-result v4

    invoke-virtual {v1}, Landroid/widget/ListView;->getHeaderViewsCount()I

    move-result v5

    sub-int/2addr v4, v5

    sub-int v0, v4, v2

    .line 848
    .local v0, "firstPosition":I
    sub-int v3, p1, v0

    .line 849
    .local v3, "wantedChild":I
    if-ltz v3, :cond_0

    invoke-virtual {v1}, Landroid/widget/ListView;->getChildCount()I

    move-result v4

    if-lt v3, v4, :cond_1

    .line 850
    :cond_0
    const-string v4, "Unable to get view for desired position, because it\'s not being displayed on screen: {} {} {}."

    const/4 v5, 0x3

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    aput-object v7, v5, v6

    const/4 v6, 0x1

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    aput-object v7, v5, v6

    const/4 v6, 0x2

    invoke-virtual {v1}, Landroid/widget/ListView;->getChildCount()I

    move-result v7

    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    aput-object v7, v5, v6

    invoke-static {v4, v5}, Lcom/edisonwang/android/slog/SLog;->w(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 851
    const/4 v4, 0x0

    .line 854
    :goto_0
    return-object v4

    :cond_1
    invoke-virtual {v1, v3}, Landroid/widget/ListView;->getChildAt(I)Landroid/view/View;

    move-result-object v4

    goto :goto_0
.end method

.method private hasPlayerPlaying()Z
    .locals 1

    .prologue
    .line 833
    iget-object v0, p0, Lco/vine/android/ConversationAdapter;->mLastPlayer:Lco/vine/android/player/SdkVideoView;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/ConversationAdapter;->mLastPlayer:Lco/vine/android/player/SdkVideoView;

    invoke-virtual {v0}, Lco/vine/android/player/SdkVideoView;->isPaused()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private initMessage(Landroid/database/Cursor;)Lco/vine/android/api/VinePrivateMessage;
    .locals 3
    .param p1, "cursor"    # Landroid/database/Cursor;

    .prologue
    .line 276
    invoke-interface {p1}, Landroid/database/Cursor;->getPosition()I

    move-result v0

    .line 277
    .local v0, "position":I
    new-instance v1, Lco/vine/android/api/VinePrivateMessage;

    invoke-direct {v1, p1}, Lco/vine/android/api/VinePrivateMessage;-><init>(Landroid/database/Cursor;)V

    .line 278
    .local v1, "vpm":Lco/vine/android/api/VinePrivateMessage;
    iget-object v2, p0, Lco/vine/android/ConversationAdapter;->mMessages:Landroid/util/SparseArray;

    invoke-virtual {v2, v0, v1}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    .line 279
    return-object v1
.end method

.method private initVideoView(ILco/vine/android/ConversationAdapter$ConversationViewHolder;)V
    .locals 2
    .param p1, "position"    # I
    .param p2, "holder"    # Lco/vine/android/ConversationAdapter$ConversationViewHolder;

    .prologue
    .line 933
    iget-object v0, p2, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->videoView:Lco/vine/android/player/SdkVideoView;

    .line 934
    .local v0, "view":Lco/vine/android/player/SdkVideoView;
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lco/vine/android/player/SdkVideoView;->setAutoShow(Z)V

    .line 935
    new-instance v1, Lco/vine/android/ConversationAdapter$3;

    invoke-direct {v1, p0, p2, p1}, Lco/vine/android/ConversationAdapter$3;-><init>(Lco/vine/android/ConversationAdapter;Lco/vine/android/ConversationAdapter$ConversationViewHolder;I)V

    invoke-virtual {v0, v1}, Lco/vine/android/player/SdkVideoView;->setOnPreparedListener(Lco/vine/android/player/VideoViewInterface$OnPreparedListener;)V

    .line 966
    new-instance v1, Lco/vine/android/ConversationAdapter$4;

    invoke-direct {v1, p0, v0}, Lco/vine/android/ConversationAdapter$4;-><init>(Lco/vine/android/ConversationAdapter;Lco/vine/android/player/SdkVideoView;)V

    invoke-virtual {v0, v1}, Lco/vine/android/player/SdkVideoView;->setOnErrorListener(Lco/vine/android/player/VideoViewInterface$OnErrorListener;)V

    .line 975
    new-instance v1, Lco/vine/android/ConversationAdapter$5;

    invoke-direct {v1, p0, v0, p1}, Lco/vine/android/ConversationAdapter$5;-><init>(Lco/vine/android/ConversationAdapter;Lco/vine/android/player/SdkVideoView;I)V

    invoke-virtual {v0, v1}, Lco/vine/android/player/SdkVideoView;->setOnCompletionListener(Lco/vine/android/player/VideoViewInterface$OnCompletionListener;)V

    .line 987
    iget-object v1, p0, Lco/vine/android/ConversationAdapter;->mPlayers:Landroid/util/SparseArray;

    invoke-virtual {v1, p1, v0}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    .line 988
    return-void
.end method

.method private invalidateTimestamp(Lco/vine/android/ConversationAdapter$ConversationViewHolder;ILandroid/database/Cursor;Lco/vine/android/api/VinePrivateMessage;)V
    .locals 7
    .param p1, "holder"    # Lco/vine/android/ConversationAdapter$ConversationViewHolder;
    .param p2, "position"    # I
    .param p3, "cursor"    # Landroid/database/Cursor;
    .param p4, "vpm"    # Lco/vine/android/api/VinePrivateMessage;

    .prologue
    const-wide/16 v5, 0x0

    const/4 v2, 0x0

    .line 542
    const/4 v1, 0x0

    .line 544
    .local v1, "shouldShow":Z
    if-nez p2, :cond_1

    .line 545
    const/4 v1, 0x1

    .line 560
    :cond_0
    :goto_0
    if-eqz v1, :cond_6

    .line 561
    iget-object v3, p1, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->timestamp:Landroid/widget/TextView;

    iget-object v4, p0, Lco/vine/android/ConversationAdapter;->mVineDateFormatter:Lco/vine/android/util/VineDateFormatter;

    iget-wide v5, p4, Lco/vine/android/api/VinePrivateMessage;->created:J

    invoke-virtual {v4, v5, v6}, Lco/vine/android/util/VineDateFormatter;->format(J)Ljava/lang/CharSequence;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 562
    iget-object v3, p1, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->timestamp:Landroid/widget/TextView;

    invoke-virtual {v3, v2}, Landroid/widget/TextView;->setVisibility(I)V

    .line 566
    :goto_1
    return-void

    .line 547
    :cond_1
    iget-object v3, p0, Lco/vine/android/ConversationAdapter;->mMessages:Landroid/util/SparseArray;

    add-int/lit8 v4, p2, -0x1

    invoke-virtual {v3, v4}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/api/VinePrivateMessage;

    .line 548
    .local v0, "previous":Lco/vine/android/api/VinePrivateMessage;
    if-nez v0, :cond_2

    .line 549
    invoke-interface {p3}, Landroid/database/Cursor;->moveToPrevious()Z

    move-result v3

    if-eqz v3, :cond_4

    .line 550
    invoke-direct {p0, p3}, Lco/vine/android/ConversationAdapter;->initMessage(Landroid/database/Cursor;)Lco/vine/android/api/VinePrivateMessage;

    move-result-object v0

    .line 551
    invoke-interface {p3}, Landroid/database/Cursor;->moveToNext()Z

    .line 556
    :cond_2
    :goto_2
    if-nez v1, :cond_0

    .line 557
    iget-wide v3, p4, Lco/vine/android/api/VinePrivateMessage;->created:J

    cmp-long v3, v3, v5

    if-lez v3, :cond_3

    iget-wide v3, v0, Lco/vine/android/api/VinePrivateMessage;->created:J

    cmp-long v3, v3, v5

    if-lez v3, :cond_3

    iget-wide v3, p4, Lco/vine/android/api/VinePrivateMessage;->created:J

    iget-wide v5, v0, Lco/vine/android/api/VinePrivateMessage;->created:J

    sub-long/2addr v3, v5

    invoke-static {v3, v4}, Ljava/lang/Math;->abs(J)J

    move-result-wide v3

    const-wide/32 v5, 0x36ee80

    cmp-long v3, v3, v5

    if-ltz v3, :cond_5

    :cond_3
    const/4 v1, 0x1

    :goto_3
    goto :goto_0

    .line 553
    :cond_4
    const/4 v1, 0x1

    goto :goto_2

    :cond_5
    move v1, v2

    .line 557
    goto :goto_3

    .line 564
    .end local v0    # "previous":Lco/vine/android/api/VinePrivateMessage;
    :cond_6
    iget-object v2, p1, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->timestamp:Landroid/widget/TextView;

    const/16 v3, 0x8

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_1
.end method

.method private isMessageAlreadyVanished(Lco/vine/android/api/VinePrivateMessage;)Z
    .locals 6
    .param p1, "vpm"    # Lco/vine/android/api/VinePrivateMessage;

    .prologue
    .line 206
    iget-boolean v2, p1, Lco/vine/android/api/VinePrivateMessage;->ephemeral:Z

    if-eqz v2, :cond_4

    .line 207
    iget-boolean v2, p1, Lco/vine/android/api/VinePrivateMessage;->vanished:Z

    if-eqz v2, :cond_1

    .line 208
    const/4 v0, 0x1

    .line 226
    .local v0, "alreadyVanished":Z
    :cond_0
    :goto_0
    return v0

    .line 210
    .end local v0    # "alreadyVanished":Z
    :cond_1
    iget-object v2, p0, Lco/vine/android/ConversationAdapter;->mSeekInfoManager:Lco/vine/android/util/SeekInfoManager;

    iget-wide v3, p1, Lco/vine/android/api/VinePrivateMessage;->messageId:J

    invoke-virtual {v2, v3, v4}, Lco/vine/android/util/SeekInfoManager;->get(J)Lco/vine/android/util/SeekInfoManager$SeekInfo;

    move-result-object v1

    .line 211
    .local v1, "startTime":Lco/vine/android/util/SeekInfoManager$SeekInfo;
    if-eqz v1, :cond_3

    .line 212
    iget-wide v2, p1, Lco/vine/android/api/VinePrivateMessage;->localStartTime:J

    const-wide/16 v4, 0x0

    cmp-long v2, v2, v4

    if-eqz v2, :cond_2

    .line 213
    iget-wide v2, p1, Lco/vine/android/api/VinePrivateMessage;->localStartTime:J

    iput-wide v2, v1, Lco/vine/android/util/SeekInfoManager$SeekInfo;->startTime:J

    .line 215
    :cond_2
    invoke-virtual {v1}, Lco/vine/android/util/SeekInfoManager$SeekInfo;->isExpired()Z

    move-result v0

    .line 216
    .restart local v0    # "alreadyVanished":Z
    if-eqz v0, :cond_0

    .line 217
    invoke-direct {p0, p1}, Lco/vine/android/ConversationAdapter;->vanishMessage(Lco/vine/android/api/VinePrivateMessage;)V

    goto :goto_0

    .line 220
    .end local v0    # "alreadyVanished":Z
    :cond_3
    const/4 v0, 0x0

    .restart local v0    # "alreadyVanished":Z
    goto :goto_0

    .line 224
    .end local v0    # "alreadyVanished":Z
    .end local v1    # "startTime":Lco/vine/android/util/SeekInfoManager$SeekInfo;
    :cond_4
    const/4 v0, 0x0

    .restart local v0    # "alreadyVanished":Z
    goto :goto_0
.end method

.method private onLoopFinished(Lco/vine/android/player/VideoViewInterface;I)Z
    .locals 7
    .param p1, "view"    # Lco/vine/android/player/VideoViewInterface;
    .param p2, "position"    # I

    .prologue
    const/4 v0, 0x1

    .line 1026
    iget-object v3, p0, Lco/vine/android/ConversationAdapter;->mMessages:Landroid/util/SparseArray;

    invoke-virtual {v3, p2}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lco/vine/android/api/VinePrivateMessage;

    .line 1027
    .local v1, "message":Lco/vine/android/api/VinePrivateMessage;
    if-eqz v1, :cond_4

    iget-wide v3, v1, Lco/vine/android/api/VinePrivateMessage;->userId:J

    iget-object v5, p0, Lco/vine/android/ConversationAdapter;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v5}, Lco/vine/android/client/AppController;->getActiveId()J

    move-result-wide v5

    cmp-long v3, v3, v5

    if-eqz v3, :cond_4

    iget-boolean v3, v1, Lco/vine/android/api/VinePrivateMessage;->ephemeral:Z

    if-eqz v3, :cond_4

    .line 1028
    iget-object v3, p0, Lco/vine/android/ConversationAdapter;->mSeekInfoManager:Lco/vine/android/util/SeekInfoManager;

    invoke-virtual {v3, p1, v1}, Lco/vine/android/util/SeekInfoManager;->getSeekInfo(Lco/vine/android/player/VideoViewInterface;Lco/vine/android/api/VinePrivateMessage;)Lco/vine/android/util/SeekInfoManager$SeekInfo;

    move-result-object v2

    .line 1029
    .local v2, "seekInfo":Lco/vine/android/util/SeekInfoManager$SeekInfo;
    const-string v3, "{} just looped, seekInfo {}"

    iget-wide v4, v1, Lco/vine/android/api/VinePrivateMessage;->messageId:J

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    invoke-static {v3, v4, v2}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 1030
    if-eqz v2, :cond_0

    invoke-virtual {v2}, Lco/vine/android/util/SeekInfoManager$SeekInfo;->isExpired()Z

    move-result v3

    if-nez v3, :cond_2

    .line 1031
    .local v0, "haveLoopsLeft":Z
    :cond_0
    :goto_0
    if-eqz v0, :cond_3

    .line 1032
    if-eqz v2, :cond_1

    .line 1033
    invoke-interface {p1}, Lco/vine/android/player/VideoViewInterface;->getTag()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lco/vine/android/ConversationAdapter$ConversationViewHolder;

    iget-object v3, v3, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->vanishTimerText:Landroid/widget/TextView;

    invoke-virtual {v2}, Lco/vine/android/util/SeekInfoManager$SeekInfo;->getLoopsLeftForDisplay()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 1045
    .end local v0    # "haveLoopsLeft":Z
    .end local v2    # "seekInfo":Lco/vine/android/util/SeekInfoManager$SeekInfo;
    :cond_1
    :goto_1
    return v0

    .line 1030
    .restart local v2    # "seekInfo":Lco/vine/android/util/SeekInfoManager$SeekInfo;
    :cond_2
    const/4 v0, 0x0

    goto :goto_0

    .line 1036
    .restart local v0    # "haveLoopsLeft":Z
    :cond_3
    invoke-direct {p0, v1}, Lco/vine/android/ConversationAdapter;->vanishMessage(Lco/vine/android/api/VinePrivateMessage;)V

    .line 1037
    iget-object v3, p0, Lco/vine/android/ConversationAdapter;->mAppController:Lco/vine/android/client/AppController;

    new-instance v4, Lco/vine/android/util/video/VideoKey;

    iget-object v5, v1, Lco/vine/android/api/VinePrivateMessage;->videoUrl:Ljava/lang/String;

    invoke-direct {v4, v5}, Lco/vine/android/util/video/VideoKey;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v4}, Lco/vine/android/client/AppController;->removeFromVideoCache(Lco/vine/android/util/video/VideoKey;)V

    .line 1038
    invoke-interface {p1}, Lco/vine/android/player/VideoViewInterface;->getTag()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lco/vine/android/ConversationAdapter$ConversationViewHolder;

    invoke-direct {p0, v1, v3, p1}, Lco/vine/android/ConversationAdapter;->vanishView(Lco/vine/android/api/VinePrivateMessage;Lco/vine/android/ConversationAdapter$ConversationViewHolder;Lco/vine/android/player/VideoViewInterface;)V

    goto :goto_1

    .line 1042
    .end local v0    # "haveLoopsLeft":Z
    .end local v2    # "seekInfo":Lco/vine/android/util/SeekInfoManager$SeekInfo;
    :cond_4
    if-nez v1, :cond_1

    .line 1043
    const-string v3, "Message was null, limited loop function not working."

    invoke-static {v3}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;)V

    goto :goto_1
.end method

.method private refreshVideoView(ILco/vine/android/ConversationAdapter$ConversationViewHolder;)V
    .locals 7
    .param p1, "position"    # I
    .param p2, "tag"    # Lco/vine/android/ConversationAdapter$ConversationViewHolder;

    .prologue
    .line 779
    iget-object v4, p2, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->videoView:Lco/vine/android/player/SdkVideoView;

    invoke-virtual {v4}, Lco/vine/android/player/SdkVideoView;->getParent()Landroid/view/ViewParent;

    move-result-object v2

    check-cast v2, Landroid/view/ViewGroup;

    .line 780
    .local v2, "group":Landroid/view/ViewGroup;
    iget-object v4, p0, Lco/vine/android/ConversationAdapter;->mVideoAttr:Landroid/util/AttributeSet;

    if-nez v4, :cond_0

    .line 781
    iget-object v4, p2, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->videoView:Lco/vine/android/player/SdkVideoView;

    invoke-virtual {v4}, Lco/vine/android/player/SdkVideoView;->getAttributes()Landroid/util/AttributeSet;

    move-result-object v4

    iput-object v4, p0, Lco/vine/android/ConversationAdapter;->mVideoAttr:Landroid/util/AttributeSet;

    .line 783
    :cond_0
    iget-object v4, p2, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->videoView:Lco/vine/android/player/SdkVideoView;

    invoke-virtual {v4}, Lco/vine/android/player/SdkVideoView;->suspend()V

    .line 785
    :try_start_0
    iget-object v4, p2, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->videoView:Lco/vine/android/player/SdkVideoView;

    invoke-virtual {v2, v4}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    .line 793
    :goto_0
    new-instance v4, Lco/vine/android/player/SdkVideoView;

    iget-object v5, p0, Lco/vine/android/ConversationAdapter;->mContext:Landroid/content/Context;

    iget-object v6, p0, Lco/vine/android/ConversationAdapter;->mVideoAttr:Landroid/util/AttributeSet;

    invoke-direct {v4, v5, v6}, Lco/vine/android/player/SdkVideoView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    iput-object v4, p2, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->videoView:Lco/vine/android/player/SdkVideoView;

    .line 794
    invoke-direct {p0, p1}, Lco/vine/android/ConversationAdapter;->getSeekInfo(I)Lco/vine/android/util/SeekInfoManager$SeekInfo;

    move-result-object v3

    .line 795
    .local v3, "seekInfo":Lco/vine/android/util/SeekInfoManager$SeekInfo;
    iget-boolean v4, p2, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->isCurrentUser:Z

    if-nez v4, :cond_1

    if-eqz v3, :cond_1

    invoke-virtual {v3}, Lco/vine/android/util/SeekInfoManager$SeekInfo;->isExpired()Z

    move-result v4

    if-eqz v4, :cond_1

    .line 796
    iget-object v4, p2, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->videoView:Lco/vine/android/player/SdkVideoView;

    const/4 v5, 0x4

    invoke-virtual {v4, v5}, Lco/vine/android/player/SdkVideoView;->setVisibility(I)V

    .line 798
    :cond_1
    iget-object v4, p2, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->videoView:Lco/vine/android/player/SdkVideoView;

    invoke-virtual {v2, v4}, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V

    .line 799
    invoke-direct {p0, p1, p2}, Lco/vine/android/ConversationAdapter;->initVideoView(ILco/vine/android/ConversationAdapter$ConversationViewHolder;)V

    .line 800
    return-void

    .line 786
    .end local v3    # "seekInfo":Lco/vine/android/util/SeekInfoManager$SeekInfo;
    :catch_0
    move-exception v0

    .line 788
    .local v0, "e":Ljava/lang/RuntimeException;
    :try_start_1
    iget-object v4, p2, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->videoView:Lco/vine/android/player/SdkVideoView;

    invoke-virtual {v2, v4}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    goto :goto_0

    .line 789
    :catch_1
    move-exception v1

    .line 790
    .local v1, "e2":Ljava/lang/Exception;
    const-string v4, "Weird things are happening."

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/Object;

    invoke-static {v0, v4, v5}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0
.end method

.method private releaseOtherPlayers(Lco/vine/android/player/SdkVideoView;)V
    .locals 6
    .param p1, "view"    # Lco/vine/android/player/SdkVideoView;

    .prologue
    .line 1093
    const/4 v3, -0x1

    .line 1094
    .local v3, "viewKey":I
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    iget-object v4, p0, Lco/vine/android/ConversationAdapter;->mPlayers:Landroid/util/SparseArray;

    invoke-virtual {v4}, Landroid/util/SparseArray;->size()I

    move-result v4

    if-ge v0, v4, :cond_1

    .line 1095
    iget-object v4, p0, Lco/vine/android/ConversationAdapter;->mPlayers:Landroid/util/SparseArray;

    invoke-virtual {v4, v0}, Landroid/util/SparseArray;->keyAt(I)I

    move-result v1

    .line 1096
    .local v1, "key":I
    iget-object v4, p0, Lco/vine/android/ConversationAdapter;->mPlayers:Landroid/util/SparseArray;

    invoke-virtual {v4, v1}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lco/vine/android/player/SdkVideoView;

    .line 1097
    .local v2, "v":Lco/vine/android/player/SdkVideoView;
    if-eq v2, p1, :cond_0

    .line 1098
    invoke-virtual {v2}, Lco/vine/android/player/SdkVideoView;->suspend()V

    .line 1094
    :goto_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 1100
    :cond_0
    move v3, v1

    goto :goto_1

    .line 1103
    .end local v1    # "key":I
    .end local v2    # "v":Lco/vine/android/player/SdkVideoView;
    :cond_1
    iget-object v4, p0, Lco/vine/android/ConversationAdapter;->mPlayers:Landroid/util/SparseArray;

    invoke-virtual {v4}, Landroid/util/SparseArray;->clear()V

    .line 1104
    if-eqz p1, :cond_2

    .line 1105
    if-ltz v3, :cond_3

    .line 1106
    iget-object v4, p0, Lco/vine/android/ConversationAdapter;->mPlayers:Landroid/util/SparseArray;

    invoke-virtual {v4, v3, p1}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    .line 1115
    :cond_2
    :goto_2
    return-void

    .line 1110
    :cond_3
    new-instance v4, Ljava/lang/RuntimeException;

    const-string v5, "Invalid state in conversation adapter. Was seeing this a lot coming back from full record. Commented out the runtime and am just logging"

    invoke-direct {v4, v5}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    invoke-static {v4}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;)V

    goto :goto_2
.end method

.method private setImage(Landroid/widget/ImageView;Landroid/graphics/Bitmap;Lco/vine/android/ConversationAdapter$ConversationViewHolder;)Z
    .locals 6
    .param p1, "imageView"    # Landroid/widget/ImageView;
    .param p2, "bitmap"    # Landroid/graphics/Bitmap;
    .param p3, "holder"    # Lco/vine/android/ConversationAdapter$ConversationViewHolder;

    .prologue
    const/16 v5, 0x1e0

    .line 1132
    iget v1, p3, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->position:I

    .line 1133
    .local v1, "position":I
    if-nez p2, :cond_0

    .line 1134
    iget-object v4, p0, Lco/vine/android/ConversationAdapter;->mContext:Landroid/content/Context;

    invoke-virtual {v4}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    const v5, 0x7f09007f

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getColor(I)I

    move-result v4

    invoke-virtual {p1, v4}, Landroid/widget/ImageView;->setBackgroundColor(I)V

    .line 1135
    const/4 v4, 0x0

    invoke-virtual {p1, v4}, Landroid/widget/ImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    .line 1136
    const/4 v4, 0x0

    .line 1163
    :goto_0
    return v4

    .line 1138
    :cond_0
    const/4 v3, 0x0

    .line 1139
    .local v3, "setBlurredImage":Z
    iget-object v4, p3, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->videoImage:Landroid/widget/ImageView;

    if-ne p1, v4, :cond_1

    invoke-virtual {p2}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v4

    if-ne v4, v5, :cond_1

    invoke-virtual {p2}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v4

    if-ne v4, v5, :cond_1

    .line 1141
    iget-object v4, p0, Lco/vine/android/ConversationAdapter;->mMessages:Landroid/util/SparseArray;

    invoke-virtual {v4, v1}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/api/VinePrivateMessage;

    .line 1142
    .local v0, "message":Lco/vine/android/api/VinePrivateMessage;
    if-eqz v0, :cond_1

    .line 1143
    iget-boolean v4, v0, Lco/vine/android/api/VinePrivateMessage;->ephemeral:Z

    if-eqz v4, :cond_1

    .line 1144
    invoke-direct {p0, v1}, Lco/vine/android/ConversationAdapter;->getSeekInfo(I)Lco/vine/android/util/SeekInfoManager$SeekInfo;

    move-result-object v2

    .line 1145
    .local v2, "seek":Lco/vine/android/util/SeekInfoManager$SeekInfo;
    if-nez v2, :cond_1

    .line 1146
    const/4 v3, 0x1

    .line 1151
    .end local v0    # "message":Lco/vine/android/api/VinePrivateMessage;
    .end local v2    # "seek":Lco/vine/android/util/SeekInfoManager$SeekInfo;
    :cond_1
    if-eqz v3, :cond_2

    .line 1152
    iget-object v4, p0, Lco/vine/android/ConversationAdapter;->mContext:Landroid/content/Context;

    invoke-virtual {v4}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    const v5, 0x7f090083

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getColor(I)I

    move-result v4

    invoke-virtual {p1, v4}, Landroid/widget/ImageView;->setBackgroundColor(I)V

    .line 1153
    iget-object v4, p0, Lco/vine/android/ConversationAdapter;->mWaitingBg:Landroid/graphics/drawable/ColorDrawable;

    invoke-virtual {p1, v4}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 1154
    iput-object p2, p0, Lco/vine/android/ConversationAdapter;->mCurrentBlurBitmap:Landroid/graphics/Bitmap;

    .line 1155
    iput-object p1, p0, Lco/vine/android/ConversationAdapter;->mCurrentBlurImageView:Landroid/widget/ImageView;

    .line 1156
    iget-object v4, p0, Lco/vine/android/ConversationAdapter;->mBlurHandler:Landroid/os/Handler;

    iget-object v5, p0, Lco/vine/android/ConversationAdapter;->mBlurQueueRunnable:Ljava/lang/Runnable;

    invoke-virtual {v4, v5}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 1157
    iget-object v4, p0, Lco/vine/android/ConversationAdapter;->mBlurHandler:Landroid/os/Handler;

    iget-object v5, p0, Lco/vine/android/ConversationAdapter;->mBlurQueueRunnable:Ljava/lang/Runnable;

    invoke-virtual {v4, v5}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 1163
    :goto_1
    const/4 v4, 0x1

    goto :goto_0

    .line 1159
    :cond_2
    new-instance v4, Lco/vine/android/drawable/RecyclableBitmapDrawable;

    iget-object v5, p0, Lco/vine/android/ConversationAdapter;->mContext:Landroid/content/Context;

    invoke-virtual {v5}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    invoke-direct {v4, v5, p2}, Lco/vine/android/drawable/RecyclableBitmapDrawable;-><init>(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V

    invoke-virtual {p1, v4}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 1160
    iget-object v4, p0, Lco/vine/android/ConversationAdapter;->mContext:Landroid/content/Context;

    invoke-virtual {v4}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    const v5, 0x106000d

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getColor(I)I

    move-result v4

    invoke-virtual {p1, v4}, Landroid/widget/ImageView;->setBackgroundColor(I)V

    goto :goto_1
.end method

.method private setupUserImageImage(Lco/vine/android/api/VinePrivateMessage;Lco/vine/android/ConversationAdapter$ConversationViewHolder;Landroid/widget/ImageView;Z)V
    .locals 5
    .param p1, "vpm"    # Lco/vine/android/api/VinePrivateMessage;
    .param p2, "holder"    # Lco/vine/android/ConversationAdapter$ConversationViewHolder;
    .param p3, "userImage"    # Landroid/widget/ImageView;
    .param p4, "isError"    # Z

    .prologue
    const/4 v3, 0x0

    .line 247
    if-eqz p4, :cond_0

    .line 248
    invoke-virtual {p3, v3}, Landroid/widget/ImageView;->setColorFilter(Landroid/graphics/ColorFilter;)V

    .line 249
    const v2, 0x7f02016b

    invoke-virtual {p3, v2}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 263
    :goto_0
    return-void

    .line 250
    :cond_0
    iget-object v2, p1, Lco/vine/android/api/VinePrivateMessage;->avatarUrl:Ljava/lang/String;

    invoke-static {v2}, Lco/vine/android/util/Util;->isDefaultAvatarUrl(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 251
    sget-object v2, Lco/vine/android/util/Util$ProfileImageSize;->MEDIUM:Lco/vine/android/util/Util$ProfileImageSize;

    const/high16 v3, -0x1000000

    iget v4, p2, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->color:I

    or-int/2addr v3, v4

    invoke-static {p3, v2, v3}, Lco/vine/android/util/Util;->safeSetDefaultAvatar(Landroid/widget/ImageView;Lco/vine/android/util/Util$ProfileImageSize;I)V

    goto :goto_0

    .line 253
    :cond_1
    invoke-virtual {p3, v3}, Landroid/widget/ImageView;->setColorFilter(Landroid/graphics/ColorFilter;)V

    .line 254
    new-instance v1, Lco/vine/android/util/image/ImageKey;

    iget-object v2, p1, Lco/vine/android/api/VinePrivateMessage;->avatarUrl:Ljava/lang/String;

    const/4 v3, 0x1

    invoke-direct {v1, v2, v3}, Lco/vine/android/util/image/ImageKey;-><init>(Ljava/lang/String;Z)V

    .line 255
    .local v1, "avatarKey":Lco/vine/android/util/image/ImageKey;
    iput-object v1, p2, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->avatarKey:Lco/vine/android/util/image/ImageKey;

    .line 256
    iget-object v2, p0, Lco/vine/android/ConversationAdapter;->mAvatars:Landroid/util/SparseArray;

    iget v3, p2, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->position:I

    invoke-virtual {v2, v3}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/graphics/Bitmap;

    .line 257
    .local v0, "avatar":Landroid/graphics/Bitmap;
    if-eqz v0, :cond_2

    .line 258
    invoke-direct {p0, p3, v0, p2}, Lco/vine/android/ConversationAdapter;->setImage(Landroid/widget/ImageView;Landroid/graphics/Bitmap;Lco/vine/android/ConversationAdapter$ConversationViewHolder;)Z

    goto :goto_0

    .line 260
    :cond_2
    iget-object v2, p0, Lco/vine/android/ConversationAdapter;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v2, v1}, Lco/vine/android/client/AppController;->getPhotoBitmap(Lco/vine/android/util/image/ImageKey;)Landroid/graphics/Bitmap;

    move-result-object v2

    invoke-direct {p0, p3, v2, p2}, Lco/vine/android/ConversationAdapter;->setImage(Landroid/widget/ImageView;Landroid/graphics/Bitmap;Lco/vine/android/ConversationAdapter$ConversationViewHolder;)Z

    goto :goto_0
.end method

.method private setupUserImageProperties(ILandroid/widget/ImageView;Z)V
    .locals 5
    .param p1, "messagePosition"    # I
    .param p2, "userImage"    # Landroid/widget/ImageView;
    .param p3, "isCurrentUser"    # Z

    .prologue
    const/16 v4, 0xb

    const/16 v3, 0x9

    const/4 v2, 0x0

    .line 230
    invoke-virtual {p2, v2}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 231
    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {p2, v1}, Landroid/widget/ImageView;->setTag(Ljava/lang/Object;)V

    .line 232
    invoke-virtual {p2, p0}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 233
    invoke-virtual {p2}, Landroid/widget/ImageView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout$LayoutParams;

    .line 235
    .local v0, "imageParams":Landroid/widget/RelativeLayout$LayoutParams;
    if-nez p3, :cond_0

    .line 236
    invoke-virtual {v0, v4, v2}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(II)V

    .line 237
    invoke-virtual {v0, v3}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(I)V

    .line 242
    :goto_0
    invoke-virtual {p2, v0}, Landroid/widget/ImageView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 243
    return-void

    .line 239
    :cond_0
    invoke-virtual {v0, v3, v2}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(II)V

    .line 240
    invoke-virtual {v0, v4}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(I)V

    goto :goto_0
.end method

.method private shouldShowThumbnail(I)Z
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 195
    iget v0, p0, Lco/vine/android/ConversationAdapter;->mCurrentPlaying:I

    if-ne v0, p1, :cond_0

    invoke-direct {p0}, Lco/vine/android/ConversationAdapter;->hasPlayerPlaying()Z

    move-result v0

    if-nez v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private styleDescription(Landroid/widget/TextView;Lco/vine/android/api/VinePost;IZ)V
    .locals 11
    .param p1, "textView"    # Landroid/widget/TextView;
    .param p2, "post"    # Lco/vine/android/api/VinePost;
    .param p3, "color"    # I
    .param p4, "deletedSharedPost"    # Z

    .prologue
    const/16 v10, 0x21

    const/4 v9, 0x0

    .line 632
    const/high16 v7, -0x1000000

    or-int/2addr p3, v7

    .line 633
    if-eqz p2, :cond_0

    iget-object v7, p2, Lco/vine/android/api/VinePost;->transientEntities:Ljava/util/ArrayList;

    if-nez v7, :cond_0

    iget-object v7, p2, Lco/vine/android/api/VinePost;->entities:Ljava/util/ArrayList;

    if-eqz v7, :cond_0

    .line 634
    new-instance v7, Ljava/util/ArrayList;

    invoke-direct {v7}, Ljava/util/ArrayList;-><init>()V

    iput-object v7, p2, Lco/vine/android/api/VinePost;->transientEntities:Ljava/util/ArrayList;

    .line 635
    iget-object v7, p2, Lco/vine/android/api/VinePost;->entities:Ljava/util/ArrayList;

    invoke-virtual {v7}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lco/vine/android/api/VineEntity;

    .line 636
    .local v2, "entity":Lco/vine/android/api/VineEntity;
    iget-object v7, p2, Lco/vine/android/api/VinePost;->transientEntities:Ljava/util/ArrayList;

    invoke-virtual {v2}, Lco/vine/android/api/VineEntity;->duplicate()Lco/vine/android/api/VineEntity;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 640
    .end local v2    # "entity":Lco/vine/android/api/VineEntity;
    .end local v3    # "i$":Ljava/util/Iterator;
    :cond_0
    if-eqz p2, :cond_3

    iget-object v4, p2, Lco/vine/android/api/VinePost;->transientEntities:Ljava/util/ArrayList;

    .line 641
    .local v4, "postEntities":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineEntity;>;"
    :goto_1
    if-eqz v4, :cond_5

    .line 642
    invoke-static {}, Landroid/text/method/LinkMovementMethod;->getInstance()Landroid/text/method/MovementMethod;

    move-result-object v7

    invoke-virtual {p1, v7}, Landroid/widget/TextView;->setMovementMethod(Landroid/text/method/MovementMethod;)V

    .line 643
    iget-object v7, p2, Lco/vine/android/api/VinePost;->descriptionSb:Landroid/text/SpannableStringBuilder;

    if-nez v7, :cond_2

    iget-object v7, p2, Lco/vine/android/api/VinePost;->description:Ljava/lang/String;

    if-eqz v7, :cond_2

    .line 644
    new-instance v7, Landroid/text/SpannableStringBuilder;

    iget-object v8, p2, Lco/vine/android/api/VinePost;->description:Ljava/lang/String;

    invoke-direct {v7, v8}, Landroid/text/SpannableStringBuilder;-><init>(Ljava/lang/CharSequence;)V

    iput-object v7, p2, Lco/vine/android/api/VinePost;->descriptionSb:Landroid/text/SpannableStringBuilder;

    .line 645
    iget-object v0, p2, Lco/vine/android/api/VinePost;->descriptionSb:Landroid/text/SpannableStringBuilder;

    .line 647
    .local v0, "descriptionSb":Landroid/text/SpannableStringBuilder;
    const/4 v7, 0x0

    const/4 v8, 0x0

    :try_start_0
    invoke-static {v4, v0, v7, v8}, Lco/vine/android/util/Util;->adjustEntities(Ljava/util/ArrayList;Landroid/text/Editable;IZ)V

    .line 649
    invoke-virtual {v4}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .restart local v3    # "i$":Ljava/util/Iterator;
    :cond_1
    :goto_2
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_2

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lco/vine/android/api/VineEntity;

    .line 650
    .restart local v2    # "entity":Lco/vine/android/api/VineEntity;
    invoke-virtual {v2}, Lco/vine/android/api/VineEntity;->isUserType()Z

    move-result v7

    if-eqz v7, :cond_4

    .line 651
    new-instance v6, Lco/vine/android/widget/StyledClickableSpan;

    const/4 v7, 0x1

    iget-wide v8, v2, Lco/vine/android/api/VineEntity;->id:J

    invoke-static {v8, v9}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v8

    iget-object v9, p0, Lco/vine/android/ConversationAdapter;->mSpanClicker:Lco/vine/android/VineSpanClicker;

    invoke-direct {v6, v7, v8, v9}, Lco/vine/android/widget/StyledClickableSpan;-><init>(ILjava/lang/Object;Lco/vine/android/widget/SpanClickListener;)V

    .line 654
    .local v6, "usernameSpan":Lco/vine/android/widget/StyledClickableSpan;
    invoke-virtual {v6, p3}, Lco/vine/android/widget/StyledClickableSpan;->setColor(I)V

    .line 655
    iget v7, v2, Lco/vine/android/api/VineEntity;->start:I

    iget v8, v2, Lco/vine/android/api/VineEntity;->end:I

    const/16 v9, 0x21

    invoke-static {v0, v6, v7, v8, v9}, Lco/vine/android/util/Util;->safeSetSpan(Landroid/text/Spannable;Ljava/lang/Object;III)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_2

    .line 666
    .end local v2    # "entity":Lco/vine/android/api/VineEntity;
    .end local v3    # "i$":Ljava/util/Iterator;
    .end local v6    # "usernameSpan":Lco/vine/android/widget/StyledClickableSpan;
    :catch_0
    move-exception v1

    .line 667
    .local v1, "e":Ljava/lang/Exception;
    invoke-static {v1}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;)V

    .line 670
    .end local v0    # "descriptionSb":Landroid/text/SpannableStringBuilder;
    .end local v1    # "e":Ljava/lang/Exception;
    :cond_2
    iget-object v7, p2, Lco/vine/android/api/VinePost;->descriptionSb:Landroid/text/SpannableStringBuilder;

    invoke-virtual {p1, v7}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 680
    :goto_3
    return-void

    .line 640
    .end local v4    # "postEntities":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineEntity;>;"
    :cond_3
    const/4 v4, 0x0

    goto :goto_1

    .line 657
    .restart local v0    # "descriptionSb":Landroid/text/SpannableStringBuilder;
    .restart local v2    # "entity":Lco/vine/android/api/VineEntity;
    .restart local v3    # "i$":Ljava/util/Iterator;
    .restart local v4    # "postEntities":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineEntity;>;"
    :cond_4
    :try_start_1
    invoke-virtual {v2}, Lco/vine/android/api/VineEntity;->isTagType()Z

    move-result v7

    if-eqz v7, :cond_1

    .line 658
    new-instance v6, Lco/vine/android/widget/StyledClickableSpan;

    const/4 v7, 0x4

    iget-object v8, v2, Lco/vine/android/api/VineEntity;->title:Ljava/lang/String;

    iget-object v9, p0, Lco/vine/android/ConversationAdapter;->mSpanClicker:Lco/vine/android/VineSpanClicker;

    invoke-direct {v6, v7, v8, v9}, Lco/vine/android/widget/StyledClickableSpan;-><init>(ILjava/lang/Object;Lco/vine/android/widget/SpanClickListener;)V

    .line 661
    .restart local v6    # "usernameSpan":Lco/vine/android/widget/StyledClickableSpan;
    invoke-virtual {v6, p3}, Lco/vine/android/widget/StyledClickableSpan;->setColor(I)V

    .line 662
    iget v7, v2, Lco/vine/android/api/VineEntity;->start:I

    iget v8, v2, Lco/vine/android/api/VineEntity;->end:I

    const/16 v9, 0x21

    invoke-static {v0, v6, v7, v8, v9}, Lco/vine/android/util/Util;->safeSetSpan(Landroid/text/Spannable;Ljava/lang/Object;III)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_2

    .line 672
    .end local v0    # "descriptionSb":Landroid/text/SpannableStringBuilder;
    .end local v2    # "entity":Lco/vine/android/api/VineEntity;
    .end local v3    # "i$":Ljava/util/Iterator;
    .end local v6    # "usernameSpan":Lco/vine/android/widget/StyledClickableSpan;
    :cond_5
    if-nez p4, :cond_6

    if-nez p2, :cond_7

    .line 673
    :cond_6
    new-instance v5, Landroid/text/SpannableStringBuilder;

    iget-object v7, p0, Lco/vine/android/ConversationAdapter;->mActivity:Lco/vine/android/ConversationActivity;

    const v8, 0x7f0e0215

    invoke-virtual {v7, v8}, Lco/vine/android/ConversationActivity;->getString(I)Ljava/lang/String;

    move-result-object v7

    invoke-direct {v5, v7}, Landroid/text/SpannableStringBuilder;-><init>(Ljava/lang/CharSequence;)V

    .line 674
    .local v5, "sb":Landroid/text/SpannableStringBuilder;
    iget-object v7, p0, Lco/vine/android/ConversationAdapter;->mDarkGreySpan:Lco/vine/android/widget/ColoredSpan;

    invoke-virtual {v5}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v8

    invoke-static {v5, v7, v9, v8, v10}, Lco/vine/android/util/Util;->safeSetSpan(Landroid/text/Spannable;Ljava/lang/Object;III)V

    .line 675
    invoke-virtual {p1, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_3

    .line 677
    .end local v5    # "sb":Landroid/text/SpannableStringBuilder;
    :cond_7
    iget-object v7, p2, Lco/vine/android/api/VinePost;->description:Ljava/lang/String;

    invoke-virtual {p1, v7}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_3
.end method

.method private styleTopSharedDescription(Lco/vine/android/api/VinePost;ZILandroid/widget/TextView;Z)V
    .locals 15
    .param p1, "post"    # Lco/vine/android/api/VinePost;
    .param p2, "isCurrentUser"    # Z
    .param p3, "color"    # I
    .param p4, "view"    # Landroid/widget/TextView;
    .param p5, "deleted"    # Z

    .prologue
    .line 569
    const/high16 v11, -0x1000000

    or-int p3, p3, v11

    .line 571
    if-nez p5, :cond_0

    if-eqz p1, :cond_0

    move-object/from16 v0, p1

    iget-object v11, v0, Lco/vine/android/api/VinePost;->username:Ljava/lang/String;

    if-nez v11, :cond_3

    .line 572
    :cond_0
    new-instance v6, Landroid/text/SpannableStringBuilder;

    invoke-direct {v6}, Landroid/text/SpannableStringBuilder;-><init>()V

    .line 573
    .local v6, "sb":Landroid/text/SpannableStringBuilder;
    iget-object v12, p0, Lco/vine/android/ConversationAdapter;->mContext:Landroid/content/Context;

    if-eqz p2, :cond_2

    const v11, 0x7f0e0218

    :goto_0
    invoke-virtual {v12, v11}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v6, v11}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 575
    iget-object v11, p0, Lco/vine/android/ConversationAdapter;->mDarkGreySpan:Lco/vine/android/widget/ColoredSpan;

    const/4 v12, 0x0

    invoke-virtual {v6}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v13

    const/16 v14, 0x21

    invoke-static {v6, v11, v12, v13, v14}, Lco/vine/android/util/Util;->safeSetSpan(Landroid/text/Spannable;Ljava/lang/Object;III)V

    .line 576
    move-object/from16 v0, p4

    invoke-virtual {v0, v6}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 577
    if-eqz p1, :cond_1

    move-object/from16 v0, p1

    iget-object v11, v0, Lco/vine/android/api/VinePost;->username:Ljava/lang/String;

    if-nez v11, :cond_1

    .line 578
    new-instance v11, Ljava/lang/IllegalArgumentException;

    new-instance v12, Ljava/lang/StringBuilder;

    invoke-direct {v12}, Ljava/lang/StringBuilder;-><init>()V

    const-string v13, "Username is null: "

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    move-object/from16 v0, p1

    iget-wide v13, v0, Lco/vine/android/api/VinePost;->postId:J

    invoke-virtual {v12, v13, v14}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    invoke-direct {v11, v12}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    invoke-static {v11}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;)V

    .line 629
    .end local v6    # "sb":Landroid/text/SpannableStringBuilder;
    :cond_1
    :goto_1
    return-void

    .line 573
    .restart local v6    # "sb":Landroid/text/SpannableStringBuilder;
    :cond_2
    const v11, 0x7f0e0216

    goto :goto_0

    .line 581
    .end local v6    # "sb":Landroid/text/SpannableStringBuilder;
    :cond_3
    move-object/from16 v0, p1

    iget-object v11, v0, Lco/vine/android/api/VinePost;->sharedVmSb:Landroid/text/SpannableStringBuilder;

    if-nez v11, :cond_7

    .line 582
    iget-object v12, p0, Lco/vine/android/ConversationAdapter;->mContext:Landroid/content/Context;

    if-eqz p2, :cond_8

    const v11, 0x7f0e0219

    :goto_2
    invoke-virtual {v12, v11}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v10

    .line 585
    .local v10, "string":Ljava/lang/String;
    new-instance v11, Landroid/text/SpannableStringBuilder;

    invoke-direct {v11}, Landroid/text/SpannableStringBuilder;-><init>()V

    move-object/from16 v0, p1

    iput-object v11, v0, Lco/vine/android/api/VinePost;->sharedVmSb:Landroid/text/SpannableStringBuilder;

    .line 586
    move-object/from16 v0, p1

    iget-object v7, v0, Lco/vine/android/api/VinePost;->sharedVmSb:Landroid/text/SpannableStringBuilder;

    .line 588
    .local v7, "sharedVmSb":Landroid/text/SpannableStringBuilder;
    const-string v11, "{"

    invoke-virtual {v10, v11}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v9

    .line 590
    .local v9, "start":I
    if-lez v9, :cond_4

    .line 591
    const/4 v11, 0x0

    invoke-virtual {v10, v11, v9}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v7, v11}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 594
    :cond_4
    const/4 v5, 0x0

    .line 596
    .local v5, "replacer":Ljava/lang/String;
    const-string v11, "}"

    invoke-virtual {v10, v11}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v4

    .line 598
    .local v4, "index":I
    if-gez v4, :cond_5

    .line 599
    new-instance v11, Ljava/lang/StringBuilder;

    invoke-direct {v11}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v11, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string v12, "}"

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    .line 603
    :cond_5
    add-int/lit8 v11, v9, 0x1

    :try_start_0
    const-string v12, "}"

    invoke-virtual {v10, v12}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v12

    invoke-virtual {v10, v11, v12}, Ljava/lang/String;->substring(II)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v5

    .line 609
    :goto_3
    const-string v11, "%s"

    move-object/from16 v0, p1

    iget-object v12, v0, Lco/vine/android/api/VinePost;->username:Ljava/lang/String;

    invoke-virtual {v5, v11, v12}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v7, v11}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 611
    invoke-virtual {v7}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v2

    .line 613
    .local v2, "end":I
    const-string v11, "}"

    invoke-virtual {v10, v11}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v3

    .line 615
    .local v3, "endOfReplacer":I
    invoke-virtual {v10}, Ljava/lang/String;->length()I

    move-result v11

    add-int/lit8 v11, v11, -0x1

    if-ge v3, v11, :cond_6

    .line 616
    add-int/lit8 v11, v3, 0x1

    invoke-virtual {v10, v11}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v7, v11}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 619
    :cond_6
    new-instance v8, Lco/vine/android/widget/StyledClickableSpan;

    const/16 v11, 0x9

    move-object/from16 v0, p1

    iget-wide v12, v0, Lco/vine/android/api/VinePost;->postId:J

    invoke-static {v12, v13}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v12

    iget-object v13, p0, Lco/vine/android/ConversationAdapter;->mSpanClicker:Lco/vine/android/VineSpanClicker;

    invoke-direct {v8, v11, v12, v13}, Lco/vine/android/widget/StyledClickableSpan;-><init>(ILjava/lang/Object;Lco/vine/android/widget/SpanClickListener;)V

    .line 621
    .local v8, "span":Lco/vine/android/widget/StyledClickableSpan;
    move/from16 v0, p3

    invoke-virtual {v8, v0}, Lco/vine/android/widget/StyledClickableSpan;->setColor(I)V

    .line 622
    const/16 v11, 0x21

    invoke-static {v7, v8, v9, v2, v11}, Lco/vine/android/util/Util;->safeSetSpan(Landroid/text/Spannable;Ljava/lang/Object;III)V

    .line 623
    iget-object v11, p0, Lco/vine/android/ConversationAdapter;->mBoldSpan:Lco/vine/android/widget/TypefacesSpan;

    const/16 v12, 0x21

    invoke-static {v7, v11, v9, v2, v12}, Lco/vine/android/util/Util;->safeSetSpan(Landroid/text/Spannable;Ljava/lang/Object;III)V

    .line 624
    iget-object v11, p0, Lco/vine/android/ConversationAdapter;->mDarkGreySpan:Lco/vine/android/widget/ColoredSpan;

    const/4 v12, 0x0

    const/16 v13, 0x21

    invoke-static {v7, v11, v12, v9, v13}, Lco/vine/android/util/Util;->safeSetSpan(Landroid/text/Spannable;Ljava/lang/Object;III)V

    .line 626
    .end local v2    # "end":I
    .end local v3    # "endOfReplacer":I
    .end local v4    # "index":I
    .end local v5    # "replacer":Ljava/lang/String;
    .end local v7    # "sharedVmSb":Landroid/text/SpannableStringBuilder;
    .end local v8    # "span":Lco/vine/android/widget/StyledClickableSpan;
    .end local v9    # "start":I
    .end local v10    # "string":Ljava/lang/String;
    :cond_7
    invoke-static {}, Landroid/text/method/LinkMovementMethod;->getInstance()Landroid/text/method/MovementMethod;

    move-result-object v11

    move-object/from16 v0, p4

    invoke-virtual {v0, v11}, Landroid/widget/TextView;->setMovementMethod(Landroid/text/method/MovementMethod;)V

    .line 627
    move-object/from16 v0, p1

    iget-object v11, v0, Lco/vine/android/api/VinePost;->sharedVmSb:Landroid/text/SpannableStringBuilder;

    move-object/from16 v0, p4

    invoke-virtual {v0, v11}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_1

    .line 582
    :cond_8
    const v11, 0x7f0e0217

    goto/16 :goto_2

    .line 604
    .restart local v4    # "index":I
    .restart local v5    # "replacer":Ljava/lang/String;
    .restart local v7    # "sharedVmSb":Landroid/text/SpannableStringBuilder;
    .restart local v9    # "start":I
    .restart local v10    # "string":Ljava/lang/String;
    :catch_0
    move-exception v1

    .line 605
    .local v1, "e":Ljava/lang/Exception;
    const-string v11, "Failed top post span thing. locale: {}"

    const/4 v12, 0x1

    new-array v12, v12, [Ljava/lang/Object;

    const/4 v13, 0x0

    invoke-static {}, Lco/vine/android/util/Util;->getLocale()Ljava/lang/String;

    move-result-object v14

    aput-object v14, v12, v13

    invoke-static {v1, v11, v12}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 606
    const-string v5, "%s"

    goto :goto_3
.end method

.method private vanishMessage(Lco/vine/android/api/VinePrivateMessage;)V
    .locals 4
    .param p1, "vpm"    # Lco/vine/android/api/VinePrivateMessage;

    .prologue
    .line 199
    const/4 v0, 0x1

    iput-boolean v0, p1, Lco/vine/android/api/VinePrivateMessage;->vanished:Z

    .line 200
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    iput-wide v0, p1, Lco/vine/android/api/VinePrivateMessage;->vanishedDate:J

    .line 201
    iget-object v0, p0, Lco/vine/android/ConversationAdapter;->mVanishedIdDateMap:Ljava/util/HashMap;

    iget-wide v1, p1, Lco/vine/android/api/VinePrivateMessage;->messageId:J

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    iget-wide v2, p1, Lco/vine/android/api/VinePrivateMessage;->vanishedDate:J

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 202
    return-void
.end method

.method private vanishView(Lco/vine/android/api/VinePrivateMessage;Lco/vine/android/ConversationAdapter$ConversationViewHolder;Lco/vine/android/player/VideoViewInterface;)V
    .locals 12
    .param p1, "vpm"    # Lco/vine/android/api/VinePrivateMessage;
    .param p2, "holder"    # Lco/vine/android/ConversationAdapter$ConversationViewHolder;
    .param p3, "view"    # Lco/vine/android/player/VideoViewInterface;

    .prologue
    .line 1050
    invoke-interface {p3}, Lco/vine/android/player/VideoViewInterface;->isInPlaybackState()Z

    move-result v8

    if-eqz v8, :cond_0

    .line 1051
    invoke-interface {p3}, Lco/vine/android/player/VideoViewInterface;->stopPlayback()V

    .line 1052
    const/4 v8, 0x0

    invoke-interface {p3, v8}, Lco/vine/android/player/VideoViewInterface;->setVideoPath(Ljava/lang/String;)V

    .line 1054
    :cond_0
    iget-object v8, p2, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->videoContainer:Landroid/view/View;

    invoke-virtual {v8}, Landroid/view/View;->getVisibility()I

    move-result v8

    const/16 v9, 0x8

    if-eq v8, v9, :cond_1

    .line 1055
    iget-object v8, p2, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->videoContainer:Landroid/view/View;

    const/16 v9, 0x8

    invoke-virtual {v8, v9}, Landroid/view/View;->setVisibility(I)V

    .line 1058
    :cond_1
    iget-object v8, p2, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->vanishTimerText:Landroid/widget/TextView;

    invoke-virtual {v8}, Landroid/widget/TextView;->getVisibility()I

    move-result v8

    const/16 v9, 0x8

    if-eq v8, v9, :cond_2

    .line 1059
    iget-object v8, p2, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->vanishTimerText:Landroid/widget/TextView;

    const/16 v9, 0x8

    invoke-virtual {v8, v9}, Landroid/widget/TextView;->setVisibility(I)V

    .line 1062
    :cond_2
    const/high16 v8, 0x60000000

    iget v9, p2, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->color:I

    or-int v0, v8, v9

    .line 1064
    .local v0, "backgroundColor":I
    iget-object v8, p0, Lco/vine/android/ConversationAdapter;->mViewedPorterDuffFilterSet:Landroid/util/SparseArray;

    invoke-virtual {v8, v0}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/graphics/PorterDuffColorFilter;

    .line 1065
    .local v3, "filter":Landroid/graphics/PorterDuffColorFilter;
    if-nez v3, :cond_3

    .line 1066
    new-instance v3, Landroid/graphics/PorterDuffColorFilter;

    .end local v3    # "filter":Landroid/graphics/PorterDuffColorFilter;
    sget-object v8, Landroid/graphics/PorterDuff$Mode;->SRC_IN:Landroid/graphics/PorterDuff$Mode;

    invoke-direct {v3, v0, v8}, Landroid/graphics/PorterDuffColorFilter;-><init>(ILandroid/graphics/PorterDuff$Mode;)V

    .line 1067
    .restart local v3    # "filter":Landroid/graphics/PorterDuffColorFilter;
    iget-object v8, p0, Lco/vine/android/ConversationAdapter;->mViewedPorterDuffFilterSet:Landroid/util/SparseArray;

    invoke-virtual {v8, v0, v3}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    .line 1069
    :cond_3
    iget-object v8, p2, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->secondaryMessageContainer:Landroid/view/View;

    invoke-virtual {v8}, Landroid/view/View;->getBackground()Landroid/graphics/drawable/Drawable;

    move-result-object v8

    invoke-virtual {v8, v3}, Landroid/graphics/drawable/Drawable;->setColorFilter(Landroid/graphics/ColorFilter;)V

    .line 1070
    iget-object v8, p2, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->secondaryMessageContainer:Landroid/view/View;

    const/4 v9, 0x0

    invoke-virtual {v8, v9}, Landroid/view/View;->setVisibility(I)V

    .line 1072
    iget-object v8, p1, Lco/vine/android/api/VinePrivateMessage;->vanishedViewedSb:Landroid/text/SpannableStringBuilder;

    if-nez v8, :cond_4

    .line 1073
    new-instance v8, Landroid/text/SpannableStringBuilder;

    invoke-direct {v8}, Landroid/text/SpannableStringBuilder;-><init>()V

    iput-object v8, p1, Lco/vine/android/api/VinePrivateMessage;->vanishedViewedSb:Landroid/text/SpannableStringBuilder;

    .line 1075
    iget-object v8, p0, Lco/vine/android/ConversationAdapter;->mVanishedIdDateMap:Ljava/util/HashMap;

    iget-wide v9, p1, Lco/vine/android/api/VinePrivateMessage;->messageId:J

    invoke-static {v9, v10}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/Long;

    .line 1077
    .local v4, "memVanishedDate":Ljava/lang/Long;
    new-instance v6, Ljava/util/Date;

    if-eqz v4, :cond_5

    invoke-virtual {v4}, Ljava/lang/Long;->longValue()J

    move-result-wide v8

    :goto_0
    invoke-direct {v6, v8, v9}, Ljava/util/Date;-><init>(J)V

    .line 1079
    .local v6, "vanishedDate":Ljava/util/Date;
    iget-object v8, p0, Lco/vine/android/ConversationAdapter;->mActivity:Lco/vine/android/ConversationActivity;

    const v9, 0x7f0e0270

    invoke-virtual {v8, v9}, Lco/vine/android/ConversationActivity;->getString(I)Ljava/lang/String;

    move-result-object v7

    .line 1080
    .local v7, "viewedString":Ljava/lang/String;
    const-string v8, "hh:mm aa"

    invoke-static {v8, v6}, Landroid/text/format/DateFormat;->format(Ljava/lang/CharSequence;Ljava/util/Date;)Ljava/lang/CharSequence;

    move-result-object v8

    invoke-interface {v8}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v1

    .line 1082
    .local v1, "dateString":Ljava/lang/String;
    const-string v8, "%s"

    invoke-virtual {v7, v8}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v5

    .line 1083
    .local v5, "start":I
    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v8

    add-int v2, v5, v8

    .line 1084
    .local v2, "end":I
    iget-object v8, p1, Lco/vine/android/api/VinePrivateMessage;->vanishedViewedSb:Landroid/text/SpannableStringBuilder;

    const-string v9, "%s"

    invoke-virtual {v7, v9, v1}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 1085
    iget-object v8, p1, Lco/vine/android/api/VinePrivateMessage;->vanishedViewedSb:Landroid/text/SpannableStringBuilder;

    new-instance v9, Lco/vine/android/widget/ColoredSpan;

    const/high16 v10, -0x1000000

    iget v11, p2, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->color:I

    or-int/2addr v10, v11

    invoke-direct {v9, v10}, Lco/vine/android/widget/ColoredSpan;-><init>(I)V

    const/4 v10, 0x0

    const/16 v11, 0x21

    invoke-static {v8, v9, v10, v2, v11}, Lco/vine/android/util/Util;->safeSetSpan(Landroid/text/Spannable;Ljava/lang/Object;III)V

    .line 1086
    iget-object v8, p1, Lco/vine/android/api/VinePrivateMessage;->vanishedViewedSb:Landroid/text/SpannableStringBuilder;

    iget-object v9, p0, Lco/vine/android/ConversationAdapter;->mBoldSpan:Lco/vine/android/widget/TypefacesSpan;

    const/16 v10, 0x21

    invoke-static {v8, v9, v5, v2, v10}, Lco/vine/android/util/Util;->safeSetSpan(Landroid/text/Spannable;Ljava/lang/Object;III)V

    .line 1088
    .end local v1    # "dateString":Ljava/lang/String;
    .end local v2    # "end":I
    .end local v4    # "memVanishedDate":Ljava/lang/Long;
    .end local v5    # "start":I
    .end local v6    # "vanishedDate":Ljava/util/Date;
    .end local v7    # "viewedString":Ljava/lang/String;
    :cond_4
    iget-object v8, p2, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->secondaryMessageContainerMessage:Landroid/widget/TextView;

    iget-object v9, p1, Lco/vine/android/api/VinePrivateMessage;->vanishedViewedSb:Landroid/text/SpannableStringBuilder;

    invoke-virtual {v8, v9}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 1090
    return-void

    .line 1077
    .restart local v4    # "memVanishedDate":Ljava/lang/Long;
    :cond_5
    iget-wide v8, p1, Lco/vine/android/api/VinePrivateMessage;->vanishedDate:J

    goto :goto_0
.end method


# virtual methods
.method public atLastPage()Z
    .locals 3

    .prologue
    const/4 v0, 0x1

    .line 1229
    iget-object v1, p0, Lco/vine/android/ConversationAdapter;->mCursor:Landroid/database/Cursor;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lco/vine/android/ConversationAdapter;->mCursor:Landroid/database/Cursor;

    invoke-interface {v1}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v1

    if-eqz v1, :cond_0

    iget-object v1, p0, Lco/vine/android/ConversationAdapter;->mCursor:Landroid/database/Cursor;

    const/16 v2, 0x8

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getInt(I)I

    move-result v1

    if-ne v1, v0, :cond_0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public bindView(Landroid/view/View;Landroid/content/Context;Landroid/database/Cursor;)V
    .locals 31
    .param p1, "view"    # Landroid/view/View;
    .param p2, "context"    # Landroid/content/Context;
    .param p3, "cursor"    # Landroid/database/Cursor;

    .prologue
    .line 289
    invoke-interface/range {p3 .. p3}, Landroid/database/Cursor;->getPosition()I

    move-result v19

    .line 290
    .local v19, "position":I
    move-object/from16 v0, p0

    move-object/from16 v1, p3

    invoke-direct {v0, v1}, Lco/vine/android/ConversationAdapter;->initMessage(Landroid/database/Cursor;)Lco/vine/android/api/VinePrivateMessage;

    move-result-object v28

    .line 292
    .local v28, "vpm":Lco/vine/android/api/VinePrivateMessage;
    invoke-virtual/range {p2 .. p2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v20

    .line 294
    .local v20, "res":Landroid/content/res/Resources;
    new-instance v15, Lco/vine/android/ConversationAdapter$1;

    move-object/from16 v0, p0

    move-object/from16 v1, v28

    invoke-direct {v15, v0, v1}, Lco/vine/android/ConversationAdapter$1;-><init>(Lco/vine/android/ConversationAdapter;Lco/vine/android/api/VinePrivateMessage;)V

    .line 302
    .local v15, "longClickListener":Landroid/view/View$OnLongClickListener;
    invoke-virtual/range {p1 .. p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v13

    check-cast v13, Lco/vine/android/ConversationAdapter$ConversationViewHolder;

    .line 304
    .local v13, "holder":Lco/vine/android/ConversationAdapter$ConversationViewHolder;
    move-object/from16 v0, p1

    invoke-virtual {v0, v15}, Landroid/view/View;->setOnLongClickListener(Landroid/view/View$OnLongClickListener;)V

    .line 306
    iget-object v4, v13, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->videoContainer:Landroid/view/View;

    invoke-virtual {v4, v15}, Landroid/view/View;->setOnLongClickListener(Landroid/view/View$OnLongClickListener;)V

    .line 307
    const/4 v4, 0x0

    iput-object v4, v13, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->avatarKey:Lco/vine/android/util/image/ImageKey;

    .line 308
    const/4 v4, 0x0

    iput-object v4, v13, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->videoImageKey:Lco/vine/android/util/image/ImageKey;

    .line 309
    move/from16 v0, v19

    iput v0, v13, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->position:I

    .line 311
    iget-object v4, v13, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->userImageProgressNormal:Landroid/view/View;

    if-eqz v4, :cond_0

    iget-object v4, v13, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->userImageProgressTop:Landroid/view/View;

    if-eqz v4, :cond_0

    .line 312
    iget-object v4, v13, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->userImageProgressTop:Landroid/view/View;

    const/16 v5, 0x8

    invoke-virtual {v4, v5}, Landroid/view/View;->setVisibility(I)V

    .line 313
    iget-object v4, v13, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->userImageProgressNormal:Landroid/view/View;

    const/16 v5, 0x8

    invoke-virtual {v4, v5}, Landroid/view/View;->setVisibility(I)V

    .line 316
    :cond_0
    move-object/from16 v0, p0

    iget-wide v4, v0, Lco/vine/android/ConversationAdapter;->mMyUserId:J

    move-object/from16 v0, v28

    iget-wide v0, v0, Lco/vine/android/api/VinePrivateMessage;->userId:J

    move-wide/from16 v29, v0

    cmp-long v4, v4, v29

    if-nez v4, :cond_e

    const/4 v6, 0x1

    .line 318
    .local v6, "isCurrentUser":Z
    :goto_0
    iput-boolean v6, v13, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->isCurrentUser:Z

    .line 320
    iget-object v4, v13, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->videoListener:Lco/vine/android/player/OnListVideoClickListener;

    move/from16 v0, v19

    invoke-virtual {v4, v0}, Lco/vine/android/player/OnListVideoClickListener;->setPosition(I)V

    .line 322
    move-object/from16 v0, p0

    move/from16 v1, v19

    move-object/from16 v2, p3

    move-object/from16 v3, v28

    invoke-direct {v0, v13, v1, v2, v3}, Lco/vine/android/ConversationAdapter;->invalidateTimestamp(Lco/vine/android/ConversationAdapter$ConversationViewHolder;ILandroid/database/Cursor;Lco/vine/android/api/VinePrivateMessage;)V

    .line 325
    if-eqz v6, :cond_f

    .line 326
    move-object/from16 v0, p0

    iget v7, v0, Lco/vine/android/ConversationAdapter;->mMyColor:I

    .line 331
    .local v7, "color":I
    :goto_1
    if-gtz v7, :cond_1

    .line 332
    sget v7, Lco/vine/android/Settings;->DEFAULT_PROFILE_COLOR:I

    .line 335
    :cond_1
    sget v4, Lco/vine/android/Settings;->DEFAULT_PROFILE_COLOR:I

    if-eq v7, v4, :cond_2

    if-gtz v7, :cond_3

    .line 336
    :cond_2
    const v4, 0xffffff

    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/ConversationAdapter;->mContext:Landroid/content/Context;

    invoke-virtual {v5}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    const v8, 0x7f090096

    invoke-virtual {v5, v8}, Landroid/content/res/Resources;->getColor(I)I

    move-result v5

    and-int v7, v4, v5

    .line 339
    :cond_3
    iput v7, v13, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->color:I

    .line 341
    move-object/from16 v0, v28

    iget-wide v4, v0, Lco/vine/android/api/VinePrivateMessage;->postId:J

    const-wide/16 v29, 0x0

    cmp-long v4, v4, v29

    if-lez v4, :cond_10

    const/4 v14, 0x1

    .line 343
    .local v14, "isSharedPost":Z
    :goto_2
    iput-boolean v14, v13, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->isSharedPost:Z

    .line 345
    move-object/from16 v0, p0

    move-object/from16 v1, v28

    invoke-direct {v0, v1}, Lco/vine/android/ConversationAdapter;->isMessageAlreadyVanished(Lco/vine/android/api/VinePrivateMessage;)Z

    move-result v25

    .line 348
    .local v25, "vanishedEphemeral":Z
    if-eqz v14, :cond_11

    move-object/from16 v0, v28

    iget-object v4, v0, Lco/vine/android/api/VinePrivateMessage;->videoUrl:Ljava/lang/String;

    if-eqz v4, :cond_4

    move-object/from16 v0, v28

    iget-object v4, v0, Lco/vine/android/api/VinePrivateMessage;->thumbnailUrl:Ljava/lang/String;

    if-eqz v4, :cond_4

    move-object/from16 v0, v28

    iget-object v4, v0, Lco/vine/android/api/VinePrivateMessage;->post:Lco/vine/android/api/VinePost;

    iget-object v4, v4, Lco/vine/android/api/VinePost;->username:Ljava/lang/String;

    if-nez v4, :cond_11

    :cond_4
    const/4 v9, 0x1

    .line 351
    .local v9, "deletedSharedPost":Z
    :goto_3
    move-object/from16 v0, v28

    iget-boolean v4, v0, Lco/vine/android/api/VinePrivateMessage;->hasVideo:Z

    if-nez v4, :cond_6

    move-object/from16 v0, v28

    iget-boolean v4, v0, Lco/vine/android/api/VinePrivateMessage;->ephemeral:Z

    if-eqz v4, :cond_5

    if-eqz v25, :cond_6

    :cond_5
    if-eqz v9, :cond_12

    :cond_6
    const/16 v22, 0x1

    .line 354
    .local v22, "showVideoContainer":Z
    :goto_4
    move-object/from16 v0, v28

    iget-object v4, v0, Lco/vine/android/api/VinePrivateMessage;->message:Ljava/lang/String;

    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-eqz v4, :cond_13

    const-string v16, ""

    .line 355
    .local v16, "message":Ljava/lang/String;
    :goto_5
    move-object/from16 v0, v28

    iget-boolean v4, v0, Lco/vine/android/api/VinePrivateMessage;->ephemeral:Z

    if-eqz v4, :cond_14

    if-eqz v25, :cond_14

    const/16 v21, 0x1

    .line 357
    .local v21, "showSecondaryMessageContainer":Z
    :goto_6
    if-eqz v22, :cond_7

    .line 358
    move-object/from16 v0, v28

    iget-boolean v4, v0, Lco/vine/android/api/VinePrivateMessage;->ephemeral:Z

    if-eqz v4, :cond_15

    .line 359
    iget-object v4, v13, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->vanishThumbnailOverlay:Landroid/view/View;

    const/4 v5, 0x0

    invoke-virtual {v4, v5}, Landroid/view/View;->setVisibility(I)V

    .line 365
    :cond_7
    :goto_7
    iget-object v4, v13, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->vanishTimerText:Landroid/widget/TextView;

    const/16 v5, 0x8

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setVisibility(I)V

    .line 367
    if-eqz v9, :cond_16

    .line 368
    iget-object v4, v13, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->videoImage:Landroid/widget/ImageView;

    sget-object v5, Landroid/widget/ImageView$ScaleType;->CENTER:Landroid/widget/ImageView$ScaleType;

    invoke-virtual {v4, v5}, Landroid/widget/ImageView;->setScaleType(Landroid/widget/ImageView$ScaleType;)V

    .line 369
    iget-object v4, v13, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->videoImage:Landroid/widget/ImageView;

    const v5, 0x7f09007f

    move-object/from16 v0, v20

    invoke-virtual {v0, v5}, Landroid/content/res/Resources;->getColor(I)I

    move-result v5

    invoke-virtual {v4, v5}, Landroid/widget/ImageView;->setBackgroundColor(I)V

    .line 375
    :goto_8
    move-object/from16 v0, v28

    iget-boolean v4, v0, Lco/vine/android/api/VinePrivateMessage;->ephemeral:Z

    if-eqz v4, :cond_19

    .line 376
    iget-object v4, v13, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->videoContainer:Landroid/view/View;

    const/4 v5, 0x0

    invoke-virtual {v4, v5}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 377
    iget-object v4, v13, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->messageContainer:Landroid/view/ViewGroup;

    const/16 v5, 0x8

    invoke-virtual {v4, v5}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 378
    iget v4, v13, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->position:I

    move-object/from16 v0, p0

    invoke-direct {v0, v4}, Lco/vine/android/ConversationAdapter;->getSeekInfo(I)Lco/vine/android/util/SeekInfoManager$SeekInfo;

    move-result-object v4

    if-nez v4, :cond_8

    .line 379
    iget-object v4, v13, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->vanishMessageContainer:Landroid/view/View;

    const/4 v5, 0x0

    invoke-virtual {v4, v5}, Landroid/view/View;->setVisibility(I)V

    .line 380
    iget-object v4, v13, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->vanishMessageOverlay:Landroid/widget/TextView;

    move-object/from16 v0, v16

    invoke-virtual {v4, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 381
    if-eqz v6, :cond_17

    .line 382
    iget-object v4, v13, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->vanishPlayButton:Landroid/view/View;

    const/16 v5, 0x8

    invoke-virtual {v4, v5}, Landroid/view/View;->setVisibility(I)V

    .line 387
    :cond_8
    :goto_9
    iget-object v5, v13, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->vanishUserImage:Landroid/widget/ImageView;

    move-object/from16 v0, v28

    iget v4, v0, Lco/vine/android/api/VinePrivateMessage;->errorCode:I

    if-eqz v4, :cond_18

    const/4 v4, 0x1

    :goto_a
    move-object/from16 v0, p0

    move-object/from16 v1, v28

    invoke-direct {v0, v1, v13, v5, v4}, Lco/vine/android/ConversationAdapter;->setupUserImageImage(Lco/vine/android/api/VinePrivateMessage;Lco/vine/android/ConversationAdapter$ConversationViewHolder;Landroid/widget/ImageView;Z)V

    .line 388
    iget-object v4, v13, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->topMessageContainer:Landroid/view/ViewGroup;

    const/16 v5, 0x8

    invoke-virtual {v4, v5}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 473
    :cond_9
    :goto_b
    if-eqz v9, :cond_27

    const/16 v23, 0x0

    .line 474
    .local v23, "thumbnailUrl":Ljava/lang/String;
    :goto_c
    if-eqz v23, :cond_28

    const/4 v4, 0x1

    :goto_d
    iput-boolean v4, v13, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->hasVideoImage:Z

    .line 475
    iget-boolean v4, v13, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->hasVideoImage:Z

    if-eqz v4, :cond_2b

    .line 476
    new-instance v26, Lco/vine/android/util/image/ImageKey;

    move-object/from16 v0, v26

    move-object/from16 v1, v23

    invoke-direct {v0, v1}, Lco/vine/android/util/image/ImageKey;-><init>(Ljava/lang/String;)V

    .line 477
    .local v26, "videoImageKey":Lco/vine/android/util/image/ImageKey;
    move-object/from16 v0, v26

    iput-object v0, v13, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->videoImageKey:Lco/vine/android/util/image/ImageKey;

    .line 478
    move-object/from16 v0, p0

    iget-object v4, v0, Lco/vine/android/ConversationAdapter;->mThumbnails:Landroid/util/SparseArray;

    move/from16 v0, v19

    invoke-virtual {v4, v0}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v27

    check-cast v27, Landroid/graphics/Bitmap;

    .line 479
    .local v27, "videoThumbnail":Landroid/graphics/Bitmap;
    if-eqz v27, :cond_29

    .line 480
    const-string v4, "setting thumbnail for {}"

    invoke-static/range {v19 .. v19}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 481
    iget-object v4, v13, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->videoImage:Landroid/widget/ImageView;

    move-object/from16 v0, p0

    move-object/from16 v1, v27

    invoke-direct {v0, v4, v1, v13}, Lco/vine/android/ConversationAdapter;->setImage(Landroid/widget/ImageView;Landroid/graphics/Bitmap;Lco/vine/android/ConversationAdapter$ConversationViewHolder;)Z

    move-result v4

    iput-boolean v4, v13, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->isVideoImageLoaded:Z

    .line 490
    :goto_e
    iget-object v4, v13, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->loadImage:Landroid/view/View;

    const/16 v5, 0x8

    invoke-virtual {v4, v5}, Landroid/view/View;->setVisibility(I)V

    .line 501
    .end local v26    # "videoImageKey":Lco/vine/android/util/image/ImageKey;
    .end local v27    # "videoThumbnail":Landroid/graphics/Bitmap;
    :cond_a
    :goto_f
    const/16 v24, 0x0

    .line 503
    .local v24, "vanishedAlreadyInBindView":Z
    if-eqz v22, :cond_30

    .line 504
    iget-object v4, v13, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->videoContainer:Landroid/view/View;

    const/4 v5, 0x0

    invoke-virtual {v4, v5}, Landroid/view/View;->setVisibility(I)V

    .line 505
    iget-object v4, v13, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->nibsChatNib:Landroid/view/View;

    const/4 v5, 0x4

    invoke-virtual {v4, v5}, Landroid/view/View;->setVisibility(I)V

    .line 506
    move-object/from16 v0, p0

    move/from16 v1, v19

    invoke-direct {v0, v1}, Lco/vine/android/ConversationAdapter;->shouldShowThumbnail(I)Z

    move-result v4

    if-eqz v4, :cond_b

    iget-object v4, v13, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->videoView:Lco/vine/android/player/SdkVideoView;

    invoke-virtual {v4}, Lco/vine/android/player/SdkVideoView;->getPlayingPosition()I

    move-result v4

    move/from16 v0, v19

    if-eq v4, v0, :cond_b

    .line 507
    iget-object v4, v13, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->videoView:Lco/vine/android/player/SdkVideoView;

    const/4 v5, 0x4

    invoke-virtual {v4, v5}, Lco/vine/android/player/SdkVideoView;->setVisibility(I)V

    .line 509
    :cond_b
    move-object/from16 v0, p0

    move/from16 v1, v19

    invoke-direct {v0, v1, v13}, Lco/vine/android/ConversationAdapter;->initVideoView(ILco/vine/android/ConversationAdapter$ConversationViewHolder;)V

    .line 510
    iget-object v5, v13, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->nibs:Landroid/view/View;

    if-eqz v14, :cond_2e

    const/16 v4, 0x8

    :goto_10
    invoke-virtual {v5, v4}, Landroid/view/View;->setVisibility(I)V

    .line 511
    iget-object v5, v13, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->postNibs:Landroid/view/View;

    if-eqz v14, :cond_2f

    const/4 v4, 0x0

    :goto_11
    invoke-virtual {v5, v4}, Landroid/view/View;->setVisibility(I)V

    .line 523
    :cond_c
    :goto_12
    if-eqz v21, :cond_31

    .line 524
    if-nez v24, :cond_d

    .line 525
    iget-object v4, v13, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->videoView:Lco/vine/android/player/SdkVideoView;

    move-object/from16 v0, p0

    move-object/from16 v1, v28

    invoke-direct {v0, v1, v13, v4}, Lco/vine/android/ConversationAdapter;->vanishView(Lco/vine/android/api/VinePrivateMessage;Lco/vine/android/ConversationAdapter$ConversationViewHolder;Lco/vine/android/player/VideoViewInterface;)V

    .line 531
    :cond_d
    :goto_13
    iget-object v4, v13, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->vanishThumbnailOverlay:Landroid/view/View;

    const/high16 v5, -0x2e000000

    iget v8, v13, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->color:I

    or-int/2addr v5, v8

    invoke-virtual {v4, v5}, Landroid/view/View;->setBackgroundColor(I)V

    .line 533
    invoke-interface/range {p3 .. p3}, Landroid/database/Cursor;->getPosition()I

    move-result v4

    invoke-interface/range {p3 .. p3}, Landroid/database/Cursor;->getCount()I

    move-result v5

    add-int/lit8 v5, v5, -0x1

    if-ne v4, v5, :cond_32

    .line 534
    iget-object v4, v13, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->bottomPaddingView:Landroid/view/View;

    const/4 v5, 0x0

    invoke-virtual {v4, v5}, Landroid/view/View;->setVisibility(I)V

    .line 538
    :goto_14
    iget-object v4, v13, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->videoView:Lco/vine/android/player/SdkVideoView;

    move-object/from16 v0, p0

    iget-boolean v5, v0, Lco/vine/android/ConversationAdapter;->mMuted:Z

    invoke-virtual {v4, v5}, Lco/vine/android/player/SdkVideoView;->setMute(Z)V

    .line 539
    return-void

    .line 316
    .end local v6    # "isCurrentUser":Z
    .end local v7    # "color":I
    .end local v9    # "deletedSharedPost":Z
    .end local v14    # "isSharedPost":Z
    .end local v16    # "message":Ljava/lang/String;
    .end local v21    # "showSecondaryMessageContainer":Z
    .end local v22    # "showVideoContainer":Z
    .end local v23    # "thumbnailUrl":Ljava/lang/String;
    .end local v24    # "vanishedAlreadyInBindView":Z
    .end local v25    # "vanishedEphemeral":Z
    :cond_e
    const/4 v6, 0x0

    goto/16 :goto_0

    .line 328
    .restart local v6    # "isCurrentUser":Z
    :cond_f
    const/16 v4, 0x19

    move-object/from16 v0, p3

    invoke-interface {v0, v4}, Landroid/database/Cursor;->getInt(I)I

    move-result v7

    .restart local v7    # "color":I
    goto/16 :goto_1

    .line 341
    :cond_10
    const/4 v14, 0x0

    goto/16 :goto_2

    .line 348
    .restart local v14    # "isSharedPost":Z
    .restart local v25    # "vanishedEphemeral":Z
    :cond_11
    const/4 v9, 0x0

    goto/16 :goto_3

    .line 351
    .restart local v9    # "deletedSharedPost":Z
    :cond_12
    const/16 v22, 0x0

    goto/16 :goto_4

    .line 354
    .restart local v22    # "showVideoContainer":Z
    :cond_13
    move-object/from16 v0, v28

    iget-object v0, v0, Lco/vine/android/api/VinePrivateMessage;->message:Ljava/lang/String;

    move-object/from16 v16, v0

    goto/16 :goto_5

    .line 355
    .restart local v16    # "message":Ljava/lang/String;
    :cond_14
    const/16 v21, 0x0

    goto/16 :goto_6

    .line 361
    .restart local v21    # "showSecondaryMessageContainer":Z
    :cond_15
    iget-object v4, v13, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->vanishThumbnailOverlay:Landroid/view/View;

    const/16 v5, 0x8

    invoke-virtual {v4, v5}, Landroid/view/View;->setVisibility(I)V

    goto/16 :goto_7

    .line 371
    :cond_16
    iget-object v4, v13, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->videoImage:Landroid/widget/ImageView;

    sget-object v5, Landroid/widget/ImageView$ScaleType;->FIT_XY:Landroid/widget/ImageView$ScaleType;

    invoke-virtual {v4, v5}, Landroid/widget/ImageView;->setScaleType(Landroid/widget/ImageView$ScaleType;)V

    .line 372
    iget-object v4, v13, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->videoImage:Landroid/widget/ImageView;

    const v5, 0x106000d

    move-object/from16 v0, v20

    invoke-virtual {v0, v5}, Landroid/content/res/Resources;->getColor(I)I

    move-result v5

    invoke-virtual {v4, v5}, Landroid/widget/ImageView;->setBackgroundColor(I)V

    goto/16 :goto_8

    .line 384
    :cond_17
    iget-object v4, v13, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->vanishPlayButton:Landroid/view/View;

    const/4 v5, 0x0

    invoke-virtual {v4, v5}, Landroid/view/View;->setVisibility(I)V

    goto/16 :goto_9

    .line 387
    :cond_18
    const/4 v4, 0x0

    goto/16 :goto_a

    .line 390
    :cond_19
    if-eqz v9, :cond_1a

    .line 391
    iget-object v4, v13, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->videoContainer:Landroid/view/View;

    const/4 v5, 0x0

    invoke-virtual {v4, v5}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 392
    iget-object v4, v13, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->videoImage:Landroid/widget/ImageView;

    const v5, 0x7f02006e

    invoke-virtual {v4, v5}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 397
    :goto_15
    iget-object v4, v13, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->vanishMessageContainer:Landroid/view/View;

    const/16 v5, 0x8

    invoke-virtual {v4, v5}, Landroid/view/View;->setVisibility(I)V

    .line 398
    iget-object v4, v13, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->messageContainer:Landroid/view/ViewGroup;

    const/4 v5, 0x0

    invoke-virtual {v4, v5}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 399
    iget-object v4, v13, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->postMessageContainer:Landroid/view/ViewGroup;

    const/16 v5, 0x8

    invoke-virtual {v4, v5}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 400
    iget-object v0, v13, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->messageContainerMessage:Landroid/widget/TextView;

    move-object/from16 v17, v0

    .line 401
    .local v17, "messageContainerMessage":Landroid/widget/TextView;
    if-eqz v14, :cond_1f

    .line 402
    iget-object v4, v13, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->messageContainer:Landroid/view/ViewGroup;

    const/16 v5, 0x8

    invoke-virtual {v4, v5}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 403
    iget-object v4, v13, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->postMessageContainer:Landroid/view/ViewGroup;

    const/4 v5, 0x0

    invoke-virtual {v4, v5}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 404
    iget-object v4, v13, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->topMessageContainer:Landroid/view/ViewGroup;

    const/4 v5, 0x0

    invoke-virtual {v4, v5}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 405
    iget-object v4, v13, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->topMessageContainerUserImage:Landroid/widget/ImageView;

    move-object/from16 v0, p0

    move/from16 v1, v19

    invoke-direct {v0, v1, v4, v6}, Lco/vine/android/ConversationAdapter;->setupUserImageProperties(ILandroid/widget/ImageView;Z)V

    .line 406
    iget-object v5, v13, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->topMessageContainerUserImage:Landroid/widget/ImageView;

    move-object/from16 v0, v28

    iget v4, v0, Lco/vine/android/api/VinePrivateMessage;->errorCode:I

    if-eqz v4, :cond_1b

    const/4 v4, 0x1

    :goto_16
    move-object/from16 v0, p0

    move-object/from16 v1, v28

    invoke-direct {v0, v1, v13, v5, v4}, Lco/vine/android/ConversationAdapter;->setupUserImageImage(Lco/vine/android/api/VinePrivateMessage;Lco/vine/android/ConversationAdapter$ConversationViewHolder;Landroid/widget/ImageView;Z)V

    .line 407
    iget-object v5, v13, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->topMessageContainerMessage:Landroid/widget/TextView;

    if-eqz v6, :cond_1c

    const/4 v4, 0x5

    :goto_17
    or-int/lit8 v4, v4, 0x10

    invoke-virtual {v5, v4}, Landroid/widget/TextView;->setGravity(I)V

    .line 408
    iget-object v4, v13, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->topMessageContainerMessage:Landroid/widget/TextView;

    invoke-virtual {v4}, Landroid/widget/TextView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v18

    check-cast v18, Landroid/widget/RelativeLayout$LayoutParams;

    .line 409
    .local v18, "params":Landroid/widget/RelativeLayout$LayoutParams;
    if-eqz v6, :cond_1d

    move-object/from16 v0, p0

    iget v4, v0, Lco/vine/android/ConversationAdapter;->mAvatarMargin:F

    float-to-int v4, v4

    :goto_18
    move-object/from16 v0, v18

    iput v4, v0, Landroid/widget/RelativeLayout$LayoutParams;->rightMargin:I

    .line 410
    if-eqz v6, :cond_1e

    const/4 v4, 0x0

    :goto_19
    move-object/from16 v0, v18

    iput v4, v0, Landroid/widget/RelativeLayout$LayoutParams;->leftMargin:I

    .line 411
    move-object/from16 v0, v28

    iget-object v5, v0, Lco/vine/android/api/VinePrivateMessage;->post:Lco/vine/android/api/VinePost;

    iget-object v8, v13, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->topMessageContainerMessage:Landroid/widget/TextView;

    move-object/from16 v4, p0

    invoke-direct/range {v4 .. v9}, Lco/vine/android/ConversationAdapter;->styleTopSharedDescription(Lco/vine/android/api/VinePost;ZILandroid/widget/TextView;Z)V

    .line 412
    iget-object v4, v13, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->postMessageContainerMessage:Landroid/widget/TextView;

    move-object/from16 v0, v28

    iget-object v5, v0, Lco/vine/android/api/VinePrivateMessage;->post:Lco/vine/android/api/VinePost;

    move-object/from16 v0, p0

    invoke-direct {v0, v4, v5, v7, v9}, Lco/vine/android/ConversationAdapter;->styleDescription(Landroid/widget/TextView;Lco/vine/android/api/VinePost;IZ)V

    .line 413
    iget-object v4, v13, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->postMessageContainerMessage:Landroid/widget/TextView;

    const/high16 v5, -0x1000000

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setTextColor(I)V

    .line 414
    iget-object v4, v13, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->postMessageContainerMessage:Landroid/widget/TextView;

    const/4 v5, 0x0

    move-object/from16 v0, p0

    iget v8, v0, Lco/vine/android/ConversationAdapter;->mSharedDescSize:F

    invoke-virtual {v4, v5, v8}, Landroid/widget/TextView;->setTextSize(IF)V

    .line 415
    iget-object v4, v13, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->postMessageContainerMessage:Landroid/widget/TextView;

    const/4 v5, 0x0

    invoke-static {v4, v5}, Lco/vine/android/util/ViewUtil;->setBackground(Landroid/view/View;Landroid/graphics/drawable/Drawable;)V

    goto/16 :goto_b

    .line 394
    .end local v17    # "messageContainerMessage":Landroid/widget/TextView;
    .end local v18    # "params":Landroid/widget/RelativeLayout$LayoutParams;
    :cond_1a
    iget-object v4, v13, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->videoContainer:Landroid/view/View;

    iget-object v5, v13, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->videoListener:Lco/vine/android/player/OnListVideoClickListener;

    invoke-virtual {v4, v5}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 395
    iget-object v4, v13, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->videoImage:Landroid/widget/ImageView;

    const/4 v5, 0x0

    invoke-virtual {v4, v5}, Landroid/widget/ImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    goto/16 :goto_15

    .line 406
    .restart local v17    # "messageContainerMessage":Landroid/widget/TextView;
    :cond_1b
    const/4 v4, 0x0

    goto :goto_16

    .line 407
    :cond_1c
    const/4 v4, 0x3

    goto :goto_17

    .line 409
    .restart local v18    # "params":Landroid/widget/RelativeLayout$LayoutParams;
    :cond_1d
    const/4 v4, 0x0

    goto :goto_18

    .line 410
    :cond_1e
    move-object/from16 v0, p0

    iget v4, v0, Lco/vine/android/ConversationAdapter;->mAvatarMargin:F

    float-to-int v4, v4

    goto :goto_19

    .line 417
    .end local v18    # "params":Landroid/widget/RelativeLayout$LayoutParams;
    :cond_1f
    move-object/from16 v0, v17

    move-object/from16 v1, v16

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 418
    iget-object v4, v13, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->messageContainerUserImage:Landroid/widget/ImageView;

    move-object/from16 v0, p0

    move/from16 v1, v19

    invoke-direct {v0, v1, v4, v6}, Lco/vine/android/ConversationAdapter;->setupUserImageProperties(ILandroid/widget/ImageView;Z)V

    .line 419
    iget-object v5, v13, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->messageContainerUserImage:Landroid/widget/ImageView;

    move-object/from16 v0, v28

    iget v4, v0, Lco/vine/android/api/VinePrivateMessage;->errorCode:I

    if-eqz v4, :cond_21

    const/4 v4, 0x1

    :goto_1a
    move-object/from16 v0, p0

    move-object/from16 v1, v28

    invoke-direct {v0, v1, v13, v5, v4}, Lco/vine/android/ConversationAdapter;->setupUserImageImage(Lco/vine/android/api/VinePrivateMessage;Lco/vine/android/ConversationAdapter$ConversationViewHolder;Landroid/widget/ImageView;Z)V

    .line 420
    iget-object v4, v13, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->topMessageContainer:Landroid/view/ViewGroup;

    const/16 v5, 0x8

    invoke-virtual {v4, v5}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 421
    move-object/from16 v0, v28

    iget-object v4, v0, Lco/vine/android/api/VinePrivateMessage;->errorReason:Ljava/lang/String;

    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-eqz v4, :cond_25

    .line 422
    iget-object v4, v13, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->errorMessage:Landroid/widget/TextView;

    if-eqz v4, :cond_20

    .line 423
    iget-object v4, v13, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->errorMessage:Landroid/widget/TextView;

    const/16 v5, 0x8

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setVisibility(I)V

    .line 425
    :cond_20
    const/4 v4, 0x0

    move-object/from16 v0, v17

    invoke-virtual {v0, v4}, Landroid/widget/TextView;->setVisibility(I)V

    .line 426
    const/high16 v4, -0x1000000

    or-int/2addr v4, v7

    move-object/from16 v0, v17

    invoke-virtual {v0, v4}, Landroid/widget/TextView;->setTextColor(I)V

    .line 428
    invoke-static/range {v16 .. v16}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_24

    .line 429
    if-eqz v6, :cond_22

    .line 430
    const/high16 v4, 0x33000000

    or-int/2addr v4, v7

    const v5, 0x7f0200ed

    move-object/from16 v0, v20

    move-object/from16 v1, v17

    invoke-static {v0, v4, v5, v1}, Lco/vine/android/util/ViewUtil;->fillColor(Landroid/content/res/Resources;IILandroid/view/View;)V

    .line 432
    const/high16 v4, 0x33000000

    or-int/2addr v4, v7

    const v5, 0x7f020287

    iget-object v8, v13, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->nibsChatNib:Landroid/view/View;

    move-object/from16 v0, v20

    invoke-static {v0, v4, v5, v8}, Lco/vine/android/util/ViewUtil;->fillColor(Landroid/content/res/Resources;IILandroid/view/View;)V

    goto/16 :goto_b

    .line 419
    :cond_21
    const/4 v4, 0x0

    goto :goto_1a

    .line 435
    :cond_22
    move-object/from16 v0, p0

    iget v4, v0, Lco/vine/android/ConversationAdapter;->mMyColor:I

    if-eq v4, v7, :cond_23

    .line 436
    const/high16 v4, 0x33000000

    or-int/2addr v4, v7

    const v5, 0x7f0200ed

    move-object/from16 v0, v20

    move-object/from16 v1, v17

    invoke-static {v0, v4, v5, v1}, Lco/vine/android/util/ViewUtil;->fillColor(Landroid/content/res/Resources;IILandroid/view/View;)V

    .line 438
    const/high16 v4, 0x33000000

    or-int/2addr v4, v7

    const v5, 0x7f020288

    iget-object v8, v13, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->nibsChatNib:Landroid/view/View;

    move-object/from16 v0, v20

    invoke-static {v0, v4, v5, v8}, Lco/vine/android/util/ViewUtil;->fillColor(Landroid/content/res/Resources;IILandroid/view/View;)V

    goto/16 :goto_b

    .line 442
    :cond_23
    const/high16 v4, -0x1000000

    or-int/2addr v4, v7

    const v5, 0x7f0200ed

    move-object/from16 v0, v20

    move-object/from16 v1, v17

    invoke-static {v0, v4, v5, v1}, Lco/vine/android/util/ViewUtil;->fillColor(Landroid/content/res/Resources;IILandroid/view/View;)V

    .line 444
    const/high16 v4, -0x1000000

    or-int/2addr v4, v7

    const v5, 0x7f020288

    iget-object v8, v13, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->nibsChatNib:Landroid/view/View;

    move-object/from16 v0, v20

    invoke-static {v0, v4, v5, v8}, Lco/vine/android/util/ViewUtil;->fillColor(Landroid/content/res/Resources;IILandroid/view/View;)V

    .line 446
    const/4 v4, -0x1

    move-object/from16 v0, v17

    invoke-virtual {v0, v4}, Landroid/widget/TextView;->setTextColor(I)V

    goto/16 :goto_b

    .line 450
    :cond_24
    const/16 v4, 0x8

    move-object/from16 v0, v17

    invoke-virtual {v0, v4}, Landroid/widget/TextView;->setVisibility(I)V

    goto/16 :goto_b

    .line 453
    :cond_25
    invoke-static/range {v16 .. v16}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-eqz v4, :cond_26

    .line 454
    const/16 v4, 0x8

    move-object/from16 v0, v17

    invoke-virtual {v0, v4}, Landroid/widget/TextView;->setVisibility(I)V

    .line 465
    :goto_1b
    iget-object v4, v13, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->errorMessage:Landroid/widget/TextView;

    if-eqz v4, :cond_9

    .line 466
    iget-object v4, v13, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->errorMessage:Landroid/widget/TextView;

    const/4 v5, 0x0

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setVisibility(I)V

    .line 467
    iget-object v4, v13, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->errorMessage:Landroid/widget/TextView;

    move-object/from16 v0, v28

    iget-object v5, v0, Lco/vine/android/api/VinePrivateMessage;->errorReason:Ljava/lang/String;

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_b

    .line 456
    :cond_26
    const v4, 0x7f090081

    move-object/from16 v0, v20

    invoke-virtual {v0, v4}, Landroid/content/res/Resources;->getColor(I)I

    move-result v12

    .line 457
    .local v12, "grayTextColor":I
    const v4, 0x7f090080

    move-object/from16 v0, v20

    invoke-virtual {v0, v4}, Landroid/content/res/Resources;->getColor(I)I

    move-result v11

    .line 458
    .local v11, "grayBubbleColor":I
    const/4 v4, 0x0

    move-object/from16 v0, v17

    invoke-virtual {v0, v4}, Landroid/widget/TextView;->setVisibility(I)V

    .line 459
    move-object/from16 v0, v17

    invoke-virtual {v0, v12}, Landroid/widget/TextView;->setTextColor(I)V

    .line 460
    const v4, 0x7f0200ed

    move-object/from16 v0, v20

    move-object/from16 v1, v17

    invoke-static {v0, v11, v4, v1}, Lco/vine/android/util/ViewUtil;->fillColor(Landroid/content/res/Resources;IILandroid/view/View;)V

    .line 462
    const v4, 0x7f020287

    iget-object v5, v13, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->nibsChatNib:Landroid/view/View;

    move-object/from16 v0, v20

    invoke-static {v0, v11, v4, v5}, Lco/vine/android/util/ViewUtil;->fillColor(Landroid/content/res/Resources;IILandroid/view/View;)V

    goto :goto_1b

    .line 473
    .end local v11    # "grayBubbleColor":I
    .end local v12    # "grayTextColor":I
    .end local v17    # "messageContainerMessage":Landroid/widget/TextView;
    :cond_27
    move-object/from16 v0, v28

    iget-object v0, v0, Lco/vine/android/api/VinePrivateMessage;->thumbnailUrl:Ljava/lang/String;

    move-object/from16 v23, v0

    goto/16 :goto_c

    .line 474
    .restart local v23    # "thumbnailUrl":Ljava/lang/String;
    :cond_28
    const/4 v4, 0x0

    goto/16 :goto_d

    .line 483
    .restart local v26    # "videoImageKey":Lco/vine/android/util/image/ImageKey;
    .restart local v27    # "videoThumbnail":Landroid/graphics/Bitmap;
    :cond_29
    const-string v4, "fetching thumbnail for {}"

    invoke-static/range {v19 .. v19}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 484
    move-object/from16 v0, p0

    iget-object v4, v0, Lco/vine/android/ConversationAdapter;->mAppController:Lco/vine/android/client/AppController;

    move-object/from16 v0, v26

    invoke-virtual {v4, v0}, Lco/vine/android/client/AppController;->getPhotoBitmap(Lco/vine/android/util/image/ImageKey;)Landroid/graphics/Bitmap;

    move-result-object v10

    .line 485
    .local v10, "bitmap":Landroid/graphics/Bitmap;
    if-eqz v10, :cond_2a

    .line 486
    move-object/from16 v0, p0

    iget-object v4, v0, Lco/vine/android/ConversationAdapter;->mThumbnails:Landroid/util/SparseArray;

    move/from16 v0, v19

    invoke-virtual {v4, v0, v10}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    .line 488
    :cond_2a
    iget-object v4, v13, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->videoImage:Landroid/widget/ImageView;

    move-object/from16 v0, p0

    invoke-direct {v0, v4, v10, v13}, Lco/vine/android/ConversationAdapter;->setImage(Landroid/widget/ImageView;Landroid/graphics/Bitmap;Lco/vine/android/ConversationAdapter$ConversationViewHolder;)Z

    move-result v4

    iput-boolean v4, v13, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->isVideoImageLoaded:Z

    goto/16 :goto_e

    .line 492
    .end local v10    # "bitmap":Landroid/graphics/Bitmap;
    .end local v26    # "videoImageKey":Lco/vine/android/util/image/ImageKey;
    .end local v27    # "videoThumbnail":Landroid/graphics/Bitmap;
    :cond_2b
    move-object/from16 v0, v28

    iget-boolean v4, v0, Lco/vine/android/api/VinePrivateMessage;->ephemeral:Z

    if-nez v4, :cond_2c

    if-eqz v9, :cond_2d

    .line 493
    :cond_2c
    iget-object v4, v13, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->loadImage:Landroid/view/View;

    const/16 v5, 0x8

    invoke-virtual {v4, v5}, Landroid/view/View;->setVisibility(I)V

    goto/16 :goto_f

    .line 495
    :cond_2d
    if-nez v6, :cond_a

    .line 496
    iget-object v4, v13, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->loadImage:Landroid/view/View;

    const/4 v5, 0x0

    invoke-virtual {v4, v5}, Landroid/view/View;->setVisibility(I)V

    goto/16 :goto_f

    .line 510
    .restart local v24    # "vanishedAlreadyInBindView":Z
    :cond_2e
    const/4 v4, 0x0

    goto/16 :goto_10

    .line 511
    :cond_2f
    const/16 v4, 0x8

    goto/16 :goto_11

    .line 513
    :cond_30
    iget-object v4, v13, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->videoContainer:Landroid/view/View;

    const/16 v5, 0x8

    invoke-virtual {v4, v5}, Landroid/view/View;->setVisibility(I)V

    .line 514
    iget-object v4, v13, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->nibsChatNib:Landroid/view/View;

    const/4 v5, 0x0

    invoke-virtual {v4, v5}, Landroid/view/View;->setVisibility(I)V

    .line 515
    iget-object v4, v13, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->videoView:Lco/vine/android/player/SdkVideoView;

    invoke-virtual {v4, v13}, Lco/vine/android/player/SdkVideoView;->setTag(Ljava/lang/Object;)V

    .line 516
    move-object/from16 v0, p0

    iget-object v4, v0, Lco/vine/android/ConversationAdapter;->mPlayers:Landroid/util/SparseArray;

    move/from16 v0, v19

    invoke-virtual {v4, v0}, Landroid/util/SparseArray;->remove(I)V

    .line 517
    if-eqz v25, :cond_c

    .line 518
    iget-object v4, v13, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->videoView:Lco/vine/android/player/SdkVideoView;

    move-object/from16 v0, p0

    move-object/from16 v1, v28

    invoke-direct {v0, v1, v13, v4}, Lco/vine/android/ConversationAdapter;->vanishView(Lco/vine/android/api/VinePrivateMessage;Lco/vine/android/ConversationAdapter$ConversationViewHolder;Lco/vine/android/player/VideoViewInterface;)V

    .line 519
    const/16 v24, 0x1

    goto/16 :goto_12

    .line 528
    :cond_31
    iget-object v4, v13, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->secondaryMessageContainer:Landroid/view/View;

    const/16 v5, 0x8

    invoke-virtual {v4, v5}, Landroid/view/View;->setVisibility(I)V

    goto/16 :goto_13

    .line 536
    :cond_32
    iget-object v4, v13, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->bottomPaddingView:Landroid/view/View;

    const/16 v5, 0x8

    invoke-virtual {v4, v5}, Landroid/view/View;->setVisibility(I)V

    goto/16 :goto_14
.end method

.method public getIdAtLastPosition()J
    .locals 3

    .prologue
    .line 683
    invoke-virtual {p0}, Lco/vine/android/ConversationAdapter;->getCursor()Landroid/database/Cursor;

    move-result-object v0

    .line 684
    .local v0, "cursor":Landroid/database/Cursor;
    if-eqz v0, :cond_0

    .line 685
    invoke-interface {v0}, Landroid/database/Cursor;->moveToLast()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 686
    const/4 v1, 0x3

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v1

    .line 689
    :goto_0
    return-wide v1

    :cond_0
    const-wide/16 v1, -0x1

    goto :goto_0
.end method

.method public getItemId(I)J
    .locals 2
    .param p1, "pos"    # I

    .prologue
    .line 1222
    iget-object v0, p0, Lco/vine/android/ConversationAdapter;->mCursor:Landroid/database/Cursor;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/ConversationAdapter;->mCursor:Landroid/database/Cursor;

    invoke-interface {v0, p1}, Landroid/database/Cursor;->moveToPosition(I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1223
    iget-object v0, p0, Lco/vine/android/ConversationAdapter;->mCursor:Landroid/database/Cursor;

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v0

    .line 1225
    :goto_0
    return-wide v0

    :cond_0
    const-wide/16 v0, -0x1

    goto :goto_0
.end method

.method public getItemViewType(I)I
    .locals 5
    .param p1, "position"    # I

    .prologue
    .line 267
    invoke-virtual {p0, p1}, Lco/vine/android/ConversationAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/database/Cursor;

    .line 268
    .local v0, "c":Landroid/database/Cursor;
    iget-wide v1, p0, Lco/vine/android/ConversationAdapter;->mMyUserId:J

    const/4 v3, 0x3

    invoke-interface {v0, v3}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v3

    cmp-long v1, v1, v3

    if-nez v1, :cond_0

    .line 269
    const/4 v1, 0x1

    .line 271
    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public getLastPlayer()Lco/vine/android/player/SdkVideoView;
    .locals 1

    .prologue
    .line 1128
    iget-object v0, p0, Lco/vine/android/ConversationAdapter;->mLastPlayer:Lco/vine/android/player/SdkVideoView;

    return-object v0
.end method

.method public getPlayer(IZ)Lco/vine/android/player/SdkVideoView;
    .locals 1
    .param p1, "position"    # I
    .param p2, "b"    # Z

    .prologue
    .line 822
    iget-object v0, p0, Lco/vine/android/ConversationAdapter;->mPlayers:Landroid/util/SparseArray;

    invoke-virtual {v0, p1}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/player/SdkVideoView;

    return-object v0
.end method

.method public getPositionForId(J)I
    .locals 2
    .param p1, "id"    # J

    .prologue
    .line 1234
    iget-object v0, p0, Lco/vine/android/ConversationAdapter;->mIdToPositionMap:Ljava/util/HashMap;

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1235
    iget-object v0, p0, Lco/vine/android/ConversationAdapter;->mIdToPositionMap:Ljava/util/HashMap;

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    .line 1237
    :goto_0
    return v0

    :cond_0
    const/4 v0, -0x1

    goto :goto_0
.end method

.method public getViewTypeCount()I
    .locals 1

    .prologue
    .line 284
    const/4 v0, 0x2

    return v0
.end method

.method public newView(Landroid/content/Context;Landroid/database/Cursor;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 11
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "cursor"    # Landroid/database/Cursor;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    const/4 v5, 0x0

    const/high16 v10, 0x40000000    # 2.0f

    .line 162
    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v2

    .line 164
    .local v2, "layoutInflater":Landroid/view/LayoutInflater;
    const/4 v6, 0x3

    invoke-interface {p2, v6}, Landroid/database/Cursor;->getInt(I)I

    move-result v6

    int-to-long v6, v6

    iget-wide v8, p0, Lco/vine/android/ConversationAdapter;->mMyUserId:J

    cmp-long v6, v6, v8

    if-nez v6, :cond_0

    const/4 v1, 0x1

    .line 167
    .local v1, "isCurrentUser":Z
    :goto_0
    if-eqz v1, :cond_1

    .line 168
    const v6, 0x7f03005c

    invoke-virtual {v2, v6, p3, v5}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v4

    .line 173
    .local v4, "v":Landroid/view/View;
    :goto_1
    new-instance v0, Lco/vine/android/ConversationAdapter$ConversationViewHolder;

    invoke-direct {v0, v4}, Lco/vine/android/ConversationAdapter$ConversationViewHolder;-><init>(Landroid/view/View;)V

    .line 174
    .local v0, "holder":Lco/vine/android/ConversationAdapter$ConversationViewHolder;
    iget-object v6, v0, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->videoContainer:Landroid/view/View;

    invoke-virtual {v6, v5}, Landroid/view/View;->setVisibility(I)V

    .line 175
    new-instance v5, Lco/vine/android/drawable/ColoredOvalDrawable;

    invoke-direct {v5}, Lco/vine/android/drawable/ColoredOvalDrawable;-><init>()V

    iput-object v5, v0, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->timerOval:Lco/vine/android/drawable/ColoredOvalDrawable;

    .line 176
    iget-object v5, v0, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->vanishTimerText:Landroid/widget/TextView;

    iget-object v6, v0, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->timerOval:Lco/vine/android/drawable/ColoredOvalDrawable;

    invoke-static {v5, v6}, Lco/vine/android/util/ViewUtil;->setBackground(Landroid/view/View;Landroid/graphics/drawable/Drawable;)V

    .line 177
    new-instance v5, Lco/vine/android/ConversationAdapter$ConversationVideoClickedListener;

    invoke-direct {v5, p0}, Lco/vine/android/ConversationAdapter$ConversationVideoClickedListener;-><init>(Lco/vine/android/ConversationAdapter;)V

    iput-object v5, v0, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->videoListener:Lco/vine/android/player/OnListVideoClickListener;

    .line 178
    iget-object v5, v0, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->videoContainer:Landroid/view/View;

    invoke-virtual {v5}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v3

    .line 179
    .local v3, "params":Landroid/view/ViewGroup$LayoutParams;
    iget v5, p0, Lco/vine/android/ConversationAdapter;->mScreenWidth:I

    int-to-float v5, v5

    iget v6, p0, Lco/vine/android/ConversationAdapter;->mSidePadding:F

    mul-float/2addr v6, v10

    sub-float/2addr v5, v6

    float-to-int v5, v5

    iput v5, v3, Landroid/view/ViewGroup$LayoutParams;->height:I

    .line 180
    iget v5, p0, Lco/vine/android/ConversationAdapter;->mScreenWidth:I

    int-to-float v5, v5

    iget v6, p0, Lco/vine/android/ConversationAdapter;->mSidePadding:F

    mul-float/2addr v6, v10

    sub-float/2addr v5, v6

    float-to-int v5, v5

    iput v5, v3, Landroid/view/ViewGroup$LayoutParams;->width:I

    .line 181
    iget-object v5, v0, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->videoContainer:Landroid/view/View;

    invoke-virtual {v5, v3}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 182
    iget-object v5, v0, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->videoImage:Landroid/widget/ImageView;

    invoke-virtual {v5}, Landroid/widget/ImageView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v3

    .line 183
    iget v5, p0, Lco/vine/android/ConversationAdapter;->mScreenWidth:I

    int-to-float v5, v5

    iget v6, p0, Lco/vine/android/ConversationAdapter;->mSidePadding:F

    mul-float/2addr v6, v10

    sub-float/2addr v5, v6

    float-to-int v5, v5

    iput v5, v3, Landroid/view/ViewGroup$LayoutParams;->width:I

    .line 184
    iget v5, p0, Lco/vine/android/ConversationAdapter;->mScreenWidth:I

    int-to-float v5, v5

    iget v6, p0, Lco/vine/android/ConversationAdapter;->mSidePadding:F

    mul-float/2addr v6, v10

    sub-float/2addr v5, v6

    float-to-int v5, v5

    iput v5, v3, Landroid/view/ViewGroup$LayoutParams;->height:I

    .line 185
    new-instance v5, Lco/vine/android/ConversationAdapter$VanishPlayButtonListener;

    invoke-direct {v5, p0, v0}, Lco/vine/android/ConversationAdapter$VanishPlayButtonListener;-><init>(Lco/vine/android/ConversationAdapter;Lco/vine/android/ConversationAdapter$ConversationViewHolder;)V

    iput-object v5, v0, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->vanishPlayButtonListener:Lco/vine/android/ConversationAdapter$VanishPlayButtonListener;

    .line 186
    iget-object v5, v0, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->vanishPlayButton:Landroid/view/View;

    iget-object v6, v0, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->vanishPlayButtonListener:Lco/vine/android/ConversationAdapter$VanishPlayButtonListener;

    invoke-virtual {v5, v6}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 187
    iget-object v5, v0, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->videoImage:Landroid/widget/ImageView;

    invoke-virtual {v5, v3}, Landroid/widget/ImageView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 188
    iget-object v5, v0, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->messageContainerUserImage:Landroid/widget/ImageView;

    invoke-virtual {v5}, Landroid/widget/ImageView;->bringToFront()V

    .line 189
    invoke-virtual {v4, v0}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 190
    iget-object v5, p0, Lco/vine/android/ConversationAdapter;->mViewHolders:Ljava/util/ArrayList;

    new-instance v6, Ljava/lang/ref/WeakReference;

    invoke-direct {v6, v0}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    invoke-virtual {v5, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 191
    return-object v4

    .end local v0    # "holder":Lco/vine/android/ConversationAdapter$ConversationViewHolder;
    .end local v1    # "isCurrentUser":Z
    .end local v3    # "params":Landroid/view/ViewGroup$LayoutParams;
    .end local v4    # "v":Landroid/view/View;
    :cond_0
    move v1, v5

    .line 164
    goto/16 :goto_0

    .line 170
    .restart local v1    # "isCurrentUser":Z
    :cond_1
    const v6, 0x7f03005b

    invoke-virtual {v2, v6, p3, v5}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v4

    .restart local v4    # "v":Landroid/view/View;
    goto/16 :goto_1
.end method

.method public onClick(Landroid/view/View;)V
    .locals 5
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 1252
    invoke-virtual {p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v1

    .line 1253
    .local v1, "tag":Ljava/lang/Object;
    instance-of v3, v1, Ljava/lang/Integer;

    if-eqz v3, :cond_0

    .line 1254
    iget-object v3, p0, Lco/vine/android/ConversationAdapter;->mMessages:Landroid/util/SparseArray;

    check-cast v1, Ljava/lang/Integer;

    .end local v1    # "tag":Ljava/lang/Object;
    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v4

    invoke-virtual {v3, v4}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lco/vine/android/api/VinePrivateMessage;

    .line 1255
    .local v2, "vpm":Lco/vine/android/api/VinePrivateMessage;
    new-instance v0, Lco/vine/android/ConversationAdapter$7;

    invoke-direct {v0, p0, v2, p1}, Lco/vine/android/ConversationAdapter$7;-><init>(Lco/vine/android/ConversationAdapter;Lco/vine/android/api/VinePrivateMessage;Landroid/view/View;)V

    .line 1276
    .local v0, "retryRunnable":Ljava/lang/Runnable;
    iget v3, v2, Lco/vine/android/api/VinePrivateMessage;->errorCode:I

    const/16 v4, 0x268

    if-ne v3, v4, :cond_1

    .line 1277
    iget-object v3, p0, Lco/vine/android/ConversationAdapter;->mActivity:Lco/vine/android/ConversationActivity;

    invoke-virtual {v3, v0}, Lco/vine/android/ConversationActivity;->startPhoneConfirmation(Ljava/lang/Runnable;)V

    .line 1284
    .end local v0    # "retryRunnable":Ljava/lang/Runnable;
    .end local v2    # "vpm":Lco/vine/android/api/VinePrivateMessage;
    :cond_0
    :goto_0
    return-void

    .line 1279
    .restart local v0    # "retryRunnable":Ljava/lang/Runnable;
    .restart local v2    # "vpm":Lco/vine/android/api/VinePrivateMessage;
    :cond_1
    iget v3, v2, Lco/vine/android/api/VinePrivateMessage;->errorCode:I

    if-eqz v3, :cond_0

    .line 1280
    invoke-interface {v0}, Ljava/lang/Runnable;->run()V

    goto :goto_0
.end method

.method onLoadFinish(Lco/vine/android/ConversationAdapter$ConversationViewHolder;)V
    .locals 3
    .param p1, "holder"    # Lco/vine/android/ConversationAdapter$ConversationViewHolder;

    .prologue
    .line 1118
    iget-object v1, p0, Lco/vine/android/ConversationAdapter;->mMessages:Landroid/util/SparseArray;

    iget v2, p1, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->position:I

    invoke-virtual {v1, v2}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/api/VinePrivateMessage;

    .line 1119
    .local v0, "message":Lco/vine/android/api/VinePrivateMessage;
    if-eqz v0, :cond_0

    .line 1120
    iget-object v1, p1, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->videoView:Lco/vine/android/player/SdkVideoView;

    invoke-virtual {v1}, Lco/vine/android/player/SdkVideoView;->getVisibility()I

    move-result v1

    if-eqz v1, :cond_0

    .line 1121
    iget-object v1, p1, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->videoView:Lco/vine/android/player/SdkVideoView;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Lco/vine/android/player/SdkVideoView;->setVisibility(I)V

    .line 1124
    :cond_0
    return-void
.end method

.method public onPause()V
    .locals 7

    .prologue
    const/4 v6, 0x0

    .line 912
    iget-object v2, p0, Lco/vine/android/ConversationAdapter;->mBlurHandlerThread:Landroid/os/HandlerThread;

    if-eqz v2, :cond_1

    .line 913
    iget-object v2, p0, Lco/vine/android/ConversationAdapter;->mBlurHandlerThread:Landroid/os/HandlerThread;

    invoke-virtual {v2}, Landroid/os/HandlerThread;->getLooper()Landroid/os/Looper;

    move-result-object v0

    .line 914
    .local v0, "looper":Landroid/os/Looper;
    if-eqz v0, :cond_0

    .line 915
    invoke-virtual {v0}, Landroid/os/Looper;->quit()V

    .line 917
    :cond_0
    iput-object v6, p0, Lco/vine/android/ConversationAdapter;->mBlurHandlerThread:Landroid/os/HandlerThread;

    .line 919
    .end local v0    # "looper":Landroid/os/Looper;
    :cond_1
    iget-object v2, p0, Lco/vine/android/ConversationAdapter;->mLastPlayer:Lco/vine/android/player/SdkVideoView;

    if-eqz v2, :cond_2

    iget-object v2, p0, Lco/vine/android/ConversationAdapter;->mLastPlayer:Lco/vine/android/player/SdkVideoView;

    invoke-virtual {v2}, Lco/vine/android/player/SdkVideoView;->hasStarted()Z

    move-result v2

    if-eqz v2, :cond_2

    iget v2, p0, Lco/vine/android/ConversationAdapter;->mCurrentPlaying:I

    if-lez v2, :cond_2

    .line 920
    iget-object v2, p0, Lco/vine/android/ConversationAdapter;->mMessages:Landroid/util/SparseArray;

    iget v3, p0, Lco/vine/android/ConversationAdapter;->mCurrentPlaying:I

    invoke-virtual {v2, v3}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lco/vine/android/api/VinePrivateMessage;

    .line 921
    .local v1, "message":Lco/vine/android/api/VinePrivateMessage;
    if-eqz v1, :cond_2

    iget-wide v2, v1, Lco/vine/android/api/VinePrivateMessage;->userId:J

    iget-object v4, p0, Lco/vine/android/ConversationAdapter;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v4}, Lco/vine/android/client/AppController;->getActiveId()J

    move-result-wide v4

    cmp-long v2, v2, v4

    if-eqz v2, :cond_2

    iget-boolean v2, v1, Lco/vine/android/api/VinePrivateMessage;->ephemeral:Z

    if-eqz v2, :cond_2

    .line 922
    iget-object v2, p0, Lco/vine/android/ConversationAdapter;->mSeekInfoManager:Lco/vine/android/util/SeekInfoManager;

    iget-wide v3, v1, Lco/vine/android/api/VinePrivateMessage;->messageId:J

    invoke-virtual {v2, v3, v4}, Lco/vine/android/util/SeekInfoManager;->get(J)Lco/vine/android/util/SeekInfoManager$SeekInfo;

    move-result-object v2

    if-eqz v2, :cond_2

    .line 923
    const-string v2, "Vanishing onPause for {}."

    iget-wide v3, v1, Lco/vine/android/api/VinePrivateMessage;->messageId:J

    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/edisonwang/android/slog/SLog;->i(Ljava/lang/String;Ljava/lang/Object;)V

    .line 924
    invoke-direct {p0, v1}, Lco/vine/android/ConversationAdapter;->vanishMessage(Lco/vine/android/api/VinePrivateMessage;)V

    .line 928
    .end local v1    # "message":Lco/vine/android/api/VinePrivateMessage;
    :cond_2
    invoke-virtual {p0}, Lco/vine/android/ConversationAdapter;->stopCurrentPlayer()V

    .line 929
    invoke-direct {p0, v6}, Lco/vine/android/ConversationAdapter;->releaseOtherPlayers(Lco/vine/android/player/SdkVideoView;)V

    .line 930
    return-void
.end method

.method public onResume()V
    .locals 2

    .prologue
    .line 903
    new-instance v0, Landroid/os/HandlerThread;

    const-string v1, "blur-thread"

    invoke-direct {v0, v1}, Landroid/os/HandlerThread;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lco/vine/android/ConversationAdapter;->mBlurHandlerThread:Landroid/os/HandlerThread;

    .line 904
    iget-object v0, p0, Lco/vine/android/ConversationAdapter;->mBlurHandlerThread:Landroid/os/HandlerThread;

    invoke-virtual {v0}, Landroid/os/HandlerThread;->start()V

    .line 905
    new-instance v0, Landroid/os/Handler;

    iget-object v1, p0, Lco/vine/android/ConversationAdapter;->mBlurHandlerThread:Landroid/os/HandlerThread;

    invoke-virtual {v1}, Landroid/os/HandlerThread;->getLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    iput-object v0, p0, Lco/vine/android/ConversationAdapter;->mBlurHandler:Landroid/os/Handler;

    .line 906
    iget-object v0, p0, Lco/vine/android/ConversationAdapter;->mContext:Landroid/content/Context;

    invoke-static {v0}, Lco/vine/android/util/MuteUtil;->isMuted(Landroid/content/Context;)Z

    move-result v0

    iput-boolean v0, p0, Lco/vine/android/ConversationAdapter;->mMuted:Z

    .line 907
    invoke-virtual {p0}, Lco/vine/android/ConversationAdapter;->playCurrentPosition()V

    .line 908
    iget-object v0, p0, Lco/vine/android/ConversationAdapter;->mVineDateFormatter:Lco/vine/android/util/VineDateFormatter;

    invoke-virtual {v0}, Lco/vine/android/util/VineDateFormatter;->refreshDates()V

    .line 909
    return-void
.end method

.method public onVideoPathObtained(Ljava/util/HashMap;)V
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/HashMap",
            "<",
            "Lco/vine/android/util/video/VideoKey;",
            "Lco/vine/android/util/video/UrlVideo;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 804
    .local p1, "videos":Ljava/util/HashMap;, "Ljava/util/HashMap<Lco/vine/android/util/video/VideoKey;Lco/vine/android/util/video/UrlVideo;>;"
    invoke-virtual {p1}, Ljava/util/HashMap;->keySet()Ljava/util/Set;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lco/vine/android/util/video/VideoKey;

    .line 805
    .local v1, "key":Lco/vine/android/util/video/VideoKey;
    invoke-virtual {p1, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lco/vine/android/util/video/UrlVideo;

    .line 806
    .local v2, "video":Lco/vine/android/util/video/UrlVideo;
    invoke-virtual {v2}, Lco/vine/android/util/video/UrlVideo;->isValid()Z

    move-result v3

    if-eqz v3, :cond_0

    iget-object v3, p0, Lco/vine/android/ConversationAdapter;->mUrlReverse:Ljava/util/HashMap;

    invoke-virtual {v3, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    if-eqz v3, :cond_0

    .line 807
    iget-object v4, p0, Lco/vine/android/ConversationAdapter;->mPaths:Landroid/util/SparseArray;

    iget-object v3, p0, Lco/vine/android/ConversationAdapter;->mUrlReverse:Ljava/util/HashMap;

    invoke-virtual {v3, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Integer;

    invoke-virtual {v3}, Ljava/lang/Integer;->intValue()I

    move-result v3

    invoke-virtual {v2}, Lco/vine/android/util/video/UrlVideo;->getAbsolutePath()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v3, v5}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    .line 808
    iget-object v3, p0, Lco/vine/android/ConversationAdapter;->mUrlReverse:Ljava/util/HashMap;

    invoke-virtual {v3, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Integer;

    invoke-virtual {v3}, Ljava/lang/Integer;->intValue()I

    move-result v3

    iget v4, p0, Lco/vine/android/ConversationAdapter;->mShouldBePlaying:I

    if-ne v3, v4, :cond_0

    .line 809
    invoke-virtual {p0}, Lco/vine/android/ConversationAdapter;->playCurrentPosition()V

    goto :goto_0

    .line 813
    .end local v1    # "key":Lco/vine/android/util/video/VideoKey;
    .end local v2    # "video":Lco/vine/android/util/video/UrlVideo;
    :cond_1
    return-void
.end method

.method public pauseCurrentPlayer()V
    .locals 1

    .prologue
    .line 827
    invoke-direct {p0}, Lco/vine/android/ConversationAdapter;->hasPlayerPlaying()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 828
    iget-object v0, p0, Lco/vine/android/ConversationAdapter;->mLastPlayer:Lco/vine/android/player/SdkVideoView;

    invoke-virtual {v0}, Lco/vine/android/player/SdkVideoView;->pause()V

    .line 830
    :cond_0
    return-void
.end method

.method public declared-synchronized play(I)V
    .locals 7
    .param p1, "requestedPosition"    # I

    .prologue
    .line 693
    monitor-enter p0

    :try_start_0
    const-string v5, "Play {} requested."

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 694
    iget-object v5, p0, Lco/vine/android/ConversationAdapter;->mPaths:Landroid/util/SparseArray;

    invoke-virtual {v5, p1}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v5

    if-eqz v5, :cond_1

    .line 695
    const/4 v5, 0x1

    invoke-virtual {p0, p1, v5}, Lco/vine/android/ConversationAdapter;->playFile(IZ)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 720
    :cond_0
    :goto_0
    monitor-exit p0

    return-void

    .line 696
    :cond_1
    :try_start_1
    iget-object v5, p0, Lco/vine/android/ConversationAdapter;->mMessages:Landroid/util/SparseArray;

    invoke-virtual {v5, p1}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v5

    if-eqz v5, :cond_0

    .line 697
    iget-object v5, p0, Lco/vine/android/ConversationAdapter;->mMessages:Landroid/util/SparseArray;

    invoke-virtual {v5, p1}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/api/VinePrivateMessage;

    .line 698
    .local v4, "vpm":Lco/vine/android/api/VinePrivateMessage;
    new-instance v3, Lco/vine/android/util/video/VideoKey;

    iget-object v5, v4, Lco/vine/android/api/VinePrivateMessage;->videoUrl:Ljava/lang/String;

    invoke-direct {v3, v5}, Lco/vine/android/util/video/VideoKey;-><init>(Ljava/lang/String;)V

    .line 699
    .local v3, "videoKey":Lco/vine/android/util/video/VideoKey;
    iget-object v5, p0, Lco/vine/android/ConversationAdapter;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v5, v3}, Lco/vine/android/client/AppController;->getVideoFilePath(Lco/vine/android/util/video/VideoKey;)Ljava/lang/String;

    move-result-object v1

    .line 700
    .local v1, "path":Ljava/lang/String;
    if-eqz v1, :cond_2

    .line 701
    iget-object v5, p0, Lco/vine/android/ConversationAdapter;->mPaths:Landroid/util/SparseArray;

    invoke-virtual {v5, p1, v1}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    .line 702
    const-string v5, "playing file at position {}"

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 703
    const/4 v5, 0x1

    invoke-virtual {p0, p1, v5}, Lco/vine/android/ConversationAdapter;->playFile(IZ)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 693
    .end local v1    # "path":Ljava/lang/String;
    .end local v3    # "videoKey":Lco/vine/android/util/video/VideoKey;
    .end local v4    # "vpm":Lco/vine/android/api/VinePrivateMessage;
    :catchall_0
    move-exception v5

    monitor-exit p0

    throw v5

    .line 705
    .restart local v1    # "path":Ljava/lang/String;
    .restart local v3    # "videoKey":Lco/vine/android/util/video/VideoKey;
    .restart local v4    # "vpm":Lco/vine/android/api/VinePrivateMessage;
    :cond_2
    :try_start_2
    invoke-direct {p0, p1}, Lco/vine/android/ConversationAdapter;->getViewAt(I)Landroid/view/View;

    move-result-object v0

    .line 706
    .local v0, "currentView":Landroid/view/View;
    if-eqz v0, :cond_3

    .line 707
    invoke-virtual {v0}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lco/vine/android/ConversationAdapter$ConversationViewHolder;

    .line 708
    .local v2, "tag":Lco/vine/android/ConversationAdapter$ConversationViewHolder;
    if-eqz v2, :cond_3

    .line 709
    iget-object v5, v2, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->vanishMessageContainer:Landroid/view/View;

    invoke-virtual {v5}, Landroid/view/View;->getVisibility()I

    move-result v5

    if-eqz v5, :cond_0

    .line 712
    iget-object v5, v2, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->loadImage:Landroid/view/View;

    const/4 v6, 0x0

    invoke-virtual {v5, v6}, Landroid/view/View;->setVisibility(I)V

    .line 716
    .end local v2    # "tag":Lco/vine/android/ConversationAdapter$ConversationViewHolder;
    :cond_3
    iput p1, p0, Lco/vine/android/ConversationAdapter;->mShouldBePlaying:I

    .line 717
    iget-object v5, p0, Lco/vine/android/ConversationAdapter;->mUrlReverse:Ljava/util/HashMap;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-virtual {v5, v3, v6}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_0
.end method

.method public declared-synchronized playCurrentPosition()V
    .locals 4

    .prologue
    .line 816
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lco/vine/android/ConversationAdapter;->mHandler:Landroid/os/Handler;

    iget-object v1, p0, Lco/vine/android/ConversationAdapter;->mPlayCurrentPositionRunnable:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 817
    iget-object v0, p0, Lco/vine/android/ConversationAdapter;->mHandler:Landroid/os/Handler;

    iget-object v1, p0, Lco/vine/android/ConversationAdapter;->mPlayCurrentPositionRunnable:Ljava/lang/Runnable;

    const-wide/16 v2, 0x32

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 818
    monitor-exit p0

    return-void

    .line 816
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public playFile(IZ)V
    .locals 8
    .param p1, "position"    # I
    .param p2, "isVideoLoaded"    # Z

    .prologue
    .line 724
    if-gez p1, :cond_1

    .line 776
    :cond_0
    :goto_0
    return-void

    .line 727
    :cond_1
    invoke-direct {p0, p1}, Lco/vine/android/ConversationAdapter;->getViewAt(I)Landroid/view/View;

    move-result-object v1

    .line 728
    .local v1, "currentView":Landroid/view/View;
    if-nez v1, :cond_2

    .line 729
    const-string v6, "Item is not visible: {}"

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    invoke-static {v6, v7}, Lcom/edisonwang/android/slog/SLog;->i(Ljava/lang/String;Ljava/lang/Object;)V

    goto :goto_0

    .line 732
    :cond_2
    invoke-virtual {v1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lco/vine/android/ConversationAdapter$ConversationViewHolder;

    .line 733
    .local v2, "holder":Lco/vine/android/ConversationAdapter$ConversationViewHolder;
    if-eqz v2, :cond_0

    .line 737
    iget-object v6, v2, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->vanishMessageContainer:Landroid/view/View;

    invoke-virtual {v6}, Landroid/view/View;->getVisibility()I

    move-result v6

    if-nez v6, :cond_3

    .line 738
    const-string v6, "No AutoPlay for Ephemeral."

    invoke-static {v6}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    goto :goto_0

    .line 742
    :cond_3
    iget-object v6, p0, Lco/vine/android/ConversationAdapter;->mPaths:Landroid/util/SparseArray;

    invoke-virtual {v6, p1}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    .line 743
    .local v4, "newPath":Ljava/lang/String;
    iget-object v6, v2, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->videoView:Lco/vine/android/player/SdkVideoView;

    invoke-virtual {v6}, Lco/vine/android/player/SdkVideoView;->getPath()Ljava/lang/String;

    move-result-object v5

    .line 744
    .local v5, "oldPath":Ljava/lang/String;
    if-eqz v4, :cond_0

    .line 745
    invoke-virtual {p0}, Lco/vine/android/ConversationAdapter;->pauseCurrentPlayer()V

    .line 747
    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-nez v6, :cond_4

    .line 748
    invoke-direct {p0, p1, v2}, Lco/vine/android/ConversationAdapter;->refreshVideoView(ILco/vine/android/ConversationAdapter$ConversationViewHolder;)V

    .line 749
    iget-object v0, v2, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->videoView:Lco/vine/android/player/SdkVideoView;

    .line 750
    .local v0, "currentVideoView":Lco/vine/android/player/SdkVideoView;
    invoke-virtual {v0, v4}, Lco/vine/android/player/SdkVideoView;->setVideoPath(Ljava/lang/String;)V

    .line 751
    invoke-virtual {v0, p1}, Lco/vine/android/player/SdkVideoView;->setPlayingPosition(I)V

    .line 752
    invoke-virtual {v0, v2}, Lco/vine/android/player/SdkVideoView;->setTag(Ljava/lang/Object;)V

    .line 753
    iget-object v6, v2, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->videoListener:Lco/vine/android/player/OnListVideoClickListener;

    invoke-virtual {v6, p1}, Lco/vine/android/player/OnListVideoClickListener;->setPosition(I)V

    .line 772
    :goto_1
    iput p1, p0, Lco/vine/android/ConversationAdapter;->mCurrentPlaying:I

    .line 773
    iput-object v0, p0, Lco/vine/android/ConversationAdapter;->mLastPlayer:Lco/vine/android/player/SdkVideoView;

    .line 774
    iget-boolean v6, p0, Lco/vine/android/ConversationAdapter;->mMuted:Z

    invoke-virtual {v0, v6}, Lco/vine/android/player/SdkVideoView;->setMute(Z)V

    goto :goto_0

    .line 755
    .end local v0    # "currentVideoView":Lco/vine/android/player/SdkVideoView;
    :cond_4
    iget-object v0, v2, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->videoView:Lco/vine/android/player/SdkVideoView;

    .line 757
    .restart local v0    # "currentVideoView":Lco/vine/android/player/SdkVideoView;
    iget-object v6, p0, Lco/vine/android/ConversationAdapter;->mMessages:Landroid/util/SparseArray;

    invoke-virtual {v6, p1}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lco/vine/android/api/VinePrivateMessage;

    .line 758
    .local v3, "message":Lco/vine/android/api/VinePrivateMessage;
    if-eqz v3, :cond_5

    .line 759
    iget-boolean v6, v3, Lco/vine/android/api/VinePrivateMessage;->ephemeral:Z

    if-nez v6, :cond_5

    .line 760
    invoke-virtual {v0}, Lco/vine/android/player/SdkVideoView;->getVisibility()I

    move-result v6

    if-eqz v6, :cond_5

    .line 761
    const/4 v6, 0x0

    invoke-virtual {v0, v6}, Lco/vine/android/player/SdkVideoView;->setVisibility(I)V

    .line 765
    :cond_5
    invoke-virtual {v0, p1}, Lco/vine/android/player/SdkVideoView;->setPlayingPosition(I)V

    .line 766
    invoke-virtual {v0}, Lco/vine/android/player/SdkVideoView;->isInPlaybackState()Z

    move-result v6

    if-eqz v6, :cond_6

    invoke-virtual {v0, v4}, Lco/vine/android/player/SdkVideoView;->isPathPlaying(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_6

    .line 767
    invoke-virtual {v0}, Lco/vine/android/player/SdkVideoView;->start()V

    goto :goto_1

    .line 769
    :cond_6
    invoke-virtual {v0, v4}, Lco/vine/android/player/SdkVideoView;->setVideoPath(Ljava/lang/String;)V

    goto :goto_1
.end method

.method public setImages(Ljava/util/HashMap;)V
    .locals 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/HashMap",
            "<",
            "Lco/vine/android/util/image/ImageKey;",
            "Lco/vine/android/util/image/UrlImage;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 1168
    .local p1, "images":Ljava/util/HashMap;, "Ljava/util/HashMap<Lco/vine/android/util/image/ImageKey;Lco/vine/android/util/image/UrlImage;>;"
    new-instance v5, Ljava/util/ArrayList;

    invoke-direct {v5}, Ljava/util/ArrayList;-><init>()V

    .line 1170
    .local v5, "toRemove":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/ref/WeakReference<Lco/vine/android/ConversationAdapter$ConversationViewHolder;>;>;"
    iget-object v6, p0, Lco/vine/android/ConversationAdapter;->mViewHolders:Ljava/util/ArrayList;

    invoke-virtual {v6}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_4

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/ref/WeakReference;

    .line 1171
    .local v4, "ref":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/ConversationAdapter$ConversationViewHolder;>;"
    invoke-virtual {v4}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lco/vine/android/ConversationAdapter$ConversationViewHolder;

    .line 1172
    .local v1, "holder":Lco/vine/android/ConversationAdapter$ConversationViewHolder;
    if-nez v1, :cond_1

    .line 1173
    invoke-virtual {v5, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 1175
    :cond_1
    iget-object v6, v1, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->avatarKey:Lco/vine/android/util/image/ImageKey;

    if-eqz v6, :cond_2

    .line 1176
    iget-object v6, v1, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->avatarKey:Lco/vine/android/util/image/ImageKey;

    invoke-virtual {p1, v6}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lco/vine/android/util/image/UrlImage;

    .line 1177
    .local v3, "image":Lco/vine/android/util/image/UrlImage;
    if-eqz v3, :cond_2

    invoke-virtual {v3}, Lco/vine/android/util/image/UrlImage;->isValid()Z

    move-result v6

    if-eqz v6, :cond_2

    .line 1178
    iget-boolean v6, v1, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->isSharedPost:Z

    if-eqz v6, :cond_3

    .line 1179
    iget-object v6, v1, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->topMessageContainerUserImage:Landroid/widget/ImageView;

    iget-object v7, v3, Lco/vine/android/util/image/UrlImage;->bitmap:Landroid/graphics/Bitmap;

    invoke-direct {p0, v6, v7, v1}, Lco/vine/android/ConversationAdapter;->setImage(Landroid/widget/ImageView;Landroid/graphics/Bitmap;Lco/vine/android/ConversationAdapter$ConversationViewHolder;)Z

    .line 1186
    .end local v3    # "image":Lco/vine/android/util/image/UrlImage;
    :cond_2
    :goto_1
    iget-object v6, v1, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->videoImageKey:Lco/vine/android/util/image/ImageKey;

    if-eqz v6, :cond_0

    .line 1187
    iget-object v6, v1, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->videoImageKey:Lco/vine/android/util/image/ImageKey;

    invoke-virtual {p1, v6}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lco/vine/android/util/image/UrlImage;

    .line 1188
    .restart local v3    # "image":Lco/vine/android/util/image/UrlImage;
    if-eqz v3, :cond_0

    invoke-virtual {v3}, Lco/vine/android/util/image/UrlImage;->isValid()Z

    move-result v6

    if-eqz v6, :cond_0

    .line 1189
    iget-object v6, v1, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->videoImage:Landroid/widget/ImageView;

    iget-object v7, v3, Lco/vine/android/util/image/UrlImage;->bitmap:Landroid/graphics/Bitmap;

    invoke-direct {p0, v6, v7, v1}, Lco/vine/android/ConversationAdapter;->setImage(Landroid/widget/ImageView;Landroid/graphics/Bitmap;Lco/vine/android/ConversationAdapter$ConversationViewHolder;)Z

    move-result v6

    iput-boolean v6, v1, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->isVideoImageLoaded:Z

    .line 1190
    iget-object v6, p0, Lco/vine/android/ConversationAdapter;->mThumbnails:Landroid/util/SparseArray;

    iget-object v7, v1, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->videoListener:Lco/vine/android/player/OnListVideoClickListener;

    invoke-virtual {v7}, Lco/vine/android/player/OnListVideoClickListener;->getPosition()I

    move-result v7

    iget-object v8, v3, Lco/vine/android/util/image/UrlImage;->bitmap:Landroid/graphics/Bitmap;

    invoke-virtual {v6, v7, v8}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    .line 1191
    const-string v6, "Image found: {}."

    iget-object v7, v1, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->videoListener:Lco/vine/android/player/OnListVideoClickListener;

    invoke-virtual {v7}, Lco/vine/android/player/OnListVideoClickListener;->getPosition()I

    move-result v7

    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    invoke-static {v6, v7}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 1192
    invoke-virtual {p0}, Lco/vine/android/ConversationAdapter;->playCurrentPosition()V

    goto :goto_0

    .line 1181
    :cond_3
    iget-object v6, v1, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->messageContainerUserImage:Landroid/widget/ImageView;

    iget-object v7, v3, Lco/vine/android/util/image/UrlImage;->bitmap:Landroid/graphics/Bitmap;

    invoke-direct {p0, v6, v7, v1}, Lco/vine/android/ConversationAdapter;->setImage(Landroid/widget/ImageView;Landroid/graphics/Bitmap;Lco/vine/android/ConversationAdapter$ConversationViewHolder;)Z

    .line 1182
    iget-object v6, v1, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->vanishUserImage:Landroid/widget/ImageView;

    iget-object v7, v3, Lco/vine/android/util/image/UrlImage;->bitmap:Landroid/graphics/Bitmap;

    invoke-direct {p0, v6, v7, v1}, Lco/vine/android/ConversationAdapter;->setImage(Landroid/widget/ImageView;Landroid/graphics/Bitmap;Lco/vine/android/ConversationAdapter$ConversationViewHolder;)Z

    goto :goto_1

    .line 1197
    .end local v1    # "holder":Lco/vine/android/ConversationAdapter$ConversationViewHolder;
    .end local v3    # "image":Lco/vine/android/util/image/UrlImage;
    .end local v4    # "ref":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/ConversationAdapter$ConversationViewHolder;>;"
    :cond_4
    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_2
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_5

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/ref/WeakReference;

    .line 1198
    .local v0, "h":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/ConversationAdapter$ConversationViewHolder;>;"
    iget-object v6, p0, Lco/vine/android/ConversationAdapter;->mViewHolders:Ljava/util/ArrayList;

    invoke-virtual {v6, v0}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    goto :goto_2

    .line 1200
    .end local v0    # "h":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/ConversationAdapter$ConversationViewHolder;>;"
    :cond_5
    return-void
.end method

.method public stopCurrentPlayer()V
    .locals 1

    .prologue
    .line 837
    iget-object v0, p0, Lco/vine/android/ConversationAdapter;->mLastPlayer:Lco/vine/android/player/SdkVideoView;

    if-eqz v0, :cond_0

    .line 838
    iget-object v0, p0, Lco/vine/android/ConversationAdapter;->mLastPlayer:Lco/vine/android/player/SdkVideoView;

    invoke-virtual {v0}, Lco/vine/android/player/SdkVideoView;->suspend()V

    .line 839
    const/4 v0, 0x0

    iput-object v0, p0, Lco/vine/android/ConversationAdapter;->mLastPlayer:Lco/vine/android/player/SdkVideoView;

    .line 840
    const/4 v0, -0x1

    iput v0, p0, Lco/vine/android/ConversationAdapter;->mCurrentPlaying:I

    .line 842
    :cond_0
    return-void
.end method

.method public swapCursor(Landroid/database/Cursor;)Landroid/database/Cursor;
    .locals 4
    .param p1, "c"    # Landroid/database/Cursor;

    .prologue
    .line 1204
    invoke-super {p0, p1}, Landroid/support/v4/widget/CursorAdapter;->swapCursor(Landroid/database/Cursor;)Landroid/database/Cursor;

    move-result-object v0

    .line 1205
    .local v0, "oldCursor":Landroid/database/Cursor;
    iget-object v1, p0, Lco/vine/android/ConversationAdapter;->mIdToPositionMap:Ljava/util/HashMap;

    invoke-virtual {v1}, Ljava/util/HashMap;->clear()V

    .line 1206
    iget-object v1, p0, Lco/vine/android/ConversationAdapter;->mThumbnails:Landroid/util/SparseArray;

    invoke-virtual {v1}, Landroid/util/SparseArray;->clear()V

    .line 1207
    iget-object v1, p0, Lco/vine/android/ConversationAdapter;->mPaths:Landroid/util/SparseArray;

    invoke-virtual {v1}, Landroid/util/SparseArray;->clear()V

    .line 1208
    if-eqz p1, :cond_1

    invoke-interface {p1}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 1209
    invoke-interface {p1}, Landroid/database/Cursor;->getCount()I

    move-result v1

    add-int/lit8 v1, v1, -0x1

    iput v1, p0, Lco/vine/android/ConversationAdapter;->mSingleLoopPosition:I

    .line 1211
    :cond_0
    iget-object v1, p0, Lco/vine/android/ConversationAdapter;->mIdToPositionMap:Ljava/util/HashMap;

    const/4 v2, 0x0

    invoke-interface {p1, v2}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-interface {p1}, Landroid/database/Cursor;->getPosition()I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1213
    invoke-interface {p1}, Landroid/database/Cursor;->moveToNext()Z

    move-result v1

    if-nez v1, :cond_0

    .line 1217
    :goto_0
    return-object v0

    .line 1215
    :cond_1
    const/4 v1, -0x1

    iput v1, p0, Lco/vine/android/ConversationAdapter;->mSingleLoopPosition:I

    goto :goto_0
.end method

.method public toggleMute(Z)V
    .locals 3
    .param p1, "mute"    # Z

    .prologue
    .line 1431
    iput-boolean p1, p0, Lco/vine/android/ConversationAdapter;->mMuted:Z

    .line 1432
    const-string v1, "Mute state changed to muted? {}."

    invoke-static {p1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 1433
    invoke-virtual {p0}, Lco/vine/android/ConversationAdapter;->getLastPlayer()Lco/vine/android/player/SdkVideoView;

    move-result-object v0

    .line 1434
    .local v0, "lastPlayer":Lco/vine/android/player/SdkVideoView;
    if-eqz v0, :cond_0

    .line 1435
    iget-boolean v1, p0, Lco/vine/android/ConversationAdapter;->mMuted:Z

    invoke-virtual {v0, v1}, Lco/vine/android/player/SdkVideoView;->setMute(Z)V

    .line 1437
    :cond_0
    return-void
.end method
