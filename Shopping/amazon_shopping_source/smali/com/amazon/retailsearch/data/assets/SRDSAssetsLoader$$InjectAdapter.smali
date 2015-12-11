.class public final Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader$$InjectAdapter;
.super Ldagger/internal/Binding;
.source "SRDSAssetsLoader$$InjectAdapter.java"

# interfaces
.implements Ldagger/MembersInjector;
.implements Ljavax/inject/Provider;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ldagger/internal/Binding",
        "<",
        "Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;",
        ">;",
        "Ldagger/MembersInjector",
        "<",
        "Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;",
        ">;",
        "Ljavax/inject/Provider",
        "<",
        "Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;",
        ">;"
    }
.end annotation


# instance fields
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

.field private parentResourceProvider:Ldagger/internal/Binding;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ldagger/internal/Binding",
            "<",
            "Lcom/amazon/ansel/fetch/ResourceProvider;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 4

    .prologue
    .line 30
    const-string/jumbo v0, "com.amazon.retailsearch.data.assets.SRDSAssetsLoader"

    const-string/jumbo v1, "members/com.amazon.retailsearch.data.assets.SRDSAssetsLoader"

    const/4 v2, 0x0

    const-class v3, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;

    invoke-direct {p0, v0, v1, v2, v3}, Ldagger/internal/Binding;-><init>(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Object;)V

    .line 31
    return-void
.end method


# virtual methods
.method public attach(Ldagger/internal/Linker;)V
    .locals 3
    .param p1, "linker"    # Ldagger/internal/Linker;

    .prologue
    .line 40
    const-string/jumbo v0, "com.amazon.ansel.fetch.ResourceProvider"

    const-class v1, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v2

    invoke-virtual {p1, v0, v1, v2}, Ldagger/internal/Linker;->requestBinding(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/ClassLoader;)Ldagger/internal/Binding;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader$$InjectAdapter;->parentResourceProvider:Ldagger/internal/Binding;

    .line 41
    const-string/jumbo v0, "com.amazon.retailsearch.android.api.experimentation.FeatureConfiguration"

    const-class v1, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v2

    invoke-virtual {p1, v0, v1, v2}, Ldagger/internal/Linker;->requestBinding(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/ClassLoader;)Ldagger/internal/Binding;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader$$InjectAdapter;->featureConfig:Ldagger/internal/Binding;

    .line 42
    const-string/jumbo v0, "android.content.Context"

    const-class v1, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v2

    invoke-virtual {p1, v0, v1, v2}, Ldagger/internal/Linker;->requestBinding(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/ClassLoader;)Ldagger/internal/Binding;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader$$InjectAdapter;->context:Ldagger/internal/Binding;

    .line 43
    return-void
.end method

.method public get()Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;
    .locals 1

    .prologue
    .line 62
    new-instance v0, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;

    invoke-direct {v0}, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;-><init>()V

    .line 63
    .local v0, "result":Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;
    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader$$InjectAdapter;->injectMembers(Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;)V

    .line 64
    return-object v0
.end method

.method public bridge synthetic get()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 23
    invoke-virtual {p0}, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader$$InjectAdapter;->get()Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;

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
    .line 51
    .local p1, "getBindings":Ljava/util/Set;, "Ljava/util/Set<Ldagger/internal/Binding<*>;>;"
    .local p2, "injectMembersBindings":Ljava/util/Set;, "Ljava/util/Set<Ldagger/internal/Binding<*>;>;"
    iget-object v0, p0, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader$$InjectAdapter;->parentResourceProvider:Ldagger/internal/Binding;

    invoke-interface {p2, v0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 52
    iget-object v0, p0, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader$$InjectAdapter;->featureConfig:Ldagger/internal/Binding;

    invoke-interface {p2, v0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 53
    iget-object v0, p0, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader$$InjectAdapter;->context:Ldagger/internal/Binding;

    invoke-interface {p2, v0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 54
    return-void
.end method

.method public injectMembers(Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;)V
    .locals 1
    .param p1, "object"    # Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;

    .prologue
    .line 73
    iget-object v0, p0, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader$$InjectAdapter;->parentResourceProvider:Ldagger/internal/Binding;

    invoke-virtual {v0}, Ldagger/internal/Binding;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/ansel/fetch/ResourceProvider;

    iput-object v0, p1, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;->parentResourceProvider:Lcom/amazon/ansel/fetch/ResourceProvider;

    .line 74
    iget-object v0, p0, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader$$InjectAdapter;->featureConfig:Ldagger/internal/Binding;

    invoke-virtual {v0}, Ldagger/internal/Binding;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/retailsearch/android/api/experimentation/FeatureConfiguration;

    iput-object v0, p1, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;->featureConfig:Lcom/amazon/retailsearch/android/api/experimentation/FeatureConfiguration;

    .line 75
    iget-object v0, p0, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader$$InjectAdapter;->context:Ldagger/internal/Binding;

    invoke-virtual {v0}, Ldagger/internal/Binding;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/content/Context;

    iput-object v0, p1, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;->context:Landroid/content/Context;

    .line 76
    return-void
.end method

.method public bridge synthetic injectMembers(Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 23
    check-cast p1, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader$$InjectAdapter;->injectMembers(Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;)V

    return-void
.end method
