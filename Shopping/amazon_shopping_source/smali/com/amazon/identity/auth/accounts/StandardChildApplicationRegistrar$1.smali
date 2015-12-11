.class Lcom/amazon/identity/auth/accounts/StandardChildApplicationRegistrar$1;
.super Lcom/amazon/identity/kcpsdk/auth/DefaultAmazonWebserviceCallListener;
.source "StandardChildApplicationRegistrar.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/identity/auth/accounts/StandardChildApplicationRegistrar;->registerChild(Ljava/lang/String;Lcom/amazon/identity/kcpsdk/common/WebRequest;Lcom/amazon/identity/auth/accounts/ChildApplicationRegistrarCallback;Lcom/amazon/identity/auth/device/framework/Tracer;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/identity/auth/accounts/StandardChildApplicationRegistrar;

.field final synthetic val$callback:Lcom/amazon/identity/auth/accounts/ChildApplicationRegistrarCallback;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/accounts/StandardChildApplicationRegistrar;Lcom/amazon/identity/auth/accounts/ChildApplicationRegistrarCallback;)V
    .locals 0

    .prologue
    .line 41
    iput-object p1, p0, Lcom/amazon/identity/auth/accounts/StandardChildApplicationRegistrar$1;->this$0:Lcom/amazon/identity/auth/accounts/StandardChildApplicationRegistrar;

    iput-object p2, p0, Lcom/amazon/identity/auth/accounts/StandardChildApplicationRegistrar$1;->val$callback:Lcom/amazon/identity/auth/accounts/ChildApplicationRegistrarCallback;

    invoke-direct {p0}, Lcom/amazon/identity/kcpsdk/auth/DefaultAmazonWebserviceCallListener;-><init>()V

    return-void
.end method


# virtual methods
.method public onAuthenticationFailed()V
    .locals 1

    .prologue
    .line 61
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/StandardChildApplicationRegistrar$1;->val$callback:Lcom/amazon/identity/auth/accounts/ChildApplicationRegistrarCallback;

    invoke-interface {v0}, Lcom/amazon/identity/auth/accounts/ChildApplicationRegistrarCallback;->onAuthenticationFailed()V

    .line 62
    return-void
.end method

.method public onNetworkFailure()V
    .locals 1

    .prologue
    .line 55
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/StandardChildApplicationRegistrar$1;->val$callback:Lcom/amazon/identity/auth/accounts/ChildApplicationRegistrarCallback;

    invoke-interface {v0}, Lcom/amazon/identity/auth/accounts/ChildApplicationRegistrarCallback;->onNetworkError()V

    .line 56
    return-void
.end method

.method public onParseError(Lcom/amazon/identity/kcpsdk/common/ParseError;)V
    .locals 1
    .param p1, "error"    # Lcom/amazon/identity/kcpsdk/common/ParseError;

    .prologue
    .line 67
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/StandardChildApplicationRegistrar$1;->val$callback:Lcom/amazon/identity/auth/accounts/ChildApplicationRegistrarCallback;

    invoke-interface {v0}, Lcom/amazon/identity/auth/accounts/ChildApplicationRegistrarCallback;->onBadResponse()V

    .line 68
    return-void
.end method

.method public onResponseComplete(Ljava/lang/Object;)V
    .locals 2
    .param p1, "response"    # Ljava/lang/Object;

    .prologue
    .line 47
    move-object v0, p1

    check-cast v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;

    .line 49
    .local v0, "childRegisterResponse":Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/StandardChildApplicationRegistrar$1;->val$callback:Lcom/amazon/identity/auth/accounts/ChildApplicationRegistrarCallback;

    invoke-interface {v1, v0}, Lcom/amazon/identity/auth/accounts/ChildApplicationRegistrarCallback;->onRegisterChildApplicationComplete(Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;)V

    .line 50
    return-void
.end method
