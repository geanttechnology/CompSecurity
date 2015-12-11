// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.analytics;

import com.disney.datg.videoplatforms.sdk.utils.LogUtils;
import java.util.Vector;

// Referenced classes of package com.disney.datg.videoplatforms.sdk.analytics:
//            IAdTracker, ITracker, IAppTracker, ILinkTracker, 
//            IMediaTracker, IAuthZTracker, ITrackable

public class TrackingManager
{
    public static final class AdEvent extends Enum
    {

        private static final AdEvent $VALUES[];
        public static final AdEvent BREAKCOMPLETED;
        public static final AdEvent BREAKSTARTED;
        public static final AdEvent COMPLETED;
        public static final AdEvent ERROR;
        public static final AdEvent FIRSTQUARTILE;
        public static final AdEvent MIDPOINT;
        public static final AdEvent STARTED;
        public static final AdEvent THIRDQUARTILE;

        public static AdEvent valueOf(String s)
        {
            return (AdEvent)Enum.valueOf(com/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AdEvent, s);
        }

        public static AdEvent[] values()
        {
            return (AdEvent[])$VALUES.clone();
        }

        static 
        {
            BREAKSTARTED = new AdEvent("BREAKSTARTED", 0);
            BREAKCOMPLETED = new AdEvent("BREAKCOMPLETED", 1);
            STARTED = new AdEvent("STARTED", 2);
            COMPLETED = new AdEvent("COMPLETED", 3);
            FIRSTQUARTILE = new AdEvent("FIRSTQUARTILE", 4);
            MIDPOINT = new AdEvent("MIDPOINT", 5);
            THIRDQUARTILE = new AdEvent("THIRDQUARTILE", 6);
            ERROR = new AdEvent("ERROR", 7);
            $VALUES = (new AdEvent[] {
                BREAKSTARTED, BREAKCOMPLETED, STARTED, COMPLETED, FIRSTQUARTILE, MIDPOINT, THIRDQUARTILE, ERROR
            });
        }

        private AdEvent(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class AppEvent extends Enum
    {

        private static final AppEvent $VALUES[];
        public static final AppEvent ACTIVITYSTART;
        public static final AppEvent ACTIVITYSTOP;
        public static final AppEvent APPSTATE;
        public static final AppEvent ERROR;
        public static final AppEvent LAUNCH;

        public static AppEvent valueOf(String s)
        {
            return (AppEvent)Enum.valueOf(com/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AppEvent, s);
        }

        public static AppEvent[] values()
        {
            return (AppEvent[])$VALUES.clone();
        }

        static 
        {
            LAUNCH = new AppEvent("LAUNCH", 0);
            ACTIVITYSTART = new AppEvent("ACTIVITYSTART", 1);
            ACTIVITYSTOP = new AppEvent("ACTIVITYSTOP", 2);
            APPSTATE = new AppEvent("APPSTATE", 3);
            ERROR = new AppEvent("ERROR", 4);
            $VALUES = (new AppEvent[] {
                LAUNCH, ACTIVITYSTART, ACTIVITYSTOP, APPSTATE, ERROR
            });
        }

        private AppEvent(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class AuthZEvent extends Enum
    {

        private static final AuthZEvent $VALUES[];
        public static final AuthZEvent AUTH_Z_FAILED;
        public static final AuthZEvent AUTH_Z_STARTED;
        public static final AuthZEvent AUTH_Z_SUCCESS;

        public static AuthZEvent valueOf(String s)
        {
            return (AuthZEvent)Enum.valueOf(com/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AuthZEvent, s);
        }

        public static AuthZEvent[] values()
        {
            return (AuthZEvent[])$VALUES.clone();
        }

        static 
        {
            AUTH_Z_STARTED = new AuthZEvent("AUTH_Z_STARTED", 0);
            AUTH_Z_SUCCESS = new AuthZEvent("AUTH_Z_SUCCESS", 1);
            AUTH_Z_FAILED = new AuthZEvent("AUTH_Z_FAILED", 2);
            $VALUES = (new AuthZEvent[] {
                AUTH_Z_STARTED, AUTH_Z_SUCCESS, AUTH_Z_FAILED
            });
        }

        private AuthZEvent(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class MediaEvent extends Enum
    {

        private static final MediaEvent $VALUES[];
        public static final MediaEvent COMPLETE;
        public static final MediaEvent ERROR;
        public static final MediaEvent FIRST_QUARTER;
        public static final MediaEvent FORWARD;
        public static final MediaEvent MID_POINT;
        public static final MediaEvent PAUSED;
        public static final MediaEvent PING;
        public static final MediaEvent RESUMED;
        public static final MediaEvent REWIND;
        public static final MediaEvent STARTED;
        public static final MediaEvent STATEUPDATED;
        public static final MediaEvent STOPPED;
        public static final MediaEvent THIRD_QUARTER;

        public static MediaEvent valueOf(String s)
        {
            return (MediaEvent)Enum.valueOf(com/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent, s);
        }

        public static MediaEvent[] values()
        {
            return (MediaEvent[])$VALUES.clone();
        }

        static 
        {
            STARTED = new MediaEvent("STARTED", 0);
            PAUSED = new MediaEvent("PAUSED", 1);
            RESUMED = new MediaEvent("RESUMED", 2);
            FORWARD = new MediaEvent("FORWARD", 3);
            REWIND = new MediaEvent("REWIND", 4);
            STOPPED = new MediaEvent("STOPPED", 5);
            STATEUPDATED = new MediaEvent("STATEUPDATED", 6);
            ERROR = new MediaEvent("ERROR", 7);
            FIRST_QUARTER = new MediaEvent("FIRST_QUARTER", 8);
            MID_POINT = new MediaEvent("MID_POINT", 9);
            THIRD_QUARTER = new MediaEvent("THIRD_QUARTER", 10);
            COMPLETE = new MediaEvent("COMPLETE", 11);
            PING = new MediaEvent("PING", 12);
            $VALUES = (new MediaEvent[] {
                STARTED, PAUSED, RESUMED, FORWARD, REWIND, STOPPED, STATEUPDATED, ERROR, FIRST_QUARTER, MID_POINT, 
                THIRD_QUARTER, COMPLETE, PING
            });
        }

        private MediaEvent(String s, int i)
        {
            super(s, i);
        }
    }


    private static String TAG = "Tracking Manager";
    private static Vector adTrackers = new Vector();
    private static Vector appTrackers = new Vector();
    private static Vector authTrackers = new Vector();
    private static Vector linkTrackers = new Vector();
    private static Vector mediaTrackers = new Vector();

    public static Vector getLinkTrackers()
    {
        return linkTrackers;
    }

    public static void registerTracker(ITracker itracker)
    {
        if ((itracker instanceof IAdTracker) && !adTrackers.contains(itracker))
        {
            adTrackers.add((IAdTracker)itracker);
            LogUtils.LOGD(TAG, (new StringBuilder()).append("Ad tracker registered ").append(itracker.getName()).toString());
        }
        if ((itracker instanceof IAppTracker) && !appTrackers.contains(itracker))
        {
            appTrackers.add((IAppTracker)itracker);
            LogUtils.LOGD(TAG, (new StringBuilder()).append("App tracker registered ").append(itracker.getName()).toString());
        }
        if ((itracker instanceof ILinkTracker) && !linkTrackers.contains(itracker))
        {
            linkTrackers.add((ILinkTracker)itracker);
            LogUtils.LOGD(TAG, (new StringBuilder()).append("Link tracker registered ").append(itracker.getName()).toString());
        }
        if ((itracker instanceof IMediaTracker) && !mediaTrackers.contains(itracker))
        {
            mediaTrackers.add((IMediaTracker)itracker);
            LogUtils.LOGD(TAG, (new StringBuilder()).append("Media tracker registered ").append(itracker.getName()).toString());
        }
        if ((itracker instanceof IAuthZTracker) && !authTrackers.contains(itracker))
        {
            authTrackers.add((IAuthZTracker)itracker);
            LogUtils.LOGD(TAG, (new StringBuilder()).append("Media tracker registered ").append(itracker.getName()).toString());
        }
    }

    public static void removeAllTrackers()
    {
        adTrackers.clear();
        appTrackers.clear();
        linkTrackers.clear();
        mediaTrackers.clear();
        authTrackers.clear();
    }

    public static void trackAd(AdEvent adevent, ITrackable itrackable)
    {
        static class _cls1
        {

            static final int $SwitchMap$com$disney$datg$videoplatforms$sdk$analytics$TrackingManager$AdEvent[];
            static final int $SwitchMap$com$disney$datg$videoplatforms$sdk$analytics$TrackingManager$AppEvent[];
            static final int $SwitchMap$com$disney$datg$videoplatforms$sdk$analytics$TrackingManager$AuthZEvent[];
            static final int $SwitchMap$com$disney$datg$videoplatforms$sdk$analytics$TrackingManager$MediaEvent[];

            static 
            {
                $SwitchMap$com$disney$datg$videoplatforms$sdk$analytics$TrackingManager$AppEvent = new int[AppEvent.values().length];
                try
                {
                    $SwitchMap$com$disney$datg$videoplatforms$sdk$analytics$TrackingManager$AppEvent[AppEvent.LAUNCH.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror28) { }
                try
                {
                    $SwitchMap$com$disney$datg$videoplatforms$sdk$analytics$TrackingManager$AppEvent[AppEvent.ACTIVITYSTART.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror27) { }
                try
                {
                    $SwitchMap$com$disney$datg$videoplatforms$sdk$analytics$TrackingManager$AppEvent[AppEvent.ACTIVITYSTOP.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror26) { }
                try
                {
                    $SwitchMap$com$disney$datg$videoplatforms$sdk$analytics$TrackingManager$AppEvent[AppEvent.APPSTATE.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror25) { }
                try
                {
                    $SwitchMap$com$disney$datg$videoplatforms$sdk$analytics$TrackingManager$AppEvent[AppEvent.ERROR.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror24) { }
                $SwitchMap$com$disney$datg$videoplatforms$sdk$analytics$TrackingManager$AdEvent = new int[AdEvent.values().length];
                try
                {
                    $SwitchMap$com$disney$datg$videoplatforms$sdk$analytics$TrackingManager$AdEvent[AdEvent.BREAKSTARTED.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror23) { }
                try
                {
                    $SwitchMap$com$disney$datg$videoplatforms$sdk$analytics$TrackingManager$AdEvent[AdEvent.BREAKCOMPLETED.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror22) { }
                try
                {
                    $SwitchMap$com$disney$datg$videoplatforms$sdk$analytics$TrackingManager$AdEvent[AdEvent.STARTED.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror21) { }
                try
                {
                    $SwitchMap$com$disney$datg$videoplatforms$sdk$analytics$TrackingManager$AdEvent[AdEvent.FIRSTQUARTILE.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror20) { }
                try
                {
                    $SwitchMap$com$disney$datg$videoplatforms$sdk$analytics$TrackingManager$AdEvent[AdEvent.MIDPOINT.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror19) { }
                try
                {
                    $SwitchMap$com$disney$datg$videoplatforms$sdk$analytics$TrackingManager$AdEvent[AdEvent.THIRDQUARTILE.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror18) { }
                try
                {
                    $SwitchMap$com$disney$datg$videoplatforms$sdk$analytics$TrackingManager$AdEvent[AdEvent.COMPLETED.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror17) { }
                try
                {
                    $SwitchMap$com$disney$datg$videoplatforms$sdk$analytics$TrackingManager$AdEvent[AdEvent.ERROR.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror16) { }
                $SwitchMap$com$disney$datg$videoplatforms$sdk$analytics$TrackingManager$MediaEvent = new int[MediaEvent.values().length];
                try
                {
                    $SwitchMap$com$disney$datg$videoplatforms$sdk$analytics$TrackingManager$MediaEvent[MediaEvent.STARTED.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror15) { }
                try
                {
                    $SwitchMap$com$disney$datg$videoplatforms$sdk$analytics$TrackingManager$MediaEvent[MediaEvent.PAUSED.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror14) { }
                try
                {
                    $SwitchMap$com$disney$datg$videoplatforms$sdk$analytics$TrackingManager$MediaEvent[MediaEvent.RESUMED.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror13) { }
                try
                {
                    $SwitchMap$com$disney$datg$videoplatforms$sdk$analytics$TrackingManager$MediaEvent[MediaEvent.STOPPED.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror12) { }
                try
                {
                    $SwitchMap$com$disney$datg$videoplatforms$sdk$analytics$TrackingManager$MediaEvent[MediaEvent.FORWARD.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    $SwitchMap$com$disney$datg$videoplatforms$sdk$analytics$TrackingManager$MediaEvent[MediaEvent.REWIND.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    $SwitchMap$com$disney$datg$videoplatforms$sdk$analytics$TrackingManager$MediaEvent[MediaEvent.STATEUPDATED.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    $SwitchMap$com$disney$datg$videoplatforms$sdk$analytics$TrackingManager$MediaEvent[MediaEvent.FIRST_QUARTER.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$com$disney$datg$videoplatforms$sdk$analytics$TrackingManager$MediaEvent[MediaEvent.MID_POINT.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$disney$datg$videoplatforms$sdk$analytics$TrackingManager$MediaEvent[MediaEvent.THIRD_QUARTER.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$disney$datg$videoplatforms$sdk$analytics$TrackingManager$MediaEvent[MediaEvent.COMPLETE.ordinal()] = 11;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$disney$datg$videoplatforms$sdk$analytics$TrackingManager$MediaEvent[MediaEvent.ERROR.ordinal()] = 12;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$disney$datg$videoplatforms$sdk$analytics$TrackingManager$MediaEvent[MediaEvent.PING.ordinal()] = 13;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                $SwitchMap$com$disney$datg$videoplatforms$sdk$analytics$TrackingManager$AuthZEvent = new int[AuthZEvent.values().length];
                try
                {
                    $SwitchMap$com$disney$datg$videoplatforms$sdk$analytics$TrackingManager$AuthZEvent[AuthZEvent.AUTH_Z_STARTED.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$disney$datg$videoplatforms$sdk$analytics$TrackingManager$AuthZEvent[AuthZEvent.AUTH_Z_FAILED.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$disney$datg$videoplatforms$sdk$analytics$TrackingManager$AuthZEvent[AuthZEvent.AUTH_Z_SUCCESS.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.disney.datg.videoplatforms.sdk.analytics.TrackingManager.AdEvent[adevent.ordinal()];
        JVM INSTR tableswitch 1 8: default 56
    //                   1 57
    //                   2 123
    //                   3 189
    //                   4 255
    //                   5 321
    //                   6 387
    //                   7 453
    //                   8 519;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9
_L1:
        return;
_L2:
        int i = 0;
        while (i < adTrackers.size()) 
        {
            adevent = (ITracker)adTrackers.get(i);
            if (itrackable != null && adevent != null && adevent.getName().equals(itrackable.getName()))
            {
                ((IAdTracker)adevent).trackAdBreakStart(itrackable);
            }
            i++;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        int j = 0;
        while (j < adTrackers.size()) 
        {
            adevent = (ITracker)adTrackers.get(j);
            if (itrackable != null && adevent != null && adevent.getName().equals(itrackable.getName()))
            {
                ((IAdTracker)adevent).trackAdBreakEnd(itrackable);
            }
            j++;
        }
        if (true) goto _L1; else goto _L4
_L4:
        int k = 0;
        while (k < adTrackers.size()) 
        {
            adevent = (ITracker)adTrackers.get(k);
            if (itrackable != null && adevent != null && adevent.getName().equals(itrackable.getName()))
            {
                ((IAdTracker)adevent).trackAdStart(itrackable);
            }
            k++;
        }
        if (true)
        {
            continue; /* Loop/switch isn't completed */
        }
_L5:
        int l = 0;
        while (l < adTrackers.size()) 
        {
            adevent = (ITracker)adTrackers.get(l);
            if (itrackable != null && adevent != null && adevent.getName().equals(itrackable.getName()))
            {
                ((IAdTracker)adevent).trackAdFirstQuartile(itrackable);
            }
            l++;
        }
        if (true) goto _L1; else goto _L6
_L6:
        int i1 = 0;
        while (i1 < adTrackers.size()) 
        {
            adevent = (ITracker)adTrackers.get(i1);
            if (itrackable != null && adevent != null && adevent.getName().equals(itrackable.getName()))
            {
                ((IAdTracker)adevent).trackAdMidpoint(itrackable);
            }
            i1++;
        }
        if (true)
        {
            continue; /* Loop/switch isn't completed */
        }
_L7:
        int j1 = 0;
        while (j1 < adTrackers.size()) 
        {
            adevent = (ITracker)adTrackers.get(j1);
            if (itrackable != null && adevent != null && adevent.getName().equals(itrackable.getName()))
            {
                ((IAdTracker)adevent).trackAdThirdQuartile(itrackable);
            }
            j1++;
        }
        if (true) goto _L1; else goto _L8
_L8:
        int k1 = 0;
        while (k1 < adTrackers.size()) 
        {
            adevent = (ITracker)adTrackers.get(k1);
            if (itrackable != null && adevent != null && adevent.getName().equals(itrackable.getName()))
            {
                ((IAdTracker)adevent).trackAdEnd(itrackable);
            }
            k1++;
        }
        if (true)
        {
            continue; /* Loop/switch isn't completed */
        }
_L9:
        int l1 = 0;
        while (l1 < adTrackers.size()) 
        {
            adevent = (ITracker)adTrackers.get(l1);
            if (itrackable != null && adevent != null && adevent.getName().equals(itrackable.getName()))
            {
                ((IAdTracker)adevent).trackAdError(itrackable);
            }
            l1++;
        }
        if (true) goto _L1; else goto _L10
_L10:
    }

    public static void trackAuthZ(AuthZEvent authzevent, ITrackable itrackable)
    {
        _cls1..SwitchMap.com.disney.datg.videoplatforms.sdk.analytics.TrackingManager.AuthZEvent[authzevent.ordinal()];
        JVM INSTR tableswitch 1 3: default 36
    //                   1 37
    //                   2 103
    //                   3 169;
           goto _L1 _L2 _L3 _L4
_L1:
        return;
_L2:
        int i = 0;
        while (i < authTrackers.size()) 
        {
            authzevent = (ITracker)authTrackers.get(i);
            if (itrackable != null && authzevent != null && authzevent.getName().equals(itrackable.getName()))
            {
                ((IAuthZTracker)authzevent).trackAuthZStarted(itrackable);
            }
            i++;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        int j = 0;
        while (j < authTrackers.size()) 
        {
            authzevent = (ITracker)authTrackers.get(j);
            if (itrackable != null && authzevent != null && authzevent.getName().equals(itrackable.getName()))
            {
                ((IAuthZTracker)authzevent).trackAuthZFailure(itrackable);
            }
            j++;
        }
        if (true) goto _L1; else goto _L4
_L4:
        int k = 0;
        while (k < authTrackers.size()) 
        {
            authzevent = (ITracker)authTrackers.get(k);
            if (itrackable != null && authzevent != null && authzevent.getName().equals(itrackable.getName()))
            {
                ((IAuthZTracker)authzevent).trackAuthZSuccess(itrackable);
            }
            k++;
        }
        if (true) goto _L1; else goto _L5
_L5:
    }

    public static void trackMedia(MediaEvent mediaevent, ITrackable itrackable)
    {
        _cls1..SwitchMap.com.disney.datg.videoplatforms.sdk.analytics.TrackingManager.MediaEvent[mediaevent.ordinal()];
        JVM INSTR tableswitch 1 13: default 76
    //                   1 77
    //                   2 143
    //                   3 209
    //                   4 275
    //                   5 341
    //                   6 407
    //                   7 473
    //                   8 539
    //                   9 605
    //                   10 671
    //                   11 737
    //                   12 803
    //                   13 869;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14
_L1:
        return;
_L2:
        int i = 0;
        while (i < mediaTrackers.size()) 
        {
            mediaevent = (ITracker)mediaTrackers.get(i);
            if (itrackable != null && mediaevent != null && mediaevent.getName().equals(itrackable.getName()))
            {
                ((IMediaTracker)mediaevent).trackMediaStarted(itrackable);
            }
            i++;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        int j = 0;
        while (j < mediaTrackers.size()) 
        {
            mediaevent = (ITracker)mediaTrackers.get(j);
            if (itrackable != null && mediaevent != null && mediaevent.getName().equals(itrackable.getName()))
            {
                ((IMediaTracker)mediaevent).trackMediaPaused(itrackable);
            }
            j++;
        }
        if (true) goto _L1; else goto _L4
_L4:
        int k = 0;
        while (k < mediaTrackers.size()) 
        {
            mediaevent = (ITracker)mediaTrackers.get(k);
            if (itrackable != null && mediaevent != null && mediaevent.getName().equals(itrackable.getName()))
            {
                ((IMediaTracker)mediaevent).trackMediaResumed(itrackable);
            }
            k++;
        }
        if (true)
        {
            continue; /* Loop/switch isn't completed */
        }
_L5:
        int l = 0;
        while (l < mediaTrackers.size()) 
        {
            mediaevent = (ITracker)mediaTrackers.get(l);
            if (itrackable != null && mediaevent != null && mediaevent.getName().equals(itrackable.getName()))
            {
                ((IMediaTracker)mediaevent).trackMediaStopped(itrackable);
            }
            l++;
        }
        if (true) goto _L1; else goto _L6
_L6:
        int i1 = 0;
        while (i1 < mediaTrackers.size()) 
        {
            mediaevent = (ITracker)mediaTrackers.get(i1);
            if (itrackable != null && mediaevent != null && mediaevent.getName().equals(itrackable.getName()))
            {
                ((IMediaTracker)mediaevent).trackMediaForward(itrackable);
            }
            i1++;
        }
        if (true)
        {
            continue; /* Loop/switch isn't completed */
        }
_L7:
        int j1 = 0;
        while (j1 < mediaTrackers.size()) 
        {
            mediaevent = (ITracker)mediaTrackers.get(j1);
            if (itrackable != null && mediaevent != null && mediaevent.getName().equals(itrackable.getName()))
            {
                ((IMediaTracker)mediaevent).trackMediaRewind(itrackable);
            }
            j1++;
        }
        if (true) goto _L1; else goto _L8
_L8:
        int k1 = 0;
        while (k1 < mediaTrackers.size()) 
        {
            mediaevent = (ITracker)mediaTrackers.get(k1);
            if (itrackable != null && mediaevent != null && mediaevent.getName().equals(itrackable.getName()))
            {
                ((IMediaTracker)mediaevent).trackMediaStateUpdated(itrackable);
            }
            k1++;
        }
        if (true)
        {
            continue; /* Loop/switch isn't completed */
        }
_L9:
        int l1 = 0;
        while (l1 < mediaTrackers.size()) 
        {
            mediaevent = (ITracker)mediaTrackers.get(l1);
            if (itrackable != null && mediaevent != null && mediaevent.getName().equals(itrackable.getName()))
            {
                ((IMediaTracker)mediaevent).trackMediaFirstQuarter(itrackable);
            }
            l1++;
        }
        if (true) goto _L1; else goto _L10
_L10:
        int i2 = 0;
        while (i2 < mediaTrackers.size()) 
        {
            mediaevent = (ITracker)mediaTrackers.get(i2);
            if (itrackable != null && mediaevent != null && mediaevent.getName().equals(itrackable.getName()))
            {
                ((IMediaTracker)mediaevent).trackMediaMidpoint(itrackable);
            }
            i2++;
        }
        if (true)
        {
            continue; /* Loop/switch isn't completed */
        }
_L11:
        int j2 = 0;
        while (j2 < mediaTrackers.size()) 
        {
            mediaevent = (ITracker)mediaTrackers.get(j2);
            if (itrackable != null && mediaevent != null && mediaevent.getName().equals(itrackable.getName()))
            {
                ((IMediaTracker)mediaevent).trackMediaThirdQuarter(itrackable);
            }
            j2++;
        }
        if (true) goto _L1; else goto _L12
_L12:
        int k2 = 0;
        while (k2 < mediaTrackers.size()) 
        {
            mediaevent = (ITracker)mediaTrackers.get(k2);
            if (itrackable != null && mediaevent != null && mediaevent.getName().equals(itrackable.getName()))
            {
                ((IMediaTracker)mediaevent).trackMediaComplete(itrackable);
            }
            k2++;
        }
        if (true)
        {
            continue; /* Loop/switch isn't completed */
        }
_L13:
        int l2 = 0;
        while (l2 < mediaTrackers.size()) 
        {
            mediaevent = (ITracker)mediaTrackers.get(l2);
            if (itrackable != null && mediaevent != null && mediaevent.getName().equals(itrackable.getName()))
            {
                ((IMediaTracker)mediaevent).trackMediaError(itrackable);
            }
            l2++;
        }
        if (true) goto _L1; else goto _L14
_L14:
        int i3 = 0;
        while (i3 < mediaTrackers.size()) 
        {
            mediaevent = (ITracker)mediaTrackers.get(i3);
            if (itrackable != null && mediaevent != null && mediaevent.getName().equals(itrackable.getName()))
            {
                ((IMediaTracker)mediaevent).trackPing(itrackable);
            }
            i3++;
        }
        if (true) goto _L1; else goto _L15
_L15:
    }

}
