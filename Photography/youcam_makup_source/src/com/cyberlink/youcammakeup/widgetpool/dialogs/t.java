// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.dialogs;

import android.graphics.Bitmap;
import android.graphics.RectF;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.dialogs:
//            s

class t
{

    float a;
    float b;
    RectF c;
    RectF d;
    Bitmap e;
    final s f;

    t(s s)
    {
        f = s;
        super();
        c = new RectF();
        d = new RectF();
    }

    void a(float f1, float f2, float f3, float f4)
    {
        float f5 = 0.0F;
        a = f1;
        b = f2;
        if (f1 < 0.0F)
        {
            f1 = 0.0F;
        }
        if (f2 < 0.0F)
        {
            f2 = f5;
        }
        if (f1 <= f3)
        {
            f3 = f1;
        }
        if (f2 <= f4)
        {
            f4 = f2;
        }
        c.set(f3 - (float)(e.getWidth() / 2), f4 - (float)(e.getHeight() / 2), (float)(e.getWidth() / 2) + f3, (float)(e.getHeight() / 2) + f4);
        d.set(f3 - (float)e.getWidth(), f4 - (float)e.getHeight(), (float)e.getWidth() + f3, (float)e.getHeight() + f4);
    }
}
