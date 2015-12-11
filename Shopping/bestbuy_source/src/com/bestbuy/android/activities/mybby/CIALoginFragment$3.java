// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.mybby;

import android.support.v4.app.FragmentActivity;
import android.view.View;

// Referenced classes of package com.bestbuy.android.activities.mybby:
//            CIALoginFragment

class a
    implements android.view.r
{

    final CIALoginFragment a;

    public void onClick(View view)
    {
        a.getActivity().finish();
        a.getActivity().overridePendingTransition(0x7f040005, 0x7f040008);
    }

    (CIALoginFragment cialoginfragment)
    {
        a = cialoginfragment;
        super();
    }
}
