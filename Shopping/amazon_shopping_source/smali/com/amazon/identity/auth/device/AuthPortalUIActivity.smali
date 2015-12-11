.class public Lcom/amazon/identity/auth/device/AuthPortalUIActivity;
.super Landroid/app/Activity;
.source "AuthPortalUIActivity.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/identity/auth/device/AuthPortalUIActivity$7;,
        Lcom/amazon/identity/auth/device/AuthPortalUIActivity$TimeoutTimerTask;,
        Lcom/amazon/identity/auth/device/AuthPortalUIActivity$AuthPortalUIActivityOptions;
    }
.end annotation


# static fields
.field public static final EMPTY_SID_COOKIE_VALUE_METRIC_NAME:Ljava/lang/String; = "EmptySidCookieValue"

.field public static final KEY_IS_WARM_SEAT_AUTHENTICATION:Ljava/lang/String; = "isWarmSeatAuthentication"

.field public static final MFA_SID_COOKIE_NAME:Ljava/lang/String; = "sid"

.field private static final TAG:Ljava/lang/String;


# instance fields
.field private mAmazonAccountManager:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

.field private mAuthenticationWebViewClient:Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;

.field private mBackPressedTimer:Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

.field private mBackwardsCompatiableDataStorage:Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;

.field private mBarFade:Z

.field private mBarFaded:Z

.field private mBarOn:Z

.field private mContext:Landroid/content/Context;

.field private mCookieUrl:Ljava/lang/String;

.field private mDcqChallengeQuestionEnterTimer:Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

.field private mDismissSpinnerEarly:Z

.field private mFirstOnPageStartedTimer:Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

.field private mFirstPageLoadTimer:Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

.field private mIsRegistrationInFlight:Ljava/util/concurrent/atomic/AtomicBoolean;

.field private mMapAccountManager:Lcom/amazon/identity/auth/device/api/MAPAccountManager;

.field private mMfaChallengeCodeEnterTimer:Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

.field private mOptions:Landroid/os/Bundle;

.field private mPageLoadToFirstRenderTimer:Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

.field private mPlatform:Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

.field private mProgressbarId:I

.field private mRequestTimeoutTimer:Ljava/util/Timer;

.field private mResponse:Lcom/amazon/identity/auth/device/callback/RemoteCallbackWrapper;

.field private mTimeoutMetricsName:Ljava/lang/String;

.field private mTracer:Lcom/amazon/identity/auth/device/framework/Tracer;

.field private mUrlHost:Ljava/lang/String;

.field private mWebView:Lcom/amazon/android/webkit/AmazonWebView;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 111
    const-class v0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v0, 0x0

    .line 83
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    .line 132
    iput-object v0, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mFirstOnPageStartedTimer:Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    .line 134
    iput-object v0, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mFirstPageLoadTimer:Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    .line 136
    iput-object v0, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mPageLoadToFirstRenderTimer:Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    .line 138
    iput-object v0, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mBackPressedTimer:Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    .line 171
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mDismissSpinnerEarly:Z

    .line 179
    new-instance v0, Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>(Z)V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mIsRegistrationInFlight:Ljava/util/concurrent/atomic/AtomicBoolean;

    .line 181
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/identity/auth/device/AuthPortalUIActivity;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/AuthPortalUIActivity;

    .prologue
    .line 83
    iget-object v0, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mTimeoutMetricsName:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$002(Lcom/amazon/identity/auth/device/AuthPortalUIActivity;Ljava/lang/String;)Ljava/lang/String;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/AuthPortalUIActivity;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 83
    iput-object p1, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mTimeoutMetricsName:Ljava/lang/String;

    return-object p1
.end method

.method static synthetic access$100(Lcom/amazon/identity/auth/device/AuthPortalUIActivity;)Landroid/content/Context;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/AuthPortalUIActivity;

    .prologue
    .line 83
    iget-object v0, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mContext:Landroid/content/Context;

    return-object v0
.end method

.method static synthetic access$1000(Lcom/amazon/identity/auth/device/AuthPortalUIActivity;)Ljava/util/Timer;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/AuthPortalUIActivity;

    .prologue
    .line 83
    iget-object v0, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mRequestTimeoutTimer:Ljava/util/Timer;

    return-object v0
.end method

.method static synthetic access$1002(Lcom/amazon/identity/auth/device/AuthPortalUIActivity;Ljava/util/Timer;)Ljava/util/Timer;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/AuthPortalUIActivity;
    .param p1, "x1"    # Ljava/util/Timer;

    .prologue
    .line 83
    iput-object p1, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mRequestTimeoutTimer:Ljava/util/Timer;

    return-object p1
.end method

.method static synthetic access$1200(Lcom/amazon/identity/auth/device/AuthPortalUIActivity;)V
    .locals 2
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/AuthPortalUIActivity;

    .prologue
    const/4 v1, 0x0

    .line 83
    iput-boolean v1, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mBarFaded:Z

    iget-boolean v0, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mBarOn:Z

    if-eqz v0, :cond_0

    iget v0, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mProgressbarId:I

    invoke-virtual {p0, v0}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ProgressBar;

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setProgress(I)V

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setVisibility(I)V

    :cond_0
    return-void
.end method

.method static synthetic access$1300(Lcom/amazon/identity/auth/device/AuthPortalUIActivity;)Lcom/amazon/android/webkit/AmazonWebView;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/AuthPortalUIActivity;

    .prologue
    .line 83
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->getWebView()Lcom/amazon/android/webkit/AmazonWebView;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$1400(Lcom/amazon/identity/auth/device/AuthPortalUIActivity;I)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/AuthPortalUIActivity;
    .param p1, "x1"    # I

    .prologue
    .line 83
    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->setProgressBarProgress(I)V

    return-void
.end method

.method static synthetic access$1500(Lcom/amazon/identity/auth/device/AuthPortalUIActivity;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/AuthPortalUIActivity;

    .prologue
    .line 83
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->hideProgressBar()V

    return-void
.end method

.method static synthetic access$1600(Lcom/amazon/identity/auth/device/AuthPortalUIActivity;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/AuthPortalUIActivity;

    .prologue
    .line 83
    iget-object v0, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mPageLoadToFirstRenderTimer:Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    return-object v0
.end method

.method static synthetic access$1700(Lcom/amazon/identity/auth/device/AuthPortalUIActivity;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/AuthPortalUIActivity;

    .prologue
    .line 83
    iget-object v0, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mFirstPageLoadTimer:Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    return-object v0
.end method

.method static synthetic access$1800()Ljava/lang/String;
    .locals 1

    .prologue
    .line 83
    sget-object v0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->TAG:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$1900(Lcom/amazon/identity/auth/device/AuthPortalUIActivity;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/AuthPortalUIActivity;

    .prologue
    .line 83
    iget-object v0, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mMfaChallengeCodeEnterTimer:Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    return-object v0
.end method

.method static synthetic access$1902(Lcom/amazon/identity/auth/device/AuthPortalUIActivity;Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/AuthPortalUIActivity;
    .param p1, "x1"    # Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    .prologue
    .line 83
    iput-object p1, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mMfaChallengeCodeEnterTimer:Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    return-object p1
.end method

.method static synthetic access$200(Lcom/amazon/identity/auth/device/AuthPortalUIActivity;)Lcom/amazon/identity/auth/device/framework/Tracer;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/AuthPortalUIActivity;

    .prologue
    .line 83
    iget-object v0, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mTracer:Lcom/amazon/identity/auth/device/framework/Tracer;

    return-object v0
.end method

.method static synthetic access$2000(Lcom/amazon/identity/auth/device/AuthPortalUIActivity;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/AuthPortalUIActivity;

    .prologue
    .line 83
    iget-object v0, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mDcqChallengeQuestionEnterTimer:Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    return-object v0
.end method

.method static synthetic access$2002(Lcom/amazon/identity/auth/device/AuthPortalUIActivity;Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/AuthPortalUIActivity;
    .param p1, "x1"    # Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    .prologue
    .line 83
    iput-object p1, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mDcqChallengeQuestionEnterTimer:Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    return-object p1
.end method

.method static synthetic access$2100(Lcom/amazon/identity/auth/device/AuthPortalUIActivity;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/AuthPortalUIActivity;

    .prologue
    .line 83
    iget-object v0, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mUrlHost:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$2200(Lcom/amazon/identity/auth/device/AuthPortalUIActivity;)Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/AuthPortalUIActivity;

    .prologue
    .line 83
    iget-object v0, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mBackwardsCompatiableDataStorage:Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;

    return-object v0
.end method

.method static synthetic access$2300(Lcom/amazon/identity/auth/device/AuthPortalUIActivity;Landroid/os/Bundle;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/AuthPortalUIActivity;
    .param p1, "x1"    # Landroid/os/Bundle;

    .prologue
    .line 83
    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->returnSuccess(Landroid/os/Bundle;)V

    return-void
.end method

.method static synthetic access$2400(Lcom/amazon/identity/auth/device/AuthPortalUIActivity;)I
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/AuthPortalUIActivity;

    .prologue
    .line 83
    iget v0, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mProgressbarId:I

    return v0
.end method

.method static synthetic access$2500(Lcom/amazon/identity/auth/device/AuthPortalUIActivity;)Lcom/amazon/identity/auth/device/callback/RemoteCallbackWrapper;
    .locals 2
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/AuthPortalUIActivity;

    .prologue
    .line 83
    iget-object v0, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mResponse:Lcom/amazon/identity/auth/device/callback/RemoteCallbackWrapper;

    const/4 v1, 0x0

    iput-object v1, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mResponse:Lcom/amazon/identity/auth/device/callback/RemoteCallbackWrapper;

    return-object v0
.end method

.method static synthetic access$2600(Lcom/amazon/identity/auth/device/AuthPortalUIActivity;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/AuthPortalUIActivity;

    .prologue
    .line 83
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->closeActivity()V

    return-void
.end method

.method static synthetic access$300(Lcom/amazon/identity/auth/device/AuthPortalUIActivity;Landroid/os/Bundle;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/AuthPortalUIActivity;
    .param p1, "x1"    # Landroid/os/Bundle;

    .prologue
    .line 83
    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->finishOnError(Landroid/os/Bundle;)V

    return-void
.end method

.method static synthetic access$400(Lcom/amazon/identity/auth/device/AuthPortalUIActivity;Lcom/amazon/android/webkit/AmazonWebView;I)V
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/AuthPortalUIActivity;
    .param p1, "x1"    # Lcom/amazon/android/webkit/AmazonWebView;
    .param p2, "x2"    # I

    .prologue
    .line 83
    const/16 v0, 0x3c

    if-le p2, v0, :cond_1

    if-eqz p1, :cond_1

    invoke-virtual {p1}, Lcom/amazon/android/webkit/AmazonWebView;->getContentHeight()I

    move-result v0

    if-lez v0, :cond_1

    iget-boolean v0, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mDismissSpinnerEarly:Z

    if-eqz v0, :cond_1

    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mDismissSpinnerEarly:Z

    const/16 v0, 0x64

    invoke-direct {p0, v0}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->setProgressBarProgress(I)V

    invoke-direct {p0}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->hideProgressBar()V

    iget-object v0, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mPageLoadToFirstRenderTimer:Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mPageLoadToFirstRenderTimer:Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    invoke-virtual {v0}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->stopAndDiscard()V

    :cond_0
    :goto_0
    return-void

    :cond_1
    invoke-direct {p0, p2}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->setProgressBarProgress(I)V

    goto :goto_0
.end method

.method static synthetic access$500(Lcom/amazon/identity/auth/device/AuthPortalUIActivity;Lcom/amazon/identity/auth/device/endpoint/OpenIdResponse;)V
    .locals 6
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/AuthPortalUIActivity;
    .param p1, "x1"    # Lcom/amazon/identity/auth/device/endpoint/OpenIdResponse;

    .prologue
    const/4 v5, 0x0

    const/4 v0, 0x0

    .line 83
    iget-object v1, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mIsRegistrationInFlight:Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Ljava/util/concurrent/atomic/AtomicBoolean;->getAndSet(Z)Z

    move-result v1

    if-eqz v1, :cond_0

    sget-object v0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->TAG:Ljava/lang/String;

    :goto_0
    return-void

    :cond_0
    new-instance v1, Ljava/lang/StringBuilder;

    const-string/jumbo v2, "WebViewSuccess:"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-direct {p0}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->getRequestTypeFromIntent()Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;->name()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-array v2, v5, [Ljava/lang/String;

    invoke-static {v1, v2}, Lcom/amazon/identity/platform/metric/MetricsHelper;->increasePeriodicCounter(Ljava/lang/String;[Ljava/lang/String;)V

    invoke-virtual {p1}, Lcom/amazon/identity/auth/device/endpoint/OpenIdResponse;->getDirectedId()Ljava/lang/String;

    move-result-object v2

    iget-object v1, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mCookieUrl:Ljava/lang/String;

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_1

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_4

    :cond_1
    :goto_1
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->getRequestTypeFromIntent()Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;

    move-result-object v1

    sget-object v3, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;->CONFIRM_CREDENTIAL:Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;

    invoke-virtual {v1, v3}, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_2

    invoke-direct {p0}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->getRequestTypeFromIntent()Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;

    move-result-object v1

    sget-object v3, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;->AUTHENTICATE:Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;

    invoke-virtual {v1, v3}, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_6

    :cond_2
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_3

    iget-object v1, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mBackwardsCompatiableDataStorage:Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;

    const-string/jumbo v3, "com.amazon.dcp.sso.token.cookie.sid"

    invoke-virtual {v1, v2, v3, v0}, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;->setToken(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    :cond_3
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    const-string/jumbo v1, "com.amazon.dcp.sso.property.account.acctId"

    invoke-virtual {p1}, Lcom/amazon/identity/auth/device/endpoint/OpenIdResponse;->getDirectedId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    const-string/jumbo v1, "com.amazon.dcp.sso.AddAccount.options.AccessToken"

    invoke-virtual {p1}, Lcom/amazon/identity/auth/device/endpoint/OpenIdResponse;->getAccessToken()Lcom/amazon/identity/auth/device/token/AccessToken;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/token/AccessToken;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    invoke-direct {p0, v0}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->returnSuccess(Landroid/os/Bundle;)V

    goto :goto_0

    :cond_4
    iget-object v3, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mContext:Landroid/content/Context;

    const-string/jumbo v4, "sid"

    invoke-static {v3, v2, v1, v4}, Lcom/amazon/identity/auth/device/utils/AmazonWebviewCookieUtils;->getCookieFromCookieManager(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/apache/http/cookie/Cookie;

    move-result-object v1

    if-eqz v1, :cond_1

    invoke-interface {v1}, Lorg/apache/http/cookie/Cookie;->getValue()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_5

    sget-object v1, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "sid cookie returned from Authportal but the value was empty. This should not happen, please open a contact with the MAP team. ref: SIM MFASettings-51"

    invoke-static {v1, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    const-string/jumbo v1, "EmptySidCookieValue:InsideCookieFromCookieManager"

    new-array v3, v5, [Ljava/lang/String;

    invoke-static {v1, v3}, Lcom/amazon/identity/platform/metric/MetricsHelper;->increasePeriodicCounter(Ljava/lang/String;[Ljava/lang/String;)V

    goto :goto_1

    :cond_5
    move-object v0, v1

    goto :goto_1

    :cond_6
    iget-object v1, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mOptions:Landroid/os/Bundle;

    if-eqz v1, :cond_7

    iget-object v1, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mOptions:Landroid/os/Bundle;

    :goto_2
    const-string/jumbo v3, "com.amazon.dcp.sso.AddAccount.options.AccessToken"

    invoke-virtual {p1}, Lcom/amazon/identity/auth/device/endpoint/OpenIdResponse;->getAccessToken()Lcom/amazon/identity/auth/device/token/AccessToken;

    move-result-object v4

    invoke-virtual {v4}, Lcom/amazon/identity/auth/device/token/AccessToken;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v3, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mAmazonAccountManager:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    invoke-virtual {v3, v2}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->doesAccountExistAfterDeregisteringStateCleanup(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_8

    sget-object v0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Fast failing since account already exists"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    sget-object v0, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->ACCOUNT_ALREADY_EXISTS:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->value()I

    move-result v0

    const-string/jumbo v1, "Account already exists"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/accounts/AccountsCallbackHelpers;->getErrorBundle(ILjava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->finishOnError(Landroid/os/Bundle;)V

    goto/16 :goto_0

    :cond_7
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    goto :goto_2

    :cond_8
    iget-object v2, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mMapAccountManager:Lcom/amazon/identity/auth/device/api/MAPAccountManager;

    sget-object v3, Lcom/amazon/identity/auth/device/api/RegistrationType;->FROM_ACCESS_TOKEN:Lcom/amazon/identity/auth/device/api/RegistrationType;

    new-instance v4, Lcom/amazon/identity/auth/device/AuthPortalUIActivity$3;

    invoke-direct {v4, p0, v0, p1}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity$3;-><init>(Lcom/amazon/identity/auth/device/AuthPortalUIActivity;Ljava/lang/String;Lcom/amazon/identity/auth/device/endpoint/OpenIdResponse;)V

    invoke-virtual {v2, v3, v1, v4}, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->registerAccount(Lcom/amazon/identity/auth/device/api/RegistrationType;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/api/MAPFuture;

    goto/16 :goto_0
.end method

.method static synthetic access$600(Lcom/amazon/identity/auth/device/AuthPortalUIActivity;)V
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/AuthPortalUIActivity;

    .prologue
    .line 83
    iget-object v0, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mRequestTimeoutTimer:Ljava/util/Timer;

    invoke-virtual {v0}, Ljava/util/Timer;->cancel()V

    return-void
.end method

.method static synthetic access$700(Lcom/amazon/identity/auth/device/AuthPortalUIActivity;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/AuthPortalUIActivity;

    .prologue
    .line 83
    iget-object v0, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mFirstOnPageStartedTimer:Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    return-object v0
.end method

.method static synthetic access$800(Lcom/amazon/identity/auth/device/AuthPortalUIActivity;)Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/AuthPortalUIActivity;

    .prologue
    .line 83
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->getRequestTypeFromIntent()Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$900(Lcom/amazon/identity/auth/device/AuthPortalUIActivity;)Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/AuthPortalUIActivity;

    .prologue
    .line 83
    iget-object v0, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mAuthenticationWebViewClient:Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;

    return-object v0
.end method

.method private closeActivity()V
    .locals 2

    .prologue
    .line 1590
    iget-object v0, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mIsRegistrationInFlight:Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Ljava/util/concurrent/atomic/AtomicBoolean;->set(Z)V

    .line 1591
    invoke-super {p0}, Landroid/app/Activity;->finish()V

    .line 1592
    return-void
.end method

.method private finishOnError(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "errorBundle"    # Landroid/os/Bundle;

    .prologue
    .line 1532
    new-instance v0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity$5;

    invoke-direct {v0, p0, p1}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity$5;-><init>(Lcom/amazon/identity/auth/device/AuthPortalUIActivity;Landroid/os/Bundle;)V

    invoke-static {v0}, Lcom/amazon/identity/auth/device/utils/ThreadUtils;->runOffMainThread(Ljava/lang/Runnable;)V

    .line 1552
    return-void
.end method

.method private getClientId()Ljava/lang/String;
    .locals 3

    .prologue
    .line 1624
    :try_start_0
    iget-object v1, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mContext:Landroid/content/Context;

    invoke-static {v1}, Lcom/amazon/identity/auth/device/api/DeviceDataStore;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/device/api/DeviceDataStore;

    move-result-object v1

    const-string/jumbo v2, "Client Id"

    invoke-virtual {v1, v2}, Lcom/amazon/identity/auth/device/api/DeviceDataStore;->getValue(Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Lcom/amazon/identity/auth/device/api/DeviceDataStoreException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 1629
    :goto_0
    return-object v1

    .line 1626
    :catch_0
    move-exception v0

    .line 1628
    .local v0, "e":Lcom/amazon/identity/auth/device/api/DeviceDataStoreException;
    sget-object v1, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Cannot fetch dsn from the DeviceDataStore."

    invoke-static {v1, v2, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 1629
    const/4 v1, 0x0

    goto :goto_0
.end method

.method private getDebugParameters()Ljava/util/Map;
    .locals 13
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 575
    new-instance v8, Ljava/util/HashMap;

    invoke-direct {v8}, Ljava/util/HashMap;-><init>()V

    .line 580
    .local v8, "paramMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    :try_start_0
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v10

    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->getPackageName()Ljava/lang/String;

    move-result-object v11

    const/16 v12, 0x80

    invoke-virtual {v10, v11, v12}, Landroid/content/pm/PackageManager;->getApplicationInfo(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;

    move-result-object v10

    .line 582
    const/4 v1, 0x0

    .local v1, "ai":Landroid/content/pm/ApplicationInfo;
    iget-object v0, v10, Landroid/content/pm/ApplicationInfo;->metaData:Landroid/os/Bundle;

    .line 583
    .local v0, "aBundle":Landroid/os/Bundle;
    if-nez v0, :cond_1

    .line 618
    .end local v0    # "aBundle":Landroid/os/Bundle;
    .end local v1    # "ai":Landroid/content/pm/ApplicationInfo;
    :cond_0
    :goto_0
    return-object v8

    .line 589
    .restart local v0    # "aBundle":Landroid/os/Bundle;
    .restart local v1    # "ai":Landroid/content/pm/ApplicationInfo;
    :cond_1
    const-string/jumbo v10, "debugParams"

    invoke-virtual {v0, v10}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 591
    .local v3, "debugParams":Ljava/lang/String;
    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v10

    if-nez v10, :cond_0

    .line 593
    new-instance v2, Landroid/text/TextUtils$SimpleStringSplitter;

    const/16 v10, 0x2c

    invoke-direct {v2, v10}, Landroid/text/TextUtils$SimpleStringSplitter;-><init>(C)V

    .line 594
    .local v2, "commaSplitter":Landroid/text/TextUtils$SimpleStringSplitter;
    invoke-virtual {v2, v3}, Landroid/text/TextUtils$SimpleStringSplitter;->setString(Ljava/lang/String;)V

    .line 596
    :cond_2
    :goto_1
    invoke-virtual {v2}, Landroid/text/TextUtils$SimpleStringSplitter;->hasNext()Z

    move-result v10

    if-eqz v10, :cond_0

    .line 598
    invoke-virtual {v2}, Landroid/text/TextUtils$SimpleStringSplitter;->next()Ljava/lang/String;

    move-result-object v7

    .line 599
    .local v7, "param":Ljava/lang/String;
    new-instance v5, Landroid/text/TextUtils$SimpleStringSplitter;

    const/16 v10, 0x3d

    invoke-direct {v5, v10}, Landroid/text/TextUtils$SimpleStringSplitter;-><init>(C)V

    .line 600
    .local v5, "equalsSplitter":Landroid/text/TextUtils$SimpleStringSplitter;
    invoke-virtual {v5, v7}, Landroid/text/TextUtils$SimpleStringSplitter;->setString(Ljava/lang/String;)V

    .line 601
    invoke-virtual {v5}, Landroid/text/TextUtils$SimpleStringSplitter;->hasNext()Z

    move-result v10

    if-eqz v10, :cond_2

    .line 603
    invoke-virtual {v5}, Landroid/text/TextUtils$SimpleStringSplitter;->next()Ljava/lang/String;

    move-result-object v6

    .line 604
    .local v6, "name":Ljava/lang/String;
    invoke-virtual {v5}, Landroid/text/TextUtils$SimpleStringSplitter;->hasNext()Z

    move-result v10

    if-eqz v10, :cond_2

    .line 606
    invoke-virtual {v5}, Landroid/text/TextUtils$SimpleStringSplitter;->next()Ljava/lang/String;

    move-result-object v9

    .line 607
    .local v9, "value":Ljava/lang/String;
    invoke-interface {v8, v6, v9}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    .line 613
    .end local v0    # "aBundle":Landroid/os/Bundle;
    .end local v1    # "ai":Landroid/content/pm/ApplicationInfo;
    .end local v2    # "commaSplitter":Landroid/text/TextUtils$SimpleStringSplitter;
    .end local v3    # "debugParams":Ljava/lang/String;
    .end local v5    # "equalsSplitter":Landroid/text/TextUtils$SimpleStringSplitter;
    .end local v6    # "name":Ljava/lang/String;
    .end local v7    # "param":Ljava/lang/String;
    .end local v9    # "value":Ljava/lang/String;
    :catch_0
    move-exception v4

    .line 615
    .local v4, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    sget-object v10, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->TAG:Ljava/lang/String;

    const-string/jumbo v11, "No meta found for this package"

    invoke-static {v10, v11, v4}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method private getParentLayout()Landroid/widget/RelativeLayout;
    .locals 2

    .prologue
    .line 1635
    const-string/jumbo v1, "apparentlayout"

    invoke-static {p0, v1}, Lcom/amazon/identity/auth/device/utils/ResourceHelper;->getId(Landroid/content/Context;Ljava/lang/String;)I

    move-result v0

    .line 1636
    .local v0, "parentLayoutId":I
    invoke-virtual {p0, v0}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/RelativeLayout;

    return-object v1
.end method

.method private getRequestTypeFromIntent()Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;
    .locals 6

    .prologue
    .line 628
    sget-object v3, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;->SIGN_IN:Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;

    .line 630
    .local v3, "type":Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->getIntent()Landroid/content/Intent;

    move-result-object v1

    .line 632
    .local v1, "intent":Landroid/content/Intent;
    if-nez v1, :cond_0

    move-object v4, v3

    .line 669
    .end local v3    # "type":Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;
    .local v4, "type":Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;
    :goto_0
    return-object v4

    .line 637
    .end local v4    # "type":Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;
    .restart local v3    # "type":Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;
    :cond_0
    invoke-virtual {v1}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    .line 640
    .local v0, "extras":Landroid/os/Bundle;
    if-nez v0, :cond_1

    move-object v4, v3

    .line 642
    .end local v3    # "type":Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;
    .restart local v4    # "type":Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;
    goto :goto_0

    .line 645
    .end local v4    # "type":Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;
    .restart local v3    # "type":Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;
    :cond_1
    const-string/jumbo v5, "requestType"

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 647
    .local v2, "requestType":Ljava/lang/String;
    if-nez v2, :cond_2

    move-object v4, v3

    .line 649
    .end local v3    # "type":Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;
    .restart local v4    # "type":Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;
    goto :goto_0

    .line 652
    .end local v4    # "type":Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;
    .restart local v3    # "type":Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;
    :cond_2
    sget-object v5, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;->REGISTER:Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;

    invoke-virtual {v5}, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v5, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_4

    .line 654
    sget-object v3, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;->REGISTER:Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;

    :cond_3
    :goto_1
    move-object v4, v3

    .line 669
    .end local v3    # "type":Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;
    .restart local v4    # "type":Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;
    goto :goto_0

    .line 656
    .end local v4    # "type":Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;
    .restart local v3    # "type":Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;
    :cond_4
    sget-object v5, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;->SIGN_IN:Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;

    invoke-virtual {v5}, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v5, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_5

    .line 658
    sget-object v3, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;->SIGN_IN:Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;

    goto :goto_1

    .line 660
    :cond_5
    sget-object v5, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;->CONFIRM_CREDENTIAL:Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;

    invoke-virtual {v5}, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v5, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_6

    .line 662
    sget-object v3, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;->CONFIRM_CREDENTIAL:Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;

    goto :goto_1

    .line 664
    :cond_6
    sget-object v5, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;->AUTHENTICATE:Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;

    invoke-virtual {v5}, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v5, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_3

    .line 666
    sget-object v3, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;->AUTHENTICATE:Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;

    goto :goto_1
.end method

.method private getWebView()Lcom/amazon/android/webkit/AmazonWebView;
    .locals 6

    .prologue
    .line 1183
    iget-object v1, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mWebView:Lcom/amazon/android/webkit/AmazonWebView;

    if-eqz v1, :cond_0

    .line 1185
    iget-object v1, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mWebView:Lcom/amazon/android/webkit/AmazonWebView;

    .line 1201
    :goto_0
    return-object v1

    .line 1188
    :cond_0
    const-string/jumbo v1, "apwebview"

    invoke-static {p0, v1}, Lcom/amazon/identity/auth/device/utils/ResourceHelper;->getId(Landroid/content/Context;Ljava/lang/String;)I

    move-result v0

    .line 1189
    .local v0, "webViewId":I
    invoke-virtual {p0, v0}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mContext:Landroid/content/Context;

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/api/AmazonWebViewUtils;->getAmazonWebViewFromView(Landroid/view/View;Landroid/content/Context;)Lcom/amazon/android/webkit/AmazonWebView;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mWebView:Lcom/amazon/android/webkit/AmazonWebView;

    .line 1191
    iget-object v1, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mWebView:Lcom/amazon/android/webkit/AmazonWebView;

    if-eqz v1, :cond_1

    .line 1193
    iget-object v1, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mWebView:Lcom/amazon/android/webkit/AmazonWebView;

    goto :goto_0

    .line 1197
    :cond_1
    sget-object v1, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Unexpected Error Occured. Webview returned from AmazonWebViewUtils getAmazonWebViewFromView method for view Id %d"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 1201
    const/4 v1, 0x0

    goto :goto_0
.end method

.method private hideProgressBar()V
    .locals 3

    .prologue
    .line 1421
    iget-object v1, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mAuthenticationWebViewClient:Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;->isMFA()Z

    move-result v1

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mMfaChallengeCodeEnterTimer:Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    if-nez v1, :cond_0

    .line 1423
    sget-object v1, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->TAG:Ljava/lang/String;

    .line 1424
    iget-object v1, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mTracer:Lcom/amazon/identity/auth/device/framework/Tracer;

    const-string/jumbo v2, "MFA:ChallengeCodeEnterTime"

    invoke-virtual {v1, v2}, Lcom/amazon/identity/auth/device/framework/Tracer;->startTimer(Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mMfaChallengeCodeEnterTimer:Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    .line 1427
    :cond_0
    iget-object v1, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mAuthenticationWebViewClient:Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;->isDCQ()Z

    move-result v1

    if-eqz v1, :cond_1

    iget-object v1, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mDcqChallengeQuestionEnterTimer:Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    if-nez v1, :cond_1

    .line 1429
    sget-object v1, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->TAG:Ljava/lang/String;

    .line 1430
    iget-object v1, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mTracer:Lcom/amazon/identity/auth/device/framework/Tracer;

    const-string/jumbo v2, "DCQ:ChallengeQuestionEnterTime"

    invoke-virtual {v1, v2}, Lcom/amazon/identity/auth/device/framework/Tracer;->startTimer(Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mDcqChallengeQuestionEnterTimer:Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    .line 1433
    :cond_1
    iget-object v1, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mRequestTimeoutTimer:Ljava/util/Timer;

    invoke-virtual {v1}, Ljava/util/Timer;->cancel()V

    .line 1434
    iget v1, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mProgressbarId:I

    invoke-virtual {p0, v1}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ProgressBar;

    .line 1435
    .local v0, "progressBar":Landroid/widget/ProgressBar;
    invoke-virtual {v0}, Landroid/widget/ProgressBar;->getVisibility()I

    move-result v1

    if-nez v1, :cond_3

    .line 1437
    iget-boolean v1, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mBarFade:Z

    if-eqz v1, :cond_2

    .line 1439
    iget-boolean v1, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mBarOn:Z

    if-eqz v1, :cond_2

    iget-boolean v1, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mBarFaded:Z

    if-nez v1, :cond_2

    const-string/jumbo v1, "delay_fade_anim"

    invoke-static {p0, v1}, Lcom/amazon/identity/auth/device/utils/ResourceHelper;->getAnimId(Landroid/content/Context;Ljava/lang/String;)I

    move-result v1

    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->getBaseContext()Landroid/content/Context;

    move-result-object v2

    invoke-static {v2, v1}, Landroid/view/animation/AnimationUtils;->loadAnimation(Landroid/content/Context;I)Landroid/view/animation/Animation;

    move-result-object v1

    const/4 v2, 0x1

    iput-boolean v2, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mBarFaded:Z

    new-instance v2, Lcom/amazon/identity/auth/device/AuthPortalUIActivity$4;

    invoke-direct {v2, p0, v1}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity$4;-><init>(Lcom/amazon/identity/auth/device/AuthPortalUIActivity;Landroid/view/animation/Animation;)V

    invoke-static {v2}, Lcom/amazon/identity/auth/device/utils/ThreadUtils;->runOnMainThread(Ljava/lang/Runnable;)V

    .line 1441
    :cond_2
    iget-boolean v1, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mBarOn:Z

    if-eqz v1, :cond_3

    .line 1443
    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 1446
    :cond_3
    return-void
.end method

.method private returnSuccess(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "result"    # Landroid/os/Bundle;

    .prologue
    .line 1563
    new-instance v0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity$6;

    invoke-direct {v0, p0, p1}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity$6;-><init>(Lcom/amazon/identity/auth/device/AuthPortalUIActivity;Landroid/os/Bundle;)V

    invoke-static {v0}, Lcom/amazon/identity/auth/device/utils/ThreadUtils;->runOffMainThread(Ljava/lang/Runnable;)V

    .line 1577
    return-void
.end method

.method private setProgressBarProgress(I)V
    .locals 2
    .param p1, "progress"    # I

    .prologue
    .line 1409
    iget-boolean v1, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mBarOn:Z

    if-eqz v1, :cond_0

    .line 1411
    iget v1, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mProgressbarId:I

    invoke-virtual {p0, v1}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ProgressBar;

    .line 1412
    .local v0, "progressBar":Landroid/widget/ProgressBar;
    invoke-virtual {v0}, Landroid/widget/ProgressBar;->getVisibility()I

    move-result v1

    if-nez v1, :cond_0

    .line 1414
    invoke-virtual {v0, p1}, Landroid/widget/ProgressBar;->setProgress(I)V

    .line 1417
    .end local v0    # "progressBar":Landroid/widget/ProgressBar;
    :cond_0
    return-void
.end method

.method private setupWebChromeClient(Lcom/amazon/android/webkit/AmazonWebView;)V
    .locals 1
    .param p1, "webview"    # Lcom/amazon/android/webkit/AmazonWebView;

    .prologue
    .line 828
    new-instance v0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity$1;

    invoke-direct {v0, p0}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity$1;-><init>(Lcom/amazon/identity/auth/device/AuthPortalUIActivity;)V

    invoke-virtual {p1, v0}, Lcom/amazon/android/webkit/AmazonWebView;->setWebChromeClient(Lcom/amazon/android/webkit/AmazonWebChromeClient;)V

    .line 836
    return-void
.end method


# virtual methods
.method public finish()V
    .locals 2

    .prologue
    .line 1507
    iget-object v0, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mIsRegistrationInFlight:Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicBoolean;->get()Z

    move-result v0

    if-nez v0, :cond_0

    .line 1510
    sget-object v0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->TAG:Ljava/lang/String;

    .line 1514
    const/4 v0, 0x4

    const-string/jumbo v1, "Registration canceled"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/accounts/AccountsCallbackHelpers;->getAccountManagerErrorBundle(ILjava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->finishOnError(Landroid/os/Bundle;)V

    .line 1519
    :goto_0
    return-void

    .line 1518
    :cond_0
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->closeActivity()V

    goto :goto_0
.end method

.method public onBackPressed()V
    .locals 1

    .prologue
    .line 1483
    iget-object v0, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mIsRegistrationInFlight:Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicBoolean;->get()Z

    move-result v0

    if-nez v0, :cond_1

    .line 1485
    iget-object v0, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mBackPressedTimer:Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    if-eqz v0, :cond_0

    .line 1487
    iget-object v0, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mBackPressedTimer:Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    invoke-virtual {v0}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->stopAndDiscard()V

    .line 1489
    :cond_0
    invoke-super {p0}, Landroid/app/Activity;->onBackPressed()V

    .line 1492
    :cond_1
    return-void
.end method

.method public onConfigurationChanged(Landroid/content/res/Configuration;)V
    .locals 4
    .param p1, "newConfig"    # Landroid/content/res/Configuration;

    .prologue
    .line 978
    invoke-super {p0, p1}, Landroid/app/Activity;->onConfigurationChanged(Landroid/content/res/Configuration;)V

    .line 982
    :try_start_0
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->getWebView()Lcom/amazon/android/webkit/AmazonWebView;

    move-result-object v1

    .line 984
    .local v1, "webView":Lcom/amazon/android/webkit/AmazonWebView;
    if-eqz v1, :cond_0

    .line 989
    invoke-virtual {v1}, Lcom/amazon/android/webkit/AmazonWebView;->invalidate()V
    :try_end_0
    .catch Ljava/lang/NoSuchFieldError; {:try_start_0 .. :try_end_0} :catch_0

    .line 996
    .end local v1    # "webView":Lcom/amazon/android/webkit/AmazonWebView;
    :cond_0
    :goto_0
    return-void

    .line 992
    :catch_0
    move-exception v0

    .line 994
    .local v0, "nsfe":Ljava/lang/NoSuchFieldError;
    sget-object v2, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string/jumbo v3, "Android Resource error: "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/lang/NoSuchFieldError;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    goto :goto_0
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 18
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 201
    :try_start_0
    sget-object v1, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Login webview called in package %s by package %s"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-virtual/range {p0 .. p0}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->getPackageName()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x1

    invoke-virtual/range {p0 .. p0}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->getCallingPackage()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 204
    invoke-static/range {p0 .. p0}, Lcom/amazon/identity/auth/device/utils/SecurityHelpers;->checkCallingPackagePermissionsOrSystem(Landroid/app/Activity;)V

    .line 207
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->getIntent()Landroid/content/Intent;

    move-result-object v1

    if-eqz v1, :cond_4

    invoke-virtual {v1}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v2

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mOptions:Landroid/os/Bundle;

    const-string/jumbo v2, "MAP_AuthPortalUIActivity"

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/framework/Tracer;->createFromIntent(Landroid/content/Intent;Ljava/lang/String;)Lcom/amazon/identity/auth/device/framework/Tracer;

    move-result-object v1

    move-object/from16 v0, p0

    iput-object v1, v0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mTracer:Lcom/amazon/identity/auth/device/framework/Tracer;

    .line 209
    :goto_0
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->create(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    move-result-object v1

    move-object/from16 v0, p0

    iput-object v1, v0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mContext:Landroid/content/Context;

    .line 210
    new-instance v1, Lcom/amazon/identity/auth/device/api/MAPAccountManager;

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mContext:Landroid/content/Context;

    invoke-direct {v1, v2}, Lcom/amazon/identity/auth/device/api/MAPAccountManager;-><init>(Landroid/content/Context;)V

    move-object/from16 v0, p0

    iput-object v1, v0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mMapAccountManager:Lcom/amazon/identity/auth/device/api/MAPAccountManager;

    .line 211
    new-instance v1, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mContext:Landroid/content/Context;

    invoke-direct {v1, v2}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;-><init>(Landroid/content/Context;)V

    move-object/from16 v0, p0

    iput-object v1, v0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mAmazonAccountManager:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    .line 212
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mContext:Landroid/content/Context;

    const-string/jumbo v2, "sso_platform"

    invoke-virtual {v1, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    move-object/from16 v0, p0

    iput-object v1, v0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mPlatform:Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    .line 213
    new-instance v1, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mContext:Landroid/content/Context;

    invoke-direct {v1, v2}, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;-><init>(Landroid/content/Context;)V

    move-object/from16 v0, p0

    iput-object v1, v0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mBackwardsCompatiableDataStorage:Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;

    .line 217
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->getWindow()Landroid/view/Window;

    move-result-object v1

    const/high16 v2, 0x10000

    invoke-virtual {v1, v2}, Landroid/view/Window;->addFlags(I)V

    .line 218
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->getWindow()Landroid/view/Window;

    move-result-object v1

    const/16 v2, 0x100

    invoke-virtual {v1, v2}, Landroid/view/Window;->addFlags(I)V

    .line 221
    const/4 v1, 0x1

    move-object/from16 v0, p0

    invoke-virtual {v0, v1}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->requestWindowFeature(I)Z

    .line 224
    invoke-super/range {p0 .. p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 231
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mOptions:Landroid/os/Bundle;

    if-eqz v1, :cond_3

    .line 233
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mOptions:Landroid/os/Bundle;

    const-string/jumbo v2, "callback"

    invoke-virtual {v1, v2}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v1

    check-cast v1, Lcom/amazon/identity/auth/device/callback/RemoteCallbackWrapper;

    move-object/from16 v0, p0

    iput-object v1, v0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mResponse:Lcom/amazon/identity/auth/device/callback/RemoteCallbackWrapper;

    .line 234
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mOptions:Landroid/os/Bundle;

    const-string/jumbo v2, "callback"

    invoke-virtual {v1, v2}, Landroid/os/Bundle;->remove(Ljava/lang/String;)V

    .line 236
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mOptions:Landroid/os/Bundle;

    if-eqz v1, :cond_3

    const-string/jumbo v2, "AuthPortalActivityUIOptions.amazonScreenModes"

    invoke-virtual {v1, v2}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    const-string/jumbo v2, "AuthPortalActivityUIOptions.amazonScreenModes"

    invoke-virtual {v1, v2}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v2

    invoke-virtual/range {p0 .. p0}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->getWindow()Landroid/view/Window;

    move-result-object v3

    invoke-virtual {v3}, Landroid/view/Window;->getDecorView()Landroid/view/View;
    :try_end_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/NullPointerException; {:try_start_0 .. :try_end_0} :catch_2
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_3

    move-result-object v3

    :try_start_1
    new-instance v4, Lcom/amazon/identity/auth/device/utils/ReflectionHelper;

    invoke-direct {v4}, Lcom/amazon/identity/auth/device/utils/ReflectionHelper;-><init>()V

    const-string/jumbo v5, "setAmazonSystemUi"

    const-string/jumbo v6, "com.amazon.android.view.AmazonScreenModes"

    const/4 v7, 0x2

    new-array v7, v7, [Ljava/lang/Class;

    const/4 v8, 0x0

    const-class v9, Landroid/view/View;

    aput-object v9, v7, v8

    const/4 v8, 0x1

    sget-object v9, Ljava/lang/Integer;->TYPE:Ljava/lang/Class;

    aput-object v9, v7, v8

    const/4 v8, 0x2

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    aput-object v3, v8, v9

    const/4 v3, 0x1

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    aput-object v2, v8, v3

    invoke-virtual {v4, v5, v6, v7, v8}, Lcom/amazon/identity/auth/device/utils/ReflectionHelper;->invokeStatic(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_1
    .catch Lcom/amazon/identity/auth/device/utils/ReflectionHelper$CannotCallMethodException; {:try_start_1 .. :try_end_1} :catch_1
    .catch Ljava/lang/IllegalArgumentException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/lang/NullPointerException; {:try_start_1 .. :try_end_1} :catch_2
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_3

    :cond_0
    :goto_1
    :try_start_2
    const-string/jumbo v2, "AuthPortalActivityUIOptions.aboveLockScreen"

    invoke-virtual {v1, v2}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-virtual/range {p0 .. p0}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->getWindow()Landroid/view/Window;

    move-result-object v2

    const/high16 v3, 0x80000

    invoke-virtual {v2, v3}, Landroid/view/Window;->addFlags(I)V

    :cond_1
    const-string/jumbo v2, "AuthPortalActivityUIOptions.requestedOrientation"

    invoke-virtual {v1, v2}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_2

    const-string/jumbo v2, "AuthPortalActivityUIOptions.requestedOrientation"

    invoke-virtual {v1, v2}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v2

    move-object/from16 v0, p0

    invoke-virtual {v0, v2}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->setRequestedOrientation(I)V

    :cond_2
    const-string/jumbo v2, "AuthPortalActivityUIOptions.fullscreen"

    invoke-virtual {v1, v2}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_3

    invoke-virtual/range {p0 .. p0}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->getWindow()Landroid/view/Window;

    move-result-object v1

    const/16 v2, 0x400

    invoke-virtual {v1, v2}, Landroid/view/Window;->addFlags(I)V

    .line 241
    :cond_3
    invoke-direct/range {p0 .. p0}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->getClientId()Ljava/lang/String;

    move-result-object v1

    .line 242
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_5

    .line 244
    sget-object v1, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->UNRECOGNIZED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->value()I

    move-result v1

    const-string/jumbo v2, "An unexpected error occured while setting up the WebView. Cannot fetch client id!"

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/accounts/AccountsCallbackHelpers;->getErrorBundle(ILjava/lang/String;)Landroid/os/Bundle;

    move-result-object v1

    move-object/from16 v0, p0

    invoke-direct {v0, v1}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->finishOnError(Landroid/os/Bundle;)V

    .line 342
    :goto_2
    return-void

    .line 207
    :cond_4
    sget-object v1, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "The intent in AuthPortalUIActivity is null! This should be a bug!"

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_2
    .catch Ljava/lang/IllegalArgumentException; {:try_start_2 .. :try_end_2} :catch_0
    .catch Ljava/lang/NullPointerException; {:try_start_2 .. :try_end_2} :catch_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_3

    goto/16 :goto_0

    .line 327
    :catch_0
    move-exception v10

    .line 329
    .local v10, "e":Ljava/lang/IllegalArgumentException;
    sget-object v1, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->BAD_REQUEST:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->value()I

    move-result v1

    invoke-virtual {v10}, Ljava/lang/IllegalArgumentException;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/accounts/AccountsCallbackHelpers;->getErrorBundle(ILjava/lang/String;)Landroid/os/Bundle;

    move-result-object v1

    move-object/from16 v0, p0

    invoke-direct {v0, v1}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->finishOnError(Landroid/os/Bundle;)V

    goto :goto_2

    .line 236
    .end local v10    # "e":Ljava/lang/IllegalArgumentException;
    :catch_1
    move-exception v2

    :try_start_3
    sget-object v2, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "Unable to set AmazonScreenModes. Could not invoke com.amazon.android.view.AmazonScreenModes.setAmazonSystemUi() from the Amazon SDK."

    invoke-static {v2, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_3
    .catch Ljava/lang/IllegalArgumentException; {:try_start_3 .. :try_end_3} :catch_0
    .catch Ljava/lang/NullPointerException; {:try_start_3 .. :try_end_3} :catch_2
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_3

    goto :goto_1

    .line 331
    :catch_2
    move-exception v10

    .line 333
    .local v10, "e":Ljava/lang/NullPointerException;
    sget-object v1, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->UNRECOGNIZED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->value()I

    move-result v1

    invoke-virtual {v10}, Ljava/lang/NullPointerException;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/accounts/AccountsCallbackHelpers;->getErrorBundle(ILjava/lang/String;)Landroid/os/Bundle;

    move-result-object v1

    move-object/from16 v0, p0

    invoke-direct {v0, v1}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->finishOnError(Landroid/os/Bundle;)V

    goto :goto_2

    .line 249
    .end local v10    # "e":Ljava/lang/NullPointerException;
    :cond_5
    :try_start_4
    new-instance v11, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;

    invoke-direct/range {p0 .. p0}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->getClientId()Ljava/lang/String;

    move-result-object v1

    invoke-direct/range {p0 .. p0}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->getRequestTypeFromIntent()Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;

    move-result-object v2

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mOptions:Landroid/os/Bundle;

    invoke-direct {v11, v1, v2, v3}, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;-><init>(Ljava/lang/String;Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;Landroid/os/Bundle;)V

    .line 251
    .local v11, "request":Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;
    invoke-virtual {v11}, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->getHost()Ljava/lang/String;

    move-result-object v1

    move-object/from16 v0, p0

    iput-object v1, v0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mUrlHost:Ljava/lang/String;

    .line 253
    const-string/jumbo v1, "apwebviewlayout"

    move-object/from16 v0, p0

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/ResourceHelper;->getLayoutId(Landroid/content/Context;Ljava/lang/String;)I

    move-result v14

    .line 254
    .local v14, "webViewLayoutId":I
    move-object/from16 v0, p0

    invoke-virtual {v0, v14}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->setContentView(I)V

    .line 256
    invoke-direct/range {p0 .. p0}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->getWebView()Lcom/amazon/android/webkit/AmazonWebView;

    move-result-object v13

    if-nez v13, :cond_6

    const/4 v13, 0x0

    .line 258
    .local v13, "webView":Lcom/amazon/android/webkit/AmazonWebView;
    :goto_3
    if-nez v13, :cond_8

    .line 260
    sget-object v1, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->UNRECOGNIZED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->value()I

    move-result v1

    const-string/jumbo v2, "An unexpected error occured while setting up the WebView."

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/accounts/AccountsCallbackHelpers;->getErrorBundle(ILjava/lang/String;)Landroid/os/Bundle;

    move-result-object v1

    move-object/from16 v0, p0

    invoke-direct {v0, v1}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->finishOnError(Landroid/os/Bundle;)V
    :try_end_4
    .catch Ljava/lang/IllegalArgumentException; {:try_start_4 .. :try_end_4} :catch_0
    .catch Ljava/lang/NullPointerException; {:try_start_4 .. :try_end_4} :catch_2
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_3

    goto/16 :goto_2

    .line 336
    .end local v11    # "request":Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;
    .end local v13    # "webView":Lcom/amazon/android/webkit/AmazonWebView;
    .end local v14    # "webViewLayoutId":I
    :catch_3
    move-exception v10

    .line 338
    .local v10, "e":Ljava/lang/Exception;
    sget-object v1, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->UNRECOGNIZED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->value()I

    move-result v1

    invoke-virtual {v10}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/accounts/AccountsCallbackHelpers;->getErrorBundle(ILjava/lang/String;)Landroid/os/Bundle;

    move-result-object v1

    move-object/from16 v0, p0

    invoke-direct {v0, v1}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->finishOnError(Landroid/os/Bundle;)V

    goto/16 :goto_2

    .line 256
    .end local v10    # "e":Ljava/lang/Exception;
    .restart local v11    # "request":Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;
    .restart local v14    # "webViewLayoutId":I
    :cond_6
    if-eqz p1, :cond_7

    :try_start_5
    move-object/from16 v0, p1

    invoke-virtual {v13, v0}, Lcom/amazon/android/webkit/AmazonWebView;->restoreState(Landroid/os/Bundle;)Lcom/amazon/android/webkit/AmazonWebBackForwardList;

    :cond_7
    const/4 v1, 0x0

    invoke-virtual {v13, v1}, Lcom/amazon/android/webkit/AmazonWebView;->setScrollBarStyle(I)V

    invoke-virtual {v13}, Lcom/amazon/android/webkit/AmazonWebView;->getSettings()Lcom/amazon/android/webkit/AmazonWebSettings;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Lcom/amazon/android/webkit/AmazonWebSettings;->setSavePassword(Z)V

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Lcom/amazon/android/webkit/AmazonWebSettings;->setSaveFormData(Z)V

    sget-object v2, Lcom/amazon/android/webkit/AmazonWebSettings$RenderPriority;->HIGH:Lcom/amazon/android/webkit/AmazonWebSettings$RenderPriority;

    invoke-virtual {v1, v2}, Lcom/amazon/android/webkit/AmazonWebSettings;->setRenderPriority(Lcom/amazon/android/webkit/AmazonWebSettings$RenderPriority;)V

    invoke-virtual {v13}, Lcom/amazon/android/webkit/AmazonWebView;->clearFormData()V

    invoke-virtual {v13}, Lcom/amazon/android/webkit/AmazonWebView;->getSettings()Lcom/amazon/android/webkit/AmazonWebSettings;

    move-result-object v1

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Lcom/amazon/android/webkit/AmazonWebSettings;->setJavaScriptEnabled(Z)V

    new-instance v5, Lcom/amazon/identity/auth/device/AuthPortalUIActivity$2;

    move-object/from16 v0, p0

    invoke-direct {v5, v0}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity$2;-><init>(Lcom/amazon/identity/auth/device/AuthPortalUIActivity;)V

    new-instance v1, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;

    invoke-virtual {v11}, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->getRequestType()Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;

    move-result-object v2

    invoke-virtual {v11}, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->getReturnToUrl()Ljava/lang/String;

    move-result-object v3

    sget-object v4, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$TOKEN_SCOPE;->ACCESS:Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$TOKEN_SCOPE;

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mTracer:Lcom/amazon/identity/auth/device/framework/Tracer;

    invoke-direct/range {v1 .. v6}, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;-><init>(Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;Ljava/lang/String;Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$TOKEN_SCOPE;Lcom/amazon/identity/auth/device/AuthenticationWebViewClient$AuthenticationWebViewClientCallback;Lcom/amazon/identity/auth/device/framework/Tracer;)V

    move-object/from16 v0, p0

    iput-object v1, v0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mAuthenticationWebViewClient:Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;

    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mAuthenticationWebViewClient:Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;

    invoke-virtual {v13, v1}, Lcom/amazon/android/webkit/AmazonWebView;->setWebViewClient(Lcom/amazon/android/webkit/AmazonWebViewClient;)V

    goto :goto_3

    .line 265
    .restart local v13    # "webView":Lcom/amazon/android/webkit/AmazonWebView;
    :cond_8
    invoke-virtual {v11}, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->getCookieUrl()Ljava/lang/String;

    move-result-object v1

    move-object/from16 v0, p0

    iput-object v1, v0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mCookieUrl:Ljava/lang/String;

    .line 266
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mCookieUrl:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mContext:Landroid/content/Context;

    const-string/jumbo v3, "sid"

    const-string/jumbo v4, ""

    const-string/jumbo v5, "/"

    invoke-static {}, Lcom/amazon/identity/auth/device/utils/CookieUtils;->getNonExpiringCookieExpiresString()Ljava/lang/String;

    move-result-object v6

    const/4 v7, 0x1

    const/4 v8, 0x1

    invoke-static/range {v1 .. v8}, Lcom/amazon/identity/auth/device/utils/AmazonWebviewCookieUtils;->setCookie(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)V

    .line 267
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mCookieUrl:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mOptions:Landroid/os/Bundle;

    const-string/jumbo v3, "directedid"

    invoke-virtual {v1, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_9

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mBackwardsCompatiableDataStorage:Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;

    const-string/jumbo v4, "com.amazon.dcp.sso.token.cookie.sid"

    invoke-virtual {v3, v1, v4}, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;->getToken(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_9

    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mContext:Landroid/content/Context;

    const-string/jumbo v3, "sid"

    const-string/jumbo v5, "/"

    invoke-static {}, Lcom/amazon/identity/auth/device/utils/CookieUtils;->getNonExpiringCookieExpiresString()Ljava/lang/String;

    move-result-object v6

    const/4 v7, 0x1

    const/4 v8, 0x1

    invoke-static/range {v1 .. v8}, Lcom/amazon/identity/auth/device/utils/AmazonWebviewCookieUtils;->setCookie(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)V

    .line 274
    :cond_9
    invoke-direct/range {p0 .. p0}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->getRequestTypeFromIntent()Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;

    move-result-object v1

    sget-object v2, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;->AUTHENTICATE:Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;

    invoke-virtual {v1, v2}, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_10

    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mOptions:Landroid/os/Bundle;

    const-string/jumbo v2, "isWarmSeatAuthentication"

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v1

    :goto_4
    if-eqz v1, :cond_a

    .line 276
    const-string/jumbo v1, "0"

    invoke-virtual {v11, v1}, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->setMaxAuthAge(Ljava/lang/String;)V

    const/4 v1, 0x1

    invoke-virtual {v11, v1}, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->setIgnoreAuthCookiesOnResponse(Z)V

    .line 278
    :cond_a
    invoke-virtual {v11}, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->getRequestType()Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;

    move-result-object v1

    sget-object v2, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;->CONFIRM_CREDENTIAL:Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;

    if-ne v1, v2, :cond_14

    .line 280
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mPlatform:Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;->isOtter()Z

    move-result v1

    if-eqz v1, :cond_13

    const-string/jumbo v15, "http://www.amazon.com/ap/specs/auth/confirm_credentials"

    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mBackwardsCompatiableDataStorage:Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mOptions:Landroid/os/Bundle;

    const-string/jumbo v3, "directedid"

    invoke-virtual {v2, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    const-string/jumbo v3, "com.amazon.dcp.sso.token.cookie.xmain"

    invoke-virtual {v1, v2, v3}, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;->getToken(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_11

    sget-object v1, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->UNRECOGNIZED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    const-string/jumbo v2, "X-MAIN should exist. There is likely a registration bug."

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/token/TokenCallbackHelpers;->getErrorBundle(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v1

    move-object/from16 v0, p0

    invoke-direct {v0, v1}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->finishOnError(Landroid/os/Bundle;)V

    .line 290
    :goto_5
    move-object/from16 v0, p0

    iget-object v9, v0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mOptions:Landroid/os/Bundle;

    sget-object v8, Lcom/amazon/identity/auth/device/api/MAPAccountManager$AuthPortalActivityUIOptions$ProgressBarState;->OFF:Lcom/amazon/identity/auth/device/api/MAPAccountManager$AuthPortalActivityUIOptions$ProgressBarState;

    sget-object v7, Lcom/amazon/identity/auth/device/api/MAPAccountManager$AuthPortalActivityUIOptions$ScreenPosition;->BOTTOM_CENTER:Lcom/amazon/identity/auth/device/api/MAPAccountManager$AuthPortalActivityUIOptions$ScreenPosition;

    const/4 v1, 0x1

    move-object/from16 v0, p0

    iput-boolean v1, v0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mBarFade:Z

    const/4 v6, 0x1

    const/4 v5, 0x0

    const/4 v2, -0x1

    const/4 v1, -0x1

    const/4 v4, -0x1

    const/4 v3, -0x1

    if-eqz v9, :cond_1f

    const-string/jumbo v1, "progressbar_state"

    invoke-virtual {v9, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_b

    invoke-static {v1}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$AuthPortalActivityUIOptions$ProgressBarState;->get(Ljava/lang/String;)Lcom/amazon/identity/auth/device/api/MAPAccountManager$AuthPortalActivityUIOptions$ProgressBarState;

    move-result-object v8

    :cond_b
    const-string/jumbo v1, "progressbar_position"

    invoke-virtual {v9, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_c

    invoke-static {v1}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$AuthPortalActivityUIOptions$ScreenPosition;->get(Ljava/lang/String;)Lcom/amazon/identity/auth/device/api/MAPAccountManager$AuthPortalActivityUIOptions$ScreenPosition;

    move-result-object v7

    :cond_c
    const-string/jumbo v1, "progressbar_fade"

    move-object/from16 v0, p0

    iget-boolean v2, v0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mBarFade:Z

    invoke-virtual {v9, v1, v2}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v1

    move-object/from16 v0, p0

    iput-boolean v1, v0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mBarFade:Z

    const-string/jumbo v1, "progressbar_stretch"

    const/4 v2, 0x1

    invoke-virtual {v9, v1, v2}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v6

    const-string/jumbo v1, "progressbar_invert_spinner"

    const/4 v2, 0x0

    invoke-virtual {v9, v1, v2}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v5

    const-string/jumbo v1, "progressbar_resource"

    const/4 v2, -0x1

    invoke-virtual {v9, v1, v2}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v2

    const-string/jumbo v1, "progressbar_background_resource"

    const/4 v3, -0x1

    invoke-virtual {v9, v1, v3}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v1

    const-string/jumbo v3, "progressbar_primary_color"

    const/4 v4, -0x1

    invoke-virtual {v9, v3, v4}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v4

    const-string/jumbo v3, "progressbar_secondary_color"

    const/4 v15, -0x1

    invoke-virtual {v9, v3, v15}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v3

    move-object v9, v7

    move-object v15, v8

    move v7, v5

    move v8, v6

    move v5, v1

    move v6, v2

    :goto_6
    const-string/jumbo v1, "approgressbar"

    move-object/from16 v0, p0

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/ResourceHelper;->getId(Landroid/content/Context;Ljava/lang/String;)I

    move-result v1

    move-object/from16 v0, p0

    iput v1, v0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mProgressbarId:I

    move-object/from16 v0, p0

    iget v1, v0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mProgressbarId:I

    move-object/from16 v0, p0

    invoke-virtual {v0, v1}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ProgressBar;

    invoke-virtual {v1}, Landroid/widget/ProgressBar;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v2

    check-cast v2, Landroid/widget/RelativeLayout$LayoutParams;

    sget-object v16, Lcom/amazon/identity/auth/device/AuthPortalUIActivity$7;->$SwitchMap$com$amazon$identity$auth$device$api$MAPAccountManager$AuthPortalActivityUIOptions$ProgressBarState:[I

    invoke-virtual {v15}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$AuthPortalActivityUIOptions$ProgressBarState;->ordinal()I

    move-result v17

    aget v16, v16, v17

    packed-switch v16, :pswitch_data_0

    const/4 v3, 0x1

    move-object/from16 v0, p0

    iput-boolean v3, v0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mBarOn:Z

    const/4 v3, 0x0

    sget-object v4, Lcom/amazon/identity/auth/device/AuthPortalUIActivity$7;->$SwitchMap$com$amazon$identity$auth$device$api$MAPAccountManager$AuthPortalActivityUIOptions$ProgressBarState:[I

    invoke-virtual {v15}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$AuthPortalActivityUIOptions$ProgressBarState;->ordinal()I

    move-result v5

    aget v4, v4, v5

    packed-switch v4, :pswitch_data_1

    sget-object v4, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->TAG:Ljava/lang/String;

    const-string/jumbo v5, "Bar State not recongized"

    invoke-static {v4, v5}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    :goto_7
    const/4 v4, -0x2

    iput v4, v2, Landroid/widget/RelativeLayout$LayoutParams;->width:I

    const/16 v4, 0x8

    invoke-virtual {v1, v4}, Landroid/widget/ProgressBar;->setVisibility(I)V

    new-instance v1, Landroid/widget/ProgressBar;

    const/4 v4, 0x0

    move-object/from16 v0, p0

    invoke-direct {v1, v0, v4, v3}, Landroid/widget/ProgressBar;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    invoke-direct/range {p0 .. p0}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->getParentLayout()Landroid/widget/RelativeLayout;

    move-result-object v3

    invoke-virtual {v3, v1}, Landroid/widget/RelativeLayout;->addView(Landroid/view/View;)V

    const-string/jumbo v3, "apspinner_progressbar"

    move-object/from16 v0, p0

    invoke-static {v0, v3}, Lcom/amazon/identity/auth/device/utils/ResourceHelper;->getId(Landroid/content/Context;Ljava/lang/String;)I

    move-result v3

    invoke-virtual {v1, v3}, Landroid/widget/ProgressBar;->setId(I)V

    move-object/from16 v0, p0

    iput v3, v0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mProgressbarId:I

    move-object/from16 v0, p0

    invoke-direct {v0, v13}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->setupWebChromeClient(Lcom/amazon/android/webkit/AmazonWebView;)V

    :goto_8
    move-object/from16 v0, p0

    iget-boolean v3, v0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mBarOn:Z

    if-eqz v3, :cond_d

    sget-object v3, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->TAG:Ljava/lang/String;

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-virtual {v9}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$AuthPortalActivityUIOptions$ScreenPosition;->getValue()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    sget-object v3, Lcom/amazon/identity/auth/device/AuthPortalUIActivity$7;->$SwitchMap$com$amazon$identity$auth$device$api$MAPAccountManager$AuthPortalActivityUIOptions$ScreenPosition:[I

    invoke-virtual {v9}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$AuthPortalActivityUIOptions$ScreenPosition;->ordinal()I

    move-result v4

    aget v3, v3, v4

    packed-switch v3, :pswitch_data_2

    :goto_9
    sget-object v3, Lcom/amazon/identity/auth/device/AuthPortalUIActivity$7;->$SwitchMap$com$amazon$identity$auth$device$api$MAPAccountManager$AuthPortalActivityUIOptions$ScreenPosition:[I

    invoke-virtual {v9}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$AuthPortalActivityUIOptions$ScreenPosition;->ordinal()I

    move-result v4

    aget v3, v3, v4

    packed-switch v3, :pswitch_data_3

    :goto_a
    invoke-virtual {v1, v2}, Landroid/widget/ProgressBar;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    invoke-virtual {v1}, Landroid/widget/ProgressBar;->bringToFront()V

    .line 291
    :cond_d
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mOptions:Landroid/os/Bundle;

    const/4 v3, -0x1

    const/4 v2, 0x0

    const-string/jumbo v1, "apimageview"

    move-object/from16 v0, p0

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/ResourceHelper;->getId(Landroid/content/Context;Ljava/lang/String;)I

    move-result v1

    move-object/from16 v0, p0

    invoke-virtual {v0, v1}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    if-eqz v4, :cond_e

    const-string/jumbo v2, "splashscreen_resource"

    const/4 v3, -0x1

    invoke-virtual {v4, v2, v3}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v3

    const-string/jumbo v2, "splashscreen_scale_type"

    invoke-virtual {v4, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    :cond_e
    const/4 v4, -0x1

    if-ne v4, v3, :cond_1d

    const/16 v2, 0x8

    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setVisibility(I)V

    const/4 v1, 0x0

    invoke-virtual {v13, v1}, Lcom/amazon/android/webkit/AmazonWebView;->setVisibility(I)V

    invoke-virtual {v13}, Lcom/amazon/android/webkit/AmazonWebView;->requestFocusFromTouch()Z

    .line 293
    :cond_f
    :goto_b
    invoke-virtual {v13}, Lcom/amazon/android/webkit/AmazonWebView;->getUrl()Ljava/lang/String;

    move-result-object v1

    .line 296
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_1e

    .line 300
    invoke-direct/range {p0 .. p0}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->getDebugParameters()Ljava/util/Map;

    move-result-object v1

    invoke-virtual {v11, v1}, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->setDebugParams(Ljava/util/Map;)V

    .line 301
    invoke-virtual {v11}, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->getRequestUrl()Ljava/lang/String;

    move-result-object v12

    .line 303
    .local v12, "sUrl":Ljava/lang/String;
    sget-object v1, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->TAG:Ljava/lang/String;

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    aput-object v12, v1, v2

    .line 305
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mTracer:Lcom/amazon/identity/auth/device/framework/Tracer;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string/jumbo v3, "AuthPortalUIActivity_FirstOnPageStarted:"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {v12}, Lcom/amazon/identity/platform/metric/MetricUtils;->getAuthPortalUrlPathAndDomain(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/identity/auth/device/framework/Tracer;->startTimer(Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    move-result-object v1

    move-object/from16 v0, p0

    iput-object v1, v0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mFirstOnPageStartedTimer:Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    .line 309
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mTracer:Lcom/amazon/identity/auth/device/framework/Tracer;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string/jumbo v3, "AuthPortalUIActivity_FirstPageLoad:"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {v12}, Lcom/amazon/identity/platform/metric/MetricUtils;->getAuthPortalUrlPathAndDomain(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/identity/auth/device/framework/Tracer;->startTimer(Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    move-result-object v1

    move-object/from16 v0, p0

    iput-object v1, v0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mFirstPageLoadTimer:Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    .line 312
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mTracer:Lcom/amazon/identity/auth/device/framework/Tracer;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string/jumbo v3, "AuthPortalUIActivity_FirstPageRender:"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {v12}, Lcom/amazon/identity/platform/metric/MetricUtils;->getAuthPortalUrlPathAndDomain(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/identity/auth/device/framework/Tracer;->startTimer(Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    move-result-object v1

    move-object/from16 v0, p0

    iput-object v1, v0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mPageLoadToFirstRenderTimer:Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    .line 315
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mTracer:Lcom/amazon/identity/auth/device/framework/Tracer;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string/jumbo v3, "AuthPortalUIActivity_BackPressedInWebView:"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {v12}, Lcom/amazon/identity/platform/metric/MetricUtils;->getAuthPortalUrlPathAndDomain(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/identity/auth/device/framework/Tracer;->startTimer(Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    move-result-object v1

    move-object/from16 v0, p0

    iput-object v1, v0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mBackPressedTimer:Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    .line 318
    const/4 v1, 0x1

    move-object/from16 v0, p0

    iput-boolean v1, v0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mDismissSpinnerEarly:Z

    .line 319
    invoke-virtual {v13, v12}, Lcom/amazon/android/webkit/AmazonWebView;->loadUrl(Ljava/lang/String;)V

    goto/16 :goto_2

    .line 274
    .end local v12    # "sUrl":Ljava/lang/String;
    :cond_10
    const/4 v1, 0x0

    goto/16 :goto_4

    .line 280
    :cond_11
    invoke-virtual {v11}, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->getHost()Ljava/lang/String;

    move-result-object v1

    const-string/jumbo v2, "development.amazon.com"

    invoke-virtual {v1, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_12

    const-string/jumbo v2, "x-tacbus"

    const-string/jumbo v4, "development.amazon.com"

    :goto_c
    new-instance v1, Lcom/amazon/identity/auth/device/token/MAPCookie;

    invoke-static {}, Lcom/amazon/identity/auth/device/utils/CookieUtils;->getNonExpiringCookieExpiresString()Ljava/lang/String;

    move-result-object v5

    const-string/jumbo v6, "/"

    const/4 v7, 0x0

    const/4 v8, 0x0

    const/4 v9, 0x0

    invoke-direct/range {v1 .. v9}, Lcom/amazon/identity/auth/device/token/MAPCookie;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)V

    invoke-virtual {v11, v15}, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->setClaimedId(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mContext:Landroid/content/Context;

    invoke-virtual {v11}, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->getRequestUrl()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3, v1}, Lcom/amazon/identity/auth/device/utils/AmazonWebviewCookieUtils;->setCookie(Landroid/content/Context;Ljava/lang/String;Lcom/amazon/identity/auth/device/token/MAPCookie;)V

    :goto_d
    const-string/jumbo v1, "0"

    invoke-virtual {v11, v1}, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->setMaxAuthAge(Ljava/lang/String;)V

    const-string/jumbo v1, "0"

    invoke-virtual {v11, v1}, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->setDisableLoginPrepopulate(Ljava/lang/String;)V

    goto/16 :goto_5

    :cond_12
    const-string/jumbo v2, "x-main"

    const-string/jumbo v4, ".amazon.com"

    goto :goto_c

    :cond_13
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mOptions:Landroid/os/Bundle;

    sget-object v3, Lcom/amazon/identity/auth/device/endpoint/TokenRequestHelpers$PROTOCOL;->HTTPS:Lcom/amazon/identity/auth/device/endpoint/TokenRequestHelpers$PROTOCOL;

    invoke-virtual {v11}, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->getHost()Ljava/lang/String;

    move-result-object v4

    invoke-static {v2, v3, v4}, Lcom/amazon/identity/auth/device/endpoint/TokenRequestHelpers;->getRequestUrlSchemeAndAuthority(Landroid/os/Bundle;Lcom/amazon/identity/auth/device/endpoint/TokenRequestHelpers$PROTOCOL;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string/jumbo v2, "/ap/id/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mOptions:Landroid/os/Bundle;

    const-string/jumbo v3, "directedid"

    invoke-virtual {v2, v3}, Landroid/os/Bundle;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v11, v1}, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->setClaimedId(Ljava/lang/String;)V

    goto :goto_d

    .line 286
    :cond_14
    const-string/jumbo v1, "1"

    invoke-virtual {v11, v1}, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->setDisableLoginPrepopulate(Ljava/lang/String;)V

    goto/16 :goto_5

    .line 290
    :pswitch_0
    const/4 v7, 0x1

    move-object/from16 v0, p0

    iput-boolean v7, v0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mBarOn:Z

    if-eqz v8, :cond_17

    const/4 v7, -0x1

    iput v7, v2, Landroid/widget/RelativeLayout$LayoutParams;->width:I

    :goto_e
    const/4 v7, -0x1

    if-eq v7, v6, :cond_18

    invoke-virtual/range {p0 .. p0}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    invoke-virtual {v3, v6}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v3

    new-instance v4, Landroid/graphics/drawable/ClipDrawable;

    const/4 v6, 0x3

    const/4 v7, 0x1

    invoke-direct {v4, v3, v6, v7}, Landroid/graphics/drawable/ClipDrawable;-><init>(Landroid/graphics/drawable/Drawable;II)V

    invoke-virtual {v1, v4}, Landroid/widget/ProgressBar;->setProgressDrawable(Landroid/graphics/drawable/Drawable;)V

    const/4 v4, -0x1

    if-eq v4, v5, :cond_15

    invoke-virtual/range {p0 .. p0}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-virtual {v1, v4}, Landroid/widget/ProgressBar;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    :cond_15
    invoke-virtual {v3}, Landroid/graphics/drawable/Drawable;->getMinimumWidth()I

    move-result v3

    iput v3, v2, Landroid/widget/RelativeLayout$LayoutParams;->width:I

    :cond_16
    :goto_f
    move-object/from16 v0, p0

    invoke-direct {v0, v13}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->setupWebChromeClient(Lcom/amazon/android/webkit/AmazonWebView;)V

    goto/16 :goto_8

    :cond_17
    const/4 v7, -0x2

    iput v7, v2, Landroid/widget/RelativeLayout$LayoutParams;->width:I

    goto :goto_e

    :cond_18
    const/4 v5, -0x1

    if-eq v5, v4, :cond_16

    const/4 v5, -0x1

    if-ne v5, v3, :cond_19

    move v3, v4

    :cond_19
    const/4 v5, 0x2

    new-array v5, v5, [I

    const/4 v6, 0x0

    aput v4, v5, v6

    const/4 v4, 0x1

    aput v3, v5, v4

    new-instance v3, Landroid/graphics/drawable/GradientDrawable;

    sget-object v4, Landroid/graphics/drawable/GradientDrawable$Orientation;->TOP_BOTTOM:Landroid/graphics/drawable/GradientDrawable$Orientation;

    invoke-direct {v3, v4, v5}, Landroid/graphics/drawable/GradientDrawable;-><init>(Landroid/graphics/drawable/GradientDrawable$Orientation;[I)V

    const/4 v4, 0x0

    invoke-virtual {v3, v4}, Landroid/graphics/drawable/GradientDrawable;->setShape(I)V

    const/high16 v4, 0x40a00000    # 5.0f

    invoke-virtual {v3, v4}, Landroid/graphics/drawable/GradientDrawable;->setCornerRadius(F)V

    new-instance v4, Landroid/graphics/drawable/ClipDrawable;

    const/4 v5, 0x3

    const/4 v6, 0x1

    invoke-direct {v4, v3, v5, v6}, Landroid/graphics/drawable/ClipDrawable;-><init>(Landroid/graphics/drawable/Drawable;II)V

    invoke-virtual {v1, v4}, Landroid/widget/ProgressBar;->setProgressDrawable(Landroid/graphics/drawable/Drawable;)V

    invoke-virtual/range {p0 .. p0}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x108006c

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v3

    invoke-virtual {v1, v3}, Landroid/widget/ProgressBar;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    goto :goto_f

    :pswitch_1
    const/4 v3, 0x0

    move-object/from16 v0, p0

    iput-boolean v3, v0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mBarOn:Z

    const/16 v3, 0x8

    invoke-virtual {v1, v3}, Landroid/widget/ProgressBar;->setVisibility(I)V

    goto/16 :goto_8

    :pswitch_2
    if-eqz v7, :cond_1a

    const v3, 0x1010288

    goto/16 :goto_7

    :cond_1a
    const v3, 0x1010079

    goto/16 :goto_7

    :pswitch_3
    if-eqz v7, :cond_1b

    const v3, 0x1010287

    goto/16 :goto_7

    :cond_1b
    const v3, 0x1010077

    goto/16 :goto_7

    :pswitch_4
    if-eqz v7, :cond_1c

    const v3, 0x1010289

    goto/16 :goto_7

    :cond_1c
    const v3, 0x101007a

    goto/16 :goto_7

    :pswitch_5
    const/16 v3, 0xa

    invoke-virtual {v2, v3}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(I)V

    goto/16 :goto_9

    :pswitch_6
    const/16 v3, 0xf

    invoke-virtual {v2, v3}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(I)V

    goto/16 :goto_9

    :pswitch_7
    const/16 v3, 0xc

    invoke-virtual {v2, v3}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(I)V

    goto/16 :goto_9

    :pswitch_8
    const/16 v3, 0x9

    invoke-virtual {v2, v3}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(I)V

    goto/16 :goto_a

    :pswitch_9
    const/16 v3, 0xe

    invoke-virtual {v2, v3}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(I)V

    goto/16 :goto_a

    :pswitch_a
    const/16 v3, 0xb

    invoke-virtual {v2, v3}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(I)V

    goto/16 :goto_a

    .line 291
    :cond_1d
    invoke-virtual {v1, v3}, Landroid/widget/ImageView;->setImageResource(I)V

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_f

    invoke-static {v2}, Landroid/widget/ImageView$ScaleType;->valueOf(Ljava/lang/String;)Landroid/widget/ImageView$ScaleType;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setScaleType(Landroid/widget/ImageView$ScaleType;)V

    goto/16 :goto_b

    .line 323
    :cond_1e
    invoke-virtual {v13}, Lcom/amazon/android/webkit/AmazonWebView;->requestLayout()V
    :try_end_5
    .catch Ljava/lang/IllegalArgumentException; {:try_start_5 .. :try_end_5} :catch_0
    .catch Ljava/lang/NullPointerException; {:try_start_5 .. :try_end_5} :catch_2
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_3

    goto/16 :goto_2

    :cond_1f
    move-object v9, v7

    move-object v15, v8

    move v7, v5

    move v8, v6

    move v5, v1

    move v6, v2

    goto/16 :goto_6

    .line 290
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch

    :pswitch_data_1
    .packed-switch 0x3
        :pswitch_2
        :pswitch_3
        :pswitch_4
    .end packed-switch

    :pswitch_data_2
    .packed-switch 0x1
        :pswitch_5
        :pswitch_5
        :pswitch_5
        :pswitch_6
        :pswitch_6
        :pswitch_6
        :pswitch_7
        :pswitch_7
        :pswitch_7
    .end packed-switch

    :pswitch_data_3
    .packed-switch 0x1
        :pswitch_8
        :pswitch_9
        :pswitch_a
        :pswitch_8
        :pswitch_9
        :pswitch_a
        :pswitch_8
        :pswitch_9
        :pswitch_a
    .end packed-switch
.end method

.method protected onDestroy()V
    .locals 2

    .prologue
    .line 1001
    sget-object v0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->TAG:Ljava/lang/String;

    .line 1004
    iget-object v0, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mTracer:Lcom/amazon/identity/auth/device/framework/Tracer;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/Tracer;->finishTrace()V

    .line 1005
    invoke-super {p0}, Landroid/app/Activity;->onDestroy()V

    .line 1007
    iget-object v0, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mWebView:Lcom/amazon/android/webkit/AmazonWebView;

    if-eqz v0, :cond_0

    .line 1009
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->getParentLayout()Landroid/widget/RelativeLayout;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mWebView:Lcom/amazon/android/webkit/AmazonWebView;

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->removeView(Landroid/view/View;)V

    .line 1010
    iget-object v0, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mWebView:Lcom/amazon/android/webkit/AmazonWebView;

    invoke-virtual {v0}, Lcom/amazon/android/webkit/AmazonWebView;->removeAllViews()V

    .line 1011
    iget-object v0, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mWebView:Lcom/amazon/android/webkit/AmazonWebView;

    invoke-virtual {v0}, Lcom/amazon/android/webkit/AmazonWebView;->destroy()V

    .line 1012
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mWebView:Lcom/amazon/android/webkit/AmazonWebView;

    .line 1015
    :cond_0
    invoke-super {p0}, Landroid/app/Activity;->onDestroy()V

    .line 1016
    return-void
.end method

.method public onKeyDown(ILandroid/view/KeyEvent;)Z
    .locals 3
    .param p1, "keyCode"    # I
    .param p2, "event"    # Landroid/view/KeyEvent;

    .prologue
    .line 1220
    const/4 v1, 0x4

    if-ne p1, v1, :cond_3

    .line 1228
    iget-object v1, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mAuthenticationWebViewClient:Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;->isMFA()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 1230
    sget-object v1, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "MFA canceled"

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 1231
    iget-object v1, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mTracer:Lcom/amazon/identity/auth/device/framework/Tracer;

    const-string/jumbo v2, "MFACanceled"

    invoke-virtual {v1, v2}, Lcom/amazon/identity/auth/device/framework/Tracer;->incrementCounter(Ljava/lang/String;)V

    .line 1233
    :cond_0
    iget-object v1, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mAuthenticationWebViewClient:Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;->isDCQ()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 1235
    sget-object v1, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "DCQ canceled"

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 1236
    iget-object v1, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mTracer:Lcom/amazon/identity/auth/device/framework/Tracer;

    const-string/jumbo v2, "DCQCanceled"

    invoke-virtual {v1, v2}, Lcom/amazon/identity/auth/device/framework/Tracer;->incrementCounter(Ljava/lang/String;)V

    .line 1242
    :cond_1
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->getWebView()Lcom/amazon/android/webkit/AmazonWebView;

    move-result-object v0

    .line 1243
    .local v0, "webView":Lcom/amazon/android/webkit/AmazonWebView;
    if-nez v0, :cond_2

    .line 1245
    sget-object v1, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->UNRECOGNIZED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->value()I

    move-result v1

    const-string/jumbo v2, "An unexpected error occured while setting up the WebView."

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/accounts/AccountsCallbackHelpers;->getErrorBundle(ILjava/lang/String;)Landroid/os/Bundle;

    move-result-object v1

    invoke-direct {p0, v1}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->finishOnError(Landroid/os/Bundle;)V

    .line 1248
    const/4 v1, 0x0

    .line 1258
    .end local v0    # "webView":Lcom/amazon/android/webkit/AmazonWebView;
    :goto_0
    return v1

    .line 1251
    .restart local v0    # "webView":Lcom/amazon/android/webkit/AmazonWebView;
    :cond_2
    invoke-virtual {v0}, Lcom/amazon/android/webkit/AmazonWebView;->canGoBack()Z

    move-result v1

    if-eqz v1, :cond_3

    .line 1253
    invoke-virtual {v0}, Lcom/amazon/android/webkit/AmazonWebView;->goBack()V

    .line 1254
    const/4 v1, 0x1

    goto :goto_0

    .line 1258
    .end local v0    # "webView":Lcom/amazon/android/webkit/AmazonWebView;
    :cond_3
    invoke-super {p0, p1, p2}, Landroid/app/Activity;->onKeyDown(ILandroid/view/KeyEvent;)Z

    move-result v1

    goto :goto_0
.end method

.method protected onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "outState"    # Landroid/os/Bundle;

    .prologue
    .line 1207
    invoke-super {p0, p1}, Landroid/app/Activity;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 1208
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->getWebView()Lcom/amazon/android/webkit/AmazonWebView;

    move-result-object v0

    .line 1209
    invoke-virtual {v0, p1}, Lcom/amazon/android/webkit/AmazonWebView;->saveState(Landroid/os/Bundle;)V

    .line 1210
    return-void
.end method
