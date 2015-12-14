// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.adapter;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.perfectcorp.model.Model;

// Referenced classes of package com.cyberlink.beautycircle.controller.adapter:
//            m

class a
    implements android.widget.terView.OnItemClickListener
{

    final m a;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        int j = i;
        if (adapterview instanceof ListView)
        {
            j = i - ((ListView)adapterview).getHeaderViewsCount();
        }
        if (j >= 0 && j < a.getCount())
        {
            a.a((Model)a.getItem(j));
        }
    }

    (m m1)
    {
        a = m1;
        super();
    }
}
