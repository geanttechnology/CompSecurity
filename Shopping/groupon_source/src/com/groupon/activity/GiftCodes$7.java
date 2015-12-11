// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Intent;
import com.groupon.models.GenericAmount;
import com.groupon.models.country.Country;
import com.groupon.models.gift.GiftCode;
import com.groupon.models.user.User;
import com.groupon.models.user.UserContainer;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.util.CurrencyFormatter;
import com.groupon.util.Function1;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            GiftCodes

class this._cls0
    implements Function1
{

    final GiftCodes this$0;

    public void execute(UserContainer usercontainer)
    {
        User user = usercontainer.user;
        boolean flag = GiftCodes.access$200(GiftCodes.this).getCurrentCountry().isJapan();
        Object obj;
        if (flag)
        {
            obj = user.gift_code.point;
        } else
        {
            obj = user.creditsAvailable;
        }
        Ln.d("CODES: new gift code success, now has %d credits", new Object[] {
            Integer.valueOf(((GenericAmount) (obj)).getAmount())
        });
        obj = getString(0x7f08004b, new Object[] {
            GiftCodes.access$400(GiftCodes.this).format(obj)
        });
        usercontainer = usercontainer.multiUsePromoCode;
        if (Strings.notEmpty(usercontainer))
        {
            obj = new Intent();
            setResult(-1, ((Intent) (obj)).putExtra("multi_use_promo_code", usercontainer));
        } else
        if (flag)
        {
            GiftCodes.access$500(GiftCodes.this, ((String) (obj)));
            usercontainer = new Intent();
            setResult(-1, usercontainer.putExtra("gift_code", user.gift_code));
        } else
        {
            GiftCodes.access$500(GiftCodes.this, ((String) (obj)));
            setResult(-1);
        }
        finish();
    }

    public volatile void execute(Object obj)
        throws Exception
    {
        execute((UserContainer)obj);
    }

    iner()
    {
        this$0 = GiftCodes.this;
        super();
    }
}
