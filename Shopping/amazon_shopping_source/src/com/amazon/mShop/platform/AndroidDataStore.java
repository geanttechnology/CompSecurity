// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.platform;

import android.content.Context;
import android.content.SharedPreferences;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.persistence.DataStore;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

// Referenced classes of package com.amazon.mShop.platform:
//            AppLocale

public class AndroidDataStore
    implements DataStore
{

    private static final List sNonLocalizedKeysList;
    private static final List sSessionKeyList;
    private final Map byteArraysCache = new HashMap(4);
    private final SharedPreferences preferences;

    public AndroidDataStore(Context context)
    {
        preferences = context.getSharedPreferences("DataStore", 0);
    }

    private static boolean shouldWrapTagWithLocale(String s)
    {
        return shouldWrapTagWithLocale(s, AppLocale.getInstance().getCurrentLocale().toString().trim());
    }

    private static boolean shouldWrapTagWithLocale(String s, String s1)
    {
        String s2 = AppLocale.getInstance().getDefaultLocale();
        return !Util.isEmpty(s2) && !s2.equals(s1) && (!AppLocale.isLocaleOfCA(s1) || !AppLocale.isLocaleOfCA(s2)) && !sNonLocalizedKeysList.contains(s);
    }

    public static String wrapKeyWithLocale(String s)
    {
        String s1 = s;
        if (shouldWrapTagWithLocale(s))
        {
            s1 = wrapKeyWithLocale(s, AppLocale.getInstance().getCurrentLocale().toString());
        }
        return s1;
    }

    private static String wrapKeyWithLocale(String s, String s1)
    {
        if (shouldWrapTagWithLocale(s, s1))
        {
            if (AppLocale.isLocaleOfCA(s1))
            {
                return (new StringBuilder()).append(s).append("_").append("CA").toString();
            } else
            {
                return (new StringBuilder()).append(s).append("_").append(s1).toString();
            }
        } else
        {
            return s;
        }
    }

    public boolean getBoolean(String s)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag;
        s = wrapKeyWithLocale(s);
        flag = preferences.getBoolean(s, false);
        this;
        JVM INSTR monitorexit ;
        return flag;
        s;
        throw s;
    }

    public boolean getBoolean(String s, String s1)
    {
        s = wrapKeyWithLocale(s, s1);
        return preferences.getBoolean(s, false);
    }

    public boolean getBoolean(String s, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        s = wrapKeyWithLocale(s);
        flag = preferences.getBoolean(s, flag);
        this;
        JVM INSTR monitorexit ;
        return flag;
        s;
        throw s;
    }

    public byte[] getByteArray(String s)
    {
        this;
        JVM INSTR monitorenter ;
        byte abyte0[];
        String s1;
        s1 = wrapKeyWithLocale(s);
        abyte0 = (byte[])byteArraysCache.get(s1);
        s = abyte0;
        if (abyte0 != null)
        {
            break MISSING_BLOCK_LABEL_142;
        }
        String s2 = preferences.getString(s1, null);
        s = abyte0;
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_142;
        }
        s = new byte[s2.length() >> 1];
        int i;
        int j;
        i = 0;
        j = 0;
_L2:
        if (i >= s.length)
        {
            break; /* Loop/switch isn't completed */
        }
        int k = j + 1;
        int l = Character.digit(s2.charAt(j), 16);
        j = k + 1;
        s[i] = (byte)((l << 4) + (Character.digit(s2.charAt(k), 16) & 0xf));
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        byteArraysCache.put(s1, s);
        this;
        JVM INSTR monitorexit ;
        return s;
        s;
        throw s;
    }

    public int getInt(String s)
    {
        this;
        JVM INSTR monitorenter ;
        int i;
        s = wrapKeyWithLocale(s);
        i = preferences.getInt(s, 0);
        this;
        JVM INSTR monitorexit ;
        return i;
        s;
        throw s;
    }

    public int getInt(String s, String s1)
    {
        this;
        JVM INSTR monitorenter ;
        int i;
        s = wrapKeyWithLocale(s, s1);
        i = preferences.getInt(s, 0);
        this;
        JVM INSTR monitorexit ;
        return i;
        s;
        throw s;
    }

    public long getLong(String s)
    {
        this;
        JVM INSTR monitorenter ;
        long l;
        s = wrapKeyWithLocale(s);
        l = preferences.getLong(s, 0L);
        this;
        JVM INSTR monitorexit ;
        return l;
        s;
        throw s;
    }

    public long getLong(String s, String s1)
    {
        this;
        JVM INSTR monitorenter ;
        long l;
        s = wrapKeyWithLocale(s, s1);
        l = preferences.getLong(s, 0L);
        this;
        JVM INSTR monitorexit ;
        return l;
        s;
        throw s;
    }

    public String getString(String s)
    {
        this;
        JVM INSTR monitorenter ;
        s = wrapKeyWithLocale(s);
        s = preferences.getString(s, null);
        this;
        JVM INSTR monitorexit ;
        return s;
        s;
        throw s;
    }

    public String getString(String s, String s1)
    {
        this;
        JVM INSTR monitorenter ;
        s = wrapKeyWithLocale(s, s1);
        s = preferences.getString(s, null);
        this;
        JVM INSTR monitorexit ;
        return s;
        s;
        throw s;
    }

    public void putBoolean(String s, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        s = wrapKeyWithLocale(s);
        android.content.SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(s, flag);
        editor.commit();
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public void putBoolean(String s, boolean flag, String s1)
    {
        this;
        JVM INSTR monitorenter ;
        s = wrapKeyWithLocale(s, s1);
        s1 = preferences.edit();
        s1.putBoolean(s, flag);
        s1.commit();
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public void putByteArray(String s, byte abyte0[])
    {
        this;
        JVM INSTR monitorenter ;
        android.content.SharedPreferences.Editor editor;
        s = wrapKeyWithLocale(s);
        editor = preferences.edit();
        if (abyte0 != null) goto _L2; else goto _L1
_L1:
        editor.remove(s);
        byteArraysCache.remove(s);
_L5:
        editor.commit();
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        char ac[] = new char[abyte0.length << 1];
        int i;
        int j;
        i = 0;
        j = 0;
_L4:
        if (i >= abyte0.length)
        {
            break; /* Loop/switch isn't completed */
        }
        byte byte0;
        int k;
        byte0 = abyte0[i];
        k = j + 1;
        ac[j] = Character.forDigit(byte0 >> 4 & 0xf, 16);
        j = k + 1;
        ac[k] = Character.forDigit(byte0 & 0xf, 16);
        i++;
        if (true) goto _L4; else goto _L3
_L3:
        editor.putString(s, new String(ac));
        byteArraysCache.put(s, abyte0);
          goto _L5
        s;
        throw s;
    }

    public void putInt(String s, int i)
    {
        this;
        JVM INSTR monitorenter ;
        s = wrapKeyWithLocale(s);
        android.content.SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(s, i);
        editor.commit();
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public void putLong(String s, long l)
    {
        this;
        JVM INSTR monitorenter ;
        s = wrapKeyWithLocale(s);
        android.content.SharedPreferences.Editor editor = preferences.edit();
        editor.putLong(s, l);
        editor.commit();
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public void putLong(String s, long l, String s1)
    {
        this;
        JVM INSTR monitorenter ;
        s = wrapKeyWithLocale(s, s1);
        s1 = preferences.edit();
        s1.putLong(s, l);
        s1.commit();
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public void putString(String s, String s1)
    {
        this;
        JVM INSTR monitorenter ;
        s = wrapKeyWithLocale(s);
        android.content.SharedPreferences.Editor editor = preferences.edit();
        editor.putString(s, s1);
        editor.commit();
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public void putString(String s, String s1, String s2)
    {
        this;
        JVM INSTR monitorenter ;
        s = wrapKeyWithLocale(s, s2);
        s2 = preferences.edit();
        s2.putString(s, s1);
        s2.commit();
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public void putString(String s, String s1, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        String s2;
        s2 = s;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_15;
        }
        s2 = wrapKeyWithLocale(s);
        s = preferences.edit();
        s.putString(s2, s1);
        s.commit();
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public void remove(String s)
    {
        this;
        JVM INSTR monitorenter ;
        s = wrapKeyWithLocale(s);
        android.content.SharedPreferences.Editor editor = preferences.edit();
        editor.remove(s);
        byteArraysCache.remove(s);
        editor.commit();
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public void remove(String s, String s1)
    {
        android.content.SharedPreferences.Editor editor = preferences.edit();
        s = wrapKeyWithLocale(s, s1);
        editor.remove(s);
        byteArraysCache.remove(s);
        editor.commit();
    }

    public void removeSessionData(String s)
    {
        this;
        JVM INSTR monitorenter ;
        android.content.SharedPreferences.Editor editor;
        editor = preferences.edit();
        String s1;
        for (Iterator iterator = sSessionKeyList.iterator(); iterator.hasNext(); byteArraysCache.remove(s1))
        {
            s1 = wrapKeyWithLocale((String)iterator.next(), s);
            editor.remove(s1);
        }

        break MISSING_BLOCK_LABEL_74;
        s;
        throw s;
        editor.commit();
        this;
        JVM INSTR monitorexit ;
    }

    static 
    {
        sSessionKeyList = new ArrayList();
        sSessionKeyList.add("cookieJar");
        sSessionKeyList.add("secureCookieJar");
        sSessionKeyList.add("userEmail");
        sSessionKeyList.add("userFullName");
        sSessionKeyList.add("userPrime");
        sSessionKeyList.add("userOneClick");
        sSessionKeyList.add("userPrimeEligible");
        sSessionKeyList.add("userPrimeFunnelUrl");
        sSessionKeyList.add("userDob");
        sSessionKeyList.add("oneClickAutoSetupState");
        sSessionKeyList.add("successfullyConnected");
        sSessionKeyList.add("acceptedEulaVersion");
        sSessionKeyList.add("allowUseUserCurrentlocation");
        sSessionKeyList.add("isLocationAllowDialogShown");
        sSessionKeyList.add("isArTried");
        sSessionKeyList.add("suppressInfoDialog");
        sSessionKeyList.add("lastRemembersUpdate");
        sSessionKeyList.add("dataChargesDialogShown");
        sSessionKeyList.add("applicationExitReason");
        sSessionKeyList.add("applicationStartCount");
        sSessionKeyList.add("remembersPendingMatches");
        sSessionKeyList.add("remembersMatchesToMarkAsNew");
        sSessionKeyList.add("recentProducts");
        sSessionKeyList.add("userRatingRequestErrorSet");
        sSessionKeyList.add("needToSelectLocale");
        sNonLocalizedKeysList = new ArrayList();
        sNonLocalizedKeysList.add("amazonAssociatesTag");
        sNonLocalizedKeysList.add("associatesTagWithoutLocaleCode");
        sNonLocalizedKeysList.add("applicationCurrentLocale");
        sNonLocalizedKeysList.add("userRatingRequestErrorSet");
        sNonLocalizedKeysList.add("partnerName");
        sNonLocalizedKeysList.add("UDID");
        sNonLocalizedKeysList.add("gcmRegistrationId");
        sNonLocalizedKeysList.add("gcmErrorId");
        sNonLocalizedKeysList.add("latestLocaleOfCanada");
        sNonLocalizedKeysList.add("enableMAPr5");
        sNonLocalizedKeysList.add("app_start_count_of_current_version");
        sNonLocalizedKeysList.add("shortcut_install_current_version");
        sNonLocalizedKeysList.add("is_shortcut_installed");
        sNonLocalizedKeysList.add("appStartIndicationDialogNotRemindAgain");
        sNonLocalizedKeysList.add("referrerSource");
        sNonLocalizedKeysList.add("applicationInstallId");
        sNonLocalizedKeysList.add("applicationSecretKey");
        sNonLocalizedKeysList.add("globalApplicationVersion");
        sNonLocalizedKeysList.add("hardwareIdentifier");
        sNonLocalizedKeysList.add("osVersion");
        sNonLocalizedKeysList.add("Ubid");
        sNonLocalizedKeysList.add("kiangUpdateSequenceNumber");
        sNonLocalizedKeysList.add("currentLocaleName");
    }
}
