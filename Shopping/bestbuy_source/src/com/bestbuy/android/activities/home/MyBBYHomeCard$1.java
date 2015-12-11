// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.home;

import android.text.Layout;
import android.view.ViewTreeObserver;
import com.bestbuy.android.bbyobjects.BBYTextView;

// Referenced classes of package com.bestbuy.android.activities.home:
//            MyBBYHomeCard

class a
    implements android.view..OnGlobalLayoutListener
{

    final MyBBYHomeCard a;

    public void onGlobalLayout()
    {
        MyBBYHomeCard.a(a).getViewTreeObserver().removeGlobalOnLayoutListener(this);
        if (MyBBYHomeCard.a(a).getLineCount() > 0)
        {
            int i = MyBBYHomeCard.a(a).getLayout().getLineEnd(0);
            String s = (new StringBuilder()).append(MyBBYHomeCard.a(a).getText().subSequence(0, i - (i - 25))).append("...").toString();
            MyBBYHomeCard.a(a).setText(s);
        }
    }

    (MyBBYHomeCard mybbyhomecard)
    {
        a = mybbyhomecard;
        super();
    }
}
