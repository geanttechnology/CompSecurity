.class Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$1;
.super Ljava/lang/Object;
.source "PlayerEventManager.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;->bitrateChanged(JLjava/lang/String;JJ)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

.field final synthetic val$bitrate:J

.field final synthetic val$changeReason:Ljava/lang/String;

.field final synthetic val$videoHeight:J

.field final synthetic val$videoWidth:J


# direct methods
.method constructor <init>(Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;JLjava/lang/String;JJ)V
    .locals 1

    .prologue
    .line 45
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$1;->this$0:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    iput-wide p2, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$1;->val$bitrate:J

    iput-object p4, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$1;->val$changeReason:Ljava/lang/String;

    iput-wide p5, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$1;->val$videoHeight:J

    iput-wide p7, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$1;->val$videoWidth:J

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 10

    .prologue
    .line 48
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$1;->this$0:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    iget-object v9, v1, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;->listeners:Ljava/util/List;

    monitor-enter v9

    .line 49
    :try_start_0
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$1;->this$0:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    iget-object v1, v1, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;->listeners:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v8

    .local v8, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v8}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-interface {v8}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;

    .line 50
    .local v0, "listener":Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;
    iget-wide v1, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$1;->val$bitrate:J

    iget-object v3, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$1;->val$changeReason:Ljava/lang/String;

    iget-wide v4, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$1;->val$videoHeight:J

    iget-wide v6, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$1;->val$videoWidth:J

    invoke-virtual/range {v0 .. v7}, Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;->bitrateChanged(JLjava/lang/String;JJ)V

    goto :goto_0

    .line 52
    .end local v0    # "listener":Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;
    .end local v8    # "i$":Ljava/util/Iterator;
    :catchall_0
    move-exception v1

    monitor-exit v9
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1

    .restart local v8    # "i$":Ljava/util/Iterator;
    :cond_0
    :try_start_1
    monitor-exit v9
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 53
    return-void
.end method
