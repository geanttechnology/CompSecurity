.class public Lcom/amazon/mShop/util/AmazonErrorUtils;
.super Ljava/lang/Object;
.source "AmazonErrorUtils.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static postExceptionToServer(Landroid/content/Context;Ljava/lang/Exception;)V
    .locals 1
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "e"    # Ljava/lang/Exception;

    .prologue
    .line 168
    sget v0, Lcom/amazon/mShop/android/lib/R$bool;->config_reportErrorExceptionMetricsToPmet:I

    invoke-static {p0, v0}, Lcom/amazon/mShop/util/ConfigUtils;->isEnabledForApp(Landroid/content/Context;I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 169
    invoke-static {p1}, Lcom/amazon/mShop/net/ErrorExceptionMetricsObserver;->logMetric(Ljava/lang/Exception;)V

    .line 171
    :cond_0
    return-void
.end method

.method public static postWebViewError(ILjava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p0, "errorCode"    # I
    .param p1, "description"    # Ljava/lang/String;
    .param p2, "failingUrl"    # Ljava/lang/String;

    .prologue
    .line 284
    new-instance v0, Lcom/amazon/mShop/net/WebViewErrorException;

    invoke-direct {v0, p0, p1, p2}, Lcom/amazon/mShop/net/WebViewErrorException;-><init>(ILjava/lang/String;Ljava/lang/String;)V

    .line 285
    .local v0, "error":Lcom/amazon/mShop/net/WebViewErrorException;
    invoke-static {v0}, Lcom/amazon/mShop/net/ErrorExceptionMetricsObserver;->logMetric(Ljava/lang/Exception;)V

    .line 286
    return-void
.end method

.method public static reportError(Lcom/amazon/mShop/AmazonActivity;ILcom/amazon/mShop/error/AmazonErrorBox$AmazonErrorBoxActionListener;Landroid/view/View;)V
    .locals 6
    .param p0, "amazonActivity"    # Lcom/amazon/mShop/AmazonActivity;
    .param p1, "errorId"    # I
    .param p2, "listener"    # Lcom/amazon/mShop/error/AmazonErrorBox$AmazonErrorBoxActionListener;
    .param p3, "reportOnView"    # Landroid/view/View;

    .prologue
    const/4 v4, 0x0

    .line 193
    move-object v0, p0

    move v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v5, v4

    invoke-static/range {v0 .. v5}, Lcom/amazon/mShop/util/AmazonErrorUtils;->reportError(Lcom/amazon/mShop/AmazonActivity;ILcom/amazon/mShop/error/AmazonErrorBox$AmazonErrorBoxActionListener;Landroid/view/View;Ljava/lang/String;Ljava/lang/String;)V

    .line 194
    return-void
.end method

.method public static reportError(Lcom/amazon/mShop/AmazonActivity;ILcom/amazon/mShop/error/AmazonErrorBox$AmazonErrorBoxActionListener;Landroid/view/View;II)V
    .locals 6
    .param p0, "amazonActivity"    # Lcom/amazon/mShop/AmazonActivity;
    .param p1, "errorId"    # I
    .param p2, "listener"    # Lcom/amazon/mShop/error/AmazonErrorBox$AmazonErrorBoxActionListener;
    .param p3, "reportOnView"    # Landroid/view/View;
    .param p4, "messageId"    # I
    .param p5, "buttonTextId"    # I

    .prologue
    .line 221
    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0, p4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0, p5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    move-object v0, p0

    move v1, p1

    move-object v2, p2

    move-object v3, p3

    invoke-static/range {v0 .. v5}, Lcom/amazon/mShop/util/AmazonErrorUtils;->reportError(Lcom/amazon/mShop/AmazonActivity;ILcom/amazon/mShop/error/AmazonErrorBox$AmazonErrorBoxActionListener;Landroid/view/View;Ljava/lang/String;Ljava/lang/String;)V

    .line 224
    return-void
.end method

.method public static reportError(Lcom/amazon/mShop/AmazonActivity;ILcom/amazon/mShop/error/AmazonErrorBox$AmazonErrorBoxActionListener;Landroid/view/View;Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p0, "amazonActivity"    # Lcom/amazon/mShop/AmazonActivity;
    .param p1, "errorId"    # I
    .param p2, "listener"    # Lcom/amazon/mShop/error/AmazonErrorBox$AmazonErrorBoxActionListener;
    .param p3, "reportOnView"    # Landroid/view/View;
    .param p4, "message"    # Ljava/lang/String;
    .param p5, "buttonText"    # Ljava/lang/String;

    .prologue
    .line 250
    new-instance v0, Lcom/amazon/mShop/error/AmazonErrorInfo;

    invoke-direct {v0, p1, p2, p4, p5}, Lcom/amazon/mShop/error/AmazonErrorInfo;-><init>(ILcom/amazon/mShop/error/AmazonErrorBox$AmazonErrorBoxActionListener;Ljava/lang/String;Ljava/lang/String;)V

    .line 251
    .local v0, "errorInfo":Lcom/amazon/mShop/error/AmazonErrorInfo;
    invoke-static {p0, v0, p3}, Lcom/amazon/mShop/util/AmazonErrorUtils;->reportError(Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/mShop/error/AmazonErrorInfo;Landroid/view/View;)V

    .line 252
    return-void
.end method

.method public static reportError(Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/mShop/error/AmazonErrorInfo;Landroid/view/View;)V
    .locals 1
    .param p0, "amazonActivity"    # Lcom/amazon/mShop/AmazonActivity;
    .param p1, "errorInfo"    # Lcom/amazon/mShop/error/AmazonErrorInfo;
    .param p2, "reportOnView"    # Landroid/view/View;

    .prologue
    .line 269
    invoke-static {p0, p1}, Lcom/amazon/mShop/util/UIUtils;->createErrorBox(Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/mShop/error/AmazonErrorInfo;)Lcom/amazon/mShop/error/AmazonErrorBox;

    move-result-object v0

    invoke-virtual {p0, p1, v0, p2}, Lcom/amazon/mShop/AmazonActivity;->reportErrorOnView(Lcom/amazon/mShop/error/AmazonErrorInfo;Lcom/amazon/mShop/error/AmazonErrorBox;Landroid/view/View;)V

    .line 271
    return-void
.end method

.method public static reportErrorWithGeneralErrorMessageAndGoToAmazonHome(Lcom/amazon/mShop/AmazonActivity;I)V
    .locals 6
    .param p0, "amazonActivity"    # Lcom/amazon/mShop/AmazonActivity;
    .param p1, "errorCode"    # I

    .prologue
    .line 76
    new-instance v2, Lcom/amazon/mShop/util/AmazonErrorUtils$2;

    invoke-direct {v2, p0}, Lcom/amazon/mShop/util/AmazonErrorUtils$2;-><init>(Lcom/amazon/mShop/AmazonActivity;)V

    .line 83
    .local v2, "listener":Lcom/amazon/mShop/error/AmazonErrorBox$AmazonErrorBoxActionListener;
    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonActivity;->getCurrentView()Landroid/view/View;

    move-result-object v3

    sget v4, Lcom/amazon/mShop/android/lib/R$string;->error_something_wrong_will_fix_message:I

    sget v5, Lcom/amazon/mShop/android/lib/R$string;->go_to_amazon_home:I

    move-object v0, p0

    move v1, p1

    invoke-static/range {v0 .. v5}, Lcom/amazon/mShop/util/AmazonErrorUtils;->reportError(Lcom/amazon/mShop/AmazonActivity;ILcom/amazon/mShop/error/AmazonErrorBox$AmazonErrorBoxActionListener;Landroid/view/View;II)V

    .line 91
    return-void
.end method

.method public static reportMShopServerError(Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/mShop/error/AmazonErrorBox$AmazonErrorBoxActionListener;Landroid/view/View;Ljava/lang/Exception;)V
    .locals 4
    .param p0, "amazonActivity"    # Lcom/amazon/mShop/AmazonActivity;
    .param p1, "listener"    # Lcom/amazon/mShop/error/AmazonErrorBox$AmazonErrorBoxActionListener;
    .param p2, "reportOnView"    # Landroid/view/View;
    .param p3, "e"    # Ljava/lang/Exception;

    .prologue
    const/4 v3, 0x0

    .line 115
    instance-of v1, p3, Lcom/amazon/rio/j2me/client/services/ApplicationException;

    if-eqz v1, :cond_1

    move-object v0, p3

    .line 116
    check-cast v0, Lcom/amazon/rio/j2me/client/services/ApplicationException;

    .line 117
    .local v0, "ae":Lcom/amazon/rio/j2me/client/services/ApplicationException;
    sget-object v1, Lcom/amazon/rio/j2me/client/services/ApplicationException;->CLIENT_UPGRADE_REQUIRED:Ljava/lang/String;

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/ApplicationException;->getErrorCode()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 118
    invoke-static {p0}, Lcom/amazon/mShop/util/UpgradeUtil;->showForceUpdateDialog(Landroid/content/Context;)V

    .line 125
    .end local v0    # "ae":Lcom/amazon/rio/j2me/client/services/ApplicationException;
    :goto_0
    return-void

    .line 120
    .restart local v0    # "ae":Lcom/amazon/rio/j2me/client/services/ApplicationException;
    :cond_0
    sget v1, Lcom/amazon/mShop/android/lib/R$string;->ok:I

    invoke-virtual {p0, v1}, Lcom/amazon/mShop/AmazonActivity;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {p0, v3, p2, p3, v1}, Lcom/amazon/mShop/util/AmazonErrorUtils;->reportMShopServerError(Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/mShop/error/AmazonErrorBox$AmazonErrorBoxActionListener;Landroid/view/View;Ljava/lang/Exception;Ljava/lang/String;)V

    goto :goto_0

    .line 123
    .end local v0    # "ae":Lcom/amazon/rio/j2me/client/services/ApplicationException;
    :cond_1
    invoke-static {p0, p1, p2, p3, v3}, Lcom/amazon/mShop/util/AmazonErrorUtils;->reportMShopServerError(Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/mShop/error/AmazonErrorBox$AmazonErrorBoxActionListener;Landroid/view/View;Ljava/lang/Exception;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public static reportMShopServerError(Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/mShop/error/AmazonErrorBox$AmazonErrorBoxActionListener;Landroid/view/View;Ljava/lang/Exception;Ljava/lang/String;)V
    .locals 6
    .param p0, "amazonActivity"    # Lcom/amazon/mShop/AmazonActivity;
    .param p1, "listener"    # Lcom/amazon/mShop/error/AmazonErrorBox$AmazonErrorBoxActionListener;
    .param p2, "reportOnView"    # Landroid/view/View;
    .param p3, "e"    # Ljava/lang/Exception;
    .param p4, "buttonText"    # Ljava/lang/String;

    .prologue
    .line 150
    const/4 v1, 0x1

    .line 151
    .local v1, "errorCode":I
    const/4 v4, 0x0

    .line 152
    .local v4, "message":Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/net/NetInfo;->hasNetworkConnection()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 153
    const/4 v1, 0x4

    .line 154
    invoke-static {p0, p3}, Lcom/amazon/mShop/util/UIUtils;->getMessageForException(Landroid/content/Context;Ljava/lang/Exception;)Ljava/lang/String;

    move-result-object v4

    :cond_0
    move-object v0, p0

    move-object v2, p1

    move-object v3, p2

    move-object v5, p4

    .line 157
    invoke-static/range {v0 .. v5}, Lcom/amazon/mShop/util/AmazonErrorUtils;->reportError(Lcom/amazon/mShop/AmazonActivity;ILcom/amazon/mShop/error/AmazonErrorBox$AmazonErrorBoxActionListener;Landroid/view/View;Ljava/lang/String;Ljava/lang/String;)V

    .line 159
    invoke-static {p0, p3}, Lcom/amazon/mShop/util/AmazonErrorUtils;->postExceptionToServer(Landroid/content/Context;Ljava/lang/Exception;)V

    .line 160
    return-void
.end method

.method public static reportWebViewClientError(Lcom/amazon/mShop/AmazonActivity;Landroid/webkit/WebView;Landroid/view/View;)V
    .locals 0
    .param p0, "amazonActivity"    # Lcom/amazon/mShop/AmazonActivity;
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "reportOnView"    # Landroid/view/View;

    .prologue
    .line 33
    invoke-static {p0, p1, p2}, Lcom/amazon/mShop/util/AmazonErrorUtils;->showWebPageRetryDialog(Lcom/amazon/mShop/AmazonActivity;Landroid/webkit/WebView;Landroid/view/View;)V

    .line 34
    return-void
.end method

.method public static showWebPageRetryDialog(Lcom/amazon/mShop/AmazonActivity;Landroid/webkit/WebView;Landroid/view/View;)V
    .locals 3
    .param p0, "amazonActivity"    # Lcom/amazon/mShop/AmazonActivity;
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "reportOnView"    # Landroid/view/View;

    .prologue
    .line 53
    invoke-static {}, Lcom/amazon/mShop/net/NetInfo;->hasNetworkConnection()Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v0, 0x2

    .line 56
    .local v0, "errorCode":I
    :goto_0
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v1

    new-instance v2, Lcom/amazon/mShop/util/AmazonErrorUtils$1;

    invoke-direct {v2, p0, v0, p1, p2}, Lcom/amazon/mShop/util/AmazonErrorUtils$1;-><init>(Lcom/amazon/mShop/AmazonActivity;ILandroid/webkit/WebView;Landroid/view/View;)V

    invoke-interface {v1, v2}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 73
    return-void

    .line 53
    .end local v0    # "errorCode":I
    :cond_0
    const/4 v0, 0x1

    goto :goto_0
.end method
