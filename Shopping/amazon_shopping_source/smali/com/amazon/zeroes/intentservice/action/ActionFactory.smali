.class public Lcom/amazon/zeroes/intentservice/action/ActionFactory;
.super Ljava/lang/Object;
.source "ActionFactory.java"


# instance fields
.field private lazyCache:Ldagger/Lazy;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ldagger/Lazy",
            "<",
            "Lcom/amazon/zeroes/intentservice/persistence/ZeroesCache;",
            ">;"
        }
    .end annotation
.end field

.field private lazyDecorator:Ldagger/Lazy;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ldagger/Lazy",
            "<",
            "Lcom/amazon/zeroes/intentservice/ZeroesPurchaseRequestDecorator;",
            ">;"
        }
    .end annotation
.end field

.field private lazyMasDsClient:Ldagger/Lazy;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ldagger/Lazy",
            "<",
            "Lcom/amazon/mas/client/deviceservice/MasDsClient;",
            ">;"
        }
    .end annotation
.end field

.field private lazyWebHttpClient:Ldagger/Lazy;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ldagger/Lazy",
            "<",
            "Lcom/amazon/mas/client/http/WebHttpClient;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ldagger/Lazy",
            "<",
            "Lcom/amazon/mas/client/deviceservice/MasDsClient;",
            ">;",
            "Ldagger/Lazy",
            "<",
            "Lcom/amazon/mas/client/http/WebHttpClient;",
            ">;",
            "Ldagger/Lazy",
            "<",
            "Lcom/amazon/zeroes/intentservice/persistence/ZeroesCache;",
            ">;",
            "Ldagger/Lazy",
            "<",
            "Lcom/amazon/zeroes/intentservice/ZeroesPurchaseRequestDecorator;",
            ">;)V"
        }
    .end annotation

    .annotation runtime Ljavax/inject/Inject;
    .end annotation

    .prologue
    .line 53
    .local p1, "lazyMasDsClient":Ldagger/Lazy;, "Ldagger/Lazy<Lcom/amazon/mas/client/deviceservice/MasDsClient;>;"
    .local p2, "lazyWebHttpClient":Ldagger/Lazy;, "Ldagger/Lazy<Lcom/amazon/mas/client/http/WebHttpClient;>;"
    .local p3, "lazyCache":Ldagger/Lazy;, "Ldagger/Lazy<Lcom/amazon/zeroes/intentservice/persistence/ZeroesCache;>;"
    .local p4, "lazyDecorator":Ldagger/Lazy;, "Ldagger/Lazy<Lcom/amazon/zeroes/intentservice/ZeroesPurchaseRequestDecorator;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 55
    iput-object p1, p0, Lcom/amazon/zeroes/intentservice/action/ActionFactory;->lazyMasDsClient:Ldagger/Lazy;

    .line 56
    iput-object p2, p0, Lcom/amazon/zeroes/intentservice/action/ActionFactory;->lazyWebHttpClient:Ldagger/Lazy;

    .line 57
    iput-object p3, p0, Lcom/amazon/zeroes/intentservice/action/ActionFactory;->lazyCache:Ldagger/Lazy;

    .line 58
    iput-object p4, p0, Lcom/amazon/zeroes/intentservice/action/ActionFactory;->lazyDecorator:Ldagger/Lazy;

    .line 59
    return-void
.end method


# virtual methods
.method public getActionFromIntent(Landroid/content/Intent;)Lcom/amazon/zeroes/intentservice/action/ZeroesAction;
    .locals 5
    .param p1, "intent"    # Landroid/content/Intent;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 73
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    .line 74
    .local v0, "actionName":Ljava/lang/String;
    sget-object v1, Lcom/amazon/zeroes/intentservice/action/GetBalanceAction;->ACTION_REQUEST:Ljava/lang/String;

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 75
    new-instance v3, Lcom/amazon/zeroes/intentservice/action/GetBalanceAction;

    iget-object v1, p0, Lcom/amazon/zeroes/intentservice/action/ActionFactory;->lazyMasDsClient:Ldagger/Lazy;

    invoke-interface {v1}, Ldagger/Lazy;->get()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/mas/client/deviceservice/MasDsClient;

    iget-object v2, p0, Lcom/amazon/zeroes/intentservice/action/ActionFactory;->lazyCache:Ldagger/Lazy;

    invoke-interface {v2}, Ldagger/Lazy;->get()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/zeroes/intentservice/persistence/ZeroesCache;

    invoke-direct {v3, p1, v1, v2}, Lcom/amazon/zeroes/intentservice/action/GetBalanceAction;-><init>(Landroid/content/Intent;Lcom/amazon/mas/client/deviceservice/MasDsClient;Lcom/amazon/zeroes/intentservice/persistence/ZeroesCache;)V

    move-object v1, v3

    .line 92
    :goto_0
    return-object v1

    .line 76
    :cond_0
    sget-object v1, Lcom/amazon/zeroes/intentservice/action/GetBundleDetailsAction;->ACTION_REQUEST:Ljava/lang/String;

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 77
    new-instance v3, Lcom/amazon/zeroes/intentservice/action/GetBundleDetailsAction;

    iget-object v1, p0, Lcom/amazon/zeroes/intentservice/action/ActionFactory;->lazyMasDsClient:Ldagger/Lazy;

    invoke-interface {v1}, Ldagger/Lazy;->get()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/mas/client/deviceservice/MasDsClient;

    iget-object v2, p0, Lcom/amazon/zeroes/intentservice/action/ActionFactory;->lazyCache:Ldagger/Lazy;

    invoke-interface {v2}, Ldagger/Lazy;->get()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/zeroes/intentservice/persistence/ZeroesCache;

    invoke-direct {v3, p1, v1, v2}, Lcom/amazon/zeroes/intentservice/action/GetBundleDetailsAction;-><init>(Landroid/content/Intent;Lcom/amazon/mas/client/deviceservice/MasDsClient;Lcom/amazon/zeroes/intentservice/persistence/ZeroesCache;)V

    move-object v1, v3

    goto :goto_0

    .line 78
    :cond_1
    sget-object v1, Lcom/amazon/zeroes/intentservice/action/GetPreferencesAction;->ACTION_REQUEST:Ljava/lang/String;

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 79
    new-instance v3, Lcom/amazon/zeroes/intentservice/action/GetPreferencesAction;

    iget-object v1, p0, Lcom/amazon/zeroes/intentservice/action/ActionFactory;->lazyMasDsClient:Ldagger/Lazy;

    invoke-interface {v1}, Ldagger/Lazy;->get()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/mas/client/deviceservice/MasDsClient;

    iget-object v2, p0, Lcom/amazon/zeroes/intentservice/action/ActionFactory;->lazyCache:Ldagger/Lazy;

    invoke-interface {v2}, Ldagger/Lazy;->get()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/zeroes/intentservice/persistence/ZeroesCache;

    invoke-direct {v3, p1, v1, v2}, Lcom/amazon/zeroes/intentservice/action/GetPreferencesAction;-><init>(Landroid/content/Intent;Lcom/amazon/mas/client/deviceservice/MasDsClient;Lcom/amazon/zeroes/intentservice/persistence/ZeroesCache;)V

    move-object v1, v3

    goto :goto_0

    .line 80
    :cond_2
    sget-object v1, Lcom/amazon/zeroes/intentservice/action/SetPreferencesAction;->ACTION_REQUEST:Ljava/lang/String;

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 81
    new-instance v3, Lcom/amazon/zeroes/intentservice/action/SetPreferencesAction;

    iget-object v1, p0, Lcom/amazon/zeroes/intentservice/action/ActionFactory;->lazyMasDsClient:Ldagger/Lazy;

    invoke-interface {v1}, Ldagger/Lazy;->get()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/mas/client/deviceservice/MasDsClient;

    iget-object v2, p0, Lcom/amazon/zeroes/intentservice/action/ActionFactory;->lazyCache:Ldagger/Lazy;

    invoke-interface {v2}, Ldagger/Lazy;->get()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/zeroes/intentservice/persistence/ZeroesCache;

    invoke-direct {v3, p1, v1, v2}, Lcom/amazon/zeroes/intentservice/action/SetPreferencesAction;-><init>(Landroid/content/Intent;Lcom/amazon/mas/client/deviceservice/MasDsClient;Lcom/amazon/zeroes/intentservice/persistence/ZeroesCache;)V

    move-object v1, v3

    goto :goto_0

    .line 82
    :cond_3
    sget-object v1, Lcom/amazon/zeroes/intentservice/action/GetTaxPreviewAction;->ACTION_REQUEST:Ljava/lang/String;

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_4

    .line 83
    new-instance v2, Lcom/amazon/zeroes/intentservice/action/GetTaxPreviewAction;

    iget-object v1, p0, Lcom/amazon/zeroes/intentservice/action/ActionFactory;->lazyMasDsClient:Ldagger/Lazy;

    invoke-interface {v1}, Ldagger/Lazy;->get()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/mas/client/deviceservice/MasDsClient;

    invoke-direct {v2, p1, v1}, Lcom/amazon/zeroes/intentservice/action/GetTaxPreviewAction;-><init>(Landroid/content/Intent;Lcom/amazon/mas/client/deviceservice/MasDsClient;)V

    move-object v1, v2

    goto :goto_0

    .line 84
    :cond_4
    sget-object v1, Lcom/amazon/zeroes/intentservice/action/PurchaseBundleAction;->ACTION_REQUEST:Ljava/lang/String;

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_5

    .line 85
    new-instance v4, Lcom/amazon/zeroes/intentservice/action/PurchaseBundleAction;

    iget-object v1, p0, Lcom/amazon/zeroes/intentservice/action/ActionFactory;->lazyMasDsClient:Ldagger/Lazy;

    invoke-interface {v1}, Ldagger/Lazy;->get()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/mas/client/deviceservice/MasDsClient;

    iget-object v2, p0, Lcom/amazon/zeroes/intentservice/action/ActionFactory;->lazyCache:Ldagger/Lazy;

    invoke-interface {v2}, Ldagger/Lazy;->get()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/zeroes/intentservice/persistence/ZeroesCache;

    iget-object v3, p0, Lcom/amazon/zeroes/intentservice/action/ActionFactory;->lazyDecorator:Ldagger/Lazy;

    invoke-interface {v3}, Ldagger/Lazy;->get()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/amazon/zeroes/intentservice/ZeroesPurchaseRequestDecorator;

    invoke-direct {v4, p1, v1, v2, v3}, Lcom/amazon/zeroes/intentservice/action/PurchaseBundleAction;-><init>(Landroid/content/Intent;Lcom/amazon/mas/client/deviceservice/MasDsClient;Lcom/amazon/zeroes/intentservice/persistence/ZeroesCache;Lcom/amazon/zeroes/intentservice/ZeroesPurchaseRequestDecorator;)V

    move-object v1, v4

    goto/16 :goto_0

    .line 87
    :cond_5
    sget-object v1, Lcom/amazon/zeroes/intentservice/action/HttpGetAction;->ACTION_REQUEST:Ljava/lang/String;

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_6

    .line 88
    new-instance v2, Lcom/amazon/zeroes/intentservice/action/HttpGetAction;

    iget-object v1, p0, Lcom/amazon/zeroes/intentservice/action/ActionFactory;->lazyWebHttpClient:Ldagger/Lazy;

    invoke-interface {v1}, Ldagger/Lazy;->get()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/mas/client/http/WebHttpClient;

    invoke-direct {v2, p1, v1}, Lcom/amazon/zeroes/intentservice/action/HttpGetAction;-><init>(Landroid/content/Intent;Lcom/amazon/mas/client/http/WebHttpClient;)V

    move-object v1, v2

    goto/16 :goto_0

    .line 89
    :cond_6
    sget-object v1, Lcom/amazon/zeroes/intentservice/action/SubmitMetricAction;->ACTION_REQUEST:Ljava/lang/String;

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_7

    .line 90
    new-instance v1, Lcom/amazon/zeroes/intentservice/action/SubmitMetricAction;

    invoke-direct {v1, p1}, Lcom/amazon/zeroes/intentservice/action/SubmitMetricAction;-><init>(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 91
    :cond_7
    sget-object v1, Lcom/amazon/zeroes/intentservice/action/PopulateCacheAction;->ACTION_REQUEST:Ljava/lang/String;

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_8

    .line 92
    new-instance v2, Lcom/amazon/zeroes/intentservice/action/PopulateCacheAction;

    iget-object v1, p0, Lcom/amazon/zeroes/intentservice/action/ActionFactory;->lazyCache:Ldagger/Lazy;

    invoke-interface {v1}, Ldagger/Lazy;->get()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/zeroes/intentservice/persistence/ZeroesCache;

    invoke-direct {v2, p1, v1}, Lcom/amazon/zeroes/intentservice/action/PopulateCacheAction;-><init>(Landroid/content/Intent;Lcom/amazon/zeroes/intentservice/persistence/ZeroesCache;)V

    move-object v1, v2

    goto/16 :goto_0

    .line 95
    :cond_8
    new-instance v1, Ljava/lang/UnsupportedOperationException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "Unknown action: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v1
.end method
