// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.ui_stuff;

import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.util.Date;

// Referenced classes of package com.ebay.mobile.ui_stuff:
//            Util

private static class isRefreshUponEnding
{

    public final boolean isCountdownItemEnding;
    public final boolean isRefreshUponEnding;
    public Date source;
    public String useToFormatDuringCountdown;
    public WeakReference view;

    public (Date date, TextView textview, String s, boolean flag, boolean flag1)
    {
        source = date;
        view = new WeakReference(textview);
        useToFormatDuringCountdown = s;
        isCountdownItemEnding = flag;
        isRefreshUponEnding = flag1;
        if (flag && flag1)
        {
            throw new IllegalArgumentException("mutually exclusive");
        } else
        {
            return;
        }
    }
}
