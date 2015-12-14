// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.example.android.bitmapfun.util;

import android.app.ActionBar;

// Referenced classes of package com.example.android.bitmapfun.util:
//            ImageDetailActivity

class a
    implements android.view.ityChangeListener
{

    final ActionBar a;
    final ImageDetailActivity b;

    public void onSystemUiVisibilityChange(int i)
    {
        if ((i & 1) != 0)
        {
            a.hide();
            return;
        } else
        {
            a.show();
            return;
        }
    }

    (ImageDetailActivity imagedetailactivity, ActionBar actionbar)
    {
        b = imagedetailactivity;
        a = actionbar;
        super();
    }
}
