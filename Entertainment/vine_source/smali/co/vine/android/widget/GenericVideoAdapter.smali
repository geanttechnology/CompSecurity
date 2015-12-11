.class public abstract Lco/vine/android/widget/GenericVideoAdapter;
.super Landroid/widget/BaseAdapter;
.source "GenericVideoAdapter.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/widget/GenericVideoAdapter$SpanCommentObjectTag;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Lco/vine/android/widget/GenericFeedViewHolder;",
        ">",
        "Landroid/widget/BaseAdapter;"
    }
.end annotation


# static fields
.field protected static final COMMENT_TYPE_FEW:I = 0x1

.field protected static final COMMENT_TYPE_MANY:I = 0x2

.field private static final HQ_THRESHOLD:I = 0xc8

.field protected static final INTERPUNCT:C = '\u00b7'

.field protected static final MAX_COMMENT_ITEMS:I = 0x3

.field protected static final SPACE:C = ' '

.field protected static final SPAN_FLAGS:I = 0x21


# instance fields
.field protected final mAppController:Lco/vine/android/client/AppController;

.field protected final mAvatars:Landroid/util/SparseArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/util/SparseArray",
            "<",
            "Landroid/graphics/Bitmap;",
            ">;"
        }
    .end annotation
.end field

.field protected final mBoldSpan:Lco/vine/android/widget/TypefacesSpan;

.field protected final mContext:Landroid/content/Context;

.field protected final mDimen:I

.field protected final mDismissedWarnings:Ljava/util/HashSet;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashSet",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field protected final mFollowEventSource:Ljava/lang/String;

.field protected mIconsSwitched:Z

.field protected mLikeCache:Lco/vine/android/LikeCache;

.field protected mLoadingTimeTag:Ljava/lang/String;

.field private mNormalVideoPlayable:Ljava/lang/Boolean;

.field protected mProfileColor:I

.field private mProfileImageSize:I

.field protected mRevineCache:Lco/vine/android/RevineCache;

.field protected final mSpanClickListener:Lco/vine/android/widget/SpanClickListener;

.field protected mStartLoadingTime:J

.field protected final mThumbnails:Landroid/util/SparseArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/util/SparseArray",
            "<",
            "Landroid/graphics/Bitmap;",
            ">;"
        }
    .end annotation
.end field

.field protected final mViewClickListener:Landroid/view/View$OnClickListener;

.field protected final mViewHolders:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/ref/WeakReference",
            "<TT;>;>;"
        }
    .end annotation
.end field

.field protected mViewOffsetResolver:Lco/vine/android/ViewOffsetResolver;

.field private final mVineGray:I

.field private final mVineGreen:I


# direct methods
.method public constructor <init>(Landroid/app/Activity;Lco/vine/android/LikeCache;Lco/vine/android/RevineCache;Landroid/view/View$OnClickListener;Lco/vine/android/widget/SpanClickListener;Ljava/lang/String;)V
    .locals 7
    .param p1, "context"    # Landroid/app/Activity;
    .param p2, "likeCache"    # Lco/vine/android/LikeCache;
    .param p3, "revineCache"    # Lco/vine/android/RevineCache;
    .param p4, "viewClickListener"    # Landroid/view/View$OnClickListener;
    .param p5, "spanClickListener"    # Lco/vine/android/widget/SpanClickListener;
    .param p6, "followEventSource"    # Ljava/lang/String;

    .prologue
    .line 98
    .local p0, "this":Lco/vine/android/widget/GenericVideoAdapter;, "Lco/vine/android/widget/GenericVideoAdapter<TT;>;"
    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    .line 99
    invoke-virtual {p1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    .line 101
    .local v0, "res":Landroid/content/res/Resources;
    iput-object p1, p0, Lco/vine/android/widget/GenericVideoAdapter;->mContext:Landroid/content/Context;

    .line 102
    invoke-static {p1}, Lco/vine/android/client/AppController;->getInstance(Landroid/content/Context;)Lco/vine/android/client/AppController;

    move-result-object v2

    iput-object v2, p0, Lco/vine/android/widget/GenericVideoAdapter;->mAppController:Lco/vine/android/client/AppController;

    .line 103
    iput-object p4, p0, Lco/vine/android/widget/GenericVideoAdapter;->mViewClickListener:Landroid/view/View$OnClickListener;

    .line 104
    iput-object p5, p0, Lco/vine/android/widget/GenericVideoAdapter;->mSpanClickListener:Lco/vine/android/widget/SpanClickListener;

    .line 105
    new-instance v2, Landroid/util/SparseArray;

    invoke-direct {v2}, Landroid/util/SparseArray;-><init>()V

    iput-object v2, p0, Lco/vine/android/widget/GenericVideoAdapter;->mThumbnails:Landroid/util/SparseArray;

    .line 106
    new-instance v2, Landroid/util/SparseArray;

    invoke-direct {v2}, Landroid/util/SparseArray;-><init>()V

    iput-object v2, p0, Lco/vine/android/widget/GenericVideoAdapter;->mAvatars:Landroid/util/SparseArray;

    .line 107
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    iput-object v2, p0, Lco/vine/android/widget/GenericVideoAdapter;->mViewHolders:Ljava/util/ArrayList;

    .line 108
    new-instance v2, Lco/vine/android/widget/TypefacesSpan;

    const/4 v3, 0x0

    iget-object v4, p0, Lco/vine/android/widget/GenericVideoAdapter;->mContext:Landroid/content/Context;

    invoke-static {v4}, Lco/vine/android/widget/Typefaces;->get(Landroid/content/Context;)Lco/vine/android/widget/Typefaces;

    move-result-object v4

    const/4 v5, 0x1

    const/4 v6, 0x3

    invoke-virtual {v4, v5, v6}, Lco/vine/android/widget/Typefaces;->getContentTypeface(II)Landroid/graphics/Typeface;

    move-result-object v4

    invoke-direct {v2, v3, v4}, Lco/vine/android/widget/TypefacesSpan;-><init>(Ljava/lang/String;Landroid/graphics/Typeface;)V

    iput-object v2, p0, Lco/vine/android/widget/GenericVideoAdapter;->mBoldSpan:Lco/vine/android/widget/TypefacesSpan;

    .line 112
    new-instance v2, Ljava/util/HashSet;

    invoke-direct {v2}, Ljava/util/HashSet;-><init>()V

    iput-object v2, p0, Lco/vine/android/widget/GenericVideoAdapter;->mDismissedWarnings:Ljava/util/HashSet;

    .line 114
    invoke-static {p1}, Lco/vine/android/util/SystemUtil;->getDisplaySize(Landroid/app/Activity;)Landroid/graphics/Point;

    move-result-object v1

    .line 116
    .local v1, "size":Landroid/graphics/Point;
    iget v2, v1, Landroid/graphics/Point;->x:I

    iput v2, p0, Lco/vine/android/widget/GenericVideoAdapter;->mDimen:I

    .line 117
    iput-object p2, p0, Lco/vine/android/widget/GenericVideoAdapter;->mLikeCache:Lco/vine/android/LikeCache;

    .line 118
    iput-object p3, p0, Lco/vine/android/widget/GenericVideoAdapter;->mRevineCache:Lco/vine/android/RevineCache;

    .line 119
    iput-object p6, p0, Lco/vine/android/widget/GenericVideoAdapter;->mFollowEventSource:Ljava/lang/String;

    .line 121
    const v2, 0x7f0b0087

    invoke-virtual {v0, v2}, Landroid/content/res/Resources;->getDimensionPixelOffset(I)I

    move-result v2

    iput v2, p0, Lco/vine/android/widget/GenericVideoAdapter;->mProfileImageSize:I

    .line 123
    const v2, 0x7f090096

    invoke-virtual {v0, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v2

    iput v2, p0, Lco/vine/android/widget/GenericVideoAdapter;->mVineGreen:I

    .line 125
    const v2, 0x7f090018

    invoke-virtual {v0, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v2

    iput v2, p0, Lco/vine/android/widget/GenericVideoAdapter;->mVineGray:I

    .line 127
    iget v2, p0, Lco/vine/android/widget/GenericVideoAdapter;->mVineGreen:I

    iput v2, p0, Lco/vine/android/widget/GenericVideoAdapter;->mProfileColor:I

    .line 128
    return-void
.end method


# virtual methods
.method protected bindAvatar(Lco/vine/android/widget/GenericFeedViewHolder;)V
    .locals 9
    .param p1, "holder"    # Lco/vine/android/widget/GenericFeedViewHolder;

    .prologue
    .line 284
    .local p0, "this":Lco/vine/android/widget/GenericVideoAdapter;, "Lco/vine/android/widget/GenericVideoAdapter<TT;>;"
    iget-object v3, p1, Lco/vine/android/widget/GenericFeedViewHolder;->post:Lco/vine/android/api/VinePost;

    .line 285
    .local v3, "post":Lco/vine/android/api/VinePost;
    iget v2, p1, Lco/vine/android/widget/GenericFeedViewHolder;->position:I

    .line 286
    .local v2, "position":I
    iget-object v4, p1, Lco/vine/android/widget/GenericFeedViewHolder;->userImage:Landroid/widget/ImageView;

    .line 287
    .local v4, "userImage":Landroid/widget/ImageView;
    iget-object v5, v3, Lco/vine/android/api/VinePost;->avatarUrl:Ljava/lang/String;

    if-eqz v5, :cond_0

    .line 288
    iget-object v5, v3, Lco/vine/android/api/VinePost;->avatarUrl:Ljava/lang/String;

    invoke-static {v5}, Lco/vine/android/util/Util;->isDefaultAvatarUrl(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_2

    .line 289
    invoke-virtual {v3}, Lco/vine/android/api/VinePost;->isRevined()Z

    move-result v5

    if-eqz v5, :cond_1

    .line 290
    sget-object v5, Lco/vine/android/util/Util$ProfileImageSize;->MEDIUM:Lco/vine/android/util/Util$ProfileImageSize;

    iget v6, p0, Lco/vine/android/widget/GenericVideoAdapter;->mVineGreen:I

    invoke-static {v4, v5, v6}, Lco/vine/android/util/Util;->safeSetDefaultAvatar(Landroid/widget/ImageView;Lco/vine/android/util/Util$ProfileImageSize;I)V

    .line 306
    :cond_0
    :goto_0
    return-void

    .line 292
    :cond_1
    sget-object v5, Lco/vine/android/util/Util$ProfileImageSize;->MEDIUM:Lco/vine/android/util/Util$ProfileImageSize;

    iget v6, p0, Lco/vine/android/widget/GenericVideoAdapter;->mProfileColor:I

    invoke-static {v4, v5, v6}, Lco/vine/android/util/Util;->safeSetDefaultAvatar(Landroid/widget/ImageView;Lco/vine/android/util/Util$ProfileImageSize;I)V

    goto :goto_0

    .line 295
    :cond_2
    new-instance v1, Lco/vine/android/util/image/ImageKey;

    iget-object v5, v3, Lco/vine/android/api/VinePost;->avatarUrl:Ljava/lang/String;

    iget v6, p0, Lco/vine/android/widget/GenericVideoAdapter;->mProfileImageSize:I

    iget v7, p0, Lco/vine/android/widget/GenericVideoAdapter;->mProfileImageSize:I

    const/4 v8, 0x1

    invoke-direct {v1, v5, v6, v7, v8}, Lco/vine/android/util/image/ImageKey;-><init>(Ljava/lang/String;IIZ)V

    .line 297
    .local v1, "avatarKey":Lco/vine/android/util/image/ImageKey;
    iget-object v5, p0, Lco/vine/android/widget/GenericVideoAdapter;->mAvatars:Landroid/util/SparseArray;

    invoke-virtual {v5, v2}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/graphics/Bitmap;

    .line 298
    .local v0, "avatar":Landroid/graphics/Bitmap;
    if-eqz v0, :cond_3

    .line 299
    invoke-virtual {p0, v4, v0}, Lco/vine/android/widget/GenericVideoAdapter;->setUserImage(Landroid/widget/ImageView;Landroid/graphics/Bitmap;)Z

    .line 303
    :goto_1
    iput-object v1, p1, Lco/vine/android/widget/GenericFeedViewHolder;->avatarKey:Lco/vine/android/util/image/ImageKey;

    goto :goto_0

    .line 301
    :cond_3
    iget-object v5, p0, Lco/vine/android/widget/GenericVideoAdapter;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v5, v1}, Lco/vine/android/client/AppController;->getPhotoBitmap(Lco/vine/android/util/image/ImageKey;)Landroid/graphics/Bitmap;

    move-result-object v5

    invoke-virtual {p0, v4, v5}, Lco/vine/android/widget/GenericVideoAdapter;->setUserImage(Landroid/widget/ImageView;Landroid/graphics/Bitmap;)Z

    goto :goto_1
.end method

.method protected declared-synchronized bindVideoImage(Lco/vine/android/widget/GenericFeedViewHolder;)Z
    .locals 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)Z"
        }
    .end annotation

    .prologue
    .local p0, "this":Lco/vine/android/widget/GenericVideoAdapter;, "Lco/vine/android/widget/GenericVideoAdapter<TT;>;"
    .local p1, "h":Lco/vine/android/widget/GenericFeedViewHolder;, "TT;"
    const/4 v5, 0x1

    const/4 v6, 0x0

    .line 620
    monitor-enter p0

    :try_start_0
    iget-object v2, p1, Lco/vine/android/widget/GenericFeedViewHolder;->post:Lco/vine/android/api/VinePost;

    .line 621
    .local v2, "post":Lco/vine/android/api/VinePost;
    iget v1, p1, Lco/vine/android/widget/GenericFeedViewHolder;->position:I

    .line 623
    .local v1, "position":I
    if-eqz v2, :cond_0

    .line 624
    iget-object v7, v2, Lco/vine/android/api/VinePost;->thumbnailUrl:Ljava/lang/String;

    if-eqz v7, :cond_1

    move v7, v5

    :goto_0
    iput-boolean v7, p1, Lco/vine/android/widget/GenericFeedViewHolder;->hasVideoImage:Z

    .line 626
    invoke-virtual {v2}, Lco/vine/android/api/VinePost;->isExplicit()Z

    move-result v7

    if-eqz v7, :cond_2

    iget-object v7, p0, Lco/vine/android/widget/GenericVideoAdapter;->mDismissedWarnings:Ljava/util/HashSet;

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/util/HashSet;->contains(Ljava/lang/Object;)Z

    move-result v7

    if-nez v7, :cond_2

    move v0, v5

    .line 628
    .local v0, "isSensitiveImage":Z
    :goto_1
    if-eqz v0, :cond_3

    .line 629
    iget-object v6, p1, Lco/vine/android/widget/GenericFeedViewHolder;->sensitiveTextContainer:Landroid/widget/LinearLayout;

    const/4 v7, 0x0

    invoke-virtual {v6, v7}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 630
    invoke-virtual {p0, p1}, Lco/vine/android/widget/GenericVideoAdapter;->createSensitiveLisenter(Lco/vine/android/widget/GenericFeedViewHolder;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 650
    .end local v0    # "isSensitiveImage":Z
    :cond_0
    :goto_2
    monitor-exit p0

    return v5

    :cond_1
    move v7, v6

    .line 624
    goto :goto_0

    :cond_2
    move v0, v6

    .line 626
    goto :goto_1

    .line 632
    .restart local v0    # "isSensitiveImage":Z
    :cond_3
    :try_start_1
    invoke-virtual {p0, p1}, Lco/vine/android/widget/GenericVideoAdapter;->createInsensitiveListener(Lco/vine/android/widget/GenericFeedViewHolder;)V

    .line 633
    iget-boolean v7, p1, Lco/vine/android/widget/GenericFeedViewHolder;->hasVideoImage:Z

    if-eqz v7, :cond_0

    .line 634
    new-instance v3, Lco/vine/android/util/image/ImageKey;

    iget-object v7, v2, Lco/vine/android/api/VinePost;->thumbnailUrl:Ljava/lang/String;

    invoke-direct {v3, v7}, Lco/vine/android/util/image/ImageKey;-><init>(Ljava/lang/String;)V

    .line 635
    .local v3, "videoImageKey":Lco/vine/android/util/image/ImageKey;
    iput-object v3, p1, Lco/vine/android/widget/GenericFeedViewHolder;->videoImageKey:Lco/vine/android/util/image/ImageKey;

    .line 636
    iget-object v7, p0, Lco/vine/android/widget/GenericVideoAdapter;->mThumbnails:Landroid/util/SparseArray;

    invoke-virtual {v7, v1}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/graphics/Bitmap;

    .line 637
    .local v4, "videoThumbnail":Landroid/graphics/Bitmap;
    if-eqz v4, :cond_4

    .line 638
    const-string v6, "setting thumbnail for {}"

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    invoke-static {v6, v7}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 639
    invoke-virtual {p1}, Lco/vine/android/widget/GenericFeedViewHolder;->getViewForVideoImage()Landroid/view/View;

    move-result-object v6

    invoke-virtual {p0, v6, v4}, Lco/vine/android/widget/GenericVideoAdapter;->setImage(Landroid/view/View;Landroid/graphics/Bitmap;)Z

    move-result v6

    iput-boolean v6, p1, Lco/vine/android/widget/GenericFeedViewHolder;->isVideoImageLoaded:Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_2

    .line 620
    .end local v0    # "isSensitiveImage":Z
    .end local v1    # "position":I
    .end local v2    # "post":Lco/vine/android/api/VinePost;
    .end local v3    # "videoImageKey":Lco/vine/android/util/image/ImageKey;
    .end local v4    # "videoThumbnail":Landroid/graphics/Bitmap;
    :catchall_0
    move-exception v5

    monitor-exit p0

    throw v5

    .line 642
    .restart local v0    # "isSensitiveImage":Z
    .restart local v1    # "position":I
    .restart local v2    # "post":Lco/vine/android/api/VinePost;
    .restart local v3    # "videoImageKey":Lco/vine/android/util/image/ImageKey;
    .restart local v4    # "videoThumbnail":Landroid/graphics/Bitmap;
    :cond_4
    :try_start_2
    const-string v5, "fetching thumbnail for {}"

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    invoke-static {v5, v7}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 643
    invoke-virtual {p1}, Lco/vine/android/widget/GenericFeedViewHolder;->getViewForVideoImage()Landroid/view/View;

    move-result-object v5

    iget-object v7, p0, Lco/vine/android/widget/GenericVideoAdapter;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v7, v3}, Lco/vine/android/client/AppController;->getPhotoBitmap(Lco/vine/android/util/image/ImageKey;)Landroid/graphics/Bitmap;

    move-result-object v7

    invoke-virtual {p0, v5, v7}, Lco/vine/android/widget/GenericVideoAdapter;->setImage(Landroid/view/View;Landroid/graphics/Bitmap;)Z

    move-result v5

    iput-boolean v5, p1, Lco/vine/android/widget/GenericFeedViewHolder;->isVideoImageLoaded:Z
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    move v5, v6

    .line 645
    goto :goto_2
.end method

.method protected abstract createInsensitiveListener(Lco/vine/android/widget/GenericFeedViewHolder;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation
.end method

.method protected abstract createSensitiveLisenter(Lco/vine/android/widget/GenericFeedViewHolder;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation
.end method

.method protected endLoadingTimeProfiling()V
    .locals 8

    .prologue
    .local p0, "this":Lco/vine/android/widget/GenericVideoAdapter;, "Lco/vine/android/widget/GenericVideoAdapter<TT;>;"
    const-wide/16 v6, 0x0

    .line 236
    iget-wide v2, p0, Lco/vine/android/widget/GenericVideoAdapter;->mStartLoadingTime:J

    cmp-long v2, v2, v6

    if-lez v2, :cond_0

    .line 237
    invoke-virtual {p0}, Lco/vine/android/widget/GenericVideoAdapter;->timeSinceStartLoadingTime()J

    move-result-wide v2

    const-wide/16 v4, 0x1f4

    div-long/2addr v2, v4

    long-to-float v2, v2

    invoke-static {v2}, Ljava/lang/Math;->round(F)I

    move-result v2

    mul-int/lit16 v2, v2, 0x1f4

    int-to-long v0, v2

    .line 238
    .local v0, "loadingTime":J
    iput-wide v6, p0, Lco/vine/android/widget/GenericVideoAdapter;->mStartLoadingTime:J

    .line 239
    const-string v2, "Loading time for {} was {}ms."

    iget-object v3, p0, Lco/vine/android/widget/GenericVideoAdapter;->mLoadingTimeTag:Ljava/lang/String;

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    invoke-static {v2, v3, v4}, Lcom/edisonwang/android/slog/SLog;->i(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 240
    iget-object v2, p0, Lco/vine/android/widget/GenericVideoAdapter;->mLoadingTimeTag:Ljava/lang/String;

    invoke-static {v2, v0, v1}, Lco/vine/android/util/FlurryUtils;->trackLoadingTime(Ljava/lang/String;J)V

    .line 242
    .end local v0    # "loadingTime":J
    :cond_0
    return-void
.end method

.method public getItemId(I)J
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 560
    .local p0, "this":Lco/vine/android/widget/GenericVideoAdapter;, "Lco/vine/android/widget/GenericVideoAdapter<TT;>;"
    int-to-long v0, p1

    return-wide v0
.end method

.method protected getRequestKey(Lco/vine/android/api/VinePost;Z)Lco/vine/android/util/video/VideoKey;
    .locals 12
    .param p1, "post"    # Lco/vine/android/api/VinePost;
    .param p2, "forceLowKey"    # Z

    .prologue
    .local p0, "this":Lco/vine/android/widget/GenericVideoAdapter;, "Lco/vine/android/widget/GenericVideoAdapter<TT;>;"
    const/4 v7, 0x1

    const/4 v8, 0x0

    .line 689
    iget-object v6, p0, Lco/vine/android/widget/GenericVideoAdapter;->mNormalVideoPlayable:Ljava/lang/Boolean;

    if-nez v6, :cond_0

    .line 690
    iget-object v6, p0, Lco/vine/android/widget/GenericVideoAdapter;->mContext:Landroid/content/Context;

    invoke-static {v6}, Lco/vine/android/util/SystemUtil;->isNormalVideoPlayable(Landroid/content/Context;)Lco/vine/android/util/SystemUtil$PrefBooleanState;

    move-result-object v6

    sget-object v9, Lco/vine/android/util/SystemUtil$PrefBooleanState;->FALSE:Lco/vine/android/util/SystemUtil$PrefBooleanState;

    if-eq v6, v9, :cond_4

    move v6, v7

    :goto_0
    invoke-static {v6}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v6

    iput-object v6, p0, Lco/vine/android/widget/GenericVideoAdapter;->mNormalVideoPlayable:Ljava/lang/Boolean;

    .line 693
    :cond_0
    invoke-static {}, Lco/vine/android/util/video/VideoCache;->getCurrentAverageSpeed()I

    move-result v0

    .line 694
    .local v0, "avgSpeed":I
    const/16 v6, 0xc8

    if-le v0, v6, :cond_5

    move v2, v7

    .line 696
    .local v2, "isSpeedGoodEnough":Z
    :goto_1
    const-string v6, "Getting HQ Video: speed {}, hq? {} && can play normal vid {}"

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v10

    iget-object v11, p0, Lco/vine/android/widget/GenericVideoAdapter;->mNormalVideoPlayable:Ljava/lang/Boolean;

    invoke-static {v6, v9, v10, v11}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 698
    new-instance v5, Lco/vine/android/util/video/VideoKey;

    iget-object v6, p1, Lco/vine/android/api/VinePost;->videoUrl:Ljava/lang/String;

    invoke-direct {v5, v6}, Lco/vine/android/util/video/VideoKey;-><init>(Ljava/lang/String;)V

    .line 699
    .local v5, "peekKey":Lco/vine/android/util/video/VideoKey;
    iget-object v6, p0, Lco/vine/android/widget/GenericVideoAdapter;->mNormalVideoPlayable:Ljava/lang/Boolean;

    invoke-virtual {v6}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v6

    if-eqz v6, :cond_1

    if-nez v2, :cond_3

    .line 700
    :cond_1
    iget-object v6, p1, Lco/vine/android/api/VinePost;->videoLowURL:Ljava/lang/String;

    if-eqz v6, :cond_6

    iget-object v6, p1, Lco/vine/android/api/VinePost;->videoLowURL:Ljava/lang/String;

    invoke-virtual {v6}, Ljava/lang/String;->isEmpty()Z

    move-result v6

    if-nez v6, :cond_6

    move v1, v7

    .line 701
    .local v1, "hasLowKey":Z
    :goto_2
    if-nez v1, :cond_7

    .line 702
    const-string v6, "Low key does NOT exist: forceLowKey {}. "

    invoke-static {p2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v7

    iget-object v8, p0, Lco/vine/android/widget/GenericVideoAdapter;->mNormalVideoPlayable:Ljava/lang/Boolean;

    invoke-static {v6, v7, v8}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 703
    if-nez p2, :cond_2

    iget-object v6, p0, Lco/vine/android/widget/GenericVideoAdapter;->mNormalVideoPlayable:Ljava/lang/Boolean;

    invoke-virtual {v6}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v6

    if-nez v6, :cond_3

    .line 704
    :cond_2
    const/4 v5, 0x0

    .line 718
    .end local v1    # "hasLowKey":Z
    .end local v5    # "peekKey":Lco/vine/android/util/video/VideoKey;
    :cond_3
    :goto_3
    return-object v5

    .end local v0    # "avgSpeed":I
    .end local v2    # "isSpeedGoodEnough":Z
    :cond_4
    move v6, v8

    .line 690
    goto :goto_0

    .restart local v0    # "avgSpeed":I
    :cond_5
    move v2, v8

    .line 694
    goto :goto_1

    .restart local v2    # "isSpeedGoodEnough":Z
    .restart local v5    # "peekKey":Lco/vine/android/util/video/VideoKey;
    :cond_6
    move v1, v8

    .line 700
    goto :goto_2

    .line 709
    .restart local v1    # "hasLowKey":Z
    :cond_7
    new-instance v3, Lco/vine/android/util/video/VideoKey;

    iget-object v6, p1, Lco/vine/android/api/VinePost;->videoLowURL:Ljava/lang/String;

    invoke-direct {v3, v6}, Lco/vine/android/util/video/VideoKey;-><init>(Ljava/lang/String;)V

    .line 710
    .local v3, "lowKey":Lco/vine/android/util/video/VideoKey;
    if-nez p2, :cond_8

    iget-object v6, p0, Lco/vine/android/widget/GenericVideoAdapter;->mNormalVideoPlayable:Ljava/lang/Boolean;

    invoke-virtual {v6}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v6

    if-nez v6, :cond_9

    :cond_8
    move-object v5, v3

    .line 711
    goto :goto_3

    .line 713
    :cond_9
    iget-object v6, p0, Lco/vine/android/widget/GenericVideoAdapter;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v6, v5}, Lco/vine/android/client/AppController;->peekVideoFilePath(Lco/vine/android/util/video/VideoKey;)Ljava/lang/String;

    move-result-object v4

    .line 714
    .local v4, "path":Ljava/lang/String;
    if-nez v4, :cond_3

    move-object v5, v3

    goto :goto_3
.end method

.method public getStartLoadingTime()J
    .locals 2

    .prologue
    .line 245
    .local p0, "this":Lco/vine/android/widget/GenericVideoAdapter;, "Lco/vine/android/widget/GenericVideoAdapter<TT;>;"
    iget-wide v0, p0, Lco/vine/android/widget/GenericVideoAdapter;->mStartLoadingTime:J

    return-wide v0
.end method

.method public hasStableIds()Z
    .locals 1

    .prologue
    .line 565
    .local p0, "this":Lco/vine/android/widget/GenericVideoAdapter;, "Lco/vine/android/widget/GenericVideoAdapter<TT;>;"
    const/4 v0, 0x0

    return v0
.end method

.method public isPlaying()Z
    .locals 1

    .prologue
    .line 656
    .local p0, "this":Lco/vine/android/widget/GenericVideoAdapter;, "Lco/vine/android/widget/GenericVideoAdapter<TT;>;"
    const/4 v0, 0x0

    return v0
.end method

.method public notifyDataSetChanged()V
    .locals 1

    .prologue
    .line 222
    .local p0, "this":Lco/vine/android/widget/GenericVideoAdapter;, "Lco/vine/android/widget/GenericVideoAdapter<TT;>;"
    invoke-super {p0}, Landroid/widget/BaseAdapter;->notifyDataSetChanged()V

    .line 223
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lco/vine/android/widget/GenericVideoAdapter;->resetStates(Z)V

    .line 224
    return-void
.end method

.method public onBackPressed()Z
    .locals 1

    .prologue
    .line 276
    .local p0, "this":Lco/vine/android/widget/GenericVideoAdapter;, "Lco/vine/android/widget/GenericVideoAdapter<TT;>;"
    const/4 v0, 0x0

    return v0
.end method

.method public onDestroy()V
    .locals 0

    .prologue
    .line 218
    .local p0, "this":Lco/vine/android/widget/GenericVideoAdapter;, "Lco/vine/android/widget/GenericVideoAdapter<TT;>;"
    return-void
.end method

.method public onDestroyView()V
    .locals 0

    .prologue
    .line 262
    .local p0, "this":Lco/vine/android/widget/GenericVideoAdapter;, "Lco/vine/android/widget/GenericVideoAdapter<TT;>;"
    return-void
.end method

.method protected onInvalidRequestKey()V
    .locals 1

    .prologue
    .line 685
    .local p0, "this":Lco/vine/android/widget/GenericVideoAdapter;, "Lco/vine/android/widget/GenericVideoAdapter<TT;>;"
    const-string v0, "Invalid request key."

    invoke-static {v0}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;)V

    .line 686
    return-void
.end method

.method public onLowMemory()V
    .locals 2

    .prologue
    .line 668
    .local p0, "this":Lco/vine/android/widget/GenericVideoAdapter;, "Lco/vine/android/widget/GenericVideoAdapter<TT;>;"
    const-string v0, "onLowMemory called."

    new-instance v1, Lco/vine/android/VineLoggingException;

    invoke-direct {v1}, Lco/vine/android/VineLoggingException;-><init>()V

    invoke-static {v0, v1}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 669
    iget-object v0, p0, Lco/vine/android/widget/GenericVideoAdapter;->mThumbnails:Landroid/util/SparseArray;

    invoke-virtual {v0}, Landroid/util/SparseArray;->clear()V

    .line 670
    iget-object v0, p0, Lco/vine/android/widget/GenericVideoAdapter;->mAvatars:Landroid/util/SparseArray;

    invoke-virtual {v0}, Landroid/util/SparseArray;->clear()V

    .line 671
    return-void
.end method

.method public onPause(Z)V
    .locals 0
    .param p1, "isFocused"    # Z

    .prologue
    .line 254
    .local p0, "this":Lco/vine/android/widget/GenericVideoAdapter;, "Lco/vine/android/widget/GenericVideoAdapter<TT;>;"
    return-void
.end method

.method public onResume(Z)V
    .locals 0
    .param p1, "isFocused"    # Z

    .prologue
    .line 258
    .local p0, "this":Lco/vine/android/widget/GenericVideoAdapter;, "Lco/vine/android/widget/GenericVideoAdapter<TT;>;"
    return-void
.end method

.method public onScrollStateChanged(Landroid/widget/AbsListView;I)V
    .locals 0
    .param p1, "view"    # Landroid/widget/AbsListView;
    .param p2, "scrollState"    # I

    .prologue
    .line 270
    .local p0, "this":Lco/vine/android/widget/GenericVideoAdapter;, "Lco/vine/android/widget/GenericVideoAdapter<TT;>;"
    return-void
.end method

.method public onTrimMemory(I)V
    .locals 3
    .param p1, "level"    # I

    .prologue
    .line 660
    .local p0, "this":Lco/vine/android/widget/GenericVideoAdapter;, "Lco/vine/android/widget/GenericVideoAdapter<TT;>;"
    const/16 v0, 0x50

    if-eq p1, v0, :cond_0

    .line 661
    const-string v0, "onTrimMemory: Adapter has cleaned it\'s bitmaps: {}, {}."

    iget-object v1, p0, Lco/vine/android/widget/GenericVideoAdapter;->mAvatars:Landroid/util/SparseArray;

    invoke-virtual {v1}, Landroid/util/SparseArray;->size()I

    move-result v1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    iget-object v2, p0, Lco/vine/android/widget/GenericVideoAdapter;->mThumbnails:Landroid/util/SparseArray;

    invoke-virtual {v2}, Landroid/util/SparseArray;->size()I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 662
    iget-object v0, p0, Lco/vine/android/widget/GenericVideoAdapter;->mAvatars:Landroid/util/SparseArray;

    invoke-virtual {v0}, Landroid/util/SparseArray;->clear()V

    .line 663
    iget-object v0, p0, Lco/vine/android/widget/GenericVideoAdapter;->mThumbnails:Landroid/util/SparseArray;

    invoke-virtual {v0}, Landroid/util/SparseArray;->clear()V

    .line 665
    :cond_0
    return-void
.end method

.method protected onVideoImageObtained(Lco/vine/android/widget/GenericFeedViewHolder;Z)V
    .locals 0
    .param p2, "b"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;Z)V"
        }
    .end annotation

    .prologue
    .line 556
    .local p0, "this":Lco/vine/android/widget/GenericVideoAdapter;, "Lco/vine/android/widget/GenericVideoAdapter<TT;>;"
    .local p1, "holder":Lco/vine/android/widget/GenericFeedViewHolder;, "TT;"
    return-void
.end method

.method public onVideoPathObtained(Ljava/util/HashMap;)V
    .locals 0
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
    .line 266
    .local p0, "this":Lco/vine/android/widget/GenericVideoAdapter;, "Lco/vine/android/widget/GenericVideoAdapter<TT;>;"
    .local p1, "videos":Ljava/util/HashMap;, "Ljava/util/HashMap<Lco/vine/android/util/video/VideoKey;Lco/vine/android/util/video/UrlVideo;>;"
    return-void
.end method

.method protected resetStates(Z)V
    .locals 1
    .param p1, "hasDataSetChanged"    # Z

    .prologue
    .line 140
    .local p0, "this":Lco/vine/android/widget/GenericVideoAdapter;, "Lco/vine/android/widget/GenericVideoAdapter<TT;>;"
    if-eqz p1, :cond_0

    .line 141
    iget-object v0, p0, Lco/vine/android/widget/GenericVideoAdapter;->mThumbnails:Landroid/util/SparseArray;

    invoke-virtual {v0}, Landroid/util/SparseArray;->clear()V

    .line 142
    iget-object v0, p0, Lco/vine/android/widget/GenericVideoAdapter;->mAvatars:Landroid/util/SparseArray;

    invoke-virtual {v0}, Landroid/util/SparseArray;->clear()V

    .line 144
    :cond_0
    return-void
.end method

.method protected setImage(Landroid/view/View;Landroid/graphics/Bitmap;)Z
    .locals 2
    .param p1, "imageView"    # Landroid/view/View;
    .param p2, "bitmap"    # Landroid/graphics/Bitmap;

    .prologue
    .line 581
    .local p0, "this":Lco/vine/android/widget/GenericVideoAdapter;, "Lco/vine/android/widget/GenericVideoAdapter<TT;>;"
    if-nez p2, :cond_0

    .line 582
    iget-object v0, p0, Lco/vine/android/widget/GenericVideoAdapter;->mContext:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f09007f

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getColor(I)I

    move-result v0

    invoke-virtual {p1, v0}, Landroid/view/View;->setBackgroundColor(I)V

    .line 583
    const/4 v0, 0x0

    .line 586
    :goto_0
    return v0

    .line 585
    :cond_0
    new-instance v0, Lco/vine/android/drawable/RecyclableBitmapDrawable;

    iget-object v1, p0, Lco/vine/android/widget/GenericVideoAdapter;->mContext:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-direct {v0, v1, p2}, Lco/vine/android/drawable/RecyclableBitmapDrawable;-><init>(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V

    invoke-virtual {p1, v0}, Landroid/view/View;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 586
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public setImages(Ljava/util/HashMap;)V
    .locals 7
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
    .line 591
    .local p0, "this":Lco/vine/android/widget/GenericVideoAdapter;, "Lco/vine/android/widget/GenericVideoAdapter<TT;>;"
    .local p1, "images":Ljava/util/HashMap;, "Ljava/util/HashMap<Lco/vine/android/util/image/ImageKey;Lco/vine/android/util/image/UrlImage;>;"
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    .line 592
    .local v4, "toRemove":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/ref/WeakReference<TT;>;>;"
    iget-object v5, p0, Lco/vine/android/widget/GenericVideoAdapter;->mViewHolders:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_3

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/ref/WeakReference;

    .line 593
    .local v3, "ref":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<TT;>;"
    invoke-virtual {v3}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/widget/GenericFeedViewHolder;

    .line 594
    .local v0, "holder":Lco/vine/android/widget/GenericFeedViewHolder;, "TT;"
    if-nez v0, :cond_1

    .line 595
    invoke-virtual {v4, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 598
    :cond_1
    iget-object v5, v0, Lco/vine/android/widget/GenericFeedViewHolder;->avatarKey:Lco/vine/android/util/image/ImageKey;

    if-eqz v5, :cond_2

    .line 599
    iget-object v5, v0, Lco/vine/android/widget/GenericFeedViewHolder;->avatarKey:Lco/vine/android/util/image/ImageKey;

    invoke-virtual {p1, v5}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lco/vine/android/util/image/UrlImage;

    .line 600
    .local v2, "image":Lco/vine/android/util/image/UrlImage;
    if-eqz v2, :cond_2

    invoke-virtual {v2}, Lco/vine/android/util/image/UrlImage;->isValid()Z

    move-result v5

    if-eqz v5, :cond_2

    .line 601
    iget-object v5, v0, Lco/vine/android/widget/GenericFeedViewHolder;->userImage:Landroid/widget/ImageView;

    iget-object v6, v2, Lco/vine/android/util/image/UrlImage;->bitmap:Landroid/graphics/Bitmap;

    invoke-virtual {p0, v5, v6}, Lco/vine/android/widget/GenericVideoAdapter;->setUserImage(Landroid/widget/ImageView;Landroid/graphics/Bitmap;)Z

    .line 602
    const-string v5, "found for avatar."

    invoke-static {v5}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 605
    .end local v2    # "image":Lco/vine/android/util/image/UrlImage;
    :cond_2
    iget-object v5, v0, Lco/vine/android/widget/GenericFeedViewHolder;->videoImageKey:Lco/vine/android/util/image/ImageKey;

    if-eqz v5, :cond_0

    .line 606
    iget-object v5, v0, Lco/vine/android/widget/GenericFeedViewHolder;->videoImageKey:Lco/vine/android/util/image/ImageKey;

    invoke-virtual {p1, v5}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lco/vine/android/util/image/UrlImage;

    .line 607
    .restart local v2    # "image":Lco/vine/android/util/image/UrlImage;
    if-eqz v2, :cond_0

    invoke-virtual {v2}, Lco/vine/android/util/image/UrlImage;->isValid()Z

    move-result v5

    if-eqz v5, :cond_0

    .line 608
    const-string v5, "found for video: {}"

    iget-object v6, v2, Lco/vine/android/util/image/UrlImage;->url:Ljava/lang/String;

    invoke-static {v5, v6}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 609
    invoke-virtual {v0}, Lco/vine/android/widget/GenericFeedViewHolder;->getViewForVideoImage()Landroid/view/View;

    move-result-object v5

    iget-object v6, v2, Lco/vine/android/util/image/UrlImage;->bitmap:Landroid/graphics/Bitmap;

    invoke-virtual {p0, v5, v6}, Lco/vine/android/widget/GenericVideoAdapter;->setImage(Landroid/view/View;Landroid/graphics/Bitmap;)Z

    move-result v5

    invoke-virtual {p0, v0, v5}, Lco/vine/android/widget/GenericVideoAdapter;->onVideoImageObtained(Lco/vine/android/widget/GenericFeedViewHolder;Z)V

    goto :goto_0

    .line 614
    .end local v0    # "holder":Lco/vine/android/widget/GenericFeedViewHolder;, "TT;"
    .end local v2    # "image":Lco/vine/android/util/image/UrlImage;
    .end local v3    # "ref":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<TT;>;"
    :cond_3
    iget-object v5, p0, Lco/vine/android/widget/GenericVideoAdapter;->mViewHolders:Ljava/util/ArrayList;

    invoke-virtual {v5, v4}, Ljava/util/ArrayList;->removeAll(Ljava/util/Collection;)Z

    .line 615
    return-void
.end method

.method public setOffsetResolver(Lco/vine/android/ViewOffsetResolver;)V
    .locals 0
    .param p1, "resolver"    # Lco/vine/android/ViewOffsetResolver;

    .prologue
    .line 280
    .local p0, "this":Lco/vine/android/widget/GenericVideoAdapter;, "Lco/vine/android/widget/GenericVideoAdapter<TT;>;"
    iput-object p1, p0, Lco/vine/android/widget/GenericVideoAdapter;->mViewOffsetResolver:Lco/vine/android/ViewOffsetResolver;

    .line 281
    return-void
.end method

.method public setProfileColor(I)V
    .locals 2
    .param p1, "color"    # I

    .prologue
    .line 131
    .local p0, "this":Lco/vine/android/widget/GenericVideoAdapter;, "Lco/vine/android/widget/GenericVideoAdapter<TT;>;"
    sget v0, Lco/vine/android/Settings;->DEFAULT_PROFILE_COLOR:I

    if-eq p1, v0, :cond_0

    if-gtz p1, :cond_1

    .line 132
    :cond_0
    iget-object v0, p0, Lco/vine/android/widget/GenericVideoAdapter;->mContext:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f090096

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getColor(I)I

    move-result p1

    .line 134
    :cond_1
    iget v0, p0, Lco/vine/android/widget/GenericVideoAdapter;->mProfileColor:I

    if-eq v0, p1, :cond_2

    .line 135
    const/high16 v0, -0x1000000

    or-int/2addr v0, p1

    iput v0, p0, Lco/vine/android/widget/GenericVideoAdapter;->mProfileColor:I

    .line 137
    :cond_2
    return-void
.end method

.method protected setStyledComments(Lco/vine/android/widget/GenericFeedViewHolder;Lco/vine/android/api/VinePagedData;)V
    .locals 36
    .param p1, "holder"    # Lco/vine/android/widget/GenericFeedViewHolder;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lco/vine/android/widget/GenericFeedViewHolder;",
            "Lco/vine/android/api/VinePagedData",
            "<",
            "Lco/vine/android/api/VineComment;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 345
    .local p0, "this":Lco/vine/android/widget/GenericVideoAdapter;, "Lco/vine/android/widget/GenericVideoAdapter<TT;>;"
    .local p2, "commentData":Lco/vine/android/api/VinePagedData;, "Lco/vine/android/api/VinePagedData<Lco/vine/android/api/VineComment;>;"
    move-object/from16 v0, p0

    iget-object v4, v0, Lco/vine/android/widget/GenericVideoAdapter;->mContext:Landroid/content/Context;

    invoke-virtual {v4}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v23

    .line 347
    .local v23, "res":Landroid/content/res/Resources;
    move-object/from16 v0, p1

    iget-object v4, v0, Lco/vine/android/widget/GenericFeedViewHolder;->comments1:Landroid/widget/TextView;

    const/16 v5, 0x8

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setVisibility(I)V

    .line 348
    move-object/from16 v0, p1

    iget-object v4, v0, Lco/vine/android/widget/GenericFeedViewHolder;->comments2:Landroid/widget/TextView;

    const/16 v5, 0x8

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setVisibility(I)V

    .line 349
    move-object/from16 v0, p1

    iget-object v4, v0, Lco/vine/android/widget/GenericFeedViewHolder;->comments3:Landroid/widget/TextView;

    const/16 v5, 0x8

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setVisibility(I)V

    .line 351
    move-object/from16 v0, p1

    iget-object v0, v0, Lco/vine/android/widget/GenericFeedViewHolder;->postCommentsDivider:Landroid/view/View;

    move-object/from16 v21, v0

    .line 352
    .local v21, "postCommentsDivider":Landroid/view/View;
    if-eqz p2, :cond_1

    invoke-virtual/range {p2 .. p2}, Lco/vine/android/api/VinePagedData;->isEmpty()Z

    move-result v4

    if-nez v4, :cond_1

    .line 353
    const/4 v4, 0x0

    move-object/from16 v0, v21

    invoke-virtual {v0, v4}, Landroid/view/View;->setVisibility(I)V

    .line 358
    :goto_0
    if-eqz p2, :cond_0

    move-object/from16 v0, p2

    iget-object v4, v0, Lco/vine/android/api/VinePagedData;->items:Ljava/util/ArrayList;

    if-eqz v4, :cond_0

    move-object/from16 v0, p2

    iget-object v4, v0, Lco/vine/android/api/VinePagedData;->items:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v4

    if-nez v4, :cond_0

    if-nez p1, :cond_2

    .line 482
    :cond_0
    return-void

    .line 355
    :cond_1
    const/16 v4, 0x8

    move-object/from16 v0, v21

    invoke-virtual {v0, v4}, Landroid/view/View;->setVisibility(I)V

    goto :goto_0

    .line 362
    :cond_2
    move-object/from16 v0, p2

    iget v4, v0, Lco/vine/android/api/VinePagedData;->count:I

    const/4 v5, 0x3

    if-le v4, v5, :cond_3

    .line 363
    const v4, 0x7f0e0245

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    move-object/from16 v0, p2

    iget v8, v0, Lco/vine/android/api/VinePagedData;->count:I

    invoke-static {v8}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    aput-object v8, v5, v6

    move-object/from16 v0, v23

    invoke-virtual {v0, v4, v5}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v15

    .line 364
    .local v15, "cta":Ljava/lang/String;
    new-instance v26, Landroid/text/SpannableStringBuilder;

    invoke-direct/range {v26 .. v26}, Landroid/text/SpannableStringBuilder;-><init>()V

    .line 365
    .local v26, "ssb":Landroid/text/SpannableStringBuilder;
    move-object/from16 v0, v26

    invoke-virtual {v0, v15}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 366
    new-instance v11, Lco/vine/android/widget/StyledClickableSpan;

    const/16 v34, 0x3

    new-instance v3, Lco/vine/android/widget/GenericVideoAdapter$SpanCommentObjectTag;

    move-object/from16 v0, p1

    iget-object v4, v0, Lco/vine/android/widget/GenericFeedViewHolder;->post:Lco/vine/android/api/VinePost;

    iget-wide v5, v4, Lco/vine/android/api/VinePost;->postId:J

    move-object/from16 v0, p1

    iget-object v4, v0, Lco/vine/android/widget/GenericFeedViewHolder;->post:Lco/vine/android/api/VinePost;

    iget-wide v7, v4, Lco/vine/android/api/VinePost;->userId:J

    move-object/from16 v4, p0

    invoke-direct/range {v3 .. v8}, Lco/vine/android/widget/GenericVideoAdapter$SpanCommentObjectTag;-><init>(Lco/vine/android/widget/GenericVideoAdapter;JJ)V

    move-object/from16 v0, p0

    iget-object v4, v0, Lco/vine/android/widget/GenericVideoAdapter;->mSpanClickListener:Lco/vine/android/widget/SpanClickListener;

    move/from16 v0, v34

    invoke-direct {v11, v0, v3, v4}, Lco/vine/android/widget/StyledClickableSpan;-><init>(ILjava/lang/Object;Lco/vine/android/widget/SpanClickListener;)V

    .line 368
    .local v11, "clickableSpan":Lco/vine/android/widget/StyledClickableSpan;
    move-object/from16 v0, p0

    iget v4, v0, Lco/vine/android/widget/GenericVideoAdapter;->mVineGray:I

    invoke-virtual {v11, v4}, Lco/vine/android/widget/StyledClickableSpan;->setColor(I)V

    .line 369
    const/4 v4, 0x0

    invoke-virtual/range {v26 .. v26}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v5

    const/16 v6, 0x21

    move-object/from16 v0, v26

    invoke-static {v0, v11, v4, v5, v6}, Lco/vine/android/util/Util;->safeSetSpan(Landroid/text/Spannable;Ljava/lang/Object;III)V

    .line 371
    move-object/from16 v0, p1

    iget-object v0, v0, Lco/vine/android/widget/GenericFeedViewHolder;->viewAllComments:Landroid/widget/TextView;

    move-object/from16 v33, v0

    .line 372
    .local v33, "viewAllComments":Landroid/widget/TextView;
    const/4 v4, 0x0

    move-object/from16 v0, v33

    invoke-virtual {v0, v4}, Landroid/widget/TextView;->setVisibility(I)V

    .line 373
    invoke-static {}, Landroid/text/method/LinkMovementMethod;->getInstance()Landroid/text/method/MovementMethod;

    move-result-object v4

    move-object/from16 v0, v33

    invoke-virtual {v0, v4}, Landroid/widget/TextView;->setMovementMethod(Landroid/text/method/MovementMethod;)V

    .line 374
    move-object/from16 v0, v33

    move-object/from16 v1, v26

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 379
    .end local v11    # "clickableSpan":Lco/vine/android/widget/StyledClickableSpan;
    .end local v15    # "cta":Ljava/lang/String;
    .end local v26    # "ssb":Landroid/text/SpannableStringBuilder;
    .end local v33    # "viewAllComments":Landroid/widget/TextView;
    :goto_1
    move-object/from16 v0, p2

    iget-object v13, v0, Lco/vine/android/api/VinePagedData;->items:Ljava/util/ArrayList;

    .line 380
    .local v13, "comments":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineComment;>;"
    invoke-virtual {v13}, Ljava/util/ArrayList;->size()I

    move-result v24

    .line 381
    .local v24, "size":I
    const/4 v14, 0x0

    .line 384
    .local v14, "count":I
    add-int/lit8 v4, v24, -0x3

    const/4 v5, 0x0

    invoke-static {v4, v5}, Ljava/lang/Math;->max(II)I

    move-result v20

    .local v20, "index":I
    :goto_2
    move/from16 v0, v20

    move/from16 v1, v24

    if-ge v0, v1, :cond_0

    .line 385
    move/from16 v0, v20

    invoke-virtual {v13, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v12

    check-cast v12, Lco/vine/android/api/VineComment;

    .line 386
    .local v12, "comment":Lco/vine/android/api/VineComment;
    const/4 v4, 0x3

    if-ge v14, v4, :cond_0

    .line 391
    packed-switch v14, :pswitch_data_0

    .line 402
    move-object/from16 v0, p1

    iget-object v0, v0, Lco/vine/android/widget/GenericFeedViewHolder;->comments3:Landroid/widget/TextView;

    move-object/from16 v27, v0

    .line 407
    .local v27, "thisComment":Landroid/widget/TextView;
    :goto_3
    const/4 v4, 0x0

    move-object/from16 v0, v27

    invoke-virtual {v0, v4}, Landroid/widget/TextView;->setVisibility(I)V

    .line 409
    iget-object v4, v12, Lco/vine/android/api/VineComment;->commentSb:Landroid/text/SpannableStringBuilder;

    if-nez v4, :cond_8

    .line 410
    new-instance v4, Landroid/text/SpannableStringBuilder;

    invoke-direct {v4}, Landroid/text/SpannableStringBuilder;-><init>()V

    iput-object v4, v12, Lco/vine/android/api/VineComment;->commentSb:Landroid/text/SpannableStringBuilder;

    .line 411
    iget-object v0, v12, Lco/vine/android/api/VineComment;->commentSb:Landroid/text/SpannableStringBuilder;

    move-object/from16 v28, v0

    .line 415
    .local v28, "thisCommentSb":Landroid/text/SpannableStringBuilder;
    :try_start_0
    move-object/from16 v0, p0

    iget-object v4, v0, Lco/vine/android/widget/GenericVideoAdapter;->mContext:Landroid/content/Context;

    iget-wide v5, v12, Lco/vine/android/api/VineComment;->timestamp:J

    const/4 v8, 0x0

    invoke-static {v4, v5, v6, v8}, Lco/vine/android/util/Util;->getRelativeTimeString(Landroid/content/Context;JZ)Ljava/lang/String;

    move-result-object v22

    .line 417
    .local v22, "relativeTimeString":Ljava/lang/String;
    iget-object v4, v12, Lco/vine/android/api/VineComment;->username:Ljava/lang/String;

    move-object/from16 v0, v28

    invoke-virtual {v0, v4}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    move-result-object v4

    const/16 v5, 0x20

    invoke-virtual {v4, v5}, Landroid/text/SpannableStringBuilder;->append(C)Landroid/text/SpannableStringBuilder;

    move-result-object v4

    iget-object v5, v12, Lco/vine/android/api/VineComment;->comment:Ljava/lang/String;

    invoke-virtual {v4, v5}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    move-result-object v4

    const/16 v5, 0x20

    invoke-virtual {v4, v5}, Landroid/text/SpannableStringBuilder;->append(C)Landroid/text/SpannableStringBuilder;

    move-result-object v4

    move-object/from16 v0, v22

    invoke-virtual {v4, v0}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
    :try_end_0
    .catch Ljava/lang/NullPointerException; {:try_start_0 .. :try_end_0} :catch_0

    .line 426
    const/16 v32, 0x0

    .line 427
    .local v32, "usernameStart":I
    iget-object v4, v12, Lco/vine/android/api/VineComment;->username:Ljava/lang/String;

    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v31

    .line 428
    .local v31, "usernameEnd":I
    iget-object v4, v12, Lco/vine/android/api/VineComment;->comment:Ljava/lang/String;

    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v4

    add-int v4, v4, v31

    add-int/lit8 v30, v4, 0x2

    .line 429
    .local v30, "timestampStart":I
    invoke-virtual/range {v28 .. v28}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v29

    .line 431
    .local v29, "timestampEnd":I
    new-instance v25, Lco/vine/android/widget/StyledClickableSpan;

    const/4 v4, 0x1

    iget-wide v5, v12, Lco/vine/android/api/VineComment;->userId:J

    invoke-static {v5, v6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/widget/GenericVideoAdapter;->mSpanClickListener:Lco/vine/android/widget/SpanClickListener;

    move-object/from16 v0, v25

    invoke-direct {v0, v4, v5, v6}, Lco/vine/android/widget/StyledClickableSpan;-><init>(ILjava/lang/Object;Lco/vine/android/widget/SpanClickListener;)V

    .line 433
    .local v25, "span":Lco/vine/android/widget/StyledClickableSpan;
    new-instance v9, Lco/vine/android/widget/TypefacesSpan;

    const/4 v4, 0x0

    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/widget/GenericVideoAdapter;->mContext:Landroid/content/Context;

    invoke-static {v5}, Lco/vine/android/widget/Typefaces;->get(Landroid/content/Context;)Lco/vine/android/widget/Typefaces;

    move-result-object v5

    const/4 v6, 0x0

    const/4 v8, 0x3

    invoke-virtual {v5, v6, v8}, Lco/vine/android/widget/Typefaces;->getContentTypeface(II)Landroid/graphics/Typeface;

    move-result-object v5

    invoke-direct {v9, v4, v5}, Lco/vine/android/widget/TypefacesSpan;-><init>(Ljava/lang/String;Landroid/graphics/Typeface;)V

    .line 435
    .local v9, "boldSpan":Lco/vine/android/widget/TypefacesSpan;
    new-instance v7, Landroid/content/res/ColorStateList;

    const/4 v4, 0x1

    new-array v4, v4, [[I

    const/4 v5, 0x0

    const/4 v6, 0x0

    new-array v6, v6, [I

    aput-object v6, v4, v5

    const/4 v5, 0x1

    new-array v5, v5, [I

    const/4 v6, 0x0

    const v8, 0x7f090018

    move-object/from16 v0, v23

    invoke-virtual {v0, v8}, Landroid/content/res/Resources;->getColor(I)I

    move-result v8

    aput v8, v5, v6

    invoke-direct {v7, v4, v5}, Landroid/content/res/ColorStateList;-><init>([[I[I)V

    .line 437
    .local v7, "color":Landroid/content/res/ColorStateList;
    new-instance v3, Landroid/text/style/TextAppearanceSpan;

    const/4 v4, 0x0

    const/4 v5, 0x0

    const v6, 0x7f0b004a

    move-object/from16 v0, v23

    invoke-virtual {v0, v6}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v6

    const/4 v8, 0x0

    invoke-direct/range {v3 .. v8}, Landroid/text/style/TextAppearanceSpan;-><init>(Ljava/lang/String;IILandroid/content/res/ColorStateList;Landroid/content/res/ColorStateList;)V

    .line 440
    .local v3, "timestampSpan":Landroid/text/style/TextAppearanceSpan;
    move-object/from16 v0, p0

    iget v4, v0, Lco/vine/android/widget/GenericVideoAdapter;->mProfileColor:I

    move-object/from16 v0, v25

    invoke-virtual {v0, v4}, Lco/vine/android/widget/StyledClickableSpan;->setColor(I)V

    .line 441
    const/4 v4, 0x0

    const/16 v5, 0x21

    move-object/from16 v0, v28

    move-object/from16 v1, v25

    move/from16 v2, v31

    invoke-static {v0, v1, v4, v2, v5}, Lco/vine/android/util/Util;->safeSetSpan(Landroid/text/Spannable;Ljava/lang/Object;III)V

    .line 442
    const/4 v4, 0x0

    const/16 v5, 0x21

    move-object/from16 v0, v28

    move/from16 v1, v31

    invoke-static {v0, v9, v4, v1, v5}, Lco/vine/android/util/Util;->safeSetSpan(Landroid/text/Spannable;Ljava/lang/Object;III)V

    .line 443
    const/16 v4, 0x21

    move-object/from16 v0, v28

    move/from16 v1, v30

    move/from16 v2, v29

    invoke-static {v0, v3, v1, v2, v4}, Lco/vine/android/util/Util;->safeSetSpan(Landroid/text/Spannable;Ljava/lang/Object;III)V

    .line 445
    iget-object v4, v12, Lco/vine/android/api/VineComment;->transientEntities:Ljava/util/ArrayList;

    if-nez v4, :cond_4

    iget-object v4, v12, Lco/vine/android/api/VineComment;->entities:Ljava/util/ArrayList;

    if-eqz v4, :cond_4

    .line 446
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    iput-object v4, v12, Lco/vine/android/api/VineComment;->transientEntities:Ljava/util/ArrayList;

    .line 447
    iget-object v4, v12, Lco/vine/android/api/VineComment;->entities:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v19

    .local v19, "i$":Ljava/util/Iterator;
    :goto_4
    invoke-interface/range {v19 .. v19}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_4

    invoke-interface/range {v19 .. v19}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v18

    check-cast v18, Lco/vine/android/api/VineEntity;

    .line 448
    .local v18, "entity":Lco/vine/android/api/VineEntity;
    iget-object v4, v12, Lco/vine/android/api/VineComment;->transientEntities:Ljava/util/ArrayList;

    invoke-virtual/range {v18 .. v18}, Lco/vine/android/api/VineEntity;->duplicate()Lco/vine/android/api/VineEntity;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_4

    .line 376
    .end local v3    # "timestampSpan":Landroid/text/style/TextAppearanceSpan;
    .end local v7    # "color":Landroid/content/res/ColorStateList;
    .end local v9    # "boldSpan":Lco/vine/android/widget/TypefacesSpan;
    .end local v12    # "comment":Lco/vine/android/api/VineComment;
    .end local v13    # "comments":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineComment;>;"
    .end local v14    # "count":I
    .end local v18    # "entity":Lco/vine/android/api/VineEntity;
    .end local v19    # "i$":Ljava/util/Iterator;
    .end local v20    # "index":I
    .end local v22    # "relativeTimeString":Ljava/lang/String;
    .end local v24    # "size":I
    .end local v25    # "span":Lco/vine/android/widget/StyledClickableSpan;
    .end local v27    # "thisComment":Landroid/widget/TextView;
    .end local v28    # "thisCommentSb":Landroid/text/SpannableStringBuilder;
    .end local v29    # "timestampEnd":I
    .end local v30    # "timestampStart":I
    .end local v31    # "usernameEnd":I
    .end local v32    # "usernameStart":I
    :cond_3
    move-object/from16 v0, p1

    iget-object v4, v0, Lco/vine/android/widget/GenericFeedViewHolder;->viewAllComments:Landroid/widget/TextView;

    const/16 v5, 0x8

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setVisibility(I)V

    goto/16 :goto_1

    .line 393
    .restart local v12    # "comment":Lco/vine/android/api/VineComment;
    .restart local v13    # "comments":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineComment;>;"
    .restart local v14    # "count":I
    .restart local v20    # "index":I
    .restart local v24    # "size":I
    :pswitch_0
    move-object/from16 v0, p1

    iget-object v0, v0, Lco/vine/android/widget/GenericFeedViewHolder;->comments1:Landroid/widget/TextView;

    move-object/from16 v27, v0

    .line 394
    .restart local v27    # "thisComment":Landroid/widget/TextView;
    goto/16 :goto_3

    .line 397
    .end local v27    # "thisComment":Landroid/widget/TextView;
    :pswitch_1
    move-object/from16 v0, p1

    iget-object v0, v0, Lco/vine/android/widget/GenericFeedViewHolder;->comments2:Landroid/widget/TextView;

    move-object/from16 v27, v0

    .line 398
    .restart local v27    # "thisComment":Landroid/widget/TextView;
    goto/16 :goto_3

    .line 420
    .restart local v28    # "thisCommentSb":Landroid/text/SpannableStringBuilder;
    :catch_0
    move-exception v16

    .line 421
    .local v16, "e":Ljava/lang/NullPointerException;
    const-string v4, "Comment attribute caused NPE: {} {} {}"

    const/4 v5, 0x3

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    iget-wide v0, v12, Lco/vine/android/api/VineComment;->commentId:J

    move-wide/from16 v34, v0

    invoke-static/range {v34 .. v35}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v8

    aput-object v8, v5, v6

    const/4 v6, 0x1

    iget-object v8, v12, Lco/vine/android/api/VineComment;->username:Ljava/lang/String;

    aput-object v8, v5, v6

    const/4 v6, 0x2

    iget-object v8, v12, Lco/vine/android/api/VineComment;->comment:Ljava/lang/String;

    aput-object v8, v5, v6

    move-object/from16 v0, v16

    invoke-static {v0, v4, v5}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 384
    .end local v16    # "e":Ljava/lang/NullPointerException;
    .end local v28    # "thisCommentSb":Landroid/text/SpannableStringBuilder;
    :goto_5
    add-int/lit8 v20, v20, 0x1

    add-int/lit8 v14, v14, 0x1

    goto/16 :goto_2

    .line 453
    .restart local v3    # "timestampSpan":Landroid/text/style/TextAppearanceSpan;
    .restart local v7    # "color":Landroid/content/res/ColorStateList;
    .restart local v9    # "boldSpan":Lco/vine/android/widget/TypefacesSpan;
    .restart local v22    # "relativeTimeString":Ljava/lang/String;
    .restart local v25    # "span":Lco/vine/android/widget/StyledClickableSpan;
    .restart local v28    # "thisCommentSb":Landroid/text/SpannableStringBuilder;
    .restart local v29    # "timestampEnd":I
    .restart local v30    # "timestampStart":I
    .restart local v31    # "usernameEnd":I
    .restart local v32    # "usernameStart":I
    :cond_4
    iget-object v0, v12, Lco/vine/android/api/VineComment;->transientEntities:Ljava/util/ArrayList;

    move-object/from16 v17, v0

    .line 455
    .local v17, "entities":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineEntity;>;"
    if-eqz v17, :cond_8

    .line 456
    add-int/lit8 v4, v31, 0x1

    const/4 v5, 0x0

    :try_start_1
    move-object/from16 v0, v17

    move-object/from16 v1, v28

    invoke-static {v0, v1, v4, v5}, Lco/vine/android/util/Util;->adjustEntities(Ljava/util/ArrayList;Landroid/text/Editable;IZ)V

    .line 457
    invoke-virtual/range {v17 .. v17}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v19

    .restart local v19    # "i$":Ljava/util/Iterator;
    :cond_5
    :goto_6
    invoke-interface/range {v19 .. v19}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_8

    invoke-interface/range {v19 .. v19}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v16

    check-cast v16, Lco/vine/android/api/VineEntity;

    .line 458
    .local v16, "e":Lco/vine/android/api/VineEntity;
    invoke-virtual/range {v16 .. v16}, Lco/vine/android/api/VineEntity;->isUserType()Z

    move-result v4

    if-eqz v4, :cond_6

    .line 459
    new-instance v10, Lco/vine/android/widget/StyledClickableSpan;

    const/4 v4, 0x1

    move-object/from16 v0, v16

    iget-wide v5, v0, Lco/vine/android/api/VineEntity;->id:J

    invoke-static {v5, v6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/widget/GenericVideoAdapter;->mSpanClickListener:Lco/vine/android/widget/SpanClickListener;

    invoke-direct {v10, v4, v5, v6}, Lco/vine/android/widget/StyledClickableSpan;-><init>(ILjava/lang/Object;Lco/vine/android/widget/SpanClickListener;)V

    .line 461
    .local v10, "click":Lco/vine/android/widget/StyledClickableSpan;
    move-object/from16 v0, p0

    iget v4, v0, Lco/vine/android/widget/GenericVideoAdapter;->mProfileColor:I

    invoke-virtual {v10, v4}, Lco/vine/android/widget/StyledClickableSpan;->setColor(I)V

    .line 462
    move-object/from16 v0, v16

    iget v4, v0, Lco/vine/android/api/VineEntity;->start:I

    move-object/from16 v0, v16

    iget v5, v0, Lco/vine/android/api/VineEntity;->end:I

    const/16 v6, 0x21

    move-object/from16 v0, v28

    invoke-static {v0, v10, v4, v5, v6}, Lco/vine/android/util/Util;->safeSetSpan(Landroid/text/Spannable;Ljava/lang/Object;III)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    goto :goto_6

    .line 471
    .end local v10    # "click":Lco/vine/android/widget/StyledClickableSpan;
    .end local v16    # "e":Lco/vine/android/api/VineEntity;
    .end local v19    # "i$":Ljava/util/Iterator;
    :catch_1
    move-exception v16

    .line 472
    .local v16, "e":Ljava/lang/Exception;
    invoke-static {}, Lco/vine/android/util/BuildUtil;->isLogsOn()Z

    move-result v4

    if-eqz v4, :cond_7

    .line 473
    new-instance v4, Ljava/lang/RuntimeException;

    move-object/from16 v0, v16

    invoke-direct {v4, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v4

    .line 463
    .local v16, "e":Lco/vine/android/api/VineEntity;
    .restart local v19    # "i$":Ljava/util/Iterator;
    :cond_6
    :try_start_2
    invoke-virtual/range {v16 .. v16}, Lco/vine/android/api/VineEntity;->isTagType()Z

    move-result v4

    if-eqz v4, :cond_5

    .line 464
    new-instance v10, Lco/vine/android/widget/StyledClickableSpan;

    const/4 v4, 0x4

    move-object/from16 v0, v16

    iget-object v5, v0, Lco/vine/android/api/VineEntity;->title:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/widget/GenericVideoAdapter;->mSpanClickListener:Lco/vine/android/widget/SpanClickListener;

    invoke-direct {v10, v4, v5, v6}, Lco/vine/android/widget/StyledClickableSpan;-><init>(ILjava/lang/Object;Lco/vine/android/widget/SpanClickListener;)V

    .line 466
    .restart local v10    # "click":Lco/vine/android/widget/StyledClickableSpan;
    move-object/from16 v0, p0

    iget v4, v0, Lco/vine/android/widget/GenericVideoAdapter;->mProfileColor:I

    invoke-virtual {v10, v4}, Lco/vine/android/widget/StyledClickableSpan;->setColor(I)V

    .line 467
    move-object/from16 v0, v16

    iget v4, v0, Lco/vine/android/api/VineEntity;->start:I

    move-object/from16 v0, v16

    iget v5, v0, Lco/vine/android/api/VineEntity;->end:I

    const/16 v6, 0x21

    move-object/from16 v0, v28

    invoke-static {v0, v10, v4, v5, v6}, Lco/vine/android/util/Util;->safeSetSpan(Landroid/text/Spannable;Ljava/lang/Object;III)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1

    goto :goto_6

    .line 475
    .end local v10    # "click":Lco/vine/android/widget/StyledClickableSpan;
    .end local v19    # "i$":Ljava/util/Iterator;
    .local v16, "e":Ljava/lang/Exception;
    :cond_7
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Failed to adjust entities on "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-wide v5, v12, Lco/vine/android/api/VineComment;->commentId:J

    invoke-virtual {v4, v5, v6}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/Object;

    move-object/from16 v0, v16

    invoke-static {v0, v4, v5}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 479
    .end local v3    # "timestampSpan":Landroid/text/style/TextAppearanceSpan;
    .end local v7    # "color":Landroid/content/res/ColorStateList;
    .end local v9    # "boldSpan":Lco/vine/android/widget/TypefacesSpan;
    .end local v16    # "e":Ljava/lang/Exception;
    .end local v17    # "entities":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineEntity;>;"
    .end local v22    # "relativeTimeString":Ljava/lang/String;
    .end local v25    # "span":Lco/vine/android/widget/StyledClickableSpan;
    .end local v28    # "thisCommentSb":Landroid/text/SpannableStringBuilder;
    .end local v29    # "timestampEnd":I
    .end local v30    # "timestampStart":I
    .end local v31    # "usernameEnd":I
    .end local v32    # "usernameStart":I
    :cond_8
    invoke-static {}, Landroid/text/method/LinkMovementMethod;->getInstance()Landroid/text/method/MovementMethod;

    move-result-object v4

    move-object/from16 v0, v27

    invoke-virtual {v0, v4}, Landroid/widget/TextView;->setMovementMethod(Landroid/text/method/MovementMethod;)V

    .line 480
    iget-object v4, v12, Lco/vine/android/api/VineComment;->commentSb:Landroid/text/SpannableStringBuilder;

    move-object/from16 v0, v27

    invoke-virtual {v0, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_5

    .line 391
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method protected setStyledCompactLikesComments(Lco/vine/android/widget/GenericFeedViewHolder;)V
    .locals 23
    .param p1, "h"    # Lco/vine/android/widget/GenericFeedViewHolder;

    .prologue
    .line 485
    .local p0, "this":Lco/vine/android/widget/GenericVideoAdapter;, "Lco/vine/android/widget/GenericVideoAdapter<TT;>;"
    move-object/from16 v0, p1

    iget-object v2, v0, Lco/vine/android/widget/GenericFeedViewHolder;->post:Lco/vine/android/api/VinePost;

    iget v13, v2, Lco/vine/android/api/VinePost;->likesCount:I

    .line 486
    .local v13, "likeCount":I
    move-object/from16 v0, p1

    iget-object v2, v0, Lco/vine/android/widget/GenericFeedViewHolder;->post:Lco/vine/android/api/VinePost;

    iget v10, v2, Lco/vine/android/api/VinePost;->commentsCount:I

    .line 487
    .local v10, "commentCount":I
    move-object/from16 v0, p1

    iget-object v2, v0, Lco/vine/android/widget/GenericFeedViewHolder;->post:Lco/vine/android/api/VinePost;

    iget v0, v2, Lco/vine/android/api/VinePost;->revinersCount:I

    move/from16 v18, v0

    .line 488
    .local v18, "revinersCount":I
    move-object/from16 v0, p1

    iget-object v2, v0, Lco/vine/android/widget/GenericFeedViewHolder;->post:Lco/vine/android/api/VinePost;

    iget-object v2, v2, Lco/vine/android/api/VinePost;->comments:Lco/vine/android/api/VinePagedData;

    if-eqz v2, :cond_5

    const/16 v20, 0x1

    .line 490
    .local v20, "showCommentsText":Z
    :goto_0
    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/widget/GenericVideoAdapter;->mContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v17

    .line 491
    .local v17, "res":Landroid/content/res/Resources;
    new-instance v19, Landroid/text/SpannableStringBuilder;

    invoke-direct/range {v19 .. v19}, Landroid/text/SpannableStringBuilder;-><init>()V

    .line 494
    .local v19, "sb":Landroid/text/SpannableStringBuilder;
    if-lez v13, :cond_0

    .line 495
    int-to-long v2, v13

    move-object/from16 v0, v17

    invoke-static {v0, v2, v3}, Lco/vine/android/util/Util;->numberFormat(Landroid/content/res/Resources;J)Ljava/lang/String;

    move-result-object v16

    .line 496
    .local v16, "numberLikesString":Ljava/lang/String;
    const v2, 0x7f0d0017

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object v16, v3, v4

    move-object/from16 v0, v17

    invoke-virtual {v0, v2, v13, v3}, Landroid/content/res/Resources;->getQuantityString(II[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    move-object/from16 v0, v19

    invoke-virtual {v0, v2}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 498
    new-instance v9, Lco/vine/android/widget/StyledClickableSpan;

    const/4 v2, 0x2

    move-object/from16 v0, p1

    iget-object v3, v0, Lco/vine/android/widget/GenericFeedViewHolder;->post:Lco/vine/android/api/VinePost;

    iget-wide v3, v3, Lco/vine/android/api/VinePost;->postId:J

    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    move-object/from16 v0, p0

    iget-object v4, v0, Lco/vine/android/widget/GenericVideoAdapter;->mSpanClickListener:Lco/vine/android/widget/SpanClickListener;

    invoke-direct {v9, v2, v3, v4}, Lco/vine/android/widget/StyledClickableSpan;-><init>(ILjava/lang/Object;Lco/vine/android/widget/SpanClickListener;)V

    .line 500
    .local v9, "clickableSpan":Lco/vine/android/widget/StyledClickableSpan;
    move-object/from16 v0, p0

    iget v2, v0, Lco/vine/android/widget/GenericVideoAdapter;->mVineGray:I

    invoke-virtual {v9, v2}, Lco/vine/android/widget/StyledClickableSpan;->setColor(I)V

    .line 501
    const/16 v21, 0x0

    .line 502
    .local v21, "start":I
    invoke-virtual/range {v19 .. v19}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v11

    .line 503
    .local v11, "end":I
    const/4 v2, 0x0

    const/16 v3, 0x21

    move-object/from16 v0, v19

    invoke-static {v0, v9, v2, v11, v3}, Lco/vine/android/util/Util;->safeSetSpan(Landroid/text/Spannable;Ljava/lang/Object;III)V

    .line 507
    .end local v9    # "clickableSpan":Lco/vine/android/widget/StyledClickableSpan;
    .end local v11    # "end":I
    .end local v16    # "numberLikesString":Ljava/lang/String;
    .end local v21    # "start":I
    :cond_0
    if-lez v10, :cond_2

    if-eqz v20, :cond_2

    .line 508
    invoke-virtual/range {v19 .. v19}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v2

    if-lez v2, :cond_1

    .line 509
    const/16 v2, 0x20

    move-object/from16 v0, v19

    invoke-virtual {v0, v2}, Landroid/text/SpannableStringBuilder;->append(C)Landroid/text/SpannableStringBuilder;

    move-result-object v2

    const/16 v3, 0xb7

    invoke-virtual {v2, v3}, Landroid/text/SpannableStringBuilder;->append(C)Landroid/text/SpannableStringBuilder;

    move-result-object v2

    const/16 v3, 0x20

    invoke-virtual {v2, v3}, Landroid/text/SpannableStringBuilder;->append(C)Landroid/text/SpannableStringBuilder;

    .line 512
    :cond_1
    int-to-long v2, v10

    move-object/from16 v0, v17

    invoke-static {v0, v2, v3}, Lco/vine/android/util/Util;->numberFormat(Landroid/content/res/Resources;J)Ljava/lang/String;

    move-result-object v15

    .line 513
    .local v15, "numberCommentsString":Ljava/lang/String;
    const v2, 0x7f0d0016

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object v15, v3, v4

    move-object/from16 v0, v17

    invoke-virtual {v0, v2, v10, v3}, Landroid/content/res/Resources;->getQuantityString(II[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    move-object/from16 v0, v19

    invoke-virtual {v0, v2}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 515
    new-instance v9, Lco/vine/android/widget/StyledClickableSpan;

    const/16 v22, 0x3

    new-instance v2, Lco/vine/android/widget/GenericVideoAdapter$SpanCommentObjectTag;

    move-object/from16 v0, p1

    iget-object v3, v0, Lco/vine/android/widget/GenericFeedViewHolder;->post:Lco/vine/android/api/VinePost;

    iget-wide v4, v3, Lco/vine/android/api/VinePost;->postId:J

    move-object/from16 v0, p1

    iget-object v3, v0, Lco/vine/android/widget/GenericFeedViewHolder;->post:Lco/vine/android/api/VinePost;

    iget-wide v6, v3, Lco/vine/android/api/VinePost;->userId:J

    move-object/from16 v3, p0

    invoke-direct/range {v2 .. v7}, Lco/vine/android/widget/GenericVideoAdapter$SpanCommentObjectTag;-><init>(Lco/vine/android/widget/GenericVideoAdapter;JJ)V

    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/widget/GenericVideoAdapter;->mSpanClickListener:Lco/vine/android/widget/SpanClickListener;

    move/from16 v0, v22

    invoke-direct {v9, v0, v2, v3}, Lco/vine/android/widget/StyledClickableSpan;-><init>(ILjava/lang/Object;Lco/vine/android/widget/SpanClickListener;)V

    .line 517
    .restart local v9    # "clickableSpan":Lco/vine/android/widget/StyledClickableSpan;
    move-object/from16 v0, p0

    iget v2, v0, Lco/vine/android/widget/GenericVideoAdapter;->mVineGray:I

    invoke-virtual {v9, v2}, Lco/vine/android/widget/StyledClickableSpan;->setColor(I)V

    .line 518
    invoke-virtual/range {v19 .. v19}, Landroid/text/SpannableStringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const/16 v3, 0xb7

    invoke-virtual {v2, v3}, Ljava/lang/String;->indexOf(I)I

    move-result v12

    .line 519
    .local v12, "interpunctIndex":I
    if-gez v12, :cond_6

    const/16 v21, 0x0

    .line 520
    .restart local v21    # "start":I
    :goto_1
    invoke-virtual/range {v19 .. v19}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v11

    .line 521
    .restart local v11    # "end":I
    const/16 v2, 0x21

    move-object/from16 v0, v19

    move/from16 v1, v21

    invoke-static {v0, v9, v1, v11, v2}, Lco/vine/android/util/Util;->safeSetSpan(Landroid/text/Spannable;Ljava/lang/Object;III)V

    .line 525
    .end local v9    # "clickableSpan":Lco/vine/android/widget/StyledClickableSpan;
    .end local v11    # "end":I
    .end local v12    # "interpunctIndex":I
    .end local v15    # "numberCommentsString":Ljava/lang/String;
    .end local v21    # "start":I
    :cond_2
    if-lez v18, :cond_4

    .line 526
    invoke-virtual/range {v19 .. v19}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v2

    if-lez v2, :cond_3

    .line 527
    const/16 v2, 0x20

    move-object/from16 v0, v19

    invoke-virtual {v0, v2}, Landroid/text/SpannableStringBuilder;->append(C)Landroid/text/SpannableStringBuilder;

    move-result-object v2

    const/16 v3, 0xb7

    invoke-virtual {v2, v3}, Landroid/text/SpannableStringBuilder;->append(C)Landroid/text/SpannableStringBuilder;

    move-result-object v2

    const/16 v3, 0x20

    invoke-virtual {v2, v3}, Landroid/text/SpannableStringBuilder;->append(C)Landroid/text/SpannableStringBuilder;

    .line 529
    :cond_3
    move/from16 v0, v18

    int-to-long v2, v0

    move-object/from16 v0, v17

    invoke-static {v0, v2, v3}, Lco/vine/android/util/Util;->numberFormat(Landroid/content/res/Resources;J)Ljava/lang/String;

    move-result-object v14

    .line 530
    .local v14, "numRevinersString":Ljava/lang/String;
    const v2, 0x7f0d0006

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object v14, v3, v4

    move-object/from16 v0, v17

    move/from16 v1, v18

    invoke-virtual {v0, v2, v1, v3}, Landroid/content/res/Resources;->getQuantityString(II[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    move-object/from16 v0, v19

    invoke-virtual {v0, v2}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 532
    new-instance v9, Lco/vine/android/widget/StyledClickableSpan;

    const/16 v22, 0x7

    new-instance v2, Lco/vine/android/widget/GenericVideoAdapter$SpanCommentObjectTag;

    move-object/from16 v0, p1

    iget-object v3, v0, Lco/vine/android/widget/GenericFeedViewHolder;->post:Lco/vine/android/api/VinePost;

    iget-wide v4, v3, Lco/vine/android/api/VinePost;->postId:J

    move-object/from16 v0, p1

    iget-object v3, v0, Lco/vine/android/widget/GenericFeedViewHolder;->post:Lco/vine/android/api/VinePost;

    iget-wide v6, v3, Lco/vine/android/api/VinePost;->userId:J

    move-object/from16 v3, p0

    invoke-direct/range {v2 .. v7}, Lco/vine/android/widget/GenericVideoAdapter$SpanCommentObjectTag;-><init>(Lco/vine/android/widget/GenericVideoAdapter;JJ)V

    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/widget/GenericVideoAdapter;->mSpanClickListener:Lco/vine/android/widget/SpanClickListener;

    move/from16 v0, v22

    invoke-direct {v9, v0, v2, v3}, Lco/vine/android/widget/StyledClickableSpan;-><init>(ILjava/lang/Object;Lco/vine/android/widget/SpanClickListener;)V

    .line 534
    .restart local v9    # "clickableSpan":Lco/vine/android/widget/StyledClickableSpan;
    move-object/from16 v0, p0

    iget v2, v0, Lco/vine/android/widget/GenericVideoAdapter;->mVineGray:I

    invoke-virtual {v9, v2}, Lco/vine/android/widget/StyledClickableSpan;->setColor(I)V

    .line 535
    invoke-virtual/range {v19 .. v19}, Landroid/text/SpannableStringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const/16 v3, 0xb7

    invoke-virtual {v2, v3}, Ljava/lang/String;->lastIndexOf(I)I

    move-result v12

    .line 536
    .restart local v12    # "interpunctIndex":I
    if-gez v12, :cond_7

    const/16 v21, 0x0

    .line 537
    .restart local v21    # "start":I
    :goto_2
    invoke-virtual/range {v19 .. v19}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v11

    .line 538
    .restart local v11    # "end":I
    const/16 v2, 0x21

    move-object/from16 v0, v19

    move/from16 v1, v21

    invoke-static {v0, v9, v1, v11, v2}, Lco/vine/android/util/Util;->safeSetSpan(Landroid/text/Spannable;Ljava/lang/Object;III)V

    .line 541
    .end local v9    # "clickableSpan":Lco/vine/android/widget/StyledClickableSpan;
    .end local v11    # "end":I
    .end local v12    # "interpunctIndex":I
    .end local v14    # "numRevinersString":Ljava/lang/String;
    .end local v21    # "start":I
    :cond_4
    invoke-virtual/range {v19 .. v19}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v2

    if-lez v2, :cond_8

    .line 542
    new-instance v8, Lco/vine/android/widget/TypefacesSpan;

    const/4 v2, 0x0

    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/widget/GenericVideoAdapter;->mContext:Landroid/content/Context;

    invoke-static {v3}, Lco/vine/android/widget/Typefaces;->get(Landroid/content/Context;)Lco/vine/android/widget/Typefaces;

    move-result-object v3

    const/4 v4, 0x0

    const/4 v5, 0x2

    invoke-virtual {v3, v4, v5}, Lco/vine/android/widget/Typefaces;->getContentTypeface(II)Landroid/graphics/Typeface;

    move-result-object v3

    invoke-direct {v8, v2, v3}, Lco/vine/android/widget/TypefacesSpan;-><init>(Ljava/lang/String;Landroid/graphics/Typeface;)V

    .line 544
    .local v8, "boldSpan":Lco/vine/android/widget/TypefacesSpan;
    const/4 v2, 0x0

    invoke-virtual/range {v19 .. v19}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v3

    const/16 v4, 0x21

    move-object/from16 v0, v19

    invoke-static {v0, v8, v2, v3, v4}, Lco/vine/android/util/Util;->safeSetSpan(Landroid/text/Spannable;Ljava/lang/Object;III)V

    .line 545
    move-object/from16 v0, p1

    iget-object v2, v0, Lco/vine/android/widget/GenericFeedViewHolder;->compactLikesCommentsRevinesCounts:Landroid/widget/TextView;

    invoke-static {}, Landroid/text/method/LinkMovementMethod;->getInstance()Landroid/text/method/MovementMethod;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setMovementMethod(Landroid/text/method/MovementMethod;)V

    .line 546
    move-object/from16 v0, p1

    iget-object v2, v0, Lco/vine/android/widget/GenericFeedViewHolder;->compactLikesCommentsRevinesCounts:Landroid/widget/TextView;

    move-object/from16 v0, v19

    invoke-virtual {v2, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 551
    .end local v8    # "boldSpan":Lco/vine/android/widget/TypefacesSpan;
    :goto_3
    move-object/from16 v0, p1

    iget-object v2, v0, Lco/vine/android/widget/GenericFeedViewHolder;->compactLikesCommentsRevinesCounts:Landroid/widget/TextView;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setVisibility(I)V

    .line 552
    return-void

    .line 488
    .end local v17    # "res":Landroid/content/res/Resources;
    .end local v19    # "sb":Landroid/text/SpannableStringBuilder;
    .end local v20    # "showCommentsText":Z
    :cond_5
    const/16 v20, 0x0

    goto/16 :goto_0

    .line 519
    .restart local v9    # "clickableSpan":Lco/vine/android/widget/StyledClickableSpan;
    .restart local v12    # "interpunctIndex":I
    .restart local v15    # "numberCommentsString":Ljava/lang/String;
    .restart local v17    # "res":Landroid/content/res/Resources;
    .restart local v19    # "sb":Landroid/text/SpannableStringBuilder;
    .restart local v20    # "showCommentsText":Z
    :cond_6
    add-int/lit8 v21, v12, 0x2

    goto/16 :goto_1

    .line 536
    .end local v15    # "numberCommentsString":Ljava/lang/String;
    .restart local v14    # "numRevinersString":Ljava/lang/String;
    :cond_7
    add-int/lit8 v21, v12, 0x2

    goto :goto_2

    .line 548
    .end local v9    # "clickableSpan":Lco/vine/android/widget/StyledClickableSpan;
    .end local v12    # "interpunctIndex":I
    .end local v14    # "numRevinersString":Ljava/lang/String;
    :cond_8
    move-object/from16 v0, p1

    iget-object v2, v0, Lco/vine/android/widget/GenericFeedViewHolder;->compactLikesCommentsRevinesCounts:Landroid/widget/TextView;

    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/widget/GenericVideoAdapter;->mContext:Landroid/content/Context;

    const v4, 0x7f0e00fa

    invoke-virtual {v3, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_3
.end method

.method protected setUserImage(Landroid/widget/ImageView;Landroid/graphics/Bitmap;)Z
    .locals 2
    .param p1, "imageView"    # Landroid/widget/ImageView;
    .param p2, "bitmap"    # Landroid/graphics/Bitmap;

    .prologue
    .local p0, "this":Lco/vine/android/widget/GenericVideoAdapter;, "Lco/vine/android/widget/GenericVideoAdapter<TT;>;"
    const/4 v0, 0x0

    .line 569
    const/4 v1, 0x0

    invoke-virtual {p1, v1}, Landroid/widget/ImageView;->setColorFilter(Landroid/graphics/ColorFilter;)V

    .line 570
    if-nez p2, :cond_0

    .line 571
    const v1, 0x7f0200f7

    invoke-virtual {p1, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 576
    :goto_0
    return v0

    .line 574
    :cond_0
    invoke-virtual {p1, v0}, Landroid/widget/ImageView;->setBackgroundColor(I)V

    .line 575
    new-instance v0, Lco/vine/android/drawable/RecyclableBitmapDrawable;

    iget-object v1, p0, Lco/vine/android/widget/GenericVideoAdapter;->mContext:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-direct {v0, v1, p2}, Lco/vine/android/drawable/RecyclableBitmapDrawable;-><init>(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V

    invoke-virtual {p1, v0}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 576
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public showLikedByMe(J)V
    .locals 10
    .param p1, "postId"    # J

    .prologue
    .line 183
    .local p0, "this":Lco/vine/android/widget/GenericVideoAdapter;, "Lco/vine/android/widget/GenericVideoAdapter<TT;>;"
    new-instance v7, Ljava/util/ArrayList;

    invoke-direct {v7}, Ljava/util/ArrayList;-><init>()V

    .line 184
    .local v7, "toRemove":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/ref/WeakReference<TT;>;>;"
    iget-object v8, p0, Lco/vine/android/widget/GenericVideoAdapter;->mViewHolders:Ljava/util/ArrayList;

    invoke-virtual {v8}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_4

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/ref/WeakReference;

    .line 185
    .local v6, "ref":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<TT;>;"
    invoke-virtual {v6}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lco/vine/android/widget/GenericFeedViewHolder;

    .line 186
    .local v2, "holder":Lco/vine/android/widget/GenericFeedViewHolder;
    if-nez v2, :cond_1

    .line 187
    invoke-virtual {v7, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 189
    :cond_1
    iget-object v8, v2, Lco/vine/android/widget/GenericFeedViewHolder;->post:Lco/vine/android/api/VinePost;

    if-eqz v8, :cond_0

    iget-object v8, v2, Lco/vine/android/widget/GenericFeedViewHolder;->post:Lco/vine/android/api/VinePost;

    iget-wide v8, v8, Lco/vine/android/api/VinePost;->postId:J

    cmp-long v8, v8, p1

    if-nez v8, :cond_0

    .line 190
    iget-object v8, v2, Lco/vine/android/widget/GenericFeedViewHolder;->post:Lco/vine/android/api/VinePost;

    iget v9, v8, Lco/vine/android/api/VinePost;->likesCount:I

    add-int/lit8 v9, v9, 0x1

    iput v9, v8, Lco/vine/android/api/VinePost;->likesCount:I

    .line 191
    iget-object v8, v2, Lco/vine/android/widget/GenericFeedViewHolder;->post:Lco/vine/android/api/VinePost;

    iget-object v4, v8, Lco/vine/android/api/VinePost;->likes:Lco/vine/android/api/VinePagedData;

    .line 192
    .local v4, "likes":Lco/vine/android/api/VinePagedData;, "Lco/vine/android/api/VinePagedData<Lco/vine/android/api/VineLike;>;"
    new-instance v5, Lco/vine/android/api/VineLike;

    invoke-direct {v5}, Lco/vine/android/api/VineLike;-><init>()V

    .line 193
    .local v5, "newL":Lco/vine/android/api/VineLike;
    iget-object v8, p0, Lco/vine/android/widget/GenericVideoAdapter;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v8}, Lco/vine/android/client/AppController;->getActiveSession()Lco/vine/android/client/Session;

    move-result-object v0

    .line 194
    .local v0, "currentSession":Lco/vine/android/client/Session;
    const-wide/16 v8, -0x1

    iput-wide v8, v5, Lco/vine/android/api/VineLike;->likeId:J

    .line 195
    iput-wide p1, v5, Lco/vine/android/api/VineLike;->postId:J

    .line 196
    invoke-virtual {v0}, Lco/vine/android/client/Session;->getName()Ljava/lang/String;

    move-result-object v8

    iput-object v8, v5, Lco/vine/android/api/VineLike;->username:Ljava/lang/String;

    .line 197
    invoke-virtual {v0}, Lco/vine/android/client/Session;->getUserId()J

    move-result-wide v8

    iput-wide v8, v5, Lco/vine/android/api/VineLike;->userId:J

    .line 198
    if-nez v4, :cond_2

    .line 199
    new-instance v4, Lco/vine/android/api/VinePagedData;

    .end local v4    # "likes":Lco/vine/android/api/VinePagedData;, "Lco/vine/android/api/VinePagedData<Lco/vine/android/api/VineLike;>;"
    invoke-direct {v4}, Lco/vine/android/api/VinePagedData;-><init>()V

    .line 201
    .restart local v4    # "likes":Lco/vine/android/api/VinePagedData;, "Lco/vine/android/api/VinePagedData<Lco/vine/android/api/VineLike;>;"
    :cond_2
    iget-object v8, v4, Lco/vine/android/api/VinePagedData;->items:Ljava/util/ArrayList;

    if-nez v8, :cond_3

    .line 202
    new-instance v8, Ljava/util/ArrayList;

    invoke-direct {v8}, Ljava/util/ArrayList;-><init>()V

    iput-object v8, v4, Lco/vine/android/api/VinePagedData;->items:Ljava/util/ArrayList;

    .line 204
    :cond_3
    iget-object v8, v4, Lco/vine/android/api/VinePagedData;->items:Ljava/util/ArrayList;

    invoke-virtual {v8, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 205
    iget-object v8, v2, Lco/vine/android/widget/GenericFeedViewHolder;->liked:Lco/vine/android/widget/ColorizedCircleButton;

    const/4 v9, 0x1

    invoke-virtual {v8, v9}, Lco/vine/android/widget/ColorizedCircleButton;->setSelected(Z)V

    .line 206
    invoke-virtual {p0, v2}, Lco/vine/android/widget/GenericVideoAdapter;->setStyledCompactLikesComments(Lco/vine/android/widget/GenericFeedViewHolder;)V

    goto :goto_0

    .line 211
    .end local v0    # "currentSession":Lco/vine/android/client/Session;
    .end local v2    # "holder":Lco/vine/android/widget/GenericFeedViewHolder;
    .end local v4    # "likes":Lco/vine/android/api/VinePagedData;, "Lco/vine/android/api/VinePagedData<Lco/vine/android/api/VineLike;>;"
    .end local v5    # "newL":Lco/vine/android/api/VineLike;
    .end local v6    # "ref":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<TT;>;"
    :cond_4
    invoke-virtual {v7}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_1
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_5

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/ref/WeakReference;

    .line 212
    .local v1, "h":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<TT;>;"
    iget-object v8, p0, Lco/vine/android/widget/GenericVideoAdapter;->mViewHolders:Ljava/util/ArrayList;

    invoke-virtual {v8, v1}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    goto :goto_1

    .line 214
    .end local v1    # "h":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<TT;>;"
    :cond_5
    return-void
.end method

.method public showUnlikedByMe(J)V
    .locals 13
    .param p1, "postId"    # J

    .prologue
    .line 147
    .local p0, "this":Lco/vine/android/widget/GenericVideoAdapter;, "Lco/vine/android/widget/GenericVideoAdapter<TT;>;"
    new-instance v8, Ljava/util/ArrayList;

    invoke-direct {v8}, Ljava/util/ArrayList;-><init>()V

    .line 148
    .local v8, "toRemove":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/ref/WeakReference<TT;>;>;"
    iget-object v9, p0, Lco/vine/android/widget/GenericVideoAdapter;->mViewHolders:Ljava/util/ArrayList;

    invoke-virtual {v9}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_0
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v9

    if-eqz v9, :cond_6

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/lang/ref/WeakReference;

    .line 149
    .local v7, "ref":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<TT;>;"
    invoke-virtual {v7}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lco/vine/android/widget/GenericFeedViewHolder;

    .line 150
    .local v1, "holder":Lco/vine/android/widget/GenericFeedViewHolder;, "TT;"
    if-nez v1, :cond_1

    .line 151
    invoke-virtual {v8, v7}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 153
    :cond_1
    iget-object v9, v1, Lco/vine/android/widget/GenericFeedViewHolder;->post:Lco/vine/android/api/VinePost;

    if-eqz v9, :cond_0

    iget-object v9, v1, Lco/vine/android/widget/GenericFeedViewHolder;->post:Lco/vine/android/api/VinePost;

    iget-wide v9, v9, Lco/vine/android/api/VinePost;->postId:J

    cmp-long v9, v9, p1

    if-nez v9, :cond_0

    .line 154
    iget-object v9, v1, Lco/vine/android/widget/GenericFeedViewHolder;->post:Lco/vine/android/api/VinePost;

    iget v9, v9, Lco/vine/android/api/VinePost;->likesCount:I

    if-lez v9, :cond_2

    .line 155
    iget-object v9, v1, Lco/vine/android/widget/GenericFeedViewHolder;->post:Lco/vine/android/api/VinePost;

    iget v10, v9, Lco/vine/android/api/VinePost;->likesCount:I

    add-int/lit8 v10, v10, -0x1

    iput v10, v9, Lco/vine/android/api/VinePost;->likesCount:I

    .line 158
    :cond_2
    iget-object v9, v1, Lco/vine/android/widget/GenericFeedViewHolder;->post:Lco/vine/android/api/VinePost;

    iget-object v9, v9, Lco/vine/android/api/VinePost;->likes:Lco/vine/android/api/VinePagedData;

    if-eqz v9, :cond_5

    iget-object v9, v1, Lco/vine/android/widget/GenericFeedViewHolder;->post:Lco/vine/android/api/VinePost;

    iget-object v9, v9, Lco/vine/android/api/VinePost;->likes:Lco/vine/android/api/VinePagedData;

    iget-object v9, v9, Lco/vine/android/api/VinePagedData;->items:Ljava/util/ArrayList;

    if-eqz v9, :cond_5

    .line 159
    iget-object v9, v1, Lco/vine/android/widget/GenericFeedViewHolder;->post:Lco/vine/android/api/VinePost;

    iget-object v9, v9, Lco/vine/android/api/VinePost;->likes:Lco/vine/android/api/VinePagedData;

    iget-object v6, v9, Lco/vine/android/api/VinePagedData;->items:Ljava/util/ArrayList;

    .line 160
    .local v6, "likes":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineLike;>;"
    const/4 v5, 0x0

    .line 161
    .local v5, "likeToRemove":Lco/vine/android/api/VineLike;
    invoke-virtual {v6}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, "i$":Ljava/util/Iterator;
    :cond_3
    :goto_1
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v9

    if-eqz v9, :cond_4

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/api/VineLike;

    .line 162
    .local v4, "l":Lco/vine/android/api/VineLike;
    iget-wide v9, v4, Lco/vine/android/api/VineLike;->userId:J

    iget-object v11, p0, Lco/vine/android/widget/GenericVideoAdapter;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v11}, Lco/vine/android/client/AppController;->getActiveId()J

    move-result-wide v11

    cmp-long v9, v9, v11

    if-nez v9, :cond_3

    .line 163
    move-object v5, v4

    goto :goto_1

    .line 166
    .end local v4    # "l":Lco/vine/android/api/VineLike;
    :cond_4
    if-eqz v5, :cond_5

    .line 167
    invoke-virtual {v6, v5}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    .line 170
    .end local v3    # "i$":Ljava/util/Iterator;
    .end local v5    # "likeToRemove":Lco/vine/android/api/VineLike;
    .end local v6    # "likes":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineLike;>;"
    :cond_5
    iget-object v9, v1, Lco/vine/android/widget/GenericFeedViewHolder;->liked:Lco/vine/android/widget/ColorizedCircleButton;

    const/4 v10, 0x0

    invoke-virtual {v9, v10}, Lco/vine/android/widget/ColorizedCircleButton;->setSelected(Z)V

    .line 172
    invoke-virtual {p0, v1}, Lco/vine/android/widget/GenericVideoAdapter;->setStyledCompactLikesComments(Lco/vine/android/widget/GenericFeedViewHolder;)V

    goto :goto_0

    .line 177
    .end local v1    # "holder":Lco/vine/android/widget/GenericFeedViewHolder;, "TT;"
    .end local v7    # "ref":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<TT;>;"
    :cond_6
    invoke-virtual {v8}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :goto_2
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v9

    if-eqz v9, :cond_7

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/ref/WeakReference;

    .line 178
    .local v0, "h":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<TT;>;"
    iget-object v9, p0, Lco/vine/android/widget/GenericVideoAdapter;->mViewHolders:Ljava/util/ArrayList;

    invoke-virtual {v9, v0}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    goto :goto_2

    .line 180
    .end local v0    # "h":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<TT;>;"
    :cond_7
    return-void
.end method

.method public startLoadingTimeProfiling(Ljava/lang/String;)V
    .locals 2
    .param p1, "tag"    # Ljava/lang/String;

    .prologue
    .line 227
    .local p0, "this":Lco/vine/android/widget/GenericVideoAdapter;, "Lco/vine/android/widget/GenericVideoAdapter<TT;>;"
    iput-object p1, p0, Lco/vine/android/widget/GenericVideoAdapter;->mLoadingTimeTag:Ljava/lang/String;

    .line 228
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    iput-wide v0, p0, Lco/vine/android/widget/GenericVideoAdapter;->mStartLoadingTime:J

    .line 229
    return-void
.end method

.method public timeSinceStartLoadingTime()J
    .locals 4

    .prologue
    .line 232
    .local p0, "this":Lco/vine/android/widget/GenericVideoAdapter;, "Lco/vine/android/widget/GenericVideoAdapter<TT;>;"
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    iget-wide v2, p0, Lco/vine/android/widget/GenericVideoAdapter;->mStartLoadingTime:J

    sub-long/2addr v0, v2

    return-wide v0
.end method

.method public toggleMute(Z)V
    .locals 0
    .param p1, "mute"    # Z

    .prologue
    .line 250
    .local p0, "this":Lco/vine/android/widget/GenericVideoAdapter;, "Lco/vine/android/widget/GenericVideoAdapter<TT;>;"
    return-void
.end method

.method public updateRevinedCount(JZ)V
    .locals 8
    .param p1, "postId"    # J
    .param p3, "revined"    # Z

    .prologue
    .line 315
    .local p0, "this":Lco/vine/android/widget/GenericVideoAdapter;, "Lco/vine/android/widget/GenericVideoAdapter<TT;>;"
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    .line 317
    .local v4, "toRemove":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/ref/WeakReference<TT;>;>;"
    iget-object v5, p0, Lco/vine/android/widget/GenericVideoAdapter;->mViewHolders:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_4

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/ref/WeakReference;

    .line 318
    .local v3, "ref":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<TT;>;"
    invoke-virtual {v3}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lco/vine/android/widget/GenericFeedViewHolder;

    .line 319
    .local v1, "holder":Lco/vine/android/widget/GenericFeedViewHolder;
    if-nez v1, :cond_1

    .line 320
    invoke-virtual {v4, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 322
    :cond_1
    iget-object v5, v1, Lco/vine/android/widget/GenericFeedViewHolder;->post:Lco/vine/android/api/VinePost;

    if-eqz v5, :cond_0

    iget-object v5, v1, Lco/vine/android/widget/GenericFeedViewHolder;->post:Lco/vine/android/api/VinePost;

    iget-wide v5, v5, Lco/vine/android/api/VinePost;->postId:J

    cmp-long v5, v5, p1

    if-nez v5, :cond_0

    .line 323
    if-eqz p3, :cond_2

    .line 324
    iget-object v5, v1, Lco/vine/android/widget/GenericFeedViewHolder;->post:Lco/vine/android/api/VinePost;

    iget v6, v5, Lco/vine/android/api/VinePost;->revinersCount:I

    add-int/lit8 v6, v6, 0x1

    iput v6, v5, Lco/vine/android/api/VinePost;->revinersCount:I

    .line 325
    iget-object v5, v1, Lco/vine/android/widget/GenericFeedViewHolder;->share:Lco/vine/android/widget/ColorizedCircleButton;

    const/4 v6, 0x1

    invoke-virtual {v5, v6}, Lco/vine/android/widget/ColorizedCircleButton;->setPressed(Z)V

    .line 332
    :goto_1
    iget-object v5, v1, Lco/vine/android/widget/GenericFeedViewHolder;->share:Lco/vine/android/widget/ColorizedCircleButton;

    iget v6, p0, Lco/vine/android/widget/GenericVideoAdapter;->mProfileColor:I

    sget-object v7, Landroid/graphics/PorterDuff$Mode;->SRC_ATOP:Landroid/graphics/PorterDuff$Mode;

    invoke-virtual {v5, v6, v7}, Lco/vine/android/widget/ColorizedCircleButton;->setColorFilter(ILandroid/graphics/PorterDuff$Mode;)V

    .line 333
    invoke-virtual {p0, v1}, Lco/vine/android/widget/GenericVideoAdapter;->setStyledCompactLikesComments(Lco/vine/android/widget/GenericFeedViewHolder;)V

    goto :goto_0

    .line 327
    :cond_2
    iget-object v5, v1, Lco/vine/android/widget/GenericFeedViewHolder;->post:Lco/vine/android/api/VinePost;

    iget v5, v5, Lco/vine/android/api/VinePost;->revinersCount:I

    if-lez v5, :cond_3

    .line 328
    iget-object v5, v1, Lco/vine/android/widget/GenericFeedViewHolder;->post:Lco/vine/android/api/VinePost;

    iget v6, v5, Lco/vine/android/api/VinePost;->revinersCount:I

    add-int/lit8 v6, v6, -0x1

    iput v6, v5, Lco/vine/android/api/VinePost;->revinersCount:I

    .line 330
    :cond_3
    iget-object v5, v1, Lco/vine/android/widget/GenericFeedViewHolder;->share:Lco/vine/android/widget/ColorizedCircleButton;

    const/4 v6, 0x0

    invoke-virtual {v5, v6}, Lco/vine/android/widget/ColorizedCircleButton;->setPressed(Z)V

    goto :goto_1

    .line 337
    .end local v1    # "holder":Lco/vine/android/widget/GenericFeedViewHolder;
    .end local v3    # "ref":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<TT;>;"
    :cond_4
    invoke-virtual {v4}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_2
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_5

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/ref/WeakReference;

    .line 338
    .local v0, "h":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<TT;>;"
    iget-object v5, p0, Lco/vine/android/widget/GenericVideoAdapter;->mViewHolders:Ljava/util/ArrayList;

    invoke-virtual {v5, v0}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    goto :goto_2

    .line 340
    .end local v0    # "h":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<TT;>;"
    :cond_5
    return-void
.end method
