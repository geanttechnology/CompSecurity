.class public Lcom/amazon/retailsearch/client/AndroidWebClientFactory;
.super Ljava/lang/Object;
.source "AndroidWebClientFactory.java"

# interfaces
.implements Lcom/amazon/searchapp/retailsearch/client/web/WebClientFactory;


# instance fields
.field featureConfig:Lcom/amazon/retailsearch/android/api/experimentation/FeatureConfiguration;
    .annotation runtime Ljavax/inject/Inject;
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 29
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 30
    invoke-static {p0}, Lcom/amazon/retailsearch/di/RetailSearchDaggerGraphController;->inject(Ljava/lang/Object;)V

    .line 31
    return-void
.end method


# virtual methods
.method public getWebClient()Lcom/amazon/searchapp/retailsearch/client/web/WebClient;
    .locals 3

    .prologue
    .line 39
    iget-object v0, p0, Lcom/amazon/retailsearch/client/AndroidWebClientFactory;->featureConfig:Lcom/amazon/retailsearch/android/api/experimentation/FeatureConfiguration;

    if-eqz v0, :cond_0

    const-string/jumbo v0, "T1"

    iget-object v1, p0, Lcom/amazon/retailsearch/client/AndroidWebClientFactory;->featureConfig:Lcom/amazon/retailsearch/android/api/experimentation/FeatureConfiguration;

    const-string/jumbo v2, "SX_Shop_Android_Web_Client_GTE_5.1"

    invoke-interface {v1, v2}, Lcom/amazon/retailsearch/android/api/experimentation/FeatureConfiguration;->getFeatureState(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 42
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/web/jnet/NetWebClient;

    invoke-direct {v0}, Lcom/amazon/searchapp/retailsearch/client/web/jnet/NetWebClient;-><init>()V

    .line 45
    :goto_0
    return-object v0

    :cond_0
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/web/apache40/ApacheWebClient;

    invoke-direct {v0}, Lcom/amazon/searchapp/retailsearch/client/web/apache40/ApacheWebClient;-><init>()V

    goto :goto_0
.end method
