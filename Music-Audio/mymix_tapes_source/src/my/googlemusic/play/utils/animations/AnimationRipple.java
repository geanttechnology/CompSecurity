// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.utils.animations;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.nineoldandroids.animation.ArgbEvaluator;
import com.nineoldandroids.animation.ValueAnimator;

public class AnimationRipple
{

    public AnimationRipple()
    {
    }

    public static void animationFadeIn(View view, View view1, TextView textview, Context context)
    {
        view.postDelayed(new _cls3(view, context, view1, textview), 0L);
    }

    public static void animationFadeOut(View view, View view1, TextView textview, Context context)
    {
        view.postDelayed(new _cls4(view, context, view1, textview), 0L);
    }

    public static void animationRippleIn(View view, ImageView imageview, TextView textview, Context context)
    {
        view.setBackgroundColor(context.getResources().getColor(0x7f0c001a));
        imageview.setImageResource(0x7f020160);
        imageview.postDelayed(new _cls1(imageview, view, context, textview), 0L);
    }

    public static void animationRippleOut(View view, ImageView imageview, TextView textview, Context context)
    {
        imageview.postDelayed(new _cls2(view, context, imageview, textview), 0L);
    }

    public static void initFadeState(TextView textview, View view, boolean flag, Context context)
    {
        int j = 0x7f0c0020;
        Resources resources = context.getResources();
        int i;
        if (flag)
        {
            i = 0x7f0c001a;
        } else
        {
            i = 0x7f0c0020;
        }
        textview.setTextColor(resources.getColor(i));
        textview = context.getResources();
        if (flag)
        {
            i = j;
        } else
        {
            i = 0x7f0c001a;
        }
        view.setBackgroundColor(textview.getColor(i));
    }

    public static void setTextColorTransition(TextView textview, int i, int j)
    {
        ValueAnimator valueanimator = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[] {
            Integer.valueOf(i), Integer.valueOf(j)
        });
        valueanimator.addUpdateListener(new _cls5(textview));
        valueanimator.start();
    }

    /* member class not found */
    class _cls3 {}


    /* member class not found */
    class _cls4 {}


    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class _cls5 {}

}
