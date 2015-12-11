// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android.impl.ads.protocol.v13;


// Referenced classes of package com.flurry.android.impl.ads.protocol.v13:
//            FrequencyCapType

public class FrequencyCapResponseInfo
{

    public int capDurationType;
    public int capRemaining;
    public FrequencyCapType capType;
    public long expirationTime;
    public String id;
    public long serveTime;
    public long streamCapDurationMillis;
    public int totalCap;

    public FrequencyCapResponseInfo()
    {
    }
}
