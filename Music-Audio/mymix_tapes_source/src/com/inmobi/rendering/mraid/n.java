// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.rendering.mraid;

import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Vibrator;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.inmobi.commons.a.a;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.rendering.InMobiAdActivity;
import com.inmobi.rendering.RenderView;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.GregorianCalendar;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inmobi.rendering.mraid:
//            a

public class n
{
    static final class a extends Handler
    {

        private static final String a = com/inmobi/rendering/mraid/n$a.getSimpleName();
        private WeakReference b;

        public void handleMessage(Message message)
        {
            message.what;
            JVM INSTR tableswitch 1 1: default 24
        //                       1 36;
               goto _L1 _L2
_L1:
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Unknown message type. Ignoring ...");
_L4:
            return;
_L2:
            message = (String)message.obj;
            RenderView renderview = (RenderView)b.get();
            if (renderview != null)
            {
                renderview.a(message, "broadcastEvent('vibrateComplete');");
                return;
            }
            if (true) goto _L4; else goto _L3
_L3:
        }


        public a(Looper looper, RenderView renderview)
        {
            super(looper);
            b = new WeakReference(renderview);
        }
    }


    private static final String a = com/inmobi/rendering/mraid/n.getSimpleName();
    private RenderView b;
    private a c;

    public n(RenderView renderview)
    {
        b = renderview;
        HandlerThread handlerthread = new HandlerThread("SystemTasksHandlerThread");
        handlerthread.start();
        c = new a(handlerthread.getLooper(), renderview);
    }

    static RenderView a(n n1)
    {
        return n1.b;
    }

    static String a()
    {
        return a;
    }

    private String a(String s)
    {
        StringBuilder stringbuilder = new StringBuilder();
        if (s.length() == 0)
        {
            break MISSING_BLOCK_LABEL_477;
        }
        String s1;
        String s2;
        try
        {
            s = new JSONObject(s);
            s1 = s.optString("frequency");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, (new StringBuilder()).append("Error Parsing recurrence string").append(s.toString()).toString());
            return "";
        }
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_428;
        }
        if ("".equals(s1))
        {
            break MISSING_BLOCK_LABEL_428;
        }
        if (!"daily".equals(s1) && !"weekly".equals(s1) && !"monthly".equals(s1) && !"yearly".equals(s1))
        {
            break MISSING_BLOCK_LABEL_414;
        }
        stringbuilder.append("freq=").append(s1).append(";");
        s2 = s.optString("interval");
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_139;
        }
        if (!"".equals(s2))
        {
            stringbuilder.append("interval=").append(Integer.parseInt(s2)).append(";");
        }
        s2 = com.inmobi.rendering.mraid.a.a(s.optString("expires"));
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_186;
        }
        stringbuilder.append("until=").append(s2.replace("+", "Z+").replace("-", "Z-")).append(";");
        if (!s1.equals("weekly"))
        {
            break MISSING_BLOCK_LABEL_228;
        }
        s2 = com.inmobi.rendering.mraid.a.a(s.optJSONArray("daysInWeek"));
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_228;
        }
        stringbuilder.append("byday=").append(s2).append(";");
        if (!s1.equals("monthly"))
        {
            break MISSING_BLOCK_LABEL_274;
        }
        s2 = com.inmobi.rendering.mraid.a.a(s.optJSONArray("daysInMonth"), -31, 31);
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_274;
        }
        stringbuilder.append("bymonthday=").append(s2).append(";");
        if (!s1.equals("yearly"))
        {
            break MISSING_BLOCK_LABEL_322;
        }
        s2 = com.inmobi.rendering.mraid.a.a(s.optJSONArray("daysInYear"), -366, 366);
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_322;
        }
        stringbuilder.append("byyearday=").append(s2).append(";");
        if (!s1.equals("monthly"))
        {
            break MISSING_BLOCK_LABEL_367;
        }
        s2 = com.inmobi.rendering.mraid.a.a(s.optJSONArray("weeksInMonth"), -4, 4);
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_367;
        }
        stringbuilder.append("byweekno=").append(s2).append(";");
        if (!s1.equals("yearly"))
        {
            break MISSING_BLOCK_LABEL_409;
        }
        s = com.inmobi.rendering.mraid.a.a(s.optJSONArray("monthsInYear"), 1, 12);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_409;
        }
        stringbuilder.append("bymonth=").append(s).append(";");
        return stringbuilder.toString();
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Error Parsing recurrence string. Invalid Frequency supplied");
        return "";
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Error Parsing recurrence string. Frequency supplied is null");
        return "";
        return "";
    }

    private void a(Context context, int i, String s, String s1, String s2)
    {
        Object obj;
        String s3;
        s3 = (new StringBuilder()).append(s).append(" ").append(s1).append(" ").append(s2).toString();
        obj = null;
        i;
        JVM INSTR tableswitch 1 3: default 68
    //                   1 103
    //                   2 176
    //                   3 205;
           goto _L1 _L2 _L3 _L4
_L4:
        break MISSING_BLOCK_LABEL_205;
_L1:
        s = obj;
_L5:
        if (s != null)
        {
            s1 = new Intent("android.intent.action.VIEW");
            s1.setData(Uri.parse(s));
            try
            {
                context.startActivity(s1);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, context.getMessage());
            }
            return;
        } else
        {
            s = new Intent();
            s.setType("text/plain");
            s.putExtra("android.intent.extra.TEXT", s3);
            try
            {
                context.startActivity(s);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, context.getMessage());
            }
            return;
        }
_L2:
        try
        {
            s = (new StringBuilder()).append("https://www.facebook.com/dialog/feed?app_id=181821551957328&link=").append(URLEncoder.encode(s1, "UTF-8")).append("&picture=").append(URLEncoder.encode(s2, "UTF-8")).append("&name=&description=").append(URLEncoder.encode(s, "UTF-8")).append("&redirect_uri=").append(URLEncoder.encode(s1, "UTF-8")).toString();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
          goto _L5
_L3:
        s = (new StringBuilder()).append("https://m.google.com/app/plus/x/?v=compose&content=").append(URLEncoder.encode(s3, "UTF-8")).toString();
          goto _L5
        s = (new StringBuilder()).append("http://twitter.com/home?status=").append(URLEncoder.encode(s3, "UTF-8")).toString();
          goto _L5
    }

    private boolean b()
    {
        boolean flag = false;
        int i;
        try
        {
            i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(com.inmobi.commons.a.a.b());
        }
        catch (NoClassDefFoundError noclassdeffounderror)
        {
            noclassdeffounderror.printStackTrace();
            return false;
        }
        if (i == 0)
        {
            flag = true;
        }
        return flag;
    }

    public void a(Context context)
    {
        if (c != null && c.hasMessages(1))
        {
            c.removeMessages(1);
            ((Vibrator)context.getSystemService("vibrator")).cancel();
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Canceling any pending/ongoing vibrate requests");
        }
    }

    public void a(String s, Context context)
    {
        ((Vibrator)context.getSystemService("vibrator")).vibrate(2000L);
        context = Message.obtain();
        context.what = 1;
        context.obj = s;
        c.sendMessageDelayed(context, 2000L);
    }

    public void a(String s, Context context, int i, String s1, String s2, String s3)
    {
        Object obj;
        if (s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0 || !s2.startsWith("http") || s3 == null || s3.length() == 0 || !s3.startsWith("http") || !s3.endsWith(".jpg"))
        {
            b.a(s, "Attempting to share with null/empty/invalid parameters", "postToSocial");
            return;
        }
        obj = null;
        i;
        JVM INSTR tableswitch 1 3: default 116
    //                   1 131
    //                   2 158
    //                   3 236;
           goto _L1 _L2 _L3 _L4
_L4:
        break MISSING_BLOCK_LABEL_236;
_L1:
        b.a(s, "Unsupported type of social network", "postToSocial");
        return;
_L2:
        s = obj;
_L5:
        if (s != null)
        {
            try
            {
                context.startActivity(s);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                a(context, i, s1, s2, s3);
            }
            return;
        } else
        {
            a(context, i, s1, s2, s3);
            return;
        }
_L3:
        s = obj;
        if (b())
        {
            s = (new StringBuilder()).append(s1).append(" ").append(s2).append(" ").append(s3).toString();
            s = (new com.google.android.gms.plus.PlusShare.Builder(context)).setType("text/plain").setText(s).setContentUrl(Uri.parse(s3)).getIntent();
        }
          goto _L5
        String s4 = (new StringBuilder()).append(s1).append(" ").append(s2).append(" ").append(s3).toString();
        s = new Intent();
        s.setType("text/plain");
        s.setPackage("com.twitter.android");
        s.putExtra("android.intent.extra.TEXT", s4);
          goto _L5
    }

    public void a(String s, Context context, String s1, int i)
    {
        Vibrator vibrator;
        vibrator = (Vibrator)context.getSystemService("vibrator");
        s1 = s1.replaceAll("\\[", "").replaceAll("\\]", "");
        if (s1 != null && !"".equals(s1.trim())) goto _L2; else goto _L1
_L1:
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Vibration canceled");
        a(context);
_L4:
        return;
_L2:
        long al[];
        int l;
        s1 = s1.split(",");
        int k = s1.length;
        com.inmobi.ads.b.e e = b.getRenderingConfig();
        int j = k;
        if (k > e.f())
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, (new StringBuilder()).append("vibration pattern exceeds max length. Will be truncated to max ").append(e.f()).toString());
            j = e.f();
        }
        al = new long[j];
        l = 0;
        k = 0;
        do
        {
            if (k >= j)
            {
                continue; /* Loop/switch isn't completed */
            }
            try
            {
                al[k] = Long.parseLong(s1[k]);
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                b.a(s, "Invalid values of pattern in vibration .", "vibrate");
                return;
            }
            if (al[k] > (long)(e.e() * 1000))
            {
                Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, (new StringBuilder()).append("vibration duration exceeds max. Will only vibrate for max ").append(e.e()).append("ms").toString());
                al[k] = e.e();
            }
            if (al[k] < 0L)
            {
                b.a(s, "Negative duration not allowed in vibration .", "vibrate");
            }
            l = (int)((long)l + al[k]);
            k++;
        } while (true);
        if (al.length == 0) goto _L4; else goto _L3
_L3:
        a(context);
        vibrator.vibrate(al, i);
        context = Message.obtain();
        context.what = 1;
        context.obj = s;
        c.sendMessageDelayed(context, l);
        return;
    }

    public void a(String s, Context context, String s1, String s2, String s3, String s4, String s5, 
            String s6, String s7, String s8, String s9, String s10)
    {
        int i;
        i = com.inmobi.rendering.mraid.a.a(context);
        GregorianCalendar gregoriancalendar = com.inmobi.rendering.mraid.a.b(s2);
        if (gregoriancalendar == null)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, (new StringBuilder()).append("Invalid event start date provided. date string: ").append(s2).toString());
            return;
        }
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, (new StringBuilder()).append("Event start: ").append(gregoriancalendar.get(1)).append("-").append(gregoriancalendar.get(2)).append("-").append(gregoriancalendar.get(5)).toString());
        GregorianCalendar gregoriancalendar1 = com.inmobi.rendering.mraid.a.b(s3);
        if (gregoriancalendar1 == null)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, (new StringBuilder()).append("Invalid event end date provided. date string: ").append(s3).toString());
            return;
        }
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, (new StringBuilder()).append("Event end: ").append(gregoriancalendar1.get(1)).append("-").append(gregoriancalendar1.get(2)).append("-").append(gregoriancalendar1.get(5)).toString());
        s1 = (new Intent("android.intent.action.INSERT")).setData(android.provider.CalendarContract.Events.CONTENT_URI).putExtra("calendar_id", s1).putExtra("beginTime", gregoriancalendar.getTimeInMillis()).putExtra("endTime", gregoriancalendar1.getTimeInMillis()).putExtra("allDay", false).putExtra("title", s5).putExtra("eventLocation", s4).putExtra("description", s6);
        if (!s8.equals("transparent")) goto _L2; else goto _L1
_L1:
        s1.putExtra("availability", 1);
_L4:
        s3 = a(s9);
        if (s3.length() != 0)
        {
            s1.putExtra("rrule", s3);
        }
        i = InMobiAdActivity.a(s1, new com.inmobi.rendering.InMobiAdActivity.a(context, i, s7, s10, s2, s) {

            final Context a;
            final int b;
            final String c;
            final String d;
            final String e;
            final String f;
            final n g;

            public void a(int j, Intent intent)
            {
                Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, com.inmobi.rendering.mraid.n.a(), (new StringBuilder()).append("Result code: ").append(j).toString());
                j = com.inmobi.rendering.mraid.a.a(a);
                if (b != j) goto _L2; else goto _L1
_L1:
                Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, com.inmobi.rendering.mraid.n.a(), "User cancelled the create calendar event");
_L12:
                return;
_L2:
                Object obj;
                obj = new ContentValues();
                intent = c;
                j = -1;
                intent.hashCode();
                JVM INSTR lookupswitch 3: default 108
            //                           -1320822226: 280
            //                           -804109473: 294
            //                           476588369: 308;
                   goto _L3 _L4 _L5 _L6
_L3:
                j;
                JVM INSTR tableswitch 0 2: default 136
            //                           0 322
            //                           1 335
            //                           2 348;
                   goto _L7 _L8 _L9 _L10
_L7:
                intent = a.getContentResolver();
                intent.update(ContentUris.withAppendedId(android.provider.CalendarContract.Events.CONTENT_URI, com.inmobi.rendering.mraid.a.a(a)), ((ContentValues) (obj)), null, null);
                if (d == null || "".equals(d)) goto _L12; else goto _L11
_L11:
                if (!d.startsWith("+")) goto _L14; else goto _L13
_L13:
                j = Integer.parseInt(d.substring(1)) / 60000;
_L15:
                j = -j;
                intent.delete(android.provider.CalendarContract.Reminders.CONTENT_URI, "event_id=?", new String[] {
                    (new StringBuilder()).append(com.inmobi.rendering.mraid.a.a(a)).append("").toString()
                });
                NumberFormatException numberformatexception;
                int k;
                if (j < 0)
                {
                    com.inmobi.rendering.mraid.n.a(g).a(f, "Reminder format is incorrect. Reminder can be set only before the event starts", "createCalendarEvent");
                    return;
                } else
                {
                    ContentValues contentvalues = new ContentValues();
                    contentvalues.put("event_id", Integer.valueOf(com.inmobi.rendering.mraid.a.a(a)));
                    contentvalues.put("method", Integer.valueOf(1));
                    contentvalues.put("minutes", Integer.valueOf(j));
                    intent.insert(android.provider.CalendarContract.Reminders.CONTENT_URI, contentvalues);
                    return;
                }
_L4:
                if (intent.equals("tentative"))
                {
                    j = 0;
                }
                  goto _L3
_L5:
                if (intent.equals("confirmed"))
                {
                    j = 1;
                }
                  goto _L3
_L6:
                if (intent.equals("cancelled"))
                {
                    j = 2;
                }
                  goto _L3
_L8:
                ((ContentValues) (obj)).put("eventStatus", Integer.valueOf(0));
                  goto _L7
_L9:
                ((ContentValues) (obj)).put("eventStatus", Integer.valueOf(1));
                  goto _L7
_L10:
                ((ContentValues) (obj)).put("eventStatus", Integer.valueOf(2));
                  goto _L7
_L14:
                j = Integer.parseInt(d) / 60000;
                  goto _L15
                numberformatexception;
                numberformatexception = com.inmobi.rendering.mraid.a.b(d);
                if (numberformatexception == null)
                {
                    Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, com.inmobi.rendering.mraid.n.a(), (new StringBuilder()).append("Invalid reminder date provided. date string: ").append(d).toString());
                    return;
                }
                k = (int)(numberformatexception.getTimeInMillis() - com.inmobi.rendering.mraid.a.b(e).getTimeInMillis()) / 60000;
                j = k;
                if (k <= 0) goto _L15; else goto _L16
_L16:
                com.inmobi.rendering.mraid.n.a(g).a(f, "Reminder format is incorrect. Reminder can be set only before the event starts", "createCalendarEvent");
                return;
                  goto _L3
            }

            
            {
                g = n.this;
                a = context;
                b = i;
                c = s;
                d = s1;
                e = s2;
                f = s3;
                super();
            }
        });
        s = new Intent(context, com/inmobi/rendering/InMobiAdActivity);
        s.putExtra("com.inmobi.rendering.InMobiAdActivity.EXTRA_AD_ACTIVITY_TYPE", 103);
        s.putExtra("id", i);
        context.startActivity(s);
        return;
_L2:
        if (s8.equals("opaque"))
        {
            s1.putExtra("availability", 0);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

}
