// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.scan;

import android.view.View;
import android.view.animation.Animation;

// Referenced classes of package com.target.ui.fragment.scan:
//            ScanUpcFragment

class this._cls0
    implements android.view.animation.nListener
{

    final ScanUpcFragment this$0;

    public void onAnimationEnd(Animation animation)
    {
        b().setVisibility(0);
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
    }

    ener()
    {
        this$0 = ScanUpcFragment.this;
        super();
    }
}
