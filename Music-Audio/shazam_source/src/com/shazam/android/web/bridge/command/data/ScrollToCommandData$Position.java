// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.web.bridge.command.data;

import com.google.b.j;
import com.google.b.k;
import com.google.b.l;
import com.google.b.r;
import java.lang.reflect.Type;

// Referenced classes of package com.shazam.android.web.bridge.command.data:
//            ScrollToCommandData

public static final class stringValue extends Enum
{
    public static class Deserializer
        implements k
    {

        public ScrollToCommandData.Position deserialize(l l1, Type type, j j)
        {
            return ScrollToCommandData.Position.fromStringValue(l1.h().b());
        }

        public volatile Object deserialize(l l1, Type type, j j)
        {
            return deserialize(l1, type, j);
        }

        public Deserializer()
        {
        }
    }


    private static final BOTTOM $VALUES[];
    public static final BOTTOM BOTTOM;
    public static final BOTTOM TOP;
    private final String stringValue;

    public static Deserializer.deserialize fromStringValue(String s)
    {
        Deserializer.deserialize adeserialize[] = values();
        int j = adeserialize.length;
        for (int i = 0; i < j; i++)
        {
            Deserializer.deserialize deserialize = adeserialize[i];
            if (deserialize.stringValue.equals(s))
            {
                return deserialize;
            }
        }

        return null;
    }

    public static stringValue valueOf(String s)
    {
        return (stringValue)Enum.valueOf(com/shazam/android/web/bridge/command/data/ScrollToCommandData$Position, s);
    }

    public static stringValue[] values()
    {
        return (stringValue[])$VALUES.clone();
    }

    static 
    {
        TOP = new <init>("TOP", 0, "top");
        BOTTOM = new <init>("BOTTOM", 1, "bottom");
        $VALUES = (new .VALUES[] {
            TOP, BOTTOM
        });
    }

    private Deserializer(String s, int i, String s1)
    {
        super(s, i);
        stringValue = s1;
    }
}
