.class Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicIdGenerator;
.super Ljava/lang/Object;
.source "BasicIdGenerator.java"


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/ThreadSafe;
.end annotation


# instance fields
.field private count:J
    .annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/GuardedBy;
    .end annotation
.end field

.field private final hostname:Ljava/lang/String;

.field private final rnd:Ljava/security/SecureRandom;


# virtual methods
.method public declared-synchronized generate(Ljava/lang/StringBuilder;)V
    .locals 8
    .param p1, "buffer"    # Ljava/lang/StringBuilder;

    .prologue
    .line 69
    monitor-enter p0

    :try_start_0
    iget-wide v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicIdGenerator;->count:J

    const-wide/16 v4, 0x1

    add-long/2addr v2, v4

    iput-wide v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicIdGenerator;->count:J

    .line 70
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicIdGenerator;->rnd:Ljava/security/SecureRandom;

    invoke-virtual {v2}, Ljava/security/SecureRandom;->nextInt()I

    move-result v1

    .line 71
    .local v1, "rndnum":I
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    invoke-virtual {p1, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    .line 72
    const/16 v2, 0x2e

    invoke-virtual {p1, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 73
    new-instance v0, Ljava/util/Formatter;

    sget-object v2, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-direct {v0, p1, v2}, Ljava/util/Formatter;-><init>(Ljava/lang/Appendable;Ljava/util/Locale;)V

    .line 74
    .local v0, "formatter":Ljava/util/Formatter;
    const-string v2, "%1$016x-%2$08x"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    iget-wide v6, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicIdGenerator;->count:J

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-virtual {v0, v2, v3}, Ljava/util/Formatter;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/util/Formatter;

    .line 75
    const/16 v2, 0x2e

    invoke-virtual {p1, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 76
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicIdGenerator;->hostname:Ljava/lang/String;

    invoke-virtual {p1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 77
    monitor-exit p0

    return-void

    .line 69
    .end local v0    # "formatter":Ljava/util/Formatter;
    .end local v1    # "rndnum":I
    :catchall_0
    move-exception v2

    monitor-exit p0

    throw v2
.end method
