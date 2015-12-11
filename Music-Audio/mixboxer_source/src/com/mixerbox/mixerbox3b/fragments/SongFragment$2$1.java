// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.fragments;

import android.content.Context;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.mixerbox.mixerbox3b.MainPage;
import com.mixerbox.mixerbox3b.classes.MixerBoxAsyncHttpResponseHandler;
import com.mixerbox.mixerbox3b.utils.MixerBoxUtils;
import java.util.ArrayList;

// Referenced classes of package com.mixerbox.mixerbox3b.fragments:
//            SongFragment

class sponseHandler extends MixerBoxAsyncHttpResponseHandler
{

    final Content this$1;

    public void onSuccess(String s)
    {
        super.onSuccess(s);
        ArrayList arraylist = new ArrayList();
        if (s != null)
        {
            s = MixerBoxUtils.getSongArray(s, _fld0);
        } else
        {
            s = arraylist;
        }
        if (getActivity() == null)
        {
            return;
        } else
        {
            ((MainPage)getActivity()).arraySong = new ArrayList(s);
            lv.onRefreshComplete();
            loadContent();
            return;
        }
    }

    tView(Context context)
    {
        this$1 = this._cls1.this;
        super(context);
    }
}
