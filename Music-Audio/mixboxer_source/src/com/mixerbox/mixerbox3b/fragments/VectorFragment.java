// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.fragments;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.mixerbox.mixerbox3b.adapters.VectorAdapter;
import com.mixerbox.mixerbox3b.classes.DividerVectorItem;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class VectorFragment extends Fragment
{

    VectorAdapter adapter;
    public List array;
    public boolean canScroll;
    boolean endList;
    LayoutInflater f;
    LinearLayout llLoading;
    PullToRefreshListView lv;
    public String title;
    public String vectorId;
    public int vectorPageType;
    public String vectorType;

    public VectorFragment()
    {
        vectorId = "";
        vectorType = "";
        vectorPageType = 0;
        endList = false;
        title = "";
        canScroll = false;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        f = (LayoutInflater)getActivity().getSystemService("layout_inflater");
    }

    public View onCreateView(LayoutInflater layoutinflater, final ViewGroup scroller, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030038, scroller, false);
        lv = (PullToRefreshListView)layoutinflater.findViewById(0x7f0700aa);
        llLoading = (LinearLayout)layoutinflater.findViewById(0x7f070071);
        lv.getLoadingLayoutProxy().setPullLabel(getActivity().getResources().getString(0x7f0800dd));
        lv.getLoadingLayoutProxy().setReleaseLabel(getActivity().getResources().getString(0x7f0800b6));
        lv.getLoadingLayoutProxy().setRefreshingLabel(getActivity().getResources().getString(0x7f080074));
        array = new ArrayList();
        try
        {
            array.add(new DividerVectorItem(new JSONObject("{\"type\":\"divider\",\"title\":\"\"}"), getActivity()));
        }
        // Misplaced declaration of an exception variable
        catch (final ViewGroup scroller)
        {
            scroller.printStackTrace();
        }
        lv.setAdapter(new VectorAdapter(getActivity(), f, array));
        lv.setRefreshing();
        lv.setOnItemClickListener(new _cls1());
        scroller = new EndlessScrollListener(vectorPageType);
        if ((vectorPageType == 0 || vectorPageType == 3) && !vectorType.equals("dj"))
        {
            ((ListView)lv.getRefreshableView()).setOnScrollListener(scroller);
        }
        if (vectorPageType == 0)
        {
            lv.setOnRefreshListener(new _cls2());
        }
        lv.setRefreshing();
        return layoutinflater;
    }

    public void setContent()
    {
        if (!isAdded())
        {
            return;
        } else
        {
            lv.setAdapter(new VectorAdapter(getActivity(), f, array));
            lv.onRefreshComplete();
            return;
        }
    }

    private class _cls1
        implements android.widget.AdapterView.OnItemClickListener
    {

        final VectorFragment this$0;

        public void onItemClick(AdapterView adapterview, View view, int i, long l)
        {
            if (vectorPageType == 3) goto _L2; else goto _L1
_L1:
            adapterview = (MyItem)((ListView)lv.getRefreshableView()).getItemAtPosition(i);
            VectorOnClickHandle.onClick(getActivity(), adapterview.getMyJSONObject(), null, null, null);
_L32:
            return;
_L2:
            Object obj2;
            adapterview = (MyItem)((ListView)lv.getRefreshableView()).getItemAtPosition(i);
            obj2 = adapterview.getMyJSONObject();
            if (((JSONObject) (obj2)).isNull("type") || !((JSONObject) (obj2)).getString("type").equals("music"))
            {
                continue; /* Loop/switch isn't completed */
            }
            Object obj;
            Object obj1;
            String s;
            int j;
            obj = "";
            adapterview = "";
            view = "";
            obj1 = "";
            s = "";
            j = 1;
            if (!((JSONObject) (obj2)).isNull("f"))
            {
                obj = ((JSONObject) (obj2)).getString("f");
            }
            if (((JSONObject) (obj2)).isNull("tm")) goto _L4; else goto _L3
_L3:
            adapterview = ((JSONObject) (obj2)).getString("tm");
_L17:
            if (((JSONObject) (obj2)).isNull("tt")) goto _L6; else goto _L5
_L5:
            view = ((JSONObject) (obj2)).getString("tt");
_L19:
            if (!((JSONObject) (obj2)).isNull("_id"))
            {
                obj1 = ((JSONObject) (obj2)).getString("_id");
            }
            if (!((JSONObject) (obj2)).isNull("thumbnail"))
            {
                s = ((JSONObject) (obj2)).getString("thumbnail");
            }
            if (!((JSONObject) (obj2)).isNull("source")) goto _L8; else goto _L7
_L7:
            j = 1;
_L22:
            SongItem songitem;
            ArrayList arraylist;
            songitem = new SongItem(((String) (obj1)), view, adapterview, ((String) (obj)), 0, j, s);
            arraylist = new ArrayList();
            int k;
            k = 0;
            obj2 = adapterview;
            View view1 = view;
            String s2 = ((String) (obj1));
            obj1 = s;
            adapterview = ((AdapterView) (obj));
            view = ((View) (obj2));
            obj = view1;
            s = s2;
_L15:
            JSONObject jsonobject;
            if (k >= array.size())
            {
                break MISSING_BLOCK_LABEL_695;
            }
            jsonobject = ((MyItem)array.get(k)).getMyJSONObject();
            if (!jsonobject.isNull("f"))
            {
                adapterview = jsonobject.getString("f");
            }
            if (jsonobject.isNull("tm")) goto _L10; else goto _L9
_L9:
            view = jsonobject.getString("tm");
_L25:
            if (jsonobject.isNull("tt")) goto _L12; else goto _L11
_L11:
            obj = jsonobject.getString("tt");
_L27:
            if (!jsonobject.isNull("_id"))
            {
                s = jsonobject.getString("_id");
            }
            if (!jsonobject.isNull("source")) goto _L14; else goto _L13
_L13:
            j = 1;
            obj2 = obj1;
_L28:
            arraylist.add(new SongItem(s, ((String) (obj)), view, adapterview, k, j, ((String) (obj2))));
            k++;
            obj1 = obj2;
              goto _L15
_L4:
            if (((JSONObject) (obj2)).isNull("duration")) goto _L17; else goto _L16
_L16:
            adapterview = ((JSONObject) (obj2)).getString("duration");
              goto _L17
_L6:
            if (((JSONObject) (obj2)).isNull("title")) goto _L19; else goto _L18
_L18:
            view = ((JSONObject) (obj2)).getString("title");
              goto _L19
_L8:
            if (!((JSONObject) (obj2)).getString("source").equals("youtube")) goto _L21; else goto _L20
_L20:
            j = 1;
              goto _L22
_L21:
            if (!((JSONObject) (obj2)).getString("source").equals("soundcloud")) goto _L22; else goto _L23
_L23:
            j = 3;
            obj = ((JSONObject) (obj2)).getString("trackId");
              goto _L22
_L10:
            if (jsonobject.isNull("duration")) goto _L25; else goto _L24
_L24:
            view = jsonobject.getString("duration");
              goto _L25
_L12:
            if (jsonobject.isNull("title")) goto _L27; else goto _L26
_L26:
            obj = jsonobject.getString("title");
              goto _L27
_L14:
            if (!jsonobject.getString("source").equals("youtube"))
            {
                break MISSING_BLOCK_LABEL_624;
            }
            j = 1;
            obj2 = obj1;
              goto _L28
            obj2 = obj1;
            if (!jsonobject.getString("source").equals("soundcloud")) goto _L28; else goto _L29
_L29:
            byte byte0 = 3;
            String s1 = jsonobject.getString("trackId");
            adapterview = s1;
            j = byte0;
            obj2 = obj1;
            if (jsonobject.isNull("thumbnail")) goto _L28; else goto _L30
_L30:
            obj2 = jsonobject.getString("thumbnail");
            adapterview = s1;
            j = byte0;
              goto _L28
            try
            {
                ((MainPage)getActivity()).arrayPlayingSong = arraylist;
                ((MainPage)getActivity()).playingSong = songitem;
                ((MainPage)getActivity()).playingPlaylist = null;
                ((MainPage)getActivity()).playingSongIndex = i - 1;
                ((MainPage)getActivity()).playMusic(true);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (AdapterView adapterview)
            {
                adapterview.toString();
            }
            return;
            if (((JSONObject) (obj2)).isNull("type") || !((JSONObject) (obj2)).getString("type").equals("playlist")) goto _L32; else goto _L31
_L31:
            VectorOnClickHandle.onClick(getActivity(), adapterview.getMyJSONObject(), null, null, null);
            return;
        }

        _cls1()
        {
            this$0 = VectorFragment.this;
            super();
        }
    }


    private class EndlessScrollListener
        implements android.widget.AbsListView.OnScrollListener
    {

        private int currentPage;
        private boolean loading;
        private int previousTotal;
        final VectorFragment this$0;
        private int vectorType;
        private int visibleThreshold;

        public void onScroll(AbsListView abslistview, int i, int j, int k)
        {
            if (canScroll)
            {
                if (loading && k > previousTotal)
                {
                    loading = false;
                    previousTotal = k;
                    currentPage = currentPage + 1;
                    MixerBoxUtils.logMsg((new StringBuilder()).append("current page = ").append(currentPage).toString());
                }
                if (!endList && !loading && i + j == k && j != 0 && k - j <= visibleThreshold + i)
                {
                    llLoading.setVisibility(0);
                    if (vectorType == 3)
                    {
                        (new LoadSearchVectorTask(null)).execute(new Integer[] {
                            Integer.valueOf(currentPage), Integer.valueOf(k), Integer.valueOf(j)
                        });
                    } else
                    {
                        (new LoadVectorTask(null)).execute(new Integer[] {
                            Integer.valueOf(currentPage), Integer.valueOf(k), Integer.valueOf(j)
                        });
                    }
                    loading = true;
                    return;
                }
            }
        }

        public void onScrollStateChanged(AbsListView abslistview, int i)
        {
        }


/*
        static int access$002(EndlessScrollListener endlessscrolllistener, int i)
        {
            endlessscrolllistener.currentPage = i;
            return i;
        }

*/


/*
        static int access$102(EndlessScrollListener endlessscrolllistener, int i)
        {
            endlessscrolllistener.previousTotal = i;
            return i;
        }

*/


/*
        static boolean access$202(EndlessScrollListener endlessscrolllistener, boolean flag)
        {
            endlessscrolllistener.loading = flag;
            return flag;
        }

*/

        public EndlessScrollListener(int i)
        {
            this$0 = VectorFragment.this;
            super();
            visibleThreshold = 500;
            currentPage = -1;
            previousTotal = 0;
            loading = true;
            vectorType = i;
        }

        private class LoadSearchVectorTask extends AsyncTask
        {

            final VectorFragment this$0;

            protected volatile Object doInBackground(Object aobj[])
            {
                return doInBackground((Integer[])aobj);
            }

            protected transient String[] doInBackground(final Integer params[])
            {
                if (getActivity() == null)
                {
                    return null;
                } else
                {
                    class _cls1
                        implements Runnable
                    {

                        final LoadSearchVectorTask this$1;
                        final Integer val$params[];

                        public void run()
                        {
                            if (endList || getActivity() == null)
                            {
                                return;
                            } else
                            {
                                class _cls1 extends MixerBoxAsyncHttpResponseHandler
                                {

                                    final _cls1 this$2;

                                    public void onFailure(Throwable throwable, String s)
                                    {
                                        super.onFailure(throwable, s);
                                    }

                                    public void onSuccess(String s)
                                    {
                                        boolean flag;
                                        flag = false;
                                        super.onSuccess(s);
                                        if (s == null)
                                        {
                                            return;
                                        }
                                        if (params[0].intValue() == -1)
                                        {
                                            array.clear();
                                        }
                                        s = (new JSONObject(s)).getJSONObject("searchVideo").getJSONArray("items");
                                        int i = ((flag) ? 1 : 0);
                                        if (s.length() >= 20)
                                        {
                                            break MISSING_BLOCK_LABEL_95;
                                        }
                                        endList = true;
                                        i = ((flag) ? 1 : 0);
_L2:
                                        if (i >= s.length())
                                        {
                                            break; /* Loop/switch isn't completed */
                                        }
                                        JSONObject jsonobject = s.getJSONObject(i);
                                        MixerBoxUtils.addMyItemToArray(array, jsonobject, getActivity(), i, s.length() - i - 1);
                                        i++;
                                        if (true) goto _L2; else goto _L1
                                        s;
                                        s.printStackTrace();
_L1:
                                        if (array == null || getActivity() == null || f == null)
                                        {
                                            llLoading.setVisibility(8);
                                            return;
                                        } else
                                        {
                                            lv.setAdapter(new VectorAdapter(getActivity(), f, array));
                                            ((ListView)lv.getRefreshableView()).setSelection(params[1].intValue() - params[2].intValue());
                                            llLoading.setVisibility(8);
                                            return;
                                        }
                                    }

                                    _cls1(Context context)
                                    {
                                        this$2 = _cls1.this;
                                        super(context);
                                    }
                                }

                                MixerBoxClient.get(MixerBoxClient.getSearchUrl(vectorType, title, params[0].intValue() + 1), null, new _cls1(getActivity()));
                                return;
                            }
                        }

                    _cls1()
                    {
                        this$1 = LoadSearchVectorTask.this;
                        params = ainteger;
                        super();
                    }
                    }

                    getActivity().runOnUiThread(new _cls1());
                    return null;
                }
            }

            protected volatile void onPostExecute(Object obj)
            {
                onPostExecute((String[])obj);
            }

            protected void onPostExecute(String as[])
            {
                super.onPostExecute(as);
            }

            private LoadSearchVectorTask()
            {
                this$0 = VectorFragment.this;
                super();
            }

            LoadSearchVectorTask(_cls1 _pcls1)
            {
                this();
            }
        }


        private class LoadVectorTask extends AsyncTask
        {

            final VectorFragment this$0;

            protected volatile Object doInBackground(Object aobj[])
            {
                return doInBackground((Integer[])aobj);
            }

            protected transient String[] doInBackground(final Integer params[])
            {
                if (getActivity() == null)
                {
                    return null;
                } else
                {
                    class _cls1
                        implements Runnable
                    {

                        final LoadVectorTask this$1;
                        final Integer val$params[];

                        public void run()
                        {
                            if (!endList && getActivity() != null)
                            {
                                String s = MixerBoxClient.getVectorUrl(vectorId, params[0].intValue() + 1, vectorType);
                                if (!vectorId.equals(""))
                                {
                                    class _cls1 extends MixerBoxAsyncHttpResponseHandler
                                    {

                                        final _cls1 this$2;

                                        public void onFailure(Throwable throwable, String s1)
                                        {
                                            super.onFailure(throwable, s1);
                                        }

                                        public void onSuccess(String s1)
                                        {
                                            boolean flag;
                                            flag = false;
                                            super.onSuccess(s1);
                                            if (s1 == null)
                                            {
                                                return;
                                            }
                                            if (params[0].intValue() == -1)
                                            {
                                                array.clear();
                                            }
                                            s1 = (new JSONObject(s1)).getJSONObject("getVector").getJSONArray("items");
                                            int i = ((flag) ? 1 : 0);
                                            if (s1.length() >= 20)
                                            {
                                                break MISSING_BLOCK_LABEL_95;
                                            }
                                            endList = true;
                                            i = ((flag) ? 1 : 0);
_L2:
                                            if (i >= s1.length())
                                            {
                                                break; /* Loop/switch isn't completed */
                                            }
                                            JSONObject jsonobject = s1.getJSONObject(i);
                                            MixerBoxUtils.addMyItemToArray(array, jsonobject, getActivity(), i, s1.length() - i - 1);
                                            i++;
                                            if (true) goto _L2; else goto _L1
                                            s1;
                                            s1.printStackTrace();
_L1:
                                            if (array == null || getActivity() == null || f == null)
                                            {
                                                llLoading.setVisibility(8);
                                                return;
                                            } else
                                            {
                                                lv.setAdapter(new VectorAdapter(getActivity(), f, array));
                                                ((ListView)lv.getRefreshableView()).setSelection(params[1].intValue() - params[2].intValue());
                                                llLoading.setVisibility(8);
                                                return;
                                            }
                                        }

                                    _cls1(Context context)
                                    {
                                        this$2 = _cls1.this;
                                        super(context);
                                    }
                                    }

                                    MixerBoxClient.get(s, null, new _cls1(getActivity()));
                                    return;
                                }
                            }
                        }

                    _cls1()
                    {
                        this$1 = LoadVectorTask.this;
                        params = ainteger;
                        super();
                    }
                    }

                    getActivity().runOnUiThread(new _cls1());
                    return null;
                }
            }

            protected volatile void onPostExecute(Object obj)
            {
                onPostExecute((String[])obj);
            }

            protected void onPostExecute(String as[])
            {
                super.onPostExecute(as);
            }

            private LoadVectorTask()
            {
                this$0 = VectorFragment.this;
                super();
            }

            LoadVectorTask(_cls1 _pcls1)
            {
                this();
            }
        }

    }


    private class _cls2
        implements com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener
    {

        final VectorFragment this$0;
        final EndlessScrollListener val$scroller;

        public void onRefresh(PullToRefreshBase pulltorefreshbase)
        {
            endList = false;
            scroller.currentPage = 0;
            scroller.previousTotal = 0;
            scroller.loading = false;
            if (vectorId.equals(""))
            {
                return;
            } else
            {
                class _cls1 extends MixerBoxAsyncHttpResponseHandler
                {

                    final _cls2 this$1;

                    public void onFailure(Throwable throwable, String s)
                    {
                        super.onFailure(throwable, s);
                    }

                    public void onSuccess(String s)
                    {
                        super.onSuccess(s);
                        if (s == null) goto _L2; else goto _L1
_L1:
                        if (array != null) goto _L4; else goto _L3
_L3:
                        array = new ArrayList();
_L11:
                        JSONObject jsonobject;
                        s = (new JSONObject(s)).getJSONObject("getVector").getJSONArray("items");
                        if (!s.getJSONObject(0).isNull("type") && !s.getJSONObject(0).getString("type").equals("divider") && !vectorType.equals("dj"))
                        {
                            array.add(new DividerVectorItem(new JSONObject((new StringBuilder()).append("{\"type\":\"divider\",\"title\":\"").append(title).append("\"}").toString()), getActivity()));
                        }
                        jsonobject = new JSONObject();
                        jsonobject.put("type", "dj_info");
                        if (s.length() == 0)
                        {
                            endList = true;
                        }
                          goto _L5
_L12:
                        int i;
                        if (i >= s.length()) goto _L2; else goto _L6
_L6:
                        JSONObject jsonobject1 = s.getJSONObject(i);
                        if (!vectorType.equals("dj") || i > 2) goto _L8; else goto _L7
_L7:
                        if (i >= 2) goto _L10; else goto _L9
_L9:
                        try
                        {
                            jsonobject.put((new StringBuilder()).append("").append(i).toString(), jsonobject1);
                            break MISSING_BLOCK_LABEL_551;
                        }
                        // Misplaced declaration of an exception variable
                        catch (String s)
                        {
                            s.printStackTrace();
                        }
                          goto _L2
_L4:
                        array.clear();
                          goto _L11
_L2:
                        if (array == null || getActivity() == null || f == null)
                        {
                            lv.onRefreshComplete();
                            canScroll = true;
                            return;
                        } else
                        {
                            lv.setAdapter(new VectorAdapter(getActivity(), f, array));
                            ((ListView)lv.getRefreshableView()).setSelection(0);
                            lv.onRefreshComplete();
                            canScroll = true;
                            return;
                        }
_L10:
                        MixerBoxUtils.addMyItemToArray(array, jsonobject, getActivity(), i, s.length() - 1);
_L8:
                        MixerBoxUtils.addMyItemToArray(array, jsonobject1, getActivity(), i, s.length() - i - 1);
                        break MISSING_BLOCK_LABEL_551;
_L5:
                        i = 0;
                          goto _L12
                        i++;
                          goto _L12
                    }

                _cls1(Context context)
                {
                    this$1 = _cls2.this;
                    super(context);
                }
                }

                MixerBoxClient.get(MixerBoxClient.getVectorUrl(vectorId, 0, vectorType), null, new _cls1(getActivity()));
                return;
            }
        }

        _cls2()
        {
            this$0 = VectorFragment.this;
            scroller = endlessscrolllistener;
            super();
        }
    }

}
