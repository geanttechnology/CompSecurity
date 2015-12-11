// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.registry;

import android.content.DialogInterface;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import com.bestbuy.android.api.lib.models.registry.Recipient;
import com.bestbuy.android.api.lib.models.registry.RegistryWishList;
import com.bestbuy.android.api.lib.models.registry.WishListReqData;
import jr;
import nb;

// Referenced classes of package com.bestbuy.android.activities.registry:
//            WishListSettingsFragment

class a
    implements android.content.ener
{

    final WishListSettingsFragment a;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        String s1 = WishListSettingsFragment.b(a).getType();
        String s2 = WishListSettingsFragment.f(a).getText().toString();
        String s;
        String as[];
        String s3;
        String s4;
        String s5;
        String s6;
        String s7;
        if (WishListSettingsFragment.g(a).getText().toString().equals("Public"))
        {
            dialoginterface = "public";
        } else
        if (WishListSettingsFragment.g(a).getText().toString().equals("Private"))
        {
            dialoginterface = "private";
        } else
        {
            dialoginterface = "";
        }
        s6 = WishListSettingsFragment.h(a).getText().toString();
        s7 = WishListSettingsFragment.i(a).getText().toString();
        s = WishListSettingsFragment.j(a).getText().toString();
        s3 = WishListSettingsFragment.k(a).getText().toString();
        s4 = WishListSettingsFragment.l(a).getSelectedItem().toString();
        s5 = WishListSettingsFragment.e(a).getText().toString();
        if (WishListSettingsFragment.c(a) == null) goto _L2; else goto _L1
_L1:
        WishListSettingsFragment.c(a).setListType(s1);
        WishListSettingsFragment.c(a).setRegistryName(s2);
        WishListSettingsFragment.c(a).setPrivacySetting(dialoginterface);
        WishListSettingsFragment.c(a).setShippingAddress(s6);
        WishListSettingsFragment.c(a).setAddDescription(s7);
        dialoginterface = s;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_241;
        }
        as = s.split(",");
        dialoginterface = s;
        if (as.length >= 3)
        {
            dialoginterface = as[0];
        }
        if (!s4.contains("Select")) goto _L4; else goto _L3
_L3:
        WishListSettingsFragment.c(a).setEventState("");
_L5:
        WishListSettingsFragment.c(a).setEventLocation(dialoginterface);
        WishListSettingsFragment.c(a).setEventCity(s3);
        WishListSettingsFragment.c(a).setEventDate(s5);
        WishListSettingsFragment.c(a).setUuid(WishListSettingsFragment.b(a).getUuid());
        WishListSettingsFragment.c(a).setRecepient(a.c);
        if (a.c != null)
        {
            WishListSettingsFragment.c(a).setFirstName(a.c.getFirstName());
            WishListSettingsFragment.c(a).setLastName(a.c.getLastName());
        }
        (new jr(a.d, a, WishListSettingsFragment.m(a), WishListSettingsFragment.c(a))).executeOnExecutor(nb.g, new Void[0]);
_L2:
        WishListSettingsFragment.b(a).setRecipient(a.c);
        return;
_L4:
        WishListSettingsFragment.c(a).setEventState(s4);
          goto _L5
        dialoginterface;
        dialoginterface.printStackTrace();
          goto _L2
    }

    (WishListSettingsFragment wishlistsettingsfragment)
    {
        a = wishlistsettingsfragment;
        super();
    }
}
