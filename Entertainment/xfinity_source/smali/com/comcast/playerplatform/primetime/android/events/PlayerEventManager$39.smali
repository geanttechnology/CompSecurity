.class Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$39;
.super Ljava/lang/Object;
.source "PlayerEventManager.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;->fragmentWarning(JJJLjava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

.field final synthetic val$downloadDuration:J

.field final synthetic val$fragmentDuration:J

.field final synthetic val$fragmentSize:J

.field final synthetic val$url:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;JJJLjava/lang/String;)V
    .locals 0

    .prologue
    .line 578
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$39;->this$0:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    iput-wide p2, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$39;->val$downloadDuration:J

    iput-wide p4, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$39;->val$fragmentDuration:J

    iput-wide p6, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$39;->val$fragmentSize:J

    iput-object p8, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$39;->val$url:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 10

    .prologue
    .line 581
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$39;->this$0:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    iget-object v9, v2, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;->listeners:Ljava/util/List;

    monitor-enter v9

    .line 582
    :try_start_0
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$39;->this$0:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

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

    .line 583
    .local v1, "listener":Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;
    iget-wide v2, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$39;->val$downloadDuration:J

    iget-wide v4, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$39;->val$fragmentDuration:J

    iget-wide v6, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$39;->val$fragmentSize:J

    iget-object v8, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$39;->val$url:Ljava/lang/String;

    invoke-virtual/range {v1 .. v8}, Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;->fragmentWarning(JJJLjava/lang/String;)V

    goto :goto_0

    .line 585
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v1    # "listener":Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;
    :catchall_0
    move-exception v2

    monitor-exit v9
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v2

    .restart local v0    # "i$":Ljava/util/Iterator;
    :cond_0
    :try_start_1
    monitor-exit v9
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 586
    return-void
.end method
