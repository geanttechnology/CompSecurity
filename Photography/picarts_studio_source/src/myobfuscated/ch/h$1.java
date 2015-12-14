// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ch;

import android.widget.CompoundButton;
import myobfuscated.cg.b;

// Referenced classes of package myobfuscated.ch:
//            h

final class it>
    implements android.widget.oundButton.OnCheckedChangeListener
{

    private h a;

    public final void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        h.a(a, flag);
        if (h.a(a) != null)
        {
            myobfuscated.ch.h.b(a).b(flag);
        }
    }

    undButton(h h1)
    {
        a = h1;
        super();
    }
}
