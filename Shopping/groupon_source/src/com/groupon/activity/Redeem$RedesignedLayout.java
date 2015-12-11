// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.os.Bundle;
import com.groupon.models.country.Country;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.util.ExpirationFormat;
import java.util.Date;

// Referenced classes of package com.groupon.activity:
//            Redeem

public class this._cls0 extends this._cls0
{

    final Redeem this$0;

    public String getExpirationString(Date date, String s, Integer integer)
    {
        return Redeem.access$1700(Redeem.this).format(date, s, integer, null);
    }

    public String getGrouponString(String s)
    {
        return s;
    }

    public int getInstructionsAndHelpStringResource()
    {
        return 0x7f080290;
    }

    public String getRefNumberString(String s)
    {
        return s;
    }

    public String getSecurityCodeString(String s)
    {
        return s;
    }

    public void onClick()
    {
        Redeem.access$700(Redeem.this);
    }

    public void onCreate(Bundle bundle)
    {
        if (Redeem.access$500(Redeem.this).getCurrentCountry().isUSACompatible())
        {
            setContentView(0x7f0301d8);
            return;
        } else
        {
            setContentView(0x7f0301d9);
            return;
        }
    }

    public void refresh()
    {
    }

    public tCountryManager()
    {
        this$0 = Redeem.this;
        super(Redeem.this);
    }
}
