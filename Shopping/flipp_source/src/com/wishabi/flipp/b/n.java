// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.b;

import android.os.AsyncTask;
import java.net.URL;

// Referenced classes of package com.wishabi.flipp.b:
//            a

final class n extends AsyncTask
{

    final URL a;
    final String b;
    final a c;

    n(a a1, URL url, String s)
    {
        c = a1;
        a = url;
        b = s;
        super();
    }

    protected final Object doInBackground(Object aobj[])
    {
        com.wishabi.flipp.b.a.a(a, b);
        return null;
    }
}
