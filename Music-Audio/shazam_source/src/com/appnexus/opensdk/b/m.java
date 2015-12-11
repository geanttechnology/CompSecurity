// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk.b;

import android.content.Intent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.appnexus.opensdk.b:
//            n, k

public final class m
{

    public static boolean j = false;
    private static SimpleDateFormat l;
    private static SimpleDateFormat m;
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public n i;
    private String k;

    private m()
    {
    }

    public static m a(String s)
    {
        m m1;
        boolean flag;
        flag = false;
        m1 = new m();
        s = new JSONObject(s);
        if (!s.isNull("id"))
        {
            m1.k = s.getString("id");
        }
        if (!s.isNull("description"))
        {
            m1.a = s.getString("description");
        }
        if (!s.isNull("location"))
        {
            m1.b = s.getString("location");
        }
        if (!s.isNull("summary"))
        {
            m1.c = s.getString("summary");
        }
        if (!s.isNull("start"))
        {
            m1.d = s.getString("start");
        }
        if (!s.isNull("end"))
        {
            if (s.isNull("start"))
            {
                m1.d = s.getString("end");
            }
            m1.e = s.getString("end");
        }
        if (!s.isNull("status"))
        {
            m1.f = s.getString("status");
        }
        if (!s.isNull("freebusy"))
        {
            m1.g = s.getString("freebusy");
        }
        if (!s.isNull("reminder"))
        {
            m1.h = s.getString("reminder");
        }
        if (s.isNull("recurrence")) goto _L2; else goto _L1
_L1:
        m1.i = new n();
        JSONArray jsonarray;
        int j1;
        s = s.getJSONObject("recurrence");
        if (!s.isNull("frequency"))
        {
            m1.i.a = s.getString("frequency");
        }
        if (!s.isNull("interval"))
        {
            m1.i.b = s.getInt("interval");
        }
        if (!s.isNull("expires"))
        {
            m1.i.c = s.getString("expires");
        }
        if (s.isNull("exceptionDates"))
        {
            break MISSING_BLOCK_LABEL_366;
        }
        jsonarray = s.getJSONArray("exceptionDates");
        j1 = jsonarray.length();
        m1.i.d = new String[j1];
        int i1 = 0;
        while (i1 < j1) 
        {
            int k1;
            try
            {
                m1.i.d[i1] = jsonarray.getString(i1);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return m1;
            }
            i1++;
        }
        if (s.isNull("daysInWeek")) goto _L4; else goto _L3
_L3:
        jsonarray = s.getJSONArray("daysInWeek");
        k1 = jsonarray.length();
        m1.i.e = new int[k1];
        i1 = 0;
_L5:
        if (i1 >= k1)
        {
            break; /* Loop/switch isn't completed */
        }
        m1.i.e[i1] = jsonarray.getInt(i1);
        i1++;
        if (true) goto _L5; else goto _L4
_L4:
        if (s.isNull("daysInMonth")) goto _L7; else goto _L6
_L6:
        jsonarray = s.getJSONArray("daysInMonth");
        k1 = jsonarray.length();
        m1.i.f = new int[k1];
        i1 = 0;
_L8:
        if (i1 >= k1)
        {
            break; /* Loop/switch isn't completed */
        }
        m1.i.f[i1] = jsonarray.getInt(i1);
        i1++;
        if (true) goto _L8; else goto _L7
_L7:
        if (s.isNull("daysInYear")) goto _L10; else goto _L9
_L9:
        jsonarray = s.getJSONArray("daysInYear");
        k1 = jsonarray.length();
        m1.i.g = new int[k1];
        i1 = 0;
_L11:
        if (i1 >= k1)
        {
            break; /* Loop/switch isn't completed */
        }
        m1.i.g[i1] = jsonarray.getInt(i1);
        i1++;
        if (true) goto _L11; else goto _L10
_L10:
        if (s.isNull("weeksInMonth")) goto _L13; else goto _L12
_L12:
        jsonarray = s.getJSONArray("weeksInMonth");
        k1 = jsonarray.length();
        m1.i.h = new int[k1];
        i1 = 0;
_L14:
        if (i1 >= k1)
        {
            break; /* Loop/switch isn't completed */
        }
        m1.i.h[i1] = jsonarray.getInt(i1);
        i1++;
        if (true) goto _L14; else goto _L13
_L13:
        if (s.isNull("monthsInYear")) goto _L2; else goto _L15
_L15:
        s = s.getJSONArray("monthsInYear");
        k1 = s.length();
        m1.i.i = new int[k1];
        i1 = ((flag) ? 1 : 0);
_L16:
        if (i1 >= k1)
        {
            break; /* Loop/switch isn't completed */
        }
        m1.i.i[i1] = s.getInt(i1);
        i1++;
        if (true) goto _L16; else goto _L2
        s;
_L2:
        return m1;
    }

    private static long b(String s)
    {
        long l1;
        try
        {
            l1 = l.parse(s).getTime();
        }
        catch (ParseException parseexception)
        {
            long l2;
            try
            {
                l2 = m.parse(s).getTime();
            }
            catch (ParseException parseexception1)
            {
                long l3;
                try
                {
                    l3 = Long.parseLong(s);
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    return -1L;
                }
                return l3;
            }
            return l2;
        }
        return l1;
    }

    public final Intent a()
    {
        String s;
        Intent intent;
        StringBuilder stringbuilder;
        boolean flag;
        long l4;
        if (!j && android.os.Build.VERSION.SDK_INT >= 14)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            intent = (new Intent("android.intent.action.EDIT")).setData(android.provider.CalendarContract.Events.CONTENT_URI);
        } else
        {
            intent = (new Intent("android.intent.action.EDIT")).setType("vnd.android.cursor.item/event");
        }
        if (!com.appnexus.opensdk.b.k.a(a))
        {
            if (flag)
            {
                intent.putExtra("title", a);
            } else
            {
                intent.putExtra("title", a);
            }
        }
        if (!com.appnexus.opensdk.b.k.a(b))
        {
            if (flag)
            {
                intent.putExtra("eventLocation", b);
            } else
            {
                intent.putExtra("eventLocation", b);
            }
        }
        if (!com.appnexus.opensdk.b.k.a(c))
        {
            if (flag)
            {
                intent.putExtra("description", c);
            } else
            {
                intent.putExtra("description", c);
            }
        }
        if (!com.appnexus.opensdk.b.k.a(d))
        {
            l4 = b(d);
            int ai1[];
            int i1;
            int k2;
            if (l4 > 0L)
            {
                if (flag)
                {
                    intent.putExtra("beginTime", l4);
                } else
                {
                    intent.putExtra("beginTime", l4);
                }
            }
        }
        if (!com.appnexus.opensdk.b.k.a(e))
        {
            l4 = b(e);
            if (l4 > 0L)
            {
                if (flag)
                {
                    intent.putExtra("endTime", l4);
                } else
                {
                    intent.putExtra("endTime", l4);
                }
            }
        }
        if (!com.appnexus.opensdk.b.k.a(f) && flag)
        {
            intent.putExtra("eventStatus", f);
        }
        if (!com.appnexus.opensdk.b.k.a(g) && flag)
        {
            boolean flag1;
            if (!g.equals("opaque"))
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            intent.putExtra("visible", flag1);
        }
        if (com.appnexus.opensdk.b.k.a(h)) goto _L2; else goto _L1
_L1:
        l4 = b(h);
        if (l4 >= 0L) goto _L4; else goto _L3
_L3:
        if (flag)
        {
            intent.putExtra("minutes", Math.abs(l4 / 60000L));
        }
_L2:
        stringbuilder = new StringBuilder("");
        if (i == null) goto _L6; else goto _L5
_L5:
        s = i.a;
        long l5;
        if (!com.appnexus.opensdk.b.k.a(s))
        {
            if ("daily".equals(s))
            {
                stringbuilder.append("FREQ=DAILY;");
            } else
            if ("weekly".equals(s))
            {
                stringbuilder.append("FREQ=WEEKLY;");
            } else
            if ("monthly".equals(s))
            {
                stringbuilder.append("FREQ=MONTHLY;");
            } else
            if ("yearly".equals(s))
            {
                stringbuilder.append("FREQ=YEARLY;");
            } else
            {
                s = "";
            }
        } else
        {
            s = "";
        }
        if (i.b > 0)
        {
            stringbuilder.append("INTERVAL=");
            stringbuilder.append(i.b);
            stringbuilder.append(";");
        }
        if (!"weekly".equals(s) || i.e == null || i.e.length <= 0) goto _L8; else goto _L7
_L7:
        stringbuilder.append("BYDAY=");
        ai1 = i.e;
        k2 = ai1.length;
        i1 = 0;
_L19:
        if (i1 >= k2) goto _L10; else goto _L9
_L9:
        ai1[i1];
        JVM INSTR tableswitch 0 6: default 508
    //                   0 744
    //                   1 755
    //                   2 766
    //                   3 777
    //                   4 788
    //                   5 799
    //                   6 810;
           goto _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18
_L11:
        i1++;
          goto _L19
_L4:
        if (!com.appnexus.opensdk.b.k.a(d) && flag)
        {
            l5 = b(d);
            if (l5 > 0L)
            {
                intent.putExtra("minutes", Math.abs((l5 - l4) / 60000L));
            }
        }
        continue; /* Loop/switch isn't completed */
_L12:
        stringbuilder.append("SU,");
          goto _L11
_L13:
        stringbuilder.append("MO,");
          goto _L11
_L14:
        stringbuilder.append("TU,");
          goto _L11
_L15:
        stringbuilder.append("WE,");
          goto _L11
_L16:
        stringbuilder.append("TH,");
          goto _L11
_L17:
        stringbuilder.append("FR,");
          goto _L11
_L18:
        stringbuilder.append("SA,");
          goto _L11
_L10:
        stringbuilder.setCharAt(stringbuilder.length() - 1, ';');
_L8:
        if ("monthly".equals(s) && i.f != null && i.f.length > 0)
        {
            stringbuilder.append("BYMONTHDAY=");
            int ai2[] = i.f;
            int l2 = ai2.length;
            for (int j1 = 0; j1 < l2; j1++)
            {
                stringbuilder.append(ai2[j1]);
                stringbuilder.append(",");
            }

            stringbuilder.setCharAt(stringbuilder.length() - 1, ';');
        }
        if ("yearly".equals(s) && i.g != null && i.g.length > 0)
        {
            stringbuilder.append("BYYEARDAY=");
            int ai3[] = i.g;
            int i3 = ai3.length;
            for (int k1 = 0; k1 < i3; k1++)
            {
                stringbuilder.append(ai3[k1]);
                stringbuilder.append(",");
            }

            stringbuilder.setCharAt(stringbuilder.length() - 1, ';');
        }
        if ("yearly".equals(s) && i.i != null && i.i.length > 0)
        {
            stringbuilder.append("BYMONTH=");
            int ai4[] = i.i;
            int j3 = ai4.length;
            for (int l1 = 0; l1 < j3; l1++)
            {
                stringbuilder.append(ai4[l1]);
                stringbuilder.append(",");
            }

            stringbuilder.setCharAt(stringbuilder.length() - 1, ';');
        }
        if ("monthly".equals(s) && i.h != null && i.h.length > 0)
        {
            stringbuilder.append("BYWEEKNO=");
            int ai[] = i.h;
            int k3 = ai.length;
            for (int i2 = 0; i2 < k3; i2++)
            {
                stringbuilder.append(ai[i2]);
                stringbuilder.append(",");
            }

            stringbuilder.setCharAt(stringbuilder.length() - 1, ';');
        }
        if (!com.appnexus.opensdk.b.k.a(i.c))
        {
            stringbuilder.append("UNTIL=");
            stringbuilder.append(i.c);
            stringbuilder.append(";");
        }
        if (i.d != null && i.d.length > 0)
        {
            stringbuilder.append("EXDATE=");
            String as[] = i.d;
            int l3 = as.length;
            for (int j2 = 0; j2 < l3; j2++)
            {
                stringbuilder.append(as[j2]);
                stringbuilder.append(",");
            }

            stringbuilder.setCharAt(stringbuilder.length() - 1, ';');
        }
        if (!flag) goto _L21; else goto _L20
_L20:
        intent.putExtra("rrule", stringbuilder.toString());
_L6:
        return intent;
_L21:
        intent.putExtra("rrule", stringbuilder.toString());
        return intent;
        if (true) goto _L2; else goto _L22
_L22:
    }

    static 
    {
        l = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZZZZZ", Locale.US);
        m = new SimpleDateFormat("yyyy-MM-dd'T'HH:mmZZZZZ", Locale.US);
    }
}
