// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.content.Context;
import java.io.File;
import java.net.SocketTimeoutException;
import java.util.List;
import org.json.JSONObject;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            bf, ad, at, y, 
//            aa, bb, br

public class bh extends bf
{

    JSONObject a;
    String b;
    String c;
    int d;
    boolean e;
    int f;
    String g;
    boolean h;

    public bh(bf.a a1, String s, String s1, boolean flag)
    {
        super(a1);
        f = 1000;
        e = false;
        b = s1;
        a = null;
        g = s;
        h = flag;
    }

    private void i()
    {
        boolean flag1;
        flag1 = false;
        if (a == null)
        {
            Context context = ad.v();
            a = aa.a(at.a(), ad.t(), (new y(context.getFilesDir().getAbsoluteFile())).e(), TremorVideo.a.a, g, h);
        }
        d = 0;
        Object obj = ad.x();
        ad.d((new StringBuilder()).append("User Agent: ").append(((String) (obj))).toString());
        ad.d((new StringBuilder()).append("CCH: ").append(g).toString());
        String s = a.toString();
        ad.d((new StringBuilder()).append("DOWNLOAD REQUEST URL=").append(b).toString());
        obj = bb.a(b, ((String) (obj)), s, ad.f);
        ((bb) (obj)).a();
        c = ((bb) (obj)).b();
        if (c == null || c == "") goto _L2; else goto _L1
_L1:
        String as[];
        int k;
        as = (new JSONObject(c)).toString(2).split("\n");
        k = as.length;
        boolean flag;
        int j = 0;
        do
        {
            if (j >= k)
            {
                break;
            }
            String s1 = as[j];
            try
            {
                ad.a(ad.d.c, s1);
            }
            catch (SocketTimeoutException sockettimeoutexception)
            {
                d = 408;
                ad.a("Error Downloading Request: ", sockettimeoutexception);
                flag = flag1;
                continue; /* Loop/switch isn't completed */
            }
            catch (Exception exception)
            {
                ad.a("Error Downloading Request: ", exception);
                flag = flag1;
                continue; /* Loop/switch isn't completed */
            }
            j++;
        } while (true);
        flag = true;
_L4:
        if (d == 408)
        {
            f = Math.min(0x1d4c0, f * 2);
        } else
        if (!flag)
        {
            d = 500;
            f = Math.min(0x1d4c0, f * 2);
        } else
        if (c.length() == 0)
        {
            d = 204;
            f = Math.min(0x1d4c0, f * 2);
        } else
        {
            d = 1;
        }
        if (d != 1)
        {
            break MISSING_BLOCK_LABEL_433;
        }
        if ((new br(c, g, false, true)).b().isEmpty())
        {
            a(bf.b.c);
            return;
        }
        try
        {
            a(bf.b.b);
            return;
        }
        catch (Exception exception1)
        {
            ad.a(exception1);
        }
        a(bf.b.d);
        return;
        if (d == 408)
        {
            a(bf.b.f);
            return;
        } else
        {
            ad.d((new StringBuilder()).append("Request returned: ").append(d).toString());
            a(bf.b.c);
            return;
        }
_L2:
        flag = false;
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void e()
    {
        i();
    }

    protected void f()
    {
    }

    protected void g()
    {
        i();
    }

    public br h()
    {
        br br1;
        try
        {
            br1 = new br(c, g, false, true);
        }
        catch (Exception exception)
        {
            ad.a(exception);
            return null;
        }
        return br1;
    }

    public String toString()
    {
        return "Download Request";
    }
}
