.class public Lcom/comcast/cim/cmasl/taskexecutor/policy/NeverValidPolicy;
.super Ljava/lang/Object;
.source "NeverValidPolicy.java"

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


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 3
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getCurrentVersion()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 6
    const/4 v0, 0x0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic getCurrentVersion()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 3
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/taskexecutor/policy/NeverValidPolicy;->getCurrentVersion()Ljava/lang/Integer;

    move-result-object v0

    return-object v0
.end method

.method public shouldFallBackToLastCached(Ljava/lang/Integer;)Z
    .locals 1
    .param p1, "version"    # Ljava/lang/Integer;

    .prologue
    .line 16
    const/4 v0, 0x0

    return v0
.end method

.method public bridge synthetic shouldFallBackToLastCached(Ljava/lang/Object;)Z
    .locals 1
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 3
    check-cast p1, Ljava/lang/Integer;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/comcast/cim/cmasl/taskexecutor/policy/NeverValidPolicy;->shouldFallBackToLastCached(Ljava/lang/Integer;)Z

    move-result v0

    return v0
.end method

.method public shouldRevalidate(Ljava/lang/Integer;)Z
    .locals 1
    .param p1, "version"    # Ljava/lang/Integer;

    .prologue
    .line 11
    const/4 v0, 0x1

    return v0
.end method

.method public bridge synthetic shouldRevalidate(Ljava/lang/Object;)Z
    .locals 1
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 3
    check-cast p1, Ljava/lang/Integer;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/comcast/cim/cmasl/taskexecutor/policy/NeverValidPolicy;->shouldRevalidate(Ljava/lang/Integer;)Z

    move-result v0

    return v0
.end method
