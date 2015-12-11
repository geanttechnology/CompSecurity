.class public final Lcom/amazon/retailsearch/di/RetailSearchInternalModule$$ModuleAdapter;
.super Ldagger/internal/ModuleAdapter;
.source "RetailSearchInternalModule$$ModuleAdapter.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/retailsearch/di/RetailSearchInternalModule$$ModuleAdapter$ProvideFeatureConfigurationProvidesAdapter;,
        Lcom/amazon/retailsearch/di/RetailSearchInternalModule$$ModuleAdapter$ProvideResourceProviderProvidesAdapter;,
        Lcom/amazon/retailsearch/di/RetailSearchInternalModule$$ModuleAdapter$ProvideLoaderContextProvidesAdapter;,
        Lcom/amazon/retailsearch/di/RetailSearchInternalModule$$ModuleAdapter$ProvidUserPreferenceManagerProvidesAdapter;,
        Lcom/amazon/retailsearch/di/RetailSearchInternalModule$$ModuleAdapter$ProvideRetailSearchAndroidPlatformProvidesAdapter;,
        Lcom/amazon/retailsearch/di/RetailSearchInternalModule$$ModuleAdapter$ProvideActionListenerProvidesAdapter;,
        Lcom/amazon/retailsearch/di/RetailSearchInternalModule$$ModuleAdapter$ProvideSearchDataSourceProvidesAdapter;,
        Lcom/amazon/retailsearch/di/RetailSearchInternalModule$$ModuleAdapter$ProvideContextProvidesAdapter;,
        Lcom/amazon/retailsearch/di/RetailSearchInternalModule$$ModuleAdapter$ProvideSearchMetricsListenerInvokerProvidesAdapter;,
        Lcom/amazon/retailsearch/di/RetailSearchInternalModule$$ModuleAdapter$ProvideRetailSearchDataProviderProvidesAdapter;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ldagger/internal/ModuleAdapter",
        "<",
        "Lcom/amazon/retailsearch/di/RetailSearchInternalModule;",
        ">;"
    }
.end annotation


# static fields
.field private static final INCLUDES:[Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "[",
            "Ljava/lang/Class",
            "<*>;"
        }
    .end annotation
.end field

.field private static final INJECTS:[Ljava/lang/String;

.field private static final STATIC_INJECTIONS:[Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "[",
            "Ljava/lang/Class",
            "<*>;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 17
    const/16 v0, 0x41

    new-array v0, v0, [Ljava/lang/String;

    const-string/jumbo v1, "members/com.amazon.retailsearch.android.api.init.RetailSearchInitializer"

    aput-object v1, v0, v3

    const/4 v1, 0x1

    const-string/jumbo v2, "members/com.amazon.retailsearch.metrics.RetailSearchDCMLogger"

    aput-object v2, v0, v1

    const/4 v1, 0x2

    const-string/jumbo v2, "members/com.amazon.retailsearch.android.ui.results.views.price.PriceList"

    aput-object v2, v0, v1

    const/4 v1, 0x3

    const-string/jumbo v2, "members/com.amazon.retailsearch.android.ui.results.views.price.PriceGrid"

    aput-object v2, v0, v1

    const/4 v1, 0x4

    const-string/jumbo v2, "members/com.amazon.retailsearch.android.ui.results.views.price.PriceGallery"

    aput-object v2, v0, v1

    const/4 v1, 0x5

    const-string/jumbo v2, "members/com.amazon.retailsearch.android.ui.results.views.price.PriceSplit"

    aput-object v2, v0, v1

    const/4 v1, 0x6

    const-string/jumbo v2, "members/com.amazon.retailsearch.android.fastBrowse.FastBrowseBaseView"

    aput-object v2, v0, v1

    const/4 v1, 0x7

    const-string/jumbo v2, "members/com.amazon.retailsearch.android.fastBrowse.SlideMenuClickListener"

    aput-object v2, v0, v1

    const/16 v1, 0x8

    const-string/jumbo v2, "members/com.amazon.retailsearch.data.search.RequestListener"

    aput-object v2, v0, v1

    const/16 v1, 0x9

    const-string/jumbo v2, "members/com.amazon.retailsearch.android.ui.refinements.RefinementsAdapter"

    aput-object v2, v0, v1

    const/16 v1, 0xa

    const-string/jumbo v2, "members/com.amazon.retailsearch.android.ui.results.views.BestSeller"

    aput-object v2, v0, v1

    const/16 v1, 0xb

    const-string/jumbo v2, "members/com.amazon.retailsearch.android.ui.results.views.twister.TwisterModel"

    aput-object v2, v0, v1

    const/16 v1, 0xc

    const-string/jumbo v2, "members/com.amazon.retailsearch.android.ui.results.ViewToggle"

    aput-object v2, v0, v1

    const/16 v1, 0xd

    const-string/jumbo v2, "members/com.amazon.retailsearch.android.ui.results.MultiViewToggle"

    aput-object v2, v0, v1

    const/16 v1, 0xe

    const-string/jumbo v2, "members/com.amazon.retailsearch.interaction.SearchUserInteractionListener"

    aput-object v2, v0, v1

    const/16 v1, 0xf

    const-string/jumbo v2, "members/com.amazon.retailsearch.interaction.SearchDataSource"

    aput-object v2, v0, v1

    const/16 v1, 0x10

    const-string/jumbo v2, "members/com.amazon.retailsearch.android.ui.results.layout.view.DidYouMeanView"

    aput-object v2, v0, v1

    const/16 v1, 0x11

    const-string/jumbo v2, "members/com.amazon.retailsearch.android.ui.results.layout.view.FkmrHeader"

    aput-object v2, v0, v1

    const/16 v1, 0x12

    const-string/jumbo v2, "members/com.amazon.retailsearch.android.ui.results.layout.view.RelatedSearchesView"

    aput-object v2, v0, v1

    const/16 v1, 0x13

    const-string/jumbo v2, "members/com.amazon.retailsearch.android.ui.StyledSpannableString"

    aput-object v2, v0, v1

    const/16 v1, 0x14

    const-string/jumbo v2, "members/com.amazon.retailsearch.api.RetailSearchPage"

    aput-object v2, v0, v1

    const/16 v1, 0x15

    const-string/jumbo v2, "members/com.amazon.retailsearch.android.ui.results.layout.ListLayout"

    aput-object v2, v0, v1

    const/16 v1, 0x16

    const-string/jumbo v2, "members/com.amazon.retailsearch.android.ui.results.layout.GridLayout"

    aput-object v2, v0, v1

    const/16 v1, 0x17

    const-string/jumbo v2, "members/com.amazon.retailsearch.android.ui.results.layout.GalleryLayout"

    aput-object v2, v0, v1

    const/16 v1, 0x18

    const-string/jumbo v2, "members/com.amazon.retailsearch.android.ui.results.layout.SplitLayout"

    aput-object v2, v0, v1

    const/16 v1, 0x19

    const-string/jumbo v2, "members/com.amazon.retailsearch.android.ui.search.SearchResultView"

    aput-object v2, v0, v1

    const/16 v1, 0x1a

    const-string/jumbo v2, "members/com.amazon.retailsearch.android.ui.entry.RetailSearchEditText"

    aput-object v2, v0, v1

    const/16 v1, 0x1b

    const-string/jumbo v2, "members/com.amazon.retailsearch.android.ui.entry.RetailSearchEditTextWatcher"

    aput-object v2, v0, v1

    const/16 v1, 0x1c

    const-string/jumbo v2, "members/com.amazon.retailsearch.android.ui.entry.RetailSearchEntryView"

    aput-object v2, v0, v1

    const/16 v1, 0x1d

    const-string/jumbo v2, "members/com.amazon.retailsearch.android.ui.results.views.image.ThumbSwitcher"

    aput-object v2, v0, v1

    const/16 v1, 0x1e

    const-string/jumbo v2, "members/com.amazon.retailsearch.client.UiInvocationHandler"

    aput-object v2, v0, v1

    const/16 v1, 0x1f

    const-string/jumbo v2, "members/com.amazon.retailsearch.data.SuggestionDataProvider"

    aput-object v2, v0, v1

    const/16 v1, 0x20

    const-string/jumbo v2, "members/com.amazon.retailsearch.android.ui.results.events.ProductGestureListener"

    aput-object v2, v0, v1

    const/16 v1, 0x21

    const-string/jumbo v2, "members/com.amazon.retailsearch.android.ui.results.views.twister.TwisterListView"

    aput-object v2, v0, v1

    const/16 v1, 0x22

    const-string/jumbo v2, "members/com.amazon.retailsearch.android.ui.results.views.messaging.NewerEditionAvailable"

    aput-object v2, v0, v1

    const/16 v1, 0x23

    const-string/jumbo v2, "members/com.amazon.retailsearch.android.ui.resultheader.ResultsInfoBar"

    aput-object v2, v0, v1

    const/16 v1, 0x24

    const-string/jumbo v2, "members/com.amazon.retailsearch.android.ui.resultheader.ResultsInfoBarContentListener"

    aput-object v2, v0, v1

    const/16 v1, 0x25

    const-string/jumbo v2, "members/com.amazon.retailsearch.android.ui.results.layout.view.CategoryCorrectedView"

    aput-object v2, v0, v1

    const/16 v1, 0x26

    const-string/jumbo v2, "members/com.amazon.retailsearch.android.ui.results.layout.view.NoResultsSetView"

    aput-object v2, v0, v1

    const/16 v1, 0x27

    const-string/jumbo v2, "members/com.amazon.retailsearch.android.ui.results.layout.view.ErrorView"

    aput-object v2, v0, v1

    const/16 v1, 0x28

    const-string/jumbo v2, "members/com.amazon.retailsearch.android.ui.results.layout.view.SpellCorrectedHeader"

    aput-object v2, v0, v1

    const/16 v1, 0x29

    const-string/jumbo v2, "members/com.amazon.retailsearch.android.ui.results.layout.view.WordSplitterView"

    aput-object v2, v0, v1

    const/16 v1, 0x2a

    const-string/jumbo v2, "members/com.amazon.retailsearch.data.assets.SRDSAssetsLoader"

    aput-object v2, v0, v1

    const/16 v1, 0x2b

    const-string/jumbo v2, "members/com.amazon.retailsearch.data.PersonalizedSuggestionLoader"

    aput-object v2, v0, v1

    const/16 v1, 0x2c

    const-string/jumbo v2, "members/com.amazon.retailsearch.userpreferences.UserPreferenceManager"

    aput-object v2, v0, v1

    const/16 v1, 0x2d

    const-string/jumbo v2, "members/com.amazon.retailsearch.android.ui.refinements.RefinementMenu"

    aput-object v2, v0, v1

    const/16 v1, 0x2e

    const-string/jumbo v2, "members/com.amazon.retailsearch.android.ui.results.views.price.ForcedPrime"

    aput-object v2, v0, v1

    const/16 v1, 0x2f

    const-string/jumbo v2, "members/com.amazon.retailsearch.log.SearchLog"

    aput-object v2, v0, v1

    const/16 v1, 0x30

    const-string/jumbo v2, "members/com.amazon.retailsearch.client.SearchCallInterceptor"

    aput-object v2, v0, v1

    const/16 v1, 0x31

    const-string/jumbo v2, "members/com.amazon.retailsearch.metrics.IssLogger"

    aput-object v2, v0, v1

    const/16 v1, 0x32

    const-string/jumbo v2, "members/com.amazon.retailsearch.android.ui.entry.RetailSearchSuggestionCursorAdapter"

    aput-object v2, v0, v1

    const/16 v1, 0x33

    const-string/jumbo v2, "members/com.amazon.retailsearch.metrics.SearchMetricEvent"

    aput-object v2, v0, v1

    const/16 v1, 0x34

    const-string/jumbo v2, "members/com.amazon.retailsearch.metrics.impressions.AsinImpressionTracker"

    aput-object v2, v0, v1

    const/16 v1, 0x35

    const-string/jumbo v2, "members/com.amazon.retailsearch.android.ui.input.RetailSearchQueryEntry$FilterListener"

    aput-object v2, v0, v1

    const/16 v1, 0x36

    const-string/jumbo v2, "members/com.amazon.retailsearch.android.ui.input.RetailSearchQueryEntry$SearchSuggestionsItemListener"

    aput-object v2, v0, v1

    const/16 v1, 0x37

    const-string/jumbo v2, "members/com.amazon.retailsearch.android.ui.entry.RetailSearchSuggestionAdapter"

    aput-object v2, v0, v1

    const/16 v1, 0x38

    const-string/jumbo v2, "members/com.amazon.retailsearch.android.ui.entry.RetailSearchSuggestionFilter"

    aput-object v2, v0, v1

    const/16 v1, 0x39

    const-string/jumbo v2, "members/com.amazon.retailsearch.data.RetailSearchDataProvider"

    aput-object v2, v0, v1

    const/16 v1, 0x3a

    const-string/jumbo v2, "members/com.amazon.retailsearch.android.ui.search.FragmentBasedResultsDisplay"

    aput-object v2, v0, v1

    const/16 v1, 0x3b

    const-string/jumbo v2, "members/com.amazon.retailsearch.android.ui.results.GridProduct"

    aput-object v2, v0, v1

    const/16 v1, 0x3c

    const-string/jumbo v2, "members/com.amazon.retailsearch.android.ui.results.ListProduct"

    aput-object v2, v0, v1

    const/16 v1, 0x3d

    const-string/jumbo v2, "members/com.amazon.retailsearch.android.ui.results.GalleryProduct"

    aput-object v2, v0, v1

    const/16 v1, 0x3e

    const-string/jumbo v2, "members/com.amazon.retailsearch.client.AndroidWebClientFactory"

    aput-object v2, v0, v1

    const/16 v1, 0x3f

    const-string/jumbo v2, "members/com.amazon.retailsearch.android.ui.entry.ActionViewBuilder"

    aput-object v2, v0, v1

    const/16 v1, 0x40

    const-string/jumbo v2, "members/com.amazon.retailsearch.android.ui.results.SplitProduct"

    aput-object v2, v0, v1

    sput-object v0, Lcom/amazon/retailsearch/di/RetailSearchInternalModule$$ModuleAdapter;->INJECTS:[Ljava/lang/String;

    .line 18
    new-array v0, v3, [Ljava/lang/Class;

    sput-object v0, Lcom/amazon/retailsearch/di/RetailSearchInternalModule$$ModuleAdapter;->STATIC_INJECTIONS:[Ljava/lang/Class;

    .line 19
    new-array v0, v3, [Ljava/lang/Class;

    sput-object v0, Lcom/amazon/retailsearch/di/RetailSearchInternalModule$$ModuleAdapter;->INCLUDES:[Ljava/lang/Class;

    return-void
.end method

.method public constructor <init>()V
    .locals 8

    .prologue
    const/4 v4, 0x0

    .line 22
    const-class v1, Lcom/amazon/retailsearch/di/RetailSearchInternalModule;

    sget-object v2, Lcom/amazon/retailsearch/di/RetailSearchInternalModule$$ModuleAdapter;->INJECTS:[Ljava/lang/String;

    sget-object v3, Lcom/amazon/retailsearch/di/RetailSearchInternalModule$$ModuleAdapter;->STATIC_INJECTIONS:[Ljava/lang/Class;

    sget-object v5, Lcom/amazon/retailsearch/di/RetailSearchInternalModule$$ModuleAdapter;->INCLUDES:[Ljava/lang/Class;

    const/4 v6, 0x1

    move-object v0, p0

    move v7, v4

    invoke-direct/range {v0 .. v7}, Ldagger/internal/ModuleAdapter;-><init>(Ljava/lang/Class;[Ljava/lang/String;[Ljava/lang/Class;Z[Ljava/lang/Class;ZZ)V

    .line 23
    return-void
.end method


# virtual methods
.method public getBindings(Ldagger/internal/BindingsGroup;Lcom/amazon/retailsearch/di/RetailSearchInternalModule;)V
    .locals 2
    .param p1, "bindings"    # Ldagger/internal/BindingsGroup;
    .param p2, "module"    # Lcom/amazon/retailsearch/di/RetailSearchInternalModule;

    .prologue
    .line 36
    const-string/jumbo v0, "com.amazon.retailsearch.data.IRetailSearchDataProvider"

    new-instance v1, Lcom/amazon/retailsearch/di/RetailSearchInternalModule$$ModuleAdapter$ProvideRetailSearchDataProviderProvidesAdapter;

    invoke-direct {v1, p2}, Lcom/amazon/retailsearch/di/RetailSearchInternalModule$$ModuleAdapter$ProvideRetailSearchDataProviderProvidesAdapter;-><init>(Lcom/amazon/retailsearch/di/RetailSearchInternalModule;)V

    invoke-virtual {p1, v0, v1}, Ldagger/internal/BindingsGroup;->contributeProvidesBinding(Ljava/lang/String;Ldagger/internal/ProvidesBinding;)Ldagger/internal/Binding;

    .line 37
    const-string/jumbo v0, "com.amazon.retailsearch.metrics.SearchMetricsListenerInvoker"

    new-instance v1, Lcom/amazon/retailsearch/di/RetailSearchInternalModule$$ModuleAdapter$ProvideSearchMetricsListenerInvokerProvidesAdapter;

    invoke-direct {v1, p2}, Lcom/amazon/retailsearch/di/RetailSearchInternalModule$$ModuleAdapter$ProvideSearchMetricsListenerInvokerProvidesAdapter;-><init>(Lcom/amazon/retailsearch/di/RetailSearchInternalModule;)V

    invoke-virtual {p1, v0, v1}, Ldagger/internal/BindingsGroup;->contributeProvidesBinding(Ljava/lang/String;Ldagger/internal/ProvidesBinding;)Ldagger/internal/Binding;

    .line 38
    const-string/jumbo v0, "android.content.Context"

    new-instance v1, Lcom/amazon/retailsearch/di/RetailSearchInternalModule$$ModuleAdapter$ProvideContextProvidesAdapter;

    invoke-direct {v1, p2}, Lcom/amazon/retailsearch/di/RetailSearchInternalModule$$ModuleAdapter$ProvideContextProvidesAdapter;-><init>(Lcom/amazon/retailsearch/di/RetailSearchInternalModule;)V

    invoke-virtual {p1, v0, v1}, Ldagger/internal/BindingsGroup;->contributeProvidesBinding(Ljava/lang/String;Ldagger/internal/ProvidesBinding;)Ldagger/internal/Binding;

    .line 39
    const-string/jumbo v0, "com.amazon.retailsearch.interaction.SearchDataSource"

    new-instance v1, Lcom/amazon/retailsearch/di/RetailSearchInternalModule$$ModuleAdapter$ProvideSearchDataSourceProvidesAdapter;

    invoke-direct {v1, p2}, Lcom/amazon/retailsearch/di/RetailSearchInternalModule$$ModuleAdapter$ProvideSearchDataSourceProvidesAdapter;-><init>(Lcom/amazon/retailsearch/di/RetailSearchInternalModule;)V

    invoke-virtual {p1, v0, v1}, Ldagger/internal/BindingsGroup;->contributeProvidesBinding(Ljava/lang/String;Ldagger/internal/ProvidesBinding;)Ldagger/internal/Binding;

    .line 40
    const-string/jumbo v0, "com.amazon.retailsearch.interaction.UserInteractionListener"

    new-instance v1, Lcom/amazon/retailsearch/di/RetailSearchInternalModule$$ModuleAdapter$ProvideActionListenerProvidesAdapter;

    invoke-direct {v1, p2}, Lcom/amazon/retailsearch/di/RetailSearchInternalModule$$ModuleAdapter$ProvideActionListenerProvidesAdapter;-><init>(Lcom/amazon/retailsearch/di/RetailSearchInternalModule;)V

    invoke-virtual {p1, v0, v1}, Ldagger/internal/BindingsGroup;->contributeProvidesBinding(Ljava/lang/String;Ldagger/internal/ProvidesBinding;)Ldagger/internal/Binding;

    .line 41
    const-string/jumbo v0, "com.amazon.retailsearch.j2me.client.util.RetailSearchAndroidPlatform"

    new-instance v1, Lcom/amazon/retailsearch/di/RetailSearchInternalModule$$ModuleAdapter$ProvideRetailSearchAndroidPlatformProvidesAdapter;

    invoke-direct {v1, p2}, Lcom/amazon/retailsearch/di/RetailSearchInternalModule$$ModuleAdapter$ProvideRetailSearchAndroidPlatformProvidesAdapter;-><init>(Lcom/amazon/retailsearch/di/RetailSearchInternalModule;)V

    invoke-virtual {p1, v0, v1}, Ldagger/internal/BindingsGroup;->contributeProvidesBinding(Ljava/lang/String;Ldagger/internal/ProvidesBinding;)Ldagger/internal/Binding;

    .line 42
    const-string/jumbo v0, "com.amazon.retailsearch.userpreferences.UserPreferenceManager"

    new-instance v1, Lcom/amazon/retailsearch/di/RetailSearchInternalModule$$ModuleAdapter$ProvidUserPreferenceManagerProvidesAdapter;

    invoke-direct {v1, p2}, Lcom/amazon/retailsearch/di/RetailSearchInternalModule$$ModuleAdapter$ProvidUserPreferenceManagerProvidesAdapter;-><init>(Lcom/amazon/retailsearch/di/RetailSearchInternalModule;)V

    invoke-virtual {p1, v0, v1}, Ldagger/internal/BindingsGroup;->contributeProvidesBinding(Ljava/lang/String;Ldagger/internal/ProvidesBinding;)Ldagger/internal/Binding;

    .line 43
    const-string/jumbo v0, "com.amazon.ansel.fetch.LoaderContext"

    new-instance v1, Lcom/amazon/retailsearch/di/RetailSearchInternalModule$$ModuleAdapter$ProvideLoaderContextProvidesAdapter;

    invoke-direct {v1, p2}, Lcom/amazon/retailsearch/di/RetailSearchInternalModule$$ModuleAdapter$ProvideLoaderContextProvidesAdapter;-><init>(Lcom/amazon/retailsearch/di/RetailSearchInternalModule;)V

    invoke-virtual {p1, v0, v1}, Ldagger/internal/BindingsGroup;->contributeProvidesBinding(Ljava/lang/String;Ldagger/internal/ProvidesBinding;)Ldagger/internal/Binding;

    .line 44
    const-string/jumbo v0, "com.amazon.ansel.fetch.ResourceProvider"

    new-instance v1, Lcom/amazon/retailsearch/di/RetailSearchInternalModule$$ModuleAdapter$ProvideResourceProviderProvidesAdapter;

    invoke-direct {v1, p2}, Lcom/amazon/retailsearch/di/RetailSearchInternalModule$$ModuleAdapter$ProvideResourceProviderProvidesAdapter;-><init>(Lcom/amazon/retailsearch/di/RetailSearchInternalModule;)V

    invoke-virtual {p1, v0, v1}, Ldagger/internal/BindingsGroup;->contributeProvidesBinding(Ljava/lang/String;Ldagger/internal/ProvidesBinding;)Ldagger/internal/Binding;

    .line 45
    const-string/jumbo v0, "com.amazon.retailsearch.android.api.experimentation.FeatureConfiguration"

    new-instance v1, Lcom/amazon/retailsearch/di/RetailSearchInternalModule$$ModuleAdapter$ProvideFeatureConfigurationProvidesAdapter;

    invoke-direct {v1, p2}, Lcom/amazon/retailsearch/di/RetailSearchInternalModule$$ModuleAdapter$ProvideFeatureConfigurationProvidesAdapter;-><init>(Lcom/amazon/retailsearch/di/RetailSearchInternalModule;)V

    invoke-virtual {p1, v0, v1}, Ldagger/internal/BindingsGroup;->contributeProvidesBinding(Ljava/lang/String;Ldagger/internal/ProvidesBinding;)Ldagger/internal/Binding;

    .line 46
    return-void
.end method

.method public bridge synthetic getBindings(Ldagger/internal/BindingsGroup;Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ldagger/internal/BindingsGroup;
    .param p2, "x1"    # Ljava/lang/Object;

    .prologue
    .line 16
    check-cast p2, Lcom/amazon/retailsearch/di/RetailSearchInternalModule;

    .end local p2    # "x1":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lcom/amazon/retailsearch/di/RetailSearchInternalModule$$ModuleAdapter;->getBindings(Ldagger/internal/BindingsGroup;Lcom/amazon/retailsearch/di/RetailSearchInternalModule;)V

    return-void
.end method

.method public newModule()Lcom/amazon/retailsearch/di/RetailSearchInternalModule;
    .locals 1

    .prologue
    .line 27
    new-instance v0, Lcom/amazon/retailsearch/di/RetailSearchInternalModule;

    invoke-direct {v0}, Lcom/amazon/retailsearch/di/RetailSearchInternalModule;-><init>()V

    return-object v0
.end method

.method public bridge synthetic newModule()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 16
    invoke-virtual {p0}, Lcom/amazon/retailsearch/di/RetailSearchInternalModule$$ModuleAdapter;->newModule()Lcom/amazon/retailsearch/di/RetailSearchInternalModule;

    move-result-object v0

    return-object v0
.end method
