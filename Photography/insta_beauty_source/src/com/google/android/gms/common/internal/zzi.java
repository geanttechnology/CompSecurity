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
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.Scope;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.google.android.gms.common.internal:
//            zzu, zzk, zze, GetServiceRequest, 
//            zzp, ValidateAccountRequest, IAccountAccessor

public abstract class zzi
    implements com.google.android.gms.common.api.Api.Client, zzj.zza
{

    public static final String zzaav[] = {
        "service_esmobile", "service_googleme"
    };
    private final Context mContext;
    final Handler mHandler;
    private final Account zzMY;
    private final Set zzWJ;
    private final Looper zzWt;
    private final com.google.android.gms.common.internal.zze zzXa;
    private final zzk zzaak;
    private zzp zzaal;
    private com.google.android.gms.common.api.GoogleApiClient.ConnectionProgressReportCallbacks zzaam;
    private IInterface zzaan;
    private final ArrayList zzaao;
    private zze zzaap;
    private int zzaaq;
    private com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks zzaar;
    private com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener zzaas;
    private final int zzaat;
    protected AtomicInteger zzaau;
    private final Object zzqt;

    public zzi(Context context, Looper looper, int i, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
    {
        zzqt = new Object();
        zzaao = new ArrayList();
        zzaaq = 1;
        zzaau = new AtomicInteger(0);
        mContext = (Context)zzu.zzu(context);
        zzWt = (Looper)zzu.zzb(looper, "Looper must not be null");
        zzaak = zzk.zzah(context);
        mHandler = new zzb(looper);
        zzaat = i;
        zzMY = null;
        zzWJ = Collections.emptySet();
        zzXa = (new com.google.android.gms.common.api.GoogleApiClient.Builder(context)).zzmx();
        zzaar = (com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks)zzu.zzu(connectioncallbacks);
        zzaas = (com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener)zzu.zzu(onconnectionfailedlistener);
    }

    public zzi(Context context, Looper looper, int i, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener, zze zze1)
    {
        this(context, looper, zzk.zzah(context), i, zze1, connectioncallbacks, onconnectionfailedlistener);
    }

    protected zzi(Context context, Looper looper, zzk zzk1, int i, zze zze1)
    {
        zzqt = new Object();
        zzaao = new ArrayList();
        zzaaq = 1;
        zzaau = new AtomicInteger(0);
        mContext = (Context)zzu.zzb(context, "Context must not be null");
        zzWt = (Looper)zzu.zzb(looper, "Looper must not be null");
        zzaak = (zzk)zzu.zzb(zzk1, "Supervisor must not be null");
        mHandler = new zzb(looper);
        zzaat = i;
        zzXa = (zze)zzu.zzu(zze1);
        zzMY = zze1.getAccount();
        zzWJ = zzb(zze1.zznw());
    }

    protected zzi(Context context, Looper looper, zzk zzk1, int i, zze zze1, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
    {
        this(context, looper, zzk1, i, zze1);
        zzaar = (com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks)zzu.zzu(connectioncallbacks);
        zzaas = (com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener)zzu.zzu(onconnectionfailedlistener);
    }

    static com.google.android.gms.common.api.GoogleApiClient.ConnectionProgressReportCallbacks zza(zzi zzi1)
    {
        return zzi1.zzaam;
    }

    static zzp zza(zzi zzi1, zzp zzp1)
    {
        zzi1.zzaal = zzp1;
        return zzp1;
    }

    private void zza(int i, IInterface iinterface)
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
        zzu.zzV(flag2);
        obj = zzqt;
        obj;
        JVM INSTR monitorenter ;
        zzaaq = i;
        zzaan = iinterface;
        i;
        JVM INSTR tableswitch 1 3: default 105
    //                   1 98
    //                   2 79
    //                   3 91;
           goto _L1 _L2 _L3 _L4
_L1:
        obj;
        JVM INSTR monitorexit ;
        return;
_L3:
        zznH();
          goto _L1
        iinterface;
        obj;
        JVM INSTR monitorexit ;
        throw iinterface;
_L4:
        zznG();
          goto _L1
_L2:
        zznI();
          goto _L1
    }

    private void zza(com.google.android.gms.common.api.GoogleApiClient.ConnectionProgressReportCallbacks connectionprogressreportcallbacks)
    {
        zzaam = (com.google.android.gms.common.api.GoogleApiClient.ConnectionProgressReportCallbacks)zzu.zzb(connectionprogressreportcallbacks, "Connection progress callbacks cannot be null.");
    }

    static void zza(zzi zzi1, int i, IInterface iinterface)
    {
        zzi1.zza(i, iinterface);
    }

    private boolean zza(int i, int j, IInterface iinterface)
    {
label0:
        {
            synchronized (zzqt)
            {
                if (zzaaq == i)
                {
                    break label0;
                }
            }
            return false;
        }
        zza(j, iinterface);
        obj;
        JVM INSTR monitorexit ;
        return true;
        iinterface;
        obj;
        JVM INSTR monitorexit ;
        throw iinterface;
    }

    static boolean zza(zzi zzi1, int i, int j, IInterface iinterface)
    {
        return zzi1.zza(i, j, iinterface);
    }

    static com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks zzb(zzi zzi1)
    {
        return zzi1.zzaar;
    }

    private Set zzb(Set set)
    {
        Set set1 = zza(set);
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

    static ArrayList zzc(zzi zzi1)
    {
        return zzi1.zzaao;
    }

    static Set zzd(zzi zzi1)
    {
        return zzi1.zzWJ;
    }

    static com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener zze(zzi zzi1)
    {
        return zzi1.zzaas;
    }

    static Context zzf(zzi zzi1)
    {
        return zzi1.mContext;
    }

    private void zznH()
    {
        if (zzaap != null)
        {
            Log.e("GmsClient", (new StringBuilder()).append("Calling connect() while still connected, missing disconnect() for ").append(getStartServiceAction()).toString());
            zzaak.zzb(getStartServiceAction(), zzaap, zzkQ());
            zzaau.incrementAndGet();
        }
        zzaap = new zze(zzaau.get());
        if (!zzaak.zza(getStartServiceAction(), zzaap, zzkQ()))
        {
            Log.e("GmsClient", (new StringBuilder()).append("unable to connect to service: ").append(getStartServiceAction()).toString());
            mHandler.sendMessage(mHandler.obtainMessage(3, zzaau.get(), 9));
        }
    }

    private void zznI()
    {
        if (zzaap != null)
        {
            zzaak.zzb(getStartServiceAction(), zzaap, zzkQ());
            zzaap = null;
        }
    }

    public void connect(com.google.android.gms.common.api.GoogleApiClient.ConnectionProgressReportCallbacks connectionprogressreportcallbacks)
    {
        zza(connectionprogressreportcallbacks);
        zza(2, ((IInterface) (null)));
    }

    public void disconnect()
    {
        zzaau.incrementAndGet();
        ArrayList arraylist = zzaao;
        arraylist;
        JVM INSTR monitorenter ;
        int j = zzaao.size();
        int i = 0;
_L2:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        ((zzc)zzaao.get(i)).zznR();
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        zzaao.clear();
        arraylist;
        JVM INSTR monitorexit ;
        zza(1, ((IInterface) (null)));
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
        synchronized (zzqt)
        {
            i = zzaaq;
            as = zzaan;
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
            printwriter.append(getServiceDescriptor()).append("@").println(Integer.toHexString(System.identityHashCode(as.asBinder())));
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
        return zzWt;
    }

    public void getRemoteService(IAccountAccessor iaccountaccessor, Set set)
    {
        Object obj;
        try
        {
            obj = zzkR();
            obj = (new GetServiceRequest(zzaat)).zzcb(mContext.getPackageName()).zzf(((Bundle) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (IAccountAccessor iaccountaccessor)
        {
            Log.w("GmsClient", "service died");
            zzbs(1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (IAccountAccessor iaccountaccessor)
        {
            Log.w("GmsClient", "Remote exception occurred", iaccountaccessor);
            return;
        }
        if (set == null)
        {
            break MISSING_BLOCK_LABEL_41;
        }
        ((GetServiceRequest) (obj)).zzb(set);
        if (!requiresSignIn()) goto _L2; else goto _L1
_L1:
        ((GetServiceRequest) (obj)).zzb(zznt()).zzb(iaccountaccessor);
_L4:
        zzaal.zza(new zzd(zzaau.get()), ((GetServiceRequest) (obj)));
        return;
_L2:
        if (requiresAccount())
        {
            ((GetServiceRequest) (obj)).zzb(zzMY);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public abstract String getServiceDescriptor();

    public abstract String getStartServiceAction();

    public boolean isConnected()
    {
        Object obj = zzqt;
        obj;
        JVM INSTR monitorenter ;
        Exception exception;
        boolean flag;
        if (zzaaq == 3)
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
        Object obj = zzqt;
        obj;
        JVM INSTR monitorenter ;
        Exception exception;
        boolean flag;
        if (zzaaq == 2)
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

    public boolean requiresAccount()
    {
        return false;
    }

    public boolean requiresSignIn()
    {
        return false;
    }

    public void validateAccount(IAccountAccessor iaccountaccessor)
    {
        Bundle bundle = zznN();
        iaccountaccessor = new ValidateAccountRequest(iaccountaccessor, (Scope[])zzWJ.toArray(new Scope[zzWJ.size()]), mContext.getPackageName(), bundle);
        try
        {
            zzaal.zza(new zzd(zzaau.get()), iaccountaccessor);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (IAccountAccessor iaccountaccessor)
        {
            Log.w("GmsClient", "service died");
            zzbs(1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (IAccountAccessor iaccountaccessor)
        {
            Log.w("GmsClient", "Remote exception occurred", iaccountaccessor);
        }
    }

    public abstract IInterface zzT(IBinder ibinder);

    protected Set zza(Set set)
    {
        return set;
    }

    protected void zza(int i, Bundle bundle, int j)
    {
        mHandler.sendMessage(mHandler.obtainMessage(5, j, -1, new zzi(i, bundle)));
    }

    protected void zza(int i, IBinder ibinder, Bundle bundle, int j)
    {
        mHandler.sendMessage(mHandler.obtainMessage(1, j, -1, new zzg(i, ibinder, bundle)));
    }

    public final void zza(zzc zzc1)
    {
        synchronized (zzaao)
        {
            zzaao.add(zzc1);
        }
        mHandler.sendMessage(mHandler.obtainMessage(2, zzaau.get(), -1, zzc1));
        return;
        zzc1;
        arraylist;
        JVM INSTR monitorexit ;
        throw zzc1;
    }

    public void zzbs(int i)
    {
        mHandler.sendMessage(mHandler.obtainMessage(4, zzaau.get(), i));
    }

    protected void zzbt(int i)
    {
        mHandler.sendMessage(mHandler.obtainMessage(6, i, -1, new zzh()));
    }

    protected String zzkQ()
    {
        return zzXa.zznz();
    }

    public Bundle zzkR()
    {
        return new Bundle();
    }

    public Bundle zzlM()
    {
        return null;
    }

    protected void zznG()
    {
    }

    public void zznJ()
    {
        int i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(mContext);
        if (i != 0)
        {
            zza(1, ((IInterface) (null)));
            zzaam = new zzf();
            mHandler.sendMessage(mHandler.obtainMessage(3, zzaau.get(), i));
            return;
        } else
        {
            connect(new zzf());
            return;
        }
    }

    public final com.google.android.gms.common.internal.zze zznK()
    {
        return zzXa;
    }

    protected final void zznL()
    {
        if (!isConnected())
        {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        } else
        {
            return;
        }
    }

    public final IInterface zznM()
    {
        Object obj = zzqt;
        obj;
        JVM INSTR monitorenter ;
        if (zzaaq == 4)
        {
            throw new DeadObjectException();
        }
        break MISSING_BLOCK_LABEL_28;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        zznL();
        IInterface iinterface;
        boolean flag;
        if (zzaan != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzu.zza(flag, "Client is connected but service is null");
        iinterface = zzaan;
        obj;
        JVM INSTR monitorexit ;
        return iinterface;
    }

    protected Bundle zznN()
    {
        return null;
    }

    public final Account zznt()
    {
        if (zzMY != null)
        {
            return zzMY;
        } else
        {
            return new Account("<<default account>>", "com.google");
        }
    }


    private class zzb extends Handler
    {

        final com.google.android.gms.common.internal.zzi zzaax;

        private void zza(Message message)
        {
            message = (zzc)message.obj;
            message.zznP();
            message.unregister();
        }

        private boolean zzb(Message message)
        {
            return message.what == 2 || message.what == 1 || message.what == 5 || message.what == 6;
        }

        public void handleMessage(Message message)
        {
            if (zzaax.zzaau.get() != message.arg1)
            {
                if (zzb(message))
                {
                    zza(message);
                }
                return;
            }
            if ((message.what == 1 || message.what == 5 || message.what == 6) && !zzaax.isConnecting())
            {
                zza(message);
                return;
            }
            if (message.what == 3)
            {
                message = new ConnectionResult(message.arg2, null);
                com.google.android.gms.common.internal.zzi.zza(zzaax).onReportServiceBinding(message);
                zzaax.onConnectionFailed(message);
                return;
            }
            if (message.what == 4)
            {
                com.google.android.gms.common.internal.zzi.zza(zzaax, 4, null);
                if (com.google.android.gms.common.internal.zzi.zzb(zzaax) != null)
                {
                    com.google.android.gms.common.internal.zzi.zzb(zzaax).onConnectionSuspended(message.arg2);
                }
                zzaax.onConnectionSuspended(message.arg2);
                com.google.android.gms.common.internal.zzi.zza(zzaax, 4, 1, null);
                return;
            }
            if (message.what == 2 && !zzaax.isConnected())
            {
                zza(message);
                return;
            }
            if (zzb(message))
            {
                ((zzc)message.obj).zznQ();
                return;
            } else
            {
                Log.wtf("GmsClient", "Don't know how to handle this message.");
                return;
            }
        }

        public zzb(Looper looper)
        {
            zzaax = zzi.this;
            super(looper);
        }
    }


    private class zze
        implements ServiceConnection
    {

        private final int zzaaA;
        final com.google.android.gms.common.internal.zzi zzaax;

        public void onServiceConnected(ComponentName componentname, IBinder ibinder)
        {
            zzu.zzb(ibinder, "Expecting a valid IBinder");
            com.google.android.gms.common.internal.zzi.zza(zzaax, zzp.zza.zzaG(ibinder));
            zzaax.zzbt(zzaaA);
        }

        public void onServiceDisconnected(ComponentName componentname)
        {
            zzaax.mHandler.sendMessage(zzaax.mHandler.obtainMessage(4, zzaaA, 1));
        }

        public zze(int i)
        {
            zzaax = zzi.this;
            super();
            zzaaA = i;
        }
    }


    private class zzc
    {

        private Object mListener;
        final com.google.android.gms.common.internal.zzi zzaax;
        private boolean zzaay;

        public void unregister()
        {
            zznR();
            synchronized (com.google.android.gms.common.internal.zzi.zzc(zzaax))
            {
                com.google.android.gms.common.internal.zzi.zzc(zzaax).remove(this);
            }
            return;
            exception;
            arraylist;
            JVM INSTR monitorexit ;
            throw exception;
        }

        protected abstract void zznP();

        public void zznQ()
        {
            this;
            JVM INSTR monitorenter ;
            Object obj;
            obj = mListener;
            if (zzaay)
            {
                Log.w("GmsClient", (new StringBuilder()).append("Callback proxy ").append(this).append(" being reused. This is not safe.").toString());
            }
            this;
            JVM INSTR monitorexit ;
            Object obj1;
            if (obj != null)
            {
                try
                {
                    zzr(obj);
                }
                // Misplaced declaration of an exception variable
                catch (Object obj1)
                {
                    zznP();
                    throw obj1;
                }
            } else
            {
                zznP();
            }
            this;
            JVM INSTR monitorenter ;
            zzaay = true;
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

        public void zznR()
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

        protected abstract void zzr(Object obj);

        public zzc(Object obj)
        {
            zzaax = zzi.this;
            super();
            mListener = obj;
            zzaay = false;
        }
    }


    private class zzd extends zzo.zza
    {

        private final int zzaaA;
        private com.google.android.gms.common.internal.zzi zzaaz;

        private void zznS()
        {
            zzaaz = null;
        }

        public void zza(int i, IBinder ibinder, Bundle bundle)
        {
            zzu.zzb(zzaaz, "onPostInitComplete can be called only once per call to getRemoteService");
            zzaaz.zza(i, ibinder, bundle, zzaaA);
            zznS();
        }

        public void zzb(int i, Bundle bundle)
        {
            zzu.zzb(zzaaz, "onAccountValidationComplete can be called only once per call to validateAccount");
            zzaaz.zza(i, bundle, zzaaA);
            zznS();
        }

        public zzd(int i)
        {
            zzaaz = zzi.this;
            zzaaA = i;
        }
    }


    private class zzi extends zza
    {
        private class zza extends zzc
        {

            public final int statusCode;
            public final Bundle zzaaw;
            final com.google.android.gms.common.internal.zzi zzaax;

            protected void zzc(Boolean boolean1)
            {
                Object obj = null;
                if (boolean1 != null) goto _L2; else goto _L1
_L1:
                com.google.android.gms.common.internal.zzi.zza(zzaax, 1, null);
_L4:
                return;
_L2:
                switch (statusCode)
                {
                default:
                    com.google.android.gms.common.internal.zzi.zza(zzaax, 1, null);
                    boolean1 = obj;
                    if (zzaaw != null)
                    {
                        boolean1 = (PendingIntent)zzaaw.getParcelable("pendingIntent");
                    }
                    zzg(new ConnectionResult(statusCode, boolean1));
                    return;

                case 0: // '\0'
                    if (!zznO())
                    {
                        com.google.android.gms.common.internal.zzi.zza(zzaax, 1, null);
                        zzg(new ConnectionResult(8, null));
                        return;
                    }
                    break;

                case 10: // '\n'
                    com.google.android.gms.common.internal.zzi.zza(zzaax, 1, null);
                    throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
                }
                if (true) goto _L4; else goto _L3
_L3:
            }

            protected abstract void zzg(ConnectionResult connectionresult);

            protected abstract boolean zznO();

            protected void zznP()
            {
            }

            protected void zzr(Object obj)
            {
                zzc((Boolean)obj);
            }

            protected zza(int i, Bundle bundle)
            {
                zzaax = com.google.android.gms.common.internal.zzi.this;
                super(Boolean.valueOf(true));
                statusCode = i;
                zzaaw = bundle;
            }
        }


        final com.google.android.gms.common.internal.zzi zzaax;

        protected void zzg(ConnectionResult connectionresult)
        {
            com.google.android.gms.common.internal.zzi.zza(zzaax).onReportAccountValidation(connectionresult);
            zzaax.onConnectionFailed(connectionresult);
        }

        protected boolean zznO()
        {
            com.google.android.gms.common.internal.zzi.zza(zzaax).onReportAccountValidation(ConnectionResult.zzVG);
            return true;
        }

        public zzi(int i, Bundle bundle)
        {
            zzaax = com.google.android.gms.common.internal.zzi.this;
            super(i, bundle);
        }
    }


    private class zzg extends zza
    {

        public final IBinder zzaaB;
        final com.google.android.gms.common.internal.zzi zzaax;

        protected void zzg(ConnectionResult connectionresult)
        {
            if (com.google.android.gms.common.internal.zzi.zze(zzaax) != null)
            {
                com.google.android.gms.common.internal.zzi.zze(zzaax).onConnectionFailed(connectionresult);
            }
            zzaax.onConnectionFailed(connectionresult);
        }

        protected boolean zznO()
        {
            String s;
            try
            {
                s = zzaaB.getInterfaceDescriptor();
            }
            catch (RemoteException remoteexception)
            {
                Log.w("GmsClient", "service probably died");
                return false;
            }
            if (!zzaax.getServiceDescriptor().equals(s))
            {
                Log.e("GmsClient", (new StringBuilder()).append("service descriptor mismatch: ").append(zzaax.getServiceDescriptor()).append(" vs. ").append(s).toString());
            } else
            {
                IInterface iinterface = zzaax.zzT(zzaaB);
                if (iinterface != null && com.google.android.gms.common.internal.zzi.zza(zzaax, 2, 3, iinterface))
                {
                    Bundle bundle = zzaax.zzlM();
                    if (com.google.android.gms.common.internal.zzi.zzb(zzaax) != null)
                    {
                        com.google.android.gms.common.internal.zzi.zzb(zzaax).onConnected(bundle);
                    }
                    GooglePlayServicesUtil.zzac(com.google.android.gms.common.internal.zzi.zzf(zzaax));
                    return true;
                }
            }
            return false;
        }

        public zzg(int i, IBinder ibinder, Bundle bundle)
        {
            zzaax = com.google.android.gms.common.internal.zzi.this;
            super(i, bundle);
            zzaaB = ibinder;
        }
    }


    private class zzh extends zza
    {

        final com.google.android.gms.common.internal.zzi zzaax;

        protected void zzg(ConnectionResult connectionresult)
        {
            com.google.android.gms.common.internal.zzi.zza(zzaax).onReportServiceBinding(connectionresult);
            zzaax.onConnectionFailed(connectionresult);
        }

        protected boolean zznO()
        {
            com.google.android.gms.common.internal.zzi.zza(zzaax).onReportServiceBinding(ConnectionResult.zzVG);
            return true;
        }

        public zzh()
        {
            zzaax = com.google.android.gms.common.internal.zzi.this;
            super(0, null);
        }
    }


    private class zzf
        implements com.google.android.gms.common.api.GoogleApiClient.ConnectionProgressReportCallbacks
    {

        final com.google.android.gms.common.internal.zzi zzaax;

        public void onReportAccountValidation(ConnectionResult connectionresult)
        {
            throw new IllegalStateException("Legacy GmsClient received onReportAccountValidation callback.");
        }

        public void onReportServiceBinding(ConnectionResult connectionresult)
        {
            if (connectionresult.isSuccess())
            {
                zzaax.getRemoteService(null, com.google.android.gms.common.internal.zzi.zzd(zzaax));
            } else
            if (com.google.android.gms.common.internal.zzi.zze(zzaax) != null)
            {
                com.google.android.gms.common.internal.zzi.zze(zzaax).onConnectionFailed(connectionresult);
                return;
            }
        }

        public zzf()
        {
            zzaax = com.google.android.gms.common.internal.zzi.this;
            super();
        }
    }

}
