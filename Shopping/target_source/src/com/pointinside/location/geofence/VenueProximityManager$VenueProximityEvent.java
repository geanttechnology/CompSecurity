// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.location.geofence;


// Referenced classes of package com.pointinside.location.geofence:
//            VenueProximityManager, VenueProximityState

public static class Type
{
    public static final class Type extends Enum
    {

        private static final Type $VALUES[];
        public static final Type enter;
        public static final Type exit;
        public static final Type update;

        public static Type valueOf(String s)
        {
            return (Type)Enum.valueOf(com/pointinside/location/geofence/VenueProximityManager$VenueProximityEvent$Type, s);
        }

        public static Type[] values()
        {
            return (Type[])$VALUES.clone();
        }

        static 
        {
            exit = new Type("exit", 0);
            enter = new Type("enter", 1);
            update = new Type("update", 2);
            $VALUES = (new Type[] {
                exit, enter, update
            });
        }

        private Type(String s, int i)
        {
            super(s, i);
        }
    }


    public final VenueProximityState state;
    public final Type type;

    private Type(Type type1, VenueProximityState venueproximitystate)
    {
        type = type1;
        state = venueproximitystate;
    }

    Type(Type type1, VenueProximityState venueproximitystate, Type type2)
    {
        this(type1, venueproximitystate);
    }
}
