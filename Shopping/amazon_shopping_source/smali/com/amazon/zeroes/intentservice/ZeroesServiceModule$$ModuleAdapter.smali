.class public final Lcom/amazon/zeroes/intentservice/ZeroesServiceModule$$ModuleAdapter;
.super Ldagger/internal/ModuleAdapter;
.source "ZeroesServiceModule$$ModuleAdapter.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/zeroes/intentservice/ZeroesServiceModule$$ModuleAdapter$ProvidePurchaseRequestDecoratorProvidesAdapter;,
        Lcom/amazon/zeroes/intentservice/ZeroesServiceModule$$ModuleAdapter$ProvideCacheProvidesAdapter;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ldagger/internal/ModuleAdapter",
        "<",
        "Lcom/amazon/zeroes/intentservice/ZeroesServiceModule;",
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
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 17
    new-array v0, v3, [Ljava/lang/String;

    const-string/jumbo v1, "members/com.amazon.zeroes.intentservice.ZeroesService"

    aput-object v1, v0, v2

    sput-object v0, Lcom/amazon/zeroes/intentservice/ZeroesServiceModule$$ModuleAdapter;->INJECTS:[Ljava/lang/String;

    .line 18
    new-array v0, v2, [Ljava/lang/Class;

    sput-object v0, Lcom/amazon/zeroes/intentservice/ZeroesServiceModule$$ModuleAdapter;->STATIC_INJECTIONS:[Ljava/lang/Class;

    .line 19
    const/4 v0, 0x3

    new-array v0, v0, [Ljava/lang/Class;

    const-class v1, Lcom/amazon/mas/client/deviceservice/MasDsClientModule;

    aput-object v1, v0, v2

    const-class v1, Lcom/amazon/mas/client/util/persistence/PersistenceModule;

    aput-object v1, v0, v3

    const/4 v1, 0x2

    const-class v2, Lcom/amazon/mas/client/http/WebHttpClientModule;

    aput-object v2, v0, v1

    sput-object v0, Lcom/amazon/zeroes/intentservice/ZeroesServiceModule$$ModuleAdapter;->INCLUDES:[Ljava/lang/Class;

    return-void
.end method

.method public constructor <init>()V
    .locals 8

    .prologue
    const/4 v4, 0x0

    .line 22
    const-class v1, Lcom/amazon/zeroes/intentservice/ZeroesServiceModule;

    sget-object v2, Lcom/amazon/zeroes/intentservice/ZeroesServiceModule$$ModuleAdapter;->INJECTS:[Ljava/lang/String;

    sget-object v3, Lcom/amazon/zeroes/intentservice/ZeroesServiceModule$$ModuleAdapter;->STATIC_INJECTIONS:[Ljava/lang/Class;

    sget-object v5, Lcom/amazon/zeroes/intentservice/ZeroesServiceModule$$ModuleAdapter;->INCLUDES:[Ljava/lang/Class;

    const/4 v6, 0x1

    move-object v0, p0

    move v7, v4

    invoke-direct/range {v0 .. v7}, Ldagger/internal/ModuleAdapter;-><init>(Ljava/lang/Class;[Ljava/lang/String;[Ljava/lang/Class;Z[Ljava/lang/Class;ZZ)V

    .line 23
    return-void
.end method


# virtual methods
.method public getBindings(Ldagger/internal/BindingsGroup;Lcom/amazon/zeroes/intentservice/ZeroesServiceModule;)V
    .locals 2
    .param p1, "bindings"    # Ldagger/internal/BindingsGroup;
    .param p2, "module"    # Lcom/amazon/zeroes/intentservice/ZeroesServiceModule;

    .prologue
    .line 36
    const-string/jumbo v0, "com.amazon.zeroes.intentservice.persistence.ZeroesCache"

    new-instance v1, Lcom/amazon/zeroes/intentservice/ZeroesServiceModule$$ModuleAdapter$ProvideCacheProvidesAdapter;

    invoke-direct {v1, p2}, Lcom/amazon/zeroes/intentservice/ZeroesServiceModule$$ModuleAdapter$ProvideCacheProvidesAdapter;-><init>(Lcom/amazon/zeroes/intentservice/ZeroesServiceModule;)V

    invoke-virtual {p1, v0, v1}, Ldagger/internal/BindingsGroup;->contributeProvidesBinding(Ljava/lang/String;Ldagger/internal/ProvidesBinding;)Ldagger/internal/Binding;

    .line 37
    const-string/jumbo v0, "com.amazon.zeroes.intentservice.ZeroesPurchaseRequestDecorator"

    new-instance v1, Lcom/amazon/zeroes/intentservice/ZeroesServiceModule$$ModuleAdapter$ProvidePurchaseRequestDecoratorProvidesAdapter;

    invoke-direct {v1, p2}, Lcom/amazon/zeroes/intentservice/ZeroesServiceModule$$ModuleAdapter$ProvidePurchaseRequestDecoratorProvidesAdapter;-><init>(Lcom/amazon/zeroes/intentservice/ZeroesServiceModule;)V

    invoke-virtual {p1, v0, v1}, Ldagger/internal/BindingsGroup;->contributeProvidesBinding(Ljava/lang/String;Ldagger/internal/ProvidesBinding;)Ldagger/internal/Binding;

    .line 38
    return-void
.end method

.method public bridge synthetic getBindings(Ldagger/internal/BindingsGroup;Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ldagger/internal/BindingsGroup;
    .param p2, "x1"    # Ljava/lang/Object;

    .prologue
    .line 16
    check-cast p2, Lcom/amazon/zeroes/intentservice/ZeroesServiceModule;

    .end local p2    # "x1":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lcom/amazon/zeroes/intentservice/ZeroesServiceModule$$ModuleAdapter;->getBindings(Ldagger/internal/BindingsGroup;Lcom/amazon/zeroes/intentservice/ZeroesServiceModule;)V

    return-void
.end method

.method public newModule()Lcom/amazon/zeroes/intentservice/ZeroesServiceModule;
    .locals 1

    .prologue
    .line 27
    new-instance v0, Lcom/amazon/zeroes/intentservice/ZeroesServiceModule;

    invoke-direct {v0}, Lcom/amazon/zeroes/intentservice/ZeroesServiceModule;-><init>()V

    return-object v0
.end method

.method public bridge synthetic newModule()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 16
    invoke-virtual {p0}, Lcom/amazon/zeroes/intentservice/ZeroesServiceModule$$ModuleAdapter;->newModule()Lcom/amazon/zeroes/intentservice/ZeroesServiceModule;

    move-result-object v0

    return-object v0
.end method
