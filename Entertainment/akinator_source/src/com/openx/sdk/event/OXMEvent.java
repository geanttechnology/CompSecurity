// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.openx.sdk.event;


public class OXMEvent
{
    public static final class OXMEventType extends Enum
    {

        private static final OXMEventType $VALUES[];
        public static final OXMEventType ACTION_HAS_BEGAN;
        public static final OXMEventType ACTION_HAS_DONE;
        public static final OXMEventType CLOSE_ACTIVE_INTERNAL_WINDOW;
        public static final OXMEventType CONFIGURATION_CHANGED;
        public static final OXMEventType INTERSTITIAL_WINDOW_CLOSED;
        public static final OXMEventType LOG;
        public static final OXMEventType ORIENTATION_PROPERTIES_CHANGED;

        public static OXMEventType valueOf(String s)
        {
            return (OXMEventType)Enum.valueOf(com/openx/sdk/event/OXMEvent$OXMEventType, s);
        }

        public static OXMEventType[] values()
        {
            return (OXMEventType[])$VALUES.clone();
        }

        static 
        {
            INTERSTITIAL_WINDOW_CLOSED = new OXMEventType("INTERSTITIAL_WINDOW_CLOSED", 0);
            CLOSE_ACTIVE_INTERNAL_WINDOW = new OXMEventType("CLOSE_ACTIVE_INTERNAL_WINDOW", 1);
            ACTION_HAS_BEGAN = new OXMEventType("ACTION_HAS_BEGAN", 2);
            ACTION_HAS_DONE = new OXMEventType("ACTION_HAS_DONE", 3);
            CONFIGURATION_CHANGED = new OXMEventType("CONFIGURATION_CHANGED", 4);
            ORIENTATION_PROPERTIES_CHANGED = new OXMEventType("ORIENTATION_PROPERTIES_CHANGED", 5);
            LOG = new OXMEventType("LOG", 6);
            $VALUES = (new OXMEventType[] {
                INTERSTITIAL_WINDOW_CLOSED, CLOSE_ACTIVE_INTERNAL_WINDOW, ACTION_HAS_BEGAN, ACTION_HAS_DONE, CONFIGURATION_CHANGED, ORIENTATION_PROPERTIES_CHANGED, LOG
            });
        }

        private OXMEventType(String s, int i)
        {
            super(s, i);
        }
    }


    private Object mArgs;
    private OXMEventType mEventType;
    private Object mSender;

    public OXMEvent(OXMEventType oxmeventtype, Object obj, Object obj1)
    {
        mEventType = oxmeventtype;
        mSender = obj;
        mArgs = obj1;
    }

    public Object getArgs()
    {
        return mArgs;
    }

    public OXMEventType getEventType()
    {
        return mEventType;
    }

    public Object getSender()
    {
        return mSender;
    }
}
