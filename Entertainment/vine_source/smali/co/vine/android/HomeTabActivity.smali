.class public Lco/vine/android/HomeTabActivity;
.super Lco/vine/android/BaseTimelineActivity;
.source "HomeTabActivity.java"

# interfaces
.implements Landroid/widget/TabHost$OnTabChangeListener;
.implements Lco/vine/android/widget/tabs/IconTabHost$OnTabClickedListener;
.implements Landroid/view/View$OnLongClickListener;
.implements Lco/vine/android/widgets/PromptDialogSupportFragment$OnDialogDoneListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/HomeTabActivity$HomeTabSessionListener;,
        Lco/vine/android/HomeTabActivity$DelayHandler;,
        Lco/vine/android/HomeTabActivity$HomeTabTabsAdapter;
    }
.end annotation


# static fields
.field public static final ACTION_VERIFICATION_COMPLETE:Ljava/lang/String;

.field public static final ACTION_VM_SENT:Ljava/lang/String; = "co.vine.android.VM_SENT"

.field private static ACTIVITY_COUNT_FILTER:Landroid/content/IntentFilter; = null

.field public static final DIALOG_STORE_CONTACTS:I = 0x1

.field public static final HOST_POST:Ljava/lang/String; = "post"

.field public static final HOST_TIMELINES:Ljava/lang/String; = "timelines"

.field public static final INDEX_ACTIVITY_TAB:I = 0x1

.field public static final INDEX_EXPLORE_TAB:I = 0x2

.field public static final INDEX_PROFILE_TAB:I = 0x3

.field public static final PREFIX_CONFIRM_EMAIL:Ljava/lang/String; = "confirmEmail"

.field public static final PREFIX_SHARED_VIDEO:Ljava/lang/String; = "v"

.field public static final PREFIX_USER_ID:Ljava/lang/String; = "u"

.field public static final REQUEST_CODE_VIEW_NOTIF:I = 0x1

.field public static final REQUEST_CODE_VM_ONBOARD:I = 0x2

.field public static final SCHEME_VINE:Ljava/lang/String; = "vine"

.field public static final TAG_ACTIVITY:Ljava/lang/String; = "activity"

.field public static final TAG_EXPLORE:Ljava/lang/String; = "explore"

.field public static final TAG_HOME:Ljava/lang/String; = "home"

.field public static final TAG_PROFILE:Ljava/lang/String; = "profile"


# instance fields
.field private mActivityCount:I

.field private mActivityCountReceiver:Landroid/content/BroadcastReceiver;

.field private mExploreRefreshReciver:Landroid/content/BroadcastReceiver;

.field private mExploreRefreshReciverIsRegistered:Z

.field private final mHandler:Landroid/os/Handler;

.field private mInboxMenu:Landroid/view/MenuItem;

.field private mLastMessageMap:Landroid/support/v4/util/LongSparseArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/support/v4/util/LongSparseArray",
            "<",
            "Ljava/lang/Long;",
            ">;"
        }
    .end annotation
.end field

.field private mMenu:Landroid/view/Menu;

.field private mMessageCount:I

.field private mRecentTab:Ljava/lang/String;

.field private mScrollAwayNavEnabled:Z

.field private mShouldShowMenu:Z

.field private mTabHost:Lco/vine/android/widget/tabs/IconTabHost;

.field private mTabsAdapter:Lco/vine/android/widget/tabs/TabsAdapter;

.field private mViewPager:Landroid/support/v4/view/ViewPager;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 91
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lco/vine/android/util/BuildUtil;->getAuthority()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ".EMAIL_VERIFIED"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lco/vine/android/HomeTabActivity;->ACTION_VERIFICATION_COMPLETE:Ljava/lang/String;

    .line 116
    new-instance v0, Landroid/content/IntentFilter;

    invoke-direct {v0}, Landroid/content/IntentFilter;-><init>()V

    sput-object v0, Lco/vine/android/HomeTabActivity;->ACTIVITY_COUNT_FILTER:Landroid/content/IntentFilter;

    .line 119
    sget-object v0, Lco/vine/android/HomeTabActivity;->ACTIVITY_COUNT_FILTER:Landroid/content/IntentFilter;

    const-string v1, "co.vine.android.service.activityCounts"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 120
    return-void
.end method

.method public constructor <init>()V
    .locals 2

    .prologue
    .line 80
    invoke-direct {p0}, Lco/vine/android/BaseTimelineActivity;-><init>()V

    .line 123
    new-instance v0, Lco/vine/android/HomeTabActivity$1;

    invoke-direct {v0, p0}, Lco/vine/android/HomeTabActivity$1;-><init>(Lco/vine/android/HomeTabActivity;)V

    iput-object v0, p0, Lco/vine/android/HomeTabActivity;->mActivityCountReceiver:Landroid/content/BroadcastReceiver;

    .line 140
    new-instance v0, Lco/vine/android/HomeTabActivity$2;

    invoke-direct {v0, p0}, Lco/vine/android/HomeTabActivity$2;-><init>(Lco/vine/android/HomeTabActivity;)V

    iput-object v0, p0, Lco/vine/android/HomeTabActivity;->mExploreRefreshReciver:Landroid/content/BroadcastReceiver;

    .line 155
    new-instance v0, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    iput-object v0, p0, Lco/vine/android/HomeTabActivity;->mHandler:Landroid/os/Handler;

    .line 157
    const/4 v0, 0x1

    iput-boolean v0, p0, Lco/vine/android/HomeTabActivity;->mScrollAwayNavEnabled:Z

    .line 991
    return-void
.end method

.method static synthetic access$002(Lco/vine/android/HomeTabActivity;I)I
    .locals 0
    .param p0, "x0"    # Lco/vine/android/HomeTabActivity;
    .param p1, "x1"    # I

    .prologue
    .line 80
    iput p1, p0, Lco/vine/android/HomeTabActivity;->mActivityCount:I

    return p1
.end method

.method static synthetic access$102(Lco/vine/android/HomeTabActivity;I)I
    .locals 0
    .param p0, "x0"    # Lco/vine/android/HomeTabActivity;
    .param p1, "x1"    # I

    .prologue
    .line 80
    iput p1, p0, Lco/vine/android/HomeTabActivity;->mMessageCount:I

    return p1
.end method

.method static synthetic access$200(Lco/vine/android/HomeTabActivity;)V
    .locals 0
    .param p0, "x0"    # Lco/vine/android/HomeTabActivity;

    .prologue
    .line 80
    invoke-direct {p0}, Lco/vine/android/HomeTabActivity;->invalidateMessagesBadge()V

    return-void
.end method

.method static synthetic access$300(Lco/vine/android/HomeTabActivity;)Lco/vine/android/widget/tabs/TabsAdapter;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/HomeTabActivity;

    .prologue
    .line 80
    iget-object v0, p0, Lco/vine/android/HomeTabActivity;->mTabsAdapter:Lco/vine/android/widget/tabs/TabsAdapter;

    return-object v0
.end method

.method static synthetic access$400(Lco/vine/android/HomeTabActivity;)Landroid/support/v4/view/ViewPager;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/HomeTabActivity;

    .prologue
    .line 80
    iget-object v0, p0, Lco/vine/android/HomeTabActivity;->mViewPager:Landroid/support/v4/view/ViewPager;

    return-object v0
.end method

.method static synthetic access$500(Lco/vine/android/HomeTabActivity;)Landroid/support/v4/util/LongSparseArray;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/HomeTabActivity;

    .prologue
    .line 80
    iget-object v0, p0, Lco/vine/android/HomeTabActivity;->mLastMessageMap:Landroid/support/v4/util/LongSparseArray;

    return-object v0
.end method

.method private fetchClientFlags()V
    .locals 3

    .prologue
    .line 705
    :try_start_0
    invoke-static {p0}, Lco/vine/android/util/Util;->getActiveNetworkType(Landroid/content/Context;)I

    move-result v1

    if-nez v1, :cond_0

    invoke-static {p0}, Lco/vine/android/util/ClientFlagsHelper;->isClientFlagsTtlInRange(Landroid/content/Context;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 707
    iget-object v1, p0, Lco/vine/android/HomeTabActivity;->mAppController:Lco/vine/android/client/AppController;

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Lco/vine/android/client/AppController;->fetchClientFlags(Z)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 712
    :cond_0
    :goto_0
    return-void

    .line 709
    :catch_0
    move-exception v0

    .line 710
    .local v0, "e":Ljava/lang/Exception;
    invoke-static {v0}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method private invalidateMessagesBadge()V
    .locals 9

    .prologue
    const/4 v8, 0x2

    .line 802
    invoke-virtual {p0}, Lco/vine/android/HomeTabActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    .line 803
    .local v3, "res":Landroid/content/res/Resources;
    if-eqz v3, :cond_2

    iget-object v4, p0, Lco/vine/android/HomeTabActivity;->mInboxMenu:Landroid/view/MenuItem;

    if-eqz v4, :cond_2

    .line 804
    iget-object v4, p0, Lco/vine/android/HomeTabActivity;->mInboxMenu:Landroid/view/MenuItem;

    invoke-interface {v4}, Landroid/view/MenuItem;->getIcon()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .line 805
    .local v0, "currentDrawable":Landroid/graphics/drawable/Drawable;
    const/4 v1, 0x0

    .line 806
    .local v1, "inboxBadgeDrawable":Lco/vine/android/drawable/CenteredTextDrawable;
    instance-of v4, v0, Lco/vine/android/drawable/CenteredTextDrawable;

    if-eqz v4, :cond_0

    move-object v1, v0

    .line 807
    check-cast v1, Lco/vine/android/drawable/CenteredTextDrawable;

    .line 809
    :cond_0
    if-nez v1, :cond_1

    .line 810
    new-instance v1, Lco/vine/android/drawable/CenteredTextDrawable;

    .end local v1    # "inboxBadgeDrawable":Lco/vine/android/drawable/CenteredTextDrawable;
    new-array v4, v8, [I

    fill-array-data v4, :array_0

    invoke-direct {v1, v3, v4}, Lco/vine/android/drawable/CenteredTextDrawable;-><init>(Landroid/content/res/Resources;[I)V

    .line 811
    .restart local v1    # "inboxBadgeDrawable":Lco/vine/android/drawable/CenteredTextDrawable;
    const/4 v4, 0x1

    new-instance v5, Landroid/graphics/PorterDuffColorFilter;

    invoke-static {p0}, Lco/vine/android/util/Util;->getProfileColor(Landroid/content/Context;)I

    move-result v6

    const/high16 v7, -0x1000000

    or-int/2addr v6, v7

    sget-object v7, Landroid/graphics/PorterDuff$Mode;->SRC_IN:Landroid/graphics/PorterDuff$Mode;

    invoke-direct {v5, v6, v7}, Landroid/graphics/PorterDuffColorFilter;-><init>(ILandroid/graphics/PorterDuff$Mode;)V

    invoke-virtual {v1, v4, v5}, Lco/vine/android/drawable/CenteredTextDrawable;->setColorFilter(ILandroid/graphics/ColorFilter;)V

    .line 812
    const/high16 v4, 0x40c00000    # 6.0f

    invoke-virtual {v3}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v5

    iget v5, v5, Landroid/util/DisplayMetrics;->density:F

    mul-float/2addr v4, v5

    float-to-int v2, v4

    .line 813
    .local v2, "padding":I
    new-instance v4, Landroid/graphics/Rect;

    invoke-direct {v4, v2, v2, v2, v2}, Landroid/graphics/Rect;-><init>(IIII)V

    invoke-virtual {v1, v4}, Lco/vine/android/drawable/CenteredTextDrawable;->setTextPadding(Landroid/graphics/Rect;)V

    .line 814
    const/4 v4, -0x1

    invoke-virtual {v1, v4}, Lco/vine/android/drawable/CenteredTextDrawable;->setTextColor(I)V

    .line 815
    invoke-static {p0}, Lco/vine/android/widget/Typefaces;->get(Landroid/content/Context;)Lco/vine/android/widget/Typefaces;

    move-result-object v4

    iget-object v4, v4, Lco/vine/android/widget/Typefaces;->boldContentBold:Landroid/graphics/Typeface;

    invoke-virtual {v1, v4}, Lco/vine/android/drawable/CenteredTextDrawable;->setTypeFace(Landroid/graphics/Typeface;)V

    .line 816
    const/high16 v4, 0x41400000    # 12.0f

    invoke-virtual {v3}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v5

    invoke-static {v8, v4, v5}, Landroid/util/TypedValue;->applyDimension(IFLandroid/util/DisplayMetrics;)F

    move-result v4

    invoke-virtual {v1, v4}, Lco/vine/android/drawable/CenteredTextDrawable;->setTextSize(F)V

    .line 819
    .end local v2    # "padding":I
    :cond_1
    iget v4, p0, Lco/vine/android/HomeTabActivity;->mMessageCount:I

    if-nez v4, :cond_3

    .line 820
    iget-object v4, p0, Lco/vine/android/HomeTabActivity;->mInboxMenu:Landroid/view/MenuItem;

    const v5, 0x7f020134

    invoke-interface {v4, v5}, Landroid/view/MenuItem;->setIcon(I)Landroid/view/MenuItem;

    .line 827
    .end local v0    # "currentDrawable":Landroid/graphics/drawable/Drawable;
    .end local v1    # "inboxBadgeDrawable":Lco/vine/android/drawable/CenteredTextDrawable;
    :cond_2
    :goto_0
    return-void

    .line 822
    .restart local v0    # "currentDrawable":Landroid/graphics/drawable/Drawable;
    .restart local v1    # "inboxBadgeDrawable":Lco/vine/android/drawable/CenteredTextDrawable;
    :cond_3
    iget v4, p0, Lco/vine/android/HomeTabActivity;->mMessageCount:I

    const/16 v5, 0x63

    if-le v4, v5, :cond_4

    const-string v4, "99+"

    :goto_1
    invoke-virtual {v1, v4}, Lco/vine/android/drawable/CenteredTextDrawable;->setText(Ljava/lang/String;)V

    .line 824
    iget-object v4, p0, Lco/vine/android/HomeTabActivity;->mInboxMenu:Landroid/view/MenuItem;

    invoke-interface {v4, v1}, Landroid/view/MenuItem;->setIcon(Landroid/graphics/drawable/Drawable;)Landroid/view/MenuItem;

    goto :goto_0

    .line 822
    :cond_4
    iget v4, p0, Lco/vine/android/HomeTabActivity;->mMessageCount:I

    invoke-static {v4}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v4

    goto :goto_1

    .line 810
    :array_0
    .array-data 4
        0x7f02027f
        0x7f02027e
    .end array-data
.end method

.method private logTabChange(Ljava/lang/String;)V
    .locals 4
    .param p1, "tag"    # Ljava/lang/String;

    .prologue
    .line 608
    const-string v0, "Current Tab"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " - "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lco/vine/android/util/CrashUtil;->set(Ljava/lang/String;Ljava/lang/String;)V

    .line 609
    if-eqz p1, :cond_0

    const-string v0, "switcher"

    invoke-virtual {p1, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 610
    invoke-static {p1}, Lco/vine/android/util/FlurryUtils;->trackTabChange(Ljava/lang/String;)V

    .line 612
    :cond_0
    return-void
.end method

.method private makeAcitivytNewIndicator(Landroid/content/res/Resources;)Lco/vine/android/drawable/CenteredTextDrawable;
    .locals 6
    .param p1, "res"    # Landroid/content/res/Resources;

    .prologue
    const/4 v5, 0x0

    .line 861
    invoke-virtual {p1}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v3

    iget v0, v3, Landroid/util/DisplayMetrics;->density:F

    .line 862
    .local v0, "density":F
    new-instance v1, Landroid/graphics/drawable/GradientDrawable;

    invoke-direct {v1}, Landroid/graphics/drawable/GradientDrawable;-><init>()V

    .line 863
    .local v1, "drawable1":Landroid/graphics/drawable/GradientDrawable;
    const/high16 v3, 0x40000000    # 2.0f

    mul-float/2addr v3, v0

    float-to-int v3, v3

    const v4, -0xdbdbdc

    invoke-virtual {v1, v3, v4}, Landroid/graphics/drawable/GradientDrawable;->setStroke(II)V

    .line 864
    invoke-virtual {v1, v5}, Landroid/graphics/drawable/GradientDrawable;->setShape(I)V

    .line 865
    const/high16 v3, 0x40800000    # 4.0f

    mul-float/2addr v3, v0

    invoke-virtual {v1, v3}, Landroid/graphics/drawable/GradientDrawable;->setCornerRadius(F)V

    .line 866
    const v3, 0x7f090096

    invoke-virtual {p1, v3}, Landroid/content/res/Resources;->getColor(I)I

    move-result v3

    invoke-virtual {v1, v3}, Landroid/graphics/drawable/GradientDrawable;->setColor(I)V

    .line 867
    const/high16 v3, 0x41980000    # 19.0f

    mul-float/2addr v3, v0

    float-to-int v3, v3

    const/high16 v4, 0x41a00000    # 20.0f

    mul-float/2addr v4, v0

    float-to-int v4, v4

    invoke-virtual {v1, v3, v4}, Landroid/graphics/drawable/GradientDrawable;->setSize(II)V

    .line 868
    new-instance v2, Lco/vine/android/drawable/CenteredTextDrawable;

    const/4 v3, 0x1

    new-array v3, v3, [Landroid/graphics/drawable/Drawable;

    aput-object v1, v3, v5

    invoke-direct {v2, v3}, Lco/vine/android/drawable/CenteredTextDrawable;-><init>([Landroid/graphics/drawable/Drawable;)V

    .line 869
    .local v2, "textDrawable":Lco/vine/android/drawable/CenteredTextDrawable;
    const/4 v3, -0x1

    invoke-virtual {v2, v3}, Lco/vine/android/drawable/CenteredTextDrawable;->setTextColor(I)V

    .line 870
    invoke-static {p0}, Lco/vine/android/widget/Typefaces;->get(Landroid/content/Context;)Lco/vine/android/widget/Typefaces;

    move-result-object v3

    iget-object v3, v3, Lco/vine/android/widget/Typefaces;->boldContentBold:Landroid/graphics/Typeface;

    invoke-virtual {v2, v3}, Lco/vine/android/drawable/CenteredTextDrawable;->setTypeFace(Landroid/graphics/Typeface;)V

    .line 871
    const/4 v3, 0x2

    const/high16 v4, 0x41400000    # 12.0f

    invoke-virtual {p1}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v5

    invoke-static {v3, v4, v5}, Landroid/util/TypedValue;->applyDimension(IFLandroid/util/DisplayMetrics;)F

    move-result v3

    invoke-virtual {v2, v3}, Lco/vine/android/drawable/CenteredTextDrawable;->setTextSize(F)V

    .line 873
    return-object v2
.end method

.method private setupTabs()V
    .locals 2

    .prologue
    .line 769
    const v0, 0x1020012

    invoke-virtual {p0, v0}, Lco/vine/android/HomeTabActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lco/vine/android/widget/tabs/IconTabHost;

    iput-object v0, p0, Lco/vine/android/HomeTabActivity;->mTabHost:Lco/vine/android/widget/tabs/IconTabHost;

    .line 770
    iget-object v0, p0, Lco/vine/android/HomeTabActivity;->mTabHost:Lco/vine/android/widget/tabs/IconTabHost;

    if-nez v0, :cond_0

    .line 771
    new-instance v0, Ljava/lang/RuntimeException;

    const-string v1, "Your content must have a TabHost whose id attribute is \'android.R.id.tabhost\'"

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 776
    :cond_0
    iget-object v0, p0, Lco/vine/android/HomeTabActivity;->mTabHost:Lco/vine/android/widget/tabs/IconTabHost;

    invoke-virtual {v0}, Lco/vine/android/widget/tabs/IconTabHost;->setup()V

    .line 777
    const v0, 0x7f0a00da

    invoke-virtual {p0, v0}, Lco/vine/android/HomeTabActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/support/v4/view/ViewPager;

    iput-object v0, p0, Lco/vine/android/HomeTabActivity;->mViewPager:Landroid/support/v4/view/ViewPager;

    .line 778
    return-void
.end method

.method private showSlidingMenuWithVmOnboard()V
    .locals 4

    .prologue
    .line 727
    iget-object v0, p0, Lco/vine/android/HomeTabActivity;->mHandler:Landroid/os/Handler;

    new-instance v1, Lco/vine/android/HomeTabActivity$4;

    invoke-direct {v1, p0}, Lco/vine/android/HomeTabActivity$4;-><init>(Lco/vine/android/HomeTabActivity;)V

    const-wide/16 v2, 0xfa

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 734
    return-void
.end method

.method private showSlidingMenuWithVmOnboardAfterSend()V
    .locals 4

    .prologue
    .line 737
    iget-object v0, p0, Lco/vine/android/HomeTabActivity;->mHandler:Landroid/os/Handler;

    new-instance v1, Lco/vine/android/HomeTabActivity$5;

    invoke-direct {v1, p0}, Lco/vine/android/HomeTabActivity$5;-><init>(Lco/vine/android/HomeTabActivity;)V

    const-wide/16 v2, 0xfa

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 744
    return-void
.end method

.method private showSlidingMenuWithoutOnboard()V
    .locals 4

    .prologue
    .line 715
    invoke-static {p0}, Lco/vine/android/util/Util;->getDefaultSharedPrefs(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "vmOnboardInProgress"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->apply()V

    .line 718
    iget-object v0, p0, Lco/vine/android/HomeTabActivity;->mHandler:Landroid/os/Handler;

    new-instance v1, Lco/vine/android/HomeTabActivity$3;

    invoke-direct {v1, p0}, Lco/vine/android/HomeTabActivity$3;-><init>(Lco/vine/android/HomeTabActivity;)V

    const-wide/16 v2, 0xfa

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 724
    return-void
.end method

.method public static start(Landroid/app/Activity;Ljava/lang/String;)V
    .locals 3
    .param p0, "activity"    # Landroid/app/Activity;
    .param p1, "tag"    # Ljava/lang/String;

    .prologue
    .line 781
    new-instance v1, Landroid/content/Intent;

    const-class v2, Lco/vine/android/HomeTabActivity;

    invoke-direct {v1, p0, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    const/high16 v2, 0x4000000

    invoke-virtual {v1, v2}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    move-result-object v0

    .line 783
    .local v0, "intent":Landroid/content/Intent;
    invoke-virtual {p0, v0}, Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V

    .line 784
    invoke-virtual {p0}, Landroid/app/Activity;->finish()V

    .line 785
    return-void
.end method

.method private trimSegment(Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p1, "segment"    # Ljava/lang/String;

    .prologue
    .line 415
    const-string v0, "\\s+"

    const-string v1, ""

    invoke-virtual {p1, v0, v1}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "\\"

    const-string v2, ""

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method protected getCurrentTimeLineFragment()Lco/vine/android/BaseTimelineFragment;
    .locals 4

    .prologue
    const/4 v2, 0x0

    .line 749
    :try_start_0
    iget-object v3, p0, Lco/vine/android/HomeTabActivity;->mTabsAdapter:Lco/vine/android/widget/tabs/TabsAdapter;

    invoke-virtual {v3}, Lco/vine/android/widget/tabs/TabsAdapter;->getCurrentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v1

    .line 750
    .local v1, "frag":Landroid/support/v4/app/Fragment;
    instance-of v3, v1, Lco/vine/android/BaseTimelineFragment;

    if-eqz v3, :cond_0

    .line 751
    check-cast v1, Lco/vine/android/BaseTimelineFragment;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 756
    .end local v1    # "frag":Landroid/support/v4/app/Fragment;
    :goto_0
    return-object v1

    .restart local v1    # "frag":Landroid/support/v4/app/Fragment;
    :cond_0
    move-object v1, v2

    .line 753
    goto :goto_0

    .line 755
    .end local v1    # "frag":Landroid/support/v4/app/Fragment;
    :catch_0
    move-exception v0

    .local v0, "e":Ljava/lang/Exception;
    move-object v1, v2

    .line 756
    goto :goto_0
.end method

.method public invalidateActivityBadge()V
    .locals 11

    .prologue
    const/16 v10, 0x63

    const/4 v8, 0x1

    .line 830
    iget-object v7, p0, Lco/vine/android/HomeTabActivity;->mTabsAdapter:Lco/vine/android/widget/tabs/TabsAdapter;

    if-eqz v7, :cond_4

    .line 831
    iget-object v9, p0, Lco/vine/android/HomeTabActivity;->mTabsAdapter:Lco/vine/android/widget/tabs/TabsAdapter;

    iget v7, p0, Lco/vine/android/HomeTabActivity;->mActivityCount:I

    if-lez v7, :cond_5

    move v7, v8

    :goto_0
    invoke-virtual {v9, v8, v7}, Lco/vine/android/widget/tabs/TabsAdapter;->setNew(IZ)V

    .line 832
    iget-object v7, p0, Lco/vine/android/HomeTabActivity;->mTabsAdapter:Lco/vine/android/widget/tabs/TabsAdapter;

    invoke-virtual {v7, v8}, Lco/vine/android/widget/tabs/TabsAdapter;->getNewIndicatorForTab(I)Landroid/widget/ImageView;

    move-result-object v1

    .line 833
    .local v1, "indicator":Landroid/widget/ImageView;
    invoke-virtual {p0}, Lco/vine/android/HomeTabActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    .line 834
    .local v5, "res":Landroid/content/res/Resources;
    if-eqz v5, :cond_4

    if-eqz v1, :cond_4

    .line 835
    invoke-virtual {v1}, Landroid/widget/ImageView;->getDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .line 836
    .local v0, "drawable":Landroid/graphics/drawable/Drawable;
    const/4 v6, 0x0

    .line 837
    .local v6, "textDrawable":Lco/vine/android/drawable/CenteredTextDrawable;
    instance-of v7, v0, Lco/vine/android/drawable/CenteredTextDrawable;

    if-eqz v7, :cond_0

    move-object v6, v0

    .line 838
    check-cast v6, Lco/vine/android/drawable/CenteredTextDrawable;

    .line 840
    :cond_0
    if-nez v6, :cond_1

    .line 841
    invoke-direct {p0, v5}, Lco/vine/android/HomeTabActivity;->makeAcitivytNewIndicator(Landroid/content/res/Resources;)Lco/vine/android/drawable/CenteredTextDrawable;

    move-result-object v6

    .line 842
    invoke-virtual {v1, v6}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 844
    :cond_1
    const/4 v2, 0x0

    .line 845
    .local v2, "minus":I
    iget v7, p0, Lco/vine/android/HomeTabActivity;->mActivityCount:I

    const/16 v8, 0x9

    if-le v7, v8, :cond_2

    .line 846
    add-int/lit8 v2, v2, 0x1

    .line 848
    :cond_2
    iget v7, p0, Lco/vine/android/HomeTabActivity;->mActivityCount:I

    if-le v7, v10, :cond_3

    .line 849
    add-int/lit8 v2, v2, 0x1

    .line 851
    :cond_3
    const/high16 v7, 0x40c00000    # 6.0f

    invoke-virtual {v5}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v8

    iget v8, v8, Landroid/util/DisplayMetrics;->density:F

    mul-float/2addr v7, v8

    float-to-int v4, v7

    .line 852
    .local v4, "paddingVertical":I
    mul-int/lit8 v7, v2, 0x2

    rsub-int/lit8 v7, v7, 0x6

    int-to-float v7, v7

    invoke-virtual {v5}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v8

    iget v8, v8, Landroid/util/DisplayMetrics;->density:F

    mul-float/2addr v7, v8

    float-to-int v3, v7

    .line 853
    .local v3, "paddingSides":I
    new-instance v7, Landroid/graphics/Rect;

    invoke-direct {v7, v3, v4, v3, v4}, Landroid/graphics/Rect;-><init>(IIII)V

    invoke-virtual {v6, v7}, Lco/vine/android/drawable/CenteredTextDrawable;->setTextPadding(Landroid/graphics/Rect;)V

    .line 854
    iget v7, p0, Lco/vine/android/HomeTabActivity;->mActivityCount:I

    if-le v7, v10, :cond_6

    const-string v7, "99+"

    :goto_1
    invoke-virtual {v6, v7}, Lco/vine/android/drawable/CenteredTextDrawable;->setText(Ljava/lang/String;)V

    .line 858
    .end local v0    # "drawable":Landroid/graphics/drawable/Drawable;
    .end local v1    # "indicator":Landroid/widget/ImageView;
    .end local v2    # "minus":I
    .end local v3    # "paddingSides":I
    .end local v4    # "paddingVertical":I
    .end local v5    # "res":Landroid/content/res/Resources;
    .end local v6    # "textDrawable":Lco/vine/android/drawable/CenteredTextDrawable;
    :cond_4
    return-void

    .line 831
    :cond_5
    const/4 v7, 0x0

    goto :goto_0

    .line 854
    .restart local v0    # "drawable":Landroid/graphics/drawable/Drawable;
    .restart local v1    # "indicator":Landroid/widget/ImageView;
    .restart local v2    # "minus":I
    .restart local v3    # "paddingSides":I
    .restart local v4    # "paddingVertical":I
    .restart local v5    # "res":Landroid/content/res/Resources;
    .restart local v6    # "textDrawable":Lco/vine/android/drawable/CenteredTextDrawable;
    :cond_6
    iget v7, p0, Lco/vine/android/HomeTabActivity;->mActivityCount:I

    invoke-static {v7}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v7

    goto :goto_1
.end method

.method protected isAutoCaptureIconEnabled()Z
    .locals 1

    .prologue
    .line 163
    const/4 v0, 0x0

    return v0
.end method

.method public isConversationSideMenuEnabled()Z
    .locals 1

    .prologue
    .line 168
    const/4 v0, 0x1

    return v0
.end method

.method public markActivitiesRead()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 579
    invoke-static {p0}, Lco/vine/android/util/Util;->getDefaultSharedPrefs(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "unread_notification_count"

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 581
    iput v2, p0, Lco/vine/android/HomeTabActivity;->mActivityCount:I

    .line 582
    invoke-virtual {p0}, Lco/vine/android/HomeTabActivity;->invalidateActivityBadge()V

    .line 583
    return-void
.end method

.method public markMessagesAsDismissed()V
    .locals 3

    .prologue
    .line 534
    invoke-static {p0}, Lco/vine/android/util/Util;->getDefaultSharedPrefs(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "pref_dismissed"

    const/4 v2, 0x1

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    .line 536
    return-void
.end method

.method protected onActivityResult(IILandroid/content/Intent;)V
    .locals 12
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    const/4 v11, 0x0

    const/4 v9, -0x1

    const/4 v10, 0x1

    .line 658
    iget-object v8, p0, Lco/vine/android/HomeTabActivity;->mTabsAdapter:Lco/vine/android/widget/tabs/TabsAdapter;

    if-eqz v8, :cond_0

    .line 659
    iget-object v8, p0, Lco/vine/android/HomeTabActivity;->mTabsAdapter:Lco/vine/android/widget/tabs/TabsAdapter;

    invoke-virtual {v8}, Lco/vine/android/widget/tabs/TabsAdapter;->getTabs()Ljava/util/ArrayList;

    move-result-object v7

    .line 660
    .local v7, "tabs":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/widget/tabs/TabInfo;>;"
    if-nez p1, :cond_1

    .line 661
    invoke-static {p0}, Lco/vine/android/util/Util;->getDefaultSharedPrefs(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v5

    .line 662
    .local v5, "sp":Landroid/content/SharedPreferences;
    invoke-interface {v5}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v8

    const-string v9, "inviteBannerWasClicked"

    invoke-interface {v8, v9, v10}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    move-result-object v8

    invoke-interface {v8}, Landroid/content/SharedPreferences$Editor;->apply()V

    .line 663
    const-string v8, "profile_follow_count"

    invoke-interface {v5, v8, v11}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v0

    .line 665
    .local v0, "followCount":I
    iget-object v8, p0, Lco/vine/android/HomeTabActivity;->mTabHost:Lco/vine/android/widget/tabs/IconTabHost;

    invoke-virtual {v8}, Lco/vine/android/widget/tabs/IconTabHost;->getCurrentTab()I

    move-result v8

    invoke-virtual {v7, v8}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Lco/vine/android/widget/tabs/TabInfo;

    invoke-virtual {v8}, Lco/vine/android/widget/tabs/TabInfo;->fragment()Landroid/support/v4/app/Fragment;

    move-result-object v3

    .line 666
    .local v3, "homeTimeline":Landroid/support/v4/app/Fragment;
    const/4 v8, 0x5

    if-le v0, v8, :cond_0

    instance-of v8, v3, Lco/vine/android/HomeTimelineFragment;

    if-eqz v8, :cond_0

    .line 667
    check-cast v3, Lco/vine/android/HomeTimelineFragment;

    .end local v3    # "homeTimeline":Landroid/support/v4/app/Fragment;
    invoke-virtual {v3}, Lco/vine/android/HomeTimelineFragment;->removeBanner()V

    .line 701
    .end local v0    # "followCount":I
    .end local v5    # "sp":Landroid/content/SharedPreferences;
    .end local v7    # "tabs":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/widget/tabs/TabInfo;>;"
    :cond_0
    :goto_0
    return-void

    .line 669
    .restart local v7    # "tabs":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/widget/tabs/TabInfo;>;"
    :cond_1
    if-ne p1, v10, :cond_3

    if-ne p2, v10, :cond_3

    .line 671
    invoke-virtual {v7}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v4

    .local v4, "i$":Ljava/util/Iterator;
    :cond_2
    :goto_1
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_0

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lco/vine/android/widget/tabs/TabInfo;

    .line 672
    .local v6, "tab":Lco/vine/android/widget/tabs/TabInfo;
    invoke-virtual {v6}, Lco/vine/android/widget/tabs/TabInfo;->fragment()Landroid/support/v4/app/Fragment;

    move-result-object v2

    .line 673
    .local v2, "fragment":Landroid/support/v4/app/Fragment;
    instance-of v8, v2, Lco/vine/android/BaseTimelineFragment;

    if-eqz v8, :cond_2

    .line 674
    invoke-virtual {v2, p1, p2, p3}, Landroid/support/v4/app/Fragment;->onActivityResult(IILandroid/content/Intent;)V

    goto :goto_1

    .line 677
    .end local v2    # "fragment":Landroid/support/v4/app/Fragment;
    .end local v4    # "i$":Ljava/util/Iterator;
    .end local v6    # "tab":Lco/vine/android/widget/tabs/TabInfo;
    :cond_3
    if-ne p1, v10, :cond_4

    if-ne p2, v9, :cond_4

    .line 678
    invoke-static {}, Lco/vine/android/util/BuildUtil;->isExplore()Z

    move-result v8

    if-eqz v8, :cond_0

    iget-object v8, p0, Lco/vine/android/HomeTabActivity;->mMenu:Landroid/view/Menu;

    if-eqz v8, :cond_0

    .line 679
    iget-object v8, p0, Lco/vine/android/HomeTabActivity;->mMenu:Landroid/view/Menu;

    const v9, 0x7f0a023c

    invoke-interface {v8, v9}, Landroid/view/Menu;->removeItem(I)V

    goto :goto_0

    .line 681
    :cond_4
    const/4 v8, 0x2

    if-ne p1, v8, :cond_7

    .line 682
    if-ne p2, v9, :cond_6

    .line 683
    invoke-static {p0}, Lco/vine/android/util/Util;->isCapableOfRecording(Landroid/content/Context;)Z

    move-result v8

    if-eqz v8, :cond_5

    .line 684
    invoke-direct {p0}, Lco/vine/android/HomeTabActivity;->showSlidingMenuWithVmOnboard()V

    .line 693
    :goto_2
    invoke-direct {p0}, Lco/vine/android/HomeTabActivity;->fetchClientFlags()V

    goto :goto_0

    .line 686
    :cond_5
    invoke-direct {p0}, Lco/vine/android/HomeTabActivity;->showSlidingMenuWithoutOnboard()V

    goto :goto_2

    .line 689
    :cond_6
    invoke-static {p0}, Lco/vine/android/util/Util;->getDefaultSharedPrefs(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v8

    invoke-interface {v8}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v8

    const-string v9, "vmOnboardInProgress"

    invoke-interface {v8, v9, v11}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    move-result-object v8

    invoke-interface {v8}, Landroid/content/SharedPreferences$Editor;->apply()V

    goto :goto_2

    .line 695
    :cond_7
    iget-object v8, p0, Lco/vine/android/HomeTabActivity;->mTabHost:Lco/vine/android/widget/tabs/IconTabHost;

    invoke-virtual {v8}, Lco/vine/android/widget/tabs/IconTabHost;->getCurrentTab()I

    move-result v8

    invoke-virtual {v7, v8}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Lco/vine/android/widget/tabs/TabInfo;

    invoke-virtual {v8}, Lco/vine/android/widget/tabs/TabInfo;->fragment()Landroid/support/v4/app/Fragment;

    move-result-object v1

    .line 696
    .local v1, "frag":Landroid/support/v4/app/Fragment;
    if-eqz v1, :cond_0

    .line 697
    invoke-virtual {v1, p1, p2, p3}, Landroid/support/v4/app/Fragment;->onActivityResult(IILandroid/content/Intent;)V

    goto :goto_0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 35
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 186
    const v30, 0x7f030052

    const/16 v31, 0x1

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move/from16 v2, v30

    move/from16 v3, v31

    invoke-super {v0, v1, v2, v3}, Lco/vine/android/BaseTimelineActivity;->onCreate(Landroid/os/Bundle;IZ)V

    .line 188
    invoke-static {}, Lco/vine/android/util/BuildUtil;->isExplore()Z

    move-result v30

    if-eqz v30, :cond_0

    .line 189
    invoke-direct/range {p0 .. p0}, Lco/vine/android/HomeTabActivity;->setupTabs()V

    .line 192
    :cond_0
    sget-boolean v30, Lcom/edisonwang/android/slog/SLog;->sLogsOn:Z

    if-eqz v30, :cond_1

    .line 193
    new-instance v30, Landroid/content/Intent;

    const-string v31, "co.vine.android.debug_receiver"

    invoke-direct/range {v30 .. v31}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    move-object/from16 v1, v30

    invoke-virtual {v0, v1}, Lco/vine/android/HomeTabActivity;->sendBroadcast(Landroid/content/Intent;)V

    .line 196
    :cond_1
    const-string v30, "HomeTabActivity pid: {}"

    invoke-static {}, Landroid/os/Process;->myPid()I

    move-result v31

    invoke-static/range {v31 .. v31}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v31

    invoke-static/range {v30 .. v31}, Lcom/edisonwang/android/slog/SLog;->i(Ljava/lang/String;Ljava/lang/Object;)V

    .line 198
    const/16 v30, 0x1

    move-object/from16 v0, p0

    move/from16 v1, v30

    invoke-virtual {v0, v1}, Lco/vine/android/HomeTabActivity;->setRequestedOrientation(I)V

    .line 200
    const/16 v30, 0x0

    invoke-static/range {v30 .. v30}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v30

    const/16 v31, 0x0

    const/16 v32, 0x0

    const/16 v33, 0x0

    move-object/from16 v0, p0

    move-object/from16 v1, v30

    move-object/from16 v2, v31

    move-object/from16 v3, v32

    move-object/from16 v4, v33

    invoke-virtual {v0, v1, v2, v3, v4}, Lco/vine/android/HomeTabActivity;->setupActionBar(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;)V

    .line 202
    new-instance v30, Lco/vine/android/HomeTabActivity$HomeTabSessionListener;

    move-object/from16 v0, v30

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lco/vine/android/HomeTabActivity$HomeTabSessionListener;-><init>(Lco/vine/android/HomeTabActivity;)V

    move-object/from16 v0, v30

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/HomeTabActivity;->mAppSessionListener:Lco/vine/android/client/AppSessionListener;

    .line 203
    new-instance v30, Landroid/support/v4/util/LongSparseArray;

    invoke-direct/range {v30 .. v30}, Landroid/support/v4/util/LongSparseArray;-><init>()V

    move-object/from16 v0, v30

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/HomeTabActivity;->mLastMessageMap:Landroid/support/v4/util/LongSparseArray;

    .line 205
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/HomeTabActivity;->getIntent()Landroid/content/Intent;

    move-result-object v17

    .line 207
    .local v17, "intent":Landroid/content/Intent;
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/HomeTabActivity;->mAppController:Lco/vine/android/client/AppController;

    move-object/from16 v30, v0

    if-nez v30, :cond_2

    .line 208
    invoke-static/range {p0 .. p0}, Lco/vine/android/client/AppController;->getInstance(Landroid/content/Context;)Lco/vine/android/client/AppController;

    move-result-object v30

    move-object/from16 v0, v30

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/HomeTabActivity;->mAppController:Lco/vine/android/client/AppController;

    .line 211
    :cond_2
    move-object/from16 v0, p0

    iget-object v9, v0, Lco/vine/android/HomeTabActivity;->mAppController:Lco/vine/android/client/AppController;

    .line 213
    .local v9, "appController":Lco/vine/android/client/AppController;
    invoke-virtual {v9}, Lco/vine/android/client/AppController;->isLoggedIn()Z

    move-result v30

    if-nez v30, :cond_4

    .line 395
    :cond_3
    :goto_0
    return-void

    .line 217
    :cond_4
    invoke-static/range {p0 .. p0}, Landroid/accounts/AccountManager;->get(Landroid/content/Context;)Landroid/accounts/AccountManager;

    move-result-object v8

    .line 218
    .local v8, "am":Landroid/accounts/AccountManager;
    invoke-static/range {p0 .. p0}, Lco/vine/android/client/VineAccountHelper;->getActiveAccountReadOnly(Landroid/content/Context;)Landroid/accounts/Account;

    move-result-object v5

    .line 219
    .local v5, "acc":Landroid/accounts/Account;
    move-object/from16 v0, p0

    invoke-static {v8, v5, v0}, Lco/vine/android/client/VineAccountHelper;->migratePassword(Landroid/accounts/AccountManager;Landroid/accounts/Account;Landroid/content/Context;)V

    .line 222
    invoke-static/range {p0 .. p0}, Lco/vine/android/util/Util;->getDefaultSharedPrefs(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v22

    .line 224
    .local v22, "prefs":Landroid/content/SharedPreferences;
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/HomeTabActivity;->mTabHost:Lco/vine/android/widget/tabs/IconTabHost;

    move-object/from16 v27, v0

    .line 226
    .local v27, "tabHost":Lco/vine/android/widget/tabs/IconTabHost;
    const v30, 0x7f0a00da

    move-object/from16 v0, p0

    move/from16 v1, v30

    invoke-virtual {v0, v1}, Lco/vine/android/HomeTabActivity;->findViewById(I)Landroid/view/View;

    move-result-object v30

    check-cast v30, Landroid/support/v4/view/ViewPager;

    move-object/from16 v0, v30

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/HomeTabActivity;->mViewPager:Landroid/support/v4/view/ViewPager;

    .line 227
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/HomeTabActivity;->mViewPager:Landroid/support/v4/view/ViewPager;

    move-object/from16 v30, v0

    invoke-virtual/range {p0 .. p0}, Lco/vine/android/HomeTabActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v31

    const v32, 0x7f0b0054

    invoke-virtual/range {v31 .. v32}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v31

    invoke-virtual/range {v30 .. v31}, Landroid/support/v4/view/ViewPager;->setPageMargin(I)V

    .line 228
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/HomeTabActivity;->mViewPager:Landroid/support/v4/view/ViewPager;

    move-object/from16 v30, v0

    const v31, 0x7f09000e

    invoke-virtual/range {v30 .. v31}, Landroid/support/v4/view/ViewPager;->setPageMarginDrawable(I)V

    .line 229
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/HomeTabActivity;->mViewPager:Landroid/support/v4/view/ViewPager;

    move-object/from16 v30, v0

    const/16 v31, 0x3

    invoke-virtual/range {v30 .. v31}, Landroid/support/v4/view/ViewPager;->setOffscreenPageLimit(I)V

    .line 231
    new-instance v30, Lco/vine/android/HomeTabActivity$HomeTabTabsAdapter;

    move-object/from16 v0, v30

    move-object/from16 v1, p0

    move-object/from16 v2, v27

    invoke-direct {v0, v1, v2}, Lco/vine/android/HomeTabActivity$HomeTabTabsAdapter;-><init>(Lco/vine/android/HomeTabActivity;Landroid/widget/TabHost;)V

    move-object/from16 v0, v30

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/HomeTabActivity;->mTabsAdapter:Lco/vine/android/widget/tabs/TabsAdapter;

    .line 233
    invoke-static/range {p0 .. p0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v16

    .line 234
    .local v16, "inflater":Landroid/view/LayoutInflater;
    move-object/from16 v0, v27

    move-object/from16 v1, p0

    invoke-virtual {v0, v1}, Lco/vine/android/widget/tabs/IconTabHost;->setOnTabChangedListener(Landroid/widget/TabHost$OnTabChangeListener;)V

    .line 235
    move-object/from16 v0, v27

    move-object/from16 v1, p0

    invoke-virtual {v0, v1}, Lco/vine/android/widget/tabs/IconTabHost;->setOnTabClickedListener(Lco/vine/android/widget/tabs/IconTabHost$OnTabClickedListener;)V

    .line 238
    new-instance v28, Landroid/os/Bundle;

    invoke-direct/range {v28 .. v28}, Landroid/os/Bundle;-><init>()V

    .line 239
    .local v28, "timelineBundle":Landroid/os/Bundle;
    const-string v30, "empty_desc"

    const v31, 0x7f0e00da

    move-object/from16 v0, v28

    move-object/from16 v1, v30

    move/from16 v2, v31

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 241
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/HomeTabActivity;->mTabsAdapter:Lco/vine/android/widget/tabs/TabsAdapter;

    move-object/from16 v30, v0

    const-string v31, "home"

    move-object/from16 v0, v27

    move-object/from16 v1, v31

    invoke-virtual {v0, v1}, Lco/vine/android/widget/tabs/IconTabHost;->newTabSpec(Ljava/lang/String;)Landroid/widget/TabHost$TabSpec;

    move-result-object v31

    const v32, 0x7f030048

    const v33, 0x7f020193

    const/16 v34, 0x0

    move-object/from16 v0, v16

    move/from16 v1, v32

    move-object/from16 v2, v27

    move/from16 v3, v33

    move/from16 v4, v34

    invoke-static {v0, v1, v2, v3, v4}, Lco/vine/android/widget/tabs/TabIndicator;->newIconIndicator(Landroid/view/LayoutInflater;ILandroid/widget/TabHost;II)Lco/vine/android/widget/tabs/TabIndicator;

    move-result-object v32

    invoke-virtual/range {v31 .. v32}, Landroid/widget/TabHost$TabSpec;->setIndicator(Landroid/view/View;)Landroid/widget/TabHost$TabSpec;

    move-result-object v31

    const-class v32, Lco/vine/android/HomeTimelineFragment;

    move-object/from16 v0, v30

    move-object/from16 v1, v31

    move-object/from16 v2, v32

    move-object/from16 v3, v28

    invoke-virtual {v0, v1, v2, v3}, Lco/vine/android/widget/tabs/TabsAdapter;->addTab(Landroid/widget/TabHost$TabSpec;Ljava/lang/Class;Landroid/os/Bundle;)V

    .line 247
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/HomeTabActivity;->restoreActivityState()V

    .line 250
    new-instance v7, Landroid/os/Bundle;

    invoke-direct {v7}, Landroid/os/Bundle;-><init>()V

    .line 251
    .local v7, "activityBundle":Landroid/os/Bundle;
    const-string v30, "empty_desc"

    const v31, 0x7f0e003f

    move-object/from16 v0, v30

    move/from16 v1, v31

    invoke-virtual {v7, v0, v1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 253
    const-string v30, "co.vine.android.ACTIVITY_NOTIFICATION_PRESSED"

    invoke-virtual/range {v17 .. v17}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v31

    invoke-virtual/range {v30 .. v31}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v30

    if-nez v30, :cond_5

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/HomeTabActivity;->mRecentTab:Ljava/lang/String;

    move-object/from16 v30, v0

    const-string v31, "activity"

    invoke-static/range {v30 .. v31}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v30

    if-eqz v30, :cond_c

    .line 255
    :cond_5
    const-string v30, "take_focus"

    const/16 v31, 0x1

    move-object/from16 v0, v30

    move/from16 v1, v31

    invoke-virtual {v7, v0, v1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 256
    const-string v30, "Activity"

    invoke-static/range {v30 .. v30}, Lco/vine/android/util/FlurryUtils;->trackNotificationClicked(Ljava/lang/String;)V

    .line 266
    :cond_6
    :goto_1
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/HomeTabActivity;->mTabsAdapter:Lco/vine/android/widget/tabs/TabsAdapter;

    move-object/from16 v30, v0

    const-string v31, "activity"

    move-object/from16 v0, v27

    move-object/from16 v1, v31

    invoke-virtual {v0, v1}, Lco/vine/android/widget/tabs/IconTabHost;->newTabSpec(Ljava/lang/String;)Landroid/widget/TabHost$TabSpec;

    move-result-object v31

    const v32, 0x7f03001f

    const v33, 0x7f02013a

    const/16 v34, 0x0

    move-object/from16 v0, v16

    move/from16 v1, v32

    move-object/from16 v2, v27

    move/from16 v3, v33

    move/from16 v4, v34

    invoke-static {v0, v1, v2, v3, v4}, Lco/vine/android/widget/tabs/TabIndicator;->newIconIndicator(Landroid/view/LayoutInflater;ILandroid/widget/TabHost;II)Lco/vine/android/widget/tabs/TabIndicator;

    move-result-object v32

    invoke-virtual/range {v31 .. v32}, Landroid/widget/TabHost$TabSpec;->setIndicator(Landroid/view/View;)Landroid/widget/TabHost$TabSpec;

    move-result-object v31

    const-class v32, Lco/vine/android/ActivityFragment;

    move-object/from16 v0, v30

    move-object/from16 v1, v31

    move-object/from16 v2, v32

    invoke-virtual {v0, v1, v2, v7}, Lco/vine/android/widget/tabs/TabsAdapter;->addTab(Landroid/widget/TabHost$TabSpec;Ljava/lang/Class;Landroid/os/Bundle;)V

    .line 272
    new-instance v13, Landroid/os/Bundle;

    invoke-direct {v13}, Landroid/os/Bundle;-><init>()V

    .line 273
    .local v13, "exploreBundle":Landroid/os/Bundle;
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/HomeTabActivity;->mRecentTab:Ljava/lang/String;

    move-object/from16 v30, v0

    const-string v31, "explore"

    invoke-static/range {v30 .. v31}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v30

    if-eqz v30, :cond_7

    .line 274
    const-string v30, "take_focus"

    const/16 v31, 0x1

    move-object/from16 v0, v30

    move/from16 v1, v31

    invoke-virtual {v13, v0, v1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 278
    :cond_7
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/HomeTabActivity;->mTabsAdapter:Lco/vine/android/widget/tabs/TabsAdapter;

    move-object/from16 v30, v0

    const-string v31, "explore"

    move-object/from16 v0, v27

    move-object/from16 v1, v31

    invoke-virtual {v0, v1}, Lco/vine/android/widget/tabs/IconTabHost;->newTabSpec(Ljava/lang/String;)Landroid/widget/TabHost$TabSpec;

    move-result-object v31

    const v32, 0x7f030048

    const v33, 0x7f020166

    const/16 v34, 0x0

    move-object/from16 v0, v16

    move/from16 v1, v32

    move-object/from16 v2, v27

    move/from16 v3, v33

    move/from16 v4, v34

    invoke-static {v0, v1, v2, v3, v4}, Lco/vine/android/widget/tabs/TabIndicator;->newIconIndicator(Landroid/view/LayoutInflater;ILandroid/widget/TabHost;II)Lco/vine/android/widget/tabs/TabIndicator;

    move-result-object v32

    invoke-virtual/range {v31 .. v32}, Landroid/widget/TabHost$TabSpec;->setIndicator(Landroid/view/View;)Landroid/widget/TabHost$TabSpec;

    move-result-object v31

    const-class v32, Lco/vine/android/ExploreFragment;

    move-object/from16 v0, v30

    move-object/from16 v1, v31

    move-object/from16 v2, v32

    invoke-virtual {v0, v1, v2, v13}, Lco/vine/android/widget/tabs/TabsAdapter;->addTab(Landroid/widget/TabHost$TabSpec;Ljava/lang/Class;Landroid/os/Bundle;)V

    .line 285
    new-instance v23, Landroid/os/Bundle;

    invoke-direct/range {v23 .. v23}, Landroid/os/Bundle;-><init>()V

    .line 286
    .local v23, "profileBundle":Landroid/os/Bundle;
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/HomeTabActivity;->mRecentTab:Ljava/lang/String;

    move-object/from16 v30, v0

    const-string v31, "profile"

    invoke-static/range {v30 .. v31}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v30

    if-eqz v30, :cond_8

    .line 287
    const-string v30, "take_focus"

    const/16 v31, 0x1

    move-object/from16 v0, v23

    move-object/from16 v1, v30

    move/from16 v2, v31

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 290
    :cond_8
    const-string v30, "user_id"

    invoke-virtual {v9}, Lco/vine/android/client/AppController;->getActiveId()J

    move-result-wide v31

    move-object/from16 v0, v23

    move-object/from16 v1, v30

    move-wide/from16 v2, v31

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 291
    const-string v30, "refresh"

    const/16 v31, 0x1

    move-object/from16 v0, v23

    move-object/from16 v1, v30

    move/from16 v2, v31

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 292
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/HomeTabActivity;->mTabsAdapter:Lco/vine/android/widget/tabs/TabsAdapter;

    move-object/from16 v30, v0

    const-string v31, "profile"

    move-object/from16 v0, v27

    move-object/from16 v1, v31

    invoke-virtual {v0, v1}, Lco/vine/android/widget/tabs/IconTabHost;->newTabSpec(Ljava/lang/String;)Landroid/widget/TabHost$TabSpec;

    move-result-object v31

    const v32, 0x7f030048

    const v33, 0x7f0201c8

    const/16 v34, 0x0

    move-object/from16 v0, v16

    move/from16 v1, v32

    move-object/from16 v2, v27

    move/from16 v3, v33

    move/from16 v4, v34

    invoke-static {v0, v1, v2, v3, v4}, Lco/vine/android/widget/tabs/TabIndicator;->newIconIndicator(Landroid/view/LayoutInflater;ILandroid/widget/TabHost;II)Lco/vine/android/widget/tabs/TabIndicator;

    move-result-object v32

    invoke-virtual/range {v31 .. v32}, Landroid/widget/TabHost$TabSpec;->setIndicator(Landroid/view/View;)Landroid/widget/TabHost$TabSpec;

    move-result-object v31

    const-class v32, Lco/vine/android/ProfileFragment;

    move-object/from16 v0, v30

    move-object/from16 v1, v31

    move-object/from16 v2, v32

    move-object/from16 v3, v23

    invoke-virtual {v0, v1, v2, v3}, Lco/vine/android/widget/tabs/TabsAdapter;->addTab(Landroid/widget/TabHost$TabSpec;Ljava/lang/Class;Landroid/os/Bundle;)V

    .line 298
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/HomeTabActivity;->mAppController:Lco/vine/android/client/AppController;

    move-object/from16 v30, v0

    invoke-virtual/range {v30 .. v30}, Lco/vine/android/client/AppController;->getActiveSession()Lco/vine/android/client/Session;

    move-result-object v25

    .line 300
    .local v25, "session":Lco/vine/android/client/Session;
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/HomeTabActivity;->mAppController:Lco/vine/android/client/AppController;

    move-object/from16 v30, v0

    move-object/from16 v0, v30

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Lco/vine/android/client/AppController;->determineCleanup(Lco/vine/android/client/Session;)V

    .line 302
    const-string v30, "unread_notification_count"

    const/16 v31, 0x0

    move-object/from16 v0, v22

    move-object/from16 v1, v30

    move/from16 v2, v31

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v30

    move/from16 v0, v30

    move-object/from16 v1, p0

    iput v0, v1, Lco/vine/android/HomeTabActivity;->mActivityCount:I

    .line 304
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/HomeTabActivity;->invalidateActivityBadge()V

    .line 306
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/HomeTabActivity;->mAppController:Lco/vine/android/client/AppController;

    move-object/from16 v30, v0

    invoke-virtual/range {v30 .. v30}, Lco/vine/android/client/AppController;->fetchActivityCounts()Ljava/lang/String;

    .line 308
    invoke-virtual/range {v17 .. v17}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v10

    .line 309
    .local v10, "data":Landroid/net/Uri;
    invoke-virtual/range {v17 .. v17}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v6

    .line 310
    .local v6, "action":Ljava/lang/String;
    const-string v30, "android.intent.action.VIEW"

    move-object/from16 v0, v30

    invoke-virtual {v0, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v30

    if-eqz v30, :cond_13

    if-eqz v10, :cond_13

    .line 311
    new-instance v19, Ljava/util/ArrayList;

    invoke-virtual {v10}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v30

    move-object/from16 v0, v19

    move-object/from16 v1, v30

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    .line 312
    .local v19, "pathSegments":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    invoke-virtual {v10}, Landroid/net/Uri;->getScheme()Ljava/lang/String;

    move-result-object v24

    .line 313
    .local v24, "scheme":Ljava/lang/String;
    invoke-virtual {v10}, Landroid/net/Uri;->getHost()Ljava/lang/String;

    move-result-object v15

    .line 315
    .local v15, "host":Ljava/lang/String;
    if-eqz v15, :cond_9

    invoke-virtual/range {v19 .. v19}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v30

    if-nez v30, :cond_9

    .line 316
    const-string v30, "vine.co"

    move-object/from16 v0, v30

    invoke-virtual {v15, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v30

    if-eqz v30, :cond_11

    .line 317
    const/16 v30, 0x0

    move-object/from16 v0, v19

    move/from16 v1, v30

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v18

    check-cast v18, Ljava/lang/String;

    .line 318
    .local v18, "pathPrefix":Ljava/lang/String;
    const-string v30, "v"

    move-object/from16 v0, v30

    move-object/from16 v1, v18

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v30

    if-eqz v30, :cond_e

    invoke-virtual/range {v19 .. v19}, Ljava/util/ArrayList;->size()I

    move-result v30

    const/16 v31, 0x1

    move/from16 v0, v30

    move/from16 v1, v31

    if-le v0, v1, :cond_e

    .line 320
    const/16 v30, 0x1

    move-object/from16 v0, v19

    move/from16 v1, v30

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v30

    check-cast v30, Ljava/lang/String;

    move-object/from16 v0, p0

    move-object/from16 v1, v30

    invoke-direct {v0, v1}, Lco/vine/android/HomeTabActivity;->trimSegment(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v26

    .line 321
    .local v26, "shareId":Ljava/lang/String;
    move-object/from16 v0, p0

    move-object/from16 v1, v26

    invoke-static {v0, v1}, Lco/vine/android/SingleActivity;->start(Landroid/content/Context;Ljava/lang/String;)V

    .line 365
    .end local v15    # "host":Ljava/lang/String;
    .end local v18    # "pathPrefix":Ljava/lang/String;
    .end local v19    # "pathSegments":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    .end local v24    # "scheme":Ljava/lang/String;
    .end local v26    # "shareId":Ljava/lang/String;
    :cond_9
    :goto_2
    new-instance v14, Lco/vine/android/HomeTabActivity$DelayHandler;

    move-object/from16 v0, p0

    invoke-direct {v14, v0}, Lco/vine/android/HomeTabActivity$DelayHandler;-><init>(Landroid/content/Context;)V

    .line 366
    .local v14, "handler":Lco/vine/android/HomeTabActivity$DelayHandler;
    const/16 v30, 0x1

    move/from16 v0, v30

    invoke-virtual {v14, v0}, Lco/vine/android/HomeTabActivity$DelayHandler;->hasMessages(I)Z

    move-result v30

    if-eqz v30, :cond_a

    .line 367
    const/16 v30, 0x1

    move/from16 v0, v30

    invoke-virtual {v14, v0}, Lco/vine/android/HomeTabActivity$DelayHandler;->removeMessages(I)V

    .line 369
    :cond_a
    const/16 v30, 0x2

    move/from16 v0, v30

    invoke-virtual {v14, v0}, Lco/vine/android/HomeTabActivity$DelayHandler;->hasMessages(I)Z

    move-result v30

    if-eqz v30, :cond_b

    .line 370
    const/16 v30, 0x2

    move/from16 v0, v30

    invoke-virtual {v14, v0}, Lco/vine/android/HomeTabActivity$DelayHandler;->removeMessages(I)V

    .line 373
    :cond_b
    const/16 v30, 0x4

    const/16 v31, 0x0

    move/from16 v0, v30

    move-object/from16 v1, v31

    invoke-virtual {v14, v0, v1}, Lco/vine/android/HomeTabActivity$DelayHandler;->obtainMessage(ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v30

    move-object/from16 v0, v30

    invoke-virtual {v14, v0}, Lco/vine/android/HomeTabActivity$DelayHandler;->sendMessage(Landroid/os/Message;)Z

    .line 375
    const/16 v30, 0x1

    const/16 v31, 0x0

    move/from16 v0, v30

    move-object/from16 v1, v31

    invoke-virtual {v14, v0, v1}, Lco/vine/android/HomeTabActivity$DelayHandler;->obtainMessage(ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v30

    const-wide/32 v31, 0xea60

    move-object/from16 v0, v30

    move-wide/from16 v1, v31

    invoke-virtual {v14, v0, v1, v2}, Lco/vine/android/HomeTabActivity$DelayHandler;->sendMessageDelayed(Landroid/os/Message;J)Z

    .line 377
    const/16 v30, 0x2

    const/16 v31, 0x0

    move/from16 v0, v30

    move-object/from16 v1, v31

    invoke-virtual {v14, v0, v1}, Lco/vine/android/HomeTabActivity$DelayHandler;->obtainMessage(ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v30

    const-wide/32 v31, 0xea60

    move-object/from16 v0, v30

    move-wide/from16 v1, v31

    invoke-virtual {v14, v0, v1, v2}, Lco/vine/android/HomeTabActivity$DelayHandler;->sendMessageDelayed(Landroid/os/Message;J)Z

    .line 379
    const/16 v30, 0x3

    const/16 v31, 0x0

    move/from16 v0, v30

    move-object/from16 v1, v31

    invoke-virtual {v14, v0, v1}, Lco/vine/android/HomeTabActivity$DelayHandler;->obtainMessage(ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v30

    const-wide/32 v31, 0xea60

    move-object/from16 v0, v30

    move-wide/from16 v1, v31

    invoke-virtual {v14, v0, v1, v2}, Lco/vine/android/HomeTabActivity$DelayHandler;->sendMessageDelayed(Landroid/os/Message;J)Z

    .line 382
    invoke-static {}, Lco/vine/android/AppImpl;->getInstance()Lco/vine/android/AppImpl;

    move-result-object v30

    move-object/from16 v0, v30

    move-object/from16 v1, p0

    invoke-virtual {v0, v1}, Lco/vine/android/AppImpl;->startCameraService(Landroid/app/Activity;)V

    .line 384
    invoke-static/range {p0 .. p0}, Lco/vine/android/client/VineAccountHelper;->syncNormalVideoPlayable(Landroid/content/Context;)V

    .line 387
    :try_start_0
    invoke-static/range {p0 .. p0}, Lcom/google/android/gms/common/GooglePlayServicesUtil;->isGooglePlayServicesAvailable(Landroid/content/Context;)I

    move-result v12

    .line 388
    .local v12, "errorCode":I
    if-nez v12, :cond_3

    .line 390
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/HomeTabActivity;->mAppController:Lco/vine/android/client/AppController;

    move-object/from16 v30, v0

    invoke-virtual/range {v30 .. v30}, Lco/vine/android/client/AppController;->getActiveId()J

    move-result-wide v30

    move-object/from16 v0, p0

    move-wide/from16 v1, v30

    invoke-static {v0, v1, v2}, Lco/vine/android/service/GCMRegistrationService;->getRegisterIntent(Landroid/content/Context;J)Landroid/content/Intent;

    move-result-object v30

    move-object/from16 v0, p0

    move-object/from16 v1, v30

    invoke-virtual {v0, v1}, Lco/vine/android/HomeTabActivity;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    goto/16 :goto_0

    .line 392
    .end local v12    # "errorCode":I
    :catch_0
    move-exception v11

    .line 393
    .local v11, "e":Ljava/lang/Throwable;
    const-string v30, "Failed to validate Google Player Service status."

    const/16 v31, 0x0

    move/from16 v0, v31

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v31, v0

    move-object/from16 v0, v30

    move-object/from16 v1, v31

    invoke-static {v11, v0, v1}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V

    goto/16 :goto_0

    .line 257
    .end local v6    # "action":Ljava/lang/String;
    .end local v10    # "data":Landroid/net/Uri;
    .end local v11    # "e":Ljava/lang/Throwable;
    .end local v13    # "exploreBundle":Landroid/os/Bundle;
    .end local v14    # "handler":Lco/vine/android/HomeTabActivity$DelayHandler;
    .end local v23    # "profileBundle":Landroid/os/Bundle;
    .end local v25    # "session":Lco/vine/android/client/Session;
    :cond_c
    const-string v30, "co.vine.android.MESSAGE_NOTIFICATION_PRESSED"

    invoke-virtual/range {v17 .. v17}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v31

    invoke-virtual/range {v30 .. v31}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v30

    if-eqz v30, :cond_d

    .line 258
    const/16 v30, 0x1

    move/from16 v0, v30

    move-object/from16 v1, p0

    iput-boolean v0, v1, Lco/vine/android/HomeTabActivity;->mShouldShowMenu:Z

    .line 259
    const-string v30, "Message"

    invoke-static/range {v30 .. v30}, Lco/vine/android/util/FlurryUtils;->trackNotificationClicked(Ljava/lang/String;)V

    goto/16 :goto_1

    .line 260
    :cond_d
    const-string v30, "co.vine.android.VM_SENT"

    invoke-virtual/range {v17 .. v17}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v31

    invoke-virtual/range {v30 .. v31}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v30

    if-eqz v30, :cond_6

    .line 261
    const-string v30, "is_vm_onboarding"

    const/16 v31, 0x0

    move-object/from16 v0, v17

    move-object/from16 v1, v30

    move/from16 v2, v31

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v30

    if-eqz v30, :cond_6

    .line 262
    invoke-direct/range {p0 .. p0}, Lco/vine/android/HomeTabActivity;->showSlidingMenuWithVmOnboardAfterSend()V

    goto/16 :goto_1

    .line 322
    .restart local v6    # "action":Ljava/lang/String;
    .restart local v10    # "data":Landroid/net/Uri;
    .restart local v13    # "exploreBundle":Landroid/os/Bundle;
    .restart local v15    # "host":Ljava/lang/String;
    .restart local v18    # "pathPrefix":Ljava/lang/String;
    .restart local v19    # "pathSegments":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    .restart local v23    # "profileBundle":Landroid/os/Bundle;
    .restart local v24    # "scheme":Ljava/lang/String;
    .restart local v25    # "session":Lco/vine/android/client/Session;
    :cond_e
    const-string v30, "u"

    move-object/from16 v0, v30

    move-object/from16 v1, v18

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v30

    if-eqz v30, :cond_f

    .line 325
    :try_start_1
    invoke-virtual {v10}, Landroid/net/Uri;->getLastPathSegment()Ljava/lang/String;

    move-result-object v30

    move-object/from16 v0, p0

    move-object/from16 v1, v30

    invoke-direct {v0, v1}, Lco/vine/android/HomeTabActivity;->trimSegment(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v29

    .line 326
    .local v29, "userId":Ljava/lang/String;
    invoke-static/range {v29 .. v29}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v30

    const-string v32, "Deep Link: /u/<userId>"

    move-object/from16 v0, p0

    move-wide/from16 v1, v30

    move-object/from16 v3, v32

    invoke-static {v0, v1, v2, v3}, Lco/vine/android/ProfileActivity;->start(Landroid/content/Context;JLjava/lang/String;)V
    :try_end_1
    .catch Ljava/lang/NumberFormatException; {:try_start_1 .. :try_end_1} :catch_1

    goto/16 :goto_2

    .line 327
    .end local v29    # "userId":Ljava/lang/String;
    :catch_1
    move-exception v11

    .line 328
    .local v11, "e":Ljava/lang/NumberFormatException;
    const v30, 0x7f0e0115

    move-object/from16 v0, p0

    move/from16 v1, v30

    invoke-static {v0, v1}, Lco/vine/android/util/Util;->showCenteredToast(Landroid/content/Context;I)V

    .line 329
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/HomeTabActivity;->finish()V

    goto/16 :goto_2

    .line 331
    .end local v11    # "e":Ljava/lang/NumberFormatException;
    :cond_f
    const-string v30, "confirmEmail"

    move-object/from16 v0, v30

    move-object/from16 v1, v18

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v30

    if-eqz v30, :cond_10

    .line 333
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/HomeTabActivity;->mAppController:Lco/vine/android/client/AppController;

    move-object/from16 v30, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/HomeTabActivity;->mAppController:Lco/vine/android/client/AppController;

    move-object/from16 v31, v0

    invoke-virtual/range {v31 .. v31}, Lco/vine/android/client/AppController;->getActiveSession()Lco/vine/android/client/Session;

    move-result-object v31

    invoke-virtual {v10}, Landroid/net/Uri;->getLastPathSegment()Ljava/lang/String;

    move-result-object v32

    invoke-virtual/range {v30 .. v32}, Lco/vine/android/client/AppController;->verifyEmail(Lco/vine/android/client/Session;Ljava/lang/String;)Ljava/lang/String;

    .line 334
    new-instance v30, Landroid/app/ProgressDialog;

    move-object/from16 v0, v30

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Landroid/app/ProgressDialog;-><init>(Landroid/content/Context;)V

    move-object/from16 v0, v30

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/HomeTabActivity;->mProgressDialog:Landroid/app/ProgressDialog;

    .line 335
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/HomeTabActivity;->mProgressDialog:Landroid/app/ProgressDialog;

    move-object/from16 v30, v0

    const v31, 0x7f0e0129

    move-object/from16 v0, p0

    move/from16 v1, v31

    invoke-virtual {v0, v1}, Lco/vine/android/HomeTabActivity;->getString(I)Ljava/lang/String;

    move-result-object v31

    invoke-virtual/range {v30 .. v31}, Landroid/app/ProgressDialog;->setMessage(Ljava/lang/CharSequence;)V

    .line 337
    :try_start_2
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/HomeTabActivity;->mProgressDialog:Landroid/app/ProgressDialog;

    move-object/from16 v30, v0

    invoke-virtual/range {v30 .. v30}, Landroid/app/ProgressDialog;->show()V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_2

    goto/16 :goto_2

    .line 338
    :catch_2
    move-exception v11

    .line 339
    .local v11, "e":Ljava/lang/Exception;
    const-string v30, "Failed to show pd."

    move-object/from16 v0, v30

    invoke-static {v0, v11}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto/16 :goto_2

    .line 343
    .end local v11    # "e":Ljava/lang/Exception;
    :cond_10
    const-string v30, "Deep Link: Vanity URL"

    move-object/from16 v0, p0

    move-object/from16 v1, v19

    move-object/from16 v2, v30

    invoke-static {v0, v1, v2}, Lco/vine/android/ProfileActivity;->start(Landroid/content/Context;Ljava/util/ArrayList;Ljava/lang/String;)V

    goto/16 :goto_2

    .line 345
    .end local v18    # "pathPrefix":Ljava/lang/String;
    :cond_11
    const-string v30, "vine"

    move-object/from16 v0, v30

    move-object/from16 v1, v24

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v30

    if-eqz v30, :cond_9

    .line 346
    const-string v30, "post"

    move-object/from16 v0, v30

    invoke-virtual {v0, v15}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v30

    if-eqz v30, :cond_12

    .line 349
    :try_start_3
    invoke-virtual {v10}, Landroid/net/Uri;->getLastPathSegment()Ljava/lang/String;

    move-result-object v30

    invoke-static/range {v30 .. v30}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v20

    .line 350
    .local v20, "postId":J
    move-object/from16 v0, p0

    move-wide/from16 v1, v20

    invoke-static {v0, v1, v2}, Lco/vine/android/SingleActivity;->start(Landroid/content/Context;J)V
    :try_end_3
    .catch Ljava/lang/NumberFormatException; {:try_start_3 .. :try_end_3} :catch_3

    goto/16 :goto_2

    .line 351
    .end local v20    # "postId":J
    :catch_3
    move-exception v11

    .line 352
    .local v11, "e":Ljava/lang/NumberFormatException;
    const v30, 0x7f0e0115

    move-object/from16 v0, p0

    move/from16 v1, v30

    invoke-static {v0, v1}, Lco/vine/android/util/Util;->showCenteredToast(Landroid/content/Context;I)V

    .line 353
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/HomeTabActivity;->finish()V

    goto/16 :goto_2

    .line 355
    .end local v11    # "e":Ljava/lang/NumberFormatException;
    :cond_12
    const-string v30, "timelines"

    move-object/from16 v0, v30

    invoke-virtual {v0, v15}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v30

    if-eqz v30, :cond_9

    .line 357
    move-object/from16 v0, p0

    invoke-static {v0, v10}, Lco/vine/android/ExploreVideoListActivity;->start(Landroid/content/Context;Landroid/net/Uri;)V

    goto/16 :goto_2

    .line 361
    .end local v15    # "host":Ljava/lang/String;
    .end local v19    # "pathSegments":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    .end local v24    # "scheme":Ljava/lang/String;
    :cond_13
    const-string v30, "co.vine.android.UPLOAD_LIST"

    move-object/from16 v0, v30

    invoke-virtual {v0, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v30

    if-eqz v30, :cond_9

    .line 362
    invoke-static {}, Lco/vine/android/AppImpl;->getInstance()Lco/vine/android/AppImpl;

    move-result-object v30

    move-object/from16 v0, v30

    move-object/from16 v1, p0

    invoke-virtual {v0, v1}, Lco/vine/android/AppImpl;->startUploadsListActivity(Landroid/app/Activity;)V

    goto/16 :goto_2
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;)Z
    .locals 3
    .param p1, "menu"    # Landroid/view/Menu;

    .prologue
    .line 789
    invoke-virtual {p0}, Lco/vine/android/HomeTabActivity;->getMenuInflater()Landroid/view/MenuInflater;

    move-result-object v1

    const v2, 0x7f100007

    invoke-virtual {v1, v2, p1}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 790
    invoke-static {p0}, Lco/vine/android/util/Util;->getDefaultSharedPrefs(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 791
    .local v0, "prefs":Landroid/content/SharedPreferences;
    invoke-static {}, Lco/vine/android/util/BuildUtil;->isExplore()Z

    move-result v1

    if-eqz v1, :cond_0

    const-string v1, "pref_gb_notif_dismissed"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 793
    const v1, 0x7f0a023c

    invoke-interface {p1, v1}, Landroid/view/Menu;->removeItem(I)V

    .line 795
    :cond_0
    const v1, 0x7f0a0247

    invoke-interface {p1, v1}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v1

    iput-object v1, p0, Lco/vine/android/HomeTabActivity;->mInboxMenu:Landroid/view/MenuItem;

    .line 796
    invoke-direct {p0}, Lco/vine/android/HomeTabActivity;->invalidateMessagesBadge()V

    .line 797
    iput-object p1, p0, Lco/vine/android/HomeTabActivity;->mMenu:Landroid/view/Menu;

    .line 798
    invoke-super {p0, p1}, Lco/vine/android/BaseTimelineActivity;->onCreateOptionsMenu(Landroid/view/Menu;)Z

    move-result v1

    return v1
.end method

.method public onCurrentTabClicked()V
    .locals 0

    .prologue
    .line 958
    invoke-virtual {p0}, Lco/vine/android/HomeTabActivity;->scrollTop()V

    .line 959
    return-void
.end method

.method protected onDestroy()V
    .locals 1

    .prologue
    .line 624
    invoke-super {p0}, Lco/vine/android/BaseTimelineActivity;->onDestroy()V

    .line 625
    iget-boolean v0, p0, Lco/vine/android/HomeTabActivity;->mExploreRefreshReciverIsRegistered:Z

    if-eqz v0, :cond_0

    .line 626
    const/4 v0, 0x0

    iput-boolean v0, p0, Lco/vine/android/HomeTabActivity;->mExploreRefreshReciverIsRegistered:Z

    .line 627
    iget-object v0, p0, Lco/vine/android/HomeTabActivity;->mExploreRefreshReciver:Landroid/content/BroadcastReceiver;

    invoke-virtual {p0, v0}, Lco/vine/android/HomeTabActivity;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    .line 629
    :cond_0
    return-void
.end method

.method public onDialogDone(Landroid/content/DialogInterface;II)V
    .locals 3
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "id"    # I
    .param p3, "which"    # I

    .prologue
    .line 399
    packed-switch p2, :pswitch_data_0

    .line 412
    :goto_0
    return-void

    .line 401
    :pswitch_0
    const/4 v2, -0x1

    if-ne p3, v2, :cond_1

    const/4 v1, 0x1

    .line 402
    .local v1, "enable":Z
    :goto_1
    if-eqz v1, :cond_0

    iget-object v2, p0, Lco/vine/android/HomeTabActivity;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v2}, Lco/vine/android/client/AppController;->sendAddressBook()Ljava/lang/String;

    .line 403
    :cond_0
    iget-object v2, p0, Lco/vine/android/HomeTabActivity;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v2, v1}, Lco/vine/android/client/AppController;->updateEnableAddressBook(Z)Ljava/lang/String;

    .line 404
    invoke-static {p0}, Lco/vine/android/util/Util;->getDefaultSharedPrefs(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v2

    invoke-interface {v2}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 405
    .local v0, "editor":Landroid/content/SharedPreferences$Editor;
    const-string v2, "enable_address_book"

    invoke-interface {v0, v2, v1}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    move-result-object v2

    invoke-interface {v2}, Landroid/content/SharedPreferences$Editor;->apply()V

    goto :goto_0

    .line 401
    .end local v0    # "editor":Landroid/content/SharedPreferences$Editor;
    .end local v1    # "enable":Z
    :cond_1
    const/4 v1, 0x0

    goto :goto_1

    .line 399
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
    .end packed-switch
.end method

.method public onLongClick(Landroid/view/View;)Z
    .locals 7
    .param p1, "view"    # Landroid/view/View;

    .prologue
    const/4 v6, 0x0

    .line 918
    const/4 v1, -0x1

    .line 919
    .local v1, "toastResId":I
    invoke-virtual {p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/Integer;

    invoke-virtual {v4}, Ljava/lang/Integer;->intValue()I

    move-result v4

    packed-switch v4, :pswitch_data_0

    .line 941
    :goto_0
    if-lez v1, :cond_0

    .line 942
    invoke-virtual {p1}, Landroid/view/View;->getLeft()I

    move-result v2

    .line 943
    .local v2, "xOffset":I
    invoke-virtual {p1}, Landroid/view/View;->getBottom()I

    move-result v4

    invoke-virtual {p1}, Landroid/view/View;->getMeasuredHeight()I

    move-result v5

    add-int v3, v4, v5

    .line 944
    .local v3, "yOffset":I
    invoke-static {p0, v1, v6}, Landroid/widget/Toast;->makeText(Landroid/content/Context;II)Landroid/widget/Toast;

    move-result-object v0

    .line 945
    .local v0, "toast":Landroid/widget/Toast;
    const/16 v4, 0x33

    invoke-virtual {v0, v4, v2, v3}, Landroid/widget/Toast;->setGravity(III)V

    .line 946
    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    .line 950
    .end local v0    # "toast":Landroid/widget/Toast;
    .end local v2    # "xOffset":I
    .end local v3    # "yOffset":I
    :cond_0
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    const-class v5, Lco/vine/android/widget/tabs/TabIndicator;

    invoke-virtual {v4, v5}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 951
    invoke-virtual {p1, v6}, Landroid/view/View;->performHapticFeedback(I)Z

    .line 953
    :cond_1
    const/4 v4, 0x1

    return v4

    .line 921
    :pswitch_0
    const v1, 0x7f0e023e

    .line 922
    goto :goto_0

    .line 925
    :pswitch_1
    const v1, 0x7f0e0236

    .line 926
    goto :goto_0

    .line 929
    :pswitch_2
    const v1, 0x7f0e0238

    .line 930
    goto :goto_0

    .line 933
    :pswitch_3
    const v1, 0x7f0e023c

    .line 934
    goto :goto_0

    .line 919
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method public onMenuClose()V
    .locals 2

    .prologue
    .line 173
    invoke-static {p0}, Lco/vine/android/util/MuteUtil;->isMuted(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 174
    new-instance v0, Landroid/content/Intent;

    sget-object v1, Lco/vine/android/util/MuteUtil;->ACTION_CHANGED_TO_UNMUTE:Ljava/lang/String;

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    const-string v1, "co.vine.android.BROADCAST"

    invoke-virtual {p0, v0, v1}, Lco/vine/android/HomeTabActivity;->sendBroadcast(Landroid/content/Intent;Ljava/lang/String;)V

    .line 176
    :cond_0
    return-void
.end method

.method public onMenuOpened()V
    .locals 0

    .prologue
    .line 180
    invoke-super {p0}, Lco/vine/android/BaseTimelineActivity;->onMenuOpened()V

    .line 181
    invoke-direct {p0}, Lco/vine/android/HomeTabActivity;->invalidateMessagesBadge()V

    .line 182
    return-void
.end method

.method protected onNewIntent(Landroid/content/Intent;)V
    .locals 4
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    const/4 v3, 0x1

    .line 482
    invoke-super {p0, p1}, Lco/vine/android/BaseTimelineActivity;->onNewIntent(Landroid/content/Intent;)V

    .line 483
    const-string v1, "co.vine.android.ACTIVITY_NOTIFICATION_PRESSED"

    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 484
    iget-object v1, p0, Lco/vine/android/HomeTabActivity;->mTabsAdapter:Lco/vine/android/widget/tabs/TabsAdapter;

    invoke-virtual {v1}, Lco/vine/android/widget/tabs/TabsAdapter;->getCurrentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 485
    .local v0, "fragment":Landroid/support/v4/app/Fragment;
    instance-of v1, v0, Lco/vine/android/BaseArrayListFragment;

    if-eqz v1, :cond_0

    .line 486
    invoke-virtual {p0, v3, v0}, Lco/vine/android/HomeTabActivity;->showPage(ILandroid/support/v4/app/Fragment;)V

    .line 495
    .end local v0    # "fragment":Landroid/support/v4/app/Fragment;
    :cond_0
    :goto_0
    return-void

    .line 488
    :cond_1
    const-string v1, "co.vine.android.MESSAGE_NOTIFICATION_PRESSED"

    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 489
    iput-boolean v3, p0, Lco/vine/android/HomeTabActivity;->mShouldShowMenu:Z

    goto :goto_0

    .line 490
    :cond_2
    const-string v1, "co.vine.android.VM_SENT"

    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 491
    const-string v1, "is_vm_onboarding"

    const/4 v2, 0x0

    invoke-virtual {p1, v1, v2}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 492
    invoke-direct {p0}, Lco/vine/android/HomeTabActivity;->showSlidingMenuWithVmOnboardAfterSend()V

    goto :goto_0
.end method

.method public onNotifyClick()V
    .locals 2

    .prologue
    .line 530
    invoke-virtual {p0}, Lco/vine/android/HomeTabActivity;->getSlidingMenu()Lcom/jeremyfeinstein/slidingmenu/lib/SlidingMenu;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingMenu;->toggle(Z)V

    .line 531
    return-void
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 5
    .param p1, "item"    # Landroid/view/MenuItem;

    .prologue
    const/4 v1, 0x1

    .line 878
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v2

    sparse-switch v2, :sswitch_data_0

    .line 911
    invoke-super {p0, p1}, Lco/vine/android/BaseTimelineActivity;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v1

    :goto_0
    return v1

    .line 880
    :sswitch_0
    const-string v2, "Menu"

    invoke-static {v2}, Lco/vine/android/util/FlurryUtils;->trackVisitFindFriends(Ljava/lang/String;)V

    .line 881
    new-instance v2, Landroid/content/Intent;

    const-class v3, Lco/vine/android/FindFriendsActivity;

    invoke-direct {v2, p0, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    invoke-virtual {p0, v2}, Lco/vine/android/HomeTabActivity;->startActivity(Landroid/content/Intent;)V

    goto :goto_0

    .line 885
    :sswitch_1
    const-string v2, "Menu"

    invoke-static {v2}, Lco/vine/android/util/FlurryUtils;->trackVisitSettings(Ljava/lang/String;)V

    .line 886
    new-instance v2, Landroid/content/Intent;

    const-class v3, Lco/vine/android/SettingsActivity;

    invoke-direct {v2, p0, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    invoke-virtual {p0, v2, v1}, Lco/vine/android/HomeTabActivity;->startActivityForResult(Landroid/content/Intent;I)V

    goto :goto_0

    .line 891
    :sswitch_2
    const-string v2, "Menu"

    invoke-static {v2}, Lco/vine/android/util/FlurryUtils;->trackVisitSearch(Ljava/lang/String;)V

    .line 892
    new-instance v2, Landroid/content/Intent;

    const-class v3, Lco/vine/android/SearchActivity;

    invoke-direct {v2, p0, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    invoke-virtual {p0, v2}, Lco/vine/android/HomeTabActivity;->startActivity(Landroid/content/Intent;)V

    goto :goto_0

    .line 896
    :sswitch_3
    const-string v2, "Menu"

    invoke-static {v2}, Lco/vine/android/util/FlurryUtils;->trackVisitInbox(Ljava/lang/String;)V

    .line 897
    invoke-virtual {p0}, Lco/vine/android/HomeTabActivity;->getSlidingMenu()Lcom/jeremyfeinstein/slidingmenu/lib/SlidingMenu;

    move-result-object v2

    invoke-virtual {v2, v1}, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingMenu;->toggle(Z)V

    goto :goto_0

    .line 901
    :sswitch_4
    invoke-static {}, Lco/vine/android/util/BuildUtil;->isExplore()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 902
    const v2, 0x7f030054

    const v3, 0x7f0a011f

    const/4 v4, 0x0

    invoke-static {p0, v2, v3, v4}, Lco/vine/android/ViewOverlayActivity;->getIntent(Landroid/content/Context;III)Landroid/content/Intent;

    move-result-object v0

    .line 904
    .local v0, "intent":Landroid/content/Intent;
    invoke-virtual {p0, v0, v1}, Lco/vine/android/HomeTabActivity;->startActivityForResult(Landroid/content/Intent;I)V

    goto :goto_0

    .line 907
    .end local v0    # "intent":Landroid/content/Intent;
    :cond_0
    invoke-super {p0, p1}, Lco/vine/android/BaseTimelineActivity;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v1

    goto :goto_0

    .line 878
    :sswitch_data_0
    .sparse-switch
        0x7f0a00e4 -> :sswitch_2
        0x7f0a0145 -> :sswitch_0
        0x7f0a018c -> :sswitch_1
        0x7f0a023c -> :sswitch_4
        0x7f0a0247 -> :sswitch_3
    .end sparse-switch
.end method

.method protected onPause()V
    .locals 4

    .prologue
    .line 420
    invoke-super {p0}, Lco/vine/android/BaseTimelineActivity;->onPause()V

    .line 421
    iget-boolean v0, p0, Lco/vine/android/HomeTabActivity;->mExploreRefreshReciverIsRegistered:Z

    if-nez v0, :cond_0

    .line 422
    const/4 v0, 0x1

    iput-boolean v0, p0, Lco/vine/android/HomeTabActivity;->mExploreRefreshReciverIsRegistered:Z

    .line 423
    iget-object v0, p0, Lco/vine/android/HomeTabActivity;->mExploreRefreshReciver:Landroid/content/BroadcastReceiver;

    sget-object v1, Lco/vine/android/client/AppController;->ACTION_UPDATED_FILTER:Landroid/content/IntentFilter;

    const-string v2, "co.vine.android.BROADCAST"

    const/4 v3, 0x0

    invoke-virtual {p0, v0, v1, v2, v3}, Lco/vine/android/HomeTabActivity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;Ljava/lang/String;Landroid/os/Handler;)Landroid/content/Intent;

    .line 426
    :cond_0
    :try_start_0
    iget-object v0, p0, Lco/vine/android/HomeTabActivity;->mActivityCountReceiver:Landroid/content/BroadcastReceiver;

    invoke-virtual {p0, v0}, Lco/vine/android/HomeTabActivity;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V
    :try_end_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_0

    .line 430
    :goto_0
    return-void

    .line 427
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method protected onResume()V
    .locals 9

    .prologue
    .line 633
    invoke-super {p0}, Lco/vine/android/BaseTimelineActivity;->onResume()V

    .line 634
    iget-object v5, p0, Lco/vine/android/HomeTabActivity;->mTabsAdapter:Lco/vine/android/widget/tabs/TabsAdapter;

    if-eqz v5, :cond_0

    iget-object v5, p0, Lco/vine/android/HomeTabActivity;->mTabHost:Lco/vine/android/widget/tabs/IconTabHost;

    if-eqz v5, :cond_0

    .line 635
    iget-object v5, p0, Lco/vine/android/HomeTabActivity;->mTabsAdapter:Lco/vine/android/widget/tabs/TabsAdapter;

    iget-object v6, p0, Lco/vine/android/HomeTabActivity;->mTabHost:Lco/vine/android/widget/tabs/IconTabHost;

    invoke-virtual {v6}, Lco/vine/android/widget/tabs/IconTabHost;->getCurrentTab()I

    move-result v6

    iput v6, v5, Lco/vine/android/widget/tabs/TabsAdapter;->previousTab:I

    .line 637
    :cond_0
    invoke-static {}, Lco/vine/android/AppImpl;->getInstance()Lco/vine/android/AppImpl;

    move-result-object v5

    invoke-virtual {v5, p0}, Lco/vine/android/AppImpl;->getNotifyFailedIntent(Landroid/content/Context;)Landroid/content/Intent;

    move-result-object v0

    .line 638
    .local v0, "i":Landroid/content/Intent;
    if-eqz v0, :cond_1

    .line 639
    invoke-virtual {p0, v0}, Lco/vine/android/HomeTabActivity;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;

    .line 641
    :cond_1
    iget-object v5, p0, Lco/vine/android/HomeTabActivity;->mTabHost:Lco/vine/android/widget/tabs/IconTabHost;

    invoke-virtual {v5}, Lco/vine/android/widget/tabs/IconTabHost;->getTabWidget()Landroid/widget/TabWidget;

    move-result-object v4

    .line 642
    .local v4, "tabWidget":Landroid/widget/TabWidget;
    if-nez v4, :cond_3

    const/4 v2, 0x0

    .line 643
    .local v2, "tabCount":I
    :goto_0
    const/4 v1, 0x0

    .local v1, "j":I
    :goto_1
    if-ge v1, v2, :cond_4

    .line 644
    invoke-virtual {v4, v1}, Landroid/widget/TabWidget;->getChildAt(I)Landroid/view/View;

    move-result-object v3

    .line 645
    .local v3, "tabView":Landroid/view/View;
    if-eqz v3, :cond_2

    .line 646
    add-int/lit8 v5, v1, 0x1

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v3, v5}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 647
    invoke-virtual {v3, p0}, Landroid/view/View;->setOnLongClickListener(Landroid/view/View$OnLongClickListener;)V

    .line 643
    :cond_2
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 642
    .end local v1    # "j":I
    .end local v2    # "tabCount":I
    .end local v3    # "tabView":Landroid/view/View;
    :cond_3
    invoke-virtual {v4}, Landroid/widget/TabWidget;->getTabCount()I

    move-result v2

    goto :goto_0

    .line 650
    .restart local v1    # "j":I
    .restart local v2    # "tabCount":I
    :cond_4
    iget-object v5, p0, Lco/vine/android/HomeTabActivity;->mActivityCountReceiver:Landroid/content/BroadcastReceiver;

    sget-object v6, Lco/vine/android/HomeTabActivity;->ACTIVITY_COUNT_FILTER:Landroid/content/IntentFilter;

    const-string v7, "co.vine.android.BROADCAST"

    const/4 v8, 0x0

    invoke-virtual {p0, v5, v6, v7, v8}, Lco/vine/android/HomeTabActivity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;Ljava/lang/String;Landroid/os/Handler;)Landroid/content/Intent;

    .line 651
    iget-object v5, p0, Lco/vine/android/HomeTabActivity;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v5}, Lco/vine/android/client/AppController;->fetchActivityCounts()Ljava/lang/String;

    .line 652
    invoke-virtual {p0}, Lco/vine/android/HomeTabActivity;->invalidateActivityBadge()V

    .line 653
    invoke-direct {p0}, Lco/vine/android/HomeTabActivity;->invalidateMessagesBadge()V

    .line 654
    return-void
.end method

.method public onScroll(I)V
    .locals 3
    .param p1, "delta"    # I

    .prologue
    .line 447
    iget-boolean v2, p0, Lco/vine/android/HomeTabActivity;->mScrollAwayNavEnabled:Z

    if-eqz v2, :cond_0

    .line 448
    iget-object v2, p0, Lco/vine/android/HomeTabActivity;->mTabHost:Lco/vine/android/widget/tabs/IconTabHost;

    invoke-virtual {v2}, Lco/vine/android/widget/tabs/IconTabHost;->getTabWidget()Landroid/widget/TabWidget;

    move-result-object v1

    check-cast v1, Lco/vine/android/widget/tabs/ScrollAwayTabWidget;

    .line 449
    .local v1, "tabWidget":Lco/vine/android/widget/tabs/ScrollAwayTabWidget;
    invoke-virtual {v1, p1}, Lco/vine/android/widget/tabs/ScrollAwayTabWidget;->onScroll(I)V

    .line 450
    iget-object v2, p0, Lco/vine/android/HomeTabActivity;->mTabsAdapter:Lco/vine/android/widget/tabs/TabsAdapter;

    invoke-virtual {v2}, Lco/vine/android/widget/tabs/TabsAdapter;->getCurrentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 451
    .local v0, "fragment":Landroid/support/v4/app/Fragment;
    instance-of v2, v0, Lco/vine/android/BaseArrayListFragment;

    if-eqz v2, :cond_0

    .line 452
    check-cast v0, Lco/vine/android/BaseArrayListFragment;

    .end local v0    # "fragment":Landroid/support/v4/app/Fragment;
    invoke-virtual {v1}, Lco/vine/android/widget/tabs/ScrollAwayTabWidget;->getNavBottom()I

    move-result v2

    invoke-virtual {v0, v2}, Lco/vine/android/BaseArrayListFragment;->setNavBottom(I)V

    .line 455
    .end local v1    # "tabWidget":Lco/vine/android/widget/tabs/ScrollAwayTabWidget;
    :cond_0
    return-void
.end method

.method protected onStart()V
    .locals 1

    .prologue
    .line 434
    invoke-super {p0}, Lco/vine/android/BaseTimelineActivity;->onStart()V

    .line 435
    invoke-direct {p0}, Lco/vine/android/HomeTabActivity;->fetchClientFlags()V

    .line 436
    invoke-static {p0}, Lco/vine/android/util/ClientFlagsHelper;->zeroRatingIsEnabled(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 437
    const/4 v0, 0x1

    invoke-static {v0}, Lco/vine/android/util/FlurryUtils;->trackZeroRatedSessionStarted(Z)V

    .line 439
    :cond_0
    return-void
.end method

.method protected onStop()V
    .locals 0

    .prologue
    .line 443
    invoke-super {p0}, Lco/vine/android/BaseTimelineActivity;->onStop()V

    .line 444
    return-void
.end method

.method public onSupportContentChanged()V
    .locals 1

    .prologue
    .line 762
    invoke-super {p0}, Lco/vine/android/BaseTimelineActivity;->onSupportContentChanged()V

    .line 763
    invoke-static {}, Lco/vine/android/util/BuildUtil;->isExplore()Z

    move-result v0

    if-nez v0, :cond_0

    .line 764
    invoke-direct {p0}, Lco/vine/android/HomeTabActivity;->setupTabs()V

    .line 766
    :cond_0
    return-void
.end method

.method public onTabChanged(Ljava/lang/String;)V
    .locals 3
    .param p1, "tag"    # Ljava/lang/String;

    .prologue
    .line 587
    sget-boolean v1, Lcom/edisonwang/android/slog/SLog;->sLogsOn:Z

    if-eqz v1, :cond_0

    .line 588
    invoke-static {}, Lco/vine/android/util/Util;->printCursorWindowStats()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 590
    :cond_0
    iget-object v1, p0, Lco/vine/android/HomeTabActivity;->mTabHost:Lco/vine/android/widget/tabs/IconTabHost;

    invoke-virtual {v1}, Lco/vine/android/widget/tabs/IconTabHost;->getCurrentTab()I

    move-result v0

    .line 591
    .local v0, "tab":I
    iget-object v1, p0, Lco/vine/android/HomeTabActivity;->mViewPager:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v1, v0}, Landroid/support/v4/view/ViewPager;->setCurrentItem(I)V

    .line 592
    iput-object p1, p0, Lco/vine/android/HomeTabActivity;->mRecentTab:Ljava/lang/String;

    .line 593
    const-string v1, "activity"

    invoke-virtual {v1, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 594
    invoke-virtual {p0}, Lco/vine/android/HomeTabActivity;->markActivitiesRead()V

    .line 596
    :cond_1
    packed-switch v0, :pswitch_data_0

    .line 601
    invoke-virtual {p0}, Lco/vine/android/HomeTabActivity;->getSlidingMenu()Lcom/jeremyfeinstein/slidingmenu/lib/SlidingMenu;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingMenu;->setTouchModeAbove(I)V

    .line 604
    :goto_0
    invoke-direct {p0, p1}, Lco/vine/android/HomeTabActivity;->logTabChange(Ljava/lang/String;)V

    .line 605
    return-void

    .line 598
    :pswitch_0
    invoke-virtual {p0}, Lco/vine/android/HomeTabActivity;->getSlidingMenu()Lcom/jeremyfeinstein/slidingmenu/lib/SlidingMenu;

    move-result-object v1

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingMenu;->setTouchModeAbove(I)V

    goto :goto_0

    .line 596
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
    .end packed-switch
.end method

.method public resetNav()V
    .locals 4

    .prologue
    .line 511
    iget-object v3, p0, Lco/vine/android/HomeTabActivity;->mTabHost:Lco/vine/android/widget/tabs/IconTabHost;

    if-eqz v3, :cond_1

    .line 512
    iget-object v3, p0, Lco/vine/android/HomeTabActivity;->mTabHost:Lco/vine/android/widget/tabs/IconTabHost;

    invoke-virtual {v3}, Lco/vine/android/widget/tabs/IconTabHost;->getTabWidget()Landroid/widget/TabWidget;

    move-result-object v2

    check-cast v2, Lco/vine/android/widget/tabs/ScrollAwayTabWidget;

    .line 513
    .local v2, "widget":Lco/vine/android/widget/tabs/ScrollAwayTabWidget;
    if-eqz v2, :cond_1

    .line 514
    invoke-virtual {v2}, Lco/vine/android/widget/tabs/ScrollAwayTabWidget;->resetScroll()V

    .line 515
    invoke-virtual {v2}, Lco/vine/android/widget/tabs/ScrollAwayTabWidget;->invalidate()V

    .line 516
    invoke-virtual {v2}, Lco/vine/android/widget/tabs/ScrollAwayTabWidget;->getNavBottom()I

    move-result v1

    .line 518
    .local v1, "navBottom":I
    iget-object v3, p0, Lco/vine/android/HomeTabActivity;->mTabsAdapter:Lco/vine/android/widget/tabs/TabsAdapter;

    invoke-virtual {v3}, Lco/vine/android/widget/tabs/TabsAdapter;->getCurrentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 519
    .local v0, "fragment":Landroid/support/v4/app/Fragment;
    if-eqz v0, :cond_0

    instance-of v3, v0, Lco/vine/android/BaseArrayListFragment;

    if-eqz v3, :cond_0

    .line 520
    check-cast v0, Lco/vine/android/BaseArrayListFragment;

    .end local v0    # "fragment":Landroid/support/v4/app/Fragment;
    invoke-virtual {v0, v1}, Lco/vine/android/BaseArrayListFragment;->setNavBottom(I)V

    .line 523
    :cond_0
    const/4 v3, 0x1

    iput-boolean v3, p0, Lco/vine/android/HomeTabActivity;->mScrollAwayNavEnabled:Z

    .line 526
    .end local v1    # "navBottom":I
    .end local v2    # "widget":Lco/vine/android/widget/tabs/ScrollAwayTabWidget;
    :cond_1
    return-void
.end method

.method public scrollTop()V
    .locals 4

    .prologue
    .line 962
    iget-object v3, p0, Lco/vine/android/HomeTabActivity;->mTabsAdapter:Lco/vine/android/widget/tabs/TabsAdapter;

    invoke-virtual {v3}, Lco/vine/android/widget/tabs/TabsAdapter;->getCurrentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 963
    .local v0, "fragment":Landroid/support/v4/app/Fragment;
    invoke-virtual {p0}, Lco/vine/android/HomeTabActivity;->resetNav()V

    .line 964
    instance-of v3, v0, Lco/vine/android/BaseArrayListFragment;

    if-eqz v3, :cond_2

    .line 965
    invoke-virtual {v0}, Landroid/support/v4/app/Fragment;->getView()Landroid/view/View;

    move-result-object v2

    .line 966
    .local v2, "view":Landroid/view/View;
    if-nez v2, :cond_1

    .line 980
    .end local v0    # "fragment":Landroid/support/v4/app/Fragment;
    .end local v2    # "view":Landroid/view/View;
    :cond_0
    :goto_0
    return-void

    .line 969
    .restart local v0    # "fragment":Landroid/support/v4/app/Fragment;
    .restart local v2    # "view":Landroid/view/View;
    :cond_1
    const v3, 0x102000a

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/twitter/android/widget/TopScrollable;

    .line 971
    .local v1, "list":Lcom/twitter/android/widget/TopScrollable;
    if-eqz v1, :cond_0

    invoke-interface {v1}, Lcom/twitter/android/widget/TopScrollable;->scrollTop()Z

    move-result v3

    if-nez v3, :cond_0

    .line 973
    check-cast v0, Lco/vine/android/BaseArrayListFragment;

    .end local v0    # "fragment":Landroid/support/v4/app/Fragment;
    invoke-virtual {v0}, Lco/vine/android/BaseArrayListFragment;->invokeScrollFirstItem()V

    goto :goto_0

    .line 976
    .end local v1    # "list":Lcom/twitter/android/widget/TopScrollable;
    .end local v2    # "view":Landroid/view/View;
    .restart local v0    # "fragment":Landroid/support/v4/app/Fragment;
    :cond_2
    instance-of v3, v0, Lcom/twitter/android/widget/TopScrollable;

    if-eqz v3, :cond_0

    .line 977
    check-cast v0, Lcom/twitter/android/widget/TopScrollable;

    .end local v0    # "fragment":Landroid/support/v4/app/Fragment;
    invoke-interface {v0}, Lcom/twitter/android/widget/TopScrollable;->scrollTop()Z

    goto :goto_0
.end method

.method public setProfileColor(I)V
    .locals 3
    .param p1, "color"    # I

    .prologue
    const/4 v2, 0x3

    .line 983
    iget-object v1, p0, Lco/vine/android/HomeTabActivity;->mTabHost:Lco/vine/android/widget/tabs/IconTabHost;

    invoke-virtual {v1}, Lco/vine/android/widget/tabs/IconTabHost;->getCurrentTab()I

    move-result v0

    .line 984
    .local v0, "current":I
    if-ne v0, v2, :cond_0

    .line 985
    iget-object v1, p0, Lco/vine/android/HomeTabActivity;->mTabHost:Lco/vine/android/widget/tabs/IconTabHost;

    invoke-virtual {v1}, Lco/vine/android/widget/tabs/IconTabHost;->getTabWidget()Landroid/widget/TabWidget;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/widget/TabWidget;->getChildTabViewAt(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lco/vine/android/widget/tabs/TabIndicator;

    invoke-virtual {v1, p1}, Lco/vine/android/widget/tabs/TabIndicator;->setColor(I)V

    .line 989
    :goto_0
    return-void

    .line 987
    :cond_0
    iget-object v1, p0, Lco/vine/android/HomeTabActivity;->mTabHost:Lco/vine/android/widget/tabs/IconTabHost;

    invoke-virtual {v1}, Lco/vine/android/widget/tabs/IconTabHost;->getTabWidget()Landroid/widget/TabWidget;

    move-result-object v1

    invoke-virtual {v1, v2}, Landroid/widget/TabWidget;->getChildTabViewAt(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lco/vine/android/widget/tabs/TabIndicator;

    invoke-virtual {v1}, Lco/vine/android/widget/tabs/TabIndicator;->unSetColor()V

    goto :goto_0
.end method

.method public setScrollAwayNavEnabled(Z)V
    .locals 0
    .param p1, "enabled"    # Z

    .prologue
    .line 458
    iput-boolean p1, p0, Lco/vine/android/HomeTabActivity;->mScrollAwayNavEnabled:Z

    .line 459
    return-void
.end method

.method public showMenuIfNeeded()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 615
    iget-boolean v0, p0, Lco/vine/android/HomeTabActivity;->mShouldShowMenu:Z

    if-eqz v0, :cond_0

    .line 616
    const-string v0, "Menu requested."

    invoke-static {v0}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 617
    iput-boolean v1, p0, Lco/vine/android/HomeTabActivity;->mShouldShowMenu:Z

    .line 618
    invoke-virtual {p0}, Lco/vine/android/HomeTabActivity;->getSlidingMenu()Lcom/jeremyfeinstein/slidingmenu/lib/SlidingMenu;

    move-result-object v0

    invoke-virtual {v0, v1}, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingMenu;->showMenu(Z)V

    .line 620
    :cond_0
    return-void
.end method

.method public showPage(ILandroid/support/v4/app/Fragment;)V
    .locals 3
    .param p1, "position"    # I
    .param p2, "fragment"    # Landroid/support/v4/app/Fragment;

    .prologue
    .line 498
    iget-object v1, p0, Lco/vine/android/HomeTabActivity;->mViewPager:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v1, p1}, Landroid/support/v4/view/ViewPager;->setCurrentItem(I)V

    .line 499
    instance-of v1, p2, Lco/vine/android/BaseArrayListFragment;

    if-eqz v1, :cond_0

    move-object v1, p2

    .line 500
    check-cast v1, Lco/vine/android/BaseArrayListFragment;

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Lco/vine/android/BaseArrayListFragment;->onMoveTo(I)V

    .line 502
    :cond_0
    iget-object v1, p0, Lco/vine/android/HomeTabActivity;->mTabsAdapter:Lco/vine/android/widget/tabs/TabsAdapter;

    iget-object v2, p0, Lco/vine/android/HomeTabActivity;->mViewPager:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v2}, Landroid/support/v4/view/ViewPager;->getCurrentItem()I

    move-result v2

    invoke-virtual {v1, v2}, Lco/vine/android/widget/tabs/TabsAdapter;->getTab(I)Lco/vine/android/widget/tabs/TabInfo;

    move-result-object v1

    invoke-virtual {v1}, Lco/vine/android/widget/tabs/TabInfo;->fragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 503
    .local v0, "current":Landroid/support/v4/app/Fragment;
    instance-of v1, v0, Lco/vine/android/BaseArrayListFragment;

    if-eqz v1, :cond_1

    .line 504
    check-cast v0, Lco/vine/android/BaseArrayListFragment;

    .end local v0    # "current":Landroid/support/v4/app/Fragment;
    const/4 v1, -0x1

    invoke-virtual {v0, v1}, Lco/vine/android/BaseArrayListFragment;->onMoveAway(I)V

    .line 506
    :cond_1
    invoke-virtual {p0}, Lco/vine/android/HomeTabActivity;->resetNav()V

    .line 507
    invoke-virtual {p2}, Landroid/support/v4/app/Fragment;->getTag()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v1}, Lco/vine/android/HomeTabActivity;->logTabChange(Ljava/lang/String;)V

    .line 508
    return-void
.end method
