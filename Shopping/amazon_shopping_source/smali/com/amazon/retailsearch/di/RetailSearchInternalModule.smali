.class public Lcom/amazon/retailsearch/di/RetailSearchInternalModule;
.super Ljava/lang/Object;
.source "RetailSearchInternalModule.java"


# annotations
.annotation runtime Ldagger/Module;
    injects = {
        Lcom/amazon/retailsearch/android/api/init/RetailSearchInitializer;,
        Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;,
        Lcom/amazon/retailsearch/android/ui/results/views/price/PriceList;,
        Lcom/amazon/retailsearch/android/ui/results/views/price/PriceGrid;,
        Lcom/amazon/retailsearch/android/ui/results/views/price/PriceGallery;,
        Lcom/amazon/retailsearch/android/ui/results/views/price/PriceSplit;,
        Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;,
        Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;,
        Lcom/amazon/retailsearch/data/search/RequestListener;,
        Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;,
        Lcom/amazon/retailsearch/android/ui/results/views/BestSeller;,
        Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel;,
        Lcom/amazon/retailsearch/android/ui/results/ViewToggle;,
        Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle;,
        Lcom/amazon/retailsearch/interaction/SearchUserInteractionListener;,
        Lcom/amazon/retailsearch/interaction/SearchDataSource;,
        Lcom/amazon/retailsearch/android/ui/results/layout/view/DidYouMeanView;,
        Lcom/amazon/retailsearch/android/ui/results/layout/view/FkmrHeader;,
        Lcom/amazon/retailsearch/android/ui/results/layout/view/RelatedSearchesView;,
        Lcom/amazon/retailsearch/android/ui/StyledSpannableString;,
        Lcom/amazon/retailsearch/api/RetailSearchPage;,
        Lcom/amazon/retailsearch/android/ui/results/layout/ListLayout;,
        Lcom/amazon/retailsearch/android/ui/results/layout/GridLayout;,
        Lcom/amazon/retailsearch/android/ui/results/layout/GalleryLayout;,
        Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;,
        Lcom/amazon/retailsearch/android/ui/search/SearchResultView;,
        Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;,
        Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;,
        Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;,
        Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcher;,
        Lcom/amazon/retailsearch/client/UiInvocationHandler;,
        Lcom/amazon/retailsearch/data/SuggestionDataProvider;,
        Lcom/amazon/retailsearch/android/ui/results/events/ProductGestureListener;,
        Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView;,
        Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailable;,
        Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;,
        Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBarContentListener;,
        Lcom/amazon/retailsearch/android/ui/results/layout/view/CategoryCorrectedView;,
        Lcom/amazon/retailsearch/android/ui/results/layout/view/NoResultsSetView;,
        Lcom/amazon/retailsearch/android/ui/results/layout/view/ErrorView;,
        Lcom/amazon/retailsearch/android/ui/results/layout/view/SpellCorrectedHeader;,
        Lcom/amazon/retailsearch/android/ui/results/layout/view/WordSplitterView;,
        Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;,
        Lcom/amazon/retailsearch/data/PersonalizedSuggestionLoader;,
        Lcom/amazon/retailsearch/userpreferences/UserPreferenceManager;,
        Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;,
        Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrime;,
        Lcom/amazon/retailsearch/log/SearchLog;,
        Lcom/amazon/retailsearch/client/SearchCallInterceptor;,
        Lcom/amazon/retailsearch/metrics/IssLogger;,
        Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionCursorAdapter;,
        Lcom/amazon/retailsearch/metrics/SearchMetricEvent;,
        Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;,
        Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$FilterListener;,
        Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$SearchSuggestionsItemListener;,
        Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionAdapter;,
        Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilter;,
        Lcom/amazon/retailsearch/data/RetailSearchDataProvider;,
        Lcom/amazon/retailsearch/android/ui/search/FragmentBasedResultsDisplay;,
        Lcom/amazon/retailsearch/android/ui/results/GridProduct;,
        Lcom/amazon/retailsearch/android/ui/results/ListProduct;,
        Lcom/amazon/retailsearch/android/ui/results/GalleryProduct;,
        Lcom/amazon/retailsearch/client/AndroidWebClientFactory;,
        Lcom/amazon/retailsearch/android/ui/entry/ActionViewBuilder;,
        Lcom/amazon/retailsearch/android/ui/results/SplitProduct;
    }
.end annotation


# instance fields
.field private context:Landroid/content/Context;

.field private featureConfiguration:Lcom/amazon/retailsearch/android/api/experimentation/FeatureConfiguration;

.field private weblabClient:Lcom/amazon/retailsearch/android/api/experimentation/WeblabClient;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 170
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 171
    iput-object v0, p0, Lcom/amazon/retailsearch/di/RetailSearchInternalModule;->context:Landroid/content/Context;

    .line 172
    iput-object v0, p0, Lcom/amazon/retailsearch/di/RetailSearchInternalModule;->featureConfiguration:Lcom/amazon/retailsearch/android/api/experimentation/FeatureConfiguration;

    .line 173
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Lcom/amazon/retailsearch/android/api/experimentation/FeatureConfiguration;Lcom/amazon/retailsearch/android/api/experimentation/WeblabClient;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "featureConfiguration"    # Lcom/amazon/retailsearch/android/api/experimentation/FeatureConfiguration;
    .param p3, "weblabClient"    # Lcom/amazon/retailsearch/android/api/experimentation/WeblabClient;

    .prologue
    .line 177
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 178
    iput-object p1, p0, Lcom/amazon/retailsearch/di/RetailSearchInternalModule;->context:Landroid/content/Context;

    .line 179
    iput-object p2, p0, Lcom/amazon/retailsearch/di/RetailSearchInternalModule;->featureConfiguration:Lcom/amazon/retailsearch/android/api/experimentation/FeatureConfiguration;

    .line 180
    iput-object p3, p0, Lcom/amazon/retailsearch/di/RetailSearchInternalModule;->weblabClient:Lcom/amazon/retailsearch/android/api/experimentation/WeblabClient;

    .line 181
    return-void
.end method


# virtual methods
.method providUserPreferenceManager(Landroid/content/Context;)Lcom/amazon/retailsearch/userpreferences/UserPreferenceManager;
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .annotation runtime Ldagger/Provides;
    .end annotation

    .annotation runtime Ljavax/inject/Singleton;
    .end annotation

    .prologue
    .line 228
    new-instance v0, Lcom/amazon/retailsearch/userpreferences/UserPreferenceManager;

    invoke-direct {v0, p1}, Lcom/amazon/retailsearch/userpreferences/UserPreferenceManager;-><init>(Landroid/content/Context;)V

    return-object v0
.end method

.method provideActionListener()Lcom/amazon/retailsearch/interaction/UserInteractionListener;
    .locals 1
    .annotation runtime Ldagger/Provides;
    .end annotation

    .annotation runtime Ljavax/inject/Singleton;
    .end annotation

    .prologue
    .line 214
    new-instance v0, Lcom/amazon/retailsearch/interaction/SearchUserInteractionListener;

    invoke-direct {v0}, Lcom/amazon/retailsearch/interaction/SearchUserInteractionListener;-><init>()V

    return-object v0
.end method

.method provideContext()Landroid/content/Context;
    .locals 1
    .annotation runtime Ldagger/Provides;
    .end annotation

    .prologue
    .line 200
    iget-object v0, p0, Lcom/amazon/retailsearch/di/RetailSearchInternalModule;->context:Landroid/content/Context;

    return-object v0
.end method

.method provideFeatureConfiguration()Lcom/amazon/retailsearch/android/api/experimentation/FeatureConfiguration;
    .locals 1
    .annotation runtime Ldagger/Provides;
    .end annotation

    .prologue
    .line 250
    iget-object v0, p0, Lcom/amazon/retailsearch/di/RetailSearchInternalModule;->featureConfiguration:Lcom/amazon/retailsearch/android/api/experimentation/FeatureConfiguration;

    return-object v0
.end method

.method provideLoaderContext(Landroid/content/Context;)Lcom/amazon/ansel/fetch/LoaderContext;
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .annotation runtime Ldagger/Provides;
    .end annotation

    .annotation runtime Ljavax/inject/Singleton;
    .end annotation

    .prologue
    .line 235
    new-instance v0, Lcom/amazon/ansel/fetch/LoaderContext$Builder;

    invoke-direct {v0, p1}, Lcom/amazon/ansel/fetch/LoaderContext$Builder;-><init>(Landroid/content/Context;)V

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/amazon/ansel/fetch/LoaderContext$Builder;->setUseWeakResourceListeners(Z)Lcom/amazon/ansel/fetch/LoaderContext$Builder;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/ansel/fetch/LoaderContext$Builder;->build()Lcom/amazon/ansel/fetch/LoaderContext;

    move-result-object v0

    return-object v0
.end method

.method provideResourceProvider(Lcom/amazon/ansel/fetch/LoaderContext;)Lcom/amazon/ansel/fetch/ResourceProvider;
    .locals 1
    .param p1, "loaderContext"    # Lcom/amazon/ansel/fetch/LoaderContext;
    .annotation runtime Ldagger/Provides;
    .end annotation

    .annotation runtime Ljavax/inject/Singleton;
    .end annotation

    .prologue
    .line 244
    new-instance v0, Lcom/amazon/ansel/fetch/ResourceProvider;

    invoke-direct {v0, p1}, Lcom/amazon/ansel/fetch/ResourceProvider;-><init>(Lcom/amazon/ansel/fetch/LoaderContext;)V

    return-object v0
.end method

.method provideRetailSearchAndroidPlatform(Landroid/content/Context;)Lcom/amazon/retailsearch/j2me/client/util/RetailSearchAndroidPlatform;
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .annotation runtime Ldagger/Provides;
    .end annotation

    .annotation runtime Ljavax/inject/Singleton;
    .end annotation

    .prologue
    .line 221
    new-instance v0, Lcom/amazon/retailsearch/j2me/client/util/RetailSearchAndroidPlatform;

    invoke-direct {v0, p1}, Lcom/amazon/retailsearch/j2me/client/util/RetailSearchAndroidPlatform;-><init>(Landroid/content/Context;)V

    return-object v0
.end method

.method provideRetailSearchDataProvider()Lcom/amazon/retailsearch/data/IRetailSearchDataProvider;
    .locals 1
    .annotation runtime Ldagger/Provides;
    .end annotation

    .annotation runtime Ljavax/inject/Singleton;
    .end annotation

    .prologue
    .line 187
    new-instance v0, Lcom/amazon/retailsearch/data/RetailSearchDataProvider;

    invoke-direct {v0}, Lcom/amazon/retailsearch/data/RetailSearchDataProvider;-><init>()V

    return-object v0
.end method

.method provideSearchDataSource()Lcom/amazon/retailsearch/interaction/SearchDataSource;
    .locals 1
    .annotation runtime Ldagger/Provides;
    .end annotation

    .annotation runtime Ljavax/inject/Singleton;
    .end annotation

    .prologue
    .line 207
    new-instance v0, Lcom/amazon/retailsearch/interaction/SearchDataSource;

    invoke-direct {v0}, Lcom/amazon/retailsearch/interaction/SearchDataSource;-><init>()V

    return-object v0
.end method

.method provideSearchMetricsListenerInvoker()Lcom/amazon/retailsearch/metrics/SearchMetricsListenerInvoker;
    .locals 1
    .annotation runtime Ldagger/Provides;
    .end annotation

    .annotation runtime Ljavax/inject/Singleton;
    .end annotation

    .prologue
    .line 194
    new-instance v0, Lcom/amazon/retailsearch/metrics/SearchMetricsListenerInvoker;

    invoke-direct {v0}, Lcom/amazon/retailsearch/metrics/SearchMetricsListenerInvoker;-><init>()V

    return-object v0
.end method
