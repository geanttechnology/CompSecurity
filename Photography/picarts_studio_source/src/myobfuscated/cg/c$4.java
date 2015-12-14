// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.cg;

import android.widget.CompoundButton;

// Referenced classes of package myobfuscated.cg:
//            c

final class it>
    implements android.widget.oundButton.OnCheckedChangeListener
{

    private c a;

    public final void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        int i = ((Integer)compoundbutton.getTag()).intValue();
        a.a(i, flag);
    }

    undButton(c c1)
    {
        a = c1;
        super();
    }
}
