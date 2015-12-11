.class Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$29;
.super Ljava/lang/Object;
.source "PlayerEventManager.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;->adStart(Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

.field final synthetic val$ad:Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;


# direct methods
.method constructor <init>(Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;)V
    .locals 0

    .prologue
    .line 438
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$29;->this$0:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    iput-object p2, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$29;->val$ad:Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 441
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$29;->this$0:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    iget-object v3, v2, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;->listeners:Ljava/util/List;

    monitor-enter v3

    .line 442
    :try_start_0
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$29;->this$0:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    iget-object v2, v2, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;->listeners:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;

    .line 443
    .local v1, "listener":Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$29;->val$ad:Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;

    invoke-virtual {v1, v2}, Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;->adStart(Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;)V

    goto :goto_0

    .line 445
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v1    # "listener":Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;
    :catchall_0
    move-exception v2

    monitor-exit v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v2

    .restart local v0    # "i$":Ljava/util/Iterator;
    :cond_0
    :try_start_1
    monitor-exit v3
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 446
    return-void
.end method
