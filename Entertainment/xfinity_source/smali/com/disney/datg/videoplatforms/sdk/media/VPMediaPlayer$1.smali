.class Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$1;
.super Ljava/lang/Object;
.source "VPMediaPlayer.java"

# interfaces
.implements Ljava/util/concurrent/Callable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->setDataSource(Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;)Ljava/util/concurrent/Future;
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
        "Ljava/lang/Boolean;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;

.field final synthetic val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

.field final synthetic val$media:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;


# direct methods
.method constructor <init>(Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;)V
    .locals 0

    .prologue
    .line 233
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;

    iput-object p2, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$1;->val$media:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    iput-object p3, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$1;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public call()Ljava/lang/Boolean;
    .locals 9
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    const/4 v8, 0x0

    const/4 v7, 0x1

    .line 238
    iget-object v3, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;

    iget-boolean v3, v3, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->isCancelled:Z

    if-eqz v3, :cond_0

    .line 239
    new-instance v3, Ljava/lang/IllegalStateException;

    new-instance v4, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v5, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_MEDIA_PLAYER_CREATION_EXCEPTION:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    const-string v6, "This media player is cancelled"

    invoke-direct {v4, v5, v6}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;Ljava/lang/String;)V

    invoke-direct {v3, v4}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/Throwable;)V

    throw v3

    .line 242
    :cond_0
    iget-object v3, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$1;->val$media:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    if-eqz v3, :cond_a

    .line 245
    iget-object v3, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$1;->val$media:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    invoke-virtual {v3}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getOnAuthorizationListener()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$VPMediaAuthorizationListener;

    move-result-object v3

    if-nez v3, :cond_1

    .line 246
    new-instance v3, Ljava/lang/IllegalStateException;

    new-instance v4, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v5, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_INVALID_MEDIA_EXCEPTION:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    const-string v6, "VPMedia object must have listener attached to receive AuthZ events"

    invoke-direct {v4, v5, v6}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;Ljava/lang/String;)V

    invoke-direct {v3, v4}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/Throwable;)V

    throw v3

    .line 250
    :cond_1
    iget-object v3, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$1;->val$media:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    iget-object v4, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;

    iget-object v4, v4, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->configuration:Lcom/disney/datg/videoplatforms/sdk/media/Configuration;

    invoke-virtual {v3, v4}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->setConfiguration(Lcom/disney/datg/videoplatforms/sdk/media/Configuration;)V

    .line 252
    iget-object v3, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;

    invoke-virtual {v3}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->removeTrackers()V

    .line 253
    iget-object v3, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;

    invoke-virtual {v3}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->addTrackers()V

    .line 256
    iget-object v3, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$1;->val$media:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    invoke-virtual {v3}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getContentUrl()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 257
    new-instance v3, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v4, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_MEDIA_PLAYER_ASSET_UNAVAILABLE:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    invoke-direct {v3, v4}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;)V

    throw v3

    .line 261
    :cond_2
    const/4 v2, 0x0

    .line 266
    .local v2, "futureAssetUrl":Ljava/util/concurrent/Future;, "Ljava/util/concurrent/Future<Ljava/lang/String;>;"
    :try_start_0
    iget-object v3, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;

    iget-boolean v3, v3, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->isCancelled:Z

    if-eqz v3, :cond_5

    .line 267
    new-instance v3, Ljava/lang/IllegalStateException;

    new-instance v4, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v5, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_MEDIA_PLAYER_CREATION_EXCEPTION:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    const-string v6, "This media player is cancelled"

    invoke-direct {v4, v5, v6}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;Ljava/lang/String;)V

    invoke-direct {v3, v4}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/Throwable;)V

    throw v3
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 304
    :catch_0
    move-exception v1

    .line 306
    .local v1, "e":Ljava/lang/Exception;
    if-eqz v2, :cond_3

    .line 307
    invoke-interface {v2, v7}, Ljava/util/concurrent/Future;->cancel(Z)Z

    .line 310
    :cond_3
    iget-object v3, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$1;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    if-eqz v3, :cond_4

    .line 311
    iget-object v3, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$1;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    invoke-interface {v3, v1}, Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;->onError(Ljava/lang/Exception;)V

    .line 313
    :cond_4
    iget-object v3, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;

    sget-object v4, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$TrackableState;->AUTHORIZATION_FAIL:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$TrackableState;

    invoke-virtual {v3, v4}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->sendTrackable(Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$TrackableState;)V

    .line 314
    iget-object v3, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;

    const/4 v4, 0x0

    # setter for: Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->authenticated:Z
    invoke-static {v3, v4}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->access$002(Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;Z)Z

    .line 315
    iget-object v3, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;

    invoke-virtual {v3, v8}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->setCurrentMedia(Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;)V

    .line 317
    new-instance v3, Ljava/lang/IllegalStateException;

    invoke-direct {v3, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/Throwable;)V

    throw v3

    .line 270
    .end local v1    # "e":Ljava/lang/Exception;
    :cond_5
    :try_start_1
    iget-object v3, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$1;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    if-eqz v3, :cond_6

    .line 271
    iget-object v3, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$1;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    invoke-interface {v3}, Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;->onAsyncTask()V

    .line 273
    :cond_6
    iget-object v3, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;

    iget-object v4, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$1;->val$media:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    invoke-virtual {v3, v4}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->setCurrentMedia(Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;)V

    .line 275
    iget-object v3, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;

    sget-object v4, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$TrackableState;->AUTHORIZATION_START:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$TrackableState;

    invoke-virtual {v3, v4}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->sendTrackable(Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$TrackableState;)V

    .line 277
    iget-object v3, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$1;->val$media:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    const/4 v4, 0x0

    invoke-virtual {v3, v4}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getPlayableAssetUrl(Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;)Ljava/util/concurrent/Future;

    move-result-object v2

    .line 278
    sget v3, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->SERVICE_TIMEOUT:I

    int-to-long v4, v3

    sget-object v3, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-interface {v2, v4, v5, v3}, Ljava/util/concurrent/Future;->get(JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 280
    .local v0, "assetUrl":Ljava/lang/String;
    iget-object v3, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;

    iget-boolean v3, v3, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->isCancelled:Z

    if-eqz v3, :cond_7

    .line 281
    new-instance v3, Ljava/lang/IllegalStateException;

    new-instance v4, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v5, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_MEDIA_PLAYER_CREATION_EXCEPTION:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    const-string v6, "This media player is cancelled"

    invoke-direct {v4, v5, v6}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;Ljava/lang/String;)V

    invoke-direct {v3, v4}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/Throwable;)V

    throw v3

    .line 284
    :cond_7
    iget-object v3, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;

    iget-object v3, v3, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    if-eqz v3, :cond_8

    iget-object v3, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;

    iget-object v3, v3, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->configuration:Lcom/disney/datg/videoplatforms/sdk/media/Configuration;

    invoke-virtual {v3}, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->getCurrentConfig()Lcom/disney/datg/videoplatforms/sdk/models/api/Config;

    move-result-object v3

    const-string v4, "maxBitrate"

    const-string v5, "FEAT0006"

    invoke-virtual {v3, v4, v5}, Lcom/disney/datg/videoplatforms/sdk/models/api/Config;->getParamInFeatureId(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    move-result-object v3

    if-eqz v3, :cond_8

    .line 287
    :try_start_2
    iget-object v3, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;

    iget-object v3, v3, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    iget-object v4, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;

    iget-object v4, v4, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->configuration:Lcom/disney/datg/videoplatforms/sdk/media/Configuration;

    invoke-virtual {v4}, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->getCurrentConfig()Lcom/disney/datg/videoplatforms/sdk/models/api/Config;

    move-result-object v4

    const-string v5, "maxBitrate"

    const-string v6, "FEAT0006"

    invoke-virtual {v4, v5, v6}, Lcom/disney/datg/videoplatforms/sdk/models/api/Config;->getParamInFeatureId(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v4

    invoke-virtual {v3, v4}, Lcom/uplynk/media/MediaPlayer;->setMaxBitrate(I)V
    :try_end_2
    .catch Ljava/lang/NumberFormatException; {:try_start_2 .. :try_end_2} :catch_1
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0

    .line 294
    :cond_8
    :goto_0
    :try_start_3
    iget-object v3, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;

    invoke-virtual {v3, v0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->setDataSource(Ljava/lang/String;)V

    .line 296
    iget-object v3, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;

    sget-object v4, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$TrackableState;->AUTHORIZATION_SUCCESS:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$TrackableState;

    invoke-virtual {v3, v4}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->sendTrackable(Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$TrackableState;)V

    .line 297
    iget-object v3, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;

    const/4 v4, 0x1

    # setter for: Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->authenticated:Z
    invoke-static {v3, v4}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->access$002(Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;Z)Z

    .line 299
    iget-object v3, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$1;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    if-eqz v3, :cond_9

    .line 300
    iget-object v3, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$1;->val$asyncHandler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    invoke-interface {v3, v0}, Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;->onSuccess(Ljava/lang/Object;)V

    .line 302
    :cond_9
    const/4 v3, 0x1

    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v3

    return-object v3

    .line 289
    :catch_1
    move-exception v1

    .line 290
    .local v1, "e":Ljava/lang/NumberFormatException;
    const-string v3, "VPMediaPlayer"

    const-string v4, "error parsing maxbitrate in config, so it is being ignored"

    invoke-static {v3, v4}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGW(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_0

    goto :goto_0

    .line 322
    .end local v0    # "assetUrl":Ljava/lang/String;
    .end local v1    # "e":Ljava/lang/NumberFormatException;
    .end local v2    # "futureAssetUrl":Ljava/util/concurrent/Future;, "Ljava/util/concurrent/Future<Ljava/lang/String;>;"
    :cond_a
    new-instance v3, Ljava/lang/IllegalArgumentException;

    new-instance v4, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v5, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_INVALID_MEDIA_EXCEPTION:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    const-string v6, "valid Media object must be set"

    invoke-direct {v4, v5, v6}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;Ljava/lang/String;)V

    invoke-direct {v3, v4}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/Throwable;)V

    throw v3
.end method

.method public bridge synthetic call()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 233
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$1;->call()Ljava/lang/Boolean;

    move-result-object v0

    return-object v0
.end method
