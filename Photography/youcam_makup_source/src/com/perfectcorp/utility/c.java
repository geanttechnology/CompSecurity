// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.perfectcorp.utility;

import android.net.Uri;

// Referenced classes of package com.perfectcorp.utility:
//            d, e

public class c
{

    public static d a(Uri uri)
    {
        d d1;
        String s;
        String s1;
        d1 = new d();
        if (uri == null)
        {
            return d1;
        }
        s = uri.getHost();
        s1 = uri.getPath();
        uri = null;
        long l;
        s1 = s1.split("[/]+", 3)[1];
        e.b(new Object[] {
            s1
        });
        l = Long.parseLong(s1);
        uri = Long.valueOf(l);
_L2:
        d1.a = s;
        d1.b = uri;
        return d1;
        Object obj;
        obj;
        e.d(new Object[] {
            obj
        });
        continue; /* Loop/switch isn't completed */
        obj;
        e.d(new Object[] {
            obj
        });
        if (true) goto _L2; else goto _L1
_L1:
    }
}
