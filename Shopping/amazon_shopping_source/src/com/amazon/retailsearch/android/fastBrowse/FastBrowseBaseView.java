// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.fastBrowse;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.v4.widget.DrawerLayout;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListView;
import com.amazon.retailsearch.android.ui.refinements.SpinnerHiderRelativeLayout;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import com.amazon.retailsearch.j2me.client.util.RetailSearchAndroidPlatform;
import com.amazon.retailsearch.log.AppLog;
import com.amazon.retailsearch.log.MessageLogger;
import com.amazon.searchapp.retailsearch.model.Department;
import com.amazon.searchapp.retailsearch.model.RefinementLink;
import com.amazon.searchapp.retailsearch.model.Refinements;
import com.amazon.searchapp.retailsearch.model.SearchResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.retailsearch.android.fastBrowse:
//            FastBrowseListAdapter, FastBrowseItem, SlideMenuClickListener, RefinementsLoader

public class FastBrowseBaseView extends FrameLayout
{
    public static interface OnBackUrlListener
    {

        public abstract void onBlockGno();

        public abstract void onCloseGno();

        public abstract void onReturn(String s);

        public abstract void onReturnAIV();

        public abstract void onReturnAPP();

        public abstract void onUnblockGno();
    }


    private static final int BASE_LAYER = 0;
    private static final String BASE_PATH = "/s/browse/categories";
    private static final int DRAWER_GRAVITY = 5;
    private static final String S_PREFIX = "/s/b";
    private static final MessageLogger log = AppLog.getLog(com/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView);
    private FastBrowseListAdapter adapter;
    private final String allDepartments;
    private String browseUrl;
    private DrawerLayout drawerLayout;
    private ArrayList fastBrowseItems;
    private ListView fastBrowseList;
    private View iconLeft;
    private View iconRight;
    private SlideMenuClickListener listener;
    private TypedArray navMenuIcons;
    RetailSearchAndroidPlatform platform;
    private ViewGroup rootView;
    private SearchResult rst;
    private final String shopByDepartments;
    private SpinnerHiderRelativeLayout spinnerList;
    private OnBackUrlListener urlListener;

    public FastBrowseBaseView(Context context)
    {
        super(context);
        browseUrl = null;
        allDepartments = getResources().getString(com.amazon.retailsearch.R.string.rs_search_all_departments);
        shopByDepartments = getResources().getString(com.amazon.retailsearch.R.string.rs_shop_by_department_text);
        init();
    }

    public FastBrowseBaseView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        browseUrl = null;
        allDepartments = getResources().getString(com.amazon.retailsearch.R.string.rs_search_all_departments);
        shopByDepartments = getResources().getString(com.amazon.retailsearch.R.string.rs_shop_by_department_text);
        init();
    }

    private void init()
    {
        RetailSearchDaggerGraphController.inject(this);
        rootView = (ViewGroup)inflate(getContext(), com.amazon.retailsearch.R.layout.rs_right_sliding_menu, this);
        drawerLayout = (DrawerLayout)rootView.findViewById(com.amazon.retailsearch.R.id.right_drawer_layout);
        drawerLayout.setDrawerLockMode(1, 5);
        fastBrowseList = (ListView)rootView.findViewById(com.amazon.retailsearch.R.id.right_drawer_list);
        iconRight = rootView.findViewById(com.amazon.retailsearch.R.id.right_drawer_icon_in);
        iconLeft = rootView.findViewById(com.amazon.retailsearch.R.id.right_drawer_icon_out);
        spinnerList = (SpinnerHiderRelativeLayout)rootView.findViewById(com.amazon.retailsearch.R.id.refinements_menu_list_spinner);
        onCreateListView();
    }

    public void backOne(String s)
    {
label0:
        {
            synchronized (fastBrowseItems)
            {
                if (s.contains("/s/b") || adapter.getCurrentLayer() != 1)
                {
                    break label0;
                }
                updateListView(((FastBrowseItem)fastBrowseItems.get(adapter.getCurrentLayer())).getBrowseUrl());
                urlListener.onReturn(((FastBrowseItem)fastBrowseItems.get(adapter.getCurrentLayer())).getBrowseUrl());
            }
            return;
        }
        if (adapter.getCurrentLayer() != 0)
        {
            break MISSING_BLOCK_LABEL_101;
        }
        arraylist;
        JVM INSTR monitorexit ;
        return;
        s;
        arraylist;
        JVM INSTR monitorexit ;
        throw s;
        if (urlListener == null) goto _L2; else goto _L1
_L1:
        if (adapter.getCurrentLayer() != 1)
        {
            break MISSING_BLOCK_LABEL_158;
        }
        updateListView(null);
_L4:
        urlListener.onReturn(((FastBrowseItem)fastBrowseItems.get(adapter.getCurrentLayer() - 1)).getBrowseUrl());
_L2:
        arraylist;
        JVM INSTR monitorexit ;
        return;
        updateListView(((FastBrowseItem)fastBrowseItems.get(adapter.getCurrentLayer() - 1)).getBrowseUrl());
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void config()
    {
        drawerLayout.setDrawerShadow(com.amazon.retailsearch.R.drawable.drawer_shadow, 5);
        iconRight.setVisibility(0);
        setIconListner();
    }

    public void fetchAfterInit()
        throws InterruptedException
    {
        (new Thread(new Runnable() {

            final FastBrowseBaseView this$0;

            public void run()
            {
                (new RefinementsLoader(new RefinementsLoader.RefinementResultListener() {

                    final _cls4 this$1;

                    public void onError(Exception exception)
                    {
                    }

                    public void onResult(SearchResult searchresult)
                    {
                        rst = searchresult;
                        searchresult = rst.getRefinements().getDepartments().getCategories();
                        Object obj = rst.getRefinements().getDepartments().getAncestry();
                        fastBrowseItems.clear();
                        fastBrowseItems.add(new FastBrowseItem(allDepartments, "/s/browse/categories", "/s/browse/categories", navMenuIcons.getResourceId(0, -1)));
                        if (obj != null)
                        {
                            RefinementLink refinementlink1;
                            for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); fastBrowseItems.add(new FastBrowseItem(refinementlink1.getText(), refinementlink1.getUrl(), refinementlink1.getBrowseUrl(), navMenuIcons.getResourceId(0, -1))))
                            {
                                refinementlink1 = (RefinementLink)((Iterator) (obj)).next();
                            }

                        }
                        adapter.setCurrentLayer(fastBrowseItems.size() - 1);
                        if (adapter.getCurrentLayer() == 0)
                        {
                            ((FastBrowseItem)fastBrowseItems.get(0)).setTitle(shopByDepartments);
                        }
                        if (searchresult != null)
                        {
                            RefinementLink refinementlink;
                            for (searchresult = searchresult.iterator(); searchresult.hasNext(); fastBrowseItems.add(new FastBrowseItem(refinementlink.getText(), refinementlink.getUrl(), refinementlink.getBrowseUrl(), navMenuIcons.getResourceId(0, -1))))
                            {
                                refinementlink = (RefinementLink)searchresult.next();
                            }

                        }
                        navMenuIcons.recycle();
                        onRefreshAfterInit();
                    }

            
            {
                this$1 = _cls4.this;
                super();
            }
                }, browseUrl)).getRefinements();
            }

            
            {
                this$0 = FastBrowseBaseView.this;
                super();
            }
        })).start();
    }

    public void fetchRefinements()
        throws InterruptedException
    {
        (new Thread(new Runnable() {

            final FastBrowseBaseView this$0;

            public void run()
            {
                (new RefinementsLoader(new RefinementsLoader.RefinementResultListener() {

                    final _cls3 this$1;

                    public void onError(Exception exception)
                    {
                    }

                    public void onResult(SearchResult searchresult)
                    {
                        rst = searchresult;
                        onRefresh();
                    }

            
            {
                this$1 = _cls3.this;
                super();
            }
                }, null)).getRefinements();
            }

            
            {
                this$0 = FastBrowseBaseView.this;
                super();
            }
        })).start();
    }

    public boolean isListRoot()
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (adapter != null)
        {
            flag = flag1;
            if (adapter.getCurrentLayer() == 0)
            {
                flag = true;
            }
        }
        return flag;
    }

    public boolean isRightMenuLock()
    {
        return drawerLayout.getDrawerLockMode(5) == 2;
    }

    public boolean isRightMenuOpen()
    {
        return drawerLayout.isDrawerOpen(5);
    }

    public boolean isRightMenuUnLock()
    {
        return drawerLayout.getDrawerLockMode(5) == 0;
    }

    public void load()
    {
        try
        {
            fetchRefinements();
            return;
        }
        catch (InterruptedException interruptedexception)
        {
            log.error("Could not fetch refinements", interruptedexception);
        }
    }

    public void onCreateListView()
    {
        Context context = getContext();
        navMenuIcons = getResources().obtainTypedArray(com.amazon.retailsearch.R.array.nav_drawer_icons);
        fastBrowseItems = new ArrayList();
        fastBrowseItems.add(new FastBrowseItem(shopByDepartments, "/s/browse/categories", "/s/browse/categories", navMenuIcons.getResourceId(0, -1)));
        adapter = new FastBrowseListAdapter(context, fastBrowseItems, 0);
        fastBrowseList.setAdapter(adapter);
        listener = new SlideMenuClickListener(context, iconRight, drawerLayout, fastBrowseItems, adapter, rst, spinnerList, fastBrowseList, new SlideMenuClickListener.OnReturnListener() {

            final FastBrowseBaseView this$0;

            public void onReturn(String s)
            {
                if (urlListener != null)
                {
                    urlListener.onReturn(s);
                }
            }

            public void onReturnAIV()
            {
                if (urlListener != null)
                {
                    urlListener.onReturnAIV();
                }
            }

            public void onReturnAPP()
            {
                if (urlListener != null)
                {
                    urlListener.onReturnAPP();
                }
            }

            
            {
                this$0 = FastBrowseBaseView.this;
                super();
            }
        });
        fastBrowseList.setOnItemClickListener(listener);
        drawerLayout.setDrawerListener(new android.support.v4.widget.DrawerLayout.DrawerListener() {

            final FastBrowseBaseView this$0;

            public void onDrawerClosed(View view)
            {
                if (urlListener != null)
                {
                    urlListener.onUnblockGno();
                }
            }

            public void onDrawerOpened(View view)
            {
                if (urlListener != null)
                {
                    urlListener.onBlockGno();
                }
            }

            public void onDrawerSlide(View view, float f)
            {
                iconLeft.setVisibility(8);
            }

            public void onDrawerStateChanged(int i)
            {
                if (i == 0 && !drawerLayout.isDrawerVisible(5))
                {
                    iconLeft.setVisibility(0);
                }
            }

            
            {
                this$0 = FastBrowseBaseView.this;
                super();
            }
        });
    }

    protected void onRefresh()
    {
        platform.invokeLater(new Runnable() {

            final FastBrowseBaseView this$0;

            public void run()
            {
                RefinementLink refinementlink;
                for (Iterator iterator = rst.getRefinements().getDepartments().getCategories().iterator(); iterator.hasNext(); fastBrowseItems.add(new FastBrowseItem(refinementlink.getText(), refinementlink.getUrl(), refinementlink.getBrowseUrl(), navMenuIcons.getResourceId(0, -1))))
                {
                    refinementlink = (RefinementLink)iterator.next();
                }

                navMenuIcons.recycle();
                adapter.notifyDataSetChanged();
                drawerLayout.setDrawerShadow(com.amazon.retailsearch.R.drawable.drawer_shadow, 5);
                setIconListner();
                iconRight.setVisibility(8);
                drawerLayout.setDrawerLockMode(0, 5);
                spinnerList.hide();
                drawerLayout.openDrawer(5);
                drawerLayout.setDrawerLockMode(2, 5);
                if (urlListener != null)
                {
                    urlListener.onCloseGno();
                }
            }

            
            {
                this$0 = FastBrowseBaseView.this;
                super();
            }
        });
    }

    protected void onRefreshAfterInit()
    {
        platform.invokeLater(new Runnable() {

            final FastBrowseBaseView this$0;

            public void run()
            {
                adapter.notifyDataSetChanged();
                fastBrowseList.setSelectionAfterHeaderView();
                spinnerList.hide();
                if (browseUrl == null)
                {
                    iconRight.setVisibility(8);
                    drawerLayout.openDrawer(5);
                    drawerLayout.setDrawerLockMode(2, 5);
                    return;
                } else
                {
                    drawerLayout.setDrawerLockMode(0, 5);
                    return;
                }
            }

            
            {
                this$0 = FastBrowseBaseView.this;
                super();
            }
        });
    }

    public void openAndLockRightMenu()
    {
        drawerLayout.openDrawer(5);
        drawerLayout.setDrawerLockMode(2, 5);
    }

    public void setIconListner()
    {
        iconLeft.setOnClickListener(new android.view.View.OnClickListener() {

            final FastBrowseBaseView this$0;

            public void onClick(View view)
            {
                if (isRightMenuUnLock())
                {
                    drawerLayout.openDrawer(5);
                }
            }

            
            {
                this$0 = FastBrowseBaseView.this;
                super();
            }
        });
        iconRight.setOnClickListener(new android.view.View.OnClickListener() {

            final FastBrowseBaseView this$0;

            public void onClick(View view)
            {
                if (isRightMenuUnLock())
                {
                    drawerLayout.closeDrawer(5);
                }
            }

            
            {
                this$0 = FastBrowseBaseView.this;
                super();
            }
        });
    }

    public void unlockAndCloseRightMenu()
    {
        drawerLayout.setDrawerLockMode(0, 5);
        drawerLayout.closeDrawer(5);
    }

    public void updateListView(String s)
    {
        try
        {
            spinnerList.show();
            browseUrl = s;
            fetchAfterInit();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            log.error("Failed to update list view", s);
        }
    }

    public void useListener(OnBackUrlListener onbackurllistener)
    {
        urlListener = onbackurllistener;
    }

    public void useView(View view)
    {
        if (view != null)
        {
            ((ViewGroup)rootView.findViewById(com.amazon.retailsearch.R.id.web_content_frame)).addView(view);
        }
    }










/*
    static SearchResult access$302(FastBrowseBaseView fastbrowsebaseview, SearchResult searchresult)
    {
        fastbrowsebaseview.rst = searchresult;
        return searchresult;
    }

*/






}
