// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.dialogs;

import android.database.DataSetObserver;
import android.view.View;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.dialogs:
//            ae

class a extends DataSetObserver
{

    final View a;
    final ae b;

    public void onChanged()
    {
        a.setVisibility(8);
        b.setCancelable(true);
    }

    (ae ae1, View view)
    {
        b = ae1;
        a = view;
        super();
    }
}
