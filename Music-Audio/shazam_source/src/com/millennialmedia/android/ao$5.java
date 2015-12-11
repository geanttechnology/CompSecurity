// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;


// Referenced classes of package com.millennialmedia.android:
//            ao

final class a
    implements Runnable
{

    final String a;
    final ao b;

    public final void run()
    {
        b.loadUrl(a);
    }

    (ao ao1, String s)
    {
        b = ao1;
        a = s;
        super();
    }
}
