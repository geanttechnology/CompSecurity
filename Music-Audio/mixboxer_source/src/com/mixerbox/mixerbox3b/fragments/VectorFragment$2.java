// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.fragments;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.mixerbox.mixerbox3b.utils.MixerBoxClient;

// Referenced classes of package com.mixerbox.mixerbox3b.fragments:
//            VectorFragment

class dlessScrollListener
    implements com.handmark.pulltorefresh.library..OnRefreshListener
{

    final VectorFragment this$0;
    final dlessScrollListener val$scroller;

    public void onRefresh(PullToRefreshBase pulltorefreshbase)
    {
        endList = false;
        dlessScrollListener.access._mth002(val$scroller, 0);
        dlessScrollListener.access._mth102(val$scroller, 0);
        dlessScrollListener.access._mth202(val$scroller, false);
        if (vectorId.equals(""))
        {
            return;
        } else
        {
            class _cls1 extends MixerBoxAsyncHttpResponseHandler
            {

                final VectorFragment._cls2 this$1;

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
                this$1 = VectorFragment._cls2.this;
                super(context);
            }
            }

            MixerBoxClient.get(MixerBoxClient.getVectorUrl(vectorId, 0, vectorType), null, new _cls1(getActivity()));
            return;
        }
    }

    dlessScrollListener()
    {
        this$0 = final_vectorfragment;
        val$scroller = dlessScrollListener.this;
        super();
    }
}
