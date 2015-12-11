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
import com.google.android.gms.cast.JoinOptions;
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

        private final String zzHP;
        private final Status zzSC;
        private final ApplicationMetadata zzYZ;
        private final String zzZa;
        private final boolean zzZb;

        public ApplicationMetadata getApplicationMetadata()
        {
            return zzYZ;
        }

        public String getApplicationStatus()
        {
            return zzZa;
        }

        public String getSessionId()
        {
            return zzHP;
        }

        public Status getStatus()
        {
            return zzSC;
        }

        public boolean getWasLaunched()
        {
            return zzZb;
        }

        public zza(Status status)
        {
            this(status, null, null, null, false);
        }

        public zza(Status status, ApplicationMetadata applicationmetadata, String s, String s1, boolean flag)
        {
            zzSC = status;
            zzYZ = applicationmetadata;
            zzZa = s;
            zzHP = s1;
            zzZb = flag;
        }
    }

    private static class zzb extends zzj.zza
    {

        private final Handler mHandler;
        private final AtomicReference zzZc;

        private void zza(zze zze1, long l, int i)
        {
            synchronized (zze.zzg(zze1))
            {
                zze1 = (com.google.android.gms.internal.zzlb.zzb)zze.zzg(zze1).remove(Long.valueOf(l));
            }
            if (zze1 != null)
            {
                zze1.zzp(new Status(i));
            }
            return;
            zze1;
            map;
            JVM INSTR monitorexit ;
            throw zze1;
        }

        private boolean zza(zze zze1, int i)
        {
            Object obj = zze.zznb();
            obj;
            JVM INSTR monitorenter ;
            if (zze.zzh(zze1) == null)
            {
                break MISSING_BLOCK_LABEL_40;
            }
            zze.zzh(zze1).zzp(new Status(i));
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
            return zzZc.get() == null;
        }

        public void onApplicationDisconnected(int i)
        {
            zze zze1 = (zze)zzZc.get();
            if (zze1 != null)
            {
                zze.zza(zze1, null);
                zze.zzb(zze1, null);
                zza(zze1, i);
                if (zze.zzd(zze1) != null)
                {
                    mHandler.post(new Runnable(this, zze1, i) {

                        final zze zzZd;
                        final int zzZe;
                        final zzb zzZf;

                        public void run()
                        {
                            if (zze.zzd(zzZd) != null)
                            {
                                zze.zzd(zzZd).onApplicationDisconnected(zzZe);
                            }
                        }

            
            {
                zzZf = zzb1;
                zzZd = zze1;
                zzZe = i;
                super();
            }
                    });
                    return;
                }
            }
        }

        public void zza(ApplicationMetadata applicationmetadata, String s, String s1, boolean flag)
        {
            zze zze1 = (zze)zzZc.get();
            if (zze1 == null)
            {
                return;
            }
            zze.zza(zze1, applicationmetadata);
            zze.zza(zze1, applicationmetadata.getApplicationId());
            zze.zzb(zze1, s1);
            synchronized (zze.zzna())
            {
                if (zze.zzc(zze1) != null)
                {
                    zze.zzc(zze1).zzp(new zza(new Status(0), applicationmetadata, s, s1, flag));
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
            zze.zzmZ().zzb("Deprecated callback: \"onStatusreceived\"", new Object[0]);
        }

        public void zza(String s, long l, int i)
        {
            s = (zze)zzZc.get();
            if (s == null)
            {
                return;
            } else
            {
                zza(((zze) (s)), l, i);
                return;
            }
        }

        public void zzb(ApplicationStatus applicationstatus)
        {
            zze zze1 = (zze)zzZc.get();
            if (zze1 == null)
            {
                return;
            } else
            {
                zze.zzmZ().zzb("onApplicationStatusChanged", new Object[0]);
                mHandler.post(new Runnable(this, zze1, applicationstatus) {

                    final zze zzZd;
                    final zzb zzZf;
                    final ApplicationStatus zzZh;

                    public void run()
                    {
                        zze.zza(zzZd, zzZh);
                    }

            
            {
                zzZf = zzb1;
                zzZd = zze1;
                zzZh = applicationstatus;
                super();
            }
                });
                return;
            }
        }

        public void zzb(DeviceStatus devicestatus)
        {
            zze zze1 = (zze)zzZc.get();
            if (zze1 == null)
            {
                return;
            } else
            {
                zze.zzmZ().zzb("onDeviceStatusChanged", new Object[0]);
                mHandler.post(new Runnable(this, zze1, devicestatus) {

                    final zze zzZd;
                    final zzb zzZf;
                    final DeviceStatus zzZg;

                    public void run()
                    {
                        zze.zza(zzZd, zzZg);
                    }

            
            {
                zzZf = zzb1;
                zzZd = zze1;
                zzZg = devicestatus;
                super();
            }
                });
                return;
            }
        }

        public void zzb(String s, byte abyte0[])
        {
            if ((zze)zzZc.get() == null)
            {
                return;
            } else
            {
                zze.zzmZ().zzb("IGNORING: Receive (type=binary, ns=%s) <%d bytes>", new Object[] {
                    s, Integer.valueOf(abyte0.length)
                });
                return;
            }
        }

        public void zzbb(int i)
        {
            zze zze1 = zznc();
            if (zze1 != null)
            {
                zze.zzmZ().zzb("ICastDeviceControllerListener.onDisconnected: %d", new Object[] {
                    Integer.valueOf(i)
                });
                if (i != 0)
                {
                    zze1.zzbE(2);
                    return;
                }
            }
        }

        public void zzbc(int i)
        {
            zze zze1 = (zze)zzZc.get();
            if (zze1 == null)
            {
                return;
            }
            synchronized (zze.zzna())
            {
                if (zze.zzc(zze1) != null)
                {
                    zze.zzc(zze1).zzp(new zza(new Status(i)));
                    zze.zza(zze1, null);
                }
            }
            return;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public void zzbd(int i)
        {
            zze zze1 = (zze)zzZc.get();
            if (zze1 == null)
            {
                return;
            } else
            {
                zza(zze1, i);
                return;
            }
        }

        public void zzbe(int i)
        {
            zze zze1 = (zze)zzZc.get();
            if (zze1 == null)
            {
                return;
            } else
            {
                zza(zze1, i);
                return;
            }
        }

        public void zzd(String s, long l)
        {
            s = (zze)zzZc.get();
            if (s == null)
            {
                return;
            } else
            {
                zza(s, l, 0);
                return;
            }
        }

        public zze zznc()
        {
            zze zze1 = (zze)zzZc.getAndSet(null);
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
            zze zze1 = (zze)zzZc.get();
            if (zze1 == null)
            {
                return;
            } else
            {
                zze.zzmZ().zzb("Receive (type=text, ns=%s) %s", new Object[] {
                    s, s1
                });
                mHandler.post(new Runnable(this, zze1, s, s1) {

                    final String zzUQ;
                    final zze zzZd;
                    final zzb zzZf;
                    final String zzZi;

                    public void run()
                    {
                        com.google.android.gms.cast.Cast.MessageReceivedCallback messagereceivedcallback;
                        synchronized (zze.zze(zzZd))
                        {
                            messagereceivedcallback = (com.google.android.gms.cast.Cast.MessageReceivedCallback)zze.zze(zzZd).get(zzUQ);
                        }
                        if (messagereceivedcallback != null)
                        {
                            messagereceivedcallback.onMessageReceived(com.google.android.gms.cast.internal.zze.zzf(zzZd), zzUQ, zzZi);
                            return;
                        } else
                        {
                            zze.zzmZ().zzb("Discarded message for unknown namespace '%s'", new Object[] {
                                zzUQ
                            });
                            return;
                        }
                        exception;
                        map;
                        JVM INSTR monitorexit ;
                        throw exception;
                    }

            
            {
                zzZf = zzb1;
                zzZd = zze1;
                zzUQ = s;
                zzZi = s1;
                super();
            }
                });
                return;
            }
        }

        public zzb(zze zze1)
        {
            zzZc = new AtomicReference(zze1);
            mHandler = new Handler(zze1.getLooper());
        }
    }


    private static final zzl zzVo = new zzl("CastClientImpl");
    private static final Object zzYX = new Object();
    private static final Object zzYY = new Object();
    private final com.google.android.gms.cast.Cast.Listener zzUZ;
    private double zzWA;
    private boolean zzWB;
    private ApplicationMetadata zzYF;
    private final CastDevice zzYG;
    private final Map zzYH = new HashMap();
    private final long zzYI;
    private zzb zzYJ;
    private String zzYK;
    private boolean zzYL;
    private boolean zzYM;
    private boolean zzYN;
    private int zzYO;
    private int zzYP;
    private final AtomicLong zzYQ = new AtomicLong(0L);
    private String zzYR;
    private String zzYS;
    private Bundle zzYT;
    private final Map zzYU = new HashMap();
    private com.google.android.gms.internal.zzlb.zzb zzYV;
    private com.google.android.gms.internal.zzlb.zzb zzYW;

    public zze(Context context, Looper looper, zzf zzf1, CastDevice castdevice, long l, com.google.android.gms.cast.Cast.Listener listener, 
            com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
    {
        super(context, looper, 10, zzf1, connectioncallbacks, onconnectionfailedlistener);
        zzYG = castdevice;
        zzUZ = listener;
        zzYI = l;
        zzmR();
    }

    static ApplicationMetadata zza(zze zze1, ApplicationMetadata applicationmetadata)
    {
        zze1.zzYF = applicationmetadata;
        return applicationmetadata;
    }

    static com.google.android.gms.internal.zzlb.zzb zza(zze zze1, com.google.android.gms.internal.zzlb.zzb zzb1)
    {
        zze1.zzYV = zzb1;
        return zzb1;
    }

    static String zza(zze zze1, String s)
    {
        zze1.zzYR = s;
        return s;
    }

    private void zza(ApplicationStatus applicationstatus)
    {
        applicationstatus = applicationstatus.zzmO();
        boolean flag;
        if (!com.google.android.gms.cast.internal.zzf.zza(applicationstatus, zzYK))
        {
            zzYK = applicationstatus;
            flag = true;
        } else
        {
            flag = false;
        }
        zzVo.zzb("hasChanged=%b, mFirstApplicationStatusUpdate=%b", new Object[] {
            Boolean.valueOf(flag), Boolean.valueOf(zzYL)
        });
        if (zzUZ != null && (flag || zzYL))
        {
            zzUZ.onApplicationStatusChanged();
        }
        zzYL = false;
    }

    private void zza(DeviceStatus devicestatus)
    {
        ApplicationMetadata applicationmetadata = devicestatus.getApplicationMetadata();
        if (!com.google.android.gms.cast.internal.zzf.zza(applicationmetadata, zzYF))
        {
            zzYF = applicationmetadata;
            zzUZ.onApplicationMetadataChanged(zzYF);
        }
        double d = devicestatus.zzmU();
        int i;
        boolean flag;
        boolean flag1;
        if (d != (0.0D / 0.0D) && Math.abs(d - zzWA) > 9.9999999999999995E-08D)
        {
            zzWA = d;
            flag = true;
        } else
        {
            flag = false;
        }
        flag1 = devicestatus.zznd();
        if (flag1 != zzWB)
        {
            zzWB = flag1;
            flag = true;
        }
        zzVo.zzb("hasVolumeChanged=%b, mFirstDeviceStatusUpdate=%b", new Object[] {
            Boolean.valueOf(flag), Boolean.valueOf(zzYM)
        });
        if (zzUZ != null && (flag || zzYM))
        {
            zzUZ.onVolumeChanged();
        }
        i = devicestatus.zzmV();
        if (i != zzYO)
        {
            zzYO = i;
            flag = true;
        } else
        {
            flag = false;
        }
        zzVo.zzb("hasActiveInputChanged=%b, mFirstDeviceStatusUpdate=%b", new Object[] {
            Boolean.valueOf(flag), Boolean.valueOf(zzYM)
        });
        if (zzUZ != null && (flag || zzYM))
        {
            zzUZ.onActiveInputStateChanged(zzYO);
        }
        i = devicestatus.zzmW();
        if (i != zzYP)
        {
            zzYP = i;
            flag = true;
        } else
        {
            flag = false;
        }
        zzVo.zzb("hasStandbyStateChanged=%b, mFirstDeviceStatusUpdate=%b", new Object[] {
            Boolean.valueOf(flag), Boolean.valueOf(zzYM)
        });
        if (zzUZ != null && (flag || zzYM))
        {
            zzUZ.onStandbyStateChanged(zzYP);
        }
        zzYM = false;
    }

    static void zza(zze zze1, ApplicationStatus applicationstatus)
    {
        zze1.zza(applicationstatus);
    }

    static void zza(zze zze1, DeviceStatus devicestatus)
    {
        zze1.zza(devicestatus);
    }

    private void zza(com.google.android.gms.internal.zzlb.zzb zzb1)
    {
        synchronized (zzYX)
        {
            if (zzYV != null)
            {
                zzYV.zzp(new zza(new Status(2002)));
            }
            zzYV = zzb1;
        }
        return;
        zzb1;
        obj;
        JVM INSTR monitorexit ;
        throw zzb1;
    }

    static com.google.android.gms.internal.zzlb.zzb zzb(zze zze1, com.google.android.gms.internal.zzlb.zzb zzb1)
    {
        zze1.zzYW = zzb1;
        return zzb1;
    }

    static String zzb(zze zze1, String s)
    {
        zze1.zzYS = s;
        return s;
    }

    static void zzb(zze zze1)
    {
        zze1.zzmR();
    }

    static com.google.android.gms.internal.zzlb.zzb zzc(zze zze1)
    {
        return zze1.zzYV;
    }

    private void zzc(com.google.android.gms.internal.zzlb.zzb zzb1)
    {
label0:
        {
            synchronized (zzYY)
            {
                if (zzYW == null)
                {
                    break label0;
                }
                zzb1.zzp(new Status(2001));
            }
            return;
        }
        zzYW = zzb1;
        obj;
        JVM INSTR monitorexit ;
        return;
        zzb1;
        obj;
        JVM INSTR monitorexit ;
        throw zzb1;
    }

    static com.google.android.gms.cast.Cast.Listener zzd(zze zze1)
    {
        return zze1.zzUZ;
    }

    static Map zze(zze zze1)
    {
        return zze1.zzYH;
    }

    static CastDevice zzf(zze zze1)
    {
        return zze1.zzYG;
    }

    static Map zzg(zze zze1)
    {
        return zze1.zzYU;
    }

    static com.google.android.gms.internal.zzlb.zzb zzh(zze zze1)
    {
        return zze1.zzYW;
    }

    private void zzmR()
    {
        zzYN = false;
        zzYO = -1;
        zzYP = -1;
        zzYF = null;
        zzYK = null;
        zzWA = 0.0D;
        zzWB = false;
    }

    private void zzmX()
    {
        zzVo.zzb("removing all MessageReceivedCallbacks", new Object[0]);
        synchronized (zzYH)
        {
            zzYH.clear();
        }
        return;
        exception;
        map;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private void zzmY()
        throws IllegalStateException
    {
        if (!zzYN || zzYJ == null || zzYJ.isDisposed())
        {
            throw new IllegalStateException("Not connected to a device");
        } else
        {
            return;
        }
    }

    static zzl zzmZ()
    {
        return zzVo;
    }

    static Object zzna()
    {
        return zzYX;
    }

    static Object zznb()
    {
        return zzYY;
    }

    public void disconnect()
    {
        zzVo.zzb("disconnect(); ServiceListener=%s, isConnected=%b", new Object[] {
            zzYJ, Boolean.valueOf(isConnected())
        });
        zzb zzb1 = zzYJ;
        zzYJ = null;
        if (zzb1 == null || zzb1.zznc() == null)
        {
            zzVo.zzb("already disposed, so short-circuiting", new Object[0]);
            return;
        }
        zzmX();
        ((zzi)zzpc()).disconnect();
        super.disconnect();
        return;
        Object obj;
        obj;
_L2:
        zzVo.zzb(((Throwable) (obj)), "Error while disconnecting the controller interface: %s", new Object[] {
            ((Exception) (obj)).getMessage()
        });
        super.disconnect();
        return;
        obj;
        super.disconnect();
        throw obj;
        obj;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public ApplicationMetadata getApplicationMetadata()
        throws IllegalStateException
    {
        zzmY();
        return zzYF;
    }

    public String getApplicationStatus()
        throws IllegalStateException
    {
        zzmY();
        return zzYK;
    }

    public boolean isMute()
        throws IllegalStateException
    {
        zzmY();
        return zzWB;
    }

    public void onConnectionFailed(ConnectionResult connectionresult)
    {
        super.onConnectionFailed(connectionresult);
        zzmX();
    }

    protected IInterface zzW(IBinder ibinder)
    {
        return zzaA(ibinder);
    }

    public void zzW(boolean flag)
        throws IllegalStateException, RemoteException
    {
        ((zzi)zzpc()).zza(flag, zzWA, zzWB);
    }

    protected void zza(int i, IBinder ibinder, Bundle bundle, int j)
    {
        zzVo.zzb("in onPostInitHandler; statusCode=%d", new Object[] {
            Integer.valueOf(i)
        });
        int k;
        if (i == 0 || i == 1001)
        {
            zzYN = true;
            zzYL = true;
            zzYM = true;
        } else
        {
            zzYN = false;
        }
        k = i;
        if (i == 1001)
        {
            zzYT = new Bundle();
            zzYT.putBoolean("com.google.android.gms.cast.EXTRA_APP_NO_LONGER_RUNNING", true);
            k = 0;
        }
        super.zza(k, ibinder, bundle, j);
    }

    public void zza(String s, com.google.android.gms.cast.Cast.MessageReceivedCallback messagereceivedcallback)
        throws IllegalArgumentException, IllegalStateException, RemoteException
    {
        com.google.android.gms.cast.internal.zzf.zzbM(s);
        zzbL(s);
        if (messagereceivedcallback != null)
        {
            synchronized (zzYH)
            {
                zzYH.put(s, messagereceivedcallback);
            }
            ((zzi)zzpc()).zzbQ(s);
        }
        return;
        s;
        map;
        JVM INSTR monitorexit ;
        throw s;
    }

    public void zza(String s, LaunchOptions launchoptions, com.google.android.gms.internal.zzlb.zzb zzb1)
        throws IllegalStateException, RemoteException
    {
        zza(zzb1);
        ((zzi)zzpc()).zza(s, launchoptions);
    }

    public void zza(String s, com.google.android.gms.internal.zzlb.zzb zzb1)
        throws IllegalStateException, RemoteException
    {
        zzc(zzb1);
        ((zzi)zzpc()).zzbP(s);
    }

    public void zza(String s, String s1, JoinOptions joinoptions, com.google.android.gms.internal.zzlb.zzb zzb1)
        throws IllegalStateException, RemoteException
    {
        zza(zzb1);
        zzb1 = joinoptions;
        if (joinoptions == null)
        {
            zzb1 = new JoinOptions();
        }
        ((zzi)zzpc()).zza(s, s1, zzb1);
    }

    public void zza(String s, String s1, com.google.android.gms.internal.zzlb.zzb zzb1)
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
        com.google.android.gms.cast.internal.zzf.zzbM(s);
        zzmY();
        long l = zzYQ.incrementAndGet();
        try
        {
            zzYU.put(Long.valueOf(l), zzb1);
            ((zzi)zzpc()).zzb(s, s1, l);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            zzYU.remove(Long.valueOf(l));
        }
        throw s;
    }

    public void zza(String s, boolean flag, com.google.android.gms.internal.zzlb.zzb zzb1)
        throws IllegalStateException, RemoteException
    {
        zza(zzb1);
        ((zzi)zzpc()).zzf(s, flag);
    }

    protected zzi zzaA(IBinder ibinder)
    {
        return zzi.zza.zzaB(ibinder);
    }

    public void zzb(com.google.android.gms.internal.zzlb.zzb zzb1)
        throws IllegalStateException, RemoteException
    {
        zzc(zzb1);
        ((zzi)zzpc()).zzne();
    }

    public void zzbL(String s)
        throws IllegalArgumentException, RemoteException
    {
        if (TextUtils.isEmpty(s))
        {
            throw new IllegalArgumentException("Channel namespace cannot be null or empty");
        }
        com.google.android.gms.cast.Cast.MessageReceivedCallback messagereceivedcallback;
        synchronized (zzYH)
        {
            messagereceivedcallback = (com.google.android.gms.cast.Cast.MessageReceivedCallback)zzYH.remove(s);
        }
        if (messagereceivedcallback == null)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        ((zzi)zzpc()).zzbR(s);
        return;
        s;
        map;
        JVM INSTR monitorexit ;
        throw s;
        IllegalStateException illegalstateexception;
        illegalstateexception;
        zzVo.zzb(illegalstateexception, "Error unregistering namespace (%s): %s", new Object[] {
            s, illegalstateexception.getMessage()
        });
        return;
    }

    public void zzf(double d)
        throws IllegalArgumentException, IllegalStateException, RemoteException
    {
        if (Double.isInfinite(d) || Double.isNaN(d))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Volume cannot be ").append(d).toString());
        } else
        {
            ((zzi)zzpc()).zza(d, zzWA, zzWB);
            return;
        }
    }

    protected String zzfK()
    {
        return "com.google.android.gms.cast.service.BIND_CAST_DEVICE_CONTROLLER_SERVICE";
    }

    protected String zzfL()
    {
        return "com.google.android.gms.cast.internal.ICastDeviceController";
    }

    protected Bundle zzly()
    {
        Bundle bundle = new Bundle();
        zzVo.zzb("getRemoteService(): mLastApplicationId=%s, mLastSessionId=%s", new Object[] {
            zzYR, zzYS
        });
        zzYG.putInBundle(bundle);
        bundle.putLong("com.google.android.gms.cast.EXTRA_CAST_FLAGS", zzYI);
        zzYJ = new zzb(this);
        bundle.putParcelable("listener", new BinderWrapper(zzYJ.asBinder()));
        if (zzYR != null)
        {
            bundle.putString("last_application_id", zzYR);
            if (zzYS != null)
            {
                bundle.putString("last_session_id", zzYS);
            }
        }
        return bundle;
    }

    public Bundle zzmS()
    {
        if (zzYT != null)
        {
            Bundle bundle = zzYT;
            zzYT = null;
            return bundle;
        } else
        {
            return super.zzmS();
        }
    }

    public void zzmT()
        throws IllegalStateException, RemoteException
    {
        ((zzi)zzpc()).zzmT();
    }

    public double zzmU()
        throws IllegalStateException
    {
        zzmY();
        return zzWA;
    }

    public int zzmV()
        throws IllegalStateException
    {
        zzmY();
        return zzYO;
    }

    public int zzmW()
        throws IllegalStateException
    {
        zzmY();
        return zzYP;
    }

}
