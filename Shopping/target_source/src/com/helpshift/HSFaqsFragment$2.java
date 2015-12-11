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
//            HSFaqsFragment, HSConversation

class a
    implements android.view.ner
{

    final HSFaqsFragment a;

    public void onClick(View view)
    {
        HSFaqsFragment.c(a);
        view = new Intent(HSFaqsFragment.d(a), com/helpshift/HSConversation);
        view.putExtra("message", com.helpshift.HSFaqsFragment.e(a));
        com.helpshift.HSFaqsFragment.b(a).a(HSFaqsFragment.a(a));
        view.putExtra("showInFullScreen", e.a(HSFaqsFragment.d(a)));
        view.putExtra("showConvOnReportIssue", com.helpshift.HSFaqsFragment.f(a).getBoolean("showConvOnReportIssue"));
        view.putExtra("chatLaunchSource", "support");
        view.putExtra("decomp", HSFaqsFragment.g(a));
        a.getActivity().startActivityForResult(view, 1);
    }

    er(HSFaqsFragment hsfaqsfragment)
    {
        a = hsfaqsfragment;
        super();
    }
}
