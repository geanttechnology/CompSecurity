// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.utils;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ListView;
import java.util.Date;
import org.apache.commons.lang3.Validate;

public class UIPresentationUtil
{

    private static final String FORBIDDEN_WORDS[] = {
        "A ", "An ", "The "
    };

    public UIPresentationUtil()
    {
    }

    public static String addQuotesToString(String s)
    {
        StringBuffer stringbuffer = new StringBuffer();
        if (s != null)
        {
            s = s.trim();
            if (!s.isEmpty())
            {
                stringbuffer.append("\"");
                stringbuffer.append(s);
                stringbuffer.append("\"");
            }
        }
        return stringbuffer.toString();
    }

    public static long bytesToMB(long l)
    {
        return l / 0x100000L;
    }

    public static String getAbsListStateDescription(View view, String s, int i, int j, int k)
    {
        String s1;
        if (view instanceof ListView)
        {
            s1 = view.getContext().getString(com.comcast.cim.android.R.string.content_description_entity_list_view_list);
        } else
        {
            s1 = view.getContext().getString(com.comcast.cim.android.R.string.content_description_entity_list_view_grid);
        }
        if (i + j > k)
        {
            j = k;
        } else
        {
            j = i + j;
        }
        return view.getContext().getString(com.comcast.cim.android.R.string.content_description_entity_list_view, new Object[] {
            s, s1, Integer.valueOf(i + 1), Integer.valueOf(j), Integer.valueOf(k)
        });
    }

    public static int getDaysLeft(Date date)
    {
        return (int)((date.getTime() - (new Date()).getTime()) / 0x5265c00L);
    }

    public static String getDuration(Context context, int i)
    {
        StringBuffer stringbuffer = new StringBuffer();
        int j = i / 3600;
        i %= 3600;
        int k = i / 60;
        if (j > 0)
        {
            StringBuffer stringbuffer1 = stringbuffer.append(j).append(" ");
            String s;
            if (j == 1)
            {
                s = context.getString(com.comcast.cim.android.R.string.hour);
            } else
            {
                s = context.getResources().getString(com.comcast.cim.android.R.string.hours);
            }
            stringbuffer1.append(s);
            if (k > 0)
            {
                stringbuffer.append(", ");
                showMinutes(context, stringbuffer, k);
            }
        } else
        if (k > 0)
        {
            showMinutes(context, stringbuffer, k);
        } else
        if (i % 60 > 0)
        {
            stringbuffer.append(context.getResources().getString(com.comcast.cim.android.R.string.less_than_a_minute));
        } else
        {
            return "";
        }
        return stringbuffer.toString();
    }

    public static String getDurationSpoken(Context context, int i)
    {
        return getDuration(context, i).replace("hr", "hour").replace("min", "minute");
    }

    public static String getRemainingTime(Context context, int i, int j)
    {
        StringBuffer stringbuffer;
        int k;
        if ((double)j / (double)i > 0.97999999999999998D)
        {
            return context.getResources().getString(com.comcast.cim.android.R.string.finished);
        }
        stringbuffer = new StringBuffer();
        j = (i - j) / 1000;
        i = j / 3600;
        j %= 3600;
        k = j / 60;
        if (i <= 0) goto _L2; else goto _L1
_L1:
        StringBuffer stringbuffer1 = stringbuffer.append(i).append(" ");
        String s;
        if (i == 1)
        {
            s = context.getString(com.comcast.cim.android.R.string.hour);
        } else
        {
            s = context.getResources().getString(com.comcast.cim.android.R.string.hours);
        }
        stringbuffer1.append(s);
        if (k > 0)
        {
            stringbuffer.append(", ");
            showMinutes(context, stringbuffer, k);
        }
_L4:
        stringbuffer.append(" ").append(context.getResources().getString(com.comcast.cim.android.R.string.left));
        return stringbuffer.toString();
_L2:
        if (k > 0)
        {
            showMinutes(context, stringbuffer, k);
        } else
        if (j % 60 > 0)
        {
            stringbuffer.append(context.getResources().getString(com.comcast.cim.android.R.string.less_than_a_minute));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static String getRemainingTimeTalkBack(Context context, int i, int j)
    {
        return translateTimeForTalkBack(getRemainingTime(context, i, j));
    }

    public static String getSeriesString(Integer integer, Integer integer1)
    {
        if (integer != null && integer.intValue() > 0 && integer1 != null && integer1.intValue() > 0)
        {
            return (new StringBuilder()).append("S").append(integer).append(" | Ep").append(integer1).toString();
        } else
        {
            return "";
        }
    }

    public static String getSeriesStringSpoken(String s, String s1, String s2)
    {
        s = s.replace("S", (new StringBuilder()).append(s1).append(" ").toString()).replace("Ep", (new StringBuilder()).append(s2).append(" ").toString()).replace("|", ", ");
        return (new StringBuilder()).append(s).append(".").toString();
    }

    public static String getSortStringFromTitle(String s)
    {
        Validate.notNull(s);
        String as[] = FORBIDDEN_WORDS;
        int j = as.length;
        for (int i = 0; i < j;)
        {
            String s2 = as[i];
            String s1 = s;
            if (s.startsWith(s2))
            {
                s1 = s.substring(s2.length()).trim();
            }
            i++;
            s = s1;
        }

        return s;
    }

    public static String getTimeForPlayer(Context context, int i)
    {
        StringBuffer stringbuffer = new StringBuffer();
        int j = i / 3600;
        int k = i % 3600;
        int l = k / 60;
        if (j > 0)
        {
            StringBuffer stringbuffer1 = stringbuffer.append(j).append(" ");
            String s;
            if (j == 1)
            {
                s = context.getString(com.comcast.cim.android.R.string.hour);
            } else
            {
                s = context.getResources().getString(com.comcast.cim.android.R.string.hours);
            }
            stringbuffer1.append(s);
        }
        if (l > 0)
        {
            stringbuffer.append(", ");
            showMinutes(context, stringbuffer, l);
        }
        if (i > 0)
        {
            stringbuffer.append(", ");
            showSeconds(context, stringbuffer, k % 60);
        }
        return translateTimeForTalkBack(stringbuffer.toString());
    }

    private static void showMinutes(Context context, StringBuffer stringbuffer, int i)
    {
        stringbuffer = stringbuffer.append(i).append(" ");
        if (i == 1)
        {
            context = context.getResources().getString(com.comcast.cim.android.R.string.min);
        } else
        {
            context = context.getResources().getString(com.comcast.cim.android.R.string.mins);
        }
        stringbuffer.append(context);
    }

    private static void showSeconds(Context context, StringBuffer stringbuffer, int i)
    {
        stringbuffer = stringbuffer.append(i).append(" ");
        if (i == 1)
        {
            context = context.getResources().getString(com.comcast.cim.android.R.string.sec);
        } else
        {
            context = context.getResources().getString(com.comcast.cim.android.R.string.secs);
        }
        stringbuffer.append(context);
    }

    public static String translateTimeForTalkBack(String s)
    {
        return s.replace("hr", "hour").replace("min", "minute").replace("sec", "second");
    }

}
