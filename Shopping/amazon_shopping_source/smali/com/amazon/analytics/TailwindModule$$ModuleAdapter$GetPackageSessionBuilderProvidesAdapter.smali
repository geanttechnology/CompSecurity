.class public final Lcom/amazon/analytics/TailwindModule$$ModuleAdapter$GetPackageSessionBuilderProvidesAdapter;
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
    name = "GetPackageSessionBuilderProvidesAdapter"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ldagger/internal/ProvidesBinding",
        "<",
        "Lcom/amazon/analytics/session/PackageSessionBuilder;",
        ">;",
        "Ljavax/inject/Provider",
        "<",
        "Lcom/amazon/analytics/session/PackageSessionBuilder;",
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
    .line 289
    const-string/jumbo v0, "com.amazon.analytics.session.PackageSessionBuilder"

    const/4 v1, 0x1

    const-string/jumbo v2, "com.amazon.analytics.TailwindModule"

    const-string/jumbo v3, "getPackageSessionBuilder"

    invoke-direct {p0, v0, v1, v2, v3}, Ldagger/internal/ProvidesBinding;-><init>(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V

    .line 290
    iput-object p1, p0, Lcom/amazon/analytics/TailwindModule$$ModuleAdapter$GetPackageSessionBuilderProvidesAdapter;->module:Lcom/amazon/analytics/TailwindModule;

    .line 291
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/amazon/analytics/TailwindModule$$ModuleAdapter$GetPackageSessionBuilderProvidesAdapter;->setLibrary(Z)V

    .line 292
    return-void
.end method


# virtual methods
.method public get()Lcom/amazon/analytics/session/PackageSessionBuilder;
    .locals 1

    .prologue
    .line 300
    iget-object v0, p0, Lcom/amazon/analytics/TailwindModule$$ModuleAdapter$GetPackageSessionBuilderProvidesAdapter;->module:Lcom/amazon/analytics/TailwindModule;

    invoke-virtual {v0}, Lcom/amazon/analytics/TailwindModule;->getPackageSessionBuilder()Lcom/amazon/analytics/session/PackageSessionBuilder;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic get()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 284
    invoke-virtual {p0}, Lcom/amazon/analytics/TailwindModule$$ModuleAdapter$GetPackageSessionBuilderProvidesAdapter;->get()Lcom/amazon/analytics/session/PackageSessionBuilder;

    move-result-object v0

    return-object v0
.end method
