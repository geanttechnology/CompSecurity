.class Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$30;
.super Ljava/lang/Object;
.source "PlayerEventManager.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;->adProgress(Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;IJ)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

.field final synthetic val$ad:Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;

.field final synthetic val$adBreak:Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

.field final synthetic val$progress:I

.field final synthetic val$timeRemaining:J


# direct methods
.method constructor <init>(Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;IJ)V
    .locals 1

    .prologue
    .line 452
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$30;->this$0:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    iput-object p2, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$30;->val$adBreak:Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    iput-object p3, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$30;->val$ad:Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;

    iput p4, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$30;->val$progress:I

    iput-wide p5, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$30;->val$timeRemaining:J

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 8

    .prologue
    .line 455
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$30;->this$0:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    iget-object v7, v1, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;->listeners:Ljava/util/List;

    monitor-enter v7

    .line 456
    :try_start_0
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$30;->this$0:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    iget-object v1, v1, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;->listeners:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v6

    .local v6, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;

    .line 457
    .local v0, "listener":Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$30;->val$adBreak:Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$30;->val$ad:Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;

    iget v3, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$30;->val$progress:I

    iget-wide v4, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$30;->val$timeRemaining:J

    invoke-virtual/range {v0 .. v5}, Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;->adProgress(Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;IJ)V

    goto :goto_0

    .line 459
    .end local v0    # "listener":Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;
    .end local v6    # "i$":Ljava/util/Iterator;
    :catchall_0
    move-exception v1

    monitor-exit v7
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1

    .restart local v6    # "i$":Ljava/util/Iterator;
    :cond_0
    :try_start_1
    monitor-exit v7
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 460
    return-void
.end method
