// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package amazon.communication.identity;

import java.security.SecureRandom;

// Referenced classes of package amazon.communication.identity:
//            EndpointIdentity

public class DeviceIdentity extends EndpointIdentity
{

    private static final int SEED = (new SecureRandom()).nextInt();
    private final String mCustomerId;
    private final String mDeviceAccountId;
    private final String mDeviceSerialNumber;
    private final String mDeviceType;
    private final String mDirectedId;

    DeviceIdentity(String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("Device endpoint must not be null.");
        }
        String as[] = s.split(":");
        if (!hasValidHeader(as))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Device endpoint URN is not valid: ").append(s).toString());
        }
        if (isDeviceOnlyEndpoint(as))
        {
            mDeviceAccountId = null;
            mCustomerId = null;
            mDirectedId = null;
            mDeviceType = as[4];
            mDeviceSerialNumber = as[6];
            return;
        }
        if (isLegacyCustomerDeviceEndpoint(as))
        {
            mDeviceAccountId = as[4];
            mCustomerId = as[6];
            mDirectedId = null;
            mDeviceType = as[8];
            mDeviceSerialNumber = as[10];
            return;
        }
        if (isNewCustomerDeviceEndpoint(as))
        {
            mDeviceAccountId = null;
            mCustomerId = as[4];
            mDirectedId = null;
            mDeviceType = as[6];
            mDeviceSerialNumber = as[8];
            return;
        }
        if (isDirectedIdDeviceEndpoint(as))
        {
            mDeviceAccountId = null;
            mCustomerId = null;
            mDirectedId = as[4];
            mDeviceType = as[6];
            mDeviceSerialNumber = as[8];
            return;
        } else
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Device endpoint URN is not valid: ").append(s).toString());
        }
    }

    private static boolean hasValidHeader(String as[])
    {
        return as.length >= 3 && as[2].equals("device") && as[1].equals("tcomm-endpoint") && as[0].equals("urn");
    }

    private static boolean isDeviceOnlyEndpoint(String as[])
    {
        return as.length == 7 && as[3].equals("deviceType") && !as[4].equals("") && as[5].equals("deviceSerialNumber") && !as[6].equals("");
    }

    private static boolean isDirectedIdDeviceEndpoint(String as[])
    {
        return as.length == 9 && as[3].equals("directedId") && !as[4].equals("") && as[5].equals("deviceType") && !as[6].equals("") && as[7].equals("deviceSerialNumber") && !as[8].equals("");
    }

    private static boolean isLegacyCustomerDeviceEndpoint(String as[])
    {
        return as.length == 11 && as[3].equals("deviceAccountId") && !as[4].equals("") && as[5].equals("customerId") && !as[6].equals("") && as[7].equals("deviceType") && !as[8].equals("") && as[9].equals("deviceSerialNumber") && !as[10].equals("");
    }

    private static boolean isNewCustomerDeviceEndpoint(String as[])
    {
        return as.length == 9 && as[3].equals("customerId") && !as[4].equals("") && as[5].equals("deviceType") && !as[6].equals("") && as[7].equals("deviceSerialNumber") && !as[8].equals("");
    }

    public static boolean matchesUrn(String s)
    {
        s = s.split(":");
        return hasValidHeader(s) && (isDeviceOnlyEndpoint(s) || isLegacyCustomerDeviceEndpoint(s) || isNewCustomerDeviceEndpoint(s) || isDirectedIdDeviceEndpoint(s));
    }

    public String getCustomerId()
    {
        return mCustomerId;
    }

    public String getDeviceSerialNumber()
    {
        return mDeviceSerialNumber;
    }

    public String getDeviceType()
    {
        return mDeviceType;
    }

    public String getDirectedId()
    {
        return mDirectedId;
    }

    public String toLogSafeString()
    {
        int j = "urn:tcomm-endpoint:device".length() + ":".length() + "deviceType".length() + ":".length() + getDeviceType().length() + ":".length() + "deviceSerialNumber".length() + ":".length() + String.valueOf(SEED + getDeviceSerialNumber().hashCode()).length();
        int i = j;
        if (getCustomerId() != null)
        {
            i = j + (":".length() + "customerId".length() + ":".length() + String.valueOf(SEED + getCustomerId().hashCode()).length());
        }
        j = i;
        if (getDirectedId() != null)
        {
            j = i + (":".length() + "directedId".length() + ":".length() + String.valueOf(SEED + getDirectedId().hashCode()).length());
        }
        StringBuilder stringbuilder = new StringBuilder(j);
        stringbuilder.append("urn:tcomm-endpoint:device");
        if (getCustomerId() != null)
        {
            stringbuilder.append(":").append("customerId").append(":").append(SEED + getCustomerId().hashCode());
        }
        if (getDirectedId() != null)
        {
            stringbuilder.append(":").append("directedId").append(":").append(SEED + getDirectedId().hashCode());
        }
        stringbuilder.append(":").append("deviceType").append(":").append(getDeviceType());
        stringbuilder.append(":").append("deviceSerialNumber").append(":").append(SEED + getDeviceSerialNumber().hashCode());
        return stringbuilder.toString();
    }

    public String toString()
    {
        int j = "urn:tcomm-endpoint:device".length() + ":".length() + "deviceType".length() + ":".length() + getDeviceType().length() + ":".length() + "deviceSerialNumber".length() + ":".length() + getDeviceSerialNumber().length();
        int i = j;
        if (getCustomerId() != null)
        {
            i = j + (":".length() + "customerId".length() + ":".length() + getCustomerId().length());
        }
        j = i;
        if (getDirectedId() != null)
        {
            j = i + (":".length() + "directedId".length() + ":".length() + getDirectedId().length());
        }
        StringBuilder stringbuilder = new StringBuilder(j);
        stringbuilder.append("urn:tcomm-endpoint:device");
        if (getCustomerId() != null)
        {
            stringbuilder.append(":").append("customerId").append(":").append(getCustomerId());
        }
        if (getDirectedId() != null)
        {
            stringbuilder.append(":").append("directedId").append(":").append(getDirectedId());
        }
        stringbuilder.append(":").append("deviceType").append(":").append(getDeviceType());
        stringbuilder.append(":").append("deviceSerialNumber").append(":").append(getDeviceSerialNumber());
        return stringbuilder.toString();
    }

}
