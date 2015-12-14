// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.widget.EditText;
import com.cyberlink.beautycircle.controller.adapter.m;
import com.cyberlink.beautycircle.view.widgetpool.common.BiDirectionSwipeRefreshLayout;
import com.cyberlink.beautycircle.view.widgetpool.common.CLMultiColumnListView;
import com.huewu.pla.lib.internal.q;
import com.perfectcorp.utility.e;
import java.util.ArrayList;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            SearchActivity, s, q

class a
    implements android.support.v4.widget.t.OnRefreshListener
{

    final SearchActivity a;

    public void onRefresh()
    {
        Object obj;
label0:
        {
            String s1;
label1:
            {
                if (!SearchActivity.p(a).isEmpty())
                {
                    break label0;
                }
                if (SearchActivity.d(a) != null)
                {
                    SearchActivity.d(a).setHint(SearchActivity.s(a).d);
                    s1 = SearchActivity.d(a).getText().toString();
                    if (s1.length() > 0)
                    {
                        break label1;
                    }
                    SearchActivity.s(a).a();
                }
                return;
            }
            SearchActivity.s(a).a(s1);
            return;
        }
        obj = SearchActivity.a(a).getAdapter();
        if (!(obj instanceof q)) goto _L2; else goto _L1
_L1:
        android.widget.ListAdapter listadapter;
        obj = (q)obj;
        listadapter = ((q) (obj)).getWrappedAdapter();
        if (!(listadapter instanceof m)) goto _L4; else goto _L3
_L3:
        obj = (m)((q) (obj)).getWrappedAdapter();
_L5:
        if (obj != null)
        {
            SearchActivity.b(a).a();
            ((m) (obj)).c();
            return;
        } else
        {
            SearchActivity.f(a).setRefreshing(false);
            return;
        }
_L4:
        e.e(new Object[] {
            "Unexpected adapter class: ", listadapter.getClass()
        });
_L6:
        obj = null;
          goto _L5
_L2:
label2:
        {
            if (!obj.getClass().isAssignableFrom(com/cyberlink/beautycircle/controller/adapter/m))
            {
                break label2;
            }
            obj = (m)obj;
        }
          goto _L5
        e.e(new Object[] {
            "Unexpected adapter class: ", obj.getClass()
        });
          goto _L6
    }

    peRefreshLayout(SearchActivity searchactivity)
    {
        a = searchactivity;
        super();
    }
}
