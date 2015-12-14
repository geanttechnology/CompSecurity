// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive;


// Referenced classes of package com.google.android.gms.drive:
//            ExecutionOptions

public static final class zzagO
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

    public zzagO setConflictStrategy(int i)
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

    public zzagO setNotifyOnCompletion(boolean flag)
    {
        zzagN = flag;
        return this;
    }

    public zzagN setTrackingTag(String s)
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

    public ()
    {
        zzagO = 0;
    }
}
