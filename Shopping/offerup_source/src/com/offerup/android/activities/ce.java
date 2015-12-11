// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.support.v4.view.ViewPager;
import android.view.View;

// Referenced classes of package com.offerup.android.activities:
//            FirstQuestionHelpActivity

final class ce
    implements android.view.View.OnClickListener
{

    private FirstQuestionHelpActivity a;

    ce(FirstQuestionHelpActivity firstquestionhelpactivity)
    {
        a = firstquestionhelpactivity;
        super();
    }

    public final void onClick(View view)
    {
        if (a.a <= 0)
        {
            view = a.b;
            FirstQuestionHelpActivity firstquestionhelpactivity = a;
            int i = firstquestionhelpactivity.a + 1;
            firstquestionhelpactivity.a = i;
            view.setCurrentItem(i);
        }
    }
}
