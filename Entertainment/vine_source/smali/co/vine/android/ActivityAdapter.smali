.class public Lco/vine/android/ActivityAdapter;
.super Landroid/widget/BaseAdapter;
.source "ActivityAdapter.java"

# interfaces
.implements Landroid/widget/SectionIndexer;
.implements Lco/vine/android/widget/PinnedHeaderAdapter;


# static fields
.field private static final BLUR_MULTIPLE:I = 0x2

.field public static final NUM_VIEW_TYPES:I = 0x4

.field private static final SPAN_FLAGS:I = 0x21

.field public static final VIEW_TYPE_ACTIVITY:I = 0x0

.field public static final VIEW_TYPE_FOLLOW_REQUEST:I = 0x2

.field public static final VIEW_TYPE_MILESTONE:I = 0x1

.field public static final VIEW_TYPE_USER_LIST_COUNT:I = 0x3


# instance fields
.field private mAppController:Lco/vine/android/client/AppController;

.field private mAvatarClicker:Landroid/view/View$OnClickListener;

.field private final mBold:Lco/vine/android/widget/TypefacesSpan;

.field private final mContext:Landroid/content/Context;

.field private mFollowRequests:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VineSingleNotification;",
            ">;"
        }
    .end annotation
.end field

.field private final mFollowRequestsString:Ljava/lang/String;

.field private mFriendships:Lco/vine/android/Friendships;

.field private mLastNewIndex:I

.field private final mListView:Landroid/widget/ListView;

.field private mListener:Lco/vine/android/widget/SpanClickListener;

.field private final mNewActivityString:Ljava/lang/String;

.field private mNotifications:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VineEverydayNotification;",
            ">;"
        }
    .end annotation
.end field

.field private final mOlderActivityString:Ljava/lang/String;

.field private final mPinnedHeaderHeight:I

.field private mPinnedHeaderSection:I

.field private mPostClicker:Landroid/view/View$OnClickListener;

.field private final mProfileImageSize:I

.field private mSections:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private mShouldReloadHeaderBecauseDataChanged:Z

.field private final mSpanColor:I

.field private mUserListClicker:Landroid/view/View$OnClickListener;

.field private mViewClickListener:Landroid/view/View$OnClickListener;

.field private mViewHolders:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/ref/WeakReference",
            "<",
            "Lco/vine/android/widget/ActivityViewHolder;",
            ">;>;"
        }
    .end annotation
.end field

.field private final mVineGreen:I


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/widget/ListView;Lco/vine/android/client/AppController;Lco/vine/android/widget/SpanClickListener;Landroid/view/View$OnClickListener;)V
    .locals 6
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "listView"    # Landroid/widget/ListView;
    .param p3, "appController"    # Lco/vine/android/client/AppController;
    .param p4, "listener"    # Lco/vine/android/widget/SpanClickListener;
    .param p5, "viewClickListener"    # Landroid/view/View$OnClickListener;

    .prologue
    const/4 v2, -0x1

    .line 88
    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    .line 77
    new-instance v1, Lco/vine/android/Friendships;

    invoke-direct {v1}, Lco/vine/android/Friendships;-><init>()V

    iput-object v1, p0, Lco/vine/android/ActivityAdapter;->mFriendships:Lco/vine/android/Friendships;

    .line 79
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    iput-object v1, p0, Lco/vine/android/ActivityAdapter;->mNotifications:Ljava/util/ArrayList;

    .line 80
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    iput-object v1, p0, Lco/vine/android/ActivityAdapter;->mFollowRequests:Ljava/util/ArrayList;

    .line 81
    iput v2, p0, Lco/vine/android/ActivityAdapter;->mLastNewIndex:I

    .line 82
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    iput-object v1, p0, Lco/vine/android/ActivityAdapter;->mSections:Ljava/util/ArrayList;

    .line 83
    iput v2, p0, Lco/vine/android/ActivityAdapter;->mPinnedHeaderSection:I

    .line 84
    const/4 v1, 0x0

    iput-boolean v1, p0, Lco/vine/android/ActivityAdapter;->mShouldReloadHeaderBecauseDataChanged:Z

    .line 113
    new-instance v1, Lco/vine/android/ActivityAdapter$1;

    invoke-direct {v1, p0}, Lco/vine/android/ActivityAdapter$1;-><init>(Lco/vine/android/ActivityAdapter;)V

    iput-object v1, p0, Lco/vine/android/ActivityAdapter;->mPostClicker:Landroid/view/View$OnClickListener;

    .line 121
    new-instance v1, Lco/vine/android/ActivityAdapter$2;

    invoke-direct {v1, p0}, Lco/vine/android/ActivityAdapter$2;-><init>(Lco/vine/android/ActivityAdapter;)V

    iput-object v1, p0, Lco/vine/android/ActivityAdapter;->mAvatarClicker:Landroid/view/View$OnClickListener;

    .line 129
    new-instance v1, Lco/vine/android/ActivityAdapter$3;

    invoke-direct {v1, p0}, Lco/vine/android/ActivityAdapter$3;-><init>(Lco/vine/android/ActivityAdapter;)V

    iput-object v1, p0, Lco/vine/android/ActivityAdapter;->mUserListClicker:Landroid/view/View$OnClickListener;

    .line 89
    iput-object p2, p0, Lco/vine/android/ActivityAdapter;->mListView:Landroid/widget/ListView;

    .line 90
    iput-object p3, p0, Lco/vine/android/ActivityAdapter;->mAppController:Lco/vine/android/client/AppController;

    .line 91
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    iput-object v1, p0, Lco/vine/android/ActivityAdapter;->mViewHolders:Ljava/util/ArrayList;

    .line 92
    iput-object p4, p0, Lco/vine/android/ActivityAdapter;->mListener:Lco/vine/android/widget/SpanClickListener;

    .line 93
    iput-object p5, p0, Lco/vine/android/ActivityAdapter;->mViewClickListener:Landroid/view/View$OnClickListener;

    .line 94
    iput-object p1, p0, Lco/vine/android/ActivityAdapter;->mContext:Landroid/content/Context;

    .line 96
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    .line 98
    .local v0, "res":Landroid/content/res/Resources;
    const v1, 0x7f0e00fd

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lco/vine/android/ActivityAdapter;->mFollowRequestsString:Ljava/lang/String;

    .line 99
    const v1, 0x7f0e014a

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lco/vine/android/ActivityAdapter;->mNewActivityString:Ljava/lang/String;

    .line 100
    const v1, 0x7f0e0164

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lco/vine/android/ActivityAdapter;->mOlderActivityString:Ljava/lang/String;

    .line 102
    const v1, 0x7f090096

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    iput v1, p0, Lco/vine/android/ActivityAdapter;->mVineGreen:I

    .line 103
    const v1, 0x7f090078

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    iput v1, p0, Lco/vine/android/ActivityAdapter;->mSpanColor:I

    .line 105
    const v1, 0x7f0b0013

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v1

    iput v1, p0, Lco/vine/android/ActivityAdapter;->mPinnedHeaderHeight:I

    .line 107
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0b0087

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDimensionPixelOffset(I)I

    move-result v1

    iput v1, p0, Lco/vine/android/ActivityAdapter;->mProfileImageSize:I

    .line 109
    new-instance v1, Lco/vine/android/widget/TypefacesSpan;

    const/4 v2, 0x0

    iget-object v3, p0, Lco/vine/android/ActivityAdapter;->mContext:Landroid/content/Context;

    invoke-static {v3}, Lco/vine/android/widget/Typefaces;->get(Landroid/content/Context;)Lco/vine/android/widget/Typefaces;

    move-result-object v3

    const/4 v4, 0x1

    const/4 v5, 0x4

    invoke-virtual {v3, v4, v5}, Lco/vine/android/widget/Typefaces;->getContentTypeface(II)Landroid/graphics/Typeface;

    move-result-object v3

    invoke-direct {v1, v2, v3}, Lco/vine/android/widget/TypefacesSpan;-><init>(Ljava/lang/String;Landroid/graphics/Typeface;)V

    iput-object v1, p0, Lco/vine/android/ActivityAdapter;->mBold:Lco/vine/android/widget/TypefacesSpan;

    .line 111
    return-void
.end method

.method static synthetic access$000(Lco/vine/android/ActivityAdapter;)Landroid/content/Context;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/ActivityAdapter;

    .prologue
    .line 51
    iget-object v0, p0, Lco/vine/android/ActivityAdapter;->mContext:Landroid/content/Context;

    return-object v0
.end method

.method private bindBodyText(Lco/vine/android/widget/ActivityViewHolder;Lco/vine/android/api/VineNotification;)V
    .locals 19
    .param p1, "h"    # Lco/vine/android/widget/ActivityViewHolder;
    .param p2, "notif"    # Lco/vine/android/api/VineNotification;

    .prologue
    .line 408
    move-object/from16 v0, p2

    iget-object v2, v0, Lco/vine/android/api/VineNotification;->comment:Ljava/lang/String;

    .line 409
    .local v2, "contentLine":Ljava/lang/String;
    new-instance v3, Landroid/text/SpannableStringBuilder;

    invoke-direct {v3, v2}, Landroid/text/SpannableStringBuilder;-><init>(Ljava/lang/CharSequence;)V

    .line 411
    .local v3, "contentSb":Landroid/text/SpannableStringBuilder;
    const/4 v6, 0x0

    .line 412
    .local v6, "entities":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineEntity;>;"
    move-object/from16 v0, p2

    iget-object v13, v0, Lco/vine/android/api/VineNotification;->entities:Ljava/util/ArrayList;

    if-eqz v13, :cond_0

    .line 414
    new-instance v6, Ljava/util/ArrayList;

    .end local v6    # "entities":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineEntity;>;"
    move-object/from16 v0, p2

    iget-object v13, v0, Lco/vine/android/api/VineNotification;->entities:Ljava/util/ArrayList;

    invoke-virtual {v13}, Ljava/util/ArrayList;->size()I

    move-result v13

    invoke-direct {v6, v13}, Ljava/util/ArrayList;-><init>(I)V

    .line 415
    .restart local v6    # "entities":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineEntity;>;"
    const/4 v8, 0x0

    .local v8, "i":I
    :goto_0
    move-object/from16 v0, p2

    iget-object v13, v0, Lco/vine/android/api/VineNotification;->entities:Ljava/util/ArrayList;

    invoke-virtual {v13}, Ljava/util/ArrayList;->size()I

    move-result v13

    if-ge v8, v13, :cond_0

    .line 416
    new-instance v14, Lco/vine/android/api/VineEntity;

    move-object/from16 v0, p2

    iget-object v13, v0, Lco/vine/android/api/VineNotification;->entities:Ljava/util/ArrayList;

    invoke-virtual {v13, v8}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v13

    check-cast v13, Lco/vine/android/api/VineEntity;

    invoke-direct {v14, v13}, Lco/vine/android/api/VineEntity;-><init>(Lco/vine/android/api/VineEntity;)V

    invoke-virtual {v6, v14}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 415
    add-int/lit8 v8, v8, 0x1

    goto :goto_0

    .line 420
    .end local v8    # "i":I
    :cond_0
    if-eqz v6, :cond_8

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v13

    if-nez v13, :cond_8

    .line 421
    const/4 v13, 0x0

    const/4 v14, 0x1

    invoke-static {v6, v3, v13, v14}, Lco/vine/android/util/Util;->adjustEntities(Ljava/util/ArrayList;Landroid/text/Editable;IZ)V

    .line 423
    move-object/from16 v0, p1

    iget-object v4, v0, Lco/vine/android/widget/ActivityViewHolder;->contentLine:Landroid/widget/TextView;

    .line 425
    .local v4, "contentTv":Landroid/widget/TextView;
    invoke-virtual {v6}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v9

    .local v9, "i$":Ljava/util/Iterator;
    :cond_1
    :goto_1
    invoke-interface {v9}, Ljava/util/Iterator;->hasNext()Z

    move-result v13

    if-eqz v13, :cond_6

    invoke-interface {v9}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lco/vine/android/api/VineEntity;

    .line 426
    .local v7, "entity":Lco/vine/android/api/VineEntity;
    const/4 v12, 0x0

    .line 427
    .local v12, "span":Lco/vine/android/widget/StyledClickableSpan;
    invoke-virtual {v7}, Lco/vine/android/api/VineEntity;->isUserType()Z

    move-result v13

    if-eqz v13, :cond_3

    .line 428
    new-instance v12, Lco/vine/android/widget/StyledClickableSpan;

    .end local v12    # "span":Lco/vine/android/widget/StyledClickableSpan;
    const/4 v13, 0x1

    iget-wide v14, v7, Lco/vine/android/api/VineEntity;->id:J

    invoke-static {v14, v15}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v14

    move-object/from16 v0, p0

    iget-object v15, v0, Lco/vine/android/ActivityAdapter;->mListener:Lco/vine/android/widget/SpanClickListener;

    invoke-direct {v12, v13, v14, v15}, Lco/vine/android/widget/StyledClickableSpan;-><init>(ILjava/lang/Object;Lco/vine/android/widget/SpanClickListener;)V

    .line 443
    .restart local v12    # "span":Lco/vine/android/widget/StyledClickableSpan;
    :cond_2
    :goto_2
    if-eqz v12, :cond_1

    .line 444
    :try_start_0
    move-object/from16 v0, p0

    iget v13, v0, Lco/vine/android/ActivityAdapter;->mSpanColor:I

    invoke-virtual {v12, v13}, Lco/vine/android/widget/StyledClickableSpan;->setColor(I)V

    .line 445
    iget v13, v7, Lco/vine/android/api/VineEntity;->start:I

    iget v14, v7, Lco/vine/android/api/VineEntity;->end:I

    const/16 v15, 0x21

    invoke-static {v3, v12, v13, v14, v15}, Lco/vine/android/util/Util;->safeSetSpan(Landroid/text/Spannable;Ljava/lang/Object;III)V

    .line 446
    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/ActivityAdapter;->mBold:Lco/vine/android/widget/TypefacesSpan;

    iget v14, v7, Lco/vine/android/api/VineEntity;->start:I

    iget v15, v7, Lco/vine/android/api/VineEntity;->end:I

    const/16 v16, 0x21

    move/from16 v0, v16

    invoke-static {v3, v13, v14, v15, v0}, Lco/vine/android/util/Util;->safeSetSpan(Landroid/text/Spannable;Ljava/lang/Object;III)V
    :try_end_0
    .catch Ljava/lang/IndexOutOfBoundsException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    .line 448
    :catch_0
    move-exception v13

    goto :goto_1

    .line 430
    :cond_3
    invoke-virtual {v7}, Lco/vine/android/api/VineEntity;->isTagType()Z

    move-result v13

    if-eqz v13, :cond_4

    .line 431
    new-instance v12, Lco/vine/android/widget/StyledClickableSpan;

    .end local v12    # "span":Lco/vine/android/widget/StyledClickableSpan;
    const/4 v13, 0x3

    iget-object v14, v7, Lco/vine/android/api/VineEntity;->title:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v15, v0, Lco/vine/android/ActivityAdapter;->mListener:Lco/vine/android/widget/SpanClickListener;

    invoke-direct {v12, v13, v14, v15}, Lco/vine/android/widget/StyledClickableSpan;-><init>(ILjava/lang/Object;Lco/vine/android/widget/SpanClickListener;)V

    .restart local v12    # "span":Lco/vine/android/widget/StyledClickableSpan;
    goto :goto_2

    .line 433
    :cond_4
    invoke-virtual {v7}, Lco/vine/android/api/VineEntity;->isUserListType()Z

    move-result v13

    if-eqz v13, :cond_5

    .line 434
    new-instance v12, Lco/vine/android/widget/StyledClickableSpan;

    .end local v12    # "span":Lco/vine/android/widget/StyledClickableSpan;
    const/4 v14, 0x4

    const/4 v13, 0x2

    new-array v15, v13, [Ljava/lang/Object;

    const/4 v13, 0x0

    move-object/from16 v0, p2

    iget-wide v0, v0, Lco/vine/android/api/VineNotification;->notificationId:J

    move-wide/from16 v16, v0

    invoke-static/range {v16 .. v17}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v16

    aput-object v16, v15, v13

    const/16 v16, 0x1

    move-object/from16 v13, p2

    check-cast v13, Lco/vine/android/api/VineEverydayNotification;

    iget-wide v0, v13, Lco/vine/android/api/VineEverydayNotification;->anchor:J

    move-wide/from16 v17, v0

    invoke-static/range {v17 .. v18}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v13

    aput-object v13, v15, v16

    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/ActivityAdapter;->mListener:Lco/vine/android/widget/SpanClickListener;

    invoke-direct {v12, v14, v15, v13}, Lco/vine/android/widget/StyledClickableSpan;-><init>(ILjava/lang/Object;Lco/vine/android/widget/SpanClickListener;)V

    .restart local v12    # "span":Lco/vine/android/widget/StyledClickableSpan;
    goto :goto_2

    .line 437
    :cond_5
    invoke-virtual {v7}, Lco/vine/android/api/VineEntity;->isCommentListType()Z

    move-result v13

    if-eqz v13, :cond_2

    .line 438
    invoke-virtual {v7}, Lco/vine/android/api/VineEntity;->getPostId()J

    move-result-wide v10

    .line 439
    .local v10, "postId":J
    new-instance v12, Lco/vine/android/widget/StyledClickableSpan;

    .end local v12    # "span":Lco/vine/android/widget/StyledClickableSpan;
    const/4 v13, 0x5

    invoke-static {v10, v11}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v14

    move-object/from16 v0, p0

    iget-object v15, v0, Lco/vine/android/ActivityAdapter;->mListener:Lco/vine/android/widget/SpanClickListener;

    invoke-direct {v12, v13, v14, v15}, Lco/vine/android/widget/StyledClickableSpan;-><init>(ILjava/lang/Object;Lco/vine/android/widget/SpanClickListener;)V

    .restart local v12    # "span":Lco/vine/android/widget/StyledClickableSpan;
    goto :goto_2

    .line 453
    .end local v7    # "entity":Lco/vine/android/api/VineEntity;
    .end local v10    # "postId":J
    .end local v12    # "span":Lco/vine/android/widget/StyledClickableSpan;
    :cond_6
    move-object/from16 v0, p1

    iget-object v13, v0, Lco/vine/android/widget/ActivityViewHolder;->dateLine:Landroid/widget/TextView;

    if-eqz v13, :cond_7

    .line 455
    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/ActivityAdapter;->mContext:Landroid/content/Context;

    move-object/from16 v0, p2

    iget-wide v14, v0, Lco/vine/android/api/VineNotification;->createdAt:J

    const/16 v16, 0x1

    invoke-static/range {v13 .. v16}, Lco/vine/android/util/Util;->getRelativeTimeString(Landroid/content/Context;JZ)Ljava/lang/String;

    move-result-object v5

    .line 456
    .local v5, "date":Ljava/lang/String;
    move-object/from16 v0, p1

    iget-object v13, v0, Lco/vine/android/widget/ActivityViewHolder;->dateLine:Landroid/widget/TextView;

    invoke-virtual {v13, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 459
    .end local v5    # "date":Ljava/lang/String;
    :cond_7
    invoke-virtual {v4, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 461
    .end local v4    # "contentTv":Landroid/widget/TextView;
    .end local v9    # "i$":Ljava/util/Iterator;
    :cond_8
    return-void
.end method

.method private bindFollowRequest(Lco/vine/android/widget/ActivityViewHolder;Lco/vine/android/api/VineSingleNotification;)V
    .locals 7
    .param p1, "h"    # Lco/vine/android/widget/ActivityViewHolder;
    .param p2, "notif"    # Lco/vine/android/api/VineSingleNotification;

    .prologue
    const/4 v6, 0x0

    .line 248
    if-nez p1, :cond_0

    .line 249
    new-instance v0, Ljava/lang/RuntimeException;

    const-string v1, "View tag is null."

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 251
    :cond_0
    iget-wide v0, p2, Lco/vine/android/api/VineSingleNotification;->userId:J

    iput-wide v0, p1, Lco/vine/android/widget/ActivityViewHolder;->userId:J

    .line 252
    iput v6, p1, Lco/vine/android/widget/ActivityViewHolder;->listItemClickType:I

    .line 253
    iget-object v2, p1, Lco/vine/android/widget/ActivityViewHolder;->avatar:Landroid/widget/ImageView;

    iget-object v3, p2, Lco/vine/android/api/VineSingleNotification;->avatarUrl:Ljava/lang/String;

    iget-wide v4, p2, Lco/vine/android/api/VineSingleNotification;->userId:J

    move-object v0, p0

    move-object v1, p1

    invoke-direct/range {v0 .. v5}, Lco/vine/android/ActivityAdapter;->setAvatar(Lco/vine/android/widget/ActivityViewHolder;Landroid/widget/ImageView;Ljava/lang/String;J)V

    .line 254
    iget-object v0, p1, Lco/vine/android/widget/ActivityViewHolder;->avatar:Landroid/widget/ImageView;

    iget-wide v1, p2, Lco/vine/android/api/VineSingleNotification;->userId:J

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setTag(Ljava/lang/Object;)V

    .line 255
    iget-object v0, p1, Lco/vine/android/widget/ActivityViewHolder;->avatar:Landroid/widget/ImageView;

    iget-object v1, p0, Lco/vine/android/ActivityAdapter;->mAvatarClicker:Landroid/view/View$OnClickListener;

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 256
    iget-object v0, p1, Lco/vine/android/widget/ActivityViewHolder;->typeIcon:Landroid/widget/ImageView;

    invoke-virtual {v0, v6}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 257
    iget-object v0, p1, Lco/vine/android/widget/ActivityViewHolder;->typeIcon:Landroid/widget/ImageView;

    const v1, 0x7f02013f

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 258
    iget-object v0, p1, Lco/vine/android/widget/ActivityViewHolder;->thumbnail:Landroid/widget/ImageView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 259
    invoke-direct {p0, p1, p2}, Lco/vine/android/ActivityAdapter;->bindBodyText(Lco/vine/android/widget/ActivityViewHolder;Lco/vine/android/api/VineNotification;)V

    .line 260
    return-void
.end method

.method private bindGroupNotification(Lco/vine/android/widget/ActivityViewHolder;Lco/vine/android/api/VineEverydayNotification;)V
    .locals 10
    .param p1, "h"    # Lco/vine/android/widget/ActivityViewHolder;
    .param p2, "notif"    # Lco/vine/android/api/VineEverydayNotification;

    .prologue
    const/16 v9, 0x8

    const/4 v8, 0x0

    .line 317
    iget-object v0, p1, Lco/vine/android/widget/ActivityViewHolder;->contentLine:Landroid/widget/TextView;

    iget-object v1, p2, Lco/vine/android/api/VineEverydayNotification;->comment:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 318
    iget-wide v0, p2, Lco/vine/android/api/VineEverydayNotification;->notificationId:J

    iput-wide v0, p1, Lco/vine/android/widget/ActivityViewHolder;->notificationId:J

    .line 319
    iget-object v7, p2, Lco/vine/android/api/VineEverydayNotification;->user:Lco/vine/android/api/VineUser;

    .line 320
    .local v7, "user":Lco/vine/android/api/VineUser;
    if-eqz v7, :cond_0

    .line 321
    iget-wide v0, v7, Lco/vine/android/api/VineUser;->userId:J

    iput-wide v0, p1, Lco/vine/android/widget/ActivityViewHolder;->userId:J

    .line 322
    iput v8, p1, Lco/vine/android/widget/ActivityViewHolder;->listItemClickType:I

    .line 323
    iget-object v2, p1, Lco/vine/android/widget/ActivityViewHolder;->avatar:Landroid/widget/ImageView;

    iget-object v3, v7, Lco/vine/android/api/VineUser;->avatarUrl:Ljava/lang/String;

    iget-wide v4, v7, Lco/vine/android/api/VineUser;->userId:J

    move-object v0, p0

    move-object v1, p1

    invoke-direct/range {v0 .. v5}, Lco/vine/android/ActivityAdapter;->setAvatar(Lco/vine/android/widget/ActivityViewHolder;Landroid/widget/ImageView;Ljava/lang/String;J)V

    .line 324
    iget-object v0, p1, Lco/vine/android/widget/ActivityViewHolder;->avatar:Landroid/widget/ImageView;

    iget-wide v1, v7, Lco/vine/android/api/VineUser;->userId:J

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setTag(Ljava/lang/Object;)V

    .line 325
    iget-object v0, p1, Lco/vine/android/widget/ActivityViewHolder;->avatar:Landroid/widget/ImageView;

    iget-object v1, p0, Lco/vine/android/ActivityAdapter;->mAvatarClicker:Landroid/view/View$OnClickListener;

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 328
    :cond_0
    const-string v0, "twitter friend joined"

    iget-object v1, p2, Lco/vine/android/api/VineEverydayNotification;->type:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    const-string v0, "address book friend joined"

    iget-object v1, p2, Lco/vine/android/api/VineEverydayNotification;->type:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 330
    :cond_1
    iget-object v0, p2, Lco/vine/android/api/VineEverydayNotification;->entities:Ljava/util/ArrayList;

    if-eqz v0, :cond_2

    .line 331
    iget-object v0, p2, Lco/vine/android/api/VineEverydayNotification;->entities:Ljava/util/ArrayList;

    invoke-virtual {v0, v8}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/api/VineEntity;

    iget-wide v0, v0, Lco/vine/android/api/VineEntity;->id:J

    iput-wide v0, p1, Lco/vine/android/widget/ActivityViewHolder;->userId:J

    .line 332
    iput v8, p1, Lco/vine/android/widget/ActivityViewHolder;->listItemClickType:I

    .line 336
    :cond_2
    iget-object v0, p2, Lco/vine/android/api/VineEverydayNotification;->post:Lco/vine/android/api/VinePost;

    if-eqz v0, :cond_7

    .line 337
    iget-object v0, p2, Lco/vine/android/api/VineEverydayNotification;->post:Lco/vine/android/api/VinePost;

    iget-wide v0, v0, Lco/vine/android/api/VinePost;->postId:J

    iput-wide v0, p1, Lco/vine/android/widget/ActivityViewHolder;->postId:J

    .line 338
    const/4 v0, 0x1

    iput v0, p1, Lco/vine/android/widget/ActivityViewHolder;->listItemClickType:I

    .line 339
    iget-object v0, p1, Lco/vine/android/widget/ActivityViewHolder;->thumbnail:Landroid/widget/ImageView;

    invoke-virtual {v0, v8}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 340
    iget-object v0, p1, Lco/vine/android/widget/ActivityViewHolder;->thumbnail:Landroid/widget/ImageView;

    iget-wide v1, p1, Lco/vine/android/widget/ActivityViewHolder;->postId:J

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setTag(Ljava/lang/Object;)V

    .line 341
    iget-object v0, p1, Lco/vine/android/widget/ActivityViewHolder;->thumbnail:Landroid/widget/ImageView;

    iget-object v1, p0, Lco/vine/android/ActivityAdapter;->mPostClicker:Landroid/view/View$OnClickListener;

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 343
    new-instance v6, Lco/vine/android/util/image/ImageKey;

    iget-object v0, p2, Lco/vine/android/api/VineEverydayNotification;->post:Lco/vine/android/api/VinePost;

    iget-object v0, v0, Lco/vine/android/api/VinePost;->thumbnailUrl:Ljava/lang/String;

    invoke-direct {v6, v0, v8}, Lco/vine/android/util/image/ImageKey;-><init>(Ljava/lang/String;Z)V

    .line 344
    .local v6, "key":Lco/vine/android/util/image/ImageKey;
    iput-object v6, p1, Lco/vine/android/widget/ActivityViewHolder;->thumbnailImageKey:Lco/vine/android/util/image/ImageKey;

    .line 345
    iget-object v0, p1, Lco/vine/android/widget/ActivityViewHolder;->thumbnail:Landroid/widget/ImageView;

    iget-object v1, p0, Lco/vine/android/ActivityAdapter;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v1, v6}, Lco/vine/android/client/AppController;->getPhotoBitmap(Lco/vine/android/util/image/ImageKey;)Landroid/graphics/Bitmap;

    move-result-object v1

    invoke-direct {p0, v0, v1}, Lco/vine/android/ActivityAdapter;->setImage(Landroid/widget/ImageView;Landroid/graphics/Bitmap;)V

    .line 354
    .end local v6    # "key":Lco/vine/android/util/image/ImageKey;
    :goto_0
    const-string v0, "followed"

    iget-object v1, p2, Lco/vine/android/api/VineEverydayNotification;->type:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_3

    const-string v0, "follow approved"

    iget-object v1, p2, Lco/vine/android/api/VineEverydayNotification;->type:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_3

    const-string v0, "address book friend joined"

    iget-object v1, p2, Lco/vine/android/api/VineEverydayNotification;->type:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_9

    .line 357
    :cond_3
    iget-object v0, p1, Lco/vine/android/widget/ActivityViewHolder;->typeIcon:Landroid/widget/ImageView;

    invoke-virtual {v0, v8}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 358
    iget-object v0, p1, Lco/vine/android/widget/ActivityViewHolder;->typeIcon:Landroid/widget/ImageView;

    const v1, 0x7f02013f

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 380
    :goto_1
    const-string v0, "followed"

    iget-object v1, p2, Lco/vine/android/api/VineEverydayNotification;->type:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_4

    const-string v0, "twitter friend joined"

    iget-object v1, p2, Lco/vine/android/api/VineEverydayNotification;->type:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_4

    const-string v0, "address book friend joined"

    iget-object v1, p2, Lco/vine/android/api/VineEverydayNotification;->type:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_10

    .line 383
    :cond_4
    iget-object v0, p1, Lco/vine/android/widget/ActivityViewHolder;->followButton:Landroid/view/View;

    invoke-virtual {v0, v8}, Landroid/view/View;->setVisibility(I)V

    .line 384
    iget-object v0, p1, Lco/vine/android/widget/ActivityViewHolder;->followButton:Landroid/view/View;

    iget-object v1, p0, Lco/vine/android/ActivityAdapter;->mViewClickListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 385
    if-eqz v7, :cond_6

    .line 386
    iget-object v0, p0, Lco/vine/android/ActivityAdapter;->mFriendships:Lco/vine/android/Friendships;

    iget-wide v1, v7, Lco/vine/android/api/VineUser;->userId:J

    invoke-virtual {v0, v1, v2}, Lco/vine/android/Friendships;->contains(J)Z

    move-result v0

    if-nez v0, :cond_5

    invoke-virtual {v7}, Lco/vine/android/api/VineUser;->isFollowing()Z

    move-result v0

    if-eqz v0, :cond_5

    .line 387
    iget-object v0, p0, Lco/vine/android/ActivityAdapter;->mFriendships:Lco/vine/android/Friendships;

    iget-wide v1, v7, Lco/vine/android/api/VineUser;->userId:J

    invoke-virtual {v0, v1, v2}, Lco/vine/android/Friendships;->addFollowing(J)V

    .line 389
    :cond_5
    iget-object v0, p1, Lco/vine/android/widget/ActivityViewHolder;->followButton:Landroid/view/View;

    iget-wide v1, v7, Lco/vine/android/api/VineUser;->userId:J

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 390
    iget-wide v0, v7, Lco/vine/android/api/VineUser;->userId:J

    invoke-virtual {p0, v0, v1}, Lco/vine/android/ActivityAdapter;->isFollowing(J)Z

    move-result v0

    if-eqz v0, :cond_f

    .line 391
    iget-object v0, p1, Lco/vine/android/widget/ActivityViewHolder;->followButton:Landroid/view/View;

    const v1, 0x7f020095

    invoke-virtual {v0, v1}, Landroid/view/View;->setBackgroundResource(I)V

    .line 399
    :cond_6
    :goto_2
    invoke-direct {p0, p1, p2}, Lco/vine/android/ActivityAdapter;->bindBodyText(Lco/vine/android/widget/ActivityViewHolder;Lco/vine/android/api/VineNotification;)V

    .line 400
    return-void

    .line 347
    :cond_7
    const-string v0, "follow approved"

    iget-object v1, p2, Lco/vine/android/api/VineEverydayNotification;->type:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_8

    .line 348
    iget-object v0, p1, Lco/vine/android/widget/ActivityViewHolder;->thumbnail:Landroid/widget/ImageView;

    invoke-virtual {v0, v9}, Landroid/widget/ImageView;->setVisibility(I)V

    goto/16 :goto_0

    .line 350
    :cond_8
    iget-object v0, p1, Lco/vine/android/widget/ActivityViewHolder;->thumbnail:Landroid/widget/ImageView;

    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    goto/16 :goto_0

    .line 359
    :cond_9
    const-string v0, "mentioned comment"

    iget-object v1, p2, Lco/vine/android/api/VineEverydayNotification;->type:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_a

    const-string v0, "commented"

    iget-object v1, p2, Lco/vine/android/api/VineEverydayNotification;->type:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_a

    const-string v0, "grouped comment"

    iget-object v1, p2, Lco/vine/android/api/VineEverydayNotification;->type:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_a

    const-string v0, "mentioned post"

    iget-object v1, p2, Lco/vine/android/api/VineEverydayNotification;->type:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_a

    const-string v0, "mentioned"

    iget-object v1, p2, Lco/vine/android/api/VineEverydayNotification;->type:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_b

    .line 364
    :cond_a
    iget-object v0, p1, Lco/vine/android/widget/ActivityViewHolder;->typeIcon:Landroid/widget/ImageView;

    invoke-virtual {v0, v8}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 365
    iget-object v0, p1, Lco/vine/android/widget/ActivityViewHolder;->typeIcon:Landroid/widget/ImageView;

    const v1, 0x7f02013d

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    goto/16 :goto_1

    .line 366
    :cond_b
    const-string v0, "liked"

    iget-object v1, p2, Lco/vine/android/api/VineEverydayNotification;->type:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_c

    .line 367
    iget-object v0, p1, Lco/vine/android/widget/ActivityViewHolder;->typeIcon:Landroid/widget/ImageView;

    invoke-virtual {v0, v8}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 368
    iget-object v0, p1, Lco/vine/android/widget/ActivityViewHolder;->typeIcon:Landroid/widget/ImageView;

    const v1, 0x7f020140

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    goto/16 :goto_1

    .line 369
    :cond_c
    const-string v0, "reposted"

    iget-object v1, p2, Lco/vine/android/api/VineEverydayNotification;->type:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_d

    .line 370
    iget-object v0, p1, Lco/vine/android/widget/ActivityViewHolder;->typeIcon:Landroid/widget/ImageView;

    invoke-virtual {v0, v8}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 371
    iget-object v0, p1, Lco/vine/android/widget/ActivityViewHolder;->typeIcon:Landroid/widget/ImageView;

    const v1, 0x7f020149

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    goto/16 :goto_1

    .line 372
    :cond_d
    const-string v0, "twitter friend joined"

    iget-object v1, p2, Lco/vine/android/api/VineEverydayNotification;->type:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_e

    .line 373
    iget-object v0, p1, Lco/vine/android/widget/ActivityViewHolder;->typeIcon:Landroid/widget/ImageView;

    invoke-virtual {v0, v8}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 374
    iget-object v0, p1, Lco/vine/android/widget/ActivityViewHolder;->typeIcon:Landroid/widget/ImageView;

    const v1, 0x7f02014a

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    goto/16 :goto_1

    .line 376
    :cond_e
    iget-object v0, p1, Lco/vine/android/widget/ActivityViewHolder;->typeIcon:Landroid/widget/ImageView;

    invoke-virtual {v0, v9}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 377
    iput-boolean v8, p1, Lco/vine/android/widget/ActivityViewHolder;->clickable:Z

    goto/16 :goto_1

    .line 393
    :cond_f
    iget-object v0, p1, Lco/vine/android/widget/ActivityViewHolder;->followButton:Landroid/view/View;

    const v1, 0x7f020094

    invoke-virtual {v0, v1}, Landroid/view/View;->setBackgroundResource(I)V

    goto/16 :goto_2

    .line 397
    :cond_10
    iget-object v0, p1, Lco/vine/android/widget/ActivityViewHolder;->followButton:Landroid/view/View;

    invoke-virtual {v0, v9}, Landroid/view/View;->setVisibility(I)V

    goto/16 :goto_2
.end method

.method private bindHeader(Lco/vine/android/widget/ActivityViewHolder;I)V
    .locals 5
    .param p1, "h"    # Lco/vine/android/widget/ActivityViewHolder;
    .param p2, "position"    # I

    .prologue
    const/16 v4, 0x8

    .line 222
    iget-object v3, p1, Lco/vine/android/widget/ActivityViewHolder;->headerView:Landroid/view/View;

    if-eqz v3, :cond_0

    .line 224
    invoke-virtual {p0}, Lco/vine/android/ActivityAdapter;->getSections()[Ljava/lang/Object;

    move-result-object v2

    .line 225
    .local v2, "sections":[Ljava/lang/Object;
    array-length v3, v2

    if-lez v3, :cond_2

    .line 226
    invoke-virtual {p0, p2}, Lco/vine/android/ActivityAdapter;->getSectionForPosition(I)I

    move-result v0

    .line 227
    .local v0, "section":I
    invoke-virtual {p0, v0}, Lco/vine/android/ActivityAdapter;->getPositionForSection(I)I

    move-result v1

    .line 228
    .local v1, "sectionPosition":I
    if-ne p2, v1, :cond_1

    .line 229
    iget-object v3, p1, Lco/vine/android/widget/ActivityViewHolder;->headerView:Landroid/view/View;

    const/4 v4, 0x0

    invoke-virtual {v3, v4}, Landroid/view/View;->setVisibility(I)V

    .line 230
    iget-object v4, p1, Lco/vine/android/widget/ActivityViewHolder;->headerText:Landroid/widget/TextView;

    aget-object v3, v2, v0

    check-cast v3, Ljava/lang/CharSequence;

    invoke-virtual {v4, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 238
    .end local v0    # "section":I
    .end local v1    # "sectionPosition":I
    .end local v2    # "sections":[Ljava/lang/Object;
    :cond_0
    :goto_0
    return-void

    .line 232
    .restart local v0    # "section":I
    .restart local v1    # "sectionPosition":I
    .restart local v2    # "sections":[Ljava/lang/Object;
    :cond_1
    iget-object v3, p1, Lco/vine/android/widget/ActivityViewHolder;->headerView:Landroid/view/View;

    invoke-virtual {v3, v4}, Landroid/view/View;->setVisibility(I)V

    goto :goto_0

    .line 235
    .end local v0    # "section":I
    .end local v1    # "sectionPosition":I
    :cond_2
    iget-object v3, p1, Lco/vine/android/widget/ActivityViewHolder;->headerView:Landroid/view/View;

    invoke-virtual {v3, v4}, Landroid/view/View;->setVisibility(I)V

    goto :goto_0
.end method

.method private bindMilestone(Lco/vine/android/widget/ActivityViewHolder;Lco/vine/android/api/VineEverydayNotification;)V
    .locals 12
    .param p1, "h"    # Lco/vine/android/widget/ActivityViewHolder;
    .param p2, "notif"    # Lco/vine/android/api/VineEverydayNotification;

    .prologue
    const/4 v11, 0x1

    const/4 v10, 0x0

    .line 263
    iget-object v7, p2, Lco/vine/android/api/VineEverydayNotification;->milestone:Lco/vine/android/api/VineMilestone;

    if-eqz v7, :cond_2

    .line 266
    const/4 v3, 0x0

    .line 267
    .local v3, "isUserType":Z
    iget-object v7, p2, Lco/vine/android/api/VineEverydayNotification;->milestone:Lco/vine/android/api/VineMilestone;

    iget-object v7, v7, Lco/vine/android/api/VineMilestone;->milestoneUrl:Ljava/lang/String;

    invoke-static {v7}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v7

    if-nez v7, :cond_0

    .line 268
    iget-object v7, p2, Lco/vine/android/api/VineEverydayNotification;->milestone:Lco/vine/android/api/VineMilestone;

    iget-object v7, v7, Lco/vine/android/api/VineMilestone;->milestoneUrl:Ljava/lang/String;

    invoke-static {v7}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v5

    .line 269
    .local v5, "milestoneUri":Landroid/net/Uri;
    invoke-virtual {v5}, Landroid/net/Uri;->getHost()Ljava/lang/String;

    move-result-object v1

    .line 270
    .local v1, "host":Ljava/lang/String;
    invoke-virtual {v5}, Landroid/net/Uri;->getLastPathSegment()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v7

    invoke-static {v7, v8}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    .line 271
    .local v2, "id":Ljava/lang/Long;
    const-string v7, "user-id"

    invoke-virtual {v7, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_3

    .line 272
    invoke-virtual {v2}, Ljava/lang/Long;->longValue()J

    move-result-wide v7

    iput-wide v7, p1, Lco/vine/android/widget/ActivityViewHolder;->userId:J

    .line 273
    iput v10, p1, Lco/vine/android/widget/ActivityViewHolder;->listItemClickType:I

    .line 274
    const/4 v3, 0x1

    .line 283
    .end local v1    # "host":Ljava/lang/String;
    .end local v2    # "id":Ljava/lang/Long;
    .end local v5    # "milestoneUri":Landroid/net/Uri;
    :cond_0
    :goto_0
    new-instance v4, Lco/vine/android/util/image/ImageKey;

    iget-object v7, p2, Lco/vine/android/api/VineEverydayNotification;->milestone:Lco/vine/android/api/VineMilestone;

    iget-object v7, v7, Lco/vine/android/api/VineMilestone;->backgroundImageUrl:Ljava/lang/String;

    iget-object v8, p2, Lco/vine/android/api/VineEverydayNotification;->milestone:Lco/vine/android/api/VineMilestone;

    iget v8, v8, Lco/vine/android/api/VineMilestone;->blurRadius:I

    mul-int/lit8 v8, v8, 0x2

    invoke-direct {v4, v7, v11, v8, v11}, Lco/vine/android/util/image/ImageKey;-><init>(Ljava/lang/String;ZIZ)V

    .line 284
    .local v4, "key":Lco/vine/android/util/image/ImageKey;
    iput-object v4, p1, Lco/vine/android/widget/ActivityViewHolder;->milestoneBackgroundImageKey:Lco/vine/android/util/image/ImageKey;

    .line 285
    iget-object v7, p1, Lco/vine/android/widget/ActivityViewHolder;->milestoneBackground:Landroid/widget/ImageView;

    iget-object v8, p0, Lco/vine/android/ActivityAdapter;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v8, v4}, Lco/vine/android/client/AppController;->getPhotoBitmap(Lco/vine/android/util/image/ImageKey;)Landroid/graphics/Bitmap;

    move-result-object v8

    invoke-direct {p0, v7, v8, v10}, Lco/vine/android/ActivityAdapter;->setImage(Landroid/widget/ImageView;Landroid/graphics/Bitmap;Z)V

    .line 288
    new-instance v4, Lco/vine/android/util/image/ImageKey;

    .end local v4    # "key":Lco/vine/android/util/image/ImageKey;
    iget-object v7, p2, Lco/vine/android/api/VineEverydayNotification;->milestone:Lco/vine/android/api/VineMilestone;

    iget-object v7, v7, Lco/vine/android/api/VineMilestone;->backgroundImageUrl:Ljava/lang/String;

    iget v8, p0, Lco/vine/android/ActivityAdapter;->mProfileImageSize:I

    iget v9, p0, Lco/vine/android/ActivityAdapter;->mProfileImageSize:I

    invoke-direct {v4, v7, v8, v9, v3}, Lco/vine/android/util/image/ImageKey;-><init>(Ljava/lang/String;IIZ)V

    .line 289
    .restart local v4    # "key":Lco/vine/android/util/image/ImageKey;
    iput-object v4, p1, Lco/vine/android/widget/ActivityViewHolder;->milestoneImageImageKey:Lco/vine/android/util/image/ImageKey;

    .line 290
    iget-object v7, p1, Lco/vine/android/widget/ActivityViewHolder;->milestoneImage:Landroid/widget/ImageView;

    iget-object v8, p0, Lco/vine/android/ActivityAdapter;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v8, v4}, Lco/vine/android/client/AppController;->getPhotoBitmap(Lco/vine/android/util/image/ImageKey;)Landroid/graphics/Bitmap;

    move-result-object v8

    invoke-direct {p0, v7, v8, v10}, Lco/vine/android/ActivityAdapter;->setImage(Landroid/widget/ImageView;Landroid/graphics/Bitmap;Z)V

    .line 292
    iget-object v8, p1, Lco/vine/android/widget/ActivityViewHolder;->milestoneImageFrame:Landroid/widget/ImageView;

    if-eqz v3, :cond_4

    const v7, 0x7f02021c

    :goto_1
    invoke-virtual {v8, v7}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 296
    new-instance v4, Lco/vine/android/util/image/ImageKey;

    .end local v4    # "key":Lco/vine/android/util/image/ImageKey;
    iget-object v7, p2, Lco/vine/android/api/VineEverydayNotification;->milestone:Lco/vine/android/api/VineMilestone;

    iget-object v7, v7, Lco/vine/android/api/VineMilestone;->iconUrl:Ljava/lang/String;

    invoke-direct {v4, v7}, Lco/vine/android/util/image/ImageKey;-><init>(Ljava/lang/String;)V

    .line 297
    .restart local v4    # "key":Lco/vine/android/util/image/ImageKey;
    iput-object v4, p1, Lco/vine/android/widget/ActivityViewHolder;->milestoneIconImageKey:Lco/vine/android/util/image/ImageKey;

    .line 298
    iget-object v7, p1, Lco/vine/android/widget/ActivityViewHolder;->milestoneIcon:Landroid/widget/ImageView;

    iget-object v8, p0, Lco/vine/android/ActivityAdapter;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v8, v4}, Lco/vine/android/client/AppController;->getPhotoBitmap(Lco/vine/android/util/image/ImageKey;)Landroid/graphics/Bitmap;

    move-result-object v8

    invoke-direct {p0, v7, v8, v10}, Lco/vine/android/ActivityAdapter;->setImage(Landroid/widget/ImageView;Landroid/graphics/Bitmap;Z)V

    .line 300
    iget-object v7, p1, Lco/vine/android/widget/ActivityViewHolder;->milestoneTitle:Landroid/widget/TextView;

    iget-object v8, p2, Lco/vine/android/api/VineEverydayNotification;->milestone:Lco/vine/android/api/VineMilestone;

    iget-object v8, v8, Lco/vine/android/api/VineMilestone;->title:Ljava/lang/String;

    invoke-virtual {v7, v8}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 301
    iget-object v7, p0, Lco/vine/android/ActivityAdapter;->mContext:Landroid/content/Context;

    iget-wide v8, p2, Lco/vine/android/api/VineEverydayNotification;->createdAt:J

    invoke-static {v7, v8, v9, v11}, Lco/vine/android/util/Util;->getRelativeTimeString(Landroid/content/Context;JZ)Ljava/lang/String;

    move-result-object v0

    .line 302
    .local v0, "date":Ljava/lang/String;
    iget-object v7, p1, Lco/vine/android/widget/ActivityViewHolder;->milestoneDescription:Landroid/widget/TextView;

    invoke-virtual {v7, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 304
    iget-object v7, p2, Lco/vine/android/api/VineEverydayNotification;->post:Lco/vine/android/api/VinePost;

    if-eqz v7, :cond_1

    .line 305
    iget-object v7, p2, Lco/vine/android/api/VineEverydayNotification;->post:Lco/vine/android/api/VinePost;

    iget-wide v7, v7, Lco/vine/android/api/VinePost;->postId:J

    iput-wide v7, p1, Lco/vine/android/widget/ActivityViewHolder;->postId:J

    .line 308
    :cond_1
    iget-object v7, p1, Lco/vine/android/widget/ActivityViewHolder;->milestoneOverlay:Landroid/view/View;

    invoke-virtual {v7}, Landroid/view/View;->getBackground()Landroid/graphics/drawable/Drawable;

    move-result-object v6

    check-cast v6, Landroid/graphics/drawable/GradientDrawable;

    .line 309
    .local v6, "overlay":Landroid/graphics/drawable/GradientDrawable;
    const/high16 v7, -0x1000000

    iget-object v8, p2, Lco/vine/android/api/VineEverydayNotification;->milestone:Lco/vine/android/api/VineMilestone;

    iget v8, v8, Lco/vine/android/api/VineMilestone;->overlayColor:I

    or-int/2addr v7, v8

    invoke-virtual {v6, v7}, Landroid/graphics/drawable/GradientDrawable;->setColor(I)V

    .line 311
    iget-object v7, p1, Lco/vine/android/widget/ActivityViewHolder;->milestoneOverlay:Landroid/view/View;

    iget-object v8, p2, Lco/vine/android/api/VineEverydayNotification;->milestone:Lco/vine/android/api/VineMilestone;

    iget v8, v8, Lco/vine/android/api/VineMilestone;->overlayAlpha:F

    const v9, 0x3dcccccd    # 0.1f

    add-float/2addr v8, v9

    invoke-virtual {v7, v8}, Landroid/view/View;->setAlpha(F)V

    .line 314
    .end local v0    # "date":Ljava/lang/String;
    .end local v3    # "isUserType":Z
    .end local v4    # "key":Lco/vine/android/util/image/ImageKey;
    .end local v6    # "overlay":Landroid/graphics/drawable/GradientDrawable;
    :cond_2
    return-void

    .line 275
    .restart local v1    # "host":Ljava/lang/String;
    .restart local v2    # "id":Ljava/lang/Long;
    .restart local v3    # "isUserType":Z
    .restart local v5    # "milestoneUri":Landroid/net/Uri;
    :cond_3
    const-string v7, "post"

    invoke-virtual {v7, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_0

    .line 276
    iput v11, p1, Lco/vine/android/widget/ActivityViewHolder;->listItemClickType:I

    .line 277
    invoke-virtual {v2}, Ljava/lang/Long;->longValue()J

    move-result-wide v7

    iput-wide v7, p1, Lco/vine/android/widget/ActivityViewHolder;->postId:J

    .line 278
    const/4 v3, 0x0

    goto/16 :goto_0

    .line 292
    .end local v1    # "host":Ljava/lang/String;
    .end local v2    # "id":Ljava/lang/Long;
    .end local v5    # "milestoneUri":Landroid/net/Uri;
    .restart local v4    # "key":Lco/vine/android/util/image/ImageKey;
    :cond_4
    const v7, 0x7f02021d

    goto :goto_1
.end method

.method private nextViewHasHeader(I)Z
    .locals 3
    .param p1, "position"    # I

    .prologue
    const/4 v0, 0x0

    .line 241
    invoke-virtual {p0}, Lco/vine/android/ActivityAdapter;->getSections()[Ljava/lang/Object;

    move-result-object v1

    array-length v1, v1

    if-nez v1, :cond_1

    .line 244
    :cond_0
    :goto_0
    return v0

    :cond_1
    invoke-virtual {p0, p1}, Lco/vine/android/ActivityAdapter;->getSectionForPosition(I)I

    move-result v1

    add-int/lit8 v2, p1, 0x1

    invoke-virtual {p0, v2}, Lco/vine/android/ActivityAdapter;->getSectionForPosition(I)I

    move-result v2

    if-eq v1, v2, :cond_0

    const/4 v0, 0x1

    goto :goto_0
.end method

.method private setAvatar(Lco/vine/android/widget/ActivityViewHolder;Landroid/widget/ImageView;Ljava/lang/String;J)V
    .locals 4
    .param p1, "h"    # Lco/vine/android/widget/ActivityViewHolder;
    .param p2, "avatarImageView"    # Landroid/widget/ImageView;
    .param p3, "avatarUrl"    # Ljava/lang/String;
    .param p4, "userId"    # J

    .prologue
    .line 464
    invoke-static {p3}, Lco/vine/android/util/Util;->isDefaultAvatarUrl(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 465
    sget-object v1, Lco/vine/android/util/Util$ProfileImageSize;->MEDIUM:Lco/vine/android/util/Util$ProfileImageSize;

    const/high16 v2, -0x1000000

    iget v3, p0, Lco/vine/android/ActivityAdapter;->mVineGreen:I

    or-int/2addr v2, v3

    invoke-static {p2, v1, v2}, Lco/vine/android/util/Util;->safeSetDefaultAvatar(Landroid/widget/ImageView;Lco/vine/android/util/Util$ProfileImageSize;I)V

    .line 471
    :goto_0
    invoke-static {p4, p5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {p2, v1}, Landroid/widget/ImageView;->setTag(Ljava/lang/Object;)V

    .line 472
    return-void

    .line 467
    :cond_0
    new-instance v0, Lco/vine/android/util/image/ImageKey;

    iget v1, p0, Lco/vine/android/ActivityAdapter;->mProfileImageSize:I

    iget v2, p0, Lco/vine/android/ActivityAdapter;->mProfileImageSize:I

    const/4 v3, 0x1

    invoke-direct {v0, p3, v1, v2, v3}, Lco/vine/android/util/image/ImageKey;-><init>(Ljava/lang/String;IIZ)V

    .line 468
    .local v0, "key":Lco/vine/android/util/image/ImageKey;
    iput-object v0, p1, Lco/vine/android/widget/ActivityViewHolder;->avatarImageKey:Lco/vine/android/util/image/ImageKey;

    .line 469
    iget-object v1, p0, Lco/vine/android/ActivityAdapter;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v1, v0}, Lco/vine/android/client/AppController;->getPhotoBitmap(Lco/vine/android/util/image/ImageKey;)Landroid/graphics/Bitmap;

    move-result-object v1

    invoke-direct {p0, p2, v1}, Lco/vine/android/ActivityAdapter;->setUserImage(Landroid/widget/ImageView;Landroid/graphics/Bitmap;)V

    goto :goto_0
.end method

.method private setImage(Landroid/widget/ImageView;Landroid/graphics/Bitmap;)V
    .locals 1
    .param p1, "v"    # Landroid/widget/ImageView;
    .param p2, "bmp"    # Landroid/graphics/Bitmap;

    .prologue
    .line 588
    const/4 v0, 0x1

    invoke-direct {p0, p1, p2, v0}, Lco/vine/android/ActivityAdapter;->setImage(Landroid/widget/ImageView;Landroid/graphics/Bitmap;Z)V

    .line 589
    return-void
.end method

.method private setImage(Landroid/widget/ImageView;Landroid/graphics/Bitmap;Z)V
    .locals 2
    .param p1, "v"    # Landroid/widget/ImageView;
    .param p2, "bmp"    # Landroid/graphics/Bitmap;
    .param p3, "showGray"    # Z

    .prologue
    .line 592
    if-nez p1, :cond_0

    .line 607
    :goto_0
    return-void

    .line 595
    :cond_0
    if-nez p2, :cond_2

    .line 596
    if-eqz p3, :cond_1

    .line 597
    iget-object v0, p0, Lco/vine/android/ActivityAdapter;->mContext:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f09007f

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getColor(I)I

    move-result v0

    invoke-virtual {p1, v0}, Landroid/widget/ImageView;->setBackgroundColor(I)V

    .line 602
    :goto_1
    const/4 v0, 0x0

    invoke-virtual {p1, v0}, Landroid/widget/ImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    goto :goto_0

    .line 600
    :cond_1
    const v0, 0xffffff

    invoke-virtual {p1, v0}, Landroid/widget/ImageView;->setBackgroundColor(I)V

    goto :goto_1

    .line 604
    :cond_2
    const/4 v0, 0x0

    invoke-virtual {p1, v0}, Landroid/widget/ImageView;->setBackgroundColor(I)V

    .line 605
    new-instance v0, Lco/vine/android/drawable/RecyclableBitmapDrawable;

    iget-object v1, p0, Lco/vine/android/ActivityAdapter;->mContext:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-direct {v0, v1, p2}, Lco/vine/android/drawable/RecyclableBitmapDrawable;-><init>(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V

    invoke-virtual {p1, v0}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    goto :goto_0
.end method

.method private setUserImage(Landroid/widget/ImageView;Landroid/graphics/Bitmap;)V
    .locals 2
    .param p1, "v"    # Landroid/widget/ImageView;
    .param p2, "bmp"    # Landroid/graphics/Bitmap;

    .prologue
    .line 575
    if-nez p1, :cond_0

    .line 585
    :goto_0
    return-void

    .line 578
    :cond_0
    const/4 v0, 0x0

    invoke-virtual {p1, v0}, Landroid/widget/ImageView;->setColorFilter(Landroid/graphics/ColorFilter;)V

    .line 579
    if-nez p2, :cond_1

    .line 580
    const v0, 0x7f0200f7

    invoke-virtual {p1, v0}, Landroid/widget/ImageView;->setImageResource(I)V

    goto :goto_0

    .line 582
    :cond_1
    const/4 v0, 0x0

    invoke-virtual {p1, v0}, Landroid/widget/ImageView;->setBackgroundColor(I)V

    .line 583
    new-instance v0, Lco/vine/android/drawable/RecyclableBitmapDrawable;

    iget-object v1, p0, Lco/vine/android/ActivityAdapter;->mContext:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-direct {v0, v1, p2}, Lco/vine/android/drawable/RecyclableBitmapDrawable;-><init>(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V

    invoke-virtual {p1, v0}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    goto :goto_0
.end method


# virtual methods
.method public bindView(Landroid/view/View;I)V
    .locals 8
    .param p1, "view"    # Landroid/view/View;
    .param p2, "position"    # I

    .prologue
    const-wide/16 v6, 0x0

    const/4 v4, 0x0

    .line 176
    invoke-virtual {p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lco/vine/android/widget/ActivityViewHolder;

    .line 178
    .local v1, "h":Lco/vine/android/widget/ActivityViewHolder;
    if-nez v1, :cond_0

    .line 179
    new-instance v3, Ljava/lang/RuntimeException;

    const-string v4, "View tag is null."

    invoke-direct {v3, v4}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 182
    :cond_0
    iget-object v5, v1, Lco/vine/android/widget/ActivityViewHolder;->divider:Landroid/view/View;

    invoke-direct {p0, p2}, Lco/vine/android/ActivityAdapter;->nextViewHasHeader(I)Z

    move-result v3

    if-eqz v3, :cond_1

    const/16 v3, 0x8

    :goto_0
    invoke-virtual {v5, v3}, Landroid/view/View;->setVisibility(I)V

    .line 184
    iput-wide v6, v1, Lco/vine/android/widget/ActivityViewHolder;->userId:J

    .line 185
    iput-wide v6, v1, Lco/vine/android/widget/ActivityViewHolder;->postId:J

    .line 186
    const/4 v3, -0x1

    iput v3, v1, Lco/vine/android/widget/ActivityViewHolder;->listItemClickType:I

    .line 188
    invoke-direct {p0, v1, p2}, Lco/vine/android/ActivityAdapter;->bindHeader(Lco/vine/android/widget/ActivityViewHolder;I)V

    .line 190
    invoke-virtual {p0, p2}, Lco/vine/android/ActivityAdapter;->getItemViewType(I)I

    move-result v3

    packed-switch v3, :pswitch_data_0

    .line 219
    :goto_1
    return-void

    :cond_1
    move v3, v4

    .line 182
    goto :goto_0

    .line 192
    :pswitch_0
    invoke-virtual {p0, p2}, Lco/vine/android/ActivityAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lco/vine/android/api/VineEverydayNotification;

    invoke-direct {p0, v1, v3}, Lco/vine/android/ActivityAdapter;->bindMilestone(Lco/vine/android/widget/ActivityViewHolder;Lco/vine/android/api/VineEverydayNotification;)V

    goto :goto_1

    .line 196
    :pswitch_1
    invoke-virtual {p0, p2}, Lco/vine/android/ActivityAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lco/vine/android/api/VineEverydayNotification;

    invoke-direct {p0, v1, v3}, Lco/vine/android/ActivityAdapter;->bindGroupNotification(Lco/vine/android/widget/ActivityViewHolder;Lco/vine/android/api/VineEverydayNotification;)V

    goto :goto_1

    .line 200
    :pswitch_2
    invoke-virtual {p0, p2}, Lco/vine/android/ActivityAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lco/vine/android/api/VineSingleNotification;

    invoke-direct {p0, v1, v3}, Lco/vine/android/ActivityAdapter;->bindFollowRequest(Lco/vine/android/widget/ActivityViewHolder;Lco/vine/android/api/VineSingleNotification;)V

    goto :goto_1

    .line 204
    :pswitch_3
    invoke-virtual {p0, p2}, Lco/vine/android/ActivityAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lco/vine/android/api/VineEverydayNotification;

    .line 205
    .local v2, "notif":Lco/vine/android/api/VineEverydayNotification;
    iget-wide v5, v2, Lco/vine/android/api/VineEverydayNotification;->notificationId:J

    iput-wide v5, v1, Lco/vine/android/widget/ActivityViewHolder;->notificationId:J

    .line 206
    iget-object v3, v2, Lco/vine/android/api/VineEverydayNotification;->entities:Ljava/util/ArrayList;

    invoke-virtual {v3, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/api/VineEntity;

    .line 207
    .local v0, "firstEntity":Lco/vine/android/api/VineEntity;
    if-eqz v0, :cond_2

    invoke-virtual {v0}, Lco/vine/android/api/VineEntity;->isCommentListType()Z

    move-result v3

    if-eqz v3, :cond_2

    .line 208
    const/4 v3, 0x3

    iput v3, v1, Lco/vine/android/widget/ActivityViewHolder;->listItemClickType:I

    .line 209
    invoke-virtual {v0}, Lco/vine/android/api/VineEntity;->getPostId()J

    move-result-wide v3

    iput-wide v3, v1, Lco/vine/android/widget/ActivityViewHolder;->postId:J

    .line 213
    :goto_2
    iget-wide v3, v2, Lco/vine/android/api/VineEverydayNotification;->anchor:J

    iput-wide v3, v1, Lco/vine/android/widget/ActivityViewHolder;->anchor:J

    .line 214
    iget-object v3, v1, Lco/vine/android/widget/ActivityViewHolder;->contentLine:Landroid/widget/TextView;

    iget-object v4, v2, Lco/vine/android/api/VineEverydayNotification;->comment:Ljava/lang/String;

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 215
    iget-object v3, v1, Lco/vine/android/widget/ActivityViewHolder;->contentLine:Landroid/widget/TextView;

    iget-object v4, p0, Lco/vine/android/ActivityAdapter;->mUserListClicker:Landroid/view/View$OnClickListener;

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 216
    iget-object v3, v1, Lco/vine/android/widget/ActivityViewHolder;->contentLine:Landroid/widget/TextView;

    invoke-virtual {v3, v2}, Landroid/widget/TextView;->setTag(Ljava/lang/Object;)V

    goto :goto_1

    .line 211
    :cond_2
    const/4 v3, 0x2

    iput v3, v1, Lco/vine/android/widget/ActivityViewHolder;->listItemClickType:I

    goto :goto_2

    .line 190
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_0
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method public follow(J)V
    .locals 1
    .param p1, "userId"    # J

    .prologue
    .line 650
    iget-object v0, p0, Lco/vine/android/ActivityAdapter;->mFriendships:Lco/vine/android/Friendships;

    invoke-virtual {v0, p1, p2}, Lco/vine/android/Friendships;->addFollowing(J)V

    .line 651
    invoke-virtual {p0}, Lco/vine/android/ActivityAdapter;->notifyDataSetChanged()V

    .line 652
    return-void
.end method

.method public getCount()I
    .locals 2

    .prologue
    .line 476
    iget-object v0, p0, Lco/vine/android/ActivityAdapter;->mFollowRequests:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    iget-object v1, p0, Lco/vine/android/ActivityAdapter;->mNotifications:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    add-int/2addr v0, v1

    return v0
.end method

.method public getItem(I)Ljava/lang/Object;
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 481
    iget-object v0, p0, Lco/vine/android/ActivityAdapter;->mFollowRequests:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ge p1, v0, :cond_0

    .line 482
    iget-object v0, p0, Lco/vine/android/ActivityAdapter;->mFollowRequests:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    .line 484
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lco/vine/android/ActivityAdapter;->mNotifications:Ljava/util/ArrayList;

    iget-object v1, p0, Lco/vine/android/ActivityAdapter;->mFollowRequests:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    sub-int v1, p1, v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    goto :goto_0
.end method

.method public getItemId(I)J
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 490
    invoke-virtual {p0, p1}, Lco/vine/android/ActivityAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/api/VineNotification;

    iget-wide v0, v0, Lco/vine/android/api/VineNotification;->notificationId:J

    return-wide v0
.end method

.method public getItemViewType(I)I
    .locals 3
    .param p1, "position"    # I

    .prologue
    .line 508
    iget-object v1, p0, Lco/vine/android/ActivityAdapter;->mFollowRequests:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-ge p1, v1, :cond_0

    .line 509
    const/4 v1, 0x2

    .line 517
    :goto_0
    return v1

    .line 511
    :cond_0
    invoke-virtual {p0, p1}, Lco/vine/android/ActivityAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/api/VineEverydayNotification;

    .line 512
    .local v0, "notif":Lco/vine/android/api/VineEverydayNotification;
    iget-object v1, v0, Lco/vine/android/api/VineEverydayNotification;->milestone:Lco/vine/android/api/VineMilestone;

    if-eqz v1, :cond_1

    .line 513
    const/4 v1, 0x1

    goto :goto_0

    .line 514
    :cond_1
    const-string v1, "count"

    iget-object v2, v0, Lco/vine/android/api/VineEverydayNotification;->type:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 515
    const/4 v1, 0x3

    goto :goto_0

    .line 517
    :cond_2
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public getPinnedHeaderHeight()I
    .locals 1

    .prologue
    .line 759
    iget v0, p0, Lco/vine/android/ActivityAdapter;->mPinnedHeaderHeight:I

    return v0
.end method

.method public getPinnedHeaderStatus(I)Lco/vine/android/widget/PinnedHeaderAdapter$PinnedHeaderStatus;
    .locals 10
    .param p1, "navBottom"    # I

    .prologue
    const/4 v8, 0x1

    const/4 v7, 0x0

    .line 717
    iget v3, p0, Lco/vine/android/ActivityAdapter;->mPinnedHeaderSection:I

    .line 718
    .local v3, "pinnedHeaderSection":I
    iget-object v6, p0, Lco/vine/android/ActivityAdapter;->mListView:Landroid/widget/ListView;

    check-cast v6, Lco/vine/android/widget/PinnedHeaderListView;

    invoke-virtual {v6, p1}, Lco/vine/android/widget/PinnedHeaderListView;->getPositionForPixelLocation(I)I

    move-result v0

    .line 719
    .local v0, "childIndex":I
    iget-object v6, p0, Lco/vine/android/ActivityAdapter;->mListView:Landroid/widget/ListView;

    invoke-virtual {v6}, Landroid/widget/ListView;->getFirstVisiblePosition()I

    move-result v6

    iget-object v9, p0, Lco/vine/android/ActivityAdapter;->mListView:Landroid/widget/ListView;

    invoke-virtual {v9}, Landroid/widget/ListView;->getHeaderViewsCount()I

    move-result v9

    sub-int/2addr v6, v9

    add-int v4, v6, v0

    .line 720
    .local v4, "position":I
    invoke-virtual {p0, v4}, Lco/vine/android/ActivityAdapter;->getSectionForPosition(I)I

    move-result v6

    iput v6, p0, Lco/vine/android/ActivityAdapter;->mPinnedHeaderSection:I

    .line 721
    const/4 v2, 0x0

    .line 722
    .local v2, "offset":I
    invoke-direct {p0, v4}, Lco/vine/android/ActivityAdapter;->nextViewHasHeader(I)Z

    move-result v6

    if-eqz v6, :cond_0

    .line 723
    iget-object v6, p0, Lco/vine/android/ActivityAdapter;->mListView:Landroid/widget/ListView;

    add-int/lit8 v9, v0, 0x1

    invoke-virtual {v6, v9}, Landroid/widget/ListView;->getChildAt(I)Landroid/view/View;

    move-result-object v1

    .line 724
    .local v1, "nextView":Landroid/view/View;
    if-eqz v1, :cond_0

    .line 725
    invoke-virtual {v1}, Landroid/view/View;->getTop()I

    move-result v6

    iget v9, p0, Lco/vine/android/ActivityAdapter;->mPinnedHeaderHeight:I

    add-int/2addr v9, p1

    if-ge v6, v9, :cond_0

    .line 726
    invoke-virtual {v1}, Landroid/view/View;->getTop()I

    move-result v6

    iget v9, p0, Lco/vine/android/ActivityAdapter;->mPinnedHeaderHeight:I

    sub-int/2addr v6, v9

    sub-int v2, v6, p1

    .line 730
    .end local v1    # "nextView":Landroid/view/View;
    :cond_0
    iget v6, p0, Lco/vine/android/ActivityAdapter;->mPinnedHeaderSection:I

    if-ne v3, v6, :cond_1

    iget-boolean v6, p0, Lco/vine/android/ActivityAdapter;->mShouldReloadHeaderBecauseDataChanged:Z

    if-eqz v6, :cond_2

    :cond_1
    move v5, v8

    .line 731
    .local v5, "shouldReloadHeader":Z
    :goto_0
    iput-boolean v7, p0, Lco/vine/android/ActivityAdapter;->mShouldReloadHeaderBecauseDataChanged:Z

    .line 732
    new-instance v6, Lco/vine/android/widget/PinnedHeaderAdapter$PinnedHeaderStatus;

    invoke-direct {v6, v2, v5, v8}, Lco/vine/android/widget/PinnedHeaderAdapter$PinnedHeaderStatus;-><init>(IZZ)V

    return-object v6

    .end local v5    # "shouldReloadHeader":Z
    :cond_2
    move v5, v7

    .line 730
    goto :goto_0
.end method

.method public getPinnedHeaderView(Landroid/view/View;)Landroid/view/View;
    .locals 5
    .param p1, "convertView"    # Landroid/view/View;

    .prologue
    const/4 v1, 0x0

    const/4 v4, 0x0

    .line 737
    invoke-virtual {p0}, Lco/vine/android/ActivityAdapter;->getSections()[Ljava/lang/Object;

    move-result-object v2

    array-length v2, v2

    if-nez v2, :cond_0

    .line 748
    :goto_0
    return-object v1

    .line 740
    :cond_0
    if-nez p1, :cond_1

    .line 741
    iget-object v2, p0, Lco/vine/android/ActivityAdapter;->mContext:Landroid/content/Context;

    invoke-static {v2}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v2

    const v3, 0x7f030018

    invoke-virtual {v2, v3, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object p1

    .line 742
    iget-object v1, p0, Lco/vine/android/ActivityAdapter;->mListView:Landroid/widget/ListView;

    invoke-virtual {v1}, Landroid/widget/ListView;->getWidth()I

    move-result v1

    iget v2, p0, Lco/vine/android/ActivityAdapter;->mPinnedHeaderHeight:I

    invoke-virtual {p1, v4, v4, v1, v2}, Landroid/view/View;->layout(IIII)V

    .line 743
    new-instance v0, Lco/vine/android/widget/ActivityViewHolder;

    invoke-direct {v0, p1}, Lco/vine/android/widget/ActivityViewHolder;-><init>(Landroid/view/View;)V

    .line 744
    .local v0, "h":Lco/vine/android/widget/ActivityViewHolder;
    invoke-virtual {p1, v0}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 746
    .end local v0    # "h":Lco/vine/android/widget/ActivityViewHolder;
    :cond_1
    invoke-virtual {p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/widget/ActivityViewHolder;

    .line 747
    .restart local v0    # "h":Lco/vine/android/widget/ActivityViewHolder;
    iget v1, p0, Lco/vine/android/ActivityAdapter;->mPinnedHeaderSection:I

    invoke-virtual {p0, v1}, Lco/vine/android/ActivityAdapter;->getPositionForSection(I)I

    move-result v1

    invoke-direct {p0, v0, v1}, Lco/vine/android/ActivityAdapter;->bindHeader(Lco/vine/android/widget/ActivityViewHolder;I)V

    move-object v1, p1

    .line 748
    goto :goto_0
.end method

.method public getPositionForSection(I)I
    .locals 2
    .param p1, "sectionIndex"    # I

    .prologue
    const/4 v0, 0x0

    .line 676
    invoke-virtual {p0}, Lco/vine/android/ActivityAdapter;->getSections()[Ljava/lang/Object;

    move-result-object v1

    array-length v1, v1

    if-lez v1, :cond_0

    .line 678
    if-nez p1, :cond_1

    .line 698
    :cond_0
    :goto_0
    return v0

    .line 683
    :cond_1
    const/4 v1, 0x1

    if-ne p1, v1, :cond_3

    .line 685
    iget-object v1, p0, Lco/vine/android/ActivityAdapter;->mFollowRequests:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-lez v1, :cond_2

    .line 686
    iget-object v0, p0, Lco/vine/android/ActivityAdapter;->mFollowRequests:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    goto :goto_0

    .line 687
    :cond_2
    iget v1, p0, Lco/vine/android/ActivityAdapter;->mLastNewIndex:I

    if-ltz v1, :cond_3

    .line 689
    iget v0, p0, Lco/vine/android/ActivityAdapter;->mLastNewIndex:I

    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 694
    :cond_3
    const/4 v1, 0x2

    if-ne p1, v1, :cond_0

    .line 695
    iget-object v0, p0, Lco/vine/android/ActivityAdapter;->mFollowRequests:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    iget v1, p0, Lco/vine/android/ActivityAdapter;->mLastNewIndex:I

    add-int/2addr v0, v1

    add-int/lit8 v0, v0, 0x1

    goto :goto_0
.end method

.method public getSectionForPosition(I)I
    .locals 4
    .param p1, "position"    # I

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 703
    invoke-virtual {p0}, Lco/vine/android/ActivityAdapter;->getSections()[Ljava/lang/Object;

    move-result-object v2

    array-length v2, v2

    if-lez v2, :cond_0

    .line 704
    iget-object v2, p0, Lco/vine/android/ActivityAdapter;->mFollowRequests:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v2

    if-ge p1, v2, :cond_1

    .line 712
    :cond_0
    :goto_0
    return v1

    .line 706
    :cond_1
    iget-object v2, p0, Lco/vine/android/ActivityAdapter;->mFollowRequests:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v2

    iget v3, p0, Lco/vine/android/ActivityAdapter;->mLastNewIndex:I

    add-int/2addr v2, v3

    if-gt p1, v2, :cond_3

    .line 707
    iget-object v2, p0, Lco/vine/android/ActivityAdapter;->mFollowRequests:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v2

    if-lez v2, :cond_2

    :goto_1
    move v1, v0

    goto :goto_0

    :cond_2
    move v0, v1

    goto :goto_1

    .line 709
    :cond_3
    iget-object v2, p0, Lco/vine/android/ActivityAdapter;->mFollowRequests:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v2

    if-lez v2, :cond_4

    move v2, v0

    :goto_2
    iget v3, p0, Lco/vine/android/ActivityAdapter;->mLastNewIndex:I

    if-ltz v3, :cond_5

    :goto_3
    add-int v1, v2, v0

    goto :goto_0

    :cond_4
    move v2, v1

    goto :goto_2

    :cond_5
    move v0, v1

    goto :goto_3
.end method

.method public getSections()[Ljava/lang/Object;
    .locals 2

    .prologue
    .line 661
    iget-object v0, p0, Lco/vine/android/ActivityAdapter;->mSections:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 662
    iget-object v0, p0, Lco/vine/android/ActivityAdapter;->mFollowRequests:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-lez v0, :cond_0

    .line 663
    iget-object v0, p0, Lco/vine/android/ActivityAdapter;->mSections:Ljava/util/ArrayList;

    iget-object v1, p0, Lco/vine/android/ActivityAdapter;->mFollowRequestsString:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 665
    :cond_0
    iget v0, p0, Lco/vine/android/ActivityAdapter;->mLastNewIndex:I

    if-ltz v0, :cond_1

    .line 666
    iget-object v0, p0, Lco/vine/android/ActivityAdapter;->mSections:Ljava/util/ArrayList;

    iget-object v1, p0, Lco/vine/android/ActivityAdapter;->mNewActivityString:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 668
    :cond_1
    iget v0, p0, Lco/vine/android/ActivityAdapter;->mLastNewIndex:I

    if-gez v0, :cond_2

    iget-object v0, p0, Lco/vine/android/ActivityAdapter;->mFollowRequests:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-lez v0, :cond_3

    .line 669
    :cond_2
    iget-object v0, p0, Lco/vine/android/ActivityAdapter;->mSections:Ljava/util/ArrayList;

    iget-object v1, p0, Lco/vine/android/ActivityAdapter;->mOlderActivityString:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 671
    :cond_3
    iget-object v0, p0, Lco/vine/android/ActivityAdapter;->mSections:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->toArray()[Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 1
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;
    .annotation build Lorg/jetbrains/annotations/Nullable;
    .end annotation

    .prologue
    .line 497
    if-nez p2, :cond_0

    .line 498
    invoke-virtual {p0, p1, p3}, Lco/vine/android/ActivityAdapter;->newView(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    .line 502
    .local v0, "view":Landroid/view/View;
    :goto_0
    invoke-virtual {p0, v0, p1}, Lco/vine/android/ActivityAdapter;->bindView(Landroid/view/View;I)V

    .line 503
    return-object v0

    .line 500
    .end local v0    # "view":Landroid/view/View;
    :cond_0
    move-object v0, p2

    .restart local v0    # "view":Landroid/view/View;
    goto :goto_0
.end method

.method public getViewTypeCount()I
    .locals 1

    .prologue
    .line 522
    const/4 v0, 0x4

    return v0
.end method

.method public isFollowing(J)Z
    .locals 1
    .param p1, "userId"    # J

    .prologue
    .line 403
    iget-object v0, p0, Lco/vine/android/ActivityAdapter;->mFriendships:Lco/vine/android/Friendships;

    invoke-virtual {v0, p1, p2}, Lco/vine/android/Friendships;->isFollowing(J)Z

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
    .line 754
    invoke-virtual {p1, p2, p3, p4, p5}, Landroid/view/View;->layout(IIII)V

    .line 755
    return-void
.end method

.method public mergeData(Ljava/util/ArrayList;Ljava/util/ArrayList;Z)V
    .locals 3
    .param p3, "mergeAfter"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VineEverydayNotification;",
            ">;",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VineSingleNotification;",
            ">;Z)V"
        }
    .end annotation

    .prologue
    .line 618
    .local p1, "notifications":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineEverydayNotification;>;"
    .local p2, "followRequests":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineSingleNotification;>;"
    if-nez p3, :cond_0

    .line 619
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    iput-object v2, p0, Lco/vine/android/ActivityAdapter;->mNotifications:Ljava/util/ArrayList;

    .line 620
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    iput-object v2, p0, Lco/vine/android/ActivityAdapter;->mFollowRequests:Ljava/util/ArrayList;

    .line 621
    iget-object v2, p0, Lco/vine/android/ActivityAdapter;->mFriendships:Lco/vine/android/Friendships;

    invoke-virtual {v2}, Lco/vine/android/Friendships;->clear()V

    .line 622
    const/4 v2, -0x1

    iput v2, p0, Lco/vine/android/ActivityAdapter;->mLastNewIndex:I

    .line 625
    :cond_0
    if-eqz p1, :cond_2

    .line 626
    invoke-virtual {p1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_2

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lco/vine/android/api/VineEverydayNotification;

    .line 628
    .local v1, "notif":Lco/vine/android/api/VineEverydayNotification;
    iget-boolean v2, v1, Lco/vine/android/api/VineEverydayNotification;->isNew:Z

    if-eqz v2, :cond_1

    .line 629
    iget v2, p0, Lco/vine/android/ActivityAdapter;->mLastNewIndex:I

    add-int/lit8 v2, v2, 0x1

    iput v2, p0, Lco/vine/android/ActivityAdapter;->mLastNewIndex:I

    .line 631
    :cond_1
    iget-object v2, p0, Lco/vine/android/ActivityAdapter;->mNotifications:Ljava/util/ArrayList;

    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 635
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v1    # "notif":Lco/vine/android/api/VineEverydayNotification;
    :cond_2
    if-eqz p2, :cond_3

    .line 636
    invoke-virtual {p2}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .restart local v0    # "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_3

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lco/vine/android/api/VineSingleNotification;

    .line 637
    .local v1, "notif":Lco/vine/android/api/VineSingleNotification;
    iget-object v2, p0, Lco/vine/android/ActivityAdapter;->mFollowRequests:Ljava/util/ArrayList;

    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 642
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v1    # "notif":Lco/vine/android/api/VineSingleNotification;
    :cond_3
    iget-object v2, p0, Lco/vine/android/ActivityAdapter;->mListView:Landroid/widget/ListView;

    check-cast v2, Lco/vine/android/widget/PinnedHeaderListView;

    invoke-virtual {v2}, Lco/vine/android/widget/PinnedHeaderListView;->untrackScrollawayChild()V

    .line 644
    if-nez p1, :cond_4

    if-eqz p2, :cond_5

    .line 645
    :cond_4
    invoke-virtual {p0}, Lco/vine/android/ActivityAdapter;->notifyDataSetChanged()V

    .line 647
    :cond_5
    return-void
.end method

.method public newView(ILandroid/view/ViewGroup;)Landroid/view/View;
    .locals 6
    .param p1, "position"    # I
    .param p2, "root"    # Landroid/view/ViewGroup;

    .prologue
    const/4 v5, 0x0

    .line 140
    invoke-virtual {p0, p1}, Lco/vine/android/ActivityAdapter;->getItemViewType(I)I

    move-result v1

    .line 142
    .local v1, "itemViewType":I
    packed-switch v1, :pswitch_data_0

    .line 156
    :pswitch_0
    iget-object v3, p0, Lco/vine/android/ActivityAdapter;->mContext:Landroid/content/Context;

    invoke-static {v3}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v3

    const v4, 0x7f03001a

    invoke-virtual {v3, v4, p2, v5}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v2

    .line 162
    .local v2, "view":Landroid/view/View;
    :goto_0
    new-instance v0, Lco/vine/android/widget/ActivityViewHolder;

    invoke-direct {v0, v2}, Lco/vine/android/widget/ActivityViewHolder;-><init>(Landroid/view/View;)V

    .line 164
    .local v0, "holder":Lco/vine/android/widget/ActivityViewHolder;
    const/4 v3, 0x1

    if-eq v1, v3, :cond_0

    .line 165
    iget-object v3, v0, Lco/vine/android/widget/ActivityViewHolder;->contentLine:Landroid/widget/TextView;

    invoke-static {}, Landroid/text/method/LinkMovementMethod;->getInstance()Landroid/text/method/MovementMethod;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setMovementMethod(Landroid/text/method/MovementMethod;)V

    .line 168
    :cond_0
    invoke-virtual {v2, v0}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 169
    iget-object v3, p0, Lco/vine/android/ActivityAdapter;->mViewHolders:Ljava/util/ArrayList;

    new-instance v4, Ljava/lang/ref/WeakReference;

    invoke-direct {v4, v0}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    invoke-virtual {v3, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 171
    return-object v2

    .line 144
    .end local v0    # "holder":Lco/vine/android/widget/ActivityViewHolder;
    .end local v2    # "view":Landroid/view/View;
    :pswitch_1
    iget-object v3, p0, Lco/vine/android/ActivityAdapter;->mContext:Landroid/content/Context;

    invoke-static {v3}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v3

    const v4, 0x7f03001e

    invoke-virtual {v3, v4, p2, v5}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v2

    .line 146
    .restart local v2    # "view":Landroid/view/View;
    goto :goto_0

    .line 149
    .end local v2    # "view":Landroid/view/View;
    :pswitch_2
    iget-object v3, p0, Lco/vine/android/ActivityAdapter;->mContext:Landroid/content/Context;

    invoke-static {v3}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v3

    const v4, 0x7f03001b

    invoke-virtual {v3, v4, p2, v5}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v2

    .line 151
    .restart local v2    # "view":Landroid/view/View;
    goto :goto_0

    .line 142
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_0
        :pswitch_2
    .end packed-switch
.end method

.method public notifyDataSetChanged()V
    .locals 1

    .prologue
    .line 611
    invoke-super {p0}, Landroid/widget/BaseAdapter;->notifyDataSetChanged()V

    .line 612
    const/4 v0, 0x1

    iput-boolean v0, p0, Lco/vine/android/ActivityAdapter;->mShouldReloadHeaderBecauseDataChanged:Z

    .line 613
    return-void
.end method

.method public setImages(Ljava/util/HashMap;)V
    .locals 10
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
    .line 526
    .local p1, "images":Ljava/util/HashMap;, "Ljava/util/HashMap<Lco/vine/android/util/image/ImageKey;Lco/vine/android/util/image/UrlImage;>;"
    new-instance v7, Ljava/util/ArrayList;

    invoke-direct {v7}, Ljava/util/ArrayList;-><init>()V

    .line 527
    .local v7, "toRemove":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/ref/WeakReference<Lco/vine/android/widget/ActivityViewHolder;>;>;"
    iget-object v8, p0, Lco/vine/android/ActivityAdapter;->mViewHolders:Ljava/util/ArrayList;

    invoke-virtual {v8}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_6

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/ref/WeakReference;

    .line 528
    .local v5, "ref":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/widget/ActivityViewHolder;>;"
    invoke-virtual {v5}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/widget/ActivityViewHolder;

    .line 529
    .local v0, "holder":Lco/vine/android/widget/ActivityViewHolder;
    if-nez v0, :cond_1

    .line 530
    invoke-virtual {v7, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 532
    :cond_1
    iget-object v8, v0, Lco/vine/android/widget/ActivityViewHolder;->avatarImageKey:Lco/vine/android/util/image/ImageKey;

    if-eqz v8, :cond_2

    .line 533
    iget-object v3, v0, Lco/vine/android/widget/ActivityViewHolder;->avatarImageKey:Lco/vine/android/util/image/ImageKey;

    .line 534
    .local v3, "key":Lco/vine/android/util/image/ImageKey;
    invoke-virtual {p1, v3}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lco/vine/android/util/image/UrlImage;

    .line 535
    .local v2, "image":Lco/vine/android/util/image/UrlImage;
    if-eqz v2, :cond_2

    invoke-virtual {v2}, Lco/vine/android/util/image/UrlImage;->isValid()Z

    move-result v8

    if-eqz v8, :cond_2

    .line 536
    iget-object v8, v0, Lco/vine/android/widget/ActivityViewHolder;->avatar:Landroid/widget/ImageView;

    iget-object v9, v2, Lco/vine/android/util/image/UrlImage;->bitmap:Landroid/graphics/Bitmap;

    invoke-direct {p0, v8, v9}, Lco/vine/android/ActivityAdapter;->setUserImage(Landroid/widget/ImageView;Landroid/graphics/Bitmap;)V

    .line 540
    .end local v2    # "image":Lco/vine/android/util/image/UrlImage;
    .end local v3    # "key":Lco/vine/android/util/image/ImageKey;
    :cond_2
    iget-object v8, v0, Lco/vine/android/widget/ActivityViewHolder;->thumbnailImageKey:Lco/vine/android/util/image/ImageKey;

    if-eqz v8, :cond_3

    .line 541
    iget-object v8, v0, Lco/vine/android/widget/ActivityViewHolder;->thumbnailImageKey:Lco/vine/android/util/image/ImageKey;

    invoke-virtual {p1, v8}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lco/vine/android/util/image/UrlImage;

    .line 542
    .local v6, "targetImage":Lco/vine/android/util/image/UrlImage;
    if-eqz v6, :cond_3

    invoke-virtual {v6}, Lco/vine/android/util/image/UrlImage;->isValid()Z

    move-result v8

    if-eqz v8, :cond_3

    .line 543
    iget-object v8, v0, Lco/vine/android/widget/ActivityViewHolder;->thumbnail:Landroid/widget/ImageView;

    iget-object v9, v6, Lco/vine/android/util/image/UrlImage;->bitmap:Landroid/graphics/Bitmap;

    invoke-direct {p0, v8, v9}, Lco/vine/android/ActivityAdapter;->setImage(Landroid/widget/ImageView;Landroid/graphics/Bitmap;)V

    .line 547
    .end local v6    # "targetImage":Lco/vine/android/util/image/UrlImage;
    :cond_3
    iget-object v8, v0, Lco/vine/android/widget/ActivityViewHolder;->milestoneImageImageKey:Lco/vine/android/util/image/ImageKey;

    if-eqz v8, :cond_4

    .line 548
    iget-object v8, v0, Lco/vine/android/widget/ActivityViewHolder;->milestoneImageImageKey:Lco/vine/android/util/image/ImageKey;

    invoke-virtual {p1, v8}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lco/vine/android/util/image/UrlImage;

    .line 549
    .restart local v6    # "targetImage":Lco/vine/android/util/image/UrlImage;
    if-eqz v6, :cond_4

    invoke-virtual {v6}, Lco/vine/android/util/image/UrlImage;->isValid()Z

    move-result v8

    if-eqz v8, :cond_4

    .line 550
    iget-object v8, v0, Lco/vine/android/widget/ActivityViewHolder;->milestoneImage:Landroid/widget/ImageView;

    iget-object v9, v6, Lco/vine/android/util/image/UrlImage;->bitmap:Landroid/graphics/Bitmap;

    invoke-direct {p0, v8, v9}, Lco/vine/android/ActivityAdapter;->setImage(Landroid/widget/ImageView;Landroid/graphics/Bitmap;)V

    .line 554
    .end local v6    # "targetImage":Lco/vine/android/util/image/UrlImage;
    :cond_4
    iget-object v8, v0, Lco/vine/android/widget/ActivityViewHolder;->milestoneBackgroundImageKey:Lco/vine/android/util/image/ImageKey;

    if-eqz v8, :cond_5

    .line 555
    iget-object v8, v0, Lco/vine/android/widget/ActivityViewHolder;->milestoneBackgroundImageKey:Lco/vine/android/util/image/ImageKey;

    invoke-virtual {p1, v8}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lco/vine/android/util/image/UrlImage;

    .line 556
    .restart local v2    # "image":Lco/vine/android/util/image/UrlImage;
    if-eqz v2, :cond_5

    invoke-virtual {v2}, Lco/vine/android/util/image/UrlImage;->isValid()Z

    move-result v8

    if-eqz v8, :cond_5

    .line 557
    iget-object v8, v0, Lco/vine/android/widget/ActivityViewHolder;->milestoneBackground:Landroid/widget/ImageView;

    iget-object v9, v2, Lco/vine/android/util/image/UrlImage;->bitmap:Landroid/graphics/Bitmap;

    invoke-direct {p0, v8, v9}, Lco/vine/android/ActivityAdapter;->setImage(Landroid/widget/ImageView;Landroid/graphics/Bitmap;)V

    .line 561
    .end local v2    # "image":Lco/vine/android/util/image/UrlImage;
    :cond_5
    iget-object v8, v0, Lco/vine/android/widget/ActivityViewHolder;->milestoneIconImageKey:Lco/vine/android/util/image/ImageKey;

    if-eqz v8, :cond_0

    .line 562
    iget-object v8, v0, Lco/vine/android/widget/ActivityViewHolder;->milestoneIconImageKey:Lco/vine/android/util/image/ImageKey;

    invoke-virtual {p1, v8}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lco/vine/android/util/image/UrlImage;

    .line 563
    .restart local v2    # "image":Lco/vine/android/util/image/UrlImage;
    if-eqz v2, :cond_0

    invoke-virtual {v2}, Lco/vine/android/util/image/UrlImage;->isValid()Z

    move-result v8

    if-eqz v8, :cond_0

    .line 564
    iget-object v8, v0, Lco/vine/android/widget/ActivityViewHolder;->milestoneIcon:Landroid/widget/ImageView;

    iget-object v9, v2, Lco/vine/android/util/image/UrlImage;->bitmap:Landroid/graphics/Bitmap;

    invoke-direct {p0, v8, v9}, Lco/vine/android/ActivityAdapter;->setImage(Landroid/widget/ImageView;Landroid/graphics/Bitmap;)V

    goto/16 :goto_0

    .line 569
    .end local v0    # "holder":Lco/vine/android/widget/ActivityViewHolder;
    .end local v2    # "image":Lco/vine/android/util/image/UrlImage;
    .end local v5    # "ref":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/widget/ActivityViewHolder;>;"
    :cond_6
    invoke-virtual {v7}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_7

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/ref/WeakReference;

    .line 570
    .local v4, "r":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/widget/ActivityViewHolder;>;"
    iget-object v8, p0, Lco/vine/android/ActivityAdapter;->mViewHolders:Ljava/util/ArrayList;

    invoke-virtual {v8, v4}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    goto :goto_1

    .line 572
    .end local v4    # "r":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/widget/ActivityViewHolder;>;"
    :cond_7
    return-void
.end method

.method public unfollow(J)V
    .locals 1
    .param p1, "userId"    # J

    .prologue
    .line 655
    iget-object v0, p0, Lco/vine/android/ActivityAdapter;->mFriendships:Lco/vine/android/Friendships;

    invoke-virtual {v0, p1, p2}, Lco/vine/android/Friendships;->removeFollowing(J)V

    .line 656
    invoke-virtual {p0}, Lco/vine/android/ActivityAdapter;->notifyDataSetChanged()V

    .line 657
    return-void
.end method
