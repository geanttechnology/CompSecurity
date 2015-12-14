// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes.ui.widgets;

import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.livemixtapes.utils.Utility;

// Referenced classes of package com.livemixtapes.ui.widgets:
//            SearchView

class this._cls0 extends Animation
{

    final SearchView this$0;

    protected void applyTransformation(float f, Transformation transformation)
    {
        transformation = (android.widget.t.LayoutParams)SearchView.access$0(SearchView.this).getLayoutParams();
        float f1 = Utility.dpToPixel(SearchView.access$8(SearchView.this), 50F * f);
        transformation.rightMargin = (int)f1;
        SearchView.access$0(SearchView.this).setLayoutParams(transformation);
        int i = (int)((float)(widthPanel - widthHint) - f1 - 20F);
        transformation = (android.widget.t.LayoutParams)SearchView.access$1(SearchView.this).getLayoutParams();
        transformation.width = (int)((float)widthHint + (float)i * f);
        SearchView.access$1(SearchView.this).setLayoutParams(transformation);
    }

    s()
    {
        this$0 = SearchView.this;
        super();
    }
}
