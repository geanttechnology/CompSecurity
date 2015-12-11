.class public Lcom/amazon/zeroes/intentservice/ZeroesServiceModule;
.super Ljava/lang/Object;
.source "ZeroesServiceModule.java"


# annotations
.annotation runtime Ldagger/Module;
    includes = {
        Lcom/amazon/mas/client/deviceservice/MasDsClientModule;,
        Lcom/amazon/mas/client/util/persistence/PersistenceModule;,
        Lcom/amazon/mas/client/http/WebHttpClientModule;
    }
    injects = {
        Lcom/amazon/zeroes/intentservice/ZeroesService;
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 28
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public provideCache(Landroid/content/SharedPreferences;)Lcom/amazon/zeroes/intentservice/persistence/ZeroesCache;
    .locals 1
    .param p1, "sharedPreferences"    # Landroid/content/SharedPreferences;
    .annotation runtime Ldagger/Provides;
    .end annotation

    .prologue
    .line 37
    new-instance v0, Lcom/amazon/zeroes/intentservice/persistence/SharedPreferencesCache;

    invoke-direct {v0, p1}, Lcom/amazon/zeroes/intentservice/persistence/SharedPreferencesCache;-><init>(Landroid/content/SharedPreferences;)V

    return-object v0
.end method

.method public providePurchaseRequestDecorator(Lcom/amazon/zeroes/intentservice/DefaultZeroesPurchaseRequestDecorator;)Lcom/amazon/zeroes/intentservice/ZeroesPurchaseRequestDecorator;
    .locals 0
    .param p1, "decorator"    # Lcom/amazon/zeroes/intentservice/DefaultZeroesPurchaseRequestDecorator;
    .annotation runtime Ldagger/Provides;
    .end annotation

    .prologue
    .line 49
    return-object p1
.end method
