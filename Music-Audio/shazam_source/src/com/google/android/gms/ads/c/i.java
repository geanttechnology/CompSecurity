// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.c;

import java.util.List;

// Referenced classes of package com.google.android.gms.ads.c:
//            g

public abstract class i extends g
{

    private com.google.android.gms.ads.b.a.a zzJF;
    private String zzvK;
    private List zzvL;
    private String zzvM;
    private String zzvO;
    private String zzvV;

    public i()
    {
    }

    public final String getAdvertiser()
    {
        return zzvV;
    }

    public final String getBody()
    {
        return zzvM;
    }

    public final String getCallToAction()
    {
        return zzvO;
    }

    public final String getHeadline()
    {
        return zzvK;
    }

    public final List getImages()
    {
        return zzvL;
    }

    public final com.google.android.gms.ads.b.a.a getLogo()
    {
        return zzJF;
    }

    public final void setAdvertiser(String s)
    {
        zzvV = s;
    }

    public final void setBody(String s)
    {
        zzvM = s;
    }

    public final void setCallToAction(String s)
    {
        zzvO = s;
    }

    public final void setHeadline(String s)
    {
        zzvK = s;
    }

    public final void setImages(List list)
    {
        zzvL = list;
    }

    public final void setLogo(com.google.android.gms.ads.b.a.a a)
    {
        zzJF = a;
    }
}
