.class public Lcom/comcast/cim/cmasl/taskexecutor/policy/MinimumIntervalRevalidationPolicy;
.super Ljava/lang/Object;
.source "MinimumIntervalRevalidationPolicy.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy",
        "<",
        "Ljava/lang/Integer;",
        ">;"
    }
.end annotation


# instance fields
.field private currentVersion:I

.field private final lock:Ljava/lang/Object;

.field private final minIntervalInMillis:J

.field private timeOfLastVersionChange:J


# direct methods
.method public constructor <init>(J)V
    .locals 1
    .param p1, "minIntervalInMillis"    # J

    .prologue
    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 8
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/cmasl/taskexecutor/policy/MinimumIntervalRevalidationPolicy;->lock:Ljava/lang/Object;

    .line 9
    const/4 v0, -0x1

    iput v0, p0, Lcom/comcast/cim/cmasl/taskexecutor/policy/MinimumIntervalRevalidationPolicy;->currentVersion:I

    .line 13
    iput-wide p1, p0, Lcom/comcast/cim/cmasl/taskexecutor/policy/MinimumIntervalRevalidationPolicy;->minIntervalInMillis:J

    .line 14
    return-void
.end method


# virtual methods
.method public getCurrentVersion()Ljava/lang/Integer;
    .locals 8

    .prologue
    .line 18
    iget-object v3, p0, Lcom/comcast/cim/cmasl/taskexecutor/policy/MinimumIntervalRevalidationPolicy;->lock:Ljava/lang/Object;

    monitor-enter v3

    .line 19
    :try_start_0
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    .line 20
    .local v0, "currentTime":J
    iget-wide v4, p0, Lcom/comcast/cim/cmasl/taskexecutor/policy/MinimumIntervalRevalidationPolicy;->timeOfLastVersionChange:J

    sub-long v4, v0, v4

    iget-wide v6, p0, Lcom/comcast/cim/cmasl/taskexecutor/policy/MinimumIntervalRevalidationPolicy;->minIntervalInMillis:J

    cmp-long v2, v4, v6

    if-lez v2, :cond_0

    .line 21
    iget v2, p0, Lcom/comcast/cim/cmasl/taskexecutor/policy/MinimumIntervalRevalidationPolicy;->currentVersion:I

    add-int/lit8 v2, v2, 0x1

    iput v2, p0, Lcom/comcast/cim/cmasl/taskexecutor/policy/MinimumIntervalRevalidationPolicy;->currentVersion:I

    .line 22
    iput-wide v0, p0, Lcom/comcast/cim/cmasl/taskexecutor/policy/MinimumIntervalRevalidationPolicy;->timeOfLastVersionChange:J

    .line 24
    :cond_0
    iget v2, p0, Lcom/comcast/cim/cmasl/taskexecutor/policy/MinimumIntervalRevalidationPolicy;->currentVersion:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    monitor-exit v3

    return-object v2

    .line 25
    .end local v0    # "currentTime":J
    :catchall_0
    move-exception v2

    monitor-exit v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v2
.end method

.method public bridge synthetic getCurrentVersion()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 5
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/taskexecutor/policy/MinimumIntervalRevalidationPolicy;->getCurrentVersion()Ljava/lang/Integer;

    move-result-object v0

    return-object v0
.end method

.method public shouldFallBackToLastCached(Ljava/lang/Integer;)Z
    .locals 1
    .param p1, "version"    # Ljava/lang/Integer;

    .prologue
    .line 35
    const/4 v0, 0x1

    return v0
.end method

.method public bridge synthetic shouldFallBackToLastCached(Ljava/lang/Object;)Z
    .locals 1
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 5
    check-cast p1, Ljava/lang/Integer;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/comcast/cim/cmasl/taskexecutor/policy/MinimumIntervalRevalidationPolicy;->shouldFallBackToLastCached(Ljava/lang/Integer;)Z

    move-result v0

    return v0
.end method

.method public shouldRevalidate(Ljava/lang/Integer;)Z
    .locals 2
    .param p1, "version"    # Ljava/lang/Integer;

    .prologue
    .line 30
    if-eqz p1, :cond_0

    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/taskexecutor/policy/MinimumIntervalRevalidationPolicy;->getCurrentVersion()Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    invoke-virtual {p1}, Ljava/lang/Integer;->intValue()I

    move-result v1

    if-le v0, v1, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public bridge synthetic shouldRevalidate(Ljava/lang/Object;)Z
    .locals 1
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 5
    check-cast p1, Ljava/lang/Integer;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/comcast/cim/cmasl/taskexecutor/policy/MinimumIntervalRevalidationPolicy;->shouldRevalidate(Ljava/lang/Integer;)Z

    move-result v0

    return v0
.end method

.method public toString()Ljava/lang/String;
    .locals 4

    .prologue
    .line 40
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "timeOfLastVersionChange: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    new-instance v1, Ljava/util/Date;

    iget-wide v2, p0, Lcom/comcast/cim/cmasl/taskexecutor/policy/MinimumIntervalRevalidationPolicy;->timeOfLastVersionChange:J

    invoke-direct {v1, v2, v3}, Ljava/util/Date;-><init>(J)V

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", currentVersion: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Lcom/comcast/cim/cmasl/taskexecutor/policy/MinimumIntervalRevalidationPolicy;->currentVersion:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
