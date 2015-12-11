.class Lcom/amazon/device/ads/AmazonOOMAPAdapter;
.super Ljava/lang/Object;
.source "AmazonOOMAPAdapter.java"

# interfaces
.implements Lcom/amazon/device/ads/AmazonOOAuthenticationPlatformAdapter;


# static fields
.field private static final LOGTAG:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 24
    const-class v0, Lcom/amazon/device/ads/AmazonOOMAPAdapter;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/device/ads/AmazonOOMAPAdapter;->LOGTAG:Ljava/lang/String;

    return-void
.end method

.method constructor <init>()V
    .locals 0

    .prologue
    .line 22
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getAccountName()Ljava/lang/String;
    .locals 8

    .prologue
    .line 29
    const/4 v0, 0x0

    .line 32
    .local v0, "acct":Ljava/lang/String;
    :try_start_0
    new-instance v2, Lcom/amazon/identity/auth/device/api/MAPAccountManager;

    invoke-static {}, Lcom/amazon/device/ads/InternalAdRegistration;->getInstance()Lcom/amazon/device/ads/IInternalAdRegistration;

    move-result-object v3

    invoke-interface {v3}, Lcom/amazon/device/ads/IInternalAdRegistration;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    invoke-direct {v2, v3}, Lcom/amazon/identity/auth/device/api/MAPAccountManager;-><init>(Landroid/content/Context;)V

    .line 33
    .local v2, "mapAcctMgr":Lcom/amazon/identity/auth/device/api/MAPAccountManager;
    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->getAccount()Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 40
    .end local v2    # "mapAcctMgr":Lcom/amazon/identity/auth/device/api/MAPAccountManager;
    :goto_0
    if-nez v0, :cond_0

    .line 42
    sget-object v3, Lcom/amazon/device/ads/AmazonOOMAPAdapter;->LOGTAG:Ljava/lang/String;

    const-string/jumbo v4, "No Amazon account found"

    invoke-static {v3, v4}, Lcom/amazon/device/ads/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 44
    :cond_0
    return-object v0

    .line 35
    :catch_0
    move-exception v1

    .line 37
    .local v1, "e":Ljava/lang/Exception;
    sget-object v3, Lcom/amazon/device/ads/AmazonOOMAPAdapter;->LOGTAG:Ljava/lang/String;

    const-string/jumbo v4, "Exception caught when trying to retrieve the user\'s account: %s"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    invoke-virtual {v1}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v7

    aput-object v7, v5, v6

    invoke-static {v3, v4, v5}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0
.end method

.method public getPreferredMarketplace()Ljava/lang/String;
    .locals 11

    .prologue
    const/4 v3, 0x0

    .line 59
    invoke-virtual {p0}, Lcom/amazon/device/ads/AmazonOOMAPAdapter;->getAccountName()Ljava/lang/String;

    move-result-object v0

    .line 60
    .local v0, "account":Ljava/lang/String;
    if-nez v0, :cond_1

    .line 81
    :cond_0
    :goto_0
    return-object v3

    .line 65
    :cond_1
    const/4 v3, 0x0

    .line 68
    .local v3, "pfm":Ljava/lang/String;
    :try_start_0
    invoke-static {}, Lcom/amazon/device/ads/InternalAdRegistration;->getInstance()Lcom/amazon/device/ads/IInternalAdRegistration;

    move-result-object v6

    invoke-interface {v6}, Lcom/amazon/device/ads/IInternalAdRegistration;->getApplicationContext()Landroid/content/Context;

    move-result-object v6

    invoke-static {v6}, Lcom/amazon/identity/auth/device/api/CustomerAttributeStore;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/device/api/CustomerAttributeStore;

    move-result-object v1

    .line 69
    .local v1, "custAttrStore":Lcom/amazon/identity/auth/device/api/CustomerAttributeStore;
    const-string/jumbo v6, "PFM"

    const/4 v7, 0x0

    const-class v8, Lcom/amazon/identity/auth/device/api/CustomerAttributeStore$GetAttributeOptions;

    invoke-static {v8}, Ljava/util/EnumSet;->noneOf(Ljava/lang/Class;)Ljava/util/EnumSet;

    move-result-object v8

    invoke-virtual {v1, v0, v6, v7, v8}, Lcom/amazon/identity/auth/device/api/CustomerAttributeStore;->getAttribute(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/device/api/Callback;Ljava/util/EnumSet;)Lcom/amazon/identity/auth/device/api/MAPFuture;

    move-result-object v5

    .line 70
    .local v5, "pfmFuture":Lcom/amazon/identity/auth/device/api/MAPFuture;, "Lcom/amazon/identity/auth/device/api/MAPFuture<Landroid/os/Bundle;>;"
    invoke-interface {v5}, Lcom/amazon/identity/auth/device/api/MAPFuture;->get()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/os/Bundle;

    .line 71
    .local v4, "pfmBundle":Landroid/os/Bundle;
    if-eqz v4, :cond_0

    .line 73
    invoke-static {v4}, Lcom/amazon/identity/auth/device/api/CustomerAttributeStore;->getValueOrAttributeDefault(Landroid/os/Bundle;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v3

    goto :goto_0

    .line 76
    .end local v1    # "custAttrStore":Lcom/amazon/identity/auth/device/api/CustomerAttributeStore;
    .end local v4    # "pfmBundle":Landroid/os/Bundle;
    .end local v5    # "pfmFuture":Lcom/amazon/identity/auth/device/api/MAPFuture;, "Lcom/amazon/identity/auth/device/api/MAPFuture<Landroid/os/Bundle;>;"
    :catch_0
    move-exception v2

    .line 78
    .local v2, "e":Ljava/lang/Exception;
    sget-object v6, Lcom/amazon/device/ads/AmazonOOMAPAdapter;->LOGTAG:Ljava/lang/String;

    const-string/jumbo v7, "Exception caught when trying to retrieve the user\'s preferred marketplace. Most issues can be remedied by upgrading to MAP R5. Exception message: %s"

    const/4 v8, 0x1

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    invoke-virtual {v2}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v10

    aput-object v10, v8, v9

    invoke-static {v6, v7, v8}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0
.end method

.method public makeAuthenticatedWebRequest(Ljava/lang/String;)Lcom/amazon/device/ads/WebRequest;
    .locals 3
    .param p1, "acct"    # Ljava/lang/String;

    .prologue
    .line 50
    new-instance v0, Lcom/amazon/identity/auth/device/api/AuthenticationMethodFactory;

    invoke-static {}, Lcom/amazon/device/ads/InternalAdRegistration;->getInstance()Lcom/amazon/device/ads/IInternalAdRegistration;

    move-result-object v2

    invoke-interface {v2}, Lcom/amazon/device/ads/IInternalAdRegistration;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    invoke-direct {v0, v2, p1}, Lcom/amazon/identity/auth/device/api/AuthenticationMethodFactory;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 51
    .local v0, "authFactory":Lcom/amazon/identity/auth/device/api/AuthenticationMethodFactory;
    sget-object v2, Lcom/amazon/identity/auth/device/api/AuthenticationType;->OAuth:Lcom/amazon/identity/auth/device/api/AuthenticationType;

    invoke-virtual {v0, v2}, Lcom/amazon/identity/auth/device/api/AuthenticationMethodFactory;->newAuthenticationMethod(Lcom/amazon/identity/auth/device/api/AuthenticationType;)Lcom/amazon/identity/auth/device/api/AuthenticationMethod;

    move-result-object v1

    .line 53
    .local v1, "authMethod":Lcom/amazon/identity/auth/device/api/AuthenticationMethod;
    new-instance v2, Lcom/amazon/device/ads/AmazonOOAuthenticatedWebRequest;

    invoke-direct {v2, v1}, Lcom/amazon/device/ads/AmazonOOAuthenticatedWebRequest;-><init>(Lcom/amazon/identity/auth/device/api/AuthenticationMethod;)V

    return-object v2
.end method
