// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.event.factory;

import com.shazam.android.analytics.event.Event;
import com.shazam.model.analytics.BeaconEventKey;
import com.shazam.model.analytics.event.DefinedEventParameterKey;

public class WidgetEventFactory
{
    public static final class WidgetEventAction extends Enum
    {

        private static final WidgetEventAction $VALUES[];
        public static final WidgetEventAction ADDED;
        public static final WidgetEventAction PRESSED;
        public static final WidgetEventAction REMOVED;
        private final String action;

        public static WidgetEventAction valueOf(String s)
        {
            return (WidgetEventAction)Enum.valueOf(com/shazam/android/analytics/event/factory/WidgetEventFactory$WidgetEventAction, s);
        }

        public static WidgetEventAction[] values()
        {
            return (WidgetEventAction[])$VALUES.clone();
        }

        public final String getAction()
        {
            return action;
        }

        static 
        {
            ADDED = new WidgetEventAction("ADDED", 0, "added");
            PRESSED = new WidgetEventAction("PRESSED", 1, "pressed");
            REMOVED = new WidgetEventAction("REMOVED", 2, "removed");
            $VALUES = (new WidgetEventAction[] {
                ADDED, PRESSED, REMOVED
            });
        }

        private WidgetEventAction(String s, int i, String s1)
        {
            super(s, i);
            action = s1;
        }
    }


    public WidgetEventFactory()
    {
    }

    public static Event createWidgetEvent(WidgetEventAction widgeteventaction)
    {
        widgeteventaction = com.shazam.android.analytics.event.EventParameters.Builder.eventParameters().putNotEmptyOrNullParameter(DefinedEventParameterKey.TYPE, "widget").putNotEmptyOrNullParameter(DefinedEventParameterKey.ACTION, widgeteventaction.getAction()).build();
        return com.shazam.android.analytics.event.Event.Builder.anEvent().withEventType(BeaconEventKey.USER_EVENT).withParameters(widgeteventaction).build();
    }
}
