// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.web.bridge.command.data;

import com.google.b.j;
import com.google.b.k;
import com.google.b.l;
import com.google.b.r;
import java.lang.reflect.Type;

public class ScrollToCommandData
{
    public static final class Position extends Enum
    {

        private static final Position $VALUES[];
        public static final Position BOTTOM;
        public static final Position TOP;
        private final String stringValue;

        public static Position fromStringValue(String s)
        {
            Position aposition[] = values();
            int j = aposition.length;
            for (int i = 0; i < j; i++)
            {
                Position position1 = aposition[i];
                if (position1.stringValue.equals(s))
                {
                    return position1;
                }
            }

            return null;
        }

        public static Position valueOf(String s)
        {
            return (Position)Enum.valueOf(com/shazam/android/web/bridge/command/data/ScrollToCommandData$Position, s);
        }

        public static Position[] values()
        {
            return (Position[])$VALUES.clone();
        }

        static 
        {
            TOP = new Position("TOP", 0, "top");
            BOTTOM = new Position("BOTTOM", 1, "bottom");
            $VALUES = (new Position[] {
                TOP, BOTTOM
            });
        }

        private Position(String s, int i, String s1)
        {
            super(s, i);
            stringValue = s1;
        }
    }

    public static class Position.Deserializer
        implements k
    {

        public Position deserialize(l l1, Type type, j j)
        {
            return Position.fromStringValue(l1.h().b());
        }

        public volatile Object deserialize(l l1, Type type, j j)
        {
            return deserialize(l1, type, j);
        }

        public Position.Deserializer()
        {
        }
    }


    private Position position;

    private ScrollToCommandData()
    {
    }

    public ScrollToCommandData(String s)
    {
        position = Position.fromStringValue(s);
    }

    public Position getPosition()
    {
        return position;
    }

    public String toString()
    {
        return (new StringBuilder("ScrollToCommandData{position=")).append(position).append('}').toString();
    }
}
