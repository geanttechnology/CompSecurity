// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import com.bestbuy.android.activities.browseproduct.pdp.PDPOverviewFragment;
import com.bestbuy.android.api.lib.models.pdp.OverviewResponse;
import com.bestbuy.android.api.lib.models.pdp.castandcrew.CastAndCrewParent;
import com.bestbuy.android.api.lib.models.pdp.castandcrew.CastAndCrewResponse;
import com.bestbuy.android.api.lib.models.pdp.castandcrew.SICastAndCrewResponse;
import com.bestbuy.android.base.BBYBaseFragment;

public class ib extends ka
{

    private String a;
    private CastAndCrewParent j;
    private OverviewResponse k;

    public ib(Activity activity, BBYBaseFragment bbybasefragment, OverviewResponse overviewresponse, String s)
    {
        super(activity, bbybasefragment);
        k = overviewresponse;
        a = s;
    }

    public void a()
    {
        j = fs.i(a);
    }

    public void b()
    {
        if (j != null && j.getSi() != null && j.getSi().getCastAndCrewResponse() != null && j.getSi().getCastAndCrewResponse().getCastAndCrew() != null)
        {
            if ((i instanceof PDPOverviewFragment) && i.isAdded())
            {
                ((PDPOverviewFragment)i).c();
            }
            k.setCastAndCrew(j.getSi().getCastAndCrewResponse().getCastAndCrew());
        }
    }
}
