.class Lcom/amazon/identity/auth/accounts/MAPSubAuthenticatorService$1;
.super Lcom/amazon/identity/auth/accounts/AbstractSubAuthenticator;
.source "MAPSubAuthenticatorService.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/identity/auth/accounts/MAPSubAuthenticatorService;->onCreate()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field private mDmsSubAuth:Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;

.field final synthetic this$0:Lcom/amazon/identity/auth/accounts/MAPSubAuthenticatorService;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/accounts/MAPSubAuthenticatorService;Landroid/content/Context;)V
    .locals 0
    .param p2, "x0"    # Landroid/content/Context;

    .prologue
    .line 26
    iput-object p1, p0, Lcom/amazon/identity/auth/accounts/MAPSubAuthenticatorService$1;->this$0:Lcom/amazon/identity/auth/accounts/MAPSubAuthenticatorService;

    invoke-direct {p0, p2}, Lcom/amazon/identity/auth/accounts/AbstractSubAuthenticator;-><init>(Landroid/content/Context;)V

    return-void
.end method

.method private declared-synchronized getDMSSubAuthenticator()Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;
    .locals 1

    .prologue
    .line 67
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/MAPSubAuthenticatorService$1;->mDmsSubAuth:Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;

    if-nez v0, :cond_0

    .line 69
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/MAPSubAuthenticatorService$1;->this$0:Lcom/amazon/identity/auth/accounts/MAPSubAuthenticatorService;

    invoke-static {v0}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->constructDMSSubAuthForThisPackage(Landroid/content/Context;)Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/accounts/MAPSubAuthenticatorService$1;->mDmsSubAuth:Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;

    .line 73
    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/MAPSubAuthenticatorService$1;->mDmsSubAuth:Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 67
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method


# virtual methods
.method public getAccountRemovalAllowed(Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;Landroid/accounts/Account;)V
    .locals 3
    .param p1, "response"    # Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;
    .param p2, "account"    # Landroid/accounts/Account;

    .prologue
    .line 62
    invoke-direct {p0}, Lcom/amazon/identity/auth/accounts/MAPSubAuthenticatorService$1;->getDMSSubAuthenticator()Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;

    move-result-object v0

    iget-object v1, p2, Landroid/accounts/Account;->type:Ljava/lang/String;

    iget-object v2, p2, Landroid/accounts/Account;->name:Ljava/lang/String;

    invoke-virtual {v0, p1, v1, v2}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->getAccountRemovalAllowed(Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;Ljava/lang/String;Ljava/lang/String;)V

    .line 63
    return-void
.end method

.method public getAuthToken(Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;Landroid/accounts/Account;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/dcp/sso/IAmazonAccountAuthenticator;)V
    .locals 7
    .param p1, "response"    # Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;
    .param p2, "account"    # Landroid/accounts/Account;
    .param p3, "authTokenType"    # Ljava/lang/String;
    .param p4, "options"    # Landroid/os/Bundle;
    .param p5, "authenticator"    # Lcom/amazon/dcp/sso/IAmazonAccountAuthenticator;

    .prologue
    .line 36
    invoke-direct {p0}, Lcom/amazon/identity/auth/accounts/MAPSubAuthenticatorService$1;->getDMSSubAuthenticator()Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;

    move-result-object v0

    iget-object v2, p2, Landroid/accounts/Account;->type:Ljava/lang/String;

    iget-object v3, p2, Landroid/accounts/Account;->name:Ljava/lang/String;

    move-object v1, p1

    move-object v4, p3

    move-object v5, p4

    move-object v6, p5

    invoke-virtual/range {v0 .. v6}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->getAuthToken(Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/dcp/sso/IAmazonAccountAuthenticator;)V

    .line 42
    return-void
.end method

.method public updateAuthToken(Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;Landroid/accounts/Account;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/dcp/sso/IAmazonAccountAuthenticator;)V
    .locals 7
    .param p1, "response"    # Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;
    .param p2, "account"    # Landroid/accounts/Account;
    .param p3, "tokenType"    # Ljava/lang/String;
    .param p4, "options"    # Landroid/os/Bundle;
    .param p5, "authenticator"    # Lcom/amazon/dcp/sso/IAmazonAccountAuthenticator;

    .prologue
    .line 51
    invoke-direct {p0}, Lcom/amazon/identity/auth/accounts/MAPSubAuthenticatorService$1;->getDMSSubAuthenticator()Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;

    move-result-object v0

    iget-object v2, p2, Landroid/accounts/Account;->type:Ljava/lang/String;

    iget-object v3, p2, Landroid/accounts/Account;->name:Ljava/lang/String;

    move-object v1, p1

    move-object v4, p3

    move-object v5, p4

    move-object v6, p5

    invoke-virtual/range {v0 .. v6}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->updateAuthToken(Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/dcp/sso/IAmazonAccountAuthenticator;)V

    .line 57
    return-void
.end method
