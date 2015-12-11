// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.registry;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import com.bestbuy.android.base.BBYBaseFragmentActivity;

// Referenced classes of package com.bestbuy.android.activities.registry:
//            FindRegistry, RegistryAdditionalOptions

class a
    implements android.view.tener
{

    final FindRegistry a;

    public void onClick(View view)
    {
        view = new RegistryAdditionalOptions();
        Bundle bundle = new Bundle();
        bundle.putSerializable("data", FindRegistry.a(a));
        FragmentManager fragmentmanager = ((BBYBaseFragmentActivity)a.d).getSupportFragmentManager();
        view.setArguments(bundle);
        fragmentmanager.beginTransaction().replace(0x7f0c0033, view).commit();
    }

    nalOptions(FindRegistry findregistry)
    {
        a = findregistry;
        super();
    }
}
