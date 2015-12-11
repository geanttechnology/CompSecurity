// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apptentive.android.sdk.storage;

import android.content.Context;
import android.content.SharedPreferences;
import com.apptentive.android.sdk.Log;
import com.apptentive.android.sdk.util.Util;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class VersionHistoryStore
{

    public static final String ENTRY_SEP = "__";
    public static final String FIELD_SEP = "--";

    public VersionHistoryStore()
    {
    }

    public static VersionHistoryEntry getLastVersionSeen(Context context)
    {
        context = getVersionHistory(context);
        if (context != null && !context.isEmpty())
        {
            return (VersionHistoryEntry)context.get(context.size() - 1);
        } else
        {
            return null;
        }
    }

    public static Double getTimeSinceVersionFirstSeen(Context context, Selector selector)
    {
        Object obj = getVersionHistory(context);
        if (obj == null) goto _L2; else goto _L1
_L1:
        Iterator iterator = ((List) (obj)).iterator();
_L9:
        if (!iterator.hasNext()) goto _L2; else goto _L3
_L3:
        VersionHistoryEntry versionhistoryentry;
        versionhistoryentry = (VersionHistoryEntry)iterator.next();
        obj = versionhistoryentry;
        _cls1..SwitchMap.com.apptentive.android.sdk.storage.VersionHistoryStore.Selector[selector.ordinal()];
        JVM INSTR tableswitch 1 3: default 76
    //                   1 94
    //                   2 78
    //                   3 113;
           goto _L4 _L5 _L6 _L7
_L5:
        break MISSING_BLOCK_LABEL_94;
_L7:
        continue; /* Loop/switch isn't completed */
_L4:
        return null;
_L6:
        if (!versionhistoryentry.versionName.equals(Util.getAppVersionName(context))) goto _L9; else goto _L8
_L8:
        obj = versionhistoryentry;
_L11:
        if (obj != null)
        {
            return Double.valueOf(Util.currentTimeSeconds() - ((VersionHistoryEntry) (obj)).seconds.doubleValue());
        } else
        {
            return null;
        }
        if (!versionhistoryentry.versionCode.equals(Integer.valueOf(Util.getAppVersionCode(context)))) goto _L9; else goto _L10
_L10:
        obj = versionhistoryentry;
          goto _L11
_L2:
        obj = null;
          goto _L11
    }

    public static List getVersionHistory(Context context)
    {
        int i = 0;
        ArrayList arraylist = new ArrayList();
        context = context.getSharedPreferences("APPTENTIVE", 0).getString("versionHistory", null);
        if (context != null)
        {
            for (context = context.split("__"); i < context.length; i++)
            {
                arraylist.add(new VersionHistoryEntry(context[i]));
            }

        }
        return arraylist;
    }

    public static boolean isUpdate(Context context, Selector selector)
    {
        Object obj;
        obj = getVersionHistory(context);
        context = new HashSet();
        if (obj == null) goto _L2; else goto _L1
_L1:
        obj = ((List) (obj)).iterator();
_L4:
        if (((Iterator) (obj)).hasNext())
        {
            VersionHistoryEntry versionhistoryentry = (VersionHistoryEntry)((Iterator) (obj)).next();
            switch (_cls1..SwitchMap.com.apptentive.android.sdk.storage.VersionHistoryStore.Selector[selector.ordinal()])
            {
            case 2: // '\002'
                context.add(versionhistoryentry.versionName);
                break;

            case 3: // '\003'
                context.add(String.valueOf(versionhistoryentry.versionCode));
                break;
            }
            continue; /* Loop/switch isn't completed */
        }
_L2:
        return context.size() > 1;
        if (true) goto _L4; else goto _L3
_L3:
    }

    private static void saveVersionHistory(Context context, List list)
    {
        context = context.getSharedPreferences("APPTENTIVE", 0);
        StringBuilder stringbuilder = new StringBuilder();
        for (list = list.iterator(); list.hasNext(); stringbuilder.append(((VersionHistoryEntry)list.next()).toString()).append("__")) { }
        context.edit().putString("versionHistory", stringbuilder.toString()).commit();
    }

    public static void updateVersionHistory(Context context, Integer integer, String s)
    {
        updateVersionHistory(context, integer, s, Util.currentTimeSeconds());
    }

    public static void updateVersionHistory(Context context, Integer integer, String s, double d)
    {
        Log.d("Updating version info: %d, %s @%f", new Object[] {
            integer, s, Double.valueOf(d)
        });
        List list = getVersionHistory(context);
        Iterator iterator = list.iterator();
        boolean flag = false;
        boolean flag1 = false;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            VersionHistoryEntry versionhistoryentry = (VersionHistoryEntry)iterator.next();
            if (integer.equals(versionhistoryentry.versionCode))
            {
                flag1 = true;
            }
            if (s.equals(versionhistoryentry.versionName))
            {
                flag = true;
            }
        } while (true);
        if (!flag1 || !flag)
        {
            list.add(new VersionHistoryEntry(Double.valueOf(d), integer, s));
            saveVersionHistory(context, list);
        }
    }

    private class VersionHistoryEntry
    {

        public Double seconds;
        public Integer versionCode;
        public String versionName;

        public String toString()
        {
            return (new StringBuilder()).append(String.valueOf(seconds)).append("--").append(String.valueOf(versionCode)).append("--").append(versionName).toString();
        }

        public VersionHistoryEntry(Double double1, Integer integer, String s)
        {
            seconds = double1;
            versionCode = integer;
            versionName = s;
        }

        public VersionHistoryEntry(String s)
        {
            if (s != null)
            {
                s = s.replace("__", "").split("--");
                seconds = Double.valueOf(s[0]);
                versionCode = Integer.valueOf(Integer.parseInt(s[1]));
                versionName = s[2];
            }
        }
    }


    private class _cls1
    {

        static final int $SwitchMap$com$apptentive$android$sdk$storage$VersionHistoryStore$Selector[];

        static 
        {
            $SwitchMap$com$apptentive$android$sdk$storage$VersionHistoryStore$Selector = new int[Selector.values().length];
            try
            {
                $SwitchMap$com$apptentive$android$sdk$storage$VersionHistoryStore$Selector[Selector.total.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                $SwitchMap$com$apptentive$android$sdk$storage$VersionHistoryStore$Selector[Selector.version.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                $SwitchMap$com$apptentive$android$sdk$storage$VersionHistoryStore$Selector[Selector.build.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }


    private class Selector extends Enum
    {

        private static final Selector $VALUES[];
        public static final Selector build;
        public static final Selector other;
        public static final Selector total;
        public static final Selector version;

        public static Selector parse(String s)
        {
            try
            {
                s = valueOf(s);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return other;
            }
            return s;
        }

        public static Selector valueOf(String s)
        {
            return (Selector)Enum.valueOf(com/apptentive/android/sdk/storage/VersionHistoryStore$Selector, s);
        }

        public static Selector[] values()
        {
            return (Selector[])$VALUES.clone();
        }

        static 
        {
            total = new Selector("total", 0);
            version = new Selector("version", 1);
            build = new Selector("build", 2);
            other = new Selector("other", 3);
            $VALUES = (new Selector[] {
                total, version, build, other
            });
        }

        private Selector(String s, int i)
        {
            super(s, i);
        }
    }

}
