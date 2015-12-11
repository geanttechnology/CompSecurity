// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import com.bestbuy.android.activities.browseproduct.pdp.PDPOverviewFragment;
import com.bestbuy.android.api.lib.models.pdp.OverviewResponse;
import com.bestbuy.android.api.lib.models.pdpmovies.MoviesResponse;
import com.bestbuy.android.base.BBYBaseFragment;

public class ie extends ka
{

    private String a;
    private MoviesResponse j;
    private OverviewResponse k;

    public ie(Activity activity, BBYBaseFragment bbybasefragment, OverviewResponse overviewresponse, String s)
    {
        super(activity, bbybasefragment);
        k = overviewresponse;
        a = s;
    }

    public void a()
    {
        j = fs.k(a);
    }

    public void b()
    {
        if (j != null && (i instanceof PDPOverviewFragment) && i.isAdded())
        {
            ((PDPOverviewFragment)i).d();
            k.setMovieDetails(j.getMovieDetails());
        }
    }
}
