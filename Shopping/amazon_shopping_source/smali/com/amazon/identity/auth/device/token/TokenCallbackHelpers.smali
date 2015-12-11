.class public final Lcom/amazon/identity/auth/device/token/TokenCallbackHelpers;
.super Ljava/lang/Object;
.source "TokenCallbackHelpers.java"


# static fields
.field private static final ACCOUNT_MANAGER_ERRORS_TO_MAP_ERRORS:Landroid/util/SparseIntArray;

.field private static final TAG:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 15
    const-class v0, Lcom/amazon/identity/auth/device/token/TokenCallbackHelpers;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/token/TokenCallbackHelpers;->TAG:Ljava/lang/String;

    .line 18
    new-instance v0, Landroid/util/SparseIntArray;

    invoke-direct {v0}, Landroid/util/SparseIntArray;-><init>()V

    .line 21
    sput-object v0, Lcom/amazon/identity/auth/device/token/TokenCallbackHelpers;->ACCOUNT_MANAGER_ERRORS_TO_MAP_ERRORS:Landroid/util/SparseIntArray;

    const/4 v1, 0x7

    sget-object v2, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->BAD_REQUEST:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->value()I

    move-result v2

    invoke-virtual {v0, v1, v2}, Landroid/util/SparseIntArray;->append(II)V

    .line 23
    sget-object v0, Lcom/amazon/identity/auth/device/token/TokenCallbackHelpers;->ACCOUNT_MANAGER_ERRORS_TO_MAP_ERRORS:Landroid/util/SparseIntArray;

    const/16 v1, 0x8

    sget-object v2, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->BAD_REQUEST:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->value()I

    move-result v2

    invoke-virtual {v0, v1, v2}, Landroid/util/SparseIntArray;->append(II)V

    .line 25
    sget-object v0, Lcom/amazon/identity/auth/device/token/TokenCallbackHelpers;->ACCOUNT_MANAGER_ERRORS_TO_MAP_ERRORS:Landroid/util/SparseIntArray;

    const/4 v1, 0x4

    sget-object v2, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->REGISTER_FAILED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->value()I

    move-result v2

    invoke-virtual {v0, v1, v2}, Landroid/util/SparseIntArray;->append(II)V

    .line 27
    sget-object v0, Lcom/amazon/identity/auth/device/token/TokenCallbackHelpers;->ACCOUNT_MANAGER_ERRORS_TO_MAP_ERRORS:Landroid/util/SparseIntArray;

    const/4 v1, 0x5

    sget-object v2, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->PARSE_ERROR:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->value()I

    move-result v2

    invoke-virtual {v0, v1, v2}, Landroid/util/SparseIntArray;->append(II)V

    .line 29
    sget-object v0, Lcom/amazon/identity/auth/device/token/TokenCallbackHelpers;->ACCOUNT_MANAGER_ERRORS_TO_MAP_ERRORS:Landroid/util/SparseIntArray;

    const/4 v1, 0x3

    sget-object v2, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->NETWORK_FAILURE:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->value()I

    move-result v2

    invoke-virtual {v0, v1, v2}, Landroid/util/SparseIntArray;->append(II)V

    .line 31
    sget-object v0, Lcom/amazon/identity/auth/device/token/TokenCallbackHelpers;->ACCOUNT_MANAGER_ERRORS_TO_MAP_ERRORS:Landroid/util/SparseIntArray;

    const/4 v1, 0x1

    sget-object v2, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->REGISTER_FAILED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->value()I

    move-result v2

    invoke-virtual {v0, v1, v2}, Landroid/util/SparseIntArray;->append(II)V

    .line 33
    sget-object v0, Lcom/amazon/identity/auth/device/token/TokenCallbackHelpers;->ACCOUNT_MANAGER_ERRORS_TO_MAP_ERRORS:Landroid/util/SparseIntArray;

    const/4 v1, 0x6

    sget-object v2, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->UNRECOGNIZED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->value()I

    move-result v2

    invoke-virtual {v0, v1, v2}, Landroid/util/SparseIntArray;->append(II)V

    .line 35
    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 38
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 39
    return-void
.end method

.method public static accountManagerErrorCodeToMapErrorCode(I)Ljava/lang/Integer;
    .locals 3
    .param p0, "accountManagerErrorCode"    # I

    .prologue
    const/high16 v2, -0x80000000

    .line 99
    sget-object v1, Lcom/amazon/identity/auth/device/token/TokenCallbackHelpers;->ACCOUNT_MANAGER_ERRORS_TO_MAP_ERRORS:Landroid/util/SparseIntArray;

    invoke-virtual {v1, p0, v2}, Landroid/util/SparseIntArray;->get(II)I

    move-result v0

    .line 100
    .local v0, "mapErrorCode":I
    if-ne v0, v2, :cond_0

    .line 102
    const/4 v1, 0x0

    .line 105
    :goto_0
    return-object v1

    :cond_0
    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    goto :goto_0
.end method

.method public static callbackError(Lcom/amazon/identity/auth/device/api/Callback;ILjava/lang/String;)V
    .locals 2
    .param p0, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;
    .param p1, "errorCode"    # I
    .param p2, "errorMessage"    # Ljava/lang/String;

    .prologue
    .line 54
    if-nez p0, :cond_0

    .line 56
    sget-object v0, Lcom/amazon/identity/auth/device/token/TokenCallbackHelpers;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Cannot callback success because no callback was given"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 61
    :goto_0
    return-void

    .line 60
    :cond_0
    invoke-static {p1, p2}, Lcom/amazon/identity/auth/device/token/TokenCallbackHelpers;->getErrorBundle(ILjava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    invoke-interface {p0, v0}, Lcom/amazon/identity/auth/device/api/Callback;->onError(Landroid/os/Bundle;)V

    goto :goto_0
.end method

.method public static callbackSuccess(Lcom/amazon/identity/auth/device/api/Callback;Ljava/lang/String;)V
    .locals 2
    .param p0, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;
    .param p1, "tokenValue"    # Ljava/lang/String;

    .prologue
    .line 43
    if-nez p0, :cond_0

    .line 45
    sget-object v0, Lcom/amazon/identity/auth/device/token/TokenCallbackHelpers;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Cannot callback success because no callback was given"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 50
    :goto_0
    return-void

    .line 49
    :cond_0
    invoke-static {p1}, Lcom/amazon/identity/auth/device/token/TokenCallbackHelpers;->createSuccessBundle(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    invoke-interface {p0, v0}, Lcom/amazon/identity/auth/device/api/Callback;->onSuccess(Landroid/os/Bundle;)V

    goto :goto_0
.end method

.method public static createSuccessBundle(Ljava/lang/String;)Landroid/os/Bundle;
    .locals 2
    .param p0, "tokenValue"    # Ljava/lang/String;

    .prologue
    .line 65
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 66
    .local v0, "result":Landroid/os/Bundle;
    const-string/jumbo v1, "value_key"

    invoke-virtual {v0, v1, p0}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 67
    return-object v0
.end method

.method public static getAccountManagerErrorBundle(ILjava/lang/String;)Landroid/os/Bundle;
    .locals 3
    .param p0, "accountManagerErrorCode"    # I
    .param p1, "errorMessage"    # Ljava/lang/String;

    .prologue
    .line 84
    invoke-static {p0}, Lcom/amazon/identity/auth/device/token/TokenCallbackHelpers;->accountManagerErrorCodeToMapErrorCode(I)Ljava/lang/Integer;

    move-result-object v1

    .line 85
    .local v1, "mapErrorCode":Ljava/lang/Integer;
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 86
    .local v0, "errorBundle":Landroid/os/Bundle;
    if-eqz v1, :cond_0

    .line 88
    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v2

    invoke-static {v2, p1}, Lcom/amazon/identity/auth/device/token/TokenCallbackHelpers;->getErrorBundle(ILjava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    .line 91
    :cond_0
    const-string/jumbo v2, "errorCode"

    invoke-virtual {v0, v2, p0}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 92
    const-string/jumbo v2, "errorMessage"

    invoke-virtual {v0, v2, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 94
    return-object v0
.end method

.method public static getErrorBundle(ILjava/lang/String;)Landroid/os/Bundle;
    .locals 2
    .param p0, "errorCode"    # I
    .param p1, "errorMessage"    # Ljava/lang/String;

    .prologue
    .line 110
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 111
    .local v0, "errorBundle":Landroid/os/Bundle;
    const-string/jumbo v1, "com.amazon.dcp.sso.ErrorCode"

    invoke-virtual {v0, v1, p0}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 112
    const-string/jumbo v1, "com.amazon.dcp.sso.ErrorMessage"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 114
    return-object v0
.end method

.method public static getErrorBundle(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Ljava/lang/String;)Landroid/os/Bundle;
    .locals 1
    .param p0, "regError"    # Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;
    .param p1, "errorMessage"    # Ljava/lang/String;

    .prologue
    .line 119
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->value()I

    move-result v0

    invoke-static {v0, p1}, Lcom/amazon/identity/auth/device/token/TokenCallbackHelpers;->getErrorBundle(ILjava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    return-object v0
.end method

.method public static onAccountManagerError(Lcom/amazon/identity/auth/device/api/Callback;ILjava/lang/String;)V
    .locals 1
    .param p0, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;
    .param p1, "accountManagerErrorCode"    # I
    .param p2, "errorMessage"    # Ljava/lang/String;

    .prologue
    .line 74
    if-nez p0, :cond_0

    .line 80
    :goto_0
    return-void

    .line 79
    :cond_0
    invoke-static {p1, p2}, Lcom/amazon/identity/auth/device/token/TokenCallbackHelpers;->getAccountManagerErrorBundle(ILjava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    invoke-interface {p0, v0}, Lcom/amazon/identity/auth/device/api/Callback;->onError(Landroid/os/Bundle;)V

    goto :goto_0
.end method
