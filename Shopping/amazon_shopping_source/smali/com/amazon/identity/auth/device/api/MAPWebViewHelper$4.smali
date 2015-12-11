.class Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$4;
.super Ljava/lang/Object;
.source "MAPWebViewHelper.java"

# interfaces
.implements Lcom/amazon/identity/auth/device/api/Callback;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;

.field final synthetic val$activity:Landroid/app/Activity;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;Landroid/app/Activity;)V
    .locals 0

    .prologue
    .line 536
    iput-object p1, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$4;->this$0:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;

    iput-object p2, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$4;->val$activity:Landroid/app/Activity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onError(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "result"    # Landroid/os/Bundle;

    .prologue
    .line 563
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$4;->this$0:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;

    # getter for: Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mClientEventCallback:Lcom/amazon/identity/auth/device/api/Callback;
    invoke-static {v0}, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->access$400(Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;)Lcom/amazon/identity/auth/device/api/Callback;

    move-result-object v0

    invoke-static {p1, v0}, Lcom/amazon/identity/auth/device/api/MAPWebViewEventHelper;->setError(Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;)V

    .line 564
    return-void
.end method

.method public onSuccess(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "result"    # Landroid/os/Bundle;

    .prologue
    .line 542
    const-string/jumbo v2, "com.amazon.identity.auth.device.api.cookiekeys.all"

    invoke-virtual {p1, v2}, Landroid/os/Bundle;->getStringArray(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    .line 543
    .local v0, "cookies":[Ljava/lang/String;
    if-eqz v0, :cond_0

    array-length v2, v0

    if-nez v2, :cond_1

    .line 547
    :cond_0
    :try_start_0
    # getter for: Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->access$700()Ljava/lang/String;

    .line 548
    iget-object v2, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$4;->this$0:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;

    iget-object v3, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$4;->val$activity:Landroid/app/Activity;

    # invokes: Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->startAuthentication(Landroid/app/Activity;)V
    invoke-static {v2, v3}, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->access$800(Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;Landroid/app/Activity;)V
    :try_end_0
    .catch Ljava/lang/NoSuchFieldError; {:try_start_0 .. :try_end_0} :catch_0

    .line 558
    :cond_1
    :goto_0
    return-void

    .line 550
    :catch_0
    move-exception v1

    .line 552
    .local v1, "nsfe":Ljava/lang/NoSuchFieldError;
    # getter for: Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->access$700()Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string/jumbo v3, "Android Resource error: "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1}, Ljava/lang/NoSuchFieldError;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 553
    sget-object v2, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->BAD_REQUEST:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->value()I

    move-result v2

    const-string/jumbo v3, "NoSuchFieldError: Check your resources."

    invoke-static {v2, v3}, Lcom/amazon/identity/auth/device/token/TokenCallbackHelpers;->getErrorBundle(ILjava/lang/String;)Landroid/os/Bundle;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$4;->this$0:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;

    # getter for: Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mClientEventCallback:Lcom/amazon/identity/auth/device/api/Callback;
    invoke-static {v3}, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->access$400(Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;)Lcom/amazon/identity/auth/device/api/Callback;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/amazon/identity/auth/device/api/MAPWebViewEventHelper;->setError(Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;)V

    goto :goto_0
.end method
