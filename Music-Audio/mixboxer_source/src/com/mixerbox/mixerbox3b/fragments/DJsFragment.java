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
import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.mixerbox.mixerbox3b.MainPage;
import com.mixerbox.mixerbox3b.adapters.VectorAdapter;

public class DJsFragment extends Fragment
{

    public VectorAdapter adapter;
    LayoutInflater f;
    public PullToRefreshListView lv;

    public DJsFragment()
    {
    }

    public void loadContent()
    {
        if (!isAdded())
        {
            return;
        }
        adapter = new VectorAdapter(getActivity(), f, ((MainPage)getActivity()).arrayDJs);
        if (((MainPage)getActivity()).arrayDJs != null)
        {
            lv.setAdapter(adapter);
        }
        lv.setOnItemClickListener(new _cls1());
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        f = (LayoutInflater)getActivity().getSystemService("layout_inflater");
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f03002d, viewgroup, false);
        lv = (PullToRefreshListView)layoutinflater.findViewById(0x7f070067);
        lv.getLoadingLayoutProxy().setPullLabel(getActivity().getResources().getString(0x7f0800dd));
        lv.getLoadingLayoutProxy().setReleaseLabel(getActivity().getResources().getString(0x7f0800b6));
        lv.getLoadingLayoutProxy().setRefreshingLabel(getActivity().getResources().getString(0x7f080074));
        lv.setOnRefreshListener(new _cls2());
        return layoutinflater;
    }

    private class _cls1
        implements android.widget.AdapterView.OnItemClickListener
    {

        final DJsFragment this$0;

        public void onItemClick(AdapterView adapterview, View view, int i, long l)
        {
            if (!MixerBoxClient.isConnectingToInternet(getActivity()))
            {
                AlertDialogFactory.NoNetworkAlertDialog(getActivity()).show();
                return;
            } else
            {
                adapterview = (MyItem)((ListView)lv.getRefreshableView()).getItemAtPosition(i);
                VectorOnClickHandle.onClick(getActivity(), adapterview.getMyJSONObject(), null, null, null);
                return;
            }
        }

        _cls1()
        {
            this$0 = DJsFragment.this;
            super();
        }
    }


    private class _cls2
        implements com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener
    {

        final DJsFragment this$0;

        public void onRefresh(PullToRefreshBase pulltorefreshbase)
        {
            pulltorefreshbase = (new StringBuilder()).append(Locale.getDefault().getLanguage()).append("-").append(Locale.getDefault().getCountry().toLowerCase(Locale.getDefault())).toString();
            class _cls1 extends MixerBoxAsyncHttpResponseHandler
            {

                final _cls2 this$1;

                public void onFailure(Throwable throwable, String s)
                {
                    super.onFailure(throwable, s);
                    lv.onRefreshComplete();
                }

                public void onSuccess(String s)
                {
                    super.onSuccess(s);
                    if (s == null) goto _L2; else goto _L1
_L1:
                    s = (new JSONObject(s)).getJSONObject("getMyFollowing").getJSONArray("items");
                    ((MainPage)getActivity()).arrayDJs = new ArrayList();
                    int i = 0;
_L8:
                    if (i >= s.length()) goto _L4; else goto _L3
_L3:
                    if (!s.isNull(i))
                    {
                        JSONObject jsonobject = s.getJSONObject(i);
                        MixerBoxUtils.addMyItemToArray(((MainPage)getActivity()).arrayDJs, jsonobject, getActivity(), i, s.length() - i - 1);
                    }
                      goto _L5
_L4:
                    s = (MainPage)getActivity();
                    if (s == null)
                    {
                        return;
                    }
                    break MISSING_BLOCK_LABEL_141;
                    s;
                    s.printStackTrace();
_L6:
                    loadContent();
                    lv.onRefreshComplete();
                    return;
_L2:
                    ((MainPage)getActivity()).arrayDJs = new ArrayList();
                    if (true) goto _L6; else goto _L5
_L5:
                    i++;
                    if (true) goto _L8; else goto _L7
_L7:
                }

                _cls1(Context context)
                {
                    this$1 = _cls2.this;
                    super(context);
                }
            }

            MixerBoxClient.get(MixerBoxClient.getDJsUrl(getActivity(), pulltorefreshbase), null, new _cls1(getActivity()));
        }

        _cls2()
        {
            this$0 = DJsFragment.this;
            super();
        }
    }

}
