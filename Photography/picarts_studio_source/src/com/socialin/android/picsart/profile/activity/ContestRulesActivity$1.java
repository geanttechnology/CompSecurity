// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.activity;

import android.app.DialogFragment;
import android.view.View;
import android.webkit.WebView;
import com.socialin.android.dialog.c;

// Referenced classes of package com.socialin.android.picsart.profile.activity:
//            ContestRulesActivity

final class a
    implements c
{

    private ContestRulesActivity a;

    public final void onViewCreated(View view, DialogFragment dialogfragment)
    {
        ((WebView)view.findViewById(0x7f10038d)).loadUrl(ContestRulesActivity.a(a));
        a.refreshDialog(view);
    }

    (ContestRulesActivity contestrulesactivity)
    {
        a = contestrulesactivity;
        super();
    }
}
