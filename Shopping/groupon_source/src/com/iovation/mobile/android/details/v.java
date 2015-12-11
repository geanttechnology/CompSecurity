// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.iovation.mobile.android.details;

import android.content.Context;
import android.media.Ringtone;
import android.media.RingtoneManager;
import java.util.Currency;
import java.util.Locale;
import java.util.TimeZone;

// Referenced classes of package com.iovation.mobile.android.details:
//            i, j

public class v
    implements i
{

    public v()
    {
    }

    private String a(String s)
    {
        String s1;
        if (s == null)
        {
            s1 = null;
        } else
        {
            s1 = s;
            if (s.startsWith("Default ringtone ("))
            {
                return s.substring("Default ringtone (".length(), s.length() - ")".length());
            }
        }
        return s1;
    }

    public void a(Context context, j j1)
    {
        j1.a("TZ", TimeZone.getDefault().getID());
        j1.a("LANG", Locale.getDefault().toString());
        j1.a("CURR", Currency.getInstance(Locale.getDefault()).getCurrencyCode());
        try
        {
            j1.a("ARTN", a(RingtoneManager.getRingtone(context, android.provider.Settings.System.DEFAULT_RINGTONE_URI).getTitle(context)));
        }
        catch (NullPointerException nullpointerexception1) { }
        catch (Exception exception1) { }
        try
        {
            j1.a("ANTN", a(RingtoneManager.getRingtone(context, android.provider.Settings.System.DEFAULT_NOTIFICATION_URI).getTitle(context)));
        }
        catch (NullPointerException nullpointerexception) { }
        catch (Exception exception) { }
        try
        {
            j1.a("AATN", a(RingtoneManager.getRingtone(context, android.provider.Settings.System.DEFAULT_ALARM_ALERT_URI).getTitle(context)));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
    }
}
