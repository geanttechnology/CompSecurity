// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.registry;

import android.content.DialogInterface;
import com.bestbuy.android.api.lib.models.registry.RegistryWishList;
import java.util.HashMap;
import jc;
import lu;
import nb;

// Referenced classes of package com.bestbuy.android.activities.registry:
//            WeddingRegistrySettings

class a
    implements android.content.tener
{

    final WeddingRegistrySettings a;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
        if (WeddingRegistrySettings.i(a) != null)
        {
            WeddingRegistrySettings.a(a, WeddingRegistrySettings.i(a).getUuid());
            (new jc(a.d, a, WeddingRegistrySettings.l(a), "weddingregistrylists", WeddingRegistrySettings.j(a))).executeOnExecutor(nb.g, new Void[0]);
            dialoginterface = new HashMap();
            dialoginterface.put("Registry List Name", WeddingRegistrySettings.i(a).getShortDescription());
            dialoginterface.put("Registry List Type", "weddingregistrylists");
            dialoginterface.put("Registry List UUID", WeddingRegistrySettings.j(a));
            lu.a(lu.at, dialoginterface);
        }
    }

    (WeddingRegistrySettings weddingregistrysettings)
    {
        a = weddingregistrysettings;
        super();
    }
}
