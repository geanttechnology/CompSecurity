.class public abstract Lcom/amazon/profiling/Profiler;
.super Ljava/lang/Object;
.source "Profiler.java"


# static fields
.field private static impl:Lcom/amazon/profiling/ProfilerImplementation;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 9
    sget-object v0, Lcom/amazon/profiling/NullProfilerImplementation;->INSTANCE:Lcom/amazon/profiling/NullProfilerImplementation;

    sput-object v0, Lcom/amazon/profiling/Profiler;->impl:Lcom/amazon/profiling/ProfilerImplementation;

    return-void
.end method

.method protected constructor <init>()V
    .locals 0

    .prologue
    .line 47
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static methodScopeStart(Ljava/lang/Class;Ljava/lang/String;)Lcom/amazon/profiling/ProfilerScope;
    .locals 1
    .param p1, "methodName"    # Ljava/lang/String;
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
    .line 26
    .local p0, "parent":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    sget-object v0, Lcom/amazon/profiling/Profiler;->impl:Lcom/amazon/profiling/ProfilerImplementation;

    invoke-interface {v0, p0, p1}, Lcom/amazon/profiling/ProfilerImplementation;->createMethodProfilerScope(Ljava/lang/Class;Ljava/lang/String;)Lcom/amazon/profiling/ProfilerScope;

    move-result-object v0

    return-object v0
.end method

.method public static scopeEnd(Lcom/amazon/profiling/ProfilerScope;)V
    .locals 1
    .param p0, "scope"    # Lcom/amazon/profiling/ProfilerScope;

    .prologue
    .line 43
    sget-object v0, Lcom/amazon/profiling/Profiler;->impl:Lcom/amazon/profiling/ProfilerImplementation;

    invoke-interface {v0, p0}, Lcom/amazon/profiling/ProfilerImplementation;->closeScope(Lcom/amazon/profiling/ProfilerScope;)V

    .line 44
    return-void
.end method

.method public static scopeStart(Ljava/lang/String;)Lcom/amazon/profiling/ProfilerScope;
    .locals 1
    .param p0, "scopeName"    # Ljava/lang/String;

    .prologue
    .line 35
    sget-object v0, Lcom/amazon/profiling/Profiler;->impl:Lcom/amazon/profiling/ProfilerImplementation;

    invoke-interface {v0, p0}, Lcom/amazon/profiling/ProfilerImplementation;->createProfilerScope(Ljava/lang/String;)Lcom/amazon/profiling/ProfilerScope;

    move-result-object v0

    return-object v0
.end method

.method public static setProfilerFactory(Lcom/amazon/profiling/ProfilerImplementation;)V
    .locals 0
    .param p0, "factory"    # Lcom/amazon/profiling/ProfilerImplementation;

    .prologue
    .line 16
    sput-object p0, Lcom/amazon/profiling/Profiler;->impl:Lcom/amazon/profiling/ProfilerImplementation;

    .line 17
    return-void
.end method
