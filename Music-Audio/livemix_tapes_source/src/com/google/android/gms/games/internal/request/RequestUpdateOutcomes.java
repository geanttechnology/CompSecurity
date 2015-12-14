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

        private int zzWu;
        private HashMap zzaxs;

        public Builder zzga(int i)
        {
            zzWu = i;
            return this;
        }

        public RequestUpdateOutcomes zzuP()
        {
            return new RequestUpdateOutcomes(zzWu, zzaxs);
        }

        public Builder zzy(String s, int i)
        {
            if (RequestUpdateResultOutcome.isValid(i))
            {
                zzaxs.put(s, Integer.valueOf(i));
            }
            return this;
        }

        public Builder()
        {
            zzaxs = new HashMap();
            zzWu = 0;
        }
    }


    private static final String zzaxr[] = {
        "requestId", "outcome"
    };
    private final int zzWu;
    private final HashMap zzaxs;

    private RequestUpdateOutcomes(int i, HashMap hashmap)
    {
        zzWu = i;
        zzaxs = hashmap;
    }


    public static RequestUpdateOutcomes zzY(DataHolder dataholder)
    {
        Builder builder = new Builder();
        builder.zzga(dataholder.getStatusCode());
        int j = dataholder.getCount();
        for (int i = 0; i < j; i++)
        {
            int k = dataholder.zzbo(i);
            builder.zzy(dataholder.zzd("requestId", i, k), dataholder.zzc("outcome", i, k));
        }

        return builder.zzuP();
    }

    public Set getRequestIds()
    {
        return zzaxs.keySet();
    }

    public int getRequestOutcome(String s)
    {
        zzx.zzb(zzaxs.containsKey(s), (new StringBuilder()).append("Request ").append(s).append(" was not part of the update operation!").toString());
        return ((Integer)zzaxs.get(s)).intValue();
    }

}
