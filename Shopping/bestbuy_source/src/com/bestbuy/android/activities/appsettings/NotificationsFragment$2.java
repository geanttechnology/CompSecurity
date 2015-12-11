// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.appsettings;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.widget.CompoundButton;
import com.exacttarget.etpushsdk.ETException;
import com.exacttarget.etpushsdk.ETPush;
import lq;

// Referenced classes of package com.bestbuy.android.activities.appsettings:
//            NotificationsFragment

class a
    implements android.widget.ChangeListener
{

    final NotificationsFragment a;

    public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        compoundbutton = NotificationsFragment.a(a).edit();
        if (flag)
        {
            compoundbutton.putBoolean(a.getResources().getString(0x7f08003e), true);
        } else
        {
            compoundbutton.putBoolean(a.getResources().getString(0x7f08003e), false);
            try
            {
                ETPush.pushManager().removeTag(a.getString(0x7f08016f));
            }
            catch (ETException etexception)
            {
                etexception.printStackTrace();
            }
        }
        compoundbutton.commit();
        lq.a(NotificationsFragment.b(a), null);
    }

    (NotificationsFragment notificationsfragment)
    {
        a = notificationsfragment;
        super();
    }
}
