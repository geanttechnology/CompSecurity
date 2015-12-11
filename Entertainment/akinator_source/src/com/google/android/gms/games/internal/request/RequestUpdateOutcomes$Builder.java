// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.request;

import com.google.android.gms.games.internal.constants.RequestUpdateResultOutcome;
import java.util.HashMap;

// Referenced classes of package com.google.android.gms.games.internal.request:
//            RequestUpdateOutcomes

public static final class zzYm
{

    private int zzYm;
    private HashMap zzazS;

    public zzYm zzgj(int i)
    {
        zzYm = i;
        return this;
    }

    public RequestUpdateOutcomes zzvF()
    {
        return new RequestUpdateOutcomes(zzYm, zzazS, null);
    }

    public zzazS zzx(String s, int i)
    {
        if (RequestUpdateResultOutcome.isValid(i))
        {
            zzazS.put(s, Integer.valueOf(i));
        }
        return this;
    }

    public Q()
    {
        zzazS = new HashMap();
        zzYm = 0;
    }
}
