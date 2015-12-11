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
import p;

// Referenced classes of package com.adobe.mobile:
//            StaticMethods, RemoteDownload

class ck
    implements Runnable
{

    private final ck callback;
    private final int connectionTimeout;
    private final String directory;
    private final int readTimeout;
    private final String url;

    protected static HttpURLConnection requestConnect(String s)
    {
        try
        {
            s = (HttpURLConnection)(new URL(s)).openConnection();
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
        byte abyte0[];
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        Object obj6;
        obj6 = null;
        obj5 = null;
        obj4 = null;
        obj2 = null;
        obj3 = null;
        abyte0 = null;
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
        HttpURLConnection httpurlconnection;
        Object obj8;
        obj = RemoteDownload.getFileForCachedURL(url, directory);
        obj8 = RemoteDownload.access$100();
        httpurlconnection = requestConnect(url);
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
        p.a(httpurlconnection);
        httpurlconnection.connect();
        p.b(httpurlconnection);
        p.a(httpurlconnection);
        int i;
        i = httpurlconnection.getResponseCode();
        p.b(httpurlconnection);
        p.c(httpurlconnection);
        if (i != 304) goto _L7; else goto _L6
_L6:
        StaticMethods.logDebugFormat("Cached Files - File has not been modified since last download. (%s)", new Object[] {
            url
        });
        if (callback != null)
        {
            callback.call(false, ((File) (obj)));
        }
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
            break MISSING_BLOCK_LABEL_356;
        }
        if (true)
        {
            break MISSING_BLOCK_LABEL_333;
        }
        throw new NullPointerException();
        httpurlconnection.disconnect();
        return;
        return;
        obj;
        p.a(httpurlconnection, ((IOException) (obj)));
        throw obj;
        obj;
        obj3 = null;
        obj = abyte0;
_L21:
        StaticMethods.logWarningFormat("Cached Files - Timed out making request (%s)", new Object[] {
            url
        });
        if (callback != null)
        {
            callback.call(false, null);
        }
        if (obj3 != null)
        {
            try
            {
                ((OutputStream) (obj3)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                StaticMethods.logWarningFormat("Cached Files - Exception while attempting to close streams (%s)", new Object[] {
                    ((IOException) (obj)).getLocalizedMessage()
                });
                return;
            }
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_424;
        }
        ((InputStream) (obj)).close();
        httpurlconnection.disconnect();
        return;
        obj;
        p.a(httpurlconnection, ((IOException) (obj)));
        throw obj;
        obj3;
        obj = null;
        obj4 = obj6;
_L19:
        obj2 = obj4;
        abyte0 = ((byte []) (obj));
        StaticMethods.logWarningFormat("Cached Files - IOException while making request (%s)", new Object[] {
            ((IOException) (obj3)).getLocalizedMessage()
        });
        obj2 = obj4;
        abyte0 = ((byte []) (obj));
        if (callback == null)
        {
            break MISSING_BLOCK_LABEL_515;
        }
        obj2 = obj4;
        abyte0 = ((byte []) (obj));
        callback.call(false, null);
        if (obj4 != null)
        {
            try
            {
                ((OutputStream) (obj4)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                StaticMethods.logWarningFormat("Cached Files - Exception while attempting to close streams (%s)", new Object[] {
                    ((IOException) (obj)).getLocalizedMessage()
                });
                return;
            }
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_533;
        }
        ((InputStream) (obj)).close();
        httpurlconnection.disconnect();
        return;
_L7:
        p.a(httpurlconnection);
        i = httpurlconnection.getResponseCode();
        p.b(httpurlconnection);
        p.c(httpurlconnection);
        if (i != 404) goto _L9; else goto _L8
_L8:
        StaticMethods.logDebugFormat("Cached Files - File not found. (%s)", new Object[] {
            url
        });
        if (callback != null)
        {
            callback.call(false, ((File) (obj)));
        }
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
            break MISSING_BLOCK_LABEL_668;
        }
        if (true)
        {
            break MISSING_BLOCK_LABEL_645;
        }
        throw new NullPointerException();
        httpurlconnection.disconnect();
        return;
        return;
        obj;
        p.a(httpurlconnection, ((IOException) (obj)));
        throw obj;
        obj3;
        obj = null;
        obj4 = obj5;
_L18:
        obj2 = obj4;
        abyte0 = ((byte []) (obj));
        StaticMethods.logWarningFormat("Cached Files - Unexpected exception while attempting to get remote file (%s)", new Object[] {
            ((Exception) (obj3)).getLocalizedMessage()
        });
        obj2 = obj4;
        abyte0 = ((byte []) (obj));
        if (callback == null)
        {
            break MISSING_BLOCK_LABEL_736;
        }
        obj2 = obj4;
        abyte0 = ((byte []) (obj));
        callback.call(false, null);
        if (obj4 != null)
        {
            try
            {
                ((OutputStream) (obj4)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                StaticMethods.logWarningFormat("Cached Files - Exception while attempting to close streams (%s)", new Object[] {
                    ((IOException) (obj)).getLocalizedMessage()
                });
                return;
            }
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_754;
        }
        ((InputStream) (obj)).close();
        httpurlconnection.disconnect();
        return;
_L9:
        p.a(httpurlconnection);
        i = httpurlconnection.getResponseCode();
        p.b(httpurlconnection);
        p.c(httpurlconnection);
        if (i == 200) goto _L11; else goto _L10
_L10:
        Object obj7;
        obj7 = url;
        p.a(httpurlconnection);
        i = httpurlconnection.getResponseCode();
        p.b(httpurlconnection);
        p.c(httpurlconnection);
        p.a(httpurlconnection);
        obj3 = httpurlconnection.getResponseMessage();
        p.b(httpurlconnection);
        p.c(httpurlconnection);
        StaticMethods.logWarningFormat("Cached Files - File could not be downloaded from URL (%s) Response: (%d) Message: (%s)", new Object[] {
            obj7, Integer.valueOf(i), obj3
        });
        if (callback != null)
        {
            callback.call(false, ((File) (obj)));
        }
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
            break MISSING_BLOCK_LABEL_950;
        }
        if (true)
        {
            break MISSING_BLOCK_LABEL_927;
        }
        throw new NullPointerException();
        httpurlconnection.disconnect();
        return;
        return;
        obj;
        p.a(httpurlconnection, ((IOException) (obj)));
        throw obj;
        obj3;
        obj = null;
_L17:
        obj2 = obj4;
        abyte0 = ((byte []) (obj));
        StaticMethods.logWarningFormat("Cached Files - Unexpected error while attempting to get remote file (%s)", new Object[] {
            ((Error) (obj3)).getLocalizedMessage()
        });
        obj2 = obj4;
        abyte0 = ((byte []) (obj));
        if (callback == null)
        {
            break MISSING_BLOCK_LABEL_1014;
        }
        obj2 = obj4;
        abyte0 = ((byte []) (obj));
        callback.call(false, null);
        if (obj4 != null)
        {
            try
            {
                ((OutputStream) (obj4)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                StaticMethods.logWarningFormat("Cached Files - Exception while attempting to close streams (%s)", new Object[] {
                    ((IOException) (obj)).getLocalizedMessage()
                });
                return;
            }
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_1032;
        }
        ((InputStream) (obj)).close();
        httpurlconnection.disconnect();
        return;
        obj;
        p.a(httpurlconnection, ((IOException) (obj)));
        throw obj;
        obj3;
        obj = null;
_L16:
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_1077;
        }
        ((OutputStream) (obj2)).close();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_1085;
        }
        ((InputStream) (obj)).close();
        httpurlconnection.disconnect();
_L14:
        throw obj3;
        obj;
        p.a(httpurlconnection, ((IOException) (obj)));
        throw obj;
_L11:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_1118;
        }
        RemoteDownload.deleteCachedDataForURL(url, directory);
        p.a(httpurlconnection);
        long l = httpurlconnection.getLastModified();
        p.b(httpurlconnection);
        p.c(httpurlconnection);
        obj8 = new Date(l);
        p.a(httpurlconnection);
        obj7 = httpurlconnection.getHeaderField("ETag");
        p.b(httpurlconnection);
        p.c(httpurlconnection);
        obj = obj7;
        if (obj7 == null)
        {
            break MISSING_BLOCK_LABEL_1189;
        }
        obj = StaticMethods.getHexString(((String) (obj7)));
        obj7 = RemoteDownload.access$400(url, ((Date) (obj8)), ((String) (obj)), directory);
        if (obj7 != null)
        {
            break MISSING_BLOCK_LABEL_1276;
        }
        if (callback != null)
        {
            callback.call(false, null);
        }
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
            break MISSING_BLOCK_LABEL_1275;
        }
        if (true)
        {
            break MISSING_BLOCK_LABEL_1252;
        }
        throw new NullPointerException();
        httpurlconnection.disconnect();
        return;
        return;
        obj = p.d(httpurlconnection);
        obj2 = obj3;
        abyte0 = ((byte []) (obj));
        obj3 = new FileOutputStream(((File) (obj7)));
        abyte0 = new byte[4096];
_L12:
        i = ((InputStream) (obj)).read(abyte0);
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_1329;
        }
        ((OutputStream) (obj3)).write(abyte0, 0, i);
          goto _L12
        StaticMethods.logDebugFormat("Cached Files - Caching successful (%s)", new Object[] {
            url
        });
        if (callback != null)
        {
            callback.call(true, ((File) (obj7)));
        }
        if (obj3 != null)
        {
            try
            {
                ((OutputStream) (obj3)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                StaticMethods.logWarningFormat("Cached Files - Exception while attempting to close streams (%s)", new Object[] {
                    ((IOException) (obj)).getLocalizedMessage()
                });
                return;
            }
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_1382;
        }
        ((InputStream) (obj)).close();
        httpurlconnection.disconnect();
        return;
        obj;
        StaticMethods.logWarningFormat("Cached Files - Exception while attempting to close streams (%s)", new Object[] {
            ((IOException) (obj)).getLocalizedMessage()
        });
        if (true) goto _L14; else goto _L13
_L13:
        obj3;
        obj = abyte0;
        continue; /* Loop/switch isn't completed */
        Object obj1;
        obj1;
        obj2 = obj3;
        obj3 = obj1;
        continue; /* Loop/switch isn't completed */
        obj1;
        obj2 = obj3;
        obj3 = obj1;
        if (true) goto _L16; else goto _L15
_L15:
        obj3;
          goto _L17
        obj1;
        obj4 = obj3;
        obj3 = obj1;
          goto _L17
        obj3;
        obj4 = obj5;
          goto _L18
        obj1;
        obj4 = obj3;
        obj3 = obj1;
          goto _L18
        obj3;
        obj4 = obj6;
          goto _L19
        obj1;
        obj4 = obj3;
        obj3 = obj1;
          goto _L19
        obj1;
        obj3 = null;
        continue; /* Loop/switch isn't completed */
        obj1;
        if (true) goto _L21; else goto _L20
_L20:
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
