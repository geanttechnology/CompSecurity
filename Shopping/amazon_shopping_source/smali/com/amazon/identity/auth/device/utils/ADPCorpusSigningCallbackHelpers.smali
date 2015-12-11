.class public final Lcom/amazon/identity/auth/device/utils/ADPCorpusSigningCallbackHelpers;
.super Ljava/lang/Object;
.source "ADPCorpusSigningCallbackHelpers.java"


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 14
    return-void
.end method

.method public static callbackError(Lcom/amazon/identity/auth/device/callback/CallbackFuture;ILjava/lang/String;)V
    .locals 1
    .param p0, "callbackFuture"    # Lcom/amazon/identity/auth/device/callback/CallbackFuture;
    .param p1, "errorCode"    # I
    .param p2, "errorMessage"    # Ljava/lang/String;

    .prologue
    .line 27
    invoke-static {p1, p2}, Lcom/amazon/identity/auth/device/utils/ADPCorpusSigningCallbackHelpers;->getErrorBundle(ILjava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/identity/auth/device/callback/CallbackFuture;->onError(Landroid/os/Bundle;)V

    .line 28
    return-void
.end method

.method public static getErrorBundle(ILjava/lang/String;)Landroid/os/Bundle;
    .locals 2
    .param p0, "errorCode"    # I
    .param p1, "errorMessage"    # Ljava/lang/String;

    .prologue
    .line 32
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 34
    .local v0, "errorBundle":Landroid/os/Bundle;
    const-string/jumbo v1, "error_code_key"

    invoke-virtual {v0, v1, p0}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 35
    const-string/jumbo v1, "error_message_key"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 37
    return-object v0
.end method

.method public static nullCorpusCallbackError(Lcom/amazon/identity/auth/device/callback/CallbackFuture;Ljava/lang/String;)V
    .locals 2
    .param p0, "callbackFuture"    # Lcom/amazon/identity/auth/device/callback/CallbackFuture;
    .param p1, "tag"    # Ljava/lang/String;

    .prologue
    .line 18
    const-string/jumbo v0, "Cannot sign a null corpus."

    .line 19
    .local v0, "errorMessage":Ljava/lang/String;
    invoke-static {p1, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 20
    const/4 v1, 0x3

    invoke-static {p0, v1, v0}, Lcom/amazon/identity/auth/device/utils/ADPCorpusSigningCallbackHelpers;->callbackError(Lcom/amazon/identity/auth/device/callback/CallbackFuture;ILjava/lang/String;)V

    .line 21
    return-void
.end method
