// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adobe.mobile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.conn.ssl.StrictHostnameVerifier;

// Referenced classes of package com.adobe.mobile:
//            RemoteDownload, StaticMethods

private static class ck
    implements Runnable
{

    private final ck callback;
    private final int connectionTimeout;
    private final String directory;
    private final int readTimeout;
    private final String url;

    protected static HttpURLConnection requestConnect(String s)
    {
        s = new URL(s);
        if (!s.getProtocol().equals("https"))
        {
            break MISSING_BLOCK_LABEL_42;
        }
        s = (HttpsURLConnection)s.openConnection();
        s.setHostnameVerifier(new StrictHostnameVerifier());
        return s;
        try
        {
            s = (HttpURLConnection)s.openConnection();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            StaticMethods.logErrorFormat("Cached Files - Exception opening URL(%s)", new Object[] {
                s.getLocalizedMessage()
            });
            return null;
        }
        return s;
    }

    public void run()
    {
        if (url != null) goto _L2; else goto _L1
_L1:
        StaticMethods.logDebugFormat("Cached Files - url is null and cannot be cached", new Object[0]);
        if (callback != null)
        {
            callback.call(false, null);
        }
_L4:
        return;
_L2:
        if (RemoteDownload.stringIsUrl(url))
        {
            break; /* Loop/switch isn't completed */
        }
        StaticMethods.logDebugFormat("Cached Files - given url is not valid and cannot be cached (\"%s\")", new Object[] {
            url
        });
        if (callback != null)
        {
            callback.call(false, null);
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
        Object obj;
        Object obj7;
        Object obj8;
        Object obj12;
        Object obj13;
        Object obj14;
        Object obj15;
        Object obj16;
        Object obj17;
        Object obj18;
        Object obj19;
        Object obj20;
        HttpURLConnection httpurlconnection;
        obj = RemoteDownload.getFileForCachedURL(url, directory);
        obj8 = RemoteDownload.access$100();
        httpurlconnection = requestConnect(url);
        obj18 = null;
        obj19 = null;
        obj20 = null;
        obj17 = null;
        obj16 = null;
        obj14 = null;
        obj15 = null;
        obj13 = null;
        obj7 = null;
        obj12 = null;
        if (httpurlconnection != null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (callback != null)
        {
            callback.call(false, null);
            return;
        }
        if (true) goto _L4; else goto _L5
_L5:
        Object obj1;
        Object obj5;
        Object obj9;
        Object obj10;
        Object obj11;
        httpurlconnection.setConnectTimeout(connectionTimeout);
        httpurlconnection.setReadTimeout(readTimeout);
        if (obj != null)
        {
            String s = StaticMethods.hexToString(RemoteDownload.access$200(((File) (obj)).getPath()));
            Long long1 = Long.valueOf(RemoteDownload.access$300(((File) (obj)).getPath()));
            if (long1.longValue() != 0L)
            {
                httpurlconnection.setRequestProperty("If-Modified-Since", ((SimpleDateFormat) (obj8)).format(long1));
            }
            if (s != null)
            {
                httpurlconnection.setRequestProperty("If-None-Match", s);
            }
        }
        obj10 = obj16;
        obj8 = obj18;
        obj9 = obj19;
        obj1 = obj20;
        obj5 = obj7;
        obj11 = obj17;
        httpurlconnection.connect();
        obj10 = obj16;
        obj8 = obj18;
        obj9 = obj19;
        obj1 = obj20;
        obj5 = obj7;
        obj11 = obj17;
        if (httpurlconnection.getResponseCode() != 304)
        {
            break MISSING_BLOCK_LABEL_446;
        }
        obj10 = obj16;
        obj8 = obj18;
        obj9 = obj19;
        obj1 = obj20;
        obj5 = obj7;
        obj11 = obj17;
        StaticMethods.logDebugFormat("Cached Files - File has not been modified since last download. (%s)", new Object[] {
            url
        });
        obj10 = obj16;
        obj8 = obj18;
        obj9 = obj19;
        obj1 = obj20;
        obj5 = obj7;
        obj11 = obj17;
        if (callback == null)
        {
            break MISSING_BLOCK_LABEL_398;
        }
        obj10 = obj16;
        obj8 = obj18;
        obj9 = obj19;
        obj1 = obj20;
        obj5 = obj7;
        obj11 = obj17;
        callback.call(false, ((File) (obj)));
        if (false)
        {
            try
            {
                throw new NullPointerException();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                StaticMethods.logWarningFormat("Cached Files - Exception while attempting to close streams (%s)", new Object[] {
                    ((IOException) (obj)).getLocalizedMessage()
                });
            }
            break MISSING_BLOCK_LABEL_445;
        }
        if (true)
        {
            break MISSING_BLOCK_LABEL_422;
        }
        throw new NullPointerException();
        httpurlconnection.disconnect();
        return;
        return;
        obj10 = obj16;
        obj8 = obj18;
        obj9 = obj19;
        obj1 = obj20;
        obj5 = obj7;
        obj11 = obj17;
        if (httpurlconnection.getResponseCode() != 404)
        {
            break MISSING_BLOCK_LABEL_627;
        }
        obj10 = obj16;
        obj8 = obj18;
        obj9 = obj19;
        obj1 = obj20;
        obj5 = obj7;
        obj11 = obj17;
        StaticMethods.logDebugFormat("Cached Files - File not found. (%s)", new Object[] {
            url
        });
        obj10 = obj16;
        obj8 = obj18;
        obj9 = obj19;
        obj1 = obj20;
        obj5 = obj7;
        obj11 = obj17;
        if (callback == null)
        {
            break MISSING_BLOCK_LABEL_579;
        }
        obj10 = obj16;
        obj8 = obj18;
        obj9 = obj19;
        obj1 = obj20;
        obj5 = obj7;
        obj11 = obj17;
        callback.call(false, ((File) (obj)));
        if (false)
        {
            try
            {
                throw new NullPointerException();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                StaticMethods.logWarningFormat("Cached Files - Exception while attempting to close streams (%s)", new Object[] {
                    ((IOException) (obj)).getLocalizedMessage()
                });
            }
            break MISSING_BLOCK_LABEL_626;
        }
        if (true)
        {
            break MISSING_BLOCK_LABEL_603;
        }
        throw new NullPointerException();
        httpurlconnection.disconnect();
        return;
        return;
        obj10 = obj16;
        obj8 = obj18;
        obj9 = obj19;
        obj1 = obj20;
        obj5 = obj7;
        obj11 = obj17;
        if (httpurlconnection.getResponseCode() == 200)
        {
            break MISSING_BLOCK_LABEL_827;
        }
        obj10 = obj16;
        obj8 = obj18;
        obj9 = obj19;
        obj1 = obj20;
        obj5 = obj7;
        obj11 = obj17;
        StaticMethods.logWarningFormat("Cached Files - File could not be downloaded from URL (%s) Response: (%d) Message: (%s)", new Object[] {
            url, Integer.valueOf(httpurlconnection.getResponseCode()), httpurlconnection.getResponseMessage()
        });
        obj10 = obj16;
        obj8 = obj18;
        obj9 = obj19;
        obj1 = obj20;
        obj5 = obj7;
        obj11 = obj17;
        if (callback == null)
        {
            break MISSING_BLOCK_LABEL_779;
        }
        obj10 = obj16;
        obj8 = obj18;
        obj9 = obj19;
        obj1 = obj20;
        obj5 = obj7;
        obj11 = obj17;
        callback.call(false, ((File) (obj)));
        if (false)
        {
            try
            {
                throw new NullPointerException();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                StaticMethods.logWarningFormat("Cached Files - Exception while attempting to close streams (%s)", new Object[] {
                    ((IOException) (obj)).getLocalizedMessage()
                });
            }
            break MISSING_BLOCK_LABEL_826;
        }
        if (true)
        {
            break MISSING_BLOCK_LABEL_803;
        }
        throw new NullPointerException();
        httpurlconnection.disconnect();
        return;
        return;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_865;
        }
        obj10 = obj16;
        obj8 = obj18;
        obj9 = obj19;
        obj1 = obj20;
        obj5 = obj7;
        obj11 = obj17;
        RemoteDownload.deleteCachedDataForURL(url, directory);
        obj10 = obj16;
        obj8 = obj18;
        obj9 = obj19;
        obj1 = obj20;
        obj5 = obj7;
        obj11 = obj17;
        Date date = new Date(httpurlconnection.getLastModified());
        obj10 = obj16;
        obj8 = obj18;
        obj9 = obj19;
        obj1 = obj20;
        obj5 = obj7;
        obj11 = obj17;
        Object obj21 = httpurlconnection.getHeaderField("ETag");
        obj = obj21;
        if (obj21 == null)
        {
            break MISSING_BLOCK_LABEL_968;
        }
        obj10 = obj16;
        obj8 = obj18;
        obj9 = obj19;
        obj1 = obj20;
        obj5 = obj7;
        obj11 = obj17;
        obj = StaticMethods.getHexString(((String) (obj21)));
        obj10 = obj16;
        obj8 = obj18;
        obj9 = obj19;
        obj1 = obj20;
        obj5 = obj7;
        obj11 = obj17;
        obj21 = RemoteDownload.access$400(url, date, ((String) (obj)), directory);
        if (obj21 != null)
        {
            break MISSING_BLOCK_LABEL_1121;
        }
        obj10 = obj16;
        obj8 = obj18;
        obj9 = obj19;
        obj1 = obj20;
        obj5 = obj7;
        obj11 = obj17;
        if (callback == null)
        {
            break MISSING_BLOCK_LABEL_1073;
        }
        obj10 = obj16;
        obj8 = obj18;
        obj9 = obj19;
        obj1 = obj20;
        obj5 = obj7;
        obj11 = obj17;
        callback.call(false, null);
        if (false)
        {
            try
            {
                throw new NullPointerException();
            }
            catch (IOException ioexception)
            {
                StaticMethods.logWarningFormat("Cached Files - Exception while attempting to close streams (%s)", new Object[] {
                    ioexception.getLocalizedMessage()
                });
            }
            break MISSING_BLOCK_LABEL_1120;
        }
        if (true)
        {
            break MISSING_BLOCK_LABEL_1097;
        }
        throw new NullPointerException();
        httpurlconnection.disconnect();
        return;
        return;
        obj10 = obj16;
        obj8 = obj18;
        obj9 = obj19;
        obj1 = obj20;
        obj5 = obj7;
        obj11 = obj17;
        ioexception = httpurlconnection.getInputStream();
        obj10 = ioexception;
        obj8 = ioexception;
        obj9 = ioexception;
        obj1 = ioexception;
        obj5 = obj7;
        obj11 = ioexception;
        obj7 = new FileOutputStream(((File) (obj21)));
        obj1 = new byte[4096];
_L8:
        int i = ioexception.read(((byte []) (obj1)));
        if (i == -1) goto _L7; else goto _L6
_L6:
        ((OutputStream) (obj7)).write(((byte []) (obj1)), 0, i);
          goto _L8
        obj1;
_L20:
        obj1 = ioexception;
        obj5 = obj7;
        StaticMethods.logWarningFormat("Cached Files - Timed out making request (%s)", new Object[] {
            url
        });
        obj1 = ioexception;
        obj5 = obj7;
        if (callback == null)
        {
            break MISSING_BLOCK_LABEL_1258;
        }
        obj1 = ioexception;
        obj5 = obj7;
        callback.call(false, null);
        if (obj7 != null)
        {
            try
            {
                ((OutputStream) (obj7)).close();
            }
            // Misplaced declaration of an exception variable
            catch (IOException ioexception)
            {
                StaticMethods.logWarningFormat("Cached Files - Exception while attempting to close streams (%s)", new Object[] {
                    ioexception.getLocalizedMessage()
                });
                return;
            }
        }
        if (ioexception == null)
        {
            break MISSING_BLOCK_LABEL_1276;
        }
        ioexception.close();
        httpurlconnection.disconnect();
        return;
_L7:
        StaticMethods.logDebugFormat("Cached Files - Caching successful (%s)", new Object[] {
            url
        });
        if (callback != null)
        {
            callback.call(true, ((File) (obj21)));
        }
        if (obj7 != null)
        {
            try
            {
                ((OutputStream) (obj7)).close();
            }
            // Misplaced declaration of an exception variable
            catch (IOException ioexception)
            {
                StaticMethods.logWarningFormat("Cached Files - Exception while attempting to close streams (%s)", new Object[] {
                    ioexception.getLocalizedMessage()
                });
                return;
            }
        }
        if (ioexception == null)
        {
            break MISSING_BLOCK_LABEL_1353;
        }
        ioexception.close();
        httpurlconnection.disconnect();
        return;
        obj7;
        ioexception = obj14;
_L18:
        obj1 = obj10;
        obj5 = ioexception;
        StaticMethods.logWarningFormat("Cached Files - IOException while making request (%s)", new Object[] {
            ((IOException) (obj7)).getLocalizedMessage()
        });
        obj1 = obj10;
        obj5 = ioexception;
        if (callback == null)
        {
            break MISSING_BLOCK_LABEL_1432;
        }
        obj1 = obj10;
        obj5 = ioexception;
        callback.call(false, null);
        if (ioexception != null)
        {
            try
            {
                ioexception.close();
            }
            // Misplaced declaration of an exception variable
            catch (IOException ioexception)
            {
                StaticMethods.logWarningFormat("Cached Files - Exception while attempting to close streams (%s)", new Object[] {
                    ioexception.getLocalizedMessage()
                });
                return;
            }
        }
        if (obj10 == null)
        {
            break MISSING_BLOCK_LABEL_1450;
        }
        ((InputStream) (obj10)).close();
        httpurlconnection.disconnect();
        return;
        obj7;
        ioexception = obj15;
_L16:
        obj1 = obj8;
        obj5 = ioexception;
        StaticMethods.logWarningFormat("Cached Files - Unexpected exception while attempting to get remote file (%s)", new Object[] {
            ((Exception) (obj7)).getLocalizedMessage()
        });
        obj1 = obj8;
        obj5 = ioexception;
        if (callback == null)
        {
            break MISSING_BLOCK_LABEL_1529;
        }
        obj1 = obj8;
        obj5 = ioexception;
        callback.call(false, null);
        if (ioexception != null)
        {
            try
            {
                ioexception.close();
            }
            // Misplaced declaration of an exception variable
            catch (IOException ioexception)
            {
                StaticMethods.logWarningFormat("Cached Files - Exception while attempting to close streams (%s)", new Object[] {
                    ioexception.getLocalizedMessage()
                });
                return;
            }
        }
        if (obj8 == null)
        {
            break MISSING_BLOCK_LABEL_1547;
        }
        ((InputStream) (obj8)).close();
        httpurlconnection.disconnect();
        return;
        obj7;
        ioexception = obj13;
_L14:
        obj1 = obj9;
        obj5 = ioexception;
        StaticMethods.logWarningFormat("Cached Files - Unexpected error while attempting to get remote file (%s)", new Object[] {
            ((Error) (obj7)).getLocalizedMessage()
        });
        obj1 = obj9;
        obj5 = ioexception;
        if (callback == null)
        {
            break MISSING_BLOCK_LABEL_1627;
        }
        obj1 = obj9;
        obj5 = ioexception;
        callback.call(false, null);
        if (ioexception != null)
        {
            try
            {
                ioexception.close();
            }
            // Misplaced declaration of an exception variable
            catch (IOException ioexception)
            {
                StaticMethods.logWarningFormat("Cached Files - Exception while attempting to close streams (%s)", new Object[] {
                    ioexception.getLocalizedMessage()
                });
                return;
            }
        }
        if (obj9 == null)
        {
            break MISSING_BLOCK_LABEL_1645;
        }
        ((InputStream) (obj9)).close();
        httpurlconnection.disconnect();
        return;
        ioexception;
_L12:
        if (obj5 == null)
        {
            break MISSING_BLOCK_LABEL_1678;
        }
        ((OutputStream) (obj5)).close();
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_1686;
        }
        ((InputStream) (obj1)).close();
        httpurlconnection.disconnect();
_L10:
        throw ioexception;
        obj1;
        StaticMethods.logWarningFormat("Cached Files - Exception while attempting to close streams (%s)", new Object[] {
            ((IOException) (obj1)).getLocalizedMessage()
        });
        if (true) goto _L10; else goto _L9
_L9:
        obj8;
        obj5 = obj7;
        obj1 = ioexception;
        ioexception = ((IOException) (obj8));
        if (true) goto _L12; else goto _L11
_L11:
        Object obj6;
        obj6;
        Object obj2 = obj7;
        obj7 = obj6;
        obj9 = ioexception;
        ioexception = ((IOException) (obj2));
        if (true) goto _L14; else goto _L13
_L13:
        obj6;
        Object obj3 = obj7;
        obj7 = obj6;
        obj8 = ioexception;
        ioexception = ((IOException) (obj3));
        if (true) goto _L16; else goto _L15
_L15:
        obj6;
        Object obj4 = obj7;
        obj7 = obj6;
        obj10 = ioexception;
        ioexception = ((IOException) (obj4));
        if (true) goto _L18; else goto _L17
_L17:
        SocketTimeoutException sockettimeoutexception;
        sockettimeoutexception;
        sockettimeoutexception = ((SocketTimeoutException) (obj11));
        obj7 = obj12;
        if (true) goto _L20; else goto _L19
_L19:
    }

    private ck(String s, ck ck, int i, int j, String s1)
    {
        url = s;
        callback = ck;
        connectionTimeout = i;
        readTimeout = j;
        directory = s1;
    }

    ck(String s, ck ck, int i, int j, String s1, ck ck1)
    {
        this(s, ck, i, j, s1);
    }
}
