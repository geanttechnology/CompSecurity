// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;

import com.applovin.impl.adview.v;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;

// Referenced classes of package com.applovin.impl.sdk:
//            AppLovinAdImpl

public class 
{

    private String a;
    private AppLovinAdSize b;
    private AppLovinAdType c;
    private String d;
    private  e;
    private v f;
    private float g;
    private float h;
    private int i;
    private long j;
    private String k;
    private String l;

    public AppLovinAdImpl build()
    {
        return new AppLovinAdImpl(a, b, c, d, e, f, g, h, i, j, k, l, null);
    }

    public  setClCode(String s)
    {
        k = s;
        return this;
    }

    public k setCloseStyle(v v)
    {
        f = v;
        return this;
    }

    public f setCompletionUrl(String s)
    {
        l = s;
        return this;
    }

    public l setCountdownLength(int i1)
    {
        i = i1;
        return this;
    }

    public i setCurrentAdIdNumber(long l1)
    {
        j = l1;
        return this;
    }

    public j setHtml(String s)
    {
        a = s;
        return this;
    }

    public a setPoststitialCloseDelay(float f1)
    {
        h = f1;
        return this;
    }

    public h setSize(AppLovinAdSize applovinadsize)
    {
        b = applovinadsize;
        return this;
    }

    public  setTarget( )
    {
        e = ;
        return this;
    }

    public e setType(AppLovinAdType applovinadtype)
    {
        c = applovinadtype;
        return this;
    }

    public c setVideoCloseDelay(float f1)
    {
        g = f1;
        return this;
    }

    public g setVideoFilename(String s)
    {
        d = s;
        return this;
    }

    public ()
    {
    }
}
