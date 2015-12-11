// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.util;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

// Referenced classes of package co.vine.android.util:
//            ViewUtil

static final class  extends Animation
{

    final int val$initialSize;
    final android.view.ayoutParams val$params;
    final boolean val$typeWidth;
    final View val$v;

    protected void applyTransformation(float f, Transformation transformation)
    {
        if (f == 1.0F)
        {
            val$v.setVisibility(8);
            return;
        }
        if (val$typeWidth)
        {
            val$params.width = val$initialSize - (int)((float)val$initialSize * f);
        } else
        {
            val$params.height = val$initialSize - (int)((float)val$initialSize * f);
        }
        val$v.requestLayout();
    }

    public boolean willChangeBounds()
    {
        return true;
    }

    ams(View view, boolean flag, android.view.ayoutParams ayoutparams, int i)
    {
        val$v = view;
        val$typeWidth = flag;
        val$params = ayoutparams;
        val$initialSize = i;
        super();
    }
}
