// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.viewit;

import android.view.animation.Animation;
import android.widget.Button;

// Referenced classes of package com.amazon.mShop.search.viewit:
//            ViewItTutorialContentView

class this._cls0
    implements android.view.animation.View._cls11
{

    final ViewItTutorialContentView this$0;

    public void onAnimationEnd(Animation animation)
    {
        ViewItTutorialContentView.access$1000(ViewItTutorialContentView.this).setVisibility(4);
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
    }

    A()
    {
        this$0 = ViewItTutorialContentView.this;
        super();
    }
}
