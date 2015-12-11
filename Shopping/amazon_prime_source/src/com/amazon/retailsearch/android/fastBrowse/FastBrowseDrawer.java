// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.fastBrowse;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.view.View;
import android.view.ViewStub;
import android.widget.AdapterView;
import android.widget.FrameLayout;
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
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.amazon.retailsearch.android.fastBrowse:
//            FastBrowseItem, FastBrowseItemAdapter, FastBrowseItemClickListener, RefinementsLoader

public class FastBrowseDrawer
{
    public static interface GNOControlListener
    {

        public abstract void closeGNOMenu();
    }


    private static final int BASE_LAYER = 0;
    private static final String BASE_PATH = "/s/browse/categories";
    private static final MessageLogger log = AppLog.getLog(com/amazon/retailsearch/android/fastBrowse/FastBrowseDrawer);
    private FastBrowseItemAdapter mAdapter;
    private String mBrowseUrl;
    private Context mContext;
    private FrameLayout mFastBrowseDrawer;
    private List mFastBrowseItems;
    private ListView mFastBrowseList;
    private GNOControlListener mGNOControlListener;
    private Set mListeners;
    private SearchResult mSearchResult;
    private SpinnerHiderRelativeLayout mSpinner;
    private final String mainMenu;
    RetailSearchAndroidPlatform platform;
    private final String shopByDepartments;
    private ViewStub viewStub;

    public FastBrowseDrawer(Context context, ViewStub viewstub)
    {
        mBrowseUrl = null;
        mContext = context;
        viewStub = viewstub;
        shopByDepartments = mContext.getResources().getString(com.amazon.retailsearch.R.string.rs_shop_by_department_text);
        mainMenu = mContext.getResources().getString(com.amazon.retailsearch.R.string.rs_main_menu);
        mListeners = new HashSet();
        RetailSearchDaggerGraphController.inject(this);
    }

    private void addItemToList(final List ancestry, final List categories, final String currentAncestryText[], final String currentCategoriesText[])
    {
        platform.invokeLater(new Runnable() {

            final FastBrowseDrawer this$0;
            final List val$ancestry;
            final List val$categories;
            final String val$currentAncestryText[];
            final String val$currentCategoriesText[];

            public void run()
            {
                mFastBrowseItems.clear();
                mFastBrowseItems.add(new FastBrowseItem(mainMenu, "/s/browse/categories", "/s/browse/categories"));
                mFastBrowseItems.add(new FastBrowseItem(shopByDepartments, "/s/browse/categories", "/s/browse/categories"));
                if (ancestry != null)
                {
                    RefinementLink refinementlink;
                    for (Iterator iterator = ancestry.iterator(); iterator.hasNext(); mFastBrowseItems.add(new FastBrowseItem(refinementlink.getText(), refinementlink.getUrl(), refinementlink.getBrowseUrl())))
                    {
                        refinementlink = (RefinementLink)iterator.next();
                    }

                } else
                if (currentAncestryText != null)
                {
                    String as[] = currentAncestryText;
                    int k = as.length;
                    for (int i = 0; i < k; i++)
                    {
                        String s = as[i];
                        mFastBrowseItems.add(new FastBrowseItem(s, null, null));
                    }

                }
                mAdapter.setCurrentLayer(mFastBrowseItems.size() - 2);
                if (categories != null)
                {
                    RefinementLink refinementlink1;
                    for (Iterator iterator1 = categories.iterator(); iterator1.hasNext(); mFastBrowseItems.add(new FastBrowseItem(refinementlink1.getText(), refinementlink1.getUrl(), refinementlink1.getBrowseUrl())))
                    {
                        refinementlink1 = (RefinementLink)iterator1.next();
                    }

                } else
                if (currentCategoriesText != null)
                {
                    String as1[] = currentCategoriesText;
                    int l = as1.length;
                    for (int j = 0; j < l; j++)
                    {
                        String s1 = as1[j];
                        mFastBrowseItems.add(new FastBrowseItem(s1, null, null));
                    }

                }
            }

            
            {
                this$0 = FastBrowseDrawer.this;
                ancestry = list;
                currentAncestryText = as;
                categories = list1;
                currentCategoriesText = as1;
                super();
            }
        });
    }

    private void fetchRefinements()
        throws InterruptedException
    {
        (new Thread(new Runnable() {

            final FastBrowseDrawer this$0;

            public void run()
            {
                (new RefinementsLoader(new RefinementsLoader.RefinementResultListener() {

                    final _cls3 this$1;

                    public void onError(Exception exception)
                    {
                        FastBrowseDrawer.log.error("Failed to fetch refinements", exception);
                    }

                    public void onResult(SearchResult searchresult)
                    {
                        mSearchResult = searchresult;
                        platform.invokeLater(searchresult. new Runnable() {

                            final _cls1 this$2;
                            final SearchResult val$result;

                            public void run()
                            {
                                RefinementLink refinementlink;
                                for (Iterator iterator = result.getRefinements().getDepartments().getCategories().iterator(); iterator.hasNext(); mFastBrowseItems.add(new FastBrowseItem(refinementlink.getText(), refinementlink.getUrl(), refinementlink.getBrowseUrl())))
                                {
                                    refinementlink = (RefinementLink)iterator.next();
                                }

                            }

            
            {
                this$2 = final__pcls1;
                result = SearchResult.this;
                super();
            }
                        });
                        refreshListView();
                    }

            
            {
                this$1 = _cls3.this;
                super();
            }
                }, null)).getRefinements();
            }

            
            {
                this$0 = FastBrowseDrawer.this;
                super();
            }
        })).start();
    }

    private void initLayout()
    {
        if (mFastBrowseDrawer == null)
        {
            viewStub.setLayoutResource(com.amazon.retailsearch.R.layout.rs_fast_browse_menu);
            mFastBrowseDrawer = (FrameLayout)viewStub.inflate();
        } else
        {
            mFastBrowseDrawer.setVisibility(0);
        }
        mFastBrowseList = (ListView)mFastBrowseDrawer.findViewById(com.amazon.retailsearch.R.id.drawer_list);
        mSpinner = (SpinnerHiderRelativeLayout)mFastBrowseDrawer.findViewById(com.amazon.retailsearch.R.id.refinements_menu_list_spinner);
        onCreateListView();
    }

    private void onCreateListView()
    {
        mFastBrowseItems = new ArrayList();
        mFastBrowseItems.add(new FastBrowseItem(mainMenu, "/s/browse/categories", "/s/browse/categories"));
        mFastBrowseItems.add(new FastBrowseItem(shopByDepartments, "/s/browse/categories", "/s/browse/categories"));
        mAdapter = new FastBrowseItemAdapter(mContext, mFastBrowseItems, 0);
        mFastBrowseList.setAdapter(mAdapter);
        mFastBrowseList.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final FastBrowseDrawer this$0;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                if (i != 0) goto _L2; else goto _L1
_L1:
                mFastBrowseDrawer.setVisibility(8);
                for (adapterview = mListeners.iterator(); adapterview.hasNext(); ((FastBrowseItemClickListener)adapterview.next()).onBackButtonClick()) { }
                  goto _L3
_L2:
                adapterview = ((FastBrowseItem)mFastBrowseItems.get(i)).getBrowseUrl();
                if (adapterview != null && !adapterview.isEmpty()) goto _L4; else goto _L3
_L3:
                return;
_L4:
                int j;
                boolean flag;
                j = 0;
                flag = false;
                if (i == 1)
                {
                    continue; /* Loop/switch isn't completed */
                }
                mBrowseUrl = adapterview;
                view = Uri.parse(CategoryBrowseController.buildCategoryBrowseLink(Uri.parse(mBrowseUrl))).getQueryParameter("node");
                if (CategoryBrowseController.shouldLaunchAIVBrowse(view))
                {
                    adapterview = mListeners.iterator();
                    while (adapterview.hasNext()) 
                    {
                        ((FastBrowseItemClickListener)adapterview.next()).onAIVItemClick();
                    }
                    continue; /* Loop/switch isn't completed */
                }
                if (!CategoryBrowseController.shouldLaunchAppStoreBrowse(view))
                {
                    break; /* Loop/switch isn't completed */
                }
                adapterview = mListeners.iterator();
                while (adapterview.hasNext()) 
                {
                    ((FastBrowseItemClickListener)adapterview.next()).onAppStoreItemClick();
                }
                if (true) goto _L3; else goto _L5
_L5:
                view = mListeners.iterator();
                i = ((flag) ? 1 : 0);
                do
                {
                    j = i;
                    if (!view.hasNext())
                    {
                        break;
                    }
                    FastBrowseItemClickListener fastbrowseitemclicklistener = (FastBrowseItemClickListener)view.next();
                    if (i != 0 || fastbrowseitemclicklistener.onItemClick(mBrowseUrl))
                    {
                        i = 1;
                    } else
                    {
                        i = 0;
                    }
                } while (true);
                if (j != 0) goto _L3; else goto _L6
_L6:
                mSpinner.show();
                try
                {
                    refetchRefinements(adapterview);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (AdapterView adapterview)
                {
                    FastBrowseDrawer.log.error("Could not fetch refinements", adapterview);
                }
                return;
            }

            
            {
                this$0 = FastBrowseDrawer.this;
                super();
            }
        });
    }

    private void refetchRefinements(final String browseUrl)
        throws InterruptedException
    {
        (new Thread(new Runnable() {

            final FastBrowseDrawer this$0;
            final String val$browseUrl;

            public void run()
            {
                (new RefinementsLoader(new RefinementsLoader.RefinementResultListener() {

                    final _cls4 this$1;

                    public void onError(Exception exception)
                    {
                        FastBrowseDrawer.log.error("Failed to refetch refinements", exception);
                    }

                    public void onResult(SearchResult searchresult)
                    {
                        if (searchresult == null || searchresult.getRefinements() == null || searchresult.getRefinements().getDepartments() == null)
                        {
                            refreshListView();
                        } else
                        {
                            mSearchResult = searchresult;
                            searchresult = mSearchResult.getRefinements().getDepartments().getCategories();
                            List list = mSearchResult.getRefinements().getDepartments().getAncestry();
                            addItemToList(list, searchresult, null, null);
                            refreshListView();
                            if (searchresult == null)
                            {
                                platform.invokeLater(new Runnable() {

                                    final _cls1 this$2;

                                    public void run()
                                    {
                                        closeGNOMenu();
                                    }

            
            {
                this$2 = _cls1.this;
                super();
            }
                                });
                                return;
                            }
                        }
                    }

            
            {
                this$1 = _cls4.this;
                super();
            }
                }, browseUrl)).getRefinements();
            }

            
            {
                this$0 = FastBrowseDrawer.this;
                browseUrl = s;
                super();
            }
        })).start();
    }

    private void refreshListView()
    {
        platform.invokeLater(new Runnable() {

            final FastBrowseDrawer this$0;

            public void run()
            {
                mAdapter.notifyDataSetChanged();
                mFastBrowseList.setSelectionAfterHeaderView();
                mSpinner.hide();
            }

            
            {
                this$0 = FastBrowseDrawer.this;
                super();
            }
        });
    }

    public void addListener(FastBrowseItemClickListener fastbrowseitemclicklistener)
    {
        mListeners.add(fastbrowseitemclicklistener);
    }

    public void closeGNOMenu()
    {
        mGNOControlListener.closeGNOMenu();
    }

    public String[] getAncestryStringArray()
    {
        Object obj = mSearchResult.getRefinements().getDepartments().getAncestry();
        String as[] = null;
        if (obj != null)
        {
            String as1[] = new String[((List) (obj)).size()];
            int i = 0;
            obj = ((List) (obj)).iterator();
            do
            {
                as = as1;
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                as1[i] = ((RefinementLink)((Iterator) (obj)).next()).getText();
                i++;
            } while (true);
        }
        return as;
    }

    public String getBrowseUrl()
    {
        return mBrowseUrl;
    }

    public String[] getCategoriesStringArray()
    {
        Object obj = mSearchResult.getRefinements().getDepartments().getCategories();
        String as[] = null;
        if (obj != null)
        {
            String as1[] = new String[((List) (obj)).size()];
            int i = 0;
            obj = ((List) (obj)).iterator();
            do
            {
                as = as1;
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                as1[i] = ((RefinementLink)((Iterator) (obj)).next()).getText();
                i++;
            } while (true);
        }
        return as;
    }

    public int getFirstVisiblePosition()
    {
        return mFastBrowseList.getFirstVisiblePosition();
    }

    public int getLayer()
    {
        return mAdapter.getCurrentLayer();
    }

    public int getListOffset()
    {
        View view = mFastBrowseList.getChildAt(0);
        if (view == null)
        {
            return 0;
        } else
        {
            return view.getTop();
        }
    }

    public void hide()
    {
        if (mFastBrowseDrawer != null)
        {
            mFastBrowseDrawer.setVisibility(8);
        }
    }

    public void initFirstLevel()
    {
        initLayout();
        mSpinner.show();
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

    public void initFromCategoryBrowseActivity(String as[], String as1[], int i, int j)
    {
        initLayout();
        addItemToList(null, null, as, as1);
        mAdapter.notifyDataSetChanged();
        mFastBrowseList.setSelectionFromTop(i, j);
    }

    public boolean isFastBrowseVisible()
    {
        return mFastBrowseDrawer != null && mFastBrowseDrawer.getVisibility() == 0;
    }

    public void removeListener(FastBrowseItemClickListener fastbrowseitemclicklistener)
    {
        mListeners.remove(fastbrowseitemclicklistener);
    }

    public void setGNOControlListener(GNOControlListener gnocontrollistener)
    {
        mGNOControlListener = gnocontrollistener;
    }

    public void show()
    {
        if (mFastBrowseDrawer != null)
        {
            mFastBrowseDrawer.setVisibility(0);
            return;
        } else
        {
            initFirstLevel();
            return;
        }
    }

    public void updateListView(String s)
    {
        try
        {
            mSpinner.show();
            mBrowseUrl = s;
            refetchRefinements(mBrowseUrl);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            log.error("Failed to update list view", s);
        }
    }






/*
    static SearchResult access$1002(FastBrowseDrawer fastbrowsedrawer, SearchResult searchresult)
    {
        fastbrowsedrawer.mSearchResult = searchresult;
        return searchresult;
    }

*/










/*
    static String access$602(FastBrowseDrawer fastbrowsedrawer, String s)
    {
        fastbrowsedrawer.mBrowseUrl = s;
        return s;
    }

*/



}
