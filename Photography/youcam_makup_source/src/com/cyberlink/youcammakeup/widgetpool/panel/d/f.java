// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.d;

import android.app.Fragment;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.clflurry.n;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.i;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.o;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.utility.at;
import com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.d:
//            d, g

public class f extends d
{

    public f()
    {
    }

    protected BeautyMode a()
    {
        return BeautyMode.k;
    }

    protected com.cyberlink.youcammakeup.utility.SkuTemplateUtils.FeatureType a(String s)
    {
        return null;
    }

    protected void a(i i1)
    {
        com.cyberlink.youcammakeup.clflurry.b.a(new n(com.cyberlink.youcammakeup.clflurry.YMKFeatures.FeatureName.k));
        i1.b(MotionControlHelper.e().L());
        if (d() == null);
    }

    protected List b(i i1)
    {
        ArrayList arraylist = new ArrayList();
        i1 = i1.E();
        if (i1 != null)
        {
            arraylist.addAll(i1.a());
        }
        return arraylist;
    }

    protected Fragment e()
    {
        return new g();
    }

    protected int f()
    {
        return 0x7f0300f6;
    }

    protected int g()
    {
        return 0x7f030168;
    }

    protected String h()
    {
        return null;
    }

    protected List i()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add("default_original_mustache");
        return arraylist;
    }

    protected at j()
    {
        return null;
    }

    protected int k()
    {
        return 1;
    }

    protected String l()
    {
        return "default_original_mustache";
    }

    protected int n()
    {
        return 0x7f070346;
    }

    protected boolean o()
    {
        return true;
    }

    protected float p()
    {
        return 50F;
    }
}
