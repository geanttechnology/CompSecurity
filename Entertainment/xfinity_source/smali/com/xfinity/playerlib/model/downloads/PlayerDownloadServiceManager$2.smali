.class Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager$2;
.super Ljava/lang/Object;
.source "PlayerDownloadServiceManager.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->downloadHlsFileWithWatchable(Lcom/xfinity/playerlib/model/consumable/Watchable;Lcom/xfinity/playerlib/model/consumable/VideoFacade;Ljava/util/Date;Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;Lcom/google/common/util/concurrent/FutureCallback;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

.field final synthetic val$alternateAudioPlaylist:Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;

.field final synthetic val$backingEntity:Lcom/comcast/cim/cmasl/utils/container/Either;

.field final synthetic val$extraTask:Ljava/lang/Runnable;

.field final synthetic val$metaData:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;

.field final synthetic val$resultCallback:Lcom/google/common/util/concurrent/FutureCallback;

.field final synthetic val$simplePlaylist:Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;

.field final synthetic val$uuid:Ljava/util/UUID;

.field final synthetic val$variantPlaylist:Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;

.field final synthetic val$videoId:J


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;Ljava/util/UUID;Lcom/comcast/cim/cmasl/utils/container/Either;JLcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;Ljava/lang/Runnable;Lcom/google/common/util/concurrent/FutureCallback;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    .prologue
    .line 201
    iput-object p1, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager$2;->this$0:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    iput-object p2, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager$2;->val$uuid:Ljava/util/UUID;

    iput-object p3, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager$2;->val$backingEntity:Lcom/comcast/cim/cmasl/utils/container/Either;

    iput-wide p4, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager$2;->val$videoId:J

    iput-object p6, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager$2;->val$simplePlaylist:Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;

    iput-object p7, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager$2;->val$variantPlaylist:Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;

    iput-object p8, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager$2;->val$alternateAudioPlaylist:Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;

    iput-object p9, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager$2;->val$metaData:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;

    iput-object p10, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager$2;->val$extraTask:Ljava/lang/Runnable;

    iput-object p11, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager$2;->val$resultCallback:Lcom/google/common/util/concurrent/FutureCallback;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 9

    .prologue
    .line 204
    iget-object v0, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager$2;->this$0:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    # getter for: Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->entityCache:Lcom/xfinity/playerlib/model/downloads/PersistentEntityCache;
    invoke-static {v0}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->access$100(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;)Lcom/xfinity/playerlib/model/downloads/PersistentEntityCache;

    move-result-object v0

    iget-object v1, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager$2;->val$uuid:Ljava/util/UUID;

    iget-object v2, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager$2;->val$backingEntity:Lcom/comcast/cim/cmasl/utils/container/Either;

    invoke-virtual {v0, v1, v2}, Lcom/xfinity/playerlib/model/downloads/PersistentEntityCache;->store(Ljava/util/UUID;Lcom/comcast/cim/cmasl/utils/container/Either;)V

    .line 206
    :try_start_0
    iget-object v0, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager$2;->this$0:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, ""

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-wide v2, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager$2;->val$videoId:J

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager$2;->val$simplePlaylist:Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;

    iget-object v3, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager$2;->val$variantPlaylist:Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;

    iget-object v4, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager$2;->val$alternateAudioPlaylist:Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;

    iget-object v5, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager$2;->val$metaData:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;

    iget-object v6, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager$2;->val$extraTask:Ljava/lang/Runnable;

    iget-object v7, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager$2;->val$resultCallback:Lcom/google/common/util/concurrent/FutureCallback;

    # invokes: Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->downloadHlsFileWithMetadata(Ljava/lang/String;Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;Lcom/comcast/cim/downloads/DownloadMetaData;Ljava/lang/Runnable;Lcom/google/common/util/concurrent/FutureCallback;)V
    invoke-static/range {v0 .. v7}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->access$200(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;Ljava/lang/String;Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;Lcom/comcast/cim/downloads/DownloadMetaData;Ljava/lang/Runnable;Lcom/google/common/util/concurrent/FutureCallback;)V
    :try_end_0
    .catch Lcom/comcast/cim/downloads/DownloadServiceException; {:try_start_0 .. :try_end_0} :catch_0

    .line 210
    :goto_0
    return-void

    .line 207
    :catch_0
    move-exception v8

    .line 208
    .local v8, "e":Lcom/comcast/cim/downloads/DownloadServiceException;
    iget-object v0, p0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager$2;->val$resultCallback:Lcom/google/common/util/concurrent/FutureCallback;

    invoke-interface {v0, v8}, Lcom/google/common/util/concurrent/FutureCallback;->onFailure(Ljava/lang/Throwable;)V

    goto :goto_0
.end method
