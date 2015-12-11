// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.util.Pair;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

// Referenced classes of package com.mopub.mobileads:
//            CustomEventRewardedVideo

class RewardedVideoData
{
    private static class TwoPartKey extends Pair
    {

        final String adNetworkId;
        final Class customEventClass;

        public TwoPartKey(Class class1, String s)
        {
            super(class1, s);
            customEventClass = class1;
            adNetworkId = s;
        }
    }


    private final Set mAdNetworkListeners = new HashSet();
    private final Map mAdUnitToCustomEventMap = new TreeMap();
    private final Map mCustomEventToMoPubIdMap = new HashMap();

    RewardedVideoData()
    {
    }

    void associateCustomEventWithMoPubId(Class class1, String s, String s1)
    {
        TwoPartKey twopartkey = new TwoPartKey(class1, s);
        class1 = mCustomEventToMoPubIdMap.entrySet().iterator();
        do
        {
            if (!class1.hasNext())
            {
                break;
            }
            s = (java.util.Map.Entry)class1.next();
            if (((TwoPartKey)s.getKey()).equals(twopartkey) || !((Set)s.getValue()).contains(s1))
            {
                continue;
            }
            ((Set)s.getValue()).remove(s1);
            if (((Set)s.getValue()).isEmpty())
            {
                class1.remove();
            }
            break;
        } while (true);
        s = (Set)mCustomEventToMoPubIdMap.get(twopartkey);
        class1 = s;
        if (s == null)
        {
            class1 = new HashSet();
            mCustomEventToMoPubIdMap.put(twopartkey, class1);
        }
        class1.add(s1);
    }

    CustomEventRewardedVideo getCustomEvent(String s)
    {
        return (CustomEventRewardedVideo)mAdUnitToCustomEventMap.get(s);
    }

    Set getMoPubIdsForAdNetwork(Class class1, String s)
    {
        if (s == null)
        {
            HashSet hashset = new HashSet();
            Iterator iterator = mCustomEventToMoPubIdMap.entrySet().iterator();
            do
            {
                s = hashset;
                if (!iterator.hasNext())
                {
                    break;
                }
                s = (java.util.Map.Entry)iterator.next();
                if (class1 == ((TwoPartKey)s.getKey()).customEventClass)
                {
                    hashset.addAll((Collection)s.getValue());
                }
            } while (true);
        } else
        {
            class1 = new TwoPartKey(class1, s);
            if (mCustomEventToMoPubIdMap.containsKey(class1))
            {
                class1 = (Set)mCustomEventToMoPubIdMap.get(class1);
            } else
            {
                class1 = Collections.emptySet();
            }
            s = class1;
        }
        return s;
    }

    void updateAdUnitCustomEventMapping(String s, CustomEventRewardedVideo customeventrewardedvideo, CustomEventRewardedVideo.CustomEventRewardedVideoListener customeventrewardedvideolistener, String s1)
    {
        mAdUnitToCustomEventMap.put(s, customeventrewardedvideo);
        mAdNetworkListeners.add(customeventrewardedvideolistener);
        associateCustomEventWithMoPubId(customeventrewardedvideo.getClass(), s1, s);
    }
}
