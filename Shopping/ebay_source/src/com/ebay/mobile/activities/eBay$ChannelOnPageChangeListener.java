// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.Pair;
import com.ebay.common.Preferences;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.SourceIdentification;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.util.AdUtil;
import com.ebay.nautilus.domain.data.UnifiedStream.Channel;
import com.ebay.nautilus.domain.data.UnifiedStream.ChannelEnum;
import com.ebay.nautilus.domain.net.api.experimentation.Treatment;
import java.lang.ref.WeakReference;
import java.util.Locale;

// Referenced classes of package com.ebay.mobile.activities:
//            eBay

static final class activityReference extends android.support.v4.view.ner
{

    private final WeakReference activityReference;
    private int currentPosition;

    public void onPageSelected(int i)
    {
        eBay ebay = (eBay)activityReference.get();
        if (ebay != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj1;
        Object obj2;
        obj2 = null;
        Channel channel = ebay.getChannel(new int[] {
            i
        });
        if (channel != null)
        {
            ebay.overrideChannel = ChannelEnum.valueOf(channel.name);
            MyApp.getPrefs().setLastHomeChannel(ebay.overrideChannel.ordinal());
            obj2 = channel.name;
        }
        obj1 = null;
        channel = ebay.getChannel(new int[] {
            currentPosition
        });
        if (channel != null)
        {
            obj1 = channel.name;
        }
        if (!"SHOP".equals(obj1)) goto _L4; else goto _L3
_L3:
        Object obj;
        Object obj3 = (ViewPager)ebay.findViewById(0x7f1002e6);
        obj = obj1;
        if (obj3 != null)
        {
            obj3 = ebay.getChannel(new int[] {
                currentPosition, ((ViewPager) (obj3)).getCurrentItem()
            });
            obj = obj1;
            if (obj3 != null)
            {
                obj = TrackingData.sanitize(((Channel) (obj3)).getTrackingName());
            }
        }
_L5:
        currentPosition = i;
        if (!TextUtils.isEmpty(((CharSequence) (obj2))))
        {
            obj1 = new TrackingData(ebay.getTrackingEventName(), TrackingType.PAGE_IMPRESSION);
            ((TrackingData) (obj1)).addKeyValuePair("chnl", ((String) (obj2)).toLowerCase(Locale.US), true);
            if ("SHOP".equals(obj2))
            {
                obj2 = (ViewPager)ebay.findViewById(0x7f1002e6);
                if (obj2 != null)
                {
                    obj2 = ebay.getChannel(new int[] {
                        i, ((ViewPager) (obj2)).getCurrentItem()
                    });
                    if (obj2 != null)
                    {
                        ((TrackingData) (obj1)).addKeyValuePair("subchnl", TrackingData.sanitize(((Channel) (obj2)).getTrackingName()), true);
                        obj2 = AdUtil.adsEnabledForShopSubChannel(((Channel) (obj2)).isDepartment, ((Channel) (obj2)).getTrackingName(), ebay.getEbayContext());
                        if (obj2 != null)
                        {
                            ((TrackingData) (obj1)).addExperimentServedTags((Treatment)((Pair) (obj2)).second);
                        }
                    }
                }
            }
            obj2 = ebay.getIntent();
            if (obj2 != null && ((Intent) (obj2)).hasExtra("com.ebay.mobile.analytics.sid"))
            {
                ((TrackingData) (obj1)).addSourceIdentification(((Intent) (obj2)));
            } else
            {
                ((TrackingData) (obj1)).addSourceIdentification(new SourceIdentification("HomePage", "carousel", ((String) (obj))));
            }
            ((TrackingData) (obj1)).send(ebay);
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
        obj = obj1;
        if (obj1 != null)
        {
            obj = ((String) (obj1)).toLowerCase(Locale.US);
        }
          goto _L5
    }

    protected (eBay ebay)
    {
        currentPosition = -1;
        activityReference = new WeakReference(ebay);
    }
}
