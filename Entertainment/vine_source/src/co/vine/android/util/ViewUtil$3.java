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

    final android.view.ayoutParams val$params;
    final int val$targetSize;
    final boolean val$typeWidth;
    final View val$v;

    protected void applyTransformation(float f, Transformation transformation)
    {
        if (val$typeWidth)
        {
            transformation = val$params;
            int i;
            if (f == 1.0F)
            {
                i = val$targetSize;
            } else
            {
                i = (int)((float)val$targetSize * f);
            }
            transformation.width = i;
        } else
        {
            transformation = val$params;
            int j;
            if (f == 1.0F)
            {
                j = val$targetSize;
            } else
            {
                j = (int)((float)val$targetSize * f);
            }
            transformation.height = j;
        }
        val$v.requestLayout();
    }

    public boolean willChangeBounds()
    {
        return true;
    }

    ams(boolean flag, android.view.ayoutParams ayoutparams, int i, View view)
    {
        val$typeWidth = flag;
        val$params = ayoutparams;
        val$targetSize = i;
        val$v = view;
        super();
    }
}
