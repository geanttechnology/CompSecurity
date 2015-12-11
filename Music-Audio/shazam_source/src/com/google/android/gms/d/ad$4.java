// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;


// Referenced classes of package com.google.android.gms.d:
//            ad, he

final class a
    implements Runnable
{

    final String a;
    final ad b;

    public final void run()
    {
        b.a.loadData(a, "text/html", "UTF-8");
    }

    (ad ad1, String s)
    {
        b = ad1;
        a = s;
        super();
    }
}
