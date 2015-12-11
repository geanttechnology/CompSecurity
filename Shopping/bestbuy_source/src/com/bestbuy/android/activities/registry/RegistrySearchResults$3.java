// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.registry;

import android.content.DialogInterface;

// Referenced classes of package com.bestbuy.android.activities.registry:
//            RegistrySearchResults

class a
    implements android.content.istener
{

    final RegistrySearchResults a;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
    }

    (RegistrySearchResults registrysearchresults)
    {
        a = registrysearchresults;
        super();
    }
}
