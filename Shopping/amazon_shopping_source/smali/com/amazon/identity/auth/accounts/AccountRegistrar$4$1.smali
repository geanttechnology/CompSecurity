.class Lcom/amazon/identity/auth/accounts/AccountRegistrar$4$1;
.super Ljava/lang/Object;
.source "AccountRegistrar.java"

# interfaces
.implements Lcom/amazon/identity/auth/device/api/Callback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/identity/auth/accounts/AccountRegistrar$4;->cleanupDeviceState(Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/amazon/identity/auth/accounts/AccountRegistrar$4;

.field final synthetic val$error:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/accounts/AccountRegistrar$4;Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;)V
    .locals 0

    .prologue
    .line 1854
    iput-object p1, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$4$1;->this$1:Lcom/amazon/identity/auth/accounts/AccountRegistrar$4;

    iput-object p2, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$4$1;->val$error:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onError(Landroid/os/Bundle;)V
    .locals 5
    .param p1, "result"    # Landroid/os/Bundle;

    .prologue
    .line 1870
    # getter for: Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->access$000()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    const-string/jumbo v4, "Got error while deregistering device in response to error : "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v4, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$4$1;->val$error:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    invoke-virtual {v4}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->name()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 1872
    const-string/jumbo v2, "com.amazon.dcp.sso.ErrorCode"

    const/4 v3, -0x1

    invoke-virtual {p1, v2, v3}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v0

    .line 1873
    .local v0, "errorCode":I
    const-string/jumbo v2, "com.amazon.dcp.sso.ErrorMessage"

    invoke-virtual {p1, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 1874
    .local v1, "errorMsg":Ljava/lang/String;
    # getter for: Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->access$000()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    const-string/jumbo v4, "Error Code: "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 1875
    # getter for: Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->access$000()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    const-string/jumbo v4, "Error message: "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 1876
    return-void
.end method

.method public onSuccess(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "result"    # Landroid/os/Bundle;

    .prologue
    .line 1858
    const-string/jumbo v0, "com.amazon.dcp.sso.ErrorCode"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1860
    invoke-virtual {p0, p1}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$4$1;->onError(Landroid/os/Bundle;)V

    .line 1865
    :goto_0
    return-void

    .line 1864
    :cond_0
    # getter for: Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->access$000()Ljava/lang/String;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    const-string/jumbo v2, "Finished deregistering device in response to error : "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$4$1;->val$error:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    invoke-virtual {v2}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->name()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method
