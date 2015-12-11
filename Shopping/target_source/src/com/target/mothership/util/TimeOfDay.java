// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.util;

import android.os.Parcel;
import android.os.Parcelable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.target.mothership.util:
//            o

public class TimeOfDay
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TimeOfDay a(Parcel parcel)
        {
            return new TimeOfDay(parcel);
        }

        public TimeOfDay[] a(int i)
        {
            return new TimeOfDay[i];
        }

        public Object createFromParcel(Parcel parcel)
        {
            return a(parcel);
        }

        public Object[] newArray(int i)
        {
            return a(i);
        }

    };
    public static final TimeOfDay DAY_END = new TimeOfDay(23, 59, 59);
    public static final TimeOfDay DAY_START = new TimeOfDay(0, 0, 0);
    private static final int MILLISECONDS_IN_SECOND = 1000;
    private static final int MINUTES_IN_HOUR = 60;
    private static final int SECONDS_IN_DAY = 0x15180;
    private static final int SECONDS_IN_HOUR = 3600;
    private static final int SECONDS_IN_MINUTE = 60;
    private static Pattern timePattern = Pattern.compile("^([0-9]{1,2}):([0-9]{2}):([0-9]{2})(([+-])([0-9]{2,4}))?$");
    private int mHour;
    private int mMinute;
    private int mSecond;
    private int mSecondOfDay;
    private Integer mTimeZoneOffset;

    public TimeOfDay(int i, int j, int k)
        throws IllegalArgumentException
    {
        a(i, j, k, null);
    }

    public TimeOfDay(Parcel parcel)
    {
        a(parcel);
    }

    public TimeOfDay(TimeOfDay timeofday)
    {
        mHour = timeofday.mHour;
        mMinute = timeofday.mMinute;
        mSecond = timeofday.mSecond;
        mSecondOfDay = timeofday.mSecondOfDay;
        mTimeZoneOffset = timeofday.mTimeZoneOffset;
    }

    public static TimeOfDay a(String s)
    {
        if (!o.e(s)) goto _L2; else goto _L1
_L1:
        s = null;
_L4:
        return s;
_L2:
        TimeOfDay timeofday;
        Matcher matcher;
        matcher = timePattern.matcher(s);
        if (!matcher.find())
        {
            throw new IllegalArgumentException("Invalid time string, must be hh:mm:ss[Z]");
        }
        timeofday = new TimeOfDay(Integer.parseInt(matcher.group(1), 10), Integer.parseInt(matcher.group(2), 10), Integer.parseInt(matcher.group(3), 10));
        s = timeofday;
        if (matcher.group(4) == null) goto _L4; else goto _L3
_L3:
        s = matcher.group(6);
        if (s.length() == 2)
        {
            timeofday.mTimeZoneOffset = Integer.valueOf(Integer.parseInt(s, 10) * 3600);
        } else
        {
            int i = Integer.parseInt(s, 10);
            timeofday.mTimeZoneOffset = Integer.valueOf((i % 100) * 60 + (i / 100) * 3600);
        }
        if (matcher.group(5).equals("-"))
        {
            timeofday.mTimeZoneOffset = Integer.valueOf(-timeofday.mTimeZoneOffset.intValue());
        }
        if (timeofday.mTimeZoneOffset.intValue() <= -43200)
        {
            break; /* Loop/switch isn't completed */
        }
        s = timeofday;
        if (timeofday.mTimeZoneOffset.intValue() < 43200) goto _L4; else goto _L5
_L5:
        throw new IllegalArgumentException("Invalid time zone offset, must be +/- 12 hours");
    }

    private void a(int i, int j, int k, Integer integer)
    {
        if (i < 0 || i > 23 || j < 0 || j > 59 || k < 0 || k > 59)
        {
            throw new IllegalArgumentException("Invalid time.  Hours must be 0-23, minutes 0-59, and seconds 0-59");
        }
        if (integer != null && (integer.intValue() < -43200 || integer.intValue() > 43200))
        {
            throw new IllegalArgumentException("Invalid time zone offset.  Must be +/- 12 hours");
        } else
        {
            mHour = i;
            mMinute = j;
            mSecond = k;
            mSecondOfDay = i * 3600 + j * 60 + k;
            mTimeZoneOffset = integer;
            return;
        }
    }

    public static boolean a(TimeOfDay timeofday, TimeOfDay timeofday1, Calendar calendar)
    {
        boolean flag;
label0:
        {
label1:
            {
                flag = true;
                boolean flag1 = false;
                timeofday = timeofday.a(calendar.getTimeZone());
                timeofday1 = timeofday1.a(calendar.getTimeZone());
                if (timeofday.a() < timeofday1.a())
                {
                    break label0;
                }
                if (!a(timeofday, calendar))
                {
                    flag = flag1;
                    if (!b(timeofday1, calendar))
                    {
                        break label1;
                    }
                }
                flag = true;
            }
            return flag;
        }
        if (!a(timeofday, calendar) || !b(timeofday1, calendar))
        {
            flag = false;
        }
        return flag;
    }

    public static boolean a(TimeOfDay timeofday, TimeOfDay timeofday1, Date date)
    {
        GregorianCalendar gregoriancalendar = new GregorianCalendar();
        gregoriancalendar.setTime(date);
        return a(timeofday, timeofday1, ((Calendar) (gregoriancalendar)));
    }

    private static boolean a(TimeOfDay timeofday, Calendar calendar)
    {
        return timeofday.mHour < calendar.get(11) || timeofday.mHour == calendar.get(11) && (timeofday.mMinute < calendar.get(12) || timeofday.mMinute == calendar.get(12) && timeofday.mSecond < calendar.get(13));
    }

    private static boolean b(TimeOfDay timeofday, Calendar calendar)
    {
        return timeofday.mHour > calendar.get(11) || timeofday.mHour == calendar.get(11) && (timeofday.mMinute > calendar.get(12) || timeofday.mMinute == calendar.get(12) && timeofday.mSecond > calendar.get(13));
    }

    public int a()
    {
        return mHour;
    }

    public TimeOfDay a(int i)
    {
        mSecondOfDay = (mSecondOfDay + i) % 0x15180;
        if (mSecondOfDay < 0)
        {
            mSecondOfDay = mSecondOfDay + 0x15180;
        }
        mSecond = mSecondOfDay % 60;
        mMinute = (mSecondOfDay / 60) % 60;
        mHour = mSecondOfDay / 3600;
        return this;
    }

    public TimeOfDay a(TimeZone timezone)
    {
        int i = timezone.getOffset(System.currentTimeMillis()) / 1000;
        if (mTimeZoneOffset == null || i == mTimeZoneOffset.intValue())
        {
            return this;
        } else
        {
            return (new TimeOfDay(this)).a(i - mTimeZoneOffset.intValue());
        }
    }

    public void a(Parcel parcel)
    {
        mHour = parcel.readInt();
        mMinute = parcel.readInt();
        mSecond = parcel.readInt();
        mSecondOfDay = parcel.readInt();
        if (parcel.readInt() == 1)
        {
            mTimeZoneOffset = Integer.valueOf(parcel.readInt());
        }
    }

    public boolean a(TimeOfDay timeofday)
    {
        return mSecondOfDay > timeofday.mSecondOfDay;
    }

    public int b()
    {
        return mMinute;
    }

    public String b(String s)
    {
        GregorianCalendar gregoriancalendar = new GregorianCalendar();
        gregoriancalendar.set(11, mHour);
        gregoriancalendar.set(12, mMinute);
        gregoriancalendar.set(13, mSecond);
        return (new SimpleDateFormat(s, Locale.US)).format(gregoriancalendar.getTime());
    }

    public boolean b(TimeOfDay timeofday)
    {
        while (timeofday == null || mSecondOfDay != timeofday.mSecondOfDay || (mTimeZoneOffset != null || timeofday.mTimeZoneOffset != null) && (mTimeZoneOffset == null || timeofday.mTimeZoneOffset != null) && mTimeZoneOffset != null && !mTimeZoneOffset.equals(timeofday.mTimeZoneOffset)) 
        {
            return false;
        }
        return true;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeInt(mHour);
        parcel.writeInt(mMinute);
        parcel.writeInt(mSecond);
        parcel.writeInt(mSecondOfDay);
        if (mTimeZoneOffset != null)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        if (mTimeZoneOffset != null)
        {
            parcel.writeInt(mTimeZoneOffset.intValue());
        }
    }

}
