// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.ImageView;
import roboguice.util.Ln;

// Referenced classes of package com.groupon.activity:
//            TravelerNameActivity

class val.view
    implements android.view.alLayoutListener
{

    final TravelerNameActivity this$0;
    final Bitmap val$bitmap;
    final ImageView val$view;

    public void onGlobalLayout()
    {
        Object obj = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(((DisplayMetrics) (obj)));
        int i = ((DisplayMetrics) (obj)).widthPixels;
        int j = (int)Math.floor((val$bitmap.getHeight() * i) / val$bitmap.getWidth());
        Ln.d("PAGER: bm = %s x %s, new = %s x %s", new Object[] {
            Integer.valueOf(val$bitmap.getWidth()), Integer.valueOf(val$bitmap.getHeight()), Integer.valueOf(i), Integer.valueOf(j)
        });
        obj = val$view.getLayoutParams();
        obj.width = i;
        obj.height = j;
        val$view.setLayoutParams(((android.view.rams) (obj)));
        val$view.requestLayout();
        val$view.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }

    Listener()
    {
        this$0 = final_travelernameactivity;
        val$bitmap = bitmap1;
        val$view = ImageView.this;
        super();
    }
}
