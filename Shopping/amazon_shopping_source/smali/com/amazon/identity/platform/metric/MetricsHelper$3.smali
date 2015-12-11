.class final Lcom/amazon/identity/platform/metric/MetricsHelper$3;
.super Ljava/lang/Object;
.source "MetricsHelper.java"

# interfaces
.implements Lcom/amazon/identity/auth/device/api/Callback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/identity/platform/metric/MetricsHelper;->wrapRegistrationCallbackWithMetrics(Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;Ljava/lang/String;Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;)Lcom/amazon/identity/auth/device/api/Callback;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# instance fields
.field final synthetic val$callback:Lcom/amazon/identity/auth/device/api/Callback;

.field final synthetic val$defaultError:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

.field final synthetic val$errorCodeKey:Ljava/lang/String;

.field final synthetic val$tracer:Lcom/amazon/identity/auth/device/framework/Tracer;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/device/framework/Tracer;Lcom/amazon/identity/auth/device/api/Callback;Ljava/lang/String;Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;)V
    .locals 0

    .prologue
    .line 289
    iput-object p1, p0, Lcom/amazon/identity/platform/metric/MetricsHelper$3;->val$tracer:Lcom/amazon/identity/auth/device/framework/Tracer;

    iput-object p2, p0, Lcom/amazon/identity/platform/metric/MetricsHelper$3;->val$callback:Lcom/amazon/identity/auth/device/api/Callback;

    iput-object p3, p0, Lcom/amazon/identity/platform/metric/MetricsHelper$3;->val$errorCodeKey:Ljava/lang/String;

    iput-object p4, p0, Lcom/amazon/identity/platform/metric/MetricsHelper$3;->val$defaultError:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onError(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "result"    # Landroid/os/Bundle;

    .prologue
    .line 304
    iget-object v1, p0, Lcom/amazon/identity/platform/metric/MetricsHelper$3;->val$errorCodeKey:Ljava/lang/String;

    iget-object v2, p0, Lcom/amazon/identity/platform/metric/MetricsHelper$3;->val$defaultError:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->value()I

    move-result v2

    invoke-virtual {p1, v1, v2}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v1

    .line 305
    iget-object v2, p0, Lcom/amazon/identity/platform/metric/MetricsHelper$3;->val$defaultError:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->fromValue(ILcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;)Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->getName()Ljava/lang/String;

    move-result-object v0

    .line 307
    .local v0, "errorType":Ljava/lang/String;
    iget-object v1, p0, Lcom/amazon/identity/platform/metric/MetricsHelper$3;->val$tracer:Lcom/amazon/identity/auth/device/framework/Tracer;

    if-eqz v1, :cond_0

    .line 309
    iget-object v1, p0, Lcom/amazon/identity/platform/metric/MetricsHelper$3;->val$tracer:Lcom/amazon/identity/auth/device/framework/Tracer;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string/jumbo v3, "Error:"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/identity/auth/device/framework/Tracer;->incrementCounter(Ljava/lang/String;)V

    .line 310
    iget-object v1, p0, Lcom/amazon/identity/platform/metric/MetricsHelper$3;->val$tracer:Lcom/amazon/identity/auth/device/framework/Tracer;

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/framework/Tracer;->finishTrace()V

    .line 313
    :cond_0
    iget-object v1, p0, Lcom/amazon/identity/platform/metric/MetricsHelper$3;->val$callback:Lcom/amazon/identity/auth/device/api/Callback;

    invoke-interface {v1, p1}, Lcom/amazon/identity/auth/device/api/Callback;->onError(Landroid/os/Bundle;)V

    .line 314
    return-void
.end method

.method public onSuccess(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "result"    # Landroid/os/Bundle;

    .prologue
    .line 293
    iget-object v0, p0, Lcom/amazon/identity/platform/metric/MetricsHelper$3;->val$tracer:Lcom/amazon/identity/auth/device/framework/Tracer;

    if-eqz v0, :cond_0

    .line 295
    iget-object v0, p0, Lcom/amazon/identity/platform/metric/MetricsHelper$3;->val$tracer:Lcom/amazon/identity/auth/device/framework/Tracer;

    const-string/jumbo v1, "Success"

    invoke-virtual {v0, v1}, Lcom/amazon/identity/auth/device/framework/Tracer;->incrementCounter(Ljava/lang/String;)V

    .line 296
    iget-object v0, p0, Lcom/amazon/identity/platform/metric/MetricsHelper$3;->val$tracer:Lcom/amazon/identity/auth/device/framework/Tracer;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/Tracer;->finishTrace()V

    .line 298
    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/platform/metric/MetricsHelper$3;->val$callback:Lcom/amazon/identity/auth/device/api/Callback;

    invoke-interface {v0, p1}, Lcom/amazon/identity/auth/device/api/Callback;->onSuccess(Landroid/os/Bundle;)V

    .line 299
    return-void
.end method
