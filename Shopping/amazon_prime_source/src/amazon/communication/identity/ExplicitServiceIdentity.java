// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package amazon.communication.identity;


// Referenced classes of package amazon.communication.identity:
//            ServiceIdentity

public class ExplicitServiceIdentity extends ServiceIdentity
{

    protected String mClearTextConnection;
    protected String mDataCompression;
    protected String mDirectConnection;
    protected Integer mSecurePort;
    protected Integer mTimeout;

    ExplicitServiceIdentity(String s)
    {
        super(s);
        if (!matchesUrn(s))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("ExplicitServiceIdentity urn is invalid: ").append(s).toString());
        }
        Object obj = s.split(":");
        if (obj.length < 13)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Too few fields in explicit service urn ").append(s).toString());
        }
        int i = 5;
        while (i < obj.length) 
        {
            if ("secure_port".equals(obj[i]))
            {
                try
                {
                    mSecurePort = Integer.valueOf(Integer.parseInt(obj[i + 1]));
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    throw new IllegalArgumentException((new StringBuilder()).append("Invalid secure port field, expecting integer. urn: ").append(s).toString());
                }
            } else
            if ("direct_connection".equals(obj[i]))
            {
                mDirectConnection = obj[i + 1].trim();
                if ("".equals(mDirectConnection))
                {
                    throw new IllegalArgumentException("Direct connection field is empty");
                }
            } else
            if ("data_compression".equals(obj[i]))
            {
                mDataCompression = obj[i + 1].trim();
                if ("".equals(mDataCompression))
                {
                    throw new IllegalArgumentException("Data Compression field is empty");
                }
            } else
            if ("clear_text_connection".equals(obj[i]))
            {
                mClearTextConnection = obj[i + 1].trim();
                if ("".equals(mClearTextConnection))
                {
                    throw new IllegalArgumentException("Clear text connection field is empty");
                }
            } else
            if ("timeout".equals(obj[i]))
            {
                try
                {
                    mTimeout = Integer.valueOf(Integer.parseInt(obj[i + 1]));
                }
                catch (NumberFormatException numberformatexception)
                {
                    throw new IllegalArgumentException((new StringBuilder()).append("Invalid timeout field, expecting integer. urn: ").append(s).toString());
                }
            }
            i += 2;
        }
    }

    public static boolean matchesUrn(String s)
    {
        return s != null && s.startsWith("urn:tcomm-endpoint:service-explicit");
    }

    public String getClearTextConnection()
    {
        return mClearTextConnection;
    }

    public String getDataCompression()
    {
        return mDataCompression;
    }

    public String getDirectConnection()
    {
        return mDirectConnection;
    }

    public Integer getSecurePort()
    {
        return mSecurePort;
    }

    public Integer getTimeout()
    {
        return mTimeout;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("urn:tcomm-endpoint:service-explicit");
        stringbuilder.append(":").append("serviceName").append(":").append(getServiceName()).append(":").append("domain").append(":").append(getDomain()).append(":").append("realm").append(":").append(getRealm()).append(":").append("hostname").append(":").append(getHostname()).append(":").append("port").append(":").append(getPort()).append(":").append("secure_port").append(":").append(getSecurePort()).append(":").append("direct_connection").append(":").append(getDirectConnection()).append(":").append("data_compression").append(":").append(getDataCompression()).append(":").append("clear_text_connection").append(":").append(getClearTextConnection()).append(":").append("timeout").append(":").append(getTimeout());
        return stringbuilder.toString();
    }
}
