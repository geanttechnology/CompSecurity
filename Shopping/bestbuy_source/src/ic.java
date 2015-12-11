// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import com.bestbuy.android.activities.browseproduct.pdp.PDPOverviewFragment;
import com.bestbuy.android.api.lib.models.pdp.OverviewResponse;
import com.bestbuy.android.api.lib.models.pdp.episodes.PDPEpisodesParent;
import com.bestbuy.android.api.lib.models.pdp.episodes.PDPEpisodesResponse;
import com.bestbuy.android.api.lib.models.pdp.episodes.PDPEpisodesResponseChild;
import com.bestbuy.android.base.BBYBaseFragment;

public class ic extends ka
{

    private String a;
    private PDPEpisodesParent j;
    private OverviewResponse k;

    public ic(Activity activity, BBYBaseFragment bbybasefragment, OverviewResponse overviewresponse, String s)
    {
        super(activity, bbybasefragment);
        k = overviewresponse;
        a = s;
    }

    public void a()
    {
        j = fs.j(a);
    }

    public void b()
    {
        if ((i instanceof PDPOverviewFragment) && i.isAdded() && j != null && j.getSi() != null && j.getSi().getResponse() != null)
        {
            ((PDPOverviewFragment)i).e();
            k.setEpisodesList(j.getSi().getResponse().getEpisodes());
        }
    }
}
