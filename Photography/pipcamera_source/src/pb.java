// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import android.view.ViewGroup;
import com.pipcamera.activity.mainViewPager.FontFitTextView;
import com.pipcamera.application.PIPCameraApplication;

public class pb extends ew
{

    public static void a(ViewGroup viewgroup, float f)
    {
        int j = viewgroup.getChildCount();
        for (int i = 0; i < j; i++)
        {
            Object obj = viewgroup.getChildAt(i);
            if (!(obj instanceof View))
            {
                continue;
            }
            android.view.ViewGroup.LayoutParams layoutparams = ((View) (obj)).getLayoutParams();
            if (layoutparams.width >= 0)
            {
                layoutparams.width = (int)((float)layoutparams.width * f);
            }
            if (layoutparams.height >= 0)
            {
                layoutparams.height = (int)((float)layoutparams.height * f);
            }
            if (layoutparams instanceof android.widget.FrameLayout.LayoutParams)
            {
                android.widget.FrameLayout.LayoutParams layoutparams1 = (android.widget.FrameLayout.LayoutParams)layoutparams;
                int k = (int)((float)layoutparams1.leftMargin * f);
                int j1 = (int)((float)layoutparams1.rightMargin * f);
                layoutparams1.setMargins(k, (int)((float)layoutparams1.topMargin * f), j1, (int)((float)layoutparams1.bottomMargin * f));
            }
            if (layoutparams instanceof android.widget.RelativeLayout.LayoutParams)
            {
                android.widget.RelativeLayout.LayoutParams layoutparams2 = (android.widget.RelativeLayout.LayoutParams)layoutparams;
                int l = (int)((float)layoutparams2.leftMargin * f);
                int k1 = (int)((float)layoutparams2.rightMargin * f);
                layoutparams2.setMargins(l, (int)((float)layoutparams2.topMargin * f), k1, (int)((float)layoutparams2.bottomMargin * f));
            }
            if (obj instanceof FontFitTextView)
            {
                android.view.ViewGroup.LayoutParams layoutparams3 = ((View) (obj)).getLayoutParams();
                if (layoutparams3 != null)
                {
                    FontFitTextView fontfittextview = (FontFitTextView)obj;
                    int i1 = layoutparams3.height;
                    i1 = d(PIPCameraApplication.a, i1);
                    if (i1 > 0)
                    {
                        float f1 = f(PIPCameraApplication.a);
                        fontfittextview.setMaxFontSize((float)(i1 - 5) * f1);
                    }
                }
            }
            ((View) (obj)).setLayoutParams(layoutparams);
            if (!(obj instanceof ViewGroup))
            {
                continue;
            }
            obj = (ViewGroup)obj;
            if (((ViewGroup) (obj)).getChildCount() > 0)
            {
                a(((ViewGroup) (obj)), f);
            }
        }

    }
}
