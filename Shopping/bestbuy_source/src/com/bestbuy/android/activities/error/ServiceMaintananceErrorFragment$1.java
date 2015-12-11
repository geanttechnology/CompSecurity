// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.error;

import android.content.Intent;
import android.net.Uri;
import android.view.View;

// Referenced classes of package com.bestbuy.android.activities.error:
//            ServiceMaintananceErrorFragment

class a
    implements android.view.ntananceErrorFragment._cls1
{

    final ServiceMaintananceErrorFragment a;

    public void onClick(View view)
    {
        view = new Intent("android.intent.action.VIEW", Uri.parse("http://www.bestbuy.com"));
        a.startActivity(view);
    }

    (ServiceMaintananceErrorFragment servicemaintananceerrorfragment)
    {
        a = servicemaintananceerrorfragment;
        super();
    }
}
