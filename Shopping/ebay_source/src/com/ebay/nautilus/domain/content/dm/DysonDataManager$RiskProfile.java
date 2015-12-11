// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import com.ebay.nautilus.domain.datamapping.BaseDataMapped;
import org.json.JSONObject;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            DysonDataManager

private static final class <init> extends BaseDataMapped
{

    public String config;
    public long configTtl;
    public String pairingId;
    public long refreshTime;
    public JSONObject riskPayload;

    private long getConfigTtlRemaining()
    {
        return Math.max(0L, (configTtl - System.currentTimeMillis()) / 1000L);
    }

    private boolean isConfigStale()
    {
        return System.currentTimeMillis() >= configTtl;
    }

    private boolean needsRefresh()
    {
        return System.currentTimeMillis() >= refreshTime;
    }




    public ()
    {
    }

    private (String s, long l, String s1, JSONObject jsonobject, long l1)
    {
        config = s;
        pairingId = s1;
        riskPayload = jsonobject;
        long l2 = System.currentTimeMillis();
        configTtl = l * 1000L + l2;
        refreshTime = l1 * 1000L + l2;
    }

    refreshTime(String s, long l, String s1, JSONObject jsonobject, long l1, 
            refreshTime refreshtime)
    {
        this(s, l, s1, jsonobject, l1);
    }
}
