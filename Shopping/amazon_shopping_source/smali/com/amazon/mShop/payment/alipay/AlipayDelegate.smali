.class public Lcom/amazon/mShop/payment/alipay/AlipayDelegate;
.super Ljava/lang/Object;
.source "AlipayDelegate.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/payment/alipay/AlipayDelegate$Factory;
    }
.end annotation


# static fields
.field private static final SINGLETON_INSTANCE:Lcom/amazon/mShop/payment/alipay/AlipayDelegate;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 16
    new-instance v0, Lcom/amazon/mShop/payment/alipay/AlipayDelegate;

    invoke-direct {v0}, Lcom/amazon/mShop/payment/alipay/AlipayDelegate;-><init>()V

    sput-object v0, Lcom/amazon/mShop/payment/alipay/AlipayDelegate;->SINGLETON_INSTANCE:Lcom/amazon/mShop/payment/alipay/AlipayDelegate;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 18
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 20
    return-void
.end method

.method static synthetic access$000()Lcom/amazon/mShop/payment/alipay/AlipayDelegate;
    .locals 1

    .prologue
    .line 14
    sget-object v0, Lcom/amazon/mShop/payment/alipay/AlipayDelegate;->SINGLETON_INSTANCE:Lcom/amazon/mShop/payment/alipay/AlipayDelegate;

    return-object v0
.end method

.method static synthetic access$100(Lcom/amazon/mShop/payment/alipay/AlipayDelegate;Lcom/amazon/mShop/web/MShopWebActivity;Ljava/lang/String;Lcom/amazon/mShop/payment/alipay/AlipayAdapterStatus;Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/payment/alipay/AlipayDelegate;
    .param p1, "x1"    # Lcom/amazon/mShop/web/MShopWebActivity;
    .param p2, "x2"    # Ljava/lang/String;
    .param p3, "x3"    # Lcom/amazon/mShop/payment/alipay/AlipayAdapterStatus;
    .param p4, "x4"    # Ljava/lang/String;

    .prologue
    .line 14
    invoke-direct {p0, p1, p2, p3, p4}, Lcom/amazon/mShop/payment/alipay/AlipayDelegate;->navigateBackFromAlipay(Lcom/amazon/mShop/web/MShopWebActivity;Ljava/lang/String;Lcom/amazon/mShop/payment/alipay/AlipayAdapterStatus;Ljava/lang/String;)V

    return-void
.end method

.method private navigateBackFromAlipay(Lcom/amazon/mShop/web/MShopWebActivity;Ljava/lang/String;Lcom/amazon/mShop/payment/alipay/AlipayAdapterStatus;Ljava/lang/String;)V
    .locals 6
    .param p1, "activity"    # Lcom/amazon/mShop/web/MShopWebActivity;
    .param p2, "returnUrl"    # Ljava/lang/String;
    .param p3, "status"    # Lcom/amazon/mShop/payment/alipay/AlipayAdapterStatus;
    .param p4, "result"    # Ljava/lang/String;

    .prologue
    .line 119
    move-object v0, p2

    .line 120
    .local v0, "newUrl":Ljava/lang/String;
    sget-object v5, Lcom/amazon/mShop/payment/alipay/AlipayAdapterStatus;->SERVICE_INVOKE_SUCCESS:Lcom/amazon/mShop/payment/alipay/AlipayAdapterStatus;

    invoke-virtual {v5, p3}, Lcom/amazon/mShop/payment/alipay/AlipayAdapterStatus;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_3

    invoke-static {}, Lcom/amazon/mShop/payment/alipay/AlipayAdapter$Factory;->getInstance()Lcom/amazon/mShop/payment/alipay/AlipayAdapter;

    move-result-object v5

    invoke-virtual {v5, p4}, Lcom/amazon/mShop/payment/alipay/AlipayAdapter;->isPaymentSuccess(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_3

    .line 124
    invoke-static {}, Lcom/amazon/mShop/payment/alipay/AlipayAdapter$Factory;->getInstance()Lcom/amazon/mShop/payment/alipay/AlipayAdapter;

    move-result-object v5

    invoke-virtual {v5, p4}, Lcom/amazon/mShop/payment/alipay/AlipayAdapter;->getResultAsUriQueryParam(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 125
    .local v3, "resultParam":Ljava/lang/String;
    invoke-static {v3}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_1

    .line 133
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1, p2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 134
    .local v1, "newUrlBuilder":Ljava/lang/StringBuilder;
    const/4 v2, 0x0

    .line 135
    .local v2, "originalQuery":Ljava/lang/String;
    invoke-static {p2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    .line 136
    .local v4, "uri":Landroid/net/Uri;
    if-eqz v4, :cond_0

    .line 137
    invoke-virtual {v4}, Landroid/net/Uri;->getQuery()Ljava/lang/String;

    move-result-object v2

    .line 139
    :cond_0
    invoke-static {v2}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_2

    .line 140
    const-string/jumbo v5, "?"

    invoke-virtual {v1, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 144
    :goto_0
    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 145
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 149
    .end local v1    # "newUrlBuilder":Ljava/lang/StringBuilder;
    .end local v2    # "originalQuery":Ljava/lang/String;
    .end local v4    # "uri":Landroid/net/Uri;
    :cond_1
    invoke-virtual {p1}, Lcom/amazon/mShop/web/MShopWebActivity;->getWebView()Landroid/webkit/WebView;

    move-result-object v5

    invoke-virtual {v5, v0}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    .line 155
    .end local v3    # "resultParam":Ljava/lang/String;
    :goto_1
    return-void

    .line 142
    .restart local v1    # "newUrlBuilder":Ljava/lang/StringBuilder;
    .restart local v2    # "originalQuery":Ljava/lang/String;
    .restart local v3    # "resultParam":Ljava/lang/String;
    .restart local v4    # "uri":Landroid/net/Uri;
    :cond_2
    const-string/jumbo v5, "&"

    invoke-virtual {v1, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0

    .line 153
    .end local v1    # "newUrlBuilder":Ljava/lang/StringBuilder;
    .end local v2    # "originalQuery":Ljava/lang/String;
    .end local v3    # "resultParam":Ljava/lang/String;
    .end local v4    # "uri":Landroid/net/Uri;
    :cond_3
    invoke-static {p1}, Lcom/amazon/mShop/util/ActivityUtils;->startHomeActivity(Landroid/content/Context;)Z

    goto :goto_1
.end method


# virtual methods
.method public payWithAlipay(Lcom/amazon/mShop/web/MShopWebActivity;Ljava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p1, "activity"    # Lcom/amazon/mShop/web/MShopWebActivity;
    .param p2, "orderInfo"    # Ljava/lang/String;
    .param p3, "returnUrl"    # Ljava/lang/String;

    .prologue
    .line 64
    if-eqz p1, :cond_1

    invoke-static {p2}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    invoke-static {p3}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 100
    :cond_0
    :goto_0
    return-void

    .line 72
    :cond_1
    const/4 v1, 0x1

    invoke-virtual {p1, v1}, Lcom/amazon/mShop/web/MShopWebActivity;->setSkipStopBehavior(Z)V

    .line 74
    sget-object v0, Lcom/amazon/mShop/payment/alipay/AlipayAdapterStatus;->UNDEFINED:Lcom/amazon/mShop/payment/alipay/AlipayAdapterStatus;

    .line 75
    .local v0, "invokationResult":Lcom/amazon/mShop/payment/alipay/AlipayAdapterStatus;
    invoke-static {}, Lcom/amazon/mShop/payment/alipay/AlipayAdapter$Factory;->getInstance()Lcom/amazon/mShop/payment/alipay/AlipayAdapter;

    move-result-object v1

    new-instance v2, Lcom/amazon/mShop/payment/alipay/AlipayDelegate$1;

    invoke-direct {v2, p0, p1, p3}, Lcom/amazon/mShop/payment/alipay/AlipayDelegate$1;-><init>(Lcom/amazon/mShop/payment/alipay/AlipayDelegate;Lcom/amazon/mShop/web/MShopWebActivity;Ljava/lang/String;)V

    invoke-virtual {v1, p1, p2, v2}, Lcom/amazon/mShop/payment/alipay/AlipayAdapter;->pay(Landroid/app/Activity;Ljava/lang/String;Lcom/amazon/mShop/payment/alipay/AlipayCallback;)Lcom/amazon/mShop/payment/alipay/AlipayAdapterStatus;

    move-result-object v0

    .line 88
    sget-object v1, Lcom/amazon/mShop/payment/alipay/AlipayAdapterStatus;->ADAPTER_INVOKE_SUCCESS:Lcom/amazon/mShop/payment/alipay/AlipayAdapterStatus;

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/payment/alipay/AlipayAdapterStatus;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 92
    const/4 v1, 0x0

    invoke-virtual {p1, v1}, Lcom/amazon/mShop/web/MShopWebActivity;->setSkipStopBehavior(Z)V

    .line 98
    invoke-virtual {p1}, Lcom/amazon/mShop/web/MShopWebActivity;->getWebView()Landroid/webkit/WebView;

    move-result-object v1

    invoke-virtual {v1, p3}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public setCookie(Landroid/content/Context;Ljava/lang/String;)V
    .locals 5
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "domain"    # Ljava/lang/String;

    .prologue
    .line 42
    const-string/jumbo v0, "0"

    .line 43
    .local v0, "alipayAvailability":Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/payment/alipay/AlipayAdapter$Factory;->getInstance()Lcom/amazon/mShop/payment/alipay/AlipayAdapter;

    move-result-object v2

    invoke-virtual {v2, p1}, Lcom/amazon/mShop/payment/alipay/AlipayAdapter;->isAlipayInstalled(Landroid/content/Context;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 44
    const-string/jumbo v0, "1"

    .line 46
    :cond_0
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "amzn-app-alipay="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, "; Domain="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 47
    .local v1, "cookie":Ljava/lang/String;
    invoke-static {}, Landroid/webkit/CookieManager;->getInstance()Landroid/webkit/CookieManager;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "www"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3, v1}, Landroid/webkit/CookieManager;->setCookie(Ljava/lang/String;Ljava/lang/String;)V

    .line 48
    return-void
.end method
