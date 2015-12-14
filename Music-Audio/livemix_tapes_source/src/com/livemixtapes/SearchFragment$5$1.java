// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.RelativeLayout;
import com.livemixtapes.utils.Utility;

// Referenced classes of package com.livemixtapes:
//            SearchFragment

class it> extends Animation
{

    final outParams this$1;
    private final boolean val$expand;

    protected void applyTransformation(float f, Transformation transformation)
    {
        transformation = (android.widget.Params)layoutHeader.getLayoutParams();
        if (val$expand)
        {
            f = Utility.dpToPixel(activity, 50F - 50F * f);
        } else
        {
            f = Utility.dpToPixel(activity, 50F * f);
        }
        transformation.height = (int)f;
        layoutHeader.setLayoutParams(transformation);
    }

    is._cls0()
    {
        this$1 = final__pcls0;
        val$expand = Z.this;
        super();
    }

    // Unreferenced inner class com/livemixtapes/SearchFragment$5

/* anonymous class */
    class SearchFragment._cls5
        implements com.livemixtapes.ui.widgets.SearchView.ExpandListener
    {

        final SearchFragment this$0;

        public void onAfterExpand(boolean flag)
        {
        }

        public void onBeforeExpand(boolean flag)
        {
            SearchFragment._cls5._cls1 _lcls1 = flag. new SearchFragment._cls5._cls1();
            _lcls1.setDuration(300L);
            layoutHeader.startAnimation(_lcls1);
        }


            
            {
                this$0 = SearchFragment.this;
                super();
            }
    }

}
