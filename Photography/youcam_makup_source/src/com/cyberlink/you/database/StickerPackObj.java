// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.database;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.cyberlink.you.database:
//            n

public class StickerPackObj
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public StickerPackObj a(Parcel parcel)
        {
            return new StickerPackObj(parcel);
        }

        public StickerPackObj[] a(int i1)
        {
            return new StickerPackObj[i1];
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
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private n h;
    private Date i;
    private Status j;
    private long k;
    private String l;
    private String m;
    private String n;
    private boolean o;
    private String p;
    private FunctionType q;

    public StickerPackObj(long l1, long l2, String s1, String s2, String s3, 
            String s4, String s5, n n1, Status status, long l3, long l4, String s6, String s7, String s8, boolean flag, String s9)
    {
        q = FunctionType.a;
        a = l1;
        b = l2;
        c = s1;
        d = s2;
        i = new Date(l3);
        f = s4;
        g = s5;
        h = n1;
        j = status;
        e = s3;
        k = l4;
        l = s6;
        m = s7;
        n = s8;
        o = flag;
        p = s9;
    }

    public StickerPackObj(long l1, long l2, String s1, String s2, String s3, 
            String s4, String s5, String s6, Status status, long l3, long l4, String s7, String s8, String s9, boolean flag, String s10)
    {
        this(l1, l2, s1, s2, s3, s4, s5, com.cyberlink.you.database.n.a(s6), status, l3, l4, s7, s8, s9, flag, s10);
    }

    public StickerPackObj(Parcel parcel)
    {
        q = FunctionType.a;
        a = parcel.readLong();
        b = parcel.readLong();
        c = parcel.readString();
        d = parcel.readString();
        i = new Date(parcel.readLong());
        f = parcel.readString();
        g = parcel.readString();
        h = com.cyberlink.you.database.n.a(parcel.readString());
        j = Status.valueOf(parcel.readString());
        e = parcel.readString();
        k = parcel.readLong();
        l = parcel.readString();
        m = parcel.readString();
        n = parcel.readString();
        boolean flag;
        if (parcel.readByte() == 0)
        {
            flag = false;
        } else
        {
            flag = true;
        }
        o = flag;
        p = parcel.readString();
    }

    public StickerPackObj(JSONObject jsonobject)
    {
        q = FunctionType.a;
        try
        {
            a = jsonobject.getLong("id");
            b = jsonobject.getLong("packId");
            c = jsonobject.getString("packType");
            d = jsonobject.getString("purchaseType");
            e = jsonobject.getString("packName");
            f = jsonobject.getString("description");
            g = jsonobject.getString("expiration");
            h = new n(new JSONObject(jsonobject.getString("url")));
            i = new Date(jsonobject.getLong("lastModified"));
            j = Status.valueOf(jsonobject.getString("status"));
            k = jsonobject.getLong("publishLastModified");
            l = jsonobject.getString("publisherName");
            m = jsonobject.getString("publisherTitleOfUrl");
            n = jsonobject.getString("publisherUrl");
            o = jsonobject.getBoolean("isShowed");
            p = jsonobject.getString("iapItem");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            jsonobject.printStackTrace();
        }
    }

    public long a()
    {
        return a;
    }

    public void a(FunctionType functiontype)
    {
        q = functiontype;
    }

    public void a(Status status)
    {
        j = status;
    }

    public long b()
    {
        return b;
    }

    public String c()
    {
        return p;
    }

    public String d()
    {
        return c;
    }

    public int describeContents()
    {
        return 0;
    }

    public String e()
    {
        return d;
    }

    public String f()
    {
        return e;
    }

    public String g()
    {
        return f;
    }

    public String h()
    {
        return g;
    }

    public n i()
    {
        return h;
    }

    public Status j()
    {
        return j;
    }

    public Date k()
    {
        return i;
    }

    public long l()
    {
        return k;
    }

    public String m()
    {
        return l;
    }

    public String n()
    {
        return m;
    }

    public String o()
    {
        return n;
    }

    public boolean p()
    {
        return !j().equals(Status.a);
    }

    public boolean q()
    {
        return o;
    }

    public FunctionType r()
    {
        return q;
    }

    public ContentValues s()
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("_id", Long.valueOf(a()));
        contentvalues.put("PackId", Long.valueOf(b()));
        contentvalues.put("PackType", d());
        contentvalues.put("PurchaseType", e());
        contentvalues.put("PackName", f());
        contentvalues.put("Description", g());
        contentvalues.put("Expiration", h());
        contentvalues.put("Url", i().toString());
        contentvalues.put("Status", j().toString());
        contentvalues.put("LastModified", Long.valueOf(k().getTime()));
        contentvalues.put("PublisherLastModified", Long.valueOf(l()));
        contentvalues.put("PublisherName", m());
        contentvalues.put("PublisherTitleOfUrl", n());
        contentvalues.put("PublisherUrl", o());
        contentvalues.put("isShowed", Boolean.valueOf(q()));
        contentvalues.put("iapItem", c());
        return contentvalues;
    }

    public String t()
    {
        Object obj = new JSONObject();
        try
        {
            ((JSONObject) (obj)).put("id", a);
            ((JSONObject) (obj)).put("packId", b);
            ((JSONObject) (obj)).put("packType", c);
            ((JSONObject) (obj)).put("purchaseType", d);
            ((JSONObject) (obj)).put("packName", e);
            ((JSONObject) (obj)).put("description", f);
            ((JSONObject) (obj)).put("expiration", g);
            ((JSONObject) (obj)).put("url", h.a());
            ((JSONObject) (obj)).put("lastModified", i.getTime());
            ((JSONObject) (obj)).put("status", j.toString());
            ((JSONObject) (obj)).put("publishLastModified", k);
            ((JSONObject) (obj)).put("publisherName", l);
            ((JSONObject) (obj)).put("publisherTitleOfUrl", m);
            ((JSONObject) (obj)).put("publisherUrl", n);
            ((JSONObject) (obj)).put("isShowed", o);
            ((JSONObject) (obj)).put("iapItem", p);
            obj = ((JSONObject) (obj)).toString();
        }
        catch (JSONException jsonexception)
        {
            jsonexception.printStackTrace();
            return "";
        }
        return ((String) (obj));
    }

    public String toString()
    {
        String s1 = super.toString();
        return (new StringBuilder()).append("ID: ").append(a).append(", ").append(s1).toString();
    }

    public void writeToParcel(Parcel parcel, int i1)
    {
        parcel.writeLong(a);
        parcel.writeLong(b);
        parcel.writeString(c);
        parcel.writeString(d);
        parcel.writeLong(i.getTime());
        parcel.writeString(f);
        parcel.writeString(g);
        parcel.writeString(h.toString());
        parcel.writeString(j.toString());
        parcel.writeString(e);
        parcel.writeLong(k);
        parcel.writeString(l);
        parcel.writeString(m);
        parcel.writeString(n);
        if (o)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        parcel.writeByte((byte)i1);
        parcel.writeString(p);
    }


    private class FunctionType extends Enum
    {

        public static final FunctionType a;
        public static final FunctionType b;
        public static final FunctionType c;
        private static final FunctionType d[];

        public static FunctionType valueOf(String s1)
        {
            return (FunctionType)Enum.valueOf(com/cyberlink/you/database/StickerPackObj$FunctionType, s1);
        }

        public static FunctionType[] values()
        {
            return (FunctionType[])d.clone();
        }

        static 
        {
            a = new FunctionType("STICKER", 0);
            b = new FunctionType("EMOJI", 1);
            c = new FunctionType("SETTING", 2);
            d = (new FunctionType[] {
                a, b, c
            });
        }

        private FunctionType(String s1, int i1)
        {
            super(s1, i1);
        }
    }


    private class Status extends Enum
    {

        public static final Status a;
        public static final Status b;
        public static final Status c;
        private static final Status d[];

        public static Status valueOf(String s1)
        {
            return (Status)Enum.valueOf(com/cyberlink/you/database/StickerPackObj$Status, s1);
        }

        public static Status[] values()
        {
            return (Status[])d.clone();
        }

        static 
        {
            a = new Status("NONE", 0);
            b = new Status("BUILTIN", 1);
            c = new Status("DOWNLOADED", 2);
            d = (new Status[] {
                a, b, c
            });
        }

        private Status(String s1, int i1)
        {
            super(s1, i1);
        }
    }

}
