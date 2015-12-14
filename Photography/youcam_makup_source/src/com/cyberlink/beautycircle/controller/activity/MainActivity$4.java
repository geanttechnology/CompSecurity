// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.os.AsyncTask;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.utility.AccountManager;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            MainActivity

class a extends AsyncTask
{

    final MainActivity a;

    protected transient Boolean a(Void avoid[])
    {
        boolean flag;
        if (AccountManager.b() != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            MainActivity.a(a, true);
            Globals.a();
        }
        return Boolean.valueOf(flag);
    }

    protected void a(Boolean boolean1)
    {
        if (boolean1.booleanValue())
        {
            MainActivity.b(a, false);
            MainActivity.a(a, true, false);
        } else
        if (Globals.n.booleanValue() && AccountManager.b() == null && Globals.k)
        {
            MainActivity.b(a, true);
            return;
        }
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((Boolean)obj);
    }

    (MainActivity mainactivity)
    {
        a = mainactivity;
        super();
    }
}
