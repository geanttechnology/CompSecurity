.class abstract Lcom/localytics/android/BaseHandler$ListenersSet;
.super Ljava/util/HashSet;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/util/HashSet",
        "<",
        "Lcom/localytics/android/BaseHandler$BaseListener;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/localytics/android/BaseHandler;


# direct methods
.method constructor <init>(Lcom/localytics/android/BaseHandler;)V
    .locals 0

    .prologue
    .line 257
    iput-object p1, p0, Lcom/localytics/android/BaseHandler$ListenersSet;->this$0:Lcom/localytics/android/BaseHandler;

    invoke-direct {p0}, Ljava/util/HashSet;-><init>()V

    return-void
.end method


# virtual methods
.method declared-synchronized callListeners(Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "[",
            "Ljava/lang/Class",
            "<*>;[",
            "Ljava/lang/Object;",
            ")V"
        }
    .end annotation

    .prologue
    .line 261
    monitor-enter p0

    :try_start_0
    iget-object v1, p0, Lcom/localytics/android/BaseHandler$ListenersSet;->this$0:Lcom/localytics/android/BaseHandler;

    monitor-enter v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 263
    :try_start_1
    iget-object v0, p0, Lcom/localytics/android/BaseHandler$ListenersSet;->this$0:Lcom/localytics/android/BaseHandler;

    const/4 v2, 0x1

    # setter for: Lcom/localytics/android/BaseHandler;->queuePriorityMessages:Z
    invoke-static {v0, v2}, Lcom/localytics/android/BaseHandler;->access$102(Lcom/localytics/android/BaseHandler;Z)Z

    .line 264
    invoke-virtual {p0}, Lcom/localytics/android/BaseHandler$ListenersSet;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object v2

    .line 268
    :try_start_2
    invoke-static {v2, p1, p2, p3}, Lcom/localytics/android/ReflectionUtils;->tryInvokeInstance(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_0

    .line 273
    :catch_0
    move-exception v2

    goto :goto_0

    .line 274
    :cond_0
    :try_start_3
    iget-object v0, p0, Lcom/localytics/android/BaseHandler$ListenersSet;->this$0:Lcom/localytics/android/BaseHandler;

    const/4 v2, 0x0

    # setter for: Lcom/localytics/android/BaseHandler;->queuePriorityMessages:Z
    invoke-static {v0, v2}, Lcom/localytics/android/BaseHandler;->access$102(Lcom/localytics/android/BaseHandler;Z)Z

    .line 275
    monitor-exit v1
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    monitor-exit p0

    return-void

    :catchall_0
    move-exception v0

    :try_start_4
    monitor-exit v1
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    :try_start_5
    throw v0
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    .line 261
    :catchall_1
    move-exception v0

    monitor-exit p0

    throw v0
.end method
