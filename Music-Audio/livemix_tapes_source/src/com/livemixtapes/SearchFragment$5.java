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

class this._cls0
    implements com.livemixtapes.ui.widgets.Listener
{

    final SearchFragment this$0;

    public void onAfterExpand(boolean flag)
    {
    }

    public void onBeforeExpand(final boolean expand)
    {
        Animation animation = new Animation() {

            final SearchFragment._cls5 this$1;
            private final boolean val$expand;

            protected void applyTransformation(float f, Transformation transformation)
            {
                transformation = (android.widget.LinearLayout.LayoutParams)layoutHeader.getLayoutParams();
                if (expand)
                {
                    f = Utility.dpToPixel(activity, 50F - 50F * f);
                } else
                {
                    f = Utility.dpToPixel(activity, 50F * f);
                }
                transformation.height = (int)f;
                layoutHeader.setLayoutParams(transformation);
            }

            
            {
                this$1 = SearchFragment._cls5.this;
                expand = flag;
                super();
            }
        };
        animation.setDuration(300L);
        layoutHeader.startAnimation(animation);
    }


    init>()
    {
        this$0 = SearchFragment.this;
        super();
    }
}
