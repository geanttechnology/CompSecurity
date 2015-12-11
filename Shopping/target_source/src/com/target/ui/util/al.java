// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util;

import android.view.View;
import android.widget.TextView;

public class al
{

    public static transient void a(float f, View aview[])
    {
        if (aview != null)
        {
            int j = aview.length;
            int i = 0;
            while (i < j) 
            {
                aview[i].setAlpha(f);
                i++;
            }
        }
    }

    public static transient void a(int i, View aview[])
    {
        if (aview != null)
        {
            int k = aview.length;
            int j = 0;
            while (j < k) 
            {
                a(aview[j], i);
                j++;
            }
        }
    }

    public static transient void a(android.view.View.OnClickListener onclicklistener, View aview[])
    {
        if (aview != null)
        {
            int j = aview.length;
            int i = 0;
            while (i < j) 
            {
                View view = aview[i];
                if (view != null)
                {
                    view.setOnClickListener(onclicklistener);
                }
                i++;
            }
        }
    }

    public static void a(View view, int i)
    {
        if (view != null && view.getVisibility() != i)
        {
            view.setVisibility(i);
        }
    }

    public static void a(View view, int i, int j, int k, int l)
    {
        if (view.getLayoutParams() instanceof android.view.ViewGroup.MarginLayoutParams)
        {
            ((android.view.ViewGroup.MarginLayoutParams)view.getLayoutParams()).setMargins(i, j, k, l);
            view.requestLayout();
        }
    }

    public static void a(View view, boolean flag)
    {
        if (view != null)
        {
            int i;
            if (flag)
            {
                i = 0;
            } else
            {
                i = 8;
            }
            view.setVisibility(i);
        }
    }

    public static transient void a(View view, View aview[])
    {
        a(aview);
        b(view);
    }

    public static void a(TextView textview, CharSequence charsequence)
    {
        if (textview == null)
        {
            return;
        } else
        {
            textview.setText(charsequence);
            b(textview);
            return;
        }
    }

    public static transient void a(View aview[])
    {
        a(8, aview);
    }

    public static boolean a(View view)
    {
        while (view == null || view.getVisibility() != 0) 
        {
            return false;
        }
        return true;
    }

    public static void b(View view)
    {
        a(view, 0);
    }

    public static transient void b(View aview[])
    {
        a(0, aview);
    }

    public static void c(View view)
    {
        a(view, 8);
    }

    public static void d(View view)
    {
        a(view, 4);
    }
}
