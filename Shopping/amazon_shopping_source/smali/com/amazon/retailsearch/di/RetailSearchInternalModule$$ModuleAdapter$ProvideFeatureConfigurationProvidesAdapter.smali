.class public final Lcom/amazon/retailsearch/di/RetailSearchInternalModule$$ModuleAdapter$ProvideFeatureConfigurationProvidesAdapter;
.super Ldagger/internal/ProvidesBinding;
.source "RetailSearchInternalModule$$ModuleAdapter.java"

# interfaces
.implements Ljavax/inject/Provider;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/retailsearch/di/RetailSearchInternalModule$$ModuleAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "ProvideFeatureConfigurationProvidesAdapter"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ldagger/internal/ProvidesBinding",
        "<",
        "Lcom/amazon/retailsearch/android/api/experimentation/FeatureConfiguration;",
        ">;",
        "Ljavax/inject/Provider",
        "<",
        "Lcom/amazon/retailsearch/android/api/experimentation/FeatureConfiguration;",
        ">;"
    }
.end annotation


# instance fields
.field private final module:Lcom/amazon/retailsearch/di/RetailSearchInternalModule;


# direct methods
.method public constructor <init>(Lcom/amazon/retailsearch/di/RetailSearchInternalModule;)V
    .locals 4
    .param p1, "module"    # Lcom/amazon/retailsearch/di/RetailSearchInternalModule;

    .prologue
    const/4 v3, 0x0

    .line 395
    const-string/jumbo v0, "com.amazon.retailsearch.android.api.experimentation.FeatureConfiguration"

    const-string/jumbo v1, "com.amazon.retailsearch.di.RetailSearchInternalModule"

    const-string/jumbo v2, "provideFeatureConfiguration"

    invoke-direct {p0, v0, v3, v1, v2}, Ldagger/internal/ProvidesBinding;-><init>(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V

    .line 396
    iput-object p1, p0, Lcom/amazon/retailsearch/di/RetailSearchInternalModule$$ModuleAdapter$ProvideFeatureConfigurationProvidesAdapter;->module:Lcom/amazon/retailsearch/di/RetailSearchInternalModule;

    .line 397
    invoke-virtual {p0, v3}, Lcom/amazon/retailsearch/di/RetailSearchInternalModule$$ModuleAdapter$ProvideFeatureConfigurationProvidesAdapter;->setLibrary(Z)V

    .line 398
    return-void
.end method


# virtual methods
.method public get()Lcom/amazon/retailsearch/android/api/experimentation/FeatureConfiguration;
    .locals 1

    .prologue
    .line 406
    iget-object v0, p0, Lcom/amazon/retailsearch/di/RetailSearchInternalModule$$ModuleAdapter$ProvideFeatureConfigurationProvidesAdapter;->module:Lcom/amazon/retailsearch/di/RetailSearchInternalModule;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/di/RetailSearchInternalModule;->provideFeatureConfiguration()Lcom/amazon/retailsearch/android/api/experimentation/FeatureConfiguration;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic get()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 390
    invoke-virtual {p0}, Lcom/amazon/retailsearch/di/RetailSearchInternalModule$$ModuleAdapter$ProvideFeatureConfigurationProvidesAdapter;->get()Lcom/amazon/retailsearch/android/api/experimentation/FeatureConfiguration;

    move-result-object v0

    return-object v0
.end method
