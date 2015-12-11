.class public final Lcom/amazon/identity/auth/attributes/AttributeCallbackHelpers;
.super Ljava/lang/Object;
.source "AttributeCallbackHelpers.java"


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 13
    return-void
.end method

.method public static callbackWithError(Lcom/amazon/identity/auth/device/api/Callback;ILjava/lang/String;)V
    .locals 1
    .param p0, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;
    .param p1, "errorCode"    # I
    .param p2, "errorMessage"    # Ljava/lang/String;

    .prologue
    .line 17
    if-nez p0, :cond_0

    .line 23
    :goto_0
    return-void

    .line 22
    :cond_0
    invoke-static {p1, p2}, Lcom/amazon/identity/auth/attributes/AttributeCallbackHelpers;->createErrorResult(ILjava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    invoke-interface {p0, v0}, Lcom/amazon/identity/auth/device/api/Callback;->onError(Landroid/os/Bundle;)V

    goto :goto_0
.end method

.method public static createErrorResult(ILjava/lang/String;)Landroid/os/Bundle;
    .locals 2
    .param p0, "errorCode"    # I
    .param p1, "errorMessage"    # Ljava/lang/String;

    .prologue
    .line 27
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 29
    .local v0, "errorBundle":Landroid/os/Bundle;
    const-string/jumbo v1, "error_code_key"

    invoke-virtual {v0, v1, p0}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 30
    const-string/jumbo v1, "error_message_key"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 32
    return-object v0
.end method
