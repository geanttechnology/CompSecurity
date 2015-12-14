// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.database;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Group
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public Group a(Parcel parcel)
        {
            return new Group(parcel);
        }

        public Group[] a(int i1)
        {
            return new Group[i1];
        }

        public Object createFromParcel(Parcel parcel)
        {
            return a(parcel);
        }

        public Object[] newArray(int i1)
        {
            return a(i1);
        }

    };
    public static List a = Arrays.asList(new String[] {
        "GroupId", "DisplayName", "LastModified", "isDisabled", "GroupType", "Avatar", "isNotificationDisabled", "Jid", "NumberOfMember"
    });
    public long b;
    public String c;
    public String d;
    public String e;
    public String f;
    public long g;
    public Long h;
    public boolean i;
    public boolean j;
    public long k;
    public int l;
    public long m;
    public long n;
    public String o;
    public String p;
    public String q;
    private long r;

    public Group()
    {
        e = "";
        f = "";
        b = -1L;
        g = 0L;
        c = "";
        d = "";
        g = 0L;
        h = Long.valueOf(0L);
        k = 0L;
        i = false;
        j = false;
        l = 0;
        m = 0L;
        n = 0L;
        o = "";
        p = "";
    }

    public Group(long l1, long l2, String s, String s1, String s2, 
            String s3, long l3, int i1, long l4, boolean flag, 
            boolean flag1, int j1, long l5, long l6, String s4, 
            String s5)
    {
        r = l1;
        b = l2;
        e = s;
        f = s1;
        c = s2;
        d = s3;
        h = Long.valueOf(l3);
        g = i1;
        i = flag;
        j = flag1;
        k = l4;
        l = j1;
        m = l5;
        n = l6;
        s = s4;
        if (s4 == null)
        {
            s = "";
        }
        o = s;
        p = s5;
    }

    public Group(long l1, long l2, String s, String s1, String s2, 
            String s3, long l3, int i1, long l4, boolean flag, 
            boolean flag1, int j1, long l5, String s4, String s5)
    {
        r = l1;
        b = l2;
        e = s;
        f = s1;
        c = s2;
        d = s3;
        h = Long.valueOf(l3);
        g = i1;
        i = flag;
        j = flag1;
        k = l4;
        l = j1;
        m = l5;
        n = 0L;
        s = s4;
        if (s4 == null)
        {
            s = "";
        }
        o = s;
        p = s5;
    }

    public Group(Parcel parcel)
    {
        boolean flag1 = false;
        super();
        e = parcel.readString();
        f = parcel.readString();
        b = parcel.readLong();
        g = parcel.readLong();
        c = parcel.readString();
        d = parcel.readString();
        h = Long.valueOf(parcel.readLong());
        k = parcel.readLong();
        boolean flag;
        if (parcel.readByte() == 0)
        {
            flag = false;
        } else
        {
            flag = true;
        }
        i = flag;
        if (parcel.readByte() == 0)
        {
            flag = flag1;
        } else
        {
            flag = true;
        }
        j = flag;
        l = parcel.readInt();
        m = parcel.readLong();
        n = parcel.readLong();
        o = parcel.readString();
        p = parcel.readString();
    }

    public static boolean a(String s)
    {
        return s.equals("Circle");
    }

    public ContentValues a()
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("_id", Long.valueOf(r));
        contentvalues.put("GroupId", Long.valueOf(b));
        contentvalues.put("GroupType", e);
        contentvalues.put("DisplayName", f);
        contentvalues.put("LastModified", h);
        contentvalues.put("Jid", c);
        contentvalues.put("Avatar", d);
        contentvalues.put("NumberOfMember", Long.valueOf(g));
        contentvalues.put("LastRead", Long.valueOf(k));
        contentvalues.put("isDisabled", Boolean.valueOf(i));
        contentvalues.put("isNotificationDisabled", Boolean.valueOf(j));
        contentvalues.put("LastDeleteChatTime", Long.valueOf(m));
        contentvalues.put("DraftText", o);
        contentvalues.put("LastMsg", p);
        return contentvalues;
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
                if (s.equals("GroupId"))
                {
                    contentvalues.put("GroupId", Long.valueOf(b));
                } else
                if (s.equals("GroupType"))
                {
                    contentvalues.put("GroupType", e);
                } else
                if (s.equals("DisplayName"))
                {
                    contentvalues.put("DisplayName", f);
                } else
                if (s.equals("LastModified"))
                {
                    contentvalues.put("LastModified", h);
                } else
                if (s.equals("Jid"))
                {
                    contentvalues.put("Jid", c);
                } else
                if (s.equals("Avatar"))
                {
                    contentvalues.put("Avatar", d);
                } else
                if (s.equals("NumberOfMember"))
                {
                    contentvalues.put("NumberOfMember", Long.valueOf(g));
                } else
                if (s.equals("LastRead"))
                {
                    contentvalues.put("LastRead", Long.valueOf(k));
                } else
                if (s.equals("isDisabled"))
                {
                    contentvalues.put("isDisabled", Boolean.valueOf(i));
                } else
                if (s.equals("isNotificationDisabled"))
                {
                    contentvalues.put("isNotificationDisabled", Boolean.valueOf(j));
                } else
                if (s.equals("LastDeleteChatTime"))
                {
                    contentvalues.put("LastDeleteChatTime", Long.valueOf(m));
                } else
                if (s.equals("DraftText"))
                {
                    contentvalues.put("DraftText", o);
                } else
                if (s.equals("LastMsg"))
                {
                    contentvalues.put("LastMsg", p);
                }
            }
        } while (true);
        return contentvalues;
    }

    public void a(Group group)
    {
        if (b == group.b)
        {
            b = group.b;
            c = group.c;
            d = group.d;
            e = group.e;
            f = group.f;
            g = group.g;
            h = group.h;
            i = group.i;
            j = group.j;
        }
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

    public void b(Group group)
    {
        d = group.d;
        f = group.f;
        b = group.b;
        e = group.e;
        r = group.r;
        c = group.c;
        h = group.h;
        k = group.k;
        i = group.i;
        j = group.j;
        l = group.l;
        m = group.m;
        if (group.n > n)
        {
            n = group.n;
        }
        o = group.o;
        if (group.p != null && !group.p.isEmpty())
        {
            p = group.p;
        }
    }

    public void c(String s)
    {
        f = s;
    }

    public int describeContents()
    {
        return 0;
    }

    public String toString()
    {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append("{").append("\n");
        stringbuffer.append((new StringBuilder()).append("  group.avatar: ").append(d).toString()).append("\n");
        stringbuffer.append((new StringBuilder()).append("  group.displayName: ").append(f).toString()).append("\n");
        stringbuffer.append((new StringBuilder()).append("  group.groupId: ").append(b).toString()).append("\n");
        stringbuffer.append((new StringBuilder()).append("  group.groupType: ").append(e).toString()).append("\n");
        stringbuffer.append((new StringBuilder()).append("  group.jid: ").append(c).toString()).append("\n");
        stringbuffer.append((new StringBuilder()).append("  group.lastRead: ").append((new Date(k)).toString()).toString()).append("\n");
        stringbuffer.append((new StringBuilder()).append("  group.numberOfMember: ").append(g).toString()).append("\n");
        stringbuffer.append((new StringBuilder()).append("  group.isDisabled: ").append(String.valueOf(i)).toString()).append("\n");
        stringbuffer.append((new StringBuilder()).append("  group.isNotificationDisabled: ").append(String.valueOf(j)).toString()).append("\n");
        stringbuffer.append((new StringBuilder()).append("  group.unread: ").append(String.valueOf(l)).toString()).append("\n");
        stringbuffer.append((new StringBuilder()).append("  group.lastMessateTime: ").append((new Date(m)).toString()).toString()).append("\n");
        stringbuffer.append((new StringBuilder()).append("  group.lastSendingTime: ").append((new Date(n)).toString()).toString()).append("\n");
        stringbuffer.append((new StringBuilder()).append("  group.draftText: ").append(o).toString()).append("\n");
        stringbuffer.append((new StringBuilder()).append("  group.lastMsg: ").append(p).toString()).append("\n");
        stringbuffer.append("}");
        return stringbuffer.toString();
    }

    public void writeToParcel(Parcel parcel, int i1)
    {
        boolean flag = true;
        parcel.writeString(e);
        parcel.writeString(f);
        parcel.writeLong(b);
        parcel.writeLong(g);
        parcel.writeString(c);
        parcel.writeString(d);
        parcel.writeLong(h.longValue());
        parcel.writeLong(k);
        if (i)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        parcel.writeByte((byte)i1);
        if (j)
        {
            i1 = ((flag) ? 1 : 0);
        } else
        {
            i1 = 0;
        }
        parcel.writeByte((byte)i1);
        parcel.writeInt(l);
        parcel.writeLong(m);
        parcel.writeLong(n);
        parcel.writeString(o);
        parcel.writeString(p);
    }

}
