.class Lcom/amazon/identity/auth/accounts/AbstractSubAuthenticator$Transport;
.super Lcom/amazon/dcp/sso/ISubAuthenticator$Stub;
.source "AbstractSubAuthenticator.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/accounts/AbstractSubAuthenticator;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "Transport"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/identity/auth/accounts/AbstractSubAuthenticator;


# direct methods
.method private constructor <init>(Lcom/amazon/identity/auth/accounts/AbstractSubAuthenticator;)V
    .locals 0

    .prologue
    .line 84
    iput-object p1, p0, Lcom/amazon/identity/auth/accounts/AbstractSubAuthenticator$Transport;->this$0:Lcom/amazon/identity/auth/accounts/AbstractSubAuthenticator;

    invoke-direct {p0}, Lcom/amazon/dcp/sso/ISubAuthenticator$Stub;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/identity/auth/accounts/AbstractSubAuthenticator;Lcom/amazon/identity/auth/accounts/AbstractSubAuthenticator$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/identity/auth/accounts/AbstractSubAuthenticator;
    .param p2, "x1"    # Lcom/amazon/identity/auth/accounts/AbstractSubAuthenticator$1;

    .prologue
    .line 84
    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/accounts/AbstractSubAuthenticator$Transport;-><init>(Lcom/amazon/identity/auth/accounts/AbstractSubAuthenticator;)V

    return-void
.end method


# virtual methods
.method public getAccountRemovalAllowed(Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "response"    # Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;
    .param p2, "accountType"    # Ljava/lang/String;
    .param p3, "accountName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 137
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AbstractSubAuthenticator$Transport;->this$0:Lcom/amazon/identity/auth/accounts/AbstractSubAuthenticator;

    invoke-static {v0}, Lcom/amazon/identity/auth/accounts/AbstractSubAuthenticator;->access$100(Lcom/amazon/identity/auth/accounts/AbstractSubAuthenticator;)V

    .line 139
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AbstractSubAuthenticator$Transport;->this$0:Lcom/amazon/identity/auth/accounts/AbstractSubAuthenticator;

    new-instance v1, Landroid/accounts/Account;

    invoke-direct {v1, p3, p2}, Landroid/accounts/Account;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v0, p1, v1}, Lcom/amazon/identity/auth/accounts/AbstractSubAuthenticator;->getAccountRemovalAllowed(Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;Landroid/accounts/Account;)V

    .line 140
    return-void
.end method

.method public getAuthToken(Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/dcp/sso/IAmazonAccountAuthenticator;)V
    .locals 6
    .param p1, "response"    # Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;
    .param p2, "accountType"    # Ljava/lang/String;
    .param p3, "accountName"    # Ljava/lang/String;
    .param p4, "tokenType"    # Ljava/lang/String;
    .param p5, "options"    # Landroid/os/Bundle;
    .param p6, "authenticator"    # Lcom/amazon/dcp/sso/IAmazonAccountAuthenticator;

    .prologue
    .line 94
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AbstractSubAuthenticator$Transport;->this$0:Lcom/amazon/identity/auth/accounts/AbstractSubAuthenticator;

    invoke-static {v0}, Lcom/amazon/identity/auth/accounts/AbstractSubAuthenticator;->access$100(Lcom/amazon/identity/auth/accounts/AbstractSubAuthenticator;)V

    .line 96
    if-eqz p1, :cond_0

    if-nez p6, :cond_1

    .line 98
    :cond_0
    # getter for: Lcom/amazon/identity/auth/accounts/AbstractSubAuthenticator;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/AbstractSubAuthenticator;->access$200()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "Invalid parameter passed to getAuthToken"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 107
    :goto_0
    return-void

    .line 102
    :cond_1
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AbstractSubAuthenticator$Transport;->this$0:Lcom/amazon/identity/auth/accounts/AbstractSubAuthenticator;

    new-instance v2, Landroid/accounts/Account;

    invoke-direct {v2, p3, p2}, Landroid/accounts/Account;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    move-object v1, p1

    move-object v3, p4

    move-object v4, p5

    move-object v5, p6

    invoke-virtual/range {v0 .. v5}, Lcom/amazon/identity/auth/accounts/AbstractSubAuthenticator;->getAuthToken(Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;Landroid/accounts/Account;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/dcp/sso/IAmazonAccountAuthenticator;)V

    goto :goto_0
.end method

.method public onTransact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z
    .locals 3
    .param p1, "code"    # I
    .param p2, "data"    # Landroid/os/Parcel;
    .param p3, "reply"    # Landroid/os/Parcel;
    .param p4, "flags"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 151
    :try_start_0
    invoke-super {p0, p1, p2, p3, p4}, Lcom/amazon/dcp/sso/ISubAuthenticator$Stub;->onTransact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v1

    return v1

    .line 153
    :catch_0
    move-exception v0

    .line 155
    .local v0, "e":Ljava/lang/RuntimeException;
    # getter for: Lcom/amazon/identity/auth/accounts/AbstractSubAuthenticator;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/AbstractSubAuthenticator;->access$200()Ljava/lang/String;

    move-result-object v1

    const-string/jumbo v2, "Unexpected Runtime Exception"

    invoke-static {v1, v2, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 156
    throw v0
.end method

.method public updateAuthToken(Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/dcp/sso/IAmazonAccountAuthenticator;)V
    .locals 6
    .param p1, "response"    # Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;
    .param p2, "accountType"    # Ljava/lang/String;
    .param p3, "accountName"    # Ljava/lang/String;
    .param p4, "tokenType"    # Ljava/lang/String;
    .param p5, "options"    # Landroid/os/Bundle;
    .param p6, "authenticator"    # Lcom/amazon/dcp/sso/IAmazonAccountAuthenticator;

    .prologue
    .line 117
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AbstractSubAuthenticator$Transport;->this$0:Lcom/amazon/identity/auth/accounts/AbstractSubAuthenticator;

    invoke-static {v0}, Lcom/amazon/identity/auth/accounts/AbstractSubAuthenticator;->access$100(Lcom/amazon/identity/auth/accounts/AbstractSubAuthenticator;)V

    .line 119
    if-eqz p1, :cond_0

    if-nez p6, :cond_1

    .line 121
    :cond_0
    # getter for: Lcom/amazon/identity/auth/accounts/AbstractSubAuthenticator;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/AbstractSubAuthenticator;->access$200()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "Invalid parameter passed to updateAuthTokens"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 130
    :goto_0
    return-void

    .line 125
    :cond_1
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AbstractSubAuthenticator$Transport;->this$0:Lcom/amazon/identity/auth/accounts/AbstractSubAuthenticator;

    new-instance v2, Landroid/accounts/Account;

    invoke-direct {v2, p3, p2}, Landroid/accounts/Account;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    move-object v1, p1

    move-object v3, p4

    move-object v4, p5

    move-object v5, p6

    invoke-virtual/range {v0 .. v5}, Lcom/amazon/identity/auth/accounts/AbstractSubAuthenticator;->updateAuthToken(Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;Landroid/accounts/Account;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/dcp/sso/IAmazonAccountAuthenticator;)V

    goto :goto_0
.end method
