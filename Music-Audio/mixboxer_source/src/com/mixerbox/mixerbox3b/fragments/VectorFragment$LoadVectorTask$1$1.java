// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.fragments;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.mixerbox.mixerbox3b.adapters.VectorAdapter;
import com.mixerbox.mixerbox3b.classes.MixerBoxAsyncHttpResponseHandler;
import com.mixerbox.mixerbox3b.utils.MixerBoxUtils;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.mixerbox.mixerbox3b.fragments:
//            VectorFragment

class it> extends MixerBoxAsyncHttpResponseHandler
{

    final l.params this$2;

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
        s = (new JSONObject(s)).getJSONObject("getVector").getJSONArray("items");
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

    I(Context context)
    {
        this$2 = this._cls2.this;
        super(context);
    }
}
