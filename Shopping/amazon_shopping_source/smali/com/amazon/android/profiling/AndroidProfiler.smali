.class public Lcom/amazon/android/profiling/AndroidProfiler;
.super Ljava/lang/Object;
.source "AndroidProfiler.java"

# interfaces
.implements Lcom/amazon/profiling/ProfilerImplementation;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/android/profiling/AndroidProfiler$1;,
        Lcom/amazon/android/profiling/AndroidProfiler$ThreadLocalStack;
    }
.end annotation


# static fields
.field private static final LOG:Lcom/amazon/logging/Logger;


# instance fields
.field private final methodScopeStack:Lcom/amazon/android/profiling/AndroidProfiler$ThreadLocalStack;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/amazon/android/profiling/AndroidProfiler$ThreadLocalStack",
            "<",
            "Lcom/amazon/android/profiling/AndroidProfilerScope;",
            ">;"
        }
    .end annotation
.end field

.field private final start:J


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 18
    const-class v0, Lcom/amazon/android/profiling/AndroidProfiler;

    invoke-static {v0}, Lcom/amazon/logging/Logger;->getLogger(Ljava/lang/Class;)Lcom/amazon/logging/Logger;

    move-result-object v0

    sput-object v0, Lcom/amazon/android/profiling/AndroidProfiler;->LOG:Lcom/amazon/logging/Logger;

    return-void
.end method

.method public constructor <init>()V
    .locals 2

    .prologue
    .line 29
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 30
    sget-object v0, Lcom/amazon/android/profiling/AndroidProfiler;->LOG:Lcom/amazon/logging/Logger;

    const-string/jumbo v1, "Creating AndroidProfiler"

    invoke-virtual {v0, v1}, Lcom/amazon/logging/Logger;->i(Ljava/lang/String;)V

    .line 32
    new-instance v0, Lcom/amazon/android/profiling/AndroidProfiler$ThreadLocalStack;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lcom/amazon/android/profiling/AndroidProfiler$ThreadLocalStack;-><init>(Lcom/amazon/android/profiling/AndroidProfiler$1;)V

    iput-object v0, p0, Lcom/amazon/android/profiling/AndroidProfiler;->methodScopeStack:Lcom/amazon/android/profiling/AndroidProfiler$ThreadLocalStack;

    .line 33
    invoke-static {}, Ljava/lang/System;->nanoTime()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/amazon/android/profiling/AndroidProfiler;->start:J

    .line 34
    return-void
.end method


# virtual methods
.method public closeScope(Lcom/amazon/profiling/ProfilerScope;)V
    .locals 24
    .param p1, "scope"    # Lcom/amazon/profiling/ProfilerScope;

    .prologue
    .line 67
    move-object/from16 v0, p1

    instance-of v0, v0, Lcom/amazon/android/profiling/AndroidProfilerScope;

    move/from16 v19, v0

    if-eqz v19, :cond_0

    move-object/from16 v2, p1

    .line 68
    check-cast v2, Lcom/amazon/android/profiling/AndroidProfilerScope;

    .line 69
    .local v2, "androidScope":Lcom/amazon/android/profiling/AndroidProfilerScope;
    invoke-static {}, Ljava/lang/System;->nanoTime()J

    move-result-wide v9

    .line 70
    .local v9, "now":J
    iget-wide v0, v2, Lcom/amazon/android/profiling/AndroidProfilerScope;->start:J

    move-wide/from16 v19, v0

    move-object/from16 v0, p0

    iget-wide v0, v0, Lcom/amazon/android/profiling/AndroidProfiler;->start:J

    move-wide/from16 v21, v0

    sub-long v12, v19, v21

    .line 71
    .local v12, "startDelta":J
    const-wide/32 v19, 0xf4240

    div-long v16, v12, v19

    .line 72
    .local v16, "startMillis":J
    const-wide/32 v19, 0xf4240

    mul-long v19, v19, v16

    sub-long v14, v12, v19

    .line 73
    .local v14, "startLtMillis":J
    iget-wide v0, v2, Lcom/amazon/android/profiling/AndroidProfilerScope;->start:J

    move-wide/from16 v19, v0

    sub-long v3, v9, v19

    .line 74
    .local v3, "delta":J
    const-wide/32 v19, 0xf4240

    div-long v7, v3, v19

    .line 75
    .local v7, "millis":J
    const-wide/32 v19, 0xf4240

    mul-long v19, v19, v7

    sub-long v5, v3, v19

    .line 79
    .local v5, "ltMillis":J
    sget-object v20, Lcom/amazon/android/profiling/AndroidProfiler;->LOG:Lcom/amazon/logging/Logger;

    const-string/jumbo v21, "%s: %d> %s, [%d.%d ms] %d.%d ms"

    const/16 v19, 0x7

    move/from16 v0, v19

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v22, v0

    const/16 v19, 0x0

    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v23

    aput-object v23, v22, v19

    const/16 v23, 0x1

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/android/profiling/AndroidProfiler;->methodScopeStack:Lcom/amazon/android/profiling/AndroidProfiler$ThreadLocalStack;

    move-object/from16 v19, v0

    invoke-virtual/range {v19 .. v19}, Lcom/amazon/android/profiling/AndroidProfiler$ThreadLocalStack;->get()Ljava/lang/Object;

    move-result-object v19

    check-cast v19, Ljava/util/Stack;

    invoke-virtual/range {v19 .. v19}, Ljava/util/Stack;->size()I

    move-result v19

    invoke-static/range {v19 .. v19}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v19

    aput-object v19, v22, v23

    const/16 v19, 0x2

    iget-object v0, v2, Lcom/amazon/android/profiling/AndroidProfilerScope;->name:Ljava/lang/String;

    move-object/from16 v23, v0

    aput-object v23, v22, v19

    const/16 v19, 0x3

    invoke-static/range {v16 .. v17}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v23

    aput-object v23, v22, v19

    const/16 v19, 0x4

    invoke-static {v14, v15}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v23

    aput-object v23, v22, v19

    const/16 v19, 0x5

    invoke-static {v7, v8}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v23

    aput-object v23, v22, v19

    const/16 v19, 0x6

    invoke-static {v5, v6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v23

    aput-object v23, v22, v19

    invoke-static/range {v21 .. v22}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v19

    move-object/from16 v0, v20

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Lcom/amazon/logging/Logger;->v(Ljava/lang/String;)V

    .line 87
    iget-boolean v0, v2, Lcom/amazon/android/profiling/AndroidProfilerScope;->method:Z

    move/from16 v19, v0

    if-eqz v19, :cond_0

    .line 88
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/android/profiling/AndroidProfiler;->methodScopeStack:Lcom/amazon/android/profiling/AndroidProfiler$ThreadLocalStack;

    move-object/from16 v19, v0

    invoke-virtual/range {v19 .. v19}, Lcom/amazon/android/profiling/AndroidProfiler$ThreadLocalStack;->get()Ljava/lang/Object;

    move-result-object v11

    check-cast v11, Ljava/util/Stack;

    .line 89
    .local v11, "stack":Ljava/util/Stack;, "Ljava/util/Stack<Lcom/amazon/android/profiling/AndroidProfilerScope;>;"
    const/16 v18, 0x0

    .line 90
    .local v18, "thisScope":Lcom/amazon/android/profiling/AndroidProfilerScope;
    :goto_0
    invoke-virtual {v11}, Ljava/util/Stack;->isEmpty()Z

    move-result v19

    if-nez v19, :cond_0

    move-object/from16 v0, v18

    if-eq v0, v2, :cond_0

    .line 91
    invoke-virtual {v11}, Ljava/util/Stack;->pop()Ljava/lang/Object;

    move-result-object v18

    .end local v18    # "thisScope":Lcom/amazon/android/profiling/AndroidProfilerScope;
    check-cast v18, Lcom/amazon/android/profiling/AndroidProfilerScope;

    .restart local v18    # "thisScope":Lcom/amazon/android/profiling/AndroidProfilerScope;
    goto :goto_0

    .line 95
    .end local v2    # "androidScope":Lcom/amazon/android/profiling/AndroidProfilerScope;
    .end local v3    # "delta":J
    .end local v5    # "ltMillis":J
    .end local v7    # "millis":J
    .end local v9    # "now":J
    .end local v11    # "stack":Ljava/util/Stack;, "Ljava/util/Stack<Lcom/amazon/android/profiling/AndroidProfilerScope;>;"
    .end local v12    # "startDelta":J
    .end local v14    # "startLtMillis":J
    .end local v16    # "startMillis":J
    .end local v18    # "thisScope":Lcom/amazon/android/profiling/AndroidProfilerScope;
    :cond_0
    return-void
.end method

.method public createMethodProfilerScope(Ljava/lang/Class;Ljava/lang/String;)Lcom/amazon/profiling/ProfilerScope;
    .locals 5
    .param p2, "scopeName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;",
            "Ljava/lang/String;",
            ")",
            "Lcom/amazon/profiling/ProfilerScope;"
        }
    .end annotation

    .prologue
    .line 39
    .local p1, "parent":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    new-instance v0, Lcom/amazon/android/profiling/AndroidProfilerScope;

    const/4 v1, 0x1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, "."

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {}, Ljava/lang/System;->nanoTime()J

    move-result-wide v3

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/amazon/android/profiling/AndroidProfilerScope;-><init>(ZLjava/lang/String;J)V

    .line 41
    .local v0, "methodScope":Lcom/amazon/android/profiling/AndroidProfilerScope;
    iget-object v1, p0, Lcom/amazon/android/profiling/AndroidProfiler;->methodScopeStack:Lcom/amazon/android/profiling/AndroidProfiler$ThreadLocalStack;

    invoke-virtual {v1}, Lcom/amazon/android/profiling/AndroidProfiler$ThreadLocalStack;->get()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/Stack;

    invoke-virtual {v1, v0}, Ljava/util/Stack;->push(Ljava/lang/Object;)Ljava/lang/Object;

    .line 42
    return-object v0
.end method

.method public createProfilerScope(Ljava/lang/String;)Lcom/amazon/profiling/ProfilerScope;
    .locals 8
    .param p1, "scopeName"    # Ljava/lang/String;

    .prologue
    .line 48
    iget-object v3, p0, Lcom/amazon/android/profiling/AndroidProfiler;->methodScopeStack:Lcom/amazon/android/profiling/AndroidProfiler$ThreadLocalStack;

    invoke-virtual {v3}, Lcom/amazon/android/profiling/AndroidProfiler$ThreadLocalStack;->get()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/Stack;

    .line 50
    .local v2, "stack":Ljava/util/Stack;, "Ljava/util/Stack<Lcom/amazon/android/profiling/AndroidProfilerScope;>;"
    invoke-virtual {v2}, Ljava/util/Stack;->isEmpty()Z

    move-result v3

    if-nez v3, :cond_0

    .line 51
    invoke-virtual {v2}, Ljava/util/Stack;->peek()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/android/profiling/AndroidProfilerScope;

    .line 56
    .local v0, "lastScope":Lcom/amazon/android/profiling/AndroidProfilerScope;
    :goto_0
    if-nez v0, :cond_1

    .line 57
    const-string/jumbo v1, ""

    .line 61
    .local v1, "methodName":Ljava/lang/String;
    :goto_1
    new-instance v3, Lcom/amazon/android/profiling/AndroidProfilerScope;

    const/4 v4, 0x0

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v5, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {}, Ljava/lang/System;->nanoTime()J

    move-result-wide v6

    invoke-direct {v3, v4, v5, v6, v7}, Lcom/amazon/android/profiling/AndroidProfilerScope;-><init>(ZLjava/lang/String;J)V

    return-object v3

    .line 53
    .end local v0    # "lastScope":Lcom/amazon/android/profiling/AndroidProfilerScope;
    .end local v1    # "methodName":Ljava/lang/String;
    :cond_0
    const/4 v0, 0x0

    .restart local v0    # "lastScope":Lcom/amazon/android/profiling/AndroidProfilerScope;
    goto :goto_0

    .line 59
    :cond_1
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v4, v0, Lcom/amazon/android/profiling/AndroidProfilerScope;->name:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string/jumbo v4, "/"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .restart local v1    # "methodName":Ljava/lang/String;
    goto :goto_1
.end method
