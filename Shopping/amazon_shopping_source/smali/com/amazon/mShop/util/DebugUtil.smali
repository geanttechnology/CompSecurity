.class public Lcom/amazon/mShop/util/DebugUtil;
.super Ljava/lang/Object;
.source "DebugUtil.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/util/DebugUtil$Log;
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 34
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 202
    return-void
.end method

.method static synthetic access$000(Landroid/content/Context;)V
    .locals 0
    .param p0, "x0"    # Landroid/content/Context;

    .prologue
    .line 34
    invoke-static {p0}, Lcom/amazon/mShop/util/DebugUtil;->requestNewWeblabAssignment(Landroid/content/Context;)V

    return-void
.end method

.method public static getWeblabCookie(Landroid/content/Context;)Ljava/lang/String;
    .locals 10
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 133
    invoke-static {}, Landroid/webkit/CookieSyncManager;->getInstance()Landroid/webkit/CookieSyncManager;

    move-result-object v7

    invoke-virtual {v7}, Landroid/webkit/CookieSyncManager;->sync()V

    .line 134
    const/4 v7, 0x0

    invoke-static {p0, v7}, Lcom/amazon/mShop/net/CookieBridge;->getMShopURL(Landroid/content/Context;Z)Ljava/lang/String;

    move-result-object v5

    .line 135
    .local v5, "url":Ljava/lang/String;
    invoke-static {}, Landroid/webkit/CookieManager;->getInstance()Landroid/webkit/CookieManager;

    move-result-object v6

    .line 136
    .local v6, "webkitCookieManager":Landroid/webkit/CookieManager;
    invoke-virtual {v6, v5}, Landroid/webkit/CookieManager;->getCookie(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 138
    .local v1, "cookieString":Ljava/lang/String;
    const-string/jumbo v7, "experiment"

    invoke-virtual {v1, v7}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v4

    .line 139
    .local v4, "start":I
    const/4 v7, -0x1

    if-eq v4, v7, :cond_1

    .line 141
    const-string/jumbo v7, "="

    invoke-virtual {v1, v7, v4}, Ljava/lang/String;->indexOf(Ljava/lang/String;I)I

    move-result v0

    .line 142
    .local v0, "begin":I
    const-string/jumbo v7, ";"

    invoke-virtual {v1, v7, v4}, Ljava/lang/String;->indexOf(Ljava/lang/String;I)I

    move-result v2

    .line 146
    .local v2, "end":I
    if-gez v2, :cond_0

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v2

    .line 147
    :cond_0
    add-int/lit8 v7, v0, 0x1

    invoke-virtual {v1, v7, v2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v3

    .line 148
    .local v3, "experimentValue":Ljava/lang/String;
    invoke-static {v3}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v7

    if-nez v7, :cond_1

    .line 149
    invoke-virtual {v3}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v7

    const-string/jumbo v8, "\""

    const-string/jumbo v9, ""

    invoke-virtual {v7, v8, v9}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v7

    .line 152
    .end local v0    # "begin":I
    .end local v2    # "end":I
    .end local v3    # "experimentValue":Ljava/lang/String;
    :goto_0
    return-object v7

    :cond_1
    const-string/jumbo v7, ""

    goto :goto_0
.end method

.method public static handleOnReceivedHTTPAuthenticationRequest(Landroid/app/Activity;Landroid/webkit/WebView;Landroid/webkit/HttpAuthHandler;Ljava/lang/String;Ljava/lang/String;)V
    .locals 9
    .param p0, "activity"    # Landroid/app/Activity;
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "handler"    # Landroid/webkit/HttpAuthHandler;
    .param p3, "host"    # Ljava/lang/String;
    .param p4, "realm"    # Ljava/lang/String;

    .prologue
    .line 166
    new-instance v6, Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    invoke-direct {v6, p0}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 167
    .local v6, "builder":Lcom/amazon/mShop/AmazonAlertDialog$Builder;
    invoke-virtual {p0}, Landroid/app/Activity;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object v0

    sget v2, Lcom/amazon/mShop/android/lib/R$layout;->debug_http_sign_in_dialog:I

    const/4 v3, 0x0

    invoke-virtual {v0, v2, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v1

    .line 168
    .local v1, "dialogView":Landroid/view/View;
    sget v0, Lcom/amazon/mShop/android/lib/R$string;->debug_http_auth_dialog_title:I

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object p3, v2, v3

    invoke-virtual {p0, v0, v2}, Landroid/app/Activity;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v6, v0}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    move-result-object v0

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setView(Landroid/view/View;)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    move-result-object v7

    sget v8, Lcom/amazon/mShop/android/lib/R$string;->ok:I

    new-instance v0, Lcom/amazon/mShop/util/DebugUtil$6;

    move-object v2, p1

    move-object v3, p3

    move-object v4, p4

    move-object v5, p2

    invoke-direct/range {v0 .. v5}, Lcom/amazon/mShop/util/DebugUtil$6;-><init>(Landroid/view/View;Landroid/webkit/WebView;Ljava/lang/String;Ljava/lang/String;Landroid/webkit/HttpAuthHandler;)V

    invoke-virtual {v7, v8, v0}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setPositiveButton(ILandroid/content/DialogInterface$OnClickListener;)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    move-result-object v0

    const/high16 v2, 0x1040000

    new-instance v3, Lcom/amazon/mShop/util/DebugUtil$5;

    invoke-direct {v3}, Lcom/amazon/mShop/util/DebugUtil$5;-><init>()V

    invoke-virtual {v0, v2, v3}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setNegativeButton(ILandroid/content/DialogInterface$OnClickListener;)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    move-result-object v0

    new-instance v2, Lcom/amazon/mShop/util/DebugUtil$4;

    invoke-direct {v2, p2}, Lcom/amazon/mShop/util/DebugUtil$4;-><init>(Landroid/webkit/HttpAuthHandler;)V

    invoke-virtual {v0, v2}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setOnCancelListener(Landroid/content/DialogInterface$OnCancelListener;)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    .line 194
    invoke-virtual {v6}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->create()Lcom/amazon/mShop/AmazonAlertDialog;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/AmazonAlertDialog;->show()V

    .line 195
    return-void
.end method

.method public static overrideWeblabAssignment(Landroid/content/Context;)V
    .locals 6
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 43
    new-instance v1, Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 44
    .local v1, "builder":Lcom/amazon/mShop/AmazonAlertDialog$Builder;
    sget v3, Lcom/amazon/mShop/android/lib/R$string;->menu_more_set_weblab:I

    invoke-virtual {v1, v3}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setTitle(I)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    .line 45
    sget v3, Lcom/amazon/mShop/android/lib/R$string;->set_web_lab_description:I

    invoke-virtual {v1, v3}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setMessage(I)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    .line 46
    new-instance v2, Landroid/widget/EditText;

    invoke-direct {v2, p0}, Landroid/widget/EditText;-><init>(Landroid/content/Context;)V

    .line 47
    .local v2, "edit":Landroid/widget/EditText;
    const/16 v3, 0x1000

    invoke-virtual {v2, v3}, Landroid/widget/EditText;->setInputType(I)V

    .line 48
    new-instance v3, Landroid/view/ViewGroup$LayoutParams;

    const/4 v4, -0x1

    const/16 v5, 0xc8

    invoke-direct {v3, v4, v5}, Landroid/view/ViewGroup$LayoutParams;-><init>(II)V

    invoke-virtual {v2, v3}, Landroid/widget/EditText;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 49
    invoke-virtual {v1, v2}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setView(Landroid/view/View;)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    .line 51
    invoke-static {p0}, Lcom/amazon/mShop/util/DebugUtil;->getWeblabCookie(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 52
    sget v3, Lcom/amazon/mShop/android/lib/R$string;->ok:I

    new-instance v4, Lcom/amazon/mShop/util/DebugUtil$1;

    invoke-direct {v4, v2, p0}, Lcom/amazon/mShop/util/DebugUtil$1;-><init>(Landroid/widget/EditText;Landroid/content/Context;)V

    invoke-virtual {v1, v3, v4}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setPositiveButton(ILandroid/content/DialogInterface$OnClickListener;)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    .line 76
    invoke-virtual {v1}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->create()Lcom/amazon/mShop/AmazonAlertDialog;

    move-result-object v0

    .line 77
    .local v0, "alert":Lcom/amazon/mShop/AmazonAlertDialog;
    invoke-virtual {v0}, Lcom/amazon/mShop/AmazonAlertDialog;->show()V

    .line 78
    return-void
.end method

.method private static requestNewWeblabAssignment(Landroid/content/Context;)V
    .locals 5
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 81
    new-instance v4, Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    invoke-direct {v4, p0}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;-><init>(Landroid/content/Context;)V

    invoke-virtual {v4}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->create()Lcom/amazon/mShop/AmazonAlertDialog;

    move-result-object v1

    .line 82
    .local v1, "dialog":Lcom/amazon/mShop/AmazonAlertDialog;
    const-string/jumbo v4, "Request Weblab Assignment..."

    invoke-virtual {v1, v4}, Lcom/amazon/mShop/AmazonAlertDialog;->setMessage(Ljava/lang/CharSequence;)V

    .line 84
    new-instance v2, Lcom/amazon/mShop/util/DebugUtil$2;

    invoke-direct {v2, v1, p0}, Lcom/amazon/mShop/util/DebugUtil$2;-><init>(Lcom/amazon/mShop/AmazonAlertDialog;Landroid/content/Context;)V

    .line 109
    .local v2, "subscriber":Lcom/amazon/mShop/feature/FeatureStateSubscriber;
    new-instance v0, Lcom/amazon/mShop/util/DebugUtil$3;

    invoke-direct {v0, v2}, Lcom/amazon/mShop/util/DebugUtil$3;-><init>(Lcom/amazon/mShop/feature/FeatureStateSubscriber;)V

    .line 119
    .local v0, "client":Landroid/webkit/WebViewClient;
    new-instance v3, Landroid/webkit/WebView;

    invoke-direct {v3, p0}, Landroid/webkit/WebView;-><init>(Landroid/content/Context;)V

    .line 120
    .local v3, "webview":Landroid/webkit/WebView;
    invoke-virtual {v3, v0}, Landroid/webkit/WebView;->setWebViewClient(Landroid/webkit/WebViewClient;)V

    .line 123
    sget v4, Lcom/amazon/mShop/android/lib/R$string;->wishlist_web_page_url:I

    invoke-virtual {p0, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    .line 124
    invoke-virtual {v1}, Lcom/amazon/mShop/AmazonAlertDialog;->show()V

    .line 125
    return-void
.end method
