// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.support.design.widget.Snackbar;
import android.support.v4.app.t;
import android.view.View;
import com.offerup.android.tracker.a;

// Referenced classes of package com.offerup.android.g:
//            ae, an

final class am
    implements android.view.View.OnClickListener
{

    private ae a;

    am(ae ae1)
    {
        a = ae1;
        super();
    }

    public final void onClick(View view)
    {
        com.offerup.android.tracker.a.b("ou_invitemodal_copylink_click");
        ((ClipboardManager)a.getActivity().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("share_text", a.getString(0x7f0901e9)));
        a.dismiss();
        view = Snackbar.a(a.getActivity().findViewById(0x1020002), a.getString(0x7f0900f4), 0);
        view.a(android.support.v4.b.a.b(a.getContext(), 0x7f0e0114)).a(a.getString(0x7f0901f5), new an(this, view)).a();
    }
}
