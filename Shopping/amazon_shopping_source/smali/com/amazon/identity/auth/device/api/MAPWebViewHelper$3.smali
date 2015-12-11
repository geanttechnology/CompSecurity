.class Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$3;
.super Ljava/lang/Object;
.source "MAPWebViewHelper.java"

# interfaces
.implements Lcom/amazon/identity/auth/device/api/Callback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->getCookiesFromTokenManagement(ZLcom/amazon/identity/auth/device/api/Callback;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;

.field final synthetic val$callback:Lcom/amazon/identity/auth/device/api/Callback;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;Lcom/amazon/identity/auth/device/api/Callback;)V
    .locals 0

    .prologue
    .line 484
    iput-object p1, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$3;->this$0:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;

    iput-object p2, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$3;->val$callback:Lcom/amazon/identity/auth/device/api/Callback;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onError(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "result"    # Landroid/os/Bundle;

    .prologue
    .line 510
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$3;->val$callback:Lcom/amazon/identity/auth/device/api/Callback;

    invoke-interface {v0, p1}, Lcom/amazon/identity/auth/device/api/Callback;->onError(Landroid/os/Bundle;)V

    .line 511
    return-void
.end method

.method public onSuccess(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "result"    # Landroid/os/Bundle;

    .prologue
    .line 491
    :try_start_0
    const-string/jumbo v2, "com.amazon.identity.auth.device.api.cookiekeys.all"

    invoke-virtual {p1, v2}, Landroid/os/Bundle;->getStringArray(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    .line 493
    .local v0, "cookies":[Ljava/lang/String;
    iget-object v2, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$3;->this$0:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;

    invoke-static {v2, v0}, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->access$500(Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;[Ljava/lang/String;)V

    .line 496
    iget-object v2, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$3;->this$0:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;

    # invokes: Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->continueLoadingURL()V
    invoke-static {v2}, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->access$600(Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;)V

    .line 498
    iget-object v2, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$3;->val$callback:Lcom/amazon/identity/auth/device/api/Callback;

    invoke-interface {v2, p1}, Lcom/amazon/identity/auth/device/api/Callback;->onSuccess(Landroid/os/Bundle;)V
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    .line 505
    .end local v0    # "cookies":[Ljava/lang/String;
    :goto_0
    return-void

    .line 500
    :catch_0
    move-exception v1

    .line 502
    .local v1, "e":Ljava/lang/RuntimeException;
    # getter for: Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->access$700()Ljava/lang/String;

    move-result-object v2

    const-string/jumbo v3, "Unexpected error during getCookie call"

    invoke-static {v2, v3, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method
