// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.view.MenuItem;
import android.view.View;

final class ko extends gw
{

    private kn g;

    public ko(kn kn1, Context context, hb hb1)
    {
        boolean flag1 = false;
        g = kn1;
        super(context, hb1, null, false, 0x7f01008d);
        int i;
        if (!((gv)hb1.getItem()).e())
        {
            int j;
            boolean flag;
            if (kn1.c == null)
            {
                context = (View)null;
            } else
            {
                context = kn1.c;
            }
            super.b = context;
        }
        super.d = kn1.g;
        j = hb1.size();
        i = 0;
        do
        {
label0:
            {
                flag = flag1;
                if (i < j)
                {
                    kn1 = hb1.getItem(i);
                    if (!kn1.isVisible() || kn1.getIcon() == null)
                    {
                        break label0;
                    }
                    flag = true;
                }
                super.e = flag;
                return;
            }
            i++;
        } while (true);
    }

    public final void onDismiss()
    {
        super.onDismiss();
        g.e = null;
        kn kn1 = g;
    }
}
