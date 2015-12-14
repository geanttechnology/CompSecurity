// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.ad;

import android.app.Activity;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.fotoable.homewall.THomewallView;
import java.lang.ref.WeakReference;
import kp;
import ks;

// Referenced classes of package com.fotoable.ad:
//            HomeWallFactory

final class arams
    implements ks
{

    public void GifViewClicked(String s)
    {
        if (HomeWallFactory.access$700() != null && HomeWallFactory.access$700().get() != null)
        {
            ((meWallClickListener)HomeWallFactory.access$700().get()).onHomeWallClicked(s);
        }
    }

    public void GifViewDisplayed(kp kp1)
    {
        if (HomeWallFactory.access$200() != null && HomeWallFactory.access$200().get() != null)
        {
            ImageView imageview = (ImageView)HomeWallFactory.access$200().get();
            if ((ViewGroup)imageview.getParent() != null)
            {
                ((ViewGroup)imageview.getParent()).removeView(imageview);
            }
        }
        if (HomeWallFactory.access$000() != null && HomeWallFactory.access$000().get() != null)
        {
            ((toHomeWalladListener)HomeWallFactory.access$000().get()).onHomeWallReceived(kp1);
            if (HomeWallFactory.access$100() == 1)
            {
                HomeWallFactory.IsHomawallLoaded = true;
            }
            if (HomeWallFactory.access$100() == 2)
            {
                HomeWallFactory.IsSavewallLoaded = true;
            }
        }
    }

    public void GifViewSizeChanged(kp kp1)
    {
        Object obj;
        while (HomeWallFactory.access$400() == null || HomeWallFactory.access$500() == null || HomeWallFactory.access$400().get() == null || HomeWallFactory.access$500().get() == null) 
        {
            return;
        }
        obj = (Activity)HomeWallFactory.access$500().get();
        float f = ((Activity) (obj)).getResources().getDisplayMetrics().widthPixels;
        float f1 = f - (2.0F * f * (320F - (float)kp1.a())) / 320F;
        f = f1;
        if (f1 <= (float)kp1.a())
        {
            f = HomeWallFactory.access$600(((android.content.Context) (obj)), kp1.a());
        }
        f1 = ((float)kp1.b() * f) / (float)kp1.a();
        obj = (android.widget.Params)((THomewallView)HomeWallFactory.access$400().get()).getLayoutParams();
        obj.width = (int)f;
        obj.height = (int)f1;
        if (kp1.a() != kp1.b() && (kp1.a() != 160 || kp1.b() != 120)) goto _L2; else goto _L1
_L1:
        if (HomeWallFactory.access$100() != 1) goto _L4; else goto _L3
_L3:
        obj.gravity = 85;
_L6:
        ((THomewallView)HomeWallFactory.access$400().get()).resetlayout(((android.widget.Params) (obj)));
        return;
_L4:
        if (HomeWallFactory.access$100() == 2)
        {
            obj.gravity = 53;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        obj.gravity = 17;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void GifViewfailed()
    {
        if (HomeWallFactory.access$000() != null && HomeWallFactory.access$000().get() != null && (HomeWallFactory.access$100() == 1 && !HomeWallFactory.IsHomawallLoaded || HomeWallFactory.access$100() == 2 && !HomeWallFactory.IsSavewallLoaded))
        {
            ((toHomeWalladListener)HomeWallFactory.access$000().get()).onHomeWallLoadfailed();
        }
        if (HomeWallFactory.access$200() != null && HomeWallFactory.access$200().get() != null)
        {
            ImageView imageview = (ImageView)HomeWallFactory.access$200().get();
            if (imageview.getParent() != null)
            {
                ((ViewGroup)imageview.getParent()).removeView(imageview);
            }
            if (HomeWallFactory.access$300() != null && HomeWallFactory.access$400().get() != null)
            {
                ((FrameLayout)HomeWallFactory.access$300().get()).addView(imageview);
            }
        }
    }

    arams()
    {
    }
}
