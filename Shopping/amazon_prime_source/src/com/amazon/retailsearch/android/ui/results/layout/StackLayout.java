// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.layout;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.amazon.ansel.fetch.AbstractResourceListener;
import com.amazon.ansel.fetch.ImageLoader;
import com.amazon.ansel.fetch.ImageRequest;
import com.amazon.ansel.fetch.ResourceLoader;
import com.amazon.ansel.fetch.ResourceProvider;
import com.amazon.ansel.fetch.UriRequest;
import com.amazon.ansel.fetch.listview.PredictiveScrollListener;
import com.amazon.ansel.fetch.tools.collection.Factory;
import com.amazon.retailsearch.adaptive.PreloadImagesAdapter;
import com.amazon.retailsearch.adaptive.ProductAdapter;
import com.amazon.retailsearch.adaptive.framework.ModelAdapter;
import com.amazon.retailsearch.adaptive.latency.LatencyAdaptiveManager;
import com.amazon.retailsearch.android.ads.AdCache;
import com.amazon.retailsearch.android.ads.AdModel;
import com.amazon.retailsearch.android.ads.AdViewEntry;
import com.amazon.retailsearch.android.ads.AdWidgetView;
import com.amazon.retailsearch.android.api.experimentation.FeatureConfiguration;
import com.amazon.retailsearch.android.api.log.RetailSearchLogger;
import com.amazon.retailsearch.android.api.log.RetailSearchLoggingProvider;
import com.amazon.retailsearch.android.ui.ImageRequestFactory;
import com.amazon.retailsearch.android.ui.animations.AnimatableResultsImage;
import com.amazon.retailsearch.android.ui.listadapter.GeneratorAdapter;
import com.amazon.retailsearch.android.ui.listadapter.ModelViewEntry;
import com.amazon.retailsearch.android.ui.listadapter.ViewBuilderEntry;
import com.amazon.retailsearch.android.ui.listadapter.ViewEntry;
import com.amazon.retailsearch.android.ui.results.ContentSwitcher;
import com.amazon.retailsearch.android.ui.results.ContentSwitcherModel;
import com.amazon.retailsearch.android.ui.results.ProductViewModel;
import com.amazon.retailsearch.android.ui.results.ResultLayoutType;
import com.amazon.retailsearch.android.ui.results.layout.entry.ContentRowEntry;
import com.amazon.retailsearch.android.ui.results.layout.model.ContentRowModel;
import com.amazon.retailsearch.android.ui.results.layout.model.ImageSparkleModel;
import com.amazon.retailsearch.android.ui.results.layout.model.MixedCorrectionsModel;
import com.amazon.retailsearch.android.ui.results.layout.view.CategoryCorrectedFooter;
import com.amazon.retailsearch.android.ui.results.layout.view.CategoryCorrectedView;
import com.amazon.retailsearch.android.ui.results.layout.view.ErrorView;
import com.amazon.retailsearch.android.ui.results.layout.view.FkmrHeader;
import com.amazon.retailsearch.android.ui.results.layout.view.MixedCorrectionsView;
import com.amazon.retailsearch.android.ui.results.layout.view.NoResultsSetView;
import com.amazon.retailsearch.android.ui.results.layout.view.RelatedSearchesView;
import com.amazon.retailsearch.android.ui.results.layout.view.ResultsCountView;
import com.amazon.retailsearch.android.ui.results.layout.view.SpellCorrectedFooter;
import com.amazon.retailsearch.android.ui.results.layout.view.SpellCorrectedHeader;
import com.amazon.retailsearch.android.ui.results.layout.view.WordSplitterView;
import com.amazon.retailsearch.android.ui.results.layout.widget.SearchWidgetType;
import com.amazon.retailsearch.android.util.NetInfo;
import com.amazon.retailsearch.data.SearchTask;
import com.amazon.retailsearch.data.search.SearchLoaderLogger;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import com.amazon.retailsearch.experiment.FeatureStateUtil;
import com.amazon.retailsearch.interaction.SearchDataSource;
import com.amazon.retailsearch.interaction.UserInteractionListener;
import com.amazon.retailsearch.metrics.impressions.AsinImpressionTracker;
import com.amazon.retailsearch.metrics.impressions.ProductViewSnapshot;
import com.amazon.retailsearch.util.Utils;
import com.amazon.searchapp.retailsearch.client.MsaUtil;
import com.amazon.searchapp.retailsearch.entity.ProductEntity;
import com.amazon.searchapp.retailsearch.model.BrandStrip;
import com.amazon.searchapp.retailsearch.model.CategoryCorrected;
import com.amazon.searchapp.retailsearch.model.Decorations;
import com.amazon.searchapp.retailsearch.model.DidYouMean;
import com.amazon.searchapp.retailsearch.model.FKMR;
import com.amazon.searchapp.retailsearch.model.Hidden;
import com.amazon.searchapp.retailsearch.model.Image;
import com.amazon.searchapp.retailsearch.model.ImageSparkle;
import com.amazon.searchapp.retailsearch.model.InbandImage;
import com.amazon.searchapp.retailsearch.model.Link;
import com.amazon.searchapp.retailsearch.model.NoResultsSet;
import com.amazon.searchapp.retailsearch.model.PastPurchases;
import com.amazon.searchapp.retailsearch.model.PreloadImages;
import com.amazon.searchapp.retailsearch.model.Product;
import com.amazon.searchapp.retailsearch.model.ProductSection;
import com.amazon.searchapp.retailsearch.model.QuartzBacklink;
import com.amazon.searchapp.retailsearch.model.Refinements;
import com.amazon.searchapp.retailsearch.model.RelatedSearches;
import com.amazon.searchapp.retailsearch.model.ResultsMetadata;
import com.amazon.searchapp.retailsearch.model.SearchResult;
import com.amazon.searchapp.retailsearch.model.Sparkle;
import com.amazon.searchapp.retailsearch.model.SpellCorrected;
import com.amazon.searchapp.retailsearch.model.TextSparkle;
import com.amazon.searchapp.retailsearch.model.TrackingInfo;
import com.amazon.searchapp.retailsearch.model.Widget;
import dagger.Lazy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.layout:
//            SearchLayout, ResultsController, StackViewContainer, StackLayoutState, 
//            SingleLayoutElementModel, UserState, StackView, LayoutElement, 
//            ListBasedLayoutElementModel, ImmersiveProduct, VerticalStackView, LayoutElementModel, 
//            FilterRequestListener

public abstract class StackLayout
    implements SearchLayout
{
    private class AsinVisibilityReporter
        implements Runnable
    {

        private final long DEFAULT_REPORTER_INTERVAL_MS;
        private Handler handler;
        private long interval;
        private boolean monitoring;
        final StackLayout this$0;

        private void examineStackView()
        {
            if (results.size() != 0)
            {
                int k = stackView.getFirstVisiblePosition();
                int l = stackView.getLastVisiblePosition();
                int j = (l - k) + 1;
                int i = j;
                if (l >= results.size())
                {
                    i = j - 1;
                }
                j = 0;
                while (j < i) 
                {
                    Object obj = stackView.getChildAt(j);
                    if (obj != null)
                    {
                        ArrayList arraylist = new ArrayList(columns);
                        int i1 = k + j;
                        if (i1 >= 0 && i1 < results.size())
                        {
                            Iterator iterator = results.get(i1).getLayoutElementModel().getAllModels().iterator();
                            do
                            {
                                if (!iterator.hasNext())
                                {
                                    break;
                                }
                                Object obj1 = iterator.next();
                                if (obj1 instanceof ProductEntity)
                                {
                                    obj1 = (ProductEntity)obj1;
                                    String s = ((ProductEntity) (obj1)).getAsin();
                                    if (!asinImpressionTracker.wasAsinViewed(s))
                                    {
                                        arraylist.add(s);
                                        processDecorations(((ProductEntity) (obj1)).getDecorations());
                                    }
                                }
                            } while (true);
                            if (!Utils.isEmpty(arraylist))
                            {
                                int j1 = ((View) (obj)).getHeight();
                                int k1 = ((View) (obj)).getTop();
                                int l1 = ((View) (obj)).getBottom();
                                int i2 = stackView.getHeight();
                                float f = 0.0F;
                                long l2;
                                if (k1 >= 0 && l1 <= i2)
                                {
                                    f = 1.0F;
                                } else
                                if (k1 < 0)
                                {
                                    f = ((float)j1 - (float)Math.abs(k1)) / (float)j1;
                                } else
                                if (l1 > i2)
                                {
                                    f = ((float)i2 - (float)k1) / (float)j1;
                                }
                                l2 = System.currentTimeMillis();
                                obj = arraylist.iterator();
                                while (((Iterator) (obj)).hasNext()) 
                                {
                                    ProductViewSnapshot productviewsnapshot = new ProductViewSnapshot((String)((Iterator) (obj)).next(), f, l2);
                                    asinImpressionTracker.evaluateByIncrementalSnapshot(productviewsnapshot);
                                }
                            }
                        }
                    }
                    j++;
                }
            }
        }

        private void monitor()
        {
            handler.postDelayed(this, interval);
        }

        private void processDecorations(Decorations decorations)
        {
            if (decorations != null && !Utils.isEmpty(decorations.getTracking()))
            {
                decorations = decorations.getTracking().iterator();
                while (decorations.hasNext()) 
                {
                    Object obj = (Link)decorations.next();
                    if (obj != null && !TextUtils.isEmpty(((Link) (obj)).getUrl()))
                    {
                        obj = new ImageRequest(((Link) (obj)).getUrl());
                        resourceProvider.execute(new ImageLoader(resourceProvider.getContext(), new SponsoredProductResourceListener(), System.currentTimeMillis(), ((ImageRequest) (obj))));
                    }
                }
            }
        }

        public void run()
        {
            try
            {
                examineStackView();
            }
            catch (Exception exception)
            {
                retailSearchLogger.error("Asin Impression Logger caused an exception ", exception);
            }
            monitor();
        }

        void startMonitoring()
        {
            if (monitoring)
            {
                return;
            } else
            {
                monitor();
                monitoring = true;
                return;
            }
        }

        void stopMonitoring()
        {
            if (!monitoring)
            {
                return;
            } else
            {
                handler.removeCallbacks(this);
                monitoring = false;
                return;
            }
        }

        AsinVisibilityReporter()
        {
            this(0L);
        }

        AsinVisibilityReporter(long l)
        {
            this$0 = StackLayout.this;
            super();
            DEFAULT_REPORTER_INTERVAL_MS = 500L;
            handler = new Handler();
            interval = 0L;
            monitoring = false;
            long l1 = l;
            if (l <= 0L)
            {
                l1 = 500L;
            }
            interval = l1;
        }
    }

    private class AsinVisibilityReporter.SponsoredProductResourceListener extends AbstractResourceListener
    {

        final AsinVisibilityReporter this$1;

        public void result(Bitmap bitmap)
        {
        }

        public volatile void result(Object obj)
        {
            result((Bitmap)obj);
        }

        private AsinVisibilityReporter.SponsoredProductResourceListener()
        {
            this$1 = AsinVisibilityReporter.this;
            super();
        }

    }

    private class Listener extends com.amazon.retailsearch.data.SearchTask.SearchTaskListener
    {

        final StackLayout this$0;

        public void categoryCorrected(CategoryCorrected categorycorrected)
        {
            int i = 
// JavaClassFileOutputException: get_constant: invalid tag

        public void clearError()
        {
            StackLayout.this.clearError();
            update();
        }

        public void didYouMean(DidYouMean didyoumean)
        {
            mixedCorrectionsModel.setDidYouMean(didyoumean);
            addMixedCorrections(mixedCorrectionsModel);
            update();
        }

        public void endPage()
        {
            hideProgressBar();
            userInteractionListener.endPage(getProgressBar());
            if (enabled && loaderScrollListener != null)
            {
                loaderScrollListener.processView((AdapterView)stackView, true);
            }
        }

        public void endParse(SearchResult searchresult)
        {
            endParse(searchresult);
            if (searchDataSource.getSearchLoaderLogger() != null)
            {
                searchDataSource.getSearchLoaderLogger().endParse();
            }
        }

        public void endResult()
        {
            StackLayout.this.endResult();
            update();
            userInteractionListener.endResult();
        }

        public void error(Exception exception)
        {
            addError(exception);
            update();
        }

        public void fkmr(FKMR fkmr1)
        {
            int i = 
// JavaClassFileOutputException: get_constant: invalid tag

        public void noResultsSet(NoResultsSet noresultsset)
        {
            addNoResultsSet(noresultsset);
            update();
        }

        public void preloadImages(PreloadImages preloadimages)
        {
            StackLayout.this.preloadImages(preloadimages);
        }

        public void product(Product product1)
        {
            addProductWrapper(product1);
            showProducts(false);
            update();
        }

        public void quartzBackLink(QuartzBacklink quartzbacklink)
        {
            mixedCorrectionsModel.setQuartzBacklink(quartzbacklink);
            addMixedCorrections(mixedCorrectionsModel);
            update();
        }

        public void ready()
        {
            if (enabled && stackView.getView() != null)
            {
                loadAtBottom(stackView.getFirstVisiblePosition(), stackView.getLastVisiblePosition());
            }
        }

        public void refinements(Refinements refinements1)
        {
            StackLayout.this.refinements = refinements1;
            if (!deferredImageSparkleModels.isEmpty())
            {
                Iterator iterator = deferredImageSparkleModels.iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    ImageSparkleModel imagesparklemodel = (ImageSparkleModel)iterator.next();
                    boolean flag = imagesparklemodel.shouldDisplay();
                    imagesparklemodel.computeShouldDisplay(refinements1);
                    if (flag != imagesparklemodel.shouldDisplay())
                    {
                        modified = true;
                    }
                } while (true);
                deferredImageSparkleModels.clear();
                update();
            }
        }

        public void relatedSearches(RelatedSearches relatedsearches)
        {
            addRelatedSearches(relatedsearches);
            insertSingleAd();
            update();
        }

        public void resultMetadata(ResultsMetadata resultsmetadata)
        {
            if (!ResultsCountView.isValidMetaData(resultsmetadata) || !showInlineResultsCount || state == null || state.getResultsCount() != null)
            {
                return;
            } else
            {
                addResultsCount(resultsmetadata);
                update();
                return;
            }
        }

        public void spellCorrected(SpellCorrected spellcorrected)
        {
            int i = 
// JavaClassFileOutputException: get_constant: invalid tag

        public void startPage()
        {
            StackLayout.this.startPage();
            showProgressBar();
            update();
            userInteractionListener.startPage(getProgressBar(), state.getProductCount());
        }

        public void startResult()
        {
            StackLayout.this.refinements = null;
            mixCorrectionsLayoutElement = null;
            mixedCorrectionsModel = new MixedCorrectionsModel();
            deferredImageSparkleModels.clear();
            userInteractionListener.startResult();
        }

        public void trackingInfo(TrackingInfo trackinginfo)
        {
            if (trackinginfo == null)
            {
                return;
            } else
            {
                store = trackinginfo.getStore();
                return;
            }
        }

        public void widgets(List list)
        {
            addWidgets(list);
            update();
        }

        public void wordSplitter(SpellCorrected spellcorrected)
        {
            int i = 
// JavaClassFileOutputException: get_constant: invalid tag

        private Listener()
        {
            this$0 = StackLayout.this;
            super();
        }

    }

    protected class LoaderScrollListener extends PredictiveScrollListener
    {

        final StackLayout this$0;

        protected List getLoadersFor(int i)
        {
            return results.getLoadersFor(i);
        }

        private LoaderScrollListener(ResourceProvider resourceprovider)
        {
            this$0 = StackLayout.this;
            super(resourceprovider);
        }

    }

    static class MainElement
        implements Comparable
    {

        private final LayoutElementModel layoutElementModel;
        private final int position;
        private final int priority;
        private final ViewEntry viewEntry;

        public int compareTo(MainElement mainelement)
        {
            int i = position - mainelement.position;
            if (i != 0)
            {
                return i;
            } else
            {
                return mainelement.priority - priority;
            }
        }

        public volatile int compareTo(Object obj)
        {
            return compareTo((MainElement)obj);
        }

        LayoutElementModel getLayoutElementModel()
        {
            return layoutElementModel;
        }

        int getPosition()
        {
            return position;
        }

        int getPriority()
        {
            return priority;
        }

        ViewEntry getViewEntry()
        {
            return viewEntry;
        }

        MainElement(ViewEntry viewentry, int i, int j, LayoutElementModel layoutelementmodel)
        {
            viewEntry = viewentry;
            position = i;
            priority = j;
            layoutElementModel = layoutelementmodel;
        }
    }

    private static class MainPosition
    {

        private static final int MOBILE_AD = 11;
        private static final int RELATED_SEARCHES = 10;

        private MainPosition()
        {
        }
    }

    private class ScrollListener
        implements android.widget.AbsListView.OnScrollListener
    {

        final StackLayout this$0;

        public void onScroll(AbsListView abslistview, int i, int j, int k)
        {
            if (loaderScrollListener != null)
            {
                loaderScrollListener.onScroll(abslistview, i, j, k);
            }
        }

        public void onScrollStateChanged(AbsListView abslistview, int i)
        {
            if (abslistview != null)
            {
                loadAtBottom(abslistview.getFirstVisiblePosition(), abslistview.getLastVisiblePosition());
            }
            if (loaderScrollListener != null)
            {
                loaderScrollListener.onScrollStateChanged(abslistview, i);
            }
        }

        private ScrollListener()
        {
            this$0 = StackLayout.this;
            super();
        }

    }

    public static class SectionIndex
    {

        public static final int ERROR = 2;
        public static final int HEADER = 0;
        public static final int MAIN = 1;

        public SectionIndex()
        {
        }
    }


    public static final int SCROLL_TOP_OFFSET = 75;
    private AdCache adCache;
    private boolean adShouldInsert;
    private GeneratorAdapter adapter;
    private final AnimatableResultsImage animatableResultsImage;
    private int asinGroupCount;
    private final AsinImpressionTracker asinImpressionTracker;
    private AsinVisibilityReporter asinVisibilityReporter;
    private final Set atfAsins;
    private List atfImageListeners;
    private final int atfProductCount;
    private int columns;
    private final int columnsLandscape;
    private final int columnsPortrait;
    private final StackViewContainer container;
    private List deferredImageSparkleModels;
    private boolean enabled;
    FeatureConfiguration featureConfig;
    private FilterRequestListener filterRequestListener;
    protected final boolean isImmersiveViewSupported;
    private final boolean isSplitLayout;
    Lazy latencyAdaptiveManager;
    private final Listener listener;
    protected final LoaderScrollListener loaderScrollListener;
    private int minRowSize;
    private LayoutElement mixCorrectionsLayoutElement;
    private MixedCorrectionsModel mixedCorrectionsModel;
    private boolean modified;
    private int orientation;
    private ModelAdapter preloadImagesAdapter;
    private StackLayoutState prevState;
    private ModelAdapter productAdapter;
    private ImageRequestFactory productImageFactory;
    private int productImageRes;
    private LinearLayout progressBar;
    private Refinements refinements;
    private final ResourceProvider resourceProvider;
    protected ResultsController results;
    private RetailSearchLogger retailSearchLogger;
    private final ScrollListener scrollListener;
    SearchDataSource searchDataSource;
    private final boolean showInlineResultsCount;
    protected StackView stackView;
    private StackLayoutState state;
    private String store;
    UserInteractionListener userInteractionListener;

    private StackLayout(StackViewContainer stackviewcontainer, int i, int j, int k, ResourceProvider resourceprovider, AsinImpressionTracker asinimpressiontracker, Point point, 
            int l, boolean flag, boolean flag1)
    {
        results = new ResultsController();
        listener = new Listener();
        scrollListener = new ScrollListener();
        retailSearchLogger = RetailSearchLoggingProvider.getInstance().getRetailSearchLogger();
        adShouldInsert = true;
        atfAsins = new HashSet();
        atfImageListeners = new ArrayList();
        deferredImageSparkleModels = new ArrayList();
        preloadImagesAdapter = PreloadImagesAdapter.getInstance();
        productAdapter = ProductAdapter.getInstance();
        container = stackviewcontainer;
        columns = i;
        columnsPortrait = i;
        columnsLandscape = j;
        minRowSize = Math.min(i, k);
        resourceProvider = resourceprovider;
        asinImpressionTracker = asinimpressiontracker;
        if (point == null) goto _L2; else goto _L1
_L1:
        productImageRes = Math.max(point.x, point.y);
        asinimpressiontracker = FeatureStateUtil.getAdaptiveNetworkImageResolutionWeblab(featureConfig);
        if ("C".equals(asinimpressiontracker) || !NetInfo.isConnectedSlow(stackviewcontainer.getContext())) goto _L2; else goto _L3
_L3:
        if (!"T1".equals(asinimpressiontracker)) goto _L5; else goto _L4
_L4:
        productImageRes = (int)((double)productImageRes * 0.90000000000000002D);
_L2:
        atfProductCount = l;
        loaderScrollListener = new LoaderScrollListener(resourceprovider);
        productImageFactory = getProductImageFactory();
        asinVisibilityReporter = new AsinVisibilityReporter();
        RetailSearchDaggerGraphController.inject(this);
        asinGroupCount = 0;
        showInlineResultsCount = stackviewcontainer.getResources().getBoolean(com.amazon.retailsearch.R.bool.config_rs_show_inline_results_count);
        isSplitLayout = flag;
        isImmersiveViewSupported = flag1;
        animatableResultsImage = stackviewcontainer.getAnimatableResultsImage();
        adCache = new AdCache();
        return;
_L5:
        if ("T2".equals(asinimpressiontracker))
        {
            productImageRes = (int)((double)productImageRes * 0.80000000000000004D);
        } else
        if ("T3".equals(asinimpressiontracker))
        {
            productImageRes = (int)((double)productImageRes * 0.69999999999999996D);
        } else
        if ("T4".equals(asinimpressiontracker))
        {
            productImageRes = (int)((double)productImageRes * 0.59999999999999998D);
        } else
        if ("T5".equals(asinimpressiontracker))
        {
            productImageRes = (int)((double)productImageRes * 0.5D);
        }
        if (true) goto _L2; else goto _L6
_L6:
    }

    public StackLayout(StackViewContainer stackviewcontainer, int i, int j, ResourceProvider resourceprovider, AsinImpressionTracker asinimpressiontracker, ResultLayoutType resultlayouttype, int k, 
            boolean flag, boolean flag1)
    {
        StackLayout(stackviewcontainer, i, j, i, resourceprovider, asinimpressiontracker, resultlayouttype.getImageDimensions(stackviewcontainer.getContext()), stackviewcontainer.getResources().getInteger(k), flag, flag1);
    }

    public StackLayout(StackViewContainer stackviewcontainer, int i, ResourceProvider resourceprovider, AsinImpressionTracker asinimpressiontracker, ResultLayoutType resultlayouttype, int j, boolean flag, 
            boolean flag1)
    {
        StackLayout(stackviewcontainer, i, i, i, resourceprovider, asinimpressiontracker, resultlayouttype.getImageDimensions(stackviewcontainer.getContext()), stackviewcontainer.getResources().getInteger(j), flag, flag1);
    }

    private void addMobileAd(AdModel admodel)
    {
        if (admodel == null)
        {
            return;
        } else
        {
            addMainContent(new MainElement(createMobileAd(admodel), state.getStartingProductRowCount() + 11, 0, SingleLayoutElementModel.create(admodel)));
            return;
        }
    }

    private Object buildWidgetModel(Widget widget, SearchWidgetType searchwidgettype)
    {
        static class _cls5
        {

            static final int $SwitchMap$com$amazon$retailsearch$android$ui$results$layout$widget$SearchWidgetType[];

            static 
            {
                $SwitchMap$com$amazon$retailsearch$android$ui$results$layout$widget$SearchWidgetType = new int[SearchWidgetType.values().length];
                try
                {
                    $SwitchMap$com$amazon$retailsearch$android$ui$results$layout$widget$SearchWidgetType[SearchWidgetType.SPARKLE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$amazon$retailsearch$android$ui$results$layout$widget$SearchWidgetType[SearchWidgetType.PAST_PURCHASES.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$amazon$retailsearch$android$ui$results$layout$widget$SearchWidgetType[SearchWidgetType.IMAGE_SPARKLE.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$amazon$retailsearch$android$ui$results$layout$widget$SearchWidgetType[SearchWidgetType.BRAND_STRIP.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$retailsearch$android$ui$results$layout$widget$SearchWidgetType[SearchWidgetType.TEXT_SPARKLE.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls5..SwitchMap.com.amazon.retailsearch.android.ui.results.layout.widget.SearchWidgetType[searchwidgettype.ordinal()])
        {
        default:
            return null;

        case 1: // '\001'
            return createSparkleModel(widget);

        case 2: // '\002'
            return createPastPurchasesModel(widget);

        case 3: // '\003'
            return createImageSparkleModel(widget);

        case 4: // '\004'
            return createBrandStripModel(widget);

        case 5: // '\005'
            return createTextSparkleModel(widget);
        }
    }

    private boolean containsVisibleProducts(List list)
    {
        if (list != null)
        {
            list = list.iterator();
            while (list.hasNext()) 
            {
                if (!isHiddenProduct((Product)list.next()))
                {
                    return true;
                }
            }
        }
        return false;
    }

    private AdModel createAdModel()
    {
        if (isAdFeatureActivated())
        {
            return new AdModel(adCache);
        } else
        {
            return null;
        }
    }

    private Object createBrandStripModel(Widget widget)
    {
        try
        {
            widget = (BrandStrip)widget;
            widget = (new Builder(widget.getBrandCells(), resourceProvider)).setBrand(widget.getBrand()).setStoreName(widget.getStoreName()).setOriginalKeywords(widget.getOriginalKeywords()).build();
        }
        // Misplaced declaration of an exception variable
        catch (Widget widget)
        {
            retailSearchLogger.error("Error building BrandStripModel", widget);
            return null;
        }
        return widget;
    }

    protected static ModelViewEntry createContentView(int i, Class class1, Object obj)
    {
        if (i == 22)
        {
            return AdViewEntry.create((AdModel)obj);
        } else
        {
            return ModelViewEntry.create(i, class1, obj);
        }
    }

    private Object createImageSparkleModel(Widget widget)
    {
        if ("T1".equals(FeatureStateUtil.getImageSparkleWeblab(featureConfig)))
        {
            widget = (new Builder((ImageSparkle)widget, resourceProvider)).setFilterRequestListener(filterRequestListener).setRefinements(refinements).build();
            if (!widget.shouldDisplay())
            {
                deferredImageSparkleModels.add(widget);
            }
            return widget;
        } else
        {
            return null;
        }
    }

    private ViewBuilderEntry createMobileAd(AdModel admodel)
    {
        return createContentView(22, com/amazon/retailsearch/android/ads/AdWidgetView, admodel);
    }

    private Object createPastPurchasesModel(Widget widget)
    {
        if (!"T1".equals(FeatureStateUtil.getPastPurchaseWidgetWeblab(featureConfig)))
        {
            break MISSING_BLOCK_LABEL_72;
        }
        widget = (PastPurchases)widget;
        widget = (new Builder(widget, resourceProvider, productImageRes)).setSeeAllLinks(widget.getSeeAllLinks()).setStore(store).build();
        return widget;
        widget;
        retailSearchLogger.error("Error building PastPurchaseViewModel", widget);
        return null;
    }

    private Object createSparkleModel(Widget widget)
    {
        String s = FeatureStateUtil.getSparkleWeblab(featureConfig);
        if (!"C".equals(s) && (widget instanceof Sparkle))
        {
            return (new Builder((Sparkle)widget)).setResourceProvider(resourceProvider).setHasMargin("T2".equals(s)).build();
        } else
        {
            return null;
        }
    }

    private Object createTextSparkleModel(Widget widget)
    {
        if ("T1".equals(FeatureStateUtil.getTextSparkleWeblab(featureConfig)))
        {
            return (new Builder((TextSparkle)widget)).build();
        } else
        {
            return null;
        }
    }

    private void insertSingleAd()
    {
        if (!adShouldInsert)
        {
            return;
        } else
        {
            addMobileAd(createAdModel());
            adShouldInsert = false;
            return;
        }
    }

    private boolean isAdFeatureActivated()
    {
        if (container != null && container.getContext() != null)
        {
            String s;
            if ((container.getContext().getResources().getConfiguration().screenLayout & 0xf) >= 3)
            {
                if ("Amazon".equals(Build.MANUFACTURER))
                {
                    s = "SX_mShop_Fire_Tablet_Mobile_Ads";
                } else
                {
                    s = "SX_mShop_Android_Tablet_Mobile_Ads";
                }
            } else
            {
                s = "SX_mShop_Android_Phone_Mobile_Ads";
            }
            return featureConfig.isFeatureActivated(s);
        } else
        {
            return false;
        }
    }

    private boolean isHiddenProduct(Product product)
    {
        return product != null && product.getHidden() != null && !TextUtils.isEmpty(product.getHidden().getType());
    }

    private UserState saveUserState()
    {
        UserState userstate = new UserState();
        if (!results.isEmpty()) goto _L2; else goto _L1
_L1:
        return userstate;
_L2:
        final String asin = state.getEntryAsin();
        if (!TextUtils.isEmpty(asin))
        {
            userstate.setSelectedModel(results.getModel(new ResultsController.ModelMatcher() {

                final StackLayout this$0;
                final String val$asin;

                public boolean match(Object obj)
                {
                    return (obj instanceof Product) && asin.equals(((Product)obj).getAsin());
                }

            
            {
                this$0 = StackLayout.this;
                asin = s;
                super();
            }
            }, stackView.getFirstVisiblePosition(), stackView.getLastVisiblePosition()));
        }
        if (userstate.getSelectedModel() != null)
        {
            break; /* Loop/switch isn't completed */
        }
        asin = stackView.getChildAt(0);
        if (asin == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        int i = getFirstVisibleItemPosition(asin);
        userstate.setCurrentDataInFocus(results.get(i).getLayoutElementModel());
        break; /* Loop/switch isn't completed */
        if (true) goto _L1; else goto _L3
_L3:
        userstate.setEntryIndex(state.getEntryGroupIndex());
        return userstate;
    }

    protected void add(ViewEntry viewentry, LayoutElementModel layoutelementmodel)
    {
        add(createLayoutElement(viewentry, layoutelementmodel));
    }

    protected void add(LayoutElement layoutelement)
    {
        add(layoutelement, true);
    }

    protected void add(LayoutElement layoutelement, boolean flag)
    {
        if (layoutelement.getPosition() > state.getNextPosition() && !flag)
        {
            state.getPendingContent().add(layoutelement);
            Collections.sort(state.getPendingContent());
            return;
        } else
        {
            insert(layoutelement);
            showPendingContent(false);
            return;
        }
    }

    protected void addAsinGroupIndex(List list, int i)
    {
        if (list != null && !list.isEmpty())
        {
            list = list.iterator();
            while (list.hasNext()) 
            {
                Product product = (Product)list.next();
                state.getAsinGroupMap().put(product.getAsin(), Integer.valueOf(i));
            }
        }
    }

    protected void addCategoryCorrected(CategoryCorrected categorycorrected)
    {
        if (categorycorrected == null || categorycorrected.getResults() == null || !containsVisibleProducts(categorycorrected.getResults().getItems()))
        {
            return;
        } else
        {
            flushProducts();
            add(createCategoryCorrectedHeader(categorycorrected), SingleLayoutElementModel.create(categorycorrected));
            addProducts(categorycorrected.getResults().getItems());
            add(createCategoryCorrectedFooter(categorycorrected), SingleLayoutElementModel.create(categorycorrected));
            flushProducts();
            return;
        }
    }

    protected void addCategoryCorrected(CategoryCorrected categorycorrected, int i)
    {
        addCategoryCorrected(categorycorrected);
        if (categorycorrected != null && categorycorrected.getResults() != null)
        {
            addAsinGroupIndex(categorycorrected.getResults().getItems(), i);
        }
    }

    protected void addError(Exception exception)
    {
        add(createLayoutElement(createErrorView(exception), 2, 0, SingleLayoutElementModel.create(exception)));
    }

    protected void addFkmr(FKMR fkmr)
    {
        if (fkmr == null || fkmr.getResults() == null || !containsVisibleProducts(fkmr.getResults().getItems()))
        {
            return;
        } else
        {
            flushProducts();
            add(createFkmrHeader(fkmr), SingleLayoutElementModel.create(fkmr));
            addProducts(fkmr.getResults().getItems());
            flushProducts();
            return;
        }
    }

    protected void addFkmr(FKMR fkmr, int i)
    {
        addFkmr(fkmr);
        if (fkmr != null && fkmr.getResults() != null)
        {
            addAsinGroupIndex(fkmr.getResults().getItems(), i);
        }
    }

    protected void addMainContent(MainElement mainelement)
    {
        state.getMainContent().add(mainelement);
        Collections.sort(state.getMainContent());
        showMainContent(false);
    }

    protected void addMixedCorrections(MixedCorrectionsModel mixedcorrectionsmodel)
    {
        while (mixedcorrectionsmodel == null || mixedcorrectionsmodel.isEmpty() || mixCorrectionsLayoutElement != null) 
        {
            return;
        }
        mixCorrectionsLayoutElement = createLayoutElement(createMixedCorrections(mixedcorrectionsmodel), 0, state.getStartingPosition(), SingleLayoutElementModel.create(mixedcorrectionsmodel));
        add(mixCorrectionsLayoutElement);
    }

    protected void addNoResultsSet(NoResultsSet noresultsset)
    {
        if (noresultsset == null)
        {
            return;
        } else
        {
            flushProducts();
            add(createNoResultsSet(noresultsset), SingleLayoutElementModel.create(noresultsset));
            addProducts(noresultsset.getFallbackResults());
            flushProducts();
            return;
        }
    }

    protected boolean addProduct(Product product)
    {
label0:
        {
            if (product == null || isHiddenProduct(product))
            {
                return false;
            }
            if (searchDataSource.getSearchLoaderLogger() != null)
            {
                searchDataSource.getSearchLoaderLogger().addNumOfProducts(1);
            }
            if ("T1".equals(FeatureStateUtil.getAdaptiveSearchWeblab(featureConfig)))
            {
                ((LatencyAdaptiveManager)latencyAdaptiveManager.get()).adaptModel(product, productAdapter);
            }
            state.setProductCount(state.getProductCount() + 1);
            state.getProducts().add(product);
            if (state.getProductCount() > atfProductCount)
            {
                return true;
            }
            if (adShouldInsert && state.getProductCount() == atfProductCount && stackView != null && (stackView instanceof ListView) && isAdFeatureActivated())
            {
                atfAsins.add(product.getAsin());
                adCache.prepareCache((ListView)stackView, atfAsins);
            }
            if (!"T1".equals(FeatureStateUtil.getInbandImageWeblab(featureConfig)) || product.getInbandImages() == null || product.getInbandImages().isEmpty() || product.getImage() == null || product.getImage().getUrl() == null)
            {
                break label0;
            }
            ImageRequest imagerequest = productImageFactory.fromUrl(product.getImage().getUrl());
            if (imagerequest == null || imagerequest.getUriRequest() == null || imagerequest.getUriRequest().getUri() == null)
            {
                break label0;
            }
            Iterator iterator = product.getInbandImages().iterator();
            InbandImage inbandimage;
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
                inbandimage = (InbandImage)iterator.next();
            } while (inbandimage == null || !imagerequest.getUriRequest().getUri().equals(inbandimage.getUrl()));
            incrementAtfImageCount();
            return true;
        }
        loadAtfImage(product.getImage());
        atfAsins.add(product.getAsin());
        return true;
    }

    public void addProductAfter(LayoutElement layoutelement, Product product, String s)
    {
        ContentRowModel contentrowmodel = new ContentRowModel(new ArrayList(columns), columns, 0);
        LayoutElement layoutelement1 = createLayoutElement(createRow(contentrowmodel), 1, layoutelement.getRequestedPosition(), ListBasedLayoutElementModel.create(new ArrayList(columns)));
        ProductViewModel productviewmodel = createProductViewModel(product, layoutelement1, false, s);
        if (isImmersiveViewSupported)
        {
            if (animatableResultsImage != null)
            {
                animatableResultsImage.setTargetModel(productviewmodel);
            }
            s = createContentView(15, com/amazon/retailsearch/android/ui/results/ContentSwitcher, new ContentSwitcherModel(5, com/amazon/retailsearch/android/ui/results/layout/ImmersiveProduct, productviewmodel));
        } else
        {
            s = createProductCell(product, productviewmodel);
        }
        contentrowmodel.getContent().add(s);
        ((ListBasedLayoutElementModel)layoutelement1.getLayoutElementModel()).getAllModels().add(productviewmodel);
        product = getProductLoaders(product);
        if (product != null)
        {
            for (product = product.iterator(); product.hasNext(); layoutelement1.addLoader((Factory)product.next())) { }
        }
        results.addAfter(layoutelement, layoutelement1, state);
        modified = true;
        update();
        scrollToResultsModel(productviewmodel, 500);
    }

    protected void addProductWrapper(Product product)
    {
        addProduct(product);
    }

    protected void addProducts(List list)
    {
        if (list == null || list.isEmpty())
        {
            return;
        }
        for (list = list.iterator(); list.hasNext(); addProduct((Product)list.next())) { }
        showProducts(false);
    }

    protected void addRelatedSearches(RelatedSearches relatedsearches)
    {
        while (relatedsearches == null || state.getRelatedSearchesExists() && !relatedsearches.getSecondaryResult()) 
        {
            return;
        }
        addMainContent(new MainElement(createRelatedSearches(relatedsearches), state.getStartingProductRowCount() + 10, 0, SingleLayoutElementModel.create(relatedsearches)));
        state.setRelatedSearchesExists(true);
    }

    protected void addResultsCount(ResultsMetadata resultsmetadata)
    {
        ModelViewEntry modelviewentry = createResultsCountView(resultsmetadata);
        add(createLayoutElement(modelviewentry, 0, 0, SingleLayoutElementModel.create(resultsmetadata)));
        state.setResultsCount(modelviewentry);
    }

    protected void addSpellCorrected(SpellCorrected spellcorrected)
    {
        if (spellcorrected == null || spellcorrected.getResults() == null || !containsVisibleProducts(spellcorrected.getResults().getItems()))
        {
            return;
        } else
        {
            flushProducts();
            add(createSpellCorrectionHeader(spellcorrected), SingleLayoutElementModel.create(spellcorrected));
            addProducts(spellcorrected.getResults().getItems());
            add(createSpellCorrectionFooter(spellcorrected), SingleLayoutElementModel.create(spellcorrected));
            flushProducts();
            return;
        }
    }

    protected void addSpellCorrected(SpellCorrected spellcorrected, int i)
    {
        addSpellCorrected(spellcorrected);
        if (spellcorrected != null && spellcorrected.getResults() != null)
        {
            addAsinGroupIndex(spellcorrected.getResults().getItems(), i);
        }
    }

    protected void addWidgets(List list)
    {
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            Object obj = (Widget)list.next();
            SearchWidgetType searchwidgettype = SearchWidgetType.valueOf(((Widget) (obj)));
            obj = buildWidgetModel(((Widget) (obj)), searchwidgettype);
            if (obj != null)
            {
                add(createLayoutElement(createContentView(searchwidgettype.getViewType(), searchwidgettype.getViewClass(), obj), searchwidgettype.getSection(), searchwidgettype.getPosition(), SingleLayoutElementModel.create(obj)));
            }
        } while (true);
    }

    protected void addWordSplitter(SpellCorrected spellcorrected)
    {
        if (spellcorrected == null || spellcorrected.getResults() == null || !containsVisibleProducts(spellcorrected.getResults().getItems()))
        {
            return;
        } else
        {
            flushProducts();
            add(createWordSplitterHeader(spellcorrected), SingleLayoutElementModel.create(spellcorrected));
            addProducts(spellcorrected.getResults().getItems());
            flushProducts();
            return;
        }
    }

    protected void addWordSplitter(SpellCorrected spellcorrected, int i)
    {
        addWordSplitter(spellcorrected);
        if (spellcorrected != null && spellcorrected.getResults() != null)
        {
            addAsinGroupIndex(spellcorrected.getResults().getItems(), i);
        }
    }

    public void changeOrientation(int i, UserState userstate)
    {
        asinGroupCount = 0;
        orientation = i;
        if (state != null && userstate != null)
        {
            state.setEntryGroupIndex(userstate.getEntryIndex());
            if (columnsPortrait != columnsLandscape)
            {
                enable(saveUserState());
                return;
            }
        }
    }

    protected void clearError()
    {
        results.clear(state.getStartingSize(), results.size());
        modified = true;
        state = new StackLayoutState(prevState);
    }

    protected ViewBuilderEntry createCategoryCorrectedFooter(CategoryCorrected categorycorrected)
    {
        return createContentView(24, com/amazon/retailsearch/android/ui/results/layout/view/CategoryCorrectedFooter, categorycorrected);
    }

    protected ViewBuilderEntry createCategoryCorrectedHeader(CategoryCorrected categorycorrected)
    {
        return createContentView(9, com/amazon/retailsearch/android/ui/results/layout/view/CategoryCorrectedView, categorycorrected);
    }

    protected ViewBuilderEntry createErrorView(Exception exception)
    {
        return createContentView(0, com/amazon/retailsearch/android/ui/results/layout/view/ErrorView, exception);
    }

    protected ViewBuilderEntry createFkmrHeader(FKMR fkmr)
    {
        return createContentView(6, com/amazon/retailsearch/android/ui/results/layout/view/FkmrHeader, fkmr);
    }

    protected LayoutElement createLayoutElement(ViewEntry viewentry, int i, int j, LayoutElementModel layoutelementmodel)
    {
        return new LayoutElement(viewentry, i, j, layoutelementmodel, isSplitLayout);
    }

    protected LayoutElement createLayoutElement(ViewEntry viewentry, LayoutElementModel layoutelementmodel)
    {
        return createLayoutElement(viewentry, 1, state.getNextPosition(), layoutelementmodel);
    }

    protected ViewBuilderEntry createMixedCorrections(MixedCorrectionsModel mixedcorrectionsmodel)
    {
        return createContentView(10, com/amazon/retailsearch/android/ui/results/layout/view/MixedCorrectionsView, mixedcorrectionsmodel);
    }

    protected ViewBuilderEntry createNoResultsSet(NoResultsSet noresultsset)
    {
        return createContentView(12, com/amazon/retailsearch/android/ui/results/layout/view/NoResultsSetView, noresultsset);
    }

    protected abstract ViewBuilderEntry createProductCell(Product product, ProductViewModel productviewmodel);

    protected ImageRequestFactory createProductImageFactory()
    {
        return new ImageRequestFactory() {

            final StackLayout this$0;

            public ImageRequest fromUrl(String s)
            {
                if (TextUtils.isEmpty(s))
                {
                    return null;
                } else
                {
                    return new ImageRequest(new UriRequest(MsaUtil.setImageRes(s, productImageRes)), 160);
                }
            }

            
            {
                this$0 = StackLayout.this;
                super();
            }
        };
    }

    protected ProductViewModel createProductViewModel(Product product, LayoutElement layoutelement, boolean flag, String s)
    {
        product = new ProductViewModel(product, getProductImageFactory(), resourceProvider, isImmersiveViewSupported, layoutelement, this, animatableResultsImage, flag, store);
        product.updateActiveOffer(s);
        return product;
    }

    protected ViewBuilderEntry createRelatedSearches(RelatedSearches relatedsearches)
    {
        return createContentView(11, com/amazon/retailsearch/android/ui/results/layout/view/RelatedSearchesView, relatedsearches);
    }

    protected ModelViewEntry createResultsCountView(ResultsMetadata resultsmetadata)
    {
        return createContentView(13, com/amazon/retailsearch/android/ui/results/layout/view/ResultsCountView, resultsmetadata);
    }

    protected ContentRowEntry createRow(ContentRowModel contentrowmodel)
    {
        return new ContentRowEntry(1, contentrowmodel);
    }

    protected ViewBuilderEntry createSpellCorrectionFooter(SpellCorrected spellcorrected)
    {
        return createContentView(23, com/amazon/retailsearch/android/ui/results/layout/view/SpellCorrectedFooter, spellcorrected);
    }

    protected ViewBuilderEntry createSpellCorrectionHeader(SpellCorrected spellcorrected)
    {
        return createContentView(7, com/amazon/retailsearch/android/ui/results/layout/view/SpellCorrectedHeader, spellcorrected);
    }

    protected StackView createStackView()
    {
        VerticalStackView verticalstackview = (VerticalStackView)LayoutInflater.from(container.getContext()).inflate(com.amazon.retailsearch.R.layout.rs_vertical_stack_view, container, false);
        container.attachStackView(verticalstackview);
        verticalstackview.setOnScrollListener(scrollListener);
        progressBar = (LinearLayout)LayoutInflater.from(container.getContext()).inflate(com.amazon.retailsearch.R.layout.rs_search_spinner, null);
        verticalstackview.addFooterView(progressBar, null, false);
        setStackView(verticalstackview);
        return verticalstackview;
    }

    protected ViewBuilderEntry createWordSplitterHeader(SpellCorrected spellcorrected)
    {
        return createContentView(8, com/amazon/retailsearch/android/ui/results/layout/view/WordSplitterView, spellcorrected);
    }

    protected void detachViews()
    {
        if (stackView != null)
        {
            container.detachStackView(stackView);
            stackView.setAdapter(null);
        }
    }

    public UserState disable()
    {
        asinGroupCount = 0;
        asinVisibilityReporter.stopMonitoring();
        UserState userstate = saveUserState();
        userstate.setEntryIndex(getEntryGroupIndex());
        reset();
        return userstate;
    }

    public void disableTouchEvents()
    {
        if (stackView != null)
        {
            stackView.disableTouchEvents();
        }
    }

    public void enable(UserState userstate)
    {
        reset();
        orientation = container.getResources().getConfiguration().orientation;
        if (orientation == 2)
        {
            columns = columnsLandscape;
        } else
        {
            columns = columnsPortrait;
        }
        if (searchDataSource.getSearchLoaderLogger() != null)
        {
            searchDataSource.getSearchLoaderLogger().setNumOfColumns(columns);
        }
        minRowSize = columns;
        adapter = new GeneratorAdapter(results.getViewGenerator(), 25);
        getStackView();
        stackView.setAdapter(adapter);
        stackView.getView().setVisibility(0);
        if (stackView.getParent() == null)
        {
            container.attachStackView(stackView);
        }
        searchDataSource.getCurrentSearch().addListener(listener);
        enabled = true;
        restoreUserState(userstate);
        update();
        asinVisibilityReporter.startMonitoring();
        if (loaderScrollListener != null)
        {
            loaderScrollListener.processView((AdapterView)stackView, true);
        }
    }

    public void enableTouchEvents()
    {
        if (stackView != null)
        {
            stackView.enableTouchEvents();
        }
    }

    protected void endResult()
    {
        flushProducts();
        flushMainContent();
        flushPendingContent();
        retailSearchLogger.recordEndOfResults();
    }

    protected void flushMainContent()
    {
        showMainContent(true);
    }

    protected void flushPendingContent()
    {
        showPendingContent(true);
    }

    protected void flushProducts()
    {
        flushProducts(true);
    }

    protected void flushProducts(boolean flag)
    {
        showProducts(true);
        if (flag)
        {
            state.setProductRow(null);
        }
    }

    protected GeneratorAdapter getAdapter()
    {
        return adapter;
    }

    public int getAsinGroupIndex(String s)
    {
        if (state != null && state.getAsinGroupMap() != null && state.getAsinGroupMap().containsKey(s))
        {
            return ((Integer)state.getAsinGroupMap().get(s)).intValue();
        } else
        {
            return 0;
        }
    }

    public int getColumns()
    {
        return columns;
    }

    public StackViewContainer getContainer()
    {
        return container;
    }

    public int[] getCoordinates()
    {
        int ai[] = new int[2];
        if (stackView == null)
        {
            return ai;
        } else
        {
            stackView.getLocationOnScreen(ai);
            return ai;
        }
    }

    public int getEntryGroupIndex()
    {
        if (state == null)
        {
            return 0;
        } else
        {
            return state.getEntryGroupIndex();
        }
    }

    protected int getFirstVisibleItemPosition(View view)
    {
        boolean flag = false;
        int j = stackView.getFirstVisiblePosition();
        int i = view.getHeight() / 2;
        if (Math.abs(stackView.getChildAt(0).getTop()) > i)
        {
            flag = true;
        }
        i = j;
        if (flag)
        {
            i = j;
            if (j < results.size() - 1)
            {
                i = j + 1;
            }
        }
        return i;
    }

    public int getMinRowSize()
    {
        return minRowSize;
    }

    protected int getOrientation()
    {
        return orientation;
    }

    protected ImageRequestFactory getProductImageFactory()
    {
        if (productImageFactory == null)
        {
            productImageFactory = createProductImageFactory();
        }
        return productImageFactory;
    }

    protected List getProductLoaders(final Product product)
    {
        if (product == null || product.getImage() == null || TextUtils.isEmpty(product.getImage().getUrl()))
        {
            return null;
        } else
        {
            ArrayList arraylist = new ArrayList(1);
            arraylist.add(new Factory() {

                final StackLayout this$0;
                final Product val$product;

                public ResourceLoader get()
                {
                    return new ImageLoader(resourceProvider.getContext(), 0L, productImageFactory.fromUrl(product.getImage().getUrl()));
                }

                public volatile Object get()
                {
                    return get();
                }

            
            {
                this$0 = StackLayout.this;
                product = product1;
                super();
            }
            });
            return arraylist;
        }
    }

    protected LinearLayout getProgressBar()
    {
        return progressBar;
    }

    public ResourceProvider getResourceProvider()
    {
        return resourceProvider;
    }

    protected ScrollListener getScrollListener()
    {
        return scrollListener;
    }

    protected StackView getStackView()
    {
        if (stackView == null)
        {
            stackView = createStackView();
        }
        return stackView;
    }

    public UserState getUserState()
    {
        return saveUserState();
    }

    protected void hideProgressBar()
    {
        progressBar.setVisibility(8);
    }

    protected void incrementAtfImageCount()
    {
        int i = state.getAtfImagesLoadedCount() + 1;
        state.setAtfImagesLoadedCount(i);
        if (i >= atfProductCount && retailSearchLogger != null)
        {
            searchDataSource.logATF();
        }
    }

    protected void insert(LayoutElement layoutelement)
    {
        int i = results.binarySearch(layoutelement);
        if (i >= 0) goto _L2; else goto _L1
_L1:
        int j = 0 - i - 1;
_L4:
        results.add(j, layoutelement, state);
        modified = true;
        return;
_L2:
        i++;
_L6:
        j = i;
        if (i >= results.size()) goto _L4; else goto _L3
_L3:
        j = i;
        if (layoutelement.compareTo(results.get(i)) != 0) goto _L4; else goto _L5
_L5:
        i++;
          goto _L6
    }

    protected void loadAtBottom(int i, int j)
    {
        SearchTask searchtask;
        for (searchtask = searchDataSource.getCurrentSearch(); searchtask.isLoading() || com.amazon.retailsearch.data.search.ResultStream.Status.Error.equals(searchtask.getStatus()) || j < results.size() - ((j - i) + 1) * 2;)
        {
            return;
        }

        searchtask.loadNext();
    }

    protected void loadAtfImage(Image image)
    {
        if (!searchDataSource.isATFLogged() && image != null && !TextUtils.isEmpty(image.getUrl()))
        {
            if ((image = productImageFactory.fromUrl(image.getUrl())) != null)
            {
                AbstractResourceListener abstractresourcelistener = new AbstractResourceListener() {

                    final StackLayout this$0;

                    public void result(Bitmap bitmap)
                    {
                        if (bitmap != null && state != null && atfImageListeners.contains(this))
                        {
                            int i = state.getAtfImagesLoadedCount() + 1;
                            state.setAtfImagesLoadedCount(i);
                            if (i >= atfProductCount)
                            {
                                searchDataSource.logATF();
                                return;
                            }
                        }
                    }

                    public volatile void result(Object obj)
                    {
                        result((Bitmap)obj);
                    }

            
            {
                this$0 = StackLayout.this;
                super();
            }
                };
                atfImageListeners.add(abstractresourcelistener);
                image = new ImageLoader(resourceProvider.getContext(), abstractresourcelistener, System.currentTimeMillis() + 10000L, image);
                resourceProvider.execute(image);
                return;
            }
        }
    }

    public void pause()
    {
        if ("T1".equals(FeatureStateUtil.getAdaptiveSearchWeblab(featureConfig)))
        {
            ((LatencyAdaptiveManager)latencyAdaptiveManager.get()).saveData();
        }
        asinVisibilityReporter.stopMonitoring();
    }

    protected void preloadImages(PreloadImages preloadimages)
    {
        if (enabled && preloadimages != null)
        {
            if ("T1".equals(FeatureStateUtil.getAdaptiveSearchWeblab(featureConfig)))
            {
                ((LatencyAdaptiveManager)latencyAdaptiveManager.get()).adaptModel(preloadimages, preloadImagesAdapter);
            }
            preloadimages = preloadimages.getImages().iterator();
            while (preloadimages.hasNext()) 
            {
                Object obj = (Image)preloadimages.next();
                if (obj != null && !TextUtils.isEmpty(((Image) (obj)).getUrl()))
                {
                    obj = getProductImageFactory().fromUrl(((Image) (obj)).getUrl());
                    if (obj != null)
                    {
                        resourceProvider.getImage(((ImageRequest) (obj)), null);
                    }
                }
            }
        }
    }

    protected void reset()
    {
        enabled = false;
        searchDataSource.getCurrentSearch().removeListener(listener);
        results.clear();
        detachViews();
        adapter = null;
        state = null;
        prevState = null;
        modified = false;
        atfImageListeners.clear();
        if (animatableResultsImage != null)
        {
            animatableResultsImage.reset();
            enableTouchEvents();
        }
        adShouldInsert = true;
        atfAsins.clear();
    }

    protected void restoreUserState(UserState userstate)
    {
        if (userstate != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj;
        Object obj1 = userstate.getSelectedModel();
        obj = obj1;
        if (obj1 != null)
        {
            break; /* Loop/switch isn't completed */
        }
        userstate = userstate.getCurrentDataInFocus();
        if (userstate == null || userstate.getCanonicalModel() == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = userstate.getCanonicalModel();
        break; /* Loop/switch isn't completed */
        if (true) goto _L1; else goto _L3
_L3:
        userstate = results.getByModel(obj);
        if (userstate != null)
        {
            stackView.setSelection(userstate.intValue());
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    public void resume()
    {
        asinVisibilityReporter.startMonitoring();
    }

    public void scrollToResultsModel(Object obj, int i)
    {
        if (results != null)
        {
            obj = results.getByModel(obj);
        } else
        {
            obj = null;
        }
        if (obj == null || stackView == null)
        {
            return;
        } else
        {
            stackView.smoothScrollToPositionFromTop(((Integer) (obj)).intValue(), 75, i);
            return;
        }
    }

    public void setAsinGroupCount(int i)
    {
        asinGroupCount = i;
    }

    public void setEntryGroupAsin(String s)
    {
        if (state == null)
        {
            state = new StackLayoutState();
        }
        state.setEntryAsin(s);
        state.setEntryGroupIndex(getAsinGroupIndex(s));
    }

    public void setFilterRequestListener(FilterRequestListener filterrequestlistener)
    {
        filterRequestListener = filterrequestlistener;
    }

    protected void setStackView(StackView stackview)
    {
        stackView = stackview;
    }

    protected void showMainContent(boolean flag)
    {
        int i = 0;
        Iterator iterator = state.getMainContent().iterator();
        do
        {
            MainElement mainelement;
label0:
            {
                if (iterator.hasNext())
                {
                    mainelement = (MainElement)iterator.next();
                    if (flag || mainelement.getPosition() <= state.getProductRowCount())
                    {
                        break label0;
                    }
                }
                if (i > 0)
                {
                    state.getMainContent().subList(0, i).clear();
                }
                return;
            }
            add(mainelement.getViewEntry(), mainelement.getLayoutElementModel());
            i++;
        } while (true);
    }

    protected void showPendingContent(boolean flag)
    {
        int i = 0;
        Iterator iterator = state.getPendingContent().iterator();
        do
        {
            LayoutElement layoutelement;
label0:
            {
                if (iterator.hasNext())
                {
                    layoutelement = (LayoutElement)iterator.next();
                    if (flag || layoutelement.getRequestedPosition() <= state.getNextPosition())
                    {
                        break label0;
                    }
                }
                if (i > 0)
                {
                    state.getPendingContent().subList(0, i).clear();
                }
                return;
            }
            insert(layoutelement);
            i++;
        } while (true);
    }

    protected void showProducts(boolean flag)
    {
        if (state != null && !Utils.isEmpty(state.getProducts())) goto _L2; else goto _L1
_L1:
        return;
_L2:
        List list;
        int i;
        list = state.getProducts();
        i = 0;
_L12:
        LayoutElement layoutelement = state.getProductRow();
        if (layoutelement == null || layoutelement.getEntry() == null || ((ContentRowEntry)layoutelement.getEntry()).getModel() == null || ((ContentRowModel)((ContentRowEntry)layoutelement.getEntry()).getModel()).getContent() == null || ((ContentRowModel)((ContentRowEntry)layoutelement.getEntry()).getModel()).getContent().size() >= ((ContentRowModel)((ContentRowEntry)layoutelement.getEntry()).getModel()).getColumns()) goto _L4; else goto _L3
_L3:
        ContentRowModel contentrowmodel;
        contentrowmodel = new ContentRowModel((ContentRowModel)((ContentRowEntry)layoutelement.getEntry()).getModel());
        ((ContentRowEntry)layoutelement.getEntry()).setModel(contentrowmodel);
        modified = true;
_L9:
        int j;
        int k;
        k = Math.min(list.size(), (contentrowmodel.getColumns() + i) - contentrowmodel.getContent().size());
        j = i;
        if (i < k) goto _L6; else goto _L5
_L5:
        if (i <= 0) goto _L1; else goto _L7
_L7:
        list.subList(0, i).clear();
        return;
_L4:
        if (!flag && list.size() - i < minRowSize) goto _L5; else goto _L8
_L8:
        contentrowmodel = new ContentRowModel(new ArrayList(columns), columns, 0);
        layoutelement = createLayoutElement(createRow(contentrowmodel), ListBasedLayoutElementModel.create(new ArrayList(columns)));
        add(layoutelement);
        state.setProductRow(layoutelement);
        state.setProductRowCount(state.getProductRowCount() + 1);
        showMainContent(false);
          goto _L9
_L11:
        modified = true;
        j++;
_L6:
        if (j >= k)
        {
            break; /* Loop/switch isn't completed */
        }
        Object obj = (Product)list.get(j);
        ProductViewModel productviewmodel = createProductViewModel(((Product) (obj)), layoutelement, true, null);
        contentrowmodel.getContent().add(createProductCell(((Product) (obj)), productviewmodel));
        ((ListBasedLayoutElementModel)layoutelement.getLayoutElementModel()).getAllModels().add(obj);
        results.updateModels(layoutelement.getLayoutElementModel());
        obj = getProductLoaders(((Product) (obj)));
        if (obj != null)
        {
            obj = ((List) (obj)).iterator();
            while (((Iterator) (obj)).hasNext()) 
            {
                layoutelement.addLoader((Factory)((Iterator) (obj)).next());
            }
        }
        if (true) goto _L11; else goto _L10
_L10:
        results.finalizeModels(layoutelement.getLayoutElementModel());
        i = j;
          goto _L12
    }

    protected void showProgressBar()
    {
        progressBar.setVisibility(0);
    }

    protected void startPage()
    {
        if (state == null)
        {
            state = new StackLayoutState();
        }
        prevState = new StackLayoutState(state);
        state.setStartingSize(results.size());
        state.setStartingPosition(state.getNextPosition());
        state.setStartingProductRowCount(state.getProductRowCount());
    }

    protected void update()
    {
        if (enabled && modified)
        {
            adapter.notifyDataSetChanged();
            modified = false;
        }
    }


/*
    static LayoutElement access$1002(StackLayout stacklayout, LayoutElement layoutelement)
    {
        stacklayout.mixCorrectionsLayoutElement = layoutelement;
        return layoutelement;
    }

*/



/*
    static MixedCorrectionsModel access$1102(StackLayout stacklayout, MixedCorrectionsModel mixedcorrectionsmodel)
    {
        stacklayout.mixedCorrectionsModel = mixedcorrectionsmodel;
        return mixedcorrectionsmodel;
    }

*/





/*
    static int access$1408(StackLayout stacklayout)
    {
        int i = stacklayout.asinGroupCount;
        stacklayout.asinGroupCount = i + 1;
        return i;
    }

*/


/*
    static boolean access$1502(StackLayout stacklayout, boolean flag)
    {
        stacklayout.modified = flag;
        return flag;
    }

*/




/*
    static String access$1802(StackLayout stacklayout, String s)
    {
        stacklayout.store = s;
        return s;
    }

*/











/*
    static Refinements access$902(StackLayout stacklayout, Refinements refinements1)
    {
        stacklayout.refinements = refinements1;
        return refinements1;
    }

*/
}
