// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.TextView;
import com.cyberlink.beautycircle.m;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            SearchActivity

class a
    implements Runnable
{

    final boolean a;
    final SearchActivity b;

    public void run()
    {
        if (a)
        {
            String s = b.getResources().getString(m.bc_search_empty_message, new Object[] {
                TextUtils.join(" ", SearchActivity.p(b))
            });
            SearchActivity.q(b).setText(s);
        } else
        {
            SearchActivity.q(b).setText("");
        }
        SearchActivity.b(b, a);
    }

    (SearchActivity searchactivity, boolean flag)
    {
        b = searchactivity;
        a = flag;
        super();
    }
}
