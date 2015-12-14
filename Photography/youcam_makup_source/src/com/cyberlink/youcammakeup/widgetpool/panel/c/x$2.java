// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.c;

import android.util.Log;
import android.view.View;
import com.cyberlink.youcammakeup.widgetpool.common.e;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.c:
//            x, r, u

class a
    implements android.view..OnClickListener
{

    final x a;

    public void onClick(View view)
    {
        int j = ((Integer)((e)view).getTag()).intValue();
        int i = x.a(a).a();
        Log.d("LookEffectPanel", (new StringBuilder()).append("Delete position:").append(j).append(", selected position:").append(i).toString());
        view = x.a(a).b(j);
        if (i == j)
        {
            i = 1;
        } else
        if (i > j && !view.i())
        {
            i--;
        } else
        {
            i = -1;
        }
        if (i != -1)
        {
            x.a(a, i, true);
        }
        x.a(a).d(j);
    }

    (x x1)
    {
        a = x1;
        super();
    }
}
