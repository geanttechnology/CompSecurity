// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.picsinphoto;


// Referenced classes of package com.socialin.android.photo.picsinphoto:
//            MainPagerActivity

final class a
    implements Runnable
{

    private MainPagerActivity a;

    public final void run()
    {
        if (!MainPagerActivity.k(a))
        {
            MainPagerActivity.l(a);
        }
    }

    (MainPagerActivity mainpageractivity)
    {
        a = mainpageractivity;
        super();
    }
}
