// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.util;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import com.gotv.crackle.Application;
import com.gotv.crackle.DetailsActivityResolver;
import com.gotv.crackle.data.CrackleAccountManager;
import com.gotv.crackle.data.QueueManager;
import com.gotv.crackle.helpers.SharedPrefsManager;
import com.gotv.crackle.model.BrowseModel;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;

// Referenced classes of package com.gotv.crackle.util:
//            LocalNotificationManagerBase

public class LocalNotificationManager extends LocalNotificationManagerBase
    implements com.gotv.crackle.data.DataRequest.DataRequestListener
{

    private static int FORTYFIVE_DAY_NOTIFICATION_ID = 3;
    private static String LOCAL_NOTIFICATION_FLAGS = "NOTIFICATION_FLAGS";
    private static int RESUME_EXPIRING_MEDIA_NOTIFICATION_ID = 6;
    private static int RESUME_MEDIA_NOTIFICATION_ID = 5;
    private static int TEST_NOTIFICATION_ID = 1;
    private static int TW0_DAY_NOTIFICATION_ID = 2;
    private static String WATCHLIST_ALARM_IDS = "WATCHLIST_ALARM_IDS";
    private static int WATCHLIST_NOTIFICATION_ID = 4;
    private Context mContext;
    private QueueManager mWatchlistFeed;

    public LocalNotificationManager()
    {
    }

    private int createWatchlistAlert(Context context, String s, int i, int j)
    {
        if (j == 0)
        {
            s = String.format(context.getString(0x7f0b012e), new Object[] {
                s
            });
        } else
        if (j == 1)
        {
            s = String.format(context.getString(0x7f0b012f), new Object[] {
                s
            });
        } else
        {
            s = String.format(context.getString(0x7f0b0130), new Object[] {
                s, Integer.valueOf(j)
            });
        }
        return scheduleAlarm(context, getScheduleTimeInMs(i), WATCHLIST_NOTIFICATION_ID, j + 1, s, null);
    }

    private long getScheduleTimeInMs(int i)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.add(11, (i - 5) * 24);
        calendar.set(calendar.get(1), calendar.get(2), calendar.get(5), 12, 0, 0);
        return calendar.getTimeInMillis();
    }

    public int create2DayNotification(Context context)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.add(11, 48);
        String s = context.getString(0x7f0b0134);
        return scheduleAlarm(context, calendar.getTimeInMillis(), TW0_DAY_NOTIFICATION_ID, 0, s, null);
    }

    protected Class getAlarmReceiverClass()
    {
        return getClass();
    }

    protected int getIconResourceId()
    {
        return 0x7f0200df;
    }

    public void onDataFailed(String s, String s1)
    {
    }

    public void onDataSuccess(String s)
    {
        if (mWatchlistFeed.getItems() != null && mWatchlistFeed.getItems().size() > 0)
        {
            regenerateWatchlistAlerts(mContext, mWatchlistFeed.getItems());
        }
    }

    public void onReceive(Context context, Intent intent)
    {
        if (!SharedPrefsManager.getIsWatchlistNotificationEnabled()) goto _L2; else goto _L1
_L1:
        mContext = context;
        if (intent.getAction() == null) goto _L2; else goto _L3
_L3:
        Object obj;
        Object obj1;
        obj = Application.getInstance().getSharedPreferences(LOCAL_NOTIFICATION_FLAGS, 0);
        obj1 = (ConnectivityManager)context.getSystemService("connectivity");
        if (!intent.getAction().equalsIgnoreCase("android.intent.action.BOOT_COMPLETED")) goto _L5; else goto _L4
_L4:
        if (((ConnectivityManager) (obj1)).getActiveNetworkInfo() == null) goto _L7; else goto _L6
_L6:
        if (((ConnectivityManager) (obj1)).getActiveNetworkInfo().isConnected())
        {
            context = CrackleAccountManager.getUserID();
            if (context != null)
            {
                mWatchlistFeed = new QueueManager(this, context);
                mWatchlistFeed.getWatchList();
            }
        }
_L2:
        return;
_L7:
        context = ((SharedPreferences) (obj)).edit();
        context.putBoolean("shouldRefreshOnNetwork", true);
        context.commit();
        return;
_L5:
        if (!intent.getAction().equalsIgnoreCase("android.net.conn.CONNECTIVITY_CHANGE"))
        {
            continue; /* Loop/switch isn't completed */
        }
        if (((ConnectivityManager) (obj1)).getActiveNetworkInfo() == null || !((ConnectivityManager) (obj1)).getActiveNetworkInfo().isConnected() || !((SharedPreferences) (obj)).getBoolean("shouldRefreshOnNetwork", false)) goto _L2; else goto _L8
_L8:
        context = ((SharedPreferences) (obj)).edit();
        context.putBoolean("shouldRefreshOnNetwork", false);
        context.commit();
        context = CrackleAccountManager.getUserID();
        if (context == null) goto _L2; else goto _L9
_L9:
        mWatchlistFeed = new QueueManager(this, context);
        mWatchlistFeed.getWatchList();
        return;
        if (!intent.getAction().equalsIgnoreCase("com.notifications.ACTION_LOCAL_NOTIFICATION")) goto _L2; else goto _L10
_L10:
        int k;
        int l;
        obj1 = intent.getExtras();
        obj = ((Bundle) (obj1)).getString("message");
        l = ((Bundle) (obj1)).getInt("alarmTypeId");
        int i1 = ((Bundle) (obj1)).getInt("id");
        k = ((Bundle) (obj1)).getInt("count");
        if (l == 5 || l == 6)
        {
            intent = new Intent(context, com/gotv/crackle/DetailsActivityResolver);
            intent.putExtras(((Bundle) (obj1)));
        } else
        {
            intent = context.getPackageManager().getLaunchIntentForPackage(context.getApplicationContext().getPackageName());
        }
        if (l == TEST_NOTIFICATION_ID)
        {
            obj1 = new ArrayList();
            for (int i = 0; i < k; i++)
            {
                ((List) (obj1)).add((new StringBuilder()).append(((String) (obj))).append(" ").append(i).toString());
            }

            createStackedInboxNotification(context, i1, k, ((String) (obj)), ((List) (obj1)), intent);
            return;
        }
        if (l != WATCHLIST_NOTIFICATION_ID)
        {
            break MISSING_BLOCK_LABEL_535;
        }
        obj1 = Application.getInstance().getSharedPreferences(WATCHLIST_ALARM_IDS, 0).getString((new StringBuilder()).append(i1).append("").toString(), null);
        if (obj1 == null) goto _L2; else goto _L11
_L11:
        ArrayList arraylist;
        obj1 = new JSONArray(((String) (obj1)));
        arraylist = new ArrayList();
        int j = 0;
_L13:
        if (j >= ((JSONArray) (obj1)).length())
        {
            break; /* Loop/switch isn't completed */
        }
        arraylist.add(((JSONArray) (obj1)).getString(j));
        j++;
        if (true) goto _L13; else goto _L12
_L12:
        try
        {
            createStackedInboxNotification(context, l, k, ((String) (obj)), arraylist, intent);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
        }
        return;
        createNotification(context, l, k, ((String) (obj)), intent);
        return;
    }

    public void regenerateWatchlistAlerts(Context context, List list)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        SharedPreferences sharedpreferences;
        sharedpreferences = Application.getInstance().getSharedPreferences(WATCHLIST_ALARM_IDS, 0);
        obj = sharedpreferences.edit();
        for (Iterator iterator1 = sharedpreferences.getAll().keySet().iterator(); iterator1.hasNext(); cancelAlarm(context, Integer.parseInt((String)iterator1.next()))) { }
        break MISSING_BLOCK_LABEL_77;
        context;
        throw context;
        Iterator iterator2;
        ((android.content.SharedPreferences.Editor) (obj)).clear();
        ((android.content.SharedPreferences.Editor) (obj)).commit();
        obj = new HashMap();
        iterator2 = list.iterator();
_L1:
        BrowseModel browsemodel;
        int i;
        do
        {
            do
            {
                if (!iterator2.hasNext())
                {
                    break MISSING_BLOCK_LABEL_221;
                }
                browsemodel = (BrowseModel)iterator2.next();
            } while (browsemodel.getExpiresInDays() == null);
            i = browsemodel.getExpiresInDays().intValue();
        } while (i <= 5);
        if (!((Map) (obj)).containsKey(Integer.valueOf(i)))
        {
            break MISSING_BLOCK_LABEL_210;
        }
        list = (List)((Map) (obj)).get(Integer.valueOf(i));
_L2:
        list.add(browsemodel.getTitle());
        ((Map) (obj)).put(Integer.valueOf(i), list);
          goto _L1
        list = new ArrayList();
          goto _L2
        list = sharedpreferences.edit();
        List list1;
        int j;
        for (Iterator iterator = ((Map) (obj)).keySet().iterator(); iterator.hasNext(); list.putString((new StringBuilder()).append(j).append("").toString(), (new JSONArray(list1)).toString()))
        {
            Integer integer = (Integer)iterator.next();
            list1 = (List)((Map) (obj)).get(integer);
            j = createWatchlistAlert(context, (String)list1.get(0), integer.intValue(), list1.size() - 1);
        }

        list.commit();
        this;
        JVM INSTR monitorexit ;
    }

    public void reset45dayNotification(Context context)
    {
        SharedPreferences sharedpreferences = Application.getInstance().getSharedPreferences(LOCAL_NOTIFICATION_FLAGS, 0);
        int i = sharedpreferences.getInt("fortyFiveDayId", 0);
        if (i != 0)
        {
            cancelAlarm(context, i);
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.add(11, 1080);
        String s = context.getString(0x7f0b0135);
        i = scheduleAlarm(context, calendar.getTimeInMillis(), FORTYFIVE_DAY_NOTIFICATION_ID, 0, s, null);
        context = sharedpreferences.edit();
        context.putInt("fortyFiveDayId", i);
        context.commit();
    }

    public void resetResumeExpiringMediaNotification(Context context, String s, String s1, String s2, int i)
    {
        SharedPreferences sharedpreferences = Application.getInstance().getSharedPreferences(LOCAL_NOTIFICATION_FLAGS, 0);
        int j = sharedpreferences.getInt("resumeExpiringMediaId", 0);
        if (j != 0)
        {
            cancelAlarm(context, j);
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.add(11, 72);
        Object obj = context.getString(0x7f0b0137);
        s = (new StringBuilder()).append(((String) (obj))).append(" \"").append(s).append("\" which will expire ").toString();
        if (i > 0)
        {
            s = (new StringBuilder()).append(s).append("in ").append(i).append(" day(s)!").toString();
        } else
        {
            s = (new StringBuilder()).append(s).append("today!").toString();
        }
        obj = new Bundle();
        ((Bundle) (obj)).putString("MEDIA_ITEM_ID", s1);
        ((Bundle) (obj)).putString("ID", s2);
        ((Bundle) (obj)).putBoolean("START_PLAYING", true);
        i = scheduleAlarm(context, calendar.getTimeInMillis(), RESUME_EXPIRING_MEDIA_NOTIFICATION_ID, 0, s, ((Bundle) (obj)));
        context = sharedpreferences.edit();
        context.putInt("resumeExpiringMediaId", i);
        context.commit();
    }

    public void resetResumeMediaNotification(Context context, String s, String s1, String s2)
    {
        SharedPreferences sharedpreferences = Application.getInstance().getSharedPreferences(LOCAL_NOTIFICATION_FLAGS, 0);
        int i = sharedpreferences.getInt("resumeMediaId", 0);
        if (i != 0)
        {
            cancelAlarm(context, i);
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.add(11, 168);
        Object obj = context.getString(0x7f0b0136);
        s = (new StringBuilder()).append(((String) (obj))).append(" \"").append(s).append("\"?").toString();
        obj = new Bundle();
        ((Bundle) (obj)).putString("MEDIA_ITEM_ID", s1);
        ((Bundle) (obj)).putString("ID", s2);
        ((Bundle) (obj)).putBoolean("START_PLAYING", true);
        i = scheduleAlarm(context, calendar.getTimeInMillis(), RESUME_MEDIA_NOTIFICATION_ID, 0, s, ((Bundle) (obj)));
        context = sharedpreferences.edit();
        context.putInt("resumeMediaId", i);
        context.commit();
    }

    public void testAlarmNotification(Context context)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        scheduleAlarm(context, 30000L + calendar.getTimeInMillis(), TEST_NOTIFICATION_ID, 4, "TESING123", null);
    }

}
