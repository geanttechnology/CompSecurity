.class public final Lcom/amazon/retailsearch/di/RetailSearchInternalModule$$ModuleAdapter$ProvideRetailSearchDataProviderProvidesAdapter;
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
    name = "ProvideRetailSearchDataProviderProvidesAdapter"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ldagger/internal/ProvidesBinding",
        "<",
        "Lcom/amazon/retailsearch/data/IRetailSearchDataProvider;",
        ">;",
        "Ljavax/inject/Provider",
        "<",
        "Lcom/amazon/retailsearch/data/IRetailSearchDataProvider;",
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
    .line 60
    const-string/jumbo v0, "com.amazon.retailsearch.data.IRetailSearchDataProvider"

    const/4 v1, 0x1

    const-string/jumbo v2, "com.amazon.retailsearch.di.RetailSearchInternalModule"

    const-string/jumbo v3, "provideRetailSearchDataProvider"

    invoke-direct {p0, v0, v1, v2, v3}, Ldagger/internal/ProvidesBinding;-><init>(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V

    .line 61
    iput-object p1, p0, Lcom/amazon/retailsearch/di/RetailSearchInternalModule$$ModuleAdapter$ProvideRetailSearchDataProviderProvidesAdapter;->module:Lcom/amazon/retailsearch/di/RetailSearchInternalModule;

    .line 62
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/di/RetailSearchInternalModule$$ModuleAdapter$ProvideRetailSearchDataProviderProvidesAdapter;->setLibrary(Z)V

    .line 63
    return-void
.end method


# virtual methods
.method public get()Lcom/amazon/retailsearch/data/IRetailSearchDataProvider;
    .locals 1

    .prologue
    .line 71
    iget-object v0, p0, Lcom/amazon/retailsearch/di/RetailSearchInternalModule$$ModuleAdapter$ProvideRetailSearchDataProviderProvidesAdapter;->module:Lcom/amazon/retailsearch/di/RetailSearchInternalModule;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/di/RetailSearchInternalModule;->provideRetailSearchDataProvider()Lcom/amazon/retailsearch/data/IRetailSearchDataProvider;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic get()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 55
    invoke-virtual {p0}, Lcom/amazon/retailsearch/di/RetailSearchInternalModule$$ModuleAdapter$ProvideRetailSearchDataProviderProvidesAdapter;->get()Lcom/amazon/retailsearch/data/IRetailSearchDataProvider;

    move-result-object v0

    return-object v0
.end method
