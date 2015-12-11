// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.blueshift.bluefront.android.http;

import android.net.Uri;
import android.util.Base64;
import com.amazon.blueshift.bluefront.android.common.BluefrontCredential;
import com.amazon.blueshift.bluefront.android.common.UriUtils;
import com.google.common.base.Preconditions;
import java.net.MalformedURLException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeMap;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

// Referenced classes of package com.amazon.blueshift.bluefront.android.http:
//            SigningProtocol, URLWrapper

public class AwsV2SigningProtocol
    implements SigningProtocol
{

    private static final String AWS_ACCESS_KEY_ID = "AWSAccessKeyId";
    private static final String CHAR_AND = "&";
    private static final String CHAR_COLON = ":";
    private static final String CHAR_EQUAL = "=";
    private static final String CHAR_NEW_LINE = "\n";
    private static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    private static final String HMAC_SHA1_ALGORITHM = "HmacSHA1";
    private static final int NON_SECURE_PORT = 80;
    private static final String POST_METHOD = "POST";
    private static final String SCHEME_HTTP = "http";
    private static final String SCHEME_HTTPS = "https";
    private static final int SECURE_PORT = 443;
    private static final String SIGNATURE_KEY = "Signature";
    private static final String SIGNATURE_METHOD_KEY = "SignatureMethod";
    private static final String SIGNATURE_VERSION = "2";
    private static final String SIGNATURE_VERSION_KEY = "SignatureVersion";
    private static final String TIME_STAMP_KEY = "Timestamp";
    private static final TimeZone TIME_ZONE_UTC = TimeZone.getTimeZone("UTC");

    public AwsV2SigningProtocol()
    {
    }

    public URLWrapper sign(BluefrontCredential bluefrontcredential, Uri uri)
        throws MalformedURLException
    {
        Preconditions.checkNotNull(bluefrontcredential, "Credentials cannot be null");
        Preconditions.checkNotNull(uri, "URI cannot be null");
        Object obj = new TreeMap();
        Object obj1 = UriUtils.getQueryParameterNames(uri).iterator();
        do
        {
            if (!((Iterator) (obj1)).hasNext())
            {
                break;
            }
            String s = (String)((Iterator) (obj1)).next();
            String s1 = uri.getQueryParameter(s);
            if (s1 != null)
            {
                ((TreeMap) (obj)).put(s, s1);
            }
        } while (true);
        obj1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
        ((SimpleDateFormat) (obj1)).setTimeZone(TIME_ZONE_UTC);
        ((TreeMap) (obj)).put("AWSAccessKeyId", Uri.encode(bluefrontcredential.getAccessId()));
        ((TreeMap) (obj)).put("SignatureVersion", "2");
        ((TreeMap) (obj)).put("SignatureMethod", "HmacSHA1");
        ((TreeMap) (obj)).put("Timestamp", Uri.encode(((SimpleDateFormat) (obj1)).format(new Date())));
        obj1 = ((TreeMap) (obj)).entrySet().iterator();
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("POST").append("\n");
        stringbuilder.append(uri.getHost());
        if (uri.getPort() > 0 && (!uri.getScheme().equals("http") || uri.getPort() != 80) && (!uri.getScheme().equals("https") || uri.getPort() != 443))
        {
            stringbuilder.append(":").append(uri.getPort());
        }
        stringbuilder.append("\n");
        stringbuilder.append(uri.getPath()).append("\n");
        obj = new StringBuilder();
        do
        {
            if (!((Iterator) (obj1)).hasNext())
            {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)((Iterator) (obj1)).next();
            ((StringBuilder) (obj)).append((String)entry.getKey());
            ((StringBuilder) (obj)).append("=");
            ((StringBuilder) (obj)).append((String)entry.getValue());
            if (((Iterator) (obj1)).hasNext())
            {
                ((StringBuilder) (obj)).append("&");
            }
        } while (true);
        stringbuilder.append(((StringBuilder) (obj)).toString());
        byte abyte0[] = stringbuilder.toString().getBytes();
        try
        {
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(new SecretKeySpec(bluefrontcredential.getAccessKey().getBytes(), "HmacSHA1"));
            bluefrontcredential = Uri.encode(Base64.encodeToString(mac.doFinal(abyte0), 0).replace("\n", ""));
            ((StringBuilder) (obj)).append("&Signature=").append(bluefrontcredential);
        }
        // Misplaced declaration of an exception variable
        catch (BluefrontCredential bluefrontcredential)
        {
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (BluefrontCredential bluefrontcredential)
        {
            return null;
        }
        bluefrontcredential = uri.buildUpon();
        bluefrontcredential.encodedQuery(((StringBuilder) (obj)).toString());
        return new URLWrapper(bluefrontcredential.build().toString());
    }

}
