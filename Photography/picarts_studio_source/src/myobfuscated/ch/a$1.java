// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ch;

import android.widget.CompoundButton;
import myobfuscated.cg.b;

// Referenced classes of package myobfuscated.ch:
//            a

final class it>
    implements android.widget.oundButton.OnCheckedChangeListener
{

    private a a;

    public final void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        myobfuscated.ch.a.a(a, flag);
        if (myobfuscated.ch.a.a(a) != null)
        {
            myobfuscated.ch.a.c(a).b(myobfuscated.ch.a.b(a));
        }
    }

    undButton(a a1)
    {
        a = a1;
        super();
    }
}
