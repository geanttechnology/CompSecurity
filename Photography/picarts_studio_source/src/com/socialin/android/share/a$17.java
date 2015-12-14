// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.share;

import android.app.Activity;
import com.socialin.android.util.Utils;
import myobfuscated.f.m;

// Referenced classes of package com.socialin.android.share:
//            a

final class a
    implements Runnable
{

    private a a;

    public final void run()
    {
        Utils.a(a.getActivity(), com.socialin.android.share.a.k(a));
        Utils.a(a.getActivity(), 0x7f080473);
        m.b(a.getActivity(), com.socialin.android.share.a.l(a));
        if (a.getActivity() != null && !a.getActivity().isFinishing())
        {
            a.getActivity().finish();
        }
    }

    (a a1)
    {
        a = a1;
        super();
    }
}
