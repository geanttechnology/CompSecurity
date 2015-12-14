// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ch;

import android.widget.CompoundButton;
import myobfuscated.cg.b;

// Referenced classes of package myobfuscated.ch:
//            u

final class it>
    implements android.widget.oundButton.OnCheckedChangeListener
{

    private u a;

    public final void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        u.a(a, flag);
        if (u.a(a) != null)
        {
            u.c(a).b(myobfuscated.ch.u.b(a));
        }
    }

    undButton(u u1)
    {
        a = u1;
        super();
    }
}
