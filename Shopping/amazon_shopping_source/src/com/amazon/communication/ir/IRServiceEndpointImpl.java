// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication.ir;

import amazon.communication.identity.IRServiceEndpoint;
import com.amazon.dp.logger.DPLogger;

public class IRServiceEndpointImpl
    implements IRServiceEndpoint
{

    private static final String WHITE_LISTED_DOMAINS[] = {
        ".amazon.com", ".amazon.co.uk"
    };
    private static final DPLogger log = new DPLogger("TComm.IRServiceEndpointImpl");
    private final amazon.communication.identity.IRServiceEndpoint.ClearTextConnection mClearTextConnection;
    private final amazon.communication.identity.IRServiceEndpoint.DataCompression mDataCompression;
    private final amazon.communication.identity.IRServiceEndpoint.DirectConnection mDirectConnection;
    private final String mDomain;
    private final String mHostname;
    private final Integer mPort;
    private final String mRealm;
    private final Integer mSecurePort;
    private final int mTimeout;

    public IRServiceEndpointImpl(String s, String s1, String s2, amazon.communication.identity.IRServiceEndpoint.DirectConnection directconnection, amazon.communication.identity.IRServiceEndpoint.DataCompression datacompression, amazon.communication.identity.IRServiceEndpoint.ClearTextConnection cleartextconnection, int i, 
            Integer integer, Integer integer1)
    {
        mHostname = s;
        mDomain = s1;
        mRealm = s2;
        mTimeout = i;
        mDirectConnection = directconnection;
        mDataCompression = datacompression;
        mClearTextConnection = cleartextconnection;
        mPort = integer;
        mSecurePort = integer1;
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
            break MISSING_BLOCK_LABEL_294;
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
        int l1 = 0;
        int i;
        int j;
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        int i2;
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
        i2 = mTimeout;
        if (mDirectConnection == null)
        {
            l = 0;
        } else
        {
            l = mDirectConnection.hashCode();
        }
        if (mDataCompression == null)
        {
            i1 = 0;
        } else
        {
            i1 = mDataCompression.hashCode();
        }
        if (mClearTextConnection == null)
        {
            j1 = 0;
        } else
        {
            j1 = mClearTextConnection.hashCode();
        }
        if (mPort == null)
        {
            k1 = 0;
        } else
        {
            k1 = mPort.intValue();
        }
        if (mSecurePort != null)
        {
            l1 = mSecurePort.intValue();
        }
        return ((((((((i + 37) * 37 + j) * 37 + k) * 37 + i2) * 37 + l) * 37 + i1) * 37 + j1) * 37 + k1) * 37 + l1;
    }

    public String toString()
    {
        return (new StringBuilder()).append("Service Endpoint on domain: ").append(mDomain).append(" - ").append(mRealm).append(" - ").append(mHostname).append(" - Direct connection ").append(mDirectConnection).append(", - Data compression ").append(mDataCompression).append(", - Clear text connection ").append(mClearTextConnection).append(", ").append(mTimeout).append(" timeout").toString();
    }

}
