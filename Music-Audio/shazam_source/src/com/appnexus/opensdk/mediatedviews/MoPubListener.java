// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk.mediatedviews;

import android.util.Pair;
import com.appnexus.opensdk.ac;
import com.appnexus.opensdk.aq;
import com.appnexus.opensdk.at;
import com.appnexus.opensdk.b.b;
import com.appnexus.opensdk.b.k;
import com.mopub.mobileads.s;
import java.util.ArrayList;
import java.util.Iterator;

public class MoPubListener
    implements com.mopub.mobileads.t.a, com.mopub.mobileads.u.a
{

    private final ac a;
    private final String b;

    public MoPubListener(ac ac1, String s1)
    {
        a = ac1;
        b = s1;
    }

    public static String a(at at1)
    {
        StringBuilder stringbuilder = new StringBuilder();
        static class _cls1
        {

            static final int a[];
            static final int b[];

            static 
            {
                b = new int[com.appnexus.opensdk.k.c.values().length];
                try
                {
                    b[com.appnexus.opensdk.k.c.c.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror14) { }
                try
                {
                    b[com.appnexus.opensdk.k.c.b.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror13) { }
                a = new int[s.values().length];
                try
                {
                    a[s.d.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror12) { }
                try
                {
                    a[s.a.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    a[s.c.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    a[s.e.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    a[s.g.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    a[s.h.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    a[s.i.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    a[s.j.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    a[s.k.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    a[s.l.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[s.m.ordinal()] = 11;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[s.n.ordinal()] = 12;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[s.q.ordinal()] = 13;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        com.appnexus.opensdk.mediatedviews._cls1.b[at1.c.ordinal()];
        JVM INSTR tableswitch 1 2: default 40
    //                   1 149
    //                   2 159;
           goto _L1 _L2 _L3
_L1:
        if (!k.a(at1.a))
        {
            if (stringbuilder.length() > 0)
            {
                stringbuilder.append(",");
            }
            stringbuilder.append("m_age:").append(at1.a);
        }
        Pair pair;
        for (at1 = at1.b.iterator(); at1.hasNext(); stringbuilder.append((String)pair.first).append(":").append((String)pair.second))
        {
            pair = (Pair)at1.next();
            if (stringbuilder.length() > 0)
            {
                stringbuilder.append(",");
            }
        }

        break; /* Loop/switch isn't completed */
_L2:
        stringbuilder.append("m_gender:F");
        continue; /* Loop/switch isn't completed */
_L3:
        stringbuilder.append("m_gender:M");
        if (true) goto _L1; else goto _L4
_L4:
        if (stringbuilder.lastIndexOf(",") == stringbuilder.length() - 1 && stringbuilder.length() > 0)
        {
            stringbuilder.deleteCharAt(stringbuilder.lastIndexOf(","));
        }
        return stringbuilder.toString();
    }

    private void c(s s1)
    {
        aq aq1 = aq.f;
        _cls1.a[s1.ordinal()];
        JVM INSTR tableswitch 1 13: default 80
    //                   1 98
    //                   2 105
    //                   3 112
    //                   4 119
    //                   5 126
    //                   6 133
    //                   7 140
    //                   8 147
    //                   9 154
    //                   10 161
    //                   11 168
    //                   12 175
    //                   13 182;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14
_L1:
        s1 = aq1;
_L16:
        if (a != null)
        {
            a.a(s1);
        }
        return;
_L2:
        s1 = aq.f;
        continue; /* Loop/switch isn't completed */
_L3:
        s1 = aq.c;
        continue; /* Loop/switch isn't completed */
_L4:
        s1 = aq.e;
        continue; /* Loop/switch isn't completed */
_L5:
        s1 = aq.f;
        continue; /* Loop/switch isn't completed */
_L6:
        s1 = aq.d;
        continue; /* Loop/switch isn't completed */
_L7:
        s1 = aq.d;
        continue; /* Loop/switch isn't completed */
_L8:
        s1 = aq.e;
        continue; /* Loop/switch isn't completed */
_L9:
        s1 = aq.c;
        continue; /* Loop/switch isn't completed */
_L10:
        s1 = aq.e;
        continue; /* Loop/switch isn't completed */
_L11:
        s1 = aq.f;
        continue; /* Loop/switch isn't completed */
_L12:
        s1 = aq.f;
        continue; /* Loop/switch isn't completed */
_L13:
        s1 = aq.e;
        continue; /* Loop/switch isn't completed */
_L14:
        s1 = aq.f;
        if (true) goto _L16; else goto _L15
_L15:
    }

    public final void a()
    {
        if (a != null)
        {
            a.f();
        }
    }

    public final void a(s s1)
    {
        com.appnexus.opensdk.b.b.b(b.c, (new StringBuilder()).append(b).append(" | MoPub - onBannerFailed called for MoPubView with ErrorCode: ").append(s1).toString());
        c(s1);
    }

    public final void b()
    {
        if (a != null)
        {
            a.c();
        }
    }

    public final void b(s s1)
    {
        com.appnexus.opensdk.b.b.b(b.c, (new StringBuilder("MoPub - onInterstitialFailed called for MoPubInterstitial with ErrorCode: ")).append(s1).toString());
        c(s1);
    }

    public final void c()
    {
        if (a != null)
        {
            a.f();
        }
    }

    public final void d()
    {
        if (a != null)
        {
            a.e();
        }
    }

    public final void e()
    {
        if (a != null)
        {
            a.d();
        }
    }
}
