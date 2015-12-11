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
import com.offerup.android.utils.as;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.offerup.android.activities:
//            ChangePostLocationActivity

final class bb extends AsyncTask
{

    private Context a;
    private String b;
    private String c;
    private boolean d;
    private ChangePostLocationActivity e;

    bb(ChangePostLocationActivity changepostlocationactivity, Context context, String s, boolean flag, boolean flag1, String s1, boolean flag2)
    {
        e = changepostlocationactivity;
        super();
        c = s1;
        a = context;
        b = s;
        d = true;
        if (StringUtils.isBlank(s1))
        {
            c = "Loading ...";
        }
        changepostlocationactivity.i();
    }

    protected final Object doInBackground(Object aobj[])
    {
        aobj = new OfferUpLocation(as.a(e, b), e.c);
        an.a(ap.b, null);
        an.a(ap.b, null);
        an.a(ap.b, ((OfferUpLocation) (aobj)));
        return ((Object) (aobj));
    }

    protected final void onPostExecute(Object obj)
    {
        obj = (OfferUpLocation)obj;
        e.i();
        if (d)
        {
            e.a = ((OfferUpLocation) (obj));
            e.a();
            return;
        }
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
        return;
    }

    protected final void onPreExecute()
    {
        e.g = ProgressDialog.show(a, "", c);
        e.g.setCancelable(true);
    }
}
