.class public Lcom/comcast/cim/model/provider/CompositeRevalidationPolicy;
.super Ljava/lang/Object;
.source "CompositeRevalidationPolicy.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<X:",
        "Ljava/lang/Object;",
        "Y:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy",
        "<",
        "Lcom/comcast/cim/cmasl/utils/container/Tuple",
        "<TX;TY;>;>;"
    }
.end annotation


# instance fields
.field private final xPolicy:Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy",
            "<TX;>;"
        }
    .end annotation
.end field

.field private final yPolicy:Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy",
            "<TY;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy",
            "<TX;>;",
            "Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy",
            "<TY;>;)V"
        }
    .end annotation

    .prologue
    .line 14
    .local p0, "this":Lcom/comcast/cim/model/provider/CompositeRevalidationPolicy;, "Lcom/comcast/cim/model/provider/CompositeRevalidationPolicy<TX;TY;>;"
    .local p1, "xPolicy":Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;, "Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy<TX;>;"
    .local p2, "yPolicy":Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;, "Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy<TY;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 15
    iput-object p1, p0, Lcom/comcast/cim/model/provider/CompositeRevalidationPolicy;->xPolicy:Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;

    .line 16
    iput-object p2, p0, Lcom/comcast/cim/model/provider/CompositeRevalidationPolicy;->yPolicy:Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;

    .line 17
    return-void
.end method

.method private getNullSafeVersion(Lcom/comcast/cim/cmasl/utils/container/Tuple;)Lcom/comcast/cim/cmasl/utils/container/Tuple;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple",
            "<TX;TY;>;)",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple",
            "<TX;TY;>;"
        }
    .end annotation

    .prologue
    .local p0, "this":Lcom/comcast/cim/model/provider/CompositeRevalidationPolicy;, "Lcom/comcast/cim/model/provider/CompositeRevalidationPolicy<TX;TY;>;"
    .local p1, "version":Lcom/comcast/cim/cmasl/utils/container/Tuple;, "Lcom/comcast/cim/cmasl/utils/container/Tuple<TX;TY;>;"
    const/4 v0, 0x0

    .line 42
    if-nez p1, :cond_0

    .line 43
    new-instance p1, Lcom/comcast/cim/cmasl/utils/container/Tuple;

    .end local p1    # "version":Lcom/comcast/cim/cmasl/utils/container/Tuple;, "Lcom/comcast/cim/cmasl/utils/container/Tuple<TX;TY;>;"
    invoke-direct {p1, v0, v0}, Lcom/comcast/cim/cmasl/utils/container/Tuple;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 45
    .restart local p1    # "version":Lcom/comcast/cim/cmasl/utils/container/Tuple;, "Lcom/comcast/cim/cmasl/utils/container/Tuple<TX;TY;>;"
    :cond_0
    return-object p1
.end method


# virtual methods
.method public getCurrentVersion()Lcom/comcast/cim/cmasl/utils/container/Tuple;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple",
            "<TX;TY;>;"
        }
    .end annotation

    .prologue
    .line 21
    .local p0, "this":Lcom/comcast/cim/model/provider/CompositeRevalidationPolicy;, "Lcom/comcast/cim/model/provider/CompositeRevalidationPolicy<TX;TY;>;"
    new-instance v0, Lcom/comcast/cim/cmasl/utils/container/Tuple;

    iget-object v1, p0, Lcom/comcast/cim/model/provider/CompositeRevalidationPolicy;->xPolicy:Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;

    invoke-interface {v1}, Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;->getCurrentVersion()Ljava/lang/Object;

    move-result-object v1

    iget-object v2, p0, Lcom/comcast/cim/model/provider/CompositeRevalidationPolicy;->yPolicy:Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;

    invoke-interface {v2}, Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;->getCurrentVersion()Ljava/lang/Object;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lcom/comcast/cim/cmasl/utils/container/Tuple;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    return-object v0
.end method

.method public bridge synthetic getCurrentVersion()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 9
    .local p0, "this":Lcom/comcast/cim/model/provider/CompositeRevalidationPolicy;, "Lcom/comcast/cim/model/provider/CompositeRevalidationPolicy<TX;TY;>;"
    invoke-virtual {p0}, Lcom/comcast/cim/model/provider/CompositeRevalidationPolicy;->getCurrentVersion()Lcom/comcast/cim/cmasl/utils/container/Tuple;

    move-result-object v0

    return-object v0
.end method

.method public shouldFallBackToLastCached(Lcom/comcast/cim/cmasl/utils/container/Tuple;)Z
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple",
            "<TX;TY;>;)Z"
        }
    .end annotation

    .prologue
    .line 32
    .local p0, "this":Lcom/comcast/cim/model/provider/CompositeRevalidationPolicy;, "Lcom/comcast/cim/model/provider/CompositeRevalidationPolicy<TX;TY;>;"
    .local p1, "version":Lcom/comcast/cim/cmasl/utils/container/Tuple;, "Lcom/comcast/cim/cmasl/utils/container/Tuple<TX;TY;>;"
    invoke-direct {p0, p1}, Lcom/comcast/cim/model/provider/CompositeRevalidationPolicy;->getNullSafeVersion(Lcom/comcast/cim/cmasl/utils/container/Tuple;)Lcom/comcast/cim/cmasl/utils/container/Tuple;

    move-result-object p1

    .line 33
    iget-object v0, p0, Lcom/comcast/cim/model/provider/CompositeRevalidationPolicy;->xPolicy:Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;

    iget-object v1, p1, Lcom/comcast/cim/cmasl/utils/container/Tuple;->e1:Ljava/lang/Object;

    invoke-interface {v0, v1}, Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;->shouldFallBackToLastCached(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/comcast/cim/model/provider/CompositeRevalidationPolicy;->yPolicy:Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;

    iget-object v1, p1, Lcom/comcast/cim/cmasl/utils/container/Tuple;->e2:Ljava/lang/Object;

    invoke-interface {v0, v1}, Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;->shouldFallBackToLastCached(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public bridge synthetic shouldFallBackToLastCached(Ljava/lang/Object;)Z
    .locals 1

    .prologue
    .line 9
    .local p0, "this":Lcom/comcast/cim/model/provider/CompositeRevalidationPolicy;, "Lcom/comcast/cim/model/provider/CompositeRevalidationPolicy<TX;TY;>;"
    check-cast p1, Lcom/comcast/cim/cmasl/utils/container/Tuple;

    invoke-virtual {p0, p1}, Lcom/comcast/cim/model/provider/CompositeRevalidationPolicy;->shouldFallBackToLastCached(Lcom/comcast/cim/cmasl/utils/container/Tuple;)Z

    move-result v0

    return v0
.end method

.method public shouldRevalidate(Lcom/comcast/cim/cmasl/utils/container/Tuple;)Z
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple",
            "<TX;TY;>;)Z"
        }
    .end annotation

    .prologue
    .line 26
    .local p0, "this":Lcom/comcast/cim/model/provider/CompositeRevalidationPolicy;, "Lcom/comcast/cim/model/provider/CompositeRevalidationPolicy<TX;TY;>;"
    .local p1, "version":Lcom/comcast/cim/cmasl/utils/container/Tuple;, "Lcom/comcast/cim/cmasl/utils/container/Tuple<TX;TY;>;"
    invoke-direct {p0, p1}, Lcom/comcast/cim/model/provider/CompositeRevalidationPolicy;->getNullSafeVersion(Lcom/comcast/cim/cmasl/utils/container/Tuple;)Lcom/comcast/cim/cmasl/utils/container/Tuple;

    move-result-object p1

    .line 27
    iget-object v0, p0, Lcom/comcast/cim/model/provider/CompositeRevalidationPolicy;->xPolicy:Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;

    iget-object v1, p1, Lcom/comcast/cim/cmasl/utils/container/Tuple;->e1:Ljava/lang/Object;

    invoke-interface {v0, v1}, Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;->shouldRevalidate(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/comcast/cim/model/provider/CompositeRevalidationPolicy;->yPolicy:Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;

    iget-object v1, p1, Lcom/comcast/cim/cmasl/utils/container/Tuple;->e2:Ljava/lang/Object;

    invoke-interface {v0, v1}, Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;->shouldRevalidate(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

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

    .prologue
    .line 9
    .local p0, "this":Lcom/comcast/cim/model/provider/CompositeRevalidationPolicy;, "Lcom/comcast/cim/model/provider/CompositeRevalidationPolicy<TX;TY;>;"
    check-cast p1, Lcom/comcast/cim/cmasl/utils/container/Tuple;

    invoke-virtual {p0, p1}, Lcom/comcast/cim/model/provider/CompositeRevalidationPolicy;->shouldRevalidate(Lcom/comcast/cim/cmasl/utils/container/Tuple;)Z

    move-result v0

    return v0
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 38
    .local p0, "this":Lcom/comcast/cim/model/provider/CompositeRevalidationPolicy;, "Lcom/comcast/cim/model/provider/CompositeRevalidationPolicy<TX;TY;>;"
    new-instance v0, Lorg/apache/commons/lang3/builder/ToStringBuilder;

    sget-object v1, Lorg/apache/commons/lang3/builder/ToStringStyle;->SHORT_PREFIX_STYLE:Lorg/apache/commons/lang3/builder/ToStringStyle;

    invoke-direct {v0, p0, v1}, Lorg/apache/commons/lang3/builder/ToStringBuilder;-><init>(Ljava/lang/Object;Lorg/apache/commons/lang3/builder/ToStringStyle;)V

    iget-object v1, p0, Lcom/comcast/cim/model/provider/CompositeRevalidationPolicy;->xPolicy:Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;

    invoke-virtual {v0, v1}, Lorg/apache/commons/lang3/builder/ToStringBuilder;->append(Ljava/lang/Object;)Lorg/apache/commons/lang3/builder/ToStringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/comcast/cim/model/provider/CompositeRevalidationPolicy;->yPolicy:Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;

    invoke-virtual {v0, v1}, Lorg/apache/commons/lang3/builder/ToStringBuilder;->append(Ljava/lang/Object;)Lorg/apache/commons/lang3/builder/ToStringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Lorg/apache/commons/lang3/builder/ToStringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
