// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.fragments;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.mixerbox.mixerbox3b.utils.MixerBoxClient;

// Referenced classes of package com.mixerbox.mixerbox3b.fragments:
//            DiscoverFragment

class this._cls0
    implements com.handmark.pulltorefresh.library.nRefreshListener
{

    final DiscoverFragment this$0;

    public void onRefresh(PullToRefreshBase pulltorefreshbase)
    {
        class _cls1 extends MixerBoxAsyncHttpResponseHandler
        {

            final DiscoverFragment._cls2 this$1;

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
                this$1 = DiscoverFragment._cls2.this;
                super(context);
            }
        }

        MixerBoxClient.get(MixerBoxClient.getSystemListUrl(getActivity(), locale), null, new _cls1(getActivity()));
    }

    _cls1()
    {
        this$0 = DiscoverFragment.this;
        super();
    }
}
