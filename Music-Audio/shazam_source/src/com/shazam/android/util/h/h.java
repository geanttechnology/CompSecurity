// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.util.h;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;

public final class h
{

    public static int a(ViewGroup viewgroup)
    {
        int l = viewgroup.getChildCount();
        int i = 0;
        int j = 0;
        while (i < l) 
        {
            int k;
            if (viewgroup.getChildAt(i).getVisibility() == 8)
            {
                k = 0;
            } else
            {
                k = 1;
            }
            j += k;
            i++;
        }
        return j;
    }

    public static ViewGroup a(Activity activity)
    {
        return (ViewGroup)activity.findViewById(0x1020002);
    }

    public static FrameLayout a(Context context, ViewGroup viewgroup, int i)
    {
        context = new FrameLayout(context);
        for (int j = viewgroup.getChildCount() - 1; j >= 0; j--)
        {
            View view = viewgroup.getChildAt(j);
            viewgroup.removeView(view);
            context.addView(view, 0);
        }

        context.setId(i);
        return context;
    }

    public static void a(View view)
    {
        if (view instanceof ViewGroup)
        {
            view = (ViewGroup)view;
            for (int i = view.getChildCount() - 1; i >= 0; i--)
            {
                View view1 = view.getChildAt(i);
                view.removeView(view1);
                if ((view1 instanceof ViewGroup) && !(view1 instanceof AdapterView))
                {
                    a(view1);
                }
            }

        }
    }
}
