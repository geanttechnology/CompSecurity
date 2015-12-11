.class public final Lcom/amazon/identity/kcpsdk/auth/CredentialStatusChecker;
.super Ljava/lang/Object;
.source "CredentialStatusChecker.java"


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 9
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 10
    return-void
.end method

.method public static checkResponse(Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;)Lcom/amazon/identity/kcpsdk/auth/CredentialStatus;
    .locals 4
    .param p0, "response"    # Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;

    .prologue
    .line 14
    sget-object v1, Lcom/amazon/identity/kcpsdk/auth/CredentialStatus;->CredentialStatusOK:Lcom/amazon/identity/kcpsdk/auth/CredentialStatus;

    .line 16
    .local v1, "status":Lcom/amazon/identity/kcpsdk/auth/CredentialStatus;
    invoke-static {p0}, Lcom/amazon/identity/kcpsdk/auth/CredentialStatusChecker;->getErrorText(Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;)Ljava/lang/String;

    move-result-object v0

    .line 17
    .local v0, "errorHeaderValue":Ljava/lang/String;
    invoke-static {p0}, Lcom/amazon/identity/kcpsdk/auth/CredentialStatusChecker;->getWarningText(Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;)Ljava/lang/String;

    move-result-object v2

    .line 19
    .local v2, "warnHeaderValue":Ljava/lang/String;
    const-string/jumbo v3, "invalid_credentials"

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 21
    sget-object v1, Lcom/amazon/identity/kcpsdk/auth/CredentialStatus;->CredentialStatusInvalid:Lcom/amazon/identity/kcpsdk/auth/CredentialStatus;

    .line 42
    :cond_0
    :goto_0
    return-object v1

    .line 23
    :cond_1
    const-string/jumbo v3, "expired_credentials"

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 27
    sget-object v1, Lcom/amazon/identity/kcpsdk/auth/CredentialStatus;->CredentialStatusInvalid:Lcom/amazon/identity/kcpsdk/auth/CredentialStatus;

    goto :goto_0

    .line 29
    :cond_2
    const-string/jumbo v3, "stale_credentials"

    invoke-virtual {v3, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_3

    .line 31
    sget-object v1, Lcom/amazon/identity/kcpsdk/auth/CredentialStatus;->CredentialStatusStale:Lcom/amazon/identity/kcpsdk/auth/CredentialStatus;

    goto :goto_0

    .line 33
    :cond_3
    if-eqz v0, :cond_4

    const-string/jumbo v3, ""

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_4

    .line 35
    sget-object v1, Lcom/amazon/identity/kcpsdk/auth/CredentialStatus;->CredentialStatusUnknownError:Lcom/amazon/identity/kcpsdk/auth/CredentialStatus;

    goto :goto_0

    .line 37
    :cond_4
    if-eqz v2, :cond_0

    const-string/jumbo v3, ""

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 39
    sget-object v1, Lcom/amazon/identity/kcpsdk/auth/CredentialStatus;->CredentialStatusUnknownWarning:Lcom/amazon/identity/kcpsdk/auth/CredentialStatus;

    goto :goto_0
.end method

.method public static getErrorText(Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;)Ljava/lang/String;
    .locals 1
    .param p0, "response"    # Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;

    .prologue
    .line 47
    const-string/jumbo v0, "X-ADP-Error"

    invoke-virtual {p0, v0}, Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;->getHeaderByName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getWarningText(Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;)Ljava/lang/String;
    .locals 1
    .param p0, "response"    # Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;

    .prologue
    .line 52
    const-string/jumbo v0, "X-ADP-Warn"

    invoke-virtual {p0, v0}, Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;->getHeaderByName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
