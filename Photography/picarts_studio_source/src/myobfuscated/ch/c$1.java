// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ch;

import android.widget.CompoundButton;
import myobfuscated.cg.b;

// Referenced classes of package myobfuscated.ch:
//            c

final class it>
    implements android.widget.oundButton.OnCheckedChangeListener
{

    private c a;

    public final void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        c.a(a, flag);
        if (c.a(a) != null)
        {
            c.c(a).b(myobfuscated.ch.c.b(a));
        }
    }

    undButton(c c1)
    {
        a = c1;
        super();
    }
}
