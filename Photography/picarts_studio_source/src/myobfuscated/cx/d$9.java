// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.cx;

import android.view.View;
import android.widget.TextView;

// Referenced classes of package myobfuscated.cx:
//            d

final class it>
    implements Runnable
{

    private d a;

    public final void run()
    {
        if (d.c(a) != null)
        {
            d.c(a).setVisibility(8);
        }
        if (d.d(a) != null)
        {
            d.d(a).setVisibility(8);
        }
    }

    iew(d d1)
    {
        a = d1;
        super();
    }
}
