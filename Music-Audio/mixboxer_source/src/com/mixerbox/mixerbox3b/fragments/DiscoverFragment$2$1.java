// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.fragments;

import android.content.Context;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.mixerbox.mixerbox3b.MainPage;
import com.mixerbox.mixerbox3b.adapters.VectorAdapter;
import com.mixerbox.mixerbox3b.classes.MixerBoxAsyncHttpResponseHandler;
import com.mixerbox.mixerbox3b.utils.MixerBoxUtils;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.mixerbox.mixerbox3b.fragments:
//            DiscoverFragment

class seHandler extends MixerBoxAsyncHttpResponseHandler
{

    final w.onRefreshComplete this$1;

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

    w(Context context)
    {
        this$1 = this._cls1.this;
        super(context);
    }
}
