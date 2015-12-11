// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.request;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.games.internal.constants.RequestUpdateResultOutcome;
import java.util.HashMap;
import java.util.Set;

public final class RequestUpdateOutcomes
{
    public static final class Builder
    {

        private int zzYm;
        private HashMap zzazS;

        public Builder zzgj(int i)
        {
            zzYm = i;
            return this;
        }

        public RequestUpdateOutcomes zzvF()
        {
            return new RequestUpdateOutcomes(zzYm, zzazS);
        }

        public Builder zzx(String s, int i)
        {
            if (RequestUpdateResultOutcome.isValid(i))
            {
                zzazS.put(s, Integer.valueOf(i));
            }
            return this;
        }

        public Builder()
        {
            zzazS = new HashMap();
            zzYm = 0;
        }
    }


    private static final String zzazR[] = {
        "requestId", "outcome"
    };
    private final int zzYm;
    private final HashMap zzazS;

    private RequestUpdateOutcomes(int i, HashMap hashmap)
    {
        zzYm = i;
        zzazS = hashmap;
    }


    public static RequestUpdateOutcomes zzaa(DataHolder dataholder)
    {
        Builder builder = new Builder();
        builder.zzgj(dataholder.getStatusCode());
        int j = dataholder.getCount();
        for (int i = 0; i < j; i++)
        {
            int k = dataholder.zzbt(i);
            builder.zzx(dataholder.zzd("requestId", i, k), dataholder.zzc("outcome", i, k));
        }

        return builder.zzvF();
    }

    public Set getRequestIds()
    {
        return zzazS.keySet();
    }

    public int getRequestOutcome(String s)
    {
        zzx.zzb(zzazS.containsKey(s), (new StringBuilder()).append("Request ").append(s).append(" was not part of the update operation!").toString());
        return ((Integer)zzazS.get(s)).intValue();
    }

}
