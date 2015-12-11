// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.fragments;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.mixerbox.mixerbox3b.utils.MixerBoxClient;
import java.util.Locale;

// Referenced classes of package com.mixerbox.mixerbox3b.fragments:
//            DJsFragment

class this._cls0
    implements com.handmark.pulltorefresh.library.ase.OnRefreshListener
{

    final DJsFragment this$0;

    public void onRefresh(PullToRefreshBase pulltorefreshbase)
    {
        pulltorefreshbase = (new StringBuilder()).append(Locale.getDefault().getLanguage()).append("-").append(Locale.getDefault().getCountry().toLowerCase(Locale.getDefault())).toString();
        class _cls1 extends MixerBoxAsyncHttpResponseHandler
        {

            final DJsFragment._cls2 this$1;

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
                this$1 = DJsFragment._cls2.this;
                super(context);
            }
        }

        MixerBoxClient.get(MixerBoxClient.getDJsUrl(getActivity(), pulltorefreshbase), null, new _cls1(getActivity()));
    }

    Base()
    {
        this$0 = DJsFragment.this;
        super();
    }
}
