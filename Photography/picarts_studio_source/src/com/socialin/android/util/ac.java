// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.util;

import android.app.Activity;
import android.graphics.Bitmap;
import java.io.File;
import java.util.Observer;

// Referenced classes of package com.socialin.android.util:
//            w, Utils, o

public final class ac extends Thread
{

    final Activity a;
    private String b;
    private String c;
    private Bitmap d;
    private String e;
    private boolean f;
    private Observer g;

    public ac(String s, String s1, Bitmap bitmap, String s2, Activity activity, boolean flag, Observer observer)
    {
        b = s;
        c = s1;
        d = bitmap;
        e = s2;
        a = activity;
        f = true;
        g = observer;
        super();
    }

    public final void run()
    {
        Object obj1 = (new StringBuilder()).append(b).append(c).toString();
        Object obj = android.graphics.Bitmap.CompressFormat.JPEG;
        if (c.equalsIgnoreCase(".png"))
        {
            obj = android.graphics.Bitmap.CompressFormat.PNG;
        }
        if (d != null)
        {
            obj1 = w.a(e, ((String) (obj1)), d, a, ((android.graphics.Bitmap.CompressFormat) (obj)), true);
            obj = obj1;
            if (f)
            {
                d.recycle();
                obj = obj1;
            }
        } else
        {
            a.runOnUiThread(new _cls1());
            obj = null;
        }
        if (obj != null)
        {
            Utils.a(a, e);
            new o(a, ((File) (obj)).getAbsolutePath(), "image/*");
        } else
        {
            Utils.a(a, 0x7f0804a0);
        }
        if (g != null)
        {
            g.update(null, null);
        }
    }

    /* member class not found */
    class _cls1 {}

}
