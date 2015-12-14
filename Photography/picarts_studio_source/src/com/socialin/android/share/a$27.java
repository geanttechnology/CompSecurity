// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.share;

import android.app.Activity;
import com.socialin.android.util.Utils;

// Referenced classes of package com.socialin.android.share:
//            a

final class a
    implements Runnable
{

    private a a;

    public final void run()
    {
        Utils.c(a.getActivity(), a.getString(0x7f0805e9));
        if (com.socialin.android.share.a.j(a))
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
