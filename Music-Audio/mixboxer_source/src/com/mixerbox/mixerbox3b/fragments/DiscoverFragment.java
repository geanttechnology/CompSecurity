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
import android.widget.TabHost;
import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.mixerbox.mixerbox3b.MainPage;
import com.mixerbox.mixerbox3b.adapters.VectorAdapter;
import java.util.List;
import java.util.Locale;

public class DiscoverFragment extends Fragment
{

    LayoutInflater f;
    String locale;
    PullToRefreshListView lvSystemList;
    TabHost tabHost;
    View v;

    public DiscoverFragment()
    {
    }

    public void loadContent()
    {
        if (!isAdded())
        {
            return;
        } else
        {
            lvSystemList.setAdapter(new VectorAdapter(getActivity(), f, ((MainPage)getActivity()).arraySystemList));
            lvSystemList.onRefreshComplete();
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        locale = (new StringBuilder()).append(Locale.getDefault().getLanguage()).append("-").append(Locale.getDefault().getCountry().toLowerCase(Locale.getDefault())).toString();
        f = (LayoutInflater)getActivity().getSystemService("layout_inflater");
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        v = layoutinflater.inflate(0x7f03002c, viewgroup, false);
        if (((MainPage)getActivity()).arraySystemList == null)
        {
            return v;
        }
        lvSystemList = (PullToRefreshListView)v.findViewById(0x7f070066);
        lvSystemList.getLoadingLayoutProxy().setPullLabel(getActivity().getResources().getString(0x7f0800dd));
        lvSystemList.getLoadingLayoutProxy().setReleaseLabel(getActivity().getResources().getString(0x7f0800b6));
        lvSystemList.getLoadingLayoutProxy().setRefreshingLabel(getActivity().getResources().getString(0x7f080074));
        lvSystemList.setAdapter(new VectorAdapter(getActivity(), f, ((MainPage)getActivity()).arraySystemList));
        if (((MainPage)getActivity()).arraySystemList != null && ((MainPage)getActivity()).arraySystemList.size() <= 1)
        {
            lvSystemList.setRefreshing();
        }
        lvSystemList.setOnItemClickListener(new _cls1());
        lvSystemList.setOnRefreshListener(new _cls2());
        return v;
    }

    private class _cls1
        implements android.widget.AdapterView.OnItemClickListener
    {

        final DiscoverFragment this$0;

        public void onItemClick(AdapterView adapterview, View view, int i, long l)
        {
            if (!MixerBoxClient.isConnectingToInternet(getActivity()))
            {
                AlertDialogFactory.NoNetworkAlertDialog(getActivity()).show();
                return;
            } else
            {
                adapterview = (MyItem)((ListView)lvSystemList.getRefreshableView()).getItemAtPosition(i);
                VectorOnClickHandle.onClick(getActivity(), adapterview.getMyJSONObject(), null, null, null);
                return;
            }
        }

        _cls1()
        {
            this$0 = DiscoverFragment.this;
            super();
        }
    }


    private class _cls2
        implements com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener
    {

        final DiscoverFragment this$0;

        public void onRefresh(PullToRefreshBase pulltorefreshbase)
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
                    break MISSING_BLOCK_LABEL_5;
_L4:
                    do
                    {
                        return;
                    } while (getActivity() == null || ((MainPage)getActivity()).arraySystemList == null);
                    if (s == null)
                    {
                        lvSystemList.onRefreshComplete();
                        return;
                    }
                    ((MainPage)getActivity()).arraySystemList.clear();
                    s = (new JSONObject(s)).getJSONObject("searchPage").getJSONArray("items");
                    int i = 0;
_L2:
                    if (i >= s.length())
                    {
                        continue; /* Loop/switch isn't completed */
                    }
                    JSONObject jsonobject = s.getJSONObject(i);
                    MixerBoxUtils.addMyItemToArray(((MainPage)getActivity()).arraySystemList, jsonobject, getActivity(), i, s.length() - i - 1);
                    i++;
                    if (true) goto _L2; else goto _L1
_L1:
                    s;
                    s.printStackTrace();
                    if (((MainPage)getActivity()).arraySystemList == null) goto _L4; else goto _L3
_L3:
                    lvSystemList.setAdapter(new VectorAdapter(getActivity(), f, ((MainPage)getActivity()).arraySystemList));
                    lvSystemList.onRefreshComplete();
                    return;
                }

                _cls1(Context context)
                {
                    this$1 = _cls2.this;
                    super(context);
                }
            }

            MixerBoxClient.get(MixerBoxClient.getSystemListUrl(getActivity(), locale), null, new _cls1(getActivity()));
        }

        _cls2()
        {
            this$0 = DiscoverFragment.this;
            super();
        }
    }

}
