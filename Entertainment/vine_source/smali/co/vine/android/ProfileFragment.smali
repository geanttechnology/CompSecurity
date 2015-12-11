.class public Lco/vine/android/ProfileFragment;
.super Lco/vine/android/BaseTimelineFragment;
.source "ProfileFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;
.implements Lco/vine/android/ViewOffsetResolver;
.implements Lco/vine/android/widget/SpanClickListener;
.implements Landroid/view/View$OnLongClickListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/ProfileFragment$ColorChangedReceiver;,
        Lco/vine/android/ProfileFragment$PrivateAccountAdapter;,
        Lco/vine/android/ProfileFragment$ProfileListener;
    }
.end annotation


# static fields
.field public static final ARG_FOLLOW_EVENT_SOURCE:Ljava/lang/String; = "event_source"

.field public static final ARG_SHOW_PROFILE_ACTIONS:Ljava/lang/String; = "show_profile_actions"

.field public static final ARG_USER_ID:Ljava/lang/String; = "user_id"

.field public static final ARG_VANITY_URL:Ljava/lang/String; = "vanity_url"

.field private static final EVENT_SOURCE_TITLE:Ljava/lang/String; = "Profile: Tab "

.field public static final FRAGMENT_TAG:Ljava/lang/String; = "profile"

.field public static final MODE_LIKES:I = 0x2

.field public static final MODE_POSTS:I = 0x1

.field private static final STATE_HEADER_ADDED:Ljava/lang/String; = "stated_header_added"

.field private static final STATE_MODE:Ljava/lang/String; = "state_mode"

.field private static final TAG:Ljava/lang/String; = "ProfileFragment"


# instance fields
.field private mBold:Lco/vine/android/widget/TypefacesSpan;

.field private final mColorChangedReceiver:Lco/vine/android/ProfileFragment$ColorChangedReceiver;

.field private mColorChangedReceiverIsRegistered:Z

.field private mCurrentMode:I

.field private mCurrentTab:I

.field private mDrawerListener:Landroid/view/animation/Animation$AnimationListener;

.field protected mFlurryFollowEventSource:Ljava/lang/String;

.field private mFollowHeader:Landroid/widget/LinearLayout;

.field private mHeaderAdded:Z

.field private mHideProfileReposts:Z

.field private mHideRevines:Landroid/view/MenuItem;

.field private mIsMe:Z

.field private mIsUserBlocked:Z

.field private mLikePage:I

.field private mPostPage:I

.field mPrivateAdapter:Lco/vine/android/ProfileFragment$PrivateAccountAdapter;

.field private mProfileBackground:I

.field mProfileHeaderAdapter:Lco/vine/android/ProfileHeaderAdapter;

.field private mSectionAdapter:Lco/vine/android/widget/SectionAdapter;

.field private mShowProfileActions:Z

.field private mTakeFocus:Z

.field private mUser:Lco/vine/android/api/VineUser;

.field private mUserId:J

.field private mUserProfileImageKeyForShortcut:Lco/vine/android/util/image/ImageKey;

.field private mVineGreen:I

.field private mWaitingToStartUserId:J


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    .line 68
    invoke-direct {p0}, Lco/vine/android/BaseTimelineFragment;-><init>()V

    .line 108
    new-instance v0, Lco/vine/android/ProfileFragment$ColorChangedReceiver;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lco/vine/android/ProfileFragment$ColorChangedReceiver;-><init>(Lco/vine/android/ProfileFragment;Lco/vine/android/ProfileFragment$1;)V

    iput-object v0, p0, Lco/vine/android/ProfileFragment;->mColorChangedReceiver:Lco/vine/android/ProfileFragment$ColorChangedReceiver;

    .line 111
    const-wide/16 v0, -0x1

    iput-wide v0, p0, Lco/vine/android/ProfileFragment;->mWaitingToStartUserId:J

    .line 118
    new-instance v0, Lco/vine/android/ProfileFragment$1;

    invoke-direct {v0, p0}, Lco/vine/android/ProfileFragment$1;-><init>(Lco/vine/android/ProfileFragment;)V

    iput-object v0, p0, Lco/vine/android/ProfileFragment;->mDrawerListener:Landroid/view/animation/Animation$AnimationListener;

    .line 1170
    return-void
.end method

.method static synthetic access$100(Lco/vine/android/ProfileFragment;)J
    .locals 2
    .param p0, "x0"    # Lco/vine/android/ProfileFragment;

    .prologue
    .line 68
    iget-wide v0, p0, Lco/vine/android/ProfileFragment;->mWaitingToStartUserId:J

    return-wide v0
.end method

.method static synthetic access$1000(Lco/vine/android/ProfileFragment;)J
    .locals 2
    .param p0, "x0"    # Lco/vine/android/ProfileFragment;

    .prologue
    .line 68
    iget-wide v0, p0, Lco/vine/android/ProfileFragment;->mUserId:J

    return-wide v0
.end method

.method static synthetic access$102(Lco/vine/android/ProfileFragment;J)J
    .locals 0
    .param p0, "x0"    # Lco/vine/android/ProfileFragment;
    .param p1, "x1"    # J

    .prologue
    .line 68
    iput-wide p1, p0, Lco/vine/android/ProfileFragment;->mWaitingToStartUserId:J

    return-wide p1
.end method

.method static synthetic access$1102(Lco/vine/android/ProfileFragment;Z)Z
    .locals 0
    .param p0, "x0"    # Lco/vine/android/ProfileFragment;
    .param p1, "x1"    # Z

    .prologue
    .line 68
    iput-boolean p1, p0, Lco/vine/android/ProfileFragment;->mIsUserBlocked:Z

    return p1
.end method

.method static synthetic access$1200(Lco/vine/android/ProfileFragment;)V
    .locals 0
    .param p0, "x0"    # Lco/vine/android/ProfileFragment;

    .prologue
    .line 68
    invoke-direct {p0}, Lco/vine/android/ProfileFragment;->bindProfileDataAndCounts()V

    return-void
.end method

.method static synthetic access$1300(Lco/vine/android/ProfileFragment;)Landroid/widget/LinearLayout;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/ProfileFragment;

    .prologue
    .line 68
    iget-object v0, p0, Lco/vine/android/ProfileFragment;->mFollowHeader:Landroid/widget/LinearLayout;

    return-object v0
.end method

.method static synthetic access$1400(Lco/vine/android/ProfileFragment;J)V
    .locals 0
    .param p0, "x0"    # Lco/vine/android/ProfileFragment;
    .param p1, "x1"    # J

    .prologue
    .line 68
    invoke-direct {p0, p1, p2}, Lco/vine/android/ProfileFragment;->setUserId(J)V

    return-void
.end method

.method static synthetic access$1502(Lco/vine/android/ProfileFragment;Z)Z
    .locals 0
    .param p0, "x0"    # Lco/vine/android/ProfileFragment;
    .param p1, "x1"    # Z

    .prologue
    .line 68
    iput-boolean p1, p0, Lco/vine/android/ProfileFragment;->mHideProfileReposts:Z

    return p1
.end method

.method static synthetic access$1600(Lco/vine/android/ProfileFragment;)V
    .locals 0
    .param p0, "x0"    # Lco/vine/android/ProfileFragment;

    .prologue
    .line 68
    invoke-direct {p0}, Lco/vine/android/ProfileFragment;->initProfile()V

    return-void
.end method

.method static synthetic access$200(Lco/vine/android/ProfileFragment;)Lco/vine/android/widget/SectionAdapter;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/ProfileFragment;

    .prologue
    .line 68
    iget-object v0, p0, Lco/vine/android/ProfileFragment;->mSectionAdapter:Lco/vine/android/widget/SectionAdapter;

    return-object v0
.end method

.method static synthetic access$202(Lco/vine/android/ProfileFragment;Lco/vine/android/widget/SectionAdapter;)Lco/vine/android/widget/SectionAdapter;
    .locals 0
    .param p0, "x0"    # Lco/vine/android/ProfileFragment;
    .param p1, "x1"    # Lco/vine/android/widget/SectionAdapter;

    .prologue
    .line 68
    iput-object p1, p0, Lco/vine/android/ProfileFragment;->mSectionAdapter:Lco/vine/android/widget/SectionAdapter;

    return-object p1
.end method

.method static synthetic access$300(Lco/vine/android/ProfileFragment;)Z
    .locals 1
    .param p0, "x0"    # Lco/vine/android/ProfileFragment;

    .prologue
    .line 68
    iget-boolean v0, p0, Lco/vine/android/ProfileFragment;->mIsMe:Z

    return v0
.end method

.method static synthetic access$302(Lco/vine/android/ProfileFragment;Z)Z
    .locals 0
    .param p0, "x0"    # Lco/vine/android/ProfileFragment;
    .param p1, "x1"    # Z

    .prologue
    .line 68
    iput-boolean p1, p0, Lco/vine/android/ProfileFragment;->mIsMe:Z

    return p1
.end method

.method static synthetic access$400(Lco/vine/android/ProfileFragment;)Lco/vine/android/api/VineUser;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/ProfileFragment;

    .prologue
    .line 68
    iget-object v0, p0, Lco/vine/android/ProfileFragment;->mUser:Lco/vine/android/api/VineUser;

    return-object v0
.end method

.method static synthetic access$402(Lco/vine/android/ProfileFragment;Lco/vine/android/api/VineUser;)Lco/vine/android/api/VineUser;
    .locals 0
    .param p0, "x0"    # Lco/vine/android/ProfileFragment;
    .param p1, "x1"    # Lco/vine/android/api/VineUser;

    .prologue
    .line 68
    iput-object p1, p0, Lco/vine/android/ProfileFragment;->mUser:Lco/vine/android/api/VineUser;

    return-object p1
.end method

.method static synthetic access$500(Lco/vine/android/ProfileFragment;)Z
    .locals 1
    .param p0, "x0"    # Lco/vine/android/ProfileFragment;

    .prologue
    .line 68
    invoke-direct {p0}, Lco/vine/android/ProfileFragment;->isLocked()Z

    move-result v0

    return v0
.end method

.method static synthetic access$600(Lco/vine/android/ProfileFragment;)Z
    .locals 1
    .param p0, "x0"    # Lco/vine/android/ProfileFragment;

    .prologue
    .line 68
    iget-boolean v0, p0, Lco/vine/android/ProfileFragment;->mTakeFocus:Z

    return v0
.end method

.method static synthetic access$700(Lco/vine/android/ProfileFragment;Z)V
    .locals 0
    .param p0, "x0"    # Lco/vine/android/ProfileFragment;
    .param p1, "x1"    # Z

    .prologue
    .line 68
    invoke-direct {p0, p1}, Lco/vine/android/ProfileFragment;->setup(Z)V

    return-void
.end method

.method static synthetic access$800(Lco/vine/android/ProfileFragment;)Lco/vine/android/util/image/ImageKey;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/ProfileFragment;

    .prologue
    .line 68
    iget-object v0, p0, Lco/vine/android/ProfileFragment;->mUserProfileImageKeyForShortcut:Lco/vine/android/util/image/ImageKey;

    return-object v0
.end method

.method static synthetic access$900(Lco/vine/android/ProfileFragment;Landroid/graphics/Bitmap;)V
    .locals 0
    .param p0, "x0"    # Lco/vine/android/ProfileFragment;
    .param p1, "x1"    # Landroid/graphics/Bitmap;

    .prologue
    .line 68
    invoke-direct {p0, p1}, Lco/vine/android/ProfileFragment;->addProfileShortCut(Landroid/graphics/Bitmap;)V

    return-void
.end method

.method private addProfileShortCut(Landroid/graphics/Bitmap;)V
    .locals 8
    .param p1, "bitmap"    # Landroid/graphics/Bitmap;

    .prologue
    const/16 v7, 0x80

    .line 360
    const/4 v4, 0x0

    iput-object v4, p0, Lco/vine/android/ProfileFragment;->mUserProfileImageKeyForShortcut:Lco/vine/android/util/image/ImageKey;

    .line 361
    invoke-virtual {p0}, Lco/vine/android/ProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    .line 362
    .local v0, "activity":Landroid/support/v4/app/FragmentActivity;
    if-eqz v0, :cond_0

    .line 363
    invoke-static {}, Lco/vine/android/util/FlurryUtils;->trackCreateProfileShortCut()V

    .line 364
    new-instance v3, Landroid/content/Intent;

    const-class v4, Lco/vine/android/StartActivity;

    invoke-direct {v3, v0, v4}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 366
    .local v3, "shortcutIntent":Landroid/content/Intent;
    const-string v4, "android.intent.action.VIEW"

    invoke-virtual {v3, v4}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 367
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "https://vine.co/u/"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, p0, Lco/vine/android/ProfileFragment;->mUser:Lco/vine/android/api/VineUser;

    iget-wide v5, v5, Lco/vine/android/api/VineUser;->userId:J

    invoke-virtual {v4, v5, v6}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;

    .line 368
    const/high16 v4, 0x10000000

    invoke-virtual {v3, v4}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 369
    new-instance v1, Landroid/content/Intent;

    invoke-direct {v1}, Landroid/content/Intent;-><init>()V

    .line 370
    .local v1, "addIntent":Landroid/content/Intent;
    const-string v4, "android.intent.extra.shortcut.INTENT"

    invoke-virtual {v1, v4, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 371
    const-string v4, "android.intent.extra.shortcut.NAME"

    iget-object v5, p0, Lco/vine/android/ProfileFragment;->mUser:Lco/vine/android/api/VineUser;

    iget-object v5, v5, Lco/vine/android/api/VineUser;->username:Ljava/lang/String;

    invoke-virtual {v1, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 372
    const/4 v4, 0x1

    invoke-static {p1, v7, v7, v4}, Landroid/graphics/Bitmap;->createScaledBitmap(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;

    move-result-object v2

    .line 373
    .local v2, "scaledBitmap":Landroid/graphics/Bitmap;
    const-string v4, "android.intent.extra.shortcut.ICON"

    invoke-virtual {v1, v4, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 374
    const-string v4, "com.android.launcher.action.INSTALL_SHORTCUT"

    invoke-virtual {v1, v4}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 375
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    invoke-virtual {v4, v1}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    .line 376
    const v4, 0x7f0e021b

    invoke-static {v0, v4}, Lco/vine/android/util/Util;->showCenteredToast(Landroid/content/Context;I)V

    .line 378
    .end local v1    # "addIntent":Landroid/content/Intent;
    .end local v2    # "scaledBitmap":Landroid/graphics/Bitmap;
    .end local v3    # "shortcutIntent":Landroid/content/Intent;
    :cond_0
    return-void
.end method

.method private bindProfileDataAndCounts()V
    .locals 5

    .prologue
    const/4 v4, 0x0

    const/4 v3, 0x0

    .line 224
    iget-object v1, p0, Lco/vine/android/ProfileFragment;->mUser:Lco/vine/android/api/VineUser;

    if-nez v1, :cond_0

    .line 245
    :goto_0
    return-void

    .line 227
    :cond_0
    iget-boolean v1, p0, Lco/vine/android/ProfileFragment;->mIsMe:Z

    if-eqz v1, :cond_1

    .line 228
    invoke-virtual {p0}, Lco/vine/android/ProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-static {v1}, Lco/vine/android/util/Util;->getDefaultSharedPrefs(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 229
    .local v0, "pref":Landroid/content/SharedPreferences;
    iget-object v1, p0, Lco/vine/android/ProfileFragment;->mUser:Lco/vine/android/api/VineUser;

    const-string v2, "settings_profile_name"

    invoke-interface {v0, v2, v3}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, v1, Lco/vine/android/api/VineUser;->username:Ljava/lang/String;

    .line 230
    iget-object v1, p0, Lco/vine/android/ProfileFragment;->mUser:Lco/vine/android/api/VineUser;

    const-string v2, "settings_profile_description"

    invoke-interface {v0, v2, v3}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, v1, Lco/vine/android/api/VineUser;->description:Ljava/lang/String;

    .line 231
    iget-object v1, p0, Lco/vine/android/ProfileFragment;->mUser:Lco/vine/android/api/VineUser;

    const-string v2, "settings_profile_location"

    invoke-interface {v0, v2, v3}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, v1, Lco/vine/android/api/VineUser;->location:Ljava/lang/String;

    .line 232
    iget-object v1, p0, Lco/vine/android/ProfileFragment;->mUser:Lco/vine/android/api/VineUser;

    const-string v2, "settings_profile_email"

    invoke-interface {v0, v2, v3}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, v1, Lco/vine/android/api/VineUser;->email:Ljava/lang/String;

    .line 233
    iget-object v1, p0, Lco/vine/android/ProfileFragment;->mUser:Lco/vine/android/api/VineUser;

    const-string v2, "settings_profile_phone"

    invoke-interface {v0, v2, v3}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, v1, Lco/vine/android/api/VineUser;->phoneNumber:Ljava/lang/String;

    .line 234
    iget-object v1, p0, Lco/vine/android/ProfileFragment;->mUser:Lco/vine/android/api/VineUser;

    const-string v2, "settings_profile_avatar_url"

    invoke-interface {v0, v2, v3}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, v1, Lco/vine/android/api/VineUser;->avatarUrl:Ljava/lang/String;

    .line 235
    iget-object v1, p0, Lco/vine/android/ProfileFragment;->mUser:Lco/vine/android/api/VineUser;

    const-string v2, "profile_follow_count"

    invoke-interface {v0, v2, v4}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v2

    iput v2, v1, Lco/vine/android/api/VineUser;->followingCount:I

    .line 236
    iget-object v1, p0, Lco/vine/android/ProfileFragment;->mUser:Lco/vine/android/api/VineUser;

    const-string v2, "profile_follower_count"

    invoke-interface {v0, v2, v4}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v2

    iput v2, v1, Lco/vine/android/api/VineUser;->followerCount:I

    .line 237
    iget-object v1, p0, Lco/vine/android/ProfileFragment;->mUser:Lco/vine/android/api/VineUser;

    const-string v2, "profile_authored_post_count"

    invoke-interface {v0, v2, v4}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v2

    iput v2, v1, Lco/vine/android/api/VineUser;->authoredPostCount:I

    .line 238
    iget-object v1, p0, Lco/vine/android/ProfileFragment;->mUser:Lco/vine/android/api/VineUser;

    const-string v2, "profile_post_count"

    invoke-interface {v0, v2, v4}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v2

    iput v2, v1, Lco/vine/android/api/VineUser;->postCount:I

    .line 239
    iget-object v1, p0, Lco/vine/android/ProfileFragment;->mUser:Lco/vine/android/api/VineUser;

    const-string v2, "profile_like_count"

    invoke-interface {v0, v2, v4}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v2

    iput v2, v1, Lco/vine/android/api/VineUser;->likeCount:I

    .line 240
    iget-object v1, p0, Lco/vine/android/ProfileFragment;->mUser:Lco/vine/android/api/VineUser;

    const-string v2, "profile_loop_count"

    const-wide/16 v3, 0x0

    invoke-interface {v0, v2, v3, v4}, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String;J)J

    move-result-wide v2

    iput-wide v2, v1, Lco/vine/android/api/VineUser;->loopCount:J

    .line 241
    iget-object v1, p0, Lco/vine/android/ProfileFragment;->mUser:Lco/vine/android/api/VineUser;

    const-string v2, "profile_background"

    sget v3, Lco/vine/android/Settings;->DEFAULT_PROFILE_COLOR:I

    invoke-interface {v0, v2, v3}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v2

    iput v2, v1, Lco/vine/android/api/VineUser;->profileBackground:I

    .line 244
    .end local v0    # "pref":Landroid/content/SharedPreferences;
    :cond_1
    iget-object v1, p0, Lco/vine/android/ProfileFragment;->mUser:Lco/vine/android/api/VineUser;

    invoke-virtual {p0, v1}, Lco/vine/android/ProfileFragment;->bindUserData(Lco/vine/android/api/VineUser;)V

    goto/16 :goto_0
.end method

.method private dismissDropdown()V
    .locals 8

    .prologue
    .line 749
    invoke-virtual {p0}, Lco/vine/android/ProfileFragment;->getView()Landroid/view/View;

    move-result-object v7

    .line 750
    .local v7, "view":Landroid/view/View;
    if-eqz v7, :cond_1

    .line 751
    const v1, 0x7f0a0196

    invoke-virtual {v7, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    .line 752
    .local v2, "dropDown":Landroid/view/View;
    if-eqz v2, :cond_0

    .line 753
    new-instance v0, Lco/vine/android/animation/HeightAnimation;

    invoke-virtual {p0}, Lco/vine/android/ProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const/4 v3, 0x0

    const-wide/16 v4, 0x12c

    invoke-direct/range {v0 .. v5}, Lco/vine/android/animation/HeightAnimation;-><init>(Landroid/app/Activity;Landroid/view/View;ZJ)V

    .line 754
    .local v0, "anim":Landroid/view/animation/Animation;
    iget-object v1, p0, Lco/vine/android/ProfileFragment;->mDrawerListener:Landroid/view/animation/Animation$AnimationListener;

    invoke-virtual {v0, v1}, Landroid/view/animation/Animation;->setAnimationListener(Landroid/view/animation/Animation$AnimationListener;)V

    .line 755
    invoke-virtual {v2, v0}, Landroid/view/View;->startAnimation(Landroid/view/animation/Animation;)V

    .line 757
    .end local v0    # "anim":Landroid/view/animation/Animation;
    :cond_0
    const v1, 0x7f0a0193

    invoke-virtual {v7, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v6

    .line 758
    .local v6, "arrowImage":Landroid/view/View;
    instance-of v1, v6, Landroid/widget/ImageView;

    if-eqz v1, :cond_1

    .line 759
    check-cast v6, Landroid/widget/ImageView;

    .end local v6    # "arrowImage":Landroid/view/View;
    new-instance v1, Landroid/graphics/PorterDuffColorFilter;

    const/high16 v3, 0x4c000000    # 3.3554432E7f

    sget-object v4, Landroid/graphics/PorterDuff$Mode;->SRC_IN:Landroid/graphics/PorterDuff$Mode;

    invoke-direct {v1, v3, v4}, Landroid/graphics/PorterDuffColorFilter;-><init>(ILandroid/graphics/PorterDuff$Mode;)V

    invoke-virtual {v6, v1}, Landroid/widget/ImageView;->setColorFilter(Landroid/graphics/ColorFilter;)V

    .line 762
    .end local v2    # "dropDown":Landroid/view/View;
    :cond_1
    return-void
.end method

.method private initProfile()V
    .locals 3

    .prologue
    .line 210
    iget-object v0, p0, Lco/vine/android/ProfileFragment;->mUser:Lco/vine/android/api/VineUser;

    if-eqz v0, :cond_0

    .line 211
    invoke-direct {p0}, Lco/vine/android/ProfileFragment;->bindProfileDataAndCounts()V

    .line 212
    const/4 v0, 0x3

    invoke-virtual {p0, v0}, Lco/vine/android/ProfileFragment;->hideProgress(I)V

    .line 220
    :goto_0
    return-void

    .line 214
    :cond_0
    iget-boolean v0, p0, Lco/vine/android/ProfileFragment;->mIsMe:Z

    if-eqz v0, :cond_1

    .line 215
    iget-object v0, p0, Lco/vine/android/ProfileFragment;->mAppController:Lco/vine/android/client/AppController;

    iget-wide v1, p0, Lco/vine/android/ProfileFragment;->mUserId:J

    invoke-virtual {v0, v1, v2}, Lco/vine/android/client/AppController;->fetchUsersMe(J)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lco/vine/android/ProfileFragment;->addRequest(Ljava/lang/String;)Ljava/lang/String;

    goto :goto_0

    .line 217
    :cond_1
    iget-object v0, p0, Lco/vine/android/ProfileFragment;->mAppController:Lco/vine/android/client/AppController;

    iget-wide v1, p0, Lco/vine/android/ProfileFragment;->mUserId:J

    invoke-virtual {v0, v1, v2}, Lco/vine/android/client/AppController;->fetchUser(J)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lco/vine/android/ProfileFragment;->addRequest(Ljava/lang/String;)Ljava/lang/String;

    goto :goto_0
.end method

.method private isLocked()Z
    .locals 1

    .prologue
    .line 789
    iget-object v0, p0, Lco/vine/android/ProfileFragment;->mUser:Lco/vine/android/api/VineUser;

    if-eqz v0, :cond_1

    iget-boolean v0, p0, Lco/vine/android/ProfileFragment;->mIsMe:Z

    if-nez v0, :cond_1

    iget-object v0, p0, Lco/vine/android/ProfileFragment;->mUser:Lco/vine/android/api/VineUser;

    invoke-virtual {v0}, Lco/vine/android/api/VineUser;->isPrivateLocked()Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lco/vine/android/ProfileFragment;->mUser:Lco/vine/android/api/VineUser;

    invoke-virtual {v0}, Lco/vine/android/api/VineUser;->isBlocked()Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private setRevineOptionText(Lco/vine/android/api/VineUser;Z)V
    .locals 3
    .param p1, "user"    # Lco/vine/android/api/VineUser;
    .param p2, "repostsEnabled"    # Z

    .prologue
    const/4 v2, 0x1

    .line 507
    iget-object v0, p0, Lco/vine/android/ProfileFragment;->mHideRevines:Landroid/view/MenuItem;

    .line 509
    .local v0, "hideRevines":Landroid/view/MenuItem;
    if-eqz v0, :cond_0

    .line 510
    if-eqz p1, :cond_1

    invoke-virtual {p1}, Lco/vine/android/api/VineUser;->isFollowing()Z

    move-result v1

    if-nez v1, :cond_1

    .line 511
    const/4 v1, 0x0

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 520
    :cond_0
    :goto_0
    return-void

    .line 512
    :cond_1
    if-eqz p2, :cond_2

    .line 513
    invoke-interface {v0, v2}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 514
    const v1, 0x7f0e010b

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setTitle(I)Landroid/view/MenuItem;

    goto :goto_0

    .line 516
    :cond_2
    invoke-interface {v0, v2}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 517
    const v1, 0x7f0e021c

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setTitle(I)Landroid/view/MenuItem;

    goto :goto_0
.end method

.method private setUserId(J)V
    .locals 3
    .param p1, "userId"    # J

    .prologue
    .line 783
    iput-wide p1, p0, Lco/vine/android/ProfileFragment;->mUserId:J

    .line 784
    iget-object v0, p0, Lco/vine/android/ProfileFragment;->mVineSpanClicker:Lco/vine/android/VineSpanClicker;

    iget-wide v1, p0, Lco/vine/android/ProfileFragment;->mUserId:J

    invoke-virtual {v0, v1, v2}, Lco/vine/android/VineSpanClicker;->setUserId(J)V

    .line 785
    return-void
.end method

.method private setup(Z)V
    .locals 9
    .param p1, "takeFocus"    # Z

    .prologue
    .line 565
    iget-object v0, p0, Lco/vine/android/ProfileFragment;->mSectionAdapter:Lco/vine/android/widget/SectionAdapter;

    if-nez v0, :cond_3

    .line 566
    invoke-direct {p0}, Lco/vine/android/ProfileFragment;->isLocked()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 567
    new-instance v0, Lco/vine/android/ProfileHeaderAdapter;

    invoke-virtual {p0}, Lco/vine/android/ProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    iget-object v2, p0, Lco/vine/android/ProfileFragment;->mAppController:Lco/vine/android/client/AppController;

    const/4 v4, 0x1

    iget-object v3, p0, Lco/vine/android/ProfileFragment;->mUser:Lco/vine/android/api/VineUser;

    invoke-virtual {v3}, Lco/vine/android/api/VineUser;->isBlocked()Z

    move-result v5

    iget-object v6, p0, Lco/vine/android/ProfileFragment;->mFlurryFollowEventSource:Ljava/lang/String;

    iget-boolean v7, p0, Lco/vine/android/ProfileFragment;->mHideProfileReposts:Z

    iget-boolean v8, p0, Lco/vine/android/ProfileFragment;->mShowProfileActions:Z

    move-object v3, p0

    invoke-direct/range {v0 .. v8}, Lco/vine/android/ProfileHeaderAdapter;-><init>(Landroid/content/Context;Lco/vine/android/client/AppController;Lco/vine/android/ProfileFragment;ZZLjava/lang/String;ZZ)V

    iput-object v0, p0, Lco/vine/android/ProfileFragment;->mProfileHeaderAdapter:Lco/vine/android/ProfileHeaderAdapter;

    .line 570
    new-instance v0, Lco/vine/android/ProfileFragment$PrivateAccountAdapter;

    iget-object v1, p0, Lco/vine/android/ProfileFragment;->mUser:Lco/vine/android/api/VineUser;

    invoke-virtual {v1}, Lco/vine/android/api/VineUser;->isBlocked()Z

    move-result v1

    iget-object v2, p0, Lco/vine/android/ProfileFragment;->mUser:Lco/vine/android/api/VineUser;

    invoke-virtual {v2}, Lco/vine/android/api/VineUser;->isPrivateLocked()Z

    move-result v2

    invoke-direct {v0, p0, v1, v2}, Lco/vine/android/ProfileFragment$PrivateAccountAdapter;-><init>(Lco/vine/android/ProfileFragment;ZZ)V

    iput-object v0, p0, Lco/vine/android/ProfileFragment;->mPrivateAdapter:Lco/vine/android/ProfileFragment$PrivateAccountAdapter;

    .line 572
    new-instance v0, Lco/vine/android/widget/SectionAdapter;

    const/4 v1, 0x2

    new-array v1, v1, [Landroid/widget/BaseAdapter;

    const/4 v2, 0x0

    iget-object v3, p0, Lco/vine/android/ProfileFragment;->mProfileHeaderAdapter:Lco/vine/android/ProfileHeaderAdapter;

    aput-object v3, v1, v2

    const/4 v2, 0x1

    iget-object v3, p0, Lco/vine/android/ProfileFragment;->mPrivateAdapter:Lco/vine/android/ProfileFragment$PrivateAccountAdapter;

    aput-object v3, v1, v2

    invoke-direct {v0, v1}, Lco/vine/android/widget/SectionAdapter;-><init>([Landroid/widget/BaseAdapter;)V

    iput-object v0, p0, Lco/vine/android/ProfileFragment;->mSectionAdapter:Lco/vine/android/widget/SectionAdapter;

    .line 574
    iget-object v0, p0, Lco/vine/android/ProfileFragment;->mListView:Landroid/widget/ListView;

    iget-object v1, p0, Lco/vine/android/ProfileFragment;->mSectionAdapter:Lco/vine/android/widget/SectionAdapter;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 575
    iget-object v0, p0, Lco/vine/android/ProfileFragment;->mSectionAdapter:Lco/vine/android/widget/SectionAdapter;

    invoke-virtual {v0}, Lco/vine/android/widget/SectionAdapter;->notifyDataSetChanged()V

    .line 592
    :cond_0
    :goto_0
    return-void

    .line 577
    :cond_1
    new-instance v0, Lco/vine/android/ProfileHeaderAdapter;

    invoke-virtual {p0}, Lco/vine/android/ProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    iget-object v2, p0, Lco/vine/android/ProfileFragment;->mAppController:Lco/vine/android/client/AppController;

    const/4 v4, 0x0

    const/4 v5, 0x0

    iget-object v6, p0, Lco/vine/android/ProfileFragment;->mFlurryFollowEventSource:Ljava/lang/String;

    iget-boolean v7, p0, Lco/vine/android/ProfileFragment;->mHideProfileReposts:Z

    iget-boolean v8, p0, Lco/vine/android/ProfileFragment;->mShowProfileActions:Z

    move-object v3, p0

    invoke-direct/range {v0 .. v8}, Lco/vine/android/ProfileHeaderAdapter;-><init>(Landroid/content/Context;Lco/vine/android/client/AppController;Lco/vine/android/ProfileFragment;ZZLjava/lang/String;ZZ)V

    iput-object v0, p0, Lco/vine/android/ProfileFragment;->mProfileHeaderAdapter:Lco/vine/android/ProfileHeaderAdapter;

    .line 580
    new-instance v0, Lco/vine/android/widget/SectionAdapter;

    const/4 v1, 0x2

    new-array v1, v1, [Landroid/widget/BaseAdapter;

    const/4 v2, 0x0

    iget-object v3, p0, Lco/vine/android/ProfileFragment;->mProfileHeaderAdapter:Lco/vine/android/ProfileHeaderAdapter;

    aput-object v3, v1, v2

    const/4 v2, 0x1

    iget-object v3, p0, Lco/vine/android/ProfileFragment;->mFeedAdapter:Lco/vine/android/widget/GenericTimelineAdapter;

    aput-object v3, v1, v2

    invoke-direct {v0, v1}, Lco/vine/android/widget/SectionAdapter;-><init>([Landroid/widget/BaseAdapter;)V

    iput-object v0, p0, Lco/vine/android/ProfileFragment;->mSectionAdapter:Lco/vine/android/widget/SectionAdapter;

    .line 583
    if-eqz p1, :cond_2

    .line 584
    iget-object v0, p0, Lco/vine/android/ProfileFragment;->mFeedAdapter:Lco/vine/android/widget/GenericTimelineAdapter;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lco/vine/android/widget/GenericTimelineAdapter;->onResume(Z)V

    .line 586
    :cond_2
    iget-object v0, p0, Lco/vine/android/ProfileFragment;->mListView:Landroid/widget/ListView;

    iget-object v1, p0, Lco/vine/android/ProfileFragment;->mSectionAdapter:Lco/vine/android/widget/SectionAdapter;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 587
    iget-object v0, p0, Lco/vine/android/ProfileFragment;->mFeedAdapter:Lco/vine/android/widget/GenericTimelineAdapter;

    invoke-virtual {v0, p0}, Lco/vine/android/widget/GenericTimelineAdapter;->setOffsetResolver(Lco/vine/android/ViewOffsetResolver;)V

    goto :goto_0

    .line 589
    :cond_3
    iget-object v0, p0, Lco/vine/android/ProfileFragment;->mFeedAdapter:Lco/vine/android/widget/GenericTimelineAdapter;

    if-eqz v0, :cond_0

    invoke-direct {p0}, Lco/vine/android/ProfileFragment;->isLocked()Z

    move-result v0

    if-nez v0, :cond_0

    if-eqz p1, :cond_0

    .line 590
    iget-object v0, p0, Lco/vine/android/ProfileFragment;->mFeedAdapter:Lco/vine/android/widget/GenericTimelineAdapter;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lco/vine/android/widget/GenericTimelineAdapter;->onResume(Z)V

    goto :goto_0
.end method


# virtual methods
.method bindUserData(Lco/vine/android/api/VineUser;)V
    .locals 9
    .param p1, "user"    # Lco/vine/android/api/VineUser;

    .prologue
    const/4 v8, 0x0

    .line 248
    iget v6, p1, Lco/vine/android/api/VineUser;->profileBackground:I

    if-gtz v6, :cond_0

    .line 249
    sget v6, Lco/vine/android/Settings;->DEFAULT_PROFILE_COLOR:I

    iput v6, p1, Lco/vine/android/api/VineUser;->profileBackground:I

    .line 251
    :cond_0
    iget v6, p1, Lco/vine/android/api/VineUser;->profileBackground:I

    if-lez v6, :cond_3

    .line 252
    invoke-virtual {p0}, Lco/vine/android/ProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v6

    instance-of v6, v6, Lco/vine/android/ProfileActivity;

    if-eqz v6, :cond_1

    .line 253
    invoke-virtual {p0}, Lco/vine/android/ProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v6

    check-cast v6, Lco/vine/android/BaseControllerActionBarActivity;

    iget v7, p1, Lco/vine/android/api/VineUser;->profileBackground:I

    invoke-virtual {v6, v7}, Lco/vine/android/BaseControllerActionBarActivity;->setActionBarColor(I)V

    .line 254
    invoke-virtual {p0}, Lco/vine/android/ProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v6

    check-cast v6, Lco/vine/android/BaseControllerActionBarActivity;

    iget v7, p1, Lco/vine/android/api/VineUser;->profileBackground:I

    invoke-virtual {v6, v7}, Lco/vine/android/BaseControllerActionBarActivity;->notifyColorChange(I)V

    .line 256
    :cond_1
    iget-object v6, p0, Lco/vine/android/ProfileFragment;->mFeedAdapter:Lco/vine/android/widget/GenericTimelineAdapter;

    if-eqz v6, :cond_2

    .line 257
    iget-object v6, p0, Lco/vine/android/ProfileFragment;->mFeedAdapter:Lco/vine/android/widget/GenericTimelineAdapter;

    iget v7, p1, Lco/vine/android/api/VineUser;->profileBackground:I

    invoke-virtual {v6, v7}, Lco/vine/android/widget/GenericTimelineAdapter;->setProfileColor(I)V

    .line 259
    :cond_2
    iget v6, p1, Lco/vine/android/api/VineUser;->profileBackground:I

    iput v6, p0, Lco/vine/android/ProfileFragment;->mProfileBackground:I

    .line 262
    :cond_3
    iget-object v6, p0, Lco/vine/android/ProfileFragment;->mProfileHeaderAdapter:Lco/vine/android/ProfileHeaderAdapter;

    invoke-virtual {v6, p1}, Lco/vine/android/ProfileHeaderAdapter;->bindUser(Lco/vine/android/api/VineUser;)V

    .line 264
    invoke-virtual {p1}, Lco/vine/android/api/VineUser;->hasFollowApprovalPending()Z

    move-result v6

    if-eqz v6, :cond_5

    iget-boolean v6, p0, Lco/vine/android/ProfileFragment;->mHeaderAdded:Z

    if-nez v6, :cond_5

    .line 265
    invoke-virtual {p0}, Lco/vine/android/ProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v6

    invoke-static {v6}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v2

    .line 266
    .local v2, "inflater":Landroid/view/LayoutInflater;
    const v6, 0x7f030043

    const/4 v7, 0x0

    invoke-virtual {v2, v6, v7, v8}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    .line 268
    .local v0, "approvalPending":Landroid/widget/LinearLayout;
    iget-object v6, p0, Lco/vine/android/ProfileFragment;->mListView:Landroid/widget/ListView;

    if-eqz v6, :cond_4

    .line 269
    iget-object v6, p0, Lco/vine/android/ProfileFragment;->mListView:Landroid/widget/ListView;

    invoke-virtual {v6, v0}, Landroid/widget/ListView;->addHeaderView(Landroid/view/View;)V

    .line 270
    const v6, 0x7f0a00fe

    invoke-virtual {v0, v6}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/RelativeLayout;

    .line 272
    .local v3, "pendingFollowAccept":Landroid/widget/RelativeLayout;
    invoke-virtual {v3, p0}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 273
    const v6, 0x7f0a00fb

    invoke-virtual {v0, v6}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/RelativeLayout;

    .line 275
    .local v4, "pendingFollowReject":Landroid/widget/RelativeLayout;
    invoke-virtual {v4, p0}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 276
    iput-object v0, p0, Lco/vine/android/ProfileFragment;->mFollowHeader:Landroid/widget/LinearLayout;

    .line 277
    const/4 v6, 0x1

    iput-boolean v6, p0, Lco/vine/android/ProfileFragment;->mHeaderAdded:Z

    .line 279
    .end local v3    # "pendingFollowAccept":Landroid/widget/RelativeLayout;
    .end local v4    # "pendingFollowReject":Landroid/widget/RelativeLayout;
    :cond_4
    iget-object v6, p0, Lco/vine/android/ProfileFragment;->mFollowHeader:Landroid/widget/LinearLayout;

    invoke-virtual {v6, v8}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 281
    .end local v0    # "approvalPending":Landroid/widget/LinearLayout;
    .end local v2    # "inflater":Landroid/view/LayoutInflater;
    :cond_5
    invoke-virtual {p1}, Lco/vine/android/api/VineUser;->areRepostsEnabled()Z

    move-result v6

    invoke-direct {p0, p1, v6}, Lco/vine/android/ProfileFragment;->setRevineOptionText(Lco/vine/android/api/VineUser;Z)V

    .line 282
    iget v6, p1, Lco/vine/android/api/VineUser;->profileBackground:I

    if-lez v6, :cond_6

    .line 283
    iget-object v6, p0, Lco/vine/android/ProfileFragment;->mFeedAdapter:Lco/vine/android/widget/GenericTimelineAdapter;

    if-eqz v6, :cond_6

    iget-object v6, p0, Lco/vine/android/ProfileFragment;->mListView:Landroid/widget/ListView;

    if-eqz v6, :cond_6

    .line 284
    iget-object v6, p0, Lco/vine/android/ProfileFragment;->mFeedAdapter:Lco/vine/android/widget/GenericTimelineAdapter;

    iget v7, p1, Lco/vine/android/api/VineUser;->profileBackground:I

    invoke-virtual {v6, v7}, Lco/vine/android/widget/GenericTimelineAdapter;->setProfileColor(I)V

    .line 285
    iget-object v5, p0, Lco/vine/android/ProfileFragment;->mListView:Landroid/widget/ListView;

    check-cast v5, Lcom/twitter/android/widget/RefreshableListView;

    .line 286
    .local v5, "rlv":Lcom/twitter/android/widget/RefreshableListView;
    const/high16 v6, -0x1000000

    iget v7, p1, Lco/vine/android/api/VineUser;->profileBackground:I

    or-int v1, v6, v7

    .line 287
    .local v1, "color":I
    invoke-virtual {v5, v1}, Lcom/twitter/android/widget/RefreshableListView;->setPullToRefreshBackgroundColor(I)V

    .line 288
    const/4 v6, -0x1

    invoke-virtual {v5, v6}, Lcom/twitter/android/widget/RefreshableListView;->colorizePTR(I)V

    .line 291
    .end local v1    # "color":I
    .end local v5    # "rlv":Lcom/twitter/android/widget/RefreshableListView;
    :cond_6
    return-void
.end method

.method public changeMode(I)V
    .locals 6
    .param p1, "mode"    # I

    .prologue
    const/4 v5, 0x3

    const/4 v1, 0x2

    const/4 v4, 0x0

    const/4 v3, 0x1

    .line 523
    packed-switch p1, :pswitch_data_0

    .line 547
    :cond_0
    :goto_0
    return-void

    .line 525
    :pswitch_0
    iget v0, p0, Lco/vine/android/ProfileFragment;->mCurrentMode:I

    if-eq v0, v1, :cond_0

    .line 528
    iput v1, p0, Lco/vine/android/ProfileFragment;->mCurrentMode:I

    .line 529
    const-string v0, "Profile: Tab 2"

    invoke-virtual {p0, v0}, Lco/vine/android/ProfileFragment;->setFlurryEventSource(Ljava/lang/String;)V

    .line 530
    new-instance v0, Lco/vine/android/widget/SectionAdapter;

    new-array v1, v3, [Landroid/widget/BaseAdapter;

    iget-object v2, p0, Lco/vine/android/ProfileFragment;->mProfileHeaderAdapter:Lco/vine/android/ProfileHeaderAdapter;

    aput-object v2, v1, v4

    invoke-direct {v0, v1}, Lco/vine/android/widget/SectionAdapter;-><init>([Landroid/widget/BaseAdapter;)V

    iput-object v0, p0, Lco/vine/android/ProfileFragment;->mSectionAdapter:Lco/vine/android/widget/SectionAdapter;

    .line 531
    iget-object v0, p0, Lco/vine/android/ProfileFragment;->mListView:Landroid/widget/ListView;

    iget-object v1, p0, Lco/vine/android/ProfileFragment;->mSectionAdapter:Lco/vine/android/widget/SectionAdapter;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 532
    invoke-virtual {p0, v5, v3}, Lco/vine/android/ProfileFragment;->fetchContent(IZ)V

    goto :goto_0

    .line 536
    :pswitch_1
    iget v0, p0, Lco/vine/android/ProfileFragment;->mCurrentMode:I

    if-eq v0, v3, :cond_0

    .line 539
    iput v3, p0, Lco/vine/android/ProfileFragment;->mCurrentMode:I

    .line 540
    new-instance v0, Lco/vine/android/widget/SectionAdapter;

    new-array v1, v3, [Landroid/widget/BaseAdapter;

    iget-object v2, p0, Lco/vine/android/ProfileFragment;->mProfileHeaderAdapter:Lco/vine/android/ProfileHeaderAdapter;

    aput-object v2, v1, v4

    invoke-direct {v0, v1}, Lco/vine/android/widget/SectionAdapter;-><init>([Landroid/widget/BaseAdapter;)V

    iput-object v0, p0, Lco/vine/android/ProfileFragment;->mSectionAdapter:Lco/vine/android/widget/SectionAdapter;

    .line 541
    iget-object v0, p0, Lco/vine/android/ProfileFragment;->mListView:Landroid/widget/ListView;

    iget-object v1, p0, Lco/vine/android/ProfileFragment;->mSectionAdapter:Lco/vine/android/widget/SectionAdapter;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 542
    const-string v0, "Profile: Tab 1"

    invoke-virtual {p0, v0}, Lco/vine/android/ProfileFragment;->setFlurryEventSource(Ljava/lang/String;)V

    .line 543
    invoke-virtual {p0, v5, v3}, Lco/vine/android/ProfileFragment;->fetchContent(IZ)V

    goto :goto_0

    .line 523
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method protected fetchContent(IZ)V
    .locals 13
    .param p1, "fetchType"    # I
    .param p2, "userInitiated"    # Z

    .prologue
    const/4 v11, 0x0

    const/16 v2, 0xa

    const/4 v0, 0x2

    .line 596
    iput p1, p0, Lco/vine/android/ProfileFragment;->mLastFetchType:I

    .line 597
    invoke-virtual {p0, p1}, Lco/vine/android/ProfileFragment;->hasPendingRequest(I)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 622
    :goto_0
    return-void

    .line 601
    :cond_0
    packed-switch p1, :pswitch_data_0

    .line 613
    :goto_1
    iget-boolean v1, p0, Lco/vine/android/ProfileFragment;->mHideProfileReposts:Z

    if-eqz v1, :cond_2

    move v5, v2

    .line 616
    .local v5, "postGroup":I
    :goto_2
    iget v1, p0, Lco/vine/android/ProfileFragment;->mCurrentMode:I

    if-ne v1, v0, :cond_1

    .line 617
    const/4 v5, 0x3

    .line 619
    :cond_1
    iget-object v0, p0, Lco/vine/android/ProfileFragment;->mAppController:Lco/vine/android/client/AppController;

    iget-object v1, p0, Lco/vine/android/ProfileFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v1}, Lco/vine/android/client/AppController;->getActiveSession()Lco/vine/android/client/Session;

    move-result-object v1

    iget-wide v3, p0, Lco/vine/android/ProfileFragment;->mUserId:J

    iget v6, p0, Lco/vine/android/ProfileFragment;->mNextPage:I

    iget-wide v7, p0, Lco/vine/android/ProfileFragment;->mAnchor:J

    iget-wide v9, p0, Lco/vine/android/ProfileFragment;->mUserId:J

    invoke-static {v9, v10}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v10

    move v9, p2

    move-object v12, v11

    invoke-virtual/range {v0 .. v12}, Lco/vine/android/client/AppController;->fetchPosts(Lco/vine/android/client/Session;IJIIJZLjava/lang/String;Ljava/lang/String;Landroid/net/Uri;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0, p1}, Lco/vine/android/ProfileFragment;->addRequest(Ljava/lang/String;I)Ljava/lang/String;

    goto :goto_0

    .line 603
    .end local v5    # "postGroup":I
    :pswitch_0
    invoke-virtual {p0, p1}, Lco/vine/android/ProfileFragment;->showProgress(I)V

    .line 607
    :pswitch_1
    const/4 v1, 0x1

    iput v1, p0, Lco/vine/android/ProfileFragment;->mNextPage:I

    .line 608
    const-wide/16 v3, 0x0

    iput-wide v3, p0, Lco/vine/android/ProfileFragment;->mAnchor:J

    goto :goto_1

    :cond_2
    move v5, v0

    .line 613
    goto :goto_2

    .line 601
    nop

    :pswitch_data_0
    .packed-switch 0x2
        :pswitch_0
        :pswitch_1
        :pswitch_1
    .end packed-switch
.end method

.method protected fetchPosts(IJZ)Ljava/lang/String;
    .locals 2
    .param p1, "page"    # I
    .param p2, "anchor"    # J
    .param p4, "userInitiated"    # Z

    .prologue
    .line 398
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Don\'t call fetch posts for ProfileFragment, this fragment handles its own fetching."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public getOffset(Landroid/widget/BaseAdapter;)I
    .locals 2
    .param p1, "me"    # Landroid/widget/BaseAdapter;

    .prologue
    .line 766
    iget-object v0, p0, Lco/vine/android/ProfileFragment;->mSectionAdapter:Lco/vine/android/widget/SectionAdapter;

    iget-object v1, p0, Lco/vine/android/ProfileFragment;->mSectionAdapter:Lco/vine/android/widget/SectionAdapter;

    invoke-virtual {v1, p1}, Lco/vine/android/widget/SectionAdapter;->getMyAdapterIndex(Landroid/widget/BaseAdapter;)I

    move-result v1

    invoke-virtual {v0, v1}, Lco/vine/android/widget/SectionAdapter;->getPositionOffset(I)I

    move-result v0

    return v0
.end method

.method public getUserId()J
    .locals 2

    .prologue
    .line 793
    iget-wide v0, p0, Lco/vine/android/ProfileFragment;->mUserId:J

    return-wide v0
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 7
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 425
    invoke-super {p0, p1}, Lco/vine/android/BaseTimelineFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 426
    invoke-virtual {p0}, Lco/vine/android/ProfileFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v2

    const-string v3, "take_focus"

    const/4 v4, 0x0

    invoke-virtual {v2, v3, v4}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 427
    invoke-virtual {p0}, Lco/vine/android/ProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    .line 428
    .local v0, "activity":Landroid/app/Activity;
    instance-of v2, v0, Lco/vine/android/HomeTabActivity;

    if-eqz v2, :cond_0

    move-object v1, v0

    .line 429
    check-cast v1, Lco/vine/android/HomeTabActivity;

    .line 430
    .local v1, "callback":Lco/vine/android/HomeTabActivity;
    const/4 v2, 0x3

    invoke-virtual {v1, v2, p0}, Lco/vine/android/HomeTabActivity;->showPage(ILandroid/support/v4/app/Fragment;)V

    .line 431
    invoke-static {}, Lco/vine/android/util/BuildUtil;->isLogsOn()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 432
    const-string v2, "ProfileFragment"

    const-string v3, "Me tab took focus."

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 436
    .end local v0    # "activity":Landroid/app/Activity;
    .end local v1    # "callback":Lco/vine/android/HomeTabActivity;
    :cond_0
    new-instance v2, Lco/vine/android/widget/TypefacesSpan;

    const/4 v3, 0x0

    invoke-virtual {p0}, Lco/vine/android/ProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v4

    invoke-static {v4}, Lco/vine/android/widget/Typefaces;->get(Landroid/content/Context;)Lco/vine/android/widget/Typefaces;

    move-result-object v4

    const/4 v5, 0x1

    const/4 v6, 0x4

    invoke-virtual {v4, v5, v6}, Lco/vine/android/widget/Typefaces;->getContentTypeface(II)Landroid/graphics/Typeface;

    move-result-object v4

    invoke-direct {v2, v3, v4}, Lco/vine/android/widget/TypefacesSpan;-><init>(Ljava/lang/String;Landroid/graphics/Typeface;)V

    iput-object v2, p0, Lco/vine/android/ProfileFragment;->mBold:Lco/vine/android/widget/TypefacesSpan;

    .line 439
    invoke-virtual {p0}, Lco/vine/android/ProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-virtual {v2}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f090096

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getColor(I)I

    move-result v2

    iput v2, p0, Lco/vine/android/ProfileFragment;->mVineGreen:I

    .line 441
    iget-boolean v2, p0, Lco/vine/android/ProfileFragment;->mTakeFocus:Z

    invoke-direct {p0, v2}, Lco/vine/android/ProfileFragment;->setup(Z)V

    .line 442
    return-void
.end method

.method public onActivityResult(IILandroid/content/Intent;)V
    .locals 5
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    const/4 v4, 0x1

    .line 446
    invoke-super {p0, p1, p2, p3}, Lco/vine/android/BaseTimelineFragment;->onActivityResult(IILandroid/content/Intent;)V

    .line 447
    packed-switch p1, :pswitch_data_0

    .line 458
    :cond_0
    :goto_0
    return-void

    .line 449
    :pswitch_0
    if-ne p2, v4, :cond_0

    .line 450
    iget-wide v0, p0, Lco/vine/android/ProfileFragment;->mUserId:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-lez v0, :cond_0

    .line 451
    iget-object v0, p0, Lco/vine/android/ProfileFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v0, v4, v4}, Lco/vine/android/client/AppController;->fetchFriends(II)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lco/vine/android/ProfileFragment;->addRequest(Ljava/lang/String;)Ljava/lang/String;

    .line 452
    iget-object v0, p0, Lco/vine/android/ProfileFragment;->mAppController:Lco/vine/android/client/AppController;

    const/4 v1, 0x0

    invoke-virtual {v0, v4, v1}, Lco/vine/android/client/AppController;->fetchFriends(II)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lco/vine/android/ProfileFragment;->addRequest(Ljava/lang/String;)Ljava/lang/String;

    goto :goto_0

    .line 447
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
    .end packed-switch
.end method

.method public onClick(Landroid/view/View;)V
    .locals 19
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 626
    invoke-virtual/range {p1 .. p1}, Landroid/view/View;->getId()I

    move-result v3

    sparse-switch v3, :sswitch_data_0

    .line 711
    invoke-super/range {p0 .. p1}, Lco/vine/android/BaseTimelineFragment;->onClick(Landroid/view/View;)V

    .line 714
    :cond_0
    :goto_0
    return-void

    .line 630
    :sswitch_0
    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/ProfileFragment;->mProfileHeaderAdapter:Lco/vine/android/ProfileHeaderAdapter;

    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/ProfileFragment;->mUser:Lco/vine/android/api/VineUser;

    move-object/from16 v0, p1

    move-object/from16 v1, p0

    invoke-virtual {v3, v0, v1, v5}, Lco/vine/android/ProfileHeaderAdapter;->onProfileHeaderClick(Landroid/view/View;Lco/vine/android/ProfileFragment;Lco/vine/android/api/VineUser;)V

    goto :goto_0

    .line 634
    :sswitch_1
    move-object/from16 v0, p0

    iget-wide v5, v0, Lco/vine/android/ProfileFragment;->mWaitingToStartUserId:J

    const-wide/16 v17, -0x1

    cmp-long v3, v5, v17

    if-nez v3, :cond_0

    .line 635
    move-object/from16 v0, p0

    iget-wide v5, v0, Lco/vine/android/ProfileFragment;->mUserId:J

    move-object/from16 v0, p0

    iput-wide v5, v0, Lco/vine/android/ProfileFragment;->mWaitingToStartUserId:J

    .line 638
    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/ProfileFragment;->mAppController:Lco/vine/android/client/AppController;

    move-object/from16 v0, p0

    iget-wide v5, v0, Lco/vine/android/ProfileFragment;->mUserId:J

    const/4 v7, 0x1

    invoke-virtual {v3, v5, v6, v7}, Lco/vine/android/client/AppController;->fetchConversationRowIdFromUserRemoteId(JI)V

    goto :goto_0

    .line 645
    :sswitch_2
    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/ProfileFragment;->mProfileHeaderAdapter:Lco/vine/android/ProfileHeaderAdapter;

    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/ProfileFragment;->mUser:Lco/vine/android/api/VineUser;

    move-object/from16 v0, p1

    move-object/from16 v1, p0

    invoke-virtual {v3, v0, v1, v5}, Lco/vine/android/ProfileHeaderAdapter;->onProfileHeaderClick(Landroid/view/View;Lco/vine/android/ProfileFragment;Lco/vine/android/api/VineUser;)V

    goto :goto_0

    .line 649
    :sswitch_3
    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/ProfileFragment;->mAppController:Lco/vine/android/client/AppController;

    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/ProfileFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v5}, Lco/vine/android/client/AppController;->getActiveSession()Lco/vine/android/client/Session;

    move-result-object v5

    move-object/from16 v0, p0

    iget-wide v6, v0, Lco/vine/android/ProfileFragment;->mUserId:J

    invoke-virtual {v3, v5, v6, v7}, Lco/vine/android/client/AppController;->acceptFollowRequest(Lco/vine/android/client/Session;J)Ljava/lang/String;

    goto :goto_0

    .line 653
    :sswitch_4
    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/ProfileFragment;->mAppController:Lco/vine/android/client/AppController;

    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/ProfileFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v5}, Lco/vine/android/client/AppController;->getActiveSession()Lco/vine/android/client/Session;

    move-result-object v5

    move-object/from16 v0, p0

    iget-wide v6, v0, Lco/vine/android/ProfileFragment;->mUserId:J

    invoke-virtual {v3, v5, v6, v7}, Lco/vine/android/client/AppController;->acceptRejectRequest(Lco/vine/android/client/Session;J)Ljava/lang/String;

    goto :goto_0

    .line 657
    :sswitch_5
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/ProfileFragment;->onDropDownClicked()V

    goto :goto_0

    .line 660
    :sswitch_6
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/ProfileFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v13

    .line 661
    .local v13, "res":Landroid/content/res/Resources;
    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/ProfileFragment;->mUser:Lco/vine/android/api/VineUser;

    if-eqz v3, :cond_0

    if-eqz v13, :cond_0

    .line 664
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/ProfileFragment;->getView()Landroid/view/View;

    move-result-object v16

    .line 665
    .local v16, "v":Landroid/view/View;
    if-eqz v16, :cond_0

    .line 666
    const v3, 0x7f0a0190

    move-object/from16 v0, v16

    invoke-virtual {v0, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v12

    .line 667
    .local v12, "postsButton":Landroid/view/View;
    const v3, 0x7f0a0196

    move-object/from16 v0, v16

    invoke-virtual {v0, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    .line 668
    .local v4, "dropDown":Landroid/view/View;
    if-eqz v4, :cond_0

    .line 669
    invoke-virtual {v4}, Landroid/view/View;->getVisibility()I

    move-result v3

    if-nez v3, :cond_1

    .line 670
    invoke-direct/range {p0 .. p0}, Lco/vine/android/ProfileFragment;->dismissDropdown()V

    goto/16 :goto_0

    .line 672
    :cond_1
    if-eqz v12, :cond_0

    .line 673
    invoke-virtual {v4}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v14

    check-cast v14, Lco/vine/android/ProfileHeaderAdapter$DropdownHolder;

    .line 674
    .local v14, "tag":Lco/vine/android/ProfileHeaderAdapter$DropdownHolder;
    move-object/from16 v0, p0

    iget-boolean v3, v0, Lco/vine/android/ProfileFragment;->mHideProfileReposts:Z

    if-eqz v3, :cond_2

    const v3, 0x7f0e021c

    :goto_1
    invoke-virtual {v13, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v10

    .line 676
    .local v10, "hideRevines":Ljava/lang/String;
    iget-object v3, v14, Lco/vine/android/ProfileHeaderAdapter$DropdownHolder;->revineParent:Landroid/view/View;

    const/4 v5, 0x0

    invoke-virtual {v3, v5}, Landroid/view/View;->setVisibility(I)V

    .line 677
    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/ProfileFragment;->mBold:Lco/vine/android/widget/TypefacesSpan;

    iget-object v5, v14, Lco/vine/android/ProfileHeaderAdapter$DropdownHolder;->revineLabel:Landroid/widget/TextView;

    invoke-static {v3, v10, v5}, Lco/vine/android/util/Util;->setTextWithSpan(Ljava/lang/Object;Ljava/lang/String;Landroid/widget/TextView;)V

    .line 678
    new-instance v9, Landroid/text/SpannableStringBuilder;

    invoke-direct {v9, v10}, Landroid/text/SpannableStringBuilder;-><init>(Ljava/lang/CharSequence;)V

    .line 679
    .local v9, "contentSb":Landroid/text/SpannableStringBuilder;
    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/ProfileFragment;->mBold:Lco/vine/android/widget/TypefacesSpan;

    const/4 v5, 0x0

    invoke-virtual {v9}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v6

    const/16 v7, 0x21

    invoke-static {v9, v3, v5, v6, v7}, Lco/vine/android/util/Util;->safeSetSpan(Landroid/text/Spannable;Ljava/lang/Object;III)V

    .line 680
    iget-object v3, v14, Lco/vine/android/ProfileHeaderAdapter$DropdownHolder;->revineLabel:Landroid/widget/TextView;

    invoke-virtual {v3, v9}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 681
    iget-object v5, v14, Lco/vine/android/ProfileHeaderAdapter$DropdownHolder;->revineIcon:Landroid/widget/ImageView;

    move-object/from16 v0, p0

    iget-boolean v3, v0, Lco/vine/android/ProfileFragment;->mHideProfileReposts:Z

    if-eqz v3, :cond_3

    const v3, 0x7f0201dd

    :goto_2
    invoke-virtual {v5, v3}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 683
    new-instance v2, Lco/vine/android/animation/HeightAnimation;

    invoke-virtual/range {p0 .. p0}, Lco/vine/android/ProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    const/4 v5, 0x1

    const-wide/16 v6, 0x12c

    invoke-direct/range {v2 .. v7}, Lco/vine/android/animation/HeightAnimation;-><init>(Landroid/app/Activity;Landroid/view/View;ZJ)V

    .line 684
    .local v2, "anim":Landroid/view/animation/Animation;
    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/ProfileFragment;->mDrawerListener:Landroid/view/animation/Animation$AnimationListener;

    invoke-virtual {v2, v3}, Landroid/view/animation/Animation;->setAnimationListener(Landroid/view/animation/Animation$AnimationListener;)V

    .line 685
    invoke-virtual {v4, v2}, Landroid/view/View;->startAnimation(Landroid/view/animation/Animation;)V

    .line 686
    const v3, 0x7f0a0193

    move-object/from16 v0, v16

    invoke-virtual {v0, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v8

    .line 687
    .local v8, "arrowImage":Landroid/view/View;
    instance-of v3, v8, Landroid/widget/ImageView;

    if-eqz v3, :cond_0

    .line 688
    move-object/from16 v0, p0

    iget v3, v0, Lco/vine/android/ProfileFragment;->mProfileBackground:I

    sget v5, Lco/vine/android/Settings;->DEFAULT_PROFILE_COLOR:I

    if-ne v3, v5, :cond_4

    .line 689
    check-cast v8, Landroid/widget/ImageView;

    .end local v8    # "arrowImage":Landroid/view/View;
    new-instance v3, Landroid/graphics/PorterDuffColorFilter;

    const/high16 v5, -0x1000000

    move-object/from16 v0, p0

    iget v6, v0, Lco/vine/android/ProfileFragment;->mVineGreen:I

    or-int/2addr v5, v6

    sget-object v6, Landroid/graphics/PorterDuff$Mode;->SRC_IN:Landroid/graphics/PorterDuff$Mode;

    invoke-direct {v3, v5, v6}, Landroid/graphics/PorterDuffColorFilter;-><init>(ILandroid/graphics/PorterDuff$Mode;)V

    invoke-virtual {v8, v3}, Landroid/widget/ImageView;->setColorFilter(Landroid/graphics/ColorFilter;)V

    goto/16 :goto_0

    .line 674
    .end local v2    # "anim":Landroid/view/animation/Animation;
    .end local v9    # "contentSb":Landroid/text/SpannableStringBuilder;
    .end local v10    # "hideRevines":Ljava/lang/String;
    :cond_2
    const v3, 0x7f0e010b

    goto :goto_1

    .line 681
    .restart local v9    # "contentSb":Landroid/text/SpannableStringBuilder;
    .restart local v10    # "hideRevines":Ljava/lang/String;
    :cond_3
    const v3, 0x7f020192

    goto :goto_2

    .line 691
    .restart local v2    # "anim":Landroid/view/animation/Animation;
    .restart local v8    # "arrowImage":Landroid/view/View;
    :cond_4
    check-cast v8, Landroid/widget/ImageView;

    .end local v8    # "arrowImage":Landroid/view/View;
    new-instance v3, Landroid/graphics/PorterDuffColorFilter;

    const/high16 v5, -0x1000000

    move-object/from16 v0, p0

    iget v6, v0, Lco/vine/android/ProfileFragment;->mProfileBackground:I

    or-int/2addr v5, v6

    sget-object v6, Landroid/graphics/PorterDuff$Mode;->SRC_IN:Landroid/graphics/PorterDuff$Mode;

    invoke-direct {v3, v5, v6}, Landroid/graphics/PorterDuffColorFilter;-><init>(ILandroid/graphics/PorterDuff$Mode;)V

    invoke-virtual {v8, v3}, Landroid/widget/ImageView;->setColorFilter(Landroid/graphics/ColorFilter;)V

    goto/16 :goto_0

    .line 702
    .end local v2    # "anim":Landroid/view/animation/Animation;
    .end local v4    # "dropDown":Landroid/view/View;
    .end local v9    # "contentSb":Landroid/text/SpannableStringBuilder;
    .end local v10    # "hideRevines":Ljava/lang/String;
    .end local v12    # "postsButton":Landroid/view/View;
    .end local v13    # "res":Landroid/content/res/Resources;
    .end local v14    # "tag":Lco/vine/android/ProfileHeaderAdapter$DropdownHolder;
    .end local v16    # "v":Landroid/view/View;
    :sswitch_7
    new-instance v11, Landroid/content/Intent;

    invoke-virtual/range {p0 .. p0}, Lco/vine/android/ProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    const-class v5, Lco/vine/android/UsersActivity;

    invoke-direct {v11, v3, v5}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 703
    .local v11, "i":Landroid/content/Intent;
    const-string v3, "p_id"

    move-object/from16 v0, p0

    iget-wide v5, v0, Lco/vine/android/ProfileFragment;->mUserId:J

    invoke-virtual {v11, v3, v5, v6}, Landroid/content/Intent;->putExtra(Ljava/lang/String;J)Landroid/content/Intent;

    .line 705
    invoke-virtual/range {p1 .. p1}, Landroid/view/View;->getId()I

    move-result v3

    const v5, 0x7f0a01a3

    if-ne v3, v5, :cond_5

    const/4 v15, 0x2

    .line 706
    .local v15, "type":I
    :goto_3
    const-string v3, "u_type"

    invoke-virtual {v11, v3, v15}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 707
    move-object/from16 v0, p0

    invoke-virtual {v0, v11}, Lco/vine/android/ProfileFragment;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 705
    .end local v15    # "type":I
    :cond_5
    const/4 v15, 0x1

    goto :goto_3

    .line 626
    :sswitch_data_0
    .sparse-switch
        0x7f0a0063 -> :sswitch_0
        0x7f0a00fb -> :sswitch_4
        0x7f0a00fe -> :sswitch_3
        0x7f0a018c -> :sswitch_0
        0x7f0a018d -> :sswitch_0
        0x7f0a018e -> :sswitch_1
        0x7f0a0190 -> :sswitch_2
        0x7f0a0192 -> :sswitch_6
        0x7f0a0194 -> :sswitch_2
        0x7f0a0197 -> :sswitch_5
        0x7f0a01a3 -> :sswitch_7
        0x7f0a01a4 -> :sswitch_7
    .end sparse-switch
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 7
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v1, 0x0

    const/4 v2, 0x1

    .line 142
    invoke-super {p0, p1}, Lco/vine/android/BaseTimelineFragment;->onCreate(Landroid/os/Bundle;)V

    .line 143
    invoke-virtual {p0, v2}, Lco/vine/android/ProfileFragment;->setHasOptionsMenu(Z)V

    .line 145
    invoke-virtual {p0}, Lco/vine/android/ProfileFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    .line 146
    .local v0, "b":Landroid/os/Bundle;
    const-string v3, "user_id"

    const-wide/16 v4, -0x1

    invoke-virtual {v0, v3, v4, v5}, Landroid/os/Bundle;->getLong(Ljava/lang/String;J)J

    move-result-wide v3

    invoke-direct {p0, v3, v4}, Lco/vine/android/ProfileFragment;->setUserId(J)V

    .line 147
    const-string v3, "Profile: Tab 1"

    invoke-virtual {p0, v3}, Lco/vine/android/ProfileFragment;->setFlurryEventSource(Ljava/lang/String;)V

    .line 148
    const-string v3, "event_source"

    invoke-virtual {v0, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Lco/vine/android/ProfileFragment;->mFlurryFollowEventSource:Ljava/lang/String;

    .line 149
    const-string v3, "take_focus"

    invoke-virtual {v0, v3, v1}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v3

    iput-boolean v3, p0, Lco/vine/android/ProfileFragment;->mTakeFocus:Z

    .line 150
    iget-boolean v3, p0, Lco/vine/android/ProfileFragment;->mTakeFocus:Z

    if-eqz v3, :cond_0

    .line 151
    invoke-virtual {p0, v2}, Lco/vine/android/ProfileFragment;->setFocused(Z)V

    .line 153
    :cond_0
    new-instance v3, Lco/vine/android/ProfileFragment$ProfileListener;

    invoke-direct {v3, p0}, Lco/vine/android/ProfileFragment$ProfileListener;-><init>(Lco/vine/android/ProfileFragment;)V

    iput-object v3, p0, Lco/vine/android/ProfileFragment;->mAppSessionListener:Lco/vine/android/client/AppSessionListener;

    .line 155
    if-eqz p1, :cond_5

    .line 156
    const-string v3, "state_mode"

    invoke-virtual {p1, v3}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v3

    iput v3, p0, Lco/vine/android/ProfileFragment;->mCurrentMode:I

    .line 157
    const-string v3, "stated_header_added"

    invoke-virtual {p1, v3}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 158
    const-string v3, "stated_header_added"

    invoke-virtual {p1, v3}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v3

    iput-boolean v3, p0, Lco/vine/android/ProfileFragment;->mHeaderAdded:Z

    .line 165
    :cond_1
    :goto_0
    invoke-virtual {p0, v1}, Lco/vine/android/ProfileFragment;->showSadface(Z)V

    .line 167
    iget-object v3, p0, Lco/vine/android/ProfileFragment;->mUser:Lco/vine/android/api/VineUser;

    if-eqz v3, :cond_2

    .line 168
    iget-object v3, p0, Lco/vine/android/ProfileFragment;->mUser:Lco/vine/android/api/VineUser;

    iput v2, v3, Lco/vine/android/api/VineUser;->repostsEnabled:I

    .line 172
    :cond_2
    const-string v3, "vanity_url"

    invoke-virtual {v0, v3}, Landroid/os/Bundle;->getStringArrayList(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v3

    if-eqz v3, :cond_6

    .line 174
    iget-object v1, p0, Lco/vine/android/ProfileFragment;->mAppController:Lco/vine/android/client/AppController;

    const-string v3, "vanity_url"

    invoke-virtual {v0, v3}, Landroid/os/Bundle;->getStringArrayList(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v3

    invoke-virtual {v1, v3}, Lco/vine/android/client/AppController;->fetchUserId(Ljava/util/ArrayList;)Ljava/lang/String;

    .line 181
    :cond_3
    :goto_1
    iget-boolean v1, p0, Lco/vine/android/ProfileFragment;->mIsMe:Z

    if-eqz v1, :cond_4

    .line 182
    invoke-direct {p0}, Lco/vine/android/ProfileFragment;->bindProfileDataAndCounts()V

    .line 185
    :cond_4
    const-string v1, "show_profile_actions"

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v1

    iput-boolean v1, p0, Lco/vine/android/ProfileFragment;->mShowProfileActions:Z

    .line 186
    return-void

    .line 161
    :cond_5
    iput v2, p0, Lco/vine/android/ProfileFragment;->mCurrentMode:I

    .line 162
    iput-boolean v1, p0, Lco/vine/android/ProfileFragment;->mHeaderAdded:Z

    goto :goto_0

    .line 175
    :cond_6
    iget-wide v3, p0, Lco/vine/android/ProfileFragment;->mUserId:J

    const-wide/16 v5, 0x0

    cmp-long v3, v3, v5

    if-lez v3, :cond_3

    .line 176
    iget-wide v3, p0, Lco/vine/android/ProfileFragment;->mUserId:J

    iget-object v5, p0, Lco/vine/android/ProfileFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v5}, Lco/vine/android/client/AppController;->getActiveId()J

    move-result-wide v5

    cmp-long v3, v3, v5

    if-nez v3, :cond_7

    move v1, v2

    :cond_7
    iput-boolean v1, p0, Lco/vine/android/ProfileFragment;->mIsMe:Z

    .line 177
    iget-boolean v1, p0, Lco/vine/android/ProfileFragment;->mIsMe:Z

    if-nez v1, :cond_3

    .line 178
    iget-object v1, p0, Lco/vine/android/ProfileFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v1}, Lco/vine/android/client/AppController;->getBlockedUsers()Ljava/lang/String;

    goto :goto_1
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V
    .locals 1
    .param p1, "menu"    # Landroid/view/Menu;
    .param p2, "inflater"    # Landroid/view/MenuInflater;

    .prologue
    .line 295
    iget-boolean v0, p0, Lco/vine/android/ProfileFragment;->mIsMe:Z

    if-nez v0, :cond_0

    .line 296
    const v0, 0x7f10000f

    invoke-virtual {p2, v0, p1}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 298
    :cond_0
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 1
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 420
    const v0, 0x7f030061

    invoke-virtual {p0, p1, v0, p2}, Lco/vine/android/ProfileFragment;->createView(Landroid/view/LayoutInflater;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public onDestroy()V
    .locals 2

    .prologue
    .line 557
    invoke-super {p0}, Lco/vine/android/BaseTimelineFragment;->onDestroy()V

    .line 558
    iget-boolean v0, p0, Lco/vine/android/ProfileFragment;->mColorChangedReceiverIsRegistered:Z

    if-eqz v0, :cond_0

    .line 559
    invoke-virtual {p0}, Lco/vine/android/ProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    iget-object v1, p0, Lco/vine/android/ProfileFragment;->mColorChangedReceiver:Lco/vine/android/ProfileFragment$ColorChangedReceiver;

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentActivity;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    .line 560
    const/4 v0, 0x0

    iput-boolean v0, p0, Lco/vine/android/ProfileFragment;->mColorChangedReceiverIsRegistered:Z

    .line 562
    :cond_0
    return-void
.end method

.method public onDropDownClicked()V
    .locals 6

    .prologue
    const/4 v3, 0x0

    const/4 v2, 0x1

    .line 732
    iget-boolean v1, p0, Lco/vine/android/ProfileFragment;->mHideProfileReposts:Z

    if-nez v1, :cond_1

    move v1, v2

    :goto_0
    iput-boolean v1, p0, Lco/vine/android/ProfileFragment;->mHideProfileReposts:Z

    .line 733
    iget-boolean v1, p0, Lco/vine/android/ProfileFragment;->mHideProfileReposts:Z

    iget-object v4, p0, Lco/vine/android/ProfileFragment;->mUser:Lco/vine/android/api/VineUser;

    iget v4, v4, Lco/vine/android/api/VineUser;->following:I

    if-lez v4, :cond_0

    move v3, v2

    :cond_0
    iget-boolean v4, p0, Lco/vine/android/ProfileFragment;->mIsMe:Z

    invoke-static {v1, v3, v4}, Lco/vine/android/util/FlurryUtils;->trackFilterProfileReposts(ZZZ)V

    .line 735
    iget-boolean v1, p0, Lco/vine/android/ProfileFragment;->mIsMe:Z

    if-eqz v1, :cond_2

    .line 736
    invoke-virtual {p0}, Lco/vine/android/ProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-static {v1}, Lco/vine/android/util/Util;->getDefaultSharedPrefs(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v1

    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 737
    .local v0, "e":Landroid/content/SharedPreferences$Editor;
    const-string v1, "profile_hide_reposts"

    iget-boolean v3, p0, Lco/vine/android/ProfileFragment;->mHideProfileReposts:Z

    invoke-interface {v0, v1, v3}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    .line 738
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->apply()V

    .line 742
    .end local v0    # "e":Landroid/content/SharedPreferences$Editor;
    :goto_1
    iget-object v1, p0, Lco/vine/android/ProfileFragment;->mFeedAdapter:Lco/vine/android/widget/GenericTimelineAdapter;

    invoke-virtual {p0}, Lco/vine/android/ProfileFragment;->isFocused()Z

    move-result v3

    invoke-virtual {v1, v3}, Lco/vine/android/widget/GenericTimelineAdapter;->onPause(Z)V

    .line 743
    const/4 v1, 0x3

    invoke-virtual {p0, v1, v2}, Lco/vine/android/ProfileFragment;->fetchContent(IZ)V

    .line 745
    invoke-direct {p0}, Lco/vine/android/ProfileFragment;->dismissDropdown()V

    .line 746
    return-void

    :cond_1
    move v1, v3

    .line 732
    goto :goto_0

    .line 740
    :cond_2
    iget-object v1, p0, Lco/vine/android/ProfileFragment;->mAppController:Lco/vine/android/client/AppController;

    iget-wide v3, p0, Lco/vine/android/ProfileFragment;->mUserId:J

    iget-boolean v5, p0, Lco/vine/android/ProfileFragment;->mHideProfileReposts:Z

    invoke-virtual {v1, v3, v4, v5}, Lco/vine/android/client/AppController;->setHideProfileReposts(JZ)Ljava/lang/String;

    goto :goto_1
.end method

.method public onLongClick(Landroid/view/View;)Z
    .locals 1
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 718
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v0

    sparse-switch v0, :sswitch_data_0

    .line 726
    const/4 v0, 0x0

    :goto_0
    return v0

    .line 722
    :sswitch_0
    iget-object v0, p0, Lco/vine/android/ProfileFragment;->mProfileHeaderAdapter:Lco/vine/android/ProfileHeaderAdapter;

    invoke-virtual {v0, p1}, Lco/vine/android/ProfileHeaderAdapter;->onProfileHeaderLongClick(Landroid/view/View;)V

    .line 723
    const/4 v0, 0x1

    goto :goto_0

    .line 718
    :sswitch_data_0
    .sparse-switch
        0x7f0a0063 -> :sswitch_0
        0x7f0a018c -> :sswitch_0
        0x7f0a018d -> :sswitch_0
    .end sparse-switch
.end method

.method public onMoveTo(I)V
    .locals 1
    .param p1, "oldPosition"    # I

    .prologue
    .line 404
    invoke-super {p0, p1}, Lco/vine/android/BaseTimelineFragment;->onMoveTo(I)V

    .line 405
    invoke-virtual {p0}, Lco/vine/android/ProfileFragment;->isFocused()Z

    move-result v0

    invoke-direct {p0, v0}, Lco/vine/android/ProfileFragment;->setup(Z)V

    .line 406
    invoke-direct {p0}, Lco/vine/android/ProfileFragment;->bindProfileDataAndCounts()V

    .line 407
    return-void
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 8
    .param p1, "item"    # Landroid/view/MenuItem;

    .prologue
    const/4 v2, 0x1

    .line 302
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v3

    packed-switch v3, :pswitch_data_0

    .line 354
    :cond_0
    :goto_0
    invoke-super {p0, p1}, Lco/vine/android/BaseTimelineFragment;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v2

    :cond_1
    :goto_1
    return v2

    .line 304
    :pswitch_0
    iget-boolean v3, p0, Lco/vine/android/ProfileFragment;->mIsUserBlocked:Z

    if-eqz v3, :cond_2

    .line 305
    iget-object v3, p0, Lco/vine/android/ProfileFragment;->mAppController:Lco/vine/android/client/AppController;

    iget-wide v4, p0, Lco/vine/android/ProfileFragment;->mUserId:J

    invoke-virtual {v3, v4, v5}, Lco/vine/android/client/AppController;->unblockUser(J)Ljava/lang/String;

    goto :goto_1

    .line 307
    :cond_2
    iget-object v3, p0, Lco/vine/android/ProfileFragment;->mAppController:Lco/vine/android/client/AppController;

    iget-wide v4, p0, Lco/vine/android/ProfileFragment;->mUserId:J

    invoke-virtual {v3, v4, v5}, Lco/vine/android/client/AppController;->blockUser(J)Ljava/lang/String;

    goto :goto_1

    .line 312
    :pswitch_1
    iget-object v3, p0, Lco/vine/android/ProfileFragment;->mAppController:Lco/vine/android/client/AppController;

    iget-wide v4, p0, Lco/vine/android/ProfileFragment;->mUserId:J

    invoke-virtual {v3, v4, v5}, Lco/vine/android/client/AppController;->reportPerson(J)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p0, v3}, Lco/vine/android/ProfileFragment;->addRequest(Ljava/lang/String;)Ljava/lang/String;

    goto :goto_1

    .line 316
    :pswitch_2
    iget-object v3, p0, Lco/vine/android/ProfileFragment;->mUser:Lco/vine/android/api/VineUser;

    if-eqz v3, :cond_1

    .line 317
    iget-object v3, p0, Lco/vine/android/ProfileFragment;->mUser:Lco/vine/android/api/VineUser;

    invoke-virtual {v3}, Lco/vine/android/api/VineUser;->areRepostsEnabled()Z

    move-result v3

    if-eqz v3, :cond_3

    .line 318
    iget-object v3, p0, Lco/vine/android/ProfileFragment;->mAppController:Lco/vine/android/client/AppController;

    iget-wide v4, p0, Lco/vine/android/ProfileFragment;->mUserId:J

    invoke-virtual {v3, v4, v5}, Lco/vine/android/client/AppController;->disableReposts(J)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p0, v3}, Lco/vine/android/ProfileFragment;->addRequest(Ljava/lang/String;)Ljava/lang/String;

    goto :goto_1

    .line 320
    :cond_3
    iget-object v3, p0, Lco/vine/android/ProfileFragment;->mAppController:Lco/vine/android/client/AppController;

    iget-wide v4, p0, Lco/vine/android/ProfileFragment;->mUserId:J

    invoke-virtual {v3, v4, v5}, Lco/vine/android/client/AppController;->enableReposts(J)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p0, v3}, Lco/vine/android/ProfileFragment;->addRequest(Ljava/lang/String;)Ljava/lang/String;

    goto :goto_1

    .line 326
    :pswitch_3
    iget-object v3, p0, Lco/vine/android/ProfileFragment;->mUser:Lco/vine/android/api/VineUser;

    if-eqz v3, :cond_1

    iget-boolean v3, p0, Lco/vine/android/ProfileFragment;->mIsMe:Z

    if-nez v3, :cond_1

    .line 327
    invoke-static {}, Lco/vine/android/util/FlurryUtils;->trackShareProfile()V

    .line 328
    new-instance v1, Landroid/content/Intent;

    const-string v3, "android.intent.action.SEND"

    invoke-direct {v1, v3}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 329
    .local v1, "share":Landroid/content/Intent;
    const-string v3, "text/plain"

    invoke-virtual {v1, v3}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    .line 330
    const/high16 v3, 0x80000

    invoke-virtual {v1, v3}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 331
    const-string v3, "android.intent.extra.SUBJECT"

    const-string v4, ""

    invoke-virtual {v1, v3, v4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 332
    const-string v3, "android.intent.extra.TEXT"

    invoke-virtual {p0}, Lco/vine/android/ProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v4

    iget-object v5, p0, Lco/vine/android/ProfileFragment;->mUser:Lco/vine/android/api/VineUser;

    iget-object v5, v5, Lco/vine/android/api/VineUser;->username:Ljava/lang/String;

    iget-object v6, p0, Lco/vine/android/ProfileFragment;->mUser:Lco/vine/android/api/VineUser;

    iget-wide v6, v6, Lco/vine/android/api/VineUser;->userId:J

    invoke-static {v4, v5, v6, v7}, Lco/vine/android/util/Util;->getShareProfileMessage(Landroid/content/Context;Ljava/lang/String;J)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v3, v4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 334
    const v3, 0x7f0e01be

    invoke-virtual {p0, v3}, Lco/vine/android/ProfileFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-static {v1, v3}, Landroid/content/Intent;->createChooser(Landroid/content/Intent;Ljava/lang/CharSequence;)Landroid/content/Intent;

    move-result-object v3

    invoke-virtual {p0, v3}, Lco/vine/android/ProfileFragment;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_1

    .line 339
    .end local v1    # "share":Landroid/content/Intent;
    :pswitch_4
    iget-object v3, p0, Lco/vine/android/ProfileFragment;->mUser:Lco/vine/android/api/VineUser;

    if-eqz v3, :cond_0

    .line 341
    new-instance v3, Lco/vine/android/util/image/ImageKey;

    iget-object v4, p0, Lco/vine/android/ProfileFragment;->mUser:Lco/vine/android/api/VineUser;

    iget-object v4, v4, Lco/vine/android/api/VineUser;->avatarUrl:Ljava/lang/String;

    invoke-direct {v3, v4, v2}, Lco/vine/android/util/image/ImageKey;-><init>(Ljava/lang/String;Z)V

    iput-object v3, p0, Lco/vine/android/ProfileFragment;->mUserProfileImageKeyForShortcut:Lco/vine/android/util/image/ImageKey;

    .line 342
    iget-object v2, p0, Lco/vine/android/ProfileFragment;->mUser:Lco/vine/android/api/VineUser;

    iget-object v2, v2, Lco/vine/android/api/VineUser;->avatarUrl:Ljava/lang/String;

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_4

    iget-object v2, p0, Lco/vine/android/ProfileFragment;->mUser:Lco/vine/android/api/VineUser;

    iget-object v2, v2, Lco/vine/android/api/VineUser;->avatarUrl:Ljava/lang/String;

    invoke-static {v2}, Lco/vine/android/util/Util;->isDefaultAvatarUrl(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_5

    .line 344
    :cond_4
    invoke-virtual {p0}, Lco/vine/android/ProfileFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f020065

    invoke-static {v2, v3}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 348
    .local v0, "bitmap":Landroid/graphics/Bitmap;
    :goto_2
    if-eqz v0, :cond_0

    .line 349
    invoke-direct {p0, v0}, Lco/vine/android/ProfileFragment;->addProfileShortCut(Landroid/graphics/Bitmap;)V

    goto/16 :goto_0

    .line 346
    .end local v0    # "bitmap":Landroid/graphics/Bitmap;
    :cond_5
    iget-object v2, p0, Lco/vine/android/ProfileFragment;->mAppController:Lco/vine/android/client/AppController;

    iget-object v3, p0, Lco/vine/android/ProfileFragment;->mUserProfileImageKeyForShortcut:Lco/vine/android/util/image/ImageKey;

    invoke-virtual {v2, v3}, Lco/vine/android/client/AppController;->getPhotoBitmap(Lco/vine/android/util/image/ImageKey;)Landroid/graphics/Bitmap;

    move-result-object v0

    .restart local v0    # "bitmap":Landroid/graphics/Bitmap;
    goto :goto_2

    .line 302
    nop

    :pswitch_data_0
    .packed-switch 0x7f0a024c
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
    .end packed-switch
.end method

.method public onPause()V
    .locals 2

    .prologue
    .line 551
    invoke-super {p0}, Lco/vine/android/BaseTimelineFragment;->onPause()V

    .line 552
    iget-object v0, p0, Lco/vine/android/ProfileFragment;->mFeedAdapter:Lco/vine/android/widget/GenericTimelineAdapter;

    invoke-virtual {p0}, Lco/vine/android/ProfileFragment;->isFocused()Z

    move-result v1

    invoke-virtual {v0, v1}, Lco/vine/android/widget/GenericTimelineAdapter;->onPause(Z)V

    .line 553
    return-void
.end method

.method public onPrepareOptionsMenu(Landroid/view/Menu;)V
    .locals 3
    .param p1, "menu"    # Landroid/view/Menu;

    .prologue
    .line 382
    const v2, 0x7f0a024c

    invoke-interface {p1, v2}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v0

    .line 383
    .local v0, "block":Landroid/view/MenuItem;
    if-eqz v0, :cond_0

    .line 384
    iget-boolean v2, p0, Lco/vine/android/ProfileFragment;->mIsUserBlocked:Z

    if-eqz v2, :cond_2

    .line 385
    const v2, 0x7f0e0252

    invoke-interface {v0, v2}, Landroid/view/MenuItem;->setTitle(I)Landroid/view/MenuItem;

    .line 390
    :cond_0
    :goto_0
    const v2, 0x7f0a024e

    invoke-interface {p1, v2}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v2

    iput-object v2, p0, Lco/vine/android/ProfileFragment;->mHideRevines:Landroid/view/MenuItem;

    .line 392
    iget-object v2, p0, Lco/vine/android/ProfileFragment;->mUser:Lco/vine/android/api/VineUser;

    if-eqz v2, :cond_1

    iget-object v2, p0, Lco/vine/android/ProfileFragment;->mUser:Lco/vine/android/api/VineUser;

    invoke-virtual {v2}, Lco/vine/android/api/VineUser;->areRepostsEnabled()Z

    move-result v2

    if-eqz v2, :cond_3

    :cond_1
    const/4 v1, 0x1

    .line 393
    .local v1, "revinesEnabled":Z
    :goto_1
    iget-object v2, p0, Lco/vine/android/ProfileFragment;->mUser:Lco/vine/android/api/VineUser;

    invoke-direct {p0, v2, v1}, Lco/vine/android/ProfileFragment;->setRevineOptionText(Lco/vine/android/api/VineUser;Z)V

    .line 394
    return-void

    .line 387
    .end local v1    # "revinesEnabled":Z
    :cond_2
    const v2, 0x7f0e0053

    invoke-interface {v0, v2}, Landroid/view/MenuItem;->setTitle(I)Landroid/view/MenuItem;

    goto :goto_0

    .line 392
    :cond_3
    const/4 v1, 0x0

    goto :goto_1
.end method

.method public onResume()V
    .locals 5

    .prologue
    const/4 v4, 0x1

    .line 190
    invoke-super {p0}, Lco/vine/android/BaseTimelineFragment;->onResume()V

    .line 191
    iget-wide v0, p0, Lco/vine/android/ProfileFragment;->mUserId:J

    invoke-virtual {p0}, Lco/vine/android/ProfileFragment;->getAppController()Lco/vine/android/client/AppController;

    move-result-object v2

    invoke-virtual {v2}, Lco/vine/android/client/AppController;->getActiveId()J

    move-result-wide v2

    cmp-long v0, v0, v2

    if-nez v0, :cond_0

    .line 192
    invoke-virtual {p0}, Lco/vine/android/ProfileFragment;->registerMergePostReceiver()V

    .line 194
    :cond_0
    iget-object v0, p0, Lco/vine/android/ProfileFragment;->mAdapter:Landroid/widget/BaseAdapter;

    invoke-virtual {v0}, Landroid/widget/BaseAdapter;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 195
    const/4 v0, 0x3

    invoke-virtual {p0, v0, v4}, Lco/vine/android/ProfileFragment;->fetchContent(IZ)V

    .line 197
    :cond_1
    iget-boolean v0, p0, Lco/vine/android/ProfileFragment;->mIsMe:Z

    if-eqz v0, :cond_2

    .line 198
    invoke-virtual {p0}, Lco/vine/android/ProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lco/vine/android/util/Util;->getDefaultSharedPrefs(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v0

    const-string v1, "profile_hide_reposts"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    iput-boolean v0, p0, Lco/vine/android/ProfileFragment;->mHideProfileReposts:Z

    .line 200
    invoke-virtual {p0}, Lco/vine/android/ProfileFragment;->isFocused()Z

    move-result v0

    invoke-direct {p0, v0}, Lco/vine/android/ProfileFragment;->setup(Z)V

    .line 202
    :cond_2
    invoke-direct {p0}, Lco/vine/android/ProfileFragment;->initProfile()V

    .line 203
    iget-boolean v0, p0, Lco/vine/android/ProfileFragment;->mColorChangedReceiverIsRegistered:Z

    if-nez v0, :cond_3

    .line 204
    iput-boolean v4, p0, Lco/vine/android/ProfileFragment;->mColorChangedReceiverIsRegistered:Z

    .line 205
    invoke-virtual {p0}, Lco/vine/android/ProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    iget-object v1, p0, Lco/vine/android/ProfileFragment;->mColorChangedReceiver:Lco/vine/android/ProfileFragment$ColorChangedReceiver;

    sget-object v2, Lco/vine/android/util/Util;->COLOR_CHANGED_INTENT_FILTER:Landroid/content/IntentFilter;

    const-string v3, "co.vine.android.BROADCAST"

    const/4 v4, 0x0

    invoke-virtual {v0, v1, v2, v3, v4}, Landroid/support/v4/app/FragmentActivity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;Ljava/lang/String;Landroid/os/Handler;)Landroid/content/Intent;

    .line 207
    :cond_3
    return-void
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "outState"    # Landroid/os/Bundle;

    .prologue
    .line 462
    invoke-super {p0, p1}, Lco/vine/android/BaseTimelineFragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 463
    const-string v0, "state_mode"

    iget v1, p0, Lco/vine/android/ProfileFragment;->mCurrentMode:I

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 464
    const-string v0, "stated_header_added"

    iget-boolean v1, p0, Lco/vine/android/ProfileFragment;->mHeaderAdded:Z

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 465
    return-void
.end method

.method protected onScrollLastItem()V
    .locals 3

    .prologue
    const/4 v2, 0x1

    .line 471
    iget-boolean v0, p0, Lco/vine/android/ProfileFragment;->mRefreshable:Z

    if-eqz v0, :cond_0

    .line 472
    iget v0, p0, Lco/vine/android/ProfileFragment;->mNextPage:I

    if-lez v0, :cond_0

    iget-object v0, p0, Lco/vine/android/ProfileFragment;->mFeedAdapter:Lco/vine/android/widget/GenericTimelineAdapter;

    invoke-virtual {v0}, Lco/vine/android/widget/GenericTimelineAdapter;->getCount()I

    move-result v0

    const/16 v1, 0x190

    if-gt v0, v1, :cond_0

    .line 473
    iget-object v0, p0, Lco/vine/android/ProfileFragment;->mFeedAdapter:Lco/vine/android/widget/GenericTimelineAdapter;

    invoke-virtual {p0}, Lco/vine/android/ProfileFragment;->isFocused()Z

    move-result v1

    invoke-virtual {v0, v1}, Lco/vine/android/widget/GenericTimelineAdapter;->onPause(Z)V

    .line 474
    iput v2, p0, Lco/vine/android/ProfileFragment;->mLastFetchType:I

    .line 475
    iget v0, p0, Lco/vine/android/ProfileFragment;->mCurrentMode:I

    packed-switch v0, :pswitch_data_0

    .line 493
    :cond_0
    :goto_0
    return-void

    .line 477
    :pswitch_0
    invoke-virtual {p0, v2}, Lco/vine/android/ProfileFragment;->showProgress(I)V

    .line 478
    invoke-virtual {p0, v2, v2}, Lco/vine/android/ProfileFragment;->fetchContent(IZ)V

    .line 479
    iget v0, p0, Lco/vine/android/ProfileFragment;->mPostPage:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lco/vine/android/ProfileFragment;->mPostPage:I

    .line 480
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "_Post"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iget v1, p0, Lco/vine/android/ProfileFragment;->mPostPage:I

    invoke-static {v0, v1}, Lco/vine/android/util/FlurryUtils;->trackTimeLinePageScroll(Ljava/lang/String;I)V

    goto :goto_0

    .line 484
    :pswitch_1
    invoke-virtual {p0, v2}, Lco/vine/android/ProfileFragment;->showProgress(I)V

    .line 485
    invoke-virtual {p0, v2, v2}, Lco/vine/android/ProfileFragment;->fetchContent(IZ)V

    .line 486
    iget v0, p0, Lco/vine/android/ProfileFragment;->mLikePage:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lco/vine/android/ProfileFragment;->mLikePage:I

    .line 487
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "_Like"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iget v1, p0, Lco/vine/android/ProfileFragment;->mLikePage:I

    invoke-static {v0, v1}, Lco/vine/android/util/FlurryUtils;->trackTimeLinePageScroll(Ljava/lang/String;I)V

    goto :goto_0

    .line 475
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;
    .param p2, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 411
    invoke-super {p0, p1, p2}, Lco/vine/android/BaseTimelineFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 412
    const/4 v0, 0x6

    invoke-virtual {p0, v0}, Lco/vine/android/ProfileFragment;->setRefreshableHeaderOffset(I)V

    .line 413
    iget-object v0, p0, Lco/vine/android/ProfileFragment;->mListView:Landroid/widget/ListView;

    invoke-virtual {v0, p0}, Landroid/widget/ListView;->setOnScrollListener(Landroid/widget/AbsListView$OnScrollListener;)V

    .line 414
    const/4 v0, 0x3

    invoke-virtual {p0, v0}, Lco/vine/android/ProfileFragment;->showProgress(I)V

    .line 415
    return-void
.end method

.method protected refresh()V
    .locals 3

    .prologue
    .line 497
    const/4 v0, 0x2

    const/4 v1, 0x1

    invoke-virtual {p0, v0, v1}, Lco/vine/android/ProfileFragment;->fetchContent(IZ)V

    .line 498
    iget-boolean v0, p0, Lco/vine/android/ProfileFragment;->mIsMe:Z

    if-eqz v0, :cond_0

    .line 499
    iget-object v0, p0, Lco/vine/android/ProfileFragment;->mAppController:Lco/vine/android/client/AppController;

    iget-object v1, p0, Lco/vine/android/ProfileFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v1}, Lco/vine/android/client/AppController;->getActiveId()J

    move-result-wide v1

    invoke-virtual {v0, v1, v2}, Lco/vine/android/client/AppController;->fetchUsersMe(J)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lco/vine/android/ProfileFragment;->addRequest(Ljava/lang/String;)Ljava/lang/String;

    .line 503
    :goto_0
    return-void

    .line 501
    :cond_0
    iget-object v0, p0, Lco/vine/android/ProfileFragment;->mAppController:Lco/vine/android/client/AppController;

    iget-wide v1, p0, Lco/vine/android/ProfileFragment;->mUserId:J

    invoke-virtual {v0, v1, v2}, Lco/vine/android/client/AppController;->fetchUser(J)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lco/vine/android/ProfileFragment;->addRequest(Ljava/lang/String;)Ljava/lang/String;

    goto :goto_0
.end method

.method public setActionBarColor()V
    .locals 4

    .prologue
    .line 771
    invoke-virtual {p0}, Lco/vine/android/ProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    .line 772
    .local v0, "activity":Landroid/app/Activity;
    instance-of v1, v0, Lco/vine/android/BaseActionBarActivity;

    if-eqz v1, :cond_1

    .line 774
    iget v1, p0, Lco/vine/android/ProfileFragment;->mProfileBackground:I

    if-nez v1, :cond_0

    .line 775
    invoke-virtual {p0}, Lco/vine/android/ProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-static {v1}, Lco/vine/android/util/Util;->getDefaultSharedPrefs(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v1

    const-string v2, "profile_background"

    sget v3, Lco/vine/android/Settings;->DEFAULT_PROFILE_COLOR:I

    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v1

    iput v1, p0, Lco/vine/android/ProfileFragment;->mProfileBackground:I

    .line 778
    :cond_0
    check-cast v0, Lco/vine/android/BaseActionBarActivity;

    .end local v0    # "activity":Landroid/app/Activity;
    iget v1, p0, Lco/vine/android/ProfileFragment;->mProfileBackground:I

    invoke-virtual {v0, v1}, Lco/vine/android/BaseActionBarActivity;->setActionBarColor(I)V

    .line 780
    :cond_1
    return-void
.end method
