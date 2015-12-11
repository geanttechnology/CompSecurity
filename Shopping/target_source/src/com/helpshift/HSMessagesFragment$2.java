// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import android.content.Intent;
import android.support.v4.app.f;
import android.view.View;
import com.helpshift.i.e;

// Referenced classes of package com.helpshift:
//            HSMessagesFragment, HSConversation, l, s

class a
    implements android.view.
{

    final HSMessagesFragment a;

    public void onClick(View view)
    {
        view = new Intent(HSMessagesFragment.g(a), com/helpshift/HSConversation);
        view.putExtra("showInFullScreen", e.a(HSMessagesFragment.g(a)));
        view.putExtra("newConversation", true);
        view.putExtras(HSMessagesFragment.p(a));
        view.removeExtra("isRoot");
        a.getActivity().startActivityForResult(view, 1);
        HSMessagesFragment.m(a).d("", HSMessagesFragment.k(a).B());
    }

    (HSMessagesFragment hsmessagesfragment)
    {
        a = hsmessagesfragment;
        super();
    }
}
