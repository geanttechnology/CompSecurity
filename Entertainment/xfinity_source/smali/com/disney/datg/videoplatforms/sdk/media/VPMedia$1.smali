.class Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;
.super Ljava/lang/Object;
.source "VPMedia.java"

# interfaces
.implements Ljava/util/concurrent/Callable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getPlayableAssetUrl(Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;)Ljava/util/concurrent/Future;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/util/concurrent/Callable",
        "<",
        "Ljava/lang/String;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

.field final synthetic val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;


# direct methods
.method constructor <init>(Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;)V
    .locals 0

    .prologue
    .line 277
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    iput-object p2, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public bridge synthetic call()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 277
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->call()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public call()Ljava/lang/String;
    .locals 26
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 283
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    move-object/from16 v21, v0

    if-eqz v21, :cond_0

    .line 284
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    move-object/from16 v21, v0

    invoke-interface/range {v21 .. v21}, Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;->onAsyncTask()V

    .line 287
    :cond_0
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    move-object/from16 v21, v0

    # getter for: Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->configuration:Lcom/disney/datg/videoplatforms/sdk/media/Configuration;
    invoke-static/range {v21 .. v21}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->access$000(Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;)Lcom/disney/datg/videoplatforms/sdk/media/Configuration;

    move-result-object v21

    if-nez v21, :cond_1

    .line 288
    new-instance v21, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v22, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_INVALID_CONFIGURATION:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    const-string v23, "misconfiguration - configuration was not set up correctly"

    invoke-direct/range {v21 .. v23}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;Ljava/lang/String;)V

    throw v21

    .line 290
    :cond_1
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    move-object/from16 v21, v0

    # getter for: Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->configuration:Lcom/disney/datg/videoplatforms/sdk/media/Configuration;
    invoke-static/range {v21 .. v21}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->access$000(Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;)Lcom/disney/datg/videoplatforms/sdk/media/Configuration;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->getCurrentConfig()Lcom/disney/datg/videoplatforms/sdk/models/api/Config;

    move-result-object v21

    if-nez v21, :cond_2

    .line 291
    new-instance v21, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v22, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_INVALID_CONFIGURATION:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    const-string v23, "misconfiguration - config was never called"

    invoke-direct/range {v21 .. v23}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;Ljava/lang/String;)V

    throw v21

    .line 294
    :cond_2
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    move-object/from16 v21, v0

    move-object/from16 v0, v21

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->accessWindow:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AccessWindow;

    move-object/from16 v21, v0

    sget-object v22, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AccessWindow;->SUBSCRIPTION:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AccessWindow;

    move-object/from16 v0, v21

    move-object/from16 v1, v22

    if-ne v0, v1, :cond_8

    .line 296
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    move-object/from16 v21, v0

    sget-object v22, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;->WAITING:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;

    move-object/from16 v0, v22

    move-object/from16 v1, v21

    iput-object v0, v1, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->authState:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;

    .line 301
    :try_start_0
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    move-object/from16 v21, v0

    new-instance v22, Ljava/util/concurrent/CountDownLatch;

    const/16 v23, 0x1

    invoke-direct/range {v22 .. v23}, Ljava/util/concurrent/CountDownLatch;-><init>(I)V

    move-object/from16 v0, v22

    move-object/from16 v1, v21

    iput-object v0, v1, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->signal:Ljava/util/concurrent/CountDownLatch;

    .line 303
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    move-object/from16 v21, v0

    invoke-virtual/range {v21 .. v21}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getOnAuthorizationListener()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$VPMediaAuthorizationListener;

    move-result-object v21

    if-eqz v21, :cond_3

    .line 304
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    move-object/from16 v21, v0

    invoke-virtual/range {v21 .. v21}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getOnAuthorizationListener()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$VPMediaAuthorizationListener;

    move-result-object v21

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    move-object/from16 v22, v0

    invoke-interface/range {v21 .. v22}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$VPMediaAuthorizationListener;->onAuthorizationTokenRequest(Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;)V

    .line 309
    :cond_3
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    move-object/from16 v21, v0

    move-object/from16 v0, v21

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->signal:Ljava/util/concurrent/CountDownLatch;

    move-object/from16 v21, v0

    sget v22, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->AUTHZ_TIMEOUT:I

    move/from16 v0, v22

    int-to-long v0, v0

    move-wide/from16 v22, v0

    sget-object v24, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-virtual/range {v21 .. v24}, Ljava/util/concurrent/CountDownLatch;->await(JLjava/util/concurrent/TimeUnit;)Z

    move-result v5

    .line 311
    .local v5, "countDownReachZero":Z
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    move-object/from16 v21, v0

    move-object/from16 v0, v21

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->tokenToAuthorize:Lcom/disney/datg/videoplatforms/sdk/common/VPAuthToken;

    move-object/from16 v21, v0

    if-nez v21, :cond_8

    .line 312
    if-eqz v5, :cond_6

    .line 313
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    move-object/from16 v21, v0

    sget-object v22, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;->NOT_AUTHORIZED:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;

    move-object/from16 v0, v22

    move-object/from16 v1, v21

    iput-object v0, v1, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->authState:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;

    .line 314
    new-instance v6, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v21, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_INVALID_AUTHTOKEN_FORMAT_EXCEPTION:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    const-string v22, "invalid VPAuthToken"

    move-object/from16 v0, v21

    move-object/from16 v1, v22

    invoke-direct {v6, v0, v1}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;Ljava/lang/String;)V

    .line 315
    .local v6, "e":Ljava/lang/Exception;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    move-object/from16 v21, v0

    if-eqz v21, :cond_4

    .line 316
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    move-object/from16 v21, v0

    move-object/from16 v0, v21

    invoke-interface {v0, v6}, Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;->onError(Ljava/lang/Exception;)V

    .line 318
    :cond_4
    throw v6
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 329
    .end local v5    # "countDownReachZero":Z
    .end local v6    # "e":Ljava/lang/Exception;
    :catch_0
    move-exception v6

    .line 330
    .restart local v6    # "e":Ljava/lang/Exception;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    move-object/from16 v21, v0

    if-eqz v21, :cond_5

    .line 331
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    move-object/from16 v21, v0

    move-object/from16 v0, v21

    invoke-interface {v0, v6}, Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;->onError(Ljava/lang/Exception;)V

    .line 333
    :cond_5
    throw v6

    .line 320
    .end local v6    # "e":Ljava/lang/Exception;
    .restart local v5    # "countDownReachZero":Z
    :cond_6
    :try_start_1
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    move-object/from16 v21, v0

    sget-object v22, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;->TIMEOUT:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;

    move-object/from16 v0, v22

    move-object/from16 v1, v21

    iput-object v0, v1, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->authState:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;

    .line 321
    new-instance v6, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v21, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_AUTHZ_TIMEOUT_EXCEPTION:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    const-string v22, "timeout occurred while waiting for AuthToken"

    move-object/from16 v0, v21

    move-object/from16 v1, v22

    invoke-direct {v6, v0, v1}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;Ljava/lang/String;)V

    .line 322
    .restart local v6    # "e":Ljava/lang/Exception;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    move-object/from16 v21, v0

    if-eqz v21, :cond_7

    .line 323
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    move-object/from16 v21, v0

    move-object/from16 v0, v21

    invoke-interface {v0, v6}, Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;->onError(Ljava/lang/Exception;)V

    .line 325
    :cond_7
    throw v6
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    .line 339
    .end local v5    # "countDownReachZero":Z
    .end local v6    # "e":Ljava/lang/Exception;
    :cond_8
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    move-object/from16 v21, v0

    # getter for: Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->configuration:Lcom/disney/datg/videoplatforms/sdk/media/Configuration;
    invoke-static/range {v21 .. v21}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->access$000(Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;)Lcom/disney/datg/videoplatforms/sdk/media/Configuration;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->getCurrentConfig()Lcom/disney/datg/videoplatforms/sdk/models/api/Config;

    move-result-object v21

    const-string v22, "entitlement-manifest"

    invoke-virtual/range {v21 .. v22}, Lcom/disney/datg/videoplatforms/sdk/models/api/Config;->getURLFromWebServiceName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v19

    .line 340
    .local v19, "url":Ljava/lang/String;
    invoke-static/range {v19 .. v19}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v21

    if-eqz v21, :cond_9

    .line 341
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    move-object/from16 v21, v0

    if-eqz v21, :cond_9

    .line 342
    new-instance v6, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v21, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_SERVICE_UNDEFINED_HOST:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    const-string v22, "entitlement url could not be resolved from Config"

    move-object/from16 v0, v21

    move-object/from16 v1, v22

    invoke-direct {v6, v0, v1}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;Ljava/lang/String;)V

    .line 344
    .restart local v6    # "e":Ljava/lang/Exception;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    move-object/from16 v21, v0

    move-object/from16 v0, v21

    invoke-interface {v0, v6}, Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;->onError(Ljava/lang/Exception;)V

    .line 345
    throw v6

    .line 350
    .end local v6    # "e":Ljava/lang/Exception;
    :cond_9
    new-instance v18, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1$1;

    move-object/from16 v0, v18

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1$1;-><init>(Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;)V

    .line 376
    .local v18, "postParameters":Lorg/springframework/util/MultiValueMap;, "Lorg/springframework/util/MultiValueMap<Ljava/lang/String;Ljava/lang/String;>;"
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    move-object/from16 v21, v0

    sget-object v22, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;->VALIDATE:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;

    move-object/from16 v0, v22

    move-object/from16 v1, v21

    iput-object v0, v1, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->authState:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;

    .line 378
    new-instance v14, Lcom/disney/datg/videoplatforms/sdk/service/PlayManifestAccessor;

    const/16 v21, 0x0

    move-object/from16 v0, v19

    move-object/from16 v1, v18

    move-object/from16 v2, v21

    invoke-direct {v14, v0, v1, v2}, Lcom/disney/datg/videoplatforms/sdk/service/PlayManifestAccessor;-><init>(Ljava/lang/String;Lorg/springframework/util/MultiValueMap;Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;)V

    .line 381
    .local v14, "manifestAccessor":Lcom/disney/datg/videoplatforms/sdk/service/PlayManifestAccessor;
    :try_start_2
    invoke-virtual {v14}, Lcom/disney/datg/videoplatforms/sdk/service/PlayManifestAccessor;->getServiceAsync()Ljava/util/concurrent/Future;

    move-result-object v12

    .line 382
    .local v12, "futureManifestResponseEntity":Ljava/util/concurrent/Future;, "Ljava/util/concurrent/Future<Lorg/springframework/http/ResponseEntity<Lcom/disney/datg/videoplatforms/sdk/models/api/PlayManifest;>;>;"
    sget v21, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->SERVICE_TIMEOUT:I

    move/from16 v0, v21

    int-to-long v0, v0

    move-wide/from16 v22, v0

    sget-object v21, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    move-wide/from16 v0, v22

    move-object/from16 v2, v21

    invoke-interface {v12, v0, v1, v2}, Ljava/util/concurrent/Future;->get(JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;

    move-result-object v16

    check-cast v16, Lorg/springframework/http/ResponseEntity;

    .line 383
    .local v16, "manifestResponseEntity":Lorg/springframework/http/ResponseEntity;, "Lorg/springframework/http/ResponseEntity<Lcom/disney/datg/videoplatforms/sdk/models/api/PlayManifest;>;"
    if-nez v16, :cond_d

    .line 384
    new-instance v21, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v22, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_AUTHZ_FAILED_EXCEPTION:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    invoke-direct/range {v21 .. v22}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;)V

    throw v21
    :try_end_2
    .catch Ljava/lang/InterruptedException; {:try_start_2 .. :try_end_2} :catch_1
    .catch Ljava/util/concurrent/ExecutionException; {:try_start_2 .. :try_end_2} :catch_2
    .catch Ljava/util/concurrent/RejectedExecutionException; {:try_start_2 .. :try_end_2} :catch_3
    .catch Ljava/util/concurrent/TimeoutException; {:try_start_2 .. :try_end_2} :catch_4
    .catch Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException; {:try_start_2 .. :try_end_2} :catch_5
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_6

    .line 440
    .end local v12    # "futureManifestResponseEntity":Ljava/util/concurrent/Future;, "Ljava/util/concurrent/Future<Lorg/springframework/http/ResponseEntity<Lcom/disney/datg/videoplatforms/sdk/models/api/PlayManifest;>;>;"
    .end local v16    # "manifestResponseEntity":Lorg/springframework/http/ResponseEntity;, "Lorg/springframework/http/ResponseEntity<Lcom/disney/datg/videoplatforms/sdk/models/api/PlayManifest;>;"
    :catch_1
    move-exception v6

    .line 441
    .local v6, "e":Ljava/lang/InterruptedException;
    new-instance v11, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v21, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_AUTHZ_FAILED_EXCEPTION:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    move-object/from16 v0, v21

    invoke-direct {v11, v0, v6}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;Ljava/lang/Throwable;)V

    .line 442
    .local v11, "ex":Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    move-object/from16 v21, v0

    if-eqz v21, :cond_a

    .line 443
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    move-object/from16 v21, v0

    move-object/from16 v0, v21

    invoke-interface {v0, v11}, Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;->onError(Ljava/lang/Exception;)V

    .line 444
    :cond_a
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    move-object/from16 v21, v0

    invoke-virtual/range {v21 .. v21}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getOnAuthorizationListener()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$VPMediaAuthorizationListener;

    move-result-object v21

    if-eqz v21, :cond_b

    .line 445
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    move-object/from16 v21, v0

    invoke-virtual/range {v21 .. v21}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getOnAuthorizationListener()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$VPMediaAuthorizationListener;

    move-result-object v21

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    move-object/from16 v22, v0

    invoke-virtual {v11}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;->getErrorCode()Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    move-result-object v23

    invoke-virtual/range {v23 .. v23}, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->getReason()Ljava/lang/String;

    move-result-object v23

    invoke-interface/range {v21 .. v23}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$VPMediaAuthorizationListener;->onAuthorizationFailure(Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;Ljava/lang/String;)V

    .line 447
    :cond_b
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    move-object/from16 v21, v0

    sget-object v22, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;->NOT_AUTHORIZED:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;

    move-object/from16 v0, v22

    move-object/from16 v1, v21

    iput-object v0, v1, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->authState:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;

    .line 497
    .end local v6    # "e":Ljava/lang/InterruptedException;
    .end local v11    # "ex":Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;
    :cond_c
    :goto_0
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    move-object/from16 v21, v0

    const/16 v22, 0x0

    move-object/from16 v0, v22

    move-object/from16 v1, v21

    iput-object v0, v1, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->tokenToAuthorize:Lcom/disney/datg/videoplatforms/sdk/common/VPAuthToken;

    .line 498
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    move-object/from16 v21, v0

    invoke-virtual/range {v21 .. v21}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getAssetUrl()Ljava/lang/String;

    move-result-object v21

    return-object v21

    .line 386
    .restart local v12    # "futureManifestResponseEntity":Ljava/util/concurrent/Future;, "Ljava/util/concurrent/Future<Lorg/springframework/http/ResponseEntity<Lcom/disney/datg/videoplatforms/sdk/models/api/PlayManifest;>;>;"
    .restart local v16    # "manifestResponseEntity":Lorg/springframework/http/ResponseEntity;, "Lorg/springframework/http/ResponseEntity<Lcom/disney/datg/videoplatforms/sdk/models/api/PlayManifest;>;"
    :cond_d
    :try_start_3
    invoke-virtual/range {v16 .. v16}, Lorg/springframework/http/ResponseEntity;->getBody()Ljava/lang/Object;

    move-result-object v15

    check-cast v15, Lcom/disney/datg/videoplatforms/sdk/models/api/PlayManifest;

    .line 387
    .local v15, "manifestResponse":Lcom/disney/datg/videoplatforms/sdk/models/api/PlayManifest;
    if-eqz v15, :cond_c

    .line 388
    invoke-virtual {v15}, Lcom/disney/datg/videoplatforms/sdk/models/api/PlayManifest;->getEntitlmentResponse()Lcom/disney/datg/videoplatforms/sdk/models/api/ResponseMessage;

    move-result-object v7

    .line 389
    .local v7, "entitlementResponse":Lcom/disney/datg/videoplatforms/sdk/models/api/ResponseMessage;
    if-eqz v7, :cond_15

    invoke-virtual {v7}, Lcom/disney/datg/videoplatforms/sdk/models/api/ResponseMessage;->getErrors()Lcom/disney/datg/videoplatforms/sdk/models/api/ErrorData;

    move-result-object v21

    if-eqz v21, :cond_15

    .line 390
    invoke-virtual {v7}, Lcom/disney/datg/videoplatforms/sdk/models/api/ResponseMessage;->getErrors()Lcom/disney/datg/videoplatforms/sdk/models/api/ErrorData;

    move-result-object v8

    .line 391
    .local v8, "errorData":Lcom/disney/datg/videoplatforms/sdk/models/api/ErrorData;
    new-instance v10, Ljava/lang/StringBuffer;

    invoke-direct {v10}, Ljava/lang/StringBuffer;-><init>()V

    .line 392
    .local v10, "errorResponse":Ljava/lang/StringBuffer;
    invoke-virtual {v8}, Lcom/disney/datg/videoplatforms/sdk/models/api/ErrorData;->getErrors()Ljava/util/List;

    move-result-object v21

    invoke-interface/range {v21 .. v21}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v13

    .local v13, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v13}, Ljava/util/Iterator;->hasNext()Z

    move-result v21

    if-eqz v21, :cond_10

    invoke-interface {v13}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Lcom/disney/datg/videoplatforms/sdk/models/api/ErrorMessage;

    .line 393
    .local v9, "errorMessage":Lcom/disney/datg/videoplatforms/sdk/models/api/ErrorMessage;
    invoke-virtual {v9}, Lcom/disney/datg/videoplatforms/sdk/models/api/ErrorMessage;->getCode()I

    move-result v21

    invoke-static/range {v21 .. v21}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v21

    move-object/from16 v0, v21

    invoke-virtual {v10, v0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v21

    const-string v22, ","

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;
    :try_end_3
    .catch Ljava/lang/InterruptedException; {:try_start_3 .. :try_end_3} :catch_1
    .catch Ljava/util/concurrent/ExecutionException; {:try_start_3 .. :try_end_3} :catch_2
    .catch Ljava/util/concurrent/RejectedExecutionException; {:try_start_3 .. :try_end_3} :catch_3
    .catch Ljava/util/concurrent/TimeoutException; {:try_start_3 .. :try_end_3} :catch_4
    .catch Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException; {:try_start_3 .. :try_end_3} :catch_5
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_6

    goto :goto_1

    .line 449
    .end local v7    # "entitlementResponse":Lcom/disney/datg/videoplatforms/sdk/models/api/ResponseMessage;
    .end local v8    # "errorData":Lcom/disney/datg/videoplatforms/sdk/models/api/ErrorData;
    .end local v9    # "errorMessage":Lcom/disney/datg/videoplatforms/sdk/models/api/ErrorMessage;
    .end local v10    # "errorResponse":Ljava/lang/StringBuffer;
    .end local v12    # "futureManifestResponseEntity":Ljava/util/concurrent/Future;, "Ljava/util/concurrent/Future<Lorg/springframework/http/ResponseEntity<Lcom/disney/datg/videoplatforms/sdk/models/api/PlayManifest;>;>;"
    .end local v13    # "i$":Ljava/util/Iterator;
    .end local v15    # "manifestResponse":Lcom/disney/datg/videoplatforms/sdk/models/api/PlayManifest;
    .end local v16    # "manifestResponseEntity":Lorg/springframework/http/ResponseEntity;, "Lorg/springframework/http/ResponseEntity<Lcom/disney/datg/videoplatforms/sdk/models/api/PlayManifest;>;"
    :catch_2
    move-exception v6

    .line 450
    .local v6, "e":Ljava/util/concurrent/ExecutionException;
    new-instance v11, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v21, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_AUTHZ_FAILED_EXCEPTION:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    move-object/from16 v0, v21

    invoke-direct {v11, v0, v6}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;Ljava/lang/Throwable;)V

    .line 451
    .restart local v11    # "ex":Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    move-object/from16 v21, v0

    if-eqz v21, :cond_e

    .line 452
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    move-object/from16 v21, v0

    move-object/from16 v0, v21

    invoke-interface {v0, v11}, Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;->onError(Ljava/lang/Exception;)V

    .line 453
    :cond_e
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    move-object/from16 v21, v0

    invoke-virtual/range {v21 .. v21}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getOnAuthorizationListener()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$VPMediaAuthorizationListener;

    move-result-object v21

    if-eqz v21, :cond_f

    .line 454
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    move-object/from16 v21, v0

    invoke-virtual/range {v21 .. v21}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getOnAuthorizationListener()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$VPMediaAuthorizationListener;

    move-result-object v21

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    move-object/from16 v22, v0

    invoke-virtual {v11}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;->getErrorCode()Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    move-result-object v23

    invoke-virtual/range {v23 .. v23}, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->getReason()Ljava/lang/String;

    move-result-object v23

    invoke-interface/range {v21 .. v23}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$VPMediaAuthorizationListener;->onAuthorizationFailure(Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;Ljava/lang/String;)V

    .line 456
    :cond_f
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    move-object/from16 v21, v0

    sget-object v22, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;->NOT_AUTHORIZED:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;

    move-object/from16 v0, v22

    move-object/from16 v1, v21

    iput-object v0, v1, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->authState:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;

    goto/16 :goto_0

    .line 396
    .end local v6    # "e":Ljava/util/concurrent/ExecutionException;
    .end local v11    # "ex":Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;
    .restart local v7    # "entitlementResponse":Lcom/disney/datg/videoplatforms/sdk/models/api/ResponseMessage;
    .restart local v8    # "errorData":Lcom/disney/datg/videoplatforms/sdk/models/api/ErrorData;
    .restart local v10    # "errorResponse":Ljava/lang/StringBuffer;
    .restart local v12    # "futureManifestResponseEntity":Ljava/util/concurrent/Future;, "Ljava/util/concurrent/Future<Lorg/springframework/http/ResponseEntity<Lcom/disney/datg/videoplatforms/sdk/models/api/PlayManifest;>;>;"
    .restart local v13    # "i$":Ljava/util/Iterator;
    .restart local v15    # "manifestResponse":Lcom/disney/datg/videoplatforms/sdk/models/api/PlayManifest;
    .restart local v16    # "manifestResponseEntity":Lorg/springframework/http/ResponseEntity;, "Lorg/springframework/http/ResponseEntity<Lcom/disney/datg/videoplatforms/sdk/models/api/PlayManifest;>;"
    :cond_10
    :try_start_4
    invoke-virtual {v10}, Ljava/lang/StringBuffer;->length()I

    move-result v21

    if-lez v21, :cond_14

    const/16 v21, 0x0

    invoke-virtual {v10}, Ljava/lang/StringBuffer;->length()I

    move-result v22

    add-int/lit8 v22, v22, -0x1

    move/from16 v0, v21

    move/from16 v1, v22

    invoke-virtual {v10, v0, v1}, Ljava/lang/StringBuffer;->substring(II)Ljava/lang/String;

    move-result-object v21

    :goto_2
    invoke-virtual/range {v21 .. v21}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v17

    .line 397
    .local v17, "message":Ljava/lang/String;
    new-instance v6, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v21, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_AUTHZ_FAILED_EXCEPTION:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    const-string v22, "%s-errorCodes:%s"

    const/16 v23, 0x2

    move/from16 v0, v23

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v23, v0

    const/16 v24, 0x0

    sget-object v25, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_AUTHZ_FAILED_EXCEPTION:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    invoke-virtual/range {v25 .. v25}, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->toString()Ljava/lang/String;

    move-result-object v25

    aput-object v25, v23, v24

    const/16 v24, 0x1

    aput-object v17, v23, v24

    invoke-static/range {v22 .. v23}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, v21

    move-object/from16 v1, v22

    invoke-direct {v6, v0, v1}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;Ljava/lang/String;)V

    .line 398
    .local v6, "e":Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    move-object/from16 v21, v0

    sget-object v22, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;->NOT_AUTHORIZED:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;

    move-object/from16 v0, v22

    move-object/from16 v1, v21

    iput-object v0, v1, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->authState:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;

    .line 399
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    move-object/from16 v21, v0

    if-eqz v21, :cond_11

    .line 400
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    move-object/from16 v21, v0

    move-object/from16 v0, v21

    invoke-interface {v0, v6}, Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;->onError(Ljava/lang/Exception;)V

    .line 401
    :cond_11
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    move-object/from16 v21, v0

    invoke-virtual/range {v21 .. v21}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getOnAuthorizationListener()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$VPMediaAuthorizationListener;

    move-result-object v21

    if-eqz v21, :cond_c

    .line 402
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    move-object/from16 v21, v0

    invoke-virtual/range {v21 .. v21}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getOnAuthorizationListener()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$VPMediaAuthorizationListener;

    move-result-object v21

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    move-object/from16 v22, v0

    invoke-virtual {v6}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;->getErrorCode()Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    move-result-object v23

    invoke-virtual/range {v23 .. v23}, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->getReason()Ljava/lang/String;

    move-result-object v23

    invoke-interface/range {v21 .. v23}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$VPMediaAuthorizationListener;->onAuthorizationFailure(Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;Ljava/lang/String;)V
    :try_end_4
    .catch Ljava/lang/InterruptedException; {:try_start_4 .. :try_end_4} :catch_1
    .catch Ljava/util/concurrent/ExecutionException; {:try_start_4 .. :try_end_4} :catch_2
    .catch Ljava/util/concurrent/RejectedExecutionException; {:try_start_4 .. :try_end_4} :catch_3
    .catch Ljava/util/concurrent/TimeoutException; {:try_start_4 .. :try_end_4} :catch_4
    .catch Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException; {:try_start_4 .. :try_end_4} :catch_5
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_6

    goto/16 :goto_0

    .line 458
    .end local v6    # "e":Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;
    .end local v7    # "entitlementResponse":Lcom/disney/datg/videoplatforms/sdk/models/api/ResponseMessage;
    .end local v8    # "errorData":Lcom/disney/datg/videoplatforms/sdk/models/api/ErrorData;
    .end local v10    # "errorResponse":Ljava/lang/StringBuffer;
    .end local v12    # "futureManifestResponseEntity":Ljava/util/concurrent/Future;, "Ljava/util/concurrent/Future<Lorg/springframework/http/ResponseEntity<Lcom/disney/datg/videoplatforms/sdk/models/api/PlayManifest;>;>;"
    .end local v13    # "i$":Ljava/util/Iterator;
    .end local v15    # "manifestResponse":Lcom/disney/datg/videoplatforms/sdk/models/api/PlayManifest;
    .end local v16    # "manifestResponseEntity":Lorg/springframework/http/ResponseEntity;, "Lorg/springframework/http/ResponseEntity<Lcom/disney/datg/videoplatforms/sdk/models/api/PlayManifest;>;"
    .end local v17    # "message":Ljava/lang/String;
    :catch_3
    move-exception v6

    .line 459
    .local v6, "e":Ljava/util/concurrent/RejectedExecutionException;
    new-instance v11, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v21, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_AUTHZ_FAILED_EXCEPTION:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    move-object/from16 v0, v21

    invoke-direct {v11, v0, v6}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;Ljava/lang/Throwable;)V

    .line 460
    .restart local v11    # "ex":Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    move-object/from16 v21, v0

    if-eqz v21, :cond_12

    .line 461
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    move-object/from16 v21, v0

    move-object/from16 v0, v21

    invoke-interface {v0, v11}, Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;->onError(Ljava/lang/Exception;)V

    .line 462
    :cond_12
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    move-object/from16 v21, v0

    invoke-virtual/range {v21 .. v21}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getOnAuthorizationListener()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$VPMediaAuthorizationListener;

    move-result-object v21

    if-eqz v21, :cond_13

    .line 463
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    move-object/from16 v21, v0

    invoke-virtual/range {v21 .. v21}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getOnAuthorizationListener()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$VPMediaAuthorizationListener;

    move-result-object v21

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    move-object/from16 v22, v0

    invoke-virtual {v11}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;->getErrorCode()Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    move-result-object v23

    invoke-virtual/range {v23 .. v23}, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->getReason()Ljava/lang/String;

    move-result-object v23

    invoke-interface/range {v21 .. v23}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$VPMediaAuthorizationListener;->onAuthorizationFailure(Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;Ljava/lang/String;)V

    .line 465
    :cond_13
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    move-object/from16 v21, v0

    sget-object v22, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;->NOT_AUTHORIZED:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;

    move-object/from16 v0, v22

    move-object/from16 v1, v21

    iput-object v0, v1, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->authState:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;

    goto/16 :goto_0

    .line 396
    .end local v6    # "e":Ljava/util/concurrent/RejectedExecutionException;
    .end local v11    # "ex":Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;
    .restart local v7    # "entitlementResponse":Lcom/disney/datg/videoplatforms/sdk/models/api/ResponseMessage;
    .restart local v8    # "errorData":Lcom/disney/datg/videoplatforms/sdk/models/api/ErrorData;
    .restart local v10    # "errorResponse":Ljava/lang/StringBuffer;
    .restart local v12    # "futureManifestResponseEntity":Ljava/util/concurrent/Future;, "Ljava/util/concurrent/Future<Lorg/springframework/http/ResponseEntity<Lcom/disney/datg/videoplatforms/sdk/models/api/PlayManifest;>;>;"
    .restart local v13    # "i$":Ljava/util/Iterator;
    .restart local v15    # "manifestResponse":Lcom/disney/datg/videoplatforms/sdk/models/api/PlayManifest;
    .restart local v16    # "manifestResponseEntity":Lorg/springframework/http/ResponseEntity;, "Lorg/springframework/http/ResponseEntity<Lcom/disney/datg/videoplatforms/sdk/models/api/PlayManifest;>;"
    :cond_14
    :try_start_5
    const-string v21, ""

    goto/16 :goto_2

    .line 409
    .end local v8    # "errorData":Lcom/disney/datg/videoplatforms/sdk/models/api/ErrorData;
    .end local v10    # "errorResponse":Ljava/lang/StringBuffer;
    .end local v13    # "i$":Ljava/util/Iterator;
    :cond_15
    invoke-virtual {v15}, Lcom/disney/datg/videoplatforms/sdk/models/api/PlayManifest;->getVideo()Lcom/disney/datg/videoplatforms/sdk/models/api/Video;

    move-result-object v21

    if-eqz v21, :cond_16

    invoke-virtual {v15}, Lcom/disney/datg/videoplatforms/sdk/models/api/PlayManifest;->getVideo()Lcom/disney/datg/videoplatforms/sdk/models/api/Video;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Lcom/disney/datg/videoplatforms/sdk/models/api/Video;->getAssets()Lcom/disney/datg/videoplatforms/sdk/models/api/Assets;

    move-result-object v21

    if-eqz v21, :cond_16

    invoke-virtual {v15}, Lcom/disney/datg/videoplatforms/sdk/models/api/PlayManifest;->getVideo()Lcom/disney/datg/videoplatforms/sdk/models/api/Video;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Lcom/disney/datg/videoplatforms/sdk/models/api/Video;->getAssets()Lcom/disney/datg/videoplatforms/sdk/models/api/Assets;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Lcom/disney/datg/videoplatforms/sdk/models/api/Assets;->getAsset()Ljava/util/ArrayList;

    move-result-object v21

    if-eqz v21, :cond_16

    invoke-virtual {v15}, Lcom/disney/datg/videoplatforms/sdk/models/api/PlayManifest;->getVideo()Lcom/disney/datg/videoplatforms/sdk/models/api/Video;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Lcom/disney/datg/videoplatforms/sdk/models/api/Video;->getAssets()Lcom/disney/datg/videoplatforms/sdk/models/api/Assets;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Lcom/disney/datg/videoplatforms/sdk/models/api/Assets;->getAsset()Ljava/util/ArrayList;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Ljava/util/ArrayList;->size()I

    move-result v21

    if-lez v21, :cond_16

    .line 410
    # getter for: Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->access$100()Ljava/lang/String;

    move-result-object v21

    const-string v22, "getVideo()"

    invoke-static/range {v21 .. v22}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGD(Ljava/lang/String;Ljava/lang/String;)V

    .line 411
    invoke-virtual {v15}, Lcom/disney/datg/videoplatforms/sdk/models/api/PlayManifest;->getVideo()Lcom/disney/datg/videoplatforms/sdk/models/api/Video;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Lcom/disney/datg/videoplatforms/sdk/models/api/Video;->getAssets()Lcom/disney/datg/videoplatforms/sdk/models/api/Assets;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Lcom/disney/datg/videoplatforms/sdk/models/api/Assets;->getAsset()Ljava/util/ArrayList;

    move-result-object v21

    const/16 v22, 0x0

    invoke-virtual/range {v21 .. v22}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v20

    check-cast v20, Lcom/disney/datg/videoplatforms/sdk/models/api/Asset;

    .line 412
    .local v20, "videoAsset":Lcom/disney/datg/videoplatforms/sdk/models/api/Asset;
    if-eqz v20, :cond_16

    invoke-virtual/range {v20 .. v20}, Lcom/disney/datg/videoplatforms/sdk/models/api/Asset;->getValue()Ljava/lang/String;

    move-result-object v21

    invoke-static/range {v21 .. v21}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v21

    if-nez v21, :cond_16

    .line 413
    # getter for: Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->access$100()Ljava/lang/String;

    move-result-object v21

    const-string v22, "videoAsset"

    invoke-static/range {v21 .. v22}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGD(Ljava/lang/String;Ljava/lang/String;)V

    .line 414
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    move-object/from16 v21, v0

    sget-object v22, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;->AUTHORIZED:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;

    move-object/from16 v0, v22

    move-object/from16 v1, v21

    iput-object v0, v1, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->authState:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;

    .line 415
    # getter for: Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->access$100()Ljava/lang/String;

    move-result-object v21

    new-instance v22, Ljava/lang/StringBuilder;

    invoke-direct/range {v22 .. v22}, Ljava/lang/StringBuilder;-><init>()V

    const-string v23, "videoAsset.getValue() "

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    invoke-virtual/range {v20 .. v20}, Lcom/disney/datg/videoplatforms/sdk/models/api/Asset;->getValue()Ljava/lang/String;

    move-result-object v23

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    invoke-virtual/range {v22 .. v22}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v22

    invoke-static/range {v21 .. v22}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGD(Ljava/lang/String;Ljava/lang/String;)V

    .line 416
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    move-object/from16 v21, v0

    invoke-virtual/range {v20 .. v20}, Lcom/disney/datg/videoplatforms/sdk/models/api/Asset;->getValue()Ljava/lang/String;

    move-result-object v22

    # invokes: Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->setAssetUrl(Ljava/lang/String;)V
    invoke-static/range {v21 .. v22}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->access$200(Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;Ljava/lang/String;)V

    .line 419
    .end local v20    # "videoAsset":Lcom/disney/datg/videoplatforms/sdk/models/api/Asset;
    :cond_16
    invoke-virtual {v15}, Lcom/disney/datg/videoplatforms/sdk/models/api/PlayManifest;->getChannel()Lcom/disney/datg/videoplatforms/sdk/models/api/Channel;

    move-result-object v21

    if-eqz v21, :cond_17

    invoke-virtual {v15}, Lcom/disney/datg/videoplatforms/sdk/models/api/PlayManifest;->getChannel()Lcom/disney/datg/videoplatforms/sdk/models/api/Channel;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Lcom/disney/datg/videoplatforms/sdk/models/api/Channel;->getAssets()Lcom/disney/datg/videoplatforms/sdk/models/api/Assets;

    move-result-object v21

    if-eqz v21, :cond_17

    invoke-virtual {v15}, Lcom/disney/datg/videoplatforms/sdk/models/api/PlayManifest;->getChannel()Lcom/disney/datg/videoplatforms/sdk/models/api/Channel;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Lcom/disney/datg/videoplatforms/sdk/models/api/Channel;->getAssets()Lcom/disney/datg/videoplatforms/sdk/models/api/Assets;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Lcom/disney/datg/videoplatforms/sdk/models/api/Assets;->getAsset()Ljava/util/ArrayList;

    move-result-object v21

    if-eqz v21, :cond_17

    invoke-virtual {v15}, Lcom/disney/datg/videoplatforms/sdk/models/api/PlayManifest;->getChannel()Lcom/disney/datg/videoplatforms/sdk/models/api/Channel;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Lcom/disney/datg/videoplatforms/sdk/models/api/Channel;->getAssets()Lcom/disney/datg/videoplatforms/sdk/models/api/Assets;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Lcom/disney/datg/videoplatforms/sdk/models/api/Assets;->getAsset()Ljava/util/ArrayList;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Ljava/util/ArrayList;->size()I

    move-result v21

    if-lez v21, :cond_17

    .line 420
    # getter for: Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->access$100()Ljava/lang/String;

    move-result-object v21

    const-string v22, "getChannel()"

    invoke-static/range {v21 .. v22}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGD(Ljava/lang/String;Ljava/lang/String;)V

    .line 421
    invoke-virtual {v15}, Lcom/disney/datg/videoplatforms/sdk/models/api/PlayManifest;->getChannel()Lcom/disney/datg/videoplatforms/sdk/models/api/Channel;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Lcom/disney/datg/videoplatforms/sdk/models/api/Channel;->getAssets()Lcom/disney/datg/videoplatforms/sdk/models/api/Assets;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Lcom/disney/datg/videoplatforms/sdk/models/api/Assets;->getAsset()Ljava/util/ArrayList;

    move-result-object v21

    const/16 v22, 0x0

    invoke-virtual/range {v21 .. v22}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/disney/datg/videoplatforms/sdk/models/api/Asset;

    .line 422
    .local v4, "channelAsset":Lcom/disney/datg/videoplatforms/sdk/models/api/Asset;
    if-eqz v4, :cond_17

    invoke-virtual {v4}, Lcom/disney/datg/videoplatforms/sdk/models/api/Asset;->getValue()Ljava/lang/String;

    move-result-object v21

    invoke-static/range {v21 .. v21}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v21

    if-nez v21, :cond_17

    .line 423
    # getter for: Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->access$100()Ljava/lang/String;

    move-result-object v21

    const-string v22, "channelAsset"

    invoke-static/range {v21 .. v22}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGD(Ljava/lang/String;Ljava/lang/String;)V

    .line 424
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    move-object/from16 v21, v0

    sget-object v22, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;->AUTHORIZED:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;

    move-object/from16 v0, v22

    move-object/from16 v1, v21

    iput-object v0, v1, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->authState:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;

    .line 425
    # getter for: Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->access$100()Ljava/lang/String;

    move-result-object v21

    new-instance v22, Ljava/lang/StringBuilder;

    invoke-direct/range {v22 .. v22}, Ljava/lang/StringBuilder;-><init>()V

    const-string v23, "channelAsset.getValue() "

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    invoke-virtual {v4}, Lcom/disney/datg/videoplatforms/sdk/models/api/Asset;->getValue()Ljava/lang/String;

    move-result-object v23

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    invoke-virtual/range {v22 .. v22}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v22

    invoke-static/range {v21 .. v22}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGD(Ljava/lang/String;Ljava/lang/String;)V

    .line 426
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    move-object/from16 v21, v0

    invoke-virtual {v4}, Lcom/disney/datg/videoplatforms/sdk/models/api/Asset;->getValue()Ljava/lang/String;

    move-result-object v22

    # invokes: Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->setAssetUrl(Ljava/lang/String;)V
    invoke-static/range {v21 .. v22}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->access$200(Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;Ljava/lang/String;)V

    .line 430
    .end local v4    # "channelAsset":Lcom/disney/datg/videoplatforms/sdk/models/api/Asset;
    :cond_17
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    move-object/from16 v21, v0

    move-object/from16 v0, v21

    # invokes: Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->setPlayManifest(Lcom/disney/datg/videoplatforms/sdk/models/api/PlayManifest;)V
    invoke-static {v0, v15}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->access$300(Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;Lcom/disney/datg/videoplatforms/sdk/models/api/PlayManifest;)V

    .line 432
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    move-object/from16 v21, v0

    if-eqz v21, :cond_18

    .line 433
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    move-object/from16 v21, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    move-object/from16 v22, v0

    invoke-virtual/range {v22 .. v22}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getAssetUrl()Ljava/lang/String;

    move-result-object v22

    invoke-interface/range {v21 .. v22}, Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;->onSuccess(Ljava/lang/Object;)V

    .line 434
    :cond_18
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    move-object/from16 v21, v0

    invoke-virtual/range {v21 .. v21}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getOnAuthorizationListener()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$VPMediaAuthorizationListener;

    move-result-object v21

    if-eqz v21, :cond_c

    .line 435
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    move-object/from16 v21, v0

    invoke-virtual/range {v21 .. v21}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getOnAuthorizationListener()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$VPMediaAuthorizationListener;

    move-result-object v21

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    move-object/from16 v22, v0

    invoke-interface/range {v21 .. v22}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$VPMediaAuthorizationListener;->onAuthorizationSuccess(Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;)V
    :try_end_5
    .catch Ljava/lang/InterruptedException; {:try_start_5 .. :try_end_5} :catch_1
    .catch Ljava/util/concurrent/ExecutionException; {:try_start_5 .. :try_end_5} :catch_2
    .catch Ljava/util/concurrent/RejectedExecutionException; {:try_start_5 .. :try_end_5} :catch_3
    .catch Ljava/util/concurrent/TimeoutException; {:try_start_5 .. :try_end_5} :catch_4
    .catch Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException; {:try_start_5 .. :try_end_5} :catch_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_6

    goto/16 :goto_0

    .line 467
    .end local v7    # "entitlementResponse":Lcom/disney/datg/videoplatforms/sdk/models/api/ResponseMessage;
    .end local v12    # "futureManifestResponseEntity":Ljava/util/concurrent/Future;, "Ljava/util/concurrent/Future<Lorg/springframework/http/ResponseEntity<Lcom/disney/datg/videoplatforms/sdk/models/api/PlayManifest;>;>;"
    .end local v15    # "manifestResponse":Lcom/disney/datg/videoplatforms/sdk/models/api/PlayManifest;
    .end local v16    # "manifestResponseEntity":Lorg/springframework/http/ResponseEntity;, "Lorg/springframework/http/ResponseEntity<Lcom/disney/datg/videoplatforms/sdk/models/api/PlayManifest;>;"
    :catch_4
    move-exception v6

    .line 468
    .local v6, "e":Ljava/util/concurrent/TimeoutException;
    new-instance v11, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v21, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_AUTHZ_TIMEOUT_EXCEPTION:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    move-object/from16 v0, v21

    invoke-direct {v11, v0, v6}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;Ljava/lang/Throwable;)V

    .line 469
    .restart local v11    # "ex":Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    move-object/from16 v21, v0

    if-eqz v21, :cond_19

    .line 470
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    move-object/from16 v21, v0

    move-object/from16 v0, v21

    invoke-interface {v0, v11}, Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;->onError(Ljava/lang/Exception;)V

    .line 471
    :cond_19
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    move-object/from16 v21, v0

    invoke-virtual/range {v21 .. v21}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getOnAuthorizationListener()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$VPMediaAuthorizationListener;

    move-result-object v21

    if-eqz v21, :cond_1a

    .line 472
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    move-object/from16 v21, v0

    invoke-virtual/range {v21 .. v21}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getOnAuthorizationListener()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$VPMediaAuthorizationListener;

    move-result-object v21

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    move-object/from16 v22, v0

    invoke-virtual {v11}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;->getErrorCode()Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    move-result-object v23

    invoke-virtual/range {v23 .. v23}, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->getReason()Ljava/lang/String;

    move-result-object v23

    invoke-interface/range {v21 .. v23}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$VPMediaAuthorizationListener;->onAuthorizationFailure(Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;Ljava/lang/String;)V

    .line 474
    :cond_1a
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    move-object/from16 v21, v0

    sget-object v22, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;->NOT_AUTHORIZED:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;

    move-object/from16 v0, v22

    move-object/from16 v1, v21

    iput-object v0, v1, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->authState:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;

    goto/16 :goto_0

    .line 476
    .end local v6    # "e":Ljava/util/concurrent/TimeoutException;
    .end local v11    # "ex":Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;
    :catch_5
    move-exception v11

    .line 477
    .restart local v11    # "ex":Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    move-object/from16 v21, v0

    if-eqz v21, :cond_1b

    .line 478
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    move-object/from16 v21, v0

    move-object/from16 v0, v21

    invoke-interface {v0, v11}, Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;->onError(Ljava/lang/Exception;)V

    .line 479
    :cond_1b
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    move-object/from16 v21, v0

    invoke-virtual/range {v21 .. v21}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getOnAuthorizationListener()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$VPMediaAuthorizationListener;

    move-result-object v21

    if-eqz v21, :cond_1c

    .line 480
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    move-object/from16 v21, v0

    invoke-virtual/range {v21 .. v21}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getOnAuthorizationListener()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$VPMediaAuthorizationListener;

    move-result-object v21

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    move-object/from16 v22, v0

    invoke-virtual {v11}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;->getErrorCode()Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    move-result-object v23

    invoke-virtual/range {v23 .. v23}, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->getReason()Ljava/lang/String;

    move-result-object v23

    invoke-interface/range {v21 .. v23}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$VPMediaAuthorizationListener;->onAuthorizationFailure(Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;Ljava/lang/String;)V

    .line 482
    :cond_1c
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    move-object/from16 v21, v0

    sget-object v22, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;->NOT_AUTHORIZED:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;

    move-object/from16 v0, v22

    move-object/from16 v1, v21

    iput-object v0, v1, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->authState:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;

    goto/16 :goto_0

    .line 484
    .end local v11    # "ex":Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;
    :catch_6
    move-exception v6

    .line 485
    .local v6, "e":Ljava/lang/Exception;
    new-instance v11, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v21, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_AUTHZ_FAILED_EXCEPTION:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    move-object/from16 v0, v21

    invoke-direct {v11, v0, v6}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;Ljava/lang/Throwable;)V

    .line 486
    .restart local v11    # "ex":Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    move-object/from16 v21, v0

    if-eqz v21, :cond_1d

    .line 487
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    move-object/from16 v21, v0

    move-object/from16 v0, v21

    invoke-interface {v0, v11}, Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;->onError(Ljava/lang/Exception;)V

    .line 488
    :cond_1d
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    move-object/from16 v21, v0

    invoke-virtual/range {v21 .. v21}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getOnAuthorizationListener()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$VPMediaAuthorizationListener;

    move-result-object v21

    if-eqz v21, :cond_1e

    .line 489
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    move-object/from16 v21, v0

    invoke-virtual/range {v21 .. v21}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getOnAuthorizationListener()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$VPMediaAuthorizationListener;

    move-result-object v21

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    move-object/from16 v22, v0

    invoke-virtual {v11}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;->getErrorCode()Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    move-result-object v23

    invoke-virtual/range {v23 .. v23}, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->getReason()Ljava/lang/String;

    move-result-object v23

    invoke-interface/range {v21 .. v23}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$VPMediaAuthorizationListener;->onAuthorizationFailure(Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;Ljava/lang/String;)V

    .line 491
    :cond_1e
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    move-object/from16 v21, v0

    sget-object v22, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;->NOT_AUTHORIZED:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;

    move-object/from16 v0, v22

    move-object/from16 v1, v21

    iput-object v0, v1, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->authState:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;

    goto/16 :goto_0
.end method
