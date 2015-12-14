// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ck;

import android.view.View;

// Referenced classes of package myobfuscated.ck:
//            e, d

final class t>
    implements android.view.OnClickListener
{

    private e a;

    public final void onClick(View view)
    {
        if (e.k(a) != null)
        {
            e.k(a).j = 0L;
        }
        a.m();
    }

    lickListener(e e1)
    {
        a = e1;
        super();
    }
}
