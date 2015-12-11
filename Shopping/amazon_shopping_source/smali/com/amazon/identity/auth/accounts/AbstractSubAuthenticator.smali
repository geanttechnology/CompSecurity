.class public abstract Lcom/amazon/identity/auth/accounts/AbstractSubAuthenticator;
.super Ljava/lang/Object;
.source "AbstractSubAuthenticator.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/identity/auth/accounts/AbstractSubAuthenticator$1;,
        Lcom/amazon/identity/auth/accounts/AbstractSubAuthenticator$Transport;
    }
.end annotation


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field protected final mContext:Landroid/content/Context;

.field private mTransport:Lcom/amazon/identity/auth/accounts/AbstractSubAuthenticator$Transport;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 73
    const-class v0, Lcom/amazon/identity/auth/accounts/AbstractSubAuthenticator;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/accounts/AbstractSubAuthenticator;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 80
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 77
    new-instance v0, Lcom/amazon/identity/auth/accounts/AbstractSubAuthenticator$Transport;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lcom/amazon/identity/auth/accounts/AbstractSubAuthenticator$Transport;-><init>(Lcom/amazon/identity/auth/accounts/AbstractSubAuthenticator;Lcom/amazon/identity/auth/accounts/AbstractSubAuthenticator$1;)V

    iput-object v0, p0, Lcom/amazon/identity/auth/accounts/AbstractSubAuthenticator;->mTransport:Lcom/amazon/identity/auth/accounts/AbstractSubAuthenticator$Transport;

    .line 81
    iput-object p1, p0, Lcom/amazon/identity/auth/accounts/AbstractSubAuthenticator;->mContext:Landroid/content/Context;

    .line 82
    return-void
.end method

.method static synthetic access$100(Lcom/amazon/identity/auth/accounts/AbstractSubAuthenticator;)V
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/accounts/AbstractSubAuthenticator;

    .prologue
    .line 71
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AbstractSubAuthenticator;->mContext:Landroid/content/Context;

    invoke-static {v0}, Lcom/amazon/identity/auth/device/utils/SecurityHelpers;->checkCaller(Landroid/content/Context;)V

    return-void
.end method

.method static synthetic access$200()Ljava/lang/String;
    .locals 1

    .prologue
    .line 71
    sget-object v0, Lcom/amazon/identity/auth/accounts/AbstractSubAuthenticator;->TAG:Ljava/lang/String;

    return-object v0
.end method


# virtual methods
.method public abstract getAccountRemovalAllowed(Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;Landroid/accounts/Account;)V
.end method

.method public abstract getAuthToken(Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;Landroid/accounts/Account;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/dcp/sso/IAmazonAccountAuthenticator;)V
.end method

.method public final getIBinder()Landroid/os/IBinder;
    .locals 1

    .prologue
    .line 166
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AbstractSubAuthenticator;->mTransport:Lcom/amazon/identity/auth/accounts/AbstractSubAuthenticator$Transport;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/accounts/AbstractSubAuthenticator$Transport;->asBinder()Landroid/os/IBinder;

    move-result-object v0

    return-object v0
.end method

.method public updateAuthToken(Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;Landroid/accounts/Account;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/dcp/sso/IAmazonAccountAuthenticator;)V
    .locals 4
    .param p1, "response"    # Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;
    .param p2, "account"    # Landroid/accounts/Account;
    .param p3, "authTokenType"    # Ljava/lang/String;
    .param p4, "options"    # Landroid/os/Bundle;
    .param p5, "authenticator"    # Lcom/amazon/dcp/sso/IAmazonAccountAuthenticator;

    .prologue
    .line 266
    const/4 v1, 0x6

    :try_start_0
    new-instance v2, Ljava/lang/StringBuilder;

    const-string/jumbo v3, "Unsupported for token type: "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {p1, v1, v2}, Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;->onError(ILjava/lang/String;)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    .line 273
    :goto_0
    return-void

    .line 269
    :catch_0
    move-exception v0

    .line 271
    .local v0, "e":Landroid/os/RemoteException;
    sget-object v1, Lcom/amazon/identity/auth/accounts/AbstractSubAuthenticator;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "An unexpected remote exception occured during updateAuthTokens."

    invoke-static {v1, v2, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method
