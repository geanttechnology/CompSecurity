// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package amazon.communication.identity;

import com.amazon.dp.logger.DPLogger;

// Referenced classes of package amazon.communication.identity:
//            EndpointIdentity

public class ServiceIdentity extends EndpointIdentity
{

    private static final DPLogger log = new DPLogger("TComm.ServiceIdentity");
    private String mDomain;
    private String mHostname;
    private Integer mPort;
    private String mRealm;
    private final String mServiceName;

    ServiceIdentity(String s)
    {
        if (!matchesUrn(s))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("ServiceIdentity urn is invalid: ").append(s).toString());
        }
        Object obj = s.split(":");
        if (obj.length < 5)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Too few fields in service urn ").append(s).toString());
        }
        if (obj.length % 2 == 0)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Expecting odd number of fields in service urn: ").append(s).toString());
        }
        if (!"serviceName".equals(obj[3]))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Expecting first field in urn to be serviceName, urn: ").append(s).toString());
        }
        mServiceName = obj[4].trim();
        if ("".equals(mServiceName))
        {
            throw new IllegalArgumentException("serviceName field is empty");
        }
        int i = 5;
        while (i < obj.length) 
        {
            if ("domain".equals(obj[i]))
            {
                mDomain = obj[i + 1].trim();
                if ("".equals(mDomain))
                {
                    throw new IllegalArgumentException("domain field is empty");
                }
                continue;
            }
            if ("realm".equals(obj[i]))
            {
                mRealm = obj[i + 1].trim();
                if ("".equals(mRealm))
                {
                    throw new IllegalArgumentException("realm field is empty");
                }
                continue;
            }
            if ("hostname".equals(obj[i]))
            {
                mHostname = obj[i + 1].trim();
                if ("".equals(mHostname))
                {
                    throw new IllegalArgumentException("hostname field is empty");
                }
            } else
            if ("port".equals(obj[i]))
            {
                try
                {
                    mPort = Integer.valueOf(Integer.parseInt(obj[i + 1]));
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    throw new IllegalArgumentException((new StringBuilder()).append("Invalid port field, expecting integer. urn: ").append(s).toString());
                }
            } else
            {
                log.debug("ServiceIdentity(urn)", "unexpected field", new Object[] {
                    "field", obj[i]
                });
            }
            i += 2;
        }
    }

    ServiceIdentity(String s, String s1, String s2, String s3, Integer integer)
    {
        Object obj = null;
        super();
        if (s == null || s.trim().isEmpty())
        {
            throw new IllegalArgumentException("ServiceName cannot be null when constructing ServiceIdentity");
        }
        mServiceName = s;
        s = s1;
        if (s1 != null)
        {
            s = s1;
            if (s1.trim().isEmpty())
            {
                s = null;
            }
        }
        mDomain = s;
        s = s2;
        if (s2 != null)
        {
            s = s2;
            if (s2.trim().isEmpty())
            {
                s = null;
            }
        }
        mRealm = s;
        if (s3 != null && s3.trim().isEmpty())
        {
            s = obj;
        } else
        {
            s = s3;
        }
        mHostname = s;
        mPort = integer;
        if ((mHostname != null || mPort != null) && (mHostname == null || mPort == null))
        {
            throw new IllegalArgumentException("Both hostname and port must be specified together");
        } else
        {
            return;
        }
    }

    public static boolean matchesUrn(String s)
    {
        return s != null && s.startsWith("urn:tcomm-endpoint:service");
    }

    public String getDomain()
    {
        return mDomain;
    }

    public String getHostname()
    {
        return mHostname;
    }

    public Integer getPort()
    {
        return mPort;
    }

    public String getRealm()
    {
        return mRealm;
    }

    public String getServiceName()
    {
        return mServiceName;
    }

    public String toLogSafeString()
    {
        return toString();
    }

    public String toString()
    {
        int j = "urn:tcomm-endpoint:service".length() + ":".length() + "serviceName".length() + ":".length() + getServiceName().length();
        int i = j;
        if (mDomain != null)
        {
            i = j + (":".length() + "domain".length() + ":".length() + getDomain().length());
        }
        j = i;
        if (mRealm != null)
        {
            j = i + (":".length() + "realm".length() + ":".length() + getRealm().length());
        }
        i = j;
        if (mHostname != null)
        {
            i = j;
            if (mPort != null)
            {
                i = j + (":".length() + "hostname".length() + ":".length() + getHostname().length() + ":".length() + "port".length() + ":".length() + getPort().toString().length());
            }
        }
        StringBuilder stringbuilder = new StringBuilder(i);
        stringbuilder.append("urn:tcomm-endpoint:service");
        stringbuilder.append(":").append("serviceName").append(":").append(getServiceName());
        if (mDomain != null)
        {
            stringbuilder.append(":").append("domain").append(":").append(getDomain());
        }
        if (mRealm != null)
        {
            stringbuilder.append(":").append("realm").append(":").append(getRealm());
        }
        if (mHostname != null && mPort != null)
        {
            stringbuilder.append(":").append("hostname").append(":").append(getHostname()).append(":").append("port").append(":").append(getPort());
        }
        return stringbuilder.toString();
    }

}
