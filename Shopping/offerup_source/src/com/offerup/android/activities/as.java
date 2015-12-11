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

final class as extends AsyncTask
{

    private Context a;
    private String b;
    private boolean c;
    private String d;
    private boolean e;
    private ChangeLocationActivity f;

    as(ChangeLocationActivity changelocationactivity, Context context, String s, boolean flag, boolean flag1, String s1, boolean flag2)
    {
        f = changelocationactivity;
        super();
        d = s1;
        a = context;
        b = s;
        c = true;
        e = true;
        if (StringUtils.isBlank(s1))
        {
            d = "Loading ...";
        }
        changelocationactivity.i();
    }

    protected final Object doInBackground(Object aobj[])
    {
        aobj = new OfferUpLocation(com.offerup.android.utils.as.a(f, b), c);
        an.a(ap.a, null);
        an.a(ap.a, null);
        an.a(ap.a, ((OfferUpLocation) (aobj)));
        return ((Object) (aobj));
    }

    protected final void onPostExecute(Object obj)
    {
        obj = (OfferUpLocation)obj;
        f.i();
        if (e)
        {
            f.a = ((OfferUpLocation) (obj));
            f.a();
            return;
        }
        try
        {
            f.b(((OfferUpLocation) (obj)));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            g.a("ChangeLocationActivity", ((Exception) (obj)));
        }
        return;
    }

    protected final void onPreExecute()
    {
        f.g = ProgressDialog.show(a, "", d);
        f.g.setCancelable(true);
    }
}
