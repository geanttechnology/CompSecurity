// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.lyrics;

import java.util.List;

// Referenced classes of package com.shazam.model.lyrics:
//            LyricPlay, SynchInfo

public static class 
{

    public List payload;
    public String provider;
    public SynchInfo synchInfo;
    public long tagTime;

    public static  a()
    {
        return new <init>();
    }

    static String a(<init> <init>1)
    {
        return <init>1.provider;
    }

    static SynchInfo b(provider provider1)
    {
        return provider1.synchInfo;
    }

    static List c(synchInfo synchinfo)
    {
        return synchinfo.payload;
    }

    static long d(payload payload1)
    {
        return payload1.tagTime;
    }

    public ()
    {
    }
}
