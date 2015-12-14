// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import com.google.android.gms.common.ConnectionResult;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.google.android.gms.common.api:
//            PendingResult, Api, Scope, zzi

public interface GoogleApiClient
{

    public abstract ConnectionResult blockingConnect();

    public abstract ConnectionResult blockingConnect(long l, TimeUnit timeunit);

    public abstract PendingResult clearDefaultAccountAndReconnect();

    public abstract void connect();

    public abstract void disconnect();

    public abstract void dump(String s, FileDescriptor filedescriptor, PrintWriter printwriter, String as[]);

    public abstract ConnectionResult getConnectionResult(Api api);

    public abstract Context getContext();

    public abstract Looper getLooper();

    public abstract int getSessionId();

    public abstract boolean hasConnectedApi(Api api);

    public abstract boolean isConnected();

    public abstract boolean isConnecting();

    public abstract boolean isConnectionCallbacksRegistered(ConnectionCallbacks connectioncallbacks);

    public abstract boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener onconnectionfailedlistener);

    public abstract void reconnect();

    public abstract void registerConnectionCallbacks(ConnectionCallbacks connectioncallbacks);

    public abstract void registerConnectionFailedListener(OnConnectionFailedListener onconnectionfailedlistener);

    public abstract void stopAutoManage(FragmentActivity fragmentactivity);

    public abstract void unregisterConnectionCallbacks(ConnectionCallbacks connectioncallbacks);

    public abstract void unregisterConnectionFailedListener(OnConnectionFailedListener onconnectionfailedlistener);

    public abstract Api.Client zza(Api.ClientKey clientkey);

    public abstract zza.zza zza(zza.zza zza1);

    public abstract boolean zza(Api api);

    public abstract boolean zza(Scope scope);

    public abstract zza.zza zzb(zza.zza zza1);

    public abstract zzi zzo(Object obj);
}
