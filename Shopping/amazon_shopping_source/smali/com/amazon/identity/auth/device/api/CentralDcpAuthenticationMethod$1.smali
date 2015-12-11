.class Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod$1;
.super Lcom/amazon/identity/auth/device/framework/SyncBoundServiceCaller;
.source "CentralDcpAuthenticationMethod.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod;->getAuthenticationBundle(Landroid/net/Uri;Ljava/lang/String;Ljava/util/Map;[BLcom/amazon/identity/auth/device/callback/CallbackFuture;)Lcom/amazon/identity/auth/device/api/MAPFuture;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod;

.field final synthetic val$bindTimer:Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

.field final synthetic val$body:[B

.field final synthetic val$headers:Ljava/util/Map;

.field final synthetic val$requestAuthVal:Ljava/util/concurrent/atomic/AtomicReference;

.field final synthetic val$serviceUri:Landroid/net/Uri;

.field final synthetic val$verb:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod;Landroid/content/Context;Landroid/content/Intent;ILcom/amazon/identity/platform/metric/PlatformMetricsTimer;Landroid/net/Uri;Ljava/lang/String;Ljava/util/Map;[BLjava/util/concurrent/atomic/AtomicReference;)V
    .locals 0
    .param p2, "x0"    # Landroid/content/Context;
    .param p3, "x1"    # Landroid/content/Intent;
    .param p4, "x2"    # I

    .prologue
    .line 91
    iput-object p1, p0, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod$1;->this$0:Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod;

    iput-object p5, p0, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod$1;->val$bindTimer:Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    iput-object p6, p0, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod$1;->val$serviceUri:Landroid/net/Uri;

    iput-object p7, p0, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod$1;->val$verb:Ljava/lang/String;

    iput-object p8, p0, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod$1;->val$headers:Ljava/util/Map;

    iput-object p9, p0, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod$1;->val$body:[B

    iput-object p10, p0, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod$1;->val$requestAuthVal:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-direct {p0, p2, p3, p4}, Lcom/amazon/identity/auth/device/framework/SyncBoundServiceCaller;-><init>(Landroid/content/Context;Landroid/content/Intent;I)V

    return-void
.end method


# virtual methods
.method protected useService(Landroid/os/IBinder;)V
    .locals 19
    .param p1, "service"    # Landroid/os/IBinder;

    .prologue
    .line 96
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod$1;->val$bindTimer:Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    invoke-virtual {v1}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->stop()V

    .line 97
    # getter for: Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod;->METRICS_COMPONENT_NAME:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod;->access$000()Ljava/lang/String;

    move-result-object v1

    const-string/jumbo v2, "getAuthenticationParams"

    invoke-static {v1, v2}, Lcom/amazon/identity/platform/metric/MetricsHelper;->startVerboseTimer(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    move-result-object v17

    .line 102
    .local v17, "timer":Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    :try_start_0
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod$1;->val$serviceUri:Landroid/net/Uri;

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod$1;->val$verb:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v8, v0, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod$1;->val$headers:Ljava/util/Map;

    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod$1;->val$body:[B

    invoke-static/range {p1 .. p1}, Lcom/amazon/dcp/sso/IRequestAuthenticationMethod$Stub;->asInterface(Landroid/os/IBinder;)Lcom/amazon/dcp/sso/IRequestAuthenticationMethod;

    move-result-object v1

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod$1;->this$0:Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod;

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod;->getAuthenticationType()Ljava/lang/String;

    move-result-object v2

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod$1;->this$0:Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod;

    invoke-virtual {v3}, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod;->getAccount()Ljava/lang/String;

    move-result-object v3

    sget-object v9, Ljava/util/Collections;->EMPTY_MAP:Ljava/util/Map;

    const/4 v6, 0x0

    new-array v6, v6, [B

    sget-object v10, Lcom/amazon/identity/auth/device/api/AuthenticationType;->OAuth:Lcom/amazon/identity/auth/device/api/AuthenticationType;

    invoke-virtual {v10}, Lcom/amazon/identity/auth/device/api/AuthenticationType;->getValue()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v10, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-nez v10, :cond_3

    move-object v6, v8

    :goto_0
    move-object/from16 v0, p0

    iget-object v8, v0, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod$1;->this$0:Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod;

    invoke-virtual {v8}, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod;->getFeatureSet()Lcom/amazon/identity/auth/device/features/FeatureSetCache;

    move-result-object v8

    sget-object v9, Lcom/amazon/identity/auth/device/features/Feature;->DirectedIdSupported:Lcom/amazon/identity/auth/device/features/Feature;

    invoke-virtual {v8, v9}, Lcom/amazon/identity/auth/device/features/FeatureSetCache;->hasFeature(Lcom/amazon/identity/auth/device/features/Feature;)Z

    move-result v8

    if-eqz v8, :cond_0

    invoke-interface/range {v1 .. v7}, Lcom/amazon/dcp/sso/IRequestAuthenticationMethod;->getAuthenticationParametersForRequestByDirectedId(Ljava/lang/String;Ljava/lang/String;Landroid/net/Uri;Ljava/lang/String;Ljava/util/Map;[B)Lcom/amazon/dcp/sso/ReturnValueOrError;

    move-result-object v18

    :goto_1
    # getter for: Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod;->access$100()Ljava/lang/String;
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 120
    .local v18, "valueOrError":Lcom/amazon/dcp/sso/ReturnValueOrError;
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod$1;->val$requestAuthVal:Ljava/util/concurrent/atomic/AtomicReference;

    move-object/from16 v0, v18

    invoke-virtual {v1, v0}, Ljava/util/concurrent/atomic/AtomicReference;->set(Ljava/lang/Object;)V

    .line 121
    invoke-virtual/range {v17 .. v17}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->stop()V

    .line 122
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod$1;->doneUsingService()V

    .line 123
    :goto_2
    return-void

    .line 102
    .end local v18    # "valueOrError":Lcom/amazon/dcp/sso/ReturnValueOrError;
    :cond_0
    :try_start_1
    move-object/from16 v0, p0

    iget-object v8, v0, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod$1;->this$0:Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod;

    # getter for: Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod;->mContext:Landroid/content/Context;
    invoke-static {v8}, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod;->access$200(Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod;)Landroid/content/Context;

    move-result-object v8

    invoke-static {v8, v3}, Lcom/amazon/identity/auth/device/utils/BackwardsCompatiabilityHelper;->getAccountWithDirectedId(Landroid/content/Context;Ljava/lang/String;)Landroid/accounts/Account;

    move-result-object v3

    if-eqz v3, :cond_1

    iget-object v10, v3, Landroid/accounts/Account;->type:Ljava/lang/String;

    :goto_3
    if-eqz v3, :cond_2

    iget-object v11, v3, Landroid/accounts/Account;->name:Ljava/lang/String;

    :goto_4
    move-object v8, v1

    move-object v9, v2

    move-object v12, v4

    move-object v13, v5

    move-object v14, v6

    move-object v15, v7

    invoke-interface/range {v8 .. v15}, Lcom/amazon/dcp/sso/IRequestAuthenticationMethod;->getAuthenticationParametersForRequest(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/net/Uri;Ljava/lang/String;Ljava/util/Map;[B)Lcom/amazon/dcp/sso/ReturnValueOrError;
    :try_end_1
    .catch Landroid/os/RemoteException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/lang/RuntimeException; {:try_start_1 .. :try_end_1} :catch_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object v18

    goto :goto_1

    :cond_1
    const/4 v10, 0x0

    goto :goto_3

    :cond_2
    const/4 v11, 0x0

    goto :goto_4

    .line 104
    :catch_0
    move-exception v16

    .line 106
    .local v16, "e":Landroid/os/RemoteException;
    :try_start_2
    # getter for: Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod;->access$100()Ljava/lang/String;

    move-result-object v1

    const-string/jumbo v2, "Could not receive request authentication from dcp!"

    move-object/from16 v0, v16

    invoke-static {v1, v2, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 107
    new-instance v18, Lcom/amazon/dcp/sso/ReturnValueOrError;

    const/4 v1, 0x6

    const-string/jumbo v2, "Connection to DCP has been lost"

    move-object/from16 v0, v18

    invoke-direct {v0, v1, v2}, Lcom/amazon/dcp/sso/ReturnValueOrError;-><init>(ILjava/lang/String;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 120
    .restart local v18    # "valueOrError":Lcom/amazon/dcp/sso/ReturnValueOrError;
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod$1;->val$requestAuthVal:Ljava/util/concurrent/atomic/AtomicReference;

    move-object/from16 v0, v18

    invoke-virtual {v1, v0}, Ljava/util/concurrent/atomic/AtomicReference;->set(Ljava/lang/Object;)V

    .line 121
    invoke-virtual/range {v17 .. v17}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->stop()V

    .line 122
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod$1;->doneUsingService()V

    goto :goto_2

    .line 111
    .end local v16    # "e":Landroid/os/RemoteException;
    .end local v18    # "valueOrError":Lcom/amazon/dcp/sso/ReturnValueOrError;
    :catch_1
    move-exception v16

    .line 113
    .local v16, "e":Ljava/lang/RuntimeException;
    :try_start_3
    # getter for: Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod;->access$100()Ljava/lang/String;

    move-result-object v1

    const-string/jumbo v2, "Unknown error during getAuthenticationBundle execution."

    move-object/from16 v0, v16

    invoke-static {v1, v2, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 114
    new-instance v18, Lcom/amazon/dcp/sso/ReturnValueOrError;

    const/4 v1, 0x5

    invoke-virtual/range {v16 .. v16}, Ljava/lang/RuntimeException;->toString()Ljava/lang/String;

    move-result-object v2

    move-object/from16 v0, v18

    invoke-direct {v0, v1, v2}, Lcom/amazon/dcp/sso/ReturnValueOrError;-><init>(ILjava/lang/String;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 120
    .restart local v18    # "valueOrError":Lcom/amazon/dcp/sso/ReturnValueOrError;
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod$1;->val$requestAuthVal:Ljava/util/concurrent/atomic/AtomicReference;

    move-object/from16 v0, v18

    invoke-virtual {v1, v0}, Ljava/util/concurrent/atomic/AtomicReference;->set(Ljava/lang/Object;)V

    .line 121
    invoke-virtual/range {v17 .. v17}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->stop()V

    .line 122
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod$1;->doneUsingService()V

    goto :goto_2

    .line 120
    .end local v16    # "e":Ljava/lang/RuntimeException;
    .end local v18    # "valueOrError":Lcom/amazon/dcp/sso/ReturnValueOrError;
    :catchall_0
    move-exception v1

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod$1;->val$requestAuthVal:Ljava/util/concurrent/atomic/AtomicReference;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Ljava/util/concurrent/atomic/AtomicReference;->set(Ljava/lang/Object;)V

    .line 121
    invoke-virtual/range {v17 .. v17}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->stop()V

    .line 122
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/identity/auth/device/api/CentralDcpAuthenticationMethod$1;->doneUsingService()V

    throw v1

    :cond_3
    move-object v7, v6

    move-object v6, v9

    goto/16 :goto_0
.end method
