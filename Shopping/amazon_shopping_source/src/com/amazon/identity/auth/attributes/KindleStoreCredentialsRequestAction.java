// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.attributes;

import android.content.Context;
import android.net.Uri;
import com.amazon.identity.auth.device.api.AuthenticationMethodFactory;
import com.amazon.identity.auth.device.api.AuthenticationType;
import com.amazon.identity.auth.device.framework.AmazonUrlConnectionHelpers;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.storage.BackwardsCompatiableDataStorage;
import com.amazon.identity.auth.device.storage.CookieJar;
import com.amazon.identity.auth.device.utils.EnvironmentUtils;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.StreamUtils;
import com.amazon.identity.kcpsdk.auth.CookieParser;
import com.amazon.identity.kcpsdk.common.XMLParser;
import com.amazon.identity.kcpsdk.common.XMLParserHelpers;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class KindleStoreCredentialsRequestAction
{

    private static final String TAG = com/amazon/identity/auth/attributes/KindleStoreCredentialsRequestAction.getName();
    private final BackwardsCompatiableDataStorage mBackCompatDataStorage;
    private final Context mContext;
    private final CookieParser mCookieParser = new CookieParser();

    public KindleStoreCredentialsRequestAction(Context context)
    {
        mContext = ServiceWrappingContext.create(context);
        mBackCompatDataStorage = new BackwardsCompatiableDataStorage(mContext);
    }

    private URL createGetStoreCredentialsUrl()
    {
        URL url;
        try
        {
            url = new URL((new android.net.Uri.Builder()).scheme("https").authority(EnvironmentUtils.getInstance().getFIRSHost()).appendPath("FirsProxy").appendPath("getStoreCredentials").build().toString());
        }
        catch (MalformedURLException malformedurlexception)
        {
            MAPLog.e(TAG, "Cannot construct store credentials request");
            return null;
        }
        return url;
    }

    private CookieJar parseResponse(HttpURLConnection httpurlconnection)
        throws IOException
    {
        java.io.InputStream inputstream;
        java.io.InputStream inputstream1;
        inputstream1 = null;
        inputstream = null;
        java.io.InputStream inputstream2 = httpurlconnection.getInputStream();
        inputstream = inputstream2;
        inputstream1 = inputstream2;
        byte abyte0[] = StreamUtils.readInputStream(inputstream2);
        inputstream = inputstream2;
        inputstream1 = inputstream2;
        Object obj1 = new XMLParser();
        inputstream = inputstream2;
        inputstream1 = inputstream2;
        if (((XMLParser) (obj1)).parseChunk(abyte0, abyte0.length))
        {
            break MISSING_BLOCK_LABEL_72;
        }
        inputstream = inputstream2;
        inputstream1 = inputstream2;
        MAPLog.w(TAG, "Parsing XML Chunk was invalid");
        inputstream = inputstream2;
        inputstream1 = inputstream2;
        obj1 = ((XMLParser) (obj1)).parseEndOfDocument();
        if (obj1 != null)
        {
            break MISSING_BLOCK_LABEL_111;
        }
        inputstream = inputstream2;
        inputstream1 = inputstream2;
        MAPLog.e(TAG, "Could not parse get Store credentials response XML");
        StreamUtils.closeStream(inputstream2);
        return null;
        inputstream = inputstream2;
        inputstream1 = inputstream2;
        obj1 = ((Document) (obj1)).getDocumentElement();
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_152;
        }
        inputstream = inputstream2;
        inputstream1 = inputstream2;
        if (((Element) (obj1)).getTagName().equals("response"))
        {
            break MISSING_BLOCK_LABEL_200;
        }
        inputstream = inputstream2;
        inputstream1 = inputstream2;
        MAPLog.e(TAG, "Get Store Credentials request form was invalid. Could not get cookies");
        inputstream = inputstream2;
        inputstream1 = inputstream2;
        obj1 = TAG;
        inputstream = inputstream2;
        inputstream1 = inputstream2;
        new String(abyte0);
        StreamUtils.closeStream(inputstream2);
        return null;
        inputstream = inputstream2;
        inputstream1 = inputstream2;
        Object obj = XMLParserHelpers.getFirstElementWithTag(((Element) (obj1)), "cookies");
        inputstream = inputstream2;
        inputstream1 = inputstream2;
        obj = new CookieJar(mCookieParser.parseStandardKindleCookieResponse(((Element) (obj))));
        StreamUtils.closeStream(inputstream2);
        return ((CookieJar) (obj));
        IOException ioexception;
        ioexception;
        inputstream1 = inputstream;
        AmazonUrlConnectionHelpers.writeErrorStream(httpurlconnection, "Get Kindle Store Credentials Service");
        inputstream1 = inputstream;
        throw ioexception;
        httpurlconnection;
        StreamUtils.closeStream(inputstream1);
        throw httpurlconnection;
    }

    public CookieJar getStoreCredentialsCookies(String s)
    {
        URL url;
        int i;
        try
        {
            url = createGetStoreCredentialsUrl();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            MAPLog.e(TAG, "Could not get cookies because we could not reach get Store Cookies endpoint.", s);
            return null;
        }
        if (url == null)
        {
            return null;
        }
        s = AmazonUrlConnectionHelpers.openConnection(url, (new AuthenticationMethodFactory(mContext, s)).newAuthenticationMethod(AuthenticationType.ADPAuthenticator));
        s.setRequestMethod("GET");
        i = s.getResponseCode();
        MAPLog.i(TAG, String.format("Recieved Response %d from Firs Proxy getStoreCredentials", new Object[] {
            Integer.valueOf(i)
        }));
        s = parseResponse(s);
        return s;
    }

    public boolean updateStoreCredentialCookies(String s)
    {
        CookieJar cookiejar = getStoreCredentialsCookies(s);
        if (cookiejar == null)
        {
            MAPLog.e(TAG, "Cannot update store credential cookies");
            return false;
        } else
        {
            mBackCompatDataStorage.setUserData(s, "com.amazon.dcp.sso.token.cookie.xmain", cookiejar.getXmain());
            mBackCompatDataStorage.setUserData(s, "com.amazon.dcp.sso.token.cookie.xmainAndXabcCookies", cookiejar.getInternationalXMainAndXAcbCookies());
            return true;
        }
    }

}
