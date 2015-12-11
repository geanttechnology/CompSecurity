// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.net.Uri;

// Referenced classes of package android.support.v7:
//            akj, ez, aqo

class b
    implements akj
{

    final b a;
    final Uri b;
    final ez c;

    public void a()
    {
        aqo.a("Picasso image load ok", new Object[0]);
        a.a();
    }

    public void b()
    {
        aqo.c("Picasso image error %s:", new Object[] {
            b
        });
        a.b();
    }

    (ez ez1,  , Uri uri)
    {
        c = ez1;
        a = ;
        b = uri;
        super();
    }
}
