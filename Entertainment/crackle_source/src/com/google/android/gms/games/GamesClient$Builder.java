// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games;

import android.content.Context;
import android.view.View;
import com.google.android.gms.internal.eg;

// Referenced classes of package com.google.android.gms.games:
//            GamesClient

public static final class jE
{

    private final com.google.android.gms.common.ient.ConnectionCallbacks jD;
    private final com.google.android.gms.common.ient.OnConnectionFailedListener jE;
    private String jF[] = {
        "https://www.googleapis.com/auth/games"
    };
    private String jG;
    private final Context mContext;
    private boolean tA;
    private int tB;
    private String tx;
    private int ty;
    private View tz;

    public GamesClient create()
    {
        return new GamesClient(mContext, tx, jG, jD, jE, jF, ty, tz, tA, tB, null);
    }

    public iledListener setAccountName(String s)
    {
        jG = (String)eg.f(s);
        return this;
    }

    public jG setGravityForPopups(int i)
    {
        ty = i;
        return this;
    }

    public transient ty setScopes(String as[])
    {
        jF = as;
        return this;
    }

    public jF setShowConnectingPopup(boolean flag)
    {
        tA = flag;
        tB = 17;
        return this;
    }

    public tB setShowConnectingPopup(boolean flag, int i)
    {
        tA = flag;
        tB = i;
        return this;
    }

    public tB setViewForPopups(View view)
    {
        tz = (View)eg.f(view);
        return this;
    }

    public iledListener(Context context, com.google.android.gms.common.ient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.ient.OnConnectionFailedListener onconnectionfailedlistener)
    {
        jG = "<<default account>>";
        ty = 49;
        tA = true;
        tB = 17;
        mContext = context;
        tx = context.getPackageName();
        jD = connectioncallbacks;
        jE = onconnectionfailedlistener;
    }
}
