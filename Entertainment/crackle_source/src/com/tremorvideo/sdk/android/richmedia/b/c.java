// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.richmedia.b;

import com.tremorvideo.sdk.android.videoad.ad;
import com.tremorvideo.sdk.android.videoad.h;
import org.json.JSONObject;

// Referenced classes of package com.tremorvideo.sdk.android.richmedia.b:
//            b, d

public class c
    implements b
{

    private h a;
    private d b;
    private String c;

    public c(h h1, d d1, String s)
    {
        a = h1;
        b = d1;
        c = s;
    }

    public void a()
    {
        a.p();
    }

    public void a(float f)
    {
        if (b != null)
        {
            b.a(f);
        }
    }

    public void a(android.widget.RelativeLayout.LayoutParams layoutparams)
    {
        a.a(layoutparams);
    }

    public void a(com.tremorvideo.sdk.android.videoad.aw.b b1, String s)
    {
        a.a(b1, s);
    }

    public void a(String s)
    {
        a.b(s);
    }

    public void a(String s, String s1)
    {
        b.clearView();
        s1 = new JSONObject(s1);
        s1.put("query_url", c);
_L2:
        b.a(s, s1);
        return;
        Exception exception;
        exception;
        s1 = null;
_L3:
        ad.a(exception);
        if (true) goto _L2; else goto _L1
_L1:
        exception;
          goto _L3
    }

    public void b()
    {
        a.q();
    }

    public void c()
    {
        if (b != null)
        {
            b.destroy();
            b = null;
            System.gc();
        }
    }
}
