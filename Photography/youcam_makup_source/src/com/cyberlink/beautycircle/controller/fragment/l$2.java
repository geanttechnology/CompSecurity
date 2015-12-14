// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.controller.a.bc;
import com.cyberlink.beautycircle.controller.a.i;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.utility.DialogUtils;
import com.perfectcorp.a.b;
import com.perfectcorp.utility.g;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            l

class a
    implements android.view..OnClickListener
{

    final l a;

    public void onClick(View view)
    {
        view = a;
        view.t = ((l) (view)).t + 1L;
        b.a(new i("makeup_tips"));
        b.a(new bc("beauty_circle"));
        if (!g.a(Globals.n().getApplicationContext(), "com.cyberlink.youcammakeup"))
        {
            DialogUtils.a(a.getActivity());
            return;
        }
        try
        {
            Object obj = a.getResources().getString(m.bc_scheme2);
            view = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append("ybc_ymk://").append(a.getResources().getString(m.bc_host_makeup_tip)).toString()));
            view.addCategory("android.intent.category.BROWSABLE");
            obj = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append(((String) (obj))).append("://").append(a.getResources().getString(m.bc_host_main)).toString()));
            view.putExtra(a.getResources().getString(m.BACK_TARGET_INTENT), ((android.os.Parcelable) (obj)));
            a.getActivity().startActivity(view);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            DialogUtils.a(a.getActivity());
        }
    }

    (l l1)
    {
        a = l1;
        super();
    }
}
