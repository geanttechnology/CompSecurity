.class public Lcom/amazon/retailsearch/android/ui/results/GridProduct;
.super Lcom/amazon/retailsearch/android/ui/results/ProductView;
.source "GridProduct.java"


# instance fields
.field private availability:Lcom/amazon/retailsearch/android/ui/results/views/messaging/Availability;

.field private byLine:Landroid/widget/TextView;

.field private column:I

.field private newerEditionAvailable:Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailable;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 45
    invoke-direct {p0, p1, p2}, Lcom/amazon/retailsearch/android/ui/results/ProductView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 46
    sget-object v0, Lcom/amazon/retailsearch/android/ui/results/ViewType;->GridView:Lcom/amazon/retailsearch/android/ui/results/ViewType;

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/GridProduct;->viewType:Lcom/amazon/retailsearch/android/ui/results/ViewType;

    .line 47
    return-void
.end method


# virtual methods
.method protected buildView()V
    .locals 5

    .prologue
    .line 92
    invoke-super {p0}, Lcom/amazon/retailsearch/android/ui/results/ProductView;->buildView()V

    .line 94
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/results/GridProduct;->product:Lcom/amazon/searchapp/retailsearch/model/Product;

    invoke-interface {v2}, Lcom/amazon/searchapp/retailsearch/model/Product;->getByLine()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 96
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/results/GridProduct;->byLine:Landroid/widget/TextView;

    const/16 v3, 0x8

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setVisibility(I)V

    .line 105
    :goto_0
    new-instance v2, Lcom/amazon/retailsearch/android/ui/results/views/messaging/AvailabilityModel$Builder;

    invoke-direct {v2}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/AvailabilityModel$Builder;-><init>()V

    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/results/GridProduct;->availabilityInfo:Lcom/amazon/searchapp/retailsearch/model/Availability;

    invoke-virtual {v2, v3}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/AvailabilityModel$Builder;->build(Lcom/amazon/searchapp/retailsearch/model/Availability;)Lcom/amazon/retailsearch/android/ui/results/views/messaging/AvailabilityModel;

    move-result-object v0

    .line 106
    .local v0, "availabilityModel":Lcom/amazon/retailsearch/android/ui/results/views/messaging/AvailabilityModel;
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/results/GridProduct;->availability:Lcom/amazon/retailsearch/android/ui/results/views/messaging/Availability;

    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/results/GridProduct;->viewType:Lcom/amazon/retailsearch/android/ui/results/ViewType;

    invoke-virtual {v2, v0, v3}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/Availability;->buildView(Lcom/amazon/retailsearch/android/ui/results/views/messaging/AvailabilityModel;Lcom/amazon/retailsearch/android/ui/results/ViewType;)V

    .line 109
    new-instance v2, Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailableModel$Builder;

    invoke-direct {v2}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailableModel$Builder;-><init>()V

    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/results/GridProduct;->product:Lcom/amazon/searchapp/retailsearch/model/Product;

    invoke-interface {v3}, Lcom/amazon/searchapp/retailsearch/model/Product;->getNewerVersion()Lcom/amazon/searchapp/retailsearch/model/NewerVersion;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/results/GridProduct;->product:Lcom/amazon/searchapp/retailsearch/model/Product;

    invoke-interface {v4}, Lcom/amazon/searchapp/retailsearch/model/Product;->getGroup()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailableModel$Builder;->build(Lcom/amazon/searchapp/retailsearch/model/NewerVersion;Ljava/lang/String;)Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailableModel;

    move-result-object v1

    .line 111
    .local v1, "newerEditionAvailableModel":Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailableModel;
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/results/GridProduct;->newerEditionAvailable:Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailable;

    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/results/GridProduct;->viewType:Lcom/amazon/retailsearch/android/ui/results/ViewType;

    invoke-virtual {v2, v1, v3}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailable;->buildView(Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailableModel;Lcom/amazon/retailsearch/android/ui/results/ViewType;)V

    .line 112
    return-void

    .line 100
    .end local v0    # "availabilityModel":Lcom/amazon/retailsearch/android/ui/results/views/messaging/AvailabilityModel;
    .end local v1    # "newerEditionAvailableModel":Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailableModel;
    :cond_0
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/results/GridProduct;->byLine:Landroid/widget/TextView;

    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/results/GridProduct;->product:Lcom/amazon/searchapp/retailsearch/model/Product;

    invoke-interface {v3}, Lcom/amazon/searchapp/retailsearch/model/Product;->getByLine()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 101
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/results/GridProduct;->byLine:Landroid/widget/TextView;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_0
.end method

.method public getColumn()I
    .locals 1

    .prologue
    .line 75
    iget v0, p0, Lcom/amazon/retailsearch/android/ui/results/GridProduct;->column:I

    return v0
.end method

.method protected init(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 52
    invoke-super {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/ProductView;->init(Landroid/content/Context;)V

    .line 53
    sget v0, Lcom/amazon/retailsearch/R$layout;->grid_product_items:I

    invoke-static {p1, v0, p0}, Lcom/amazon/retailsearch/android/ui/results/GridProduct;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    .line 54
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/GridProduct;->initProductElements()V

    .line 55
    return-void
.end method

.method protected initProductElements()V
    .locals 2

    .prologue
    .line 60
    invoke-super {p0}, Lcom/amazon/retailsearch/android/ui/results/ProductView;->initProductElements()V

    .line 62
    sget v0, Lcom/amazon/retailsearch/R$id;->rs_item_byline:I

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/GridProduct;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/GridProduct;->byLine:Landroid/widget/TextView;

    .line 64
    sget v0, Lcom/amazon/retailsearch/R$id;->rs_results_availability:I

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/GridProduct;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/amazon/retailsearch/android/ui/results/views/messaging/Availability;

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/GridProduct;->availability:Lcom/amazon/retailsearch/android/ui/results/views/messaging/Availability;

    .line 65
    sget v0, Lcom/amazon/retailsearch/R$id;->rs_results_newer_edition_available:I

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/GridProduct;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailable;

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/GridProduct;->newerEditionAvailable:Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailable;

    .line 66
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/GridProduct;->gestureListener:Lcom/amazon/retailsearch/android/ui/results/events/ProductGestureListener;

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/GridProduct;->newerEditionAvailable:Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailable;

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/android/ui/results/events/ProductGestureListener;->addTapTarget(Lcom/amazon/retailsearch/android/ui/results/views/InteractiveRetailSearchResultView;)V

    .line 67
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/GridProduct;->gestureListener:Lcom/amazon/retailsearch/android/ui/results/events/ProductGestureListener;

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/GridProduct;->twister:Lcom/amazon/retailsearch/android/ui/results/views/twister/Twister;

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/android/ui/results/events/ProductGestureListener;->addTapTarget(Lcom/amazon/retailsearch/android/ui/results/views/InteractiveRetailSearchResultView;)V

    .line 68
    return-void
.end method

.method public setColumn(I)V
    .locals 0
    .param p1, "column"    # I

    .prologue
    .line 83
    iput p1, p0, Lcom/amazon/retailsearch/android/ui/results/GridProduct;->column:I

    .line 84
    return-void
.end method
