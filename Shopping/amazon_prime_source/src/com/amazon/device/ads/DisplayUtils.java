// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.WindowManager;

// Referenced classes of package com.amazon.device.ads:
//            AndroidTargetUtils

class DisplayUtils
{

    private static int rotationArray[][] = {
        {
            1, 0, 9, 8
        }, {
            0, 9, 8, 1
        }
    };

    DisplayUtils()
    {
    }

    public static int determineCanonicalScreenOrientation(Context context)
    {
        int j = AndroidTargetUtils.getOrientation(((WindowManager)context.getSystemService("window")).getDefaultDisplay());
        int i = context.getResources().getConfiguration().orientation;
        if (i == 1)
        {
            if (j == 0 || j == 2)
            {
                i = 1;
            } else
            {
                i = 0;
            }
        } else
        if (i == 2)
        {
            if (j == 1 || j == 3)
            {
                i = 1;
            } else
            {
                i = 0;
            }
        } else
        {
            i = 1;
        }
        if (i != 0)
        {
            i = 0;
        } else
        {
            i = 1;
        }
        return rotationArray[i][j];
    }

}
