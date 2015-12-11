// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;


// Referenced classes of package com.wishabi.flipp.app:
//            ff, MainActivity, SearchFragment

final class di
    implements ff
{

    final MainActivity a;

    di(MainActivity mainactivity)
    {
        a = mainactivity;
        super();
    }

    public final void a()
    {
        MainActivity.a(a).a();
    }

    public final void a(String s)
    {
        MainActivity.a(a).a(s, false);
    }
}
