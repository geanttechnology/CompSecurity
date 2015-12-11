// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk.mediatedviews;

import com.appnexus.opensdk.ac;
import com.appnexus.opensdk.ad;
import com.appnexus.opensdk.af;
import com.appnexus.opensdk.aq;
import com.appnexus.opensdk.b.b;
import com.millennialmedia.android.aa;
import com.millennialmedia.android.ag;
import com.millennialmedia.android.at;

class MillennialMediaListener
    implements at
{

    final String a;
    private final ac b;

    public MillennialMediaListener(ac ac1, String s)
    {
        b = ac1;
        a = s;
    }

    public void MMAdOverlayClosed(aa aa)
    {
        a((new StringBuilder("MMAdOverlayClosed: ")).append(aa).toString());
        if (b != null && (b instanceof ad))
        {
            b.e();
        }
    }

    public void MMAdOverlayLaunched(aa aa)
    {
        a((new StringBuilder("MMAdOverlayLaunched: ")).append(aa).toString());
        if (b != null && (b instanceof ad))
        {
            b.d();
        }
    }

    public void MMAdRequestIsCaching(aa aa)
    {
        a((new StringBuilder("MMAdRequestIsCaching: ")).append(aa).toString());
    }

    final void a(String s)
    {
        com.appnexus.opensdk.b.b.b(b.c, (new StringBuilder()).append(a).append(" - ").append(s).toString());
    }

    final void b(String s)
    {
        com.appnexus.opensdk.b.b.e(b.c, (new StringBuilder()).append(a).append(" - ").append(s).toString());
    }

    public void onSingleTap(aa aa)
    {
        a((new StringBuilder("onSingleTap: ")).append(aa).toString());
        if (b != null)
        {
            b.f();
        }
    }

    public void requestCompleted(aa aa)
    {
        a((new StringBuilder("requestCompleted: ")).append(aa).toString());
        if (b != null)
        {
            b.c();
        }
    }

    public void requestFailed(aa aa, ag ag1)
    {
        aq aq1;
        boolean flag;
        a((new StringBuilder("requestFailed: ")).append(aa).append(" with error: ").append(ag1).toString());
        aq1 = aq.f;
        flag = false;
        ag1.a;
        JVM INSTR lookupswitch 19: default 204
    //                   1: 227
    //                   2: 234
    //                   3: 241
    //                   10: 248
    //                   11: 255
    //                   12: 262
    //                   13: 269
    //                   14: 276
    //                   15: 283
    //                   16: 290
    //                   17: 297
    //                   20: 330
    //                   21: 337
    //                   22: 344
    //                   23: 351
    //                   24: 358
    //                   25: 365
    //                   26: 372
    //                   100: 379;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20
_L1:
        aa = aq1;
_L22:
        if (!flag && b != null)
        {
            b.a(aa);
        }
        return;
_L2:
        aa = aq.b;
        continue; /* Loop/switch isn't completed */
_L3:
        aa = aq.f;
        continue; /* Loop/switch isn't completed */
_L4:
        aa = aq.f;
        continue; /* Loop/switch isn't completed */
_L5:
        aa = aq.e;
        continue; /* Loop/switch isn't completed */
_L6:
        aa = aq.e;
        continue; /* Loop/switch isn't completed */
_L7:
        aa = aq.b;
        continue; /* Loop/switch isn't completed */
_L8:
        aa = aq.b;
        continue; /* Loop/switch isn't completed */
_L9:
        aa = aq.c;
        continue; /* Loop/switch isn't completed */
_L10:
        aa = aq.b;
        continue; /* Loop/switch isn't completed */
_L11:
        aa = aq.b;
        continue; /* Loop/switch isn't completed */
_L12:
        a("cache not empty, show the cached ad");
        aa = aq1;
        if (b instanceof af)
        {
            flag = true;
            b.c();
            aa = aq1;
        }
        continue; /* Loop/switch isn't completed */
_L13:
        aa = aq.c;
        continue; /* Loop/switch isn't completed */
_L14:
        aa = aq.c;
        continue; /* Loop/switch isn't completed */
_L15:
        aa = aq.c;
        continue; /* Loop/switch isn't completed */
_L16:
        aa = aq.c;
        continue; /* Loop/switch isn't completed */
_L17:
        aa = aq.c;
        continue; /* Loop/switch isn't completed */
_L18:
        aa = aq.f;
        continue; /* Loop/switch isn't completed */
_L19:
        aa = aq.f;
        continue; /* Loop/switch isn't completed */
_L20:
        aa = aq.f;
        if (true) goto _L22; else goto _L21
_L21:
    }
}
