// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import android.net.Uri;
import android.view.View;
import com.cyberlink.beautycircle.c;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            k

class a
    implements android.view..OnClickListener
{

    final k a;

    public void onClick(View view)
    {
        c.a(a.getActivity(), Uri.parse("https://dl.dropboxusercontent.com/u/19164442/BC_DeepLink.html"));
    }

    (k k1)
    {
        a = k1;
        super();
    }
}
