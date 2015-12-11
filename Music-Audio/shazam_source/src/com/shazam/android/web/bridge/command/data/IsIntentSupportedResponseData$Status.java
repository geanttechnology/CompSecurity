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
//            IsIntentSupportedResponseData

public static final class jsonString extends Enum
{
    public static class Deserializer
        implements k
    {

        public IsIntentSupportedResponseData.Status deserialize(l l1, Type type, j j)
        {
            l1 = l1.h().b();
            type = IsIntentSupportedResponseData.Status.values();
            int i1 = type.length;
            for (int i = 0; i < i1; i++)
            {
                j = type[i];
                if (((IsIntentSupportedResponseData.Status) (j)).jsonString.equals(l1))
                {
                    return j;
                }
            }

            return IsIntentSupportedResponseData.Status.UNSUPPORTED;
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

        public l serialize(IsIntentSupportedResponseData.Status status, Type type, s s)
        {
            return new r(status.getJsonString());
        }

        public volatile l serialize(Object obj, Type type, s s)
        {
            return serialize((IsIntentSupportedResponseData.Status)obj, type, s);
        }

        public Serializer()
        {
        }
    }


    private static final UNSUPPORTED $VALUES[];
    public static final UNSUPPORTED SUPPORTED;
    public static final UNSUPPORTED UNSUPPORTED;
    private final String jsonString;

    public static Serializer.serialize valueOf(String s)
    {
        return (Serializer.serialize)Enum.valueOf(com/shazam/android/web/bridge/command/data/IsIntentSupportedResponseData$Status, s);
    }

    public static Serializer.serialize[] values()
    {
        return (Serializer.serialize[])$VALUES.clone();
    }

    public final String getJsonString()
    {
        return jsonString;
    }

    static 
    {
        SUPPORTED = new <init>("SUPPORTED", 0, "supported");
        UNSUPPORTED = new <init>("UNSUPPORTED", 1, "unsupported");
        $VALUES = (new .VALUES[] {
            SUPPORTED, UNSUPPORTED
        });
    }


    private Serializer(String s, int i, String s1)
    {
        super(s, i);
        jsonString = s1;
    }
}
