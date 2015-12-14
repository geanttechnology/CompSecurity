// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.cx;

import android.widget.GridView;
import android.widget.LinearLayout;

// Referenced classes of package myobfuscated.cx:
//            a, c

final class it>
    implements Runnable
{

    private a a;

    public final void run()
    {
        if (myobfuscated.cx.a.f(a))
        {
            myobfuscated.cx.a.h(a).setAdapter(myobfuscated.cx.a.g(a));
            myobfuscated.cx.a.h(a).invalidate();
            return;
        }
        myobfuscated.cx.a.i(a).removeAllViews();
        for (int i = 0; i < myobfuscated.cx.a.g(a).getCount(); i++)
        {
            android.view.View view = myobfuscated.cx.a.g(a).getView(i, null, myobfuscated.cx.a.i(a));
            myobfuscated.cx.a.i(a).addView(view);
        }

        myobfuscated.cx.a.i(a).invalidate();
    }

    rLayout(a a1)
    {
        a = a1;
        super();
    }
}
