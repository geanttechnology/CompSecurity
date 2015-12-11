// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.internal.ee;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Referenced classes of package com.google.android.gms.common.api:
//            Scope

public final class Api
{
    public static interface a
    {

        public abstract void connect();

        public abstract void disconnect();

        public abstract Looper getLooper();

        public abstract boolean isConnected();
    }

    public static interface b
    {

        public abstract a b(Context context, Looper looper, ee ee, GoogleApiClient.ApiOptions apioptions, GoogleApiClient.ConnectionCallbacks connectioncallbacks, GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener);

        public abstract int getPriority();
    }


    private final b za;
    private final ArrayList zb;

    public transient Api(b b1, Scope ascope[])
    {
        za = b1;
        zb = new ArrayList(Arrays.asList(ascope));
    }

    public b dp()
    {
        return za;
    }

    public List dq()
    {
        return zb;
    }
}
