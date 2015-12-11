// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.content;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import org.json.JSONArray;

// Referenced classes of package com.wishabi.flipp.content:
//            j

public class <init>
    implements Parcelable
{

    public static final android.os.reator CREATOR = new j();
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public boolean e;
    public final String f;
    public final String g;
    public final String h;
    public final Float i;
    public final Float j;
    public final String k;
    public final String l;
    public final String m;
    public final boolean n;
    public final String o;
    public final boolean p;
    public float q[];
    private final String r;
    private final String s;

    public int describeContents()
    {
        return 0;
    }

    public String toString()
    {
        return (new StringBuilder()).append(getClass().getName()).append("[flyerId=").append(a).append(", flyerRunId=").append(b).append(", flyerTypeId=").append(c).append(", merchantId=").append(d).append(", premium=").append(e).append(", flyerName=").append(r).append(", postalCode=").append(f).append(", merchantName=").append(g).append(", merchantLogo=").append(h).append(", width=").append(i).append(", height=").append(j).append(", path=").append(k).append(", thumbnail=").append(s).append(", validFrom=").append(l).append(", validTo=").append(m).append(", webIndexed=").append(n).append(", analyticsPayload=").append(o).append(", isStoreSelect=").append(p).append(", resolutions=").append(Arrays.toString(q)).append("]").toString();
    }

    public void writeToParcel(Parcel parcel, int i1)
    {
        boolean flag = true;
        parcel.writeInt(a);
        parcel.writeInt(b);
        parcel.writeInt(c);
        parcel.writeInt(d);
        if (e)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        parcel.writeInt(i1);
        parcel.writeString(r);
        parcel.writeString(f);
        parcel.writeString(g);
        parcel.writeString(h);
        parcel.writeFloat(i.floatValue());
        parcel.writeFloat(j.floatValue());
        parcel.writeString(k);
        parcel.writeString(s);
        parcel.writeString(l);
        parcel.writeString(m);
        if (n)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        parcel.writeInt(i1);
        parcel.writeString(o);
        if (p)
        {
            i1 = ((flag) ? 1 : 0);
        } else
        {
            i1 = 0;
        }
        parcel.writeInt(i1);
        parcel.writeFloatArray(q);
    }


    public (Cursor cursor)
    {
        int i1 = 0;
        boolean flag1 = true;
        super();
        a = cursor.getInt(cursor.getColumnIndexOrThrow("flyer_id"));
        b = cursor.getInt(cursor.getColumnIndexOrThrow("flyer_run_id"));
        c = cursor.getInt(cursor.getColumnIndexOrThrow("flyer_type_id"));
        d = cursor.getInt(cursor.getColumnIndexOrThrow("merchant_id"));
        boolean flag;
        if (cursor.getInt(cursor.getColumnIndexOrThrow("premium")) == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        e = flag;
        r = cursor.getString(cursor.getColumnIndex("name"));
        f = cursor.getString(cursor.getColumnIndexOrThrow("postal_code"));
        g = cursor.getString(cursor.getColumnIndexOrThrow("merchant"));
        h = cursor.getString(cursor.getColumnIndexOrThrow("merchant_logo"));
        i = Float.valueOf(cursor.getFloat(cursor.getColumnIndexOrThrow("width")));
        j = Float.valueOf(cursor.getFloat(cursor.getColumnIndexOrThrow("height")));
        k = cursor.getString(cursor.getColumnIndexOrThrow("path"));
        s = cursor.getString(cursor.getColumnIndex("thumbnail"));
        l = cursor.getString(cursor.getColumnIndexOrThrow("valid_from"));
        m = cursor.getString(cursor.getColumnIndexOrThrow("valid_to"));
        if (cursor.getInt(cursor.getColumnIndexOrThrow("web_indexed")) == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        n = flag;
        o = cursor.getString(cursor.getColumnIndexOrThrow("analytics_payload"));
        if (cursor.getInt(cursor.getColumnIndexOrThrow("store_select")) == 1)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        p = flag;
        cursor = new JSONArray(cursor.getString(cursor.getColumnIndexOrThrow("resolutions")));
        q = new float[cursor.length()];
_L1:
        if (i1 >= cursor.length())
        {
            break MISSING_BLOCK_LABEL_453;
        }
        q[i1] = (float)cursor.getDouble(i1);
        i1++;
          goto _L1
        cursor;
        (new StringBuilder("Exception creating intent: ")).append(cursor.toString());
    }

    private q(Parcel parcel)
    {
        boolean flag1 = true;
        super();
        a = parcel.readInt();
        b = parcel.readInt();
        c = parcel.readInt();
        d = parcel.readInt();
        boolean flag;
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        e = flag;
        r = parcel.readString();
        f = parcel.readString();
        g = parcel.readString();
        h = parcel.readString();
        i = Float.valueOf(parcel.readFloat());
        j = Float.valueOf(parcel.readFloat());
        k = parcel.readString();
        s = parcel.readString();
        l = parcel.readString();
        m = parcel.readString();
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        n = flag;
        o = parcel.readString();
        if (parcel.readInt() == 1)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        p = flag;
        q = parcel.createFloatArray();
    }

    q(Parcel parcel, byte byte0)
    {
        this(parcel);
    }
}
