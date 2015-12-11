.class public final Lcom/amazon/retailsearch/data/RetailSearchDataProvider$$InjectAdapter;
.super Ldagger/internal/Binding;
.source "RetailSearchDataProvider$$InjectAdapter.java"

# interfaces
.implements Ldagger/MembersInjector;
.implements Ljavax/inject/Provider;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ldagger/internal/Binding",
        "<",
        "Lcom/amazon/retailsearch/data/RetailSearchDataProvider;",
        ">;",
        "Ldagger/MembersInjector",
        "<",
        "Lcom/amazon/retailsearch/data/RetailSearchDataProvider;",
        ">;",
        "Ljavax/inject/Provider",
        "<",
        "Lcom/amazon/retailsearch/data/RetailSearchDataProvider;",
        ">;"
    }
.end annotation


# instance fields
.field private featureConfig:Ldagger/internal/Binding;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ldagger/internal/Binding",
            "<",
            "Lcom/amazon/retailsearch/android/api/experimentation/FeatureConfiguration;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 4

    .prologue
    .line 28
    const-string/jumbo v0, "com.amazon.retailsearch.data.RetailSearchDataProvider"

    const-string/jumbo v1, "members/com.amazon.retailsearch.data.RetailSearchDataProvider"

    const/4 v2, 0x0

    const-class v3, Lcom/amazon/retailsearch/data/RetailSearchDataProvider;

    invoke-direct {p0, v0, v1, v2, v3}, Ldagger/internal/Binding;-><init>(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Object;)V

    .line 29
    return-void
.end method


# virtual methods
.method public attach(Ldagger/internal/Linker;)V
    .locals 3
    .param p1, "linker"    # Ldagger/internal/Linker;

    .prologue
    .line 38
    const-string/jumbo v0, "com.amazon.retailsearch.android.api.experimentation.FeatureConfiguration"

    const-class v1, Lcom/amazon/retailsearch/data/RetailSearchDataProvider;

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v2

    invoke-virtual {p1, v0, v1, v2}, Ldagger/internal/Linker;->requestBinding(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/ClassLoader;)Ldagger/internal/Binding;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/retailsearch/data/RetailSearchDataProvider$$InjectAdapter;->featureConfig:Ldagger/internal/Binding;

    .line 39
    return-void
.end method

.method public get()Lcom/amazon/retailsearch/data/RetailSearchDataProvider;
    .locals 1

    .prologue
    .line 56
    new-instance v0, Lcom/amazon/retailsearch/data/RetailSearchDataProvider;

    invoke-direct {v0}, Lcom/amazon/retailsearch/data/RetailSearchDataProvider;-><init>()V

    .line 57
    .local v0, "result":Lcom/amazon/retailsearch/data/RetailSearchDataProvider;
    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/data/RetailSearchDataProvider$$InjectAdapter;->injectMembers(Lcom/amazon/retailsearch/data/RetailSearchDataProvider;)V

    .line 58
    return-object v0
.end method

.method public bridge synthetic get()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 23
    invoke-virtual {p0}, Lcom/amazon/retailsearch/data/RetailSearchDataProvider$$InjectAdapter;->get()Lcom/amazon/retailsearch/data/RetailSearchDataProvider;

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
    .line 47
    .local p1, "getBindings":Ljava/util/Set;, "Ljava/util/Set<Ldagger/internal/Binding<*>;>;"
    .local p2, "injectMembersBindings":Ljava/util/Set;, "Ljava/util/Set<Ldagger/internal/Binding<*>;>;"
    iget-object v0, p0, Lcom/amazon/retailsearch/data/RetailSearchDataProvider$$InjectAdapter;->featureConfig:Ldagger/internal/Binding;

    invoke-interface {p2, v0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 48
    return-void
.end method

.method public injectMembers(Lcom/amazon/retailsearch/data/RetailSearchDataProvider;)V
    .locals 1
    .param p1, "object"    # Lcom/amazon/retailsearch/data/RetailSearchDataProvider;

    .prologue
    .line 67
    iget-object v0, p0, Lcom/amazon/retailsearch/data/RetailSearchDataProvider$$InjectAdapter;->featureConfig:Ldagger/internal/Binding;

    invoke-virtual {v0}, Ldagger/internal/Binding;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/retailsearch/android/api/experimentation/FeatureConfiguration;

    iput-object v0, p1, Lcom/amazon/retailsearch/data/RetailSearchDataProvider;->featureConfig:Lcom/amazon/retailsearch/android/api/experimentation/FeatureConfiguration;

    .line 68
    return-void
.end method

.method public bridge synthetic injectMembers(Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 23
    check-cast p1, Lcom/amazon/retailsearch/data/RetailSearchDataProvider;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/amazon/retailsearch/data/RetailSearchDataProvider$$InjectAdapter;->injectMembers(Lcom/amazon/retailsearch/data/RetailSearchDataProvider;)V

    return-void
.end method
