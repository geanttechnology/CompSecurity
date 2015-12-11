// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.e;

import android.content.Context;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

// Referenced classes of package com.google.android.gms.e:
//            v, x, bv, bh, 
//            aj, w

final class dj
    implements v
{

    private static dj a;
    private static final Object b = new Object();
    private String c;
    private String d;
    private bh e;
    private w f;

    private dj(Context context)
    {
        this(((w) (x.a(context))), ((bh) (new bv((byte)0))));
    }

    private dj(w w1, bh bh1)
    {
        f = w1;
        e = bh1;
    }

    public static v a(Context context)
    {
        synchronized (b)
        {
            if (a == null)
            {
                a = new dj(context);
            }
            context = a;
        }
        return context;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    public final boolean a(String s)
    {
        if (!e.a())
        {
            aj.a();
            return false;
        }
        String s1 = s;
        if (c != null)
        {
            s1 = s;
            if (d != null)
            {
                try
                {
                    s1 = (new StringBuilder()).append(c).append("?").append(d).append("=").append(URLEncoder.encode(s, "UTF-8")).toString();
                    aj.d();
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    aj.b();
                    return false;
                }
            }
        }
        f.a(s1);
        return true;
    }

}
