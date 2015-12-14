// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.utility;


// Referenced classes of package com.cyberlink.you.utility:
//            ULogUtility

final class c
    implements Runnable
{

    final gType a;
    final String b;
    final String c;

    public void run()
    {
        ULogUtility.a(a, b, c);
    }

    gType(gType gtype, String s, String s1)
    {
        a = gtype;
        b = s;
        c = s1;
        super();
    }
}
