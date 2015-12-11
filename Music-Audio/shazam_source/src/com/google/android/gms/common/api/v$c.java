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
//            v

private final class c
    implements Runnable
{

    final v a;
    private final int b;
    private final ConnectionResult c;

    public final void run()
    {
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
                v.a(a);
            }
            return;
        }
        if (GooglePlayServicesUtil.isUserRecoverableError(c.c))
        {
            GooglePlayServicesUtil.showErrorDialogFragment(c.c, a.getActivity(), a, 2, a);
            return;
        } else
        {
            v.a(a, b, c);
            return;
        }
    }

    public onResult(v v1, int j, ConnectionResult connectionresult)
    {
        a = v1;
        super();
        b = j;
        c = connectionresult;
    }
}
