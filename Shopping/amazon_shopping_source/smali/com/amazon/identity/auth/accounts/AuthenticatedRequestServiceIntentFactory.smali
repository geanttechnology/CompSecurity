.class public Lcom/amazon/identity/auth/accounts/AuthenticatedRequestServiceIntentFactory;
.super Lcom/amazon/identity/auth/device/framework/SSOIntentFactory;
.source "AuthenticatedRequestServiceIntentFactory.java"


# direct methods
.method public constructor <init>(Landroid/content/ComponentName;)V
    .locals 0
    .param p1, "componentName"    # Landroid/content/ComponentName;

    .prologue
    .line 17
    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/device/framework/SSOIntentFactory;-><init>(Landroid/content/ComponentName;)V

    .line 18
    return-void
.end method

.method public static findAuthRequestService(Landroid/content/Context;)Lcom/amazon/identity/auth/accounts/AuthenticatedRequestServiceIntentFactory;
    .locals 3
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 22
    const-string/jumbo v1, "com.amazon.dcp.sso.AuthenticatedRequestService"

    sget-object v2, Lcom/amazon/identity/auth/accounts/AuthenticatedRequestServiceIntentFactory;->SERVICE_FINDER:Lcom/amazon/identity/auth/device/framework/SSOIntentFactory$ComponentFinder;

    invoke-static {p0, v1, v2}, Lcom/amazon/identity/auth/accounts/AuthenticatedRequestServiceIntentFactory;->findSSOComponent(Landroid/content/Context;Ljava/lang/String;Lcom/amazon/identity/auth/device/framework/SSOIntentFactory$ComponentFinder;)Landroid/content/ComponentName;

    move-result-object v0

    .line 23
    .local v0, "authServiceComp":Landroid/content/ComponentName;
    if-nez v0, :cond_0

    .line 25
    const/4 v1, 0x0

    .line 27
    :goto_0
    return-object v1

    :cond_0
    new-instance v1, Lcom/amazon/identity/auth/accounts/AuthenticatedRequestServiceIntentFactory;

    invoke-direct {v1, v0}, Lcom/amazon/identity/auth/accounts/AuthenticatedRequestServiceIntentFactory;-><init>(Landroid/content/ComponentName;)V

    goto :goto_0
.end method


# virtual methods
.method public buildIntentForService()Landroid/content/Intent;
    .locals 1

    .prologue
    .line 32
    const-string/jumbo v0, "com.amazon.dcp.sso.action.GET_DEVICE_CREDENTIALS"

    invoke-virtual {p0, v0}, Lcom/amazon/identity/auth/accounts/AuthenticatedRequestServiceIntentFactory;->buildIntent(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v0

    return-object v0
.end method
