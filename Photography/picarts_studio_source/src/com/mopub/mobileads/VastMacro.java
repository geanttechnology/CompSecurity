// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;


final class VastMacro extends Enum
{

    private static final VastMacro $VALUES[];
    public static final VastMacro ASSETURI;
    public static final VastMacro CACHEBUSTING;
    public static final VastMacro CONTENTPLAYHEAD;
    public static final VastMacro ERRORCODE;

    private VastMacro(String s, int i)
    {
        super(s, i);
    }

    public static VastMacro valueOf(String s)
    {
        return (VastMacro)Enum.valueOf(com/mopub/mobileads/VastMacro, s);
    }

    public static VastMacro[] values()
    {
        return (VastMacro[])$VALUES.clone();
    }

    static 
    {
        ERRORCODE = new VastMacro("ERRORCODE", 0);
        CONTENTPLAYHEAD = new VastMacro("CONTENTPLAYHEAD", 1);
        CACHEBUSTING = new VastMacro("CACHEBUSTING", 2);
        ASSETURI = new VastMacro("ASSETURI", 3);
        $VALUES = (new VastMacro[] {
            ERRORCODE, CONTENTPLAYHEAD, CACHEBUSTING, ASSETURI
        });
    }
}
