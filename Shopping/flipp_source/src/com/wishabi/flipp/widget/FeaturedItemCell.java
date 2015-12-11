// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;
import com.wishabi.flipp.content.h;

// Referenced classes of package com.wishabi.flipp.widget:
//            SlidingFrameLayout, WebImageView

public class FeaturedItemCell extends SlidingFrameLayout
{

    Animator a;
    private final TextView b;
    private final WebImageView c;
    private final WebImageView d;
    private final TextView e;
    private final TextView f;
    private h g;

    public FeaturedItemCell(Context context)
    {
        this(context, null);
    }

    public FeaturedItemCell(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public FeaturedItemCell(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        setBackgroundResource(0x7f0200e8);
        View.inflate(context, 0x7f030026, this);
        b = (TextView)findViewById(0x7f0b00a6);
        b.setSingleLine();
        c = (WebImageView)findViewById(0x7f0b00a7);
        d = (WebImageView)findViewById(0x7f0b00aa);
        e = (TextView)findViewById(0x7f0b00a9);
        e.setSingleLine();
        f = (TextView)findViewById(0x7f0b00a8);
        f.setSingleLine();
        a = getSlideInAnimation();
    }

    private Animator getSlideInAnimation()
    {
        ObjectAnimator objectanimator = ObjectAnimator.ofFloat(this, "xFraction", new float[] {
            1.0F, 0.0F
        });
        ObjectAnimator objectanimator1 = ObjectAnimator.ofFloat(this, "alpha", new float[] {
            0.0F, 1.0F
        });
        AnimatorSet animatorset = new AnimatorSet();
        animatorset.playTogether(new Animator[] {
            objectanimator1, objectanimator
        });
        animatorset.setDuration(333L);
        animatorset.setInterpolator(new DecelerateInterpolator());
        return animatorset;
    }

    public final void a()
    {
        a.cancel();
        setVisibility(8);
    }

    public h getData()
    {
        return g;
    }

    public void setData(h h1)
    {
        if (g != h1)
        {
            g = h1;
            if (g != null)
            {
                if (TextUtils.isEmpty(g.h))
                {
                    c.setImageUrl(null);
                    c.setVisibility(8);
                    if (TextUtils.isEmpty(g.g))
                    {
                        b.setVisibility(8);
                    } else
                    {
                        b.setText(g.g);
                        b.setVisibility(0);
                    }
                } else
                {
                    c.setImageUrl(g.h);
                    c.setVisibility(0);
                    b.setVisibility(8);
                }
                d.setImageUrl(g.c);
                if (TextUtils.isEmpty(g.e))
                {
                    e.setVisibility(8);
                } else
                {
                    e.setText(g.e);
                    e.setVisibility(0);
                }
                if (TextUtils.isEmpty(g.d))
                {
                    f.setVisibility(8);
                    return;
                } else
                {
                    f.setText(g.d);
                    f.setVisibility(0);
                    return;
                }
            }
        }
    }
}
