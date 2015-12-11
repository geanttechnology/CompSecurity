.class public final Lcom/comcast/cim/cmasl/utils/collections/CollectionUtils;
.super Ljava/lang/Object;
.source "CollectionUtils.java"


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 94
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static containsAny(Ljava/util/Collection;Ljava/util/Collection;)Z
    .locals 6
    .param p0, "first"    # Ljava/util/Collection;
    .param p1, "second"    # Ljava/util/Collection;

    .prologue
    .line 76
    invoke-interface {p0}, Ljava/util/Collection;->size()I

    move-result v4

    invoke-interface {p1}, Ljava/util/Collection;->size()I

    move-result v5

    if-ge v4, v5, :cond_1

    .line 77
    move-object v2, p0

    .line 78
    .local v2, "looper":Ljava/util/Collection;
    move-object v0, p1

    .line 84
    .local v0, "checker":Ljava/util/Collection;
    :goto_0
    invoke-interface {v2}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_2

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    .line 85
    .local v3, "obj":Ljava/lang/Object;
    invoke-interface {v0, v3}, Ljava/util/Collection;->contains(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 87
    const/4 v4, 0x1

    .line 91
    .end local v3    # "obj":Ljava/lang/Object;
    :goto_1
    return v4

    .line 80
    .end local v0    # "checker":Ljava/util/Collection;
    .end local v1    # "i$":Ljava/util/Iterator;
    .end local v2    # "looper":Ljava/util/Collection;
    :cond_1
    move-object v2, p1

    .line 81
    .restart local v2    # "looper":Ljava/util/Collection;
    move-object v0, p0

    .restart local v0    # "checker":Ljava/util/Collection;
    goto :goto_0

    .line 91
    .restart local v1    # "i$":Ljava/util/Iterator;
    :cond_2
    const/4 v4, 0x0

    goto :goto_1
.end method

.method public static createList(Ljava/lang/Object;)Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(TT;)",
            "Ljava/util/List",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 31
    .local p0, "a":Ljava/lang/Object;, "TT;"
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 32
    .local v0, "list":Ljava/util/List;, "Ljava/util/List<TT;>;"
    invoke-interface {v0, p0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 33
    return-object v0
.end method

.method public static createList(Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(TT;TT;)",
            "Ljava/util/List",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 37
    .local p0, "a":Ljava/lang/Object;, "TT;"
    .local p1, "b":Ljava/lang/Object;, "TT;"
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 38
    .local v0, "list":Ljava/util/List;, "Ljava/util/List<TT;>;"
    invoke-interface {v0, p0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 39
    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 40
    return-object v0
.end method

.method public static createList(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(TT;TT;TT;)",
            "Ljava/util/List",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 44
    .local p0, "a":Ljava/lang/Object;, "TT;"
    .local p1, "b":Ljava/lang/Object;, "TT;"
    .local p2, "c":Ljava/lang/Object;, "TT;"
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 45
    .local v0, "list":Ljava/util/List;, "Ljava/util/List<TT;>;"
    invoke-interface {v0, p0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 46
    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 47
    invoke-interface {v0, p2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 48
    return-object v0
.end method

.method public static nullOrEmpty(Ljava/util/Collection;)Z
    .locals 1
    .param p0, "c"    # Ljava/util/Collection;

    .prologue
    .line 70
    if-eqz p0, :cond_0

    invoke-interface {p0}, Ljava/util/Collection;->isEmpty()Z

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
