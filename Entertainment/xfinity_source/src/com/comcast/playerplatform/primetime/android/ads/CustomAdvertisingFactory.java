// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.ads;

import com.adobe.mediacore.DefaultAdvertisingFactory;
import com.adobe.mediacore.MediaPlayerItem;
import com.adobe.mediacore.MediaResource;
import com.adobe.mediacore.metadata.DefaultMetadataKeys;
import com.adobe.mediacore.metadata.Metadata;
import com.adobe.mediacore.timeline.advertising.AdPolicySelector;
import com.adobe.mediacore.timeline.advertising.MetadataResolver;
import com.adobe.mediacore.timeline.advertising.auditude.AuditudeResolver;
import com.adobe.mediacore.timeline.advertising.customadmarkers.CustomAdMarkersContentResolver;
import com.comcast.playerplatform.primetime.android.ads.managers.BaseAdManager;
import com.comcast.playerplatform.primetime.android.ads.managers.FreewheelManager;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.comcast.playerplatform.primetime.android.ads:
//            CustomAdBreakPolicySelector, FreewheelAdResolver

public class CustomAdvertisingFactory extends DefaultAdvertisingFactory
{

    private BaseAdManager adManager;
    private boolean useResumeLogic;

    public CustomAdvertisingFactory(BaseAdManager baseadmanager, boolean flag)
    {
        super(baseadmanager.getSignalingMode());
        adManager = baseadmanager;
        useResumeLogic = flag;
    }

    public AdPolicySelector createAdPolicySelector(MediaPlayerItem mediaplayeritem)
    {
        return new CustomAdBreakPolicySelector(mediaplayeritem, adManager, useResumeLogic);
    }

    public List createContentResolvers(MediaPlayerItem mediaplayeritem)
    {
        ArrayList arraylist = new ArrayList();
        mediaplayeritem = mediaplayeritem.getResource().getMetadata();
        if (mediaplayeritem != null)
        {
            if (mediaplayeritem.containsKey(DefaultMetadataKeys.CUSTOM_AD_MARKERS_METADATA_KEY.getValue()))
            {
                arraylist.add(new CustomAdMarkersContentResolver());
            } else
            {
                if (mediaplayeritem.containsKey(DefaultMetadataKeys.AUDITUDE_METADATA_KEY.getValue()))
                {
                    arraylist.add(new AuditudeResolver());
                    return arraylist;
                }
                if (mediaplayeritem.containsKey(DefaultMetadataKeys.JSON_METADATA_KEY.getValue()))
                {
                    arraylist.add(new MetadataResolver());
                    return arraylist;
                }
                if (mediaplayeritem.containsKey("FREEWHEEL_AD_KEY"))
                {
                    arraylist.add(new FreewheelAdResolver((FreewheelManager)adManager));
                    return arraylist;
                }
            }
        }
        return arraylist;
    }
}
