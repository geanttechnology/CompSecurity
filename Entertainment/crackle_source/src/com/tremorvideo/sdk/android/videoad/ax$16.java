// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.widget.DatePicker;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            ax, n

class b
    implements android.app.ckerDialog.OnDateSetListener
{

    final c a;
    final String b;
    final ax c;

    public void onDateSet(DatePicker datepicker, int i, int j, int k)
    {
        if (c.f != i || c.g != j || c.h != k)
        {
            c.f = i;
            c.g = j;
            c.h = k;
            for (datepicker = c.j.iterator(); datepicker.hasNext(); ((c)datepicker.next()).(a, c.f, c.g, c.h)) { }
            if (b != null)
            {
                datepicker = c.a.c().c(b);
                if (datepicker != null)
                {
                    c.a(datepicker);
                    c.b(datepicker);
                }
            }
            ax.a(c, true);
        }
    }

    ener(ax ax1, ener ener, String s)
    {
        c = ax1;
        a = ener;
        b = s;
        super();
    }
}
