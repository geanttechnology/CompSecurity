// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.drawee.components;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class DraweeEventTracker
{
    public static final class Event extends Enum
    {

        private static final Event $VALUES[];
        public static final Event ON_ACTIVITY_START;
        public static final Event ON_ACTIVITY_STOP;
        public static final Event ON_ATTACH_CONTROLLER;
        public static final Event ON_CLEAR_CONTROLLER;
        public static final Event ON_CLEAR_HIERARCHY;
        public static final Event ON_CLEAR_OLD_CONTROLLER;
        public static final Event ON_DATASOURCE_FAILURE;
        public static final Event ON_DATASOURCE_FAILURE_INT;
        public static final Event ON_DATASOURCE_RESULT;
        public static final Event ON_DATASOURCE_RESULT_INT;
        public static final Event ON_DATASOURCE_SUBMIT;
        public static final Event ON_DETACH_CONTROLLER;
        public static final Event ON_DRAWABLE_HIDE;
        public static final Event ON_DRAWABLE_SHOW;
        public static final Event ON_HOLDER_ATTACH;
        public static final Event ON_HOLDER_DETACH;
        public static final Event ON_INIT_CONTROLLER;
        public static final Event ON_RELEASE_CONTROLLER;
        public static final Event ON_SET_CONTROLLER;
        public static final Event ON_SET_HIERARCHY;

        public static Event valueOf(String s)
        {
            return (Event)Enum.valueOf(com/facebook/drawee/components/DraweeEventTracker$Event, s);
        }

        public static Event[] values()
        {
            return (Event[])$VALUES.clone();
        }

        static 
        {
            ON_SET_HIERARCHY = new Event("ON_SET_HIERARCHY", 0);
            ON_CLEAR_HIERARCHY = new Event("ON_CLEAR_HIERARCHY", 1);
            ON_SET_CONTROLLER = new Event("ON_SET_CONTROLLER", 2);
            ON_CLEAR_OLD_CONTROLLER = new Event("ON_CLEAR_OLD_CONTROLLER", 3);
            ON_CLEAR_CONTROLLER = new Event("ON_CLEAR_CONTROLLER", 4);
            ON_INIT_CONTROLLER = new Event("ON_INIT_CONTROLLER", 5);
            ON_ATTACH_CONTROLLER = new Event("ON_ATTACH_CONTROLLER", 6);
            ON_DETACH_CONTROLLER = new Event("ON_DETACH_CONTROLLER", 7);
            ON_RELEASE_CONTROLLER = new Event("ON_RELEASE_CONTROLLER", 8);
            ON_DATASOURCE_SUBMIT = new Event("ON_DATASOURCE_SUBMIT", 9);
            ON_DATASOURCE_RESULT = new Event("ON_DATASOURCE_RESULT", 10);
            ON_DATASOURCE_RESULT_INT = new Event("ON_DATASOURCE_RESULT_INT", 11);
            ON_DATASOURCE_FAILURE = new Event("ON_DATASOURCE_FAILURE", 12);
            ON_DATASOURCE_FAILURE_INT = new Event("ON_DATASOURCE_FAILURE_INT", 13);
            ON_HOLDER_ATTACH = new Event("ON_HOLDER_ATTACH", 14);
            ON_HOLDER_DETACH = new Event("ON_HOLDER_DETACH", 15);
            ON_DRAWABLE_SHOW = new Event("ON_DRAWABLE_SHOW", 16);
            ON_DRAWABLE_HIDE = new Event("ON_DRAWABLE_HIDE", 17);
            ON_ACTIVITY_START = new Event("ON_ACTIVITY_START", 18);
            ON_ACTIVITY_STOP = new Event("ON_ACTIVITY_STOP", 19);
            $VALUES = (new Event[] {
                ON_SET_HIERARCHY, ON_CLEAR_HIERARCHY, ON_SET_CONTROLLER, ON_CLEAR_OLD_CONTROLLER, ON_CLEAR_CONTROLLER, ON_INIT_CONTROLLER, ON_ATTACH_CONTROLLER, ON_DETACH_CONTROLLER, ON_RELEASE_CONTROLLER, ON_DATASOURCE_SUBMIT, 
                ON_DATASOURCE_RESULT, ON_DATASOURCE_RESULT_INT, ON_DATASOURCE_FAILURE, ON_DATASOURCE_FAILURE_INT, ON_HOLDER_ATTACH, ON_HOLDER_DETACH, ON_DRAWABLE_SHOW, ON_DRAWABLE_HIDE, ON_ACTIVITY_START, ON_ACTIVITY_STOP
            });
        }

        private Event(String s, int i)
        {
            super(s, i);
        }
    }


    private static final int MAX_EVENTS_TO_TRACK = 20;
    private final Queue mEventQueue = new ArrayBlockingQueue(20);

    public DraweeEventTracker()
    {
    }

    public void recordEvent(Event event)
    {
        if (mEventQueue.size() + 1 > 20)
        {
            mEventQueue.poll();
        }
        mEventQueue.add(event);
    }

    public String toString()
    {
        return mEventQueue.toString();
    }
}
