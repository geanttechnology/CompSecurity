.class Lcom/amazon/identity/auth/device/AuthPortalUIActivity$2;
.super Ljava/lang/Object;
.source "AuthPortalUIActivity.java"

# interfaces
.implements Lcom/amazon/identity/auth/device/AuthenticationWebViewClient$AuthenticationWebViewClientCallback;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/AuthPortalUIActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/identity/auth/device/AuthPortalUIActivity;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/device/AuthPortalUIActivity;)V
    .locals 0

    .prologue
    .line 1059
    iput-object p1, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity$2;->this$0:Lcom/amazon/identity/auth/device/AuthPortalUIActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCodeEnterFinished()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 1148
    # getter for: Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->access$1800()Ljava/lang/String;

    .line 1149
    iget-object v0, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity$2;->this$0:Lcom/amazon/identity/auth/device/AuthPortalUIActivity;

    # getter for: Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mAuthenticationWebViewClient:Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;
    invoke-static {v0}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->access$900(Lcom/amazon/identity/auth/device/AuthPortalUIActivity;)Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;->isMFA()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity$2;->this$0:Lcom/amazon/identity/auth/device/AuthPortalUIActivity;

    # getter for: Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mMfaChallengeCodeEnterTimer:Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    invoke-static {v0}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->access$1900(Lcom/amazon/identity/auth/device/AuthPortalUIActivity;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 1151
    # getter for: Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->access$1800()Ljava/lang/String;

    .line 1152
    iget-object v0, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity$2;->this$0:Lcom/amazon/identity/auth/device/AuthPortalUIActivity;

    # getter for: Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mMfaChallengeCodeEnterTimer:Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    invoke-static {v0}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->access$1900(Lcom/amazon/identity/auth/device/AuthPortalUIActivity;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->stopAndDiscard()V

    .line 1153
    iget-object v0, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity$2;->this$0:Lcom/amazon/identity/auth/device/AuthPortalUIActivity;

    # setter for: Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mMfaChallengeCodeEnterTimer:Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->access$1902(Lcom/amazon/identity/auth/device/AuthPortalUIActivity;Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    .line 1155
    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity$2;->this$0:Lcom/amazon/identity/auth/device/AuthPortalUIActivity;

    # getter for: Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mAuthenticationWebViewClient:Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;
    invoke-static {v0}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->access$900(Lcom/amazon/identity/auth/device/AuthPortalUIActivity;)Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;->isDCQ()Z

    move-result v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity$2;->this$0:Lcom/amazon/identity/auth/device/AuthPortalUIActivity;

    # getter for: Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mDcqChallengeQuestionEnterTimer:Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    invoke-static {v0}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->access$2000(Lcom/amazon/identity/auth/device/AuthPortalUIActivity;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 1157
    # getter for: Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->access$1800()Ljava/lang/String;

    .line 1158
    iget-object v0, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity$2;->this$0:Lcom/amazon/identity/auth/device/AuthPortalUIActivity;

    # getter for: Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mDcqChallengeQuestionEnterTimer:Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    invoke-static {v0}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->access$2000(Lcom/amazon/identity/auth/device/AuthPortalUIActivity;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->stopAndDiscard()V

    .line 1159
    iget-object v0, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity$2;->this$0:Lcom/amazon/identity/auth/device/AuthPortalUIActivity;

    # setter for: Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mDcqChallengeQuestionEnterTimer:Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->access$2002(Lcom/amazon/identity/auth/device/AuthPortalUIActivity;Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    .line 1161
    :cond_1
    return-void
.end method

.method public onPageFinished()V
    .locals 6

    .prologue
    .line 1108
    iget-object v3, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity$2;->this$0:Lcom/amazon/identity/auth/device/AuthPortalUIActivity;

    const-string/jumbo v4, "apimageview"

    invoke-static {v3, v4}, Lcom/amazon/identity/auth/device/utils/ResourceHelper;->getId(Landroid/content/Context;Ljava/lang/String;)I

    move-result v1

    .line 1109
    .local v1, "imageViewId":I
    iget-object v3, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity$2;->this$0:Lcom/amazon/identity/auth/device/AuthPortalUIActivity;

    invoke-virtual {v3, v1}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 1111
    .local v0, "imageView":Landroid/widget/ImageView;
    iget-object v3, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity$2;->this$0:Lcom/amazon/identity/auth/device/AuthPortalUIActivity;

    # invokes: Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->getWebView()Lcom/amazon/android/webkit/AmazonWebView;
    invoke-static {v3}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->access$1300(Lcom/amazon/identity/auth/device/AuthPortalUIActivity;)Lcom/amazon/android/webkit/AmazonWebView;

    move-result-object v2

    .line 1112
    .local v2, "webView":Lcom/amazon/android/webkit/AmazonWebView;
    if-nez v2, :cond_1

    .line 1114
    iget-object v3, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity$2;->this$0:Lcom/amazon/identity/auth/device/AuthPortalUIActivity;

    sget-object v4, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->UNRECOGNIZED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-virtual {v4}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->value()I

    move-result v4

    const-string/jumbo v5, "An unexpected error occured while setting up the WebView."

    invoke-static {v4, v5}, Lcom/amazon/identity/auth/accounts/AccountsCallbackHelpers;->getErrorBundle(ILjava/lang/String;)Landroid/os/Bundle;

    move-result-object v4

    # invokes: Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->finishOnError(Landroid/os/Bundle;)V
    invoke-static {v3, v4}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->access$300(Lcom/amazon/identity/auth/device/AuthPortalUIActivity;Landroid/os/Bundle;)V

    .line 1143
    :cond_0
    :goto_0
    return-void

    .line 1121
    :cond_1
    invoke-virtual {v0}, Landroid/widget/ImageView;->getVisibility()I

    move-result v3

    if-nez v3, :cond_2

    .line 1123
    const/16 v3, 0x8

    invoke-virtual {v0, v3}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 1125
    :cond_2
    invoke-virtual {v2}, Lcom/amazon/android/webkit/AmazonWebView;->getVisibility()I

    move-result v3

    if-eqz v3, :cond_3

    .line 1127
    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Lcom/amazon/android/webkit/AmazonWebView;->setVisibility(I)V

    .line 1128
    invoke-virtual {v2}, Lcom/amazon/android/webkit/AmazonWebView;->requestFocusFromTouch()Z

    .line 1131
    :cond_3
    iget-object v3, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity$2;->this$0:Lcom/amazon/identity/auth/device/AuthPortalUIActivity;

    const/16 v4, 0x64

    # invokes: Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->setProgressBarProgress(I)V
    invoke-static {v3, v4}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->access$1400(Lcom/amazon/identity/auth/device/AuthPortalUIActivity;I)V

    .line 1132
    iget-object v3, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity$2;->this$0:Lcom/amazon/identity/auth/device/AuthPortalUIActivity;

    # invokes: Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->hideProgressBar()V
    invoke-static {v3}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->access$1500(Lcom/amazon/identity/auth/device/AuthPortalUIActivity;)V

    .line 1133
    iget-object v3, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity$2;->this$0:Lcom/amazon/identity/auth/device/AuthPortalUIActivity;

    # getter for: Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mPageLoadToFirstRenderTimer:Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    invoke-static {v3}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->access$1600(Lcom/amazon/identity/auth/device/AuthPortalUIActivity;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    move-result-object v3

    if-eqz v3, :cond_4

    .line 1135
    iget-object v3, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity$2;->this$0:Lcom/amazon/identity/auth/device/AuthPortalUIActivity;

    # getter for: Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mPageLoadToFirstRenderTimer:Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    invoke-static {v3}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->access$1600(Lcom/amazon/identity/auth/device/AuthPortalUIActivity;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->stopAndDiscard()V

    .line 1139
    :cond_4
    iget-object v3, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity$2;->this$0:Lcom/amazon/identity/auth/device/AuthPortalUIActivity;

    # getter for: Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mFirstPageLoadTimer:Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    invoke-static {v3}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->access$1700(Lcom/amazon/identity/auth/device/AuthPortalUIActivity;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    move-result-object v3

    if-eqz v3, :cond_0

    .line 1141
    iget-object v3, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity$2;->this$0:Lcom/amazon/identity/auth/device/AuthPortalUIActivity;

    # getter for: Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mFirstPageLoadTimer:Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    invoke-static {v3}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->access$1700(Lcom/amazon/identity/auth/device/AuthPortalUIActivity;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->stopAndDiscard()V

    goto :goto_0
.end method

.method public onPageStarted(Ljava/lang/String;)V
    .locals 5
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 1078
    iget-object v1, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity$2;->this$0:Lcom/amazon/identity/auth/device/AuthPortalUIActivity;

    # getter for: Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mFirstOnPageStartedTimer:Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    invoke-static {v1}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->access$700(Lcom/amazon/identity/auth/device/AuthPortalUIActivity;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 1080
    iget-object v1, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity$2;->this$0:Lcom/amazon/identity/auth/device/AuthPortalUIActivity;

    # getter for: Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mFirstOnPageStartedTimer:Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    invoke-static {v1}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->access$700(Lcom/amazon/identity/auth/device/AuthPortalUIActivity;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->stopAndDiscard()V

    .line 1083
    :cond_0
    new-instance v1, Ljava/lang/StringBuilder;

    const-string/jumbo v2, "AuthPortalPageTimeout:"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity$2;->this$0:Lcom/amazon/identity/auth/device/AuthPortalUIActivity;

    # invokes: Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->getRequestTypeFromIntent()Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;
    invoke-static {v2}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->access$800(Lcom/amazon/identity/auth/device/AuthPortalUIActivity;)Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;->name()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 1084
    .local v0, "timeoutMetricsName":Ljava/lang/String;
    iget-object v1, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity$2;->this$0:Lcom/amazon/identity/auth/device/AuthPortalUIActivity;

    # getter for: Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mAuthenticationWebViewClient:Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;
    invoke-static {v1}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->access$900(Lcom/amazon/identity/auth/device/AuthPortalUIActivity;)Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;->isMFA()Z

    move-result v1

    if-eqz v1, :cond_3

    .line 1086
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, ":MFA"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 1092
    :cond_1
    :goto_0
    iget-object v1, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity$2;->this$0:Lcom/amazon/identity/auth/device/AuthPortalUIActivity;

    # setter for: Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mTimeoutMetricsName:Ljava/lang/String;
    invoke-static {v1, v0}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->access$002(Lcom/amazon/identity/auth/device/AuthPortalUIActivity;Ljava/lang/String;)Ljava/lang/String;

    .line 1094
    iget-object v1, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity$2;->this$0:Lcom/amazon/identity/auth/device/AuthPortalUIActivity;

    # getter for: Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mRequestTimeoutTimer:Ljava/util/Timer;
    invoke-static {v1}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->access$1000(Lcom/amazon/identity/auth/device/AuthPortalUIActivity;)Ljava/util/Timer;

    move-result-object v1

    if-eqz v1, :cond_2

    .line 1097
    iget-object v1, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity$2;->this$0:Lcom/amazon/identity/auth/device/AuthPortalUIActivity;

    # getter for: Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mRequestTimeoutTimer:Ljava/util/Timer;
    invoke-static {v1}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->access$1000(Lcom/amazon/identity/auth/device/AuthPortalUIActivity;)Ljava/util/Timer;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/Timer;->cancel()V

    .line 1099
    :cond_2
    iget-object v1, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity$2;->this$0:Lcom/amazon/identity/auth/device/AuthPortalUIActivity;

    new-instance v2, Ljava/util/Timer;

    invoke-direct {v2}, Ljava/util/Timer;-><init>()V

    # setter for: Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mRequestTimeoutTimer:Ljava/util/Timer;
    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->access$1002(Lcom/amazon/identity/auth/device/AuthPortalUIActivity;Ljava/util/Timer;)Ljava/util/Timer;

    .line 1100
    iget-object v1, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity$2;->this$0:Lcom/amazon/identity/auth/device/AuthPortalUIActivity;

    # getter for: Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mRequestTimeoutTimer:Ljava/util/Timer;
    invoke-static {v1}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->access$1000(Lcom/amazon/identity/auth/device/AuthPortalUIActivity;)Ljava/util/Timer;

    move-result-object v1

    new-instance v2, Lcom/amazon/identity/auth/device/AuthPortalUIActivity$TimeoutTimerTask;

    iget-object v3, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity$2;->this$0:Lcom/amazon/identity/auth/device/AuthPortalUIActivity;

    const/4 v4, 0x0

    invoke-direct {v2, v3, v4}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity$TimeoutTimerTask;-><init>(Lcom/amazon/identity/auth/device/AuthPortalUIActivity;Lcom/amazon/identity/auth/device/AuthPortalUIActivity$1;)V

    const-wide/32 v3, 0x3d090

    invoke-virtual {v1, v2, v3, v4}, Ljava/util/Timer;->schedule(Ljava/util/TimerTask;J)V

    .line 1102
    iget-object v1, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity$2;->this$0:Lcom/amazon/identity/auth/device/AuthPortalUIActivity;

    invoke-static {v1}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->access$1200(Lcom/amazon/identity/auth/device/AuthPortalUIActivity;)V

    .line 1103
    return-void

    .line 1088
    :cond_3
    iget-object v1, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity$2;->this$0:Lcom/amazon/identity/auth/device/AuthPortalUIActivity;

    # getter for: Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->mAuthenticationWebViewClient:Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;
    invoke-static {v1}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->access$900(Lcom/amazon/identity/auth/device/AuthPortalUIActivity;)Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/AuthenticationWebViewClient;->isDCQ()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 1090
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, ":DCQ"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public setError(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "errorBundle"    # Landroid/os/Bundle;

    .prologue
    .line 1071
    iget-object v0, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity$2;->this$0:Lcom/amazon/identity/auth/device/AuthPortalUIActivity;

    invoke-static {v0}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->access$600(Lcom/amazon/identity/auth/device/AuthPortalUIActivity;)V

    .line 1072
    iget-object v0, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity$2;->this$0:Lcom/amazon/identity/auth/device/AuthPortalUIActivity;

    # invokes: Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->finishOnError(Landroid/os/Bundle;)V
    invoke-static {v0, p1}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->access$300(Lcom/amazon/identity/auth/device/AuthPortalUIActivity;Landroid/os/Bundle;)V

    .line 1073
    return-void
.end method

.method public setResult(Lcom/amazon/identity/auth/device/endpoint/OpenIdResponse;)V
    .locals 1
    .param p1, "response"    # Lcom/amazon/identity/auth/device/endpoint/OpenIdResponse;

    .prologue
    .line 1065
    iget-object v0, p0, Lcom/amazon/identity/auth/device/AuthPortalUIActivity$2;->this$0:Lcom/amazon/identity/auth/device/AuthPortalUIActivity;

    invoke-static {v0, p1}, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;->access$500(Lcom/amazon/identity/auth/device/AuthPortalUIActivity;Lcom/amazon/identity/auth/device/endpoint/OpenIdResponse;)V

    .line 1066
    return-void
.end method
