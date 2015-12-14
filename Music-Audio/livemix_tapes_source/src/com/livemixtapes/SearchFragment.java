// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.livemixtapes.ui.widgets.SearchView;
import com.livemixtapes.utils.Utility;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.livemixtapes:
//            AsyncHttp, JsonToMap, LazyAdapterSearch, SearchActivity, 
//            Mixtape, App, MainActivity, NowPlayingActivity

public class SearchFragment extends Fragment
    implements com.livemixtapes.ui.widgets.SearchView.QueryTextListener
{
    private class TopArtistsComparator
        implements Comparator
    {

        final SearchFragment this$0;

        public volatile int compare(Object obj, Object obj1)
        {
            return compare((HashMap)obj, (HashMap)obj1);
        }

        public int compare(HashMap hashmap, HashMap hashmap1)
        {
            return Integer.parseInt(hashmap.get("position").toString()) - Integer.parseInt(hashmap1.get("position").toString());
        }

        private TopArtistsComparator()
        {
            this$0 = SearchFragment.this;
            super();
        }

        TopArtistsComparator(TopArtistsComparator topartistscomparator)
        {
            this();
        }
    }


    private static String textBasedSearchUrl = "https://api.livemixtapes.com/api/search?query=";
    private static String topArtistsSearchUrl = "https://api.livemixtapes.com/api/top_artists";
    private Handler DebounceHandler;
    private Runnable DebounceListener;
    SearchActivity activity;
    LazyAdapterSearch adapter;
    int curPage;
    RelativeLayout layoutHeader;
    ListView list;
    View listEmpty;
    View listHeader;
    View listProgress;
    private android.widget.AbsListView.OnScrollListener listScrollListener;
    View rootView;
    private android.widget.AdapterView.OnItemClickListener searchResultClicked;
    SearchView searchView;
    ArrayList topArtistsResultsList;

    public SearchFragment()
    {
        topArtistsResultsList = new ArrayList();
        searchResultClicked = new android.widget.AdapterView.OnItemClickListener() {

            final SearchFragment this$0;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                i -= list.getHeaderViewsCount();
                if (adapter.isTopArtistSearch())
                {
                    adapterview = ((HashMap)topArtistsResultsList.get(i)).get("artist").toString();
                    searchView.setQuery(adapterview);
                    return;
                } else
                {
                    Utility.hideKeyboard(activity);
                    showMixtapeFragment(activity, adapter.getResult(i));
                    return;
                }
            }

            
            {
                this$0 = SearchFragment.this;
                super();
            }
        };
        listScrollListener = new android.widget.AbsListView.OnScrollListener() {

            private int previousLast;
            final SearchFragment this$0;

            public void onScroll(AbsListView abslistview, int i, int j, int k)
            {
label0:
                {
                    i += j;
                    if (i == k && k > 1 && i != previousLast)
                    {
                        if (adapter.isTopArtistSearch())
                        {
                            break label0;
                        }
                        previousLast = i;
                        abslistview = SearchFragment.this;
                        abslistview.curPage = ((SearchFragment) (abslistview)).curPage + 1;
                        loadSearchResults(searchView.getQuery());
                    }
                    return;
                }
                previousLast = -1;
            }

            public void onScrollStateChanged(AbsListView abslistview, int i)
            {
            }

            
            {
                this$0 = SearchFragment.this;
                super();
                previousLast = -1;
            }
        };
        DebounceHandler = new Handler();
        DebounceListener = new Runnable() {

            final SearchFragment this$0;

            public void run()
            {
                runTextSearch(searchView.getQuery());
            }

            
            {
                this$0 = SearchFragment.this;
                super();
            }
        };
    }

    private void loadSearchResults(String s)
    {
        updateUI(true);
        s = (new StringBuilder(String.valueOf(textBasedSearchUrl))).append(URLEncoder.encode(s)).append("&page=").append(curPage).toString();
        (new AsyncHttp()).get(s, null, new AsyncHttp.AsyncHttpCallback() {

            final SearchFragment this$0;

            protected void always()
            {
                updateUI(false);
            }

            protected void exception(Exception exception1)
            {
                exception1.printStackTrace();
            }

            protected void success(String s1, String s2, int i)
            {
                loadSearchResultsFromJson(s1);
            }

            
            {
                this$0 = SearchFragment.this;
                super();
            }
        });
    }

    private void loadSearchResultsFromJson(String s)
    {
        try
        {
            s = new JSONObject(s);
            ArrayList arraylist = new ArrayList();
            ArrayList arraylist1 = (ArrayList)JsonToMap.convert(s).get("artist_results");
            ArrayList arraylist2 = (ArrayList)JsonToMap.convert(s).get("track_results");
            if (arraylist1.size() > 0)
            {
                arraylist.addAll((ArrayList)((HashMap)arraylist1.get(0)).get("mixtapes"));
            }
            arraylist.addAll((ArrayList)JsonToMap.convert(s).get("mixtape_results"));
            if (curPage == 0)
            {
                adapter.clear();
            }
            adapter.appendSearchResults(arraylist, arraylist2);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
    }

    private void loadTopArtists()
    {
        updateUI(true);
        (new AsyncHttp()).get(topArtistsSearchUrl, null, new AsyncHttp.AsyncHttpCallback() {

            final SearchFragment this$0;

            protected void always()
            {
                updateUI(false);
            }

            protected void exception(Exception exception1)
            {
                exception1.printStackTrace();
            }

            protected void success(String s, String s1, int i)
            {
                loadTopArtistsFromJson(s);
            }

            
            {
                this$0 = SearchFragment.this;
                super();
            }
        });
    }

    private void loadTopArtistsFromJson(String s)
    {
        try
        {
            topArtistsResultsList = (ArrayList)JsonToMap.toList(new JSONArray(s));
            Collections.sort(topArtistsResultsList, new TopArtistsComparator(null));
            adapter.setTopArtists(topArtistsResultsList);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
        updateUI(false);
    }

    private void showMixtapeFragment(Context context, HashMap hashmap)
    {
        Utility.hideKeyboard(activity);
        searchView.clearFocus();
        context = activity.getAnimatedFragmentTransaction();
        Mixtape mixtape = new Mixtape();
        context.replace(0x7f0800cc, mixtape, "MIXTAPE").addToBackStack(null);
        Bundle bundle = new Bundle();
        bundle.putSerializable("mixtapeData", hashmap);
        bundle.putString("backScreenTitle", "Search");
        mixtape.setArguments(bundle);
        context.commit();
    }

    private void updateUI(boolean flag)
    {
        boolean flag1 = false;
        View view = listProgress;
        int i;
        if (adapter.getCount() == 0 && flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        view.setVisibility(i);
        view = listEmpty;
        if (adapter.getCount() == 0 && !flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        view.setVisibility(i);
        view = listHeader;
        if (adapter.isTopArtistSearch() && !flag && adapter.getCount() > 0)
        {
            i = ((flag1) ? 1 : 0);
        } else
        {
            i = 8;
        }
        view.setVisibility(i);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        activity = (SearchActivity)getActivity();
        if (rootView != null) goto _L2; else goto _L1
_L1:
        rootView = layoutinflater.inflate(0x7f030036, viewgroup, false);
        searchView = (SearchView)rootView.findViewById(0x7f0800ff);
        searchView.setOnQueryTextListener(this);
        searchView.clearFocus();
        rootView.setOnTouchListener(new android.view.View.OnTouchListener() {

            final SearchFragment this$0;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                if (!(new Rect(searchView.getLeft(), searchView.getTop(), searchView.getRight(), searchView.getBottom())).contains(view.getLeft() + (int)motionevent.getX(), view.getTop() + (int)motionevent.getY()))
                {
                    searchView.setExpand(false);
                }
                return false;
            }

            
            {
                this$0 = SearchFragment.this;
                super();
            }
        });
        searchView.setOnExpandListener(new com.livemixtapes.ui.widgets.SearchView.ExpandListener() {

            final SearchFragment this$0;

            public void onAfterExpand(boolean flag)
            {
            }

            public void onBeforeExpand(boolean flag)
            {
                Animation animation = flag. new Animation() {

                    final _cls5 this$1;
                    private final boolean val$expand;

                    protected void applyTransformation(float f, Transformation transformation)
                    {
                        transformation = (android.widget.LinearLayout.LayoutParams)layoutHeader.getLayoutParams();
                        if (expand)
                        {
                            f = Utility.dpToPixel(activity, 50F - 50F * f);
                        } else
                        {
                            f = Utility.dpToPixel(activity, 50F * f);
                        }
                        transformation.height = (int)f;
                        layoutHeader.setLayoutParams(transformation);
                    }

            
            {
                this$1 = final__pcls5;
                expand = Z.this;
                super();
            }
                };
                animation.setDuration(300L);
                layoutHeader.startAnimation(animation);
            }


            
            {
                this$0 = SearchFragment.this;
                super();
            }
        });
        layoutHeader = (RelativeLayout)rootView.findViewById(0x7f0800fe);
        listHeader = layoutinflater.inflate(0x7f030037, null, false);
        listProgress = rootView.findViewById(0x102000d);
        listEmpty = rootView.findViewById(0x1020004);
        list = (ListView)rootView.findViewById(0x7f080100);
        list.addHeaderView(listHeader);
        listHeader = listHeader.findViewById(0x7f080101);
        adapter = new LazyAdapterSearch(this);
        list.setAdapter(adapter);
        loadTopArtists();
        viewgroup = null;
        layoutinflater = new JSONObject(App.DefaultTape);
        layoutinflater = layoutinflater.getJSONObject("mixtape");
_L4:
        layoutinflater = JsonToMap.convert(layoutinflater);
        if (!App.didLoad.booleanValue())
        {
            App.didLoad = Boolean.valueOf(true);
            MainActivity.firstLoad = true;
            NowPlayingActivity.mixtape = layoutinflater;
            NowPlayingActivity.tracksList = (ArrayList)layoutinflater.get("tracks");
            NowPlayingActivity.playList = null;
            NowPlayingActivity.position = 0;
            NowPlayingActivity.flag = 1;
            startActivity(new Intent(activity, com/livemixtapes/NowPlayingActivity));
        }
        list.setOnItemClickListener(searchResultClicked);
_L2:
        ((InputMethodManager)activity.getSystemService("input_method")).showSoftInput(searchView, 1);
        searchView.setFocusable(false);
        return rootView;
        layoutinflater;
_L5:
        layoutinflater.printStackTrace();
        layoutinflater = viewgroup;
        if (true) goto _L4; else goto _L3
_L3:
        layoutinflater;
          goto _L5
    }

    public boolean onQueryTextChange(String s)
    {
        DebounceHandler.removeCallbacks(DebounceListener);
        DebounceHandler.postDelayed(DebounceListener, 300L);
        return true;
    }

    public boolean onQueryTextSubmit(String s)
    {
        searchView.clearFocus();
        return false;
    }

    public void runTextSearch(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            list.clearTextFilter();
            activity.hideProgressBar();
            adapter.setTopArtists(topArtistsResultsList);
            updateUI(false);
            return;
        } else
        {
            curPage = 0;
            adapter.clear();
            loadSearchResults(s);
            return;
        }
    }

    void shake(Context context, View view, final Runnable callback)
    {
        context = AnimationUtils.loadAnimation(context, 0x7f04000c);
        context.setAnimationListener(new android.view.animation.Animation.AnimationListener() {

            final SearchFragment this$0;
            private final Runnable val$callback;

            public void onAnimationEnd(Animation animation)
            {
                if (callback != null)
                {
                    callback.run();
                }
            }

            public void onAnimationRepeat(Animation animation)
            {
            }

            public void onAnimationStart(Animation animation)
            {
            }

            
            {
                this$0 = SearchFragment.this;
                callback = runnable;
                super();
            }
        });
        view.startAnimation(context);
    }






}
