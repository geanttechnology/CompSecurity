.class public Lco/vine/android/widget/FeedAdapter;
.super Lco/vine/android/widget/GenericTimelineAdapter;
.source "FeedAdapter.java"

# interfaces
.implements Lco/vine/android/player/HasVideoPlayerAdapter;
.implements Lco/vine/android/widget/PinnedHeaderAdapter;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/widget/FeedAdapter$PlayCurrentPositionRunnable;,
        Lco/vine/android/widget/FeedAdapter$LoopCountRunnable;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lco/vine/android/widget/GenericTimelineAdapter",
        "<",
        "Lco/vine/android/widget/FeedViewHolder;",
        ">;",
        "Lco/vine/android/player/HasVideoPlayerAdapter;",
        "Lco/vine/android/widget/PinnedHeaderAdapter;"
    }
.end annotation


# instance fields
.field private currentPlayerCount:I

.field private volatile mCurrentPlaying:I

.field private mDividerScrollAwayPadding:I

.field private final mFeedLocationPinDrawable:Landroid/graphics/drawable/Drawable;

.field private mFirstPlayed:Z

.field private final mHandler:Landroid/os/Handler;

.field private mHasFocus:Z

.field private mLastPlayer:Lco/vine/android/player/SdkVideoView;

.field private mLoopCountHandler:Landroid/os/Handler;

.field private mLoopCountThread:Landroid/os/HandlerThread;

.field private mMuted:Z

.field private mNeedReleaseOtherPlayers:Z

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

.field private mPinnedHeaderHeight:I

.field private mPinnedHeaderListViewChildIndex:I

.field private mPinnedHeaderPosition:I

.field private mPinnedHeaderView:Landroid/view/View;

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

.field private final mPosts:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VinePost;",
            ">;"
        }
    .end annotation
.end field

.field private mShouldBePlaying:I

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

.field private mVideoAttr:Landroid/util/AttributeSet;

.field private mWasResumed:Z

.field private maxPlayer:I


# direct methods
.method public constructor <init>(Landroid/app/Activity;Landroid/widget/ListView;Lco/vine/android/LikeCache;Lco/vine/android/RevineCache;Lco/vine/android/BaseTimelineFragment;Ljava/lang/String;)V
    .locals 4
    .param p1, "context"    # Landroid/app/Activity;
    .param p2, "listView"    # Landroid/widget/ListView;
    .param p3, "likeCache"    # Lco/vine/android/LikeCache;
    .param p4, "revineCache"    # Lco/vine/android/RevineCache;
    .param p5, "timelineFragment"    # Lco/vine/android/BaseTimelineFragment;
    .param p6, "followEventSource"    # Ljava/lang/String;

    .prologue
    const/high16 v1, -0x80000000

    const/4 v3, 0x0

    const/4 v2, 0x0

    .line 106
    invoke-direct/range {p0 .. p6}, Lco/vine/android/widget/GenericTimelineAdapter;-><init>(Landroid/app/Activity;Landroid/widget/ListView;Lco/vine/android/LikeCache;Lco/vine/android/RevineCache;Lco/vine/android/BaseTimelineFragment;Ljava/lang/String;)V

    .line 70
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    iput-object v0, p0, Lco/vine/android/widget/FeedAdapter;->mHandler:Landroid/os/Handler;

    .line 73
    iput v1, p0, Lco/vine/android/widget/FeedAdapter;->mCurrentPlaying:I

    .line 74
    iput v1, p0, Lco/vine/android/widget/FeedAdapter;->mShouldBePlaying:I

    .line 75
    const/16 v0, 0xa

    iput v0, p0, Lco/vine/android/widget/FeedAdapter;->maxPlayer:I

    .line 76
    iput v2, p0, Lco/vine/android/widget/FeedAdapter;->currentPlayerCount:I

    .line 77
    iput-boolean v2, p0, Lco/vine/android/widget/FeedAdapter;->mNeedReleaseOtherPlayers:Z

    .line 80
    iput-boolean v2, p0, Lco/vine/android/widget/FeedAdapter;->mWasResumed:Z

    .line 82
    iput-object v3, p0, Lco/vine/android/widget/FeedAdapter;->mVideoAttr:Landroid/util/AttributeSet;

    .line 84
    const/4 v0, -0x1

    iput v0, p0, Lco/vine/android/widget/FeedAdapter;->mPinnedHeaderPosition:I

    .line 85
    iput v2, p0, Lco/vine/android/widget/FeedAdapter;->mPinnedHeaderHeight:I

    .line 88
    iput-object v3, p0, Lco/vine/android/widget/FeedAdapter;->mPinnedHeaderView:Landroid/view/View;

    .line 89
    iput v2, p0, Lco/vine/android/widget/FeedAdapter;->mDividerScrollAwayPadding:I

    .line 90
    iput v2, p0, Lco/vine/android/widget/FeedAdapter;->mPinnedHeaderListViewChildIndex:I

    .line 107
    const-string v0, "Adapter constructed, accelerated? {}"

    invoke-virtual {p2}, Landroid/widget/ListView;->isHardwareAccelerated()Z

    move-result v1

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 108
    new-instance v0, Landroid/util/SparseArray;

    invoke-direct {v0}, Landroid/util/SparseArray;-><init>()V

    iput-object v0, p0, Lco/vine/android/widget/FeedAdapter;->mPlayers:Landroid/util/SparseArray;

    .line 109
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lco/vine/android/widget/FeedAdapter;->mPosts:Ljava/util/ArrayList;

    .line 110
    new-instance v0, Landroid/util/SparseArray;

    invoke-direct {v0}, Landroid/util/SparseArray;-><init>()V

    iput-object v0, p0, Lco/vine/android/widget/FeedAdapter;->mPaths:Landroid/util/SparseArray;

    .line 111
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lco/vine/android/widget/FeedAdapter;->mUrlReverse:Ljava/util/HashMap;

    .line 112
    new-instance v0, Lco/vine/android/widget/FeedAdapter$PlayCurrentPositionRunnable;

    invoke-direct {v0, p0}, Lco/vine/android/widget/FeedAdapter$PlayCurrentPositionRunnable;-><init>(Lco/vine/android/widget/FeedAdapter;)V

    iput-object v0, p0, Lco/vine/android/widget/FeedAdapter;->mPlayCurrentPositionRunnable:Ljava/lang/Runnable;

    .line 113
    invoke-virtual {p1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f02016d

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/widget/FeedAdapter;->mFeedLocationPinDrawable:Landroid/graphics/drawable/Drawable;

    .line 114
    iget-object v0, p0, Lco/vine/android/widget/FeedAdapter;->mContext:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f0b0063

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v0

    iput v0, p0, Lco/vine/android/widget/FeedAdapter;->mPinnedHeaderHeight:I

    .line 117
    new-instance v0, Landroid/widget/LinearLayout;

    iget-object v1, p0, Lco/vine/android/widget/FeedAdapter;->mContext:Landroid/content/Context;

    invoke-direct {v0, v1}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    invoke-virtual {p5, v0, v3, v2}, Lco/vine/android/BaseTimelineFragment;->addHeaderView(Landroid/view/View;Ljava/lang/Object;Z)V

    .line 118
    new-instance v0, Landroid/os/HandlerThread;

    const-string v1, "loop-count-handler"

    invoke-direct {v0, v1}, Landroid/os/HandlerThread;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lco/vine/android/widget/FeedAdapter;->mLoopCountThread:Landroid/os/HandlerThread;

    .line 119
    iget-object v0, p0, Lco/vine/android/widget/FeedAdapter;->mLoopCountThread:Landroid/os/HandlerThread;

    invoke-virtual {v0}, Landroid/os/HandlerThread;->start()V

    .line 120
    new-instance v0, Landroid/os/Handler;

    iget-object v1, p0, Lco/vine/android/widget/FeedAdapter;->mLoopCountThread:Landroid/os/HandlerThread;

    invoke-virtual {v1}, Landroid/os/HandlerThread;->getLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    iput-object v0, p0, Lco/vine/android/widget/FeedAdapter;->mLoopCountHandler:Landroid/os/Handler;

    .line 122
    invoke-virtual {p1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f0b002d

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v0

    iput v0, p0, Lco/vine/android/widget/FeedAdapter;->mDividerScrollAwayPadding:I

    .line 123
    return-void
.end method

.method static synthetic access$000(Lco/vine/android/widget/FeedAdapter;)I
    .locals 1
    .param p0, "x0"    # Lco/vine/android/widget/FeedAdapter;

    .prologue
    .line 63
    iget v0, p0, Lco/vine/android/widget/FeedAdapter;->mCurrentPlaying:I

    return v0
.end method

.method static synthetic access$100(Lco/vine/android/widget/FeedAdapter;Lco/vine/android/player/VideoViewInterface;J)V
    .locals 0
    .param p0, "x0"    # Lco/vine/android/widget/FeedAdapter;
    .param p1, "x1"    # Lco/vine/android/player/VideoViewInterface;
    .param p2, "x2"    # J

    .prologue
    .line 63
    invoke-direct {p0, p1, p2, p3}, Lco/vine/android/widget/FeedAdapter;->countedMediaPlayerStart(Lco/vine/android/player/VideoViewInterface;J)V

    return-void
.end method

.method static synthetic access$1000(Lco/vine/android/widget/FeedAdapter;I)Z
    .locals 1
    .param p0, "x0"    # Lco/vine/android/widget/FeedAdapter;
    .param p1, "x1"    # I

    .prologue
    .line 63
    invoke-direct {p0, p1}, Lco/vine/android/widget/FeedAdapter;->getExplicit(I)Z

    move-result v0

    return v0
.end method

.method static synthetic access$202(Lco/vine/android/widget/FeedAdapter;I)I
    .locals 0
    .param p0, "x0"    # Lco/vine/android/widget/FeedAdapter;
    .param p1, "x1"    # I

    .prologue
    .line 63
    iput p1, p0, Lco/vine/android/widget/FeedAdapter;->maxPlayer:I

    return p1
.end method

.method static synthetic access$300(Lco/vine/android/widget/FeedAdapter;)I
    .locals 1
    .param p0, "x0"    # Lco/vine/android/widget/FeedAdapter;

    .prologue
    .line 63
    iget v0, p0, Lco/vine/android/widget/FeedAdapter;->currentPlayerCount:I

    return v0
.end method

.method static synthetic access$402(Lco/vine/android/widget/FeedAdapter;Z)Z
    .locals 0
    .param p0, "x0"    # Lco/vine/android/widget/FeedAdapter;
    .param p1, "x1"    # Z

    .prologue
    .line 63
    iput-boolean p1, p0, Lco/vine/android/widget/FeedAdapter;->mNeedReleaseOtherPlayers:Z

    return p1
.end method

.method static synthetic access$500(Lco/vine/android/widget/FeedAdapter;)Landroid/util/SparseArray;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/widget/FeedAdapter;

    .prologue
    .line 63
    iget-object v0, p0, Lco/vine/android/widget/FeedAdapter;->mPaths:Landroid/util/SparseArray;

    return-object v0
.end method

.method static synthetic access$600(Lco/vine/android/widget/FeedAdapter;I)Lco/vine/android/api/VinePost;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/widget/FeedAdapter;
    .param p1, "x1"    # I

    .prologue
    .line 63
    invoke-direct {p0, p1}, Lco/vine/android/widget/FeedAdapter;->getPost(I)Lco/vine/android/api/VinePost;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$700(Lco/vine/android/widget/FeedAdapter;)Z
    .locals 1
    .param p0, "x0"    # Lco/vine/android/widget/FeedAdapter;

    .prologue
    .line 63
    iget-boolean v0, p0, Lco/vine/android/widget/FeedAdapter;->mHasFocus:Z

    return v0
.end method

.method static synthetic access$800(Lco/vine/android/widget/FeedAdapter;)Lco/vine/android/player/SdkVideoView;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/widget/FeedAdapter;

    .prologue
    .line 63
    iget-object v0, p0, Lco/vine/android/widget/FeedAdapter;->mLastPlayer:Lco/vine/android/player/SdkVideoView;

    return-object v0
.end method

.method static synthetic access$900(Lco/vine/android/widget/FeedAdapter;)I
    .locals 1
    .param p0, "x0"    # Lco/vine/android/widget/FeedAdapter;

    .prologue
    .line 63
    invoke-direct {p0}, Lco/vine/android/widget/FeedAdapter;->calculateCurrentPosition()I

    move-result v0

    return v0
.end method

.method private bindHeader(Lco/vine/android/widget/FeedViewHolder;)V
    .locals 13
    .param p1, "h"    # Lco/vine/android/widget/FeedViewHolder;

    .prologue
    const/16 v12, 0x21

    const/4 v11, 0x1

    const/4 v10, 0x0

    const/4 v9, 0x0

    .line 987
    iget-object v1, p1, Lco/vine/android/widget/FeedViewHolder;->post:Lco/vine/android/api/VinePost;

    .line 988
    .local v1, "post":Lco/vine/android/api/VinePost;
    iget-object v4, v1, Lco/vine/android/api/VinePost;->username:Ljava/lang/String;

    .line 990
    .local v4, "usernameString":Ljava/lang/String;
    iput-object v9, p1, Lco/vine/android/widget/FeedViewHolder;->avatarKey:Lco/vine/android/util/image/ImageKey;

    .line 991
    invoke-virtual {p0, p1}, Lco/vine/android/widget/FeedAdapter;->bindAvatar(Lco/vine/android/widget/GenericFeedViewHolder;)V

    .line 993
    if-nez v4, :cond_0

    .line 994
    const-string v4, ""

    .line 995
    new-instance v5, Lco/vine/android/VineLoggingException;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "Invalid user name for post "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    iget-wide v7, v1, Lco/vine/android/api/VinePost;->userId:J

    invoke-virtual {v6, v7, v8}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v6}, Lco/vine/android/VineLoggingException;-><init>(Ljava/lang/String;)V

    invoke-static {v5}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;)V

    .line 997
    :cond_0
    new-instance v2, Landroid/text/SpannableStringBuilder;

    invoke-direct {v2, v4}, Landroid/text/SpannableStringBuilder;-><init>(Ljava/lang/CharSequence;)V

    .line 998
    .local v2, "sb":Landroid/text/SpannableStringBuilder;
    iget-object v5, p0, Lco/vine/android/widget/FeedAdapter;->mBoldSpan:Lco/vine/android/widget/TypefacesSpan;

    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v6

    invoke-static {v2, v5, v10, v6, v12}, Lco/vine/android/util/Util;->safeSetSpan(Landroid/text/Spannable;Ljava/lang/Object;III)V

    .line 1000
    new-instance v3, Lco/vine/android/widget/StyledClickableSpan;

    iget-wide v5, v1, Lco/vine/android/api/VinePost;->userId:J

    invoke-static {v5, v6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    iget-object v6, p0, Lco/vine/android/widget/FeedAdapter;->mSpanClickListener:Lco/vine/android/widget/SpanClickListener;

    invoke-direct {v3, v11, v5, v6}, Lco/vine/android/widget/StyledClickableSpan;-><init>(ILjava/lang/Object;Lco/vine/android/widget/SpanClickListener;)V

    .line 1002
    .local v3, "styledClickableSpan":Lco/vine/android/widget/StyledClickableSpan;
    iget v5, p0, Lco/vine/android/widget/FeedAdapter;->mProfileColor:I

    invoke-virtual {v3, v5}, Lco/vine/android/widget/StyledClickableSpan;->setColor(I)V

    .line 1003
    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v5

    invoke-static {v2, v3, v10, v5, v12}, Lco/vine/android/util/Util;->safeSetSpan(Landroid/text/Spannable;Ljava/lang/Object;III)V

    .line 1005
    iget-object v5, p1, Lco/vine/android/widget/FeedViewHolder;->userImage:Landroid/widget/ImageView;

    new-instance v6, Lco/vine/android/widget/FeedAdapter$8;

    invoke-direct {v6, p0, v1}, Lco/vine/android/widget/FeedAdapter$8;-><init>(Lco/vine/android/widget/FeedAdapter;Lco/vine/android/api/VinePost;)V

    invoke-virtual {v5, v6}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 1011
    iget-object v5, p1, Lco/vine/android/widget/FeedViewHolder;->username:Landroid/widget/TextView;

    invoke-static {}, Landroid/text/method/LinkMovementMethod;->getInstance()Landroid/text/method/MovementMethod;

    move-result-object v6

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setMovementMethod(Landroid/text/method/MovementMethod;)V

    .line 1012
    iget-object v5, p1, Lco/vine/android/widget/FeedViewHolder;->username:Landroid/widget/TextView;

    invoke-virtual {v5, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 1013
    iget-object v5, p0, Lco/vine/android/widget/FeedAdapter;->mContext:Landroid/content/Context;

    iget-wide v6, v1, Lco/vine/android/api/VinePost;->created:J

    invoke-static {v5, v6, v7, v10}, Lco/vine/android/util/Util;->getRelativeTimeString(Landroid/content/Context;JZ)Ljava/lang/String;

    move-result-object v0

    .line 1015
    .local v0, "dateString":Ljava/lang/String;
    iget-object v5, v1, Lco/vine/android/api/VinePost;->venueData:Lco/vine/android/api/VineVenue;

    if-eqz v5, :cond_1

    iget-object v5, v1, Lco/vine/android/api/VinePost;->venueData:Lco/vine/android/api/VineVenue;

    iget-object v5, v5, Lco/vine/android/api/VineVenue;->venueName:Ljava/lang/String;

    invoke-static {v5}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-nez v5, :cond_1

    .line 1016
    iget-object v5, p1, Lco/vine/android/widget/FeedViewHolder;->timestamp:Landroid/widget/TextView;

    iget-object v6, p0, Lco/vine/android/widget/FeedAdapter;->mFeedLocationPinDrawable:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v5, v9, v9, v6, v9}, Landroid/widget/TextView;->setCompoundDrawablesWithIntrinsicBounds(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V

    .line 1017
    iget-object v5, p0, Lco/vine/android/widget/FeedAdapter;->mContext:Landroid/content/Context;

    const v6, 0x7f0e00a8

    invoke-virtual {v5, v6}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v5

    const/4 v6, 0x2

    new-array v6, v6, [Ljava/lang/Object;

    aput-object v0, v6, v10

    iget-object v7, v1, Lco/vine/android/api/VinePost;->venueData:Lco/vine/android/api/VineVenue;

    iget-object v7, v7, Lco/vine/android/api/VineVenue;->venueName:Ljava/lang/String;

    invoke-virtual {v7}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v7

    aput-object v7, v6, v11

    invoke-static {v5, v6}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 1022
    :goto_0
    iget-object v5, p1, Lco/vine/android/widget/FeedViewHolder;->timestamp:Landroid/widget/TextView;

    invoke-virtual {v5, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 1024
    invoke-virtual {p1, v1}, Lco/vine/android/widget/FeedViewHolder;->updateCount(Lco/vine/android/api/VinePost;)V

    .line 1025
    return-void

    .line 1019
    :cond_1
    iget-object v5, p1, Lco/vine/android/widget/FeedViewHolder;->timestamp:Landroid/widget/TextView;

    invoke-virtual {v5, v9, v9, v9, v9}, Landroid/widget/TextView;->setCompoundDrawablesWithIntrinsicBounds(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V

    goto :goto_0
.end method

.method private bindView(Lco/vine/android/widget/FeedViewHolder;)V
    .locals 26
    .param p1, "h"    # Lco/vine/android/widget/FeedViewHolder;

    .prologue
    .line 581
    move-object/from16 v0, p1

    iget-object v12, v0, Lco/vine/android/widget/FeedViewHolder;->post:Lco/vine/android/api/VinePost;

    .line 582
    .local v12, "post":Lco/vine/android/api/VinePost;
    move-object/from16 v0, p1

    iget v11, v0, Lco/vine/android/widget/FeedViewHolder;->position:I

    .line 584
    .local v11, "position":I
    move-object/from16 v0, p0

    invoke-direct {v0, v11}, Lco/vine/android/widget/FeedAdapter;->shouldShowThumbnail(I)Z

    move-result v21

    if-eqz v21, :cond_0

    .line 585
    const-string v21, "Should show thumbnail... {} {}."

    invoke-static {v11}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v22

    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/widget/FeedAdapter;->mCurrentPlaying:I

    move/from16 v23, v0

    invoke-static/range {v23 .. v23}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v23

    invoke-static/range {v21 .. v23}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 586
    move-object/from16 v0, p1

    iget-object v0, v0, Lco/vine/android/widget/FeedViewHolder;->videoLoadImage:Landroid/widget/ProgressBar;

    move-object/from16 v21, v0

    const/16 v22, 0x0

    invoke-virtual/range {v21 .. v22}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 587
    move-object/from16 v0, p1

    iget-object v0, v0, Lco/vine/android/widget/FeedViewHolder;->videoView:Lco/vine/android/player/SdkVideoView;

    move-object/from16 v21, v0

    const/16 v22, 0x8

    invoke-virtual/range {v21 .. v22}, Lco/vine/android/player/SdkVideoView;->setVisibility(I)V

    .line 590
    :cond_0
    const/16 v21, 0x0

    move-object/from16 v0, v21

    move-object/from16 v1, p1

    iput-object v0, v1, Lco/vine/android/widget/FeedViewHolder;->videoImageKey:Lco/vine/android/util/image/ImageKey;

    .line 592
    invoke-virtual/range {p0 .. p1}, Lco/vine/android/widget/FeedAdapter;->bindVideoImage(Lco/vine/android/widget/GenericFeedViewHolder;)Z

    .line 594
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lco/vine/android/widget/FeedAdapter;->mIconsSwitched:Z

    move/from16 v21, v0

    if-nez v21, :cond_1

    .line 596
    const/16 v21, 0x1

    move/from16 v0, v21

    move-object/from16 v1, p0

    iput-boolean v0, v1, Lco/vine/android/widget/FeedAdapter;->mIconsSwitched:Z

    .line 599
    :cond_1
    move-object/from16 v0, p1

    iget-object v0, v0, Lco/vine/android/widget/FeedViewHolder;->post:Lco/vine/android/api/VinePost;

    move-object/from16 v21, v0

    invoke-virtual/range {v21 .. v21}, Lco/vine/android/api/VinePost;->isExplicit()Z

    move-result v21

    if-eqz v21, :cond_2

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/widget/FeedAdapter;->mDismissedWarnings:Ljava/util/HashSet;

    move-object/from16 v21, v0

    invoke-static {v11}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v22

    invoke-virtual/range {v21 .. v22}, Ljava/util/HashSet;->contains(Ljava/lang/Object;)Z

    move-result v21

    if-eqz v21, :cond_3

    .line 600
    :cond_2
    move-object/from16 v0, p1

    iget-object v0, v0, Lco/vine/android/widget/FeedViewHolder;->videoImage:Landroid/widget/ImageView;

    move-object/from16 v21, v0

    const/16 v22, 0x0

    invoke-virtual/range {v21 .. v22}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 605
    :goto_0
    iget-object v0, v12, Lco/vine/android/api/VinePost;->repost:Lco/vine/android/api/VineRepost;

    move-object/from16 v21, v0

    if-eqz v21, :cond_6

    .line 606
    move-object/from16 v0, p1

    iget-object v0, v0, Lco/vine/android/widget/FeedViewHolder;->revineLine:Landroid/widget/TextView;

    move-object/from16 v21, v0

    const/16 v22, 0x0

    invoke-virtual/range {v21 .. v22}, Landroid/widget/TextView;->setVisibility(I)V

    .line 607
    iget-object v0, v12, Lco/vine/android/api/VinePost;->repost:Lco/vine/android/api/VineRepost;

    move-object/from16 v21, v0

    move-object/from16 v0, v21

    iget-wide v0, v0, Lco/vine/android/api/VineRepost;->userId:J

    move-wide/from16 v18, v0

    .line 608
    .local v18, "userId":J
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/widget/FeedAdapter;->mAppController:Lco/vine/android/client/AppController;

    move-object/from16 v21, v0

    invoke-virtual/range {v21 .. v21}, Lco/vine/android/client/AppController;->getActiveId()J

    move-result-wide v21

    cmp-long v21, v18, v21

    if-nez v21, :cond_4

    .line 609
    move-object/from16 v0, p1

    iget-object v0, v0, Lco/vine/android/widget/FeedViewHolder;->revineLine:Landroid/widget/TextView;

    move-object/from16 v21, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/widget/FeedAdapter;->mContext:Landroid/content/Context;

    move-object/from16 v22, v0

    const v23, 0x7f0e01b1

    invoke-virtual/range {v22 .. v23}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v22

    invoke-virtual/range {v21 .. v22}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 628
    .end local v18    # "userId":J
    :goto_1
    iget-object v0, v12, Lco/vine/android/api/VinePost;->description:Ljava/lang/String;

    move-object/from16 v21, v0

    invoke-static/range {v21 .. v21}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v21

    if-nez v21, :cond_10

    .line 629
    move-object/from16 v0, p1

    iget-object v0, v0, Lco/vine/android/widget/FeedViewHolder;->description:Landroid/widget/TextView;

    move-object/from16 v21, v0

    const/16 v22, 0x0

    invoke-virtual/range {v21 .. v22}, Landroid/widget/TextView;->setVisibility(I)V

    .line 631
    iget-object v0, v12, Lco/vine/android/api/VinePost;->transientEntities:Ljava/util/ArrayList;

    move-object/from16 v21, v0

    if-nez v21, :cond_7

    iget-object v0, v12, Lco/vine/android/api/VinePost;->entities:Ljava/util/ArrayList;

    move-object/from16 v21, v0

    if-eqz v21, :cond_7

    .line 632
    new-instance v21, Ljava/util/ArrayList;

    invoke-direct/range {v21 .. v21}, Ljava/util/ArrayList;-><init>()V

    move-object/from16 v0, v21

    iput-object v0, v12, Lco/vine/android/api/VinePost;->transientEntities:Ljava/util/ArrayList;

    .line 633
    iget-object v0, v12, Lco/vine/android/api/VinePost;->entities:Ljava/util/ArrayList;

    move-object/from16 v21, v0

    invoke-virtual/range {v21 .. v21}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v9

    .local v9, "i$":Ljava/util/Iterator;
    :goto_2
    invoke-interface {v9}, Ljava/util/Iterator;->hasNext()Z

    move-result v21

    if-eqz v21, :cond_7

    invoke-interface {v9}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Lco/vine/android/api/VineEntity;

    .line 634
    .local v8, "entity":Lco/vine/android/api/VineEntity;
    iget-object v0, v12, Lco/vine/android/api/VinePost;->transientEntities:Ljava/util/ArrayList;

    move-object/from16 v21, v0

    invoke-virtual {v8}, Lco/vine/android/api/VineEntity;->duplicate()Lco/vine/android/api/VineEntity;

    move-result-object v22

    invoke-virtual/range {v21 .. v22}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_2

    .line 602
    .end local v8    # "entity":Lco/vine/android/api/VineEntity;
    .end local v9    # "i$":Ljava/util/Iterator;
    :cond_3
    move-object/from16 v0, p1

    iget-object v0, v0, Lco/vine/android/widget/FeedViewHolder;->videoImage:Landroid/widget/ImageView;

    move-object/from16 v21, v0

    const/16 v22, 0x8

    invoke-virtual/range {v21 .. v22}, Landroid/widget/ImageView;->setVisibility(I)V

    goto/16 :goto_0

    .line 610
    .restart local v18    # "userId":J
    :cond_4
    iget-object v0, v12, Lco/vine/android/api/VinePost;->repost:Lco/vine/android/api/VineRepost;

    move-object/from16 v21, v0

    move-object/from16 v0, v21

    iget-object v0, v0, Lco/vine/android/api/VineRepost;->username:Ljava/lang/String;

    move-object/from16 v21, v0

    if-eqz v21, :cond_5

    .line 611
    move-object/from16 v0, p1

    iget-object v0, v0, Lco/vine/android/widget/FeedViewHolder;->revineLine:Landroid/widget/TextView;

    move-object/from16 v21, v0

    new-instance v22, Lco/vine/android/widget/FeedAdapter$6;

    move-object/from16 v0, v22

    move-object/from16 v1, p0

    move-wide/from16 v2, v18

    invoke-direct {v0, v1, v2, v3}, Lco/vine/android/widget/FeedAdapter$6;-><init>(Lco/vine/android/widget/FeedAdapter;J)V

    invoke-virtual/range {v21 .. v22}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 617
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/widget/FeedAdapter;->mContext:Landroid/content/Context;

    move-object/from16 v21, v0

    const v22, 0x7f0e01b0

    const/16 v23, 0x1

    move/from16 v0, v23

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v23, v0

    const/16 v24, 0x0

    iget-object v0, v12, Lco/vine/android/api/VinePost;->repost:Lco/vine/android/api/VineRepost;

    move-object/from16 v25, v0

    move-object/from16 v0, v25

    iget-object v0, v0, Lco/vine/android/api/VineRepost;->username:Ljava/lang/String;

    move-object/from16 v25, v0

    aput-object v25, v23, v24

    invoke-virtual/range {v21 .. v23}, Landroid/content/Context;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v15

    .line 618
    .local v15, "revinedBy":Ljava/lang/String;
    new-instance v16, Landroid/text/SpannableStringBuilder;

    move-object/from16 v0, v16

    invoke-direct {v0, v15}, Landroid/text/SpannableStringBuilder;-><init>(Ljava/lang/CharSequence;)V

    .line 619
    .local v16, "revinedBySb":Landroid/text/SpannableStringBuilder;
    move-object/from16 v0, p1

    iget-object v0, v0, Lco/vine/android/widget/FeedViewHolder;->revineLine:Landroid/widget/TextView;

    move-object/from16 v21, v0

    invoke-static {}, Landroid/text/method/LinkMovementMethod;->getInstance()Landroid/text/method/MovementMethod;

    move-result-object v22

    invoke-virtual/range {v21 .. v22}, Landroid/widget/TextView;->setMovementMethod(Landroid/text/method/MovementMethod;)V

    .line 620
    move-object/from16 v0, p1

    iget-object v0, v0, Lco/vine/android/widget/FeedViewHolder;->revineLine:Landroid/widget/TextView;

    move-object/from16 v21, v0

    move-object/from16 v0, v21

    move-object/from16 v1, v16

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_1

    .line 622
    .end local v15    # "revinedBy":Ljava/lang/String;
    .end local v16    # "revinedBySb":Landroid/text/SpannableStringBuilder;
    :cond_5
    move-object/from16 v0, p1

    iget-object v0, v0, Lco/vine/android/widget/FeedViewHolder;->revineLine:Landroid/widget/TextView;

    move-object/from16 v21, v0

    const/16 v22, 0x8

    invoke-virtual/range {v21 .. v22}, Landroid/widget/TextView;->setVisibility(I)V

    goto/16 :goto_1

    .line 625
    .end local v18    # "userId":J
    :cond_6
    move-object/from16 v0, p1

    iget-object v0, v0, Lco/vine/android/widget/FeedViewHolder;->revineLine:Landroid/widget/TextView;

    move-object/from16 v21, v0

    const/16 v22, 0x8

    invoke-virtual/range {v21 .. v22}, Landroid/widget/TextView;->setVisibility(I)V

    goto/16 :goto_1

    .line 638
    :cond_7
    iget-object v13, v12, Lco/vine/android/api/VinePost;->transientEntities:Ljava/util/ArrayList;

    .line 639
    .local v13, "postEntities":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineEntity;>;"
    iget-object v0, v12, Lco/vine/android/api/VinePost;->description:Ljava/lang/String;

    move-object/from16 v21, v0

    invoke-static/range {v21 .. v21}, Lco/vine/android/util/Util;->addDirectionalMarkers(Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v5

    .line 640
    .local v5, "description":Ljava/lang/String;
    if-eqz v13, :cond_e

    .line 641
    move-object/from16 v0, p1

    iget-object v0, v0, Lco/vine/android/widget/FeedViewHolder;->description:Landroid/widget/TextView;

    move-object/from16 v21, v0

    invoke-static {}, Landroid/text/method/LinkMovementMethod;->getInstance()Landroid/text/method/MovementMethod;

    move-result-object v22

    invoke-virtual/range {v21 .. v22}, Landroid/widget/TextView;->setMovementMethod(Landroid/text/method/MovementMethod;)V

    .line 642
    iget-object v0, v12, Lco/vine/android/api/VinePost;->descriptionSb:Landroid/text/SpannableStringBuilder;

    move-object/from16 v21, v0

    if-nez v21, :cond_9

    .line 643
    new-instance v21, Landroid/text/SpannableStringBuilder;

    move-object/from16 v0, v21

    invoke-direct {v0, v5}, Landroid/text/SpannableStringBuilder;-><init>(Ljava/lang/CharSequence;)V

    move-object/from16 v0, v21

    iput-object v0, v12, Lco/vine/android/api/VinePost;->descriptionSb:Landroid/text/SpannableStringBuilder;

    .line 644
    iget-object v6, v12, Lco/vine/android/api/VinePost;->descriptionSb:Landroid/text/SpannableStringBuilder;

    .line 646
    .local v6, "descriptionSb":Landroid/text/SpannableStringBuilder;
    const/16 v21, 0x0

    const/16 v22, 0x0

    :try_start_0
    move/from16 v0, v21

    move/from16 v1, v22

    invoke-static {v13, v6, v0, v1}, Lco/vine/android/util/Util;->adjustEntities(Ljava/util/ArrayList;Landroid/text/Editable;IZ)V

    .line 648
    invoke-virtual {v13}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v9

    .restart local v9    # "i$":Ljava/util/Iterator;
    :cond_8
    :goto_3
    invoke-interface {v9}, Ljava/util/Iterator;->hasNext()Z

    move-result v21

    if-eqz v21, :cond_9

    invoke-interface {v9}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Lco/vine/android/api/VineEntity;

    .line 649
    .restart local v8    # "entity":Lco/vine/android/api/VineEntity;
    invoke-virtual {v8}, Lco/vine/android/api/VineEntity;->isUserType()Z

    move-result v21

    if-eqz v21, :cond_d

    .line 650
    new-instance v20, Lco/vine/android/widget/StyledClickableSpan;

    const/16 v21, 0x1

    iget-wide v0, v8, Lco/vine/android/api/VineEntity;->id:J

    move-wide/from16 v22, v0

    invoke-static/range {v22 .. v23}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v22

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/widget/FeedAdapter;->mSpanClickListener:Lco/vine/android/widget/SpanClickListener;

    move-object/from16 v23, v0

    invoke-direct/range {v20 .. v23}, Lco/vine/android/widget/StyledClickableSpan;-><init>(ILjava/lang/Object;Lco/vine/android/widget/SpanClickListener;)V

    .line 653
    .local v20, "usernameSpan":Lco/vine/android/widget/StyledClickableSpan;
    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/widget/FeedAdapter;->mProfileColor:I

    move/from16 v21, v0

    invoke-virtual/range {v20 .. v21}, Lco/vine/android/widget/StyledClickableSpan;->setColor(I)V

    .line 654
    iget v0, v8, Lco/vine/android/api/VineEntity;->start:I

    move/from16 v21, v0

    iget v0, v8, Lco/vine/android/api/VineEntity;->end:I

    move/from16 v22, v0

    const/16 v23, 0x21

    move-object/from16 v0, v20

    move/from16 v1, v21

    move/from16 v2, v22

    move/from16 v3, v23

    invoke-static {v6, v0, v1, v2, v3}, Lco/vine/android/util/Util;->safeSetSpan(Landroid/text/Spannable;Ljava/lang/Object;III)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_3

    .line 665
    .end local v8    # "entity":Lco/vine/android/api/VineEntity;
    .end local v9    # "i$":Ljava/util/Iterator;
    .end local v20    # "usernameSpan":Lco/vine/android/widget/StyledClickableSpan;
    :catch_0
    move-exception v7

    .line 666
    .local v7, "e":Ljava/lang/Exception;
    invoke-static {v7}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;)V

    .line 669
    .end local v6    # "descriptionSb":Landroid/text/SpannableStringBuilder;
    .end local v7    # "e":Ljava/lang/Exception;
    :cond_9
    move-object/from16 v0, p1

    iget-object v0, v0, Lco/vine/android/widget/FeedViewHolder;->description:Landroid/widget/TextView;

    move-object/from16 v21, v0

    iget-object v0, v12, Lco/vine/android/api/VinePost;->descriptionSb:Landroid/text/SpannableStringBuilder;

    move-object/from16 v22, v0

    invoke-virtual/range {v21 .. v22}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 674
    :goto_4
    invoke-static {v5}, Lco/vine/android/util/Util;->isRtlLanguage(Ljava/lang/String;)Z

    move-result v21

    if-eqz v21, :cond_f

    .line 675
    move-object/from16 v0, p1

    iget-object v0, v0, Lco/vine/android/widget/FeedViewHolder;->description:Landroid/widget/TextView;

    move-object/from16 v21, v0

    const/16 v22, 0x5

    invoke-virtual/range {v21 .. v22}, Landroid/widget/TextView;->setGravity(I)V

    .line 684
    .end local v5    # "description":Ljava/lang/String;
    .end local v13    # "postEntities":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineEntity;>;"
    :goto_5
    move-object/from16 v0, p1

    iget-object v0, v0, Lco/vine/android/widget/FeedViewHolder;->listener:Lco/vine/android/player/OnListVideoClickListener;

    move-object/from16 v21, v0

    move-object/from16 v0, v21

    invoke-virtual {v0, v11}, Lco/vine/android/player/OnListVideoClickListener;->setPosition(I)V

    .line 685
    move-object/from16 v0, p1

    iget-object v0, v0, Lco/vine/android/widget/FeedViewHolder;->imageListener:Lco/vine/android/player/SensitiveImageClickListener;

    move-object/from16 v21, v0

    if-eqz v21, :cond_a

    .line 686
    move-object/from16 v0, p1

    iget-object v0, v0, Lco/vine/android/widget/FeedViewHolder;->imageListener:Lco/vine/android/player/SensitiveImageClickListener;

    move-object/from16 v21, v0

    move-object/from16 v0, v21

    invoke-virtual {v0, v11}, Lco/vine/android/player/SensitiveImageClickListener;->setPosition(I)V

    .line 689
    :cond_a
    invoke-direct/range {p0 .. p1}, Lco/vine/android/widget/FeedAdapter;->bindHeader(Lco/vine/android/widget/FeedViewHolder;)V

    .line 691
    move-object/from16 v0, p1

    iget-object v0, v0, Lco/vine/android/widget/FeedViewHolder;->comment:Lco/vine/android/widget/ColorizedCircleButton;

    move-object/from16 v21, v0

    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/widget/FeedAdapter;->mProfileColor:I

    move/from16 v22, v0

    invoke-virtual/range {v21 .. v22}, Lco/vine/android/widget/ColorizedCircleButton;->setColor(I)V

    .line 692
    move-object/from16 v0, p1

    iget-object v0, v0, Lco/vine/android/widget/FeedViewHolder;->comment:Lco/vine/android/widget/ColorizedCircleButton;

    move-object/from16 v21, v0

    new-instance v22, Lco/vine/android/widget/FeedAdapter$7;

    move-object/from16 v0, v22

    move-object/from16 v1, p0

    invoke-direct {v0, v1, v12}, Lco/vine/android/widget/FeedAdapter$7;-><init>(Lco/vine/android/widget/FeedAdapter;Lco/vine/android/api/VinePost;)V

    invoke-virtual/range {v21 .. v22}, Lco/vine/android/widget/ColorizedCircleButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 699
    move-object/from16 v0, p1

    iget-object v4, v0, Lco/vine/android/widget/FeedViewHolder;->commentList:Landroid/widget/LinearLayout;

    .line 700
    .local v4, "commentsContainer":Landroid/widget/LinearLayout;
    move-object/from16 v0, p1

    iget-object v0, v0, Lco/vine/android/widget/FeedViewHolder;->post:Lco/vine/android/api/VinePost;

    move-object/from16 v21, v0

    move-object/from16 v0, v21

    iget-object v0, v0, Lco/vine/android/api/VinePost;->comments:Lco/vine/android/api/VinePagedData;

    move-object/from16 v21, v0

    if-eqz v21, :cond_11

    move-object/from16 v0, p1

    iget-object v0, v0, Lco/vine/android/widget/FeedViewHolder;->post:Lco/vine/android/api/VinePost;

    move-object/from16 v21, v0

    move-object/from16 v0, v21

    iget-object v0, v0, Lco/vine/android/api/VinePost;->comments:Lco/vine/android/api/VinePagedData;

    move-object/from16 v21, v0

    move-object/from16 v0, v21

    iget-object v0, v0, Lco/vine/android/api/VinePagedData;->items:Ljava/util/ArrayList;

    move-object/from16 v21, v0

    invoke-virtual/range {v21 .. v21}, Ljava/util/ArrayList;->size()I

    move-result v21

    if-lez v21, :cond_11

    const/16 v17, 0x1

    .line 703
    .local v17, "showComments":Z
    :goto_6
    invoke-virtual/range {p0 .. p1}, Lco/vine/android/widget/FeedAdapter;->setStyledCompactLikesComments(Lco/vine/android/widget/GenericFeedViewHolder;)V

    .line 704
    const/16 v21, 0x0

    move/from16 v0, v21

    invoke-virtual {v4, v0}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 707
    if-eqz v17, :cond_13

    .line 708
    iget-object v0, v12, Lco/vine/android/api/VinePost;->comments:Lco/vine/android/api/VinePagedData;

    move-object/from16 v21, v0

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move-object/from16 v2, v21

    invoke-virtual {v0, v1, v2}, Lco/vine/android/widget/FeedAdapter;->setStyledComments(Lco/vine/android/widget/GenericFeedViewHolder;Lco/vine/android/api/VinePagedData;)V

    .line 709
    const/16 v21, 0x0

    move/from16 v0, v21

    invoke-virtual {v4, v0}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 710
    iget v0, v12, Lco/vine/android/api/VinePost;->commentsCount:I

    move/from16 v21, v0

    const/16 v22, 0x3

    move/from16 v0, v21

    move/from16 v1, v22

    if-le v0, v1, :cond_12

    .line 711
    const/16 v21, 0x2

    move/from16 v0, v21

    move-object/from16 v1, p1

    iput v0, v1, Lco/vine/android/widget/FeedViewHolder;->commentType:I

    .line 721
    :goto_7
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/widget/FeedAdapter;->mLikeCache:Lco/vine/android/LikeCache;

    move-object/from16 v21, v0

    iget-wide v0, v12, Lco/vine/android/api/VinePost;->postId:J

    move-wide/from16 v22, v0

    invoke-virtual/range {v21 .. v23}, Lco/vine/android/LikeCache;->contains(J)Z

    move-result v21

    if-eqz v21, :cond_14

    .line 722
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/widget/FeedAdapter;->mLikeCache:Lco/vine/android/LikeCache;

    move-object/from16 v21, v0

    iget-wide v0, v12, Lco/vine/android/api/VinePost;->postId:J

    move-wide/from16 v22, v0

    invoke-virtual/range {v21 .. v23}, Lco/vine/android/LikeCache;->isLike(J)Z

    move-result v10

    .line 723
    .local v10, "liked":Z
    invoke-virtual {v12, v10}, Lco/vine/android/api/VinePost;->setFlagLiked(Z)V

    .line 733
    :goto_8
    move-object/from16 v0, p1

    iget-object v0, v0, Lco/vine/android/widget/FeedViewHolder;->liked:Lco/vine/android/widget/ColorizedCircleButton;

    move-object/from16 v21, v0

    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/widget/FeedAdapter;->mProfileColor:I

    move/from16 v22, v0

    invoke-virtual/range {v21 .. v22}, Lco/vine/android/widget/ColorizedCircleButton;->setColor(I)V

    .line 735
    move-object/from16 v0, p1

    iget-object v0, v0, Lco/vine/android/widget/FeedViewHolder;->liked:Lco/vine/android/widget/ColorizedCircleButton;

    move-object/from16 v21, v0

    move-object/from16 v0, v21

    invoke-virtual {v0, v10}, Lco/vine/android/widget/ColorizedCircleButton;->setSelected(Z)V

    .line 737
    move-object/from16 v0, p1

    iget-object v0, v0, Lco/vine/android/widget/FeedViewHolder;->liked:Lco/vine/android/widget/ColorizedCircleButton;

    move-object/from16 v21, v0

    iget-wide v0, v12, Lco/vine/android/api/VinePost;->postId:J

    move-wide/from16 v22, v0

    invoke-static/range {v22 .. v23}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v22

    invoke-virtual/range {v21 .. v22}, Lco/vine/android/widget/ColorizedCircleButton;->setTag(Ljava/lang/Object;)V

    .line 738
    move-object/from16 v0, p1

    iget-object v0, v0, Lco/vine/android/widget/FeedViewHolder;->liked:Lco/vine/android/widget/ColorizedCircleButton;

    move-object/from16 v21, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/widget/FeedAdapter;->mViewClickListener:Landroid/view/View$OnClickListener;

    move-object/from16 v22, v0

    invoke-virtual/range {v21 .. v22}, Lco/vine/android/widget/ColorizedCircleButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 740
    move-object/from16 v0, p1

    iget-object v0, v0, Lco/vine/android/widget/FeedViewHolder;->more:Landroid/widget/ImageView;

    move-object/from16 v21, v0

    move-object/from16 v0, v21

    invoke-virtual {v0, v12}, Landroid/widget/ImageView;->setTag(Ljava/lang/Object;)V

    .line 741
    move-object/from16 v0, p1

    iget-object v0, v0, Lco/vine/android/widget/FeedViewHolder;->more:Landroid/widget/ImageView;

    move-object/from16 v21, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/widget/FeedAdapter;->mViewClickListener:Landroid/view/View$OnClickListener;

    move-object/from16 v22, v0

    invoke-virtual/range {v21 .. v22}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 743
    move-object/from16 v0, p1

    iget-object v0, v0, Lco/vine/android/widget/FeedViewHolder;->share:Lco/vine/android/widget/ColorizedCircleButton;

    move-object/from16 v21, v0

    const/16 v22, 0x0

    invoke-virtual/range {v21 .. v22}, Lco/vine/android/widget/ColorizedCircleButton;->setVisibility(I)V

    .line 745
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/widget/FeedAdapter;->mRevineCache:Lco/vine/android/RevineCache;

    move-object/from16 v21, v0

    iget-wide v0, v12, Lco/vine/android/api/VinePost;->postId:J

    move-wide/from16 v22, v0

    invoke-virtual/range {v21 .. v23}, Lco/vine/android/RevineCache;->contains(J)Z

    move-result v21

    if-eqz v21, :cond_16

    .line 746
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/widget/FeedAdapter;->mRevineCache:Lco/vine/android/RevineCache;

    move-object/from16 v21, v0

    iget-wide v0, v12, Lco/vine/android/api/VinePost;->postId:J

    move-wide/from16 v22, v0

    invoke-virtual/range {v21 .. v23}, Lco/vine/android/RevineCache;->isRevined(J)Z

    move-result v14

    .line 747
    .local v14, "revined":Z
    invoke-virtual {v12, v14}, Lco/vine/android/api/VinePost;->setFlagRevined(Z)V

    .line 758
    :goto_9
    move-object/from16 v0, p1

    iget-object v0, v0, Lco/vine/android/widget/FeedViewHolder;->share:Lco/vine/android/widget/ColorizedCircleButton;

    move-object/from16 v21, v0

    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/widget/FeedAdapter;->mProfileColor:I

    move/from16 v22, v0

    invoke-virtual/range {v21 .. v22}, Lco/vine/android/widget/ColorizedCircleButton;->setColor(I)V

    .line 759
    move-object/from16 v0, p1

    iget-object v0, v0, Lco/vine/android/widget/FeedViewHolder;->share:Lco/vine/android/widget/ColorizedCircleButton;

    move-object/from16 v21, v0

    move-object/from16 v0, v21

    invoke-virtual {v0, v14}, Lco/vine/android/widget/ColorizedCircleButton;->setSelected(Z)V

    .line 761
    move-object/from16 v0, p1

    iget-object v0, v0, Lco/vine/android/widget/FeedViewHolder;->share:Lco/vine/android/widget/ColorizedCircleButton;

    move-object/from16 v21, v0

    move-object/from16 v0, v21

    invoke-virtual {v0, v12}, Lco/vine/android/widget/ColorizedCircleButton;->setTag(Ljava/lang/Object;)V

    .line 762
    move-object/from16 v0, p1

    iget-object v0, v0, Lco/vine/android/widget/FeedViewHolder;->share:Lco/vine/android/widget/ColorizedCircleButton;

    move-object/from16 v21, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/widget/FeedAdapter;->mViewClickListener:Landroid/view/View$OnClickListener;

    move-object/from16 v22, v0

    invoke-virtual/range {v21 .. v22}, Lco/vine/android/widget/ColorizedCircleButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 764
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    invoke-direct {v0, v11, v1}, Lco/vine/android/widget/FeedAdapter;->initVideoView(ILco/vine/android/widget/FeedViewHolder;)V

    .line 765
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lco/vine/android/widget/FeedAdapter;->mFirstPlayed:Z

    move/from16 v21, v0

    if-nez v21, :cond_c

    if-nez v11, :cond_c

    invoke-virtual {v12}, Lco/vine/android/api/VinePost;->isExplicit()Z

    move-result v21

    if-nez v21, :cond_c

    .line 766
    const/16 v21, 0x0

    move-object/from16 v0, p0

    move/from16 v1, v21

    invoke-virtual {v0, v1}, Lco/vine/android/widget/FeedAdapter;->play(I)V

    .line 767
    sget-boolean v21, Lcom/edisonwang/android/slog/SLog;->sLogsOn:Z

    if-eqz v21, :cond_b

    move-object/from16 v0, p0

    iget-wide v0, v0, Lco/vine/android/widget/FeedAdapter;->mStartLoadingTime:J

    move-wide/from16 v21, v0

    const-wide/16 v23, 0x0

    cmp-long v21, v21, v23

    if-lez v21, :cond_b

    .line 768
    const-string v21, "Time since started loading to request 0th video to play: {}ms"

    invoke-virtual/range {p0 .. p0}, Lco/vine/android/widget/FeedAdapter;->timeSinceStartLoadingTime()J

    move-result-wide v22

    invoke-static/range {v22 .. v23}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v22

    invoke-static/range {v21 .. v22}, Lcom/edisonwang/android/slog/SLog;->i(Ljava/lang/String;Ljava/lang/Object;)V

    .line 770
    :cond_b
    const/16 v21, 0x1

    move/from16 v0, v21

    move-object/from16 v1, p0

    iput-boolean v0, v1, Lco/vine/android/widget/FeedAdapter;->mFirstPlayed:Z

    .line 773
    :cond_c
    return-void

    .line 656
    .end local v4    # "commentsContainer":Landroid/widget/LinearLayout;
    .end local v10    # "liked":Z
    .end local v14    # "revined":Z
    .end local v17    # "showComments":Z
    .restart local v5    # "description":Ljava/lang/String;
    .restart local v6    # "descriptionSb":Landroid/text/SpannableStringBuilder;
    .restart local v8    # "entity":Lco/vine/android/api/VineEntity;
    .restart local v9    # "i$":Ljava/util/Iterator;
    .restart local v13    # "postEntities":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineEntity;>;"
    :cond_d
    :try_start_1
    invoke-virtual {v8}, Lco/vine/android/api/VineEntity;->isTagType()Z

    move-result v21

    if-eqz v21, :cond_8

    .line 657
    new-instance v20, Lco/vine/android/widget/StyledClickableSpan;

    const/16 v21, 0x4

    iget-object v0, v8, Lco/vine/android/api/VineEntity;->title:Ljava/lang/String;

    move-object/from16 v22, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/widget/FeedAdapter;->mSpanClickListener:Lco/vine/android/widget/SpanClickListener;

    move-object/from16 v23, v0

    invoke-direct/range {v20 .. v23}, Lco/vine/android/widget/StyledClickableSpan;-><init>(ILjava/lang/Object;Lco/vine/android/widget/SpanClickListener;)V

    .line 660
    .restart local v20    # "usernameSpan":Lco/vine/android/widget/StyledClickableSpan;
    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/widget/FeedAdapter;->mProfileColor:I

    move/from16 v21, v0

    invoke-virtual/range {v20 .. v21}, Lco/vine/android/widget/StyledClickableSpan;->setColor(I)V

    .line 661
    iget v0, v8, Lco/vine/android/api/VineEntity;->start:I

    move/from16 v21, v0

    iget v0, v8, Lco/vine/android/api/VineEntity;->end:I

    move/from16 v22, v0

    const/16 v23, 0x21

    move-object/from16 v0, v20

    move/from16 v1, v21

    move/from16 v2, v22

    move/from16 v3, v23

    invoke-static {v6, v0, v1, v2, v3}, Lco/vine/android/util/Util;->safeSetSpan(Landroid/text/Spannable;Ljava/lang/Object;III)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto/16 :goto_3

    .line 671
    .end local v6    # "descriptionSb":Landroid/text/SpannableStringBuilder;
    .end local v8    # "entity":Lco/vine/android/api/VineEntity;
    .end local v9    # "i$":Ljava/util/Iterator;
    .end local v20    # "usernameSpan":Lco/vine/android/widget/StyledClickableSpan;
    :cond_e
    move-object/from16 v0, p1

    iget-object v0, v0, Lco/vine/android/widget/FeedViewHolder;->description:Landroid/widget/TextView;

    move-object/from16 v21, v0

    move-object/from16 v0, v21

    invoke-virtual {v0, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_4

    .line 677
    :cond_f
    move-object/from16 v0, p1

    iget-object v0, v0, Lco/vine/android/widget/FeedViewHolder;->description:Landroid/widget/TextView;

    move-object/from16 v21, v0

    const/16 v22, 0x3

    invoke-virtual/range {v21 .. v22}, Landroid/widget/TextView;->setGravity(I)V

    goto/16 :goto_5

    .line 681
    .end local v5    # "description":Ljava/lang/String;
    .end local v13    # "postEntities":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineEntity;>;"
    :cond_10
    move-object/from16 v0, p1

    iget-object v0, v0, Lco/vine/android/widget/FeedViewHolder;->description:Landroid/widget/TextView;

    move-object/from16 v21, v0

    const/16 v22, 0x8

    invoke-virtual/range {v21 .. v22}, Landroid/widget/TextView;->setVisibility(I)V

    goto/16 :goto_5

    .line 700
    .restart local v4    # "commentsContainer":Landroid/widget/LinearLayout;
    :cond_11
    const/16 v17, 0x0

    goto/16 :goto_6

    .line 713
    .restart local v17    # "showComments":Z
    :cond_12
    const/16 v21, 0x1

    move/from16 v0, v21

    move-object/from16 v1, p1

    iput v0, v1, Lco/vine/android/widget/FeedViewHolder;->commentType:I

    goto/16 :goto_7

    .line 716
    :cond_13
    const/16 v21, 0x8

    move/from16 v0, v21

    invoke-virtual {v4, v0}, Landroid/widget/LinearLayout;->setVisibility(I)V

    goto/16 :goto_7

    .line 725
    :cond_14
    invoke-virtual {v12}, Lco/vine/android/api/VinePost;->isLiked()Z

    move-result v10

    .line 726
    .restart local v10    # "liked":Z
    if-eqz v10, :cond_15

    .line 727
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/widget/FeedAdapter;->mLikeCache:Lco/vine/android/LikeCache;

    move-object/from16 v21, v0

    iget-wide v0, v12, Lco/vine/android/api/VinePost;->postId:J

    move-wide/from16 v22, v0

    invoke-virtual/range {v21 .. v23}, Lco/vine/android/LikeCache;->like(J)V

    goto/16 :goto_8

    .line 729
    :cond_15
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/widget/FeedAdapter;->mLikeCache:Lco/vine/android/LikeCache;

    move-object/from16 v21, v0

    iget-wide v0, v12, Lco/vine/android/api/VinePost;->postId:J

    move-wide/from16 v22, v0

    invoke-virtual/range {v21 .. v23}, Lco/vine/android/LikeCache;->unlike(J)V

    goto/16 :goto_8

    .line 749
    :cond_16
    iget-wide v0, v12, Lco/vine/android/api/VinePost;->myRepostId:J

    move-wide/from16 v21, v0

    const-wide/16 v23, 0x0

    cmp-long v21, v21, v23

    if-gtz v21, :cond_17

    invoke-virtual {v12}, Lco/vine/android/api/VinePost;->isRevined()Z

    move-result v21

    if-eqz v21, :cond_18

    :cond_17
    const/4 v14, 0x1

    .line 750
    .restart local v14    # "revined":Z
    :goto_a
    if-eqz v14, :cond_19

    .line 751
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/widget/FeedAdapter;->mRevineCache:Lco/vine/android/RevineCache;

    move-object/from16 v21, v0

    iget-wide v0, v12, Lco/vine/android/api/VinePost;->postId:J

    move-wide/from16 v22, v0

    iget-wide v0, v12, Lco/vine/android/api/VinePost;->myRepostId:J

    move-wide/from16 v24, v0

    invoke-virtual/range {v21 .. v25}, Lco/vine/android/RevineCache;->putMyRepostId(JJ)V

    .line 752
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/widget/FeedAdapter;->mRevineCache:Lco/vine/android/RevineCache;

    move-object/from16 v21, v0

    iget-wide v0, v12, Lco/vine/android/api/VinePost;->postId:J

    move-wide/from16 v22, v0

    invoke-virtual/range {v21 .. v23}, Lco/vine/android/RevineCache;->revine(J)V

    goto/16 :goto_9

    .line 749
    .end local v14    # "revined":Z
    :cond_18
    const/4 v14, 0x0

    goto :goto_a

    .line 754
    .restart local v14    # "revined":Z
    :cond_19
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/widget/FeedAdapter;->mRevineCache:Lco/vine/android/RevineCache;

    move-object/from16 v21, v0

    iget-wide v0, v12, Lco/vine/android/api/VinePost;->postId:J

    move-wide/from16 v22, v0

    invoke-virtual/range {v21 .. v23}, Lco/vine/android/RevineCache;->unRevine(J)V

    goto/16 :goto_9
.end method

.method private calculateCurrentPosition()I
    .locals 15

    .prologue
    .line 126
    iget-object v11, p0, Lco/vine/android/widget/FeedAdapter;->mListView:Landroid/widget/ListView;

    invoke-virtual {v11}, Landroid/widget/ListView;->getFirstVisiblePosition()I

    move-result v1

    .line 127
    .local v1, "currentFirst":I
    const/4 v8, 0x0

    .line 128
    .local v8, "offset":I
    iget-object v11, p0, Lco/vine/android/widget/FeedAdapter;->mViewOffsetResolver:Lco/vine/android/ViewOffsetResolver;

    if-eqz v11, :cond_0

    .line 129
    iget-object v11, p0, Lco/vine/android/widget/FeedAdapter;->mViewOffsetResolver:Lco/vine/android/ViewOffsetResolver;

    invoke-interface {v11, p0}, Lco/vine/android/ViewOffsetResolver;->getOffset(Landroid/widget/BaseAdapter;)I

    move-result v8

    .line 131
    :cond_0
    sub-int/2addr v1, v8

    .line 133
    iget-object v11, p0, Lco/vine/android/widget/FeedAdapter;->mTimelineFragment:Lco/vine/android/BaseTimelineFragment;

    invoke-virtual {v11}, Lco/vine/android/BaseTimelineFragment;->getHeaderViewParents()Ljava/util/HashSet;

    move-result-object v4

    .line 134
    .local v4, "headers":Ljava/util/HashSet;, "Ljava/util/HashSet<Landroid/view/View;>;"
    invoke-virtual {v4}, Ljava/util/HashSet;->size()I

    move-result v11

    if-lez v11, :cond_3

    .line 135
    const/4 v7, 0x0

    .line 136
    .local v7, "missingHeaderViewCount":I
    invoke-virtual {v4}, Ljava/util/HashSet;->iterator()Ljava/util/Iterator;

    move-result-object v6

    .local v6, "i$":Ljava/util/Iterator;
    :cond_1
    :goto_0
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v11

    if-eqz v11, :cond_2

    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Landroid/view/View;

    .line 137
    .local v10, "view":Landroid/view/View;
    invoke-virtual {v10}, Landroid/view/View;->isShown()Z

    move-result v11

    if-nez v11, :cond_1

    .line 138
    add-int/lit8 v7, v7, 0x1

    goto :goto_0

    .line 141
    .end local v10    # "view":Landroid/view/View;
    :cond_2
    sub-int/2addr v1, v7

    .line 142
    const-string v11, "Try to get current First: {}, missing header count: {}"

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v12

    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v13

    invoke-static {v11, v12, v13}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 145
    .end local v6    # "i$":Ljava/util/Iterator;
    .end local v7    # "missingHeaderViewCount":I
    :cond_3
    invoke-virtual {p0, v1}, Lco/vine/android/widget/FeedAdapter;->getViewAtPosition(I)Landroid/view/View;

    move-result-object v2

    .line 146
    .local v2, "currentView":Landroid/view/View;
    if-nez v2, :cond_5

    .line 147
    const/4 v1, -0x1

    .line 166
    .end local v1    # "currentFirst":I
    :cond_4
    :goto_1
    return v1

    .line 150
    .restart local v1    # "currentFirst":I
    :cond_5
    const/4 v3, 0x0

    .line 151
    .local v3, "currentlyPlayingOffset":I
    invoke-virtual {p0}, Lco/vine/android/widget/FeedAdapter;->getLastPlayer()Lco/vine/android/player/SdkVideoView;

    move-result-object v11

    if-eqz v11, :cond_6

    .line 152
    invoke-virtual {p0}, Lco/vine/android/widget/FeedAdapter;->getLastPlayer()Lco/vine/android/player/SdkVideoView;

    move-result-object v11

    invoke-virtual {v11}, Lco/vine/android/player/SdkVideoView;->getHeight()I

    move-result v11

    div-int/lit8 v3, v11, 0x2

    .line 154
    :cond_6
    invoke-virtual {v2}, Landroid/view/View;->getBottom()I

    move-result v11

    int-to-float v11, v11

    int-to-float v12, v3

    add-float v0, v11, v12

    .line 155
    .local v0, "bottom":F
    invoke-virtual {v2}, Landroid/view/View;->getHeight()I

    move-result v11

    int-to-float v11, v11

    int-to-float v12, v3

    add-float v5, v11, v12

    .line 156
    .local v5, "height":F
    const/4 v11, 0x0

    cmpl-float v11, v5, v11

    if-nez v11, :cond_7

    const/high16 v5, 0x3f800000    # 1.0f

    .end local v5    # "height":F
    :cond_7
    div-float v9, v0, v5

    .line 157
    .local v9, "ratio":F
    const-string v11, "Current First: {}, ratio: {}"

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v12

    invoke-static {v9}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v13

    invoke-static {v11, v12, v13}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 158
    float-to-double v11, v9

    const-wide/high16 v13, 0x3fe0000000000000L    # 0.5

    cmpg-double v11, v11, v13

    if-ltz v11, :cond_8

    const/4 v11, -0x1

    if-ne v1, v11, :cond_9

    invoke-virtual {p0}, Lco/vine/android/widget/FeedAdapter;->getCount()I

    move-result v11

    add-int/lit8 v11, v11, -0x1

    if-ge v1, v11, :cond_9

    add-int/lit8 v11, v1, 0x1

    iget v12, p0, Lco/vine/android/widget/FeedAdapter;->mCurrentPlaying:I

    if-eq v11, v12, :cond_9

    .line 162
    :cond_8
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 163
    :cond_9
    iget v11, p0, Lco/vine/android/widget/FeedAdapter;->mCurrentPlaying:I

    if-ne v1, v11, :cond_4

    .line 166
    const/4 v1, -0x1

    goto :goto_1
.end method

.method private countedMediaPlayerStart(Lco/vine/android/player/VideoViewInterface;J)V
    .locals 4
    .param p1, "view"    # Lco/vine/android/player/VideoViewInterface;
    .param p2, "postId"    # J

    .prologue
    .line 479
    invoke-interface {p1}, Lco/vine/android/player/VideoViewInterface;->start()V

    .line 480
    iget-object v0, p0, Lco/vine/android/widget/FeedAdapter;->mLoopCountHandler:Landroid/os/Handler;

    new-instance v1, Lco/vine/android/widget/FeedAdapter$LoopCountRunnable;

    iget v2, p0, Lco/vine/android/widget/FeedAdapter;->mCurrentPlaying:I

    invoke-direct {v1, p0, v2, p2, p3}, Lco/vine/android/widget/FeedAdapter$LoopCountRunnable;-><init>(Lco/vine/android/widget/FeedAdapter;IJ)V

    const-wide/16 v2, 0x1f4

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 481
    return-void
.end method

.method private getExplicit(I)Z
    .locals 3
    .param p1, "position"    # I

    .prologue
    .line 358
    invoke-direct {p0, p1}, Lco/vine/android/widget/FeedAdapter;->getPost(I)Lco/vine/android/api/VinePost;

    move-result-object v0

    .line 359
    .local v0, "post":Lco/vine/android/api/VinePost;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lco/vine/android/api/VinePost;->isExplicit()Z

    move-result v1

    if-eqz v1, :cond_0

    iget-object v1, p0, Lco/vine/android/widget/FeedAdapter;->mDismissedWarnings:Ljava/util/HashSet;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/util/HashSet;->contains(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    const/4 v1, 0x1

    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method private getPost(I)Lco/vine/android/api/VinePost;
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 310
    if-ltz p1, :cond_0

    iget-object v0, p0, Lco/vine/android/widget/FeedAdapter;->mPosts:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ge p1, v0, :cond_0

    .line 311
    iget-object v0, p0, Lco/vine/android/widget/FeedAdapter;->mPosts:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/api/VinePost;

    .line 313
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private hasPlayerPlaying()Z
    .locals 1

    .prologue
    .line 363
    iget-object v0, p0, Lco/vine/android/widget/FeedAdapter;->mLastPlayer:Lco/vine/android/player/SdkVideoView;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/widget/FeedAdapter;->mLastPlayer:Lco/vine/android/player/SdkVideoView;

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

.method private initVideoView(ILco/vine/android/widget/FeedViewHolder;)V
    .locals 3
    .param p1, "position"    # I
    .param p2, "tag"    # Lco/vine/android/widget/FeedViewHolder;

    .prologue
    .line 416
    iget-object v1, p2, Lco/vine/android/widget/FeedViewHolder;->videoLoadImage:Landroid/widget/ProgressBar;

    const/16 v2, 0x8

    invoke-virtual {v1, v2}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 417
    iget-object v0, p2, Lco/vine/android/widget/FeedViewHolder;->videoView:Lco/vine/android/player/SdkVideoView;

    .line 418
    .local v0, "view":Lco/vine/android/player/SdkVideoView;
    new-instance v1, Lco/vine/android/widget/FeedAdapter$1;

    invoke-direct {v1, p0, p2}, Lco/vine/android/widget/FeedAdapter$1;-><init>(Lco/vine/android/widget/FeedAdapter;Lco/vine/android/widget/FeedViewHolder;)V

    invoke-virtual {v0, v1}, Lco/vine/android/player/SdkVideoView;->setOnPreparedListener(Lco/vine/android/player/VideoViewInterface$OnPreparedListener;)V

    .line 430
    new-instance v1, Lco/vine/android/widget/FeedAdapter$2;

    invoke-direct {v1, p0, v0, p1, p2}, Lco/vine/android/widget/FeedAdapter$2;-><init>(Lco/vine/android/widget/FeedAdapter;Lco/vine/android/player/SdkVideoView;ILco/vine/android/widget/FeedViewHolder;)V

    invoke-virtual {v0, v1}, Lco/vine/android/player/SdkVideoView;->setOnErrorListener(Lco/vine/android/player/VideoViewInterface$OnErrorListener;)V

    .line 454
    new-instance v1, Lco/vine/android/widget/FeedAdapter$3;

    invoke-direct {v1, p0, p2}, Lco/vine/android/widget/FeedAdapter$3;-><init>(Lco/vine/android/widget/FeedAdapter;Lco/vine/android/widget/FeedViewHolder;)V

    invoke-virtual {v0, v1}, Lco/vine/android/player/SdkVideoView;->setOnCompletionListener(Lco/vine/android/player/VideoViewInterface$OnCompletionListener;)V

    .line 467
    new-instance v1, Lco/vine/android/widget/FeedAdapter$4;

    invoke-direct {v1, p0}, Lco/vine/android/widget/FeedAdapter$4;-><init>(Lco/vine/android/widget/FeedAdapter;)V

    invoke-virtual {v0, v1}, Lco/vine/android/player/SdkVideoView;->setSurfaceReadyListener(Lco/vine/android/player/SdkVideoView$SurfaceReadyListener;)V

    .line 475
    iget-object v1, p0, Lco/vine/android/widget/FeedAdapter;->mPlayers:Landroid/util/SparseArray;

    invoke-virtual {v1, p1, v0}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    .line 476
    return-void
.end method

.method private preFetch(I)Z
    .locals 9
    .param p1, "requestedPosition"    # I

    .prologue
    const/4 v5, 0x1

    const/4 v6, 0x0

    .line 317
    iget-object v7, p0, Lco/vine/android/widget/FeedAdapter;->mPosts:Ljava/util/ArrayList;

    invoke-virtual {v7}, Ljava/util/ArrayList;->size()I

    move-result v7

    if-ge p1, v7, :cond_6

    .line 318
    invoke-direct {p0, p1}, Lco/vine/android/widget/FeedAdapter;->getPost(I)Lco/vine/android/api/VinePost;

    move-result-object v3

    .line 319
    .local v3, "nextPost":Lco/vine/android/api/VinePost;
    if-eqz v3, :cond_5

    .line 320
    iget-object v7, p0, Lco/vine/android/widget/FeedAdapter;->mPaths:Landroid/util/SparseArray;

    invoke-virtual {v7, p1}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v7

    if-nez v7, :cond_4

    .line 321
    invoke-direct {p0, p1}, Lco/vine/android/widget/FeedAdapter;->getPost(I)Lco/vine/android/api/VinePost;

    move-result-object v7

    invoke-virtual {p0, v7, v6}, Lco/vine/android/widget/FeedAdapter;->getRequestKey(Lco/vine/android/api/VinePost;Z)Lco/vine/android/util/video/VideoKey;

    move-result-object v4

    .line 322
    .local v4, "nextUrl":Lco/vine/android/util/video/VideoKey;
    const-string v6, "Pre-fetch {}: {}"

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    invoke-static {v6, v7, v4}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 323
    if-eqz v4, :cond_2

    .line 324
    iget-object v6, v3, Lco/vine/android/api/VinePost;->thumbnailUrl:Ljava/lang/String;

    if-eqz v6, :cond_0

    .line 325
    new-instance v1, Lco/vine/android/util/image/ImageKey;

    iget-object v6, v3, Lco/vine/android/api/VinePost;->thumbnailUrl:Ljava/lang/String;

    invoke-direct {v1, v6}, Lco/vine/android/util/image/ImageKey;-><init>(Ljava/lang/String;)V

    .line 326
    .local v1, "imageKey":Lco/vine/android/util/image/ImageKey;
    iget-object v6, p0, Lco/vine/android/widget/FeedAdapter;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v6, v1}, Lco/vine/android/client/AppController;->getPhotoBitmap(Lco/vine/android/util/image/ImageKey;)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 327
    .local v0, "bitmap":Landroid/graphics/Bitmap;
    if-eqz v0, :cond_0

    .line 328
    iget-object v6, p0, Lco/vine/android/widget/FeedAdapter;->mThumbnails:Landroid/util/SparseArray;

    invoke-virtual {v6, p1, v0}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    .line 331
    .end local v0    # "bitmap":Landroid/graphics/Bitmap;
    .end local v1    # "imageKey":Lco/vine/android/util/image/ImageKey;
    :cond_0
    iget-object v6, v3, Lco/vine/android/api/VinePost;->avatarUrl:Ljava/lang/String;

    if-eqz v6, :cond_1

    .line 332
    new-instance v1, Lco/vine/android/util/image/ImageKey;

    iget-object v6, v3, Lco/vine/android/api/VinePost;->avatarUrl:Ljava/lang/String;

    invoke-direct {v1, v6, v5}, Lco/vine/android/util/image/ImageKey;-><init>(Ljava/lang/String;Z)V

    .line 333
    .restart local v1    # "imageKey":Lco/vine/android/util/image/ImageKey;
    iget-object v6, p0, Lco/vine/android/widget/FeedAdapter;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v6, v1}, Lco/vine/android/client/AppController;->getPhotoBitmap(Lco/vine/android/util/image/ImageKey;)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 334
    .restart local v0    # "bitmap":Landroid/graphics/Bitmap;
    if-eqz v0, :cond_1

    .line 335
    iget-object v6, p0, Lco/vine/android/widget/FeedAdapter;->mAvatars:Landroid/util/SparseArray;

    invoke-virtual {v6, p1, v0}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    .line 338
    .end local v0    # "bitmap":Landroid/graphics/Bitmap;
    .end local v1    # "imageKey":Lco/vine/android/util/image/ImageKey;
    :cond_1
    iget-object v6, p0, Lco/vine/android/widget/FeedAdapter;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v6, v4}, Lco/vine/android/client/AppController;->getVideoFilePath(Lco/vine/android/util/video/VideoKey;)Ljava/lang/String;

    move-result-object v2

    .line 339
    .local v2, "nextPath":Ljava/lang/String;
    if-eqz v2, :cond_3

    .line 340
    iget-object v6, p0, Lco/vine/android/widget/FeedAdapter;->mPaths:Landroid/util/SparseArray;

    invoke-virtual {v6, p1, v2}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    .line 354
    .end local v2    # "nextPath":Ljava/lang/String;
    .end local v3    # "nextPost":Lco/vine/android/api/VinePost;
    .end local v4    # "nextUrl":Lco/vine/android/util/video/VideoKey;
    :cond_2
    :goto_0
    return v5

    .line 342
    .restart local v2    # "nextPath":Ljava/lang/String;
    .restart local v3    # "nextPost":Lco/vine/android/api/VinePost;
    .restart local v4    # "nextUrl":Lco/vine/android/util/video/VideoKey;
    :cond_3
    iget-object v6, p0, Lco/vine/android/widget/FeedAdapter;->mUrlReverse:Ljava/util/HashMap;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    invoke-virtual {v6, v4, v7}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 346
    .end local v2    # "nextPath":Ljava/lang/String;
    .end local v4    # "nextUrl":Lco/vine/android/util/video/VideoKey;
    :cond_4
    const-string v6, "{} is already fetched."

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    invoke-static {v6, v7}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    goto :goto_0

    .line 350
    :cond_5
    const-string v5, "End of list, no pre-fetching: {} {}"

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    invoke-virtual {p0}, Lco/vine/android/widget/FeedAdapter;->getCount()I

    move-result v8

    invoke-static {v8}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    invoke-static {v5, v7, v8}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    move v5, v6

    .line 351
    goto :goto_0

    .end local v3    # "nextPost":Lco/vine/android/api/VinePost;
    :cond_6
    move v5, v6

    .line 354
    goto :goto_0
.end method

.method private refreshVideoView(ILco/vine/android/widget/FeedViewHolder;)V
    .locals 6
    .param p1, "position"    # I
    .param p2, "tag"    # Lco/vine/android/widget/FeedViewHolder;

    .prologue
    .line 395
    iget-object v3, p2, Lco/vine/android/widget/FeedViewHolder;->videoView:Lco/vine/android/player/SdkVideoView;

    invoke-virtual {v3}, Lco/vine/android/player/SdkVideoView;->getParent()Landroid/view/ViewParent;

    move-result-object v2

    check-cast v2, Landroid/view/ViewGroup;

    .line 396
    .local v2, "group":Landroid/view/ViewGroup;
    iget-object v3, p0, Lco/vine/android/widget/FeedAdapter;->mVideoAttr:Landroid/util/AttributeSet;

    if-nez v3, :cond_0

    .line 397
    iget-object v3, p2, Lco/vine/android/widget/FeedViewHolder;->videoView:Lco/vine/android/player/SdkVideoView;

    invoke-virtual {v3}, Lco/vine/android/player/SdkVideoView;->getAttributes()Landroid/util/AttributeSet;

    move-result-object v3

    iput-object v3, p0, Lco/vine/android/widget/FeedAdapter;->mVideoAttr:Landroid/util/AttributeSet;

    .line 399
    :cond_0
    iget-object v3, p2, Lco/vine/android/widget/FeedViewHolder;->videoView:Lco/vine/android/player/SdkVideoView;

    invoke-virtual {v3}, Lco/vine/android/player/SdkVideoView;->suspend()V

    .line 401
    :try_start_0
    iget-object v3, p2, Lco/vine/android/widget/FeedViewHolder;->videoView:Lco/vine/android/player/SdkVideoView;

    invoke-virtual {v2, v3}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    .line 409
    :goto_0
    new-instance v3, Lco/vine/android/player/SdkVideoView;

    iget-object v4, p0, Lco/vine/android/widget/FeedAdapter;->mContext:Landroid/content/Context;

    iget-object v5, p0, Lco/vine/android/widget/FeedAdapter;->mVideoAttr:Landroid/util/AttributeSet;

    invoke-direct {v3, v4, v5}, Lco/vine/android/player/SdkVideoView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    iput-object v3, p2, Lco/vine/android/widget/FeedViewHolder;->videoView:Lco/vine/android/player/SdkVideoView;

    .line 410
    iget-object v3, p2, Lco/vine/android/widget/FeedViewHolder;->videoView:Lco/vine/android/player/SdkVideoView;

    const v4, 0x7f0a0075

    invoke-virtual {v3, v4}, Lco/vine/android/player/SdkVideoView;->setId(I)V

    .line 411
    iget-object v3, p2, Lco/vine/android/widget/FeedViewHolder;->videoView:Lco/vine/android/player/SdkVideoView;

    invoke-virtual {v2, v3}, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V

    .line 412
    invoke-direct {p0, p1, p2}, Lco/vine/android/widget/FeedAdapter;->initVideoView(ILco/vine/android/widget/FeedViewHolder;)V

    .line 413
    return-void

    .line 402
    :catch_0
    move-exception v0

    .line 404
    .local v0, "e":Ljava/lang/RuntimeException;
    :try_start_1
    iget-object v3, p2, Lco/vine/android/widget/FeedViewHolder;->videoView:Lco/vine/android/player/SdkVideoView;

    invoke-virtual {v2, v3}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    goto :goto_0

    .line 405
    :catch_1
    move-exception v1

    .line 406
    .local v1, "e2":Ljava/lang/Exception;
    const-string v3, "Weird things are happening."

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/Object;

    invoke-static {v0, v3, v4}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0
.end method

.method private shouldShowThumbnail(I)Z
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 577
    iget v0, p0, Lco/vine/android/widget/FeedAdapter;->mCurrentPlaying:I

    if-ne v0, p1, :cond_0

    invoke-direct {p0}, Lco/vine/android/widget/FeedAdapter;->hasPlayerPlaying()Z

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


# virtual methods
.method protected createInsensitiveListener(Lco/vine/android/widget/FeedViewHolder;)V
    .locals 2
    .param p1, "h"    # Lco/vine/android/widget/FeedViewHolder;

    .prologue
    .line 868
    iget-object v0, p1, Lco/vine/android/widget/FeedViewHolder;->sensitiveTextContainer:Landroid/widget/LinearLayout;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 869
    iget-object v0, p1, Lco/vine/android/widget/FeedViewHolder;->sensitiveTextContainer:Landroid/widget/LinearLayout;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 870
    iget-object v0, p1, Lco/vine/android/widget/FeedViewHolder;->sensitiveTextContainer:Landroid/widget/LinearLayout;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setClickable(Z)V

    .line 871
    return-void
.end method

.method protected bridge synthetic createInsensitiveListener(Lco/vine/android/widget/GenericFeedViewHolder;)V
    .locals 0
    .param p1, "x0"    # Lco/vine/android/widget/GenericFeedViewHolder;

    .prologue
    .line 63
    check-cast p1, Lco/vine/android/widget/FeedViewHolder;

    .end local p1    # "x0":Lco/vine/android/widget/GenericFeedViewHolder;
    invoke-virtual {p0, p1}, Lco/vine/android/widget/FeedAdapter;->createInsensitiveListener(Lco/vine/android/widget/FeedViewHolder;)V

    return-void
.end method

.method protected createSensitiveLisenter(Lco/vine/android/widget/FeedViewHolder;)V
    .locals 3
    .param p1, "h"    # Lco/vine/android/widget/FeedViewHolder;

    .prologue
    const/4 v2, 0x1

    .line 860
    new-instance v0, Lco/vine/android/player/VideoSensitiveImageClickListener;

    iget-object v1, p0, Lco/vine/android/widget/FeedAdapter;->mDismissedWarnings:Ljava/util/HashSet;

    invoke-direct {v0, p0, v1}, Lco/vine/android/player/VideoSensitiveImageClickListener;-><init>(Lco/vine/android/player/HasVideoPlayerAdapter;Ljava/util/HashSet;)V

    iput-object v0, p1, Lco/vine/android/widget/FeedViewHolder;->imageListener:Lco/vine/android/player/SensitiveImageClickListener;

    .line 861
    iget-object v0, p1, Lco/vine/android/widget/FeedViewHolder;->sensitiveTextContainer:Landroid/widget/LinearLayout;

    iget-object v1, p1, Lco/vine/android/widget/FeedViewHolder;->imageListener:Lco/vine/android/player/SensitiveImageClickListener;

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 862
    iget-object v0, p1, Lco/vine/android/widget/FeedViewHolder;->sensitiveTextContainer:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->setClickable(Z)V

    .line 863
    iput-boolean v2, p1, Lco/vine/android/widget/FeedViewHolder;->isVideoImageLoaded:Z

    .line 864
    return-void
.end method

.method protected bridge synthetic createSensitiveLisenter(Lco/vine/android/widget/GenericFeedViewHolder;)V
    .locals 0
    .param p1, "x0"    # Lco/vine/android/widget/GenericFeedViewHolder;

    .prologue
    .line 63
    check-cast p1, Lco/vine/android/widget/FeedViewHolder;

    .end local p1    # "x0":Lco/vine/android/widget/GenericFeedViewHolder;
    invoke-virtual {p0, p1}, Lco/vine/android/widget/FeedAdapter;->createSensitiveLisenter(Lco/vine/android/widget/FeedViewHolder;)V

    return-void
.end method

.method public getCount()I
    .locals 1

    .prologue
    .line 885
    iget-object v0, p0, Lco/vine/android/widget/FeedAdapter;->mPosts:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    return v0
.end method

.method protected getHolderFromPosition(I)Lco/vine/android/widget/FeedViewHolder;
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 811
    iget-object v1, p0, Lco/vine/android/widget/FeedAdapter;->mViewHolders:Ljava/util/ArrayList;

    invoke-virtual {v1, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/ref/WeakReference;

    .line 812
    .local v0, "p":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/widget/FeedViewHolder;>;"
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lco/vine/android/widget/FeedViewHolder;

    :goto_0
    return-object v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public getItem(I)Ljava/lang/Object;
    .locals 1
    .param p1, "i"    # I

    .prologue
    .line 890
    invoke-direct {p0, p1}, Lco/vine/android/widget/FeedAdapter;->getPost(I)Lco/vine/android/api/VinePost;

    move-result-object v0

    return-object v0
.end method

.method public getItemId(I)J
    .locals 2
    .param p1, "postition"    # I

    .prologue
    .line 914
    int-to-long v0, p1

    return-wide v0
.end method

.method public getLastPlayer()Lco/vine/android/player/SdkVideoView;
    .locals 1

    .prologue
    .line 875
    iget-object v0, p0, Lco/vine/android/widget/FeedAdapter;->mLastPlayer:Lco/vine/android/player/SdkVideoView;

    return-object v0
.end method

.method public getPinnedHeaderHeight()I
    .locals 1

    .prologue
    .line 983
    iget v0, p0, Lco/vine/android/widget/FeedAdapter;->mPinnedHeaderHeight:I

    return v0
.end method

.method public getPinnedHeaderStatus(I)Lco/vine/android/widget/PinnedHeaderAdapter$PinnedHeaderStatus;
    .locals 13
    .param p1, "navBottom"    # I

    .prologue
    const/4 v10, 0x1

    const/4 v11, 0x0

    .line 925
    iget v4, p0, Lco/vine/android/widget/FeedAdapter;->mPinnedHeaderPosition:I

    .line 926
    .local v4, "pinnedHeaderPosition":I
    iget-object v9, p0, Lco/vine/android/widget/FeedAdapter;->mListView:Landroid/widget/ListView;

    check-cast v9, Lco/vine/android/widget/PinnedHeaderListView;

    invoke-virtual {v9, p1}, Lco/vine/android/widget/PinnedHeaderListView;->getPositionForPixelLocation(I)I

    move-result v9

    iput v9, p0, Lco/vine/android/widget/FeedAdapter;->mPinnedHeaderListViewChildIndex:I

    .line 927
    iget-object v9, p0, Lco/vine/android/widget/FeedAdapter;->mListView:Landroid/widget/ListView;

    invoke-virtual {v9}, Landroid/widget/ListView;->getFirstVisiblePosition()I

    move-result v9

    iget-object v12, p0, Lco/vine/android/widget/FeedAdapter;->mListView:Landroid/widget/ListView;

    invoke-virtual {v12}, Landroid/widget/ListView;->getHeaderViewsCount()I

    move-result v12

    sub-int/2addr v9, v12

    iget v12, p0, Lco/vine/android/widget/FeedAdapter;->mPinnedHeaderListViewChildIndex:I

    add-int/2addr v9, v12

    iput v9, p0, Lco/vine/android/widget/FeedAdapter;->mPinnedHeaderPosition:I

    .line 928
    iget-object v9, p0, Lco/vine/android/widget/FeedAdapter;->mListView:Landroid/widget/ListView;

    iget v12, p0, Lco/vine/android/widget/FeedAdapter;->mPinnedHeaderListViewChildIndex:I

    invoke-virtual {v9, v12}, Landroid/widget/ListView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 929
    .local v0, "child":Landroid/view/View;
    const/4 v3, 0x0

    .line 930
    .local v3, "offset":I
    const/4 v7, 0x1

    .line 931
    .local v7, "show":Z
    if-eqz v0, :cond_2

    .line 932
    invoke-virtual {v0}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lco/vine/android/widget/FeedViewHolder;

    .line 933
    .local v2, "h":Lco/vine/android/widget/FeedViewHolder;
    if-eqz v2, :cond_2

    move-object v9, v0

    .line 934
    check-cast v9, Landroid/view/ViewGroup;

    invoke-virtual {v9, v11}, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v5

    .line 935
    .local v5, "reviners":Landroid/view/View;
    invoke-virtual {v5}, Landroid/view/View;->getVisibility()I

    move-result v9

    if-nez v9, :cond_5

    move v6, v10

    .line 937
    .local v6, "revinersVisible":Z
    :goto_0
    invoke-virtual {v0}, Landroid/view/View;->getTop()I

    move-result v8

    .line 940
    .local v8, "viewTop":I
    invoke-virtual {v0}, Landroid/view/View;->getTop()I

    move-result v9

    iget-object v12, v2, Lco/vine/android/widget/FeedViewHolder;->divider:Landroid/view/View;

    invoke-virtual {v12}, Landroid/view/View;->getTop()I

    move-result v12

    add-int v1, v9, v12

    .line 947
    .local v1, "dividerTop":I
    iget v9, p0, Lco/vine/android/widget/FeedAdapter;->mPinnedHeaderHeight:I

    add-int/2addr v9, p1

    iget v12, p0, Lco/vine/android/widget/FeedAdapter;->mDividerScrollAwayPadding:I

    add-int/2addr v9, v12

    if-ge v1, v9, :cond_0

    .line 948
    iget v9, p0, Lco/vine/android/widget/FeedAdapter;->mPinnedHeaderHeight:I

    sub-int v9, v1, v9

    sub-int v3, v9, p1

    .line 950
    :cond_0
    if-eqz v6, :cond_1

    invoke-virtual {v5}, Landroid/view/View;->getHeight()I

    move-result v9

    sub-int v9, p1, v9

    if-gt v8, v9, :cond_6

    :cond_1
    move v7, v10

    .line 954
    .end local v1    # "dividerTop":I
    .end local v2    # "h":Lco/vine/android/widget/FeedViewHolder;
    .end local v5    # "reviners":Landroid/view/View;
    .end local v6    # "revinersVisible":Z
    .end local v8    # "viewTop":I
    :cond_2
    :goto_1
    new-instance v9, Lco/vine/android/widget/PinnedHeaderAdapter$PinnedHeaderStatus;

    iget-object v12, p0, Lco/vine/android/widget/FeedAdapter;->mPinnedHeaderView:Landroid/view/View;

    if-eqz v12, :cond_3

    iget v12, p0, Lco/vine/android/widget/FeedAdapter;->mPinnedHeaderPosition:I

    if-eq v4, v12, :cond_4

    :cond_3
    move v11, v10

    :cond_4
    invoke-direct {v9, v3, v11, v7}, Lco/vine/android/widget/PinnedHeaderAdapter$PinnedHeaderStatus;-><init>(IZZ)V

    return-object v9

    .restart local v2    # "h":Lco/vine/android/widget/FeedViewHolder;
    .restart local v5    # "reviners":Landroid/view/View;
    :cond_5
    move v6, v11

    .line 935
    goto :goto_0

    .restart local v1    # "dividerTop":I
    .restart local v6    # "revinersVisible":Z
    .restart local v8    # "viewTop":I
    :cond_6
    move v7, v11

    .line 950
    goto :goto_1
.end method

.method public getPinnedHeaderView(Landroid/view/View;)Landroid/view/View;
    .locals 4
    .param p1, "convertView"    # Landroid/view/View;

    .prologue
    .line 968
    iget-object v2, p0, Lco/vine/android/widget/FeedAdapter;->mListView:Landroid/widget/ListView;

    iget v3, p0, Lco/vine/android/widget/FeedAdapter;->mPinnedHeaderListViewChildIndex:I

    invoke-virtual {v2, v3}, Landroid/widget/ListView;->getChildAt(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/view/ViewGroup;

    .line 969
    .local v1, "topLevelView":Landroid/view/ViewGroup;
    if-eqz v1, :cond_1

    .line 970
    const v2, 0x7f0a0152

    invoke-virtual {v1, v2}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .line 971
    .local v0, "pinnedView":Landroid/view/View;
    if-eqz v0, :cond_0

    .line 972
    const/4 v2, -0x1

    invoke-virtual {v0, v2}, Landroid/view/View;->setBackgroundColor(I)V

    .line 974
    :cond_0
    iput-object v0, p0, Lco/vine/android/widget/FeedAdapter;->mPinnedHeaderView:Landroid/view/View;

    .line 977
    .end local v0    # "pinnedView":Landroid/view/View;
    :goto_0
    return-object v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getPlayer(IZ)Lco/vine/android/player/SdkVideoView;
    .locals 1
    .param p1, "position"    # I
    .param p2, "b"    # Z

    .prologue
    .line 382
    iget-object v0, p0, Lco/vine/android/widget/FeedAdapter;->mPlayers:Landroid/util/SparseArray;

    invoke-virtual {v0, p1}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/player/SdkVideoView;

    return-object v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 5
    .param p1, "i"    # I
    .param p2, "view"    # Landroid/view/View;
    .param p3, "viewGroup"    # Landroid/view/ViewGroup;
    .annotation build Lorg/jetbrains/annotations/Nullable;
    .end annotation

    .prologue
    .line 897
    if-nez p2, :cond_0

    .line 898
    invoke-virtual {p0}, Lco/vine/android/widget/FeedAdapter;->newView()Landroid/view/View;

    move-result-object p2

    .line 900
    :cond_0
    invoke-virtual {p2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/widget/FeedViewHolder;

    .line 901
    .local v0, "h":Lco/vine/android/widget/FeedViewHolder;
    invoke-direct {p0, p1}, Lco/vine/android/widget/FeedAdapter;->getPost(I)Lco/vine/android/api/VinePost;

    move-result-object v1

    iput-object v1, v0, Lco/vine/android/widget/FeedViewHolder;->post:Lco/vine/android/api/VinePost;

    .line 902
    iput p1, v0, Lco/vine/android/widget/FeedViewHolder;->position:I

    .line 904
    iget-object v1, v0, Lco/vine/android/widget/FeedViewHolder;->post:Lco/vine/android/api/VinePost;

    if-eqz v1, :cond_1

    .line 905
    invoke-direct {p0, v0}, Lco/vine/android/widget/FeedAdapter;->bindView(Lco/vine/android/widget/FeedViewHolder;)V

    .line 909
    :goto_0
    return-object p2

    .line 907
    :cond_1
    const-string v1, "Post null: {} {}"

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x1

    iget-object v4, p0, Lco/vine/android/widget/FeedAdapter;->mPosts:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    move-result v4

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v1, v2}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0
.end method

.method public isPlaying()Z
    .locals 1

    .prologue
    .line 391
    invoke-direct {p0}, Lco/vine/android/widget/FeedAdapter;->hasPlayerPlaying()Z

    move-result v0

    return v0
.end method

.method public layoutPinnedHeader(Landroid/view/View;IIII)V
    .locals 0
    .param p1, "header"    # Landroid/view/View;
    .param p2, "l"    # I
    .param p3, "t"    # I
    .param p4, "r"    # I
    .param p5, "b"    # I

    .prologue
    .line 960
    return-void
.end method

.method public mergeMyPost(Lco/vine/android/api/VinePost;)V
    .locals 2
    .param p1, "post"    # Lco/vine/android/api/VinePost;

    .prologue
    .line 93
    if-eqz p1, :cond_0

    .line 94
    iget-object v0, p0, Lco/vine/android/widget/FeedAdapter;->mPosts:Ljava/util/ArrayList;

    const/4 v1, 0x0

    invoke-virtual {v0, v1, p1}, Ljava/util/ArrayList;->add(ILjava/lang/Object;)V

    .line 95
    iget-object v0, p0, Lco/vine/android/widget/FeedAdapter;->mPaths:Landroid/util/SparseArray;

    invoke-virtual {v0}, Landroid/util/SparseArray;->clear()V

    .line 96
    iget-object v0, p0, Lco/vine/android/widget/FeedAdapter;->mUrlReverse:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->clear()V

    .line 97
    iget-object v0, p0, Lco/vine/android/widget/FeedAdapter;->mPlayers:Landroid/util/SparseArray;

    invoke-virtual {v0}, Landroid/util/SparseArray;->clear()V

    .line 98
    invoke-virtual {p0}, Lco/vine/android/widget/FeedAdapter;->notifyDataSetChanged()V

    .line 99
    invoke-virtual {p0}, Lco/vine/android/widget/FeedAdapter;->playCurrentPosition()V

    .line 101
    :cond_0
    return-void
.end method

.method public mergePost(Lco/vine/android/api/VinePost;)V
    .locals 2
    .param p1, "post"    # Lco/vine/android/api/VinePost;

    .prologue
    .line 918
    iget-object v0, p0, Lco/vine/android/widget/FeedAdapter;->mPosts:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 919
    iget-object v0, p0, Lco/vine/android/widget/FeedAdapter;->mPosts:Ljava/util/ArrayList;

    const/4 v1, 0x0

    invoke-virtual {v0, v1, p1}, Ljava/util/ArrayList;->add(ILjava/lang/Object;)V

    .line 920
    invoke-virtual {p0}, Lco/vine/android/widget/FeedAdapter;->notifyDataSetChanged()V

    .line 921
    return-void
.end method

.method public mergePosts(Ljava/util/ArrayList;Z)V
    .locals 1
    .param p2, "mergeAfter"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VinePost;",
            ">;Z)V"
        }
    .end annotation

    .prologue
    .line 1042
    .local p1, "newPosts":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VinePost;>;"
    if-nez p2, :cond_0

    .line 1043
    iget-object v0, p0, Lco/vine/android/widget/FeedAdapter;->mPosts:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 1044
    iget-object v0, p0, Lco/vine/android/widget/FeedAdapter;->mPaths:Landroid/util/SparseArray;

    invoke-virtual {v0}, Landroid/util/SparseArray;->clear()V

    .line 1045
    iget-object v0, p0, Lco/vine/android/widget/FeedAdapter;->mPlayers:Landroid/util/SparseArray;

    invoke-virtual {v0}, Landroid/util/SparseArray;->clear()V

    .line 1046
    iget-object v0, p0, Lco/vine/android/widget/FeedAdapter;->mUrlReverse:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->clear()V

    .line 1048
    :cond_0
    iget-object v0, p0, Lco/vine/android/widget/FeedAdapter;->mPosts:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 1049
    invoke-virtual {p0}, Lco/vine/android/widget/FeedAdapter;->notifyDataSetChanged()V

    .line 1050
    return-void
.end method

.method public newView()Landroid/view/View;
    .locals 9

    .prologue
    const v8, 0x7f0a0073

    .line 530
    iget-object v5, p0, Lco/vine/android/widget/FeedAdapter;->mContext:Landroid/content/Context;

    invoke-static {v5}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v5

    const v6, 0x7f030070

    const/4 v7, 0x0

    invoke-virtual {v5, v6, v7}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v4

    .line 532
    .local v4, "view":Landroid/view/View;
    invoke-virtual {v4, v8}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    .line 533
    .local v0, "container":Landroid/widget/RelativeLayout;
    invoke-virtual {v0}, Landroid/widget/RelativeLayout;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v2

    .line 534
    .local v2, "params":Landroid/view/ViewGroup$LayoutParams;
    iget v5, p0, Lco/vine/android/widget/FeedAdapter;->mDimen:I

    iput v5, v2, Landroid/view/ViewGroup$LayoutParams;->height:I

    .line 535
    iget v5, p0, Lco/vine/android/widget/FeedAdapter;->mDimen:I

    iput v5, v2, Landroid/view/ViewGroup$LayoutParams;->width:I

    .line 536
    invoke-virtual {v0, v2}, Landroid/widget/RelativeLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 538
    const v5, 0x7f0a012b

    invoke-virtual {v4, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    .line 539
    .local v1, "imageContainer":Landroid/widget/ImageView;
    invoke-virtual {v1}, Landroid/widget/ImageView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v2

    .line 540
    iget v5, p0, Lco/vine/android/widget/FeedAdapter;->mDimen:I

    iput v5, v2, Landroid/view/ViewGroup$LayoutParams;->width:I

    .line 541
    iget v5, p0, Lco/vine/android/widget/FeedAdapter;->mDimen:I

    iput v5, v2, Landroid/view/ViewGroup$LayoutParams;->height:I

    .line 542
    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 544
    new-instance v3, Lco/vine/android/widget/FeedViewHolder;

    invoke-direct {v3, v4}, Lco/vine/android/widget/FeedViewHolder;-><init>(Landroid/view/View;)V

    .line 545
    .local v3, "tag":Lco/vine/android/widget/FeedViewHolder;
    const v5, 0x7f0a0075

    invoke-virtual {v4, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Lco/vine/android/player/SdkVideoView;

    iput-object v5, v3, Lco/vine/android/widget/FeedViewHolder;->videoView:Lco/vine/android/player/SdkVideoView;

    .line 546
    new-instance v5, Lco/vine/android/player/OnListVideoClickListener;

    invoke-direct {v5, p0}, Lco/vine/android/player/OnListVideoClickListener;-><init>(Lco/vine/android/player/HasVideoPlayerAdapter;)V

    iput-object v5, v3, Lco/vine/android/widget/FeedViewHolder;->listener:Lco/vine/android/player/OnListVideoClickListener;

    .line 547
    invoke-virtual {v4, v8}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    iget-object v6, v3, Lco/vine/android/widget/FeedViewHolder;->listener:Lco/vine/android/player/OnListVideoClickListener;

    invoke-virtual {v5, v6}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 549
    invoke-virtual {v4, v3}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 550
    iget-object v5, p0, Lco/vine/android/widget/FeedAdapter;->mViewHolders:Ljava/util/ArrayList;

    new-instance v6, Ljava/lang/ref/WeakReference;

    invoke-direct {v6, v3}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    invoke-virtual {v5, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 551
    const-string v5, "Get view: {}"

    iget-object v6, v3, Lco/vine/android/widget/FeedViewHolder;->videoView:Lco/vine/android/player/SdkVideoView;

    invoke-virtual {v6}, Ljava/lang/Object;->hashCode()I

    move-result v6

    rem-int/lit8 v6, v6, 0x64

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 554
    sget v5, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v6, 0xf

    if-le v5, v6, :cond_0

    .line 555
    iget-object v5, v3, Lco/vine/android/widget/FeedViewHolder;->loopsHintButton:Landroid/widget/Button;

    new-instance v6, Lco/vine/android/widget/FeedAdapter$5;

    invoke-direct {v6, p0}, Lco/vine/android/widget/FeedAdapter$5;-><init>(Lco/vine/android/widget/FeedAdapter;)V

    invoke-virtual {v5, v6}, Landroid/widget/Button;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 573
    :cond_0
    return-object v4
.end method

.method public onDestroy()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 817
    invoke-virtual {p0}, Lco/vine/android/widget/FeedAdapter;->stopCurrentPlayer()V

    .line 818
    invoke-virtual {p0, v1}, Lco/vine/android/widget/FeedAdapter;->releaseOtherPlayers(Lco/vine/android/player/SdkVideoView;)V

    .line 819
    iget-object v0, p0, Lco/vine/android/widget/FeedAdapter;->mLoopCountHandler:Landroid/os/Handler;

    invoke-virtual {v0}, Landroid/os/Handler;->getLooper()Landroid/os/Looper;

    move-result-object v0

    invoke-virtual {v0}, Landroid/os/Looper;->quit()V

    .line 820
    iget-object v0, p0, Lco/vine/android/widget/FeedAdapter;->mLoopCountThread:Landroid/os/HandlerThread;

    invoke-virtual {v0}, Landroid/os/HandlerThread;->interrupt()V

    .line 821
    iput-object v1, p0, Lco/vine/android/widget/FeedAdapter;->mLoopCountThread:Landroid/os/HandlerThread;

    .line 822
    return-void
.end method

.method public onDestroyView()V
    .locals 1

    .prologue
    .line 880
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lco/vine/android/widget/FeedAdapter;->releaseOtherPlayers(Lco/vine/android/player/SdkVideoView;)V

    .line 881
    return-void
.end method

.method public declared-synchronized onPause(Z)V
    .locals 2
    .param p1, "focused"    # Z

    .prologue
    .line 776
    monitor-enter p0

    :try_start_0
    const-string v0, "OnPause {}. {}"

    invoke-static {p1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-static {v0, v1, p0}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 777
    iput-boolean p1, p0, Lco/vine/android/widget/FeedAdapter;->mHasFocus:Z

    .line 778
    const/high16 v0, -0x80000000

    iput v0, p0, Lco/vine/android/widget/FeedAdapter;->mShouldBePlaying:I

    .line 779
    iget-object v0, p0, Lco/vine/android/widget/FeedAdapter;->mHandler:Landroid/os/Handler;

    iget-object v1, p0, Lco/vine/android/widget/FeedAdapter;->mPlayCurrentPositionRunnable:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 780
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lco/vine/android/widget/FeedAdapter;->releaseOtherPlayers(Lco/vine/android/player/SdkVideoView;)V

    .line 781
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lco/vine/android/widget/FeedAdapter;->resetStates(Z)V

    .line 782
    const/4 v0, 0x0

    iput-boolean v0, p0, Lco/vine/android/widget/FeedAdapter;->mWasResumed:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 783
    monitor-exit p0

    return-void

    .line 776
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized onResume(Z)V
    .locals 5
    .param p1, "focused"    # Z

    .prologue
    .line 786
    monitor-enter p0

    :try_start_0
    const-string v3, "OnResume {}. {}"

    invoke-static {p1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    invoke-static {v3, v4, p0}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 787
    iget-boolean v3, p0, Lco/vine/android/widget/FeedAdapter;->mWasResumed:Z

    if-nez v3, :cond_0

    .line 788
    const/4 v3, 0x1

    iput-boolean v3, p0, Lco/vine/android/widget/FeedAdapter;->mWasResumed:Z

    .line 789
    const/high16 v3, -0x80000000

    iput v3, p0, Lco/vine/android/widget/FeedAdapter;->mShouldBePlaying:I

    .line 790
    iget-object v3, p0, Lco/vine/android/widget/FeedAdapter;->mContext:Landroid/content/Context;

    invoke-static {v3}, Lco/vine/android/util/MuteUtil;->isMuted(Landroid/content/Context;)Z

    move-result v3

    iput-boolean v3, p0, Lco/vine/android/widget/FeedAdapter;->mMuted:Z

    .line 792
    :cond_0
    iput-boolean p1, p0, Lco/vine/android/widget/FeedAdapter;->mHasFocus:Z

    .line 793
    iget-boolean v3, p0, Lco/vine/android/widget/FeedAdapter;->mHasFocus:Z

    if-eqz v3, :cond_1

    .line 794
    invoke-direct {p0}, Lco/vine/android/widget/FeedAdapter;->calculateCurrentPosition()I

    move-result v0

    .line 795
    .local v0, "currentPosition":I
    if-lez v0, :cond_1

    iget-object v3, p0, Lco/vine/android/widget/FeedAdapter;->mViewHolders:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v3

    if-le v3, v0, :cond_1

    .line 797
    :try_start_1
    invoke-virtual {p0, v0}, Lco/vine/android/widget/FeedAdapter;->getHolderFromPosition(I)Lco/vine/android/widget/FeedViewHolder;

    move-result-object v2

    .line 798
    .local v2, "h":Lco/vine/android/widget/FeedViewHolder;
    if-eqz v2, :cond_1

    .line 799
    invoke-virtual {p0, v2}, Lco/vine/android/widget/FeedAdapter;->bindVideoImage(Lco/vine/android/widget/GenericFeedViewHolder;)Z
    :try_end_1
    .catch Ljava/lang/IndexOutOfBoundsException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 807
    .end local v0    # "currentPosition":I
    .end local v2    # "h":Lco/vine/android/widget/FeedViewHolder;
    :cond_1
    :goto_0
    :try_start_2
    invoke-virtual {p0}, Lco/vine/android/widget/FeedAdapter;->playCurrentPosition()V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 808
    monitor-exit p0

    return-void

    .line 801
    .restart local v0    # "currentPosition":I
    :catch_0
    move-exception v1

    .line 803
    .local v1, "e":Ljava/lang/IndexOutOfBoundsException;
    :try_start_3
    const-string v3, "Race condition."

    invoke-static {v3, v1}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_0

    .line 786
    .end local v0    # "currentPosition":I
    .end local v1    # "e":Ljava/lang/IndexOutOfBoundsException;
    :catchall_0
    move-exception v3

    monitor-exit p0

    throw v3
.end method

.method public onScrollStateChanged(Landroid/widget/AbsListView;I)V
    .locals 0
    .param p1, "view"    # Landroid/widget/AbsListView;
    .param p2, "scrollState"    # I

    .prologue
    .line 826
    if-nez p2, :cond_0

    .line 827
    invoke-virtual {p0}, Lco/vine/android/widget/FeedAdapter;->playCurrentPosition()V

    .line 829
    :cond_0
    return-void
.end method

.method protected onVideoImageObtained(Lco/vine/android/widget/FeedViewHolder;Z)V
    .locals 0
    .param p1, "holder"    # Lco/vine/android/widget/FeedViewHolder;
    .param p2, "b"    # Z

    .prologue
    .line 854
    iput-boolean p2, p1, Lco/vine/android/widget/FeedViewHolder;->isVideoImageLoaded:Z

    .line 855
    invoke-virtual {p0}, Lco/vine/android/widget/FeedAdapter;->playCurrentPosition()V

    .line 856
    return-void
.end method

.method protected bridge synthetic onVideoImageObtained(Lco/vine/android/widget/GenericFeedViewHolder;Z)V
    .locals 0
    .param p1, "x0"    # Lco/vine/android/widget/GenericFeedViewHolder;
    .param p2, "x1"    # Z

    .prologue
    .line 63
    check-cast p1, Lco/vine/android/widget/FeedViewHolder;

    .end local p1    # "x0":Lco/vine/android/widget/GenericFeedViewHolder;
    invoke-virtual {p0, p1, p2}, Lco/vine/android/widget/FeedAdapter;->onVideoImageObtained(Lco/vine/android/widget/FeedViewHolder;Z)V

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
    .line 841
    .local p1, "videos":Ljava/util/HashMap;, "Ljava/util/HashMap<Lco/vine/android/util/video/VideoKey;Lco/vine/android/util/video/UrlVideo;>;"
    const-string v3, "CALLBACK onVideoPathObtained"

    invoke-static {v3}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 842
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

    .line 843
    .local v1, "key":Lco/vine/android/util/video/VideoKey;
    invoke-virtual {p1, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lco/vine/android/util/video/UrlVideo;

    .line 844
    .local v2, "video":Lco/vine/android/util/video/UrlVideo;
    invoke-virtual {v2}, Lco/vine/android/util/video/UrlVideo;->isValid()Z

    move-result v3

    if-eqz v3, :cond_0

    iget-object v3, p0, Lco/vine/android/widget/FeedAdapter;->mUrlReverse:Ljava/util/HashMap;

    invoke-virtual {v3, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    if-eqz v3, :cond_0

    .line 845
    iget-object v4, p0, Lco/vine/android/widget/FeedAdapter;->mPaths:Landroid/util/SparseArray;

    iget-object v3, p0, Lco/vine/android/widget/FeedAdapter;->mUrlReverse:Ljava/util/HashMap;

    invoke-virtual {v3, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Integer;

    invoke-virtual {v3}, Ljava/lang/Integer;->intValue()I

    move-result v3

    invoke-virtual {v2}, Lco/vine/android/util/video/UrlVideo;->getAbsolutePath()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v3, v5}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    .line 846
    iget-object v3, p0, Lco/vine/android/widget/FeedAdapter;->mUrlReverse:Ljava/util/HashMap;

    invoke-virtual {v3, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Integer;

    invoke-virtual {v3}, Ljava/lang/Integer;->intValue()I

    move-result v3

    iget v4, p0, Lco/vine/android/widget/FeedAdapter;->mShouldBePlaying:I

    if-ne v3, v4, :cond_0

    .line 847
    invoke-virtual {p0}, Lco/vine/android/widget/FeedAdapter;->playCurrentPosition()V

    goto :goto_0

    .line 851
    .end local v1    # "key":Lco/vine/android/util/video/VideoKey;
    .end local v2    # "video":Lco/vine/android/util/video/UrlVideo;
    :cond_1
    return-void
.end method

.method public pauseCurrentPlayer()V
    .locals 2

    .prologue
    .line 375
    invoke-direct {p0}, Lco/vine/android/widget/FeedAdapter;->hasPlayerPlaying()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 376
    const-string v0, "Pause player {}."

    iget-object v1, p0, Lco/vine/android/widget/FeedAdapter;->mLastPlayer:Lco/vine/android/player/SdkVideoView;

    invoke-virtual {v1}, Lco/vine/android/player/SdkVideoView;->getPlayingPosition()I

    move-result v1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 377
    iget-object v0, p0, Lco/vine/android/widget/FeedAdapter;->mLastPlayer:Lco/vine/android/player/SdkVideoView;

    invoke-virtual {v0}, Lco/vine/android/player/SdkVideoView;->pause()V

    .line 379
    :cond_0
    return-void
.end method

.method public declared-synchronized play(I)V
    .locals 8
    .param p1, "requestedPosition"    # I

    .prologue
    .line 259
    monitor-enter p0

    :try_start_0
    const-string v5, "play task executing with position {} "

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 260
    iget-boolean v5, p0, Lco/vine/android/widget/FeedAdapter;->mHasFocus:Z

    if-eqz v5, :cond_8

    .line 261
    iget-object v5, p0, Lco/vine/android/widget/FeedAdapter;->mPaths:Landroid/util/SparseArray;

    invoke-virtual {v5, p1}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v5

    if-eqz v5, :cond_2

    .line 262
    add-int/lit8 v5, p1, 0x1

    invoke-direct {p0, v5}, Lco/vine/android/widget/FeedAdapter;->preFetch(I)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 263
    add-int/lit8 v5, p1, 0x2

    invoke-direct {p0, v5}, Lco/vine/android/widget/FeedAdapter;->preFetch(I)Z

    .line 265
    :cond_0
    const-string v5, "{} is in cache or it is already pre-fetched."

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 266
    const-string v5, "playing file at position {}"

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 267
    const/4 v5, 0x1

    invoke-virtual {p0, p1, v5}, Lco/vine/android/widget/FeedAdapter;->playFile(IZ)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 307
    :cond_1
    :goto_0
    monitor-exit p0

    return-void

    .line 269
    :cond_2
    :try_start_1
    const-string v5, "Real fetch for {}."

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 270
    invoke-direct {p0, p1}, Lco/vine/android/widget/FeedAdapter;->getPost(I)Lco/vine/android/api/VinePost;

    move-result-object v1

    .line 271
    .local v1, "post":Lco/vine/android/api/VinePost;
    if-eqz v1, :cond_7

    .line 272
    const/4 v5, 0x0

    invoke-virtual {p0, v1, v5}, Lco/vine/android/widget/FeedAdapter;->getRequestKey(Lco/vine/android/api/VinePost;Z)Lco/vine/android/util/video/VideoKey;

    move-result-object v3

    .line 273
    .local v3, "url":Lco/vine/android/util/video/VideoKey;
    if-nez v3, :cond_3

    .line 274
    invoke-virtual {p0}, Lco/vine/android/widget/FeedAdapter;->onInvalidRequestKey()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 259
    .end local v1    # "post":Lco/vine/android/api/VinePost;
    .end local v3    # "url":Lco/vine/android/util/video/VideoKey;
    :catchall_0
    move-exception v5

    monitor-exit p0

    throw v5

    .line 277
    .restart local v1    # "post":Lco/vine/android/api/VinePost;
    .restart local v3    # "url":Lco/vine/android/util/video/VideoKey;
    :cond_3
    :try_start_2
    iget-object v5, p0, Lco/vine/android/widget/FeedAdapter;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v5, v3}, Lco/vine/android/client/AppController;->getVideoFilePath(Lco/vine/android/util/video/VideoKey;)Ljava/lang/String;

    move-result-object v0

    .line 278
    .local v0, "path":Ljava/lang/String;
    add-int/lit8 v5, p1, 0x1

    invoke-direct {p0, v5}, Lco/vine/android/widget/FeedAdapter;->preFetch(I)Z

    move-result v5

    if-eqz v5, :cond_4

    .line 279
    add-int/lit8 v5, p1, 0x2

    invoke-direct {p0, v5}, Lco/vine/android/widget/FeedAdapter;->preFetch(I)Z

    .line 281
    :cond_4
    if-eqz v0, :cond_5

    .line 282
    iget-object v5, p0, Lco/vine/android/widget/FeedAdapter;->mPaths:Landroid/util/SparseArray;

    invoke-virtual {v5, p1, v0}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    .line 283
    const-string v5, "playing file at position {}"

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 284
    const/4 v5, 0x1

    invoke-virtual {p0, p1, v5}, Lco/vine/android/widget/FeedAdapter;->playFile(IZ)V

    goto :goto_0

    .line 286
    :cond_5
    iput p1, p0, Lco/vine/android/widget/FeedAdapter;->mShouldBePlaying:I

    .line 287
    iget-object v5, p0, Lco/vine/android/widget/FeedAdapter;->mUrlReverse:Ljava/util/HashMap;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-virtual {v5, v3, v6}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 288
    const-string v5, "{} is not in app cache yet."

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 289
    invoke-virtual {p0}, Lco/vine/android/widget/FeedAdapter;->pauseCurrentPlayer()V

    .line 290
    invoke-virtual {p0, p1}, Lco/vine/android/widget/FeedAdapter;->getViewAtPosition(I)Landroid/view/View;

    move-result-object v4

    .line 291
    .local v4, "view":Landroid/view/View;
    if-eqz v4, :cond_1

    .line 292
    invoke-virtual {v4}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v2

    .line 293
    .local v2, "tag":Ljava/lang/Object;
    instance-of v5, v2, Lco/vine/android/widget/FeedViewHolder;

    if-eqz v5, :cond_6

    .line 294
    check-cast v2, Lco/vine/android/widget/FeedViewHolder;

    .end local v2    # "tag":Ljava/lang/Object;
    iget-object v5, v2, Lco/vine/android/widget/FeedViewHolder;->videoLoadImage:Landroid/widget/ProgressBar;

    const/4 v6, 0x0

    invoke-virtual {v5, v6}, Landroid/widget/ProgressBar;->setVisibility(I)V

    goto :goto_0

    .line 296
    .restart local v2    # "tag":Ljava/lang/Object;
    :cond_6
    new-instance v5, Ljava/lang/IllegalStateException;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "Somehow tag was "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, ", view class is \'"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v4}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "\'."

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v6}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    invoke-static {v5}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;)V

    goto/16 :goto_0

    .line 301
    .end local v0    # "path":Ljava/lang/String;
    .end local v2    # "tag":Ljava/lang/Object;
    .end local v3    # "url":Lco/vine/android/util/video/VideoKey;
    .end local v4    # "view":Landroid/view/View;
    :cond_7
    const-string v5, "mPosts is {} or the requested position has no post object in it yet, return -1."

    iget-object v6, p0, Lco/vine/android/widget/FeedAdapter;->mPosts:Ljava/util/ArrayList;

    invoke-static {v5, v6}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    goto/16 :goto_0

    .line 305
    .end local v1    # "post":Lco/vine/android/api/VinePost;
    :cond_8
    const-string v5, "not playing because not focused."

    invoke-static {v5}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto/16 :goto_0
.end method

.method public declared-synchronized playCurrentPosition()V
    .locals 4

    .prologue
    .line 386
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lco/vine/android/widget/FeedAdapter;->mHandler:Landroid/os/Handler;

    iget-object v1, p0, Lco/vine/android/widget/FeedAdapter;->mPlayCurrentPositionRunnable:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 387
    iget-object v0, p0, Lco/vine/android/widget/FeedAdapter;->mHandler:Landroid/os/Handler;

    iget-object v1, p0, Lco/vine/android/widget/FeedAdapter;->mPlayCurrentPositionRunnable:Ljava/lang/Runnable;

    const-wide/16 v2, 0x32

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 388
    monitor-exit p0

    return-void

    .line 386
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized playFile(IZ)V
    .locals 10
    .param p1, "position"    # I
    .param p2, "isVideoLoaded"    # Z

    .prologue
    const/4 v3, 0x1

    const/4 v5, 0x0

    .line 181
    monitor-enter p0

    if-gez p1, :cond_1

    .line 256
    :cond_0
    :goto_0
    monitor-exit p0

    return-void

    .line 184
    :cond_1
    :try_start_0
    const-string v6, "Playing item: {}"

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    invoke-static {v6, v7}, Lcom/edisonwang/android/slog/SLog;->i(Ljava/lang/String;Ljava/lang/Object;)V

    .line 186
    invoke-virtual {p0, p1}, Lco/vine/android/widget/FeedAdapter;->getViewAtPosition(I)Landroid/view/View;

    move-result-object v1

    .line 187
    .local v1, "currentView":Landroid/view/View;
    if-nez v1, :cond_2

    .line 188
    const-string v5, "Item is not visible: {}"

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/edisonwang/android/slog/SLog;->i(Ljava/lang/String;Ljava/lang/Object;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 181
    .end local v1    # "currentView":Landroid/view/View;
    :catchall_0
    move-exception v5

    monitor-exit p0

    throw v5

    .line 191
    .restart local v1    # "currentView":Landroid/view/View;
    :cond_2
    :try_start_1
    invoke-virtual {v1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/widget/FeedViewHolder;

    .line 192
    .local v4, "tag":Lco/vine/android/widget/FeedViewHolder;
    if-eqz v4, :cond_0

    .line 196
    iget-object v0, v4, Lco/vine/android/widget/FeedViewHolder;->videoView:Lco/vine/android/player/SdkVideoView;

    .line 198
    .local v0, "currentVideoView":Lco/vine/android/player/SdkVideoView;
    iget-object v6, p0, Lco/vine/android/widget/FeedAdapter;->mLastPlayer:Lco/vine/android/player/SdkVideoView;

    if-eq v0, v6, :cond_3

    .line 199
    const-string v6, "Pause previous player."

    invoke-static {v6}, Lcom/edisonwang/android/slog/SLog;->i(Ljava/lang/String;)V

    .line 200
    invoke-virtual {p0}, Lco/vine/android/widget/FeedAdapter;->pauseCurrentPlayer()V

    .line 203
    :cond_3
    iget-object v6, p0, Lco/vine/android/widget/FeedAdapter;->mPaths:Landroid/util/SparseArray;

    invoke-virtual {v6, p1}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 205
    .local v2, "newPath":Ljava/lang/String;
    if-nez v2, :cond_4

    .line 206
    const-string v5, "Path was cleared."

    invoke-static {v5}, Lcom/edisonwang/android/slog/SLog;->i(Ljava/lang/String;)V

    goto :goto_0

    .line 210
    :cond_4
    iget-object v6, v4, Lco/vine/android/widget/FeedViewHolder;->post:Lco/vine/android/api/VinePost;

    if-nez v6, :cond_5

    .line 211
    const-string v5, "Post was cleared."

    invoke-static {v5}, Lcom/edisonwang/android/slog/SLog;->i(Ljava/lang/String;)V

    goto :goto_0

    .line 215
    :cond_5
    invoke-virtual {v0, v2}, Lco/vine/android/player/SdkVideoView;->isPathPlaying(Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_d

    .line 216
    iget-object v6, p0, Lco/vine/android/widget/FeedAdapter;->mContext:Landroid/content/Context;

    invoke-static {v6}, Lco/vine/android/util/SystemUtil;->isSinglePlayerEnabled(Landroid/content/Context;)Z

    move-result v6

    if-eqz v6, :cond_c

    invoke-static {}, Lco/vine/android/player/SdkVideoView;->getCurrentUri()Landroid/net/Uri;

    move-result-object v6

    if-nez v6, :cond_b

    .line 218
    .local v3, "newView":Z
    :cond_6
    :goto_1
    if-nez v3, :cond_7

    .line 219
    invoke-direct {p0, p1, v4}, Lco/vine/android/widget/FeedAdapter;->refreshVideoView(ILco/vine/android/widget/FeedViewHolder;)V

    .line 221
    :cond_7
    iget-object v0, v4, Lco/vine/android/widget/FeedViewHolder;->videoView:Lco/vine/android/player/SdkVideoView;

    .line 222
    iget-boolean v5, p0, Lco/vine/android/widget/FeedAdapter;->mMuted:Z

    invoke-virtual {v0, v5}, Lco/vine/android/player/SdkVideoView;->setMute(Z)V

    .line 223
    iget-boolean v5, p0, Lco/vine/android/widget/FeedAdapter;->mNeedReleaseOtherPlayers:Z

    if-eqz v5, :cond_8

    iget v5, p0, Lco/vine/android/widget/FeedAdapter;->currentPlayerCount:I

    iget v6, p0, Lco/vine/android/widget/FeedAdapter;->maxPlayer:I

    if-lt v5, v6, :cond_8

    .line 224
    iget-object v5, v4, Lco/vine/android/widget/FeedViewHolder;->videoView:Lco/vine/android/player/SdkVideoView;

    invoke-virtual {p0, v5}, Lco/vine/android/widget/FeedAdapter;->releaseOtherPlayers(Lco/vine/android/player/SdkVideoView;)V

    .line 226
    :cond_8
    const-string v5, "Start playing by set path."

    invoke-static {v5}, Lcom/edisonwang/android/slog/SLog;->i(Ljava/lang/String;)V

    .line 227
    iget-object v5, v4, Lco/vine/android/widget/FeedViewHolder;->post:Lco/vine/android/api/VinePost;

    iget-wide v5, v5, Lco/vine/android/api/VinePost;->postId:J

    invoke-static {v5, v6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    invoke-virtual {v0, v5}, Lco/vine/android/player/SdkVideoView;->setTag(Ljava/lang/Object;)V

    .line 228
    const-string v5, "Setting video path in feed for post {}"

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    iget-object v8, v4, Lco/vine/android/widget/FeedViewHolder;->post:Lco/vine/android/api/VinePost;

    iget-wide v8, v8, Lco/vine/android/api/VinePost;->postId:J

    invoke-static {v8, v9}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v8

    aput-object v8, v6, v7

    invoke-static {v5, v6}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 229
    invoke-virtual {v0, v2}, Lco/vine/android/player/SdkVideoView;->setVideoPath(Ljava/lang/String;)V

    .line 230
    invoke-virtual {v0}, Lco/vine/android/player/SdkVideoView;->isSurfaceReady()Z

    move-result v5

    if-nez v5, :cond_9

    invoke-virtual {v0}, Lco/vine/android/player/SdkVideoView;->getVisibility()I

    move-result v5

    if-eqz v5, :cond_9

    .line 231
    const/4 v5, 0x0

    invoke-virtual {v0, v5}, Lco/vine/android/player/SdkVideoView;->setVisibility(I)V

    .line 233
    :cond_9
    iget v5, p0, Lco/vine/android/widget/FeedAdapter;->currentPlayerCount:I

    add-int/lit8 v5, v5, 0x1

    iput v5, p0, Lco/vine/android/widget/FeedAdapter;->currentPlayerCount:I

    .line 249
    .end local v3    # "newView":Z
    :goto_2
    invoke-virtual {v0, p1}, Lco/vine/android/player/SdkVideoView;->setPlayingPosition(I)V

    .line 250
    iget-object v5, v4, Lco/vine/android/widget/FeedViewHolder;->listener:Lco/vine/android/player/OnListVideoClickListener;

    invoke-virtual {v5, p1}, Lco/vine/android/player/OnListVideoClickListener;->setPosition(I)V

    .line 251
    iget-object v5, v4, Lco/vine/android/widget/FeedViewHolder;->imageListener:Lco/vine/android/player/SensitiveImageClickListener;

    if-eqz v5, :cond_a

    .line 252
    iget-object v5, v4, Lco/vine/android/widget/FeedViewHolder;->imageListener:Lco/vine/android/player/SensitiveImageClickListener;

    invoke-virtual {v5, p1}, Lco/vine/android/player/SensitiveImageClickListener;->setPosition(I)V

    .line 254
    :cond_a
    iput p1, p0, Lco/vine/android/widget/FeedAdapter;->mCurrentPlaying:I

    .line 255
    iput-object v0, p0, Lco/vine/android/widget/FeedAdapter;->mLastPlayer:Lco/vine/android/player/SdkVideoView;

    goto/16 :goto_0

    :cond_b
    move v3, v5

    .line 216
    goto :goto_1

    :cond_c
    invoke-virtual {v0}, Lco/vine/android/player/SdkVideoView;->getPath()Ljava/lang/String;

    move-result-object v6

    if-eqz v6, :cond_6

    move v3, v5

    goto :goto_1

    .line 235
    :cond_d
    iget-object v5, v4, Lco/vine/android/widget/FeedViewHolder;->videoView:Lco/vine/android/player/SdkVideoView;

    invoke-virtual {v5}, Lco/vine/android/player/SdkVideoView;->getVisibility()I

    move-result v5

    if-eqz v5, :cond_e

    .line 236
    iget-object v5, v4, Lco/vine/android/widget/FeedViewHolder;->videoView:Lco/vine/android/player/SdkVideoView;

    const/4 v6, 0x0

    invoke-virtual {v5, v6}, Lco/vine/android/player/SdkVideoView;->setVisibility(I)V

    .line 238
    :cond_e
    iget-boolean v5, p0, Lco/vine/android/widget/FeedAdapter;->mMuted:Z

    invoke-virtual {v0, v5}, Lco/vine/android/player/SdkVideoView;->setMute(Z)V

    .line 239
    invoke-virtual {v0}, Lco/vine/android/player/SdkVideoView;->isInPlaybackState()Z

    move-result v5

    if-eqz v5, :cond_f

    .line 240
    const-string v5, "Start playing by calling start."

    invoke-static {v5}, Lcom/edisonwang/android/slog/SLog;->i(Ljava/lang/String;)V

    .line 241
    invoke-virtual {v0}, Lco/vine/android/player/SdkVideoView;->start()V

    goto :goto_2

    .line 243
    :cond_f
    const-string v5, "Start playing by set path."

    invoke-static {v5}, Lcom/edisonwang/android/slog/SLog;->i(Ljava/lang/String;)V

    .line 244
    iget-object v5, v4, Lco/vine/android/widget/FeedViewHolder;->post:Lco/vine/android/api/VinePost;

    iget-wide v5, v5, Lco/vine/android/api/VinePost;->postId:J

    invoke-static {v5, v6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    invoke-virtual {v0, v5}, Lco/vine/android/player/SdkVideoView;->setTag(Ljava/lang/Object;)V

    .line 245
    const-string v5, "Setting video path in feed for post {}"

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    iget-object v8, v4, Lco/vine/android/widget/FeedViewHolder;->post:Lco/vine/android/api/VinePost;

    iget-wide v8, v8, Lco/vine/android/api/VinePost;->postId:J

    invoke-static {v8, v9}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v8

    aput-object v8, v6, v7

    invoke-static {v5, v6}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 246
    invoke-virtual {v0, v2}, Lco/vine/android/player/SdkVideoView;->setVideoPath(Ljava/lang/String;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_2
.end method

.method public declared-synchronized releaseOtherPlayers(Lco/vine/android/player/SdkVideoView;)V
    .locals 5
    .param p1, "view"    # Lco/vine/android/player/SdkVideoView;

    .prologue
    .line 519
    monitor-enter p0

    :try_start_0
    iget-object v3, p0, Lco/vine/android/widget/FeedAdapter;->mViewHolders:Ljava/util/ArrayList;

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

    check-cast v2, Ljava/lang/ref/WeakReference;

    .line 520
    .local v2, "key":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/widget/FeedViewHolder;>;"
    invoke-virtual {v2}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/widget/FeedViewHolder;

    .line 521
    .local v0, "holder":Lco/vine/android/widget/FeedViewHolder;
    if-eqz v0, :cond_0

    iget-object v3, v0, Lco/vine/android/widget/FeedViewHolder;->videoView:Lco/vine/android/player/SdkVideoView;

    if-eq p1, v3, :cond_0

    .line 522
    const-string v3, "Releasing player: {}"

    iget v4, v0, Lco/vine/android/widget/FeedViewHolder;->position:I

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 523
    iget-object v3, v0, Lco/vine/android/widget/FeedViewHolder;->videoView:Lco/vine/android/player/SdkVideoView;

    invoke-virtual {v3}, Lco/vine/android/player/SdkVideoView;->suspend()V

    .line 524
    iget v3, p0, Lco/vine/android/widget/FeedAdapter;->currentPlayerCount:I

    add-int/lit8 v3, v3, -0x1

    iput v3, p0, Lco/vine/android/widget/FeedAdapter;->currentPlayerCount:I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 519
    .end local v0    # "holder":Lco/vine/android/widget/FeedViewHolder;
    .end local v1    # "i$":Ljava/util/Iterator;
    .end local v2    # "key":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/widget/FeedViewHolder;>;"
    :catchall_0
    move-exception v3

    monitor-exit p0

    throw v3

    .line 527
    .restart local v1    # "i$":Ljava/util/Iterator;
    :cond_1
    monitor-exit p0

    return-void
.end method

.method public removePost(J)V
    .locals 4
    .param p1, "postId"    # J

    .prologue
    .line 484
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    iget-object v2, p0, Lco/vine/android/widget/FeedAdapter;->mPosts:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v2

    if-ge v0, v2, :cond_0

    .line 485
    invoke-direct {p0, v0}, Lco/vine/android/widget/FeedAdapter;->getPost(I)Lco/vine/android/api/VinePost;

    move-result-object v1

    .line 486
    .local v1, "post":Lco/vine/android/api/VinePost;
    if-eqz v1, :cond_1

    .line 487
    iget-wide v2, v1, Lco/vine/android/api/VinePost;->postId:J

    cmp-long v2, v2, p1

    if-nez v2, :cond_1

    .line 488
    iget-object v2, p0, Lco/vine/android/widget/FeedAdapter;->mPosts:Ljava/util/ArrayList;

    invoke-virtual {v2, v0}, Ljava/util/ArrayList;->remove(I)Ljava/lang/Object;

    .line 493
    .end local v1    # "post":Lco/vine/android/api/VinePost;
    :cond_0
    iget-object v2, p0, Lco/vine/android/widget/FeedAdapter;->mPaths:Landroid/util/SparseArray;

    invoke-virtual {v2}, Landroid/util/SparseArray;->clear()V

    .line 494
    iget-object v2, p0, Lco/vine/android/widget/FeedAdapter;->mUrlReverse:Ljava/util/HashMap;

    invoke-virtual {v2}, Ljava/util/HashMap;->clear()V

    .line 495
    iget-object v2, p0, Lco/vine/android/widget/FeedAdapter;->mPlayers:Landroid/util/SparseArray;

    invoke-virtual {v2}, Landroid/util/SparseArray;->clear()V

    .line 496
    invoke-virtual {p0}, Lco/vine/android/widget/FeedAdapter;->notifyDataSetChanged()V

    .line 497
    invoke-virtual {p0}, Lco/vine/android/widget/FeedAdapter;->playCurrentPosition()V

    .line 498
    return-void

    .line 484
    .restart local v1    # "post":Lco/vine/android/api/VinePost;
    :cond_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_0
.end method

.method protected resetStates(Z)V
    .locals 2
    .param p1, "hasDataSetChanged"    # Z

    .prologue
    const/4 v1, 0x0

    .line 171
    invoke-super {p0, p1}, Lco/vine/android/widget/GenericTimelineAdapter;->resetStates(Z)V

    .line 172
    invoke-virtual {p0}, Lco/vine/android/widget/FeedAdapter;->stopCurrentPlayer()V

    .line 173
    iget-object v0, p0, Lco/vine/android/widget/FeedAdapter;->mLikeCache:Lco/vine/android/LikeCache;

    invoke-virtual {v0}, Lco/vine/android/LikeCache;->clear()V

    .line 174
    iget-object v0, p0, Lco/vine/android/widget/FeedAdapter;->mRevineCache:Lco/vine/android/RevineCache;

    invoke-virtual {v0}, Lco/vine/android/RevineCache;->clear()V

    .line 175
    const/4 v0, -0x1

    iput v0, p0, Lco/vine/android/widget/FeedAdapter;->mShouldBePlaying:I

    .line 176
    iput v1, p0, Lco/vine/android/widget/FeedAdapter;->currentPlayerCount:I

    .line 177
    iput-boolean v1, p0, Lco/vine/android/widget/FeedAdapter;->mFirstPlayed:Z

    .line 178
    return-void
.end method

.method public stopCurrentPlayer()V
    .locals 1

    .prologue
    .line 367
    iget-object v0, p0, Lco/vine/android/widget/FeedAdapter;->mLastPlayer:Lco/vine/android/player/SdkVideoView;

    if-eqz v0, :cond_0

    .line 368
    iget-object v0, p0, Lco/vine/android/widget/FeedAdapter;->mLastPlayer:Lco/vine/android/player/SdkVideoView;

    invoke-virtual {v0}, Lco/vine/android/player/SdkVideoView;->suspend()V

    .line 369
    const/4 v0, 0x0

    iput-object v0, p0, Lco/vine/android/widget/FeedAdapter;->mLastPlayer:Lco/vine/android/player/SdkVideoView;

    .line 370
    const/4 v0, -0x1

    iput v0, p0, Lco/vine/android/widget/FeedAdapter;->mCurrentPlaying:I

    .line 372
    :cond_0
    return-void
.end method

.method public toggleMute(Z)V
    .locals 3
    .param p1, "mute"    # Z

    .prologue
    .line 832
    iput-boolean p1, p0, Lco/vine/android/widget/FeedAdapter;->mMuted:Z

    .line 833
    const-string v1, "Mute state changed to muted? {}."

    invoke-static {p1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 834
    invoke-virtual {p0}, Lco/vine/android/widget/FeedAdapter;->getLastPlayer()Lco/vine/android/player/SdkVideoView;

    move-result-object v0

    .line 835
    .local v0, "lastPlayer":Lco/vine/android/player/SdkVideoView;
    if-eqz v0, :cond_0

    .line 836
    iget-boolean v1, p0, Lco/vine/android/widget/FeedAdapter;->mMuted:Z

    invoke-virtual {v0, v1}, Lco/vine/android/player/SdkVideoView;->setMute(Z)V

    .line 838
    :cond_0
    return-void
.end method
