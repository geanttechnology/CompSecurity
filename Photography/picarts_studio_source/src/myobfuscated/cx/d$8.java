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

    private String a;
    private d b;

    public final void run()
    {
        if (d.c(b) != null)
        {
            d.c(b).setText(a);
            d.c(b).setVisibility(0);
        }
        if (d.d(b) != null)
        {
            d.d(b).setVisibility(8);
        }
    }

    iew(d d1, String s)
    {
        b = d1;
        a = s;
        super();
    }
}
