// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.viewit;

import android.view.View;
import android.view.animation.Transformation;
import android.view.animation.TranslateAnimation;

// Referenced classes of package com.amazon.mShop.search.viewit:
//            ViewItTutorialContentView

class this._cls0 extends TranslateAnimation
{

    final ViewItTutorialContentView this$0;

    protected void applyTransformation(float f, Transformation transformation)
    {
        super.applyTransformation(f, transformation);
        transformation = (View)getParent();
        postInvalidate();
        transformation.postInvalidate();
    }

    (int i, float f, int j, float f1, int k, float f2, 
            int l, float f3)
    {
        this$0 = ViewItTutorialContentView.this;
        super(i, f, j, f1, k, f2, l, f3);
    }
}
