// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle;

import android.content.SharedPreferences;
import com.cyberlink.beautycircle.controller.a.t;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.perfectcorp.a.b;
import com.perfectcorp.utility.j;
import java.text.DateFormat;
import java.util.Date;
import java.util.TimeZone;

// Referenced classes of package com.cyberlink.beautycircle:
//            BaseActivity, Globals

final class Manager extends j
{

    protected volatile Object a(Object obj)
    {
        return a((Void)obj);
    }

    protected Void a(Void void1)
    {
        void1 = AccountManager.c();
        if (void1 != null)
        {
            SharedPreferences sharedpreferences = Globals.D();
            String s = sharedpreferences.getString("BC_MemberInfo", null);
            Object obj = DateFormat.getDateInstance();
            ((DateFormat) (obj)).setTimeZone(TimeZone.getTimeZone("GMT-0700"));
            obj = ((DateFormat) (obj)).format(new Date());
            if (!((String) (obj)).equals(s))
            {
                sharedpreferences.edit().putString("BC_MemberInfo", ((String) (obj))).apply();
                b.a(new t(void1));
            }
        }
        return null;
    }

    Manager()
    {
    }
}
