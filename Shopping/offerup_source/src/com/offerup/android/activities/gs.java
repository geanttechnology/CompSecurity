// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.content.DialogInterface;

// Referenced classes of package com.offerup.android.activities:
//            SearchActivity

final class gs
    implements android.content.DialogInterface.OnClickListener
{

    private SearchActivity a;

    gs(SearchActivity searchactivity)
    {
        a = searchactivity;
        super();
    }

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
        if (SearchActivity.e(a) == 1)
        {
            SearchActivity.a(a, true);
            return;
        } else
        {
            SearchActivity.a(a, false);
            return;
        }
    }
}
