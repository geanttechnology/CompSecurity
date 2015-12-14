// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.friends;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Friend
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public Friend a(Parcel parcel)
        {
            return new Friend(parcel);
        }

        public Friend[] a(int i)
        {
            return new Friend[i];
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
    public static List e = Arrays.asList(new String[] {
        "UserId", "Jid", "DisplayName", "Avatar"
    });
    public static List f = Arrays.asList(new String[] {
        "UserId", "Jid", "DisplayName", "Avatar", "IsBlocked"
    });
    public long a;
    public String b;
    public String c;
    public boolean d;
    private long g;
    private String h;

    public Friend()
    {
        a = 0L;
        h = "";
        b = "";
        c = "";
        d = false;
    }

    public Friend(long l, long l1, String s, String s1, String s2, 
            boolean flag)
    {
        g = l;
        a = l1;
        h = s1;
        b = s2;
        c = s;
        d = flag;
    }

    public Friend(Parcel parcel)
    {
        a = parcel.readLong();
        h = parcel.readString();
        b = parcel.readString();
        c = parcel.readString();
        boolean flag;
        if (parcel.readByte() == 0)
        {
            flag = false;
        } else
        {
            flag = true;
        }
        d = flag;
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
                if (s.equals("UserId"))
                {
                    contentvalues.put("UserId", Long.valueOf(a));
                } else
                if (s.equals("Jid"))
                {
                    contentvalues.put("Jid", c);
                } else
                if (s.equals("DisplayName"))
                {
                    contentvalues.put("DisplayName", h);
                } else
                if (s.equals("Avatar"))
                {
                    contentvalues.put("Avatar", b);
                } else
                if (s.equals("IsBlocked"))
                {
                    contentvalues.put("IsBlocked", Boolean.valueOf(d));
                }
            }
        } while (true);
        return contentvalues;
    }

    public void a(String s)
    {
        h = s;
    }

    public boolean a()
    {
        return a != 0L;
    }

    public ContentValues b(String s)
    {
        if (s == null || s.isEmpty())
        {
            return new ContentValues();
        } else
        {
            ArrayList arraylist = new ArrayList();
            arraylist.add(s);
            return a(arraylist);
        }
    }

    public String b()
    {
        return h;
    }

    public ContentValues c()
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("_id", Long.valueOf(g));
        contentvalues.put("UserId", Long.valueOf(a));
        contentvalues.put("Jid", c);
        contentvalues.put("DisplayName", h);
        contentvalues.put("Avatar", b);
        contentvalues.put("IsBlocked", Boolean.valueOf(d));
        return contentvalues;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null)
            {
                return false;
            }
            if (getClass() != obj.getClass())
            {
                return false;
            }
            obj = (Friend)obj;
            if (a != ((Friend) (obj)).a)
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        return (int)(a ^ a >>> 32) + 31;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeLong(a);
        parcel.writeString(h);
        parcel.writeString(b);
        parcel.writeString(c);
        if (d)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeByte((byte)i);
    }

}
