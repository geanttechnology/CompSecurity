.class public abstract Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;
.super Ljava/lang/Object;
.source "StackLayout.java"

# interfaces
.implements Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayout;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$AsinVisibilityReporter;,
        Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$LoaderScrollListener;,
        Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$ScrollListener;,
        Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$MainPosition;,
        Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$MainElement;,
        Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$SectionIndex;,
        Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$Listener;
    }
.end annotation


# instance fields
.field private adapter:Lcom/amazon/retailsearch/android/ui/listadapter/GeneratorAdapter;

.field private asinGroupCount:I

.field private final asinImpressionTracker:Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;

.field private asinVisibilityReporter:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$AsinVisibilityReporter;

.field private atfImageListeners:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/ansel/fetch/ResourceListener",
            "<",
            "Landroid/graphics/Bitmap;",
            ">;>;"
        }
    .end annotation
.end field

.field private final atfProductCount:I

.field private columns:I

.field private final columnsLandscape:I

.field private final columnsPortrait:I

.field private final container:Landroid/view/ViewGroup;

.field private enabled:Z

.field private final listener:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$Listener;

.field protected final loaderScrollListener:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$LoaderScrollListener;

.field private final minRowSize:I

.field private modified:Z

.field private orientation:I

.field private prevState:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;

.field private productImageFactory:Lcom/amazon/retailsearch/android/ui/ImageRequestFactory;

.field private final productImageSize:Landroid/graphics/Point;

.field private progressBar:Landroid/widget/LinearLayout;

.field private final resourceProvider:Lcom/amazon/ansel/fetch/ResourceProvider;

.field protected results:Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;

.field private retailSearchLogger:Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

.field private final scrollListener:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$ScrollListener;

.field searchDataSource:Lcom/amazon/retailsearch/interaction/SearchDataSource;
    .annotation runtime Ljavax/inject/Inject;
    .end annotation
.end field

.field protected stackView:Lcom/amazon/retailsearch/android/ui/results/layout/StackView;

.field private state:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;

.field userInteractionListener:Lcom/amazon/retailsearch/interaction/UserInteractionListener;
    .annotation runtime Ljavax/inject/Inject;
    .end annotation
.end field


# direct methods
.method private constructor <init>(Landroid/view/ViewGroup;IIILcom/amazon/ansel/fetch/ResourceProvider;Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;Landroid/graphics/Point;I)V
    .locals 2
    .param p1, "container"    # Landroid/view/ViewGroup;
    .param p2, "columns"    # I
    .param p3, "columnsLandscape"    # I
    .param p4, "minRowSize"    # I
    .param p5, "resourceProvider"    # Lcom/amazon/ansel/fetch/ResourceProvider;
    .param p6, "asinImpressionTracker"    # Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;
    .param p7, "productImageSize"    # Landroid/graphics/Point;
    .param p8, "atfProductCount"    # I

    .prologue
    const/4 v1, 0x0

    .line 144
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 87
    new-instance v0, Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;

    invoke-direct {v0}, Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;-><init>()V

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->results:Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;

    .line 89
    new-instance v0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$Listener;

    invoke-direct {v0, p0, v1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$Listener;-><init>(Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$1;)V

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->listener:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$Listener;

    .line 94
    new-instance v0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$ScrollListener;

    invoke-direct {v0, p0, v1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$ScrollListener;-><init>(Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$1;)V

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->scrollListener:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$ScrollListener;

    .line 102
    invoke-static {}, Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;->getInstance()Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;->getRetailSearchLogger()Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->retailSearchLogger:Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

    .line 108
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->atfImageListeners:Ljava/util/List;

    .line 145
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->container:Landroid/view/ViewGroup;

    .line 146
    iput p2, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->columns:I

    .line 147
    iput p2, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->columnsPortrait:I

    .line 148
    iput p3, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->columnsLandscape:I

    .line 149
    invoke-static {p2, p4}, Ljava/lang/Math;->min(II)I

    move-result v0

    iput v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->minRowSize:I

    .line 150
    iput-object p5, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->resourceProvider:Lcom/amazon/ansel/fetch/ResourceProvider;

    .line 151
    iput-object p6, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->asinImpressionTracker:Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;

    .line 152
    iput-object p7, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->productImageSize:Landroid/graphics/Point;

    .line 153
    iput p8, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->atfProductCount:I

    .line 154
    new-instance v0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$LoaderScrollListener;

    invoke-direct {v0, p0, p5, v1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$LoaderScrollListener;-><init>(Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;Lcom/amazon/ansel/fetch/ResourceProvider;Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$1;)V

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->loaderScrollListener:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$LoaderScrollListener;

    .line 155
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->getProductImageFactory()Lcom/amazon/retailsearch/android/ui/ImageRequestFactory;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->productImageFactory:Lcom/amazon/retailsearch/android/ui/ImageRequestFactory;

    .line 156
    new-instance v0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$AsinVisibilityReporter;

    invoke-direct {v0, p0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$AsinVisibilityReporter;-><init>(Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;)V

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->asinVisibilityReporter:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$AsinVisibilityReporter;

    .line 157
    invoke-static {p0}, Lcom/amazon/retailsearch/di/RetailSearchDaggerGraphController;->inject(Ljava/lang/Object;)V

    .line 158
    const/4 v0, 0x0

    iput v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->asinGroupCount:I

    .line 159
    return-void
.end method

.method public constructor <init>(Landroid/view/ViewGroup;IILcom/amazon/ansel/fetch/ResourceProvider;Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;III)V
    .locals 11
    .param p1, "container"    # Landroid/view/ViewGroup;
    .param p2, "columns"    # I
    .param p3, "columnsLandscape"    # I
    .param p4, "resourceProvider"    # Lcom/amazon/ansel/fetch/ResourceProvider;
    .param p5, "asinImpressionTracker"    # Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;
    .param p6, "prodImageWidthId"    # I
    .param p7, "prodImageHeightId"    # I
    .param p8, "atfProductCountId"    # I

    .prologue
    .line 115
    invoke-virtual {p1}, Landroid/view/ViewGroup;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    move/from16 v0, p6

    move/from16 v1, p7

    invoke-static {v2, v0, v1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->naturalDimensions(Landroid/content/res/Resources;II)Landroid/graphics/Point;

    move-result-object v9

    invoke-virtual {p1}, Landroid/view/ViewGroup;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    move/from16 v0, p8

    invoke-virtual {v2, v0}, Landroid/content/res/Resources;->getInteger(I)I

    move-result v10

    move-object v2, p0

    move-object v3, p1

    move v4, p2

    move v5, p3

    move v6, p2

    move-object v7, p4

    move-object/from16 v8, p5

    invoke-direct/range {v2 .. v10}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;-><init>(Landroid/view/ViewGroup;IIILcom/amazon/ansel/fetch/ResourceProvider;Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;Landroid/graphics/Point;I)V

    .line 125
    return-void
.end method

.method public constructor <init>(Landroid/view/ViewGroup;ILcom/amazon/ansel/fetch/ResourceProvider;Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;III)V
    .locals 10
    .param p1, "container"    # Landroid/view/ViewGroup;
    .param p2, "columns"    # I
    .param p3, "resourceProvider"    # Lcom/amazon/ansel/fetch/ResourceProvider;
    .param p4, "asinImpressionTracker"    # Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;
    .param p5, "prodImageWidthId"    # I
    .param p6, "prodImageHeightId"    # I
    .param p7, "atfProductCountId"    # I

    .prologue
    .line 130
    invoke-virtual {p1}, Landroid/view/ViewGroup;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    move/from16 v0, p6

    invoke-static {v1, p5, v0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->naturalDimensions(Landroid/content/res/Resources;II)Landroid/graphics/Point;

    move-result-object v8

    invoke-virtual {p1}, Landroid/view/ViewGroup;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    move/from16 v0, p7

    invoke-virtual {v1, v0}, Landroid/content/res/Resources;->getInteger(I)I

    move-result v9

    move-object v1, p0

    move-object v2, p1

    move v3, p2

    move v4, p2

    move v5, p2

    move-object v6, p3

    move-object v7, p4

    invoke-direct/range {v1 .. v9}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;-><init>(Landroid/view/ViewGroup;IIILcom/amazon/ansel/fetch/ResourceProvider;Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;Landroid/graphics/Point;I)V

    .line 140
    return-void
.end method

.method static synthetic access$1000(Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;)Z
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    .prologue
    .line 80
    iget-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->enabled:Z

    return v0
.end method

.method static synthetic access$1100(Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;)I
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    .prologue
    .line 80
    iget v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->asinGroupCount:I

    return v0
.end method

.method static synthetic access$1108(Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;)I
    .locals 2
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    .prologue
    .line 80
    iget v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->asinGroupCount:I

    add-int/lit8 v1, v0, 0x1

    iput v1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->asinGroupCount:I

    return v0
.end method

.method static synthetic access$1200(Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;)I
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    .prologue
    .line 80
    iget v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->columns:I

    return v0
.end method

.method static synthetic access$1300(Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;)Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    .prologue
    .line 80
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->asinImpressionTracker:Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;

    return-object v0
.end method

.method static synthetic access$300(Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;)Lcom/amazon/ansel/fetch/ResourceProvider;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    .prologue
    .line 80
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->resourceProvider:Lcom/amazon/ansel/fetch/ResourceProvider;

    return-object v0
.end method

.method static synthetic access$400(Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;)Lcom/amazon/retailsearch/android/ui/ImageRequestFactory;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    .prologue
    .line 80
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->productImageFactory:Lcom/amazon/retailsearch/android/ui/ImageRequestFactory;

    return-object v0
.end method

.method static synthetic access$500(Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;)Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    .prologue
    .line 80
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->state:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;

    return-object v0
.end method

.method static synthetic access$600(Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;)Ljava/util/List;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    .prologue
    .line 80
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->atfImageListeners:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$700(Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;)I
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    .prologue
    .line 80
    iget v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->atfProductCount:I

    return v0
.end method

.method static synthetic access$800(Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;)Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    .prologue
    .line 80
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->retailSearchLogger:Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

    return-object v0
.end method

.method static synthetic access$900(Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;)Landroid/graphics/Point;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    .prologue
    .line 80
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->productImageSize:Landroid/graphics/Point;

    return-object v0
.end method

.method private containsVisibleProducts(Ljava/util/List;)Z
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/Product;",
            ">;)Z"
        }
    .end annotation

    .prologue
    .local p1, "products":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/Product;>;"
    const/4 v2, 0x0

    .line 1024
    if-nez p1, :cond_1

    .line 1037
    :cond_0
    :goto_0
    return v2

    .line 1029
    :cond_1
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_2
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/searchapp/retailsearch/model/Product;

    .line 1031
    .local v1, "product":Lcom/amazon/searchapp/retailsearch/model/Product;
    invoke-direct {p0, v1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->isHiddenProduct(Lcom/amazon/searchapp/retailsearch/model/Product;)Z

    move-result v3

    if-nez v3, :cond_2

    .line 1033
    const/4 v2, 0x1

    goto :goto_0
.end method

.method protected static createContentView(ILjava/lang/Class;Ljava/lang/Object;)Lcom/amazon/retailsearch/android/ui/listadapter/ModelViewEntry;
    .locals 1
    .param p0, "type"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<Widget:",
            "Landroid/view/View;",
            ":",
            "Lcom/amazon/retailsearch/android/ui/listadapter/ModelView",
            "<TModel;>;Model:",
            "Ljava/lang/Object;",
            ">(I",
            "Ljava/lang/Class",
            "<TWidget;>;TModel;)",
            "Lcom/amazon/retailsearch/android/ui/listadapter/ModelViewEntry",
            "<TWidget;TModel;>;"
        }
    .end annotation

    .prologue
    .line 989
    .local p1, "viewClass":Ljava/lang/Class;, "Ljava/lang/Class<TWidget;>;"
    .local p2, "model":Ljava/lang/Object;, "TModel;"
    invoke-static {p0, p1, p2}, Lcom/amazon/retailsearch/android/ui/listadapter/ModelViewEntry;->create(ILjava/lang/Class;Ljava/lang/Object;)Lcom/amazon/retailsearch/android/ui/listadapter/ModelViewEntry;

    move-result-object v0

    return-object v0
.end method

.method private isHiddenProduct(Lcom/amazon/searchapp/retailsearch/model/Product;)Z
    .locals 1
    .param p1, "product"    # Lcom/amazon/searchapp/retailsearch/model/Product;

    .prologue
    .line 1045
    if-eqz p1, :cond_0

    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/Product;->getHidden()Lcom/amazon/searchapp/retailsearch/model/Hidden;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/Product;->getHidden()Lcom/amazon/searchapp/retailsearch/model/Hidden;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/searchapp/retailsearch/model/Hidden;->getType()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static naturalDimensions(Landroid/content/res/Resources;II)Landroid/graphics/Point;
    .locals 6
    .param p0, "resources"    # Landroid/content/res/Resources;
    .param p1, "widthId"    # I
    .param p2, "heightId"    # I

    .prologue
    const-wide/high16 v4, 0x3fe0000000000000L    # 0.5

    .line 1081
    invoke-virtual {p0, p1}, Landroid/content/res/Resources;->getDimension(I)F

    move-result v2

    invoke-virtual {p0}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v3

    iget v3, v3, Landroid/util/DisplayMetrics;->density:F

    div-float/2addr v2, v3

    float-to-double v2, v2

    add-double/2addr v2, v4

    double-to-int v1, v2

    .line 1082
    .local v1, "w":I
    invoke-virtual {p0, p2}, Landroid/content/res/Resources;->getDimension(I)F

    move-result v2

    invoke-virtual {p0}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v3

    iget v3, v3, Landroid/util/DisplayMetrics;->density:F

    div-float/2addr v2, v3

    float-to-double v2, v2

    add-double/2addr v2, v4

    double-to-int v0, v2

    .line 1083
    .local v0, "h":I
    new-instance v2, Landroid/graphics/Point;

    invoke-direct {v2, v1, v0}, Landroid/graphics/Point;-><init>(II)V

    return-object v2
.end method

.method private saveUserState()Lcom/amazon/retailsearch/android/ui/results/layout/UserState;
    .locals 10

    .prologue
    .line 267
    new-instance v5, Lcom/amazon/retailsearch/android/ui/results/layout/UserState;

    invoke-direct {v5}, Lcom/amazon/retailsearch/android/ui/results/layout/UserState;-><init>()V

    .line 268
    .local v5, "state":Lcom/amazon/retailsearch/android/ui/results/layout/UserState;
    iget-object v6, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->results:Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;

    invoke-virtual {v6}, Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;->isEmpty()Z

    move-result v6

    if-eqz v6, :cond_1

    .line 299
    :cond_0
    :goto_0
    return-object v5

    .line 274
    :cond_1
    iget-object v6, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->state:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;

    invoke-virtual {v6}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->getEntryAsin()Ljava/lang/String;

    move-result-object v0

    .line 275
    .local v0, "asin":Ljava/lang/String;
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v6

    if-nez v6, :cond_2

    .line 277
    iget-object v6, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->results:Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;

    new-instance v7, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$1;

    invoke-direct {v7, p0, v0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$1;-><init>(Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;Ljava/lang/String;)V

    iget-object v8, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->stackView:Lcom/amazon/retailsearch/android/ui/results/layout/StackView;

    invoke-interface {v8}, Lcom/amazon/retailsearch/android/ui/results/layout/StackView;->getFirstVisiblePosition()I

    move-result v8

    iget-object v9, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->stackView:Lcom/amazon/retailsearch/android/ui/results/layout/StackView;

    invoke-interface {v9}, Lcom/amazon/retailsearch/android/ui/results/layout/StackView;->getLastVisiblePosition()I

    move-result v9

    invoke-virtual {v6, v7, v8, v9}, Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;->getModel(Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController$ModelMatcher;II)Ljava/lang/Object;

    move-result-object v4

    .line 285
    .local v4, "selectedModel":Ljava/lang/Object;
    invoke-virtual {v5, v4}, Lcom/amazon/retailsearch/android/ui/results/layout/UserState;->setSelectedModel(Ljava/lang/Object;)V

    .line 288
    .end local v4    # "selectedModel":Ljava/lang/Object;
    :cond_2
    invoke-virtual {v5}, Lcom/amazon/retailsearch/android/ui/results/layout/UserState;->getSelectedModel()Ljava/lang/Object;

    move-result-object v6

    if-nez v6, :cond_0

    .line 290
    iget-object v6, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->stackView:Lcom/amazon/retailsearch/android/ui/results/layout/StackView;

    const/4 v7, 0x0

    invoke-interface {v6, v7}, Lcom/amazon/retailsearch/android/ui/results/layout/StackView;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    .line 291
    .local v2, "firstVisibleView":Landroid/view/View;
    if-eqz v2, :cond_0

    .line 295
    invoke-virtual {p0, v2}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->getFirstVisibleItemPosition(Landroid/view/View;)I

    move-result v1

    .line 296
    .local v1, "firstVisiblePosition":I
    iget-object v6, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->results:Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;

    invoke-virtual {v6, v1}, Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;->get(I)Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;

    move-result-object v3

    .line 297
    .local v3, "layoutElement":Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;, "Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement<+Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntry;>;"
    invoke-virtual {v3}, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;->getLayoutElementModel()Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;

    move-result-object v6

    invoke-virtual {v5, v6}, Lcom/amazon/retailsearch/android/ui/results/layout/UserState;->setCurrentDataInFocus(Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;)V

    goto :goto_0
.end method


# virtual methods
.method protected add(Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntry;Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;)V
    .locals 1
    .param p1, "viewEntry"    # Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntry;
    .param p2, "layoutElementModel"    # Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;

    .prologue
    .line 387
    invoke-virtual {p0, p1, p2}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->createLayoutElement(Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntry;Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;)Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->add(Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;)V

    .line 388
    return-void
.end method

.method protected add(Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement",
            "<*>;)V"
        }
    .end annotation

    .prologue
    .line 391
    .local p1, "item":Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;, "Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement<*>;"
    const/4 v0, 0x1

    invoke-virtual {p0, p1, v0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->add(Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;Z)V

    .line 392
    return-void
.end method

.method protected add(Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;Z)V
    .locals 2
    .param p2, "showImmediately"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement",
            "<*>;Z)V"
        }
    .end annotation

    .prologue
    .line 395
    .local p1, "item":Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;, "Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement<*>;"
    invoke-virtual {p1}, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;->getPosition()I

    move-result v0

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->state:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->getNextPosition()I

    move-result v1

    if-le v0, v1, :cond_0

    if-nez p2, :cond_0

    .line 396
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->state:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->getPendingContent()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 397
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->state:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->getPendingContent()Ljava/util/List;

    move-result-object v0

    invoke-static {v0}, Ljava/util/Collections;->sort(Ljava/util/List;)V

    .line 403
    :goto_0
    return-void

    .line 401
    :cond_0
    invoke-virtual {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->insert(Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;)V

    .line 402
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->showPendingContent(Z)V

    goto :goto_0
.end method

.method protected addAsinGroupIndex(Ljava/util/List;I)V
    .locals 5
    .param p2, "index"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/Product;",
            ">;I)V"
        }
    .end annotation

    .prologue
    .line 476
    .local p1, "products":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/Product;>;"
    if-eqz p1, :cond_0

    invoke-interface {p1}, Ljava/util/List;->isEmpty()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 484
    :cond_0
    return-void

    .line 480
    :cond_1
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/searchapp/retailsearch/model/Product;

    .line 482
    .local v1, "product":Lcom/amazon/searchapp/retailsearch/model/Product;
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->state:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;

    invoke-virtual {v2}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->getAsinGroupMap()Ljava/util/HashMap;

    move-result-object v2

    invoke-interface {v1}, Lcom/amazon/searchapp/retailsearch/model/Product;->getAsin()Ljava/lang/String;

    move-result-object v3

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0
.end method

.method protected addCategoryCorrected(Lcom/amazon/searchapp/retailsearch/model/CategoryCorrected;)V
    .locals 2
    .param p1, "categoryCorrected"    # Lcom/amazon/searchapp/retailsearch/model/CategoryCorrected;

    .prologue
    .line 899
    if-eqz p1, :cond_0

    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/CategoryCorrected;->getResults()Lcom/amazon/searchapp/retailsearch/model/ProductSection;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/CategoryCorrected;->getResults()Lcom/amazon/searchapp/retailsearch/model/ProductSection;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/searchapp/retailsearch/model/ProductSection;->getItems()Ljava/util/List;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->containsVisibleProducts(Ljava/util/List;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 909
    :cond_0
    :goto_0
    return-void

    .line 905
    :cond_1
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->flushProducts()V

    .line 906
    invoke-virtual {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->createCategoryCorrectedHeader(Lcom/amazon/searchapp/retailsearch/model/CategoryCorrected;)Lcom/amazon/retailsearch/android/ui/listadapter/ViewBuilderEntry;

    move-result-object v0

    invoke-static {p1}, Lcom/amazon/retailsearch/android/ui/results/layout/SingleLayoutElementModel;->create(Ljava/lang/Object;)Lcom/amazon/retailsearch/android/ui/results/layout/SingleLayoutElementModel;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->add(Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntry;Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;)V

    .line 907
    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/CategoryCorrected;->getResults()Lcom/amazon/searchapp/retailsearch/model/ProductSection;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/searchapp/retailsearch/model/ProductSection;->getItems()Ljava/util/List;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->addProducts(Ljava/util/List;)V

    .line 908
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->flushProducts()V

    goto :goto_0
.end method

.method protected addCategoryCorrected(Lcom/amazon/searchapp/retailsearch/model/CategoryCorrected;I)V
    .locals 1
    .param p1, "categoryCorrected"    # Lcom/amazon/searchapp/retailsearch/model/CategoryCorrected;
    .param p2, "index"    # I

    .prologue
    .line 892
    invoke-virtual {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->addCategoryCorrected(Lcom/amazon/searchapp/retailsearch/model/CategoryCorrected;)V

    .line 893
    if-eqz p1, :cond_0

    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/CategoryCorrected;->getResults()Lcom/amazon/searchapp/retailsearch/model/ProductSection;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 894
    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/CategoryCorrected;->getResults()Lcom/amazon/searchapp/retailsearch/model/ProductSection;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/searchapp/retailsearch/model/ProductSection;->getItems()Ljava/util/List;

    move-result-object v0

    invoke-virtual {p0, v0, p2}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->addAsinGroupIndex(Ljava/util/List;I)V

    .line 896
    :cond_0
    return-void
.end method

.method protected addDidYouMean(Lcom/amazon/searchapp/retailsearch/model/DidYouMean;)V
    .locals 5
    .param p1, "didYouMean"    # Lcom/amazon/searchapp/retailsearch/model/DidYouMean;

    .prologue
    .line 920
    if-nez p1, :cond_0

    .line 932
    :goto_0
    return-void

    .line 924
    :cond_0
    new-instance v0, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;

    invoke-virtual {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->createDidYouMean(Lcom/amazon/searchapp/retailsearch/model/DidYouMean;)Lcom/amazon/retailsearch/android/ui/listadapter/ViewBuilderEntry;

    move-result-object v1

    const/4 v2, 0x0

    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->state:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;

    invoke-virtual {v3}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->getStartingPosition()I

    move-result v3

    invoke-static {p1}, Lcom/amazon/retailsearch/android/ui/results/layout/SingleLayoutElementModel;->create(Ljava/lang/Object;)Lcom/amazon/retailsearch/android/ui/results/layout/SingleLayoutElementModel;

    move-result-object v4

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;-><init>(Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntry;IILcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;)V

    .line 931
    .local v0, "item":Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;, "Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement<*>;"
    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->add(Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;)V

    goto :goto_0
.end method

.method protected addError(Ljava/lang/Exception;)V
    .locals 5
    .param p1, "error"    # Ljava/lang/Exception;

    .prologue
    .line 691
    new-instance v0, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;

    invoke-virtual {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->createErrorView(Ljava/lang/Exception;)Lcom/amazon/retailsearch/android/ui/listadapter/ViewBuilderEntry;

    move-result-object v1

    const/4 v2, 0x1

    const/4 v3, 0x0

    invoke-static {p1}, Lcom/amazon/retailsearch/android/ui/results/layout/SingleLayoutElementModel;->create(Ljava/lang/Object;)Lcom/amazon/retailsearch/android/ui/results/layout/SingleLayoutElementModel;

    move-result-object v4

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;-><init>(Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntry;IILcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;)V

    .line 692
    .local v0, "item":Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;, "Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement<*>;"
    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->add(Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;)V

    .line 693
    return-void
.end method

.method protected addFkmr(Lcom/amazon/searchapp/retailsearch/model/FKMR;)V
    .locals 2
    .param p1, "fkmr"    # Lcom/amazon/searchapp/retailsearch/model/FKMR;

    .prologue
    .line 815
    if-eqz p1, :cond_0

    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/FKMR;->getResults()Lcom/amazon/searchapp/retailsearch/model/ProductSection;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/FKMR;->getResults()Lcom/amazon/searchapp/retailsearch/model/ProductSection;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/searchapp/retailsearch/model/ProductSection;->getItems()Ljava/util/List;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->containsVisibleProducts(Ljava/util/List;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 825
    :cond_0
    :goto_0
    return-void

    .line 821
    :cond_1
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->flushProducts()V

    .line 822
    invoke-virtual {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->createFkmrHeader(Lcom/amazon/searchapp/retailsearch/model/FKMR;)Lcom/amazon/retailsearch/android/ui/listadapter/ViewBuilderEntry;

    move-result-object v0

    invoke-static {p1}, Lcom/amazon/retailsearch/android/ui/results/layout/SingleLayoutElementModel;->create(Ljava/lang/Object;)Lcom/amazon/retailsearch/android/ui/results/layout/SingleLayoutElementModel;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->add(Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntry;Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;)V

    .line 823
    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/FKMR;->getResults()Lcom/amazon/searchapp/retailsearch/model/ProductSection;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/searchapp/retailsearch/model/ProductSection;->getItems()Ljava/util/List;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->addProducts(Ljava/util/List;)V

    .line 824
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->flushProducts()V

    goto :goto_0
.end method

.method protected addFkmr(Lcom/amazon/searchapp/retailsearch/model/FKMR;I)V
    .locals 1
    .param p1, "fkmr"    # Lcom/amazon/searchapp/retailsearch/model/FKMR;
    .param p2, "index"    # I

    .prologue
    .line 808
    invoke-virtual {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->addFkmr(Lcom/amazon/searchapp/retailsearch/model/FKMR;)V

    .line 809
    if-eqz p1, :cond_0

    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/FKMR;->getResults()Lcom/amazon/searchapp/retailsearch/model/ProductSection;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 810
    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/FKMR;->getResults()Lcom/amazon/searchapp/retailsearch/model/ProductSection;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/searchapp/retailsearch/model/ProductSection;->getItems()Ljava/util/List;

    move-result-object v0

    invoke-virtual {p0, v0, p2}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->addAsinGroupIndex(Ljava/util/List;I)V

    .line 812
    :cond_0
    return-void
.end method

.method protected addMainContent(Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$MainElement;)V
    .locals 1
    .param p1, "item"    # Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$MainElement;

    .prologue
    .line 607
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->state:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->getMainContent()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 608
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->state:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->getMainContent()Ljava/util/List;

    move-result-object v0

    invoke-static {v0}, Ljava/util/Collections;->sort(Ljava/util/List;)V

    .line 609
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->showMainContent(Z)V

    .line 610
    return-void
.end method

.method protected addNoResultsSet(Lcom/amazon/searchapp/retailsearch/model/NoResultsSet;)V
    .locals 2
    .param p1, "noResultsSet"    # Lcom/amazon/searchapp/retailsearch/model/NoResultsSet;

    .prologue
    .line 969
    if-nez p1, :cond_0

    .line 977
    :goto_0
    return-void

    .line 973
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->flushProducts()V

    .line 974
    invoke-virtual {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->createNoResultsSet(Lcom/amazon/searchapp/retailsearch/model/NoResultsSet;)Lcom/amazon/retailsearch/android/ui/listadapter/ViewBuilderEntry;

    move-result-object v0

    invoke-static {p1}, Lcom/amazon/retailsearch/android/ui/results/layout/SingleLayoutElementModel;->create(Ljava/lang/Object;)Lcom/amazon/retailsearch/android/ui/results/layout/SingleLayoutElementModel;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->add(Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntry;Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;)V

    .line 975
    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/NoResultsSet;->getFallbackResults()Ljava/util/List;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->addProducts(Ljava/util/List;)V

    .line 976
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->flushProducts()V

    goto :goto_0
.end method

.method protected addProduct(Lcom/amazon/searchapp/retailsearch/model/Product;)Z
    .locals 2
    .param p1, "product"    # Lcom/amazon/searchapp/retailsearch/model/Product;

    .prologue
    .line 789
    if-eqz p1, :cond_0

    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->isHiddenProduct(Lcom/amazon/searchapp/retailsearch/model/Product;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 791
    :cond_0
    const/4 v0, 0x0

    .line 804
    :goto_0
    return v0

    .line 795
    :cond_1
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->state:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->state:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->getProductCount()I

    move-result v1

    add-int/lit8 v1, v1, 0x1

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->setProductCount(I)V

    .line 796
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->state:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->getProducts()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 798
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->state:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->getProductCount()I

    move-result v0

    iget v1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->atfProductCount:I

    if-gt v0, v1, :cond_2

    .line 801
    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/Product;->getImage()Lcom/amazon/searchapp/retailsearch/model/Image;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->loadAtfImage(Lcom/amazon/searchapp/retailsearch/model/Image;)V

    .line 804
    :cond_2
    const/4 v0, 0x1

    goto :goto_0
.end method

.method protected addProductWrapper(Lcom/amazon/searchapp/retailsearch/model/Product;)V
    .locals 0
    .param p1, "product"    # Lcom/amazon/searchapp/retailsearch/model/Product;

    .prologue
    .line 780
    invoke-virtual {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->addProduct(Lcom/amazon/searchapp/retailsearch/model/Product;)Z

    .line 781
    return-void
.end method

.method protected addProducts(Ljava/util/List;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/Product;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 459
    .local p1, "products":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/Product;>;"
    if-eqz p1, :cond_0

    invoke-interface {p1}, Ljava/util/List;->isEmpty()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 470
    :cond_0
    :goto_0
    return-void

    .line 463
    :cond_1
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_2

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/searchapp/retailsearch/model/Product;

    .line 466
    .local v1, "product":Lcom/amazon/searchapp/retailsearch/model/Product;
    invoke-virtual {p0, v1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->addProduct(Lcom/amazon/searchapp/retailsearch/model/Product;)Z

    goto :goto_1

    .line 469
    .end local v1    # "product":Lcom/amazon/searchapp/retailsearch/model/Product;
    :cond_2
    const/4 v2, 0x0

    invoke-virtual {p0, v2}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->showProducts(Z)V

    goto :goto_0
.end method

.method protected addRelatedSearches(Lcom/amazon/searchapp/retailsearch/model/RelatedSearches;)V
    .locals 5
    .param p1, "relatedSearches"    # Lcom/amazon/searchapp/retailsearch/model/RelatedSearches;

    .prologue
    .line 943
    if-nez p1, :cond_1

    .line 958
    :cond_0
    :goto_0
    return-void

    .line 947
    :cond_1
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->state:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->getRelatedSearchesExists()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/RelatedSearches;->getSecondaryResult()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 951
    :cond_2
    new-instance v0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$MainElement;

    invoke-virtual {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->createRelatedSearches(Lcom/amazon/searchapp/retailsearch/model/RelatedSearches;)Lcom/amazon/retailsearch/android/ui/listadapter/ViewBuilderEntry;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->state:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;

    invoke-virtual {v2}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->getStartingProductRowCount()I

    move-result v2

    add-int/lit8 v2, v2, 0xa

    const/4 v3, 0x0

    invoke-static {p1}, Lcom/amazon/retailsearch/android/ui/results/layout/SingleLayoutElementModel;->create(Ljava/lang/Object;)Lcom/amazon/retailsearch/android/ui/results/layout/SingleLayoutElementModel;

    move-result-object v4

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$MainElement;-><init>(Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntry;IILcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;)V

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->addMainContent(Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$MainElement;)V

    .line 957
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->state:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->setRelatedSearchesExists(Z)V

    goto :goto_0
.end method

.method protected addSpellCorrected(Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;)V
    .locals 2
    .param p1, "spellCorrected"    # Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;

    .prologue
    .line 843
    if-eqz p1, :cond_0

    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;->getResults()Lcom/amazon/searchapp/retailsearch/model/ProductSection;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;->getResults()Lcom/amazon/searchapp/retailsearch/model/ProductSection;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/searchapp/retailsearch/model/ProductSection;->getItems()Ljava/util/List;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->containsVisibleProducts(Ljava/util/List;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 853
    :cond_0
    :goto_0
    return-void

    .line 849
    :cond_1
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->flushProducts()V

    .line 850
    invoke-virtual {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->createSpellCorrectionHeader(Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;)Lcom/amazon/retailsearch/android/ui/listadapter/ViewBuilderEntry;

    move-result-object v0

    invoke-static {p1}, Lcom/amazon/retailsearch/android/ui/results/layout/SingleLayoutElementModel;->create(Ljava/lang/Object;)Lcom/amazon/retailsearch/android/ui/results/layout/SingleLayoutElementModel;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->add(Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntry;Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;)V

    .line 851
    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;->getResults()Lcom/amazon/searchapp/retailsearch/model/ProductSection;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/searchapp/retailsearch/model/ProductSection;->getItems()Ljava/util/List;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->addProducts(Ljava/util/List;)V

    .line 852
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->flushProducts()V

    goto :goto_0
.end method

.method protected addSpellCorrected(Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;I)V
    .locals 1
    .param p1, "spellCorrected"    # Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;
    .param p2, "index"    # I

    .prologue
    .line 836
    invoke-virtual {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->addSpellCorrected(Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;)V

    .line 837
    if-eqz p1, :cond_0

    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;->getResults()Lcom/amazon/searchapp/retailsearch/model/ProductSection;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 838
    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;->getResults()Lcom/amazon/searchapp/retailsearch/model/ProductSection;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/searchapp/retailsearch/model/ProductSection;->getItems()Ljava/util/List;

    move-result-object v0

    invoke-virtual {p0, v0, p2}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->addAsinGroupIndex(Ljava/util/List;I)V

    .line 840
    :cond_0
    return-void
.end method

.method protected addWordSplitter(Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;)V
    .locals 2
    .param p1, "wordSplitter"    # Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;

    .prologue
    .line 871
    if-eqz p1, :cond_0

    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;->getResults()Lcom/amazon/searchapp/retailsearch/model/ProductSection;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;->getResults()Lcom/amazon/searchapp/retailsearch/model/ProductSection;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/searchapp/retailsearch/model/ProductSection;->getItems()Ljava/util/List;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->containsVisibleProducts(Ljava/util/List;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 881
    :cond_0
    :goto_0
    return-void

    .line 877
    :cond_1
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->flushProducts()V

    .line 878
    invoke-virtual {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->createWordSplitterHeader(Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;)Lcom/amazon/retailsearch/android/ui/listadapter/ViewBuilderEntry;

    move-result-object v0

    invoke-static {p1}, Lcom/amazon/retailsearch/android/ui/results/layout/SingleLayoutElementModel;->create(Ljava/lang/Object;)Lcom/amazon/retailsearch/android/ui/results/layout/SingleLayoutElementModel;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->add(Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntry;Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;)V

    .line 879
    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;->getResults()Lcom/amazon/searchapp/retailsearch/model/ProductSection;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/searchapp/retailsearch/model/ProductSection;->getItems()Ljava/util/List;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->addProducts(Ljava/util/List;)V

    .line 880
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->flushProducts()V

    goto :goto_0
.end method

.method protected addWordSplitter(Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;I)V
    .locals 1
    .param p1, "wordSplitter"    # Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;
    .param p2, "index"    # I

    .prologue
    .line 864
    invoke-virtual {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->addWordSplitter(Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;)V

    .line 865
    if-eqz p1, :cond_0

    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;->getResults()Lcom/amazon/searchapp/retailsearch/model/ProductSection;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 866
    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;->getResults()Lcom/amazon/searchapp/retailsearch/model/ProductSection;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/searchapp/retailsearch/model/ProductSection;->getItems()Ljava/util/List;

    move-result-object v0

    invoke-virtual {p0, v0, p2}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->addAsinGroupIndex(Ljava/util/List;I)V

    .line 868
    :cond_0
    return-void
.end method

.method public changeOrientation(ILcom/amazon/retailsearch/android/ui/results/layout/UserState;)V
    .locals 2
    .param p1, "orientation"    # I
    .param p2, "userState"    # Lcom/amazon/retailsearch/android/ui/results/layout/UserState;

    .prologue
    .line 1457
    iput p1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->orientation:I

    .line 1458
    invoke-direct {p0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->saveUserState()Lcom/amazon/retailsearch/android/ui/results/layout/UserState;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->enable(Lcom/amazon/retailsearch/android/ui/results/layout/UserState;)V

    .line 1459
    iget v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->columnsPortrait:I

    iget v1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->columnsLandscape:I

    if-ne v0, v1, :cond_0

    .line 1463
    :cond_0
    return-void
.end method

.method protected clearError()V
    .locals 3

    .prologue
    .line 704
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->results:Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->state:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->getStartingSize()I

    move-result v1

    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->results:Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;

    invoke-virtual {v2}, Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;->size()I

    move-result v2

    invoke-virtual {v0, v1, v2}, Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;->clear(II)V

    .line 705
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->modified:Z

    .line 706
    new-instance v0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->prevState:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;

    invoke-direct {v0, v1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;-><init>(Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;)V

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->state:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;

    .line 707
    return-void
.end method

.method protected createCategoryCorrectedHeader(Lcom/amazon/searchapp/retailsearch/model/CategoryCorrected;)Lcom/amazon/retailsearch/android/ui/listadapter/ViewBuilderEntry;
    .locals 2
    .param p1, "categoryCorrected"    # Lcom/amazon/searchapp/retailsearch/model/CategoryCorrected;

    .prologue
    .line 912
    const/16 v0, 0xb

    const-class v1, Lcom/amazon/retailsearch/android/ui/results/layout/view/CategoryCorrectedView;

    invoke-static {v0, v1, p1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->createContentView(ILjava/lang/Class;Ljava/lang/Object;)Lcom/amazon/retailsearch/android/ui/listadapter/ModelViewEntry;

    move-result-object v0

    return-object v0
.end method

.method protected createDidYouMean(Lcom/amazon/searchapp/retailsearch/model/DidYouMean;)Lcom/amazon/retailsearch/android/ui/listadapter/ViewBuilderEntry;
    .locals 2
    .param p1, "didYouMean"    # Lcom/amazon/searchapp/retailsearch/model/DidYouMean;

    .prologue
    .line 935
    const/16 v0, 0xc

    const-class v1, Lcom/amazon/retailsearch/android/ui/results/layout/view/DidYouMeanView;

    invoke-static {v0, v1, p1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->createContentView(ILjava/lang/Class;Ljava/lang/Object;)Lcom/amazon/retailsearch/android/ui/listadapter/ModelViewEntry;

    move-result-object v0

    return-object v0
.end method

.method protected createErrorView(Ljava/lang/Exception;)Lcom/amazon/retailsearch/android/ui/listadapter/ViewBuilderEntry;
    .locals 2
    .param p1, "error"    # Ljava/lang/Exception;

    .prologue
    .line 696
    const/4 v0, 0x0

    const-class v1, Lcom/amazon/retailsearch/android/ui/results/layout/view/ErrorView;

    invoke-static {v0, v1, p1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->createContentView(ILjava/lang/Class;Ljava/lang/Object;)Lcom/amazon/retailsearch/android/ui/listadapter/ModelViewEntry;

    move-result-object v0

    return-object v0
.end method

.method protected createFkmrHeader(Lcom/amazon/searchapp/retailsearch/model/FKMR;)Lcom/amazon/retailsearch/android/ui/listadapter/ViewBuilderEntry;
    .locals 2
    .param p1, "fkmr"    # Lcom/amazon/searchapp/retailsearch/model/FKMR;

    .prologue
    .line 828
    const/16 v0, 0x8

    const-class v1, Lcom/amazon/retailsearch/android/ui/results/layout/view/FkmrHeader;

    invoke-static {v0, v1, p1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->createContentView(ILjava/lang/Class;Ljava/lang/Object;)Lcom/amazon/retailsearch/android/ui/listadapter/ModelViewEntry;

    move-result-object v0

    return-object v0
.end method

.method protected createLayoutElement(Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntry;Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;)Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;
    .locals 3
    .param p2, "layoutElementModel"    # Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntry;",
            ">(TT;",
            "Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;",
            ")",
            "Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 406
    .local p1, "viewEntry":Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntry;, "TT;"
    new-instance v0, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;

    const/4 v1, 0x0

    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->state:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;

    invoke-virtual {v2}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->getNextPosition()I

    move-result v2

    invoke-direct {v0, p1, v1, v2, p2}, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;-><init>(Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntry;IILcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;)V

    return-object v0
.end method

.method protected createNoResultsSet(Lcom/amazon/searchapp/retailsearch/model/NoResultsSet;)Lcom/amazon/retailsearch/android/ui/listadapter/ViewBuilderEntry;
    .locals 2
    .param p1, "noResultsSet"    # Lcom/amazon/searchapp/retailsearch/model/NoResultsSet;

    .prologue
    .line 980
    const/16 v0, 0xe

    const-class v1, Lcom/amazon/retailsearch/android/ui/results/layout/view/NoResultsSetView;

    invoke-static {v0, v1, p1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->createContentView(ILjava/lang/Class;Ljava/lang/Object;)Lcom/amazon/retailsearch/android/ui/listadapter/ModelViewEntry;

    move-result-object v0

    return-object v0
.end method

.method protected abstract createProductCell(Lcom/amazon/searchapp/retailsearch/model/Product;)Lcom/amazon/retailsearch/android/ui/listadapter/ViewBuilderEntry;
.end method

.method protected createProductImageFactory()Lcom/amazon/retailsearch/android/ui/ImageRequestFactory;
    .locals 1

    .prologue
    .line 1005
    new-instance v0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$4;

    invoke-direct {v0, p0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$4;-><init>(Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;)V

    return-object v0
.end method

.method protected createProductViewModel(Lcom/amazon/searchapp/retailsearch/model/Product;)Lcom/amazon/retailsearch/android/ui/results/ProductViewModel;
    .locals 3
    .param p1, "product"    # Lcom/amazon/searchapp/retailsearch/model/Product;

    .prologue
    .line 993
    new-instance v0, Lcom/amazon/retailsearch/android/ui/results/ProductViewModel;

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->getProductImageFactory()Lcom/amazon/retailsearch/android/ui/ImageRequestFactory;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->resourceProvider:Lcom/amazon/ansel/fetch/ResourceProvider;

    invoke-direct {v0, p1, v1, v2}, Lcom/amazon/retailsearch/android/ui/results/ProductViewModel;-><init>(Lcom/amazon/searchapp/retailsearch/model/Product;Lcom/amazon/retailsearch/android/ui/ImageRequestFactory;Lcom/amazon/ansel/fetch/ResourceProvider;)V

    return-object v0
.end method

.method protected createRelatedSearches(Lcom/amazon/searchapp/retailsearch/model/RelatedSearches;)Lcom/amazon/retailsearch/android/ui/listadapter/ViewBuilderEntry;
    .locals 2
    .param p1, "relatedSearches"    # Lcom/amazon/searchapp/retailsearch/model/RelatedSearches;

    .prologue
    .line 961
    const/16 v0, 0xd

    const-class v1, Lcom/amazon/retailsearch/android/ui/results/layout/view/RelatedSearchesView;

    invoke-static {v0, v1, p1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->createContentView(ILjava/lang/Class;Ljava/lang/Object;)Lcom/amazon/retailsearch/android/ui/listadapter/ModelViewEntry;

    move-result-object v0

    return-object v0
.end method

.method protected createRow(Lcom/amazon/retailsearch/android/ui/results/layout/model/ContentRowModel;)Lcom/amazon/retailsearch/android/ui/results/layout/entry/ContentRowEntry;
    .locals 2
    .param p1, "model"    # Lcom/amazon/retailsearch/android/ui/results/layout/model/ContentRowModel;

    .prologue
    .line 559
    new-instance v0, Lcom/amazon/retailsearch/android/ui/results/layout/entry/ContentRowEntry;

    const/4 v1, 0x1

    invoke-direct {v0, v1, p1}, Lcom/amazon/retailsearch/android/ui/results/layout/entry/ContentRowEntry;-><init>(ILcom/amazon/retailsearch/android/ui/results/layout/model/ContentRowModel;)V

    return-object v0
.end method

.method protected createSpellCorrectionHeader(Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;)Lcom/amazon/retailsearch/android/ui/listadapter/ViewBuilderEntry;
    .locals 2
    .param p1, "spellCorrected"    # Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;

    .prologue
    .line 856
    const/16 v0, 0x9

    const-class v1, Lcom/amazon/retailsearch/android/ui/results/layout/view/SpellCorrectedHeader;

    invoke-static {v0, v1, p1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->createContentView(ILjava/lang/Class;Ljava/lang/Object;)Lcom/amazon/retailsearch/android/ui/listadapter/ModelViewEntry;

    move-result-object v0

    return-object v0
.end method

.method protected createStackView()Lcom/amazon/retailsearch/android/ui/results/layout/StackView;
    .locals 7

    .prologue
    const/4 v6, 0x0

    .line 370
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->container:Landroid/view/ViewGroup;

    invoke-virtual {v2}, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-static {v2}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v2

    sget v3, Lcom/amazon/retailsearch/R$layout;->rs_vertical_stack_view:I

    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->container:Landroid/view/ViewGroup;

    const/4 v5, 0x1

    invoke-virtual {v2, v3, v4, v5}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 372
    .local v0, "root":Landroid/view/View;
    sget v2, Lcom/amazon/retailsearch/R$id;->rs_vertical_stack_view:I

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/amazon/retailsearch/android/ui/results/layout/VerticalStackView;

    .line 373
    .local v1, "stackView":Lcom/amazon/retailsearch/android/ui/results/layout/VerticalStackView;
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->scrollListener:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$ScrollListener;

    invoke-virtual {v1, v2}, Lcom/amazon/retailsearch/android/ui/results/layout/VerticalStackView;->setOnScrollListener(Landroid/widget/AbsListView$OnScrollListener;)V

    .line 374
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->container:Landroid/view/ViewGroup;

    invoke-virtual {v2}, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-static {v2}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v2

    sget v3, Lcom/amazon/retailsearch/R$layout;->rs_search_spinner:I

    invoke-virtual {v2, v3, v6}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/LinearLayout;

    iput-object v2, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->progressBar:Landroid/widget/LinearLayout;

    .line 381
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->progressBar:Landroid/widget/LinearLayout;

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v6, v3}, Lcom/amazon/retailsearch/android/ui/results/layout/VerticalStackView;->addFooterView(Landroid/view/View;Ljava/lang/Object;Z)V

    .line 382
    invoke-virtual {p0, v1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->setStackView(Lcom/amazon/retailsearch/android/ui/results/layout/StackView;)V

    .line 383
    return-object v1
.end method

.method protected createWordSplitterHeader(Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;)Lcom/amazon/retailsearch/android/ui/listadapter/ViewBuilderEntry;
    .locals 2
    .param p1, "wordSplitter"    # Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;

    .prologue
    .line 884
    const/16 v0, 0xa

    const-class v1, Lcom/amazon/retailsearch/android/ui/results/layout/view/WordSplitterView;

    invoke-static {v0, v1, p1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->createContentView(ILjava/lang/Class;Ljava/lang/Object;)Lcom/amazon/retailsearch/android/ui/listadapter/ModelViewEntry;

    move-result-object v0

    return-object v0
.end method

.method protected detachViews()V
    .locals 2

    .prologue
    .line 354
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->stackView:Lcom/amazon/retailsearch/android/ui/results/layout/StackView;

    if-eqz v0, :cond_1

    .line 355
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->stackView:Lcom/amazon/retailsearch/android/ui/results/layout/StackView;

    invoke-interface {v0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackView;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 356
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->stackView:Lcom/amazon/retailsearch/android/ui/results/layout/StackView;

    invoke-interface {v0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackView;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->stackView:Lcom/amazon/retailsearch/android/ui/results/layout/StackView;

    invoke-interface {v1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackView;->getView()Landroid/view/View;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    .line 358
    :cond_0
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->stackView:Lcom/amazon/retailsearch/android/ui/results/layout/StackView;

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 360
    :cond_1
    return-void
.end method

.method public disable()Lcom/amazon/retailsearch/android/ui/results/layout/UserState;
    .locals 2

    .prologue
    .line 241
    const/4 v1, 0x0

    iput v1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->asinGroupCount:I

    .line 242
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->asinVisibilityReporter:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$AsinVisibilityReporter;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$AsinVisibilityReporter;->stopMonitoring()V

    .line 243
    invoke-direct {p0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->saveUserState()Lcom/amazon/retailsearch/android/ui/results/layout/UserState;

    move-result-object v0

    .line 244
    .local v0, "userState":Lcom/amazon/retailsearch/android/ui/results/layout/UserState;
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->getEntryGroupIndex()I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/android/ui/results/layout/UserState;->setEntryIndex(I)V

    .line 245
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->reset()V

    .line 246
    return-object v0
.end method

.method public enable(Lcom/amazon/retailsearch/android/ui/results/layout/UserState;)V
    .locals 4
    .param p1, "state"    # Lcom/amazon/retailsearch/android/ui/results/layout/UserState;

    .prologue
    const/4 v3, 0x1

    .line 211
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->reset()V

    .line 212
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->container:Landroid/view/ViewGroup;

    invoke-virtual {v0}, Landroid/view/ViewGroup;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v0

    iget v0, v0, Landroid/content/res/Configuration;->orientation:I

    iput v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->orientation:I

    .line 213
    iget v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->orientation:I

    const/4 v1, 0x2

    if-ne v0, v1, :cond_2

    .line 214
    iget v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->columnsLandscape:I

    iput v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->columns:I

    .line 218
    :goto_0
    new-instance v0, Lcom/amazon/retailsearch/android/ui/listadapter/GeneratorAdapter;

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->results:Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;->getViewGenerator()Lcom/amazon/retailsearch/android/ui/listadapter/ViewGenerator;

    move-result-object v1

    const/16 v2, 0xf

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/android/ui/listadapter/GeneratorAdapter;-><init>(Lcom/amazon/retailsearch/android/ui/listadapter/ViewGenerator;I)V

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->adapter:Lcom/amazon/retailsearch/android/ui/listadapter/GeneratorAdapter;

    .line 219
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->getStackView()Lcom/amazon/retailsearch/android/ui/results/layout/StackView;

    .line 220
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->stackView:Lcom/amazon/retailsearch/android/ui/results/layout/StackView;

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->adapter:Lcom/amazon/retailsearch/android/ui/listadapter/GeneratorAdapter;

    invoke-interface {v0, v1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 221
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->stackView:Lcom/amazon/retailsearch/android/ui/results/layout/StackView;

    invoke-interface {v0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackView;->getView()Landroid/view/View;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 223
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->stackView:Lcom/amazon/retailsearch/android/ui/results/layout/StackView;

    invoke-interface {v0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackView;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    if-nez v0, :cond_0

    .line 225
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->container:Landroid/view/ViewGroup;

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->stackView:Lcom/amazon/retailsearch/android/ui/results/layout/StackView;

    invoke-interface {v1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackView;->getView()Landroid/view/View;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V

    .line 228
    :cond_0
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->searchDataSource:Lcom/amazon/retailsearch/interaction/SearchDataSource;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/interaction/SearchDataSource;->getCurrentSearch()Lcom/amazon/retailsearch/data/SearchTask;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->listener:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$Listener;

    invoke-interface {v0, v1}, Lcom/amazon/retailsearch/data/SearchTask;->addListener(Lcom/amazon/retailsearch/data/SearchTask$SearchTaskListener;)V

    .line 230
    iput-boolean v3, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->enabled:Z

    .line 231
    invoke-virtual {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->restoreUserState(Lcom/amazon/retailsearch/android/ui/results/layout/UserState;)V

    .line 232
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->update()V

    .line 233
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->asinVisibilityReporter:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$AsinVisibilityReporter;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$AsinVisibilityReporter;->startMonitoring()V

    .line 234
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->loaderScrollListener:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$LoaderScrollListener;

    if-eqz v0, :cond_1

    .line 235
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->loaderScrollListener:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$LoaderScrollListener;

    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->stackView:Lcom/amazon/retailsearch/android/ui/results/layout/StackView;

    check-cast v0, Landroid/widget/AdapterView;

    invoke-virtual {v1, v0, v3}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$LoaderScrollListener;->processView(Landroid/widget/AdapterView;Z)V

    .line 237
    :cond_1
    return-void

    .line 216
    :cond_2
    iget v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->columnsPortrait:I

    iput v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->columns:I

    goto :goto_0
.end method

.method protected endResult()V
    .locals 1

    .prologue
    .line 673
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->flushProducts()V

    .line 674
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->flushMainContent()V

    .line 675
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->flushPendingContent()V

    .line 676
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->retailSearchLogger:Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

    invoke-interface {v0}, Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;->recordEndOfResults()V

    .line 677
    return-void
.end method

.method protected flushMainContent()V
    .locals 1

    .prologue
    .line 636
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->showMainContent(Z)V

    .line 637
    return-void
.end method

.method protected flushPendingContent()V
    .locals 1

    .prologue
    .line 662
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->showPendingContent(Z)V

    .line 663
    return-void
.end method

.method protected flushProducts()V
    .locals 1

    .prologue
    .line 595
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->flushProducts(Z)V

    .line 596
    return-void
.end method

.method protected flushProducts(Z)V
    .locals 2
    .param p1, "endRow"    # Z

    .prologue
    .line 599
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->showProducts(Z)V

    .line 601
    if-eqz p1, :cond_0

    .line 602
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->state:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->setProductRow(Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;)V

    .line 604
    :cond_0
    return-void
.end method

.method protected getAdapter()Lcom/amazon/retailsearch/android/ui/listadapter/GeneratorAdapter;
    .locals 1

    .prologue
    .line 1470
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->adapter:Lcom/amazon/retailsearch/android/ui/listadapter/GeneratorAdapter;

    return-object v0
.end method

.method public getAsinGroupIndex(Ljava/lang/String;)I
    .locals 1
    .param p1, "asin"    # Ljava/lang/String;

    .prologue
    .line 186
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->state:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->state:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->getAsinGroupMap()Ljava/util/HashMap;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->state:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->getAsinGroupMap()Ljava/util/HashMap;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 188
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->state:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->getAsinGroupMap()Ljava/util/HashMap;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    .line 190
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getColumns()I
    .locals 1

    .prologue
    .line 166
    iget v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->columns:I

    return v0
.end method

.method public getContainer()Landroid/view/ViewGroup;
    .locals 1

    .prologue
    .line 162
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->container:Landroid/view/ViewGroup;

    return-object v0
.end method

.method public getEntryGroupIndex()I
    .locals 1

    .prologue
    .line 203
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->state:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;

    if-nez v0, :cond_0

    .line 204
    const/4 v0, 0x0

    .line 206
    :goto_0
    return v0

    :cond_0
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->state:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->getEntryGroupIndex()I

    move-result v0

    goto :goto_0
.end method

.method protected getFirstVisibleItemPosition(Landroid/view/View;)I
    .locals 5
    .param p1, "firstVisibleView"    # Landroid/view/View;

    .prologue
    const/4 v0, 0x0

    .line 304
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->stackView:Lcom/amazon/retailsearch/android/ui/results/layout/StackView;

    invoke-interface {v4}, Lcom/amazon/retailsearch/android/ui/results/layout/StackView;->getFirstVisiblePosition()I

    move-result v1

    .line 305
    .local v1, "firstVisiblePosition":I
    invoke-virtual {p1}, Landroid/view/View;->getHeight()I

    move-result v4

    div-int/lit8 v2, v4, 0x2

    .line 306
    .local v2, "halfRowHeight":I
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->stackView:Lcom/amazon/retailsearch/android/ui/results/layout/StackView;

    invoke-interface {v4, v0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackView;->getChildAt(I)Landroid/view/View;

    move-result-object v4

    invoke-virtual {v4}, Landroid/view/View;->getTop()I

    move-result v3

    .line 307
    .local v3, "rowTop":I
    invoke-static {v3}, Ljava/lang/Math;->abs(I)I

    move-result v4

    if-le v4, v2, :cond_0

    const/4 v0, 0x1

    .line 308
    .local v0, "firstVisibleItemHasSufficientlyScrolledAway":Z
    :cond_0
    if-eqz v0, :cond_1

    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->results:Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;

    invoke-virtual {v4}, Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;->size()I

    move-result v4

    add-int/lit8 v4, v4, -0x1

    if-ge v1, v4, :cond_1

    .line 310
    add-int/lit8 v1, v1, 0x1

    .line 312
    :cond_1
    return v1
.end method

.method public getMinRowSize()I
    .locals 1

    .prologue
    .line 170
    iget v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->minRowSize:I

    return v0
.end method

.method protected getOrientation()I
    .locals 1

    .prologue
    .line 1451
    iget v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->orientation:I

    return v0
.end method

.method protected getProductImageFactory()Lcom/amazon/retailsearch/android/ui/ImageRequestFactory;
    .locals 1

    .prologue
    .line 997
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->productImageFactory:Lcom/amazon/retailsearch/android/ui/ImageRequestFactory;

    if-nez v0, :cond_0

    .line 998
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->createProductImageFactory()Lcom/amazon/retailsearch/android/ui/ImageRequestFactory;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->productImageFactory:Lcom/amazon/retailsearch/android/ui/ImageRequestFactory;

    .line 1001
    :cond_0
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->productImageFactory:Lcom/amazon/retailsearch/android/ui/ImageRequestFactory;

    return-object v0
.end method

.method public getProductImageSize()Landroid/graphics/Point;
    .locals 1

    .prologue
    .line 178
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->productImageSize:Landroid/graphics/Point;

    return-object v0
.end method

.method protected getProductLoaders(Lcom/amazon/searchapp/retailsearch/model/Product;)Ljava/util/List;
    .locals 2
    .param p1, "product"    # Lcom/amazon/searchapp/retailsearch/model/Product;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/searchapp/retailsearch/model/Product;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/ansel/fetch/tools/collection/Factory",
            "<",
            "Lcom/amazon/ansel/fetch/ResourceLoader",
            "<*>;>;>;"
        }
    .end annotation

    .prologue
    .line 571
    if-eqz p1, :cond_0

    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/Product;->getImage()Lcom/amazon/searchapp/retailsearch/model/Image;

    move-result-object v1

    if-eqz v1, :cond_0

    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/Product;->getImage()Lcom/amazon/searchapp/retailsearch/model/Image;

    move-result-object v1

    invoke-interface {v1}, Lcom/amazon/searchapp/retailsearch/model/Image;->getUrl()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 573
    :cond_0
    const/4 v0, 0x0

    .line 591
    :goto_0
    return-object v0

    .line 576
    :cond_1
    new-instance v0, Ljava/util/ArrayList;

    const/4 v1, 0x1

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(I)V

    .line 578
    .local v0, "loaders":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/amazon/ansel/fetch/tools/collection/Factory<Lcom/amazon/ansel/fetch/ResourceLoader<*>;>;>;"
    new-instance v1, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$2;

    invoke-direct {v1, p0, p1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$2;-><init>(Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;Lcom/amazon/searchapp/retailsearch/model/Product;)V

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0
.end method

.method protected getProgressBar()Landroid/widget/LinearLayout;
    .locals 1

    .prologue
    .line 1493
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->progressBar:Landroid/widget/LinearLayout;

    return-object v0
.end method

.method public getResourceProvider()Lcom/amazon/ansel/fetch/ResourceProvider;
    .locals 1

    .prologue
    .line 174
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->resourceProvider:Lcom/amazon/ansel/fetch/ResourceProvider;

    return-object v0
.end method

.method protected getScrollListener()Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$ScrollListener;
    .locals 1

    .prologue
    .line 1438
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->scrollListener:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$ScrollListener;

    return-object v0
.end method

.method protected getStackView()Lcom/amazon/retailsearch/android/ui/results/layout/StackView;
    .locals 1

    .prologue
    .line 363
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->stackView:Lcom/amazon/retailsearch/android/ui/results/layout/StackView;

    if-nez v0, :cond_0

    .line 364
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->createStackView()Lcom/amazon/retailsearch/android/ui/results/layout/StackView;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->stackView:Lcom/amazon/retailsearch/android/ui/results/layout/StackView;

    .line 366
    :cond_0
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->stackView:Lcom/amazon/retailsearch/android/ui/results/layout/StackView;

    return-object v0
.end method

.method public getUserState()Lcom/amazon/retailsearch/android/ui/results/layout/UserState;
    .locals 1

    .prologue
    .line 262
    invoke-direct {p0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->saveUserState()Lcom/amazon/retailsearch/android/ui/results/layout/UserState;

    move-result-object v0

    return-object v0
.end method

.method protected hideProgressBar()V
    .locals 2

    .prologue
    .line 1477
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->progressBar:Landroid/widget/LinearLayout;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 1478
    return-void
.end method

.method protected insert(Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;)V
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement",
            "<*>;)V"
        }
    .end annotation

    .prologue
    .line 415
    .local p1, "item":Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;, "Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement<*>;"
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->results:Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;

    invoke-virtual {v4, p1}, Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;->binarySearch(Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;)I

    move-result v2

    .line 417
    .local v2, "idx":I
    if-gez v2, :cond_4

    .line 419
    rsub-int/lit8 v4, v2, 0x0

    add-int/lit8 v2, v4, -0x1

    .line 430
    :cond_0
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->results:Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;

    invoke-virtual {v4, v2, p1}, Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;->add(ILcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;)V

    .line 431
    const/4 v4, 0x1

    iput-boolean v4, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->modified:Z

    .line 433
    move v1, v2

    .local v1, "i":I
    :goto_0
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->results:Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;

    invoke-virtual {v4}, Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;->size()I

    move-result v4

    if-ge v1, v4, :cond_3

    .line 434
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->results:Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;

    invoke-virtual {v4, v1}, Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;->get(I)Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;

    move-result-object v0

    .line 436
    .local v0, "el":Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;, "Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement<*>;"
    if-lez v1, :cond_1

    .line 437
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->results:Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;

    add-int/lit8 v5, v1, -0x1

    invoke-virtual {v4, v5}, Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;->get(I)Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;

    move-result-object v3

    .line 439
    .local v3, "prev":Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;, "Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement<*>;"
    invoke-virtual {v3}, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;->getSection()I

    move-result v4

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;->getSection()I

    move-result v5

    if-ne v4, v5, :cond_1

    .line 440
    invoke-virtual {v3}, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;->getPosition()I

    move-result v4

    invoke-virtual {v3}, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;->getSpan()I

    move-result v5

    add-int/2addr v4, v5

    invoke-virtual {v0, v4}, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;->setPosition(I)V

    .line 444
    .end local v3    # "prev":Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;, "Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement<*>;"
    :cond_1
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->state:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;

    invoke-virtual {v4}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->getNextPosition()I

    move-result v4

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;->getPosition()I

    move-result v5

    if-ne v4, v5, :cond_2

    invoke-virtual {p1}, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;->getSection()I

    move-result v4

    if-nez v4, :cond_2

    .line 445
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->state:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;->getPosition()I

    move-result v5

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;->getSpan()I

    move-result v6

    add-int/2addr v5, v6

    invoke-virtual {v4, v5}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->setNextPosition(I)V

    .line 448
    :cond_2
    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;->getSection()I

    move-result v4

    invoke-virtual {p1}, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;->getSection()I

    move-result v5

    if-eq v4, v5, :cond_5

    .line 452
    .end local v0    # "el":Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;, "Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement<*>;"
    :cond_3
    return-void

    .line 423
    .end local v1    # "i":I
    :cond_4
    add-int/lit8 v2, v2, 0x1

    :goto_1
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->results:Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;

    invoke-virtual {v4}, Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;->size()I

    move-result v4

    if-ge v2, v4, :cond_0

    .line 424
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->results:Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;

    invoke-virtual {v4, v2}, Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;->get(I)Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;

    move-result-object v4

    invoke-virtual {p1, v4}, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;->compareTo(Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;)I

    move-result v4

    if-nez v4, :cond_0

    .line 423
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 433
    .restart local v0    # "el":Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;, "Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement<*>;"
    .restart local v1    # "i":I
    :cond_5
    add-int/lit8 v1, v1, 0x1

    goto :goto_0
.end method

.method protected loadAtBottom(II)V
    .locals 5
    .param p1, "firstVisiblePosition"    # I
    .param p2, "lastVisiblePosition"    # I

    .prologue
    .line 1054
    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->searchDataSource:Lcom/amazon/retailsearch/interaction/SearchDataSource;

    invoke-virtual {v3}, Lcom/amazon/retailsearch/interaction/SearchDataSource;->getCurrentSearch()Lcom/amazon/retailsearch/data/SearchTask;

    move-result-object v2

    .line 1056
    .local v2, "searchTask":Lcom/amazon/retailsearch/data/SearchTask;
    invoke-interface {v2}, Lcom/amazon/retailsearch/data/SearchTask;->isLoading()Z

    move-result v3

    if-nez v3, :cond_0

    sget-object v3, Lcom/amazon/retailsearch/data/search/ResultStream$Status;->Error:Lcom/amazon/retailsearch/data/search/ResultStream$Status;

    invoke-interface {v2}, Lcom/amazon/retailsearch/data/SearchTask;->getStatus()Lcom/amazon/retailsearch/data/search/ResultStream$Status;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/amazon/retailsearch/data/search/ResultStream$Status;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 1070
    :cond_0
    :goto_0
    return-void

    .line 1061
    :cond_1
    move v0, p1

    .line 1062
    .local v0, "first":I
    move v1, p2

    .line 1066
    .local v1, "last":I
    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->results:Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;

    invoke-virtual {v3}, Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;->size()I

    move-result v3

    sub-int v4, v1, v0

    add-int/lit8 v4, v4, 0x1

    mul-int/lit8 v4, v4, 0x2

    sub-int/2addr v3, v4

    if-lt v1, v3, :cond_0

    .line 1068
    invoke-interface {v2}, Lcom/amazon/retailsearch/data/SearchTask;->loadNext()V

    goto :goto_0
.end method

.method protected loadAtfImage(Lcom/amazon/searchapp/retailsearch/model/Image;)V
    .locals 8
    .param p1, "atfImage"    # Lcom/amazon/searchapp/retailsearch/model/Image;

    .prologue
    .line 736
    iget-boolean v1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->enabled:Z

    if-eqz v1, :cond_0

    if-eqz p1, :cond_0

    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/Image;->getUrl()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 777
    :cond_0
    :goto_0
    return-void

    .line 742
    :cond_1
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->productImageFactory:Lcom/amazon/retailsearch/android/ui/ImageRequestFactory;

    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/Image;->getUrl()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v3}, Lcom/amazon/retailsearch/android/ui/ImageRequestFactory;->fromUrl(Ljava/lang/String;)Lcom/amazon/ansel/fetch/ImageRequest;

    move-result-object v5

    .line 743
    .local v5, "imageRequest":Lcom/amazon/ansel/fetch/ImageRequest;
    if-eqz v5, :cond_0

    .line 748
    new-instance v2, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$3;

    invoke-direct {v2, p0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$3;-><init>(Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;)V

    .line 767
    .local v2, "imageListener":Lcom/amazon/ansel/fetch/ResourceListener;, "Lcom/amazon/ansel/fetch/ResourceListener<Landroid/graphics/Bitmap;>;"
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->atfImageListeners:Ljava/util/List;

    invoke-interface {v1, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 769
    new-instance v0, Lcom/amazon/ansel/fetch/ImageLoader;

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->resourceProvider:Lcom/amazon/ansel/fetch/ResourceProvider;

    invoke-virtual {v1}, Lcom/amazon/ansel/fetch/ResourceProvider;->getContext()Lcom/amazon/ansel/fetch/LoaderContext;

    move-result-object v1

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v3

    const-wide/16 v6, 0x2710

    add-long/2addr v3, v6

    invoke-direct/range {v0 .. v5}, Lcom/amazon/ansel/fetch/ImageLoader;-><init>(Lcom/amazon/ansel/fetch/LoaderContext;Lcom/amazon/ansel/fetch/ResourceListener;JLcom/amazon/ansel/fetch/ImageRequest;)V

    .line 776
    .local v0, "loader":Lcom/amazon/ansel/fetch/ImageLoader;
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->resourceProvider:Lcom/amazon/ansel/fetch/ResourceProvider;

    invoke-virtual {v1, v0}, Lcom/amazon/ansel/fetch/ResourceProvider;->execute(Lcom/amazon/ansel/fetch/ResourceLoader;)V

    goto :goto_0
.end method

.method public pause()V
    .locals 1

    .prologue
    .line 258
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->asinVisibilityReporter:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$AsinVisibilityReporter;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$AsinVisibilityReporter;->stopMonitoring()V

    .line 259
    return-void
.end method

.method protected preloadImages(Lcom/amazon/searchapp/retailsearch/model/PreloadImages;)V
    .locals 5
    .param p1, "preloadImages"    # Lcom/amazon/searchapp/retailsearch/model/PreloadImages;

    .prologue
    .line 710
    iget-boolean v3, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->enabled:Z

    if-eqz v3, :cond_0

    if-nez p1, :cond_1

    .line 725
    :cond_0
    return-void

    .line 714
    :cond_1
    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/PreloadImages;->getImages()Ljava/util/List;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_2
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/searchapp/retailsearch/model/Image;

    .line 715
    .local v1, "image":Lcom/amazon/searchapp/retailsearch/model/Image;
    if-eqz v1, :cond_2

    invoke-interface {v1}, Lcom/amazon/searchapp/retailsearch/model/Image;->getUrl()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_2

    .line 719
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->getProductImageFactory()Lcom/amazon/retailsearch/android/ui/ImageRequestFactory;

    move-result-object v3

    invoke-interface {v1}, Lcom/amazon/searchapp/retailsearch/model/Image;->getUrl()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v3, v4}, Lcom/amazon/retailsearch/android/ui/ImageRequestFactory;->fromUrl(Ljava/lang/String;)Lcom/amazon/ansel/fetch/ImageRequest;

    move-result-object v2

    .line 721
    .local v2, "request":Lcom/amazon/ansel/fetch/ImageRequest;
    if-eqz v2, :cond_2

    .line 722
    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->resourceProvider:Lcom/amazon/ansel/fetch/ResourceProvider;

    const/4 v4, 0x0

    invoke-virtual {v3, v2, v4}, Lcom/amazon/ansel/fetch/ResourceProvider;->getImage(Lcom/amazon/ansel/fetch/ImageRequest;Lcom/amazon/ansel/fetch/ResourceListener;)V

    goto :goto_0
.end method

.method protected reset()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    const/4 v2, 0x0

    .line 340
    iput-boolean v3, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->enabled:Z

    .line 341
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->searchDataSource:Lcom/amazon/retailsearch/interaction/SearchDataSource;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/interaction/SearchDataSource;->getCurrentSearch()Lcom/amazon/retailsearch/data/SearchTask;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->listener:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$Listener;

    invoke-interface {v0, v1}, Lcom/amazon/retailsearch/data/SearchTask;->removeListener(Lcom/amazon/retailsearch/data/SearchTask$SearchTaskListener;)Z

    .line 342
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->results:Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;->clear()V

    .line 344
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->detachViews()V

    .line 346
    iput-object v2, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->adapter:Lcom/amazon/retailsearch/android/ui/listadapter/GeneratorAdapter;

    .line 347
    iput-object v2, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->state:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;

    .line 348
    iput-object v2, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->prevState:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;

    .line 349
    iput-boolean v3, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->modified:Z

    .line 350
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->atfImageListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 351
    return-void
.end method

.method protected restoreUserState(Lcom/amazon/retailsearch/android/ui/results/layout/UserState;)V
    .locals 5
    .param p1, "state"    # Lcom/amazon/retailsearch/android/ui/results/layout/UserState;

    .prologue
    .line 317
    if-nez p1, :cond_1

    .line 337
    :cond_0
    :goto_0
    return-void

    .line 321
    :cond_1
    invoke-virtual {p1}, Lcom/amazon/retailsearch/android/ui/results/layout/UserState;->getSelectedModel()Ljava/lang/Object;

    move-result-object v0

    .line 322
    .local v0, "canonicalModel":Ljava/lang/Object;
    if-nez v0, :cond_2

    .line 324
    invoke-virtual {p1}, Lcom/amazon/retailsearch/android/ui/results/layout/UserState;->getCurrentDataInFocus()Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;

    move-result-object v1

    .line 326
    .local v1, "currentFocusedContent":Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;
    if-eqz v1, :cond_0

    invoke-interface {v1}, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;->getCanonicalModel()Ljava/lang/Object;

    move-result-object v3

    if-eqz v3, :cond_0

    .line 330
    invoke-interface {v1}, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;->getCanonicalModel()Ljava/lang/Object;

    move-result-object v0

    .line 333
    .end local v1    # "currentFocusedContent":Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;
    :cond_2
    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->results:Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;

    invoke-virtual {v3, v0}, Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;->getByModel(Ljava/lang/Object;)Ljava/lang/Integer;

    move-result-object v2

    .line 334
    .local v2, "targetListSelection":Ljava/lang/Integer;
    if-eqz v2, :cond_0

    .line 335
    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->stackView:Lcom/amazon/retailsearch/android/ui/results/layout/StackView;

    invoke-virtual {v2}, Ljava/lang/Integer;->intValue()I

    move-result v4

    invoke-interface {v3, v4}, Lcom/amazon/retailsearch/android/ui/results/layout/StackView;->setSelection(I)V

    goto :goto_0
.end method

.method public resume()V
    .locals 1

    .prologue
    .line 252
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->asinVisibilityReporter:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$AsinVisibilityReporter;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$AsinVisibilityReporter;->startMonitoring()V

    .line 253
    return-void
.end method

.method public setAsinGroupCount(I)V
    .locals 0
    .param p1, "count"    # I

    .prologue
    .line 182
    iput p1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->asinGroupCount:I

    .line 183
    return-void
.end method

.method public setEntryGroupAsin(Ljava/lang/String;)V
    .locals 2
    .param p1, "asin"    # Ljava/lang/String;

    .prologue
    .line 194
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->state:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;

    if-nez v0, :cond_0

    .line 196
    new-instance v0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;

    invoke-direct {v0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;-><init>()V

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->state:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;

    .line 198
    :cond_0
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->state:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;

    invoke-virtual {v0, p1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->setEntryAsin(Ljava/lang/String;)V

    .line 199
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->state:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;

    invoke-virtual {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->getAsinGroupIndex(Ljava/lang/String;)I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->setEntryGroupIndex(I)V

    .line 200
    return-void
.end method

.method protected setStackView(Lcom/amazon/retailsearch/android/ui/results/layout/StackView;)V
    .locals 0
    .param p1, "stackView"    # Lcom/amazon/retailsearch/android/ui/results/layout/StackView;

    .prologue
    .line 1443
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->stackView:Lcom/amazon/retailsearch/android/ui/results/layout/StackView;

    .line 1444
    return-void
.end method

.method protected showMainContent(Z)V
    .locals 5
    .param p1, "flush"    # Z

    .prologue
    .line 619
    const/4 v1, 0x0

    .line 621
    .local v1, "i":I
    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->state:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;

    invoke-virtual {v3}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->getMainContent()Ljava/util/List;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$MainElement;

    .line 622
    .local v0, "el":Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$MainElement;
    if-nez p1, :cond_2

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$MainElement;->getPosition()I

    move-result v3

    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->state:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;

    invoke-virtual {v4}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->getProductRowCount()I

    move-result v4

    if-le v3, v4, :cond_2

    .line 630
    .end local v0    # "el":Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$MainElement;
    :cond_0
    if-lez v1, :cond_1

    .line 631
    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->state:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;

    invoke-virtual {v3}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->getMainContent()Ljava/util/List;

    move-result-object v3

    const/4 v4, 0x0

    invoke-interface {v3, v4, v1}, Ljava/util/List;->subList(II)Ljava/util/List;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/List;->clear()V

    .line 633
    :cond_1
    return-void

    .line 626
    .restart local v0    # "el":Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$MainElement;
    :cond_2
    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$MainElement;->getViewEntry()Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntry;

    move-result-object v3

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$MainElement;->getLayoutElementModel()Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;

    move-result-object v4

    invoke-virtual {p0, v3, v4}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->add(Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntry;Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;)V

    .line 627
    add-int/lit8 v1, v1, 0x1

    goto :goto_0
.end method

.method protected showPendingContent(Z)V
    .locals 5
    .param p1, "flush"    # Z

    .prologue
    .line 645
    const/4 v1, 0x0

    .line 647
    .local v1, "i":I
    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->state:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;

    invoke-virtual {v3}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->getPendingContent()Ljava/util/List;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;

    .line 648
    .local v0, "el":Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;, "Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement<*>;"
    if-nez p1, :cond_2

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;->getRequestedPosition()I

    move-result v3

    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->state:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;

    invoke-virtual {v4}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->getNextPosition()I

    move-result v4

    if-le v3, v4, :cond_2

    .line 656
    .end local v0    # "el":Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;, "Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement<*>;"
    :cond_0
    if-lez v1, :cond_1

    .line 657
    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->state:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;

    invoke-virtual {v3}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->getPendingContent()Ljava/util/List;

    move-result-object v3

    const/4 v4, 0x0

    invoke-interface {v3, v4, v1}, Ljava/util/List;->subList(II)Ljava/util/List;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/List;->clear()V

    .line 659
    :cond_1
    return-void

    .line 652
    .restart local v0    # "el":Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;, "Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement<*>;"
    :cond_2
    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->insert(Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;)V

    .line 653
    add-int/lit8 v1, v1, 0x1

    goto :goto_0
.end method

.method protected showProducts(Z)V
    .locals 14
    .param p1, "flush"    # Z

    .prologue
    const/4 v13, 0x1

    const/4 v12, 0x0

    .line 490
    iget-object v9, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->state:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;

    invoke-virtual {v9}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->getProducts()Ljava/util/List;

    move-result-object v8

    .line 492
    .local v8, "products":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/Product;>;"
    invoke-interface {v8}, Ljava/util/List;->isEmpty()Z

    move-result v9

    if-eqz v9, :cond_1

    .line 556
    :cond_0
    :goto_0
    return-void

    .line 496
    :cond_1
    const/4 v1, 0x0

    .line 499
    .local v1, "i":I
    :goto_1
    iget-object v9, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->state:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;

    invoke-virtual {v9}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->getProductRow()Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;

    move-result-object v0

    .line 502
    .local v0, "el":Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;, "Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement<Lcom/amazon/retailsearch/android/ui/results/layout/entry/ContentRowEntry;>;"
    if-eqz v0, :cond_3

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;->getEntry()Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntry;

    move-result-object v9

    if-eqz v9, :cond_3

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;->getEntry()Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntry;

    move-result-object v9

    check-cast v9, Lcom/amazon/retailsearch/android/ui/results/layout/entry/ContentRowEntry;

    invoke-virtual {v9}, Lcom/amazon/retailsearch/android/ui/results/layout/entry/ContentRowEntry;->getModel()Ljava/lang/Object;

    move-result-object v9

    if-eqz v9, :cond_3

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;->getEntry()Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntry;

    move-result-object v9

    check-cast v9, Lcom/amazon/retailsearch/android/ui/results/layout/entry/ContentRowEntry;

    invoke-virtual {v9}, Lcom/amazon/retailsearch/android/ui/results/layout/entry/ContentRowEntry;->getModel()Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Lcom/amazon/retailsearch/android/ui/results/layout/model/ContentRowModel;

    invoke-virtual {v9}, Lcom/amazon/retailsearch/android/ui/results/layout/model/ContentRowModel;->getContent()Ljava/util/List;

    move-result-object v9

    if-eqz v9, :cond_3

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;->getEntry()Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntry;

    move-result-object v9

    check-cast v9, Lcom/amazon/retailsearch/android/ui/results/layout/entry/ContentRowEntry;

    invoke-virtual {v9}, Lcom/amazon/retailsearch/android/ui/results/layout/entry/ContentRowEntry;->getModel()Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Lcom/amazon/retailsearch/android/ui/results/layout/model/ContentRowModel;

    invoke-virtual {v9}, Lcom/amazon/retailsearch/android/ui/results/layout/model/ContentRowModel;->getContent()Ljava/util/List;

    move-result-object v9

    invoke-interface {v9}, Ljava/util/List;->size()I

    move-result v10

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;->getEntry()Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntry;

    move-result-object v9

    check-cast v9, Lcom/amazon/retailsearch/android/ui/results/layout/entry/ContentRowEntry;

    invoke-virtual {v9}, Lcom/amazon/retailsearch/android/ui/results/layout/entry/ContentRowEntry;->getModel()Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Lcom/amazon/retailsearch/android/ui/results/layout/model/ContentRowModel;

    invoke-virtual {v9}, Lcom/amazon/retailsearch/android/ui/results/layout/model/ContentRowModel;->getColumns()I

    move-result v9

    if-ge v10, v9, :cond_3

    .line 507
    new-instance v6, Lcom/amazon/retailsearch/android/ui/results/layout/model/ContentRowModel;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;->getEntry()Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntry;

    move-result-object v9

    check-cast v9, Lcom/amazon/retailsearch/android/ui/results/layout/entry/ContentRowEntry;

    invoke-virtual {v9}, Lcom/amazon/retailsearch/android/ui/results/layout/entry/ContentRowEntry;->getModel()Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Lcom/amazon/retailsearch/android/ui/results/layout/model/ContentRowModel;

    invoke-direct {v6, v9}, Lcom/amazon/retailsearch/android/ui/results/layout/model/ContentRowModel;-><init>(Lcom/amazon/retailsearch/android/ui/results/layout/model/ContentRowModel;)V

    .line 508
    .local v6, "model":Lcom/amazon/retailsearch/android/ui/results/layout/model/ContentRowModel;
    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;->getEntry()Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntry;

    move-result-object v9

    check-cast v9, Lcom/amazon/retailsearch/android/ui/results/layout/entry/ContentRowEntry;

    invoke-virtual {v9, v6}, Lcom/amazon/retailsearch/android/ui/results/layout/entry/ContentRowEntry;->setModel(Ljava/lang/Object;)V

    .line 509
    iput-boolean v13, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->modified:Z

    .line 528
    :goto_2
    invoke-interface {v8}, Ljava/util/List;->size()I

    move-result v9

    invoke-virtual {v6}, Lcom/amazon/retailsearch/android/ui/results/layout/model/ContentRowModel;->getColumns()I

    move-result v10

    add-int/2addr v10, v1

    invoke-virtual {v6}, Lcom/amazon/retailsearch/android/ui/results/layout/model/ContentRowModel;->getContent()Ljava/util/List;

    move-result-object v11

    invoke-interface {v11}, Ljava/util/List;->size()I

    move-result v11

    sub-int/2addr v10, v11

    invoke-static {v9, v10}, Ljava/lang/Math;->min(II)I

    move-result v3

    .line 530
    .local v3, "last":I
    if-lt v1, v3, :cond_6

    .line 553
    .end local v3    # "last":I
    .end local v6    # "model":Lcom/amazon/retailsearch/android/ui/results/layout/model/ContentRowModel;
    :cond_2
    if-lez v1, :cond_0

    .line 554
    invoke-interface {v8, v12, v1}, Ljava/util/List;->subList(II)Ljava/util/List;

    move-result-object v9

    invoke-interface {v9}, Ljava/util/List;->clear()V

    goto/16 :goto_0

    .line 511
    :cond_3
    if-nez p1, :cond_4

    invoke-interface {v8}, Ljava/util/List;->size()I

    move-result v9

    sub-int/2addr v9, v1

    iget v10, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->minRowSize:I

    if-lt v9, v10, :cond_2

    .line 517
    :cond_4
    new-instance v6, Lcom/amazon/retailsearch/android/ui/results/layout/model/ContentRowModel;

    new-instance v9, Ljava/util/ArrayList;

    iget v10, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->columns:I

    invoke-direct {v9, v10}, Ljava/util/ArrayList;-><init>(I)V

    iget v10, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->columns:I

    invoke-direct {v6, v9, v10, v12}, Lcom/amazon/retailsearch/android/ui/results/layout/model/ContentRowModel;-><init>(Ljava/util/List;II)V

    .line 518
    .restart local v6    # "model":Lcom/amazon/retailsearch/android/ui/results/layout/model/ContentRowModel;
    invoke-virtual {p0, v6}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->createRow(Lcom/amazon/retailsearch/android/ui/results/layout/model/ContentRowModel;)Lcom/amazon/retailsearch/android/ui/results/layout/entry/ContentRowEntry;

    move-result-object v9

    new-instance v10, Ljava/util/ArrayList;

    iget v11, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->columns:I

    invoke-direct {v10, v11}, Ljava/util/ArrayList;-><init>(I)V

    invoke-static {v10}, Lcom/amazon/retailsearch/android/ui/results/layout/ListBasedLayoutElementModel;->create(Ljava/util/List;)Lcom/amazon/retailsearch/android/ui/results/layout/ListBasedLayoutElementModel;

    move-result-object v10

    invoke-virtual {p0, v9, v10}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->createLayoutElement(Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntry;Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;)Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;

    move-result-object v0

    .line 519
    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->add(Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;)V

    .line 520
    iget-object v9, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->state:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;

    invoke-virtual {v9, v0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->setProductRow(Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;)V

    .line 521
    iget-object v9, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->state:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;

    iget-object v10, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->state:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;

    invoke-virtual {v10}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->getProductRowCount()I

    move-result v10

    add-int/lit8 v10, v10, 0x1

    invoke-virtual {v9, v10}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->setProductRowCount(I)V

    .line 525
    invoke-virtual {p0, v12}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->showMainContent(Z)V

    goto :goto_2

    .line 548
    .restart local v3    # "last":I
    .local v5, "loaders":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/ansel/fetch/tools/collection/Factory<Lcom/amazon/ansel/fetch/ResourceLoader<*>;>;>;"
    .local v7, "product":Lcom/amazon/searchapp/retailsearch/model/Product;
    :cond_5
    iput-boolean v13, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->modified:Z

    .line 534
    add-int/lit8 v1, v1, 0x1

    .end local v5    # "loaders":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/ansel/fetch/tools/collection/Factory<Lcom/amazon/ansel/fetch/ResourceLoader<*>;>;>;"
    .end local v7    # "product":Lcom/amazon/searchapp/retailsearch/model/Product;
    :cond_6
    if-ge v1, v3, :cond_7

    .line 535
    invoke-interface {v8, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lcom/amazon/searchapp/retailsearch/model/Product;

    .line 536
    .restart local v7    # "product":Lcom/amazon/searchapp/retailsearch/model/Product;
    invoke-virtual {v6}, Lcom/amazon/retailsearch/android/ui/results/layout/model/ContentRowModel;->getContent()Ljava/util/List;

    move-result-object v9

    invoke-virtual {p0, v7}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->createProductCell(Lcom/amazon/searchapp/retailsearch/model/Product;)Lcom/amazon/retailsearch/android/ui/listadapter/ViewBuilderEntry;

    move-result-object v10

    invoke-interface {v9, v10}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 537
    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;->getLayoutElementModel()Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;

    move-result-object v9

    check-cast v9, Lcom/amazon/retailsearch/android/ui/results/layout/ListBasedLayoutElementModel;

    invoke-virtual {v9}, Lcom/amazon/retailsearch/android/ui/results/layout/ListBasedLayoutElementModel;->getAllModels()Ljava/util/List;

    move-result-object v9

    invoke-interface {v9, v7}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 538
    iget-object v9, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->results:Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;->getLayoutElementModel()Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;

    move-result-object v10

    invoke-virtual {v9, v10}, Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;->updateModels(Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;)V

    .line 540
    invoke-virtual {p0, v7}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->getProductLoaders(Lcom/amazon/searchapp/retailsearch/model/Product;)Ljava/util/List;

    move-result-object v5

    .line 542
    .restart local v5    # "loaders":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/ansel/fetch/tools/collection/Factory<Lcom/amazon/ansel/fetch/ResourceLoader<*>;>;>;"
    if-eqz v5, :cond_5

    .line 543
    invoke-interface {v5}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :goto_3
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v9

    if-eqz v9, :cond_5

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/amazon/ansel/fetch/tools/collection/Factory;

    .line 544
    .local v4, "loader":Lcom/amazon/ansel/fetch/tools/collection/Factory;, "Lcom/amazon/ansel/fetch/tools/collection/Factory<Lcom/amazon/ansel/fetch/ResourceLoader<*>;>;"
    invoke-virtual {v0, v4}, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;->addLoader(Lcom/amazon/ansel/fetch/tools/collection/Factory;)V

    goto :goto_3

    .line 550
    .end local v2    # "i$":Ljava/util/Iterator;
    .end local v4    # "loader":Lcom/amazon/ansel/fetch/tools/collection/Factory;, "Lcom/amazon/ansel/fetch/tools/collection/Factory<Lcom/amazon/ansel/fetch/ResourceLoader<*>;>;"
    .end local v5    # "loaders":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/ansel/fetch/tools/collection/Factory<Lcom/amazon/ansel/fetch/ResourceLoader<*>;>;>;"
    .end local v7    # "product":Lcom/amazon/searchapp/retailsearch/model/Product;
    :cond_7
    iget-object v9, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->results:Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;->getLayoutElementModel()Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;

    move-result-object v10

    invoke-virtual {v9, v10}, Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;->finalizeModels(Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;)V

    goto/16 :goto_1
.end method

.method protected showProgressBar()V
    .locals 2

    .prologue
    .line 1484
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->progressBar:Landroid/widget/LinearLayout;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 1485
    return-void
.end method

.method protected startPage()V
    .locals 2

    .prologue
    .line 680
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->state:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;

    if-nez v0, :cond_0

    .line 681
    new-instance v0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;

    invoke-direct {v0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;-><init>()V

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->state:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;

    .line 684
    :cond_0
    new-instance v0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->state:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;

    invoke-direct {v0, v1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;-><init>(Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;)V

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->prevState:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;

    .line 685
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->state:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->results:Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;->size()I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->setStartingSize(I)V

    .line 686
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->state:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->state:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->getNextPosition()I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->setStartingPosition(I)V

    .line 687
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->state:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->state:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->getProductRowCount()I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->setStartingProductRowCount(I)V

    .line 688
    return-void
.end method

.method protected update()V
    .locals 1

    .prologue
    .line 666
    iget-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->enabled:Z

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->modified:Z

    if-eqz v0, :cond_0

    .line 667
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->adapter:Lcom/amazon/retailsearch/android/ui/listadapter/GeneratorAdapter;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/listadapter/GeneratorAdapter;->notifyDataSetChanged()V

    .line 668
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->modified:Z

    .line 670
    :cond_0
    return-void
.end method
