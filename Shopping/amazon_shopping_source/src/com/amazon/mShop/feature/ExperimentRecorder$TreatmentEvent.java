// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.feature;


// Referenced classes of package com.amazon.mShop.feature:
//            ExperimentRecorder

private static class <init>
{

    private final Integer cacheStamp;
    private final String featureName;
    private final String session;
    private final long time;
    private final String treatment;

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("session: ").append(session).append(", time: ").append(time).append(", featureName: ").append(featureName).append(", treatment: ").append(treatment).append(", cacheStamp: ").append(cacheStamp);
        return stringbuilder.toString();
    }






    private (String s, long l, String s1, String s2, Integer integer)
    {
        session = s;
        time = l;
        featureName = s1;
        treatment = s2;
        cacheStamp = integer;
    }

    cacheStamp(String s, long l, String s1, String s2, Integer integer, cacheStamp cachestamp)
    {
        this(s, l, s1, s2, integer);
    }
}
