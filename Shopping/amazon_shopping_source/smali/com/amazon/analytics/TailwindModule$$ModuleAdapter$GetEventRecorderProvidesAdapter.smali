.class public final Lcom/amazon/analytics/TailwindModule$$ModuleAdapter$GetEventRecorderProvidesAdapter;
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
    name = "GetEventRecorderProvidesAdapter"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ldagger/internal/ProvidesBinding",
        "<",
        "Lcom/amazon/device/analytics/events/EventRecorder;",
        ">;",
        "Ljavax/inject/Provider",
        "<",
        "Lcom/amazon/device/analytics/events/EventRecorder;",
        ">;"
    }
.end annotation


# instance fields
.field private configImpl:Ldagger/internal/Binding;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ldagger/internal/Binding",
            "<",
            "Lcom/amazon/analytics/AnalyticsConfigurationImpl;",
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


# direct methods
.method public constructor <init>(Lcom/amazon/analytics/TailwindModule;)V
    .locals 4
    .param p1, "module"    # Lcom/amazon/analytics/TailwindModule;

    .prologue
    .line 241
    const-string/jumbo v0, "com.amazon.device.analytics.events.EventRecorder"

    const/4 v1, 0x1

    const-string/jumbo v2, "com.amazon.analytics.TailwindModule"

    const-string/jumbo v3, "getEventRecorder"

    invoke-direct {p0, v0, v1, v2, v3}, Ldagger/internal/ProvidesBinding;-><init>(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V

    .line 242
    iput-object p1, p0, Lcom/amazon/analytics/TailwindModule$$ModuleAdapter$GetEventRecorderProvidesAdapter;->module:Lcom/amazon/analytics/TailwindModule;

    .line 243
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/amazon/analytics/TailwindModule$$ModuleAdapter$GetEventRecorderProvidesAdapter;->setLibrary(Z)V

    .line 244
    return-void
.end method


# virtual methods
.method public attach(Ldagger/internal/Linker;)V
    .locals 3
    .param p1, "linker"    # Ldagger/internal/Linker;

    .prologue
    .line 253
    const-string/jumbo v0, "android.content.Context"

    const-class v1, Lcom/amazon/analytics/TailwindModule;

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v2

    invoke-virtual {p1, v0, v1, v2}, Ldagger/internal/Linker;->requestBinding(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/ClassLoader;)Ldagger/internal/Binding;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/analytics/TailwindModule$$ModuleAdapter$GetEventRecorderProvidesAdapter;->context:Ldagger/internal/Binding;

    .line 254
    const-string/jumbo v0, "com.amazon.analytics.AnalyticsConfigurationImpl"

    const-class v1, Lcom/amazon/analytics/TailwindModule;

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v2

    invoke-virtual {p1, v0, v1, v2}, Ldagger/internal/Linker;->requestBinding(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/ClassLoader;)Ldagger/internal/Binding;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/analytics/TailwindModule$$ModuleAdapter$GetEventRecorderProvidesAdapter;->configImpl:Ldagger/internal/Binding;

    .line 255
    return-void
.end method

.method public get()Lcom/amazon/device/analytics/events/EventRecorder;
    .locals 3

    .prologue
    .line 273
    iget-object v2, p0, Lcom/amazon/analytics/TailwindModule$$ModuleAdapter$GetEventRecorderProvidesAdapter;->module:Lcom/amazon/analytics/TailwindModule;

    iget-object v0, p0, Lcom/amazon/analytics/TailwindModule$$ModuleAdapter$GetEventRecorderProvidesAdapter;->context:Ldagger/internal/Binding;

    invoke-virtual {v0}, Ldagger/internal/Binding;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/content/Context;

    iget-object v1, p0, Lcom/amazon/analytics/TailwindModule$$ModuleAdapter$GetEventRecorderProvidesAdapter;->configImpl:Ldagger/internal/Binding;

    invoke-virtual {v1}, Ldagger/internal/Binding;->get()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/analytics/AnalyticsConfigurationImpl;

    invoke-virtual {v2, v0, v1}, Lcom/amazon/analytics/TailwindModule;->getEventRecorder(Landroid/content/Context;Lcom/amazon/analytics/AnalyticsConfigurationImpl;)Lcom/amazon/device/analytics/events/EventRecorder;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic get()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 234
    invoke-virtual {p0}, Lcom/amazon/analytics/TailwindModule$$ModuleAdapter$GetEventRecorderProvidesAdapter;->get()Lcom/amazon/device/analytics/events/EventRecorder;

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
    .line 263
    .local p1, "getBindings":Ljava/util/Set;, "Ljava/util/Set<Ldagger/internal/Binding<*>;>;"
    .local p2, "injectMembersBindings":Ljava/util/Set;, "Ljava/util/Set<Ldagger/internal/Binding<*>;>;"
    iget-object v0, p0, Lcom/amazon/analytics/TailwindModule$$ModuleAdapter$GetEventRecorderProvidesAdapter;->context:Ldagger/internal/Binding;

    invoke-interface {p1, v0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 264
    iget-object v0, p0, Lcom/amazon/analytics/TailwindModule$$ModuleAdapter$GetEventRecorderProvidesAdapter;->configImpl:Ldagger/internal/Binding;

    invoke-interface {p1, v0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 265
    return-void
.end method
