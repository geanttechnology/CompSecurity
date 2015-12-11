// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.registry;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.widget.EditText;
import android.widget.Spinner;
import com.bestbuy.android.api.lib.models.registry.Recipient;
import com.bestbuy.android.api.lib.models.registry.RegistryWishList;
import com.bestbuy.android.api.lib.models.registry.WeddingRegistryData;
import com.bestbuy.android.bbyobjects.BBYTextView;
import jq;
import nb;

// Referenced classes of package com.bestbuy.android.activities.registry:
//            WeddingRegistrySettings

class a
    implements android.content.tener
{

    final WeddingRegistrySettings a;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        String s3 = WeddingRegistrySettings.b(a).getText().toString();
        String s4 = WeddingRegistrySettings.c(a).getText().toString();
        String s5 = WeddingRegistrySettings.d(a).getText().toString();
        String s1 = WeddingRegistrySettings.e(a).getText().toString();
        String s2 = WeddingRegistrySettings.f(a).getText().toString();
        String s = WeddingRegistrySettings.g(a).getSelectedItem().toString();
        dialoginterface = s;
        if (s.length() > 0)
        {
            dialoginterface = s.substring(0, 2);
        }
        WeddingRegistrySettings.h(a).setEventDate(s3);
        WeddingRegistrySettings.h(a).setRegistryName(s4);
        WeddingRegistrySettings.h(a).setAddDescription(s5);
        s = s1;
        if (s1 != null)
        {
            String as[] = s1.split(", ");
            s = s1;
            if (as.length > 1)
            {
                s = as[0];
            }
        }
        WeddingRegistrySettings.h(a).setEventLocation(s);
        WeddingRegistrySettings.h(a).setEventCity(s2);
        WeddingRegistrySettings.h(a).setEventState(dialoginterface);
        WeddingRegistrySettings.a(a, WeddingRegistrySettings.i(a).getUuid());
        if (WeddingRegistrySettings.j(a) == null || WeddingRegistrySettings.j(a).isEmpty())
        {
            dialoginterface = a.d.getSharedPreferences("sharedPrefs", 0);
            WeddingRegistrySettings.a(a, dialoginterface.getString("LIST_UUID", ""));
        }
        WeddingRegistrySettings.h(a).setUuid(WeddingRegistrySettings.j(a));
        WeddingRegistrySettings.h(a).setListType("weddingregistrylists");
        if (WeddingRegistrySettings.k(a).getText().toString().contains("BestBuy.com, Best Buy Stores"))
        {
            dialoginterface = "public";
        } else
        {
            dialoginterface = "private";
        }
        WeddingRegistrySettings.h(a).setPrivacySetting(dialoginterface);
        if (!WeddingRegistrySettings.k(a).getText().toString().equals("BestBuy.com, Best Buy Stores, TheKnot.com")) goto _L2; else goto _L1
_L1:
        WeddingRegistrySettings.h(a).setTheKnot(true);
        WeddingRegistrySettings.h(a).setMyregistry(false);
_L4:
        if (a.a != null)
        {
            WeddingRegistrySettings.h(a).setFirstName(a.a.getFirstName());
            WeddingRegistrySettings.h(a).setLastName(a.a.getLastName());
        }
        if (WeddingRegistrySettings.i(a) != null)
        {
            WeddingRegistrySettings.h(a).setCoregistrantFirstName(WeddingRegistrySettings.i(a).getCoRegistrantFirstName());
            WeddingRegistrySettings.h(a).setCoregistrantLastName(WeddingRegistrySettings.i(a).getCoRegistrantLastName());
        }
        (new jq(a.d, a, WeddingRegistrySettings.l(a), WeddingRegistrySettings.h(a))).executeOnExecutor(nb.g, new Void[0]);
        return;
_L2:
        if (WeddingRegistrySettings.k(a).getText().toString().equals("BestBuy.com, Best Buy Stores, MyRegistry.com"))
        {
            WeddingRegistrySettings.h(a).setTheKnot(false);
            WeddingRegistrySettings.h(a).setMyregistry(true);
        } else
        if (WeddingRegistrySettings.k(a).getText().toString().equals("BestBuy.com, Best Buy Stores, TheKnot.com, MyRegistry.com"))
        {
            WeddingRegistrySettings.h(a).setTheKnot(true);
            WeddingRegistrySettings.h(a).setMyregistry(true);
        } else
        if (WeddingRegistrySettings.k(a).getText().toString().equals("BestBuy.com, Best Buy Stores"))
        {
            WeddingRegistrySettings.h(a).setTheKnot(false);
            WeddingRegistrySettings.h(a).setMyregistry(false);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    (WeddingRegistrySettings weddingregistrysettings)
    {
        a = weddingregistrysettings;
        super();
    }
}
