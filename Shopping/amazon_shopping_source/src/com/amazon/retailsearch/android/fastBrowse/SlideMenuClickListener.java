// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.fastBrowse;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.ListView;
import com.amazon.retailsearch.android.categoryBrowse.CategoryBrowseController;
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
//            FastBrowseItem, FastBrowseListAdapter, RefinementsLoader

public class SlideMenuClickListener
    implements android.widget.AdapterView.OnItemClickListener
{
    public static interface OnReturnListener
    {

        public abstract void onReturn(String s);

        public abstract void onReturnAIV();

        public abstract void onReturnAPP();
    }


    private static final String BASE_PATH = "/s/browse/categories";
    private static final int DRAWER_GRAVITY = 5;
    private static final MessageLogger log = AppLog.getLog(com/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener);
    private FastBrowseListAdapter adapter;
    private String allDepartments;
    private String browseUrl;
    private Context context;
    private DrawerLayout drawerLayout;
    private ArrayList fastBrowseItems;
    private ListView fastBrowseList;
    private View iconRight;
    private final OnReturnListener listener;
    private TypedArray navMenuIcons;
    RetailSearchAndroidPlatform platform;
    private int position;
    private SearchResult rst;
    private String shopByDepartments;
    private SpinnerHiderRelativeLayout spinnerList;

    public SlideMenuClickListener(Context context1, View view, DrawerLayout drawerlayout, ArrayList arraylist, FastBrowseListAdapter fastbrowselistadapter, SearchResult searchresult, SpinnerHiderRelativeLayout spinnerhiderrelativelayout, 
            ListView listview, OnReturnListener onreturnlistener)
    {
        browseUrl = null;
        context = context1;
        fastBrowseItems = arraylist;
        adapter = fastbrowselistadapter;
        drawerLayout = drawerlayout;
        rst = searchresult;
        spinnerList = spinnerhiderrelativelayout;
        listener = onreturnlistener;
        iconRight = view;
        fastBrowseList = listview;
        allDepartments = context1.getResources().getString(com.amazon.retailsearch.R.string.rs_search_all_departments);
        shopByDepartments = context1.getResources().getString(com.amazon.retailsearch.R.string.rs_shop_by_department_text);
        RetailSearchDaggerGraphController.inject(this);
    }

    public void fetchRefinements()
        throws InterruptedException
    {
        (new Thread(new Runnable() {

            final SlideMenuClickListener this$0;

            public void run()
            {
                RefinementsLoader.RefinementResultListener refinementresultlistener = new RefinementsLoader.RefinementResultListener() {

                    final _cls1 this$1;

                    public void onError(Exception exception)
                    {
                    }

                    public void onResult(SearchResult searchresult)
                    {
                        if (searchresult == null || searchresult.getRefinements() == null || searchresult.getRefinements().getDepartments() == null)
                        {
                            navMenuIcons.recycle();
                            onRefresh();
                            return;
                        }
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
                        onRefresh();
                    }

            
            {
                this$1 = _cls1.this;
                super();
            }
                };
                String s;
                if ("/s/browse/categories".equals(browseUrl))
                {
                    s = null;
                } else
                {
                    s = browseUrl;
                }
                (new RefinementsLoader(refinementresultlistener, s)).getRefinements();
            }

            
            {
                this$0 = SlideMenuClickListener.this;
                super();
            }
        })).start();
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        position = i;
        if (i != 0)
        {
            drawerLayout.setDrawerLockMode(0, 5);
            iconRight.setVisibility(8);
        } else
        {
            drawerLayout.setDrawerLockMode(2, 5);
        }
        navMenuIcons = context.getResources().obtainTypedArray(com.amazon.retailsearch.R.array.nav_drawer_icons);
        browseUrl = ((FastBrowseItem)fastBrowseItems.get(i)).getBrowseUrl();
        adapterview = Uri.parse(CategoryBrowseController.buildCategoryBrowseLink(Uri.parse(browseUrl))).getQueryParameter("node");
        if (CategoryBrowseController.shouldLaunchAIVBrowse(adapterview))
        {
            drawerLayout.setDrawerLockMode(2, 5);
            listener.onReturnAIV();
            return;
        }
        if (CategoryBrowseController.shouldLaunchAppStoreBrowse(adapterview))
        {
            drawerLayout.setDrawerLockMode(2, 5);
            listener.onReturnAPP();
            return;
        }
        spinnerList.show();
        listener.onReturn(browseUrl);
        try
        {
            fetchRefinements();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (AdapterView adapterview)
        {
            log.error("Could not fetch refinements", adapterview);
        }
    }

    protected void onRefresh()
    {
        platform.invokeLater(new Runnable() {

            final SlideMenuClickListener this$0;

            public void run()
            {
                adapter.notifyDataSetChanged();
                fastBrowseList.setSelectionAfterHeaderView();
                spinnerList.hide();
                iconRight.setVisibility(8);
                if (position != 0)
                {
                    AlphaAnimation alphaanimation = new AlphaAnimation(0.1F, 1.0F);
                    alphaanimation.setDuration(1500L);
                    iconRight.setAnimation(alphaanimation);
                    iconRight.setVisibility(0);
                    return;
                } else
                {
                    AlphaAnimation alphaanimation1 = new AlphaAnimation(1.0F, 0.1F);
                    alphaanimation1.setDuration(1500L);
                    iconRight.setAnimation(alphaanimation1);
                    iconRight.setVisibility(8);
                    return;
                }
            }

            
            {
                this$0 = SlideMenuClickListener.this;
                super();
            }
        });
    }






/*
    static SearchResult access$102(SlideMenuClickListener slidemenuclicklistener, SearchResult searchresult)
    {
        slidemenuclicklistener.rst = searchresult;
        return searchresult;
    }

*/








}
