// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import android.content.Intent;
import android.support.v4.app.f;
import android.view.View;
import com.helpshift.i.e;

// Referenced classes of package com.helpshift:
//            HSQuestionFragment, HSConversation

class a
    implements android.view.
{

    final HSQuestionFragment a;

    public void onClick(View view)
    {
        view = new Intent(HSQuestionFragment.a(a), com/helpshift/HSConversation);
        view.putExtra("showInFullScreen", e.a(HSQuestionFragment.a(a)));
        view.putExtra("chatLaunchSource", "support");
        view.putExtras(HSQuestionFragment.g(a));
        view.removeExtra("isRoot");
        a.getActivity().startActivityForResult(view, 1);
    }

    (HSQuestionFragment hsquestionfragment)
    {
        a = hsquestionfragment;
        super();
    }
}
