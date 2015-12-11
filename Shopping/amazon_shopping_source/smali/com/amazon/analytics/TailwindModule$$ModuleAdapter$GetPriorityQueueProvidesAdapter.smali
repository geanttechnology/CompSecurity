.class public final Lcom/amazon/analytics/TailwindModule$$ModuleAdapter$GetPriorityQueueProvidesAdapter;
.super Ldagger/internal/ProvidesBinding;
.source "TailwindModule$$ModuleAdapter.java"

# interfaces
.implements Ljavax/inject/Provider;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/analytics/TailwindModule$$ModuleAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "GetPriorityQueueProvidesAdapter"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ldagger/internal/ProvidesBinding",
        "<",
        "Lcom/amazon/analytics/session/PriorityQueue;",
        ">;",
        "Ljavax/inject/Provider",
        "<",
        "Lcom/amazon/analytics/session/PriorityQueue;",
        ">;"
    }
.end annotation


# instance fields
.field private config:Ldagger/internal/Binding;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ldagger/internal/Binding",
            "<",
            "Lcom/amazon/analytics/AnalyticsConfiguration;",
            ">;"
        }
    .end annotation
.end field

.field private final module:Lcom/amazon/analytics/TailwindModule;

.field private sessionObserver:Ldagger/internal/Binding;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ldagger/internal/Binding",
            "<",
            "Lcom/amazon/analytics/session/SessionObserver;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/amazon/analytics/TailwindModule;)V
    .locals 4
    .param p1, "module"    # Lcom/amazon/analytics/TailwindModule;

    .prologue
    .line 374
    const-string/jumbo v0, "com.amazon.analytics.session.PriorityQueue"

    const/4 v1, 0x1

    const-string/jumbo v2, "com.amazon.analytics.TailwindModule"

    const-string/jumbo v3, "getPriorityQueue"

    invoke-direct {p0, v0, v1, v2, v3}, Ldagger/internal/ProvidesBinding;-><init>(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V

    .line 375
    iput-object p1, p0, Lcom/amazon/analytics/TailwindModule$$ModuleAdapter$GetPriorityQueueProvidesAdapter;->module:Lcom/amazon/analytics/TailwindModule;

    .line 376
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/amazon/analytics/TailwindModule$$ModuleAdapter$GetPriorityQueueProvidesAdapter;->setLibrary(Z)V

    .line 377
    return-void
.end method


# virtual methods
.method public attach(Ldagger/internal/Linker;)V
    .locals 3
    .param p1, "linker"    # Ldagger/internal/Linker;

    .prologue
    .line 386
    const-string/jumbo v0, "com.amazon.analytics.session.SessionObserver"

    const-class v1, Lcom/amazon/analytics/TailwindModule;

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v2

    invoke-virtual {p1, v0, v1, v2}, Ldagger/internal/Linker;->requestBinding(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/ClassLoader;)Ldagger/internal/Binding;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/analytics/TailwindModule$$ModuleAdapter$GetPriorityQueueProvidesAdapter;->sessionObserver:Ldagger/internal/Binding;

    .line 387
    const-string/jumbo v0, "com.amazon.analytics.AnalyticsConfiguration"

    const-class v1, Lcom/amazon/analytics/TailwindModule;

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v2

    invoke-virtual {p1, v0, v1, v2}, Ldagger/internal/Linker;->requestBinding(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/ClassLoader;)Ldagger/internal/Binding;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/analytics/TailwindModule$$ModuleAdapter$GetPriorityQueueProvidesAdapter;->config:Ldagger/internal/Binding;

    .line 388
    return-void
.end method

.method public get()Lcom/amazon/analytics/session/PriorityQueue;
    .locals 3

    .prologue
    .line 406
    iget-object v2, p0, Lcom/amazon/analytics/TailwindModule$$ModuleAdapter$GetPriorityQueueProvidesAdapter;->module:Lcom/amazon/analytics/TailwindModule;

    iget-object v0, p0, Lcom/amazon/analytics/TailwindModule$$ModuleAdapter$GetPriorityQueueProvidesAdapter;->sessionObserver:Ldagger/internal/Binding;

    invoke-virtual {v0}, Ldagger/internal/Binding;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/analytics/session/SessionObserver;

    iget-object v1, p0, Lcom/amazon/analytics/TailwindModule$$ModuleAdapter$GetPriorityQueueProvidesAdapter;->config:Ldagger/internal/Binding;

    invoke-virtual {v1}, Ldagger/internal/Binding;->get()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/analytics/AnalyticsConfiguration;

    invoke-virtual {v2, v0, v1}, Lcom/amazon/analytics/TailwindModule;->getPriorityQueue(Lcom/amazon/analytics/session/SessionObserver;Lcom/amazon/analytics/AnalyticsConfiguration;)Lcom/amazon/analytics/session/PriorityQueue;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic get()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 367
    invoke-virtual {p0}, Lcom/amazon/analytics/TailwindModule$$ModuleAdapter$GetPriorityQueueProvidesAdapter;->get()Lcom/amazon/analytics/session/PriorityQueue;

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
    .line 396
    .local p1, "getBindings":Ljava/util/Set;, "Ljava/util/Set<Ldagger/internal/Binding<*>;>;"
    .local p2, "injectMembersBindings":Ljava/util/Set;, "Ljava/util/Set<Ldagger/internal/Binding<*>;>;"
    iget-object v0, p0, Lcom/amazon/analytics/TailwindModule$$ModuleAdapter$GetPriorityQueueProvidesAdapter;->sessionObserver:Ldagger/internal/Binding;

    invoke-interface {p1, v0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 397
    iget-object v0, p0, Lcom/amazon/analytics/TailwindModule$$ModuleAdapter$GetPriorityQueueProvidesAdapter;->config:Ldagger/internal/Binding;

    invoke-interface {p1, v0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 398
    return-void
.end method
