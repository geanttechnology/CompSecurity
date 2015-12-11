// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.platform;

import com.amazon.mShop.util.Util;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class AppLocale
{

    private static final AppLocale mInstance = new AppLocale();
    private Locale mCurrentLocale;
    private String mDefaultLocaleName;
    private Map mMapMappingMarketPlaceWithLocale;
    private Set mSupportedLocaleNameSet;

    private AppLocale()
    {
        mDefaultLocaleName = "en_US";
        mCurrentLocale = new Locale("en", "US");
        initSupportedLocaleNameSet();
        initMapMappingMarketPlaceWithLocale();
    }

    public static AppLocale getInstance()
    {
        return mInstance;
    }

    private void initMapMappingMarketPlaceWithLocale()
    {
        mMapMappingMarketPlaceWithLocale = new HashMap();
        mMapMappingMarketPlaceWithLocale.put("en_CA", "A2EUQ1WTGCTBG2");
        mMapMappingMarketPlaceWithLocale.put("fr_CA", "A2EUQ1WTGCTBG2");
        mMapMappingMarketPlaceWithLocale.put("zh_CN", "AAHKV2X7AFYLW");
        mMapMappingMarketPlaceWithLocale.put("ja_JP", "A1VC38T7YXB528");
        mMapMappingMarketPlaceWithLocale.put("en_GB", "A1F83G8C2ARO7P");
        mMapMappingMarketPlaceWithLocale.put("en_IN", "A21TJRUUN4KGV");
        mMapMappingMarketPlaceWithLocale.put("en_US", "ATVPDKIKX0DER");
        mMapMappingMarketPlaceWithLocale.put("de_DE", "A1PA6795UKMFR9");
        mMapMappingMarketPlaceWithLocale.put("es_ES", "A1RKKUPIHCS9HS");
        mMapMappingMarketPlaceWithLocale.put("fr_FR", "A13V1IB3VIYZZH");
        mMapMappingMarketPlaceWithLocale.put("it_IT", "APJ6JRA9NG5V4");
    }

    private void initSupportedLocaleNameSet()
    {
        mSupportedLocaleNameSet = new HashSet();
        mSupportedLocaleNameSet.add("de_DE");
        mSupportedLocaleNameSet.add("en_GB");
        mSupportedLocaleNameSet.add("en_IN");
        mSupportedLocaleNameSet.add("en_US");
        mSupportedLocaleNameSet.add("fr_FR");
        mSupportedLocaleNameSet.add("ja_JP");
        mSupportedLocaleNameSet.add("zh_CN");
        mSupportedLocaleNameSet.add("it_IT");
        mSupportedLocaleNameSet.add("es_ES");
        mSupportedLocaleNameSet.add("en_CA");
        mSupportedLocaleNameSet.add("fr_CA");
    }

    public static boolean isLocaleOfCA(String s)
    {
        return "en_CA".equals(s) || "fr_CA".equals(s);
    }

    public Locale getCurrentLocale()
    {
        this;
        JVM INSTR monitorenter ;
        Locale locale = mCurrentLocale;
        this;
        JVM INSTR monitorexit ;
        return locale;
        Exception exception;
        exception;
        throw exception;
    }

    public String getCurrentLocaleName()
    {
        this;
        JVM INSTR monitorenter ;
        String s = mCurrentLocale.toString();
        this;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }

    public String getDefaultLocale()
    {
        this;
        JVM INSTR monitorenter ;
        String s = mDefaultLocaleName;
        this;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }

    public String getLocaleByMarketPlaceId(String s)
    {
label0:
        {
            if (mMapMappingMarketPlaceWithLocale.entrySet() == null)
            {
                break label0;
            }
            Iterator iterator = mMapMappingMarketPlaceWithLocale.entrySet().iterator();
            java.util.Map.Entry entry;
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
                entry = (java.util.Map.Entry)iterator.next();
            } while (!s.equals(entry.getValue()));
            return (String)entry.getKey();
        }
        return null;
    }

    public String getLocaleName(Locale locale)
    {
        return (new StringBuilder()).append(locale.getLanguage()).append("_").append(locale.getCountry()).toString();
    }

    public String getMarketPlaceIdByLocale(String s)
    {
        if (!Util.isEmpty(s))
        {
            return (String)mMapMappingMarketPlaceWithLocale.get(s);
        } else
        {
            return null;
        }
    }

    public final Object[] getSupportedLocaleNameArray()
    {
        return mSupportedLocaleNameSet.toArray();
    }

    public boolean isSupported(String s)
    {
        return mSupportedLocaleNameSet.contains(s);
    }

    public boolean setCurrentLocale(String s)
        throws IllegalArgumentException
    {
        this;
        JVM INSTR monitorenter ;
        if (Util.isEmpty(s))
        {
            throw new IllegalArgumentException("localeName should not be null nor empty");
        }
        break MISSING_BLOCK_LABEL_24;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
        boolean flag = isSupported(s);
        if (flag) goto _L2; else goto _L1
_L1:
        flag = false;
_L4:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        s = new StringTokenizer(s, "_");
        mCurrentLocale = new Locale(s.nextToken(), s.nextToken());
        flag = true;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public boolean setDefaultLocale(String s)
        throws IllegalArgumentException
    {
        this;
        JVM INSTR monitorenter ;
        if (Util.isEmpty(s))
        {
            throw new IllegalArgumentException("locale should not be null nor empty");
        }
        break MISSING_BLOCK_LABEL_24;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
        boolean flag = isSupported(s);
        if (flag) goto _L2; else goto _L1
_L1:
        flag = false;
_L4:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        mDefaultLocaleName = s;
        flag = true;
        if (true) goto _L4; else goto _L3
_L3:
    }

}
