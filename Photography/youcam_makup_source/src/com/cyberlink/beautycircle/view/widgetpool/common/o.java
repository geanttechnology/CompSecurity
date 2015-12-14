// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.view.widgetpool.common;

import android.view.View;

public class o
    implements android.support.v4.view.ViewPager.PageTransformer
{

    private int a;
    private int b;
    private float c;

    public o(int i)
    {
        b = 0;
        c = 0.2F;
        a = i;
    }

    public void a(float f)
    {
        c = f;
    }

    public void transformPage(View view, float f)
    {
        float f1;
label0:
        {
            View view1 = view.findViewById(a);
            if (view1 != null && android.os.Build.VERSION.SDK_INT > 11 && f > -1F && f < 1.0F)
            {
                view1.setTranslationX(-((float)view1.getWidth() * f * c));
                f1 = ((float)view.getWidth() - (float)b) / (float)view.getWidth();
                if (f != 0.0F)
                {
                    break label0;
                }
                view.setScaleX(1.0F);
                view.setScaleY(1.0F);
            }
            return;
        }
        view.setScaleX(f1);
        view.setScaleY(f1);
    }
}
