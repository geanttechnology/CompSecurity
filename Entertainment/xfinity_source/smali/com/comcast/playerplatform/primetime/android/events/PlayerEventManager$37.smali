.class Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$37;
.super Ljava/lang/Object;
.source "PlayerEventManager.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;->retryAttempted(Ljava/lang/String;Ljava/lang/String;I)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

.field final synthetic val$code:Ljava/lang/String;

.field final synthetic val$description:Ljava/lang/String;

.field final synthetic val$retryCount:I


# direct methods
.method constructor <init>(Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;Ljava/lang/String;Ljava/lang/String;I)V
    .locals 0

    .prologue
    .line 550
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$37;->this$0:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    iput-object p2, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$37;->val$code:Ljava/lang/String;

    iput-object p3, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$37;->val$description:Ljava/lang/String;

    iput p4, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$37;->val$retryCount:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 6

    .prologue
    .line 553
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$37;->this$0:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    iget-object v3, v2, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;->listeners:Ljava/util/List;

    monitor-enter v3

    .line 554
    :try_start_0
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$37;->this$0:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

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

    .line 555
    .local v1, "listener":Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$37;->val$code:Ljava/lang/String;

    iget-object v4, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$37;->val$description:Ljava/lang/String;

    iget v5, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$37;->val$retryCount:I

    invoke-virtual {v1, v2, v4, v5}, Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;->retryAttempted(Ljava/lang/String;Ljava/lang/String;I)V

    goto :goto_0

    .line 557
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

    .line 558
    return-void
.end method
