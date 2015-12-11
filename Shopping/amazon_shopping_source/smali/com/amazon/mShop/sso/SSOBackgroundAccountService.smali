.class public Lcom/amazon/mShop/sso/SSOBackgroundAccountService;
.super Landroid/app/IntentService;
.source "SSOBackgroundAccountService.java"


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 28
    const-class v0, Lcom/amazon/mShop/sso/SSOBackgroundAccountService;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Landroid/app/IntentService;-><init>(Ljava/lang/String;)V

    .line 29
    return-void
.end method


# virtual methods
.method public onCreate()V
    .locals 1

    .prologue
    .line 33
    invoke-super {p0}, Landroid/app/IntentService;->onCreate()V

    .line 35
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v0

    if-nez v0, :cond_0

    .line 37
    invoke-virtual {p0}, Lcom/amazon/mShop/sso/SSOBackgroundAccountService;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/AmazonApplication;->setUp(Landroid/content/Context;)V

    .line 41
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/mShop/sso/SSOBackgroundAccountService;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/net/CookieBridge;->init(Landroid/content/Context;)V

    .line 42
    return-void
.end method

.method protected onHandleIntent(Landroid/content/Intent;)V
    .locals 5
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 46
    sget-boolean v2, Lcom/amazon/mShop/sso/SSOUtil;->DEBUG:Z

    if-eqz v2, :cond_1

    .line 47
    const/4 v0, 0x0

    .line 48
    .local v0, "account":Ljava/lang/String;
    if-eqz p1, :cond_0

    .line 49
    const-string/jumbo v2, "com.amazon.dcp.sso.extra.account.directed_id"

    invoke-virtual {p1, v2}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 51
    :cond_0
    const-string/jumbo v2, "Amazon.SSOUtil"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "In SSOBackgroundAccountService onHandleIntent: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string/jumbo v4, " account is : "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 55
    .end local v0    # "account":Ljava/lang/String;
    :cond_1
    invoke-virtual {p0}, Lcom/amazon/mShop/sso/SSOBackgroundAccountService;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    invoke-static {v2, p1}, Lcom/amazon/identity/auth/device/api/MAPBroadcastReceiver;->constructBackwardsCompatibleIntent(Landroid/content/Context;Landroid/content/Intent;)Landroid/content/Intent;

    move-result-object v1

    .line 56
    .local v1, "compatibleIntent":Landroid/content/Intent;
    if-nez v1, :cond_2

    .line 57
    move-object v1, p1

    .line 63
    :cond_2
    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil;->getCurrentIdentityType()Lcom/amazon/mShop/sso/IdentityType;

    move-result-object v2

    invoke-virtual {v2, p0, v1}, Lcom/amazon/mShop/sso/IdentityType;->handleBackgroundService(Lcom/amazon/mShop/sso/SSOBackgroundAccountService;Landroid/content/Intent;)V

    .line 64
    return-void
.end method
