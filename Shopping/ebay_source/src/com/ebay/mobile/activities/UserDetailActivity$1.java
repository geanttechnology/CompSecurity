// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.view.View;
import android.view.ViewTreeObserver;

// Referenced classes of package com.ebay.mobile.activities:
//            UserDetailActivity

class this._cls0
    implements android.view.obalLayoutListener
{

    final UserDetailActivity this$0;

    public void onGlobalLayout()
    {
        buttonLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        android.view.s s = scrollViewSpacer.getLayoutParams();
        s.height = buttonLayout.getHeight();
        scrollViewSpacer.setLayoutParams(s);
    }

    ener()
    {
        this$0 = UserDetailActivity.this;
        super();
    }
}
