// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.registry;

import android.content.DialogInterface;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.bestbuy.android.base.BBYBaseFragmentActivity;

// Referenced classes of package com.bestbuy.android.activities.registry:
//            RegistryAndGiftsFragment, EmptyWeddingRegistryContainer

class a
    implements android.content.ener
{

    final RegistryAndGiftsFragment a;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
        dialoginterface = new EmptyWeddingRegistryContainer(false);
        FragmentTransaction fragmenttransaction = ((BBYBaseFragmentActivity)a.d).getSupportFragmentManager().beginTransaction();
        fragmenttransaction.add(0x7f0c0033, dialoginterface, "EmptyWeddingRegistryContainer");
        fragmenttransaction.addToBackStack(null);
        fragmenttransaction.commit();
    }

    er(RegistryAndGiftsFragment registryandgiftsfragment)
    {
        a = registryandgiftsfragment;
        super();
    }
}
