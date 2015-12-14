// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio;

import android.os.Looper;
import myobfuscated.f.m;

// Referenced classes of package com.picsart.studio:
//            ImagePickerActivity

final class a
    implements Runnable
{

    private ImagePickerActivity a;

    public final void run()
    {
        if (ImagePickerActivity.e(a))
        {
            boolean flag;
            if (Looper.getMainLooper().getThread() != Thread.currentThread())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            m.a(a, ImagePickerActivity.f(a), flag);
        }
    }

    (ImagePickerActivity imagepickeractivity)
    {
        a = imagepickeractivity;
        super();
    }
}
