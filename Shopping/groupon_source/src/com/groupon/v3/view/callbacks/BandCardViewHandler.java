// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.view.callbacks;

import android.content.Context;
import com.groupon.db.models.Band;
import com.groupon.models.nst.BandCardExtraInfo;
import com.groupon.util.LoggingUtils;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;

// Referenced classes of package com.groupon.v3.view.callbacks:
//            BandCardCallbacks

public class BandCardViewHandler
    implements BandCardCallbacks
{

    private static final String BAND_CARD_IMPRESSION_TYPE = "band_card_impression";
    private static final String BAND_CARD_TYPE_TITLE = "title";
    private LoggingUtils loggingUtils;
    private String nstChannel;

    public BandCardViewHandler(Context context, String s)
    {
        RoboGuice.getInjector(context).injectMembers(this);
        nstChannel = s;
    }

    public void onBandBound(Band band)
    {
        band = new BandCardExtraInfo("title");
        loggingUtils.logImpression("", "band_card_impression", nstChannel, "0", band);
    }
}
