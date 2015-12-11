// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.view.View;

// Referenced classes of package com.wishabi.flipp.app:
//            cn, cs

final class cr
    implements android.view.View.OnClickListener
{

    final cn a;

    cr(cn cn1)
    {
        a = cn1;
        super();
    }

    public final void onClick(View view)
    {
        view = a.getActivity();
        if (view == null)
        {
            return;
        } else
        {
            (new cs(this, view)).a();
            return;
        }
    }
}
