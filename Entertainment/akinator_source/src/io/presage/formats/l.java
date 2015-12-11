// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.formats;

import android.content.Context;
import android.view.WindowManager;
import io.presage.utils.e;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package io.presage.formats:
//            h, b

final class l
    implements Runnable
{

    final h a;

    l(h h1)
    {
        a = h1;
        super();
    }

    public final void run()
    {
        WindowManager windowmanager = (WindowManager)a.h().getSystemService("window");
        if (a.e() != null)
        {
            try
            {
                for (Iterator iterator = a.e().iterator(); iterator.hasNext(); windowmanager.removeView(((b)iterator.next()).b())) { }
            }
            catch (IllegalArgumentException illegalargumentexception)
            {
                e.c(new String[] {
                    "Ad", "hideAd error: ", illegalargumentexception.toString()
                });
            }
        }
    }
}
