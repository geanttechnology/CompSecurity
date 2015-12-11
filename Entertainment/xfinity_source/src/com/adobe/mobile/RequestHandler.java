// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adobe.mobile;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.conn.ssl.StrictHostnameVerifier;

// Referenced classes of package com.adobe.mobile:
//            StaticMethods, WearableFunctionBridge, MobileConfig

final class RequestHandler
{

    private static final int BUF_SIZE = 1024;
    private static final int CONNECTION_TIMEOUT = 2000;
    private static final Object _hostnameVerifierMutex = new Object();
    private static StrictHostnameVerifier _strictHostnameVerifier = null;

    RequestHandler()
    {
    }

    private static HttpURLConnection requestConnect(String s)
    {
        obj = new URL(s);
        if (!((URL) (obj)).getProtocol().equals("https"))
        {
            break MISSING_BLOCK_LABEL_86;
        }
        synchronized (_hostnameVerifierMutex)
        {
            if (_strictHostnameVerifier == null)
            {
                _strictHostnameVerifier = new StrictHostnameVerifier();
            }
        }
        s = (HttpsURLConnection)((URL) (obj)).openConnection();
        s.setHostnameVerifier(_strictHostnameVerifier);
        return s;
        obj;
        s;
        JVM INSTR monitorexit ;
        try
        {
            throw obj;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            StaticMethods.logErrorFormat("Adobe Mobile - Exception opening URL(%s)", new Object[] {
                s.getLocalizedMessage()
            });
        }
        return null;
        s = (HttpURLConnection)((URL) (obj)).openConnection();
        return s;
    }

    protected static byte[] retrieveData(String s, Map map, int i, String s1)
    {
        if (!StaticMethods.isWearableApp()) goto _L2; else goto _L1
_L1:
        s = WearableFunctionBridge.retrieveData(s, i);
_L6:
        return s;
_L2:
        Map map1;
        Map map2;
        Map map3;
        byte abyte1[];
        ByteArrayOutputStream bytearrayoutputstream;
        Object obj;
        Object obj1;
        HttpURLConnection httpurlconnection;
        httpurlconnection = requestConnect(s);
        if (httpurlconnection == null)
        {
            return null;
        }
        obj = null;
        abyte1 = null;
        obj1 = null;
        bytearrayoutputstream = null;
        map3 = bytearrayoutputstream;
        map1 = obj;
        map2 = abyte1;
        s = obj1;
        httpurlconnection.setConnectTimeout(2000);
        map3 = bytearrayoutputstream;
        map1 = obj;
        map2 = abyte1;
        s = obj1;
        httpurlconnection.setReadTimeout(i);
        if (map == null)
        {
            break; /* Loop/switch isn't completed */
        }
        map3 = bytearrayoutputstream;
        map1 = obj;
        map2 = abyte1;
        s = obj1;
        map = map.entrySet().iterator();
_L4:
        map3 = bytearrayoutputstream;
        map1 = obj;
        map2 = abyte1;
        s = obj1;
        if (!map.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        map3 = bytearrayoutputstream;
        map1 = obj;
        map2 = abyte1;
        s = obj1;
        java.util.Map.Entry entry = (java.util.Map.Entry)map.next();
        map3 = bytearrayoutputstream;
        map1 = obj;
        map2 = abyte1;
        s = obj1;
        httpurlconnection.setRequestProperty((String)entry.getKey(), (String)entry.getValue());
        if (true) goto _L4; else goto _L3
_L3:
        break; /* Loop/switch isn't completed */
        map;
        s = map3;
        StaticMethods.logWarningFormat("%s - IOException while sending request (%s)", new Object[] {
            s1, map.getLocalizedMessage()
        });
        s = null;
        httpurlconnection.disconnect();
        if (map3 != null)
        {
            try
            {
                map3.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                StaticMethods.logWarningFormat("%s - Unable to close stream (%s)", new Object[] {
                    s1, s.getLocalizedMessage()
                });
                return null;
            }
            return null;
        }
        if (true) goto _L6; else goto _L5
_L5:
        map3 = bytearrayoutputstream;
        map1 = obj;
        map2 = abyte1;
        s = obj1;
        if (httpurlconnection.getResponseCode() != 200)
        {
            break; /* Loop/switch isn't completed */
        }
        map3 = bytearrayoutputstream;
        map1 = obj;
        map2 = abyte1;
        s = obj1;
        map = httpurlconnection.getInputStream();
        map3 = map;
        map1 = map;
        map2 = map;
        s = map;
        abyte1 = new byte[1024];
        map3 = map;
        map1 = map;
        map2 = map;
        s = map;
        bytearrayoutputstream = new ByteArrayOutputStream();
_L7:
        map3 = map;
        map1 = map;
        map2 = map;
        s = map;
        if (map.read(abyte1) == -1)
        {
            break MISSING_BLOCK_LABEL_466;
        }
        map3 = map;
        map1 = map;
        map2 = map;
        s = map;
        bytearrayoutputstream.write(abyte1);
          goto _L7
        map;
        s = map1;
        StaticMethods.logWarningFormat("%s - Exception while sending request (%s)", new Object[] {
            s1, map.getLocalizedMessage()
        });
        s = null;
        httpurlconnection.disconnect();
        if (map1 != null)
        {
            try
            {
                map1.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                StaticMethods.logWarningFormat("%s - Unable to close stream (%s)", new Object[] {
                    s1, s.getLocalizedMessage()
                });
                return null;
            }
            return null;
        }
        continue; /* Loop/switch isn't completed */
        map3 = map;
        map1 = map;
        map2 = map;
        s = map;
        map.close();
        map3 = map;
        map1 = map;
        map2 = map;
        s = map;
        abyte1 = bytearrayoutputstream.toByteArray();
        byte abyte0[] = abyte1;
        httpurlconnection.disconnect();
        s = abyte0;
        if (map != null)
        {
            try
            {
                map.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                StaticMethods.logWarningFormat("%s - Unable to close stream (%s)", new Object[] {
                    s1, s.getLocalizedMessage()
                });
                return abyte0;
            }
            return abyte0;
        }
        if (true) goto _L6; else goto _L8
_L8:
        httpurlconnection.disconnect();
        if (false)
        {
            try
            {
                throw new NullPointerException();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                StaticMethods.logWarningFormat("%s - Unable to close stream (%s)", new Object[] {
                    s1, s.getLocalizedMessage()
                });
            }
        }
        return null;
        map;
        s = map2;
        StaticMethods.logWarningFormat("%s - Unexpected error while sending request (%s)", new Object[] {
            s1, map.getLocalizedMessage()
        });
        s = null;
        httpurlconnection.disconnect();
        if (map2 == null) goto _L6; else goto _L9
_L9:
        try
        {
            map2.close();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            StaticMethods.logWarningFormat("%s - Unable to close stream (%s)", new Object[] {
                s1, s.getLocalizedMessage()
            });
            return null;
        }
        return null;
        map;
        httpurlconnection.disconnect();
        if (s != null)
        {
            try
            {
                s.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                StaticMethods.logWarningFormat("%s - Unable to close stream (%s)", new Object[] {
                    s1, s.getLocalizedMessage()
                });
            }
        }
        throw map;
    }

    protected static boolean sendAnalyticsRequest(String s, String s1, Map map, int i, String s2)
    {
        if (s != null) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        if (StaticMethods.isWearableApp())
        {
            return WearableFunctionBridge.sendAnalyticsRequest(s, s1, i, s2);
        }
        s = requestConnect(s);
        if (s == null)
        {
            return false;
        }
        byte abyte0[];
        s.setConnectTimeout(i);
        s.setReadTimeout(i);
        s.setRequestMethod("POST");
        abyte0 = s1.getBytes("UTF-8");
        s.setFixedLengthStreamingMode(abyte0.length);
        s.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        if (map == null)
        {
            break MISSING_BLOCK_LABEL_168;
        }
        java.util.Map.Entry entry;
        for (map = map.entrySet().iterator(); map.hasNext(); s.setRequestProperty((String)entry.getKey(), (String)entry.getValue()))
        {
            entry = (java.util.Map.Entry)map.next();
        }

        break MISSING_BLOCK_LABEL_168;
        map;
        StaticMethods.logDebugFormat("%s - Timed out sending request(%s)", new Object[] {
            s2, s1
        });
        if (MobileConfig.getInstance().getSSL()) goto _L1; else goto _L3
_L3:
        s.disconnect();
        return false;
        map = new BufferedOutputStream(s.getOutputStream());
        map.write(abyte0);
        map.close();
        map = s.getInputStream();
        if (!MobileConfig.getInstance().getSSL()) goto _L5; else goto _L4
_L4:
        for (byte abyte1[] = new byte[10]; map.read(abyte1) > 0;) { }
_L6:
        map.close();
        StaticMethods.logDebugFormat("%s - Request Sent(%s)", new Object[] {
            s2, s1
        });
        if (!MobileConfig.getInstance().getSSL())
        {
            s.disconnect();
        }
_L7:
        return true;
_L5:
        s.getResponseCode();
          goto _L6
        s1;
        StaticMethods.logDebugFormat("%s - IOException while sending request, may retry(%s)", new Object[] {
            s2, s1.getLocalizedMessage()
        });
        if (!MobileConfig.getInstance().getSSL())
        {
            s.disconnect();
            return false;
        }
          goto _L1
        s1;
        StaticMethods.logErrorFormat("%s - Exception while attempting to send hit, will not retry(%s)", new Object[] {
            s2, s1.getLocalizedMessage()
        });
        if (!MobileConfig.getInstance().getSSL())
        {
            s.disconnect();
        }
          goto _L7
        s1;
        StaticMethods.logErrorFormat("%s - Exception while attempting to send hit, will not retry(%s)", new Object[] {
            s2, s1.getLocalizedMessage()
        });
        if (!MobileConfig.getInstance().getSSL())
        {
            s.disconnect();
        }
          goto _L7
        s1;
        if (!MobileConfig.getInstance().getSSL())
        {
            s.disconnect();
        }
        throw s1;
          goto _L6
    }

    protected static void sendGenericRequest(String s, Map map, int i, String s1)
    {
        if (s != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (StaticMethods.isWearableApp())
        {
            WearableFunctionBridge.sendGenericRequest(s, i, s1);
            return;
        }
        HttpURLConnection httpurlconnection = requestConnect(s);
        if (httpurlconnection == null) goto _L1; else goto _L3
_L3:
        httpurlconnection.setConnectTimeout(i);
        httpurlconnection.setReadTimeout(i);
        if (map == null)
        {
            break MISSING_BLOCK_LABEL_139;
        }
        map = map.entrySet().iterator();
        do
        {
            if (!map.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)map.next();
            String s2 = (String)entry.getValue();
            if (s2.trim().length() > 0)
            {
                httpurlconnection.setRequestProperty((String)entry.getKey(), s2);
            }
        } while (true);
        try
        {
            StaticMethods.logDebugFormat("%s - Request Sent(%s)", new Object[] {
                s1, s
            });
            httpurlconnection.getResponseCode();
            httpurlconnection.getInputStream().close();
            httpurlconnection.disconnect();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            StaticMethods.logWarningFormat("%s - Timed out sending request(%s)", new Object[] {
                s1, s
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            StaticMethods.logWarningFormat("%s - IOException while sending request, may retry(%s)", new Object[] {
                s1, s.getLocalizedMessage()
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            StaticMethods.logWarningFormat("%s - Exception while attempting to send hit, will not retry(%s)", new Object[] {
                s1, s.getLocalizedMessage()
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            StaticMethods.logWarningFormat("%s - Exception while attempting to send hit, will not retry(%s)", new Object[] {
                s1, s.getLocalizedMessage()
            });
        }
        return;
    }

    protected static boolean sendThirdPartyRequest(String s, String s1, Map map, int i, String s2, String s3)
    {
        HttpURLConnection httpurlconnection;
        if (s == null)
        {
            return false;
        }
        if (StaticMethods.isWearableApp())
        {
            return WearableFunctionBridge.sendThirdPartyRequest(s, s1, i, s2, s3);
        }
        httpurlconnection = requestConnect(s);
        if (httpurlconnection == null)
        {
            return false;
        }
        httpurlconnection.setConnectTimeout(i);
        httpurlconnection.setReadTimeout(i);
        httpurlconnection.setRequestMethod("GET");
        if (map == null)
        {
            break MISSING_BLOCK_LABEL_141;
        }
        byte abyte0[];
        byte abyte1[];
        try
        {
            java.util.Map.Entry entry;
            for (map = map.entrySet().iterator(); map.hasNext(); httpurlconnection.setRequestProperty((String)entry.getKey(), (String)entry.getValue()))
            {
                entry = (java.util.Map.Entry)map.next();
            }

            break MISSING_BLOCK_LABEL_141;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            StaticMethods.logDebugFormat("%s - Timed out sending request (%s)", new Object[] {
                s3, s1
            });
            return false;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            StaticMethods.logDebugFormat("%s - IOException while sending request, will not retry (%s)", new Object[] {
                s3, s.getLocalizedMessage()
            });
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            StaticMethods.logErrorFormat("%s - Exception while attempting to send hit, will not retry (%s)", new Object[] {
                s3, s.getLocalizedMessage()
            });
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            StaticMethods.logErrorFormat("%s - Exception while attempting to send hit, will not retry (%s)", new Object[] {
                s3, s.getLocalizedMessage()
            });
        }
          goto _L1
        if (s1 == null) goto _L3; else goto _L2
_L2:
        if (s1.length() <= 0) goto _L3; else goto _L4
_L4:
        httpurlconnection.setRequestMethod("POST");
        if (s2 == null) goto _L6; else goto _L5
_L5:
        if (s2.length() <= 0) goto _L6; else goto _L7
_L7:
        map = s2;
_L9:
        abyte1 = s1.getBytes("UTF-8");
        httpurlconnection.setFixedLengthStreamingMode(abyte1.length);
        httpurlconnection.setRequestProperty("Content-Type", map);
        map = new BufferedOutputStream(httpurlconnection.getOutputStream());
        map.write(abyte1);
        map.close();
_L3:
        map = httpurlconnection.getInputStream();
        for (abyte0 = new byte[10]; map.read(abyte0) > 0;) { }
        map.close();
        StaticMethods.logDebugFormat("%s - Successfully forwarded hit (%s body: %s type: %s)", new Object[] {
            s3, s, s1, s2
        });
          goto _L1
_L6:
        map = "application/x-www-form-urlencoded";
        continue; /* Loop/switch isn't completed */
_L1:
        return true;
        if (true) goto _L9; else goto _L8
_L8:
    }

}
