.class public final Lcom/amazon/analytics/TailwindModule$$ModuleAdapter;
.super Ldagger/internal/ModuleAdapter;
.source "TailwindModule$$ModuleAdapter.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/analytics/TailwindModule$$ModuleAdapter$GetAnalyticsConfigurationInitializerProvidesAdapter;,
        Lcom/amazon/analytics/TailwindModule$$ModuleAdapter$GetPriorityQueueProvidesAdapter;,
        Lcom/amazon/analytics/TailwindModule$$ModuleAdapter$GetSessionObserverProvidesAdapter;,
        Lcom/amazon/analytics/TailwindModule$$ModuleAdapter$GetPackageSessionBuilderProvidesAdapter;,
        Lcom/amazon/analytics/TailwindModule$$ModuleAdapter$GetEventRecorderProvidesAdapter;,
        Lcom/amazon/analytics/TailwindModule$$ModuleAdapter$GetAnalyticsConfigurationProvidesAdapter;,
        Lcom/amazon/analytics/TailwindModule$$ModuleAdapter$GetAnalyticsConfigurationImplProvidesAdapter;,
        Lcom/amazon/analytics/TailwindModule$$ModuleAdapter$GetScheduledExecutorServiceProvidesAdapter;,
        Lcom/amazon/analytics/TailwindModule$$ModuleAdapter$GetTailwindActivityManagerProvidesAdapter;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ldagger/internal/ModuleAdapter",
        "<",
        "Lcom/amazon/analytics/TailwindModule;",
        ">;"
    }
.end annotation


# static fields
.field private static final INCLUDES:[Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "[",
            "Ljava/lang/Class",
            "<*>;"
        }
    .end annotation
.end field

.field private static final INJECTS:[Ljava/lang/String;

.field private static final STATIC_INJECTIONS:[Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "[",
            "Ljava/lang/Class",
            "<*>;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 17
    new-array v0, v4, [Ljava/lang/String;

    const-string/jumbo v1, "members/com.amazon.analytics.eventbuilder.AnalyticsEventBuilder$InjectPoint"

    aput-object v1, v0, v2

    const-string/jumbo v1, "members/com.amazon.analytics.session.PackageSession"

    aput-object v1, v0, v3

    sput-object v0, Lcom/amazon/analytics/TailwindModule$$ModuleAdapter;->INJECTS:[Ljava/lang/String;

    .line 18
    new-array v0, v2, [Ljava/lang/Class;

    sput-object v0, Lcom/amazon/analytics/TailwindModule$$ModuleAdapter;->STATIC_INJECTIONS:[Ljava/lang/Class;

    .line 19
    new-array v0, v4, [Ljava/lang/Class;

    const-class v1, Lcom/amazon/android/dagger/application/ContextModule;

    aput-object v1, v0, v2

    const-class v1, Lcom/amazon/mas/client/featureconfig/FeatureConfigModule;

    aput-object v1, v0, v3

    sput-object v0, Lcom/amazon/analytics/TailwindModule$$ModuleAdapter;->INCLUDES:[Ljava/lang/Class;

    return-void
.end method

.method public constructor <init>()V
    .locals 8

    .prologue
    const/4 v4, 0x0

    .line 22
    const-class v1, Lcom/amazon/analytics/TailwindModule;

    sget-object v2, Lcom/amazon/analytics/TailwindModule$$ModuleAdapter;->INJECTS:[Ljava/lang/String;

    sget-object v3, Lcom/amazon/analytics/TailwindModule$$ModuleAdapter;->STATIC_INJECTIONS:[Ljava/lang/Class;

    sget-object v5, Lcom/amazon/analytics/TailwindModule$$ModuleAdapter;->INCLUDES:[Ljava/lang/Class;

    move-object v0, p0

    move v6, v4

    move v7, v4

    invoke-direct/range {v0 .. v7}, Ldagger/internal/ModuleAdapter;-><init>(Ljava/lang/Class;[Ljava/lang/String;[Ljava/lang/Class;Z[Ljava/lang/Class;ZZ)V

    .line 23
    return-void
.end method


# virtual methods
.method public getBindings(Ldagger/internal/BindingsGroup;Lcom/amazon/analytics/TailwindModule;)V
    .locals 2
    .param p1, "bindings"    # Ldagger/internal/BindingsGroup;
    .param p2, "module"    # Lcom/amazon/analytics/TailwindModule;

    .prologue
    .line 36
    const-string/jumbo v0, "com.amazon.analytics.TailwindActivityManager"

    new-instance v1, Lcom/amazon/analytics/TailwindModule$$ModuleAdapter$GetTailwindActivityManagerProvidesAdapter;

    invoke-direct {v1, p2}, Lcom/amazon/analytics/TailwindModule$$ModuleAdapter$GetTailwindActivityManagerProvidesAdapter;-><init>(Lcom/amazon/analytics/TailwindModule;)V

    invoke-virtual {p1, v0, v1}, Ldagger/internal/BindingsGroup;->contributeProvidesBinding(Ljava/lang/String;Ldagger/internal/ProvidesBinding;)Ldagger/internal/Binding;

    .line 37
    const-string/jumbo v0, "@javax.inject.Named(value=TailwindExecutorService)/java.util.concurrent.ScheduledExecutorService"

    new-instance v1, Lcom/amazon/analytics/TailwindModule$$ModuleAdapter$GetScheduledExecutorServiceProvidesAdapter;

    invoke-direct {v1, p2}, Lcom/amazon/analytics/TailwindModule$$ModuleAdapter$GetScheduledExecutorServiceProvidesAdapter;-><init>(Lcom/amazon/analytics/TailwindModule;)V

    invoke-virtual {p1, v0, v1}, Ldagger/internal/BindingsGroup;->contributeProvidesBinding(Ljava/lang/String;Ldagger/internal/ProvidesBinding;)Ldagger/internal/Binding;

    .line 38
    const-string/jumbo v0, "com.amazon.analytics.AnalyticsConfigurationImpl"

    new-instance v1, Lcom/amazon/analytics/TailwindModule$$ModuleAdapter$GetAnalyticsConfigurationImplProvidesAdapter;

    invoke-direct {v1, p2}, Lcom/amazon/analytics/TailwindModule$$ModuleAdapter$GetAnalyticsConfigurationImplProvidesAdapter;-><init>(Lcom/amazon/analytics/TailwindModule;)V

    invoke-virtual {p1, v0, v1}, Ldagger/internal/BindingsGroup;->contributeProvidesBinding(Ljava/lang/String;Ldagger/internal/ProvidesBinding;)Ldagger/internal/Binding;

    .line 39
    const-string/jumbo v0, "com.amazon.analytics.AnalyticsConfiguration"

    new-instance v1, Lcom/amazon/analytics/TailwindModule$$ModuleAdapter$GetAnalyticsConfigurationProvidesAdapter;

    invoke-direct {v1, p2}, Lcom/amazon/analytics/TailwindModule$$ModuleAdapter$GetAnalyticsConfigurationProvidesAdapter;-><init>(Lcom/amazon/analytics/TailwindModule;)V

    invoke-virtual {p1, v0, v1}, Ldagger/internal/BindingsGroup;->contributeProvidesBinding(Ljava/lang/String;Ldagger/internal/ProvidesBinding;)Ldagger/internal/Binding;

    .line 40
    const-string/jumbo v0, "com.amazon.device.analytics.events.EventRecorder"

    new-instance v1, Lcom/amazon/analytics/TailwindModule$$ModuleAdapter$GetEventRecorderProvidesAdapter;

    invoke-direct {v1, p2}, Lcom/amazon/analytics/TailwindModule$$ModuleAdapter$GetEventRecorderProvidesAdapter;-><init>(Lcom/amazon/analytics/TailwindModule;)V

    invoke-virtual {p1, v0, v1}, Ldagger/internal/BindingsGroup;->contributeProvidesBinding(Ljava/lang/String;Ldagger/internal/ProvidesBinding;)Ldagger/internal/Binding;

    .line 41
    const-string/jumbo v0, "com.amazon.analytics.session.PackageSessionBuilder"

    new-instance v1, Lcom/amazon/analytics/TailwindModule$$ModuleAdapter$GetPackageSessionBuilderProvidesAdapter;

    invoke-direct {v1, p2}, Lcom/amazon/analytics/TailwindModule$$ModuleAdapter$GetPackageSessionBuilderProvidesAdapter;-><init>(Lcom/amazon/analytics/TailwindModule;)V

    invoke-virtual {p1, v0, v1}, Ldagger/internal/BindingsGroup;->contributeProvidesBinding(Ljava/lang/String;Ldagger/internal/ProvidesBinding;)Ldagger/internal/Binding;

    .line 42
    const-string/jumbo v0, "com.amazon.analytics.session.SessionObserver"

    new-instance v1, Lcom/amazon/analytics/TailwindModule$$ModuleAdapter$GetSessionObserverProvidesAdapter;

    invoke-direct {v1, p2}, Lcom/amazon/analytics/TailwindModule$$ModuleAdapter$GetSessionObserverProvidesAdapter;-><init>(Lcom/amazon/analytics/TailwindModule;)V

    invoke-virtual {p1, v0, v1}, Ldagger/internal/BindingsGroup;->contributeProvidesBinding(Ljava/lang/String;Ldagger/internal/ProvidesBinding;)Ldagger/internal/Binding;

    .line 43
    const-string/jumbo v0, "com.amazon.analytics.session.PriorityQueue"

    new-instance v1, Lcom/amazon/analytics/TailwindModule$$ModuleAdapter$GetPriorityQueueProvidesAdapter;

    invoke-direct {v1, p2}, Lcom/amazon/analytics/TailwindModule$$ModuleAdapter$GetPriorityQueueProvidesAdapter;-><init>(Lcom/amazon/analytics/TailwindModule;)V

    invoke-virtual {p1, v0, v1}, Ldagger/internal/BindingsGroup;->contributeProvidesBinding(Ljava/lang/String;Ldagger/internal/ProvidesBinding;)Ldagger/internal/Binding;

    .line 44
    const-string/jumbo v0, "com.amazon.analytics.AnalyticsConfigurationInitializer"

    new-instance v1, Lcom/amazon/analytics/TailwindModule$$ModuleAdapter$GetAnalyticsConfigurationInitializerProvidesAdapter;

    invoke-direct {v1, p2}, Lcom/amazon/analytics/TailwindModule$$ModuleAdapter$GetAnalyticsConfigurationInitializerProvidesAdapter;-><init>(Lcom/amazon/analytics/TailwindModule;)V

    invoke-virtual {p1, v0, v1}, Ldagger/internal/BindingsGroup;->contributeProvidesBinding(Ljava/lang/String;Ldagger/internal/ProvidesBinding;)Ldagger/internal/Binding;

    .line 45
    return-void
.end method

.method public bridge synthetic getBindings(Ldagger/internal/BindingsGroup;Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ldagger/internal/BindingsGroup;
    .param p2, "x1"    # Ljava/lang/Object;

    .prologue
    .line 16
    check-cast p2, Lcom/amazon/analytics/TailwindModule;

    .end local p2    # "x1":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lcom/amazon/analytics/TailwindModule$$ModuleAdapter;->getBindings(Ldagger/internal/BindingsGroup;Lcom/amazon/analytics/TailwindModule;)V

    return-void
.end method

.method public newModule()Lcom/amazon/analytics/TailwindModule;
    .locals 1

    .prologue
    .line 27
    new-instance v0, Lcom/amazon/analytics/TailwindModule;

    invoke-direct {v0}, Lcom/amazon/analytics/TailwindModule;-><init>()V

    return-object v0
.end method

.method public bridge synthetic newModule()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 16
    invoke-virtual {p0}, Lcom/amazon/analytics/TailwindModule$$ModuleAdapter;->newModule()Lcom/amazon/analytics/TailwindModule;

    move-result-object v0

    return-object v0
.end method
