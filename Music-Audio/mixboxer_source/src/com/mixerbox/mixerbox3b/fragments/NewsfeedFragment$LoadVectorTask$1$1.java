// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.fragments;

import android.content.Context;
import android.widget.LinearLayout;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.mixerbox.mixerbox3b.MainPage;
import com.mixerbox.mixerbox3b.adapters.VectorAdapter;
import com.mixerbox.mixerbox3b.classes.MixerBoxAsyncHttpResponseHandler;
import com.mixerbox.mixerbox3b.utils.MixerBoxUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.mixerbox.mixerbox3b.fragments:
//            NewsfeedFragment

class > extends MixerBoxAsyncHttpResponseHandler
{

    final lete this$2;

    public void onSuccess(String s)
    {
        boolean flag;
        flag = false;
        super.onSuccess(s);
        if (getActivity() == null)
        {
            return;
        }
        if (((MainPage)getActivity()).arrayNewsfeed == null)
        {
            ((MainPage)getActivity()).arrayNewsfeed = new ArrayList();
        }
        if (params[0].intValue() == -1)
        {
            ((MainPage)getActivity()).arrayNewsfeed.clear();
        }
        s = (new JSONObject(s)).getJSONObject("newsPage").getJSONArray("items");
        int i = ((flag) ? 1 : 0);
        if (s.length() >= 20)
        {
            break MISSING_BLOCK_LABEL_161;
        }
        endList = true;
        i = ((flag) ? 1 : 0);
_L2:
        if (i >= s.length())
        {
            break; /* Loop/switch isn't completed */
        }
        JSONObject jsonobject = s.getJSONObject(i);
        MixerBoxUtils.addMyItemToArray(((MainPage)getActivity()).arrayNewsfeed, jsonobject, getActivity(), i, s.length() - i - 1);
        i++;
        if (true) goto _L2; else goto _L1
        s;
        s.printStackTrace();
_L1:
        adapter.notifyDataSetChanged();
        lvNewsfeed.onRefreshComplete();
        llLoading.setVisibility(8);
        return;
    }

    (Context context)
    {
        this$2 = this._cls2.this;
        super(context);
    }
}
