// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.support.v4.view.ViewPager;
import android.view.View;

// Referenced classes of package com.groupon.fragment:
//            SnapIntroDialog

private class <init>
    implements android.view.istener
{

    final SnapIntroDialog this$0;

    public void onClick(View view)
    {
        if (SnapIntroDialog.access$400(SnapIntroDialog.this) < 2)
        {
            int _tmp = SnapIntroDialog.access$408(SnapIntroDialog.this);
        }
        SnapIntroDialog.access$1100(SnapIntroDialog.this).setCurrentItem(SnapIntroDialog.access$400(SnapIntroDialog.this), true);
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
