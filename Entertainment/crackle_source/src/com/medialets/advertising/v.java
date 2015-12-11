// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.medialets.advertising;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

// Referenced classes of package com.medialets.advertising:
//            DisplayInfo

final class v extends DisplayInfo
{

    v()
    {
        this((byte)0);
    }

    private v(byte byte0)
    {
    }

    public final int getDpi(Context context)
    {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        ((WindowManager)context.getSystemService("window")).getDefaultDisplay().getMetrics(displaymetrics);
        return displaymetrics.densityDpi;
    }
}
