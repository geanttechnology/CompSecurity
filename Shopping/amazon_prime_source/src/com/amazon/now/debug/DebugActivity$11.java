// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.debug;

import android.content.DialogInterface;
import android.content.Intent;
import com.amazon.now.home.WelcomeScreen;
import com.amazon.now.location.LocaleManager;
import com.amazon.now.location.Location;
import java.util.Locale;

// Referenced classes of package com.amazon.now.debug:
//            DebugActivity

class val.locales
    implements android.content.nClickListener
{

    final DebugActivity this$0;
    final Locale val$locales[];

    public void onClick(DialogInterface dialoginterface, int i)
    {
        while (i >= val$locales.length || val$locales[i] == LocaleManager.getInstance().getLocale()) 
        {
            return;
        }
        Location.resetLocation();
        LocaleManager.getInstance().setLocale(val$locales[i]);
        dialoginterface = new Intent(DebugActivity.this, com/amazon/now/home/WelcomeScreen);
        dialoginterface.addFlags(0x14008000);
        startActivity(dialoginterface);
    }

    kListener()
    {
        this$0 = final_debugactivity;
        val$locales = _5B_Ljava.util.Locale_3B_.this;
        super();
    }
}
