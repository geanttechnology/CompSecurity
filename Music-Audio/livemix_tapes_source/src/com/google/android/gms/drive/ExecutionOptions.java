// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.drive.internal.zzt;

// Referenced classes of package com.google.android.gms.drive:
//            Drive

public final class ExecutionOptions
{
    public static final class Builder
    {

        private String zzagM;
        private boolean zzagN;
        private int zzagO;

        public ExecutionOptions build()
        {
            if (zzagO == 1 && !zzagN)
            {
                throw new IllegalStateException("Cannot use CONFLICT_STRATEGY_KEEP_REMOTE without requesting completion notifications");
            } else
            {
                return new ExecutionOptions(zzagM, zzagN, zzagO);
            }
        }

        public Builder setConflictStrategy(int i)
        {
            if (!ExecutionOptions.zzcg(i))
            {
                throw new IllegalArgumentException((new StringBuilder()).append("Unrecognized value for conflict strategy: ").append(i).toString());
            } else
            {
                zzagO = i;
                return this;
            }
        }

        public Builder setNotifyOnCompletion(boolean flag)
        {
            zzagN = flag;
            return this;
        }

        public Builder setTrackingTag(String s)
        {
            if (!ExecutionOptions.zzcD(s))
            {
                throw new IllegalArgumentException(String.format("trackingTag must not be null nor empty, and the length must be <= the maximum length (%s)", new Object[] {
                    Integer.valueOf(0x10000)
                }));
            } else
            {
                zzagM = s;
                return this;
            }
        }

        public Builder()
        {
            zzagO = 0;
        }
    }


    public static final int CONFLICT_STRATEGY_KEEP_REMOTE = 1;
    public static final int CONFLICT_STRATEGY_OVERWRITE_REMOTE = 0;
    public static final int MAX_TRACKING_TAG_STRING_LENGTH = 0x10000;
    private final String zzagM;
    private final boolean zzagN;
    private final int zzagO;

    public ExecutionOptions(String s, boolean flag, int i)
    {
        zzagM = s;
        zzagN = flag;
        zzagO = i;
    }

    public static void zza(GoogleApiClient googleapiclient, ExecutionOptions executionoptions)
    {
        googleapiclient = (zzt)googleapiclient.zza(Drive.zzQf);
        if (executionoptions.zzqm() && !googleapiclient.zzqI())
        {
            throw new IllegalStateException("Application must define an exported DriveEventService subclass in AndroidManifest.xml to be notified on completion");
        } else
        {
            return;
        }
    }

    public static boolean zzcD(String s)
    {
        return s != null && !s.isEmpty() && s.length() <= 0x10000;
    }

    public static boolean zzcf(int i)
    {
        switch (i)
        {
        default:
            return false;

        case 1: // '\001'
            return true;
        }
    }

    public static boolean zzcg(int i)
    {
        switch (i)
        {
        default:
            return false;

        case 0: // '\0'
        case 1: // '\001'
            return true;
        }
    }

    public boolean equals(Object obj)
    {
        boolean flag1 = true;
        if (obj != null && obj.getClass() == getClass()) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        flag = flag1;
        if (obj == this) goto _L4; else goto _L3
_L3:
        obj = (ExecutionOptions)obj;
        if (!zzw.equal(zzagM, ((ExecutionOptions) (obj)).zzagM) || zzagO != ((ExecutionOptions) (obj)).zzagO)
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (zzagN == ((ExecutionOptions) (obj)).zzagN) goto _L4; else goto _L5
_L5:
        return false;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            zzagM, Integer.valueOf(zzagO), Boolean.valueOf(zzagN)
        });
    }

    public String zzql()
    {
        return zzagM;
    }

    public boolean zzqm()
    {
        return zzagN;
    }

    public int zzqn()
    {
        return zzagO;
    }
}
