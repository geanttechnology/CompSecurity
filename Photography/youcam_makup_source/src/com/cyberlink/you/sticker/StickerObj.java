// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.sticker;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;
import com.cyberlink.you.database.l;
import com.cyberlink.you.e;
import com.cyberlink.you.utility.d;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class StickerObj
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public StickerObj a(Parcel parcel)
        {
            return new StickerObj(parcel);
        }

        public StickerObj[] a(int i1)
        {
            return new StickerObj[i1];
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
    protected long a;
    private long b;
    private long c;
    private long d;
    private Date e;
    private String f;
    private String g;
    private String h;
    private String i;
    private int j;
    private int k;
    private List l;
    private int m;

    public StickerObj(long l1, long l2, long l3, long l4, long l5, String s, String s1, int i1, int j1)
    {
        this(l1, l2, l3, l4, l5, s, s1, i1, j1, "", 0);
    }

    public StickerObj(long l1, long l2, long l3, long l4, long l5, String s, String s1, int i1, int j1, 
            String s2, int k1)
    {
        a = l1;
        b = l2;
        c = l3;
        d = l4;
        e = new Date(l5);
        f = s;
        h = s1;
        g = "_";
        i = "_";
        j = i1;
        k = j1;
        c(s2);
        m = k1;
    }

    public StickerObj(long l1, long l2, long l3, long l4, long l5, String s, String s1, String s2, String s3, 
            int i1, int j1, String s4, int k1)
    {
        a = l1;
        b = l2;
        c = l3;
        d = l4;
        e = new Date(l5);
        f = s;
        g = s1;
        h = s2;
        i = s3;
        j = i1;
        k = j1;
        c(s4);
        m = k1;
    }

    public StickerObj(Parcel parcel)
    {
        b = parcel.readLong();
        c = parcel.readLong();
        d = parcel.readLong();
        e = new Date(parcel.readLong());
        f = parcel.readString();
        g = parcel.readString();
        h = parcel.readString();
        i = parcel.readString();
        j = parcel.readInt();
        k = parcel.readInt();
    }

    private void c(String s)
    {
        if (!s.isEmpty())
        {
            l = new ArrayList();
            s = s.split(",");
            int j1 = s.length;
            int i1 = 0;
            while (i1 < j1) 
            {
                Object obj = s[i1];
                l.add(obj);
                i1++;
            }
        }
    }

    public long a()
    {
        return a;
    }

    public void a(int i1)
    {
        j = i1;
    }

    public void a(String s)
    {
        g = s;
    }

    public long b()
    {
        return b;
    }

    public void b(int i1)
    {
        k = i1;
    }

    public void b(String s)
    {
        i = s;
    }

    public long c()
    {
        return c;
    }

    public long d()
    {
        return d;
    }

    public int describeContents()
    {
        return 0;
    }

    public Date e()
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

    public String h()
    {
        return h;
    }

    public String i()
    {
        return i;
    }

    public int j()
    {
        return j;
    }

    public int k()
    {
        return k;
    }

    public void l()
    {
        if (l != null) goto _L2; else goto _L1
_L1:
        Object obj;
        obj = (new StringBuilder()).append(com.cyberlink.you.utility.d.a(c)).append(File.separator).toString();
        obj = (new StringBuilder()).append(((String) (obj))).append(String.valueOf(b)).toString();
        obj = com.cyberlink.you.utility.d.f((new StringBuilder()).append(((String) (obj))).append(File.separator).append("info.json").toString());
        if (obj == null) goto _L4; else goto _L3
_L3:
        l = new ArrayList();
        JSONObject jsonobject = new JSONObject(((String) (obj)));
        obj = jsonobject.getJSONArray("images");
        m = (int)Math.round(jsonobject.getDouble("duration") * 1000D) / ((JSONArray) (obj)).length();
        int i1 = 0;
_L7:
        int j1 = ((JSONArray) (obj)).length();
        if (i1 >= j1) goto _L6; else goto _L5
_L5:
        l.add(((JSONArray) (obj)).getString(i1));
_L8:
        i1++;
          goto _L7
        JSONException jsonexception1;
        jsonexception1;
        JSONException jsonexception;
        jsonexception1.printStackTrace();
          goto _L8
_L2:
        return;
_L6:
        try
        {
            com.cyberlink.you.e.h().a(b, this);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (JSONException jsonexception)
        {
            jsonexception.printStackTrace();
        }
        if (true) goto _L2; else goto _L4
_L4:
        m = 0;
        return;
    }

    public String m()
    {
        if (l != null && !l.isEmpty())
        {
            StringBuilder stringbuilder = new StringBuilder();
            String s;
            for (Iterator iterator = l.iterator(); iterator.hasNext(); stringbuilder.append((new StringBuilder()).append(s).append(",").toString()))
            {
                s = (String)iterator.next();
            }

            return stringbuilder.substring(0, stringbuilder.length() - 1).toString();
        } else
        {
            return "";
        }
    }

    public List n()
    {
        return l;
    }

    public int o()
    {
        return m;
    }

    public ContentValues p()
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("_id", Long.valueOf(a()));
        contentvalues.put("StickerId", Long.valueOf(b()));
        contentvalues.put("PackId", Long.valueOf(c()));
        contentvalues.put("StickerOrder", Long.valueOf(d()));
        contentvalues.put("LastModified", Long.valueOf(e().getTime()));
        contentvalues.put("OriginalURL", f());
        contentvalues.put("OriginalLocalFilePath", g());
        contentvalues.put("ThumbnailURL", h());
        contentvalues.put("ThumbnailLocalFilePath", i());
        contentvalues.put("Height", Integer.valueOf(k()));
        contentvalues.put("Width", Integer.valueOf(j()));
        contentvalues.put("AnimPngFilename", m());
        contentvalues.put("Duration", Integer.valueOf(o()));
        return contentvalues;
    }

    public String toString()
    {
        String s = super.toString();
        return (new StringBuilder()).append("ID: ").append(a).append(", ").append(s).toString();
    }

    public void writeToParcel(Parcel parcel, int i1)
    {
        parcel.writeLong(b);
        parcel.writeLong(c);
        parcel.writeLong(d);
        long l1;
        if (e == null)
        {
            l1 = 0L;
        } else
        {
            l1 = e.getTime();
        }
        parcel.writeLong(l1);
        parcel.writeString(f);
        parcel.writeString(g);
        parcel.writeString(h);
        parcel.writeString(i);
        parcel.writeInt(j);
        parcel.writeInt(k);
    }

}
