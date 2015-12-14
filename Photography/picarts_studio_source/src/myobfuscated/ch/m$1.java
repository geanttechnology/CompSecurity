// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ch;

import android.widget.CompoundButton;
import myobfuscated.cg.b;

// Referenced classes of package myobfuscated.ch:
//            m

final class it>
    implements android.widget.oundButton.OnCheckedChangeListener
{

    private m a;

    public final void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        m.a(a, flag);
        if (m.a(a) != null)
        {
            myobfuscated.ch.m.b(a).b(flag);
        }
    }

    undButton(m m1)
    {
        a = m1;
        super();
    }
}
