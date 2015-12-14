// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio;

import android.content.Intent;
import com.socialin.android.d;

// Referenced classes of package com.picsart.studio:
//            ImagePickerActivity

final class b extends Thread
{

    private Intent a;
    private String b;
    private ImagePickerActivity c;

    public final void run()
    {
        java.util.ArrayList arraylist = null;
        boolean flag = false;
        int ai[];
        String as[];
        if (a != null && a.hasExtra("selectedItems"))
        {
            as = a.getStringArrayExtra("selectedItems");
            arraylist = a.getStringArrayListExtra("extra.orig.urls");
            ai = new int[as.length];
            for (int i = 0; i < ai.length; i++)
            {
                ai[i] = 0;
            }

            if (d.b)
            {
                for (int j = ((flag) ? 1 : 0); j < as.length; j++)
                {
                    (new StringBuilder("selected pic ")).append(j).append(" -- ").append(as[j]);
                }

            }
        } else
        {
            ai = null;
            as = null;
        }
        ImagePickerActivity.a(c, as, ai, ImagePickerActivity.a(b, as, arraylist));
    }

    (ImagePickerActivity imagepickeractivity, Intent intent, String s)
    {
        c = imagepickeractivity;
        a = intent;
        b = s;
        super();
    }
}
