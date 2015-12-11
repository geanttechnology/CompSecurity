.class public final Lcom/amazon/analytics/TailwindModule$$ModuleAdapter$GetScheduledExecutorServiceProvidesAdapter;
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
    name = "GetScheduledExecutorServiceProvidesAdapter"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ldagger/internal/ProvidesBinding",
        "<",
        "Ljava/util/concurrent/ScheduledExecutorService;",
        ">;",
        "Ljavax/inject/Provider",
        "<",
        "Ljava/util/concurrent/ScheduledExecutorService;",
        ">;"
    }
.end annotation


# instance fields
.field private final module:Lcom/amazon/analytics/TailwindModule;


# direct methods
.method public constructor <init>(Lcom/amazon/analytics/TailwindModule;)V
    .locals 4
    .param p1, "module"    # Lcom/amazon/analytics/TailwindModule;

    .prologue
    .line 109
    const-string/jumbo v0, "@javax.inject.Named(value=TailwindExecutorService)/java.util.concurrent.ScheduledExecutorService"

    const/4 v1, 0x1

    const-string/jumbo v2, "com.amazon.analytics.TailwindModule"

    const-string/jumbo v3, "getScheduledExecutorService"

    invoke-direct {p0, v0, v1, v2, v3}, Ldagger/internal/ProvidesBinding;-><init>(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V

    .line 110
    iput-object p1, p0, Lcom/amazon/analytics/TailwindModule$$ModuleAdapter$GetScheduledExecutorServiceProvidesAdapter;->module:Lcom/amazon/analytics/TailwindModule;

    .line 111
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/amazon/analytics/TailwindModule$$ModuleAdapter$GetScheduledExecutorServiceProvidesAdapter;->setLibrary(Z)V

    .line 112
    return-void
.end method


# virtual methods
.method public bridge synthetic get()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 104
    invoke-virtual {p0}, Lcom/amazon/analytics/TailwindModule$$ModuleAdapter$GetScheduledExecutorServiceProvidesAdapter;->get()Ljava/util/concurrent/ScheduledExecutorService;

    move-result-object v0

    return-object v0
.end method

.method public get()Ljava/util/concurrent/ScheduledExecutorService;
    .locals 1

    .prologue
    .line 120
    iget-object v0, p0, Lcom/amazon/analytics/TailwindModule$$ModuleAdapter$GetScheduledExecutorServiceProvidesAdapter;->module:Lcom/amazon/analytics/TailwindModule;

    invoke-virtual {v0}, Lcom/amazon/analytics/TailwindModule;->getScheduledExecutorService()Ljava/util/concurrent/ScheduledExecutorService;

    move-result-object v0

    return-object v0
.end method
