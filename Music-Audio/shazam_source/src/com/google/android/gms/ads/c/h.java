// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.c;

import java.util.List;

// Referenced classes of package com.google.android.gms.ads.c:
//            g

public abstract class h extends g
{

    private com.google.android.gms.ads.b.a.a zzJE;
    private String zzvK;
    private List zzvL;
    private String zzvM;
    private String zzvO;
    private double zzvP;
    private String zzvQ;
    private String zzvR;

    public h()
    {
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

    public final com.google.android.gms.ads.b.a.a getIcon()
    {
        return zzJE;
    }

    public final List getImages()
    {
        return zzvL;
    }

    public final String getPrice()
    {
        return zzvR;
    }

    public final double getStarRating()
    {
        return zzvP;
    }

    public final String getStore()
    {
        return zzvQ;
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

    public final void setIcon(com.google.android.gms.ads.b.a.a a)
    {
        zzJE = a;
    }

    public final void setImages(List list)
    {
        zzvL = list;
    }

    public final void setPrice(String s)
    {
        zzvR = s;
    }

    public final void setStarRating(double d)
    {
        zzvP = d;
    }

    public final void setStore(String s)
    {
        zzvQ = s;
    }
}
