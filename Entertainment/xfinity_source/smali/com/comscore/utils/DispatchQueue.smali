.class public Lcom/comscore/utils/DispatchQueue;
.super Ljava/util/concurrent/ConcurrentLinkedQueue;


# annotations
.annotation runtime Ljava/lang/Deprecated;
.end annotation


# instance fields
.field private b:Lcom/comscore/analytics/Core;


# direct methods
.method public constructor <init>(Lcom/comscore/analytics/Core;)V
    .locals 0

    invoke-direct {p0}, Ljava/util/concurrent/ConcurrentLinkedQueue;-><init>()V

    iput-object p1, p0, Lcom/comscore/utils/DispatchQueue;->b:Lcom/comscore/analytics/Core;

    return-void
.end method


# virtual methods
.method public bridge synthetic offer(Ljava/lang/Object;)Z
    .locals 1

    check-cast p1, Ljava/lang/Runnable;

    invoke-virtual {p0, p1}, Lcom/comscore/utils/DispatchQueue;->offer(Ljava/lang/Runnable;)Z

    move-result v0

    return v0
.end method

.method public offer(Ljava/lang/Runnable;)Z
    .locals 2
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    iget-object v0, p0, Lcom/comscore/utils/DispatchQueue;->b:Lcom/comscore/analytics/Core;

    invoke-virtual {v0}, Lcom/comscore/analytics/Core;->getTaskExecutor()Lcom/comscore/utils/task/TaskExecutor;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, p1, v1}, Lcom/comscore/utils/task/TaskExecutor;->execute(Ljava/lang/Runnable;Z)Z

    move-result v0

    return v0
.end method
