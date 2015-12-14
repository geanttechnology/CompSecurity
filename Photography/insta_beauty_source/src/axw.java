// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import android.view.ViewGroup;
import com.instabeauty.application.InstaBeautyApplication;
import com.wantu.activity.mainpage.MainFontFitTextView;

public class axw extends yp
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
            if (obj instanceof MainFontFitTextView)
            {
                android.view.ViewGroup.LayoutParams layoutparams3 = ((View) (obj)).getLayoutParams();
                if (layoutparams3 != null)
                {
                    MainFontFitTextView mainfontfittextview = (MainFontFitTextView)obj;
                    int i1 = layoutparams3.height;
                    i1 = d(InstaBeautyApplication.a().b(), i1);
                    if (i1 > 0)
                    {
                        float f1 = f(InstaBeautyApplication.a().b());
                        mainfontfittextview.setMaxFontSize((float)(i1 - 10) * f1);
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
