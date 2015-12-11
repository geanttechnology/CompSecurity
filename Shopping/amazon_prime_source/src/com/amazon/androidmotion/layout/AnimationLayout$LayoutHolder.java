// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.androidmotion.layout;

import android.widget.RelativeLayout;

// Referenced classes of package com.amazon.androidmotion.layout:
//            AnimationLayout

private class <init>
{

    private RelativeLayout mLayout;
    final AnimationLayout this$0;

    public RelativeLayout getLayout()
    {
        if (mLayout == null)
        {
            throw new IllegalStateException("no layout has been set on this AnimationLayout");
        } else
        {
            return mLayout;
        }
    }

    public void setLayout(RelativeLayout relativelayout)
    {
        mLayout = relativelayout;
    }

    private ()
    {
        this$0 = AnimationLayout.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
