// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rhythmnewmedia.sdk;

import com.rhythmnewmedia.sdk.util.Util;

// Referenced classes of package com.rhythmnewmedia.sdk:
//            a, y

public final class d
    implements Runnable
{

    final String a;
    final String b;
    final e c;
    final String d;
    final a e;

    public final void run()
    {
        StringBuilder stringbuilder;
        stringbuilder = new StringBuilder(e.a());
        stringbuilder.append("/adClicked?requestId=");
        stringbuilder.append(a);
        stringbuilder.append("&id=");
        stringbuilder.append(b);
        stringbuilder.append("&");
        stringbuilder.append("v");
        stringbuilder.append("=");
        stringbuilder.append(3);
        if (c != a)
        {
            stringbuilder.append("&action=");
            stringbuilder.append(c.a());
        }
        if (d == null) goto _L2; else goto _L1
_L1:
        Object obj;
        if (d.length() <= 30)
        {
            break MISSING_BLOCK_LABEL_170;
        }
        obj = d.substring(0, 30);
_L3:
        stringbuilder.append("&label=");
        stringbuilder.append(Util.d(((String) (obj))));
_L2:
        obj = e.a(a(stringbuilder.toString()), null);
        com.rhythmnewmedia.sdk.a.a(((org.apache.http.HttpResponse) (obj)));
        return;
        obj = d;
          goto _L3
        Object obj1;
        obj1;
        y.a(((Throwable) (obj1)), "Error during click report", new Object[0]);
        com.rhythmnewmedia.sdk.a.a(null);
        return;
        obj1;
        com.rhythmnewmedia.sdk.a.a(null);
        throw obj1;
    }

    public .Util(a a1, String s, String s1, .Util util, String s2)
    {
        e = a1;
        a = s;
        b = s1;
        c = util;
        d = s2;
        super();
    }
}
