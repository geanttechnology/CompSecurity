.class public Lcom/amazon/mShop/AmazonActivity;
.super Lcom/amazon/mShop/startup/BaseActivity;
.source "AmazonActivity.java"

# interfaces
.implements Lcom/amazon/mShop/actionBar/ActionBarIconController;
.implements Lcom/amazon/mShop/model/auth/UserSubscriber$Callback;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/AmazonActivity$NewIntentListener;,
        Lcom/amazon/mShop/AmazonActivity$OnConfigurationChangedListener;,
        Lcom/amazon/mShop/AmazonActivity$RetailSearchDelayedInitializer;,
        Lcom/amazon/mShop/AmazonActivity$DelayedInitializer;
    }
.end annotation


# static fields
.field public static final ACTIVITY_START_TIME:Ljava/lang/String; = "activity_start_time"

.field public static final CLICK_STREAM_ORIGIN:Ljava/lang/String; = "clickStreamOrigin"

.field protected static final DEBUG:Z

.field public static final INTENT_ACTION_START_ACTIVITY:Ljava/lang/String; = "intentActionStartActivity"

.field public static final KEY_SEARCH_REQUEST_QUERY:Ljava/lang/String; = "Query"

.field public static final KEY_SEARCH_SELECT_INITIAL_QUERY:Ljava/lang/String; = "selectInitialQuery"

.field public static final LOG_TAG:Ljava/lang/String; = "AmazonActivity"

.field public static final ONSTOP_BEHAVIOR_FINISH:I = 0x1

.field public static final ONSTOP_BEHAVIOR_MODAL:I = 0x0

.field public static final ONSTOP_BEHAVIOR_POP_TO_ROOT:I = 0x3

.field public static final ONSTOP_BEHAVIOR_REMOVE_VIEWS:I = 0x2

.field public static final REFMARKER:Ljava/lang/String; = "REFMARKER"

.field public static final TOP_MOST_VIEW_CHANGED_RECEIVER_INTENT:Ljava/lang/String; = "com.amazon.mShop.TopMostViewChangedReceiverIntent"

.field private static sIsInitialLaunch:Z

.field private static sKeepTopActivity:Z

.field private static sNeedRestart:Z

.field private static sTaskID:I

.field private static sTerminationReceiverCounter:I

.field private static sTopMostAmazonActivity:Lcom/amazon/mShop/AmazonActivity;

.field protected static sWebViewInst:Landroid/webkit/WebView;


# instance fields
.field private animationMap:Landroid/util/SparseArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/util/SparseArray",
            "<",
            "Landroid/view/animation/Animation;",
            ">;"
        }
    .end annotation
.end field

.field private mActionBarSeparatorDecorator:Landroid/view/View;

.field private mActivityStartTime:J

.field private mAmazonErrorHandler:Lcom/amazon/mShop/error/AmazonActivityErrorHandler;

.field private mBackButtonPoppedView:Z

.field private mClickStreamOrigin:Ljava/lang/String;

.field private mConfigChangedListenerList:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/mShop/AmazonActivity$OnConfigurationChangedListener;",
            ">;"
        }
    .end annotation
.end field

.field private mContentView:Landroid/view/View;

.field private mErrorBoxView:Lcom/amazon/mShop/error/AmazonErrorBox;

.field private mGNODrawer:Lcom/amazon/mShop/gno/GNODrawer;

.field private mIndexFirstPdv:I

.field private mNetworkInfoMetricObserver:Lcom/amazon/mShop/net/NetworkInfoMetricObserver;

.field private mNewIntentListenerList:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/mShop/AmazonActivity$NewIntentListener;",
            ">;"
        }
    .end annotation
.end field

.field private mTemporaryBlankView:Landroid/view/View;

.field private mTerminationReceiver:Lcom/amazon/mShop/ActivityTerminationReceiver;

.field private primaryUserSubscriberCallback:Lcom/amazon/mShop/model/auth/UserSubscriber$Callback;

.field private pushAnimationInProgress:Z

.field private final pushInAnimationListener:Landroid/view/animation/Animation$AnimationListener;

.field private secondaryUserSubscriberCallback:Lcom/amazon/mShop/model/auth/UserSubscriber$Callback;

.field private skipStopBehavior:Z

.field private stopBehavior:I

.field private viewAnimator:Landroid/widget/ViewAnimator;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 89
    invoke-static {}, Lcom/amazon/mShop/debug/DebugSettings;->isDebugEnabled()Z

    move-result v0

    sput-boolean v0, Lcom/amazon/mShop/AmazonActivity;->DEBUG:Z

    .line 101
    sput v1, Lcom/amazon/mShop/AmazonActivity;->sTerminationReceiverCounter:I

    .line 139
    const/4 v0, 0x1

    sput-boolean v0, Lcom/amazon/mShop/AmazonActivity;->sIsInitialLaunch:Z

    .line 141
    const/high16 v0, -0x80000000

    sput v0, Lcom/amazon/mShop/AmazonActivity;->sTaskID:I

    .line 147
    const/4 v0, 0x0

    sput-object v0, Lcom/amazon/mShop/AmazonActivity;->sWebViewInst:Landroid/webkit/WebView;

    .line 154
    sput-boolean v1, Lcom/amazon/mShop/AmazonActivity;->sKeepTopActivity:Z

    .line 1777
    sput-boolean v1, Lcom/amazon/mShop/AmazonActivity;->sNeedRestart:Z

    return-void
.end method

.method public constructor <init>()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x0

    .line 85
    invoke-direct {p0}, Lcom/amazon/mShop/startup/BaseActivity;-><init>()V

    .line 103
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/AmazonActivity;->mConfigChangedListenerList:Ljava/util/List;

    .line 132
    const/4 v0, -0x1

    iput v0, p0, Lcom/amazon/mShop/AmazonActivity;->mIndexFirstPdv:I

    .line 135
    iput-object v2, p0, Lcom/amazon/mShop/AmazonActivity;->mErrorBoxView:Lcom/amazon/mShop/error/AmazonErrorBox;

    .line 137
    iput-object v2, p0, Lcom/amazon/mShop/AmazonActivity;->mAmazonErrorHandler:Lcom/amazon/mShop/error/AmazonActivityErrorHandler;

    .line 163
    iput-boolean v1, p0, Lcom/amazon/mShop/AmazonActivity;->mBackButtonPoppedView:Z

    .line 901
    iput-boolean v1, p0, Lcom/amazon/mShop/AmazonActivity;->pushAnimationInProgress:Z

    .line 906
    new-instance v0, Lcom/amazon/mShop/AmazonActivity$1;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/AmazonActivity$1;-><init>(Lcom/amazon/mShop/AmazonActivity;)V

    iput-object v0, p0, Lcom/amazon/mShop/AmazonActivity;->pushInAnimationListener:Landroid/view/animation/Animation$AnimationListener;

    .line 924
    new-instance v0, Landroid/util/SparseArray;

    invoke-direct {v0}, Landroid/util/SparseArray;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/AmazonActivity;->animationMap:Landroid/util/SparseArray;

    .line 1600
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/AmazonActivity;->mNewIntentListenerList:Ljava/util/List;

    return-void
.end method

.method private UpdateCartAndAppStartCount(Landroid/content/Context;ZZ)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "isGateway"    # Z
    .param p3, "appDidLaunch"    # Z

    .prologue
    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 286
    invoke-static {}, Lcom/amazon/mShop/control/home/HomeController;->getInstance()Lcom/amazon/mShop/control/home/HomeController;

    move-result-object v0

    .line 288
    .local v0, "homeController":Lcom/amazon/mShop/control/home/HomeController;
    if-eqz p3, :cond_0

    .line 289
    invoke-virtual {v0, v2}, Lcom/amazon/mShop/control/home/HomeController;->setApplicationStarted(Z)V

    .line 293
    if-nez p2, :cond_0

    .line 294
    invoke-virtual {v0, v2}, Lcom/amazon/mShop/control/home/HomeController;->setReturnCartItems(Z)V

    .line 295
    invoke-virtual {v0, v1}, Lcom/amazon/mShop/control/home/HomeController;->setReturnHomeItems(Z)V

    .line 296
    invoke-virtual {v0, v1, v1}, Lcom/amazon/mShop/control/home/HomeController;->phoneHome(ZZ)Z

    .line 300
    :cond_0
    return-void
.end method

.method static synthetic access$202(Lcom/amazon/mShop/AmazonActivity;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/AmazonActivity;
    .param p1, "x1"    # Z

    .prologue
    .line 85
    iput-boolean p1, p0, Lcom/amazon/mShop/AmazonActivity;->pushAnimationInProgress:Z

    return p1
.end method

.method private applyTitle(Landroid/view/View;)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 855
    const/4 v0, 0x0

    .line 856
    .local v0, "title":Ljava/lang/CharSequence;
    instance-of v1, p1, Lcom/amazon/mShop/TitleProvider;

    if-eqz v1, :cond_0

    .line 857
    check-cast p1, Lcom/amazon/mShop/TitleProvider;

    .end local p1    # "view":Landroid/view/View;
    invoke-interface {p1}, Lcom/amazon/mShop/TitleProvider;->getTitle()Ljava/lang/CharSequence;

    move-result-object v0

    .line 859
    :cond_0
    invoke-virtual {p0, v0}, Lcom/amazon/mShop/AmazonActivity;->setTitle(Ljava/lang/CharSequence;)V

    .line 860
    return-void
.end method

.method private authenticateUser(Lcom/amazon/mShop/model/auth/UserSubscriber$Callback;Lcom/amazon/mShop/model/auth/UserSubscriber$Callback;ZLjava/lang/String;)V
    .locals 7
    .param p1, "primaryCallback"    # Lcom/amazon/mShop/model/auth/UserSubscriber$Callback;
    .param p2, "secondaryCallback"    # Lcom/amazon/mShop/model/auth/UserSubscriber$Callback;
    .param p3, "isCreateNewAccount"    # Z
    .param p4, "refMarker"    # Ljava/lang/String;

    .prologue
    const/4 v1, 0x0

    .line 1650
    iput-object p1, p0, Lcom/amazon/mShop/AmazonActivity;->primaryUserSubscriberCallback:Lcom/amazon/mShop/model/auth/UserSubscriber$Callback;

    .line 1651
    iput-object p2, p0, Lcom/amazon/mShop/AmazonActivity;->secondaryUserSubscriberCallback:Lcom/amazon/mShop/model/auth/UserSubscriber$Callback;

    .line 1653
    sget-object v0, Lcom/amazon/mShop/sso/IdentityType;->NON_SSO_TYPE:Lcom/amazon/mShop/sso/IdentityType;

    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil;->getCurrentIdentityType()Lcom/amazon/mShop/sso/IdentityType;

    move-result-object v2

    if-eq v0, v2, :cond_0

    .line 1654
    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil;->getCurrentIdentityType()Lcom/amazon/mShop/sso/IdentityType;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/amazon/mShop/sso/IdentityType;->handleSSOLogin(Landroid/app/Activity;)V

    .line 1667
    :goto_0
    return-void

    .line 1656
    :cond_0
    instance-of v0, p0, Lcom/amazon/mShop/AmazonActivity;

    if-eqz v0, :cond_1

    .line 1657
    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonActivity;->skipNextStopBehavior()V

    .line 1661
    :cond_1
    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonActivity;->isLaunchedFromPublicUrl()Z

    move-result v0

    if-eqz v0, :cond_2

    instance-of v0, p0, Lcom/amazon/mShop/order/web/WebViewOrderActivity;

    if-eqz v0, :cond_2

    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil;->needSigninPrompt()Z

    move-result v0

    if-eqz v0, :cond_2

    const/4 v3, 0x1

    .line 1665
    .local v3, "forceSignInFlag":Z
    :goto_1
    const-string/jumbo v2, "authenticate_user"

    move-object v0, p0

    move v4, v3

    move v5, p3

    move-object v6, p4

    invoke-static/range {v0 .. v6}, Lcom/amazon/mShop/util/ActivityUtils;->startLoginActivityForResult(Landroid/content/Context;ILjava/lang/String;ZZZLjava/lang/String;)Z

    goto :goto_0

    .end local v3    # "forceSignInFlag":Z
    :cond_2
    move v3, v1

    .line 1661
    goto :goto_1
.end method

.method private getAnimation(I)Landroid/view/animation/Animation;
    .locals 1
    .param p1, "id"    # I

    .prologue
    .line 955
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/amazon/mShop/AmazonActivity;->getAnimation(ILandroid/view/animation/Animation$AnimationListener;)Landroid/view/animation/Animation;

    move-result-object v0

    return-object v0
.end method

.method private getAnimation(ILandroid/view/animation/Animation$AnimationListener;)Landroid/view/animation/Animation;
    .locals 2
    .param p1, "id"    # I
    .param p2, "animationListener"    # Landroid/view/animation/Animation$AnimationListener;

    .prologue
    .line 936
    if-nez p1, :cond_1

    .line 937
    const/4 v0, 0x0

    .line 947
    :cond_0
    :goto_0
    return-object v0

    .line 941
    :cond_1
    iget-object v1, p0, Lcom/amazon/mShop/AmazonActivity;->animationMap:Landroid/util/SparseArray;

    invoke-virtual {v1, p1}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/animation/Animation;

    .local v0, "animation":Landroid/view/animation/Animation;
    if-nez v0, :cond_0

    .line 942
    invoke-static {p0, p1}, Landroid/view/animation/AnimationUtils;->loadAnimation(Landroid/content/Context;I)Landroid/view/animation/Animation;

    move-result-object v0

    .line 943
    iget-object v1, p0, Lcom/amazon/mShop/AmazonActivity;->animationMap:Landroid/util/SparseArray;

    invoke-virtual {v1, p1, v0}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    .line 944
    invoke-virtual {v0, p2}, Landroid/view/animation/Animation;->setAnimationListener(Landroid/view/animation/Animation$AnimationListener;)V

    goto :goto_0
.end method

.method public static declared-synchronized getTerminationReceiverCounter()I
    .locals 2

    .prologue
    .line 1788
    const-class v0, Lcom/amazon/mShop/AmazonActivity;

    monitor-enter v0

    :try_start_0
    sget v1, Lcom/amazon/mShop/AmazonActivity;->sTerminationReceiverCounter:I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v0

    return v1

    :catchall_0
    move-exception v1

    monitor-exit v0

    throw v1
.end method

.method public static final getTopMostBaseActivity()Lcom/amazon/mShop/AmazonActivity;
    .locals 1

    .prologue
    .line 1439
    sget-object v0, Lcom/amazon/mShop/AmazonActivity;->sTopMostAmazonActivity:Lcom/amazon/mShop/AmazonActivity;

    return-object v0
.end method

.method private getViewAnimator(Z)Landroid/widget/ViewAnimator;
    .locals 3
    .param p1, "needWrapped"    # Z
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "NewApi"
        }
    .end annotation

    .prologue
    .line 980
    iget-object v1, p0, Lcom/amazon/mShop/AmazonActivity;->viewAnimator:Landroid/widget/ViewAnimator;

    if-nez v1, :cond_0

    .line 981
    new-instance v1, Landroid/widget/ViewAnimator;

    invoke-direct {v1, p0}, Landroid/widget/ViewAnimator;-><init>(Landroid/content/Context;)V

    iput-object v1, p0, Lcom/amazon/mShop/AmazonActivity;->viewAnimator:Landroid/widget/ViewAnimator;

    .line 982
    iget-object v1, p0, Lcom/amazon/mShop/AmazonActivity;->viewAnimator:Landroid/widget/ViewAnimator;

    invoke-static {}, Lcom/amazon/mShop/util/LayoutUtils;->fillBoth()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/ViewAnimator;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 983
    if-eqz p1, :cond_1

    .line 986
    iget-object v1, p0, Lcom/amazon/mShop/AmazonActivity;->viewAnimator:Landroid/widget/ViewAnimator;

    invoke-virtual {p0, v1}, Lcom/amazon/mShop/AmazonActivity;->setupCustomizedActionbar(Landroid/widget/ViewAnimator;)Landroid/view/View;

    move-result-object v0

    .line 987
    .local v0, "wrappedViewAnimator":Landroid/view/View;
    iput-object v0, p0, Lcom/amazon/mShop/AmazonActivity;->mActionBarSeparatorDecorator:Landroid/view/View;

    .line 990
    invoke-virtual {p0, v0}, Lcom/amazon/mShop/AmazonActivity;->setWrappedViewAnimator(Landroid/view/View;)Landroid/view/View;

    move-result-object v0

    .line 993
    invoke-static {p0, v0}, Lcom/amazon/mShop/actionBar/ActionBarHelper;->applyActionBar(Lcom/amazon/mShop/AmazonActivity;Landroid/view/View;)Landroid/view/View;

    move-result-object v0

    .line 995
    invoke-super {p0, v0}, Lcom/amazon/mShop/startup/BaseActivity;->setContentView(Landroid/view/View;)V

    .line 996
    iput-object v0, p0, Lcom/amazon/mShop/AmazonActivity;->mContentView:Landroid/view/View;

    .line 1002
    .end local v0    # "wrappedViewAnimator":Landroid/view/View;
    :cond_0
    :goto_0
    iget-object v1, p0, Lcom/amazon/mShop/AmazonActivity;->viewAnimator:Landroid/widget/ViewAnimator;

    return-object v1

    .line 998
    :cond_1
    iget-object v1, p0, Lcom/amazon/mShop/AmazonActivity;->viewAnimator:Landroid/widget/ViewAnimator;

    invoke-super {p0, v1}, Lcom/amazon/mShop/startup/BaseActivity;->setContentView(Landroid/view/View;)V

    .line 999
    iget-object v1, p0, Lcom/amazon/mShop/AmazonActivity;->viewAnimator:Landroid/widget/ViewAnimator;

    iput-object v1, p0, Lcom/amazon/mShop/AmazonActivity;->mContentView:Landroid/view/View;

    goto :goto_0
.end method

.method public static declared-synchronized isNeedRestart()Z
    .locals 2

    .prologue
    .line 1784
    const-class v0, Lcom/amazon/mShop/AmazonActivity;

    monitor-enter v0

    :try_start_0
    sget-boolean v1, Lcom/amazon/mShop/AmazonActivity;->sNeedRestart:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v0

    return v1

    :catchall_0
    move-exception v1

    monitor-exit v0

    throw v1
.end method

.method private onTopmostViewChanged()V
    .locals 3

    .prologue
    .line 1234
    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonActivity;->getCurrentView()Landroid/view/View;

    move-result-object v0

    .line 1235
    .local v0, "currentView":Landroid/view/View;
    invoke-direct {p0, v0}, Lcom/amazon/mShop/AmazonActivity;->applyTitle(Landroid/view/View;)V

    .line 1237
    new-instance v1, Landroid/content/Intent;

    invoke-direct {v1}, Landroid/content/Intent;-><init>()V

    .line 1238
    .local v1, "intent":Landroid/content/Intent;
    const-string/jumbo v2, "com.amazon.mShop.TopMostViewChangedReceiverIntent"

    invoke-virtual {v1, v2}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 1239
    invoke-virtual {p0, v1}, Lcom/amazon/mShop/AmazonActivity;->sendBroadcast(Landroid/content/Intent;)V

    .line 1240
    return-void
.end method

.method public static declared-synchronized setNeedRestart(Z)V
    .locals 2
    .param p0, "needRestart"    # Z

    .prologue
    .line 1780
    const-class v0, Lcom/amazon/mShop/AmazonActivity;

    monitor-enter v0

    :try_start_0
    sput-boolean p0, Lcom/amazon/mShop/AmazonActivity;->sNeedRestart:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 1781
    monitor-exit v0

    return-void

    .line 1780
    :catchall_0
    move-exception v1

    monitor-exit v0

    throw v1
.end method

.method public static declared-synchronized setTerminationReceiverCounter(I)V
    .locals 2
    .param p0, "terminationReceiverCounter"    # I

    .prologue
    .line 1792
    const-class v0, Lcom/amazon/mShop/AmazonActivity;

    monitor-enter v0

    :try_start_0
    sput p0, Lcom/amazon/mShop/AmazonActivity;->sTerminationReceiverCounter:I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 1793
    monitor-exit v0

    return-void

    .line 1792
    :catchall_0
    move-exception v1

    monitor-exit v0

    throw v1
.end method

.method private startLogTime()V
    .locals 3

    .prologue
    .line 1471
    invoke-static {}, Lcom/amazon/mShop/net/NetInfo;->getNetworkType()Ljava/lang/String;

    move-result-object v0

    .line 1472
    .local v0, "identifier":Ljava/lang/String;
    invoke-static {v0}, Lcom/amazon/mShop/net/NetworkInfoMetricObserver;->start(Ljava/lang/String;)Lcom/amazon/mShop/net/NetworkInfoMetricObserver;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/mShop/AmazonActivity;->mNetworkInfoMetricObserver:Lcom/amazon/mShop/net/NetworkInfoMetricObserver;

    .line 1473
    iget-object v1, p0, Lcom/amazon/mShop/AmazonActivity;->mNetworkInfoMetricObserver:Lcom/amazon/mShop/net/NetworkInfoMetricObserver;

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/net/NetworkInfoMetricObserver;->startForObject(Ljava/lang/String;)V

    .line 1474
    sget-boolean v1, Lcom/amazon/mShop/AmazonActivity;->DEBUG:Z

    if-eqz v1, :cond_0

    .line 1475
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    const-string/jumbo v2, "Network collection start to log time"

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 1477
    :cond_0
    return-void
.end method

.method private stopLogTime()V
    .locals 2

    .prologue
    .line 1483
    iget-object v0, p0, Lcom/amazon/mShop/AmazonActivity;->mNetworkInfoMetricObserver:Lcom/amazon/mShop/net/NetworkInfoMetricObserver;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/AmazonActivity;->mNetworkInfoMetricObserver:Lcom/amazon/mShop/net/NetworkInfoMetricObserver;

    invoke-virtual {v0}, Lcom/amazon/mShop/net/NetworkInfoMetricObserver;->isFinished()Z

    move-result v0

    if-nez v0, :cond_0

    .line 1484
    iget-object v0, p0, Lcom/amazon/mShop/AmazonActivity;->mNetworkInfoMetricObserver:Lcom/amazon/mShop/net/NetworkInfoMetricObserver;

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/net/NetworkInfoMetricObserver;->completeForObject(Ljava/lang/String;)V

    .line 1485
    sget-boolean v0, Lcom/amazon/mShop/AmazonActivity;->DEBUG:Z

    if-eqz v0, :cond_0

    .line 1486
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "Network collection end to log time"

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 1489
    :cond_0
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/mShop/AmazonActivity;->mNetworkInfoMetricObserver:Lcom/amazon/mShop/net/NetworkInfoMetricObserver;

    .line 1490
    return-void
.end method


# virtual methods
.method public authenticateUser(Lcom/amazon/mShop/model/auth/UserSubscriber$Callback;Lcom/amazon/mShop/model/auth/UserSubscriber$Callback;)V
    .locals 2
    .param p1, "primaryCallback"    # Lcom/amazon/mShop/model/auth/UserSubscriber$Callback;
    .param p2, "secondaryCallback"    # Lcom/amazon/mShop/model/auth/UserSubscriber$Callback;

    .prologue
    .line 1625
    const/4 v0, 0x0

    const/4 v1, 0x0

    invoke-direct {p0, p1, p2, v0, v1}, Lcom/amazon/mShop/AmazonActivity;->authenticateUser(Lcom/amazon/mShop/model/auth/UserSubscriber$Callback;Lcom/amazon/mShop/model/auth/UserSubscriber$Callback;ZLjava/lang/String;)V

    .line 1626
    return-void
.end method

.method public authenticateUser(Lcom/amazon/mShop/model/auth/UserSubscriber$Callback;Lcom/amazon/mShop/model/auth/UserSubscriber$Callback;Ljava/lang/String;)V
    .locals 1
    .param p1, "primaryCallback"    # Lcom/amazon/mShop/model/auth/UserSubscriber$Callback;
    .param p2, "secondaryCallback"    # Lcom/amazon/mShop/model/auth/UserSubscriber$Callback;
    .param p3, "refMarker"    # Ljava/lang/String;

    .prologue
    .line 1629
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0, p3}, Lcom/amazon/mShop/AmazonActivity;->authenticateUser(Lcom/amazon/mShop/model/auth/UserSubscriber$Callback;Lcom/amazon/mShop/model/auth/UserSubscriber$Callback;ZLjava/lang/String;)V

    .line 1630
    return-void
.end method

.method public authenticateUser(Lcom/amazon/mShop/model/auth/UserSubscriber$Callback;Lcom/amazon/mShop/model/auth/UserSubscriber$Callback;Z)V
    .locals 1
    .param p1, "primaryCallback"    # Lcom/amazon/mShop/model/auth/UserSubscriber$Callback;
    .param p2, "secondaryCallback"    # Lcom/amazon/mShop/model/auth/UserSubscriber$Callback;
    .param p3, "isCreateNewAccount"    # Z

    .prologue
    .line 1633
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, p3, v0}, Lcom/amazon/mShop/AmazonActivity;->authenticateUser(Lcom/amazon/mShop/model/auth/UserSubscriber$Callback;Lcom/amazon/mShop/model/auth/UserSubscriber$Callback;ZLjava/lang/String;)V

    .line 1634
    return-void
.end method

.method public canLaunchHomeFromActionBar()Z
    .locals 1

    .prologue
    .line 1827
    const/4 v0, 0x1

    return v0
.end method

.method public clearErrorOnView(Landroid/view/View;)V
    .locals 3
    .param p1, "clearOnView"    # Landroid/view/View;

    .prologue
    .line 1312
    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonActivity;->getViewAnimator()Landroid/widget/ViewAnimator;

    move-result-object v1

    invoke-static {v1, p1}, Lcom/amazon/mShop/util/UIUtils;->findViewIndex(Landroid/widget/ViewAnimator;Landroid/view/View;)I

    move-result v0

    .line 1313
    .local v0, "viewIndex":I
    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonActivity;->getErrorHandler()Lcom/amazon/mShop/error/AmazonActivityErrorHandler;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v1, v2, v0}, Lcom/amazon/mShop/error/AmazonActivityErrorHandler;->onErrorReportAt(Lcom/amazon/mShop/error/AmazonErrorInfo;I)V

    .line 1315
    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonActivity;->getViewAnimator()Landroid/widget/ViewAnimator;

    move-result-object v1

    invoke-virtual {v1}, Landroid/widget/ViewAnimator;->getChildCount()I

    move-result v1

    add-int/lit8 v1, v1, -0x1

    if-ne v0, v1, :cond_0

    .line 1316
    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonActivity;->dismissErrorBox()V

    .line 1318
    :cond_0
    return-void
.end method

.method protected clearKeepTopActivityFlag()V
    .locals 1

    .prologue
    .line 1816
    const/4 v0, 0x0

    sput-boolean v0, Lcom/amazon/mShop/AmazonActivity;->sKeepTopActivity:Z

    .line 1817
    return-void
.end method

.method public closeSoftKeyboard()V
    .locals 1

    .prologue
    .line 1223
    iget-object v0, p0, Lcom/amazon/mShop/AmazonActivity;->viewAnimator:Landroid/widget/ViewAnimator;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/AmazonActivity;->viewAnimator:Landroid/widget/ViewAnimator;

    invoke-virtual {v0}, Landroid/widget/ViewAnimator;->getChildCount()I

    move-result v0

    if-lez v0, :cond_0

    .line 1224
    iget-object v0, p0, Lcom/amazon/mShop/AmazonActivity;->viewAnimator:Landroid/widget/ViewAnimator;

    invoke-virtual {v0}, Landroid/widget/ViewAnimator;->getCurrentView()Landroid/view/View;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/util/UIUtils;->closeSoftKeyboard(Landroid/view/View;)V

    .line 1226
    :cond_0
    return-void
.end method

.method public defaultStartActivity(Landroid/content/Intent;)V
    .locals 0
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 1760
    invoke-super {p0, p1}, Lcom/amazon/mShop/startup/BaseActivity;->startActivity(Landroid/content/Intent;)V

    .line 1761
    return-void
.end method

.method public dismissErrorBox()V
    .locals 1

    .prologue
    .line 1334
    iget-object v0, p0, Lcom/amazon/mShop/AmazonActivity;->mErrorBoxView:Lcom/amazon/mShop/error/AmazonErrorBox;

    if-eqz v0, :cond_0

    .line 1336
    iget-object v0, p0, Lcom/amazon/mShop/AmazonActivity;->mErrorBoxView:Lcom/amazon/mShop/error/AmazonErrorBox;

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/AmazonActivity;->removeErrorBox(Landroid/view/View;)V

    .line 1338
    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonActivity;->getErrorHandler()Lcom/amazon/mShop/error/AmazonActivityErrorHandler;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/error/AmazonActivityErrorHandler;->onErrorBoxDisappeared()V

    .line 1340
    iget-object v0, p0, Lcom/amazon/mShop/AmazonActivity;->mErrorBoxView:Lcom/amazon/mShop/error/AmazonErrorBox;

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/AmazonActivity;->unregisterConfigChangedListener(Lcom/amazon/mShop/AmazonActivity$OnConfigurationChangedListener;)V

    .line 1343
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/mShop/AmazonActivity;->mErrorBoxView:Lcom/amazon/mShop/error/AmazonErrorBox;

    .line 1345
    :cond_0
    return-void
.end method

.method public dispatchKeyEvent(Landroid/view/KeyEvent;)Z
    .locals 5
    .param p1, "event"    # Landroid/view/KeyEvent;

    .prologue
    const/4 v4, 0x4

    const/4 v3, 0x0

    const/4 v1, 0x1

    .line 1030
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/AmazonActivity;->menuDispatchedKeyEvent(Landroid/view/KeyEvent;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 1064
    :cond_0
    :goto_0
    return v1

    .line 1034
    :cond_1
    iget-boolean v2, p0, Lcom/amazon/mShop/AmazonActivity;->pushAnimationInProgress:Z

    if-nez v2, :cond_0

    .line 1037
    iget-object v2, p0, Lcom/amazon/mShop/AmazonActivity;->viewAnimator:Landroid/widget/ViewAnimator;

    if-eqz v2, :cond_3

    .line 1038
    invoke-virtual {p1}, Landroid/view/KeyEvent;->getKeyCode()I

    move-result v2

    if-ne v4, v2, :cond_3

    invoke-virtual {p1}, Landroid/view/KeyEvent;->getAction()I

    move-result v2

    if-nez v2, :cond_3

    .line 1043
    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonActivity;->getCurrentView()Landroid/view/View;

    move-result-object v0

    .line 1044
    .local v0, "currentView":Landroid/view/View;
    if-eqz v0, :cond_2

    invoke-virtual {v0, p1}, Landroid/view/View;->dispatchKeyEvent(Landroid/view/KeyEvent;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 1047
    :cond_2
    invoke-virtual {p0, v3}, Lcom/amazon/mShop/AmazonActivity;->popView(Z)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 1048
    iput-boolean v1, p0, Lcom/amazon/mShop/AmazonActivity;->mBackButtonPoppedView:Z

    goto :goto_0

    .line 1054
    .end local v0    # "currentView":Landroid/view/View;
    :cond_3
    iget-boolean v2, p0, Lcom/amazon/mShop/AmazonActivity;->mBackButtonPoppedView:Z

    if-eqz v2, :cond_4

    invoke-virtual {p1}, Landroid/view/KeyEvent;->getKeyCode()I

    move-result v2

    if-ne v4, v2, :cond_4

    invoke-virtual {p1}, Landroid/view/KeyEvent;->getAction()I

    move-result v2

    if-ne v1, v2, :cond_4

    .line 1061
    iput-boolean v3, p0, Lcom/amazon/mShop/AmazonActivity;->mBackButtonPoppedView:Z

    goto :goto_0

    .line 1064
    :cond_4
    invoke-super {p0, p1}, Lcom/amazon/mShop/startup/BaseActivity;->dispatchKeyEvent(Landroid/view/KeyEvent;)Z

    move-result v1

    goto :goto_0
.end method

.method public dispatchTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 1
    .param p1, "ev"    # Landroid/view/MotionEvent;

    .prologue
    .line 1070
    iget-boolean v0, p0, Lcom/amazon/mShop/AmazonActivity;->pushAnimationInProgress:Z

    if-eqz v0, :cond_0

    .line 1071
    const/4 v0, 0x1

    .line 1073
    :goto_0
    return v0

    :cond_0
    invoke-super {p0, p1}, Lcom/amazon/mShop/startup/BaseActivity;->dispatchTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    goto :goto_0
.end method

.method public dispatchTrackballEvent(Landroid/view/MotionEvent;)Z
    .locals 1
    .param p1, "ev"    # Landroid/view/MotionEvent;

    .prologue
    .line 1078
    iget-boolean v0, p0, Lcom/amazon/mShop/AmazonActivity;->pushAnimationInProgress:Z

    if-eqz v0, :cond_0

    .line 1079
    const/4 v0, 0x1

    .line 1081
    :goto_0
    return v0

    :cond_0
    invoke-super {p0, p1}, Lcom/amazon/mShop/startup/BaseActivity;->dispatchTrackballEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    goto :goto_0
.end method

.method public final findViewById(I)Landroid/view/View;
    .locals 1
    .param p1, "id"    # I
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 477
    invoke-super {p0, p1}, Lcom/amazon/mShop/startup/BaseActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public finishIfNotFinishing()V
    .locals 1

    .prologue
    .line 1767
    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonActivity;->isFinishing()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1771
    :goto_0
    return-void

    .line 1770
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonActivity;->finish()V

    goto :goto_0
.end method

.method public forward(Ljava/lang/Object;)Z
    .locals 4
    .param p1, "object"    # Ljava/lang/Object;

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 883
    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonActivity;->closeSoftKeyboard()V

    .line 885
    instance-of v2, p1, Lcom/amazon/mShop/control/item/ProductController;

    if-eqz v2, :cond_0

    .line 887
    check-cast p1, Lcom/amazon/mShop/control/item/ProductController;

    .end local p1    # "object":Ljava/lang/Object;
    new-array v1, v1, [I

    invoke-static {p0, p1, v1}, Lcom/amazon/mShop/util/ActivityUtils;->launchDetailsPage(Landroid/content/Context;Lcom/amazon/mShop/control/item/ProductController;[I)Z

    .line 893
    :goto_0
    return v0

    .line 889
    .restart local p1    # "object":Ljava/lang/Object;
    :cond_0
    instance-of v2, p1, Landroid/net/Uri;

    if-eqz v2, :cond_1

    .line 890
    new-instance v1, Lcom/amazon/mShop/AmazonBrandedWebView;

    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    sget v3, Lcom/amazon/mShop/android/lib/R$string;->navigate_forward_to_uri:I

    invoke-virtual {p0, v3}, Lcom/amazon/mShop/AmazonActivity;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, p0, v2, v3}, Lcom/amazon/mShop/AmazonBrandedWebView;-><init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {p0, v1}, Lcom/amazon/mShop/AmazonActivity;->pushView(Landroid/view/View;)V

    goto :goto_0

    :cond_1
    move v0, v1

    .line 893
    goto :goto_0
.end method

.method public getActivityStartTime()J
    .locals 4

    .prologue
    .line 1748
    iget-wide v0, p0, Lcom/amazon/mShop/AmazonActivity;->mActivityStartTime:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-lez v0, :cond_0

    iget-wide v0, p0, Lcom/amazon/mShop/AmazonActivity;->mActivityStartTime:J

    :goto_0
    return-wide v0

    :cond_0
    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v0

    goto :goto_0
.end method

.method public getClickStreamOrigin()Ljava/lang/String;
    .locals 1

    .prologue
    .line 373
    iget-object v0, p0, Lcom/amazon/mShop/AmazonActivity;->mClickStreamOrigin:Ljava/lang/String;

    return-object v0
.end method

.method public getContentView()Landroid/view/View;
    .locals 1

    .prologue
    .line 963
    iget-object v0, p0, Lcom/amazon/mShop/AmazonActivity;->mContentView:Landroid/view/View;

    return-object v0
.end method

.method public getCurrentErrorInfo()Lcom/amazon/mShop/error/AmazonErrorInfo;
    .locals 1

    .prologue
    .line 1387
    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonActivity;->getErrorHandler()Lcom/amazon/mShop/error/AmazonActivityErrorHandler;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/error/AmazonActivityErrorHandler;->getCurrentErrorInfo()Lcom/amazon/mShop/error/AmazonErrorInfo;

    move-result-object v0

    return-object v0
.end method

.method public getCurrentView()Landroid/view/View;
    .locals 1

    .prologue
    .line 486
    iget-object v0, p0, Lcom/amazon/mShop/AmazonActivity;->viewAnimator:Landroid/widget/ViewAnimator;

    if-eqz v0, :cond_0

    .line 487
    iget-object v0, p0, Lcom/amazon/mShop/AmazonActivity;->viewAnimator:Landroid/widget/ViewAnimator;

    invoke-virtual {v0}, Landroid/widget/ViewAnimator;->getCurrentView()Landroid/view/View;

    move-result-object v0

    .line 489
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getErrorHandler()Lcom/amazon/mShop/error/AmazonActivityErrorHandler;
    .locals 1

    .prologue
    .line 1251
    iget-object v0, p0, Lcom/amazon/mShop/AmazonActivity;->mAmazonErrorHandler:Lcom/amazon/mShop/error/AmazonActivityErrorHandler;

    if-nez v0, :cond_0

    .line 1252
    new-instance v0, Lcom/amazon/mShop/error/AmazonActivityErrorHandler;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/error/AmazonActivityErrorHandler;-><init>(Lcom/amazon/mShop/AmazonActivity;)V

    iput-object v0, p0, Lcom/amazon/mShop/AmazonActivity;->mAmazonErrorHandler:Lcom/amazon/mShop/error/AmazonActivityErrorHandler;

    .line 1254
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/AmazonActivity;->mAmazonErrorHandler:Lcom/amazon/mShop/error/AmazonActivityErrorHandler;

    return-object v0
.end method

.method public getGNODrawer()Lcom/amazon/mShop/gno/GNODrawer;
    .locals 1

    .prologue
    .line 1808
    iget-object v0, p0, Lcom/amazon/mShop/AmazonActivity;->mGNODrawer:Lcom/amazon/mShop/gno/GNODrawer;

    return-object v0
.end method

.method public getViewAnimator()Landroid/widget/ViewAnimator;
    .locals 1

    .prologue
    .line 969
    const/4 v0, 0x1

    invoke-direct {p0, v0}, Lcom/amazon/mShop/AmazonActivity;->getViewAnimator(Z)Landroid/widget/ViewAnimator;

    move-result-object v0

    return-object v0
.end method

.method public handleConfigChanged(Landroid/content/res/Configuration;)V
    .locals 3
    .param p1, "newConfig"    # Landroid/content/res/Configuration;

    .prologue
    .line 1578
    iget-object v2, p0, Lcom/amazon/mShop/AmazonActivity;->mConfigChangedListenerList:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/AmazonActivity$OnConfigurationChangedListener;

    .line 1579
    .local v1, "listener":Lcom/amazon/mShop/AmazonActivity$OnConfigurationChangedListener;
    invoke-interface {v1, p1}, Lcom/amazon/mShop/AmazonActivity$OnConfigurationChangedListener;->handleConfigurationChanged(Landroid/content/res/Configuration;)V

    goto :goto_0

    .line 1581
    .end local v1    # "listener":Lcom/amazon/mShop/AmazonActivity$OnConfigurationChangedListener;
    :cond_0
    return-void
.end method

.method protected handleForceSignIn()V
    .locals 0

    .prologue
    .line 274
    return-void
.end method

.method public handleNewIntent(Landroid/content/Intent;)V
    .locals 3
    .param p1, "newIntent"    # Landroid/content/Intent;

    .prologue
    .line 1615
    iget-object v2, p0, Lcom/amazon/mShop/AmazonActivity;->mNewIntentListenerList:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/AmazonActivity$NewIntentListener;

    .line 1616
    .local v1, "listener":Lcom/amazon/mShop/AmazonActivity$NewIntentListener;
    invoke-interface {v1, p1}, Lcom/amazon/mShop/AmazonActivity$NewIntentListener;->handleNewIntent(Landroid/content/Intent;)V

    goto :goto_0

    .line 1618
    .end local v1    # "listener":Lcom/amazon/mShop/AmazonActivity$NewIntentListener;
    :cond_0
    return-void
.end method

.method protected insertErrorBox(Landroid/view/View;)V
    .locals 3
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 1358
    iget-object v1, p0, Lcom/amazon/mShop/AmazonActivity;->mActionBarSeparatorDecorator:Landroid/view/View;

    check-cast v1, Landroid/view/ViewGroup;

    .line 1359
    .local v1, "rootView":Landroid/view/ViewGroup;
    invoke-virtual {v1}, Landroid/view/ViewGroup;->getChildCount()I

    move-result v2

    add-int/lit8 v0, v2, -0x1

    .line 1360
    .local v0, "destIndex":I
    if-ltz v0, :cond_0

    .line 1361
    invoke-virtual {v1, p1, v0}, Landroid/view/ViewGroup;->addView(Landroid/view/View;I)V

    .line 1365
    :goto_0
    return-void

    .line 1363
    :cond_0
    invoke-virtual {v1, p1}, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V

    goto :goto_0
.end method

.method public isActionBarSearchIconFadeable()Z
    .locals 2

    .prologue
    .line 1821
    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonActivity;->getCurrentView()Landroid/view/View;

    move-result-object v0

    .line 1822
    .local v0, "currentView":Landroid/view/View;
    instance-of v1, v0, Lcom/amazon/mShop/actionBar/ActionBarIconController;

    if-eqz v1, :cond_0

    check-cast v0, Lcom/amazon/mShop/actionBar/ActionBarIconController;

    .end local v0    # "currentView":Landroid/view/View;
    invoke-interface {v0}, Lcom/amazon/mShop/actionBar/ActionBarIconController;->isActionBarSearchIconFadeable()Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v1, 0x1

    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public isErrorBoxShowing()Z
    .locals 1

    .prologue
    .line 1327
    iget-object v0, p0, Lcom/amazon/mShop/AmazonActivity;->mErrorBoxView:Lcom/amazon/mShop/error/AmazonErrorBox;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isLaunchedFromPublicUrl()Z
    .locals 3

    .prologue
    const/4 v1, 0x0

    .line 1831
    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    .line 1832
    .local v0, "intent":Landroid/content/Intent;
    if-eqz v0, :cond_0

    const-string/jumbo v2, "Launch_From_Public_Url"

    invoke-virtual {v0, v2, v1}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v2

    if-eqz v2, :cond_0

    const/4 v1, 0x1

    :cond_0
    return v1
.end method

.method public isPushAnimationInProgress()Z
    .locals 1

    .prologue
    .line 899
    iget-boolean v0, p0, Lcom/amazon/mShop/AmazonActivity;->pushAnimationInProgress:Z

    return v0
.end method

.method public logTimeWhenNetworkTypeChanged()V
    .locals 2

    .prologue
    .line 1498
    sget-boolean v0, Lcom/amazon/mShop/AmazonActivity;->DEBUG:Z

    if-eqz v0, :cond_0

    .line 1499
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "Network work type changed"

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 1501
    :cond_0
    invoke-direct {p0}, Lcom/amazon/mShop/AmazonActivity;->stopLogTime()V

    .line 1502
    invoke-direct {p0}, Lcom/amazon/mShop/AmazonActivity;->startLogTime()V

    .line 1503
    return-void
.end method

.method public menuDispatchedKeyEvent(Landroid/view/KeyEvent;)Z
    .locals 4
    .param p1, "event"    # Landroid/view/KeyEvent;

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 1198
    const/16 v2, 0x52

    invoke-static {p1, v2, v1}, Lcom/amazon/mShop/util/KeyUtils;->isEventMatching(Landroid/view/KeyEvent;II)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 1199
    instance-of v1, p0, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;

    if-eqz v1, :cond_0

    .line 1200
    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonActivity;->getGNODrawer()Lcom/amazon/mShop/gno/GNODrawer;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/gno/GNODrawer;->unlock()V

    .line 1202
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonActivity;->getGNODrawer()Lcom/amazon/mShop/gno/GNODrawer;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/gno/GNODrawer;->toggle()V

    .line 1216
    :cond_1
    :goto_0
    return v0

    .line 1206
    :cond_2
    invoke-virtual {p1}, Landroid/view/KeyEvent;->getKeyCode()I

    move-result v2

    const/4 v3, 0x4

    if-ne v2, v3, :cond_4

    iget-object v2, p0, Lcom/amazon/mShop/AmazonActivity;->mGNODrawer:Lcom/amazon/mShop/gno/GNODrawer;

    invoke-virtual {v2}, Lcom/amazon/mShop/gno/GNODrawer;->isVisible()Z

    move-result v2

    if-eqz v2, :cond_4

    .line 1207
    invoke-virtual {p1}, Landroid/view/KeyEvent;->getAction()I

    move-result v1

    if-nez v1, :cond_1

    .line 1208
    iget-object v1, p0, Lcom/amazon/mShop/AmazonActivity;->mGNODrawer:Lcom/amazon/mShop/gno/GNODrawer;

    invoke-virtual {v1}, Lcom/amazon/mShop/gno/GNODrawer;->isAppDrawerOpen()Z

    move-result v1

    if-eqz v1, :cond_3

    .line 1209
    iget-object v1, p0, Lcom/amazon/mShop/AmazonActivity;->mGNODrawer:Lcom/amazon/mShop/gno/GNODrawer;

    invoke-virtual {v1}, Lcom/amazon/mShop/gno/GNODrawer;->closeAppDrawer()V

    goto :goto_0

    .line 1211
    :cond_3
    iget-object v1, p0, Lcom/amazon/mShop/AmazonActivity;->mGNODrawer:Lcom/amazon/mShop/gno/GNODrawer;

    invoke-virtual {v1}, Lcom/amazon/mShop/gno/GNODrawer;->close()V

    goto :goto_0

    :cond_4
    move v0, v1

    .line 1216
    goto :goto_0
.end method

.method protected onActivityResult(IILandroid/content/Intent;)V
    .locals 2
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    const/4 v1, 0x0

    .line 1674
    invoke-super {p0, p1, p2, p3}, Lcom/amazon/mShop/startup/BaseActivity;->onActivityResult(IILandroid/content/Intent;)V

    .line 1675
    if-nez p1, :cond_0

    .line 1676
    const/4 v0, -0x1

    if-ne v0, p2, :cond_1

    .line 1677
    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonActivity;->userSuccessfullySignedIn()V

    .line 1681
    :goto_0
    iput-object v1, p0, Lcom/amazon/mShop/AmazonActivity;->primaryUserSubscriberCallback:Lcom/amazon/mShop/model/auth/UserSubscriber$Callback;

    .line 1682
    iput-object v1, p0, Lcom/amazon/mShop/AmazonActivity;->secondaryUserSubscriberCallback:Lcom/amazon/mShop/model/auth/UserSubscriber$Callback;

    .line 1684
    :cond_0
    return-void

    .line 1679
    :cond_1
    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonActivity;->userCancelledSignIn()V

    goto :goto_0
.end method

.method public onConfigurationChanged(Landroid/content/res/Configuration;)V
    .locals 0
    .param p1, "newConfig"    # Landroid/content/res/Configuration;

    .prologue
    .line 1585
    invoke-super {p0, p1}, Lcom/amazon/mShop/startup/BaseActivity;->onConfigurationChanged(Landroid/content/res/Configuration;)V

    .line 1589
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/AmazonActivity;->handleConfigChanged(Landroid/content/res/Configuration;)V

    .line 1590
    return-void
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 8
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 175
    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonActivity;->getTaskId()I

    move-result v0

    .line 177
    .local v0, "currentTaskID":I
    sget v4, Lcom/amazon/mShop/AmazonActivity;->sTaskID:I

    const/high16 v5, -0x80000000

    if-ne v4, v5, :cond_6

    .line 178
    sput v0, Lcom/amazon/mShop/AmazonActivity;->sTaskID:I

    .line 179
    sput-boolean v2, Lcom/amazon/mShop/AmazonActivity;->sIsInitialLaunch:Z

    .line 188
    :goto_0
    sget-boolean v4, Lcom/amazon/mShop/AmazonActivity;->sIsInitialLaunch:Z

    if-ne v4, v2, :cond_0

    .line 189
    invoke-static {p0}, Lcom/amazon/mShop/util/ShortcutUtil;->increaseAppStartCountInCurrentVersion(Landroid/content/Context;)V

    .line 192
    :cond_0
    sget-boolean v4, Lcom/amazon/mShop/AmazonActivity;->DEBUG:Z

    if-eqz v4, :cond_1

    .line 193
    const-string/jumbo v4, "AmazonActivity"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v6, "sIsInitialLaunch is "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    sget-boolean v6, Lcom/amazon/mShop/AmazonActivity;->sIsInitialLaunch:Z

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 196
    :cond_1
    invoke-static {p0}, Lcom/amazon/mShop/AmazonApplication;->setUp(Landroid/content/Context;)V

    .line 198
    instance-of v4, p0, Lcom/amazon/mShop/home/GatewayActivity;

    if-nez v4, :cond_2

    instance-of v4, p0, Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;

    if-eqz v4, :cond_8

    .line 200
    .local v2, "isGateway":Z
    :cond_2
    :goto_1
    sget-boolean v4, Lcom/amazon/mShop/AmazonActivity;->sIsInitialLaunch:Z

    invoke-direct {p0, p0, v2, v4}, Lcom/amazon/mShop/AmazonActivity;->UpdateCartAndAppStartCount(Landroid/content/Context;ZZ)V

    .line 202
    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonActivity;->handleForceSignIn()V

    .line 204
    sput-boolean v3, Lcom/amazon/mShop/AmazonActivity;->sIsInitialLaunch:Z

    .line 206
    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonActivity;->registerPushNotification()V

    .line 208
    invoke-super {p0, p1}, Lcom/amazon/mShop/startup/BaseActivity;->onCreate(Landroid/os/Bundle;)V

    .line 218
    if-nez p1, :cond_3

    .line 219
    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonActivity;->getIntent()Landroid/content/Intent;

    move-result-object v4

    const-string/jumbo v5, "activity_start_time"

    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v6

    invoke-virtual {v4, v5, v6, v7}, Landroid/content/Intent;->getLongExtra(Ljava/lang/String;J)J

    move-result-wide v4

    iput-wide v4, p0, Lcom/amazon/mShop/AmazonActivity;->mActivityStartTime:J

    .line 223
    :cond_3
    new-instance v4, Lcom/amazon/mShop/ActivityTerminationReceiver;

    invoke-direct {v4}, Lcom/amazon/mShop/ActivityTerminationReceiver;-><init>()V

    iput-object v4, p0, Lcom/amazon/mShop/AmazonActivity;->mTerminationReceiver:Lcom/amazon/mShop/ActivityTerminationReceiver;

    .line 224
    iget-object v4, p0, Lcom/amazon/mShop/AmazonActivity;->mTerminationReceiver:Lcom/amazon/mShop/ActivityTerminationReceiver;

    sget-object v5, Lcom/amazon/mShop/ActivityTerminationReceiver;->INTENT_FILTER:Landroid/content/IntentFilter;

    invoke-virtual {p0, v4, v5}, Lcom/amazon/mShop/AmazonActivity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 225
    invoke-static {}, Lcom/amazon/mShop/AmazonActivity;->getTerminationReceiverCounter()I

    move-result v4

    add-int/lit8 v4, v4, 0x1

    invoke-static {v4}, Lcom/amazon/mShop/AmazonActivity;->setTerminationReceiverCounter(I)V

    .line 227
    sget-boolean v4, Lcom/amazon/mShop/AmazonActivity;->DEBUG:Z

    if-eqz v4, :cond_4

    .line 228
    const-string/jumbo v4, "AmazonActivity"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v6, "onCreate: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 231
    :cond_4
    iput v3, p0, Lcom/amazon/mShop/AmazonActivity;->stopBehavior:I

    .line 232
    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonActivity;->getIntent()Landroid/content/Intent;

    move-result-object v1

    .line 233
    .local v1, "intent":Landroid/content/Intent;
    const-string/jumbo v3, "clickStreamOrigin"

    invoke-virtual {v1, v3}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Lcom/amazon/mShop/AmazonActivity;->mClickStreamOrigin:Ljava/lang/String;

    .line 235
    sget-object v3, Lcom/amazon/mShop/AmazonActivity;->sWebViewInst:Landroid/webkit/WebView;

    if-nez v3, :cond_5

    .line 236
    new-instance v3, Landroid/webkit/WebView;

    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    invoke-direct {v3, v4}, Landroid/webkit/WebView;-><init>(Landroid/content/Context;)V

    sput-object v3, Lcom/amazon/mShop/AmazonActivity;->sWebViewInst:Landroid/webkit/WebView;

    .line 239
    :cond_5
    invoke-static {p0}, Lcom/amazon/mShop/gno/GNODrawer;->getInstance(Lcom/amazon/mShop/AmazonActivity;)Lcom/amazon/mShop/gno/GNODrawer;

    move-result-object v3

    iput-object v3, p0, Lcom/amazon/mShop/AmazonActivity;->mGNODrawer:Lcom/amazon/mShop/gno/GNODrawer;

    .line 240
    return-void

    .line 180
    .end local v1    # "intent":Landroid/content/Intent;
    .end local v2    # "isGateway":Z
    :cond_6
    sget v4, Lcom/amazon/mShop/AmazonActivity;->sTaskID:I

    if-eq v4, v0, :cond_7

    .line 181
    sput v0, Lcom/amazon/mShop/AmazonActivity;->sTaskID:I

    .line 182
    sput-boolean v2, Lcom/amazon/mShop/AmazonActivity;->sIsInitialLaunch:Z

    goto/16 :goto_0

    .line 184
    :cond_7
    sput-boolean v3, Lcom/amazon/mShop/AmazonActivity;->sIsInitialLaunch:Z

    goto/16 :goto_0

    :cond_8
    move v2, v3

    .line 198
    goto/16 :goto_1
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;)Z
    .locals 1
    .param p1, "menu"    # Landroid/view/Menu;

    .prologue
    .line 1177
    invoke-static {p1, p0}, Lcom/amazon/mShop/util/MenuUtil;->onCreateOptionsMenu(Landroid/view/Menu;Lcom/amazon/mShop/AmazonActivity;)Z

    .line 1178
    const/4 v0, 0x1

    return v0
.end method

.method protected onDestroy()V
    .locals 2

    .prologue
    .line 1399
    iget-object v1, p0, Lcom/amazon/mShop/AmazonActivity;->mTerminationReceiver:Lcom/amazon/mShop/ActivityTerminationReceiver;

    invoke-virtual {p0, v1}, Lcom/amazon/mShop/AmazonActivity;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    .line 1400
    invoke-static {}, Lcom/amazon/mShop/AmazonActivity;->getTerminationReceiverCounter()I

    move-result v1

    add-int/lit8 v1, v1, -0x1

    invoke-static {v1}, Lcom/amazon/mShop/AmazonActivity;->setTerminationReceiverCounter(I)V

    .line 1402
    invoke-super {p0}, Lcom/amazon/mShop/startup/BaseActivity;->onDestroy()V

    .line 1403
    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonActivity;->removeAllViews()V

    .line 1409
    invoke-static {}, Lcom/amazon/mShop/AmazonActivity;->getTerminationReceiverCounter()I

    move-result v1

    if-nez v1, :cond_0

    invoke-static {}, Lcom/amazon/mShop/AmazonActivity;->isNeedRestart()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 1410
    invoke-static {p0}, Lcom/amazon/mShop/util/AppUtils;->launchApp(Landroid/content/Context;)V

    .line 1411
    const/4 v1, 0x0

    invoke-static {v1}, Lcom/amazon/mShop/AmazonActivity;->setNeedRestart(Z)V

    .line 1414
    :cond_0
    const/4 v1, 0x0

    iput-object v1, p0, Lcom/amazon/mShop/AmazonActivity;->mTerminationReceiver:Lcom/amazon/mShop/ActivityTerminationReceiver;

    .line 1416
    invoke-static {}, Lcom/amazon/mShop/util/MShopPushNotificationUtils;->isPushNotificationAvailable()Z

    move-result v1

    if-eqz v1, :cond_1

    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonActivity;->isTaskRoot()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 1417
    invoke-static {}, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->getInstance()Lcom/amazon/mShop/pushnotification/PushNotificationManager;

    move-result-object v0

    .line 1418
    .local v0, "pushNotificationManager":Lcom/amazon/mShop/pushnotification/PushNotificationManager;
    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->onMainActivityDestroyed(Landroid/content/Context;)V

    .line 1420
    .end local v0    # "pushNotificationManager":Lcom/amazon/mShop/pushnotification/PushNotificationManager;
    :cond_1
    iget-object v1, p0, Lcom/amazon/mShop/AmazonActivity;->mGNODrawer:Lcom/amazon/mShop/gno/GNODrawer;

    invoke-virtual {v1}, Lcom/amazon/mShop/gno/GNODrawer;->destroy()V

    .line 1421
    return-void
.end method

.method public onEulaAccepted()V
    .locals 0

    .prologue
    .line 1805
    return-void
.end method

.method public onLowMemory()V
    .locals 0

    .prologue
    .line 1426
    invoke-static {}, Lcom/amazon/mShop/net/LRUCache;->onLowMemory()V

    .line 1427
    return-void
.end method

.method public onMenuItemSelected(ILandroid/view/MenuItem;)Z
    .locals 1
    .param p1, "featureId"    # I
    .param p2, "item"    # Landroid/view/MenuItem;

    .prologue
    .line 1134
    sparse-switch p1, :sswitch_data_0

    .line 1140
    const/4 v0, 0x0

    :goto_0
    return v0

    .line 1136
    :sswitch_0
    invoke-virtual {p0, p2}, Lcom/amazon/mShop/AmazonActivity;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v0

    goto :goto_0

    .line 1138
    :sswitch_1
    invoke-super {p0, p1, p2}, Lcom/amazon/mShop/startup/BaseActivity;->onMenuItemSelected(ILandroid/view/MenuItem;)Z

    move-result v0

    goto :goto_0

    .line 1134
    nop

    :sswitch_data_0
    .sparse-switch
        0x0 -> :sswitch_0
        0x6 -> :sswitch_1
    .end sparse-switch
.end method

.method protected onNewIntent(Landroid/content/Intent;)V
    .locals 4
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 1155
    invoke-super {p0, p1}, Lcom/amazon/mShop/startup/BaseActivity;->onNewIntent(Landroid/content/Intent;)V

    .line 1156
    const-string/jumbo v1, "activity_start_time"

    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v2

    invoke-virtual {p1, v1, v2, v3}, Landroid/content/Intent;->getLongExtra(Ljava/lang/String;J)J

    move-result-wide v1

    iput-wide v1, p0, Lcom/amazon/mShop/AmazonActivity;->mActivityStartTime:J

    .line 1157
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/AmazonActivity;->handleNewIntent(Landroid/content/Intent;)V

    .line 1158
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    .line 1159
    .local v0, "act":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 1160
    const-string/jumbo v1, "intentActionStartActivity"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 1161
    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonActivity;->popToRoot()V

    .line 1164
    :cond_0
    return-void
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 1
    .param p1, "item"    # Landroid/view/MenuItem;

    .prologue
    .line 1150
    invoke-static {p1, p0}, Lcom/amazon/mShop/util/MenuUtil;->onOptionsItemSelected(Landroid/view/MenuItem;Lcom/amazon/mShop/AmazonActivity;)Z

    move-result v0

    return v0
.end method

.method protected onPause()V
    .locals 1

    .prologue
    .line 1535
    invoke-super {p0}, Lcom/amazon/mShop/startup/BaseActivity;->onPause()V

    .line 1537
    invoke-direct {p0}, Lcom/amazon/mShop/AmazonActivity;->stopLogTime()V

    .line 1539
    sget-object v0, Lcom/amazon/mShop/AmazonActivity;->sTopMostAmazonActivity:Lcom/amazon/mShop/AmazonActivity;

    if-ne v0, p0, :cond_0

    sget-boolean v0, Lcom/amazon/mShop/AmazonActivity;->sKeepTopActivity:Z

    if-nez v0, :cond_0

    .line 1540
    const/4 v0, 0x0

    sput-object v0, Lcom/amazon/mShop/AmazonActivity;->sTopMostAmazonActivity:Lcom/amazon/mShop/AmazonActivity;

    .line 1545
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonActivity;->pauseTimersIfNeeded()V

    .line 1546
    return-void
.end method

.method public onPrepareOptionsMenu(Landroid/view/Menu;)Z
    .locals 1
    .param p1, "menu"    # Landroid/view/Menu;

    .prologue
    .line 1184
    const/4 v0, 0x0

    return v0
.end method

.method protected onResume()V
    .locals 1

    .prologue
    .line 1447
    invoke-super {p0}, Lcom/amazon/mShop/startup/BaseActivity;->onResume()V

    .line 1448
    sput-object p0, Lcom/amazon/mShop/AmazonActivity;->sTopMostAmazonActivity:Lcom/amazon/mShop/AmazonActivity;

    .line 1450
    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonActivity;->resumeTimersIfNeeded()V

    .line 1453
    invoke-static {}, Lcom/amazon/mShop/feature/Features;->getInstance()Lcom/amazon/mShop/feature/Features;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/feature/Features;->fetchFeatureStates()V

    .line 1456
    iget-object v0, p0, Lcom/amazon/mShop/AmazonActivity;->mGNODrawer:Lcom/amazon/mShop/gno/GNODrawer;

    invoke-virtual {v0}, Lcom/amazon/mShop/gno/GNODrawer;->resetPosition()V

    .line 1457
    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonActivity;->updateGNOMenuItems()V

    .line 1458
    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonActivity;->removeTemporaryBlankView()V

    .line 1460
    invoke-direct {p0}, Lcom/amazon/mShop/AmazonActivity;->startLogTime()V

    .line 1463
    invoke-static {}, Lcom/amazon/mShop/smile/SmileUserListener;->registerUserListener()V

    .line 1464
    invoke-static {}, Lcom/amazon/mShop/smile/SmileHelper;->syncSmileInfoWithTimeInterval()V

    .line 1465
    return-void
.end method

.method public onSearchRequested()Z
    .locals 2

    .prologue
    .line 1096
    const/4 v0, 0x0

    const/4 v1, 0x1

    invoke-virtual {p0, v0, v1}, Lcom/amazon/mShop/AmazonActivity;->onSearchRequested(Ljava/lang/String;Z)Z

    move-result v0

    return v0
.end method

.method public onSearchRequested(Ljava/lang/String;Z)Z
    .locals 3
    .param p1, "searchTerm"    # Ljava/lang/String;
    .param p2, "selectInitialQuery"    # Z

    .prologue
    .line 1100
    new-instance v1, Lcom/amazon/mShop/search/SearchIntentBuilder;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/search/SearchIntentBuilder;-><init>(Landroid/content/Context;)V

    invoke-virtual {v1, p1}, Lcom/amazon/mShop/search/SearchIntentBuilder;->query(Ljava/lang/String;)Lcom/amazon/mShop/search/SearchIntentBuilder;

    move-result-object v1

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/search/SearchIntentBuilder;->showSearchEntryView(Z)Lcom/amazon/mShop/search/SearchIntentBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Lcom/amazon/mShop/search/SearchIntentBuilder;->selectInitialQuery(Z)Lcom/amazon/mShop/search/SearchIntentBuilder;

    move-result-object v1

    sget-object v2, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_SEARCH:Lcom/amazon/mShop/control/item/ClickStreamTag;

    invoke-virtual {v2}, Lcom/amazon/mShop/control/item/ClickStreamTag;->getTag()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/search/SearchIntentBuilder;->clickStreamOrigin(Ljava/lang/String;)Lcom/amazon/mShop/search/SearchIntentBuilder;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/search/SearchIntentBuilder;->build()Landroid/content/Intent;

    move-result-object v0

    .line 1106
    .local v0, "searchIntent":Landroid/content/Intent;
    invoke-static {p0, v0}, Lcom/amazon/mShop/util/ActivityUtils;->startSearchActivity(Lcom/amazon/mShop/AmazonActivity;Landroid/content/Intent;)Z

    move-result v1

    return v1
.end method

.method protected onStart()V
    .locals 3

    .prologue
    .line 305
    invoke-super {p0}, Lcom/amazon/mShop/startup/BaseActivity;->onStart()V

    .line 306
    sget-boolean v0, Lcom/amazon/mShop/AmazonActivity;->DEBUG:Z

    if-eqz v0, :cond_0

    .line 307
    const-string/jumbo v0, "AmazonActivity"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "onStart: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 308
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonActivity;->getWindow()Landroid/view/Window;

    move-result-object v0

    const/4 v1, 0x3

    invoke-virtual {v0, v1}, Landroid/view/Window;->setSoftInputMode(I)V

    .line 309
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/mShop/AmazonActivity;->skipStopBehavior:Z

    .line 310
    return-void
.end method

.method protected onStop()V
    .locals 3

    .prologue
    .line 323
    invoke-super {p0}, Lcom/amazon/mShop/startup/BaseActivity;->onStop()V

    .line 324
    sget-boolean v0, Lcom/amazon/mShop/AmazonActivity;->DEBUG:Z

    if-eqz v0, :cond_0

    .line 325
    const-string/jumbo v0, "AmazonActivity"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "onStop: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 327
    :cond_0
    iget-boolean v0, p0, Lcom/amazon/mShop/AmazonActivity;->skipStopBehavior:Z

    if-nez v0, :cond_1

    .line 328
    iget v0, p0, Lcom/amazon/mShop/AmazonActivity;->stopBehavior:I

    packed-switch v0, :pswitch_data_0

    .line 344
    :cond_1
    :goto_0
    invoke-static {}, Lcom/amazon/mShop/util/AppUtils;->isApplicationForeground()Z

    move-result v0

    if-nez v0, :cond_2

    .line 346
    invoke-static {}, Lcom/amazon/mShop/share/WechatSDKManager;->clearPendingTransaction()V

    .line 352
    :cond_2
    iget-object v0, p0, Lcom/amazon/mShop/AmazonActivity;->mGNODrawer:Lcom/amazon/mShop/gno/GNODrawer;

    invoke-virtual {v0}, Lcom/amazon/mShop/gno/GNODrawer;->close()V

    .line 353
    return-void

    .line 330
    :pswitch_0
    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonActivity;->finish()V

    goto :goto_0

    .line 333
    :pswitch_1
    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonActivity;->removeAllViews()V

    goto :goto_0

    .line 336
    :pswitch_2
    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonActivity;->popToRoot()V

    goto :goto_0

    .line 328
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method protected onTitleChanged(Ljava/lang/CharSequence;I)V
    .locals 0
    .param p1, "title"    # Ljava/lang/CharSequence;
    .param p2, "color"    # I

    .prologue
    .line 317
    invoke-super {p0, p1, p2}, Lcom/amazon/mShop/startup/BaseActivity;->onTitleChanged(Ljava/lang/CharSequence;I)V

    .line 318
    invoke-static {p0, p1}, Lcom/amazon/mShop/actionBar/ActionBarHelper;->onTitleChanged(Lcom/amazon/mShop/AmazonActivity;Ljava/lang/CharSequence;)V

    .line 319
    return-void
.end method

.method protected onViewPopped(Landroid/view/View;Landroid/view/View;)V
    .locals 0
    .param p1, "oldTop"    # Landroid/view/View;
    .param p2, "newTop"    # Landroid/view/View;

    .prologue
    .line 690
    return-void
.end method

.method protected onViewPushed(Landroid/view/View;)V
    .locals 0
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 575
    return-void
.end method

.method public onWindowFocusChanged(Z)V
    .locals 2
    .param p1, "hasFocus"    # Z

    .prologue
    .line 1111
    invoke-super {p0, p1}, Lcom/amazon/mShop/startup/BaseActivity;->onWindowFocusChanged(Z)V

    .line 1112
    if-eqz p1, :cond_0

    .line 1113
    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonActivity;->getCurrentView()Landroid/view/View;

    move-result-object v0

    .line 1114
    .local v0, "view":Landroid/view/View;
    if-eqz v0, :cond_0

    .line 1115
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 1118
    .end local v0    # "view":Landroid/view/View;
    :cond_0
    return-void
.end method

.method protected pauseTimersIfNeeded()V
    .locals 1

    .prologue
    .line 1528
    invoke-static {}, Lcom/amazon/mShop/AmazonApplication;->isWebViewCacheEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    .line 1529
    sget-object v0, Lcom/amazon/mShop/AmazonActivity;->sWebViewInst:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->pauseTimers()V

    .line 1531
    :cond_0
    return-void
.end method

.method public popToRoot()V
    .locals 3

    .prologue
    const/4 v1, 0x0

    const/4 v2, 0x1

    .line 739
    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonActivity;->closeSoftKeyboard()V

    .line 741
    iget-object v0, p0, Lcom/amazon/mShop/AmazonActivity;->viewAnimator:Landroid/widget/ViewAnimator;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/AmazonActivity;->viewAnimator:Landroid/widget/ViewAnimator;

    invoke-virtual {v0}, Landroid/widget/ViewAnimator;->getChildCount()I

    move-result v0

    if-ge v2, v0, :cond_0

    .line 742
    iget-object v0, p0, Lcom/amazon/mShop/AmazonActivity;->viewAnimator:Landroid/widget/ViewAnimator;

    invoke-virtual {v0, v1}, Landroid/widget/ViewAnimator;->setInAnimation(Landroid/view/animation/Animation;)V

    .line 743
    iget-object v0, p0, Lcom/amazon/mShop/AmazonActivity;->viewAnimator:Landroid/widget/ViewAnimator;

    invoke-virtual {v0, v1}, Landroid/widget/ViewAnimator;->setOutAnimation(Landroid/view/animation/Animation;)V

    .line 744
    iget-object v0, p0, Lcom/amazon/mShop/AmazonActivity;->viewAnimator:Landroid/widget/ViewAnimator;

    iget-object v1, p0, Lcom/amazon/mShop/AmazonActivity;->viewAnimator:Landroid/widget/ViewAnimator;

    invoke-virtual {v1}, Landroid/widget/ViewAnimator;->getChildCount()I

    move-result v1

    add-int/lit8 v1, v1, -0x1

    invoke-virtual {v0, v2, v1}, Landroid/widget/ViewAnimator;->removeViews(II)V

    .line 746
    invoke-direct {p0}, Lcom/amazon/mShop/AmazonActivity;->onTopmostViewChanged()V

    .line 748
    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonActivity;->getErrorHandler()Lcom/amazon/mShop/error/AmazonActivityErrorHandler;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/error/AmazonActivityErrorHandler;->onPoppedToRoot()V

    .line 750
    :cond_0
    return-void
.end method

.method public popView()Z
    .locals 1

    .prologue
    .line 664
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/AmazonActivity;->popView(Z)Z

    move-result v0

    return v0
.end method

.method public popView(Z)Z
    .locals 1
    .param p1, "finishIfActivityIsEmpty"    # Z

    .prologue
    .line 679
    const/4 v0, 0x1

    invoke-virtual {p0, p1, v0}, Lcom/amazon/mShop/AmazonActivity;->popView(ZZ)Z

    move-result v0

    return v0
.end method

.method public popView(ZII)Z
    .locals 5
    .param p1, "finishActivityIfEmpty"    # Z
    .param p2, "inId"    # I
    .param p3, "outId"    # I

    .prologue
    .line 623
    const/4 v1, 0x0

    .line 624
    .local v1, "result":Z
    const/4 v2, 0x0

    .line 625
    .local v2, "top":Landroid/view/View;
    const/4 v0, 0x0

    .line 628
    .local v0, "newTop":Landroid/view/View;
    const/4 v3, 0x0

    iput-boolean v3, p0, Lcom/amazon/mShop/AmazonActivity;->pushAnimationInProgress:Z

    .line 629
    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonActivity;->closeSoftKeyboard()V

    .line 631
    iget-object v3, p0, Lcom/amazon/mShop/AmazonActivity;->viewAnimator:Landroid/widget/ViewAnimator;

    if-eqz v3, :cond_1

    const/4 v3, 0x1

    iget-object v4, p0, Lcom/amazon/mShop/AmazonActivity;->viewAnimator:Landroid/widget/ViewAnimator;

    invoke-virtual {v4}, Landroid/widget/ViewAnimator;->getChildCount()I

    move-result v4

    if-ge v3, v4, :cond_1

    .line 635
    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonActivity;->dismissErrorBox()V

    .line 637
    iget-object v3, p0, Lcom/amazon/mShop/AmazonActivity;->viewAnimator:Landroid/widget/ViewAnimator;

    invoke-virtual {v3}, Landroid/widget/ViewAnimator;->getCurrentView()Landroid/view/View;

    move-result-object v2

    .line 638
    iget-object v3, p0, Lcom/amazon/mShop/AmazonActivity;->viewAnimator:Landroid/widget/ViewAnimator;

    invoke-direct {p0, p2}, Lcom/amazon/mShop/AmazonActivity;->getAnimation(I)Landroid/view/animation/Animation;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/widget/ViewAnimator;->setInAnimation(Landroid/view/animation/Animation;)V

    .line 639
    iget-object v3, p0, Lcom/amazon/mShop/AmazonActivity;->viewAnimator:Landroid/widget/ViewAnimator;

    invoke-direct {p0, p3}, Lcom/amazon/mShop/AmazonActivity;->getAnimation(I)Landroid/view/animation/Animation;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/widget/ViewAnimator;->setOutAnimation(Landroid/view/animation/Animation;)V

    .line 641
    iget-object v3, p0, Lcom/amazon/mShop/AmazonActivity;->viewAnimator:Landroid/widget/ViewAnimator;

    invoke-virtual {v3}, Landroid/widget/ViewAnimator;->showPrevious()V

    .line 642
    iget-object v3, p0, Lcom/amazon/mShop/AmazonActivity;->viewAnimator:Landroid/widget/ViewAnimator;

    invoke-virtual {v3, v2}, Landroid/widget/ViewAnimator;->removeView(Landroid/view/View;)V

    .line 643
    iget-object v3, p0, Lcom/amazon/mShop/AmazonActivity;->viewAnimator:Landroid/widget/ViewAnimator;

    invoke-virtual {v3}, Landroid/widget/ViewAnimator;->getCurrentView()Landroid/view/View;

    move-result-object v0

    .line 645
    invoke-direct {p0}, Lcom/amazon/mShop/AmazonActivity;->onTopmostViewChanged()V

    .line 648
    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonActivity;->getErrorHandler()Lcom/amazon/mShop/error/AmazonActivityErrorHandler;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/mShop/error/AmazonActivityErrorHandler;->onViewPopped()V

    .line 650
    const/4 v1, 0x1

    .line 656
    :cond_0
    :goto_0
    invoke-virtual {p0, v2, v0}, Lcom/amazon/mShop/AmazonActivity;->onViewPopped(Landroid/view/View;Landroid/view/View;)V

    .line 657
    return v1

    .line 651
    :cond_1
    if-eqz p1, :cond_0

    .line 652
    iget-object v3, p0, Lcom/amazon/mShop/AmazonActivity;->viewAnimator:Landroid/widget/ViewAnimator;

    invoke-virtual {v3}, Landroid/widget/ViewAnimator;->getCurrentView()Landroid/view/View;

    move-result-object v0

    .line 653
    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonActivity;->finish()V

    goto :goto_0
.end method

.method public popView(ZZ)Z
    .locals 2
    .param p1, "finishActivityIfEmpty"    # Z
    .param p2, "useAnimation"    # Z

    .prologue
    const/4 v0, 0x0

    .line 603
    if-eqz p2, :cond_0

    sget v0, Lcom/amazon/mShop/android/lib/R$anim;->transition_pop_in:I

    sget v1, Lcom/amazon/mShop/android/lib/R$anim;->transition_pop_out:I

    invoke-virtual {p0, p1, v0, v1}, Lcom/amazon/mShop/AmazonActivity;->popView(ZII)Z

    move-result v0

    :goto_0
    return v0

    :cond_0
    invoke-virtual {p0, p1, v0, v0}, Lcom/amazon/mShop/AmazonActivity;->popView(ZII)Z

    move-result v0

    goto :goto_0
.end method

.method public pushTemporaryBlankView()V
    .locals 3

    .prologue
    .line 497
    new-instance v0, Landroid/view/View;

    invoke-direct {v0, p0}, Landroid/view/View;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/amazon/mShop/AmazonActivity;->mTemporaryBlankView:Landroid/view/View;

    .line 500
    iget-object v0, p0, Lcom/amazon/mShop/AmazonActivity;->mTemporaryBlankView:Landroid/view/View;

    const/4 v1, 0x0

    sget v2, Lcom/amazon/mShop/android/lib/R$anim;->fade_out:I

    invoke-virtual {p0, v0, v1, v2}, Lcom/amazon/mShop/AmazonActivity;->pushView(Landroid/view/View;II)V

    .line 501
    return-void
.end method

.method public pushView(I)V
    .locals 1
    .param p1, "layoutResID"    # I

    .prologue
    .line 504
    iget-boolean v0, p0, Lcom/amazon/mShop/AmazonActivity;->pushAnimationInProgress:Z

    if-eqz v0, :cond_0

    .line 508
    :goto_0
    return-void

    .line 507
    :cond_0
    const/4 v0, 0x0

    invoke-static {p0, p1, v0}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/AmazonActivity;->pushView(Landroid/view/View;)V

    goto :goto_0
.end method

.method public pushView(Landroid/view/View;)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 515
    const/4 v0, 0x1

    invoke-virtual {p0, p1, v0}, Lcom/amazon/mShop/AmazonActivity;->pushView(Landroid/view/View;Z)V

    .line 516
    return-void
.end method

.method public pushView(Landroid/view/View;II)V
    .locals 4
    .param p1, "view"    # Landroid/view/View;
    .param p2, "inId"    # I
    .param p3, "outId"    # I

    .prologue
    const/4 v3, 0x1

    .line 543
    iget-boolean v1, p0, Lcom/amazon/mShop/AmazonActivity;->pushAnimationInProgress:Z

    if-eqz v1, :cond_0

    .line 566
    :goto_0
    return-void

    .line 547
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonActivity;->getErrorHandler()Lcom/amazon/mShop/error/AmazonActivityErrorHandler;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/error/AmazonActivityErrorHandler;->onPushView()V

    .line 548
    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonActivity;->closeSoftKeyboard()V

    .line 550
    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonActivity;->getViewAnimator()Landroid/widget/ViewAnimator;

    move-result-object v0

    .line 551
    .local v0, "va":Landroid/widget/ViewAnimator;
    iget-object v1, p0, Lcom/amazon/mShop/AmazonActivity;->pushInAnimationListener:Landroid/view/animation/Animation$AnimationListener;

    invoke-direct {p0, p2, v1}, Lcom/amazon/mShop/AmazonActivity;->getAnimation(ILandroid/view/animation/Animation$AnimationListener;)Landroid/view/animation/Animation;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ViewAnimator;->setInAnimation(Landroid/view/animation/Animation;)V

    .line 552
    invoke-direct {p0, p3}, Lcom/amazon/mShop/AmazonActivity;->getAnimation(I)Landroid/view/animation/Animation;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ViewAnimator;->setOutAnimation(Landroid/view/animation/Animation;)V

    .line 553
    invoke-virtual {v0, p1}, Landroid/widget/ViewAnimator;->addView(Landroid/view/View;)V

    .line 554
    invoke-virtual {v0}, Landroid/widget/ViewAnimator;->showNext()V

    .line 556
    invoke-direct {p0}, Lcom/amazon/mShop/AmazonActivity;->onTopmostViewChanged()V

    .line 558
    instance-of v1, p1, Lcom/amazon/mShop/DelayedInitView;

    if-eqz v1, :cond_2

    .line 559
    new-instance v2, Lcom/amazon/mShop/AmazonActivity$DelayedInitializer;

    move-object v1, p1

    check-cast v1, Lcom/amazon/mShop/DelayedInitView;

    invoke-direct {v2, p0, v1, v3}, Lcom/amazon/mShop/AmazonActivity$DelayedInitializer;-><init>(Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/mShop/DelayedInitView;Z)V

    .line 565
    :cond_1
    :goto_1
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/AmazonActivity;->onViewPushed(Landroid/view/View;)V

    goto :goto_0

    .line 561
    :cond_2
    instance-of v1, p1, Lcom/amazon/retailsearch/android/ui/DelayedInitView;

    if-eqz v1, :cond_1

    .line 562
    new-instance v2, Lcom/amazon/mShop/AmazonActivity$RetailSearchDelayedInitializer;

    move-object v1, p1

    check-cast v1, Lcom/amazon/retailsearch/android/ui/DelayedInitView;

    invoke-direct {v2, p0, v1, v3}, Lcom/amazon/mShop/AmazonActivity$RetailSearchDelayedInitializer;-><init>(Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/retailsearch/android/ui/DelayedInitView;Z)V

    goto :goto_1
.end method

.method public pushView(Landroid/view/View;Z)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;
    .param p2, "useAnimation"    # Z

    .prologue
    const/4 v0, 0x0

    .line 528
    if-eqz p2, :cond_0

    .line 529
    sget v0, Lcom/amazon/mShop/android/lib/R$anim;->transition_push_in:I

    sget v1, Lcom/amazon/mShop/android/lib/R$anim;->transition_push_out:I

    invoke-virtual {p0, p1, v0, v1}, Lcom/amazon/mShop/AmazonActivity;->pushView(Landroid/view/View;II)V

    .line 533
    :goto_0
    return-void

    .line 531
    :cond_0
    invoke-virtual {p0, p1, v0, v0}, Lcom/amazon/mShop/AmazonActivity;->pushView(Landroid/view/View;II)V

    goto :goto_0
.end method

.method public registerConfigChangedListener(Lcom/amazon/mShop/AmazonActivity$OnConfigurationChangedListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/amazon/mShop/AmazonActivity$OnConfigurationChangedListener;

    .prologue
    .line 1566
    if-eqz p1, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/AmazonActivity;->mConfigChangedListenerList:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 1567
    iget-object v0, p0, Lcom/amazon/mShop/AmazonActivity;->mConfigChangedListenerList:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 1569
    :cond_0
    return-void
.end method

.method public registerNewIntentListener(Lcom/amazon/mShop/AmazonActivity$NewIntentListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/amazon/mShop/AmazonActivity$NewIntentListener;

    .prologue
    .line 1603
    if-eqz p1, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/AmazonActivity;->mNewIntentListenerList:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 1604
    iget-object v0, p0, Lcom/amazon/mShop/AmazonActivity;->mNewIntentListenerList:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 1606
    :cond_0
    return-void
.end method

.method protected registerPushNotification()V
    .locals 5

    .prologue
    const/4 v2, 0x0

    .line 248
    invoke-static {}, Lcom/amazon/mShop/util/MShopPushNotificationUtils;->isPushNotificationAvailable()Z

    move-result v3

    if-eqz v3, :cond_3

    .line 249
    invoke-static {}, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->getInstance()Lcom/amazon/mShop/pushnotification/PushNotificationManager;

    move-result-object v0

    .line 250
    .local v0, "notificationManager":Lcom/amazon/mShop/pushnotification/PushNotificationManager;
    invoke-virtual {v0, v2}, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->getNewNotificationTarget(Ljava/lang/String;)Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;

    move-result-object v1

    .line 255
    .local v1, "notificationTarget":Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;
    if-eqz v1, :cond_0

    .line 256
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;->getDestination()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->updateDeviceToken(Ljava/lang/String;)V

    .line 262
    :cond_0
    invoke-static {}, Lcom/amazon/mShop/util/MShopPushNotificationUtils;->getLastMarketPlace()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_1

    invoke-static {}, Lcom/amazon/mShop/util/MShopPushNotificationUtils;->getLastMarketPlace()Ljava/lang/String;

    move-result-object v3

    invoke-static {}, Lcom/amazon/mShop/platform/AppLocale;->getInstance()Lcom/amazon/mShop/platform/AppLocale;

    move-result-object v4

    invoke-virtual {v4}, Lcom/amazon/mShop/platform/AppLocale;->getCurrentLocaleName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_3

    .line 264
    :cond_1
    if-eqz v1, :cond_2

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;->getDestination()Ljava/lang/String;

    move-result-object v2

    :cond_2
    invoke-virtual {v0, v2}, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->enableNotificationsForNewMarketplace(Ljava/lang/String;)V

    .line 267
    .end local v0    # "notificationManager":Lcom/amazon/mShop/pushnotification/PushNotificationManager;
    .end local v1    # "notificationTarget":Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;
    :cond_3
    return-void
.end method

.method public removeAllViews()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 756
    iget-object v0, p0, Lcom/amazon/mShop/AmazonActivity;->viewAnimator:Landroid/widget/ViewAnimator;

    if-eqz v0, :cond_0

    .line 758
    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonActivity;->closeSoftKeyboard()V

    .line 760
    iget-object v0, p0, Lcom/amazon/mShop/AmazonActivity;->viewAnimator:Landroid/widget/ViewAnimator;

    invoke-virtual {v0, v1}, Landroid/widget/ViewAnimator;->setInAnimation(Landroid/view/animation/Animation;)V

    .line 761
    iget-object v0, p0, Lcom/amazon/mShop/AmazonActivity;->viewAnimator:Landroid/widget/ViewAnimator;

    invoke-virtual {v0, v1}, Landroid/widget/ViewAnimator;->setOutAnimation(Landroid/view/animation/Animation;)V

    .line 762
    iget-object v0, p0, Lcom/amazon/mShop/AmazonActivity;->viewAnimator:Landroid/widget/ViewAnimator;

    invoke-virtual {v0}, Landroid/widget/ViewAnimator;->removeAllViews()V

    .line 764
    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonActivity;->getErrorHandler()Lcom/amazon/mShop/error/AmazonActivityErrorHandler;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/error/AmazonActivityErrorHandler;->removeAllErrors()V

    .line 765
    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonActivity;->dismissErrorBox()V

    .line 767
    :cond_0
    return-void
.end method

.method protected removeErrorBox(Landroid/view/View;)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 1376
    iget-object v0, p0, Lcom/amazon/mShop/AmazonActivity;->mActionBarSeparatorDecorator:Landroid/view/View;

    check-cast v0, Landroid/view/ViewGroup;

    invoke-virtual {v0, p1}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    .line 1377
    return-void
.end method

.method protected removeTemporaryBlankView()V
    .locals 2

    .prologue
    .line 1507
    iget-object v0, p0, Lcom/amazon/mShop/AmazonActivity;->mTemporaryBlankView:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 1508
    iget-object v0, p0, Lcom/amazon/mShop/AmazonActivity;->mTemporaryBlankView:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1}, Lcom/amazon/mShop/AmazonActivity;->removeView(Landroid/view/View;Z)Z

    .line 1509
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/mShop/AmazonActivity;->mTemporaryBlankView:Landroid/view/View;

    .line 1511
    :cond_0
    return-void
.end method

.method public removeView(Landroid/view/View;Z)Z
    .locals 6
    .param p1, "viewToRemove"    # Landroid/view/View;
    .param p2, "needAnimation"    # Z

    .prologue
    const/4 v5, 0x0

    const/4 v3, 0x0

    .line 700
    if-nez p1, :cond_1

    .line 730
    :cond_0
    :goto_0
    return v3

    .line 704
    :cond_1
    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonActivity;->closeSoftKeyboard()V

    .line 706
    if-nez p2, :cond_2

    .line 707
    iget-object v4, p0, Lcom/amazon/mShop/AmazonActivity;->viewAnimator:Landroid/widget/ViewAnimator;

    invoke-virtual {v4, v5}, Landroid/widget/ViewAnimator;->setInAnimation(Landroid/view/animation/Animation;)V

    .line 708
    iget-object v4, p0, Lcom/amazon/mShop/AmazonActivity;->viewAnimator:Landroid/widget/ViewAnimator;

    invoke-virtual {v4, v5}, Landroid/widget/ViewAnimator;->setOutAnimation(Landroid/view/animation/Animation;)V

    .line 710
    :cond_2
    iget-object v4, p0, Lcom/amazon/mShop/AmazonActivity;->viewAnimator:Landroid/widget/ViewAnimator;

    invoke-virtual {v4}, Landroid/widget/ViewAnimator;->getChildCount()I

    move-result v2

    .line 711
    .local v2, "viewCount":I
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_1
    if-ge v0, v2, :cond_0

    .line 712
    iget-object v4, p0, Lcom/amazon/mShop/AmazonActivity;->viewAnimator:Landroid/widget/ViewAnimator;

    invoke-virtual {v4, v0}, Landroid/widget/ViewAnimator;->getChildAt(I)Landroid/view/View;

    move-result-object v1

    .line 713
    .local v1, "view":Landroid/view/View;
    if-ne v1, p1, :cond_4

    .line 714
    iget-object v3, p0, Lcom/amazon/mShop/AmazonActivity;->viewAnimator:Landroid/widget/ViewAnimator;

    invoke-virtual {v3, v1}, Landroid/widget/ViewAnimator;->removeView(Landroid/view/View;)V

    .line 718
    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonActivity;->getErrorHandler()Lcom/amazon/mShop/error/AmazonActivityErrorHandler;

    move-result-object v3

    invoke-virtual {v3, v0}, Lcom/amazon/mShop/error/AmazonActivityErrorHandler;->removeErrorAt(I)V

    .line 720
    add-int/lit8 v3, v2, -0x1

    if-ne v0, v3, :cond_3

    .line 722
    invoke-direct {p0}, Lcom/amazon/mShop/AmazonActivity;->onTopmostViewChanged()V

    .line 723
    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonActivity;->getErrorHandler()Lcom/amazon/mShop/error/AmazonActivityErrorHandler;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/mShop/error/AmazonActivityErrorHandler;->onTopViewRemoved()V

    .line 726
    :cond_3
    const/4 v3, 0x1

    goto :goto_0

    .line 711
    :cond_4
    add-int/lit8 v0, v0, 0x1

    goto :goto_1
.end method

.method public reportErrorOnView(Lcom/amazon/mShop/error/AmazonErrorInfo;Lcom/amazon/mShop/error/AmazonErrorBox;Landroid/view/View;)V
    .locals 3
    .param p1, "errorInfo"    # Lcom/amazon/mShop/error/AmazonErrorInfo;
    .param p2, "errorBox"    # Lcom/amazon/mShop/error/AmazonErrorBox;
    .param p3, "reportOnView"    # Landroid/view/View;

    .prologue
    .line 1282
    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonActivity;->getViewAnimator()Landroid/widget/ViewAnimator;

    move-result-object v1

    invoke-static {v1, p3}, Lcom/amazon/mShop/util/UIUtils;->findViewIndex(Landroid/widget/ViewAnimator;Landroid/view/View;)I

    move-result v0

    .line 1283
    .local v0, "viewIndex":I
    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonActivity;->getErrorHandler()Lcom/amazon/mShop/error/AmazonActivityErrorHandler;

    move-result-object v1

    invoke-virtual {v1, p1, v0}, Lcom/amazon/mShop/error/AmazonActivityErrorHandler;->onErrorReportAt(Lcom/amazon/mShop/error/AmazonErrorInfo;I)V

    .line 1288
    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonActivity;->getViewAnimator()Landroid/widget/ViewAnimator;

    move-result-object v1

    invoke-virtual {v1}, Landroid/widget/ViewAnimator;->getChildCount()I

    move-result v1

    add-int/lit8 v1, v1, -0x1

    if-ne v0, v1, :cond_1

    if-ltz v0, :cond_1

    .line 1289
    iget-object v1, p0, Lcom/amazon/mShop/AmazonActivity;->mErrorBoxView:Lcom/amazon/mShop/error/AmazonErrorBox;

    if-eqz v1, :cond_0

    .line 1290
    iget-object v1, p0, Lcom/amazon/mShop/AmazonActivity;->mErrorBoxView:Lcom/amazon/mShop/error/AmazonErrorBox;

    invoke-virtual {p0, v1}, Lcom/amazon/mShop/AmazonActivity;->removeErrorBox(Landroid/view/View;)V

    .line 1291
    const/4 v1, 0x0

    iput-object v1, p0, Lcom/amazon/mShop/AmazonActivity;->mErrorBoxView:Lcom/amazon/mShop/error/AmazonErrorBox;

    .line 1294
    :cond_0
    if-eqz p2, :cond_1

    .line 1295
    iput-object p2, p0, Lcom/amazon/mShop/AmazonActivity;->mErrorBoxView:Lcom/amazon/mShop/error/AmazonErrorBox;

    .line 1296
    iget-object v1, p0, Lcom/amazon/mShop/AmazonActivity;->mErrorBoxView:Lcom/amazon/mShop/error/AmazonErrorBox;

    invoke-virtual {p0, v1}, Lcom/amazon/mShop/AmazonActivity;->insertErrorBox(Landroid/view/View;)V

    .line 1297
    iget-object v1, p0, Lcom/amazon/mShop/AmazonActivity;->mErrorBoxView:Lcom/amazon/mShop/error/AmazonErrorBox;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/error/AmazonErrorBox;->setVisibility(I)V

    .line 1298
    iget-object v1, p0, Lcom/amazon/mShop/AmazonActivity;->mErrorBoxView:Lcom/amazon/mShop/error/AmazonErrorBox;

    invoke-virtual {p0, v1}, Lcom/amazon/mShop/AmazonActivity;->registerConfigChangedListener(Lcom/amazon/mShop/AmazonActivity$OnConfigurationChangedListener;)V

    .line 1301
    :cond_1
    return-void
.end method

.method protected resumeTimersIfNeeded()V
    .locals 1

    .prologue
    .line 1515
    invoke-static {}, Lcom/amazon/mShop/AmazonApplication;->isWebViewCacheEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    .line 1516
    sget-object v0, Lcom/amazon/mShop/AmazonActivity;->sWebViewInst:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->resumeTimers()V

    .line 1518
    :cond_0
    return-void
.end method

.method public setActionBarAndSeparatorDecoratorVisibility(I)V
    .locals 5
    .param p1, "visiblity"    # I

    .prologue
    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 1839
    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonActivity;->getContentView()Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/view/ViewGroup;

    .line 1840
    .local v1, "contentView":Landroid/view/ViewGroup;
    iget-object v0, p0, Lcom/amazon/mShop/AmazonActivity;->mActionBarSeparatorDecorator:Landroid/view/View;

    check-cast v0, Landroid/view/ViewGroup;

    .line 1841
    .local v0, "actionBarSeparatorDecorator":Landroid/view/ViewGroup;
    if-eqz v1, :cond_1

    if-eqz v0, :cond_1

    .line 1842
    invoke-virtual {v0}, Landroid/view/ViewGroup;->getChildCount()I

    move-result v2

    if-le v2, v4, :cond_0

    .line 1843
    invoke-virtual {v0, v3}, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    invoke-virtual {v2, p1}, Landroid/view/View;->setVisibility(I)V

    .line 1846
    :cond_0
    invoke-virtual {v1}, Landroid/view/ViewGroup;->getChildCount()I

    move-result v2

    if-le v2, v4, :cond_1

    .line 1847
    invoke-virtual {v1, v3}, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    invoke-virtual {v2, p1}, Landroid/view/View;->setVisibility(I)V

    .line 1850
    :cond_1
    return-void
.end method

.method public setClickStreamOrigin(Ljava/lang/String;)V
    .locals 0
    .param p1, "clickStream"    # Ljava/lang/String;

    .prologue
    .line 369
    iput-object p1, p0, Lcom/amazon/mShop/AmazonActivity;->mClickStreamOrigin:Ljava/lang/String;

    .line 370
    return-void
.end method

.method public final setContentView(I)V
    .locals 0
    .param p1, "layoutResID"    # I
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 457
    invoke-super {p0, p1}, Lcom/amazon/mShop/startup/BaseActivity;->setContentView(I)V

    .line 458
    return-void
.end method

.method public final setContentView(Landroid/view/View;)V
    .locals 0
    .param p1, "view"    # Landroid/view/View;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 467
    invoke-super {p0, p1}, Lcom/amazon/mShop/startup/BaseActivity;->setContentView(Landroid/view/View;)V

    .line 468
    return-void
.end method

.method public final setContentView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    .locals 0
    .param p1, "view"    # Landroid/view/View;
    .param p2, "params"    # Landroid/view/ViewGroup$LayoutParams;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 447
    invoke-super {p0, p1, p2}, Lcom/amazon/mShop/startup/BaseActivity;->setContentView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 448
    return-void
.end method

.method protected setKeepTopActivityFlag()V
    .locals 1

    .prologue
    .line 1812
    const/4 v0, 0x1

    sput-boolean v0, Lcom/amazon/mShop/AmazonActivity;->sKeepTopActivity:Z

    .line 1813
    return-void
.end method

.method public setRootView(Landroid/view/View;)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 780
    const/4 v0, 0x1

    invoke-virtual {p0, p1, v0}, Lcom/amazon/mShop/AmazonActivity;->setRootView(Landroid/view/View;Z)V

    .line 781
    return-void
.end method

.method public setRootView(Landroid/view/View;Z)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;
    .param p2, "needWrapped"    # Z

    .prologue
    .line 784
    const/4 v0, 0x1

    invoke-virtual {p0, p1, p2, v0}, Lcom/amazon/mShop/AmazonActivity;->setRootView(Landroid/view/View;ZZ)V

    .line 785
    return-void
.end method

.method public setRootView(Landroid/view/View;ZII)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;
    .param p2, "needWrapped"    # Z
    .param p3, "inId"    # I
    .param p4, "outId"    # I

    .prologue
    .line 826
    iget-object v0, p0, Lcom/amazon/mShop/AmazonActivity;->viewAnimator:Landroid/widget/ViewAnimator;

    if-nez v0, :cond_1

    .line 827
    invoke-direct {p0, p2}, Lcom/amazon/mShop/AmazonActivity;->getViewAnimator(Z)Landroid/widget/ViewAnimator;

    .line 834
    :goto_0
    iget-object v0, p0, Lcom/amazon/mShop/AmazonActivity;->viewAnimator:Landroid/widget/ViewAnimator;

    iget-object v1, p0, Lcom/amazon/mShop/AmazonActivity;->pushInAnimationListener:Landroid/view/animation/Animation$AnimationListener;

    invoke-direct {p0, p3, v1}, Lcom/amazon/mShop/AmazonActivity;->getAnimation(ILandroid/view/animation/Animation$AnimationListener;)Landroid/view/animation/Animation;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ViewAnimator;->setInAnimation(Landroid/view/animation/Animation;)V

    .line 835
    iget-object v0, p0, Lcom/amazon/mShop/AmazonActivity;->viewAnimator:Landroid/widget/ViewAnimator;

    invoke-direct {p0, p4}, Lcom/amazon/mShop/AmazonActivity;->getAnimation(I)Landroid/view/animation/Animation;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ViewAnimator;->setOutAnimation(Landroid/view/animation/Animation;)V

    .line 836
    iget-object v0, p0, Lcom/amazon/mShop/AmazonActivity;->viewAnimator:Landroid/widget/ViewAnimator;

    invoke-virtual {v0, p1}, Landroid/widget/ViewAnimator;->addView(Landroid/view/View;)V

    .line 837
    iget-object v0, p0, Lcom/amazon/mShop/AmazonActivity;->viewAnimator:Landroid/widget/ViewAnimator;

    invoke-virtual {v0}, Landroid/widget/ViewAnimator;->showNext()V

    .line 839
    invoke-direct {p0}, Lcom/amazon/mShop/AmazonActivity;->onTopmostViewChanged()V

    .line 840
    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonActivity;->getErrorHandler()Lcom/amazon/mShop/error/AmazonActivityErrorHandler;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/error/AmazonActivityErrorHandler;->removeAllErrors()V

    .line 841
    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonActivity;->getErrorHandler()Lcom/amazon/mShop/error/AmazonActivityErrorHandler;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/error/AmazonActivityErrorHandler;->setCurrentErrorInfo(Lcom/amazon/mShop/error/AmazonErrorInfo;)V

    .line 843
    instance-of v0, p1, Lcom/amazon/mShop/DelayedInitView;

    if-eqz v0, :cond_0

    .line 844
    new-instance v0, Lcom/amazon/mShop/AmazonActivity$DelayedInitializer;

    check-cast p1, Lcom/amazon/mShop/DelayedInitView;

    .end local p1    # "view":Landroid/view/View;
    const/4 v1, 0x0

    invoke-direct {v0, p0, p1, v1}, Lcom/amazon/mShop/AmazonActivity$DelayedInitializer;-><init>(Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/mShop/DelayedInitView;Z)V

    .line 846
    :cond_0
    return-void

    .line 829
    .restart local p1    # "view":Landroid/view/View;
    :cond_1
    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonActivity;->closeSoftKeyboard()V

    .line 830
    iget-object v0, p0, Lcom/amazon/mShop/AmazonActivity;->viewAnimator:Landroid/widget/ViewAnimator;

    invoke-virtual {v0}, Landroid/widget/ViewAnimator;->removeAllViews()V

    goto :goto_0
.end method

.method public setRootView(Landroid/view/View;ZZ)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;
    .param p2, "needWrapped"    # Z
    .param p3, "useAnimation"    # Z

    .prologue
    const/4 v0, 0x0

    .line 802
    if-eqz p3, :cond_0

    .line 803
    sget v0, Lcom/amazon/mShop/android/lib/R$anim;->transition_push_in:I

    sget v1, Lcom/amazon/mShop/android/lib/R$anim;->transition_push_out:I

    invoke-virtual {p0, p1, p2, v0, v1}, Lcom/amazon/mShop/AmazonActivity;->setRootView(Landroid/view/View;ZII)V

    .line 807
    :goto_0
    return-void

    .line 805
    :cond_0
    invoke-virtual {p0, p1, p2, v0, v0}, Lcom/amazon/mShop/AmazonActivity;->setRootView(Landroid/view/View;ZII)V

    goto :goto_0
.end method

.method public setSkipStopBehavior(Z)V
    .locals 0
    .param p1, "skipStopBehavior"    # Z

    .prologue
    .line 365
    iput-boolean p1, p0, Lcom/amazon/mShop/AmazonActivity;->skipStopBehavior:Z

    .line 366
    return-void
.end method

.method public setStopBehavior(I)V
    .locals 0
    .param p1, "_stopBehavior"    # I

    .prologue
    .line 356
    iput p1, p0, Lcom/amazon/mShop/AmazonActivity;->stopBehavior:I

    .line 357
    return-void
.end method

.method protected setViewAnimator(Landroid/widget/ViewAnimator;)V
    .locals 0
    .param p1, "viewAnimator"    # Landroid/widget/ViewAnimator;

    .prologue
    .line 1022
    iput-object p1, p0, Lcom/amazon/mShop/AmazonActivity;->viewAnimator:Landroid/widget/ViewAnimator;

    .line 1023
    if-eqz p1, :cond_0

    .line 1024
    invoke-super {p0, p1}, Lcom/amazon/mShop/startup/BaseActivity;->setContentView(Landroid/view/View;)V

    .line 1026
    :cond_0
    return-void
.end method

.method protected setWrappedViewAnimator(Landroid/view/View;)Landroid/view/View;
    .locals 1
    .param p1, "wrappedViewAnimator"    # Landroid/view/View;

    .prologue
    .line 1014
    iget-object v0, p0, Lcom/amazon/mShop/AmazonActivity;->mGNODrawer:Lcom/amazon/mShop/gno/GNODrawer;

    invoke-virtual {v0, p1}, Lcom/amazon/mShop/gno/GNODrawer;->applyGNODrawer(Landroid/view/View;)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method protected setupCustomizedActionbar(Landroid/widget/ViewAnimator;)Landroid/view/View;
    .locals 1
    .param p1, "orignalViewAnimator"    # Landroid/widget/ViewAnimator;

    .prologue
    .line 1008
    invoke-static {p0, p1}, Lcom/amazon/mShop/actionBar/ActionBarHelper;->applyActionBarSeparator(Lcom/amazon/mShop/AmazonActivity;Landroid/view/View;)Landroid/view/View;

    move-result-object v0

    .line 1009
    .local v0, "wrappedViewAnimator":Landroid/view/View;
    return-object v0
.end method

.method public skipNextStopBehavior()V
    .locals 1

    .prologue
    .line 360
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/mShop/AmazonActivity;->skipStopBehavior:Z

    .line 361
    return-void
.end method

.method public startActivity(Landroid/content/Intent;)V
    .locals 6
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 1728
    move-object v2, p1

    .line 1729
    .local v2, "newIntent":Landroid/content/Intent;
    const-string/jumbo v3, "activity_start_time"

    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v4

    invoke-virtual {p1, v3, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;J)Landroid/content/Intent;

    .line 1730
    const-string/jumbo v3, "android.intent.action.CHOOSER"

    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 1731
    invoke-static {p0, p1}, Lcom/amazon/mShop/AmazonChooserActivity;->getIntentToStart(Landroid/content/Context;Landroid/content/Intent;)Landroid/content/Intent;

    move-result-object v2

    .line 1743
    :cond_0
    :goto_0
    invoke-super {p0, v2}, Lcom/amazon/mShop/startup/BaseActivity;->startActivity(Landroid/content/Intent;)V

    .line 1744
    return-void

    .line 1732
    :cond_1
    const-string/jumbo v3, "android.intent.action.DIAL"

    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 1735
    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v1

    .line 1736
    .local v1, "manager":Landroid/content/pm/PackageManager;
    const/high16 v3, 0x10000

    invoke-virtual {v1, p1, v3}, Landroid/content/pm/PackageManager;->queryIntentActivities(Landroid/content/Intent;I)Ljava/util/List;

    move-result-object v0

    .line 1737
    .local v0, "activities":Ljava/util/List;, "Ljava/util/List<Landroid/content/pm/ResolveInfo;>;"
    if-eqz v0, :cond_0

    .line 1738
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v3

    const/4 v4, 0x1

    if-le v3, v4, :cond_0

    .line 1739
    invoke-static {p0, p1}, Lcom/amazon/mShop/AmazonChooserActivity;->getIntentToStart(Landroid/content/Context;Landroid/content/Intent;)Landroid/content/Intent;

    move-result-object v2

    goto :goto_0
.end method

.method public swapView(Landroid/view/View;)V
    .locals 3
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 578
    iget-boolean v2, p0, Lcom/amazon/mShop/AmazonActivity;->pushAnimationInProgress:Z

    if-eqz v2, :cond_0

    .line 588
    :goto_0
    return-void

    .line 581
    :cond_0
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/AmazonActivity;->pushView(Landroid/view/View;)V

    .line 582
    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonActivity;->getViewAnimator()Landroid/widget/ViewAnimator;

    move-result-object v1

    .line 583
    .local v1, "va":Landroid/widget/ViewAnimator;
    invoke-virtual {v1}, Landroid/widget/ViewAnimator;->getChildCount()I

    move-result v0

    .line 584
    .local v0, "count":I
    const/4 v2, 0x1

    if-ge v2, v0, :cond_1

    .line 585
    add-int/lit8 v2, v0, -0x2

    invoke-virtual {v1, v2}, Landroid/widget/ViewAnimator;->removeViewAt(I)V

    .line 587
    :cond_1
    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonActivity;->getErrorHandler()Lcom/amazon/mShop/error/AmazonActivityErrorHandler;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/error/AmazonActivityErrorHandler;->onViewSwapped()V

    goto :goto_0
.end method

.method public unregisterConfigChangedListener(Lcom/amazon/mShop/AmazonActivity$OnConfigurationChangedListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/amazon/mShop/AmazonActivity$OnConfigurationChangedListener;

    .prologue
    .line 1572
    if-eqz p1, :cond_0

    .line 1573
    iget-object v0, p0, Lcom/amazon/mShop/AmazonActivity;->mConfigChangedListenerList:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    .line 1575
    :cond_0
    return-void
.end method

.method public unregisterNewIntentListener(Lcom/amazon/mShop/AmazonActivity$NewIntentListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/amazon/mShop/AmazonActivity$NewIntentListener;

    .prologue
    .line 1609
    if-eqz p1, :cond_0

    .line 1610
    iget-object v0, p0, Lcom/amazon/mShop/AmazonActivity;->mNewIntentListenerList:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    .line 1612
    :cond_0
    return-void
.end method

.method protected updateGNOMenuItems()V
    .locals 2

    .prologue
    .line 1521
    iget-object v0, p0, Lcom/amazon/mShop/AmazonActivity;->mGNODrawer:Lcom/amazon/mShop/gno/GNODrawer;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/gno/GNODrawer;->updateMenuItems(Z)V

    .line 1522
    return-void
.end method

.method public updateTitle(Landroid/view/View;)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 871
    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonActivity;->getCurrentView()Landroid/view/View;

    move-result-object v0

    if-ne p1, v0, :cond_0

    .line 872
    invoke-direct {p0, p1}, Lcom/amazon/mShop/AmazonActivity;->applyTitle(Landroid/view/View;)V

    .line 874
    :cond_0
    return-void
.end method

.method public userCancelledSignIn()V
    .locals 1

    .prologue
    .line 1698
    iget-object v0, p0, Lcom/amazon/mShop/AmazonActivity;->primaryUserSubscriberCallback:Lcom/amazon/mShop/model/auth/UserSubscriber$Callback;

    if-eqz v0, :cond_0

    .line 1699
    iget-object v0, p0, Lcom/amazon/mShop/AmazonActivity;->primaryUserSubscriberCallback:Lcom/amazon/mShop/model/auth/UserSubscriber$Callback;

    invoke-interface {v0}, Lcom/amazon/mShop/model/auth/UserSubscriber$Callback;->userCancelledSignIn()V

    .line 1701
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/AmazonActivity;->secondaryUserSubscriberCallback:Lcom/amazon/mShop/model/auth/UserSubscriber$Callback;

    if-eqz v0, :cond_1

    .line 1702
    iget-object v0, p0, Lcom/amazon/mShop/AmazonActivity;->secondaryUserSubscriberCallback:Lcom/amazon/mShop/model/auth/UserSubscriber$Callback;

    invoke-interface {v0}, Lcom/amazon/mShop/model/auth/UserSubscriber$Callback;->userCancelledSignIn()V

    .line 1704
    :cond_1
    return-void
.end method

.method public userSuccessfullySignedIn()V
    .locals 1

    .prologue
    .line 1688
    iget-object v0, p0, Lcom/amazon/mShop/AmazonActivity;->primaryUserSubscriberCallback:Lcom/amazon/mShop/model/auth/UserSubscriber$Callback;

    if-eqz v0, :cond_0

    .line 1689
    iget-object v0, p0, Lcom/amazon/mShop/AmazonActivity;->primaryUserSubscriberCallback:Lcom/amazon/mShop/model/auth/UserSubscriber$Callback;

    invoke-interface {v0}, Lcom/amazon/mShop/model/auth/UserSubscriber$Callback;->userSuccessfullySignedIn()V

    .line 1691
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/AmazonActivity;->secondaryUserSubscriberCallback:Lcom/amazon/mShop/model/auth/UserSubscriber$Callback;

    if-eqz v0, :cond_1

    .line 1692
    iget-object v0, p0, Lcom/amazon/mShop/AmazonActivity;->secondaryUserSubscriberCallback:Lcom/amazon/mShop/model/auth/UserSubscriber$Callback;

    invoke-interface {v0}, Lcom/amazon/mShop/model/auth/UserSubscriber$Callback;->userSuccessfullySignedIn()V

    .line 1694
    :cond_1
    return-void
.end method
