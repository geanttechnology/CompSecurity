.class Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$4;
.super Ljava/lang/Object;
.source "PlayerEventManager.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;->droppedFPSChanged(J)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

.field final synthetic val$droppedFPS:J


# direct methods
.method constructor <init>(Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;J)V
    .locals 0

    .prologue
    .line 87
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$4;->this$0:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    iput-wide p2, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$4;->val$droppedFPS:J

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 6

    .prologue
    .line 90
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$4;->this$0:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    iget-object v3, v2, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;->listeners:Ljava/util/List;

    monitor-enter v3

    .line 91
    :try_start_0
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$4;->this$0:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

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

    .line 92
    .local v1, "listener":Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;
    iget-wide v4, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$4;->val$droppedFPS:J

    invoke-virtual {v1, v4, v5}, Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;->droppedFPSChanged(J)V

    goto :goto_0

    .line 94
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

    .line 95
    return-void
.end method
