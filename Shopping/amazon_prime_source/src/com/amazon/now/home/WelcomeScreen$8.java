// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.home;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import com.amazon.now.account.SSO;
import com.amazon.now.location.LocaleManager;
import com.amazon.now.location.Location;
import java.util.List;
import java.util.Locale;

// Referenced classes of package com.amazon.now.home:
//            WelcomeScreen

class val.currLocale
    implements android.content.OnClickListener
{

    final WelcomeScreen this$0;
    final Locale val$currLocale;
    final List val$locales;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        while (i >= val$locales.size() || val$locales.get(i) == val$currLocale) 
        {
            return;
        }
        Location.resetLocation();
        LocaleManager.getInstance().setLocale((Locale)val$locales.get(i));
        dialoginterface = new Intent(WelcomeScreen.access$000(WelcomeScreen.this), com/amazon/now/home/WelcomeScreen);
        dialoginterface.addFlags(0x14008000);
        dialoginterface.putExtra("intentKeyChangeLocation", getIntent().getBooleanExtra("intentKeyChangeLocation", false));
        boolean flag;
        if (SSO.getAccount() != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dialoginterface.putExtra("intentKeySyncCookie", flag);
        WelcomeScreen.access$000(WelcomeScreen.this).startActivity(dialoginterface);
    }

    r()
    {
        this$0 = final_welcomescreen;
        val$locales = list;
        val$currLocale = Locale.this;
        super();
    }
}
