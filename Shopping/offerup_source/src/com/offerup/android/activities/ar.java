// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import com.b.a.a.g;
import com.offerup.android.utils.OfferUpLocation;
import com.offerup.android.utils.an;
import com.offerup.android.utils.ap;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.offerup.android.activities:
//            ChangeLocationActivity

final class ar extends AsyncTask
{

    private Context a;
    private String b;
    private boolean c;
    private String d;
    private ChangeLocationActivity e;

    ar(ChangeLocationActivity changelocationactivity, Context context, String s, boolean flag, boolean flag1, String s1)
    {
        e = changelocationactivity;
        super();
        d = s1;
        a = context;
        b = s;
        c = true;
        if (StringUtils.isBlank(s1))
        {
            d = "Loading ...";
        }
        changelocationactivity.i();
    }

    protected final Object doInBackground(Object aobj[])
    {
        return an.a(a, ap.a, b, false, c, false);
    }

    protected final void onPostExecute(Object obj)
    {
        obj = (OfferUpLocation)obj;
        e.i();
        try
        {
            e.b(((OfferUpLocation) (obj)));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            g.a("ChangeLocationActivity", ((Exception) (obj)));
        }
    }

    protected final void onPreExecute()
    {
        e.g = ProgressDialog.show(a, "", d);
        e.g.setCancelable(true);
    }
}
