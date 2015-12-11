// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.categorybrowser;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;
import com.ebay.common.Preferences;
import com.ebay.common.view.EbayErrorHandler;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.activities.BaseFragment;
import com.ebay.mobile.common.view.RecyclerContentAdapter;
import com.ebay.mobile.common.view.ViewModel;
import com.ebay.mobile.home.cards.DepartmentTitleViewHolder;
import com.ebay.mobile.home.channels.ChannelDispatcher;
import com.ebay.mobile.home.channels.ChannelFragment;
import com.ebay.mobile.home.channels.ChannelObserver;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.dm.CategoryServiceDataManager;
import com.ebay.nautilus.domain.content.dm.ImageDataManager;
import com.ebay.nautilus.domain.data.EbayCategory;
import com.ebay.nautilus.domain.data.EbayCategoryNode;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.shell.app.DataManagerContainer;
import java.lang.ref.WeakReference;

// Referenced classes of package com.ebay.mobile.categorybrowser:
//            TopLevelCategoriesAdapter, BrowseCategoriesFragment, CategoryViewModel

public final class BrowseCategoriesTileFragment extends BaseFragment
    implements android.app.FragmentManager.OnBackStackChangedListener, com.ebay.mobile.common.view.ViewModel.OnClickListener, ChannelFragment, com.ebay.nautilus.domain.content.dm.CategoryServiceDataManager.Observer, com.ebay.nautilus.domain.content.dm.ImageDataManager.Observer
{
    public static class TileScrollListener extends android.support.v7.widget.RecyclerView.OnScrollListener
    {

        private final WeakReference fragmentReference;

        public void onScrollStateChanged(RecyclerView recyclerview, int i)
        {
            BrowseCategoriesTileFragment browsecategoriestilefragment = (BrowseCategoriesTileFragment)fragmentReference.get();
            if (browsecategoriestilefragment != null && !browsecategoriestilefragment.isRemoving())
            {
                switch (i)
                {
                default:
                    return;

                case 0: // '\0'
                    break;
                }
                if (browsecategoriestilefragment.isTablet && browsecategoriestilefragment.isCategorySelected() && (recyclerview.getLayoutManager() instanceof LinearLayoutManager))
                {
                    recyclerview = (LinearLayoutManager)recyclerview.getLayoutManager();
                    i = recyclerview.findFirstCompletelyVisibleItemPosition();
                    if (i != -1)
                    {
                        recyclerview = ((RecyclerView) (recyclerview.findViewByPosition(i).getTag(0x7f100010)));
                        if (recyclerview instanceof EbayCategory)
                        {
                            recyclerview = (EbayCategory)recyclerview;
                            if (((EbayCategory) (recyclerview)).id != browsecategoriestilefragment.selectedCategoryId)
                            {
                                browsecategoriestilefragment.setSelectedCategory(recyclerview);
                                return;
                            }
                        }
                    }
                }
            }
        }

        public void onScrolled(RecyclerView recyclerview, int i, int j)
        {
            for (recyclerview = (BrowseCategoriesTileFragment)fragmentReference.get(); recyclerview == null || recyclerview.isRemoving() || ((BrowseCategoriesTileFragment) (recyclerview)).channelFragmentDispatcher == null;)
            {
                return;
            }

            ChannelDispatcher channeldispatcher = ((BrowseCategoriesTileFragment) (recyclerview)).channelFragmentDispatcher;
            if (recyclerview.hasScrollOffset() || ((BrowseCategoriesTileFragment) (recyclerview)).isTablet && recyclerview.isCategorySelected())
            {
                i = 1;
            } else
            {
                i = 0;
            }
            channeldispatcher.onScrollChanged(recyclerview, 0, i);
        }

        public TileScrollListener(BrowseCategoriesTileFragment browsecategoriestilefragment)
        {
            fragmentReference = new WeakReference(browsecategoriestilefragment);
        }
    }

    public static final class UpdateGridWidthAfterLayoutListener
        implements android.view.ViewTreeObserver.OnGlobalLayoutListener
    {

        private final WeakReference fragmentReference;
        private final int newGridWidth;
        private final WeakReference viewReference;

        public void onGlobalLayout()
        {
            BrowseCategoriesTileFragment browsecategoriestilefragment = (BrowseCategoriesTileFragment)fragmentReference.get();
            View view;
            for (view = (View)viewReference.get(); browsecategoriestilefragment == null || view == null || view.getWidth() <= 0;)
            {
                return;
            }

            view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            browsecategoriestilefragment.setColumnSpan(newGridWidth);
        }

        public UpdateGridWidthAfterLayoutListener(BrowseCategoriesTileFragment browsecategoriestilefragment, View view, int i)
        {
            fragmentReference = new WeakReference(browsecategoriestilefragment);
            viewReference = new WeakReference(view);
            newGridWidth = i;
        }
    }


    public static final String EXTRA_HEADER_BACKGROUND_URL = "backgroundUrl";
    public static final String EXTRA_HEADER_TITLE = "title";
    public static final String EXTRA_SELECTED_CATEGORY_ID = "selectedCategoryId";
    public static final long NO_SELECTION = -1L;
    private TopLevelCategoriesAdapter adapter;
    private ImageView backgroundImageView;
    private com.ebay.nautilus.domain.content.dm.ImageDataManager.LoadToken backgroundLoadToken;
    private String backgroundUrl;
    protected View browseFragmentContainer;
    protected ChannelDispatcher channelFragmentDispatcher;
    private CategoryServiceDataManager dataManager;
    protected boolean isTablet;
    private View progressBar;
    private RecyclerView recyclerView;
    protected long requestedCategoryId;
    protected long selectedCategoryId;
    private String title;

    public BrowseCategoriesTileFragment()
    {
        selectedCategoryId = -1L;
        requestedCategoryId = -1L;
        channelFragmentDispatcher = new ChannelDispatcher();
    }

    private void scrollRecyclerToPosition(int i)
    {
        if (i > -1 && recyclerView != null && (recyclerView.getLayoutManager() instanceof GridLayoutManager))
        {
            ((GridLayoutManager)recyclerView.getLayoutManager()).scrollToPositionWithOffset(i, 0);
        }
    }

    private void smoothScrollRecyclerToPosition(int i)
    {
        if (i > -1 && recyclerView != null && recyclerView.getLayoutManager() != null)
        {
            recyclerView.getLayoutManager().smoothScrollToPosition(recyclerView, new android.support.v7.widget.RecyclerView.State(), i);
        }
    }

    public void clearSelectedCategory()
    {
        if (!isCategorySelected())
        {
            return;
        }
        selectedCategoryId = -1L;
        if (isTablet)
        {
            browseFragmentContainer.animate().translationX(recyclerView.getWidth() / 2).setDuration(recyclerView.getItemAnimator().getMoveDuration()).setStartDelay(0L).withEndAction(new Runnable() {

                final BrowseCategoriesTileFragment this$0;

                public void run()
                {
                    browseFragmentContainer.setVisibility(8);
                    FragmentManager fragmentmanager1 = getFragmentManager();
                    if (fragmentmanager1 != null && !fragmentmanager1.isDestroyed())
                    {
                        fragmentmanager1.popBackStackImmediate(BrowseCategoriesFragment.createFragmentTag(1), 1);
                    }
                }

            
            {
                this$0 = BrowseCategoriesTileFragment.this;
                super();
            }
            }).start();
            setColumnSpan(adapter.getNumSpans());
            adapter.showTitle(true);
        } else
        {
            FragmentManager fragmentmanager = getFragmentManager();
            if (fragmentmanager != null && !fragmentmanager.isDestroyed())
            {
                fragmentmanager.popBackStackImmediate(BrowseCategoriesFragment.createFragmentTag(1), 1);
            }
            browseFragmentContainer.setVisibility(8);
        }
        scrollRecyclerToPosition(adapter.findAdapterPositionByEbayCategoryId(selectedCategoryId));
    }

    public String getDepartmentId()
    {
        return "ALLCATEGORIES";
    }

    public int getPositionInParent()
    {
        Fragment fragment = getParentFragment();
        if (fragment instanceof ChannelFragment)
        {
            return ((ChannelFragment)fragment).getPositionInParent();
        } else
        {
            return -2;
        }
    }

    public boolean hasCarousel()
    {
        return true;
    }

    public boolean hasScrollOffset()
    {
        boolean flag1 = false;
        if (getFragmentManager().getBackStackEntryCount() <= 0) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        flag = flag1;
        if (recyclerView == null) goto _L4; else goto _L3
_L3:
        android.support.v7.widget.RecyclerView.LayoutManager layoutmanager;
        layoutmanager = recyclerView.getLayoutManager();
        flag = flag1;
        if (layoutmanager == null) goto _L4; else goto _L5
_L5:
        flag = flag1;
        if (!(layoutmanager instanceof LinearLayoutManager)) goto _L4; else goto _L6
_L6:
        int i;
        i = ((LinearLayoutManager)layoutmanager).findFirstCompletelyVisibleItemPosition();
        if (i > 0)
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (i != -1) goto _L4; else goto _L7
_L7:
        return true;
    }

    public boolean hasSubChannels()
    {
        return false;
    }

    protected boolean isCategorySelected()
    {
        return selectedCategoryId > -1L;
    }

    public void navigateTo(long l)
    {
label0:
        {
            requestedCategoryId = l;
            if (dataManager != null)
            {
                if (l != 6000L || dataManager.getParams().ebaySite != EbaySite.US)
                {
                    break label0;
                }
                EbayCategory ebaycategory = new EbayCategory(6000L, "eBay Motors");
                ebaycategory.level = 1;
                setSelectedCategory(ebaycategory);
            }
            return;
        }
        dataManager.getPathToCategory(requestedCategoryId, this);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        if (activity instanceof ChannelObserver)
        {
            channelFragmentDispatcher.register((ChannelObserver)activity);
        }
    }

    public void onBackStackChanged()
    {
        FragmentManager fragmentmanager = getFragmentManager();
        if (fragmentmanager != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int i;
        i = fragmentmanager.getBackStackEntryCount();
        if (!isTablet)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (i != 0 || recyclerView == null || !(recyclerView.getLayoutManager() instanceof GridLayoutManager)) goto _L1; else goto _L3
_L3:
        clearSelectedCategory();
        return;
        if (i != 0) goto _L1; else goto _L4
_L4:
        ChannelDispatcher channeldispatcher = channelFragmentDispatcher;
        float f;
        if (hasScrollOffset())
        {
            f = 1.0F;
        } else
        {
            f = 0.0F;
        }
        channeldispatcher.onCategoryExpansion(this, f);
        return;
    }

    public void onCategoriesChanged(CategoryServiceDataManager categoryservicedatamanager, long l, Content content)
    {
        categoryservicedatamanager = getActivity();
        break MISSING_BLOCK_LABEL_5;
        if (categoryservicedatamanager != null && !categoryservicedatamanager.isFinishing() && !categoryservicedatamanager.isDestroyed() && (l == requestedCategoryId || l == -1L))
        {
            progressBar.setVisibility(8);
            if (content != null)
            {
                categoryservicedatamanager = content.getStatus();
                content = (EbayCategoryNode)content.getData();
                if (categoryservicedatamanager.hasError())
                {
                    EbayErrorHandler.handleResultStatus(this, 0, categoryservicedatamanager);
                    return;
                }
                if (content != null && recyclerView != null && adapter != null)
                {
                    recyclerView.setVisibility(0);
                    if (l == -1L)
                    {
                        adapter.setCategories(((EbayCategoryNode) (content)).children);
                        return;
                    } else
                    {
                        requestedCategoryId = -1L;
                        setSelectedCategory(((EbayCategoryNode) (content)).category);
                        return;
                    }
                }
            }
        }
        return;
    }

    public void onCategoriesLoading(CategoryServiceDataManager categoryservicedatamanager, long l)
    {
        for (categoryservicedatamanager = getActivity(); categoryservicedatamanager == null || categoryservicedatamanager.isFinishing() || categoryservicedatamanager.isDestroyed() || l != -1L;)
        {
            return;
        }

        progressBar.setVisibility(0);
    }

    public void onClick(View view, ViewModel viewmodel)
    {
        if (!(viewmodel instanceof CategoryViewModel))
        {
            return;
        } else
        {
            view = ((CategoryViewModel)viewmodel).category;
            clearSelectedCategory();
            setSelectedCategory(view);
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (bundle != null)
        {
            backgroundUrl = bundle.getString("backgroundUrl");
            title = bundle.getString("title");
            selectedCategoryId = bundle.getLong("selectedCategoryId", -1L);
        } else
        if (getArguments() != null)
        {
            bundle = getArguments();
            backgroundUrl = bundle.getString("backgroundUrl");
            title = bundle.getString("title");
            selectedCategoryId = bundle.getLong("selectedCategoryId", -1L);
        } else
        {
            title = getString(0x7f07053e);
            selectedCategoryId = -1L;
        }
        isTablet = getResources().getBoolean(0x7f0b0006);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f03002c, viewgroup, false);
        progressBar = layoutinflater.findViewById(0x7f1000ca);
        browseFragmentContainer = layoutinflater.findViewById(0x7f1000bf);
        adapter = new TopLevelCategoriesAdapter(getActivity(), title);
        adapter.setOnClickListener(this, new int[] {
            1
        });
        viewgroup = adapter;
        boolean flag;
        if (!isTablet || !isCategorySelected())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        viewgroup.showTitle(flag);
        recyclerView = (RecyclerView)layoutinflater.findViewById(0x7f1000c8);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(adapter.createLayoutManager());
        recyclerView.addOnScrollListener(new TileScrollListener(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setClipToPadding(false);
        recyclerView.offsetChildrenVertical(getResources().getDimensionPixelSize(0x7f090141));
        if (isTablet)
        {
            layoutinflater.findViewById(0x7f1000c9).setVisibility(0);
            if (isCategorySelected())
            {
                recyclerView.getViewTreeObserver().addOnGlobalLayoutListener(new UpdateGridWidthAfterLayoutListener(this, recyclerView, 1));
                recyclerView.requestLayout();
            }
        }
        backgroundImageView = (ImageView)layoutinflater.findViewById(0x7f1000c7);
        backgroundImageView.setTranslationY(-getResources().getDimensionPixelSize(0x7f090138));
        viewgroup = getFragmentManager();
        if (viewgroup != null)
        {
            viewgroup.addOnBackStackChangedListener(this);
        }
        return layoutinflater;
    }

    public void onDestroyView()
    {
        FragmentManager fragmentmanager = getFragmentManager();
        if (fragmentmanager != null)
        {
            fragmentmanager.removeOnBackStackChangedListener(this);
        }
        dataManager = null;
        if (recyclerView != null)
        {
            recyclerView.clearOnScrollListeners();
            recyclerView = null;
        }
        progressBar = null;
        browseFragmentContainer = null;
        adapter = null;
        backgroundImageView = null;
        super.onDestroyView();
    }

    public void onDetach()
    {
        Activity activity = getActivity();
        if (activity != null && (activity instanceof ChannelObserver))
        {
            channelFragmentDispatcher.unregister((ChannelObserver)activity);
        }
        super.onDetach();
    }

    protected void onInitializeDataManagers(DataManagerContainer datamanagercontainer)
    {
        super.onInitializeDataManagers(datamanagercontainer);
        dataManager = (CategoryServiceDataManager)datamanagercontainer.initialize(new com.ebay.nautilus.domain.content.dm.CategoryServiceDataManager.KeyParams(MyApp.getPrefs().getCurrentCountry().site), this);
        if (!TextUtils.isEmpty(backgroundUrl))
        {
            backgroundLoadToken = ((ImageDataManager)datamanagercontainer.initialize(ImageDataManager.KEY, this)).loadImage(this, backgroundUrl);
        }
    }

    public void onLoadImageComplete(ImageDataManager imagedatamanager, Content content)
    {
        imagedatamanager = getActivity();
        break MISSING_BLOCK_LABEL_5;
        if (imagedatamanager != null && !imagedatamanager.isFinishing() && !imagedatamanager.isDestroyed() && content != null)
        {
            imagedatamanager = content.getStatus();
            content = (com.ebay.nautilus.domain.content.dm.ImageDataManager.ImageInfo)content.getData();
            if (!imagedatamanager.hasError() && content != null && backgroundImageView != null && backgroundLoadToken != null && backgroundLoadToken.equals(((com.ebay.nautilus.domain.content.dm.ImageDataManager.ImageInfo) (content)).loadToken))
            {
                backgroundImageView.setImageBitmap(((com.ebay.nautilus.domain.content.dm.ImageDataManager.ImageInfo) (content)).image);
                return;
            }
        }
        return;
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putLong("selectedCategoryId", selectedCategoryId);
        bundle.putString("backgroundUrl", backgroundUrl);
        bundle.putString("title", title);
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        if (isCategorySelected())
        {
            browseFragmentContainer.setVisibility(0);
        } else
        {
            browseFragmentContainer.setVisibility(8);
        }
        initDataManagers();
    }

    protected void setColumnSpan(int i)
    {
        if (recyclerView != null && (recyclerView.getLayoutManager() instanceof GridLayoutManager))
        {
            GridLayoutManager gridlayoutmanager = (GridLayoutManager)recyclerView.getLayoutManager();
            if (i > 1)
            {
                recyclerView.setPadding(recyclerView.getPaddingLeft(), recyclerView.getPaddingTop(), 0, recyclerView.getPaddingBottom());
            } else
            {
                recyclerView.setPadding(recyclerView.getPaddingLeft(), recyclerView.getPaddingTop(), recyclerView.getWidth() / 2, recyclerView.getPaddingBottom());
            }
            gridlayoutmanager.setSpanCount(i);
        }
    }

    protected void setSelectedCategory(EbayCategory ebaycategory)
    {
        Object obj1 = getActivity();
        Object obj2;
        if (ebaycategory != null && obj1 != null)
        {
            if ((obj2 = getFragmentManager()) != null)
            {
                if (isCategorySelected() && ebaycategory.id != selectedCategoryId)
                {
                    ((FragmentManager) (obj2)).popBackStackImmediate(BrowseCategoriesFragment.createFragmentTag(1), 1);
                }
                if (!isCategorySelected() || ebaycategory.id != selectedCategoryId)
                {
                    Bundle bundle = new Bundle();
                    bundle.putLong("categoryId", ebaycategory.id);
                    bundle.putString("categoryName", ebaycategory.name);
                    bundle.putInt("categoryLevel", ebaycategory.level);
                    Object obj;
                    if (dataManager.getParams().ebaySite == EbaySite.US && ebaycategory.id == 6000L)
                    {
                        obj = EbaySite.MOTOR;
                    } else
                    {
                        obj = dataManager.getParams().ebaySite;
                    }
                    bundle.putParcelable("categorySite", ((android.os.Parcelable) (obj)));
                    bundle.putString("categoryImageUrl", CategoryViewModel.getCategoryImageUrl(ebaycategory.id));
                    bundle.putParcelableArray("navigationIdPath", BrowseCategoriesFragment.constructNavigationBreadcrumbs(((android.content.Context) (obj1)), ebaycategory));
                    obj = Fragment.instantiate(((android.content.Context) (obj1)), com/ebay/mobile/categorybrowser/BrowseCategoriesFragment.getName(), bundle);
                    obj1 = BrowseCategoriesFragment.createFragmentTag(ebaycategory.level);
                    obj2 = ((FragmentManager) (obj2)).beginTransaction();
                    if (!isTablet)
                    {
                        if (android.os.Build.VERSION.SDK_INT >= 21)
                        {
                            int i = adapter.findAdapterPositionByEbayCategoryId(ebaycategory.id);
                            if (i > -1)
                            {
                                Object obj3 = recyclerView.findViewHolderForAdapterPosition(i);
                                if (obj3 != null && ((android.support.v7.widget.RecyclerView.ViewHolder) (obj3)).itemView != null)
                                {
                                    ImageView imageview = (ImageView)((android.support.v7.widget.RecyclerView.ViewHolder) (obj3)).itemView.findViewById(0x7f1000c2);
                                    obj3 = (TextView)((android.support.v7.widget.RecyclerView.ViewHolder) (obj3)).itemView.findViewById(0x7f1000c3);
                                    Object obj4 = TransitionInflater.from(getActivity());
                                    android.transition.Transition transition = ((TransitionInflater) (obj4)).inflateTransition(0x10f0001);
                                    android.transition.Transition transition1 = ((TransitionInflater) (obj4)).inflateTransition(0x10f0004);
                                    obj4 = ((TransitionInflater) (obj4)).inflateTransition(0x10f0002);
                                    ((Fragment) (obj)).setSharedElementEnterTransition(transition);
                                    ((Fragment) (obj)).setEnterTransition(transition1);
                                    setExitTransition(null);
                                    ((Fragment) (obj)).setSharedElementReturnTransition(transition);
                                    ((Fragment) (obj)).setReturnTransition(((android.transition.Transition) (obj4)));
                                    ((Fragment) (obj)).setExitTransition(transition1);
                                    setReenterTransition(null);
                                    ((FragmentTransaction) (obj2)).addSharedElement(imageview, imageview.getTransitionName());
                                    ((FragmentTransaction) (obj2)).addSharedElement(((View) (obj3)), ((TextView) (obj3)).getTransitionName());
                                }
                            }
                        } else
                        {
                            ((FragmentTransaction) (obj2)).setTransition(4097);
                        }
                    }
                    ((FragmentTransaction) (obj2)).addToBackStack(((String) (obj1)));
                    if (isTablet)
                    {
                        ((FragmentTransaction) (obj2)).replace(0x7f1000bf, ((Fragment) (obj)), ((String) (obj1)));
                    } else
                    {
                        ((FragmentTransaction) (obj2)).replace(0x7f1001c9, ((Fragment) (obj)), ((String) (obj1)));
                    }
                    ((FragmentTransaction) (obj2)).commit();
                }
                if (isTablet)
                {
                    if (isCategorySelected())
                    {
                        smoothScrollRecyclerToPosition(adapter.findAdapterPositionByEbayCategoryId(ebaycategory.id));
                    } else
                    {
                        adapter.showTitle(false);
                        setColumnSpan(1);
                        scrollRecyclerToPosition(adapter.findAdapterPositionByEbayCategoryId(ebaycategory.id));
                        browseFragmentContainer.animate().withStartAction(new Runnable() {

                            final BrowseCategoriesTileFragment this$0;

                            public void run()
                            {
                                browseFragmentContainer.setTranslationX(recyclerView.getWidth() / 2);
                                browseFragmentContainer.setVisibility(0);
                            }

            
            {
                this$0 = BrowseCategoriesTileFragment.this;
                super();
            }
                        }).translationX(0.0F).setStartDelay(recyclerView.getItemAnimator().getChangeDuration()).setDuration(recyclerView.getItemAnimator().getMoveDuration()).start();
                    }
                } else
                {
                    browseFragmentContainer.setVisibility(0);
                }
                selectedCategoryId = ebaycategory.id;
                if (isTablet)
                {
                    ebaycategory = channelFragmentDispatcher;
                    float f;
                    if (isCategorySelected() || hasScrollOffset())
                    {
                        f = 1.0F;
                    } else
                    {
                        f = 0.0F;
                    }
                    ebaycategory.onCategoryExpansion(this, f);
                    return;
                } else
                {
                    channelFragmentDispatcher.onCategoryExpansion(this, 1.0F);
                    return;
                }
            }
        }
    }

    public void setTitleVisibility(boolean flag)
    {
        int i = 0;
        if (recyclerView != null)
        {
            RecyclerContentAdapter recyclercontentadapter = (RecyclerContentAdapter)recyclerView.getAdapter();
            if (recyclercontentadapter != null)
            {
                int j = recyclercontentadapter.getPositionForViewType(0);
                if (j > -1)
                {
                    Object obj = (DepartmentTitleViewHolder)recyclerView.findViewHolderForAdapterPosition(j);
                    if (obj != null && ((DepartmentTitleViewHolder) (obj)).itemView != null)
                    {
                        obj = ((DepartmentTitleViewHolder) (obj)).itemView;
                        if (!flag)
                        {
                            i = 4;
                        }
                        ((View) (obj)).setVisibility(i);
                    }
                }
            }
        }
    }

    public void setUserVisibleHint(boolean flag)
    {
        super.setUserVisibleHint(flag);
        if (flag)
        {
            ChannelDispatcher channeldispatcher = channelFragmentDispatcher;
            float f;
            if (isCategorySelected())
            {
                f = 1.0F;
            } else
            {
                f = 0.0F;
            }
            channeldispatcher.onCategoryExpansion(this, f);
            return;
        }
        if (isCategorySelected())
        {
            clearSelectedCategory();
        }
        scrollRecyclerToPosition(0);
        setTitleVisibility(false);
    }

}
