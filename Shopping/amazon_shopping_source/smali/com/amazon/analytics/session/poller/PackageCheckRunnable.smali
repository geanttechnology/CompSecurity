.class public Lcom/amazon/analytics/session/poller/PackageCheckRunnable;
.super Ljava/lang/Object;
.source "PackageCheckRunnable.java"

# interfaces
.implements Ljava/lang/Runnable;


# static fields
.field private static logger:Lcom/amazon/device/analytics/log/Logger;


# instance fields
.field private final activityManager:Lcom/amazon/analytics/TailwindActivityManager;

.field private final context:Landroid/content/Context;

.field private final queue:Lcom/amazon/analytics/session/PriorityQueue;

.field private final sessionBuilder:Lcom/amazon/analytics/session/PackageSessionBuilder;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 27
    const-class v0, Lcom/amazon/analytics/session/poller/PackageCheckRunnable;

    invoke-static {v0}, Lcom/amazon/device/analytics/log/Logging;->getLogger(Ljava/lang/Class;)Lcom/amazon/device/analytics/log/Logger;

    move-result-object v0

    sput-object v0, Lcom/amazon/analytics/session/poller/PackageCheckRunnable;->logger:Lcom/amazon/device/analytics/log/Logger;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Lcom/amazon/analytics/TailwindActivityManager;Lcom/amazon/analytics/session/PriorityQueue;Lcom/amazon/analytics/session/PackageSessionBuilder;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "activityManager"    # Lcom/amazon/analytics/TailwindActivityManager;
    .param p3, "queue"    # Lcom/amazon/analytics/session/PriorityQueue;
    .param p4, "sessionBuilder"    # Lcom/amazon/analytics/session/PackageSessionBuilder;

    .prologue
    .line 38
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 39
    iput-object p1, p0, Lcom/amazon/analytics/session/poller/PackageCheckRunnable;->context:Landroid/content/Context;

    .line 40
    iput-object p2, p0, Lcom/amazon/analytics/session/poller/PackageCheckRunnable;->activityManager:Lcom/amazon/analytics/TailwindActivityManager;

    .line 41
    iput-object p3, p0, Lcom/amazon/analytics/session/poller/PackageCheckRunnable;->queue:Lcom/amazon/analytics/session/PriorityQueue;

    .line 42
    iput-object p4, p0, Lcom/amazon/analytics/session/poller/PackageCheckRunnable;->sessionBuilder:Lcom/amazon/analytics/session/PackageSessionBuilder;

    .line 43
    return-void
.end method

.method static runHelper(Landroid/content/Context;Lcom/amazon/analytics/TailwindActivityManager;Lcom/amazon/analytics/session/PriorityQueue;Lcom/amazon/analytics/session/PackageSessionBuilder;)V
    .locals 15
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "activityManager"    # Lcom/amazon/analytics/TailwindActivityManager;
    .param p2, "queue"    # Lcom/amazon/analytics/session/PriorityQueue;
    .param p3, "sessionBuilder"    # Lcom/amazon/analytics/session/PackageSessionBuilder;

    .prologue
    .line 51
    new-instance v10, Ljava/util/HashSet;

    invoke-direct {v10}, Ljava/util/HashSet;-><init>()V

    .line 52
    .local v10, "possibleStoppedSessionPackages":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    invoke-virtual/range {p3 .. p3}, Lcom/amazon/analytics/session/PackageSessionBuilder;->getRunningSessions()Ljava/util/Set;

    move-result-object v11

    invoke-interface {v11}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v11

    if-eqz v11, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lcom/amazon/analytics/session/PackageSession;

    .line 53
    .local v7, "pSession":Lcom/amazon/analytics/session/PackageSession;
    invoke-virtual {v7}, Lcom/amazon/analytics/session/PackageSession;->getPackageName()Ljava/lang/String;

    move-result-object v11

    invoke-interface {v10, v11}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 58
    .end local v7    # "pSession":Lcom/amazon/analytics/session/PackageSession;
    :cond_0
    invoke-interface/range {p1 .. p1}, Lcom/amazon/analytics/TailwindActivityManager;->getRunningAppProcesses()Ljava/util/List;

    move-result-object v11

    invoke-interface {v11}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .end local v3    # "i$":Ljava/util/Iterator;
    :cond_1
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v11

    if-eqz v11, :cond_3

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/app/ActivityManager$RunningAppProcessInfo;

    .line 59
    .local v2, "currInfo":Landroid/app/ActivityManager$RunningAppProcessInfo;
    iget v11, v2, Landroid/app/ActivityManager$RunningAppProcessInfo;->importance:I

    const/16 v12, 0x82

    if-eq v11, v12, :cond_2

    iget v11, v2, Landroid/app/ActivityManager$RunningAppProcessInfo;->importance:I

    const/16 v12, 0x64

    if-eq v11, v12, :cond_2

    iget v11, v2, Landroid/app/ActivityManager$RunningAppProcessInfo;->importance:I

    const/16 v12, 0xc8

    if-ne v11, v12, :cond_1

    .line 62
    :cond_2
    iget-object v1, v2, Landroid/app/ActivityManager$RunningAppProcessInfo;->pkgList:[Ljava/lang/String;

    .local v1, "arr$":[Ljava/lang/String;
    array-length v5, v1

    .local v5, "len$":I
    const/4 v4, 0x0

    .local v4, "i$":I
    :goto_1
    if-ge v4, v5, :cond_1

    aget-object v9, v1, v4

    .line 63
    .local v9, "pkgName":Ljava/lang/String;
    invoke-interface {v10, v9}, Ljava/util/Set;->remove(Ljava/lang/Object;)Z

    .line 62
    add-int/lit8 v4, v4, 0x1

    goto :goto_1

    .line 69
    .end local v1    # "arr$":[Ljava/lang/String;
    .end local v2    # "currInfo":Landroid/app/ActivityManager$RunningAppProcessInfo;
    .end local v4    # "i$":I
    .end local v5    # "len$":I
    .end local v9    # "pkgName":Ljava/lang/String;
    :cond_3
    invoke-interface {v10}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .restart local v3    # "i$":Ljava/util/Iterator;
    :goto_2
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v11

    if-eqz v11, :cond_4

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/lang/String;

    .line 70
    .local v8, "packageName":Ljava/lang/String;
    new-instance v6, Lcom/amazon/analytics/util/Message;

    invoke-direct {v6}, Lcom/amazon/analytics/util/Message;-><init>()V

    .line 71
    .local v6, "message":Lcom/amazon/analytics/util/Message;
    invoke-virtual {v6}, Lcom/amazon/analytics/util/Message;->getExtras()Ljava/util/Map;

    move-result-object v11

    const-string/jumbo v12, "PackageName"

    invoke-interface {v11, v12, v8}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 72
    invoke-virtual {v6}, Lcom/amazon/analytics/util/Message;->getExtras()Ljava/util/Map;

    move-result-object v11

    const-string/jumbo v12, "TimeStamp"

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v13

    invoke-static {v13, v14}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v13

    invoke-interface {v11, v12, v13}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 74
    invoke-virtual {v6}, Lcom/amazon/analytics/util/Message;->getExtras()Ljava/util/Map;

    move-result-object v11

    const-string/jumbo v12, "SessionFlag"

    const/4 v13, 0x1

    invoke-static {v13}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v13

    invoke-interface {v11, v12, v13}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 75
    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Lcom/amazon/analytics/session/PriorityQueue;->enqueue(Lcom/amazon/analytics/util/Message;)V

    .line 76
    sget-object v11, Lcom/amazon/analytics/session/poller/PackageCheckRunnable;->logger:Lcom/amazon/device/analytics/log/Logger;

    new-instance v12, Ljava/lang/StringBuilder;

    invoke-direct {v12}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v13, "Published session event with FLAG_RUN_STOP for package "

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v11, v12}, Lcom/amazon/device/analytics/log/Logger;->d(Ljava/lang/String;)V

    goto :goto_2

    .line 78
    .end local v6    # "message":Lcom/amazon/analytics/util/Message;
    .end local v8    # "packageName":Ljava/lang/String;
    :cond_4
    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 82
    iget-object v0, p0, Lcom/amazon/analytics/session/poller/PackageCheckRunnable;->context:Landroid/content/Context;

    iget-object v1, p0, Lcom/amazon/analytics/session/poller/PackageCheckRunnable;->activityManager:Lcom/amazon/analytics/TailwindActivityManager;

    iget-object v2, p0, Lcom/amazon/analytics/session/poller/PackageCheckRunnable;->queue:Lcom/amazon/analytics/session/PriorityQueue;

    iget-object v3, p0, Lcom/amazon/analytics/session/poller/PackageCheckRunnable;->sessionBuilder:Lcom/amazon/analytics/session/PackageSessionBuilder;

    invoke-static {v0, v1, v2, v3}, Lcom/amazon/analytics/session/poller/PackageCheckRunnable;->runHelper(Landroid/content/Context;Lcom/amazon/analytics/TailwindActivityManager;Lcom/amazon/analytics/session/PriorityQueue;Lcom/amazon/analytics/session/PackageSessionBuilder;)V

    .line 83
    return-void
.end method
