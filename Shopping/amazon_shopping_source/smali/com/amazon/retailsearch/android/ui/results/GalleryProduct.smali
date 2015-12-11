.class public Lcom/amazon/retailsearch/android/ui/results/GalleryProduct;
.super Lcom/amazon/retailsearch/android/ui/results/ProductView;
.source "GalleryProduct.java"


# static fields
.field private static final log:Lcom/amazon/retailsearch/log/MessageLogger;


# instance fields
.field private availability:Lcom/amazon/retailsearch/android/ui/results/views/messaging/Availability;

.field private fastTrack:Lcom/amazon/retailsearch/android/ui/results/views/messaging/FastTrack;

.field featureConfig:Lcom/amazon/retailsearch/android/api/experimentation/FeatureConfiguration;
    .annotation runtime Ljavax/inject/Inject;
    .end annotation
.end field

.field private superSaverShipping:Lcom/amazon/retailsearch/android/ui/results/views/messaging/SuperSaverShipping;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 43
    const-class v0, Lcom/amazon/retailsearch/android/ui/results/GalleryProduct;

    invoke-static {v0}, Lcom/amazon/retailsearch/log/AppLog;->getLog(Ljava/lang/Class;)Lcom/amazon/retailsearch/log/MessageLogger;

    move-result-object v0

    sput-object v0, Lcom/amazon/retailsearch/android/ui/results/GalleryProduct;->log:Lcom/amazon/retailsearch/log/MessageLogger;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 53
    invoke-direct {p0, p1, p2}, Lcom/amazon/retailsearch/android/ui/results/ProductView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 54
    invoke-static {p0}, Lcom/amazon/retailsearch/di/RetailSearchDaggerGraphController;->inject(Ljava/lang/Object;)V

    .line 55
    sget-object v0, Lcom/amazon/retailsearch/android/ui/results/ViewType;->GalleryView:Lcom/amazon/retailsearch/android/ui/results/ViewType;

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/GalleryProduct;->viewType:Lcom/amazon/retailsearch/android/ui/results/ViewType;

    .line 56
    return-void
.end method


# virtual methods
.method protected buildView()V
    .locals 6

    .prologue
    .line 91
    invoke-super {p0}, Lcom/amazon/retailsearch/android/ui/results/ProductView;->buildView()V

    .line 95
    :try_start_0
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/results/GalleryProduct;->fastTrack:Lcom/amazon/retailsearch/android/ui/results/views/messaging/FastTrack;

    if-eqz v4, :cond_0

    .line 97
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/results/GalleryProduct;->fastTrack:Lcom/amazon/retailsearch/android/ui/results/views/messaging/FastTrack;

    const/16 v5, 0x8

    invoke-virtual {v4, v5}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/FastTrack;->setVisibility(I)V

    .line 100
    :cond_0
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/results/GalleryProduct;->superSaverShipping:Lcom/amazon/retailsearch/android/ui/results/views/messaging/SuperSaverShipping;

    if-eqz v4, :cond_1

    .line 102
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/results/GalleryProduct;->superSaverShipping:Lcom/amazon/retailsearch/android/ui/results/views/messaging/SuperSaverShipping;

    const/16 v5, 0x8

    invoke-virtual {v4, v5}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/SuperSaverShipping;->setVisibility(I)V

    .line 105
    :cond_1
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/results/GalleryProduct;->availability:Lcom/amazon/retailsearch/android/ui/results/views/messaging/Availability;

    if-eqz v4, :cond_2

    .line 107
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/results/GalleryProduct;->availability:Lcom/amazon/retailsearch/android/ui/results/views/messaging/Availability;

    const/16 v5, 0x8

    invoke-virtual {v4, v5}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/Availability;->setVisibility(I)V

    .line 110
    :cond_2
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/results/GalleryProduct;->featureConfig:Lcom/amazon/retailsearch/android/api/experimentation/FeatureConfiguration;

    const-string/jumbo v5, "SX_Shop_Android_Gallery_Messaging"

    invoke-interface {v4, v5}, Lcom/amazon/retailsearch/android/api/experimentation/FeatureConfiguration;->isFeatureActivated(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_5

    .line 113
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/results/GalleryProduct;->fastTrack:Lcom/amazon/retailsearch/android/ui/results/views/messaging/FastTrack;

    if-eqz v4, :cond_3

    .line 115
    new-instance v4, Lcom/amazon/retailsearch/android/ui/results/views/messaging/FastTrackModel$Builder;

    invoke-direct {v4}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/FastTrackModel$Builder;-><init>()V

    iget-object v5, p0, Lcom/amazon/retailsearch/android/ui/results/GalleryProduct;->availabilityInfo:Lcom/amazon/searchapp/retailsearch/model/Availability;

    invoke-virtual {v4, v5}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/FastTrackModel$Builder;->build(Lcom/amazon/searchapp/retailsearch/model/Availability;)Lcom/amazon/retailsearch/android/ui/results/views/messaging/FastTrackModel;

    move-result-object v2

    .line 116
    .local v2, "fastTrackModel":Lcom/amazon/retailsearch/android/ui/results/views/messaging/FastTrackModel;
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/results/GalleryProduct;->fastTrack:Lcom/amazon/retailsearch/android/ui/results/views/messaging/FastTrack;

    iget-object v5, p0, Lcom/amazon/retailsearch/android/ui/results/GalleryProduct;->viewType:Lcom/amazon/retailsearch/android/ui/results/ViewType;

    invoke-virtual {v4, v2, v5}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/FastTrack;->buildView(Lcom/amazon/retailsearch/android/ui/results/views/messaging/FastTrackModel;Lcom/amazon/retailsearch/android/ui/results/ViewType;)V

    .line 120
    .end local v2    # "fastTrackModel":Lcom/amazon/retailsearch/android/ui/results/views/messaging/FastTrackModel;
    :cond_3
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/results/GalleryProduct;->superSaverShipping:Lcom/amazon/retailsearch/android/ui/results/views/messaging/SuperSaverShipping;

    if-eqz v4, :cond_4

    .line 122
    new-instance v4, Lcom/amazon/retailsearch/android/ui/results/views/messaging/SuperSaverShippingModel$Builder;

    invoke-direct {v4}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/SuperSaverShippingModel$Builder;-><init>()V

    iget-object v5, p0, Lcom/amazon/retailsearch/android/ui/results/GalleryProduct;->shippingInfo:Lcom/amazon/searchapp/retailsearch/model/Shipping;

    invoke-virtual {v4, v5}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/SuperSaverShippingModel$Builder;->build(Lcom/amazon/searchapp/retailsearch/model/Shipping;)Lcom/amazon/retailsearch/android/ui/results/views/messaging/SuperSaverShippingModel;

    move-result-object v3

    .line 124
    .local v3, "superSaverShippingModel":Lcom/amazon/retailsearch/android/ui/results/views/messaging/SuperSaverShippingModel;
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/results/GalleryProduct;->superSaverShipping:Lcom/amazon/retailsearch/android/ui/results/views/messaging/SuperSaverShipping;

    iget-object v5, p0, Lcom/amazon/retailsearch/android/ui/results/GalleryProduct;->viewType:Lcom/amazon/retailsearch/android/ui/results/ViewType;

    invoke-virtual {v4, v3, v5}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/SuperSaverShipping;->buildView(Lcom/amazon/retailsearch/android/ui/results/views/messaging/SuperSaverShippingModel;Lcom/amazon/retailsearch/android/ui/results/ViewType;)V

    .line 128
    .end local v3    # "superSaverShippingModel":Lcom/amazon/retailsearch/android/ui/results/views/messaging/SuperSaverShippingModel;
    :cond_4
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/results/GalleryProduct;->availability:Lcom/amazon/retailsearch/android/ui/results/views/messaging/Availability;

    if-eqz v4, :cond_5

    .line 130
    new-instance v4, Lcom/amazon/retailsearch/android/ui/results/views/messaging/AvailabilityModel$Builder;

    invoke-direct {v4}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/AvailabilityModel$Builder;-><init>()V

    iget-object v5, p0, Lcom/amazon/retailsearch/android/ui/results/GalleryProduct;->availabilityInfo:Lcom/amazon/searchapp/retailsearch/model/Availability;

    invoke-virtual {v4, v5}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/AvailabilityModel$Builder;->build(Lcom/amazon/searchapp/retailsearch/model/Availability;)Lcom/amazon/retailsearch/android/ui/results/views/messaging/AvailabilityModel;

    move-result-object v0

    .line 131
    .local v0, "availabilityModel":Lcom/amazon/retailsearch/android/ui/results/views/messaging/AvailabilityModel;
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/results/GalleryProduct;->availability:Lcom/amazon/retailsearch/android/ui/results/views/messaging/Availability;

    iget-object v5, p0, Lcom/amazon/retailsearch/android/ui/results/GalleryProduct;->viewType:Lcom/amazon/retailsearch/android/ui/results/ViewType;

    invoke-virtual {v4, v0, v5}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/Availability;->buildView(Lcom/amazon/retailsearch/android/ui/results/views/messaging/AvailabilityModel;Lcom/amazon/retailsearch/android/ui/results/ViewType;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 139
    .end local v0    # "availabilityModel":Lcom/amazon/retailsearch/android/ui/results/views/messaging/AvailabilityModel;
    :cond_5
    :goto_0
    return-void

    .line 135
    :catch_0
    move-exception v1

    .line 137
    .local v1, "e":Ljava/lang/Exception;
    sget-object v4, Lcom/amazon/retailsearch/android/ui/results/GalleryProduct;->log:Lcom/amazon/retailsearch/log/MessageLogger;

    const-string/jumbo v5, "Error"

    invoke-interface {v4, v5, v1}, Lcom/amazon/retailsearch/log/MessageLogger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method protected init(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 60
    invoke-super {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/ProductView;->init(Landroid/content/Context;)V

    .line 61
    sget v0, Lcom/amazon/retailsearch/R$layout;->gallery_product_items:I

    invoke-static {p1, v0, p0}, Lcom/amazon/retailsearch/android/ui/results/GalleryProduct;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    .line 62
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/GalleryProduct;->initProductElements()V

    .line 63
    return-void
.end method

.method protected initProductElements()V
    .locals 3

    .prologue
    .line 68
    invoke-super {p0}, Lcom/amazon/retailsearch/android/ui/results/ProductView;->initProductElements()V

    .line 70
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/GalleryProduct;->gestureListener:Lcom/amazon/retailsearch/android/ui/results/events/ProductGestureListener;

    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/results/GalleryProduct;->twister:Lcom/amazon/retailsearch/android/ui/results/views/twister/Twister;

    invoke-virtual {v1, v2}, Lcom/amazon/retailsearch/android/ui/results/events/ProductGestureListener;->addTapTarget(Lcom/amazon/retailsearch/android/ui/results/views/InteractiveRetailSearchResultView;)V

    .line 75
    :try_start_0
    sget v1, Lcom/amazon/retailsearch/R$id;->rs_results_fast_track:I

    invoke-virtual {p0, v1}, Lcom/amazon/retailsearch/android/ui/results/GalleryProduct;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/amazon/retailsearch/android/ui/results/views/messaging/FastTrack;

    iput-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/GalleryProduct;->fastTrack:Lcom/amazon/retailsearch/android/ui/results/views/messaging/FastTrack;

    .line 76
    sget v1, Lcom/amazon/retailsearch/R$id;->rs_results_super_saver_shipping:I

    invoke-virtual {p0, v1}, Lcom/amazon/retailsearch/android/ui/results/GalleryProduct;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/amazon/retailsearch/android/ui/results/views/messaging/SuperSaverShipping;

    iput-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/GalleryProduct;->superSaverShipping:Lcom/amazon/retailsearch/android/ui/results/views/messaging/SuperSaverShipping;

    .line 77
    sget v1, Lcom/amazon/retailsearch/R$id;->rs_results_availability:I

    invoke-virtual {p0, v1}, Lcom/amazon/retailsearch/android/ui/results/GalleryProduct;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/amazon/retailsearch/android/ui/results/views/messaging/Availability;

    iput-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/GalleryProduct;->availability:Lcom/amazon/retailsearch/android/ui/results/views/messaging/Availability;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 83
    :goto_0
    return-void

    .line 79
    :catch_0
    move-exception v0

    .line 81
    .local v0, "e":Ljava/lang/Exception;
    sget-object v1, Lcom/amazon/retailsearch/android/ui/results/GalleryProduct;->log:Lcom/amazon/retailsearch/log/MessageLogger;

    const-string/jumbo v2, "Error"

    invoke-interface {v1, v2, v0}, Lcom/amazon/retailsearch/log/MessageLogger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method
