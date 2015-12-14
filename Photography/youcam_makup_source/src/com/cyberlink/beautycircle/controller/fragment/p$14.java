// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import android.app.Activity;
import android.net.Uri;
import android.view.View;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.MeADPager;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            p

class a
    implements android.view.OnClickListener
{

    final p a;

    public void onClick(View view)
    {
        view = (MeADPager)view.getTag();
        if (view != null)
        {
            if (((MeADPager) (view)).redirectUrl != null && !((MeADPager) (view)).redirectUrl.toString().isEmpty())
            {
                c.a(a.getActivity(), ((MeADPager) (view)).eventLink.toString(), 2);
                return;
            }
            if (((MeADPager) (view)).id != null)
            {
                Object obj = a.getActivity();
                if (obj != null)
                {
                    String s = ((Activity) (obj)).getString(m.bc_appscheme);
                    obj = ((Activity) (obj)).getString(m.bc_host_free_sample);
                    view = (new StringBuilder()).append(s).append("://").append(((String) (obj))).append("/").append(((MeADPager) (view)).id).toString();
                    try
                    {
                        view = Uri.parse(view);
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view)
                    {
                        return;
                    }
                    c.a(a.getActivity(), view);
                    return;
                }
            }
        }
    }

    _cls9(p p1)
    {
        a = p1;
        super();
    }
}
