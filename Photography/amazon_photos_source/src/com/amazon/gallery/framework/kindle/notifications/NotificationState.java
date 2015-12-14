// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.notifications;


public final class NotificationState extends Enum
{
    public static final class StateType extends Enum
    {

        private static final StateType $VALUES[];
        public static final StateType ERROR;
        public static final StateType NO_PROGRESS;
        public static final StateType PROGRESS;

        public static StateType valueOf(String s)
        {
            return (StateType)Enum.valueOf(com/amazon/gallery/framework/kindle/notifications/NotificationState$StateType, s);
        }

        public static StateType[] values()
        {
            return (StateType[])$VALUES.clone();
        }

        public boolean isOnGoing()
        {
            return this == PROGRESS;
        }

        static 
        {
            PROGRESS = new StateType("PROGRESS", 0);
            NO_PROGRESS = new StateType("NO_PROGRESS", 1);
            ERROR = new StateType("ERROR", 2);
            $VALUES = (new StateType[] {
                PROGRESS, NO_PROGRESS, ERROR
            });
        }

        private StateType(String s, int i)
        {
            super(s, i);
        }
    }


    private static final NotificationState $VALUES[];
    public static final NotificationState ACTIVE;
    public static final NotificationState CANCELED;
    public static final NotificationState COMPLETE;
    public static final NotificationState LOW_BATTERY;
    public static final NotificationState NO_NETWORK;
    public static final NotificationState NO_SPACE_ALL;
    public static final NotificationState NO_SPACE_PHOTOS;
    public static final NotificationState PAUSED;
    public static final NotificationState UNKNOWN_PROBLEM;
    public static final NotificationState WAITING_FOR_POWER;
    public static final NotificationState WAITING_FOR_WIFI;
    public StateType stateType;

    private NotificationState(String s, int i, StateType statetype)
    {
        super(s, i);
        stateType = statetype;
    }

    public static NotificationState valueOf(String s)
    {
        return (NotificationState)Enum.valueOf(com/amazon/gallery/framework/kindle/notifications/NotificationState, s);
    }

    public static NotificationState[] values()
    {
        return (NotificationState[])$VALUES.clone();
    }

    static 
    {
        ACTIVE = new NotificationState("ACTIVE", 0, StateType.PROGRESS);
        PAUSED = new NotificationState("PAUSED", 1, StateType.PROGRESS);
        CANCELED = new NotificationState("CANCELED", 2, StateType.NO_PROGRESS);
        NO_SPACE_PHOTOS = new NotificationState("NO_SPACE_PHOTOS", 3, StateType.NO_PROGRESS);
        NO_SPACE_ALL = new NotificationState("NO_SPACE_ALL", 4, StateType.NO_PROGRESS);
        NO_NETWORK = new NotificationState("NO_NETWORK", 5, StateType.NO_PROGRESS);
        WAITING_FOR_WIFI = new NotificationState("WAITING_FOR_WIFI", 6, StateType.NO_PROGRESS);
        WAITING_FOR_POWER = new NotificationState("WAITING_FOR_POWER", 7, StateType.NO_PROGRESS);
        LOW_BATTERY = new NotificationState("LOW_BATTERY", 8, StateType.NO_PROGRESS);
        COMPLETE = new NotificationState("COMPLETE", 9, StateType.NO_PROGRESS);
        UNKNOWN_PROBLEM = new NotificationState("UNKNOWN_PROBLEM", 10, StateType.ERROR);
        $VALUES = (new NotificationState[] {
            ACTIVE, PAUSED, CANCELED, NO_SPACE_PHOTOS, NO_SPACE_ALL, NO_NETWORK, WAITING_FOR_WIFI, WAITING_FOR_POWER, LOW_BATTERY, COMPLETE, 
            UNKNOWN_PROBLEM
        });
    }
}
