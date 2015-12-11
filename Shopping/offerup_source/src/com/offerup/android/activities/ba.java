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
//            ChangePostLocationActivity

final class ba extends AsyncTask
{

    private Context a;
    private String b;
    private boolean c;
    private String d;
    private ChangePostLocationActivity e;

    ba(ChangePostLocationActivity changepostlocationactivity, Context context, String s, boolean flag, boolean flag1, String s1)
    {
        e = changepostlocationactivity;
        super();
        d = s1;
        a = context;
        b = s;
        c = true;
        if (StringUtils.isBlank(s1))
        {
            d = "Loading ...";
        }
        changepostlocationactivity.i();
    }

    protected final Object doInBackground(Object aobj[])
    {
        return an.a(a, ap.b, b, false, c, false);
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
            g.a("ChangePostLocationActivity", ((Exception) (obj)));
        }
    }

    protected final void onPreExecute()
    {
        e.g = ProgressDialog.show(a, "", d);
        e.g.setCancelable(true);
    }
}
