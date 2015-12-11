// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads;

import android.content.Context;
import android.widget.RelativeLayout;
import com.facebook.ads.a.b.u;
import com.facebook.ads.a.f.k;
import com.facebook.ads.a.f.s;
import com.facebook.ads.a.g.a.a;
import com.facebook.ads.a.g.c;

// Referenced classes of package com.facebook.ads:
//            k

public final class j extends RelativeLayout
{

    private final c a;
    private final a b;
    private boolean c;
    private boolean d;

    private j(Context context)
    {
        super(context, null);
        c = false;
        d = true;
        a = new c(context);
        a.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, -1));
        addView(a);
        b = new a(context);
        context = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        context.addRule(13);
        b.setLayoutParams(context);
        b.setAutoplay(d);
        addView(b);
    }

    public j(Context context, byte byte0)
    {
        this(context);
    }

    public final void setAutoplay(boolean flag)
    {
        d = flag;
        b.setAutoplay(flag);
    }

    public final void setNativeAd(com.facebook.ads.k k1)
    {
        Object obj = null;
        k1.c = true;
        k1.d = d;
        if (c)
        {
            a.a(null, null);
            b.a = null;
            c = false;
        }
        String s1;
        a a1;
        boolean flag;
        if (!s.a(k1.h()))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag) goto _L2; else goto _L1
_L1:
        a.setVisibility(4);
        b.setVisibility(0);
        bringChildToFront(b);
        c = true;
        a1 = b;
        if (k1.b()) goto _L4; else goto _L3
_L3:
        s1 = null;
_L7:
        a1.setVideoPlayReportURI(s1);
        a1 = b;
        if (!k1.b())
        {
            s1 = obj;
            break MISSING_BLOCK_LABEL_127;
        }
          goto _L5
_L4:
        s1 = k1.b.q();
        continue; /* Loop/switch isn't completed */
_L5:
        s1 = k1.b.r();
        try
        {
            a1.setVideoTimeReportURI(s1);
            b.setVideoURI(k1.h());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.facebook.ads.k k1)
        {
            k1.printStackTrace();
        }
        return;
_L2:
        if (k1.d() != null)
        {
            b.a();
            b.setVisibility(4);
            a.setVisibility(0);
            bringChildToFront(a);
            c = true;
            (new k(a)).execute(new String[] {
                k1.d().a
            });
        }
        return;
        if (true) goto _L7; else goto _L6
_L6:
    }
}
