// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.appsettings;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.widget.CompoundButton;
import com.exacttarget.etpushsdk.ETException;
import com.exacttarget.etpushsdk.ETPush;
import java.util.ArrayList;
import java.util.Iterator;
import lq;

// Referenced classes of package com.bestbuy.android.activities.appsettings:
//            NotificationsFragment

class a
    implements android.widget.ChangeListener
{

    final NotificationsFragment a;

    public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        Object obj;
        compoundbutton = NotificationsFragment.a(a).edit();
        obj = lq.a(NotificationsFragment.b(a));
        if (!flag) goto _L2; else goto _L1
_L1:
        compoundbutton.putBoolean(a.getResources().getString(0x7f08008b), true);
_L4:
        compoundbutton.putBoolean(a.getResources().getString(0x7f08008a), flag);
        compoundbutton.commit();
        a.a(flag);
        lq.a(NotificationsFragment.b(a), null);
        return;
_L2:
        compoundbutton.putBoolean(a.getResources().getString(0x7f08008b), false);
        ETException etexception;
        ETPush.pushManager().removeTag(a.getString(0x7f080388));
        String s;
        for (obj = ((ArrayList) (obj)).iterator(); ((Iterator) (obj)).hasNext(); ETPush.pushManager().removeTag(s))
        {
            s = (String)((Iterator) (obj)).next();
        }

        try
        {
            lq.c(NotificationsFragment.b(a));
        }
        // Misplaced declaration of an exception variable
        catch (ETException etexception)
        {
            etexception.printStackTrace();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    (NotificationsFragment notificationsfragment)
    {
        a = notificationsfragment;
        super();
    }
}
