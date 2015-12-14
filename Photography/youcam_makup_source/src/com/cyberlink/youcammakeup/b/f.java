// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.b;

import android.app.Activity;
import android.graphics.Bitmap;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import com.cyberlink.youcammakeup.utility.aa;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.b:
//            a, g, b

public class f extends a
{

    private View a;
    private Pair b;

    protected View a(LayoutInflater layoutinflater, b b1)
    {
        b1 = (g)b1;
        layoutinflater = layoutinflater.inflate(((g) (b1)).e, null);
        if (((g) (b1)).e == 0x7f030208)
        {
            ((ImageView)layoutinflater.findViewById(0x7f0c08e4)).setImageBitmap((Bitmap)b.second);
        }
        return layoutinflater;
    }

    protected Animation a(boolean flag)
    {
        AnimationSet animationset = new AnimationSet(true);
        AlphaAnimation alphaanimation = new AlphaAnimation(0.5F, 1.0F);
        animationset.setDuration(e());
        animationset.setStartOffset(e());
        animationset.setInterpolator(new DecelerateInterpolator());
        animationset.addAnimation(alphaanimation);
        return animationset;
    }

    protected void a(Activity activity, LayoutInflater layoutinflater, List list)
    {
        activity = list.iterator();
        do
        {
            if (!activity.hasNext())
            {
                break;
            }
            list = (b)activity.next();
            if (((g)list).e == 0x7f030208)
            {
                if (b == null)
                {
                    a.setVisibility(4);
                } else
                if (b.first != null && ((Integer)b.first).intValue() > 0)
                {
                    a.setVisibility(0);
                    if (aa.b((Bitmap)b.second))
                    {
                        a(layoutinflater, ((b) (list)), null);
                    }
                } else
                {
                    a.setVisibility(4);
                }
            } else
            {
                a(layoutinflater, ((b) (list)), null);
            }
        } while (true);
    }

    protected void a(View view)
    {
    }

    protected int b()
    {
        return 0x7f0c0149;
    }

    protected Animation b(boolean flag)
    {
        AnimationSet animationset = new AnimationSet(true);
        AlphaAnimation alphaanimation = new AlphaAnimation(1.0F, 0.5F);
        animationset.setDuration(e());
        animationset.setInterpolator(new AccelerateInterpolator());
        animationset.addAnimation(alphaanimation);
        return animationset;
    }

    protected int c()
    {
        return 0x7f0c0148;
    }

    protected int d()
    {
        return 2000;
    }

    protected long e()
    {
        return 150L;
    }

    protected int f()
    {
        return -1;
    }

    protected int g()
    {
        return -1;
    }

    protected int h()
    {
        return -1;
    }

    public void n()
    {
        b = null;
        super.n();
    }

    protected List o()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.addAll(Arrays.asList(new g[] {
            new g(this, 0x7f030209), new g(this, 0x7f030208)
        }));
        return arraylist;
    }

    protected int p()
    {
        return 0x7f0c0148;
    }

    protected boolean s()
    {
        return true;
    }
}
