.class public interface abstract Lcom/amazon/profiling/ProfilerImplementation;
.super Ljava/lang/Object;
.source "ProfilerImplementation.java"


# virtual methods
.method public abstract closeScope(Lcom/amazon/profiling/ProfilerScope;)V
.end method

.method public abstract createMethodProfilerScope(Ljava/lang/Class;Ljava/lang/String;)Lcom/amazon/profiling/ProfilerScope;
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
.end method

.method public abstract createProfilerScope(Ljava/lang/String;)Lcom/amazon/profiling/ProfilerScope;
.end method
