// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.common;

import com.amazon.identity.auth.device.utils.MAPLog;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

// Referenced classes of package com.amazon.identity.kcpsdk.common:
//            HttpVerb, WebProtocol

public class WebRequest
{

    private static final String TAG = com/amazon/identity/kcpsdk/common/WebRequest.getName();
    private boolean mAuthenticationRequired;
    private byte mBody[];
    private final List mHeaderNames = new ArrayList();
    private final Map mHeaders = new HashMap();
    private String mHost;
    private String mPath;
    private String mPathAndQueryString;
    private String mPort;
    private String mProtocol;
    private String mQueryParameters;
    private String mUrl;
    private HttpVerb mVerb;

    public WebRequest()
    {
        mProtocol = "http";
        mVerb = HttpVerb.HttpVerbGet;
        mBody = new byte[0];
    }

    public static boolean isValidUrl(String s)
    {
        return (new WebRequest()).tryToParseUrl(s);
    }

    private boolean tryToParseUrl(String s)
    {
        if (s == null || s.equals(""))
        {
            return false;
        }
        int i;
        try
        {
            s = new URI(s);
            mProtocol = s.getScheme();
            mHost = s.getHost();
            i = s.getPort();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            MAPLog.e(TAG, (new StringBuilder("tryToParseUrl: URL is malformed: ")).append(s.getMessage()).toString());
            return false;
        }
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_130;
        }
        mPort = Integer.toString(i);
_L1:
        mPath = s.getRawPath();
        if (mPath != null && !"".equals(mPath) && !mPath.startsWith("/"))
        {
            mPath = (new StringBuilder("/")).append(mPath).toString();
        }
        mQueryParameters = s.getRawQuery();
        return true;
        mPort = null;
          goto _L1
    }

    public void addQueryParameter(String s, String s1)
    {
        if (s == null || "".equals(s) || s1 == null)
        {
            MAPLog.e(TAG, "addQueryParameter: could not add query parameter because the supplied arguments are invalid (null or empty name or null value).");
            return;
        }
        if (mQueryParameters != null)
        {
            mQueryParameters = (new StringBuilder()).append(mQueryParameters).append("&").toString();
        } else
        {
            mQueryParameters = "";
        }
        try
        {
            mQueryParameters = (new StringBuilder()).append(mQueryParameters).append(String.format("%s=%s", new Object[] {
                URLEncoder.encode(s, "UTF-8"), URLEncoder.encode(s1, "UTF-8")
            })).toString();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            MAPLog.e(TAG, (new StringBuilder("addQueryParameter: Could not add query parameter because of UnsupportedEncodingException: ")).append(s.getMessage()).toString());
        }
    }

    public boolean getAuthenticationRequired()
    {
        return mAuthenticationRequired;
    }

    public byte[] getBodyBytes()
    {
        return mBody;
    }

    public String getHeaderByName(String s)
    {
        if (s == null)
        {
            return null;
        } else
        {
            return (String)mHeaders.get(s.toLowerCase(Locale.US));
        }
    }

    public String getHeaderName(int i)
    {
        if (i < 0 || i >= getNumHeaders())
        {
            MAPLog.e(TAG, "getHeader: index is out of range");
            return null;
        } else
        {
            return (String)mHeaderNames.get(i);
        }
    }

    public String getHeaderValue(int i)
    {
        return getHeaderByName(getHeaderName(i));
    }

    public int getNumHeaders()
    {
        return mHeaderNames.size();
    }

    public String getPathAndQueryString()
    {
        String s = "";
        if (mPath != null)
        {
            s = mPath;
        }
        String s1 = "";
        if (mQueryParameters != null)
        {
            s1 = (new StringBuilder("?")).append(mQueryParameters).toString();
        }
        mPathAndQueryString = (new StringBuilder()).append(s).append(s1).toString();
        return mPathAndQueryString;
    }

    public String getQueryString()
    {
        if (mQueryParameters == null)
        {
            return "";
        } else
        {
            return mQueryParameters;
        }
    }

    public String getUrl()
    {
        StringBuilder stringbuilder = new StringBuilder();
        String s;
        if (mProtocol != null)
        {
            s = mProtocol;
        } else
        {
            s = "";
        }
        stringbuilder.append(s);
        stringbuilder.append("://");
        if (mHost != null)
        {
            s = mHost;
        } else
        {
            s = "";
        }
        stringbuilder.append(s);
        if (mPort != null)
        {
            stringbuilder.append((new StringBuilder(":")).append(mPort).toString());
        }
        stringbuilder.append(getPathAndQueryString());
        mUrl = stringbuilder.toString();
        return mUrl;
    }

    public HttpVerb getVerb()
    {
        return mVerb;
    }

    public String getVerbAsString()
    {
        if (mVerb != null)
        {
            return mVerb.getValue();
        } else
        {
            return null;
        }
    }

    public void setAuthenticationRequired(boolean flag)
    {
        mAuthenticationRequired = flag;
    }

    public void setBody(String s)
    {
        try
        {
            setBody(s.getBytes("UTF-8"));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            MAPLog.e(TAG, (new StringBuilder("setBody: UnsupportedEncodingException error: ")).append(s.getMessage()).toString());
        }
    }

    public void setBody(byte abyte0[])
    {
        mBody = abyte0;
    }

    public void setHeader(String s, String s1)
    {
        if (s == null || "".equals(s))
        {
            MAPLog.w(TAG, "setHeader: failed because the given header name was null or empty.");
            return;
        }
        if (s1 == null)
        {
            mHeaderNames.remove(s);
            mHeaders.remove(s.toLowerCase(Locale.US));
            return;
        } else
        {
            s1 = s1.replace("\n", "\n ");
            mHeaderNames.add(s);
            mHeaders.put(s.toLowerCase(Locale.US), s1);
            return;
        }
    }

    public void setHost(String s)
    {
        mHost = s;
    }

    public void setPath(String s)
    {
        String s1 = s;
        String s2 = s1;
        if (s != null)
        {
            s2 = s1;
            if (!s.equals(""))
            {
                s2 = s1;
                if (!s.startsWith("/"))
                {
                    s2 = (new StringBuilder("/")).append(s).toString();
                }
            }
        }
        try
        {
            mPath = (new URI("http", "www.amazon.com", s2, null)).getRawPath();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            MAPLog.e(TAG, (new StringBuilder("setPath: Could not set path because of URISyntaxException: ")).append(s.getMessage()).toString());
        }
        throw new IllegalArgumentException(s);
    }

    public void setProtocol(WebProtocol webprotocol)
    {
        if (webprotocol != null)
        {
            mProtocol = webprotocol.getValue();
            return;
        } else
        {
            mProtocol = null;
            return;
        }
    }

    public boolean setUrl(String s)
    {
        if (!tryToParseUrl(s))
        {
            MAPLog.e(TAG, "setUrl: url was malformed. Cannot be set.");
            return false;
        } else
        {
            return true;
        }
    }

    public void setVerb(HttpVerb httpverb)
    {
        mVerb = httpverb;
    }

}
