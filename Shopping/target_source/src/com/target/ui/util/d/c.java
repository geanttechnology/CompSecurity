// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util.d;

import android.content.Context;
import android.content.res.Resources;
import android.text.format.DateFormat;
import com.google.a.a.g;
import com.google.a.b.e;
import com.google.a.b.h;
import com.target.mothership.model.store.interfaces.StoreOperatingHours;
import com.target.mothership.util.TimeOfDay;
import com.target.ui.model.DisplayStoreOperatingHours;
import com.target.ui.util.u;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class com.target.ui.util.d.c
{
    private static final class a extends Enum
    {

        private static final a $VALUES[];
        public static final a Friday;
        public static final a Monday;
        public static final a Saturday;
        public static final a Sunday;
        public static final a Thursday;
        public static final a Tuesday;
        public static final a Wednesday;

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/target/ui/util/d/c$a, s);
        }

        public static a[] values()
        {
            return (a[])$VALUES.clone();
        }

        static 
        {
            Sunday = new a("Sunday", 0);
            Monday = new a("Monday", 1);
            Tuesday = new a("Tuesday", 2);
            Wednesday = new a("Wednesday", 3);
            Thursday = new a("Thursday", 4);
            Friday = new a("Friday", 5);
            Saturday = new a("Saturday", 6);
            $VALUES = (new a[] {
                Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday
            });
        }

        private a(String s, int i)
        {
            super(s, i);
        }
    }

    private static class b
        implements com.target.ui.util.u.a
    {

        public boolean a(StoreOperatingHours storeoperatinghours, StoreOperatingHours storeoperatinghours1)
        {
            c c1 = new c();
            boolean flag = u.a(storeoperatinghours.e(), storeoperatinghours1.e(), c1);
            boolean flag1 = u.a(storeoperatinghours.f(), storeoperatinghours1.f(), c1);
            return flag && flag1;
        }

        public volatile boolean a(Object obj, Object obj1)
        {
            return a((StoreOperatingHours)obj, (StoreOperatingHours)obj1);
        }

        private b()
        {
        }

    }

    private static class c
        implements com.target.ui.util.u.a
    {

        public boolean a(TimeOfDay timeofday, TimeOfDay timeofday1)
        {
            return timeofday.b(timeofday1);
        }

        public volatile boolean a(Object obj, Object obj1)
        {
            return a((TimeOfDay)obj, (TimeOfDay)obj1);
        }

        private c()
        {
        }

    }


    private static final g sIsWeekday = new g() {

        public boolean a(StoreOperatingHours storeoperatinghours)
        {
            return storeoperatinghours != null && com.target.ui.util.d.c.a().contains(storeoperatinghours.a());
        }

        public volatile boolean a(Object obj)
        {
            return a((StoreOperatingHours)obj);
        }

    };
    private static final List sWeekdays;

    public static String a(TimeOfDay timeofday, Context context)
    {
        if (timeofday == null)
        {
            return "";
        }
        if (DateFormat.is24HourFormat(context))
        {
            return timeofday.b("H:mm");
        }
        if (timeofday.b() != 0)
        {
            return timeofday.b("h:mmaa").toLowerCase();
        } else
        {
            return timeofday.b("haa").toLowerCase();
        }
    }

    public static String a(String s)
    {
        int i = a.valueOf(s).ordinal() + 1;
        if (i == a.values().length)
        {
            return a.values()[0].name();
        } else
        {
            return a.values()[i].name();
        }
    }

    public static String a(Date date)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        switch (calendar.get(7))
        {
        default:
            return "";

        case 1: // '\001'
            return a.Sunday.name();

        case 2: // '\002'
            return a.Monday.name();

        case 3: // '\003'
            return a.Tuesday.name();

        case 4: // '\004'
            return a.Wednesday.name();

        case 5: // '\005'
            return a.Thursday.name();

        case 6: // '\006'
            return a.Friday.name();

        case 7: // '\007'
            return a.Saturday.name();
        }
    }

    static List a()
    {
        return sWeekdays;
    }

    public static List a(List list, Context context)
    {
        boolean flag1 = a(((List) (e.a(list).a(sIsWeekday).a())));
        ArrayList arraylist = new ArrayList();
        list = list.iterator();
        boolean flag = false;
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            StoreOperatingHours storeoperatinghours = (StoreOperatingHours)list.next();
            if (sIsWeekday.a(storeoperatinghours))
            {
                if (flag1 && !flag)
                {
                    arraylist.add(new DisplayStoreOperatingHours(storeoperatinghours, context.getResources().getString(0x7f0903d0), context.getResources().getString(0x7f0903d1)));
                    flag = true;
                } else
                if (!flag1)
                {
                    arraylist.add(new DisplayStoreOperatingHours(storeoperatinghours));
                }
            } else
            {
                arraylist.add(new DisplayStoreOperatingHours(storeoperatinghours));
            }
        } while (true);
        return arraylist;
    }

    private static boolean a(List list)
    {
        if (list.isEmpty())
        {
            return true;
        } else
        {
            StoreOperatingHours storeoperatinghours = (StoreOperatingHours)list.get(0);
            return e.a(list).b(new g(storeoperatinghours) {

                final StoreOperatingHours val$firstHours;

                public boolean a(StoreOperatingHours storeoperatinghours1)
                {
                    return u.a(firstHours, storeoperatinghours1, new b());
                }

                public volatile boolean a(Object obj)
                {
                    return a((StoreOperatingHours)obj);
                }

            
            {
                firstHours = storeoperatinghours;
                super();
            }
            });
        }
    }

    public static String b(Date date)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return String.valueOf(calendar.get(11));
    }

    static 
    {
        sWeekdays = h.a(a.Monday.name(), a.Tuesday.name(), a.Wednesday.name(), a.Thursday.name(), a.Friday.name());
    }
}
