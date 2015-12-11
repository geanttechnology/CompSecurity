// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import co.vine.android.util.Util;
import java.util.Locale;

// Referenced classes of package co.vine.android:
//            VineApplication

class val.locale
    implements Runnable
{

    final VineApplication this$0;
    final Locale val$locale;

    public void run()
    {
        Util.forceCustomLocale(VineApplication.access$000(), val$locale, true);
    }

    ()
    {
        this$0 = final_vineapplication;
        val$locale = Locale.this;
        super();
    }
}
