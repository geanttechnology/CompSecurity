.class Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;
.super Ljava/lang/Object;
.source "VPPlayerManager.java"

# interfaces
.implements Ljava/util/concurrent/Callable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->getPlayer(Landroid/app/Activity;Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;Landroid/view/SurfaceHolder;Landroid/widget/RelativeLayout;Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;)Ljava/util/concurrent/Future;
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
        "Landroid/media/MediaPlayer;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;

.field final synthetic val$ccContainer:Landroid/widget/RelativeLayout;

.field final synthetic val$context:Landroid/app/Activity;

.field final synthetic val$handler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

.field final synthetic val$holder:Landroid/view/SurfaceHolder;

.field final synthetic val$media:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;


# direct methods
.method constructor <init>(Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;Landroid/app/Activity;Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;Landroid/view/SurfaceHolder;Landroid/widget/RelativeLayout;)V
    .locals 0

    .prologue
    .line 118
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;

    iput-object p2, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;->val$context:Landroid/app/Activity;

    iput-object p3, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;->val$media:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    iput-object p4, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;->val$handler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    iput-object p5, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;->val$holder:Landroid/view/SurfaceHolder;

    iput-object p6, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;->val$ccContainer:Landroid/widget/RelativeLayout;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public call()Landroid/media/MediaPlayer;
    .locals 12
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    const/4 v10, 0x0

    const/4 v11, 0x0

    .line 124
    iget-object v8, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;

    # getter for: Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->catalogManager:Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager;
    invoke-static {v8}, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->access$000(Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;)Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager;

    move-result-object v8

    iget-object v9, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;->val$context:Landroid/app/Activity;

    invoke-virtual {v8, v9}, Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager;->setContext(Landroid/content/Context;)V

    .line 127
    iget-object v8, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;->val$media:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    if-eqz v8, :cond_0

    iget-object v8, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;->val$media:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    invoke-virtual {v8}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getMediaId()Ljava/lang/String;

    move-result-object v8

    invoke-static {v8}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v8

    if-eqz v8, :cond_1

    .line 128
    :cond_0
    iget-object v8, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;

    # setter for: Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->requestInProgress:Z
    invoke-static {v8, v11}, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->access$102(Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;Z)Z

    .line 129
    new-instance v8, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v9, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_INVALID_MEDIA_EXCEPTION:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    const-string v10, "media item is null"

    invoke-direct {v8, v9, v10}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;Ljava/lang/String;)V

    throw v8

    .line 132
    :cond_1
    iget-object v8, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;

    # getter for: Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->isCancelled:Z
    invoke-static {v8}, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->access$200(Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;)Z

    move-result v8

    if-eqz v8, :cond_2

    .line 133
    iget-object v8, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;

    # setter for: Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->requestInProgress:Z
    invoke-static {v8, v11}, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->access$102(Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;Z)Z

    .line 134
    new-instance v8, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v9, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_MEDIA_PLAYER_CREATION_EXCEPTION:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    const-string v10, "creation has been cancelled"

    invoke-direct {v8, v9, v10}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;Ljava/lang/String;)V

    throw v8

    .line 137
    :cond_2
    const/4 v7, 0x0

    .line 139
    .local v7, "videoQueryMedia":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    iget-object v8, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;->val$media:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    invoke-virtual {v8}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getContentUrl()Ljava/lang/String;

    move-result-object v8

    invoke-static {v8}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v8

    if-eqz v8, :cond_10

    .line 141
    iget-object v8, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;->val$media:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    invoke-virtual {v8}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getMediaId()Ljava/lang/String;

    move-result-object v8

    invoke-static {v8}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v8

    if-eqz v8, :cond_3

    .line 142
    iget-object v8, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;

    # setter for: Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->requestInProgress:Z
    invoke-static {v8, v11}, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->access$102(Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;Z)Z

    .line 143
    new-instance v8, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v9, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_INVALID_MEDIA_EXCEPTION:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    const-string v10, "media id is null or empty"

    invoke-direct {v8, v9, v10}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;Ljava/lang/String;)V

    throw v8

    .line 146
    :cond_3
    const/4 v3, 0x0

    .line 147
    .local v3, "futureCatalog":Ljava/util/concurrent/Future;, "Ljava/util/concurrent/Future<Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog;>;"
    iget-object v8, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;->val$media:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    invoke-virtual {v8}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getMediaType()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;

    move-result-object v8

    sget-object v9, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;->VOD:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;

    if-ne v8, v9, :cond_5

    .line 149
    iget-object v8, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;

    # getter for: Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->catalogManager:Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager;
    invoke-static {v8}, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->access$000(Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;)Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager;

    move-result-object v8

    iget-object v9, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;->val$media:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    invoke-virtual {v9}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getMediaId()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9, v10}, Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager;->getVideoCatalog(Ljava/lang/String;Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;)Ljava/util/concurrent/Future;

    move-result-object v3

    .line 156
    :cond_4
    :goto_0
    iget-object v8, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;

    # getter for: Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->isCancelled:Z
    invoke-static {v8}, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->access$200(Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;)Z

    move-result v8

    if-eqz v8, :cond_6

    .line 157
    iget-object v8, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;

    # setter for: Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->requestInProgress:Z
    invoke-static {v8, v11}, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->access$102(Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;Z)Z

    .line 158
    new-instance v8, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v9, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_MEDIA_PLAYER_CREATION_EXCEPTION:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    const-string v10, "creation has been cancelled"

    invoke-direct {v8, v9, v10}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;Ljava/lang/String;)V

    throw v8

    .line 151
    :cond_5
    iget-object v8, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;->val$media:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    invoke-virtual {v8}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getMediaType()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;

    move-result-object v8

    sget-object v9, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;->LIVE:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;

    if-ne v8, v9, :cond_4

    .line 152
    iget-object v8, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;

    # getter for: Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->catalogManager:Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager;
    invoke-static {v8}, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->access$000(Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;)Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager;

    move-result-object v8

    invoke-virtual {v8, v10}, Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager;->getChannelCatalog(Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;)Ljava/util/concurrent/Future;

    move-result-object v3

    goto :goto_0

    .line 162
    :cond_6
    if-eqz v3, :cond_a

    .line 163
    :try_start_0
    sget v8, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->SERVICE_TIMEOUT:I

    int-to-long v8, v8

    sget-object v10, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-interface {v3, v8, v9, v10}, Ljava/util/concurrent/Future;->get(JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog;

    .line 164
    .local v0, "catalog":Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog;
    if-eqz v0, :cond_8

    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog;->getCollection()Ljava/util/List;

    move-result-object v8

    if-eqz v8, :cond_8

    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog;->getCollection()Ljava/util/List;

    move-result-object v8

    invoke-interface {v8}, Ljava/util/List;->size()I

    move-result v8

    if-lez v8, :cond_8

    .line 165
    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog;->getCollection()Ljava/util/List;

    move-result-object v4

    .line 166
    .local v4, "mediaCollection":Ljava/util/List;, "Ljava/util/List<Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;>;"
    const/4 v8, 0x0

    invoke-interface {v4, v8}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v7

    .end local v7    # "videoQueryMedia":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    check-cast v7, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/util/concurrent/ExecutionException; {:try_start_0 .. :try_end_0} :catch_2
    .catch Ljava/util/concurrent/RejectedExecutionException; {:try_start_0 .. :try_end_0} :catch_3
    .catch Ljava/util/concurrent/TimeoutException; {:try_start_0 .. :try_end_0} :catch_4
    .catch Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException; {:try_start_0 .. :try_end_0} :catch_5
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_6

    .line 224
    .end local v0    # "catalog":Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog;
    .end local v3    # "futureCatalog":Ljava/util/concurrent/Future;, "Ljava/util/concurrent/Future<Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog;>;"
    .end local v4    # "mediaCollection":Ljava/util/List;, "Ljava/util/List<Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;>;"
    .restart local v7    # "videoQueryMedia":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    :goto_1
    :try_start_1
    sget-object v6, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$PlayerType;->VOD:Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$PlayerType;

    .line 225
    .local v6, "playerType":Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$PlayerType;
    sget-object v8, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$2;->$SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMedia$MediaType:[I

    iget-object v9, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;->val$media:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    invoke-virtual {v9}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getMediaType()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;

    move-result-object v9

    invoke-virtual {v9}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;->ordinal()I

    move-result v9

    aget v8, v8, v9

    packed-switch v8, :pswitch_data_0

    .line 234
    :goto_2
    iget-object v8, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;

    # getter for: Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->isCancelled:Z
    invoke-static {v8}, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->access$200(Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;)Z

    move-result v8

    if-eqz v8, :cond_11

    .line 235
    iget-object v8, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;

    const/4 v9, 0x0

    # setter for: Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->requestInProgress:Z
    invoke-static {v8, v9}, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->access$102(Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;Z)Z

    .line 236
    new-instance v8, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v9, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_MEDIA_PLAYER_CREATION_EXCEPTION:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    const-string v10, "creation has been cancelled"

    invoke-direct {v8, v9, v10}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;Ljava/lang/String;)V

    throw v8
    :try_end_1
    .catch Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_1 .. :try_end_1} :catch_7
    .catch Ljava/lang/IllegalStateException; {:try_start_1 .. :try_end_1} :catch_8
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_9

    .line 299
    .end local v6    # "playerType":Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$PlayerType;
    :catch_0
    move-exception v1

    .line 300
    .local v1, "e":Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;
    iget-object v8, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;->val$handler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    if-eqz v8, :cond_7

    .line 301
    iget-object v8, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;->val$handler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    invoke-interface {v8, v1}, Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;->onError(Ljava/lang/Exception;)V

    .line 303
    :cond_7
    throw v1

    .line 168
    .end local v1    # "e":Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;
    .restart local v0    # "catalog":Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog;
    .restart local v3    # "futureCatalog":Ljava/util/concurrent/Future;, "Ljava/util/concurrent/Future<Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog;>;"
    :cond_8
    :try_start_2
    iget-object v8, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;

    const/4 v9, 0x0

    # setter for: Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->requestInProgress:Z
    invoke-static {v8, v9}, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->access$102(Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;Z)Z

    .line 169
    new-instance v8, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v9, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_INVALID_MEDIA_EXCEPTION:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    const-string v10, "catalog returned null or empty results for video media"

    invoke-direct {v8, v9, v10}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;Ljava/lang/String;)V

    throw v8
    :try_end_2
    .catch Ljava/lang/InterruptedException; {:try_start_2 .. :try_end_2} :catch_1
    .catch Ljava/util/concurrent/ExecutionException; {:try_start_2 .. :try_end_2} :catch_2
    .catch Ljava/util/concurrent/RejectedExecutionException; {:try_start_2 .. :try_end_2} :catch_3
    .catch Ljava/util/concurrent/TimeoutException; {:try_start_2 .. :try_end_2} :catch_4
    .catch Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException; {:try_start_2 .. :try_end_2} :catch_5
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_6

    .line 176
    .end local v0    # "catalog":Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog;
    .end local v7    # "videoQueryMedia":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    :catch_1
    move-exception v1

    .line 177
    .local v1, "e":Ljava/lang/InterruptedException;
    iget-object v8, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;

    # setter for: Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->requestInProgress:Z
    invoke-static {v8, v11}, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->access$102(Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;Z)Z

    .line 178
    new-instance v2, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v8, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_VIDEOS_SERVICE_ERROR:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    invoke-direct {v2, v8, v1}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;Ljava/lang/Throwable;)V

    .line 179
    .local v2, "ex":Ljava/lang/Exception;
    iget-object v8, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;->val$handler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    if-eqz v8, :cond_9

    .line 180
    iget-object v8, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;->val$handler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    invoke-interface {v8, v2}, Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;->onError(Ljava/lang/Exception;)V

    .line 181
    :cond_9
    throw v2

    .line 172
    .end local v1    # "e":Ljava/lang/InterruptedException;
    .end local v2    # "ex":Ljava/lang/Exception;
    .restart local v7    # "videoQueryMedia":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    :cond_a
    :try_start_3
    iget-object v8, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;

    const/4 v9, 0x0

    # setter for: Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->requestInProgress:Z
    invoke-static {v8, v9}, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->access$102(Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;Z)Z

    .line 173
    new-instance v8, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v9, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_INVALID_MEDIA_EXCEPTION:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    const-string v10, "catalog returned null or empty results for video media"

    invoke-direct {v8, v9, v10}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;Ljava/lang/String;)V

    throw v8
    :try_end_3
    .catch Ljava/lang/InterruptedException; {:try_start_3 .. :try_end_3} :catch_1
    .catch Ljava/util/concurrent/ExecutionException; {:try_start_3 .. :try_end_3} :catch_2
    .catch Ljava/util/concurrent/RejectedExecutionException; {:try_start_3 .. :try_end_3} :catch_3
    .catch Ljava/util/concurrent/TimeoutException; {:try_start_3 .. :try_end_3} :catch_4
    .catch Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException; {:try_start_3 .. :try_end_3} :catch_5
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_6

    .line 182
    .end local v7    # "videoQueryMedia":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    :catch_2
    move-exception v1

    .line 183
    .local v1, "e":Ljava/util/concurrent/ExecutionException;
    iget-object v8, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;

    # setter for: Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->requestInProgress:Z
    invoke-static {v8, v11}, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->access$102(Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;Z)Z

    .line 184
    new-instance v2, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v8, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_VIDEOS_SERVICE_ERROR:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    invoke-direct {v2, v8, v1}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;Ljava/lang/Throwable;)V

    .line 185
    .restart local v2    # "ex":Ljava/lang/Exception;
    iget-object v8, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;->val$handler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    if-eqz v8, :cond_b

    .line 186
    iget-object v8, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;->val$handler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    invoke-interface {v8, v2}, Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;->onError(Ljava/lang/Exception;)V

    .line 187
    :cond_b
    throw v2

    .line 189
    .end local v1    # "e":Ljava/util/concurrent/ExecutionException;
    .end local v2    # "ex":Ljava/lang/Exception;
    :catch_3
    move-exception v1

    .line 190
    .local v1, "e":Ljava/util/concurrent/RejectedExecutionException;
    iget-object v8, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;

    # setter for: Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->requestInProgress:Z
    invoke-static {v8, v11}, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->access$102(Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;Z)Z

    .line 191
    new-instance v2, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v8, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_VIDEOS_SERVICE_ERROR:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    invoke-direct {v2, v8, v1}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;Ljava/lang/Throwable;)V

    .line 192
    .restart local v2    # "ex":Ljava/lang/Exception;
    iget-object v8, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;->val$handler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    if-eqz v8, :cond_c

    .line 193
    iget-object v8, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;->val$handler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    invoke-interface {v8, v2}, Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;->onError(Ljava/lang/Exception;)V

    .line 194
    :cond_c
    throw v2

    .line 196
    .end local v1    # "e":Ljava/util/concurrent/RejectedExecutionException;
    .end local v2    # "ex":Ljava/lang/Exception;
    :catch_4
    move-exception v1

    .line 197
    .local v1, "e":Ljava/util/concurrent/TimeoutException;
    iget-object v8, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;

    # setter for: Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->requestInProgress:Z
    invoke-static {v8, v11}, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->access$102(Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;Z)Z

    .line 198
    new-instance v2, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v8, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_VIDEOS_SERVICE_TIMEOUT:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    invoke-direct {v2, v8, v1}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;Ljava/lang/Throwable;)V

    .line 199
    .restart local v2    # "ex":Ljava/lang/Exception;
    iget-object v8, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;->val$handler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    if-eqz v8, :cond_d

    .line 200
    iget-object v8, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;->val$handler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    invoke-interface {v8, v2}, Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;->onError(Ljava/lang/Exception;)V

    .line 201
    :cond_d
    throw v2

    .line 202
    .end local v1    # "e":Ljava/util/concurrent/TimeoutException;
    .end local v2    # "ex":Ljava/lang/Exception;
    :catch_5
    move-exception v2

    .line 203
    .local v2, "ex":Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;
    iget-object v8, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;

    # setter for: Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->requestInProgress:Z
    invoke-static {v8, v11}, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->access$102(Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;Z)Z

    .line 204
    iget-object v8, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;->val$handler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    if-eqz v8, :cond_e

    .line 205
    iget-object v8, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;->val$handler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    invoke-interface {v8, v2}, Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;->onError(Ljava/lang/Exception;)V

    .line 206
    :cond_e
    throw v2

    .line 208
    .end local v2    # "ex":Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;
    :catch_6
    move-exception v1

    .line 209
    .local v1, "e":Ljava/lang/Exception;
    iget-object v8, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;

    # setter for: Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->requestInProgress:Z
    invoke-static {v8, v11}, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->access$102(Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;Z)Z

    .line 210
    new-instance v2, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v8, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_VIDEOS_SERVICE_ERROR:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    invoke-direct {v2, v8, v1}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;Ljava/lang/Throwable;)V

    .line 211
    .local v2, "ex":Ljava/lang/Exception;
    iget-object v8, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;->val$handler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    if-eqz v8, :cond_f

    .line 212
    iget-object v8, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;->val$handler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    invoke-interface {v8, v2}, Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;->onError(Ljava/lang/Exception;)V

    .line 213
    :cond_f
    throw v2

    .line 218
    .end local v1    # "e":Ljava/lang/Exception;
    .end local v2    # "ex":Ljava/lang/Exception;
    .end local v3    # "futureCatalog":Ljava/util/concurrent/Future;, "Ljava/util/concurrent/Future<Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog;>;"
    .restart local v7    # "videoQueryMedia":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    :cond_10
    iget-object v7, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;->val$media:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    goto/16 :goto_1

    .line 227
    .restart local v6    # "playerType":Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$PlayerType;
    :pswitch_0
    :try_start_4
    sget-object v6, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$PlayerType;->LIVE:Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$PlayerType;

    .line 228
    goto/16 :goto_2

    .line 230
    :pswitch_1
    sget-object v6, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$PlayerType;->VOD:Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$PlayerType;

    goto/16 :goto_2

    .line 239
    :cond_11
    iget-object v8, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;

    iget-object v9, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;->val$context:Landroid/app/Activity;

    iget-object v10, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;->val$holder:Landroid/view/SurfaceHolder;

    iget-object v11, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;->val$ccContainer:Landroid/widget/RelativeLayout;

    invoke-virtual {v8, v6, v9, v10, v11}, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->getPlayer(Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$PlayerType;Landroid/app/Activity;Landroid/view/SurfaceHolder;Landroid/widget/RelativeLayout;)Landroid/media/MediaPlayer;

    move-result-object v5

    check-cast v5, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;

    .line 241
    .local v5, "mediaPlayer":Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;
    iget-object v8, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;

    # getter for: Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->isCancelled:Z
    invoke-static {v8}, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->access$200(Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;)Z

    move-result v8

    if-eqz v8, :cond_13

    .line 242
    iget-object v8, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;

    const/4 v9, 0x0

    # setter for: Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->requestInProgress:Z
    invoke-static {v8, v9}, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->access$102(Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;Z)Z

    .line 243
    const/4 v8, 0x0

    invoke-virtual {v5, v8}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->setDisplay(Landroid/view/SurfaceHolder;)V

    .line 244
    new-instance v8, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v9, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_MEDIA_PLAYER_CREATION_EXCEPTION:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    const-string v10, "creation has been cancelled"

    invoke-direct {v8, v9, v10}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;Ljava/lang/String;)V

    throw v8
    :try_end_4
    .catch Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException; {:try_start_4 .. :try_end_4} :catch_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_4 .. :try_end_4} :catch_7
    .catch Ljava/lang/IllegalStateException; {:try_start_4 .. :try_end_4} :catch_8
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_9

    .line 304
    .end local v5    # "mediaPlayer":Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;
    .end local v6    # "playerType":Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$PlayerType;
    :catch_7
    move-exception v1

    .line 305
    .local v1, "e":Ljava/lang/IllegalArgumentException;
    iget-object v8, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;->val$handler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    if-eqz v8, :cond_12

    .line 306
    iget-object v8, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;->val$handler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    invoke-interface {v8, v1}, Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;->onError(Ljava/lang/Exception;)V

    .line 308
    :cond_12
    throw v1

    .line 247
    .end local v1    # "e":Ljava/lang/IllegalArgumentException;
    .restart local v5    # "mediaPlayer":Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;
    .restart local v6    # "playerType":Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$PlayerType;
    :cond_13
    :try_start_5
    new-instance v8, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1$1;

    invoke-direct {v8, p0, v5}, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1$1;-><init>(Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;)V

    invoke-virtual {v5, v7, v8}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->setDataSource(Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;)Ljava/util/concurrent/Future;

    .line 280
    new-instance v8, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1$2;

    invoke-direct {v8, p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1$2;-><init>(Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;)V

    invoke-virtual {v5, v8}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->setOnPreparedListener(Landroid/media/MediaPlayer$OnPreparedListener;)V

    .line 291
    iget-object v8, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;

    # getter for: Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->isCancelled:Z
    invoke-static {v8}, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->access$200(Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;)Z

    move-result v8

    if-eqz v8, :cond_16

    .line 292
    iget-object v8, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;

    const/4 v9, 0x0

    # setter for: Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->requestInProgress:Z
    invoke-static {v8, v9}, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->access$102(Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;Z)Z

    .line 293
    const/4 v8, 0x0

    invoke-virtual {v5, v8}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->setDisplay(Landroid/view/SurfaceHolder;)V

    .line 294
    new-instance v8, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v9, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_MEDIA_PLAYER_CREATION_EXCEPTION:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    const-string v10, "creation has been cancelled"

    invoke-direct {v8, v9, v10}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;Ljava/lang/String;)V

    throw v8
    :try_end_5
    .catch Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException; {:try_start_5 .. :try_end_5} :catch_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_5 .. :try_end_5} :catch_7
    .catch Ljava/lang/IllegalStateException; {:try_start_5 .. :try_end_5} :catch_8
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_9

    .line 309
    .end local v5    # "mediaPlayer":Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;
    .end local v6    # "playerType":Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$PlayerType;
    :catch_8
    move-exception v1

    .line 310
    .local v1, "e":Ljava/lang/IllegalStateException;
    iget-object v8, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;->val$handler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    if-eqz v8, :cond_14

    .line 311
    iget-object v8, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;->val$handler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    invoke-interface {v8, v1}, Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;->onError(Ljava/lang/Exception;)V

    .line 313
    :cond_14
    throw v1

    .line 314
    .end local v1    # "e":Ljava/lang/IllegalStateException;
    :catch_9
    move-exception v1

    .line 315
    .local v1, "e":Ljava/lang/Exception;
    iget-object v8, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;->val$handler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    if-eqz v8, :cond_15

    .line 316
    iget-object v8, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;->val$handler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    invoke-interface {v8, v1}, Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;->onError(Ljava/lang/Exception;)V

    .line 318
    :cond_15
    throw v1

    .line 297
    .end local v1    # "e":Ljava/lang/Exception;
    .restart local v5    # "mediaPlayer":Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;
    .restart local v6    # "playerType":Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$PlayerType;
    :cond_16
    return-object v5

    .line 225
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public bridge synthetic call()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 118
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;->call()Landroid/media/MediaPlayer;

    move-result-object v0

    return-object v0
.end method
