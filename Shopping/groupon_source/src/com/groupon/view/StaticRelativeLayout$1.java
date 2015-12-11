// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.view.ViewTreeObserver;

// Referenced classes of package com.groupon.view:
//            StaticRelativeLayout

class this._cls0
    implements android.view.rawListener
{

    final StaticRelativeLayout this$0;

    public boolean onPreDraw()
    {
        getViewTreeObserver().removeOnPreDrawListener(StaticRelativeLayout.access$000(StaticRelativeLayout.this));
        setYFraction(StaticRelativeLayout.access$100(StaticRelativeLayout.this));
        return true;
    }

    istener()
    {
        this$0 = StaticRelativeLayout.this;
        super();
    }
}
