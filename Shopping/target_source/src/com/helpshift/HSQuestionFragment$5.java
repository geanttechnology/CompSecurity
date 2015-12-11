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
        HSQuestionFragment.d(a, Boolean.valueOf(true));
        HSQuestionFragment.a(a, new Handler(), a.a, HSQuestionFragment.c(a), Boolean.valueOf(false));
        o.a("u", HSQuestionFragment.d(a));
        HSQuestionFragment.f(a);
        HSQuestionFragment.c(a, Boolean.valueOf(false));
    }

    (HSQuestionFragment hsquestionfragment)
    {
        a = hsquestionfragment;
        super();
    }
}
