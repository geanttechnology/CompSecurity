.class public Lcom/amazon/retailsearch/android/ui/results/ProductViewModel;
.super Ljava/lang/Object;
.source "ProductViewModel.java"


# instance fields
.field private final product:Lcom/amazon/searchapp/retailsearch/model/Product;

.field private final productImageFactory:Lcom/amazon/retailsearch/android/ui/ImageRequestFactory;

.field private final resourceProvider:Lcom/amazon/ansel/fetch/ResourceProvider;


# direct methods
.method public constructor <init>(Lcom/amazon/searchapp/retailsearch/model/Product;Lcom/amazon/retailsearch/android/ui/ImageRequestFactory;Lcom/amazon/ansel/fetch/ResourceProvider;)V
    .locals 0
    .param p1, "product"    # Lcom/amazon/searchapp/retailsearch/model/Product;
    .param p2, "productImageFactory"    # Lcom/amazon/retailsearch/android/ui/ImageRequestFactory;
    .param p3, "resourceProvider"    # Lcom/amazon/ansel/fetch/ResourceProvider;

    .prologue
    .line 24
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 25
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/ProductViewModel;->product:Lcom/amazon/searchapp/retailsearch/model/Product;

    .line 26
    iput-object p2, p0, Lcom/amazon/retailsearch/android/ui/results/ProductViewModel;->productImageFactory:Lcom/amazon/retailsearch/android/ui/ImageRequestFactory;

    .line 27
    iput-object p3, p0, Lcom/amazon/retailsearch/android/ui/results/ProductViewModel;->resourceProvider:Lcom/amazon/ansel/fetch/ResourceProvider;

    .line 28
    return-void
.end method


# virtual methods
.method public getProduct()Lcom/amazon/searchapp/retailsearch/model/Product;
    .locals 1

    .prologue
    .line 35
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/ProductViewModel;->product:Lcom/amazon/searchapp/retailsearch/model/Product;

    return-object v0
.end method

.method public getProductImageFactory()Lcom/amazon/retailsearch/android/ui/ImageRequestFactory;
    .locals 1

    .prologue
    .line 43
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/ProductViewModel;->productImageFactory:Lcom/amazon/retailsearch/android/ui/ImageRequestFactory;

    return-object v0
.end method

.method public getResourceProvider()Lcom/amazon/ansel/fetch/ResourceProvider;
    .locals 1

    .prologue
    .line 51
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/ProductViewModel;->resourceProvider:Lcom/amazon/ansel/fetch/ResourceProvider;

    return-object v0
.end method
