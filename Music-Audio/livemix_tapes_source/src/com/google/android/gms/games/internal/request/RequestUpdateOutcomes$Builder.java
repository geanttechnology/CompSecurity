// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.request;

import com.google.android.gms.games.internal.constants.RequestUpdateResultOutcome;
import java.util.HashMap;

// Referenced classes of package com.google.android.gms.games.internal.request:
//            RequestUpdateOutcomes

public static final class zzWu
{

    private int zzWu;
    private HashMap zzaxs;

    public zzWu zzga(int i)
    {
        zzWu = i;
        return this;
    }

    public RequestUpdateOutcomes zzuP()
    {
        return new RequestUpdateOutcomes(zzWu, zzaxs, null);
    }

    public zzaxs zzy(String s, int i)
    {
        if (RequestUpdateResultOutcome.isValid(i))
        {
            zzaxs.put(s, Integer.valueOf(i));
        }
        return this;
    }

    public Q()
    {
        zzaxs = new HashMap();
        zzWu = 0;
    }
}
