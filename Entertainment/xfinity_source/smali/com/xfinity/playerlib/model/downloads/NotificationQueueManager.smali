.class public Lcom/xfinity/playerlib/model/downloads/NotificationQueueManager;
.super Ljava/lang/Object;
.source "NotificationQueueManager.java"


# instance fields
.field private final adultNotificationQueue:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Integer;",
            ">;>;"
        }
    .end annotation
.end field

.field private final context:Landroid/content/Context;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 14
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/model/downloads/NotificationQueueManager;->adultNotificationQueue:Ljava/util/List;

    .line 17
    iput-object p1, p0, Lcom/xfinity/playerlib/model/downloads/NotificationQueueManager;->context:Landroid/content/Context;

    .line 18
    return-void
.end method


# virtual methods
.method public cancelAdultDownloadNotifications()V
    .locals 6

    .prologue
    .line 27
    iget-object v3, p0, Lcom/xfinity/playerlib/model/downloads/NotificationQueueManager;->context:Landroid/content/Context;

    const-string v4, "notification"

    invoke-virtual {v3, v4}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/app/NotificationManager;

    .line 28
    .local v1, "manager":Landroid/app/NotificationManager;
    iget-object v5, p0, Lcom/xfinity/playerlib/model/downloads/NotificationQueueManager;->adultNotificationQueue:Ljava/util/List;

    monitor-enter v5

    .line 29
    :try_start_0
    iget-object v3, p0, Lcom/xfinity/playerlib/model/downloads/NotificationQueueManager;->adultNotificationQueue:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .line 30
    .local v0, "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/comcast/cim/cmasl/utils/container/Tuple<Ljava/lang/String;Ljava/lang/Integer;>;>;"
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 31
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/comcast/cim/cmasl/utils/container/Tuple;

    .line 32
    .local v2, "notificationInfo":Lcom/comcast/cim/cmasl/utils/container/Tuple;, "Lcom/comcast/cim/cmasl/utils/container/Tuple<Ljava/lang/String;Ljava/lang/Integer;>;"
    iget-object v3, v2, Lcom/comcast/cim/cmasl/utils/container/Tuple;->e1:Ljava/lang/Object;

    check-cast v3, Ljava/lang/String;

    iget-object v4, v2, Lcom/comcast/cim/cmasl/utils/container/Tuple;->e2:Ljava/lang/Object;

    check-cast v4, Ljava/lang/Integer;

    invoke-virtual {v4}, Ljava/lang/Integer;->intValue()I

    move-result v4

    invoke-virtual {v1, v3, v4}, Landroid/app/NotificationManager;->cancel(Ljava/lang/String;I)V

    .line 33
    invoke-interface {v0}, Ljava/util/Iterator;->remove()V

    goto :goto_0

    .line 35
    .end local v0    # "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/comcast/cim/cmasl/utils/container/Tuple<Ljava/lang/String;Ljava/lang/Integer;>;>;"
    .end local v2    # "notificationInfo":Lcom/comcast/cim/cmasl/utils/container/Tuple;, "Lcom/comcast/cim/cmasl/utils/container/Tuple<Ljava/lang/String;Ljava/lang/Integer;>;"
    :catchall_0
    move-exception v3

    monitor-exit v5
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v3

    .restart local v0    # "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/comcast/cim/cmasl/utils/container/Tuple<Ljava/lang/String;Ljava/lang/Integer;>;>;"
    :cond_0
    :try_start_1
    monitor-exit v5
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 36
    return-void
.end method

.method public registerAdultDownloadNotification(Ljava/lang/String;I)Z
    .locals 4
    .param p1, "notificationTag"    # Ljava/lang/String;
    .param p2, "notificationId"    # I

    .prologue
    .line 21
    iget-object v1, p0, Lcom/xfinity/playerlib/model/downloads/NotificationQueueManager;->adultNotificationQueue:Ljava/util/List;

    monitor-enter v1

    .line 22
    :try_start_0
    iget-object v0, p0, Lcom/xfinity/playerlib/model/downloads/NotificationQueueManager;->adultNotificationQueue:Ljava/util/List;

    new-instance v2, Lcom/comcast/cim/cmasl/utils/container/Tuple;

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-direct {v2, p1, v3}, Lcom/comcast/cim/cmasl/utils/container/Tuple;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    invoke-interface {v0, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    move-result v0

    monitor-exit v1

    return v0

    .line 23
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method
