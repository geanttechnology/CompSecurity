// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import com.jumio.netverify.sdk.enums.NVScanSide;

// Referenced classes of package jumiomobile:
//            w, hu

class ob
{

    static final int a[];
    static final int b[];
    static final int c[];

    static 
    {
        c = new int[w.values().length];
        try
        {
            c[w.a.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror19) { }
        try
        {
            c[w.c.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror18) { }
        try
        {
            c[w.b.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror17) { }
        try
        {
            c[w.d.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror16) { }
        b = new int[NVScanSide.values().length];
        try
        {
            b[NVScanSide.FRONT.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror15) { }
        try
        {
            b[NVScanSide.BACK.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror14) { }
        try
        {
            b[NVScanSide.FACE.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror13) { }
        a = new int[hu.values().length];
        try
        {
            a[hu.g.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror12) { }
        try
        {
            a[hu.j.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror11) { }
        try
        {
            a[hu.t.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror10) { }
        try
        {
            a[hu.u.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror9) { }
        try
        {
            a[hu.f.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror8) { }
        try
        {
            a[hu.i.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            a[hu.m.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            a[hu.p.ordinal()] = 8;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            a[hu.o.ordinal()] = 9;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            a[hu.q.ordinal()] = 10;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            a[hu.s.ordinal()] = 11;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            a[hu.r.ordinal()] = 12;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            a[hu.v.ordinal()] = 13;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
