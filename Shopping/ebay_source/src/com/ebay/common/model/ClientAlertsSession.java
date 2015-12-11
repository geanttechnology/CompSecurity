// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model;


public class ClientAlertsSession
{

    private static final long ONE_DAY_MS = 0x5265c00L;
    public String data;
    public String id;
    public long timestamp;

    public ClientAlertsSession()
    {
        timestamp = 0L;
    }

    public boolean isValid()
    {
        return id != null && data != null && System.currentTimeMillis() - timestamp < 0x5265c00L;
    }

    public String toString()
    {
        return (new StringBuilder()).append("{data:").append(data).append(",id:").append(id).append(",timestamp:").append(timestamp).append("}").toString();
    }
}
