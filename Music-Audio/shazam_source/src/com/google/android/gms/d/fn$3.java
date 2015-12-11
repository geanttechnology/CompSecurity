// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;


// Referenced classes of package com.google.android.gms.d:
//            fn, fp, he

static final class a
    implements Runnable
{

    final fp a;

    public final void run()
    {
        fp fp1 = a;
        if (fp1.e != null)
        {
            fp1.e.destroy();
            fp1.e = null;
        }
        if (a.f != null)
        {
            a.f.a();
        }
    }

    (fp fp1)
    {
        a = fp1;
        super();
    }
}
