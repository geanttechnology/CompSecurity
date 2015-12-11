// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication.ir;

import amazon.communication.identity.IRServiceEndpoint;
import com.amazon.communication.utils.StringUtils;
import com.amazon.dp.logger.DPFormattedMessage;
import com.amazon.dp.logger.DPLogger;
import com.amazon.org.codehaus.jackson.JsonFactory;
import com.amazon.org.codehaus.jackson.JsonParser;
import com.amazon.org.codehaus.jackson.JsonToken;
import java.io.IOException;

// Referenced classes of package com.amazon.communication.ir:
//            InvalidIRFileFormatException, IRConfigurationException

public class IRServiceEndpointImpl
    implements IRServiceEndpoint
{

    private static final String NULL_DIRECTOR_SERVICENAME = null;
    private static final DPLogger log = new DPLogger("TComm.IRServiceEndpointImpl");
    private static JsonFactory sJsonFactory;
    private final amazon.communication.identity.IRServiceEndpoint.ClearTextConnection mClearTextConnection;
    private final amazon.communication.identity.IRServiceEndpoint.DataCompression mDataCompression;
    private final amazon.communication.identity.IRServiceEndpoint.DirectConnection mDirectConnection;
    private final String mDirectorServiceName;
    private final String mDomain;
    private final String mHostname;
    private final Integer mPort;
    private final String mRealm;
    private final Integer mSecurePort;
    private final int mTimeout;

    public IRServiceEndpointImpl(String s, String s1, String s2, amazon.communication.identity.IRServiceEndpoint.DirectConnection directconnection, int i, Integer integer, Integer integer1)
    {
        this(s, s1, s2, NULL_DIRECTOR_SERVICENAME, directconnection, amazon.communication.identity.IRServiceEndpoint.DataCompression.NOT_NEEDED, amazon.communication.identity.IRServiceEndpoint.ClearTextConnection.ALLOWED, i, integer, integer1);
    }

    public IRServiceEndpointImpl(String s, String s1, String s2, amazon.communication.identity.IRServiceEndpoint.DirectConnection directconnection, amazon.communication.identity.IRServiceEndpoint.DataCompression datacompression, amazon.communication.identity.IRServiceEndpoint.ClearTextConnection cleartextconnection, int i, 
            Integer integer, Integer integer1)
    {
        this(s, s1, s2, NULL_DIRECTOR_SERVICENAME, directconnection, datacompression, cleartextconnection, i, integer, integer1);
    }

    public IRServiceEndpointImpl(String s, String s1, String s2, String s3, amazon.communication.identity.IRServiceEndpoint.DirectConnection directconnection, amazon.communication.identity.IRServiceEndpoint.DataCompression datacompression, amazon.communication.identity.IRServiceEndpoint.ClearTextConnection cleartextconnection, 
            int i, Integer integer, Integer integer1)
    {
        mHostname = s;
        mDomain = s1;
        mRealm = s2;
        mDirectorServiceName = s3;
        mTimeout = i;
        mDirectConnection = directconnection;
        mDataCompression = datacompression;
        mClearTextConnection = cleartextconnection;
        mPort = integer;
        mSecurePort = integer1;
    }

    private static JsonFactory getJsonFactory()
    {
        com/amazon/communication/ir/IRServiceEndpointImpl;
        JVM INSTR monitorenter ;
        JsonFactory jsonfactory;
        if (sJsonFactory == null)
        {
            sJsonFactory = new JsonFactory();
        }
        jsonfactory = sJsonFactory;
        com/amazon/communication/ir/IRServiceEndpointImpl;
        JVM INSTR monitorexit ;
        return jsonfactory;
        Exception exception;
        exception;
        throw exception;
    }

    public static IRServiceEndpoint parse(String s, String s1, String s2)
        throws IOException, InvalidIRFileFormatException
    {
        Integer integer;
        Integer integer1;
        amazon.communication.identity.IRServiceEndpoint.ClearTextConnection cleartextconnection;
        String s3;
        amazon.communication.identity.IRServiceEndpoint.DataCompression datacompression;
        String s4;
        amazon.communication.identity.IRServiceEndpoint.DirectConnection directconnection;
        JsonParser jsonparser;
        log.verbose("parse", "getting service endpoint", new Object[] {
            "domain", s, "json", s2
        });
        if (StringUtils.isNullOrEmpty(s))
        {
            throw new IllegalArgumentException(DPFormattedMessage.toDPFormat("parse", "domain is null or empty", new Object[0]));
        }
        if (StringUtils.isNullOrEmpty(s1))
        {
            throw new IllegalArgumentException(DPFormattedMessage.toDPFormat("parse", "realm is null or empty", new Object[0]));
        }
        if (StringUtils.isNullOrEmpty(s2))
        {
            throw new IllegalArgumentException(DPFormattedMessage.toDPFormat("parse", "json is null or empty", new Object[0]));
        }
        jsonparser = getJsonFactory().createJsonParser(s2);
        s4 = null;
        s3 = null;
        s2 = null;
        directconnection = amazon.communication.identity.IRServiceEndpoint.DirectConnection.NOT_ALLOWED;
        datacompression = amazon.communication.identity.IRServiceEndpoint.DataCompression.NOT_NEEDED;
        cleartextconnection = amazon.communication.identity.IRServiceEndpoint.ClearTextConnection.NOT_ALLOWED;
        integer1 = null;
        integer = null;
        jsonparser.nextToken();
_L3:
        String s5;
        if (jsonparser.nextToken() == JsonToken.END_OBJECT)
        {
            break MISSING_BLOCK_LABEL_500;
        }
        s5 = jsonparser.getCurrentName();
        jsonparser.nextToken();
        if (!"director-service".equals(s5)) goto _L2; else goto _L1
_L1:
        s3 = jsonparser.getText();
          goto _L3
_L2:
label0:
        {
            if (!"hostname".equals(s5))
            {
                break label0;
            }
            s4 = jsonparser.getText();
        }
          goto _L3
label1:
        {
            if (!"timeout".equals(s5))
            {
                break label1;
            }
            s2 = Integer.valueOf(jsonparser.getValueAsInt());
        }
          goto _L3
        if (!"direct-connection".equals(s5))
        {
            break MISSING_BLOCK_LABEL_305;
        }
        s5 = jsonparser.getText();
        directconnection = amazon.communication.identity.IRServiceEndpoint.DirectConnection.parse(s5);
          goto _L3
        s;
        throw new InvalidIRFileFormatException(DPFormattedMessage.toDPFormat("parse", "invalid direct-connection", new Object[] {
            "tmp", s5
        }), s);
        s;
        try
        {
            jsonparser.close();
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            log.warn("parse", "IOException closing JsonParser", new Object[] {
                s1
            });
        }
        throw s;
        if (!"data-compression".equals(s5))
        {
            break MISSING_BLOCK_LABEL_368;
        }
        s5 = jsonparser.getText();
        datacompression = amazon.communication.identity.IRServiceEndpoint.DataCompression.parse(s5);
          goto _L3
        s;
        jsonparser.close();
        throw new InvalidIRFileFormatException(DPFormattedMessage.toDPFormat("parse", "invalid data-compression", new Object[] {
            "tmp", s5
        }), s);
        if (!"clear-text-connection".equals(s5))
        {
            break MISSING_BLOCK_LABEL_426;
        }
        s5 = jsonparser.getText();
        cleartextconnection = amazon.communication.identity.IRServiceEndpoint.ClearTextConnection.parse(s5);
          goto _L3
        s;
        throw new InvalidIRFileFormatException(DPFormattedMessage.toDPFormat("parse", "invalid clear-text-connection", new Object[] {
            "tmp", s5
        }), s);
        if (!"port".equals(s5))
        {
            break MISSING_BLOCK_LABEL_449;
        }
        integer1 = Integer.valueOf(jsonparser.getIntValue());
          goto _L3
label2:
        {
            if (!"secure-port".equals(s5))
            {
                break label2;
            }
            integer = Integer.valueOf(jsonparser.getIntValue());
        }
          goto _L3
        throw new InvalidIRFileFormatException(DPFormattedMessage.toDPFormat("parse", "invalid field", new Object[] {
            "fieldName", s5
        }));
        if (directconnection.equals(amazon.communication.identity.IRServiceEndpoint.DirectConnection.NOT_ALLOWED))
        {
            break MISSING_BLOCK_LABEL_656;
        }
        if (StringUtils.isNullOrEmpty(s4) && StringUtils.isNullOrEmpty(s3))
        {
            throw new InvalidIRFileFormatException(DPFormattedMessage.toDPFormat("parse", "hostname and director is null or empty", new Object[0]));
        }
        if (integer1 != null || integer != null)
        {
            break MISSING_BLOCK_LABEL_574;
        }
        throw new InvalidIRFileFormatException(DPFormattedMessage.toDPFormat("parse", "neither insecure nor secure port defined", new Object[0]));
        if (integer1 == null)
        {
            break MISSING_BLOCK_LABEL_616;
        }
        if (integer1.intValue() <= 0)
        {
            throw new InvalidIRFileFormatException(DPFormattedMessage.toDPFormat("parse", "insecure port must be positive", new Object[] {
                "port", integer1
            }));
        }
        if (integer == null)
        {
            break MISSING_BLOCK_LABEL_656;
        }
        if (integer.intValue() <= 0)
        {
            throw new InvalidIRFileFormatException(DPFormattedMessage.toDPFormat("parse", "secure port must be positive", new Object[] {
                "securePort", integer1
            }));
        }
        if (s2 != null)
        {
            break MISSING_BLOCK_LABEL_679;
        }
        throw new InvalidIRFileFormatException(DPFormattedMessage.toDPFormat("parse", "timeout is null", new Object[0]));
        s = new IRServiceEndpointImpl(s4, s, s1, s3, directconnection, datacompression, cleartextconnection, s2.intValue(), integer1, integer);
        try
        {
            jsonparser.close();
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            log.warn("parse", "IOException closing JsonParser", new Object[] {
                s1
            });
            return s;
        }
        return s;
    }

    public boolean equals(Object obj)
    {
        if (obj != this) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (obj == null)
        {
            return false;
        }
        if (!(obj instanceof IRServiceEndpoint))
        {
            break MISSING_BLOCK_LABEL_326;
        }
        obj = (IRServiceEndpointImpl)obj;
        if (mHostname == null)
        {
            if (((IRServiceEndpointImpl) (obj)).mHostname != null)
            {
                return false;
            }
        } else
        if (!mHostname.equals(((IRServiceEndpointImpl) (obj)).mHostname))
        {
            return false;
        }
        if (mDomain == null)
        {
            if (((IRServiceEndpointImpl) (obj)).mDomain != null)
            {
                return false;
            }
        } else
        if (!mDomain.equals(((IRServiceEndpointImpl) (obj)).mDomain))
        {
            return false;
        }
        if (mRealm == null)
        {
            if (((IRServiceEndpointImpl) (obj)).mRealm != null)
            {
                return false;
            }
        } else
        if (!mRealm.equals(((IRServiceEndpointImpl) (obj)).mRealm))
        {
            return false;
        }
        if (mDirectorServiceName == null)
        {
            if (((IRServiceEndpointImpl) (obj)).mDirectorServiceName != null)
            {
                return false;
            }
        } else
        if (!mDirectorServiceName.equals(((IRServiceEndpointImpl) (obj)).mDirectorServiceName))
        {
            return false;
        }
        if (mTimeout != ((IRServiceEndpointImpl) (obj)).mTimeout)
        {
            return false;
        }
        if (mDirectConnection == null)
        {
            if (((IRServiceEndpointImpl) (obj)).mDirectConnection != null)
            {
                return false;
            }
        } else
        if (!mDirectConnection.equals(((IRServiceEndpointImpl) (obj)).mDirectConnection))
        {
            return false;
        }
        if (mDataCompression == null)
        {
            if (((IRServiceEndpointImpl) (obj)).mDataCompression != null)
            {
                return false;
            }
        } else
        if (!mDataCompression.equals(((IRServiceEndpointImpl) (obj)).mDataCompression))
        {
            return false;
        }
        if (mClearTextConnection == null)
        {
            if (((IRServiceEndpointImpl) (obj)).mClearTextConnection != null)
            {
                return false;
            }
        } else
        if (!mClearTextConnection.equals(((IRServiceEndpointImpl) (obj)).mClearTextConnection))
        {
            return false;
        }
        if (mPort == null)
        {
            if (((IRServiceEndpointImpl) (obj)).mPort != null)
            {
                return false;
            }
        } else
        if (!mPort.equals(((IRServiceEndpointImpl) (obj)).mPort))
        {
            return false;
        }
        if (mSecurePort != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (((IRServiceEndpointImpl) (obj)).mSecurePort == null) goto _L1; else goto _L3
_L3:
        return false;
        if (mSecurePort.equals(((IRServiceEndpointImpl) (obj)).mSecurePort)) goto _L1; else goto _L4
_L4:
        return false;
        return false;
    }

    public amazon.communication.identity.IRServiceEndpoint.ClearTextConnection getClearTextConnection()
    {
        return mClearTextConnection;
    }

    public amazon.communication.identity.IRServiceEndpoint.DataCompression getDataCompression()
    {
        return mDataCompression;
    }

    public amazon.communication.identity.IRServiceEndpoint.DirectConnection getDirectConnection()
    {
        return mDirectConnection;
    }

    public String getDirectorServiceName()
    {
        return mDirectorServiceName;
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

    public Integer getSecurePort()
    {
        return mSecurePort;
    }

    public int getTimeout()
    {
        return mTimeout;
    }

    public int hashCode()
    {
        int i2 = 0;
        int i;
        int j;
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        int l1;
        int j2;
        if (mHostname == null)
        {
            i = 0;
        } else
        {
            i = mHostname.hashCode();
        }
        if (mDomain == null)
        {
            j = 0;
        } else
        {
            j = mDomain.hashCode();
        }
        if (mRealm == null)
        {
            k = 0;
        } else
        {
            k = mRealm.hashCode();
        }
        if (mDirectorServiceName == null)
        {
            l = 0;
        } else
        {
            l = mDirectorServiceName.hashCode();
        }
        j2 = mTimeout;
        if (mDirectConnection == null)
        {
            i1 = 0;
        } else
        {
            i1 = mDirectConnection.hashCode();
        }
        if (mDataCompression == null)
        {
            j1 = 0;
        } else
        {
            j1 = mDataCompression.hashCode();
        }
        if (mClearTextConnection == null)
        {
            k1 = 0;
        } else
        {
            k1 = mClearTextConnection.hashCode();
        }
        if (mPort == null)
        {
            l1 = 0;
        } else
        {
            l1 = mPort.intValue();
        }
        if (mSecurePort != null)
        {
            i2 = mSecurePort.intValue();
        }
        return (((((((((i + 37) * 37 + j) * 37 + k) * 37 + l) * 37 + j2) * 37 + i1) * 37 + j1) * 37 + k1) * 37 + l1) * 37 + i2;
    }

    public String toResolvedUri(amazon.communication.identity.IRServiceEndpoint.Scheme scheme)
    {
        if (getHostname() == null)
        {
            throw new IRConfigurationException("Cannot create URI. No hostname defined in IR config");
        }
        amazon.communication.identity.IRServiceEndpoint.Scheme scheme1;
        amazon.communication.identity.IRServiceEndpoint.Scheme scheme2;
        boolean flag;
        boolean flag1;
        if (mClearTextConnection == amazon.communication.identity.IRServiceEndpoint.ClearTextConnection.NOT_ALLOWED)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (scheme == amazon.communication.identity.IRServiceEndpoint.Scheme.WSS || scheme == amazon.communication.identity.IRServiceEndpoint.Scheme.HTTPS)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag || flag1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        scheme2 = scheme;
        scheme1 = scheme2;
        if (flag)
        {
            scheme1 = scheme2;
            if (scheme == amazon.communication.identity.IRServiceEndpoint.Scheme.WS)
            {
                scheme1 = amazon.communication.identity.IRServiceEndpoint.Scheme.WSS;
            }
        }
        scheme2 = scheme1;
        if (flag)
        {
            scheme2 = scheme1;
            if (scheme == amazon.communication.identity.IRServiceEndpoint.Scheme.HTTP)
            {
                scheme2 = amazon.communication.identity.IRServiceEndpoint.Scheme.HTTPS;
            }
        }
        if (flag)
        {
            scheme = getSecurePort();
        } else
        {
            scheme = getPort();
        }
        if (scheme == null)
        {
            StringBuilder stringbuilder = (new StringBuilder()).append("Cannot create URI. No ");
            if (flag)
            {
                scheme = "secure ";
            } else
            {
                scheme = "";
            }
            throw new IRConfigurationException(stringbuilder.append(scheme).append("port defined in IR config").toString());
        } else
        {
            return String.format("%s://%s:%d", new Object[] {
                scheme2.toString(), getHostname(), scheme
            });
        }
    }

    public String toString()
    {
        return (new StringBuilder()).append("Service Endpoint on domain: ").append(mDomain).append(" - realm: ").append(mRealm).append(" - directorServiceName: ").append(mDirectorServiceName).append(" - hostname: ").append(mHostname).append(" - port: ").append(mPort).append(" - secure port : ").append(mSecurePort).append(" - Direct connection ").append(mDirectConnection).append(", - Data compression ").append(mDataCompression).append(", - Clear text connection ").append(mClearTextConnection).append(", ").append(mTimeout).append(" timeout").toString();
    }

}
