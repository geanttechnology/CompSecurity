// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.fragments;

import com.mixerbox.mixerbox3b.utils.MixerBoxClient;

// Referenced classes of package com.mixerbox.mixerbox3b.fragments:
//            NewsfeedFragment

class val.params
    implements Runnable
{

    final _cls1 this$1;
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

                final NewsfeedFragment.LoadVectorTask._cls1 this$2;

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

            _cls1(Context context)
            {
                this$2 = NewsfeedFragment.LoadVectorTask._cls1.this;
                super(context);
            }
            }

            MixerBoxClient.get(MixerBoxClient.getNewsfeedUrl(getActivity(), val$params[0].intValue() + 1), null, new _cls1(getActivity()));
            return;
        }
    }

    _cls1()
    {
        this$1 = final__pcls1;
        val$params = _5B_Ljava.lang.Integer_3B_.this;
        super();
    }
}
