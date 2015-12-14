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

class val.defaultPosition extends Animation
{

    int heightDelta;
    int originalHeight;
    int originalWidth;
    final LightboxView this$0;
    final Point val$defaultPosition;
    final Point val$displaySize;
    int widthDelta;

    protected void applyTransformation(float f, Transformation transformation)
    {
        int i;
        int j;
        int k;
        int l;
        int j1;
        int k1;
label0:
        {
            float f1;
            int i1;
            if (f == 1.0F)
            {
                i = LightboxView.access$1100(LightboxView.this);
            } else
            {
                i = (int)((float)originalHeight - (float)heightDelta * f);
            }
            f1 = (float)(i - LightboxView.access$1100(LightboxView.this)) / (float)(val$displaySize.y - LightboxView.access$1100(LightboxView.this));
            if (f == 1.0F)
            {
                j = LightboxView.access$1200(LightboxView.this);
            } else
            {
                j = (int)((float)LightboxView.access$1200(LightboxView.this) + (float)widthDelta * f1);
            }
            if (f == 1.0F)
            {
                k = 0;
            } else
            {
                k = (int)((float)LightboxView.access$1300(LightboxView.this) * f1);
            }
            if (f == 1.0F)
            {
                j1 = LightboxView.access$1400(LightboxView.this);
            } else
            {
                j1 = LightboxView.access$1400(LightboxView.this) - (int)((float)LightboxView.access$1400(LightboxView.this) * f1);
            }
            if (f == 1.0F)
            {
                l = val$defaultPosition.x;
            } else
            {
                l = Math.max(0, val$displaySize.x - j - (LightboxView.access$1500(LightboxView.this) - (int)((float)LightboxView.access$1500(LightboxView.this) * f1)));
            }
            if (f == 1.0F)
            {
                i1 = val$defaultPosition.y;
            } else
            {
                i1 = Math.max(0, val$displaySize.y - i - (LightboxView.access$1600(LightboxView.this) - (int)((float)LightboxView.access$1600(LightboxView.this) * f1)));
            }
            if (j > LightboxView.access$1200(LightboxView.this) && i > LightboxView.access$1100(LightboxView.this) && l < val$defaultPosition.x)
            {
                k1 = i;
                i = i1;
                if (i1 < val$defaultPosition.y)
                {
                    break label0;
                }
            }
            k = 0;
            j1 = LightboxView.access$1400(LightboxView.this);
            j = LightboxView.access$1200(LightboxView.this);
            k1 = LightboxView.access$1100(LightboxView.this);
            i = val$defaultPosition.y;
            l = val$defaultPosition.x;
            LightboxView.access$1700(LightboxView.this).setVisibility(8);
        }
        if (f == 1.0F)
        {
            setTranslationX(val$defaultPosition.x);
            setTranslationY(val$defaultPosition.y);
            getLayoutParams().width = LightboxView.access$1200(LightboxView.this);
            ((android.widget.ayoutParams)LightboxView.access$1700(LightboxView.this).getLayoutParams()).topMargin = LightboxView.access$1400(LightboxView.this);
            LightboxView.access$1800(LightboxView.this, k1);
            ((android.widget.ayoutParams)LightboxView.access$300(LightboxView.this).getLayoutParams()).topMargin = 0;
            LightboxView.access$300(LightboxView.this).setTranslationX(0.0F);
            LightboxView.access$300(LightboxView.this).getLayoutParams().height = -1;
            LightboxView.access$300(LightboxView.this).getLayoutParams().width = -1;
        } else
        {
            ((android.widget.ayoutParams)LightboxView.access$1700(LightboxView.this).getLayoutParams()).topMargin = j1;
            LightboxView.access$1800(LightboxView.this, k1);
            ((android.widget.ayoutParams)LightboxView.access$300(LightboxView.this).getLayoutParams()).topMargin = k;
            LightboxView.access$300(LightboxView.this).getLayoutParams().width = j;
            setTranslationY(i);
            LightboxView.access$300(LightboxView.this).setTranslationX(l);
        }
        requestLayout();
    }

    public void initialize(int i, int j, int k, int l)
    {
        originalHeight = j;
        heightDelta = j - LightboxView.access$1100(LightboxView.this);
        originalWidth = i;
        widthDelta = i - LightboxView.access$1200(LightboxView.this);
    }

    public boolean willChangeBounds()
    {
        return true;
    }

    ()
    {
        this$0 = final_lightboxview;
        val$displaySize = point;
        val$defaultPosition = Point.this;
        super();
    }
}
