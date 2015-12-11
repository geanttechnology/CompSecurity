// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.web.bridge.command.data;

import com.google.b.j;
import com.google.b.k;
import com.google.b.l;
import com.google.b.r;
import com.google.b.s;
import com.google.b.t;
import java.lang.reflect.Type;

// Referenced classes of package com.shazam.android.web.bridge.command.data:
//            NewWebViewData

public static final class stringValue extends Enum
{
    public static class Deserializer
        implements k
    {

        public NewWebViewData.ViewType deserialize(l l1, Type type, j j)
        {
            return NewWebViewData.ViewType.fromString(l1.h().b());
        }

        public volatile Object deserialize(l l1, Type type, j j)
        {
            return deserialize(l1, type, j);
        }

        public Deserializer()
        {
        }
    }

    public static class Serializer
        implements t
    {

        public l serialize(NewWebViewData.ViewType viewtype, Type type, s s)
        {
            return new r(viewtype.getStringValue());
        }

        public volatile l serialize(Object obj, Type type, s s)
        {
            return serialize((NewWebViewData.ViewType)obj, type, s);
        }

        public Serializer()
        {
        }
    }


    private static final COMMENTS $VALUES[];
    public static final COMMENTS COMMENTS;
    private final String stringValue;

    public static Serializer.serialize fromString(String s)
    {
        Serializer.serialize aserialize[] = values();
        int j = aserialize.length;
        for (int i = 0; i < j; i++)
        {
            Serializer.serialize serialize = aserialize[i];
            if (serialize.stringValue.equals(s))
            {
                return serialize;
            }
        }

        return null;
    }

    public static stringValue valueOf(String s)
    {
        return (stringValue)Enum.valueOf(com/shazam/android/web/bridge/command/data/NewWebViewData$ViewType, s);
    }

    public static stringValue[] values()
    {
        return (stringValue[])$VALUES.clone();
    }

    public final String getStringValue()
    {
        return stringValue;
    }

    static 
    {
        COMMENTS = new <init>("COMMENTS", 0, "comments");
        $VALUES = (new .VALUES[] {
            COMMENTS
        });
    }

    private Serializer(String s, int i, String s1)
    {
        super(s, i);
        stringValue = s1;
    }
}
