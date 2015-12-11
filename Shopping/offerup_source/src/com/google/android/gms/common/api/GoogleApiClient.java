// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Looper;
import android.support.v4.app.t;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.internal.zzlm;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.google.android.gms.common.api:
//            PendingResult, Api

public abstract class GoogleApiClient
{

    public GoogleApiClient()
    {
    }

    public abstract ConnectionResult blockingConnect();

    public abstract ConnectionResult blockingConnect(long l, TimeUnit timeunit);

    public abstract PendingResult clearDefaultAccountAndReconnect();

    public abstract void connect();

    public abstract void disconnect();

    public abstract void dump(String s, FileDescriptor filedescriptor, PrintWriter printwriter, String as[]);

    public abstract ConnectionResult getConnectionResult(Api api);

    public Context getContext()
    {
        throw new UnsupportedOperationException();
    }

    public Looper getLooper()
    {
        throw new UnsupportedOperationException();
    }

    public int getSessionId()
    {
        throw new UnsupportedOperationException();
    }

    public abstract boolean hasConnectedApi(Api api);

    public abstract boolean isConnected();

    public abstract boolean isConnecting();

    public abstract boolean isConnectionCallbacksRegistered(ConnectionCallbacks connectioncallbacks);

    public abstract boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener onconnectionfailedlistener);

    public abstract void reconnect();

    public abstract void registerConnectionCallbacks(ConnectionCallbacks connectioncallbacks);

    public abstract void registerConnectionFailedListener(OnConnectionFailedListener onconnectionfailedlistener);

    public abstract void stopAutoManage(t t);

    public abstract void unregisterConnectionCallbacks(ConnectionCallbacks connectioncallbacks);

    public abstract void unregisterConnectionFailedListener(OnConnectionFailedListener onconnectionfailedlistener);

    public Api.zzb zza(Api.zzc zzc)
    {
        throw new UnsupportedOperationException();
    }

    public com.google.android.gms.internal.zzlb.zza zza(com.google.android.gms.internal.zzlb.zza zza1)
    {
        throw new UnsupportedOperationException();
    }

    public boolean zza(Api api)
    {
        throw new UnsupportedOperationException();
    }

    public com.google.android.gms.internal.zzlb.zza zzb(com.google.android.gms.internal.zzlb.zza zza1)
    {
        throw new UnsupportedOperationException();
    }

    public zzlm zzo(Object obj)
    {
        throw new UnsupportedOperationException();
    }
}
