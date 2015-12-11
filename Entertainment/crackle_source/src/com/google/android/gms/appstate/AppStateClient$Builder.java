// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.appstate;

import android.content.Context;
import com.google.android.gms.internal.eg;

// Referenced classes of package com.google.android.gms.appstate:
//            AppStateClient

public static final class jG
{

    private static final String jC[] = {
        "https://www.googleapis.com/auth/appstate"
    };
    private com.google.android.gms.common.t.ConnectionCallbacks jD;
    private com.google.android.gms.common.t.OnConnectionFailedListener jE;
    private String jF[];
    private String jG;
    private Context mContext;

    public AppStateClient create()
    {
        return new AppStateClient(mContext, jD, jE, jG, jF, null);
    }

    public ner setAccountName(String s)
    {
        jG = (String)eg.f(s);
        return this;
    }

    public transient jG setScopes(String as[])
    {
        jF = as;
        return this;
    }


    public ner(Context context, com.google.android.gms.common.t.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.t.OnConnectionFailedListener onconnectionfailedlistener)
    {
        mContext = context;
        jD = connectioncallbacks;
        jE = onconnectionfailedlistener;
        jF = jC;
        jG = "<<default account>>";
    }
}
