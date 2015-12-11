// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import android.os.Handler;
import android.view.View;

// Referenced classes of package com.helpshift:
//            HSQuestionFragment, o

class a
    implements android.view.
{

    final HSQuestionFragment a;

    public void onClick(View view)
    {
        HSQuestionFragment.b(a, Boolean.valueOf(true));
        HSQuestionFragment.a(a, new Handler(), a.a, HSQuestionFragment.c(a), Boolean.valueOf(true));
        o.a("h", HSQuestionFragment.d(a));
        HSQuestionFragment.e(a);
        HSQuestionFragment.c(a, Boolean.valueOf(true));
        if (a.c())
        {
            HSQuestionFragment.b(a, "ticketAvoided");
        }
    }

    (HSQuestionFragment hsquestionfragment)
    {
        a = hsquestionfragment;
        super();
    }
}
