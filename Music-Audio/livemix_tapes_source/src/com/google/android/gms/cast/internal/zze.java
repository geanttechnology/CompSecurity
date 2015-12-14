// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.BinderWrapper;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

// Referenced classes of package com.google.android.gms.cast.internal:
//            zzl, ApplicationStatus, zzf, DeviceStatus, 
//            zzi

public final class zze extends zzj
{
    private static final class zza
        implements com.google.android.gms.cast.Cast.ApplicationConnectionResult
    {

        private final String zzGY;
        private final Status zzQA;
        private final ApplicationMetadata zzXh;
        private final String zzXi;
        private final boolean zzXj;

        public ApplicationMetadata getApplicationMetadata()
        {
            return zzXh;
        }

        public String getApplicationStatus()
        {
            return zzXi;
        }

        public String getSessionId()
        {
            return zzGY;
        }

        public Status getStatus()
        {
            return zzQA;
        }

        public boolean getWasLaunched()
        {
            return zzXj;
        }

        public zza(Status status)
        {
            this(status, null, null, null, false);
        }

        public zza(Status status, ApplicationMetadata applicationmetadata, String s, String s1, boolean flag)
        {
            zzQA = status;
            zzXh = applicationmetadata;
            zzXi = s;
            zzGY = s1;
            zzXj = flag;
        }
    }

    private static class zzb extends zzj.zza
    {

        private final Handler mHandler;
        private final AtomicReference zzXk;

        private void zza(zze zze1, long l, int i)
        {
            synchronized (zze.zzg(zze1))
            {
                zze1 = (com.google.android.gms.common.api.zzc.zzb)zze.zzg(zze1).remove(Long.valueOf(l));
            }
            if (zze1 != null)
            {
                zze1.zzn(new Status(i));
            }
            return;
            zze1;
            map;
            JVM INSTR monitorexit ;
            throw zze1;
        }

        private boolean zza(zze zze1, int i)
        {
            Object obj = zze.zzmF();
            obj;
            JVM INSTR monitorenter ;
            if (zze.zzh(zze1) == null)
            {
                break MISSING_BLOCK_LABEL_40;
            }
            zze.zzh(zze1).zzn(new Status(i));
            zze.zzb(zze1, null);
            return true;
            obj;
            JVM INSTR monitorexit ;
            return false;
            zze1;
            obj;
            JVM INSTR monitorexit ;
            throw zze1;
        }

        public boolean isDisposed()
        {
            return zzXk.get() == null;
        }

        public void onApplicationDisconnected(int i)
        {
            zze zze1 = (zze)zzXk.get();
            if (zze1 != null)
            {
                zze.zza(zze1, null);
                zze.zzb(zze1, null);
                zza(zze1, i);
                if (zze.zzd(zze1) != null)
                {
                    mHandler.post(new Runnable(this, zze1, i) {

                        final zze zzXl;
                        final int zzXm;
                        final zzb zzXn;

                        public void run()
                        {
                            if (zze.zzd(zzXl) != null)
                            {
                                zze.zzd(zzXl).onApplicationDisconnected(zzXm);
                            }
                        }

            
            {
                zzXn = zzb1;
                zzXl = zze1;
                zzXm = i;
                super();
            }
                    });
                    return;
                }
            }
        }

        public void zza(ApplicationMetadata applicationmetadata, String s, String s1, boolean flag)
        {
            zze zze1 = (zze)zzXk.get();
            if (zze1 == null)
            {
                return;
            }
            zze.zza(zze1, applicationmetadata);
            zze.zza(zze1, applicationmetadata.getApplicationId());
            zze.zzb(zze1, s1);
            synchronized (zze.zzmE())
            {
                if (zze.zzc(zze1) != null)
                {
                    zze.zzc(zze1).zzn(new zza(new Status(0), applicationmetadata, s, s1, flag));
                    zze.zza(zze1, null);
                }
            }
            return;
            applicationmetadata;
            obj;
            JVM INSTR monitorexit ;
            throw applicationmetadata;
        }

        public void zza(String s, double d, boolean flag)
        {
            zze.zzmD().zzb("Deprecated callback: \"onStatusreceived\"", new Object[0]);
        }

        public void zza(String s, long l, int i)
        {
            s = (zze)zzXk.get();
            if (s == null)
            {
                return;
            } else
            {
                zza(((zze) (s)), l, i);
                return;
            }
        }

        public void zzaU(int i)
        {
            zze zze1 = zzmG();
            if (zze1 != null)
            {
                zze.zzmD().zzb("ICastDeviceControllerListener.onDisconnected: %d", new Object[] {
                    Integer.valueOf(i)
                });
                if (i != 0)
                {
                    zze1.zzbz(2);
                    return;
                }
            }
        }

        public void zzaV(int i)
        {
            zze zze1 = (zze)zzXk.get();
            if (zze1 == null)
            {
                return;
            }
            synchronized (zze.zzmE())
            {
                if (zze.zzc(zze1) != null)
                {
                    zze.zzc(zze1).zzn(new zza(new Status(i)));
                    zze.zza(zze1, null);
                }
            }
            return;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public void zzaW(int i)
        {
            zze zze1 = (zze)zzXk.get();
            if (zze1 == null)
            {
                return;
            } else
            {
                zza(zze1, i);
                return;
            }
        }

        public void zzaX(int i)
        {
            zze zze1 = (zze)zzXk.get();
            if (zze1 == null)
            {
                return;
            } else
            {
                zza(zze1, i);
                return;
            }
        }

        public void zzb(ApplicationStatus applicationstatus)
        {
            zze zze1 = (zze)zzXk.get();
            if (zze1 == null)
            {
                return;
            } else
            {
                zze.zzmD().zzb("onApplicationStatusChanged", new Object[0]);
                mHandler.post(new Runnable(this, zze1, applicationstatus) {

                    final zze zzXl;
                    final zzb zzXn;
                    final ApplicationStatus zzXp;

                    public void run()
                    {
                        zze.zza(zzXl, zzXp);
                    }

            
            {
                zzXn = zzb1;
                zzXl = zze1;
                zzXp = applicationstatus;
                super();
            }
                });
                return;
            }
        }

        public void zzb(DeviceStatus devicestatus)
        {
            zze zze1 = (zze)zzXk.get();
            if (zze1 == null)
            {
                return;
            } else
            {
                zze.zzmD().zzb("onDeviceStatusChanged", new Object[0]);
                mHandler.post(new Runnable(this, zze1, devicestatus) {

                    final zze zzXl;
                    final zzb zzXn;
                    final DeviceStatus zzXo;

                    public void run()
                    {
                        zze.zza(zzXl, zzXo);
                    }

            
            {
                zzXn = zzb1;
                zzXl = zze1;
                zzXo = devicestatus;
                super();
            }
                });
                return;
            }
        }

        public void zzb(String s, byte abyte0[])
        {
            if ((zze)zzXk.get() == null)
            {
                return;
            } else
            {
                zze.zzmD().zzb("IGNORING: Receive (type=binary, ns=%s) <%d bytes>", new Object[] {
                    s, Integer.valueOf(abyte0.length)
                });
                return;
            }
        }

        public void zzd(String s, long l)
        {
            s = (zze)zzXk.get();
            if (s == null)
            {
                return;
            } else
            {
                zza(s, l, 0);
                return;
            }
        }

        public zze zzmG()
        {
            zze zze1 = (zze)zzXk.getAndSet(null);
            if (zze1 == null)
            {
                return null;
            } else
            {
                zze.zzb(zze1);
                return zze1;
            }
        }

        public void zzs(String s, String s1)
        {
            zze zze1 = (zze)zzXk.get();
            if (zze1 == null)
            {
                return;
            } else
            {
                zze.zzmD().zzb("Receive (type=text, ns=%s) %s", new Object[] {
                    s, s1
                });
                mHandler.post(new Runnable(this, zze1, s, s1) {

                    final String zzTb;
                    final zze zzXl;
                    final zzb zzXn;
                    final String zzXq;

                    public void run()
                    {
                        com.google.android.gms.cast.Cast.MessageReceivedCallback messagereceivedcallback;
                        synchronized (zze.zze(zzXl))
                        {
                            messagereceivedcallback = (com.google.android.gms.cast.Cast.MessageReceivedCallback)zze.zze(zzXl).get(zzTb);
                        }
                        if (messagereceivedcallback != null)
                        {
                            messagereceivedcallback.onMessageReceived(com.google.android.gms.cast.internal.zze.zzf(zzXl), zzTb, zzXq);
                            return;
                        } else
                        {
                            zze.zzmD().zzb("Discarded message for unknown namespace '%s'", new Object[] {
                                zzTb
                            });
                            return;
                        }
                        exception;
                        map;
                        JVM INSTR monitorexit ;
                        throw exception;
                    }

            
            {
                zzXn = zzb1;
                zzXl = zze1;
                zzTb = s;
                zzXq = s1;
                super();
            }
                });
                return;
            }
        }

        public zzb(zze zze1)
        {
            zzXk = new AtomicReference(zze1);
            mHandler = new Handler(zze1.getLooper());
        }
    }


    private static final zzl zzTy = new zzl("CastClientImpl");
    private static final Object zzXf = new Object();
    private static final Object zzXg = new Object();
    private final com.google.android.gms.cast.Cast.Listener zzTk;
    private double zzUJ;
    private boolean zzUK;
    private ApplicationMetadata zzWN;
    private final CastDevice zzWO;
    private final Map zzWP = new HashMap();
    private final long zzWQ;
    private zzb zzWR;
    private String zzWS;
    private boolean zzWT;
    private boolean zzWU;
    private boolean zzWV;
    private int zzWW;
    private int zzWX;
    private final AtomicLong zzWY = new AtomicLong(0L);
    private String zzWZ;
    private String zzXa;
    private Bundle zzXb;
    private final Map zzXc = new HashMap();
    private com.google.android.gms.common.api.zzc.zzb zzXd;
    private com.google.android.gms.common.api.zzc.zzb zzXe;

    public zze(Context context, Looper looper, zzf zzf1, CastDevice castdevice, long l, com.google.android.gms.cast.Cast.Listener listener, 
            com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
    {
        super(context, looper, 10, zzf1, connectioncallbacks, onconnectionfailedlistener);
        zzWO = castdevice;
        zzTk = listener;
        zzWQ = l;
        zzmv();
    }

    static ApplicationMetadata zza(zze zze1, ApplicationMetadata applicationmetadata)
    {
        zze1.zzWN = applicationmetadata;
        return applicationmetadata;
    }

    static com.google.android.gms.common.api.zzc.zzb zza(zze zze1, com.google.android.gms.common.api.zzc.zzb zzb1)
    {
        zze1.zzXd = zzb1;
        return zzb1;
    }

    static String zza(zze zze1, String s)
    {
        zze1.zzWZ = s;
        return s;
    }

    private void zza(ApplicationStatus applicationstatus)
    {
        applicationstatus = applicationstatus.zzms();
        boolean flag;
        if (!com.google.android.gms.cast.internal.zzf.zza(applicationstatus, zzWS))
        {
            zzWS = applicationstatus;
            flag = true;
        } else
        {
            flag = false;
        }
        zzTy.zzb("hasChanged=%b, mFirstApplicationStatusUpdate=%b", new Object[] {
            Boolean.valueOf(flag), Boolean.valueOf(zzWT)
        });
        if (zzTk != null && (flag || zzWT))
        {
            zzTk.onApplicationStatusChanged();
        }
        zzWT = false;
    }

    private void zza(DeviceStatus devicestatus)
    {
        ApplicationMetadata applicationmetadata = devicestatus.getApplicationMetadata();
        if (!com.google.android.gms.cast.internal.zzf.zza(applicationmetadata, zzWN))
        {
            zzWN = applicationmetadata;
            zzTk.onApplicationMetadataChanged(zzWN);
        }
        double d = devicestatus.zzmy();
        int i;
        boolean flag;
        boolean flag1;
        if (d != (0.0D / 0.0D) && Math.abs(d - zzUJ) > 9.9999999999999995E-08D)
        {
            zzUJ = d;
            flag = true;
        } else
        {
            flag = false;
        }
        flag1 = devicestatus.zzmH();
        if (flag1 != zzUK)
        {
            zzUK = flag1;
            flag = true;
        }
        zzTy.zzb("hasVolumeChanged=%b, mFirstDeviceStatusUpdate=%b", new Object[] {
            Boolean.valueOf(flag), Boolean.valueOf(zzWU)
        });
        if (zzTk != null && (flag || zzWU))
        {
            zzTk.onVolumeChanged();
        }
        i = devicestatus.zzmz();
        if (i != zzWW)
        {
            zzWW = i;
            flag = true;
        } else
        {
            flag = false;
        }
        zzTy.zzb("hasActiveInputChanged=%b, mFirstDeviceStatusUpdate=%b", new Object[] {
            Boolean.valueOf(flag), Boolean.valueOf(zzWU)
        });
        if (zzTk != null && (flag || zzWU))
        {
            zzTk.onActiveInputStateChanged(zzWW);
        }
        i = devicestatus.zzmA();
        if (i != zzWX)
        {
            zzWX = i;
            flag = true;
        } else
        {
            flag = false;
        }
        zzTy.zzb("hasStandbyStateChanged=%b, mFirstDeviceStatusUpdate=%b", new Object[] {
            Boolean.valueOf(flag), Boolean.valueOf(zzWU)
        });
        if (zzTk != null && (flag || zzWU))
        {
            zzTk.onStandbyStateChanged(zzWX);
        }
        zzWU = false;
    }

    static void zza(zze zze1, ApplicationStatus applicationstatus)
    {
        zze1.zza(applicationstatus);
    }

    static void zza(zze zze1, DeviceStatus devicestatus)
    {
        zze1.zza(devicestatus);
    }

    static com.google.android.gms.common.api.zzc.zzb zzb(zze zze1, com.google.android.gms.common.api.zzc.zzb zzb1)
    {
        zze1.zzXe = zzb1;
        return zzb1;
    }

    static String zzb(zze zze1, String s)
    {
        zze1.zzXa = s;
        return s;
    }

    static void zzb(zze zze1)
    {
        zze1.zzmv();
    }

    static com.google.android.gms.common.api.zzc.zzb zzc(zze zze1)
    {
        return zze1.zzXd;
    }

    private void zzc(com.google.android.gms.common.api.zzc.zzb zzb1)
    {
        synchronized (zzXf)
        {
            if (zzXd != null)
            {
                zzXd.zzn(new zza(new Status(2002)));
            }
            zzXd = zzb1;
        }
        return;
        zzb1;
        obj;
        JVM INSTR monitorexit ;
        throw zzb1;
    }

    static com.google.android.gms.cast.Cast.Listener zzd(zze zze1)
    {
        return zze1.zzTk;
    }

    static Map zze(zze zze1)
    {
        return zze1.zzWP;
    }

    private void zze(com.google.android.gms.common.api.zzc.zzb zzb1)
    {
label0:
        {
            synchronized (zzXg)
            {
                if (zzXe == null)
                {
                    break label0;
                }
                zzb1.zzn(new Status(2001));
            }
            return;
        }
        zzXe = zzb1;
        obj;
        JVM INSTR monitorexit ;
        return;
        zzb1;
        obj;
        JVM INSTR monitorexit ;
        throw zzb1;
    }

    static CastDevice zzf(zze zze1)
    {
        return zze1.zzWO;
    }

    static Map zzg(zze zze1)
    {
        return zze1.zzXc;
    }

    static com.google.android.gms.common.api.zzc.zzb zzh(zze zze1)
    {
        return zze1.zzXe;
    }

    private void zzmB()
    {
        zzTy.zzb("removing all MessageReceivedCallbacks", new Object[0]);
        synchronized (zzWP)
        {
            zzWP.clear();
        }
        return;
        exception;
        map;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private void zzmC()
        throws IllegalStateException
    {
        if (!zzWV || zzWR == null || zzWR.isDisposed())
        {
            throw new IllegalStateException("Not connected to a device");
        } else
        {
            return;
        }
    }

    static zzl zzmD()
    {
        return zzTy;
    }

    static Object zzmE()
    {
        return zzXf;
    }

    static Object zzmF()
    {
        return zzXg;
    }

    private void zzmv()
    {
        zzWV = false;
        zzWW = -1;
        zzWX = -1;
        zzWN = null;
        zzWS = null;
        zzUJ = 0.0D;
        zzUK = false;
    }

    public void disconnect()
    {
        zzTy.zzb("disconnect(); ServiceListener=%s, isConnected=%b", new Object[] {
            zzWR, Boolean.valueOf(isConnected())
        });
        zzb zzb1 = zzWR;
        zzWR = null;
        if (zzb1 == null || zzb1.zzmG() == null)
        {
            zzTy.zzb("already disposed, so short-circuiting", new Object[0]);
            return;
        }
        zzmB();
        if (isConnected() || isConnecting())
        {
            ((zzi)zzoA()).disconnect();
        }
        super.disconnect();
        return;
        Object obj;
        obj;
        zzTy.zzb(((Throwable) (obj)), "Error while disconnecting the controller interface: %s", new Object[] {
            ((RemoteException) (obj)).getMessage()
        });
        super.disconnect();
        return;
        obj;
        super.disconnect();
        throw obj;
    }

    public ApplicationMetadata getApplicationMetadata()
        throws IllegalStateException
    {
        zzmC();
        return zzWN;
    }

    public String getApplicationStatus()
        throws IllegalStateException
    {
        zzmC();
        return zzWS;
    }

    public boolean isMute()
        throws IllegalStateException
    {
        zzmC();
        return zzUK;
    }

    public void onConnectionFailed(ConnectionResult connectionresult)
    {
        super.onConnectionFailed(connectionresult);
        zzmB();
    }

    protected IInterface zzV(IBinder ibinder)
    {
        return zzaA(ibinder);
    }

    public void zzV(boolean flag)
        throws IllegalStateException, RemoteException
    {
        ((zzi)zzoA()).zza(flag, zzUJ, zzUK);
    }

    protected void zza(int i, IBinder ibinder, Bundle bundle, int j)
    {
        zzTy.zzb("in onPostInitHandler; statusCode=%d", new Object[] {
            Integer.valueOf(i)
        });
        int k;
        if (i == 0 || i == 1001)
        {
            zzWV = true;
            zzWT = true;
            zzWU = true;
        } else
        {
            zzWV = false;
        }
        k = i;
        if (i == 1001)
        {
            zzXb = new Bundle();
            zzXb.putBoolean("com.google.android.gms.cast.EXTRA_APP_NO_LONGER_RUNNING", true);
            k = 0;
        }
        super.zza(k, ibinder, bundle, j);
    }

    public void zza(String s, com.google.android.gms.cast.Cast.MessageReceivedCallback messagereceivedcallback)
        throws IllegalArgumentException, IllegalStateException, RemoteException
    {
        com.google.android.gms.cast.internal.zzf.zzbL(s);
        zzbK(s);
        if (messagereceivedcallback != null)
        {
            synchronized (zzWP)
            {
                zzWP.put(s, messagereceivedcallback);
            }
            ((zzi)zzoA()).zzbP(s);
        }
        return;
        s;
        map;
        JVM INSTR monitorexit ;
        throw s;
    }

    public void zza(String s, LaunchOptions launchoptions, com.google.android.gms.common.api.zzc.zzb zzb1)
        throws IllegalStateException, RemoteException
    {
        zzc(zzb1);
        ((zzi)zzoA()).zza(s, launchoptions);
    }

    public void zza(String s, com.google.android.gms.common.api.zzc.zzb zzb1)
        throws IllegalStateException, RemoteException
    {
        zze(zzb1);
        ((zzi)zzoA()).zzbO(s);
    }

    public void zza(String s, String s1, com.google.android.gms.common.api.zzc.zzb zzb1)
        throws IllegalArgumentException, IllegalStateException, RemoteException
    {
        if (TextUtils.isEmpty(s1))
        {
            throw new IllegalArgumentException("The message payload cannot be null or empty");
        }
        if (s1.length() > 0x10000)
        {
            throw new IllegalArgumentException("Message exceeds maximum size");
        }
        com.google.android.gms.cast.internal.zzf.zzbL(s);
        zzmC();
        long l = zzWY.incrementAndGet();
        try
        {
            zzXc.put(Long.valueOf(l), zzb1);
            ((zzi)zzoA()).zza(s, s1, l);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            zzXc.remove(Long.valueOf(l));
        }
        throw s;
    }

    public void zza(String s, boolean flag, com.google.android.gms.common.api.zzc.zzb zzb1)
        throws IllegalStateException, RemoteException
    {
        zzc(zzb1);
        ((zzi)zzoA()).zzf(s, flag);
    }

    protected zzi zzaA(IBinder ibinder)
    {
        return zzi.zza.zzaB(ibinder);
    }

    public void zzb(String s, String s1, com.google.android.gms.common.api.zzc.zzb zzb1)
        throws IllegalStateException, RemoteException
    {
        zzc(zzb1);
        ((zzi)zzoA()).zzt(s, s1);
    }

    public void zzbK(String s)
        throws IllegalArgumentException, RemoteException
    {
        if (TextUtils.isEmpty(s))
        {
            throw new IllegalArgumentException("Channel namespace cannot be null or empty");
        }
        com.google.android.gms.cast.Cast.MessageReceivedCallback messagereceivedcallback;
        synchronized (zzWP)
        {
            messagereceivedcallback = (com.google.android.gms.cast.Cast.MessageReceivedCallback)zzWP.remove(s);
        }
        if (messagereceivedcallback == null)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        ((zzi)zzoA()).zzbQ(s);
        return;
        s;
        map;
        JVM INSTR monitorexit ;
        throw s;
        IllegalStateException illegalstateexception;
        illegalstateexception;
        zzTy.zzb(illegalstateexception, "Error unregistering namespace (%s): %s", new Object[] {
            s, illegalstateexception.getMessage()
        });
        return;
    }

    public void zzd(com.google.android.gms.common.api.zzc.zzb zzb1)
        throws IllegalStateException, RemoteException
    {
        zze(zzb1);
        ((zzi)zzoA()).zzmI();
    }

    public void zze(double d)
        throws IllegalArgumentException, IllegalStateException, RemoteException
    {
        if (Double.isInfinite(d) || Double.isNaN(d))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Volume cannot be ").append(d).toString());
        } else
        {
            ((zzi)zzoA()).zza(d, zzUJ, zzUK);
            return;
        }
    }

    protected String zzfA()
    {
        return "com.google.android.gms.cast.service.BIND_CAST_DEVICE_CONTROLLER_SERVICE";
    }

    protected String zzfB()
    {
        return "com.google.android.gms.cast.internal.ICastDeviceController";
    }

    protected Bundle zzli()
    {
        Bundle bundle = new Bundle();
        zzTy.zzb("getRemoteService(): mLastApplicationId=%s, mLastSessionId=%s", new Object[] {
            zzWZ, zzXa
        });
        zzWO.putInBundle(bundle);
        bundle.putLong("com.google.android.gms.cast.EXTRA_CAST_FLAGS", zzWQ);
        zzWR = new zzb(this);
        bundle.putParcelable("listener", new BinderWrapper(zzWR.asBinder()));
        if (zzWZ != null)
        {
            bundle.putString("last_application_id", zzWZ);
            if (zzXa != null)
            {
                bundle.putString("last_session_id", zzXa);
            }
        }
        return bundle;
    }

    public int zzmA()
        throws IllegalStateException
    {
        zzmC();
        return zzWX;
    }

    public Bundle zzmw()
    {
        if (zzXb != null)
        {
            Bundle bundle = zzXb;
            zzXb = null;
            return bundle;
        } else
        {
            return super.zzmw();
        }
    }

    public void zzmx()
        throws IllegalStateException, RemoteException
    {
        ((zzi)zzoA()).zzmx();
    }

    public double zzmy()
        throws IllegalStateException
    {
        zzmC();
        return zzUJ;
    }

    public int zzmz()
        throws IllegalStateException
    {
        zzmC();
        return zzWW;
    }

}
