.class Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$20;
.super Ljava/lang/Object;
.source "PlayerEventManager.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;->offlineDRMComplete(Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;Ljava/lang/String;)V
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

.field final synthetic val$policyId:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 312
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$20;->this$0:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    iput-object p2, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$20;->val$asset:Ljava/lang/String;

    iput-object p3, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$20;->val$licenseStart:Ljava/util/Date;

    iput-object p4, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$20;->val$licenseEnd:Ljava/util/Date;

    iput-object p5, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$20;->val$policyId:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 7

    .prologue
    .line 315
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$20;->this$0:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    iget-object v3, v2, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;->listeners:Ljava/util/List;

    monitor-enter v3

    .line 316
    :try_start_0
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$20;->this$0:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

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

    .line 317
    .local v1, "listener":Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$20;->val$asset:Ljava/lang/String;

    iget-object v4, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$20;->val$licenseStart:Ljava/util/Date;

    iget-object v5, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$20;->val$licenseEnd:Ljava/util/Date;

    iget-object v6, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$20;->val$policyId:Ljava/lang/String;

    invoke-virtual {v1, v2, v4, v5, v6}, Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;->offlineDRMComplete(Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;Ljava/lang/String;)V

    goto :goto_0

    .line 319
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

    .line 320
    return-void
.end method
