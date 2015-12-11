.class Lcom/amazon/identity/auth/accounts/SubAuthChildApplicationRegistrar$1;
.super Lcom/amazon/dcp/sso/IWebserviceCallback$Stub;
.source "SubAuthChildApplicationRegistrar.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/identity/auth/accounts/SubAuthChildApplicationRegistrar;->registerChild(Ljava/lang/String;Lcom/amazon/identity/kcpsdk/common/WebRequest;Lcom/amazon/identity/auth/accounts/ChildApplicationRegistrarCallback;Lcom/amazon/identity/auth/device/framework/Tracer;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/identity/auth/accounts/SubAuthChildApplicationRegistrar;

.field final synthetic val$callback:Lcom/amazon/identity/auth/accounts/ChildApplicationRegistrarCallback;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/accounts/SubAuthChildApplicationRegistrar;Lcom/amazon/identity/auth/accounts/ChildApplicationRegistrarCallback;)V
    .locals 0

    .prologue
    .line 43
    iput-object p1, p0, Lcom/amazon/identity/auth/accounts/SubAuthChildApplicationRegistrar$1;->this$0:Lcom/amazon/identity/auth/accounts/SubAuthChildApplicationRegistrar;

    iput-object p2, p0, Lcom/amazon/identity/auth/accounts/SubAuthChildApplicationRegistrar$1;->val$callback:Lcom/amazon/identity/auth/accounts/ChildApplicationRegistrarCallback;

    invoke-direct {p0}, Lcom/amazon/dcp/sso/IWebserviceCallback$Stub;-><init>()V

    return-void
.end method


# virtual methods
.method public onAuthenticationFailed()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 71
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/SubAuthChildApplicationRegistrar$1;->val$callback:Lcom/amazon/identity/auth/accounts/ChildApplicationRegistrarCallback;

    invoke-interface {v0}, Lcom/amazon/identity/auth/accounts/ChildApplicationRegistrarCallback;->onAuthenticationFailed()V

    .line 72
    return-void
.end method

.method public onBadResponse()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 77
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/SubAuthChildApplicationRegistrar$1;->val$callback:Lcom/amazon/identity/auth/accounts/ChildApplicationRegistrarCallback;

    invoke-interface {v0}, Lcom/amazon/identity/auth/accounts/ChildApplicationRegistrarCallback;->onBadResponse()V

    .line 78
    return-void
.end method

.method public onInvalidRequest()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 83
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/SubAuthChildApplicationRegistrar$1;->val$callback:Lcom/amazon/identity/auth/accounts/ChildApplicationRegistrarCallback;

    invoke-interface {v0}, Lcom/amazon/identity/auth/accounts/ChildApplicationRegistrarCallback;->onInvalidRequest()V

    .line 84
    return-void
.end method

.method public onNetworkError()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 64
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/SubAuthChildApplicationRegistrar$1;->val$callback:Lcom/amazon/identity/auth/accounts/ChildApplicationRegistrarCallback;

    invoke-interface {v0}, Lcom/amazon/identity/auth/accounts/ChildApplicationRegistrarCallback;->onNetworkError()V

    .line 65
    return-void
.end method

.method public onResponseReceived(JLjava/util/Map;[B)V
    .locals 3
    .param p1, "statusCode"    # J
    .param p3, "headers"    # Ljava/util/Map;
    .param p4, "body"    # [B
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 51
    move-object v1, p3

    .line 53
    .local v1, "strHeaders":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/SubAuthChildApplicationRegistrar$1;->this$0:Lcom/amazon/identity/auth/accounts/SubAuthChildApplicationRegistrar;

    invoke-static {v2, p1, p2, v1, p4}, Lcom/amazon/identity/auth/accounts/SubAuthChildApplicationRegistrar;->access$000(Lcom/amazon/identity/auth/accounts/SubAuthChildApplicationRegistrar;JLjava/util/Map;[B)Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;

    move-result-object v0

    .line 58
    .local v0, "exchangeTokenResponse":Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;
    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/SubAuthChildApplicationRegistrar$1;->val$callback:Lcom/amazon/identity/auth/accounts/ChildApplicationRegistrarCallback;

    invoke-interface {v2, v0}, Lcom/amazon/identity/auth/accounts/ChildApplicationRegistrarCallback;->onRegisterChildApplicationComplete(Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;)V

    .line 59
    return-void
.end method
