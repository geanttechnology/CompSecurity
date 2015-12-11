// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import com.bestbuy.android.activities.browseproduct.pdp.PDPOverviewFragment;
import com.bestbuy.android.api.lib.models.pdp.OverviewResponse;
import com.bestbuy.android.api.lib.models.pdpmusic.MusicResponse;
import com.bestbuy.android.base.BBYBaseFragment;

public class if extends ka
{

    private String a;
    private MusicResponse j;
    private OverviewResponse k;

    public if(Activity activity, BBYBaseFragment bbybasefragment, OverviewResponse overviewresponse, String s)
    {
        super(activity, bbybasefragment);
        k = overviewresponse;
        a = s;
    }

    public void a()
    {
        j = fs.l(a);
    }

    public void b()
    {
        if (j != null && (i instanceof PDPOverviewFragment) && i.isAdded())
        {
            ((PDPOverviewFragment)i).f();
            k.setMusicResponse(j);
        }
    }
}
