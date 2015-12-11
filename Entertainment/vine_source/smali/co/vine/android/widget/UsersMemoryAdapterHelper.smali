.class public Lco/vine/android/widget/UsersMemoryAdapterHelper;
.super Ljava/lang/Object;
.source "UsersMemoryAdapterHelper.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/widget/UsersMemoryAdapterHelper$UsersAppSessionListener;
    }
.end annotation


# static fields
.field public static final ARG_ANCHOR:Ljava/lang/String; = "anchor"

.field public static final ARG_NOTIFICATION_ID:Ljava/lang/String; = "notification_id"

.field public static final ARG_POST_ID:Ljava/lang/String; = "post_id"

.field public static final ARG_PROFILE_ID:Ljava/lang/String; = "p_id"

.field public static final ARG_USERS_TYPE:Ljava/lang/String; = "u_type"


# instance fields
.field private mAdapter:Lco/vine/android/UsersMemoryAdapter;

.field private mAnchor:J

.field private mAppController:Lco/vine/android/client/AppController;

.field private mAppSessionListener:Lco/vine/android/widget/UsersMemoryAdapterHelper$UsersAppSessionListener;

.field mFetched:Z

.field private final mFlurryEventSource:Ljava/lang/String;

.field private final mFragment:Lco/vine/android/BaseFragment;

.field private mFriendships:Lco/vine/android/Friendships;

.field private final mFriendshipsTag:Ljava/lang/String;

.field private final mLoadFalgsTag:Ljava/lang/String;

.field mLoadFlags:I

.field private mNextPage:I

.field mNotificationId:J

.field private mOriginalAnchor:J

.field private final mPendingRequestHelper:Lco/vine/android/PendingRequestHelper;

.field mPostId:J

.field mProfileId:J

.field private mRefreshable:Z

.field mUsersType:I


# direct methods
.method public constructor <init>(Lco/vine/android/BaseFragment;Lco/vine/android/PendingRequestHelper;Ljava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p1, "fragment"    # Lco/vine/android/BaseFragment;
    .param p2, "pendingRequestHelper"    # Lco/vine/android/PendingRequestHelper;
    .param p3, "flurryEventSource"    # Ljava/lang/String;
    .param p4, "tag"    # Ljava/lang/String;

    .prologue
    const-wide/16 v1, 0x0

    .line 64
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 58
    const/4 v0, 0x1

    iput v0, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mNextPage:I

    .line 59
    iput-wide v1, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mAnchor:J

    .line 60
    iput-wide v1, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mOriginalAnchor:J

    .line 65
    iput-object p1, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mFragment:Lco/vine/android/BaseFragment;

    .line 66
    iput-object p2, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mPendingRequestHelper:Lco/vine/android/PendingRequestHelper;

    .line 67
    iput-object p3, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mFlurryEventSource:Ljava/lang/String;

    .line 68
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "state_load_flags_"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mLoadFalgsTag:Ljava/lang/String;

    .line 69
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "state_friendships_"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mFriendshipsTag:Ljava/lang/String;

    .line 70
    return-void
.end method

.method static synthetic access$000(Lco/vine/android/widget/UsersMemoryAdapterHelper;)Lco/vine/android/PendingRequestHelper;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/widget/UsersMemoryAdapterHelper;

    .prologue
    .line 35
    iget-object v0, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mPendingRequestHelper:Lco/vine/android/PendingRequestHelper;

    return-object v0
.end method

.method static synthetic access$100(Lco/vine/android/widget/UsersMemoryAdapterHelper;)Lco/vine/android/UsersMemoryAdapter;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/widget/UsersMemoryAdapterHelper;

    .prologue
    .line 35
    iget-object v0, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mAdapter:Lco/vine/android/UsersMemoryAdapter;

    return-object v0
.end method

.method static synthetic access$202(Lco/vine/android/widget/UsersMemoryAdapterHelper;I)I
    .locals 0
    .param p0, "x0"    # Lco/vine/android/widget/UsersMemoryAdapterHelper;
    .param p1, "x1"    # I

    .prologue
    .line 35
    iput p1, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mNextPage:I

    return p1
.end method

.method static synthetic access$302(Lco/vine/android/widget/UsersMemoryAdapterHelper;J)J
    .locals 0
    .param p0, "x0"    # Lco/vine/android/widget/UsersMemoryAdapterHelper;
    .param p1, "x1"    # J

    .prologue
    .line 35
    iput-wide p1, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mAnchor:J

    return-wide p1
.end method

.method static synthetic access$400(Lco/vine/android/widget/UsersMemoryAdapterHelper;)Lco/vine/android/Friendships;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/widget/UsersMemoryAdapterHelper;

    .prologue
    .line 35
    iget-object v0, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mFriendships:Lco/vine/android/Friendships;

    return-object v0
.end method

.method static synthetic access$500(Lco/vine/android/widget/UsersMemoryAdapterHelper;)Lco/vine/android/BaseFragment;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/widget/UsersMemoryAdapterHelper;

    .prologue
    .line 35
    iget-object v0, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mFragment:Lco/vine/android/BaseFragment;

    return-object v0
.end method

.method private fetchContent(I)V
    .locals 8
    .param p1, "fetchType"    # I

    .prologue
    .line 167
    iget-object v0, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mPendingRequestHelper:Lco/vine/android/PendingRequestHelper;

    invoke-virtual {v0, p1}, Lco/vine/android/PendingRequestHelper;->hasPendingRequest(I)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 220
    :cond_0
    :goto_0
    return-void

    .line 170
    :cond_1
    const/4 v7, 0x0

    .line 173
    .local v7, "reqId":Ljava/lang/String;
    packed-switch p1, :pswitch_data_0

    .line 187
    :goto_1
    iget v0, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mUsersType:I

    sparse-switch v0, :sswitch_data_0

    .line 216
    :goto_2
    if-eqz v7, :cond_0

    .line 217
    iget-object v0, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mPendingRequestHelper:Lco/vine/android/PendingRequestHelper;

    invoke-virtual {v0, p1}, Lco/vine/android/PendingRequestHelper;->showProgress(I)V

    .line 218
    iget-object v0, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mPendingRequestHelper:Lco/vine/android/PendingRequestHelper;

    invoke-virtual {v0, v7, p1}, Lco/vine/android/PendingRequestHelper;->addRequest(Ljava/lang/String;I)Ljava/lang/String;

    goto :goto_0

    .line 177
    :pswitch_0
    const/4 v0, 0x1

    iput v0, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mNextPage:I

    .line 178
    iget-wide v0, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mOriginalAnchor:J

    iput-wide v0, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mAnchor:J

    goto :goto_1

    .line 189
    :sswitch_0
    iget-object v0, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mAppController:Lco/vine/android/client/AppController;

    iget-wide v1, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mProfileId:J

    iget v3, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mNextPage:I

    iget-wide v4, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mAnchor:J

    invoke-virtual/range {v0 .. v5}, Lco/vine/android/client/AppController;->fetchFollowing(JIJ)Ljava/lang/String;

    move-result-object v7

    .line 190
    goto :goto_2

    .line 193
    :sswitch_1
    iget-object v0, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mAppController:Lco/vine/android/client/AppController;

    iget-wide v1, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mProfileId:J

    iget v3, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mNextPage:I

    iget-wide v4, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mAnchor:J

    invoke-virtual/range {v0 .. v5}, Lco/vine/android/client/AppController;->fetchFollowers(JIJ)Ljava/lang/String;

    move-result-object v7

    .line 194
    goto :goto_2

    .line 197
    :sswitch_2
    iget-object v0, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mAppController:Lco/vine/android/client/AppController;

    iget-object v1, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v1}, Lco/vine/android/client/AppController;->getActiveSession()Lco/vine/android/client/Session;

    move-result-object v1

    iget-wide v2, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mPostId:J

    iget v4, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mNextPage:I

    iget-wide v5, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mAnchor:J

    invoke-virtual/range {v0 .. v6}, Lco/vine/android/client/AppController;->fetchPostLikers(Lco/vine/android/client/Session;JIJ)Ljava/lang/String;

    move-result-object v7

    .line 199
    goto :goto_2

    .line 202
    :sswitch_3
    iget-object v0, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mAppController:Lco/vine/android/client/AppController;

    iget-object v1, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v1}, Lco/vine/android/client/AppController;->getActiveSession()Lco/vine/android/client/Session;

    move-result-object v1

    iget-wide v2, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mPostId:J

    iget v4, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mNextPage:I

    iget-wide v5, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mAnchor:J

    invoke-virtual/range {v0 .. v6}, Lco/vine/android/client/AppController;->fetchReviners(Lco/vine/android/client/Session;JIJ)Ljava/lang/String;

    move-result-object v7

    .line 204
    goto :goto_2

    .line 207
    :sswitch_4
    iget-object v0, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mAppController:Lco/vine/android/client/AppController;

    iget-object v1, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v1}, Lco/vine/android/client/AppController;->getActiveSession()Lco/vine/android/client/Session;

    move-result-object v1

    iget-wide v2, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mNotificationId:J

    iget v4, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mNextPage:I

    iget-wide v5, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mAnchor:J

    invoke-virtual/range {v0 .. v6}, Lco/vine/android/client/AppController;->fetchNotificationUsers(Lco/vine/android/client/Session;JIJ)Ljava/lang/String;

    move-result-object v7

    .line 209
    goto :goto_2

    .line 173
    :pswitch_data_0
    .packed-switch 0x2
        :pswitch_0
        :pswitch_0
        :pswitch_0
    .end packed-switch

    .line 187
    :sswitch_data_0
    .sparse-switch
        0x1 -> :sswitch_0
        0x2 -> :sswitch_1
        0x5 -> :sswitch_2
        0x9 -> :sswitch_3
        0xc -> :sswitch_4
    .end sparse-switch
.end method


# virtual methods
.method public getAdapter(Landroid/app/Activity;Lco/vine/android/client/AppController;)Lco/vine/android/UsersMemoryAdapter;
    .locals 6
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "appController"    # Lco/vine/android/client/AppController;

    .prologue
    .line 95
    iget-object v0, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mAdapter:Lco/vine/android/UsersMemoryAdapter;

    if-nez v0, :cond_0

    .line 96
    new-instance v0, Lco/vine/android/UsersMemoryAdapter;

    const/4 v3, 0x1

    iget-object v5, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mFriendships:Lco/vine/android/Friendships;

    move-object v1, p1

    move-object v2, p2

    move-object v4, p0

    invoke-direct/range {v0 .. v5}, Lco/vine/android/UsersMemoryAdapter;-><init>(Landroid/content/Context;Lco/vine/android/client/AppController;ZLandroid/view/View$OnClickListener;Lco/vine/android/Friendships;)V

    iput-object v0, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mAdapter:Lco/vine/android/UsersMemoryAdapter;

    .line 98
    iput-object p2, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mAppController:Lco/vine/android/client/AppController;

    .line 100
    :cond_0
    iget-object v0, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mAdapter:Lco/vine/android/UsersMemoryAdapter;

    return-object v0
.end method

.method public getAppSessionListener()Lco/vine/android/client/AppSessionListener;
    .locals 1

    .prologue
    .line 104
    iget-object v0, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mAppSessionListener:Lco/vine/android/widget/UsersMemoryAdapterHelper$UsersAppSessionListener;

    if-nez v0, :cond_0

    .line 105
    new-instance v0, Lco/vine/android/widget/UsersMemoryAdapterHelper$UsersAppSessionListener;

    invoke-direct {v0, p0}, Lco/vine/android/widget/UsersMemoryAdapterHelper$UsersAppSessionListener;-><init>(Lco/vine/android/widget/UsersMemoryAdapterHelper;)V

    iput-object v0, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mAppSessionListener:Lco/vine/android/widget/UsersMemoryAdapterHelper$UsersAppSessionListener;

    .line 107
    :cond_0
    iget-object v0, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mAppSessionListener:Lco/vine/android/widget/UsersMemoryAdapterHelper$UsersAppSessionListener;

    return-object v0
.end method

.method public getPendingRequestHelper()Lco/vine/android/PendingRequestHelper;
    .locals 1

    .prologue
    .line 158
    iget-object v0, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mPendingRequestHelper:Lco/vine/android/PendingRequestHelper;

    return-object v0
.end method

.method public onClick(Landroid/view/View;)V
    .locals 9
    .param p1, "view"    # Landroid/view/View;

    .prologue
    const/4 v4, 0x0

    .line 224
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 243
    :cond_0
    :goto_0
    return-void

    .line 226
    :pswitch_0
    invoke-virtual {p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lco/vine/android/FollowButtonViewHolder;

    .line 227
    .local v7, "holder":Lco/vine/android/FollowButtonViewHolder;
    if-eqz v7, :cond_0

    iget-object v0, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mFriendships:Lco/vine/android/Friendships;

    if-eqz v0, :cond_0

    .line 228
    iget-boolean v0, v7, Lco/vine/android/FollowButtonViewHolder;->following:Z

    if-nez v0, :cond_1

    .line 229
    iget-object v0, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mPendingRequestHelper:Lco/vine/android/PendingRequestHelper;

    iget-object v1, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mAppController:Lco/vine/android/client/AppController;

    iget-object v2, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v2}, Lco/vine/android/client/AppController;->getActiveSession()Lco/vine/android/client/Session;

    move-result-object v2

    iget-wide v5, v7, Lco/vine/android/FollowButtonViewHolder;->userId:J

    invoke-virtual {v1, v2, v5, v6, v4}, Lco/vine/android/client/AppController;->followUser(Lco/vine/android/client/Session;JZ)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lco/vine/android/PendingRequestHelper;->addRequest(Ljava/lang/String;)Ljava/lang/String;

    .line 231
    iget-object v0, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mFriendships:Lco/vine/android/Friendships;

    iget-wide v1, v7, Lco/vine/android/FollowButtonViewHolder;->userId:J

    invoke-virtual {v0, v1, v2}, Lco/vine/android/Friendships;->addFollowing(J)V

    .line 232
    iget-object v0, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mAdapter:Lco/vine/android/UsersMemoryAdapter;

    invoke-virtual {v0}, Lco/vine/android/UsersMemoryAdapter;->notifyDataSetChanged()V

    goto :goto_0

    .line 234
    :cond_1
    iget-object v8, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mPendingRequestHelper:Lco/vine/android/PendingRequestHelper;

    iget-object v0, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mAppController:Lco/vine/android/client/AppController;

    iget-object v1, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v1}, Lco/vine/android/client/AppController;->getActiveSession()Lco/vine/android/client/Session;

    move-result-object v1

    iget-wide v2, v7, Lco/vine/android/FollowButtonViewHolder;->userId:J

    iget-wide v5, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mProfileId:J

    invoke-virtual/range {v0 .. v6}, Lco/vine/android/client/AppController;->unfollowUser(Lco/vine/android/client/Session;JZJ)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v8, v0}, Lco/vine/android/PendingRequestHelper;->addRequest(Ljava/lang/String;)Ljava/lang/String;

    .line 236
    iget-object v0, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mFriendships:Lco/vine/android/Friendships;

    iget-wide v1, v7, Lco/vine/android/FollowButtonViewHolder;->userId:J

    invoke-virtual {v0, v1, v2}, Lco/vine/android/Friendships;->removeFollowing(J)V

    .line 237
    iget-object v0, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mAdapter:Lco/vine/android/UsersMemoryAdapter;

    invoke-virtual {v0}, Lco/vine/android/UsersMemoryAdapter;->notifyDataSetChanged()V

    goto :goto_0

    .line 224
    nop

    :pswitch_data_0
    .packed-switch 0x7f0a022d
        :pswitch_0
    .end packed-switch
.end method

.method public onCreate(Landroid/os/Bundle;Landroid/os/Bundle;Z)V
    .locals 4
    .param p1, "args"    # Landroid/os/Bundle;
    .param p2, "savedInstanceState"    # Landroid/os/Bundle;
    .param p3, "refreshable"    # Z

    .prologue
    const-wide/16 v2, -0x1

    .line 73
    const-string v0, "u_type"

    const/4 v1, -0x1

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v0

    iput v0, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mUsersType:I

    .line 74
    const-string v0, "p_id"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v0

    iput-wide v0, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mProfileId:J

    .line 75
    const-string v0, "post_id"

    invoke-virtual {p1, v0, v2, v3}, Landroid/os/Bundle;->getLong(Ljava/lang/String;J)J

    move-result-wide v0

    iput-wide v0, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mPostId:J

    .line 76
    const-string v0, "notification_id"

    invoke-virtual {p1, v0, v2, v3}, Landroid/os/Bundle;->getLong(Ljava/lang/String;J)J

    move-result-wide v0

    iput-wide v0, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mNotificationId:J

    .line 77
    const-string v0, "anchor"

    invoke-virtual {p1, v0, v2, v3}, Landroid/os/Bundle;->getLong(Ljava/lang/String;J)J

    move-result-wide v0

    iput-wide v0, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mOriginalAnchor:J

    .line 78
    iput-boolean p3, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mRefreshable:Z

    .line 80
    if-eqz p2, :cond_2

    .line 81
    iget-object v0, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mLoadFalgsTag:Ljava/lang/String;

    invoke-virtual {p2, v0}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mLoadFlags:I

    .line 82
    iget-object v0, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mFriendshipsTag:Ljava/lang/String;

    invoke-virtual {p2, v0}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 83
    iget-object v0, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mFriendshipsTag:Ljava/lang/String;

    invoke-virtual {p2, v0}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Lco/vine/android/Friendships;

    iput-object v0, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mFriendships:Lco/vine/android/Friendships;

    .line 85
    :cond_0
    iget-object v0, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mFriendships:Lco/vine/android/Friendships;

    if-nez v0, :cond_1

    .line 86
    new-instance v0, Lco/vine/android/Friendships;

    invoke-direct {v0}, Lco/vine/android/Friendships;-><init>()V

    iput-object v0, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mFriendships:Lco/vine/android/Friendships;

    .line 92
    :cond_1
    :goto_0
    return-void

    .line 89
    :cond_2
    const/4 v0, 0x0

    iput v0, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mLoadFlags:I

    .line 90
    new-instance v0, Lco/vine/android/Friendships;

    invoke-direct {v0}, Lco/vine/android/Friendships;-><init>()V

    iput-object v0, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mFriendships:Lco/vine/android/Friendships;

    goto :goto_0
.end method

.method public onListItemClick(J)V
    .locals 2
    .param p1, "id"    # J

    .prologue
    .line 152
    const-wide/16 v0, 0x0

    cmp-long v0, p1, v0

    if-lez v0, :cond_0

    .line 153
    iget-object v0, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mFragment:Lco/vine/android/BaseFragment;

    invoke-virtual {v0}, Lco/vine/android/BaseFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    iget-object v1, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mFlurryEventSource:Ljava/lang/String;

    invoke-static {v0, p1, p2, v1}, Lco/vine/android/ProfileActivity;->start(Landroid/content/Context;JLjava/lang/String;)V

    .line 155
    :cond_0
    return-void
.end method

.method public onResume()V
    .locals 1

    .prologue
    .line 111
    iget-object v0, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mAdapter:Lco/vine/android/UsersMemoryAdapter;

    invoke-virtual {v0}, Lco/vine/android/UsersMemoryAdapter;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mFetched:Z

    if-nez v0, :cond_0

    .line 112
    const/4 v0, 0x3

    invoke-direct {p0, v0}, Lco/vine/android/widget/UsersMemoryAdapterHelper;->fetchContent(I)V

    .line 114
    :cond_0
    return-void
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "outState"    # Landroid/os/Bundle;

    .prologue
    .line 147
    iget-object v0, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mFriendshipsTag:Ljava/lang/String;

    iget-object v1, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mFriendships:Lco/vine/android/Friendships;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 148
    iget-object v0, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mLoadFalgsTag:Ljava/lang/String;

    iget v1, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mLoadFlags:I

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 149
    return-void
.end method

.method public onScroll(Lco/vine/android/ListState;III)V
    .locals 2
    .param p1, "listState"    # Lco/vine/android/ListState;
    .param p2, "firstVisibleItem"    # I
    .param p3, "visibleItemCount"    # I
    .param p4, "totalItemCount"    # I

    .prologue
    .line 126
    iput p2, p1, Lco/vine/android/ListState;->firstVisibleItem:I

    .line 127
    iput p3, p1, Lco/vine/android/ListState;->visibleItemCount:I

    .line 128
    iput p4, p1, Lco/vine/android/ListState;->totalItemCount:I

    .line 130
    if-nez p3, :cond_1

    .line 144
    :cond_0
    :goto_0
    return-void

    .line 134
    :cond_1
    if-lez p2, :cond_0

    iget-object v1, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mAdapter:Lco/vine/android/UsersMemoryAdapter;

    if-eqz v1, :cond_0

    .line 135
    add-int v0, p2, p3

    .line 137
    .local v0, "position":I
    add-int/lit8 v1, p4, -0x1

    if-lt v0, v1, :cond_0

    iget-object v1, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mAdapter:Lco/vine/android/UsersMemoryAdapter;

    invoke-virtual {v1}, Lco/vine/android/UsersMemoryAdapter;->getCount()I

    move-result v1

    if-lez v1, :cond_0

    .line 138
    iget-boolean v1, p1, Lco/vine/android/ListState;->hasNewScrollState:Z

    if-eqz v1, :cond_0

    .line 139
    const/4 v1, 0x0

    iput-boolean v1, p1, Lco/vine/android/ListState;->hasNewScrollState:Z

    .line 140
    invoke-virtual {p0}, Lco/vine/android/widget/UsersMemoryAdapterHelper;->onScrollLastItem()V

    goto :goto_0
.end method

.method public onScrollLastItem()V
    .locals 2

    .prologue
    .line 117
    iget-boolean v0, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mRefreshable:Z

    if-eqz v0, :cond_0

    iget v0, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mNextPage:I

    if-lez v0, :cond_0

    iget-object v0, p0, Lco/vine/android/widget/UsersMemoryAdapterHelper;->mAdapter:Lco/vine/android/UsersMemoryAdapter;

    invoke-virtual {v0}, Lco/vine/android/UsersMemoryAdapter;->getCount()I

    move-result v0

    const/16 v1, 0x190

    if-gt v0, v1, :cond_0

    .line 119
    const/4 v0, 0x1

    invoke-direct {p0, v0}, Lco/vine/android/widget/UsersMemoryAdapterHelper;->fetchContent(I)V

    .line 121
    :cond_0
    return-void
.end method

.method public refresh()V
    .locals 1

    .prologue
    .line 246
    const/4 v0, 0x2

    invoke-direct {p0, v0}, Lco/vine/android/widget/UsersMemoryAdapterHelper;->fetchContent(I)V

    .line 247
    return-void
.end method
