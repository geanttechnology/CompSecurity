// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.data;

import android.text.TextUtils;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.FitnessActivities;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.google.android.gms.fitness.data:
//            Session, Application

public static class zzapX
{

    private String mName;
    private long zzNY;
    private long zzapN;
    private int zzapX;
    private String zzaqY;
    private String zzaqZ;
    private Application zzaqk;
    private Long zzara;

    static long zza(zzapX zzapx)
    {
        return zzapx.zzNY;
    }

    static long zzb(zzNY zzny)
    {
        return zzny.zzapN;
    }

    static String zzc(zzapN zzapn)
    {
        return zzapn.mName;
    }

    static String zzd(mName mname)
    {
        return mname.zzaqY;
    }

    static String zze(zzaqY zzaqy)
    {
        return zzaqy.zzaqZ;
    }

    static int zzf(zzaqZ zzaqz)
    {
        return zzaqz.zzapX;
    }

    static Application zzg(zzapX zzapx)
    {
        return zzapx.zzaqk;
    }

    static Long zzh(zzaqk zzaqk1)
    {
        return zzaqk1.zzara;
    }

    public Session build()
    {
label0:
        {
            boolean flag1 = false;
            StringBuilder stringbuilder;
            boolean flag;
            if (zzNY > 0L)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzx.zza(flag, "Start time should be specified.");
            if (zzapN != 0L)
            {
                flag = flag1;
                if (zzapN <= zzNY)
                {
                    break label0;
                }
            }
            flag = true;
        }
        zzx.zza(flag, "End time should be later than start time.");
        if (zzaqY == null)
        {
            stringbuilder = new StringBuilder();
            String s;
            if (mName == null)
            {
                s = "";
            } else
            {
                s = mName;
            }
            zzaqY = stringbuilder.append(s).append(zzNY).toString();
        }
        return new Session(this, null);
    }

    public zzNY setActiveTime(long l, TimeUnit timeunit)
    {
        zzara = Long.valueOf(timeunit.toMillis(l));
        return this;
    }

    public zzara setActivity(String s)
    {
        return zzeH(FitnessActivities.zzcO(s));
    }

    public O setDescription(String s)
    {
        boolean flag;
        if (s.length() <= 1000)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, "Session description cannot exceed %d characters", new Object[] {
            Integer.valueOf(1000)
        });
        zzaqZ = s;
        return this;
    }

    public zzaqZ setEndTime(long l, TimeUnit timeunit)
    {
        boolean flag;
        if (l >= 0L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zza(flag, "End time should be positive.");
        zzapN = timeunit.toMillis(l);
        return this;
    }

    public zzapN setIdentifier(String s)
    {
        boolean flag;
        if (s != null && TextUtils.getTrimmedLength(s) > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzaa(flag);
        zzaqY = s;
        return this;
    }

    public zzaqY setName(String s)
    {
        boolean flag;
        if (s.length() <= 100)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, "Session name cannot exceed %d characters", new Object[] {
            Integer.valueOf(100)
        });
        mName = s;
        return this;
    }

    public mName setStartTime(long l, TimeUnit timeunit)
    {
        boolean flag;
        if (l > 0L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zza(flag, "Start time should be positive.");
        zzNY = timeunit.toMillis(l);
        return this;
    }

    public zzNY zzeH(int i)
    {
        zzapX = i;
        return this;
    }

    public _cls9()
    {
        zzNY = 0L;
        zzapN = 0L;
        mName = null;
        zzapX = 4;
    }
}
