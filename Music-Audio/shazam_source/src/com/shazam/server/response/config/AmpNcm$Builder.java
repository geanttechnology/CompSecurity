// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.response.config;


// Referenced classes of package com.shazam.server.response.config:
//            AmpNcm, AmpNcmPresence

public static class 
{

    private AmpNcmPresence presence;

    public static  ampNcm()
    {
        return new <init>();
    }

    public AmpNcm build()
    {
        return new AmpNcm(this, null);
    }

    public <init> withPresence(AmpNcmPresence ampncmpresence)
    {
        presence = ampncmpresence;
        return this;
    }


    public ()
    {
    }
}
