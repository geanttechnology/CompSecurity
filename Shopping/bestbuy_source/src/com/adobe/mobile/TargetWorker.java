// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adobe.mobile;

import android.content.SharedPreferences;
import java.net.HttpCookie;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;

// Referenced classes of package com.adobe.mobile:
//            StaticMethods, MobileConfig, VisitorIDService, TargetLocationRequest, 
//            Lifecycle

final class TargetWorker
{

    protected static final String COOKIE_EXPIRES_KEY_SUFFIX = "_Expires";
    protected static final String COOKIE_NAME_PCID = "mboxPC";
    protected static final String COOKIE_NAME_SESSION = "mboxSession";
    protected static final String COOKIE_VALUE_KEY_SUFFIX = "_Value";
    protected static final String LOCATION_CONTENT_TYPE = "text%2Fplain%3Bcharset%3Dutf-8";
    protected static final String LOCATION_SERVER_SUFFIX = ".tt.omtrdc.net";
    protected static final String LOCATION_SESSION_STRING = "&mboxSession=%s&mboxPC=%s&mboxXDomain=disabled";
    private static final String OFFER_ENCODING = "UTF-8";
    private static final int TO_MILLI = 1000;
    private static final Object _parameterMutex = new Object();
    private static String _pcId;
    private static final Object _pcIdMutex = new Object();
    private static HashMap _persistentParameters;
    private static String _serverURL = null;
    private static final Object _serverURLMutex = new Object();
    private static String _sessionId;
    private static final Object _sessionIdMutex = new Object();

    TargetWorker()
    {
    }

    protected static void addPersistentParameter(String s, String s1)
    {
        if (s == null || s1 == null)
        {
            return;
        }
        synchronized (_parameterMutex)
        {
            if (_persistentParameters == null)
            {
                _persistentParameters = new HashMap();
            }
            _persistentParameters.put(s, s1);
        }
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    protected static void clearCookies()
    {
        deleteCookie("mboxSession");
        deleteCookie("mboxPC");
    }

    private static void deleteCookie(String s)
    {
        if (s.equals("mboxSession"))
        {
            synchronized (_sessionIdMutex)
            {
                _sessionId = null;
            }
        } else
        if (s.equals("mboxPC"))
        {
            synchronized (_pcIdMutex)
            {
                _pcId = null;
            }
        }
        try
        {
            obj = StaticMethods.getSharedPreferencesEditor();
            ((android.content.SharedPreferences.Editor) (obj)).remove((new StringBuilder()).append(s).append("_Value").toString());
            ((android.content.SharedPreferences.Editor) (obj)).remove((new StringBuilder()).append(s).append("_Expires").toString());
            ((android.content.SharedPreferences.Editor) (obj)).commit();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            StaticMethods.logErrorFormat("Target - Error persisting cookies (%s)", new Object[] {
                s.getMessage()
            });
        }
        break MISSING_BLOCK_LABEL_136;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
        s;
        obj1;
        JVM INSTR monitorexit ;
        throw s;
    }

    private static String getCookieValue(String s)
    {
        long l = StaticMethods.getSharedPreferences().getLong((new StringBuilder()).append(s).append("_Expires").toString(), 0L);
        if (l <= 0L)
        {
            break MISSING_BLOCK_LABEL_101;
        }
        String s1;
        if (l <= System.currentTimeMillis())
        {
            break MISSING_BLOCK_LABEL_101;
        }
        s1 = StaticMethods.getSharedPreferences().getString((new StringBuilder()).append(s).append("_Value").toString(), "");
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_105;
        }
        return (new StringBuilder()).append(s).append("=").append(s1).toString();
        deleteCookie(s);
_L2:
        return "";
        s;
        StaticMethods.logErrorFormat("Target - Error loading cookie data (%s)", new Object[] {
            s.getMessage()
        });
        if (true) goto _L2; else goto _L1
_L1:
    }

    private static String getParamsString(Map map)
    {
        if (map == null || map.size() == 0)
        {
            return "";
        }
        StringBuilder stringbuilder = new StringBuilder();
        map = map.entrySet().iterator();
        do
        {
            if (!map.hasNext())
            {
                break;
            }
            Object obj = (java.util.Map.Entry)map.next();
            String s = (String)((java.util.Map.Entry) (obj)).getKey();
            obj = ((java.util.Map.Entry) (obj)).getValue();
            if (s != null && s.length() > 0 && obj != null && obj.toString().length() > 0)
            {
                stringbuilder.append("&");
                stringbuilder.append(StaticMethods.URLEncode(s));
                stringbuilder.append("=");
                stringbuilder.append(StaticMethods.URLEncode(obj.toString()));
            }
        } while (true);
        return stringbuilder.toString();
    }

    protected static String getPcID()
    {
        String s;
        synchronized (_pcIdMutex)
        {
            s = _pcId;
        }
        return s;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private static String getServerURL(String s)
    {
        Object obj = _serverURLMutex;
        obj;
        JVM INSTR monitorenter ;
        StringBuilder stringbuilder;
        if (_serverURL != null)
        {
            break MISSING_BLOCK_LABEL_52;
        }
        stringbuilder = new StringBuilder();
        String s1;
        if (MobileConfig.getInstance().getSSL())
        {
            s1 = "https://";
        } else
        {
            s1 = "http://";
        }
        _serverURL = stringbuilder.append(s1).append(s).append(".tt.omtrdc.net").toString();
        s = _serverURL;
        obj;
        JVM INSTR monitorexit ;
        return s;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    protected static String getSessionID()
    {
        String s;
        synchronized (_sessionIdMutex)
        {
            s = _sessionId;
        }
        return s;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private static String getSessionString()
    {
        String s;
        synchronized (_pcIdMutex)
        {
            s = _pcId;
        }
        String s1;
        synchronized (_sessionIdMutex)
        {
            s1 = _sessionId;
        }
        if (s1 != null && s1.trim().length() > 0 && s != null && s.trim().length() > 0)
        {
            return String.format("&mboxSession=%s&mboxPC=%s&mboxXDomain=disabled", new Object[] {
                s1, s
            });
        } else
        {
            return "";
        }
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        exception1;
        obj;
        JVM INSTR monitorexit ;
        throw exception1;
    }

    private static String getURLRequestString(String s, Map map)
    {
        if (s == null || s.length() <= 0 || !MobileConfig.getInstance().mobileUsingTarget())
        {
            return null;
        }
        String s2;
        synchronized (_parameterMutex)
        {
            s2 = getParamsString(_persistentParameters);
        }
        obj = new FutureTask(new Callable() {

            public volatile Object call()
            {
                return call();
            }

            public HashMap call()
            {
                return Lifecycle.getContextData();
            }

        });
        StaticMethods.getAnalyticsExecutor().execute(((Runnable) (obj)));
        String s1;
        StringBuilder stringbuilder;
        try
        {
            obj = (HashMap)((FutureTask) (obj)).get();
        }
        catch (Exception exception)
        {
            StaticMethods.logDebugFormat("Target - Unable to get lifecycle data (%s)", new Object[] {
                exception.getMessage()
            });
            exception = null;
        }
        stringbuilder = (new StringBuilder()).append(getServerURL(MobileConfig.getInstance().getClientCode())).append("/m2/").append(MobileConfig.getInstance().getClientCode()).append("/ubox/raw?mboxContentType=").append("text%2Fplain%3Bcharset%3Dutf-8").append("&t=").append(StaticMethods.getTimeSince1970()).append(getSessionString()).append("&mboxDefault=none&mbox=").append(s);
        if (MobileConfig.getInstance().getVisitorIdServiceEnabled())
        {
            s1 = VisitorIDService.sharedInstance().getTargetParameterString();
        } else
        {
            s1 = "";
        }
        map = stringbuilder.append(s1).append(getParamsString(map)).append(getParamsString(((Map) (obj)))).append(s2).toString();
        StaticMethods.logDebugFormat("Target - LocationRequest (%s) loading URL: %s", new Object[] {
            s, map
        });
        return map;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    protected static void loadRequest(TargetLocationRequest targetlocationrequest, Target.TargetCallback targetcallback)
    {
        if (targetlocationrequest == null)
        {
            StaticMethods.logWarningFormat("Target - LocationRequest parameter is null", new Object[0]);
            if (targetcallback != null)
            {
                targetcallback.call(null);
            }
            return;
        } else
        {
            (new Thread(new SendRequestTask(targetlocationrequest, targetcallback))).start();
            return;
        }
    }

    private static void readAndStoreCookiesFromHeaders(Map map)
    {
        map = (List)map.get("Set-Cookie");
        if (map != null)
        {
            map = map.iterator();
            while (map.hasNext()) 
            {
                Iterator iterator = HttpCookie.parse((String)map.next()).iterator();
                while (iterator.hasNext()) 
                {
                    HttpCookie httpcookie = (HttpCookie)iterator.next();
                    obj = httpcookie.getName();
                    if (((String) (obj)).equals("mboxSession"))
                    {
                        synchronized (_sessionIdMutex)
                        {
                            _sessionId = httpcookie.getValue();
                        }
                        storeCookie(httpcookie);
                    } else
                    if (((String) (obj)).equals("mboxPC"))
                    {
                        synchronized (_pcIdMutex)
                        {
                            _pcId = httpcookie.getValue();
                        }
                        storeCookie(httpcookie);
                    }
                }
            }
        }
        return;
        map;
        obj;
        JVM INSTR monitorexit ;
        throw map;
        map;
        obj1;
        JVM INSTR monitorexit ;
        throw map;
    }

    protected static void removePersistentParameter(String s)
    {
        if (s == null)
        {
            return;
        }
        synchronized (_parameterMutex)
        {
            if (_persistentParameters != null)
            {
                _persistentParameters.remove(s);
            }
        }
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    private static void storeCookie(HttpCookie httpcookie)
    {
        try
        {
            android.content.SharedPreferences.Editor editor = StaticMethods.getSharedPreferencesEditor();
            editor.putString((new StringBuilder()).append(httpcookie.getName()).append("_Value").toString(), httpcookie.getValue());
            editor.putLong((new StringBuilder()).append(httpcookie.getName()).append("_Expires").toString(), httpcookie.getMaxAge() * 1000L + System.currentTimeMillis());
            editor.commit();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (HttpCookie httpcookie)
        {
            StaticMethods.logErrorFormat("Target - Error persisting cookie (%s)", new Object[] {
                httpcookie.getLocalizedMessage()
            });
        }
    }





    private class SendRequestTask
        implements Runnable
    {

        private Target.TargetCallback callback;
        private BigDecimal lifetimeValue;
        private TargetLocationRequest request;

        public void run()
        {
            String s;
            if (lifetimeValue != null)
            {
                TargetWorker.addPersistentParameter("a.ltv.amount", lifetimeValue.toString());
            }
            s = TargetWorker.getURLRequestString(request.name, request.parameters);
            if (s != null && s.length() > 0) goto _L2; else goto _L1
_L1:
            StaticMethods.logWarningFormat("Target - LocationRequest requires a name.", new Object[0]);
            if (callback != null)
            {
                callback.call(request.defaultContent);
            }
_L4:
            return;
_L2:
            byte abyte0[] = RequestHandler.retrieveData(s, MobileConfig.getInstance().getDefaultLocationTimeout() * 1000, "Target", new Callable() {

                final SendRequestTask this$0;

                public volatile Object call()
                {
                    return call();
                }

                public Map call()
                {
                    String s2 = TargetWorker.getCookieValue("mboxPC");
                    Object obj = TargetWorker.getCookieValue("mboxSession");
                    StringBuilder stringbuilder = (new StringBuilder()).append(s2);
                    if (s2.length() > 0)
                    {
                        s2 = "; ";
                    } else
                    {
                        s2 = "";
                    }
                    s2 = stringbuilder.append(s2).append(((String) (obj))).toString();
                    obj = new HashMap();
                    ((Map) (obj)).put("Cookie", s2);
                    return ((Map) (obj));
                }

                
                {
                    this$0 = SendRequestTask.this;
                    super();
                }
            }, new RequestHandler.HeaderCallback() {

                final SendRequestTask this$0;

                public void call(Map map)
                {
                    TargetWorker.readAndStoreCookiesFromHeaders(map);
                }

                
                {
                    this$0 = SendRequestTask.this;
                    super();
                }
            });
            if (abyte0 == null)
            {
                break MISSING_BLOCK_LABEL_155;
            }
            RuntimeException runtimeexception;
            if (abyte0.length > 0)
            {
                String s1 = new String(abyte0, "UTF-8");
                if (callback != null)
                {
                    callback.call(s1);
                    return;
                }
                continue; /* Loop/switch isn't completed */
            }
            try
            {
                StaticMethods.logWarningFormat("Target - No content found or user didn't qualify for campaign for LocationRequest (%s)", new Object[] {
                    request.name
                });
                if (callback != null)
                {
                    callback.call(request.defaultContent);
                    return;
                }
            }
            // Misplaced declaration of an exception variable
            catch (RuntimeException runtimeexception)
            {
                throw runtimeexception;
            }
            catch (Exception exception)
            {
                StaticMethods.logWarningFormat("Target - Unable to retrieve content (%s)", new Object[] {
                    exception.getLocalizedMessage()
                });
                if (callback != null)
                {
                    callback.call(request.defaultContent);
                    return;
                }
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        private SendRequestTask(TargetLocationRequest targetlocationrequest, Target.TargetCallback targetcallback)
        {
            request = targetlocationrequest;
            callback = targetcallback;
            lifetimeValue = AnalyticsTrackLifetimeValueIncrease.getLifetimeValue();
        }

    }

}
