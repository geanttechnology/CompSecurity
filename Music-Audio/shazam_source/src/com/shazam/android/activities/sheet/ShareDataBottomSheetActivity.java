// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities.sheet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.shazam.android.k.f.i;
import com.shazam.android.k.f.j;
import com.shazam.android.widget.share.b;
import com.shazam.model.analytics.AnalyticsInfo;
import com.shazam.model.analytics.event.DefinedEventParameterKey;
import com.shazam.model.analytics.share.ShareStyle;
import com.shazam.model.share.ShareData;
import java.util.Map;

// Referenced classes of package com.shazam.android.activities.sheet:
//            a

public class ShareDataBottomSheetActivity extends a
{

    private final j a = new j();
    private ShareData b;
    private i c;

    public ShareDataBottomSheetActivity()
    {
    }

    public static Bundle a(ShareData sharedata)
    {
        Bundle bundle = new Bundle();
        bundle.putSerializable("share_data", sharedata);
        return bundle;
    }

    public final void a(View view, int k)
    {
        com.shazam.android.analytics.module.AddOnAnalyticsInfo.Builder builder = com.shazam.android.analytics.module.AddOnAnalyticsInfo.Builder.addOnAnalyticsInfo();
        AnalyticsInfo analyticsinfo = c.a();
        if (!analyticsinfo.eventParameters.isEmpty())
        {
            builder.withScreenName(analyticsinfo.a(DefinedEventParameterKey.SCREEN_NAME)).withTrackCategory(analyticsinfo.a(DefinedEventParameterKey.TRACK_CATEGORY)).withTrackId(b.trackId).withBeaconKey(b.beaconKey).withCampaign(b.campaign).withTagResultVersion(b.trackStyle).withArtistId(analyticsinfo.a(DefinedEventParameterKey.ARTIST_ID)).withShareStyle(ShareStyle.ACTION_SHEET);
        }
        (new b()).a(b, k, view, builder);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = getIntent();
        b = (ShareData)bundle.getSerializableExtra("share_data");
        c = j.a(bundle);
        a(b.a());
    }
}
