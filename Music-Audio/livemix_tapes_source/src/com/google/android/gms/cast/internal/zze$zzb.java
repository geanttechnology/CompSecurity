// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast.internal;

import android.os.Handler;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.common.api.Status;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

// Referenced classes of package com.google.android.gms.cast.internal:
//            zze, zzl, ApplicationStatus, DeviceStatus

private static class ooper extends ooper
{

    private final Handler mHandler;
    private final AtomicReference zzXk;

    private void zza(zze zze1, long l, int i)
    {
        synchronized (zze.zzg(zze1))
        {
            zze1 = (com.google.android.gms.common.api.zg)zze.zzg(zze1).remove(Long.valueOf(l));
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
                mHandler.post(new Runnable(zze1, i) {

                    final zze zzXl;
                    final int zzXm;
                    final zze.zzb zzXn;

                    public void run()
                    {
                        if (zze.zzd(zzXl) != null)
                        {
                            zze.zzd(zzXl).onApplicationDisconnected(zzXm);
                        }
                    }

            
            {
                zzXn = zze.zzb.this;
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
                zze.zzc(zze1).zzn(new <init>(new Status(0), applicationmetadata, s, s1, flag));
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
                zze.zzc(zze1).zzn(new <init>(new Status(i)));
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
            mHandler.post(new Runnable(zze1, applicationstatus) {

                final zze zzXl;
                final zze.zzb zzXn;
                final ApplicationStatus zzXp;

                public void run()
                {
                    zze.zza(zzXl, zzXp);
                }

            
            {
                zzXn = zze.zzb.this;
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
            mHandler.post(new Runnable(zze1, devicestatus) {

                final zze zzXl;
                final zze.zzb zzXn;
                final DeviceStatus zzXo;

                public void run()
                {
                    zze.zza(zzXl, zzXo);
                }

            
            {
                zzXn = zze.zzb.this;
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
            mHandler.post(new Runnable(zze1, s, s1) {

                final String zzTb;
                final zze zzXl;
                final zze.zzb zzXn;
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
                        messagereceivedcallback.onMessageReceived(zze.zzf(zzXl), zzTb, zzXq);
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
                zzXn = zze.zzb.this;
                zzXl = zze1;
                zzTb = s;
                zzXq = s1;
                super();
            }
            });
            return;
        }
    }

    public _cls4.zzXq(zze zze1)
    {
        zzXk = new AtomicReference(zze1);
        mHandler = new Handler(zze1.getLooper());
    }
}
