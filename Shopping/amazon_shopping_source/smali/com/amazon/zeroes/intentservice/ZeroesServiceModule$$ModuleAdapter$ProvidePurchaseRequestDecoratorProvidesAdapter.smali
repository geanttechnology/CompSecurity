.class public final Lcom/amazon/zeroes/intentservice/ZeroesServiceModule$$ModuleAdapter$ProvidePurchaseRequestDecoratorProvidesAdapter;
.super Ldagger/internal/ProvidesBinding;
.source "ZeroesServiceModule$$ModuleAdapter.java"

# interfaces
.implements Ljavax/inject/Provider;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/zeroes/intentservice/ZeroesServiceModule$$ModuleAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "ProvidePurchaseRequestDecoratorProvidesAdapter"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ldagger/internal/ProvidesBinding",
        "<",
        "Lcom/amazon/zeroes/intentservice/ZeroesPurchaseRequestDecorator;",
        ">;",
        "Ljavax/inject/Provider",
        "<",
        "Lcom/amazon/zeroes/intentservice/ZeroesPurchaseRequestDecorator;",
        ">;"
    }
.end annotation


# instance fields
.field private decorator:Ldagger/internal/Binding;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ldagger/internal/Binding",
            "<",
            "Lcom/amazon/zeroes/intentservice/DefaultZeroesPurchaseRequestDecorator;",
            ">;"
        }
    .end annotation
.end field

.field private final module:Lcom/amazon/zeroes/intentservice/ZeroesServiceModule;


# direct methods
.method public constructor <init>(Lcom/amazon/zeroes/intentservice/ZeroesServiceModule;)V
    .locals 4
    .param p1, "module"    # Lcom/amazon/zeroes/intentservice/ZeroesServiceModule;

    .prologue
    const/4 v3, 0x0

    .line 106
    const-string/jumbo v0, "com.amazon.zeroes.intentservice.ZeroesPurchaseRequestDecorator"

    const-string/jumbo v1, "com.amazon.zeroes.intentservice.ZeroesServiceModule"

    const-string/jumbo v2, "providePurchaseRequestDecorator"

    invoke-direct {p0, v0, v3, v1, v2}, Ldagger/internal/ProvidesBinding;-><init>(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V

    .line 107
    iput-object p1, p0, Lcom/amazon/zeroes/intentservice/ZeroesServiceModule$$ModuleAdapter$ProvidePurchaseRequestDecoratorProvidesAdapter;->module:Lcom/amazon/zeroes/intentservice/ZeroesServiceModule;

    .line 108
    invoke-virtual {p0, v3}, Lcom/amazon/zeroes/intentservice/ZeroesServiceModule$$ModuleAdapter$ProvidePurchaseRequestDecoratorProvidesAdapter;->setLibrary(Z)V

    .line 109
    return-void
.end method


# virtual methods
.method public attach(Ldagger/internal/Linker;)V
    .locals 3
    .param p1, "linker"    # Ldagger/internal/Linker;

    .prologue
    .line 118
    const-string/jumbo v0, "com.amazon.zeroes.intentservice.DefaultZeroesPurchaseRequestDecorator"

    const-class v1, Lcom/amazon/zeroes/intentservice/ZeroesServiceModule;

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v2

    invoke-virtual {p1, v0, v1, v2}, Ldagger/internal/Linker;->requestBinding(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/ClassLoader;)Ldagger/internal/Binding;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/zeroes/intentservice/ZeroesServiceModule$$ModuleAdapter$ProvidePurchaseRequestDecoratorProvidesAdapter;->decorator:Ldagger/internal/Binding;

    .line 119
    return-void
.end method

.method public get()Lcom/amazon/zeroes/intentservice/ZeroesPurchaseRequestDecorator;
    .locals 2

    .prologue
    .line 136
    iget-object v1, p0, Lcom/amazon/zeroes/intentservice/ZeroesServiceModule$$ModuleAdapter$ProvidePurchaseRequestDecoratorProvidesAdapter;->module:Lcom/amazon/zeroes/intentservice/ZeroesServiceModule;

    iget-object v0, p0, Lcom/amazon/zeroes/intentservice/ZeroesServiceModule$$ModuleAdapter$ProvidePurchaseRequestDecoratorProvidesAdapter;->decorator:Ldagger/internal/Binding;

    invoke-virtual {v0}, Ldagger/internal/Binding;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/zeroes/intentservice/DefaultZeroesPurchaseRequestDecorator;

    invoke-virtual {v1, v0}, Lcom/amazon/zeroes/intentservice/ZeroesServiceModule;->providePurchaseRequestDecorator(Lcom/amazon/zeroes/intentservice/DefaultZeroesPurchaseRequestDecorator;)Lcom/amazon/zeroes/intentservice/ZeroesPurchaseRequestDecorator;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic get()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 100
    invoke-virtual {p0}, Lcom/amazon/zeroes/intentservice/ZeroesServiceModule$$ModuleAdapter$ProvidePurchaseRequestDecoratorProvidesAdapter;->get()Lcom/amazon/zeroes/intentservice/ZeroesPurchaseRequestDecorator;

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
    .line 127
    .local p1, "getBindings":Ljava/util/Set;, "Ljava/util/Set<Ldagger/internal/Binding<*>;>;"
    .local p2, "injectMembersBindings":Ljava/util/Set;, "Ljava/util/Set<Ldagger/internal/Binding<*>;>;"
    iget-object v0, p0, Lcom/amazon/zeroes/intentservice/ZeroesServiceModule$$ModuleAdapter$ProvidePurchaseRequestDecoratorProvidesAdapter;->decorator:Ldagger/internal/Binding;

    invoke-interface {p1, v0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 128
    return-void
.end method
