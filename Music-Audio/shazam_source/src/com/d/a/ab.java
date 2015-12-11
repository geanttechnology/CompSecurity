// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.d.a;

import android.widget.TextView;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.d.a:
//            ag, al, x, aj, 
//            ah

final class ab
    implements Runnable
{

    private List a;

    ab(List list)
    {
        a = list;
        super();
    }

    public final void run()
    {
        for (Iterator iterator = a.iterator(); iterator.hasNext();)
        {
            ag ag1 = (ag)iterator.next();
            if (!ag1.c)
            {
                al al1 = ag1.b();
                if (al1 != null)
                {
                    ag1.removeAllViews();
                    ag1.addView(al1, ag.a());
                    al1.a.a(new x((byte)3, ag1.a.f()));
                    ag1.c = true;
                } else
                if (!ag1.d)
                {
                    TextView textview = new TextView(ag1.b);
                    textview.setText(aj.b);
                    textview.setTextSize(1, 20F);
                    ag1.addView(textview, ag.a());
                }
                ag1.d = true;
            }
        }

    }
}
