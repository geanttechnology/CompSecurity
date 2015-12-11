.class Lcom/comcast/playerplatform/util/android/ConfigurationManager$5;
.super Ljava/lang/Object;
.source "ConfigurationManager.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/playerplatform/util/android/ConfigurationManager;->requestFailed(Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/playerplatform/util/android/ConfigurationManager;

.field final synthetic val$response:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/comcast/playerplatform/util/android/ConfigurationManager;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 196
    iput-object p1, p0, Lcom/comcast/playerplatform/util/android/ConfigurationManager$5;->this$0:Lcom/comcast/playerplatform/util/android/ConfigurationManager;

    iput-object p2, p0, Lcom/comcast/playerplatform/util/android/ConfigurationManager$5;->val$response:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 199
    iget-object v2, p0, Lcom/comcast/playerplatform/util/android/ConfigurationManager$5;->this$0:Lcom/comcast/playerplatform/util/android/ConfigurationManager;

    # getter for: Lcom/comcast/playerplatform/util/android/ConfigurationManager;->listeners:Ljava/util/concurrent/CopyOnWriteArrayList;
    invoke-static {v2}, Lcom/comcast/playerplatform/util/android/ConfigurationManager;->access$100(Lcom/comcast/playerplatform/util/android/ConfigurationManager;)Ljava/util/concurrent/CopyOnWriteArrayList;

    move-result-object v3

    monitor-enter v3

    .line 200
    :try_start_0
    iget-object v2, p0, Lcom/comcast/playerplatform/util/android/ConfigurationManager$5;->this$0:Lcom/comcast/playerplatform/util/android/ConfigurationManager;

    # getter for: Lcom/comcast/playerplatform/util/android/ConfigurationManager;->listeners:Ljava/util/concurrent/CopyOnWriteArrayList;
    invoke-static {v2}, Lcom/comcast/playerplatform/util/android/ConfigurationManager;->access$100(Lcom/comcast/playerplatform/util/android/ConfigurationManager;)Ljava/util/concurrent/CopyOnWriteArrayList;

    move-result-object v2

    invoke-virtual {v2}, Ljava/util/concurrent/CopyOnWriteArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/comcast/playerplatform/util/android/IConfigurationEventListener;

    .line 201
    .local v1, "listener":Lcom/comcast/playerplatform/util/android/IConfigurationEventListener;
    iget-object v2, p0, Lcom/comcast/playerplatform/util/android/ConfigurationManager$5;->val$response:Ljava/lang/String;

    invoke-interface {v1, v2}, Lcom/comcast/playerplatform/util/android/IConfigurationEventListener;->configurationFailed(Ljava/lang/String;)V

    goto :goto_0

    .line 203
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v1    # "listener":Lcom/comcast/playerplatform/util/android/IConfigurationEventListener;
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

    .line 204
    return-void
.end method
