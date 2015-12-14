// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mixtape.account;


// Referenced classes of package com.amazon.mixtape.account:
//            MetadataStore

public static class metadataVersion
{

    private final int metadataVersion;
    private final String state;

    public int getMetadataVersion()
    {
        return metadataVersion;
    }

    public String getState()
    {
        return state;
    }

    public (String s, int i)
    {
        state = s;
        metadataVersion = i;
    }
}
