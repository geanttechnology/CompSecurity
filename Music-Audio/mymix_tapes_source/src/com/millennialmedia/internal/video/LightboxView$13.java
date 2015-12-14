// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.video;

import android.graphics.Point;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;

// Referenced classes of package com.millennialmedia.internal.video:
//            LightboxView, MMVideoView

class val.displaySize extends Animation
{

    int heightDelta;
    int originalHeight;
    final LightboxView this$0;
    final Point val$displaySize;

    protected void applyTransformation(float f, Transformation transformation)
    {
label0:
        {
            int i1 = 0;
            float f1;
            int i;
            int j;
            int k;
            int l;
            int j1;
            int k1;
            if (f == 1.0F)
            {
                i = val$displaySize.y;
            } else
            {
                i = (int)((float)originalHeight + (float)heightDelta * f);
            }
            f1 = (float)(i - LightboxView.access$1100(LightboxView.this)) / (float)(val$displaySize.y - LightboxView.access$1100(LightboxView.this));
            if (f == 1.0F)
            {
                j = val$displaySize.x;
            } else
            {
                j = (int)((float)LightboxView.access$1200(LightboxView.this) + (float)(val$displaySize.x - LightboxView.access$1200(LightboxView.this)) * f1);
            }
            if (f == 1.0F)
            {
                k = LightboxView.access$1300(LightboxView.this);
            } else
            {
                k = (int)((float)LightboxView.access$1300(LightboxView.this) * f1);
            }
            if (f == 1.0F)
            {
                j1 = 0;
            } else
            {
                j1 = LightboxView.access$1400(LightboxView.this) - (int)((float)LightboxView.access$1400(LightboxView.this) * f1);
            }
            if (f == 1.0F)
            {
                l = 0;
            } else
            {
                l = Math.max(0, val$displaySize.x - j - (LightboxView.access$1500(LightboxView.this) - (int)((float)LightboxView.access$1500(LightboxView.this) * f1)));
            }
            if (f != 1.0F)
            {
                i1 = Math.max(0, val$displaySize.y - i - (LightboxView.access$1600(LightboxView.this) - (int)((float)LightboxView.access$1600(LightboxView.this) * f1)));
            }
            if (j < val$displaySize.x && i < val$displaySize.y && l > 0)
            {
                k1 = i;
                i = i1;
                if (i1 > 0)
                {
                    break label0;
                }
            }
            j = val$displaySize.x;
            k1 = val$displaySize.y;
            j1 = 0;
            k = LightboxView.access$1300(LightboxView.this);
            i = 0;
            l = 0;
        }
        ((android.widget.ayoutParams)LightboxView.access$1700(LightboxView.this).getLayoutParams()).topMargin = j1;
        LightboxView.access$1800(LightboxView.this, k1);
        ((android.widget.ayoutParams)LightboxView.access$300(LightboxView.this).getLayoutParams()).topMargin = k;
        LightboxView.access$300(LightboxView.this).getLayoutParams().width = j;
        setTranslationY(i);
        LightboxView.access$300(LightboxView.this).setTranslationX(l);
        requestLayout();
    }

    public void initialize(int i, int j, int k, int l)
    {
        originalHeight = j;
        heightDelta = l - j;
    }

    public boolean willChangeBounds()
    {
        return true;
    }

    ()
    {
        this$0 = final_lightboxview;
        val$displaySize = Point.this;
        super();
    }
}
