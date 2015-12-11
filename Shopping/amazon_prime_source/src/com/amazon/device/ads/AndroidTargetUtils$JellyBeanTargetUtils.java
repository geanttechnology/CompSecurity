// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;

// Referenced classes of package com.amazon.device.ads:
//            AndroidTargetUtils

private static class 
{

    public static void hideStatusBar(Activity activity)
    {
        activity.getWindow().getDecorView().setSystemUiVisibility(4);
    }

    public static void setBackgroundForLinerLayout(View view, Drawable drawable)
    {
        view.setBackground(drawable);
    }

    protected static void setImageButtonAlpha(ImageButton imagebutton, int i)
    {
        imagebutton.setImageAlpha(i);
    }

    private ()
    {
    }
}
