// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.utils.messaging;

import com.amazon.gallery.framework.model.media.MediaItem;

public class CabMediaItemEvent
{
    public static final class Action extends Enum
    {

        private static final Action $VALUES[];
        public static final Action ADD;
        public static final Action REMOVE;

        public static Action valueOf(String s)
        {
            return (Action)Enum.valueOf(com/amazon/gallery/framework/gallery/utils/messaging/CabMediaItemEvent$Action, s);
        }

        public static Action[] values()
        {
            return (Action[])$VALUES.clone();
        }

        static 
        {
            ADD = new Action("ADD", 0);
            REMOVE = new Action("REMOVE", 1);
            $VALUES = (new Action[] {
                ADD, REMOVE
            });
        }

        private Action(String s, int i)
        {
            super(s, i);
        }
    }


    public Action action;
    public MediaItem mediaItem;

    public CabMediaItemEvent(Action action1, MediaItem mediaitem)
    {
        action = action1;
        mediaItem = mediaitem;
    }
}
