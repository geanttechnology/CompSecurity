// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.location.geofence;

import android.content.Context;
import android.content.Intent;
import android.location.Location;

// Referenced classes of package com.pointinside.location.geofence:
//            LocationReceiver, VenueProximityService, VenueProximityState, VenueProximityCache

public class VenueProximityManager
{
    private static final class ACTIONS extends Enum
    {

        private static final ACTIONS $VALUES[];
        public static final ACTIONS START_SERVICE;
        public static final ACTIONS STOP_SERVICE;

        public static ACTIONS valueOf(String s)
        {
            return (ACTIONS)Enum.valueOf(com/pointinside/location/geofence/VenueProximityManager$ACTIONS, s);
        }

        public static ACTIONS[] values()
        {
            return (ACTIONS[])$VALUES.clone();
        }

        static 
        {
            START_SERVICE = new ACTIONS("START_SERVICE", 0);
            STOP_SERVICE = new ACTIONS("STOP_SERVICE", 1);
            $VALUES = (new ACTIONS[] {
                START_SERVICE, STOP_SERVICE
            });
        }

        private ACTIONS(String s, int i)
        {
            super(s, i);
        }
    }

    static class IntentBuilder
    {

        private int duration;
        private int interval;
        private String pkgName;
        private ACTIONS type;

        public Intent build()
        {
            static class _cls1
            {

                static final int $SwitchMap$com$pointinside$location$geofence$VenueProximityManager$ACTIONS[];

                static 
                {
                    $SwitchMap$com$pointinside$location$geofence$VenueProximityManager$ACTIONS = new int[ACTIONS.values().length];
                    try
                    {
                        $SwitchMap$com$pointinside$location$geofence$VenueProximityManager$ACTIONS[ACTIONS.START_SERVICE.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        $SwitchMap$com$pointinside$location$geofence$VenueProximityManager$ACTIONS[ACTIONS.STOP_SERVICE.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            switch (_cls1..SwitchMap.com.pointinside.location.geofence.VenueProximityManager.ACTIONS[type.ordinal()])
            {
            default:
                return null;

            case 1: // '\001'
                return VenueProximityService.getStartIntent(pkgName, interval, duration);

            case 2: // '\002'
                return VenueProximityService.getStopIntent(pkgName);
            }
        }

        public IntentBuilder setDuration(int i)
        {
            duration = i;
            return this;
        }

        public IntentBuilder setInterval(int i)
        {
            interval = i;
            return this;
        }

        public IntentBuilder setPkgName(String s)
        {
            pkgName = new String(s);
            return this;
        }

        public IntentBuilder setType(ACTIONS actions)
        {
            type = actions;
            return this;
        }

        IntentBuilder()
        {
            interval = 0x80000000;
            duration = 0x80000000;
        }
    }

    public static interface LocationListener
    {

        public abstract void onNewLocation(Location location);
    }

    public static class VenueProximityEvent
    {

        public final VenueProximityState state;
        public final Type type;

        private VenueProximityEvent(Type type1, VenueProximityState venueproximitystate)
        {
            type = type1;
            state = venueproximitystate;
        }

    }

    public static final class VenueProximityEvent.Type extends Enum
    {

        private static final VenueProximityEvent.Type $VALUES[];
        public static final VenueProximityEvent.Type enter;
        public static final VenueProximityEvent.Type exit;
        public static final VenueProximityEvent.Type update;

        public static VenueProximityEvent.Type valueOf(String s)
        {
            return (VenueProximityEvent.Type)Enum.valueOf(com/pointinside/location/geofence/VenueProximityManager$VenueProximityEvent$Type, s);
        }

        public static VenueProximityEvent.Type[] values()
        {
            return (VenueProximityEvent.Type[])$VALUES.clone();
        }

        static 
        {
            exit = new VenueProximityEvent.Type("exit", 0);
            enter = new VenueProximityEvent.Type("enter", 1);
            update = new VenueProximityEvent.Type("update", 2);
            $VALUES = (new VenueProximityEvent.Type[] {
                exit, enter, update
            });
        }

        private VenueProximityEvent.Type(String s, int i)
        {
            super(s, i);
        }
    }

    static class VenueProximityEventBuilder
    {

        private VenueProximityState s;
        private VenueProximityEvent.Type t;

        VenueProximityEvent build()
        {
            return new VenueProximityEvent(t, s, null);
        }

        VenueProximityEventBuilder setState(VenueProximityState venueproximitystate)
        {
            s = venueproximitystate;
            return this;
        }

        VenueProximityEventBuilder setType(VenueProximityEvent.Type type)
        {
            t = type;
            return this;
        }

        VenueProximityEventBuilder()
        {
            s = VenueProximityCache.getState();
            t = VenueProximityEvent.Type.update;
        }
    }

    public static interface VenueProximityListener
    {

        public abstract void onVenueProximityEvent(VenueProximityEvent venueproximityevent);
    }


    private VenueProximityManager()
    {
    }

    public static void addListener(LocationListener locationlistener)
    {
        LocationReceiver.addListener(locationlistener);
    }

    public static void addListener(VenueProximityListener venueproximitylistener)
    {
        LocationReceiver.addListener(venueproximitylistener);
    }

    public static void clearLocationListeners()
    {
        LocationReceiver.clearLocaitonListeners();
    }

    public static void clearVenueListeners()
    {
        LocationReceiver.clearVenueListeners();
    }

    static IntentBuilder getIntentBuilder(String s, ACTIONS actions)
    {
        IntentBuilder intentbuilder = new IntentBuilder();
        intentbuilder.setPkgName(s).setType(actions);
        return intentbuilder;
    }

    public static void removeLocationListener(LocationListener locationlistener)
    {
        LocationReceiver.removeLocationListener(locationlistener);
    }

    public static void removeVenueListener(VenueProximityListener venueproximitylistener)
    {
        LocationReceiver.removeVenueListener(venueproximitylistener);
    }

    public static void startService(Context context)
    {
        context.startService(getIntentBuilder(context.getPackageName(), ACTIONS.START_SERVICE).build());
    }

    public static void stopService(Context context)
    {
        LocationReceiver.clearLocaitonListeners();
        LocationReceiver.clearVenueListeners();
        context.startService(getIntentBuilder(context.getPackageName(), ACTIONS.STOP_SERVICE).build());
    }
}
