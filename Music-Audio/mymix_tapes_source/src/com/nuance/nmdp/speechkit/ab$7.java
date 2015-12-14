// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmdp.speechkit;


// Referenced classes of package com.nuance.nmdp.speechkit:
//            ab, aa

final class a
    implements Runnable
{

    private String a;
    private ab b;

    public final void run()
    {
        ab.d(b).setVoice(a);
    }

    (ab ab1, String s)
    {
        b = ab1;
        a = s;
        super();
    }
}
