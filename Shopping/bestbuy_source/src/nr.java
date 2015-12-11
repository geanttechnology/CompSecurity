// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.SparseArray;
import com.bestbuy.android.api.lib.models.store.BBYStore;
import com.bestbuy.android.api.lib.models.store.DetailedHours;
import com.bestbuy.android.api.lib.models.store.StoreDetails;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class nr
{

    public static String a(int i)
    {
        if (i == 1)
        {
            return "Sunday";
        }
        if (i == 2)
        {
            return "Monday";
        }
        if (i == 3)
        {
            return "Tuesday";
        }
        if (i == 4)
        {
            return "Wednesday";
        }
        if (i == 5)
        {
            return "Thursday";
        }
        if (i == 6)
        {
            return "Friday";
        }
        if (i == 7)
        {
            return "Saturday";
        } else
        {
            return "";
        }
    }

    public static String a(BBYStore bbystore)
    {
        int i;
        StringBuffer stringbuffer;
        DetailedHours adetailedhours[];
        DetailedHours detailedhours;
        try
        {
            stringbuffer = new StringBuffer();
            adetailedhours = bbystore.getStoreDetails().getDetailedHours();
        }
        // Misplaced declaration of an exception variable
        catch (BBYStore bbystore)
        {
            bbystore.printStackTrace();
            return "";
        }
        i = 0;
_L3:
        if (i >= adetailedhours.length)
        {
            break MISSING_BLOCK_LABEL_124;
        }
        detailedhours = adetailedhours[i];
        bbystore = detailedhours.getDay();
        if (bbystore == null)
        {
            break MISSING_BLOCK_LABEL_142;
        }
        if (bbystore.isEmpty())
        {
            break MISSING_BLOCK_LABEL_142;
        }
        if (!bbystore.equals("Thursday"))
        {
            break MISSING_BLOCK_LABEL_114;
        }
        bbystore = bbystore.substring(0, 5);
_L1:
        stringbuffer.append((new StringBuilder()).append(bbystore).append(": ").append(detailedhours.getOpen()).append("-").append(detailedhours.getClose()).append(";").toString());
        break MISSING_BLOCK_LABEL_142;
        bbystore = bbystore.substring(0, 3);
          goto _L1
        bbystore = a(stringbuffer.toString());
        return bbystore;
        i++;
        if (true) goto _L3; else goto _L2
_L2:
    }

    public static String a(String s)
    {
        String s1 = "Closed";
        if (s == null || s.isEmpty())
        {
            return "";
        }
        SparseArray sparsearray = new SparseArray();
        s = s.split(";");
        int i = 0;
        byte byte0 = 0;
        while (i < s.length) 
        {
            String as[] = s[i].split(": ");
            if (as[0].trim().equals("Mon"))
            {
                byte0 = 2;
            } else
            if (as[0].trim().equals("Tue"))
            {
                byte0 = 3;
            } else
            if (as[0].trim().equals("Wed"))
            {
                byte0 = 4;
            } else
            if (as[0].trim().equals("Thurs"))
            {
                byte0 = 5;
            } else
            if (as[0].trim().equals("Fri"))
            {
                byte0 = 6;
            } else
            if (as[0].trim().trim().equals("Sat"))
            {
                byte0 = 7;
            } else
            if (as[0].trim().equals("Sun"))
            {
                byte0 = 1;
            }
            sparsearray.put(byte0, as[1]);
            i++;
        }
        int k = Calendar.getInstance(Locale.US).get(7);
        s = (String)sparsearray.get(Integer.valueOf(k).intValue());
        Object obj = s1;
        if (s != null)
        {
            String as1[] = s.split("-");
            s = new SimpleDateFormat("h:mm a");
            obj = b(as1[0].trim());
            Date date = b(as1[1].trim());
            String s3 = a(((Date) (obj)), date);
            if (s3.equals("BetweenTheRange"))
            {
                return (new StringBuilder()).append("Open until ").append(s.format(date)).toString();
            }
            if (s3.equals("BeforeTheRange"))
            {
                return (new StringBuilder()).append("Closed, Open at ").append(s.format(((Date) (obj)))).toString();
            }
            s = (String)sparsearray.get(k + 1);
            if (s != null && !s.isEmpty())
            {
                s = s.split("-");
                return (new StringBuilder()).append("Closed, Open at ").append(s[0]).toString();
            }
            boolean flag = true;
            s = s1;
            do
            {
                obj = s;
                if (!flag)
                {
                    break;
                }
                String s2;
                int j;
                if (k >= 7)
                {
                    j = 1;
                } else
                {
                    j = k + 1;
                }
                s2 = (String)sparsearray.get(j);
                if (s2 != null && !s2.isEmpty())
                {
                    s = s2.split("-");
                    s2 = a(j);
                    s = (new StringBuilder()).append("Closed, Open ").append(s2).append(" at ").append(s[0]).toString();
                    flag = false;
                    k = j;
                } else
                {
                    k = j;
                    if (j > 8)
                    {
                        s = "";
                        flag = false;
                        k = j;
                    }
                }
            } while (true);
        }
        return ((String) (obj));
    }

    public static String a(Date date, Date date1)
    {
        Date date2 = new Date();
        if (date2.after(date) && date2.before(date1))
        {
            return "BetweenTheRange";
        }
        if (date2.after(date1))
        {
            return "AfterTheRange";
        } else
        {
            return "BeforeTheRange";
        }
    }

    public static Date b(String s)
    {
        Object obj;
        boolean flag;
        if (s.contains("pm"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj = s.replace("am", "").replace("pm", "");
        s = ((String) (obj));
        if (!((String) (obj)).contains(":"))
        {
            s = (new StringBuilder()).append(((String) (obj))).append(":00").toString();
        }
        s = s.split(":");
        obj = new GregorianCalendar();
        if (flag)
        {
            ((GregorianCalendar) (obj)).set(11, Integer.parseInt(s[0]) + 12);
        } else
        {
            ((GregorianCalendar) (obj)).set(11, Integer.parseInt(s[0]));
        }
        ((GregorianCalendar) (obj)).set(12, Integer.parseInt(s[1]));
        ((GregorianCalendar) (obj)).set(13, 0);
        ((GregorianCalendar) (obj)).set(14, 0);
        return ((GregorianCalendar) (obj)).getTime();
    }

    public static boolean c(String s)
    {
        boolean flag = false;
        NumberFormat numberformat = NumberFormat.getInstance();
        ParsePosition parseposition = new ParsePosition(0);
        numberformat.parse(s, parseposition);
        if (s.length() == parseposition.getIndex())
        {
            flag = true;
        }
        return flag;
    }
}
