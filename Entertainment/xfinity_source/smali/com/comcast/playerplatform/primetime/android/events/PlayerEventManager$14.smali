.class Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$14;
.super Ljava/lang/Object;
.source "PlayerEventManager.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;->mediaProgress(JDJJI)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

.field final synthetic val$endPosition:J

.field final synthetic val$playbackSpeed:D

.field final synthetic val$position:J

.field final synthetic val$startPosition:J

.field final synthetic val$updateInterval:I


# direct methods
.method constructor <init>(Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;JDJJI)V
    .locals 0

    .prologue
    .line 228
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$14;->this$0:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    iput-wide p2, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$14;->val$position:J

    iput-wide p4, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$14;->val$playbackSpeed:D

    iput-wide p6, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$14;->val$startPosition:J

    iput-wide p8, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$14;->val$endPosition:J

    iput p10, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$14;->val$updateInterval:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 12

    .prologue
    .line 231
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$14;->this$0:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    iget-object v11, v2, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;->listeners:Ljava/util/List;

    monitor-enter v11

    .line 232
    :try_start_0
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$14;->this$0:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

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

    .line 233
    .local v1, "listener":Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;
    iget-wide v2, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$14;->val$position:J

    iget-wide v4, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$14;->val$playbackSpeed:D

    iget-wide v6, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$14;->val$startPosition:J

    iget-wide v8, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$14;->val$endPosition:J

    iget v10, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$14;->val$updateInterval:I

    invoke-virtual/range {v1 .. v10}, Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;->mediaProgress(JDJJI)V

    goto :goto_0

    .line 235
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v1    # "listener":Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;
    :catchall_0
    move-exception v2

    monitor-exit v11
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v2

    .restart local v0    # "i$":Ljava/util/Iterator;
    :cond_0
    :try_start_1
    monitor-exit v11
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 236
    return-void
.end method
