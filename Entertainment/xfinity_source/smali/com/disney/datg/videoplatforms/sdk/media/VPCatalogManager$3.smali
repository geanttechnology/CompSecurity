.class Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager$3;
.super Ljava/lang/Object;
.source "VPCatalogManager.java"

# interfaces
.implements Ljava/util/concurrent/Callable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager;->getChannelCatalog(Ljava/lang/String;Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;)Ljava/util/concurrent/Future;
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
        "Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager;

.field final synthetic val$affiliate:Ljava/lang/String;

.field final synthetic val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;


# direct methods
.method constructor <init>(Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager;Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 416
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager$3;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager;

    iput-object p2, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager$3;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    iput-object p3, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager$3;->val$affiliate:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public call()Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog;
    .locals 12
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 421
    iget-object v8, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager$3;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager;

    # getter for: Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager;->configuration:Lcom/disney/datg/videoplatforms/sdk/media/Configuration;
    invoke-static {v8}, Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager;->access$000(Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager;)Lcom/disney/datg/videoplatforms/sdk/media/Configuration;

    move-result-object v8

    invoke-virtual {v8}, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->getCurrentConfig()Lcom/disney/datg/videoplatforms/sdk/models/api/Config;

    move-result-object v8

    const-string v9, "channels"

    invoke-virtual {v8, v9}, Lcom/disney/datg/videoplatforms/sdk/models/api/Config;->getURLFromWebServiceName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 422
    .local v7, "url":Ljava/lang/String;
    invoke-static {v7}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v8

    if-eqz v8, :cond_1

    .line 424
    iget-object v8, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager$3;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    if-eqz v8, :cond_1

    .line 425
    new-instance v4, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v8, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_SERVICE_UNDEFINED_HOST:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    const-string v9, "partner channels url could not be resolved from Config"

    invoke-direct {v4, v8, v9}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;Ljava/lang/String;)V

    .line 427
    .local v4, "e":Ljava/lang/Exception;
    iget-object v8, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager$3;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    if-eqz v8, :cond_0

    .line 428
    iget-object v8, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager$3;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    invoke-interface {v8, v4}, Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;->onError(Ljava/lang/Exception;)V

    .line 429
    :cond_0
    throw v4

    .line 432
    .end local v4    # "e":Ljava/lang/Exception;
    :cond_1
    iget-object v8, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager$3;->val$affiliate:Ljava/lang/String;

    invoke-static {v8}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v8

    if-nez v8, :cond_3

    .line 433
    const-string v8, "%AFFILIATE%"

    iget-object v9, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager$3;->val$affiliate:Ljava/lang/String;

    invoke-virtual {v7, v8, v9}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v7

    .line 437
    :goto_0
    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog;

    invoke-direct {v0}, Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog;-><init>()V

    .line 438
    .local v0, "catalog":Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog;
    new-instance v1, Lcom/disney/datg/videoplatforms/sdk/service/ChannelsAccessor;

    const/4 v8, 0x0

    invoke-direct {v1, v7, v8}, Lcom/disney/datg/videoplatforms/sdk/service/ChannelsAccessor;-><init>(Ljava/lang/String;Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;)V

    .line 442
    .local v1, "channelAccessor":Lcom/disney/datg/videoplatforms/sdk/service/ChannelsAccessor;
    :try_start_0
    invoke-virtual {v1}, Lcom/disney/datg/videoplatforms/sdk/service/ChannelsAccessor;->getServiceAsync()Ljava/util/concurrent/Future;

    move-result-object v5

    .line 443
    .local v5, "futureChannelsResponseEntity":Ljava/util/concurrent/Future;, "Ljava/util/concurrent/Future<Lorg/springframework/http/ResponseEntity<Lcom/disney/datg/videoplatforms/sdk/models/api/Channels;>;>;"
    sget v8, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->SERVICE_TIMEOUT:I

    int-to-long v8, v8

    sget-object v10, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-interface {v5, v8, v9, v10}, Ljava/util/concurrent/Future;->get(JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lorg/springframework/http/ResponseEntity;

    .line 444
    .local v2, "channelResponseEntity":Lorg/springframework/http/ResponseEntity;, "Lorg/springframework/http/ResponseEntity<Lcom/disney/datg/videoplatforms/sdk/models/api/Channels;>;"
    if-nez v2, :cond_4

    .line 445
    new-instance v8, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v9, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_CHANNELS_SERVICE_ERROR:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    invoke-direct {v8, v9}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;)V

    throw v8
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/util/concurrent/ExecutionException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/util/concurrent/RejectedExecutionException; {:try_start_0 .. :try_end_0} :catch_2
    .catch Ljava/util/concurrent/TimeoutException; {:try_start_0 .. :try_end_0} :catch_3
    .catch Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException; {:try_start_0 .. :try_end_0} :catch_4
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_5

    .line 461
    .end local v2    # "channelResponseEntity":Lorg/springframework/http/ResponseEntity;, "Lorg/springframework/http/ResponseEntity<Lcom/disney/datg/videoplatforms/sdk/models/api/Channels;>;"
    .end local v5    # "futureChannelsResponseEntity":Ljava/util/concurrent/Future;, "Ljava/util/concurrent/Future<Lorg/springframework/http/ResponseEntity<Lcom/disney/datg/videoplatforms/sdk/models/api/Channels;>;>;"
    :catch_0
    move-exception v4

    .line 462
    .local v4, "e":Ljava/lang/InterruptedException;
    iget-object v8, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager$3;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    if-eqz v8, :cond_2

    .line 463
    iget-object v8, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager$3;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    new-instance v9, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v10, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_CHANNELS_SERVICE_ERROR:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    invoke-direct {v9, v10, v4}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;Ljava/lang/Throwable;)V

    invoke-interface {v8, v9}, Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;->onError(Ljava/lang/Exception;)V

    .line 480
    .end local v4    # "e":Ljava/lang/InterruptedException;
    :cond_2
    :goto_1
    return-object v0

    .line 435
    .end local v0    # "catalog":Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog;
    .end local v1    # "channelAccessor":Lcom/disney/datg/videoplatforms/sdk/service/ChannelsAccessor;
    :cond_3
    const-string v8, "%AFFILIATE%"

    const-string v9, "-1"

    invoke-virtual {v7, v8, v9}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v7

    goto :goto_0

    .line 447
    .restart local v0    # "catalog":Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog;
    .restart local v1    # "channelAccessor":Lcom/disney/datg/videoplatforms/sdk/service/ChannelsAccessor;
    .restart local v2    # "channelResponseEntity":Lorg/springframework/http/ResponseEntity;, "Lorg/springframework/http/ResponseEntity<Lcom/disney/datg/videoplatforms/sdk/models/api/Channels;>;"
    .restart local v5    # "futureChannelsResponseEntity":Ljava/util/concurrent/Future;, "Ljava/util/concurrent/Future<Lorg/springframework/http/ResponseEntity<Lcom/disney/datg/videoplatforms/sdk/models/api/Channels;>;>;"
    :cond_4
    :try_start_1
    invoke-virtual {v2}, Lorg/springframework/http/ResponseEntity;->getBody()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/disney/datg/videoplatforms/sdk/models/api/Channels;

    .line 448
    .local v3, "channels":Lcom/disney/datg/videoplatforms/sdk/models/api/Channels;
    invoke-virtual {v3}, Lcom/disney/datg/videoplatforms/sdk/models/api/Channels;->getChannel()Ljava/util/ArrayList;

    move-result-object v8

    if-eqz v8, :cond_5

    invoke-virtual {v3}, Lcom/disney/datg/videoplatforms/sdk/models/api/Channels;->getChannel()Ljava/util/ArrayList;

    move-result-object v8

    invoke-virtual {v8}, Ljava/util/ArrayList;->size()I

    move-result v8

    if-lez v8, :cond_5

    .line 450
    iget-object v8, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager$3;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager;

    invoke-virtual {v3}, Lcom/disney/datg/videoplatforms/sdk/models/api/Channels;->getChannel()Ljava/util/ArrayList;

    move-result-object v9

    iget-object v10, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager$3;->val$affiliate:Ljava/lang/String;

    # invokes: Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager;->collectionFromChannels(Ljava/util/List;Ljava/lang/String;)Ljava/util/List;
    invoke-static {v8, v9, v10}, Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager;->access$200(Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager;Ljava/util/List;Ljava/lang/String;)Ljava/util/List;

    move-result-object v6

    .line 451
    .local v6, "mediaCollection":Ljava/util/List;, "Ljava/util/List<Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;>;"
    sget-object v8, Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog$CatalogType;->CHANNEL:Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog$CatalogType;

    invoke-virtual {v0, v6, v8}, Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog;->setCollection(Ljava/util/List;Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog$CatalogType;)V

    .line 452
    iget-object v8, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager$3;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    if-eqz v8, :cond_2

    .line 453
    iget-object v8, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager$3;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    invoke-interface {v8, v0}, Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;->onSuccess(Ljava/lang/Object;)V
    :try_end_1
    .catch Ljava/lang/InterruptedException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/util/concurrent/ExecutionException; {:try_start_1 .. :try_end_1} :catch_1
    .catch Ljava/util/concurrent/RejectedExecutionException; {:try_start_1 .. :try_end_1} :catch_2
    .catch Ljava/util/concurrent/TimeoutException; {:try_start_1 .. :try_end_1} :catch_3
    .catch Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException; {:try_start_1 .. :try_end_1} :catch_4
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_5

    goto :goto_1

    .line 464
    .end local v2    # "channelResponseEntity":Lorg/springframework/http/ResponseEntity;, "Lorg/springframework/http/ResponseEntity<Lcom/disney/datg/videoplatforms/sdk/models/api/Channels;>;"
    .end local v3    # "channels":Lcom/disney/datg/videoplatforms/sdk/models/api/Channels;
    .end local v5    # "futureChannelsResponseEntity":Ljava/util/concurrent/Future;, "Ljava/util/concurrent/Future<Lorg/springframework/http/ResponseEntity<Lcom/disney/datg/videoplatforms/sdk/models/api/Channels;>;>;"
    .end local v6    # "mediaCollection":Ljava/util/List;, "Ljava/util/List<Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;>;"
    :catch_1
    move-exception v4

    .line 465
    .local v4, "e":Ljava/util/concurrent/ExecutionException;
    iget-object v8, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager$3;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    if-eqz v8, :cond_2

    .line 466
    iget-object v8, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager$3;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    new-instance v9, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v10, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_CHANNELS_SERVICE_ERROR:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    invoke-direct {v9, v10, v4}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;Ljava/lang/Throwable;)V

    invoke-interface {v8, v9}, Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;->onError(Ljava/lang/Exception;)V

    goto :goto_1

    .line 456
    .end local v4    # "e":Ljava/util/concurrent/ExecutionException;
    .restart local v2    # "channelResponseEntity":Lorg/springframework/http/ResponseEntity;, "Lorg/springframework/http/ResponseEntity<Lcom/disney/datg/videoplatforms/sdk/models/api/Channels;>;"
    .restart local v3    # "channels":Lcom/disney/datg/videoplatforms/sdk/models/api/Channels;
    .restart local v5    # "futureChannelsResponseEntity":Ljava/util/concurrent/Future;, "Ljava/util/concurrent/Future<Lorg/springframework/http/ResponseEntity<Lcom/disney/datg/videoplatforms/sdk/models/api/Channels;>;>;"
    :cond_5
    :try_start_2
    iget-object v8, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager$3;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    if-eqz v8, :cond_2

    .line 457
    iget-object v8, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager$3;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    new-instance v9, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v10, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_CHANNELS_SERVICE_ERROR:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    const-string v11, "Channel is invalid or does not exist for partner"

    invoke-direct {v9, v10, v11}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;Ljava/lang/String;)V

    invoke-interface {v8, v9}, Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;->onError(Ljava/lang/Exception;)V
    :try_end_2
    .catch Ljava/lang/InterruptedException; {:try_start_2 .. :try_end_2} :catch_0
    .catch Ljava/util/concurrent/ExecutionException; {:try_start_2 .. :try_end_2} :catch_1
    .catch Ljava/util/concurrent/RejectedExecutionException; {:try_start_2 .. :try_end_2} :catch_2
    .catch Ljava/util/concurrent/TimeoutException; {:try_start_2 .. :try_end_2} :catch_3
    .catch Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException; {:try_start_2 .. :try_end_2} :catch_4
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_5

    goto :goto_1

    .line 467
    .end local v2    # "channelResponseEntity":Lorg/springframework/http/ResponseEntity;, "Lorg/springframework/http/ResponseEntity<Lcom/disney/datg/videoplatforms/sdk/models/api/Channels;>;"
    .end local v3    # "channels":Lcom/disney/datg/videoplatforms/sdk/models/api/Channels;
    .end local v5    # "futureChannelsResponseEntity":Ljava/util/concurrent/Future;, "Ljava/util/concurrent/Future<Lorg/springframework/http/ResponseEntity<Lcom/disney/datg/videoplatforms/sdk/models/api/Channels;>;>;"
    :catch_2
    move-exception v4

    .line 468
    .local v4, "e":Ljava/util/concurrent/RejectedExecutionException;
    iget-object v8, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager$3;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    if-eqz v8, :cond_2

    .line 469
    iget-object v8, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager$3;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    new-instance v9, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v10, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_CHANNELS_SERVICE_ERROR:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    invoke-direct {v9, v10, v4}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;Ljava/lang/Throwable;)V

    invoke-interface {v8, v9}, Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;->onError(Ljava/lang/Exception;)V

    goto :goto_1

    .line 470
    .end local v4    # "e":Ljava/util/concurrent/RejectedExecutionException;
    :catch_3
    move-exception v4

    .line 471
    .local v4, "e":Ljava/util/concurrent/TimeoutException;
    iget-object v8, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager$3;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    if-eqz v8, :cond_2

    .line 472
    iget-object v8, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager$3;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    new-instance v9, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v10, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_CHANNELS_SERVICE_TIMEOUT:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    invoke-direct {v9, v10, v4}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;Ljava/lang/Throwable;)V

    invoke-interface {v8, v9}, Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;->onError(Ljava/lang/Exception;)V

    goto/16 :goto_1

    .line 473
    .end local v4    # "e":Ljava/util/concurrent/TimeoutException;
    :catch_4
    move-exception v4

    .line 474
    .local v4, "e":Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;
    iget-object v8, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager$3;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    if-eqz v8, :cond_2

    .line 475
    iget-object v8, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager$3;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    invoke-interface {v8, v4}, Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;->onError(Ljava/lang/Exception;)V

    goto/16 :goto_1

    .line 476
    .end local v4    # "e":Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;
    :catch_5
    move-exception v4

    .line 477
    .local v4, "e":Ljava/lang/Exception;
    iget-object v8, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager$3;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    if-eqz v8, :cond_2

    .line 478
    iget-object v8, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager$3;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    new-instance v9, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v10, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_CHANNELS_SERVICE_ERROR:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    invoke-direct {v9, v10, v4}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;Ljava/lang/Throwable;)V

    invoke-interface {v8, v9}, Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;->onError(Ljava/lang/Exception;)V

    goto/16 :goto_1
.end method

.method public bridge synthetic call()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 416
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager$3;->call()Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog;

    move-result-object v0

    return-object v0
.end method
