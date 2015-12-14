// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.cx;

import android.app.Activity;
import com.socialin.android.util.aj;

// Referenced classes of package myobfuscated.cx:
//            a

final class it>
    implements aj
{

    private a a;

    public final void a()
    {
        if (a.getActivity() != null && !a.getActivity().isFinishing())
        {
            myobfuscated.cx.a.a(a, true);
        }
    }

    public final void b()
    {
        if (a.getActivity() != null && !a.getActivity().isFinishing())
        {
            myobfuscated.cx.a.a(a, false);
        }
    }

    (a a1)
    {
        a = a1;
        super();
    }
}
