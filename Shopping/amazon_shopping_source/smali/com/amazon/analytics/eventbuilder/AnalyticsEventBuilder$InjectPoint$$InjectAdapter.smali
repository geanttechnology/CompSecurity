.class public final Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder$InjectPoint$$InjectAdapter;
.super Ldagger/internal/Binding;
.source "AnalyticsEventBuilder$InjectPoint$$InjectAdapter.java"

# interfaces
.implements Ldagger/MembersInjector;
.implements Ljavax/inject/Provider;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ldagger/internal/Binding",
        "<",
        "Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder$InjectPoint;",
        ">;",
        "Ldagger/MembersInjector",
        "<",
        "Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder$InjectPoint;",
        ">;",
        "Ljavax/inject/Provider",
        "<",
        "Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder$InjectPoint;",
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

.field private execService:Ldagger/internal/Binding;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ldagger/internal/Binding",
            "<",
            "Ljava/util/concurrent/ScheduledExecutorService;",
            ">;"
        }
    .end annotation
.end field

.field private initializer:Ldagger/internal/Binding;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ldagger/internal/Binding",
            "<",
            "Lcom/amazon/analytics/AnalyticsConfigurationInitializer;",
            ">;"
        }
    .end annotation
.end field

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

.field private recorder:Ldagger/internal/Binding;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ldagger/internal/Binding",
            "<",
            "Lcom/amazon/device/analytics/events/EventRecorder;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 4

    .prologue
    .line 32
    const-string/jumbo v0, "com.amazon.analytics.eventbuilder.AnalyticsEventBuilder$InjectPoint"

    const-string/jumbo v1, "members/com.amazon.analytics.eventbuilder.AnalyticsEventBuilder$InjectPoint"

    const/4 v2, 0x0

    const-class v3, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder$InjectPoint;

    invoke-direct {p0, v0, v1, v2, v3}, Ldagger/internal/Binding;-><init>(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Object;)V

    .line 33
    return-void
.end method


# virtual methods
.method public attach(Ldagger/internal/Linker;)V
    .locals 3
    .param p1, "linker"    # Ldagger/internal/Linker;

    .prologue
    .line 42
    const-string/jumbo v0, "com.amazon.analytics.AnalyticsConfigurationInitializer"

    const-class v1, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder$InjectPoint;

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v2

    invoke-virtual {p1, v0, v1, v2}, Ldagger/internal/Linker;->requestBinding(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/ClassLoader;)Ldagger/internal/Binding;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder$InjectPoint$$InjectAdapter;->initializer:Ldagger/internal/Binding;

    .line 43
    const-string/jumbo v0, "com.amazon.device.analytics.events.EventRecorder"

    const-class v1, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder$InjectPoint;

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v2

    invoke-virtual {p1, v0, v1, v2}, Ldagger/internal/Linker;->requestBinding(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/ClassLoader;)Ldagger/internal/Binding;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder$InjectPoint$$InjectAdapter;->recorder:Ldagger/internal/Binding;

    .line 44
    const-string/jumbo v0, "com.amazon.analytics.AnalyticsConfiguration"

    const-class v1, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder$InjectPoint;

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v2

    invoke-virtual {p1, v0, v1, v2}, Ldagger/internal/Linker;->requestBinding(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/ClassLoader;)Ldagger/internal/Binding;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder$InjectPoint$$InjectAdapter;->config:Ldagger/internal/Binding;

    .line 45
    const-string/jumbo v0, "com.amazon.analytics.session.PriorityQueue"

    const-class v1, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder$InjectPoint;

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v2

    invoke-virtual {p1, v0, v1, v2}, Ldagger/internal/Linker;->requestBinding(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/ClassLoader;)Ldagger/internal/Binding;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder$InjectPoint$$InjectAdapter;->queue:Ldagger/internal/Binding;

    .line 46
    const-string/jumbo v0, "@javax.inject.Named(value=TailwindExecutorService)/java.util.concurrent.ScheduledExecutorService"

    const-class v1, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder$InjectPoint;

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v2

    invoke-virtual {p1, v0, v1, v2}, Ldagger/internal/Linker;->requestBinding(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/ClassLoader;)Ldagger/internal/Binding;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder$InjectPoint$$InjectAdapter;->execService:Ldagger/internal/Binding;

    .line 47
    return-void
.end method

.method public get()Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder$InjectPoint;
    .locals 1

    .prologue
    .line 68
    new-instance v0, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder$InjectPoint;

    invoke-direct {v0}, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder$InjectPoint;-><init>()V

    .line 69
    .local v0, "result":Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder$InjectPoint;
    invoke-virtual {p0, v0}, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder$InjectPoint$$InjectAdapter;->injectMembers(Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder$InjectPoint;)V

    .line 70
    return-object v0
.end method

.method public bridge synthetic get()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 23
    invoke-virtual {p0}, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder$InjectPoint$$InjectAdapter;->get()Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder$InjectPoint;

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
    .line 55
    .local p1, "getBindings":Ljava/util/Set;, "Ljava/util/Set<Ldagger/internal/Binding<*>;>;"
    .local p2, "injectMembersBindings":Ljava/util/Set;, "Ljava/util/Set<Ldagger/internal/Binding<*>;>;"
    iget-object v0, p0, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder$InjectPoint$$InjectAdapter;->initializer:Ldagger/internal/Binding;

    invoke-interface {p2, v0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 56
    iget-object v0, p0, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder$InjectPoint$$InjectAdapter;->recorder:Ldagger/internal/Binding;

    invoke-interface {p2, v0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 57
    iget-object v0, p0, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder$InjectPoint$$InjectAdapter;->config:Ldagger/internal/Binding;

    invoke-interface {p2, v0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 58
    iget-object v0, p0, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder$InjectPoint$$InjectAdapter;->queue:Ldagger/internal/Binding;

    invoke-interface {p2, v0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 59
    iget-object v0, p0, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder$InjectPoint$$InjectAdapter;->execService:Ldagger/internal/Binding;

    invoke-interface {p2, v0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 60
    return-void
.end method

.method public injectMembers(Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder$InjectPoint;)V
    .locals 1
    .param p1, "object"    # Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder$InjectPoint;

    .prologue
    .line 79
    iget-object v0, p0, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder$InjectPoint$$InjectAdapter;->initializer:Ldagger/internal/Binding;

    invoke-virtual {v0}, Ldagger/internal/Binding;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/analytics/AnalyticsConfigurationInitializer;

    iput-object v0, p1, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder$InjectPoint;->initializer:Lcom/amazon/analytics/AnalyticsConfigurationInitializer;

    .line 80
    iget-object v0, p0, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder$InjectPoint$$InjectAdapter;->recorder:Ldagger/internal/Binding;

    invoke-virtual {v0}, Ldagger/internal/Binding;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/device/analytics/events/EventRecorder;

    iput-object v0, p1, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder$InjectPoint;->recorder:Lcom/amazon/device/analytics/events/EventRecorder;

    .line 81
    iget-object v0, p0, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder$InjectPoint$$InjectAdapter;->config:Ldagger/internal/Binding;

    invoke-virtual {v0}, Ldagger/internal/Binding;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/analytics/AnalyticsConfiguration;

    iput-object v0, p1, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder$InjectPoint;->config:Lcom/amazon/analytics/AnalyticsConfiguration;

    .line 82
    iget-object v0, p0, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder$InjectPoint$$InjectAdapter;->queue:Ldagger/internal/Binding;

    invoke-virtual {v0}, Ldagger/internal/Binding;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/analytics/session/PriorityQueue;

    iput-object v0, p1, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder$InjectPoint;->queue:Lcom/amazon/analytics/session/PriorityQueue;

    .line 83
    iget-object v0, p0, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder$InjectPoint$$InjectAdapter;->execService:Ldagger/internal/Binding;

    invoke-virtual {v0}, Ldagger/internal/Binding;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/concurrent/ScheduledExecutorService;

    iput-object v0, p1, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder$InjectPoint;->execService:Ljava/util/concurrent/ScheduledExecutorService;

    .line 84
    return-void
.end method

.method public bridge synthetic injectMembers(Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 23
    check-cast p1, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder$InjectPoint;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder$InjectPoint$$InjectAdapter;->injectMembers(Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder$InjectPoint;)V

    return-void
.end method
