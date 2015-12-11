// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.home;

import android.text.Layout;
import android.view.ViewTreeObserver;
import com.bestbuy.android.bbyobjects.BBYTextView;

// Referenced classes of package com.bestbuy.android.activities.home:
//            HomeActivity

class a
    implements android.view.r.OnGlobalLayoutListener
{

    final BBYTextView a;
    final HomeActivity b;

    public void onGlobalLayout()
    {
        a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        if (a.getLineCount() > 0)
        {
            int i = a.getLayout().getLineEnd(1);
            String s = (new StringBuilder()).append(a.getText().subSequence(0, i - 10)).append("...").toString();
            a.setText(s);
        }
    }

    r(HomeActivity homeactivity, BBYTextView bbytextview)
    {
        b = homeactivity;
        a = bbytextview;
        super();
    }
}
