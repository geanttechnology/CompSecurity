// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.browseproduct.plp;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

// Referenced classes of package com.bestbuy.android.activities.browseproduct.plp:
//            PLPFragment

class a
    implements android.view.stener
{

    final PLPFragment a;

    public void onClick(View view)
    {
        view = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
        a.d.startActivityForResult(view, 5000);
    }

    (PLPFragment plpfragment)
    {
        a = plpfragment;
        super();
    }
}
