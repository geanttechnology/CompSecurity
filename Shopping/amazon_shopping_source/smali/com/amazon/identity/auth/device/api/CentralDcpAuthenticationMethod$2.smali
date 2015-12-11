.class Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod$2;
.super Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;
.source "CentralDcpAuthenticationMethod.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod;

.field final synthetic val$bindTimer:Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

.field final synthetic val$callback:Lcom/amazon/identity/auth/device/api/Callback;

.field final synthetic val$callbackFuture:Lcom/amazon/identity/auth/device/callback/CallbackFuture;

.field final synthetic val$corpus:[B

.field final synthetic val$directedId:Ljava/lang/String;

.field final synthetic val$signCorpusOption:Landroid/os/Bundle;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod;Landroid/content/Context;Landroid/content/Intent;ILcom/amazon/identity/platform/metric/PlatformMetricsTimer;[BLcom/amazon/identity/auth/device/callback/CallbackFuture;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;Ljava/lang/String;)V
    .locals 0
    .param p2, "x0"    # Landroid/content/Context;
    .param p3, "x1"    # Landroid/content/Intent;
    .param p4, "x2"    # I

    .prologue
    .line 325
    iput-object p1, p0, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod$2;->this$0:Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod;

    iput-object p5, p0, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod$2;->val$bindTimer:Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    iput-object p6, p0, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod$2;->val$corpus:[B

    iput-object p7, p0, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod$2;->val$callbackFuture:Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    iput-object p8, p0, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod$2;->val$signCorpusOption:Landroid/os/Bundle;

    iput-object p9, p0, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod$2;->val$callback:Lcom/amazon/identity/auth/device/api/Callback;

    iput-object p10, p0, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod$2;->val$directedId:Ljava/lang/String;

    invoke-direct {p0, p2, p3, p4}, Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;-><init>(Landroid/content/Context;Landroid/content/Intent;I)V

    return-void
.end method


# virtual methods
.method protected serviceDisconnected()V
    .locals 3

    .prologue
    .line 365
    const-string/jumbo v0, "AuthenticatedRequestService is disconnected. It\'s probably crashed."

    .line 366
    .local v0, "errorMessage":Ljava/lang/String;
    # getter for: Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod;->access$100()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 367
    iget-object v1, p0, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod$2;->val$callbackFuture:Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    const/4 v2, 0x1

    invoke-static {v1, v2, v0}, Lcom/amazon/identity/auth/device/utils/ADPCorpusSigningCallbackHelpers;->callbackError(Lcom/amazon/identity/auth/device/callback/CallbackFuture;ILjava/lang/String;)V

    .line 370
    return-void
.end method

.method protected useService(Landroid/os/IBinder;)V
    .locals 9
    .param p1, "service"    # Landroid/os/IBinder;

    .prologue
    const/4 v0, 0x0

    .line 329
    iget-object v2, p0, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod$2;->val$bindTimer:Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    invoke-virtual {v2}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->stop()V

    .line 331
    # getter for: Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod;->METRICS_COMPONENT_NAME:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod;->access$000()Ljava/lang/String;

    move-result-object v2

    const-string/jumbo v3, "signCorpusByDirectedIdWrapper"

    invoke-static {v2, v3}, Lcom/amazon/identity/platform/metric/MetricsHelper;->startVerboseTimer(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    move-result-object v8

    .line 336
    .local v8, "timer":Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    :try_start_0
    iget-object v3, p0, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod$2;->val$corpus:[B

    invoke-static {p1}, Lcom/amazon/dcp/sso/IRequestAuthenticationMethod$Stub;->asInterface(Landroid/os/IBinder;)Lcom/amazon/dcp/sso/IRequestAuthenticationMethod;

    move-result-object v4

    iget-object v2, p0, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod$2;->this$0:Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod;

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod;->getFeatureSet()Lcom/amazon/identity/auth/device/features/FeatureSetCache;

    move-result-object v2

    sget-object v5, Lcom/amazon/identity/auth/device/features/Feature;->DirectedIdSupported:Lcom/amazon/identity/auth/device/features/Feature;

    invoke-virtual {v2, v5}, Lcom/amazon/identity/auth/device/features/FeatureSetCache;->hasFeature(Lcom/amazon/identity/auth/device/features/Feature;)Z

    move-result v2

    if-eqz v2, :cond_0

    const-string/jumbo v0, "SHA256WithRSA"

    iget-object v2, p0, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod$2;->val$directedId:Ljava/lang/String;

    invoke-interface {v4, v0, v2, v3}, Lcom/amazon/dcp/sso/IRequestAuthenticationMethod;->signCorpusByDirectedId(Ljava/lang/String;Ljava/lang/String;[B)Lcom/amazon/dcp/sso/ReturnValueOrError;

    move-result-object v1

    :goto_0
    # getter for: Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod;->access$100()Ljava/lang/String;

    .line 337
    .local v1, "valueOrError":Lcom/amazon/dcp/sso/ReturnValueOrError;
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod$2;->this$0:Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod;

    iget-object v2, p0, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod$2;->val$callbackFuture:Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    iget-object v3, p0, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod$2;->val$corpus:[B

    iget-object v4, p0, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod$2;->val$signCorpusOption:Landroid/os/Bundle;

    iget-object v5, p0, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod$2;->val$callback:Lcom/amazon/identity/auth/device/api/Callback;

    invoke-static/range {v0 .. v5}, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod;->access$300(Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod;Lcom/amazon/dcp/sso/ReturnValueOrError;Lcom/amazon/identity/auth/device/callback/CallbackFuture;[BLandroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 357
    invoke-virtual {v8}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->stop()V

    .line 358
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod$2;->unbind()V

    .line 359
    .end local v1    # "valueOrError":Lcom/amazon/dcp/sso/ReturnValueOrError;
    :goto_1
    return-void

    .line 336
    :cond_0
    :try_start_1
    iget-object v2, p0, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod$2;->this$0:Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod;

    # getter for: Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod;->mContext:Landroid/content/Context;
    invoke-static {v2}, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod;->access$200(Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod;)Landroid/content/Context;

    move-result-object v2

    iget-object v5, p0, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod$2;->val$directedId:Ljava/lang/String;

    invoke-static {v2, v5}, Lcom/amazon/identity/auth/device/utils/BackwardsCompatiabilityHelper;->getAccountWithDirectedId(Landroid/content/Context;Ljava/lang/String;)Landroid/accounts/Account;

    move-result-object v5

    if-eqz v5, :cond_2

    iget-object v2, v5, Landroid/accounts/Account;->type:Ljava/lang/String;

    :goto_2
    if-eqz v5, :cond_1

    iget-object v0, v5, Landroid/accounts/Account;->name:Ljava/lang/String;

    :cond_1
    const-string/jumbo v5, "SHA256WithRSA"

    invoke-interface {v4, v5, v2, v0, v3}, Lcom/amazon/dcp/sso/IRequestAuthenticationMethod;->signCorpus(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[B)Lcom/amazon/dcp/sso/ReturnValueOrError;
    :try_end_1
    .catch Landroid/os/RemoteException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/lang/RuntimeException; {:try_start_1 .. :try_end_1} :catch_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object v1

    goto :goto_0

    :cond_2
    move-object v2, v0

    goto :goto_2

    .line 339
    :catch_0
    move-exception v6

    .line 341
    .local v6, "e":Landroid/os/RemoteException;
    :try_start_2
    const-string/jumbo v7, "Cannot receive corpus authentication from dcp! Connection to DCP has been lost."

    .line 343
    .local v7, "errorMessage":Ljava/lang/String;
    # getter for: Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod;->access$100()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0, v7, v6}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 344
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod$2;->val$callbackFuture:Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    const/4 v2, 0x1

    invoke-static {v0, v2, v7}, Lcom/amazon/identity/auth/device/utils/ADPCorpusSigningCallbackHelpers;->callbackError(Lcom/amazon/identity/auth/device/callback/CallbackFuture;ILjava/lang/String;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 357
    invoke-virtual {v8}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->stop()V

    .line 358
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod$2;->unbind()V

    goto :goto_1

    .line 348
    .end local v6    # "e":Landroid/os/RemoteException;
    .end local v7    # "errorMessage":Ljava/lang/String;
    :catch_1
    move-exception v6

    .line 350
    .local v6, "e":Ljava/lang/RuntimeException;
    :try_start_3
    # getter for: Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod;->access$100()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v2, "Unknown error during signCorpus execution."

    invoke-static {v0, v2, v6}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 351
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod$2;->val$callbackFuture:Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    const/4 v2, 0x5

    invoke-virtual {v6}, Ljava/lang/RuntimeException;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v0, v2, v3}, Lcom/amazon/identity/auth/device/utils/ADPCorpusSigningCallbackHelpers;->callbackError(Lcom/amazon/identity/auth/device/callback/CallbackFuture;ILjava/lang/String;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 357
    invoke-virtual {v8}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->stop()V

    .line 358
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod$2;->unbind()V

    goto :goto_1

    .line 357
    .end local v6    # "e":Ljava/lang/RuntimeException;
    :catchall_0
    move-exception v0

    invoke-virtual {v8}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->stop()V

    .line 358
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod$2;->unbind()V

    throw v0
.end method
