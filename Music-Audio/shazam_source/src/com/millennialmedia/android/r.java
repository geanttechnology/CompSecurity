// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import android.os.Parcel;
import java.io.Externalizable;
import java.io.File;
import java.io.FileFilter;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

// Referenced classes of package com.millennialmedia.android:
//            an, al, VideoAd, a, 
//            ab

abstract class r
    implements Externalizable
{

    String a;
    String b;
    Date c;
    long d;
    String e;
    int f;
    boolean g;

    r()
    {
        g = false;
        d = System.currentTimeMillis();
    }

    protected r(Parcel parcel)
    {
        g = false;
        try
        {
            a = parcel.readString();
            b = parcel.readString();
            c = (Date)parcel.readSerializable();
            d = parcel.readLong();
            boolean aflag[] = new boolean[1];
            parcel.readBooleanArray(aflag);
            g = aflag[0];
            e = parcel.readString();
            f = parcel.readInt();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Parcel parcel)
        {
            parcel.printStackTrace();
        }
    }

    static r a(String s)
    {
        if (an.a < 5) goto _L2; else goto _L1
_L1:
        int l;
        al.a();
        l = s.length();
        if (l <= 1000) goto _L4; else goto _L3
_L3:
        int i;
        int j;
        i = 999;
        j = 0;
_L7:
        if (i >= l)
        {
            break MISSING_BLOCK_LABEL_102;
        }
        s.substring(j, i);
        al.a();
        j = i + 1000;
        if (j <= l) goto _L6; else goto _L5
_L5:
        int k;
        k = l - 1;
        j = i;
_L8:
        s.substring(j, k);
_L4:
        al.a();
_L2:
        if (s.length() > 0)
        {
            return new VideoAd(s);
        } else
        {
            return null;
        }
_L6:
        k = i;
        i = j;
        j = k;
          goto _L7
        k = i;
          goto _L8
    }

    static String a(r r1)
    {
        return r1.a;
    }

    abstract void a(Context context, long l);

    protected void a(JSONObject jsonobject)
    {
        SimpleDateFormat simpledateformat;
        a = jsonobject.optString("id", null);
        b = jsonobject.optString("vid", null);
        e = jsonobject.optString("content-url", null);
        jsonobject = jsonobject.optString("expiration", null);
        if (jsonobject == null)
        {
            break MISSING_BLOCK_LABEL_64;
        }
        simpledateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ZZZZ");
        c = simpledateformat.parse(jsonobject);
        return;
        jsonobject;
        al.a("CachedAd", "Exception deserializing cached ad: ", jsonobject);
        return;
    }

    final boolean a()
    {
        return c != null && c.getTime() <= System.currentTimeMillis();
    }

    abstract boolean a(Context context);

    abstract boolean a(Context context, ab ab, boolean flag);

    void b(Context context)
    {
        int i;
        i = 0;
        context = com.millennialmedia.android.a.f(context);
        if (context == null || !context.isDirectory())
        {
            break MISSING_BLOCK_LABEL_88;
        }
        context = context.listFiles(new FileFilter() {

            final r a;

            public final boolean accept(File file)
            {
                return file.isFile() && file.getName().startsWith(r.a(a));
            }

            
            {
                a = r.this;
                super();
            }
        });
        String.format("Deleting %d files for %s.", new Object[] {
            Integer.valueOf(context.length), a
        });
        al.a();
_L1:
        if (i >= context.length)
        {
            break MISSING_BLOCK_LABEL_88;
        }
        context[i].delete();
        i++;
          goto _L1
        context;
        al.a("CachedAd", "Exception deleting cached ad: ", context);
    }

    final boolean b()
    {
        return a != null && a.length() > 0 && e != null && e.length() > 0;
    }

    abstract int c();

    abstract boolean c(Context context);

    abstract String d();

    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (!(obj instanceof r))
        {
            return false;
        } else
        {
            obj = (r)obj;
            return a.equals(((r) (obj)).a);
        }
    }

    public void readExternal(ObjectInput objectinput)
    {
        a = (String)objectinput.readObject();
        b = (String)objectinput.readObject();
        c = (Date)objectinput.readObject();
        d = objectinput.readLong();
        e = (String)objectinput.readObject();
    }

    public void writeExternal(ObjectOutput objectoutput)
    {
        objectoutput.writeObject(a);
        objectoutput.writeObject(b);
        objectoutput.writeObject(c);
        objectoutput.writeLong(d);
        objectoutput.writeObject(e);
    }

    protected void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(a);
        parcel.writeString(b);
        parcel.writeSerializable(c);
        parcel.writeLong(d);
        parcel.writeBooleanArray(new boolean[] {
            g
        });
        parcel.writeString(e);
        parcel.writeInt(f);
    }
}
