// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzae;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.android.gms.tagmanager:
//            zzak, zzdf, DataLayer

class zzdb extends zzak
{

    private static final String ID;
    private static final String NAME;
    private static final String zzaZu;
    private static final String zzaZv;
    private static final String zzaZw;
    private final Context mContext;
    private Handler mHandler;
    private DataLayer zzaVR;
    private final Set zzaZA = new HashSet();
    private boolean zzaZx;
    private boolean zzaZy;
    private final HandlerThread zzaZz = new HandlerThread("Google GTM SDK Timer", 10);

    public zzdb(Context context, DataLayer datalayer)
    {
        super(ID, new String[] {
            zzaZu, NAME
        });
        mContext = context;
        zzaVR = datalayer;
        zzaZz.start();
        mHandler = new Handler(zzaZz.getLooper());
    }

    static Set zza(zzdb zzdb1)
    {
        return zzdb1.zzaZA;
    }

    static DataLayer zzb(zzdb zzdb1)
    {
        return zzdb1.zzaVR;
    }

    static Handler zzc(zzdb zzdb1)
    {
        return zzdb1.mHandler;
    }

    static boolean zzd(zzdb zzdb1)
    {
        return zzdb1.zzaZy;
    }

    static boolean zze(zzdb zzdb1)
    {
        return zzdb1.zzaZx;
    }

    static Context zzf(zzdb zzdb1)
    {
        return zzdb1.mContext;
    }

    public boolean zzCo()
    {
        return false;
    }

    public com.google.android.gms.internal.zzag.zza zzI(Map map)
    {
label0:
        {
label1:
            {
                String s1 = zzdf.zzg((com.google.android.gms.internal.zzag.zza)map.get(NAME));
                String s = zzdf.zzg((com.google.android.gms.internal.zzag.zza)map.get(zzaZw));
                String s2 = zzdf.zzg((com.google.android.gms.internal.zzag.zza)map.get(zzaZu));
                map = zzdf.zzg((com.google.android.gms.internal.zzag.zza)map.get(zzaZv));
                long l;
                long l1;
                try
                {
                    l = Long.parseLong(s2);
                }
                catch (NumberFormatException numberformatexception)
                {
                    l = 0L;
                }
                try
                {
                    l1 = Long.parseLong(map);
                }
                // Misplaced declaration of an exception variable
                catch (Map map)
                {
                    l1 = 0L;
                }
                if (l <= 0L || TextUtils.isEmpty(s1))
                {
                    break label0;
                }
                if (s != null)
                {
                    map = s;
                    if (!s.isEmpty())
                    {
                        break label1;
                    }
                }
                map = "0";
            }
            if (!zzaZA.contains(map))
            {
                if (!"0".equals(map))
                {
                    zzaZA.add(map);
                }
                mHandler.postDelayed(new zza(s1, map, l, l1), l);
            }
        }
        return zzdf.zzDX();
    }

    static 
    {
        ID = zzad.zzcQ.toString();
        NAME = zzae.zzfR.toString();
        zzaZu = zzae.zzfw.toString();
        zzaZv = zzae.zzfE.toString();
        zzaZw = zzae.zzhv.toString();
    }

    private class zza
        implements Runnable
    {

        private final long zzaEE;
        private final String zzaZB;
        private final String zzaZC;
        private final long zzaZD;
        private long zzaZE;
        final zzdb zzaZF;
        private final long zzzB = System.currentTimeMillis();

        public final void run()
        {
            if (zzaZD > 0L && zzaZE >= zzaZD)
            {
                if (!"0".equals(zzaZC))
                {
                    zzdb.zza(zzaZF).remove(zzaZC);
                }
                return;
            }
            zzaZE = zzaZE + 1L;
            if (zzcu())
            {
                long l = System.currentTimeMillis();
                zzdb.zzb(zzaZF).push(DataLayer.mapOf(new Object[] {
                    "event", zzaZB, "gtm.timerInterval", String.valueOf(zzaEE), "gtm.timerLimit", String.valueOf(zzaZD), "gtm.timerStartTime", String.valueOf(zzzB), "gtm.timerCurrentTime", String.valueOf(l), 
                    "gtm.timerElapsedTime", String.valueOf(l - zzzB), "gtm.timerEventNumber", String.valueOf(zzaZE), "gtm.triggers", zzaZC
                }));
            }
            zzdb.zzc(zzaZF).postDelayed(this, zzaEE);
        }

        protected final boolean zzcu()
        {
            if (zzdb.zzd(zzaZF))
            {
                return zzdb.zze(zzaZF);
            }
            Object obj = (ActivityManager)zzdb.zzf(zzaZF).getSystemService("activity");
            KeyguardManager keyguardmanager = (KeyguardManager)zzdb.zzf(zzaZF).getSystemService("keyguard");
            PowerManager powermanager = (PowerManager)zzdb.zzf(zzaZF).getSystemService("power");
            for (obj = ((ActivityManager) (obj)).getRunningAppProcesses().iterator(); ((Iterator) (obj)).hasNext();)
            {
                android.app.ActivityManager.RunningAppProcessInfo runningappprocessinfo = (android.app.ActivityManager.RunningAppProcessInfo)((Iterator) (obj)).next();
                if (Process.myPid() == runningappprocessinfo.pid && runningappprocessinfo.importance == 100 && !keyguardmanager.inKeyguardRestrictedInputMode() && powermanager.isScreenOn())
                {
                    return true;
                }
            }

            return false;
        }

        zza(String s, String s1, long l, long l1)
        {
            zzaZF = zzdb.this;
            super();
            zzaZB = s;
            zzaZC = s1;
            zzaEE = l;
            zzaZD = l1;
        }
    }

}
