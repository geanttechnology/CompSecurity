// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;

// Referenced classes of package com.wishabi.flipp.app:
//            bx

final class cc
    implements android.view.View.OnClickListener
{

    final String a;
    final bx b;

    cc(bx bx1, String s)
    {
        b = bx1;
        a = s;
        super();
    }

    public final void onClick(View view)
    {
        if (!bx.g(b))
        {
            bx.h(b);
            view = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("geo:0,0?q=")).append(a).toString()));
            if (view.resolveActivity(b.getActivity().getPackageManager()) != null)
            {
                b.startActivity(view);
                return;
            }
        }
    }
}
