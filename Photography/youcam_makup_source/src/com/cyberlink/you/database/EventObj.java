// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.database;

import android.content.ContentValues;
import android.os.Parcel;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.cyberlink.you.database:
//            BaseObj

public class EventObj extends BaseObj
{

    public static List b = Arrays.asList(new String[] {
        "EventId", "EventId", "EventFrom", "EventTo", "EventType", "EventContent"
    });
    long a;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;

    public EventObj(long l, String s, String s1, String s2, String s3, String s4)
    {
        a = l;
        c = s;
        d = s1;
        e = s2;
        f = s3;
        g = s4;
    }

    public ContentValues a()
    {
        return a(h());
    }

    public ContentValues a(List list)
    {
        if (list == null)
        {
            return new ContentValues();
        }
        ContentValues contentvalues = new ContentValues();
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            String s = (String)list.next();
            if (s != null && !s.isEmpty())
            {
                if (s.equals("_id"))
                {
                    contentvalues.put("_id", Long.valueOf(b()));
                } else
                if (s.equals("EventId"))
                {
                    contentvalues.put("EventId", c());
                } else
                if (s.equals("EventFrom"))
                {
                    contentvalues.put("EventFrom", d());
                } else
                if (s.equals("EventTo"))
                {
                    contentvalues.put("EventTo", e());
                } else
                if (s.equals("EventType"))
                {
                    contentvalues.put("EventType", f());
                } else
                if (s.equals("EventContent"))
                {
                    contentvalues.put("EventContent", g());
                }
            }
        } while (true);
        return contentvalues;
    }

    public long b()
    {
        return a;
    }

    public String c()
    {
        return c;
    }

    public String d()
    {
        return d;
    }

    public int describeContents()
    {
        return 0;
    }

    public String e()
    {
        return e;
    }

    public String f()
    {
        return f;
    }

    public String g()
    {
        return g;
    }

    public List h()
    {
        return b;
    }

    public String toString()
    {
        String s = super.toString();
        return (new StringBuilder()).append("ID: ").append(a).append(", ").append(s).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
    }

}
