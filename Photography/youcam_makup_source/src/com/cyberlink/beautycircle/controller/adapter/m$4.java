// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.adapter;

import android.view.View;
import com.huewu.pla.lib.internal.PLA_AdapterView;
import com.huewu.pla.lib.internal.PLA_ListView;
import com.huewu.pla.lib.internal.n;
import com.perfectcorp.model.Model;

// Referenced classes of package com.cyberlink.beautycircle.controller.adapter:
//            m

class a
    implements n
{

    final m a;

    public boolean a(PLA_AdapterView pla_adapterview, View view, int i, long l)
    {
        int j = i;
        if (pla_adapterview instanceof PLA_ListView)
        {
            j = i - ((PLA_ListView)pla_adapterview).getHeaderViewsCount();
        }
        if (j >= 0 && j < a.getCount())
        {
            a.b((Model)a.getItem(j));
        }
        return true;
    }

    (m m1)
    {
        a = m1;
        super();
    }
}
