// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.liverail.library;


// Referenced classes of package com.liverail.library:
//            AdView

class b
    implements Runnable
{

    final AdView a;

    b(AdView adview)
    {
        a = adview;
        super();
    }

    public void run()
    {
        AdView.b(a);
    }
}
