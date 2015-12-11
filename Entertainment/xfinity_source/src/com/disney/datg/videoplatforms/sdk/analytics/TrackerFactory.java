// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.analytics;

import android.app.Activity;
import com.disney.datg.videoplatforms.sdk.analytics.omniture.OmnitureTracker;
import com.disney.datg.videoplatforms.sdk.analytics.slogger.SloggerTracker;
import com.disney.datg.videoplatforms.sdk.media.Configuration;
import com.disney.datg.videoplatforms.sdk.utils.LogUtils;

// Referenced classes of package com.disney.datg.videoplatforms.sdk.analytics:
//            ITracker

public class TrackerFactory
{
    public static final class TrackerType extends Enum
    {

        private static final TrackerType $VALUES[];
        public static final TrackerType OMNITURE;
        public static final TrackerType SLOGGER;
        public static final TrackerType UNKNOWN;

        public static TrackerType valueOf(String s)
        {
            return (TrackerType)Enum.valueOf(com/disney/datg/videoplatforms/sdk/analytics/TrackerFactory$TrackerType, s);
        }

        public static TrackerType[] values()
        {
            return (TrackerType[])$VALUES.clone();
        }

        static 
        {
            OMNITURE = new TrackerType("OMNITURE", 0);
            SLOGGER = new TrackerType("SLOGGER", 1);
            UNKNOWN = new TrackerType("UNKNOWN", 2);
            $VALUES = (new TrackerType[] {
                OMNITURE, SLOGGER, UNKNOWN
            });
        }

        private TrackerType(String s, int i)
        {
            super(s, i);
        }
    }


    public static ITracker getTracker(TrackerType trackertype, Activity activity, Configuration configuration)
    {
        static class _cls1
        {

            static final int $SwitchMap$com$disney$datg$videoplatforms$sdk$analytics$TrackerFactory$TrackerType[];

            static 
            {
                $SwitchMap$com$disney$datg$videoplatforms$sdk$analytics$TrackerFactory$TrackerType = new int[TrackerType.values().length];
                try
                {
                    $SwitchMap$com$disney$datg$videoplatforms$sdk$analytics$TrackerFactory$TrackerType[TrackerType.OMNITURE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$disney$datg$videoplatforms$sdk$analytics$TrackerFactory$TrackerType[TrackerType.SLOGGER.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.disney.datg.videoplatforms.sdk.analytics.TrackerFactory.TrackerType[trackertype.ordinal()])
        {
        default:
            return null;

        case 1: // '\001'
            try
            {
                trackertype = new OmnitureTracker(activity, configuration);
            }
            // Misplaced declaration of an exception variable
            catch (TrackerType trackertype)
            {
                LogUtils.LOGE("TrackerFactory", String.format("OmnitureTracker instantiationFailure - %s", new Object[] {
                    trackertype.getMessage()
                }));
                return null;
            }
            return trackertype;

        case 2: // '\002'
            break;
        }
        try
        {
            trackertype = new SloggerTracker(activity, configuration);
        }
        // Misplaced declaration of an exception variable
        catch (TrackerType trackertype)
        {
            LogUtils.LOGE("TrackerFactory", String.format("SloggerTracker instantiationFailure - %s", new Object[] {
                trackertype.getMessage()
            }));
            return null;
        }
        return trackertype;
    }
}
