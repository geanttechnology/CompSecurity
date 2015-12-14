// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmdp.speechkit;


// Referenced classes of package com.nuance.nmdp.speechkit:
//            ab, aa

final class b
    implements Runnable
{

    private String a;
    private Object b;
    private ab c;

    public final void run()
    {
        ab.d(c).speakMarkupString(a, b);
    }

    (ab ab1, String s, Object obj)
    {
        c = ab1;
        a = s;
        b = obj;
        super();
    }
}
