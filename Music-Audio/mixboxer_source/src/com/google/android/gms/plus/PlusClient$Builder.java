// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.plus;

import android.content.Context;
import com.google.android.gms.internal.hs;
import com.google.android.gms.internal.hv;

// Referenced classes of package com.google.android.gms.plus:
//            PlusClient

public static class mContext
{

    private final hv DA;
    private final com.google.android.gms.common.lient.ConnectionCallbacks Dz;
    private final com.google.android.gms.common.lient.OnConnectionFailedListener jE;
    private final Context mContext;

    public PlusClient build()
    {
        return new PlusClient(new hs(mContext, Dz, jE, DA.eZ()));
    }

    public DA clearScopes()
    {
        DA.eY();
        return this;
    }

    public DA setAccountName(String s)
    {
        DA.aA(s);
        return this;
    }

    public transient DA setActions(String as[])
    {
        DA.e(as);
        return this;
    }

    public transient DA setScopes(String as[])
    {
        DA.d(as);
        return this;
    }

    public nFailedListener(Context context, com.google.android.gms.common.lient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.lient.OnConnectionFailedListener onconnectionfailedlistener)
    {
        mContext = context;
        Dz = connectioncallbacks;
        jE = onconnectionfailedlistener;
        DA = new hv(mContext);
    }
}
