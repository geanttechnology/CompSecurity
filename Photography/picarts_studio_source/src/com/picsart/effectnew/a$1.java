// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effectnew;

import android.view.View;
import android.widget.FrameLayout;

// Referenced classes of package com.picsart.effectnew:
//            a, b, d

final class a
    implements android.view..OnClickListener
{

    private View a;
    private a b;

    public final void onClick(View view)
    {
        com.picsart.effectnew.a.a(b).a = ((Integer)view.getTag()).intValue();
        if (com.picsart.effectnew.a.b(b) != null)
        {
            com.picsart.effectnew.a.b(b).a(com.picsart.effectnew.a.a(b));
        }
        int ai[] = b.a;
        for (int i = 0; i < 5; i++)
        {
            int j = ai[i];
            ((FrameLayout)a.findViewById(j)).setBackgroundResource(0x7f0201f8);
        }

        ((FrameLayout)view).setBackgroundResource(0x7f0205a1);
    }

    (a a1, View view)
    {
        b = a1;
        a = view;
        super();
    }
}
