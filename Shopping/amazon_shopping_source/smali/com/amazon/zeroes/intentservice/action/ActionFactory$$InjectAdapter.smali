.class public final Lcom/amazon/zeroes/intentservice/action/ActionFactory$$InjectAdapter;
.super Ldagger/internal/Binding;
.source "ActionFactory$$InjectAdapter.java"

# interfaces
.implements Ljavax/inject/Provider;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ldagger/internal/Binding",
        "<",
        "Lcom/amazon/zeroes/intentservice/action/ActionFactory;",
        ">;",
        "Ljavax/inject/Provider",
        "<",
        "Lcom/amazon/zeroes/intentservice/action/ActionFactory;",
        ">;"
    }
.end annotation


# instance fields
.field private lazyCache:Ldagger/internal/Binding;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ldagger/internal/Binding",
            "<",
            "Ldagger/Lazy",
            "<",
            "Lcom/amazon/zeroes/intentservice/persistence/ZeroesCache;",
            ">;>;"
        }
    .end annotation
.end field

.field private lazyDecorator:Ldagger/internal/Binding;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ldagger/internal/Binding",
            "<",
            "Ldagger/Lazy",
            "<",
            "Lcom/amazon/zeroes/intentservice/ZeroesPurchaseRequestDecorator;",
            ">;>;"
        }
    .end annotation
.end field

.field private lazyMasDsClient:Ldagger/internal/Binding;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ldagger/internal/Binding",
            "<",
            "Ldagger/Lazy",
            "<",
            "Lcom/amazon/mas/client/deviceservice/MasDsClient;",
            ">;>;"
        }
    .end annotation
.end field

.field private lazyWebHttpClient:Ldagger/internal/Binding;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ldagger/internal/Binding",
            "<",
            "Ldagger/Lazy",
            "<",
            "Lcom/amazon/mas/client/http/WebHttpClient;",
            ">;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 4

    .prologue
    .line 27
    const-string/jumbo v0, "com.amazon.zeroes.intentservice.action.ActionFactory"

    const-string/jumbo v1, "members/com.amazon.zeroes.intentservice.action.ActionFactory"

    const/4 v2, 0x0

    const-class v3, Lcom/amazon/zeroes/intentservice/action/ActionFactory;

    invoke-direct {p0, v0, v1, v2, v3}, Ldagger/internal/Binding;-><init>(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Object;)V

    .line 28
    return-void
.end method


# virtual methods
.method public attach(Ldagger/internal/Linker;)V
    .locals 3
    .param p1, "linker"    # Ldagger/internal/Linker;

    .prologue
    .line 37
    const-string/jumbo v0, "dagger.Lazy<com.amazon.mas.client.deviceservice.MasDsClient>"

    const-class v1, Lcom/amazon/zeroes/intentservice/action/ActionFactory;

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v2

    invoke-virtual {p1, v0, v1, v2}, Ldagger/internal/Linker;->requestBinding(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/ClassLoader;)Ldagger/internal/Binding;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/zeroes/intentservice/action/ActionFactory$$InjectAdapter;->lazyMasDsClient:Ldagger/internal/Binding;

    .line 38
    const-string/jumbo v0, "dagger.Lazy<com.amazon.mas.client.http.WebHttpClient>"

    const-class v1, Lcom/amazon/zeroes/intentservice/action/ActionFactory;

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v2

    invoke-virtual {p1, v0, v1, v2}, Ldagger/internal/Linker;->requestBinding(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/ClassLoader;)Ldagger/internal/Binding;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/zeroes/intentservice/action/ActionFactory$$InjectAdapter;->lazyWebHttpClient:Ldagger/internal/Binding;

    .line 39
    const-string/jumbo v0, "dagger.Lazy<com.amazon.zeroes.intentservice.persistence.ZeroesCache>"

    const-class v1, Lcom/amazon/zeroes/intentservice/action/ActionFactory;

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v2

    invoke-virtual {p1, v0, v1, v2}, Ldagger/internal/Linker;->requestBinding(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/ClassLoader;)Ldagger/internal/Binding;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/zeroes/intentservice/action/ActionFactory$$InjectAdapter;->lazyCache:Ldagger/internal/Binding;

    .line 40
    const-string/jumbo v0, "dagger.Lazy<com.amazon.zeroes.intentservice.ZeroesPurchaseRequestDecorator>"

    const-class v1, Lcom/amazon/zeroes/intentservice/action/ActionFactory;

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v2

    invoke-virtual {p1, v0, v1, v2}, Ldagger/internal/Linker;->requestBinding(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/ClassLoader;)Ldagger/internal/Binding;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/zeroes/intentservice/action/ActionFactory$$InjectAdapter;->lazyDecorator:Ldagger/internal/Binding;

    .line 41
    return-void
.end method

.method public get()Lcom/amazon/zeroes/intentservice/action/ActionFactory;
    .locals 5

    .prologue
    .line 61
    new-instance v0, Lcom/amazon/zeroes/intentservice/action/ActionFactory;

    iget-object v1, p0, Lcom/amazon/zeroes/intentservice/action/ActionFactory$$InjectAdapter;->lazyMasDsClient:Ldagger/internal/Binding;

    invoke-virtual {v1}, Ldagger/internal/Binding;->get()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ldagger/Lazy;

    iget-object v2, p0, Lcom/amazon/zeroes/intentservice/action/ActionFactory$$InjectAdapter;->lazyWebHttpClient:Ldagger/internal/Binding;

    invoke-virtual {v2}, Ldagger/internal/Binding;->get()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ldagger/Lazy;

    iget-object v3, p0, Lcom/amazon/zeroes/intentservice/action/ActionFactory$$InjectAdapter;->lazyCache:Ldagger/internal/Binding;

    invoke-virtual {v3}, Ldagger/internal/Binding;->get()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ldagger/Lazy;

    iget-object v4, p0, Lcom/amazon/zeroes/intentservice/action/ActionFactory$$InjectAdapter;->lazyDecorator:Ldagger/internal/Binding;

    invoke-virtual {v4}, Ldagger/internal/Binding;->get()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ldagger/Lazy;

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/amazon/zeroes/intentservice/action/ActionFactory;-><init>(Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;)V

    .line 62
    .local v0, "result":Lcom/amazon/zeroes/intentservice/action/ActionFactory;
    return-object v0
.end method

.method public bridge synthetic get()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 19
    invoke-virtual {p0}, Lcom/amazon/zeroes/intentservice/action/ActionFactory$$InjectAdapter;->get()Lcom/amazon/zeroes/intentservice/action/ActionFactory;

    move-result-object v0

    return-object v0
.end method

.method public getDependencies(Ljava/util/Set;Ljava/util/Set;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Set",
            "<",
            "Ldagger/internal/Binding",
            "<*>;>;",
            "Ljava/util/Set",
            "<",
            "Ldagger/internal/Binding",
            "<*>;>;)V"
        }
    .end annotation

    .prologue
    .line 49
    .local p1, "getBindings":Ljava/util/Set;, "Ljava/util/Set<Ldagger/internal/Binding<*>;>;"
    .local p2, "injectMembersBindings":Ljava/util/Set;, "Ljava/util/Set<Ldagger/internal/Binding<*>;>;"
    iget-object v0, p0, Lcom/amazon/zeroes/intentservice/action/ActionFactory$$InjectAdapter;->lazyMasDsClient:Ldagger/internal/Binding;

    invoke-interface {p1, v0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 50
    iget-object v0, p0, Lcom/amazon/zeroes/intentservice/action/ActionFactory$$InjectAdapter;->lazyWebHttpClient:Ldagger/internal/Binding;

    invoke-interface {p1, v0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 51
    iget-object v0, p0, Lcom/amazon/zeroes/intentservice/action/ActionFactory$$InjectAdapter;->lazyCache:Ldagger/internal/Binding;

    invoke-interface {p1, v0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 52
    iget-object v0, p0, Lcom/amazon/zeroes/intentservice/action/ActionFactory$$InjectAdapter;->lazyDecorator:Ldagger/internal/Binding;

    invoke-interface {p1, v0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 53
    return-void
.end method
