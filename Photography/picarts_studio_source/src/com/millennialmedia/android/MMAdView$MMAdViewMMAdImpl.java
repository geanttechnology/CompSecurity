// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import java.util.Map;
import java.util.Random;

// Referenced classes of package com.millennialmedia.android:
//            MMAdView, MMSDK

class ientListener extends ientListener
{

    final MMAdView k;

    final void a(Bitmap bitmap)
    {
        k.a.setImageBitmap(bitmap);
        k.a.setVisibility(0);
        k.a.bringToFront();
    }

    final void a(Map map)
    {
        if (k.c > 0)
        {
            map.put("hsht", String.valueOf(k.c));
        }
        if (k.d > 0)
        {
            map.put("hswd", String.valueOf(k.d));
        }
        super.a(map);
    }

    final boolean g()
    {
        return k.b != 0;
    }

    final void h()
    {
        if (k.a.getDrawable() == null) goto _L2; else goto _L1
_L1:
        int i;
        int j = k.b;
        i = j;
        if (j == 4)
        {
            i = (new Random()).nextInt(4);
        }
        i;
        JVM INSTR tableswitch 2 3: default 64
    //                   2 117
    //                   3 140;
           goto _L3 _L4 _L5
_L3:
        Object obj = new AlphaAnimation(1.0F, 0.0F);
_L7:
        ((Animation) (obj)).setDuration(1000L);
        ((Animation) (obj)).setAnimationListener(k);
        ((Animation) (obj)).setFillEnabled(true);
        ((Animation) (obj)).setFillBefore(true);
        ((Animation) (obj)).setFillAfter(true);
        MMSDK.a(new Runnable(((Animation) (obj))) {

            private Animation a;
            private MMAdView.MMAdViewMMAdImpl b;

            public void run()
            {
                b.k.a.startAnimation(a);
            }

            
            {
                b = MMAdView.MMAdViewMMAdImpl.this;
                a = animation;
                super();
            }
        });
_L2:
        return;
_L4:
        obj = new TranslateAnimation(0.0F, 0.0F, 0.0F, -(float)k.getHeight());
        continue; /* Loop/switch isn't completed */
_L5:
        obj = new TranslateAnimation(0.0F, 0.0F, 0.0F, k.getHeight());
        if (true) goto _L7; else goto _L6
_L6:
    }

    public boolean hasCachedVideoSupport()
    {
        return false;
    }

    public boolean isBanner()
    {
        return true;
    }

    final String l()
    {
        return "millennialmedia.action.ACTION_GETAD_FAILED";
    }

    final String m()
    {
        return "millennialmedia.action.ACTION_GETAD_SUCCEEDED";
    }

    final String n()
    {
        return "getad";
    }

    final boolean o()
    {
        return k.getWindowToken() != null;
    }

    public _cls1.a(MMAdView mmadview, Context context)
    {
        k = mmadview;
        super(mmadview, context);
        i = new ientListener(this);
    }
}
