// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.social.activity;

import android.content.res.Resources;
import android.os.AsyncTask;
import org.json.JSONArray;

// Referenced classes of package com.socialin.android.social.activity:
//            SocialMainActivity

final class c extends AsyncTask
{

    private String a;
    private String b[];
    private int c;
    private JSONArray d;
    private SocialMainActivity e;

    public c(SocialMainActivity socialmainactivity, String s, String as[], int i, JSONArray jsonarray)
    {
        e = socialmainactivity;
        super();
        a = s;
        b = as;
        c = i;
        d = jsonarray;
    }

    protected final Object doInBackground(Object aobj[])
    {
        aobj = (String[])aobj;
        if (SocialMainActivity.c(e))
        {
            return aobj[0];
        } else
        {
            return SocialMainActivity.a(((String []) (aobj)));
        }
    }

    protected final void onPostExecute(Object obj)
    {
        obj = (String)obj;
        if (SocialMainActivity.c(e))
        {
            SocialMainActivity.a(e, ((String) (obj)), b[c], d);
            return;
        } else
        {
            SocialMainActivity.a(e, a, ((String) (obj)));
            return;
        }
    }

    protected final void onPreExecute()
    {
        if (!SocialMainActivity.c(e))
        {
            e.showFragmentProgressDialog("", e.getResources().getString(0x7f08043d), false);
        }
        super.onPreExecute();
    }
}
