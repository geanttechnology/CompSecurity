// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.widget.ImageView;
import android.widget.TextView;
import com.groupon.view.PageIndicators;

// Referenced classes of package com.groupon.fragment:
//            SnapIntroDialog

private class <init>
    implements android.support.v4.view.it>
{

    final SnapIntroDialog this$0;

    public void onPageScrollStateChanged(int i)
    {
    }

    public void onPageScrolled(int i, float f, int j)
    {
        i;
        JVM INSTR tableswitch 0 2: default 28
    //                   0 40
    //                   1 78
    //                   2 115;
           goto _L1 _L2 _L3 _L4
_L1:
        SnapIntroDialog.access$300(SnapIntroDialog.this).setActiveIndicator(i);
        return;
_L2:
        SnapIntroDialog.access$000(SnapIntroDialog.this).setVisibility(8);
        SnapIntroDialog.access$100(SnapIntroDialog.this).setVisibility(0);
        SnapIntroDialog.access$200(SnapIntroDialog.this).setVisibility(8);
        continue; /* Loop/switch isn't completed */
_L3:
        SnapIntroDialog.access$000(SnapIntroDialog.this).setVisibility(0);
        SnapIntroDialog.access$100(SnapIntroDialog.this).setVisibility(0);
        SnapIntroDialog.access$200(SnapIntroDialog.this).setVisibility(8);
        continue; /* Loop/switch isn't completed */
_L4:
        SnapIntroDialog.access$000(SnapIntroDialog.this).setVisibility(0);
        SnapIntroDialog.access$100(SnapIntroDialog.this).setVisibility(8);
        SnapIntroDialog.access$200(SnapIntroDialog.this).setVisibility(0);
        if (true) goto _L1; else goto _L5
_L5:
    }

    public void onPageSelected(int i)
    {
        SnapIntroDialog.access$402(SnapIntroDialog.this, i);
    }

    private ()
    {
        this$0 = SnapIntroDialog.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
