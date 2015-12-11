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

public class IsIntentSupportedResponseData
{
    public static final class Status extends Enum
    {

        private static final Status $VALUES[];
        public static final Status SUPPORTED;
        public static final Status UNSUPPORTED;
        private final String jsonString;

        public static Status valueOf(String s)
        {
            return (Status)Enum.valueOf(com/shazam/android/web/bridge/command/data/IsIntentSupportedResponseData$Status, s);
        }

        public static Status[] values()
        {
            return (Status[])$VALUES.clone();
        }

        public final String getJsonString()
        {
            return jsonString;
        }

        static 
        {
            SUPPORTED = new Status("SUPPORTED", 0, "supported");
            UNSUPPORTED = new Status("UNSUPPORTED", 1, "unsupported");
            $VALUES = (new Status[] {
                SUPPORTED, UNSUPPORTED
            });
        }


        private Status(String s, int i, String s1)
        {
            super(s, i);
            jsonString = s1;
        }
    }

    public static class Status.Deserializer
        implements k
    {

        public Status deserialize(l l1, Type type, j j)
        {
            l1 = l1.h().b();
            type = Status.values();
            int i1 = type.length;
            for (int i = 0; i < i1; i++)
            {
                j = type[i];
                if (((Status) (j)).jsonString.equals(l1))
                {
                    return j;
                }
            }

            return Status.UNSUPPORTED;
        }

        public volatile Object deserialize(l l1, Type type, j j)
        {
            return deserialize(l1, type, j);
        }

        public Status.Deserializer()
        {
        }
    }

    public static class Status.Serializer
        implements t
    {

        public l serialize(Status status1, Type type, s s)
        {
            return new r(status1.getJsonString());
        }

        public volatile l serialize(Object obj, Type type, s s)
        {
            return serialize((Status)obj, type, s);
        }

        public Status.Serializer()
        {
        }
    }


    private String intentString;
    private Status status;

    private IsIntentSupportedResponseData()
    {
    }

    public IsIntentSupportedResponseData(String s, Status status1)
    {
        intentString = s;
        status = status1;
    }

    public String getIntent()
    {
        return intentString;
    }

    public Status getStatus()
    {
        return status;
    }
}
