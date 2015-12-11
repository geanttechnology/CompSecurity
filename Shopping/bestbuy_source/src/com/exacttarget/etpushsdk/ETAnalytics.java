// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.exacttarget.etpushsdk.data.AnalyticItem;
import com.exacttarget.etpushsdk.database.a;
import com.exacttarget.etpushsdk.event.AnalyticItemEvent;
import com.exacttarget.etpushsdk.event.AnalyticItemEventListener;
import com.exacttarget.etpushsdk.event.AnalyticPiItemEvent;
import com.exacttarget.etpushsdk.event.BackgroundEvent;
import com.exacttarget.etpushsdk.event.BackgroundEventListener;
import com.exacttarget.etpushsdk.util.EventBus;
import com.exacttarget.etpushsdk.util.d;
import com.exacttarget.etpushsdk.util.m;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.exacttarget.etpushsdk:
//            ETException, ETPushReceiver

public class ETAnalytics
    implements AnalyticItemEventListener, BackgroundEventListener
{

    private static ETAnalytics a;
    private Context b;

    private ETAnalytics(Context context)
    {
        b = context;
        EventBus.getInstance().register(this);
    }

    public static ETAnalytics a()
    {
        if (com.exacttarget.etpushsdk.util.d.f() | com.exacttarget.etpushsdk.util.d.g())
        {
            if (a == null)
            {
                throw new ETException("You forgot to call readyAimFire first.");
            } else
            {
                return a;
            }
        } else
        {
            throw new ETException("Analytics are disabled.");
        }
    }

    protected static void a(Context context)
    {
        if (a == null)
        {
            m.a("~!ETAnalytics", "readyAimFire()");
            a = new ETAnalytics(context);
            return;
        } else
        {
            throw new ETException("You must have called readyAimFire more than once.");
        }
    }

    private boolean d()
    {
        List list = com.exacttarget.etpushsdk.database.a.a("pi_app_key IS NULL AND analytic_types LIKE ? AND value IS NULL", new String[] {
            "%4%"
        }, null, null, "id ASC ");
        int i;
        boolean flag;
        if (list.size() > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        try
        {
            m.a("~!ETAnalytics", String.format("isCountingTimeInApp: %1$s", new Object[] {
                Boolean.valueOf(flag)
            }));
            i = list.size();
        }
        catch (Exception exception)
        {
            m.c("~!ETAnalytics", exception.getMessage(), exception);
            return false;
        }
        return i > 0;
    }

    protected void a(long l)
    {
        l = System.currentTimeMillis() - l;
        Exception exception;
        AnalyticItem analyticitem;
        for (Iterator iterator = com.exacttarget.etpushsdk.database.a.a("pi_app_key IS NULL AND analytic_types LIKE ? AND value IS NULL", new String[] {
    "%4%"
}, null, null, "id ASC ").iterator(); iterator.hasNext(); com.exacttarget.etpushsdk.database.a.b(analyticitem))
        {
            analyticitem = (AnalyticItem)iterator.next();
            int i = (int)((l - analyticitem.getEventDate().getTime()) / 1000L);
            m.a("~!ETAnalytics", (new StringBuilder()).append("ET Time in app was ").append(i).append(" seconds").toString());
            analyticitem.setValue(Integer.valueOf(i));
            analyticitem.setReadyToSend(Boolean.TRUE);
        }

          goto _L1
_L3:
        return;
_L1:
        try
        {
            Iterator iterator1 = com.exacttarget.etpushsdk.database.a.a("pi_app_key IS NOT NULL AND analytic_types LIKE ? AND value IS NULL", new String[] {
                "%5%"
            }, null, null, "id ASC ").iterator();
            while (iterator1.hasNext()) 
            {
                AnalyticItem analyticitem1 = (AnalyticItem)iterator1.next();
                int j = (int)((l - analyticitem1.getEventDate().getTime()) / 1000L);
                m.a("~!ETAnalytics", (new StringBuilder()).append("PI Time in app was ").append(j).append(" seconds").toString());
                analyticitem1.setValue(Integer.valueOf(j));
                analyticitem1.setReadyToSend(Boolean.TRUE);
                com.exacttarget.etpushsdk.database.a.b(analyticitem1);
            }
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception)
        {
            m.c("~!ETAnalytics", exception.getMessage(), exception);
        }
        if (true) goto _L3; else goto _L2
_L2:
    }

    protected void a(String s)
    {
        long l = System.currentTimeMillis();
        Object obj = com.exacttarget.etpushsdk.database.a.a("object_ids LIKE ? AND value IS NULL", new String[] {
            (new StringBuilder()).append("%").append(s).append("%").toString()
        }, null, null, null);
        if (obj != null)
        {
            try
            {
                if (((List) (obj)).size() > 0)
                {
                    AnalyticItem analyticitem;
                    for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); com.exacttarget.etpushsdk.database.a.b(analyticitem))
                    {
                        analyticitem = (AnalyticItem)((Iterator) (obj)).next();
                        int i = (int)((l - analyticitem.getEventDate().getTime()) / 1000L);
                        m.a("~!ETAnalytics", (new StringBuilder()).append("Time in region: ").append(s).append(" was ").append(i).append(" seconds").toString());
                        analyticitem.setValue(Integer.valueOf(i));
                        analyticitem.setReadyToSend(Boolean.TRUE);
                    }

                }
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                m.c("~!ETAnalytics", s.getMessage(), s);
            }
        }
        return;
    }

    protected void a(String s, int i, int j, List list)
    {
        AnalyticItem analyticitem;
        try
        {
            analyticitem = new AnalyticItem(b);
            analyticitem.setEventDate(new Date());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            m.c("~!ETAnalytics", s.getMessage(), s);
            return;
        }
        if (i != 1) goto _L2; else goto _L1
_L1:
        analyticitem.a(6);
        analyticitem.a(s);
_L3:
        analyticitem.a(3);
        for (s = list.iterator(); s.hasNext(); analyticitem.a((String)s.next())) { }
        break MISSING_BLOCK_LABEL_133;
_L2:
        if (i != 2)
        {
            break MISSING_BLOCK_LABEL_117;
        }
        analyticitem.a(7);
        analyticitem.a(s);
          goto _L3
        analyticitem.a(12);
        analyticitem.a(s);
          goto _L3
        analyticitem.setReadyToSend(Boolean.TRUE);
        com.exacttarget.etpushsdk.database.a.a(analyticitem);
        return;
    }

    protected void a(String s, boolean flag)
    {
        AnalyticItem analyticitem;
        try
        {
            analyticitem = new AnalyticItem(b);
            analyticitem.setEventDate(new Date());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            m.c("~!ETAnalytics", s.getMessage(), s);
            return;
        }
        if (flag)
        {
            break MISSING_BLOCK_LABEL_43;
        }
        analyticitem.a(11);
_L2:
        analyticitem.a(s);
        com.exacttarget.etpushsdk.database.a.a(analyticitem);
        return;
        analyticitem.a(13);
        if (true) goto _L2; else goto _L1
_L1:
    }

    protected void b(String s)
    {
        try
        {
            AnalyticItem analyticitem = new AnalyticItem(b);
            analyticitem.setEventDate(new Date());
            analyticitem.a(10);
            analyticitem.a(s);
            analyticitem.setReadyToSend(Boolean.TRUE);
            com.exacttarget.etpushsdk.database.a.a(analyticitem);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            m.c("~!ETAnalytics", s.getMessage(), s);
        }
    }

    protected boolean b()
    {
        long l;
        boolean flag1;
        boolean flag2;
        flag2 = false;
        flag1 = false;
        l = System.currentTimeMillis();
        Object obj = com.exacttarget.etpushsdk.database.a.a("analytic_types LIKE ? AND ready_to_send = ? ", new String[] {
            (new StringBuilder()).append("%").append(String.valueOf(11)).append("%").toString(), "0"
        }, null, null, null);
        boolean flag = flag2;
        if (obj == null) goto _L2; else goto _L1
_L1:
        flag = flag2;
        if (((List) (obj)).size() <= 0) goto _L2; else goto _L3
_L3:
        m.a("~!ETAnalytics", String.format("There are %d geofences currently being tracked", new Object[] {
            Integer.valueOf(((List) (obj)).size())
        }));
        AnalyticItem analyticitem;
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); com.exacttarget.etpushsdk.database.a.b(analyticitem))
        {
            analyticitem = (AnalyticItem)((Iterator) (obj)).next();
            analyticitem.setValue(Integer.valueOf((int)((l - analyticitem.getEventDate().getTime()) / 1000L)));
            analyticitem.setReadyToSend(Boolean.TRUE);
        }

          goto _L4
        Exception exception;
        exception;
        flag = true;
_L5:
        m.c("~!ETAnalytics", exception.getMessage(), exception);
_L2:
        return flag;
        exception;
        flag = flag1;
        if (true) goto _L5; else goto _L4
_L4:
        return true;
    }

    protected boolean c()
    {
        long l;
        boolean flag1;
        boolean flag2;
        flag2 = false;
        flag1 = false;
        l = System.currentTimeMillis();
        Object obj = com.exacttarget.etpushsdk.database.a.a("analytic_types LIKE ? AND ready_to_send = ? ", new String[] {
            (new StringBuilder()).append("%").append(String.valueOf(13)).append("%").toString(), "0"
        }, null, null, null);
        boolean flag = flag2;
        if (obj == null) goto _L2; else goto _L1
_L1:
        flag = flag2;
        if (((List) (obj)).size() <= 0) goto _L2; else goto _L3
_L3:
        m.a("~!ETAnalytics", String.format("There are %d beacons currently being tracked", new Object[] {
            Integer.valueOf(((List) (obj)).size())
        }));
        AnalyticItem analyticitem;
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); com.exacttarget.etpushsdk.database.a.b(analyticitem))
        {
            analyticitem = (AnalyticItem)((Iterator) (obj)).next();
            analyticitem.setValue(Integer.valueOf((int)((l - analyticitem.getEventDate().getTime()) / 1000L)));
            analyticitem.setReadyToSend(Boolean.TRUE);
        }

          goto _L4
        Exception exception;
        exception;
        flag = true;
_L5:
        m.c("~!ETAnalytics", exception.getMessage(), exception);
_L2:
        return flag;
        exception;
        flag = flag1;
        if (true) goto _L5; else goto _L4
_L4:
        return true;
    }

    public void onEvent(AnalyticItemEvent analyticitemevent)
    {
        AnalyticItem analyticitem;
        try
        {
            if (analyticitemevent.getDatabaseIds() != null && analyticitemevent.getDatabaseIds().size() > 0)
            {
                int i = com.exacttarget.etpushsdk.database.a.a(analyticitemevent.getDatabaseIds());
                m.d("~!ETAnalytics", (new StringBuilder()).append("Error: analytic_item rows deleted = ").append(i).toString());
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (AnalyticItemEvent analyticitemevent)
        {
            m.c("~!ETAnalytics", analyticitemevent.getMessage(), analyticitemevent);
            return;
        }
        analyticitemevent = analyticitemevent.iterator();
_L3:
        if (!analyticitemevent.hasNext())
        {
            break MISSING_BLOCK_LABEL_204;
        }
        analyticitem = (AnalyticItem)analyticitemevent.next();
        if (analyticitem.getId() != null) goto _L2; else goto _L1
_L1:
        m.d("~!ETAnalytics", (new StringBuilder()).append("Error, AnalyticItem had no ID: ").append(analyticitem.toString()).toString());
          goto _L3
_L2:
        int j = com.exacttarget.etpushsdk.database.a.a(analyticitem.getId().intValue());
        if (j != 1)
        {
            break MISSING_BLOCK_LABEL_175;
        }
        m.a("~!ETAnalytics", (new StringBuilder()).append("removed analytic_item types: ").append(analyticitem.getAnalyticTypes()).toString());
          goto _L3
        m.d("~!ETAnalytics", (new StringBuilder()).append("Error: rowsUpdated = ").append(j).toString());
          goto _L3
    }

    public void onEvent(AnalyticPiItemEvent analyticpiitemevent)
    {
        int i;
        com.exacttarget.etpushsdk.util.d.a(b, "et_user_id_cache", analyticpiitemevent.getUserId());
        com.exacttarget.etpushsdk.util.d.a(b, "et_session_id_cache", analyticpiitemevent.getSessionId());
        if (analyticpiitemevent.getDatabaseIds() == null || analyticpiitemevent.getDatabaseIds().size() <= 0)
        {
            break MISSING_BLOCK_LABEL_152;
        }
        i = com.exacttarget.etpushsdk.database.a.a(analyticpiitemevent.getDatabaseIds());
        if (i == analyticpiitemevent.getDatabaseIds().size())
        {
            m.a("~!ETAnalytics", (new StringBuilder()).append("pi_analytic_item rows deleted = ").append(i).toString());
            return;
        }
        try
        {
            m.d("~!ETAnalytics", (new StringBuilder()).append("Error: mis-match on pi_analytic_item rows deleted.  rows deleted:").append(i).append(" expected: ").append(analyticpiitemevent.getDatabaseIds().size()).toString());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (AnalyticPiItemEvent analyticpiitemevent)
        {
            m.c("~!ETAnalytics", analyticpiitemevent.getMessage(), analyticpiitemevent);
        }
    }

    public void onEvent(BackgroundEvent backgroundevent)
    {
        if (com.exacttarget.etpushsdk.util.d.f() | com.exacttarget.etpushsdk.util.d.g())
        {
            if (backgroundevent.isInBackground())
            {
                m.a("~!ETAnalytics", "App is now in background.");
                long l = System.currentTimeMillis();
                m.a("~!ETAnalytics", (new StringBuilder()).append("Save background time: ").append(l).toString());
                com.exacttarget.etpushsdk.util.d.a(b, "et_background_time_cache", Long.valueOf(l));
                if (backgroundevent.getTimeWentInBackground() != -1L)
                {
                    a(System.currentTimeMillis() - backgroundevent.getTimeWentInBackground());
                } else
                {
                    a(0L);
                }
                if (com.exacttarget.etpushsdk.util.d.f())
                {
                    backgroundevent = new Intent(b, com/exacttarget/etpushsdk/ETPushReceiver);
                    backgroundevent.putExtra("et_send_type_extra", "et_send_type_analytic_events");
                    b.sendBroadcast(backgroundevent);
                }
                if (com.exacttarget.etpushsdk.util.d.g())
                {
                    backgroundevent = new Intent(b, com/exacttarget/etpushsdk/ETPushReceiver);
                    backgroundevent.putExtra("et_send_type_extra", "pi_send_type_analytic_events");
                    b.sendBroadcast(backgroundevent);
                }
            } else
            {
                m.a("~!ETAnalytics", "App is now in foreground.");
                long l1 = ((Long)com.exacttarget.etpushsdk.util.d.a(b, "et_background_time_cache", Long.valueOf(-1L), new Object[0])).longValue();
                if (l1 != -1L)
                {
                    m.a("~!ETAnalytics", (new StringBuilder()).append("Found background time.  Checking if app has been in background for over 30 minutes: ").append(l1).toString());
                    backgroundevent = b.getSharedPreferences("ETPush", 0).edit();
                    backgroundevent.remove(com.exacttarget.etpushsdk.util.d.d("et_background_time_cache"));
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTimeInMillis(l1);
                    Calendar calendar1 = Calendar.getInstance();
                    calendar1.add(12, -30);
                    m.a("~!ETAnalytics", String.format("timeWentInBackground: %d and thirtyMinsAgo: %d", new Object[] {
                        Long.valueOf(calendar.getTimeInMillis()), Long.valueOf(calendar1.getTimeInMillis())
                    }));
                    if (calendar.before(calendar1))
                    {
                        m.a("~!ETAnalytics", "App has been in background for more than 30 minutes, so reset PI session Id.");
                        backgroundevent.remove(com.exacttarget.etpushsdk.util.d.d("et_session_id_cache"));
                    }
                    backgroundevent.commit();
                }
                if (!d())
                {
                    m.a("~!ETAnalytics", "Not counting time in App, so start a new counter.");
                    try
                    {
                        backgroundevent = new Date();
                        if (com.exacttarget.etpushsdk.util.d.f())
                        {
                            AnalyticItem analyticitem = new AnalyticItem(b);
                            analyticitem.setEventDate(backgroundevent);
                            analyticitem.a(4);
                            com.exacttarget.etpushsdk.database.a.a(analyticitem);
                            m.a("~!ETAnalytics", (new StringBuilder()).append("Added new ET analytic item: ").append(analyticitem.getId()).toString());
                        }
                        if (com.exacttarget.etpushsdk.util.d.g())
                        {
                            AnalyticItem analyticitem1 = new AnalyticItem(b);
                            analyticitem1.setEventDate(backgroundevent);
                            analyticitem1.a(5);
                            analyticitem1.setPiAppKey("849f26e2-2df6-11e4-ab12-14109fdc48df");
                            com.exacttarget.etpushsdk.database.a.a(analyticitem1);
                            m.a("~!ETAnalytics", (new StringBuilder()).append("Added new PI analytic item: ").append(analyticitem1.getId()).toString());
                            return;
                        }
                    }
                    // Misplaced declaration of an exception variable
                    catch (BackgroundEvent backgroundevent)
                    {
                        m.c("~!ETAnalytics", backgroundevent.getMessage(), backgroundevent);
                        return;
                    }
                }
            }
        }
    }
}
