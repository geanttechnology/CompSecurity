// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk.b;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.ImageButton;

public final class l
{

    public static ImageButton a(Context context, boolean flag)
    {
        ImageButton imagebutton = new ImageButton(context);
        if (!flag)
        {
            imagebutton.setImageDrawable(context.getResources().getDrawable(0x1080038));
        }
        imagebutton.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-2, -2, 53));
        imagebutton.setBackgroundColor(0);
        return imagebutton;
    }

    public static void a(Activity activity, int ai[])
    {
        float f = activity.getResources().getDisplayMetrics().density;
        for (int i = 0; i < ai.length; i++)
        {
            ai[i] = (int)((float)ai[i] / f + 0.5F);
        }

    }

    public static void a(View view)
    {
        if (view != null && view.getParent() != null)
        {
            ((ViewGroup)view.getParent()).removeView(view);
        }
    }

    public static int[] a(Activity activity)
    {
        activity = activity.getWindowManager().getDefaultDisplay();
        int i;
        int j;
        if (android.os.Build.VERSION.SDK_INT >= 13)
        {
            Point point = new Point();
            activity.getSize(point);
            j = point.x;
            i = point.y;
        } else
        {
            j = activity.getWidth();
            i = activity.getHeight();
        }
        return (new int[] {
            j, i
        });
    }

    public static Context b(View view)
    {
        ViewParent viewparent;
label0:
        {
            if (view == null)
            {
                return null;
            }
            ViewParent viewparent1 = view.getParent();
            if (viewparent1 != null)
            {
                viewparent = viewparent1;
                if (viewparent1 instanceof View)
                {
                    break label0;
                }
            }
            return view.getContext();
        }
        for (; viewparent.getParent() != null && (viewparent.getParent() instanceof View); viewparent = viewparent.getParent()) { }
        return ((View)viewparent).getContext();
    }
}
