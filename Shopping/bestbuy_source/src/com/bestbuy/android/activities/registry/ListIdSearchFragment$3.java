// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.registry;

import android.content.DialogInterface;

// Referenced classes of package com.bestbuy.android.activities.registry:
//            ListIdSearchFragment

class a
    implements android.content.Listener
{

    final ListIdSearchFragment a;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
    }

    (ListIdSearchFragment listidsearchfragment)
    {
        a = listidsearchfragment;
        super();
    }
}
