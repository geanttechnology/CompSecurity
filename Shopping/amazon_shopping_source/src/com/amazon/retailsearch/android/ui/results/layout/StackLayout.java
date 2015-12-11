// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.layout;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import com.amazon.ansel.fetch.AbstractResourceListener;
import com.amazon.ansel.fetch.ImageLoader;
import com.amazon.ansel.fetch.ImageRequest;
import com.amazon.ansel.fetch.ResourceLoader;
import com.amazon.ansel.fetch.ResourceProvider;
import com.amazon.ansel.fetch.UriRequest;
import com.amazon.ansel.fetch.listview.PredictiveScrollListener;
import com.amazon.ansel.fetch.tools.collection.Factory;
import com.amazon.retailsearch.android.api.log.RetailSearchLogger;
import com.amazon.retailsearch.android.api.log.RetailSearchLoggingProvider;
import com.amazon.retailsearch.android.ui.ImageRequestFactory;
import com.amazon.retailsearch.android.ui.listadapter.GeneratorAdapter;
import com.amazon.retailsearch.android.ui.listadapter.ModelViewEntry;
import com.amazon.retailsearch.android.ui.listadapter.ViewBuilderEntry;
import com.amazon.retailsearch.android.ui.listadapter.ViewEntry;
import com.amazon.retailsearch.android.ui.results.ProductViewModel;
import com.amazon.retailsearch.android.ui.results.layout.entry.ContentRowEntry;
import com.amazon.retailsearch.android.ui.results.layout.model.ContentRowModel;
import com.amazon.retailsearch.android.ui.results.layout.view.CategoryCorrectedView;
import com.amazon.retailsearch.android.ui.results.layout.view.DidYouMeanView;
import com.amazon.retailsearch.android.ui.results.layout.view.ErrorView;
import com.amazon.retailsearch.android.ui.results.layout.view.FkmrHeader;
import com.amazon.retailsearch.android.ui.results.layout.view.NoResultsSetView;
import com.amazon.retailsearch.android.ui.results.layout.view.RelatedSearchesView;
import com.amazon.retailsearch.android.ui.results.layout.view.SpellCorrectedHeader;
import com.amazon.retailsearch.android.ui.results.layout.view.WordSplitterView;
import com.amazon.retailsearch.data.SearchTask;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import com.amazon.retailsearch.interaction.SearchDataSource;
import com.amazon.retailsearch.interaction.UserInteractionListener;
import com.amazon.retailsearch.metrics.impressions.AsinImpressionTracker;
import com.amazon.retailsearch.metrics.impressions.ProductViewSnapshot;
import com.amazon.retailsearch.util.Utils;
import com.amazon.searchapp.retailsearch.client.MsaUtil;
import com.amazon.searchapp.retailsearch.entity.ProductEntity;
import com.amazon.searchapp.retailsearch.model.CategoryCorrected;
import com.amazon.searchapp.retailsearch.model.DidYouMean;
import com.amazon.searchapp.retailsearch.model.FKMR;
import com.amazon.searchapp.retailsearch.model.Hidden;
import com.amazon.searchapp.retailsearch.model.Image;
import com.amazon.searchapp.retailsearch.model.NoResultsSet;
import com.amazon.searchapp.retailsearch.model.PreloadImages;
import com.amazon.searchapp.retailsearch.model.Product;
import com.amazon.searchapp.retailsearch.model.ProductSection;
import com.amazon.searchapp.retailsearch.model.RelatedSearches;
import com.amazon.searchapp.retailsearch.model.SpellCorrected;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.layout:
//            SearchLayout, ResultsController, UserState, StackLayoutState, 
//            StackView, LayoutElement, SingleLayoutElementModel, VerticalStackView, 
//            LayoutElementModel, ListBasedLayoutElementModel

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
                                    obj1 = ((ProductEntity)obj1).getAsin();
                                    if (!asinImpressionTracker.wasAsinViewed(((String) (obj1))))
                                    {
                                        arraylist.add(obj1);
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

    private static class SectionIndex
    {

        private static final int ERROR = 1;
        private static final int MAIN = 0;

        private SectionIndex()
        {
        }
    }


    private GeneratorAdapter adapter;
    private int asinGroupCount;
    private final AsinImpressionTracker asinImpressionTracker;
    private AsinVisibilityReporter asinVisibilityReporter;
    private List atfImageListeners;
    private final int atfProductCount;
    private int columns;
    private final int columnsLandscape;
    private final int columnsPortrait;
    private final ViewGroup container;
    private boolean enabled;
    private final Listener listener;
    protected final LoaderScrollListener loaderScrollListener;
    private final int minRowSize;
    private boolean modified;
    private int orientation;
    private StackLayoutState prevState;
    private ImageRequestFactory productImageFactory;
    private final Point productImageSize;
    private LinearLayout progressBar;
    private final ResourceProvider resourceProvider;
    protected ResultsController results;
    private RetailSearchLogger retailSearchLogger;
    private final ScrollListener scrollListener;
    SearchDataSource searchDataSource;
    protected StackView stackView;
    private StackLayoutState state;
    UserInteractionListener userInteractionListener;

    private StackLayout(ViewGroup viewgroup, int i, int j, int k, ResourceProvider resourceprovider, AsinImpressionTracker asinimpressiontracker, Point point, 
            int l)
    {
        results = new ResultsController();
        listener = new Listener();
        scrollListener = new ScrollListener();
        retailSearchLogger = RetailSearchLoggingProvider.getInstance().getRetailSearchLogger();
        atfImageListeners = new ArrayList();
        container = viewgroup;
        columns = i;
        columnsPortrait = i;
        columnsLandscape = j;
        minRowSize = Math.min(i, k);
        resourceProvider = resourceprovider;
        asinImpressionTracker = asinimpressiontracker;
        productImageSize = point;
        atfProductCount = l;
        loaderScrollListener = new LoaderScrollListener(resourceprovider);
        productImageFactory = getProductImageFactory();
        asinVisibilityReporter = new AsinVisibilityReporter();
        RetailSearchDaggerGraphController.inject(this);
        asinGroupCount = 0;
    }

    public StackLayout(ViewGroup viewgroup, int i, int j, ResourceProvider resourceprovider, AsinImpressionTracker asinimpressiontracker, int k, int l, 
            int i1)
    {
        StackLayout(viewgroup, i, j, i, resourceprovider, asinimpressiontracker, naturalDimensions(viewgroup.getResources(), k, l), viewgroup.getResources().getInteger(i1));
    }

    public StackLayout(ViewGroup viewgroup, int i, ResourceProvider resourceprovider, AsinImpressionTracker asinimpressiontracker, int j, int k, int l)
    {
        StackLayout(viewgroup, i, i, i, resourceprovider, asinimpressiontracker, naturalDimensions(viewgroup.getResources(), j, k), viewgroup.getResources().getInteger(l));
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

    protected static ModelViewEntry createContentView(int i, Class class1, Object obj)
    {
        return ModelViewEntry.create(i, class1, obj);
    }

    private boolean isHiddenProduct(Product product)
    {
        return product != null && product.getHidden() != null && !TextUtils.isEmpty(product.getHidden().getType());
    }

    public static Point naturalDimensions(Resources resources, int i, int j)
    {
        return new Point((int)((double)(resources.getDimension(i) / resources.getDisplayMetrics().density) + 0.5D), (int)((double)(resources.getDimension(j) / resources.getDisplayMetrics().density) + 0.5D));
    }

    private UserState saveUserState()
    {
        UserState userstate = new UserState();
        if (!results.isEmpty())
        {
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
            if (userstate.getSelectedModel() == null)
            {
                View view = stackView.getChildAt(0);
                if (view != null)
                {
                    int i = getFirstVisibleItemPosition(view);
                    userstate.setCurrentDataInFocus(results.get(i).getLayoutElementModel());
                    return userstate;
                }
            }
        }
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

    protected void addDidYouMean(DidYouMean didyoumean)
    {
        if (didyoumean == null)
        {
            return;
        } else
        {
            add(new LayoutElement(createDidYouMean(didyoumean), 0, state.getStartingPosition(), SingleLayoutElementModel.create(didyoumean)));
            return;
        }
    }

    protected void addError(Exception exception)
    {
        add(new LayoutElement(createErrorView(exception), 1, 0, SingleLayoutElementModel.create(exception)));
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
        if (product == null || isHiddenProduct(product))
        {
            return false;
        }
        state.setProductCount(state.getProductCount() + 1);
        state.getProducts().add(product);
        if (state.getProductCount() <= atfProductCount)
        {
            loadAtfImage(product.getImage());
        }
        return true;
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
        orientation = i;
        enable(saveUserState());
        if (columnsPortrait != columnsLandscape);
    }

    protected void clearError()
    {
        results.clear(state.getStartingSize(), results.size());
        modified = true;
        state = new StackLayoutState(prevState);
    }

    protected ViewBuilderEntry createCategoryCorrectedHeader(CategoryCorrected categorycorrected)
    {
        return createContentView(11, com/amazon/retailsearch/android/ui/results/layout/view/CategoryCorrectedView, categorycorrected);
    }

    protected ViewBuilderEntry createDidYouMean(DidYouMean didyoumean)
    {
        return createContentView(12, com/amazon/retailsearch/android/ui/results/layout/view/DidYouMeanView, didyoumean);
    }

    protected ViewBuilderEntry createErrorView(Exception exception)
    {
        return createContentView(0, com/amazon/retailsearch/android/ui/results/layout/view/ErrorView, exception);
    }

    protected ViewBuilderEntry createFkmrHeader(FKMR fkmr)
    {
        return createContentView(8, com/amazon/retailsearch/android/ui/results/layout/view/FkmrHeader, fkmr);
    }

    protected LayoutElement createLayoutElement(ViewEntry viewentry, LayoutElementModel layoutelementmodel)
    {
        return new LayoutElement(viewentry, 0, state.getNextPosition(), layoutelementmodel);
    }

    protected ViewBuilderEntry createNoResultsSet(NoResultsSet noresultsset)
    {
        return createContentView(14, com/amazon/retailsearch/android/ui/results/layout/view/NoResultsSetView, noresultsset);
    }

    protected abstract ViewBuilderEntry createProductCell(Product product);

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
                    return new ImageRequest(new UriRequest(MsaUtil.setImageRes(s, Math.max(productImageSize.x, productImageSize.y))), 160);
                }
            }

            
            {
                this$0 = StackLayout.this;
                super();
            }
        };
    }

    protected ProductViewModel createProductViewModel(Product product)
    {
        return new ProductViewModel(product, getProductImageFactory(), resourceProvider);
    }

    protected ViewBuilderEntry createRelatedSearches(RelatedSearches relatedsearches)
    {
        return createContentView(13, com/amazon/retailsearch/android/ui/results/layout/view/RelatedSearchesView, relatedsearches);
    }

    protected ContentRowEntry createRow(ContentRowModel contentrowmodel)
    {
        return new ContentRowEntry(1, contentrowmodel);
    }

    protected ViewBuilderEntry createSpellCorrectionHeader(SpellCorrected spellcorrected)
    {
        return createContentView(9, com/amazon/retailsearch/android/ui/results/layout/view/SpellCorrectedHeader, spellcorrected);
    }

    protected StackView createStackView()
    {
        VerticalStackView verticalstackview = (VerticalStackView)LayoutInflater.from(container.getContext()).inflate(com.amazon.retailsearch.R.layout.rs_vertical_stack_view, container, true).findViewById(com.amazon.retailsearch.R.id.rs_vertical_stack_view);
        verticalstackview.setOnScrollListener(scrollListener);
        progressBar = (LinearLayout)LayoutInflater.from(container.getContext()).inflate(com.amazon.retailsearch.R.layout.rs_search_spinner, null);
        verticalstackview.addFooterView(progressBar, null, false);
        setStackView(verticalstackview);
        return verticalstackview;
    }

    protected ViewBuilderEntry createWordSplitterHeader(SpellCorrected spellcorrected)
    {
        return createContentView(10, com/amazon/retailsearch/android/ui/results/layout/view/WordSplitterView, spellcorrected);
    }

    protected void detachViews()
    {
        if (stackView != null)
        {
            if (stackView.getParent() != null)
            {
                ((ViewGroup)stackView.getParent()).removeView(stackView.getView());
            }
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
        adapter = new GeneratorAdapter(results.getViewGenerator(), 15);
        getStackView();
        stackView.setAdapter(adapter);
        stackView.getView().setVisibility(0);
        if (stackView.getParent() == null)
        {
            container.addView(stackView.getView());
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

    public ViewGroup getContainer()
    {
        return container;
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

    public Point getProductImageSize()
    {
        return productImageSize;
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

    protected void insert(LayoutElement layoutelement)
    {
        int i = results.binarySearch(layoutelement);
        if (i >= 0) goto _L2; else goto _L1
_L1:
        i = 0 - i - 1;
_L4:
        results.add(i, layoutelement);
        modified = true;
_L7:
        if (i < results.size())
        {
            LayoutElement layoutelement1 = results.get(i);
            if (i > 0)
            {
                LayoutElement layoutelement2 = results.get(i - 1);
                if (layoutelement2.getSection() == layoutelement1.getSection())
                {
                    layoutelement1.setPosition(layoutelement2.getPosition() + layoutelement2.getSpan());
                }
            }
            if (state.getNextPosition() == layoutelement1.getPosition() && layoutelement.getSection() == 0)
            {
                state.setNextPosition(layoutelement1.getPosition() + layoutelement1.getSpan());
            }
            if (layoutelement1.getSection() == layoutelement.getSection())
            {
                break MISSING_BLOCK_LABEL_201;
            }
        }
        return;
_L2:
        int j = i + 1;
_L6:
        i = j;
        if (j >= results.size()) goto _L4; else goto _L3
_L3:
        i = j;
        if (layoutelement.compareTo(results.get(j)) != 0) goto _L4; else goto _L5
_L5:
        j++;
          goto _L6
        i++;
          goto _L7
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
        if (enabled && image != null && !TextUtils.isEmpty(image.getUrl()))
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
                            if (i >= atfProductCount && retailSearchLogger != null)
                            {
                                retailSearchLogger.searchATFReached();
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
        asinVisibilityReporter.stopMonitoring();
    }

    protected void preloadImages(PreloadImages preloadimages)
    {
        if (enabled && preloadimages != null)
        {
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
        List list = state.getProducts();
        if (!list.isEmpty()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int i = 0;
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
        contentrowmodel.getContent().add(createProductCell(((Product) (obj))));
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
    static int access$1108(StackLayout stacklayout)
    {
        int i = stacklayout.asinGroupCount;
        stacklayout.asinGroupCount = i + 1;
        return i;
    }

*/









}
