// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.measurement.AppMeasurementReceiver;
import com.google.android.gms.measurement.AppMeasurementService;
import com.google.android.gms.measurement.zza;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.android.gms.measurement.internal:
//            zzz, zzs, zzp, zzf, 
//            zzn, zzd, zzq, zzab, 
//            zzaa, zzad, zzu, zzr, 
//            zzc, zzag, zzy, AppMetadata, 
//            zza, zzg, zzae, EventParams, 
//            UserAttributeParcel, EventParcel, zzh, zzx

public class zzv
{

    private static zzz zzaNK;
    private static volatile zzv zzaNL;
    private final Context mContext;
    private final boolean zzMF = true;
    private final zzc zzaNM;
    private final zzs zzaNN;
    private final zzp zzaNO;
    private final zzu zzaNP;
    private final zza zzaNQ;
    private final zzag zzaNR;
    private final zzd zzaNS;
    private final zzq zzaNT;
    private final zzab zzaNU;
    private final zzf zzaNV;
    private final zzaa zzaNW;
    private final zzn zzaNX;
    private final zzr zzaNY;
    private final zzad zzaNZ;
    private Boolean zzaOa;
    private List zzaOb;
    private int zzaOc;
    private int zzaOd;
    private final zzmn zzpW;

    zzv(zzz zzz1)
    {
        zzx.zzw(zzz1);
        mContext = zzz1.mContext;
        zzpW = zzz1.zzj(this);
        zzaNM = zzz1.zza(this);
        Object obj = zzz1.zzb(this);
        ((zzs) (obj)).zza();
        zzaNN = ((zzs) (obj));
        obj = zzz1.zzc(this);
        ((zzp) (obj)).zza();
        zzaNO = ((zzp) (obj));
        zzaNR = zzz1.zzg(this);
        obj = zzz1.zzl(this);
        ((zzf) (obj)).zza();
        zzaNV = ((zzf) (obj));
        obj = zzz1.zzm(this);
        ((zzn) (obj)).zza();
        zzaNX = ((zzn) (obj));
        obj = zzz1.zzh(this);
        ((zzd) (obj)).zza();
        zzaNS = ((zzd) (obj));
        obj = zzz1.zzi(this);
        ((zzq) (obj)).zza();
        zzaNT = ((zzq) (obj));
        obj = zzz1.zzk(this);
        ((zzab) (obj)).zza();
        zzaNU = ((zzab) (obj));
        obj = zzz1.zzf(this);
        ((zzaa) (obj)).zza();
        zzaNW = ((zzaa) (obj));
        obj = zzz1.zzo(this);
        ((zzad) (obj)).zza();
        zzaNZ = ((zzad) (obj));
        zzaNY = zzz1.zzn(this);
        zzaNQ = zzz1.zze(this);
        zzz1 = zzz1.zzd(this);
        zzz1.zza();
        zzaNP = zzz1;
        if (zzaOc != zzaOd)
        {
            zzyd().zzzK().zze("Not all components initialized", Integer.valueOf(zzaOc), Integer.valueOf(zzaOd));
        }
        zzaNP.zzh(new Runnable() {

            final zzv zzaOe;

            public void run()
            {
                zzaOe.start();
            }

            
            {
                zzaOe = zzv.this;
                super();
            }
        });
    }

    private boolean zzAj()
    {
        zzis();
        return zzaOb != null;
    }

    private boolean zzAl()
    {
        return !TextUtils.isEmpty(zzAd().zzzu());
    }

    private void zzAm()
    {
        zzis();
        zziE();
        if (!zzAa() || !zzAl())
        {
            zzAg().unregister();
            zzAh().cancel();
            return;
        }
        long l1 = zzAn();
        if (l1 == 0L)
        {
            zzAg().unregister();
            zzAh().cancel();
            return;
        }
        if (!zzAe().zzkK())
        {
            zzAg().zzkH();
            zzAh().cancel();
            return;
        }
        long l2 = zzzs().zzaNk.get();
        long l3 = zzzt().zzzi();
        long l = l1;
        if (!zzzq().zzc(l2, l3))
        {
            l = Math.max(l1, l2 + l3);
        }
        zzAg().unregister();
        l -= zzit().currentTimeMillis();
        if (l <= 0L)
        {
            zzAh().zzt(1L);
            return;
        } else
        {
            zzyd().zzzQ().zzj("Upload scheduled in approximately ms", Long.valueOf(l));
            zzAh().zzt(l);
            return;
        }
    }

    private long zzAn()
    {
        long l;
        long l1;
        long l2;
        long l3;
        long l4;
        long l5;
        l4 = zzit().currentTimeMillis();
        l = zzzt().zzzk();
        l1 = zzzt().zzzj();
        l3 = zzzs().zzaNi.get();
        l2 = zzzs().zzaNj.get();
        l5 = zzAd().zzzx();
        if (l5 != 0L) goto _L2; else goto _L1
_L1:
        l1 = 0L;
_L4:
        return l1;
_L2:
        l4 -= Math.abs(l5 - l4);
        l += l4;
        if (!zzzq().zzc(l3, l1))
        {
            l = l3 + l1;
        }
        l1 = l;
        if (l2 != 0L)
        {
            l1 = l;
            if (l2 >= l4)
            {
                int i = 0;
label0:
                do
                {
label1:
                    {
                        if (i >= zzzt().zzzm())
                        {
                            break label1;
                        }
                        l += (long)(1 << i) * zzzt().zzzl();
                        l1 = l;
                        if (l > l2)
                        {
                            break label0;
                        }
                        i++;
                    }
                } while (true);
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
        return 0L;
    }

    static void zza(zzv zzv1, int i, Throwable throwable, byte abyte0[])
    {
        zzv1.zzb(i, throwable, abyte0);
    }

    private void zza(com.google.android.gms.measurement.internal.zzx zzx1)
    {
        if (zzx1 == null)
        {
            throw new IllegalStateException("Component not created");
        } else
        {
            return;
        }
    }

    private void zza(zzy zzy1)
    {
        if (zzy1 == null)
        {
            throw new IllegalStateException("Component not created");
        }
        if (!zzy1.isInitialized())
        {
            throw new IllegalStateException("Component not initialized");
        } else
        {
            return;
        }
    }

    public static zzv zzaL(Context context)
    {
        zzx.zzw(context);
        zzx.zzw(context.getApplicationContext());
        if (zzaNL != null) goto _L2; else goto _L1
_L1:
        com/google/android/gms/measurement/internal/zzv;
        JVM INSTR monitorenter ;
        if (zzaNL != null) goto _L4; else goto _L3
_L3:
        if (zzaNK == null)
        {
            break MISSING_BLOCK_LABEL_52;
        }
        context = zzaNK;
_L5:
        zzaNL = context.zzAq();
_L4:
        com/google/android/gms/measurement/internal/zzv;
        JVM INSTR monitorexit ;
_L2:
        return zzaNL;
        context = new zzz(context);
          goto _L5
        context;
        com/google/android/gms/measurement/internal/zzv;
        JVM INSTR monitorexit ;
        throw context;
    }

    private void zzb(int i, Throwable throwable, byte abyte0[])
    {
        boolean flag;
        flag = false;
        zzis();
        zziE();
        byte abyte1[] = abyte0;
        if (abyte0 == null)
        {
            abyte1 = new byte[0];
        }
        abyte0 = zzaOb;
        zzaOb = null;
        if (i != 200 && i != 204 || throwable != null)
        {
            break MISSING_BLOCK_LABEL_206;
        }
        zzzs().zzaNi.set(zzit().currentTimeMillis());
        zzzs().zzaNj.set(0L);
        zzAm();
        zzyd().zzzQ().zze("Successful upload. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(abyte1.length));
        zzAd().beginTransaction();
        for (throwable = abyte0.iterator(); throwable.hasNext(); zzAd().zzN(abyte0.longValue()))
        {
            abyte0 = (Long)throwable.next();
        }

        break MISSING_BLOCK_LABEL_165;
        throwable;
        zzAd().endTransaction();
        throw throwable;
        zzAd().setTransactionSuccessful();
        zzAd().endTransaction();
        if (zzAe().zzkK() && zzAl())
        {
            zzAk();
            return;
        } else
        {
            zzAm();
            return;
        }
        zzyd().zzzQ().zze("Network upload failed. Will retry later. code, error", Integer.valueOf(i), throwable);
        zzzs().zzaNj.set(zzit().currentTimeMillis());
        if (i == 503)
        {
            flag = true;
        }
        if (flag)
        {
            zzzs().zzaNk.set(zzit().currentTimeMillis());
        }
        zzAm();
        return;
    }

    private void zzc(AppMetadata appmetadata)
    {
        com.google.android.gms.measurement.internal.zza zza2;
        String s;
        boolean flag;
        zzis();
        zziE();
        zzx.zzw(appmetadata);
        zzx.zzcr(appmetadata.packageName);
        zza2 = zzAd().zzea(appmetadata.packageName);
        s = zzzs().zzzT();
        flag = false;
        if (zza2 != null) goto _L2; else goto _L1
_L1:
        com.google.android.gms.measurement.internal.zza zza1;
        zza1 = new com.google.android.gms.measurement.internal.zza(appmetadata.packageName, zzzs().zzzU(), appmetadata.zzaLP, s, 0L, 0L);
        flag = true;
_L4:
        boolean flag1 = flag;
        zza2 = zza1;
        if (!TextUtils.isEmpty(appmetadata.zzaLP))
        {
            flag1 = flag;
            zza2 = zza1;
            if (!appmetadata.zzaLP.equals(zza1.zzaLL))
            {
                zza2 = zza1.zzdY(appmetadata.zzaLP);
                flag1 = true;
            }
        }
        if (flag1)
        {
            zzAd().zza(zza2);
        }
        return;
_L2:
        zza1 = zza2;
        if (!s.equals(zza2.zzaLM))
        {
            zza1 = zza2.zzG(zzzs().zzzU(), s);
            flag = true;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void zzv(List list)
    {
        boolean flag;
        if (!list.isEmpty())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzaa(flag);
        if (zzaOb != null)
        {
            zzyd().zzzK().zzec("Set uploading progress before finishing the previous upload");
            return;
        } else
        {
            zzaOb = new ArrayList(list);
            return;
        }
    }

    public Context getContext()
    {
        return mContext;
    }

    protected void start()
    {
        zzis();
        zzyd().zzzO().zzec("App measurement is starting up");
        zzyd().zzzP().zzec("Debug logging enabled");
        if (zzAa()) goto _L2; else goto _L1
_L1:
        if (!zzzq().zzbh("android.permission.INTERNET"))
        {
            zzyd().zzzK().zzec("App is missing INTERNET permission");
        }
        if (!zzzq().zzbh("android.permission.ACCESS_NETWORK_STATE"))
        {
            zzyd().zzzK().zzec("App is missing ACCESS_NETWORK_STATE permission");
        }
        if (!AppMeasurementReceiver.zzV(getContext()))
        {
            zzyd().zzzK().zzec("AppMeasurementReceiver not registered/enabled");
        }
        if (!AppMeasurementService.zzW(getContext()))
        {
            zzyd().zzzK().zzec("AppMeasurementService not registered/enabled");
        }
        zzyd().zzzK().zzec("Uploading is not possible. App measurement disabled");
_L4:
        zzAm();
        return;
_L2:
        if (!zzzt().zzjA() && !TextUtils.isEmpty(zzzo().zzzH()))
        {
            zzAc().zzAr();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected boolean zzAa()
    {
        boolean flag1 = true;
        zziE();
        zzis();
        if (zzaOa == null)
        {
            boolean flag;
            if (zzzq().zzbh("android.permission.INTERNET") && zzzq().zzbh("android.permission.ACCESS_NETWORK_STATE") && AppMeasurementReceiver.zzV(getContext()) && AppMeasurementService.zzW(getContext()))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzaOa = Boolean.valueOf(flag);
            if (zzaOa.booleanValue() && !zzzt().zzjA())
            {
                if (!TextUtils.isEmpty(zzzo().zzzH()))
                {
                    flag = flag1;
                } else
                {
                    flag = false;
                }
                zzaOa = Boolean.valueOf(flag);
            }
        }
        return zzaOa.booleanValue();
    }

    zzu zzAb()
    {
        return zzaNP;
    }

    public zzaa zzAc()
    {
        zza(zzaNW);
        return zzaNW;
    }

    public zzd zzAd()
    {
        zza(zzaNS);
        return zzaNS;
    }

    public zzq zzAe()
    {
        zza(zzaNT);
        return zzaNT;
    }

    public zzf zzAf()
    {
        zza(zzaNV);
        return zzaNV;
    }

    public zzr zzAg()
    {
        if (zzaNY == null)
        {
            throw new IllegalStateException("Network broadcast receiver not created");
        } else
        {
            return zzaNY;
        }
    }

    public zzad zzAh()
    {
        zza(zzaNZ);
        return zzaNZ;
    }

    protected boolean zzAi()
    {
        return false;
    }

    public void zzAk()
    {
        boolean flag;
        flag = false;
        zzis();
        zziE();
        if (zzzt().zzjA()) goto _L2; else goto _L1
_L1:
        Object obj = zzzs().zzzW();
        if (obj != null) goto _L4; else goto _L3
_L3:
        zzyd().zzzL().zzec("Upload data called on the client side before use of service was decided");
_L6:
        return;
_L4:
        if (((Boolean) (obj)).booleanValue())
        {
            zzyd().zzzK().zzec("Upload called in the client side when service should be used");
            return;
        }
_L2:
        if (zzAj())
        {
            zzyd().zzzL().zzec("Uploading requested multiple times");
            return;
        }
        if (!zzAe().zzkK())
        {
            zzyd().zzzL().zzec("Network not connected, ignoring upload request");
            zzAm();
            return;
        }
        long l1 = zzzs().zzaNi.get();
        if (l1 != 0L)
        {
            l1 = Math.abs(zzit().currentTimeMillis() - l1);
            zzyd().zzzP().zzj("Uploading events. Elapsed time since last upload attempt (ms)", Long.valueOf(l1));
        }
        obj = zzAd().zzzu();
        if (TextUtils.isEmpty(((CharSequence) (obj)))) goto _L6; else goto _L5
_L5:
        Object obj1;
        int i = zzzt().zzzf();
        int l = zzzt().zzzg();
        obj1 = zzAd().zzn(((String) (obj)), i, l);
        if (((List) (obj1)).isEmpty()) goto _L6; else goto _L7
_L7:
        obj = ((List) (obj1)).iterator();
_L11:
        if (!((Iterator) (obj)).hasNext()) goto _L9; else goto _L8
_L8:
        com.google.android.gms.internal.zzpk.zzd zzd1 = (com.google.android.gms.internal.zzpk.zzd)((Pair)((Iterator) (obj)).next()).first;
        if (TextUtils.isEmpty(zzd1.zzaPa)) goto _L11; else goto _L10
_L10:
        obj = zzd1.zzaPa;
_L20:
        if (obj == null) goto _L13; else goto _L12
_L12:
        int j = 0;
_L15:
        if (j >= ((List) (obj1)).size())
        {
            break; /* Loop/switch isn't completed */
        }
        zzd1 = (com.google.android.gms.internal.zzpk.zzd)((Pair)((List) (obj1)).get(j)).first;
          goto _L14
_L17:
        j++;
        if (true) goto _L15; else goto _L13
_L14:
        if (TextUtils.isEmpty(zzd1.zzaPa) || zzd1.zzaPa.equals(obj)) goto _L17; else goto _L16
_L16:
        obj = ((List) (obj1)).subList(0, j);
_L18:
        com.google.android.gms.internal.zzpk.zzc zzc1 = new com.google.android.gms.internal.zzpk.zzc();
        zzc1.zzaOI = new com.google.android.gms.internal.zzpk.zzd[((List) (obj)).size()];
        obj1 = new ArrayList(((List) (obj)).size());
        long l2 = zzit().currentTimeMillis();
        for (int k = ((flag) ? 1 : 0); k < zzc1.zzaOI.length; k++)
        {
            zzc1.zzaOI[k] = (com.google.android.gms.internal.zzpk.zzd)((Pair)((List) (obj)).get(k)).first;
            ((List) (obj1)).add(((Pair)((List) (obj)).get(k)).second);
            zzc1.zzaOI[k].zzaOZ = Long.valueOf(zzzt().zzzb());
            zzc1.zzaOI[k].zzaON = Long.valueOf(l2);
            zzc1.zzaOI[k].zzaPg = Boolean.valueOf(zzzt().zzjA());
        }

        byte abyte0[] = zzzq().zza(zzc1);
        obj = zzzt().zzzh();
        try
        {
            URL url = new URL(((String) (obj)));
            zzv(((List) (obj1)));
            zzzs().zzaNj.set(zzit().currentTimeMillis());
            zzAe().zza(url, abyte0, new zzq.zza() {

                final zzv zzaOe;

                public void zza(int i1, Throwable throwable, byte abyte1[])
                {
                    com.google.android.gms.measurement.internal.zzv.zza(zzaOe, i1, throwable, abyte1);
                }

            
            {
                zzaOe = zzv.this;
                super();
            }
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            zzyd().zzzK().zzj("Failed to parse upload URL. Not uploading", obj);
        }
        return;
_L13:
        obj = obj1;
        if (true) goto _L18; else goto _L9
_L9:
        obj = null;
        if (true) goto _L20; else goto _L19
_L19:
    }

    void zzAo()
    {
        zzaOd = zzaOd + 1;
    }

    public void zzI(boolean flag)
    {
        zzAm();
    }

    com.google.android.gms.internal.zzpk.zzd zza(zzg azzg[], AppMetadata appmetadata)
    {
        Object obj1 = null;
        zzx.zzw(appmetadata);
        zzx.zzw(azzg);
        zzis();
        com.google.android.gms.internal.zzpk.zzd zzd1 = new com.google.android.gms.internal.zzpk.zzd();
        zzd1.zzaOK = Integer.valueOf(1);
        zzd1.zzaOS = "android";
        zzd1.zzaOX = appmetadata.packageName;
        zzd1.zzaLQ = appmetadata.zzaLQ;
        zzd1.zzaDC = appmetadata.zzaDC;
        zzd1.zzaOY = Long.valueOf(appmetadata.zzaLR);
        zzd1.zzaLP = appmetadata.zzaLP;
        Object obj;
        if (appmetadata.zzaLS == 0L)
        {
            obj = null;
        } else
        {
            obj = Long.valueOf(appmetadata.zzaLS);
        }
        zzd1.zzaPd = ((Long) (obj));
        obj = zzzs().zzzS();
        if (obj != null && ((Pair) (obj)).first != null && ((Pair) (obj)).second != null)
        {
            zzd1.zzaPa = (String)((Pair) (obj)).first;
            zzd1.zzaPb = (Boolean)((Pair) (obj)).second;
        }
        zzd1.zzaOU = zzAf().zzgE();
        zzd1.zzaOT = zzAf().zzzy();
        zzd1.zzaOW = Integer.valueOf((int)zzAf().zzzz());
        zzd1.zzaOV = zzAf().zzzA();
        zzd1.zzaOZ = null;
        zzd1.zzaON = null;
        zzd1.zzaOO = Long.valueOf(azzg[0].zzZH);
        zzd1.zzaOP = Long.valueOf(azzg[0].zzZH);
        for (int i = 1; i < azzg.length; i++)
        {
            zzd1.zzaOO = Long.valueOf(Math.min(zzd1.zzaOO.longValue(), azzg[i].zzZH));
            zzd1.zzaOP = Long.valueOf(Math.max(zzd1.zzaOP.longValue(), azzg[i].zzZH));
        }

        com.google.android.gms.measurement.internal.zza zza1 = zzAd().zzea(appmetadata.packageName);
        obj = zza1;
        if (zza1 == null)
        {
            obj = new com.google.android.gms.measurement.internal.zza(appmetadata.packageName, zzzs().zzzU(), appmetadata.zzaLP, zzzs().zzzT(), 0L, 0L);
        }
        zza1 = ((com.google.android.gms.measurement.internal.zza) (obj)).zza(zzyd(), zzd1.zzaOP.longValue());
        zzAd().zza(zza1);
        zzd1.zzaPc = zza1.zzaLK;
        zzd1.zzaPe = Integer.valueOf((int)zza1.zzaLN);
        if (((com.google.android.gms.measurement.internal.zza) (obj)).zzaLO == 0L)
        {
            obj = obj1;
        } else
        {
            obj = Long.valueOf(((com.google.android.gms.measurement.internal.zza) (obj)).zzaLO);
        }
        zzd1.zzaOR = ((Long) (obj));
        zzd1.zzaOQ = zzd1.zzaOR;
        appmetadata = zzAd().zzdZ(appmetadata.packageName);
        zzd1.zzaOM = new com.google.android.gms.internal.zzpk.zze[appmetadata.size()];
        for (int j = 0; j < appmetadata.size(); j++)
        {
            obj = new com.google.android.gms.internal.zzpk.zze();
            zzd1.zzaOM[j] = ((com.google.android.gms.internal.zzpk.zze) (obj));
            obj.name = ((zzae)appmetadata.get(j)).mName;
            obj.zzaPi = Long.valueOf(((zzae)appmetadata.get(j)).zzaOy);
            zzzq().zza(((com.google.android.gms.internal.zzpk.zze) (obj)), ((zzae)appmetadata.get(j)).zzJy);
        }

        zzd1.zzaOL = new com.google.android.gms.internal.zzpk.zza[azzg.length];
        for (int k = 0; k < azzg.length; k++)
        {
            appmetadata = new com.google.android.gms.internal.zzpk.zza();
            zzd1.zzaOL[k] = appmetadata;
            appmetadata.name = azzg[k].mName;
            appmetadata.zzaOE = Long.valueOf(azzg[k].zzZH);
            appmetadata.zzaOD = new com.google.android.gms.internal.zzpk.zzb[azzg[k].zzaMd.size()];
            Iterator iterator = azzg[k].zzaMd.iterator();
            for (int l = 0; iterator.hasNext(); l++)
            {
                Object obj2 = (String)iterator.next();
                com.google.android.gms.internal.zzpk.zzb zzb1 = new com.google.android.gms.internal.zzpk.zzb();
                ((com.google.android.gms.internal.zzpk.zza) (appmetadata)).zzaOD[l] = zzb1;
                zzb1.name = ((String) (obj2));
                obj2 = azzg[k].zzaMd.get(((String) (obj2)));
                zzzq().zza(zzb1, obj2);
            }

        }

        zzd1.zzaPf = zzyd().zzzR();
        return zzd1;
    }

    public void zzb(AppMetadata appmetadata)
    {
        zzis();
        zziE();
        zzx.zzw(appmetadata);
        zzx.zzcr(appmetadata.packageName);
        if (!TextUtils.isEmpty(appmetadata.zzaLP))
        {
            zzc(appmetadata);
            if (zzAd().zzH(appmetadata.packageName, "_f") == null)
            {
                long l = zzit().currentTimeMillis();
                zzb(new UserAttributeParcel("_fot", l, Long.valueOf(0x36ee80L * (l / 0x36ee80L + 1L)), "auto"), appmetadata);
                Bundle bundle = new Bundle();
                bundle.putLong("_c", 1L);
                zzb(new EventParcel("_f", new EventParams(bundle), "auto", l), appmetadata);
                zzAm();
                return;
            }
        }
    }

    void zzb(EventParcel eventparcel, AppMetadata appmetadata)
    {
        zzis();
        zziE();
        zzx.zzcr(appmetadata.packageName);
        if (TextUtils.isEmpty(appmetadata.zzaLP))
        {
            return;
        }
        zzyd().zzzQ().zzj("Logging event", eventparcel);
        eventparcel = new zzg(this, eventparcel.zzaMl, appmetadata.packageName, eventparcel.name, eventparcel.zzaMm, 0L, eventparcel.zzaMk.zzzB());
        zzAd().beginTransaction();
        zzh zzh1;
        zzc(appmetadata);
        zzh1 = zzAd().zzH(appmetadata.packageName, ((zzg) (eventparcel)).mName);
        if (zzh1 != null)
        {
            break MISSING_BLOCK_LABEL_191;
        }
        zzh1 = new zzh(appmetadata.packageName, ((zzg) (eventparcel)).mName, 1L, 1L, ((zzg) (eventparcel)).zzZH);
_L1:
        zzAd().zza(zzh1);
        appmetadata = zza(new zzg[] {
            eventparcel
        }, appmetadata);
        zzAd().zza(appmetadata);
        zzAd().setTransactionSuccessful();
        zzyd().zzzP().zzj("Event logged", eventparcel);
        zzAd().endTransaction();
        zzAm();
        return;
        eventparcel = eventparcel.zza(this, zzh1.zzaMg);
        zzh1 = zzh1.zzO(((zzg) (eventparcel)).zzZH);
          goto _L1
        eventparcel;
        zzAd().endTransaction();
        throw eventparcel;
    }

    void zzb(UserAttributeParcel userattributeparcel, AppMetadata appmetadata)
    {
        zzis();
        zziE();
        if (!TextUtils.isEmpty(appmetadata.zzaLP)) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj;
        zzzq().zzef(userattributeparcel.name);
        obj = zzzq().zzD(userattributeparcel.getValue());
        if (obj == null) goto _L1; else goto _L3
_L3:
        userattributeparcel = new zzae(appmetadata.packageName, userattributeparcel.name, userattributeparcel.zzaOz, obj);
        zzyd().zzzP().zze("Setting user attribute", ((zzae) (userattributeparcel)).mName, obj);
        zzAd().beginTransaction();
        zzc(appmetadata);
        zzAd().zza(userattributeparcel);
        zzAd().setTransactionSuccessful();
        zzyd().zzzP().zze("User attribute set", ((zzae) (userattributeparcel)).mName, ((zzae) (userattributeparcel)).zzJy);
        zzAd().endTransaction();
        return;
        userattributeparcel;
        zzAd().endTransaction();
        throw userattributeparcel;
    }

    void zzb(zzy zzy1)
    {
        zzaOc = zzaOc + 1;
    }

    void zzc(UserAttributeParcel userattributeparcel, AppMetadata appmetadata)
    {
        zzis();
        zziE();
        if (TextUtils.isEmpty(appmetadata.zzaLP))
        {
            return;
        }
        zzyd().zzzP().zzj("Removing user attribute", userattributeparcel.name);
        zzAd().beginTransaction();
        zzc(appmetadata);
        zzAd().zzI(appmetadata.packageName, userattributeparcel.name);
        zzAd().setTransactionSuccessful();
        zzyd().zzzP().zzj("User attribute removed", userattributeparcel.name);
        zzAd().endTransaction();
        return;
        userattributeparcel;
        zzAd().endTransaction();
        throw userattributeparcel;
    }

    void zziE()
    {
        if (!zzMF)
        {
            throw new IllegalStateException("AppMeasurement is not initialized");
        } else
        {
            return;
        }
    }

    void zzir()
    {
        if (zzzt().zzjA())
        {
            throw new IllegalStateException("Unexpected call on package side");
        } else
        {
            return;
        }
    }

    public void zzis()
    {
        zzzr().zzis();
    }

    public zzmn zzit()
    {
        return zzpW;
    }

    public zzp zzyd()
    {
        zza(zzaNO);
        return zzaNO;
    }

    public zzn zzzo()
    {
        zza(zzaNX);
        return zzaNX;
    }

    public zzab zzzp()
    {
        zza(zzaNU);
        return zzaNU;
    }

    public zzag zzzq()
    {
        zza(zzaNR);
        return zzaNR;
    }

    public zzu zzzr()
    {
        zza(zzaNP);
        return zzaNP;
    }

    public zzs zzzs()
    {
        zza(zzaNN);
        return zzaNN;
    }

    public zzc zzzt()
    {
        return zzaNM;
    }
}
