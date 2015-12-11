// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.drive.internal.zzu;

// Referenced classes of package com.google.android.gms.drive:
//            Drive

public final class ExecutionOptions
{
    public static final class Builder
    {

        private String zzaiX;
        private boolean zzaiY;
        private int zzaiZ;

        public ExecutionOptions build()
        {
            if (zzaiZ == 1 && !zzaiY)
            {
                throw new IllegalStateException("Cannot use CONFLICT_STRATEGY_KEEP_REMOTE without requesting completion notifications");
            } else
            {
                return new ExecutionOptions(zzaiX, zzaiY, zzaiZ);
            }
        }

        public Builder setConflictStrategy(int i)
        {
            if (!ExecutionOptions.zzcl(i))
            {
                throw new IllegalArgumentException((new StringBuilder()).append("Unrecognized value for conflict strategy: ").append(i).toString());
            } else
            {
                zzaiZ = i;
                return this;
            }
        }

        public Builder setNotifyOnCompletion(boolean flag)
        {
            zzaiY = flag;
            return this;
        }

        public Builder setTrackingTag(String s)
        {
            if (!ExecutionOptions.zzcC(s))
            {
                throw new IllegalArgumentException(String.format("trackingTag must not be null nor empty, and the length must be <= the maximum length (%s)", new Object[] {
                    Integer.valueOf(0x10000)
                }));
            } else
            {
                zzaiX = s;
                return this;
            }
        }

        public Builder()
        {
            zzaiZ = 0;
        }
    }


    public static final int CONFLICT_STRATEGY_KEEP_REMOTE = 1;
    public static final int CONFLICT_STRATEGY_OVERWRITE_REMOTE = 0;
    public static final int MAX_TRACKING_TAG_STRING_LENGTH = 0x10000;
    private final String zzaiX;
    private final boolean zzaiY;
    private final int zzaiZ;

    public ExecutionOptions(String s, boolean flag, int i)
    {
        zzaiX = s;
        zzaiY = flag;
        zzaiZ = i;
    }

    public static void zza(GoogleApiClient googleapiclient, ExecutionOptions executionoptions)
    {
        googleapiclient = (zzu)googleapiclient.zza(Drive.zzRk);
        if (executionoptions.zzqT() && !googleapiclient.zzrq())
        {
            throw new IllegalStateException("Application must define an exported DriveEventService subclass in AndroidManifest.xml to be notified on completion");
        } else
        {
            return;
        }
    }

    public static boolean zzcC(String s)
    {
        return s != null && !s.isEmpty() && s.length() <= 0x10000;
    }

    public static boolean zzck(int i)
    {
        switch (i)
        {
        default:
            return false;

        case 1: // '\001'
            return true;
        }
    }

    public static boolean zzcl(int i)
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
        if (!zzw.equal(zzaiX, ((ExecutionOptions) (obj)).zzaiX) || zzaiZ != ((ExecutionOptions) (obj)).zzaiZ)
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (zzaiY == ((ExecutionOptions) (obj)).zzaiY) goto _L4; else goto _L5
_L5:
        return false;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            zzaiX, Integer.valueOf(zzaiZ), Boolean.valueOf(zzaiY)
        });
    }

    public String zzqS()
    {
        return zzaiX;
    }

    public boolean zzqT()
    {
        return zzaiY;
    }

    public int zzqU()
    {
        return zzaiZ;
    }
}
