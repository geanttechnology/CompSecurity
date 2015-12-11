.class public Lco/vine/android/util/InstanceCounter;
.super Ljava/lang/Object;
.source "InstanceCounter.java"


# instance fields
.field private final mLimit:I

.field private final sInstanceCounter:Ljava/util/HashSet;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashSet",
            "<",
            "Ljava/lang/ref/WeakReference",
            "<",
            "Ljava/lang/Object;",
            ">;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(I)V
    .locals 1
    .param p1, "limit"    # I

    .prologue
    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 14
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    iput-object v0, p0, Lco/vine/android/util/InstanceCounter;->sInstanceCounter:Ljava/util/HashSet;

    .line 18
    iput p1, p0, Lco/vine/android/util/InstanceCounter;->mLimit:I

    .line 19
    return-void
.end method

.method public static get(I)Lco/vine/android/util/InstanceCounter;
    .locals 1
    .param p0, "limit"    # I

    .prologue
    .line 46
    new-instance v0, Lco/vine/android/util/InstanceCounter;

    invoke-direct {v0, p0}, Lco/vine/android/util/InstanceCounter;-><init>(I)V

    return-object v0
.end method


# virtual methods
.method public onCreate(Ljava/lang/Object;)I
    .locals 5
    .param p1, "o"    # Ljava/lang/Object;

    .prologue
    .line 27
    invoke-static {}, Ljava/lang/System;->gc()V

    .line 28
    iget-object v3, p0, Lco/vine/android/util/InstanceCounter;->sInstanceCounter:Ljava/util/HashSet;

    invoke-virtual {v3}, Ljava/util/HashSet;->size()I

    move-result v3

    iget v4, p0, Lco/vine/android/util/InstanceCounter;->mLimit:I

    add-int/lit8 v4, v4, 0x64

    if-le v3, v4, :cond_0

    .line 29
    iget-object v3, p0, Lco/vine/android/util/InstanceCounter;->sInstanceCounter:Ljava/util/HashSet;

    invoke-virtual {v3}, Ljava/util/HashSet;->clear()V

    .line 31
    :cond_0
    iget-object v3, p0, Lco/vine/android/util/InstanceCounter;->sInstanceCounter:Ljava/util/HashSet;

    new-instance v4, Ljava/lang/ref/WeakReference;

    invoke-direct {v4, p1}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    invoke-virtual {v3, v4}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    .line 32
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 33
    .local v2, "toRemove":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/ref/WeakReference<Ljava/lang/Object;>;>;"
    iget-object v3, p0, Lco/vine/android/util/InstanceCounter;->sInstanceCounter:Ljava/util/HashSet;

    invoke-virtual {v3}, Ljava/util/HashSet;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_1
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_2

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/ref/WeakReference;

    .line 34
    .local v1, "sessionWeakReference":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Ljava/lang/Object;>;"
    invoke-virtual {v1}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v3

    if-nez v3, :cond_1

    .line 35
    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 38
    .end local v1    # "sessionWeakReference":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Ljava/lang/Object;>;"
    :cond_2
    iget-object v3, p0, Lco/vine/android/util/InstanceCounter;->sInstanceCounter:Ljava/util/HashSet;

    invoke-virtual {v3, v2}, Ljava/util/HashSet;->removeAll(Ljava/util/Collection;)Z

    .line 39
    sget-boolean v3, Lcom/edisonwang/android/slog/SLog;->sLogsOn:Z

    if-eqz v3, :cond_3

    iget-object v3, p0, Lco/vine/android/util/InstanceCounter;->sInstanceCounter:Ljava/util/HashSet;

    invoke-virtual {v3}, Ljava/util/HashSet;->size()I

    move-result v3

    iget v4, p0, Lco/vine/android/util/InstanceCounter;->mLimit:I

    if-lt v3, v4, :cond_3

    .line 40
    new-instance v3, Ljava/lang/RuntimeException;

    const-string v4, "Limit has reached for this object type."

    invoke-direct {v3, v4}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 42
    :cond_3
    iget-object v3, p0, Lco/vine/android/util/InstanceCounter;->sInstanceCounter:Ljava/util/HashSet;

    invoke-virtual {v3}, Ljava/util/HashSet;->size()I

    move-result v3

    return v3
.end method
