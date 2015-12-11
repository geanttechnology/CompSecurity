// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.app.Activity;
import android.os.AsyncTask;
import com.abtnprojects.ambatana.models.CountryCurrencyInfo;
import com.abtnprojects.ambatana.models.LatitudeLongitude;
import com.abtnprojects.ambatana.models.SearchParameters;
import com.abtnprojects.ambatana.ui.activities.e;
import com.abtnprojects.ambatana.ui.fragments.ProductListFragment;
import com.parse.ParseUser;

// Referenced classes of package android.support.v7:
//            fu, aqo, gf

public class fh extends AsyncTask
{

    public final String a = android/support/v7/fh.getSimpleName();
    protected final Activity b;
    protected final int c;
    protected final String d;
    protected final String e;
    protected final ProductListFragment f;
    protected final LatitudeLongitude g;
    private final SearchParameters h;
    private final fu i = new fu();
    private final CountryCurrencyInfo j;
    private final String k = ParseUser.getCurrentUser().getSessionToken();

    public fh(e e1, int l, String s, String s1, SearchParameters searchparameters, ProductListFragment productlistfragment, LatitudeLongitude latitudelongitude, 
            CountryCurrencyInfo countrycurrencyinfo)
    {
        b = e1;
        c = l;
        d = s;
        e = s1;
        f = productlistfragment;
        h = searchparameters;
        g = latitudelongitude;
        j = countrycurrencyinfo;
    }

    protected transient gf a(Void avoid[])
    {
        aqo.a("will fetch results for location %s", new Object[] {
            g.toString()
        });
        return i.a(h, c, b, d, g, j, k);
    }

    protected void a(gf gf1)
    {
        if (f != null && f.n())
        {
            f.a(gf1);
        }
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((gf)obj);
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
    }
}
