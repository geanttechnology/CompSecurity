.class public Lcom/comcast/cim/model/provider/UserChangeRevalidationPolicy;
.super Ljava/lang/Object;
.source "UserChangeRevalidationPolicy.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<U::",
        "Lcom/comcast/cim/model/user/User;",
        ">",
        "Ljava/lang/Object;",
        "Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy",
        "<TU;>;"
    }
.end annotation


# instance fields
.field private userManager:Lcom/comcast/cim/model/user/UserManager;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/model/user/UserManager",
            "<+TU;+",
            "Lcom/comcast/cim/model/user/service/UserSettings;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/comcast/cim/model/user/UserManager;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/model/user/UserManager",
            "<+TU;+",
            "Lcom/comcast/cim/model/user/service/UserSettings;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 13
    .local p0, "this":Lcom/comcast/cim/model/provider/UserChangeRevalidationPolicy;, "Lcom/comcast/cim/model/provider/UserChangeRevalidationPolicy<TU;>;"
    .local p1, "userManager":Lcom/comcast/cim/model/user/UserManager;, "Lcom/comcast/cim/model/user/UserManager<+TU;+Lcom/comcast/cim/model/user/service/UserSettings;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 14
    iput-object p1, p0, Lcom/comcast/cim/model/provider/UserChangeRevalidationPolicy;->userManager:Lcom/comcast/cim/model/user/UserManager;

    .line 15
    return-void
.end method


# virtual methods
.method public getCurrentVersion()Lcom/comcast/cim/model/user/User;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TU;"
        }
    .end annotation

    .prologue
    .line 19
    .local p0, "this":Lcom/comcast/cim/model/provider/UserChangeRevalidationPolicy;, "Lcom/comcast/cim/model/provider/UserChangeRevalidationPolicy<TU;>;"
    iget-object v1, p0, Lcom/comcast/cim/model/provider/UserChangeRevalidationPolicy;->userManager:Lcom/comcast/cim/model/user/UserManager;

    invoke-virtual {v1}, Lcom/comcast/cim/model/user/UserManager;->getUser()Lcom/comcast/cim/model/user/User;

    move-result-object v0

    .line 20
    .local v0, "user":Lcom/comcast/cim/model/user/User;, "TU;"
    if-nez v0, :cond_0

    .line 21
    const/4 v0, 0x0

    .line 23
    .end local v0    # "user":Lcom/comcast/cim/model/user/User;, "TU;"
    :cond_0
    return-object v0
.end method

.method public bridge synthetic getCurrentVersion()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 10
    .local p0, "this":Lcom/comcast/cim/model/provider/UserChangeRevalidationPolicy;, "Lcom/comcast/cim/model/provider/UserChangeRevalidationPolicy<TU;>;"
    invoke-virtual {p0}, Lcom/comcast/cim/model/provider/UserChangeRevalidationPolicy;->getCurrentVersion()Lcom/comcast/cim/model/user/User;

    move-result-object v0

    return-object v0
.end method

.method public shouldFallBackToLastCached(Lcom/comcast/cim/model/user/User;)Z
    .locals 1
    .param p1, "version"    # Lcom/comcast/cim/model/user/User;

    .prologue
    .line 33
    .local p0, "this":Lcom/comcast/cim/model/provider/UserChangeRevalidationPolicy;, "Lcom/comcast/cim/model/provider/UserChangeRevalidationPolicy<TU;>;"
    invoke-virtual {p0, p1}, Lcom/comcast/cim/model/provider/UserChangeRevalidationPolicy;->shouldRevalidate(Lcom/comcast/cim/model/user/User;)Z

    move-result v0

    if-nez v0, :cond_0

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
    .line 10
    .local p0, "this":Lcom/comcast/cim/model/provider/UserChangeRevalidationPolicy;, "Lcom/comcast/cim/model/provider/UserChangeRevalidationPolicy<TU;>;"
    check-cast p1, Lcom/comcast/cim/model/user/User;

    invoke-virtual {p0, p1}, Lcom/comcast/cim/model/provider/UserChangeRevalidationPolicy;->shouldFallBackToLastCached(Lcom/comcast/cim/model/user/User;)Z

    move-result v0

    return v0
.end method

.method public shouldRevalidate(Lcom/comcast/cim/model/user/User;)Z
    .locals 1
    .param p1, "version"    # Lcom/comcast/cim/model/user/User;

    .prologue
    .line 28
    .local p0, "this":Lcom/comcast/cim/model/provider/UserChangeRevalidationPolicy;, "Lcom/comcast/cim/model/provider/UserChangeRevalidationPolicy<TU;>;"
    if-eqz p1, :cond_0

    invoke-virtual {p0}, Lcom/comcast/cim/model/provider/UserChangeRevalidationPolicy;->getCurrentVersion()Lcom/comcast/cim/model/user/User;

    move-result-object v0

    invoke-virtual {p1, v0}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

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
    .line 10
    .local p0, "this":Lcom/comcast/cim/model/provider/UserChangeRevalidationPolicy;, "Lcom/comcast/cim/model/provider/UserChangeRevalidationPolicy<TU;>;"
    check-cast p1, Lcom/comcast/cim/model/user/User;

    invoke-virtual {p0, p1}, Lcom/comcast/cim/model/provider/UserChangeRevalidationPolicy;->shouldRevalidate(Lcom/comcast/cim/model/user/User;)Z

    move-result v0

    return v0
.end method

.method public toString()Ljava/lang/String;
    .locals 3

    .prologue
    .line 38
    .local p0, "this":Lcom/comcast/cim/model/provider/UserChangeRevalidationPolicy;, "Lcom/comcast/cim/model/provider/UserChangeRevalidationPolicy<TU;>;"
    new-instance v0, Lorg/apache/commons/lang3/builder/ToStringBuilder;

    sget-object v1, Lorg/apache/commons/lang3/builder/ToStringStyle;->SHORT_PREFIX_STYLE:Lorg/apache/commons/lang3/builder/ToStringStyle;

    invoke-direct {v0, p0, v1}, Lorg/apache/commons/lang3/builder/ToStringBuilder;-><init>(Ljava/lang/Object;Lorg/apache/commons/lang3/builder/ToStringStyle;)V

    const-string v1, "currentVersion"

    invoke-virtual {p0}, Lcom/comcast/cim/model/provider/UserChangeRevalidationPolicy;->getCurrentVersion()Lcom/comcast/cim/model/user/User;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lorg/apache/commons/lang3/builder/ToStringBuilder;->append(Ljava/lang/String;Ljava/lang/Object;)Lorg/apache/commons/lang3/builder/ToStringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Lorg/apache/commons/lang3/builder/ToStringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
