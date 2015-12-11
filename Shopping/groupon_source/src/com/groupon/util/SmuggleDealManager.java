// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import com.groupon.Channel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.groupon.util:
//            ArraySharedPreferences, RuntimeIOException

public class SmuggleDealManager
{
    public static final class SharedPrefKey extends Enum
    {

        private static final SharedPrefKey $VALUES[];
        public static final SharedPrefKey LAST_SMUGGLE_TIMESTAMP_ON_CHANNEL;
        public static final SharedPrefKey SMUGGLED_DEALS_ON_CHANNEL;
        private final String template;

        public static SharedPrefKey valueOf(String s)
        {
            return (SharedPrefKey)Enum.valueOf(com/groupon/util/SmuggleDealManager$SharedPrefKey, s);
        }

        public static SharedPrefKey[] values()
        {
            return (SharedPrefKey[])$VALUES.clone();
        }

        public String format(String s)
        {
            return String.format(template, new Object[] {
                s
            });
        }

        static 
        {
            LAST_SMUGGLE_TIMESTAMP_ON_CHANNEL = new SharedPrefKey("LAST_SMUGGLE_TIMESTAMP_ON_CHANNEL", 0, "last_smuggle_timestamp_on_%s");
            SMUGGLED_DEALS_ON_CHANNEL = new SharedPrefKey("SMUGGLED_DEALS_ON_CHANNEL", 1, "smuggled_deals_on_%s");
            $VALUES = (new SharedPrefKey[] {
                LAST_SMUGGLE_TIMESTAMP_ON_CHANNEL, SMUGGLED_DEALS_ON_CHANNEL
            });
        }

        private SharedPrefKey(String s, int i, String s1)
        {
            super(s, i);
            template = s1;
        }
    }


    public static final String SMUGGLED_DEALS = "smuggledDeals";
    private ArraySharedPreferences prefs;

    public SmuggleDealManager()
    {
    }

    private void clearSecretScreenSmuggledDeal()
    {
        prefs.edit().remove("smuggledDeals").apply();
    }

    private Set getSecretScreenSmuggledDealIdSet()
    {
        LinkedHashSet linkedhashset = new LinkedHashSet();
        String s = prefs.getString("smuggledDeals", null);
        if (s != null)
        {
            linkedhashset.addAll(Arrays.asList(s.split(",")));
        }
        return linkedhashset;
    }

    private long startOfTodayTimestamp()
    {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    public void addDealsToBeSmuggled(List list, String s)
    {
        String s1;
        String s2;
        long l1;
        s1 = SharedPrefKey.LAST_SMUGGLE_TIMESTAMP_ON_CHANNEL.format(s);
        s2 = SharedPrefKey.SMUGGLED_DEALS_ON_CHANNEL.format(s);
        long l = prefs.getLong(s1, -1L);
        l1 = startOfTodayTimestamp();
        if (l1 != l)
        {
            break MISSING_BLOCK_LABEL_133;
        }
        s = prefs.getListString(s2, null);
_L1:
        LinkedHashSet linkedhashset = new LinkedHashSet(list);
        boolean flag;
        if (!linkedhashset.addAll(s) && (!s.isEmpty() || list.isEmpty()))
        {
            flag = false;
        } else
        {
            flag = true;
        }
        if (flag)
        {
            try
            {
                prefs.edit().putLong(s1, l1).putListString(s2, new ArrayList(linkedhashset)).apply();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (List list)
            {
                throw new RuntimeIOException(list);
            }
        } else
        {
            return;
        }
        s = new ArrayList();
          goto _L1
    }

    public void clearSmuggledDeals()
    {
        ArraySharedPreferences.Editor editor = prefs.edit();
        Channel achannel[] = Channel.values();
        int j = achannel.length;
        for (int i = 0; i < j; i++)
        {
            Object obj = achannel[i];
            if (((Channel) (obj)).isNavigableTo())
            {
                String s = SharedPrefKey.LAST_SMUGGLE_TIMESTAMP_ON_CHANNEL.format(((Channel) (obj)).name());
                obj = SharedPrefKey.SMUGGLED_DEALS_ON_CHANNEL.format(((Channel) (obj)).name());
                editor.remove(s);
                editor.remove(((String) (obj)));
            }
        }

        editor.apply();
        clearSecretScreenSmuggledDeal();
    }

    public Set getDealIdsToBeSmuggled(String s)
    {
        String s1 = SharedPrefKey.LAST_SMUGGLE_TIMESTAMP_ON_CHANNEL.format(s);
        s = SharedPrefKey.SMUGGLED_DEALS_ON_CHANNEL.format(s);
        if (prefs.getLong(s1, -1L) != startOfTodayTimestamp())
        {
            break MISSING_BLOCK_LABEL_67;
        }
        s = prefs.getListString(s, null);
_L1:
        s = new LinkedHashSet(s);
        s.addAll(getSecretScreenSmuggledDealIdSet());
        return s;
        try
        {
            s = new ArrayList();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeIOException(s);
        }
          goto _L1
    }
}
