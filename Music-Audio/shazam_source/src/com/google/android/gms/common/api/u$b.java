// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import android.support.v4.app.i;
import android.support.v4.app.k;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import java.util.List;

// Referenced classes of package com.google.android.gms.common.api:
//            u

private final class c
    implements Runnable
{

    final u a;
    private final int b;
    private final ConnectionResult c;

    public final void run()
    {
        if (!u.a(a) || u.b(a))
        {
            return;
        }
        u.c(a);
        u.a(a, b);
        u.a(a, c);
        if (c.a())
        {
            try
            {
                int j = a.getActivity().getSupportFragmentManager().f().indexOf(a);
                c.a(a.getActivity(), (j + 1 << 16) + 1);
                return;
            }
            catch (android.content.ntSender.SendIntentException sendintentexception)
            {
                u.d(a);
            }
            return;
        }
        if (GooglePlayServicesUtil.isUserRecoverableError(c.c))
        {
            GooglePlayServicesUtil.showErrorDialogFragment(c.c, a.getActivity(), a, 2, a);
            return;
        } else
        {
            u.a(a, b, c);
            return;
        }
    }

    public onResult(u u1, int j, ConnectionResult connectionresult)
    {
        a = u1;
        super();
        b = j;
        c = connectionresult;
    }
}
