// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ch;

import android.widget.CompoundButton;
import myobfuscated.cg.b;

// Referenced classes of package myobfuscated.ch:
//            g

final class it>
    implements android.widget.oundButton.OnCheckedChangeListener
{

    private g a;

    public final void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        g.a(a, flag);
        if (g.a(a) != null)
        {
            g.c(a).b(myobfuscated.ch.g.b(a));
        }
    }

    undButton(g g1)
    {
        a = g1;
        super();
    }
}
