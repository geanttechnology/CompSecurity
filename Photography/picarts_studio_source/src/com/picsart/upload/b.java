// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.upload;

import com.socialin.android.d;
import com.socialin.android.picsart.upload.UploadItem;

// Referenced classes of package com.picsart.upload:
//            a

public class b
{

    a a;

    b(a a1)
    {
        a = a1;
        super();
    }

    b(a a1, byte byte0)
    {
        this(a1);
    }

    public void a(String s)
    {
        d.b("item uploader", new Object[] {
            (new StringBuilder("onSuccess ")).append(s).toString()
        });
        com.picsart.upload.a.c(a, s);
        com.picsart.upload.a.f(a);
    }

    public void a(String s, String s1)
    {
        d.b("item uploader", new Object[] {
            (new StringBuilder("onFailure ")).append(s).append(" :::: error message: ").append(s1).toString()
        });
        if ("picsart".equals(s) && s1 != null && s1.toLowerCase().contains("duplicate"))
        {
            for (; a.a.d(s); a.a.g(s)) { }
            com.picsart.upload.a.g(a);
        } else
        {
            com.picsart.upload.a.a(a, s);
        }
        com.picsart.upload.a.f(a);
    }
}
