// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.os.AsyncTask;
import com.cyberlink.beautycircle.utility.AccountManager;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            FreeSampleResultActivity

class a extends AsyncTask
{

    final FreeSampleResultActivity a;

    protected transient Void a(Void avoid[])
    {
        if (AccountManager.b() != null)
        {
            if (FreeSampleResultActivity.a(a) != FreeSampleResultActivity.o());
        }
        return null;
    }

    protected void a(Void void1)
    {
        FreeSampleResultActivity.b(a);
        a.l();
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((Void)obj);
    }

    (FreeSampleResultActivity freesampleresultactivity)
    {
        a = freesampleresultactivity;
        super();
    }
}
