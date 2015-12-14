// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.clipart;

import android.app.Activity;
import android.support.v4.view.ViewPager;
import android.widget.ListView;

// Referenced classes of package com.socialin.android.photo.clipart:
//            f

final class a
    implements Runnable
{

    private Activity a;
    private f b;

    public final void run()
    {
        f.d(b).setItemChecked(f.b(), true);
        android.view.View view = a.findViewById(0x7f100169);
        if (view != null && (view instanceof ViewPager))
        {
            ((ViewPager)view).setCurrentItem(0, true);
        }
    }

    (f f1, Activity activity)
    {
        b = f1;
        a = activity;
        super();
    }
}
