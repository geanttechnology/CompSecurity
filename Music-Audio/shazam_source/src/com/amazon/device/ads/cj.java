// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.app.Activity;
import java.util.HashMap;

// Referenced classes of package com.amazon.device.ads:
//            de, co, f, h, 
//            do, ci, bi, cv, 
//            dd, cn, ae

class cj
    implements de
{

    private static final String a = com/amazon/device/ads/cj.getSimpleName();
    private ci b;
    private final cn c;

    cj(ci ci1)
    {
        new co();
        c = co.a(a);
        b = ci1;
    }

    private void a(f f1)
    {
        Object obj = (Activity)f1.b();
        f1.a.q = ((Activity) (obj)).getRequestedOrientation();
        obj = f1.a.v();
        ci ci1 = b;
        int i = ((do) (obj)).a;
        int j = ((do) (obj)).b;
        ci1.d.a = i;
        ci1.d.b = j;
        obj = f1.a.t();
        ci1 = b;
        i = ((cv) (obj)).a.a;
        j = ((cv) (obj)).a.b;
        int k = ((cv) (obj)).b;
        int l = ((cv) (obj)).c;
        ci1.f.a = new do(i, j);
        ci1.f.b = k;
        ci1.f.c = l;
        b.g();
        f1.a("mraidBridge.stateChange('default');");
        f1.a("mraidBridge.viewableChange('true');");
    }

    public final void a(dd dd1, f f1)
    {
        c.b(dd1.a.toString(), null);
        static final class _cls1
        {

            static final int a[];
            static final int b[];

            static 
            {
                b = new int[ae.values().length];
                try
                {
                    b[ae.h.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    b[ae.g.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    b[ae.e.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                a = new int[dd.a.values().length];
                try
                {
                    a[dd.a.a.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    a[dd.a.b.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    a[dd.a.e.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    a[dd.a.g.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[dd.a.c.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[dd.a.d.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[dd.a.h.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1.a[dd1.a.ordinal()];
        JVM INSTR tableswitch 1 7: default 68
    //                   1 69
    //                   2 76
    //                   3 82
    //                   4 253
    //                   5 261
    //                   6 261
    //                   7 274;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L6 _L7
_L1:
        return;
_L2:
        f1.a("mraidBridge.ready();");
        return;
_L3:
        a(f1);
        return;
_L4:
        if (!f1.a.x.equals(ae.h))
        {
            continue; /* Loop/switch isn't completed */
        }
        dd1 = b;
        ((ci) (dd1)).a.b((new StringBuilder("Collapsing expanded ad ")).append(dd1).toString(), null);
        ((ci) (dd1)).i.a(new ci._cls10(dd1, f1), ds.b.a, ds.c.a);
        if (((Activity)f1.b()).getRequestedOrientation() != f1.a.q)
        {
            ((Activity)f1.b()).setRequestedOrientation(f1.a.q);
            return;
        }
        continue; /* Loop/switch isn't completed */
        if (!f1.a.x.equals(ae.g)) goto _L1; else goto _L8
_L8:
        if (((Activity)f1.b()).getRequestedOrientation() != f1.a.q)
        {
            ((Activity)f1.b()).setRequestedOrientation(f1.a.q);
        }
        f1.a("mraidBridge.stateChange('hidden');");
        f1.a("mraidBridge.viewableChange('false');");
        return;
_L5:
        b.f();
        return;
_L6:
        f1.a("mraidBridge.stateChange('hidden');");
        f1.a("mraidBridge.viewableChange('false');");
        return;
_L7:
        dd1 = (String)dd1.b.get("bridgeName");
        if (dd1 != null && dd1.equals("mraidObject"))
        {
            switch (_cls1.b[f1.a.x.ordinal()])
            {
            default:
                return;

            case 1: // '\001'
            case 2: // '\002'
                f1.a("mraidBridge.ready();");
                a(f1);
                return;

            case 3: // '\003'
                f1.a("mraidBridge.ready();");
                break;
            }
            return;
        }
        if (true) goto _L1; else goto _L9
_L9:
    }

}
