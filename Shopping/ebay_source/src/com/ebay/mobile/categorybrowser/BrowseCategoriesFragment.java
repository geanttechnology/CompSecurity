// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.categorybrowser;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.ebay.android.widget.RemoteImageView;
import com.ebay.common.Preferences;
import com.ebay.common.model.search.EbayCategorySummary;
import com.ebay.common.net.api.search.SearchParameters;
import com.ebay.common.view.EbayErrorHandler;
import com.ebay.mobile.ActivityStarter;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.activities.BaseFragment;
import com.ebay.mobile.analytics.model.SourceIdentification;
import com.ebay.mobile.common.view.ViewHolder;
import com.ebay.mobile.common.view.ViewModel;
import com.ebay.mobile.eBayDictionaryProvider;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.dm.CategoryServiceDataManager;
import com.ebay.nautilus.domain.data.EbayCategory;
import com.ebay.nautilus.domain.data.EbayCategoryNode;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.util.NumberUtil;
import com.ebay.nautilus.shell.app.DataManagerContainer;
import java.lang.ref.WeakReference;

// Referenced classes of package com.ebay.mobile.categorybrowser:
//            CategoryLineItemAdapter, CategoryViewModel

public final class BrowseCategoriesFragment extends BaseFragment
    implements com.ebay.nautilus.domain.content.dm.CategoryServiceDataManager.Observer
{
    public static final class BranchNodeOnClickListener
        implements com.ebay.mobile.common.view.ViewModel.OnClickListener
    {

        private final WeakReference fragmentReference;

        public void onClick(View view, ViewModel viewmodel)
        {
            BrowseCategoriesFragment browsecategoriesfragment;
            browsecategoriesfragment = (BrowseCategoriesFragment)fragmentReference.get();
            break MISSING_BLOCK_LABEL_11;
            if (browsecategoriesfragment != null && browsecategoriesfragment.getView() != null && browsecategoriesfragment.getView().getParent() != null && (viewmodel instanceof CategoryViewModel))
            {
                viewmodel = ((CategoryViewModel)viewmodel).category;
                if (viewmodel != null)
                {
                    Object obj = new Bundle();
                    ((Bundle) (obj)).putLong("categoryId", ((EbayCategory) (viewmodel)).id);
                    ((Bundle) (obj)).putString("categoryName", ((EbayCategory) (viewmodel)).name);
                    ((Bundle) (obj)).putInt("categoryLevel", ((EbayCategory) (viewmodel)).level);
                    if (browsecategoriesfragment.categoryId == -1L)
                    {
                        view = CategoryViewModel.getCategoryImageUrl(((EbayCategory) (viewmodel)).id);
                    } else
                    {
                        view = browsecategoriesfragment.categoryImageUrl;
                    }
                    ((Bundle) (obj)).putString("categoryImageUrl", view);
                    if (browsecategoriesfragment.categorySite == EbaySite.US && ((EbayCategory) (viewmodel)).id == 6000L)
                    {
                        view = EbaySite.MOTOR;
                    } else
                    {
                        view = browsecategoriesfragment.categorySite;
                    }
                    ((Bundle) (obj)).putParcelable("categorySite", view);
                    view = new EbayCategory[browsecategoriesfragment.navigationBreadcrumbs.length + 1];
                    System.arraycopy(browsecategoriesfragment.navigationBreadcrumbs, 0, view, 0, browsecategoriesfragment.navigationBreadcrumbs.length);
                    view[view.length - 1] = viewmodel;
                    ((Bundle) (obj)).putParcelableArray("navigationIdPath", view);
                    view = Fragment.instantiate(browsecategoriesfragment.getActivity(), com/ebay/mobile/categorybrowser/BrowseCategoriesFragment.getName(), ((Bundle) (obj)));
                    obj = browsecategoriesfragment.getFragmentManager().beginTransaction();
                    if (android.os.Build.VERSION.SDK_INT >= 21)
                    {
                        Object obj2 = TransitionInflater.from(browsecategoriesfragment.getActivity());
                        Object obj1 = ((TransitionInflater) (obj2)).inflateTransition(0x10f0001);
                        obj2 = ((TransitionInflater) (obj2)).inflateTransition(0x10f0002);
                        view.setSharedElementEnterTransition(((android.transition.Transition) (obj1)));
                        view.setEnterTransition(null);
                        browsecategoriesfragment.setExitTransition(null);
                        view.setSharedElementReturnTransition(((android.transition.Transition) (obj1)));
                        view.setReturnTransition(((android.transition.Transition) (obj2)));
                        browsecategoriesfragment.setReenterTransition(null);
                        int i = browsecategoriesfragment.adapter.findAdapterPositionByEbayCategoryId(((EbayCategory) (viewmodel)).id);
                        obj1 = browsecategoriesfragment.categoryList.findViewHolderForAdapterPosition(i);
                        if (obj1 != null && ((android.support.v7.widget.RecyclerView.ViewHolder) (obj1)).itemView != null)
                        {
                            ((FragmentTransaction) (obj)).addSharedElement(((android.support.v7.widget.RecyclerView.ViewHolder) (obj1)).itemView, ((android.support.v7.widget.RecyclerView.ViewHolder) (obj1)).itemView.getTransitionName());
                        }
                    }
                    viewmodel = BrowseCategoriesFragment.createFragmentTag(((EbayCategory) (viewmodel)).level);
                    ((FragmentTransaction) (obj)).addToBackStack(viewmodel).replace(((ViewGroup)browsecategoriesfragment.getView().getParent()).getId(), view, viewmodel);
                    ((FragmentTransaction) (obj)).commit();
                    return;
                }
            }
            return;
        }

        public BranchNodeOnClickListener(BrowseCategoriesFragment browsecategoriesfragment)
        {
            fragmentReference = new WeakReference(browsecategoriesfragment);
        }
    }

    public static class DividerItemDecoration extends android.support.v7.widget.RecyclerView.ItemDecoration
    {

        private static final int DIVIDER_HEIGHT = 2;
        private final int childSeparatorColor;
        private final int navigationSeparatorColor;
        private final int separatorLeftPadding;

        public void onDrawOver(Canvas canvas, RecyclerView recyclerview, android.support.v7.widget.RecyclerView.State state)
        {
            if (recyclerview.getLayoutManager() instanceof LinearLayoutManager)
            {
                break MISSING_BLOCK_LABEL_10;
            } else
            {
                throw new IllegalStateException("DividerItemDecoration can only be used with a LinearLayoutManager.");
            }
_L2:
            int i;
            int j;
            int k;
            int l;
            while (i > l) 
            {
                do
                {
                    return;
                } while (((LinearLayoutManager)recyclerview.getLayoutManager()).getOrientation() != 1 || recyclerview.getItemAnimator().isRunning());
                j = recyclerview.getPaddingLeft();
                k = recyclerview.getWidth() - recyclerview.getPaddingRight();
                state = (LinearLayoutManager)recyclerview.getLayoutManager();
                i = state.findFirstVisibleItemPosition();
                l = state.findLastVisibleItemPosition();
                i = Math.max(i, 1);
            }
            state = recyclerview.findViewHolderForLayoutPosition(i);
            if (state instanceof ViewHolder)
            {
                break; /* Loop/switch isn't completed */
            }
_L4:
            i++;
            if (true) goto _L2; else goto _L1
_L1:
            Object obj;
            int i1;
            int j1;
            obj = ((android.support.v7.widget.RecyclerView.ViewHolder) (state)).itemView;
            android.support.v7.widget.RecyclerView.LayoutParams layoutparams = (android.support.v7.widget.RecyclerView.LayoutParams)((View) (obj)).getLayoutParams();
            state = new Paint();
            i1 = ((View) (obj)).getTop() - layoutparams.topMargin - 2;
            j1 = ((View) (obj)).getTop();
            obj = recyclerview.findViewHolderForLayoutPosition(i - 1);
            if (obj == null) goto _L4; else goto _L3
_L3:
            switch (((android.support.v7.widget.RecyclerView.ViewHolder) (obj)).getItemViewType())
            {
            default:
                state.setColor(childSeparatorColor);
                canvas.drawRect(j, i1, k, j1, state);
                break;

            case 3: // '\003'
            case 4: // '\004'
                state.setColor(navigationSeparatorColor);
                canvas.drawRect(j, i1, separatorLeftPadding - 1, j1, state);
                state.setColor(childSeparatorColor);
                canvas.drawRect(separatorLeftPadding + j, i1, k, j1, state);
                break;
            }
            if (true) goto _L4; else goto _L5
_L5:
        }

        public DividerItemDecoration(Context context)
        {
            context = context.getResources();
            childSeparatorColor = context.getColor(0x7f0d00d2);
            navigationSeparatorColor = context.getColor(0x106000b);
            separatorLeftPadding = context.getDimensionPixelSize(0x7f09010b);
        }
    }

    public static final class LeafNodeOnClickListener
        implements com.ebay.mobile.common.view.ViewModel.OnClickListener
    {

        private final WeakReference fragmentReference;

        public void onClick(View view, ViewModel viewmodel)
        {
            for (view = (BrowseCategoriesFragment)fragmentReference.get(); view == null || !(viewmodel instanceof CategoryViewModel);)
            {
                return;
            }

            view.startSearch(((CategoryViewModel)viewmodel).category);
        }

        public LeafNodeOnClickListener(BrowseCategoriesFragment browsecategoriesfragment)
        {
            fragmentReference = new WeakReference(browsecategoriesfragment);
        }
    }

    public static final class NavigationOnClickListener
        implements com.ebay.mobile.common.view.ViewModel.OnClickListener
    {

        private final WeakReference fragmentReference;

        public void onClick(View view, ViewModel viewmodel)
        {
            BrowseCategoriesFragment browsecategoriesfragment;
            browsecategoriesfragment = (BrowseCategoriesFragment)fragmentReference.get();
            break MISSING_BLOCK_LABEL_11;
            if (browsecategoriesfragment != null && (viewmodel instanceof CategoryViewModel))
            {
                viewmodel = ((CategoryViewModel)viewmodel).category;
                if (viewmodel != null)
                {
                    view = BrowseCategoriesFragment.createFragmentTag(((EbayCategory) (viewmodel)).level);
                    int i = 0;
                    if (((EbayCategory) (viewmodel)).level < 1)
                    {
                        view = BrowseCategoriesFragment.createFragmentTag(1);
                        i = 1;
                    }
                    FragmentManager fragmentmanager = browsecategoriesfragment.getFragmentManager();
                    if (!browsecategoriesfragment.isTablet && ((EbayCategory) (viewmodel)).level < 1 && android.os.Build.VERSION.SDK_INT >= 21)
                    {
                        browsecategoriesfragment.setReturnTransition(TransitionInflater.from(browsecategoriesfragment.getActivity()).inflateTransition(0x10f0004));
                    }
                    fragmentmanager.popBackStack(view, i);
                    return;
                }
            }
            return;
        }

        public NavigationOnClickListener(BrowseCategoriesFragment browsecategoriesfragment)
        {
            fragmentReference = new WeakReference(browsecategoriesfragment);
        }
    }


    public static final String EXTRA_CATEGORY_ID = "categoryId";
    public static final String EXTRA_CATEGORY_IMAGE_URL = "categoryImageUrl";
    public static final String EXTRA_CATEGORY_LEVEL = "categoryLevel";
    public static final String EXTRA_CATEGORY_NAME = "categoryName";
    public static final String EXTRA_CATEGORY_SITE = "categorySite";
    public static final String EXTRA_NAVIGATION_BREADCRUMBS = "navigationIdPath";
    private static final String FRAGMENT_TAG_PREFIX = "Level";
    private CategoryLineItemAdapter adapter;
    private long categoryId;
    private String categoryImageUrl;
    protected RemoteImageView categoryImageView;
    private int categoryLevel;
    private RecyclerView categoryList;
    private String categoryName;
    private EbaySite categorySite;
    protected boolean isTablet;
    private EbayCategory navigationBreadcrumbs[];

    public BrowseCategoriesFragment()
    {
    }

    public static EbayCategory[] constructNavigationBreadcrumbs(Context context, EbayCategory ebaycategory)
    {
        context = new EbayCategory(-1L, context.getString(0x7f07053e));
        if (ebaycategory.idPath != null && ebaycategory.namePath != null)
        {
            String as[] = ebaycategory.idPath.split(":");
            String as1[] = ebaycategory.namePath.split(":");
            if (as.length == as1.length)
            {
                ebaycategory = new EbayCategory[as.length + 1];
                ebaycategory[0] = context;
                int i = 0;
                do
                {
label0:
                    {
                        context = ebaycategory;
                        if (i < as.length)
                        {
                            context = NumberUtil.safeParseLong(as[i]);
                            if (context != null)
                            {
                                break label0;
                            }
                            context = null;
                        }
                        return context;
                    }
                    context = new EbayCategory(context.longValue(), as1[i]);
                    context.level = i + 1;
                    ebaycategory[i + 1] = context;
                    i++;
                } while (true);
            }
        }
        return (new EbayCategory[] {
            context, ebaycategory
        });
    }

    public static String createFragmentTag(int i)
    {
        return (new StringBuilder()).append("Level").append(Integer.toString(i)).toString();
    }

    public String getCategoryLabel()
    {
        return categoryName;
    }

    public void onCategoriesChanged(CategoryServiceDataManager categoryservicedatamanager, long l, Content content)
    {
        categoryservicedatamanager = getActivity();
        break MISSING_BLOCK_LABEL_5;
        if (categoryservicedatamanager != null && !categoryservicedatamanager.isFinishing() && !categoryservicedatamanager.isDestroyed() && l == categoryId && content != null)
        {
            categoryservicedatamanager = content.getStatus();
            content = (EbayCategoryNode)content.getData();
            if (categoryservicedatamanager.hasError())
            {
                EbayErrorHandler.handleResultStatus(this, 0, categoryservicedatamanager);
                return;
            }
            if (content != null && ((EbayCategoryNode) (content)).children.length > 0 && adapter != null)
            {
                adapter.setChildCategories(((EbayCategoryNode) (content)).children);
                return;
            }
        }
        return;
    }

    public void onCategoriesLoading(CategoryServiceDataManager categoryservicedatamanager, long l)
    {
        for (categoryservicedatamanager = getActivity(); categoryservicedatamanager == null || categoryservicedatamanager.isFinishing() || categoryservicedatamanager.isDestroyed() || adapter == null || l != categoryId;)
        {
            return;
        }

        adapter.setLoading(true);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        Bundle bundle1 = getArguments();
        android.os.Parcelable aparcelable[] = null;
        if (bundle != null)
        {
            categoryId = bundle.getLong("categoryId", -1L);
            categoryName = bundle.getString("categoryName", getString(0x7f07053e));
            categoryLevel = bundle.getInt("categoryLevel", -1);
            aparcelable = bundle.getParcelableArray("navigationIdPath");
            categorySite = (EbaySite)bundle.getParcelable("categorySite");
            bundle = aparcelable;
        } else
        if (bundle1 != null)
        {
            categoryId = bundle1.getLong("categoryId", -1L);
            categoryName = bundle1.getString("categoryName", getString(0x7f07053e));
            categoryLevel = bundle1.getInt("categoryLevel", -1);
            categoryImageUrl = bundle1.getString("categoryImageUrl");
            categorySite = (EbaySite)bundle1.getParcelable("categorySite");
            bundle = bundle1.getParcelableArray("navigationIdPath");
        } else
        {
            categoryId = -1L;
            categoryName = getString(0x7f07053e);
            categoryLevel = -1;
            categorySite = null;
            navigationBreadcrumbs = new EbayCategory[0];
            bundle = aparcelable;
        }
        if (bundle != null)
        {
            navigationBreadcrumbs = new EbayCategory[bundle.length];
            for (int i = 0; i < navigationBreadcrumbs.length; i++)
            {
                navigationBreadcrumbs[i] = (EbayCategory)bundle[i];
            }

        }
        isTablet = getResources().getBoolean(0x7f0b0006);
        initDataManagers();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030023, viewgroup, false);
        viewgroup = layoutinflater.findViewById(0x7f1000c1);
        if (viewgroup == null) goto _L2; else goto _L1
_L1:
        if (!TextUtils.isEmpty(categoryImageUrl)) goto _L4; else goto _L3
_L3:
        viewgroup.setVisibility(8);
_L2:
        viewgroup = (TextView)layoutinflater.findViewById(0x7f1000c3);
        if (viewgroup != null)
        {
            viewgroup.setText(categoryName);
        }
        adapter = new CategoryLineItemAdapter(getActivity());
        adapter.setOnClickListener(new NavigationOnClickListener(this), new int[] {
            0, 1
        });
        adapter.setOnClickListener(new LeafNodeOnClickListener(this), new int[] {
            3
        });
        adapter.setOnClickListener(new BranchNodeOnClickListener(this), new int[] {
            4
        });
        if (navigationBreadcrumbs != null)
        {
            adapter.setBreadcrumbs(navigationBreadcrumbs);
        }
        categoryList = (RecyclerView)layoutinflater.findViewById(0x7f1000c4);
        categoryList.setLayoutManager(new LinearLayoutManager(getActivity()));
        categoryList.addItemDecoration(new DividerItemDecoration(getActivity()));
        categoryList.setAdapter(adapter);
        return layoutinflater;
_L4:
        viewgroup.setVisibility(0);
        categoryImageView = (RemoteImageView)layoutinflater.findViewById(0x7f1000c2);
        if (categoryImageView != null)
        {
            if (android.os.Build.VERSION.SDK_INT >= 21)
            {
                categoryImageView.setTransitionName((new StringBuilder()).append("categoryImage-").append(Long.toString(categoryId)).toString());
            }
            categoryImageView.setRemoteImageUrl(categoryImageUrl);
            categoryImageView.setColorFilter(getResources().getColor(0x7f0d001a));
            categoryImageView.setOnClickListener(new android.view.View.OnClickListener() {

                final BrowseCategoriesFragment this$0;

                public void onClick(View view)
                {
                    getFragmentManager().popBackStack();
                }

            
            {
                this$0 = BrowseCategoriesFragment.this;
                super();
            }
            });
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    public void onDestroyView()
    {
        categoryList = null;
        adapter = null;
        categoryImageView = null;
        super.onDestroyView();
    }

    protected void onInitializeDataManagers(DataManagerContainer datamanagercontainer)
    {
        super.onInitializeDataManagers(datamanagercontainer);
        DeviceConfiguration deviceconfiguration = DeviceConfiguration.getAsync();
        EbaySite ebaysite;
        int i;
        if (categorySite != null)
        {
            ebaysite = categorySite;
        } else
        {
            ebaysite = MyApp.getPrefs().getCurrentCountry().site;
        }
        if (deviceconfiguration.get(com.ebay.nautilus.domain.dcs.DcsDomain.Verticals.B.categoryServiceLimitByLevel))
        {
            i = categoryLevel;
        } else
        {
            i = -1;
        }
        datamanagercontainer = (CategoryServiceDataManager)datamanagercontainer.initialize(new com.ebay.nautilus.domain.content.dm.CategoryServiceDataManager.KeyParams(ebaysite), this);
        if (categoryId != -1L)
        {
            datamanagercontainer.loadData(categoryId, i, this);
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putLong("categoryId", categoryId);
        bundle.putString("categoryName", categoryName);
        bundle.putInt("categoryLevel", categoryLevel);
        bundle.putParcelable("categorySite", categorySite);
        bundle.putString("categoryImageUrl", categoryImageUrl);
        bundle.putParcelableArray("navigationIdPath", navigationBreadcrumbs);
    }

    protected void startSearch(EbayCategory ebaycategory)
    {
        SearchParameters searchparameters = eBayDictionaryProvider.getLockedSearchParameters(getActivity(), null);
        searchparameters.category = new EbayCategorySummary(ebaycategory.id, ebaycategory.name);
        ebaycategory = ActivityStarter.getSearchResultListIntent(getActivity(), searchparameters, "browse_categories");
        ebaycategory.putExtra("com.ebay.mobile.analytics.sid", new SourceIdentification("HomePage", "browsecat", "AllCategories"));
        getActivity().startActivity(ebaycategory);
    }






}
