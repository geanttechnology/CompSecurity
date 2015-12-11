.class public final Lcom/amazon/identity/auth/accounts/AccountsCallbackHelpers;
.super Ljava/lang/Object;
.source "AccountsCallbackHelpers.java"


# static fields
.field private static final ACCOUNT_MANAGER_ERRORS_TO_MAP_ERRORS:Landroid/util/SparseIntArray;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 14
    new-instance v0, Landroid/util/SparseIntArray;

    invoke-direct {v0}, Landroid/util/SparseIntArray;-><init>()V

    .line 17
    sput-object v0, Lcom/amazon/identity/auth/accounts/AccountsCallbackHelpers;->ACCOUNT_MANAGER_ERRORS_TO_MAP_ERRORS:Landroid/util/SparseIntArray;

    const/4 v1, 0x7

    sget-object v2, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->BAD_REQUEST:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->value()I

    move-result v2

    invoke-virtual {v0, v1, v2}, Landroid/util/SparseIntArray;->append(II)V

    .line 19
    sget-object v0, Lcom/amazon/identity/auth/accounts/AccountsCallbackHelpers;->ACCOUNT_MANAGER_ERRORS_TO_MAP_ERRORS:Landroid/util/SparseIntArray;

    const/16 v1, 0x8

    sget-object v2, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->BAD_REQUEST:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->value()I

    move-result v2

    invoke-virtual {v0, v1, v2}, Landroid/util/SparseIntArray;->append(II)V

    .line 21
    sget-object v0, Lcom/amazon/identity/auth/accounts/AccountsCallbackHelpers;->ACCOUNT_MANAGER_ERRORS_TO_MAP_ERRORS:Landroid/util/SparseIntArray;

    const/4 v1, 0x4

    sget-object v2, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->REGISTER_FAILED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->value()I

    move-result v2

    invoke-virtual {v0, v1, v2}, Landroid/util/SparseIntArray;->append(II)V

    .line 23
    sget-object v0, Lcom/amazon/identity/auth/accounts/AccountsCallbackHelpers;->ACCOUNT_MANAGER_ERRORS_TO_MAP_ERRORS:Landroid/util/SparseIntArray;

    const/4 v1, 0x5

    sget-object v2, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->PARSE_ERROR:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->value()I

    move-result v2

    invoke-virtual {v0, v1, v2}, Landroid/util/SparseIntArray;->append(II)V

    .line 25
    sget-object v0, Lcom/amazon/identity/auth/accounts/AccountsCallbackHelpers;->ACCOUNT_MANAGER_ERRORS_TO_MAP_ERRORS:Landroid/util/SparseIntArray;

    const/4 v1, 0x3

    sget-object v2, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->NETWORK_FAILURE:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->value()I

    move-result v2

    invoke-virtual {v0, v1, v2}, Landroid/util/SparseIntArray;->append(II)V

    .line 27
    sget-object v0, Lcom/amazon/identity/auth/accounts/AccountsCallbackHelpers;->ACCOUNT_MANAGER_ERRORS_TO_MAP_ERRORS:Landroid/util/SparseIntArray;

    const/4 v1, 0x1

    sget-object v2, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->REGISTER_FAILED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->value()I

    move-result v2

    invoke-virtual {v0, v1, v2}, Landroid/util/SparseIntArray;->append(II)V

    .line 29
    sget-object v0, Lcom/amazon/identity/auth/accounts/AccountsCallbackHelpers;->ACCOUNT_MANAGER_ERRORS_TO_MAP_ERRORS:Landroid/util/SparseIntArray;

    const/4 v1, 0x6

    sget-object v2, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->UNRECOGNIZED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->value()I

    move-result v2

    invoke-virtual {v0, v1, v2}, Landroid/util/SparseIntArray;->append(II)V

    .line 31
    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 34
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 35
    return-void
.end method

.method public static accountManagerErrorCodeToMapErrorCode(I)Ljava/lang/Integer;
    .locals 3
    .param p0, "accountManagerErrorCode"    # I

    .prologue
    const/high16 v2, -0x80000000

    .line 125
    sget-object v1, Lcom/amazon/identity/auth/accounts/AccountsCallbackHelpers;->ACCOUNT_MANAGER_ERRORS_TO_MAP_ERRORS:Landroid/util/SparseIntArray;

    invoke-virtual {v1, p0, v2}, Landroid/util/SparseIntArray;->get(II)I

    move-result v0

    .line 126
    .local v0, "mapErrorCode":I
    if-ne v0, v2, :cond_0

    .line 128
    const/4 v1, 0x0

    .line 131
    :goto_0
    return-object v1

    :cond_0
    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    goto :goto_0
.end method

.method public static getAccountManagerErrorBundle(ILjava/lang/String;)Landroid/os/Bundle;
    .locals 3
    .param p0, "accountManagerErrorCode"    # I
    .param p1, "errorMessage"    # Ljava/lang/String;

    .prologue
    .line 82
    invoke-static {p0}, Lcom/amazon/identity/auth/accounts/AccountsCallbackHelpers;->accountManagerErrorCodeToMapErrorCode(I)Ljava/lang/Integer;

    move-result-object v1

    .line 83
    .local v1, "mapErrorCode":Ljava/lang/Integer;
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 84
    .local v0, "errorBundle":Landroid/os/Bundle;
    if-eqz v1, :cond_0

    .line 86
    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v2

    invoke-static {v2, p1}, Lcom/amazon/identity/auth/accounts/AccountsCallbackHelpers;->getErrorBundle(ILjava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    .line 89
    :cond_0
    const-string/jumbo v2, "errorCode"

    invoke-virtual {v0, v2, p0}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 90
    const-string/jumbo v2, "errorMessage"

    invoke-virtual {v0, v2, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 92
    return-object v0
.end method

.method public static getErrorBundle(ILjava/lang/String;)Landroid/os/Bundle;
    .locals 2
    .param p0, "errorCode"    # I
    .param p1, "errorMessage"    # Ljava/lang/String;

    .prologue
    .line 58
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 59
    .local v0, "errorBundle":Landroid/os/Bundle;
    const-string/jumbo v1, "com.amazon.dcp.sso.ErrorCode"

    invoke-virtual {v0, v1, p0}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 60
    const-string/jumbo v1, "com.amazon.dcp.sso.ErrorMessage"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 62
    return-object v0
.end method

.method public static hasError(Landroid/os/Bundle;)Z
    .locals 2
    .param p0, "result"    # Landroid/os/Bundle;

    .prologue
    const/4 v0, 0x0

    .line 114
    if-nez p0, :cond_1

    .line 119
    :cond_0
    :goto_0
    return v0

    :cond_1
    const-string/jumbo v1, "com.amazon.dcp.sso.ErrorCode"

    invoke-virtual {p0, v1}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_2

    const-string/jumbo v1, "errorCode"

    invoke-virtual {p0, v1}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    :cond_2
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public static onAccountAlreadyExistsError(Lcom/amazon/identity/auth/device/api/Callback;Ljava/lang/String;)V
    .locals 3
    .param p0, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;
    .param p1, "directedId"    # Ljava/lang/String;

    .prologue
    .line 136
    if-nez p0, :cond_0

    .line 148
    :goto_0
    return-void

    .line 141
    :cond_0
    sget-object v1, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->ACCOUNT_ALREADY_EXISTS:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->value()I

    move-result v1

    const-string/jumbo v2, "Account has already been registered on this device"

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/accounts/AccountsCallbackHelpers;->getErrorBundle(ILjava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    .line 145
    .local v0, "errorBundle":Landroid/os/Bundle;
    const-string/jumbo v1, "com.amazon.dcp.sso.property.account.acctId"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 147
    invoke-interface {p0, v0}, Lcom/amazon/identity/auth/device/api/Callback;->onError(Landroid/os/Bundle;)V

    goto :goto_0
.end method

.method public static onAccountManagerError(Lcom/amazon/identity/auth/device/api/Callback;ILjava/lang/String;)V
    .locals 1
    .param p0, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;
    .param p1, "accountManagerErrorCode"    # I
    .param p2, "errorMessage"    # Ljava/lang/String;

    .prologue
    .line 72
    if-nez p0, :cond_0

    .line 78
    :goto_0
    return-void

    .line 77
    :cond_0
    invoke-static {p1, p2}, Lcom/amazon/identity/auth/accounts/AccountsCallbackHelpers;->getAccountManagerErrorBundle(ILjava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    invoke-interface {p0, v0}, Lcom/amazon/identity/auth/device/api/Callback;->onError(Landroid/os/Bundle;)V

    goto :goto_0
.end method

.method public static onError(Lcom/amazon/identity/auth/device/api/Callback;ILjava/lang/String;Landroid/os/Bundle;)V
    .locals 1
    .param p0, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;
    .param p1, "errorCode"    # I
    .param p2, "errorMessage"    # Ljava/lang/String;
    .param p3, "extras"    # Landroid/os/Bundle;

    .prologue
    .line 42
    if-nez p0, :cond_0

    .line 54
    :goto_0
    return-void

    .line 47
    :cond_0
    invoke-static {p1, p2}, Lcom/amazon/identity/auth/accounts/AccountsCallbackHelpers;->getErrorBundle(ILjava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    .line 48
    .local v0, "errorBundle":Landroid/os/Bundle;
    if-eqz p3, :cond_1

    .line 50
    invoke-virtual {v0, p3}, Landroid/os/Bundle;->putAll(Landroid/os/Bundle;)V

    .line 53
    :cond_1
    invoke-interface {p0, v0}, Lcom/amazon/identity/auth/device/api/Callback;->onError(Landroid/os/Bundle;)V

    goto :goto_0
.end method

.method public static resultToSuccessOrError(Lcom/amazon/identity/auth/device/api/Callback;Landroid/os/Bundle;)V
    .locals 1
    .param p0, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;
    .param p1, "result"    # Landroid/os/Bundle;

    .prologue
    .line 97
    if-nez p0, :cond_0

    .line 110
    :goto_0
    return-void

    .line 102
    :cond_0
    invoke-static {p1}, Lcom/amazon/identity/auth/accounts/AccountsCallbackHelpers;->hasError(Landroid/os/Bundle;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 104
    invoke-interface {p0, p1}, Lcom/amazon/identity/auth/device/api/Callback;->onError(Landroid/os/Bundle;)V

    goto :goto_0

    .line 108
    :cond_1
    invoke-interface {p0, p1}, Lcom/amazon/identity/auth/device/api/Callback;->onSuccess(Landroid/os/Bundle;)V

    goto :goto_0
.end method
