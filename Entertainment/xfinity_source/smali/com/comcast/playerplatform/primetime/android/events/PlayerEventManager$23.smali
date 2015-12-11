.class Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$23;
.super Ljava/lang/Object;
.source "PlayerEventManager.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;->drmComplete(Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

.field final synthetic val$asset:Ljava/lang/String;

.field final synthetic val$licenseEnd:Ljava/util/Date;

.field final synthetic val$licenseStart:Ljava/util/Date;


# direct methods
.method constructor <init>(Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;)V
    .locals 0

    .prologue
    .line 354
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$23;->this$0:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    iput-object p2, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$23;->val$asset:Ljava/lang/String;

    iput-object p3, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$23;->val$licenseStart:Ljava/util/Date;

    iput-object p4, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$23;->val$licenseEnd:Ljava/util/Date;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 6

    .prologue
    .line 357
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$23;->this$0:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    iget-object v3, v2, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;->listeners:Ljava/util/List;

    monitor-enter v3

    .line 358
    :try_start_0
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$23;->this$0:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

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

    .line 359
    .local v1, "listener":Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$23;->val$asset:Ljava/lang/String;

    iget-object v4, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$23;->val$licenseStart:Ljava/util/Date;

    iget-object v5, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$23;->val$licenseEnd:Ljava/util/Date;

    invoke-virtual {v1, v2, v4, v5}, Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;->drmComplete(Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;)V

    goto :goto_0

    .line 361
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

    .line 362
    return-void
.end method
