// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package amazon.communication.identity;


public abstract class EndpointIdentity
{

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

    public int hashCode()
    {
        return toString().hashCode();
    }

    public abstract String toLogSafeString();

    public abstract String toString();
}
