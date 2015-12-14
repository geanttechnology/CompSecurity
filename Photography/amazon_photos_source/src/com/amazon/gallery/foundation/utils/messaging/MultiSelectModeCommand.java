// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.utils.messaging;


public class MultiSelectModeCommand
{
    public static final class EntranceType extends Enum
    {

        private static final EntranceType $VALUES[];
        public static final EntranceType BACK;
        public static final EntranceType BUTTON;
        public static final EntranceType TAP;

        public static EntranceType valueOf(String s)
        {
            return (EntranceType)Enum.valueOf(com/amazon/gallery/foundation/utils/messaging/MultiSelectModeCommand$EntranceType, s);
        }

        public static EntranceType[] values()
        {
            return (EntranceType[])$VALUES.clone();
        }

        static 
        {
            TAP = new EntranceType("TAP", 0);
            BUTTON = new EntranceType("BUTTON", 1);
            BACK = new EntranceType("BACK", 2);
            $VALUES = (new EntranceType[] {
                TAP, BUTTON, BACK
            });
        }

        private EntranceType(String s, int i)
        {
            super(s, i);
        }
    }


    public final boolean enabled;
    public final EntranceType entrance;

    public MultiSelectModeCommand(boolean flag, EntranceType entrancetype)
    {
        enabled = flag;
        entrance = entrancetype;
    }
}
