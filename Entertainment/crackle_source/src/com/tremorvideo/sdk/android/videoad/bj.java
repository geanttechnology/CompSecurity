// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.content.Context;
import com.tremorvideo.sdk.android.richmedia.ae;
import com.tremorvideo.sdk.android.videoad.a.a;
import java.util.Map;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            bf, bb, ad, n

public class bj extends bf
{

    String a;
    boolean b;
    a c;

    public bj(bf.a a1, Context context, Map map)
    {
        super(a1);
        b = false;
        a = (String)map.get("url");
        c = null;
    }

    private void h()
    {
        i();
        if (c != null)
        {
            a(bf.b.b);
            return;
        } else
        {
            a(bf.b.c);
            return;
        }
    }

    private void i()
    {
        String s = a.replace("|", "%7C");
        Object obj = s;
        if (s.contains(" "))
        {
            obj = s.replace(" ", "%20");
        }
        obj = com.tremorvideo.sdk.android.videoad.bb.a(((String) (obj)), ae.c(((String) (obj))));
        ((bb) (obj)).a();
        obj = ((bb) (obj)).b();
        c = new a(((String) (obj)));
        if (obj == "") goto _L2; else goto _L1
_L1:
        String as[];
        int k;
        as = ((String) (obj)).split("\n");
        k = as.length;
        int j = 0;
_L3:
        if (j >= k)
        {
            break; /* Loop/switch isn't completed */
        }
        s = as[j];
        com.tremorvideo.sdk.android.videoad.ad.a(ad.d.c, s);
        j++;
        if (true) goto _L3; else goto _L2
        Exception exception;
        exception;
        c = null;
        com.tremorvideo.sdk.android.videoad.ad.a(exception);
_L2:
    }

    public void a(String s, n n1)
        throws Exception
    {
        n1.a(s, c);
    }

    protected void e()
    {
        h();
    }

    protected void f()
    {
    }

    protected void g()
    {
        h();
    }

    public String toString()
    {
        return "Download VAST";
    }
}
