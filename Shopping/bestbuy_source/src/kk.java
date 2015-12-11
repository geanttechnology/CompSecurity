// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.bestbuy.android.bbyobjects.MyBBYCertViewPager;

public class kk
    implements android.support.v4.view.ViewPager.PageTransformer
{

    final MyBBYCertViewPager a;

    private kk(MyBBYCertViewPager mybbycertviewpager)
    {
        a = mybbycertviewpager;
        super();
    }

    public kk(MyBBYCertViewPager mybbycertviewpager, com.bestbuy.android.bbyobjects.MyBBYCertViewPager._cls1 _pcls1)
    {
        this(mybbycertviewpager);
    }

    public void transformPage(View view, float f)
    {
        int i = view.getWidth();
        int j = view.getHeight();
        if (f < -1F)
        {
            view.setAlpha(0.0F);
            return;
        }
        if (f <= 1.0F)
        {
            view.setAlpha(1.0F);
            view.setTranslationX((float)i * -f);
            view.setTranslationY((float)j * f);
            return;
        } else
        {
            view.setAlpha(0.0F);
            return;
        }
    }
}
