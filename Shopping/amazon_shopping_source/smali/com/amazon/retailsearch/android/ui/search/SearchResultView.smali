.class public Lcom/amazon/retailsearch/android/ui/search/SearchResultView;
.super Landroid/widget/LinearLayout;
.source "SearchResultView.java"

# interfaces
.implements Lcom/amazon/retailsearch/interaction/SearchChangeListener;
.implements Lcom/amazon/retailsearch/userpreferences/UserPreferenceChangeListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/retailsearch/android/ui/search/SearchResultView$1;,
        Lcom/amazon/retailsearch/android/ui/search/SearchResultView$TaskListener;
    }
.end annotation


# static fields
.field public static final TAG:Ljava/lang/String;


# instance fields
.field private asinImpressionTracker:Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;

.field private detailInterface:Lcom/amazon/retailsearch/android/api/display/DetailDisplayInterface;

.field private entryIndex:I

.field featureConfig:Lcom/amazon/retailsearch/android/api/experimentation/FeatureConfiguration;
    .annotation runtime Ljavax/inject/Inject;
    .end annotation
.end field

.field private hasViewType:Z

.field private infoBar:Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;

.field private layout:Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayout;

.field private layoutType:Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayoutType;

.field private final layouts:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayoutType;",
            "Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayout;",
            ">;"
        }
    .end annotation
.end field

.field private final numColumnsGalleryLandscape:I

.field private final numColumnsGalleryPortrait:I

.field private final numColumnsGridLandscape:I

.field private final numColumnsGridPortrait:I

.field private final numColumnsListLandscape:I

.field private final numColumnsListPortrait:I

.field private oldOrientation:I

.field parentResourceProvider:Lcom/amazon/ansel/fetch/ResourceProvider;
    .annotation runtime Ljavax/inject/Inject;
    .end annotation
.end field

.field preferencesManager:Lcom/amazon/retailsearch/userpreferences/UserPreferenceManager;
    .annotation runtime Ljavax/inject/Inject;
    .end annotation
.end field

.field private previousLayoutType:Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayoutType;

.field private resourceProvider:Lcom/amazon/ansel/fetch/ResourceProvider;

.field private retailSearchLogger:Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

.field searchDataSource:Lcom/amazon/retailsearch/interaction/SearchDataSource;
    .annotation runtime Ljavax/inject/Inject;
    .end annotation
.end field

.field private taskListener:Lcom/amazon/retailsearch/android/ui/search/SearchResultView$TaskListener;

.field userInteractionListener:Lcom/amazon/retailsearch/interaction/UserInteractionListener;
    .annotation runtime Ljavax/inject/Inject;
    .end annotation
.end field

.field private userState:Lcom/amazon/retailsearch/android/ui/results/layout/UserState;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 56
    const-class v0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 86
    invoke-direct {p0, p1}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    .line 60
    new-instance v0, Ljava/util/HashMap;

    const/4 v1, 0x5

    invoke-direct {v0, v1}, Ljava/util/HashMap;-><init>(I)V

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->layouts:Ljava/util/Map;

    .line 63
    new-instance v0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView$TaskListener;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lcom/amazon/retailsearch/android/ui/search/SearchResultView$TaskListener;-><init>(Lcom/amazon/retailsearch/android/ui/search/SearchResultView;Lcom/amazon/retailsearch/android/ui/search/SearchResultView$1;)V

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->taskListener:Lcom/amazon/retailsearch/android/ui/search/SearchResultView$TaskListener;

    .line 67
    new-instance v0, Lcom/amazon/retailsearch/android/ui/results/layout/UserState;

    invoke-direct {v0}, Lcom/amazon/retailsearch/android/ui/results/layout/UserState;-><init>()V

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->userState:Lcom/amazon/retailsearch/android/ui/results/layout/UserState;

    .line 68
    new-instance v0, Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;

    invoke-direct {v0}, Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;-><init>()V

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->asinImpressionTracker:Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;

    .line 71
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/retailsearch/R$integer;->config_rs_grid_columns_landscape:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getInteger(I)I

    move-result v0

    iput v0, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->numColumnsGridLandscape:I

    .line 72
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/retailsearch/R$integer;->config_rs_grid_columns_portrait:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getInteger(I)I

    move-result v0

    iput v0, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->numColumnsGridPortrait:I

    .line 73
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/retailsearch/R$integer;->config_rs_gallery_columns_landscape:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getInteger(I)I

    move-result v0

    iput v0, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->numColumnsGalleryLandscape:I

    .line 74
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/retailsearch/R$integer;->config_rs_gallery_columns_portrait:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getInteger(I)I

    move-result v0

    iput v0, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->numColumnsGalleryPortrait:I

    .line 75
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/retailsearch/R$integer;->config_rs_list_columns_landscape:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getInteger(I)I

    move-result v0

    iput v0, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->numColumnsListLandscape:I

    .line 76
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/retailsearch/R$integer;->config_rs_list_columns_portrait:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getInteger(I)I

    move-result v0

    iput v0, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->numColumnsListPortrait:I

    .line 77
    const/4 v0, -0x1

    iput v0, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->oldOrientation:I

    .line 78
    invoke-static {}, Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;->getInstance()Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;->getRetailSearchLogger()Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->retailSearchLogger:Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

    .line 87
    invoke-direct {p0}, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->init()V

    .line 88
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 91
    invoke-direct {p0, p1, p2}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 60
    new-instance v0, Ljava/util/HashMap;

    const/4 v1, 0x5

    invoke-direct {v0, v1}, Ljava/util/HashMap;-><init>(I)V

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->layouts:Ljava/util/Map;

    .line 63
    new-instance v0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView$TaskListener;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lcom/amazon/retailsearch/android/ui/search/SearchResultView$TaskListener;-><init>(Lcom/amazon/retailsearch/android/ui/search/SearchResultView;Lcom/amazon/retailsearch/android/ui/search/SearchResultView$1;)V

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->taskListener:Lcom/amazon/retailsearch/android/ui/search/SearchResultView$TaskListener;

    .line 67
    new-instance v0, Lcom/amazon/retailsearch/android/ui/results/layout/UserState;

    invoke-direct {v0}, Lcom/amazon/retailsearch/android/ui/results/layout/UserState;-><init>()V

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->userState:Lcom/amazon/retailsearch/android/ui/results/layout/UserState;

    .line 68
    new-instance v0, Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;

    invoke-direct {v0}, Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;-><init>()V

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->asinImpressionTracker:Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;

    .line 71
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/retailsearch/R$integer;->config_rs_grid_columns_landscape:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getInteger(I)I

    move-result v0

    iput v0, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->numColumnsGridLandscape:I

    .line 72
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/retailsearch/R$integer;->config_rs_grid_columns_portrait:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getInteger(I)I

    move-result v0

    iput v0, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->numColumnsGridPortrait:I

    .line 73
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/retailsearch/R$integer;->config_rs_gallery_columns_landscape:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getInteger(I)I

    move-result v0

    iput v0, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->numColumnsGalleryLandscape:I

    .line 74
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/retailsearch/R$integer;->config_rs_gallery_columns_portrait:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getInteger(I)I

    move-result v0

    iput v0, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->numColumnsGalleryPortrait:I

    .line 75
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/retailsearch/R$integer;->config_rs_list_columns_landscape:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getInteger(I)I

    move-result v0

    iput v0, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->numColumnsListLandscape:I

    .line 76
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/retailsearch/R$integer;->config_rs_list_columns_portrait:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getInteger(I)I

    move-result v0

    iput v0, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->numColumnsListPortrait:I

    .line 77
    const/4 v0, -0x1

    iput v0, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->oldOrientation:I

    .line 78
    invoke-static {}, Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;->getInstance()Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;->getRetailSearchLogger()Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->retailSearchLogger:Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

    .line 92
    invoke-direct {p0}, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->init()V

    .line 93
    return-void
.end method

.method static synthetic access$100(Lcom/amazon/retailsearch/android/ui/search/SearchResultView;)Z
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/search/SearchResultView;

    .prologue
    .line 55
    iget-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->hasViewType:Z

    return v0
.end method

.method static synthetic access$102(Lcom/amazon/retailsearch/android/ui/search/SearchResultView;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/search/SearchResultView;
    .param p1, "x1"    # Z

    .prologue
    .line 55
    iput-boolean p1, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->hasViewType:Z

    return p1
.end method

.method static synthetic access$200(Lcom/amazon/retailsearch/android/ui/search/SearchResultView;)Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/search/SearchResultView;

    .prologue
    .line 55
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->infoBar:Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;

    return-object v0
.end method

.method private adjustViewForOrientation(I)V
    .locals 12
    .param p1, "orientation"    # I

    .prologue
    const/4 v11, 0x0

    const/4 v10, -0x1

    const/4 v9, 0x0

    .line 315
    iget-object v6, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->layout:Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayout;

    if-eqz v6, :cond_0

    .line 317
    iget-object v6, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->layout:Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayout;

    iget-object v7, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->userState:Lcom/amazon/retailsearch/android/ui/results/layout/UserState;

    invoke-interface {v6, p1, v7}, Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayout;->changeOrientation(ILcom/amazon/retailsearch/android/ui/results/layout/UserState;)V

    .line 319
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->isInSplitView()Z

    move-result v6

    if-eqz v6, :cond_1

    .line 321
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->getParent()Landroid/view/ViewParent;

    move-result-object v3

    check-cast v3, Landroid/widget/FrameLayout;

    .line 322
    .local v3, "parentLayout":Landroid/widget/FrameLayout;
    if-nez v3, :cond_2

    .line 324
    iget-object v6, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->retailSearchLogger:Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v8, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->TAG:Ljava/lang/String;

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string/jumbo v8, ": Cannot find the parent layout for the Split View"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-interface {v6, v7, v11}, Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 362
    .end local v3    # "parentLayout":Landroid/widget/FrameLayout;
    :cond_1
    :goto_0
    return-void

    .line 328
    .restart local v3    # "parentLayout":Landroid/widget/FrameLayout;
    :cond_2
    invoke-virtual {v3, v9}, Landroid/widget/FrameLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v5

    .line 330
    .local v5, "webView":Landroid/view/View;
    packed-switch p1, :pswitch_data_0

    .line 359
    iget-object v6, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->retailSearchLogger:Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v8, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->TAG:Ljava/lang/String;

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string/jumbo v8, ": received and invalid value for orientation"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-interface {v6, v7, v11}, Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0

    .line 333
    :pswitch_0
    if-eqz v5, :cond_3

    .line 335
    new-instance v0, Landroid/widget/FrameLayout$LayoutParams;

    invoke-direct {v0, v10, v10}, Landroid/widget/FrameLayout$LayoutParams;-><init>(II)V

    .line 337
    .local v0, "frameLayoutParams":Landroid/widget/FrameLayout$LayoutParams;
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    sget v7, Lcom/amazon/retailsearch/R$dimen;->rs_split_view_land_layout_width:I

    invoke-virtual {v6, v7}, Landroid/content/res/Resources;->getDimension(I)F

    move-result v6

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    sget v8, Lcom/amazon/retailsearch/R$dimen;->rs_split_view_divider_right_margin:I

    invoke-virtual {v7, v8}, Landroid/content/res/Resources;->getDimension(I)F

    move-result v7

    sub-float v2, v6, v7

    .line 339
    .local v2, "leftMargin":F
    float-to-int v6, v2

    invoke-virtual {v0, v6, v9, v9, v9}, Landroid/widget/FrameLayout$LayoutParams;->setMargins(IIII)V

    .line 340
    invoke-virtual {v5, v0}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 342
    .end local v0    # "frameLayoutParams":Landroid/widget/FrameLayout$LayoutParams;
    .end local v2    # "leftMargin":F
    :cond_3
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v1

    .line 343
    .local v1, "layoutParams":Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    sget v7, Lcom/amazon/retailsearch/R$dimen;->rs_split_view_land_layout_width:I

    invoke-virtual {v6, v7}, Landroid/content/res/Resources;->getDimension(I)F

    move-result v6

    float-to-int v6, v6

    iput v6, v1, Landroid/view/ViewGroup$LayoutParams;->width:I

    .line 344
    iput v10, v1, Landroid/view/ViewGroup$LayoutParams;->height:I

    goto :goto_0

    .line 347
    .end local v1    # "layoutParams":Landroid/view/ViewGroup$LayoutParams;
    :pswitch_1
    if-eqz v5, :cond_4

    .line 348
    new-instance v0, Landroid/widget/FrameLayout$LayoutParams;

    invoke-direct {v0, v10, v10}, Landroid/widget/FrameLayout$LayoutParams;-><init>(II)V

    .line 349
    .restart local v0    # "frameLayoutParams":Landroid/widget/FrameLayout$LayoutParams;
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    sget v7, Lcom/amazon/retailsearch/R$dimen;->rs_split_view_port_layout_height:I

    invoke-virtual {v6, v7}, Landroid/content/res/Resources;->getDimension(I)F

    move-result v6

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    sget v8, Lcom/amazon/retailsearch/R$dimen;->rs_split_view_divider_bottom_margin:I

    invoke-virtual {v7, v8}, Landroid/content/res/Resources;->getDimension(I)F

    move-result v7

    sub-float v4, v6, v7

    .line 351
    .local v4, "topMargin":F
    float-to-int v6, v4

    invoke-virtual {v0, v9, v6, v9, v9}, Landroid/widget/FrameLayout$LayoutParams;->setMargins(IIII)V

    .line 352
    invoke-virtual {v5, v0}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 354
    .end local v0    # "frameLayoutParams":Landroid/widget/FrameLayout$LayoutParams;
    .end local v4    # "topMargin":F
    :cond_4
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v1

    .line 355
    .restart local v1    # "layoutParams":Landroid/view/ViewGroup$LayoutParams;
    iput v10, v1, Landroid/view/ViewGroup$LayoutParams;->width:I

    .line 356
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    sget v7, Lcom/amazon/retailsearch/R$dimen;->rs_split_view_port_layout_height:I

    invoke-virtual {v6, v7}, Landroid/content/res/Resources;->getDimension(I)F

    move-result v6

    float-to-int v6, v6

    iput v6, v1, Landroid/view/ViewGroup$LayoutParams;->height:I

    goto/16 :goto_0

    .line 330
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method private buildInfoBar()V
    .locals 2

    .prologue
    .line 119
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->getContext()Landroid/content/Context;

    move-result-object v0

    sget v1, Lcom/amazon/retailsearch/R$layout;->result_header:I

    invoke-static {v0, v1, p0}, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    .line 120
    sget v0, Lcom/amazon/retailsearch/R$id;->results_info_bar:I

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->infoBar:Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;

    .line 121
    return-void
.end method

.method private closeLayout()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 138
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->layout:Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayout;

    if-eqz v0, :cond_0

    .line 140
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->layoutType:Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayoutType;

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->previousLayoutType:Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayoutType;

    .line 141
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->layout:Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayout;

    invoke-interface {v0}, Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayout;->disable()Lcom/amazon/retailsearch/android/ui/results/layout/UserState;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->userState:Lcom/amazon/retailsearch/android/ui/results/layout/UserState;

    .line 142
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->userState:Lcom/amazon/retailsearch/android/ui/results/layout/UserState;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/results/layout/UserState;->getEntryIndex()I

    move-result v0

    iput v0, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->entryIndex:I

    .line 143
    iput-object v1, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->layout:Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayout;

    .line 144
    iput-object v1, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->layoutType:Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayoutType;

    .line 146
    :cond_0
    return-void
.end method

.method private createLayout(Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayoutType;Z)Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayout;
    .locals 6
    .param p1, "type"    # Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayoutType;
    .param p2, "landscape"    # Z

    .prologue
    .line 162
    sget-object v0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView$1;->$SwitchMap$com$amazon$retailsearch$android$ui$results$layout$SearchLayoutType:[I

    invoke-virtual {p1}, Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayoutType;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 175
    const/4 v0, 0x0

    :goto_0
    return-object v0

    .line 164
    :pswitch_0
    new-instance v0, Lcom/amazon/retailsearch/android/ui/results/layout/ListLayout;

    iget v2, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->numColumnsListPortrait:I

    iget v3, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->numColumnsListLandscape:I

    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->resourceProvider:Lcom/amazon/ansel/fetch/ResourceProvider;

    iget-object v5, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->asinImpressionTracker:Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;

    move-object v1, p0

    invoke-direct/range {v0 .. v5}, Lcom/amazon/retailsearch/android/ui/results/layout/ListLayout;-><init>(Landroid/view/ViewGroup;IILcom/amazon/ansel/fetch/ResourceProvider;Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;)V

    goto :goto_0

    .line 166
    :pswitch_1
    new-instance v0, Lcom/amazon/retailsearch/android/ui/results/layout/GridLayout;

    iget v2, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->numColumnsGridPortrait:I

    iget v3, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->numColumnsGridLandscape:I

    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->resourceProvider:Lcom/amazon/ansel/fetch/ResourceProvider;

    iget-object v5, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->asinImpressionTracker:Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;

    move-object v1, p0

    invoke-direct/range {v0 .. v5}, Lcom/amazon/retailsearch/android/ui/results/layout/GridLayout;-><init>(Landroid/view/ViewGroup;IILcom/amazon/ansel/fetch/ResourceProvider;Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;)V

    goto :goto_0

    .line 168
    :pswitch_2
    new-instance v0, Lcom/amazon/retailsearch/android/ui/results/layout/GalleryLayout;

    iget v2, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->numColumnsGalleryPortrait:I

    iget v3, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->numColumnsGalleryLandscape:I

    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->resourceProvider:Lcom/amazon/ansel/fetch/ResourceProvider;

    iget-object v5, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->asinImpressionTracker:Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;

    move-object v1, p0

    invoke-direct/range {v0 .. v5}, Lcom/amazon/retailsearch/android/ui/results/layout/GalleryLayout;-><init>(Landroid/view/ViewGroup;IILcom/amazon/ansel/fetch/ResourceProvider;Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;)V

    goto :goto_0

    .line 170
    :pswitch_3
    new-instance v0, Lcom/amazon/retailsearch/android/ui/results/layout/FlipBookLayout;

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->resourceProvider:Lcom/amazon/ansel/fetch/ResourceProvider;

    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->asinImpressionTracker:Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;

    invoke-direct {v0, p0, v1, v2}, Lcom/amazon/retailsearch/android/ui/results/layout/FlipBookLayout;-><init>(Landroid/view/ViewGroup;Lcom/amazon/ansel/fetch/ResourceProvider;Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;)V

    goto :goto_0

    .line 172
    :pswitch_4
    new-instance v0, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->resourceProvider:Lcom/amazon/ansel/fetch/ResourceProvider;

    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->asinImpressionTracker:Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;

    iget v3, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->entryIndex:I

    invoke-direct {v0, p0, v1, v2, v3}, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;-><init>(Landroid/view/ViewGroup;Lcom/amazon/ansel/fetch/ResourceProvider;Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;I)V

    goto :goto_0

    .line 162
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
    .end packed-switch
.end method

.method private getLayout(Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayoutType;)Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayout;
    .locals 4
    .param p1, "searchLayoutType"    # Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayoutType;

    .prologue
    .line 149
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->layouts:Ljava/util/Map;

    invoke-interface {v2, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayout;

    .line 150
    .local v1, "searchLayout":Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayout;
    iget v2, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->oldOrientation:I

    const/4 v3, 0x2

    if-ne v2, v3, :cond_1

    const/4 v0, 0x1

    .line 152
    .local v0, "landscape":Z
    :goto_0
    if-nez v1, :cond_0

    .line 153
    invoke-direct {p0, p1, v0}, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->createLayout(Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayoutType;Z)Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayout;

    move-result-object v1

    .line 154
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->layouts:Ljava/util/Map;

    invoke-interface {v2, p1, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 157
    :cond_0
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->userState:Lcom/amazon/retailsearch/android/ui/results/layout/UserState;

    iget v3, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->entryIndex:I

    invoke-virtual {v2, v3}, Lcom/amazon/retailsearch/android/ui/results/layout/UserState;->setEntryIndex(I)V

    .line 158
    return-object v1

    .line 150
    .end local v0    # "landscape":Z
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private init()V
    .locals 2

    .prologue
    .line 101
    invoke-static {p0}, Lcom/amazon/retailsearch/di/RetailSearchDaggerGraphController;->inject(Ljava/lang/Object;)V

    .line 102
    new-instance v0, Lcom/amazon/ansel/fetch/ResourceProvider;

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->parentResourceProvider:Lcom/amazon/ansel/fetch/ResourceProvider;

    invoke-direct {v0, v1}, Lcom/amazon/ansel/fetch/ResourceProvider;-><init>(Lcom/amazon/ansel/fetch/LoaderGroup;)V

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->resourceProvider:Lcom/amazon/ansel/fetch/ResourceProvider;

    .line 103
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->searchDataSource:Lcom/amazon/retailsearch/interaction/SearchDataSource;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/interaction/SearchDataSource;->clear()V

    .line 104
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->searchDataSource:Lcom/amazon/retailsearch/interaction/SearchDataSource;

    invoke-virtual {v0, p0}, Lcom/amazon/retailsearch/interaction/SearchDataSource;->addSearchChangeListener(Lcom/amazon/retailsearch/interaction/SearchChangeListener;)V

    .line 105
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->preferencesManager:Lcom/amazon/retailsearch/userpreferences/UserPreferenceManager;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/userpreferences/UserPreferenceManager;->clear()V

    .line 106
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->preferencesManager:Lcom/amazon/retailsearch/userpreferences/UserPreferenceManager;

    invoke-virtual {v0, p0}, Lcom/amazon/retailsearch/userpreferences/UserPreferenceManager;->addUserPreferenceChangeListener(Lcom/amazon/retailsearch/userpreferences/UserPreferenceChangeListener;)V

    .line 108
    invoke-direct {p0}, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->buildInfoBar()V

    .line 110
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->setOrientation(I)V

    .line 113
    :try_start_0
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v0

    iget v0, v0, Landroid/content/res/Configuration;->orientation:I

    iput v0, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->oldOrientation:I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 115
    :goto_0
    return-void

    .line 114
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method private openLayout(Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayoutType;)V
    .locals 2
    .param p1, "searchLayoutType"    # Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayoutType;

    .prologue
    .line 125
    if-eqz p1, :cond_0

    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->layoutType:Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayoutType;

    if-ne p1, v0, :cond_1

    .line 134
    :cond_0
    :goto_0
    return-void

    .line 130
    :cond_1
    invoke-direct {p0}, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->closeLayout()V

    .line 131
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->layoutType:Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayoutType;

    .line 132
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->getLayout(Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayoutType;)Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayout;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->layout:Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayout;

    .line 133
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->layout:Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayout;

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->userState:Lcom/amazon/retailsearch/android/ui/results/layout/UserState;

    invoke-interface {v0, v1}, Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayout;->enable(Lcom/amazon/retailsearch/android/ui/results/layout/UserState;)V

    goto :goto_0
.end method

.method private resetSearchState()V
    .locals 1

    .prologue
    .line 183
    new-instance v0, Lcom/amazon/retailsearch/android/ui/results/layout/UserState;

    invoke-direct {v0}, Lcom/amazon/retailsearch/android/ui/results/layout/UserState;-><init>()V

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->userState:Lcom/amazon/retailsearch/android/ui/results/layout/UserState;

    .line 184
    return-void
.end method


# virtual methods
.method public backPressed()Z
    .locals 2

    .prologue
    const/4 v0, 0x1

    .line 366
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->isInSplitView()Z

    move-result v1

    if-eqz v1, :cond_2

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->previousLayoutType:Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayoutType;

    if-eqz v1, :cond_2

    .line 368
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->detailInterface:Lcom/amazon/retailsearch/android/api/display/DetailDisplayInterface;

    if-eqz v1, :cond_1

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->detailInterface:Lcom/amazon/retailsearch/android/api/display/DetailDisplayInterface;

    invoke-interface {v1}, Lcom/amazon/retailsearch/android/api/display/DetailDisplayInterface;->canGoBack()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 370
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->detailInterface:Lcom/amazon/retailsearch/android/api/display/DetailDisplayInterface;

    invoke-interface {v1}, Lcom/amazon/retailsearch/android/api/display/DetailDisplayInterface;->goBack()V

    .line 383
    :cond_0
    :goto_0
    return v0

    .line 374
    :cond_1
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->closeSplitView()V

    .line 377
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->detailInterface:Lcom/amazon/retailsearch/android/api/display/DetailDisplayInterface;

    if-eqz v1, :cond_0

    .line 379
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->detailInterface:Lcom/amazon/retailsearch/android/api/display/DetailDisplayInterface;

    invoke-interface {v1}, Lcom/amazon/retailsearch/android/api/display/DetailDisplayInterface;->clearBackstack()V

    goto :goto_0

    .line 383
    :cond_2
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public closeSplitView()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    const/4 v2, -0x1

    .line 405
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->previousLayoutType:Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayoutType;

    invoke-direct {p0, v1}, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->openLayout(Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayoutType;)V

    .line 406
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->infoBar:Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;

    invoke-virtual {v1, v3}, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->setVisibility(I)V

    .line 407
    invoke-virtual {p0, v3}, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->setVisibility(I)V

    .line 408
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->detailInterface:Lcom/amazon/retailsearch/android/api/display/DetailDisplayInterface;

    invoke-interface {v1}, Lcom/amazon/retailsearch/android/api/display/DetailDisplayInterface;->clearBackstack()V

    .line 409
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    .line 410
    .local v0, "layoutParams":Landroid/view/ViewGroup$LayoutParams;
    iput v2, v0, Landroid/view/ViewGroup$LayoutParams;->width:I

    .line 411
    iput v2, v0, Landroid/view/ViewGroup$LayoutParams;->height:I

    .line 412
    return-void
.end method

.method public isInSplitView()Z
    .locals 2

    .prologue
    .line 420
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->layoutType:Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayoutType;

    sget-object v1, Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayoutType;->Split:Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayoutType;

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onConfigurationChanged(Landroid/content/res/Configuration;)V
    .locals 2
    .param p1, "newConfig"    # Landroid/content/res/Configuration;

    .prologue
    .line 297
    if-eqz p1, :cond_0

    iget v0, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->oldOrientation:I

    iget v1, p1, Landroid/content/res/Configuration;->orientation:I

    if-ne v0, v1, :cond_1

    .line 307
    :cond_0
    :goto_0
    return-void

    .line 301
    :cond_1
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->isInSplitView()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 303
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->layout:Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayout;

    invoke-interface {v0}, Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayout;->getUserState()Lcom/amazon/retailsearch/android/ui/results/layout/UserState;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->userState:Lcom/amazon/retailsearch/android/ui/results/layout/UserState;

    .line 305
    :cond_2
    iget v0, p1, Landroid/content/res/Configuration;->orientation:I

    invoke-direct {p0, v0}, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->adjustViewForOrientation(I)V

    .line 306
    iget v0, p1, Landroid/content/res/Configuration;->orientation:I

    iput v0, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->oldOrientation:I

    goto :goto_0
.end method

.method public onNewSearch(Lcom/amazon/retailsearch/data/SearchTask;)V
    .locals 2
    .param p1, "searchTask"    # Lcom/amazon/retailsearch/data/SearchTask;

    .prologue
    .line 189
    invoke-direct {p0}, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->closeLayout()V

    .line 190
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->hasViewType:Z

    .line 191
    invoke-direct {p0}, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->resetSearchState()V

    .line 192
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->asinImpressionTracker:Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;->recordImpressions()V

    .line 193
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->searchDataSource:Lcom/amazon/retailsearch/interaction/SearchDataSource;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/interaction/SearchDataSource;->getCurrentSearch()Lcom/amazon/retailsearch/data/SearchTask;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->taskListener:Lcom/amazon/retailsearch/android/ui/search/SearchResultView$TaskListener;

    invoke-interface {v0, v1}, Lcom/amazon/retailsearch/data/SearchTask;->addListener(Lcom/amazon/retailsearch/data/SearchTask$SearchTaskListener;)V

    .line 194
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->searchDataSource:Lcom/amazon/retailsearch/interaction/SearchDataSource;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/interaction/SearchDataSource;->getCurrentSearch()Lcom/amazon/retailsearch/data/SearchTask;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->asinImpressionTracker:Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;->getSearchTaskListener()Lcom/amazon/retailsearch/data/SearchTask$SearchTaskListener;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/amazon/retailsearch/data/SearchTask;->addListener(Lcom/amazon/retailsearch/data/SearchTask$SearchTaskListener;)V

    .line 195
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->searchDataSource:Lcom/amazon/retailsearch/interaction/SearchDataSource;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/interaction/SearchDataSource;->getCurrentSearch()Lcom/amazon/retailsearch/data/SearchTask;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->infoBar:Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->getSearchTaskListener()Lcom/amazon/retailsearch/data/SearchTask$SearchTaskListener;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/amazon/retailsearch/data/SearchTask;->addListener(Lcom/amazon/retailsearch/data/SearchTask$SearchTaskListener;)V

    .line 196
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->preferencesManager:Lcom/amazon/retailsearch/userpreferences/UserPreferenceManager;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/userpreferences/UserPreferenceManager;->getViewType()Lcom/amazon/retailsearch/android/ui/results/ViewType;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/results/ViewType;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayoutType;->valueOf(Ljava/lang/String;)Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayoutType;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->openLayout(Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayoutType;)V

    .line 197
    return-void
.end method

.method public onPause()V
    .locals 1

    .prologue
    .line 267
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->layout:Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayout;

    if-eqz v0, :cond_0

    .line 269
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->layout:Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayout;

    invoke-interface {v0}, Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayout;->pause()V

    .line 271
    :cond_0
    return-void
.end method

.method public onResume()V
    .locals 1

    .prologue
    .line 256
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->layout:Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayout;

    if-eqz v0, :cond_0

    .line 258
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->layout:Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayout;

    invoke-interface {v0}, Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayout;->resume()V

    .line 260
    :cond_0
    return-void
.end method

.method public onStart()V
    .locals 0

    .prologue
    .line 279
    return-void
.end method

.method public onStop()V
    .locals 0

    .prologue
    .line 288
    return-void
.end method

.method public onViewTypeUpdated(Lcom/amazon/retailsearch/android/ui/results/ViewType;)V
    .locals 1
    .param p1, "newViewType"    # Lcom/amazon/retailsearch/android/ui/results/ViewType;

    .prologue
    .line 206
    invoke-virtual {p1}, Lcom/amazon/retailsearch/android/ui/results/ViewType;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayoutType;->valueOf(Ljava/lang/String;)Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayoutType;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->openLayout(Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayoutType;)V

    .line 207
    return-void
.end method

.method public openSplitView(Ljava/lang/String;)V
    .locals 6
    .param p1, "asin"    # Ljava/lang/String;

    .prologue
    const/4 v3, 0x1

    const/4 v4, 0x0

    .line 388
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    invoke-virtual {v5}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v5

    iget v2, v5, Landroid/content/res/Configuration;->orientation:I

    .line 389
    .local v2, "orientation":I
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->isInSplitView()Z

    move-result v5

    if-nez v5, :cond_3

    move v0, v3

    .line 390
    .local v0, "isLayoutChanged":Z
    :goto_0
    iget v5, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->oldOrientation:I

    if-eq v2, v5, :cond_4

    move v1, v3

    .line 391
    .local v1, "isOrientationChanged":Z
    :goto_1
    if-eqz v0, :cond_0

    .line 392
    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->layout:Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayout;

    invoke-interface {v3, p1}, Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayout;->setEntryGroupAsin(Ljava/lang/String;)V

    .line 394
    :cond_0
    sget-object v3, Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayoutType;->Split:Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayoutType;

    invoke-direct {p0, v3}, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->openLayout(Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayoutType;)V

    .line 395
    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->infoBar:Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;

    const/16 v4, 0x8

    invoke-virtual {v3, v4}, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->setVisibility(I)V

    .line 396
    if-nez v0, :cond_1

    if-eqz v1, :cond_2

    .line 398
    :cond_1
    invoke-direct {p0, v2}, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->adjustViewForOrientation(I)V

    .line 400
    :cond_2
    iput v2, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->oldOrientation:I

    .line 401
    return-void

    .end local v0    # "isLayoutChanged":Z
    .end local v1    # "isOrientationChanged":Z
    :cond_3
    move v0, v4

    .line 389
    goto :goto_0

    .restart local v0    # "isLayoutChanged":Z
    :cond_4
    move v1, v4

    .line 390
    goto :goto_1
.end method

.method public setDetailDisplayInterface(Lcom/amazon/retailsearch/android/api/display/DetailDisplayInterface;)V
    .locals 0
    .param p1, "detailDisplayInterface"    # Lcom/amazon/retailsearch/android/api/display/DetailDisplayInterface;

    .prologue
    .line 97
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->detailInterface:Lcom/amazon/retailsearch/android/api/display/DetailDisplayInterface;

    .line 98
    return-void
.end method
