// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Scope;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.google.android.gms.common.internal:
//            zzl, zzx, zzf, ValidateAccountRequest, 
//            zzs, GetServiceRequest, zzp

public abstract class zzj
    implements com.google.android.gms.common.api.Api.zzb, zzk.zza
{

    public static final String zzafI[] = {
        "service_esmobile", "service_googleme"
    };
    private final Context mContext;
    final Handler mHandler;
    private final Account zzQd;
    private final Set zzTm;
    private final Looper zzaaO;
    private final GoogleApiAvailability zzaaP;
    private final com.google.android.gms.common.internal.zzf zzabI;
    private IInterface zzafA;
    private final ArrayList zzafB;
    private zze zzafC;
    private int zzafD;
    private final com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks zzafE;
    private final com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener zzafF;
    private final int zzafG;
    protected AtomicInteger zzafH;
    private final zzl zzafx;
    private zzs zzafy;
    private com.google.android.gms.common.api.GoogleApiClient.zza zzafz;
    private final Object zzpd;

    protected zzj(Context context, Looper looper, int i, zzf zzf1, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
    {
        this(context, looper, zzl.zzal(context), GoogleApiAvailability.getInstance(), i, zzf1, (com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks)zzx.zzw(connectioncallbacks), (com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener)zzx.zzw(onconnectionfailedlistener));
    }

    protected zzj(Context context, Looper looper, zzl zzl1, GoogleApiAvailability googleapiavailability, int i, zzf zzf1, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, 
            com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
    {
        zzpd = new Object();
        zzafB = new ArrayList();
        zzafD = 1;
        zzafH = new AtomicInteger(0);
        mContext = (Context)zzx.zzb(context, "Context must not be null");
        zzaaO = (Looper)zzx.zzb(looper, "Looper must not be null");
        zzafx = (zzl)zzx.zzb(zzl1, "Supervisor must not be null");
        zzaaP = (GoogleApiAvailability)zzx.zzb(googleapiavailability, "API availability must not be null");
        mHandler = new zzb(looper);
        zzafG = i;
        zzabI = (zzf)zzx.zzw(zzf1);
        zzQd = zzf1.getAccount();
        zzTm = zza(zzf1.zzoL());
        zzafE = connectioncallbacks;
        zzafF = onconnectionfailedlistener;
    }

    static com.google.android.gms.common.api.GoogleApiClient.zza zza(zzj zzj1)
    {
        return zzj1.zzafz;
    }

    static zzs zza(zzj zzj1, zzs zzs1)
    {
        zzj1.zzafy = zzs1;
        return zzs1;
    }

    private Set zza(Set set)
    {
        Set set1 = zzb(set);
        if (set1 == null)
        {
            return set1;
        }
        for (Iterator iterator = set1.iterator(); iterator.hasNext();)
        {
            if (!set.contains((Scope)iterator.next()))
            {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }

        return set1;
    }

    static void zza(zzj zzj1, int i, IInterface iinterface)
    {
        zzj1.zzb(i, iinterface);
    }

    private boolean zza(int i, int j, IInterface iinterface)
    {
label0:
        {
            synchronized (zzpd)
            {
                if (zzafD == i)
                {
                    break label0;
                }
            }
            return false;
        }
        zzb(j, iinterface);
        obj;
        JVM INSTR monitorexit ;
        return true;
        iinterface;
        obj;
        JVM INSTR monitorexit ;
        throw iinterface;
    }

    static boolean zza(zzj zzj1, int i, int j, IInterface iinterface)
    {
        return zzj1.zza(i, j, iinterface);
    }

    static com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks zzb(zzj zzj1)
    {
        return zzj1.zzafE;
    }

    private void zzb(int i, IInterface iinterface)
    {
        boolean flag2 = true;
        Object obj;
        boolean flag;
        boolean flag1;
        if (i == 3)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (iinterface != null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag != flag1)
        {
            flag2 = false;
        }
        zzx.zzaa(flag2);
        obj = zzpd;
        obj;
        JVM INSTR monitorenter ;
        zzafD = i;
        zzafA = iinterface;
        zzc(i, iinterface);
        i;
        JVM INSTR tableswitch 1 3: default 109
    //                   1 102
    //                   2 83
    //                   3 95;
           goto _L1 _L2 _L3 _L4
_L1:
        obj;
        JVM INSTR monitorexit ;
        return;
_L3:
        zzoX();
          goto _L1
        iinterface;
        obj;
        JVM INSTR monitorexit ;
        throw iinterface;
_L4:
        zzoW();
          goto _L1
_L2:
        zzoY();
          goto _L1
    }

    static ArrayList zzc(zzj zzj1)
    {
        return zzj1.zzafB;
    }

    static Set zzd(zzj zzj1)
    {
        return zzj1.zzTm;
    }

    static com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener zze(zzj zzj1)
    {
        return zzj1.zzafF;
    }

    private void zzoX()
    {
        if (zzafC != null)
        {
            Log.e("GmsClient", (new StringBuilder("Calling connect() while still connected, missing disconnect() for ")).append(zzfK()).toString());
            zzafx.zzb(zzfK(), zzafC, zzoV());
            zzafH.incrementAndGet();
        }
        zzafC = new zze(zzafH.get());
        if (!zzafx.zza(zzfK(), zzafC, zzoV()))
        {
            Log.e("GmsClient", (new StringBuilder("unable to connect to service: ")).append(zzfK()).toString());
            mHandler.sendMessage(mHandler.obtainMessage(3, zzafH.get(), 9));
        }
    }

    private void zzoY()
    {
        if (zzafC != null)
        {
            zzafx.zzb(zzfK(), zzafC, zzoV());
            zzafC = null;
        }
    }

    public void disconnect()
    {
        zzafH.incrementAndGet();
        ArrayList arraylist = zzafB;
        arraylist;
        JVM INSTR monitorenter ;
        int j = zzafB.size();
        int i = 0;
_L2:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        ((zzc)zzafB.get(i)).zzpi();
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        zzafB.clear();
        arraylist;
        JVM INSTR monitorexit ;
        zzb(1, null);
        return;
        Exception exception;
        exception;
        arraylist;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void dump(String s, FileDescriptor filedescriptor, PrintWriter printwriter, String as[])
    {
        int i;
        synchronized (zzpd)
        {
            i = zzafD;
            as = zzafA;
        }
        printwriter.append(s).append("mConnectState=");
        i;
        JVM INSTR tableswitch 1 4: default 64
    //                   1 127
    //                   2 97
    //                   3 107
    //                   4 117;
           goto _L1 _L2 _L3 _L4 _L5
_L2:
        break MISSING_BLOCK_LABEL_127;
_L1:
        printwriter.print("UNKNOWN");
_L6:
        printwriter.append(" mService=");
        if (as == null)
        {
            printwriter.println("null");
            return;
        } else
        {
            printwriter.append(zzfL()).append("@").println(Integer.toHexString(System.identityHashCode(as.asBinder())));
            return;
        }
        s;
        filedescriptor;
        JVM INSTR monitorexit ;
        throw s;
_L3:
        printwriter.print("CONNECTING");
          goto _L6
_L4:
        printwriter.print("CONNECTED");
          goto _L6
_L5:
        printwriter.print("DISCONNECTING");
          goto _L6
        printwriter.print("DISCONNECTED");
          goto _L6
    }

    public final Context getContext()
    {
        return mContext;
    }

    public final Looper getLooper()
    {
        return zzaaO;
    }

    public boolean isConnected()
    {
        Object obj = zzpd;
        obj;
        JVM INSTR monitorenter ;
        Exception exception;
        boolean flag;
        if (zzafD == 3)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj;
        JVM INSTR monitorexit ;
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean isConnecting()
    {
        Object obj = zzpd;
        obj;
        JVM INSTR monitorenter ;
        Exception exception;
        boolean flag;
        if (zzafD == 2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj;
        JVM INSTR monitorexit ;
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected void onConnectionFailed(ConnectionResult connectionresult)
    {
    }

    protected void onConnectionSuspended(int i)
    {
    }

    protected abstract IInterface zzW(IBinder ibinder);

    protected void zza(int i, Bundle bundle, int j)
    {
        mHandler.sendMessage(mHandler.obtainMessage(5, j, -1, new zzi(i, bundle)));
    }

    protected void zza(int i, IBinder ibinder, Bundle bundle, int j)
    {
        mHandler.sendMessage(mHandler.obtainMessage(1, j, -1, new zzg(i, ibinder, bundle)));
    }

    public void zza(com.google.android.gms.common.api.GoogleApiClient.zza zza1)
    {
        zzafz = (com.google.android.gms.common.api.GoogleApiClient.zza)zzx.zzb(zza1, "Connection progress callbacks cannot be null.");
        zzb(2, null);
    }

    public void zza(zzp zzp)
    {
        Bundle bundle = zzpd();
        zzp = new ValidateAccountRequest(zzp, (Scope[])zzTm.toArray(new Scope[zzTm.size()]), mContext.getPackageName(), bundle);
        try
        {
            zzafy.zza(new zzd(zzafH.get()), zzp);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (zzp zzp)
        {
            Log.w("GmsClient", "service died");
            zzbE(1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (zzp zzp)
        {
            Log.w("GmsClient", "Remote exception occurred", zzp);
        }
    }

    public void zza(zzp zzp, Set set)
    {
        Object obj;
        try
        {
            obj = zzly();
            obj = (new GetServiceRequest(zzafG)).zzcl(mContext.getPackageName()).zzg(((Bundle) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (zzp zzp)
        {
            Log.w("GmsClient", "service died");
            zzbE(1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (zzp zzp)
        {
            Log.w("GmsClient", "Remote exception occurred", zzp);
            return;
        }
        if (set == null)
        {
            break MISSING_BLOCK_LABEL_41;
        }
        ((GetServiceRequest) (obj)).zzd(set);
        if (!zzlN()) goto _L2; else goto _L1
_L1:
        ((GetServiceRequest) (obj)).zzc(zzoI()).zzc(zzp);
_L4:
        zzafy.zza(new zzd(zzafH.get()), ((GetServiceRequest) (obj)));
        return;
_L2:
        if (zzpe())
        {
            ((GetServiceRequest) (obj)).zzc(zzQd);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected Set zzb(Set set)
    {
        return set;
    }

    public void zzbE(int i)
    {
        mHandler.sendMessage(mHandler.obtainMessage(4, zzafH.get(), i));
    }

    protected void zzbF(int i)
    {
        mHandler.sendMessage(mHandler.obtainMessage(6, i, -1, new zzh()));
    }

    protected void zzc(int i, IInterface iinterface)
    {
    }

    protected abstract String zzfK();

    protected abstract String zzfL();

    public boolean zzlN()
    {
        return false;
    }

    protected Bundle zzly()
    {
        return new Bundle();
    }

    public Bundle zzmS()
    {
        return null;
    }

    public IBinder zznz()
    {
        if (zzafy == null)
        {
            return null;
        } else
        {
            return zzafy.asBinder();
        }
    }

    public final Account zzoI()
    {
        if (zzQd != null)
        {
            return zzQd;
        } else
        {
            return new Account("<<default account>>", "com.google");
        }
    }

    protected final String zzoV()
    {
        return zzabI.zzoO();
    }

    protected void zzoW()
    {
    }

    public void zzoZ()
    {
        int i = zzaaP.isGooglePlayServicesAvailable(mContext);
        if (i != 0)
        {
            zzb(1, null);
            zzafz = new zzf();
            mHandler.sendMessage(mHandler.obtainMessage(3, zzafH.get(), i));
            return;
        } else
        {
            zza(new zzf());
            return;
        }
    }

    protected final com.google.android.gms.common.internal.zzf zzpa()
    {
        return zzabI;
    }

    protected final void zzpb()
    {
        if (!isConnected())
        {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        } else
        {
            return;
        }
    }

    public final IInterface zzpc()
    {
        Object obj = zzpd;
        obj;
        JVM INSTR monitorenter ;
        if (zzafD == 4)
        {
            throw new DeadObjectException();
        }
        break MISSING_BLOCK_LABEL_28;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        zzpb();
        IInterface iinterface;
        boolean flag;
        if (zzafA != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zza(flag, "Client is connected but service is null");
        iinterface = zzafA;
        obj;
        JVM INSTR monitorexit ;
        return iinterface;
    }

    protected Bundle zzpd()
    {
        return null;
    }

    public boolean zzpe()
    {
        return false;
    }


    private class zzb extends Handler
    {

        final zzj zzafK;

        private void zza(Message message)
        {
            message = (zzc)message.obj;
            message.zzpg();
            message.unregister();
        }

        private boolean zzb(Message message)
        {
            return message.what == 2 || message.what == 1 || message.what == 5 || message.what == 6;
        }

        public final void handleMessage(Message message)
        {
            if (zzafK.zzafH.get() != message.arg1)
            {
                if (zzb(message))
                {
                    zza(message);
                }
                return;
            }
            if ((message.what == 1 || message.what == 5 || message.what == 6) && !zzafK.isConnecting())
            {
                zza(message);
                return;
            }
            if (message.what == 3)
            {
                message = new ConnectionResult(message.arg2, null);
                zzj.zza(zzafK).zza(message);
                zzafK.onConnectionFailed(message);
                return;
            }
            if (message.what == 4)
            {
                zzj.zza(zzafK, 4, null);
                if (zzj.zzb(zzafK) != null)
                {
                    zzj.zzb(zzafK).onConnectionSuspended(message.arg2);
                }
                zzafK.onConnectionSuspended(message.arg2);
                zzj.zza(zzafK, 4, 1, null);
                return;
            }
            if (message.what == 2 && !zzafK.isConnected())
            {
                zza(message);
                return;
            }
            if (zzb(message))
            {
                ((zzc)message.obj).zzph();
                return;
            } else
            {
                Log.wtf("GmsClient", (new StringBuilder("Don't know how to handle message: ")).append(message.what).toString(), new Exception());
                return;
            }
        }

        public zzb(Looper looper)
        {
            zzafK = zzj.this;
            super(looper);
        }
    }


    private class zze
        implements ServiceConnection
    {

        final zzj zzafK;
        private final int zzafN;

        public final void onServiceConnected(ComponentName componentname, IBinder ibinder)
        {
            zzx.zzb(ibinder, "Expecting a valid IBinder");
            zzj.zza(zzafK, zzs.zza.zzaK(ibinder));
            zzafK.zzbF(zzafN);
        }

        public final void onServiceDisconnected(ComponentName componentname)
        {
            zzafK.mHandler.sendMessage(zzafK.mHandler.obtainMessage(4, zzafN, 1));
        }

        public zze(int i)
        {
            zzafK = zzj.this;
            super();
            zzafN = i;
        }
    }


    private class zzc
    {

        private Object mListener;
        final zzj zzafK;
        private boolean zzafL;

        public void unregister()
        {
            zzpi();
            synchronized (zzj.zzc(zzafK))
            {
                zzj.zzc(zzafK).remove(this);
            }
            return;
            exception;
            arraylist;
            JVM INSTR monitorexit ;
            throw exception;
        }

        protected abstract void zzpg();

        public void zzph()
        {
            this;
            JVM INSTR monitorenter ;
            Object obj;
            obj = mListener;
            if (zzafL)
            {
                Log.w("GmsClient", (new StringBuilder("Callback proxy ")).append(this).append(" being reused. This is not safe.").toString());
            }
            this;
            JVM INSTR monitorexit ;
            Object obj1;
            if (obj != null)
            {
                try
                {
                    zzt(obj);
                }
                // Misplaced declaration of an exception variable
                catch (Object obj1)
                {
                    zzpg();
                    throw obj1;
                }
            } else
            {
                zzpg();
            }
            this;
            JVM INSTR monitorenter ;
            zzafL = true;
            this;
            JVM INSTR monitorexit ;
            unregister();
            return;
            obj1;
            this;
            JVM INSTR monitorexit ;
            throw obj1;
            obj1;
            this;
            JVM INSTR monitorexit ;
            throw obj1;
        }

        public void zzpi()
        {
            this;
            JVM INSTR monitorenter ;
            mListener = null;
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            this;
            JVM INSTR monitorexit ;
            throw exception;
        }

        protected abstract void zzt(Object obj);

        public zzc(Object obj)
        {
            zzafK = zzj.this;
            super();
            mListener = obj;
            zzafL = false;
        }
    }


    private class zzi extends zza
    {
        private class zza extends zzc
        {

            public final int statusCode;
            public final Bundle zzafJ;
            final zzj zzafK;

            protected void zzc(Boolean boolean1)
            {
                Object obj = null;
                if (boolean1 != null) goto _L2; else goto _L1
_L1:
                zzj.zza(zzafK, 1, null);
_L4:
                return;
_L2:
                switch (statusCode)
                {
                default:
                    zzj.zza(zzafK, 1, null);
                    boolean1 = obj;
                    if (zzafJ != null)
                    {
                        boolean1 = (PendingIntent)zzafJ.getParcelable("pendingIntent");
                    }
                    zzh(new ConnectionResult(statusCode, boolean1));
                    return;

                case 0: // '\0'
                    if (!zzpf())
                    {
                        zzj.zza(zzafK, 1, null);
                        zzh(new ConnectionResult(8, null));
                        return;
                    }
                    break;

                case 10: // '\n'
                    zzj.zza(zzafK, 1, null);
                    throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
                }
                if (true) goto _L4; else goto _L3
_L3:
            }

            protected abstract void zzh(ConnectionResult connectionresult);

            protected abstract boolean zzpf();

            protected void zzpg()
            {
            }

            protected void zzt(Object obj)
            {
                zzc((Boolean)obj);
            }

            protected zza(int i, Bundle bundle)
            {
                zzafK = zzj.this;
                super(Boolean.valueOf(true));
                statusCode = i;
                zzafJ = bundle;
            }
        }


        final zzj zzafK;

        protected final void zzh(ConnectionResult connectionresult)
        {
            zzj.zza(zzafK).zzb(connectionresult);
            zzafK.onConnectionFailed(connectionresult);
        }

        protected final boolean zzpf()
        {
            zzj.zza(zzafK).zzb(ConnectionResult.zzZY);
            return true;
        }

        public zzi(int i, Bundle bundle)
        {
            zzafK = zzj.this;
            super(i, bundle);
        }
    }


    private class zzg extends zza
    {

        final zzj zzafK;
        public final IBinder zzafO;

        protected final void zzh(ConnectionResult connectionresult)
        {
            if (zzj.zze(zzafK) != null)
            {
                zzj.zze(zzafK).onConnectionFailed(connectionresult);
            }
            zzafK.onConnectionFailed(connectionresult);
        }

        protected final boolean zzpf()
        {
            String s;
            try
            {
                s = zzafO.getInterfaceDescriptor();
            }
            catch (RemoteException remoteexception)
            {
                Log.w("GmsClient", "service probably died");
                return false;
            }
            if (!zzafK.zzfL().equals(s))
            {
                Log.e("GmsClient", (new StringBuilder("service descriptor mismatch: ")).append(zzafK.zzfL()).append(" vs. ").append(s).toString());
            } else
            {
                IInterface iinterface = zzafK.zzW(zzafO);
                if (iinterface != null && zzj.zza(zzafK, 2, 3, iinterface))
                {
                    Bundle bundle = zzafK.zzmS();
                    if (zzj.zzb(zzafK) != null)
                    {
                        zzj.zzb(zzafK).onConnected(bundle);
                    }
                    return true;
                }
            }
            return false;
        }

        public zzg(int i, IBinder ibinder, Bundle bundle)
        {
            zzafK = zzj.this;
            super(i, bundle);
            zzafO = ibinder;
        }
    }


    private class zzd extends zzr.zza
    {

        private zzj zzafM;
        private final int zzafN;

        private void zzpj()
        {
            zzafM = null;
        }

        public final void zza(int i, IBinder ibinder, Bundle bundle)
        {
            zzx.zzb(zzafM, "onPostInitComplete can be called only once per call to getRemoteService");
            zzafM.zza(i, ibinder, bundle, zzafN);
            zzpj();
        }

        public final void zzb(int i, Bundle bundle)
        {
            zzx.zzb(zzafM, "onAccountValidationComplete can be called only once per call to validateAccount");
            zzafM.zza(i, bundle, zzafN);
            zzpj();
        }

        public zzd(int i)
        {
            zzafM = zzj.this;
            zzafN = i;
        }
    }


    private class zzh extends zza
    {

        final zzj zzafK;

        protected final void zzh(ConnectionResult connectionresult)
        {
            zzj.zza(zzafK).zza(connectionresult);
            zzafK.onConnectionFailed(connectionresult);
        }

        protected final boolean zzpf()
        {
            zzj.zza(zzafK).zza(ConnectionResult.zzZY);
            return true;
        }

        public zzh()
        {
            zzafK = zzj.this;
            super(0, null);
        }
    }


    private class zzf
        implements com.google.android.gms.common.api.GoogleApiClient.zza
    {

        final zzj zzafK;

        public void zza(ConnectionResult connectionresult)
        {
            if (connectionresult.isSuccess())
            {
                zzafK.zza(null, zzj.zzd(zzafK));
            } else
            if (zzj.zze(zzafK) != null)
            {
                zzj.zze(zzafK).onConnectionFailed(connectionresult);
                return;
            }
        }

        public void zzb(ConnectionResult connectionresult)
        {
            throw new IllegalStateException("Legacy GmsClient received onReportAccountValidation callback.");
        }

        public zzf()
        {
            zzafK = zzj.this;
            super();
        }
    }

}
