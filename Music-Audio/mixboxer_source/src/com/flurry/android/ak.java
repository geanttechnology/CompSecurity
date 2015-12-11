// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;


// Referenced classes of package com.flurry.android:
//            v

final class ak
    implements Runnable
{

    private v cC;

    ak(v v1)
    {
        cC = v1;
        super();
    }

    public final void run()
    {
        if (v.a(cC))
        {
            cC.post(v.b(cC));
        }
    }
}
