.class public Lcom/amazon/retailsearch/android/ui/results/layout/ListLayout;
.super Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;
.source "ListLayout.java"


# direct methods
.method public constructor <init>(Landroid/view/ViewGroup;IILcom/amazon/ansel/fetch/ResourceProvider;Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;)V
    .locals 9
    .param p1, "container"    # Landroid/view/ViewGroup;
    .param p2, "columnsPortrait"    # I
    .param p3, "columnsLandscape"    # I
    .param p4, "resourceProvider"    # Lcom/amazon/ansel/fetch/ResourceProvider;
    .param p5, "asinImpressionTracker"    # Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;

    .prologue
    .line 15
    sget v6, Lcom/amazon/retailsearch/R$dimen;->rs_results_image_width_list:I

    sget v7, Lcom/amazon/retailsearch/R$dimen;->rs_results_image_height_list:I

    sget v8, Lcom/amazon/retailsearch/R$integer;->config_rs_atf_product_count_list:I

    move-object v0, p0

    move-object v1, p1

    move v2, p2

    move v3, p3

    move-object v4, p4

    move-object v5, p5

    invoke-direct/range {v0 .. v8}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;-><init>(Landroid/view/ViewGroup;IILcom/amazon/ansel/fetch/ResourceProvider;Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;III)V

    .line 25
    return-void
.end method


# virtual methods
.method protected createProductCell(Lcom/amazon/searchapp/retailsearch/model/Product;)Lcom/amazon/retailsearch/android/ui/listadapter/ViewBuilderEntry;
    .locals 3
    .param p1, "product"    # Lcom/amazon/searchapp/retailsearch/model/Product;

    .prologue
    .line 29
    const/4 v0, 0x2

    const-class v1, Lcom/amazon/retailsearch/android/ui/results/ListProduct;

    invoke-virtual {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/layout/ListLayout;->createProductViewModel(Lcom/amazon/searchapp/retailsearch/model/Product;)Lcom/amazon/retailsearch/android/ui/results/ProductViewModel;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lcom/amazon/retailsearch/android/ui/results/layout/ListLayout;->createContentView(ILjava/lang/Class;Ljava/lang/Object;)Lcom/amazon/retailsearch/android/ui/listadapter/ModelViewEntry;

    move-result-object v0

    return-object v0
.end method
