// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package amazon.communication.identity;


public abstract class EndpointIdentity
{
    public static final class Type extends Enum
    {

        private static final Type $VALUES[];
        public static final Type DEVICE;
        public static final Type SERVICE;
        public static final Type URL;

        public static Type valueOf(String s)
        {
            return (Type)Enum.valueOf(amazon/communication/identity/EndpointIdentity$Type, s);
        }

        public static Type[] values()
        {
            return (Type[])$VALUES.clone();
        }

        static 
        {
            DEVICE = new Type("DEVICE", 0);
            SERVICE = new Type("SERVICE", 1);
            URL = new Type("URL", 2);
            $VALUES = (new Type[] {
                DEVICE, SERVICE, URL
            });
        }

        private Type(String s, int i)
        {
            super(s, i);
        }
    }


    protected EndpointIdentity()
    {
    }

    public static String logSafe(EndpointIdentity endpointidentity)
    {
        String s = null;
        if (endpointidentity != null)
        {
            s = endpointidentity.toLogSafeString();
        }
        return s;
    }

    public boolean equals(Object obj)
    {
        if (obj != null)
        {
            String s = toString();
            obj = obj.toString();
            boolean flag;
            boolean flag1;
            if (s == null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (obj == null)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (!(flag1 ^ flag) && (s == null || s.equals(obj)))
            {
                return true;
            }
        }
        return false;
    }

    public abstract Type getType();

    public int hashCode()
    {
        return toString().hashCode();
    }

    public abstract String toLogSafeString();

    public abstract String toString();
}
