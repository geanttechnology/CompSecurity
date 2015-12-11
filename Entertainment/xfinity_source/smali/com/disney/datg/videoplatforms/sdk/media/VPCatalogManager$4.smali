.class Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager$4;
.super Ljava/lang/Object;
.source "VPCatalogManager.java"

# interfaces
.implements Ljava/util/concurrent/Callable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager;->getVideoCatalog(Ljava/lang/String;Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;)Ljava/util/concurrent/Future;
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

.field final synthetic val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

.field final synthetic val$videoId:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager;Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 491
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager$4;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager;

    iput-object p2, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager$4;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    iput-object p3, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager$4;->val$videoId:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public call()Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog;
    .locals 13
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 496
    iget-object v9, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager$4;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager;

    # getter for: Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager;->configuration:Lcom/disney/datg/videoplatforms/sdk/media/Configuration;
    invoke-static {v9}, Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager;->access$000(Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager;)Lcom/disney/datg/videoplatforms/sdk/media/Configuration;

    move-result-object v9

    invoke-virtual {v9}, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->getCurrentConfig()Lcom/disney/datg/videoplatforms/sdk/models/api/Config;

    move-result-object v9

    const-string v10, "videos"

    invoke-virtual {v9, v10}, Lcom/disney/datg/videoplatforms/sdk/models/api/Config;->getURLFromWebServiceName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 497
    .local v5, "url":Ljava/lang/String;
    invoke-static {v5}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v9

    if-eqz v9, :cond_0

    .line 498
    iget-object v9, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager$4;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    if-eqz v9, :cond_0

    .line 499
    new-instance v1, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v9, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_SERVICE_UNDEFINED_HOST:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    const-string v10, "partner videos url could not be resolved from Config"

    invoke-direct {v1, v9, v10}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;Ljava/lang/String;)V

    .line 501
    .local v1, "e":Ljava/lang/Exception;
    iget-object v9, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager$4;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    invoke-interface {v9, v1}, Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;->onError(Ljava/lang/Exception;)V

    .line 502
    throw v1

    .line 505
    .end local v1    # "e":Ljava/lang/Exception;
    :cond_0
    const-string v9, "%SHOW%"

    const-string v10, "-1"

    invoke-virtual {v5, v9, v10}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v5

    .line 506
    const-string v9, "%SEASON%"

    const-string v10, "-1"

    invoke-virtual {v5, v9, v10}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v5

    .line 507
    const-string v9, "%START%"

    const-string v10, "-1"

    invoke-virtual {v5, v9, v10}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v5

    .line 508
    const-string v9, "%LIMIT%"

    const-string v10, "-1"

    invoke-virtual {v5, v9, v10}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v5

    .line 509
    iget-object v9, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager$4;->val$videoId:Ljava/lang/String;

    invoke-static {v9}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v9

    if-nez v9, :cond_3

    .line 511
    :try_start_0
    const-string v9, "%VIDEO%"

    iget-object v10, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager$4;->val$videoId:Ljava/lang/String;

    invoke-virtual {v5, v9, v10}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    move-result-object v5

    .line 525
    :goto_0
    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog;

    invoke-direct {v0}, Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog;-><init>()V

    .line 526
    .local v0, "catalog":Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog;
    new-instance v6, Lcom/disney/datg/videoplatforms/sdk/service/VideoAccessor;

    const/4 v9, 0x0

    invoke-direct {v6, v5, v9}, Lcom/disney/datg/videoplatforms/sdk/service/VideoAccessor;-><init>(Ljava/lang/String;Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;)V

    .line 532
    .local v6, "videoAccessor":Lcom/disney/datg/videoplatforms/sdk/service/VideoAccessor;
    :try_start_1
    invoke-virtual {v6}, Lcom/disney/datg/videoplatforms/sdk/service/VideoAccessor;->getServiceAsync()Ljava/util/concurrent/Future;

    move-result-object v3

    .line 533
    .local v3, "futureVideosResponseEntity":Ljava/util/concurrent/Future;, "Ljava/util/concurrent/Future<Lorg/springframework/http/ResponseEntity<Lcom/disney/datg/videoplatforms/sdk/models/api/Videos;>;>;"
    sget v9, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->SERVICE_TIMEOUT:I

    int-to-long v10, v9

    sget-object v9, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-interface {v3, v10, v11, v9}, Ljava/util/concurrent/Future;->get(JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lorg/springframework/http/ResponseEntity;

    .line 534
    .local v7, "videoResponseEntity":Lorg/springframework/http/ResponseEntity;, "Lorg/springframework/http/ResponseEntity<Lcom/disney/datg/videoplatforms/sdk/models/api/Videos;>;"
    if-nez v7, :cond_4

    .line 535
    new-instance v9, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v10, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_VIDEOS_SERVICE_ERROR:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    invoke-direct {v9, v10}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;)V

    throw v9
    :try_end_1
    .catch Ljava/lang/InterruptedException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/util/concurrent/ExecutionException; {:try_start_1 .. :try_end_1} :catch_2
    .catch Ljava/util/concurrent/RejectedExecutionException; {:try_start_1 .. :try_end_1} :catch_3
    .catch Ljava/util/concurrent/TimeoutException; {:try_start_1 .. :try_end_1} :catch_4
    .catch Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException; {:try_start_1 .. :try_end_1} :catch_5
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_6

    .line 550
    .end local v3    # "futureVideosResponseEntity":Ljava/util/concurrent/Future;, "Ljava/util/concurrent/Future<Lorg/springframework/http/ResponseEntity<Lcom/disney/datg/videoplatforms/sdk/models/api/Videos;>;>;"
    .end local v7    # "videoResponseEntity":Lorg/springframework/http/ResponseEntity;, "Lorg/springframework/http/ResponseEntity<Lcom/disney/datg/videoplatforms/sdk/models/api/Videos;>;"
    :catch_0
    move-exception v1

    .line 551
    .local v1, "e":Ljava/lang/InterruptedException;
    iget-object v9, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager$4;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    if-eqz v9, :cond_1

    .line 552
    iget-object v9, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager$4;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    new-instance v10, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v11, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_VIDEOS_SERVICE_ERROR:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    invoke-direct {v10, v11, v1}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;Ljava/lang/Throwable;)V

    invoke-interface {v9, v10}, Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;->onError(Ljava/lang/Exception;)V

    .line 569
    .end local v1    # "e":Ljava/lang/InterruptedException;
    :cond_1
    :goto_1
    return-object v0

    .line 512
    .end local v0    # "catalog":Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog;
    .end local v6    # "videoAccessor":Lcom/disney/datg/videoplatforms/sdk/service/VideoAccessor;
    :catch_1
    move-exception v1

    .line 513
    .local v1, "e":Ljava/lang/Exception;
    new-instance v2, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v9, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_VIDEOS_SERVICE_ERROR:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    const-string v10, "improper format for videoId param"

    invoke-direct {v2, v9, v10}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;Ljava/lang/String;)V

    .line 515
    .local v2, "ex":Ljava/lang/Exception;
    iget-object v9, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager$4;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    if-eqz v9, :cond_2

    .line 516
    iget-object v9, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager$4;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    invoke-interface {v9, v2}, Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;->onError(Ljava/lang/Exception;)V

    .line 517
    :cond_2
    throw v2

    .line 521
    .end local v1    # "e":Ljava/lang/Exception;
    .end local v2    # "ex":Ljava/lang/Exception;
    :cond_3
    const-string v9, "%VIDEO%"

    const-string v10, "-1"

    invoke-virtual {v5, v9, v10}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v5

    goto :goto_0

    .line 537
    .restart local v0    # "catalog":Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog;
    .restart local v3    # "futureVideosResponseEntity":Ljava/util/concurrent/Future;, "Ljava/util/concurrent/Future<Lorg/springframework/http/ResponseEntity<Lcom/disney/datg/videoplatforms/sdk/models/api/Videos;>;>;"
    .restart local v6    # "videoAccessor":Lcom/disney/datg/videoplatforms/sdk/service/VideoAccessor;
    .restart local v7    # "videoResponseEntity":Lorg/springframework/http/ResponseEntity;, "Lorg/springframework/http/ResponseEntity<Lcom/disney/datg/videoplatforms/sdk/models/api/Videos;>;"
    :cond_4
    :try_start_2
    invoke-virtual {v7}, Lorg/springframework/http/ResponseEntity;->getBody()Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Lcom/disney/datg/videoplatforms/sdk/models/api/Videos;

    .line 538
    .local v8, "videos":Lcom/disney/datg/videoplatforms/sdk/models/api/Videos;
    invoke-virtual {v8}, Lcom/disney/datg/videoplatforms/sdk/models/api/Videos;->getVideo()Ljava/util/ArrayList;

    move-result-object v9

    if-eqz v9, :cond_5

    invoke-virtual {v8}, Lcom/disney/datg/videoplatforms/sdk/models/api/Videos;->getVideo()Ljava/util/ArrayList;

    move-result-object v9

    invoke-virtual {v9}, Ljava/util/ArrayList;->size()I

    move-result v9

    if-lez v9, :cond_5

    .line 540
    iget-object v9, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager$4;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager;

    invoke-virtual {v8}, Lcom/disney/datg/videoplatforms/sdk/models/api/Videos;->getVideo()Ljava/util/ArrayList;

    move-result-object v10

    # invokes: Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager;->collectionFromVideos(Ljava/util/List;)Ljava/util/List;
    invoke-static {v9, v10}, Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager;->access$300(Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager;Ljava/util/List;)Ljava/util/List;

    move-result-object v4

    .line 541
    .local v4, "mediaCollection":Ljava/util/List;, "Ljava/util/List<Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;>;"
    sget-object v9, Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog$CatalogType;->VIDEO:Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog$CatalogType;

    invoke-virtual {v0, v4, v9}, Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog;->setCollection(Ljava/util/List;Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog$CatalogType;)V

    .line 542
    iget-object v9, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager$4;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    if-eqz v9, :cond_1

    .line 543
    iget-object v9, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager$4;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    invoke-interface {v9, v0}, Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;->onSuccess(Ljava/lang/Object;)V
    :try_end_2
    .catch Ljava/lang/InterruptedException; {:try_start_2 .. :try_end_2} :catch_0
    .catch Ljava/util/concurrent/ExecutionException; {:try_start_2 .. :try_end_2} :catch_2
    .catch Ljava/util/concurrent/RejectedExecutionException; {:try_start_2 .. :try_end_2} :catch_3
    .catch Ljava/util/concurrent/TimeoutException; {:try_start_2 .. :try_end_2} :catch_4
    .catch Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException; {:try_start_2 .. :try_end_2} :catch_5
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_6

    goto :goto_1

    .line 553
    .end local v3    # "futureVideosResponseEntity":Ljava/util/concurrent/Future;, "Ljava/util/concurrent/Future<Lorg/springframework/http/ResponseEntity<Lcom/disney/datg/videoplatforms/sdk/models/api/Videos;>;>;"
    .end local v4    # "mediaCollection":Ljava/util/List;, "Ljava/util/List<Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;>;"
    .end local v7    # "videoResponseEntity":Lorg/springframework/http/ResponseEntity;, "Lorg/springframework/http/ResponseEntity<Lcom/disney/datg/videoplatforms/sdk/models/api/Videos;>;"
    .end local v8    # "videos":Lcom/disney/datg/videoplatforms/sdk/models/api/Videos;
    :catch_2
    move-exception v1

    .line 554
    .local v1, "e":Ljava/util/concurrent/ExecutionException;
    iget-object v9, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager$4;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    if-eqz v9, :cond_1

    .line 555
    iget-object v9, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager$4;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    new-instance v10, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v11, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_VIDEOS_SERVICE_ERROR:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    invoke-direct {v10, v11, v1}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;Ljava/lang/Throwable;)V

    invoke-interface {v9, v10}, Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;->onError(Ljava/lang/Exception;)V

    goto :goto_1

    .line 546
    .end local v1    # "e":Ljava/util/concurrent/ExecutionException;
    .restart local v3    # "futureVideosResponseEntity":Ljava/util/concurrent/Future;, "Ljava/util/concurrent/Future<Lorg/springframework/http/ResponseEntity<Lcom/disney/datg/videoplatforms/sdk/models/api/Videos;>;>;"
    .restart local v7    # "videoResponseEntity":Lorg/springframework/http/ResponseEntity;, "Lorg/springframework/http/ResponseEntity<Lcom/disney/datg/videoplatforms/sdk/models/api/Videos;>;"
    .restart local v8    # "videos":Lcom/disney/datg/videoplatforms/sdk/models/api/Videos;
    :cond_5
    :try_start_3
    iget-object v9, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager$4;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    if-eqz v9, :cond_1

    .line 547
    iget-object v9, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager$4;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    new-instance v10, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v11, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_VIDEOS_SERVICE_ERROR:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    const-string v12, "Video is invalid or does not exist for partner"

    invoke-direct {v10, v11, v12}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;Ljava/lang/String;)V

    invoke-interface {v9, v10}, Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;->onError(Ljava/lang/Exception;)V
    :try_end_3
    .catch Ljava/lang/InterruptedException; {:try_start_3 .. :try_end_3} :catch_0
    .catch Ljava/util/concurrent/ExecutionException; {:try_start_3 .. :try_end_3} :catch_2
    .catch Ljava/util/concurrent/RejectedExecutionException; {:try_start_3 .. :try_end_3} :catch_3
    .catch Ljava/util/concurrent/TimeoutException; {:try_start_3 .. :try_end_3} :catch_4
    .catch Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException; {:try_start_3 .. :try_end_3} :catch_5
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_6

    goto :goto_1

    .line 556
    .end local v3    # "futureVideosResponseEntity":Ljava/util/concurrent/Future;, "Ljava/util/concurrent/Future<Lorg/springframework/http/ResponseEntity<Lcom/disney/datg/videoplatforms/sdk/models/api/Videos;>;>;"
    .end local v7    # "videoResponseEntity":Lorg/springframework/http/ResponseEntity;, "Lorg/springframework/http/ResponseEntity<Lcom/disney/datg/videoplatforms/sdk/models/api/Videos;>;"
    .end local v8    # "videos":Lcom/disney/datg/videoplatforms/sdk/models/api/Videos;
    :catch_3
    move-exception v1

    .line 557
    .local v1, "e":Ljava/util/concurrent/RejectedExecutionException;
    iget-object v9, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager$4;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    if-eqz v9, :cond_1

    .line 558
    iget-object v9, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager$4;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    new-instance v10, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v11, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_VIDEOS_SERVICE_ERROR:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    invoke-direct {v10, v11, v1}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;Ljava/lang/Throwable;)V

    invoke-interface {v9, v10}, Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;->onError(Ljava/lang/Exception;)V

    goto/16 :goto_1

    .line 559
    .end local v1    # "e":Ljava/util/concurrent/RejectedExecutionException;
    :catch_4
    move-exception v1

    .line 560
    .local v1, "e":Ljava/util/concurrent/TimeoutException;
    iget-object v9, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager$4;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    if-eqz v9, :cond_1

    .line 561
    iget-object v9, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager$4;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    new-instance v10, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v11, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_VIDEOS_SERVICE_ERROR:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    invoke-direct {v10, v11, v1}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;Ljava/lang/Throwable;)V

    invoke-interface {v9, v10}, Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;->onError(Ljava/lang/Exception;)V

    goto/16 :goto_1

    .line 562
    .end local v1    # "e":Ljava/util/concurrent/TimeoutException;
    :catch_5
    move-exception v1

    .line 563
    .local v1, "e":Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;
    iget-object v9, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager$4;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    if-eqz v9, :cond_1

    .line 564
    iget-object v9, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager$4;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    invoke-interface {v9, v1}, Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;->onError(Ljava/lang/Exception;)V

    goto/16 :goto_1

    .line 565
    .end local v1    # "e":Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;
    :catch_6
    move-exception v1

    .line 566
    .local v1, "e":Ljava/lang/Exception;
    iget-object v9, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager$4;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    if-eqz v9, :cond_1

    .line 567
    iget-object v9, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager$4;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    new-instance v10, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v11, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_VIDEOS_SERVICE_ERROR:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    invoke-direct {v10, v11, v1}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;Ljava/lang/Throwable;)V

    invoke-interface {v9, v10}, Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;->onError(Ljava/lang/Exception;)V

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
    .line 491
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager$4;->call()Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog;

    move-result-object v0

    return-object v0
.end method
