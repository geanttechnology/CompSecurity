// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.view.View;

// Referenced classes of package com.wishabi.flipp.widget:
//            dz, ee, ec

final class ea
    implements android.view.View.OnClickListener
{

    final dz a;

    ea(dz dz1)
    {
        a = dz1;
        super();
    }

    public final void onClick(View view)
    {
        int i = 0;
        do
        {
label0:
            {
                if (i < dz.a(a).getChildCount())
                {
                    if (view != dz.a(a).getChildAt(i))
                    {
                        break label0;
                    }
                    if (dz.b(a) != null && dz.b(a).a(dz.a(a).a, i))
                    {
                        dz.a(a, i);
                    }
                }
                return;
            }
            i++;
        } while (true);
    }
}
