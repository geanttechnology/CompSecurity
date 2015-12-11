.class public final Lcom/amazon/analytics/TailwindModule$$ModuleAdapter$GetAnalyticsConfigurationInitializerProvidesAdapter;
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
    name = "GetAnalyticsConfigurationInitializerProvidesAdapter"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ldagger/internal/ProvidesBinding",
        "<",
        "Lcom/amazon/analytics/AnalyticsConfigurationInitializer;",
        ">;",
        "Ljavax/inject/Provider",
        "<",
        "Lcom/amazon/analytics/AnalyticsConfigurationInitializer;",
        ">;"
    }
.end annotation


# instance fields
.field private activityManager:Ldagger/internal/Binding;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ldagger/internal/Binding",
            "<",
            "Lcom/amazon/analytics/TailwindActivityManager;",
            ">;"
        }
    .end annotation
.end field

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

.field private context:Ldagger/internal/Binding;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ldagger/internal/Binding",
            "<",
            "Landroid/content/Context;",
            ">;"
        }
    .end annotation
.end field

.field private final module:Lcom/amazon/analytics/TailwindModule;

.field private queue:Ldagger/internal/Binding;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ldagger/internal/Binding",
            "<",
            "Lcom/amazon/analytics/session/PriorityQueue;",
            ">;"
        }
    .end annotation
.end field

.field private service:Ldagger/internal/Binding;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ldagger/internal/Binding",
            "<",
            "Ljava/util/concurrent/ScheduledExecutorService;",
            ">;"
        }
    .end annotation
.end field

.field private sessionBuilder:Ldagger/internal/Binding;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ldagger/internal/Binding",
            "<",
            "Lcom/amazon/analytics/session/PackageSessionBuilder;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/amazon/analytics/TailwindModule;)V
    .locals 4
    .param p1, "module"    # Lcom/amazon/analytics/TailwindModule;

    .prologue
    .line 431
    const-string/jumbo v0, "com.amazon.analytics.AnalyticsConfigurationInitializer"

    const/4 v1, 0x1

    const-string/jumbo v2, "com.amazon.analytics.TailwindModule"

    const-string/jumbo v3, "getAnalyticsConfigurationInitializer"

    invoke-direct {p0, v0, v1, v2, v3}, Ldagger/internal/ProvidesBinding;-><init>(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V

    .line 432
    iput-object p1, p0, Lcom/amazon/analytics/TailwindModule$$ModuleAdapter$GetAnalyticsConfigurationInitializerProvidesAdapter;->module:Lcom/amazon/analytics/TailwindModule;

    .line 433
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/amazon/analytics/TailwindModule$$ModuleAdapter$GetAnalyticsConfigurationInitializerProvidesAdapter;->setLibrary(Z)V

    .line 434
    return-void
.end method


# virtual methods
.method public attach(Ldagger/internal/Linker;)V
    .locals 3
    .param p1, "linker"    # Ldagger/internal/Linker;

    .prologue
    .line 443
    const-string/jumbo v0, "android.content.Context"

    const-class v1, Lcom/amazon/analytics/TailwindModule;

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v2

    invoke-virtual {p1, v0, v1, v2}, Ldagger/internal/Linker;->requestBinding(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/ClassLoader;)Ldagger/internal/Binding;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/analytics/TailwindModule$$ModuleAdapter$GetAnalyticsConfigurationInitializerProvidesAdapter;->context:Ldagger/internal/Binding;

    .line 444
    const-string/jumbo v0, "com.amazon.analytics.TailwindActivityManager"

    const-class v1, Lcom/amazon/analytics/TailwindModule;

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v2

    invoke-virtual {p1, v0, v1, v2}, Ldagger/internal/Linker;->requestBinding(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/ClassLoader;)Ldagger/internal/Binding;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/analytics/TailwindModule$$ModuleAdapter$GetAnalyticsConfigurationInitializerProvidesAdapter;->activityManager:Ldagger/internal/Binding;

    .line 445
    const-string/jumbo v0, "com.amazon.analytics.AnalyticsConfiguration"

    const-class v1, Lcom/amazon/analytics/TailwindModule;

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v2

    invoke-virtual {p1, v0, v1, v2}, Ldagger/internal/Linker;->requestBinding(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/ClassLoader;)Ldagger/internal/Binding;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/analytics/TailwindModule$$ModuleAdapter$GetAnalyticsConfigurationInitializerProvidesAdapter;->config:Ldagger/internal/Binding;

    .line 446
    const-string/jumbo v0, "com.amazon.analytics.session.PriorityQueue"

    const-class v1, Lcom/amazon/analytics/TailwindModule;

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v2

    invoke-virtual {p1, v0, v1, v2}, Ldagger/internal/Linker;->requestBinding(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/ClassLoader;)Ldagger/internal/Binding;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/analytics/TailwindModule$$ModuleAdapter$GetAnalyticsConfigurationInitializerProvidesAdapter;->queue:Ldagger/internal/Binding;

    .line 447
    const-string/jumbo v0, "com.amazon.analytics.session.PackageSessionBuilder"

    const-class v1, Lcom/amazon/analytics/TailwindModule;

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v2

    invoke-virtual {p1, v0, v1, v2}, Ldagger/internal/Linker;->requestBinding(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/ClassLoader;)Ldagger/internal/Binding;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/analytics/TailwindModule$$ModuleAdapter$GetAnalyticsConfigurationInitializerProvidesAdapter;->sessionBuilder:Ldagger/internal/Binding;

    .line 448
    const-string/jumbo v0, "@javax.inject.Named(value=TailwindExecutorService)/java.util.concurrent.ScheduledExecutorService"

    const-class v1, Lcom/amazon/analytics/TailwindModule;

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v2

    invoke-virtual {p1, v0, v1, v2}, Ldagger/internal/Linker;->requestBinding(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/ClassLoader;)Ldagger/internal/Binding;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/analytics/TailwindModule$$ModuleAdapter$GetAnalyticsConfigurationInitializerProvidesAdapter;->service:Ldagger/internal/Binding;

    .line 449
    return-void
.end method

.method public get()Lcom/amazon/analytics/AnalyticsConfigurationInitializer;
    .locals 7

    .prologue
    .line 471
    iget-object v0, p0, Lcom/amazon/analytics/TailwindModule$$ModuleAdapter$GetAnalyticsConfigurationInitializerProvidesAdapter;->module:Lcom/amazon/analytics/TailwindModule;

    iget-object v1, p0, Lcom/amazon/analytics/TailwindModule$$ModuleAdapter$GetAnalyticsConfigurationInitializerProvidesAdapter;->context:Ldagger/internal/Binding;

    invoke-virtual {v1}, Ldagger/internal/Binding;->get()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/content/Context;

    iget-object v2, p0, Lcom/amazon/analytics/TailwindModule$$ModuleAdapter$GetAnalyticsConfigurationInitializerProvidesAdapter;->activityManager:Ldagger/internal/Binding;

    invoke-virtual {v2}, Ldagger/internal/Binding;->get()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/analytics/TailwindActivityManager;

    iget-object v3, p0, Lcom/amazon/analytics/TailwindModule$$ModuleAdapter$GetAnalyticsConfigurationInitializerProvidesAdapter;->config:Ldagger/internal/Binding;

    invoke-virtual {v3}, Ldagger/internal/Binding;->get()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/amazon/analytics/AnalyticsConfiguration;

    iget-object v4, p0, Lcom/amazon/analytics/TailwindModule$$ModuleAdapter$GetAnalyticsConfigurationInitializerProvidesAdapter;->queue:Ldagger/internal/Binding;

    invoke-virtual {v4}, Ldagger/internal/Binding;->get()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/amazon/analytics/session/PriorityQueue;

    iget-object v5, p0, Lcom/amazon/analytics/TailwindModule$$ModuleAdapter$GetAnalyticsConfigurationInitializerProvidesAdapter;->sessionBuilder:Ldagger/internal/Binding;

    invoke-virtual {v5}, Ldagger/internal/Binding;->get()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/amazon/analytics/session/PackageSessionBuilder;

    iget-object v6, p0, Lcom/amazon/analytics/TailwindModule$$ModuleAdapter$GetAnalyticsConfigurationInitializerProvidesAdapter;->service:Ldagger/internal/Binding;

    invoke-virtual {v6}, Ldagger/internal/Binding;->get()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/util/concurrent/ScheduledExecutorService;

    invoke-virtual/range {v0 .. v6}, Lcom/amazon/analytics/TailwindModule;->getAnalyticsConfigurationInitializer(Landroid/content/Context;Lcom/amazon/analytics/TailwindActivityManager;Lcom/amazon/analytics/AnalyticsConfiguration;Lcom/amazon/analytics/session/PriorityQueue;Lcom/amazon/analytics/session/PackageSessionBuilder;Ljava/util/concurrent/ScheduledExecutorService;)Lcom/amazon/analytics/AnalyticsConfigurationInitializer;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic get()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 420
    invoke-virtual {p0}, Lcom/amazon/analytics/TailwindModule$$ModuleAdapter$GetAnalyticsConfigurationInitializerProvidesAdapter;->get()Lcom/amazon/analytics/AnalyticsConfigurationInitializer;

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
    .line 457
    .local p1, "getBindings":Ljava/util/Set;, "Ljava/util/Set<Ldagger/internal/Binding<*>;>;"
    .local p2, "injectMembersBindings":Ljava/util/Set;, "Ljava/util/Set<Ldagger/internal/Binding<*>;>;"
    iget-object v0, p0, Lcom/amazon/analytics/TailwindModule$$ModuleAdapter$GetAnalyticsConfigurationInitializerProvidesAdapter;->context:Ldagger/internal/Binding;

    invoke-interface {p1, v0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 458
    iget-object v0, p0, Lcom/amazon/analytics/TailwindModule$$ModuleAdapter$GetAnalyticsConfigurationInitializerProvidesAdapter;->activityManager:Ldagger/internal/Binding;

    invoke-interface {p1, v0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 459
    iget-object v0, p0, Lcom/amazon/analytics/TailwindModule$$ModuleAdapter$GetAnalyticsConfigurationInitializerProvidesAdapter;->config:Ldagger/internal/Binding;

    invoke-interface {p1, v0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 460
    iget-object v0, p0, Lcom/amazon/analytics/TailwindModule$$ModuleAdapter$GetAnalyticsConfigurationInitializerProvidesAdapter;->queue:Ldagger/internal/Binding;

    invoke-interface {p1, v0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 461
    iget-object v0, p0, Lcom/amazon/analytics/TailwindModule$$ModuleAdapter$GetAnalyticsConfigurationInitializerProvidesAdapter;->sessionBuilder:Ldagger/internal/Binding;

    invoke-interface {p1, v0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 462
    iget-object v0, p0, Lcom/amazon/analytics/TailwindModule$$ModuleAdapter$GetAnalyticsConfigurationInitializerProvidesAdapter;->service:Ldagger/internal/Binding;

    invoke-interface {p1, v0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 463
    return-void
.end method
