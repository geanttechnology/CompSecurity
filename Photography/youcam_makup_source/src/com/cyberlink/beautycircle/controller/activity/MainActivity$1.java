// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.os.AsyncTask;
import android.os.Bundle;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.controller.a.a;
import com.cyberlink.beautycircle.controller.a.aq;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.perfectcorp.a.b;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            MainActivity

class a extends AsyncTask
{

    final Bundle a;
    final MainActivity b;

    protected transient Integer a(Void avoid[])
    {
label0:
        {
            avoid = Integer.valueOf(0);
            if (Globals.n.booleanValue())
            {
                if (AccountManager.b() != null || !Globals.k)
                {
                    break label0;
                }
                if (Globals.k && Globals.l)
                {
                    com.perfectcorp.a.b.a(new a("BC_welcome_page_0819"));
                }
                avoid = Integer.valueOf(2);
                aq.c = "welcome_page";
            }
            return avoid;
        }
        com.cyberlink.beautycircle.controller.activity.MainActivity.a(b, true);
        Globals.a();
        return Integer.valueOf(1);
    }

    protected void a(Integer integer)
    {
        if (integer.intValue() == 2)
        {
            com.cyberlink.beautycircle.controller.activity.MainActivity.b(b, true);
        } else
        if (integer.intValue() == 1)
        {
            com.cyberlink.beautycircle.controller.activity.MainActivity.a(b);
            com.cyberlink.beautycircle.controller.activity.MainActivity.a(b, true, false);
        } else
        {
            com.cyberlink.beautycircle.controller.activity.MainActivity.a(b);
        }
        com.cyberlink.beautycircle.controller.activity.MainActivity.a(b, a);
        com.cyberlink.beautycircle.controller.activity.MainActivity.b(b);
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((Integer)obj);
    }

    (MainActivity mainactivity, Bundle bundle)
    {
        b = mainactivity;
        a = bundle;
        super();
    }
}
