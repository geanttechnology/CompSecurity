// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ck;

import android.view.View;
import android.widget.Spinner;

// Referenced classes of package myobfuscated.ck:
//            a

final class it>
    implements android.view..OnClickListener
{

    private a a;

    public final void onClick(View view)
    {
        view = myobfuscated.ck.a.K(a);
        if (view != null)
        {
            view.performClick();
        }
    }

    er(a a1)
    {
        a = a1;
        super();
    }
}
