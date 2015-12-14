// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ch;

import android.view.View;
import android.widget.LinearLayout;

// Referenced classes of package myobfuscated.ch:
//            d

final class it>
    implements android.view..OnClickListener
{

    private d a;

    public final void onClick(View view)
    {
        d.a(a, d.a(a));
        if (view.getId() == 0x7f10040e)
        {
            d.a(a, 0);
            d.a(a).findViewById(0x7f10040d).setVisibility(0);
        } else
        {
            if (view.getId() == 0x7f100410)
            {
                d.a(a, 1);
                d.a(a).findViewById(0x7f10040f).setVisibility(0);
                return;
            }
            if (view.getId() == 0x7f100412)
            {
                d.a(a, 2);
                d.a(a).findViewById(0x7f100411).setVisibility(0);
                return;
            }
            if (view.getId() == 0x7f100414)
            {
                d.a(a, 3);
                d.a(a).findViewById(0x7f100413).setVisibility(0);
                return;
            }
            if (view.getId() == 0x7f100416)
            {
                d.a(a, 4);
                d.a(a).findViewById(0x7f100415).setVisibility(0);
                return;
            }
        }
    }

    rLayout(d d1)
    {
        a = d1;
        super();
    }
}
