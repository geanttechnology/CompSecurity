// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.iovation.mobile.android.details;

import android.content.Context;
import android.view.Display;
import android.view.WindowManager;

// Referenced classes of package com.iovation.mobile.android.details:
//            i, j

public class l
    implements i
{

    public l()
    {
    }

    public void a(Context context, j j1)
    {
        context = ((WindowManager)context.getSystemService("window")).getDefaultDisplay();
        if (context != null)
        {
            int k = context.getRotation();
            if (k == 0)
            {
                j1.a("DOR", "PORTRAIT");
                return;
            }
            if (k == 2)
            {
                j1.a("DOR", "UPSIDEDOWN");
                return;
            }
            if (k == 1)
            {
                j1.a("DOR", "LEFT");
                return;
            }
            if (k == 3)
            {
                j1.a("DOR", "RIGHT");
                return;
            }
        }
    }
}
