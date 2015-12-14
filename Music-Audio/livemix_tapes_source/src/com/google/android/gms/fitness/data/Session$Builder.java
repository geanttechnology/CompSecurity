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

public static class zzanx
{

    private String mName;
    private long zzMS;
    private Application zzanK;
    private long zzann;
    private int zzanx;
    private String zzaoA;
    private String zzaoB;
    private Long zzaoC;

    static long zza(zzanx zzanx1)
    {
        return zzanx1.zzMS;
    }

    static long zzb(zzMS zzms)
    {
        return zzms.zzann;
    }

    static String zzc(zzann zzann1)
    {
        return zzann1.mName;
    }

    static String zzd(mName mname)
    {
        return mname.zzaoA;
    }

    static String zze(zzaoA zzaoa)
    {
        return zzaoa.zzaoB;
    }

    static int zzf(zzaoB zzaob)
    {
        return zzaob.zzanx;
    }

    static Application zzg(zzanx zzanx1)
    {
        return zzanx1.zzanK;
    }

    static Long zzh(zzanK zzank)
    {
        return zzank.zzaoC;
    }

    public Session build()
    {
label0:
        {
            boolean flag1 = false;
            StringBuilder stringbuilder;
            boolean flag;
            if (zzMS > 0L)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzx.zza(flag, "Start time should be specified.");
            if (zzann != 0L)
            {
                flag = flag1;
                if (zzann <= zzMS)
                {
                    break label0;
                }
            }
            flag = true;
        }
        zzx.zza(flag, "End time should be later than start time.");
        if (zzaoA == null)
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
            zzaoA = stringbuilder.append(s).append(zzMS).toString();
        }
        return new Session(this, null);
    }

    public zzMS setActiveTime(long l, TimeUnit timeunit)
    {
        zzaoC = Long.valueOf(timeunit.toMillis(l));
        return this;
    }

    public zzaoC setActivity(String s)
    {
        return zzey(FitnessActivities.zzcP(s));
    }

    public P setDescription(String s)
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
        zzaoB = s;
        return this;
    }

    public zzaoB setEndTime(long l, TimeUnit timeunit)
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
        zzann = timeunit.toMillis(l);
        return this;
    }

    public zzann setIdentifier(String s)
    {
        boolean flag;
        if (s != null && TextUtils.getTrimmedLength(s) > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzZ(flag);
        zzaoA = s;
        return this;
    }

    public zzaoA setName(String s)
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
        zzMS = timeunit.toMillis(l);
        return this;
    }

    public zzMS zzey(int i)
    {
        zzanx = i;
        return this;
    }

    public _cls9()
    {
        zzMS = 0L;
        zzann = 0L;
        mName = null;
        zzanx = 4;
    }
}
