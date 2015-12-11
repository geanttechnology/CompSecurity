// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.search;

import android.graphics.Color;
import android.location.Location;
import com.google.android.gms.ads.mediation.NetworkExtras;

// Referenced classes of package com.google.android.gms.ads.search:
//            SearchAdRequest

public static final class jp
{

    private final com.google.android.gms.internal.r.dX dX = new com.google.android.gms.internal.r.dX();
    private int jj;
    private int jk;
    private int jl;
    private int jm;
    private int jn;
    private int jo;
    private int jp;
    private int jq;
    private String jr;
    private int js;
    private String jt;
    private int ju;
    private int jv;
    private String jw;

    static int a(jp jp1)
    {
        return jp1.jj;
    }

    static int b(jj jj1)
    {
        return jj1.jk;
    }

    static int c(jk jk1)
    {
        return jk1.jl;
    }

    static int d(jl jl1)
    {
        return jl1.jm;
    }

    static int e(jm jm1)
    {
        return jm1.jn;
    }

    static int f(jn jn1)
    {
        return jn1.jo;
    }

    static int g(jo jo1)
    {
        return jo1.jp;
    }

    static int h(jp jp1)
    {
        return jp1.jq;
    }

    static String i(jq jq1)
    {
        return jq1.jr;
    }

    static int j(jr jr1)
    {
        return jr1.js;
    }

    static String k(js js1)
    {
        return js1.jt;
    }

    static int l(jt jt1)
    {
        return jt1.ju;
    }

    static int m(ju ju1)
    {
        return ju1.jv;
    }

    static String n(jv jv1)
    {
        return jv1.jw;
    }

    static com.google.android.gms.internal.r o(jw jw1)
    {
        return jw1.dX;
    }

    public dX addNetworkExtras(NetworkExtras networkextras)
    {
        dX.dX(networkextras);
        return this;
    }

    public dX addTestDevice(String s)
    {
        dX.dX(s);
        return this;
    }

    public SearchAdRequest build()
    {
        return new SearchAdRequest(this, null);
    }

    public dX setAnchorTextColor(int i1)
    {
        jj = i1;
        return this;
    }

    public jj setBackgroundColor(int i1)
    {
        jk = i1;
        jl = Color.argb(0, 0, 0, 0);
        jm = Color.argb(0, 0, 0, 0);
        return this;
    }

    public jm setBackgroundGradient(int i1, int j1)
    {
        jk = Color.argb(0, 0, 0, 0);
        jl = j1;
        jm = i1;
        return this;
    }

    public jm setBorderColor(int i1)
    {
        jn = i1;
        return this;
    }

    public jn setBorderThickness(int i1)
    {
        jo = i1;
        return this;
    }

    public jo setBorderType(int i1)
    {
        jp = i1;
        return this;
    }

    public jp setCallButtonColor(int i1)
    {
        jq = i1;
        return this;
    }

    public jq setCustomChannels(String s)
    {
        jr = s;
        return this;
    }

    public jr setDescriptionTextColor(int i1)
    {
        js = i1;
        return this;
    }

    public js setFontFace(String s)
    {
        jt = s;
        return this;
    }

    public jt setHeaderTextColor(int i1)
    {
        ju = i1;
        return this;
    }

    public ju setHeaderTextSize(int i1)
    {
        jv = i1;
        return this;
    }

    public jv setLocation(Location location)
    {
        dX.dX(location);
        return this;
    }

    public dX setQuery(String s)
    {
        jw = s;
        return this;
    }

    public jw tagForChildDirectedTreatment(boolean flag)
    {
        dX.dX(flag);
        return this;
    }

    public ()
    {
        jp = 0;
    }
}
