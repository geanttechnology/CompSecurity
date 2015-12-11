// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.support.v4.app.t;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzk;
import com.google.android.gms.common.internal.zzx;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Referenced classes of package com.google.android.gms.internal:
//            zzlh, zzlx, zzly, zzlo, 
//            zzlj, zzlf, zzlg, zzlp, 
//            zzlm, zzll

public final class zzli extends GoogleApiClient
{

    private final Context mContext;
    private final int zzaaM;
    private final Looper zzaaO;
    private final GoogleApiAvailability zzaaP;
    final com.google.android.gms.common.api.Api.zza zzaaQ;
    final com.google.android.gms.common.internal.zzf zzabI;
    final Map zzabJ = new HashMap();
    private final Condition zzabY;
    final zzk zzabZ;
    private final Lock zzabt = new ReentrantLock();
    final Queue zzaca = new LinkedList();
    private volatile boolean zzacb;
    private long zzacc;
    private long zzacd;
    private final zza zzace;
    zzd zzacf;
    final Map zzacg = new HashMap();
    final Map zzach = new HashMap();
    Set zzaci;
    private volatile zzlj zzacj;
    private ConnectionResult zzack;
    private final Set zzacl = Collections.newSetFromMap(new WeakHashMap());
    final Set zzacm = Collections.newSetFromMap(new ConcurrentHashMap(16, 0.75F, 2));
    private com.google.android.gms.common.api.zza zzacn;
    private final zze zzaco = new _cls1();
    private final com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks zzacp = new _cls2();
    private final com.google.android.gms.common.internal.zzk.zza zzacq = new _cls3();

    public zzli(Context context, Looper looper, zzf zzf1, GoogleApiAvailability googleapiavailability, com.google.android.gms.common.api.Api.zza zza1, Map map, ArrayList arraylist, 
            ArrayList arraylist1, int i)
    {
        zzacc = 0x1d4c0L;
        zzacd = 5000L;
        zzaci = new HashSet();
        zzack = null;
        mContext = context;
        zzabZ = new zzk(looper, zzacq);
        zzaaO = looper;
        zzace = new zza(looper);
        zzaaP = googleapiavailability;
        zzaaM = i;
        zzabY = zzabt.newCondition();
        zzacj = new zzlh(this);
        for (googleapiavailability = arraylist.iterator(); googleapiavailability.hasNext(); zzabZ.registerConnectionCallbacks(arraylist))
        {
            arraylist = (com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks)googleapiavailability.next();
        }

        for (googleapiavailability = arraylist1.iterator(); googleapiavailability.hasNext(); zzabZ.registerConnectionFailedListener(arraylist))
        {
            arraylist = (com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener)googleapiavailability.next();
        }

        arraylist = zzf1.zzoM();
        arraylist1 = map.keySet().iterator();
        while (arraylist1.hasNext()) 
        {
            Api api = (Api)arraylist1.next();
            googleapiavailability = ((GoogleApiAvailability) (map.get(api)));
            if (arraylist.get(api) != null)
            {
                if (((com.google.android.gms.common.internal.zzf.zza)arraylist.get(api)).zzafk)
                {
                    i = 1;
                } else
                {
                    i = 2;
                }
            } else
            {
                i = 0;
            }
            zzabJ.put(api, Integer.valueOf(i));
            if (api.zzny())
            {
                googleapiavailability = zza(api.zznw(), googleapiavailability, context, looper, zzf1, zzacp, zza(api, i));
            } else
            {
                googleapiavailability = zza(api.zznv(), googleapiavailability, context, looper, zzf1, zzacp, zza(api, i));
            }
            zzacg.put(api.zznx(), googleapiavailability);
        }
        zzabI = zzf1;
        zzaaQ = zza1;
    }

    private void resume()
    {
        zzabt.lock();
        if (zzoc())
        {
            connect();
        }
        zzabt.unlock();
        return;
        Exception exception;
        exception;
        zzabt.unlock();
        throw exception;
    }

    private static com.google.android.gms.common.api.Api.zzb zza(com.google.android.gms.common.api.Api.zza zza1, Object obj, Context context, Looper looper, zzf zzf1, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
    {
        return zza1.zza(context, looper, zzf1, obj, connectioncallbacks, onconnectionfailedlistener);
    }

    private com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener zza(Api api, int i)
    {
        return new _cls4(api, i);
    }

    static com.google.android.gms.common.api.zza zza(zzli zzli1)
    {
        return zzli1.zzacn;
    }

    private static zzac zza(com.google.android.gms.common.api.Api.zze zze1, Object obj, Context context, Looper looper, zzf zzf1, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
    {
        return new zzac(context, looper, zze1.zznA(), connectioncallbacks, onconnectionfailedlistener, zzf1, zze1.zzn(obj));
    }

    private void zza(GoogleApiClient googleapiclient, zzlo zzlo1, boolean flag)
    {
        zzlx.zzagw.zzb(googleapiclient).setResultCallback(new _cls7(zzlo1, flag, googleapiclient));
    }

    private static void zza(zzf zzf1, com.google.android.gms.common.api.zza zza1, IBinder ibinder)
    {
        if (zzf1.isReady())
        {
            zzf1.zza(new zzc(zzf1, zza1, ibinder, null));
            return;
        }
        if (ibinder != null && ibinder.isBinderAlive())
        {
            zzc zzc1 = new zzc(zzf1, zza1, ibinder, null);
            zzf1.zza(zzc1);
            try
            {
                ibinder.linkToDeath(zzc1, 0);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (IBinder ibinder)
            {
                zzf1.cancel();
            }
            zza1.remove(zzf1.zznF().intValue());
            return;
        } else
        {
            zzf1.zza(null);
            zzf1.cancel();
            zza1.remove(zzf1.zznF().intValue());
            return;
        }
    }

    static void zza(zzli zzli1, GoogleApiClient googleapiclient, zzlo zzlo1, boolean flag)
    {
        zzli1.zza(googleapiclient, zzlo1, flag);
    }

    static Lock zzb(zzli zzli1)
    {
        return zzli1.zzabt;
    }

    static zzlj zzc(zzli zzli1)
    {
        return zzli1.zzacj;
    }

    static void zzd(zzli zzli1)
    {
        zzli1.resume();
    }

    static void zze(zzli zzli1)
    {
        zzli1.zzod();
    }

    static int zzf(zzli zzli1)
    {
        return zzli1.zzaaM;
    }

    private void zzod()
    {
        zzabt.lock();
        if (zzof())
        {
            connect();
        }
        zzabt.unlock();
        return;
        Exception exception;
        exception;
        zzabt.unlock();
        throw exception;
    }

    public final ConnectionResult blockingConnect()
    {
        InterruptedException interruptedexception;
        ConnectionResult connectionresult;
        boolean flag;
        if (Looper.myLooper() != Looper.getMainLooper())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zza(flag, "blockingConnect must not be called on the UI thread");
        zzabt.lock();
        connect();
_L1:
        flag = isConnecting();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_86;
        }
        zzabY.await();
          goto _L1
        interruptedexception;
        Thread.currentThread().interrupt();
        connectionresult = new ConnectionResult(15, null);
        zzabt.unlock();
        return connectionresult;
        ConnectionResult connectionresult1;
        if (!isConnected())
        {
            break MISSING_BLOCK_LABEL_108;
        }
        connectionresult1 = ConnectionResult.zzZY;
        zzabt.unlock();
        return connectionresult1;
        if (zzack == null)
        {
            break MISSING_BLOCK_LABEL_131;
        }
        connectionresult1 = zzack;
        zzabt.unlock();
        return connectionresult1;
        connectionresult1 = new ConnectionResult(13, null);
        zzabt.unlock();
        return connectionresult1;
        Exception exception;
        exception;
        zzabt.unlock();
        throw exception;
    }

    public final ConnectionResult blockingConnect(long l, TimeUnit timeunit)
    {
        long l1;
        boolean flag;
        if (Looper.myLooper() != Looper.getMainLooper())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zza(flag, "blockingConnect must not be called on the UI thread");
        zzx.zzb(timeunit, "TimeUnit must not be null");
        zzabt.lock();
        connect();
        l = timeunit.toNanos(l);
_L2:
        flag = isConnecting();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_137;
        }
        l1 = zzabY.awaitNanos(l);
        l = l1;
        if (l1 > 0L) goto _L2; else goto _L1
_L1:
        timeunit = new ConnectionResult(14, null);
        zzabt.unlock();
        return timeunit;
        timeunit;
        Thread.currentThread().interrupt();
        timeunit = new ConnectionResult(15, null);
        zzabt.unlock();
        return timeunit;
        if (!isConnected())
        {
            break MISSING_BLOCK_LABEL_159;
        }
        timeunit = ConnectionResult.zzZY;
        zzabt.unlock();
        return timeunit;
        if (zzack == null)
        {
            break MISSING_BLOCK_LABEL_182;
        }
        timeunit = zzack;
        zzabt.unlock();
        return timeunit;
        timeunit = new ConnectionResult(13, null);
        zzabt.unlock();
        return timeunit;
        timeunit;
        zzabt.unlock();
        throw timeunit;
    }

    public final PendingResult clearDefaultAccountAndReconnect()
    {
        zzx.zza(isConnected(), "GoogleApiClient is not connected yet.");
        zzlo zzlo1 = new zzlo(this);
        if (zzacg.containsKey(zzlx.zzRk))
        {
            zza(this, zzlo1, false);
            return zzlo1;
        } else
        {
            AtomicReference atomicreference = new AtomicReference();
            Object obj = new _cls5(atomicreference, zzlo1);
            _cls6 _lcls6 = new _cls6(zzlo1);
            obj = (new com.google.android.gms.common.api.GoogleApiClient.Builder(mContext)).addApi(zzlx.API).addConnectionCallbacks(((com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks) (obj))).addOnConnectionFailedListener(_lcls6).setHandler(zzace).build();
            atomicreference.set(obj);
            ((GoogleApiClient) (obj)).connect();
            return zzlo1;
        }
    }

    public final void connect()
    {
        zzabt.lock();
        zzacj.connect();
        zzabt.unlock();
        return;
        Exception exception;
        exception;
        zzabt.unlock();
        throw exception;
    }

    public final void disconnect()
    {
        zzabt.lock();
        zzof();
        zzacj.disconnect();
        zzabt.unlock();
        return;
        Exception exception;
        exception;
        zzabt.unlock();
        throw exception;
    }

    public final void dump(String s, FileDescriptor filedescriptor, PrintWriter printwriter, String as[])
    {
        printwriter.append(s).append("mState=").append(zzacj.getName());
        printwriter.append(" mResuming=").print(zzacb);
        printwriter.append(" mWorkQueue.size()=").print(zzaca.size());
        printwriter.append(" mUnconsumedRunners.size()=").println(zzacm.size());
        String s1 = (new StringBuilder()).append(s).append("  ").toString();
        Api api;
        for (Iterator iterator = zzabJ.keySet().iterator(); iterator.hasNext(); ((com.google.android.gms.common.api.Api.zzb)zzacg.get(api.zznx())).dump(s1, filedescriptor, printwriter, as))
        {
            api = (Api)iterator.next();
            printwriter.append(s).append(api.getName()).println(":");
        }

    }

    public final ConnectionResult getConnectionResult(Api api)
    {
        com.google.android.gms.common.api.Api.zzc zzc1;
        zzc1 = api.zznx();
        zzabt.lock();
        if (!isConnected() && !zzoc())
        {
            throw new IllegalStateException("Cannot invoke getConnectionResult unless GoogleApiClient is connected");
        }
        break MISSING_BLOCK_LABEL_51;
        api;
        zzabt.unlock();
        throw api;
        if (!zzacg.containsKey(zzc1))
        {
            break MISSING_BLOCK_LABEL_208;
        }
        if (!((com.google.android.gms.common.api.Api.zzb)zzacg.get(zzc1)).isConnected())
        {
            break MISSING_BLOCK_LABEL_100;
        }
        api = ConnectionResult.zzZY;
        zzabt.unlock();
        return api;
        if (!zzach.containsKey(zzc1))
        {
            break MISSING_BLOCK_LABEL_138;
        }
        api = (ConnectionResult)zzach.get(zzc1);
        zzabt.unlock();
        return api;
        Log.i("GoogleApiClientImpl", zzog());
        Log.wtf("GoogleApiClientImpl", (new StringBuilder()).append(api.getName()).append(" requested in getConnectionResult is not connected but is not present in the failed connections map").toString(), new Exception());
        api = new ConnectionResult(8, null);
        zzabt.unlock();
        return api;
        zzabt.unlock();
        throw new IllegalArgumentException((new StringBuilder()).append(api.getName()).append(" was never registered with GoogleApiClient").toString());
    }

    public final Context getContext()
    {
        return mContext;
    }

    public final Looper getLooper()
    {
        return zzaaO;
    }

    public final int getSessionId()
    {
        return System.identityHashCode(this);
    }

    public final boolean hasConnectedApi(Api api)
    {
        api = (com.google.android.gms.common.api.Api.zzb)zzacg.get(api.zznx());
        return api != null && api.isConnected();
    }

    public final boolean isConnected()
    {
        return zzacj instanceof zzlf;
    }

    public final boolean isConnecting()
    {
        return zzacj instanceof zzlg;
    }

    public final boolean isConnectionCallbacksRegistered(com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks)
    {
        return zzabZ.isConnectionCallbacksRegistered(connectioncallbacks);
    }

    public final boolean isConnectionFailedListenerRegistered(com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
    {
        return zzabZ.isConnectionFailedListenerRegistered(onconnectionfailedlistener);
    }

    public final void reconnect()
    {
        disconnect();
        connect();
    }

    public final void registerConnectionCallbacks(com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks)
    {
        zzabZ.registerConnectionCallbacks(connectioncallbacks);
    }

    public final void registerConnectionFailedListener(com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
    {
        zzabZ.registerConnectionFailedListener(onconnectionfailedlistener);
    }

    public final void stopAutoManage(t t)
    {
        if (zzaaM >= 0)
        {
            zzlp zzlp1 = com.google.android.gms.internal.zzlp.zza(t);
            if (zzlp1 == null)
            {
                (new Handler(mContext.getMainLooper())).post(new _cls8(t));
                return;
            } else
            {
                zzlp1.zzbp(zzaaM);
                return;
            }
        } else
        {
            throw new IllegalStateException("Called stopAutoManage but automatic lifecycle management is not enabled.");
        }
    }

    public final void unregisterConnectionCallbacks(com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks)
    {
        zzabZ.unregisterConnectionCallbacks(connectioncallbacks);
    }

    public final void unregisterConnectionFailedListener(com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
    {
        zzabZ.unregisterConnectionFailedListener(onconnectionfailedlistener);
    }

    public final com.google.android.gms.common.api.Api.zzb zza(com.google.android.gms.common.api.Api.zzc zzc1)
    {
        zzc1 = (com.google.android.gms.common.api.Api.zzb)zzacg.get(zzc1);
        zzx.zzb(zzc1, "Appropriate Api was not requested.");
        return zzc1;
    }

    public final zzlb.zza zza(zzlb.zza zza1)
    {
        boolean flag;
        if (zza1.zznx() != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, "This task can not be enqueued (it's probably a Batch or malformed)");
        zzx.zzb(zzacg.containsKey(zza1.zznx()), "GoogleApiClient is not configured to use the API required for this call.");
        zzabt.lock();
        zza1 = zzacj.zza(zza1);
        zzabt.unlock();
        return zza1;
        zza1;
        zzabt.unlock();
        throw zza1;
    }

    final void zza(zzb zzb1)
    {
        zzb1 = zzace.obtainMessage(3, zzb1);
        zzace.sendMessage(zzb1);
    }

    final void zza(RuntimeException runtimeexception)
    {
        runtimeexception = zzace.obtainMessage(4, runtimeexception);
        zzace.sendMessage(runtimeexception);
    }

    public final boolean zza(Api api)
    {
        return zzacg.containsKey(api.zznx());
    }

    public final zzlb.zza zzb(zzlb.zza zza1)
    {
        zzf zzf1;
        boolean flag;
        if (zza1.zznx() != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, "This task can not be executed (it's probably a Batch or malformed)");
        zzabt.lock();
        if (!zzoc())
        {
            break MISSING_BLOCK_LABEL_113;
        }
        zzaca.add(zza1);
        for (; !zzaca.isEmpty(); zzf1.zzv(Status.zzabd))
        {
            zzf1 = (zzf)zzaca.remove();
            zzb(zzf1);
        }

        break MISSING_BLOCK_LABEL_102;
        zza1;
        zzabt.unlock();
        throw zza1;
        zzabt.unlock();
        return zza1;
        zza1 = zzacj.zzb(zza1);
        zzabt.unlock();
        return zza1;
    }

    final void zzb(zzf zzf1)
    {
        zzacm.add(zzf1);
        zzf1.zza(zzaco);
    }

    final void zzg(ConnectionResult connectionresult)
    {
        zzabt.lock();
        zzack = connectionresult;
        zzacj = new zzlh(this);
        zzacj.begin();
        zzabY.signalAll();
        zzabt.unlock();
        return;
        connectionresult;
        zzabt.unlock();
        throw connectionresult;
    }

    final void zznY()
    {
        for (Iterator iterator = zzacm.iterator(); iterator.hasNext();)
        {
            zzf zzf1 = (zzf)iterator.next();
            zzf1.zza(null);
            if (zzf1.zznF() == null)
            {
                zzf1.cancel();
            } else
            {
                zzf1.zznJ();
                IBinder ibinder = zza(zzf1.zznx()).zznz();
                zza(zzf1, zzacn, ibinder);
            }
        }

        zzacm.clear();
        for (Iterator iterator1 = zzacl.iterator(); iterator1.hasNext(); ((zzlm)iterator1.next()).clear()) { }
        zzacl.clear();
    }

    final void zznZ()
    {
        for (Iterator iterator = zzacg.values().iterator(); iterator.hasNext(); ((com.google.android.gms.common.api.Api.zzb)iterator.next()).disconnect()) { }
    }

    public final zzlm zzo(Object obj)
    {
        zzx.zzb(obj, "Listener must not be null");
        zzabt.lock();
        obj = new zzlm(zzaaO, obj);
        zzacl.add(obj);
        zzabt.unlock();
        return ((zzlm) (obj));
        obj;
        zzabt.unlock();
        throw obj;
    }

    final void zzoa()
    {
        zzabt.lock();
        zzacj = new zzlg(this, zzabI, zzabJ, zzaaP, zzaaQ, zzabt, mContext);
        zzacj.begin();
        zzabY.signalAll();
        zzabt.unlock();
        return;
        Exception exception;
        exception;
        zzabt.unlock();
        throw exception;
    }

    final void zzob()
    {
        zzabt.lock();
        zzof();
        zzacj = new zzlf(this);
        zzacj.begin();
        zzabY.signalAll();
        zzabt.unlock();
        return;
        Exception exception;
        exception;
        zzabt.unlock();
        throw exception;
    }

    final boolean zzoc()
    {
        return zzacb;
    }

    final void zzoe()
    {
        if (zzoc())
        {
            return;
        }
        zzacb = true;
        if (zzacf == null)
        {
            zzacf = (zzd)com.google.android.gms.internal.zzll.zza(mContext.getApplicationContext(), new zzd(), zzaaP);
        }
        zzace.sendMessageDelayed(zzace.obtainMessage(1), zzacc);
        zzace.sendMessageDelayed(zzace.obtainMessage(2), zzacd);
    }

    final boolean zzof()
    {
        if (!zzoc())
        {
            return false;
        }
        zzacb = false;
        zzace.removeMessages(2);
        zzace.removeMessages(1);
        if (zzacf != null)
        {
            zzacf.unregister();
            zzacf = null;
        }
        return true;
    }

    final String zzog()
    {
        StringWriter stringwriter = new StringWriter();
        dump("", null, new PrintWriter(stringwriter), null);
        return stringwriter.toString();
    }

    private class _cls1
        implements zze
    {

        final zzli zzacr;

        public void zzc(zzf zzf1)
        {
            zzacr.zzacm.remove(zzf1);
            if (zzf1.zznF() != null && com.google.android.gms.internal.zzli.zza(zzacr) != null)
            {
                com.google.android.gms.internal.zzli.zza(zzacr).remove(zzf1.zznF().intValue());
            }
        }

        _cls1()
        {
            zzacr = zzli.this;
            super();
        }
    }


    private class _cls2
        implements com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    {

        final zzli zzacr;

        public void onConnected(Bundle bundle)
        {
            zzli.zzb(zzacr).lock();
            zzli.zzc(zzacr).onConnected(bundle);
            zzli.zzb(zzacr).unlock();
            return;
            bundle;
            zzli.zzb(zzacr).unlock();
            throw bundle;
        }

        public void onConnectionSuspended(int i)
        {
            zzli.zzb(zzacr).lock();
            zzli.zzc(zzacr).onConnectionSuspended(i);
            zzli.zzb(zzacr).unlock();
            return;
            Exception exception;
            exception;
            zzli.zzb(zzacr).unlock();
            throw exception;
        }

        _cls2()
        {
            zzacr = zzli.this;
            super();
        }
    }


    private class _cls3
        implements com.google.android.gms.common.internal.zzk.zza
    {

        final zzli zzacr;

        public boolean isConnected()
        {
            return zzacr.isConnected();
        }

        public Bundle zzmS()
        {
            return null;
        }

        _cls3()
        {
            zzacr = zzli.this;
            super();
        }
    }


    private class zza extends Handler
    {

        final zzli zzacr;

        public final void handleMessage(Message message)
        {
            switch (message.what)
            {
            default:
                Log.w("GoogleApiClientImpl", (new StringBuilder("Unknown message id: ")).append(message.what).toString());
                return;

            case 1: // '\001'
                zzli.zze(zzacr);
                return;

            case 2: // '\002'
                zzli.zzd(zzacr);
                return;

            case 3: // '\003'
                ((zzb)message.obj).zzg(zzacr);
                return;

            case 4: // '\004'
                throw (RuntimeException)message.obj;
            }
        }

        zza(Looper looper)
        {
            zzacr = zzli.this;
            super(looper);
        }

        private class zzb
        {

            private final zzlj zzacy;

            public final void zzg(zzli zzli1)
            {
                zzli.zzb(zzli1).lock();
                zzlj zzlj1;
                zzlj zzlj2;
                zzlj1 = zzli.zzc(zzli1);
                zzlj2 = zzacy;
                if (zzlj1 != zzlj2)
                {
                    zzli.zzb(zzli1).unlock();
                    return;
                }
                zznO();
                zzli.zzb(zzli1).unlock();
                return;
                Exception exception;
                exception;
                zzli.zzb(zzli1).unlock();
                throw exception;
            }

            protected abstract void zznO();

            protected zzb(zzlj zzlj1)
            {
                zzacy = zzlj1;
            }
        }

    }


    private class _cls4
        implements com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
    {

        final zzli zzacr;
        final Api zzacs;
        final int zzact;

        public void onConnectionFailed(ConnectionResult connectionresult)
        {
            zzli.zzb(zzacr).lock();
            zzli.zzc(zzacr).zza(connectionresult, zzacs, zzact);
            zzli.zzb(zzacr).unlock();
            return;
            connectionresult;
            zzli.zzb(zzacr).unlock();
            throw connectionresult;
        }

        _cls4(Api api, int i)
        {
            zzacr = zzli.this;
            zzacs = api;
            zzact = i;
            super();
        }
    }


    private class _cls7
        implements ResultCallback
    {

        final GoogleApiClient zzWT;
        final zzli zzacr;
        final zzlo zzacv;
        final boolean zzacw;

        public void onResult(Result result)
        {
            zzo((Status)result);
        }

        public void zzo(Status status)
        {
            if (status.isSuccess() && zzacr.isConnected())
            {
                zzacr.reconnect();
            }
            zzacv.zzb(status);
            if (zzacw)
            {
                zzWT.disconnect();
            }
        }

        _cls7(zzlo zzlo1, boolean flag, GoogleApiClient googleapiclient)
        {
            zzacr = zzli.this;
            zzacv = zzlo1;
            zzacw = flag;
            zzWT = googleapiclient;
            super();
        }
    }


    private class zzf
    {

        public abstract void cancel();

        public abstract boolean isReady();

        public abstract void zza(zze zze1);

        public abstract void zzb(com.google.android.gms.common.api.Api.zzb zzb1);

        public abstract Integer zznF();

        public abstract void zznJ();

        public abstract int zznK();

        public abstract com.google.android.gms.common.api.Api.zzc zznx();

        public abstract void zzv(Status status);

        public abstract void zzw(Status status);
    }


    private class zzc
        implements android.os.IBinder.DeathRecipient, zze
    {

        private final WeakReference zzacA;
        private final WeakReference zzacB;
        private final WeakReference zzacz;

        private void zzoh()
        {
            Object obj = (zzf)zzacz.get();
            com.google.android.gms.common.api.zza zza1 = (com.google.android.gms.common.api.zza)zzacA.get();
            if (zza1 != null && obj != null)
            {
                zza1.remove(((zzf) (obj)).zznF().intValue());
            }
            obj = (IBinder)zzacB.get();
            if (zzacB != null)
            {
                ((IBinder) (obj)).unlinkToDeath(this, 0);
            }
        }

        public void binderDied()
        {
            zzoh();
        }

        public void zzc(zzf zzf1)
        {
            zzoh();
        }

        private zzc(zzf zzf1, com.google.android.gms.common.api.zza zza1, IBinder ibinder)
        {
            zzacA = new WeakReference(zza1);
            zzacz = new WeakReference(zzf1);
            zzacB = new WeakReference(ibinder);
        }

        zzc(zzf zzf1, com.google.android.gms.common.api.zza zza1, IBinder ibinder, _cls1 _pcls1)
        {
            this(zzf1, zza1, ibinder);
        }
    }


    private class _cls5
        implements com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    {

        final zzli zzacr;
        final AtomicReference zzacu;
        final zzlo zzacv;

        public void onConnected(Bundle bundle)
        {
            com.google.android.gms.internal.zzli.zza(zzacr, (GoogleApiClient)zzacu.get(), zzacv, true);
        }

        public void onConnectionSuspended(int i)
        {
        }

        _cls5(AtomicReference atomicreference, zzlo zzlo1)
        {
            zzacr = zzli.this;
            zzacu = atomicreference;
            zzacv = zzlo1;
            super();
        }
    }


    private class _cls6
        implements com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
    {

        final zzli zzacr;
        final zzlo zzacv;

        public void onConnectionFailed(ConnectionResult connectionresult)
        {
            zzacv.zzb(new Status(8));
        }

        _cls6(zzlo zzlo1)
        {
            zzacr = zzli.this;
            zzacv = zzlo1;
            super();
        }
    }


    private class _cls8
        implements Runnable
    {

        final zzli zzacr;
        final t zzacx;

        public void run()
        {
            if (zzacx.isFinishing() || zzacx.getSupportFragmentManager().e())
            {
                return;
            } else
            {
                zzlp.zzb(zzacx).zzbp(com.google.android.gms.internal.zzli.zzf(zzacr));
                return;
            }
        }

        _cls8(t t1)
        {
            zzacr = zzli.this;
            zzacx = t1;
            super();
        }
    }


    private class zzd extends zzll
    {

        private WeakReference zzacC;

        public void zzoi()
        {
            zzli zzli1 = (zzli)zzacC.get();
            if (zzli1 == null)
            {
                return;
            } else
            {
                zzli.zzd(zzli1);
                return;
            }
        }

        zzd()
        {
            zzacC = new WeakReference(zzli.this);
        }
    }

}
