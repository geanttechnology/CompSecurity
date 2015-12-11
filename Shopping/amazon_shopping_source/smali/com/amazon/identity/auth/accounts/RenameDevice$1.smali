.class Lcom/amazon/identity/auth/accounts/RenameDevice$1;
.super Lcom/amazon/identity/kcpsdk/auth/DefaultAmazonWebserviceCallListener;
.source "RenameDevice.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/identity/auth/accounts/RenameDevice;->renameDevice(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/identity/auth/accounts/RenameDevice;

.field final synthetic val$callback:Lcom/amazon/identity/auth/device/api/Callback;

.field final synthetic val$directedId:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/accounts/RenameDevice;Lcom/amazon/identity/auth/device/api/Callback;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 74
    iput-object p1, p0, Lcom/amazon/identity/auth/accounts/RenameDevice$1;->this$0:Lcom/amazon/identity/auth/accounts/RenameDevice;

    iput-object p2, p0, Lcom/amazon/identity/auth/accounts/RenameDevice$1;->val$callback:Lcom/amazon/identity/auth/device/api/Callback;

    iput-object p3, p0, Lcom/amazon/identity/auth/accounts/RenameDevice$1;->val$directedId:Ljava/lang/String;

    invoke-direct {p0}, Lcom/amazon/identity/kcpsdk/auth/DefaultAmazonWebserviceCallListener;-><init>()V

    return-void
.end method


# virtual methods
.method public onAuthenticationFailed()V
    .locals 4

    .prologue
    .line 86
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/RenameDevice$1;->this$0:Lcom/amazon/identity/auth/accounts/RenameDevice;

    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/RenameDevice$1;->val$callback:Lcom/amazon/identity/auth/device/api/Callback;

    const/4 v2, 0x2

    const-string/jumbo v3, "Authentication failure performing rename device request"

    # invokes: Lcom/amazon/identity/auth/accounts/RenameDevice;->callbackOnError(Lcom/amazon/identity/auth/device/api/Callback;ILjava/lang/String;)V
    invoke-static {v0, v1, v2, v3}, Lcom/amazon/identity/auth/accounts/RenameDevice;->access$000(Lcom/amazon/identity/auth/accounts/RenameDevice;Lcom/amazon/identity/auth/device/api/Callback;ILjava/lang/String;)V

    .line 89
    return-void
.end method

.method public onNetworkFailure()V
    .locals 4

    .prologue
    .line 78
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/RenameDevice$1;->this$0:Lcom/amazon/identity/auth/accounts/RenameDevice;

    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/RenameDevice$1;->val$callback:Lcom/amazon/identity/auth/device/api/Callback;

    const/4 v2, 0x1

    const-string/jumbo v3, "Network failure performing rename device request"

    # invokes: Lcom/amazon/identity/auth/accounts/RenameDevice;->callbackOnError(Lcom/amazon/identity/auth/device/api/Callback;ILjava/lang/String;)V
    invoke-static {v0, v1, v2, v3}, Lcom/amazon/identity/auth/accounts/RenameDevice;->access$000(Lcom/amazon/identity/auth/accounts/RenameDevice;Lcom/amazon/identity/auth/device/api/Callback;ILjava/lang/String;)V

    .line 81
    return-void
.end method

.method public onParseError(Lcom/amazon/identity/kcpsdk/common/ParseError;)V
    .locals 4
    .param p1, "error"    # Lcom/amazon/identity/kcpsdk/common/ParseError;

    .prologue
    .line 94
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/RenameDevice$1;->this$0:Lcom/amazon/identity/auth/accounts/RenameDevice;

    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/RenameDevice$1;->val$callback:Lcom/amazon/identity/auth/device/api/Callback;

    const/4 v2, 0x4

    const-string/jumbo v3, "Parsing failure performing rename device request"

    # invokes: Lcom/amazon/identity/auth/accounts/RenameDevice;->callbackOnError(Lcom/amazon/identity/auth/device/api/Callback;ILjava/lang/String;)V
    invoke-static {v0, v1, v2, v3}, Lcom/amazon/identity/auth/accounts/RenameDevice;->access$000(Lcom/amazon/identity/auth/accounts/RenameDevice;Lcom/amazon/identity/auth/device/api/Callback;ILjava/lang/String;)V

    .line 97
    return-void
.end method

.method public onResponseComplete(Ljava/lang/Object;)V
    .locals 7
    .param p1, "response"    # Ljava/lang/Object;

    .prologue
    .line 102
    # getter for: Lcom/amazon/identity/auth/accounts/RenameDevice;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/RenameDevice;->access$100()Ljava/lang/String;

    move-result-object v3

    const-string/jumbo v4, "Completed the rename device request"

    invoke-static {v3, v4}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    move-object v2, p1

    .line 103
    check-cast v2, Lcom/amazon/identity/kcpsdk/auth/RenameDeviceResponse;

    .line 105
    .local v2, "renameDeviceResponse":Lcom/amazon/identity/kcpsdk/auth/RenameDeviceResponse;
    if-nez v2, :cond_0

    .line 107
    iget-object v3, p0, Lcom/amazon/identity/auth/accounts/RenameDevice$1;->this$0:Lcom/amazon/identity/auth/accounts/RenameDevice;

    iget-object v4, p0, Lcom/amazon/identity/auth/accounts/RenameDevice$1;->val$callback:Lcom/amazon/identity/auth/device/api/Callback;

    const/4 v5, 0x7

    const-string/jumbo v6, " Unrecognized response from server"

    # invokes: Lcom/amazon/identity/auth/accounts/RenameDevice;->callbackOnError(Lcom/amazon/identity/auth/device/api/Callback;ILjava/lang/String;)V
    invoke-static {v3, v4, v5, v6}, Lcom/amazon/identity/auth/accounts/RenameDevice;->access$000(Lcom/amazon/identity/auth/accounts/RenameDevice;Lcom/amazon/identity/auth/device/api/Callback;ILjava/lang/String;)V

    .line 124
    :goto_0
    return-void

    .line 111
    :cond_0
    invoke-virtual {v2}, Lcom/amazon/identity/kcpsdk/auth/RenameDeviceResponse;->getError()I

    move-result v0

    .line 112
    .local v0, "errorCode":I
    invoke-virtual {v2}, Lcom/amazon/identity/kcpsdk/auth/RenameDeviceResponse;->getMessage()Ljava/lang/String;

    move-result-object v1

    .line 113
    .local v1, "message":Ljava/lang/String;
    if-nez v0, :cond_1

    .line 115
    # getter for: Lcom/amazon/identity/auth/accounts/RenameDevice;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/RenameDevice;->access$100()Ljava/lang/String;

    move-result-object v3

    const-string/jumbo v4, "Successfully completed the rename device request"

    invoke-static {v3, v4}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 116
    iget-object v3, p0, Lcom/amazon/identity/auth/accounts/RenameDevice$1;->this$0:Lcom/amazon/identity/auth/accounts/RenameDevice;

    # getter for: Lcom/amazon/identity/auth/accounts/RenameDevice;->mAmazonAccountManager:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;
    invoke-static {v3}, Lcom/amazon/identity/auth/accounts/RenameDevice;->access$200(Lcom/amazon/identity/auth/accounts/RenameDevice;)Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/identity/auth/accounts/RenameDevice$1;->val$directedId:Ljava/lang/String;

    const-string/jumbo v5, "com.amazon.dcp.sso.property.devicename"

    invoke-virtual {v3, v4, v5, v1}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->setUserData(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 117
    # getter for: Lcom/amazon/identity/auth/accounts/RenameDevice;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/RenameDevice;->access$100()Ljava/lang/String;

    move-result-object v3

    const-string/jumbo v4, "RenameDevice completed successfully."

    invoke-static {v3, v4}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 118
    invoke-static {}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->renameDeviceRequestSuccess()V

    .line 119
    iget-object v3, p0, Lcom/amazon/identity/auth/accounts/RenameDevice$1;->val$callback:Lcom/amazon/identity/auth/device/api/Callback;

    iget-object v4, p0, Lcom/amazon/identity/auth/accounts/RenameDevice$1;->this$0:Lcom/amazon/identity/auth/accounts/RenameDevice;

    invoke-static {v4, v1}, Lcom/amazon/identity/auth/accounts/RenameDevice;->access$300(Lcom/amazon/identity/auth/accounts/RenameDevice;Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v4

    invoke-interface {v3, v4}, Lcom/amazon/identity/auth/device/api/Callback;->onSuccess(Landroid/os/Bundle;)V

    goto :goto_0

    .line 123
    :cond_1
    iget-object v3, p0, Lcom/amazon/identity/auth/accounts/RenameDevice$1;->this$0:Lcom/amazon/identity/auth/accounts/RenameDevice;

    iget-object v4, p0, Lcom/amazon/identity/auth/accounts/RenameDevice$1;->val$callback:Lcom/amazon/identity/auth/device/api/Callback;

    # invokes: Lcom/amazon/identity/auth/accounts/RenameDevice;->callbackOnError(Lcom/amazon/identity/auth/device/api/Callback;ILjava/lang/String;)V
    invoke-static {v3, v4, v0, v1}, Lcom/amazon/identity/auth/accounts/RenameDevice;->access$000(Lcom/amazon/identity/auth/accounts/RenameDevice;Lcom/amazon/identity/auth/device/api/Callback;ILjava/lang/String;)V

    goto :goto_0
.end method
