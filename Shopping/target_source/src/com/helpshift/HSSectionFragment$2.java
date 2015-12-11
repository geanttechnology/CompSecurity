// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.f;
import android.view.View;
import com.helpshift.app.b;
import com.helpshift.i.e;

// Referenced classes of package com.helpshift:
//            HSSectionFragment, HSConversation, h

class a
    implements android.view.
{

    final HSSectionFragment a;

    public void onClick(View view)
    {
        HSSectionFragment.c(a);
        view = new Intent(HSSectionFragment.d(a), com/helpshift/HSConversation);
        view.putExtra("message", com.helpshift.HSSectionFragment.e(a));
        com.helpshift.HSSectionFragment.b(a).a(HSSectionFragment.a(a));
        view.putExtra("showInFullScreen", e.a(HSSectionFragment.d(a)));
        view.putExtra("showConvOnReportIssue", HSSectionFragment.d(a).getIntent().getExtras().getBoolean("showConvOnReportIssue"));
        view.putExtra("chatLaunchSource", "support");
        a.getActivity().startActivityForResult(view, 1);
    }

    (HSSectionFragment hssectionfragment)
    {
        a = hssectionfragment;
        super();
    }
}
