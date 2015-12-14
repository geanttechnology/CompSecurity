// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio;

import android.content.Intent;
import com.socialin.android.d;

// Referenced classes of package com.picsart.studio:
//            ImagePickerActivity

final class a extends Thread
{

    private Intent a;
    private ImagePickerActivity b;

    public final void run()
    {
        java.util.ArrayList arraylist = null;
        int ai[];
        String as[];
        if (a != null && a.hasExtra("selectedItems"))
        {
            as = a.getStringArrayExtra("selectedItems");
            ai = a.getIntArrayExtra("selectedItemsDegrees");
            arraylist = a.getStringArrayListExtra("extra.orig.urls");
            if (d.b)
            {
                for (int i = 0; i < as.length; i++)
                {
                    (new StringBuilder("selected pic ")).append(i).append(" -- ").append(as[i]);
                    (new StringBuilder("selected pic degree")).append(i).append(" -- ").append(ai[i]);
                }

            }
        } else
        {
            ai = null;
            as = null;
        }
        ImagePickerActivity.a(b, as, ai, ImagePickerActivity.a("gallery", as, arraylist));
    }

    (ImagePickerActivity imagepickeractivity, Intent intent)
    {
        b = imagepickeractivity;
        a = intent;
        super();
    }
}
