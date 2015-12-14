// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.graphics.Bitmap;
import android.widget.ImageView;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            AutoPostActivity

class a
    implements Runnable
{

    final Bitmap a;
    final AutoPostActivity b;

    public void run()
    {
        AutoPostActivity.q(b).setImageBitmap(a);
    }

    (AutoPostActivity autopostactivity, Bitmap bitmap)
    {
        b = autopostactivity;
        a = bitmap;
        super();
    }
}
