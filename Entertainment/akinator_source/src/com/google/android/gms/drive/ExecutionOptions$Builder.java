// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive;


// Referenced classes of package com.google.android.gms.drive:
//            ExecutionOptions

public static final class zzaiZ
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

    public zzaiZ setConflictStrategy(int i)
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

    public zzaiZ setNotifyOnCompletion(boolean flag)
    {
        zzaiY = flag;
        return this;
    }

    public zzaiY setTrackingTag(String s)
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

    public ()
    {
        zzaiZ = 0;
    }
}
