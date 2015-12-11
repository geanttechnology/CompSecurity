.class public Lco/vine/android/CaptchaActivity;
.super Lco/vine/android/BaseControllerActionBarActivity;
.source "CaptchaActivity.java"


# static fields
.field public static final CAPTCHA_CANCELED:I = 0x2

.field private static final CAPTCHA_COMPLETE:Ljava/lang/String; = "_captcha_complete"


# instance fields
.field private mReqId:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 17
    invoke-direct {p0}, Lco/vine/android/BaseControllerActionBarActivity;-><init>()V

    return-void
.end method

.method static synthetic access$000(Lco/vine/android/CaptchaActivity;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/CaptchaActivity;

    .prologue
    .line 17
    iget-object v0, p0, Lco/vine/android/CaptchaActivity;->mReqId:Ljava/lang/String;

    return-object v0
.end method

.method private cancelCaptcha()V
    .locals 3

    .prologue
    .line 94
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .line 95
    .local v0, "i":Landroid/content/Intent;
    const-string v1, "rid"

    iget-object v2, p0, Lco/vine/android/CaptchaActivity;->mReqId:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 96
    const/4 v1, 0x2

    invoke-virtual {p0, v1, v0}, Lco/vine/android/CaptchaActivity;->setResult(ILandroid/content/Intent;)V

    .line 97
    invoke-virtual {p0}, Lco/vine/android/CaptchaActivity;->finish()V

    .line 98
    return-void
.end method

.method public static getIntent(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "captchaUrl"    # Ljava/lang/String;
    .param p2, "reqId"    # Ljava/lang/String;

    .prologue
    .line 73
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lco/vine/android/CaptchaActivity;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 74
    .local v0, "i":Landroid/content/Intent;
    const-string v1, "captcha_url"

    invoke-virtual {v0, v1, p1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 75
    const-string v1, "rid"

    invoke-virtual {v0, v1, p2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 76
    return-object v0
.end method


# virtual methods
.method public onBackPressed()V
    .locals 0

    .prologue
    .line 81
    invoke-direct {p0}, Lco/vine/android/CaptchaActivity;->cancelCaptcha()V

    .line 82
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 5
    .param p1, "bun"    # Landroid/os/Bundle;

    .prologue
    .line 25
    const v3, 0x7f0300a9

    const/4 v4, 0x0

    invoke-super {p0, p1, v3, v4}, Lco/vine/android/BaseControllerActionBarActivity;->onCreate(Landroid/os/Bundle;IZ)V

    .line 27
    invoke-virtual {p0}, Lco/vine/android/CaptchaActivity;->getIntent()Landroid/content/Intent;

    move-result-object v3

    invoke-virtual {v3}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    .line 28
    .local v0, "b":Landroid/os/Bundle;
    const v3, 0x7f0a00e1

    invoke-virtual {p0, v3}, Lco/vine/android/CaptchaActivity;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/webkit/WebView;

    .line 30
    .local v2, "webView":Landroid/webkit/WebView;
    const-string v3, "rid"

    invoke-virtual {v0, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Lco/vine/android/CaptchaActivity;->mReqId:Ljava/lang/String;

    .line 31
    const-string v3, "captcha_url"

    invoke-virtual {v0, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 33
    .local v1, "captchaUrl":Ljava/lang/String;
    invoke-virtual {v2}, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v3

    sget-object v4, Lco/vine/android/network/HttpOperation;->USER_AGENT_STRING:Ljava/lang/String;

    invoke-virtual {v3, v4}, Landroid/webkit/WebSettings;->setUserAgentString(Ljava/lang/String;)V

    .line 34
    invoke-virtual {v2, v1}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    .line 35
    new-instance v3, Lco/vine/android/CaptchaActivity$1;

    invoke-direct {v3, p0}, Lco/vine/android/CaptchaActivity$1;-><init>(Lco/vine/android/CaptchaActivity;)V

    invoke-virtual {v2, v3}, Landroid/webkit/WebView;->setWebViewClient(Landroid/webkit/WebViewClient;)V

    .line 70
    return-void
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 2
    .param p1, "item"    # Landroid/view/MenuItem;

    .prologue
    .line 86
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v0

    const v1, 0x102002c

    if-ne v0, v1, :cond_0

    .line 87
    invoke-direct {p0}, Lco/vine/android/CaptchaActivity;->cancelCaptcha()V

    .line 88
    const/4 v0, 0x1

    .line 90
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
