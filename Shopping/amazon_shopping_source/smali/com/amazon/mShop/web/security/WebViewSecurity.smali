.class public Lcom/amazon/mShop/web/security/WebViewSecurity;
.super Ljava/lang/Object;
.source "WebViewSecurity.java"


# static fields
.field private static final DEBUG:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 30
    invoke-static {}, Lcom/amazon/mShop/debug/DebugSettings;->isDebugEnabled()Z

    move-result v0

    sput-boolean v0, Lcom/amazon/mShop/web/security/WebViewSecurity;->DEBUG:Z

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 28
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$000()Z
    .locals 1

    .prologue
    .line 28
    sget-boolean v0, Lcom/amazon/mShop/web/security/WebViewSecurity;->DEBUG:Z

    return v0
.end method

.method public static isHTTPUrl(Ljava/lang/String;)Z
    .locals 1
    .param p0, "url"    # Ljava/lang/String;

    .prologue
    .line 46
    invoke-static {p0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 47
    invoke-static {}, Lcom/amazon/mShop/platform/AppLocale;->getInstance()Lcom/amazon/mShop/platform/AppLocale;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/platform/AppLocale;->getCurrentLocale()Ljava/util/Locale;

    move-result-object v0

    invoke-virtual {p0, v0}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object p0

    .line 48
    const-string/jumbo v0, "http://"

    invoke-virtual {p0, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 49
    const/4 v0, 0x1

    .line 52
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static logMetricsForHTTPRequest(Ljava/lang/String;Ljava/lang/String;Z)V
    .locals 8
    .param p0, "currentUrl"    # Ljava/lang/String;
    .param p1, "requestUrl"    # Ljava/lang/String;
    .param p2, "blocked"    # Z

    .prologue
    .line 56
    new-instance v0, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;

    invoke-direct {v0}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;-><init>()V

    .line 57
    .local v0, "clientMetrics":Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;
    new-instance v2, Lorg/json/JSONObject;

    invoke-direct {v2}, Lorg/json/JSONObject;-><init>()V

    .line 61
    .local v2, "info":Lorg/json/JSONObject;
    :try_start_0
    const-string/jumbo v5, "referrer"

    invoke-static {p0}, Landroid/net/Uri;->encode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v2, v5, v6}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 63
    const-string/jumbo v5, "url"

    invoke-static {p1}, Landroid/net/Uri;->encode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v2, v5, v6}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 65
    const-string/jumbo v5, "blocked"

    invoke-virtual {v2, v5, p2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Z)Lorg/json/JSONObject;

    .line 67
    sget-boolean v5, Lcom/amazon/mShop/web/security/WebViewSecurity;->DEBUG:Z

    if-eqz v5, :cond_0

    const-string/jumbo v5, "WebViewSecurity"

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v7, "info: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v2}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 69
    :cond_0
    new-instance v3, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;

    invoke-direct {v3}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;-><init>()V

    .line 70
    .local v3, "metric":Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;
    const-string/jumbo v5, "BlockedHTTPPage"

    invoke-virtual {v3, v5}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;->setName(Ljava/lang/String;)V

    .line 71
    invoke-virtual {v2}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v5}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;->setInfo(Ljava/lang/String;)V

    .line 73
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    .line 74
    .local v4, "metrics":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;>;"
    invoke-interface {v4, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 75
    invoke-virtual {v0, v4}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;->setMetrics(Ljava/util/List;)V

    .line 76
    invoke-static {v0}, Lcom/amazon/mShop/web/security/WebViewSecurity;->postMetrics(Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 80
    .end local v3    # "metric":Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;
    .end local v4    # "metrics":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;>;"
    :goto_0
    return-void

    .line 77
    :catch_0
    move-exception v1

    .line 78
    .local v1, "e":Lorg/json/JSONException;
    const-string/jumbo v5, "WebViewSecurity"

    const-string/jumbo v6, ""

    invoke-static {v5, v6, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method

.method private static postMetrics(Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;)V
    .locals 2
    .param p0, "clientMetrics"    # Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;

    .prologue
    .line 87
    new-instance v0, Lcom/amazon/mShop/web/security/WebViewSecurity$1;

    invoke-direct {v0}, Lcom/amazon/mShop/web/security/WebViewSecurity$1;-><init>()V

    .line 101
    .local v0, "postMetricsResponseListener":Lcom/amazon/rio/j2me/client/services/mShop/PostMetricsResponseListener;
    invoke-static {}, Lcom/amazon/mShop/control/ServiceController;->getMShopService()Lcom/amazon/rio/j2me/client/services/mShop/MShopService;

    move-result-object v1

    invoke-interface {v1, p0, v0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopService;->postMetrics(Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;Lcom/amazon/rio/j2me/client/services/mShop/PostMetricsResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .line 102
    return-void
.end method

.method public static shouldBlockWebViewLoading(Landroid/webkit/WebView;Ljava/lang/String;)Z
    .locals 1
    .param p0, "webView"    # Landroid/webkit/WebView;
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 41
    invoke-static {p1}, Lcom/amazon/mShop/web/security/WebViewSecurity;->isHTTPUrl(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-static {}, Lcom/amazon/mShop/util/ActivityUtils;->isBlockHttpEnabled()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
