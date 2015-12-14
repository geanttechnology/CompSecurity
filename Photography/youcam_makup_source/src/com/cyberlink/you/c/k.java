// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.c;

import android.widget.Filter;
import java.util.TimerTask;

// Referenced classes of package com.cyberlink.you.c:
//            e, f

class k extends TimerTask
{

    final e a;
    private String b;

    public k(e e1, String s)
    {
        a = e1;
        super();
        b = s;
    }

    public void run()
    {
        if (e.a(a) != null)
        {
            e.a(a).getFilter().filter(b);
        }
    }
}
