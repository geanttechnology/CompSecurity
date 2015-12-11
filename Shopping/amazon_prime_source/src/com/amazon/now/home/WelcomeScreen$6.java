// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.home;

import java.util.Comparator;
import java.util.Locale;

// Referenced classes of package com.amazon.now.home:
//            WelcomeScreen

class val.currLocale
    implements Comparator
{

    final WelcomeScreen this$0;
    final Locale val$currLocale;

    public volatile int compare(Object obj, Object obj1)
    {
        return compare((Locale)obj, (Locale)obj1);
    }

    public int compare(Locale locale, Locale locale1)
    {
        if (locale == val$currLocale)
        {
            return -1;
        }
        if (locale1 == val$currLocale)
        {
            return 1;
        } else
        {
            return locale.getDisplayCountry().compareTo(locale1.getDisplayCountry());
        }
    }

    ()
    {
        this$0 = final_welcomescreen;
        val$currLocale = Locale.this;
        super();
    }
}
