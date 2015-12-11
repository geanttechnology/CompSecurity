// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.widget.Button;
import android.widget.RelativeLayout;

// Referenced classes of package jumiomobile:
//            kt, mf, kw, lf, 
//            nu

class kv
    implements Runnable
{

    final kt a;

    kv(kt kt1)
    {
        a = kt1;
        super();
    }

    public void run()
    {
        kt.c(a).setVisibility(0);
        a.d(false);
        a.i = true;
        kt.a(a, a.d, 100);
        kt.a(a, a.c, 100);
        Button button = (Button)kt.c(a).findViewById(mf.ao);
        if (button != null)
        {
            button.setOnClickListener(new kw(this));
        }
        button = (Button)kt.c(a).findViewById(mf.ap);
        if (button != null)
        {
            button.setOnClickListener(new lf(a, null));
        }
        kt.a(a).setVisibility(8);
        kt.a(a, true);
    }
}
