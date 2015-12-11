// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.registry;

import android.view.View;
import android.widget.AdapterView;
import com.bestbuy.android.api.lib.models.registry.RegistryWishList;
import fr;
import java.util.ArrayList;
import jd;
import nb;

// Referenced classes of package com.bestbuy.android.activities.registry:
//            RegistrySearchResults

class a
    implements android.widget.istener
{

    final RegistrySearchResults a;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        if (i < RegistrySearchResults.a(a).size())
        {
            RegistrySearchResults.a(a, (RegistryWishList)RegistrySearchResults.a(a).get(i));
            (new jd(a.d, a, fr.d(), RegistrySearchResults.b(a).getUuid(), RegistrySearchResults.b(a).getType(), false, null)).executeOnExecutor(nb.g, new Void[0]);
        }
    }

    (RegistrySearchResults registrysearchresults)
    {
        a = registrysearchresults;
        super();
    }
}
