// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.utils.messaging;


public class ActionCompleteEvent
{
    public static final class ActionSource extends Enum
    {

        private static final ActionSource $VALUES[];
        public static final ActionSource DELETE;

        public static ActionSource valueOf(String s)
        {
            return (ActionSource)Enum.valueOf(com/amazon/gallery/foundation/utils/messaging/ActionCompleteEvent$ActionSource, s);
        }

        public static ActionSource[] values()
        {
            return (ActionSource[])$VALUES.clone();
        }

        static 
        {
            DELETE = new ActionSource("DELETE", 0);
            $VALUES = (new ActionSource[] {
                DELETE
            });
        }

        private ActionSource(String s, int i)
        {
            super(s, i);
        }
    }


    public final ActionSource actionSource;

    public ActionCompleteEvent()
    {
        actionSource = null;
    }

    public ActionCompleteEvent(ActionSource actionsource)
    {
        actionSource = actionsource;
    }
}
