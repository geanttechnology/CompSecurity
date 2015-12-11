.class public abstract Lcom/amazon/ansel/fetch/LoaderGroup;
.super Ljava/lang/Object;
.source "LoaderGroup.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/ansel/fetch/LoaderGroup$ItemListener;
    }
.end annotation


# instance fields
.field private final context:Lcom/amazon/ansel/fetch/LoaderContext;

.field private final loaders:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Lcom/amazon/ansel/fetch/ResourceLoader",
            "<*>;>;"
        }
    .end annotation
.end field

.field private final parent:Lcom/amazon/ansel/fetch/LoaderGroup;


# direct methods
.method public constructor <init>(Lcom/amazon/ansel/fetch/LoaderContext;)V
    .locals 1
    .param p1, "context"    # Lcom/amazon/ansel/fetch/LoaderContext;

    .prologue
    .line 27
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/amazon/ansel/fetch/LoaderGroup;-><init>(Lcom/amazon/ansel/fetch/LoaderContext;Lcom/amazon/ansel/fetch/LoaderGroup;)V

    .line 28
    return-void
.end method

.method private constructor <init>(Lcom/amazon/ansel/fetch/LoaderContext;Lcom/amazon/ansel/fetch/LoaderGroup;)V
    .locals 1
    .param p1, "context"    # Lcom/amazon/ansel/fetch/LoaderContext;
    .param p2, "parent"    # Lcom/amazon/ansel/fetch/LoaderGroup;

    .prologue
    .line 21
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 15
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {v0}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    invoke-static {v0}, Ljava/util/Collections;->newSetFromMap(Ljava/util/Map;)Ljava/util/Set;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/ansel/fetch/LoaderGroup;->loaders:Ljava/util/Set;

    .line 22
    iput-object p1, p0, Lcom/amazon/ansel/fetch/LoaderGroup;->context:Lcom/amazon/ansel/fetch/LoaderContext;

    .line 23
    iput-object p2, p0, Lcom/amazon/ansel/fetch/LoaderGroup;->parent:Lcom/amazon/ansel/fetch/LoaderGroup;

    .line 24
    return-void
.end method

.method public constructor <init>(Lcom/amazon/ansel/fetch/LoaderGroup;)V
    .locals 1
    .param p1, "parent"    # Lcom/amazon/ansel/fetch/LoaderGroup;

    .prologue
    .line 31
    invoke-virtual {p1}, Lcom/amazon/ansel/fetch/LoaderGroup;->getContext()Lcom/amazon/ansel/fetch/LoaderContext;

    move-result-object v0

    invoke-direct {p0, v0, p1}, Lcom/amazon/ansel/fetch/LoaderGroup;-><init>(Lcom/amazon/ansel/fetch/LoaderContext;Lcom/amazon/ansel/fetch/LoaderGroup;)V

    .line 32
    return-void
.end method


# virtual methods
.method public cancel()V
    .locals 3

    .prologue
    .line 75
    iget-object v2, p0, Lcom/amazon/ansel/fetch/LoaderGroup;->loaders:Ljava/util/Set;

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/ansel/fetch/ResourceLoader;

    .line 76
    .local v1, "loader":Lcom/amazon/ansel/fetch/ResourceLoader;, "Lcom/amazon/ansel/fetch/ResourceLoader<*>;"
    invoke-virtual {v1}, Lcom/amazon/ansel/fetch/ResourceLoader;->cancel()V

    goto :goto_0

    .line 78
    .end local v1    # "loader":Lcom/amazon/ansel/fetch/ResourceLoader;, "Lcom/amazon/ansel/fetch/ResourceLoader<*>;"
    :cond_0
    return-void
.end method

.method public execute(Lcom/amazon/ansel/fetch/ResourceLoader;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/ansel/fetch/ResourceLoader",
            "<*>;)V"
        }
    .end annotation

    .prologue
    .line 51
    .local p1, "loader":Lcom/amazon/ansel/fetch/ResourceLoader;, "Lcom/amazon/ansel/fetch/ResourceLoader<*>;"
    iget-object v0, p0, Lcom/amazon/ansel/fetch/LoaderGroup;->loaders:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 52
    new-instance v0, Lcom/amazon/ansel/fetch/tools/ref/WeakObjectReference;

    new-instance v1, Lcom/amazon/ansel/fetch/LoaderGroup$ItemListener;

    invoke-direct {v1, p0, p1}, Lcom/amazon/ansel/fetch/LoaderGroup$ItemListener;-><init>(Lcom/amazon/ansel/fetch/LoaderGroup;Lcom/amazon/ansel/fetch/ResourceLoader;)V

    invoke-direct {v0, v1}, Lcom/amazon/ansel/fetch/tools/ref/WeakObjectReference;-><init>(Ljava/lang/Object;)V

    invoke-virtual {p1, v0}, Lcom/amazon/ansel/fetch/ResourceLoader;->addListener(Lcom/amazon/ansel/fetch/tools/ref/ObjectReference;)V

    .line 53
    invoke-virtual {p0, p1}, Lcom/amazon/ansel/fetch/LoaderGroup;->runLoader(Lcom/amazon/ansel/fetch/ResourceLoader;)V

    .line 54
    return-void
.end method

.method public getContext()Lcom/amazon/ansel/fetch/LoaderContext;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lcom/amazon/ansel/fetch/LoaderGroup;->context:Lcom/amazon/ansel/fetch/LoaderContext;

    return-object v0
.end method

.method protected loaderDone(Lcom/amazon/ansel/fetch/ResourceLoader;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/ansel/fetch/ResourceLoader",
            "<*>;)V"
        }
    .end annotation

    .prologue
    .line 65
    .local p1, "loader":Lcom/amazon/ansel/fetch/ResourceLoader;, "Lcom/amazon/ansel/fetch/ResourceLoader<*>;"
    iget-object v0, p0, Lcom/amazon/ansel/fetch/LoaderGroup;->loaders:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->remove(Ljava/lang/Object;)Z

    .line 66
    return-void
.end method

.method protected runLoader(Lcom/amazon/ansel/fetch/ResourceLoader;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/ansel/fetch/ResourceLoader",
            "<*>;)V"
        }
    .end annotation

    .prologue
    .line 57
    .local p1, "loader":Lcom/amazon/ansel/fetch/ResourceLoader;, "Lcom/amazon/ansel/fetch/ResourceLoader<*>;"
    iget-object v0, p0, Lcom/amazon/ansel/fetch/LoaderGroup;->parent:Lcom/amazon/ansel/fetch/LoaderGroup;

    if-eqz v0, :cond_0

    .line 58
    iget-object v0, p0, Lcom/amazon/ansel/fetch/LoaderGroup;->parent:Lcom/amazon/ansel/fetch/LoaderGroup;

    invoke-virtual {v0, p1}, Lcom/amazon/ansel/fetch/LoaderGroup;->execute(Lcom/amazon/ansel/fetch/ResourceLoader;)V

    .line 62
    :goto_0
    return-void

    .line 60
    :cond_0
    invoke-virtual {p1}, Lcom/amazon/ansel/fetch/ResourceLoader;->execute()V

    goto :goto_0
.end method
