// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import android.widget.ImageView;

// Referenced classes of package com.jirbo.adcolony:
//            ae, ad

class a
    implements Runnable
{

    final ae a;

    public void run()
    {
        if (!a.c.t && !a.c.u)
        {
            a.b = false;
            a.c.p = true;
            a.c.I.setVisibility(8);
        }
    }

    (ae ae1)
    {
        a = ae1;
        super();
    }
}
