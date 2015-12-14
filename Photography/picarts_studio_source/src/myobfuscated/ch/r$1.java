// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ch;

import android.widget.CompoundButton;
import myobfuscated.cg.b;

// Referenced classes of package myobfuscated.ch:
//            r

final class it>
    implements android.widget.oundButton.OnCheckedChangeListener
{

    private r a;

    public final void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        r.a(a, flag);
        if (r.a(a) != null)
        {
            r.c(a).b(myobfuscated.ch.r.b(a));
        }
    }

    undButton(r r1)
    {
        a = r1;
        super();
    }
}
