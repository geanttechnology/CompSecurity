// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk;

import com.appnexus.opensdk.b.d;
import com.appnexus.opensdk.b.e;
import java.net.MalformedURLException;
import java.net.URL;

// Referenced classes of package com.appnexus.opensdk:
//            m

final class <init> extends d
{

    final String a;
    final m b;

    protected final String a()
    {
        return a;
    }

    protected final void a(e e1)
    {
        if (e1.a)
        {
            e1 = com.appnexus.opensdk.m.d(e1.b);
            String s = m.a(b, e1);
            try
            {
                e1 = (new URL(a)).getHost();
            }
            // Misplaced declaration of an exception variable
            catch (e e1)
            {
                e1 = null;
            }
            b.loadDataWithBaseURL(e1, s, "text/html", "UTF-8", null);
            b.g();
        }
    }

    protected final void onPostExecute(Object obj)
    {
        a((e)obj);
    }

    ption(m m1, String s)
    {
        b = m1;
        a = s;
        super();
    }
}
