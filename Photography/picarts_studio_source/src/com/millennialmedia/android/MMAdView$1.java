// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

// Referenced classes of package com.millennialmedia.android:
//            MMAdView

class a
    implements Runnable
{

    private MMAdView a;

    public void run()
    {
        float f = a.getContext().getResources().getDisplayMetrics().density;
        if (a.d <= 0)
        {
            a.d = (int)((float)a.getWidth() / f);
        }
        if (a.c <= 0)
        {
            a.c = (int)((float)a.getHeight() / f);
        }
    }

    (MMAdView mmadview)
    {
        a = mmadview;
        super();
    }
}
