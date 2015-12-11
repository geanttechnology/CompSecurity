// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import com.groupon.view.Transformation.BlurImageTransformation;
import com.groupon.view.Transformation.CropTransformation;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.text.Format;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.restlet.engine.util.InternetDateFormat;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.util:
//            PicassoHelper, DeviceInfoUtil

public class MarketRateUtil
{

    public MarketRateUtil()
    {
    }

    public static int getAverageRoomRate(List list)
    {
        if (list == null || list.size() == 0)
        {
            return 0;
        }
        double d = 0.0D;
        for (Iterator iterator = list.iterator(); iterator.hasNext();)
        {
            d += ((Integer)iterator.next()).intValue();
        }

        return (int)Math.round(d / (double)list.size());
    }

    protected static Calendar getDatePart(Date date)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar;
    }

    public static String getFormattedDate(String s, InternetDateFormat internetdateformat, Format format, Context context)
    {
        String s1 = null;
        if (Strings.notEmpty(s))
        {
            try
            {
                s1 = getFormattedDate(internetdateformat.parse(s), format, context);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return null;
            }
        }
        return s1;
    }

    public static String getFormattedDate(Date date, Format format, Context context)
    {
        if (date == null) goto _L2; else goto _L1
_L1:
        StringBuilder stringbuilder = new StringBuilder();
        if (context == null) goto _L4; else goto _L3
_L3:
        if (!isToday(date)) goto _L6; else goto _L5
_L5:
        stringbuilder.append(context.getString(0x7f0803e2)).append(": ");
_L4:
        return stringbuilder.append(format.format(date)).toString();
_L6:
        if (isTomorrow(date))
        {
            stringbuilder.append(context.getString(0x7f0803e1)).append(": ");
        }
        if (true) goto _L4; else goto _L2
_L2:
        return null;
    }

    public static int getNumberOfNights(Date date, Date date1)
    {
        date = getDatePart(date);
        Calendar calendar = getDatePart(date1);
        Object obj = calendar;
        date1 = date;
        if (calendar.before(date))
        {
            date1 = calendar;
            obj = date;
        }
        int i;
        for (i = 0; date1.before(obj); i++)
        {
            date1.add(5, 1);
        }

        return i;
    }

    public static String getPersonsFilterString(Context context, int i, int j)
    {
        String s = context.getResources().getQuantityString(0x7f0c0000, i, new Object[] {
            Integer.valueOf(i)
        });
        context = context.getResources().getQuantityString(0x7f0c0003, j, new Object[] {
            Integer.valueOf(j)
        });
        return (new StringBuilder()).append(s).append(", ").append(context).toString();
    }

    public static String getReservationDatesString(Context context, Date date, Date date1)
    {
        return getReservationDatesString(context, date, date1, true);
    }

    public static String getReservationDatesString(Context context, Date date, Date date1, boolean flag)
    {
        Object obj = Calendar.getInstance();
        String s;
        if (!flag && isToday(date) && isTomorrow(date1))
        {
            s = context.getString(0x7f0803e2);
        } else
        {
            if (!flag && isTomorrow(date) && isDayAfterTomorrow(date1))
            {
                return context.getString(0x7f0803e1);
            }
            ((Calendar) (obj)).setTime(date);
            s = ((Calendar) (obj)).getDisplayName(2, 1, Locale.getDefault());
            int i = ((Calendar) (obj)).get(5);
            int k = ((Calendar) (obj)).get(1);
            ((Calendar) (obj)).setTime(date1);
            String s1 = ((Calendar) (obj)).getDisplayName(2, 1, Locale.getDefault());
            int l = ((Calendar) (obj)).get(5);
            int i1 = ((Calendar) (obj)).get(1);
            if (k != i1)
            {
                obj = String.format(context.getString(0x7f0804de), new Object[] {
                    s, Integer.valueOf(i), Integer.valueOf(k), s1, Integer.valueOf(l), Integer.valueOf(i1)
                });
            } else
            if (s == s1)
            {
                obj = String.format(context.getString(0x7f080514), new Object[] {
                    s, Integer.valueOf(i), Integer.valueOf(l)
                });
            } else
            {
                obj = String.format(context.getString(0x7f080515), new Object[] {
                    s, Integer.valueOf(i), s1, Integer.valueOf(l)
                });
            }
            s = ((String) (obj));
            if (flag)
            {
                if (isToday(date))
                {
                    context = context.getString(0x7f0803e2);
                } else
                if (isTomorrow(date))
                {
                    context = context.getString(0x7f0803e1);
                } else
                {
                    int j = getNumberOfNights(date, date1);
                    context = context.getResources().getQuantityString(0x7f0c0017, j, new Object[] {
                        Integer.valueOf(j)
                    });
                }
                return (new StringBuilder()).append(context).append(": ").append(((String) (obj))).toString();
            }
        }
        return s;
    }

    public static int getStatusColor(String s, int i)
    {
        if (s.equalsIgnoreCase("confirmed"))
        {
            i = 0x7f0e00c2;
        } else
        {
            if (s.equalsIgnoreCase("processing"))
            {
                return 0x7f0e01bc;
            }
            if (s.matches("cancell?ed") || s.equalsIgnoreCase("failed"))
            {
                return 0x7f0e015c;
            }
        }
        return i;
    }

    public static boolean isDayAfterTomorrow(Date date)
    {
        Calendar calendar = getDatePart(Calendar.getInstance().getTime());
        calendar.add(5, 2);
        return calendar.compareTo(getDatePart(date)) == 0;
    }

    public static boolean isToday(Date date)
    {
        return getDatePart(Calendar.getInstance().getTime()).compareTo(getDatePart(date)) == 0;
    }

    public static boolean isTomorrow(Date date)
    {
        Calendar calendar = getDatePart(Calendar.getInstance().getTime());
        calendar.add(5, 1);
        return calendar.compareTo(getDatePart(date)) == 0;
    }

    public static void setHeaderImage(Context context, DeviceInfoUtil deviceinfoutil, String s, ImageView imageview, boolean flag)
    {
        if (Strings.notEmpty(s))
        {
            int i = (int)context.getResources().getDimension(0x7f0b018f);
            deviceinfoutil = PicassoHelper.getPicasso(context).load(s).transform(new CropTransformation(deviceinfoutil.getDisplayMetrics().widthPixels, i)).transform(new BlurImageTransformation());
            context = deviceinfoutil;
            if (flag)
            {
                context = PicassoHelper.request565Bitmap(deviceinfoutil, s);
            }
            context.into(imageview);
        }
    }
}
