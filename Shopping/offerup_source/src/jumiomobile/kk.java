// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.widget.ImageView;

// Referenced classes of package jumiomobile:
//            kj, bq

class kk
    implements Runnable
{

    final kj a;

    kk(kj kj1)
    {
        a = kj1;
        super();
    }

    public void run()
    {
        if (a.c != null)
        {
            a.c.setVisibility(8);
        }
        if (a.d != null)
        {
            a.d.setVisibility(8);
        }
        if (a.e != null)
        {
            a.e.setVisibility(8);
        }
    }
}
