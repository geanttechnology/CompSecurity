.class Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$2;
.super Ljava/lang/Object;
.source "StackLayout.java"

# interfaces
.implements Lcom/amazon/ansel/fetch/tools/collection/Factory;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->getProductLoaders(Lcom/amazon/searchapp/retailsearch/model/Product;)Ljava/util/List;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/amazon/ansel/fetch/tools/collection/Factory",
        "<",
        "Lcom/amazon/ansel/fetch/ResourceLoader",
        "<*>;>;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

.field final synthetic val$product:Lcom/amazon/searchapp/retailsearch/model/Product;


# direct methods
.method constructor <init>(Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;Lcom/amazon/searchapp/retailsearch/model/Product;)V
    .locals 0

    .prologue
    .line 579
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$2;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    iput-object p2, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$2;->val$product:Lcom/amazon/searchapp/retailsearch/model/Product;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public get()Lcom/amazon/ansel/fetch/ResourceLoader;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/amazon/ansel/fetch/ResourceLoader",
            "<*>;"
        }
    .end annotation

    .prologue
    .line 582
    new-instance v0, Lcom/amazon/ansel/fetch/ImageLoader;

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$2;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    # getter for: Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->resourceProvider:Lcom/amazon/ansel/fetch/ResourceProvider;
    invoke-static {v1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->access$300(Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;)Lcom/amazon/ansel/fetch/ResourceProvider;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/ansel/fetch/ResourceProvider;->getContext()Lcom/amazon/ansel/fetch/LoaderContext;

    move-result-object v1

    const-wide/16 v2, 0x0

    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$2;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    # getter for: Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->productImageFactory:Lcom/amazon/retailsearch/android/ui/ImageRequestFactory;
    invoke-static {v4}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->access$400(Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;)Lcom/amazon/retailsearch/android/ui/ImageRequestFactory;

    move-result-object v4

    iget-object v5, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$2;->val$product:Lcom/amazon/searchapp/retailsearch/model/Product;

    invoke-interface {v5}, Lcom/amazon/searchapp/retailsearch/model/Product;->getImage()Lcom/amazon/searchapp/retailsearch/model/Image;

    move-result-object v5

    invoke-interface {v5}, Lcom/amazon/searchapp/retailsearch/model/Image;->getUrl()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v4, v5}, Lcom/amazon/retailsearch/android/ui/ImageRequestFactory;->fromUrl(Ljava/lang/String;)Lcom/amazon/ansel/fetch/ImageRequest;

    move-result-object v4

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/amazon/ansel/fetch/ImageLoader;-><init>(Lcom/amazon/ansel/fetch/LoaderContext;JLcom/amazon/ansel/fetch/ImageRequest;)V

    return-object v0
.end method

.method public bridge synthetic get()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 579
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$2;->get()Lcom/amazon/ansel/fetch/ResourceLoader;

    move-result-object v0

    return-object v0
.end method
