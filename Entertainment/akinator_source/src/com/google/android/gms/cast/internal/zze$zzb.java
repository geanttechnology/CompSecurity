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
    private final AtomicReference zzZc;

    private void zza(zze zze1, long l, int i)
    {
        synchronized (zze.zzg(zze1))
        {
            zze1 = (com.google.android.gms.internal.)zze.zzg(zze1).remove(Long.valueOf(l));
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
                mHandler.post(new Runnable(zze1, i) {

                    final zze zzZd;
                    final int zzZe;
                    final zze.zzb zzZf;

                    public void run()
                    {
                        if (zze.zzd(zzZd) != null)
                        {
                            zze.zzd(zzZd).onApplicationDisconnected(zzZe);
                        }
                    }

            
            {
                zzZf = zze.zzb.this;
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
                zze.zzc(zze1).zzp(new <init>(new Status(0), applicationmetadata, s, s1, flag));
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
            mHandler.post(new Runnable(zze1, applicationstatus) {

                final zze zzZd;
                final zze.zzb zzZf;
                final ApplicationStatus zzZh;

                public void run()
                {
                    zze.zza(zzZd, zzZh);
                }

            
            {
                zzZf = zze.zzb.this;
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
            mHandler.post(new Runnable(zze1, devicestatus) {

                final zze zzZd;
                final zze.zzb zzZf;
                final DeviceStatus zzZg;

                public void run()
                {
                    zze.zza(zzZd, zzZg);
                }

            
            {
                zzZf = zze.zzb.this;
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
                zze.zzc(zze1).zzp(new <init>(new Status(i)));
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
            mHandler.post(new Runnable(zze1, s, s1) {

                final String zzUQ;
                final zze zzZd;
                final zze.zzb zzZf;
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
                        messagereceivedcallback.onMessageReceived(zze.zzf(zzZd), zzUQ, zzZi);
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
                zzZf = zze.zzb.this;
                zzZd = zze1;
                zzUQ = s;
                zzZi = s1;
                super();
            }
            });
            return;
        }
    }

    public _cls4.zzZi(zze zze1)
    {
        zzZc = new AtomicReference(zze1);
        mHandler = new Handler(zze1.getLooper());
    }
}
