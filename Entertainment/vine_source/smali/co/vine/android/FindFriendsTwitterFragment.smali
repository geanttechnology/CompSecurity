.class public Lco/vine/android/FindFriendsTwitterFragment;
.super Lco/vine/android/BaseCursorListFragment;
.source "FindFriendsTwitterFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;
.implements Landroid/widget/AdapterView$OnItemClickListener;
.implements Lco/vine/android/FindFriendsNUXActivity$FilterableFriendsList;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/FindFriendsTwitterFragment$FriendsListener;
    }
.end annotation


# static fields
.field public static final ARG_FROM_SIGN_UP:Ljava/lang/String; = "from_sign_up"

.field private static final EVENT_SOURCE_TITLE:Ljava/lang/String; = "Find Friends: Twitter"

.field protected static final LOADER_ID_FILTER:I = 0x1

.field private static final STATE_FETCHED:Ljava/lang/String; = "fetch"

.field private static final STATE_FRIENDSHIPS:Ljava/lang/String; = "friendships"

.field private static final STATE_FROM_SIGN_UP:Ljava/lang/String; = "from_sign_up"


# instance fields
.field private mActivity:Lco/vine/android/FindFriendsNUXActivity;

.field private mBold:[Landroid/text/style/StyleSpan;

.field private mContactsCountContainer:Landroid/widget/RelativeLayout;

.field private mContactsText:Landroid/widget/TextView;

.field private mFetched:Z

.field private mFilterLoaderIsReady:Z

.field private mFilterRunnable:Ljava/lang/Runnable;

.field private mFriendships:Lco/vine/android/Friendships;

.field private mFromSignup:Z

.field private mNewFollowsCount:I

.field private mProjection:[Ljava/lang/String;

.field private volatile mSearchQuery:Ljava/lang/String;

.field private mSecret:Ljava/lang/String;

.field private mSelectAllToggle:Landroid/widget/TextView;

.field private mSelected:Z

.field private mSortOrder:Ljava/lang/String;

.field private mToken:Ljava/lang/String;

.field private mTwitter:Lcom/twitter/android/sdk/Twitter;

.field private mTwitterFriends:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VineUser;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 51
    invoke-direct {p0}, Lco/vine/android/BaseCursorListFragment;-><init>()V

    .line 381
    new-instance v0, Lco/vine/android/FindFriendsTwitterFragment$1;

    invoke-direct {v0, p0}, Lco/vine/android/FindFriendsTwitterFragment$1;-><init>(Lco/vine/android/FindFriendsTwitterFragment;)V

    iput-object v0, p0, Lco/vine/android/FindFriendsTwitterFragment;->mFilterRunnable:Ljava/lang/Runnable;

    .line 398
    return-void
.end method

.method static synthetic access$000(Lco/vine/android/FindFriendsTwitterFragment;)Z
    .locals 1
    .param p0, "x0"    # Lco/vine/android/FindFriendsTwitterFragment;

    .prologue
    .line 51
    iget-boolean v0, p0, Lco/vine/android/FindFriendsTwitterFragment;->mFilterLoaderIsReady:Z

    return v0
.end method

.method static synthetic access$002(Lco/vine/android/FindFriendsTwitterFragment;Z)Z
    .locals 0
    .param p0, "x0"    # Lco/vine/android/FindFriendsTwitterFragment;
    .param p1, "x1"    # Z

    .prologue
    .line 51
    iput-boolean p1, p0, Lco/vine/android/FindFriendsTwitterFragment;->mFilterLoaderIsReady:Z

    return p1
.end method

.method static synthetic access$100(Lco/vine/android/FindFriendsTwitterFragment;)Z
    .locals 1
    .param p0, "x0"    # Lco/vine/android/FindFriendsTwitterFragment;

    .prologue
    .line 51
    iget-boolean v0, p0, Lco/vine/android/FindFriendsTwitterFragment;->mFromSignup:Z

    return v0
.end method

.method static synthetic access$200(Lco/vine/android/FindFriendsTwitterFragment;)Landroid/widget/RelativeLayout;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/FindFriendsTwitterFragment;

    .prologue
    .line 51
    iget-object v0, p0, Lco/vine/android/FindFriendsTwitterFragment;->mContactsCountContainer:Landroid/widget/RelativeLayout;

    return-object v0
.end method

.method static synthetic access$300(Lco/vine/android/FindFriendsTwitterFragment;)Landroid/widget/TextView;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/FindFriendsTwitterFragment;

    .prologue
    .line 51
    iget-object v0, p0, Lco/vine/android/FindFriendsTwitterFragment;->mContactsText:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$400(Lco/vine/android/FindFriendsTwitterFragment;)Z
    .locals 1
    .param p0, "x0"    # Lco/vine/android/FindFriendsTwitterFragment;

    .prologue
    .line 51
    iget-boolean v0, p0, Lco/vine/android/FindFriendsTwitterFragment;->mSelected:Z

    return v0
.end method

.method static synthetic access$500(Lco/vine/android/FindFriendsTwitterFragment;)Landroid/widget/TextView;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/FindFriendsTwitterFragment;

    .prologue
    .line 51
    iget-object v0, p0, Lco/vine/android/FindFriendsTwitterFragment;->mSelectAllToggle:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$600(Lco/vine/android/FindFriendsTwitterFragment;)Lco/vine/android/Friendships;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/FindFriendsTwitterFragment;

    .prologue
    .line 51
    iget-object v0, p0, Lco/vine/android/FindFriendsTwitterFragment;->mFriendships:Lco/vine/android/Friendships;

    return-object v0
.end method

.method static synthetic access$700(Lco/vine/android/FindFriendsTwitterFragment;)Lco/vine/android/FindFriendsNUXActivity;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/FindFriendsTwitterFragment;

    .prologue
    .line 51
    iget-object v0, p0, Lco/vine/android/FindFriendsTwitterFragment;->mActivity:Lco/vine/android/FindFriendsNUXActivity;

    return-object v0
.end method

.method static synthetic access$800(Lco/vine/android/FindFriendsTwitterFragment;)Ljava/util/ArrayList;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/FindFriendsTwitterFragment;

    .prologue
    .line 51
    iget-object v0, p0, Lco/vine/android/FindFriendsTwitterFragment;->mTwitterFriends:Ljava/util/ArrayList;

    return-object v0
.end method

.method private fetchContent(I)V
    .locals 8
    .param p1, "fetchType"    # I

    .prologue
    const/4 v6, 0x1

    .line 220
    iput-boolean v6, p0, Lco/vine/android/FindFriendsTwitterFragment;->mFetched:Z

    .line 222
    packed-switch p1, :pswitch_data_0

    .line 251
    :goto_0
    return-void

    .line 224
    :pswitch_0
    invoke-virtual {p0}, Lco/vine/android/FindFriendsTwitterFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    .line 225
    .local v1, "activity":Landroid/app/Activity;
    iget-object v4, p0, Lco/vine/android/FindFriendsTwitterFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v4}, Lco/vine/android/client/AppController;->getActiveSession()Lco/vine/android/client/Session;

    move-result-object v4

    invoke-virtual {v4}, Lco/vine/android/client/Session;->getLoginEmail()Ljava/lang/String;

    move-result-object v3

    .line 226
    .local v3, "uniqueLogin":Ljava/lang/String;
    invoke-static {v1, v3}, Lco/vine/android/client/VineAccountHelper;->getAccount(Landroid/content/Context;Ljava/lang/String;)Landroid/accounts/Account;

    move-result-object v0

    .line 227
    .local v0, "ac":Landroid/accounts/Account;
    if-nez v0, :cond_0

    .line 228
    new-instance v4, Lco/vine/android/VineLoggingException;

    const-string v5, "Find Friends Twitter account was null"

    invoke-direct {v4, v5}, Lco/vine/android/VineLoggingException;-><init>(Ljava/lang/String;)V

    const-string v5, "Find Friends Twitter account was null. UniqueLogin: {} "

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    aput-object v3, v6, v7

    invoke-static {v4, v5, v6}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 231
    const v4, 0x7f0e00ee

    invoke-static {v1, v4}, Lco/vine/android/util/Util;->showCenteredToast(Landroid/content/Context;I)V

    goto :goto_0

    .line 235
    :cond_0
    invoke-virtual {p0}, Lco/vine/android/FindFriendsTwitterFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v4

    invoke-static {v4}, Landroid/accounts/AccountManager;->get(Landroid/content/Context;)Landroid/accounts/AccountManager;

    move-result-object v2

    .line 237
    .local v2, "am":Landroid/accounts/AccountManager;
    const-string v4, "account_t_token"

    invoke-virtual {v2, v0, v4}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lco/vine/android/FindFriendsTwitterFragment;->mToken:Ljava/lang/String;

    .line 238
    const-string v4, "account_t_secret"

    invoke-virtual {v2, v0, v4}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lco/vine/android/FindFriendsTwitterFragment;->mSecret:Ljava/lang/String;

    .line 240
    iget-object v4, p0, Lco/vine/android/FindFriendsTwitterFragment;->mToken:Ljava/lang/String;

    if-eqz v4, :cond_1

    iget-object v4, p0, Lco/vine/android/FindFriendsTwitterFragment;->mSecret:Ljava/lang/String;

    if-nez v4, :cond_2

    .line 241
    :cond_1
    iget-object v4, p0, Lco/vine/android/FindFriendsTwitterFragment;->mTwitter:Lcom/twitter/android/sdk/Twitter;

    invoke-static {v4, v1}, Lco/vine/android/client/AppController;->startTwitterAuthWithFinish(Lcom/twitter/android/sdk/Twitter;Landroid/app/Activity;)V

    goto :goto_0

    .line 243
    :cond_2
    iget-object v4, p0, Lco/vine/android/FindFriendsTwitterFragment;->mToken:Ljava/lang/String;

    iget-object v5, p0, Lco/vine/android/FindFriendsTwitterFragment;->mSecret:Ljava/lang/String;

    invoke-direct {p0, v4, v5}, Lco/vine/android/FindFriendsTwitterFragment;->fetchTwitterFriends(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 222
    nop

    :pswitch_data_0
    .packed-switch 0x3
        :pswitch_0
    .end packed-switch
.end method

.method private fetchTwitterFriends(Ljava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p1, "token"    # Ljava/lang/String;
    .param p2, "secret"    # Ljava/lang/String;

    .prologue
    .line 254
    new-instance v0, Landroid/app/ProgressDialog;

    invoke-virtual {p0}, Lco/vine/android/FindFriendsTwitterFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const v2, 0x7f0f0037

    invoke-direct {v0, v1, v2}, Landroid/app/ProgressDialog;-><init>(Landroid/content/Context;I)V

    .line 256
    .local v0, "dialog":Landroid/app/ProgressDialog;
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/app/ProgressDialog;->setProgress(I)V

    .line 257
    const v1, 0x7f0e00f5

    invoke-virtual {p0, v1}, Lco/vine/android/FindFriendsTwitterFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/app/ProgressDialog;->setMessage(Ljava/lang/CharSequence;)V

    .line 258
    invoke-virtual {v0}, Landroid/app/ProgressDialog;->show()V

    .line 259
    iput-object v0, p0, Lco/vine/android/FindFriendsTwitterFragment;->mProgressDialog:Landroid/app/ProgressDialog;

    .line 260
    iget-object v1, p0, Lco/vine/android/FindFriendsTwitterFragment;->mAppController:Lco/vine/android/client/AppController;

    iget-object v2, p0, Lco/vine/android/FindFriendsTwitterFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v2}, Lco/vine/android/client/AppController;->getActiveSession()Lco/vine/android/client/Session;

    move-result-object v2

    invoke-virtual {v1, v2, p1, p2}, Lco/vine/android/client/AppController;->fetchTwitterFriends(Lco/vine/android/client/Session;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 262
    return-void
.end method

.method private startProfileActivity(J)V
    .locals 3
    .param p1, "userId"    # J

    .prologue
    .line 363
    invoke-virtual {p0}, Lco/vine/android/FindFriendsTwitterFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    const-string v1, "Find Friends: Twitter"

    const/4 v2, 0x0

    invoke-static {v0, p1, p2, v1, v2}, Lco/vine/android/ProfileActivity;->start(Landroid/content/Context;JLjava/lang/String;Z)V

    .line 364
    return-void
.end method


# virtual methods
.method public getFirstItemPosition()Lcom/twitter/android/widget/ItemPosition;
    .locals 1

    .prologue
    .line 181
    const/4 v0, 0x0

    return-object v0
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 7
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 163
    invoke-super {p0, p1}, Lco/vine/android/BaseCursorListFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 164
    iget-object v0, p0, Lco/vine/android/FindFriendsTwitterFragment;->mCursorAdapter:Landroid/support/v4/widget/CursorAdapter;

    if-nez v0, :cond_0

    .line 165
    sget-object v0, Lco/vine/android/provider/VineDatabaseSQL$UsersQuery;->PROJECTION:[Ljava/lang/String;

    iput-object v0, p0, Lco/vine/android/FindFriendsTwitterFragment;->mProjection:[Ljava/lang/String;

    .line 166
    const-string v0, "username ASC"

    iput-object v0, p0, Lco/vine/android/FindFriendsTwitterFragment;->mSortOrder:Ljava/lang/String;

    .line 167
    new-instance v0, Lco/vine/android/UsersAdapter;

    invoke-virtual {p0}, Lco/vine/android/FindFriendsTwitterFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    iget-object v2, p0, Lco/vine/android/FindFriendsTwitterFragment;->mAppController:Lco/vine/android/client/AppController;

    const/4 v3, 0x1

    iget-object v5, p0, Lco/vine/android/FindFriendsTwitterFragment;->mFriendships:Lco/vine/android/Friendships;

    const/4 v6, 0x0

    move-object v4, p0

    invoke-direct/range {v0 .. v6}, Lco/vine/android/UsersAdapter;-><init>(Landroid/content/Context;Lco/vine/android/client/AppController;ZLandroid/view/View$OnClickListener;Lco/vine/android/Friendships;I)V

    iput-object v0, p0, Lco/vine/android/FindFriendsTwitterFragment;->mCursorAdapter:Landroid/support/v4/widget/CursorAdapter;

    .line 170
    :cond_0
    iget-object v0, p0, Lco/vine/android/FindFriendsTwitterFragment;->mListView:Landroid/widget/ListView;

    iget-object v1, p0, Lco/vine/android/FindFriendsTwitterFragment;->mCursorAdapter:Landroid/support/v4/widget/CursorAdapter;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 171
    return-void
.end method

.method public onActivityResult(IILandroid/content/Intent;)V
    .locals 2
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    const/4 v0, -0x1

    .line 266
    packed-switch p1, :pswitch_data_0

    .line 288
    invoke-super {p0, p1, p2, p3}, Lco/vine/android/BaseCursorListFragment;->onActivityResult(IILandroid/content/Intent;)V

    .line 292
    :cond_0
    :goto_0
    return-void

    .line 268
    :pswitch_0
    if-ne p2, v0, :cond_1

    .line 269
    const-string v0, "tk"

    invoke-virtual {p3, v0}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/FindFriendsTwitterFragment;->mToken:Ljava/lang/String;

    .line 270
    const-string v0, "ts"

    invoke-virtual {p3, v0}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/FindFriendsTwitterFragment;->mSecret:Ljava/lang/String;

    .line 271
    iget-object v0, p0, Lco/vine/android/FindFriendsTwitterFragment;->mToken:Ljava/lang/String;

    iget-object v1, p0, Lco/vine/android/FindFriendsTwitterFragment;->mSecret:Ljava/lang/String;

    invoke-direct {p0, v0, v1}, Lco/vine/android/FindFriendsTwitterFragment;->fetchTwitterFriends(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 272
    :cond_1
    if-eqz p2, :cond_0

    .line 273
    invoke-virtual {p0}, Lco/vine/android/FindFriendsTwitterFragment;->dismissDialog()V

    .line 274
    invoke-virtual {p0}, Lco/vine/android/FindFriendsTwitterFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    const v1, 0x7f0e00f0

    invoke-static {v0, v1}, Lco/vine/android/util/Util;->showCenteredToast(Landroid/content/Context;I)V

    goto :goto_0

    .line 280
    :pswitch_1
    if-ne p2, v0, :cond_0

    .line 281
    const-string v0, "token"

    invoke-virtual {p3, v0}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/FindFriendsTwitterFragment;->mToken:Ljava/lang/String;

    .line 282
    const-string v0, "secret"

    invoke-virtual {p3, v0}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/FindFriendsTwitterFragment;->mSecret:Ljava/lang/String;

    .line 283
    iget-object v0, p0, Lco/vine/android/FindFriendsTwitterFragment;->mToken:Ljava/lang/String;

    iget-object v1, p0, Lco/vine/android/FindFriendsTwitterFragment;->mSecret:Ljava/lang/String;

    invoke-direct {p0, v0, v1}, Lco/vine/android/FindFriendsTwitterFragment;->fetchTwitterFriends(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 266
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 1
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    .line 85
    invoke-super {p0, p1}, Lco/vine/android/BaseCursorListFragment;->onAttach(Landroid/app/Activity;)V

    .line 86
    instance-of v0, p1, Lco/vine/android/FindFriendsNUXActivity;

    if-eqz v0, :cond_0

    .line 87
    check-cast p1, Lco/vine/android/FindFriendsNUXActivity;

    .end local p1    # "activity":Landroid/app/Activity;
    iput-object p1, p0, Lco/vine/android/FindFriendsTwitterFragment;->mActivity:Lco/vine/android/FindFriendsNUXActivity;

    .line 89
    :cond_0
    return-void
.end method

.method public onClick(Landroid/view/View;)V
    .locals 6
    .param p1, "view"    # Landroid/view/View;

    .prologue
    const/4 v1, 0x1

    .line 296
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v2

    sparse-switch v2, :sswitch_data_0

    .line 334
    :cond_0
    :goto_0
    return-void

    .line 298
    :sswitch_0
    const/4 v2, 0x3

    invoke-direct {p0, v2}, Lco/vine/android/FindFriendsTwitterFragment;->fetchContent(I)V

    .line 301
    :sswitch_1
    invoke-virtual {p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/FollowButtonViewHolder;

    .line 302
    .local v0, "holder":Lco/vine/android/FollowButtonViewHolder;
    if-eqz v0, :cond_0

    .line 303
    iget-boolean v2, v0, Lco/vine/android/FollowButtonViewHolder;->following:Z

    if-nez v2, :cond_2

    .line 304
    iget-boolean v2, p0, Lco/vine/android/FindFriendsTwitterFragment;->mFromSignup:Z

    if-eqz v2, :cond_1

    .line 305
    iget-object v1, p0, Lco/vine/android/FindFriendsTwitterFragment;->mActivity:Lco/vine/android/FindFriendsNUXActivity;

    iget-wide v2, v0, Lco/vine/android/FollowButtonViewHolder;->userId:J

    invoke-virtual {v1, v2, v3}, Lco/vine/android/FindFriendsNUXActivity;->addUserToFollow(J)V

    .line 310
    :goto_1
    iget-object v1, p0, Lco/vine/android/FindFriendsTwitterFragment;->mFriendships:Lco/vine/android/Friendships;

    iget-wide v2, v0, Lco/vine/android/FollowButtonViewHolder;->userId:J

    invoke-virtual {v1, v2, v3}, Lco/vine/android/Friendships;->addFollowing(J)V

    .line 311
    iget-object v1, p0, Lco/vine/android/FindFriendsTwitterFragment;->mCursorAdapter:Landroid/support/v4/widget/CursorAdapter;

    invoke-virtual {v1}, Landroid/support/v4/widget/CursorAdapter;->notifyDataSetChanged()V

    .line 312
    iget v1, p0, Lco/vine/android/FindFriendsTwitterFragment;->mNewFollowsCount:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lco/vine/android/FindFriendsTwitterFragment;->mNewFollowsCount:I

    goto :goto_0

    .line 307
    :cond_1
    iget-object v2, p0, Lco/vine/android/FindFriendsTwitterFragment;->mAppController:Lco/vine/android/client/AppController;

    iget-object v3, p0, Lco/vine/android/FindFriendsTwitterFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v3}, Lco/vine/android/client/AppController;->getActiveSession()Lco/vine/android/client/Session;

    move-result-object v3

    iget-wide v4, v0, Lco/vine/android/FollowButtonViewHolder;->userId:J

    invoke-virtual {v2, v3, v4, v5, v1}, Lco/vine/android/client/AppController;->followUser(Lco/vine/android/client/Session;JZ)Ljava/lang/String;

    goto :goto_1

    .line 314
    :cond_2
    iget-boolean v2, p0, Lco/vine/android/FindFriendsTwitterFragment;->mFromSignup:Z

    if-eqz v2, :cond_3

    .line 315
    iget-object v1, p0, Lco/vine/android/FindFriendsTwitterFragment;->mActivity:Lco/vine/android/FindFriendsNUXActivity;

    iget-wide v2, v0, Lco/vine/android/FollowButtonViewHolder;->userId:J

    invoke-virtual {v1, v2, v3}, Lco/vine/android/FindFriendsNUXActivity;->removeUserToFollow(J)V

    .line 320
    :goto_2
    iget-object v1, p0, Lco/vine/android/FindFriendsTwitterFragment;->mFriendships:Lco/vine/android/Friendships;

    iget-wide v2, v0, Lco/vine/android/FollowButtonViewHolder;->userId:J

    invoke-virtual {v1, v2, v3}, Lco/vine/android/Friendships;->removeFollowing(J)V

    .line 321
    iget-object v1, p0, Lco/vine/android/FindFriendsTwitterFragment;->mCursorAdapter:Landroid/support/v4/widget/CursorAdapter;

    invoke-virtual {v1}, Landroid/support/v4/widget/CursorAdapter;->notifyDataSetChanged()V

    goto :goto_0

    .line 317
    :cond_3
    iget-object v2, p0, Lco/vine/android/FindFriendsTwitterFragment;->mAppController:Lco/vine/android/client/AppController;

    iget-object v3, p0, Lco/vine/android/FindFriendsTwitterFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v3}, Lco/vine/android/client/AppController;->getActiveSession()Lco/vine/android/client/Session;

    move-result-object v3

    iget-wide v4, v0, Lco/vine/android/FollowButtonViewHolder;->userId:J

    invoke-virtual {v2, v3, v4, v5, v1}, Lco/vine/android/client/AppController;->unfollowUser(Lco/vine/android/client/Session;JZ)Ljava/lang/String;

    goto :goto_2

    .line 327
    .end local v0    # "holder":Lco/vine/android/FollowButtonViewHolder;
    :sswitch_2
    iget-boolean v2, p0, Lco/vine/android/FindFriendsTwitterFragment;->mSelected:Z

    if-nez v2, :cond_4

    :goto_3
    iput-boolean v1, p0, Lco/vine/android/FindFriendsTwitterFragment;->mSelected:Z

    .line 328
    iget-object v1, p0, Lco/vine/android/FindFriendsTwitterFragment;->mActivity:Lco/vine/android/FindFriendsNUXActivity;

    iget-boolean v2, p0, Lco/vine/android/FindFriendsTwitterFragment;->mSelected:Z

    iget-object v3, p0, Lco/vine/android/FindFriendsTwitterFragment;->mTwitterFriends:Ljava/util/ArrayList;

    iget-object v4, p0, Lco/vine/android/FindFriendsTwitterFragment;->mFriendships:Lco/vine/android/Friendships;

    invoke-virtual {v1, v2, v3, v4}, Lco/vine/android/FindFriendsNUXActivity;->toggleFollowAll(ZLjava/util/ArrayList;Lco/vine/android/Friendships;)V

    .line 329
    iget-object v2, p0, Lco/vine/android/FindFriendsTwitterFragment;->mSelectAllToggle:Landroid/widget/TextView;

    iget-boolean v1, p0, Lco/vine/android/FindFriendsTwitterFragment;->mSelected:Z

    if-eqz v1, :cond_5

    const v1, 0x7f0e00b8

    :goto_4
    invoke-virtual {v2, v1}, Landroid/widget/TextView;->setText(I)V

    .line 330
    iget-object v1, p0, Lco/vine/android/FindFriendsTwitterFragment;->mCursorAdapter:Landroid/support/v4/widget/CursorAdapter;

    invoke-virtual {v1}, Landroid/support/v4/widget/CursorAdapter;->notifyDataSetChanged()V

    goto/16 :goto_0

    .line 327
    :cond_4
    const/4 v1, 0x0

    goto :goto_3

    .line 329
    :cond_5
    const v1, 0x7f0e01bc

    goto :goto_4

    .line 296
    nop

    :sswitch_data_0
    .sparse-switch
        0x7f0a00f0 -> :sswitch_2
        0x7f0a00f6 -> :sswitch_0
        0x7f0a022d -> :sswitch_1
    .end sparse-switch
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 5
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v4, 0x1

    .line 93
    invoke-super {p0, p1}, Lco/vine/android/BaseCursorListFragment;->onCreate(Landroid/os/Bundle;)V

    .line 95
    new-array v1, v4, [Landroid/text/style/StyleSpan;

    const/4 v2, 0x0

    new-instance v3, Landroid/text/style/StyleSpan;

    invoke-direct {v3, v4}, Landroid/text/style/StyleSpan;-><init>(I)V

    aput-object v3, v1, v2

    iput-object v1, p0, Lco/vine/android/FindFriendsTwitterFragment;->mBold:[Landroid/text/style/StyleSpan;

    .line 97
    if-eqz p1, :cond_3

    .line 98
    const-string v1, "fetch"

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 99
    const-string v1, "fetch"

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v1

    iput-boolean v1, p0, Lco/vine/android/FindFriendsTwitterFragment;->mFetched:Z

    .line 101
    :cond_0
    const-string v1, "friendships"

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 102
    const-string v1, "friendships"

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v1

    check-cast v1, Lco/vine/android/Friendships;

    iput-object v1, p0, Lco/vine/android/FindFriendsTwitterFragment;->mFriendships:Lco/vine/android/Friendships;

    .line 104
    :cond_1
    const-string v1, "from_sign_up"

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 105
    const-string v1, "from_sign_up"

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v1

    iput-boolean v1, p0, Lco/vine/android/FindFriendsTwitterFragment;->mFromSignup:Z

    .line 116
    :cond_2
    :goto_0
    iget-object v1, p0, Lco/vine/android/FindFriendsTwitterFragment;->mAppController:Lco/vine/android/client/AppController;

    iget-object v2, p0, Lco/vine/android/FindFriendsTwitterFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v2}, Lco/vine/android/client/AppController;->getActiveSession()Lco/vine/android/client/Session;

    move-result-object v2

    const/4 v3, 0x6

    invoke-virtual {v1, v2, v3}, Lco/vine/android/client/AppController;->removeUsers(Lco/vine/android/client/Session;I)Ljava/lang/String;

    .line 119
    new-instance v1, Lcom/twitter/android/sdk/Twitter;

    sget-object v2, Lco/vine/android/client/TwitterVineApp;->API_KEY:Ljava/lang/String;

    sget-object v3, Lco/vine/android/client/TwitterVineApp;->API_SECRET:Ljava/lang/String;

    invoke-direct {v1, v2, v3}, Lcom/twitter/android/sdk/Twitter;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    iput-object v1, p0, Lco/vine/android/FindFriendsTwitterFragment;->mTwitter:Lcom/twitter/android/sdk/Twitter;

    .line 120
    new-instance v1, Lco/vine/android/FindFriendsTwitterFragment$FriendsListener;

    invoke-direct {v1, p0}, Lco/vine/android/FindFriendsTwitterFragment$FriendsListener;-><init>(Lco/vine/android/FindFriendsTwitterFragment;)V

    iput-object v1, p0, Lco/vine/android/FindFriendsTwitterFragment;->mAppSessionListener:Lco/vine/android/client/AppSessionListener;

    .line 121
    iput-boolean v4, p0, Lco/vine/android/FindFriendsTwitterFragment;->mSelected:Z

    .line 122
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    iput-object v1, p0, Lco/vine/android/FindFriendsTwitterFragment;->mTwitterFriends:Ljava/util/ArrayList;

    .line 123
    return-void

    .line 108
    :cond_3
    new-instance v1, Lco/vine/android/Friendships;

    invoke-direct {v1}, Lco/vine/android/Friendships;-><init>()V

    iput-object v1, p0, Lco/vine/android/FindFriendsTwitterFragment;->mFriendships:Lco/vine/android/Friendships;

    .line 109
    invoke-virtual {p0}, Lco/vine/android/FindFriendsTwitterFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    .line 110
    .local v0, "args":Landroid/os/Bundle;
    if-eqz v0, :cond_2

    .line 111
    const-string v1, "from_sign_up"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v1

    iput-boolean v1, p0, Lco/vine/android/FindFriendsTwitterFragment;->mFromSignup:Z

    goto :goto_0
.end method

.method public onCreateLoader(ILandroid/os/Bundle;)Landroid/support/v4/content/Loader;
    .locals 7
    .param p1, "id"    # I
    .param p2, "args"    # Landroid/os/Bundle;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Landroid/os/Bundle;",
            ")",
            "Landroid/support/v4/content/Loader",
            "<",
            "Landroid/database/Cursor;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v4, 0x0

    .line 202
    packed-switch p1, :pswitch_data_0

    .line 212
    sget-object v0, Lco/vine/android/provider/Vine$UserGroupsView;->CONTENT_URI_FIND_FRIENDS_TWITTER:Landroid/net/Uri;

    iget-object v1, p0, Lco/vine/android/FindFriendsTwitterFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v1}, Lco/vine/android/client/AppController;->getActiveId()J

    move-result-wide v5

    invoke-static {v0, v5, v6}, Landroid/content/ContentUris;->withAppendedId(Landroid/net/Uri;J)Landroid/net/Uri;

    move-result-object v2

    .line 214
    .local v2, "uri":Landroid/net/Uri;
    new-instance v0, Landroid/support/v4/content/CursorLoader;

    invoke-virtual {p0}, Lco/vine/android/FindFriendsTwitterFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    iget-object v3, p0, Lco/vine/android/FindFriendsTwitterFragment;->mProjection:[Ljava/lang/String;

    iget-object v6, p0, Lco/vine/android/FindFriendsTwitterFragment;->mSortOrder:Ljava/lang/String;

    move-object v5, v4

    invoke-direct/range {v0 .. v6}, Landroid/support/v4/content/CursorLoader;-><init>(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V

    .end local v2    # "uri":Landroid/net/Uri;
    :goto_0
    return-object v0

    .line 204
    :pswitch_0
    sget-object v0, Lco/vine/android/provider/Vine$UserGroupsView;->CONTENT_URI_FRIENDS_FILTER:Landroid/net/Uri;

    iget-object v1, p0, Lco/vine/android/FindFriendsTwitterFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v1}, Lco/vine/android/client/AppController;->getActiveId()J

    move-result-wide v5

    invoke-static {v0, v5, v6}, Landroid/content/ContentUris;->withAppendedId(Landroid/net/Uri;J)Landroid/net/Uri;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v2

    .line 206
    .local v2, "uri":Landroid/net/Uri$Builder;
    const-string v0, "filter"

    iget-object v1, p0, Lco/vine/android/FindFriendsTwitterFragment;->mSearchQuery:Ljava/lang/String;

    invoke-static {v1}, Landroid/net/Uri;->encode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v2, v0, v1}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 207
    const-string v0, "group_type"

    const/4 v1, 0x6

    invoke-static {v1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v2, v0, v1}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 209
    new-instance v0, Landroid/support/v4/content/CursorLoader;

    invoke-virtual {p0}, Lco/vine/android/FindFriendsTwitterFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v2}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v2

    .end local v2    # "uri":Landroid/net/Uri$Builder;
    iget-object v3, p0, Lco/vine/android/FindFriendsTwitterFragment;->mProjection:[Ljava/lang/String;

    iget-object v6, p0, Lco/vine/android/FindFriendsTwitterFragment;->mSortOrder:Ljava/lang/String;

    move-object v5, v4

    invoke-direct/range {v0 .. v6}, Landroid/support/v4/content/CursorLoader;-><init>(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 202
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
    .end packed-switch
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 5
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 128
    const v2, 0x7f030041

    const/4 v3, 0x0

    invoke-virtual {p1, v2, p2, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    .line 130
    .local v1, "v":Landroid/view/View;
    const v2, 0x102000a

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ListView;

    iput-object v2, p0, Lco/vine/android/FindFriendsTwitterFragment;->mListView:Landroid/widget/ListView;

    .line 131
    iget-object v2, p0, Lco/vine/android/FindFriendsTwitterFragment;->mListView:Landroid/widget/ListView;

    const v3, 0x1020004

    invoke-virtual {v1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/ListView;->setEmptyView(Landroid/view/View;)V

    .line 132
    iget-object v2, p0, Lco/vine/android/FindFriendsTwitterFragment;->mListView:Landroid/widget/ListView;

    invoke-virtual {v2, p0}, Landroid/widget/ListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 133
    const v2, 0x7f0a00ee

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/RelativeLayout;

    iput-object v2, p0, Lco/vine/android/FindFriendsTwitterFragment;->mContactsCountContainer:Landroid/widget/RelativeLayout;

    .line 134
    const v2, 0x7f0a00ef

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    iput-object v2, p0, Lco/vine/android/FindFriendsTwitterFragment;->mContactsText:Landroid/widget/TextView;

    .line 135
    const v2, 0x7f0a00f0

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    iput-object v2, p0, Lco/vine/android/FindFriendsTwitterFragment;->mSelectAllToggle:Landroid/widget/TextView;

    .line 136
    iget-object v2, p0, Lco/vine/android/FindFriendsTwitterFragment;->mSelectAllToggle:Landroid/widget/TextView;

    invoke-virtual {v2, p0}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 138
    const v2, 0x7f0a00f6

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    .line 139
    .local v0, "mActionButton":Landroid/widget/Button;
    iget-object v2, p0, Lco/vine/android/FindFriendsTwitterFragment;->mBold:[Landroid/text/style/StyleSpan;

    const v3, 0x7f0e00ed

    invoke-virtual {p0, v3}, Lco/vine/android/FindFriendsTwitterFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    const/16 v4, 0x22

    invoke-static {v2, v3, v4}, Lco/vine/android/util/Util;->getSpannedText([Ljava/lang/Object;Ljava/lang/String;C)Landroid/text/Spanned;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 143
    invoke-virtual {v0, p0}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 145
    return-object v1
.end method

.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 3
    .param p2, "view"    # Landroid/view/View;
    .param p3, "i"    # I
    .param p4, "l"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView",
            "<*>;",
            "Landroid/view/View;",
            "IJ)V"
        }
    .end annotation

    .prologue
    .line 356
    .local p1, "adapterView":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    invoke-virtual {p2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v1

    instance-of v1, v1, Lco/vine/android/widget/UserViewHolder;

    if-eqz v1, :cond_0

    .line 357
    invoke-virtual {p2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/widget/UserViewHolder;

    .line 358
    .local v0, "h":Lco/vine/android/widget/UserViewHolder;
    iget-wide v1, v0, Lco/vine/android/widget/UserViewHolder;->userId:J

    invoke-direct {p0, v1, v2}, Lco/vine/android/FindFriendsTwitterFragment;->startProfileActivity(J)V

    .line 360
    .end local v0    # "h":Lco/vine/android/widget/UserViewHolder;
    :cond_0
    return-void
.end method

.method public onLoadFinished(Landroid/support/v4/content/Loader;Landroid/database/Cursor;)V
    .locals 2
    .param p2, "cursor"    # Landroid/database/Cursor;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/support/v4/content/Loader",
            "<",
            "Landroid/database/Cursor;",
            ">;",
            "Landroid/database/Cursor;",
            ")V"
        }
    .end annotation

    .prologue
    .line 194
    .local p1, "loader":Landroid/support/v4/content/Loader;, "Landroid/support/v4/content/Loader<Landroid/database/Cursor;>;"
    invoke-super {p0, p1, p2}, Lco/vine/android/BaseCursorListFragment;->onLoadFinished(Landroid/support/v4/content/Loader;Landroid/database/Cursor;)V

    .line 195
    iget-object v0, p0, Lco/vine/android/FindFriendsTwitterFragment;->mActivity:Lco/vine/android/FindFriendsNUXActivity;

    if-eqz v0, :cond_0

    invoke-interface {p2}, Landroid/database/Cursor;->getCount()I

    move-result v0

    if-lez v0, :cond_0

    iget-boolean v0, p0, Lco/vine/android/FindFriendsTwitterFragment;->mFromSignup:Z

    if-eqz v0, :cond_0

    .line 196
    iget-object v0, p0, Lco/vine/android/FindFriendsTwitterFragment;->mActivity:Lco/vine/android/FindFriendsNUXActivity;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lco/vine/android/FindFriendsNUXActivity;->showSearchIcon(Z)V

    .line 198
    :cond_0
    return-void
.end method

.method public bridge synthetic onLoadFinished(Landroid/support/v4/content/Loader;Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Landroid/support/v4/content/Loader;
    .param p2, "x1"    # Ljava/lang/Object;

    .prologue
    .line 51
    check-cast p2, Landroid/database/Cursor;

    .end local p2    # "x1":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lco/vine/android/FindFriendsTwitterFragment;->onLoadFinished(Landroid/support/v4/content/Loader;Landroid/database/Cursor;)V

    return-void
.end method

.method public onLoaderReset(Landroid/support/v4/content/Loader;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/support/v4/content/Loader",
            "<",
            "Landroid/database/Cursor;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 395
    .local p1, "loader":Landroid/support/v4/content/Loader;, "Landroid/support/v4/content/Loader<Landroid/database/Cursor;>;"
    iget-object v0, p0, Lco/vine/android/FindFriendsTwitterFragment;->mCursorAdapter:Landroid/support/v4/widget/CursorAdapter;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/support/v4/widget/CursorAdapter;->swapCursor(Landroid/database/Cursor;)Landroid/database/Cursor;

    .line 396
    return-void
.end method

.method public onMoveAway(I)V
    .locals 3
    .param p1, "newPosition"    # I

    .prologue
    .line 338
    invoke-super {p0, p1}, Lco/vine/android/BaseCursorListFragment;->onMoveAway(I)V

    .line 339
    iget-boolean v1, p0, Lco/vine/android/FindFriendsTwitterFragment;->mFetched:Z

    if-eqz v1, :cond_0

    .line 340
    iget v1, p0, Lco/vine/android/FindFriendsTwitterFragment;->mNewFollowsCount:I

    const/16 v2, 0xf

    if-le v1, v2, :cond_1

    const-string v0, ">15"

    .line 341
    .local v0, "count":Ljava/lang/String;
    :goto_0
    invoke-static {v0}, Lco/vine/android/util/FlurryUtils;->trackTwitterNewFollowingCount(Ljava/lang/String;)V

    .line 343
    .end local v0    # "count":Ljava/lang/String;
    :cond_0
    const/4 v1, 0x0

    iput v1, p0, Lco/vine/android/FindFriendsTwitterFragment;->mNewFollowsCount:I

    .line 344
    return-void

    .line 340
    :cond_1
    iget v1, p0, Lco/vine/android/FindFriendsTwitterFragment;->mNewFollowsCount:I

    invoke-static {v1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public onMoveTo(I)V
    .locals 1
    .param p1, "oldPosition"    # I

    .prologue
    .line 348
    invoke-super {p0, p1}, Lco/vine/android/BaseCursorListFragment;->onMoveTo(I)V

    .line 349
    iget-object v0, p0, Lco/vine/android/FindFriendsTwitterFragment;->mActivity:Lco/vine/android/FindFriendsNUXActivity;

    if-eqz v0, :cond_0

    .line 350
    iget-object v0, p0, Lco/vine/android/FindFriendsTwitterFragment;->mActivity:Lco/vine/android/FindFriendsNUXActivity;

    invoke-virtual {v0}, Lco/vine/android/FindFriendsNUXActivity;->clearSearch()V

    .line 352
    :cond_0
    return-void
.end method

.method public onResume()V
    .locals 0

    .prologue
    .line 175
    invoke-super {p0}, Lco/vine/android/BaseCursorListFragment;->onResume()V

    .line 176
    return-void
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "outState"    # Landroid/os/Bundle;

    .prologue
    .line 186
    invoke-super {p0, p1}, Lco/vine/android/BaseCursorListFragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 187
    const-string v0, "fetch"

    iget-boolean v1, p0, Lco/vine/android/FindFriendsTwitterFragment;->mFetched:Z

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 188
    const-string v0, "friendships"

    iget-object v1, p0, Lco/vine/android/FindFriendsTwitterFragment;->mFriendships:Lco/vine/android/Friendships;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 189
    const-string v0, "from_sign_up"

    iget-boolean v1, p0, Lco/vine/android/FindFriendsTwitterFragment;->mFromSignup:Z

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 190
    return-void
.end method

.method public onTextChanged(Ljava/lang/CharSequence;III)V
    .locals 4
    .param p1, "s"    # Ljava/lang/CharSequence;
    .param p2, "start"    # I
    .param p3, "before"    # I
    .param p4, "count"    # I

    .prologue
    .line 367
    iget-object v0, p0, Lco/vine/android/FindFriendsTwitterFragment;->mHandler:Landroid/os/Handler;

    iget-object v1, p0, Lco/vine/android/FindFriendsTwitterFragment;->mFilterRunnable:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 368
    invoke-interface {p1}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/FindFriendsTwitterFragment;->mSearchQuery:Ljava/lang/String;

    .line 369
    iget-object v0, p0, Lco/vine/android/FindFriendsTwitterFragment;->mSearchQuery:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 370
    iget-object v0, p0, Lco/vine/android/FindFriendsTwitterFragment;->mHandler:Landroid/os/Handler;

    iget-object v1, p0, Lco/vine/android/FindFriendsTwitterFragment;->mFilterRunnable:Ljava/lang/Runnable;

    const-wide/16 v2, 0x12c

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 374
    :goto_0
    return-void

    .line 372
    :cond_0
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lco/vine/android/FindFriendsTwitterFragment;->restartLoader(I)Z

    goto :goto_0
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 4
    .param p1, "view"    # Landroid/view/View;
    .param p2, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 150
    invoke-super {p0, p1, p2}, Lco/vine/android/BaseCursorListFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 151
    iget-boolean v2, p0, Lco/vine/android/FindFriendsTwitterFragment;->mFromSignup:Z

    if-nez v2, :cond_0

    .line 152
    invoke-virtual {p0}, Lco/vine/android/FindFriendsTwitterFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-static {v2}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    .line 153
    .local v0, "inflater":Landroid/view/LayoutInflater;
    const v2, 0x7f03004f

    const/4 v3, 0x0

    invoke-virtual {v0, v2, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v1

    .line 154
    .local v1, "title":Landroid/view/View;
    iget-object v2, p0, Lco/vine/android/FindFriendsTwitterFragment;->mListView:Landroid/widget/ListView;

    invoke-virtual {v2, v1}, Landroid/widget/ListView;->addHeaderView(Landroid/view/View;)V

    .line 156
    const v2, 0x7f0a0110

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    const v3, 0x7f0e00f1

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(I)V

    .line 159
    .end local v0    # "inflater":Landroid/view/LayoutInflater;
    .end local v1    # "title":Landroid/view/View;
    :cond_0
    return-void
.end method

.method public shouldShowSearchIcon()Z
    .locals 1

    .prologue
    .line 378
    iget-object v0, p0, Lco/vine/android/FindFriendsTwitterFragment;->mCursorAdapter:Landroid/support/v4/widget/CursorAdapter;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/FindFriendsTwitterFragment;->mCursorAdapter:Landroid/support/v4/widget/CursorAdapter;

    invoke-virtual {v0}, Landroid/support/v4/widget/CursorAdapter;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
