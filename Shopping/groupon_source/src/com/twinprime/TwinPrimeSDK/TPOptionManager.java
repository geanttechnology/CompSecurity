// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.TwinPrimeSDK;

import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.twinprime.TwinPrimeSDK:
//            TPLog

class TPOptionManager
{
    static final class TPOptionCache extends Enum
    {

        private static final TPOptionCache $VALUES[];
        public static final TPOptionCache TPOptionCache_disable;
        public static final TPOptionCache TPOptionCache_enable;

        public static TPOptionCache valueOf(String s)
        {
            return (TPOptionCache)Enum.valueOf(com/twinprime/TwinPrimeSDK/TPOptionManager$TPOptionCache, s);
        }

        public static TPOptionCache[] values()
        {
            return (TPOptionCache[])$VALUES.clone();
        }

        static 
        {
            TPOptionCache_disable = new TPOptionCache("TPOptionCache_disable", 0);
            TPOptionCache_enable = new TPOptionCache("TPOptionCache_enable", 1);
            $VALUES = (new TPOptionCache[] {
                TPOptionCache_disable, TPOptionCache_enable
            });
        }

        private TPOptionCache(String s, int i)
        {
            super(s, i);
        }
    }

    static final class TPOptionDisableCaching extends Enum
    {

        private static final TPOptionDisableCaching $VALUES[];
        public static final TPOptionDisableCaching TPOptionDisableCaching_library;
        public static final TPOptionDisableCaching TPOptionDisableCaching_none;
        public static final TPOptionDisableCaching TPOptionDisableCaching_system;

        public static TPOptionDisableCaching valueOf(String s)
        {
            return (TPOptionDisableCaching)Enum.valueOf(com/twinprime/TwinPrimeSDK/TPOptionManager$TPOptionDisableCaching, s);
        }

        public static TPOptionDisableCaching[] values()
        {
            return (TPOptionDisableCaching[])$VALUES.clone();
        }

        static 
        {
            TPOptionDisableCaching_none = new TPOptionDisableCaching("TPOptionDisableCaching_none", 0);
            TPOptionDisableCaching_library = new TPOptionDisableCaching("TPOptionDisableCaching_library", 1);
            TPOptionDisableCaching_system = new TPOptionDisableCaching("TPOptionDisableCaching_system", 2);
            $VALUES = (new TPOptionDisableCaching[] {
                TPOptionDisableCaching_none, TPOptionDisableCaching_library, TPOptionDisableCaching_system
            });
        }

        private TPOptionDisableCaching(String s, int i)
        {
            super(s, i);
        }
    }

    static final class TPOptionFollowRedirect extends Enum
    {

        private static final TPOptionFollowRedirect $VALUES[];
        public static final TPOptionFollowRedirect TPOptionFollowRedirect_disable;
        public static final TPOptionFollowRedirect TPOptionFollowRedirect_enable;

        public static TPOptionFollowRedirect valueOf(String s)
        {
            return (TPOptionFollowRedirect)Enum.valueOf(com/twinprime/TwinPrimeSDK/TPOptionManager$TPOptionFollowRedirect, s);
        }

        public static TPOptionFollowRedirect[] values()
        {
            return (TPOptionFollowRedirect[])$VALUES.clone();
        }

        static 
        {
            TPOptionFollowRedirect_disable = new TPOptionFollowRedirect("TPOptionFollowRedirect_disable", 0);
            TPOptionFollowRedirect_enable = new TPOptionFollowRedirect("TPOptionFollowRedirect_enable", 1);
            $VALUES = (new TPOptionFollowRedirect[] {
                TPOptionFollowRedirect_disable, TPOptionFollowRedirect_enable
            });
        }

        private TPOptionFollowRedirect(String s, int i)
        {
            super(s, i);
        }
    }

    static final class TPOptionHTTPAcceleration extends Enum
    {

        private static final TPOptionHTTPAcceleration $VALUES[];
        public static final TPOptionHTTPAcceleration TPOptionHTTPAcceleration_disable;
        public static final TPOptionHTTPAcceleration TPOptionHTTPAcceleration_enable;

        public static TPOptionHTTPAcceleration valueOf(String s)
        {
            return (TPOptionHTTPAcceleration)Enum.valueOf(com/twinprime/TwinPrimeSDK/TPOptionManager$TPOptionHTTPAcceleration, s);
        }

        public static TPOptionHTTPAcceleration[] values()
        {
            return (TPOptionHTTPAcceleration[])$VALUES.clone();
        }

        static 
        {
            TPOptionHTTPAcceleration_disable = new TPOptionHTTPAcceleration("TPOptionHTTPAcceleration_disable", 0);
            TPOptionHTTPAcceleration_enable = new TPOptionHTTPAcceleration("TPOptionHTTPAcceleration_enable", 1);
            $VALUES = (new TPOptionHTTPAcceleration[] {
                TPOptionHTTPAcceleration_disable, TPOptionHTTPAcceleration_enable
            });
        }

        private TPOptionHTTPAcceleration(String s, int i)
        {
            super(s, i);
        }
    }

    static final class TPOptionHTTPCertificateVerification extends Enum
    {

        private static final TPOptionHTTPCertificateVerification $VALUES[];
        public static final TPOptionHTTPCertificateVerification TPOptionHTTPCertificateVerification_disable;
        public static final TPOptionHTTPCertificateVerification TPOptionHTTPCertificateVerification_enable;

        public static TPOptionHTTPCertificateVerification valueOf(String s)
        {
            return (TPOptionHTTPCertificateVerification)Enum.valueOf(com/twinprime/TwinPrimeSDK/TPOptionManager$TPOptionHTTPCertificateVerification, s);
        }

        public static TPOptionHTTPCertificateVerification[] values()
        {
            return (TPOptionHTTPCertificateVerification[])$VALUES.clone();
        }

        static 
        {
            TPOptionHTTPCertificateVerification_enable = new TPOptionHTTPCertificateVerification("TPOptionHTTPCertificateVerification_enable", 0);
            TPOptionHTTPCertificateVerification_disable = new TPOptionHTTPCertificateVerification("TPOptionHTTPCertificateVerification_disable", 1);
            $VALUES = (new TPOptionHTTPCertificateVerification[] {
                TPOptionHTTPCertificateVerification_enable, TPOptionHTTPCertificateVerification_disable
            });
        }

        private TPOptionHTTPCertificateVerification(String s, int i)
        {
            super(s, i);
        }
    }

    static final class TPOptionHTTPSAcceleration extends Enum
    {

        private static final TPOptionHTTPSAcceleration $VALUES[];
        public static final TPOptionHTTPSAcceleration TPOptionHTTPSAcceleration_disable;
        public static final TPOptionHTTPSAcceleration TPOptionHTTPSAcceleration_enable;

        public static TPOptionHTTPSAcceleration valueOf(String s)
        {
            return (TPOptionHTTPSAcceleration)Enum.valueOf(com/twinprime/TwinPrimeSDK/TPOptionManager$TPOptionHTTPSAcceleration, s);
        }

        public static TPOptionHTTPSAcceleration[] values()
        {
            return (TPOptionHTTPSAcceleration[])$VALUES.clone();
        }

        static 
        {
            TPOptionHTTPSAcceleration_disable = new TPOptionHTTPSAcceleration("TPOptionHTTPSAcceleration_disable", 0);
            TPOptionHTTPSAcceleration_enable = new TPOptionHTTPSAcceleration("TPOptionHTTPSAcceleration_enable", 1);
            $VALUES = (new TPOptionHTTPSAcceleration[] {
                TPOptionHTTPSAcceleration_disable, TPOptionHTTPSAcceleration_enable
            });
        }

        private TPOptionHTTPSAcceleration(String s, int i)
        {
            super(s, i);
        }
    }

    static final class TPOptionHTTPSProxy extends Enum
    {

        private static final TPOptionHTTPSProxy $VALUES[];
        public static final TPOptionHTTPSProxy TPOptionHTTPSProxy_local;
        public static final TPOptionHTTPSProxy TPOptionHTTPSProxy_remote;

        public static TPOptionHTTPSProxy valueOf(String s)
        {
            return (TPOptionHTTPSProxy)Enum.valueOf(com/twinprime/TwinPrimeSDK/TPOptionManager$TPOptionHTTPSProxy, s);
        }

        public static TPOptionHTTPSProxy[] values()
        {
            return (TPOptionHTTPSProxy[])$VALUES.clone();
        }

        static 
        {
            TPOptionHTTPSProxy_remote = new TPOptionHTTPSProxy("TPOptionHTTPSProxy_remote", 0);
            TPOptionHTTPSProxy_local = new TPOptionHTTPSProxy("TPOptionHTTPSProxy_local", 1);
            $VALUES = (new TPOptionHTTPSProxy[] {
                TPOptionHTTPSProxy_remote, TPOptionHTTPSProxy_local
            });
        }

        private TPOptionHTTPSProxy(String s, int i)
        {
            super(s, i);
        }
    }

    static final class TPOptionLimitedHTTPIntercept extends Enum
    {

        private static final TPOptionLimitedHTTPIntercept $VALUES[];
        public static final TPOptionLimitedHTTPIntercept TPOptionLimitedHTTPIntercept_disable;
        public static final TPOptionLimitedHTTPIntercept TPOptionLimitedHTTPIntercept_enable;

        public static TPOptionLimitedHTTPIntercept valueOf(String s)
        {
            return (TPOptionLimitedHTTPIntercept)Enum.valueOf(com/twinprime/TwinPrimeSDK/TPOptionManager$TPOptionLimitedHTTPIntercept, s);
        }

        public static TPOptionLimitedHTTPIntercept[] values()
        {
            return (TPOptionLimitedHTTPIntercept[])$VALUES.clone();
        }

        static 
        {
            TPOptionLimitedHTTPIntercept_enable = new TPOptionLimitedHTTPIntercept("TPOptionLimitedHTTPIntercept_enable", 0);
            TPOptionLimitedHTTPIntercept_disable = new TPOptionLimitedHTTPIntercept("TPOptionLimitedHTTPIntercept_disable", 1);
            $VALUES = (new TPOptionLimitedHTTPIntercept[] {
                TPOptionLimitedHTTPIntercept_enable, TPOptionLimitedHTTPIntercept_disable
            });
        }

        private TPOptionLimitedHTTPIntercept(String s, int i)
        {
            super(s, i);
        }
    }

    static final class TPOptionLogFullURL extends Enum
    {

        private static final TPOptionLogFullURL $VALUES[];
        public static final TPOptionLogFullURL TPOptionLogFullURL_disable;
        public static final TPOptionLogFullURL TPOptionLogFullURL_enable;

        public static TPOptionLogFullURL valueOf(String s)
        {
            return (TPOptionLogFullURL)Enum.valueOf(com/twinprime/TwinPrimeSDK/TPOptionManager$TPOptionLogFullURL, s);
        }

        public static TPOptionLogFullURL[] values()
        {
            return (TPOptionLogFullURL[])$VALUES.clone();
        }

        static 
        {
            TPOptionLogFullURL_disable = new TPOptionLogFullURL("TPOptionLogFullURL_disable", 0);
            TPOptionLogFullURL_enable = new TPOptionLogFullURL("TPOptionLogFullURL_enable", 1);
            $VALUES = (new TPOptionLogFullURL[] {
                TPOptionLogFullURL_disable, TPOptionLogFullURL_enable
            });
        }

        private TPOptionLogFullURL(String s, int i)
        {
            super(s, i);
        }
    }

    static final class TPOptionPerformanceLog extends Enum
    {

        private static final TPOptionPerformanceLog $VALUES[];
        public static final TPOptionPerformanceLog TPOptionPerformanceLog_disable;
        public static final TPOptionPerformanceLog TPOptionPerformanceLog_enable;

        public static TPOptionPerformanceLog valueOf(String s)
        {
            return (TPOptionPerformanceLog)Enum.valueOf(com/twinprime/TwinPrimeSDK/TPOptionManager$TPOptionPerformanceLog, s);
        }

        public static TPOptionPerformanceLog[] values()
        {
            return (TPOptionPerformanceLog[])$VALUES.clone();
        }

        static 
        {
            TPOptionPerformanceLog_enable = new TPOptionPerformanceLog("TPOptionPerformanceLog_enable", 0);
            TPOptionPerformanceLog_disable = new TPOptionPerformanceLog("TPOptionPerformanceLog_disable", 1);
            $VALUES = (new TPOptionPerformanceLog[] {
                TPOptionPerformanceLog_enable, TPOptionPerformanceLog_disable
            });
        }

        private TPOptionPerformanceLog(String s, int i)
        {
            super(s, i);
        }
    }

    static final class TPOptionSendSessionID extends Enum
    {

        private static final TPOptionSendSessionID $VALUES[];
        public static final TPOptionSendSessionID TPOptionSendSessionID_disable;
        public static final TPOptionSendSessionID TPOptionSendSessionID_enable;

        public static TPOptionSendSessionID valueOf(String s)
        {
            return (TPOptionSendSessionID)Enum.valueOf(com/twinprime/TwinPrimeSDK/TPOptionManager$TPOptionSendSessionID, s);
        }

        public static TPOptionSendSessionID[] values()
        {
            return (TPOptionSendSessionID[])$VALUES.clone();
        }

        static 
        {
            TPOptionSendSessionID_enable = new TPOptionSendSessionID("TPOptionSendSessionID_enable", 0);
            TPOptionSendSessionID_disable = new TPOptionSendSessionID("TPOptionSendSessionID_disable", 1);
            $VALUES = (new TPOptionSendSessionID[] {
                TPOptionSendSessionID_enable, TPOptionSendSessionID_disable
            });
        }

        private TPOptionSendSessionID(String s, int i)
        {
            super(s, i);
        }
    }


    private static TPOptionManager optManager;
    int accHttpPort;
    String accName;
    TPOptionCache cache;
    String cacheName;
    TPOptionDisableCaching cachingPolicy;
    TPOptionHTTPCertificateVerification certVerificationPolicy;
    TPOptionFollowRedirect followRedirect;
    TPOptionHTTPAcceleration httpAcceleration;
    TPOptionHTTPSAcceleration httpsAcceleration;
    TPOptionHTTPSProxy httpsProxy;
    TPOptionLimitedHTTPIntercept limitedHttpIntercept;
    TPOptionLogFullURL log_full_url;
    HashMap options;
    TPOptionPerformanceLog performanceLog;
    TPOptionSendSessionID sendSession;
    List urlBlackList;
    List urlWhiteList;

    TPOptionManager()
    {
        options = new HashMap();
        urlBlackList = null;
        urlWhiteList = null;
    }

    static String defaultCacheName()
    {
        return (new StringBuilder()).append("tp-cache-").append(android.os.Build.VERSION.SDK_INT).toString();
    }

    static int getAcceleratorHttpPort()
    {
        return getInstance().accHttpPort;
    }

    static String getAcceleratorNameOption()
    {
        return getInstance().accName;
    }

    static TPOptionCache getCache()
    {
        return getInstance().cache;
    }

    static String getCacheNameOption()
    {
        return getInstance().cacheName;
    }

    static TPOptionDisableCaching getCachingOption()
    {
        return getInstance().cachingPolicy;
    }

    static TPOptionHTTPCertificateVerification getCertVerificationOption()
    {
        return getInstance().certVerificationPolicy;
    }

    static TPOptionHTTPAcceleration getHTTPAcceleration()
    {
        return getInstance().httpAcceleration;
    }

    static TPOptionHTTPSAcceleration getHTTPSAcceleration()
    {
        return getInstance().httpsAcceleration;
    }

    static TPOptionHTTPSProxy getHTTPSProxy()
    {
        return getInstance().httpsProxy;
    }

    public static TPOptionManager getInstance()
    {
        com/twinprime/TwinPrimeSDK/TPOptionManager;
        JVM INSTR monitorenter ;
        TPOptionManager tpoptionmanager;
        if (optManager == null)
        {
            optManager = new TPOptionManager();
            optManager.init();
        }
        tpoptionmanager = optManager;
        com/twinprime/TwinPrimeSDK/TPOptionManager;
        JVM INSTR monitorexit ;
        return tpoptionmanager;
        Exception exception;
        exception;
        throw exception;
    }

    static TPOptionLimitedHTTPIntercept getLimitedHTTPIntercept()
    {
        return getInstance().limitedHttpIntercept;
    }

    static TPOptionLogFullURL getLogFullURLOption()
    {
        return getInstance().log_full_url;
    }

    static TPOptionPerformanceLog getPerformanceLogOption()
    {
        return getInstance().performanceLog;
    }

    static TPOptionSendSessionID getSendSessionID()
    {
        return getInstance().sendSession;
    }

    static void setOption(Map map)
    {
        if (map != null)
        {
            getInstance().setOptionInternal(map);
        }
    }

    void init()
    {
        cachingPolicy = TPOptionDisableCaching.TPOptionDisableCaching_none;
        sendSession = TPOptionSendSessionID.TPOptionSendSessionID_enable;
        httpAcceleration = TPOptionHTTPAcceleration.TPOptionHTTPAcceleration_enable;
        httpsAcceleration = TPOptionHTTPSAcceleration.TPOptionHTTPSAcceleration_disable;
        accName = null;
        accHttpPort = 0;
        followRedirect = TPOptionFollowRedirect.TPOptionFollowRedirect_enable;
        httpsProxy = TPOptionHTTPSProxy.TPOptionHTTPSProxy_local;
        cache = TPOptionCache.TPOptionCache_enable;
        log_full_url = TPOptionLogFullURL.TPOptionLogFullURL_disable;
        cacheName = defaultCacheName();
    }

    void setOptionInternal(Map map)
    {
        Iterator iterator = map.entrySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj1 = (java.util.Map.Entry)iterator.next();
            Object obj = (String)((java.util.Map.Entry) (obj1)).getKey();
            obj1 = ((java.util.Map.Entry) (obj1)).getValue();
            if (TPLog.LOG13.isLoggable("TPOptionManager"))
            {
                Log.d("TPOptionManager", (new StringBuilder()).append("\t").append(((String) (obj))).append(" - ").append(map.get(obj)).toString());
            }
            if (((String) (obj)).equalsIgnoreCase("com.twinprime.options.urls.exclude"))
            {
                if (obj1 instanceof List)
                {
                    obj = (List)obj1;
                    urlBlackList = new ArrayList(((List) (obj)).size());
                    obj = ((List) (obj)).iterator();
                    while (((Iterator) (obj)).hasNext()) 
                    {
                        obj1 = ((Iterator) (obj)).next();
                        urlBlackList.add((String)obj1);
                    }
                } else
                if (obj1 == null)
                {
                    urlBlackList = null;
                }
            } else
            if (((String) (obj)).equalsIgnoreCase("com.twinprime.options.urls.include"))
            {
                if (obj1 instanceof List)
                {
                    obj = (List)obj1;
                    urlWhiteList = new ArrayList(((List) (obj)).size());
                    obj = ((List) (obj)).iterator();
                    while (((Iterator) (obj)).hasNext()) 
                    {
                        obj1 = ((Iterator) (obj)).next();
                        urlWhiteList.add((String)obj1);
                    }
                } else
                if (obj1 == null)
                {
                    urlWhiteList = null;
                }
            } else
            if (((String) (obj)).equalsIgnoreCase("com.twinprime.options.disableCache"))
            {
                if (obj1 instanceof String)
                {
                    obj1 = (String)obj1;
                    if (((String) (obj1)).equalsIgnoreCase("library"))
                    {
                        cachingPolicy = TPOptionDisableCaching.TPOptionDisableCaching_library;
                    } else
                    if (((String) (obj1)).equalsIgnoreCase("system"))
                    {
                        cachingPolicy = TPOptionDisableCaching.TPOptionDisableCaching_system;
                    } else
                    {
                        Log.e("TPOptionManager", (new StringBuilder()).append("Invalid Option Value for key ").append(((String) (obj))).append(" setting default option").toString());
                    }
                } else
                {
                    Log.e("TPOptionManager", (new StringBuilder()).append("Invalid Option Value for key ").append(((String) (obj))).append(" expected String.").toString());
                }
            } else
            if (((String) (obj)).equalsIgnoreCase("com.twinprime.options.performanceLog"))
            {
                if (obj1 instanceof String)
                {
                    obj1 = (String)obj1;
                    if (((String) (obj1)).equalsIgnoreCase("enable"))
                    {
                        performanceLog = TPOptionPerformanceLog.TPOptionPerformanceLog_enable;
                    } else
                    if (((String) (obj1)).equalsIgnoreCase("disable"))
                    {
                        performanceLog = TPOptionPerformanceLog.TPOptionPerformanceLog_disable;
                    } else
                    {
                        obj1 = (new StringBuilder()).append("Invalid Option Value for key ").append(((String) (obj))).append(". ");
                        if (performanceLog == TPOptionPerformanceLog.TPOptionPerformanceLog_enable)
                        {
                            obj = "En";
                        } else
                        {
                            obj = "Dis";
                        }
                        Log.e("TPOptionManager", ((StringBuilder) (obj1)).append(((String) (obj))).append("abling Performance Log").toString());
                    }
                } else
                {
                    Log.e("TPOptionManager", (new StringBuilder()).append("Invalid Option Value for key ").append(((String) (obj))).append(" expected String").toString());
                }
            } else
            if (((String) (obj)).equalsIgnoreCase("com.twinprime.options.ABTesting"))
            {
                TPLog.LOG3.i("TPOptionManager", (new StringBuilder()).append(((String) (obj))).append(" option is deprecated").toString());
            } else
            if (((String) (obj)).equalsIgnoreCase("com.twinprime.options.sendSessionID"))
            {
                if (obj1 instanceof String)
                {
                    obj1 = (String)obj1;
                    if (((String) (obj1)).equalsIgnoreCase("disable"))
                    {
                        sendSession = TPOptionSendSessionID.TPOptionSendSessionID_disable;
                    } else
                    if (((String) (obj1)).equalsIgnoreCase("enable"))
                    {
                        sendSession = TPOptionSendSessionID.TPOptionSendSessionID_enable;
                    } else
                    {
                        obj1 = (new StringBuilder()).append("Invalid Option Value for key ").append(((String) (obj))).append(". ");
                        if (sendSession == TPOptionSendSessionID.TPOptionSendSessionID_enable)
                        {
                            obj = "En";
                        } else
                        {
                            obj = "Dis";
                        }
                        Log.e("TPOptionManager", ((StringBuilder) (obj1)).append(((String) (obj))).append("abling Send Session ID").toString());
                    }
                } else
                {
                    Log.e("TPOptionManager", (new StringBuilder()).append("Invalid Option Value for key ").append(((String) (obj))).append(" expected String.").toString());
                }
            } else
            if (((String) (obj)).equalsIgnoreCase("com.twinprime.options.HTTPAcceleration"))
            {
                if (obj1 instanceof String)
                {
                    obj1 = (String)obj1;
                    if (((String) (obj1)).equalsIgnoreCase("disable"))
                    {
                        httpAcceleration = TPOptionHTTPAcceleration.TPOptionHTTPAcceleration_disable;
                    } else
                    if (((String) (obj1)).equalsIgnoreCase("enable"))
                    {
                        httpAcceleration = TPOptionHTTPAcceleration.TPOptionHTTPAcceleration_enable;
                    } else
                    {
                        obj1 = (new StringBuilder()).append("Invalid Option Value for key ").append(((String) (obj))).append(". ");
                        if (httpAcceleration == TPOptionHTTPAcceleration.TPOptionHTTPAcceleration_enable)
                        {
                            obj = "En";
                        } else
                        {
                            obj = "Dis";
                        }
                        Log.e("TPOptionManager", ((StringBuilder) (obj1)).append(((String) (obj))).append("abling HTTP Acceleration").toString());
                    }
                } else
                {
                    Log.e("TPOptionManager", (new StringBuilder()).append("Invalid Option Value for key ").append(((String) (obj))).append(" expected String.").toString());
                }
            } else
            if (((String) (obj)).equalsIgnoreCase("com.twinprime.options.HTTPSAcceleration"))
            {
                if (obj1 instanceof String)
                {
                    obj1 = (String)obj1;
                    if (((String) (obj1)).equalsIgnoreCase("disable"))
                    {
                        httpsAcceleration = TPOptionHTTPSAcceleration.TPOptionHTTPSAcceleration_disable;
                    } else
                    if (((String) (obj1)).equalsIgnoreCase("enable"))
                    {
                        httpsAcceleration = TPOptionHTTPSAcceleration.TPOptionHTTPSAcceleration_enable;
                    } else
                    {
                        obj1 = (new StringBuilder()).append("Invalid Option Value for key ").append(((String) (obj))).append(". ");
                        if (httpsAcceleration == TPOptionHTTPSAcceleration.TPOptionHTTPSAcceleration_enable)
                        {
                            obj = "En";
                        } else
                        {
                            obj = "Dis";
                        }
                        Log.e("TPOptionManager", ((StringBuilder) (obj1)).append(((String) (obj))).append("abling HTTPS Acceleration").toString());
                    }
                } else
                {
                    Log.e("TPOptionManager", (new StringBuilder()).append("Invalid Option Value for key ").append(((String) (obj))).append(" expected String.").toString());
                }
            } else
            if (((String) (obj)).equalsIgnoreCase("com.twinprime.options.AcceleratorName"))
            {
                if (obj1 instanceof String)
                {
                    accName = (String)obj1;
                } else
                {
                    Log.e("TPOptionManager", (new StringBuilder()).append("Invalid Option Value for key ").append(((String) (obj))).append(" expected String.").toString());
                }
            } else
            if (((String) (obj)).equalsIgnoreCase("com.twinprime.options.cacheName"))
            {
                if (obj1 instanceof String)
                {
                    cacheName = (String)obj1;
                } else
                {
                    Log.e("TPOptionManager", (new StringBuilder()).append("Invalid Option Value for key ").append(((String) (obj))).append(" expected String.").toString());
                }
            } else
            if (((String) (obj)).equalsIgnoreCase("com.twinprime.options.AcceleratorHttpPort"))
            {
                if (obj1 instanceof Integer)
                {
                    accHttpPort = ((Integer)obj1).intValue();
                } else
                {
                    Log.e("TPOptionManager", (new StringBuilder()).append("Invalid Option Value for key ").append(((String) (obj))).append(" expected Integer").toString());
                }
            } else
            if (((String) (obj)).equalsIgnoreCase("com.twinprime.options.FollowRedirect"))
            {
                if (obj1 instanceof String)
                {
                    obj1 = (String)obj1;
                    if (((String) (obj1)).equalsIgnoreCase("disable"))
                    {
                        followRedirect = TPOptionFollowRedirect.TPOptionFollowRedirect_disable;
                    } else
                    if (((String) (obj1)).equalsIgnoreCase("enable"))
                    {
                        followRedirect = TPOptionFollowRedirect.TPOptionFollowRedirect_enable;
                    } else
                    {
                        obj1 = (new StringBuilder()).append("Invalid Option Value for key ").append(((String) (obj))).append(". ");
                        if (followRedirect == TPOptionFollowRedirect.TPOptionFollowRedirect_enable)
                        {
                            obj = "En";
                        } else
                        {
                            obj = "Dis";
                        }
                        Log.e("TPOptionManager", ((StringBuilder) (obj1)).append(((String) (obj))).append("abling Follow Redirect").toString());
                    }
                } else
                {
                    Log.e("TPOptionManager", (new StringBuilder()).append("Invalid Option Value for key ").append(((String) (obj))).append(" expected String.").toString());
                }
            } else
            if (((String) (obj)).equalsIgnoreCase("com.twinprime.options.HTTPSProxy"))
            {
                if (obj1 instanceof String)
                {
                    obj1 = (String)obj1;
                    if (((String) (obj1)).equalsIgnoreCase("local"))
                    {
                        httpsProxy = TPOptionHTTPSProxy.TPOptionHTTPSProxy_local;
                    } else
                    if (((String) (obj1)).equalsIgnoreCase("remote"))
                    {
                        httpsProxy = TPOptionHTTPSProxy.TPOptionHTTPSProxy_remote;
                    } else
                    {
                        obj1 = (new StringBuilder()).append("Invalid Option Value for key ").append(((String) (obj))).append(" using ");
                        if (httpsProxy == TPOptionHTTPSProxy.TPOptionHTTPSProxy_local)
                        {
                            obj = "local";
                        } else
                        {
                            obj = "remote";
                        }
                        Log.e("TPOptionManager", ((StringBuilder) (obj1)).append(((String) (obj))).append(" HTTPS Proxy").toString());
                    }
                } else
                {
                    Log.e("TPOptionManager", (new StringBuilder()).append("Invalid Option Value for key ").append(((String) (obj))).append(" expected String.").toString());
                }
            } else
            if (((String) (obj)).equalsIgnoreCase("com.twinprime.options.Cache"))
            {
                if (obj1 instanceof String)
                {
                    obj1 = (String)obj1;
                    if (((String) (obj1)).equalsIgnoreCase("disable"))
                    {
                        cache = TPOptionCache.TPOptionCache_disable;
                    } else
                    if (((String) (obj1)).equalsIgnoreCase("enable"))
                    {
                        cache = TPOptionCache.TPOptionCache_enable;
                    } else
                    {
                        obj1 = (new StringBuilder()).append("Invalid Option Value for key ").append(((String) (obj))).append(". ");
                        if (cache == TPOptionCache.TPOptionCache_enable)
                        {
                            obj = "En";
                        } else
                        {
                            obj = "Dis";
                        }
                        Log.e("TPOptionManager", ((StringBuilder) (obj1)).append(((String) (obj))).append("abling Follow Redirect").toString());
                    }
                } else
                {
                    Log.e("TPOptionManager", (new StringBuilder()).append("Invalid Option Value for key ").append(((String) (obj))).append(" expected String.").toString());
                }
            } else
            if (((String) (obj)).equalsIgnoreCase("com.twinprime.options.LogFullURL"))
            {
                if (obj1 instanceof String)
                {
                    obj1 = (String)obj1;
                    if (((String) (obj1)).equalsIgnoreCase("enable"))
                    {
                        log_full_url = TPOptionLogFullURL.TPOptionLogFullURL_enable;
                    } else
                    if (((String) (obj1)).equalsIgnoreCase("disable"))
                    {
                        log_full_url = TPOptionLogFullURL.TPOptionLogFullURL_disable;
                    } else
                    {
                        StringBuilder stringbuilder = (new StringBuilder()).append("Invalid Option Value for key ").append(((String) (obj))).append(". ");
                        if (log_full_url == TPOptionLogFullURL.TPOptionLogFullURL_enable)
                        {
                            obj = "En";
                        } else
                        {
                            obj = "Dis";
                        }
                        Log.e("TPOptionManager", stringbuilder.append(((String) (obj))).append("abling log full URL").toString());
                    }
                } else
                {
                    Log.e("TPOptionManager", (new StringBuilder()).append("Invalid Option Value for key ").append(((String) (obj))).append(" expected String.").toString());
                }
            } else
            {
                Log.e("TPOptionManager", (new StringBuilder()).append("Invalid Option key ").append(((String) (obj))).append(" passed into SDK options").toString());
            }
        } while (true);
    }
}
