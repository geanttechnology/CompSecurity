// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adobe.adms.measurement;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

// Referenced classes of package com.adobe.adms.measurement:
//            ADMS_ContextData, ADMS_DefaultValues

abstract class ADMS_MeasurementBase
{

    private static final String encodedChars[] = {
        "%00", "%01", "%02", "%03", "%04", "%05", "%06", "%07", "%08", "%09", 
        "%0A", "%0B", "%0C", "%0D", "%0E", "%0F", "%10", "%11", "%12", "%13", 
        "%14", "%15", "%16", "%17", "%18", "%19", "%1A", "%1B", "%1C", "%1D", 
        "%1E", "%1F", "%20", "%21", "%22", "%23", "%24", "%25", "%26", "%27", 
        "%28", "%29", "*", "%2B", "%2C", "-", ".", "%2F", "0", "1", 
        "2", "3", "4", "5", "6", "7", "8", "9", "%3A", "%3B", 
        "%3C", "%3D", "%3E", "%3F", "%40", "A", "B", "C", "D", "E", 
        "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", 
        "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", 
        "Z", "%5B", "%5C", "%5D", "%5E", "_", "%60", "a", "b", "c", 
        "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", 
        "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", 
        "x", "y", "z", "%7B", "%7C", "%7D", "%7E", "%7F", "%80", "%81", 
        "%82", "%83", "%84", "%85", "%86", "%87", "%88", "%89", "%8A", "%8B", 
        "%8C", "%8D", "%8E", "%8F", "%90", "%91", "%92", "%93", "%94", "%95", 
        "%96", "%97", "%98", "%99", "%9A", "%9B", "%9C", "%9D", "%9E", "%9F", 
        "%A0", "%A1", "%A2", "%A3", "%A4", "%A5", "%A6", "%A7", "%A8", "%A9", 
        "%AA", "%AB", "%AC", "%AD", "%AE", "%AF", "%B0", "%B1", "%B2", "%B3", 
        "%B4", "%B5", "%B6", "%B7", "%B8", "%B9", "%BA", "%BB", "%BC", "%BD", 
        "%BE", "%BF", "%C0", "%C1", "%C2", "%C3", "%C4", "%C5", "%C6", "%C7", 
        "%C8", "%C9", "%CA", "%CB", "%CC", "%CD", "%CE", "%CF", "%D0", "%D1", 
        "%D2", "%D3", "%D4", "%D5", "%D6", "%D7", "%D8", "%D9", "%DA", "%DB", 
        "%DC", "%DD", "%DE", "%DF", "%E0", "%E1", "%E2", "%E3", "%E4", "%E5", 
        "%E6", "%E7", "%E8", "%E9", "%EA", "%EB", "%EC", "%ED", "%EE", "%EF", 
        "%F0", "%F1", "%F2", "%F3", "%F4", "%F5", "%F6", "%F7", "%F8", "%F9", 
        "%FA", "%FB", "%FC", "%FD", "%FE", "%FF"
    };
    private static final HashMap keyReplacements = new HashMap() {

            
            {
                put("contextdata", "c");
                put("lightprofileid", "mtp");
                put("lightstoreforseconds", "mtss");
                put("lightincrementby", "mti");
                put("retrievelightprofiles", "mtsr");
                put("deletelightprofiles", "mtsd");
                put("visitorid", "vid");
                put("charset", "ce");
                put("currencycode", "cc");
                put("dynamicvariableprefix", "D");
                put("channel", "ch");
                put("pageurl", "g");
                put("visitornamespace", "ns");
                put("referrer", "r");
                put("campaign", "v0");
                put("transactionid", "xact");
                put("appstate", "pageName");
                put("pagename", "pageName");
                put("appsection", "server");
                put("geozip", "zip");
                put("geostate", "state");
                put("linkurl", "pev1");
                put("linkname", "pev2");
                put("linktype", "pe");
                put("purchaseid", "purchaseID");
                put("events", "events");
                put("products", "products");
            }
    };
    private static final HashMap prefixReplacements = new HashMap() {

            
            {
                put("evar", "v");
                put("prop", "c");
                put("list", "l");
                put("hier", "h");
                put("pev", "pev");
            }
    };
    private static final HashSet validKeys = new HashSet() {

            
            {
                add("vid");
                add("ce");
                add("ns");
                add("pageName");
                add("g");
                add("r");
                add("cc");
                add("pe");
                add("ts");
                add("t");
                add("purchaseID");
                add("ch");
                add("server");
                add("pageType");
                add("xact");
                add("v0");
                add("state");
                add("zip");
                add("events");
                add("products");
                add("mtsr");
                for (int i = 1; i <= 75; i++)
                {
                    add((new StringBuilder()).append("c").append(i).toString());
                }

                for (int j = 1; j <= 75; j++)
                {
                    add((new StringBuilder()).append("v").append(j).toString());
                }

                for (int k = 1; k <= 5; k++)
                {
                    add((new StringBuilder()).append("h").append(k).toString());
                }

                for (int l = 1; l <= 3; l++)
                {
                    add((new StringBuilder()).append("l").append(l).toString());
                }

                for (int i1 = 1; i1 <= 3; i1++)
                {
                    add((new StringBuilder()).append("pev").append(i1).toString());
                }

                add("c");
                add("mtsd");
            }
    };
    private static final HashSet validLightParameters = new HashSet() {

            
            {
                add("ce");
                add("ns");
                add("cookieDomainPeriods");
                add("cookieLifetime");
                add("mtp");
                add("mtss");
                add("mti");
                add("mtsd");
                add("ts");
                for (int i = 1; i <= 75; i++)
                {
                    add((new StringBuilder()).append("c").append(i).toString());
                }

                for (int j = 1; j <= 75; j++)
                {
                    add((new StringBuilder()).append("v").append(j).toString());
                }

            }
    };
    private String appSection;
    private String appState;
    private String campaign;
    private String channel;
    private String charSet;
    private String currencyCode;
    protected String customVisitorID;
    protected String dataCenter;
    protected boolean debugLogging;
    protected Hashtable evarMap;
    private String events;
    private String geoState;
    private String geoZip;
    protected Hashtable hierMap;
    protected boolean isOffline;
    private int lightIncrementBy;
    private String lightProfileID;
    private int lightStoreForSeconds;
    private String lightTrackVars;
    private String linkName;
    private String linkTrackEvents;
    private String linkTrackVars;
    private String linkType;
    private String linkURL;
    protected Hashtable listMap;
    protected int offlineHitLimit;
    protected boolean offlineTrackingEnabled;
    protected Hashtable persistentContextData;
    protected Hashtable pevMap;
    private String products;
    protected Hashtable propMap;
    private String purchaseID;
    private String reportSuiteIDs;
    private SecureRandom secRandom;
    protected boolean ssl;
    protected long timestamp;
    private String trackingServer;
    private String transactionID;
    protected String userAgent;
    protected String version;
    protected String visitorID;

    protected ADMS_MeasurementBase()
    {
        reportSuiteIDs = null;
        trackingServer = null;
        visitorID = null;
        customVisitorID = null;
        charSet = null;
        currencyCode = null;
        ssl = false;
        debugLogging = false;
        offlineTrackingEnabled = true;
        offlineHitLimit = 1000;
        purchaseID = null;
        transactionID = null;
        appState = null;
        channel = null;
        appSection = null;
        campaign = null;
        products = null;
        events = null;
        persistentContextData = null;
        geoZip = null;
        geoState = null;
        lightTrackVars = null;
        linkTrackVars = null;
        linkTrackEvents = null;
        linkURL = null;
        linkName = null;
        linkType = null;
        lightProfileID = null;
        lightStoreForSeconds = 0;
        lightIncrementBy = 0;
        userAgent = null;
        dataCenter = null;
        timestamp = 0L;
        isOffline = false;
        secRandom = null;
        setupDefaults();
    }

    protected ADMS_MeasurementBase(String s, String s1)
    {
        reportSuiteIDs = null;
        trackingServer = null;
        visitorID = null;
        customVisitorID = null;
        charSet = null;
        currencyCode = null;
        ssl = false;
        debugLogging = false;
        offlineTrackingEnabled = true;
        offlineHitLimit = 1000;
        purchaseID = null;
        transactionID = null;
        appState = null;
        channel = null;
        appSection = null;
        campaign = null;
        products = null;
        events = null;
        persistentContextData = null;
        geoZip = null;
        geoState = null;
        lightTrackVars = null;
        linkTrackVars = null;
        linkTrackEvents = null;
        linkURL = null;
        linkName = null;
        linkType = null;
        lightProfileID = null;
        lightStoreForSeconds = 0;
        lightIncrementBy = 0;
        userAgent = null;
        dataCenter = null;
        timestamp = 0L;
        isOffline = false;
        secRandom = null;
        setupDefaults();
    }

    private final void addValueToHashtable(Object obj, ADMS_ContextData adms_contextdata, List list, int i)
    {
        int j = list.size();
        String s;
        if (i < j)
        {
            s = (String)list.get(i);
        } else
        {
            s = null;
        }
        if (s == null)
        {
            return;
        }
        ADMS_ContextData adms_contextdata1 = new ADMS_ContextData();
        if (adms_contextdata.containsKey(s))
        {
            adms_contextdata1 = adms_contextdata.get(s);
        }
        if (j - 1 == i)
        {
            adms_contextdata1.value = obj;
            adms_contextdata.put(s, adms_contextdata1);
            return;
        } else
        {
            adms_contextdata.put(s, adms_contextdata1);
            addValueToHashtable(obj, adms_contextdata1, list, i + 1);
            return;
        }
    }

    private final boolean isInteger(Object obj)
    {
        boolean flag = false;
        try
        {
            obj = (Integer)obj;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return false;
        }
        if (obj != null)
        {
            flag = true;
        }
        return flag;
    }

    private final boolean isString(Object obj)
    {
        boolean flag = false;
        try
        {
            obj = (String)obj;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return false;
        }
        if (obj != null)
        {
            flag = true;
        }
        return flag;
    }

    protected static final String join(Iterable iterable, String s)
    {
        StringBuilder stringbuilder = new StringBuilder();
        iterable = iterable.iterator();
        do
        {
label0:
            {
                if (iterable.hasNext())
                {
                    stringbuilder.append(iterable.next());
                    if (iterable.hasNext())
                    {
                        break label0;
                    }
                }
                return stringbuilder.toString();
            }
            stringbuilder.append(s);
        } while (true);
    }

    private final String toString(Object obj)
    {
        return (String)obj;
    }

    protected final void addAllParameters(ArrayList arraylist, ArrayList arraylist1)
    {
        for (arraylist1 = arraylist1.iterator(); arraylist1.hasNext(); arraylist.add(cleanParameterKey((String)arraylist1.next()))) { }
    }

    protected final String cleanCommaDelimitedString(String s)
    {
        if (!isSet(s))
        {
            return s;
        } else
        {
            return s.replaceAll(" ", "");
        }
    }

    protected final String cleanContextKey(String s)
    {
        return s.replaceAll("[^a-zA-Z0-9.]", "");
    }

    protected final String cleanParameterKey(String s)
    {
        Object obj = prefixReplacements.keySet().iterator();
_L2:
        String s1;
        String s2;
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break MISSING_BLOCK_LABEL_94;
            }
            s1 = (String)((Iterator) (obj)).next();
        } while (!s.toLowerCase().startsWith(s1));
        s2 = s.substring(s1.length());
        if (Integer.parseInt(s2) <= 0) goto _L2; else goto _L1
_L1:
        obj = (new StringBuilder()).append((String)prefixReplacements.get(s1)).append(s2).toString();
        return ((String) (obj));
        NumberFormatException numberformatexception;
        numberformatexception;
        return s;
        return replaceKeyWithADMSKey(s);
    }

    public abstract void clearTrackingQueue();

    public final void clearVars()
    {
        resetSingleUseParameters();
        purchaseID = null;
        transactionID = null;
        appState = null;
        channel = null;
        appSection = null;
        campaign = null;
        events = null;
        products = null;
        geoZip = null;
        geoState = null;
        lightTrackVars = null;
        linkTrackVars = null;
        linkTrackEvents = null;
        evarMap.clear();
        propMap.clear();
        listMap.clear();
        hierMap.clear();
        persistentContextData.clear();
    }

    public Object clone()
        throws CloneNotSupportedException
    {
        throw new CloneNotSupportedException();
    }

    public final void configureMeasurement(String s, String s1)
    {
        setReportSuiteIDs(s);
        setTrackingServer(s1);
    }

    protected abstract void debugLog(String s);

    protected final void filterLightTrackParameters(Hashtable hashtable, Hashtable hashtable1, Hashtable hashtable2)
    {
        ArrayList arraylist = new ArrayList();
        ArrayList arraylist1 = new ArrayList();
        if (isSet(lightTrackVars))
        {
            arraylist1.addAll(Arrays.asList(lightTrackVars.split("[,]")));
        }
        Hashtable hashtable3 = new Hashtable();
        if (hashtable2 != null)
        {
            Enumeration enumeration = hashtable2.keys();
            do
            {
                if (!enumeration.hasMoreElements())
                {
                    break;
                }
                String s1 = (String)enumeration.nextElement();
                if (s1.equalsIgnoreCase("lightTrackVars"))
                {
                    String s2 = cleanCommaDelimitedString((String)hashtable2.get("lightTrackVars"));
                    if (isSet(s2))
                    {
                        arraylist1.clear();
                        arraylist1.addAll(Arrays.asList(s2.split("[,]")));
                    }
                }
                String s3 = cleanParameterKey(s1);
                if (lightParameterIsValid(s3))
                {
                    hashtable3.put(s3, hashtable2.get(s1));
                }
            } while (true);
        }
        addAllParameters(arraylist, arraylist1);
        putAllParameters(hashtable, hashtable3);
        hashtable2 = null;
        if (arraylist.size() > 0)
        {
            arraylist.addAll(ADMS_DefaultValues.requiredLightVarList);
            hashtable2 = hashtable.keys();
            do
            {
                if (!hashtable2.hasMoreElements())
                {
                    break;
                }
                String s = (String)hashtable2.nextElement();
                if (!arraylist.contains(s))
                {
                    hashtable.remove(s);
                }
            } while (true);
            hashtable2 = generateFilterArrayWithVars(arraylist1);
        }
        handlePersistentContextData(hashtable, hashtable1, hashtable2);
    }

    protected final void filterLinkTrackParameters(Hashtable hashtable, Hashtable hashtable1, Hashtable hashtable2)
    {
        Object obj;
        ArrayList arraylist1;
label0:
        {
            ArrayList arraylist2 = new ArrayList();
            ArrayList arraylist3 = new ArrayList();
            if (isSet(linkTrackVars))
            {
                arraylist3.addAll(Arrays.asList(linkTrackVars.split("[,]")));
            }
            ArrayList arraylist = new ArrayList();
            if (isSet(linkTrackEvents))
            {
                arraylist.addAll(Arrays.asList(linkTrackEvents.split("[,]")));
            }
            arraylist1 = new ArrayList();
            if (isSet(events))
            {
                arraylist1.addAll(Arrays.asList(events.split("[,]")));
            }
            obj = new Hashtable();
            if (hashtable2 != null)
            {
                Enumeration enumeration = hashtable2.keys();
                do
                {
                    if (!enumeration.hasMoreElements())
                    {
                        break;
                    }
                    String s1 = (String)enumeration.nextElement();
                    if (s1.equalsIgnoreCase("linkTrackEvents"))
                    {
                        s1 = cleanCommaDelimitedString((String)hashtable2.get("linkTrackEvents"));
                        if (isSet(s1))
                        {
                            arraylist.clear();
                            arraylist.addAll(Arrays.asList(s1.split("[,]")));
                        }
                    } else
                    if (s1.equalsIgnoreCase("events"))
                    {
                        s1 = cleanCommaDelimitedString((String)hashtable2.get("events"));
                        if (isSet(s1))
                        {
                            arraylist1.clear();
                            arraylist1.addAll(Arrays.asList(s1.split("[,]")));
                        }
                    } else
                    if (s1.equalsIgnoreCase("linkTrackVars"))
                    {
                        s1 = cleanCommaDelimitedString((String)hashtable2.get("linkTrackVars"));
                        if (isSet(s1))
                        {
                            arraylist3.clear();
                            arraylist3.addAll(Arrays.asList(s1.split("[,]")));
                        }
                    } else
                    {
                        String s2 = cleanParameterKey(s1);
                        if (parameterKeyIsValid(s2))
                        {
                            ((Hashtable) (obj)).put(s2, hashtable2.get(s1));
                        }
                    }
                } while (true);
            }
            addAllParameters(arraylist2, arraylist3);
            putAllParameters(hashtable, ((Hashtable) (obj)));
            Object obj2 = null;
            Object obj1 = null;
            obj = null;
            if (hashtable.containsKey("pe"))
            {
                obj = (String)hashtable.get("pe");
            }
            String s = ((String) (obj));
            if (hashtable2 != null)
            {
                s = ((String) (obj));
                if (hashtable2.containsKey("pe"))
                {
                    s = (String)hashtable2.get("pe");
                }
            }
            if (!isSet(s))
            {
                obj = obj2;
                if (!isSet(linkType))
                {
                    break label0;
                }
            }
            hashtable2 = obj1;
            if (arraylist2.size() > 0)
            {
                arraylist2.addAll(ADMS_DefaultValues.requiredVarList);
                hashtable2 = hashtable.keys();
                do
                {
                    if (!hashtable2.hasMoreElements())
                    {
                        break;
                    }
                    obj = (String)hashtable2.nextElement();
                    if (!arraylist2.contains(obj))
                    {
                        hashtable.remove(obj);
                    }
                } while (true);
                hashtable2 = generateFilterArrayWithVars(arraylist3);
            }
            obj = hashtable2;
            if (arraylist.size() > 0)
            {
                obj = new ArrayList();
                ((ArrayList) (obj)).addAll(arraylist1);
                Iterator iterator = ((ArrayList) (obj)).iterator();
                do
                {
                    obj = hashtable2;
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    obj = (String)iterator.next();
                    if (!arraylist.contains(obj))
                    {
                        arraylist1.remove(obj);
                    }
                } while (true);
            }
        }
        handlePersistentContextData(hashtable, hashtable1, ((ArrayList) (obj)));
        putParameter(hashtable, "events", arraylist1);
    }

    protected final ArrayList generateFilterArrayWithVars(ArrayList arraylist)
    {
        ArrayList arraylist1 = new ArrayList();
        arraylist = arraylist.iterator();
        do
        {
            if (!arraylist.hasNext())
            {
                break;
            }
            String s = ((String)arraylist.next()).toLowerCase();
            if (s.equals("contextdata"))
            {
                return null;
            }
            if (s.contains("contextdata"))
            {
                arraylist1.add(s);
            }
        } while (true);
        if (arraylist1.size() > 0)
        {
            arraylist1.add("contextdata.a.CarrierName");
            arraylist1.add("contextdata.a.OSVersion");
            arraylist1.add("contextdata.a.DeviceName");
            arraylist1.add("contextdata.a.Resolution");
            return arraylist1;
        } else
        {
            arraylist1.add("   ");
            return arraylist1;
        }
    }

    protected final Hashtable generateLightTrackParameters()
    {
        Hashtable hashtable = new Hashtable();
        putParameter(hashtable, "ce", charSet);
        putParameter(hashtable, "mtp", lightProfileID);
        putParameter(hashtable, "mtss", Integer.valueOf(lightStoreForSeconds));
        putParameter(hashtable, "mti", Integer.valueOf(lightIncrementBy));
        putAllStringParameters(hashtable, evarMap);
        putAllStringParameters(hashtable, propMap);
        return hashtable;
    }

    protected final Hashtable generateTrackParameters()
    {
        Hashtable hashtable = new Hashtable();
        if (customVisitorID != null)
        {
            putParameter(hashtable, "vid", customVisitorID);
        } else
        {
            putParameter(hashtable, "vid", visitorID);
        }
        putParameter(hashtable, "ce", charSet);
        putParameter(hashtable, "pageName", appState);
        putParameter(hashtable, "cc", currencyCode);
        putParameter(hashtable, "purchaseID", purchaseID);
        putParameter(hashtable, "xact", transactionID);
        putParameter(hashtable, "ch", channel);
        putParameter(hashtable, "server", appSection);
        putParameter(hashtable, "v0", campaign);
        putParameter(hashtable, "zip", geoZip);
        putParameter(hashtable, "state", geoState);
        putParameter(hashtable, "products", products);
        putAllStringParameters(hashtable, propMap);
        putAllStringParameters(hashtable, evarMap);
        putAllStringParameters(hashtable, listMap);
        putAllStringParameters(hashtable, hierMap);
        putAllStringParameters(hashtable, pevMap);
        return hashtable;
    }

    public final String getAppSection()
    {
        return appSection;
    }

    public final String getAppState()
    {
        return appState;
    }

    protected abstract String getApplicationID();

    public final String getCampaign()
    {
        return campaign;
    }

    protected abstract String getCarrierString();

    public final String getChannel()
    {
        return channel;
    }

    public final String getCharSet()
    {
        return charSet;
    }

    public final String getCurrencyCode()
    {
        return currencyCode;
    }

    protected abstract String getDefaultCharSet();

    protected abstract String getDefaultUserAgent();

    public String getEvar(int i)
    {
        if (ADMS_DefaultValues.evarValid(i))
        {
            return (String)evarMap.get((new StringBuilder()).append("v").append(i).toString());
        } else
        {
            return null;
        }
    }

    public final String getEvents()
    {
        return events;
    }

    protected final String getFullTrackingServer()
    {
        if (!isSet(trackingServer))
        {
            String s = "";
            ArrayList arraylist = new ArrayList(Arrays.asList(reportSuiteIDs.split("[,]")));
            if (arraylist.size() > 0)
            {
                s = (String)arraylist.get(0);
            }
            s = s.replace(".", "-").replace("_", "-");
            if (isSet(dataCenter))
            {
                dataCenter = dataCenter.toLowerCase();
                if (dataCenter.equals("dc2") || dataCenter.equals("122"))
                {
                    dataCenter = "122";
                }
            } else
            {
                dataCenter = "112";
            }
            trackingServer = (new StringBuilder()).append(s).append(".").append(dataCenter).append(".2o7.net").toString();
        }
        return trackingServer;
    }

    public final String getGeoState()
    {
        return geoState;
    }

    public final String getGeoZip()
    {
        return geoZip;
    }

    public final String getHier(int i)
    {
        if (ADMS_DefaultValues.hierValid(i))
        {
            return (String)hierMap.get((new StringBuilder()).append("h").append(i).toString());
        } else
        {
            return null;
        }
    }

    protected final int getLightIncrementBy()
    {
        return lightIncrementBy;
    }

    public final String getLightProfileID()
    {
        return lightProfileID;
    }

    protected final int getLightStoreForSeconds()
    {
        return lightStoreForSeconds;
    }

    public final String getLightTrackVars()
    {
        return lightTrackVars;
    }

    protected final String getLinkName()
    {
        return linkName;
    }

    public final String getLinkTrackEvents()
    {
        return linkTrackEvents;
    }

    public final String getLinkTrackVars()
    {
        return linkTrackVars;
    }

    protected final String getLinkType()
    {
        return linkType;
    }

    protected final String getLinkURL()
    {
        return linkURL;
    }

    public final String getListVar(int i)
    {
        if (ADMS_DefaultValues.listValid(i))
        {
            return (String)listMap.get((new StringBuilder()).append("l").append(i).toString());
        } else
        {
            return null;
        }
    }

    protected abstract String getNetworkConnectionString();

    public final int getOfflineHitLimit()
    {
        return offlineHitLimit;
    }

    public final int getOfflineThrottleDelay()
    {
        return 0;
    }

    protected abstract String getOperatingSystemString();

    public final Hashtable getPersistentContextData()
    {
        Hashtable hashtable = null;
        if (persistentContextData != null)
        {
            hashtable = (Hashtable)persistentContextData.clone();
        }
        return hashtable;
    }

    protected abstract String getPlatformString();

    public final String getProducts()
    {
        return products;
    }

    public final String getProp(int i)
    {
        if (ADMS_DefaultValues.propValid(i))
        {
            return (String)propMap.get((new StringBuilder()).append("c").append(i).toString());
        } else
        {
            return null;
        }
    }

    public final String getPurchaseID()
    {
        return purchaseID;
    }

    public final String getReportSuiteIDs()
    {
        this;
        JVM INSTR monitorenter ;
        String s = reportSuiteIDs;
        this;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }

    protected final String getRequestString()
    {
        return getRequestString(null, null);
    }

    protected final String getRequestString(Hashtable hashtable, Hashtable hashtable1)
    {
        if (!isSet(reportSuiteIDs))
        {
            return null;
        }
        hashtable = getTrackingParameters(hashtable, hashtable1);
        debugLog((new StringBuilder()).append("Hit Parameters : ").append(hashtable.toString()).toString());
        int i = 0;
        if (secRandom != null)
        {
            i = secRandom.nextInt(0x5f5e100) + 1;
        }
        hashtable1 = (new StringBuilder()).append("s").append(i).toString();
        String s = serializeToQueryString(hashtable);
        String s1 = getFullTrackingServer();
        if (ssl)
        {
            hashtable = "https";
        } else
        {
            hashtable = "http";
        }
        return (new StringBuilder()).append(hashtable).append("://").append(s1).append("/b/ss/").append(urlEncode(reportSuiteIDs)).append("/0/").append(version).append("/").append(hashtable1).append("?AQB=1&ndh=1").append(s).append("&AQE=1").toString();
    }

    protected abstract String getResolutionString();

    protected final double getTime()
    {
        return (double)Calendar.getInstance().getTime().getTime();
    }

    protected final Hashtable getTrackingParameters(Hashtable hashtable, Hashtable hashtable1)
    {
        Hashtable hashtable2 = new Hashtable();
        validateTechnology();
        if (isSet(lightProfileID))
        {
            putAllParameters(hashtable2, generateLightTrackParameters());
            filterLightTrackParameters(hashtable2, hashtable, hashtable1);
            validateRequiredLightVariables(hashtable2);
        } else
        {
            validateLinkTracking(hashtable2);
            putAllParameters(hashtable2, generateTrackParameters());
            filterLinkTrackParameters(hashtable2, hashtable, hashtable1);
            validateRequiredVariables(hashtable2);
        }
        validateTimestamps(hashtable2);
        return hashtable2;
    }

    public abstract int getTrackingQueueSize();

    public final String getTrackingServer()
    {
        return trackingServer;
    }

    public final String getTransactionID()
    {
        return transactionID;
    }

    public final String getVersion()
    {
        return version;
    }

    public final String getVisitorID()
    {
        this;
        JVM INSTR monitorenter ;
        if (customVisitorID != null) goto _L2; else goto _L1
_L1:
        String s = visitorID;
_L4:
        this;
        JVM INSTR monitorexit ;
        return s;
_L2:
        s = customVisitorID;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    protected final void handlePersistentContextData(Hashtable hashtable, Hashtable hashtable1, ArrayList arraylist)
    {
        Hashtable hashtable2 = new Hashtable();
        hashtable2.putAll(persistentContextData);
        if (hashtable1 != null)
        {
            String s;
            Object obj;
            for (Enumeration enumeration = hashtable1.keys(); enumeration.hasMoreElements(); hashtable2.put(cleanContextKey(s), obj))
            {
                s = (String)enumeration.nextElement();
                obj = hashtable1.get(s);
            }

        }
        putParameter(hashtable, "c", translateContextData(hashtable2, arraylist));
    }

    protected final boolean isBoolean(Object obj)
    {
        boolean flag = false;
        try
        {
            obj = (Boolean)obj;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return false;
        }
        if (obj != null)
        {
            flag = true;
        }
        return flag;
    }

    public final boolean isOfflineTrackingEnabled()
    {
        return offlineTrackingEnabled;
    }

    protected final boolean isSet(double d)
    {
        return d != 0.0D;
    }

    protected final boolean isSet(float f)
    {
        return (double)f != 0.0D;
    }

    protected final boolean isSet(int i)
    {
        return i != 0;
    }

    protected final boolean isSet(Object obj)
    {
        if (obj == null)
        {
            return false;
        }
        if (isString(obj))
        {
            return isSet(toString(obj));
        }
        if (isInteger(obj))
        {
            return isSet(toInteger(obj));
        }
        if (isBoolean(obj))
        {
            return isSet(toBoolean(obj));
        } else
        {
            return true;
        }
    }

    protected final boolean isSet(String s)
    {
        while (s == null || s.length() == 0) 
        {
            return false;
        }
        return true;
    }

    protected final boolean isSet(boolean flag)
    {
        return flag;
    }

    protected final boolean lightParameterIsValid(String s)
    {
        return validLightParameters.contains(s);
    }

    protected final boolean parameterKeyIsValid(String s)
    {
        return validKeys.contains(s);
    }

    protected final void putAllParameters(Hashtable hashtable, Hashtable hashtable1)
    {
        putAllParameters(hashtable, hashtable1, false);
    }

    protected final void putAllParameters(Hashtable hashtable, Hashtable hashtable1, boolean flag)
    {
        if (hashtable1 != null)
        {
            String s;
            for (Enumeration enumeration = hashtable1.keys(); enumeration.hasMoreElements(); putParameter(hashtable, s, hashtable1.get(s), flag))
            {
                s = (String)enumeration.nextElement();
            }

        }
    }

    protected final void putAllStringParameters(Hashtable hashtable, Hashtable hashtable1)
    {
        String s;
        for (Enumeration enumeration = hashtable1.keys(); enumeration.hasMoreElements(); putParameter(hashtable, s, hashtable1.get(s)))
        {
            s = (String)enumeration.nextElement();
        }

    }

    protected final void putContextData(String s, Object obj)
    {
        if (!isSet(s) || !isSet(obj))
        {
            return;
        } else
        {
            persistentContextData.put(s, obj);
            return;
        }
    }

    protected final void putParameter(Hashtable hashtable, String s, Object obj)
    {
        putParameter(hashtable, s, obj, false);
    }

    protected final void putParameter(Hashtable hashtable, String s, Object obj, boolean flag)
    {
        if (!isSet(obj))
        {
            hashtable.remove(s);
        } else
        {
            boolean flag1 = true;
            String s1 = s;
            if (flag)
            {
                s1 = cleanParameterKey(s);
                flag1 = parameterKeyIsValid(s1);
            }
            if (isSet(s1) && isSet(obj) && flag1 && (!(obj instanceof ArrayList) || ((ArrayList)obj).size() != 0) && (!(obj instanceof Hashtable) || ((Hashtable)obj).size() != 0))
            {
                hashtable.put(s1, obj);
                return;
            }
        }
    }

    protected final void putStringParameter(Hashtable hashtable, String s, String s1)
    {
        if (!isSet(s1))
        {
            hashtable.remove(s);
            return;
        } else
        {
            hashtable.put(s, s1);
            return;
        }
    }

    protected final String replaceKeyWithADMSKey(String s)
    {
        String s1 = s.toLowerCase();
        if (keyReplacements.containsKey(s1))
        {
            return (String)keyReplacements.get(s1);
        } else
        {
            return s;
        }
    }

    protected final void resetSingleUseParameters()
    {
        linkURL = null;
        linkName = null;
        linkType = null;
        lightProfileID = null;
        lightStoreForSeconds = 0;
        lightIncrementBy = 0;
        pevMap.clear();
    }

    protected abstract void saveVisitorID(String s);

    protected abstract void sendRequest(String s);

    protected final String serializeToQueryString(Hashtable hashtable)
    {
        StringBuilder stringbuilder = new StringBuilder(1024);
        hashtable = hashtable.entrySet().iterator();
        do
        {
            if (!hashtable.hasNext())
            {
                break;
            }
            Object obj = (java.util.Map.Entry)hashtable.next();
            String s = urlEncode((String)((java.util.Map.Entry) (obj)).getKey());
            obj = ((java.util.Map.Entry) (obj)).getValue();
            if ((obj instanceof String) && isSet((String)obj))
            {
                obj = (String)obj;
                stringbuilder.append("&");
                stringbuilder.append(s);
                stringbuilder.append("=");
                stringbuilder.append(urlEncode(((String) (obj))));
            } else
            if (obj instanceof ADMS_ContextData)
            {
                boolean flag1 = false;
                obj = (ADMS_ContextData)obj;
                boolean flag = flag1;
                if (((ADMS_ContextData) (obj)).value instanceof String)
                {
                    flag = flag1;
                    if (isSet((String)((ADMS_ContextData) (obj)).value))
                    {
                        flag = true;
                        stringbuilder.append("&");
                        stringbuilder.append(s);
                        stringbuilder.append("=");
                        stringbuilder.append(urlEncode((String)((ADMS_ContextData) (obj)).value));
                    }
                }
                if (((ADMS_ContextData) (obj)).contextData.size() > 0)
                {
                    stringbuilder.append("&");
                    stringbuilder.append(s);
                    stringbuilder.append(".");
                    stringbuilder.append(serializeToQueryString(((ADMS_ContextData) (obj)).contextData));
                    stringbuilder.append("&.");
                    stringbuilder.append(s);
                } else
                if (isSet(((ADMS_ContextData) (obj)).value) && !flag)
                {
                    stringbuilder.append("&");
                    stringbuilder.append(s);
                    stringbuilder.append("=");
                    stringbuilder.append(urlEncode(((ADMS_ContextData) (obj)).value.toString()));
                }
            } else
            if (obj instanceof ArrayList)
            {
                obj = (ArrayList)obj;
                if (((ArrayList) (obj)).size() > 0)
                {
                    obj = join(((Iterable) (obj)), ",");
                    stringbuilder.append("&");
                    stringbuilder.append(s);
                    stringbuilder.append("=");
                    stringbuilder.append(urlEncode(((String) (obj)).toString()));
                }
            } else
            {
                String s1 = obj.toString();
                debugLog((new StringBuilder()).append("Object for parameter \"").append(s).append("\" is of class ").append(obj.getClass().getSimpleName()).append(".").toString());
                debugLog((new StringBuilder()).append("We recommend using strings where possible, but we are sending this parameter with a value of ").append(s1).append(".").toString());
                debugLog("If you would like another value for this parameter please send the value as a string the way you would like it to appear.");
                stringbuilder.append("&");
                stringbuilder.append(s);
                stringbuilder.append("=");
                stringbuilder.append(urlEncode(s1));
            }
        } while (true);
        return stringbuilder.toString();
    }

    public final void setAppSection(String s)
    {
        appSection = s;
    }

    public final void setAppState(String s)
    {
        appState = s;
    }

    public final void setCampaign(String s)
    {
        campaign = s;
    }

    public final void setChannel(String s)
    {
        channel = s;
    }

    public final void setCharSet(String s)
    {
        charSet = s;
    }

    public final void setCurrencyCode(String s)
    {
        currencyCode = s;
    }

    public final void setDebugLogging(boolean flag)
    {
        debugLogging = flag;
    }

    public final void setEvar(int i, String s)
    {
        if (ADMS_DefaultValues.evarValid(i))
        {
            String s1 = (new StringBuilder()).append("v").append(i).toString();
            putStringParameter(evarMap, s1, s);
        }
    }

    public final void setEvents(String s)
    {
        events = cleanCommaDelimitedString(s);
    }

    public final void setGeoState(String s)
    {
        geoState = s;
    }

    public final void setGeoZip(String s)
    {
        geoZip = s;
    }

    public final void setHier(int i, String s)
    {
        if (ADMS_DefaultValues.hierValid(i))
        {
            String s1 = (new StringBuilder()).append("h").append(i).toString();
            putStringParameter(hierMap, s1, s);
        }
    }

    protected final void setLightIncrementBy(int i)
    {
        lightIncrementBy = i;
    }

    protected final void setLightProfileID(String s)
    {
        lightProfileID = s;
    }

    protected final void setLightStoreForSeconds(int i)
    {
        lightStoreForSeconds = i;
    }

    public final void setLightTrackVars(String s)
    {
        lightTrackVars = cleanCommaDelimitedString(s);
    }

    protected final void setLinkName(String s)
    {
        linkName = s;
    }

    public final void setLinkTrackEvents(String s)
    {
        linkTrackEvents = cleanCommaDelimitedString(s);
    }

    public final void setLinkTrackVars(String s)
    {
        linkTrackVars = cleanCommaDelimitedString(s);
    }

    protected final void setLinkType(String s)
    {
        linkType = s;
    }

    protected final void setLinkURL(String s)
    {
        linkURL = s;
    }

    public final void setListVar(int i, String s)
    {
        if (ADMS_DefaultValues.listValid(i))
        {
            String s1 = (new StringBuilder()).append("l").append(i).toString();
            putStringParameter(listMap, s1, s);
        }
    }

    public abstract void setOffline();

    public abstract void setOfflineHitLimit(int i);

    public abstract void setOfflineThrottleDelay(int i);

    public abstract void setOfflineTrackingEnabled(boolean flag);

    public abstract void setOnline();

    public final void setPersistentContextData(Hashtable hashtable)
    {
        if (persistentContextData == null)
        {
            persistentContextData = new Hashtable();
        }
        persistentContextData.clear();
        if (hashtable != null)
        {
            String s;
            Object obj;
            for (Enumeration enumeration = hashtable.keys(); enumeration.hasMoreElements(); persistentContextData.put(cleanContextKey(s), obj))
            {
                s = (String)enumeration.nextElement();
                obj = hashtable.get(s);
            }

        }
    }

    public final void setProducts(String s)
    {
        if (isSet(s))
        {
            products = s.replaceAll(", ", ",");
            products = products.replaceAll(" ,", ",");
            return;
        } else
        {
            products = s;
            return;
        }
    }

    public final void setProp(int i, String s)
    {
        if (ADMS_DefaultValues.propValid(i))
        {
            String s1 = (new StringBuilder()).append("c").append(i).toString();
            putStringParameter(propMap, s1, s);
        }
    }

    public final void setPurchaseID(String s)
    {
        purchaseID = s;
    }

    public final void setReportSuiteIDs(String s)
    {
        this;
        JVM INSTR monitorenter ;
        reportSuiteIDs = cleanCommaDelimitedString(s);
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public final void setSSL(boolean flag)
    {
        ssl = flag;
    }

    public final void setTrackingServer(String s)
    {
        trackingServer = s;
    }

    public final void setTransactionID(String s)
    {
        transactionID = s;
    }

    public final void setVisitorID(String s)
    {
        this;
        JVM INSTR monitorenter ;
        if (s == null) goto _L2; else goto _L1
_L1:
        if (s.trim().length() != 0) goto _L3; else goto _L2
_L2:
        customVisitorID = null;
_L5:
        this;
        JVM INSTR monitorexit ;
        return;
_L3:
        customVisitorID = s;
        if (true) goto _L5; else goto _L4
_L4:
        s;
        throw s;
    }

    protected final void setupDefaults()
    {
        version = "JAVA-3.2.1-AN";
        evarMap = new Hashtable();
        propMap = new Hashtable();
        pevMap = new Hashtable();
        hierMap = new Hashtable();
        listMap = new Hashtable();
        persistentContextData = new Hashtable();
        offlineTrackingEnabled = false;
        offlineHitLimit = 1000;
        ssl = false;
        trackingServer = null;
        try
        {
            secRandom = SecureRandom.getInstance("SHA1PRNG");
            return;
        }
        catch (NoSuchAlgorithmException nosuchalgorithmexception)
        {
            secRandom = null;
            debugLog((new StringBuilder()).append("Unable to create secure random number generator : ").append(nosuchalgorithmexception.getMessage()).toString());
            return;
        }
    }

    protected final boolean toBoolean(Object obj)
    {
        return ((Boolean)obj).booleanValue();
    }

    protected final int toInteger(Object obj)
    {
        return ((Integer)obj).intValue();
    }

    public final void track()
    {
        track(null);
    }

    public final void track(Hashtable hashtable)
    {
        track(hashtable, null);
    }

    public final void track(Hashtable hashtable, Hashtable hashtable1)
    {
        this;
        JVM INSTR monitorenter ;
        if (isSet(reportSuiteIDs))
        {
            break MISSING_BLOCK_LABEL_16;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        sendRequest(getRequestString(hashtable, hashtable1));
        resetSingleUseParameters();
        this;
        JVM INSTR monitorexit ;
        return;
        hashtable;
        this;
        JVM INSTR monitorexit ;
        throw hashtable;
    }

    public final void trackAppState(String s)
    {
        trackAppState(s, null);
    }

    public final void trackAppState(String s, Hashtable hashtable)
    {
        Hashtable hashtable1 = new Hashtable();
        hashtable1.put("pageName", s);
        track(hashtable, hashtable1);
    }

    public final void trackEvents(String s)
    {
        trackEvents(s, null);
    }

    public final void trackEvents(String s, Hashtable hashtable)
    {
        Hashtable hashtable1 = new Hashtable();
        hashtable1.put("events", s);
        trackLink(null, "o", (new StringBuilder()).append(getApplicationID()).append(" Event").toString(), hashtable, hashtable1);
    }

    public final void trackLight(String s, int i, int j, Hashtable hashtable, Hashtable hashtable1)
    {
        setLightProfileID(s);
        setLightStoreForSeconds(i);
        setLightIncrementBy(j);
        track(hashtable, hashtable1);
    }

    public final void trackLink(String s, String s1, String s2, Hashtable hashtable, Hashtable hashtable1)
    {
        setLinkURL(s);
        setLinkType(s1);
        setLinkName(s2);
        track(hashtable, hashtable1);
    }

    protected final ADMS_ContextData translateContextData(Hashtable hashtable, ArrayList arraylist)
    {
        ADMS_ContextData adms_contextdata = new ADMS_ContextData();
        Enumeration enumeration = hashtable.keys();
        do
        {
            if (!enumeration.hasMoreElements())
            {
                break;
            }
            String s = (String)enumeration.nextElement();
            if (arraylist == null || arraylist.contains((new StringBuilder()).append("contextdata.").append(s.toLowerCase()).toString()))
            {
                ArrayList arraylist1 = new ArrayList();
                int i = 0;
                do
                {
                    int j = s.indexOf('.', i);
                    if (j < 0)
                    {
                        break;
                    }
                    arraylist1.add(s.substring(i, j));
                    i = j + 1;
                } while (true);
                arraylist1.add(s.substring(i, s.length()));
                addValueToHashtable(hashtable.get(s), adms_contextdata, arraylist1, 0);
            }
        } while (true);
        return adms_contextdata;
    }

    protected final String urlEncode(String s)
    {
        if (s == null)
        {
            return null;
        }
        StringBuilder stringbuilder;
        int i;
        int j;
        try
        {
            s = s.getBytes("UTF-8");
            j = s.length;
            stringbuilder = new StringBuilder(j << 1);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            debugLog((new StringBuilder()).append("UnsupportedEncodingException : ").append(s.getMessage()).toString());
            return null;
        }
        i = 0;
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        stringbuilder.append(encodedChars[s[i] & 0xff]);
        i++;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_32;
_L1:
        s = stringbuilder.toString();
        return s;
    }

    protected final void validateLinkTracking(Hashtable hashtable)
    {
        if (isSet(linkType) && (isSet(linkURL) || isSet(linkName)))
        {
            linkType = linkType.toLowerCase();
            if (!linkType.equalsIgnoreCase("d") && !linkType.equalsIgnoreCase("e"))
            {
                linkType = "o";
            }
            putParameter(hashtable, "pe", (new StringBuilder()).append("lnk_").append(linkType).toString());
            putParameter(hashtable, "pev1", linkURL);
            putParameter(hashtable, "pev2", linkName);
        }
    }

    protected final void validateRequiredLightVariables(Hashtable hashtable)
    {
        if (!hashtable.containsKey("ce"))
        {
            putParameter(hashtable, "ce", getDefaultCharSet());
        }
    }

    protected final void validateRequiredVariables(Hashtable hashtable)
    {
        if (!hashtable.containsKey("vid"))
        {
            putParameter(hashtable, "vid", visitorID);
        }
        if (!hashtable.containsKey("ce"))
        {
            putParameter(hashtable, "ce", getDefaultCharSet());
        }
        if (!hashtable.containsKey("pageName") && !hashtable.containsKey("g"))
        {
            putParameter(hashtable, "pageName", getApplicationID());
        }
    }

    protected final void validateTechnology()
    {
        persistentContextData.put("a.Resolution", getResolutionString());
        persistentContextData.put("a.DeviceName", getPlatformString());
        persistentContextData.put("a.OSVersion", getOperatingSystemString());
        persistentContextData.put("a.CarrierName", getCarrierString());
    }

    protected final void validateTimestamps(Hashtable hashtable)
    {
        Date date = new Date();
        if (timestamp != 0L || !offlineTrackingEnabled) goto _L2; else goto _L1
_L1:
        putParameter(hashtable, "ts", (new StringBuilder()).append("").append((long)Math.floor(getTime() / 1000D)).toString());
_L4:
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        putParameter(hashtable, "t", (new StringBuilder()).append("").append(calendar.get(5)).append("/").append(calendar.get(2)).append("/").append(calendar.get(1)).append(" ").append(calendar.get(11)).append(":").append(calendar.get(12)).append(":").append(calendar.get(13)).append(" ").append(calendar.get(7) - 1).append(" ").append((calendar.getTimeZone().getOffset(1, calendar.get(1), calendar.get(2), calendar.get(5), calendar.get(7), ((calendar.get(11) * 60 + calendar.get(12)) * 60 + calendar.get(13)) * 1000 + calendar.get(14)) / 60000) * -1).toString());
        return;
_L2:
        if (timestamp != 0L)
        {
            date = new Date(timestamp);
            putParameter(hashtable, "ts", (new StringBuilder()).append("").append(timestamp).toString());
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

}
