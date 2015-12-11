.class Lcom/amazon/mShop/search/viewit/ViewItActivity$6;
.super Ljava/lang/Object;
.source "ViewItActivity.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/services/mShop/RecognizeAuthenticityCodeResponseListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/search/viewit/ViewItActivity;->handleDataMatrixCode(Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/search/viewit/ViewItActivity;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/search/viewit/ViewItActivity;)V
    .locals 0

    .prologue
    .line 910
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity$6;->this$0:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public cancelled(Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 1
    .param p1, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 956
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity$6;->this$0:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->enableLoading()V

    .line 957
    return-void
.end method

.method public completed(Lcom/amazon/rio/j2me/client/services/mShop/RecognizeAuthenticityCodeResponse;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 7
    .param p1, "value"    # Lcom/amazon/rio/j2me/client/services/mShop/RecognizeAuthenticityCodeResponse;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    const-wide/16 v5, 0x64

    const/4 v4, 0x1

    .line 913
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/RecognizeAuthenticityCodeResponse;->getCodeType()Ljava/lang/String;

    move-result-object v0

    .line 914
    .local v0, "codeType":Ljava/lang/String;
    const-string/jumbo v2, "public"

    invoke-virtual {v2, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 916
    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity$6;->this$0:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    invoke-static {v2, v5, v6}, Lcom/amazon/mShop/util/UIUtils;->vibrate(Landroid/content/Context;J)V

    .line 917
    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity$6;->this$0:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    # setter for: Lcom/amazon/mShop/search/viewit/ViewItActivity;->publicAuthCodeScanned:Z
    invoke-static {v2, v4}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->access$502(Lcom/amazon/mShop/search/viewit/ViewItActivity;Z)Z

    .line 918
    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity$6;->this$0:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItActivity;->mViewItMetricHelper:Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;
    invoke-static {v2}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->access$100(Lcom/amazon/mShop/search/viewit/ViewItActivity;)Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;

    move-result-object v2

    const-string/jumbo v3, "PublicCodeSession"

    invoke-virtual {v2, v3, v4}, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->logCountMetricsPerSession(Ljava/lang/String;I)V

    .line 920
    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity$6;->this$0:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItActivity;->mPhotoCaptureView:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;
    invoke-static {v2}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->access$000(Lcom/amazon/mShop/search/viewit/ViewItActivity;)Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->getViewItDialogHelper()Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->clearErrorWindow()V

    .line 921
    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity$6;->this$0:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    # invokes: Lcom/amazon/mShop/search/viewit/ViewItActivity;->showPublicDataMatrixCodeInfoDialog()V
    invoke-static {v2}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->access$600(Lcom/amazon/mShop/search/viewit/ViewItActivity;)V

    .line 937
    :goto_0
    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity$6;->this$0:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    const/4 v3, 0x0

    # setter for: Lcom/amazon/mShop/search/viewit/ViewItActivity;->mDataMatrixCodes:Ljava/util/List;
    invoke-static {v2, v3}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->access$802(Lcom/amazon/mShop/search/viewit/ViewItActivity;Ljava/util/List;)Ljava/util/List;

    .line 938
    return-void

    .line 922
    :cond_0
    const-string/jumbo v2, "private"

    invoke-virtual {v2, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 924
    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity$6;->this$0:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    invoke-static {v2, v5, v6}, Lcom/amazon/mShop/util/UIUtils;->vibrate(Landroid/content/Context;J)V

    .line 925
    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity$6;->this$0:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    # setter for: Lcom/amazon/mShop/search/viewit/ViewItActivity;->privateAuthCodeScanned:Z
    invoke-static {v2, v4}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->access$702(Lcom/amazon/mShop/search/viewit/ViewItActivity;Z)Z

    .line 926
    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity$6;->this$0:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItActivity;->mViewItMetricHelper:Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;
    invoke-static {v2}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->access$100(Lcom/amazon/mShop/search/viewit/ViewItActivity;)Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;

    move-result-object v2

    const-string/jumbo v3, "PrivateCodeSession"

    invoke-virtual {v2, v3, v4}, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->logCountMetricsPerSession(Ljava/lang/String;I)V

    .line 927
    const-string/jumbo v2, "fl_dm_pri_succ"

    invoke-static {v2}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 930
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/RecognizeAuthenticityCodeResponse;->getLandingUrl()Ljava/lang/String;

    move-result-object v1

    .line 931
    .local v1, "url":Ljava/lang/String;
    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity$6;->this$0:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    invoke-static {v2, v1}, Lcom/amazon/mShop/util/WebUtils;->openWebview(Landroid/content/Context;Ljava/lang/String;)V

    goto :goto_0

    .line 933
    .end local v1    # "url":Ljava/lang/String;
    :cond_1
    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity$6;->this$0:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItActivity;->mViewItMetricHelper:Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;
    invoke-static {v2}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->access$100(Lcom/amazon/mShop/search/viewit/ViewItActivity;)Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;

    move-result-object v2

    const-string/jumbo v3, "UnknownCodeSession"

    invoke-virtual {v2, v3, v4}, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->logCountMetricsPerSession(Ljava/lang/String;I)V

    goto :goto_0
.end method

.method public error(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 4
    .param p1, "e"    # Ljava/lang/Exception;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 942
    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity$6;->this$0:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    invoke-virtual {v2}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->enableLoading()V

    .line 943
    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity$6;->this$0:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    invoke-virtual {v2}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/amazon/mShop/android/lib/R$string;->view_it_error_server_return_error:I

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 944
    .local v1, "errorMsg":Ljava/lang/String;
    sget-object v0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;->ERROR_FLOW_SERVER:Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;

    .line 945
    .local v0, "errorDialogType":Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v2

    new-instance v3, Lcom/amazon/mShop/search/viewit/ViewItActivity$6$1;

    invoke-direct {v3, p0, v1, v0}, Lcom/amazon/mShop/search/viewit/ViewItActivity$6$1;-><init>(Lcom/amazon/mShop/search/viewit/ViewItActivity$6;Ljava/lang/String;Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;)V

    invoke-interface {v2, v3}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 952
    return-void
.end method
